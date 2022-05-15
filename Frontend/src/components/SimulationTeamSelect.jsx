import React, { useState } from "react";
import Box from "@mui/material/Box";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";

const TeamSelect = (props) => {
  const [team1, setTeam1] = useState("");
  const [team2, setTeam2] = useState("");

  const handleChange1 = (event) => {
    setTeam1(event.target.value);
  };
  const handleChange2 = (event) => {
    setTeam2(event.target.value);
  };

  return (
    <div>
      <Box sx={{ minWidth: 120 }}>
        <FormControl fullWidth>
          <InputLabel id="team1">1팀</InputLabel>
          <Select
            labelId="team1"
            id="team1"
            value={team1}
            label="Team1"
            onChange={handleChange1}
          >
            <MenuItem value={10}>Ten</MenuItem>
            <MenuItem value={20}>Twenty</MenuItem>
            <MenuItem value={30}>Thirty</MenuItem>
          </Select>
        </FormControl>
      </Box>

      <Box sx={{ minWidth: 120 }}>
        <FormControl fullWidth>
          <InputLabel id="team2">2팀</InputLabel>
          <Select
            labelId="team2"
            id="team2"
            value={team2}
            label="Team2"
            onChange={handleChange2}
          >
            <MenuItem value={10}>Ten</MenuItem>
            <MenuItem value={20}>Twenty</MenuItem>
            <MenuItem value={30}>Thirty</MenuItem>
          </Select>
        </FormControl>
      </Box>
    </div>
  );
};

export default TeamSelect;
