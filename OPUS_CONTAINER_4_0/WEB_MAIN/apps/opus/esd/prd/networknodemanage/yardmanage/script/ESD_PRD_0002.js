/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0002.js
*@FileTitle  : Node Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var nodeCd="";
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var formObject=document.form;
    var param ;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
        case "btn_new":
            sheetObject.RemoveAll();
            var opts=document.form.select2;
            for(var i=opts.length-1; i>0 ; i--) {
            	opts[i].parentNode.removeChild(opts[i]);
            }
            formObject.reset();
            break;
        case "loc_btn":
            param='?classId=' + "COM_ENS_051" + '&loc_cd=' + formObject.location_code_top.value;
            ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 520, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
            break;
        case "node_btn":
            param='?classId=' + "COM_ENS_061" + '&node_cd=' + formObject.node_code_top.value + "&pop_mode=1";
            ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 800, 510, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
            break;
        case "btn_cnt":
            selectCountry('cnt');
            break;
        case "btng_constraint":
            doConstraint(sheetObject);
            break;
        case "btng_yardcct":
            doYardCct(sheetObject);
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('COM12111'));
        } else {
            ComShowMessage(e.message);
        }
    }
}

var cntGb='';
function selectCountry(cnt) {
    cntGb=cnt;
    var frm=document.form;
    var param='?classId=' + "COM_ENS_051"
    if (cntGb == 'cnt') {
        param=param + '&cnt_cd=' + frm.country_code.value;
    }
    ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 770, 510, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}

function getCountry(rowArray) {
    var colArray=rowArray[0];
    var frm=document.form;
    if (cntGb == 'cnt') {
        frm.country_code.value=colArray[3];
    }
}

function getLoc(rowArray) {
    var colArray=rowArray[0];
    document.all.location_code_top.value=colArray[3];
}

function getNode(rowArray) {
    var colArray=rowArray[0];
    document.all.node_code_top.value=colArray[3];
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (k=0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    if (nodeCd != "") {
        formObj=document.form;
        formObj.f_cmd.value=SEARCH;
        sheetObjects[0].DoSearch("ESD_PRD_0002GS.do", PrdFQString(formObj), {Sync:2} );
    }
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'country_code', 'region_code', 'location_code_top', 'node_code_top');
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
	    case 1: //IBSheet1 init
	        with(sheetObj){
	    		var HeadTitle="No.|Type|Node Code|Node Name|Node Type|Remarks";
	
	    		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
	
	    		var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"node_div",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"node_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"node_name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"node_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"node_remark",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	    		InitColumns(cols);
	
	    		SetEditable(0);
	      		SetSheetHeight(140);
	      	}
	        break;

	    case 2: //IBSheet2 init
	        with(sheetObj){
	    		var HeadTitle="seq|Postal Code|District|";
	
	    		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
	
	    		var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
	    		             {Type:"Text",      Hidden:1,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
	    		             ];
	       
	    		InitColumns(cols);
	
	    		SetEditable(0);
	            SetSheetHeight(100);
	    	}
	        break;
    }
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid ;
	var sXml ;
    switch (sAction) {
    case IBSEARCH:  {
        clear_form();
        setCountry();
        if (formObj.country_code.value == '') {
            ComShowMessage(ComGetMsg('PRD90007'));
            return;
        }
        if (formObj.radio1[0].checked) {
        	formObj.node_type_div.value='';
        }
        if (formObj.radio1[1].checked) {
        		formObj.node_type_div.value='Y';
        }
        if (formObj.radio1[2].checked) {
        	formObj.node_type_div.value='Z';
        }
        if (validateForm(sheetObj, formObj, sAction))  {
        	formObj.f_cmd.value = SEARCH;
        }
        ComOpenWait(true);
        setTimeout(function() {
        	sheetObj.DoSearch("ESD_PRD_0002GS.do", PrdFQString(formObj), {Sync:2});
        	ComOpenWait(false);
        }, 1000);
        break;
    }
    case IBSAVE: 
        if (validateForm(sheetObj, formObj, sAction))
            break;
    case IBINSERT: 
        if (validateForm(sheetObj, formObj, sAction))
            sheetObj.DataInsert();
        break;
    case IBCOPYROW: 
        sheetObj.DataCopy();
        break;
    case IBDOWNEXCEL: 
    	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        break;
    case SEARCH02:
        formObj.f_cmd.value=SEARCH02;
        uid="ESD_PRD_0002";
        sXml=sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&chkData=" + validateData + "&" + PrdFQString(formObj));
        retValidate=ComGetEtcData(sXml, "rowCount");
        break;
    case SEARCH05:
        formObj.f_cmd.value=SEARCH05;
        uid="ESD_PRD_0002";
        sXml=sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&chkData=" + validateData + "&" + PrdFQString(formObj));
        retValidate=ComGetEtcData(sXml, "rowCount");
        break;
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++]=tab_obj;
}

/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
    case 1:
        with (tabObj) {
            var cnt=0;
            InsertItem( "Yard", "");
            InsertItem( "Zone", "");
        }
        break;
    }
}

/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
    var objs=document.all.item("tabLayer");
    objs[nItem].style.display="Inline";
    objs[beforetab].style.display="none";
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
    beforetab=nItem;
}

function sheet1_OnSearchEnd(sheetObj) {
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
    }
    return true;
}

function sheet1_OnDblClick(sheetObj, row, col, value) {
    clear_form();
    var node_div=(sheetObj.GetCellValue(row, "node_div") == 'Zone') ? 'Z' : 'Y';
    var node_cd=sheetObj.GetCellValue(row, "node_code");
    if (node_div == 'Z') {
        tabObjects[0].SetSelectedIndex(1);
    } else if (node_div == 'Y') {
        tabObjects[0].SetSelectedIndex(0);
    }
    if (node_div == 'Y') { //Yard
        document.form.f_cmd.value=SEARCH01;
        sheetObjects[1].DoSearch("ESD_PRD_0002GS.do?node_type_div="+node_div+"&node_code="+node_cd, PrdFQString(document.form), {Sync:2} );
        ComEtcDataToForm(document.form, sheetObjects[1]);
        var f=document.form;
        sheetObjects[1].GetEtcData("service_type_marinet") == "Y" ? f.service_type_marinet.checked=true : f.service_type_marinet.checked=false;
        sheetObjects[1].GetEtcData("service_type_barget") == "Y" ? f.service_type_barget.checked=true : f.service_type_barget.checked=false;
        sheetObjects[1].GetEtcData("service_type_cy") == "Y" ? f.service_type_cy.checked=true : f.service_type_cy.checked=false;
        sheetObjects[1].GetEtcData("service_type_cfs") == "Y" ? f.service_type_cfs.checked=true : f.service_type_cfs.checked=false;
        sheetObjects[1].GetEtcData("service_type_railramp") == "Y" ? f.service_type_railramp.checked=true : f.service_type_railramp.checked=false;
        sheetObjects[1].GetEtcData("service_type_pseudoy") == "Y" ? f.service_type_pseudoy.checked=true : f.service_type_pseudoy.checked=false;
    } else if (node_div == 'Z') { // Zone
        document.form.f_cmd.value=SEARCH02;
        sheetObjects[1].DoSearch("ESD_PRD_0002GS.do?node_type_div="+node_div+"&node_code="+node_cd, PrdFQString(document.form), {Sync:2});
        ComEtcDataToForm(document.form, sheetObjects[1]);
    } else {
        ComShowMessage(ComGetMsg('PRD90110',node_div));
    }
}

function changeContinent() {
    var list=document.form.select1;
    var c_code=list.options[list.selectedIndex].value;
    if (c_code != '0') {
        document.form.f_cmd.value=SEARCH19;
        document.form.conti_code.value=c_code;
        document.form.subconti_code.value='';
        document.form.action="ESD_PRD_COM_0002.do";
        document.form.target="HiddenFrame";
        document.form.submit();
    } else {
        document.form.conti_code.value="";
        document.form.subconti_code.value="";
        var opts=document.form.select2;
        for(var i=opts.length-1; i>0 ; i--) {
        	opts[i].parentNode.removeChild(opts[i]);
        }
    }
}

function changeSubContinent() {
    var list=document.form.select2;
    var c_code=list.options[list.selectedIndex].value;
    if (c_code != '0') {
        document.form.f_cmd.value='101';
        document.form.subconti_code.value=c_code;
    } else {
        document.form.subconti_code.value="";
    }
}

function clear_form() {
    nodeForm=document.form;
    // yard
    nodeForm.yard_code.value='';
    nodeForm.location_code.value='';
    nodeForm.yard_name.value='';
    // nodeForm.yd_rep_hub_loc_cd.value = '';
    nodeForm.node_type.value='';
    nodeForm.hub_node.value='';
    nodeForm.service_type_marinet.checked='';
    nodeForm.service_type_barget.checked='';
    nodeForm.service_type_cy.checked='';
    nodeForm.service_type_cfs.checked='';
    nodeForm.service_type_railramp.checked='';
    nodeForm.service_type_pseudoy.checked='';
    // yard contact point
    nodeForm.person.value='';
    nodeForm.email.value='';
    nodeForm.tel.value='';
    // nodeForm.yd_web_site.value = '';
    nodeForm.fax.value='';
    nodeForm.postal_code.value='';
    nodeForm.yard_address.value='';
    // yard service info
    nodeForm.gate_week_open.value='';
    nodeForm.gate_week_close.value='';
    nodeForm.gate_sat_open.value='';
    nodeForm.gate_sat_close.value='';
    nodeForm.gate_sun_open.value='';
    nodeForm.gate_sun_close.value='';
    nodeForm.gate_holiday_open.value='';
    nodeForm.gate_holiday_close.value='';
    nodeForm.average_dwell_r.value='';
    nodeForm.average_dwell_d.value='';
    nodeForm.minimum_dwell_r.value='';
    nodeForm.minimum_dwell_d.value='';
    nodeForm.free_time.value='';
    // yard yard operator
    nodeForm.yard_operator1.value='';
    nodeForm.operator1_name.value='';
    nodeForm.yard_operator2.value='';
    nodeForm.operator2_name.value='';
    nodeForm.yard_operator3.value='';
    nodeForm.operator3_name.value='';
    // yard additional info
    nodeForm.office_code.value='';
    nodeForm.dem_ib_collection.value='';
    nodeForm.dem_ob_collection.value='';
    nodeForm.yard_ownership.value='';
    nodeForm.bonded_yard.value='';
    nodeForm.c_tpat.value='';
    nodeForm.yard_on_off.value='';
    // zone location
    nodeForm.location_code.value='';
    nodeForm.location_name.value='';
    // zone zone
    nodeForm.zone_code.value='';
    nodeForm.zone_name.value='';
    nodeForm.control_office.value='';
    nodeForm.cargo_handling_time.value='';
    // zone representative
    nodeForm.representative_code.value='';
    nodeForm.representative_name.value='';
    nodeForm.distance.value='';
}

function chkCountry(obj) {
    var formObj=document.form;
    var inVal=event.srcElement.value;
    if (inVal.length > 2) {
        formObj.country_code.value=inVal.substring(0, 2);
    }
}

function setCountry() {
	var formObj=document.form;
	var inVal  = formObj.location_code_top.value;
	if(inVal.length > 2) {
		formObj.country_code.value=inVal.substring(0, 2);
	} else {
		inVal=formObj.node_code_top.value;
		if(inVal.length > 2) formObj.country_code.value=inVal.substring(0, 2);
	}
}

function doConstraint(sheetObj) {
    var formObj=document.form;
    var param='?node_cd=' + document.getElementsByName("yard_code")[0].value + "&link_flg=N&mode=pop&pgmNo=ESD_PRD_0024";
    winObject=window.open("/opuscntr/ESD_PRD_0024_POP.do" + param, "OPUSPI", "height=600, width=1280, top=0");
}

function doYardCct(sheetObject) {
    var formObj=document.form;
    var param='?loc_cd=' + document.getElementsByName("location_code")[0].value + "&mode=pop&pgmNo=ESD_PRD_0036";
    winObject=window.open("/opuscntr/ESD_PRD_0036_POP.do" + param, "OPUSPI", "height=450, width=1280, top=0");
}