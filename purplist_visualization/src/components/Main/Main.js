import React,{useState} from "react"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faBars} from '@fortawesome/free-solid-svg-icons'
import {faArrowRight,faArrowLeft} from "@fortawesome/free-solid-svg-icons";
import {faNoteSticky,faCalendar} from "@fortawesome/free-regular-svg-icons";
import Button from '../Common/Button/Button.js'
import './Main.css'


export const Main = ()=>{

    const [isOpen,setIsOpen] = useState(false);
    const [userShortcut,setUserShortcut] = useState('JM')
    function openLeftMenu(){
        console.log('Sidebar clicked!')
        isOpen === true ? setIsOpen(false) : setIsOpen(true)
    }

    return(
        <div className={'main-container'}>
            <div className="top-bar">
                <div >
                    <Button className={`top-bar-sidebar-icon ${isOpen ? 'active' : ''}`} onClick={openLeftMenu}>
                        {
                            isOpen && <FontAwesomeIcon icon={faArrowLeft} size="xs" style={{color: '#ffffff', paddingRight: '2px'}}/>
                        }
                        <FontAwesomeIcon icon={faBars} size="xl" style={{color: '#ffffff'}}/>
                    {
                        !isOpen && <FontAwesomeIcon icon={faArrowRight} size="xs" style={{color: '#ffffff', paddingLeft:'2px'}}/>
                    }
                    </Button>
                </div>
                <span className="top-bar-text">Purplist</span>
                <div className={'right-menu'}>
                    <div className="user-icon">
                        {userShortcut}
                    </div>
                </div>

            </div>
            <div className={`main-sidebar ${isOpen ? 'active': '' }`}>
                <ul style={{padding: 0, margin: 0}}>
                    <li className={'main-sidebar-list-item'}>
                        <FontAwesomeIcon icon={faNoteSticky} ></FontAwesomeIcon>
                        Notes
                    </li>
                    <li className={'main-sidebar-list-item'}>
                        <FontAwesomeIcon icon={faCalendar} ></FontAwesomeIcon>
                        Calendar
                    </li>
                </ul>
            </div>
        </div>
    )
}