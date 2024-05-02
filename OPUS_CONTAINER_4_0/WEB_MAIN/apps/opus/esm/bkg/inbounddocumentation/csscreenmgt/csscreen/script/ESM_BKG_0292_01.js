/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_01.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    var previewSheet = 1;
    document.onclick = processButtonClick;

    /**
     * Event handler processing by button name<br>
     * @param {void}
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function processButtonClick(){
        var param=null;
        var sc_no=null;
        var cntr_no=null;
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            //disabled -> return
            if(!ComIsBtnEnable(srcName)){
                return;
            }
            switch(srcName) {
                case "btn_Cop":
                	if (sheetObjects[0].RowCount()== 0) return;
                	cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "t2sheet1_cntr_no");
                	param="?mainPage=false&pgmNo=ESD_SCE_0001&cntr_no="+cntr_no;
                	ComOpenWindowCenter("ESD_SCE_0001_POP.do"+param, "myWin", 1024, 650, false);
                	break;
                case "btn_Movement":
                	if (sheetObjects[0].RowCount()== 0) return;
                	cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "t2sheet1_cntr_no").substring(0,10);
                	var check=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "t2sheet1_cntr_no").substring(10);
                	var tpsz_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "t2sheet1_tpsz_cd");
                	var fromDate="";
                	var toDate=ComGetNowInfo();
                	if (sheetObjects[1].RowCount()> 0) {
                   		fromDate=ComGetMaskedValue(sheetObjects[1].GetCellValue(sheetObjects[1].RowCount(), "t2sheet2_event_dt").substring(0,8), "ymd");
                	} else {
                		fromDate=toDate ;
                	}
                  	param="?p_cntrno=" + cntr_no + "&" + "check_digit=" + check + "&" + "ctnr_tpsz_cd=" + tpsz_cd + "&pgmNo=EES_CTM_0408&pop_mode=1";
                	ComOpenWindowCenter("EES_CTM_0408_POP.do" + param, "EES_CTM_0408", 1020, 690, false);
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
     * registering IBSheet Object as list<br>
     * @param sheet_obj IBSheet Object
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet<br>
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     * @param {void}
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	if (sheetObjects[i].id == "t2sheet3") {
                initSheet(sheetObjects[i],i+1);
        	} else {
            	ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
        	}
        }
        resizeIfSheet();
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }        
    }
    /**
     * setting sheet initial values and header<br>
     * @param sheetObj IBSheet Object
     * @param sheetNo  The order of IBSheet
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var prefix="";
        var sheetID=sheetObj.id;
        switch(sheetID) {        
            case "t2sheet1":      //t2sheet1 init
            	with(sheetObj){
	                var HeadTitle="|Seq.|Container No.|Size|Last Event(VVD)|Date|Place(Node Code)|ACT NM";
	                var prefix="t2sheet1_";
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",    Wrap:1 },
				                {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",       Wrap:1 },
				                {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:prefix+"lst_event", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"event_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:prefix+"nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(160);
	            }
	            break;
            case "t2sheet2":      //t2sheet2 init
            	with(sheetObj){
	                var HeadTitle="||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	                var prefix="t2sheet2_";
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"event_dt", KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:190,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",   KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fcus_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                InitColumns(cols);
	                SetEditable(1);
//	                SetSheetHeight(270);
	                resizeIfSheet();
	            }
	            break;
            case "t2sheet3":      //t2sheet3 init
            	with(sheetObj){
	                var HeadTitle="||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	                var prefix="t2sheet3_";
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"event_dt", KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",   KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fcus_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                InitColumns(cols);
	                SetEditable(1);
	                SetVisible(0);
	            }
	            break;
        }
    }
//    function resizeSheet(){        
//        ComResizeSheet(sheetObjects[2]);//최하단시트 t2sheet3 -> sheetObjects[2].id    	
//    }
    /**
     * Sheet handling process<br>
     * @param sheetObj IBSheet Object
     * @param formObj  UI  Object
     * @param sAction  IBSEARCH , COMMAND01, COMMAND02, COMMAND04
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //Retrieve
            	ComOpenWait(true);
            	sheetObjects[0].SetWaitImageVisible(0);
            	formObj.f_cmd.value=SEARCH;
                var aryPrefix=new Array("t2sheet1_", "t2sheet3_"); //prefix string array
                 var sXml=sheetObj.GetSearchData("ESM_BKG_0292_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                sheetObjects[0].SetWaitImageVisible(0);
                sheetObjects[0].LoadSearchData(arrXml[0]);
                sheetObjects[2].SetWaitImageVisible(0);
                sheetObjects[2].LoadSearchData(arrXml[1]);
	            break;
        }
    }
    /**
     * t2Upon completion of sheet1 to set the value to lookup.
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg  Error Messages
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function t2sheet3_OnSearchEnd(sheetObj, ErrMsg){
        var cntrNo=null;
        var emptyXml="<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
            	cntrNo=sheetObjects[0].GetCellValue(1, "t2sheet1_cntr_no");
                if (sheetObjects[2].RowCount()> 0) {
                    copyMovementDetail(cntrNo);
                } else {                    
                	sheetObjects[1].LoadSearchData(emptyXml);
                }
            } else {
            	sheetObjects[1].LoadSearchData(emptyXml);
            }
        }
    }
     /**
      * t2sheet1 double-click event
      * @param Object  sheetObj IBSheet Object
      * @param Integer row      Row location
      * @param Integer col      Col location
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t2sheet1_OnDblClick(sheetObj, row, col){
        if (sheetObj.RowCount()> 0) {
        	var cntrNo=sheetObj.GetCellValue(row, "t2sheet1_cntr_no");
            copyMovementDetail(cntrNo);         
        }
    }
    /**
     * T2sheet3 by comparing   Container_No, go to t2sheet2
     * @param String  cntrNo Container No.
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function copyMovementDetail(cntrNo) {
        sheetObjects[1].RemoveAll(); // all row delete , Container_No match input
        var prefix7="t2sheet2_";
        var prefix8="t2sheet3_";
        var row7=0;
        var fcusRow=0;
        for(i=0;i<sheetObjects[2].RowCount();i++){
        	if (sheetObjects[2].GetCellValue(i+1,prefix8+ "cntr_no") == cntrNo) {
                row7=sheetObjects[1].DataInsert(-1);
                sheetObjects[1].SetCellValue(row7,prefix7+ "sts_nm",sheetObjects[2].GetCellValue(i+1,prefix8+ "sts_nm"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "event_dt",sheetObjects[2].GetCellValue(i+1,prefix8+ "event_dt"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "act_nm",sheetObjects[2].GetCellValue(i+1,prefix8+ "act_nm"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "loc_cd",sheetObjects[2].GetCellValue(i+1,prefix8+ "loc_cd"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "vvd",sheetObjects[2].GetCellValue(i+1,prefix8+ "vvd"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "seal_no",sheetObjects[2].GetCellValue(i+1,prefix8+ "seal_no"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "msg",sheetObjects[2].GetCellValue(i+1,prefix8+ "msg"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "bl_no",sheetObjects[2].GetCellValue(i+1,prefix8+ "bl_no"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "upd_dt",sheetObjects[2].GetCellValue(i+1,prefix8+ "upd_dt"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "cntr_no",sheetObjects[2].GetCellValue(i+1,prefix8+ "cntr_no"),0);
                sheetObjects[1].SetCellValue(row7,prefix7+ "fcus_flg",sheetObjects[2].GetCellValue(i+1,prefix8+ "fcus_flg"),0);
                if (sheetObjects[2].GetCellValue(i+1,prefix8+ "fcus_flg") == "Y") {
                	fcusRow=row7;
                }
                if (sheetObjects[2].GetCellValue(i+1,prefix8+ "sts_nm") != "Actual") {
                    sheetObjects[1].SetRowBackColor(row7,"#66CC00");
                }
            }
        }
        sheetObjects[1].SetSelectRow(fcusRow);
    }
    /**
     * t2Upon completion of sheet1 to set the value to lookup.
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg  Error Messages
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	ComOpenWait(false);
    	if (ErrMsg != "") {
            fnMovementClear();
        }
        if (sheetObj.RowCount()> 0) {
        	buttonColorSet("btn_Cop", 'red');
        	buttonColorSet("btn_Movement", 'red');
      	} else {
        	buttonColorSet("btn_Cop", 'gray');
        	buttonColorSet("btn_Movement", 'gray');
        }
    }
    /**
     * Clear the value of move
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnMovementClear() {
    	for (i=0; i<sheetObjects.length; i++) sheetObjects[i].RemoveAll();
    }
    /**
     * Query processing module integrated management
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSearch() {
    	fnMovementClear();
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
    }
    /**
     * Button disabled
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function buttonColorSet(btn_name, color){
    	var btn= ComGetObject(btn_name);
        if (color == 'red') {
        	ComEnableObject(btn, 1)
        } else {
        	ComEnableObject(btn, 0)
        }
       	if (btn_name == "btn_split") {
       	    document.form.h_split.value=color;
       	}
       	btn.style.color = color;
    }

    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
    		document.form.bkg_no.value=bkg_no;
    		fnSearch();
        }     	
    }

    function resizeIfSheet(){
        ComResizeSheet(sheetObjects[1]);
   } 