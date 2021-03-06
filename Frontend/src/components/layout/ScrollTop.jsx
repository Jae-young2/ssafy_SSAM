import React from "react";

import { Box, Button, Zoom } from "@mui/material";
import PropTypes from "prop-types";
import useScrollTrigger from "@mui/material/useScrollTrigger";
import Fab from "@mui/material/Fab";
import KeyboardArrowUpIcon from "@mui/icons-material/KeyboardArrowUp";

const ScrollTop = props => {
  function ScrollTop(props) {
    const { children, window } = props;
    const trigger = useScrollTrigger({
      target: window ? window() : undefined,
      disableHysteresis: true,
      threshold: 100,
    });

    const handleBackToTopClick = event => {
      const anchor = (event.target.ownerDocument || document).querySelector(
        "#back-to-top-anchor"
      );

      if (anchor) {
        anchor.scrollIntoView({
          behavior: "smooth",
          block: "center",
        });
      }
    };

    return (
      <Zoom in={trigger}>
        <Box
          sx={{ position: "fixed", bottom: 42, right: 12 }}
          onClick={handleBackToTopClick}
          role="presentation"
        >
          {children}
        </Box>
      </Zoom>
    );
  }

  ScrollTop.propTypes = {
    children: PropTypes.element.isRequired,
    window: PropTypes.func,
  };

  return (
    <>
      <ScrollTop {...props}>
        <Fab
          sx={{ mb: 1 }}
          color="secondary"
          size="small"
          aria-label="scroll back to top"
        >
          <KeyboardArrowUpIcon sx={{ color: "white" }} />
        </Fab>
      </ScrollTop>
    </>
  );
};

export default ScrollTop;
