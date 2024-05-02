/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_02B.js
*@FileTitle  : TRO(Transportation Request Order) for Inland Haulage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* developer's work	*/
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var tabObjects=new Array(); 
    var tabCnt=0 ; 
    var beforetab_trob=1; 
	//---------------------------------
    //To use the name without order  
    var x_sheetObject1=null;
    var x_sheetObject2=null;
    var x_sheetObject3=null;
    var x_sheetObject4=null;
    var x_sheetObject5=null;
    var x_sheetObject6=null;
    var x_sheetObject7=null;
    var x_sheetObject8=null;
    var x_sheetObject9=null;
    var x_oldTroSeq="";   //previous selected value of tro_seq   
    var x_oldTroSeq_rtn="";   //previous selected value of  tro_seq   : rtn_cago 
    var x_cancelAllFlg="N";  //Y:cancelAll 
    var x_cancelAllFlg_rtn="N";  //Y:cancelAll 
    var tab_alert_msg=false; // Message display mode 
    // Event handler processing by button click event   */
    document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
    // Event handler processing by button name  */
    function processButtonClick(){
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(srcName != "btn_splitPop" && layList.style.display == "") layList.style.display="none";
    		
    		switch(srcName) {
				case "btn_splitPop":
					doActionIBSheet(x_sheetObject9, formObject, COMMAND03);	
					break;
			    case "btn_Danger":
			    	if(checkTdUnLink(srcName)) return false;    
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0200(bkgNo, caFlg);
			    	var url="ESM_BKG_0200_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0200_POP", 1280, 682, false);
			    	break;
			    case "btn_Reefer":
			    	if(checkTdUnLink(srcName)) return false;    		
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0498(bkgNo, caFlg);
			    	var url="ESM_BKG_0498_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0498_POP", 1280, 682, false);
			    	break;
			    case "btn_Awkward":
			    	if(checkTdUnLink(srcName)) return false;    	
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0055(bkgNo, caFlg);
			    	var url="ESM_BKG_0055_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0055_POP", 1280, 682, false);
			    	break;
			    case "btn_Bulk":
			    	if(checkTdUnLink(srcName)) return false;  
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0106(bkgNo, caFlg);
			    	var url="ESM_BKG_0106_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0106_POP", 1280, 682, false);
			    	break;
				case "btn_t2bAdd":
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					addRow(x_sheetObject1);   
					break;
				case "btn_t2bDelete": 
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var nRow=x_sheetObject1.CheckedRows("del_chk");
					if (nRow <= 0) {
						ComShowCodeMessage("BKG00567");
						return false;
					}
					if (!ComShowCodeConfirm("COM12194", "")) {
        	    		return false;
        	    	} 
				    //setRowDelStatus(x_sheetObject1, "del_chk");
				    //setRowDelStatus_chkall(x_sheetObject1, "del_chk");
				    //cancelDtl(x_sheetObject1, "del_chk");
        	    	//2) save & delete : call
                    cancelDtl(x_sheetObject1, "del_chk");
                    doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y"); 
					break;
				case "btn_t2bCopy":	
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var bResult=checkCopySumTroqty(x_sheetObject1);  //handling message when you copy(check the exceeded amount)
					//if (!bResult) {
					//	return false;
					//}					
					copyRow(x_sheetObject1);
					break;
				case "t2_btn_t2bAdd":
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject7.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					addRow(x_sheetObject6);   
					break;
				case "t2_btn_t2bDelete": 
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject7.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}					
					var nRow=x_sheetObject6.CheckedRows("del_chk");
					if (nRow <= 0) {
						ComShowCodeMessage("BKG00567");
						return false;
					}
					if (!ComShowCodeConfirm("COM12194", "")) {
        	    		return false;
        	    	}
				    //setRowDelStatus(x_sheetObject6, "del_chk");
				    //setRowDelStatus_chkall(x_sheetObject6, "del_chk");
				    //cancelDtl(x_sheetObject6, "del_chk");
				    //2) save & delete : call
                    cancelDtl(x_sheetObject6, "del_chk");
				    doActionIBSheet(x_sheetObject7, formObject, IBSAVE, "Y");
				    
					break;
				case "t2_btn_t2bCopy":
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject7.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					copyRow(x_sheetObject6);
					break;
				case "btn_t2bRetrieve":
					if(checkTdDisabled(srcName)) return false;
					formObject.curr_rtn_tro_flg.value="";  //default tab clear
					formObject.curr_tro_seq.value="";  //default order clear
					doActionIBSheet(x_sheetObject2, formObject, IBSEARCH);
					break;
				case "btn_t2bSave":		
					if(checkTdDisabled(srcName)) return false; 
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE);
					break;
				case "btn_t2bSaveSeq":  //saving the only one Sequence
					if(checkTdDisabled(srcName)) return false; 
			        doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "C");
					break;
				case "btn_t2bCancelAll": 
					if(checkTdDisabled(srcName)) return false;
					if (tabObjects[0].GetSelectedIndex() == 1) {
						if (x_sheetObject7.RowCount()<= 0) {
							callShowMessageAddSeq();
							return false;
						}
						if (x_cancelAllFlg_rtn == "Y") {
							callShowMessageReProc("(Return) Cancel All");
							return false;
						}	
						if (!ComBkgProcessYn("(Return) CANCEL All")) {
	        	    		return false;
	        	    	}
					} else {
						if (x_sheetObject2.RowCount()<= 0) {
							callShowMessageAddSeq();
							return false;
						}	
						if (x_cancelAllFlg == "Y") {
							callShowMessageReProc("(General) Cancel All");
							return false;
						}		
						if (!ComBkgProcessYn("(General) CANCEL All")) {
	        	    		return false;
	        	    	}
					}
					//2) save & delete : call
					cancelAll();
					if (tabObjects[0].GetSelectedIndex() == 1) {
				        doActionIBSheet(x_sheetObject7, formObject, IBSAVE, "Y");
					} else {
						doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					}
					break;
				case "btn_t2bRequest":	
					if(checkTdDisabled(srcName)) return false;
	          		//01. save
					if (tabObjects[0].GetSelectedIndex() == 1) {
				        doActionIBSheet(x_sheetObject7, formObject, IBSAVE, "R");
					} else {
						doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "R");
					}	          		
					break;
				case "btn_t2bTROCopy":		
                    if(checkTdDisabled(srcName)) return false;
					var bkgNo=nullToBlank(formObject.bkg_no.value);
					var bkgNoOld=nullToBlank(formObject.oldBkgNo.value); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkgNo != bkgNoOld) {
						ComShowCodeMessage("BKG00048", bkgNoOld, bkgNo);
						ComSetFocus(bkg_no);
						return false;
					}
					var boundCd=""; 
					var troSeq=nullToBlank(tro_seq.GetSelectText());
					var uiId="ESM_BKG_0079_02B";
					comBkgCallPop0920('setTroCopy', bkgNo, boundCd, troSeq, uiId); 
					break;
				case "btn_t2bAddSeq":			
					if(checkTdDisabled(srcName)) return false;
					if (tabObjects[0].GetSelectedIndex() == 1) {
						addRow(x_sheetObject7);   
					} else {
						addRow(x_sheetObject2);   
					}
					break;
				case "btn_t2bCopySeq":			
					if(checkTdDisabled(srcName)) return false;
					if (tabObjects[0].GetSelectedIndex() == 1) {
						if (x_sheetObject7.RowCount()<= 0) {
							callShowMessageAddSeq();
							return false;
						}
						copyRow(x_sheetObject7);
					} else {
						if (x_sheetObject2.RowCount()<= 0) {
							callShowMessageAddSeq();
							return false;
						}							
						var bResult=checkCopySumTroqty(x_sheetObject2);  //handling message when you copy Sequence(check the exceeded amount)   
						//if (!bResult) {
						//	return false;
						//} 
						copyRow(x_sheetObject2);
					}
					break;
				case "btn_t2bCancelSeq":   //Delete seq -> Cancel Seq 
				    if(checkTdDisabled(srcName)) return false;
					if (tabObjects[0].GetSelectedIndex() == 1) {
						if (x_sheetObject7.RowCount()<= 0) {
							callShowMessageAddSeq();
							return false;
						}
						if (formObject.t2_cxl_flg.checked) {
							callShowMessageReProc("Cancel Seq");
							return false; 
						}
					} else {
						if (x_sheetObject2.RowCount()<= 0) {
							callShowMessageAddSeq();
							return false;
						}
						if (formObject.cxl_flg.checked) {
							callShowMessageReProc("Cancel Seq");
							return false; 
						}
					}
					if (!ComBkgProcessYn("Delete Seq")) {
        	    		return false;
        	    	} 
					//2) save & delete : call
					cancelSeq();
					if (tabObjects[0].GetSelectedIndex() == 1) {
				        doActionIBSheet(x_sheetObject7, formObject, IBSAVE, "Y");
					} else {
						doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					}
					break;
				case "btns_popActCust":
					if(checkInputDisabled("act_shpr_nm")) return false; 					
					var conti_cd=document.form.conti_cd.value;            //hidden : continect code
					var cnt_cd=document.form.por_cd.value.substr(0,2);  //country code -> not use
					var dor_loc_cd=document.form.dor_loc_cd.value; 
					var act_shpr_cnt_cd=document.form.act_shpr_cnt_cd.value; 
					var act_shpr_seq=document.form.act_shpr_seq.value;
					var act_shpr_nm=document.form.act_shpr_nm.value; 
					var arrAct_shpr_nm=act_shpr_nm.split(" ");
					act_shpr_nm=arrAct_shpr_nm[0];
					var bkg_no=nullToBlank(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank(formObject.oldBkgNo.value); 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					var type = "B";
					comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, type);
					break;
				case "t2_btns_popActCust": 
					if(checkInputDisabled("t2_act_shpr_nm")) return false; 					
					var conti_cd=document.form.conti_cd.value;            //hidden : continect code
					var cnt_cd=document.form.por_cd.value.substr(0,2);  //country code -> not use
					var dor_loc_cd=document.form.t2_dor_loc_cd.value; 
					var act_shpr_cnt_cd=document.form.t2_act_shpr_cnt_cd.value; 
					var act_shpr_seq=document.form.t2_act_shpr_seq.value;
					var act_shpr_nm=document.form.t2_act_shpr_nm.value;
					var arrAct_shpr_nm=act_shpr_nm.split(" ");
					act_shpr_nm=arrAct_shpr_nm[0]; 
					var bkg_no=nullToBlank(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank(formObject.oldBkgNo.value); 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					var type = "B";
					comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, type);
					break;
				case "btns_popLocation":				
					if(checkInputDisabled("zn_cd")) return false; 
					var cnt_cd=document.form.por_cd.value.substr(0,2);  //country code -> not use
					var node_cd="";
					var dor_loc_cd=formObject.dor_loc_cd.value;
					var zn_cd=formObject.zn_cd.value;
					if (dor_loc_cd.length == 5 && zn_cd.length == 2) { 
						node=dor_loc_cd+zn_cd; 
					}					
					var param="";
					param += "?cnt_cd="    + cnt_cd;
					param += "&loc_cd="    + dor_loc_cd;
					param += "&ofc_cd="    + "N";
					param += "&node_cd="   + node_cd;
					param += "&mode="      + "zone";
					param += "&mode_only=" + "Y";
					ComOpenPopup("/opuscntr/COM_ENS_061.do"+param, 780, 520, 'getCOM_ENS_061_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
				case "t2_btns_popLocation":
					if(checkInputDisabled("t2_zn_cd")) return false; 
					var cnt_cd=document.form.por_cd.value.substr(0,2);  //country code -> not use
					var node_cd="";
					var dor_loc_cd=formObject.t2_dor_loc_cd.value;
					var zn_cd=formObject.t2_zn_cd.value;
					if (dor_loc_cd.length == 5 && zn_cd.length == 2) { 
						node=dor_loc_cd+zn_cd; 
					}
					var param="";
					param += "?cnt_cd="    + cnt_cd;
					param += "&loc_cd="    + dor_loc_cd;
					param += "&ofc_cd="    + "N";
					param += "&node_cd="   + node_cd;
					param += "&mode="      + "zone";
					param += "&mode_only=" + "Y";
					ComOpenPopup("/opuscntr/COM_ENS_061.do"+param, 780, 470, 'getCOM_ENS_061_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
            } // end switch
    	}catch(e) {    		
    		if( e.name == "TypeError") {
    			return false;
    		}else{
        		ComShowMessage(e.message);
    		}
    	}
    }
    /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }    
    /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**    
     * registering IBCombo Object as comboObjects list
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
        var formObj=document.form; 
     	//handling button link/output ------------->
   	    changeDisplayBtn("btn_Danger",  "N");
   	    changeDisplayBtn("btn_Reefer",  "N");
   	    changeDisplayBtn("btn_Awkward", "N");
   	    changeDisplayBtn("btn_Bulk",    "N");
   	    //<----------------------------------------------
         for(var i=0; i<sheetObjects.length; i++){
             ComConfigSheet   (sheetObjects[i]);
             initSheet        (sheetObjects[i], i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         //---------------
         //initializing IBMultiCombo 
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k],k+1);
         }         
         //---------------
         // initializing tab 
         for(var k=0; k<tabObjects.length; k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }       
         //---------------
 	 	//creating iframe 
 		//CofigIframe();
        //***** using extra sheet valuable if there are more 2 sheets ****
 	   	x_sheetObject5=sheetObjects[0];  //sum_qty screen
 	   	x_sheetObject1=sheetObjects[1];  //tro_dtl screen  : general 
 	   	x_sheetObject6=sheetObjects[2];  //tro_dtl screen  : rtn-cago  	   	
 	   	x_sheetObject2=sheetObjects[3];  //tro        all hidden : general 
 	   	x_sheetObject3=sheetObjects[4];  //tro_dtl    all hidden : general 
 	   	x_sheetObject4=sheetObjects[5];  //tro_dg_seq all hidden : general 
 	   	x_sheetObject7=sheetObjects[6];  //tro        all hidden : rtn-cago 
 	   	x_sheetObject8=sheetObjects[7];  //tro_dtl    all hidden : rtn-cago 
 	   	x_sheetObject9=sheetObjects[8];  //requset/msg : hidden 
        //*************************************************************  
// 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
// 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);  
 	   	axon_event.addListenerForm  ('click',    'obj_click',        document.form); 
 	    axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
// 	    axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
 	   	if (formObj.bkg_no.value != "" || formObj.bl_no.value != "") {
 	   		formObj.curr_rtn_tro_flg.value="";  //default tab clear
 	   		formObj.curr_tro_seq.value="";  //default sequence clear
             doActionIBSheet(x_sheetObject2, document.form, IBSEARCH); 
             //initTestSample_receive_flatfile();  //to use for testing , in case of managing, remove it!!!!!!!!!!!!!
 	   	} else {
 	   		//Search button only enabled
 	   		ComEnableManyTd(true,  "btn_t2bRetrieve", "btn_t2bIFInquiry");	
 	   		ComEnableManyTd(false, "btn_t2bSave", "btn_t2bSaveSeq", 
 	   				                "btn_t2bRequest", "btn_t2bCancelAll", "btn_t2bTROCopy", 
                                    "btn_t2bAddSeq", "btn_t2bCopySeq", "btn_t2bCancelSeq", 
                                    "btn_t2bAdd", "btn_t2bDelete", "btn_t2bCopy", 
                                    "t2_btn_t2bAdd", "t2_btn_t2bDelete", "t2_btn_t2bCopy"); 
 	   	}
     	//------------------------------------------------>
     	//calling setInquiryDisableButton event
     	if(ComGetObjValue(document.form.isInquiry) == "Y"){
     		setInquiryDisableButton();
     	}
     	initControl();
    }
	function initControl() {
     	applyShortcut();
	}
	function initTestSample_receive_flatfile() {
    	var formObj=document.form;
	    var strTestFlatFile="";
	    strTestFlatFile += "          ";  //10 digit
	    strTestFlatFile += "A";
	    //strTestFlatFile += " ";
	    strTestFlatFile += "200906252015";
	    strTestFlatFile += "KORZ1235322  ";
	    strTestFlatFile += "1 ";
	    strTestFlatFile += "          ";
	    strTestFlatFile += "99999999991";
	    strTestFlatFile += "test_request_order_msg                                                                              ";
	    strTestFlatFile += "                                                                                                    ";
	    formObj.flatfile.value=strTestFlatFile;    	
    }
	/**
	 * setting Tab 
	 * setting tab item
	 */
	function initTab(tabObj, tabNo) {
	     switch(tabNo) {
	         case 1:
	            with (tabObj) {
	                var cnt=0 ;
	                InsertItem( "General" , "");
	                InsertItem( "Return" , "");
//no support[check again]CLT 	                BaseColor="243,242,248"; 
	            }
	         break;
	     }
	}      
    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		SetMultiSeparator("|");
	    	switch(comboObj.options.id) {
			    case "tro_seq" : 
			    	SetColWidth(0, "46");
			        break;
	    	    case "dcgo_seq" : 
	    	    	SetColWidth(0, "40");
	    	    	SetColWidth(1, "280");
	                SetTitle("seq|Remark");
	                SetMultiSelect(1);
	    	        break;	
	    	    case "rc_seq" : 
	    	    	SetColWidth(0, "40");
	    	    	SetColWidth(1, "380");
	    	    	SetTitle("seq|Remark");
	    	    	SetMultiSelect(1);
	    	    	break;
	    	    case "awk_cgo_seq" : 
	    	    	SetColWidth(0, "70");
	    	    	SetMultiSelect(1);
	    	        break;
	    	}
        }
    }
//	// business java script (OnKeyPress event)
//	function obj_keypress_loc() {
//		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//		switch(event.srcElement.dataformat){
//	       case "float":
//	           //number+"."
//	           ComKeyOnlyNumber(event.srcElement, ".");
//	           break;
//	       case "eng":
//	           //only alphabet, alphabet+number -> ComKeyOnlyAlphabet('num');
//	           ComKeyOnlyAlphabet();
//	           break;
//	       case "engdn":
//	           //only lower case, lower case+number -> ComKeyOnlyAlphabet('lowernum');
//	           ComKeyOnlyAlphabet('lower');
//	           break;
//	       case "engup":
//	           //only upper case
//	           ComKeyOnlyAlphabet('upper');
//	           break;
//	       case "int":
//	           //only number(number,date ,time)
//	           ComKeyOnlyNumber(event.srcElement);
//	           break;
//	       case "uppernum": //all character are permitted,  upper case  
//	       	   if(keyValue >= 97 && keyValue <= 122) {//lower case
//	     			event.keyCode=keyValue + 65 - 97;
//	     		}
//	           break;
//	       case "tel":
//		        // number+"-"
//		        ComKeyOnlyNumber(event.srcElement, "-"); 
//		        break;
//           case "engupspecial": // upper case+number + Space + &*-,./
//	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
//	    	   break;
//	    }
//	}
	function obj_keyup() {
		var formObj=document.form;
		with (formObj) {
			//textarea : except enter 
			if (event.srcElement.type == "textarea") {
				return;
			}			
			if ( window.event.keyCode == 13 ) {
				formObj.curr_rtn_tro_flg.value="";  //default tab clear
				formObj.curr_tro_seq.value="";  //default order clear
		    }
		}
	}     
	function obj_click() {
		var formObj=document.form;
		with(formObj) {
			switch(event.srcElement.name){
	            case "cfm_flg":
	            	//var strToDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //local PC date  
	            	//------------------------------------------------>
	            	//to use system date   
	            	var bReturn=doActionIBSheet(x_sheetObject9, formObj, COMMAND09);	            	
	            	var strToDay=formObj.cfm_sys_date.value;                     //cfm target row(check event row) : changing cfm_dt
	            	//<------------------------------------------------	            	
	            	var bResult=setCfmCheck(strToDay); 
	            	break;
			}
		}
	}	
	/**     
	  * setCfmCheck -> Tro-Master Form  : 
	  */
	function setCfmCheck(toDay) {
		var formObj=document.form;
		with(formObj) {        	
	    	//-------------------------------------------
			//1) cfm_flg : "Y" , Confirm Date setting 
	    	if (cfm_flg.checked) {
	    		cfm_dt.value=toDay;
	    	} else {
	    		cfm_dt.value="";
	    	}
			//-------------------------------------------
			//2) cfm_flg : "Y" , disabled
			if (formObj.cxl_flg.checked || formObj.cfm_flg.checked) {
				ComEnableObject_loc(formObj.cfm_flg, false);	
			} else {
				ComEnableObject_loc(formObj.cfm_flg, true);
			}
		}
	} 	  
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
    	switch(sheetObj.id) {
			case "t2bsheet1":	
				with (sheetObj) {
			        var HeadTitle="|Sel.|||Seq.|Del|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|Pick-Up Date|Pick-Up Date|"+
			        	"Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|CNTR No.|||";
			        var headCount=ComCountHeadTitle(HeadTitle);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = 	[  {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					               {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					               {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",           KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					               {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt_hhmi",   KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt_hhmi",      KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					               {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					               {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
					               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_old",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty_old",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
					               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_old",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetColProperty("dor_arr_dt", {Format:"####-##-##"} );
			        SetColProperty("pkup_dt", {Format:"####-##-##"} );
			        SetWaitImageVisible(0);
			        sheetObj.SetColHidden("chk",1);//chk  : Hidden
			        sheetObj.SetColHidden("tro_seq",1);//tro_seq  : Hidden
			        SetColProperty(0 ,"cntr_tpsz_cd" ,  {AcceptKeys: "E|N" , InputCaseSensitive:1});
			        SetColProperty(0 ,"pkup_loc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			        SetColProperty(0 ,"pkup_yd_cd" , {AcceptKeys:"N|[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"});
			        SetColProperty(0 ,"rtn_loc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			        SetColProperty(0 ,"rtn_yd_cd" , {AcceptKeys:"N|[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"});
			        SetColProperty(0 ,"cmdt_cd" , {AcceptKeys:"N"});
			        SetColProperty(0 ,"cntr_no" , {AcceptKeys:"N|[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"});
			        //no support[check again]CLT 					PopupImage="img/btns_calendar.gif";
			        SetShowButtonImage(2);
			        SetSheetHeight(120);
				}				
				break;
			case "t2bsheet1_b":		
				with (sheetObj) {
			        var HeadTitle="|Sel.|||Seq.|Del|CNTR No.|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|Pick-Up Date|Pick-Up Date|"+
			        "Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|||";
			        var headCount=ComCountHeadTitle(HeadTitle);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				               {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"ComboEdit", Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				               {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				               {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt_hhmi",   KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt_hhmi",      KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
				               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_old",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty_old",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
				               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_old",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetColProperty("dor_arr_dt", {Format:"####-##-##"} );
			        SetColProperty("pkup_dt", {Format:"####-##-##"} );
			        SetWaitImageVisible(0);
		            sheetObj.SetColHidden("chk",1);//chk Hidden
			        sheetObj.SetColHidden("tro_seq",1);//tro_seq Hidden
			        SetColProperty(0 ,"cntr_tpsz_cd" ,  {AcceptKeys: "E|N" , InputCaseSensitive:1});
			        SetColProperty(0 ,"pkup_loc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			        SetColProperty(0 ,"pkup_yd_cd" , {AcceptKeys:"N|[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"});
			        SetColProperty(0 ,"rtn_loc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			        SetColProperty(0 ,"rtn_yd_cd" , {AcceptKeys:"N|[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"});
			        SetColProperty(0 ,"cmdt_cd" , {AcceptKeys:"N"});
			        SetColProperty(0 ,"cntr_no" , {AcceptKeys:"N|[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"});
			        //no support[check again]CLT 					PopupImage="img/btns_calendar.gif";
			        SetShowButtonImage(2);
			        SetSheetHeight(120);
				}
				break;    	
    		case "t2bsheet2":      //t2bsheet2 init : all-master <hidden>  
				with (sheetObj) {				
    		      	var HeadTitle=" |";
    		      	var HeadTitle=" | | | | | | | | | | | | | | | | | | | | | | | | ";  //23 cols
    		      	var headCount=ComCountHeadTitle(HeadTitle);

    		      	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		      	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		      	InitHeaders(headers, info);

    		      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rqst_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"so_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ownr_trk_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"biz_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"cntc_mphn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ack_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"zn_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_pst_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_fax_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_flg_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
    		       
    		      	InitColumns(cols);
    		      	SetEditable(0);
    		      	SetWaitImageVisible(0);
    		            //no support[check again]CLT 					sheetObj.SpeedOption="NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
				}	
			    break;
    		case "t2bsheet2_b":      //t2bsheet2_b init : all-master <hidden>  
				with (sheetObj) { 
    		      	var HeadTitle=" |";
    		      	var HeadTitle=" | | | | | | | | | | | | | | | | | | | | | | | | ";  //25cols
    		      	var headCount=ComCountHeadTitle(HeadTitle);

    		      	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		      	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		      	InitHeaders(headers, info);

    		      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rqst_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"so_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ownr_trk_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"biz_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"cntc_mphn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ack_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"zn_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_pst_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_fax_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_flg_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
    		       
    		      	InitColumns(cols);

    		      	SetEditable(0);
    		      	SetWaitImageVisible(0);
    		            //no support[check again]CLT 					sheetObj.SpeedOption="NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
				}	
			    break;			    
    		case "t2bsheet3":      //t2bsheet3 init : all-detail <hidden>   			
				with (sheetObj) {
    		      	var HeadTitle="|Sel.||Seq.|SubSeq|Del|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|Pick-Up Date|Pick-Up Date|Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|CNTR No.|||";
    		      	var headCount=ComCountHeadTitle(HeadTitle);

    		      	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		      	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		      	InitHeaders(headers, info);

    		      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		    		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
		    		             {Type:"PopupEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt_hhmi",   KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"PopupEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt_hhmi",   	KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		    		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		    		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		    		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		    		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_old",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		    		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty_old",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_old",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    		       
    		      	InitColumns(cols);
    		      	
    		      	SetEditable(0);
    		      	SetColProperty("dor_arr_dt", {Format:"####-##-##"} );
    		      	SetColProperty("pkup_dt", {Format:"####-##-##"} );
    		      	SetWaitImageVisible(0);
    		            //no support[check again]CLT 					sheetObj.SpeedOption="NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
				}
		        break;	
    		case "t2bsheet3_b":      //t2bsheet3 init : all-detail <hidden>   			
				with (sheetObj) {
    		      	var HeadTitle="|Sel.||Seq.|SubSeq|Del|CNTR No.|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|Pick-Up Date|Pick-Up Date|Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|||";
    		      	var headCount=ComCountHeadTitle(HeadTitle);

    		      	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		      	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		      	InitHeaders(headers, info);

    		      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		    		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		    		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
		    		             {Type:"PopupEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt_hhmi",   KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"PopupEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt_hhmi",      KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		    		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		    		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		    		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_old",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		    		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty_old",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_old",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    		       
    		      	InitColumns(cols);

    		      	SetEditable(0);
    		      	SetColProperty("dor_arr_dt", {Format:"####-##-##"} );
    		      	SetColProperty("pkup_dt", {Format:"####-##-##"} );
    		      	SetWaitImageVisible(0);
    		            //no support[check again]CLT 					sheetObj.SpeedOption="NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
				}
		        break;			        
    		case "t2bsheet4":      //t2bsheet4 init : tro_dg_seq all <hidden>  
				with (sheetObj) {				
    		      	var HeadTitle=" | | | |";  //4 cols
    		      	var headCount=ComCountHeadTitle(HeadTitle);

    		      	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		      	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		      	InitHeaders(headers, info);

    		      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		    		             {Type:"DummyCheck", Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
    		       
    		      	InitColumns(cols);

    		      	SetEditable(0);
    		      	SetWaitImageVisible(0);
    		            //no support[check again]CLT 					sheetObj.SpeedOption="NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
				}	
			    break;
    		case "t2bsheet5":      //t2bsheet5 init : sum_qty grid
				with (sheetObj) {				
	    	        var HeadTitle="TP/SZ|Total Qty|TRO Qty";  //3 cols
	    	        var headCount=ComCountHeadTitle(HeadTitle);
	
	    	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	        InitHeaders(headers, info);
	
	    	        var cols =   [ {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	               {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	               {Type:"Int",       Hidden:0,  Width:140,   Align:"Right",   ColMerge:0,   SaveName:"tro_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    	         
	    	        InitColumns(cols);
	
	    	        SetEditable(1);
	    	        SetWaitImageVisible(0);
	    	              //no support[check again]CLT 					sheetObj.SpeedOption="NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
	    	        SetSheetHeight(102);
	    	        SetExtendLastCol(0);
	    	        SetCountPosition(0);
				}	
			    break;
			case "h1sheet1":      //hidden sheet1
				with (sheetObj) {
			      	var HeadTitle="";
			      	var headCount=ComCountHeadTitle(HeadTitle);

			      	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			      	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      	InitHeaders(headers, info);

			      	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			       
			      	InitColumns(cols);

			      	SetEditable(0);
			      	SetWaitImageVisible(0);
				}
				break; 	
    	}    	
    }     
    // handling sheet process
    function doActionIBSheet(sheetObj, formObj, sAction, delFlg) {
    	if (delFlg == null) {
    		delFlg="N";
    	}
     //   sheetObj.ShowDebugMsg = 1;
        switch(sAction) {
			case COMMAND03:      //searching booking split no
				formObj.f_cmd.value=COMMAND03;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02BGS.do", FormQueryString(formObj));
			 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
			 	bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -23); 
			 	break;	
			case COMMAND09:      //searching system_date (local) 
				formObj.f_cmd.value=COMMAND09;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02BGS.do", FormQueryString(formObj));
			 	formObj.cfm_sys_date.value=ComGetEtcData(sXml, "cfm_sys_date");
			 	break;	
          	case IBSEARCH:      //searching hidden Booking  
          	    if(!validateForm(sheetObj,formObj,sAction)) return;  	
             	initSearchVal();  //global variable clear[load status] 
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);				  
				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02BGS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");  
				//ComDebug(arrXml);
				ComOpenWait(false); //waiting box disappear
				if(ComGetEtcData(arrXml[0], "DataYn") == "N") {
					x_sheetObject9.LoadSearchData(arrXml[0],{Sync:1} );
					formObj.bkg_no.value=formObj.oldBkgNo.value;
					formObj.bl_no.value=formObj.oldBlNo.value;
					return;
				} 
				
				x_sheetObject4.RemoveAll();
				x_sheetObject2.RemoveAll();
				x_sheetObject3.RemoveAll();
				x_sheetObject7.RemoveAll();
				x_sheetObject8.RemoveAll();
				x_sheetObject6.RemoveAll();
				x_sheetObject5.RemoveAll();
				//(searching information all): Start------------------------------------------>
                if (arrXml.length > 0) 
				{ 
                    x_sheetObject4.LoadSearchData(arrXml[2],{Sync:1} );
                    ComBkgXml2ComboItem(arrXml[3], dcgo_seq,    "display_nm", "dg_seq"); 
                    ComBkgXml2ComboItem(arrXml[4], rc_seq,      "display_nm", "rf_seq"); 
                    ComBkgXml2ComboItem(arrXml[5], awk_cgo_seq, "awk_seq",    "awk_seq"); 
                    ComBkgXml2ComboItem(arrXml[0], tro_seq,     "tro_seq",    "tro_seq");  
                	x_sheetObject2.LoadSearchData(arrXml[0],{Sync:1} );
                    setEtcDataToForm_bkg(formObj, x_sheetObject2);
                    //max_tro_seq_old : setting
                    var max_tro_seq_old=x_sheetObject2.GetCellValue(x_sheetObject2.RowCount(), "tro_seq");
                    formObj.max_tro_seq_old.value=(nullToBlank(max_tro_seq_old.trim())=="")? "0": max_tro_seq_old;
                    setDataToForm_TroMst(x_sheetObject2.GetCellValue(1, "tro_seq"));
                    changeMasterColor();  //cxl_flg check box : Master , handling update 
                }
                if (arrXml.length > 1) 
				{
                	x_sheetObject3.LoadSearchData(arrXml[1],{Sync:1} ); //x_sheetObject3/tro_dtl    all hidden : general
                    setAllDataToData_TroDtl(tro_seq.GetSelectText());//tro_seq.text //general 탭 셋팅
                } 
                if (arrXml.length > 6) 
				{ 
                	ComBkgXml2ComboItem(arrXml[7], t2_tro_seq, "tro_seq", "tro_seq");  
                	x_sheetObject7.LoadSearchData(arrXml[7],{Sync:1} ); //x_sheetObject7/tro        all hidden : rtn-cago
                	//max_tro_seq_rtn_old : setting
                	var max_tro_seq_rtn_old=x_sheetObject7.GetCellValue(x_sheetObject7.RowCount(), "tro_seq"); //rowcount 가 0 이면 value " "임 
                    formObj.max_tro_seq_rtn_old.value=(nullToBlank(max_tro_seq_rtn_old.trim())=="")? "0": max_tro_seq_rtn_old;
                    setDataToForm_TroMst_rtn(x_sheetObject7.GetCellValue(1, "tro_seq"));
                	changeMasterColor("Y");  //t2_cxl_flg checkbox : Master  handling update 
                }
                if (arrXml.length > 7) 
				{
                	x_sheetObject8.LoadSearchData(arrXml[8],{Sync:1} ); //x_sheetObject8/tro_dtl    all hidden : rtn-cago
                	setAllDataToData_TroDtl(t2_tro_seq.GetSelectText(), "Y"); //formObj.t2_tro_seq.text //return 탭 셋팅
                }
    	  		if (arrXml.length > 8) {
    	  			var arrCombo=ComXml2ComboString(arrXml[9], "val", "name");
    	  			//for (var i=0; i<arrCombo.length; i++) {
    	  			//	alert("arrCombo["+i+"]->"+arrCombo[i]);
    	  			//}
    	  			x_sheetObject6.InitComboNoMatchText(true);
    	  			x_sheetObject6.SetColProperty("cntr_no", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
    	  		}
                //<--------------------------------------------(searching information all): End 
                x_sheetObject5.LoadSearchData(arrXml[6],{Sync:1} );
                changeTroQtyColor(x_sheetObject5);
                //1) tot tro_seq=='0', default seq Add                
                if (formObj.tro_seq_maxcnt.value == "0") {
                	addRow(x_sheetObject2);   // t2_tro_seq 1번이 생긴다.
                } else {
                	if (formObj.curr_rtn_tro_flg.value != "Y" && formObj.curr_tro_seq.value != "") {
                		tro_seq.SetSelectText(formObj.curr_tro_seq.value);//default seq set : onchange!!!!!!!!
                		tabObjects[0].SetSelectedIndex(0);
                	}
                }
                
                if (formObj.t2_tro_seq_maxcnt.value == "0") {
                	addRow(x_sheetObject7);
                } else {
                	if(formObj.curr_tro_seq.value != "") {
	                	t2_tro_seq.SetSelectText(formObj.curr_tro_seq.value);	//default seq set : onchange!!!!!!!!
	               		tabObjects[0].SetSelectedIndex(1);
                	}
                }
                
                if(t2_tro_seq.GetSelectIndex() == "-1") {
                	t2_tro_seq.SetSelectIndex(0);
                }
                
                // 2010.2.18 by jayoung shin
                if('X' == ComGetObjValue(formObj.bkg_sts_cd)){
                	//ComEnableManyTd(false ,"btn_t2bRetrieve","btn_t2bSaveSeq","btn_t2bCancelSeq","btn_t2bRequest","btn_t2bIFInquiry","btn_t2bAddSeq","btn_t2bCopySeq","btn_t2bSave","btn_t2bCancelAll");
                	//ComEnableManyTd(false, "btn_t2bTROCopy"); 
                }else{
                	ComEnableManyTd(true ,"btn_t2bRetrieve","btn_t2bSaveSeq","btn_t2bCancelSeq","btn_t2bRequest","btn_t2bIFInquiry","btn_t2bAddSeq","btn_t2bCopySeq","btn_t2bSave","btn_t2bCancelAll");
                }
                ComSetObjValue(formObj.modify_flag, "N");
                var objs=document.all.item("tabLayer_trob");
                if('none' == objs[0].style.display){
                	ComEnableManyTd(false, "btn_t2bTROCopy"); 
                }
                fnOnSearchEnd();
                //ComOpenWait(false); //waiting box disapear
             	//------------------------------------------------>
             	//setInquiryDisableButton calling event
             	if(ComGetObjValue(document.form.isInquiry) == "Y"){
             		setInquiryDisableButton();
             	}
                //2) C/A button Control
				parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"), 
						             ComGetEtcData(arrXml[0], "ca_flg"), 
						             ComGetEtcData(arrXml[0], "bdr_flg"), 
						             ComGetEtcData(arrXml[0], "ca_exist_flg"), 
						             ComGetEtcData(arrXml[0], "bl_no")); 
                break;
     		case IBSAVE:        //save 		
	 		    if (tabObjects[0].GetSelectedIndex() == 1) 
	 		    {
	 		    	//1) rtn_cago 처리---------------------------------------------------------------------------------------------------
					var currTroSeq_rtn=t2_tro_seq.GetSelectText();
					//master
					setFormToData_TroMst_rtn(currTroSeq_rtn); 							
	 		    	//dtl
					setDataToAllData_TroDtl(currTroSeq_rtn, false, "Y");  //copy
 		    		x_sheetObject8.ColumnSort("tro_seq|tro_sub_seq");     //dtl-all grid(hidden) before saving, Sorting
 					if (delFlg == "C") {
 						for (var i=1; i<=x_sheetObject7.RowCount(); i++) {
 							if (x_sheetObject7.GetCellValue(i, "tro_seq") != currTroSeq_rtn) {
 								x_sheetObject7.SetRowStatus(i, "R");
 							}
 		     		    }
 						for (var i=1; i<=x_sheetObject8.RowCount(); i++) {
 							if (x_sheetObject8.GetCellValue(i, "tro_seq") != currTroSeq_rtn) {
 								x_sheetObject8.SetRowStatus(i, "R");
 							}
 		     		    }
 					}
					if(!validateForm(sheetObj, formObj, sAction, delFlg)) return;  
	          		//(containerVO)----------------------------------------->
	          	    formObj.f_cmd.value=MULTI; 		 
	          	    //formObj.f_del_flg.value = delFlg;  //event (delete:Y, request:R, save:N) -> check add
	          	    if (tabObjects[0].GetSelectedIndex() == 1) {
         		        formObj.curr_rtn_tro_flg.value="Y";                  //default tab setting
         		        formObj.curr_tro_seq.value=t2_tro_seq.GetSelectText();  //default order setting
         		    } else {
         		    	formObj.curr_rtn_tro_flg.value="N";                  //default tab setting
         		    	formObj.curr_tro_seq.value=tro_seq.GetSelectText();     //default order setting
         		    }
	          	    var sheetSaveObjects=new Array();
	          	    sheetSaveObjects[0]=x_sheetObject7;
	          	    sheetSaveObjects[1]=x_sheetObject8;
	          	    
	          	    var sParam1=ComSetPrifix(x_sheetObject7.GetSaveString(true), "t2bsheet2_b_");
	          	    var sParam2=ComSetPrifix(x_sheetObject8.GetSaveString(true), "t2bsheet3_b_");
	          	    //if (sParam1+sParam2 == "") return; 
	          	    var sParam=FormQueryString(formObj); 
	          		sParam += "&" + sParam1; 
	          	    sParam += "&" + sParam2;
	          	    var sXml=sheetObj.GetSaveData("ESM_BKG_0079_02BGS.do", sParam);
	          		formObj.post_flg.value=nullToBlank(ComGetEtcData(sXml, "post_flg"));
	          		sheetSaveObjects[0].LoadSaveData(sXml); //x_sheetObject7
	          		//<------------------------------------------(containerVO)
	          		
	          		if("F" != ComGetEtcData(sXml, "TRANS_RESULT_KEY")) {
	          			doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
	          		}
	          	//1) rtn_cago 처리 ENd ---------------------------------------------------------------------------------------------------
	 		    } 
	 		    else 
	 		    {
	     		    //2) general 처리 ---------------------------------------------------------------------------------------------------
					var currTroSeq=tro_seq.GetSelectText();
	                setFormToData_Tro_dg_seq(currTroSeq); 
	                x_sheetObject4.ColumnSort("tro_seq|spcl_cgo_cd|spcl_cgo_seq");
	     		    //master
		        	setFormToData_TroMst(currTroSeq);   		
		        	//dtl
 		    		setDataToAllData_TroDtl(currTroSeq, false);        //copy    
 		    		x_sheetObject3.ColumnSort("tro_seq|tro_sub_seq");  //dtl-all grid(hidden) before saving, Sorting
 					if (delFlg == "C") {
 						for (var i=1; i<=x_sheetObject2.RowCount(); i++) {
 							if (x_sheetObject2.GetCellValue(i, "tro_seq") != currTroSeq) {
 								//x_sheetObject2.CellValue2(i, "ibflag") = "R";
 								//x_sheetObject2.SetRowStatus(i,"R");
 								x_sheetObject2.SetCellValue(i, "ibflag", "R", false);
 							}
 		     		    }
 						for (var i=1; i<=x_sheetObject3.RowCount(); i++) {
 							if (x_sheetObject3.GetCellValue(i, "tro_seq") != currTroSeq) {
//	 								x_sheetObject3.CellValue2(i, "ibflag") = "R";
 								//x_sheetObject3.SetRowStatus(i,"R");
 								x_sheetObject3.SetCellValue(i, "ibflag", "R", false);
 							}
 		     		    }
 						for (var i=1; i<=x_sheetObject4.RowCount(); i++) {
 							if (x_sheetObject4.GetCellValue(i, "tro_seq") != currTroSeq) {
//	 								x_sheetObject4.CellValue2(i, "ibflag") = "R";
 								//x_sheetObject4.SetRowStatus(i,"R");
 								x_sheetObject4.SetCellValue(i, "ibflag", "R", false);
 							}
 		     		    }
 					} else {
	 		    		for (var i=1; i<=x_sheetObject4.RowCount(); i++) {
//			     		    	x_sheetObject4.CellValue2(i, "ibflag") = "I";
		     		    	//x_sheetObject4.SetRowStatus(i,"I");
	 		    			x_sheetObject4.SetCellValue(i, "ibflag", "I", false);
		     		    }
 					}
					if(!validateForm(sheetObj, formObj, sAction, delFlg)) return;  
	          		//(containerVO)----------------------------------------->
	          	    formObj.f_cmd.value=MULTI; 
	          	    //formObj.f_del_flg.value = delFlg;  //delete event divider(delete:Y, request:R, save:N)
	          	    if (tabObjects[0].GetSelectedIndex() == 1) {
         		        formObj.curr_rtn_tro_flg.value="Y";                  //default tab setting
         		        formObj.curr_tro_seq.value=t2_tro_seq.GetSelectText();  //default order setting
         		    } else {
         		    	formObj.curr_rtn_tro_flg.value="N";                  //default tab setting
         		    	formObj.curr_tro_seq.value=tro_seq.GetSelectText();     //default order setting
         		    }
	          	    var sheetSaveObjects=new Array();
	          	    sheetSaveObjects[0]=x_sheetObject2;
	          	    sheetSaveObjects[1]=x_sheetObject3;
	          	    sheetSaveObjects[2]=x_sheetObject4;
	          	    var sParam1=ComSetPrifix(x_sheetObject2.GetSaveString(true), "t2bsheet2_");
	          	    var sParam2=ComSetPrifix(x_sheetObject3.GetSaveString(true), "t2bsheet3_");
	          	    var sParam3=ComSetPrifix(x_sheetObject4.GetSaveString(),     "t2bsheet4_");
	          	    //if (sParam1+sParam2+sParam3 == "") return;
	          	    var sParam=FormQueryString(formObj);
	          		sParam += "&" + sParam1; 
	          	    sParam += "&" + sParam2; 
	          	    sParam += "&" + sParam3; 
	          	    var sXml=sheetObj.GetSaveData("ESM_BKG_0079_02BGS.do", sParam);
	          		formObj.post_flg.value=nullToBlank(ComGetEtcData(sXml, "post_flg"));
	          		sheetSaveObjects[0].LoadSaveData(sXml);
	          		//<------------------------------------------(containerVO)
	          		
	          		if("F" != ComGetEtcData(sXml, "TRANS_RESULT_KEY")) {
	          			doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
	          		}
	 		    }
	 		   
               break; 
        }
    }
    //initialization
    function initSearchVal() {
    	var formObj=document.form;
    	//page global valuable  clear -> OnLoad
    	x_oldTroSeq=""; 
    	x_oldTroSeq_rtn=""; 
    	x_cancelAllFlg="N";  //Y:cancelAll 
    	x_cancelAllFlg_rtn="N";  //Y:cancelAll 
    	formObj.post_flg.value="N";  //initialization
    }	
    //######################[1. Event]############################################################
    /**
     * Tab click event
     * 
     */
    function tab3_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer_trob");
        var formObj=document.form;
    	objs[nItem].style.display="Inline";
    	objs[beforetab_trob].style.display="none";
    	objs[beforetab_trob].style.zIndex=objs[nItem].style.zIndex -1 ;
    	beforetab_trob=nItem;
    	//Rtn-tab : btn_t2bTROCopy  disabled
    	if (nItem == 1) {    		
    		ComEnableManyTd(false, "btn_t2bTROCopy"); 
    	} else {
    		ComEnableManyTd(true,  "btn_t2bTROCopy");
    	}
    	//return TAB-  cancel booking can be tro 
		if('X' == ComGetObjValue(formObj.bkg_sts_cd)&& nItem != 1){
			//  cancel booking: it can be executed tro 2010.04.06 requested by EY.SHIN
			//ComEnableManyTd(false ,"btn_t2bRetrieve","btn_t2bSaveSeq","btn_t2bCancelSeq","btn_t2bRequest","btn_t2bIFInquiry","btn_t2bAddSeq","btn_t2bCopySeq","btn_t2bSave","btn_t2bCancelAll");
			//ComEnableManyTd(false, "btn_t2bTROCopy"); 
		}else{
			ComEnableManyTd(true ,"btn_t2bRetrieve","btn_t2bSaveSeq","btn_t2bCancelSeq","btn_t2bRequest","btn_t2bIFInquiry","btn_t2bAddSeq","btn_t2bCopySeq","btn_t2bSave","btn_t2bCancelAll");
		}
    }
    /**
    * Tro master : tro_seq changing combo 
    */
    function tro_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var bRtnFlg=null;
    	//-------------------------------------------
    	//1) searching selected tro_seq which is modified
		var currTroSeq=comboObj.GetSelectText();
    	//-------------------------------------------
    	//2) tro-master  
        if (x_oldTroSeq != "") {
    	    setFormToData_TroMst(x_oldTroSeq);
        }
    	setDataToForm_TroMst(currTroSeq);      //changing tro-master Form output(selected tro_seq) 
    	//-------------------------------------------
    	//3) tro-detail 
    	if (x_oldTroSeq != "") {
    	    setDataToAllData_TroDtl(x_oldTroSeq);  //dtl(store) : display->hidden all (except first loading)
    	}
    	setAllDataToData_TroDtl(currTroSeq);   //dtl(load)  : hidden all->display 
    	//-------------------------------------------
    	//4) tro/tro-detail , to use when it saves screen, x_oldTroSeq maintain
    	x_oldTroSeq=currTroSeq;    
    	//-------------------------------------------
    	//5) cxl_flg checkbox : Master handling modification    	
    	changeMasterColor();  
    }
    /**
    * [rtn_cago]Tro master : tro_seq changing combo 
    */
    function t2_tro_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	//-------------------------------------------
    	//1) searching selected tro_seq which is modified
		var currTroSeq_rtn=comboObj.GetSelectText();
    	//-------------------------------------------
    	//2) tro-master  
        if (x_oldTroSeq_rtn != "") {
    	    setFormToData_TroMst_rtn(x_oldTroSeq_rtn);
        }
    	setDataToForm_TroMst_rtn(currTroSeq_rtn);      //tro-master Form Form output(selected tro_seq) 
    	//-------------------------------------------
    	//3) tro-detail
    	if (x_oldTroSeq_rtn != "") {
    		setDataToAllData_TroDtl(x_oldTroSeq_rtn, null, "Y");  //dtl(store) : display->hidden all (except first loading)
        }
    	setAllDataToData_TroDtl(currTroSeq_rtn, "Y");             //dtl(load)  : hidden all->display 
    	//-------------------------------------------
    	//4) tro/tro-detail  to use when it saves screen, x_oldTroSeq maintain
    	x_oldTroSeq_rtn=currTroSeq_rtn; 
    	//-------------------------------------------
    	//5) cxl_flg checkbox : Master  handling modification   	
    	changeMasterColor("Y"); 
    }    
    /**
    * Tro master : dcgo_seq( in case of clicking multi combo, handling event)
    */
    function dcgo_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj=document.form; 
    	setAddRemarkText(comboObj, idx_cd, text); 
    	setComboBackColor(dcgo_seq);
    }
    /**
    * Tro master : rc_seq ( in case of clicking multi combo, handling event)
    */
    function rc_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj=document.form;    	
    	setAddRemarkText(comboObj, idx_cd, text); 
    	setComboBackColor(rc_seq);	
    }    
    /**
    * Tro master : awk_cgo_seq ( in case of clicking multi combo, handling event)
    */
    function awk_cgo_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var formObj=document.form; 
    	setComboBackColor(awk_cgo_seq);	    
    } 
    /**
    * after saving, searching
    */    
    function t2bsheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	if (ErrMsg == "0") {
    		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);	//retrieve call
    	}
    } 
    function t2bsheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	if (ErrMsg == "0") {
    		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);	//retrieve call
    	}
    }     
    
    /**
    * end of searching 
    */  
    function fnOnSearchEnd(sheetObj, ErrMsg) {
    		var formObj=document.form;
    		with(formObj) {
    		    if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
	    			if (diff_rmk.value == "") {
	    			    diff_rmk.value="Food Grade, Hide ";
	    			}
	    			if (t2_diff_rmk.value == "") {
	    				t2_diff_rmk.value="Food Grade, Hide ";
	    			}
    		    } 
    		    else if (fd_grd_flg.value == "Y") {
	    			if (diff_rmk.value == "") {
	    			    diff_rmk.value="Food Grade ";
	    			}
	    			if (t2_diff_rmk.value == "") {
	    				t2_diff_rmk.value="Food Grade ";
	    			}
    		    }
    		    else if (spcl_hide_flg.value == "Y") {
	    			if (diff_rmk.value == "") {
	    			    diff_rmk.value="Hide ";
	    			}
	    			if (t2_diff_rmk.value == "") {
	    				t2_diff_rmk.value="Hide ";
	    			}
    		    }
    		}
    	}
    /**
    * after saving, searching 
    */ 
    function t2bsheet2_b_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	if (ErrMsg.length > 9 && ErrMsg.substr(0,9) == "[Success]") {
    		doActionIBSheet(x_sheetObject7, document.form, IBSEARCH);	//retrieve call
    	}
    }
    /**
    * after finishing Request , searching
    */    
    function h1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var sheetObj_all=null;
	    if (tabObjects[0].GetSelectedIndex() == 1) {
    		sheetObj_all=x_sheetObject7; 
    	} else {
    		sheetObj_all=x_sheetObject2; 
    	}
    	//if (ErrMsg.trim() == msgs['BKG02043'].trim()) {
    		doActionIBSheet(sheetObj_all, document.form, IBSEARCH); 
    	//}
    } 
    /**
    *  calendar pop up
    */
    function t2bsheet1_OnPopupClick(sheetObj, row,col){
    	if (sheetObj.ColSaveName(col) == "dor_arr_dt" || sheetObj.ColSaveName(col) == "pkup_dt") {
            var cal=new ComCalendarGrid("myCal");
            cal.select(sheetObj, row, col, 'yyyy-MM-dd');
        }
    }    
    /**
    * [rtn_cago] calendar pop up
    */
    function t2bsheet1_b_OnPopupClick(sheetObj, row,col){
    	if (sheetObj.ColSaveName(col) == "dor_arr_dt" || sheetObj.ColSaveName(col) == "pkup_dt") {
            var cal=new ComCalendarGrid("myCal");
            cal.select(sheetObj, row, col, 'yyyy-MM-dd');
        }
    }      
    function t2bsheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	var colId=sheetObj.ColSaveName(Col);
        var formObj=document.form; 
        with(formObj) {
            switch(colId) {
				case "cntr_tpsz_cd":					
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "tro_qty", false);
	            	}
					break;
				case "tro_qty": 
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 3) {
	            		sheetObj.SelectCell(Row, "dor_arr_dt", false);
	            	}
					break;
				case "dor_arr_dt":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 10) {
	            		sheetObj.SelectCell(Row, "dor_arr_dt_hhmi", false);
	            	}
					break;					
				case "dor_arr_dt_hhmi":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 4) {
	            		sheetObj.SelectCell(Row, "pkup_dt", false);
	            	}
					break;
				case "pkup_dt":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 10) {
	            		sheetObj.SelectCell(Row, "pkup_dt_hhmi", false);
	            	}
					break;					
				case "pkup_dt_hhmi":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 4) {
	            		sheetObj.SelectCell(Row, "pkup_loc_cd", false);
	            	}
					break;
				case "pkup_loc_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 5) {
	            		sheetObj.SelectCell(Row, "pkup_yd_cd", false);
	            	}
					break;					
				case "pkup_yd_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "rtn_loc_cd", false);
	            	}
					break;
				case "rtn_loc_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 5) {
	            		sheetObj.SelectCell(Row, "rtn_yd_cd", false);
	            	}
					break;
	         }
        }
	} 
    function t2bsheet1_b_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	var colId=sheetObj.ColSaveName(Col);
        var formObj=document.form; 
        with(formObj) {
            switch(colId) {
                case "cntr_no":
                	var valType=sheetObj.GetEditText();
	            	if (valType.length == 14) {
	            		//sheetObj.SelectCell(Row, "cntr_tpsz_cd", false);
	            		sheetObj.SelectCell(Row, "dor_arr_dt", false);
	            	}
                	break; 
				case "cntr_tpsz_cd":					
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "dor_arr_dt", false);
	            	}
					break;
				case "dor_arr_dt":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 10) {
	            		sheetObj.SelectCell(Row, "dor_arr_dt_hhmi", false);
	            	}
					break;					
				case "dor_arr_dt_hhmi":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 4) {
	            		sheetObj.SelectCell(Row, "pkup_dt", false);
	            	}
					break;
				case "pkup_dt":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 10) {
	            		sheetObj.SelectCell(Row, "pkup_dt_hhmi", false);
	            	}
					break;					
				case "pkup_dt_hhmi":
					var valType=ComReplaceStr(sheetObj.GetEditText(), "_", "");
	            	if (valType.length == 4) {
	            		sheetObj.SelectCell(Row, "pkup_loc_cd", false);
	            	}
					break;
				case "pkup_loc_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 5) {
	            		sheetObj.SelectCell(Row, "pkup_yd_cd", false);
	            	}
					break;					
				case "pkup_yd_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "rtn_loc_cd", false);
	            	}
					break;
				case "rtn_loc_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 5) {
	            		sheetObj.SelectCell(Row, "rtn_yd_cd", false);
	            	}
					break;
				case "rtn_yd_cd":
					var valType=sheetObj.GetEditText();
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "cmdt_cd", false);
	            	}
					break;
	         }
        }
	} 
    function t2bsheet1_OnChange(sheetObj, Row, Col, Val) {
    	var colId=sheetObj.ColSaveName(Col);
        var formObj=document.form; 
        with(formObj) {
            switch(colId) {
				case "cntr_tpsz_cd":
					if ("Y" == sheetObj.GetCellValue(Row, "cxl_flg") || "D" == sheetObj.GetCellValue(Row, "ibflag")) {
						//Cancel/Delete is not included in troqty sum
						return; 
					}
					var preVal_type=sheetObj.GetCellValue(Row, "cntr_tpsz_cd_old");
					var nxtVal_type=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
	            	if (nxtVal_type != preVal_type) {
	            		//var preTroQty = sheetObj.CellValue(Row, "tro_qty_old");
	            		var preTroQty=BkgNullToString(sheetObj.GetCellValue(Row, "tro_qty_old"), "0");
	            		//var nxtTroQty = sheetObj.CellValue(Row, "tro_qty");
	            		var nxtTroQty=BkgNullToString(sheetObj.GetCellValue(Row, "tro_qty"), "0");  //""
	            		changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, Row);
	            	}
					break;
				case "tro_qty": 
					if ("Y" == sheetObj.GetCellValue(Row, "cxl_flg") || "D" == sheetObj.GetCellValue(Row, "ibflag")) {
						//Cancel/Delete is not included in  troqty sum
						return; 
					}
					//var preTroQty = sheetObj.CellValue(Row, "tro_qty_old");
					var preTroQty=BkgNullToString(sheetObj.GetCellValue(Row, "tro_qty_old"), "0");
            		//var nxtTroQty = sheetObj.CellValue(Row, "tro_qty");	
					var nxtTroQty=BkgNullToString(sheetObj.GetCellValue(Row, "tro_qty"), "0");  //""
	            	if (nxtTroQty != preTroQty) {
	            		var preVal_type=sheetObj.GetCellValue(Row, "cntr_tpsz_cd_old");
	            		var nxtVal_type=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
	            		changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, Row, "Q");
	            	}
					break;
				case "dor_arr_dt":
					if (Val != "") {
						var t_dor_arr_dt=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "dor_arr_dt")),      "-", "");
						var t_dor_arr_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "dor_arr_dt_hhmi")), ":", "");
		    			if (t_dor_arr_dt_hhmi == "") {
		    				t_dor_arr_dt_hhmi="0000"; 
		    			}
		    			var t_arr_dt=t_dor_arr_dt + t_dor_arr_dt_hhmi;	
	    				var t_etb_dt=etb_dt.value;
						if (t_etb_dt != "" && t_arr_dt.substr(0,8) > t_etb_dt.substr(0,8)) {
							ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.GetCellValue(Row, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(Row, "tro_sub_seq")+"] Door Arrival Date", "ETB Date("+t_etb_dt+")", "lesser");
							return false;  
						}
						if (t_dor_arr_dt_hhmi == "") {
						    sheetObj.SetCellValue(Row, "dor_arr_dt_hhmi","00:00",0);
						}
					} 
					break;
				case "pkup_dt":
					var t_pkup_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "pkup_dt_hhmi")), ":", "");
	    			if (t_pkup_dt_hhmi == "") {
					    sheetObj.SetCellValue(Row, "pkup_dt_hhmi","00:00",0);
	    			}
					break;
	         }
        }
	}  
    function t2bsheet1_b_OnChange(sheetObj, Row, Col, Val) {
    	var colId=sheetObj.ColSaveName(Col);
        var formObj=document.form; 
        with(formObj) {
            switch(colId) {
				/* : rtn is not used  
								case "cntr_tpsz_cd": 
				if ("Y" == sheetObj.GetCellValue(Row, "cxl_flg") || "D" == sheetObj.GetCellValue(Row, "ibflag")) {
										//Cancel/Delete is not included in  troqty sum
										return; 
									}
				var preVal_type=sheetObj.GetCellValue(Row, "cntr_tpsz_cd_old");
									var nxtVal_type=Val;  //"cntr_tpsz_cd"
					            	if (nxtVal_type != preVal_type) {
					            		//var preTroQty = sheetObj.CellValue(Row, "tro_qty_old");
				var preTroQty=BkgNullToString(sheetObj.GetCellValue(Row, "tro_qty_old"), "0");
					            		//var nxtTroQty = sheetObj.CellValue(Row, "tro_qty");
				var nxtTroQty=BkgNullToString(sheetObj.GetCellValue(Row, "tro_qty"), "0");  //"" :
	            		changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, Row); 
	            	}
					break;
				 */ 
				case "cntr_no": 
	                // getting cntr tpsz and  setting data. it shows message[BKG00173],if you input wrong Container No.
					var tCntrNo=sheetObj.GetCellValue(Row, "cntr_no").trim();
	                //sheetObj.CellValue2(Row, "cntr_no") = tCntrNo;
	    			if (tCntrNo.length > 9) {
	                	f_cmd.value=SEARCH01;	
	                	var param="cntr_no="+tCntrNo;	
	                	var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02BGS.do", FormQueryString(formObj)+"&"+param);
	        			var cntr_tpsz_cd=ComGetEtcData(sXml, "cntr_tpsz_cd");
	        			if(cntr_tpsz_cd == "") {
	        				sheetObj.SetCellValue(Row, Col,"",0);//if you input cntr_no which has not type size, cntr_no should be cleared.(
	        				sheetObj.SetCellValue(Row, "cntr_tpsz_cd","",0);
	        				ComShowCodeMessage("BKG00095");     //ComGetMsg("BKG00173", tCntrNo);     
	        				sheetObj.SelectCell(Row, Col);
	        				return;	
	        			} else {
	        				sheetObj.SetCellValue(Row, "cntr_tpsz_cd",cntr_tpsz_cd,0);
	        			}
	    			}	                
	                break;
				case "dor_arr_dt":
					if (Val != "") {
						var t_dor_arr_dt=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "dor_arr_dt")),      "-", "");
						var t_dor_arr_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "dor_arr_dt_hhmi")), ":", "");
		    			if (t_dor_arr_dt_hhmi == "") {
		    				t_dor_arr_dt_hhmi="0000"; 
		    			}
		    			var t_arr_dt=t_dor_arr_dt + t_dor_arr_dt_hhmi;	
	    				var t_etb_dt=etb_dt.value;
						if (t_etb_dt != "" && t_arr_dt.substr(0,8) > t_etb_dt.substr(0,8)) {
							ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.GetCellValue(Row, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(Row, "tro_sub_seq")+"] Door Arrival Date", "ETB Date("+t_etb_dt+")", "lesser");
							return false;  
						}
						if (t_dor_arr_dt_hhmi == "") {
						    sheetObj.SetCellValue(Row, "dor_arr_dt_hhmi","00:00",0);
						}
					}					
					break;
				case "pkup_dt":
					var t_pkup_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "pkup_dt_hhmi")), ":", "");
	    			if (t_pkup_dt_hhmi == "") {
					    sheetObj.SetCellValue(Row, "pkup_dt_hhmi","00:00",0);
	    			}
					break;
	         }
        }
	} 
	/**
	 * Tro-Master : Mater (prohibiting modification)
	 */    
    function changeMasterColor(bRtnFlg) {
	 	var formObj=document.form;
	 	var objCxlFlg=null;
	 	var objCfmFlg=null;
	 	var objAckStsCd=null; 
	 	var t_max_tro_seq_old=null;
	 	var t_currTroSeq=null;	
	 	var t_objNm_actStsCd=null;
	 	if (bRtnFlg == null) {
	 		bRtnFlg="N"; 
	 	}
	 	if (bRtnFlg == "Y") {
	 		objCxlFlg=formObj.t2_cxl_flg;
	 		t_max_tro_seq_old=(nullToBlank(formObj.max_tro_seq_rtn_old.value)=="")? "0" : formObj.max_tro_seq_rtn_old.value; 
		    t_currTroSeq=t2_tro_seq.GetSelectText();
		    objAckStsCd=formObj.t2_ack_sts_cd;
		    t_objNm_actStsCd="t2_ack_sts_cd"
	 	} else {
	 		objCxlFlg=formObj.cxl_flg;
	 		objCfmFlg=formObj.cfm_flg;
	 		t_max_tro_seq_old=(nullToBlank(formObj.max_tro_seq_old.value)=="")? "0" : formObj.max_tro_seq_old.value; 
		    t_currTroSeq=tro_seq.GetSelectText();
		    objAckStsCd=formObj.ack_sts_cd;
		    t_objNm_actStsCd="ack_sts_cd"
	 	}
	 	//Request Result : color change
	 	if (objAckStsCd.value == "Success") {
//	 		document.getElementById(t_objNm_actStsCd).style.color="#0000ff";
	 		document.getElementById(t_objNm_actStsCd).style.setProperty("color", BTN_BLUE, "important");
	 	} else {
//	 		document.getElementById(t_objNm_actStsCd).style.color="#ff0000";	//red
	 		document.getElementById(t_objNm_actStsCd).style.setProperty("color", BTN_RED, "important");
	 	}
	 	//-------------------------------------------
	 	//1) cxl_flg/cfm_flg checkbox : Master handling midification	
		if (objCxlFlg.checked || (bRtnFlg != "Y" && objCfmFlg.checked)) {
			changeEnabled_master(false, bRtnFlg);			
		} else {
			changeEnabled_master(true, bRtnFlg);
			setChangeAllComboBackColor();  //in case of existing combo item, changing background color
		}
    	//----------------------
    	//3) tro_seq, SaveSeq button control
        //copyCntr/addCntr  (max_seq+1 < seq) saveSeq button disabled -> SaveAll    
	    if (parseInt(t_currTroSeq) > parseInt(t_max_tro_seq_old)+1) {
	    	ComEnableManyTd(false, "btn_t2bSaveSeq"); 
	    } else {
	    	ComEnableManyTd(true, "btn_t2bSaveSeq"); 
	    }	 	
	    
	    //4) BKG_TRO, CFM_FLG = 'Y' enable 로직
	    if (bRtnFlg != "Y" && objCfmFlg.checked){
	    	with(formObj) {
		 		ComEnableManyObjects_loc(true, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, 
	                        				   dor_loc_cd, zn_cd, dor_pst_no, biz_rgst_no, cntc_pson_nm, 
	                        				   cntc_phn_no, cntc_fax_no, cntc_mphn_no, act_shpr_addr, diff_rmk,
	                        				   btns_popActCust, btns_popLocation);
		 	}
	    }	    
    }    
	 /**
	  * Tro-Master : cancel prohibiting modification
	  */
	function changeEnabled_master(bFlag, bRtnFlg) {
		var formObj=document.form;
	 	if (bRtnFlg == "Y") {
			with(formObj) {
		 		ComEnableManyObjects_loc(bFlag, t2_ownr_trk_flg, t2_act_shpr_cnt_cd, t2_act_shpr_seq, t2_act_shpr_nm, 
		 				                        t2_dor_loc_cd, t2_zn_cd, t2_biz_rgst_no, t2_dor_pst_no, t2_cntc_pson_nm, 
		 				                        t2_cntc_phn_no, t2_cntc_fax_no, t2_cntc_mphn_no, t2_act_shpr_addr, t2_diff_rmk, 
		 				                        t2_btns_popActCust, t2_btns_popLocation);
			    ComEnableManyTd         (bFlag, "t2_btn_t2bAdd", "t2_btn_t2bDelete", "t2_btn_t2bCopy");
		 	}
	 	} else {
			with(formObj) {
		 		ComEnableManyObjects_loc(bFlag, ownr_trk_flg, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, 
		 				                        dor_loc_cd, zn_cd, dor_pst_no, biz_rgst_no, cfm_flg, 
		 				                        cntc_pson_nm, cntc_phn_no, cntc_fax_no, cntc_mphn_no, act_shpr_addr, diff_rmk, 
		 				                        btns_popActCust, btns_popLocation);
//			    ComEnableManyIBCombo    (bFlag, dcgo_seq, rc_seq, awk_cgo_seq);
//		 		args[i].Enable = bFlag;
		 		comboObjects[1].SetEnable(bFlag);
		 		comboObjects[2].SetEnable(bFlag);
		 		comboObjects[3].SetEnable(bFlag);
			    ComEnableManyTd         (bFlag, "btn_t2bAdd", "btn_t2bDelete", "btn_t2bCopy");
		 	}
	 	}
    }
    //######################[2. Button Proc : Add/Copy/Cancel/Confirm/Sumqty]#####################
	/**     
	  * cancelAll 
	  */
    function cancelAll() {
	    var formObj=document.form; 
	    var sheetObj_all=null; 
	    var sheetObj_all_dtl=null; 
	    if (tabObjects[0].GetSelectedIndex() == 1) {
    		sheetObj_all=x_sheetObject7; 
    		sheetObj_all_dtl=x_sheetObject8; 
    	} else {
    		sheetObj_all=x_sheetObject2; 
    		sheetObj_all_dtl=x_sheetObject3; 
    	}	    	
	    sheetObj_all_dtl.ReDraw=false;
	    for (var i=1; i<=sheetObj_all_dtl.RowCount(); i++)
	    {
	    	if ("Y" != sheetObj_all_dtl.GetCellValue(i, "cxl_flg"))
			{
			    sheetObj_all_dtl.SetCellValue(i, "cxl_flg","Y",0);
			    if (tabObjects[0].GetSelectedIndex() == 0) {
		            //changing sum-qty  
		            var PM_gubun="M";  //P:Plus, M:Minus 
		            var p_Row=i;
		            var p_currVal_type=sheetObj_all_dtl.GetCellValue(p_Row, "cntr_tpsz_cd");
		            //var p_currTroQty   = sheetObj_all_dtl.CellValue(p_Row, "tro_qty");
		            var p_currTroQty=BkgNullToString(sheetObj_all_dtl.GetCellValue(p_Row, "tro_qty"), "0");
		            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun); 	
			    }
			}
	    }	
	    sheetObj_all_dtl.ReDraw=true;
	    sheetObj_all.ReDraw=false;
	    for (var i=1; i<=sheetObj_all.RowCount(); i++)
	    {
	    	if ("Y" != sheetObj_all.GetCellValue(i, "cxl_flg"))
	    	{
	            sheetObj_all.SetCellValue(i, "cxl_flg","Y",0);
	    	}
	    }
	    sheetObj_all.ReDraw=true;
	    //changing output  : synchronization
	    cancelSeq("Y");	 
	    //x_cancelAllFlg : changing global valuable
	    if (tabObjects[0].GetSelectedIndex() == 1) {
	        x_cancelAllFlg_rtn="Y";
	    } else {
	    	x_cancelAllFlg="Y";
	    }
	}
	/**     
	  * cancelSeq
	  */
	function cancelSeq(all_gubun) {
  	    var formObj=document.form; 
  	    var chkObjCxlflg=null;
		var sheetObj_dtl=null; 
		var bRtnFlg=null;
		if (tabObjects[0].GetSelectedIndex() == 1) {
    		sheetObj_dtl=x_sheetObject6;
    		chkObjCxlflg=formObj.t2_cxl_flg;
    		bRtnFlg="Y";
    	} else {
    		sheetObj_dtl=x_sheetObject1;
    		chkObjCxlflg=formObj.cxl_flg;
    		bRtnFlg="N";
    	}
		if (all_gubun == null) {
			all_gubun="N";
		}
		//-------------------------------------------
		//1) tro-master : cancel
		chkObjCxlflg.checked=true;
		//-------------------------------------------
		//2) tro-detail : cancel
		for (var i=sheetObj_dtl.RowCount(); i>=1; i--)
		{
			if ("Y" != sheetObj_dtl.GetCellValue(i, "cxl_flg"))
			{
			    if (tabObjects[0].GetSelectedIndex() == 0) {
		            //changing sum-qty  
		            var PM_gubun="M";  //P:Plus, M:Minus 
		            var p_Row=i;
		            var p_currVal_type=sheetObj_dtl.GetCellValue(p_Row, "cntr_tpsz_cd");
		            //var p_currTroQty   = sheetObj_dtl.CellValue(p_Row, "tro_qty");
		            var p_currTroQty=BkgNullToString(sheetObj_dtl.GetCellValue(p_Row, "tro_qty"), "0");
		            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);
			    }
	            //sheetObj_dtl.CellValue2(i, "cxl_flg") = "Y"; 
			    if (sheetObj_dtl.GetCellValue(i, "ibflag") == "I") {
	            	//sheetObj_dtl.CellValue2(i, "ibflag") = "D";
	            	sheetObj_dtl.SetRowStatus(i,"D");
	            } else {
	            	sheetObj_dtl.SetCellValue(i, "cxl_flg","Y",0);
	            	sheetObj_dtl.SetRangeFontColor(i, 0, i, sheetObj_dtl.LastCol(),"#FF0000");
	            	sheetObj_dtl.SetCellFont("FontStrikethru", i, 0, i, sheetObj_dtl.LastCol(),1);
	            	changeAllGetCellEditable(sheetObj_dtl, i, 3, sheetObj_dtl.LastCol(), false);
	            }
			}
		}
		if (chkObjCxlflg.checked) {
			changeEnabled_master(false, bRtnFlg);  //cancelSeq시, Master prohibiting modification	
		} else {
			changeEnabled_master(true,  bRtnFlg);  //cancelSeq시, Master prohibiting modification	
		}
		return true;
	}
	/**     
	  * cancel_dtl
	  */
	function cancelDtl(sheetObj, colId) {
  	    var formObj=document.form; 
		//1) tro-detail : cancel
        var sRow=sheetObj.FindCheckedRow(colId);
//      // ACTIVE 버젼처럼 추가해준다.
        if(sRow.length >0 ) {
     	   sRow = sRow +"|";
        }
        var arrRow=sRow.split("|");
        for (var idx=arrRow.length-1; idx>=0; idx--)
        { 
        	if ("Y" != sheetObj.GetCellValue(arrRow[idx], "cxl_flg"))
        	{	
	           	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);    	
	         	if (strSheetId_gubun != "_b") {   
		            //changing sum-qty 
		            var PM_gubun="M";  //P:Plus, M:Minus 
		            var p_Row=arrRow[idx];
		            var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
		            //var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty");
		            var p_currTroQty=BkgNullToString(sheetObj.GetCellValue(p_Row, "tro_qty"), "0");
		            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);         	
	         	}
	         	if (sheetObj.GetCellValue(arrRow[idx], "ibflag") == "I") {
//	     	         sheetObj.CellValue2    (arrRow[idx], "ibflag")  = "D";
	     	         sheetObj.SetRowStatus(arrRow[idx],"D");
	            } else {
	            	 sheetObj.SetCellValue(arrRow[idx], "cxl_flg","Y",0);
	         	     //sheetObj.CellValue2    (arrRow[idx], "del")     = "Y";
	         	     sheetObj.SetRangeFontColor(arrRow[idx], 0, arrRow[idx], sheetObj.LastCol(),"#FF0000");
	         	     sheetObj.SetCellFont("FontStrikethru", arrRow[idx], 0, arrRow[idx], sheetObj.LastCol(),1);
	         	     changeAllGetCellEditable(sheetObj, arrRow[idx], 3, sheetObj.LastCol(), false);
	            }   
        	}
        }
        return true;
	}
	/**     
	 *  CopySeq-  controlling dtl AllCopy 
	 */
    function copyAllRow_dtl(sheetObj, newTroSeq, sheetObj_copy, copyTroSeq) { 	
    	for (var i=1; i<=sheetObj_copy.RowCount(); i++) {
    		addRow(sheetObj, "C", i, newTroSeq, sheetObj_copy);  //i : copyRow, sheetObj:x_sheetObject3, sheetObj_copy:x_sheetObject1 
    	} 
    }
	/**     
	 *  Copy , controlling 
	 */
	function copyRow(sheetObj) {
	  	var formObj=document.form;	  
	  	var cmbObjTroseq=null;
	  	var txtObjTrocopycnt=null;
	  	var chkObjCxlflg=null;
    	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);
    	if (strSheetId_gubun == "_b") {
    		chkObjCxlflg=formObj.t2_cxl_flg;
    		cmbObjTroseq=formObj.t2_tro_seq;
    		txtObjTrocopycnt=formObj.t2_tro_copy_cnt;
    	} else {
    		chkObjCxlflg=formObj.cxl_flg; 
    		cmbObjTroseq=tro_seq;
    		txtObjTrocopycnt=formObj.tro_copy_cnt;
    	} 
	    //CancelSeq, copy is prohibited.
	  	if (chkObjCxlflg.checked) {
	  		callShowMessageReProc("CancelSeq", "Copy");
	  		return;
	  	} 
		sheetObj.ReDraw=false;
	    if (sheetObj.id == "t2bsheet2" || sheetObj.id == "t2bsheet2_b")       //master
	    {
	    	var nCopyRow=sheetObj.FindText("tro_seq", cmbObjTroseq.GetSelectText());
		    addRow(sheetObj, "C", nCopyRow);  
	    } 
	    else if (sheetObj.id == "t2bsheet1" || sheetObj.id == "t2bsheet1_b")  //dtl
	    { 	
			var strCopyCnt=txtObjTrocopycnt.value;	
		    if (strCopyCnt == "") {
		    	strCopyCnt="1";  // default : 1 
		    }
		    var nCopyCnt=parseInt(strCopyCnt);
	    	var nCopyRow=sheetObj.GetSelectRow();
	    	if (nCopyRow < 0) {
	    		nCopyRow=0; 
	    	}
			for (var i=0; i<nCopyCnt; i++) {
				addRow(sheetObj, "C", nCopyRow);  
			}
		}
    	if (strSheetId_gubun == "_b") {
    		ComSetObjValue(t2_tro_seq, ComGetObjValue(formObj.t2_tro_seq_maxcnt)); 
    		t2_tro_seq_OnChange(t2_tro_seq, t2_tro_seq.GetSelectIndex(), t2_tro_seq.GetSelectText(), t2_tro_seq.GetSelectCode, '', '','');
    	} else {
    		ComSetObjValue(tro_seq, ComGetObjValue(formObj.tro_seq_maxcnt)); 
			tro_seq_OnChange(tro_seq, tro_seq.GetSelectIndex(), tro_seq.GetSelectText(), tro_seq.GetSelectCode(), '', '', '');
    	} 
	    sheetObj.ReDraw=true;
	}
	function setDataCopy(sheetObj, nNewRow, nCopyRow) {
    	// copy seq - copy data set 
		//sheetObj.CellValue2(nNewRow, "rqst_dt")          = sheetObj.CellValue(nCopyRow, "rqst_dt");    	
		sheetObj.SetCellValue(nNewRow, "act_shpr_cnt_cd",sheetObj.GetCellValue(nCopyRow, "act_shpr_cnt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_seq",sheetObj.GetCellValue(nCopyRow, "act_shpr_seq"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_nm",sheetObj.GetCellValue(nCopyRow, "act_shpr_nm"),0);
		sheetObj.SetCellValue(nNewRow, "dor_loc_cd",sheetObj.GetCellValue(nCopyRow, "dor_loc_cd"),0);
		sheetObj.SetCellValue(nNewRow, "zn_cd",sheetObj.GetCellValue(nCopyRow, "zn_cd"),0);
		sheetObj.SetCellValue(nNewRow, "dor_pst_no",sheetObj.GetCellValue(nCopyRow, "dor_pst_no"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_addr",sheetObj.GetCellValue(nCopyRow, "act_shpr_addr"),0);
		sheetObj.SetCellValue(nNewRow, "cntc_pson_nm",sheetObj.GetCellValue(nCopyRow, "cntc_pson_nm"),0);
		sheetObj.SetCellValue(nNewRow, "diff_rmk",sheetObj.GetCellValue(nCopyRow, "diff_rmk"),0);
		sheetObj.SetCellValue(nNewRow, "cntc_phn_no",sheetObj.GetCellValue(nCopyRow, "cntc_phn_no"),0);
		sheetObj.SetCellValue(nNewRow, "cntc_fax_no",sheetObj.GetCellValue(nCopyRow, "cntc_fax_no"),0);
    	//sheetObj.CellValue2(nNewRow, "rc_seq")           = sheetObj.CellValue(nCopyRow, "rc_seq");
    	//sheetObj.CellValue2(nNewRow, "awk_cgo_seq")      = sheetObj.CellValue(nCopyRow, "awk_cgo_seq");	   
    	//hidden  
        //sheetObj.CellValue2(nNewRow, "cxl_flg")          = sheetObj.CellValue(nCopyRow, "cxl_flg");
    	//sheetObj.CellValue2(nNewRow, "cfm_flg")          = sheetObj.CellValue(nCopyRow, "cfm_flg");
    	//sheetObj.CellValue2(nNewRow, "cfm_dt")           = sheetObj.CellValue(nCopyRow, "cfm_dt");   
    	sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
    	sheetObj.SetCellValue(nNewRow, "cfm_flg","N",0);
    	sheetObj.SetCellValue(nNewRow, "cxl_flg_old","N",0);
    	sheetObj.SetCellValue(nNewRow, "cfm_flg_old","N",0);
	}
	function setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy) {
	    var formObj=document.form;
	    if (sheetObj_copy == null) {
	    	sheetObj_copy=sheetObj;
	    }
	    sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd",sheetObj_copy.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);
	    sheetObj.SetCellValue(nNewRow, "tro_qty",sheetObj_copy.GetCellValue(nCopyRow, "tro_qty"),0);
	    sheetObj.SetCellValue(nNewRow, "dor_arr_dt",sheetObj_copy.GetCellValue(nCopyRow, "dor_arr_dt"),0);
		sheetObj.SetCellValue(nNewRow, "dor_arr_dt_hhmi",sheetObj_copy.GetCellValue(nCopyRow, "dor_arr_dt_hhmi"),0);
	    sheetObj.SetCellValue(nNewRow, "pkup_dt",sheetObj_copy.GetCellValue(nCopyRow, "pkup_dt"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_dt_hhmi",sheetObj_copy.GetCellValue(nCopyRow, "pkup_dt_hhmi"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_loc_cd",sheetObj_copy.GetCellValue(nCopyRow, "pkup_loc_cd"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_yd_cd",sheetObj_copy.GetCellValue(nCopyRow, "pkup_yd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "rtn_loc_cd",sheetObj_copy.GetCellValue(nCopyRow, "rtn_loc_cd"),0);
		sheetObj.SetCellValue(nNewRow, "rtn_yd_cd",sheetObj_copy.GetCellValue(nCopyRow, "rtn_yd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cmdt_cd",sheetObj_copy.GetCellValue(nCopyRow, "cmdt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_no",sheetObj_copy.GetCellValue(nCopyRow, "cntr_no"),0);
		//sheetObj.CellValue2(nNewRow, "cxl_flg")         = sheetObj_copy.CellValue(nCopyRow, "cxl_flg");	
		//sheetObj.CellValue2(nNewRow, "del")             = sheetObj_copy.CellValue(nCopyRow, "del");  
		sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
		sheetObj.SetCellValue(nNewRow, "cxl_flg_old","N",0);
		sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd_old",sheetObj_copy.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);//copy , new -> old
		sheetObj.SetCellValue(nNewRow, "tro_qty_old",sheetObj_copy.GetCellValue(nCopyRow, "tro_qty"),0);//copy , tro_qty -> tro_qty_old
	}
   function copyTrodgseq(copy_tro_seq, new_tro_seq) {
	   var sheetObj=x_sheetObject4;  
       //1) dtl check (tro_seq) 
	   sheetObj.CheckAll("del_chk",0,1);//hidden chk : check clear
       //2) checking copy_tro_seq  
       var nRow=0;  //findRow 
       var nStartRow=0;  //find Start Index 
       while (nRow > -1) {
    	   nRow=sheetObj.FindText("tro_seq", copy_tro_seq, nStartRow);
    	   if (nRow > -1) {    		   
    		   sheetObj.SetCellValue(nRow, "del_chk","Y",0);
    		   nStartRow=nRow+1;
    	   }
       } 
       //3) sheetObj.copy 
       var sRow=sheetObj.FindCheckedRow("del_chk");
//     // ACTIVE 버젼처럼 추가해준다.
       if(sRow.length >0 ) {
    	   sRow = sRow +"|";
       }
       var arrRow=sRow.split("|");
       for (var idx=0; idx<=arrRow.length-2; idx++)
       { 
	       var nNewRow=sheetObj.DataInsert(-1);
	       sheetObj.SetCellValue(nNewRow, "tro_seq",new_tro_seq,0);
	       sheetObj.SetCellValue(nNewRow, "spcl_cgo_cd",sheetObj.GetCellValue(arrRow[idx], "spcl_cgo_cd"),0);
	       sheetObj.SetCellValue(nNewRow, "spcl_cgo_seq",sheetObj.GetCellValue(arrRow[idx], "spcl_cgo_seq"),0);
       }
   }  
    /**     
    * AddRow, controlling
    */
    //function addRow(sheetObj, NCflag, nCopyRow) {  //addRow(sheetObj, "C", i, newTroSeq, sheetObj_copy); 
    function addRow(sheetObj, NCflag, nCopyRow, newCopyTroSeq, sheetObj_copy) {  //newCopyTroSeq -> dtl-all-copy 
    	var formObj=document.form;
        var cmbObjTroseq=null;
    	if (NCflag == null) {
    		NCflag="N";  //N:New, C:Copy  
    	}
    	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);
    	if (strSheetId_gubun == "_b") {
    		cmbObjTroseq=t2_tro_seq;
    	} else {
    		cmbObjTroseq=tro_seq;
    	}	     	
    	//---------------------------------------
    	//1) add new row
    	var nNewRow=sheetObj.DataInsert(-1);
	    if (sheetObj.id == "t2bsheet2" || sheetObj.id == "t2bsheet2_b")       //master
	    {
	    	if (NCflag == "C") {	    		
				if (sheetObj.id == "t2bsheet2" && x_oldTroSeq != "") {
		    	    setFormToData_TroMst(x_oldTroSeq);          //2-1) tro-master : store 
				} else if (sheetObj.id == "t2bsheet2_b" && x_oldTroSeq_rtn != "") {
					setFormToData_TroMst_rtn(x_oldTroSeq_rtn);  //2-1) [rtn_cago]tro-master : store 
				}
	    	}
	    	//---------------------------------------
	        //2) default  setting : master 
	    	//setDefaultInsertRow(sheetObj, nNewRow);  
	    	setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow);
	    } 
		else if (sheetObj.id == "t2bsheet1" || sheetObj.id == "t2bsheet1_b")  //dtl
	    { 
	    	//---------------------------------------
	        //2) default  setting : dtl  	
	    	var curr_tro_seq=cmbObjTroseq.GetSelectText();
	    	//alert("nNewRow, curr_tro_seq->"+nNewRow+","+curr_tro_seq);	
	    	setDefaultInsertRow_Dtl(sheetObj, nNewRow, curr_tro_seq); 
	    	if (NCflag == "C") {
	    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow);
	    		if (sheetObj.id == "t2bsheet1") {
		    		//changing sum-qty   
		            var PM_gubun="P";  //P:Plus, M:Minus 
		            var p_Row=nNewRow;
		            var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
		            //var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty");
		            var p_currTroQty=BkgNullToString(sheetObj.GetCellValue(p_Row, "tro_qty"), "0");
		            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun, "Y");  //Y : copyGubun
	    		}
	    	}
	    }
		else if (sheetObj.id == "t2bsheet3" || sheetObj.id == "t2bsheet3_b")  //dtl all : copy 
		{ 
	    	if (NCflag == "C") {
	    		sheetObj.SetCellValue(nNewRow, "tro_seq",newCopyTroSeq,0);//New Copy, value of tro_seq
	    		sheetObj.SetCellValue(nNewRow, "tro_sub_seq",sheetObj_copy.GetCellValue(nCopyRow, "tro_sub_seq"),0);
	    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy);
	    		if (sheetObj.id == "t2bsheet3") {
		    		//changing sum-qty 
		            var PM_gubun="P";  //P:Plus, M:Minus 
		            var p_Row=nNewRow;
		            var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
		            //var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty");
		            var p_currTroQty=BkgNullToString(sheetObj.GetCellValue(p_Row, "tro_qty"), "0");
		            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun, "Y");  //Y : copyGubun
	    		}
	    	}
		}
    }
    /**     
     * [tro_master]AddRow, setting default
     */
    //function setDefaultInsertRow(sheetObj, nRow, NCflag) {
    function setDefaultInsertRow(sheetObj, nRow, NCflag, nCopyRow) {
    	var formObj=document.form;
    	var cmbObjTroseq=null;
    	var cmbObjTroseqmaxcnt=null;
    	var sheetObjDtl=null; 
    	var sheetObjDtl_all=null;    	
    	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);    	
    	if (strSheetId_gubun == "_b") {
    		sheetObjDtl=x_sheetObject6;
    		sheetObjDtl_all=x_sheetObject8;
    		cmbObjTroseq=t2_tro_seq;
    		cmbObjTroseqmaxcnt=formObj.t2_tro_seq_maxcnt;
    	} else {
    		sheetObjDtl=x_sheetObject1;
    		sheetObjDtl_all=x_sheetObject3;
    		cmbObjTroseq=tro_seq;
    		cmbObjTroseqmaxcnt=formObj.tro_seq_maxcnt;
    	}
    	var prevMaxTroSeq=""; 
    	var newTroSeq="";   	
		prevMaxTroSeq=getPrevMaxTroSeq(sheetObj, nRow, "tro_seq"); 
		//-------------------------------------------
		//2) tro-master : standard for New grid,  setting initial value
        sheetObj.SetCellValue(nRow, "tro_seq",parseInt(prevMaxTroSeq) + 1,0);//new tro_seq : max+1
        sheetObj.SetCellValue(nRow, "rcv_term_cd",formObj.term.value,0);
        //if (tabObjects[0].GetSelectedIndex() == 0)
    	if (strSheetId_gubun != "_b") 
        {
        	sheetObj.SetCellValue(nRow, "act_shpr_cnt_cd",formObj.cust_cnt_cd.value,0);
        	sheetObj.SetCellValue(nRow, "act_shpr_seq",formObj.cust_seq.value,0);
        	//sheetObj.CellValue2(nRow, "act_shpr_nm")     = formObj.cust_nm.value;  //except from default 
        }
        //Location : except from default 
        //sheetObj.CellValue2(nRow, "dor_loc_cd")      = formObj.por_cd.value;  
        //sheetObj.CellValue2(nRow, "zn_cd")           = formObj.por_nod_cd.value;
        //20100405 except from default
//        if (sheetObj.CellValue(nRow, "zn_cd").trim() == "") {
//        	sheetObj.CellValue2(nRow, "zn_cd")       = "01"; 
//        }
        sheetObj.SetCellValue(nRow, "cxl_flg","N",0);
        sheetObj.SetCellValue(nRow, "cfm_flg","N",0);
        sheetObj.SetCellValue(nRow, "cxl_flg_old","N",0);
        sheetObj.SetCellValue(nRow, "cfm_flg_old","N",0);
        sheetObj.SetCellValue(nRow, "so_flg","N",0);
	    //-------------------------------------------
    	//3) tro-master Form :  adding to list of tro_seq combo (tro_seq which is added newly)
        newTroSeq=sheetObj.GetCellValue(nRow, "tro_seq");
        cmbObjTroseq.InsertItem(-1, newTroSeq, newTroSeq);	
    	if (NCflag == "C") {
    		//CopyRow  		
            ComSetObjValue(cmbObjTroseqmaxcnt, sheetObj.RowCount());
    		setDataCopy(sheetObj, nRow, nCopyRow);  //nNewRow
    		var copyTroSeq=sheetObj.GetCellValue(nCopyRow, "tro_seq");
            if (strSheetId_gubun != "_b") {	    		
	    		copyTrodgseq(copyTroSeq, newTroSeq);  //dg_seq Copy 
            }
    		//Dtl All Copy : call
    		copyAllRow_dtl(sheetObjDtl_all, newTroSeq, sheetObjDtl, copyTroSeq);     		
    	} else {
    		//AddRow 
    		if (strSheetId_gubun == "_b") {
    			setDataToForm_TroMst_rtn(newTroSeq, "Y");   //4) changing output of tro-master Form(tro_seq which is added newly) : onchange call !!
    		} else {
    			setDataToForm_TroMst(newTroSeq, "Y");       //4) changing output of  tro-master Form(tro_seq which is added newly) : onchange call !!
    		} 
        	addRow(sheetObjDtl);                    //5) changing output of  tro-dtl Form (tro_seq which is added newly)
    	}
    }
     /**     
      * [tro_dtl] setting default of certain item , at row which is added
      */
    function setDefaultInsertRow_Dtl(sheetObj, nRow, tro_seq) { 
      	var formObj=document.form; 
    	var prevMaxTroSubSeq=""; 
    	prevMaxTroSubSeq=getPrevMaxTroSeq(sheetObj, nRow, "tro_sub_seq");     	
    	//alert("prevMaxTroSubSeq->"+prevMaxTroSubSeq); 
    	sheetObj.SetCellValue(nRow, "tro_seq",tro_seq,0);//current, value of tro_seq combo
	    sheetObj.SetCellValue(nRow, "tro_sub_seq",parseInt(prevMaxTroSubSeq) + 1,0);//new tro_sub_seq : max+1
        //sheetObj.CellValue2(nRow, "del")         = 'N';
	    sheetObj.SetCellValue(nRow, "cxl_flg",'N',0);
	    sheetObj.SetCellValue(nRow, "cxl_flg_old",'N',0);
	    sheetObj.SetCellValue(nRow, "dor_arr_dt",formObj.dor_arr_dt.value,0);//header information
	    sheetObj.SetCellValue(nRow, "dor_arr_dt_hhmi",formObj.dor_arr_dt_hhmi.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_dt",formObj.pkup_dt.value,0);//header information
	    sheetObj.SetCellValue(nRow, "pkup_dt_hhmi",formObj.pkup_dt_hhmi.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_loc_cd",formObj.pickup_cy1.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_yd_cd",formObj.pickup_cy2.value,0);
	    //if (tabObjects[0].GetSelectedIndex() == 1)
    	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);    	
    	if (strSheetId_gubun == "_b") 
	    {
    		sheetObj.SetCellValue(nRow, "tro_qty",1,0);//general : tro_qty=1 fixed->except, rtn:tro_qty=1 fixed->except
	    } else {
		    sheetObj.SetCellValue(nRow, "rtn_loc_cd",formObj.return_cy1.value,0);
		    sheetObj.SetCellValue(nRow, "rtn_yd_cd",formObj.return_cy2.value,0);
		    sheetObj.SetCellValue(nRow, "dor_arr_dt_hhmi","00:00",0);
		    sheetObj.SetCellValue(nRow, "pkup_dt_hhmi","00:00",0);
	    }
    }
    /** 
     *  initializing qtysum color  
     */   
    function changeTroQtyColor(sheetObj_qty) {
    	var formObj=document.form;  	
    	for(var i=1; i<=sheetObj_qty.RowCount(); i++) {
    		var cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
    		var n_totQty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
			//var n_currTroqty = parseInt(sheetObj_qty.CellValue(i, "tro_qty"));  
    		var n_currTroqty=parseInt(BkgNullToString(sheetObj_qty.GetCellValue(i, "tro_qty"), "0"));
			if (n_totQty < n_currTroqty) {
				sheetObj_qty.SetCellFontColor(i, "tro_qty","#FF0000");
			} else if (n_totQty == n_currTroqty) {
				sheetObj_qty.SetCellFontColor(i, "tro_qty","#000000");
			} else if (nullToBlank(sheetObj_qty.GetCellValue(i, "tro_qty")) != "") {
				sheetObj_qty.SetCellFontColor(i, "tro_qty","#0000FF");
				//callShowMessageBiggerQty(sheetObj_qty.CellValue(i, "cntr_tpsz_cd"));  
			} else if (n_totQty > n_currTroqty) {
				sheetObj_qty.SetCellFontColor(i, "tro_qty","#0000FF");
			}
    	}
    }      
    /**     
     * in case of changing [tro_dtl], changing sumqty output : All(P/M)
     * gubun -> (T:type, Q:qty)
     */
  	function changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, p_Row, gubun) {
  	  	var formObj=document.form;  	  	
  	  	var sheetObj_qty=x_sheetObject5;
  	    var sheetObj=null; 
  	    if (gubun == null) {
  	    	gubun="T";
  	    }
  	    if (tabObjects[0].GetSelectedIndex() == 1) {
  	    	sheetObj=x_sheetObject6; 
		} else {
			sheetObj=x_sheetObject1; 
		} 
  	  	sheetObj_qty.ReDraw=false;   	  	
  	  	//1) next qty (+) 
  	    var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
  	    if (nSRow > -1) 
        {
  			//var currTroqty = sheetObj_qty.CellValue(nSRow, "tro_qty");
  			//sheetObj_qty.CellValue2(nSRow, "tro_qty") = parseInt(currTroqty) + parseInt(nxtTroQty); 
  	    	var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
			//var n_currTroqty  = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty"));
  	    	var n_currTroqty=parseInt(BkgNullToString(sheetObj_qty.GetCellValue(nSRow, "tro_qty"), "0"));
			var n_t_chgTroqty=0;
			if (gubun == "Q") {
				n_t_chgTroqty=n_currTroqty + parseInt(nxtTroQty) - parseInt(preTroQty); 
			} else if (gubun == "T") {
				n_t_chgTroqty=n_currTroqty + parseInt(nxtTroQty); 
			}
			//*) adding check -------->
			if (n_totQty > n_t_chgTroqty) {
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#FF0000");
			} else if (n_totQty == n_t_chgTroqty) {
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#000000");
			} else {
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#0000FF");
				if (nxtVal_type != "" && nxtTroQty != "" && nxtTroQty != "0") {
					callShowMessageBiggerQty(sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
				}
				/* : keep going after showing message even though it exceeds amount
				sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preVal_type,0);//changing into original value
				sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preTroQty,0);//changing into original value
				sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
				sheetObj_qty.ReDraw=true; 
				return;
				*/
			}
			//<-------------------
			//1) handling next qty (+)
			sheetObj_qty.SetCellValue(nSRow, "tro_qty",n_t_chgTroqty,0);
			if (gubun == "T") 
			{
				//2) handling pre qty (-) 
			  	var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", preVal_type);
			  	if (nSRow > -1) 
			  	{
			  		var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
					//var n_currTroqty  = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty")); 
			  		var n_currTroqty=parseInt(BkgNullToString(sheetObj_qty.GetCellValue(nSRow, "tro_qty"), "0"));
					var n_t_chgTroqty=n_currTroqty - parseInt(preTroQty);
					sheetObj_qty.SetCellValue(nSRow, "tro_qty",n_t_chgTroqty,0);
			  		//changing color
				  	if (n_totQty > n_t_chgTroqty) {
				  		sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#FF0000");
					} else if (n_totQty == n_t_chgTroqty) {
						sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#000000");
				    } else {
				    	sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#0000FF");
				    }
			  	} 
			}
  		  	//3) currVal -> oldVal 
  			sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd_old",nxtVal_type,0);
  			sheetObj.SetCellValue(p_Row, "tro_qty_old",nxtTroQty,0);
        } else {
        	//  warning in booking QTY and other type 
			if (!ComShowConfirm(ComGetMsg("BKG08140"))){// CNTR TY/SZ is different from BKG volume. Do you go ahead?
					return false;
			}
        	//ComShowCodeMessage("BKG00297");  // registering TP/SZ is not valid 
  			//sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preVal_type;  //changing into original value
  			//sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
  		}
  		sheetObj_qty.ReDraw=true; 
  	}
    /**     
     * when [tro_dtl] is changing, changing output of sumqty  : Option(P/M)
     * copyGubun -> Y:copy, N:add
     */	
  	//function plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun) {
     function plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun, copyGubun) {
  	  	var formObj=document.form;
  	  	var sheetObj_qty=x_sheetObject5; 
  	    var sheetObj=null; 
  	    if (copyGubun == null) {
  	    	copyGubun="N";
  	    }
  	    if (tabObjects[0].GetSelectedIndex() == 1) {
  	    	sheetObj=x_sheetObject6; 
		} else {
			sheetObj=x_sheetObject1; 
		}   	  	
  	  	sheetObj_qty.ReDraw=false; 
  	  	if ("P" == PM_gubun) {
  			var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", p_currVal_type);
  		  	if (nSRow > -1) 
  		  	{
  		  		//var currTroqty = sheetObj_qty.CellValue(nSRow, "tro_qty");
  		  		//sheetObj_qty.CellValue2(nSRow, "tro_qty") = parseInt(currTroqty) + parseInt(p_currTroQty);  //Copy  		  		
  		  		var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
		    	//var n_currTroqty = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty")); 
  		  		var n_currTroqty=parseInt(BkgNullToString(sheetObj_qty.GetCellValue(nSRow, "tro_qty"), "0"));
				var n_t_chgTroqty=n_currTroqty + parseInt(p_currTroQty);  //Copy 
				//*) adding check -------->
				if (n_totQty > n_t_chgTroqty) {
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#FF0000");
				} else if (n_totQty == n_t_chgTroqty) {
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#000000");
				} else {
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#0000FF");
					if (copyGubun != "Y") {
						callShowMessageBiggerQty(sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd")); // in case of copying, handling check message
					}
					/* : keep going after showing message even though it exceeds amount  
					var preVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd_old");
					var preTroQty=sheetObj.GetCellValue(p_Row, "tro_qty_old");
					sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preVal_type,0);//changing into original value
					sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preTroQty,0);//changing into original value
					sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
					sheetObj_qty.ReDraw=true; 
					return; 
					*/
				}
				//<-------------------
		  		sheetObj_qty.SetCellValue(nSRow, "tro_qty",n_t_chgTroqty,0);
  		  	}
  	    } else if ("M" == PM_gubun) {
  		  	var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", p_currVal_type);
  		  	if (nSRow > -1) 
  		  	{
  		  		//var currTroqty = sheetObj_qty.CellValue(nSRow, "tro_qty");
  		  		var currTroqty=BkgNullToString(sheetObj_qty.GetCellValue(nSRow, "tro_qty"), "0");
  		  		sheetObj_qty.SetCellValue(nSRow, "tro_qty",parseInt(currTroqty) - parseInt(p_currTroQty),0);//Delete
  	      	} 
  	  	} 
  	  	sheetObj_qty.ReDraw=true; 
  	}    
 	/**
 	 * before Copy/CopySeq , checking exceeded amount of troqty : _in case of B, do not call
 	 */  
 	function checkCopySumTroqty(sheetObj) {
 	    var formObj=document.form;
 	    var sheetObj_qty=x_sheetObject5;
 	    var sheetObj_dtl=null;
  	    if (tabObjects[0].GetSelectedIndex() == 1) {
  	    	sheetObj_dtl=x_sheetObject6; 
		} else {
			sheetObj_dtl=x_sheetObject1; 
		}
 	    //if (sheetObj.id == "t2bsheet1" || sheetObj.id == "t2bsheet1_b")
 	   if (sheetObj.id == "t2bsheet1")  //[except Rtn check] 
 	    {
 			var nCopyCnt=formObj.tro_copy_cnt.value;	
 		    if (nCopyCnt == "") {
 		    	nCopyCnt=1;  //default : 1 
 		    }
 	    	var nCopyRow=sheetObj.GetSelectRow();
 	    	if (nCopyRow < 0) {
 	    		nCopyRow=0; 
 	    	}
 			//var n_t_troqty        = parseInt(sheetObj.CellValue(nCopyRow, "tro_qty"));  
 	    	var n_t_troqty=parseInt(BkgNullToString(sheetObj.GetCellValue(nCopyRow, "tro_qty"), "0"));
 			var n_t_sumqty=n_t_troqty * nCopyCnt; 
 			var cntr_tpsz_cd_copy=sheetObj.GetCellValue(nCopyRow, "cntr_tpsz_cd");
 			var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", cntr_tpsz_cd_copy);
  		  	if (nSRow > -1) {
  		  		var totqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
  		  	    //var currTroqty   = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty"));
  		  		var currTroqty=parseInt(BkgNullToString(sheetObj_qty.GetCellValue(nSRow, "tro_qty"), "0"));
  		  	    var changeTroqty=currTroqty + n_t_sumqty;
  		  	    if (totqty < changeTroqty) {
  		  	    	callShowMessageBiggerQty(sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
  		  	        //return false;  //if amount is exceeded, after showing the message, keep going the process
  		  	    }
  		  	}
 	    } 
 	    //else if (sheetObj.id == "t2bsheet2" || sheetObj.id == "t2bsheet2_b")
 	    else if (sheetObj.id == "t2bsheet2")  //[except Rtn check] 
 	    {	    
 	    	for (var i=1; i<=sheetObj_qty.RowCount(); i++) {
 	    		var i_cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
 	    		var n_t_sumqty=0;
 	    		for (var j=1; j<=sheetObj_dtl.RowCount(); j++) {
 	    			var j_cntr_tpsz_cd=sheetObj_dtl.GetCellValue(j, "cntr_tpsz_cd");
 	    			if (j_cntr_tpsz_cd == i_cntr_tpsz_cd) {
 	    	    		//var n_t_troqty = parseInt(sheetObj_dtl.CellValue(j, "tro_qty"));
 	    				var n_t_troqty=parseInt(BkgNullToString(sheetObj_dtl.GetCellValue(j, "tro_qty"), "0"));
 	    				n_t_sumqty += n_t_troqty;  
 	    			}
 	    		}
 	    		var totqty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
  		  	    //var currTroqty   = parseInt(sheetObj_qty.CellValue(i, "tro_qty"));
 	    		var currTroqty=parseInt(BkgNullToString(sheetObj_qty.GetCellValue(i, "tro_qty"), "0"));
  		  	    var changeTroqty=currTroqty + n_t_sumqty;  		  	    
  		  	    if (totqty < changeTroqty) {
  		  	    	callShowMessageBiggerQty(sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd"));
  		  	        //return false;  //if amount is exceeded, after showing the message, keep going the process 
  		  	    }  		  	    
 	    	}
 	    }
 	    return true;
 	}  
 	//######################[3. Data Display/Store (Master/Detail)]###############################
    /** 
    * Tro-Mastr  (Sheet -> Form : Display)
    */
    function setDataToForm_TroMst(troSeq, troseq_Onchg_flg) {
       var comboTroSeq = tro_seq;
       var formObj=document.form;
       var sheetObj=x_sheetObject2;
       if (troseq_Onchg_flg == null) {
    	   troseq_Onchg_flg="N";  //Y: tro_seq Onchange event  call, N: don't execute
       }
       //-----------------------------------
       //1)   initializing the row (tro_seq Value)
       var nRow=sheetObj.FindText("tro_seq", troSeq);
       //-----------------------------------
       //2) output 
       with(formObj) {
    	   if (troseq_Onchg_flg == "Y") {
    		   ComSetObjValue(comboTroSeq, sheetObj.GetCellValue(nRow, "tro_seq"));  //Onchange automatically call.
    	   } else {
    		   comboTroSeq.SetSelectText(sheetObj.GetCellValue(nRow, "tro_seq"),false);//Onchange  do not call !
    	   }
           if (x_oldTroSeq == "") {
               x_oldTroSeq=comboTroSeq.GetSelectText();
           } 
    	   ComSetObjValue(tro_seq_maxcnt,   sheetObj.RowCount());
    	   ComSetObjValue(rcv_term_cd,      nullToBlank(sheetObj.GetCellValue(nRow, "rcv_term_cd")));
    	   ComSetObjValue(rqst_dt,          nullToBlank(sheetObj.GetCellValue(nRow, "rqst_dt")));
    	   ComSetObjValue(act_shpr_cnt_cd,  nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_cnt_cd")));
    	   ComSetObjValue(act_shpr_seq,     nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_seq")));
    	   ComSetObjValue(act_shpr_nm,      nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_nm")));
    	   ComSetObjValue(dor_loc_cd,       nullToBlank(sheetObj.GetCellValue(nRow, "dor_loc_cd")));
    	   ComSetObjValue(zn_cd,            nullToBlank(sheetObj.GetCellValue(nRow, "zn_cd")));
    	   ComSetObjValue(dor_pst_no,       nullToBlank(sheetObj.GetCellValue(nRow, "dor_pst_no")));
    	   //ComSetObjValue(cfm_flg,          nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")));
    	   cfm_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "cfm_flg")) == "Y") ? true : false;
    	   ComSetObjValue(cfm_flg_old,      nullToBlank(sheetObj.GetCellValue(nRow, "cfm_flg_old")));
    	   ComSetObjValue(cfm_dt,           nullToBlank(sheetObj.GetCellValue(nRow, "cfm_dt")));
    	   ComSetObjValue(act_shpr_addr,    nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_addr")));
    	   ComSetObjValue(cntc_pson_nm,     nullToBlank(sheetObj.GetCellValue(nRow, "cntc_pson_nm")));
    	   ComSetObjValue(diff_rmk,         nullToBlank(sheetObj.GetCellValue(nRow, "diff_rmk")));
    	   ComSetObjValue(cntc_phn_no,      nullToBlank(sheetObj.GetCellValue(nRow, "cntc_phn_no")));
    	   ComSetObjValue(cntc_fax_no,      nullToBlank(sheetObj.GetCellValue(nRow, "cntc_fax_no")));
    	   //rc_seq.Text2 = sheetObj.CellValue(nRow, "rc_seq"); 
    	   //ComSetObjValue(awk_cgo_seq,      nullToBlank(sheetObj.CellValue(nRow, "awk_cgo_seq")));
    	   //hidden  
    	   cxl_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "cxl_flg")) == "Y") ? true : false;
    	   ComSetObjValue(cxl_flg_old,      nullToBlank(sheetObj.GetCellValue(nRow, "cxl_flg_old")));
           //<B>            
    	   ComSetObjValue(so_flg,       nullToBlank(sheetObj.GetCellValue(nRow, "so_flg")));
    	   ownr_trk_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "ownr_trk_flg")) == "Y") ? true : false;
    	   ComSetObjValue(biz_rgst_no,  nullToBlank(sheetObj.GetCellValue(nRow, "biz_rgst_no")));
    	   ComSetObjValue(cntc_mphn_no, nullToBlank(sheetObj.GetCellValue(nRow, "cntc_mphn_no")));
    	   ComSetObjValue(ack_sts_cd, nullToBlank(sheetObj.GetCellValue(nRow, "ack_sts_cd")));
           //-----------------------------------
           //2-1) dg_seq 
    	   setDataToForm_Tro_dg_seq(sheetObj.GetCellValue(nRow, "tro_seq"));
           //-----------------------------------
           //3) changing background color if item of combo is existed
           //setChangeAllComboBackColor(); 
       }       
   }       
   /** 
    * [rtn_cago]Tro-Mastr  (Sheet -> Form : Display)
    */
   function setDataToForm_TroMst_rtn(troSeq, troseq_Onchg_flg) {
	   var comboTroSeq = t2_tro_seq;
       var formObj=document.form;
       var sheetObj=x_sheetObject7;       
       if (troseq_Onchg_flg == null) {
    	   troseq_Onchg_flg="N";  //Y: tro_seq Onchange event call, N: do not call event   
       }
       //-----------------------------------
       //1) initializing the row (tro_seq Value)
       var nRow=sheetObj.FindText("tro_seq", troSeq);
       
//       if(nRow == -1) return;
       //-----------------------------------
       //2) output
       with(formObj) {
    	   if (troseq_Onchg_flg == "Y") {  		   
    		   ComSetObjValue(comboTroSeq,   sheetObj.GetCellValue(nRow, "tro_seq"));  //Onchange automatically call.
    	   } else {
    		   comboTroSeq.SetSelectText(sheetObj.GetCellValue(nRow, "tro_seq"),false);//Onchange do not call automatically.
    		   //comboObjects[4].SetSelectText(sheetObj.GetCellValue(nRow, "tro_seq"),false);//Onchange do not call automatically.
    	   }
           if (x_oldTroSeq_rtn == "") {
               x_oldTroSeq_rtn=comboTroSeq.GetSelectText();
               //x_oldTroSeq_rtn=comboObjects[4].GetSelectText();
           } 
    	   ComSetObjValue(t2_tro_seq_maxcnt,   sheetObj.RowCount());
    	   ComSetObjValue(t2_rcv_term_cd,      nullToBlank(sheetObj.GetCellValue(nRow, "rcv_term_cd")));
    	   ComSetObjValue(t2_rqst_dt,          nullToBlank(sheetObj.GetCellValue(nRow, "rqst_dt")));
    	   ComSetObjValue(t2_act_shpr_cnt_cd,  nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_cnt_cd")));
    	   ComSetObjValue(t2_act_shpr_seq,     nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_seq")));
    	   ComSetObjValue(t2_act_shpr_nm,      nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_nm")));
    	   ComSetObjValue(t2_dor_loc_cd,       nullToBlank(sheetObj.GetCellValue(nRow, "dor_loc_cd")));
    	   ComSetObjValue(t2_zn_cd,            nullToBlank(sheetObj.GetCellValue(nRow, "zn_cd")));
    	   ComSetObjValue(t2_dor_pst_no,       nullToBlank(sheetObj.GetCellValue(nRow, "dor_pst_no")));
    	   //ComSetObjValue(cfm_flg,          nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")));
    	   //t2_cfm_flg.checked = (nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")) == "Y") ? true : false; 
    	   //ComSetObjValue(cfm_flg_old,         nullToBlank(sheetObj.CellValue(nRow, "cfm_flg_old")));
    	   //ComSetObjValue(t2_cfm_dt,           nullToBlank(sheetObj.CellValue(nRow, "cfm_dt")));
    	   ComSetObjValue(t2_act_shpr_addr,    nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_addr")));
    	   ComSetObjValue(t2_cntc_pson_nm,     nullToBlank(sheetObj.GetCellValue(nRow, "cntc_pson_nm")));
    	   ComSetObjValue(t2_diff_rmk,         nullToBlank(sheetObj.GetCellValue(nRow, "diff_rmk")));
    	   ComSetObjValue(t2_cntc_phn_no,      nullToBlank(sheetObj.GetCellValue(nRow, "cntc_phn_no")));
    	   ComSetObjValue(t2_cntc_fax_no,      nullToBlank(sheetObj.GetCellValue(nRow, "cntc_fax_no")));
    	   //hidden  
    	   t2_cxl_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "cxl_flg")) == "Y") ? true : false;
    	   ComSetObjValue(t2_cxl_flg_old,      nullToBlank(sheetObj.GetCellValue(nRow, "cxl_flg_old")));
           //<B>            
    	   ComSetObjValue(t2_so_flg,       nullToBlank(sheetObj.GetCellValue(nRow, "so_flg")));
    	   t2_ownr_trk_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "ownr_trk_flg")) == "Y") ? true : false;
    	   ComSetObjValue(t2_biz_rgst_no,  nullToBlank(sheetObj.GetCellValue(nRow, "biz_rgst_no")));
    	   ComSetObjValue(t2_cntc_mphn_no, nullToBlank(sheetObj.GetCellValue(nRow, "cntc_mphn_no")));
    	   ComSetObjValue(t2_ack_sts_cd,   nullToBlank(sheetObj.GetCellValue(nRow, "ack_sts_cd")));
       }       
   }       
    /** 
     * saving Tro-Master Temp  (Form ->Sheet  : Store)
     */
    function setFormToData_TroMst(prev_tro_seq) {    	 
     	var formObj=document.form; 
        var sheetObj=x_sheetObject2; 
        //-----------------------------------
        // 1)  row (tro_seq Value): delete 
        var nRow=sheetObj.FindText("tro_seq", prev_tro_seq);
        //-----------------------------------
        // 2) Store(Update) 
        with(formObj) {
         	sheetObj.SetCellValue(nRow, "tro_seq",prev_tro_seq,0);
         	sheetObj.SetCellValue(nRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd),0);
         	sheetObj.SetCellValue(nRow, "rqst_dt",ComGetObjValue(rqst_dt),0);
         	sheetObj.SetCellValue(nRow, "act_shpr_cnt_cd",ComGetObjValue(act_shpr_cnt_cd),0);
         	sheetObj.SetCellValue(nRow, "act_shpr_seq",ComGetObjValue(act_shpr_seq),0);
         	sheetObj.SetCellValue(nRow, "act_shpr_nm",ComGetObjValue(act_shpr_nm),0);
         	sheetObj.SetCellValue(nRow, "dor_loc_cd",ComGetObjValue(dor_loc_cd),0);
         	sheetObj.SetCellValue(nRow, "zn_cd",ComGetObjValue(zn_cd),0);
         	sheetObj.SetCellValue(nRow, "dor_pst_no",ComGetObjValue(dor_pst_no),0);
         	//sheetObj.CellValue2(nRow, "cfm_flg")          = (ComGetObjValue(cfm_flg)=="on") ? "Y" : "";  //"N" ???
         	sheetObj.SetCellValue(nRow, "cfm_flg",(cfm_flg.checked==1) ? "Y" : "N",0);//"" ???
         	//cfm_flg_old : do not change. 
         	sheetObj.SetCellValue(nRow, "cfm_dt",ComGetObjValue(cfm_dt),0);
         	sheetObj.SetCellValue(nRow, "act_shpr_addr",ComGetObjValue(act_shpr_addr),0);
         	sheetObj.SetCellValue(nRow, "cntc_pson_nm",ComGetObjValue(cntc_pson_nm),0);
         	sheetObj.SetCellValue(nRow, "diff_rmk",ComGetObjValue(diff_rmk),0);
         	sheetObj.SetCellValue(nRow, "cntc_phn_no",ComGetObjValue(cntc_phn_no),0);
         	sheetObj.SetCellValue(nRow, "cntc_fax_no",ComGetObjValue(cntc_fax_no),0);
         	//sheetObj.CellValue2(nRow, "rc_seq")           = rc_seq.Text; 
         	//sheetObj.CellValue2(nRow, "awk_cgo_seq")      = ComGetObjValue(awk_cgo_seq);    
         	//hidden  
            sheetObj.SetCellValue(nRow, "cxl_flg",(cxl_flg.checked==1) ? "Y" : "N",0);
            //cxl_flg_old : do not change. 
            //<B>            
            sheetObj.SetCellValue(nRow, "so_flg",ComGetObjValue(so_flg),0);
            sheetObj.SetCellValue(nRow, "ownr_trk_flg",(ownr_trk_flg.checked==1) ? "Y" : "N",0);
            sheetObj.SetCellValue(nRow, "biz_rgst_no",ComGetObjValue(biz_rgst_no),0);
            sheetObj.SetCellValue(nRow, "cntc_mphn_no",ComGetObjValue(cntc_mphn_no),0);
            sheetObj.SetCellValue(nRow, "ack_sts_cd",ComGetObjValue(ack_sts_cd),0);
            //-----------------------------------
            // 2-1) dg_seq Store
         	//sheetObj.CellValue2(nRow, "dcgo_seq")         = dcgo_seq.Text; 
            setFormToData_Tro_dg_seq(prev_tro_seq); 
        }  
    } 
     /** 
      * [rtn_cago]saving Tro-Master Temp  (Form ->Sheet  : Store)
      */
     function setFormToData_TroMst_rtn(prev_tro_seq) {
      	 var formObj=document.form; 
         var sheetObj=x_sheetObject7; 
         //-----------------------------------
         // 1) row (tro_seq Value): delete 
         var nRow=sheetObj.FindText("tro_seq", prev_tro_seq);
         //-----------------------------------
         // 2) Store(Update) 
         with(formObj) {
         	 sheetObj.SetCellValue(nRow, "tro_seq",prev_tro_seq,0);
         	 sheetObj.SetCellValue(nRow, "rcv_term_cd",ComGetObjValue(t2_rcv_term_cd),0);
         	 sheetObj.SetCellValue(nRow, "rqst_dt",ComGetObjValue(t2_rqst_dt),0);
         	 sheetObj.SetCellValue(nRow, "act_shpr_cnt_cd",ComGetObjValue(t2_act_shpr_cnt_cd),0);
         	 sheetObj.SetCellValue(nRow, "act_shpr_seq",ComGetObjValue(t2_act_shpr_seq),0);
         	 sheetObj.SetCellValue(nRow, "act_shpr_nm",ComGetObjValue(t2_act_shpr_nm),0);
         	 sheetObj.SetCellValue(nRow, "dor_loc_cd",ComGetObjValue(t2_dor_loc_cd),0);
         	 sheetObj.SetCellValue(nRow, "zn_cd",ComGetObjValue(t2_zn_cd),0);
         	 sheetObj.SetCellValue(nRow, "dor_pst_no",ComGetObjValue(t2_dor_pst_no),0);
         	 sheetObj.SetCellValue(nRow, "act_shpr_addr",ComGetObjValue(t2_act_shpr_addr),0);
         	 sheetObj.SetCellValue(nRow, "cntc_pson_nm",ComGetObjValue(t2_cntc_pson_nm),0);
         	 sheetObj.SetCellValue(nRow, "diff_rmk",ComGetObjValue(t2_diff_rmk),0);
         	 sheetObj.SetCellValue(nRow, "cntc_phn_no",ComGetObjValue(t2_cntc_phn_no),0);
         	 sheetObj.SetCellValue(nRow, "cntc_fax_no",ComGetObjValue(t2_cntc_fax_no),0);
         	 //hidden  
             sheetObj.SetCellValue(nRow, "cxl_flg",(t2_cxl_flg.checked==1) ? "Y" : "N",0);
             //<B>            
             sheetObj.SetCellValue(nRow, "so_flg",ComGetObjValue(t2_so_flg),0);
             sheetObj.SetCellValue(nRow, "ownr_trk_flg",(t2_ownr_trk_flg.checked==1) ? "Y" : "N",0);
             sheetObj.SetCellValue(nRow, "biz_rgst_no",ComGetObjValue(t2_biz_rgst_no),0);
             sheetObj.SetCellValue(nRow, "cntc_mphn_no",ComGetObjValue(t2_cntc_mphn_no),0);
             sheetObj.SetCellValue(nRow, "ack_sts_cd",ComGetObjValue(t2_ack_sts_cd),0);
         }  
     } 
    /** 
    * Tro-Detail  ( HiddenSheet -> Sheet : Display ) 
    */
   function setAllDataToData_TroDtl(tro_seq, rtn_tro_flg) {
       var formObj=document.form;
       var sheetObj=null;
       var sheetObjDtl=null;
       var sheetObjDtl_All=null;
       rtn_tro_flg=nullToBlank(rtn_tro_flg);       
       if (rtn_tro_flg == "Y") {
           sheetObj=x_sheetObject7;
           sheetObjDtl=x_sheetObject6; 
           sheetObjDtl_All=x_sheetObject8; 
       } else {
           sheetObj=x_sheetObject2;
           sheetObjDtl=x_sheetObject1; 
           sheetObjDtl_All=x_sheetObject3;            
       }
       //--------------------------------
       //1) initializing 
       sheetObjDtl_All.CheckAll("chk",0,1);//dtl_all check initializing
       sheetObjDtl.RemoveAll();              //dtl grid initializing
       //--------------------------------
       //2) dtl check (tro_seq)       
       for (var i=1; i<=sheetObjDtl_All.RowCount(); i++) {
    	   var tempTro_seq=sheetObjDtl_All.GetCellValue(i, "tro_seq");
    	   if (tro_seq == tempTro_seq) {
    		   sheetObjDtl_All.SetCellValue(i, "chk","1",0);
    	   }
       }
       //-------------------------------- 
       //3) ComMakeSearchXml       
       var strSaveNames="ibflag|tro_seq|tro_sub_seq|cntr_tpsz_cd|tro_qty|dor_arr_dt|dor_arr_dt_hhmi|pkup_dt|pkup_dt_hhmi|pkup_loc_cd|pkup_yd_cd|rtn_loc_cd|rtn_yd_cd|cmdt_cd|cntr_no|cxl_flg|cxl_flg_old|cntr_tpsz_cd_old|tro_qty_old";
       var sXml=ComMakeSearchXml(sheetObjDtl_All, false, "chk", strSaveNames, true);  //all column : move 
       //--------------------------------
       //4) LoadSearchXml (for output  dtl grid) 
       sheetObjDtl.LoadSearchData(sXml,{Append:1 , Sync:1} );
       //--------------------------------
       //5) dtl : cxl/cfm:  color /editable 
       setRowDelColorChange(sheetObjDtl, "del_chk");
   }       
   /** 
    * saving Tro-Detail Temp    ( Sheet -> HidenSheet : Store )
    */
   function setDataToAllData_TroDtl(prev_tro_seq, del_flag, rtn_tro_flg) {    	
       var formObj=document.form;
       var sheetObjDtl=null;
       var sheetObjDtl_All=null;      
       var currTroSeq=null;
       rtn_tro_flg=nullToBlank(rtn_tro_flg);       
       if (rtn_tro_flg == "Y") {
           sheetObjDtl=x_sheetObject6; 
           sheetObjDtl_All=x_sheetObject8; 
           //currTroSeq      = formObj.t2_tro_seq.Text;
       } else {
           sheetObjDtl=x_sheetObject1; 
           sheetObjDtl_All=x_sheetObject3; 
           //currTroSeq      = tro_seq.Text;
       }    	
       if (del_flag == null) {
    	   del_flag=true; //default : true(deleting)
       }
       //--------------------------------
       //1) dtl check (tro_seq) 
       sheetObjDtl.CheckAll("chk",1,1);//hidden chk : dtl_all check initializing
       //--------------------------------
       //2) dtl-all delete (tro_seq)
       if (rtn_tro_flg == "Y") {
           deleteRowDtlAll(prev_tro_seq, "Y");  //rtn
       } else {
    	   deleteRowDtlAll(prev_tro_seq);
       }
       //-------------------------------- 
       //3) ComMakeSearchXml / LoadSearchXml (for output  dtl grid) 
       var strSaveNames="ibflag|tro_seq|tro_sub_seq|cntr_tpsz_cd|tro_qty|dor_arr_dt|dor_arr_dt_hhmi|pkup_dt|pkup_dt_hhmi|pkup_loc_cd|pkup_yd_cd|rtn_loc_cd|rtn_yd_cd|cmdt_cd|cntr_no|cxl_flg|cxl_flg_old|cntr_tpsz_cd_old|tro_qty_old";
       var sXml=ComMakeSearchXml(sheetObjDtl, false, "chk", strSaveNames, del_flag);  //all column : move/copy (true:deleting)
       sheetObjDtl_All.LoadSearchData(sXml,{Append:1 , Sync:1} );
   }
   //function deleteRowDtlAll(prev_tro_seq) {
   function deleteRowDtlAll(prev_tro_seq, rtn_tro_flg) {
       var sheetObj=null;    
       rtn_tro_flg=nullToBlank(rtn_tro_flg);       
       if (rtn_tro_flg == "Y") {
    	   sheetObj=x_sheetObject8;  //sheetObjDtl_All
       } else {
    	   sheetObj=x_sheetObject3;  //sheetObjDtl_All
       }	   
       //--------------------------------
       //2) dtl check (tro_seq) 
	   sheetObj.CheckAll("del_chk",0,1);//hidden chk : check clear
       //1) prev_tro_seq  flag setting  
       var nRow=0;  //findRow 
       var nStartRow=0;  //find Start Index 
       while (nRow > -1) {
    	   nRow=sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow);
    	   if (nRow > -1) {    		   
    		   sheetObj.SetCellValue(nRow, "del_chk","Y",0);
    		   nStartRow=nRow+1;
    	   }
       } 
       //2) sheetObj.RowDelete(); 
       var sRow=sheetObj.FindCheckedRow("del_chk");
//       // ACTIVE 버젼처럼 추가해준다.
       if(sRow.length >0 ) {
    	   sRow = sRow +"|";
       }
       var arrRow=sRow.split("|");
       for (var idx=arrRow.length-2; idx>=0; idx--)
       { 
    	   sheetObj.RowDelete(arrRow[idx], false);
       }
   }   
    //######################[4. Data Display/Store (Etc : Header/Combo)]##########################
    /**
    * Header (Booking information) 
    * : EtcData
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData -> Form 
        //IBS_EtcDataToForm(formObj, sheetObj);
        with (formObj) 
        {
	        por_nod_cd.value=nullToBlank(sheetObj.GetEtcData("por_nod_cd"));
	        skd_dir_cd.value=nullToBlank(sheetObj.GetEtcData("skd_dir_cd"));
	        cust_seq.value=nullToBlank(sheetObj.GetEtcData("cust_seq"));
	        fd_grd_flg.value=nullToBlank(sheetObj.GetEtcData("fd_grd_flg"));
	        spcl_hide_flg.value=nullToBlank(sheetObj.GetEtcData("spcl_hide_flg"));
	        pol_code.value=nullToBlank(sheetObj.GetEtcData("pol_code"));
	        bkg_sts_cd.value=nullToBlank(sheetObj.GetEtcData("bkg_sts_cd"));
	        cmdt_nm.value=nullToBlank(sheetObj.GetEtcData("cmdt_nm"));
	        //bl_tp_cd.value        = nullToBlank(sheetObj.EtcData("bl_tp_cd")); 
	        bkg_no.value=nullToBlank(sheetObj.GetEtcData("bkg_no"));
	        bl_no.value=nullToBlank(sheetObj.GetEtcData("bl_no"));
	        cust_cnt_cd.value=nullToBlank(sheetObj.GetEtcData("cust_cnt_cd"));
	        cust_nm.value=nullToBlank(sheetObj.GetEtcData("cust_nm"));
	        cmdt_cd.value=nullToBlank(sheetObj.GetEtcData("cmdt_cd"));
	        conti_cd.value=nullToBlank(sheetObj.GetEtcData("conti_cd"));
	        del_cd.value=nullToBlank(sheetObj.GetEtcData("del_cd"));
	        term.value=nullToBlank(sheetObj.GetEtcData("term"));
	        por_cd.value=nullToBlank(sheetObj.GetEtcData("por_cd"));
	        pod_cd.value=nullToBlank(sheetObj.GetEtcData("pod_cd"));
	        skd_voy_no.value=nullToBlank(sheetObj.GetEtcData("skd_voy_no"));
	        etb_dt.value=nullToBlank(sheetObj.GetEtcData("etb_dt"));
	        vsl_cd.value=nullToBlank(sheetObj.GetEtcData("vsl_cd"));
	        dor_arr_dt.value=nullToBlank(sheetObj.GetEtcData("dor_arr_dt"));
	        dor_arr_dt_hhmi.value=nullToBlank(sheetObj.GetEtcData("dor_arr_dt_hhmi"));
	        pkup_dt.value=nullToBlank(sheetObj.GetEtcData("pkup_dt"));
	        pkup_dt_hhmi.value=nullToBlank(sheetObj.GetEtcData("pkup_dt_hhmi"));
		    //bkg_rep_cmdt_cd.value = nullToBlank(sheetObj.EtcData("bkg_rep_cmdt_cd")); 	
	        //bkg_rep_cmdt_nm.value = nullToBlank(sheetObj.EtcData("bkg_rep_cmdt_nm"));
	        //act_wgt.value         = nullToBlank(sheetObj.EtcData("act_wgt")); 
	        //wgt_ut_cd.value       = nullToBlank(sheetObj.EtcData("wgt_ut_cd"));
	        //bkg_cgo_tp_cd.value   = nullToBlank(sheetObj.EtcData("bkg_cgo_tp_cd")); 
        }
        var returnCy=nullToBlank(sheetObj.GetEtcData("return_cy"));
	    if (returnCy.length >= 7) {
	    	formObj.return_cy1.value=returnCy.substr(0, 5);
	    	formObj.return_cy2.value=returnCy.substr(5, 2);	    	
	    } else {
	    	formObj.return_cy1.value=returnCy;
	    	formObj.return_cy2.value="";
	    }
	    var pickupCy=nullToBlank(sheetObj.GetEtcData("pickup_cy"));
	    if (pickupCy.length >= 7) {
	    	formObj.pickup_cy1.value=pickupCy.substr(0, 5);
	    	formObj.pickup_cy2.value=pickupCy.substr(5, 2);
	    } else {
	    	formObj.pickup_cy1.value=pickupCy;
	    	formObj.pickup_cy2.value="";
	    }
       //------------------------------
       //setting the retrieved booking code in hidden 
       formObj.oldBkgNo.value=nullToBlank(sheetObj.GetEtcData("bkg_no"));
       formObj.oldBlNo.value=nullToBlank(sheetObj.GetEtcData("bl_no"));
       formObj.ca_flg.value=nullToBlank(sheetObj.GetEtcData("ca_flg"));
       //------------------------------------------------
       // Receiving Term : other case of 'D',   showing warning message
/* : <B> don't check
       if ("D" != formObj.term.value) {
    	   ComShowCodeMessage("BKG02021");  //"Receiving Term is not 'D' !"
       }
*/        
       if ("US" == formObj.por_cd.value.substr(0,2)) {
    	   document.getElementById("dor_pst_no").className="input1";  //Zip mandatory inputting value
       } else {
    	   document.getElementById("dor_pst_no").className="input";  
       }
	   //checkbox --------------------------> 
	   var dcgo_flg=nullToBlank(sheetObj.GetEtcData("dcgo_flg"));
	   var rc_flg=nullToBlank(sheetObj.GetEtcData("rc_flg"));
	   var awk_cgo_flg=nullToBlank(sheetObj.GetEtcData("awk_cgo_flg"));
	   var bb_cgo_flg=nullToBlank(sheetObj.GetEtcData("bb_cgo_flg"));
	   var rd_cgo_flg=nullToBlank(sheetObj.GetEtcData("rd_cgo_flg"));
	   formObj.dcgo_flg.checked=(dcgo_flg    == "Y") ? true : false;
	   formObj.rc_flag.checked=(rc_flg      == "Y") ? true : false;
	   formObj.awk_cgo_flg.checked=(awk_cgo_flg == "Y") ? true : false;
	   formObj.bb_cgo_flg.checked=(bb_cgo_flg  == "Y") ? true : false;
	   formObj.rd_cgo_flg.checked=(rd_cgo_flg  == "Y") ? true : false;
	   //<---------------------------checkbox  
       //alert("flag-->"+dcgo_flg+","+rc_flg+","+awk_cgo_flg+","+bb_cgo_flg+","+rd_cgo_flg); 
	   //handling button link/ button -------------------------->
	   changeDisplayBtn("btn_Danger",  dcgo_flg);
	   changeDisplayBtn("btn_Reefer",  rc_flg);
	   changeDisplayBtn("btn_Awkward", awk_cgo_flg);
	   changeDisplayBtn("btn_Bulk",    bb_cgo_flg);
	   //<----------------------------------------------
	    //after finishing to search, button enabled	   
		if (formObj.oldBkgNo.value != "") {
			//ComEnableManyTd(true,  "btn_t2bRetrieve", "btn_t2bIFInquiry");		
	   		ComEnableManyTd(true, "btn_t2bSave", "btn_t2bRequest", "btn_t2bCancelAll", "btn_t2bTROCopy", 
                                  "btn_t2bAddSeq", "btn_t2bCopySeq", "btn_t2bCancelSeq", 
                                  "btn_t2bAdd", "btn_t2bDelete", "btn_t2bCopy", 
                                  "t2_btn_t2bAdd", "t2_btn_t2bDelete", "t2_btn_t2bCopy");
		}	   
    }
    /** 
    * Tro-Mastr dg_seq  : (multicombo) 
    */
    function setDataToForm_Tro_dg_seq(tro_seq, comboId, comboObj) {
        var formObj=document.form;
        var sheetObj=x_sheetObject4; 
        var comboObj_1=dcgo_seq; 
        var comboObj_2=rc_seq; 
        var comboObj_3=awk_cgo_seq; 
        var comboId="spcl_cgo_seq";
//        var nRow=0;  //findRow 
//        var nStartRow=0;
        var strCode_1=""; //code initializing
        var strCode_2=""; //code initializing 
        var strCode_3=""; //code initializing 
//        while (nRow > -1) {
//	   	    nRow=sheetObj.FindText("tro_seq", tro_seq, nStartRow);
//	   	    if (nRow > -1) {
//	   	    	var spcl_cgo_cd=sheetObj.GetCellValue(nRow, "spcl_cgo_cd");
//	   	    	switch(spcl_cgo_cd) {
//	   	    	    case "DG":
//	   	    		    if (strCode_1 == "") {
//	   	    		    	strCode_1 += sheetObj.GetCellValue(nRow, comboId);
//	   	    		    } else {
//	   	    		    	strCode_1 += "|"+sheetObj.GetCellValue(nRow, comboId);
//	   	    		    }
//	   	    	    	break;
//	   	    	    case "RF":
//	   	    		    if (strCode_2 == "") {
//	   	    		    	strCode_2 += sheetObj.GetCellValue(nRow, comboId);
//	   	    		    } else {
//	   	    		    	strCode_2 += "|"+sheetObj.GetCellValue(nRow, comboId);
//	   	    		    }
//	   	    	    	break;
//	   	    	    case "AK":
//	   	    		    if (strCode_3 == "") {
//	   	    		    	strCode_3 += sheetObj.GetCellValue(nRow, comboId);
//	   	    		    } else {
//	   	    		    	strCode_3 += "|"+sheetObj.GetCellValue(nRow, comboId);
//	   	    		    }
//	   	    	    	break;
//	   	    	}
//	               nStartRow=nRow+1;
//	   	    }
//        } 

        for(i=1;i<sheetObj.RowCount() + 1; i++){
        	if(sheetObj.GetCellValue(i, "tro_seq")== tro_seq){
	   	    	var spcl_cgo_cd=sheetObj.GetCellValue(i, "spcl_cgo_cd");
	   	    	switch(spcl_cgo_cd) {
	   	    	    case "DG":
	   	    		    if (strCode_1 == "") {
	   	    		    	strCode_1 += sheetObj.GetCellValue(i, comboId);
	   	    		    } else {
	   	    		    	strCode_1 += "|"+sheetObj.GetCellValue(i, comboId);
	   	    		    }
	   	    	    	break;
	   	    	    case "RF":
	   	    		    if (strCode_2 == "") {
	   	    		    	strCode_2 += sheetObj.GetCellValue(i, comboId);
	   	    		    } else {
	   	    		    	strCode_2 += "|"+sheetObj.GetCellValue(i, comboId);
	   	    		    }
	   	    	    	break;
	   	    	    case "AK":
	   	    		    if (strCode_3 == "") {
	   	    		    	strCode_3 += sheetObj.GetCellValue(i, comboId);
	   	    		    } else {
	   	    		    	strCode_3 += "|"+sheetObj.GetCellValue(i, comboId);
	   	    		    }
	   	    	    	break;
	   	    	}
        	}
        }
        
        // showing the spcl_cgo_seq of tro_seq at each screen
        comboObj_1.SetSelectText("",false);
        comboObj_2.SetSelectText("",false);
        comboObj_3.SetSelectText("",false);
        comboObj_1.SetSelectText(strCode_1,false);
        comboObj_2.SetSelectText(strCode_2,false);
        comboObj_3.SetSelectText(strCode_3,false);
    }
    /** 
     * Tro-Mastr spcl_cgo_seq Store_pre : (multicombo) 
     */
    function setFormToData_Tro_dg_seq(prev_tro_seq) {
        var formObj=document.form;
        var sheetObj=x_sheetObject4; 
        var comboObj_1=dcgo_seq; 
        var comboObj_2=rc_seq; 
        var comboObj_3=awk_cgo_seq; 
        //1) prev_tro_seq  -> setting delete flag   
//        var nRow=0;  //findRow 
//        var nStartRow=0;  //find Start Index 
//        while (nRow > -1) 
//	    {
//	   	    nRow=sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow);
//	   	    if (nRow > -1) 
//			    {    		   
//	   		    sheetObj.SetCellValue(nRow, "del_chk","Y",0);
//	   		    nStartRow=nRow+1;
//	   	    }
//        } 
        //2) deleting prev_tro_seq  : deleting all checked row from the screen(do not send to server)        
//        var sRow=sheetObj.FindCheckedRow("del_chk");
//      // ACTIVE 버젼처럼 추가해준다.
//        if(sRow.length >0 ) {
//     	   sRow = sRow +"|";
//        }
//        var arrRow=sRow.split("|");
//        for (var idx=arrRow.length-2; idx>=0; idx--)
//        { 
//        	sheetObj.RowDelete(arrRow[idx], false);
//        }
 
        for(i=sheetObj.RowCount();0<i;i--){
        	if(sheetObj.GetCellValue(i, "tro_seq")== prev_tro_seq){
        		sheetObj.RowDelete(i, false);
        	}
        }
         
        //3) parsing comboObj.Text 
        comboCodeToSheet(sheetObj, comboObj_1, "DG", prev_tro_seq);
        comboCodeToSheet(sheetObj, comboObj_2, "RF", prev_tro_seq);
        comboCodeToSheet(sheetObj, comboObj_3, "AK", prev_tro_seq);
    }
    /** 
     * Tro-Mastr spcl_cgo_seq Store : (multicombo값) 
     */
    function comboCodeToSheet(sheetObj, comboObj, spcl_cgo_cd, prev_tro_seq) {
        var strText=comboObj.GetSelectText();
        if (strText != "") {
	        var arrComboSeq=strText.split("|");   
	        for (var i=0; i<arrComboSeq.length; i++) {	
		        var nNewRow=sheetObj.DataInsert(-1);  //adding new row
		    	sheetObj.SetCellValue(nNewRow, "tro_seq",prev_tro_seq,0);
		    	sheetObj.SetCellValue(nNewRow, "spcl_cgo_cd",spcl_cgo_cd,0);
		    	sheetObj.SetCellValue(nNewRow, "spcl_cgo_seq",arrComboSeq[i],0);
	        }
        }
    }
    //######################[5. Etc]##############################################################
    // addRow prev MaxSeq get
    function getPrevMaxTroSeq(sheetObj, nRow, colId)
	{
	    var prevMaxTroSeq=0;
		//-------------------------------------------
		//1) tro-master :  creating New tro_seq 	
		if (nRow > 1) {
			prevMaxTroSeq=sheetObj.GetCellValue(nRow-1, colId);  //LastRow()s() , nRow->RowInsert returnRow
		} else {
			prevMaxTroSeq=0; 
		}
		//alert("prevMaxTroSeq->"+prevMaxTroSeq);
		return prevMaxTroSeq;
	}
    /**  
     * ibflag('D')row : Delete Color 
     * : -> dtl cxl/cfm , disabled and cacel line
     */ 
    function setRowDelColorChange(sheetObj, colId) {
    	var cfm_flg_mst=getMstValue_currSeq(sheetObj, "cfm_flg");
	   	for (var i=1; i<=sheetObj.RowCount(); i++) {
	   		if ("Y" == sheetObj.GetCellValue(i, "cxl_flg")) {
				sheetObj.SetCellValue(i, "cxl_flg","Y",0);
				sheetObj.SetRangeFontColor(i, 0, i, sheetObj.LastCol(),"#FF0000");
				//영역에 글자 취소선 설정
				sheetObj.SetCellFont("FontStrike", i, 0, i, sheetObj.LastCol(),1);
				changeAllGetCellEditable(sheetObj, i, 3, sheetObj.LastCol(), false);
			} else if ("Y" == cfm_flg_mst) {
				changeAllGetCellEditable(sheetObj, i, 3, sheetObj.LastCol(), false);
				changeAllGetCellEditable(sheetObj, i, 8, 9, true);	// BKG_TRO, CFM_FLG = 'Y' enable 로직
			}
		} 
    }
    /**  
     * returning certain column Value of master-row(current tro_seq)
     */ 
    function getMstValue_currSeq(sheetObj, colId) {    	
	   	var formObj=document.form;
	   	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);    	
		var strCurrTroSeq="";
		var sheetObj_mst=null; 
		if (strSheetId_gubun == "_b") {
			sheetObj_mst=x_sheetObject7;
			strCurrTroSeq=t2_tro_seq.GetSelectText();
		} else {
			sheetObj_mst=x_sheetObject2;
			strCurrTroSeq=tro_seq.GetSelectText();
		} 
   		var nSRow_mst=sheetObj_mst.FindText("tro_seq", strCurrTroSeq);
   		var strReturnVal_mst=sheetObj_mst.GetCellValue(nSRow_mst, colId);
   		return strReturnVal_mst;
    }
    /**     
    * Sum_qty reCalc/removeAll/reDisplay : tro_qty sum change  
    */
    function changeTroQtySum(curr_tro_seq) {
        var formObj=document.form;
		var sheetObj=x_sheetObject3;
		var sheetObj_qty=x_sheetObject5; 
        //var curr_tro_seq = tro_seq.Text;
        sheetObj_qty.RemoveAll();
		for (var i=1; i<=sheetObj.RowCount(); i++)
		{
			var t_ibflag=nullToBlank(sheetObj.GetCellValue(i, "ibflag"));
			var t_cxl_flg=nullToBlank(sheetObj.GetCellValue(i, "cxl_flg"));
            if (t_ibflag != "D" && t_cxl_flg != "Y")  // except deleting/cancel
            {
            	var t_tpsz=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
            	var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
				//var t_qty     = sheetObj.CellValue(i, "tro_qty");
            	var t_qty=BkgNullToString(sheetObj.GetCellValue(i, "tro_qty"), "0");
				var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", t_tpsz);
				if (nSRow > -1) //exist
				{
					sheetObj_qty.SetCellValue(nSRow, "total_qty",parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty")) + parseInt(t_qty),0);
                    if (curr_tro_seq == t_tro_seq)
                    {
                        //sheetObj_qty.CellValue2(nSRow, "tro_qty") = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty")) + parseInt(t_qty);
                    	sheetObj_qty.SetCellValue(nSRow, "tro_qty",parseInt(BkgNullToString(sheetObj_qty.GetCellValue(nSRow, "tro_qty"), "0")) + parseInt(t_qty),0);
                    }
				} 
				else 
				{
                    var nNRow=sheetObj_qty.DataInsert(-1);
                    sheetObj_qty.SetCellValue(nNRow, "cntr_tpsz_cd",t_tpsz,0);
                    sheetObj_qty.SetCellValue(nNRow, "total_qty",t_qty,0);
                    if (curr_tro_seq == t_tro_seq)
                    {
                        sheetObj_qty.SetCellValue(nNRow, "tro_qty",t_qty,0);
                    }
				}
            }	
		} 
		sheetObj_qty.ColumnSort("cntr_tpsz_cd");
    }
    /**
    * adding split remark to text area
    */    
    function setAddRemarkText(comboObj, idx_cd, text) {
    	if (comboObj.GetItemCheck(idx_cd)) {  //multi combo : check box
	    	if (comboObj) {
	        	var arrComboText=text.split("|"); // adding remark at text area
	        	var objRemark=document.form.diff_rmk;
	        	if(objRemark.value) {
	        		objRemark.value += " ";
	        	}
	        	objRemark.value += arrComboText[1];
	    	}
    	}
    }
    /**
    * as flag is changed, handling button change 
    */
    function changeDisplayBtn(btnNm, link_flag) {
 	    if ("Y" == link_flag) {
// 		    document.getElementById(btnNm).style.color="#0000ff";
 	    	document.getElementById(btnNm).style.setProperty("color", BTN_BLUE, "important");
	    } else {
		    document.getElementById(btnNm).style.color="";
	   }
    }
    /**
    * Td button (to check Link status)
    */
    function checkTdUnLink(btnNm) {
//   	    return !(document.getElementById(btnNm).style.color == "#0000ff");
//    	return !(document.getElementById(btnNm).style.color == "rgb(1, 0, 255)");
    	return !( ComGetWebColor( document.getElementById(btnNm).style.color ) == BTN_BLUE);
    	
    }        
    /** 
    * (All) changing background color of combo
    */    
    function setChangeAllComboBackColor() {
    	var formObj=document.form;
    	setComboBackColor(dcgo_seq);
    	setComboBackColor(rc_seq);
    	setComboBackColor(awk_cgo_seq);
    }
    /** 
    * (certain)changing background color of combo 
    */
    function setComboBackColor(comboObj) {
    	if ("" != comboObj.GetSelectText()) {
    		comboObj.SetBackColor("#ff0000");
    		comboObj.fontcolor="#ffffff";
    	} else {
    		comboObj.SetBackColor("#ffffff");
    		comboObj.fontcolor="#606060";
    	} 
    }
	/**     
	 *  changing attribute of editable at certain cell
	 */
    function changeAllGetCellEditable(sheetObj, nRow, nSCol, nECol, bFlag) {
        for (var i=nSCol; i<=nECol; i++) {
            sheetObj.SetCellEditable(nRow, i,bFlag);
        }
    }
    /**
     *  for checking disabled status of the Td button 
     */
    function checkTdDisabled(srcName) {
    	return !(document.getElementById(srcName).className.indexOf('_1') == -1);
    }
    /**
     * for checking disabled status of the img button  : previous input tag check
     */
    function checkInputDisabled(srcName) {
     	return (document.getElementById(srcName).getAttribute("readOnly") || document.getElementById(srcName).getAttribute("isDisabled"));
    }
    //######################[6. Check/Link/Popup]#################################################
    /**
     * handling process for input validation 
     */
    function validateForm(sheetObj, formObj, sAction, delFlg) {
	    if (delFlg == null) {
	    	delFlg="N";
	    }	   
   	    //checking Validation     	 
        with(formObj)
        {
        	switch (sAction) {
        	    case IBSEARCH:
					if (bkg_no.value == "" && bl_no.value == "") {
					   // ComShowCodeMessage("BKG00255");
					   //  ComSetFocus(bkg_no);
					    return false;
					}
        	    	break;
        	    case IBSAVE:
        	   	    //0) -maxlength, checking Validation  
        	   	    //if (!ComChkValid(formObj)) return false; -> checking onchange         	    	
  					if (bkg_no.value != oldBkgNo.value) {
  					    ComShowCodeMessage("BKG00448");  //clicking retrieve button first
  					    ComSetFocus(bkg_no);
  					    return false;
  					}
  					formObj.f_del_flg.value=delFlg;  //classifying event (delete:Y, request:R, save:N)
  					if (tabObjects[0].GetSelectedIndex() == 1)  
  					{
   					    //1) Dtl : check
  						if (!checkDtl(x_sheetObject8)) {
  							return false;
  						}
  					    //2) Master : check
  						if (!checkMaster(x_sheetObject7)) {
  							return false;
  						}
  					} else {
  						//1) Dtl : check
  						if (!checkDtl(x_sheetObject3)) {
  							return false;
  						}
  						//2) Master : check
  						if (!checkMaster(x_sheetObject2)) {
  							return false;
  						}
  					}
        	        if (delFlg == "N" && !ComShowCodeConfirm("COM12147", "")) {
        	    		return false;
        	        } else if (delFlg == "C" && !ComShowCodeConfirm("COM12147", "Current Troseq")) {
        	    		return false;
        	    	} else if (delFlg == "R" && !ComShowCodeConfirm("BKG00521")) {
        	    		return false;
        	    	}
        	    	break;
        	}
        }
        return true;
    } 
    /**
    * Dtl Grid :  checking mandatory before saving  
    */    
    function checkDtl(sheetObj) {
	   	var formObj=document.form;
	   	var delFlg=formObj.f_del_flg.value;
	   	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);    	
		var strTab="";
		var strCurrTroSeq="";
		var sheetObj_mst=null; 		
		var strMsgExistYn="N";
		if (strSheetId_gubun == "_b") {
			sheetObj_mst=x_sheetObject7;
			strTab="(Return)"; 
			strCurrTroSeq=t2_tro_seq.GetSelectText();
		} else {
			sheetObj_mst=x_sheetObject2;
			strTab="(General)";
			strCurrTroSeq=tro_seq.GetSelectText();
		} 
	   	for (var i=1; i<=sheetObj.RowCount(); i++)
	   	{
	   		var t_cxl_flg=sheetObj.GetCellValue(i, "cxl_flg");
	   		var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
	   	    //01. Request Row Find : current value of tro_seq  -> request tro_seq 
	   	    //02. Confirm Row Find : 
	   		var nSRow_mst=sheetObj_mst.FindText("tro_seq", t_tro_seq);
	   		var cfm_flg_mst=sheetObj_mst.GetCellValue(nSRow_mst, "cfm_flg");
	   		var cfm_flg_old_mst=sheetObj_mst.GetCellValue(nSRow_mst, "cfm_flg_old");
    		if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
    	   		 (t_cxl_flg == "Y") )  //skip it which is confirmed before 
    		{
    			continue; 
    		}
    		//---------------------->
	   	    //03. (request/confirm)  putting in action to check   
    		var t_dor_arr_dt=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(i, "dor_arr_dt")), "-", "");
    		var t_dor_arr_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(i, "dor_arr_dt_hhmi")), ":", "");
			var t_arr_dt=t_dor_arr_dt + t_dor_arr_dt_hhmi;
			//madatory check
   			if ((delFlg == "R" && t_tro_seq == strCurrTroSeq) || cfm_flg_mst != cfm_flg_old_mst)
   			{
	   		    //1) TP/SZ
   				var t_tpsz=nullToBlank(sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
	   			if (t_tpsz == "") {   
	   				ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+", TP/SZ");
	   				return false;
	   			}
	   			//2) Qty
	   			var tTroQty=nullToBlank(sheetObj.GetCellValue(i, "tro_qty"));
	   			if (tTroQty == "") {
	   				ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+", Qty");
	   				return false;
	   			}
	   		    //3) Arrival dt			
	   		    if (strSheetId_gubun != "_b") {
					if (t_dor_arr_dt != "" && t_dor_arr_dt_hhmi == "") {
						ComShowCodeMessage("COM12138", "["+strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
						return false; 
					}
					if (t_dor_arr_dt_hhmi != "" && t_dor_arr_dt == "") {
						ComShowCodeMessage("COM12138", "["+strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
						return false;  
					} 
					if (t_arr_dt != "") {
						var etb_dt=formObj.etb_dt.value;
						var toDay=ComGetNowInfo("ymd")+ComGetNowInfo("hm");
						toDay=ComReplaceStr(toDay, "-", ""); 
						toDay=ComReplaceStr(toDay, ":", ""); 
						if (t_arr_dt.substr(0,8) < toDay.substr(0,8)) {
							//ComShowCodeMessage("COM12131", "["+strTab+"Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date"); 
							//return false;   // saving after showing warning message	 -> retroactively apply past date
							strMsgExistYn="Y";
						}
						if (etb_dt != "" && t_arr_dt.substr(0,8) > etb_dt.substr(0,8)) {
							ComShowCodeMessage("COM12133", "["+strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "ETB Date", "lesser");
							return false;				
						}  
					} else {
						ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+", Door Arrival Date");
						return false; 
					}
	   		    }
   			} else {
				//3) Arrival dt		
				if (strSheetId_gubun != "_b") {
					if (t_dor_arr_dt != "" && t_dor_arr_dt_hhmi == "") {
						ComShowCodeMessage("COM12138", "["+strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
						return false;   
					}
					if (t_dor_arr_dt_hhmi != "" && t_dor_arr_dt == "") {
						ComShowCodeMessage("COM12138", "["+strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
						return false;  
					} 
					if (t_arr_dt != "") {
						var etb_dt=formObj.etb_dt.value;
						var toDay=ComGetNowInfo("ymd")+ComGetNowInfo("hm");
						toDay=ComReplaceStr(toDay, "-", ""); 
						toDay=ComReplaceStr(toDay, ":", "");
						// in case of today, changing condition to pass validation , old version (t_arr_dt <= toDay)
						if (t_arr_dt.substr(0,8) < toDay.substr(0,8)) {
							//ComShowCodeMessage("COM12131", "["+strTab+"Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date"); 
							//return false; //saving after showing warning message  -> retroactively apply past date
							strMsgExistYn="Y";
						}
						if (etb_dt != "" && t_arr_dt.substr(0,8) > etb_dt.substr(0,8)) {
							ComShowCodeMessage("COM12133", "["+strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "ETB Date", "lesser");
							return false;
						}   
					} 
				}
   			}
	   	    //<----------------------
	   	}
	   	if (strSheetId_gubun != "_b" && strMsgExistYn == "Y") {
	   		ComShowCodeMessage("COM12131", "Door Arrival Date");
	   	}
	   	return true;
    }
   /**
   * Master Grid : checking all before saving     
   */ 
   function checkMaster(sheetObj) {
  	   var formObj=document.form;
  	   var delFlg=formObj.f_del_flg.value;
  	   var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2); 
  	   var strTab="";
  	   var strCurrTroSeq="";
  	   if (strSheetId_gubun == "_b") {
  			strTab="(Return)";
  			strCurrTroSeq=t2_tro_seq.GetSelectText();
  	   } else {
  			strTab="(General)";
  			strCurrTroSeq=tro_seq.GetSelectText();
  	   }
       var t_Por=formObj.por_cd.value.substr(0,2);
       for (var i=1; i<=sheetObj.RowCount(); i++) {
    	   var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
    	   var t_cxl_flg=sheetObj.GetCellValue(i, "cxl_flg");
    	   var strCfmFlg=sheetObj.GetCellValue(i, "cfm_flg");
    	   var strCfmFlg_old=sheetObj.GetCellValue(i, "cfm_flg_old");
    	   //alert("delFlg, t_tro_seq, strCurrTroSeq, t_cxl_flg, strCfmFlg, strCfmFlg_old->\n"+delFlg+", "+t_tro_seq+", "+strCurrTroSeq+", "+t_cxl_flg+", "+strCfmFlg+", "+strCfmFlg_old);
    	   //01. (not cancel, saveSeq/request/confirm) putting in action of check logic  
	   	   if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
	   		    (delFlg == "R" && (t_tro_seq != strCurrTroSeq)) || 
	   		    (t_cxl_flg == "Y")  
	   		   // ||(strCfmFlg == strCfmFlg_old)
	   		     ) 
	   	   {
		       continue; 
		   }
   		   //03. check----------------------------->
           //Actual Customer Nm : act_shpr_nm
	   	   var t_act_shpr_nm=nullToBlank(sheetObj.GetCellValue(i, "act_shpr_nm"));
           if (t_act_shpr_nm == "") {
        	   ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Actual Customer Name");
               return false;
           }
           //Location 
           var t_dor_loc_cd=nullToBlank(sheetObj.GetCellValue(i, "dor_loc_cd"));
           var t_zn_cd=nullToBlank(sheetObj.GetCellValue(i, "zn_cd"));
           if (t_dor_loc_cd == "" && t_zn_cd != "") {
        	   ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Location");
               return false;
           }
           //Zip
           var t_zip=nullToBlank(sheetObj.GetCellValue(i, "dor_pst_no"));
           if ("US" == t_Por && t_zip == "") {
        	   ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Zip");
               return false;
           }
           var t_cntc_phn_no=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(i, "cntc_phn_no")), "-", "");
		   //alert (t_cntc_phn_no);
		   if (t_cntc_phn_no == "" && delFlg == "R") {
			   ComShowCodeMessage("COM12200", strTab+"Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", TEL");
			  	return false;
		   }
           //<------------------------------------- 
       }
       return true;
   }
    /**
     * setting the common pop up of Actual Customer 
     */     
    //function setActCustCallBack(aryPopupData, row, col, sheetIdx) { 
    function setActCustCallBack(aryPopupData) {
        var formObj=document.form;     
    	//var p_loc_cd              = nullToBlank(aryPopupData[0][1]); 
    	//var p_zn_cd               = nullToBlank(aryPopupData[0][2]);  
    	var p_act_shpr_nm=nullToBlank(aryPopupData[0][3]); 
    	var p_cnt_cd=nullToBlank(aryPopupData[0][4]); 
    	//var p_vndr_seq            = nullToBlank(aryPopupData[0][5]); 
    	//var p_vndr_lgl_eng_nm	    = nullToBlank(aryPopupData[0][6]); 
    	var p_cntc_pson_nm=nullToBlank(aryPopupData[0][7]); 
    	var p_cntc_phn_no=nullToBlank(aryPopupData[0][8]); 
    	var p_cntc_mphn_no=nullToBlank(aryPopupData[0][9]); 
    	var p_act_shpr_addr=nullToBlank(aryPopupData[0][10]);
    	var p_dor_zip_id=nullToBlank(aryPopupData[0][14]);
    	var p_diff_rmk=nullToBlank(aryPopupData[0][15]);
    	var p_cntc_fax_no=nullToBlank(aryPopupData[0][16]);
    	var p_cntc_eml=nullToBlank(aryPopupData[0][17]);
    	var p_tro_act_cust_knd_cd=nullToBlank(aryPopupData[0][18]);   //E, C
    	//var tro_vndr_seq        = nullToBlank(aryPopupData[0][15]); 
    	//var cnt_cd              = nullToBlank(aryPopupData[0][16]); 
    	var p_cust_seq=nullToBlank(aryPopupData[0][21]); 
    	//var ofc_cd              = nullToBlank(aryPopupData[0][18]); 
    	//var tro_act_rep_seq     = nullToBlank(aryPopupData[0][19]); 
        if (tabObjects[0].GetSelectedIndex() == 1) {
            with(formObj) {
/*             
    	        if (t2_act_shpr_cnt_cd.value == "") { t2_act_shpr_cnt_cd.value=p_cnt_cd; }
    	        if (t2_act_shpr_seq.value    == "") { t2_act_shpr_seq.value=p_cust_seq; }
    	        if (t2_act_shpr_nm.value     == "") { t2_act_shpr_nm.value=p_act_shpr_nm; }	        
    	        //if (t2_dor_loc_cd.value      == "") { t2_dor_loc_cd.value      = p_loc_cd; }
    	        //if (t2_zn_cd.value           == "") { t2_zn_cd.value           = p_zn_cd; }
    	        if (t2_dor_pst_no.value      == "") { t2_dor_pst_no.value=p_dor_zip_id; }
    	        if (t2_act_shpr_addr.value   == "") { t2_act_shpr_addr.value=p_act_shpr_addr; }
    	        if (t2_cntc_pson_nm.value    == "") { t2_cntc_pson_nm.value=p_cntc_pson_nm; }
    	        if (t2_cntc_phn_no.value     == "") { t2_cntc_phn_no.value=p_cntc_phn_no; }
    	        if (t2_cntc_mphn_no.value    == "") { t2_cntc_mphn_no.value=p_cntc_mphn_no; }
    	        if (t2_cntc_fax_no.value     == "") { t2_cntc_fax_no.value=p_cntc_fax_no; }
*/     	        
				t2_act_shpr_cnt_cd.value=p_cnt_cd;
				t2_act_shpr_seq.value=p_cust_seq;
				t2_act_shpr_nm.value=p_act_shpr_nm;
				//t2_dor_loc_cd.value      = p_loc_cd;
				//t2_zn_cd.value           = p_zn_cd;
				t2_dor_pst_no.value=p_dor_zip_id;
				t2_diff_rmk.value=p_diff_rmk;
				t2_act_shpr_addr.value=p_act_shpr_addr;
				t2_cntc_pson_nm.value=p_cntc_pson_nm;
				t2_cntc_phn_no.value=p_cntc_phn_no;
				t2_cntc_mphn_no.value=p_cntc_mphn_no;
				t2_cntc_fax_no.value=p_cntc_fax_no;
            }            
		} else {
	        with(formObj) {
/* 	        	
		        if (act_shpr_cnt_cd.value == "") { act_shpr_cnt_cd.value=p_cnt_cd; }
		        if (act_shpr_seq.value    == "") { act_shpr_seq.value=p_cust_seq; }
		        if (act_shpr_nm.value     == "") { act_shpr_nm.value=p_act_shpr_nm; }	        
		        //if (dor_loc_cd.value      == "") { dor_loc_cd.value      = p_loc_cd; }
		        //if (zn_cd.value           == "") { zn_cd.value           = p_zn_cd; }
		        if (dor_pst_no.value      == "") { dor_pst_no.value=p_dor_zip_id; }
		        if (act_shpr_addr.value   == "") { act_shpr_addr.value=p_act_shpr_addr; }
		        if (cntc_pson_nm.value    == "") { cntc_pson_nm.value=p_cntc_pson_nm; }
		        if (cntc_phn_no.value     == "") { cntc_phn_no.value=p_cntc_phn_no; }
		        if (cntc_mphn_no.value    == "") { cntc_mphn_no.value=p_cntc_mphn_no; }
		        if (cntc_fax_no.value     == "") { cntc_fax_no.value=p_cntc_fax_no; }
*/ 
				act_shpr_cnt_cd.value=p_cnt_cd;
				act_shpr_seq.value=p_cust_seq;
				act_shpr_nm.value=p_act_shpr_nm;
				//dor_loc_cd.value      = p_loc_cd;
				//zn_cd.value           = p_zn_cd;
				dor_pst_no.value=p_dor_zip_id;
				diff_rmk.value=p_diff_rmk;
				act_shpr_addr.value=p_act_shpr_addr;
				cntc_pson_nm.value=p_cntc_pson_nm;
				cntc_phn_no.value=p_cntc_phn_no;
				cntc_mphn_no.value=p_cntc_mphn_no;
				cntc_fax_no.value=p_cntc_fax_no;
	        }
		}
    }
    /**
    *  setting the common pop up of Location
    */
    function getCOM_ENS_061_1(aryPopupData, row, col, sheetIdx) { 
    	var formObj=document.form;
    	var nod_cd=aryPopupData[0][3];
    	if (nod_cd.length == 7) {
            if (tabObjects[0].GetSelectedIndex() == 1) {
            	formObj.t2_dor_loc_cd.value=nod_cd.substr(0,5); 
            	formObj.t2_zn_cd.value=nod_cd.substr(5,7); 
    		} else {
            	formObj.dor_loc_cd.value=nod_cd.substr(0,5); 
            	formObj.zn_cd.value=nod_cd.substr(5,7); 
    		} 
    	}
    }
    //#############################(7. Util/Etc)##################################################
	function ComEnableObject_loc(obj, bEnable)
	{
	     try {
	     	//setting disabled or readOnly 
	         switch( obj.type ) {
	             case "password" :
	             case "text" :
	             	obj.readOnly=!bEnable;
	                 break;
	             default:
	                 obj.disabled=!bEnable;
	         }
			 //handling css 
	         switch( obj.type ) {
	             case "select-one" :
	             case "text" :
	                 if (bEnable){
	                     if (obj.className=="input2_2"){	   //gray - mandatory
	                     	obj.className="input1";	       //white - mandatory 
	                     } else if (obj.className=="input2"){  //white
	                     	obj.className="input";           //white
	                     }
	                 } else {
	                     if (obj.className=="input1"){         //mandatory
	                     	obj.className="input2_2";        //gray
	                     } else if (obj.className=="input"){   //white
	                     	obj.className="input2";          //gray
	                     }
	                 }
	                 break;
	             case "textarea":
	                 if (bEnable){
	                 	obj.className="textarea";
	                 } else {
	                 	obj.className="textarea2";
	                 }
	                 break;
				default :
	                 if (obj.tagName=="IMG" || obj.tagName=="img") {
	                     if (bEnable){
	                         obj.style.cursor="hand";
	                         obj.style.filter="";
	                     } else {
	                         obj.style.cursor="default";
	                         obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
	                     }
	                 }
				     break;
         	 }	
	     } catch(err) { ComFuncErrMsg(err.message); }
	}
	/**
	 * InputBox  
	 * handling Enable/Disable  
	 */
	function ComEnableManyObjects_loc(bEnable, objs) {
	    try {
	        var args=arguments;
	        if (args.length < 2) return;
	        for(var i=1; i<args.length; i++) {
	            if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
//	/**
//	 * IBMultiCombo  
//	 * handling Enable/Disable  
//	 */
//	function ComEnableManyIBCombo(bEnable, objs) {
//	    try {
//	         var args=arguments;
//	         if (args.length < 2) return;
//	         for(var i=1; i<args.length; i++) {
//	             if (args[i].tagName != undefined) {
//	            	 setComboObject(eval("document.all."+args[i].name));
////	                 args[i].SetEnable(bEnable);
//	             }
//	         } 
//	     } catch(err) { ComFuncErrMsg(err.message); }
//     }
	/**
	 * Td button 
	 * handling Enable/Disable  
	 */
    function ComEnableManyTd(bEnable, objs) {
	    try {
	        var args=arguments;
	        if (args.length < 2) return;
	        for(var i=1; i<args.length; i++) {
	 	    	if (bEnable == true) {	 	    		
		    		ComBtnEnable(args[i]);
		    	} else {
		    		ComBtnDisable(args[i]);
		    	} 
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
    }	    
    function callShowMessageAddSeq() {
    	ComShowCodeMessage("COM12130", "click event", "AddSeq button");
    }
    function callShowMessageReProc(strMsgTitle, strMsg2) {
    	if (strMsg2 == null) { strMsg2="rehandling"; }
    	ComShowCodeMessage("COM12242", "Already ["+strMsgTitle+"] process status. "+strMsg2);
    } 
    function callShowMessageBiggerQty(strMsgTitle) {
        ComShowCodeMessage("COM12133", "["+strMsgTitle+"] Total Qty", "or equal to the BKG Qty", "lesser");
    } 
	 /**
	 * t2bsheet1_OnAfterEdit  
	 * sheet calling function after modifying 
	 * @param sheetObj, Row, Col, Value
	 */
    function t2bsheet1_OnAfterEdit(sheetObj, Row, Col, Value) {
    	ComSetObjValue(document.form.modify_flag, "Y");
	}
	 /**
	 * t2bsheet1_b_OnAfterEdit  
	 * sheet calling function after modifying 
	 * @param sheetObj, Row, Col, Value
	 */
	function t2bsheet1_b_OnAfterEdit(sheetObj, Row, Col, Value) {
		ComSetObjValue(document.form.modify_flag, "Y");
	}
	 /**
	 * check_Enter  
	 * searching history
	 * @param 
	 * @return 
	 */
	function check_Enter() {
		var formObj=document.form;
    	var srcName=ComGetEvent("name");
    	var srcValue=ComGetEvent("value");
		if (event.keyCode == 13) {
			if(event.srcElement.name == "bkg_no" || event.srcElement.name == "bl_no"){
				formObj.elements[srcName].value=srcValue.toUpperCase();
				doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
			}
		}
	}
	 /**
	  * onblur event <br>
	  **/
	 function obj_deactivate() {
		if(event.srcElement.name != "bkg_no" && event.srcElement.name != "bl_no"){
			 if(eval('document.form.'+event.srcElement.name).value.length > 0){
				 ComSetObjValue(document.form.modify_flag, "Y");	 
			 }
		} else {
	    	var formObj=document.form;
	    	var srcName=ComGetEvent("name");
	    	var srcValue=window.event.srcElement.getAttribute("value");
			formObj.elements[srcName].value=srcValue.toUpperCase();
		}
	  }
	 /**
	 * searchData :searching in case of moving tab
	 * bkgNo : 
	 * putting in action at 0079
	 */
	 function searchData(bkgNo){
	 	var formObj=document.form;
	 	ComSetObjValue(formObj.bkg_no ,bkgNo);
	 	ComSetObjValue(formObj.modify_flag,"N");
	 	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
	 }
	 /**
	 * checkModify: saving in case of moving tab
	 * param : 
	 * putting in action at 0079
	 */
	 function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			tab_alert_msg=false;
			if (!ComShowConfirm(ComGetMsg("BKG00350")))
				return false; // Are you sure to save the changes?
			doActionIBSheet(x_sheetObject2, formObj, IBSAVE);
		}
	 }
	/**
	* setInquiryDisableButton  .<br>
	* in case of ComBtnDisable , deactivating 
	* @param 
	*/
	function setInquiryDisableButton(){
		ComBtnDisable("btn_t2bSaveSeq");
		ComBtnDisable("btn_t2bCancelSeq");
		ComBtnDisable("btn_t2bRequest");
		ComBtnDisable("btn_t2bAddSeq");
		ComBtnDisable("btn_t2bCopySeq");
		ComBtnDisable("btn_t2bTROCopy");
		ComBtnDisable("btn_t2bSave");
		ComBtnDisable("btn_t2bCancelAll");
		ComBtnDisable("btn_t2bAdd");
		ComBtnDisable("btn_t2bDelete");
		ComBtnDisable("btn_t2bCopy");
	}
	/* the end of developer's work */