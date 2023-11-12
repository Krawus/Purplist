import React,{useState} from "react";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import './Menu.css'


export default const Menu = ({show,children,width,height,...props})=>{
    return (
        <div className={`menu-modal ${show ? 'active' : ''}`} {...props}>
            {children}
        </div>
    )
}