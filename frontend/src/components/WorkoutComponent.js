import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import Alert from '@material-ui/lab/Alert';
import { Paper } from '@material-ui/core';

const paperStyle={padding: "30px 50px",width:370,margin:"20px auto"}
const avatarStyle={backgroundColor: "#1bbd7e"}
const headerStyle={margin:0}
const marginTop={marginTop:5}

function AlertSucc() {
    const [open, setOpen] = React.useState(true);
    return (
      //Popup.alert('You pressed the Save btn')
      <Alert
      >
        Close me!
      </Alert>
    );
  }

  const WorkoutGenerator=()=>{
      return(
        <Grid>
            <Paper elevation={20} style={paperStyle}>
                <Grid align='center'>
                    <h2 style={headerStyle}>Generated workout:</h2>
                    TODO
                </Grid>
            </Paper>
        </Grid>
      );
  }

  export default WorkoutGenerator;