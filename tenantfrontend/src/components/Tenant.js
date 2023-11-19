import { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';


export default function Tenant() {

    const paperstyle={padding: "50px 20px", width:600, margin:"20px auto"}     
    const[name, setName] = useState('')
    const[address, setAddress] = useState('')
    const[tenants, setTenants] = useState([])


    const handleClick=(e) => {
        e.preventDefault()
        const tenant={name,address}
        console.log(tenant)
        fetch("http://localhost:8080/tenant/add",{
            method:"POST",
            headers:{"Content-type":"application/json"},
            body:JSON.stringify(tenant)
        }).then(()=>{
            console.log("New tenant added")
        })
    }

    useEffect(() => {
        fetch("http://localhost:8080/tenant/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setTenants(result);
        }
    )
    }, [])
    return (
    <>
        <Container>
            <Paper elevation={3} style={paperstyle}>
                <h1 style={{color: "blue"}}><u>Add Tenant</u></h1>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <TextField id="outlined-basic" label="Tenant Name" variant="outlined" fullWidth 
                    value={name}
                    onChange={(e) => setName(e.target.value)}/>
                    <TextField id="outlined-basic" label="Tenant Address" variant="outlined" fullWidth
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                    />
                    <Button variant="contained" onClick={handleClick}>Submit</Button>
                </Box>
            </Paper>

            <h1>Tenant</h1>
            <Paper elevation={3} style={paperstyle}>
                {tenants.map(tenant=>(
                    <Paper elevation={6} style={{margin:"10px", padding:"15px", textAlign:"left"}} key={tenant.id}>
                        ID: {tenant.id}<br/>
                        Name: {tenant.name}<br/>
                        Address: {tenant.address}
                    </Paper>
                ))}    
            </Paper>
        </Container>
    </>
  );
}
