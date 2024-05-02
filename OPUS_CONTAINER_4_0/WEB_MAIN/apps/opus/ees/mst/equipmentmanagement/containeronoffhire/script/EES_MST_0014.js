/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0014.js
*@FileTitle  : Leased Container
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_mst_0014 : business script for ees_mst_0014
     */
    // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 // Combo Object Array
	 var comboObjects=new Array();
	 var comboCnt=0;
	 var IBSEARCH01=29;
	 var IBSEARCH02=30; 
	 var IBSEARCH03=31;
	 var tcnt=0;
	 var rcnt=0;
	 var tabkey=false;
	 var tabkey_1=false;
	  var tmp_agmt_seq="";
	 var tmp_sts_evnt_yd_cd="";
	 var specSearchType = "";
	 var schSpecNo = "";
	 var schTpszCd = "";
	 var schRow = "";
	 var specstrNull = false;
	 var excelChkVal = false;
	 var prvSpecNoValue = "";
	 var errSpecNoValue = "";
	 var chkLeasTrm = "";
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
     function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
					case "btn_master":
						if (sheetObjects[0].RowCount() != 0 ) {
							var cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no");
							if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"){
								var cntr_no_len=cntr_no.length;
								if ( cntr_no_len > 10 ) {
									cntr_no=cntr_no.substring(0,10);
								}
								ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?popup_mode=Y&cntr_no="+cntr_no,1120, 570, "", "1,0,1,1,1,1,1,1", true);
							}
						}
						break;
						
					case "btn_new":
						sheetObject1.RemoveAll();
						sheetObjects[1].RemoveAll();
						initCntr();
						formObject.ctype.value="";
						formObject.hire_date0.value="";
						formObject.eff_dt.value="";
						formObject.exp_dt.value="";
						formObject.p_time.value="00:00";
						setnotreadOnly();
						sheetObject1.SetHeaderCheck(0,"del_chk",0);
						formObject.ctype.value = "0";
						formObject.ctype.focus();
						sheetObject1.SetColProperty(0 ,"cntr_no" , {KeyField:1});
						sheetObject1.SetColProperty(0 ,"cntr_spec_no" , {KeyField:1});
						sheetObject1.SetColBackColor("cntr_spec_no", "");
						sheetObject1.SetColProperty(0 ,"mft_dt" , {KeyField:0});
						sheetObject1.SetColBackColor("mft_dt", "");
						sheetObject1.SetColProperty(0 ,"vndr_abbr_nm" , {KeyField:0});
						sheetObject1.SetColBackColor("vndr_abbr_nm", "");						
						creat_type();
						break;
					
					case "btn_save":
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						break;
						
					case "btn_loadexcel":
			            if (approval_no.GetSelectIndex() != -1 && 
			            	formObject.sts_evnt_yd_cd.value.length > 0 &&
			            	formObject.agmt_cty_cd.value.length > 0 &&
			            	formObject.agmt_seq.value.length > 0 &&
			            	formObject.ctype.value.length > 0 &&
			            	formObject.hire_date0.value.length > 0){
				        } else {
				        	if (formObject.ctype.value.length == 0)
				        		ComShowCodeMessage("MST00001", "Creation Type")
				        	else if (formObject.hire_date0.value.length == 0)
				        		ComShowCodeMessage("MST00001", "On-hire Date")
				            else if (approval_no.GetSelectIndex() != -1	)
				            	ComShowCodeMessage("MST00001", "Auth No.")
			            	else if (formObject.sts_evnt_yd_cd.value.length == 0)
			            	    ComShowCodeMessage("MST00001", "On Hire Yard")
			            	else if (formObject.agmt_cty_cd.value.length == 0)   
			            		ComShowCodeMessage("MST00001", "AGMT No.")
			            	else if (formObject.agmt_seq.value.length == 0)	
			            		ComShowCodeMessage("MST00001", "AGMT No.");
			            	return;
				        } 					
			            sheetObject1.RemoveAll();
			            //sheetObject1.SetColProperty(0 ,"cntr_spec_no" , {KeyField:0});
			            //sheetObject1.SetCellEditable(1,"cntr_spec_no",0);
			            sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
//						if (ccheck == true){
//						    for(var i=1; i <= sheetObject1.RowCount(); i++){
//						    	setCntInsMode(i);
//						    }
//						}   
					break;
					
					case "btn_add":
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
						break;			
					case "btn_copy":
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;					
					case "btn_delete":
	   					if(sheetObject1.FindCheckedRow("del_chk")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
	   					}
	   					break;
	   					
	                case "ComOpenPopupWithTargetYard":
	                	if (formObject.sts_evnt_yd_cd.readOnly == false){
	         		       ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 540, "3:sts_evnt_yd_cd|4:yd_cd_nm", "0,0,1,1,1,1,1", true);
		                	if (formObject.sts_evnt_yd_cd.value.length > 0 && formObject.sts_evnt_yd_cd.value.length != 7){
		                		ComShowCodeMessage("MST01019", formObject.sts_evnt_yd_cd.value);
		                		formObject.sts_evnt_yd_cd.value="";
		                		ComSetFocus(formObject.sts_evnt_yd_cd);
		                		return;
		                	} else {
		                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
		                	} 	         		       
	                	}
	                	break;
	                	
	                case "ComOpenPopupWithTargetAgmtNo": //agmt no
	                    if (formObject.agmt_seq.readOnly == false)
	       			       ComOpenPopup('/opuscntr/EES_LSE_0091.do', 855, 480, 'setPopData_Agreement', '0,0,1', true); 			                	
	                    break;
	                case "cal_img":
	                	func_calendar('calendarPopup1');
	                	break;
             } 
         }catch(e) {
             if( e == "[object Error]") {
            	 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }
     }
     
     
  	/**
  	 * handling Currency Pop-up Return Value<br>
  	 * @param {arry} Return value array of returnedValues Pop-up screen
  	 * @param Row index
  	 * @param Col index
  	 * @paramsheet Array index
  	 */
 	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
 	    var formObj=document.form;
 	    var sheetObj=sheetObjects[0];
 	    if ( aryPopupData.length > 0 ) {
 	    	comboObjects[0].RemoveAll();
 	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][4]);
 	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
 	        ComSetObjValue(formObj.ref_no,   aryPopupData[0][6]);
 	        ComSetObjValue(formObj.lstm_cd,  aryPopupData[0][7]);
 	        ComSetObjValue(formObj.vndr_seq, aryPopupData[0][8]);
 	        ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][9]);
 	        
 	       ComSetObjValue(formObj.eff_dt,  aryPopupData[0][10]);
 	       ComSetObjValue(formObj.exp_dt,  aryPopupData[0][11]);
  	       ComSetObjValue(formObj.hid_free_dys,  aryPopupData[0][12]);

 	        if (formObj.lstm_cd.value != "LT" &&
 	        	formObj.lstm_cd.value != "ST" &&	
 	        	formObj.lstm_cd.value != "OF" &&
 	        	formObj.lstm_cd.value != "SI" &&
 	        	formObj.lstm_cd.value != "MI" &&
 	        	formObj.lstm_cd.value != "SH") {
 	        	ComShowCodeMessage("MST01003");
 	        	formObj.agmt_cty_cd.value="HHO";
 	        	formObj.agmt_seq.value="";
 	        	formObj.ref_no.value="";
 	        	formObj.vndr_seq.value="";
 	        	formObj.vndr_nm.value="";
 	        	formObj.lstm_cd.value="";
 	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
 	        	ComSetFocus(formObj.agmt_seq);
 	        	return;
 	        }
        	if (formObj.lstm_cd.value.length == 2) {
        		if (formObj.ctype.value == "1"){  
		  			if (!(formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SH" || formObj.lstm_cd.value == "MI")){
				        ComShowCodeMessage("MST01003");
				        formObj.agmt_seq.value="";
	                    formObj.ref_no.value="";
	                    formObj.lstm_cd.value="";
	            	    formObj.vndr_seq.value="";
	            	    formObj.vndr_nm.value="";		
	     	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);		            	    
					    ComSetFocus(formObj.agmt_seq);                                                		  				
			  			return;    		  				
		  			}
        		}
        	} 	        
 	        if (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF") {
 	        	ComBtnEnable("btn_loadexcel");
 	        } else {
 	        	ComBtnDisable("btn_loadexcel");
 	        }
 	        
 	       if (formObj.lstm_cd.value == "LT") {
	  			sheetObj.SetColProperty(0 ,"cntr_spec_no" , {KeyField:1});
	  			sheetObj.SetColBackColor("cntr_spec_no", "#d4f6ff");
	  		}
	  		if (formObj.lstm_cd.value == "LT" || formObj.ctype.value == "2") {
	  			sheetObj.SetColProperty(0 ,"mft_dt" , {KeyField:1});
	  			sheetObj.SetColBackColor("mft_dt", "#d4f6ff");
	  			sheetObj.SetColProperty(0 ,"vndr_abbr_nm" , {KeyField:1});
	  			sheetObj.SetColBackColor("vndr_abbr_nm", "#d4f6ff");	  			
 			}
	  		
 	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  		if (formObj.lstm_cd.value.length == 2) {
	  			if (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI"){
	  				approval_no.SetBackColor("#D4F6FF");
	  				comboObjects[0].SetDisabledBackColor("#D4F6FF"); 
	  			} else {
	  				approval_no.SetBackColor("#FFFFFF");
	  				comboObjects[0].SetDisabledBackColor("#FFFFFF");
	  			}
	  		} else {
	  			approval_no.SetBackColor("#FFFFFF");
	  			comboObjects[0].SetDisabledBackColor("#FFFFFF");
	  		} 	        
 	    }
 	} 	 
    /**
     * registering IBsheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
     function setSheetObject(sheet_obj){        
         sheetObjects[sheetCnt++]=sheet_obj;
     }
   	/**
   	 * registering IBMultiCombo Object as list
   	 * adding process for list in case of needing batch processing with other items 
   	 * defining list on the top of source
   	 */
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}      
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
     function loadPage() {
    	 
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         sheet1_OnLoadFinish(sheet1);
         document.form.hidden_curdate.value=ComGetNowInfo("ymd"); //document.form.hire_date.value;
         document.form.agmt_cty_cd.value="HHO";
         document.form.p_time.value="00:00";
         document.form.ctype.value="";
         document.form.ctype.focus();         
  	     for ( k=0 ; k < comboObjects.length ; k++ ){
  		   initCombo(comboObjects[k], k+1);
  	     }          
  		 initControl();
  		 doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
  		 
  		 document.form.ctype.value = "0";
  		 creat_type();
     }
     
     function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);    	  
          
          var formObj=document.form;
          formObj.f_cmd.value=SEARCH11;			
  		  var xml="";
  		  xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
  		  var comboItems=ComGetEtcData(xml, "rf_humid_ctrl_val_cd").split("|");
  		
  		  var rfHCVCdCode = "";
  		  var rfHCVCdText = "";
  		  var rfHCVCdArr = "";
  		  for(var i=0;i<comboItems.length;i++) {
  			  rfHCVCdArr = comboItems[i].split(",");
  			  rfHCVCdCode = rfHCVCdCode + "|" + rfHCVCdArr[0];
  			  rfHCVCdText =  rfHCVCdText + "|" + rfHCVCdArr[1];
  		  }	
  		  sheetObj.SetColProperty("rf_humid_ctrl_val_cd", {ComboText:rfHCVCdText, ComboCode:rfHCVCdCode} );
     }
     
     /**
      * calling event after retrieving Sheet
 	 * @param sheetObj
 	 * @param ErrMsg
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 
     }

     function initControl() {
		var formObj=document.form;
		axon_event.addListenerFormat('blur',    'obj_blur',     form);   //- handling OnBeforeDeactivate event of all control except rdoCity
        axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- handling OnBeforeDeactivate event of all control that has dataformat attribute
	    axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- when key down
	    axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- when key down
	    axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- when key down
		axon_event.addListener("change", "creat_type","ctype");
    	formObj.cntr_no0.disabled=true;
    	formObj.cntr_no1.disabled=true;
    	formObj.cntr_no2.disabled=true;		
	}
	function creat_type(){
		var formObj=document.form;		
	    if (formObj.ctype.value == "0" || formObj.ctype.value == "1"){
	    	formObj.cntr_no0.value="";
	    	formObj.cntr_no1.value="";
	    	formObj.cntr_no2.value="";
	    	formObj.cntr_no3.value="";
	    	formObj.cntr_no0.disabled=true;
	    	formObj.cntr_no1.disabled=true;
	    	formObj.cntr_no2.disabled=true;
	 		document.getElementById("cntr_no0").className="input2";
	 		document.getElementById("cntr_no1").className="input2";
	 		document.getElementById("cntr_no2").className="input2";
	 		formObj.cntr_no0.readOnly=true;
	 		formObj.cntr_no1.readOnly=true;
	 		formObj.cntr_no2.readOnly=true;	 		
	 		ComBtnEnable("btn_add");
	 		ComBtnEnable("btn_delete");
	 		ComBtnEnable("btn_copy");
	 		if(formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF")
	 		   ComBtnEnable("btn_loadexcel")
	 		else
	 		   ComBtnDisable("btn_loadexcel");
	    	if (formObj.ctype.value == "1"){
	    		if (!(formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SH" || formObj.lstm_cd.value == "MI")){
	 	        	formObj.agmt_cty_cd.value="HHO";
	 	        	formObj.agmt_seq.value="";
	 	        	formObj.ref_no.value="";
	 	        	formObj.vndr_seq.value="";
	 	        	formObj.vndr_nm.value="";
	 	        	formObj.lstm_cd.value="";
	 	        	ComSetFocus(formObj.agmt_seq);
	 	        	return;
	    		}
	    	}	 		
	    } else {
	    	formObj.cntr_no0.value="";
	    	formObj.cntr_no1.value="";
	    	formObj.cntr_no2.value="";
	    	formObj.cntr_no3.value="";
	    	formObj.cntr_no0.disabled=false;
	    	formObj.cntr_no1.disabled=false;
	    	formObj.cntr_no2.disabled=false;
	 		document.getElementById("cntr_no0").className="input1";
	 		document.getElementById("cntr_no1").className="input1";
	 		document.getElementById("cntr_no2").className="input1";
	 		formObj.cntr_no0.readOnly=false;
	 		formObj.cntr_no1.readOnly=false;
	 		formObj.cntr_no2.readOnly=false;
	 		ComBtnDisable("btn_add");
	 		ComBtnDisable("btn_copy");
	 		ComBtnDisable("btn_loadexcel");
	 		ComBtnDisable("btn_delete");
	 		
	    }
	    tabkey=false;
     	if (formObj.agmt_cty_cd.value != "" && formObj.agmt_seq.value != ""){
     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //Lease Term
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	  //Aprove No
    	   	    
     	}
     	if (formObj.hire_date0.value.trim() == ""){
     		formObj.hire_date0.focus();
     	}	
     	else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
     		formObj.sts_evnt_yd_cd.focus();
     	}
	} 
	//handling event on blur
	function obj_blur(){
		var formObj=document.form;
		var obj=ComGetEvent();
		formObj.hire_date.value = formObj.hire_date0.value.substr(0, 10);
	    if (ComGetEvent("name") == "hire_date0"){
	    	ComAddSeparator(formObj.hire_date0);
	    	if (ComGetNowInfo("ymd") < formObj.hire_date0.value){
	    		formObj.hire_date0.value=ComGetNowInfo("ymd");
	    		ComAlertFocus(formObj.hire_date0,ComGetMsg("MST01006", "", "", ""));
	    	} else {
	    		if (formObj.hire_date0.value.length >= 8) {
	    			if (formObj.agmt_cty_cd.value != "" && formObj.agmt_seq.value != ""){
		    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
		    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	 	    				
	    			}		
	    			if(replaceAll(formObj.hire_date0.value,"-","") < getRelativeTime(0,0,-90,0).substring(0,8)){
	    				ComShowCodeMessage("MST01030");
	    			}	    			
	    		}
	    		ComAddSeparator(formObj.hire_date0, "ymd");
	    	}
	    }
	    else if(ComGetEvent("name") == "agmt_cty_cd"){
	    	if (formObj.agmt_cty_cd.value.length == 3 && 
	    	    formObj.agmt_seq.value != "" &&
	    	    formObj.sts_evnt_yd_cd.value != "" &&
	    	    formObj.agmt_cty_cd.readOnly == true){
	    	} 
	    }
	    else if(ComGetEvent("name") == "agmt_seq"){
	    	if (formObj.agmt_cty_cd.value.length == 3 && 
	    	    formObj.agmt_seq.value != "" &&
	    	    formObj.sts_evnt_yd_cd.value != "" &&
	    	    formObj.agmt_cty_cd.readOnly == true){
    			if (tmp_agmt_seq != formObj.agmt_seq.value){
		    		formObj.lstm_cd.value="";
		    		formObj.vndr_seq.value="";
		    		formObj.ref_no.value="";
		    		formObj.vndr_nm.value="";
		    		var chkdup=false;
		    		if (tcnt < 0) { tcnt=0; chkdup=true} 
		    		tcnt=tcnt + 1;
		    		var toggle=tcnt%2;
		    		if (toggle == 1){	
		    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
		    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
		    			
    			    }
		    		if (!chkdup){
		    			tcnt=0;
		    		}
	    		}	
		    } 	    	
	    }
	    else if(ComGetEvent("name") == "sts_evnt_yd_cd"){
        	if (formObj.sts_evnt_yd_cd.value.length > 0 && formObj.sts_evnt_yd_cd.value.length != 7){
        		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
        		formObj.sts_evnt_yd_cd.value="";
        		formObj.yd_cd_nm.value="";
            	comboObjects[0].SetSelectIndex(-1);
            	comboObjects[0].RemoveAll();
        		ComSetFocus(formObj.sts_evnt_yd_cd);
        		formObj.sts_evnt_yd_cd.focus();
        	}else if(formObj.sts_evnt_yd_cd.value.length == 0){
        		formObj.yd_cd_nm.value="";
        	} 		
	    }
	    else {
            ComChkObjValid(obj);
	    }
	}
	//handling event focus
	function obj_focus(){
		var formObj=document.form;
		var obj=event.srcElement;
	    if (ComGetEvent("name") == "hire_date0"){		
	    	ComClearSeparator(formObj.hire_date0, "ymd");
	    	ComSetFocus(formObj.hire_date0);
	    } else if (ComGetEvent("name") == "agmt_seq"){
	    	//tmp_agmt_seq=formObj.agmt_seq.value;
	    	//tmp_sts_evnt_yd_cd=formObj.sts_evnt_yd_cd.value;
	    } else if (ComGetEvent("name") == "sts_evnt_yd_cd"){
	    	//tmp_agmt_seq=formObj.agmt_seq.value;
	    	//tmp_sts_evnt_yd_cd=formObj.sts_evnt_yd_cd.value;
	    }
	}
  	function obj_keyup() {
 		var obj=ComGetEvent();
 		var vKeyCode=ComGetEvent("keycode");
 		var formObj=document.form;
 		switch(ComGetEvent("name")) {
			case "cntr_no0":
				if (formObj.cntr_no0.value.length == 4) {
					ComSetFocus(formObj.cntr_no1);
				}
            break;
			case "cntr_no1":
				if (formObj.cntr_no1.value.length == 6) {
					ComSetFocus(formObj.cntr_no2);
				}
            break;
			case "cntr_no2":
				if (formObj.cntr_no2.value.length == 6) {
					getRangeCount();
				}
            break;
			case "agmt_cty_cd":
				if (formObj.agmt_cty_cd.value.length == 3) {
					ComSetFocus(formObj.agmt_seq);
				}
			break;
			case "agmt_seq":
				if (vKeyCode == 13 &&   //enter key pressed, unvailalbe to retrieve twice
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.sts_evnt_yd_cd.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// call LSE
					tcnt=-1;
					ComSetFocus(approval_no);
				}
			break;
			case "sts_evnt_yd_cd":
				if (vKeyCode == 13 && 
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.sts_evnt_yd_cd.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// call LSE
					ComSetFocus(formObj.agmt_cty_cd);
				} else if (vKeyCode == 13){
					ComSetFocus(formObj.agmt_cty_cd);
				}
				if (formObj.sts_evnt_yd_cd.value.length == 7) {
	        		if (tmp_sts_evnt_yd_cd != formObj.sts_evnt_yd_cd.value){
	        			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	        		}
			    	if (formObj.agmt_cty_cd.value.length == 3 && 
			    	    formObj.agmt_seq.value != "" &&
			    	    formObj.sts_evnt_yd_cd.value != "" &&
			    	    formObj.agmt_cty_cd.readOnly == true){
			    		if (tmp_sts_evnt_yd_cd != formObj.sts_evnt_yd_cd.value || 
			    			tmp_agmt_seq != formObj.agmt_seq.value){
				    		formObj.lstm_cd.value="";
				    		formObj.vndr_seq.value="";
				    		formObj.ref_no.value="";
				    		formObj.vndr_nm.value="";
				    		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
						    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
						   
						    ComSetFocus(formObj.agmt_cty_cd);
			    		}
				    }
			    	if (formObj.sts_evnt_yd_cd.value == ""){
			    		formObj.yd_cd_nm.value="";
		            	comboObjects[0].SetSelectIndex(-1);
		            	comboObjects[0].RemoveAll();
			    	}				
				}
			break;
			case "cntr_no2":
				if (vKeyCode == 13){
					getRangeCount();
				}
			break;	
			case  "cntr_spec_no":
		    break;
 		}
 	}  	 
 	function obj_keypress(){
	    var obj=ComGetEvent();
	    var obj_name=ComGetEvent("name");
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    var vKeyCode=ComGetEvent("keycode");
	    switch(obj.dataformat) {
	        case "engup":
	            if(obj_name=="lstm_cd") ComKeyOnlyAlphabet('uppernum');
	            if(obj_name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
	            if(obj_name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
	            if(obj_name=="agmt_seq") ComKeyOnlyNumber('int');
	            if(obj_name=="vndr_seq") ComKeyOnlyNumber('int');
	            if(obj_name=="approval_no") ComKeyOnlyAlphabet('uppernum');
	            if(obj_name=="ref_no") ComKeyOnlyAlphabet('uppernum',"45"); //"-" 허용
	            if(obj_name=="cntr_no0") ComKeyOnlyAlphabet('upper');
	            if(obj_name=="cntr_no1") ComKeyOnlyNumber('int');
	            if(obj_name=="cntr_no2") ComKeyOnlyNumber('int');
	            break;
	        case "ymd":
	        	if(obj_name=="hire_date0") ComKeyOnlyNumber('int', "-");
	        	break;
	    }
	}
    function approval_no_OnKeyDown(comboObj, KeyCode, Shift) {
    	var formObj=document.form;
		if ((KeyCode >= 48 && KeyCode <= 57) || 
			(KeyCode >= 96 && KeyCode <= 105) || 
			(KeyCode >= 65 && KeyCode <= 90) ||
			(KeyCode >= 37 && KeyCode <= 40) ||
			KeyCode == 189 || KeyCode == 8 ||
			KeyCode == 46) {
			comboObj.SetText(0, 0, comboObj.GetSelectText().toUpperCase());
		} else { 
			comboObj.SetSelectText("");
		}
    }
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
            	    with(sheetObj){
		               var HeadTitle1="||CNTR No.|TP/SZ|Spec No.|Material|Unit Type|Humidity Control|Compressor|PU-charge|PU-credit|Min O/H Days|Free Days|Old /New|M/Date|Manufacturer|Handle On Charge";
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		                      {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"" },
		                      {Type:"Popup",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",      KeyField:1,   CalcLogic:"",   Format:"" , PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                      {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mtrl_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Combo",     Hidden:0, Width:120,   Align:"Left",    ColMerge:0,   SaveName:"rf_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Combo",     Hidden:0, Width:130,   Align:"Left",    ColMerge:0,   SaveName:"rf_humid_ctrl_val_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Text",     Hidden:0, Width:200,   Align:"Left",    ColMerge:0,   SaveName:"rf_cmpr_ctnt",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"pkup_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"pkup_chg_cr_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"min_onh_dys",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"free_dys",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_old_van_flg",  KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"PopupEdit", Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, ShowCol:1 },
		                      {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"lift_on_chrg",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ieflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eeflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ceflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ueflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"heflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"teflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				       SetColProperty("cntr_mtrl_cd", {ComboText:"StainlessSteel|Steel(Unspecified)|Aluminum", ComboCode:"SS|SU|AU"} );
		               SetColProperty("cntr_old_van_flg", {ComboText:"OLD|NEW", ComboCode:"O|N"} );
		               SetShowButtonImage(2);
		               SetEditEnterBehavior("tab");
		              // SetSheetHeight(320);
		               resizeSheet();
               		}
                 break;
                 
             case 2:      // sheet1 init
            	    with(sheetObj){
		               var HeadTitle1="|Sel|CNTR No.|TP/SZ|Spec No.|Material|Unit Type|Humidity Control|Compressor|PU-Charge|PU-Credit|Min O/H Days|Free Days|Old /New|M/Date|Manufacturer|Handle On Charge";
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                      {Type:"Text",       Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		                      {Type:"Combo",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"" },
		                      {Type:"Popup",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",      KeyField:1,   CalcLogic:"",   Format:"" ,  UpdateEdit:0,   InsertEdit:0},
		                      {Type:"Combo",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mtrl_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Combo",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rf_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Combo",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"rf_humid_ctrl_val_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Text",       Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rf_cmpr_ctnt",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Float",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"pkup_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"pkup_chg_cr_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",        Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"min_onh_dys",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",        Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"free_dys",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Combo",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_old_van_flg",  KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"PopupEdit",  Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"ComboEdit",  Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Float",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lift_on_chrg",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                      {Type:"Text",       Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ieflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",       Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eeflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",       Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ceflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",       Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ueflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",       Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"heflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",       Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"teflg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetColProperty("cntr_mtrl_cd", {ComboText:"StainlessSteel|Steel(Unspecified)|Aluminium", ComboCode:"SS|SU|AL"} );
		               SetColProperty("cntr_old_van_flg", {ComboText:"OLD|NEW", ComboCode:"O|N"} );
		               SetShowButtonImage(2);
		               SetSheetHeight(350);
               		}
             break; 
         }
     }
     
     
 	
	/**
	 * setting combo initial values and header
	 * param : comboObj ==> combo object, sheetNo ==> combo object combo object no.
	 */
   	function initCombo(comboObj, comboNo) {
   		var formObj=document.form;
   	    switch(comboObj.options.id) {
   	        case "approval_no":
   	        	with(comboObj) {
 			   	    SetTitle("Auth No.|Old/New|TP/SZ|Auth Vol.|Pick-up Vol.|Pick-up Period|tpsz|pca|pcca|mod|locg|fdys|lonchg|spno|ppp|qqq");  
 			   	    SetTitleVisible(true);    
					SetColAlign(0, "left");
					SetColAlign(1, "center");
					SetColAlign(2, "center");
					SetColAlign(3, "right");
					SetColAlign(4, "right");
					SetColAlign(5, "center");
					SetColAlign(6, "center");
					SetColAlign(7, "center");
					SetColAlign(8, "center");
					SetColAlign(9, "center");
					SetColAlign(10, "center");
					SetColAlign(11, "center");
					SetColAlign(12, "center");
					SetColAlign(13, "center");
					SetColAlign(14, "center");
					SetColAlign(15, "center");
					SetColWidth(0, "150");
					SetColWidth(1, "65");
					SetColWidth(2, "50");
					SetColWidth(3, "80");
					SetColWidth(4, "80");
					SetColWidth(5, "160");
					SetColWidth(6, "-1");
					SetColWidth(7, "-1");
					SetColWidth(8, "-1");
					SetColWidth(9, "-1");
					SetColWidth(10, "-1");
					SetColWidth(11, "-1");
					SetColWidth(12, "-1");
					SetColWidth(13, "-1");
					SetColWidth(14, "-1");
					SetColWidth(15, "-1");
				    SetDropHeight(160);
   	            	SetMultiSelect(0);
   	            	SetMaxSelect(1);
	   	 	  		if (formObj.lstm_cd.value.length == 2) {
	   		  			if (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI"){
	   		  				SetBackColor("#D4F6FF");
	   		  			SetDisabledBackColor("#D4F6FF");
	   		  			} else {
	   		  				SetBackColor("#FFFFFF");
	   		  			SetDisabledBackColor("#FFFFFF");
	   		  			}
	   		  		} else {
	   		  			SetBackColor("#FFFFFF");
	   		  		    SetDisabledBackColor("#FFFFFF");
	   		  		}    	            	
   	            }
   	        	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
   	        	break;
   	    }
   	}      
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBCREATE:
            	comboObjects[0].SetSelectIndex(-1);
            	comboObjects[0].RemoveAll();
            	clearAGMTdata();
            break;	
            
            case IBSEARCH03:
            	formObj.f_cmd.value=SEARCH01;
            	ComOpenWait(false);
            	if(specSearchType == "") {
	 				var xml="";
	 				var param = "&sch_spec_no="+schSpecNo+"&sch_tpsz_cd="+schTpszCd;
	 				xml=sheetObj.GetSearchData("EES_MST_0022GS.do", FormQueryString(formObj)+param);

	 				var specstr=ComXmlString(xml, "cntr_spec_no");
	 				if(specstr == "" && schSpecNo !="") {
	 					ComShowCodeMessage("MST02042", schSpecNo);
	 					sheetObj.SetCellValue(schRow,"cntr_spec_no","");
	 				}
	 				schRow="";
	 				schSpecNo = "";
	 				schTpszCd = "";
	 				//ComOpenWait(false);
            	}else{
            		var xml="";
            		if(errSpecNoValue == schSpecNo) {
	 					specstrNull = true;		 					
	 					sheetObj.SetCellValue(schRow,"cntr_spec_no","");            			
            		} else {
                		if(prvSpecNoValue != schSpecNo && schSpecNo != "") {
    		 				var param = "&sch_spec_no="+schSpecNo+"&sch_tpsz_cd="+schTpszCd;
    		 				xml=sheetObj.GetSearchData("EES_MST_0022GS.do", FormQueryString(formObj)+param);
    		 				var specstr=ComXmlString(xml, "cntr_spec_no");
    		 				if(specstr == "") {
    		 					specstrNull = true;		
    		 					errSpecNoValue=schSpecNo;		    		 					
    		 					sheetObj.SetCellValue(schRow,"cntr_spec_no",""); 					
    		 				}else{
    		 					prvSpecNoValue = schSpecNo;
    		 				}
                		}            			
            		}
	 				
	 				schRow="";
	 				schSpecNo = "";
	 				schTpszCd = "";
	 				//ComOpenWait(false);
            	}
 				
            	break;
            
			case IBSEARCH:      //retrieve for Auth No.
				//comboObjects[0].SetSelectIndex(-1);
				comboObjects[0].RemoveAll();
			    clearAGMTdata();
			    sheetObj.SetWaitImageVisible(0);
			    ComOpenWait(true);			    
				formObj.f_cmd.value=SEARCH;
				var xml="";
				if (formObj.ctype.value == '2')
					xml=sheetObj.GetSearchData("EES_MST_0014GS.do", FormQueryString(formObj)+"&gubun=1")
				else
					xml=sheetObj.GetSearchData("EES_MST_0014GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				//Creation Type이 W/O Check Digit일 경우에는 Pick up Period와 상관없음
				//if(formObj.ctype.value != 1) {
					if(ComGetTotalRows(xml) == 0 && chkLeasTrm !="SH") {
						return;
					}
				//}
				if (xml.indexOf("ERROR") == -1 && xml.indexOf("Error") == -1){
					ComXml2ComboItem(xml, approval_no, "cntr_onh_auth_no", "cntr_onh_auth_no|new_van_tp_cd|cntr_tpsz_cd|onh_qty|pick_qty|pkup_due_dt|cntr_tpsz_cd|pkup_chg_amt|pkup_chg_cr_amt|min_onh_dys|" +
							"lift_on_chg|free_dys|lon_chg|cntr_spec_no");
				}else {
					sheetObj.LoadSearchData(xml,{Sync:1} );
				}
			break;
			
			case IBSEARCH01:
				formObj.f_cmd.value=SEARCH05;
				var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchData(sXml,{Sync:1} );
					 return;
				} 
				chkLeasTrm = "";
            	formObj.ref_no.value=ComXmlString(sXml, "ref_no");
            	formObj.lstm_cd.value=ComXmlString(sXml, "lstm_cd");
            	formObj.vndr_seq.value=ComXmlString(sXml, "vndr_seq");
            	formObj.vndr_nm.value=ComXmlString(sXml, "vndr_lgl_eng_nm");
            	
            	formObj.eff_dt.value=ComXmlString(sXml, "eff_dt");
            	formObj.exp_dt.value=ComXmlString(sXml, "exp_dt");
            	formObj.hid_free_dys.value=ComXmlString(sXml, "lse_free_dys");
            	
            	if(formObj.lstm_cd.value == "SH") {
            		chkLeasTrm = "SH";
            	}
            	
            	if (formObj.lstm_cd.value.length == 2) {
            		if (formObj.ctype.value == "1"){  //in case of W.O check digit 
    		  			if (!(formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SH" || formObj.lstm_cd.value == "MI")){
   					        ComShowCodeMessage("MST01003");
   					        formObj.agmt_seq.value="";
  		                    formObj.ref_no.value="";
		                    formObj.lstm_cd.value="";
		            	    formObj.vndr_seq.value="";
		            	    formObj.vndr_nm.value="";		
		     	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);		            	    
   					        ComSetFocus(formObj.agmt_seq);                                                		  				
   			  			    return;    		  				
    		  			}
            		}
            	}
            	if (formObj.lstm_cd.value.length == 2) {
		  			if (!(formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI" || formObj.lstm_cd.value == "SH")){  
				        ComShowCodeMessage("MST01003");
				        formObj.agmt_seq.value="";
		                formObj.ref_no.value="";
		                formObj.lstm_cd.value="";
		            	formObj.vndr_seq.value="";
		            	formObj.vndr_nm.value="";		
		 	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);		            	
				        ComSetFocus(formObj.agmt_seq);                                                		  				
		  			    return;	
		  			}
            	}
		  		if (formObj.lstm_cd.value.length == 2) {
		  			if (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI"){
		  				approval_no.SetBackColor("#D4F6FF");
		  				comboObjects[0].SetDisabledBackColor("#D4F6FF");
		  			} else {
		  				approval_no.SetBackColor("#FFFFFF");
		  				comboObjects[0].SetDisabledBackColor("#FFFFFF");
		  			}
		  		} else {
		  			approval_no.SetBackColor("#FFFFFF");
		  			comboObjects[0].SetDisabledBackColor("#FFFFFF");
		  		}
		  		if (formObj.ref_no.value == ""){
		  			formObj.agmt_cty_cd.value="HHO";
		  			formObj.agmt_seq.value="";
		  			ComSetFocus(formObj.agmt_seq);
		  		}
		  		if (formObj.ctype.value == "0" || formObj.ctype.value == "1"){
		 	        if (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" ||formObj.lstm_cd.value == "OF") {
		 	 	        ComBtnEnable("btn_loadexcel");
		 	 	    } else {
		 	 	        ComBtnDisable("btn_loadexcel");
		 	 	    }
		  		}else {
		  			ComBtnDisable("btn_loadexcel");
		  		}
		  		
		  		sheetObj.SetColProperty(0 ,"cntr_spec_no" , {KeyField:1});
		  		sheetObj.SetColBackColor("cntr_spec_no", "");
		  		sheetObj.SetColProperty(0 ,"mft_dt" , {KeyField:0});
		  		sheetObj.SetColBackColor("mft_dt", "");
		  		sheetObj.SetColProperty(0 ,"vndr_abbr_nm" , {KeyField:0});
		  		sheetObj.SetColBackColor("vndr_abbr_nm", "");		  		
		  		//if (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" ||formObj.lstm_cd.value == "SI") {
		  		if (formObj.lstm_cd.value == "LT") {
		  			sheetObj.SetColProperty(0 ,"cntr_spec_no" , {KeyField:1});
		  			sheetObj.SetColBackColor("cntr_spec_no", "#d4f6ff");
		  		}
		  		if (formObj.lstm_cd.value == "LT" || formObj.ctype.value == "2") {
		  			sheetObj.SetColProperty(0 ,"mft_dt" , {KeyField:1});
		  			sheetObj.SetColBackColor("mft_dt", "#d4f6ff");
		  			sheetObj.SetColProperty(0 ,"vndr_abbr_nm" , {KeyField:1});
		  			sheetObj.SetColBackColor("vndr_abbr_nm", "#d4f6ff");		  			
	  			}
            break;
            
			case IBSEARCH02 :
				if (formObj.sts_evnt_yd_cd.value != ""){
					formObj.f_cmd.value=SEARCH06;
					var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.sts_evnt_yd_cd.value+"&yd_chk_flg=N");
					var chk=sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					   return;
					}
	            	var codestr=ComXmlString(sXml, "code_nm");
	            	if (codestr == ""){
	            		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
	            		formObj.sts_evnt_yd_cd.value="";
	            		formObj.yd_cd_nm.value="";
	                	comboObjects[0].SetSelectIndex(-1);
	                	comboObjects[0].RemoveAll();
	            		ComSetFocus(formObj.sts_evnt_yd_cd);
	            	} else {
	            		formObj.yd_cd_nm.value=codestr;
	            		ComSetFocus(formObj.agmt_cty_cd);	            		
	            	}
				}
            break;
            
			case IBSAVE:        //save
				// hire date Setting
				formObj.hire_date.value = formObj.hire_date0.value.substr(0, 10)+" "+formObj.p_time.value;

			    if (sheetObj.RowCount()== 0){
			       ComShowCodeMessage("MST00001", "Row Add");
			       return;
			    }

			    for (var i=1; i <= sheetObj.RowCount(); i++){
			    	var lcntrno=sheetObj.GetCellValue(i, "cntr_no");
			    	if (formObj.ctype.value == "0" && lcntrno.trim().length != 11){
			    		sheetObj.SelectCell(i, "cntr_no");
			    		ComShowCodeMessage("MST02010");
			    		return;
			    	}
			    }
			    
		    	if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
				    if (Number(formObj.cntr_no3.value) > Number(formObj.approval_vol.value.replace(",","")) - Number(formObj.pick_up_vol.value.replace(",",""))){
					    ComShowCodeMessage("MST01012");
					    return;			    	
				    }
		    	}
		    	
		    	var leaseCd = formObj.lstm_cd.value;
		    	
				if(leaseCd == "LT" || leaseCd == "ST" || leaseCd == "SI" || leaseCd == "OF" || leaseCd == "MI" || leaseCd == "SH") {
			    	formObj.f_cmd.value=SEARCH23;
					sheetObj.SetWaitImageVisible(0);
					var str_agmt_seq = formObj.agmt_seq.value;
					var chk_date = formObj.hire_date.value;
					
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj)+"&sch_date="+chk_date+"&sch_agmt_no="+str_agmt_seq);
					sheetObj.SetWaitImageVisible(1);
	
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "check_date_yn") != undefined && ComGetEtcData(sXml, "check_date_yn") != "") {
							if(ComGetEtcData(sXml, "check_date_yn") == "N") {
								ComShowCodeMessage("MST02044");
								return false;
							}
						} 
					}
				}
		    	
			    sheetObjects[1].RemoveAll();
			    if ((formObj.lstm_cd.value.length == 2 &&  (formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI")) ||	
			    	    approval_no.GetBackColor()== "#D4F6FF"){
			    	if (approval_no.GetSelectText().trim().length == 0){
			    	   ComShowCodeMessage("MST00001", "Approval No");
			    	   ComSetFocus(approval_no);
			      	   return;
			    	}
			    }
			    for(var i=0; i <= sheetObj.RowCount(); i++){
				    if (formObj.lstm_cd.value == "LT" || formObj.ctype.value == "2"){				    	
				    	if (sheetObj.GetCellValue(i, "mft_dt") == ""){
					    	ComShowCodeMessage("MST01011");
					    	sheetObj.SelectCell(i, "mft_dt");
				    		return;
				    	}
					    if (sheetObj.GetCellValue(i, "vndr_abbr_nm") == ""){
					    	ComShowCodeMessage("MST00001", "Manufacturer");
					    	sheetObj.SelectCell(i, "vndr_abbr_nm");
				    		return;
				    	}				    	
			        }
				    
				    if (formObj.lstm_cd.value == "LT") {
					    if (sheetObj.GetCellValue(i, "cntr_spec_no") == ""){
					    	ComShowCodeMessage("MST00001", "Spec No");
					    	sheetObj.SelectCell(i, "cntr_spec_no");
				    		return;
				    	}
				    }
			    }
			    
			    
			    if (formObj.ctype.value == 2){ //serial range
			    	if (formObj.cntr_no0.value == "" || formObj.cntr_no1.value == "" || formObj.cntr_no2.value == ""){
			    		ComShowCodeMessage("MST01009");
			    		if (formObj.cntr_no0.value == "")
			    			ComSetFocus(formObj.cntr_no0);
			    		else if (formObj.cntr_no1.value == "")
			    			ComSetFocus(formObj.cntr_no1);
			    		else if	(formObj.cntr_no2.value == "")
			    			ComSetFocus(formObj.cntr_no2);
			    		return;
			    	}
			    	
			    	sheetObj.SetColProperty(0,"cntr_no", {KeyField:0});
			    }else{
			    	sheetObj.SetColProperty(0,"cntr_no", {KeyField:1});
			    }
			    
			    if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
				    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObj.RowCount()) {
				       ComShowCodeMessage("MST01012");
				       return;
				    }
			    }   
			    
        		var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		var arrRow=dupRows.split(",");
		        if (dupRows != ""){
		        	ComShowCodeMessage("MST00002", sheetObj.GetCellValue(arrRow[0],3)+","+sheetObj.GetCellValue(arrRow[0],4)+","+sheetObj.GetCellValue(arrRow[0],5));
		             for (var i=1; i <= sheetObj.RowCount()+1; i++){
		            	 if (sheetObj.GetCellValue(i,"cntr_no")   == sheetObj.GetCellValue(arrRow[0],"cntr_no")){
		       			     sheetObj.SelectCell(i, "cntr_no", true);
		       			     break;
		            	 }
		             }
	       			 return;				        	
		        }
		        sheetObj.SetWaitImageVisible(0);
		    	formObj.f_cmd.value=MULTI;
		    	ComOpenWait(true);
		    	setTimeout( function () {
	     	        var sParam=ComGetSaveString(sheetObjects[0]);
	     	        if (sheetObj.IsDataModified()){
	     	           sParam += "&" + FormQueryString(formObj);
	     	           
	     	        }
	     	        var sXml=sheetObj.GetSaveData("EES_MST_0014GS.do", sParam);
					var chk=sXml.indexOf("(null)");
					if (chk != -1) return;
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						return;
					} 				
					//inserting success
					var iesuc=0; 
					//inserting failure
					var iefal=0;
					//modifying success
					var uesuc=0;
					//modifying failure
					var uefal=0;
					//failcnt
					var failcnt=0;
					var failflg=false;
					var cerr=0;
					var cerr1=0;
					var derr=0;
					var eerr=0;
					var herr=0;
					//var msg=ComXmlStringOfItmCnt(sXml, "cntr_no", 0);
					//if (msg == "") return;
					sheetObjects[1].LoadSaveData(sXml);
					var sheetcnt=1;
					//color rollback
					for (var i=1; i <= sheetObj.RowCount()+1; i++){
						setsheetRowColorBlack(i);				
					}				
					for (var i=1; i <= sheetObj.RowCount(); i++){
						if (sheetObjects[1].GetCellValue(sheetcnt, "ceflg") == "E"){
							sheetObj.SetCellValue(i,"ceflg","");
							sheetObj.SetCellFontColor(i,"cntr_no","#FF0000");
							sheetObj.SetRowStatus(i,"I");
							cerr=cerr + 1;
							failflg=true;
					    }
						if (sheetObjects[1].GetCellValue(sheetcnt, "ceflg") == "B"){
							sheetObj.SetCellValue(i,"ceflg","");
							setsheetRowColorRed(i);
							sheetObj.SetRowStatus(i,"I");
							cerr1=cerr1 + 1;
							failflg=true;
					    }					    
						if (sheetObjects[1].GetCellValue(sheetcnt, "eeflg") == "E"){
							sheetObj.SetCellValue(i,"eeflg","");
							setsheetRowColorRed(i);
							sheetObj.SetRowStatus(i,"I");
							eerr=eerr + 1;
							failflg=true;
					    }
						if (sheetObjects[1].GetCellValue(sheetcnt, "heflg") == "E"){
							sheetObj.SetCellValue(i,"heflg","");
							setsheetRowColorRed(i);
							sheetObj.SetRowStatus(i,"I");
							herr=herr + 1;
							failflg=true;
					    }
					    if (failflg == true) failcnt=failcnt + 1;
					    failflg=false;
					    if ( sheetObjects[1].GetCellValue(sheetcnt, "ieflg") == "E" || sheetObjects[1].GetCellValue(sheetcnt, "ueflg") == "E" ){
							sheetObj.SetCellValue(i,"ceflg","");
							sheetObj.SetCellValue(i,"eeflg","");
							sheetObj.SetCellValue(i,"heflg","");
							sheetObj.SetCellValue(i,"ieflg","");
							sheetObj.SetCellValue(i,"ueflg","");
							setsheetRowColorRed(i);
							sheetObj.SetRowStatus(i,"I");
							if (sheetObjects[1].GetCellValue(sheetcnt, "ieflg") == "E"){
							   iefal=iefal + 1;
							} else {
							   uefal=uefal + 1;
							}	
					    } else if ( 
					    		sheetObjects[1].GetCellValue(sheetcnt, "ceflg") != "E" &&
					    		sheetObjects[1].GetCellValue(sheetcnt, "eeflg") != "E" &&
					    		sheetObjects[1].GetCellValue(sheetcnt, "heflg") != "E" &&
					    		sheetObjects[1].GetCellValue(sheetcnt, "ieflg") != "E" &&
					    		sheetObjects[1].GetCellValue(sheetcnt, "ueflg") != "E" &&
					    		sheetObjects[1].GetCellValue(sheetcnt, "ceflg") != "B"){
							sheetObj.SetRowStatus(i,"R");
							iesuc=iesuc + 1;
					    }
					    sheetcnt=sheetcnt + 1; 
					}
					var sMsg="";
					if (iesuc > 0){
						sMsg=ComGetMsg("MST01025", "", "", "");
					}				
					if (iefal > 0 || uefal > 0){
						sMsg=sMsg + ComGetMsg("MST02008", "", "", "");
					}
					if (cerr > 0){
						sMsg=sMsg + ComGetMsg("MST02003", "", "", "");
					}
					if (cerr1 > 0){
						sMsg=sMsg + ComGetMsg("MST02009", "", "", "");
					}
					if (eerr > 0){
						sMsg=sMsg + ComGetMsg("MST02004", "", "", "");
					}
					if (herr > 0){
						sMsg=sMsg + ComGetMsg("MST02005", "", "", "");
					}				
					if (derr > 0){
						sMsg=sMsg + ComGetMsg("MST02006", "", "", "");
					}
					var lcheckerr=0;
					for (var i=1; i <= sheetObj.RowCount(); i++){
						if (sheetObj.GetRowStatus(i) == "R"){
						   sheetObj.SetCellEditable(i,"cntr_no",0);
				           sheetObj.SetCellEditable(i,"eq_tpsz_cd",0);
				           sheetObj.SetCellEditable(i,"cntr_mtrl_cd",0);
				           sheetObj.SetCellEditable(i,"pkup_chg_amt",0);
				           sheetObj.SetCellEditable(i,"pkup_chg_cr_amt",0);
				           sheetObj.SetCellEditable(i,"min_onh_dys",0);
				           sheetObj.SetCellEditable(i,"free_dys",0);
				           sheetObj.SetCellEditable(i,"cntr_old_van_flg",0); 
				           sheetObj.SetCellEditable(i,"mft_dt",0);
				           sheetObj.SetCellEditable(i,"vndr_abbr_nm",0);
				           sheetObj.SetCellEditable(i,"lift_on_chrg",0);
				           
				           sheetObj.SetCellEditable(i,"rf_tp_cd",0);
				           sheetObj.SetCellEditable(i,"rf_humid_ctrl_val_cd",0);
				           sheetObj.SetCellEditable(i,"rf_cmpr_ctnt",0);
					   } else {
						   lcheckerr=lcheckerr + 1;
					   }
					}
					sheetObj.ColumnSort("ibflag|cntr_no");
					if (lcheckerr != 0){
		 	        	ComBtnEnable("btn_save");
		 	        } else {
		 	        	ComBtnDisable("btn_save");
		 	        	ComBtnDisable("btn_add");    
		 	        	ComBtnDisable("btn_delete");
					}
					ComOpenWait(false);
					ComShowMessage (sMsg);
					if (formObj.ctype.value == "2" && (iefal > 0 || failcnt > 0 || cerr > 0 || eerr > 0 || herr > 0 || derr > 0 || cerr1 > 0)){
						formObj.cntr_no0.value="";
						formObj.cntr_no1.value="";
						formObj.cntr_no2.value="";
						formObj.cntr_no3.value="";
						formObj.cntr_no0.readOnly=false;
						formObj.cntr_no1.readOnly=false;
						formObj.cntr_no2.readOnly=false;
						ComSetFocus(formObj.cntr_no0);
						ComBtnEnable("btn_save");
					}
					if (iefal > 0 || failcnt > 0 || cerr > 0 || eerr > 0 || herr > 0 || derr > 0 || cerr1 > 0){
					}else{
						ComBtnDisable("btn_add");    
						ComBtnDisable("btn_copy");
					}
					
		    	 } , 100);
		    	ComOpenWait(false);
				sheetObj.SetWaitImageVisible(0);
			break;
			
			case IBINSERT:      // inserting
			    if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
				    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObj.RowCount() +1) {
				       ComShowCodeMessage("MST02002");
				       return;
				    }
			    } 
			    if ((formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI") && approval_no.GetSelectIndex() == -1) {
	     		    ComShowCodeMessage("MST01007");
         		    ComSetFocus(approval_no);
					return;
				}
	            if ((approval_no.GetBackColor() ==  "#FFFFFF" ||
	            	(approval_no.GetBackColor() == "#D4F6FF" && approval_no.GetSelectIndex() != -1)) &&
	            	formObj.sts_evnt_yd_cd.value.length > 0 &&
	            	formObj.agmt_cty_cd.value.length > 0 &&
	            	formObj.agmt_seq.value.length > 0 &&
	            	formObj.ctype.value.length > 0 &&
	            	formObj.hire_date0.value.length > 0){
					    if (formObj.ctype.value == "2"){
					    	if (formObj.cntr_no0.value.length == 4 && 
					    		formObj.cntr_no1.value.length == 6 &&
					    		formObj.cntr_no2.value.length == 6){
					    		if (sheetObj.RowCount() > 0 && window.event.srcElement.getAttribute("name") == "btn_copy"){
					    			sheetObj.GetCellValue(sheetObj.GetSelectRow(),"del_chk") = "1";
								    for (idx=0; idx<formObj.mk_cnt.value; idx++){ 
								    	sheetObj.Copy2SheetCol(sheetObj,"3|4|10|11|12","3|4|10|11|12",-1,-1,-1, 2,false,false,"1");
								    	setInsMode();
								    }
								    for (i = 1; i <= sheetObj.RowCount(); i++){ 
								        sheetObj.GetSelectCell(i, 0, false);  // Bold 해제
								    }
							    	sheetObj.CheckAll(1) = 0;
                                }else{
                                        for (idx=0; idx<formObj.mk_cnt.value; idx++){ 
                                            sheetObj.DataInsert();
                                            setInsAddMode();
                                        }
                                }

//							    sheetObj.DataInsert();
//							    setInsMode();
							    ComBtnDisable("btn_add");
							    ComBtnDisable("btn_loadexcel");
							    ComBtnDisable("btn_delete");
							    rcnt=rcnt + 1;
							    
					    	} else {
					    		ComShowCodeMessage("MST00001", "CNTR Serial Range");
					    		if (formObj.cntr_no0.value.length != 4)
							    	ComSetFocus(formObj.cntr_no0);
					    		else if (formObj.cntr_no1.value.length != 6)
					    			ComSetFocus(formObj.cntr_no1);
					    		else if (formObj.cntr_no2.value.length != 6)
					    			ComSetFocus(formObj.cntr_no2);
					    	} 
					    } else {
					    	
							   if (sheetObj.RowCount() > 0 && window.event.srcElement.getAttribute("name") == "btn_copy"){
							    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "del_chk", "1");
								    for (idx=0; idx<formObj.mk_cnt.value; idx++){ 
//								        sheetObj.Copy2SheetCol(sheetObj,"3|4|10|11|12","3|4|10|11|12",-1,-1,-1, 2,false,false,"1");
								        sheetObj.DataCopy(sheetObj.GetSelectRow());
								        setInsMode();
								    }
								    for (i = 1; i <= sheetObj.RowCount(); i++){ 
//								        sheetObj.GetSelectCell(i, 0, false);  // Bold 해제
								        sheetObj.SetCellValue(i, 0, "0");
								    }
//							    	sheetObj.CheckAll(1) = 0;
							   }else{
								    for (idx=0; idx<formObj.mk_cnt.value; idx++){ 
								    	sheetObj.DataInsert();
								    	setInsAddMode();
								    }
							   }					    	
					    	
//						   sheetObj.DataInsert();
//						   setInsMode();
						   rcnt=rcnt + 1;
					    }	 								   
	            } else {
		        	if (formObj.ctype.value.length == 0)
		        		ComShowCodeMessage("MST00001", "Creation Type")
		        	else if (formObj.hire_date0.value.length == 0)
		        		ComShowCodeMessage("MST00001", "On-hire Date")	            	
		        	else if (approval_no.GetSelectIndex() == -1)
		            	ComShowCodeMessage("MST00001", "Auth No.")
		            else if (formObj.sts_evnt_yd_cd.value.length == 0)
		            	ComShowCodeMessage("MST00001", "On Hire Yard")
		            else if (formObj.agmt_cty_cd.value.length == 0)   
		            	ComShowCodeMessage("MST00001", "AGMT No.")
		            else if (formObj.agmt_seq.value.length == 0)	
		            	ComShowCodeMessage("MST00001", "AGMT No.");
		            return;
	            }
			break;
			
            case IBSEARCH_ASYNC01://sheet Combo data
	   	 	   formObj.f_cmd.value=SEARCH01;
	   	 	   var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&vndr_seq=");
			   var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:0} );
				   return;
			   }
	   	  	   var cols=ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
	   	  	   var strText = cols[1].substr()
	   	  	   sheetObj.SetColProperty("vndr_abbr_nm", {ComboText:cols[1], ComboCode: cols[0]} );
            break; 	
            
            case IBSEARCH_ASYNC02://sheet Combo data
     	 	   formObj.f_cmd.value=SEARCH02;
    	 	   var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd=U");
    		   var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:0} );
				   return;
			   }    	  	   
    	  	   var cols=ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
    	  	   sheetObj.SetColProperty("eq_tpsz_cd", {ComboText:cols[0], ComboCode:cols[0]} );
            break;
            
			case IBDELETE:      // deleting
   	   		if (sheetObj.id == 'sheet1') {  
   	   			sheetObj.SelectFontBold=false;
	   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj,"del_chk"); 
					sheetObj.SelectFontBold=true;
					rcnt=sheetObj.RowCount();
				} else {     
				}
			}    			
		    break;
		    
			case SEARCH08:      //Unit Type combo retrieve
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH08;
				var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(xml, "unit_type").split("|");//array
				var name=" ";
				var code=" ";
				for ( var i=0; i < comboItems.length; i++) {
			 		var comboItem=comboItems[i].split(",");
					name=name + "|" + comboItem[1];
					code=code + "|" + comboItem[0];
			 	}
				sheetObj.SetColProperty("rf_tp_cd", {ComboText:name, ComboCode:code} );
				ComOpenWait(false);
			break;
         }
     }
    
    
    function  sheet1_OnSaveEnd(sheetObj, errMsg){
		
	}
    
    /**
     * handling process for input validation
     */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
     function setsheetRowColorBlack(cnt){
    	 var formObj=document.form;    	 
    	 sheetObjects[0].SetCellFontColor(cnt,1,"#000000");
         if (formObj.ctype.value != "2"){     	 
        	 sheetObjects[0].SetCellFontColor(cnt,2,"#000000");
         }
         sheetObjects[0].SetCellFontColor(cnt,3,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,4,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,5,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,6,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,7,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,8,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,9,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,10,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,11,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,12,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,13,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,14,"#000000");
         sheetObjects[0].SetCellFontColor(cnt,15,"#000000");
     }
     function setsheetRowColorRed(cnt){
    	 var formObj=document.form; 
    	 sheetObjects[0].SetCellFontColor(cnt,1,"#FF0000");
    	 if (formObj.ctype.value != "2"){  
    		 sheetObjects[0].SetCellFontColor(cnt,2,"#FF0000");
    	 }
    	 sheetObjects[0].SetCellFontColor(cnt,3,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,4,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,5,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,6,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,7,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,8,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,9,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,10,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,11,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,12,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,13,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,14,"#FF0000");
    	 sheetObjects[0].SetCellFontColor(cnt,15,"#FF0000");
     }     
     /**
     * event clicking pop-up button on ibsheet
     */
     function sheet1_OnPopupClick(sheetObj, Row,Col,Value)
     {
         var sName=sheetObj.ColSaveName(Col);
   		var formObj=document.form;
   		
   		switch (sName) {
   			case "mft_dt" :
   				var cal=new ComCalendarGrid("myCal");
   				cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
   				break;
   			case "cntr_spec_no":
   				/* Delivery Location Pop-up */
   				//openPopupPage("6", Row, Col, 0);
   				
				var own_cntr_flg="";
				if ( formObj.lstm_cd.value == "OW" || formObj.lstm_cd.value == "LP" || formObj.lstm_cd.value == "OL" ) {
					own_cntr_flg="O";
				} else if(formObj.lstm_cd.value == "SH" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI" || formObj.lstm_cd.value == "OF" ) {
					own_cntr_flg="S";
				} else if(formObj.lstm_cd.value == "ST") {
					own_cntr_flg="T";
				} else {
					own_cntr_flg="L";
				}
				var cntr_tpsz_cd=sheetObjects[0].GetCellValue(Row, "eq_tpsz_cd");
				if ( cntr_tpsz_cd == "" ) {
					ComShowCodeMessage("MST02040");
					sheetObjects[0].SelectCell(Row, "cntr_tpsz_cd");
					return;
				}
				var strvndr_seq = formObj.vndr_seq.value;
				var strvndr_lgl_eng_nm = formObj.vndr_nm.value;
				if(strvndr_seq == "") {
					ComShowCodeMessage("MST02038");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				if(own_cntr_flg=="S") {
					strvndr_seq ="";
					strvndr_lgl_eng_nm = "";
				}
				ComOpenPopup('/opuscntr/EES_MST_0022_POP.do?own_cntr_flg='+own_cntr_flg+'&cntr_tpsz_cd='+cntr_tpsz_cd+'&active_flag=3'+'&strVndrSeq='+strvndr_seq+'&strVndrNm='+strvndr_lgl_eng_nm + '&lstm_cd='+formObj.lstm_cd.value, 1250, 650, 'setPopData_CntrSpecNo', '0,0', false, false, Row, Col, "0");
			
   			break;
   	 	}
     }
     
     /**
 	 * Container Spec No. Pop-up Return Value handling<br>
 	 * @param {arry} returnedValues Pop-up page Return value array
 	 * @param Row Row index
 	 * @param Col Col index
 	 * @param IBSheet Sheet Array index
 	 */
 	function setPopData_CntrSpecNo(aryPopupData, Row, Col, sheetIdx) {
 		var formObj=document.form;
 		if ( aryPopupData.length > 0 ) {
 			with(sheetObjects[sheetIdx]) {
 				var sName=ColSaveName(Col);
 				switch(sName) {
 					case "cntr_spec_no":
 						if(formObj.lstm_cd.value == "SH" || formObj.lstm_cd.value == "SI" || formObj.lstm_cd.value == "MI" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "ST") {
 							SetCellValue(Row,Col,aryPopupData[0][2],0);
 						} else {
 	 						if ( ComTrim(ComGetObjValue(formObj.vndr_seq)) == ComTrim(aryPopupData[0][7]) ) {
 	 							SetCellValue(Row,Col,aryPopupData[0][2],0);
 	 						} else {
 	 							ComShowCodeMessage("MST02039");
 	 							SelectCell(Row, Col);
 	 						}							
 						}

 						break;
 				}
 			}
 		}
 	}
 	
     function sheet1_OnChange(sheetObj, Row,Col, Value)
     {
    	 var savename=sheetObj.ColSaveName(Col);
    	 if(savename == "cntr_old_van_flg"){
    		 if (sheetObj.GetCellValue(Row,"cntr_old_van_flg") == "N"){
    			 sheetObj.SetCellEditable(Row,"lift_on_chrg",0);
    			 sheetObj.SetCellValue(Row, "lift_on_chrg","");
    		 } else {
    			 sheetObj.SetCellEditable(Row,"lift_on_chrg",1);
    		 }
    	 }
         else if (savename == "vndr_abbr_nm"){
             var sText=sheetObj.GetComboInfo(Row, Col, "Text");
           	 var arrText=sText.split("|");
             var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
             if(idx != -1){
            	 var tmparrtxt=arrText[idx].substring(0, 6);
                 sheetObj.SetCellValue(Row, "vndr_abbr_nm",tmparrtxt);
             }
         }    
         else if(savename == "cntr_spec_no") {
        	 var formObject = document.form;
        	 schSpecNo=sheetObj.GetCellValue(Row,Col);
        	 schTpszCd=sheetObj.GetCellValue(Row,"eq_tpsz_cd");
        	 schRow=Row;
        	 specSearchType = "";
        	 if(schSpecNo!="") doActionIBSheet(sheetObj,document.form,IBSEARCH03);
         }
     }     
     
     function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	 var savename=SheetObj.ColSaveName(Col);
         if (savename == "pkup_chg_amt"){
        	 if(SheetObj.GetCellEditable(Row,"pkup_chg_cr_amt") == true ||
        		SheetObj.GetCellEditable(Row,"pkup_chg_amt") == true){
         	    if (KeyCode != 9)
          	       SheetObj.SetCellValue(Row,"pkup_chg_cr_amt",0);
        	 }
         }
         else if (savename == "pkup_chg_cr_amt"){
        	 if(SheetObj.GetCellEditable(Row,"pkup_chg_cr_amt") == true ||
             	SheetObj.GetCellEditable(Row,"pkup_chg_amt") == true){
        		 if (KeyCode != 9)
        	    SheetObj.SetCellValue(Row,"pkup_chg_amt",0);
        	 }
         }
     }
     /**
     *  save시 validation check
     */
     function sheet1_OnValidation(Row,Col,Value){
     }

     function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
    	 if(isExceedMaxRow(msg))return;
    	 
	    if(result) {
	    	//ComOpenWait(true);
	    	var formObj = document.form;
	    	if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
			    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObj.RowCount()) {
			       ComShowCodeMessage("MST02002");
			       sheetObj.RemoveAll();
			       return;
			    }
		    } 
	    	
		    for(var i=1; i <= sheetObj.RowCount(); i++){
		    	setCntInsMode(i);
		    	
	        	var formObject = document.form;
	        	schSpecNo=sheetObj.GetCellValue(i,"cntr_spec_no");
	        	schTpszCd=sheetObj.GetCellValue(i,"eq_tpsz_cd");
	        	schRow=i;
	        	specSearchType = "Excel";
	        	doActionIBSheet(sheetObj,document.form,IBSEARCH03);
		    }
		    
		    if(specstrNull == true) {
		    	ComShowCodeMessage("MST02041");
		    	return;
		    }
		    
		    //ComOpenWait(false);
	     } 
	 }

     function func_calendar(){
        var formObj=document.form; 
        if (formObj.hire_date0.readOnly == false){    	 
	       var cal=new ComCalendar();
	       cal.select(document.form.hire_date0, "yyyy-MM-dd");
        } 
     }
     


     /**
 	 * handling Form Element Clear <br>
 	 * @param fieldName
 	 */
 	 function clearForm(fieldName){
 		 var formObj=document.form;
 		 switch(fieldName) {
 			case "vndr_seq":
 				ComSetObjValue(formObj.vndr_seq, "");
 				ComSetObjValue(formObj.vndr_nm,  "");
 				break;
 		 }
 	 }
  	 /**
	 * checkign mandatory
	 */
	 function checkSerItem(formObj){
		if (formObj.ctype.value == "2"){
			if (formObj.cntr_no0.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no0);
				formObj.cntr_no3.value="";
				return false;
			}
			if (formObj.cntr_no1.value.trim().length == 0 ) {
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no1);
				formObj.cntr_no3.value="";				
				return false;
			} 
			if (formObj.cntr_no2.value.trim().length == 0 ) {
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no2);
				formObj.cntr_no3.value="";				
				return false;
			}
			if (formObj.cntr_no1.value.trim() > formObj.cntr_no2.value.trim()){
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no1);				
				formObj.cntr_no3.value="";
				return false;
			}
			if(eval(formObj.cntr_no3.value) < 1){
				ComShowCodeMessage("MST01022");
				formObj.cntr_no3.value="";
				return false;
			}
		}
		return true;
	 }
    /**
    * range_change
    */  
	function range_change1(){
		var formObj=document.form;
		var fm_ser_no=formObj.cntr_no1.value.trim();
		formObj.cntr_no3.value='';
		if(formObj.cntr_no1.value.trim().length > 0){
			if(formObj.cntr_no1.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.cntr_no1.value.trim());
				ComSetFocus(formObj.cntr_no1);
				return;
			}
			if(!ComIsNumber(formObj.cntr_no1)){
				ComShowCodeMessage("MST01019", formObj.cntr_no1.value.trim());
				ComSetFocus(formObj.cntr_no1);
				return;
			}
		}
		getRangeCount();
	}
	
	function range_change2(){
		var formObj=document.form;
		formObj.cntr_no3.value='';
		if(formObj.cntr_no2.value.trim().length > 0){
			if(formObj.cntr_no2.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.cntr_no2.value.trim());
				ComSetFocus(formObj.cntr_no2);
				return;
			}
		}
		if(formObj.cntr_no2.value.trim().length > 0){
			if(!ComIsNumber(formObj.cntr_no2)){
				ComShowCodeMessage("MST01019", formObj.cntr_no2.value.trim());
				ComSetFocus(formObj.cntr_no2);
				return;
			}
		}
		getRangeCount();
	}	
	
	function getRangeCount(){
		var formObj=document.form;
		var fm_no=formObj.cntr_no1.value.trim();
		var to_no=formObj.cntr_no2.value.trim();
		if(formObj.cntr_no1.value.trim().length != 6) return;
		if(formObj.cntr_no2.value.trim().length != 6) return;
		var change_count=String(to_no - fm_no + 1);
		if(eval(change_count) < 1){		
			formObj.cntr_no3.value="";
		} else {
			formObj.cntr_no3.value=change_count;
			var sheetObject1=sheetObjects[0];
			if (sheetObject1.RowCount()== 0)
			   doActionIBSheet(sheetObject1, formObj, IBINSERT);
		    if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
			    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObject1.RowCount()) {
			    } else {
			    	//in case of Serial Range, New
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),"cntr_old_van_flg","N",0);
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),"cntr_no","");
					sheetObject1.GetCellFontColor(sheetObject1.SetSelectRow,"cntr_no","#FFFFFF");
			    }
		    } else {
		    	//in case of Serial Range, New
		    	if (sheetObject1.RowCount()> 0){
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),"cntr_old_van_flg","N",0);
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),"cntr_no","");
					sheetObject1.GetCellFontColor(sheetObject1.SetSelectRow,"cntr_no","#FFFFFF");
		    	}
		    }			
		}
		if(eval(change_count) < 1){
			ComShowCodeMessage("MST01022");
			ComSetFocus(formObj.cntr_no1);
			return;
		}
	}
	/*
	* handling event approval_no OnChange 
	*/
	//function approval_no_OnChange(comboObj,Index_Code, Text){
	function approval_no_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){
		newindex = parseInt(newindex, 10);
		var formObj=document.form;
		//var arrXml=Text.split("|");
		var strPickUpPeriod               = comboObj.GetText(newindex,5).split("~");
		formObj.pkup_fm_dt.value          = strPickUpPeriod[0]; 
		formObj.pick_up_due_date.value    = strPickUpPeriod[1];
		formObj.approval_vol.value        = comboObj.GetText(newindex,3).trim(); 
		formObj.pick_up_vol.value         = comboObj.GetText(newindex,4).trim(); 
		formObj.hid_min_onh_dys.value     = comboObj.GetText(newindex,9).trim();
		formObj.hid_pkup_chg_cr_amt.value = comboObj.GetText(newindex,8).trim(); 
		formObj.hid_pkup_chg_amt.value    = comboObj.GetText(newindex,7).trim(); 
		formObj.hid_tp_sz.value           = comboObj.GetText(newindex,6).trim(); 
		formObj.hid_old_new.value         = comboObj.GetText(newindex,1).trim(); 
		
		
		
		//in case of Short Term, OLD, show data. else setting "0" 
		if ((formObj.lstm_cd.value == "ST" || formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI")	&& formObj.hid_old_new.value.substring(0,1) == "O"){
		   formObj.hid_lift_on_chrg.value=comboObj.GetText(newindex,10).trim(); 
		}
		formObj.hid_free_dys.value=comboObj.GetText(newindex,11).trim(); 
		
		if (comboObj.GetText(newindex,12).trim() != ""){
			formObj.hid_lift_on_chrg.value=comboObj.GetText(newindex,12).trim(); 
		}
		formObj.hid_cntr_spec_no.value=comboObj.GetText(newindex,13).trim(); 
		formObj.cntr_no0.value="";
		formObj.cntr_no1.value="";
		formObj.cntr_no2.value="";
		formObj.cntr_no3.value="";
	}	
	
	function clearAGMTdata(){
		var formObj=document.form;
		formObj.approval_vol.value="";
		formObj.pick_up_vol.value="";
		formObj.pkup_fm_dt.value="";
		formObj.pick_up_due_date.value="";
		formObj.hid_min_onh_dys.value="";
		formObj.hid_pkup_chg_cr_amt.value="";
		formObj.hid_pkup_chg_amt.value="";
		formObj.hid_tp_sz.value="";
		formObj.hid_lift_on_chrg.value="";
		formObj.hid_cntr_spec_no.value="";
	} 
	
	function toDateString() { //formatTime(date)
		var now=new Date();
	    var year=now.getFullYear();
	    var month=now.getMonth() + 1; // cause jan=0,dec=11
	    var day=now.getDate();
	    if (("" + month).length == 1) { month="0" + month; }
	    if (("" + day).length   == 1) { day="0" + day;   }
	    return ("" + year+ "-" + month + "-" + day);
	}
	
	function initCntr(){
		var formObj=document.form;
		formObj.ctype.value="0";
		formObj.hire_date0.value=ComGetNowInfo("ymd");
		formObj.sts_evnt_yd_cd.value="";
		formObj.agmt_cty_cd.value="HHO";
		formObj.agmt_seq.value="";
		formObj.lstm_cd.value="";
		formObj.vndr_seq.value="";
		formObj.vndr_nm.value="";
		formObj.ref_no.value="";
		comboObjects[0].SetSelectIndex(-1,false);
		comboObjects[0].RemoveAll();
		formObj.approval_vol.value="";
		formObj.pick_up_vol.value="";
		formObj.pkup_fm_dt.value="";
		formObj.pick_up_due_date.value="";
		formObj.cntr_no0.value="";
		formObj.cntr_no1.value="";
		formObj.cntr_no2.value="";
		formObj.cntr_no3.value="";
		formObj.hid_old_new.value="";
		formObj.mk_cnt.value = "1";
		formObj.hid_tp_sz.value="";
		formObj.hid_app_vol.value="";
		formObj.hid_pick_vol.value="";
		formObj.hid_pick_date.value="";
		formObj.hid_min_onh_dys.value="";
		formObj.hid_pkup_chg_cr_amt.value="";
		formObj.hid_pkup_chg_amt.value="";
		formObj.hid_lift_on_chrg.value="";
		formObj.hid_lift_on_chrg.value="";
		formObj.hid_cntr_spec_no.value="";
		formObj.hid_free_dys.value="";
		formObj.yd_cd_nm.value="";
		approval_no.SetBackColor("#FFFFFF");
		ComBtnEnable("btn_add");
		ComBtnEnable("btn_loadexcel");
		ComBtnEnable("btn_delete");
		ComBtnEnable("btn_save");
		document.getElementById("cntr_no0").className="input2";
		document.getElementById("cntr_no1").className="input2";
		document.getElementById("cntr_no2").className="input2";
		formObj.cntr_no0.readOnly=true;
		formObj.cntr_no1.readOnly=true;
		formObj.cntr_no2.readOnly=true;
		rcnt=0;
	}
	
	function setreadOnly(){
		var formObj=document.form;		
        formObj.ctype.disabled=true;
        formObj.hire_date0.readOnly=true;
        formObj.p_time.readOnly=true;
        formObj.sts_evnt_yd_cd.readOnly=true;
        formObj.agmt_cty_cd.readOnly=true;
        formObj.agmt_seq.readOnly=true;
        comboObjects[0].SetEnable(0);
	}
	
	function setnotreadOnly(){
		var formObj=document.form;		
        formObj.ctype.disabled=false;
        formObj.hire_date0.readOnly=false;
        formObj.p_time.readOnly=false;
        formObj.sts_evnt_yd_cd.readOnly=false;
        formObj.agmt_cty_cd.readOnly=true;
        formObj.agmt_seq.readOnly=false;
        comboObjects[0].SetEnable(1);
	}
	
	function setInsMode(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
    	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"vndr_abbr_nm","");
		
	    if (approval_no.GetSelectIndex() != -1){
        	 sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_cr_amt");
        	 sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_amt");
	    }	
	    
    	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"eq_tpsz_cd","");
    	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_mtrl_cd","");
    	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_old_van_flg","");
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "pkup_chg_cr_amt","",0 );
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "pkup_chg_amt","",0);
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "min_onh_dys");
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "free_dys");
        //sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "lift_on_chrg","",0);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "pkup_chg_cr_amt",99999.99);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "pkup_chg_amt",99999.99);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "min_onh_dys",99999);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "free_dys",99999);
        //sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "lift_on_chrg", 999999);
        // setting default value
        if (approval_no.GetSelectIndex() != -1){
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"eq_tpsz_cd",formObj.hid_tp_sz.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"eq_tpsz_cd",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"pkup_chg_amt",formObj.hid_pkup_chg_amt.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_amt",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",formObj.hid_pkup_chg_cr_amt.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"min_onh_dys",formObj.hid_min_onh_dys.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"min_onh_dys",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"free_dys",formObj.hid_free_dys.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"free_dys",0);
           sheetObj.SetCellText(sheetObj.GetSelectRow(),"cntr_old_van_flg",formObj.hid_old_new.value);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_old_van_flg",0);
           //sheetObj.SetCellValue(sheetObj.GetSelectRow(),"lift_on_chrg",formObj.hid_lift_on_chrg.value);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"lift_on_chrg",0);
           if(formObj.ctype.value == "0" && formObj.hid_old_new.value.substring(0,1) == "O"){
        	   sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"lift_on_chrg",1);
           }
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_spec_no",formObj.hid_cntr_spec_no.value,0);
          // sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_spec_no",0);
        } else {
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"eq_tpsz_cd",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_amt",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"min_onh_dys",1);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"free_dys",formObj.hid_free_dys.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"free_dys",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_old_van_flg",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"lift_on_chrg",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_old_van_flg","N",0);
           //sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_spec_no",0);
        }
        sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_tp_cd",0);
        sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_humid_ctrl_val_cd",0);
        sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_cmpr_ctnt",0);
        if (formObj.hid_tp_sz.value.substring(0, 1) == "R"){
        	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_mtrl_cd","SS",0);
        	//if(formObj.lstm_cd.value == "LT") {
        		sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_tp_cd",1);
        		sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_humid_ctrl_val_cd",1);
        		sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_cmpr_ctnt",1);
        	//} else {
        	//	sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_tp_cd",0);
        	//}
        } else {
        	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_mtrl_cd","SU",0);
        }
        setreadOnly();
        if (formObj.ctype.value != "2"){ 
        	sheetObj.SelectCell(sheetObj.GetSelectRow(), "cntr_no", true);
        }
	}
	
	
	function setInsAddMode(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"vndr_abbr_nm","",0);
	    if (approval_no.GetSelectIndex() != -1){
        	 sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",0);
        	 sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_amt",0);
	    }	
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"eq_tpsz_cd","",0);
    	//sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_mtrl_cd","",0);
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_old_van_flg","",0);
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "pkup_chg_cr_amt" ,0);
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "pkup_chg_amt",0);
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "min_onh_dys",0);
        sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "free_dys",0);
        //sheetObj.SetMinimumValue(sheetObj.GetSelectRow(), "lift_on_chrg",0);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "pkup_chg_cr_amt",99999.99);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "pkup_chg_amt",99999.99);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "min_onh_dys",99999);
        sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "free_dys",99999);
        //sheetObj.SetMaximumValue(sheetObj.GetSelectRow(), "lift_on_chrg", 999999);
        // setting default value
        if (approval_no.GetSelectIndex() != -1){
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"eq_tpsz_cd",formObj.hid_tp_sz.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"eq_tpsz_cd",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"pkup_chg_amt",formObj.hid_pkup_chg_amt.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_amt",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",formObj.hid_pkup_chg_cr_amt.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"min_onh_dys",formObj.hid_min_onh_dys.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"min_onh_dys",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"free_dys",formObj.hid_free_dys.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"free_dys",0);
           sheetObj.SetCellText(sheetObj.GetSelectRow(),"cntr_old_van_flg",formObj.hid_old_new.value);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_old_van_flg",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"lift_on_chrg",formObj.hid_lift_on_chrg.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"lift_on_chrg",0);
           if(formObj.ctype.value == "0" && formObj.hid_old_new.value.substring(0,1) == "O"){
        	   sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"lift_on_chrg",1);
           }
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_spec_no",formObj.hid_cntr_spec_no.value,0);
           //sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_spec_no",0);
        } else {
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"eq_tpsz_cd",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_amt",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"pkup_chg_cr_amt",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"min_onh_dys",1);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"free_dys",formObj.hid_free_dys.value,0);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"free_dys",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_old_van_flg",1);
           sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"lift_on_chrg",0);
           sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_old_van_flg","N",0);
           //sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cntr_spec_no",0);
        }
        sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_humid_ctrl_val_cd",0);
        sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_cmpr_ctnt",0);        
        sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_tp_cd",0);
        if (formObj.hid_tp_sz.value.substring(0, 1) == "R"){
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_mtrl_cd","SS",0);
        	//if(formObj.lstm_cd.value == "LT") {
        		sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_tp_cd",1);
        		sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_humid_ctrl_val_cd",1);
        		sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_cmpr_ctnt",1);
        	//} else {
        	//	sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"rf_tp_cd",0);
        	//}
        } else {
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_mtrl_cd","SU",0);
        }
        setreadOnly();
        if (formObj.ctype.value != "2"){ 
        	sheetObj.SelectCell(sheetObj.GetSelectRow(), "cntr_no", true);
        }
	}
	
	function setCntInsMode(cnt){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
    	sheetObj.SetCellValue(cnt,"vndr_abbr_nm","",0);
	    if (approval_no.GetSelectIndex() != -1){
        	 sheetObj.SetCellEditable(cnt,"pkup_chg_cr_amt",0);
        	 sheetObj.SetCellEditable(cnt,"pkup_chg_amt",0);
        	 //  Approval_no != null, getting Approval_no value
	    }	
    	sheetObj.SetCellValue(cnt,"eq_tpsz_cd","",0);
    	sheetObj.SetCellValue(cnt,"cntr_mtrl_cd","",0);
    	sheetObj.SetCellValue(cnt,"cntr_old_van_flg","",0);
        sheetObj.SetMinimumValue(cnt, "pkup_chg_cr_amt",0);
        sheetObj.SetMinimumValue(cnt, "pkup_chg_amt",0);
        sheetObj.SetMinimumValue(cnt, "min_onh_dys",0);
        sheetObj.SetMinimumValue(cnt, "free_dys",0);
        sheetObj.SetMinimumValue(cnt, "lift_on_chrg",0);
        sheetObj.SetMaximumValue(cnt, "pkup_chg_cr_amt",99999.99);
        sheetObj.SetMaximumValue(cnt, "pkup_chg_amt",99999.99);
        sheetObj.SetMaximumValue(cnt, "min_onh_dys",99999);
        sheetObj.SetMaximumValue(cnt, "free_dys",99999);
        sheetObj.SetMaximumValue(cnt, "lift_on_chrg",999999);
        // setting default value
        if (approval_no.GetSelectIndex() != -1){
           sheetObj.SetCellValue(cnt,"eq_tpsz_cd",formObj.hid_tp_sz.value,0);
           sheetObj.SetCellEditable(cnt,"eq_tpsz_cd",0);
           sheetObj.SetCellValue(cnt,"pkup_chg_amt",formObj.hid_pkup_chg_amt.value,0);
           sheetObj.SetCellEditable(cnt,"pkup_chg_amt",0);
           sheetObj.SetCellValue(cnt,"pkup_chg_cr_amt",formObj.hid_pkup_chg_cr_amt.value,0);
           sheetObj.SetCellEditable(cnt,"pkup_chg_cr_amt",0);
           sheetObj.SetCellValue(cnt,"min_onh_dys",formObj.hid_min_onh_dys.value,0);
           sheetObj.SetCellEditable(cnt,"min_onh_dys",0);
           sheetObj.SetCellValue(cnt,"free_dys",formObj.hid_free_dys.value,0);
           sheetObj.SetCellEditable(cnt,"free_dys",0);
           sheetObj.SetCellValue(cnt,"cntr_old_van_flg",formObj.hid_old_new.value);
           sheetObj.SetCellEditable(cnt,"cntr_old_van_flg",0);
           sheetObj.SetCellValue(cnt,"lift_on_chrg",formObj.hid_lift_on_chrg.value,0);
           sheetObj.SetCellEditable(cnt,"lift_on_chrg",0);
           //sheetObj.SetCellValue(cnt,"cntr_spec_no",formObj.hid_cntr_spec_no.value,0);
          // sheetObj.SetCellEditable(cnt,"cntr_spec_no",0);
        } else {
           sheetObj.SetCellEditable(cnt,"eq_tpsz_cd",1);
           sheetObj.SetCellEditable(cnt,"pkup_chg_amt",1);
           sheetObj.SetCellEditable(cnt,"pkup_chg_cr_amt",1);
           sheetObj.SetCellEditable(cnt,"min_onh_dys",1);
           sheetObj.SetCellValue(cnt,"free_dys",formObj.hid_free_dys.value,0);
           sheetObj.SetCellEditable(cnt,"free_dys",1);
           sheetObj.SetCellEditable(cnt,"cntr_old_van_flg",1);
           sheetObj.SetCellEditable(cnt,"lift_on_chrg",0);
           sheetObj.SetCellValue(cnt,"cntr_old_van_flg","N",0);
           //sheetObj.SetCellEditable(cnt,"cntr_spec_no",0);
        }
        sheetObj.SetCellEditable(cnt,"rf_tp_cd",0);
        sheetObj.SetCellEditable(cnt,"rf_humid_ctrl_val_cd",0);
        sheetObj.SetCellEditable(cnt,"rf_cmpr_ctnt",0);
        
        if (formObj.hid_tp_sz.value.substring(0, 1) == "R"){
        	sheetObj.SetCellValue(cnt,"cntr_mtrl_cd","SS",0);
        	//if(formObj.lstm_cd.value == "LT") {
        		sheetObj.SetCellEditable(cnt,"rf_tp_cd",1);
        		sheetObj.SetCellEditable(cnt,"rf_humid_ctrl_val_cd",1);
        		sheetObj.SetCellEditable(cnt,"rf_cmpr_ctnt",1);
        	//} else {
        	//	sheetObj.SetCellEditable(cnt,"rf_tp_cd",0);
        	//}
        } else {
        	sheetObj.SetCellValue(cnt,"cntr_mtrl_cd","SU",0);
        }
        setreadOnly();
	}	
	/*
	 *  gubun1 = separator 
	 *  gubun2 = word to be 
	 */
	function replaceAll(Str ,gubun1 ,gubun2){
		var Strname=Str.split(gubun1);
		var returnStr="";
		for(i=0 ; i < Strname.length ; i++) {
			if ( i == Strname.length-1 ){
				returnStr=returnStr + Strname[i];  
			} else {
				returnStr=returnStr + Strname[i]+gubun2;
			}
		}
		return returnStr;
	}	
	
	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}