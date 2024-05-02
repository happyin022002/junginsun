/*=========================================================
 * Copyright(c) 2015 CyberLogitec
 *@FileName   : ESM_BKG_1705.js
 *@FileTitle  : Special Cargo Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/01/19
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/			 
	/* global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	/*********************** EDTITABLE MULIT COMBO END ********************/
	var arrMultiCombo;// variable to set multi combo 
	var orderby=""; 
 
	/* init */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function setComboObject(combo_obj){
		 comboObjects[comboCnt++]=combo_obj;
	}	
    function loadPage() {  
		loadingMode=true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for (i=0; i < sheetObjects.length; i++) {			
		    ComConfigSheet(sheetObjects[i]);
		    initSheet(sheetObjects[i], i + 1);
		    ComEndConfigSheet(sheetObjects[i]);
		}			
		loadingMode=false;
		
		initControl();
    }
    function initCombo(comboObj, comboId) {
		with(comboObj) {
	    	switch(comboObj.options.id) {
	        	case "r_term":
	        	case "d_term":	
        			SetMultiSelect(1);
        			SetMultiSeparator(",");
	        		break;
	        	case "dir_cd":
	        	case "trd_cd":
	        	case "sub_trd_cd":
	        		InsertItem(0, '', '');
	        		break;
	        	case "report_type":	        		
	        		SetSelectIndex(0);
	        		break;	        		
	    	}			
            ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고				
		}
	} 	 	
 
/*********************** KEY EVENT START ********************/
    function initControl() {
    	axon_event.addListenerForm('keydown','bkg_keydown',document.form); 	//20150317.MOD
        
        chgMandatory();
    }
    
    /** 20150317.ADD */
    function bkg_keydown() {
        var obj=event.srcElement;
        var vKeyCode=event.keyCode;
        if ( vKeyCode == 13 ) {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }     
/*********************** KEY EVENT END ********************/
	
	// Event handler processing by button click event */
 		document.onclick=processButtonClick;		
 	// Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
		  var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	    	try {
	     		var srcName=ComGetEvent("name");
	     		 if(ComGetBtnDisable(srcName)) return false;
		 			switch(srcName) {	
		 				case "btn_Direct_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;			 			
		 				case "btn_Sort":
			 				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?isPop=Y&codeGubun=", "OrderBy", 420,250,false,"scrollbars=no,resizable=yes");
		 				  break; 		 					
		 				case "btn_New":
		 					document.tempform.reset();
		 					initAll(formObject);
		 					for(k=0;k<comboObjects.length;k++){
		 						initCombo(comboObjects[k],comboObjects[k].id);
		 					}
		 					chgMandatory();
		 					break;
		 				case "btn_ReportTemplate": 	
		 					//20150603.MOD
	 						var retVal=ComOpenPopup('/opuscntr/ESM_BKG_0104.do?'+FormQueryString(document.tempform), 850, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
							break;
		 				case "btn_customer_pop":
							var param="" ;
							param="?cust_cd="+formObject.cust_cnt_cd.value;
							if(formObject.cust_seq.value != ""){
								param += eval(formObject.cust_seq.value);
							}
							param += "&cust_nm="+formObject.cust_nm.value;	
							ComOpenPopup('/opuscntr/COM_ENS_041.do'+param, 770, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;	
		 				case "btn_cust_grp_pop":
			 				ComOpenPopup('/opuscntr/COM_COM_0006.do', 770, 430, 'setCustGrp', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;								
						//-------------------- Date Button Start
						case "btn_sail_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.sail_from_dt, formObject.sail_to_dt,'yyyy-MM-dd');
						 	break;
						case "btn_arr_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.arr_from_dt, formObject.arr_to_dt,'yyyy-MM-dd');
							break;
						case "btn_bkg_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
							break;
						//-------------------- Date Button End							
		        } // end switch
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e);
		    		}
	     	}
    }

	// handling of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        
		case IBCLEAR:	
			formObj.f_cmd.value=INIT;	
			var sXml=sheetObj.GetSearchData("ESM_BKG_1705GS.do", FormQueryString(formObj)+"&"+FormQueryString(document.tempform));	//20150603.MOD
			arrMultiCombo=sXml.split("|$$|");	
			initAll(formObj);
			break;        
			
		case IBSEARCH:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH01;
				formObj.orderby.value=orderby;
				formObj.target="_top";
				formObj.action="ESM_BKG_1705DL.do?"+FormQueryString(formObj)+"&"+FormQueryString(document.tempform);				//20150603.MOD
	            formObj.submit();
	            sheetObj.RemoveEtcData(); // Delete ETC data
			break;			
	    }
     }
			
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
    		case IBSEARCH:    			
    			//VVD 가 있으면 무조건 조회 가능
    			if (!ComIsNull(formObj.vvd_cd)) {
    				return true;
    			}

    			//BKG No 만 넣었을 때도 조회 가능
    			if (!ComIsNull(formObj.bkg_no)) {
    				return true;
    			}    			

    			//Outbound 체크시 Sail Date + POL 조합으로 조회 가능
    			if (formObj.io_bnd_cd[0].checked) {
    				
    				// POL값이 입력되었는지 체크
    				if (!ComIsNull(formObj.pol_cd)) {
    					if (!ComIsNull(formObj.sail_from_dt)) {
    						if (ComIsNull(formObj.sail_to_dt)) {
        						ComShowCodeMessage('BKG00104','Sail Date (To)');
        	    				formObj.sail_to_dt.focus();
        	    				return false;
    						}
    					} else {
    						ComShowCodeMessage('BKG00104','Sail Date (From)');
    	    				formObj.sail_from_dt.focus();
    	    				return false;
    					}
    				} else {
    					if (!ComIsNull(formObj.sail_from_dt)) {
    						ComShowCodeMessage('BKG00104','POL');
    	    				formObj.pol_cd.focus();
    	    				return false;
    					}
    					
    					if (!ComIsNull(formObj.sail_to_dt)) {
    						ComShowCodeMessage('BKG00104','POL');
    	    				formObj.pol_cd.focus();
    	    				return false;
						}
    				}
    				if (!ComIsNull(formObj.sail_from_dt) && !ComIsNull(formObj.sail_to_dt)) {
						if (!ComBkgMonthsBetweenCheck(formObj.sail_from_dt.value,formObj.sail_to_dt.value, "1")) {
							ComShowCodeMessage('COM132001','Sail Date','1Month');
		                    ComSetFocus(formObj.sail_to_dt);
		                    return false;
						} else {
	    					return true;
	    				}
    				}
    			}else {
    				// Inbound 체크시 Arrival Date + POD 조합으로 조회 가능
    				// POD값이 입력되었는지 체크
    				if (!ComIsNull(formObj.pod_cd)) {
    					if (!ComIsNull(formObj.arr_from_dt)) {
    						if (ComIsNull(formObj.arr_to_dt)) {
        						ComShowCodeMessage('BKG00104','Arrival Date (To)');
        	    				formObj.arr_to_dt.focus();
        	    				return false;
    						}
    					} else {
    						ComShowCodeMessage('BKG00104','Arrival Date (From)');
    	    				formObj.arr_from_dt.focus();
    	    				return false;
    					}
    				} else {
    					if (!ComIsNull(formObj.arr_from_dt)) {
    						ComShowCodeMessage('BKG00104','POD');
    	    				formObj.pod_cd.focus();
    	    				return false;
    					}
    					
    					if (!ComIsNull(formObj.arr_to_dt)) {
    						ComShowCodeMessage('BKG00104','POD');
    	    				formObj.pod_cd.focus();
    	    				return false;
						}
    				}
    				
    				if (!ComIsNull(formObj.arr_from_dt) && !ComIsNull(formObj.arr_to_dt)) {
						if (!ComBkgMonthsBetweenCheck(formObj.arr_from_dt.value,formObj.arr_to_dt.value, "1")) {
							ComShowCodeMessage('COM132001','Arrival Date','1Month');
		                    ComSetFocus(formObj.arr_to_dt);
		                    return false;
						} else {
	    					return true;
	    				}
    				} 
    			}
    			
    			//Outbound/Inbound 관계 없이 BKG Date + BKG Office 로 조회 가능
    			if (!ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt)) {
    				if (!ComIsNull(formObj.bkg_ofc_cd)) {
    					if (!ComBkgMonthsBetweenCheck(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value, "1")){
    						ComShowCodeMessage('COM132001','Booking Date','1Month');
    						ComSetFocus(formObj.bkg_to_dt);
    						return false;
    					} else {
    						return true;
    					}
    				} else {
    					ComShowCodeMessage('BKG00104','BKG Ofc');
	    				formObj.bkg_ofc_cd.focus();
	    				return false;
    				}
    			}

    			if(formObj.rdo1_1.checked) {
    				chkMsg = 'If you select Outbound You must enter (VVD) or (Sail Date & POL) or (Booking Date & Booking Office).';
        			ComShowCodeMessage('BKG00627',chkMsg);
        			return false;
    			} else {
    				chkMsg = 'If you select Inbound You must enter (VVD) or (Arrival Date & POD) or (Booking Date & Booking Office).';
        			ComShowCodeMessage('BKG00627',chkMsg);
        			return false;    				
    			}
    			
    			break;
/*
    			if (!ComIsNull(formObj.vvd_cd)) {
    				return true;
    			}else if (ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.sail_from_dt) ||  ComIsNull(formObj.sail_to_dt)) 
					  && (ComIsNull(formObj.arr_from_dt) ||  ComIsNull(formObj.arr_to_dt))
					  && (ComIsNull(formObj.bkg_from_dt) ||  ComIsNull(formObj.bkg_to_dt))) {
 					ComShowCodeMessage('BKG00626','VVD or Sail Date or Arrival Date or Booking Date');
 					formObj.vvd_cd.focus();
 					return false;    
    			}else if ((formObj.io_bnd_cd.value=="O" && (ComIsNull(formObj.sail_from_dt) ||  ComIsNull(formObj.sail_to_dt)) && (ComIsNull(formObj.bkg_from_dt) ||  ComIsNull(formObj.bkg_to_dt))) 
  					   || (formObj.io_bnd_cd.value=="I" && (ComIsNull(formObj.arr_from_dt) ||  ComIsNull(formObj.arr_to_dt)) && (ComIsNull(formObj.bkg_from_dt) ||  ComIsNull(formObj.bkg_to_dt))) ) {
    				var chkMsg = "";
    				if(formObj.rdo1_1.checked) chkMsg = 'If you select Outbound You must enter (Sail Date or Booking Date) and POL.';
    				else chkMsg = 'If you select Inbound You must enter (Arrival Date or Booking Date) and POD.';
   					ComShowCodeMessage('BKG00627',chkMsg);
   					if(formObj.rdo1_1.checked) formObj.sail_from_dt.focus();
   					else formObj.arr_from_dt.focus();
   					return false;     					
	    		}else if (((!ComIsNull(formObj.sail_from_dt) && !ComIsNull(formObj.sail_to_dt)) || 
        			       (!ComIsNull(formObj.arr_from_dt) && !ComIsNull(formObj.arr_to_dt)) ||
        			       (!ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt))) &&
        			         ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd )) {	    			
	    			if(formObj.rdo1_1.checked) {
	    				ComShowCodeMessage('BKG00104','POL');
	    				formObj.pol_cd.focus();
	    			} else {
	    				ComShowCodeMessage('BKG00104','POD');
	    				formObj.pod_cd.focus();
	    			}
	    			return false;
			  	}
    			// maximum 1 month
                if(ComIsNull(formObj.vvd_cd) && (!ComIsNull(formObj.sail_from_dt) && !ComIsNull(formObj.sail_to_dt)) && 
                  !ComBkgMonthsBetweenCheck(formObj.sail_from_dt.value,formObj.sail_to_dt.value, "1")){
                    ComShowCodeMessage('COM132001','Sail Date','1Month');
                    ComSetFocus(formObj.sail_to_dt);
                    return false;
                }
                if(ComIsNull(formObj.vvd_cd) && (!ComIsNull(formObj.arr_from_dt) && !ComIsNull(formObj.arr_to_dt)) && 
                  !ComBkgMonthsBetweenCheck(formObj.arr_from_dt.value,formObj.arr_to_dt.value, "1")){
                    ComShowCodeMessage('COM132001','Arrival Date','1Month');
                    ComSetFocus(formObj.arr_to_dt);
                    return false;
                }
                if(ComIsNull(formObj.vvd_cd) && (!ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt)) && 
                  !ComBkgMonthsBetweenCheck(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value, "1")){
                    ComShowCodeMessage('COM132001','Booking Date','1Month');
                    ComSetFocus(formObj.bkg_to_dt);
                    return false;
                }   	
	  			break;
*/                	
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
/*############################# combo onchage start ########################*/
     /**
 	 *  2015.03.02.MOD
 	 */
 	function report_type_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
 		if(rptIdArr != null){
 			document.form.rpt_id.value = rptIdArr[newindex];
 		}
 	}   	 
/*############################# combo onchage end ########################*/		
	/*
	 *  initializing all condition
	 * */
 	var rptIdArr;
	function initAll(formObject){
		formObject.reset();
		ComXml2ComboItem(arrMultiCombo[0], report_type, 	"sql_ctnt_col_nm", "rpt_nm");
		var arr=ComBkgXml2Array(arrMultiCombo[0], "rpt_nm");
		if(arr == undefined) return;		
		var rptIdStr = ComXml2ComboString(arrMultiCombo[0], "rpt_id", "rpt_id")[0];
		rptIdArr = rptIdStr.split("|");
		
		ComXml2ComboItem(arrMultiCombo[1], r_term,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[2], d_term,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[3], dir_cd, 			"val", "val");
		ComXml2ComboItem(arrMultiCombo[4], trd_cd, 			"trd_cd", "trd_cd");
		ComXml2ComboItem(arrMultiCombo[5], sub_trd_cd, 		"sub_trd_cd", "sub_trd_cd");
//		ComXml2ComboItem(arrMultiCombo[6], lane_cd, 		"code", "code");
		for (var i=0; i < sheetObjects.length; i++) {			
		    sheetObjects[i].RemoveAll();
		}
	}    
	/*
	 * method which is setting the result of Customer
	 * */
	function setCustomer(val){
		var c_cd=val[0][3];
		var c_name=val[0][4];
		form.cust_cnt_cd.value=c_cd.substring(0,2);
		form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
		form.cust_nm.value=c_name;
	} 
	/*
	 * method which is setting the result of Group Customer
	 * */
	function setCustGrp(val){
		form.cust_grp_id.value=val[0][2];
	}		
	/**
      * initSheet
      */
     function initSheet(sheetObj,sheetNo,ColList) {
	    sheetObj.UseUtf8=true;
	    var cnt=0;
	    switch(sheetObj.id) {
	    	case "search_options":
		        with(sheetObj){			
					  var HeadTitle1="Search Options";
					  var headCount=ComCountHeadTitle(HeadTitle1);
					
					  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					  InitHeaders(headers, info);
					
					  var cols = [ {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"search_options" } ];
					   
					  InitColumns(cols);						
					  SetEditable(0);
					  SetCountPosition(0);//[1/3]page
					  SetSheetHeight(100);
		
                    }
				break;    	            
	    }
     }     
     
     /* 조건에 따른 필수값 세팅 */
     function chgMandatory() {
    	 var formObject = document.form;    
    	 if(formObject.rdo1_1.checked) {    		 
			 formObject.arr_from_dt.value = "";
			 formObject.arr_to_dt.value = "";
			 formObject.pod_cd.value = "";
			 formObject.pod_yard_cd.value = "";		 
			 document.getElementById("sail_from_dt").className="input1";
			 document.getElementById("sail_to_dt").className="input1";
			 document.getElementById("pol_cd").className="input1";
			 document.getElementById("arr_from_dt").className="input";
			 document.getElementById("arr_to_dt").className="input";
			 document.getElementById("pod_cd").className="input";
			 if(formObject.vvd_cd.value=="") formObject.vvd_cd.focus();	 
			 else formObject.sail_from_dt.focus();			 
		 } else if(formObject.rdo1_2.checked) {
			 formObject.sail_from_dt.value = "";
			 formObject.sail_to_dt.value = "";
			 formObject.pol_cd.value = "";
			 formObject.pol_yard_cd.value = "";			 
			 document.getElementById("sail_from_dt").className="input";
			 document.getElementById("sail_to_dt").className="input";
			 document.getElementById("pol_cd").className="input";			 
			 document.getElementById("arr_from_dt").className="input1";
			 document.getElementById("arr_to_dt").className="input1";
			 document.getElementById("pod_cd").className="input1";
			 if(formObject.vvd_cd.value=="") formObject.vvd_cd.focus();	 
			 else formObject.arr_from_dt.focus();
		 } else {
			 formObject.sail_from_dt.value = "";
			 formObject.sail_to_dt.value = "";
			 formObject.pol_cd.value = "";
			 formObject.pol_yard_cd.value = "";				 
			 formObject.arr_from_dt.value = "";
			 formObject.arr_to_dt.value = "";
			 formObject.pod_cd.value = "";
			 formObject.pod_yard_cd.value = "";			 
			 document.getElementById("sail_from_dt").className="input";
			 document.getElementById("sail_to_dt").className="input";
			 document.getElementById("pol_cd").className="input";			 
			 document.getElementById("arr_from_dt").className="input";
			 document.getElementById("arr_to_dt").className="input";
			 document.getElementById("pod_cd").className="input";	
			 if(formObject.vvd_cd.value=="") formObject.vvd_cd.focus();	 
			 else formObject.sail_from_dt.focus();
		 }
     }
     
     /* report type 변경시 */
     function chgRepoType() {    	 
    	var formObj = document.form;
    	formObj.f_cmd.value=SEARCH02;
    	//20150603.MOD
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_1705GS.do", FormQueryString(formObj)+"&"+FormQueryString(document.tempform));
		var arrCombo=sXml.split("|$$|");
		
		ComXml2ComboItem(arrCombo[0], report_type, 	"sql_ctnt_col_nm", "rpt_nm");
		var arr=ComBkgXml2Array(arrCombo[0], "rpt_nm");
		if(arr == undefined) return;		
		var rptIdStr = ComXml2ComboString(arrCombo[0], "rpt_id", "rpt_id")[0];
		rptIdArr = rptIdStr.split("|");
		
		report_type.SetSelectIndex(0);
     }
     
     /* setting Sort in POP-UP   * */
     function setOrderBy(val){    	 
    	 orderby = val;    	 
     }
     
     //대문자로 입력 변환
	 function onlyText(obj){
		val=obj.value;
		re=/[^a-zA-Z]/gi;
		obj.value=val.replace(re,"");
	}
     
	/* the end of developer's work */    
