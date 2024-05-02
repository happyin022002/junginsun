/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4103.jsp
*@FileTitle  : Sheet Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var ROWMARK="|";
var FIELDMARK="=";
var DEF_SHEET_HEIGHT = 140;

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_save":
            		if(ComGetObjValue(formObject.sec_invoice) == "N") {
            			ComShowCodeMessage("DMT01145", "Save");
            			return;
            		}                	
                    if ( formObject.h_user_office.value == formObject.isof.value ) {
                        if ( ComShowConfirm("Will you save this sheet option?") ) {                    
                            doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                        } else {
                            return false;
                        }
                    } else {
                        ComShowCodeMessage( "DMT01103" );
                        return false;
                    }                    
                break;
                case "btn2_rowadd01":
                    doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
                break;
                case "btn2_rowdel01":
                    if ( ComShowCodeConfirm("DMT00143") ){ 
                        doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
                    }
                break;
                case "btn2_rowadd02":
                    doActionIBSheet2(sheetObjects[1], formObject, IBINSERT);
                break;
                case "btn2_rowdel02":
                    if ( ComShowCodeConfirm("DMT00143") ){ 
                        doActionIBSheet2(sheetObjects[1],formObject,IBDELETE);
                    }
                break;
                case "btn_close":
//                    if ( document.form.tJspno.value == "EES_DMT_4002" ||
//                         document.form.tJspno.value == "EES_DMT_3109" ||
//                         document.form.tJspno.value == "EES_DMT_3108" ||
//                         document.form.tJspno.value == "EES_DMT_4004" ||
//                         document.form.tJspno.value == "EES_DMT_4016-1"
//                       ) {
//                        var opener = window.dialogArguments;
//                        //opener.document.form.tax_rto.value = document.form.taxrto.value;
//                        var tTftp = document.form.tTftp.value;
//                        var tTaxRto = document.form.taxrto.value;
//                        var rtnValTerm = "";
//                        var rtnValIsDt = "";
//                        var tOpnTftp = 0;
//                        if ( tTftp == "DMIF" ) {
//                            tOpnTftp = 3;
//                        } else if ( tTftp == "DTIC" ) {
//                            tOpnTftp = 4;
//                        } else if ( tTftp == "DMOF" ) {
//                            tOpnTftp = 5;
//                        } else if ( tTftp == "DTOC" ) {
//                            tOpnTftp = 6;
//                        } else if ( tTftp == "CTIC" ) {
//                            tOpnTftp = 7;
//                        } else if ( tTftp == "CTOC" ) {
//                            tOpnTftp = 8;
//                        }
//                        for ( var x18 = 2 ; x18 < sheetObjects[0].LastRow+1 ; x18++ ) {
//                            if ( sheetObjects[0].CellValue( x18 , tOpnTftp ) == 1 ) {
//                                rtnValTerm = sheetObjects[0].CellValue( x18 ,  9 );
//                                rtnValIsDt = sheetObjects[0].CellValue( x18 , 10 );
//                            }
//                        }
//                        opener.getSheetOptionData(rtnValTerm,rtnValIsDt,tTaxRto);
//                    }
                	unLoadPage();
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        if (document.form.taxrto.value > 0) {
            //document.form.rtovat.value="Y";
            document.form.rtovat.disabled=true;
        } else {
            //document.form.rtovat.value="Y";
            document.form.rtovat.disabled=false;
        }
    }
  /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet1 init Credit Term
                with (sheetObj) {
		            var HeadTitle1="|Seq.|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Term (Days)|Due Date||";
		            var HeadTitle2="|Seq.|All|DMIF|DTIC|DMOF|DTOC|CTIC|CTOC|Term (Days)|Due Date||";
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seqq" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"alll",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmif",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dtic",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmof",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dtoc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ctic",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ctoc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"term",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"issd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"shtp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"titl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		            InitColumns(cols);
		            SetColProperty("issd", {ComboText:"|IssueDate|********", ComboCode:"0|1|2"} );
		            SetEditable(1);
		            SetSheetHeight(DEF_SHEET_HEIGHT);
		            SetCountPosition(0);
               }
            break; 
            case "sheet2":      // sheet2 init Customized Title
                with (sheetObj) {
		            
		             var HeadTitle1="|Seq.|Sheet Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Customized Title||";
		             var HeadTitle2="|Seq.|Sheet Type|All|DMIF|DTIC|DMOF|DTOC|CTIC|CTOC|Customized Title||";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                             { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seqq" },
				                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"shtp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"alll",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmif",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dtic",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmof",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dtoc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ctic",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ctoc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"titl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"term",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"issd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             InitColumns(cols);
		             SetColProperty("shtp", {ComboText:"Invoice|Demand Note|Group Demand|OTS Invoice", ComboCode:"I|D|G|O"} );
		             SetEditable(1);
		             SetSheetHeight(DEF_SHEET_HEIGHT);
		             SetCountPosition(0);
               }
            break;
        }
    }
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == 'sheet1') { 
                        for( var i=0 ; i < sheetObjects.length ; i++ ){
                            sheetObjects[i].RemoveAll();
                        }               
                        formObj.f_cmd.value=SEARCH;    
                        ComOpenWait(true);
                        sheetObj.SetWaitImageVisible(0);
                        var sXml=sheetObj.GetSearchData("EES_DMT_4103GS.do", FormQueryString(formObj));
                        ComOpenWait(false);
                        var arrXml=sXml.split("|$$|");
                        var shOptInfo=ComGetEtcData(arrXml[0], "shOptInfo");
                        if ( shOptInfo != undefined && shOptInfo != '' ) {
                            var arrTpSz=shOptInfo.split("|");
                            document.form.isof  .value=arrTpSz[0];
                            document.form.toloca.value=arrTpSz[1]; // LEFT RIGHT
                            document.form.cusref.value=arrTpSz[2]; // Cust. Ref.
                            document.form.telfax.value=arrTpSz[3]; // Tel. Fax
                            document.form.cusvat.value=arrTpSz[4]; // Cust. VAT No.
                            document.form.taxrto.value=arrTpSz[5]; // Tax Rate
                            document.form.rtovat.value=arrTpSz[6]; // 
                            document.form.dcamtr.value=arrTpSz[7]; // 
                        }
                        for( var i=0 ; i < arrXml.length ; i++ ){
                            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
                        }
                    }                     
                } else {
                    return;
                }
            break;
            case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction)) {
                    if ( sheetObj.id == "sheet1") {
                        var rCnt01=sheetObjects[0].RowCount()+2;
                        var rCnt02=sheetObjects[1].RowCount()+2;
                        var dupCnt=0;
                        var chkCnt=0;
                        for ( var aaa=3 ; aaa < 9 ; aaa++ ) {
                            for ( var iii=2 ; iii < rCnt01 ; iii++ ) {
                            	if ( sheetObjects[0].GetCellValue( iii , aaa ) == 1 && sheetObjects[0].GetCellValue( iii , 0 ) != "D" ) {
                                    dupCnt++;
                                }
                            	if ( sheetObjects[0].GetCellValue( iii , aaa ) == 1 ) { chkCnt++; }
                            }
                            if ( dupCnt > 1 ) {
                                //ComShowCodeMessage("DMT00144"," Tariff Type Credit Term");
                                ComShowCodeMessage( "DMT01104" );
                                return false;
                            }
                            dupCnt=0;
                        }
                        if ( chkCnt == 0 && rCnt01 > 2 ) {
                            ComShowCodeMessage("DMT01110","Credit Term");
                            return false;
                        }
                        chkCnt=0;
                        dupCnt=0;
                        var tShTp="";
                        var tShTp2="";
                        for ( var aaa=4 ; aaa < 10 ; aaa++ ) { 
                            tShTp="";
                            for ( var iii=2 ; iii < rCnt02 ; iii++ ) {
                            	if ( sheetObjects[1].GetCellValue( iii , aaa ) == 1 && sheetObjects[1].GetCellValue( iii , 2 ) == tShTp && sheetObjects[1].GetCellValue( iii , 0 ) != "D") { // 선택한 tariff 와 sheet 이 같을 때
                                    dupCnt++;
                                    tShTp=sheetObjects[1].GetCellValue( iii , 2 );
                                    if ( dupCnt > 1 ) {
                                        tShTp2=sheetObjects[1].GetCellText( iii , 2 );;
                                    }
                                }
                            	if ( iii == 2 && sheetObjects[1].GetCellValue( iii , aaa ) == 1 ) {
                                    dupCnt++;
                                    tShTp=sheetObjects[1].GetCellValue( iii , 2 );
                                }
                            	if ( sheetObjects[1].GetCellValue( iii , aaa ) == 1 ) { chkCnt++; }
                            }
                            if ( dupCnt > 1 ) {
                                ComShowCodeMessage( "DMT01105" , tShTp2 );
                                //ComShowCodeMessage("DMT00144"," Tariff Type Customized Title");
                                return false;
                            }                            
                            dupCnt=0;
                        }
                        if ( chkCnt == 0 && rCnt02 > 2 ) {
                            ComShowCodeMessage("DMT01110","Customized Title");
                            return false;
                        }
                        for ( var iii=2 ; iii < rCnt02 ; iii++ ) {
                        	if ( sheetObjects[1].GetCellValue( iii , 10 ) == '' ) {
                                ComShowCodeMessage("DMT02002","Customized Title ");
                                return false;
                            }
                        }                        
                        formObj.f_cmd.value=MULTI;                
                        var sParam1=sheetObjects[0].GetSaveString(true);
                        var sParam2=sheetObjects[1].GetSaveString(true);
                        sParam=sParam1 +  "&" + sParam2 +  "&" + FormQueryString(formObj);
                        ComOpenWait(true);
                        sheetObj.SetWaitImageVisible(0);
                        var sXml=sheetObj.GetSaveData("EES_DMT_4103GS.do", sParam);
                        sheetObjects[0].LoadSaveData(sXml);
                        ComOpenWait(false);
                    }
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
                    ComOpenWait(false);
                }
            break;
            case IBINSERT:      
                var rowno=sheetObj.DataInsert(-1);
                sheetObj.SetCellValue(rowno,2,1,0);
                sheetObj.SetCellValue(rowno,3,1,0);
                sheetObj.SetCellValue(rowno,4,1,0);
                sheetObj.SetCellValue(rowno,5,1,0);
                sheetObj.SetCellValue(rowno,6,1,0);
                sheetObj.SetCellValue(rowno,7,1,0);
                sheetObj.SetCellValue(rowno,8,1,0);
                sheetObj.SetCellValue(rowno,9,"0",0);
                sheetObj.SetCellValue(rowno,10,"1",0);
            break;
            case IBDELETE:      
                if (sheetObj.id == 'sheet1') {  
                    //no support[implemented common]CLT sheetObj.SelectFontBold=false;
                    var delRow=document.form.selectRowNumUp.value;
                    sheetObj.SetRowHidden(delRow,1);
                    sheetObj.SetRowStatus(delRow,"D");
                    if ( delRow == sheetObj.RowCount()) {
                        if ( delRow - 1 < 2 ) {
                            return false;
                        }else{
                            document.form.selectRowNumUp.value=delRow - 1;                        
                        }
                    }
                }               
            break;
        }
    }
  // Sheet processing-related processes
    function doActionIBSheet2( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBINSERT:      
                var rowno=sheetObj.DataInsert(-1);
                sheetObj.SetCellValue(rowno,3,1,0);
                sheetObj.SetCellValue(rowno,4,1,0);
                sheetObj.SetCellValue(rowno,5,1,0);
                sheetObj.SetCellValue(rowno,6,1,0);
                sheetObj.SetCellValue(rowno,7,1,0);
                sheetObj.SetCellValue(rowno,8,1,0);
                sheetObj.SetCellValue(rowno,9,1,0);
            break;
            case IBDELETE:      
                if (sheetObj.id == 'sheet2') {  
                    //no support[implemented common]CLT sheetObj.SelectFontBold=false;
                    var delRow=document.form.selectRowNumDw.value;
                    sheetObj.SetRowHidden(delRow,1);
                    sheetObj.SetRowStatus(delRow,"D");
                    if ( delRow == sheetObj.RowCount()) {
                        if ( delRow - 1 < 2 ) {
                            return false;
                        }else{
                            document.form.selectRowNumUp.value=delRow - 1;                        
                        }
                    }
                }               
            break;
        }
    }
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    function sheet1_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            document.form.selectRowNumUp.value=Row;
            if ( Row > 1 && Col == 2 ) {
                if ( Value == 0 ) {
                    SetCellValue( Row , 3 ,1,0);
                    SetCellValue( Row , 4 ,1,0);
                    SetCellValue( Row , 5 ,1,0);
                    SetCellValue( Row , 6 ,1,0);
                    SetCellValue( Row , 7 ,1,0);
                    SetCellValue( Row , 8 ,1,0);
                } else {
                    SetCellValue( Row , 3 ,0,0);
                    SetCellValue( Row , 4 ,0,0);
                    SetCellValue( Row , 5 ,0,0);
                    SetCellValue( Row , 6 ,0,0);
                    SetCellValue( Row , 7 ,0,0);
                    SetCellValue( Row , 8 ,0,0);
                }
            }
            if ( Row > 1 && ( Col == 3 || Col == 4 || Col == 5 || Col == 6 || Col == 7 || Col == 8 ) ) { 
                SetCellValue( Row , 2 ,0,0);
            }
        }
    }
    function sheet1_OnChange( sheetObj , Row , Col, Value ) {
        with (sheetObj) {
            if ( Row > 1 && Col == 9 ) {
                if ( Value == 0 || Value == '' ) {
                    SetCellEditable( Row , 10 ,1);
                    SetCellValue( Row , 10 ,1,0);
                } else {
                    SetCellValue( Row , 10 ,0,0);
                    SetCellEditable( Row , 10 ,0);
                }
            }
            if ( Row > 1 && Col == 10 ) {
            	if ( Value == 0 && GetCellValue( Row , 9 ) == 0 ) {
                    ComShowMessage(msgs["DMT01102"]);
                    SetCellEditable( Row , 10 ,1);
                    SetCellValue( Row , 10 ,1,0);
                    SelectCell( Row , 10 );
            	} else if ( Value != 0 && GetCellValue( Row , 9 ) != 0 ) {
                    SetCellValue( Row , 10 ,0,0);
                    SetCellEditable( Row , 10 ,0);
                }
            }
        }
    }
    function sheet2_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            document.form.selectRowNumDw.value=Row;
            if ( Row > 1 && Col == 3 ) {
                if ( Value == 0 ) {
                    SetCellValue( Row , 4 ,1,0);
                    SetCellValue( Row , 5 ,1,0);
                    SetCellValue( Row , 6 ,1,0);
                    SetCellValue( Row , 7 ,1,0);
                    SetCellValue( Row , 8 ,1,0);
                    SetCellValue( Row , 9 ,1,0);
                } else {
                    SetCellValue( Row , 4 ,0,0);
                    SetCellValue( Row , 5 ,0,0);
                    SetCellValue( Row , 6 ,0,0);
                    SetCellValue( Row , 7 ,0,0);
                    SetCellValue( Row , 8 ,0,0);
                    SetCellValue( Row , 9 ,0,0);
                }
            }
            if ( Row > 1 && ( Col == 4 || Col == 5 || Col == 6 || Col == 7 || Col == 8 || Col == 9 ) ) {
                SetCellValue( Row , 3 ,0,0);
            }
        }
    }
    function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg){
        with (sheetObj) {
            if ( RowCount()== 0 ) {
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
            } else {
                var tDmif=1;
                var tDtic=1;
                var tDmof=1;
                var tDtoc=1;
                var tCtic=1;
                var tCtoc=1;
                for ( var x18=2 ; x18 < LastRow()+1 ; x18++ ) {
					if ( GetCellValue( x18 , 3 ) == 1 ) { tDmif=0; }
					if ( GetCellValue( x18 , 4 ) == 1 ) { tDtic=0; }
					if ( GetCellValue( x18 , 5 ) == 1 ) { tDmof=0; }
					if ( GetCellValue( x18 , 6 ) == 1 ) { tDtoc=0; }
					if ( GetCellValue( x18 , 7 ) == 1 ) { tCtic=0; }
					if ( GetCellValue( x18 , 8 ) == 1 ) { tCtoc=0; }
                }
                if ( !( tDmif == 0 && tDtic == 0 && tDmof == 0 && tDtoc == 0 && tCtic == 0 && tCtoc == 0 ) ) {
                    var rowno2=sheetObj.DataInsert(-1);
                    sheetObj.SetCellValue( rowno2 , 2 ,0,0);
                    sheetObj.SetCellValue( rowno2 , 3 ,tDmif,0);
                    sheetObj.SetCellValue( rowno2 , 4 ,tDtic,0);
                    sheetObj.SetCellValue( rowno2 , 5 ,tDmof,0);
                    sheetObj.SetCellValue( rowno2 , 6 ,tDtoc,0);
                    sheetObj.SetCellValue( rowno2 , 7 ,tCtic,0);
                    sheetObj.SetCellValue( rowno2 , 8 ,tCtoc,0);
                    sheetObj.SetCellValue( rowno2 , 9 ,"0",0);
                    sheetObj.SetCellValue( rowno2 ,10 ,"1",0);
                }
            }
        }
    }
    function sheet2_OnSearchEnd(sheetObj, code,  ErrMsg){
        with (sheetObj) {
//            
//            if ( RowCount == 0 ) {
//                doActionIBSheet2(sheetObjects[1], document.form, IBINSERT);
//            }
        }
    }
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "engup2":
                DmtComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); 
//        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form );
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
        axon_event.addListenerForm('change', 'obj_change', form);
    }
    function obj_change() {
	    obj=event.srcElement;
	    if (obj.name == "taxrto") {
	        if (obj.value > 0) {
	            document.form.rtovat.value="Y";
	            document.form.rtovat.disabled=true;
	        } else {
	            document.form.rtovat.value="Y";
	            document.form.rtovat.disabled=false;
	        }
	    }
    }
	function unLoadPage(){
		if ( document.form.tJspno.value == "EES_DMT_4002" ||
			document.form.tJspno.value == "EES_DMT_3109" ||
		    document.form.tJspno.value == "EES_DMT_3108" ||
		    document.form.tJspno.value == "EES_DMT_4004" ||
		    document.form.tJspno.value == "EES_DMT_4016-1"
		) {
			var opener=window.dialogArguments;
 			if (!opener) opener = parent;
 			
			//opener.document.form.tax_rto.value = document.form.taxrto.value;
			var tTftp=document.form.tTftp.value;
			var tTaxRto=document.form.taxrto.value;
			var rtnValTerm="";
			var rtnValIsDt="";
			var tOpnTftp=0;
			if ( tTftp == "DMIF" ) {
				tOpnTftp=3;
			} else if ( tTftp == "DTIC" ) {
				tOpnTftp=4;
			} else if ( tTftp == "DMOF" ) {
				tOpnTftp=5;
			} else if ( tTftp == "DTOC" ) {
				tOpnTftp=6;
			} else if ( tTftp == "CTIC" ) {
				tOpnTftp=7;
			} else if ( tTftp == "CTOC" ) {
				tOpnTftp=8;
			}
			for ( var x18=2 ; x18 < sheetObjects[0].LastRow()+1 ; x18++ ) {
				if ( sheetObjects[0].GetCellValue( x18 , tOpnTftp ) == 1 ) {
				rtnValTerm=sheetObjects[0].GetCellValue( x18 ,  9 );
				rtnValIsDt=sheetObjects[0].GetCellValue( x18 , 10 );
	           }
	       }
	       opener.getSheetOptionData(rtnValTerm,rtnValIsDt,tTaxRto);
		}	
	}