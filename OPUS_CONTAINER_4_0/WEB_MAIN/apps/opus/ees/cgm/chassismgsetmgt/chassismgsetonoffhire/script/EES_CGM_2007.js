/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2007.js
*@FileTitle  : Chassis On-Hire Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_2007 : ees_cgm_2007 business script for
 */
function ees_cgm_2007() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
/* developer jop */
//common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
 function processButtonClick(){
      /***** use additional sheet var in case of more than 2 tap each sheet *****/
      var sheetObject=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
         switch(srcName) {
             case "New":
            	// SHEET RESET
            	sheetObject.RemoveAll();
     			// HTML OBJECT RESET
     			formObject.reset();
     			chk('O');
                break;
             case "Row_Add":
            	 sheetObject.DataInsert();
     			for(i=1; i<sheetObject.RowCount()+1; i++){
     				sheetObject.SetCellValue(i, "eq_knd_cd",formObject.eq_knd_cd.value);
     				if(sheetObject.GetCellValue(i, "cre_usr_id") == ""){
    					sheetObject.SetCellValue(i, "cre_usr_id",formObject.cre_id.value);
    				}
    			}
				 break;
             case "Delete":
            	 rowDelete(sheetObject);
				 break;
     		 case "btn_verify":
    			doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			break;
    		 case "btn_excel":
    			doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    			break;
             case "Save":
    			doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
     		 case "btn_Calendar_a":
    			var cal=new ComCalendar();
    			cal.select(formObject.onh_dt, "yyyy-MM-dd");
    			
    			break;
     		 case "ComOpenPopupWithTargetOffice":
    			ComOpenPopup('/opuscntr/COM_ENS_071.do?ofc_cd='+formObject.onh_ofc_cd.value, 800, 580, "getOfficeCheck", "1,0,1,1,1,1,1", true);
    			break;
     		 case "ComOpenPopupWithTargetYard":
    			//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 545, "3:onh_yd_cd", "1,0,1,1,1,1,1", true);
    			ComOpenPopup('/opuscntr/COM_ENS_061.do?node_cd='+formObject.onh_yd_cd.value, 800, 545, "getYardCheck", "1,0,1,1,1,1,1", true);
    			break;
     		case "ComOpenPopupWithTargetAgree":
     			if(formObj.ownleas[1].checked == true){
     				ComOpenPopup('/opuscntr/EES_CGM_2022.do?pgmNo=EES_CGM_2022', 820, 420, "setProgramNo", "1,0,1,1,1,1", true, false);
     			}
    			break;
            case "btn_downexcel":
            	if(sheetObject.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	} else{
            		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1, Merge:1});
            	}
	   	       	break;
         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
 
 /**
  * Return Value Office Code
  * Office Code Validation 
  */
 function getOfficeCheck(rtnVal){

 	var sheetObj=sheetObjects[0]; 
	var formObj=document.form;
	var rVal = rtnVal[0];
	
	if (rVal.length >0 ){
	   formObj.onh_ofc_cd.value =rVal[3];
					
	   if (formObj.onh_ofc_cd.value != "") {
		   Matched_Chk('Office');
			if (formObj.onh_ofc_cd.value == "") {
				formObj.onh_ofc_cd.focus();
			} 
			Verify_Status_chk();
	    }
    }
 }		 
 
 /**
  * Return Value Yard Code
  * Yard Code Validation 
  */
 function getYardCheck(rtnVal){

 	var sheetObj=sheetObjects[0]; 
	var formObj=document.form;
	var rVal = rtnVal[0];
	
	if (rVal.length >0 ){
	   formObj.onh_yd_cd.value =rVal[3];
					
	   if (formObj.onh_yd_cd.value != "") {
		   Matched_Chk('Yard');
			if (formObj.onh_yd_cd.value == "") {
				formObj.onh_yd_cd.focus();
			} 
			Verify_Status_chk();
	    }
    }
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
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
 function loadPage() {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
     for(i=0;i<sheetObjects.length;i++){
     //
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
     //
         ComEndConfigSheet(sheetObjects[i]);
     }
     for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
     }
     sheet1_OnLoadFinish(sheet1);
 }
  /**
  * 
  * @param sheetObj
  * @return
  */
function sheet1_OnLoadFinish(sheetObj) {
     sheetObj.SetWaitImageVisible(0);
     formObj=document.form;
//     axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	formObj);
// 	 axon_event.addListenerFormat("beforeactivate",		"obj_activate",		formObj);
     axon_event.addListenerForm("blur", "obj_focusout" , formObj); 
     axon_event.addListenerForm("change", "obj_change" , formObj); 
//   axon_event.addListenerFormat("keypress",			"obj_keypress",		formObj);
//   axon_event.addListenerForm('keyup', 'obj_keyup', formObj);

     // reset
     initControl(sheetObjects[0]); 
     sheetObj.SetWaitImageVisible(1);
}
  /**
   * init control of form <br>
   * @param  {object} sheetObj	
   * @return 
   * @author 
   * @version
   */
  function initControl(sheetObj){
  	// Form object
  	  formObj=document.form;
      // axon event regist
    doActionIBSheet(sheetObj, formObj, SEARCH04); // COMBO retrieve(TYPE SIZE)
    doActionIBSheet(sheetObj, formObj, SEARCH03); // COMBO retrieve(TYPE SIZE)
    yard_Chk();
  }
/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
         case 1:      //t1sheet1 init
        	    with(sheetObj){
	        	       var HeadTitle="||Seq.|M.G.Set No.|Type|Manufacture Date|Model No.|Machine Serial No.|Voltage (V)|Fuel Capacity (ltr)|Verify Status|Created By|||||||||";
	        	       var headCount=ComCountHeadTitle(HeadTitle);
	
	        	       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        	       var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        	       var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        	       InitHeaders(headers, info);
	
	        	       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	        	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	        	              {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	        	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	              {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd" },
	        	              {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eq_spec_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"mgst_mchn_ser_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"Combo",     Hidden:0, Width:90,   Align:"Right",  ColMerge:0,   SaveName:"mgst_vltg_capa",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",  ColMerge:0,   SaveName:"mgst_fuel_capa",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",  ColMerge:0,   SaveName:"verify",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	              {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"own_lse" },
	        	              {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd" },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"onh_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"agreement_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"agmt_ver_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"onh_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"onh_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        	        
	        	       InitColumns(cols);
	
	        	       SetEditable(1);
	        	       SetShowButtonImage(1);
	        	       SetSelectionMode(smSelectionFree);
	        	       SetColProperty(0, "mgst_vltg_capa", {ComboText:"|220|440", ComboCode:"|220|440"} );
	        	       SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	        	       SetColProperty(0 ,"mgst_mchn_ser_no" , {AcceptKeys:"E|N|`~!@#$%^&*()_+=|  \\ \/?><,. -[]{}" , InputCaseSensitive:1});
	        	       SetColProperty(0 ,"mgst_fuel_capa" , {AcceptKeys:"N"});
//	        	       SetSheetHeight(320);
	        	       resizeSheet();
        	    }
             break;
     }
 }
 function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

// handling process for Sheet
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
	     case IBSEARCH: // retrieve
			var verifyFlag=false;
			var chkFlag=false;
			formObj.f_cmd.value=SEARCHLIST;
			queryString="f_cmd=" + SEARCHLIST;
			if(formObj.onh_ofc_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Office");
//				formObj.onh_ofc_cd.focus();
				return;
			}
			if(formObj.onh_dt.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Date");
//				formObj.onh_dt.focus();
				return;
			}
			if(formObj.onh_yd_cd.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Yard");
//				formObj.onh_yd_cd.focus();
				return;
			}
			if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
				 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
//			 	 formObj.onh_yd_cd.focus();
			     return false;
			}
			if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
				ComShowCodeMessage("CGM10004", "Agreement No");
//				formObj.agreement_no.focus();
				return;
			}
			for(i=1; i<sheetObj.RowCount()+1; i++){
				var del_chk=sheetObj.GetCellValue(i, "del_chk");
				// 
				if(del_chk == "1" && sheetObj.GetCellValue(i, "eq_no")==""){
					sheetObj.SetRowStatus(i,"R");
					sheetObj.SetCellValue(i, "del_chk","0");
				} else if(del_chk == "1" && sheetObj.GetCellValue(i, "eq_no")!=""){
					sheetObj.SetCellValue(i, "own_lse",formObj.own_lse.value);
					sheetObj.SetCellValue(i, "eq_knd_cd",formObj.eq_knd_cd.value);
					chkFlag=true;
				}
				if(formObj.ownleas[1].checked == true  ){
					sheetObj.SetCellValue(i, "agreement_no",formObj.agreement_no.value);
				}
				sheetObj.SetCellValue(i, "onh_dt",formObj.onh_dt.value );
			}
			var params=sheetObj.GetSaveString(true);
			if(sheetObj.RowCount()>0 && chkFlag){
				sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
		 	    sheetObj.DoSearch("EES_CGM_2007GS.do", queryString+"&"+params );
				for(i=1; i<sheetObj.RowCount()+1; i++){
					var verify=sheetObj.GetCellValue(i, "verify")
					// 
					if(verify != "OK"){
						if(sheetObj.GetCellValue(i, "eq_no") == ""){
//							sheetObj.CellValue(i, "del_chk") = "1";
						} else {
							verifyFlag=true;
						}
					}
				}
				ComOpenWait(false);
				if(verifyFlag){
					ComShowCodeMessage("CGM10005");
					//return;
				}
			} else {
				ComShowCodeMessage("CGM10008");	
				return;
			}
			for(i=1; i<sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, "verify") == "OK" && sheetObj.GetCellValue(i, "del_chk") == "1"){
					sheetObj.SetCellEditable(i, "del_chk",1);
					sheetObj.SetCellEditable(i, "eq_no",0);
					sheetObj.SetRowFontColor(i,"#000000");
					sheetObj.SetRowStatus(i,"I");
					if(formObj.ownleas[0].checked == false  ){
						sheetObj.SetCellEditable(i, "eq_tpsz_cd",0);
						sheetObj.SetCellEditable(i,"eq_spec_no",0);
						sheetObj.SetCellEditable(i,"mgst_mchn_ser_no",0);
						sheetObj.SetCellEditable(i,"mgst_vltg_capa",0);
					}
				} else if(sheetObj.GetCellValue(i, "verify") != "OK" && sheetObj.GetCellValue(i, "del_chk") == "1"){
					sheetObj.SetCellValue(i, "del_chk","0");
					sheetObj.SetCellEditable(i, "del_chk",1);
					sheetObj.SetCellEditable(i, "mft_dt",1);
					sheetObj.SetCellEditable(i, "eq_tpsz_cd",1);
					sheetObj.SetCellEditable(i,"eq_spec_no",1);
					sheetObj.SetCellEditable(i,"mgst_mchn_ser_no",1);
					sheetObj.SetCellEditable(i,"mgst_vltg_capa",1);
					sheetObj.SetCellEditable(i,"mgst_fuel_capa",1);
					sheetObj.SetRowFontColor(i,"#FF0000");
				}
			}
			break;
			 case IBSAVE:        //saving
		 		var actionFlag=false; 
	 		    var VerifyFlag=false; 
				if(formObj.onh_ofc_cd.value == ""){
					ComShowCodeMessage("CGM10004", "Office");
//					formObj.onh_ofc_cd.focus();
					return;
				}
				if(formObj.onh_dt.value == ""){
					ComShowCodeMessage("CGM10004", "On-Hire Date");
//					formObj.onh_dt.focus();
					return;
				}
				if(formObj.onh_yd_cd.value == ""){
					ComShowCodeMessage("CGM10004", "On-Hire Yard");
//					formObj.onh_yd_cd.focus();
					return;
				}
				if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
					 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
//				 	 formObj.onh_yd_cd.focus();
				     return false;
				}
				if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
					ComShowCodeMessage("CGM10004", "Agreement No");
//					formObj.agreement_no.focus();
					return;
				}
				formObj.f_cmd.value=MULTI;
				for(i=1; i<sheetObj.RowCount()+1; i++){
					var verify=sheetObj.GetCellValue(i, "verify");
					if(verify == "OK" && sheetObj.GetCellValue(i, "del_chk") == "1"){
						// 
						sheetObj.SetCellValue(i, "onh_dt",formObj.onh_dt.value );
						if(formObj.ownleas[1].checked){
							sheetObj.SetCellValue(i, "agreement_no",formObj.agreement_no.value );
							sheetObj.SetCellValue(i, "agmt_ver_no",formObj.agmt_ver_no.value );
							sheetObj.SetCellValue(i, "vndr_seq",formObj.vndr_seq.value );
							sheetObj.SetCellValue(i, "agmt_lstm_cd",formObj.agmt_lstm_cd.value );
						}
						sheetObj.SetCellValue(i, "onh_yd_cd",formObj.onh_yd_cd.value );
						sheetObj.SetCellValue(i, "onh_ofc_cd",formObj.onh_ofc_cd.value );
						sheetObj.SetCellValue(i, "own_lse",formObj.own_lse.value);
						sheetObj.SetCellValue(i, "eq_knd_cd",formObj.eq_knd_cd.value);
						sheetObj.SetRowStatus(i,"I");
						actionFlag=true; 
					}
					else if(verify == "" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
						ComShowCodeMessage("CGM10004", "verify");
						sheetObj.SetRowStatus(i,"R");
						actionFlag=false; 
						break;
					}
					else if(verify != "OK" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
						sheetObj.SetRowStatus(i,"R");
						VerifyFlag=true; 
						break;
					}
					else {
						sheetObj.SetRowStatus(i,"R");
					}
				}
				if(VerifyFlag){
			        	ComShowCodeMessage("CGM10005");
		        }else if(actionFlag){
					var params=sheetObj.GetSaveString(true);
					formObj.f_cmd.value=MULTI;
					queryString="f_cmd=" + MULTI ;
					sheetObj.SetWaitImageVisible(0);
			 	    ComOpenWait(true);
					if(sheetObj.DoSave("EES_CGM_2007GS.do", FormQueryString(formObj)))
					{
					}
					 ComOpenWait(false);
				}
				else
				{
					ComShowCodeMessage("CGM10008");
				}
				// CONFIRM
             break;
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value=SEARCH12;
		    formObj.agmt_no.value=formObj.agreement_no.value;
		    var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do" , FormQueryString(formObj));
		    // data count
		    var dataCount=ComGetTotalRows(sXml);
		    // data existing
		    if(dataCount > 0){
		    	var lstmCd=DomXml2String(sXml,"agmt_lstm_cd");
		        if(formObj.ownleas[0].checked == true  ){
			       	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){ 
						 ComShowCodeMessage("CGM10067",formObj.agreement_no.value);
			           	 return false;
			       	 } else {
			       		formObj.agreement_no.value=DomXml2String(sXml,"agmt_no");
			        	formObj.agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
			        	formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
			        	// AGREEMENT NO POST PROCESS CALL
			        	formObj.vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
			        	formObj.vndr_seq.value=DomXml2String(sXml,"vndr_seq");
			        	formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
			       	 }
		        } else if(formObj.ownleas[1].checked == true ){
			       	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
			       		 ComShowCodeMessage("CGM10068",formObj.agreement_no.value);
			           	 return false;
			       	 } else {
			       		formObj.agreement_no.value=DomXml2String(sXml,"agmt_no");
			        	formObj.agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
			        	formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
			        	// AGREEMENT NO POST PROCESS CALL
			        	formObj.vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
			        	formObj.vndr_seq.value=DomXml2String(sXml,"vndr_seq");
			        	formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
			       	 }
		        }
		    	return true;
		    } else {
		    	// Form Object reset
		    	ComShowCodeMessage("CGM10009","Agreement No");
		    	formObj.agreement_no.value="";
		    	formObj.agmt_ref_no.value="";
		    	formObj.agmt_lstm_cd.value="";
		    	formObj.vndr_lgl_eng_nm.value="";
		    	formObj.vndr_seq.value="";
		    	return false;
		    }
            break;
        // LOAD EXCEL
		case IBLOADEXCEL:
	 			if (sheetObj.id == "sheet1") {
	 				sheetObj.RemoveAll();
	 				sheetObj.LoadExcel();
	 			}
				
	 			break;
		case IBSEARCH_ASYNC02:	// Office Code  Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.ofc_cd.value=formObj.onh_ofc_cd.value;
		   	var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Office');
		   		formObj.onh_ofc_cd.value="";
//		   		formObj.onh_ofc_cd.focus();
		   	} else {
//		   		formObj.onh_yd_cd.focus();
		   		Matched_Chk('Office');
		   	}
		   	break;
		case IBSEARCH_ASYNC03:	// Office Code  Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.yd_cd.value=formObj.onh_yd_cd.value;
		   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Yard');
		   		formObj.onh_yd_cd.value="";
//		   		formObj.onh_yd_cd.focus();
		   	} else {
//		   		formObj.onh_dt.focus();
		   		Matched_Chk('Yard');
		   	}
		   	break;
		case SEARCH03: //multi combo(TYPE/SIZE)
			formObj.f_cmd.value=SEARCH03;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
	        var arrCode1="";
	        var arrCode2="";
	        for (var i=0; i < arrStr.length;i++ ) {
	        	var arrCode=arrStr[i].split("|");
	        	if(i==0){
	        		arrCode1=arrCode1+" " +"|"+ arrCode[1];
	        		arrCode2=arrCode2+" " +"|"+ arrCode[0];
	        	} else {
	        		arrCode1=arrCode1 +"|"+ arrCode[1];
	        		arrCode2=arrCode2 +"|"+ arrCode[0];
	        	}
	        }
	        sheetObj.SetColProperty(0, "eq_spec_no", {ComboText:arrCode1, ComboCode:arrCode2}, "", "");
		 	break;
		case SEARCH04: //grid multi combo(TYPE/SIZE)
	        formObj.f_cmd.value=SEARCH04;
	        var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	        var sStr=ComGetEtcData(sXml,"comboList");
	        var arrStr=sStr.split("@");
	        var arrCode1="";
	        var arrCode2="";
	        for (var i=0; i < arrStr.length;i++ ) {
	        	var arrCode=arrStr[i].split("|");
	        	if(i==0){
	        		arrCode1=arrCode1+" " +"|"+ arrCode[0];
	        		arrCode2=arrCode2+" " +"|"+ arrCode[1];
	        	} else {
	        		arrCode1=arrCode1 +"|"+ arrCode[0];
	        		arrCode2=arrCode2 +"|"+ arrCode[1];
	        	}
	        }
	        sheetObj.SetColProperty(0, "eq_tpsz_cd", {ComboText:arrCode1 , ComboCode:arrCode2}, "", "");
		 	break;
		    // LOAD EXCEL
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
  * initializing Tab
  * setting Tab items
  */
 function initTab(tabObj , tabNo) {
      switch(tabNo) {
          case 1:
             with (tabObj) {
             }
          break;
      }
 }
 function tab1_OnChange(tabObj , nItem)
 {
     var objs=document.all.item("tabLayer");
 	objs[nItem].style.display="Inline";
 	objs[beforetab].style.display="none";
 	//----------------------------------//
 	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
 	//------------------------------------------------------//
 	beforetab=nItem;
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
//         if (!isNumber(formObj.iPage)) {
//             return false;
//         }
     }
     return true;
 }
 /** 
  * Object change event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version
  */  
     function obj_focusout(){
     	 var formObj=document.form;
     	 var sheetObj=sheetObjects[0]; 
     	 obj=ComGetEvent();
     	 switch(ComGetEvent("name")){
     	   case "onh_ofc_cd":
     	 		if(formObj.onh_ofc_cd.value != ''){
     	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
     	 			break;
     	 		} 
     	   // chungpa 20100414 keyup->focusout start     	 		
     	   case "onh_yd_cd":
	   	    	if (formObj.onh_yd_cd.value != "") {
	   	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	   	    	}
				break;
  		  // chungpa 20100414 keyup->focusout end
     	   case "agreement_no":
     		   if(formObj.agreement_no.value != ''){
       	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
       	 			break;
     		   }else if(formObj.agreement_no.value == ''){
    			   formObj.agmt_ref_no.value="";
    			   formObj.agmt_lstm_cd.value="";
    			   formObj.vndr_lgl_eng_nm.value="";
      	 			break;
    		   }
     		   break;
    	   case "onh_dt":
    		   if(formObj.onh_dt.value != ''){
   			    
      	 			if(getDateObj(formObj.onh_dt.value)>getDateObj(formObj.form_day.value)){
      	 				ComShowCodeMessage("CGM10062");
      	 				formObj.onh_dt.value="";
//      	 				formObj.onh_dt.focus();
      	 			}
    		   } 
    		   break;
     	 }   
     }

     function obj_change(){
     	 var formObj=document.form;
     	 var sheetObj=sheetObjects[0]; 
     	 obj=ComGetEvent();
     	 switch(ComGetEvent("name")){
     	   case "onh_ofc_cd":
     	 		if(formObj.onh_ofc_cd.value != ''){
     	 			Verify_Status_chk();
     	 			break;
     	 		} 
     	   case "agreement_no":
     		   if(formObj.agreement_no.value != ''){
       	 		    Verify_Status_chk();
       	 			break;
     		   }else if(formObj.agreement_no.value == ''){
    			   Verify_Status_chk();
     	 			break;
    		   }
     		   break;
    	   case "onh_dt":
    		   Verify_Status_chk();
    		   break;
    	   case "onh_dt_hm" :
	    	   Verify_Status_chk();
			   break;
     	 }   
     }
          
     
     
 /**
  * YA_CD value check
  * @return
  */
 function obj_keyup(){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 obj=ComGetEvent();
	 switch(ComGetEvent("name")){
	 	case "onh_yd_cd":
		    ComKeyEnter('lengthnextfocus');
		    /*
    	    var onh_yd_cd;
	    	onh_yd_cd=formObj.onh_yd_cd.value;
	    	if (onh_yd_cd.length == 7) {
	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	}
	    	*/
	    	break;
	 }
}
 /**
  * key input limit
  */
 function obj_keypress(){
 	 obj=ComGetEvent();
 	 if(obj.dataformat == null){
 		 return;
 	 }
 	 window.defaultStatus=obj.dataformat;
 	 switch(obj.dataformat) {
   	    case "engup":
     		ComKeyOnlyAlphabet("uppernum");
 	        break;
   	    case "enghi":
   	    	ComKeyOnlyAlphabet("upper");
   	    	break;
 	    case "isnum":
 	    	ComKeyOnlyNumber(obj);
 	    	break;
 	    case "int":
  	    	ComKeyOnlyNumber(obj);
  	        break;
   	 	case "ymd":
   	 		ComKeyOnlyNumber(obj);
   	        break;
   	 	case "ym":
   	 		ComKeyOnlyNumber(obj);
   	        break;
   	 	case "hm":
   	 		ComKeyOnlyNumber(obj);
   	        break;
 	 }
 }
  /**
   * AXON event handling
   */
  function obj_activate(){
      ComClearSeparator(ComGetEvent());
  }
  /** 
   * OBJECT DEACTIVATE event handler  <br>
   */
  function obj_deactivate(){
  	var formObj=document.form;
  	obj=ComGetEvent();
  	if(ComGetEvent("name") == "onh_dt"){
  		with(formObj){
  			var creDtFr=ComReplaceStr(onh_dt.value, "-", "");
  		}
          ComChkObjValid(ComGetEvent());
  	}
  }
   /**
    * inserting value from PROGRAMNO POPUP
    */   
   function setProgramNo(aryPopupData, row, col, sheetIdx){
   	 var formObj=document.form;
   	 var sheetObj=sheetObjects[0];
   	 var agreeNo="";
   	 var referNo="";
   	 var lessNm="";
   	 var lstmCd="";
   	 var vndrSq="";
   	 var agmtVerNo="";
   	 var i=0;
   	 for(i=0; i < aryPopupData.length; i++){
   /*
   		 ComShowMessage(aryPopupData[i][0]); // 1
   		 ComShowMessage(aryPopupData[i][1]); // 0
   		 ComShowMessage(aryPopupData[i][2]); // NYC000027
   		 ComShowMessage(aryPopupData[i][3]); // ZOWGN85003
   		 ComShowMessage(aryPopupData[i][4]); // OW
   		 ComShowMessage(aryPopupData[i][5]); // 111635
   		 ComShowMessage(aryPopupData[i][6]); // SHIPPING CO., LTD
   		 ComShowMessage(aryPopupData[i][7]); // 19930601
   		 ComShowMessage(aryPopupData[i][8]); // 20101231
   		 ComShowMessage(aryPopupData[i][9]); // SELCOE
   		 ComShowMessage(aryPopupData[i][10]);// 19980329  
   */
   		 vndrSq=vndrSq  + aryPopupData[i][5];  // vndr_seq
   		 agreeNo=agreeNo + aryPopupData[i][2];  // agreement_no
   		 referNo=referNo + aryPopupData[i][3];  // reference_no
   		 lstmCd=lstmCd  + aryPopupData[i][4];  // lease term
   		 lessNm=lessNm  + aryPopupData[i][6];  // lessor
   		 agmtVerNo=aryPopupData[i][11];  // lessor
   	 }
        if(formObj.ownleas[0].checked == true  ){
	       	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
	       		 ComShowCodeMessage("CGM10067",agreeNo);
	           	 return false;
	       	 } else {
	       		 formObj.vndr_seq.value=vndrSq;
	       		 formObj.agreement_no.value=agreeNo;
	       		 formObj.agmt_ref_no.value=referNo;
	       		 formObj.agmt_lstm_cd.value=lstmCd;
	       		 // AGREEMENT NO POST PROCESS CALL
	       		 formObj.vndr_lgl_eng_nm.value=lessNm;
	       		 formObj.agmt_ver_no.value=agmtVerNo;
	       	 }
        } else if(formObj.ownleas[1].checked == true ){
	       	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
	       		 ComShowCodeMessage("CGM10068",agreeNo);
	           	 return false;
	       	 } else {
	       		 formObj.vndr_seq.value=vndrSq;
	       		 formObj.agreement_no.value=agreeNo;
	       		 formObj.agmt_ref_no.value=referNo;
	       		 formObj.agmt_lstm_cd.value=lstmCd;
	       		 // AGREEMENT NO POST PROCESS CALL
	       		 formObj.vndr_lgl_eng_nm.value=lessNm;
	       		 formObj.agmt_ver_no.value=agmtVerNo;
	       	 }
        }
   }
    /**
     *  ROW deleting 
     */
    function rowDelete(sheetObj){
    	for(i=sheetObj.RowCount(); i > 0; i--){
    		if(sheetObj.GetCellValue(i, "ibflag") != ""   &&  sheetObj.GetCellValue(i, "del_chk") == "1") {
    			sheetObj.RowDelete(i, false);
    		}
    	}
    }
     function sheet1_OnPopupClick(sheetObj, row, col){
     	switch (sheetObj.ColSaveName(col)) {
     	case "mft_dt" :
     		if (sheetObj.ColSaveName(col) != "mft_dt"){
     			return;
     		}
     		var cal=new ComCalendarGrid("myCal");
     		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
     		break;
//     	case "chss_rgst_exp_dt" :
//     		if (sheetObj.ColSaveName(col) != "chss_rgst_exp_dt"){
//     			return;
//     		}
//     		var cal = new ComCalendarGrid("myCal");
//     		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
//     		break;
     	}
     }
      /**
       * SHEET1 ONCHANGE EVENT
       */
      function sheet1_OnChange(sheetObj, Row, Col, Value) {
      	var formObj=document.form;
      	var sheetObj=sheetObjects[0];
      	var targetCol=sheetObj.SaveNameCol("eq_no");
      	var eqNo=sheetObj.GetCellValue(Row, "eq_no");
      	with(sheetObj){
      		var colName=ColSaveName(Col);
      		switch(colName){
      		case "eq_no":
      	     	formObj.f_cmd.value=SEARCH;
      			formObj.eq_no.value=eqNo;
      			if(Row >1){
      				// chassis no check
      				for(i=1; i<sheetObj.RowCount(); i++){
      					if(sheetObj.GetCellValue(i, "eq_no")== Value && Row != i && sheetObj.GetCellValue(i, "eq_no")!='')
       					{
      						// check message out
      			        	//ComShowMessage('CGM20007');      			        
      						ComShowCodeMessage("CGM20004",sheetObj.GetCellValue(i, "eq_no") );
      			        	// Setting Cell value to Null
      						sheetObj.SetCellValue(Row, "eq_no","");
      			        	return false;
       					}
      				}
      			} 
      			if(formObj.eq_no.value !=""){
      				var sXml=sheetObj.GetSearchData("EES_CGM_2007GS.do", FormQueryString(formObj));
      		 		//ComShowMessage("####### "+sXml);
      		 		// data count
      		 		var dataCount=ComGetTotalRows(sXml);
      		 		
      		 		if(dataCount > 0){
      		 			
      					var lstmCd=DomXml2String(sXml,"agmt_lstm_cd");
      					if(formObj.ownleas[1].checked == true){
      						if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
      				       		 ComShowCodeMessage("CGM10068",formObj.eq_no.value);
      				       		 sheetObj.SetCellValue(Row, "eq_no", "", 0);
      				           	 return false;
      				       	 }
      						sheetObj.SetCellValue(Row,"cre_usr_id",DomXml2String(sXml,"cre_usr_id"),0);
      					} else {
      						sheetObj.SetCellValue(Row,"cre_usr_id","",0);
      						if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
      				       		 ComShowCodeMessage("CGM10067",formObj.eq_no.value);
      				       		 sheetObj.SetCellValue(Row, "eq_no", "", 0);
      				           	 return false;
      				       	} 
      					}
      					sheetObj.SetCellValue(Row,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
      					sheetObj.SetCellValue(Row,"mft_dt",DomXml2String(sXml,"mft_dt"),0);
      					sheetObj.SetCellValue(Row,"eq_spec_no",DomXml2String(sXml,"eq_spec_no"),0);
      					sheetObj.SetCellValue(Row,"mgst_mchn_ser_no",DomXml2String(sXml,"mgst_mchn_ser_no"),0);
      					sheetObj.SetCellValue(Row,"mgst_vltg_capa",DomXml2String(sXml,"mgst_vltg_capa"),0);
      					sheetObj.SetCellValue(Row,"mgst_fuel_capa",DomXml2String(sXml,"mgst_fuel_capa"),0);
      					sheetObj.SetCellValue(Row,"cre_usr_id",DomXml2String(sXml,"cre_usr_id"),0);
      					sheetObj.SetCellValue(Row,"agreement_no",DomXml2String(sXml,"agreement_no"),0);
      					sheetObj.SetCellValue(Row,"agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
      					sheetObj.SetCellValue(Row,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
      					sheetObj.SetCellValue(Row,"agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
      					sheetObj.SetCellEditable(Row, "eq_tpsz_cd",1);
  						sheetObj.SetCellEditable(Row,"eq_spec_no",1);
  						sheetObj.SetCellEditable(Row,"mgst_mchn_ser_no",1);
  						sheetObj.SetCellEditable(Row,"mgst_vltg_capa",1);
  						sheetObj.SetCellEditable(Row,"mgst_fuel_capa",1);
      				} else {
      					
      					sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
      					sheetObj.SetCellValue(Row,"mft_dt","",0);
      					sheetObj.SetCellValue(Row,"eq_spec_no","",0);
      					sheetObj.SetCellValue(Row,"mgst_mchn_ser_no","",0);
      					sheetObj.SetCellValue(Row,"mgst_vltg_capa","",0);
      					sheetObj.SetCellValue(Row,"mgst_fuel_capa","",0);
      					sheetObj.SetCellValue(Row,"agreement_no","",0);
      					sheetObj.SetCellValue(Row,"agmt_ver_no","",0);
      					sheetObj.SetCellValue(Row,"vndr_seq","",0);
      					sheetObj.SetCellValue(Row,"cre_usr_id",formObj.cre_id.value,0);
      					if(formObj.ownleas[0].checked == true){
      						ComShowCodeMessage("CGM20003");
      			        	// Setting Cell value to Null
      						sheetObj.SetCellValue(Row, "eq_no","");
      						return false;
      					} else {
      						sheetObj.SetCellEditable(Row, "eq_tpsz_cd",1);
      						sheetObj.SetCellEditable(Row,"eq_spec_no",1);
      						sheetObj.SetCellEditable(Row,"mgst_mchn_ser_no",1);
      						sheetObj.SetCellEditable(Row,"mgst_vltg_capa",1);
      						sheetObj.SetCellEditable(Row,"mgst_fuel_capa",1);
      						sheetObj.SetCellValue(Row,"eq_tpsz_cd","UMG",0);
      					}
      				}
      			} else {
    				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
  					sheetObj.SetCellValue(Row,"mft_dt","",0);
  					sheetObj.SetCellValue(Row,"eq_spec_no","",0);
  					sheetObj.SetCellValue(Row,"mgst_mchn_ser_no","",0);
  					sheetObj.SetCellValue(Row,"mgst_vltg_capa","",0);
  					sheetObj.SetCellValue(Row,"mgst_fuel_capa","",0);
  					sheetObj.SetCellValue(Row,"agreement_no","",0);
  					sheetObj.SetCellValue(Row,"agmt_ver_no","",0);
  					sheetObj.SetCellValue(Row,"vndr_seq","",0);
  					sheetObj.SetCellValue(Row,"cre_usr_id",formObj.cre_id.value,0);
  					sheetObj.SetCellEditable(Row, "eq_tpsz_cd",0);
					sheetObj.SetCellEditable(Row,"eq_spec_no",0);
					sheetObj.SetCellEditable(Row,"mgst_mchn_ser_no",0);
					sheetObj.SetCellEditable(Row,"mgst_vltg_capa",0);
					sheetObj.SetCellEditable(Row,"mgst_fuel_capa",0);
    			}
      			break;
      		case "eq_spec_no":
      			formObj.f_cmd.value=SEARCH01;
      			formObj.eq_spec_no.value=sheetObj.GetCellValue(Row, "eq_spec_no");
      			if(formObj.eq_spec_no.value !=""){
      				var sXml=sheetObj.GetSearchData("EES_CGM_2007GS.do", FormQueryString(formObj));
      		 		//ComShowMessage("####### "+sXml);
      		 		// data count
      		 		var dataCount=ComGetTotalRows(sXml);
      		 		if(dataCount > 0){
      		 			sheetObj.SetCellValue(Row,"mgst_vltg_capa",DomXml2String(sXml,"mgst_vltg_capa"),0);
      					sheetObj.SetCellValue(Row,"mgst_fuel_capa",DomXml2String(sXml,"mgst_fuel_capa"),0);
      		 		} else {
      		 			sheetObj.SetCellValue(Row,"mgst_vltg_capa","",0);
      					sheetObj.SetCellValue(Row,"mgst_fuel_capa","",0);
      		 		}
      			} else {
      				sheetObj.SetCellValue(Row,"mgst_vltg_capa","",0);
  					sheetObj.SetCellValue(Row,"mgst_fuel_capa","",0);
      			}
      		    break;
      		}
      	}
      }
/**
 * OWN, Leased radio button
 */
function obj_onclick(radioObj){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if(formObj.ownleas[0].checked == true){
		formObj.own_lse.value="O";
	} else {
		formObj.own_lse.value="L";
	}
}
 /**
 * OWN,Leased select -> page reset
 * @param a
 * @return
 */
 function chk(a){
   	var formObj=document.form;
   	 var sheetObj=sheetObjects[0]; 
   	 sheetObj.RemoveAll();
			// HTML OBJECT RESET
   	 formObj.reset();
   	 if(a=="O"){
   		 formObj.ownleas[0].checked=true;
   	 } else {
   		 formObj.ownleas[1].checked=true;
   	 }
     formObj.own_lse.value=a;
   	 yard_Chk();
   }
//retrieve after saving
 function sheet1_OnSaveEnd(sheetObj, errMsg) {
	 if(errMsg =='') {   
		  ComShowCodeMessage('CGM00003');
          for(i=sheetObj.LastRow(); i>0; i--){
        	  if(sheetObj.GetCellValue(i, "del_chk") == "1" ){
				  sheetObj.RowDelete(i, false);
			  } 
		  }
	 }
 }    
/**
* Form Date yard control
* @return
* @author 
* @version4
*/
function yard_Chk(){
	  formObj=document.form;
	  var l_chk ,f_chk;
	  var l_cName,f_cName;
	  if(formObj.ownleas[0].checked == true){
		  l_chk=true;
		  f_chk=false;
		  l_cName="input2";
		  formObj.agreement_no.value="";
	  } else {
		  l_chk=false;
		  f_chk=true;
		  l_cName="input1";
	  }
	  formObj.agreement_no.readOnly=l_chk;
     ComEnableObject(formObj.ComOpenPopupWithTargetAgree, f_chk);
     formObj.agreement_no.className=l_cName;
}
/**
 * yard and office check
 * @param chk
 * @return
 */
function Matched_Chk(chk){
	 formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 if(formObj.onh_yd_cd.value != "" && formObj.onh_ofc_cd.value != "" ){
		    formObj.f_cmd.value=SEARCH01;
		    formObj.ofc_cd.value=formObj.onh_ofc_cd.value;		//   ( location)
		    formObj.loc_cd.value=formObj.onh_yd_cd.value.substr(0,5);
		    var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
		    if(DomXml2String(sXml, "chk")!="OK"){
				ComShowCodeMessage("CGM10028");
				if(chk == 'Yard'){
					formObj.onh_yd_cd.value="";
//					formObj.onh_yd_cd.focus();
				} else {
					formObj.onh_ofc_cd.value="";
//					formObj.onh_ofc_cd.focus();
				}
				return;
		    }
	 }
}
function Verify_Status_chk(){
	 var sheetObj=sheetObjects[0];
	 for(i=1; i<sheetObj.RowCount()+1; i++){
		 sheetObj.SetCellValue(i, "verify","");
	 }
	
}
function sheet1_OnLoadExcel(sheetObj, result, code, msg){
  if(isExceedMaxRow(msg))return;
  
  var formObj=document.form;  
  for(iChk=1; iChk<sheetObj.RowCount()+1; iChk++){
		var cellValue=sheetObj.GetCellValue(iChk, "eq_spec_no"); 
		var eqNo=sheetObj.GetCellValue(iChk, "eq_no");
//		alert(sheetObj.cellValue(iChk, "eq_spec_no"));
		if (cellValue != ''){
			formObj.f_cmd.value=SEARCH01;
			formObj.eq_spec_no.value=sheetObj.GetCellValue(iChk, "eq_spec_no");
	 		//alert(Row);
		    if(formObj.eq_spec_no.value !=""){
		    	var sXml=sheetObj.GetSearchData("EES_CGM_2007GS.do", FormQueryString(formObj));
		 		//ComShowMessage("####### "+sXml);
		 		// data count
		 		var dataCount=ComGetTotalRows(sXml);
		 		if(dataCount > 0){
		 			sheetObj.SetCellValue(iChk,"mgst_vltg_capa",DomXml2String(sXml,"mgst_vltg_capa"),0);
					sheetObj.SetCellValue(iChk,"mgst_fuel_capa",DomXml2String(sXml,"mgst_fuel_capa"),0);
		 		} else {
		 			sheetObj.SetCellValue(iChk,"mgst_vltg_capa","",0);
					sheetObj.SetCellValue(iChk,"mgst_fuel_capa","",0);
		 		}
			} else {
				sheetObj.SetCellValue(iChk,"mgst_vltg_capa","",0);
				sheetObj.SetCellValue(iChk,"mgst_fuel_capa","",0);
			}
		}
		
		formObj.f_cmd.value=SEARCH;
		formObj.eq_no.value=eqNo;
		
		// chassis no check
		for(i=1; i<sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i, "eq_no")== eqNo && iChk != i && sheetObj.GetCellValue(i, "eq_no")!='')
			{
				// check message out
			    // ComShowMessage('CGM20007');
				ComShowCodeMessage("CGM20004",sheetObj.GetCellValue(i, "eq_no") );
			    // Setting Cell value to Null
				sheetObj.SetCellValue(iChk, "eq_no","");
			    continue;
			}
		}
		
		if(formObj.eq_no.value !=""){
			var sXml=sheetObj.GetSearchData("EES_CGM_2007GS.do", FormQueryString(formObj));
		 	// ComShowMessage("####### "+sXml);
		 	// data count
		 	var dataCount=ComGetTotalRows(sXml);
		 		
		 	if(dataCount > 0){
				var lstmCd=DomXml2String(sXml,"agmt_lstm_cd");
				if(formObj.ownleas[1].checked == true){
					if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
				       	ComShowCodeMessage("CGM10068",formObj.eq_no.value);
				       	sheetObj.SetCellValue(iChk, "eq_no", "", 0);
				        continue;
					}
					sheetObj.SetCellValue(iChk,"cre_usr_id",DomXml2String(sXml,"cre_usr_id"),0);
				} else {
					sheetObj.SetCellValue(iChk,"cre_usr_id","",0);
					if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
				       	ComShowCodeMessage("CGM10067",formObj.eq_no.value);
				       	sheetObj.SetCellValue(iChk, "eq_no", "", 0);
				        continue;
				    } 
				}
				
				sheetObj.SetCellValue(iChk,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
				sheetObj.SetCellValue(iChk,"mft_dt",DomXml2String(sXml,"mft_dt"),0);
				sheetObj.SetCellValue(iChk,"eq_spec_no",DomXml2String(sXml,"eq_spec_no"),0);
				sheetObj.SetCellValue(iChk,"mgst_mchn_ser_no",DomXml2String(sXml,"mgst_mchn_ser_no"),0);
				sheetObj.SetCellValue(iChk,"mgst_vltg_capa",DomXml2String(sXml,"mgst_vltg_capa"),0);
				sheetObj.SetCellValue(iChk,"mgst_fuel_capa",DomXml2String(sXml,"mgst_fuel_capa"),0);
				sheetObj.SetCellValue(iChk,"cre_usr_id",DomXml2String(sXml,"cre_usr_id"),0);
				sheetObj.SetCellValue(iChk,"agreement_no",DomXml2String(sXml,"agreement_no"),0);
				sheetObj.SetCellValue(iChk,"agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
				sheetObj.SetCellValue(iChk,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
				sheetObj.SetCellValue(iChk,"agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
				sheetObj.SetCellEditable(iChk, "eq_tpsz_cd",1);
				sheetObj.SetCellEditable(iChk,"eq_spec_no",1);
				sheetObj.SetCellEditable(iChk,"mgst_mchn_ser_no",1);
				sheetObj.SetCellEditable(iChk,"mgst_vltg_capa",1);
				sheetObj.SetCellEditable(iChk,"mgst_fuel_capa",1);
			}else {
				if(formObj.ownleas[0].checked){
					sheetObj.SetCellValue(iChk,"eq_tpsz_cd","",0);
					sheetObj.SetCellValue(iChk,"mft_dt","",0);
					sheetObj.SetCellValue(iChk,"eq_spec_no","",0);
					sheetObj.SetCellValue(iChk,"mgst_mchn_ser_no","",0);
					sheetObj.SetCellValue(iChk,"mgst_vltg_capa","",0);
					sheetObj.SetCellValue(iChk,"mgst_fuel_capa","",0);
					sheetObj.SetCellValue(iChk,"agreement_no","",0);
					sheetObj.SetCellValue(iChk,"agmt_ver_no","",0);
					sheetObj.SetCellValue(iChk,"vndr_seq","",0);
					sheetObj.SetCellValue(iChk,"cre_usr_id",formObj.cre_id.value,0);
					if(formObj.ownleas[0].checked == true){
						ComShowCodeMessage("CGM20003");
			        	// Setting Cell value to Null
						sheetObj.SetCellValue(iChk, "eq_no","");
						continue;
					} else {
						sheetObj.SetCellEditable(iChk, "eq_tpsz_cd",1);
						sheetObj.SetCellEditable(iChk,"eq_spec_no",1);
						sheetObj.SetCellEditable(iChk,"mgst_mchn_ser_no",1);
						sheetObj.SetCellEditable(iChk,"mgst_vltg_capa",1);
						sheetObj.SetCellEditable(iChk,"mgst_fuel_capa",1);
						sheetObj.SetCellValue(iChk,"eq_tpsz_cd","UMG",0);
					}
				}
			}
		}else {
			sheetObj.SetCellValue(iChk,"eq_tpsz_cd","",0);
			sheetObj.SetCellValue(iChk,"mft_dt","",0);
			sheetObj.SetCellValue(iChk,"eq_spec_no","",0);
			sheetObj.SetCellValue(iChk,"mgst_mchn_ser_no","",0);
			sheetObj.SetCellValue(iChk,"mgst_vltg_capa","",0);
			sheetObj.SetCellValue(iChk,"mgst_fuel_capa","",0);
			sheetObj.SetCellValue(iChk,"agreement_no","",0);
			sheetObj.SetCellValue(iChk,"agmt_ver_no","",0);
			sheetObj.SetCellValue(iChk,"vndr_seq","",0);
			sheetObj.SetCellValue(iChk,"cre_usr_id",formObj.cre_id.value,0);
			sheetObj.SetCellEditable(iChk, "eq_tpsz_cd",0);
			sheetObj.SetCellEditable(iChk,"eq_spec_no",0);
			sheetObj.SetCellEditable(iChk,"mgst_mchn_ser_no",0);
			sheetObj.SetCellEditable(iChk,"mgst_vltg_capa",0);
			sheetObj.SetCellEditable(iChk,"mgst_fuel_capa",0);
		}
//		sheet1_OnChange(sheetObj, iChk, 3, sheetObj.GetCellValue(iChk, "eq_no"));
	}
  
}
/* developer jop end */