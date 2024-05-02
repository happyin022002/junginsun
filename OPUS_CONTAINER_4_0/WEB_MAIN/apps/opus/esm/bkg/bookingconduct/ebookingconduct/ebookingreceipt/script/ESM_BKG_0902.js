/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0902.js
*@FileTitle  : e-Booking & S/I Reject
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var iterator="|$$|";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
			case IBCLEAR:
				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
			break;
			case "btn_OK":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			break;
			case "bt_Close":
			  ComClosePopup(); 
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
        for(i=0; i < sheetObjects.length; i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        initControl(); 		
    }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
           case 1:
               with(sheetObj){
				    var HeadTitle1="|cntr_prt_flg|cntr_wgt|cntr_cfm_flg|pagerows|ibflag|po_no|cntr_no|cntr_tpsz_cd|wgt_ut_cd|meas_qty|pck_qty|cntr_seal_no|pck_tp_cd|meas_ut_cd|";
				    var headCount=ComCountHeadTitle(HeadTitle1);
				
				    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				    InitHeaders(headers, info);
				
				    var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_prt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cfm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pagerows",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"po_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				    InitColumns(cols);
				    SetEditable(1);
				    SetVisible(false);
                 }
			break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
		case IBCLEAR:      //retrieve
		  //var opener=window.dialogArguments;
	        if (!opener) opener=parent;
			if (opener.name == "") { // In case of openning in ESM_BKG_0228
				var openerFormObj=opener.document.form;
			}
			else { // In case of openning in ESM_BKG_0229
				var openerFormObj=opener.frames["t1frame"].document.form;
			}

			replaceReasonText("{?rqst_no}", formObj.rqst_no.value);
			replaceReasonText("{?bkg_no}" , formObj.bkg_no.value);
			replaceReasonText("{?v1}"     , openerFormObj.vvd2.value);
			replaceReasonText("{?v2}"     , openerFormObj.vsl_nm2.value);
			replaceReasonText("{?por1}"   , openerFormObj.bkg_por_cd2.value);
			replaceReasonText("{?por2}"   , openerFormObj.por_nm2.value);
			replaceReasonText("{?pol1}"   , openerFormObj.bkg_pol_cd2.value);
			replaceReasonText("{?pol2}"   , openerFormObj.pol_nm2.value);
			replaceReasonText("{?pod1}"   , openerFormObj.bkg_pod_cd2.value);
			replaceReasonText("{?pod2}"   , openerFormObj.pod_nm2.value);
			replaceReasonText("{?del1}"   , openerFormObj.bkg_del_cd2.value);
			replaceReasonText("{?del2}"   , openerFormObj.del_nm2.value);
			break;
		case IBSEARCH_ASYNC01:
			if ( formObj.reject_reason_cd.value == '' || formObj.reject_reason_cd.value == null ) {
				ComShowCodeMessage('BKG00625');
				formObj.reject_reason_cd.focus();
				return;
			}
			formObj.f_cmd.value=MODIFY;
 			var sXml=sheetObj.GetSaveData("ESM_BKG_0902GS.do", FormQueryString(formObj));
			if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key) == "S"){
					ComShowCodeMessage('BKG00166');
					ComClosePopup(); 
			}else if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key) == "F"){
				ComShowCodeMessage("BKG00098");
			}
			break;
        }
    }
    function initControl() {
    	var formObject=document.form;
//    	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- in case of keyboard input
    }
	function obj_keypress(){
	    switch(ComGetEvent().dataformat){
	    	case "int":
	            //num
	            ComKeyOnlyNumber(ComGetEvent());
	            break;
	        case "float":
	            //num+"."
	            ComKeyOnlyNumber(ComGetEvent(), ".");
	            break;
        	case "saupja":
	            //num + "+-."
	            ComKeyOnlyNumber(ComGetEvent(), "+-.");
	            break;
	        case "eng":
	            //Eng+num -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //lower Eng+num -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //enter just number
	            ComKeyOnlyNumber(ComGetEvent());
	            break;
	    }
	}
	function changeReason(){
   	var formObj=document.form;
   	var obj=formObj.reject_reason_cd;
		var msg=formObj.reject_reason.value;
		var idx1=formObj.reject_reason.value.indexOf("Rejection Reason : ");
		var idx2=0;
		for (var i=idx1;i<msg.length;i++) {
			var ch=msg.charAt(i);
			if (ch == "\n") {
				idx2=i;
				break;
			}
		}
		var msg2=formObj.reject_reason.value.substring(idx1, idx2);
		msg=ComReplaceStr(msg, msg2, "Rejection Reason : "+obj.options[obj.selectedIndex].text);
		formObj.reject_reason.value=msg;
	}
	function replaceReasonText(dst, rep){
   	var formObj=document.form;
		var msg=formObj.reject_reason.value;
   			msg=ComReplaceStr(msg, dst, rep);
		formObj.reject_reason.value=msg;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
        return true;
    }
