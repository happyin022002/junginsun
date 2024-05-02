/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1035.js
*@FileTitle  : CY or Destuffing Setup(Vietnam) Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/28
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
     * @class esm_bkg_1035 : esm_bkg_1035 - task script definition for screen
     */
    function esm_bkg_1035() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet_no=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
        var sheetObject1=sheetObjects[sheet_no];
        /*******************************************************/
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Setup":
                    doActionIBSheet(sheetObject1,document.form,IBINSERT);
                    ComClosePopup(); 
                break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } // end switch
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
        if (document.form.bkg_no.value != '') {
            doActionIBSheet(sheetObjects[sheet_no],document.form,IBSEARCH);
        }
    }
    /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
	              var HeadTitle1="ibflag|bkg_no|rlse_seq|vn_cgo_de_cd";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="sheet1_";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rlse_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vn_cgo_de_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetVisible(0);
                }	
                break;
        }
    }
    /**
     * handling sheet process
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //retrieve
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                ComOpenWait(true);
                sheetObjects[sheet_no].SetWaitImageVisible(0);
                formObj.f_cmd.value=SEARCH;
                var aryPrefix=new Array("sheet1_"); 
                var sXml=sheetObj.GetSearchData("ESM_BKG_1035GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                for(var idx=0; idx < arrXml.length; idx++){
                    sheetObjects[idx].RenderSheet(0);
                    if(idx > 0) {
                        sheetObjects[idx].SetWaitImageVisible(0);
                    }
                    sheetObjects[idx].LoadSearchData(arrXml[idx],{Sync:1} );
                    sheetObjects[idx].RenderSheet(1);
                }
                sheetObjects[sheet_no].SetWaitImageVisible(1);
            break;
            case IBINSERT:
                formObj.f_cmd.value=MULTI;
                copyFormTosheet1();
                var sParam1=sheetObjects[sheet_no].GetSaveString();
                //Check for changes in the grid
                if(! sheetObjects[sheet_no].IsDataModified()){
                    ComShowCodeMessage('BKG00743');
                    return false;
                }
                if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
                    return false;
                }
                var aryPrefix=new Array("sheet1_");   
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                var sXml=sheetObj.GetSaveData("ESM_BKG_1035GS.do", sparam);
                sheetObjects[sheet_no].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);   /// Used only once, when you want to show the message passed
            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
            case IBSEARCH:
                if(ComIsEmpty(formObj.bkg_no.value)){
                    ComShowCodeMessage('BKG00554');
                    return false;
                }
            break;
            case IBINSERT:
                if(ComIsEmpty(formObj.bkg_no.value)){
                    ComShowCodeMessage('BKG00554');
                    return false;
                }
            break;
        }
        return true;
    }
    /**
     * things after Saving sheet1 
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
           doActionIBSheet(sheetObjects[sheet_no],document.form,IBSEARCH);
        }
    }
    /**
     * copy valuet to sheet1
     */
    function copyFormTosheet1() {
        var rowCnt=sheetObjects[sheet_no].RowCount();
        var prefix="sheet1_";
        if (rowCnt > 0) {      //기존 자료가 존재하는 경우
        	sheetObjects[sheet_no].SetRowStatus(rowCnt,"U");
        } else {               //신규 입력인 경우
            rowCnt=sheetObjects[sheet_no].DataInsert(-1);
        	sheetObjects[sheet_no].SetRowStatus(rowCnt,"I");
        }
        sheetObjects[sheet_no].SetCellValue(rowCnt,prefix + "bkg_no",document.form.bkg_no.value,0);
        sheetObjects[sheet_no].SetCellValue(rowCnt,prefix + "vn_cgo_de_cd",document.form.vn_cgo_de_cd.value,0);
    }
    /**
     * set values after retrieve finish
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var prefix="sheet1_";
        var formObject=document.form;
        if (ErrMsg == "") {
if(sheetObj.GetCellValue(1, prefix + "vn_cgo_de_cd") !=''){
document.form.vn_cgo_de_cd.value=sheetObj.GetCellValue(1, prefix + "vn_cgo_de_cd");
            }else{
                document.form.vn_cgo_de_cd.value='A';
            }
        }
        ComOpenWait(false);
    }
