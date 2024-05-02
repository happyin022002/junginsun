/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BSA_0121.js
*@FileTitle  : Company Slot Swap Information By VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
        /*
         * Event handler processing by button name 
         */
        function processButtonClick(){
            var sheetObject=sheetObjects[0];
            var formObject=document.form;
            try {
                var srcName=ComGetEvent("name");
                if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
                    case "btn_retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    case "btn_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
                    case "btn_Close":
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
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            var formObject=document.form;
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){
	                 var HeadTitle="STS|Carrier|Sales to(by VVD)|Sales to(by VVD)|Purchase from(by VVD)|Purchase from(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|slt_prc_capa|co_bfr_sub_capa";
	                 var HeadTitle1="";
	                 if(document.form.pBsa_op_jb_cd.value == "007"){
	                	 HeadTitle1="STS|Carrier|SPC(Teu)|WGT|SPC(Teu)|WGT|Lane|VVD|SPC(Teu)|SPC(Teu)|WGT|slt_prc_capa|co_bfr_sub_capa";
	                 } else {
	                	 HeadTitle1="STS|Carrier|SPC(BOX)|WGT|SPC(BOX)|WGT|Lane|VVD|SPC(BOX)|SPC(BOX)|WGT|slt_prc_capa|co_bfr_sub_capa";
	                 }
	                 var slt_swap_teu="IF(|slt_swap_teu_capa|>0, |slt_swap_teu_capa|*|slt_prc_capa|, |slt_swap_teu_capa|*|co_bfr_sub_capa|)";
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
	                 InitHeaders(headers, info);
	                 var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sls_teu_capa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sls_wgt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pur_teu_capa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pur_wgt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slt_swap_rlane_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slt_swap_vvd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"slt_swap_teu_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"slt_swap_amt",       KeyField:0,   CalcLogic:slt_swap_teu,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"slt_swap_wgt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:10,   Align:"Right",   ColMerge:1,   SaveName:"slt_prc_capa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:10,   Align:"Right",   ColMerge:1,   SaveName:"co_bfr_sub_capa",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 if(document.form.pBsa_op_jb_cd.value == "007"){
		                 SetColHidden("sls_wgt",0);
		                 SetColHidden("pur_wgt",0);
		                 SetColHidden("slt_swap_wgt",0);
	                 } else {
		                 SetColHidden("sls_wgt",1);
		                 SetColHidden("pur_wgt",1);
		                 SetColHidden("slt_swap_wgt",1);
	                 }
	         
	                 InitColumns(cols);
	                 SetEditable(1);//Editkind[option,Defaultfalse]
	                 //SetRangeBackColor(1, 2, 1, 10,"#DEFBF8");
	                 //SetRangeBackColor(0, 2, 0, 3,"#BBBCE6");
	                 //SetRangeBackColor(0, 6, 0, 10,"#BBBCE6");
//	                 SetSheetHeight(300);
	                 resizeSheet();
	                 
	                 SetEditArrowBehavior(3); 
	                 
	                 }
                    break;
            }
        }
        /**
         * handling the process realated with sheet
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
                case IBSEARCH:      //Retrieve
                    if(!validateForm(sheetObj,formObj,sAction))return false;
                    //ComOpenWait(true);
                    formObj.f_cmd.value=SEARCHLIST02;
                    sheetObj.DoSearch("ESM_BSA_0121GS.do", bsaFormString(formObj,getParam2('ESM_BSA_0121')) );
                    //ComOpenWait(false);
                    break;
                case IBSAVE:       //save
                    if(!validateForm(sheetObj,formObj,sAction))return false;
                    saveStatus=true;
                    formObj.f_cmd.value=MULTI02;
                    formObj.chgValueRowNo.value=sheetObj.FindStatusRow("I|U");
                    openerChange(sheetObj, formObj);
                    sheetObj.DoSave("ESM_BSA_0121GS.do", bsaFormString(formObj,getParam2('ESM_BSA_0121','S')), -1, true);	//SJH.20150210.MOD
                    break;
            }
        }
        function sheet_OnSaveEnd(sheetObj, ErrMsg){
        }
        function sheet_OnSearchEnd(sheetObj,ErrMsg) {
        	sheetObj.SetSumText(0,0,"" );
        	sheetObj.SetSumText(0,"crr_cd","TOTAL" );
        }
        /**
         * setting changed data in parent window
         */
        function openerChange(sheetObj, formObj){
            var sRow=formObj.sRow.value;
            var chgRow=formObj.chgValueRowNo.value;
            var arrRow=chgRow.split(";");
            var j=0;
            var sls_teu=0;
            var pur_teu=0;
            var slt_teu=0;
            for(j=0; j<arrRow.length; j++){
                sls_teu=0;
                pur_teu=0;
                slt_teu=0;
//                if(sheetObj.CellSearchValue(arrRow[j], "sls_teu_capa") != sheetObj.CellValue(arrRow[j],"sls_teu_capa")) sls_teu = sheetObj.CellValue(arrRow[j],"sls_teu_capa");
//                if(sheetObj.CellSearchValue(arrRow[j], "pur_teu_capa") != sheetObj.CellValue(arrRow[j],"pur_teu_capa")) pur_teu = sheetObj.CellValue(arrRow[j],"pur_teu_capa");
//                if(sheetObj.CellSearchValue(arrRow[j], "slt_swap_teu_capa") != sheetObj.CellValue(arrRow[j],"slt_swap_teu_capa")) slt_teu = sheetObj.CellValue(arrRow[j],"slt_swap_teu_capa");
                sls_teu=sheetObj.GetCellValue(arrRow[j],"sls_teu_capa");
                pur_teu=sheetObj.GetCellValue(arrRow[j],"pur_teu_capa");
				slt_teu=sheetObj.GetCellValue(arrRow[j],"slt_swap_teu_capa");
				opener.changeRow(sRow, sheetObj.GetCellValue(arrRow[j],"crr_cd"),  sls_teu, pur_teu,  slt_teu);
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            }
            return true;
        }
        
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
        }

