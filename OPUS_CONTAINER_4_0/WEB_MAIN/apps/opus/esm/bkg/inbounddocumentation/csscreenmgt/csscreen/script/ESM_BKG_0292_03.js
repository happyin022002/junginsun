/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_03.js
*@FileTitle  : C/S Screen_S/O Info
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
     /**
      * registering IBSheet Object as list<br>
      * @param sheet_obj IBSheet Object
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
     /**
      * initializing sheet<br>
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen
      * @param {void}
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	if (sheetObjects[i].id == "t4sheet4") {
                initSheet(sheetObjects[i],i+1);
        	} else {
            	ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);        		
        	}
        }
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }   
        resizeIfSheet();
    }
         
     /**
      * setting sheet initial values and header<br>
      * @param sheetObj IBSheet Object
      * @param sheetNo
      **/
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var prefix = "";
        var sheetID = sheetObj.id;
        switch(sheetID) {        
            case "t4sheet1":      //t4sheet1 init
            	with(sheetObj){
	            	var HeadTitle="|Seq.|Container No.|TP/SZ|Bound|S/O\nRequire|S/O\nIssued|POD|DEL|Delivery\nTerm|Last S/O Status";
	            	var prefix="t4sheet1_";
	            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				            	{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
				            	{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"req_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"iss_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				            	{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetSheetHeight(100,1);
            	}
                break;                    
            case "t4sheet2":      //t4sheet2 init
            	with(sheetObj){
	            	var HeadTitle="|TP/SZ|CNTR Q'ty|Hidden\nColumn";
	            	prefix="t4sheet2_";
	            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				            	{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				            	{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
				            	{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hidden",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 } ];
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetSheetHeight(100,1);
            	}
                break;
            case "t4sheet3":      //t4sheet3 init
            	with(sheetObj){
	            	var HeadTitle="|Seq.|S/P Code|S/P Name|S/P Tel No|Cost Mode|From-To|S/O Status|Office|User ID|S/O No|S/O Date|W/O No|W/O Date|Container No.";
	            	var prefix="t4sheet3_";
	            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:8, DataRowMerge:1 } );
	            	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",    Wrap:1 },
			            	     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq",       Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_name",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_tel_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cost_mode", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"so_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"so_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			            	     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetSheetHeight(240);
            	}
                break;
                    
            case "t4sheet4":      //t4sheet4 init
            	with(sheetObj){
	            	var HeadTitle="|Seq.|S/P Code|S/P Name|S/P Tel No|Cost Mode|From-To|S/O Status|Office|User ID|S/O No|S/O Date|W/O No|W/O Date|Container No.|User Name";
	            	var prefix="t4sheet4_";
	            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				            	 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
				            	 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_name",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_tel_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cost_mode", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"so_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"so_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetVisible(0);
            	}
            break;
        }
    }

    /**
     * handling sheet process<br>
     * @param sheetObj IBSheet Object
     * @param formObj 
     * @param sAction
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:
            	sheetObjects[0].SetWaitImageVisible(0);
            	formObj.f_cmd.value=SEARCH;
                var aryPrefix=new Array("t4sheet1_", "t4sheet2_", "t4sheet4_"); //prefix string array
                 var sXml=sheetObj.GetSearchData("ESM_BKG_0292_03GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                sheetObjects[0].SetWaitImageVisible(0);
                sheetObjects[0].LoadSearchData(arrXml[0]);
                sheetObjects[1].SetWaitImageVisible(0);
                sheetObjects[1].LoadSearchData(arrXml[1]);
                sheetObjects[3].SetWaitImageVisible(0);
                sheetObjects[3].LoadSearchData(arrXml[2]);
                sheetObjects[0].SetWaitImageVisible(1);
                ComOpenWait(false);
                break;
        }
    }
     /**
      * setting value when complete retrieving of t4sheet4
      * set info t4sheet4 equivalent of Container of first row in t4sheet1 to t4sheet3 in case of exist value in t4sheet4.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg
      **/
    function t4sheet4_OnSearchEnd(sheetObj, ErrMsg){
    	var cntrNo=null;
    	var emptyXml="<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
        if (ErrMsg == "") {
        	if(sheetObj.RowCount()> 0){
        		cntrNo=sheetObjects[0].GetCellValue(1, "t4sheet1_cntr_no");
                 if (sheetObjects[3].RowCount()> 0) {
                     copySoInfoDetail(cntrNo);
                 } else {
                	 sheetObjects[2].LoadSearchData(emptyXml);
                 }
            } else {
            	sheetObjects[2].LoadSearchData(emptyXml);
            }
        }
    }
     /**
      * handler list of t4sheet1 double click event
      * @param Object  sheetObj IBSheet Object
      * @param Integer row
      * @param Integer col 
      **/
    function t4sheet1_OnDblClick(sheetObj, row, col){
        if (sheetObj.RowCount()> 0) {
        	var cntrNo=sheetObj.GetCellValue(row, "t4sheet1_cntr_no");
            copySoInfoDetail(cntrNo);            
        }
    }
    /**
     * Container No를 비교하여 t4sheet4의 값을 t4sheet3로 이동한다.
     * @param String  cntrNo Container No.
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function copySoInfoDetail(cntrNo) {
         sheetObjects[2].RemoveAll();
         var prefix1="t4sheet3_";
         var prefix2="t4sheet4_";
         var row=0;
            for(i=0;i<sheetObjects[3].RowCount();i++){
            	if (sheetObjects[3].GetCellValue(i+1,prefix2+ "cntr_no") == cntrNo) {
                 row=sheetObjects[2].DataInsert(-1);
				sheetObjects[2].SetCellValue(row,prefix1+ "sp_code",sheetObjects[3].GetCellValue(i+1,prefix2+ "sp_code"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "sp_name",sheetObjects[3].GetCellValue(i+1,prefix2+ "sp_name"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "sp_tel_no",sheetObjects[3].GetCellValue(i+1,prefix2+ "sp_tel_no"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "cost_mode",sheetObjects[3].GetCellValue(i+1,prefix2+ "cost_mode"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "nod_cd",sheetObjects[3].GetCellValue(i+1,prefix2+ "nod_cd"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "sts_cd",sheetObjects[3].GetCellValue(i+1,prefix2+ "sts_cd"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "ofc_cd",sheetObjects[3].GetCellValue(i+1,prefix2+ "ofc_cd"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "usr_id",sheetObjects[3].GetCellValue(i+1,prefix2+ "usr_id"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "so_no",sheetObjects[3].GetCellValue(i+1,prefix2+ "so_no"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "so_date",sheetObjects[3].GetCellValue(i+1,prefix2+ "so_date"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "wo_no",sheetObjects[3].GetCellValue(i+1,prefix2+ "wo_no"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "wo_date",sheetObjects[3].GetCellValue(i+1,prefix2+ "wo_date"),0);
				sheetObjects[2].SetCellValue(row,prefix1+ "cntr_no",sheetObjects[3].GetCellValue(i+1,prefix2+ "cntr_no"),0);
				sheetObjects[2].SetToolTipText(row,prefix1+ "usr_id",sheetObjects[3].GetCellValue(i+1, prefix2+ "usr_nm"));
             }
        }
    }
     /**
      * setting value when t4sheet2 retrieveing complete
      * @param Object sheetObj
      * @param Object ErrMsg
      **/
    function t4sheet2_OnSearchEnd(sheetObj, ErrMsg){
       cntrQtySum=0;
       if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
               for(var i=1; i<=sheetObj.RowCount(); i++) {
            	   if (isFloat(sheetObj.GetCellValue(i,"t4sheet2_cntr_qty")) == true) {
                        sheetObj.SetCellFontBold(i, "t4sheet2_cntr_qty",1);
                        sheetObj.SetCellFontColor(i, "t4sheet2_cntr_qty" ,"#FF0000");
                   }
               }
            }
       }
    }
     /**
      * handling button disable 
      **/
    function buttonColorSet(btn_name, color){
        var tds=document.getElementsByTagName("td");
        var curFlag=null;
        if (color == 'red') {
    	    curFlag="hand";
        } else {
    	    curFlag="default";
        }
        for(var i=0; i < tds.length; i++) {
            var td=tds[i];
            if(td.name == '•' + btn_name){
           	    td.style.color=color;
           	    td.style.cursor=curFlag;
           	if (btn_name == "btn_split") {
           	    document.form.h_split.value=color;
           	}
                break;
            }else if(td.name == btn_name){
           	    td.style.color=color;
           	    td.style.cursor=curFlag;
           	    if (btn_name == "btn_split") {
           		    document.form.h_split.value=color;
           	    }
                break;
            }else{
           	    continue;
            }
        }
    }
     /**
      * setting value after t4sheet1 retrieving
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	if (ErrMsg != "") {
        	fnSoInfoClear();
        }
    }
    /**
     * clear S/O Info
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSoInfoClear() {
    	for(i=0; i<sheetObjects.length; i++)  sheetObjects[i].RemoveAll();
    }
    /**
     * search module integration management  in screen
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSearch() {
    	fnSoInfoClear();
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
    }
    /**
     * checking Float of not 
     * @param  Object
     * @return Boolean
     **/
    function isFloat(fVal) {
    	var temp=0;
    	var sVal=null;
    	var sIdx=fVal.toString().indexOf(".");
    	if (sIdx > 0) {
	    	var sTemp=fVal.toString();
    		sVal=sTemp.substring(parseInt(sIdx) + 1);
	    	if (parseInt(sVal) > 0 ) {
	    		return true;
	    	} else {
	    		return false;
	    	}
    	} else {
    		return false;
    	}
    }
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {         	
      		document.form.bkg_no.value=bkg_no;
      		fnSearch();
        }     	
    }     
    

    function resizeIfSheet(){
        ComResizeSheet(sheetObjects[2]);
   }