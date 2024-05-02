/*********************************************************************************
'주  시 스 템 : 
'서브  시스템 : 샘플
'프로그램 ID  : PopupSample.js
'프로그램 명  : javascript 샘플 구성
'프로그램개요 : javascript 샘플 구성 화면 이벤트들을 수행한다.
'작   성   자 : 박상률/2006.08.03
'작   성   일 : 
==================================================================================
'수정자/수정일 : 
'수정사유/내역 : 
 *********************************************************************************/

document.onclick = processButtonClick;

function processButtonClick()
{
    
    try {
    	var srcName = window.event.srcElement.getAttribute("name");
    
    	with(document.theForm)
    	{
    	    
    		switch(srcName) {
    		    
    		    // 01. Commodity (COM_ENS_011)
                case "cmdt_btn":                   
                   var cmdt_cd_val = cmdt_cd.value;
                   //var mid_cmdt_val = mid_cmdt.value;
                   var rep_cmdt_cd_val = rep_cmdt_cd.value;
                   var rep_imdg_lvl_cd_val = rep_imdg_lvl_cd.value;
                   
                   var cmdt_nm_val = cmdt_nm.value;
                   var dispaly = cmdt_dispaly.value;
          			   var classId = "COM_ENS_011";
          			   var param = '?cmdt_cd='+cmdt_cd_val+'&rep_cmdt_cd='+rep_cmdt_cd_val+'&cmdt_nm='+cmdt_nm_val+'&rep_imdg_lvl_cd='+rep_imdg_lvl_cd_val+'&classId='+classId;
          			  
          			   var chkStr = dispaly.substring(0,3)
                        
                       // radio PopUp  
                       if(chkStr == "1,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 778, 450, 'getCOM_ENS_011_1', dispaly, true);
                       } else if(chkStr == "0,1") {
                    	   ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 778, 450, 'getCOM_ENS_011_2', dispaly, true);
                       } else if(chkStr == "0,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 778, 450, 'getCOM_ENS_011_3', dispaly, true);
                       } else if(chkStr == "1,1"){
                    	   ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
                           return;
                       } else {
                    	   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                           return;
                      }
                    break;
                
                // 02. Contract (COM_ENS_021)
                case "cnt_btn":
                  var v1 = cnt_txt1.value;
  				  var v2 = cnt_txt2.value;
  				  var v5 = cnt_txt5.value;
  				 
  				  var display = cnt_display.value;
  				  var classId = "COM_ENS_021";
  				  var param = '?cont_tp='+v1+'&cont_no='+v2+'&cust_nm='+v5+'&flag='+v6+'&classId='+classId;
  						  
  				  var chkStr = display.substring(0,3)
  				  
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 778, 440, 'getCOM_ENS_021_1', display, true);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 778, 440, 'getCOM_ENS_021_2', display, true);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 778, 440, 'getCOM_ENS_021_3', display, true);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;
//				
//				// 03. Contract (COM_ENS_021) 달력
//				case "btns_calendar1":
//        	         var cal = new calendarPopup();
//            		 cal.select(cnt_txt3, 'cnt_txt3', 'yyyy-MM-dd');
//        	        break;
//                
//                // 03. Contract (COM_ENS_021) 달력
//        	    case "btns_calendar2":
//        	         var cal = new calendarPopup();
//            		 cal.select(cnt_txt4, 'cnt_txt4', 'yyyy-MM-dd');
//        	        break;
//				  
				// 04. Customer (COM_ENS_041)
                case "cust01_btn":
  				  var v1 = cust01_txt1.value;
  				  var v3 = cust01_txt3.value;
  				  var v4 = cust01_txt4.value;
  				  var display = "1,0,0,1,1,1,1,1,1,1,1,1";//cust01_display.value;
  				  var classId = "COM_ENS_041";
  				  var param = '?cust_cd='+v1+'&cust_nm='+v4+'&ofc_cd='+v3+'&classId='+classId;
  						  
  				  var chkStr = display.substring(0,3)
                
  				  
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 768, 420, 'getCOM_ENS_041_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 768, 420, 'getCOM_ENS_041_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 768, 420, 'getCOM_ENS_041_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;
				  
				  
				// 04. Customer (COM_ENS_042)
                case "cust02_btn":
  				  var v1 = cust02_txt1.value;
  				  var v2 = cust02_txt2.value;
  				  var v3 = cust02_txt3.value;
  				  var display = cust02_display.value;
  				  var classId = "COM_ENS_042";
  				  var param = '?loc_cd='+v1+'&cust_cd='+v2+'&cust_nm='+v3+'&classId='+classId;
  				  
  				  var chkStr = display.substring(0,3)
  				  
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_042.do' + param, 770, 380, 'getCOM_ENS_042_1', display);	// check PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_042.do' + param, 770, 380, 'getCOM_ENS_042_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_042.do' + param, 770, 380, 'getCOM_ENS_042_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;
				  
				// 05. Location (COM_ENS_051)
                case "com_ens_051_btn":
                   var conti_cd_val = com_ens_051_conti_cd.value;
                   var sconti_cd_val = com_ens_051_sconti_cd.value;
                   var cnt_cd_val = com_ens_051_cnt_cd.value;
                   var loc_state_val = com_ens_051_loc_state.value;
                   var loc_eq_ofc_val = com_ens_051_loc_eq_ofc.value;
                   var loc_cd_val = com_ens_051_loc_cd.value;
                   var loc_desc_val = com_ens_051_loc_desc.value;
                   
                   var sys_code = com_ens_051_sys_code.value;
                   
                   var loc_port_ind_val = "";
                   if(com_ens_051_loc_port_ind.checked) {
                       loc_port_ind_val = "1";
                   } else {
                       loc_port_ind_val = "0";
                   }
                   
                   var dispaly = com_ens_051_dispaly.value;
        	       var classId = "COM_ENS_051";
        		   var param = '?conti_cd='+conti_cd_val+'&sconti_cd='+sconti_cd_val+'&cnt_cd='+cnt_cd_val+'&loc_state='+loc_state_val
        		              +'&loc_eq_ofc='+loc_eq_ofc_val+'&loc_cd='+loc_cd_val+'&loc_desc='+loc_desc_val
        		              +'&loc_port_ind='+loc_port_ind_val+'&sysCode='+sys_code+'&classId='+classId;
        			  
        		   var chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
                       if(chkStr == "1,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 410, 'getCOM_ENS_051_1', dispaly);
                       } else if(chkStr == "0,1") {
                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 410, 'getCOM_ENS_051_2', dispaly);
                       } else if(chkStr == "0,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 410, 'getCOM_ENS_051_3', dispaly);
                       } else if(chkStr == "1,1"){
                    	   ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
                           return;
                       } else {
                    	   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                           return;
                      }
                  break;
                  
                // 06. Node (COM_ENS_061)
                case "com_ens_061_btn":                  
  				  var v1 = com_ens_061_cnt_cd.value;
  				  var v2 = com_ens_061_loc_cd.value;
  				  var v3 = com_ens_061_ofc_cd.value;
  				  var v4 = com_ens_061_node_cd.value;
  				  var v5 = com_ens_061_node_nm.value;
  				  
  				  var v6 = "";
  				  if(com_ens_061_mode) {
      				  if(com_ens_061_mode[0] && com_ens_061_mode[0].checked) {
      				      v6 = com_ens_061_mode[0].value;
      				  } else {
      				      v6 = com_ens_061_mode[1].value;
      				  }
  				  }
  				  
  				  var v7 = "N";
  				  if(com_ens_061_mode_only.checked) {
  				      v7 = "Y";
  				  }
  				  
  				  
  				  var display = com_ens_061_display.value;
  				  var classId = "COM_ENS_061";
  				  var param = '?cnt_cd='+v1+'&loc_cd='+v2+'&ofc_cd='+v3+'&node_cd='+v4+'&node_nm='+v5+'&mode='+v6+'&mode_only='+v7+'&classId='+classId;
  				  var chkStr = display.substring(0,3)
                
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'getCOM_ENS_061_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'getCOM_ENS_061_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'getCOM_ENS_061_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
	              break;
	              
	            // 07. Office (COM_ENS_071)
                case "ofc_btn":
                   var ofc_lev_val = ofc_lev.value;
                   var ofc_pts_cd_val = ofc_pts_cd.value;
                   var ofc_cd_val = ofc_cd.value;
                   var ofc_nm_val = ofc_nm.value;
                   
                   var dispaly = ofc_dispaly.value;
          			   var classId = "COM_ENS_071";
          			   var param = '?ofc_lev='+ofc_lev_val+'&ofc_pts_cd='+ofc_pts_cd_val+'&ofc_cd='+ofc_cd_val+'&ofc_nm='+ofc_nm_val+'&classId='+classId;
    			  
    			         var chkStr = dispaly.substring(0,3)
                  
                   // radio PopUp  
                   if(chkStr == "1,0") {
                	   ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 410, 'getCOM_ENS_071_1', dispaly);
                   } else if(chkStr == "0,1") {
                	   ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 410, 'getCOM_ENS_071_2', dispaly);
                   } else if(chkStr == "0,0") {
                	   ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 410, 'getCOM_ENS_071_3', dispaly);
                   } else if(chkStr == "1,1"){
                	   ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
                       return;
                   } else {
                	   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                       return;
                  }
                  break;
                  
                // 08. Lane (COM_ENS_081)
                case "com_ens_081_btn":                  
  				  var v1 = com_ens_081_mode.value;
  				  var v2 = com_ens_081_trade_cd.value;
  				  var v3 = com_ens_081_sub_trade_cd.value;
  				  var v4 = com_ens_081_lane_cd.value;
  				  var v5 = com_ens_081_lane_nm.value;
  				  var v6 = com_ens_081_svc_tp.value;
  				  
  				  var display = com_ens_081_display.value;
  				  var classId = "COM_ENS_081";
  				  
  				  var param = "";
  				  if(v1 == "rev") {
  				      param = '?mode='+v1+'&trade_cd='+v2+'&sub_trade_cd='+v3+'&lane_cd='+v4+'&lane_nm='+v5+'&svc_tp='+v6+'&classId='+classId;
  				  } else {
  				      param = '?mode='+v1+'&lane_cd='+v4+'&lane_nm='+v5+'&svc_tp='+v6+'&classId='+classId;
  				  }
  				  
  				  var chkStr = display.substring(0,3)
                
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 420, 'getCOM_ENS_081_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 420, 'getCOM_ENS_081_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 420, 'getCOM_ENS_081_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
	              break; 
	              
	            // 09-01. Staff (COM_ENS_091)
                case "com_ens_091_btn":                
  				  var v1 = com_ens_091_ofc_cd.value;
  				  var v2 = com_ens_091_user_cd.value;
  				  var v3 = com_ens_091_user_nm.value;
  				  var display = com_ens_091_display.value;
  				  var classId = "COM_ENS_091";
  				  var param = '?ofc_cd='+v1+'&user_cd='+v2+'&user_nm='+v3+'&classId='+classId+"&f_cmd=2";
  				 
  				  var chkStr = display.substring(0,3)
                
  				  
  				  if(chkStr == "1,0") {					  
  					ComOpenPopup('/hanjin/COM_ENS_091.do' + param, 780, 535, 'getCOM_ENS_091_1', display,true, true);
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_091.do' + param, 780, 535, 'getCOM_ENS_091_2', display, true, true);
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_091.do' + param, 780, 535, 'getCOM_ENS_091_3', display, true);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;
				
				// 09-02. Notified Subscriber (COM_ENS_092)
                case "com_ens_092_btn":                
  				  //var v1 = com_ens_092_user_id.value;
  				  //var v2 = com_ens_092_user_email.value;
  				  var classId = "COM_ENS_092";
  				  //var param = '?usr_id='+v1+'&usr_eml='+v2+'&classId='+classId;
  				  var param = '?classId='+classId;
  				 
  				  ComOpenPopup('/hanjin/COM_ENS_092.do' + param, 810, 450, 'getCOM_ENS_092', '1,0,1,1,1,1,0,0,0,0,0,0,0,0,0', true);	// radio PopUp  
  				  
				  break;
                 
    		    // 10. Vessel (COM_ENS_0A1)(완료)
    			case "sp1_btn":
  				  var v1 = sp1_txt1.value;
  				  var v2 = sp1_txt2.value;
  				  var v3 = sp1_txt3.value;
  				  var display = sp1_display.value;
  				  var classId = "COM_ENS_0A1";
  				  var param = '?vsl_cd='+v1+'&vsl_eng_nm='+v2+'&car_cd='+v3+'&classId='+classId;
  						  
  				  var chkStr = display.substring(0,3)
                
  				  
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_0A1.do' + param, 618, 420, 'getCOM_ENS_0A1_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_0A1.do' + param, 618, 420, 'getCOM_ENS_0A1_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_0A1.do' + param, 618, 420, 'getCOM_ENS_0A1_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;
				  
				// 11. Vessel SKD (COM_ENS_0B1)
                case "vesselskd01_btn":
  				  var v1 = vvd01_cd.value;
  				  var display = vslskd01_display.value;
  				  var classId = "COM_ENS_0B1";
  				  var param = '?vvd_cd='+v1+'&classId='+classId;
  						  
  				  var chkStr = display.substring(0,3)
                
  				  
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_0B1.do' + param, 620, 450, 'getCOM_ENS_0B1_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_0B1.do' + param, 620, 450, 'getCOM_ENS_0B1_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_0B1.do' + param, 620, 450, 'getCOM_ENS_0B1_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;					  	  
	  	  
				  
				// 11. VVD (COM_ENS_0B2)
                case "vesselskd02_btn":
  				  var v1 = vslskd02_etdeta.value;
  				  var v2 = vslskd02_sdate.value;
  				  var v3 = vslskd02_edate.value;
  				  var v4 = vslskd02_vvd.value;
  				  var v5 = vslskd02_loc.value;
  				  var v6 = vslskd02_lane.value;
  				  var v7 = vslskd02_oper.value;

  				  var display = vslskd02_display.value;
  				  var classId = "COM_ENS_0B2";
  				  
  				  var param = '?etdeta='+v1+  
  				              '&sdate='+v2+             
  				              '&edate='+v3+             
  				              '&vvd_cd='+v4+             
  				              '&loc_cd='+v5+             
  				              '&lane_cd='+v6+             
  				              '&oper='+v7+             
  				              '&classId='+classId;
  						  
  				  var chkStr = display.substring(0,3)
                
  				  
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 770, 420, 'getCOM_ENS_0B2_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 770, 420, 'getCOM_ENS_0B2_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 770, 420, 'getCOM_ENS_0B2_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
				  break;
				  
				  /*var v1 = vslskd02_etdeta.value;
  				  var v2 = vslskd02_sdate.value;
  				  var v3 = vslskd02_edate.value;
  				  var v4 = vslskd02_vvd.value;
  				  var v5 = vslskd02_loc.value;
  				  var v6 = vslskd02_lane.value;
  				  var v7 = vslskd02_oper.value;

  				  var display = vslskd02_display.value;
  				  var classId = "COM_ENS_0B2";
  				  
                  var targetObjList = "vvd:vslskd02_vvd";
  				  var param = '?etdeta='+v1+  
  				              '&sdate='+v2+             
  				              '&edate='+v3+             
  				              '&vvd_cd='+v4+             
  				              '&loc_cd='+v5+             
  				              '&lane_cd='+v6+             
  				              '&oper='+v7+             
  				              '&classId='+classId;
  				  
  				  comPopupWithTargetObj('/hanjin/COM_ENS_0B2.do' + param, 770, 470, targetObjList, display, true);
	              break;*/					  	  
	  	        
	  	        // 03. Contract (COM_ENS_021) 달력
				case "vslskd02_calendar1":
        	         var cal = new calendarPopup();
            		 cal.select(vslskd02_sdate, 'vslskd02_sdate', 'yyyy-MM-dd');
        	         break;
                
                // 03. Contract (COM_ENS_021) 달력
        	    case "vslskd02_calendar2":
        	         var cal = new calendarPopup();
            		 cal.select(vslskd02_edate, 'vslskd02_edate', 'yyyy-MM-dd');
        	         break;
				  
				// 12. Service Provider (COM_ENS_0C1)
                case "sp_btn":
  				  var v1 = sp_txt1.value;
  				  var v2 = sp_txt2.value;
  				  var v4 = sp_txt4.value;
  				  var v5 = sp_txt5.value;
  				  var v6 = sp_vndr_cd.value;
  				  var display = sp_display.value;
  				  var classId = "COM_ENS_0C1";
  				  var param = '?vndr_cd='+v6+'&cnt_cd='+v1+'&vndr_nm_eng='+v2+'&ofc_cd='+v4+'&pts_vndr_cd='+v5+'&classId='+classId;
  				  var chkStr = display.substring(0,3)
                
  				  if(chkStr == "1,0") {		
  					ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_0C1_1', display);	// radio PopUp  
  				  } else if(chkStr == "0,1") {
  					ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_0C1_2', display);	// check PopUp  
  				  } else if(chkStr == "0,0") {
  					ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_0C1_3', display);	// list PopUp  
  				  } else if(chkStr == "1,1"){
  					ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) display속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
  					  return;
  				  } else {
  					ComShowMessage("팝업을 띄우기display속성 정보가 부족합니다.");
  					return;
  				  }
	              break;
    		}
    	}
    }
    catch(e) {        
    	if( e = "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
    	} else {
    		ComShowMessage(e);
    	}
    }
}

/**
 * Commodity : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_011_1(rowArray) {
	//alertComPopupData(rowArray);
	
	var colArray = rowArray[0];	
	document.all.cmdt_cd.value = colArray[2];
	document.all.cmdt_nm.value = colArray[3];
	document.all.rep_cmdt_cd.value = colArray[4];
	document.all.rep_imdg_lvl_cd.value = colArray[5];	
}


/**
 * Commodity : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_011_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';
		
		colArray = rowArray[i];
		
		document.all.cmdt_cd.value += colArray[2] + gubun;
	    document.all.cmdt_nm.value += colArray[3] + gubun;
	    document.all.rep_cmdt_cd.value += colArray[4] + gubun;
	    document.all.rep_imdg_lvl_cd.value += colArray[5] + gubun;
	}
}


/**
 * Commodity : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_011_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.cmdt_cd.value = colArray[2];
	document.all.cmdt_nm.value = colArray[3];
	document.all.rep_cmdt_cd.value = colArray[4];
	document.all.rep_imdg_lvl_cd.value = colArray[5];
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_021_1(rowArray) {
	//alertComPopupData(rowArray);
	var colArray = rowArray[0];
	document.all.cnt_txt1.value = colArray[2].substring(0,3);
	document.all.cnt_txt2.value = colArray[2].substring(3,colArray[2].length);	
	document.all.cnt_txt5.value = colArray[3];
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_021_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	// 초기화
	document.all.cnt_txt1.value = "";
	document.all.cnt_txt2.value = "";
	//document.all.cnt_txt5.value = "";
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
		document.all.cnt_txt1.value += colArray[2] + gubun;
    	document.all.cnt_txt2.value += colArray[2] + gubun;	
    	document.all.cnt_txt5.value += colArray[3] + gubun;
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_021_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];

	document.all.cnt_txt1.value = colArray[2].substring(0,3);
	document.all.cnt_txt2.value = colArray[2].substring(3,colArray[2].length);	
    document.all.cnt_txt5.value = colArray[3];
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_041_1(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.cust01_txt1.value = colArray[4];
	document.all.cust01_txt4.value = colArray[5];
	document.all.cust01_txt3.value = colArray[6];
//	document.all.cust01_txt2.value = colArray[5];
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_041_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		  	
  	document.all.cust01_txt1.value += colArray[3] + gubun;
  	document.all.cust01_txt4.value += colArray[4] + gubun;
//  	document.all.cust01_txt2.value += colArray[5] + gubun;
  	document.all.cust01_txt3.value += colArray[9] + gubun;
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_041_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];

	document.all.cust01_txt1.value = colArray[3];
	document.all.cust01_txt4.value = colArray[4];
//    document.all.cust01_txt2.value = colArray[5];
	document.all.cust01_txt3.value = colArray[9];
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_042_1(rowArray) {
	////alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.cust02_txt1.value = colArray[10];
	document.all.cust02_txt2.value = colArray[8];
	document.all.cust02_txt3.value = colArray[9];
	document.all.cust02_txt4.value = colArray[2];
	document.all.cust02_txt5.value = colArray[4];
	document.all.cust02_txt6.value = colArray[3];
	document.all.cust02_txt7.value = colArray[6];
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_042_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		  	
      	document.all.cust02_txt1.value = colArray[10] + gubun;
    	document.all.cust02_txt2.value = colArray[8] + gubun;
    	document.all.cust02_txt3.value = colArray[9] + gubun;
    	document.all.cust02_txt4.value = colArray[2] + gubun;
    	document.all.cust02_txt5.value = colArray[4] + gubun;
    	document.all.cust02_txt6.value = colArray[3] + gubun;
    	document.all.cust02_txt7.value = colArray[6] + gubun;
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_042_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];

	document.all.cust02_txt1.value = colArray[10];
	document.all.cust02_txt2.value = colArray[8];
	document.all.cust02_txt3.value = colArray[9];
	document.all.cust02_txt4.value = colArray[2];
	document.all.cust02_txt5.value = colArray[4];
	document.all.cust02_txt6.value = colArray[3];
	document.all.cust02_txt7.value = colArray[6];
}

/**
 * Location : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_051_1(rowArray) {
	//alertComPopupData(rowArray);
	
	var colArray = rowArray[0];
	document.all.com_ens_051_conti_cd.value = colArray[5];
	document.all.com_ens_051_sconti_cd.value = colArray[6];
	document.all.com_ens_051_cnt_cd.value = colArray[8];
	document.all.com_ens_051_loc_state.value = colArray[9];
	document.all.com_ens_051_loc_eq_ofc.value = colArray[10];
	document.all.com_ens_051_loc_cd.value = colArray[3];
	document.all.com_ens_051_loc_desc.value = colArray[4];
	if(colArray[11] == "Y") {
	    document.all.com_ens_051_loc_port_ind.checked = true;
	} else {
	    document.all.com_ens_051_loc_port_ind.checked = false;
	}
}


/**
 * Location : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_051_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';
		
		colArray = rowArray[i];
		
    	document.all.com_ens_051_conti_cd.value += colArray[5] + gubun;
    	document.all.com_ens_051_sconti_cd.value += colArray[6] + gubun;
    	document.all.com_ens_051_cnt_cd.value += colArray[8] + gubun;
    	document.all.com_ens_051_loc_state.value += colArray[9] + gubun;
    	document.all.com_ens_051_loc_eq_ofc.value += colArray[10] + gubun;
    	document.all.com_ens_051_loc_cd.value += colArray[3] + gubun;
    	document.all.com_ens_051_loc_desc.value += colArray[4] + gubun;
    	if(colArray[11] == "Y") {
    	    document.all.com_ens_051_loc_port_ind.checked = true;
    	} else {
    	    document.all.com_ens_051_loc_port_ind.checked = false;
    	}
	}
}


/**
 * Location : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_051_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.com_ens_051_conti_cd.value = colArray[5];
	document.all.com_ens_051_sconti_cd.value = colArray[6];
	document.all.com_ens_051_cnt_cd.value = colArray[8];
	document.all.com_ens_051_loc_state.value = colArray[9];
	document.all.com_ens_051_loc_eq_ofc.value = colArray[10];
	document.all.com_ens_051_loc_cd.value = colArray[3];
	document.all.com_ens_051_loc_desc.value = colArray[4];
	if(colArray[11] == "Y") {
	    document.all.com_ens_051_loc_port_ind.checked = true;
	} else {
	    document.all.com_ens_051_loc_port_ind.checked = false;
	}
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_061_1(rowArray) {
	//alertComPopupData(rowArray);
    var gubun = '';

	var colArray = rowArray[0];
  	if(document.all.com_ens_061_mode[0].checked) {
      	document.all.com_ens_061_cnt_cd.value = colArray[12];
      	document.all.com_ens_061_loc_cd.value = colArray[13];
      	document.all.com_ens_061_ofc_cd.value = colArray[5];
      	document.all.com_ens_061_node_cd.value = colArray[3];
      	document.all.com_ens_061_node_nm.value = colArray[4];
    } else {
        document.all.com_ens_061_cnt_cd.value = colArray[10];
      	document.all.com_ens_061_loc_cd.value = colArray[11];
      	document.all.com_ens_061_ofc_cd.value = colArray[5];
      	document.all.com_ens_061_node_cd.value = colArray[3];
      	document.all.com_ens_061_node_nm.value = colArray[4];
    }
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_061_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		  	
      	if(document.all.com_ens_061_mode[0].checked) {
          	document.all.com_ens_061_cnt_cd.value += colArray[12] + gubun;
          	document.all.com_ens_061_loc_cd.value += colArray[13] + gubun;
          	document.all.com_ens_061_ofc_cd.value += colArray[5] + gubun;
          	document.all.com_ens_061_node_cd.value += colArray[3] + gubun;
          	document.all.com_ens_061_node_nm.value += colArray[4] + gubun;
        } else {
            document.all.com_ens_061_cnt_cd.value += colArray[10] + gubun;
          	document.all.com_ens_061_loc_cd.value += colArray[11] + gubun;
          	document.all.com_ens_061_ofc_cd.value += colArray[5] + gubun;
          	document.all.com_ens_061_node_cd.value += colArray[3] + gubun;
          	document.all.com_ens_061_node_nm.value += colArray[4] + gubun;
        }
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_061_3(rowArray) {
	//alertComPopupData(rowArray);
    var gubun = '';

	var colArray = rowArray[0];
    
    if(document.all.com_ens_061_mode[0].checked) {
      	document.all.com_ens_061_cnt_cd.value = colArray[12];
      	document.all.com_ens_061_loc_cd.value = colArray[13];
      	document.all.com_ens_061_ofc_cd.value = colArray[5];
      	document.all.com_ens_061_node_cd.value = colArray[3];
      	document.all.com_ens_061_node_nm.value = colArray[4];
    } else {
        document.all.com_ens_061_cnt_cd.value = colArray[10];
      	document.all.com_ens_061_loc_cd.value = colArray[11];
      	document.all.com_ens_061_ofc_cd.value = colArray[5];
      	document.all.com_ens_061_node_cd.value = colArray[3];
      	document.all.com_ens_061_node_nm.value = colArray[4];
    }
}

/**
 * Commodity : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_071_1(rowArray) {
	//alertComPopupData(rowArray);
	
	var colArray = rowArray[0];	
	
	document.all.ofc_cd.value = colArray[3];
	document.all.ofc_nm.value = colArray[4];
	
	var object = document.all.ofc_lev;	
	for(var i=0; i<object.length; i++) {
	    if(object.options[i].text == colArray[5]) {
	        object.options[i].selected = true;
	        break;
	    }
	}
}


/**
 * Commodity : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_071_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';
		
		colArray = rowArray[i];
		
		document.all.ofc_cd.value += colArray[3] + gubun;
    	document.all.ofc_nm.value += colArray[4] + gubun;
    	
    	var object = document.all.ofc_lev;	
    	
    	for(var j=0; j<object.length; j++) {
    	    if(object.options[j].text == colArray[5]) {
    	        object.options[j].selected = true;
    	        break;
    	    }
    	}
	}
}


/**
 * Commodity : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_071_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.ofc_cd.value = colArray[3];
	document.all.ofc_nm.value = colArray[4];
	
	var object = document.all.ofc_lev;	
	for(var i=0; i<object.length; i++) {
	    if(object.options[i].text == colArray[5]) {
	        object.options[i].selected = true;
	        break;
	    }
	}
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_081_1(rowArray) {
	//alertComPopupData(rowArray);
    var gubun = '';

	var colArray = rowArray[0];
	
	if(document.all.com_ens_081_mode.value == "rev") {
    	document.all.com_ens_081_trade_cd.value = colArray[3];
      	document.all.com_ens_081_sub_trade_cd.value = colArray[4];
      	document.all.com_ens_081_lane_cd.value = colArray[5];
      	document.all.com_ens_081_lane_nm.value = colArray[6];
      	document.all.com_ens_081_svc_tp.value = colArray[7];
	} else {
	    document.all.com_ens_081_lane_cd.value = colArray[3];
      	document.all.com_ens_081_lane_nm.value = colArray[4];
      	document.all.com_ens_081_svc_tp.value = colArray[5];
	}
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_081_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
		if(document.all.com_ens_081_mode.value == "rev") {
        	document.all.com_ens_081_trade_cd.value += colArray[3] + gubun;
          	document.all.com_ens_081_sub_trade_cd.value += colArray[4] + gubun;
          	document.all.com_ens_081_lane_cd.value += colArray[5] + gubun;
          	document.all.com_ens_081_lane_nm.value += colArray[6] + gubun;
          	document.all.com_ens_081_svc_tp.value = colArray[7];
    	} else {
    	    document.all.com_ens_081_lane_cd.value += colArray[3] + gubun;
          	document.all.com_ens_081_lane_nm.value += colArray[4] + gubun;
          	document.all.com_ens_081_svc_tp.value = colArray[5];
    	}
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_081_3(rowArray) {
	//alertComPopupData(rowArray);
    var gubun = '';

	var colArray = rowArray[0];

  	if(document.all.com_ens_081_mode.value == "rev") {
    	document.all.com_ens_081_trade_cd.value = colArray[3];
      	document.all.com_ens_081_sub_trade_cd.value = colArray[4];
      	document.all.com_ens_081_lane_cd.value = colArray[5];
      	document.all.com_ens_081_lane_nm.value = colArray[6];
      	document.all.com_ens_081_svc_tp.value = colArray[7];
	} else {
	    document.all.com_ens_081_lane_cd.value = colArray[3];
      	document.all.com_ens_081_lane_nm.value = colArray[4];
      	document.all.com_ens_081_svc_tp.value = colArray[5];
	}
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_091_1(rowArray) {
	var gubun = '';

	var colArray = rowArray[0];
    document.all.com_ens_091_ofc_cd.value = colArray[3];
  	document.all.com_ens_091_user_cd.value = colArray[4];
  	document.all.com_ens_091_user_nm.value = colArray[5];
  	document.all.com_ens_091_user_email.value = colArray[6];
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_091_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
		document.all.com_ens_091_ofc_cd.value += colArray[3] + gubun;
      	document.all.com_ens_091_user_cd.value += colArray[4] + gubun;
      	document.all.com_ens_091_user_nm.value += colArray[5] + gubun;
      	document.all.com_ens_091_user_email.value += colArray[6] + gubun;
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_091_3(rowArray) {
	//alertComPopupData(rowArray);
    var gubun = '';

	var colArray = rowArray[0];

  	document.all.com_ens_091_ofc_cd.value = colArray[3] + gubun;
  	document.all.com_ens_091_user_cd.value = colArray[4] + gubun;
  	document.all.com_ens_091_user_nm.value = colArray[5] + gubun;
  	document.all.com_ens_091_user_email.value = colArray[6] + gubun;
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_092(rowArray) {
	var gubun = ',';
   
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
    	document.all.com_ens_092_user_id.value += colArray[3] + gubun;
    	document.all.com_ens_092_user_email.value += colArray[4] + gubun;
	}
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_0A1_1(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.sp1_txt1.value = colArray[3];
	document.all.sp1_txt2.value = colArray[4];
	document.all.sp1_txt3.value = colArray[5];
}

/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_0A1_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
    	document.all.sp1_txt1.value += colArray[3] + gubun;
    	document.all.sp1_txt2.value += colArray[4] + gubun;
    	document.all.sp1_txt3.value += colArray[5] + gubun;
	}
}

/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_0A1_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];
	document.all.sp1_txt1.value = colArray[3];
	document.all.sp1_txt2.value = colArray[4];
	document.all.sp1_txt3.value = colArray[5];
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_0B1_1(rowArray) {
	//alertComPopupData(rowArray);
    var colArray = rowArray[0];
    
  	document.all.vvd01_cd.value += colArray[3] + colArray[4] + colArray[5];  	
  	document.all.vvd01_lane.value += colArray[6];
  	document.all.vvd01_port.value += colArray[7];
  	document.all.vvd01_etd.value += colArray[8];
  	document.all.vvd01_tind.value += colArray[9];
}

/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_0B1_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		  	
  	document.all.vvd01_cd.value += colArray[3] + colArray[4] + colArray[5] + gubun;
  	
  	document.all.vvd01_lane.value += colArray[6] + gubun;
  	document.all.vvd01_port.value += colArray[7] + gubun;
  	document.all.vvd01_etd.value += colArray[8] + gubun;
  	document.all.vvd01_tind.value += colArray[9] + gubun;
	}
}

/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_0B1_3(rowArray) {
	//alertComPopupData(rowArray);  
	var colArray = rowArray[0];

  	document.all.vvd01_cd.value += colArray[3] + colArray[4] + colArray[5];  	
  	document.all.vvd01_lane.value += colArray[6];
  	document.all.vvd01_port.value += colArray[7];
  	document.all.vvd01_etd.value += colArray[8];
  	document.all.vvd01_tind.value += colArray[9];
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_0B2_1(rowArray) {
	//alertComPopupData(rowArray);
  var gubun = '';

	var colArray = rowArray[0];
  	document.all.vslskd02_lane.value = colArray[3] + gubun;
  	document.all.vslskd02_loc.value  = colArray[4] + gubun;
  	document.all.vslskd02_sdate.value = colArray[5] + gubun;
  	document.all.vslskd02_edate.value = colArray[6] + gubun;
  	document.all.vslskd02_vvd.value = colArray[7] + gubun;
}

/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_0B2_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		  	
  	document.all.vslskd02_lane.value += colArray[3] + gubun;
  	document.all.vslskd02_loc.value += colArray[4] + gubun;
  	document.all.vslskd02_sdate.value += colArray[5] + gubun;
  	document.all.vslskd02_edate.value += colArray[6] + gubun;
  	document.all.vslskd02_vvd.value += colArray[7] + gubun;
	}
}

/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_0B2_3(rowArray) {
	//alertComPopupData(rowArray);
  var gubun = '';

	var colArray = rowArray[0];

  	document.all.vslskd02_lane.value = colArray[3] + gubun;
  	document.all.vslskd02_loc.value = colArray[4] + gubun;
  	document.all.vslskd02_sdate.value = colArray[5] + gubun;
  	document.all.vslskd02_edate.value = colArray[6] + gubun;
  	document.all.vslskd02_vvd.value = colArray[7] + gubun;
}

/**
 * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_0C1_1(rowArray) {
    //alertComPopupData(rowArray);

	var colArray = rowArray[0];
	
	document.all.sp_txt1.value = colArray[7];
	document.all.sp_txt2.value = colArray[4];
	document.all.sp_txt4.value = colArray[3];	
	document.all.sp_txt5.value = colArray[6];
	document.all.sp_txt6.value = colArray[8];
}


/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_0C1_2(rowArray) {
	//alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
		document.all.sp_txt1.value += colArray[7] + gubun;
    	document.all.sp_txt2.value += colArray[4] + gubun;
    	document.all.sp_txt4.value += colArray[3] + gubun;
    	document.all.sp_txt5.value += colArray[6] + gubun;
    	document.all.sp_txt6.value += colArray[8] + gubun;
	}
}


/**
 * Sample 3 : 팝업에서 그냥 로우(Row)를 선택한경우..
 */
function getCOM_ENS_0C1_3(rowArray) {
	//alertComPopupData(rowArray);

	var colArray = rowArray[0];

	document.all.sp_txt1.value = colArray[7];
	document.all.sp_txt2.value = colArray[4];
	document.all.sp_txt4.value = colArray[3];	
	document.all.sp_txt5.value = colArray[6];
	document.all.sp_txt6.value = colArray[8];
}

/**
 * Sample 2 : 팝업에서 Check로 멀티 선택을 한경우..
 */
function getCOM_ENS_0O1(rowArray) {
	alertComPopupData(rowArray);
	
	var gubun = ',';
	
	for(var i=0; i<rowArray.length; i++)
	{
		if(i == rowArray.length-1) gubun = '';

		colArray = rowArray[i];
		
		document.all.COM_ENS_0O1_loc_cd.value += colArray[2] + gubun;
	}
}

/**
 * 특정 Div 영역의 Display 모드를 변경한다.
 */
function chgDisplayMode(divId) {
    
    var divList = eval(divId);
    
    if(divList.length) {
        
        for(var i=0; i<divList.length; i++) {  
            var curDisplayMode = divList[i].style.display;
            if(curDisplayMode == "inline") {
                divList[i].style.display = "none";
            } else {
                divList[i].style.display = "inline";
            }
        }
    } else {
        var curDisplayMode = divList.style.display;
        if(curDisplayMode == "inline") {
            divList.style.display = "none";
        } else {
            divList.style.display = "inline";
        }
    }
}