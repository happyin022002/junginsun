/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0102.js
*@FileTitle  : Forecast Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
/**
 * @extends 
 * @class ESM_SPC_0102 : business script for ESM_SPC_0102
 */
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** setting additional sheet value in case of more 2 sheet per tab *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /*******************************************************/ 
    var formObject = document.form;
    try {

        //var srcName = event.srcElement.id:event.target.id;
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;

        switch (srcName) {
            case "btn_retrieve":
                //        			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
                //        			sheetObjects[0].RemoveAll();
                //        			sheetObjects[1].RemoveAll();
                ComOpenWait(true);
                setTimeout(function() {
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
                    ComOpenWait(false);
                }, 100);
                break;

            case "btn_fileimport":
                ComOpenPopup("ESM_SPC_9010.do", 900, 600, "", "1,0", true, false);
                break;

            case "btn_new":
                if (checkModifiedSheet(sheetObjects)) {
                    if (ComShowConfirm(getMsg("SPC90001")) != 1) {
                        return;
                    }
                }
                //using common funtion : initializing the screen
                resetAll();
                ComBtnDisable("btng_addAccount2");
                break;
            case "btn_save":
                // Calling doActionIBSheet2 in case of clicking save button without changing data
                if (sheetObjects[0].IsDataModified() == false) {
                    doActionIBSheet2(sheetObjects[0], formObject, IBSAVE);
                } else doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                break;
            case "btn_confirm":
                confirmData(sheetObjects[0], formObject);
                break;
            case "btn_downexcel":
                if (sheetObjects[0].RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
                }

                break;
            case "btng_addAccount2":
                accountAddDelete();
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e);
        }
    }
}

function goRetrieve() {
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    optionSetting();
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    var sheetResizeFull = true;
    document_onresize();
    var formObject = document.form;
    var comObj = salesOffice;
    if (comObj.GetItemCount() <= 1) {
        comObj.SetSelectIndex(0, false);
        var comObj1 = subOffice;
        if (comObj.GetSelectCode() != comObj1.GetSelectCode()) {
            comObj1.SetEnable(false);
        }
    }
    ComBtnDisable("btng_addAccount2");
    showDataSelectionItem("divDs2CFM", true);
    var rtn = getCodeList("ChildOffice", "ofc_cd=" + ofc_cd + "&level=4");
    initData_salesOffice(rtn[0].split("|"), rtn[1].split("|"));
}

/**
 * Displaying the object appied as id  according to show option
 */
function showDataSelectionItem(id, show) {
    var objs = document.all[id];
    for (var i = 0; i < objs.length; i++) {
        objs[i].style.display = show ? "" : "none";
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    switch (sheetNo) {            
        case 1: //sheet1 init        	
            initSheet1(sheetObj, document.form.year.value + document.form.week.value + "|TTL", true);
            break;
    }
}

/**
 * Changing the title after retrieving it in TabSheet2
 */
var sheet1 = new Object();

function initSheet1(sheetObj, weeks, isInit) {
	if(isInit == undefined){
		isInit=false;
	}
	
	with(sheetObj){
		var comObj=salesOffice;
		//20160203.ADD, 20160325.MOD
		var HeadTitle1="Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Load Sales Rep|Load Sales Rep|Week|Week|Week|Week|Week|Week|Week|Week|";
		var HeadTitle2="Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Load Account|Load Account|Load Account|Contract|Contract Customer|Contract Customer|Port|Port|";
		var HeadTitle3="Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Type|Code|Name|Number|Code|Name|POL|POD|";
		var HeadTitle4="||||||||||||||";
		var HeadTitleInfo="TRD|STRD|Lane|BD|V| V |D|IOC|SREP|CUST|SEQ||||POL|POD|OFC|CTP|CFM|CTRL|C_FLG|IB|";		//20160203.MOD
		var HeadTail="Tree|Flag|ILane|IRep|IPol|cL2|cL3|cL4|";			
		sheet1.masterColumnCount=HeadTitle1.split("|").length - 1;
		sheet1.forecastColumnCount=7;//5; //Total, TEU, hc, 45, 53, rf, wt
		sheet1.confirmColumnCount=9;//5;//TEU, hc, 45, 53, rf, wt
		sheet1.bookingColumnCount=8;
		sheet1.infoColumnCount=HeadTitleInfo.split("|").length - 1;
		var weekArr=weeks.split("|");
		sheet1.weekCount=weekArr.length;
		sheet1.tailColumnCount=HeadTail.split("|").length + 1;
		sheet1.itemColumnCount=sheet1.forecastColumnCount + sheet1.confirmColumnCount + sheet1.bookingColumnCount + sheet1.infoColumnCount;
		sheet1.columnCount=sheet1.masterColumnCount + sheet1.itemColumnCount * sheet1.weekCount + sheet1.tailColumnCount;
		sheet1.conformColorDif=sheet1.bookingColumnCount + sheet1.forecastColumnCount;
		
		for(var i=0 ; i < sheet1.weekCount ; i++){
			for(var j=0 ; j < sheet1.infoColumnCount ; j++){
				HeadTitle1=HeadTitle1 + weekArr[i] + "|";
				HeadTitle2=HeadTitle2 + "|";
				HeadTitle4=HeadTitle4 + "|";
			}
			HeadTitle3=HeadTitle3 + HeadTitleInfo+"Total TEU|TEU|HC|45|53'|RF|WT|Total TEU|20|40|HC|45|53'|RF|WT|Total TEU|TEU|HC|45|53'|RF|WT|D5RT|D7RT|";
			
			for(var k=0 ; k < sheet1.forecastColumnCount ; k++){
				HeadTitle1=HeadTitle1 + weekArr[i] + "|";
				HeadTitle2=HeadTitle2 + "F'cast|";
				HeadTitle4=HeadTitle4 + "|";
			}
			
			for(var m=0 ; m < sheet1.bookingColumnCount ; m++){
				HeadTitle1=HeadTitle1 + weekArr[i] + "|";
				HeadTitle2=HeadTitle2 + "BKG|";
				HeadTitle4=HeadTitle4 + "|";
			}
			
			for(var n=0 ; n < sheet1.confirmColumnCount ; n++){
				HeadTitle1=HeadTitle1 + weekArr[i] + "|";
				HeadTitle2=HeadTitle2 + "Confirmed|";
				HeadTitle4=HeadTitle4 + "|";
			}
		}
		
		HeadTitle3=HeadTitle3 + HeadTail;
		var cnt=0;
		
		//SetConfig( { SearchMode:2,  MergeSheet:7,Page:500, FrozenCol:sheet1.masterColumnCount, DataRowMerge:0, ColResize:1 } );
		SetConfig( { SearchMode:2, MergeSheet:5 , DataRowMerge:0, Page:10 } );
		
		var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"},
							{ Text:HeadTitle2, Align:"Center"},
							{ Text:HeadTitle3, Align:"Center"},
							{ Text:HeadTitle4, Align:"Center"} ];//HeadTitle3
		
		InitHeaders(headers, info);
		
		var cols = [{Type:"Text",      Hidden:0, Width:45,   Align:"Center", ColMerge:0,   SaveName:"d_trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:45,   Align:"Center", ColMerge:0,   SaveName:"d_sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center", ColMerge:0,   SaveName:"d_rlane_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:20,   Align:"Center", ColMerge:0,   SaveName:"d_dir_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Center", ColMerge:0,   SaveName:"d_ioc_ts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center", ColMerge:0,   SaveName:"d_rgn_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center", ColMerge:0,   SaveName:"d_sub_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center", ColMerge:0,   SaveName:"d_srep_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Center", ColMerge:0,   SaveName:"d_srep_usr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center", ColMerge:0,   SaveName:"d_fcast_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center", ColMerge:0,   SaveName:"d_cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Center", ColMerge:0,   SaveName:"d_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					//20160203.ADD Start, 20160325.MOD
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center", ColMerge:0,   SaveName:"d_ctrt_no",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center", ColMerge:0,   SaveName:"d_ctrt_cust_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Center", ColMerge:0,   SaveName:"d_ctrt_cust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					//20160203.ADD End
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center", ColMerge:0,   SaveName:"d_pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
					
		if(document.all.ctrl_lvl_all.value == "D") {
			cols.push({Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"d_pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		} else {
			cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"d_pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		}
		
		for(var p = 0 ; p < sheet1.weekCount ; p++){
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ioc_ts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"srep_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			//20160204.ADD, 20160325.MOD
			cols.push({Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_no",    	  	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fcast_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fcast_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_lvl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"flag_col",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_teu_qty",    KeyField:0,   CalcLogic:"",   AcceptKeys:"N", MinimumValue:0, PointCount:0,   UpdateEdit:0, InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_qty",        KeyField:0,   CalcLogic:"",   AcceptKeys:"N",  MinimumValue:0, PointCount:0,   UpdateEdit:1, InsertEdit:0, EditLen:6 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_40ft_hc_qty",    KeyField:0,   CalcLogic:"",   AcceptKeys:"N", MinimumValue:0, PointCount:0,   UpdateEdit:1, InsertEdit:0, EditLen:6 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_45ft_hc_qty",    KeyField:0,   CalcLogic:"",   AcceptKeys:"N", MinimumValue:0, PointCount:0,   UpdateEdit:1, InsertEdit:0, EditLen:6 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_53ft_qty",       KeyField:0,   CalcLogic:"",   AcceptKeys:"N", MinimumValue:0, PointCount:0,   UpdateEdit:1, InsertEdit:0, EditLen:6 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_rf_qty",         KeyField:0,   CalcLogic:"",   AcceptKeys:"N", MinimumValue:0, PointCount:0,   UpdateEdit:1, InsertEdit:0, EditLen:6 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_wgt",        KeyField:0,   CalcLogic:"",   AcceptKeys:"N", MinimumValue:0, PointCount:0,   UpdateEdit:1, InsertEdit:0, EditLen:9 });
			cols.push({Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_ttl_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_20ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_40ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_40ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_45ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_53ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_rf_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cfm_ttl_teu_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cfm_ttl_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_40ft_hc_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_45ft_hc_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_53ft_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_rf_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_ttl_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_40ft_hc_rat",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_45ft_hc_rat",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		}
	
	
		cols.push({Type:"Text",     Hidden:1, Width:50,   Align:"Left",     ColMerge:0,   SaveName:"treeLevel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });//TreeCol:1 , LevelSaveName:"sLevel" ,
		cols.push({Type:"Status",   Hidden:1, Width:50,   Align:"Center",   ColMerge:0,   SaveName:"editFlg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		cols.push({Type:"Text",     Hidden:1, Width:40,   Align:"Right",    ColMerge:0,   SaveName:"rowLane",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		cols.push({Type:"Text",     Hidden:1, Width:40,   Align:"Right",    ColMerge:0,   SaveName:"rowRep",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		cols.push({Type:"Text",     Hidden:1, Width:40,   Align:"Right",    ColMerge:0,   SaveName:"rowPol",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		
		cols.push({Type:"CheckBox", Hidden:1, Width:15,   Align:"Center",   ColMerge:0,   SaveName:"cL2",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		cols.push({Type:"CheckBox", Hidden:1, Width:15,   Align:"Center",   ColMerge:0,   SaveName:"cL3",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		cols.push({Type:"CheckBox", Hidden:1, Width:15,   Align:"Center",   ColMerge:0,   SaveName:"cL4",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		
		cols.push({Type:"Text",     Hidden:0,  Width:10, Align:"Right",   ColMerge:0,   SaveName:"ddd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		
		InitColumns(cols);
		SetEditable(comObj.GetItemCount()>=1);
		t1sheet1.SetHeaderRowHeight(10);
		resizeSheet();
	}
}


/**
 * OnClick시 Level Hidden(rowhidden and colhidden)
 * @param sheetObj
 * @param row
 * @param col
 */
function t1sheet1_OnClick(sheetObj, row, col) {

    var csName = sheetObj.ColSaveName(col);
    switch (csName) {
        case "d_pol_cd":
        case "d_pod_cd":
            var mark = sheetObj.GetCellValue(row, col);
            var status = sheetObj.GetRowStatus(row);
            if (mark == "+") {
                //toggleExpand(sheetObj, row, col);
                var startRow = row + 1;
//              var endRow = sheetObj.GetMergedEndCell(csName == "d_pol_cd" ? row + 1 : row, csName == "d_pol_cd" ? col - 4 : col - 1).split(",")[0];
                var endRow = sheetObj.FindText("treeLevel",(csName == "d_pol_cd") ? "2" : "3" ,startRow,-1,1);		//20160112.MOD
                if(endRow==-1) endRow = sheetObj.LastRow()+1;														//20160118.ADD

                for (; startRow <= endRow-1; startRow++) {
                    sheetObj.SetRowHidden(startRow, 0);
                    if (sheetObj.ColSaveName(col) == "d_pol_cd" && (sheetObj.GetCellValue(startRow, "d_pod_cd") == '+' || !document.form.chkDs2POD.checked)) {
//                        startRow = sheetObj.GetMergedEndCell(startRow, "d_pol_cd").split(",")[0];
                        startRow = sheetObj.FindText("treeLevel", "3" ,startRow+1,-1,1);							//20160118.ADD
                        if(startRow==-1) startRow = sheetObj.LastRow()+1;
                        startRow = startRow-1;                        
                    }
                }
                sheetObj.SetCellValue(row, col, "-", 0);
                sheetObj.SetCellValue(row, "editFlg", status, 0);

            } else if (mark == "-") {           	
                var startRow = row + 1;
//              var endRow = sheetObj.GetMergedEndCell(csName == "d_pol_cd" ? row + 1 : row, csName == "d_pol_cd" ? col - 4 : col - 1).split(",")[0];
                var endRow = sheetObj.FindText("treeLevel",(csName == "d_pol_cd") ? "2" : "3" ,startRow,-1,1);		//20160112.MOD
                if(endRow==-1) endRow = sheetObj.LastRow()+1;														//20160118.ADD
                for (; startRow <= endRow-1; startRow++) {
                    sheetObj.SetRowHidden(startRow, 1);
                }
                sheetObj.SetCellValue(row, col, "+", 0);
                sheetObj.SetCellValue(row, "editFlg", status, 0);
            }
//            sheetObj.SetDataMerge();
            break;
    }
}


/**
 * 화면에서 체크박스를 클릭했을 경우 해당 Data Hidden
 * 화면 컨트롤 Disable로 수행안함.(UI개선후 성능개선을 위해)
 * @param obj
 */
function changeCheckSelection(obj) {
    //ComOpenWait(true);
    t1sheet1.RenderSheet(0);
    changeDataSelection(obj, false);
//    if (obj.name == 'chkDs2Account' || obj.name == 'chkDs2POD') t1sheet1.SetDataMerge(); //rowhidden을 하므로			//20160120.MOD 
    t1sheet1.RenderSheet(1);
    //ComOpenWait(false);
}

function initDataSelection(sheetNo) {
    if (sheetNo == 1) {
        changeDataSelection(document.getElementsByName("chkDs2LaneInfo")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2Office")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2Account")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2POD")[0], false);
        //Calling changeDataSelectionTpSzAll internally while Handling (chkDs2BKG) (OTH, HC, 45, 53, RF, WT recall)
        changeDataSelection(document.getElementsByName("chkDs2BKG")[0], false);
        //Calling changeDataSelectionTpSzAll internally while Handling (chkDs2CFM) (OTH, HC, 45, 53, RF, WT recall)
        changeDataSelection(document.getElementsByName("chkDs2CFM")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2INF")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2OTH")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2HC")[0], false);
        changeDataSelection(document.getElementsByName("chkDs245")[0], false);
        changeDataSelection(document.getElementsByName("chkDs253")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2RF")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2WT")[0], false);
    }
}

function accountAddDelete() {
    var sheetObj = sheetObjects[0];
    var row = sheetObj.GetSelectRow();
    var srep_id = ComTrim(sheetObj.GetCellValue(row, "d_srep_usr_id"));
    srep_id = srep_id.replace("'", "");
    if (srep_id == "") {
        ComShowCodeMessage("COM12113", "Sales Rep");
        return false;
    } else {
    	//20160112.MOD
        var param = "srep_id=" + srep_id;
        param = param + "&srep_nm=" + sheetObj.GetCellValue(row, "d_srep_usr_nm");
        param = param + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd");
        param = param + "&trd_cd=" + sheetObj.GetCellValue(row, "trd_cd");
        param = param + "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
        param = param + "&bound=" + sheetObj.GetCellValue(row, "dir_cd");
        param = param + "&rgn_ofc_cd=" + sheetObj.GetCellValue(3, sheetObj.SaveNameCol("d_rgn_ofc_cd"));
        param = param + "&sub_ofc_cd=" + sheetObj.GetCellValue(row, "d_sub_ofc_cd");
        param = param + "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_ts_cd");
        param = param + "&acc_tp=" + sheetObj.GetCellValue(row, "fcast_cust_tp_cd");
        ComOpenPopup('ESM_SPC_0103_POP.do?' + param, 800, 600, "acctCallBack", "1,0", true);
    }
}

function changeDataSelection(tobj, internal) {
    if (internal == undefined || internal == null) {
        internal == false;
    }
    var sheetObj = sheetObjects[0];
    var obj = null;
    obj = tobj;
    var sts = obj.checked;
    var hval = sts ? 0 : 1; //체크박스 언체크시 hidden

    /*
    	   1-,0:20/40
    	   1:HC
    	   2:45
    	   3:53
    	   4:RF
    	   5:WG
    	 */
    switch (obj.name) {
        case "chkDs2LaneInfo":
            if (sheetObj.GetColHidden("d_trd_cd") == hval) break;
            sheetObj.SetColHidden("d_trd_cd", hval);
            sheetObj.SetColHidden("d_sub_trd_cd", hval);
            sheetObj.SetColHidden("d_dir_cd", hval);
            sheetObj.SetColHidden("d_ioc_ts_cd", hval);
            break;
        case "chkDs2Office":
            if (sheetObj.GetColHidden("d_rgn_ofc_cd") == hval) break;
            sheetObj.SetColHidden("d_rgn_ofc_cd", hval);
            sheetObj.SetColHidden("d_sub_ofc_cd", hval);
            break;
        case "chkDs2Account":
            //sheetObj.ShowTreeLevel(sts?3:2, 0);
            if (sheetObj.GetColHidden("d_fcast_cust_tp_cd") == hval) break;
            sheetObj.SetColHidden("d_fcast_cust_tp_cd", hval);
            sheetObj.SetColHidden("d_cust_cd", hval);
            sheetObj.SetColHidden("d_cust_nm", hval);
            sheetObj.SetColHidden("d_pol_cd", hval);
            
            if (!sts) { //접을때는 POD도 같이
                if (document.all.ds2POD.checked) {
                    document.all.ds2POD.checked = false;
                    sheetObj.SetColHidden("d_pod_cd", hval);
                }
            }
            break;
        case "chkDs2POD":
            if (sheetObj.GetColHidden("d_pod_cd") == hval) break;
            //펼칠때는 Accout/POL도 같이
            if (sts) {
                if (!document.all.ds2Account.checked) {
                    document.all.ds2Account.checked = true;
                    sheetObj.SetColHidden("d_fcast_cust_tp_cd", 0);
                    sheetObj.SetColHidden("d_cust_cd", 0);
                    sheetObj.SetColHidden("d_cust_nm", 0);
                    sheetObj.SetColHidden("d_pol_cd", 0);
                }
            }
            sheetObj.SetColHidden("d_pod_cd", hval);

            if (sts) {
                ChangeValues2(sheetObj, "d_pod_cd", "+", "d_pod_cd", "-");
            }
            ChangeValues2(sheetObj, "d_pol_cd", "+", "d_pol_cd", "-");
            break;
        case "chkDs2OTH":
            /*20/40
    			  F'cast=TotalTEU(), TEU(O), HC(), 45(), 53(), RF(), WT()
    			  BKG=TEU(O), 20(O), 40(O), HC(), 45(), 53(), RF(), WT()
    			  Confirmed=TEU(O), HC(), 45(), 53(), RF(), WT()
    			 */
            hiddenTypeSize(sheetObj, sheet1, -1, sts);
            hiddenTypeSize(sheetObj, sheet1, 0, sts);
            break;
        case "chkDs2HC":
            /*HC
    			  F'cast=TotalTEU(O), TEU(O), HC(O), 45(), 53(), RF(), WT()
    			  BKG=TEU(O), 20(), 40(), HC(O), 45(), 53(), RF(), WT()
    			  Confirmed=TEU(O), HC(O), 45(), 53(), RF(), WT()
    			 */
            hiddenTypeSize(sheetObj, sheet1, 1, sts);
            break;
        case "chkDs245":
            /*45
    			  F'cast=TotalTEU(O), TEU(O), HC(), 45(O), 53(), RF(), WT()
    			  BKG=TEU(O), 20(), 40(), HC(), 45(O), 53(), RF(), WT()
    			  Confirmed=TEU(O), HC(), 45(O), 53(), RF(), WT()
    			 */
            hiddenTypeSize(sheetObj, sheet1, 2, sts);
            break;
        case "chkDs253":
            /*53
    			  F'cast=TotalTEU(O), TEU(O), HC(), 45(), 53(O), RF(), WT()
    			  BKG=TEU(O), 20(), 40(), HC(), 45(), 53(O), RF(), WT()
    			  Confirmed=TEU(O), HC(), 45(), 53(O), RF(), WT()
    			 */
            hiddenTypeSize(sheetObj, sheet1, 3, sts);
            break;
        case "chkDs2RF":
            /*RF
    			  F'cast=TotalTEU(), TEU(O), HC(), 45(O), 53(), RF(O), WT()
    			  BKG=TEU(O), 20(), 40(), HC(), 45(), 53(), RF(O), WT()
    			  Confirmed=TEU(O), HC(), 45(), 53(), RF(O), WT()
    			 */
            hiddenTypeSize(sheetObj, sheet1, 4, sts);
            break;
        case "chkDs2WT":
            /*WT
    			  F'cast=TotalTEU(), TEU(O), HC(), 45(O), 53(), RF(), WT(O)
    			  BKG=TEU(O), 20(), 40(), HC(), 45(), 53(), RF(), WT(O)
    			  Confirmed=TEU(O), HC(), 45(), 53(), RF(), WT(O)
    			 */
            hiddenTypeSize(sheetObj, sheet1, 5, sts);
            break;
        case "chkDs2BKG":
            for (var i = 0; i < sheet1.weekCount; i++) {
                var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i + sheet1.infoColumnCount + sheet1.forecastColumnCount;
                for (var c = 0; c < sheet1.bookingColumnCount; c++) {
                    sheetObj.SetColHidden(sCol + c, hval);
                }
            }
            if (tobj == undefined || tobj == null || sts) {
                changeDataSelectionTpSzAll(2);
            }
            break;
        case "chkDs2CFM":
            for (var i = 0; i < sheet1.weekCount; i++) {
                var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i + sheet1.itemColumnCount - sheet1.confirmColumnCount;
                for (var c = 0; c < sheet1.confirmColumnCount; c++) {
                    sheetObj.SetColHidden(sCol + c, hval);                
                }
            }
            if (tobj == undefined || tobj == null || sts) {
                changeDataSelectionTpSzAll(2);
            }  
            break;
        case "chkDs2INF":
            for (var i = 0; i < sheet1.weekCount; i++) {
                var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i + sheet1.infoColumnCount;
                sheetObj.SetColHidden(sCol - 1, hval);
                sheetObj.SetColHidden(sCol - 2, hval);
                sheetObj.SetColHidden(sCol - 4, hval);
                sheetObj.SetColHidden(sCol - 13, hval);
                sheetObj.SetColHidden(sCol - 14, hval);
                sheetObj.SetColHidden(sCol - 15, hval);
            }
            break;
    }
}

function changeDataSelectionTpSzAll(idx) {
    changeDataSelection(document.getElementsByName("chkDs" + idx + "OTH")[0], false);
    changeDataSelection(document.getElementsByName("chkDs" + idx + "HC")[0], false);
    changeDataSelection(document.getElementsByName("chkDs" + idx + "45")[0], false);;
    changeDataSelection(document.getElementsByName("chkDs" + idx + "53")[0], false);
    changeDataSelection(document.getElementsByName("chkDs" + idx + "RF")[0], false);
    changeDataSelection(document.getElementsByName("chkDs" + idx + "WT")[0], false);
}

function hiddenTypeSize(sheetObj, info, tpIdx, sts) {
    var bkgSts = document.getElementsByName("chkDs2BKG")[0].checked;
    var cfmSts = document.getElementsByName("chkDs2CFM")[0].checked;
    var stsHC = document.getElementsByName("chkDs2HC")[0].checked;
    var sts45 = document.getElementsByName("chkDs245")[0].checked;
    var sts53 = document.getElementsByName("chkDs253")[0].checked;
    /*
    	  0:20/40
    	  1:HC
    	  2:45
    	  3:53
    	  3:RF
    	  4:WG
    	 */
    for (var i = 0; i < info.weekCount; i++) {
        var sCol = 0;
        //F'cast supply Hidden=========================================
        //Handling Total TEU in case of HC(1), 45(2), 53(3)
        sCol = info.masterColumnCount + info.itemColumnCount * i + info.infoColumnCount; //numbers of total column counting
        //    		if(stsHC||sts45||sts53) sheetObj.SetColHidden(sCol,0);//Activating Total TEU
        //    		else sheetObj.SetColHidden(sCol,1);//deactivating Total TEU
        sheetObj.SetColHidden(sCol + 1, 0); //Activating TEU
        if (tpIdx > 0) sheetObj.SetColHidden(sCol + 1 + tpIdx, sts ? 0 : 1); //HC, 45, 53, RF, WT
        //==========================================================
        //BKG supply Hidden=============================================
        sCol = sCol + info.bookingColumnCount;
        if (bkgSts) sheetObj.SetColHidden(sCol + 1 + tpIdx, sts ? 0 : 1);
        //==========================================================
        //Confirmed supply Hidden=======================================
        sCol = sCol + info.confirmColumnCount-2;
        sheetObj.SetColHidden(sCol, 1); // Hidding Total TEU
        if (tpIdx > 0 && cfmSts) {
        	sheetObj.SetColHidden(sCol + 1 + tpIdx, sts ? 0 : 1);
        	sheetObj.SetColHidden(sCol + 7, 1);
        	sheetObj.SetColHidden(sCol + 8, 1);
        }
        //==========================================================
    }
}

function ChangeValues2(sheetObj, col, val, sCol, sVal) {
    with(sheetObj) {
        var frow = -1;
        while ((frow = FindText(col, val, frow + 1)) >= 0) {
            var status = sheetObj.GetRowStatus(frow);
            SetCellValue(frow, sCol, sVal, 0);
            //sheetObj.SetRowStatus(frow,status);
            SetCellValue(frow, "editFlg", status, 0);
        }
    }
}

// Changing Data value to CellValue2
function ChangeValue2(sheetObj, row, col, val) {
    with(sheetObj) {
        var status = GetRowStatus(row);
        SetCellValue(row, col, val, 0);
        //SetRowStatus(row,status);
        SetCellValue(row, "editFlg", status, 0);
    }
}

// Changing Data value to CellValue
function ChangeValue(sheetObj, row, col, val) {
    with(sheetObj) {
        var status = GetRowStatus(row);
        SetCellValue(row, col, val);
        SetCellValue(row, "editFlg", status, 0);
        //SetRowStatus(row,status);
    }
}

function AddValue2(sheetObj, row, col1, col2, val) {
    if (col1 != null) {
        var old_color = sheetObj.GetCellFontColor(row, col1);
        ChangeValue2(sheetObj, row, col1, val + sheetObj.GetCellValue(row, col1) * 1);
        sheetObj.SetCellFontColor(row, col1, old_color);
        compareConfirmValue(sheetObj, row, col1);
    }
    if (col2 != null) {
        var old_color = sheetObj.GetCellFontColor(row, col2);
        ChangeValue2(sheetObj, row, col2, val + sheetObj.GetCellValue(row, col2) * 1);
        sheetObj.SetCellFontColor(row, col2, old_color);
        compareConfirmValue(sheetObj, row, col2);
    }
}

function compareConfirmValue(sheetObj, row, col) {
    var val1 = sheetObj.GetCellValue(row, col) * 1;
    var val2 = sheetObj.GetCellValue(row, col + sheet1.conformColorDif) * 1;
    if (sheetObj.GetCellFontColor(row, col) == "#FFFFFF") {
        return;
    }
    sheetObj.SetCellFontColor(row, col, (val1 == val2) ? "#0000FF" : sheetObj.GetDataFontColor());
}

function AddValue(sheetObj, row, col, val) {
    ChangeValue(sheetObj, row, col, val + sheetObj.GetCellValue(row, col) * 1);
}

//Handling the process related with Sheet
function doActionIBSheet(sheetObj, formObj, sAction, quite) {
    if (quite == undefined) quite = false;
    //sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            var sheetObj = sheetObjects[0];
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }

            //ComOpenWait(true);

            var param = "year=" + formObj.year.value;
            param = param + "&week=" + formObj.week.value;
            param = param + "&duration=" + formObj.duration.value;
            param = param + "&trade=" + comObjects[0].GetSelectCode();
            param = param + "&subtrade=" + comObjects[1].GetSelectCode();
            param = param + "&lane=" + comObjects[2].GetSelectCode();
            param = param + "&bound=" + formObj.bound.value;
            param = param + "&ioc=" + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value : formObj.id_chk_ts.value));
            param = param + "&salesOffice=" + comObjects[3].GetSelectCode();
            param = param + "&subOffice=" + comObjects[4].GetSelectCode();
            param = param + "&salesRep=" + comObjects[5].GetSelectCode();
            param = param + "&vvd=" + formObj.vvd.value;

            var rtn = sheetObj.GetSearchData("ESM_SPC_0102GS.do", "f_cmd=" + SEARCHLIST02 + "&" + param);		//20160112.MOD
            var etcData = getEtcData(rtn);

            if (etcData["status"] == undefined || etcData["status"] != "OK" || etcData["week"] == undefined) {
                ComShowMessage("Error occurred. Try again");
                return;
            }

            if (ComGetTotalRows(rtn) > 0) {
               
                sheetObj = sheetObjects[0].Reset();
                sheetObjects[0] = sheetObj;

                formObj.ctrl_hc.value = etcData["ctrl_hc"];
                formObj.ctrl_45.value = etcData["ctrl_45"];
                formObj.ctrl_53.value = etcData["ctrl_53"];
                formObj.ctrl_wt.value = etcData["ctrl_wt"];
                formObj.ctrl_lvl_all.value = etcData["ctrl_lvl_all"];
                formObj.ctrl_tpsz_all.value = etcData["ctrl_tpsz_all"];                
                
                //추가(화면조회후 control option에 따라 checkbox 설정)
                initCheckBox();
                sheetObj.RenderSheet(0);
                initSheet1(sheetObj, etcData["week"].substring(1), false);
                sheetObj.RenderSheet(1);

                sheetObj.RenderSheet(0);
                sheetObj.LoadSearchData(rtn, { Sync: 1 });
                sheetObj.RenderSheet(1);
                //t1sheet1_OnScroll(sheetObj, 0, 0, sheetObj.HeaderRows(), 0, true);//조회후 바로 수행할 필요 없어보임 속도개선을 위해 주석처리 Arie
                initData2(sheetObj);
                sheetObj.RenderSheet(0);
                initDataSelection(1);
                sheetObj.RenderSheet(1);
                ComBtnEnable("btng_addAccount2"); 

                var comObj = trade;
                var trd_cd = comObj.GetSelectCode();
                
                //Setting form value to handle save without modifying data in case of retrieving
                formObj.vvdList.value = etcData["vvd"].replace('|TTL', '');
                formObj.salesRepCodeList.value = etcData["salesRepCodeList"];
                //Setting the column according to control option by VVD===============================
                //Making the column hidden by VVD according to control option after retrieving sheet.
                //Showing the column in case cell is editable.
                var isEditCol;
                var cn;
                sheetObj.RenderSheet(0);
                //첫번째 Row를 Header로 Copy LastCol()
                var nHdrS = "";
                for (var idx = 0; idx <= sheetObj.LastCol(); idx++) {
                    nHdrS = nHdrS + sheetObj.GetCellValue(4, idx) + "|";
                }
                changeHeaderRow(sheetObj, 3, nHdrS);

                for (var c = sheet1.masterColumnCount; c < sheet1.columnCount; c++) {
                    isEditCol = false; //initializing in case of new column
                    cn = sheetObj.ColSaveName(c);
                    for (var r = 0; r < sheetObj.LastRow() + 1; r++) {
                        if (sheetObj.GetCellBackColor(r, c) == "#ffff80") {
                            isEditCol = true;
                            break;
                        }
                    }                    
                    if (isEditCol && (cn == 'fcast_ttl_qty' || cn == 'fcast_40ft_hc_qty' || cn == 'fcast_45ft_hc_qty' || cn == 'fcast_53ft_qty' || cn == 'fcast_rf_qty' || cn == 'fcast_ttl_wgt')) {
                        sheetObj.SetColHidden(c, 0);
                        switch (sheetObj.ColSaveName(c)) {
                            case "fcast_ttl_wgt":
                                document.form.chkDs2WT.checked = true;
                                changeDataSelection(document.getElementsByName("chkDs2WT")[0], false);
                                break;
                        }
                    }
                }
                sheetObj.SetRowHidden(3, false);
                sheetObj.RenderSheet(1);

            } else {                
                sheetObj.LoadSearchData(rtn, { Sync: 1 });
                sheetObj.SetRowHidden(3, true);
            }
                        
            //ComOpenWait(false);	
            //===============================================================================
            break;

        case IBSEARCH_ASYNC01: //Retrieve
            var sheetObj = sheetObjects[0];
            if (!validateForm2(sheetObj, formObj, sAction)) {
                return false;
            }

            //ComOpenWait(true);
            var param = "year=" + formObj.year.value;
            param = param + "&week=" + formObj.week.value;
            param = param + "&duration=" + formObj.duration.value;
            param = param + "&trade=" + comObjects[0].GetSelectCode();
            param = param + "&subtrade=" + comObjects[1].GetSelectCode();
            param = param + "&lane=" + comObjects[2].GetSelectCode();
            param = param + "&bound=" + formObj.bound.value;
            param = param + "&ioc=" + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value : formObj.id_chk_ts.value));
            param = param + "&salesOffice=" + comObjects[3].GetSelectCode();
            param = param + "&subOffice=" + comObjects[4].GetSelectCode();
            param = param + "&salesRep=" + comObjects[5].GetSelectCode();
            param = param + "&vvd=" + formObj.vvd.value;

            var rtn = sheetObj.GetSearchData("ESM_SPC_0102GS.do", "f_cmd=" + SEARCHLIST02 + "&" + param);
            var etcData = getEtcData(rtn);

            if (etcData["status"] == undefined || etcData["status"] != "OK" || etcData["week"] == undefined) {
                ComShowMessage("Error occurred. Try again");
                return;
            }

            var sheetObj = sheetObjects[0].Reset();
            sheetObjects[0] = sheetObj;

            initSheet1(sheetObj, etcData["week"].substring(1), false);
            sheetObj.RenderSheet(0);
            sheetObj.LoadSearchData(rtn, {
                Sync: 1
            });
            sheetObj.RenderSheet(1);
            //t1sheet1_OnScroll(sheetObj, 0, 0, sheetObj.HeaderRows(), 0, true);//조회후 바로 수행할 필요 없어보임 속도개선을 위해 주석처리 Arie
            initData2(sheetObj);
            sheetObj.RenderSheet(0);
            initDataSelection(1);
            sheetObj.RenderSheet(1);
            ComBtnEnable("btng_addAccount2");

            var comObj = trade;
            var trd_cd = comObj.GetSelectCode();
            
            //Setting form value to handle save without modifying data in case of retrieving
            formObj.vvdList.value = etcData["vvd"].replace('|TTL', '');
            formObj.salesRepCodeList.value = etcData["salesRepCodeList"];
            //Setting the column according to control option by VVD===============================
            //Making the column hidden by VVD according to control option after retrieving sheet.
            //Showing the column in case cell is editable.
            var isEditCol;
            var cn;
            sheetObj.RenderSheet(0);
            for (var c = sheet1.masterColumnCount; c < sheet1.columnCount; c++) {
                isEditCol = false; //initializing in case of new column
                cn = sheetObj.ColSaveName(c);
                for (var r = 0; r < sheetObj.LastRow() + 1; r++) {
                    if (sheetObj.GetCellBackColor(r, c) == "#ffff80") {
                        isEditCol = true;
                        break;
                    }
                }
                if (isEditCol && (cn == 'fcast_ttl_qty' || cn == 'fcast_40ft_hc_qty' || cn == 'fcast_45ft_hc_qty' || cn == 'fcast_53ft_qty' || cn == 'fcast_rf_qty' || cn == 'fcast_ttl_wgt')) {
                    sheetObj.SetColHidden(c, 0);
                    switch (sheetObj.ColSaveName(c)) {
                        case "fcast_ttl_wgt":
                            document.form.chkDs2WT.checked = true;
                            changeDataSelection(document.getElementsByName("chkDs2WT")[0], false);
                            break;
                    }
                }
            }
            sheetObj.RenderSheet(1);
            //===============================================================================
            break;

        case IBSAVE: //save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //ComOpenWait(true);
            var uList = sheetObj.FindStatusRow("U");
            var uArr = uList.split(";");
            
            for (var i = 0; i < uArr.length; i++) {
                var row = uArr[i] * 1;
                var lvl = sheetObj.GetCellValue(row, "treeLevel") * 1;
                if (lvl != 4) {
                    continue;
                }
                
                var rowRep = sheetObj.GetCellValue(row, "rowRep") * 1;
                var rowPol = sheetObj.GetCellValue(row, "rowPol") * 1;
                for (var c = 0; c < sheet1.weekCount; c++) {
                    var col = sheet1.masterColumnCount + sheet1.itemColumnCount * c + sheet1.infoColumnCount - 1;
                    break;
                    
                    if (sheetObj.GetCellValue(row, col) == "U" || sheetObj.GetCellValue(row, col) == "I") {
                        sheetObj.SetCellValue(rowRep, col, "I", 0);
                        sheetObj.SetCellValue(rowPol, col, "I", 0);
                    }
                }
            }
            
            uList = sheetObj.FindStatusRow("U");
            uArr = uList.split(";");
            
            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0102GS.do", "f_cmd=" + MULTI02, null, !quite);
            break;
            
        case IBDOWNEXCEL: //Excel download    			
            //sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), DownRows:Visible, SheetDesign:1, AutoSizeColumn:1, Merge:1, ExcelFontSize:9});
            sheetObj.Down2Excel({ FileName: "Forecast_Input", DownRows: "Visible", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

//in case of saving without changing Handling the process related with Sheet, Data
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSAVE: //saving without changing Data
            if (!validateForm(sheetObj, formObj, IBSEARCH)) {
                return false;
            }
            //ComOpenWait(true);
            if (formObj.salesRepCodeList.value != '') {
                if (ComShowConfirm('There is no data to changed\nPlease click "Yes" if you\'d like to continue') == 0)
                    return false;
                var param = "salesRepCodeList=" + formObj.salesRepCodeList.value;
                param = param + "&vvdList=" + formObj.vvdList.value;
                param = param + "&ioc=" + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value : formObj.id_chk_ts.value));
                sheetObj.DoAllSave("ESM_SPC_0102GS.do", "f_cmd=" + MULTI03 + "&" + param);
            } else {
                ComShowMessage("There is no data to save");
            }
            break;
    }
}

/*
 * Calling after saving
 */
function t1sheet1_OnSaveEnd(sheetObj, Code, errMsg) {
    if (sheetObj.GetEtcData("status") == "OK") {
        ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	
        doActionIBSheet(sheetObj, document.form, IBSEARCH); //위치이동(doActionIBSheet마지막에서 이곳으로)
    } else if (sheetObj.GetEtcData("status") != "OK") {
        ComShowMessage(errMsg);
    }
}

function t1sheet1_OnSearchEnd(shtObj, ErrMsg) {
}
function initData2(sheetObj) {
}
function t1sheet1_OnScroll(sheetObj, newTopRow, newLeftCol, isTop, isBottom, isInit) {
}

var selectedCell_OldValue = 0;

function t1sheet1_OnSelectCell(sheetObj, orow, ocol, row, col) {
    selectedCell_OldValue = sheetObj.GetCellValue(row, col) * 1;
}
function t1sheet1_OnChange(sheetObj, row, col, value) {
    if (value == "") {
        ComShowMessage(getMsg("SPC90201"));
        sheetObj.SetCellValue(row, col, selectedCell_OldValue * 1, 0);
    } else {
        with(sheetObj) {
            var level = GetCellValue(row, "treeLevel") * 1;
            var orgValue = selectedCell_OldValue;
            var difValue = value * 1 - orgValue;
            
            //=====================================
            var colName = sheetObj.ColSaveName(col);
            var difTeuValue = difValue;
            //if (colName == 'fcast_40ft_hc_qty' || colName == 'fcast_45ft_hc_qty' || colName == 'fcast_53ft_qty') difTeuValue = difValue * 2;            
            
            if (colName == 'fcast_40ft_hc_qty') {            	
            	difTeuValue = difValue * GetCellValue(row, col+20);
            } else  if (colName == 'fcast_45ft_hc_qty') {            	
            	difTeuValue = difValue * GetCellValue(row, col+20);;
            } else  if (colName == 'fcast_53ft_qty') {            	
            	difTeuValue = difValue * 2;
            }
            
            //=====================================
            
            if (GetCellEditable(row, col) && GetCellFontColor(row, col) == "#FFFFFF") {
                ComShowMessage("Please check if port is skipped or account is not registered for forecast input.");
            }
            
            switch (level) {
                case 3:
                    var colIdx = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
                    var ttlCol = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1) + colIdx;
                    compareConfirmValue(sheetObj, row, col);
                    var frow = row;
                    var pol_cd = GetCellValue(frow, "d_pol_cd");
                    var polVal = GetCellValue(frow, "rowPol") * 1;
                    var isAsigned = false;
                    frow = frow + 1;
                    //while(pol_cd == GetCellValue(frow, "d_pol_cd")){
                    while (polVal == GetCellValue(frow, "rowPol") * 1) { //POD와 값없는 SREP을가져오지 않으므로 POL_CD가 아래랑 같을수도 있으니까 NO로 변경
                        selectedCell_OldValue = GetCellValue(frow, col);
                        if (selectedCell_OldValue != "") {
                            var old_color = GetCellFontColor(frow, col);
                            if (isAsigned) {
                                SetCellValue(frow, col, 0);
                            } else {
                                SetCellValue(frow, col, value);
                                isAsigned = true;
                            }
                            SetCellFontColor(frow, col, old_color);
                        }
                        frow = frow + 1;
                    }
                    setChangedStatus(sheetObj, row, col);
                    //RowStatus(row) = "R";
                    break;
                    
                case 4:
                    var colIdx = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
                    var ttlCol = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1) + colIdx;
                    var rowLane = GetCellValue(row, "rowLane") * 1;
                    var rowRep = GetCellValue(row, "rowRep") * 1;
                    var rowPol = GetCellValue(row, "rowPol") * 1;
                    compareConfirmValue(sheetObj, row, col);
                    //1.Changing the value of current TTL
                    AddValue2(sheetObj, row, null, ttlCol, difValue);
                    //2.Changing the value of current POL 
                    //POL 합계 행이 non-editable 일 때만 합계 행 값 변경
                    if (rowPol != row && GetCellEditable(rowPol, "fcast_ttl_qty") == 0) {
                        AddValue2(sheetObj, rowPol, col, null, difValue);
                        compareConfirmValue(sheetObj, rowPol, col);
                        setChangedStatus(sheetObj, rowPol, col);
                    }
                    AddValue2(sheetObj, rowPol, null, ttlCol, difValue);
                    //3.Changing the value of current Sales Rep
                    AddValue2(sheetObj, rowRep, col, ttlCol, difValue);
                    compareConfirmValue(sheetObj, rowRep, col);
                    setChangedStatus(sheetObj, rowRep, col);
                    //4.Changing the value of current RLane
                    AddValue2(sheetObj, rowLane + 1 + ((ComTrim(GetCellValue(rowLane + 1, "d_pol_cd")) == "") ? 1 : 0), col, ttlCol, difValue);
                    //5.Changing the value of current POL of RLane
                    var frow = FindText("pol_cd", GetCellValue(row, "pol_cd"), rowLane);		//20160118.MOD : d_pol_cd->pol_cd
                    AddValue2(sheetObj, frow, col, ttlCol, difValue);
                    //6.Changing the value of current POD of RLane
                    frow = FindText("pod_cd", GetCellValue(row, "pod_cd"), frow);				//20160118.MOD : d_pod_cd->pod_cd
                    AddValue2(sheetObj, frow, col, ttlCol, difValue);
                    setChangedStatus(sheetObj, row, col);
                    break;
            }
        }
        selectedCell_OldValue = value;
        //==================================================================================================
        // Changing data according to Adding Total TEU
        var totalTeuCol = 0;
        var totalTeuValue = 0;
        var ttlTotalTeuCol = 0;
        var ttlTotalTeuValue = 0;
        for (var k = sheetObj.HeaderRows(); k <= sheetObj.LastRow(); k++) {
            switch (sheetObj.ColSaveName(col)) {
                case "fcast_ttl_qty":
                    totalTeuCol = col - 1;
                    //TEU + HC*2 + 45*2 + 53*2
                    totalTeuValue = parseInt(sheetObj.GetCellValue(k, col)) + parseInt(sheetObj.GetCellValue(k, col + 1)) * sheetObj.GetCellValue(row, col+21) + parseInt(sheetObj.GetCellValue(k, col + 2)) * sheetObj.GetCellValue(row, col+22) + parseInt(sheetObj.GetCellValue(k, col + 3)) * 2;
                    ttlTotalTeuCol = ttlCol - 1;
                    ttlTotalTeuValue = parseInt(sheetObj.GetCellValue(k, ttlCol)) + parseInt(sheetObj.GetCellValue(k, ttlCol + 1)) * sheetObj.GetCellValue(row, col+21) + parseInt(sheetObj.GetCellValue(k, ttlCol + 2)) * sheetObj.GetCellValue(row, col+22) + parseInt(sheetObj.GetCellValue(k, ttlCol + 3)) * 2;
                    break;
                case "fcast_40ft_hc_qty":
                    totalTeuCol = col - 2;
                    //TEU + HC*2 + 45*2 + 53*2
                    totalTeuValue = parseInt(sheetObj.GetCellValue(k, col - 1)) + parseInt(sheetObj.GetCellValue(k, col)) * sheetObj.GetCellValue(row, col+20) + parseInt(sheetObj.GetCellValue(k, col + 1)) * sheetObj.GetCellValue(row, col+21) + parseInt(sheetObj.GetCellValue(k, col + 2)) * 2;
                    ttlTotalTeuCol = ttlCol - 2;
                    ttlTotalTeuValue = parseInt(sheetObj.GetCellValue(k, ttlCol - 1)) + parseInt(sheetObj.GetCellValue(k, ttlCol)) * sheetObj.GetCellValue(row, col+20) + parseInt(sheetObj.GetCellValue(k, col + 1)) * sheetObj.GetCellValue(row, col+21) + parseInt(sheetObj.GetCellValue(k, col + 2)) * 2;
                    break;
                case "fcast_45ft_hc_qty":
                    totalTeuCol = col - 3;
                    //TEU + HC*2 + 45*2 + 53*2
                    totalTeuValue = parseInt(sheetObj.GetCellValue(k, col - 2)) + parseInt(sheetObj.GetCellValue(k, col - 1)) * sheetObj.GetCellValue(row, col+19) + parseInt(sheetObj.GetCellValue(k, col)) * sheetObj.GetCellValue(row, col+20) + parseInt(sheetObj.GetCellValue(k, col + 1)) * 2;
                    ttlTotalTeuCol = ttlCol - 3;
                    ttlTotalTeuValue = parseInt(sheetObj.GetCellValue(k, ttlCol - 2)) + parseInt(sheetObj.GetCellValue(k, ttlCol - 1)) * sheetObj.GetCellValue(row, col+19) + parseInt(sheetObj.GetCellValue(k, ttlCol)) * sheetObj.GetCellValue(row, col+20) + parseInt(sheetObj.GetCellValue(k, ttlCol + 1)) * 2;
                    break;
                case "fcast_53ft_qty":
                    totalTeuCol = col - 4;
                    //TEU + HC*2 + 45*2 + 53*2
                    totalTeuValue = parseInt(sheetObj.GetCellValue(k, col - 3)) + parseInt(sheetObj.GetCellValue(k, col - 2)) * sheetObj.GetCellValue(row, col+18) + parseInt(sheetObj.GetCellValue(k, col - 1)) * sheetObj.GetCellValue(row, col+19) + parseInt(sheetObj.GetCellValue(k, col)) * 2;
                    ttlTotalTeuCol = ttlCol - 4;
                    ttlTotalTeuValue = parseInt(sheetObj.GetCellValue(k, ttlCol - 3)) + parseInt(sheetObj.GetCellValue(k, ttlCol - 2)) * sheetObj.GetCellValue(row, col+18) + parseInt(sheetObj.GetCellValue(k, ttlCol - 1)) * sheetObj.GetCellValue(row, col+19) + parseInt(sheetObj.GetCellValue(k, ttlCol - 0)) * 2;
                    break;
                default:
                    totalTeuCol = 0;
                    totalTeuValue = 0;
                    ttlTotalTeuCol = 0;
                    ttlTotalTeuValue = 0;
                    break;
            }
            //1. Changing Total TEU of VVD
            if (totalTeuCol > 0 && totalTeuValue > 0) ChangeValue2(sheetObj, k, totalTeuCol, totalTeuValue);
            //2. Changing Total TEU of TTL
            if (ttlTotalTeuCol > 0 && ttlTotalTeuValue > 0) ChangeValue2(sheetObj, k, ttlTotalTeuCol, ttlTotalTeuValue);
        }
    }
    //==================================================================================================
}

function setChangedStatus(sheetObj, row, col) {
    with(sheetObj) {
        var value = GetCellValue(row, col);
        var colIdx = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
        //======================
        //Calculating VVD Index
        var itemIdx = (col - sheet1.masterColumnCount - colIdx) / sheet1.itemColumnCount;
        //Calculating flag column of VVD
        var flagCol = sheet1.masterColumnCount + itemIdx * sheet1.itemColumnCount + sheet1.infoColumnCount - 1;
        var colFlag = GetCellValue(row, flagCol - 1);
        var colSearchFlag = CellSearchValue(row, flagCol - 1);
        var colArr = colFlag.split(",");
        var fieldIdx = colIdx - sheet1.infoColumnCount;
        if (fieldIdx > 10) fieldIdx = fieldIdx - 12;
        var confirmValue = CellSearchValue(row, col + sheet1.forecastColumnCount + sheet1.bookingColumnCount) * 1;
        var searchValue = CellSearchValue(row, col) * 1;
        var curFlag = GetCellValue(row, flagCol);
        var searchFlag = CellSearchValue(row, flagCol);
        colArr[fieldIdx] = confirmValue == value ? "S" : "D";
        SetCellValue(row, flagCol - 1, colArr, 0);
        SetCellValue(row, flagCol - 3, (colArr + "").indexOf("D") >= 0 ? "D" : "", 0);
        SetCellValue(row, flagCol, (colSearchFlag == (colArr + "") && value == searchValue) ? searchFlag == "" ? "" : "R" : (searchFlag == "" ? "I" : "U"), 0);
        var curRowEdited = false;
        for (var i = 0; i < sheet1.weekCount; i++) {
            var colValue = GetCellValue(row, sheet1.masterColumnCount + sheet1.itemColumnCount * i + sheet1.infoColumnCount - 1);
            if (colValue != "" && colValue != "R") {
                curRowEdited = true;
            }
        }
        if (!curRowEdited) {
            //SetRowStatus(row,"R");
            SetCellValue(row, "editFlg", "R", 0);
        }
    }
}

function vvdChanged(obj) {
    if (obj.value == "") {
        trade_OnChange(comObjects[0], "", "", "", "", comObjects[0].GetSelectText(), comObjects[0].GetSelectCode());
    }
}

function lane_OnChange(comObj, oldindex, oldtext, oldvalue, newindex, text, value) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;
    //    	trade_OnChange(comObjects[0], "" , "" , "" , "" ,  text , comObjects[2].GetSelectText() );
}

function trade_OnChange(combj, oldindex, oldtext, oldvalue, newIndex, text, value) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;

    var formObj = document.form;
    var trade = formObj.trade.value;

    if (trade != null && trade != '') {
        SpcSearchOptionSubTrade("subtrade", true, false, "", formObj.trade.value); // 0207 SHKIM			
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    }
}

function subtrade_OnChange(combj, value, text) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;

    var formObj = document.form;
    var subtrade = formObj.subtrade.value;

    if (subtrade != null && subtrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    }
}

function salesOffice_OnChange(comObj, oldindex, oldtext, oldvalue, newindex, text, value) {
    if (value == "") return;
    var rtn = getCodeList("ChildTeamOffice", "ofc_cd=" + value + "&level=5&include=1");

    initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));
    var subObj = subOffice;
    subOffice_OnChange(subObj, "", "", "", "", subObj.GetSelectText(), subObj.GetSelectCode());
}

function subOffice_OnChange(comObj, oldindex, oldtext, oldvalue, newindex, text, value) {
    var rtn = "";
    if (value == "") {
        rtn = getCodeList("TeamSalesRep", "ofc_cd=" + salesOffice.GetSelectCode() + "&level=4");
    } else {
        rtn = getCodeList("TeamSalesRep", "ofc_cd=" + value + "&level=5");
    }
    initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
}

function initDataValue_salesOffice() {
    salesOffice.SetSelectIndex(0, false);
}

function initData_salesOffice(codes, names) {

    var sheetObj = salesOffice;
    var cnt = 0;
    with(sheetObj) {
        RemoveAll();
        SetTitleVisible(1);
        SetTitle("Office|Name");
        ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고
        SetMaxLength(6);
        SetDropHeight(190);

        if (codes == undefined || codes == null) {
            return;
        }
        if (codes.length > 2) {
            InsertItem(0, "|ALL", "");
        }
        var selectCode = "";
        for (var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[1] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
        }
        if (selectCode != "") {
            SetSelectCode(selectCode);
        } else {
            SetSelectIndex(0, false);
        }
        SetColWidth(0, "60");
        SetColWidth(1, "250");
        SetColAlign(0, "left");
        SetColAlign(1, "left");
    }
}

function initData_subOffice(codes, names) {
    var cnt = 0;
    with(subOffice) {
        RemoveAll();
        SetTitleVisible(1);
        SetTitle("Office|Name");
        ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고
        SetMaxLength(6);

        if (codes == undefined || codes == null) {
            return;
        }

        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }
        var selectCode = "";
        for (var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[1] == "1") {
                selectCode = codes[i];
            }
            //    			alert(codes[i]+"|"+txt[0] +" ::  " +codes[i]);
            InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
        }
        if (selectCode != "") {
            SetSelectCode(selectCode);

        } else {
            SetSelectIndex(0, false);

        }

        SetColWidth(0, "60");
        SetColWidth(1, "250");
        SetColAlign(0, "left");
        SetColAlign(1, "left");
    }
}

function initDataValue_trade() {
    trade.SetSelectIndex(0, false);
}

function initDataValue_subtrade() {
    subtrade.SetSelectIndex(0, false);
}

function initDataValue_lane() {
    lane.SetSelectIndex(0, false);
}

function initDataValue_subOffice() {
    subOffice.SetSelectIndex(0, false);
}

function initData_salesRep(codes, names) {
    var sheetObj = salesRep;
    var cnt = 0;
    with(sheetObj) {
        RemoveAll();
        SetTitle("Code|Name|OFC|OFC NM");
        ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고
        SetMaxLength(20);
        //SetMultiSelect(0);
        //SetMaxSelect(1);
        SetDropHeight(190);
        
        if (codes == undefined || codes == null) {
            return;
        }
        
        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }
        
        var selectCode = "";
        for (var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[3] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + names[i].replace(/~/g, "|"), codes[i]);
        }
        
        if (selectCode != "") {
            SetSelectCode(selectCode);
        } else {
            SetSelectIndex(0, false);
        }

        SetColWidth(0, "60");
        SetColWidth(1, "150");
        SetColWidth(2, "60");
        SetColWidth(3, "100");
        SetColAlign(0, "left");
        SetColAlign(1, "left");
        SetColAlign(2, "left");
        SetColAlign(3, "left");
    }
}

function initDataValue_salesRep() {
    salesRep.SetSelectIndex(0, false);
}

function confirmData(sheetObj, formObj) {
	
    if (document.all.ds2CfrmAll.checked) {
        if (ComShowConfirm("All forecast on the screen will be confirmed to SPC. Continue?") == 0) {
            return;
        }
    } else {    	
    	//20160112.MOD
        if (salesRep.GetSelectCode() == "" && (sheetObj.GetSelectRow() < 3 || ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "srep_usr_id")) == "")) {
            ComShowMessage("Please select a sales rep to be confirmed.");
            return;
        }
        
        var srow = sheetObj.GetSelectRow();
        if (salesRep.GetSelectCode() != "") {
            srow = sheetObj.LastRow(); // Rows - 1;
        }
        
        var srep_cd = ComTrim(sheetObj.GetCellValue(srow, "srep_usr_id"));													//20160112.MOD
        var srep_nm = "[" + ComTrim(sheetObj.GetCellValue(sheetObj.GetCellValue(srow, "rowRep"), "d_srep_usr_nm")) + "]";	//20160112.MOD
        if (ComShowConfirm("Forecast of the selected Sales Rep(" + srep_cd + srep_nm + ") will be confirmed to SPC. Continue?") == 0) {
            return;
        }
    }
    
    if (document.all.ds2CfrmAll.checked) {
        confirmDataAll(sheetObj, formObj);
    } else {
        confirmDataSelectedSalesRep(sheetObj, formObj, srep_cd);
    }
    
    doActionIBSheet(sheetObj, formObj, IBSAVE, true);
}

function confirmRow(sheetObj, formObj, row) {
    if (sheetObj.GetCellValue(row, "treeLevel") * 1 < 4) {
        return;
    }
    var baseColumn = sheet1.masterColumnCount + sheet1.infoColumnCount;
    for (var i = 0; i < sheet1.weekCount; i++) {
        var sCol = baseColumn + sheet1.itemColumnCount * i;
        if (sheetObj.GetCellValue(row, sCol - 4) == "D" || sheetObj.GetCellValue(row, sCol - 1) == "U" || sheetObj.GetCellValue(row, sCol - 1) == "I") {
            confirmItem(sheetObj, formObj, row, sCol, sheet1);
        }
    }
}

function confirmItem(sheetObj, formObj, row, baseColumn, sheetInfo) {
    var rowLane = sheetObj.GetCellValue(row, "rowLane") * 1;
    var rowRep = sheetObj.GetCellValue(row, "rowRep") * 1;
    var rowPol = sheetObj.GetCellValue(row, "rowPol") * 1;
    var rowLanePol = sheetObj.FindText("d_pol_cd", sheetObj.GetCellValue(row, "d_pol_cd"), rowLane);
    var rowLanePod = sheetObj.FindText("d_pod_cd", sheetObj.GetCellValue(row, "d_pod_cd"), rowLane);
    for (var c = baseColumn; c < baseColumn + sheetInfo.forecastColumnCount; c++) {
        selectedCell_OldValue = sheetObj.GetCellValue(row, c + sheetInfo.conformColorDif);
        sheetObj.SetCellValue(row, c + sheetInfo.conformColorDif, sheetObj.GetCellValue(row, c));
        compareConfirmValue(sheetObj, row, c);
        compareConfirmValue(sheetObj, rowPol, c);
        compareConfirmValue(sheetObj, rowRep, c);
        compareConfirmValue(sheetObj, rowLane + 1 + ((ComTrim(sheetObj.GetCellValue(rowLane + 1, "d_pol_cd")) == "") ? 1 : 0), c);
        compareConfirmValue(sheetObj, rowLanePol, c);
        compareConfirmValue(sheetObj, rowLanePod, c);
    }
    sheetObj.SetCellValue(row, baseColumn - 4, 'C', 0);
    sheetObj.SetCellValue(row, baseColumn - 2, 'S,S,S,S,S', 0);
    sheetObj.SetCellValue(rowPol, baseColumn - 4, 'C', 0);
    sheetObj.SetCellValue(rowPol, baseColumn - 2, 'S,S,S,S,S', 0);
    sheetObj.SetCellValue(rowRep, baseColumn - 4, 'C', 0);
    sheetObj.SetCellValue(rowRep, baseColumn - 2, 'S,S,S,S,S', 0);
}

function confirmDataSelectedSalesRep(sheetObj, formObj, srep_cd) {
    var row = 0;
    while ((row = sheetObj.FindText("d_srep_usr_id", srep_cd, row + 1)) > 0) {
        if (ComTrim(sheetObj.GetCellValue(row, "d_srep_usr_id")) == "") {
            continue;
        }
        confirmRow(sheetObj, formObj, row);
    }
}

function confirmDataEdited(sheetObj, formObj) {
    var rowsData = sheetObj.FindStatusRow("U");
    var rows = rowsData.split(";");
    for (var r = 0; r < rows.length - 1; r++) {
        var row = rows[r] * 1;
        confirmRow(sheetObj, formObj, row);
    }
}

function confirmDataAll(sheetObj, formObj) {
    confirmDataEdited(sheetObj, formObj);
    var baseColumn = sheet1.masterColumnCount + sheet1.infoColumnCount;
    for (var i = 0; i < sheet1.weekCount; i++) {
        var sCol = baseColumn + sheet1.itemColumnCount * i;
        var row = 0;
        while ((row = sheetObj.FindText(sCol - 4, "D", row + 1)) > 0) {
            confirmItem(sheetObj, formObj, row, sCol, sheet1);
        }
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSEARCH: //Retrieve
            var sel_vvd = formObj.vvd.value;
            var sel_trade = comObjects[0].GetSelectCode();
            if (sel_vvd == "" && sel_trade == "") {
                ComShowMessage(getMsg("SPC90114", "Trade"));
                formObj.vvd.focus();
                comObjects[0].Focus();
                ComOpenWait(false);
                return false;
            }

            var sel_lane = comObjects[2].GetSelectCode();
            if (sel_vvd == "" && sel_lane == "") {
                ComShowMessage(getMsg("SPC90114", "Lane"));
                comObjects[2].Focus();
                ComOpenWait(false);
                return false;
            }
            var sel_ofc = comObjects[3].GetSelectCode();
            if (sel_ofc == "") {
                ComShowMessage(getMsg("SPC90114", "Sales Office"));
                formObj.vvd.focus();
                if (comObjects[3].GetEnable()) comObjects[3].Focus();
                //comObjects[3].focus();
                ComOpenWait(false);
                return false;
            }
            if (sel_vvd != "" && sel_vvd.length < 9) {
                ComShowCodeMessage("COM12174", "VVD", "9");
                formObj.vvd.Focus();
                ComOpenWait(false);
                return false;
            }
            //return true;
            break;
    }
    return true;
}

/**
 * handling process for input validation
 */
function validateForm2(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSEARCH_ASYNC01: //Retrieve
            var sel_vvd = formObj.vvd.value;
            var sel_trade = comObjects[0].GetSelectCode();
            if (sel_vvd == "" && sel_trade == "") {

                return false;
            }
            var sel_lane = comObjects[2].GetSelectCode();
            if (sel_vvd == "" && sel_lane == "") {
                return false;
            }

            var sel_ofc = comObjects[3].GetSelectCode();
            if (sel_ofc == "") {
                return false;
            }

            if (sel_vvd != "" && sel_vvd.length < 9) {
                return false;
            }
            break;
    }
    return true;
}

function optionSetting() {
    SpcSearchOptionYear("year");
    SpcSearchOptionWeek("week");
    SpcSearchOptionDuration("duration", 5, 4);
    SpcSearchOptionTrade("trade");
    SpcSearchOptionSubTrade("subtrade", true, true);
    SpcSearchOptionLane("lane", true, true);
    SpcSearchOptionBound("bound");
}

function acctCallBack(rtnValue) {
    if (rtnValue == "OK") doActionIBSheet(t1sheet1, document.form, IBSEARCH);
}

/*
 * 
 */
function initCheckBox() {
    var fObj = document.form;

    document.all.ds2POD.checked = false;
    document.all.ds2OTH.checked = false;
    document.all.ds2HC.checked = false;
    document.all.ds245.checked = false;
    document.all.ds253.checked = false;
    document.all.ds2RF.checked = false;
    document.all.ds2WT.checked = false;
    document.all.ds2BKG.checked = true;
    document.all.ds2CFM.checked = false;
    document.all.ds2CfrmAll.checked = true;

    if (fObj.ctrl_lvl_all.value == "D") fObj.chkDs2POD.checked = true;
    var iCheck = fObj.ctrl_tpsz_all.value;
    var arrRow = iCheck.split("|"); //hc, 45, 53, rf, wt 순서
    if (arrRow.length >= 6) {
        if (arrRow[1] == "Y") fObj.chkDs2HC.checked = true;
        if (arrRow[2] == "Y") fObj.chkDs245.checked = true;
        if (arrRow[3] == "Y") fObj.chkDs253.checked = true;
        if (arrRow[4] == "Y") fObj.chkDs2RF.checked = true;
        if (arrRow[5] == "Y") fObj.chkDs2WT.checked = true;
    }
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

function fileImportInfo() {

}