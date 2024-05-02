/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0163.jsp
*@FileTitle  : Customized Conditions
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
======================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_SAQ_0163 : business script for ESM_SAQ_0163
     */
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var currentTabIndex=1;
    var saveParams="";
    var tabSearchParams=["-1", ""];
    var searchFlag="N";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
    	try {
			var srcName=ComGetEvent("name");
		    if(ComGetBtnDisable(srcName)) return false;
    		//var srcObj=window.event.srcElement;
    		var srcObj=ComGetEvent();
    		//if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
    		if(ComGetBtnDisable(srcObj)){
    			return false;
    		}
            switch(srcName) {
                case "btn_retrieve":
                    tabSearchParams[currentTabIndex]="";
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
        	        break;
                case "btng_row_add":
                	sheetObjects[0].DataInsert();
                	break;
        	    case "btng_save":
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSAVE);
        	        break;
        	    case "btng_saveB":
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSAVE);
        	        break;
        	    case "btng_confirm":
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH_ASYNC01);
        	        break;
        	    case "btng_confirm_":
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH_ASYNC01);
        	        break;
        	    case "btng_cancelconfirmation":
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH_ASYNC02);
        	        break;
        	    case "btng_cancelconfirmationB":
   	            	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH_ASYNC02);
   	            	break;
        	    case "btng_createinitialdata":
        	        doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH_ASYNC04);
        	        break;
        	    case "btng_createinitialdataB":
        	        doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH_ASYNC04);
        	        break;
        	    case "btng_rowadd":
        	    	sheetObjects[1].DataInsert(1);
        	    	//rowAdd(sheetObjects[1]);
        	        break;
                case "btn_downexcel":
                	if(sheetObjects[currentTabIndex].RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		 doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBDOWNEXCEL);
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
    function loadPage() {
    	optionSetting();
        var formObj=document.form;
        var objs=document.all.tabLayer;
        
       	setYearMonthObject(formObj.bse_yr, formObj.bse_qtr_cd);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            objs[i].style.display="Inline";
            initSheet(sheetObjects[i],i+1);
            objs[i].style.display="none";
            ComEndConfigSheet(sheetObjects[i]);
        }

        resizeSheet();
        
        for(k=0;k<tabObjects.length;k++){
        	initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        
		        
        disableAllButton("init");
        ComBtnEnable("btn_retrieve");
        ComBtnDisable("btng_confirm_");
        document.form.bse_yr.focus();
        
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
                with(sheetObj){
	                  var HeadTitle="Del.|Target Group|Trade|Bound|Regional Group|";
	                  SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
	                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ {Type:"DelCheck",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"" },
	                               {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trade_group",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                               {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                               {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                               {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                               {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	                  for(var i=1 ; i <= RowCount(); i++){
	                	  text=text + "|" + GetGetCellText(i, "CODE");
	                  	}
	                  for(var i=1 ; i <= RowCount(); i++){
	                	  text=text + "|" + GetGetCellText(i, "CODE");
	                  	}
	                  for(var i=1 ; i <= RowCount(); i++){
	                	  text=text + "|" + GetGetCellText(i, "CODE");
	                  }
	                  InitColumns(cols);
	                  SetEditable(1);
//	                  SetSheetHeight(475);
	                  SetFocusEditMode(default_edit_mode);

	                  var rtn=getCodeXmlList("LaneBoundSwitchTargetGroup", "");
	                  var arrData=SaqXml2ComboItem(rtn, "code", "text");
	                  arrData[0]=" |" + arrData[0];
	                  SetColProperty("trade_group", {ComboText:arrData[0], ComboCode:arrData[0]} );

	                  var rtn=getCodeXmlList("SaqTagetGroupTradeAll", "");
	                  var arrData=SaqXml2ComboItem(rtn, "code", "text");
	                  arrData[0]=" |" + arrData[0];
	                  SetColProperty("trd_cd", {ComboText:arrData[0], ComboCode:arrData[0]} );

	                  var rtn=getCodeXmlList("SaqTagetGroupDirAll", "");
	                  var arrData=SaqXml2ComboItem(rtn, "code", "text");
	                  arrData[0]=" |" + arrData[0];
	                  SetColProperty("dir_cd",{ComboText:arrData[0], ComboCode:arrData[0]} );

	                  var rtn=getCodeXmlList("RegionalGroup", "");
	                  var arrData=SaqXml2ComboItem(rtn, "code", "text");
	                  arrData[0]=" |" + arrData[0];
	                  SetColProperty("rhq_cd", {ComboText:arrData[0], ComboCode:arrData[0]} );

                  }
                break;
            case 2:      //sheet2 init
                with(sheetObj){
	             var HeadTitle="||Del.|Target Group|Trade|Sub-Trade|Lane|Bound - Orignal|Bound - Adjusted";
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"delflag" },
	                 {Type:"DelCheck",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_check" },
	                 {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trade_group",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"conv_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	             InitColumns(cols);
	             SetEditable(1);
//	             SetSheetHeight(475);
	             SetFocusEditMode(default_edit_mode);
	             InitComboNoMatchText(1,"",1);
                 var rtn=getCodeXmlList("TargetGroupCombo", "ofc=&del=");
                 var arrData=SaqXml2ComboItem(rtn, "grp_cd", "grp_cd");
                 arrData[0]=" |" + arrData[0];
                 SetColProperty("trade_group", {ComboText:arrData[0], ComboCode:arrData[0]} );

                 var rtn=getCodeXmlList("LaneBoundSwitchTrade", "");
                 var arrData=SaqXml2ComboItem(rtn, "code", "text");
                 arrData[0]=" |" + arrData[0];
                 SetColProperty("trd_cd", {ComboText:arrData[0], ComboCode:arrData[0]} );

                 var text=" |E|W|S|N";
                 SetColProperty("dir_cd",{ComboText:text, ComboCode:text} );

             }
             break;
        }
    }
    
	function resizeSheet(){
        for(i=0;i<sheetObjects.length;i++){
            ComResizeSheet(sheetObjects[i]);
        }    		
	}
	
    // handling sheet1 process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:
                if (tabSearchParams[currentTabIndex] != getTabLocalParams()){
                    if (currentTabIndex == 0) {
    				    formObj.f_cmd.value=SEARCHLIST01;
    		   		} else if (currentTabIndex == 1) {
    				    formObj.f_cmd.value=SEARCHLIST02;
    		   		}
    		   		searchFlag="Y";
    		   		disableAllButton();
    		   		tabSearchParams[currentTabIndex]=getTabLocalParams();
    		   		sheetObj.DoSearch("ESM_SAQ_0163GS.do", saqFormString(formObj) );
                }
                break;
            case IBSAVE:
          	    // MULTI01 : 1 Tab Save button
          	    // MULTI02 : 2 Tab Save button
          	    var params=tabSearchParams[currentTabIndex];
                if (currentTabIndex == 0) {
                	//Mandatory Check
                	var sheetParams=sheetObj.GetSaveString();
                	if(sheetParams == "") {
                		return;
                	}
                	//Dup Check
                //no support[check again]CLT 	sheetObj.SpaceDupCheck=false;
                	var dupIdx=sheetObj.ColValueDup("trade_group|trd_cd|dir_cd|rhq_cd", false);
                	if(dupIdx != -1) {
                		ComShowCodeMessage("COM131302", dupIdx+" row");
                		sheetObj.SetSelectRow(dupIdx);
                		return;
                	}
              	    if(ComShowConfirm (getMsg("SAQ90010")) != 1) {
              	    	return;
              	    }
                    params=replaceParams(params, "f_cmd", MULTI01);
                    params=replaceParams(params, "cond_sts_cd", "0");
    		   		disableAllButton();
              	    sheetObj.DoSave("ESM_SAQ_0163GS.do", params, -1, false);

		   		} else if (currentTabIndex == 1) {
				    params=replaceParams(params, "f_cmd", MULTI02);
				    params=replaceParams(params, "cond_sts_cd", "0");
				    if (validationData(sheetObj) == false) return;
	          	    if(ComShowConfirm (getMsg("SAQ90010")) != 1) {
	          	    	return;
	          	    }
				    disableAllButton();
              	    sheetObj.DoSave("ESM_SAQ_0163GS.do", params);
		   		}
	            break;
          	case IBSEARCH_ASYNC01:        // Confirm
             	// MULTI01 : 1 Tab Confirm button
          	    // MULTI03 : 2 Tab Confirm button
          	    var params=tabSearchParams[currentTabIndex];
                if (currentTabIndex == 0) {
                    params=replaceParams(params, "f_cmd", MULTI06);
                    params=replaceParams(params, "cond_sts_cd", "C");
                    disableAllButton();
                    var sXml=sheetObj.GetSaveData("ESM_SAQ_0163GS.do", params);
                    sheetObj.LoadSaveData(sXml);
		   		} else if (currentTabIndex == 1) {
				    params=replaceParams(params, "f_cmd", MULTI03);
				    params=replaceParams(params, "cond_sts_cd", "C");
				    disableAllButton();
			   		sheetObj.DoAllSave("ESM_SAQ_0163GS.do", params);
		   		}
	            break;
          	case IBSEARCH_ASYNC02:        // Cancel Confirm
             	// MULTI01 : 1 Tab Cancel Confirm button
          	    // MULTI03 : 2 Tab Cancel Confirm button
          	    var params=tabSearchParams[currentTabIndex];
                if (currentTabIndex == 0) {
                    params=replaceParams(params, "f_cmd", MULTI06);
                    params=replaceParams(params, "cond_sts_cd", "0");
                    disableAllButton();
                    var sXml=sheetObj.GetSaveData("ESM_SAQ_0163GS.do", params);
                    sheetObj.LoadSaveData(sXml);
		   		} else if (currentTabIndex == 1) {
				    params=replaceParams(params, "f_cmd", MULTI03);
				    params=replaceParams(params, "cond_sts_cd", "0");
				    disableAllButton();
			   		sheetObj.DoAllSave("ESM_SAQ_0163GS.do", params);
		   		}
	            break;
	        case IBSEARCH_ASYNC04:     // DATA COPY
                // MULTI04 : 1 Tab Create Inital Data button
          	    // MULTI05 : 2 Tab Create Inital Data button
                var params=tabSearchParams[currentTabIndex];
                if (currentTabIndex == 0) {
                    params=replaceParams(params,"f_cmd",MULTI04);
		   		} else if (currentTabIndex == 1) {
				    params=replaceParams(params,"f_cmd",MULTI05);
		   		}
		   		if(ComShowConfirm(getMsg("SAQ90139", "create initial data")) != 1){
	           		return;
	         	}
		   		disableAllButton();
		   		sheetObj.DoSearch("ESM_SAQ_0163GS.do", params );
                break;
          	case IBDOWNEXCEL:        //excel download
                selectDownExcelMethod(sheetObj);
                break;
        }
    }

     /**
      * Down Excel �˾�â ���� ���� �޾Ƽ� Ÿ���� ������
      *
      * excelType
 	 * AY - ��ü �����͸� Format ����ؼ� down �޴� ���
 	 * DY - ȭ�鿡 ���̴� ���� Format ����ؼ� down �޴� ���
 	 * AN - ��ü �����͸� Format ������� �ʰ� down �޴� ���
 	 * DN - ȭ�鿡 ���̴� ���� Format ������� �ʰ� down �޴� ���
      */
   	function callBackExcelMethod(excelType){
		var sheetObj = sheetObjects[currentTabIndex];
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
                tabObj.InsertItem( "Load Target - Regional Group Mapping" , "");
                tabObj.InsertItem( "Lane - Bound Switch" , "");
             break;
         }
    }
    /**
     * registering initial event
     */
    function tab1_OnChange(tabObj , nItem){
        //var formObj = document.form;
		var objs=document.all.tabLayer;
		var beforetab=currentTabIndex;
		objs[nItem].style.display="Inline";
		for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
		currentTabIndex=nItem;
		//Retrieve in case previous search information and current search information are different.
   		if (searchFlag == "Y") {
   			doActionIBSheet(sheetObjects[currentTabIndex],document.form,IBSEARCH);
   		}
   		resizeSheet();
   		
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var formObject=document.form;
        var sheet_status=sheetObj.GetEtcData("status");
        formObject.status_value[0].value=sheet_status;
        tabSearchParams[currentTabIndex]=getTabLocalParams();
        if(sheet_status == "Confirmed"){
        	//The stored data can't modification.
            var sRow=sheetObj.RowCount();
            for (idx=0; idx<sRow; idx++){
                sheetObj.SetRowEditable(idx+1,0);
            }
        }else if(sheet_status == "DataCopy"){
            tabSearchParams[currentTabIndex]="";
        	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
        }
        changeButtonStatus(sheet_status);
        if(sheet_status == "DataCopyFail"){
        	ComShowMessage(getMsg("SAQ90153", "copy"));
        	tabSearchParams[currentTabIndex]="";
        	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
        }
    }
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        var formObject=document.form;
        var sheet_status=sheetObj.GetEtcData("status");
        formObject.status_value[1].value=sheet_status;
        tabSearchParams[currentTabIndex]=getTabLocalParams();
        if(sheet_status == "Confirmed"){
        	//The stored data can't modification.
            var sRow=sheetObj.RowCount();
            for (idx=0; idx<sRow; idx++){
                sheetObj.SetRowEditable(idx+1,0);
            }
        }else if(sheet_status == "DataCopy"){
            tabSearchParams[currentTabIndex]="";
        	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
        }
        changeButtonStatus(sheet_status);
        if(sheet_status == "DataCopyFail"){
        	ComShowMessage(getMsg("SAQ90153", "copy"));
        	tabSearchParams[currentTabIndex]="";
        	doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
        }
    }
    function sheet1_OnSaveEnd(sheetObj,errMsg){
        var formObject=document.form;
        var sheet_status=sheetObj.GetEtcData("status");
         if(sheet_status == "OK"){
        	 changeButtonStatus();
             tabSearchParams[currentTabIndex]="";
             doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
         }
    }
    function sheet2_OnSaveEnd(sheetObj,errMsg){
        var formObject=document.form;
        if(sheetObj.GetEtcData("status") == "OK"){
        	changeButtonStatus();
            tabSearchParams[currentTabIndex]="";
            doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBSEARCH);
        }
    }
    function disableAllButton(sts){
        ComBtnDisable("btn_retrieve");
        ComBtnDisable("btn_downexcel");
        if(currentTabIndex == 0 || sts == "init"){
        	ComBtnDisable("btng_row_add");
            ComBtnDisable("btng_save");
            ComBtnDisable("btng_confirm");
            ComBtnDisable("btng_cancelconfirmation");
            ComBtnDisable("btng_createinitialdata");
        }
        if(currentTabIndex == 1 || sts == "init"){
            ComBtnDisable("btng_rowadd");
            ComBtnDisable("btng_saveB");
            ComBtnDisable("btng_confirm_");
            document.form.btng_confirm_.disabled=true;
            ComBtnDisable("btng_cancelconfirmationB");
            ComBtnDisable("btng_createinitialdataB");
        }
    }
    function changeButtonStatus(sts){
        disableAllButton();
        var formObj=document.form;
        ComBtnEnable("btn_retrieve");
        if(currentTabIndex == 0){
            if( sts == "" || sts == undefined){ // only save,copy
            	ComBtnEnable("btng_row_add");
                ComBtnEnable("btng_save");
                ComBtnEnable("btng_createinitialdata");
            }else if( sts == "Pending" || sts == "DataCopy"){   // only excel down, save, confirm, data copy
                ComBtnEnable("btn_downexcel");
                ComBtnEnable("btng_row_add");
                ComBtnEnable("btng_save");
                ComBtnEnable("btng_confirm");
                ComBtnEnable("btng_createinitialdata");
            }else if( sts == "Confirmed" ){    // only excel down, cancel confirm
                ComBtnEnable("btn_downexcel");
                ComBtnEnable("btng_cancelconfirmation");
            }
        } else {
            if( sts == "" || sts == undefined){ // only save, data copy
                ComBtnEnable("btng_rowadd");
                ComBtnEnable("btng_saveB");
                ComBtnEnable("btng_createinitialdataB");
            }else if( sts == "Pending" || sts == "DataCopy"){   // only Excel Down, Save, Confirm, Data Copy
                ComBtnEnable("btng_rowadd");
                ComBtnEnable("btn_downexcel");
                ComBtnEnable("btng_saveB");
                ComBtnEnable("btng_confirm_");
                ComBtnEnable("btng_createinitialdataB");
            }else if( sts == "Confirmed" ){    // only Excel Down, Cancel Confirm
                ComBtnEnable("btn_downexcel");
                ComBtnEnable("btng_cancelconfirmationB");
            }
        }
    }
    /*
	 * Tab 조회 조건 변경 여부 판단에 필요한 QueryString
	 */
    function getTabLocalParams(){
        var formObj=document.form;
		return    "&bse_yr="     + formObj.bse_yr.value
				+ "&bse_qtr_cd=" + formObj.bse_qtr_cd.value;
    }
    function getLocalParams(){
        var obj=document.form;
        var params=saqFormString(obj);
    	return params;
    }
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
    // row append
    function rowAdd(sheetObj) {
        var formObj=document.form;
        //Target Group List
        var params="f_cmd="+SEARCHLIST
    		     + "&mcode=LaneBoundSwitchTargetGroup";
        createCodeSheetObject();
        with(codeSheet){
//        	DoSearch("ESM_SAQ_CODGS.do", params );
        	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
            if (sXml != "") LoadSearchData(sXml,{Sync:1} );

            var text="";
            for(var i=1 ; i <= RowCount(); i++){
                text=text + "|" + GetCellText(i, "CODE");
            }
        }
        var insertRow=sheetObj.DataInsert(-1);
        //setting combo
        sheetObj.InitCellProperty(insertRow, "trade_group",{ Type:"Combo" , ComboText:text, ComboCode:text} );
        sheetObj.InitCellProperty(insertRow, "trd_cd"     ,{ Type:"Combo"} );
        sheetObj.InitCellProperty(insertRow, "sub_trd_cd" ,{ Type:"Combo"} );
        sheetObj.InitCellProperty(insertRow, "rlane_cd"   ,{ Type:"Combo"} );
        sheetObj.InitCellProperty(insertRow, "dir_cd"     ,{ Type:"Combo"} );
        //setting combo
    }

    function sheet1_OnChange(sheetObj, row, col, value){
    	with(sheetObj) {
    		var colNm=ColSaveName(col);
    		switch(colNm) {
    		case "trade_group":
    			//Trade Code Combo Setting
    			if(GetComboInfo(row, "trade_group", "SelectedIndex") == 0){
                    sheetObj.CellComboItem(row,"trd_cd", {ComboText:"", ComboCode:""} );
                }else{
                    var params="f_cmd="+SEARCHLIST + "&mcode=SaqTagetGroupTrade"+ "&targetGrp=" + sheetObj.GetCellValue(row, "trade_group");
                    createCodeSheetObject();
                    with(codeSheet){
                    	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                        if (sXml != "") LoadSearchData(sXml,{Sync:1} );
                        var text="";
                        for(var i=1 ; i <= RowCount(); i++){
                            text=text + "|" + GetCellText(i, "CODE");
                        }
                    }
                    sheetObj.CellComboItem(row,"trd_cd", {ComboText:text, ComboCode:text} );
                }
    			break;
    		case "trd_cd":
    			//Dir Code Combo Setting
    			if(GetComboInfo(row, "trd_cd", "SelectedIndex") == 0){
                    sheetObj.CellComboItem(row,"dir_cd", {ComboText:"", ComboCode:""} );
                }else{
                    var params="f_cmd="+SEARCHLIST + "&mcode=SaqTagetGroupDir"+ "&targetGrp=" + sheetObj.GetCellValue(row, "trade_group")+ "&trdCd=" 	+ sheetObj.GetCellValue(row, "trd_cd");
                    createCodeSheetObject();
                    with(codeSheet){
                    	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                        if (sXml != "") LoadSearchData(sXml,{Sync:1} );
                        var text="";
                        for(var i=1 ; i <= RowCount(); i++){
                            text=text + "|" + GetCellText(i, "CODE");
                        }
                    }
                    sheetObj.CellComboItem(row,"dir_cd", {ComboText:text, ComboCode:text} );
                }
    			break;
    		}
    	}
    }
    function sheet2_OnChange(sheetObj, row, col, value){
        var formObj=document.form;
        if(sheetObj.ColSaveName(col) == "trade_group"){
            sheetObj.SetCellValue(row, "trd_cd","");
            if(sheetObj.GetComboInfo(row, "trade_group", "SelectedIndex") == 0){
                sheetObj.CellComboItem(row,"trd_cd", {ComboText:"", ComboCode:""} );
            }else{
                var params="f_cmd="+SEARCHLIST+ "&mcode=LaneBoundSwitchTrade"+ "&trade_group=" + sheetObj.GetCellValue(row, "trade_group");
                createCodeSheetObject();
                with(codeSheet){
//                	DoSearch("ESM_SAQ_CODGS.do", params );
                	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                    if (sXml != "") LoadSearchData(sXml,{Sync:1} );

                    var text="";
                    for(var i=1 ; i <= RowCount(); i++){
                        text=text + "|" + GetCellText(i, "CODE");
                    }
                }
                sheetObj.CellComboItem(row,"trd_cd", {ComboText:text, ComboCode:text} );
            }
        }
    	 if(sheetObj.ColSaveName(col) == "trd_cd"){
            sheetObj.SetCellValue(row, "sub_trd_cd","");
            if(sheetObj.GetComboInfo(row, "trd_cd", "SelectedIndex") == 0){
                sheetObj.CellComboItem(row,"sub_trd_cd", {ComboText:"", ComboCode:""} );
            }else{
	            var params="f_cmd="+SEARCHLIST + "&mcode=LaneBoundSwitchSubTrade"	+ "&trd_cd=" + sheetObj.GetCellValue(row, "trd_cd");
                createCodeSheetObject();
                with(codeSheet){
//                	DoSearch("ESM_SAQ_CODGS.do", params );
                	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                    if (sXml != "") LoadSearchData(sXml,{Sync:1} );

                    var text="";
                    for(var i=1 ; i <= RowCount(); i++){
                        text=text + "|" + GetCellText(i, "CODE");
                    }
                }
                sheetObj.CellComboItem(row,"sub_trd_cd", {ComboText:text, ComboCode:text} );
            }
        }
        if(sheetObj.ColSaveName(col) == "trd_cd" || sheetObj.ColSaveName(col) == "sub_trd_cd"){
            sheetObj.SetCellValue(row, "rlane_cd","");
            if(sheetObj.GetComboInfo(row, "trd_cd", "SelectedIndex") == 0 && sheetObj.GetComboInfo(row, "sub_trd_cd", "SelectedIndex") == 0){
                sheetObj.CellComboItem(row,"rlane_cd", {ComboText:"", ComboCode:""} );
            }else{
                var params="f_cmd="+SEARCHLIST
            		        + "&mcode=LaneBoundSwitchRlane"+ "&trd_cd="     + sheetObj.GetCellValue(row, "trd_cd")+ "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
                createCodeSheetObject();
                with(codeSheet){
//                	DoSearch("ESM_SAQ_CODGS.do", params );
                	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                    if (sXml != "") LoadSearchData(sXml,{Sync:1} );

                    var text="";
                    for(var i=1 ; i <= RowCount(); i++){
                        text=text + "|" + GetCellText(i, "CODE");
                    }
                }
                sheetObj.CellComboItem(row,"rlane_cd", {ComboText:text, ComboCode:text} );
            }
        }
        if(sheetObj.ColSaveName(col) == "rlane_cd"){
            sheetObj.SetCellValue(row, "dir_cd","");
            if(sheetObj.GetComboInfo(row, "rlane_cd", "SelectedIndex") == 0){
                sheetObj.CellComboItem(row,"dir_cd", {ComboText:"", ComboCode:""} );
            }else{
                var text=" |E|W|S|N";
                sheetObj.CellComboItem(row,"dir_cd", {ComboText:text, ComboCode:text} );
            }
        }
        if(sheetObj.ColSaveName(col) == "dir_cd"){
            sheetObj.SetCellValue(row, "conv_dir_cd","");
            if(sheetObj.GetComboInfo(row, "dir_cd", "SelectedIndex") == 0){
                sheetObj.SetCellValue(row, "conv_dir_cd","",0);
            }else{
            	var ori=sheetObj.GetCellValue(row, "dir_cd");
                var adj="";
                if(ori == "E") adj="W";
                if(ori == "W") adj="E";
                if(ori == "S") adj="N";
                if(ori == "N") adj="S";
                sheetObj.SetCellValue(row, "conv_dir_cd",adj,0);
            }
        }
        if(sheetObj.ColSaveName(col) == "del_check"){
			var trade_group=sheetObj.GetCellValue(row, "trade_group");
			var trd_cd=sheetObj.GetCellValue(row, "trd_cd");
			var sub_trd_cd=sheetObj.GetCellValue(row, "sub_trd_cd");
			var rlane_cd=sheetObj.GetCellValue(row, "rlane_cd");
			var dir_cd=sheetObj.GetCellValue(row, "dir_cd");
			var conv_cd=sheetObj.GetCellValue(row, "conv_dir_cd");
            var cnt=sheetObj.RowCount();
            for(idx=1; idx<cnt+1; idx++){
            	if(trade_group   == sheetObj.GetCellValue(idx, "trade_group")
            			&& trd_cd     == sheetObj.GetCellValue(idx, "trd_cd")
            			&& sub_trd_cd == sheetObj.GetCellValue(idx, "sub_trd_cd")
            			&& rlane_cd   == sheetObj.GetCellValue(idx, "rlane_cd")
            			&& dir_cd     == sheetObj.GetCellValue(idx, "conv_dir_cd")
            			&& conv_cd    == sheetObj.GetCellValue(idx, "dir_cd") ){
            		sheetObj.SetCellValue(idx, "del_check",sheetObj.GetCellValue(row, "del_check"),0);
                   break;
                }
            }
        }
    }
    //checking validation
    function validationData(sheetObj){
        var duprows = sheetObj.ColValueDupRows("trade_group|trd_cd|sub_trd_cd|rlane_cd|dir_cd|conv_dir_cd");
        var arrRow=duprows.split(",");
        if(arrRow != "") {
            for(idx=arrRow.length; idx>0; idx--){
                sheetObj.RowDelete(arrRow[idx-1], false);
            }
        }
        // Status가 I인 행들
        var rows=sheetObj.FindStatusRow("I");
        if( rows != "" && rows != undefined){
            var statusArr=rows.split(";");
            var arrLen=statusArr.length;
            for(i=0; i<arrLen-1; i++){
            	if(sheetObj.GetCellValue(statusArr[i], "delflag") != "Del"){
            		var trade_group=sheetObj.GetCellValue(statusArr[i], "trade_group");
					var trd_cd=sheetObj.GetCellValue(statusArr[i], "trd_cd"     );
					var sub_trd_cd=sheetObj.GetCellValue(statusArr[i], "sub_trd_cd" );
					var rlane_cd=sheetObj.GetCellValue(statusArr[i], "rlane_cd"   );
					var dir_cd=sheetObj.GetCellValue(statusArr[i], "dir_cd"     );
					var conv_dir_cd=sheetObj.GetCellValue(statusArr[i], "conv_dir_cd");
                    for(j=0; j<arrLen-1; j++){
                    	if(trade_group    == sheetObj.GetCellValue(statusArr[j], "trade_group")
							&& trd_cd      == sheetObj.GetCellValue(statusArr[j], "trd_cd"     )
							&& sub_trd_cd  == sheetObj.GetCellValue(statusArr[j], "sub_trd_cd" )
							&& rlane_cd    == sheetObj.GetCellValue(statusArr[j], "rlane_cd"   )
							&& dir_cd      == sheetObj.GetCellValue(statusArr[j], "conv_dir_cd")
							&& conv_dir_cd == sheetObj.GetCellValue(statusArr[j], "dir_cd"     ) ){
                            sheetObj.SetCellValue(statusArr[j], "delflag","Del",0);
                        }
                    }
                }
            }
        }
        var rowCnt=sheetObj.RowCount();
        for(i=rowCnt; i>1; i--){
        	if(sheetObj.GetCellValue(i, "delflag") == "Del")
                sheetObj.RowDelete(i, false);
        }
    }
    function optionSetting() {
    	SaqSearchOptionYear("bse_yr");
    	SaqSearchOptionQuarter("bse_qtr_cd");
    }
