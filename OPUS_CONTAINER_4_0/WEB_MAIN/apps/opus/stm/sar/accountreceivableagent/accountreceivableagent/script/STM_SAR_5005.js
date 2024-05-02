/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_5005.js
*@FileTitle  : Agent Collection Inquiry
*@author     : CLT
*@version    : 1.0
*@LastModify : 2014/12/15
*@since      : 2014/08/05
=========================================================*/
/**
 * @extends 
 * @class STM_SAR_5005 : business script for STM_SAR_5005
 */
//function STM_SAR_5005() { 
//	this.processButtonClick=processButtonClick;
//	this.setSheetObject=setSheetObject;
//	this.loadPage=loadPage;
//	this.initSheet=initSheet;
//	this.initControl=initControl;
//	this.doActionIBSheet=doActionIBSheet;
//	this.setTabObject=setTabObject;
//	this.validateForm=validateForm;
//}
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
var pre_data=[];
var dpPrcsKnt = 2;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_OK":
				if(sheetObject1.RowCount()== 0){
					ComClosePopup(); 
				}else{
					comPopupOK();
				}
				break;
			case "btn_Close":
				ComClosePopup(); 
    	        break;				
			case "btn_print":
				var dupRow1=sheetObjects[0].ColValueDup(prefix + "chg_tp_cd");
	            // Dup data pre-check before saving
	            if (dupRow1>0) {  
	            	sheetObject1.SetSelectRow(dupRow1);
	            	ComShowCodeMessage('SCO00004', 'Check', 'Duplicated Type');
	                ComSetFocus(sheetObject1.ColValueDupRows(prefix + "chg_tp_cd"));	
	                return false;
	            }
				break;
			case "btn_pop_ofc_cd":
		        ComOpenPopupWithTarget("/opuscntr/STM_SAP_0001.do?ofc_cd="+document.form.ar_ofc_cd.value, 480, 550,"ap_ofc_cd:ar_ofc_cd", "0,0", true);
		        //ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+document.form.ofc_cd.value, 480, 550,"asa_no:ofc_cd", "0,0", true);
		        break;
			case "btn_pop_asa_cd":
				if(agn_ofc_cd.GetSelectText() == ""){
					ComShowCodeMessage("COM12113", "Office Code");
					ComSetFocus(document.all.item("agn_ofc_cd"));
					return false;
				}
				
		        //ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+ document.form.asa_no1.value + "&ofc_cd="+document.form.ar_ofc_cd.value + "&flag_cd=Y", 480, 550,"asa_no1:asa_no1|asa_no2:asa_no2|asa_no3:asa_no3|bil_cre_prd_fm_dt:gl_yrmon_fm|bil_cre_prd_to_dt:gl_yrmon_to|curr_cd:asa_curr_cd", "0,0", true);
		        ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?flag_cd=Y&asa_no="+ document.form.asa_no1.value + "&ofc_cd="+document.form.ar_ofc_cd.value    , 480, 550,"asa_no1:asa_no1|asa_no2:asa_no2|asa_no3:asa_no3|bil_cre_prd_fm_dt:gl_yrmon_fm|bil_cre_prd_to_dt:gl_yrmon_to|curr_cd:asa_curr_cd|dp_prcs_knt:dp_prcs_knt", "0,0", true);
		        formObj.f_cmd.value = SEARCH08;
				formObj.curr_cd.value = formObj.asa_curr_cd.value; 
				var sXml = sheetObject1.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml,"dp_prcs_knt_list");
				var arrStr = sStr.split("|"); 
				
				if(ComIsEmpty(arrStr[1])) dpPrcsKnt = 2;
				else dpPrcsKnt = arrStr[1];
				 
				//자리수 추가
				sheetObjects[0] = sheetObjects[0].Reset(); 
				sheetObject1=sheetObjects[0];  
				ComConfigSheet(sheetObject1);  
				initSheet(sheetObject1, 1, dpPrcsKnt); 
				ComEndConfigSheet(sheetObject1);    
		        
				break;
			case "btn_new":
				formObj.reset();
    	    	sheetObject1.RemoveAll();
    	    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    	        break;
			case "btn_downexcel":
				if(sheetObject1.RowCount() < 1){//no data
           		 	ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel();
				}
    	    	break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1,dpPrcsKnt);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo珥덇린??
	agn_ofc_cd=comboObjects[0];
	comboCnt=comboObjects.length;
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
}

/**
* 肄ㅻ낫 珥덇린?ㅼ젙媛?
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#7896B1";	
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
	comboObj.SetBackColor("#CCFFFD");
}

/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo,dpPrcsKnt) {
	var cnt=0;	
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
       
	        var HeadTitle1="|ASA NO|B/L No|Invoice No|Charge Code|VVD|Port|Due Date |Type|TTL AMT|USD AMT";
	        HeadTitle1=HeadTitle1 + "|EX. Rate1|Equivalence\nLCL|Local CUR|Source AMT|EX. Rate1|Charge AMT|3rd CUR1|3rd AMT1|3rd Rate1|3rd CUR2";
	        HeadTitle1=HeadTitle1 + "|3rd AMT2|3rd Rate2|3rd CUR3|3rd AMT3|3rd Rate3|3rd CUR4|3rd AMT4|3rd Rate4|Equivalence\nLCL2|Remark";
	        HeadTitle1=HeadTitle1 + "|asa_clt_seq|ar_ofc_cd|eff_dt|agn_cd|svc_scp_cd|ib_ob_cd|asa_curr_cd|sail_arr_dt|gl_yrmon|n3rd_locl_amt1";
	        HeadTitle1=HeadTitle1 + "|n3rd_locl_amt2|n3rd_locl_amt3|n3rd_locl_amt4|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	//        (headCount, 0, 0, true);
	        var prefix="sheet1_";
	 
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        if(dpPrcsKnt == 0){ 
	        	var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
		  		               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt1",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt",   KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",       KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"chg_usd_amt",    KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd1",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt1",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt1",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt2",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd3",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt3",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt3",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd4",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt4",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt4",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt2",  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_clt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ar_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_scp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_ob_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_yrmon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt1", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt2", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt3", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt4", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	        } else {
		        	var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
			  		               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt1",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"chg_usd_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd1",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt1",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt1",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt2",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd3",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt3",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt3",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd4",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt4",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt4",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			  		               {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt2",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_clt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ar_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_scp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_ob_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_yrmon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt1", KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt2", KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt3", KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt4", KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	        }
	          
	        		InitColumns(cols);
	
	        		SetEditable(1);
	        		//SetSheetHeight(360);
	        		resizeSheet();
              }
	        sheetObj.SetColProperty(prefix+"due_dt", {Format:"####-##-##"} );
	        sheetObj.SetColProperty(prefix+"eff_dt", {Format:"####-##-##"} );
	        sheetObj.SetColProperty(prefix+"sail_arr_dt", {Format:"####-##-##"} );

	        break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

// handling sheet process Sheet愿???
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	var form=document.form;
	var sheetObject1=sheetObjects[0];
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {	
		case IBSEARCH_ASYNC01: 
			//loadPageflg = "Y";
			formObj.f_cmd.value=SEARCH03;	
			var param="f_cmd=" + SEARCH03 + "&ofc_lvl_tp=ENTRY&ofc_brnc_agn_tp_cd=AGT";
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", param);
			var strOtsOfcCd=ComGetEtcData(sXml,"ots_ofc_cd");	
			if (!ComIsNull(strOtsOfcCd)) {
				var ofcList=strOtsOfcCd.split("|");
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd^agnCurrCd^agnPfxCd^agnOtsLmtAmt
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11        ^12       ^13      ^14
				// -------------------------------------------------------------------------------------------------------------------
				agn_ofc_cd.RemoveAll();
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");
					agn_ofc_cd.InsertItem(i-1, ofcInfo[0], ofcList[i]);	
				}	
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");
					if(ofcInfo[0] == ofcInfo[1]){
						agn_ofc_cd.SetSelectText(ofcInfo[1]); 
						formObj.ar_ofc_cd.value=ofcInfo[1]; 
						formObj.asa_no1.value=ofcInfo[13];
					}
				}	
			}
			ComOpenWait(false);  
			break;
		case IBSEARCH: //retrieve
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);	
		    setTimeout( function () {
				formObj.f_cmd.value=SEARCH;
	 			sheetObj.DoSearch("STM_SAR_5005GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),{Sync:2} );
				ComOpenWait(false);
		    } , 100);
			break;
	}
}

/**
 * handling process for input validation 
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			if(agn_ofc_cd.GetSelectText() == ""){
				ComShowCodeMessage("COM12113", "Office Code");
				ComSetFocus(document.all.item("agn_ofc_cd"));
				return false;
			}
			if(formObj.asa_no1.value == ""||ComIsNull(formObj.asa_no1.value)){
				ComShowCodeMessage("COM12113", "ASA NO1");
				ComSetFocus(document.all.item("asa_no1"));
				return false;
			}
			if(formObj.asa_no2.value == ""||ComIsNull(formObj.asa_no2.value)){
				ComShowCodeMessage("COM12113", "ASA NO2");
				ComSetFocus(document.all.item("asa_no2"));
				return false;
			}
			if(formObj.asa_no3.value == ""||ComIsNull(formObj.asa_no3.value)){
				ComShowCodeMessage("COM12113", "ASA NO3");
				ComSetFocus(document.all.item("asa_no3"));
				return false;
			}
			if(formObj.gl_yrmon_to.value == ""||ComIsNull(formObj.gl_yrmon_to.value)){
				ComShowCodeMessage("COM12113", "GL Month");
				ComSetFocus(document.all.item("gl_yrmon_to"));
				return false;
			}
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		}
}

/**
 * function called when combo box rct_ofc_cd change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Park sung yong
 * @version 2014.03.26
 */	
function agn_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
//	var arrStr=newCode.split("^");
	//if(loadPageflg == "Y") return;
	  if (newText != null) {
          formObj.ar_ofc_cd.value = comboObj.GetText(newCode, 0);
      } else {
          formObj.ar_ofc_cd.value="";
      }
		
	var formObj = document.form;
    if (formObj.agn_ofc_cd.value != '' && formObj.agn_ofc_cd.value != '') {
    	//formObj.reset();
		formObj.asa_no1.value = "";
		formObj.asa_no2.value = "";
		formObj.asa_no3.value = "";
			
		formObj.gl_yrmon_fm.value ="";
		formObj.gl_yrmon_to.value ="";
		//formObj.due_dt_fm.value ="";
		//formObj.due_dt_to.value ="";
		
		formObj.asa_curr_cd.value = "";
			
		sheetObjects[0].RemoveAll();
	}
  }
//	sheetObjects[0].RemoveAll();
//	formObj.ar_ofc_cd.value=arrStr[0];
//}