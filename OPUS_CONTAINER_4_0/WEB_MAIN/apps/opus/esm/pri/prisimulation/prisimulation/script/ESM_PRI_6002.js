/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_6002.js
*@FileTitle  : Verify Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2015/05/08
=========================================================**/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects=new Array();
var sheetCnt=0;

var comboObjects=new Array();
var comboCnt=0;

var formObj;
var gCurrDate;

var backEndCount;
var backEndSuccessCount = 0;
var backEndJobKeys = [];
var backEndJobTimers = [];
var backendJobSuccess = 0;

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name
 */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_new":
            	sheetObjects[0].RemoveAll();
            	sheetObjects[1].RemoveAll();
            	sheetObjects[2].RemoveAll();
            	sheetObjects[3].RemoveAll();
            	formObj.reset();
                formObj.ld_dt.value=gCurrDate;
                eq_tp_cd.RemoveAll();
                formObj.svc_scp_cd.options.length=0;
                ComPriTextCode2ComboItem(eqtTpCdListComboValue, eqtTpCdListComboText, getComboObject(comboObjects, 'eq_tp_cd'),	"|", "\t" );
            	FormDisable("N");
                cgo_tp_cd.SetSelectCode("DR");
                eq_tp_cd.SetSelectCode("D");
                break;
            case "btn_retrieve":
                doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                break;
            case "btn_cost_calc":
                doActionIBSheet(sheetObject1,formObj,SEARCHLIST06);
                break;
            case "btn_por":
            	selectLoc('POR');
            	break;
            case "btn_del":
            	selectLoc('DEL');
            	break;
            case "btn_pol":
            	selectLoc('POL');
            	break;
            case "btn_pod":
            	selectLoc('POD');
                break;
            case "btn_mty_pkup":
            	selectLoc('PKUP');
                break;
            case "btn_mty_rtn":
            	selectLoc('RTN');
                break;
            case "btn_dep_lane":
            	selectLane('DEP');
            	break;
            case "btn_arv_lane":
            	selectLane('ARV');
                break;
            case "btn_sub_trd":
            	var sUrl="/opuscntr/COM_COM_0013.do?code=" + formObj.sub_trd_cd.value + "&main_page=" + "false";
 		        var rVal=ComOpenPopup(sUrl, 750, 410, "get_subTrdCd", "1,0,1", true);
            	break;
            case "btn_agn_bkg_ofc":
            	ComOpenPopup('/opuscntr/COM_ENS_071.do', 800, 500, "findRequestBkgOfc", "1,0,1,1,1,1,1,1", true);
                break;
            case "btn_agn_ctrt_ofc":
            	ComOpenPopup('/opuscntr/COM_ENS_071.do', 800, 500, "findRequestCtrtOfc", "1,0,1,1,1,1,1,1", true);
                break;
            case "btn_calendar":
				var cal=new ComCalendar();
				cal.select(formObj.ld_dt, 'yyyy-MM-dd');
    	        break;
    	    case "btn_commodity": //cmdt_cd
                var param="";
                ComOpenPopup("/opuscntr/COM_ENS_011.do" + param, 780, 445, "getCOM_ENS_011", "0,0,1,1,1,1,1,1", true);
                break;
    	    case "btn_cust":
                var custCd=form.f_agn_ff_cust.value;
                if(form.f_agn_ff_cust.value == ""){
                    custCd="";
                }
                ComOpenPopup("/opuscntr/COM_ENS_041.do?cust_cd="+custCd, 770, 470, "findRequestCust", '1,0,1,1,1,1,1', false);
                break;
    	    case "btn_cm_dtl":
    	    	var cost_dtl_pctl_no="";
    	        var classId="ESM_COA_4006POP";
    	        var param="";
    	        cost_dtl_pctl_no=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "pctl_no");
    	        var dtl_eq_tp_cd = "";
    	        dtl_eq_tp_cd = form.eq_tp_cd.value
    	        param='?pctl_no='+cost_dtl_pctl_no+'&eq_tp_cd='+dtl_eq_tp_cd+'&classId='+classId;
    	        ComOpenPopup("/opuscntr/ESM_COA_4006POP.do"+param, 1100, 650, "", "1,0", false);
    	    	break;
    	    case "btn_excel":

     			if(sheetObjects[0].RowCount() < 1){
     			  ComShowCodeMessage("COM132501");
     			}else{
     				doActionIBSheet(sheetObject1,formObj,IBDOWNEXCEL);
     			}

    			break;
    	    case "btn_apply":
    	    	doActionIBSheet(sheetObjects[1],formObj, "btn_apply");
    	    	break;
    	    case "btn_up":
    	    	sheetObjects[0].SetSheetHeight(sheetObjects[0].GetSheetHeight() - 50);
    	    	sheetObjects[1].SetSheetHeight(sheetObjects[1].GetSheetHeight() + 50);
    	    	sheetObjects[2].SetSheetHeight(sheetObjects[2].GetSheetHeight() + 50);
    	    	break;
    	    case "btn_down":
    	    	sheetObjects[0].SetSheetHeight(sheetObjects[0].GetSheetHeight() + 50);
    	    	sheetObjects[1].SetSheetHeight(sheetObjects[1].GetSheetHeight() - 50);
    	    	sheetObjects[2].SetSheetHeight(sheetObjects[2].GetSheetHeight() - 50);
    	    	break;
    	    case "btn_schg_pop":
    	    	if(document.getElementById("all_charge_btn").innerHTML == "Show Surcharge Selection") setSurchargeSelBtn(true);
    	    	else setSurchargeSelBtn(false);
    	    	break;
    	    	
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBCombo Object as list
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}

/**
 * initializing sheet
 */
function loadPage() {
    formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //Add Environment Setting Function
        ComEndConfigSheet(sheetObjects[i]);
    }
    //Initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    // Axon Event Initialize
    initControl();
    initIBComboItem();

    gCurrDate=ComGetNowInfo('ymd', '-');
    formObj.ld_dt.value=gCurrDate;
    if(formObj.r_classId.value=="ESM_PRI_6002_POP"){
    	initParameta();
    	doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
    }
    setSurchargeSelBtn(false);

    cgo_tp_cd.SetSelectCode("DR");
    eq_tp_cd.SetSelectCode("D");
}

/**
 * Catching events for Axon event.
 */
function initControl() {
    // Process Axon Event No.1, Event Catch
    axon_event.addListenerFormat('beforeactivate', 'obj_onActivate', document.form);
    axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);
    axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
    axon_event.addListenerForm ('change', 'obj_onChange', document.form);
    axon_event.addListenerForm ('blur', 'obj_onBlue', document.form);
}

/**
 * calling function when occurring OnBlur event <br>
 */
function obj_onBlue(){
    var formObj=document.form;
    var elementName=ComGetEvent("name");
    var srcValue=event.srcElement.value;
    switch (elementName) {
	case "por":
		searchAgnBkgOfc(elementName, srcValue);
		break;   
    }
}
/**
 * location code checking validation function <br>
 */  
function searchAgnBkgOfc(objName, objValue) {
    var formObj=document.form;
    var sheetObj = sheetObjects[0];
    var oName=eval("document.form." + objName);
    // Location
    if(objValue.length == 5) {
    	formObj.por.value=objValue;
    	formObj.f_cmd.value=SEARCH05;
    	var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do", FormQueryString(formObj));
    	var f_agn_bkg_ofc_cd = "";
    	f_agn_bkg_ofc_cd = ComGetEtcData(sXml, "f_agn_bkg_ofc_cd");
    	if(f_agn_bkg_ofc_cd == undefined || f_agn_bkg_ofc_cd == null ) {
    		formObj.f_agn_bkg_ofc_cd.value="";
    	} else {
    		
    		formObj.f_agn_bkg_ofc_cd.value=f_agn_bkg_ofc_cd
    	}
            return false;
        }
        return true;
    }
/**
 * setting Item in IBMultiCombo<br>
 */
function initIBComboItem() {
    ComPriTextCode2ComboItem(cgoTpCdListComboValue, cgoTpCdListComboText, getComboObject(comboObjects, 'cgo_tp_cd'),	"|", "\t" );
    ComPriTextCode2ComboItem(eqtTpCdListComboValue, eqtTpCdListComboText, getComboObject(comboObjects, 'eq_tp_cd'),	"|", "\t" );
    ComPriTextCode2ComboItem(gohCdListComboValue,   gohCdListComboText,   getComboObject(comboObjects, 'goh_cd'),		"|", "\t" );
    ComPriTextCode2ComboItem(trnsModComboValue,   	trnsModComboText,	getComboObject(comboObjects, 'org_trns_mod_cd'),		"|", "\t" );
    ComPriTextCode2ComboItem(trnsModComboValue,   	trnsModComboText,	getComboObject(comboObjects, 'dest_trns_mod_cd'),		"|", "\t" );
}

/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets  <br>
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle0="Flag|Trade|Sub\nTrade|Service\nLane|Cargo\nCutoff\nTime|eCom T/T|eCom T/T|Total\nTrans.\nTime|Cargo\nAvail.\nTime|Ocean\nPriority|EPP A|EPP A|EPP A|EPP A|EPP A|EPP A|EPP A|EPP A|EPP B|EPP B|EPP B|EPP B|EPP B|EPP B|EPP B|EPP B|Eqt.\nType|POR|POR|Inter\nChange|POL|POL|T/S Route|POD|POD|Inter\nChange|DEL|DEL|Trans Mode|Trans Mode|Remarks|pctl_no|cost_flg|mis_avg_flg_20|mis_avg_flg_40|mis_avg_flg_45|mis_avg_flg_70";
				var HeadTitle1="Flag|Trade|Sub\nTrade|Service\nLane|Cargo\nCutoff\nTime|Ocean|Total|Total\nTrans.\nTime|Cargo\nAvail.\nTime|Ocean\nPriority|Cost|Cost|Cost|Cost|CM|CM|CM|CM|Cost|Cost|Cost|Cost|CM|CM|CM|CM|Eqt.\nType|POR|POR|Inter\nChange|POL|POL|T/S Route|POD|POD|Inter\nChange|DEL|DEL|ORG|DEST|Remarks|pctl_no|cost_flg|mis_avg_flg_20|mis_avg_flg_40|mis_avg_flg_45|mis_avg_flg_70";
				var HeadTitle2="Flag|Trade|Sub\nTrade|Service\nLane|Cargo\nCutoff\nTime|Ocean|Total|Total\nTrans.\nTime|Cargo\nAvail.\nTime|Ocean\nPriority|2|4|5|7|2|4|5|7|2|4|5|7|2|4|5|7|Eqt.\nType|POR|POR|Inter\nChange|POL|POL|T/S Route|POD|POD|Inter\nChange|DEL|DEL|ORG|DEST|Remarks|pctl_no|cost_flg|mis_avg_flg_20|mis_avg_flg_40|mis_avg_flg_45|mis_avg_flg_70";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:30, FrozenCol:0, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},
				                { Text:HeadTitle1, Align:"Center"},
								{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",Hidden:1, Width:30,		Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",	Hidden:0, Width:45,		Align:"Center",  ColMerge:0,   SaveName:"trd_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:40,		Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:45,		Align:"Center",  ColMerge:0,   SaveName:"slan_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:105,		Align:"Center",  ColMerge:0,   SaveName:"cct",			KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cml_ocn_tztm_hrs",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"cml_inlnd_tztm_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"ttl_tztm_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:105,		Align:"Center",  ColMerge:0,   SaveName:"cgo_aval_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",  Hidden:0, Width:45,   	Align:"Center",  ColMerge:1,  SaveName:"ocn_rout_prio_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },				             
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:45,		Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:1, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"por_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:65,		Align:"Center",  ColMerge:0,   SaveName:"por_nod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"ob_itchg_ctnt",KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:1, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"pol_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:65,		Align:"Center",  ColMerge:0,   SaveName:"pol_nod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:60,	Align:"Center",  ColMerge:0,   SaveName:"ts_route",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:1, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"pod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:65,		Align:"Center",  ColMerge:0,   SaveName:"pod_nod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"ib_itchg_ctnt",KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:1, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"del_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:65,		Align:"Center",  ColMerge:0,   SaveName:"del_nod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:35,		Align:"Center",  ColMerge:0,   SaveName:"r_org_trns_mod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:35,		Align:"Center",  ColMerge:0,   SaveName:"r_dest_trns_mod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"rmk",			KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:150,		Align:"Center",  ColMerge:0,   SaveName:"pctl_no",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cost_flg",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"mis_avg_flg_20",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"mis_avg_flg_40",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"mis_avg_flg_45",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"mis_avg_flg_70",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];

                 InitColumns(cols);
                 SetEditable(0);
                 SetWaitImageVisible(0);
                 SetAutoRowHeight(0);
                 SetSheetHeight(380);
                 SetColBackColor("estm_cm_cost_amt_20","#FFF0F5");
                 SetColBackColor("estm_cm_cost_amt_40","#FFF0F5");
                 SetColBackColor("estm_cm_cost_amt_45","#FFF0F5");
                 SetColBackColor("estm_cm_cost_amt_70","#FFF0F5");
                 SetColBackColor("estm_cm_amt_20","#FFFACD");
                 SetColBackColor("estm_cm_amt_40","#FFFACD");
                 SetColBackColor("estm_cm_amt_45","#FFFACD");
                 SetColBackColor("estm_cm_amt_70","#FFFACD");
                 SetColBackColor("estm_cm_cost_amt2_20","#FFF0F5");
                 SetColBackColor("estm_cm_cost_amt2_40","#FFF0F5");
                 SetColBackColor("estm_cm_cost_amt2_45","#FFF0F5");
                 SetColBackColor("estm_cm_cost_amt2_70","#FFF0F5");
                 SetColBackColor("estm_cm_amt2_20","#FFFACD");
                 SetColBackColor("estm_cm_amt2_40","#FFFACD");
                 SetColBackColor("estm_cm_amt2_45","#FFFACD");
                 SetColBackColor("estm_cm_amt2_70","#FFFACD");
	             SetColProperty("ttl_tztm_hrs", {AcceptKeys:"N", Format:"##D##H"} );
	             SetColProperty("cml_ocn_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
	             SetColProperty("cml_inlnd_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
                 SetHeaderRowHeight(18);
            }
			break;
		case "sheet2":
			with(sheetObj) {

		        var HeadTitle1="Charge\nCode|Amount(USD)|Amount(USD)|Amount(USD)|Amount(USD)|Apply|Percent\nBase|PCTL_NO|PC_CHG|20|40|45|70|20|40|45|70|qty";
		        var HeadTitle2="Charge\nCode|2|4|5|7|Apply|Percent\nBase|PCTL_NO|PC_CHG|20|40|45|70|20|40|45|70|qty";

		        SetConfig( { SearchMode:2, MergeSheet:5, Page:30, DataRowMerge:0 } );
  		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
  		        var headers = [ { Text:HeadTitle1, Align:"Center"},
								{ Text:HeadTitle2, Align:"Center"} ];

		        InitHeaders(headers, info);

		        var cols = [ {Type:"Text",		Hidden:0,	Width:80,   Align:"Center",	ColMerge:0,	SaveName:"chg_cd",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d20",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d40",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d45",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d70",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"CheckBox",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:0,	SaveName:"apply",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
  			                 {Type:"Text",		Hidden:0,	Width:40,   Align:"Center",	ColMerge:0,	SaveName:"pc"	,		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		                     {Type:"Text",		Hidden:1,	Width:80,   Align:"Center",	ColMerge:0,	SaveName:"pctl_no",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		                     {Type:"Text",		Hidden:1,	Width:80,   Align:"Center",	ColMerge:0,	SaveName:"pc_chg",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		                     {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d20_init",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d40_init",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d45_init",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d70_init",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
		                     {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d20_tot",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d40_tot",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d45_tot",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"d70_tot",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"Text",		Hidden:1,	Width:10,   Align:"Center",	ColMerge:0,	SaveName:"sel"	,		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:1,	Width:120,  Align:"Left",	ColMerge:0,	SaveName:"rat_as_qty",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 }
  			               ];

	      	    InitColumns(cols);
    		    SetEditable(1); 
                SetWaitImageVisible(0);
                SetSheetHeight(200);
                SetHeaderRowHeight(12);
                SetCountPosition(0);
            }

			break;
		case "sheet3":
			with(sheetObj) {

		        var HeadTitle1="Charge Code|Apply";

		        SetConfig( { SearchMode:2, MergeSheet:5, Page:30, DataRowMerge:0 } );
  		        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
  		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];

		        InitHeaders(headers, info);

		        var cols = [ {Type:"Text",		Hidden:0,	Width:120,  Align:"Center",	ColMerge:0,	SaveName:"chg_cd",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"CheckBox",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:0,	SaveName:"apply",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:0 }
  			               ];

	      	    InitColumns(cols);
    		    SetEditable(1);
                SetWaitImageVisible(0);
                SetSheetHeight(200);
                SetCountPosition(0);
            }
			break;
		case "sheet4":
			with(sheetObj) {

			var HeadTitle0="Flag|Trade|Sub\nTrade|Service\nLane|Cargo\nCutoff\nTime|eCom T/T|eCom T/T|Total\nTrans.\nTime|Cargo\nAvail.\nTime|Ocean\nPriority|EPP A|EPP A|EPP A|EPP A|EPP A|EPP A|EPP A|EPP A|EPP B|EPP B|EPP B|EPP B|EPP B|EPP B|EPP B|EPP B|Eqt.\nType|POR|Inter\nChange|POL|T/S Route|POD|Inter\nChange|DEL|Remarks|pctl_no|cost_flg";
			var HeadTitle1="Flag|Trade|Sub\nTrade|Service\nLane|Cargo\nCutoff\nTime|Ocean|Total|Total\nTrans.\nTime|Cargo\nAvail.\nTime|Ocean\nPriority|Cost|Cost|Cost|Cost|CM|CM|CM|CM|Cost|Cost|Cost|Cost|CM|CM|CM|CM|Eqt.\nType|POR|Inter\nChange|POL|T/S Route|POD|Inter\nChange|DEL|Remarks|pctl_no|cost_flg";
			var HeadTitle2="Flag|Trade|Sub\nTrade|Service\nLane|Cargo\nCutoff\nTime|Ocean|Total|Total\nTrans.\nTime|Cargo\nAvail.\nTime|Ocean\nPriority|2|4|5|7|2|4|5|7|2|4|5|7|2|4|5|7|Eqt.\nType|POR|Inter\nChange|POL|T/S Route|POD|Inter\nChange|DEL|Remarks|pctl_no|cost_flg";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:30, FrozenCol:0, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"},
			                { Text:HeadTitle1, Align:"Center"},
							{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",Hidden:1, Width:30,		Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",	Hidden:0, Width:45,		Align:"Center",  ColMerge:0,   SaveName:"trd_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:40,		Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:45,		Align:"Center",  ColMerge:0,   SaveName:"slan_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:105,		Align:"Center",  ColMerge:0,   SaveName:"cct",			KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cml_ocn_tztm_hrs",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"cml_inlnd_tztm_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"ttl_tztm_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:105,		Align:"Center",  ColMerge:0,   SaveName:"cgo_aval_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",  Hidden:0, Width:45,   	Align:"Center",  ColMerge:1,  SaveName:"ocn_rout_prio_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },				             
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_cost_amt2_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_20",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_40",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_45",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",	Hidden:0, Width:60,		Align:"Right",  ColMerge:0,   SaveName:"estm_cm_amt2_70",	KeyField:0,   CalcLogic:"",   Format:"float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:45,		Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"por_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"ob_itchg_ctnt",KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"pol_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,	Align:"Center",  ColMerge:0,   SaveName:"ts_route",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"pod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"ib_itchg_ctnt",KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"del_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"rmk",			KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",  Hidden:1, Width:150,		Align:"Center",  ColMerge:0,   SaveName:"pctl_no",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cost_flg",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];

             InitColumns(cols);
//             SetEditable(0);
//             SetWaitImageVisible(0);
//             SetAutoRowHeight(0);
//             SetSheetHeight(380);
//             SetColBackColor("estm_cm_cost_amt_20","#FFF0F5");
//             SetColBackColor("estm_cm_cost_amt_40","#FFF0F5");
//             SetColBackColor("estm_cm_cost_amt_45","#FFF0F5");
//             SetColBackColor("estm_cm_cost_amt_70","#FFF0F5");
//             SetColBackColor("estm_cm_amt_20","#FFFACD");
//             SetColBackColor("estm_cm_amt_40","#FFFACD");
//             SetColBackColor("estm_cm_amt_45","#FFFACD");
//             SetColBackColor("estm_cm_amt_70","#FFFACD");
//             SetColBackColor("estm_cm_cost_amt2_20","#FFF0F5");
//             SetColBackColor("estm_cm_cost_amt2_40","#FFF0F5");
//             SetColBackColor("estm_cm_cost_amt2_45","#FFF0F5");
//             SetColBackColor("estm_cm_cost_amt2_70","#FFF0F5");
//             SetColBackColor("estm_cm_amt2_20","#FFFACD");
//             SetColBackColor("estm_cm_amt2_40","#FFFACD");
//             SetColBackColor("estm_cm_amt2_45","#FFFACD");
//             SetColBackColor("estm_cm_amt2_70","#FFFACD");
//             SetColProperty("ttl_tztm_hrs", {AcceptKeys:"N", Format:"##D##H"} );
//             SetColProperty("cml_ocn_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
//             SetColProperty("cml_inlnd_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
//             SetHeaderRowHeight(18);
            }

			break;
		}
}

/**
 * setting intial combo value <br>
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "cgo_tp_cd":
            with(comboObj) {
                SetDropHeight(260);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(2);
                SetUseAutoComplete(1);
                SetColAlign(0, "center");
                ValidChar(2);	// Uppercase, Alphabet Only
            }
            break;
        case "eq_tp_cd":
            with(comboObj) {
                SetDropHeight(260);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(1);
                SetUseAutoComplete(1);
                ValidChar(2);	// Uppercase, Alphabet Only
            }
            break;
        case "goh_cd":
        	with(comboObj) {
            	SetDropHeight(260);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetMaxLength(1);
            	SetUseAutoComplete(1);
            	ValidChar(2);	// Uppercase, Alphabet Only
            }
        	break;
    }
}

/**
 * Handling sheet's processes <br>
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetObject4=sheetObjects[3];
    try {
        switch (sAction) {
            case IBSEARCH: // retrieving
            	
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                formObj.trf_schg_chk.checked = false;
                
                formObj.f_cmd.value=SEARCHLIST02;

                ComOpenWait(true);
                
                setTimeout(function(){
                	var sXml=sheetObject4.GetSearchData("ESM_PRI_6002GS.do", FormQueryString(formObj));
                	var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                	var f_pctl_no = ComGetEtcData(sXml, "F_PCTL_NO");
                	formObj.f_pctl_no.value = f_pctl_no;
                	var svc_scp_cd = ComGetEtcData(sXml, "svc_scp");

                	if(svc_scp_cd!=null && svc_scp_cd!=""){
                		// Service Scope setting
                		var rName=svc_scp_cd.split("$");
                		var rCode='';
                		var _first=false;
                		for ( var j=0; j < rName.length; j++) {
                			if (_first) {
                				rCode += '$';
                			}
                			rCode += rName[j].substring(0, 3);
                			_first=true;
                		}
                		//- svc_scp_cd setting
                		var r_value=rCode + "^" + svc_scp_cd;
                		fnSetComboBox('svc_scp_cd', r_value, '');
                	}
            		
                	sheetObject4.LoadSearchData(sXml,{Sync:1} );
                	
                	if(transResultKey!="S"){
                		ComOpenWait(false);
                	}
                },100);
                
                break;

            case SEARCH01:
            	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCHLIST01;
            	var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do", FormQueryString(formObj));
                var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                var f_pctl_no = ComGetEtcData(sXml, "F_PCTL_NO");
                formObj.f_pctl_no.value = f_pctl_no;
//				if (backendJobKey != null && backendJobKey.length > 0) {
//					ComSetObjValue(formObj.backendjob_key, backendJobKey);
//					sheetObj.RequestTimeOut = 7200; //초 - 2시간
//					backEndJobTimer = setInterval(getBackEndJobStatus, 1000);	//밀리초  - 10초
//				}
              //multi backendjob ................
                backEndCount = 0;
                backEndSuccessCount = 0;
                backEndJobKeys = [];
                backEndJobTimers = [];
                backendJobSuccess = 0;
            	
                backEndJobKeys = backendJobKey.split("$");
				if (backendJobKey != null && backendJobKey.length > 0) {
					
					for(var i=0; i < backEndJobKeys.length; i++){
						if(backEndJobKeys[i] == "")	continue;
						
//						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 7200; //초 - 2시간
						backEndJobTimers[i] = setInterval(getBackEndJobStatus, 100, i, backEndJobKeys[i]);	//밀리초  - 10초
						backEndCount++;
					}
				}
                break;

            case SEARCHLIST06:
            	if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
            	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCHLIST06;
            	var sParam = FormQueryString(formObj) +"&"+ sheetObj.GetSaveString(1);
            	
            	var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do", sParam);
            	//multi backendjob ................
                backEndCount = 0;
                backEndSuccessCount = 0;
                backEndJobKeys = [];
                backEndJobTimers = [];
                backendJobSuccess = 0;
            	
                var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                backEndJobKeys = backendJobKey.split("$");
                var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                if(transResultKey=="F"){
     				sheetObj.LoadSaveData(sXml);
					ComOpenWait(false);
					break;
     			}
                
                
				if (backendJobKey != null && backendJobKey.length > 0) {
					
					for(var i=0; i < backEndJobKeys.length; i++){
						if(backEndJobKeys[i] == "")	continue;
						
//						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 7200; //초 - 2시간
						backEndJobTimers[i] = setInterval(getBackEndJobStatus, 100, i, backEndJobKeys[i]);	//밀리초  - 10초
						backEndCount++;
					}
				}
				break;
            case SEARCHLIST07:
            	if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
            	
            	if(sheetObject4.RowCount()<1){	//prd 는 생성되었으나, svc lane, trans mode 등의 이유로 조회된 route 가 없는 경우.
            		ComOpenWait(false);
            		ComShowCodeMessage('PRI00018');
            		return false;
            	}
            	
            	formObj.f_cmd.value=SEARCHLIST06;
            	
            	
            	var sParam = FormQueryString(formObj) +"&"+ sheetObject4.GetSaveString(1);
            	
            	var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do", sParam);
            	
            	//multi backendjob ................
                backEndCount = 0;
                backEndSuccessCount = 0;
                backEndJobKeys = [];
                backEndJobTimers = [];
                backendJobSuccess = 0;
            	
                var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                backEndJobKeys = backendJobKey.split("$");
                var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                if(transResultKey=="F"){
     				sheetObj.LoadSaveData(sXml);
					ComOpenWait(false);
					break;
     			}
                
                
				if (backendJobKey != null && backendJobKey.length > 0) {
					
					for(var i=0; i < backEndJobKeys.length; i++){
						if(backEndJobKeys[i] == "")	continue;
						
//						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 7200; //초 - 2시간
						backEndJobTimers[i] = setInterval(getBackEndJobStatus, 100, i, backEndJobKeys[i]);	//밀리초  - 10초
						backEndCount++;
					}
				}
				break;

            case SEARCH02:
            	// Subject To Tariff Surcharge checked
            	if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
            	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH02;
            	var sParam = FormQueryString(formObj) +"&"+ sheetObjects[0].GetSaveString(1);
    			var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do", sParam);
    			var key=ComGetEtcData(sXml, "BackEndJobKey");
    			// top.document.body.scrollTop = 0;
    			intervalId=setInterval("doActionValidationResult(sheetObjects[1], '" + key + "');", 3000);
            	break;

            case IBDOWNEXCEL:
            	var excelType=selectDownExcelMethod(sheetObj);
            	break;
            case "btn_apply":
    	    	if (sheetObjects[2].RowCount() < 1) return;
                ComOpenWait(true);
                setTimeout( function () {
                
	    	    	for (var i = sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++)
	    	    	{
	    	    		var arrRow=ComFindText(sheetObjects[1], "chg_cd", sheetObjects[2].GetCellValue(i, "chg_cd"));
	    	    		
	    	    		for (var j=0; j<arrRow.length; j++) {
	    	    			sheetObjects[1].SetCellValue(arrRow[j], "apply", sheetObjects[2].GetCellValue(i, "apply"));
		    				sheetObjects[1].SetCellValue(arrRow[j], "sel",   sheetObjects[2].GetCellValue(i, "apply"));
	    	    		}
	    	    	}
    	    		setSheet2Hidden();
                    ComOpenWait(false);
                } , 100);
    	    	setSurchargeSelBtn(false);
                break;

            case SEARCH04:

            	formObj.f_cmd.value=SEARCH04;
    			sheetObj.DoSearch("ESM_PRI_6002GS.do", FormQueryString(formObj));
    			
                break;
        }
    }catch(e){
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * handling process for input validation <br>
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH: // retrieving
//    	if(sheetObj.RowCount()>0){
//    		if(!ComShowConfirm(ComGetMsg("PRI07003"))){
//    			return false;
//
//    		}
//    	}
    	if (!ComChkValid(formObj))
            return false;
    	if(cgo_tp_cd.GetSelectCode()==""){
    		ComShowCodeMessage("PRI00308", "select", "Cargo Type");
    		cgo_tp_cd.Focus();
    		return false;
    	}
    	if(eq_tp_cd.GetSelectCode()==""){
    		ComShowCodeMessage("PRI00308", "select", "Eqt Type");
    		eq_tp_cd.Focus();
    		return false;
    	}
        break;

    case SEARCHLIST06:
    	if(sheetObj.GetCellValue(sheetObj.LastRow(),"cost_flg")=="Y"){
    		ComShowCodeMessage("PRI07004");
    		return false;
    	}
    	break;

    case SEARCH02:
    	if(sheetObj.RowCount() < 1) {
    		ComShowCodeMessage("COM132701");
    	}

    	break;
    }
    return true;
}

/**
 * Calling Function in case of OnChange event <br>
 */
function cgo_tp_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, text, code){
    eq_tp_cd.RemoveAll();

    if(code=="DR"){
    	eq_tp_cd.InsertItem(1, "D", "D");
    	eq_tp_cd.InsertItem(2, "R", "R");
    	eq_tp_cd.InsertItem(3, "T", "T");
    }else if(code=="DG"){
    	eq_tp_cd.InsertItem(1, "D", "D");
    	eq_tp_cd.InsertItem(2, "R", "R");
    	eq_tp_cd.InsertItem(3, "F", "F");
    	eq_tp_cd.InsertItem(4, "T", "T");
    }else if(code=="RF"){
    	eq_tp_cd.InsertItem(1, "R", "R");
    	eq_tp_cd.InsertItem(2, "T", "T");
    }else if(code=="AK"){
    	eq_tp_cd.InsertItem(1, "F", "F");
    	eq_tp_cd.InsertItem(2, "A", "A");
    	eq_tp_cd.InsertItem(3, "O", "O");
    	eq_tp_cd.InsertItem(4, "S", "S");
    }else if(code=="BB"){
    	eq_tp_cd.InsertItem(1, "F", "F");
    	eq_tp_cd.InsertItem(2, "A", "A");
    }else{
    	ComPriTextCode2ComboItem(eqtTpCdListComboValue, eqtTpCdListComboText, getComboObject(comboObjects, 'eq_tp_cd'),	"|", "\t" );
    }
}

/**
 * handling OnBeforeActivate event<br>
 */
function obj_onActivate() {
    var srcName=ComGetEvent("name");
    ComClearSeparator (ComGetEvent());
}

/*-popup---------------------------------------------------------------*/
var locInd='';
function selectLoc(pt){
	var param='?loc_port_ind=1';
	locInd=pt;
	if(locInd == 'POR'){
      param=param+'&loc_cd='+formObj.por.value;
	}else if(locInd == 'POL'){
		param=param+'&loc_cd='+formObj.pol.value;
	}else if(locInd == 'POD'){
		param=param+'&loc_cd='+formObj.pod.value;
	}else if(locInd == 'DEL'){
	  param=param+'&loc_cd='+formObj.del.value;
	}else if(locInd == 'PKUP'){
		param=param+'&loc_cd='+formObj.f_mty_pkup_yd_cd.value;
	}else if(locInd == 'RTN'){
		param=param+'&loc_cd='+formObj.f_mty_rtn_yd_cd.value;
	}else{
		return;
	}
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 810, 500, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}

function getLoc(rowArray) {
	var colArray=rowArray[0];
	var rtnLod=colArray[3];
	if(locInd == 'POR'){
		formObj.por.value=rtnLod;
	}else if(locInd == 'POL'){
		formObj.pol.value=rtnLod;
	}else if(locInd == 'POD'){
		formObj.pod.value=rtnLod;
	}else if(locInd == 'DEL'){
		formObj.del.value=rtnLod;
	}else if(locInd == 'PKUP'){
		formObj.f_mty_pkup_yd_cd.value=rtnLod;
	}else if(locInd == 'RTN'){
		formObj.f_mty_rtn_yd_cd.value=rtnLod;
	}
}
/*----------------------------------------------------------------*/
var laneInd='';
function selectLane(pt) {
    var param='?';
    laneInd=pt;
    if(laneInd == 'DEP'){
    	param=param+'&lane_cd='+formObj.dep_lane.value;
	}else if(laneInd == 'ARV'){
		param=param+'&lane_cd='+formObj.arv_lane.value;
	}
    ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800,400,'getLane',"1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getLane(rowArray) {
	var colArray=rowArray[0];
	if(laneInd == 'DEP'){
    	document.form.dep_lane.value=colArray[3];
	}else if(laneInd == 'ARV'){
		document.form.arv_lane.value=colArray[3];
	}
}
/**
 * Returning select value of Rep. Commodity pop-up <br>
 */
function getCOM_ENS_011(rowArray){
    var colArray=rowArray[0];
    formObj.cmdt_cd.value=colArray[2]; // Commodity - cmdt_cd
}
/**
 *  CallBack function for getting Actual Coustomer, Coustomer code <br>
 */
function callBackComEns041(rArray){
    if(rArray != null){
        var colArray=rArray[0];
        var ctrtCustCntCd=colArray[3].substring(0,2);
        var ctrtCustSeq=ComLpad(colArray[3].substring(2),6,"0");
            formObj.cust_cnt_cd.value=ctrtCustCntCd;
            formObj.cust_seq.value=ctrtCustSeq;
        }
    }
function get_subTrdCd(rowArray) {
	   	var colArray=rowArray[0];
     	formObj.sub_trd_cd.value=colArray[3];
   }

/*----------------------------------------------------------------*/

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		sheetObj.SetCellValue(i, "cntr_tp_cd", eq_tp_cd.GetSelectCode());
	}
	
	for (i=3;i<=sheetObj.RowCount()+3;i++) {
		if(sheetObj.GetCellValue(i,"mis_avg_flg_20")=="1"){
    		sheetObj.SetCellFontColor(i, "estm_cm_cost_amt_20","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt_20","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_cost_amt2_20","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt2_20","#FF0000");
    	}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_40")=="1"){
			sheetObj.SetCellFontColor(i, "estm_cm_cost_amt_40","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt_40","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_cost_amt2_40","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt2_40","#FF0000");
    	}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_45")=="1"){
			sheetObj.SetCellFontColor(i, "estm_cm_cost_amt_45","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt_45","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_cost_amt2_45","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt2_45","#FF0000");
    	}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_70")=="1"){
			sheetObj.SetCellFontColor(i, "estm_cm_cost_amt_70","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt_70","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_cost_amt2_70","#FF0000");
    		sheetObj.SetCellFontColor(i, "estm_cm_amt2_70","#FF0000");
    	}
	}
	
	
	var formObj = document.form;
	
	switch (formObj.eq_tp_cd.value)
	{
		case "D":
			sheetObj.SetColHidden("estm_cm_cost_amt_40", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt_45", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt_70", "0");
			
			sheetObj.SetColHidden("estm_cm_amt_40", "0");
			sheetObj.SetColHidden("estm_cm_amt_45", "0");
			sheetObj.SetColHidden("estm_cm_amt_70", "0");

			sheetObj.SetColHidden("estm_cm_cost_amt2_40", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt2_45", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt2_70", "0");
			
			sheetObj.SetColHidden("estm_cm_amt2_40", "0");
			sheetObj.SetColHidden("estm_cm_amt2_45", "0");
			sheetObj.SetColHidden("estm_cm_amt2_70", "0");
			
			sheetObjects[1].SetColHidden("d40", "0");
			sheetObjects[1].SetColHidden("d45", "0");
			sheetObjects[1].SetColHidden("d70", "0");
			
			formObj.f_rv_40.disabled = false;
			formObj.f_rv_45.disabled = false;
			formObj.f_rv_70.disabled = false;
			break;
			
		case "R":
			sheetObj.SetColHidden("estm_cm_cost_amt_40", "1");
			sheetObj.SetColHidden("estm_cm_cost_amt_45", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt_70", "0");
			
			sheetObj.SetColHidden("estm_cm_amt_40", "1");
			sheetObj.SetColHidden("estm_cm_amt_45", "0");
			sheetObj.SetColHidden("estm_cm_amt_70", "0");

			sheetObj.SetColHidden("estm_cm_cost_amt2_40", "1");
			sheetObj.SetColHidden("estm_cm_cost_amt2_45", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt2_70", "0");
			
			sheetObj.SetColHidden("estm_cm_amt2_40", "1");
			sheetObj.SetColHidden("estm_cm_amt2_45", "0");
			sheetObj.SetColHidden("estm_cm_amt2_70", "0");

			sheetObjects[1].SetColHidden("d40", "1");
			sheetObjects[1].SetColHidden("d45", "0");
			sheetObjects[1].SetColHidden("d70", "0");

			formObj.f_rv_40.disabled = true;
			formObj.f_rv_45.disabled = false;
			formObj.f_rv_70.disabled = false;

			break;
			
		case "F":
		case "O":
			
			sheetObj.SetColHidden("estm_cm_cost_amt_40", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt_45", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt_70", "1");
			
			sheetObj.SetColHidden("estm_cm_amt_40", "0");
			sheetObj.SetColHidden("estm_cm_amt_45", "0");
			sheetObj.SetColHidden("estm_cm_amt_70", "1");

			sheetObj.SetColHidden("estm_cm_cost_amt2_40", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt2_45", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt2_70", "1");
			
			sheetObj.SetColHidden("estm_cm_amt2_40", "0");
			sheetObj.SetColHidden("estm_cm_amt2_45", "0");
			sheetObj.SetColHidden("estm_cm_amt2_70", "1");
			
			sheetObjects[1].SetColHidden("d40", "0");
			sheetObjects[1].SetColHidden("d45", "0");
			sheetObjects[1].SetColHidden("d70", "1");

			formObj.f_rv_40.disabled = false;
			formObj.f_rv_45.disabled = false;
			formObj.f_rv_70.disabled = true;

			break;
			
		case "T":
			sheetObj.SetColHidden("estm_cm_cost_amt_40", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt_45", "1");
			sheetObj.SetColHidden("estm_cm_cost_amt_70", "1");
			
			sheetObj.SetColHidden("estm_cm_amt_40", "0");
			sheetObj.SetColHidden("estm_cm_amt_45", "1");
			sheetObj.SetColHidden("estm_cm_amt_70", "1");

			sheetObj.SetColHidden("estm_cm_cost_amt2_40", "0");
			sheetObj.SetColHidden("estm_cm_cost_amt2_45", "1");
			sheetObj.SetColHidden("estm_cm_cost_amt2_70", "1");
			
			sheetObj.SetColHidden("estm_cm_amt2_40", "0");
			sheetObj.SetColHidden("estm_cm_amt2_45", "1");
			sheetObj.SetColHidden("estm_cm_amt2_70", "1");
			
			sheetObjects[1].SetColHidden("d40", "0");
			sheetObjects[1].SetColHidden("d45", "1");
			sheetObjects[1].SetColHidden("d70", "1");

			formObj.f_rv_40.disabled = false;
			formObj.f_rv_45.disabled = true;
			formObj.f_rv_70.disabled = true;
			
			break;
	}

	setTotalCm();
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus(idx, key) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.backendjob_key.value = key;
	formObj.f_cmd.value = SEARCHLIST03;
	var sXml = sheetObj.GetSearchData("ESM_PRI_6002GS.do", FormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	if (jobState == "3") {
		backEndSuccessCount++;
		if(backEndCount == backEndSuccessCount)		backendJobSuccess = 1;
		clearInterval(backEndJobTimers[idx]);
	} else if (jobState == "4") {
		ComShowCodeMessage("PRI07001");
		backendJobSuccess = 2;
		ComOpenWait(false);
		clearInterval(backEndJobTimers[idx]);
	} else if (jobState == "5") {
		ComShowCodeMessage("PRI07002");
		ComOpenWait(false);
		clearInterval(backEndJobTimers[idx]);
	}
	
	if(backendJobSuccess == 1){
		getBackEndJobSearch(key);
	}
}


/**
 * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.
 */
function getBackEndJobSearch(key) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	formObj.backendjob_key.value = key;
	formObj.f_cmd.value = SEARCHLIST04;
	var sXml = sheetObj.GetSearchData("ESM_PRI_6002GS.do", FormQueryString(formObj));
	var err_cd = ComGetEtcData(sXml, "err_cd");
	var err_msg = ComGetEtcData(sXml, "err_msg");

	if (err_cd == "00000") {
		formObj.f_cmd.value = SEARCHLIST05;
		var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do", FormQueryString(formObj));
        sheetObj.LoadSearchData(sXml,{Sync:1} );
        if(formObj.r_classId.value=="ESM_PRI_6002_POP"){
        	formObj.f_count.value = formObj.f_count.value+1;
        }
        ComOpenWait(false);
	} else if (err_cd == "00028") {
        ComOpenWait(false);
		ComShowMessage("ERROR(COA00153): " + err_msg);
	} else{
        ComOpenWait(false);
		ComShowMessage("ERROR(COA00153): " + err_msg);
	}
}

function initParameta(){
	formObj.por.value 	= formObj.r_por.value;
	formObj.rcv_t.options[formObj.rcv_t.selectedIndex].text  =  formObj.r_rcv_t.value;
	formObj.del_t.options[formObj.del_t.selectedIndex].text	= formObj.r_del_t.value;
	formObj.dep_lane.value= formObj.r_dep_lane.value;
	formObj.arv_lane.value= formObj.r_arv_lane.value;
	formObj.del.value 	= formObj.r_del.value;
	formObj.pol.value		= formObj.r_pol.value;
	formObj.pod.value		= formObj.r_pod.value;
	cgo_tp_cd.SetSelectCode(formObj.r_cgo_tp_cd.value);
	eq_tp_cd.SetSelectCode(formObj.r_eq_tp_cd.value);
	formObj.sub_trd_cd.value= formObj.r_sub_trd_cd.value;
	formObj.ld_dt.value	 = formObj.r_ld_dt.value;
	formObj.f_rv_20.value = ComAddComma(formObj.r_ttl_rt2.value);
	formObj.f_rv_40.value = ComAddComma(formObj.r_ttl_rt4.value);
	formObj.f_rv_45.value = ComAddComma(formObj.r_ttl_rt5.value);
	formObj.f_rv_70.value = ComAddComma(formObj.r_ttl_rt7.value);

	if(formObj.r_soc_flg.value=="Y"){
		formObj.soc_flg.checked = true;
	}
	goh_cd.SetSelectCode(formObj.r_goh_cd.value);
	FormDisable("Y");
}

function FormDisable(type){
	if(type=="Y"){
    	ComBtnDisable("btn_schg_pop");
    	cgo_tp_cd.SetEnable(false);
    	eq_tp_cd.SetEnable(false);
    	goh_cd.SetEnable(false);
    	org_trns_mod_cd.SetEnable(false);
    	dest_trns_mod_cd.SetEnable(false);
    	ComEnableManyObjects(false, formObj.por,
    							   formObj.rcv_t,
    							   formObj.del_t,
    							   formObj.dep_lane,
    							   formObj.arv_lane,
    							   formObj.pol,
    							   formObj.pod,
    							   formObj.del,
    							   formObj.eq_tp_cd,
    							   formObj.sub_trd_cd,
    							   formObj.ld_dt,
    							   formObj.f_rv_20,
    							   formObj.f_rv_40,
    							   formObj.f_rv_45,
    							   formObj.f_rv_70,
    							   formObj.soc_flg,
    							   formObj.goh_cd,
    							   formObj.trf_schg_chk,
    							   formObj.svc_scp_cd);
	}else{
		ComBtnEnable("btn_schg_pop");
    	cgo_tp_cd.SetEnable(true);
    	eq_tp_cd.SetEnable(true);
    	goh_cd.SetEnable(true);
    	org_trns_mod_cd.SetEnable(true);
    	dest_trns_mod_cd.SetEnable(true);
    	ComEnableManyObjects(true, formObj.por,
    							   formObj.rcv_t,
    							   formObj.del_t,
    							   formObj.dep_lane,
    							   formObj.arv_lane,
    							   formObj.pol,
    							   formObj.pod,
    							   formObj.del,
    							   formObj.eq_tp_cd,
    							   formObj.sub_trd_cd,
    							   formObj.ld_dt,
    							   formObj.f_rv_20,
    							   formObj.f_rv_40,
    							   formObj.f_rv_45,
    							   formObj.f_rv_70,
    							   formObj.soc_flg,
    							   formObj.goh_cd,
    							   formObj.trf_schg_chk,
    							   formObj.svc_scp_cd);
	}
}

function callBackExcelMethod(excelType){
	var sheetObj = sheetObjects[0];
	switch (excelType) {
	case "AY":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	case "AN":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	case "DY":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	case "DN":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	}
}

//DOWNEXCEL OPTION
function makeHiddenCoaSkipCol(sobj){
    var lc = sobj.LastCol();
    var rtnStr = "";
    for(var i=0;i<=lc;i++){
       if( ! ( sobj.GetCellProperty(0,i,"Type") == "Status" ||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" ) ){
          rtnStr += "|"+ i;
       }
    }
    return rtnStr.substring(1);
}

/**
 * Excel Dowload시 사용
 * 사용 : var rtn = selectDownExcelMethod(sheetObj);
 */
function selectDownExcelMethod(sheetObj, sheetIdx){
	if(sheetObj.RowCount()== 0){
		ComShowCodeMessage("COM132501");
		return "NODATA";
	}

	if (sheetIdx==undefined || sheetIdx==null) {
		sheetIdx="";
	}

	var sFeature="";
	sFeature=sFeature + "dialogHeight:230px;"
	sFeature=sFeature + "dialogWidth:352px;"
	sFeature=sFeature + "center:yes;"
	sFeature=sFeature + "resizable:no;"
	sFeature=sFeature + "scroll:no;"
	sFeature=sFeature + "status:no;"
	setTimeout( function () {
        ComOpenPopup("ESM_COA_3002.do?sheetidx="+sheetIdx, 350, 200, "callBackExcelDown","0,0", true);
     } , 100);
}

function callBackExcelDown(execType) {
	$(document).find(".opus_design_grid").addClass("excelCellColor");
	callBackExcelMethod(execType);
    setTimeout(function(){
        $(document).find(".opus_design_grid").removeClass("excelCellColor");
        },10);
}

function doActionValidationResult(sheetObj, sKey) {
	
	sheetObj.RemoveAll();
	var formObj=document.form;
	var sXml=sheetObj.GetSearchData("ESM_PRI_6002GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");


	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
		return;
	} else if (sJbStsFlg == "FAIL") {
		// Error
		clearInterval(intervalId);
		ComOpenWait(false);
		// Error Message
		var errMsg=ComGetEtcData(sXml, "err_msg");
		if(errMsg!=""){
			ComShowMessage(errMsg);
		}else{
			ComShowCodeMessage("COM132101");
		}
		return;
	} else {
		return;
	}
}

// 전체 CM을 계산한다.
function setTotalCm() {
	if (sheetObjects[0].RowCount() < 1) return;
		
	var formObj = document.form;
	var sheet1 = sheetObjects[0];
	var sheet2 = sheetObjects[1];
	
	var f_rv_20 = formObj.f_rv_20.value;
	var f_rv_40 = formObj.f_rv_40.value;
	var f_rv_45 = formObj.f_rv_45.value;
	var f_rv_70 = formObj.f_rv_70.value;

	if (f_rv_20 == "") f_rv_20 = 0; else f_rv_20 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_20, "float"));
	if (f_rv_40 == "") f_rv_40 = 0; else f_rv_40 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_40, "float"));
	if (f_rv_45 == "") f_rv_45 = 0; else f_rv_45 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_45, "float"));
	if (f_rv_70 == "") f_rv_70 = 0; else f_rv_70 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_70, "float"));
	
	for (var i = sheet1.HeaderRows(); i <= sheet1.LastRow(); i++)
	{
//		if (sheet1.GetCellValue(i, "estm_cm_cost_amt_20") == "") break; 
		if (sheet1.GetCellValue(i, "cost_flg") == "") continue; 
		
		var cm_amt_20 = "";
		var cm_amt_40 = "";
		var cm_amt_45 = "";
		var cm_amt_70 = "";
		var cm_amt2_20 = "";
		var cm_amt2_40 = "";
		var cm_amt2_45 = "";
		var cm_amt2_70 = "";
		
		var estm_cm_cost_amt_20 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt_20");
		var estm_cm_cost_amt_40 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt_40");
		var estm_cm_cost_amt_45 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt_45");
		var estm_cm_cost_amt_70 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt_70");
		var estm_cm_cost_amt2_20 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt2_20");
		var estm_cm_cost_amt2_40 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt2_40");
		var estm_cm_cost_amt2_45 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt2_45");
		var estm_cm_cost_amt2_70 = sheetObjects[0].GetCellValue (i, "estm_cm_cost_amt2_70");
		var d20 = 0;
		var d40 = 0;
		var d45 = 0;
		var d70 = 0;
		
		for (var j = sheet2.HeaderRows(); j <= sheet2.LastRow(); j++)
		{
			if (sheet1.GetCellValue(i, "pctl_no") == sheet2.GetCellValue(j, "pctl_no"))
			{
				if (sheet2.GetCellValue (j, "apply") == "1")
				{
					d20 += sheet2.GetCellValue (j, "d20");
					d40 += sheet2.GetCellValue (j, "d40");
					d45 += sheet2.GetCellValue (j, "d45");
					d70 += sheet2.GetCellValue (j, "d70");
				}
			}
		}
		
		cm_amt_20 += f_rv_20 + d20 - estm_cm_cost_amt_20;
		cm_amt_40 += f_rv_40 + d40 - estm_cm_cost_amt_40;
		cm_amt_45 += f_rv_45 + d45 - estm_cm_cost_amt_45;
		cm_amt_70 += f_rv_70 + d70 - estm_cm_cost_amt_70;
		
		cm_amt2_20 += f_rv_20 + d20 - estm_cm_cost_amt2_20;
		cm_amt2_40 += f_rv_40 + d40 - estm_cm_cost_amt2_40;
		cm_amt2_45 += f_rv_45 + d45 - estm_cm_cost_amt2_45;
		cm_amt2_70 += f_rv_70 + d70 - estm_cm_cost_amt2_70;

		sheet1.SetCellValue (i, "estm_cm_amt_20", cm_amt_20);
		sheet1.SetCellValue (i, "estm_cm_amt_40", cm_amt_40);
		sheet1.SetCellValue (i, "estm_cm_amt_45", cm_amt_45);
		sheet1.SetCellValue (i, "estm_cm_amt_70", cm_amt_70);
		
		sheet1.SetCellValue (i, "estm_cm_amt2_20", cm_amt2_20);
		sheet1.SetCellValue (i, "estm_cm_amt2_40", cm_amt2_40);
		sheet1.SetCellValue (i, "estm_cm_amt2_45", cm_amt2_45);
		sheet1.SetCellValue (i, "estm_cm_amt2_70", cm_amt2_70);
	}
}

// PC 의 경우 Charge 계산
function setPcChg(sheet2, Row) {
	
	if (sheet2.FindText("pc", "PC") == -1) return;
		
	var formObj = document.form;
	var f_rv_20 = formObj.f_rv_20.value;
	var f_rv_40 = formObj.f_rv_40.value;
	var f_rv_45 = formObj.f_rv_45.value;
	var f_rv_70 = formObj.f_rv_70.value;

	if (f_rv_20 == "") f_rv_20 = 0; else f_rv_20 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_20, "float"));
	if (f_rv_40 == "") f_rv_40 = 0; else f_rv_40 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_40, "float"));
	if (f_rv_45 == "") f_rv_45 = 0; else f_rv_45 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_45, "float"));
	if (f_rv_70 == "") f_rv_70 = 0; else f_rv_70 = parseFloat(ComGetUnMaskedValue(formObj.f_rv_70, "float"));
	
	for (var i = sheet2.HeaderRows(); i <= sheet2.LastRow(); i++)
	{
		var d20_init = sheet2.GetCellValue(i, "d20_init");
		var d40_init = sheet2.GetCellValue(i, "d40_init");
		var d45_init = sheet2.GetCellValue(i, "d45_init");
		var d70_init = sheet2.GetCellValue(i, "d70_init");

		// OFT 가 있으면 Revenue를 더한다.
		if (sheet2.GetCellValue(i, "pc_chg").indexOf("OFT") != -1)
		{
			d20_init += parseFloat(f_rv_20);
			d40_init += parseFloat(f_rv_40);
			d45_init += parseFloat(f_rv_45);
			d70_init += parseFloat(f_rv_70);
			
			sheet2.SetCellValue(i, "d20_tot", d20_init);
			sheet2.SetCellValue(i, "d40_tot", d40_init);
			sheet2.SetCellValue(i, "d45_tot", d45_init);
			sheet2.SetCellValue(i, "d70_tot", d70_init);
		}
	}

	for (var i = sheet2.HeaderRows(); i <= sheet2.LastRow(); i++)
	{
		var d20_tot = sheet2.GetCellValue(i, "d20_tot");
		var d40_tot = sheet2.GetCellValue(i, "d40_tot");
		var d45_tot = sheet2.GetCellValue(i, "d45_tot");
		var d70_tot = sheet2.GetCellValue(i, "d70_tot");
		
		if (sheet2.GetCellValue(i, "pc_chg").indexOf(sheet2.GetCellValue(Row, "chg_cd")) != -1)
		{
			if (sheet2.GetCellValue(Row, "pctl_no") == sheet2.GetCellValue(i, "pctl_no"))
			{
				if (sheet2.GetCellValue(Row, "apply") == "0")
				{
					d20_tot = d20_tot - sheet2.GetCellValue(Row, "d20");
					d40_tot = d40_tot - sheet2.GetCellValue(Row, "d40");
					d45_tot = d45_tot - sheet2.GetCellValue(Row, "d45");
					d70_tot = d70_tot - sheet2.GetCellValue(Row, "d70");
				}
				sheet2.SetCellValue(i, "d20", d20_tot * sheet2.GetCellValue(i, "rat_as_qty") / 100);
				sheet2.SetCellValue(i, "d40", d40_tot * sheet2.GetCellValue(i, "rat_as_qty") / 100);
				sheet2.SetCellValue(i, "d45", d45_tot * sheet2.GetCellValue(i, "rat_as_qty") / 100);
				sheet2.SetCellValue(i, "d70", d70_tot * sheet2.GetCellValue(i, "rat_as_qty") / 100);
			}
		}
	}
}

function obj_onChange() {
	var formObj = document.form;
	var elementName = ComGetEvent("name");
	var sheet2 = sheetObjects[1];
	switch (elementName) {
		case "trf_schg_chk":
			callTariffSurcharge();
		break;
		case "f_rv_20":
		case "f_rv_40":
		case "f_rv_45":
		case "f_rv_70":
        	ComOpenWait(true);
            setTimeout( function () {
    			for (var i = sheet2.HeaderRows(); i <= sheet2.LastRow(); i++)
    			{
    				setPcChg(sheet2, i);
    			}
    			setTotalCm();
    			ComOpenWait(false);
            } , 100);
			break;
		case "svc_scp_cd":
			if(formObj.trf_schg_chk.checked){
				formObj.trf_schg_chk.checked = false;
				callTariffSurcharge();
			}
			break;
	}
}

function sheet2_OnSearchEnd(sheet2, ErrMsg) {
	
	setTotalCm();
	setSheet2Hidden();

	doActionIBSheet(sheetObjects[2],formObj, SEARCH04);
}


function sheet2_OnChange(sheet2, Row, Col)
{
	// apply 
	if (sheet2.ColSaveName(0,Col) != "apply") return;
	setPcChg(sheet2, Row);
	setTotalCm();
}

function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (Row < sheetObj.HeaderRows()) return;
	if (sheetObjects[1].RowCount() < 1) return;

	ComOpenWait(true);
    setTimeout( function () {
    	setSheet2Hidden();
        
		ComOpenWait(false);
        
    } , 100);
}

function setSheet2Hidden() {
	var sheet1 = sheetObjects[0];
	var sheet2 = sheetObjects[1];
	for (var j = sheet2.HeaderRows(); j <= sheet2.LastRow(); j++)
	{
		if (sheet1.GetCellValue(sheet1.GetSelectRow(), "pctl_no") != sheet2.GetCellValue(j, "pctl_no"))
		{
			sheet2.SetRowHidden(j, 1);
		}
		else
		{
			if (sheet2.GetCellValue(j, "sel") == "0")
			{
				sheet2.SetRowHidden(j, 1);
			}
			else
			{
				sheet2.SetRowHidden(j, 0);
			}
		}
	}
}

function ComFindText(sheetObj, colName, colValue){
	var idxs=new Array();
	for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ) {
	  	if(sheetObj.GetRowStatus(yn) != 'D' && sheetObj.GetCellValue(yn, colName) == colValue){
	      idxs.push(''+yn);
	    }
	}
	return idxs;
}

function setSurchargeSelBtn(show) {
	if (show) {
	    document.getElementById("all_charge_btn").innerHTML = "Hide Surcharge Selection";
	    all_charge.style.display = "block";
		sheetObjects[2].SetSelectRow(1);
	} else {
		document.getElementById("all_charge_btn").innerHTML = "Show Surcharge Selection";
		all_charge.style.display = "none";
	}
}

function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, formObj, SEARCHLIST07);
}


/**
 * set combo box
 * @param vCombo
 * @param vCode
 * @param vSelected
 * @return
 */
function fnSetComboBox(vCombo, vCode, vSelected) {
	var _spr="^"; // delimiter
	var obj=eval("document.all." + vCombo); // SELECT box position ID
	for ( var i=obj.length - 1; i >= 0; i--)
		obj[i]=null; // Init
	try {
		var result=vCode;
		if (result != "ERR" && result != "^") {
			var aList=result.split(_spr);
			var aCode, aName;
			var aCode=aList[0].split("$");
			var aName=aList[1].split("$");
			var optioncnt=obj.options.length;
			var codeindex=0;
			for ( var j=optioncnt; j < aCode.length + optioncnt; j++) {
				obj.options[j]=new Option();
				obj.options[j].text=aName[codeindex];
				obj.options[j].value=aCode[codeindex];
				if (vSelected == aCode[codeindex]) {
					obj.options[j].selected=true;
				}
				++codeindex;
			}
		}
	} catch (err) {
		 ComFuncErrMsg(err.message);
	}
}
function findRequestBkgOfc(rArray) {
    if(rArray != null ){
        var colArray=rArray[0];
        var rqstOfc=colArray[3]; 
    	form.f_agn_bkg_ofc_cd.value = rqstOfc;
    } 
}
function findRequestCtrtOfc(rArray) {
    if(rArray != null ){
        var colArray=rArray[0];
        var rqstOfc=colArray[3]; 
    	form.f_agn_ctrt_ofc_cd.value = rqstOfc;
    } 
}
function findRequestCust(rArray){
    if(rArray != null){
        var colArray=rArray[0];
        var rqstCust=colArray[3]; 
    	form.f_agn_ff_cust.value = rqstCust;

        }
    }
function callTariffSurcharge(){
	var formObj = document.form;
	
	if (sheetObjects[0].RowCount() < 1) 
	{
		ComShowCodeMessage("COM132701");
		formObj.trf_schg_chk.checked = false;
		return;
	}
	
	if (formObj.trf_schg_chk.checked) {
		doActionIBSheet(sheetObjects[1], formObj, SEARCH02);
	} else {
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		setTotalCm() ;
	}
}