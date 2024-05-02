/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1022.js
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
    /**
     * @extends 
     * @class ees_eqr_1022
     */
    function ees_eqr_1022() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
    }
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var IBSEARCH02=30;
    var PREFIX00="";
    var PREFIX01="";
    var PREFIX02="";    
    document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var sheetObject2=sheetObjects[2];
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                	doActionIBSheet( sheetObject , formObject , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObject , formObject , IBSEARCH );
                break;
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    formObject.reset();
                    document.getElementById("vvd").focus();
                    setHRText2();
                    break;
                break;
                case "btn_downexcel":
                    if ( sheetObjects[0].RowCount()> 0 ) {
                    	sheetObjects[0].Down2Excel({ HiddenColumn:-1});
                    }
                    if ( sheetObjects[1].RowCount()> 0 ) {
                    	sheetObjects[1].Down2Excel({ HiddenColumn:-1});
                    }
                    if ( sheetObjects[2].RowCount()> 0 ) {
                    	sheetObjects[2].Down2Excel({ HiddenColumn:-1});
                    }
                break;
                case "btn_vvd": //vvd 
                    var param="?vvd_cd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/COM_ENS_0B2.do" , 755, 450 , "popupFinish" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "HRBTN":
                    var param="?version=H&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_1057.do"+param , 940, 600 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "RMBTN":
                    var param="?vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_1056.do"+param , 910, 620 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "DMBTN":
                    var param="?version=D&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_1057.do"+param , 940, 600 , "" , "1,0,1,1,1,1,1,1" , true );
                break;                
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                alert(e);
            } else {
                alert(e);
            }
        }
    }
    function popHRBTN(){
        var formObject=document.form;
        var param="?version=H&vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/opuscntr/EES_EQR_1057.do"+param , 940, 550 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    function popRMBTN(){
        var formObject=document.form;
        var param="?vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/opuscntr/EES_EQR_1056.do"+param , 910, 600 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    function popDMBTN(){
        var formObject=document.form;
        var param="?version=D&vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/opuscntr/EES_EQR_1057.do"+param , 940, 550 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    /**
     * lane code 
     */
    function popupFinish(aryPopupData, row, col, sheetIdx) {
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        formObject.vvd.value=aryPopupData[0][7];
        formObject.lane.value=aryPopupData[0][3];
        formObject.bay.value=aryPopupData[0][4];
    }
    /**
     * IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function form_click(){
    	srcName=ComGetEvent("name");
    	if ( srcName == "user"){
    		var userId=document.form.user.value;
    		if ( userId != "" ){
   				ComUserPopup(userId);
    		}
    	}
    }
    function initControl(){
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); 
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); 
        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        axon_event.addListenerForm('click', 'form_click',    document.form); //- 클릭시
        document.form.vvd.focus();
    }
    /**
     * Initial sheet value 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        setHRText2();
        sheetObjects[0].SetColHidden(4,1);
        sheetObjects[0].SetColHidden(5,1);
        sheetObjects[0].SetColHidden(24,1);
        sheetObjects[0].SetColHidden(25,1);
        sheetObjects[0].SetColHidden(26,1);
        sheetObjects[0].SetColHidden(27,1);
        sheetObjects[1].SetColHidden(24,1);
        sheetObjects[1].SetColHidden(25,1);
        sheetObjects[1].SetColHidden(26,1);
        sheetObjects[1].SetColHidden(27,1);
        sheetObjects[2].SetColHidden(24,1);
        sheetObjects[2].SetColHidden(25,1);
        sheetObjects[2].SetColHidden(26,1);
        sheetObjects[2].SetColHidden(27,1);
    }
    function setHRText2(){
        HRTEXT.innerText="HR :    ";
        RMTEXT.innerText="Rev. MTY :    ";
        DMTEXT.innerText="DMG :    ";
    }     
  /**
     * initialize sheet
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                
              var HeadTitle="|||MTY Volume|MTY Volume|MTY Volume|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|P2|P4|T2|T4";
              var headCount=ComCountHeadTitle(HeadTitle);
              (headCount, 0, 0, true);
              sheetObj.FrozenCols=2;
              var sumLine="|"+PREFIX00+"d2| + |"+PREFIX00+"d4| + |"+PREFIX00+"d5| + |"+PREFIX00+"d7| + |"+PREFIX00+"r2| + |"+PREFIX00+"r5| + |"+PREFIX00+"r9| + |"+PREFIX00+"o2| + " +
              "|"+PREFIX00+"o4| + |"+PREFIX00+"o5| + |"+PREFIX00+"s2| + |"+PREFIX00+"s4| + |"+PREFIX00+"f2| + |"+PREFIX00+"f4| + |"+PREFIX00+"f5| + |"+PREFIX00+"a4| + " +
              "|"+PREFIX00+"a2| + |"+PREFIX00+"p2| + |"+PREFIX00+"p4| + |"+PREFIX00+"t2| + |"+PREFIX00+"t4|";

              SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX00+"ibflag" },
                     {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX00+"del_chk" },
                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX00+"status" },
                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:PREFIX00+"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"etb",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"total",   KeyField:0,   CalcLogic:sumLine,Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r9",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"s2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"s4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"a2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"a4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"p2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"p4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"t2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"t4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetSheetHeight(140);
              SetEditable(0);
              SetCountPosition(0);
                    }


            break;
            case "sheet2":
                with(sheetObj){
                
              var HeadTitle="|||POL|POL|ETD|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|P2|P4|T2|T4";
              var headCount=ComCountHeadTitle(HeadTitle);
              var sumLine2="|"+PREFIX01+"d2| + |"+PREFIX01+"d4| + |"+PREFIX01+"d5| + |"+PREFIX01+"d7| + |"+PREFIX01+"r2| + |"+PREFIX01+"r5| + |"+PREFIX01+"r9| + " +
              "|"+PREFIX01+"o2| + |"+PREFIX01+"o4| + |"+PREFIX01+"o5| + |"+PREFIX01+"s2| + |"+PREFIX01+"s4| + |"+PREFIX01+"f2| + |"+PREFIX01+"f4| + " +
              "|"+PREFIX01+"f5| + |"+PREFIX01+"a4| + |"+PREFIX01+"a2| + |"+PREFIX01+"p2| + |"+PREFIX01+"p4| + |"+PREFIX01+"t2| + |"+PREFIX01+"t4|";

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX01+"ibflag" },
                     {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX01+"del_chk" },
                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"status" },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"etb",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"total",   KeyField:0,   CalcLogic:sumLine2,Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r9",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"s2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"s4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"a2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"a4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"p2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"p4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"t2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"t4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetSheetHeight(140);
              SetEditable(0);
              SetCountPosition(0);
                    }


            break;
            case "sheet3":
                with(sheetObj){
                
              var HeadTitle="|||POD|POD|ETB|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|P2|P4|T2|T4";
              var headCount=ComCountHeadTitle(HeadTitle);
              var sumLine3="|"+PREFIX02+"d2| + |"+PREFIX02+"d4| + |"+PREFIX02+"d5| + |"+PREFIX02+"d7| + |"+PREFIX02+"r2| + |"+PREFIX02+"r5| + |"+PREFIX02+"r9| + |"+PREFIX02+"o2| + " +
              "|"+PREFIX02+"o4| + |"+PREFIX02+"o5| + |"+PREFIX02+"s2| + |"+PREFIX02+"s4| + |"+PREFIX02+"f2| + |"+PREFIX02+"f4| + |"+PREFIX02+"f5| + |"+PREFIX02+"a4| + " +
              "|"+PREFIX02+"a2| + |"+PREFIX02+"p2| + |"+PREFIX02+"p4| + |"+PREFIX02+"t2| + |"+PREFIX02+"t4|";

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX02+"ibflag" },
                     {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX02+"del_chk" },
                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"status" },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"etb",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"total",   KeyField:0,   CalcLogic:sumLine3,Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r9",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"s2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"s4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"a2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"a4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:44,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"p2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"p4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"t2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"t4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetSheetHeight(140);
              SetEditable(0);
              SetCountPosition(0);
                    //conversion of function[check again]CLT                     InitDataValid( 0 , PREFIX02+"pod_cd" , vtEngUpOnly , "" ); //대문자만
              }


            break;
        }
    }
  // Sheet
    function doActionIBSheet( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == 'sheet1') { 
                        for( var i=0 ; i < sheetObjects.length ; i++ ){
                            sheetObjects[i].RemoveAll();
                        }               
                		sheetObj.SetWaitImageVisible(0);
                		//ComOpenWait(true);
                        formObj.f_cmd.value=SEARCH;    
                        var sXml=sheetObj.GetSearchData("EES_EQR_1024GS.do", FormQueryString(formObj));
                        var arrXml=sXml.split("|$$|");
                        var sCheck=ComGetEtcData(arrXml[0], "check");
                        var arrTpSz=sCheck.split("|");
                        if(arrTpSz[0] == '') arrTpSz[0]=0;
                        if(arrTpSz[1] == '') arrTpSz[1]=0;
                        if(arrTpSz[2] == '') arrTpSz[2]=0;
                        HRTEXT.innerText="HR : "       + arrTpSz[0];
                        RMTEXT.innerText="Rev. MTY : " + arrTpSz[2];
                        DMTEXT.innerText="DMG : "      + arrTpSz[1];
                        for( var i=0 ; i < arrXml.length ; i++ ){  
                            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
                        }
                		
                		
                    }                     
                } else {
                    return;
                }
            break;
            case IBSEARCH_ASYNC01:      // VVD 
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData("EES_EQR_1024GS.do",FormQueryString(formObj));
                    var sCheck=ComGetEtcData(sXml, "check");
                    var arrTpSz=sCheck.split("|");
                    document.form.lane.value=arrTpSz[0];
                    document.form.bay.value=arrTpSz[1];
                    if(arrTpSz[2] == "C"){
                    	document.form.version.value="C";
                	}
                    else{
                    	document.form.version.value="##";
                    }
                    document.form.remark.value=arrTpSz[4];
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj,code,msg) {
    	sheetObj.SetWaitImageVisible(1);
    	//ComOpenWait(false);
    }
    
    function sheet2_OnSearchEnd(sheetObj,code,msg) {
    	sheetObj.SetWaitImageVisible(1);
    	//ComOpenWait(false);
    }
    
    function sheet3_OnSearchEnd(sheetObj,code,msg) {
    	sheetObj.SetWaitImageVisible(1);
    	//ComOpenWait(false);
    }
    /**
     * validate input value
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction == IBSEARCH){
                if(vvd.value == ""){
                    ComShowCodeMessage("EQR90191","VVD Code ");
                    ComSetFocus(vvd);
                    return false;
                }                
            }
        }
        return true;
    }
    // Remove total = 0
    function removeZero(sheetObj) {
        with(sheetObj) {
            var sCol=6;
            var eCol=LastCol();
            for ( i=sCol ; i <= eCol ; i++ ) {
            	if ("" == GetSumText(0, i) ) {
            		SetSumText(0, i,"0");
                }
            }
        }
    }
    // Search end event
    function sheet1_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
            SetColBackColor(PREFIX00+"pod_cd","#E5EAFF");
            //SumText(0, PREFIX00+"pod_cd") = "Onboard Total";
            MessageText("Sum")="Onboard Total";
            SetCellAlign(0,PREFIX00+"pod_cd","Center");
            removeZero(sheetObj);
            sheetObjects[0].SetColHidden(4,1);
            sheetObjects[0].SetColHidden(5,1);
        }
    }
    // Search end event
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
        	SetSumText( 0 , PREFIX01 + "pod_cd","Additonal Load Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(),PREFIX01 + "pod_cd","Center");
            removeZero(sheetObj);
            for ( var i=7 ; i < 27 ; i++ ) {
            	sheetObjects[0].SetCellValue(2,i,GetSumValue(0, i),0);
            }
        }
    }
    // Search end event
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
        	SetSumText(0, PREFIX02+"pod_cd","Discharge Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(),PREFIX02+"pod_cd","Center");
            removeZero(sheetObj);
            var tVer=document.form.version.value;
            if ( tVer == "I" ) {
                for( var i=7 ; i < 27 ; i++ ) {
                	sheetObjects[0].SetCellValue(1,i,sheetObj.GetSumValue(0,i),0);
                }
            }
        }
    }
    /**
     * 
     */
	function obj_keypress(){
	    switch(event.srcElement.name){
	        case "vvd":
	            ComKeyOnlyAlphabet('uppernum');
	        break;
	    }   
	}    
