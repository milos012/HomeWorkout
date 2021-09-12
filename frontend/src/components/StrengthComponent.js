import React, {Component} from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import Alert from '@material-ui/lab/Alert';
import { Paper } from '@material-ui/core';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import Checkbox from '@material-ui/core/Checkbox';
import FormGroup from '@material-ui/core/FormGroup';
import SportsIcon from '@material-ui/icons/Sports';
import axios from 'axios';

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

  class ChooseStrength extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            muscleGroup: ''
         }
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        axios.post('/api/user/generateStr',this.state.muscleGroup).then(response=>
        {
            console.log(response)
        })
        .catch(error =>{
            console.log(error)
        })
    }

      render() { 
        const {muscleGroup} = this.state
          return (
            <Grid>
                <Paper elevation={20} style={paperStyle}>
                    <Grid align='center'>
                        <Avatar style={avatarStyle}>
                            <SportsIcon/>
                        </Avatar>
                        <h2 style={headerStyle}>Choose muscle group</h2>
                    </Grid>
                    <form onSubmit={this.submitHandler}>
                        <FormControl component="fieldset" style={marginTop} required>
                            <FormLabel component="legend">Muscle groups</FormLabel>
                            <RadioGroup aria-label="muscleGroup" name="muscleGroup" style={{display:'initial'}} value={muscleGroup} onChange={this.changeHandler}>
                                <FormControlLabel value="ARMS" control={<Radio />} label="Arms" />
                                <FormControlLabel value="BACK" control={<Radio />} label="Back" />
                                <FormControlLabel value="CHEST" control={<Radio />} label="Chest" />
                                <FormControlLabel value="SHOULDERS" control={<Radio />} label="Shoulders" />
                                <FormControlLabel value="ABS" control={<Radio />} label="Abs" />
                                <FormControlLabel value="LEGS" control={<Radio />} label="Legs" />
                            </RadioGroup>
                        </FormControl>
                        <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        >
                            submit
                        </Button>
                    </form>
                </Paper>
            </Grid>
            );
      }
  }
   
  export default ChooseStrength;