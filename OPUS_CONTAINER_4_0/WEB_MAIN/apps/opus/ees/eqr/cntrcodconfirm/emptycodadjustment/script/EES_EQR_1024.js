/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1024.js
*@FileTitle  : MTY COD Confirmation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
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
                    sheetObjects[0].SetSelectRow(0);
                    sheetObjects[1].SetSelectRow(0);
                    sheetObjects[2].SetSelectRow(0);
                break;
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    formObject.reset();
                    document.getElementById("vvd").focus();
                    ComBtnDisable("btn_save");
                    ComBtnDisable("btn_remove");
                    ComBtnDisable("btn_rowadd");
                    ComBtnDisable("btn_delete");
                    ComBtnDisable("btn_rowadd2");
                    ComBtnDisable("btn_delete2");
                    setHRText2();
                    break;
                break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                break;
                case "btn_downexcel":
                	if(sheetObjects[0].RowCount() < 1 && sheetObjects[1].RowCount() < 1 && sheetObjects[2].RowCount() < 1){
	            		ComShowCodeMessage("EQR01104");
	            	}else{
	            		if(sheetObjects[0].RowCount() > 0)sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
	            		if(sheetObjects[1].RowCount() > 0)sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
	            		if(sheetObjects[2].RowCount() > 0)sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1 });
	            	}
                case "btn_rowadd":
                    doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;
                case "btn_delete":
                    if ( sheetObject1.FindCheckedRow(PREFIX01+"del_chk") == "" ){
                        ComShowCodeMessage("EQR90214");
                    }else if ( ComShowCodeConfirm("EQR90193") ){ 
                        doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    }
                break;
                case "btn_rowadd2":
                    doActionIBSheet2(sheetObject2, formObject, IBINSERT);
                break;
                case "btn_delete2":
                    if ( sheetObject2.FindCheckedRow(PREFIX02+"del_chk") == "" ){
                        ComShowCodeMessage("EQR90214");
                    }else if ( ComShowCodeConfirm("EQR90193") ){ 
                        doActionIBSheet2(sheetObject2,formObject,IBDELETE);
                    }
                break;
                case "btn_revenue":
                break;
                case "btn_remove":
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC04);
                break;
                case "btn_vvd": // vvd
                    var param="?vvd_cd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/COM_ENS_0B2.do" , 755, 460 , "popupFinish" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "HRBTN":
                    var param="?version=H&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_1057.do"+param , 940, 490 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "RMBTN":
                    var param="?vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_1056.do"+param , 910, 480 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "DMBTN":
                    var param="?version=D&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_1057.do"+param , 940, 490 , "" , "1,0,1,1,1,1,1,1" , true );
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
        ComBtnDisable("btn_save");
        ComBtnDisable("btn_remove");
        ComBtnDisable("btn_rowadd");
        ComBtnDisable("btn_delete");
        ComBtnDisable("btn_rowadd2");
        ComBtnDisable("btn_delete2");
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); 
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); 
        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        axon_event.addListenerForm('click', 'form_click',    document.form); 
        document.form.vvd.focus();
    }
    /**
     * onload sheet body   
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        setHRText2();
        sheetObjects[0].RenderSheet(0);
        sheetObjects[1].RenderSheet(0);
        sheetObjects[2].RenderSheet(0);
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
        sheetObjects[0].RenderSheet(1);
        sheetObjects[1].RenderSheet(1);
        sheetObjects[2].RenderSheet(1);
    }
    function setHRText2(){
        HRTEXT.innerText="HR :    ";
        RMTEXT.innerText="Rev. MTY :    ";
        DMTEXT.innerText="DMG :    ";
    }     
    /**
     * Setting sheet default value 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		             var HeadTitle="|||MTY Volume|MTY Volume|MTY Volume|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|P2|P4|T2|T4|";
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
				                 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX00+"del_chk" },
				                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX00+"status" },
				                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:PREFIX00+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"yd_cd",      KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"etb",        KeyField:0,   CalcLogic:"",   Format:"Ymd", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"total",      KeyField:0,   CalcLogic:sumLine, Format:"NullInteger", UpdateEdit:0, InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d7",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r9",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"s2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"s4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"a2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"a4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"p2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"p4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"t2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"t4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"clptindseq", KeyField:0,   CalcLogic:"",   Format:"" } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetCountPosition(0);
		             SetSheetHeight(120);
            	}
            break;
            case "sheet2":
                with(sheetObj){
					 var HeadTitle="|||POL|POL|ETD|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|P2|P4|T2|T4|";
					 var headCount=ComCountHeadTitle(HeadTitle);
					 var sumLine2="|"+PREFIX01+"d2| + |"+PREFIX01+"d4| + |"+PREFIX01+"d5| + |"+PREFIX01+"d7| + |"+PREFIX01+"r2| + |"+PREFIX01+"r5| + |"+PREFIX01+"r9| + " +
					 "|"+PREFIX01+"o2| + |"+PREFIX01+"o4| + |"+PREFIX01+"o5| + |"+PREFIX01+"s2| + |"+PREFIX01+"s4| + |"+PREFIX01+"f2| + |"+PREFIX01+"f4| + " +
					 "|"+PREFIX01+"f5| + |"+PREFIX01+"a4| + |"+PREFIX01+"a2| + |"+PREFIX01+"p2| + |"+PREFIX01+"p4| + |"+PREFIX01+"t2| + |"+PREFIX01+"t4|";
					
					 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					 var headers = [ { Text:HeadTitle, Align:"Center"} ];
					 InitHeaders(headers, info);
					
					 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX01+"ibflag" },
								{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX01+"del_chk" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"status" },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1},
								{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"yd_cd",      KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
								{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"etb",        KeyField:0,   CalcLogic:"",   Format:"Ymd", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"total",      KeyField:0,   CalcLogic:sumLine2,Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d7",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r9",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"s2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"s4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"a2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"a4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"p2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"p4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"t2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"t4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"clptindseq", KeyField:0,   CalcLogic:"",   Format:"" } ];
					  
					 InitColumns(cols);
					 SetEditable(1);
					 SetCountPosition(0);
					 SetSheetHeight(120);
            	}
            break;
            case "sheet3":
                with(sheetObj){
				   var HeadTitle="|||POD|POD|ETB|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|P2|P4|T2|T4|";
				   var headCount=ComCountHeadTitle(HeadTitle);
				   var sumLine3="|"+PREFIX02+"d2| + |"+PREFIX02+"d4| + |"+PREFIX02+"d5| + |"+PREFIX02+"d7| + |"+PREFIX02+"r2| + |"+PREFIX02+"r5| + |"+PREFIX02+"r9| + |"+PREFIX02+"o2| + " +
				   "|"+PREFIX02+"o4| + |"+PREFIX02+"o5| + |"+PREFIX02+"s2| + |"+PREFIX02+"s4| + |"+PREFIX02+"f2| + |"+PREFIX02+"f4| + |"+PREFIX02+"f5| + |"+PREFIX02+"a4| + " +
				   "|"+PREFIX02+"a2| + |"+PREFIX02+"p2| + |"+PREFIX02+"p4| + |"+PREFIX02+"t2| + |"+PREFIX02+"t4|";
				
				   SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				   var headers = [ { Text:HeadTitle, Align:"Center"} ];
				   InitHeaders(headers, info);
					
					   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX02+"ibflag" },
									{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX02+"del_chk" },
									{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"status" },
									{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1},
									{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"yd_cd",      KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
									{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"etb",        KeyField:0,   CalcLogic:"",   Format:"Ymd", UpdateEdit:0,   InsertEdit:0 },
									{Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"total",      KeyField:0,   CalcLogic:sumLine3,Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d7",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r9",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"s2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"s4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"a2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"a4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:43,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f5",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"p2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"p4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"t2",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"t4",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:1,   InsertEdit:1 },
									{Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"clptindseq", KeyField:0,   CalcLogic:"",   Format:"" } ];
					    
					   InitColumns(cols);
					   SetEditable(1);
					   SetCountPosition(0);
					   SetSheetHeight(120);
					   ShowSubSum({SumEx:1});
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
                		ComOpenWait(true);
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
                            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
                        }
                		sheetObj.SetWaitImageVisible(1);
                		ComOpenWait(false);
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
                    document.form.version.value=arrTpSz[2];
                    document.form.remark.value=arrTpSz[4];
                    if(arrTpSz[3] != null && arrTpSz[3] != ""){
	                    document.form.userid.value=arrTpSz[3];
	                    document.form.date.value=arrTpSz[5];
                    }else{
                    	document.form.userid.value=document.form.session_user_id.value;
	                    document.form.date.value="";
                    }
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;
            case IBSEARCH_ASYNC02:      // PORT 
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH04;
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData("EES_EQR_1024GS.do",FormQueryString(formObj));
                    var sCheck=ComXml2ComboString(sXml, "yd_cd", "etb");
                    if ( sCheck == undefined  || sCheck == "" || sCheck.length < 1){
                        var tR=formObj.editRow.value;
                        ComShowCodeMessage("EQR90205");
                        sheetObjects[1].InitCellProperty(tR,PREFIX01+"yd_cd",{ Type:"Data"} );
                        sheetObjects[1].SelectCell(tR, 3, true);
                        sheetObjects[1].SetCellValue(tR,PREFIX01+"yd_cd","",0);
                        sheetObjects[1].SetCellValue(tR,PREFIX01+"etb","",0);
                        sheetObjects[1].SetCellValue(tR,PREFIX01+"clptindseq","",0);
                        return false;
                    }else{
                        var tR=formObj.editRow.value;
                        if(sCheck[0].length > 2){
                            sheetObjects[1].InitCellProperty(tR,PREFIX01+"yd_cd",{ Type:"ComboEdit"} );
                            arrText=sCheck[0].split("|");
                            arrValue=sCheck[1].split("|");
                            var comboText="";
                            var comboValue="";
                            for(var i=0 ; i < arrValue.length-1 ; i++){
                            	arrValue2=arrValue[i].split("&&");
                            	comboText += arrText[i]+"\t"+arrValue2[i]+"|";
                            	comboValue += arrText[i]+"\t"+arrValue2[i]+arrValue2[i+1]+"|";
        			   	  	}
                            arrValue2=arrValue[arrValue.length-1].split("&&");
                            comboText += arrText[arrValue.length-1]+"\t"+arrValue2[0];
                            comboValue += arrText[arrValue.length-1]+"\t"+arrValue2[0]+arrValue2[1];
    			   	  		sheetObjects[1].CellComboItem(tR,PREFIX01+"yd_cd", {ComboText:"||"+comboText, ComboCode:"||"+comboValue} );
    			   	  		sheetObjects[1].SelectCell(tR, 4, true);
                        }
                        else{
                         	sheetObjects[1].InitCellProperty(tR,PREFIX01+"yd_cd",{ Type:"Data"} );
	                        sheetObjects[1].SetCellValue(tR,PREFIX01+"yd_cd",sCheck[0],0);
	                        arrValue3=sCheck[1].split("&&");
	                        sheetObjects[1].SetCellValue(tR,PREFIX01+"etb",arrValue3[0],0);
	                        sheetObjects[1].SetCellValue(tR,PREFIX01+"clptindseq",arrValue3[1],0);
                        }
                    }
                    if(sCheck == ","){
                    	var tR=formObj.editRow.value;
                    	 sheetObjects[1].SetCellValue(tR,PREFIX01+"clptindseq","0",0);
                    }
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;
            case IBSEARCH_ASYNC03:      // PORT 
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH02;
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData("EES_EQR_1024GS.do",FormQueryString(formObj));
                    var sCheck=ComXml2ComboString(sXml, "yd_cd", "etb");
                    if ( sCheck == undefined  || sCheck == "" || sCheck.length < 1){
                        var tR=formObj.editRow.value;
                        ComShowCodeMessage("EQR90205");
                        sheetObjects[2].InitCellProperty(tR,PREFIX02+"yd_cd",{ Type:"Data"} );
                        sheetObjects[2].SelectCell(tR, 3, true,"");
                        sheetObjects[2].SetCellValue(tR,PREFIX02+"yd_cd","",0);
                        sheetObjects[2].SetCellValue(tR,PREFIX02+"etb","",0);
                        sheetObjects[2].SetCellValue(tR,PREFIX02+"clptindseq","",0);
                        return false;
                    }else{
                        var tR=formObj.editRow.value;
                        if(sCheck[0].length > 2){
                            sheetObjects[2].InitCellProperty(tR,PREFIX02+"yd_cd",{ Type:"ComboEdit"} );
                            arrText=sCheck[0].split("|");
                            arrValue=sCheck[1].split("|");
                            var comboText="";
                            var comboValue="";
                            for(var i=0 ; i < arrValue.length-1 ; i++){
                            	arrValue2=arrValue[i].split("&&");
                            	comboText += arrText[i]+"\t"+arrValue2[i]+"|";
                            	comboValue += arrText[i]+"\t"+arrValue2[i]+arrValue2[i+1]+"|";
        			   	  	}
                            arrValue2=arrValue[arrValue.length-1].split("&&");
                            comboText += arrText[arrValue.length-1]+"\t"+arrValue2[0];
                            comboValue += arrText[arrValue.length-1]+"\t"+arrValue2[0]+arrValue2[1];
    			   	  		sheetObjects[2].CellComboItem(tR,PREFIX02+"yd_cd", {ComboText:"||"+comboText, ComboCode:"||"+comboValue} );
    			   	  		sheetObjects[2].SelectCell(tR, 4, true);
                        }
                        else{
                         	sheetObjects[2].InitCellProperty(tR,PREFIX01+"yd_cd",{ Type:"Data"} );
	                        sheetObjects[2].SetCellValue(tR,PREFIX02+"yd_cd",sCheck[0],0);
	                        arrValue3=sCheck[1].split("&&");
	                        sheetObjects[2].SetCellValue(tR,PREFIX02+"etb",arrValue3[0],0);
	                        sheetObjects[2].SetCellValue(tR,PREFIX02+"clptindseq",arrValue3[1],0);
                        }
                    }
                    if(sCheck == ","){
                    	var tR=formObj.editRow.value;
                    	 sheetObjects[2].SetCellValue(tR,PREFIX02+"clptindseq","0",0);
                    }
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;            
            case IBSEARCH_ASYNC05:      // yd_cd validate check
                if (validateForm(sheetObj, formObj, sAction)) {
                	var tR=formObj.editRow.value;
                    formObj.f_cmd.value=SEARCH03;
                    formObj.yardcode.value=sheetObj.GetCellValue(tR,3)+sheetObj.GetCellValue(tR,4).substring(0,2);
                    if(sheetObj.GetCellValue(tR,4).substring(3,11) != ""){
                    	sheetObj.SetCellValue(tR,PREFIX01+"etb",sheetObj.GetCellValue(tR,4).substring(3,11),0);
                    }
                    if(sheetObj.GetCellValue(tR,4).substring(11,12) != ""){
                    	sheetObj.SetCellValue(tR,PREFIX01+"clptindseq",sheetObj.GetCellValue(tR,4).substring(11,12),0);
                    }
                    if(sheetObj.GetCellValue(tR,4).substring(0,2) != ""){
	                    sheetObj.SetWaitImageVisible(0);
 	                    var sXml=sheetObj.GetSearchData("EES_EQR_1024GS.do",FormQueryString(formObj));
	                    var sCheck=ComGetEtcData(sXml, "check");
	    				if (sCheck != "OK") {
							ComShowCodeMessage("EQR90218");
							sheetObj.SelectCell(tR, 4, true,"");
							return false;
	    				}
                    }
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;
            case IBSEARCH02:      
            break;            
            case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction)) {
                    for( var i=7 ; i < 26 ; i++ ){
                    	if (sheetObjects[0].GetSumValue(0,i) != sheetObjects[2].GetSumValue(0,i) ) {
                        	ComShowCodeMessage("EQR90220",sheetObjects[0].ColSaveName(i).toUpperCase());
                            sheetObjects[1].SelectCell(1,i);
                            i=9999;
                            return false;
                        }
                    }
                    var rCnt01=sheetObjects[1].RowCount()+1;
                    var rCnt02=sheetObjects[2].RowCount()+1;
                    for ( var i=1 ; i < rCnt01 ; i++ ) {
                    	if ( sheetObjects[1].GetCellValue(i,3) ==  "" &&  sheetObjects[1].GetCellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Port Code ");
                            sheetObjects[1].SelectCell(i, 3, true);
                            return false;
                        }
                    	if ( sheetObjects[1].GetCellValue(i,4) ==  "" &&  sheetObjects[1].GetCellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Yard Code ");
                            sheetObjects[1].SelectCell(i, 3, true);
                            return false;
                        }
                    	if ( sheetObjects[1].GetCellValue(i,5) == "" &&  sheetObjects[1].GetCellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","ETD Code ");
                            sheetObjects[1].SelectCell(i, 3, true);
                            return false;
                        }
                    }
                    for ( var i=1 ; i < rCnt02 ; i++ ) {
        				if ( sheetObjects[2].GetCellValue(i,3) ==  "" &&  sheetObjects[2].GetCellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Port Code ");
                            sheetObjects[2].SelectCell(i, 3, true);
                            return false;
                        }
        				if ( sheetObjects[2].GetCellValue(i,4) ==  "" &&  sheetObjects[2].GetCellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Yard Code ");
                            sheetObjects[2].SelectCell(i, 3, true);
                            return false;
                        }
        				if ( (sheetObjects[2].GetCellValue(i,5) == "" || sheetObjects[2].GetCellValue(i,5) == "SKIP") &&  sheetObjects[2].GetCellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","ETB ");
                            sheetObjects[2].SelectCell(i, 3, true);
                            return false;
                        }
                    }
                    sheetObjects[2].ColumnSort(PREFIX02+"etb","ASC");
                    document.form.n1stEtb.value=sheetObjects[2].GetCellValue( 1 , PREFIX02+"etb" );
                    if ( sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=MULTI;                
                        var sParam1=sheetObjects[0].GetSaveString(true);
                        var sParam2=sheetObjects[1].GetSaveString(true);
                        var sParam3=sheetObjects[2].GetSaveString(true);
                        formObj.sh2RC.value=sheetObjects[1].LastRow()- 1;
                        sParam=sParam1 +  "&" + sParam2 +  "&" + sParam3 +  "&" + FormQueryString(formObj);
                        var sXml=sheetObj.GetSaveData("EES_EQR_1024GS.do", sParam);
                        sheetObjects[0].LoadSaveData(sXml);
                    }
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
                }
            break;
            case IBSEARCH_ASYNC04:        
            	if (!ComShowCodeConfirm("EQR90219",document.form.vvd.value)) return;
                    formObj.f_cmd.value=MULTI01;                
                    var sParam1=sheetObjects[0].GetSaveString(true);
                    var sParam2=sheetObjects[1].GetSaveString(true);
                    var sParam3=sheetObjects[2].GetSaveString(true);
                    sParam=sParam1 +  "&" + sParam2 +  "&" + sParam3 +  "&" + FormQueryString(formObj);
                    var sXml=sheetObj.GetSaveData("EES_EQR_1024GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
            break;            
            case IBINSERT:      
                sheetObj.DataInsert();
                var rCnt01=sheetObjects[1].RowCount();
                for ( var i=0 ; i < rCnt01 ; i++ ) {
                     sheetObjects[1].SetCellEditable(i,6,0);
                }
                removeZero2(sheetObjects[1]);
                sheetObj.SetSumText(0, PREFIX01+"pod_cd","Additonal Load Total");
                sheetObj.SetMergeCell(sheetObj.LastRow(), 3 , 1 , 3);
                sheetObj.SetCellAlign(sheetObj.LastRow(),PREFIX01 + "pod_cd","Center");
            break;
            case IBDELETE:      
                if (sheetObj.id == 'sheet2') {  
                    //no support[implemented common]CLT sheetObj.SelectFontBold=false;
                    if(sheetObj.FindCheckedRow(PREFIX01+"del_chk") != ""){
                        ComRowHideDelete(sheetObj,PREFIX01+"del_chk"); 
                        //no support[implemented common]CLT sheetObj.SelectFontBold=true;
                        rcnt=sheetObj.RowCount();
                        if( rcnt == 0 ){
                            for( var i=5 ; i < 25 ; i++ ){
                                sheetObjects[0].SetCellValue(2,i,"");
                            }
                        }else{
                            sheet2_OnSearchEnd (sheetObjects[1], "");
                        }
                    } else {     
                    }
                }               
            break;
        }
    }
  // Sheet
    function doActionIBSheet2( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBINSERT:     
                sheetObj.DataInsert();
                var rCnt01=sheetObjects[2].RowCount();
                for ( var i=0 ; i < rCnt01 ; i++ ) {
                    sheetObjects[2].SetCellEditable(i,5,0);
                    sheetObjects[2].SetCellEditable(i,6,0);
                }
                removeZero2(sheetObjects[2]);
                sheetObj.SetSumText(0, PREFIX02+"pod_cd","Discharge Total");
                sheetObj.SetMergeCell(sheetObj.LastRow(), 3 , 1 , 3);
                sheetObj.SetCellAlign(sheetObj.LastRow(),PREFIX02+"pod_cd","Center");
            break;
            case IBDELETE:      
            if (sheetObj.id == 'sheet3') {  
                //no support[implemented common]CLT sheetObj.SelectFontBold=false;
                if(sheetObj.FindCheckedRow(PREFIX02+"del_chk") != ""){
                    ComRowHideDelete(sheetObj,PREFIX02+"del_chk"); 
                    rcnt=sheetObj.RowCount();
                    if( rcnt == 0 ){
                    }else{
                    	sheet3_OnDeleteEnd (sheetObjects[2], "");
                    }
                } else {     
                }
            }               
            break;
        }
    }
    /**
     * validate input value
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction == IBSEARCH || sAction == IBSEARCH_ASYNC01){
                if(vvd.value == "" && sAction == IBSEARCH){
                    ComShowCodeMessage("EQR90198");
                    ComSetFocus(vvd);
                    return false;
                } 
                else if(vvd.value == ""){
                	return false;
                }
            }
        }
        return true;
    }
    // remove total value zero
    function removeZero(sheetObj) {
        with(sheetObj) {
            var sCol=6;
            var eCol=LastCol();
            for ( i=sCol ; i <= eCol ; i++ ) {
            	if (0 == GetSumText(0, i) ) {
            		 SetSumText(0, i,"0");
                }
            	if ("" == GetSumText(0, i) ) {
                     SetSumText(0, i,"0");
                }
            }
        }
    }
    // remove total value zero
    function removeZero2(sheetObj) {
        with(sheetObj) {
            var sCol=6;
            var eCol=LastCol();
            var rCnt=sheetObj.RowCount()+ 1;
            for ( var o=1 ; o < rCnt ; o++ ) {
                for ( i=sCol ; i <= eCol ; i++ ) {
                	if ( "" == GetCellValue( o , i) ) {
                        SetCellValue(o, i,"0",0);
                    }
                }
            }
        }
    }    
    function sheet1_OnSearchEnd (sheetObj, code, ErrMsg) {
        with (sheetObj) {
            SetColBackColor(PREFIX00+"pod_cd","#E5EAFF");
            SetSumText( 0 , PREFIX00 + "pod_cd", "Onboard Total");
            removeZero(sheetObj);
            //no support[implemented common]CLT MessageText("Sum")="Onboard Total";
        }
    }
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
     //   	SelectBackColor  = "#FFFFFF";
            SetSumText( 0 , PREFIX01 + "pod_cd","Additonal Load Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(), PREFIX01 + "pod_cd", "Center");
            removeZero(sheetObj);
            var rCnt01=sheetObjects[1].RowCount();
            for ( var i=0 ; i < rCnt01 ; i++ ) {
                sheetObjects[1].SetCellEditable(i,6,0);
            }
            for ( var i=7 ; i < 27 ; i++ ) {
            	sheetObjects[0].SetCellValue(2, i, GetSumValue(0, i), 0);
            }
        }
    }
    function sheet2_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift) {
		if(ComGetLenByByte(sheetObjects[1].GetEditText()) == 5 && Col == 3){
			sheetObjects[1].SelectCell(Row,Col+1,false);
		}
    }
    function sheet3_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift) {
		if(ComGetLenByByte(sheetObjects[2].GetEditText()) == 5 && Col == 3){
			sheetObjects[2].SelectCell(Row,Col+1,false);
		}
    }
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        with(sheetObj) {
            SetSumText(0, PREFIX01+"pod_cd","Additonal Load Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(), PREFIX02 + "pod_cd", "Center");
            removeZero(sheetObj);
            var formObj=document.form;
            if ( Col == 3 ) {
                var rCnt01=sheetObjects[1].RowCount()+ 1;
                var rCnt02=sheetObjects[2].RowCount()+ 1;
                for ( var i=1 ; i < rCnt01 ; i++ ) {
                	if ( sheetObjects[1].GetCellValue(i,Col) ==  Value && Row != i && sheetObjects[1].GetCellValue(i,0) != "D" ) {
                    	ComShowCodeMessage("EQR90194");
                        sheetObj.SelectCell(Row, Col, true, "");
                        return false;
                    }
                }
                formObj.editRow.value=Row;
                formObj.editPort.value=Value;
                formObj.editIbFlag.value=sheetObj.GetCellValue(Row,0);
                if(ComGetLenByByte(sheetObjects[1].GetCellValue(Row,Col)) == 5){
                	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC02 );
                }
                else{
                    ComShowCodeMessage("EQR90205");
                    sheetObj.SelectCell(Row, 3, true);
                    sheetObj.SetCellValue(Row,PREFIX01+"yd_cd","",0);
                    sheetObj.SetCellValue(Row,PREFIX01+"etb","",0);
                }
            } else {
                if ( Col > 6 ) {
                	sheetObjects[0].SetCellValue(2,Col,GetSumValue(0, Col),0);
                }
                else if ( Col == 4 ) { // yd_cd 컬럼
                	if(GetCellValue(Row,Col) != ''){
	                	formObj.editRow.value=Row;
	                	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC05);
                	}
                }
            }
        }
    }
    function sheet3_OnDeleteEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
            SetSumText(0, PREFIX02+"pod_cd","Discharge Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(),PREFIX02+"pod_cd","Center");
            removeZero(sheetObj);
            var rCnt01=sheetObjects[2].RowCount();
            for ( var i=0 ; i < rCnt01 ; i++ ) {
               // sheetObjects[2].CellEditable(i,4) = false;
                sheetObjects[2].SetCellEditable(i,5,0);
                sheetObjects[2].SetCellEditable(i,6,0);
            }
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_remove");
            ComBtnEnable("btn_rowadd");
            ComBtnEnable("btn_delete");
            ComBtnEnable("btn_rowadd2");
            ComBtnEnable("btn_delete2");
        }
    }
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
             SetSumText(0, PREFIX02+"pod_cd","Discharge Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(),PREFIX02+"pod_cd","Center");
            removeZero(sheetObj);
            var tVer=document.form.version.value;
            if ( tVer == "I" || tVer == "B") {
                for( var i=7 ; i < 27 ; i++ ) {
                	sheetObjects[0].SetCellValue(1,i,sheetObj.GetSumValue(0,i),0);
                }
            }
            var rCnt01=sheetObjects[2].RowCount();
            for ( var i=0 ; i < rCnt01 ; i++ ) {
               // sheetObjects[2].CellEditable(i,4) = false;
                sheetObjects[2].SetCellEditable(i,5,0);
                sheetObjects[2].SetCellEditable(i,6,0);
            }
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_remove");
            ComBtnEnable("btn_rowadd");
            ComBtnEnable("btn_delete");
            ComBtnEnable("btn_rowadd2");
            ComBtnEnable("btn_delete2");
        }
    }
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
        with(sheetObj) {
            removeZero(sheetObj);
            //no support[implemented common]CLT MessageText("Sum")="";
            var formObj=document.form;
            if( Col == 3 ) {
                var rCnt01=sheetObjects[1].RowCount()+ 1;
                var rCnt02=sheetObjects[2].RowCount()+ 1;
                for ( var i=1 ; i < rCnt02 ; i++ ) {
                	if ( sheetObjects[2].GetCellValue(i,Col) ==  Value && Row != i && sheetObjects[2].GetCellValue(i,0) != "D" ) {
                    	ComShowCodeMessage("EQR90194");
                        sheetObj.SelectCell(Row, Col, true, "");
                        return false;
                    }
                } 
                formObj.editRow.value=Row;
                formObj.editPort.value=Value;
				formObj.editIbFlag.value=sheetObj.GetCellValue(Row,0);
				if(ComGetLenByByte(sheetObj.GetCellValue(Row,Col)) == 5){
                	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC03 );
                }
                else{
                    ComShowCodeMessage("EQR90205");
                    sheetObj.SelectCell(Row, 3, true);
                    sheetObj.SetCellValue(Row,PREFIX02+"yd_cd","",0);
                    sheetObj.SetCellValue(Row,PREFIX02+"etb","",0);
                }                               
            }
            else if ( Col == 4 ) { // yd_cd 컬럼
            	formObj.editRow.value=Row;
            	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC05);
            }
        }
    }
    //Axon 
    function obj_deactivate() {
        switch (event.srcElement.name) {
            case "vvd":
                if(event.srcElement.value != ""){
                }
            break;
        }           
        return true;
    }
function obj_keypress(){
    switch(event.srcElement.name){
        case "vvd":
            ComKeyOnlyAlphabet('uppernum');
        break;
    }   
}    
