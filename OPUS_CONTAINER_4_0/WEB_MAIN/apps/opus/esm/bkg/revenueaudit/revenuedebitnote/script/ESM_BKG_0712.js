/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0712.js
*@FileTitle  : RDN Receipt by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//search xml
var searchXml;
//event status
var eventStatus="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
  * Event handler processing by button name <br>
  * @return 
  */
function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	 /*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
	    switch(srcName) {
			case "btn_Retrieve":
				//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
					
				if(comboObjects[0].GetItemCount() == 0 ||  formObject.rdn_no.value == null || getRdnNoTxt() != formObject.rdn_no  ) {
					setRdnCd();
				} else {
					//removeSearch(formObject);	
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);				
				}
				break;
			case "btn_New":
				removeAll(document.form);
				break;
			case "btn_Save":
				if(ComGetBtnDisable("btn_Save")){
					return false;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_Accept":
				if(ComGetBtnDisable("btn_Accept")){
					return false;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
				break;
			case "btn_ReviseRequest":
				if(ComGetBtnDisable("btn_ReviseRequest")){
					return false;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
				break;
			case "btn_CancelRequest":
				if(ComGetBtnDisable("btn_CancelRequest")){
					return false;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
				break;
			case "btn_Print":
				if(ComGetBtnDisable("btn_Print")){
					return false;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
				break;
	    } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 * @param  sheet_obj
 * @return 
 */ 
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBMulti Combo Object as array <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 * @param combo_obj
 * @return 
 */ 
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen.. <br>
 * @return 
 */
function loadPage() {
	for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
	 for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);    		
//	axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);     		
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	//axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	        			
	//doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	setSumTxt(sheetObjects[1]);
	resetButton();
//	comboObjects[0].focus();
	if(document.form.rdn_no_pop.value != "") {
		var rdn_no=document.form.rdn_no_pop.value.toUpperCase();
		var code=comboObjects[0].FindItem(rdn_no, 0);
		if(code == "-1") {	
			eventStatus="INIT";
			comboObjects[0].InsertItem(0,rdn_no);
			comboObjects[0].SetSelectText(rdn_no);
			eventStatus="";
		}	
		setRdnCd();
	}
	//form.bl_no.value = "AARE01025401";
	//setRdnCd();
}
 /** 
 * handler event keypress of Object <br>
 * checking validation about input data according to dataformat <br>
 * @param    
 * @return 
 */ 
 function obj_keypress(){

 	if(event.srcElement.dataformat == null) return;

 	switch(event.srcElement.dataformat){
	  	case "ymd": 
	 		ComKeyOnlyNumber(event.srcElement,"-"); 
	 		break;
	  	case "int":
	  	case "number": 	
	  		ComKeyOnlyNumber(event.srcElement);
	  		break;
	  	case "engup":
	  		ComKeyOnlyAlphabet('upper');
	  		break;
	  	case "uppernum":
	  		ComKeyOnlyAlphabet('uppernum');
	  		break;
	  	default:
	  		//ComKeyOnlyNumber(obj);
	  		break;
 	}
  	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	switch(event.srcElement.name){
	  	case "bl_no":
		 	if(ComIsEmpty(event.srcElement.value)) { 
		 		return;
	 		}
		  	if(keyValue == 13 && event.srcElement.value.length == 12){
		 		var btnObj=document.getElementById("btn_retrieve");
		 		if (btnObj) { 
		 			btnObj.fireEvent("onclick"); 
	 			}
		  	}
 		break;
 	}	 
 }         
 /** 
 * handler event Onbeforedeactivate of Object<br>
 * checking validation about input data according to dataformat <br>
 * @param    
 * @return 
 */ 
 function obj_deactivate() {
 	var form=document.form;
 	var formObj=ComGetEvent();
     var srcName=formObj.ComGetEvent("name");
     switch(srcName) {
 		case "bl_no":
 		//case "bkg_corr_no":
         	if(ComIsEmpty(formObj.value)) return;
         	var msg=formObj.caption;
 			if(formObj.value.length != formObj.maxLength) {
 				ComShowCodeMessage("BKG95018", msg, formObj.maxLength);
 				ComSetFocus(formObj);
 				return false;
 			} 
 			break;
 		default :
 			ComChkObjValid(formObj);
 			break;
 	}
 }
/**
 * setting first data after retrieve combo as bl_no <br>
 * @return 
 */
function setRdnCd() {
	var formObject=document.form;
	
	if (validateForm(sheetObjects[0],formObject,IBSEARCH)) {
		//alert("setRdnCd : " + formObject.rdn_no.value)
		//setting rdn combo data at hidden
		//formObject.rdn_no.value = comboObjects[0].Code;		
			
    	formObject.f_cmd.value=SEARCH01;
    	searchXml=sheetObjects[0].GetSearchData("ESM_BKG_0426GS.do", FormQueryString(formObject));
 		//reset screen
		removeSearch(formObject);
 		ComXml2ComboItem(searchXml, rdn_no_cd, "rdn_no", "rdn_no");
 		
 		if(comboObjects[0].GetItemCount () > 0) { 			
 			comboObjects[0].SetSelectIndex("0"); 
 			
 		} else {
 			ComShowCodeMessage("BKG95010");
 		}
 		
 		
//		 		formObject.rdn_no.value = code;
// 				
//   		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}	
/**
 * setting returned xml at screen after retrieve as RDN No<br>
 * @param  searchXml
 * @param formObj
 * @return 
 */
function setSearchData(searchXml, formObj) {
		
	var arrData=ComBkgXml2Array(searchXml,  "rdn_no|rvis_seq|iss_ofc_cd|rdn_sts_cd|rdn_iss_dt|sts_upd_dt" +
					"|rct_rhq_cd|rct_ofc_cd|respb_ofc_cd|umch_tp_cd|umch_sub_tp_cd" +
					"|rdn_iss_rsn_cd|sc_rfa_no|umch_rmk|rdn_rmk|rdn_sts_nm" + 
					"|bkg_no|bkg_no_split|bkg_corr_no|prog_seq|bl_no|respb_rhq_cd|rev_aud_tool_cd|ctrt_tp_cd");	
	
	
	if (arrData != null && arrData.length > 0) {
		var Data="";
		for(var i=0;i<arrData.length;i++)
		{
			if(arrData[i]!= undefined)
				{
					Data=arrData[i];
					break;
				}
		}
		formObj.rdn_no.value=Data[0];
		formObj.rvis_seq.value=Data[1];
		formObj.iss_ofc_cd.value=Data[2];
		formObj.rdn_sts_cd.value=Data[3];
		formObj.rdn_iss_dt.value=Data[4];
		formObj.sts_upd_dt.value=Data[5];
		//조직도 		
		formObj.rct_rhq_cd.value=Data[6];
		formObj.rct_ofc_cd.value=Data[7];
		formObj.respb_ofc_cd.value=Data[8];
		//unmatch combo1
		formObj.umch_tp_cd.value=Data[9];
		formObj.umch_sub_tp_cd.value=Data[10];
		formObj.rdn_iss_rsn_cd.value=Data[11];
		formObj.sc_rfa_no.value=Data[12];
		formObj.umch_rmk.value=Data[13];
		formObj.rdn_rmk.value=Data[14];
		formObj.rdn_sts_nm.value=Data[15];
		//BOOKING
		formObj.bkg_no.value=Data[16];
		formObj.bkg_no_split.value=Data[17];
		formObj.bkg_corr_no.value=Data[18];
		//prog_seq
		formObj.prog_seq.value=Data[19];
		//bl_no
		formObj.bl_no.value=Data[20];
		//respb_rhq_cd
		formObj.respb_rhq_cd.value=Data[21];
		//rev_aud_tool_cd
		formObj.rev_aud_tool_cd.value=Data[22];
		formObj.ctrt_tp_cd.value=Data[23]
	}
	return arrData;
}
/**
 * loading IBSHEET COMBO<br>
 * @return 
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
    case "rdn_no_cd":
        var i=0;
        comboObj.SetDropHeight(200);
        comboObj.SetUseAutoComplete(1);
        comboObj.SetUseEdit(true);
        comboObj.SetMaxLength(9);// 9자리만 입력
        break;
    }
}
/**
 * return code data of comboObjects[0]<br>
 * @return comboObjects[0].Code
 */ 
function getRdnNoCd() {
	return comboObjects[0].GetSelectCode();
}
/**
 * return text data of comboObjects[0]<br>
 * @return comboObjects[0].Text <br>
 */ 
function getRdnNoTxt() {
	return comboObjects[0].GetSelectText();
}
	/**
	 * activating in case of changing rdn_no combo<br>
	 * @param comboObj
	 * @param  code    
	 * @param  text 
	 * @return    
	 */ 
	function rdn_no_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		if(eventStatus == "INIT") return;
		
		if(NewIdx == -1){
			rdn_no_cd_setting(comboObj, NewTxt, NewCod);
		}else{
			if(comboObjects[0].GetItemCount() > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
				if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
					var formObj=document.form;
					formObj.rdn_no.value=NewCod;
			 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				} 
			}			
		}
	}


	function rdn_no_cd_setting(comboObj, NewIdx, NewTxt, NewCod){
		var formObj=document.form;
	
		if(ComIsEmpty(comboObj.GetSelectText())) return;
		if(comboObj.GetSelectText().length != 9) {
			ComShowCodeMessage("BKG95018","RDN No\'s","9");
			//comboObj.focus();
			return;
		}
		if(NewIdx == -1 && formObj.rdn_no.value == NewTxt){
			return;
		}
		
		//var rdn_no = comboObj.Text.substr(0,3).toUpperCase() + comboObj.Text.substr(3,6)
		var rdn_no=comboObj.GetSelectText().toUpperCase();
	
		var code=comboObj.FindItem(rdn_no, 0);
		if(code == "-1") {	
			comboObj.RemoveAll();
			//combo item insert
			eventStatus="INIT";
			comboObj.InsertItem(0,rdn_no);
			comboObj.SetSelectText(rdn_no);
			//document.form.bl_no.focus();
			eventStatus="";
			
			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
				formObj.rdn_no.value=NewCod;
		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}		
		}
	}

    /**
	 * acting in case of focus out rdn_no combo<br>
	 * @param comboObj 
	 * @return    
	 */
	function rdn_no_cd_OnBlur(comboObj) {
		var formObj=document.form;
		if(ComIsEmpty(comboObj.GetSelectText())) return;
		if(comboObj.GetSelectText().length != 9) {
			ComShowCodeMessage("BKG95018","RDN No\'s","9");
			//comboObj.focus();
			return;
		} 
		//var rdn_no = comboObj.Text.substr(0,3).toUpperCase() + comboObj.Text.substr(3,6)
		var rdn_no=comboObj.GetSelectText().toUpperCase();
	
		var code=comboObj.FindItem(rdn_no, 0);
		if(code == -1 && formObj.rdn_no.value == "") {
			comboObj.RemoveAll();
			//combo item insert
			eventStatus="INIT";
			comboObj.InsertItem(0,rdn_no);
			comboObj.SetSelectText(rdn_no);
			//document.form.bl_no.focus();
			eventStatus="";
		}
   } 
     /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
		case "sheet0":      //hidden 
             with (sheetObj) {
             }
             break; 
		case "sheet1":      //sheet1 init
			with(sheetObj){
				var HeadTitle="|Currency|Amount|USD Amount|rdn_no|rvis_seq";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:155,  Align:"Right",   ColMerge:1,   SaveName:"dr_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"AutoSum",   Hidden:0, Width:155,  Align:"Right",   ColMerge:1,   SaveName:"usd_amount",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rdn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rvis_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				//SetSheetHeight(82);
				//82 is smaller thanMin-value
				SetSheetHeight(120);
				SetEditable(0);
				SetCountPosition(0);
				//SetGetCountPosition()(0);
            }
			break;
	}
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
    case IBSEARCH:      //retrieve
		eventStatus="IBSEARCH";
		if (validateForm(sheetObj,formObj,sAction)) {
		  	
			if ( sheetObj.id == "sheet0") {
			   
			   formObj.f_cmd.value=SEARCH04;			  
			   var sXml=sheetObj.GetSearchData("ESM_BKG_0712GS.do", FormQueryString(formObj));			   
			   var arrData=setSearchData(sXml, formObj);
			  			   
   			   if (arrData != null && arrData.length > 0) {
   					if (formObj.rdn_no.value != "" && formObj.rvis_seq.value != "") {
       					//alert(formObj.rdn_no.value);
       					formObj.f_cmd.value=SEARCH03;
       					sXml=sheetObjects[0].GetSearchData("ESM_BKG_0712GS.do", FormQueryString(formObj));
       					if(typeof ComGetEtcData(sXml, "regional_rmk") != "undefined" && ComGetEtcData(sXml, "regional_rmk") != "") {
       						formObj.rdn_rmk.value=ComGetEtcData(sXml, "regional_rmk"); 
       		 			}
       					if(typeof ComGetEtcData(sXml, "receipt_rmk") != "undefined" && ComGetEtcData(sXml, "receipt_rmk") != "") {
       						formObj.receiver_rmk.value=ComGetEtcData(sXml, "receipt_rmk");
       					}
        	    		ComOpenWait(true);		
       					sheetObjects[1].SetWaitImageVisible(0);
       					formObj.f_cmd.value=SEARCH02;
       					sheetObjects[1].DoSearch("ESM_BKG_0712GS.do", FormQueryString(formObj) );
        	    		ComOpenWait(false);				       					
   					}	
   			   } else {
   				   ComShowCodeMessage("BKG95010");
   			   }
   			   ComBtnEnable("btn_Print");
		   } 
    	}
		eventStatus="";
        break;
	case IBSAVE:        
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		if (!ComBkgProcessYn("save")) return;
		formObj.f_cmd.value=MULTI01;
		var sParam=FormQueryString(formObj);
		var sParamSheet1=sheetObjects[1].GetSaveString();
		if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
			return;
		}
		sParam += "&" + sParamSheet1;
		ComOpenWait(true);		
		var sXml=sheetObj.GetSaveData("ESM_BKG_0712GS.do", sParam);
		sheetObjects[1].LoadSaveData(sXml);
		ComOpenWait(false);		
		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
			ComShowCodeMessage("BKG95033"); // "Saved."
			//setting combo
			//setRdnCd();
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		break;
	case IBSEARCH_ASYNC01:        //Accept
		 if (validateForm(sheetObj,document.form,sAction)) {
			if (ComShowCodeConfirm("BKG95003", "accept the RDN")) {
				ComOpenWait(true);		
				// confirmation CA No 
				formObj.f_cmd.value=SEARCH06;
				var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0712GS.do", FormQueryString(formObj));
				if(ComGetEtcData(sXml, "count_bkg_corr_no") == "0") {
					ComShowCodeMessage("BKG95042");
					//formObj.bkg_corr_no.focus();
		    		ComOpenWait(false);		
	   				return false;
				}
				// Accept
				formObj.f_cmd.value=MULTI02;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0712GS.do", sParam);
	    		ComOpenWait(false);		
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage("BKG95041"); // msgs['BKG95041']="Accepted."
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}	
		 }	
		 break;		
	case IBSEARCH_ASYNC02:        //Rivise Request
		 if (validateForm(sheetObj,document.form,sAction)) {
			if (ComShowCodeConfirm("BKG95003", "request the revise of the RDN")) {
				formObj.f_cmd.value=MULTI03;
				var sParam=FormQueryString(formObj);
				ComOpenWait(true);		
				var sXml=sheetObj.GetSaveData("ESM_BKG_0712GS.do", sParam);
				ComOpenWait(false);		   						
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage("BKG95040"); // "Requested."
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}	
		 }	
		 break;	
	case IBSEARCH_ASYNC03:        //Cancel Request
		 if (validateForm(sheetObj,document.form,sAction)) {
			if (ComShowCodeConfirm("BKG95003", "request the cancel of the RDN")) {
				formObj.f_cmd.value=MULTI04;
				var sParam=FormQueryString(formObj);
				ComOpenWait(true);		
				var sXml=sheetObj.GetSaveData("ESM_BKG_0712GS.do", sParam);
				ComOpenWait(false);		
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage("BKG95040"); // "Requested."
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}	
		 }	
		 break;
	case IBSEARCH_ASYNC04:
		var popParams="progId=ESM_BKG_0712";
		comRASCallPop("ESM_BKG_5001", "ESM_BKG_0712", popParams, "");
		break;
    }
}
/**
 * handling process for input validation <br>
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj,formObj,sAction){
  switch (sAction) {
	case IBSEARCH: // retrieve		
		
 		if (ComIsEmpty(getRdnNoTxt()) && ComIsEmpty(formObj.bl_no.value)) {
//			ComBkgInputValueFailed("input","RDN No or BL No",rdn_no_cd);
			ComBkgInputValueFailed("input","RDN No or BL No", document.getElementById(comboObjects[0].options.id));
			return false;
 		}
   	 	if (!ComIsEmpty(getRdnNoTxt()) && getRdnNoTxt().length != 9) {
   	 		ComShowCodeMessage("BKG95018","RDN No\'s","9");
   	 		//comboObjects[0].focus();
			return false;
		} 
   	 	if (!ComIsEmpty(formObj.bl_no.value) && formObj.bl_no.value.length != 12 && formObj.bl_no.value.length != 10) {
   	 		ComShowCodeMessage("BKG95018","BL No\'s","10 or 12");
 			//formObj.bl_no.focus();
			return false;
		}
   	 	if (!ComIsEmpty(getRdnNoTxt()) && !ComIsEmpty(formObj.bl_no.value)) {
   	 		formObj.bl_no.value="";
	 	}
		//setting data of rdn combo
		formObj.rdn_no.value=getRdnNoTxt();
		//alert(formObj.rdn_no.value);
 		//formatRdnNo(formObj.rdn_no);
				
		return true;
		break;
	case IBSAVE: 
		var rdn_sts_cd=formObj.rdn_sts_cd.value;
		if(rdn_sts_cd == "AC" || rdn_sts_cd == "CR" || rdn_sts_cd == "RR") {
 			if (ComIsEmpty(formObj.bl_no.value)) {
				ComBkgInputValueFailed("input","BL No",bl_no);
				return false;
 			}
   	 		if (ComIsEmpty(formObj.bkg_no.value)) {
   	 		    ComShowCodeMessage("BKG95009","BL No");
   	 			//formObj.bl_no.focus();
				return false;
 			}
	   	 	if (formObj.bl_no.value.length != 12) {
	   	 		ComShowCodeMessage("BKG95018","BL No\'s","12");
   	 			//formObj.bl_no.focus();
				return false;
 			}
 			if (ComIsEmpty(formObj.receiver_rmk.value)) {
 				ComBkgInputValueFailed("input","Remark",receiver_rmk);
 				return false;
 			}
 			//formatRdnNo(formObj.rdn_no);
  		} else {
  			return false;
  		}	
		return true;
		break;
	case IBSEARCH_ASYNC01: // ACCEPT
		var rdn_sts_cd=formObj.rdn_sts_cd.value;
		if(rdn_sts_cd == "IS" || rdn_sts_cd == "RV"){
			if (ComIsEmpty(formObj.bkg_corr_no.value)) {
			    ComShowCodeMessage("BKG95025", "C/A No"); // ['BKG95025']="Please input {?msg1}." 					
   	 			//formObj.bkg_corr_no.focus();
				return false;
 			}
			/*
			if (formObj.bkg_corr_no.value.length != 10) {
				ComShowCodeMessage("BKG95018","CA No\'s","10");
   	 			formObj.bkg_corr_no.focus();
				return false;
 			}
 			*/
			if (ComIsEmpty(formObj.receiver_rmk.value)) {
 				ComBkgInputValueFailed("input","Remark",receiver_rmk);
 				return false;
 			}
			return true;
		} else {
			return false;
		}	
		return true;
		break;	
	case IBSEARCH_ASYNC02: // RIVISE REQUEST
	case IBSEARCH_ASYNC03: // CANCEL REQUEST
		var rdn_sts_cd=formObj.rdn_sts_cd.value;
		if(rdn_sts_cd == "IS" || rdn_sts_cd == "RV"){
			//formatRdnNo(formObj.rdn_no);
			if (ComIsEmpty(formObj.receiver_rmk.value)) {
 				ComShowCodeMessage("BKG95025", "Remarks"); // "Please input {?msg2}."
 				//formObj.receiver_rmk.focus();
 				return false;
 			}
			return true;
		} else {
			return false;
		}
		return true;
		break;	
	}
    return true;
}
/**
 * activating and deactivating according to button condition<br>
 * @param  mode    
 * @return 
 */
function toggleButtons(mode) {
	 switch (mode) {
		case "":		//new
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_ReviseRequest");
			ComBtnDisable("btn_CancelRequest");
			ComBtnDisable("btn_Print");
			break;
		case "IS":		//ISSUE
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_Accept");
			ComBtnEnable("btn_ReviseRequest");
			ComBtnEnable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		case "RV":		//REVISE
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_Accept");
			ComBtnEnable("btn_ReviseRequest");
			ComBtnEnable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		case "CL":		//CANCEL
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_ReviseRequest");
			ComBtnDisable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		case "ST":		//SETTLE
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_ReviseRequest");
			ComBtnDisable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		case "AC":		//Accepted
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_ReviseRequest");
			ComBtnDisable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		case "CR":		//Cancel Requested
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_ReviseRequest");
			ComBtnDisable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		case "RR":		//REVISE Requested
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_ReviseRequest");
			ComBtnDisable("btn_CancelRequest");
			ComBtnEnable("btn_Print");
			break;
		}			 		 
 }
/**
 * activating and deactivating according to condition code after retrieve<br>
 * @return 
 */
function resetButton() {
	var formObj=document.form;
	var rdn_sts_cd=formObj.rdn_sts_cd.value;
	toggleButtons(rdn_sts_cd);
}
/**
 * calling data at sheet1 after retrieve event<br>
 * reset button after calculating sub sum
 * @param sheetObj  
 * @param  ErrMsg  
 * @return 
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	setSumTxt(sheetObj);
	resetButton();
}
/**
 * calling data at sheet1 after retrieve event<br>
 * setting total sum and words at last row
 * @param  sheetObj  
 * @return 
 */
function setSumTxt(sheetObj) {
	with(sheetObj)
	{
		//SumText(0, "curr_cd") = "";
		SetSumText(0, "curr_cd","USD Total");
		//alert(SumText(0, "curr_cd"));
		//CellAlign(LastRow, "dr_amt") = daRight;
		//CellAlign(LastRow, "usd_amount") = daRight;
		//setting retrieved curr_cd as readonly
		for (var i=1; i<=SearchRows(); i++) {
			SetCellEditable(i, "curr_cd",0);
	    }
	}		
}
/**
 * reset all screen<br>
 * @param formObj    
 * @return 
 */
function removeAll(formObj) {
	formObj.reset();
	comboObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	setSumTxt(sheetObjects[1]);
	resetButton();
	comboObjects[0].Focus();
}
/**
 * reset except BLNO and RDN NO<br>
 * @param  formObj    
 * @return 
 */
function removeSearch(formObj) {
	//var rdnNo = formObj.rdn_no.value;
	var blNo=formObj.bl_no.value;
	formObj.reset();
	//comboObjects[0].removeAll();
	//sheetObjects[1].RemoveAll();
	setSumTxt(sheetObjects[1]);
	//formObj.rdn_no.value = rdnNo;
	formObj.bl_no.value=blNo;
}
/**
 * setting rdn_no as 9 length combined character and number form<br>
 * @param  obj    
 * @return String
 */
function formatRdnNo(obj) {
	//var obj = eval("document.form."+formObj);
	//alert(obj.value);
	if(ComIsEmpty(obj.value)) 
		return;
	var d=new Date();
	var year="";
	year=d.getYear() + "";
//    		if(ComIsNumber(obj.value)) {
//    			var rdnNo = obj.value+"";
//    			obj.value = "RDN" + year.substr(2,2) + plusZero(minusZero(rdnNo));
//    			//alert(obj.value);
//    		} else {
		//alert(obj.value);
	if(obj.value.length == 9) {
		var rdnNo=obj.value+"";
		obj.value=minusZero(rdnNo.substr(5,4));
	} else {
		return "";
	}
//    		}
}
/**
 * insert number 0 at rdn_no<br>
 * @param  rdnNo    
 * @return String
 */
function plusZero(rdnNo) {
	var zero="";
	for(var i=0; i<(4-rdnNo.length); i++) {
		zero=zero + "0";
	}
	return (zero+rdnNo);
}
/**
 * remove number 0 at rdn_no<br>
 * @param  rdnNo    
 * @return String
 */
function minusZero(rdnNo) {
	var no="";
	var i=0;
	for(i=0; i<rdnNo.length; i++) {
		var num=rdnNo.charAt(i);
		if(containsCharsOnly(num,"123456789"))  break;
	}
	return (no=rdnNo.substring(i));
}
/**
 * return true in case of only character type
 * return true in case of no only character type
 * @param  input    
 * @param  chars  
 * @return boolean
 */
function containsCharsOnly(input,chars) {
    for (var inx=0; inx < input.length; inx++) {
        if (chars.indexOf(input.charAt(inx)) == -1)
            return false;
    }
    return true;
}
/**
 * checking CA NO in case of save ACCEPT<br>
 * @param formObj    
 * @return 
 */
/*
         function searchCano(formObj) {
        	formObj.f_cmd.value=SEARCH06;
//parameter changed[check again]CLT 			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0712GS.do", FormQueryString(formObj));
			if(ComGetEtcData(sXml, "count_bkg_corr_no") == "0") {
				ComShowCodeMessage("BKG95042");
				formObj.bkg_corr_no.focus();
   				return false;
			}
        }
 */	 	