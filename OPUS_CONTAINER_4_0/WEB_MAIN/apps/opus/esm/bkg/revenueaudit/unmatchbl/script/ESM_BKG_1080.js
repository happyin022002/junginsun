﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1080.js
*@FileTitle : Audit by Hanger Installation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/**
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends  
 * @class ESM_BKG_1080 : business script for ESM_BKG_1080
 */
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var comboObjects=new Array();
var comboCnt=0;
var gCurrDate;
var gCurrFromDate;
var gCurrToDate;
var gXml="";
var gBkgRhqCd;
var gCtrtTpCdDefault="S";
/** 
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 * @param  {IBSheet} sheetObj IBSheet Object
 */ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
* @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
*/ 
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/** 
* implementing onLoad event handler in body tag <br>
* adding first-served functions after loading screen. <br> 
*/ 
function loadPage() {
	var form=document.form;	
    sheet1=sheetObjects[0];
    sheetCnt=sheetObjects.length ;
    //initialize IBMultiCombo 
    comboCnt=comboObjects.length;
    for(var k=0;k<comboCnt;k++){
        initCombo(comboObjects[k],k+1);
    }
    //initialize IBSheet
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    sheet1.SetWaitImageVisible(0);
    sheet1.SetCountPosition(0);
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');    	    	
    gBkgRhqCd=form.strRhq_ofc_cd.value;
    //gCurrDate = ComGetNowInfo('ymd', '-');
    //gCurrFromDate = ComGetDateAdd(gCurrDate, "M", -1, "-", true);
    //gCurrToDate = gCurrDate;
	//form.from_dt.value = gCurrFromDate;
	//form.to_dt.value = gCurrToDate;
	initIBComboItem();
    sheet1.SetWaitImageVisible(1);
}
/**
 * setting item in IBMultiCombo. <br>
 * <br><b>Example :</b>
 * <pre>
 *     initIBComboItem();
 * </pre>
 * @return 없음
 * @author 김대호
 * @version 2010.01.19
 */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,        rhqComboValue,       getComboObject(comboObjects, 'bkg_rhq_cd'),  "|", "\t" );
	getComboObject(comboObjects, 'bkg_rhq_cd').SetSelectCode(gBkgRhqCd,false);// 초기화시에는 이벤트 발생 안시킴. 초기화시 office 자동 셋팅함.(java와 맞춰준다.)
	ComBkgTextCode2ComboItem(officeComboValue,     officeComboValue,    getComboObject(comboObjects, 'bkg_ofc_cd'),  "|", "\t" );	
	getComboObject(comboObjects, 'bkg_ofc_cd').SetSelectCode(form.strOfc_cd.value,false);
    ComBkgTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'), "|", "\t" );  
	getComboObject(comboObjects, 'bkg_ctrt_tp_cd').SetSelectCode(gCtrtTpCdDefault,false);
	bdr_flg.InsertItem(0,'','');
	bdr_flg.InsertItem(1,'Yes','Y');
	bdr_flg.InsertItem(2,'No','N');
	ComBkgTextCode2ComboItem(splitFlgComboValue,   splitFlgComboText,   getComboObject(comboObjects, 'split_flg'),   	"|", "\t" );
	ComBkgTextCode2ComboItem(chargeFlgComboValue,  chargeFlgComboText,  getComboObject(comboObjects, 'charge_flg'),  	"|", "\t" );
}
/** 
* initializing sheet <br>
* adding first-served functions after loading screen. <br>
* adding case as numbers of counting sheets. <br> 
* @param {IBSheet} sheetObj
* @param {int} sheetNo  
*/ 
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
		    with(sheet1){
		      var HeadTitle1="Seq.|RHQ|Office|B/L No.|BKG Date|Appl. Date|POL ETD|Scope|T/VVD|Contract No.|BDR\nStatus|Split\nStatus|Charge\nStatus|Bill\nType|RDN\nIssuance|RDN\nStatus|CNTR Info|CNTR Info"
							      + "|Hanger Installation Order|Hanger Installation Order|Hanger Installation Order|Hanger Installation Order|Hanger Installation Order|Hanger Installation Order"
							      + "|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Remarks\n(Office)|Remarks\n(Auditor)|bkg_no|bkg_ctrt_tp_cd|bl_cnt|";
		      var HeadTitle2="Seq.|RHQ|Office|B/L No.|BKG Date|Appl. Date|POL ETD|Scope|T/VVD|Contract No.|BDR\nStatus|Split\nStatus|Charge\nStatus|Bill\nType|RDN\nIssuance|RDN\nStatus|TP/SZ|Qty|TP/SZ|C’HGR|C’HGR|C’HGR|C’HGR|M’HGR|Charge|Cur|Rate|Rated As|Per|Amount|Remarks\n(Office)|Remarks\n(Auditor)|bkg_no|bkg_ctrt_tp_cd|bl_cnt|";
		      var HeadTitle3="Seq.|RHQ|Office|B/L No.|BKG Date|Appl. Date|POL ETD|Scope|T/VVD|Contract No.|BDR\nStatus|Split\nStatus|Charge\nStatus|Bill\nType|RDN\nIssuance|RDN\nStatus|TP/SZ|Qty|TP/SZ|Single|Double|Triple|Total|M’HGR|Charge|Cur|Rate|Rated As|Per|Amount|Remarks\n(Office)|Remarks\n(Auditor)|bkg_no|bkg_ctrt_tp_cd|bl_cnt|";
	
		      SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"},
		                  { Text:HeadTitle3, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"row_cnt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_aply_dt",            KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"split_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"charge_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_bl_tp_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rdn_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rdn_sts_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cntr_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cntr_tpsz_cd2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"crr_hngr_sgl_bar_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"crr_hngr_dbl_bar_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"crr_hngr_tpl_bar_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"crr_hngr_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"mer_hngr_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_ut_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rat_as_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chg_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"umch_rsn_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rgn_grp_avc_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ctrt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_cnt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		       
			      InitColumns(cols);
			      SetEditable(1);
		          SetColHidden("ctrt_cntr_tpsz_cd2",1);
			      SetShowButtonImage(2);
			      SetSheetHeight(390);
		      }
	      	break;
	}
}
/** 
* setting IBMultiCombo initial values and header
* param : comboObj, comboNo
* adding case as numbers of counting combos
* @param {IBMultiCombo} comboObj
* @param {int} comboNo  
*/ 
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
		// RHQ
		case "bkg_rhq_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
				ValidChar(2, 0);
                SetMaxLength(6);
			}
			break;
		// office
		case "bkg_ofc_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
				ValidChar(2, 0); 				
			}
			break;
		// scope
		case "svc_scp_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
				ValidChar(2, 0); 
                SetMaxLength(3);
			}
			break;
		// Contract type
        case "bkg_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
				SetUseAutoComplete(1);
				ValidChar(2, 2); 
            }
            break;      
	}
}      
document.onclick=processButtonClick;
/** 
* Event handler processing by button name <br>
*/ 
function processButtonClick(){
	var form=document.form;
	var rdoDateObj=form.rdoDate;
    try {
	    var srcName=ComGetEvent("name");
	    switch(srcName) {
	        case "btns_calendar1": 
	        	var cal=new ComCalendar();
	        	cal.select(form.from_dt, 'yyyy-MM-dd');
	        	break;
	        case "btns_calendar2":
		        var cal=new ComCalendar();
		        cal.select(form.to_dt, 'yyyy-MM-dd');
		        break;
			case "btn_com_ens_ob2":
				var param="";
	    		//param = param + "lane_cd=" + ComGetObjValue(form.vsl_slan_cd);
				//param = "loc_cd="+ComGetObjValue(form.pol_cd);
	    		//param = param + "&" + "pod_cd="+ComGetObjValue(form.pod_cd);
	    		param=param + "&" + "vvd_cd=" + form.vvd.value;
	    		//param = param + "&" + "etd_cd="+form.etd_cd.value;
	    		ComOpenPopup('/opuscntr/COM_ENS_0B2.do?' + param, 780, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
				break;
	    	case "btn_retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			ComOpenWait(true);
	    			sheet1.SetWaitImageVisible(0);
	    			doActionIBSheet(sheet1, form, IBSEARCH);
	    			ComOpenWait(false);	    			
	    		}
	    		break;
	    	case "btn_new":
	    		//form.reset();
	    		ComResetAll();
	    		setNew();
	    		break;
	    	case "btn_downexcel":
				if(sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
		    		doActionIBSheet(sheet1, form, IBDOWNEXCEL);
				}
	    		break;
	    	case "btn_save":
				doActionIBSheet(sheet1,form,IBSAVE);
				break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
}
//===================================================================================
//Axson Event Handler
//===================================================================================
/** 
* handling Keypress event <br>
*/ 
function obj_keypress(){
	var obj=event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": 
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": 
 	case "number": 	
 		ComKeyOnlyNumber(obj);
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
}
/**
* handling click event
*/
function obj_click(){
	var form=document.form;
	var obj=event.srcElement;
	switch(ComGetEvent("name")){
	 	case "rdo_date":
	 		form.search_date.value=obj.value;
	 		break;	 		
	 	case "bill_type_all":
	 		var tf=false;
	 		if(obj.checked) {
	 			tf=true;
	 		}
	 		setBillTypeCheckBox(tf);
	 		break;
	}
 	//if(obj.dataformat == null) return;
}
/**
 * handling OnClick event <br>
 * @param {ibsheet} sheetObj
 * @param {int} Row 
 * @param {int} Col
 * @param {str} Value 
 */  	           
 function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //open MemoPad in case of desc cell click.(MemoPad editable)
	    var colname=sheetObj.ColSaveName(Col);
 	switch(colname){
	    	case "umch_rsn_rmk":
	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200); 
	    		break;
	    	case "rgn_grp_avc_rmk":
	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200);
	    		break;
 	}    	 
 }
/**
* handling OnBeforeActivate event. <br>
*/      
function obj_activate() {
    ComClearSeparator (event.srcElement);
}
/** 
* handling Onbeforedeactivate event <br>
*/ 
function obj_deactivate() {
	var form=document.form;
	var formObj=event.srcElement;
    var srcName=formObj.getAttribute("name");
    switch(srcName) {
		case "vvd":
			var classNm="input";
			if(formObj.value.length < formObj.maxLength) {
				classNm="input1";
			}
			form.from_dt.className=classNm;
			form.to_dt.className=classNm;
			break;
		case "ctrt_no":
			var ctrtTpCd=form.bkg_ctrt_tp_cd;
			if("" != formObj.value) {
				ctrtTpCd.className="mult_combo1";
				ctrtTpCd.SetBackColor("#CCFFFD");
			}else{
				ctrtTpCd.className="mult_combo";
				ctrtTpCd.SetBackColor("#FFFFFF");
			}
			break;
		default :
			ComChkObjValid(formObj);
	}
}
//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
 * vvd : Vessel SKD & Code Inquiry. <br>
 */ 
function setCallBack0B2(aryPopupData) {
	var form=document.form;
	//form.etd_cd.value = ComGetMaskedValue(aryPopupData[0][5], "ymd");
	//var strValue = aryPopupData[0][7];
	form.vvd.value=aryPopupData[0][7];
	//form.vsl_cd.value = strValue.substr(0,4);
	//form.skd_voy_no.value = strValue.substr(4,4);
	//form.skd_dir_cd_txt.value = strValue.substr(8);
} 
 /** 
  * handler sheet1_OnPopupClick event <br>
  * @param  {IBSheet} sheetObj  
  * @param  {Long} Row
  * @param  {Long} Col
  */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
 	var form=document.form;
 	var colName=sheet1.ColSaveName(Col);
	var sName=sheet1.ColSaveName(Col);
	var scRfaNo=sheet1.GetCellValue(Row, "ctrt_no");
	var ctrtTpCd=sheet1.GetCellValue(Row, "bkg_ctrt_tp_cd");
	var bkgNo=sheet1.GetCellValue(Row, "bkg_no");
	var blNo=sheet1.GetCellValue(Row, "bl_no");
	var rdnNo=sheet1.GetCellValue(Row, "rdn_no");
	var rctRhqCd=sheet1.GetCellValue(Row, "bkg_rhq_cd");
	var rctOfcCd=sheet1.GetCellValue(Row, "bkg_ofc_cd");
 	switch(colName){
		case "bl_no":
			if(null == bkgNo || "" == bkgNo) { return; }
        	var popParams="bkg_no=" + bkgNo + "&openTab=B9";
	    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1080", popParams, "");
			break;
		case "ctrt_no":
        	if(null == scRfaNo || "" == scRfaNo) { return; }
    		var pgmNo="ESM_PRI_0004";
    		var scRfaNoP=scRfaNo.substr(0, 3);
    		var scRfaNoS=scRfaNo.substr(3);
        	var popParams="sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.from_dt.value + "&exp_dt=" + form.to_dt.value;
	    	if(ctrtTpCd == "R") { // RFA
	    		pgmNo="ESM_PRI_2019";
	    		popParams="s_rfa_no=" + scRfaNo;
	    	}
	    	else if(ctrtTpCd == "T") { // TAA
	    		pgmNo="ESM_PRI_3007";
	    		popParams="cond_taa_no=" + scRfaNo;  
	    	}
        	comRASCallPop(pgmNo, "ESM_BKG_1080", popParams, "");
			break;
		case "rdn_no":
			//rdnNo = "RDN090086";
		    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
			var popParams="rdn_no=" + rdnNo + "&bl_no=" + blNo + "&rct_rhq_cd=" + rctRhqCd + "&rct_ofc_cd=" + rctOfcCd;
    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_1080", popParams, "");
			break;
	 	}
 } 	      
/** 
* call in case of RHQ change <br>
* setting Office combo. <br>
* @param  {IBMultiCombo} rhqObj  
* @param  {String} Code 
* @param  {String} Text 
*/ 
function bkg_rhq_cd_OnChange(rhqObj, oldindex, oldtext, oldcode, newindex , Text , Code) {
	var form=document.form;
	var officeObj=bkg_ofc_cd;
		officeObj.RemoveAll();
	if(null == Code || "" == Code) {
		officeObj.InsertItem(0, "", "");
	}else{
		var params="f_cmd=" + COMMAND02 + "&etc2=" + Code;
		var sXml=sheet1.GetSearchData("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, officeObj, "cd", "cd");
		officeObj.InsertItem(0, "", "");
		officeObj.SetSelectCode(form.strOfc_cd.value);
	}
}
/** 
* initialize form <br>
*/ 
function setNew() {
	var form=document.form;
	var rhqObj=bkg_rhq_cd;
	var officeObj=bkg_ofc_cd;
    //var fromDt = form.from_dt;
    //var toDt = form.to_dt;
    var ctrtTpCd=bkg_ctrt_tp_cd;
    officeObj.RemoveAll();
    rhqObj.SetSelectIndex("-1");
   	rhqObj.SetSelectCode(gBkgRhqCd);
    //fromDt.value = gCurrFromDate;
   	//toDt.value = gCurrToDate;
    ctrtTpCd.SetSelectCode(gCtrtTpCdDefault);
    ctrtTpCd.SetBackColor("#FFFFFF");
   	sheet1.RemoveAll();
}
/** 
* Event handler processing by button click event
* @param  {IBSheet} sheetObj  
* @param  {object} formObj
* @param  {sAction} sAction
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheet1.ShowDebugMsg(false);
	switch(sAction) {
        case IBSEARCH: 
        	formObj.f_cmd.value=SEARCH;
        	sheet1.DoSearch("ESM_BKG_1080GS.do", FormQueryString(formObj) );
 			break;
		case IBDOWNEXCEL:      //download excel
			if(sheetObj.RowCount() < 1){
				ComShowCodeMessage("COM132501");
			}else{
				sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
			}
			break;
		case IBSAVE:		
		   if (!ComShowCodeConfirm("BKG95003", "save Remarks")) { return false; }
		   formObj.f_cmd.value=MULTI01;
	       var sParam=FormQueryString(formObj);
	       var sParamSheet1=sheet1.GetSaveString();
	       sParam += "&" + sParamSheet1;
	       ComOpenWait(true);
	       var sXml=sheet1.GetSaveData("ESM_BKG_1080GS.do", sParam);
	       sheet1.LoadSaveData(sXml);
	       ComOpenWait(false);        		
	       if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	    	   ComShowCodeMessage("BKG95033"); // "Saved."
	    	   //doActionIBSheet(sheet1,document.form,IBSEARCH);
	       }
	       break;
	}
}
/** 
* handling process for input validation <br>
*  check validation of Application date <br>
*/ 
function chkDate(formObj) {
	var form=document.form;
	var vvdBool=false;
	var vvd=form.vvd;
	if(vvd.value.length == vvd.maxLength){ vvdBool=true; }
    var fmDtObj=form.from_dt;
    var toDtObj=form.to_dt;
	var fmDtValue=fmDtObj.value.replace(/-/g,'');
	var toDtValue=toDtObj.value.replace(/-/g,'');
	if(fmDtValue != "" && toDtValue != "") {
		if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
			ComShowCodeMessage("BKG95026", "From Date", "To Date");
			event.returnValue=false;			
			ComSetFocus(formObj);
			return false;
		}
		var fromAddDays=ComGetDateAdd(fmDtValue, "D", 99, "", true); // 100 days
		if( !vvdBool && ( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) ) {
			ComShowCodeMessage("BKG95027", "100 days"); // "The period of Date can't be over {?msg1}."
			event.returnValue=false;		
			ComSetFocus(formObj);
			return false;
		}
	}
	if(!vvdBool) {
		if(formObj.value == ""){
			ComShowCodeMessage("BKG95025", formObj.caption); // msgs['BKG95025']="Please input {?msg1}."
			event.returnValue=false;		
			ComSetFocus(formObj);
			return false;
		}
	}
	return true;
}
/** 
* handling process for input validation하는 validateForm <br>
* @param  {IBSheet} sheetObj  
* @param  {object} formObj 
* @param  {sAction} sAction
*/ 
function validateForm(sheetObj, formObj, sAction){
	var form=document.form;
	var rhq=bkg_rhq_cd; 
	var fmDtObj=form.from_dt;	
	var toDtObj=form.to_dt;
	var fmDtValue=fmDtObj.value;	
	var toDtValue=toDtObj.value;
	var vvdObj=form.vvd;
	var ctrtTyObj=bkg_ctrt_tp_cd;
	var ctrtNoObj=form.ctrt_no;
    switch (sAction) {
    	case IBSEARCH: 
    		if(null == rhq.GetSelectCode()|| "" == rhq.GetSelectCode()){
				ComShowCodeMessage("BKG95031", "RHQ");
				event.returnValue=false;
				ComSetFocus(rhq);
				return false;	
    		}
			if(!ComChkObjValid(fmDtObj)) { return false; }
			if(!ComChkObjValid(toDtObj)) { return false; }
			if("" == vvdObj.value && ("" == fmDtValue || "" == toDtValue)) {
				 ComShowCodeMessage("BKG95025", "Date or T/VVD"); // "Please input {?msg1}."
				 if("" == fmDtObj.value) {
					 ComSetFocus(fmDtObj);
				 }else{
					 ComSetFocus(toDtObj);
				 }
				 return false;
			}
			if(!chkDate(fmDtObj)) {  return false; }
			if(!chkDate(toDtObj)) { return false; }
			if(!chkDate(fmDtObj)) {  return false; }
			if(!chkDate(toDtObj)) { return false; }
			if(ctrtNoObj.value != "" && (null == ctrtTyObj.GetSelectCode()|| "" == ctrtTyObj.GetSelectCode()) ) {
				ComShowCodeMessage("BKG95031", "Contract Type");
				event.returnValue=false;
				ComSetFocus(ctrtTyObj);
				return false; 
			}
			break;
    }
    return true;
}    
/** 
* decision check or not of B/L COVERED TYPE CODE  in case of Bill Type select<br>
* @param  {boolean} tf
*/ 
function setBillTypeCheckBox(tf) {
	/*
	common code : B/L COVERED TYPE CODE ( CD01639 )
	B CO-BIZ B/L 
	C COVERED B/L
	M MASTER B/L
	N NORMAL B/L
	*/
	var form=document.form;
	form.bill_type_n.checked=tf;
	form.bill_type_m.checked=tf;
	form.bill_type_c.checked=tf;	
	form.bill_type_b.checked=tf;		
}
/** 
* handling OnSearchEnd event after sheet2 data retrieve<br>
* @param  {IBSheet} sheetObj  
* @param  {string} errMsg   
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var form=document.form;
    if(sheetObj.RowCount()> 0){
    	form.bl_cnt.value=sheetObj.GetCellValue(3,"bl_cnt");
    }else{
    	form.bl_cnt.value="0";
    }
}
