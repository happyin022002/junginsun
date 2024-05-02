/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0116.js
*@FileTitle  : booking report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null;
var comboCnt=0;
var tabItem=0;
var seqSheet1=0;
var seqSheet2=0;

 // Event handler processing by button click event
 document.onclick=processButtonClick;

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
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
    
    doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
    
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    
    //MultiCombo
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    initControl();
    document.form.vvd.focus();
 }

/**
 * initializing combo
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj, comboId) {
    comboObj.SetMultiSelect(0);
    comboObj.SetMultiSeparator(",");
    comboObj.SetDropHeight(150);
    comboObj.SetUseAutoComplete(1);
}

/**
 * handling input search condition
 */
function obj_KeyUp() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcValue=window.event.srcElement.getAttribute("value");

    if (ComChkLen(srcValue, srcMaxLength) == "2") {
        ComSetNextFocus();
    }
}

/**
 * Dynamically load HTML Control event in page. <br>
 * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects list in turn
 **/
function initControl() {
    var formObject=document.form;
    //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
    //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
    //axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
    //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리
    //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
}

 /**
  * handling input onkeypress event
  */
 function obj_keypress(){
    switch(event.srcElement.dataformat){
        case "int":
            //num only
            ComKeyOnlyNumber(event.srcElement);
            break;
        case "float":
            //num +"."
            ComKeyOnlyNumber(event.srcElement, ".");
            break;
        case "eng":
            //eng only, eng+num -> ComKeyOnlyAlphabet('num');
            ComKeyOnlyAlphabet();
            break;
        case "engdn":
            //eng lower case, eng lower case+num-> ComKeyOnlyAlphabet('lowernum');
            ComKeyOnlyAlphabet('lower');
            break;
        case "engup":
            //eng upper case, eng upper case+num -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        case "engupnum":
            //eng upper case, eng upper case+num -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('uppernum');
            break;
        default:
            // num only
            ComKeyOnlyNumber(event.srcElement);
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var cnt2=0;
    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with(sheetObj){
                var HeadTitle1="B/L No.|Seq.|Description|Package|Package|Weight(KGS)|Measure(CBM)|R/D|R/D|D/G|A/K|H/G|A/S|Mark & No.|S.Rep.|Shipper|BKG Staff|HTS CD|P.O No.|CMDT|POL";
                
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:0, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_gds",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",                             KeyField:0,   CalcLogic:"",   Format:"",	        PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Package2",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",                         KeyField:0,   CalcLogic:"",   Format:"#,##0",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",     Hidden:0, Width:90,    Align:"Right",  ColMerge:1,   SaveName:"meas_qty",                           KeyField:0,   CalcLogic:"",   Format:"#,##0",	    PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hngr_flg",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"adv_shtg_cd",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_gds_desc",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_cnt_cd",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"doc_usr_id",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hamo_trf_cd",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"po_no",                               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_hs_cd",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
                            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"link" } ];
                
                InitColumns(cols);
                SetEditable(0);
                SetCountPosition(0);
//                SetSheetHeight(330);
                updateSheetSize(sheetObj);
            }
        break;
        case 2:      //t2sheet1 init
            with(sheetObj){
                var HeadTitle1="|B/L No.|To|Attention|Fax.|Container No.|Container No.|Seal|POD|Description|Package|Weight\n(KGS)|Measure\n(CBM)|EX Ref No.";
                
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Chk",           Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"To",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"Attention",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"FaxNo",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ContainerNo",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ContainerNo2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:"Seal",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"Description",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"Package",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Weight",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Measure",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"EXRefNo",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        Wrap:1 },
                            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk_tp",        Wrap:1 },
                            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"link",          Wrap:1 } ];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
//                SetSheetHeight(330);
                updateSheetSize(sheetObj);
            }
        break;
    }
}


$(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
});

$(window).on('resizeEnd', function() {
	 updateSheetSize();
});

function updateSheetSize(sheetObj){
  if(typeof sheetObj == "undefined") {
	for(var i = 0; i < sheetObjects.length; i++) {
		if($("#"+sheetObjects[i].id).offset().top != 0) {
			sheetObj = sheetObjects[i];
			break;
		}
	}
  }
  var obj = $("#" + sheetObj.id).offset();
  var marginDefault = 50;
  if(sheetObj.id == "t2sheet1") {
    marginDefault = 20;
  }
  var marginHeight = obj.top + marginDefault;
  var height = $(window).height();

  with(sheetObj){
     SetSheetHeight(height - marginHeight);
  }
}

// Event handler processing by button name
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    var formObject=document.form;
    try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                    if (tabItem == 0){
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
                    }else{
                        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
                    }
                break;
                case "btn_downexcel":
                    if (tabItem == 0){
                    	if(sheetObject1.RowCount() < 1){
                    		ComShowCodeMessage("COM132501");
                    	}else{
                    		sheetObject1.Down2Excel({ SheetDesign:1 });
                    	}
                    }else{
                    	if(sheetObject2.RowCount() < 1){
                    		ComShowCodeMessage("COM132501");
                    	}else{
                    		sheetObject2.Down2Excel({ SheetDesign:1 });
                    	}
                    }
                break;
                case "btn_new":
                    ComResetAll();
                break;
                case "btn_checkall":
                    checkAll("1");  
                break;
                case "btn_uncheckall":
                    checkAll("0");   
                break;
                case "btn_print":
                    goPrint("CM");
                break;
                case "btn_print2":
                    goPrint("FAX");   
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

// handling of Sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:      // retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.SetWaitImageVisible(0);
            formObj.f_cmd.value=SEARCH;   
            sheetObj.DoSearch("ESM_BKG_0116GS.do",FormQueryString(formObj) );
        break;
        case COMMAND01:      // INIT
            formObj.f_cmd.value=INIT;   
            var searchXml=sheetObj.GetSearchData("ESM_BKG_0116GS.do", FormQueryString(formObj));
            var sXml=searchXml.split("|$$|");
            //R Term
            ComBkgXml2ComboItem(sXml[0], rcv_term_cd, "val", "desc");
            //D Term
            ComBkgXml2ComboItem(sXml[1], de_term_cd, "val", "desc");
        break;
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    if (formObj.vvd.value == '' || formObj.vvd.value.length != 9){
      ComShowCodeMessage("BKG00007");//VVD is not available !             
      formObj.vvd.focus();            
      return false;
    }else{
      formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
      formObj.skd_voy_no.value=formObj.vvd.value.substring(4,8);
      formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
      //alert( formObj.vsl_cd.value + "_" + formObj.skd_voy_no.value + "_" + formObj.skd_dir_cd.value);
    }
    if (formObj.pol_cd.value == '' && formObj.pod_cd.value == ''){
      ComShowCodeMessage("BKG00137");//POL/POD is not available       
      formObj.pol_cd.focus();             
      return false;
    }
    if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value == ''){
      ComShowCodeMessage("BKG00458");//invalid customer code          
      formObj.cust_cnt_cd.focus();
      return false;
    }
    if (formObj.cust_cnt_cd.value == '' && formObj.cust_seq.value != ''){
      ComShowCodeMessage("BKG00458");//invalid customer code          
      formObj.cust_seq.focus();
      return false;
    }
    if (formObj.pol_nod_cd.value != ''){
      formObj.pol_yd_cd.value=formObj.pol_cd.value + formObj.pol_nod_cd.value;
    }
    if (formObj.pod_nod_cd.value != ''){
      formObj.pod_yd_cd.value=formObj.pod_cd.value + formObj.pod_nod_cd.value;
    }
    return true;
}

/**
 * register Tab Object to tabObjects array
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}

/**
 * initializing Tab Object
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem( "C/M" , "");
                InsertItem( "Fax" , "");
            }
        break;
    }
}

/**
 * handling process Tab click event
 */
function tab1_OnChange(tabObj , nItem)
{    
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	tabItem = nItem
	document.form.tab_tp.value = tabItem;
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	beforetab=nItem;
	updateSheetSize();
}
function tab2_OnChange(tabObj , nItem)
{    
	updateSheetSize();
}

/**
 * handling process on search end event
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
    var formObj=document.form;
    with(sheetObj)
    {	var info = {Type: "Int", Align: "Right", Edit: 0,Format:"#,##0"};

        var redColor="#FF0000";
        var blueColor="#0000FF";

        for (var i=1; i <= LastRow(); i ++)
        { 
            if (GetCellValue(i,"link") == "OK"){
                SetCellFontColor(i, "bl_no",blueColor);
                SetCellFontUnderline(i, "bl_no",1);
            }
            InitCellProperty(i, "pck_qty", info);
        }
        formObj.tot_package.value=ComAddComma(GetCellValue(LastRow(), 3));
        formObj.tot_weight.value=ComAddComma(GetCellValue(LastRow(), 5));
        formObj.tot_Measure.value=ComAddComma(GetCellValue(LastRow(), 6));

    }
}

/**
 * handling process on search end event
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
    with(sheetObj)
    {
        var redColor="#FF0000";
        var blueColor="#0000FF";
        var info = {Type: "Int", Align: "Right", Edit: 0,Format:"#,##0"};
        for (var i=1; i <= LastRow(); i ++)
        { 
        	if( GetCellValue( i ,"bl_no").trim() != "" ){
            	InitCellProperty(i, "Chk", {Type: "CheckBox"});
        		
        	}

            SetCellFontColor(i, "bl_no",blueColor);
            SetCellFontUnderline(i, "bl_no",1);
            InitCellProperty(i, "Package", info);
        }
    }
}

/*
 *  Search Option or Item Option Modify
 */
function t1sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    if( colIdx == sheetObj.SaveNameCol("bl_no")){
        var param="?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.GetCellValue(rowIdx, "bkg_no");
//        ComOpenWindowCenter2("/opuscntr/ESM_BKG_0079_Q_POP.do"+param, "Booking Main", 1200,740,true);
        comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
//        ComOpenPopup("ESM_BKG_0079.do?"+param, 1024, 740, "","1,0", false);

    }else if( colIdx == sheetObj.SaveNameCol("misi")){
        var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, "bkg_no");
        ComOpenWindowCenter2("/opuscntr/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
    }
}   

/*
 *  Search Option or Item Option Modify
 */
function t2sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    if( colIdx == sheetObj.SaveNameCol("bl_no")){
        var param="?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.GetCellValue(rowIdx, "bkg_no");
        ComOpenWindowCenter2("/opuscntr/ESM_BKG_0079_Q_POP.do"+param, "Booking Main", 1200,740,true);
    }else if( colIdx == sheetObj.SaveNameCol("misi")){
        var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, "bkg_no");
        ComOpenWindowCenter2("/opuscntr/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
    }
}     

//CHECK BOX >>> CHECKALL,UNCHECKALL
function checkAll(value)
{
    var sheetObj=sheetObjects[1];
    for (var i=1 ; i <= sheetObj.LastRow(); i ++)
    {       
if (sheetObj.GetCellValue(i, "chk_tp") == "C")
        {
            sheetObj.SetCellValue(i, "Chk",value,0);
        }
    }
}

//PRINT >>> Call RD
function goPrint(tp)
{       
    if (tp == "CM"){
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var rdPath="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0779.mrd";
        //var rdParam = "/rv VVD[] POL[] POD[] RD[] BKG_OFFICD[] BKG_STAFF[] CNTR_NO[] BKG_NO[] SALES_REP[] SHIPPER[] OPTION[VVD-CDLC0037E/POL-KRPUS/POD-KRPUS] WHERE[AND A.VSL_CD = 'CDLC' AND A.SKD_VOY_NO = '0037' AND A.SKD_DIR_CD = 'E' AND A.POL_CD = 'KRPUS']";
        var option="";
        var where="";
        if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
        option="OPTION[VVD-" + formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value + "/POL-" + formObj.pol_cd.value;
        where="WHERE[AND D.VSL_CD='" + formObj.vsl_cd.value + "' AND D.SKD_VOY_NO='" + formObj.skd_voy_no.value + "' AND D.SKD_DIR_CD='" + formObj.skd_dir_cd.value + "' "
        if (formObj.pol_cd.value != ""){
            option=option + "/POL-" + formObj.pol_cd.value; 
            where=where + " AND D.POL_CD='" + formObj.pol_cd.value + "'";
        }
        if (formObj.pod_cd.value != ""){
            option=option + "/POD-" + formObj.pod_cd.value; 
            where=where + " AND D.POD_CD='" + formObj.pod_cd.value + "'";
        }
        if (rcv_term_cd.GetSelectText()!= "" || de_term_cd.GetSelectText()!= ""){
            option=option + "/R/D-" + rcv_term_cd.GetSelectText()+ "/" + de_term_cd.GetSelectText();
            if (rcv_term_cd.GetSelectText()!= ""){
                where=where + " AND A.RCV_TERM_CD='" + rcv_term_cd.GetSelectText()+ "'";
            }
            if (de_term_cd.GetSelectText()!= ""){
                where=where + " AND A.DE_TERM_CD='" + de_term_cd.GetSelectText()+ "'";
            }
        }
        if (formObj.bkg_ofc_cd.value != ""){
            option=option + "/BKG Office-" + formObj.bkg_ofc_cd.value; 
            where=where + " AND A.BKG_OFC_CD='" + formObj.bkg_ofc_cd.value + "'";
        }
        if (formObj.cre_usr_id.value != ""){
            option=option + "/BKG Staff-" + formObj.cre_usr_id.value;
            where=where + " AND A.CRE_USR_ID='" + formObj.cre_usr_id.value + "'";
        }
        if (formObj.bkg_no.value != ""){
            option=option + "/BKG No.-" + formObj.bkg_no.value; 
            where=where + " AND A.BKG_NO='" + formObj.bkg_no.value + "'";
        }
        if (formObj.bl_no.value != ""){
            option=option + "/B/L No.-" + formObj.bl_no.value; 
            where=where + " AND A.BL_NO='" + formObj.bl_no.value + "'";
        }
        if (formObj.cntr_no.value != ""){
            option=option + "/CNTR No.-" + formObj.cntr_no.value; 
            where=where + " AND C.CNTR_NO='" + formObj.cntr_no.value + "'";
        }
        if (formObj.ob_srep_cd.value != ""){
            option=option + "/Sales Rep.-" + formObj.ob_srep_cd.value; 
            where=where + " AND A.OB_SREP_CD='" + formObj.ob_srep_cd.value + "'";
        }
        if (formObj.cust_cnt_cd.value != "" || formObj.cust_seq.value != ""){
            option=option + "Shipper-" + formObj.cust_cnt_cd.value + formObj.cust_seq.value; 
            where=where + " AND E.CUST_CNT_CD(+)='" + formObj.cust_cnt_cd.value + "'";
            where=where + " AND E.CUST_SEQ(+)='" + formObj.cust_seq.value + "'";
        }
        option=option + "]";
        where=where + "]";
        //alert("/rv " + option + " " + where);
        formObj.com_mrdTitle.value="C/M Print by VVD";
        formObj.com_mrdBodyTitle.value="C/M Print by VVD";
        formObj.com_mrdPath.value=rdPath;
        formObj.com_mrdArguments.value="/rv " + option + " " + where;
        ComOpenRDPopup();
    }else{
        var sheetObj=sheetObjects[1];
        var formObj=document.form;
        var rdPath="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0780.mrd";
        var bkg_nos="";
        var usr_id=formObj.usr_id.value;
        var firstChk=true;
        if (sheetObj.GetSelectRow()== -1){
            alert(" Please Retrieve");
            return;
        }
        for (var i=1 ; i <= sheetObj.LastRow(); i++){
            if (sheetObj.GetCellValue(i, "Chk") == "1"){
                if (firstChk){
                    bkg_nos += sheetObj.GetCellValue(i, "bkg_no");
                    firstChk=false;
                }else{
                    bkg_nos += "," + sheetObj.GetCellValue(i, "bkg_no");
                }                                   
            }
        }
        firstChk=true;
        var nowBkg_no="";
        var befBkg_no="";
        tempArr=bkg_nos.split(",");
        bkg_nos="";
        for (var i=0 ; i < tempArr.length ; i++){
            nowBkg_no=tempArr[i];
            if (i != 0){
                befBkg_no=tempArr[i-1];
            }
            if (befBkg_no != nowBkg_no){
                if (firstChk){
                    bkg_nos += "'" + tempArr[i] + "'"; 
                    firstChk=false;
                }else{
                    bkg_nos += ",'" + tempArr[i] + "'"; 
                }   
            }
        }
        formObj.com_mrdTitle.value="C/M Print by VVD";
        formObj.com_mrdBodyTitle.value="C/M Print by VVD";
        formObj.com_mrdPath.value=rdPath;
        formObj.com_mrdArguments.value="/rv BKG_NOS[" + bkg_nos + "] USR_ID[" + usr_id + "]";
        ComOpenRDPopup();
    }
}
function t2sheet1_OnChange(sheetObj, row, col, value) {     
    if (col == 0){
        for (var i=1 ; i <= sheetObj.LastRow(); i++){
            if (sheetObj.GetCellValue(row,"bl_no") == sheetObj.GetCellValue(i,"bl_no")){
                sheetObj.SetCellValue(i, "Chk",value,0);
            }
        }
    }
}
/* developers work end */
