/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0036.jsp
*@FileTitle  : B/L Inquiry: C/M Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
//Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
 function processButtonClick(){
	  /* */
	  var sheetObject1=sheetObjects[0]; // Cntr
	  var sheetObject2=sheetObjects[1]; // C/M
	  var sheetObject3=sheetObjects[2]; // B/L Info
	  /*******************************************************/
	  var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
         switch(srcName) {
			case "btn_retrieve":
				//doActionIBSheet(sheetObject3,document.form,IBSEARCH);
				doActionIBSheet(sheetObject2,document.form,IBSEARCH);
			break;
			case "btn_save":
				doActionIBSheet(sheetObject2,document.form,IBSAVE);
			break;
			case "btn_copy":
				var selIdx=sheetObject1.GetSelectRow();
				if(selIdx > 0){
					var cntr_no=sheetObject1.GetCellValue(selIdx, "cntr_no");
					var cntr_tpsz_cd=sheetObject1.GetCellValue(selIdx, "cntr_tpsz_cd");
					var url="ESM_BKG_0176.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
					ComOpenWindowCenter(url, "ESM_BKG_0176", 400, 300);
				}else{
					ComShowCodeMessage('BKG00249');  // No Selected Row
				}
			break;
			case "btn_clm":
				var params="pgmNo=ESD_SCE_0044&f_cmd=0&" +
							 "cntr_no=" + document.form.cntr_no.value + 
							 "&tpsz_cd=" + document.form.tpsz_cd.value;
				ComOpenWindowCenter("ESD_SCE_0044.do?"+params, "ESD_SCE_0044", 1024, 530);
			break;				
			case "btn_close":
				ComClosePopup(); 
			break;
			case "btn_add":
				doActionIBSheet(sheetObject2,document.form,IBINSERT);
			break;
			case "btn_del":
				doActionIBSheet(sheetObject2,document.form,IBDELETE);
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
     for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
	var formObj=document.form;
// 	axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
// 	axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
// 	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	sheet2_OnLoadFinish(sheet2);
 }

 /**
  * retrieving after loading screen
  */
 function sheet2_OnLoadFinish(sheetObj) {
	 var formObj=document.form;
	 doActionIBSheet(sheetObj,formObj,IBSEARCH);
 }
/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     var sheetId=sheetObj.id;
     switch(sheetId) {	         
         case "sheet1":      //sheet1 init
        	    with(sheetObj){                      
		           var HeadTitle="|Seq.|bl_no|Container|TY/SZ|Seal No.|Seal No.|STS||";
		
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                  {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Combo",     Hidden:0, Width:250,  Align:"Center",  ColMerge:0,   SaveName:"combo_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibd_cntr_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_flag",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mf_cfm_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            
		         InitColumns(cols);
		
		         SetEditable(1);
                 SetColProperty("ibd_cntr_sts_cd", {ComboText:"Active|Deleted", ComboCode:"A|D"} );
                 SetSheetHeight(140);

             }
             break;
         case "sheet2":      //sheet2 init
             with (sheetObj) {                          
             var HeadTitle1="||Seq.|GDS Seq|PACKAGE|PACKAGE|WEIGHT|WEIGHT|MK|DESCRIPTION|HTS CODE|HTS CODE|FDA|PN CONFIRM BY CONSIGNEE|PN CONFIRM BY CONSIGNEE|PN CONFIRM BY CONSIGNEE||";
             var HeadTitle2="||Seq.|GDS Seq|PACKAGE|PACKAGE|WEIGHT|WEIGHT|MK|DESCRIPTION|HTS CODE|HTS CODE|PN|C|DATE|REMARK||";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:0 };
             
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                         { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                    {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
                    {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_gds_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ams_pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                    {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mk_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cgo_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"hamo_cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                    {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"prior_ntc_snd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                    {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prior_ntc_cfm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
                    {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prior_ntc_cfm_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"prior_ntc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              
             InitColumns(cols);
             SetEditable(1);
             SetColProperty("wgt_ut_cd", {ComboText:" |KGS|LBS", ComboCode:" |KGS|LBS"} );
             SetSheetHeight(200);
             SetShowButtonImage(2);
             }
             sheetObj.SetMergeCell(0, 4, 2, 2);
             sheetObj.SetMergeCell(0, 6, 2, 2);
             sheetObj.SetMergeCell(0, 10, 2, 2);             

             break; 
	     case "sheet3":      //sheet3 init
	         with (sheetObj) {	         
	         var HeadTitle="|bl_no|pod_cd|pol_cd|del_cd|usa_lst_loc_cd|pck_qty|ams_pck_tp_cd|cgo_wgt|wgt_ut_cd|ibd_trsp_no|ibd_trsp_tp_cd|cstms_clr_tp_cd|mf_sts|f_flg|o_flg|c_flg|cstms_mf_tp_cd|vps_eta_dt";

	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
	         InitHeaders(headers, info);

	         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"usa_lst_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ams_pck_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mf_sts",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"f_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"o_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cstms_mf_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          
	         InitColumns(cols);

	         SetEditable(1);
	         

	         }
	         break;
     }
 }
/**
 * handling process for Sheet
 */ 
 function doActionIBSheet(sheetObj,formObj,sAction) {
     //sheetObj.ShowDebugMsg = false;
	 sheetObjects[0].SetWaitImageVisible(0);
	 sheetObjects[1].SetWaitImageVisible(0);
     switch(sAction) {
		case IBSEARCH:      //retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
    		ComOpenWait(true);
	        formObj.f_cmd.value=SEARCH;
 	        var sXml=sheetObj.GetSearchData("ESM_BKG_0036GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if(arrXml.length > 0){
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
				sheetObjects[1].SelectCell(0,0);
		        ComEtcDataXmlToForm(arrXml[0], formObj);
		        var stsCd=ComGetEtcData(arrXml[0],"mf_sts");
		        document.getElementById("mf_sts").innerHTML=(stsCd != undefined ? stsCd : "");
				if(stsCd == "Active"){
					document.getElementById("mf_sts").style.color="blue";
				}else if(stsCd == "Deleted"){
					document.getElementById("mf_sts").style.color="red";
				}
				var etcData;
				etcData=ComGetEtcData(arrXml[0],"cstms_clr_tp_cd");
		        document.getElementById("cstms_clr_tp_cd").innerHTML=(etcData != undefined ? etcData : "");
		        etcData=ComGetEtcData(arrXml[0],"f_flg");
		        document.getElementById("f_flg").innerHTML=(etcData != undefined ? etcData : "");
		        etcData=ComGetEtcData(arrXml[0],"o_flg");
		        document.getElementById("o_flg").innerHTML=(etcData != undefined ? etcData : "");
		        etcData=ComGetEtcData(arrXml[0],"c_flg");
		        document.getElementById("c_flg").innerHTML=(etcData != undefined ? etcData : "");
		        if(formObj.pck_qty.value != "" && formObj.cgo_wgt.value != ""){
					AddComma(formObj.pck_qty,"#,###");
					AddComma(formObj.cgo_wgt,"#,###.###");
		        }
			}
    		ComOpenWait(false);
	        break;
		case IBSAVE:        //
			if(!validateForm(sheetObj,formObj,sAction)) return false;
		 	if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
	    		ComOpenWait(true);
		        formObj.f_cmd.value=MODIFY;
				sheetObj.DoSave("ESM_BKG_0036GS.do", FormQueryString(formObj), -1, false);
	    		ComOpenWait(false);
		 	}
			break;
		case IBINSERT:      // 
			sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bl_no",formObj.bl_no.value);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_no",formObj.cntr_no.value);
			setSeq();
			break;
		case IBDELETE:      // 
			if(sheetObj.CheckedRows(1) == 0){
				ComShowCodeMessage('BKG00249'); // No Selected Row
				return;
			}
			if(sheetObj.CheckedRows(1) > 0){
				if(ComShowCodeConfirm('BKG03037')){
					/* deleting Row */
					rowDelete(sheetObj, "Sel", 1);
					/* recalculating Quantity */
					syncQuantity("pck_qty");
					syncQuantity("grs_wgt");
					setSeq();
				}
			}
			break;
     }
 }
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
	case IBSEARCH: // 
		if (!ComChkObjValid(formObj.bl_no)) return false;
		return true;
	    break;
	case IBSAVE: // 
	 	if (!ComChkValid(formObj)) return false;
	    return true;
	    break;
	}
}
/**
 * setting combo data after retrieving
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if(ErrMsg != "") return;
	var sealNo;
	for (i=1; i<=sheetObj.RowCount(); i++){
		sealNo=sheetObj.GetCellValue(i,"seal_no");
		sheetObj.CellComboItem(i,"combo_seal_no", {ComboText:sealNo, ComboCode:sealNo} );
		sheetObj.SetCellBackColor(i, "combo_seal_no","#EFEBEF");
		sheetObj.SetCellValue(i,"mf_cfm_flg",0,0);
		
		var sealNoOneItem = sealNo.split("|");
		sheetObj.SetCellValue(i, "combo_seal_no", sealNoOneItem[0]);
	}
    document.form.cntr_no.value=sheetObj.GetCellText(1,"cntr_no");
}
/**
 * onClick event : displaying CM of Container on selected Row at below sheet
 */ 
function sheet1_OnClick(sheetObj, Row, Col){
    if (sheetObj.ColSaveName(Col) != "cntr_no") return;
    document.form.cntr_no.value=sheetObj.GetCellText(Row,"cntr_no");
    document.form.tpsz_cd.value=sheetObj.GetCellText(Row,"cntr_tpsz_cd");
	setCMInfo(Row);
}
/**
 * handling event after retrieving
 */ 
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	if(ErrMsg != "") return;
	var formObj=document.form;
    if(sheetObj.RowCount()> 0){
    	//setCMInfo(1);
    	//alert(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "Seq"));
    	sheet1_OnClick(sheetObjects[0], sheetObjects[0].GetSelectRow(), sheetObjects[0].SaveNameCol("cntr_no"));
    }
}
/**
 * handling event after saving
 */ 
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj,document.form,IBSEARCH);
}
/**
 * change event : recalculating Total value in case of existing changed package, weight
 */ 
function sheet2_OnChange(sheetObj, Row, Col, Val) {
    var col_name=sheetObj.ColSaveName(Col);
	switch(col_name) {
		case "pck_qty":
		case "grs_wgt":
			syncQuantity(col_name);
			break;
	}
}
/**
 * onClick event : showing memo pad in case of clicking mk_desc
 */ 
function sheet2_OnClick(sheetObj, Row, Col){
    if (sheetObj.ColSaveName(Col) == "mk_desc") {
		ComShowMemoPad(sheetObj, null, null, false, 200, 100);
		if(sheetObj.GetCellValue(Row, Col) == ""){
		    var frameDoc=document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
			frameDoc.getElementById(MEMO_TEXT_NAME).value="NO MARKS";
		}
    }
	//document.getElementById("total_cnt").innerHTML="["+sheetObj.GetCellText(Row,"seq")+" / "+cmTotal+"]";
}
/**
 * calling pop up in case of clicking magnifier image on sheet 
 */ 
function sheet2_OnPopupClick(sheetObj, Row, Col){
    if (sheetObj.ColSaveName(Col) == "hts_cd"){
    	comBkgCallPop0607("setCallBack0607","","");
    }
}
/**
 * setting values from pop up
 */ 
function setCallBack0607(aryPopupData) {
	var sheetObj=sheetObjects[1];
	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"hamo_cmdt_cd",aryPopupData[0][3]);
	sheetObj.SetCellValue(sheetObj.GetSelectRow(),"prior_ntc_snd_flg",aryPopupData[0][6]);
}
/**
 * returning formatted string
 */
function AddComma(obj, sFormat){
    try {
        var sVal=obj.value.replace(/\,/g,"");
    	switch(sFormat){
    		case "#,###":
    			obj.value=ComAddComma(sVal);
    			break;
    		case "#,###.###":
    	    	p=sVal.split(".");
                p[0]=ComAddComma(p[0]);
                if      (p.length <= 1) obj.value=p[0]+".000";
                else if (p.length == 2) obj.value=p[0]+"."+p[1].substr(0,3);
                else if (p.length > 2) obj.value=p[0]+"."+p[1].substr(0,3);
                else sVal="";
    			break;
    	}
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * setting Cntr data and CM grid data when selecting container at Cntr grid 
 */
var cmTotal;
function setCMInfo(row){
	if(row > 0) {
		// retrieve CM
		showAndHideSheet(sheetObjects[1], "cntr_no", sheetObjects[0].GetCellValue(row, "cntr_no"));
		// rearangeSeq
		setSeq();
		// calculate sum
		syncQuantity("pck_qty");
		syncQuantity("grs_wgt");
		sheetObjects[0].SelectCell(row,"cntr_no");
	}
}
/**
 * handling to hide row - excepting CM of Container at higher grid
 */ 
function showAndHideSheet(sheetObj, colName, colValue){
	var rcnt=sheetObj.RowCount()+ 2;
	for(rn=2;rn<rcnt;rn++){
if(sheetObj.GetRowStatus(rn) != 'D' && sheetObj.GetCellValue(rn, colName) == colValue){
			sheetObj.SetRowHidden(rn,0);
			//sheetObj.CellValue2(rn, "Sel") = '0';
		}else{
			sheetObj.SetRowHidden(rn,1);
			//sheetObj.CellValue2(rn, "Sel") = '1';
		}
	}
}
/**
 * in case of clicking Row Delete button
 */ 
function rowDelete(sheetObj, colName, colValue){
	var arrRow=findText(sheetObj, colName, colValue);
	for (ir=0; ir < arrRow.length; ir++) {
		if(arrRow[arrRow.length-1-ir]=='') continue;
		sheetObj.SetRowHidden(arrRow[arrRow.length-1-ir],1);
		sheetObj.SetRowStatus(arrRow[arrRow.length-1-ir],'D');
	}
}
/**
 * calculating Package, Weight value
 */
function syncQuantity(col_name){
	var formObj=document.form;
	var vSum=0;
	// CM
	var CmArr=findText(sheetObjects[1], "cntr_no", document.form.cntr_no.value);
	for(rx=0;rx<CmArr.length;rx++){
		//alert(CmArr[rx] + " : " + sheetObjects[1].CellValue(CmArr[rx], col_name));
vSum += ComParseFloat(sheetObjects[1].GetCellValue(CmArr[rx], col_name));
	}
	// Set Value
	if(col_name=="pck_qty") {
		formObj.tot_pkg.value=''+vSum;
		AddComma(formObj.tot_pkg, "#,###");
	}
	if(col_name=="grs_wgt") {
		formObj.tot_wgt.value=''+vSum;
		AddComma(formObj.tot_wgt, "#,###.###");
	}
}
/**
 * setting Seq No. of CM grid according to Container of higher grid
 */ 
function setSeq(){
	var rSeq=1;
	var rCnt=sheetObjects[1].RowCount()+ 2;
	for (rn=2; rn < rCnt; rn++) {
var rsts=sheetObjects[1].GetRowStatus(rn);
		if(rsts != 'D' && sheetObjects[1].GetRowHidden(rn) == false){
		//if(rsts != 'D' && sheetObjects[1].CellValue(rn, "Sel") == '0'){
			sheetObjects[1].SetCellValue(rn, "seq",rSeq++,0);
			sheetObjects[1].SetRowStatus(rn,rsts);
		}
		if(rSeq == 1) sheetObjects[1].SelectCell(0,0);
	}
	cmTotal=rSeq-1;
//	if(cmTotal == 0){
//		document.getElementById("total_cnt").innerHTML="[0 / "+cmTotal+"]";
//	}else{
//		document.getElementById("total_cnt").innerHTML="[1 / "+cmTotal+"]";
//	}
}
/**
 * setting CM with CM value of selected Container at Copy CM pop up
 */ 
function copyCm(fmCntr, toCntrArr){
	if(fmCntr == '' || toCntrArr == ''){
		return;
	}
	var sheetObj=sheetObjects[1];
	var tgtCnt=toCntrArr.length;
	var cArr=findText(sheetObj, "cntr_no", fmCntr);
	for(ix=0;ix<tgtCnt;ix++){
		for(ir=0;ir<cArr.length;ir++) {
			var nRow=sheetObj.DataInsert(-1);
			sheetObj.SetRowHidden(nRow,1);
			for(ic=0; ic <=  sheetObj.LastCol(); ic++){
				try{
					if(sheetObj.ColSaveName(ic) == "ibflag") continue;
					if(sheetObj.ColSaveName(ic) == "cmdt_gds_seq") continue;
					if(sheetObj.ColSaveName(ic) == "cntr_no"){
						sheetObj.SetCellValue(nRow, ic,toCntrArr[ix],0);
					}else{
sheetObj.SetCellValue(nRow, ic,sheetObj.GetCellValue(cArr[ir], ic),0);
					}
				} catch(err) { }
			}			
		}
	}
}
/**
 * casting to Integer type
 * @param p
 * @return int
 */
function ComParseInt(p){
	return (p == null || p == '') ? 0 : parseInt(p);
}
/**
 * casting to Float type
 * @param p
 * @return float
 */
function ComParseFloat(p){
	return (p == null || p == '') ? 0 : parseFloat(p);
}
/**
 * getting column Index of sheet
 */
function findText(sheetObj, colName, colValue){
	var idxs=new Array();
	var firstRow;
	var cnt;
	if(sheetObj.id == "sheet2"){
		firstRow=2;
		cnt=sheetObj.RowCount()+ 2;
	}else{
		firstRow=1;
		cnt=sheetObj.RowCount()+ 1;
	}
	for (ix=firstRow; ix < cnt; ix++) {
		if(sheetObj.GetRowStatus(ix) != 'D' && sheetObj.GetCellValue(ix, colName) == colValue){
			idxs.push(''+ix);
		}
	}
	return idxs;
}
/**
 * getting current date
 */
  function getTimeStamp() {
    var d=new Date();
    var s=
      leadingZeros(d.getFullYear(), 4) + '-' +
      leadingZeros(d.getMonth() + 1, 2) + '-' +
      leadingZeros(d.getDate(), 2) ;
    return s;
  }
/**
 * formatting - yyyy,mm,dd
 */
  function leadingZeros(n, digits) {
    var zero='';
    n=n.toString();
    if (n.length < digits) {
      for (i=0; i < digits - n.length; i++)
        zero += '0';
    }
    return zero + n;
  }
