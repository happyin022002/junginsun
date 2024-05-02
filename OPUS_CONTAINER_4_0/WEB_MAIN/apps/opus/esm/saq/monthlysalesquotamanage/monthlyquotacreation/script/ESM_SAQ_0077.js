/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0077.jsp
*@FileTitle  : Model Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends 
     * @class ESM_SAQ_0077 : business script for ESM_SAQ_0077
     */
 var sheetObjects=new Array();
 var sheetCnt=0;
 var tabObjects=new Array();
 var tabCnt=0 ;
 var currentTabIndex=0;
 var monthNames=new Array();
 var tabSearchParams=["-1", "", "", ""];
 var sheetParams=new Array("", "", "", "");
 var intervalID=null;
 var lastSeq=" ";
 var loadFlg = false;
//Event handler processing by button click event */
 document.onclick=processButtonClick;
//Event handler processing by button name */
 	function processButtonClick(){
 		 var sheetObject=sheetObjects[currentTabIndex];
 		 var formObject=document.form;
 		try {
 			var srcName=ComGetEvent("name");
 			if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
 				case "btn_basedatacreation" :
					doActionIBSheet(sheetObject,formObject,MODIFY01);					
					break;
 				case "btn_retrieve":
 					initTabText(tabObjects[0]);
 					tabSearchParams[currentTabIndex]="";
 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					break;
 				case "btn_saveasfinal":
 					doActionIBSheet(sheetObject,formObject,IBSAVE);
 					break;
 			} // end switch
 		}catch(e) {
 			if( e == "[object Error]") {
 				ComShowCodeMessage("COM12111");
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
 	function setTabObject(tab_obj){
 		tabObjects[tabCnt++]=tab_obj;
 	}
 	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
 	function loadPage() {
 		optionSetting();
 		monthSetting();
 		//search_onChange();
 		var objs=document.all.tabLayer;
 		
 		for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet(sheetObjects[i]);
 			objs[i].style.display="Inline";
 			initSheet(sheetObjects[i],i+1);
 			objs[i].style.display="none";
 			ComEndConfigSheet(sheetObjects[i]);
 		}
 		
 		resizeSheet();
 		
 		// tab Object init
 		for(k=0;k<tabObjects.length;k++){
 			initTab(tabObjects[k],k+1);
 		}
        
 		var formObj=document.form;
 		var sheetResizeFull=true;		
 		var sheetResizeCount=1;
        
        document.form.year.focus();
        tabObjects[0].SetSelectedIndex(0);
        
        setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
        
        // version setting
        search_onChange();
 	}
 	
    function monthSetting() {												
    	var rtn=getCodeList("CommonCode", "codeNo=CD01915");	//영문월 "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb"
 		var code=rtn[0].split("|");
 		for ( var i=0; i<code.length+1; i++ ) {
 			if ( i == 12 ) {
     			monthNames[i]=code[0];
 			} else if ( i == 13 ) {
     			monthNames[i]=code[1];
 			} else {
     			monthNames[i]=code[i];
 			}
 		}
    }
    /**
     * initializing Tab
     * setting Tab items
     */
 	function initTab(tabObj, tabNo) {
 		var cnt=0 ;
 		switch(tabNo) {					 
 			 case 1:
 				with (tabObj) {
					InsertItem( "           " , "");
					InsertItem( "           " , "");
					InsertItem( "           " , "");
 					tabSearchParams[currentTabIndex]="";
 					initTabText(tabObj);
 				}
 				break;
 		}
 	}
 	/**
     * initializing Tab
     * setting Tab items
     */
 	function initTabText(tabObj) {
 		var year=document.form.year.value;
 		var quarter=document.form.bse_qtr_cd.value;
 		var repMonth=eval(document.form.bse_qtr_cd.value.substring(0,1))*3-2;
 		var month=repMonth - 1;
 		sheetParams[0]="f_cmd="+SEARCHLIST01+"&year="+year+"&bse_qtr_cd="+quarter+"&repMonth="+repMonth;
 		tabObj.SetTabTitle(0," " + year + " " + monthNames[month++]  + " ");
 		repMonth++;
 		if (month == 12) { year=eval(year) + 1; }
 		sheetParams[1]="f_cmd="+SEARCHLIST02+"&year="+year+"&bse_qtr_cd="+quarter+"&repMonth="+repMonth;
 		tabObj.SetTabTitle(1," " + year + " " + monthNames[month++]  + " ");
 		repMonth++;
 		if (month == 12) { year=eval(year) + 1; }
 		sheetParams[2]="f_cmd="+SEARCHLIST03+"&year="+year+"&bse_qtr_cd="+quarter+"&repMonth="+repMonth;
 		tabObj.SetTabTitle(2," " + year + " " + monthNames[month++]  + " ");
 	}
 	
 	function getSheetParams() {
 		//var quarter=document.form.bse_qtr_cd.value;
 		var version=document.form.version.value;
 		//return sheetParams[currentTabIndex] +"&bse_qtr_cd="+quarter + "&version="+version;
 		return sheetParams[currentTabIndex] + "&version="+version;
 	}
 	/**
     * Event when clicking Tab
     * activating selected tab items
     */
 	function tab1_OnChange(tabObj , nItem)
 	{
 		initTabText(tabObj);
 		
 		currentTabIndex=nItem;
 		var objs=document.all.item("tabLayer");
 		for(i=0; i < objs.length; i++) {
 			objs[i].style.display="none";
 		}
 		objs[nItem].style.display="Inline";
 		
 		resizeSheet();
 		
 		if(loadFlg) {
 			doActionIBSheet(sheetObjects[currentTabIndex],document.form,IBSEARCH);
 		}
 		loadFlg = true;
 	}
 	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
 	function initSheet(sheetObj,sheetNo) {
 		var cnt=0;
 		switch(sheetObj.id) {
			// 1, 2, 3 modelResult Sheet.
			case "modelResult01" : // modelResult01 Sheet
			case "modelResult02" : // modelResult02 Sheet
			case "modelResult03" : // modelResult03 Sheet
				with(sheetObj){
		 	      var headerText= changeHeadTitle(sheetObj);
		
		 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:0 } );
		
		 	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		 	      var headers = [{Text:headerText[0], Align:"Center"} , {Text:headerText[1], Align:"Center"}];
		 	      InitHeaders(headers, info);
		
		 	      var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trd",    TreeCol:1, LevelSaveName:"sLevel" ,   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dir",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sub",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"mLodT",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"mLodF",    KeyField:0,   CalcLogic:"|mLodT|/2",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"rLf",      KeyField:0,   CalcLogic:"|mLodT|/|mCa|*100",Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"mRev",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"mCm",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"mOp",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"mAccLod",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"mAccRev",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mCa",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 } ];
		 	       
		 	      InitColumns(cols);
		
		 	      SetEditable(0);
		 	      sheetObj.SetColHidden("mLodF",1);
		 	      sheetObj.SetColHidden("mOp",1);
//		 	      SetSheetHeight(483);
//		 	      SetRangeBackColor(1, 9, 1, 10,"#777777");
	 	      }
 			break;
  		}
 	}
 	
 	function resizeSheet(){
        for(i=0;i<sheetObjects.length;i++){ //Hidden sheet가 마지막에 있음(그래서 제외)
            ComResizeSheet(sheetObjects[i]);
        }    		
	}
 	
   // handling sheet process
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg(false);
 		switch(sAction) {
 		   case IBSEARCH:      //retrieve
 			    formObj.f_cmd.value="";
 				if (tabSearchParams[currentTabIndex] != "-1" && tabSearchParams[currentTabIndex] != getSheetParams()) {
 					if (validateForm(sheetObj,formObj,sAction) == false) {
 						break;
 					}
 				    //log("sheetParams=>" + getSheetParams());
 				    tabSearchParams[currentTabIndex]=getSheetParams();
 			   		if (currentTabIndex < 3) {
 						// Head Title Setting
 						var headerTitle = changeHeadTitle(sheetObj);
 						changeHeaderRow(sheetObj , 0 , headerTitle[0]);
 						changeHeaderRow(sheetObj , 1 , headerTitle[1]);
 			   			// Model Result 01, 02, 03  retrieve
 						sheetObj.DoSearch("ESM_SAQ_0077GS.do", getSheetParams() );
 			   		}
// 					} else {
// 						// Model Log retrieve
// 					    //formObj.f_cmd.value = SEARCHLIST04;
// 						clearStatusInterval();
// 						clearInterval(intervalID);
// 						lastSeq = " ";
// 						searchEngineStatus();
// 					}
 				}
 				break;
 			case IBSAVE:       //save 
 				if (validateForm(sheetObj,formObj,sAction) == false) {
 					break;
 				}
 				var flag=confirm(getMsg("SAQ90139", "save Version" + formObj.version.value + " as Final Version"));
 				if (flag) {
// 				    formObj.f_cmd.value = COMMAND01;
 					formObj.f_cmd.value=MULTI01;
 					sheetObjects[0].DoAllSave("ESM_SAQ_0077GS.do", saqFormString(formObj), "trd", false);

 				}
 				break;
 		   case IBDOWNEXCEL:   //excel download
 			  if(sheetObj.RowCount() < 1){//no data
 					ComShowCodeMessage("COM132501");
 			  }else{
 				  sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
 			  }
 			  break;
 		  case MODIFY01 :
 			 formObj.f_cmd.value=MODIFY01;
			  var params=saqFormString(formObj);			  
			  // retrieve
			  //method change[check again]CLT 			  
			  sheetObj.DoSearch("ESM_SAQ_0077GS.do", params );
			   
			   break;
 		}
 	}
 	
 	function modelResult01_OnSearchEnd(sheetObj , code , msg){
 		sheetObj.ShowTreeLevel(1,1);
		showUnitColums(sheetObj, document.form);
			
 	}
 	function modelResult01_OnSaveEnd(sheetObj , code , msg){
	    var cur_version=document.form.version.value;
		search_onChange();
		document.form.version.value=cur_version;
 		
 	}
 	
 	function modelResult02_OnSearchEnd(sheetObj , code , msg){
 		sheetObj.ShowTreeLevel(1,1);
	    showUnitColums(sheetObj, document.form);
		
	}
 	function modelResult03_OnSearchEnd(sheetObj , code , msg){
 		sheetObj.ShowTreeLevel(1,1);
	    showUnitColums(sheetObj, document.form);
		
	}

 	/*
 	 * setting head title
 	 */
 	function changeHeadTitle(sheetObj) {
 		var title = new Array();
 		var month=eval(document.form.bse_qtr_cd.value.substring(0,1))*3-3;
 		title[0]="Trade/Bound|Trade/Bound|Trade/Bound|"
 					  + "Load(TEU)|"
 					  + "Load(FEU)|"
 					  + "L/F|"
 					  + "Gross Revenue|"
 					  + "CM|"
 					  + "OP|"
 					  + "Accumulated Quarterly\nQTA (as of "+monthNames[month]+")|"
 					  + "Accumulated Quarterly\nQTA (as of "+monthNames[month]+")|"
 					  ;
 		title[1]=" | | |"
 					  + "Load(TEU)|"
 					  + "Load(FEU)|"
 					  + "L/F|"
 					  + "Gross Revenue|"
 					  + "CM|"
 					  + "OP|"
 					  + "Load|"
 					  + "Gross Revenue|";
 		return title;
 		//setting header information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 //no support[implemented common]CLT 		sheetObj.InitHeadRow(0, HeadTitle, true);
 //no support[implemented common]CLT 		sheetObj.InitHeadRow(1, HeadTitle1, true);
 	}
     /**
 	 */
 	function showUnitColums(sheetObj, formObj) {
 		if (formObj.unit.value == "T") {
 			document.all.sheetUnit[currentTabIndex].innerText="Unit : TEU, 1,000USD";
 			sheetObj.SetColHidden("mLodT",0);
 			sheetObj.SetColHidden("mLodF",1);
 		} else {
 			document.all.sheetUnit[currentTabIndex].innerText="Unit : FEU, 1,000USD";
 			sheetObj.SetColHidden("mLodT",1);
 			sheetObj.SetColHidden("mLodF",0);
 		}
 	}
     /**
     * handling process for input validation
 	 */
 	function validateForm(sheetObj,formObj,sAction){ 		
	 	with(formObj){
	 		if (ComIsNull(version)) {
	 			ComShowMessage(getMsg("SAQ90199", "Version"));
	          	return false;
	 		}
 		}
 		return true;
 	}
 	function search_onChange() {
 		
 		var params="year="+document.form.year.value
 					+ "&bse_qtr_cd="+document.form.bse_qtr_cd.value;
 		getSelectCodeList(document.form.version, "MonthlyQuotaModelVersion", params);
 		
 		var versionText = "";
 		
 		if(document.form.version.value != "") {
 			versionText = document.form.version.options[document.form.version.selectedIndex].text;
 			
 			if(versionText.lastIndexOf("F") != -1) { 
 				btn_basedatacreation.disabled = true;
 			} else {
 				btn_basedatacreation.disabled = false;  
 			}
 		} else {
 			btn_basedatacreation.disabled = false;
 		}
 	}
 	// engineLog clear
 	function clearStatusInterval(){
 		if(intervalID != null){
 			clearInterval(intervalID);
 			intervalID == null;
 		}
 		var len=engineLog.rows.length;
 		for(var i=0 ; i < len ; i++){
 			engineLog.deleteRow();
 		}
 	}
 	// log history
 	function searchEngineStatus(){
 		if (lastSeq == "ZZZZZZ") return;
 		var sheetObj=sheetObjects[3];
 		var queryStr=getSheetParams()+"&stsCd="+lastSeq;
 		with(sheetObj){
 			DoSearch("ESM_SAQ_0077GS.do", queryStr );
 			if(RowCount()> 0){
 				var lrow=LastRow();
 				var frow=HeaderRows();
 				for(var i=frow ; i <= lrow ; i++){
 					lastSeq=GetCellValue(i, 2);
 					//log("lastSeq=" + lastSeq);
     				if(lastSeq == "ZZZZZZ"){
     					if(intervalID != null){
                 			clearInterval(intervalID);
                 			intervalID=null;
                 		}
                			return;
     				}
     				appendEngineLog(new Array(GetCellValue(i, 0), GetCellValue(i, 1)));
 				}
 			}
 		}
 		if(lastSeq != "ZZZZZZ" && intervalID == null){
 			intervalID=setInterval("searchEngineStatus()", document.form.intervalTime.value*1000);
 		}
 	}
 	function appendEngineLog(log){
 		var tr=engineLog.insertRow();
 		var td1=tr.insertCell();
 		var td2=tr.insertCell();
 		td1.nowrap=true;
 		td1.innerHTML=log[0];
 		td2.innerHTML=log[1];
 		var div=engineLog.parentElement;
 		div.scrollTop=engineLog.offsetHeight - div.offsetHeight;
 	}
 	function intervalTime_OnChange(){
 		var obj=event.srcElement;
 		if(intervalID != null){
 			clearInterval(intervalID);
 			try{
 				if(obj.value*1 > 0){
 					intervalID=setInterval("searchEngineStatus()", obj.value*1000);
 				}
 			}catch(e) {
 			}
 		}
 		return false;
 	}
 	function optionSetting() {
		SaqSearchOptionYear("year");
		SaqSearchOptionQuarter("bse_qtr_cd");
		SaqSearchOptionComCode("unit", "CD00897", false);
 	}
