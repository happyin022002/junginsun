/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1020.js
*@FileTitle  : Group Arrival Notice Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================**/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// Common global variable
	
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	var isSaveable=false;
	var isDeleteable=false;
	
	document.onclick=processButtonClick;
	
	/**
	 * Event handler processing by button name<br>
	 */
	function processButtonClick()
	{
	    var sheetObject1=sheetObjects[0];
	    var formObj=document.form;	
        var srcName=ComGetEvent("name");
        switch(srcName)
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObj,IBSEARCH);
            break;
            case "btn_Close":
            	ComClosePopup(); 
            break;
            case "btn_Save":
                if(!isSaveable)
                {
                    ComShowCodeMessage("BKG00448");
                    return;
                }
                doActionIBSheet(sheetObject1,formObj,MULTI);
            break;
            case "btn_Delete":
                doActionIBSheet(sheetObject1,formObj,REMOVE);
            break;
        }
	}
	/**
	 * registering IBSheet Object as list<br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source<br>
	 */
	function setSheetObject(sheet_obj)
	{
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage()
	{
	    for(i=0;i<sheetObjects.length;i++)
	    {
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    axon_event.addListenerFormat("keypress","obj_keypress", form);
	    axon_event.addListener("keydown","obj_keydown1", "ofc_cd");
	    axon_event.addListener("keydown","obj_keydown2", "impt_ntc_rmk");
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
	 * handling process for input validation<br>
	 */
	function validateForm(sheetObj,formObj,sAction)
	{
	    var len=formObj.ofc_cd.value.length;
	    switch(sAction)
	    {
	    case MULTI:
	        if(len < 5 || len > 6)
	        {
	            //"Input Issue OFC !"
	            ComShowCodeMessage("BKG00604");
	            return false;
	        }
	        break;
	    case REMOVE:
	        if(!isDeleteable)
	        {
	            ComShowCodeMessage("BKG03054");
	            return false;
	        }
	        if(len < 5 || len > 6)
	        {
	            //"Input Issue OFC !"
	            ComShowCodeMessage("BKG00604");
	            return false;
	        }
	        break;
	    case IBSEARCH:
	        if(len < 5 || len > 6)
	        {
	            //"Input Issue OFC !"
	            ComShowCodeMessage("BKG00604");
	            return false;
	        }
	        break;
	    }
	    return true;
	}
	/**
	 * setting sheet initial values and header<br>
	 */
	function initSheet(sheetObj,sheetNo)
	{
	    var cnt=0;
	    switch(sheetNo)
	    {
	        case 1:      //sheet1 init
	        	  with(sheetObj){		           
			           //no support[check again]CLT 	                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			           var HeadTitle="|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
			           var prefix="sheet1_";
		
			           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			           var headers = [ { Text:HeadTitle, Align:"Center"} ];
			           InitHeaders(headers, info);
		
			           var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
			                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"addr_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"impt_ntc_rmk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"an_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			            
			           InitColumns(cols);
		
			           SetEditable(1);
			           SetCountPosition(0);
			           SetSheetHeight(100,1);
			           
	              }
	        break;
	    }
	}
	/**
	 * handling process for Sheet<br>
	 */
	function doActionIBSheet(sheetObj,formObj,sAction){
	    //sheetObj.ShowDebugMsg = false;
	    var status='';	
	    switch(sAction)
	    {
	        case IBSEARCH:      //retrieve
	            formObj.f_cmd.value=SEARCH;
	            validateForm(sheetObj,formObj,sAction)
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            //ComOpenWait(true);
	            sheetObj.DoSearch("ESM_BKG_1020GS.do", FormQueryString(formObj ) + "&" + ComGetPrefixParam("sheet1_"));
	            break;
	        case REMOVE:
	            formObj.f_cmd.value=REMOVE;
	            if(!validateForm(sheetObj,formObj,sAction)) return;
					formObj.addr_ctnt.value="";
					formObj.impt_ntc_rmk.value="";
					formObj.an_seq.value="";
					sheetObj.SetRowStatus(1,"D");
	                sheetObj.DoSave("ESM_BKG_1020GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	            break;
	        case MULTI:
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            formObj.f_cmd.value=MULTI;	
				if(sheetObj.RowCount()< 1){
					sheetObj.DataInsert();
				}	
				sheetObj.SetCellValue( 1,"sheet1_" + "addr_ctnt",formObj.addr_ctnt.value);
				sheetObj.SetCellValue( 1,"sheet1_" + "impt_ntc_rmk",formObj.impt_ntc_rmk.value);
				sheetObj.SetCellValue( 1,"sheet1_" + "an_seq",formObj.an_seq.value);
	            sheetObj.SetRowStatus(1,"U");
	            sheetObj.DoSave("ESM_BKG_1020GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
	            break;
	    }
	}
	/**
	 * Keyboard Event<br>
	 */
	function obj_keypress()
	{
	    switch(event.srcElement.dataformat)
	    {
	        case "int": 
	            ComKeyOnlyNumber(event.srcElement); break;
	        case "float":
	            ComKeyOnlyNumber(event.srcElement, "."); break;
	        case "eng": 
	            ComKeyOnlyAlphabet(); break;
	        case "engup": 
	            ComKeyOnlyAlphabet('upper'); break;
	        default: 
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
	/**
	 * Key Down Event<br>
	 */
	function obj_keydown1()
	{
	    var key=event.keyCode;
	    if(key == 13)
	    {
	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    }
	}
	/**
	 * Key Down Event 2<br>
	 */
	function obj_keydown2()
	{
	    fncTextareaMaxLine(document.form.impt_ntc_rmk, 10);
	}
	/**
	 * Checking the Max line of text Area
	 */
	function fncTextareaMaxLine(obj, maxLine)
	{
	    var str_len=obj.value;
	    line=str_len.split("\r\n");
	    ln=line.length;
	    if(ln == maxLine && event.keyCode == 13)
	    {
	        event.returnValue=false;
	    }
	}
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		var formObj=document.form;
		if(sheetObj.RowCount()> 0){
			isDeleteable=true;
	        isSaveable=true;
			formObj.addr_ctnt.value=sheetObj.GetCellValue( 1,"sheet1_" + "addr_ctnt");
			formObj.impt_ntc_rmk.value=sheetObj.GetCellValue( 1,"sheet1_" + "impt_ntc_rmk");
			formObj.an_seq.value=sheetObj.GetCellValue( 1,"sheet1_" + "an_seq");
		}else{
			ComOpenWait(false);
			isDeleteable=false;
			isSaveable=true;
			formObj.addr_ctnt.value="";
			formObj.impt_ntc_rmk.value="";
			formObj.an_seq.value="";
		}
	}
	function sheet1_OnSaveEnd(sheetObj, errMsg){
	    ComOpenWait(false);
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
	    if(errMsg != ""){
		}else{
			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
		}
	}
