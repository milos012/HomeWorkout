import React from 'react';
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
import { makeStyles } from '@material-ui/core/styles';
import axios from 'axios';

const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1),
      },
    },
  }));

const Home = () => {
    const classes = useStyles();
    return ( 
        <div className={classes.root}>
            <h2>Homepage</h2>
            <br></br>
            <br></br>
            <Button variant="contained" color="secondary" href="chooseCardio">
            Generate Cardio workout
            </Button>
            
            <Button variant="contained" color="secondary" href="chooseStrength">
            Generate Strength workout
            </Button>
        </div>
     );
}
 
export default Home;