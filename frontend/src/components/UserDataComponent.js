import React, {Component} from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Alert from '@material-ui/lab/Alert';
import { Paper } from '@material-ui/core';
import EditIcon from '@material-ui/icons/Edit';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import Checkbox from '@material-ui/core/Checkbox';
import FormGroup from '@material-ui/core/FormGroup';
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

class UserDataEdit extends Component {
    constructor(props){
        super(props)

        this.state = {
            weight: '',
            height: '',
            pl: '',
            equipment:[]

        }
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    equipmentHandler = e => {
        let lista = this.state.equipment
        lista.push(e.target.name)
        this.setState({equipment: lista})
    }

    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        axios.post('/api/user/add',this.state).then(response=>
        {
            console.log(response)
        })
        .catch(error =>{
            console.log(error)
        })
    }

    render() { 
        const {weight,height,pl,equipment} = this.state
        return (
            <Grid>
            <Paper elevation={20} style={paperStyle}>
                <Grid align='center'>
                    <Avatar style={avatarStyle}>
                        <EditIcon/>
                    </Avatar>
                    <h2 style={headerStyle}>Edit user data</h2>
                </Grid>
                <form onSubmit={this.submitHandler}>
                    <TextField
                        name="weight"
                        variant="outlined"
                        required
                        fullWidth
                        id="weight"
                        label="Weight"
                        autoFocus
                        style={marginTop}
                        value={weight}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        id="height"
                        label="Height"
                        name="height"
                        style={marginTop}
                        value={height}
                        onChange={this.changeHandler}
                    />
                    <FormControl component="fieldset" style={marginTop}>
                        <FormLabel component="legend">Physical level</FormLabel>
                        <RadioGroup aria-label="PhysicalLevel" name="pl" style={{display:'initial'}} value={pl} onChange={this.changeHandler}>
                            <FormControlLabel value="BEGINNER" control={<Radio />} label="Beginner" />
                            <FormControlLabel value="INTERMEDIATE" control={<Radio />} label="Intermediate" />
                            <FormControlLabel value="ADVANCED" control={<Radio />} label="Advanced" />
                        </RadioGroup>
                    </FormControl>
                    <FormLabel component="legend">Equipment</FormLabel>
                    <FormGroup row name="equipment" value={equipment} onChange={this.equipmentHandler}>
                        <FormControlLabel
                        control={<Checkbox name="JUMP_ROPE" />}
                        label="Jump rope"
                        />
                        <FormControlLabel control={<Checkbox name="DUMBBELLS_WITH_PLATES" />} label="Dumbbells with Plates" />
                        <FormControlLabel control={<Checkbox name="BARBELL_WITH_PLATES" />} label="Barbell with Plates" />
                        <FormControlLabel control={<Checkbox name="PULL_UP_BAR" />} label="Pull up bar" />
                        <FormControlLabel control={<Checkbox name="JUMP_BOX" />} label="Jump box" />
                    </FormGroup>
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
 
export default UserDataEdit;