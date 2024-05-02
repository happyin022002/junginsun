/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0672.js
*@FileTitle : Arrival Notice
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author
 */
/**
 * @extends
 * @class esm_bkg_0672 : esm_bkg_0672 - task script definition for screen
 */
// public variable

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetNames=new Array("t2sheet1","t3sheet1","t4sheet1","t4sheet2");
var sheetCnt=0;
var loadPageCnt=0;
// public  variables 
/* javascript interval identifier */
var intervalId;
/* Save tab1 condition */
var t1s1CondParam="";
/* Save retrieve condtion modifying */
var queryStrChange=true;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
    var shtCnt=0;
    //var t1sheet1Obj = sheetObjects[shtCnt++];//0
    //var t1sheet2Obj = sheetObjects[shtCnt++];//1
    //var t2sheet1Obj = sheetObjects[shtCnt++];//0 ; Arrival Data
    var t2sheet1Obj=sheetObjects["t2sheet1"];
    var t3sheet1Obj=sheetObjects["t3sheet1"];//1 ; Customer
    var t4sheet1Obj=sheetObjects["t4sheet1"];//2
    var t4sheet2Obj=sheetObjects["t4sheet2"];//3
    //var t1sheet3Obj = sheetObjects[shtCnt++]; // for excel t1sheet1
    //var t1sheet4Obj = sheetObjects[shtCnt++]; // for excel t1sheet2
    /*******************************************************/
    var formObject=document.form;
    // try {
    var srcName=ComGetEvent("name");
    if (!ComIsBtnEnable(srcName)) {
        return;
    }
    switch(srcName) {
    	case "vvd":
    		formObject.sch_tp[0].checked=true;
        break;
    	case "bl_no":
    		formObject.sch_tp[2].checked=true;
        break;
    	case "btn_Close":
			ComClosePopup(); 
			break;
        case "vps_eta_dt_start":
            formObject.sch_tp[1].checked=true;
            // var cal=new ComCalendar();
            // cal.select(formObject.vps_eta_dt_start, 'yyyy-MM-dd');
            break;
        case "vps_eta_dt_end":
            formObject.sch_tp[1].checked=true;
            // var cal=new ComCalendarFromTo();
            // cal.select(formObject.vps_eta_dt_start, formObject.vps_eta_dt_end, 'yyyy-MM-dd');
            break;
        case "eta_dt_end":
        	var cal=new ComCalendarFromTo();
        	cal.select(formObject.vps_eta_dt_start, formObject.vps_eta_dt_end, 'yyyy-MM-dd');
        	break;
        case "btn_Retrieve":
            ComSetCookie("esm_bkg_0672_pod_cd", form.pod_cd.value);
            
            
            if(beforetab == 0){//Arrival Data
                doActionIBSheet(t2sheet1Obj,formObject,IBSEARCH,"","");
            }else if(beforetab == 1){//Customer
                doActionIBSheet(t3sheet1Obj,formObject,IBSEARCH,"","");
            }else if(beforetab == 2){//Upload_Match
                doActionIBSheet(t4sheet1Obj,formObject,IBSEARCH,"","");
            }
            break;
        case "btn_DownExcel":
            if(beforetab == 0){
                //doActionIBSheet(t2sheet1Obj,formObject,IBDOWNEXCEL,"","");
                //t2sheet1Obj.Down2Excel(true,false,true);//Exel download
            	
            	if(t2sheet1Obj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		t2sheet1Obj.Down2Excel( {DownCols: makeHiddenSkipCol(				t2sheet1Obj), SheetDesign:1,Merge:1 });
            	}
            }else if(beforetab == 1){
                //doActionIBSheet(t2sheet1Obj,formObject,IBDOWNEXCEL,"","");
                //t3sheet1Obj.Down2Excel(true,false,true);//Exel download
				//t3sheet1Obj.SpeedDown2Excel(-1);
            	if(t3sheet1Obj.RowCount() < 1){//no data
         	       ComShowCodeMessage("COM132501");
         	      }else{
         	    	  t3sheet1Obj.Down2Excel( {DownCols: makeHiddenSkipCol(				t3sheet1Obj), SheetDesign:1,Merge:1 });
         	      }
            }else if(beforetab == 2){
                //doActionIBSheet(t2sheet1Obj,formObject,IBDOWNEXCEL,"","");
            	if(t4sheet1Obj.RowCount() < 1){//no data
         	       ComShowCodeMessage("COM132501");
         	      }else{
         	    	  t4sheet1Obj.Down2Excel({ HiddenColumn:1, SheetDesign:1,Merge:1});
         	      }
            }
            break;
        case "btn_Save":
            if(beforetab == 0){
                doActionIBSheet(t2sheet1Obj,formObject,IBSAVE,"","");
            }else if(beforetab == 1){//Customer
                doActionIBSheet(t3sheet1Obj,formObject,IBSAVE,"","");
            }else if(beforetab == 2){//Upload_Match
                doActionIBSheet(t4sheet1Obj,formObject,IBSAVE,"","");
            }
            break;
        case "btn_ANSend":
            fncANSendClick();
            break;
        /*****  TAB  Arrival Data (S)     *****/
        case "btn_t2selectAll":
            t2sheet1Obj.CheckAll(t2sheet1Obj.SaveNameCol("t2sheet1_Chk"),1);
            break;
        case "btn_t2deSelectAll":
            t2sheet1Obj.CheckAll(t2sheet1Obj.SaveNameCol("t2sheet1_Chk"),0);
            break;
        case "btn_t2cus":
            //go to 0052
            fncT2CustomerInfoClick();
            break;
        case "btn_t2set":
            //go to 0243
            fncT2SetDataClick();
            break;
        /*****     TAB  Arrival Data (E)     *****/
        /*****  TAB  Customer (S)     *****/
        case "btn_t3cust":
            // go to 0243
            fncT3CustomerInfoClick();
            break;
        case "btn_t3multi_contact":
            //go to <8.13>1044
            fncT3MultiContact();
            break;
        case "btn_t3master":
            fncT3MasterDataClick();
            break;
        /*****  TAB  Customer (E)     *****/
        /*****  TAB  Upload & Match Date (S)     *****/
        case "btn_t4downExcel":
        	t4sheet1Obj.Down2Excel({ HiddenColumn:1,SheetDesign:1, Merge:1,AutoSizeColumn:1});
            break;
        case "btn_t4uploadExcel":
        	t4sheet1Obj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
            break;
        /*****  TAB  Upload & Match Date (E)     *****/
        case "btn_code_validate":
            var goUrl="";
            var param="";
            goUrl="/opuscntr/ESM_BKG_1054_POP.do?";
            param += "1=1";
            //param += "&" + "bl_no="+clickBlNo;
            param += "&" + FormQueryString(document.form);
            param += "&pgmNo=ESM_BKG_1054-1";
            param += "&autoSearchFlg=N";
	        ComOpenPopup(goUrl + param, 1024, 678, "", '0,1,1,1,1,1,1', false);
            break;
        case "btn_template":
            var goUrl="";
            var param="";
            goUrl="/opuscntr/ESM_BKG_0375_POP.do?";
            param += "1=1";
            param += "&pgmNo=ESM_BKG_0375&autoSearchFlg=Y";
            //If it is not selected, No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0375",1024,620,false);
            break;
    } // end switch
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheet_obj.id]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    var formObj=document.form;
    for(i=0;i<sheetNames.length;i++){
        ComConfigSheet(sheetObjects[sheetNames[i]] );
        initSheet(sheetObjects[sheetNames[i]] ,i+1);
        ComEndConfigSheet(sheetObjects[sheetNames[i]] );
    }
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    if(parPgmNo == "ESM_BKG_0672-02"){
        tabObjects[0].SetSelectedIndex(1);
    }else if(parPgmNo == "ESM_BKG_0672-03"){
        tabObjects[0].SetSelectedIndex(2)
    }
    loadPageCnt=1;
    initControl();
    initMail();
    if(parAutoSearchFlg != ""){
        formObj.vvd.value=parVvd;
        formObj.vps_eta_dt_start.value=parVpsEtaDtStart;
        formObj.vps_eta_dt_end.value=parVpsEtaDtEnd;
        formObj.pod_cd.value=parPodCd;
        formObj.del_cd.value=parDelCd;
		formObj.pol_cd.value=parPolCd;
        formObj.bl_no.value=parBlNo;
		formObj.cust_cnt_cd.value=parCustCntCd;
		formObj.cust_seq.value=parCustSeq;
		formObj.cust_nm.value=parCustNm;
		formObj.cust_ref_no.value=parCustRefNo;
		formObj.sc_no.value=parSNo;
		
		if(parTsFlg == "Y"){
            formObj.ts_flg.checked=true;
        }
    }else{
        formObj.vvd.focus();
    }
    if (parAutoSearchFlg == "Y" ) {
        //document.getElementById("btn_Retrieve").fireEvent("onclick");
    	doActionIBSheet(sheetObjects[sheetNames[0]],formObj,IBSEARCH,"","");
    	doActionIBSheet(sheetObjects[sheetNames[1]],formObj,IBSEARCH,"","");
    	doActionIBSheet(sheetObjects[sheetNames[2]],formObj,IBSEARCH,"","");
    }
}
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var sheetID=sheetObj.id;
    var cnt=0;
    switch(sheetID) {
        //----------------------------------------
        // Arrival Data
        //----------------------------------------
        case "t2sheet1":      // t2sheet1 init
            with (sheetObj) {
	            var HeadTitle="||Seq.|VVD|B/L No.|D/T|CNTR\nType|DEL|HUB|POD ETA|DEL ETA|Available Date";
	            HeadTitle      += "|Last Free\nto Pick Up|POD\nFIRMS|P/Up\nCY/CFS|P/Up\nFIRMS|Return\nCY|Form|Agent|Remark|is_validated|vsl_cd|skd_voy_no|skd_dir_cd|vsl_nm|ntc_rvis_flg|chk1|chk2|chk3|chk4|chk5|chk6|chk7|chk8|chk9";
	            var prefix="t2sheet1_";
	            SetConfig( { SearchMode:2, MergeSheet:1, Page:20 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Date",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Date",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Date",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_aval_dt", KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Date",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_free_dt", KeyField:0,   CalcLogic:"",   Format:"YmdHm",             PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_firms",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_firms",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rtn_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"an_fom_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chn_agn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:2 },
	                {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"is_validated", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ntc_rvis_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_arr_dt_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_arr_dt_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_aval_dt_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_free_dt_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_yd_cd_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rtn_yd_cd_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"an_fom_cd_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chn_agn_cd_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_nm_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            InitColumns(cols);
	            SetEditable(1);
	            SetColProperty(0, prefix+"an_fom_cd", {ComboText:evtValue, ComboCode:evtCode} );
	            SetWaitImageVisible(0);
//	            SetColProperty(prefix+"pod_arr_dt", {Format:"####-##-#### ##:##"} );
//	            SetColProperty(prefix+"del_arr_dt", {Format:"####-##-#### ##:##"} );
//	            SetColProperty(prefix+"pkup_aval_dt", {Format:"####-##-#### ##:##"} );
//	            SetColProperty(prefix+"pkup_free_dt", {Format:"####-##-##"} );
	            SetAutoRowHeight(0);
	            SetSelectionMode(smSelectionList);
	            SetSheetHeight(450);
                }
            break;
        //----------------------------------------
        // Customer
        //----------------------------------------
        case "t3sheet1":      // t3sheet1 init
            with (sheetObj) {
		            var HeadTitle1="|Seq.|Chg|B/L No.|C/N|A.NF|S/C No.|DEL|Eval.|Data \nSet|Customer \nCode|Customer Name (B/L)|Customer Address(B/L)";
		            HeadTitle1     += "|Fax|Fax|Fax|Fax|Fax|Fax";
		            HeadTitle1     += "|E-mail|E-mail|E-mail|E-mail|E-mail|E-mail";
		            HeadTitle1     += "|is_validated";
		            var HeadTitle2="|Seq.|Chg|B/L No.|C/N|A.NF|S/C No.|DEL|Eval.|Data \nSet|Customer \nCode|Customer Name (B/L)|Customer Address(B/L)";
		            HeadTitle2     += "|CNEE/NTFY IN B/L|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only";
		            HeadTitle2     += "|CNEE/NTFY IN B/L|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only";
		            HeadTitle2     += "|is_validated";
		            var Status=0;
		            var prefix="t3sheet1_";
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20 } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"},
		                        { Text:HeadTitle2, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		                   {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_dp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_an",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"evaluation_yn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_info_set_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_fax_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax3",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eml1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eml2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eml3",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eml4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eml5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"is_validated",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"is_validated",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cmdt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		            InitColumns(cols);
		            SetEditable(1);
		            SetEllipsis(1);
		            SetWaitImageVisible(0);
		            SetColProperty(prefix+"bkg_cust_tp_cd", {ComboText:"CN|NF", ComboCode:"C|N"} );
		            SetSheetHeight(450);
                }
            break;
        //----------------------------------------
        // Upload & Match
        //----------------------------------------
        case "t4sheet1":      // t4sheet1 init
            with (sheetObj) {
	            var HeadTitle1="|Seq.|B/L|B/L";
	            HeadTitle1 += "|Customer|Customer";
	            HeadTitle1 += "|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1";
	            HeadTitle1 += "|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2";
	            HeadTitle1 += "|Hidden|Hidden|Hidden";
	            var HeadTitle2="|Seq.|B/L No.|Name";
	            HeadTitle2 +=  "|Fax|E-mail";
	            HeadTitle2 +=  "|Fax|E-mail";
	            HeadTitle2 +=  "|Fax|E-mail";
	            HeadTitle2 +=  "|bkg_no|bkg_cust_tp_cd";
	            HeadTitle2 +=  "|is_validated";
	            var prefix="t4sheet1_";
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:Status,Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_cust_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"is_validated",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            InitColumns(cols);
	            SetEditable(1);
	            SetEllipsis(1);
	            SetWaitImageVisible(0);
	            SetAutoRowHeight(0);
	            SetSheetHeight(450);
                }
            break;
        case "t4sheet2":      // t4sheet2 init
            with (sheetObj) {
	            var HeadTitle1="| |B/L|B/L";
	            HeadTitle1 += "|Customer|Customer";
	            HeadTitle1 += "|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1";
	            HeadTitle1 += "|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2";
	            var HeadTitle2="| |B/L No.|Name";
	            HeadTitle2 +=  "|Fax|E-mail";
	            HeadTitle2 +=  "|Fax|E-mail";
	            HeadTitle2 +=  "|Fax|E-mail";
	            var prefix="t4sheet2_";
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:Status,Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                   {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_cust_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"is_validated",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            InitColumns(cols);
	            SetSheetHeight(450);
	            SetEditable(1);
                }
            break;
    }
}

var startDate;
var resultMsg;
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    ////sheetObj.ShowDebugMsg = true;
    switch(sAction) {
        case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction)){
                //-------------------------------------
                // Arrival Data
                //-------------------------------------
                if ( sheetObj.id == "t2sheet1"){
                    startDate=new Date();
                    resultMsg="";
                    //delete all data except header
                    formObj.f_cmd.value=SEARCH02;
                    if(formObj.sch_tp[0].checked){
                        formObj.sch_tp.value="V";
                    }else if(formObj.sch_tp[1].checked){
                        formObj.sch_tp.value="D";
                    }else if(formObj.sch_tp[2].checked){
                        formObj.sch_tp.value="B";
                    }
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_0672GS.do" ,FormQueryString(formObj)+ "&" + ComGetPrefixParam("t2sheet1_") );
                }
                else if ( sheetObj.id == "t3sheet1"){
                    //delete all data except header
                    formObj.f_cmd.value=SEARCH03;
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_0672GS.do"
                        ,FormQueryString(formObj)
                        + "&"
                        + ComGetPrefixParam("t3sheet1_")
                        );
                }
                else if ( sheetObj.id == "t4sheet1"){
                    //delete all data except header
                    formObj.f_cmd.value=SEARCH04;
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_0672GS.do"
					
                        ,FormQueryString(formObj)
                        + "&"
                        + ComGetPrefixParam("t4sheet1_")
                        );
                }
            }
            break;
        case IBSAVE:        //Save
            if ( sheetObj.id == "t2sheet1"){
                var prefix="t2sheet1_";
                formObj.f_cmd.value=MULTI02;
                var sParam=FormQueryString(formObj);
                sparam=sParam + "&" + ComGetPrefixParam("t2sheet1_");
                //before modifying
                /*******************************************************************
                    if(! sheetObj.IsDataModified()){
						 //alert("Nothing has been changed after data is retrieved ");
                    	 ComShowCodeMessage('BKG00797');
                         return false;
                    }
                    sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
					********************************************************************/
                // after modifying
				ComOpenWait(true);
//                sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
				if(tabChangeSaveFlag){
	                sheetObj.DoSave("ESM_BKG_0672GS.do", {Param:sparam,Quest:0});
                }else{
	                sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
                }
                tabChangeSaveFlag = false;
                ComOpenWait(false);
            }else if ( sheetObj.id == "t3sheet1"){
                formObj.f_cmd.value=MULTI03;
                var sParam=FormQueryString(formObj);
                sparam=sParam + "&" + ComGetPrefixParam("t3sheet1_");
                if(! sheetObj.IsDataModified()){
                    //alert("Nothing has been changed after data is retrieved ");
                    ComShowCodeMessage('BKG00797');
                    return false;
                }
				//ComOpenWait(true);
//                sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
                if(tabChangeSaveFlag){
                    sheetObj.DoSave("ESM_BKG_0672GS.do", {Param:sparam,Quest:0});
                }else{
                    sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
                }
                tabChangeSaveFlag = false;
            }else if ( sheetObj.id == "t4sheet1"){
                formObj.f_cmd.value=MULTI04;
                var sParam=FormQueryString(formObj);
                sparam=sParam + "&" + ComGetPrefixParam("t4sheet1_");
                if(! sheetObj.IsDataModified()){
                    //alert("Nothing has been changed after data is retrieved ");
                    ComShowCodeMessage('BKG00797');
                    return false;
                }
				//ComOpenWait(true);
//                sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
                if(tabChangeSaveFlag){
                    sheetObj.DoSave("ESM_BKG_0672GS.do", {Param:sparam,Quest:0});
                }else{
                    sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
                }
                tabChangeSaveFlag = false;
            }
            break;
        case IBINSERT:      //input
            break;
        case IBSEARCHAPPEND:
            break;
        case IBDOWNEXCEL:   // EXCEL download
            if (queryStrChange == true) {
                ComShowCodeMessage("BKG03053");
                return;
            }
            break;
    }
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0 ;
                //InsertTab( cnt++ , "Code Validation" , -1 );
                InsertItem( "Arrival Data" , "");
                InsertItem( "Customer" , "");
                InsertItem( "Upload & Match" , "");
                }
            break;
    }
}

//@ 저장 시 확인 메시지 이중으로 표시 안하기 위함.
//var tabChangeSaveFlag=false;
//function tab1_OnClick(tabObj, tabIndex){
//    var formObject=document.form;
//    if(sheetObjects["t2sheet1"].IsDataModified()){
//     //alert("변경된 Data가 있습니다. 저장해주십시오.");
////     ComShowCodeMessage("BKG00986");
////     tabObj.SetSelectedIndex(0);
//    	if(ComShowCodeConfirm("BKG00986")){
//    		tabChangeSaveFlag = true;
//    		doActionIBSheet(sheetObjects["t2sheet1"],formObject,IBSAVE,"","");
//    	}            
//    }else if(sheetObjects["t3sheet1"].IsDataModified()){
//    	//alert("변경된 Data가 있습니다. 저장해주십시오.");
//    	if(ComShowCodeConfirm("BKG00986")){
//    		tabChangeSaveFlag = true;
//    		doActionIBSheet(sheetObjects["t3sheet1"],formObject,IBSAVE,"","");
//    	}
//    }else if(sheetObjects["t4sheet1"].IsDataModified()){
//    	//alert("변경된 Data가 있습니다. 저장해주십시오.");
////     ComShowCodeMessage("BKG00986");
////     tabObj.SetSelectedIndex(2);
//    	if(ComShowCodeConfirm("BKG00986")){
//    		tabChangeSaveFlag = true;
//    		doActionIBSheet(sheetObjects["t4sheet1"],formObject,IBSAVE,"","");
//    	}      
//    }
//}

//@ 저장 시 확인 메시지 이중으로 표시 안하기 위함.
var tabChangeSaveFlag=false;
function tab1_OnBeforeChange(tabObj , nItem){
       var formObject=document.form;
       //alert(tabObj.GetID()+"-"+tabIndex)
       if(sheetObjects["t2sheet1"].IsDataModified()){
       if(ComShowCodeConfirm("BKG00986")){
             tabChangeSaveFlag = true;
             doActionIBSheet(sheetObjects["t2sheet1"],formObject,IBSAVE,"","");
       }            
    }else if(sheetObjects["t3sheet1"].IsDataModified()){
        //alert("변경된 Data가 있습니다. 저장해주십시오.");
       if(ComShowCodeConfirm("BKG00986")){
             tabChangeSaveFlag = true;
             doActionIBSheet(sheetObjects["t3sheet1"],formObject,IBSAVE,"","");
       }
    }else if(sheetObjects["t4sheet1"].IsDataModified()){
       if(ComShowCodeConfirm("BKG00986")){
             tabChangeSaveFlag = true;
             doActionIBSheet(sheetObjects["t4sheet1"],formObject,IBSAVE,"","");
       }      
    }
}

 


/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
    objs[nItem].style.display="Inline";
//    objs[beforetab].style.display="none";
    for(var i = 0; i<objs.length; i++){
        if(i != nItem){
         objs[i].style.display="none";
         objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
        }
     }
//    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    beforetab=nItem;
    //----------------------------------------------------
    //TAB2 select
    //1.If tab2 is selected, VVD  focus on
    //2.using POD output(Cookie)
    //----------------------------------------------------
    if(beforetab == 2){
        ComBtnDisable("btn_DownExcel");
    }else{
        ComBtnEnable("btn_DownExcel");
    }
    if(loadPageCnt == 0) return;
    
    
    setTimeout( function () { //@ setTimeout ###########################################################
    	var t2sheet1Obj=sheetObjects["t2sheet1"];
        var t3sheet1Obj=sheetObjects["t3sheet1"];//1 ; Customer
        var t4sheet1Obj=sheetObjects["t4sheet1"];//2
        var t4sheet2Obj=sheetObjects["t4sheet2"];//3
        var formObject=document.form;
    	if(beforetab == 0){//Arrival Data
    		doActionIBSheet(t2sheet1Obj,formObject,IBSEARCH,"","");
    	}else if(beforetab == 1){//Customer
    		doActionIBSheet(t3sheet1Obj,formObject,IBSEARCH,"","");
    	}else if(beforetab == 2){//Upload_Match
    		doActionIBSheet(t4sheet1Obj,formObject,IBSEARCH,"","");
    	}
    } , 100);//@ setTimeout end ###########################################################
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj=document.form;
    with(formObj){
        switch (sAction){
            case IBSEARCH:
                //if(!ComChkValid(formObj)) return false;
                if(formObj.sch_tp[0].checked == true) {
                    // either del or pod is necessary
                    if(formObj.pod_cd.value == "") {
                        ComShowCodeMessage("BKG40115");
                        return false;
                    }
                    // del-> 2 or 5digit
                    if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                        ComShowCodeMessage("BKG40009");
                        ComSetFocus(formObj.del_cd);
                        return false;
                    }
                }else if(formObj.sch_tp[1].checked == true) {
                    // either del or pod is necessary
                    if(formObj.pod_cd.value == "") {
                        ComShowCodeMessage("BKG40116");
                        return false;
                    }
                    // del-> 2 or 5digit
                    if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                        ComShowCodeMessage("BKG40009");
                        ComSetFocus(formObj.del_cd);
                        return false;
                    }
    		    }else if(formObj.sch_tp[2].checked == true) {
    		    	if(formObj.bl_no.value == "") {
    		    		//msgs['BKG00104']="Mandatory item is missing. Please enter ({?msg1})"
    		    		ComShowCodeMessage("BKG00104","B/L No.");
    		    		return false;
    		    	}
    		    }
                if( formObj.cust_cnt_cd.value.trim() != "" && formObj.cust_seq.value.trim() == "") {
                    ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
                    ComSetFocus(formObj.cust_seq);
                    return;
                } else if( formObj.cust_seq.value.trim() != "" && formObj.cust_cnt_cd.value.trim() == "") {
                    ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
                    ComSetFocus(formObj.cust_cnt_cd);
                    return;
                }
                //alert(ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value));
                if(formObj.sch_tp[0].checked
                    && formObj.vvd.value == ""){
                    ComShowCodeMessage("BKG00626","VVD");
                    ComSetFocus(formObj.vvd);
                    return false;
                }
                if(formObj.sch_tp[1].checked
                    && formObj.vps_eta_dt_start.value == ""){
                    ComShowCodeMessage("BKG00626","POD ETA");
                    ComSetFocus(formObj.vps_eta_dt_start);
                    return false;
                }
                if(formObj.sch_tp[1].checked
                    && formObj.vps_eta_dt_end.value == ""){
                    ComShowCodeMessage("BKG00626","POD ETA");
                    ComSetFocus(formObj.vps_eta_dt_end);
                    return false;
                }
                if(formObj.sch_tp[1].checked
                    && (ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) > 6
                        || ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) < 0 )
                    ){
                    ComShowCodeMessage("BKG40014", "1");
                    ComSetFocus(formObj.vps_eta_dt_end);
                    return false;
                }
                break;
            case IBSAVE:
                if(!ComChkValid(formObj)) return false;
                break;
            case IBDELETE:
                if(!ComChkValid(formObj)) return false;
                break;
        }
        }
    return true;
}
/**
 * initialization task
 * @return
 */
function initControl() {
    //Axon event handling1. event catch
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
//    axon_event.addListenerForm('click', 'obj_click', form );     
//    axon_event.addListenerForm ('activate', 'obj_activate', form);
    // input initialization information
    var formObj=document.form;
    if (parSchTp != null && parSchTp != "") {
        for ( var idx=0; idx < formObj.sch_tp.length; idx ++ ) {
            if (formObj.sch_tp[idx].value == parSchTp ){
                formObj.sch_tp[idx].checked=true;
                break;
            }
        }
    }
    if (parPodCd != null && parPodCd != "") {
        formObj.pod_cd.value=parPodCd;
    } else {
        var sPodCd=ComGetCookie("esm_bkg_0672_pod_cd");
        formObj.pod_cd.value=sPodCd;
    }
    if (parVvd != null && parVvd != "") {
        formObj.vvd.value=parVvd;
        formObj.sch_tp[0].checked=true;
        fnToggleSchTp("V", formObj);  // Search type modifying
    }
    if (parDelCd != null && parDelCd != "") {
        formObj.del_cd.value=parDelCd;
    }
    if (parBlNo != null && parBlNo != "") {
        formObj.bl_no.value=parBlNo;
    }
    //alert(parEvalFlg);
    for(var k=0;k<formObj.is_validated.options.length;k++){
        if(formObj.is_validated.options[k].value == parEvalFlg){
            formObj.is_validated.options[k].selected=true;
        }
    }
    // calendar handling
    formObj.vps_eta_dt_start.value=ComGetNowInfo('ymd','-');
    formObj.vps_eta_dt_end.value=ComGetDateAdd(null, 'd', 6, '-');
}
/**
 * screen object click event handling
 * @return
 */
function obj_click() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "vsl_info_set_flg":
            matchUnmatchSetup();
            break;
        case "sch_tp":
            var vSchTp="";
            for (var i=0; i<formObj.sch_tp.length; i++) {
                if (formObj.sch_tp[i].checked) {
                    vSchTp=formObj.sch_tp[i].value;
                }
            }
            formObj.sch_tp.value=vSchTp;
            fnToggleSchTp(vSchTp, formObj);
            break;
    }
}
function fnToggleSchTp (vSchTp, formObj) {
    if (vSchTp=="B") {  // BL
        document.getElementsByName("bl_no")[0].setAttribute("required", true);
        document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
        document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
    } else if (vSchTp=="V") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
        document.getElementsByName("vvd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
        document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
        document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
    }else if (vSchTp=="D") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        //document.getElementsByName("bl_no")[0].removeAttribute("fullfill");
        document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_eta_dt_start")[0].setAttribute("required", true);
        document.getElementsByName("vps_eta_dt_end")[0].setAttribute("required", true);
    }
}
/**
 * screen object modifying event handling
 * @return
 */
function obj_keyup() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "sch_tp":
        case "vvd":
        case "vps_eta_dt_start":
        case "vps_eta_dt_end":
        case "pod_cd":
        case "del_cd":
        case "bl_no":
        case "cust_cnt_cd":
        case "cust_seq":
        case "cust_nm":
        case "po_no":
        case "sc_no":
            queryStrChange=true;
            break;
    }
}
/**
 * Form Object Active event handling
 * @return
 */
function obj_activate(){
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "vvd":
            formObj.sch_tp[0].checked=true;
            fnToggleSchTp("V", formObj);
            break;
        case "vps_eta_dt_start":
            formObj.sch_tp[1].checked=true;
            fnToggleSchTp("D", formObj);
            formObj.vps_eta_dt_start.value=formObj.vps_eta_dt_start.value.replace(eval("/-/gi"), "");
            break;
        case "vps_eta_dt_end":
            formObj.sch_tp[1].checked=true;
            fnToggleSchTp("D", formObj);
            formObj.vps_eta_dt_end.value=formObj.vps_eta_dt_end.value.replace(eval("/-/gi"), "");
            break;
        case "bl_no":
            formObj.sch_tp[2].checked=true;
            fnToggleSchTp("B", formObj);
            break;
    }
}
/**
  * Initialization Mail
  * @return
  */
function initMail() {
    var formObj=document.form;
    formObj.strUsr_nm.value=strUsr_nm;
    formObj.strUsr_email.value=strUsr_email;
    formObj.strOfc_cd.value=strOfc_cd;
}
/**
 * sending Groupmail
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function mailCustCodeRequest(sheetObj, row, col) {
    var formObj=document.form;
    var mailFrom="From: " + strUsr_email;
    var mailTo="\n To: ...USER INPUT...";
    var mailTitle="\nTitle: Customer Code Request";
    var mailBody1="<br/><br/>Please, create following customer master data in CRM system.";
    var mailBody2="<br/>BKG No. :" + sheetObj.GetCellValue(row, "bkg_no") ;
    var mailBody3="<br/>";
    var mailBody4="<br/><br/>BEST REGARDS";
    var mailBody5="<br/>Staff: " + strUsr_nm;
    var mailBody6="<br/>Office: " + strOfc_cd + "<br/></br>";
    if (sheetObj.GetCellValue(row, "bkg_cust_tp_cd") == "C") {
        mailBody3=mailBody3 + "Consignee";
    } else if (sheetObj.GetCellValue(row, "bkg_cust_tp_cd") == "N") {
        mailBody3=mailBody3 + "Notifier";
    }
    formObj.gw_contents.value="";
    formObj.gw_args[0].value="name;" + strUsr_nm ;
    formObj.gw_args[1].value="message;" + mailBody1 + mailBody2 + mailBody3 + mailBody4 + mailBody5 + mailBody6;
    return true;
}
/**
 * Fill in the appropriate length to move the focus to the next
 */
function fncNextFocusByMax(srcObj,maxLength,nextObj){
    if(srcObj.value.length == maxLength){
        nextObj.focus();
    }
}
/*-------------------------------------------------------------------------------------------*/
//0672_02.js start
/* Arrival Data */
/**
      *
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    if(sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "an_fom_cd"
        || sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "diff_rmk"
        || sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "chn_agn_cd"
        ){
        sheetObj.SetRowStatus(Row,"U");
        t2sheet1_OnClick(sheetObj, Row, Col, Value);
    }
}
//When contact is made with a vertical scroll bar on the bottom of the events that occur Catch
function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObj, document.form, IBSEARCH, CondParam, PageNo);
}
//no support[check again]CLT function t2sheet1_OnScroll(sheetObj,OlGetTopRow()(), OldLeftCol, NewGetTopRow, NewLeftCo) {
//}
//change YYYY-MM-DD to DDMONYY(DDMMMYY) 
function convMM2MMM(mm){
    var mStr=["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    mm=mm.replace('-','');
    mm=mm.replace('-','');
    var vYYYY=mm.substring(0,4);
    var vYY=mm.substring(2,4);
    var vMM=mm.substring(4,6);
    var iMM=eval(vMM);
    var vDD=mm.substring(6,8);
    var retStr=vDD + mStr[iMM-1] + vYY;
    return retStr;
}
//change DDMONYY(DDMMMYY) to  YYYY-MM-DD
function convMMM2MM(mmm){
    var mStr=["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    var iStr=["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
    var vYY=mmm.substring(5,7);
    var vYYYY="20"+vYY;
    var vMMM=mmm.substring(2,5);
    for(var i=0;i<mStr.length;i++){
        if(mStr[i] == vMMM){
            vMM=iStr[i];
            break;
        }
    }
    var vDD=mmm.substring(0,2);
    var retStr=vYYYY + vMM + vDD;
    return retStr;
}
//Tab2 가 Retrieve시
function t2sheet1_retrieve(){
    var formObj=document.form;
    if(formObj.sch_tp[0].checked){
        if(formObj.vvd.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vvd.focus();
        }
    }
    if(formObj.sch_tp[1].checked){
        if(formObj.vps_eta_dt_start.value == "" || formObj.vps_eta_dt_end.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vps_eta_dt_start.focus();
        }
    }
    //2. 날짜 포맷입력 확인 필요.
    var sDate=convMMM2MM(formObj.vps_eta_dt_start.value);
    var eDate=convMMM2MM(formObj.vps_eta_dt_end.value);
    var check3=ComChkPeriod(sDate,eDate);
    if(!(check3 == 1 || check3 == 2)){
        ComShowCodeMessage("BKG00156");
        formObj.vps_eta_dt_end.focus();
    }
    //
    //<EXCEPTION>
    var formObj=document.form;
    //1. The initial state is set to Focus On VVD items
    formObj.vvd.focus();
    //2. Duration : Default FM=retrieve date
    formObj.vps_eta_dt_start.value=convMM2MMM(ComGetNowInfo());
    formObj.vps_eta_dt_end.value=convMM2MMM(ComGetDateAdd(ComGetNowInfo(),'D',14));
}
/**
 * t2sheet1 data retrieve fifnish
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    //1.If there is no result ,save  disable
    //according to is_validated value
    //alert("search "+sheetObj.id + "  end");
    with(sheetObj)
    {
    	
    	if(beforetab == 0){//Arrival Data
    		if(RowCount() < 1){ //fix
    			ComBtnDisable("btn_Save");
    		}else{
    			ComBtnEnable("btn_Save");
    		}
        }    	
        //CheckAll2("t2sheet1_Chk")  = true;
     }
    ComOpenWait(false);
}
var timerId;
/********************************************************
* time management method
**************************************************************/
function startTimer() {
    timerId=setInterval("fncAfterFinishSetting()",200);
}
function stopTimer() {
    clearInterval(timerId);
    endDate=new Date();
    vTime=endDate.getTime() - startDate.getTime();
    vSec=Math.round(vTime/1000);
    resultMsg=resultMsg + "\n(DBretrieve + 화면) 처리시간 : " + vSec + "초입니다.";
    gStartRow=1;
    ComOpenWait(false);
}
var rNum=1;
var gStartRow=1;
/********************************************************
* color management method
**************************************************************/
function fncAfterFinishSetting(){
    var sheetObj=sheetObjects["t2sheet1"];
    with(sheetObj){
        var startRow=gStartRow;
        for(var i=startRow;i <= startRow+100;i++){
        	if(GetCellValue(i,"t2sheet1_"+"is_validated") == "Y"){
                SetCellEditable(i,"t2sheet1_" + "an_fom_cd",1);
                //CellEditable(i,"t2sheet1_" + "diff_rmk") = true;
                SetCellEditable(i,"t2sheet1_" + "chn_agn_cd",1);
            //CellEditable(i,"t2sheet1_" + "Chk") = true;
            //RowBackColor(i) = "#FFFFFF";
            }else{
                SetCellEditable(i,"t2sheet1_" + "an_fom_cd",0);
                //CellEditable(i,"t2sheet1_" + "diff_rmk") = false;
                SetCellEditable(i,"t2sheet1_" + "chn_agn_cd",0);
                //CellEditable(i,"t2sheet1_" + "Chk") = false;
                SetRowBackColor(i,"#FFC0C0");
            }
        	if(GetCellValue(i,"t2sheet1_"+"bl_no") == ""){
        		SetCellFont("FontBold",i,"t2sheet1_"+"vvd",1);
                SetCellEditable(i,"t2sheet1_" + "an_fom_cd",0);
                //CellEditable(i,"t2sheet1_" + "diff_rmk") = false;
                SetCellEditable(i,"t2sheet1_" + "chn_agn_cd",0);
                //line can't change
                SetRowEditable(i,0);
                //Merge
                SetRowMerge(i,1);
                //color setting
                //for(var x=2;x < 19;x++){
                SetRowBackColor(i,"#00C000");
            //}
            }else{
                SetCellValue(i,"t2sheet1_"+"Seq",rNum++);
            }
            sheetObjects["t2sheet1"].SetRowStatus(i,"R");
        }
        gStartRow=startRow + 100;
        window.status=gStartRow + "번까지 종료";
        if(gStartRow >= sheetObj.RowCount()){
            stopTimer();
        }
        }
}
/**
 * Set Data button click event
 * @return
 */
var clickSheetObj;
var clickRow=0;
var clickParam="";
var clickBkg="";
var clickBlNo="";
function fncT2SetDataClick(){
    var goUrl="";
    goUrl="/opuscntr/ESM_BKG_0243.do?";
    if(clickSheetObj == null){
        return;
    }
    if(clickRow < 1){
        //alert("데이터를 선택후 실행하십시오.");
        ComShowCodeMessage("BKG00149");
        return;
    }
    var sRowStr=clickSheetObj.GetSelectionRows("/");
    var arr=sRowStr.split("/");
    var paramVVD="";
    var tmpVVD="";
    if(arr.length == 1
    		&& clickSheetObj.GetCellValue(arr[0],"t2sheet1_"+"bl_no") == ""){
        return;
    }
    for(var x=0;x<arr.length;x++){
    	if(clickSheetObj.GetCellValue(parseInt(arr[x]),"t2sheet1_"+"vvd") != tmpVVD ){
    		paramVVD += clickSheetObj.GetCellValue(arr[x],"t2sheet1_"+"vvd") + "/";
    		tmpVVD=clickSheetObj.GetCellValue(arr[x],"t2sheet1_"+"vvd");
        }
    	if(clickSheetObj.GetCellValue(parseInt(arr[x]),"t2sheet1_"+"bl_no") == ""){
            continue;
    	}else if(clickSheetObj.GetCellValue(parseInt(arr[x]),"t2sheet1_"+"is_validated") != "Y"){
            //alert("Code Validation 된 데이터가 없습니다.");
            //<8.26>Code Validation 된 데이터가 없습니다
            ComShowCodeMessage("BKG04003");
            return;
        }
    }
    form.vvd0243list.value=paramVVD;
    ComOpenWindowCenter(goUrl+encodeURI(clickParam),"ESM_BKG_0243",800,490,true);
}
/**
*  Mouse click event
* to control header click
*/
function t2sheet1_OnMouseDown(sheetObj, button, shift, x, y){
    if(sheetObj.MouseRow()== 0 && sheetObj.MouseCol()== 2){
        sheetObj.SetSelectRow(1);
        sheetObj.SetSelectRow(2);
        sheetObj.SetSelectRow(3);
        sheetObj.SetSelectRow(4);
    }
}
function t2sheet1_OnClick(sheetObj, Row, Col, Value){
    //-Click to pop up where the data passes.
    //-data list
    //1.Arrival Vessel
    //2.VVD   (vvd)
    //3.ETA POD(pod_arr_dt)
    //4.ETA DEL(del_arr_dt)
    //5.Available Date(pkup_aval_dt)
    //6.Last Free Date to Pickup(pkup_free_dt)
    //7.Full CNTR P/UP CY(yd_cstms_no)
    //8.Empty Return CY(rtn_yd_cd)
    //9.A/N Form Type
    //10.chn_agn_cd
    //11.whether to Revise or not
    var colName=sheetObj.ColSaveName(Col);
    clickRow=Row;
    clickSheetObj=sheetObj;
    var arrColNames=new Array("vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd","pod_arr_dt_chk","del_arr_dt_chk","pkup_aval_dt_chk","pkup_free_dt_chk","pkup_yd_cd_chk","rtn_yd_cd_chk","an_fom_cd_chk","chn_agn_cd_chk","vsl_nm_chk", "diff_rmk"
    );
    clickParam="1=1";
    clickParam="&row="+Row;
    //alert(sheetObj.CellText(Row,"t2sheet1_" + "chn_agn_cd"));
    for(var i=0;i<arrColNames.length;i++){
        //Formatted as a date format from the pop-up might receive.
        if(arrColNames[i] != "an_fom_cd"){
        	if(arrColNames[i] == "diff_rmk"){
            	clickParam += "&" + arrColNames[i] + "="+encodeURIComponent(sheetObj.GetCellText(Row,"t2sheet1_" + arrColNames[i]));
            }else{
            	clickParam += "&" + arrColNames[i] + "="+sheetObj.GetCellText(Row,"t2sheet1_" + arrColNames[i]);
            }
        }
        else{     	
            clickParam += "&" + arrColNames[i] + "="+sheetObj.GetCellValue(Row,"t2sheet1_" + arrColNames[i]);
        }
    }
    clickBkg=sheetObj.GetCellText(Row,"t2sheet1_" + "bkg_no");
    clickBlNo=sheetObj.GetCellText(Row,sheetObj.id + "_" + "bl_no");
}
/**
* as Double-click an event occurs
**/
function t2sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName=sheetObj.ColSaveName(Col);
    if( sheetObj.GetCellValue(Row,"t2sheet1_"+"is_validated") == "Y"
        && colName == "t2sheet1_" + "diff_rmk"){
        ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200 );
    }else{
        fncT2SetDataClick();
    }
}
/**
 * Customer Info Popup
 * @return
 */
function fncT2CustomerInfoClick(){
    var goUrl="";
    var param="";
    if(clickSheetObj == null){
        return;
    }
    var sRowStr=clickSheetObj.GetSelectionRows("/");
    var arr=sRowStr.split("/");
    if(arr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG04007");
        return;
    }
    goUrl="/opuscntr/ESM_BKG_0242_POP.do?";
    if(clickBkg == ""){
        //alert("데이터를 선택후 실행하십시오");
        ComShowCodeMessage("BKG00149");
        return;
    }
    param += "1=1";
    //param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);
    param += "&bkg_no="+encodeURI(clickBkg);
    param += "&tab_idx=0";
    param += "&pgmNo=ESM_BKG_0242";
    ComOpenPopup(goUrl + param, 570 , 380, "", "1,0",true);
}
function fncANSendClick(){
    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_0381_POP.do?";
    param += "1=1";
    //param += "&" + "bl_no="+clickBlNo;
	// value initialization
	document.form.f_cmd.value="";
    param += "&" + FormQueryString(document.form);
    param += "&pgmNo=ESM_BKG_0381";
    param += "&autoSearchFlg=Y";
    //If it is not selected, No Action
    //location.href=goUrl + param;
    ComOpenWindowCenter(goUrl + encodeURI(param), "ESM_BKG_0381", 1024, 500, false);
}
/**
 * calling if it is saved
 * @param sheetObj
 * @param errMsg
 * @return
 */
function t2sheet1_OnSaveEnd(sheetObj, errMsg){
    if (errMsg == "") {
        ComBkgSaveCompleted();
		ComOpenWait(false);
    //doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
}
/**
 * seq focus out
 * Put a zero before the number automatically make a six-digit
 * @param obj
 * @return
 */
function fncCustSeqBlur(obj){
    var orgV=obj.value;
    if(orgV.length < 1){
        obj.value="";
    }else{
        obj.value=fncSeqTo6(orgV);
    }
}
/**
 * Put a zero before the number automatically make a six-digit
 * @param str
 * @return
 */
function fncSeqTo6(str){
    var currentObjLen=str.length;
    if(currentObjLen < 1) return;
    var retStr="";
    for(var i=0;i<6-currentObjLen;i++){
        retStr += "0";
    }
    return retStr + str;
}
/**
* set value from 243
**/
function fncSetupFrom243(doc,selectVVD){
    var arrColNames=new Array("pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","chn_agn_cd","ntc_rvis_flg","an_fom_cd","diff_rmk","vsl_nm","pod_arr_dt_chk","del_arr_dt_chk","pkup_aval_dt_chk","pkup_free_dt_chk","pkup_yd_cd_chk","rtn_yd_cd_chk","an_fom_cd_chk","chn_agn_cd_chk","vsl_nm_chk", "diff_rmk_chk");
    var sheetObj=sheetObjects["t2sheet1"];
    var sRowStr=sheetObj.GetSelectionRows("/");
    var arr=sRowStr.split("/");
    if(typeof(sheetObj) != "undefined"){
        for(var x=0;x<arr.length;x++){
            //alert(selectVVD + " " + opener.sheetObjects[0].CellValue(x,"t2sheet1_" + "vvd") );
        	if(selectVVD != sheetObj.GetCellValue(arr[x],"t2sheet1_" + "vvd")
        			|| sheetObj.GetCellValue(arr[x],"t2sheet1_" + "bl_no") == ""){
                continue;
            }
            sheetObj.SetRowStatus(arr[x],"U");
            for(var i=0;i<arrColNames.length;i++){
                var valObj=doc.getElementById(arrColNames[i]);
                if(sheetObj.GetCellValue(arr[x],"t2sheet1_" + "bl_no") == ""){
                    continue;
                }
                var sheetVal=sheetObj.GetCellValue(arr[x],"t2sheet1_" + arrColNames[i]);
                if(arrColNames[i] == "ntc_rvis_flg"){
                    if(valObj.checked){
                        sheetObj.SetCellValue(arr[x],"t2sheet1_" + arrColNames[i],"Y");
                    }else{
                        sheetObj.SetCellValue(arr[x],"t2sheet1_" + arrColNames[i],"N");
                    }
                }else{
                	if (arrColNames[i].indexOf("_chk") > -1 ) {//&& valObj.value != ""
                		if(doc.getElementById(arrColNames[i]).checked){ //ESM_BKG_0243에서 자동 체크된 것만 데이터 수정이 되게 함 20151111
                		var colName = arrColNames[i].substring(0, arrColNames[i].indexOf("_chk"));
                		sheetObj.SetCellValue(arr[x],"t2sheet1_" + colName, valObj.value);
                		}
                    }
                }
            }
        }
    }else{
        alert("부모창이 없습니다");
    }
}
//0672_02.js end
/*-------------------------------------------------------------------------------------------*/
/*-------------------------------------------------------------------------------------------*/
//0672_03.js start
/* Customer */
/**
      *
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
    var colName=sheetObj.ColSaveName(Col);
    //sheetObj.CellValue2(Row,sheetObj.SaveNameCol(sheetObj.id + "_" + "Chk")) = 1;
    if(colName == "t3sheet1_" + "fax1"
        || colName == "t3sheet1_" + "fax2"
        || colName == "t3sheet1_" + "fax3"
        || colName == "t3sheet1_" + "fax4"
        || colName == "t3sheet1_" + "fax5"
        ){
    }
    //<7.29>3.2 Email : As Focus Out, Email format Valdation check 
    if(colName == "t3sheet1_" + "eml1"
        || colName == "t3sheet1_" + "eml2"
        || colName == "t3sheet1_" + "eml3"
        || colName == "t3sheet1_" + "eml4"
        || colName == "t3sheet1_" + "eml5"
        ){
    	if(sheetObj.GetCellValue(Row,Col) != ""
    		&& !ComIsEmailAddr(sheetObj.GetCellValue(Row,Col))){
    		ComShowCodeMessage("BKG00366");
            sheetObj.SelectCell(Row, Col);
            return;
        }
    }
}
//Got to the bottom of the vertical scroll bar event that occurs when a Catch
function t3sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    //    alert('scroll next');
    doActionIBSheet(sheetObj, document.form, IBSEARCH, CondParam, PageNo);
//alert("PageNo " + PageNo);
}
//no support[check again]CLT function t3sheet1_OnScroll(sheetObj,OlGetTopRow()(), OldLeftCol, NewGetTopRow, NewLeftCo) {
//alert('scroll');
//}
//Tab2  Retrieve
function t3sheet1_retrieve(){
    var formObj=document.form;
    if(formObj.sch_tp[0].checked){
        if(formObj.vvd.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vvd.focus();
        }
    }
    if(formObj.sch_tp[1].checked){
        if(formObj.vps_eta_dt_start.value == "" || formObj.vps_eta_dt_end.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vps_eta_dt_start.focus();
        }
    }
    var sDate=convMMM2MM(formObj.vps_eta_dt_start.value);
    var eDate=convMMM2MM(formObj.vps_eta_dt_end.value);
    var check3=ComChkPeriod(sDate,eDate);
    if(!(check3 == 1 || check3 == 2)){
        ComShowCodeMessage("BKG00156");
        formObj.vps_eta_dt_end.focus();
    }
    //
    //<EXCEPTION>
    var formObj=document.form;
    formObj.vps_eta_dt_start.value=convMM2MMM(ComGetNowInfo());
    formObj.vps_eta_dt_end.value=convMM2MMM(ComGetDateAdd(ComGetNowInfo(),'D',14));
}
/**
 * t3sheet1  retrieve finish
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
    //1.If there is no result, save button disable
    //according to is_validated value
    //alert("search t3sheet1 end");
    with(sheetObj)
    {
        SetRowHeight(0,10);
        SetRowHeight(1,10);
        if(beforetab == 1){//Customer
	        if(RowCount() < 1){
	            ComBtnDisable("btn_Save");
	        }else{
	            ComBtnEnable("btn_Save");
	        }
        }        
        ComOpenWait(false);
        return;
        //HKGA33268605
        for(var i=2;i <= RowCount()+1;i++){
        	if(GetCellValue(i,"t3sheet1_"+"ib_cmdt_flg") == "1"){
        		SetRangeFontBold(i,0, i,30,1);
            }
        	if(GetCellValue(i,"t3sheet1_"+"is_validated") == "Y"){
                //CellEditable(i,"t3sheet1_" + "cust_fax_no") = true;
                SetCellEditable(i,"t3sheet1_" + "fax1",1);
                SetCellEditable(i,"t3sheet1_" + "fax2",1);
                SetCellEditable(i,"t3sheet1_" + "fax3",1);
                SetCellEditable(i,"t3sheet1_" + "fax4",1);
                SetCellEditable(i,"t3sheet1_" + "fax5",1);
                //CellEditable(i,"t3sheet1_" + "ntc_eml") = true;
                SetCellEditable(i,"t3sheet1_" + "eml1",1);
                SetCellEditable(i,"t3sheet1_" + "eml2",1);
                SetCellEditable(i,"t3sheet1_" + "eml3",1);
                SetCellEditable(i,"t3sheet1_" + "eml4",1);
                SetCellEditable(i,"t3sheet1_" + "eml5",1);
            }else{
                //CellEditable(i,"t3sheet1_" + "cust_fax_no") = false;
                SetCellEditable(i,"t3sheet1_" + "fax1",0);
                SetCellEditable(i,"t3sheet1_" + "fax2",0);
                SetCellEditable(i,"t3sheet1_" + "fax3",0);
                SetCellEditable(i,"t3sheet1_" + "fax4",0);
                SetCellEditable(i,"t3sheet1_" + "fax5",0);
                //CellEditable(i,"t3sheet1_" + "ntc_eml") = false;
                SetCellEditable(i,"t3sheet1_" + "eml1",0);
                SetCellEditable(i,"t3sheet1_" + "eml2",0);
                SetCellEditable(i,"t3sheet1_" + "eml3",0);
                SetCellEditable(i,"t3sheet1_" + "eml4",0);
                SetCellEditable(i,"t3sheet1_" + "eml5",0);
                SetRowBackColor(i,"#FFC0C0");
            }
        }
        //CheckAll2("t2sheet1_Chk")  = true;
        }
}
/**
 * Set Data button click event
 * @return
 */
var clickParam3="";
function t3sheet1_OnClick(sheetObj, Row, Col, Value){
    //Click to pop up where the data passes.
    //data list
    //1.Arrival Vessel
    //2.VVD   (vvd)
    //3.ETA POD(pod_arr_dt)
    //4.ETA DEL(del_eta_dt)
    //5.Available Date(pkup_aval_dt)
    //6.Last Free Date to Pickup(pkup_free_dt)
    //7.Full CNTR P/UP CY(yd_cstms_no)
    //8.Empty Return CY(rtn_yd_cd)
    //9.A/N Form Type
    //10.Agent
    //11.whether to Revise or not
    var colName=sheetObj.ColSaveName(Col);
    clickRow=Row;
    clickSheetObj=sheetObj;
    clickParam3="1=1";
    vvdByCustomerInfo3=sheetObj.GetCellText(Row,"t3sheet1_" + "vvd");
    custCntCd3=sheetObj.GetCellText(Row,"t3sheet1_" + "cust_cnt_cd");
    custSeq3=sheetObj.GetCellText(Row,"t3sheet1_" + "cust_seq");
    custNm3=sheetObj.GetCellText(Row,"t3sheet1_" + "cust_nm");
    clickBkg=sheetObj.GetCellText(Row,"t3sheet1_" + "bkg_no");
    clickBlNo=sheetObj.GetCellText(Row,"t3sheet1_" + "bl_no");
}
function t3sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName=sheetObj.ColSaveName(Col);
    if((colName == "t3sheet1_" + "cust_nm" || colName == "t3sheet1_" + "cust_addr")){
        if(sheetObj.GetRowHeight(Row) == 20){
            sheetObj.SetRowHeight(Row,0);
            sheetObj.SetColWidth(Col,0);
        }else{
            sheetObj.SetRowHeight(Row,20);
            sheetObj.SetColWidth(Col,180);
        }
    }
    if(colName == "t3sheet1_" + "bl_no"
        || colName == "t3sheet1_" + "bkg_cust_tp_cd"
        || colName == "t3sheet1_" + "sc_no"
        || colName == "t3sheet1_" + "del_cd"
        || colName == "t3sheet1_" + "evaluation_yn"
        || colName == "t3sheet1_" + "vsl_info_set_flg"
        || colName == "t3sheet1_" + "cust_cd"
        ){
        fncT3CustomerInfoClick();
    }
}
/**
 * Customer Info Popup
 * @return
 */
var vvdByCustomerInfo3="";
var custCntCd3="";
var custSeq3="";
var custNm3="";
function fncT3CustomerInfoClick(){
    fncT2CustomerInfoClick();
}
/**
 * Master Data Popup ; get cust_cnt_cd , cust_seq  to 240
 * @return
 */
function fncT3MasterDataClick(){
    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_0240_POP.do?";
    if(custCntCd3 == "" || custSeq3 == ""){
        //alert("데이터를 선택후 실행하십시오");
        ComShowCodeMessage("BKG04007");
        return;
    }
    var sRowStr=clickSheetObj.GetSelectionRows("/");
    var arr=sRowStr.split("/");
    if(arr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG04007");
        return;
    }
    param += "1=1";
    param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);
    param += "&pgmNo=ESM_BKG_0240";
    //If it is not selected No Action
    if(custCntCd3 == "" || custSeq3 == ""){
        return;
    }else{
        //location.href=goUrl + param;
        ComOpenWindowCenter(goUrl + param,"ESM_BKG_0240",1024,670,false);
    }
}
function fncT3MultiContact(){
    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_1044.do?";
    if(clickSheetObj == null){
        ComShowCodeMessage("BKG04007");
        return;
    }
    var sRowStr=clickSheetObj.GetSelectionRows("/");
    var arr=sRowStr.split("/");
    if(arr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG04007");
        return;
    }
    if(custCntCd3 == "" || custSeq3 == ""){
        ComShowCodeMessage("BKG04007");
        return;
    }
    param += "1=1";
    param += "&cust_cnt_cd="+encodeURI(custCntCd3)
    +"&cust_seq="+encodeURI(custSeq3)
    +"&cust_nm="+encodeURIComponent(custNm3)
    ;
    param += "&pgmNo=ESM_BKG_1044";
    //If it is not selected No Action
    //location.href=goUrl + param;
    ComOpenWindowCenter(goUrl + param,"ESM_BKG_1044",800,360,true);
}
function t3sheet1_OnSaveEnd(sheetObj, errMsg){
    if (errMsg == "") {
        ComBkgSaveCompleted();
		ComOpenWait(false);
    //doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
}
//0672_03.js end
/*-------------------------------------------------------------------------------------------*/
/*-------------------------------------------------------------------------------------------*/
//0672_04.js start
/* Upload_Match */
/**
      *
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
function t4sheet1_OnChange(sheetObj, Row, Col) {
    var prefix="t4sheet1_";
    var colName=sheetObj.ColSaveName(Col);
    if(colName == prefix + "fax_no1"
        || colName == prefix + "fax_no2"
        || colName == prefix + "fax_no3"
        ){
    }
    //<8.25>3.2 Email : as Focus Out, Email format Valdation check 
    if(colName == prefix + "ntc_eml1"
        || colName == prefix + "ntc_eml2"
        || colName == prefix + "ntc_eml3"
        ){
    	if(sheetObj.GetCellValue(Row,Col) != ""
    		&& !ComIsEmailAddr(sheetObj.GetCellValue(Row,Col))){
            ComShowCodeMessage("BKG40021");
            sheetObj.SelectCell(Row, Col);
            return;
        }
    }
}
//Got to the bottom of the vertical scroll bar event that occurs when a Catch
  function t4sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    //    alert('scroll next');
    doActionIBSheet(sheetObj, document.form, IBSEARCH, CondParam, PageNo);
//alert("PageNo " + PageNo);
}
//no support[check again]CLT function t4sheet1_OnScroll(sheetObj,OlGetTopRow()(), OldLeftCol, NewGetTopRow, NewLeftCo) {
//alert('scroll');
//}
/**
 * t4sheet1 retrieve finish
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    //1.If there is no result , save button disable
    //according to is_validated value
    //alert("search t4sheet1 end");
    with(sheetObj)
    {
    	if(beforetab == 2){//Upload_Match
    		if(RowCount() < 1){
    			ComBtnDisable("btn_Save");
    		}else{
    			ComBtnEnable("btn_Save");
    		}
        }
        //CheckAll2("t2sheet1_Chk")  = true;
        //data copy to t4sheet2 grid
    	
        var xmlStr=IBS_GetDataSearchXml(sheetObj);//change sheet to xml
        sheetObjects["t4sheet2"].LoadSearchData(xmlStr,{Sync:0} );
        }
    ComOpenWait(false);
}
/**
 * After saving
 * @param sheetObj
 * @param errMsg
 * @return
 */
function t4sheet1_OnSaveEnd(sheetObj, errMsg)
{
    var formObj=document.form;
	ComOpenWait(false);
//if (errMsg != null && errMsg != "") {
//	 ComShowMessage(errMsg);
//}
}
/**
 * after uploading exel
 * @param sheetObj
 * @return
 */
function t4sheet1_OnLoadExcel(sheetObj, result, code, msg){
    var sheetOrg;
    var sheetNew;
    var cnt=0;
    var lineNumber=0;
    var colName=0;
    
    if(isExceedMaxRow(msg)) return;
    
    sheetOrg=sheetObj;
    //sheetNew = sheetObjects[3];
    sheetNew=sheetObjects["t4sheet2"];
    sheetOrg.SetDataAutoTrim(1);
    sheetNew.SetDataAutoTrim(1);
    //alert(sheetOrg.id);
    //alert(sheetNew.id);
    ComBtnDisable("btn_Save");
    
	for(var i=1;i <= sheetOrg.RowCount()+1;i++){
		if(sheetOrg.GetCellValue(i,"t4sheet1_"+"bl_no") == ""){
			sheetOrg.RowDelete(i,false);
		}
	}
    if(sheetOrg.RowCount()!= sheetNew.RowCount()){
        //ComShowMessage("Excel Data의 Row수가 다릅니다.\n다시retrieve후 사용하십시오.");
		ComShowCodeMessage("BKG43041");
        return;
    }
    //alert(sheetOrg.kkkkkk);
    for(var i=2;i <= sheetOrg.RowCount()+1;i++){
        //1.If key value is different , return
        //2.key ; bl_no,cust_nm
        //3.bkg_no,bkg_cust_tp_cd setting 
    	sheetOrg.SetCellValue(i,"t4sheet1_"+"bkg_no",sheetNew.GetCellValue(i,"t4sheet2_"+"bkg_no"));
    	sheetOrg.SetCellValue(i,"t4sheet1_"+"bkg_cust_tp_cd",sheetNew.GetCellValue(i,"t4sheet2_"+"bkg_cust_tp_cd"));
    	sheetOrg.SetCellValue(i,"t4sheet1_"+"is_validated",sheetNew.GetCellValue(i,"t4sheet2_"+"is_validated"));
    }
    for(var i=2;i <= sheetOrg.RowCount()+1;i++){
        //1.If key value is different , return
        //2.key ; bl_no,cust_nm
        //3.bkg_no,bkg_cust_tp_cd setting 
    	if(sheetOrg.GetCellValue(i,"t4sheet1_" + "ntc_eml1") != ""
    		&& !ComIsEmailAddr(sheetOrg.GetCellValue(i,"t4sheet1_" + "ntc_eml1"))){
            ComShowCodeMessage("BKG40021");
            sheetOrg.SelectCell(i, "t4sheet1_"+"ntc_eml1");
            cnt++;
            break;
        }
    	if(sheetOrg.GetCellValue(i,"t4sheet1_" + "ntc_eml2") != ""
    		&& !ComIsEmailAddr(sheetOrg.GetCellValue(i,"t4sheet1_" + "ntc_eml2"))){
            ComShowCodeMessage("BKG40021");
            sheetOrg.SelectCell(i, "t4sheet1_"+"ntc_eml2");
            cnt++;
            break;
        }
    	if(sheetOrg.GetCellValue(i,"t4sheet1_" + "ntc_eml3") != ""
    		&& !ComIsEmailAddr(sheetOrg.GetCellValue(i,"t4sheet1_" + "ntc_eml3"))){
            ComShowCodeMessage("BKG40021");
            sheetOrg.SelectCell(i, "t4sheet1_"+"ntc_eml3");
            cnt++;
            break;
        }
        //ComKeyOnlyNumber(this, "-")
    	if(fncDiff( sheetOrg.GetCellValue(i,"t4sheet1_"+"bl_no"),sheetNew.GetCellValue(i,"t4sheet2_"+"bl_no") )){
            ComShowCodeMessage("BKG40022");
            //alert("bl_no , row : " + i);
            cnt++;
            break;
        }
    	if(fncDiff( sheetOrg.GetCellValue(i,"t4sheet1_"+"cust_nm"),sheetNew.GetCellValue(i,"t4sheet2_"+"cust_nm") )){
            ComShowCodeMessage("BKG40022");
            //alert("cust_nm , row : " + i);
            cnt++;
            break;
        //break;
        }
    }
    if(cnt < 1){
        ComBtnEnable("btn_Save");
    }
}
/**
 * comparison
 * 
 * @param orgStr
 * @param newStr
 * @return
 */
function fncDiff(orgStr,newStr){
    orgStr=orgStr.replace(eval("/\\r\\n/gi"), " ").trim();
    newStr=newStr.replace(eval("/\\r\\n/gi"), " ").trim();
    //alert("["+orgStr+"]" +"["+newStr+"]");
    if(orgStr != newStr){
        return true;
    }else{
        return false;
    }
}
/**
* DblClick->spread out
**/
function t4sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName=sheetObj.ColSaveName(Col);
    var prefix="t4sheet1_";
    //alert(sheetObj.RowHeight(Row));
    //if(colName == "t3sheet1_" + "cust_nm" || colName == "t3sheet1_" + "cust_addr"){
    //	ComShowMemoPad(sheetObj, Row, colName, true, 200, 100, 200 );
    //}
    if((colName == prefix + "cust_nm")){
        if(sheetObj.GetRowHeight(Row) == 20){
            sheetObj.SetRowHeight(Row,0);
            sheetObj.SetColWidth(Col,0);
        }else{
            sheetObj.SetRowHeight(Row,20);
            sheetObj.SetColWidth(Col,200);
        }
    }
}
//0672_04.js end
/*-------------------------------------------------------------------------------------------*/
