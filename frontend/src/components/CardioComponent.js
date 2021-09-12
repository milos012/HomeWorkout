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
import AvTimerIcon from '@material-ui/icons/AvTimer';
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


  class ChooseCardio extends Component {
      constructor(props) {
          super(props);
          this.state = { 
            duration: ''
           }
        }

        changeHandler = e => {
            this.setState({[e.target.name]: e.target.value})
        }

        submitHandler = e => {
            e.preventDefault()
            console.log(this.state)
            // axios.post('/api/user/add',this.state).then(response=>
            // {
            //     console.log(response)
            // })
            // .catch(error =>{
            //     console.log(error)
            // })
        }

      render() { 
        const {duration} = this.state
          return (
            <Grid>
                <Paper elevation={20} style={paperStyle}>
                    <Grid align='center'>
                        <Avatar style={avatarStyle}>
                            <AvTimerIcon/>
                        </Avatar>
                        <h2 style={headerStyle}>Choose cardio duration</h2>
                    </Grid>
                    <form onSubmit={this.submitHandler}>
                        <FormControl component="fieldset" style={marginTop} required>
                            <FormLabel component="legend">Workout duration</FormLabel>
                            <RadioGroup aria-label="Duration" name="duration" style={{display:'initial'}} value={duration} onChange={this.changeHandler}>
                                <FormControlLabel value="10min" control={<Radio />} label="10min" />
                                <FormControlLabel value="20min" control={<Radio />} label="20min" />
                                <FormControlLabel value="30min" control={<Radio />} label="30min" />
                            </RadioGroup>
                        </FormControl>
                        <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        >
                            Submit
                        </Button>
                    </form>
                </Paper>
            </Grid>
            );
      }
  }
   
  export default ChooseCardio;