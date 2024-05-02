/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4011.js
*@FileTitle  : Surcharge Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
// global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var defaultPageRows = 100;
var SearCondition = null;

//Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name  <br>
 */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_loc_grp_pop":
            	var sUrl="/opuscntr/ESM_PRI_4029.do?is_popup=Y&pre_svc_scp_cd=" + comboObjects[0].GetSelectCode()+ "&pre_chg_cd=" + comboObjects[1].GetSelectCode();
                ComOpenPopup(sUrl, 1010, 560,"", "0,0", true);
                break;
            case "btn_retrieve":
                doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                break; 
            case "btn_new":
                comboObjects[0].SetSelectCode('-1',false);
                comboObjects[1].SetSelectCode('-1',false);
                comboObjects[2].SetSelectCode('-1',false);
                comboObjects[3].SetSelectCode('-1',false);
                comboObjects[4].SetSelectCode('-1',false);
                comboObjects[5].SetSelectCode('-1',false);
                comboObjects[6].SetSelectCode('-1',false);
                comboObjects[7].SetSelectCode('-1',false);
                ComClearManyObjects(formObject.por_def_cd, formObject.pol_def_cd, formObject.pod_def_cd, formObject.del_def_cd, formObject.upd_dt);
                formObject.eff_dt.value=ComGetNowInfo('ymd', '-');
                formObject.wdr_flg.checked=false;
                sheetObject1.RemoveAll();
                ComBtnDisable("btn_directdownexcel");
                
                sheetObject1.SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
                break;
            case "btn_downexcel":
                doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                break; 
            case "btn_directdownexcel":
                doActionIBSheet(sheetObjects[2],formObject,IBSEARCH_ASYNC01);
                break;
            case "btn_close":
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
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items  <br>
 * defining list on the top of source <br>
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBMultiCombo Object as array <br>
 * adding process for list in case of needing batch processing with other items  <br>
 * defining list on the top of source <br>
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * Initializing and setting Sheet basics <br>
 * Setting body tag's onLoad event handler <br>
 * Adding pre-handling function after loading screen on the browser  <br>
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++) {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // initializing IBMultiCombo
    for ( var k=0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k + 1);
    }
    User_pageOnLoadFinish();
    ComBtnDisable("btn_directdownexcel");
}
/**
 * calling function when Page Loading <br>
 */ 
function User_pageOnLoadFinish() {
    initControl();
    initIBComboItem();  // IBCombo??Item setting
    form.eff_dt.value=ComGetNowInfo('ymd', '-');
}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetid=sheetObj.id;
    switch(sheetid) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle1="Scope|Charge|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Amount/\nPercentage(%)|Pay Term|Effective\nDate|Expiration\nDate|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|S/I|Update\nDate|User\nName|Remark(s)";
                var HeadTitle2="Scope|Charge|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Amount/\nPercentage(%)|Pay Term|Effective\nDate|Expiration\nDate|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|S/I|Update\nDate|User\nName|Remark(s)";
                var headCount=ComCountHeadTitle(HeadTitle2);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:defaultPageRows, FrozenCol:6, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"scg_amt",             KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Date",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                            {Type:"Date",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                            {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Float",    Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                            {Type:"Float",    Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                            {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dest_trsp_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg",        KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"io_ga_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"soc_flg",             KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scg_grp_cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Date",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"upd_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"scg_rmk",             KeyField:0,   CalcLogic:"",   Format:"" }]
                                                       
                InitColumns(cols);
                SetEditable(0);
                
                SetColProperty("org_trsp_mod_cd", {ComboText:orgTrspModCdText, ComboCode:orgTrspModCdValue} );
                SetColProperty("dest_trsp_mod_cd", {ComboText:destTrspModCdText, ComboCode:destTrspModCdValue} );
                SetColProperty("usa_svc_mod_cd", {ComboText:usaSvcModCdText, ComboCode:usaSvcModCdValue} );
                SetColProperty("prc_rcv_term_cd", {ComboText:prcRcvTermCdText, ComboCode:prcRcvTermCdValue} );
                SetColProperty("prc_de_term_cd", {ComboText:prcDeTermCdText, ComboCode:prcDeTermCdValue} );
                SetColProperty("prc_hngr_bar_tp_cd", {ComboText:prcHngrBarTpCdText, ComboCode:prcHngrBarTpCdValue} );
                SetColProperty("pay_term_cd", {ComboText:payTermCdText, ComboCode:payTermCdValue} );
                SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
                SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
                SetColProperty("scg_imdg_clss_cd", {ComboText:scgImdgClssCdText, ComboCode:scgImdgClssCdValue} );
                SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
                SetColProperty("dir_call_flg", {ComboText:dirCallFlgText, ComboCode:dirCallFlgValue} );
                SetColProperty("soc_flg", {ComboText:socFlgText, ComboCode:socFlgValue} );
                SetColProperty("io_ga_cd", {ComboText:ioGaCdText, ComboCode:ioGaCdValue} );
                SetColProperty("sub_trd_cd", {ComboText:subTrdCdText, ComboCode:subTrdCdValue} );
                SetColProperty("cnl_tz_cd", {ComboText:cnlTzCdText, ComboCode:cnlTzCdValue} );
                SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
                SetWaitImageVisible(0);
                //SetAutoRowHeight(0);
                resizeSheet(); //SetSheetHeight(390);
            }

            break;
        case "sheet2":
            with(sheetObj){
                SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:"", Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
                                                       
                InitColumns(cols);
                SetVisible(0);
            }

            break;
            
        case "sheet3":
            with(sheetObj){
	        	SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            
	            var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	            var headers = [ { Text:"", Align:"Center"} ];
	            InitHeaders(headers, info);
	            
	            var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	                                                   
	            InitColumns(cols);
	            SetVisible(0);
            }

            break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	var lstTotal = sheetObj.GetEtcData("TOTAL");
	if(lstTotal == undefined || lstTotal == null) {
		lstTotal = 0;
	}
	if (vpos==oldvpos || !isBottom || sheetObj.RowCount() >= lstTotal || sheetObj.GetTotalRows() != lstTotal) return;
    
	if(!isChangeSearchCondition()){   		
		//var msg = "Search option was changed, please click 'Retrieve' button again.";
		ComShowCodeMessage("PRI02020");
		sheetObj.RemoveAll();
		sheetObj.SetEtcData("TOTAL", 0);
		sheet1_OnSearchEnd(sheetObj);
		return;
	}
	
	// TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
    doActionIBSheet(sheetObj, document.form, IBSEARCH, true, ++iPageNo);
}

/**
 * Handling sheet process <br>
 */
function doActionIBSheet(sheetObj,formObj,sAction, isPage, PageNo) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            //set the condition for SEARCH
            makeSearchCondition();
            
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("ESM_PRI_4011GS.do", FormQueryString(formObj));
            var arrDesc=ComPriXml2Array(sXml, "flt_pct_tp_cd");
            if (arrDesc != null && arrDesc.length > 0) {
                setFltPctTpCd(sheetObj, arrDesc[0]);
            }
            
            formObj.f_cmd.value=SEARCH02;      
            if(isPage == undefined || !isPage){
            	iPageNo = 1;
            	PageNo  = 1;
            	sheetObj.DoSearch("ESM_PRI_4011GS.do",FormQueryString(formObj) + "&iPage="+PageNo,{Append:false});
            } else {
            	sheetObj.DoSearch("ESM_PRI_4011GS.do",FormQueryString(formObj) + "&iPage="+PageNo,{Append:true});
            }
            
            break;
        case IBDOWNEXCEL: //download excel
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObj.Down2Excel({HiddenColumn:-1, Merge:1,  CheckBoxOnValue:"Y", CheckBoxOffValue:" "}); 
            }
            break;
        case IBSEARCH_ASYNC01: //direct download excel
        	
        	if(!isChangeSearchCondition()){   		
        		//var msg = "Search option was changed, please click 'Retrieve' button again.";
        		ComShowCodeMessage("PRI02020");
        		sheet1.RemoveAll();
        		sheet1.SetEtcData("TOTAL", 0);
        		sheet1_OnSearchEnd(sheet1);
        		return;
        	}
        	

        	
        	var lstTotal = sheetObjects[0].GetEtcData("TOTAL");
            if(sheetObjects[0].RowCount() > 1 && lstTotal <= 35000){

            	formObj.f_cmd.value=SEARCH03;
				formObj.target="_top";
	            formObj.action="ESM_PRI_4011DL.do?"+FormQueryString(formObj);
	            formObj.submit();
	            sheetObj.RemoveEtcData(); // Delete ETC data
            	
            } else if(sheetObjects[0].RowCount() > 1 && lstTotal > 35000){
            	ComShowCodeMessage("PRI02021");
            }
            break;
    }
}

/**
 * Calling function in case of Onclick event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} Row Mandatory Onclick ,Cell's Row Index
 * @param {int} Col Mandatory Onclick ,Cell's Column Index
 * @return N/A
 * @author 
 * @version 2015.12.08
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var colName=sheetObj.ColSaveName(Col);
	var memoColWidth =	sheetObj.GetColWidth("scg_rmk") + sheetObj.GetColWidth("upd_usr_nm") + sheetObj.GetColWidth("upd_dt");
	if (colName == "scg_rmk") {
		ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth + 300, parseInt(sheetObj.GetDataRowHeight()) * 14, 4000, "X");
	} 
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
    if(sheetObj.RowCount() > 1) {
    	ComBtnEnable("btn_directdownexcel");
    } else {
    	ComBtnDisable("btn_directdownexcel");
    }
    //display sheet row's total count
	var lstTotal = sheetObj.GetEtcData("TOTAL");
	if(lstTotal == undefined || lstTotal == "") {
		sheetObj.SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
	} else {
		sheetObj.SetCountFormat("Total Row : (" + lstTotal + ") [SELECTDATAROW / ROWCOUNT]");
	}

}

/**
 * selecting flt_pct_tp_cd function <br>
 *  changing sheet title
 */ 
function setFltPctTpCd(sheetObj, code) {
    if(code == 'F') {
        sheetObj.SetCellValue(0, "scg_amt","Amount")
    } else if(code == 'P') {
        sheetObj.SetCellValue(0, "scg_amt","Percetage %")
    }
}
/**
 * setting IBMultiCombo with retrieved Combo Item <br>
 */
function initIBComboItem() {
    ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    ComPriTextCode2ComboItem(chgCdComboValue, chgCdComboText, getComboObject(comboObjects, 'chg_cd'),"|","\t");
    ComPriTextCode2ComboItem(prcRcvTermCdComboValue, prcRcvTermCdComboText, getComboObject(comboObjects, 'prc_rcv_term_cd'),"|","\t");
    ComPriTextCode2ComboItem(prcDeTermCdComboValue, prcDeTermCdComboText, getComboObject(comboObjects, 'prc_de_term_cd'),"|","\t");
    ComPriTextCode2ComboItem(prcCgoTpCdComboValue, prcCgoTpCdComboText, getComboObject(comboObjects, 'prc_cgo_tp_cd'),"|","\t");
    ComPriTextCode2ComboItem(ratUtCdComboValue, ratUtCdComboText, getComboObject(comboObjects, 'rat_ut_cd'),"|","\t");
    ComPriTextCode2ComboItem(cntrSzCdComboValue, cntrSzCdComboText, getComboObject(comboObjects, 'cntr_sz_cd'),"|","\t");
    ComPriTextCode2ComboItem(scgImdgClssCdComboValue, scgImdgClssCdComboText, getComboObject(comboObjects, 'scg_imdg_clss_cd'),"|","\t");
}
/**
 * initializing combo, header <br>
 * adding case in case of multiple combo <br>
 */
function initCombo(comboObj, comboNo) {
    switch (comboObj.options.id) {
        case "svc_scp_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2);
            }
            break;
        case "chg_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2);
            }
            break;
        case "prc_rcv_term_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetEnable(1);
                SetUseAutoComplete(1);
                ValidChar(2);
            }
            break;
        case "prc_de_term_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetEnable(1);
                SetUseAutoComplete(1);
                ValidChar(2);
            }
            break;
        case "prc_cgo_tp_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetEnable(1);
                SetUseAutoComplete(1);
                ValidChar(2);
            }
            break;
        case "scg_imdg_clss_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetEnable(1);
                SetUseAutoComplete(1);
                InsertItem(0, "", "");// null 값 추가
                ValidChar(5,1);
                SetMaxSelect(1);
            }
            break;
        case "rat_ut_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetEnable(1);
                SetUseAutoComplete(1);
                ValidChar(2,1);
                SetMaxSelect(2);
            }
            break;
        case "cntr_sz_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetEnable(1);
                SetUseAutoComplete(1);
                ValidChar(2,1);
            }
            break;  
    }
}

/**
 * loading HTML Control event in the page <br>
 * initializing IBSheet Object calling from {@link #loadPage} function <br>
 **/
function initControl() {
    DATE_SEPARATOR="/";
    axon_event.addListenerForm  ('beforeactivate', 'obj_activate', document.form);
    axon_event.addListenerForm  ('blur', 'obj_blur',  form);
    //axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    axon_event.addListener ('keydown', 'getKeyEnter', 'form');
}

/**
 * HTML tag (Object)'s onKeyDown event can calling this function, when pressing Enter key handling automatic transaction <br>
 * sFlag = not setting : handling same as sFlag="Search"<br>
 * sFlag = "Search"          : when clicking enter key, handling like clicking retrieve button. calling from OnKeyDown !<br>
 * sFlag = "NextFocus"       : when clicking enter key, changing focus like clicking tab key. calling from OnKeyDown !<br>
 * sFlag = "LengthNextFocus" : when inputed maxlength, changing next focus automatically. when clicking enter key, changing focus like clicking tab key. calling from OnKeyDown !<br>
 * sFlag = Function naming string  : getting Function naming string and clicking enter key, calling relevant function. calling from OnKeyDown !<br>
 * sFlag = "LengthNextFocus" should be called from OnKeyUp event, all remainders should be called from OnKeyDown event<br>
 */
function getKeyEnter(sFlag)
{
    var formObj=document.form;
    try {
        var keyValue=null;
        if(event == undefined || event == null) {
            keyValue=13;
        } else {
            keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        }
        if (keyValue != 13) return;
        
        var obj = ComGetObject("btn_retrieve");
        if (obj == null) obj=ComGetObject("btn_retrieve");
        if (obj) $(obj).click();

    } catch(err) { ComFuncErrMsg(err.message); }
}   

/**
 * calling function when occurring OnKeyPress event <br>
 */
function obj_keypress() {
    switch (event.srcElement.dataformat) {
    case "int":
        //number only
        ComKeyOnlyNumber(ComGetEvent());
        break;
    case "float":
        //number + "."
        ComKeyOnlyNumber(ComGetEvent(), ".");
        break;
    case "eng":
        ComKeyOnlyAlphabet('upper');
        break;
    case "engup":
    	ComKeyOnlyAlphabet('uppernum'); 
        break;
    default:
        //number only
        ComKeyOnlyNumber(ComGetEvent());
    }
}
/**
 * calling event when occurring OnFocus event <br>
 * showing eff_dt YYYYMMDD <br>
 */
function obj_activate() {
    var formObj=document.form;
    var srcName=ComGetEvent("name");
    if(srcName == "eff_dt") {
        formObj.eff_dt.value=formObj.eff_dt.value.replace(RegExp(/-/ig), "");
    } else if(srcName == "upd_dt") {
        formObj.upd_dt.value=formObj.upd_dt.value.replace(RegExp(/-/ig), "");
    }
}

/**
 * calling function when occurring OnBlur event <br>
 */
function obj_blur(){
    var formObj=document.form;
    var srcName=ComGetEvent("name");
    var srcValue=event.srcElement.value;
    switch (srcName) {
        case "por_def_cd":
            checkFormLocation(srcName, srcValue);
            break;
        case "pol_def_cd":
            checkFormLocation(srcName, srcValue);
            break;
        case "pod_def_cd":
            checkFormLocation(srcName, srcValue);
            break;
        case "del_def_cd":
            checkFormLocation(srcName, srcValue);
            break;
        case "eff_dt":
        	formObj.eff_dt.value=ComGetMaskedValue(formObj.eff_dt, "ymd", "-");
        	break;
        case "upd_dt":
            if(ComGetDaysToToday(formObj.upd_dt.value) < 0) {
                ComShowCodeMessage("PRI02012");
                formObj.upd_dt.value="";
                ComSetFocus(formObj.upd_dt);
                return;
            }
            formObj.upd_dt.value=ComGetMaskedValue(formObj.upd_dt, "ymd", "-");
        break;
    }
}
/**
 * location code checking validation function <br>
 */  
function checkFormLocation(objName, objValue) {
    var formObj=document.form;
    var oName=eval("document.form." + objName);
    // Location
    if(objValue.length == 5) {
        formObj.f_cmd.value=SEARCH05;
        formObj.cd.value=objValue;
        var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
        var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
        if(arrDesc == undefined || arrDesc == null ) {
            oName.value="";
            oName.focus();
            return false;
        }
        return true;
    }
    // Location Group
    else if (objValue.length == 4) {
        formObj.f_cmd.value=COMMAND11;
        formObj.cd.value=objValue;
        var param = "&etc1=" +comboObjects[0].GetSelectCode()+ "&etc2=" +comboObjects[1].GetSelectCode();
        var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
        if(arrData[1] == "" || arrData[1] == null) {
            oName.value="";
            oName.focus();
            return false;
        }
        return true;
    }
    // Region
    else if (objValue.length == 3) {
        formObj.f_cmd.value=COMMAND08;
        formObj.cd.value=objValue;
        var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
        if(arrData[1] == "" || arrData[1] == null) {
            oName.value="";
            oName.focus();
            return false;
        }
        return true;
    }
    // Country
    else if(objValue.length == 2) {
        formObj.f_cmd.value=SEARCH07;
        formObj.cd.value=objValue;
        var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
        if(arrData[1] == "" || arrData[1] == null) {
            oName.value="";
            oName.focus();
            return false;
        }
        return true;
    }
}
/**
 * checking validation process of inputed form data <br>
 */ 
function validateForm(sheetObj,formObj,sAction){
     switch (sAction) {
     case IBSEARCH:
         if(formObj.eff_dt.value == "") {
             ComShowCodeMessage("PRI02009");
             formObj.eff_dt.focus();
             return false;
         }
         if((comboObjects[0].GetSelectCode()== "" || comboObjects[0].GetSelectCode()== " ")
         	&& (comboObjects[1].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== " ")
             && formObj.por_def_cd.value == "" && formObj.pol_def_cd.value == "" 
                 && formObj.pod_def_cd.value == "" && formObj.del_def_cd.value == "") {
             ComShowCodeMessage("PRI02010");
             formObj.svc_scp_cd.focus();
             return false;
         }
         break;
  }
    return true;
}

/**
 * set the condition for search <br>
 * @version 2015.09.18
 */  
function makeSearchCondition(){
	
	var formObj = document.form;
	
	var vSvc = svc_scp_cd.GetSelectCode();
	
	var vPor = formObj.por_def_cd.value;
	var vPol = formObj.pol_def_cd.value;
	var vPod = formObj.pod_def_cd.value;
	var vDel = formObj.del_def_cd.value;
	var vVslSlaneCd = formObj.vsl_slan_cd.value;
	
	var vChgCd = chg_cd.GetSelectCode();
	var vRcvTerm = prc_rcv_term_cd.GetSelectCode();
	var vDeTerm = prc_de_term_cd.GetSelectCode();
	
	var vEffDt = ComGetUnMaskedValue(formObj.eff_dt.value,"ymd");
	var vUpdDt = ComGetUnMaskedValue(formObj.upd_dt.value,"ymd");
	
	var vCgoTp = prc_cgo_tp_cd.GetSelectCode();
	var vImdg = scg_imdg_clss_cd.GetSelectCode();
	var vRatUtCd = rat_ut_cd.GetSelectCode();
	var vCntrSzCd = cntr_sz_cd.GetSelectCode();
	
	var vWdrFlg = formObj.wdr_flg.checked;
	
	SearCondition = new Object();
	SearCondition.SVC = vSvc;
	SearCondition.POR = vPor;
	SearCondition.POL = vPol;
	SearCondition.POD = vPod;
	SearCondition.DEL = vDel;
	SearCondition.VSL_SLANE_CD = vVslSlaneCd;
	
	SearCondition.CHG_CD = vChgCd;
	SearCondition.RCV_TERM = vRcvTerm;
	SearCondition.DE_TERM = vDeTerm;
	SearCondition.EFF_DT = vEffDt;
	SearCondition.UPD_DT = vUpdDt;
	
	SearCondition.CGO_CD = vCgoTp;
	SearCondition.IMDG = vImdg;
	SearCondition.RAT_UT_CD = vRatUtCd;
	SearCondition.CNTR_SZ_CD = vCntrSzCd;
	
	
	
	SearCondition.WDR_FLG = vWdrFlg;

}

/**
 * check the condition data of search to the current condition data <br>
 * @version 2015.09.18
 */ 
function isChangeSearchCondition(){
	
	var result = true;
	
	var formObj = document.form;
	
	var vSvc = svc_scp_cd.GetSelectCode();
	
	var vPor = formObj.por_def_cd.value;
	var vPol = formObj.pol_def_cd.value;
	var vPod = formObj.pod_def_cd.value;
	var vDel = formObj.del_def_cd.value;
	var vVslSlaneCd = formObj.vsl_slan_cd.value;
	
	var vChgCd = chg_cd.GetSelectCode();
	var vRcvTerm = prc_rcv_term_cd.GetSelectCode();
	var vDeTerm = prc_de_term_cd.GetSelectCode();
	
	var vEffDt = ComGetUnMaskedValue(formObj.eff_dt.value,"ymd");
	var vUpdDt = ComGetUnMaskedValue(formObj.upd_dt.value,"ymd");
	
	var vCgoTp = prc_cgo_tp_cd.GetSelectCode();
	var vImdg = scg_imdg_clss_cd.GetSelectCode();
	var vRatUtCd = rat_ut_cd.GetSelectCode();
	var vCntrSzCd = cntr_sz_cd.GetSelectCode();
	
	var vWdrFlg = formObj.wdr_flg.checked;
	
	if(vSvc != SearCondition.SVC) return false;
	if(vPor != SearCondition.POR) return false;
	if(vPol != SearCondition.POL) return false;
	if(vPod != SearCondition.POD) return false;
	if(vDel != SearCondition.DEL) return false;
	if(vVslSlaneCd != SearCondition.VSL_SLANE_CD) return false;
	
	if(vChgCd != SearCondition.CHG_CD) return false;
	if(vRcvTerm != SearCondition.RCV_TERM) return false;
	if(vDeTerm != SearCondition.DE_TERM) return false;
	if(vEffDt != SearCondition.EFF_DT) return false;
	if(vUpdDt != SearCondition.UPD_DT) return false;
	
	if(vCgoTp != SearCondition.CGO_CD) return false;
	if(vImdg != SearCondition.IMDG) return false;
	if(vRatUtCd != SearCondition.RAT_UT_CD) return false;
	if(vCntrSzCd != SearCondition.CNTR_SZ_CD) return false;
	if(vWdrFlg != SearCondition.WDR_FLG) return false;
	
	
	return result;
	
}