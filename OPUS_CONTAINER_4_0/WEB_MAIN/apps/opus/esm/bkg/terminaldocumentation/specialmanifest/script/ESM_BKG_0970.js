/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_BKG_0970.js
 *@FileTitle : ESM_BKG_0970
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;

var comboObjects = new Array();
var comboCnt = 0;
//Event handler processing by button click event  */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
     var sheetObject=sheetObjects[0];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
				case "btn1_DownExcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
					break;
				case "btn_calendar":
					visibleFalse("2");
					var cal=new ComCalendarFromTo();
	                cal.select(formObject.snd_dt_from, formObject.snd_dt_to, 'yyyy-MM-dd');
					break;
				case "d_type0": // in case of Declration select(All)
				case "d_type1": // in case of Declration select(Discharging)
				case "d_type2": // in case of Declration select(Trasit)
				case "d_type3": // in case of Declration select(Loading)
				case "d_type4": // in case of Declration select(Pre-Carriage)
				case "d_type5": // in case of Declration select(On-Carriage)
					var dTypeVal=declarationCheckValue();  // get value of selected checkbox 
					dTypeCheckValidate(dTypeVal, srcName);
					break;
				case "vvd_cd" :
				case "port_cd" :
					visibleFalse("1");
					break;
				case "snd_dt_from" :
				case "snd_dt_to" :
					visibleFalse("2");
					break;
				case "search_type" :
					if(formObject.search_type[0].checked) {
						visibleFalse("1");
					} else {
						visibleFalse("2");
					}
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
 * 조회조건 visible
 * @param searchType ("1" : VVD, PORT 활성화, "2" : Transmit Date 활성화)
 * @return
 */
function visibleFalse(searchType) {
	
	var formObject = document.form;
	
	if(searchType == "1") {
		formObject.vvd_cd.readOnly = false;
		$("[name='vvd_cd']").removeClass("input2").addClass("input1");
//		formObject.vvd_cd.className = "input1";
		/*
		 * 2012.03.15 port_cd 0965일때 콤보 처리
		 * */
		if(formObject.call_gubun.value == "ESM_BKG_0965"){
			formObject.port_cd.BackColor = "#CCFFFD";
			formObject.port_cd.Style = 1;//0 -편집 가능,1 -편집 불가능
		}else{
			formObject.port_cd.readOnly = false;
			$("[name='port_cd']").removeClass("input2").addClass("input1");
//			formObject.port_cd.className = "input1";
		}
		
		formObject.snd_dt_from.value = "";
		formObject.snd_dt_to.value = "";
		formObject.snd_dt_from.readOnly = true;
		$("[name='snd_dt_from']").removeClass("input1").addClass("input2");
//		formObject.snd_dt_from.className = "input2";
		formObject.snd_dt_to.readOnly = true;
		$("[name='snd_dt_to']").removeClass("input1").addClass("input2");
//		formObject.snd_dt_to.className = "input2";
		formObject.search_type[0].checked = true;
		
	} else {
		
		formObject.snd_dt_from.readOnly = false;
		$("[name='snd_dt_from']").removeClass("input2").addClass("input1");
//		formObject.snd_dt_from.className = "input1";
		formObject.snd_dt_to.readOnly = false;
		$("[name='snd_dt_to']").removeClass("input2").addClass("input1");
//		formObject.snd_dt_to.className = "input1";
		
		formObject.vvd_cd.value = "";
		formObject.vvd_cd.readOnly = true;
		$("[name='vvd_cd']").removeClass("input1").addClass("input2");
		formObject.vvd_cd.className = "input2";
		/*
		 * 2012.03.15 port_cd 0965일때 콤보 처리
		 * */
		if(formObject.call_gubun.value == "ESM_BKG_0965"){
			formObject.port_cd.Text = "";
			formObject.port_cd.BackColor = "#E8E7EC";
		}else{
			formObject.port_cd.readOnly = true;
			$("[name='port_cd']").removeClass("input1").addClass("input2");
//			formObject.port_cd.className = "input2";
			formObject.port_cd.value = "";
		}
		
		formObject.search_type[1].checked = true;
		
		//날짜 셋팅
		if(formObject.snd_dt_from.value == "" && formObject.snd_dt_to.value == "") {
			initSearchDate();
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
 * adding first-served functions after loading screen
 */
function loadPage(dType, callGubun) {
	var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
    }	
    
    for(var k=0;k < comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }    
	// Declaration Setting
	if(callGubun == "ESM_BKG_0965") {
		
		if (dType == "") {
			formObj.d_type0.checked = true;
			formObj.d_type.value = ""; 
		} else if (dType == "D") {
			formObj.d_type1.checked = true;
			formObj.d_type.value = "D"; 
		} else if (dType == "T") {
			formObj.d_type2.checked = true;
			formObj.d_type.value = "T"; 
		} else if (dType == "L") {
			formObj.d_type3.checked = true;
			formObj.d_type.value = "L"; 
		} else if (dType == "P") {
			formObj.d_type4.checked = true;
			formObj.d_type.value = "P"; 
		} else if (dType == "O") {
			formObj.d_type5.checked = true;
			formObj.d_type.value = "O"; 
		} else {
			formObj.d_type0.checked = true;
			formObj.d_type.value = ""; 
		}
		
	} else {
		
		if(dType == "") {
			formObj.d_type[0].checked = true;
		} else if(dType == "D") {
			formObj.d_type[1].checked = true;
		} else if(dType == "T") {
			formObj.d_type[2].checked = true;
		} else if(dType == "L") {
			formObj.d_type[3].checked = true;
		} else {
			formObj.d_type[0].checked = true;
		}
	}
	setHideField(callGubun);
	// Declaration Setting
	if(formObj.call_gubun.value == "ESM_BKG_0965") {
		// port_cd 콤보 세팅
		doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
	}
	
	//  선택적 필수 조회조건 셋팅
	visibleFalse("1");
	
	
	if(formObj.pgmNo.value != "ESM_BKG_0970") {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}	
	
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
//	sheet1_OnLoadFinish(sheet1);
}
	/**
	 * Bl No. / Container No. / Un No. / Error Message field hidden when 0966 screen open 
	 * @return
	 */
	function setHideField(callGubun) {
		if(callGubun == "ESM_BKG_0966") {
			sheetObjects[0].SetColHidden("bl_no",1);
			sheetObjects[0].SetColHidden("cntr_no",1);
			sheetObjects[0].SetColHidden("imdg_un_no",1);			
			sheetObjects[0].SetColHidden("dg",1);
		}
	}


	
	/**
	 * Combo Object 초기화
	 * 
	 * @param comboObj
	 * @param comNo
	 * @return
	 */
	function initCombo(comboObj, comNo) {
		switch (comboObj.id) {
			case "port_cd":
				with (comboObj) {
					BackColor = "#CCFFFD";
				}
				break;
		} // end switch
	}

/**
 * return selected declaration field 
 * 
 * @return
 */
function declarationCheckValue() {
	var formObj=document.form;
	var retVal="";
	for ( var i=0; i <= 5; i++) {
		var dTypeFlag="formObj.d_type" + i + ".checked";
		var dTypeValue="formObj.d_type" + i + ".value";
		if (eval(dTypeFlag)) {
			retVal += eval(dTypeValue);
		}
	} // end for(i)
	return retVal;
}
/**
 * Declaration check Validation
 * @return
 */
function dTypeCheckValidate(dTypeVal, srcName) {
	var formObj=document.form;
	//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
	switch (srcName) {
		case "d_type0" :	// All 
			//alert(">> " + formObj.d_type0.checked);
			if(formObj.d_type0.checked) {
				formObj.d_type0.checked=true;
			} else {
				formObj.d_type0.checked=false;
			}
			formObj.d_type1.checked=false;
			formObj.d_type2.checked=false;
			formObj.d_type3.checked=false;
			formObj.d_type4.checked=false;
			formObj.d_type5.checked=false;
			break;
		case "d_type1" :	// Discharging 
			formObj.d_type0.checked=false;
			switch (dTypeVal) {
				case "AD" : 
				case "DT" :
				case "DL" :
				case "DP" :
				case "DLP" :
					formObj.d_type1.checked=false;
			}
			break;
		case "d_type2" : 	// Transit
			formObj.d_type0.checked=false;
			switch (dTypeVal) {
				case "AT" :
				case "DT" :
				case "TL" :
				case "TP" :
				case "TO" :
				case "TLP" :
				case "DTO" :
					formObj.d_type2.checked=false;
			}
			break;
		case "d_type3" : 	// Loading
			formObj.d_type0.checked=false;
			switch (dTypeVal) {
				case "AL" :
				case "DL" :
				case "TL" :
				case "LO" :
				case "DLO" :
					formObj.d_type3.checked=false;
			}
			break;
		case "d_type4" : 	// Pre-Carriage
			formObj.d_type0.checked=false;
			switch (dTypeVal) {
				case "AP" :
				case "DP" :
				case "TP" :
				case "PO" :
				case "DPO" :
					formObj.d_type4.checked=false;
			}
			break;
		case "d_type5" : 	// On-Carriage
			formObj.d_type0.checked=false;
			switch (dTypeVal) {
				case "AO" :
				case "TO" :
				case "LO" :
				case "PO" :
				case "LPO" :
					formObj.d_type5.checked=false;
			}
			break;
		default : 
			formObj.d_type1.checked=false;
			break;
	} // end switch
	var newType=declarationCheckValue();
	formObj.d_type.value=(newType == "LP") ? "PL" : newType;
}
/**
 * date setting
 * @return
 */
function initSearchDate() {
	document.form.snd_dt_from.value=ComGetDateAdd(null, 'd', -7, '-');
	document.form.snd_dt_to.value=ComGetNowInfo('ymd','-');
}
/**
 * validation range of date(a month)
 * @return
 */
function validateSearchDate() {
//	document.form.snd_dt_from.value=ComGetDateAdd(null, 'd', -7, '-');
//	document.form.snd_dt_to.value=ComGetNowInfo('ymd','-');
	var formObj=document.form;
	var fromDt=formObj.snd_dt_from.value;
	var toDt=formObj.snd_dt_to.value;
	var retVal=ComGetDaysBetween(fromDt, toDt);
	//alert("retVal : " + retVal);
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
        case "sheet1":
            with(sheetObj){
            
			var HeadTitle1 = "|Seq|Message Key Number|Sent Type|Sent Type|Transmit Date|VVD|PORT|Declaration Type|Security file Number|B/L No.|Container No.|UN No.|Status|Acknowledge Date|Approval Date|Received Error Message|DG\nInquiry|Transmit ID|cntr_cgo_seq|IMO class|Flashpoint|PG|Packings|QUANTITY|Net WGT|Grs WGT|Substance|Technical Name";
			var HeadTitle2 = "|Seq|Message Key Number|Sent Type|Sent Type|Transmit Date|VVD|PORT|Declaration Type|Security file Number|B/L No.|Container No.|UN No.|Status|Acknowledge Date|Approval Date|Received Error Message|DG\nInquiry|Transmit ID|cntr_cgo_seq|IMO class|Flashpoint|PG|Packings|QUANTITY|Net WGT|Grs WGT|Substance|Technical Name";
          var headCount=ComCountHeadTitle(HeadTitle1);
          (headCount, 0, 0, true);

          SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"}     ,    { Text:HeadTitle2, Align:"Center"}  ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:"msg_snd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"msg_func_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"auto_snd_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eur_dg_decl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"scr_file_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ack_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"apro_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cstms_err_msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Popup",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"tran_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

		         {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"eur_pck_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"net_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetCountPosition(4);
          SetShowButtonImage(1);
          FrozenCols=6;
          //no support[check again]CLT 				MultiSelection=true;
          SetAutoRowHeight(0);
          SetDataRowHeight(22);
          SetSheetHeight(500);
          }

		break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
    switch(sAction) {
		case IBSEARCH:      
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value=SEARCH;			
			var sXml=sheetObj.GetSearchData("ESM_BKG_0970GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml, {Sync:1} );			
			break;
		case IBDOWNEXCEL:
			if(!validateForm(sheetObj,formObj,sAction)) return false;
//			sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), Merge:1 });
			break;
    }
}
/**
 * handling sheet click
 */
function sheet1_OnClick(sheetObj, row, col) {
	var rowCnt=sheetObj.RowCount();
	var colSaveName=sheetObj.ColSaveName(col);
	/* color and font of Row Focus set default value Row Focus */
//no support[implemented common]CLT 	
//no support[implemented common]CLT 	sheetObj.SelectFontBold=false;
//no support[implemented common]CLT 	
//no support[implemented common]CLT 	sheetObj.SelectBackColor="16186087";
	sheetObj.SetSelectFontBold(false);
	sheetObj.SetSelectBackColor("16186087");
	switch(colSaveName) {
		/* handling MemoPad of long string*/
		case "cstms_err_msg" :
			if(sheetObj.GetGetCellValue(row,col) == "") return false;
			ComShowMemoPad(sheetObj, null, null, true, 400, 100);
			break;
	} // end switch
}
/**
 * handling search end
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	if(ErrMsg == "") {
		var rowCnt=sheetObj.LastRow();
		/*
		 * setting status value
		 */
		for(var i=1; i <= rowCnt; i++) {
		var ackRcvStsCd=sheetObj.GetCellValue(i, "ack_rcv_sts_cd");
		var msgSndNo=sheetObj.GetCellValue(i, "msg_snd_no");
//parameter changed[check again]CLT 			
//parameter changed[check again]CLT 			sheetObj.SetGetCellFontColor(i, "ack_rcv_sts_cd","#FFFFFF");
		sheetObj.SetCellFontColor(i, "ack_rcv_sts_cd","#FFFFFF");
			if (msgSndNo == "" && ackRcvStsCd == "") { // empty
				sheetObj.SetCellValue(i, "ack_rcv_sts_cd","Empty Message not sent",0);
				sheetObj.SetCellBackColor(i,"ack_rcv_sts_cd","#808080");// gray
			} else if (msgSndNo != "" && ackRcvStsCd == "") {
				sheetObj.SetCellValue(i, "ack_rcv_sts_cd","Processing",0);
				sheetObj.SetCellBackColor(i,"ack_rcv_sts_cd","#808080");// gray
			} else if (ackRcvStsCd == "A") {
				sheetObj.SetCellValue(i, "ack_rcv_sts_cd","Sent, Accepted",0);
				sheetObj.SetCellBackColor(i,"ack_rcv_sts_cd","#0000FF");// blue
			} else if (ackRcvStsCd == "C") {
				sheetObj.SetCellValue(i, "ack_rcv_sts_cd","Sent, Wrong but Acceptable",0);
				sheetObj.SetCellBackColor(i,"ack_rcv_sts_cd","#008000");//yellowgreen
			} else if (ackRcvStsCd == "R") {
				sheetObj.SetCellValue(i, "ack_rcv_sts_cd","Sent, Not Acceptable",0);
				sheetObj.SetCellBackColor(i,"ack_rcv_sts_cd","#FF0000");// read
			}
		} // end for(i)
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH:
			if(formObj.d_type.value == "") {
				if(formObj.call_gubun.value == "ESM_BKG_0965") {
					formObj.d_type0.checked=true;
				} else {
					formObj.d_type.checked=true;
				}
			}
			if(formObj.search_type[0].checked) {
				if(!ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
			} else {
				if(!ComChkObjValid(formObj.snd_dt_from) || !ComChkObjValid(formObj.snd_dt_to)) return false;
			}
			if(!ComChkObjValid(formObj.bl_no) || !ComChkObjValid(formObj.cntr_no)) return false;
			// error  from - to range over 30days 
			if(ComGetDaysBetween(formObj.snd_dt_from.value, formObj.snd_dt_to.value) > 30) {
				ComShowCodeMessage('BKG00605');
				ComSetFocus(formObj.snd_dt_to);
				return false;
			}
			break;
		case IBDOWNEXCEL:
			var rowCnt=sheetObj.RowCount();
			if(rowCnt == 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			break;
	} // end switch
	return true;
}
/**
 * handling popup click
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @returnN
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var formObj=document.form;
	var callGubun=formObj.call_gubun.value;
	with (sheetObj) {
		var sName=ColSaveName(Col);
		switch (sName) {
			case "dg":
				var dType="";
				var declarationType=sheetObj.GetGetCellValue(Row, "eur_dg_decl_tp_cd");
				if(declarationType == "Discharging") {
					dType="D";
				} else if(declarationType == "Transit") {
					dType="T";
				} else if(declarationType == "Loading") {
					dType="L";
				} else if(declarationType == "Pre-carriage") {
					dType="P";
				} else if(declarationType == "On-Carriage") {
					dType="O";
				} else if(declarationType == "Discharging + On-Carriage") {
					dType="DO";
				} else if(declarationType == "Pre-carriage + Loading") {
					dType="PL";
				}
				sUrl="ESM_BKG_0967.do?";
				sParam="callGubun="+ callGubun
					+ "&d_type="+dType
					+ "&vvd_cd="+sheetObj.GetGetCellValue(Row, 'vvd_cd')
					+ "&port_cd="+sheetObj.GetGetCellValue(Row, 'port_cd')
					+ "&bl_no="+sheetObj.GetGetCellValue(Row, 'bl_no')
					+ "&cntr_no="+sheetObj.GetGetCellValue(Row, 'cntr_no')
					+ "&cntr_cgo_seq="+sheetObj.GetGetCellValue(Row, 'cntr_cgo_seq');
				//alert(sUrl + sParam);
				rtnVal=ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0967", 1024, 670, true);
				break;
		} // end switch
	} // end with
}

