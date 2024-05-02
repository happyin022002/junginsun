/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0139.js
*@FileTitle  : Container SBU
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends
     * @class ESM_SAQ_0139 : business script for ESM_SAQ_0139
     */
    function ESM_SAQ_0139() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 var tabObjects=new Array();
 var tabCnt=0 ;
 var currentTabIndex=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comObjects=new Array();
 var comboCnt=0;
 var targetGroup="";
 var tabSearchParams="";
 var tabChildSearchParams=["", "", "", "", ""];
 var haveChildLevels=[0, 0, 6];
 var retrievedChildKeysObj=new Object();
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
 				case "btn_retrieve":
 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					break;
 				case "btn_print":
 					ComShowMessage("btng_print");
 					break;
 				case "btn_downexcel":
 					if(sheetObject.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 					}
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
     * registering IBCombo Object as list
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
 		var objs=document.all.tabLayer;
        	var formObj=document.form;
        	setYearMonthObjectByRelease(formObj.year, formObj.quarter);
 		for(var i=0;i<sheetObjects.length;i++){
 			ComConfigSheet(sheetObjects[i]);
 			objs[i].style.display="Inline";
 			initSheet(sheetObjects[i],i+1);
 			objs[i].style.display="None";
 			ComEndConfigSheet(sheetObjects[i]);
 		}
 		var sheetResizeFull=true;
 		objs[0].style.display="Inline";
 		for(var k=0;k<tabObjects.length;k++){
 			initTab(tabObjects[k],k+1);
 			tabObjects[k].SetSelectedIndex(0);
 		}
 		for(var k=0; k<comboCnt; k++){
 			if (comObjects[k].options.id == "targetGrp" || comObjects[k].options.id == "trade01")
 				continue;
 			comObjects[k].SetSelectText(0, "ALL");
 		}
 		for (i=0; i<sheetObjects.length; i++) {
 			retrievedChildKeysObj[sheetObjects[i].id]=new Object();
 		}
 		resizeSheet();
 		version_change();
 	}
 	
 	function resizeSheet(){
        for(i=0;i<sheetObjects.length;i++){
            ComResizeSheet(sheetObjects[i]);
        }    		
	}
 	
 	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
 	function initSheet(sheetObj,sheetNo) {
 		var cnt=0;
 		var year=document.form.year.value;
 		switch(sheetNo) {
 			case 1: // tradeGroupSheet sheet init
 			    with(sheetObj){

	 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0} );
	 		      changeSheetHead(sheetObj, sheetNo,"init");
	 		      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"target",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	 		             {Type:"Text",      Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:"sub",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	 		      for (i=0; i<=3; i++)
	 		      	{
	 		    	 	cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
	 		      	}
	 		      	cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

	 		      InitColumns(cols);
	 		      SetEditable(0);
//	 		      SetSheetHeight(436);
 		      }
 			   break;
 			case 2: // laneSheet sheet init
 				with (sheetObj) {

	 				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	 				changeSheetHead(sheetObj, sheetNo,"init");
	 				var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"target",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
	 				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 				for (i=0; i<=3; i++) {
	 					cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
	 					}
	 				cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	 				InitColumns(cols);
	 				SetEditable(0);
//	 				SetSheetHeight(436);
 				}
 				break;
 			case 3: // rhqSheet sheet init
 			    with(sheetObj){

	 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	 		      changeSheetHead(sheetObj, sheetNo,"init");
	 		      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"target",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
	 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
	 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
	 		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"aq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
//	 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//	 		             {Type:"Text",      Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 		            for (i=0; i<=3; i++) {
	 		            	cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
	 		            }
		 		  cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	 		      InitColumns(cols);
	 		      SetEditable(0);
//			      SetSheetHeight(436);
 		      }


 				break;
 			} // end swich
 	}
 	// handling process after ending sheet1 retrieve
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg(false);
 		switch(sAction) {
 		   case IBSEARCH:
 				if (tabSearchParams != "" && tabSearchParams != searchKeyQueryString(formObj)) {
 					for(i=0;i<sheetObjects.length;i++){
 						sheetObjects[i].RemoveAll();
 					}
 				}
 				if (validateForm(sheetObj,formObj,sAction) == false) {
 					break;
 				}
 		   		var f_cmd="";
 		   		if (currentTabIndex == 0) {
 		   			// Target Group retrieve
 				    f_cmd="&f_cmd=" + SEARCHLIST01;
 				    var queryString = f_cmd+searchTabQueryString(formObj).replace("targetGrp=0", "targetGrp=");//targetGrp=0
 				    sheetObj.DoSearch("ESM_SAQ_0139GS1.do", queryString );
 		   		} else if (currentTabIndex == 1) {
 		   			// Lane retrieve
 				    f_cmd="&f_cmd=" + SEARCHLIST02;
 				    sheetObj.DoSearch("ESM_SAQ_0139GS2.do", f_cmd+searchTabQueryString(formObj) );
 		   		} else if (currentTabIndex == 2) {
 		   			// RHQ retrieve
 				    f_cmd="&f_cmd=" + SEARCHLIST03;
 				    sheetObj.DoSearch("ESM_SAQ_0139GS3.do", f_cmd+searchTabQueryString(formObj) );
 		   		}
 				tabSearchParams=searchKeyQueryString(formObj);
 				tabChildSearchParams[currentTabIndex]=searchTabQueryString(formObj);
 		    	changeSheetHead(sheetObj, currentTabIndex+1);
     			retrievedChildKeysObj[sheetObj.id]=new Object();
 				break;
 		   case IBDOWNEXCEL:  //excel download
 			  selectDownExcelMethod(sheetObj);
 			  break;
 		}
 	}

    function callBackExcelMethod(excelType) {
    	var sheetObj = sheetObjects[currentTabIndex];
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
			return;
		}
		DownExcel(sheetObj, excelType);
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
     * initializing Tab
     * setting Tab items
     */
 	function initTab(tabObj , tabNo) {
 		 switch(tabNo) {
 			 case 1:
 				with (tabObj) {
 					var cnt=0 ;
					InsertItem( " Target Group/Trade/Sub Trade " , "");
					InsertItem( "     Lane      " , "");
					InsertItem( " Regional Group/Area Director " , "");
 				}
 			 break;
 		}
 	}
 	/**
     * Event when clicking Tab
     * activating selected tab items
     */
 	function tab1_OnChange(tabObj,nItem)
 	{
 		var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	var beforetab=currentTabIndex;
    	objs[beforetab].style.display="none";
 		for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
 		currentTabIndex=nItem;
 		resizeSheet();
 	}
    /**
 	      * handling process for input validation
 	 */
 	function validateForm(sheetObj,formObj,sAction){
// 		with(formObj){
// 			/** checking validation **/
//
// 		} // with end
 		if (ComIsNull(formObj.year)) {
       	 ComShowCodeMessage("COM12113", "Year");
            return false;
        }
        if (ComIsNull(formObj.quarter)) {
       	 ComShowCodeMessage("COM12113", "Quarter");
            return false;
        }
        if (ComIsNull(formObj.version)) {
       	 ComShowCodeMessage("COM12113", "Version");
            return false;
        }
		switch (currentTabIndex) {
			case 0 : // targetGroup check
	            if (getItem_parameter(item01) == "ALL:") {
	            	ComShowCodeMessage("COM12113", "Item");
	                return false;
	            }
				break;
			case 1 : // Lane check
	            if (getItem_parameter(item02) == "ALL:") {
	            	ComShowCodeMessage("COM12113", "Item");
	                return false;
	            }
				break;
			case 2 : // RHQ/Area Director/Lane check
	            if (getItem_parameter(item03) == "ALL:") {
	            	ComShowCodeMessage("COM12113", "Item");
	                return false;
	            }
				break;
        } // switch end
 		return true;
 	}
 	/*
 	 */
 	function searchKeyQueryString(formObj) {
 		var query="";
 		query += "&year="+formObj.year.value;
 		query += "&quarter="+formObj.quarter.value;
 		query += "&targetGrp="+targetGroup;
 		query += "&version="+formObj.version.value;
 		query += "&unit="+formObj.unit.value;
 		return query;
 	}
 	/*
 	 */
 	function searchTabQueryString(formObj) {
 		var queryString=searchKeyQueryString(formObj);
 		var selType="";
 		switch (currentTabIndex) {
 			case 0 : // targetGroup
 				selType=formObj.selType01[0].checked ? "Q" : "T";
 				queryString=queryString
 							+ "&trade="+formObj.trade01.value
 							+ "&dirCd="+formObj.dirCd01.value
 							+ "&selType="+selType
 							+ "&item="+getItem_parameter(item01)
 							;
 				break;
 			case 1 : // lane
 				selType=formObj.selType02[0].checked ? "Q" : "T";
 				queryString=queryString
 							+ "&trade="+formObj.trade02.value
 							+ "&dirCd="+formObj.dirCd02.value
 							+ "&selType="+selType
 							+ "&item="+getItem_parameter(item02)
 							;
 				break;
 			case 2 : // rhq
 				selType=formObj.selType03[0].checked ? "Q" : "T";
 				queryString=queryString
 							+ "&trade="+formObj.trade03.value
 							+ "&dirCd="+formObj.dirCd03.value
 							+ "&selType="+selType
 							+ "&item="+getItem_parameter(item03)
 							;
 				break;
 		} // end switch
 		return queryString;
 	}
 	/*
 	 *  Item Parameter
 	 */
 	function getItem_parameter(comObj){
 		var code=comObj.GetSelectCode().split(",");
 		var param="";
 		for (var i=0; i<code.length; i++) {
 			param=param + comObj.GetText(code[i], 1) + ":";
 		}
 		return param;
 	}
 	/*
 	 *  Target Group
 	 */
 	function targetGrp_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
 	    targetGroup=comboObj.GetSelectCode();
 	    //version_change();
     	trade_change();
 	}
 	/*
 	 */
 	function version_change() {
 		var obj=document.form.version;
 		var params="year="+document.form.year.value+ "&quarter="+form.quarter.value;
 		getSelectCodeList(document.form.version, "SaqMonthlyQuotaReleaseVersion", params);
 	}
 	/*
 	 */
 	function trade_change() {
 		var params="targetGrp="+targetGroup;
 		getSelectCodeList(document.form.trade01, "SaqTagetGroupTrade", params, true);
 		getSelectCodeList(document.form.trade02, "SaqTagetGroupTrade", params, false);
 		getSelectCodeList(document.form.trade03, "SaqTagetGroupTrade", params, false);
 		document.form.trade01.options[document.form.trade01.options.length]=new Option('ALL', '');
 		document.form.trade01.value="";
 		document.form.trade02.options[document.form.trade02.options.length]=new Option('ALL', '');
 		document.form.trade02.value="";
 		document.form.trade03.options[document.form.trade03.options.length]=new Option('ALL', '');
 		document.form.trade03.value="";
 	}
// 	/*
// 	 * tradeGroupSheet Tree Double Click Event
// 	 */
// 	function tradeGroupSheet_OnDblClick(sheetObj, Row, Col) {
// 		common_tree_DblClick(sheetObj, Row, Col);
// 	}
// 	/*
// 	 * laneSheet Tree Double Click Event
// 	 */
// 	function laneSheet_OnDblClick(sheetObj, Row, Col) {
// 		common_tree_DblClick(sheetObj, Row, Col);
// 	}
// 	/*
// 	 * rhqSheet Tree Double Click Event
// 	 */
// 	function rhqSheet_OnDblClick(sheetObj, Row, Col) {
// 		common_tree_DblClick(sheetObj, Row, Col);
// 	}
 	/**
 	 */
	function rhqSheet_OnTreeChild(sheetObj,  Row)
	{
 	    var params = "&f_cmd=" + SEARCHLIST13
 	    		   + "&targetGrpChild=" + sheetObj.GetCellValue(Row, "target")
 	    		   + "&tradeChild=" + sheetObj.GetCellValue(Row, "trd")
 	    		   + "&dirCdChild=" + sheetObj.GetCellValue(Row, "dir")
 	    		   + "&rhqCd=" + sheetObj.GetCellValue(Row, "rhq")
 	    		   + "&ctrtAqCd=" + sheetObj.GetCellValue(Row, "aq")
 	    		   + tabChildSearchParams[currentTabIndex];

 	   	sheetObj.DoSearchChild(Row, "ESM_SAQ_0139GS13.do", params);

 	    recordChildKey(sheetObj, Row);
 	}
 	/**
 	 */
 	function changeSheetHead(sheetObj, sheetNo, gubun) {
 		var year=document.form.year.value;
 		var month=eval(document.form.quarter.value.substring(0,1))*3-2;
 		var months=[month, month+1, month+2];
 		for(var i=0; i<months.length; i++) {
 			months[i]=( months[i]<10 ? "0" : "" )+ months[i];
 		}
 		var i,j=0;
 		with(sheetObj) {
 	        //InitHeadMode(true, true, false, true, false, false)
 	        var HeadTitle1="";
 			if (sheetNo == 1) {
 				HeadTitle1="Target Group|Trade|Bound|Sub Trade|Item|Quarter\nTotal|";
 			} else if (sheetNo == 2) {
 				HeadTitle1="Target Group|Trade|Bound|Sub Trade|Lane|Item|Quarter\nTotal|";
 			} else if (sheetNo == 3) {
// 				HeadTitle1="Target Group|Trade|Bound|Regional\nGroup|Area Director|OFC|Sub Trade|Lane|Item|Quarter\nTotal|";
 				HeadTitle1="Target Group|Trade|Bound|Regional\nGroup|Area Director|OFC|Item|Quarter\nTotal|";
 	        }
 	        for(var i=0; i<3; i++) {
 	        	HeadTitle1=HeadTitle1 + year + "." + months[i] + "|";
 	        }

			if( gubun == "init"){
				var headers = [ { Text:HeadTitle1, Align:"Center"}];
		 	    var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
		 	    sheetObj.InitHeaders(headers, info);
			} else{
    			changeHeaderRow(sheetObj, 0 , HeadTitle1);
			}
 		}
 	    // Sheet Unit Setting
 		var unit_text=document.form.unit.options[document.form.unit.selectedIndex].text;
 		document.all("sheet_unit")[currentTabIndex].innerHTML="Unit : "+unit_text+" / USD / USD 1,000*";
 	}
 	function optionSetting() {
		SaqSearchOptionYear("year");
		SaqSearchOptionQuarter("quarter");
		SaqSearchOptionTargetGroup("targetGrp", '', true, true);
		SaqSearchOptionComCode("unit", "CD00897", false);
		SaqSearchOptionBound("dirCd01");
		SaqSearchOptionComCodeMulti("item01", "CD01058", true, true, 10, "type2");
		SaqSearchOptionBound("dirCd02");
		SaqSearchOptionComCodeMulti("item02", "CD01058", true, true, 10,"type2");
		SaqSearchOptionBound("dirCd03");
		SaqSearchOptionComCodeMulti("item03", "CD01060", true, true, 10, "type2");
    }
 	function item01_OnCheckClick(comboObj, index, code) { 
 		SaqAllChkMultiCombo(comboObj,index);    
 	}
 	function item02_OnCheckClick(comboObj, index, code) { 
 		SaqAllChkMultiCombo(comboObj,index);    
 	} 
 	function item03_OnCheckClick(comboObj, index, code) { 
 		SaqAllChkMultiCombo(comboObj,index);    
 	} 
 	function getSelectText(comboObj) {
 		var mText = "";
 		var curCode = comboObj.GetSelectCode();
 		if (curCode == undefined || curCode == null || curCode == "")
 			return "";
 		var arrCode = curCode.split("|");
 		if (arrCode == null)
 			return "";
 		for (var i = 0; i < arrCode.length; i++) {
 			mText += comboObj.GetText(i, 1) + "|";
 		}
 		return mText.replace(/\|$/, '');
 	}
