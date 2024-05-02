/*=========================================================
*@FileName   EES_DMT_1001.js
*@FileTitle  : Basic Tariff Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends     
     * @class EES_DMT_1001 : EES_DMT_1001 for generating business from the screen using a script is defined.
     */
    /* Developer's task   */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    //  business global variables
    var CONTINENT="CONTI";
    var COUNTRY="CNT";
    var REGION="RGN";
    var STATE="STE";
    var LOCATION="LOC";
    var YARD="YD";
    var COMMON_TARIFF_CD="common_tariff_cd"; 
    var ROWMARK="|";
    var FIELDMARK="=";
    var ORIGIN="Origin";
    var DESTINATION="Destination";
    var IBSAVE2=51;   
    var isNoChangeActive=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	var currSvrId="";
	var currDmdtTrfCd="";
	var currTrfSeq="";
	var currTrfGrpSeq="";
	var currCntrTpCd="";
	var currCgoTpCd="";
	var DEF_SHEET_HEIGHT = 228;
	var SUB_SHEET_HEIGHT = 134;			
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcObj=window.event.srcElement;
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn_New":
                    initControl();
                    GetEnableControls();
                    break;
                case "btn_Create":
                    if(ComIsBtnEnable(srcName)) {
                        openPopup(sheetObject1, formObject, srcName);
                    }
                    break;
                case "btn_Update":
                    if(ComIsBtnEnable(srcName)) {
                        openPopup(sheetObject1, formObject, srcName);
                    }
                    break;
                case "btn_Confirm":
                    if(ComIsBtnEnable(srcName)) {
                        //Confirm 실행
                        doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    }
                    break;
                case "btn_Expire":
                    if(ComIsBtnEnable(srcName)) {
                        openPopup(sheetObject1, formObject, srcName);
                    }
                    break;
                case "btn_ConfirmCancel":
                    if(ComIsBtnEnable(srcName)) {
                        //ConfirmCancel
                        doActionIBSheet(sheetObject1,formObject,IBSAVE2);
                    }
                    break;
                case "btn_Delete":
                    if(ComIsBtnEnable(srcName)) {
                        doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    }
                    break;
                case "btn_Copy":
                    if(ComIsBtnEnable(srcName)) {
                        openPopup(sheetObject1, formObject, srcName);
                    }
                    break;
                case "btn_Downexcel":
                    t1901SpeedDownExcel();
//                  doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
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
    	initButton();
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        initAxonControl();
    //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
        var formObj=document.form;
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
    }
    /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
		              var HeadTitle="|Group Name|Effective Date|Expiration Date|User Office|CNTR Type|Cargo Type|rgn_cfm_flg|grp_cfm_flg|trf_seq|svr_id|xcld_sat_flg|xcld_sun_flg|xcld_hol_flg|dmdt_chg_cmnc_tp_nm|cmnc_hr|curr_cd|eff_day|dmdt_trf_cd|dmdt_cntr_tp_cd|dmdt_cgo_tp_cd|trf_grp_seq";
		              var headCount=ComCountHeadTitle(HeadTitle);
		
		              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"user_office",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trf_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_cmnc_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmnc_hr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eff_day",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trf_grp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetDataAutoTrim(0);
		              SetCountPosition(0);
		              SetSheetHeight(DEF_SHEET_HEIGHT);
                }
                break;
            case 2:      // sheet3 init
                with(sheetObj){
		              var HeadTitle="|CNTR Q'ty|CNTR Q'ty|Free Day";
		              var HeadTitle2="|From|Up To|Free Day";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_fm_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_to_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
		               
		              InitColumns(cols);
		              SetCountPosition(0);
		              SetEditable(1);
		              SetSheetHeight(SUB_SHEET_HEIGHT);
                }
                break;
            case 3:      // sheet4 init
                with(sheetObj){
		              var HeadTitle="|Over Day|Over Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day";
		              var HeadTitle2="|From|Up To|20 FT|40 FT|H/C|45 FT";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_und_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cntr_20ft_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 },
		                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cntr_40ft_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 },
		                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cntr_hc_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_45ft_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 } ];
		               
		              InitColumns(cols);
		              SetCountPosition(0);
		              SetEditable(1);
		              SetSheetHeight(SUB_SHEET_HEIGHT);
                }
                break;
            case 4:      // sheet4 init
                with(sheetObj){
		              var HeadTitle1="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
		              var HeadTitle2="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|expire_chk|wknd1|wknd2";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		
		              SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("eff_dt"), MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"covrg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_dest",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_grp_seq" },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_cmnc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"free_time",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"over_day",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_hc_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"expire_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		               
		              InitColumns(cols);
		              SetCountPosition(0);
		              SetEditable(1);
		              FrozenCols=SaveNameCol("eff_dt");
		              SetSheetHeight(SUB_SHEET_HEIGHT);
              	}
                break;
        }
    }
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            //조회
            case IBSEARCH:
                if (sheetObj.id == "sheet1") {
                    if(ComGetObjValue(formObj.combo5) == "") {
                        ComSetObjValue(formObj.yd_cd1, "");
                    }
                    ComSetObjValue(formObj.f_cmd, SEARCH);
                    setParameters(SEARCH);
                    ComSetObjValue(formObj.cnt_cd, comboObjects[2].GetSelectCode());
                    if (validateForm(sheetObj,formObj,sAction)) {
                        initResultControls();
                        initResultText();
                        //ComOpenWait Start
                        sheetObj.WaitImageVisible = false;
                        ComOpenWait(true);
                        var sXml=sheetObj.GetSearchData("EES_DMT_1001GS.do", FormQueryString(formObj));
                        sheetObj.LoadSearchData(sXml,{Sync:1} );
                        wknd1.innerHTML=ComGetEtcData(sXml, "WKND1");
                        wknd2.innerHTML=ComGetEtcData(sXml, "WKND2");
                        ComSetObjValue(formObj.wknd1, ComGetEtcData(sXml, "WKND1"));
                        ComSetObjValue(formObj.wknd2, ComGetEtcData(sXml, "WKND2"));
//                        //ComOpenWait End
//                        ComOpenWait(false);
//                        wknd1.innerHTML=ComGetEtcData(sXml, "WKND1");
//                        wknd2.innerHTML=ComGetEtcData(sXml, "WKND2");
//                        ComSetObjValue(formObj.wknd1, ComGetEtcData(sXml, "WKND1"));
//                        ComSetObjValue(formObj.wknd2, ComGetEtcData(sXml, "WKND2"));
//                    	if (sheetObj.RowCount()> 0) {
//                    		with(sheetObj) {
//								currSvrId=GetCellValue(GetSelectRow(), "svr_id");
//								currDmdtTrfCd=GetCellValue(GetSelectRow(), "dmdt_trf_cd");
//								currTrfSeq=GetCellValue(GetSelectRow(), "trf_seq");
//								currTrfGrpSeq=GetCellValue(GetSelectRow(), "trf_grp_seq");
//								currDmdtCntrTpCd=GetCellValue(GetSelectRow(), "dmdt_cntr_tp_cd");
//								currDmdtCgoTpCd=GetCellValue(GetSelectRow(), "dmdt_cgo_tp_cd");
//                    		}
//                            sheetObj.SelectCell(1,1);
//                            sheet1_OnClick(sheetObj, 1, 1, "");
//                    	}                        
//                        DisableControls();
                    }
                }else if(sheetObj.id == "sheet2") {
                    ComSetObjValue(formObj.f_cmd, SEARCH01);
                    setParameters(SEARCH01);
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSearchData("EES_DMT_1001GS.do", FormQueryString(formObj) );
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    //ComOpenWait End
                    ComOpenWait(false);
                    sheetObj.SetCellValue(sheetObj.LastRow(), "ft_to_qty","");
                } else if(sheetObj.id == "sheet3") {
                    ComSetObjValue(formObj.f_cmd, SEARCH02);
                    setParameters(SEARCH02);
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSearchData("EES_DMT_1001GS.do", FormQueryString(formObj) );
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    //ComOpenWait End
                    ComOpenWait(false);
                    sheetObj.SetCellValue(sheetObj.LastRow(), "ft_und_dys","");
                } else if (sheetObj.id == "sheet4") {
                    ComSetObjValue(formObj.f_cmd, SEARCH04 ); 
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj.DoSearch("EES_DMT_1001GS.do", FormQueryString(formObj) );
                    
                }
                break;
            //Confirm
            case IBSAVE:
                ComSetObjValue(formObj.f_cmd, MODIFY ); 
                setParameters(MODIFY);
                if(!validateForm(sheetObj,formObj,sAction)) return;
                if(ComShowCodeConfirm('DMT00122')) {
                	for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
                        sheetObj.SetRowStatus(i,"R");
                    }
                    for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
                        sheetObj.SetRowStatus(i,"U");
                    }
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj.DoSave("EES_DMT_1001GS.do", FormQueryString(formObj), -1, false);
                    //ComOpenWait End
//                    ComOpenWait(false);
//                    doActionIBSheet(sheetObj,formObj,IBSEARCH);
                }
                break;
            //Confirm Cancel
            case IBSAVE2:
                ComSetObjValue(formObj.f_cmd, MODIFY01 ); 
                setParameters(MODIFY01);
                if(!validateForm(sheetObj,formObj,sAction)) return;
                if(ComShowCodeConfirm('DMT01137')) {
                	for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
	                    sheetObj.SetRowStatus(i,"R");
	                }
	                for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
	                    sheetObj.SetRowStatus(i,"U");
	                }
	                //ComOpenWait Start
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.DoSave("EES_DMT_1001GS.do", FormQueryString(formObj), -1, false);
	                //ComOpenWait End
//	                ComOpenWait(false);
//	                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                }
                break;
            //Delete
            case IBDELETE:
                ComSetObjValue(formObj.f_cmd, REMOVE ); 
                setParameters(REMOVE);
                if(!validateForm(sheetObj,formObj,sAction)) return;
                if(ComShowCodeConfirm('DMT01147')) {
                	for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
                        sheetObj.SetRowStatus(i,"R");
                    }
					var trf_seq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_seq");
					var grp_seq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_grp_seq");
                    sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
//                    for(var i=1; i< sheetObj.TotalRows+1; i++) {
//                        sheetObj.RowStatus(i) = "D";
//                    }
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj.DoSave("EES_DMT_1001GS.do", FormQueryString(formObj), -1, false);
                    //ComOpenWait End
//                    ComOpenWait(false);
//                    doActionIBSheet(sheetObj,formObj,IBSEARCH);
                }
                break;
            case IBDOWNEXCEL:   // EXCEL DOWNLOAD
                if (sheetObj.id == "sheet1") {
                	if(sheetObj.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                		}else{
                			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                		}
                }; 
                break;
        }
    }
    /**
     * EES_DMT_1002, EES_DMT_1102 call popup
     * @param url
     * @param sheetObj
     * @param formObject
     * @param srcName   button name(btn_Create, btn_Update, btn_Expire, btn_Copy)
     * @return
     */
    function openPopup(sheetObj, formObj, srcName) {
        if(srcName == "btn_Create") {
        	var exp_dt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt");
            var iCnt=0;
            if(sheetObj.GetTotalRows()== 10) {
                if(exp_dt == "") {
                    ComShowCodeMessage('DMT00116');//Pls expire the previous tariff first!
                    return;
                }
            }
            //exp_dt dup check
            for(var i=1; i< sheetObj.GetTotalRows()+1 ; i++) {
            	if(exp_dt != sheetObj.GetCellValue(i, "exp_dt")) {
                    iCnt++;
                }
            }
            if(iCnt > 0) {
                ComShowCodeMessage('DMT00117');//Expiration Date different! Pls create tariff group separately!
                return;
            }
            var url="EES_DMT_1002.do"
                        +"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
                        +"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
                        +"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
                        +"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
                        +"&cvrg_rgn_cd="+ComGetObjValue(formObj.cvrg_rgn_cd)
                        +"&cvrg_ste_cd="+ComGetObjValue(formObj.cvrg_ste_cd)
                        +"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
                        +"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
                        +"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
                        +"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
                        +"&org_dest_rgn_cd="+ComGetObjValue(formObj.org_dest_rgn_cd)
                        +"&org_dest_ste_cd="+ComGetObjValue(formObj.org_dest_ste_cd)
                        +"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
                        +"&button_mode=C"
						+"&dmdt_bzc_trf_grp_nm="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_bzc_trf_grp_nm")
						+"&exp_dt="+ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt"))
                        +"&wknd1="+ComGetObjValue(formObj.wknd1)
                        +"&wknd2="+ComGetObjValue(formObj.wknd2)
                        +"&svr_id="+ComGetObjValue(formObj.svr_id)
                        +"&trf_seq="+ComGetObjValue(formObj.trf_seq)
                        +"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
                        +"&ui_code=1001"
                        ;
            //ComOpenWindowCenter(url, "myWin", "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=926,height=680", true);
            ComOpenPopup(url, "1000", "750", "findCommodity", "0,1", true);
//            var returnValue=ComOpenWindowCenter(url, "EES_DMT_1002", "926","800", true);
//            if(returnValue == "Y") {
//                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//            }
        }else if(srcName == "btn_Update") {
            var rowIndex=sheetObj.GetSelectRow();
            if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "Y") {
                ComShowCodeMessage('DMT00118');//Already confirmed!'
                return;
            }           
            var exp_dt="";
            var exp_dt_check=false;
            var isFirst=false;
            for(var i=1; i< sheetObj.GetTotalRows()+1 ; i++) {
            	if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) == "") {
                    continue;
                }
                if(!isFirst) {
                    isFirst=true;
                    exp_dt=ComTrim(sheetObj.GetCellValue(i, "exp_dt"));
                    continue;
                }
                if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) != exp_dt) {
                    exp_dt_check=true;
                    break;
                }
                exp_dt=ComTrim(sheetObj.GetCellValue(i, "exp_dt"));
            }
            if(exp_dt_check) {
                ComShowCodeMessage('DMT00127');//Expiration Date different! Pls create tariff group separately!
                return;
            }
            var url="EES_DMT_1002.do"
                +"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
                +"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
                +"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
                +"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
                +"&cvrg_rgn_cd="+ComGetObjValue(formObj.cvrg_rgn_cd)
                +"&cvrg_ste_cd="+ComGetObjValue(formObj.cvrg_ste_cd)
                +"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
                +"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
                +"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
                +"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
                +"&org_dest_rgn_cd="+ComGetObjValue(formObj.org_dest_rgn_cd)
                +"&org_dest_ste_cd="+ComGetObjValue(formObj.org_dest_ste_cd)
                +"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
                +"&button_mode=U"
                +"&exp_dt="+ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt"))
                +"&wknd1="+ComGetObjValue(formObj.wknd1)
                +"&wknd2="+ComGetObjValue(formObj.wknd2)
                +"&svr_id="+ComGetObjValue(formObj.svr_id)
                +"&trf_seq="+ComGetObjValue(formObj.trf_seq)
                +"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
                +"&ui_code=1001"
                ;
            //ComOpenWindowCenter(url, "myWin", "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=926,height=680", true);
            ComOpenPopup(url, "1000", "750", "findCommodity", "0,1", true);
//            var returnValue=ComOpenWindowCenter(url, "EES_DMT_1002", "926","800", true);
//            if(returnValue == "Y") {
//                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//            }
        }else if(srcName == "btn_Expire") {
            var rowIndex=sheetObj.GetSelectRow();
            if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "N") {
                ComShowCodeMessage('DMT00123');//Not in confirmed staus!'
                return;
            }
            if(ComShowCodeConfirm('DMT01131')) {
            	if(ComShowCodeConfirm('DMT01149')) {
	                var url="EES_DMT_1002.do"
	                    +"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
	                    +"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
	                    +"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
	                    +"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
	                    +"&cvrg_rgn_cd="+ComGetObjValue(formObj.cvrg_rgn_cd)
	                    +"&cvrg_ste_cd="+ComGetObjValue(formObj.cvrg_ste_cd)
	                    +"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
	                    +"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
	                    +"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
	                    +"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
	                    +"&org_dest_rgn_cd="+ComGetObjValue(formObj.org_dest_rgn_cd)
	                    +"&org_dest_ste_cd="+ComGetObjValue(formObj.org_dest_ste_cd)
	                    +"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
	                    +"&button_mode=E"
	                    +"&exp_dt="+ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt"))
	                    +"&wknd1="+ComGetObjValue(formObj.wknd1)
	                    +"&wknd2="+ComGetObjValue(formObj.wknd2)
	                    +"&svr_id="+ComGetObjValue(formObj.svr_id)
	                    +"&trf_seq="+ComGetObjValue(formObj.trf_seq)
	                    +"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
	                    +"&ui_code=1001"
	                    ;
	                //ComOpenPopup(url, 926, 680,  'popupFinish', '1,0,1,1,1,1,1,1', false);
	                //ComOpenWindowCenter(url, "myWin", "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=926,height=680", true);
	                ComOpenPopup(url, "1000", "750", "findCommodity", "0,1", true);
//	                var returnValue=ComOpenWindowCenter(url, "EES_DMT_1002", "926","800", true);
//	                if(returnValue == "Y") {
//	                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//	                }
            	}
            }
        }else if(srcName == "btn_Copy") {
            //parameter
            var cvrg_rgn_cd="";
            var cvrg_ste_cd="";
            var org_dest_rgn_cd="";
            var org_dest_ste_cd="";
            if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
                cvrg_rgn_cd="";
                cvrg_ste_cd=ComGetObjValue(formObj.cvrg_ste_cd);
            }else {
                cvrg_rgn_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
                cvrg_ste_cd="";
            }
            if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
                org_dest_rgn_cd="";
                org_dest_ste_cd=ComGetObjValue(formObj.org_dest_ste_cd);
            }else {
                org_dest_rgn_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
                org_dest_ste_cd="";
            }
            var url="EES_DMT_1101.do"
                +"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
                +"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
                +"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
                +"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
                +"&cvrg_rgn_cd="+cvrg_rgn_cd
                +"&cvrg_ste_cd="+cvrg_ste_cd
                +"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
                +"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
                +"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
                +"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
                +"&org_dest_rgn_cd="+org_dest_rgn_cd
                +"&org_dest_ste_cd="+org_dest_ste_cd
                +"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
                +"&svr_id="+ComGetObjValue(formObj.svr_id)
                +"&trf_seq="+ComGetObjValue(formObj.trf_seq)
                +"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
                +"&ui_code=1001"
                ;
            var returnValue=ComOpenWindowCenter(url, "EES_DMT_1101", "921","355", true);
//          if(returnValue == "Y") {
//              doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//          }
        }
    }

  	function findCommodity(rtnVal) {
  		var formObj = document.form;
  		var sheetObj=sheetObjects[0];
        if(rtnVal == "Y") {
        	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
   }
  	
    function initAxonControl() { 
        axon_event.addListenerFormat('blur',    'obj_blur',     form);   
    }
    function obj_blur() {
        obj=ComGetEvent();
        if(obj.value.length > 0 && obj.value.length < 5) {
            ComShowCodeMessage('DMT00110');
            ComClearObject(obj);
        }
    }
	function obj_keydown() {
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyValue != 13) return;
		var obj=event.srcElement;
		var formObj=document.form;
		if(!doCheckBKGNo(obj)) return;
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        var msg="";
        with(formObj) {
            switch(sAction) {
                case IBSEARCH:      
                    //Coverage Continent Valid check
                    if(ComTrim(ComGetObjValue(formObj.dmdt_trf_cd)) == "") {
                        ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Tariff Type"));
                        return false;
                    }
                    //Coverage Continent Valid check
                    if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
                        ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Continent"));
                        return false;
                    }
                    //Coverage Country Valid check
                    if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
                        ComAlertFocus(formObj.combo3, ComGetMsg('COM12113', "Coverage Country"));
                        return false;
                    }
                    if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMOF" || ComGetObjValue(formObj.dmdt_trf_cd) == "DTOC" || 
                        ComGetObjValue(formObj.dmdt_trf_cd) == "CTOC") {
                        msg=DESTINATION;
                    } else if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMIF" ||  ComGetObjValue(formObj.dmdt_trf_cd) == "DTIC" || 
                        ComGetObjValue(formObj.dmdt_trf_cd) == "CTIC") {
                        msg=ORIGIN;
                    }
                    //Orgin/Dest Continent Valid check
                    if(ComTrim(ComGetObjValue(formObj.org_dest_conti_cd)) == "") {
                        ComAlertFocus(formObj.combo6, ComGetMsg('COM12113', msg+" Continent"));
                        return false;
                    }
                    break;
                case IBSAVE:    //Confirm
                    var rowIndex=sheetObj.GetSelectRow();
//                  if(ComTrim(sheetObj.CellValue(rowIndex, "grp_cfm_flg")) == "Y") {
//                      ComShowCodeMessage('DMT00118');
//                      return false;
//                  }
                    if(sheetObj.GetTotalRows()!= 10) {
                        ComShowCodeMessage("DMT00121");
                        return false;
                    }
                    var exp_dt_cnt=0;
                    for(var i=1; i< sheetObj.GetTotalRows()+1 ; i++) {
                    	if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) != "") {
                            exp_dt_cnt++;
                        }
                    }
                    if(exp_dt_cnt > 0) {
                        ComShowCodeMessage('DMT00121');
                        return false;
                    }
                    break;
                case IBSAVE2:   //Confirm Cancel
                    var rowIndex=sheetObj.GetSelectRow();
                    if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "N") {
                        ComShowCodeMessage('DMT00123');//Not in confirmed staus!
                        return false;
                    }
                    for(var i=1 ; i < sheetObj.GetTotalRows()+1 ; i++ ) {
                    	if(ComTrim(sheetObj.GetCellValue(i, "eff_day")) < 0) {
                          ComShowCodeMessage('DMT00124');//Only for future tariff!
                          return false;
                      }
                    }
//                    if(ComTrim(sheetObj.CellValue(rowIndex, "eff_day")) < 0) {
//                        ComShowCodeMessage('DMT00124');//Only for future tariff!
//                        return false;
//                    }
//                    if(ComTrim(sheetObj.CellValue(rowIndex, "exp_dt")) != "") {
//                        ComShowCodeMessage('DMT00125');//Already expired!
//                        return false;
//                    }
                    break;
                case IBDELETE:  //Delete
                    var rowIndex=sheetObj.GetSelectRow();
                    if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "Y") {
                        ComShowCodeMessage('DMT00118');//Already confirmed!
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++]=combo_obj;  
    } 
    function initCombo(comboObj, comboNo) {
        var formObj=document.form
        switch(comboNo) { 
            //Tariff Type
            case 1:
                with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD");
                    SetDropHeight(160);
  					ValidChar(2);
                    SetMaxLength(4);
                }
            break;
            
            //Continent
            case 2: 
            case 6:
                with (comboObj) { 
                    SetMultiSelect(0);
                    SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD");
                    SetDropHeight(160);
  					ValidChar(2);
                    SetMaxLength(1);
                }
            break;
            
            //Country
            case 3:
            	with (comboObj) {
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");
            }
            case 7:
            	with (comboObj) {            	
                    SetMultiSelect(0);
                    UseAutoComplet=false;
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
                    SetDropHeight(160);
                    ValidChar(2);
                    //no support[check again]CLT ValidChar(2,0);     
                    //no support[check again]CLT IMEMode=0;
                    SetMaxLength(2);
                }
            break;
            
            //Region
            case 4:
            case 8:
                with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
					ValidChar(2);
					SetDropHeight(160);
                    //no support[check again]CLT ValidChar(2,0);     
                    //no support[check again]CLT IMEMode=0;
                    SetMaxLength(3);
                }
            break;
            
            //Coverage Yard
            case 5:
                with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
                    SetDropHeight(160);
                    ValidChar(2, 1);	// using the English uppercase letters, numbers
                    SetMaxLength(2);
                }
                comboObj.InsertItem(0, "", "");
            break;
         }      
    }   
    function initButton() {
        ComBtnEnable("btn_Retrieve");
        ComBtnEnable("btn_New");
        ComBtnDisable("btn_Create");
        ComBtnDisable("btn_Update");
        ComBtnDisable("btn_Confirm");
        ComBtnDisable("btn_Expire");
        ComBtnDisable("btn_ConfirmCancel");
        ComBtnDisable("btn_Delete");
        ComBtnDisable("btn_Copy");
        ComBtnEnable("btn_DownExcel");
    }
    function setParameters(sAction) {
        var formObj=document.form;
        //Triff Type ComboSettion
        ComSetObjValue(formObj.dmdt_trf_cd,     comboObjects[0].GetSelectText());
        //Coverage ComboSetting
        ComSetObjValue(formObj.cvrg_conti_cd,   comboObjects[1].GetSelectText());
        ComSetObjValue(formObj.cvrg_cnt_cd,     comboObjects[2].GetSelectText());
        if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
            ComSetObjValue(formObj.cvrg_rgn_cd, "");
            ComSetObjValue(formObj.cvrg_ste_cd, comboObjects[3].GetSelectText());
        }else{
            ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[3].GetSelectText());
            ComSetObjValue(formObj.cvrg_ste_cd, "");
        }
        ComSetObjValue(formObj.cvrg_loc_cd,     ComGetObjValue(formObj.cvrg_location));
        ComSetObjValue(formObj.cvrg_yd_cd,      comboObjects[4].GetSelectCode());		//yard Code
        //Origin/Dest ComboSettion
        ComSetObjValue(formObj.org_dest_conti_cd,   comboObjects[5].GetSelectText());
        ComSetObjValue(formObj.org_dest_cnt_cd,     comboObjects[6].GetSelectText());
        if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
            ComSetObjValue(formObj.org_dest_rgn_cd, "");
            ComSetObjValue(formObj.org_dest_ste_cd, comboObjects[7].GetSelectText());
        }else{
            ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[7].GetSelectText());
            ComSetObjValue(formObj.org_dest_ste_cd, "");
        }
        ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
        if(sheetObjects[0].GetSelectRow()== -1) {
            ComSetObjValue(formObj.trf_seq, "");
            ComSetObjValue(formObj.trf_grp_seq, "");
            ComSetObjValue(formObj.svr_id, "");
        }else{
        	ComSetObjValue(formObj.trf_seq, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_seq"));
        	ComSetObjValue(formObj.trf_grp_seq, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_grp_seq"));
        	ComSetObjValue(formObj.svr_id, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "svr_id"));
        }
        //Retrieve Setting
        //ComSetObjValue(formObj.f_cmd, sAction);                         //Command
    }   
    //[2:56:25 PM] Tu?n L?c D??ng: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

    function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        if(comboObj.GetSelectText().length < 4) {
            comboObj.SetSelectText("");
            ComSetFocus(comboObj);
            return;
        }
        search_combo1(comboObj, newIndex, newText);
    }
    function combo1_OnBlur(comboObj) {
        var formObj=document.form;
        var sIndexCode=comboObj.GetSelectIndex();
        var sText=comboObj.GetSelectText();
        if(sIndexCode == -1) {
            comboObj.SetSelectText("");
            ComSetObjValue(formObj.dmdt_trf_nm, "");
        }
    }
    function search_combo1(comboObj, searchIndex, searchText) {
        var formObj=document.form;
        var searchIndex = parseInt(searchIndex);
        if (comboObj.GetSelectText().length == 0 ){
            ComSetObjValue(formObj.dmdt_trf_nm, "");
            comboObj.SetSelectText("");
            ComSetFocus(comboObj);
            return;
        }
        var formObj=document.form;
        
        if ( typeof(comboObj.GetText(searchIndex,1)) == "undefined"){
        	ComSetObjValue(formObj.dmdt_trf_nm, comboObj.GetText(0,1));   //텍스트 컬럼 보여주기
        } else {
        	ComSetObjValue(formObj.dmdt_trf_nm, comboObj.GetText(searchIndex,1));   //텍스트 컬럼 보여주기
        }
//        var tariffType=ComTrim(comboObj.GetText(searchIndex, 0));
        var tariffType=searchText;
        if (tariffType == "DMOF" || tariffType == "DTOC" || tariffType == "CTOC" ) {
            OriginDest.innerHTML=DESTINATION;
        }
        else if (tariffType == "DMIF" || tariffType == "DTIC" || tariffType == "CTIC" || tariffType == ""){
            OriginDest.innerHTML=ORIGIN;
        }
        if (tariffType == "DMIF" || tariffType == "DMOF" || tariffType == "") {
            comboObjects[4].SetEnable(1);
            ComEnableObject(formObj.yd_cd1, true);
            ComEnableObject(formObj.cvrg_yd_cd, true);
            ComEnableObject(formObj.yd_cd, true);
        }else{
            clearYard();
            comboObjects[4].SetEnable(0);
            ComEnableObject(formObj.yd_cd1, false);
            ComEnableObject(formObj.cvrg_yd_cd, false);
            ComEnableObject(formObj.yd_cd, false);
        }
    }
    function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo1(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }   
//    function combo2_OnChange(comboObj, Index_Code, Text) {
//        search_combo2(comboObj, Index_Code, Text);      
//    }
    function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        search_combo2(comboObj, newIndex, newText);      
    }
    function search_combo2(comboObj, searchIndex, searchText) {
        if (comboObj.GetSelectText().length == 0 ) return;
        if (isNoChangeActive) return;
        var formObj=document.form;
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
        clearLocation1();
        clearYard();
    }
    function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo2(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
//    function combo3_OnChange(comboObj, Index_Code, Text) {
//    	alert(Index_Code+"|"+Text);
//        search_combo3(comboObj, Index_Code, Text);
//    }
    function combo3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	//alert(newIndex+"|"+newText);
        search_combo3(comboObj, newIndex, newText);
    }
    function search_combo3(comboObj, searchIndex, searchText) {
    	if (comboObj.GetSelectText().length == 0 ) return;
        if (isNoChangeActive)   return;
        if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
            Region.innerHTML="State";
        } else {
            Region.innerHTML="Region";
        }
        var formObj=document.form;
        isNoChangeActive=true;
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
        isNoChangeActive=false;
        clearLocation1();
        clearYard();
    }
    function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo3(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
//    function combo4_OnChange(comboObj, Index_Code, Text) {
//        search_combo4(comboObj, Index_Code, Text);
//    }
    function combo4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	search_combo4(comboObj, newIndex, newText);
    }
    function search_combo4(comboObj, searchIndex, searchText) {
        var region_len=comboObj.GetSelectText().length ;
        if (region_len == 0)    return;
        if (isNoChangeActive)   return;
        var formObj=document.form;
        isNoChangeActive=true;
        if(region_len == 2) {
            doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);  //searchHierarchyByState
        }else{
            doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj); //searchHierarchyByRegion
        }
        isNoChangeActive=false;
    }
    function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo4(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    function checkLocation1(obj) {
        if(isAlpha()) {
            if (isNoChangeActive) return;
            var formObj=document.form;
            if (ComTrim(ComGetObjValue(obj)).length == 5) {
                var locCd=ComTrim(ComGetObjValue(obj));
                if (locCd.length > 0) {
                    if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
                        Region.innerHTML="State";
                    }else{
                        Region.innerHTML="Region";
                    }
                    isNoChangeActive=true;
                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
                    isNoChangeActive=false;
                }
            }       
        }
    }
    function checkYard1(obj) {
        if(isAlpha()) {
            checkYard1_sub1(obj);
            checkYard1_sub2(obj);
        }
    }
    function checkYard1_sub1(obj) {
        if (isNoChangeActive) return;
        var formObj=document.form;
        if (ComTrim(ComGetObjValue(obj)).length == 5) {
            var yardCd1=ComTrim(ComGetObjValue(obj));
            if (yardCd1.length > 0) {
                if(yardCd1.substring(0,2) == "CA" || yardCd1.substring(0,2) == "US") {
                    Region.innerHTML="State";
                }else{
                    Region.innerHTML="Region";
                }
                isNoChangeActive=true;
                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
                isNoChangeActive=false;
            }
        }
    }
    function checkYard1_sub2(obj) {
        if (isNoChangeActive) return;
        var formObj=document.form;
        if (ComTrim(ComGetObjValue(obj)).length == 5) {
            var yardCd1=ComTrim(ComGetObjValue(obj));
            if (yardCd1.length > 0) {
                isNoChangeActive=true;
                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);
                isNoChangeActive=false;
            }
        }
    }
//    function combo5_OnChange(comboObj, Index_Code, Text) {
//        search_combo5(comboObj, Index_Code, Text);
//    }
    function combo5_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        search_combo5(comboObj, newIndex, newText);
    }
    function search_combo5(comboObj, searchIndex, searchText) {
        if(comboObj.GetSelectText().length == 0 ) return;
        if(isNoChangeActive) return;
        if(searchIndex == undefined || searchIndex == ""){
            comboObj.SetSelectText("");
            return;
        }
        isNoChangeActive=true;
        doActionIBCombo(sheetObjects[0],document.form,IBSEARCH,COMMAND03,YARD,comboObj);
        isNoChangeActive=false;
    }
    function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo5(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
//    function combo6_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//        search_combo6(comboObj, newIndex, newText);
//    }
    function combo6_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        search_combo6(comboObj, newIndex, newText);
    }
    function search_combo6(comboObj, searchIndex, searchText) {
    	if (comboObj.GetSelectText().length == 0 ) return;
        if (isNoChangeActive) return;
        var formObj=document.form;
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
        clearLocation2();
    }
    function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo6(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }//comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode
//    function combo7_OnChange(comboObj, Index_Code, Text) {
//        search_combo7(comboObj, Index_Code, Text)
//    }
    function combo7_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        search_combo7(comboObj, newIndex, newText)
    }
    function search_combo7(comboObj, searchIndex, searchText) {
        if (isNoChangeActive)           return;
        if (comboObj.GetSelectText().length == 0 ) return;
        if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
            Region2.innerHTML="State";
        } else {
            Region2.innerHTML="Region";
        }
        var formObj=document.form;
        isNoChangeActive=true;
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
        isNoChangeActive=false;
    }
    function combo7_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo7(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
//    function combo8_OnChange(comboObj, Index_Code, Text) {
//        search_combo8(comboObj, Index_Code, Text);
//    }
    function combo8_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        search_combo8(comboObj, newIndex, newText);
    }
    function search_combo8(comboObj, searchIndex, searchText) {
        if (isNoChangeActive)           return;
        if (comboObj.GetSelectText().length == 0)  return;
        var formObj=document.form;
        isNoChangeActive=true;
        if(comboObj.GetSelectText().length == 2) {
            doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);  //searchHierarchyByState
        }else{
            doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj); //searchHierarchyByRegion
        }
        isNoChangeActive=false;
    }
    function combo8_OnKeyDown(comboObj, KeyCode, Shift) {
        if(KeyCode == 13) {
            var sIndexCode=comboObj.GetSelectIndex();
            var sText=comboObj.GetSelectText();
            search_combo8(comboObj, sIndexCode, sText);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    function checkLocation2(obj) {
        if(isAlpha()) {
            if (isNoChangeActive) return;
            var formObj=document.form;
            if (ComTrim(ComGetObjValue(obj)).length == 5) {
                var locCd=ComTrim(ComGetObjValue(obj));
                if (locCd.length > 0) {
                    if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
                        Region2.innerHTML="State";
                    }else{
                        Region2.innerHTML="Region";
                    }
                    isNoChangeActive=true;
                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
                    isNoChangeActive=false;
                }
            }       
        }
    }   
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        var formObj=document.form;
        with(sheetObj) {
        	currSvrId=GetCellValue(GetSelectRow(), "svr_id");
        	currDmdtTrfCd=GetCellValue(GetSelectRow(), "dmdt_trf_cd");
        	currTrfSeq=GetCellValue(GetSelectRow(), "trf_seq");
        	currTrfGrpSeq=GetCellValue(GetSelectRow(), "trf_grp_seq");
        	currDmdtCntrTpCd=GetCellValue(GetSelectRow(), "dmdt_cntr_tp_cd");
        	currDmdtCgoTpCd=GetCellValue(GetSelectRow(), "dmdt_cgo_tp_cd");
		}
        var sat_check=false;
        var sun_check=false;
        var hol_check=false;
        if(ComTrim(sheetObj.GetCellValue(Row, "xcld_sat_flg")) == "Y") {
            sat_check=true;
        }
        if(ComTrim(sheetObj.GetCellValue(Row, "xcld_sun_flg")) == "Y") {
            sun_check=true;
        }
        if(ComTrim(sheetObj.GetCellValue(Row, "xcld_hol_flg")) == "Y") {
            hol_check=true;
        }
        doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);      
        ComSetObjValue(formObj.xcld_sat_flg, sat_check);
        ComSetObjValue(formObj.xcld_sun_flg, sun_check);
        ComSetObjValue(formObj.xcld_hol_flg, hol_check);
        ComSetObjValue(formObj.dmdt_chg_cmnc_tp_nm, ComTrim(sheetObj.GetCellValue(Row, "dmdt_chg_cmnc_tp_nm")));
        ComSetObjValue(formObj.cmnc_hr, ComTrim(sheetObj.GetCellValue(Row, "cmnc_hr")));
        ComSetObjValue(formObj.curr_cd, ComTrim(sheetObj.GetCellValue(Row, "curr_cd")));
        doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
    }
    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
    	//ComOpenWait End
        ComOpenWait(false);
    	if (sheetObj.RowCount()> 0) {
    		with(sheetObj) {
				currSvrId=GetCellValue(GetSelectRow(), "svr_id");
				currDmdtTrfCd=GetCellValue(GetSelectRow(), "dmdt_trf_cd");
				currTrfSeq=GetCellValue(GetSelectRow(), "trf_seq");
				currTrfGrpSeq=GetCellValue(GetSelectRow(), "trf_grp_seq");
				currDmdtCntrTpCd=GetCellValue(GetSelectRow(), "dmdt_cntr_tp_cd");
				currDmdtCgoTpCd=GetCellValue(GetSelectRow(), "dmdt_cgo_tp_cd");
    		}
            sheetObj.SelectCell(1,1);
            sheet1_OnClick(sheetObj, 1, 1, "");
    	}                        
        DisableControls();
        var formObj=document.form;
        var	ttlRows=sheetObj.GetTotalRows();
        //버튼 셋팅
        var confirm_ten="N";	// 10 개 모두 Confirmed 인 경우.
        var	confirm_same="N";	// 조회 데이터 10 건 미만 이면서 모두 Confirmed 인 경우.
        var confirm_one="N";	// 조회 데이터 10 건 미만 이면서 그 중에 일부만 Confirmed 인 경우.
        var confirm_upd="N";	// Confirm 해야할 대상이 있을 경우.
        var temp_cnt=0;
        //Tariff Group Status Y check
        var cnt_grp_confirm=0;
        for(var i=1; i < ttlRows + 1; i++) {
            //exp_dt의 값이 존재하지 않는 경우
        	if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) == "") {
                temp_cnt++;
            }
            //Tariff group confirm status
        	if(ComTrim(sheetObj.GetCellValue(i, "grp_cfm_flg")) == "Y") {
                cnt_grp_confirm++;
            }
        }               
        if ( (ttlRows == 10) && ( ttlRows == cnt_grp_confirm) ) {
        	// 10 개 모두 Confirmed 인 경우
        	confirm_ten="Y";
        	confirm_same="Y";
        } 
        if ( ( ttlRows < 10 ) && ( cnt_grp_confirm > 0 ) && ( ttlRows == cnt_grp_confirm ) ) {
        	// 조회 데이터 10 건 미만 이면서 모두 Confirmed 인 경우
        	confirm_same="N";
        } 
        if ( ( ttlRows < 10 ) && ( cnt_grp_confirm > 0 ) && ( ttlRows != cnt_grp_confirm ) ) {
        	// 조회 데이터 10 건 미만 이면서 그 중에 일부만 Confirmed 인 경우
        	confirm_one="Y";
        }
        if ( ( ttlRows > 0 ) && ( ttlRows != cnt_grp_confirm ) ) {
        	// 조회 데이터 1 건 이상 이면서 그 중에 일부만 Confirmed 인 경우
        	// 다시 말해, Confirm 해야할 대상이 있을 경우.
        	confirm_upd="Y";
        }
        // 화면 : Confirmed 표시
        ComSetObjValue(formObj.confirm_yn, confirm_same);
        //1.Create(disable : 10개 이면서 exp_dt 가 모두 ""인 경우)
        if(ttlRows == 10 ) {
    	   ComBtnDisable("btn_Create");
        } else {
            ComBtnEnable("btn_Create");
        }
        //2.Update
        if(confirm_upd == "Y") {
            ComBtnEnable("btn_Update");
        }else {
            ComBtnDisable("btn_Update");
        }
        //3.Confirm
        if (confirm_upd=="Y") {
            ComBtnEnable("btn_Confirm");
        }else {
            ComBtnDisable("btn_Confirm");
        }
        //4.Expire -- logic 점검 필요
        if(cnt_grp_confirm > 0) {
            ComBtnEnable("btn_Expire");
        }else {
            ComBtnDisable("btn_Expire");
        }
        //5.Confirm Cancel
        if( confirm_ten == "Y" ) {
            ComBtnEnable("btn_ConfirmCancel");
        }else {
            ComBtnDisable("btn_ConfirmCancel");
        }
        //6.Delete
        if(confirm_upd == "Y") {
        	ComBtnEnable("btn_Delete");
        }else {
            ComBtnDisable("btn_Delete");
        }
        //7.Copy
        if(ttlRows == 10 && temp_cnt == 10) {
            ComBtnEnable("btn_Copy");
        }else{
            ComBtnDisable("btn_Copy");
        }
    }
    /**
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
//  function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//      if(ErrMsg != "") {
//          alert(ErrMsg);  
//      }
//      var formObject = document.form;
//      doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);       
//  }
    function sheet1_OnSort(sheetObj, Col, SortArrow) {
 		with(sheetObj) {
 			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	currSvrId 		== GetCellValue(row, "svr_id")
				&&	currDmdtTrfCd 	== GetCellValue(row, "dmdt_trf_cd")
				&&	currTrfSeq 		== GetCellValue(row, "trf_seq")
				&&	currTrfGrpSeq 	== GetCellValue(row, "trf_grp_seq")
				&&	currDmdtCntrTpCd== GetCellValue(row, "dmdt_cntr_tp_cd")
				&&	currDmdtCgoTpCd == GetCellValue(row, "dmdt_cgo_tp_cd")) {
 					SetSelectRow(row);
 					break;
 				}
 			}
 		}
 	}     
    function setComboItem(comboObj,comboItems) {
        var checkedItem=comboItems[0].split(FIELDMARK);
        comboObj.SetSelectText(checkedItem[0]);
    }   
    function clearLocation1() {
        var formObj=document.form;
        ComSetObjValue(formObj.loc_cd, "");
        ComSetObjValue(formObj.cvrg_location, "");
    }
    function clearLocation2() {
        var formObj=document.form;
        ComSetObjValue(formObj.loc_cd, "");
        ComSetObjValue(formObj.org_dest_location, "");
    }
    function clearObjectValue(obj) {
        switch(ComGetEvent("name")) {
            case "cvrg_location":
            case "yd_cd1":
            case "org_dest_location":
                obj.value="";
                break;
            default:
                obj.SetSelectText("");
                break;
        }
    }
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.WaitImageVisible = false;
        var index_1=0;
        var index_2=0;
        var index_3=0;
        switch(sAction) {
           case IBSEARCH:     
                if (sheetObj.id == "sheet1") {
                	var comboDatas;
                    var comboItems;
                    switch(sComboAction) {
                    	case SEARCHLIST07:
                    		ComSetObjValue(formObj.f_cmd, SEARCHLIST07); 
                    		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                    		//TARIFF LIST
                    		comboItems=ComGetEtcData(sXml, COMMON_TARIFF_CD).split(ROWMARK);	
                    		addComboItem(comboObjects[0], comboItems);
                    		//Coverage Continent
                    		comboDatas=ComGetEtcData(sXml, CONTINENT);
                    		if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[1].SetSelectCode("-1");
                                comboObjects[1].RemoveAll();
                                addComboItem(comboObjects[1],comboItems);
                            }
                    		//Coverage Country 
                    		comboDatas=ComGetEtcData(sXml, COUNTRY);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[2].SetSelectCode("-1");
                                comboObjects[2].RemoveAll();
                                addComboItem(comboObjects[2],comboItems); //COUNTRY
                            }
                            //Coverage Region
                            comboDatas=ComGetEtcData(sXml, REGION);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[3].SetSelectCode("-1");
                                comboObjects[3].RemoveAll();
                                addComboItem(comboObjects[3],comboItems); //Region
                            }
                            //Coverage Continent
                    		comboDatas=ComGetEtcData(sXml, CONTINENT);
                    		if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[5].SetSelectCode("-1");
                                comboObjects[5].RemoveAll();
                                addComboItem(comboObjects[5],comboItems);
                            }
                    		//Coverage Country 
                    		comboDatas=ComGetEtcData(sXml, COUNTRY);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[6].SetSelectCode("-1");
                                comboObjects[6].RemoveAll();
                                addComboItem(comboObjects[6],comboItems); //COUNTRY
                            }
                            //Coverage Region
                            comboDatas=ComGetEtcData(sXml, REGION);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[7].SetSelectCode("-1");
                                comboObjects[7].RemoveAll();
                                addComboItem(comboObjects[7],comboItems); //Region
                            }
                    		break;
                        //1. TARIFF LIST
                        case SEARCHLIST:
                        	ComSetObjValue(formObj.f_cmd, SEARCHLIST); 
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
                            addComboItem(sObj,comboItems);                      
                            break;                          
                        //2. CONTINENT LIST
                        case SEARCH08:
                        	ComSetObjValue(formObj.f_cmd, SEARCH08); 
                            setComboParameters(sComboAction, sObj);
                            var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo2") {
                                index_1=1;
                            } else {
                                index_1=5;
                            }
                            comboDatas=ComGetEtcData(sXml, sComboKey);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_1].SetSelectCode("-1");
                                comboObjects[index_1].RemoveAll();
                                addComboItem(comboObjects[index_1],comboItems); //CONTINENT
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        //2. COUNTRY LIST
                        case SEARCH02:
                        	ComSetObjValue(formObj.f_cmd, SEARCH02);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo3") {
                                index_1=2;
                            } else {
                                index_1=6;
                            }
                            comboDatas=ComGetEtcData(sXml, sComboKey);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_1].SetSelectCode("-1");
                                comboObjects[index_1].RemoveAll();
                                addComboItem(comboObjects[index_1],comboItems); //COUNTRY
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        //3. REGION LIST
                        case SEARCH01:
                        	ComSetObjValue(formObj.f_cmd, SEARCH01);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo4" || sObj.options.id == "combo2") {
                                index_1=3;
                            } else {
                                index_1=7;
                            } 
                            comboDatas=ComGetEtcData(sXml, sComboKey);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_1].SetSelectCode("-1");
                                comboObjects[index_1].RemoveAll();
                                addComboItem(comboObjects[index_1],comboItems); //REGION
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH06:
                        	ComSetObjValue(formObj.f_cmd, SEARCH06);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));

                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
                            if(sObj_name == "combo2" || sObj_name == "combo4" || sObj_name == "cvrg_location"
                                || sObj_name == "combo5" || sObj_name == "yd_cd1" ) {
                                index_1=2;
                            }else{
                                index_1=6;
                            }
                            comboDatas=ComGetEtcData(sXml, COUNTRY);
                            if (comboDatas != undefined) {
                                if(comboDatas != "") {
                                    comboItems=comboDatas.split(ROWMARK);
                                    comboObjects[index_1].SetSelectCode("-1");
                                    comboObjects[index_1].RemoveAll();
                                    addComboItem(comboObjects[index_1],comboItems); //Country
                                }else{
                                    ComShowCodeMessage("DMT06001");
                                    clearObjectValue(sObj);
                                }
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH12:
                        	ComSetObjValue(formObj.f_cmd, SEARCH12);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
//                        	alert(sObj.options.id);
                            if(sObj.options.id == "combo3") {
                                index_1=1;
                            } else {
                                index_1=5;
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if( comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems); //Continent
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH03:
                        	ComSetObjValue(formObj.f_cmd, SEARCH03);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                        	
                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
                            if(sObj_name == "combo3" || sObj_name == "combo4" || sObj_name == "combo5" 
                                || sObj_name == "cvrg_location" || sObj_name == "yd_cd1") {
                                index_1=2;
                                index_2=3;
                                clearLocation1();
                            } else {
                                index_1=6;
                                index_2=7;
                                clearLocation2();
                            }
                            if(comboObjects[index_1].GetSelectText()== "CA" || comboObjects[index_1].GetSelectText()== "US" ) {
                                //State
                                comboDatas=ComGetEtcData(sXml, STATE);
                            }else{
                                                                                                                                                                                                                                //Region
                                comboDatas=ComGetEtcData(sXml, REGION);
                            }
                            if(comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();              //Region
                                addComboItem(comboObjects[index_2],comboItems);
                            }else {
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH17:
                        	ComSetObjValue(formObj.f_cmd, SEARCH17);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo4") {
                                index_1=1;
                                index_2=2;    
                                index_3=3;
                                clearLocation1();
                            } else {
                                index_1=5;
                                index_2=6;
                                index_3=7;
                                clearLocation2();
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                //Continent Setting
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems);     //Continent
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems); //Country
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();              //Region
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    comboDatas=ComGetEtcData(sXml, sComboKey);
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems); //Region
                                    }else{
                                        ComShowCodeMessage("DMT06001");
                                        clearObjectValue(sObj);
                                    }
                                }else{
                                    ComShowCodeMessage("DMT06001");
                                    clearObjectValue(sObj);
                                }                           
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH13:
                        	ComSetObjValue(formObj.f_cmd, SEARCH13);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo4") {
                                index_1=1;
                                index_2=2;   
                                index_3=3;
                                clearLocation1();
                            } else {
                                index_1=5;
                                index_2=6;
                                index_3=7;
                                clearLocation2();
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                //Continent Setting
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems);     //Continent
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems); //Country
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();              //Region
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    comboDatas=ComGetEtcData(sXml, sComboKey);
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems); //Region
                                    }else{
                                        ComShowCodeMessage("DMT06001");
                                        clearObjectValue(sObj);
                                    }
                                }else{
                                    ComShowCodeMessage("DMT06001");
                                    clearObjectValue(sObj);
                                }                           
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH10:
                        	ComSetObjValue(formObj.f_cmd, SEARCH10);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            var location=ComGetObjValue(sObj);
                            if(sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
                                index_1=1;
                                index_2=2;    //Location 초기화
                                index_3=3;
                                clearLocation1();
                            } else {
                                index_1=5;
                                index_2=6;
                                index_3=7;
                                clearLocation2();
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                //Continent Setting
                                setComboItem(comboObjects[index_1],comboItems);     //Continent
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();                  //Country
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems);
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();              //Region
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
                                        comboDatas=ComGetEtcData(sXml, STATE);
                                    }else{
                                        comboDatas=ComGetEtcData(sXml, REGION);
                                    }
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems); //Region
                                        //location setting
                                        ComSetObjValue(sObj, location);
                                        if(sObj.name == "cvrg_location") {
                                            if (ComGetObjValue(formObj.combo1) == "DMIF" || ComGetObjValue(formObj.combo1) == "DMOF" 
                                                || ComGetObjValue(formObj.combo1) == "") {
                                                //yd_cd1 Setting
                                                ComSetObjValue(formObj.yd_cd1, ComGetObjValue(formObj.cvrg_location));
                                                isNoChangeActive=false;
                                                checkYard1_sub2(formObj.yd_cd1);
                                                ComSetFocus(formObj.yd_cd1);
                                            }
                                        }
                                    }else{
                                        ComShowCodeMessage("DMT06001");
                                        clearObjectValue(sObj);
                                    }
                                }else{
                                    ComShowCodeMessage("DMT06001");
                                    clearObjectValue(sObj);
                                }
                            }else{
                                ComAlertFocus(sObj, ComGetMsg('DMT00110'));
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH14:
                        	ComSetObjValue(formObj.f_cmd, SEARCH14);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            var yd_cd1=ComGetObjValue(sObj);
                            ComSetObjValue(formObj.cvrg_location, yd_cd1);
                            index_1=4;
                            comboObjects[index_1].SetSelectCode("-1");
                            comboObjects[index_1].RemoveAll();
                            comboDatas=ComGetEtcData(sXml, YARD);
                            if (comboDatas == undefined ||comboDatas == "") {
                                //ComShowCodeMessage("DMT06001");
                                //ComSetObjValue(formObj.cvrg_location, "");
                                //ComSetObjValue(formObj.yd_cd1, "");
                            }else{
                                comboItems=comboDatas.split(ROWMARK);
                                addComboItem1(comboObjects[index_1],comboItems);    
                                setComboItem(comboObjects[index_1],comboItems);
                            }
                            break;
                        case COMMAND03:
                        	ComSetObjValue(formObj.f_cmd, COMMAND03);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            index_1=1;
                            index_2=2;
                            index_3=3;
                            //Continent 조회
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                //Continent Setting
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems);
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems);
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    //Region/State Setting
                                    if(comboObjects[index_2].GetSelectText()== "CA" || comboObjects[index_2].GetSelectText()== "US" ) {
                                        comboDatas=ComGetEtcData(sXml, STATE);
                                    }else{
                                        comboDatas=ComGetEtcData(sXml, REGION);
                                    }
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems);
                                        //location setting
                                        ComSetObjValue(formObj.cvrg_location, ComGetObjValue(formObj.yd_cd1));
                                    }else{
                                        ComShowCodeMessage("DMT06001");
                                        clearObjectValue(sObj);
                                    }
                                }else{
                                    ComShowCodeMessage("DMT06001");
                                    clearObjectValue(sObj);
                                }
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;                              
                    }
                };
                break;
        }
        sheetObj.SetWaitImageVisible(1);
    }   
    function addComboItem(comboObj, comboItems) {
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);        
        }           
    }
    function addComboItem1(comboObj, comboItems) {
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[1], comboItem[0]);     
        }           
    }
    function clearYard() {
        var formObj=document.form;
        comboObjects[4].SetSelectCode("-1");
        comboObjects[4].RemoveAll();
        ComSetObjValue(formObj.yd_cd1, "");
        ComSetObjValue(formObj.cvrg_yd_cd, "");
        ComSetObjValue(formObj.yd_cd, "");
    }
    function setComboParameters(sComboAction, sObj) {
        var formObj=document.form;
        var sObj_name = "";
        if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
        	sObj_name = sObj.name;
        } else {
        	sObj_name = sObj.options.id;
        }
        switch(sObj_name) {
            case "combo2":
            case "combo3":
            case "combo4":
            case "combo5":
            case "cvrg_location":
            case "yd_cd1":
                //Coverage ComboSetting
                ComSetObjValue(formObj.conti_cd, comboObjects[1].GetSelectText());
                ComSetObjValue(formObj.cnt_cd, comboObjects[2].GetSelectText());
                ComSetObjValue(formObj.rgn_cd, comboObjects[3].GetSelectText());
                ComSetObjValue(formObj.ste_cd, comboObjects[3].GetSelectText());
                if(sObj_name == "cvrg_location") {
                    ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
                } else if(sObj_name == "yd_cd1") {
                    ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
                }
                ComSetObjValue(formObj.yd_cd, comboObjects[4].GetSelectCode());
                break;                      
            case "combo6":
            case "combo7":
            case "combo8":
            case "org_dest_location":
                //Origin/Dest ComboSettion
                ComSetObjValue(formObj.conti_cd, comboObjects[5].GetSelectText());
                ComSetObjValue(formObj.cnt_cd, comboObjects[6].GetSelectText());
                ComSetObjValue(formObj.rgn_cd, comboObjects[7].GetSelectText());
                ComSetObjValue(formObj.ste_cd, comboObjects[7].GetSelectText());
                ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_location));
                break; 
        }
    }
    function GetEnableControls() {
        var formObj=document.form;
        ComEnableObject(formObj.yd_cd1, true);
        ComEnableObject(formObj.cvrg_location, true);
        ComEnableObject(formObj.org_dest_location, true);
        formObj.yd_cd1.className="input";
        formObj.cvrg_location.className="input";
        formObj.org_dest_location.className="input";
        for(var i=0 ; i < comboObjects.length ; i++) {
            comboObjects[i].SetEnable(1);
        }
    }
    function DisableControls() {
    	 var formObj=document.form;
        ComEnableObject(formObj.yd_cd1, false);
        ComEnableObject(formObj.cvrg_location, false);
        ComEnableObject(formObj.org_dest_location, false);
        formObj.yd_cd1.className="input2";
        formObj.cvrg_location.className="input2";
        formObj.org_dest_location.className="input2";
        for(var i=0 ; i < comboObjects.length ; i++) {
            comboObjects[i].SetEnable(0);
        }
    }
    function initSearchControls() {
        var formObj=document.form;
        comboObjects[0].SetSelectCode("-1");
        comboObjects[0].RemoveAll();
        comboObjects[1].SetSelectCode("-1");
        comboObjects[1].RemoveAll();
        comboObjects[2].SetSelectCode("-1");
        comboObjects[2].RemoveAll();
        comboObjects[3].SetSelectCode("-1");
        comboObjects[3].RemoveAll();
        comboObjects[4].SetSelectCode("-1");
        comboObjects[4].RemoveAll();
        comboObjects[5].SetSelectCode("-1");
        comboObjects[5].RemoveAll();
        comboObjects[6].SetSelectCode("-1");
        comboObjects[6].RemoveAll();
        comboObjects[7].SetSelectCode("-1");
        comboObjects[7].RemoveAll();
        ComSetObjValue(formObj.conti_cd, "");   
        ComSetObjValue(formObj.cnt_cd, "");     
        ComSetObjValue(formObj.rgn_cd, "");     
        ComSetObjValue(formObj.loc_cd, "");
        ComSetObjValue(formObj.ste_cd, "");
        ComSetObjValue(formObj.yd_cd1, "");
        ComSetObjValue(formObj.yd_cd, "");
        ComSetObjValue(formObj.cvrg_location, "");
        ComSetObjValue(formObj.org_dest_location, "");
        ComSetObjValue(formObj.cvrg_conti_cd, "");
        ComSetObjValue(formObj.cvrg_cnt_cd, "");
        ComSetObjValue(formObj.cvrg_rgn_cd, "");
        ComSetObjValue(formObj.cvrg_ste_cd, "");
        ComSetObjValue(formObj.cvrg_loc_cd, "");
        ComSetObjValue(formObj.cvrg_yd_cd, "");
        ComSetObjValue(formObj.org_dest_conti_cd, "");
        ComSetObjValue(formObj.org_dest_cnt_cd, "");
        ComSetObjValue(formObj.org_dest_rgn_cd, "");
        ComSetObjValue(formObj.org_dest_ste_cd, "");
        ComSetObjValue(formObj.org_dest_loc_cd, "");
        ComSetObjValue(formObj.dmdt_trf_cd, "");
        ComSetObjValue(formObj.trf_seq, "");
        ComSetObjValue(formObj.trf_grp_seq, "");
        ComSetObjValue(formObj.dmdt_trf_nm, "");
        ComSetObjValue(formObj.confirm_yn, "");
        ComSetObjValue(formObj.wknd1, "SAT");
        ComSetObjValue(formObj.wknd2, "SUN");
        Region.innerHTML="Region";
        Region2.innerHTML="Region";
        OriginDest.innerHTML="Origin";
        OriginDest.innerHTML="Origin";
        OriginDest.innerHTML="Origin";
        wknd1.innerHTML="SAT";
        wknd2.innerHTML="SUN";
        initResultText();
    }   
    function initResultText() {
        var formObj=document.form;
        ComSetObjValue(formObj.xcld_sat_flg, "");
        ComSetObjValue(formObj.xcld_sun_flg, "");
        ComSetObjValue(formObj.xcld_hol_flg, "");
        ComSetObjValue(formObj.cmnc_hr, "");
        ComSetObjValue(formObj.dmdt_chg_cmnc_tp_nm, "");
        ComSetObjValue(formObj.curr_cd, "");
    }
    function initResultControls() {
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
    }
    function initControl() {
    	initSearchControls();
    	initResultControls();
    	for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
    	var formObj=document.form;
        doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
        initButton();
    }
function t1901SpeedDownExcel () {
    sheetObjects[3].RemoveAll();
    doActionIBSheet( sheetObjects[3] , document.form , IBSEARCH );
//    if(sheetObjects[3].RowCount() < 1){//no data
//    	ComShowCodeMessage("COM132501");
//    }
//    else{
//    	sheetObjects[3].Down2Excel({ HiddenColumn:-1});
//    }
}
function sheet4_OnSearchEnd(sheetObj, code, ErrMsg) {
	//ComOpenWait End
    ComOpenWait(false);
    //3.Expired Validity
    for(var i=0; i<= sheetObj.RowCount()+2; i++) {
		if(sheetObj.GetCellValue(i, "expire_chk") == "Y") {
			sheetObj.SetCellFontColor(i, 5,"#FF0000");
			sheetObj.SetCellFontColor(i, 6,"#FF0000");
			sheetObj.SetCellFontColor(i, 7,"#FF0000");
        }
    }
	sheetObj.SetCellValue(1,"xcld_sat_flg",sheetObj.GetCellValue(2,"wknd1"));
	sheetObj.SetCellValue(1,"xcld_sun_flg",sheetObj.GetCellValue(2,"wknd2"));
	if(sheetObj.RowCount() < 1){//no data
    	ComShowCodeMessage("COM132501");
    }
    else{
    	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:0,Merge:1 });
    }
}
	/**
 * handling after saving
 */
function sheet1_OnSaveEnd(sheetObj, code, ErrMsg ){
    var formObj=document.form;
    ComOpenWait(false);
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}