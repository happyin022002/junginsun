/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_SAQ_0170.js
*@FileTitle  : Year/Month Set for Cost Management
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
     * @class ESM_SAQ_0170 : business script for ESM_SAQ_0170.
     */
    function ESM_SAQ_0170() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   var sheetObjects=new Array();
   var comObjects=new Array();
   var sheetCnt=0;
   var comboCnt=0;
   var tabObjects=new Array();
   var tabCnt=0 ;
   var currentTabIndex=1;
   var saveParams="";
   var tabSearchParams=["-1", ""];
   // Event handler processing by button click event */
   document.onclick=processButtonClick;
// Event handler processing by button name */
       function processButtonClick(){
    	   var sheetObject=sheetObjects[0];
            var formObject=document.form;
       	try {
   			var srcName=ComGetEvent("name");
   			if(ComGetBtnDisable(srcName)) return false;
//       		var srcObj=window.event.srcElement;
//       		if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
               switch(srcName) {
                   case "btn_retrieve":
      	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
           	        break;
           	    case "btn_save":
      	            	doActionIBSheet(sheetObject,formObject,IBSAVE);
           	        break;
           	    case "btn_createinitialdata":
           	        doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
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
           var formObj=document.form;
           setYearMonthObject(formObj.bse_yr, formObj.bse_qtr_cd);
           for(i=0;i<sheetObjects.length;i++){
               ComConfigSheet (sheetObjects[i]);
               initSheet(sheetObjects[i],i+1);
               ComEndConfigSheet(sheetObjects[i]);
           }
           for(k=0;k<tabObjects.length;k++){
               initTab(tabObjects[k],k+1);
           }
           disableAllButton();
           //btnImgEnable(formObj.btn_retrieve, true);
   		   ComBtnEnable("btn_retrieve");
       }
       /**
        * setting sheet initial values and header
        * param : sheetObj, sheetNo
        * adding case as numbers of counting sheets
        */
       function initSheet(sheetObj,sheetNo) {
           var cnt=0;
           switch(sheetNo) {
               case 1:     //sheet1 init
               case 2:     //sheet2 init
            	    with(sheetObj){
		                 var HeadTitle="Year|Quarter|cost_div_cd|Catagory|Appl_Year|Appl_Mon";
		                 SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		                 var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                 InitHeaders(headers, info);
		                 var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bse_yr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                              {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cost_div_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                              {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"cost_div_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                              {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"appl_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                              {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"appl_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];

		                 InitColumns(cols);
		                 SetEditable(1);
		                 SetSheetHeight(430);
		                 SetFocusEditMode(default_edit_mode);
		                 var mon=setYearMon("mon");
		                 SetColProperty("appl_mon", {ComboText:mon, ComboCode:mon} );
                 }
            	 break;
           }
       }
       // handling process after ending sheet1 retrieve
       function doActionIBSheet(sheetObj,formObj,sAction) {
           // 1 Tap : Year
           // 2 Tap : Quarter
           sheetObj.ShowDebugMsg(false);
           switch(sAction) {
               case IBSEARCH:      // search
                   // SEARCHLIST01 : Retrieve button
                   formObj.f_cmd.value=SEARCHLIST01;
                   var params=saqFormString(formObj);
                   if (currentTabIndex == 0) {
   				    params=replaceParams(params, "bse_qtr_cd", "00");
   		   		}
   		   		disableAllButton();
   		   		//setting combo
                   var year=setYearMon("year");
   		   			sheetObj.SetColProperty("appl_yr", {ComboText:year, ComboCode:year} );
   		   			sheetObj.DoSearch("ESM_SAQ_0170GS.do", params );
                   break;
               case IBSAVE:
             	    // COMMAND01 : Save button
             	    var params=tabSearchParams[currentTabIndex];
   		   			params=replaceParams(params,"f_cmd",MULTI01);
   		   			disableAllButton();
             	    sheetObj.DoAllSave("ESM_SAQ_0170GS.do", params);
             	    break;
   	        case IBSEARCH_ASYNC01:     // data copy
                   // COMMAND02 : Create Initial Data button
                   var params=tabSearchParams[currentTabIndex];
                params=replaceParams(params,"f_cmd",MULTI02);
                   if (currentTabIndex == 0) {
                       params=replaceParams(params, "bse_qtr_cd", "00");
   		   		}
   		   		if(ComShowConfirm (getMsg("SAQ90139", "create initial data")) != 1){
   	           		return;
   	         	}
   		   		disableAllButton();
   		   		sheetObj.DoSearch("ESM_SAQ_0170GS.do", params );
//                   sheetObj.DoSearch("ESM_SAQ_0170GS.do", params);
                   break;
             	case IBDOWNEXCEL:        //excel upload
                     selectDownExcelMethod(sheetObj);
                   break;
           }
       }

    /**
     * Down Excel 팝업창 이후 값을 받아서 타입을 리턴함
     *
     * excelType
	 * AY - 전체 데이터를 Format 적용해서 down 받는 경우
	 * DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
	 * AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
	 * DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
     */
   	function callBackExcelMethod(excelType){
		var sheetObj = sheetObjects[0];
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
                var cnt=0;
                   tabObj.InsertItem( "Year" , "");
                   tabObj.InsertItem( "Quarter" , "");
                break;
            }
       }
       function setYearMon(str){
           var rtn=document.form.bse_yr.value;
           if( str == "mon" ) {
               rtn="01|02|03|04|05|06|07|08|09|10|11|12";
           } else if( str == "year" ) {
               rtn=String(Number(rtn)+1) + "|" + rtn + "|" + String(Number(rtn)-1);
           }
           return rtn;
       }
       /**
        * Event when clicking Tab
        * activating selected tab items
        */
       function tab1_OnChange(tabObj , nItem){
           //var formObj = document.form;
   		var objs=document.all.tabLayer;
   		var beforetab=currentTabIndex;
   		objs[nItem].style.display="Inline";
   		objs[beforetab].style.display="none";
   		//--------------- important --------------------------//
   		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
   		//------------------------------------------------------//
   		currentTabIndex=nItem;
      		if (currentTabIndex == 0) {
      			document.all.td_yr.width="100%";
      			document.all.td_qtr.style.display="none";
      			document.all.bse_qtr_cd.style.display="none";
      		} else if(currentTabIndex == 1) {
      		    document.all.td_yr.width="80";
      		    document.all.td_qtr.style.display="Inline";
      			document.all.bse_qtr_cd.style.display="Inline";
      		}
      		if( tabSearchParams[currentTabIndex] == -1 || tabSearchParams[currentTabIndex] == "" ){
      		    changeButtonStatus();
      		} else {
      		    changeButtonStatus("OK");
      		}
       }

       function sheet1_OnSearchEnd(sheetObject, ErrMsg){
           var formObject=document.form;
           var sheet_status=sheetObject.GetEtcData("status");

           tabSearchParams[currentTabIndex]=getTabLocalParams();
           if(sheet_status == "DataCopy"){
               tabSearchParams[currentTabIndex]="";
           	doActionIBSheet(sheetObject,formObject,IBSEARCH);
           }
           changeButtonStatus(sheet_status);
       }

       function sheet2_OnSearchEnd(sheetObject, ErrMsg){
           var formObject=document.form;
           var sheet_status=sheetObject.GetEtcData("status");

           tabSearchParams[currentTabIndex]=getTabLocalParams();
           if(sheet_status == "DataCopy"){
               tabSearchParams[currentTabIndex]="";
           	   doActionIBSheet(sheetObject,formObject,IBSEARCH);
           }
           changeButtonStatus(sheet_status);
           if ( sheetObject.GetEtcData("existCheck") == 'OK' ) {
        	   ComBtnEnable("btn_createinitialdata");
           } else {
        	   ComBtnDisable("btn_createinitialdata");
           }
       }

       function sheet1_OnSaveEnd(sheetObject,errMsg){
           var formObject=document.form;
           if(sheetObject.GetEtcData("status") == "OK"){
               tabSearchParams[currentTabIndex]="";
               doActionIBSheet(sheetObject,formObject,IBSEARCH);
           }
       }
       function sheet2_OnSaveEnd(sheetObject,errMsg){
           var formObject=document.form;
           if(sheetObject.GetEtcData("status") == "OK"){
               tabSearchParams[currentTabIndex]="";
               doActionIBSheet(sheetObject,formObject,IBSEARCH);
           }
       }
       function disableAllButton(sts){
           var formObj=document.form;
           ComBtnDisable("btn_retrieve");
           ComBtnDisable("btn_save");
           ComBtnDisable("btn_createinitialdata");
           ComBtnDisable("btn_downexcel");
       }
       function changeButtonStatus(sts){
           disableAllButton();
           var formObj=document.form;
           ComBtnEnable("btn_retrieve");
           if( sts == "OK" || sts == "DataCopy" ){
              ComBtnEnable("btn_save");
              ComBtnEnable("btn_createinitialdata");
              ComBtnEnable("btn_downexcel");
           }
       }

       function getTabLocalParams(){
    	   var formObj=document.form;
   		   return "&bse_yr="     + formObj.bse_yr.value
   		        + "&bse_qtr_cd=" + formObj.bse_qtr_cd.value;
       }

       function getLocalParams(){
           var obj=document.form;
           var params=saqFormString(obj);
       	return params;
       }

       /*
        * Params에 있는 값을 찾아서 변경한다.
        */
       function replaceParams( params,paramName,paramValue ){
           var idx1=params.indexOf(paramName+"=");
           if( idx1 < 0 ){
               params += "&"+paramName+"="+paramValue;
               return params;
           }
           var idx2=params.indexOf("&",idx1);
           if( idx2 < 0 ){
               idx2=params.length;
           }
           var v=paramName.length+1;
           var startStr=params.substring(0,idx1+v);
           var endStr=params.substring(idx2,params.length);
           var value=startStr + paramValue + endStr;
           return value;
       }

       /*
        * 년도와 분기 combo box setting
        */
       function optionSetting() {
    	   SaqSearchOptionYear("bse_yr");
    	   SaqSearchOptionQuarter("bse_qtr_cd");
       }
