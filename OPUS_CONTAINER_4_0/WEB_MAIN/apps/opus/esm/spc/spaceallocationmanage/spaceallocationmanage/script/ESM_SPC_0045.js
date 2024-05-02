/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0045.js
*@FileTitle  : Bottleneck Check  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_SPC_0045 : business script for ESM_SPC_0045
     */
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=0;
    var ret_vvd;
    var ret_minvvd;
    var ret_maxvvd;
    var minArr=new Array();
    var maxArr=new Array();
    var ret_check=false;
    var sheetResizeCount=2;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
    	/***** setting additional sheet value in case of more 2 sheet per tab *****/
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
//       			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
       				sheetObjects[0].RemoveAll();
       				sheetObjects[1].RemoveAll();
       				
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_new":
    				if(checkModifiedSheet(sheetObject)) {
    					if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    						return;
    					}
    				}
    				//using common funtion : initializing the screen
    				//resetAll();
//    				formObject.reset();
    				resetAll();

//    				sheetObject1.RemoveAll();
//					sheetObject.RemoveAll();
					// 2014.12.23 NEW 버튼 undefined 관련 수정
					formObject.vvd.value="";

    				break;
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				break;
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
    		} else {
    			ComShowMessage(e);
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setComboObject(combo_obj){
    	comObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	optionSetting();
    	var tdisp="block";
    	var objs=document.all.tabLayer;
    	
    	for(var i=0;i<sheetObjects.length;i++){
    		// change the name of start environment setting funtion
    		ComConfigSheet(sheetObjects[i]);
    		objs[i].style.display="Inline";
//    		if(i > 0){
//    			tdisp=tabLayer[i-1].style.display;
//    			tabLayer[i-1].style.display="block";
//    		}
    		initSheet(sheetObjects[i],i+1);
    		objs[i].style.display="none";
//    		if(i > 0){
//    			tabLayer[i-1].style.display=tdisp;
//    		}
    		// Adding last environment setting funtion
    		ComEndConfigSheet(sheetObjects[i]);
    	}
//    	var sheetResizeFull=true;
//    	document_onresize();
    	resizeSheet();
    	for(var k=0;k<tabObjects.length;k++){
    		initTab(tabObjects[k],k+1);
    		 tabObjects[k].SetSelectedIndex(0);
    	}
    	// Setting it related with tab
    	if(document.getElementById("lane").SetEnable== 0) document.getElementById("lane").tabIndex(1);
    	// Setting focus
    	document.form.year1.focus();
    	/*
    	if(!isDevMode){
    	}
    	*/
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
		    	      SetFocusEditMode(default_edit_mode);
		    	      var HeadTitle1="Port|BSA|IOC|Load|Discharge|Onboard|Loadable";
//		    	      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, DataColMerge:0} );
                      SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:100 } );
		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		    	      var cols = [ 
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"port",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bsa",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ioc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"lod_cur_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"dis_teu_cur_qty",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"teu_onboard",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"loadable",         KeyField:0,   CalcLogic:"|bsa|-|teu_onboard|",Format:"",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
//		    	             {Type:"Text",      Hidden:1,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"src_knd",     TreeCol:1,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:1,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"src_knd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:1,    Align:"Left",    ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(0);
		    	      SetHeaderRowHeight(20);
		    	      SetSheetHeight(ComGetSheetHeight(sheetObj, 16));
		    	      //InitTreeInfo("src_knd", "sLevel", "#0000FFNAN");
    			}
    		    break;
    		case 2:      //sheet1 init
    		    with(sheetObj){
		    	      SetFocusEditMode(default_edit_mode);
		    	      var HeadTitle1="Port|BSA|IOC|Load|Discharge|Onboard|Loadable";
		    	      SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:100 } );
		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		    	      var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"port",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bsa",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ioc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"lod_cur_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"dis_teu_cur_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"teu_onboard",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"loadable",         KeyField:0,   CalcLogic:"|bsa|-|teu_onboard|",Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:1,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"src_knd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:1,    Align:"Left",    ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(0);
		    	      SetHeaderRowHeight(20);
		    	      SetSheetHeight(ComGetSheetHeight(sheetObj, 16));
		    	      //InitTreeInfo("src_knd", "sLevel", "#0000FFNAN");
		    		}
    			break;
    	}
    }
   // Handling the process related with sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //Retrieve
    			if(checkModifiedSheet(sheetObj)) {
    				if(ComShowConfirm (getMsg("SPC90001")) != 1){
    					return;
    				}
    			}
    			if(!validateForm1(sheetObj,formObj, sAction)){
    				return false;
    			}
    			var sheetObj=sheetObjects[0];
    			var sheetObj1=sheetObjects[1];
    			formObj.f_cmd.value=SEARCHLIST02;
    			ret_check=true;
    			var param=SpcFormString(formObj,"f_cmd,lane,vvd");
    			var datas=sheetObjects[beforetab].GetSearchData("ESM_SPC_0045GS.do", param);
    			var xmls=datas.split("[+]");
    			for(var i=0 ; i < xmls.length ; i++) {
    				sheetObjects[i].LoadSearchData(xmls[i],{Sync:1} );
    			}
    			var val="";
    			for(var i=0;i<formObj.dataSelect.length;i++) {
    				if(formObj.dataSelect[i].checked) {
    					if(i==0)val="F";
    					else if(i==1) val="B";
    					else if(i==2) val="A";
    					else if(i==3) val="M";
    				}
    			}
    			changeSelecteData(sheetObj, val);
    			for(var j=0;j<formObj.dataSelect1.length;j++) {
    				if(formObj.dataSelect1[j].checked) {
    					if(j==0)val="F";
    					else if(j==1) val="B";
    					else if(j==2) val="A";
    					else if(j==3) val="M";
    				}
    			}
    			changeSelecteData1(sheetObj1, val);
    			break;
    		case IBDOWNEXCEL:        //Excel download
    			var sheetObj=sheetObjects[0];
				var sheetObj1=sheetObjects[1];
    			if(beforetab == 0){
	    				if(sheetObj.RowCount() < 1){//no data
	    					ComShowCodeMessage("COM132501");
	    				}else{
	    					sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9, DownRows:'Visible'});
	    				}    				
    			}else if(beforetab == 1){
    				if(sheetObj1.RowCount() < 1){//no data
    					ComShowCodeMessage("COM132501");
    				}else{
    					sheetObj1.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj1), SheetDesign:1, Merge:1, ExcelFontSize:9, DownRows:'Visible' });
    				}   
    				
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
    *Tab Basic setting
     *Setting items of tab
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    		case 1:
    			with (tabObj) {
    				var cnt=0 ;
					InsertItem( "By Teu"     , "");
					InsertItem( "By Weight " , "");
    			}
    			break;
    	}
    }
    /**
     *the event in case of clicking Tab
    * Activating the element of selected tab
     */
    function tab1_OnChange(tabObj , nItem) {
    	var objs=document.all.item("tabLayer");
    	for(var i=0 ; i < objs.length ; i++) {
    		objs[i].style.display="none";
    	}
    	objs[nItem].style.display="Inline";
    	beforetab=nItem;
    	resizeSheet();
    }
    function getEtcDataFromXml(xml, str){
    	var pos=xml.indexOf("ETC KEY=\""+str+"\"");
    	if(pos < 0) return "";
    	pos=xml.indexOf(">", pos + 1);
    	if(pos < 0) return "";
    	var epos=xml.indexOf("</ETC>", pos + 1);
    	var rtn="";
    	if(epos < 0){
    		rtn=xml.substring(pos + 1);
    	} else {
    		rtn=xml.substring(pos + 1, epos);
    	}
//    	log("rtn : " + rtn);
    	return rtn;
    }
    // Setting VVD in case of changing lane
    function lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	getVVD("");
    }
    /*
     * Setting VVD
     */
    function getVVD(vvd){
    	var rtn;
    	var ret_vvd;
    	var ret_minvvd;
    	var ret_maxvvd;
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var year1=formObj.year1.value;
    	var week1=formObj.year1.value;
    	var varLane=lane.GetSelectText();
    	var bound=formObj.bound.value;
    	formObj.f_cmd.value=SEARCHLIST01;
    	formObj.re_vvd.value="";
    	for(var i=0; i<formObj.vvd.length; i++){
    		formObj.vvd.options[i]=new Option("", "");
    	}
    	if(year1 != "" && week1 != "" && varLane != "" && bound != ""){
    		var param=SpcFormString(formObj,"f_cmd,year1,week1,lane,bound");
    		rtn=sheetObj.GetSearchData("ESM_SPC_0045GS.do", param);
    		ret_vvd=getEtcDataFromXml(rtn, "vvd");
    		ret_relvvd=getEtcDataFromXml(rtn, "relvvd");
    		setVVD(formObj, sheetObj, ret_vvd, ret_relvvd, vvd);
    	}
    }
    function changeVVD(){
    	var formObj=document.form;
    	var vvd_index=formObj.vvd.options.selectedIndex;
    	var vvd=formObj.vvd.options[vvd_index].relVVD;
    	if(vvd != undefined){
    		formObj.re_vvd.value=vvd;
    	}
    }
    /*
     * vvd, relation vvd setting
     */
    function setVVD(formObj, sheetObj, strVvd, strRelvvd){
    	var vvdArr=strVvd.split("|");
    	var relArr=strRelvvd.split("|");
    	var vvd_index=formObj.vvd.options.selectedIndex;
    	for (var i=0; i < formObj.vvd.length; i++){
    		formObj.vvd.remove(i);
    	}
    	for(var j=0; j< vvdArr.length; j++){
    		formObj.vvd.options[j]=new Option(vvdArr[j], vvdArr[j]);
    		formObj.vvd.options[j].relVVD=relArr[j];
    	}
    	formObj.re_vvd.value=relArr[0];
    	
    }
    function sheet1_OnSearchEnd(sheetObj , code, ErrMsg){
    	if(ErrMsg == ""){
    		for(var i=1 ; i < sheetObjects.length ; i++){
    			sheetObjects[i].RemoveAll();
    		}
    	}
    }
    /*
     * Checking  fcast,bkg,allocation row are shown or not in case of selecting check box
     */
    function changeTitle2(){
    	var sheetObj=sheetObjects[0];
    	var val=ComGetEvent("value");
    	changeSelecteData(sheetObj, val);
    }
    function changeSelecteData(sheetObj, val){
    	sheet1.RenderSheet(0);
    	var formObj=document.form;
    	var sel=formObj.dataSelect;
    	var frow=-1;
    	var show= 1;
    	var count = sheetObj.RowCount();
    	for(var i=1 ; i <= count ; i++){
    		if(val != "" && val != sheetObj.GetCellValue(i, "src_knd")){
    			show = 1;
    		}else{
    			show = 0;
    		}
//    		frow=sheetObj.FindText("src_knd", sel[i].value);
//    		show= sel[i].checked;
    		sheetObj.SetRowHidden(i,show);
//    		sheetObj.SetRowExpanded(frow,show);
    	}
    	sheet1.RenderSheet(1);
    }
    function changeTitle1(){
    	var sheetObj1=sheetObjects[1];
    	var val=ComGetEvent("value");
    	changeSelecteData1(sheetObj1, val);
    }
    function changeSelecteData1(sheetObj1, val){
    	sheet2.RenderSheet(0);
    	var formObj=document.form;
    	var sel=formObj.dataSelect1;
    	var frow=-1;
    	var show= 1;
    	var count = sheetObj1.RowCount();
    	for(var i=1 ; i <= count ; i++){
    		if(val != "" && val != sheetObj1.GetCellValue(i, "src_knd")){
    			show = 1;
    		}else{
    			show = 0;
    		}
//    		frow=sheetObj.FindText("src_knd", sel[i].value);
//    		show= sel[i].checked;
    		sheetObj1.SetRowHidden(i,show);
//    		sheetObj.SetRowExpanded(frow,show);
    	}
    	sheet2.RenderSheet(1);
    }
    /**
     * handling process for input validation
     */
    function validateForm1(sheetObj,formObj){
    	with(formObj){
    		var lane_value=comObjects[0].GetSelectCode();
    		var bound_value=bound.value;
    		var re_vvd_value=re_vvd.value;
    		var vvd_value=vvd.value;
    		if(lane_value == ""){
    			ComShowMessage(getMsg("SPC90114", "Lane"));
    			comObjects[0].SetSelectCode("");
    			//forcing to apply it  in case of not focusing on lane combo
//    			formObj.year1.focus();
    			comObjects[0].Focus();
    			return false;
    		}
    		if(bound_value == ""){
    			ComShowMessage(getMsg("SPC90114", "Bound"));
//    			formObj.bound.focus();
    			return false;
    		}
    		if(vvd_value == ""){
    			ComShowCodeMessage("COM12174", "VVD", "9");
//    			formObj.vvd.focus();
    			return false;
    		}
    		//if(re_vvd==""){
    		//	ComShowMessage(getMsg("SPC90114","Relation VVD"));
    		//	formObj.re_vvd.focus();
    		//	return false;
    		//}
    	}
    	return true;
    }
    function initDataValue_lane(){
    	var sheetObj=document.getElementById("lane");
    	with(sheetObj){
    		Index2=0;
    	}
    }
    function optionSetting() {
    	SpcSearchOptionYear("year1");
    	SpcSearchOptionWeek("week1");
    	SpcSearchOptionLane("lane");
    	SpcSearchOptionBound("bound");
    }
    
	function resizeSheet(){
        for(var i=0;i<sheetObjects.length;i++){
            ComResizeSheet(sheetObjects[i]);
        }    		
	}