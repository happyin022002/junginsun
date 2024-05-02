/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0032.js
*@FileTitle  : OW/LP/OL Auth creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
          MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
          OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_lse_0032 : business script for ees_lse_0032
     */

/* developer job */
// common global variables
var vOrcCntrTpszCd="";
var sheetObjects=new Array();
var sheetCnt=0;
// Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var curRow=0;
var addColCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
 //Event handler processing by button name */
    function processButtonClick(){
        /**********/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcObj=ComGetEvent();
            var srcName=ComGetEvent("name");
            var obj = event.target || ComGetEvent();
	            if ($(obj).prop('disabled')) {
	            	return;
	         }

                switch(srcName) {
                    case "Retrieve":
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;
                    case "New":
                    	var sheetCount=sheetObjects[0].RowCount();
            			var editCount=0;
            			if (sheetCount > 0 ){
            				for (i=0 ; i <= sheetCount+1 ; i++){
            					if (sheetObject.GetRowStatus(i) == 'I' || sheetObject.GetRowStatus(i) == 'U' || sheetObject.GetRowStatus(i) == 'D'){
            						editCount ++;
            					}
            				}
            			}
            			if (editCount > 0 ){
            				ComShowCodeMessage("LSE01156");
            			}else {
            				formObject.loc_cd.value="";
            				formObject.loc_tp[0].selected=true;
            				sheetObject.RemoveAll();
            				ComBtnDisable("Save");
            				loc_cd.focus();
            			}
                    break;
                    case "Save":                    	
                        if(ComIsBtnEnable("Save")){
                            if(sheetObjects[0].CheckedRows(1) > 0){
                        	    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                            }else{
                            	ComShowCodeMessage("LSE01045");
                            }
                        }
                    break;
                    case "btns_search1":   // onh_loc_cd Pop-up
                        if ( srcObj.style.filter == "" ) {
                            openPopup("1");
                        }
                    break;
                    case "btns_calendar1":
                        if ( srcObj.style.filter == "" ) {
                            var cal=new ComCalendar();
                            cal.select(formObject.start_dt, "yyyy-MM-dd");
                        }
                    break;
                    case "btns_calendar2":
                        if ( srcObj.style.filter == "" ) {
                            var cal=new ComCalendar();
                            cal.select(formObject.end_dt, "yyyy-MM-dd");
                        }
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
    function  sheet1_OnLoadFinish() {
    	/* IBMulti Combo Item Setting */
        doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
        document.form.loc_cd.focus();
    }
    function loadPage(){
    	for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	/* initializing IBMultiCombo */
        for ( var k=0 ; k < comboObjects.length ; k++ ) {
            initCombo(comboObjects[k], k+1);
        }
        /* Axon Control Setting*/
        initControl();
        //버튼 비활성화
        ComBtnDisable("Save");   
        sheet1_OnLoadFinish(sheet1);
    }
    function initControl() {
        var formObj=document.form;
        axon_event.addListenerForm('change','obj_change',formObj);       
        axon_event.addListenerForm('click','obj_click',formObj);         
//        axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
        axon_event.addListenerFormat('blur','obj_blur',formObj);         
//        axon_event.addListenerFormat('focus','obj_focus',formObj);       
//        axon_event.addListenerForm('keydown','obj_keydown',	formObj); 
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:
                with (sheetObj) {

	                var HeadTitle="|Sel|Seq.|LIST_KEY|CNTR No.|TP/SZ|P/Up Yard|P/Up Date|Auth No|AGMT No.|Lease Term|New Van| cntr_sts_seq |Auth VOL|P/Up VOL|Remark(s)";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                //(headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dtChk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq_num",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"list_key",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"tysz",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pup_yard",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pup_date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"auth_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"new_van_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Int",       Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"auth_vol",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Int",       Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pup_vol",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:135,  Align:"Center",  ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetDataAutoTrim(1);
	                //SetSheetHeight(439);
	                resizeSheet();
                }
                break;
            case 2:
                with (sheetObj) {
                
                var HeadTitle="0|LIST_KEY|auth_cntr_vol|pickup_vol|auth_vol|tysz|pup_yard|pkup_due_dt|auth_no|agmt_no1|agmt_no2|agmt_no|new_van_type|auth_cntr_vol_org|lstm_cd|remark";
                var headCount=ComCountHeadTitle(HeadTitle);
                //(headCount, 0, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Sta" },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"list_key",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"auth_cntr_vol",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pickup_vol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"auth_vol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"tysz",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pup_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pkup_due_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"auth_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"agmt_no1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"agmt_no2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"new_van_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"auth_cntr_vol_org",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remark",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetDataAutoTrim(1);
                SetSheetHeight(335);
                //ComResizeSheet(sheetObj);
            }
            break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:
                if(validateForm(sheetObj,formObj,sAction)){
                    formObj.f_cmd.value=SEARCH;
                    //sheetObj.SetWaitImageVisible(1);
                    //sheetObjects[1].SetWaitImageVisible(0);
                    ComOpenWait(true);                    
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    setTimeout( function () {
	                    var sXml=sheetObj.GetSearchData("EES_LSE_0032GS.do" , FormQueryString(formObj));
	                    var arrXml=sXml.split("|$$|");
	                    if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	                    if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	                	subsheet_copy();
	                	sheetObjects[0].ColumnSort("auth_no","DESC");
	                    if(sheetObj.RowCount() > 0) ComBtnEnable("Save");
	                	ComOpenWait(false);
                    } , 100);
                    
                	if(sheetObj.RowCount()> 0) ComBtnEnable("Save");
                }
            break;
            case IBSAVE:            	
            if ( sheetObj.id == "sheet1") {
            	formObj.f_cmd.value=MULTI;
            	var sParam=sheetObj.GetSaveString(false, true, 1);
            	sParam += "&" + FormQueryString(formObj);            	
            	var sXml=sheetObj.GetSaveData("EES_LSE_0032GS.do", sParam);
            	sheetObj.LoadSaveData(sXml);
            }            	
            break;
            case IBSEARCH_ASYNC01:	// retrieving for Location
    		if(validateForm(sheetObj,formObj,sAction)) {
    			if ( sheetObj.id == "sheet1") {
    				//var vLocTp=formObj.loc_tp[loc_tp.selectedIndex].text;
    				var vLocTp=formObj.loc_tp.value;
    				var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
    				+"&loc_cd="+ComGetObjValue(loc_cd);
    				sheetObj.SetWaitImageVisible(0);
    				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
    				if ( sXml != "" ) {
    					if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
    						if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
    							var vLocCd="";
    							switch (vLocTp) {
    							case "R":
    								vLocCd=ComGetEtcData(sXml, "rcc_cd");
    								break;
    							case "L":
    								vLocCd=ComGetEtcData(sXml, "lcc_cd");
    								break;															
    							}
    							formObj.loc_cd.value=vLocCd;
    							ComSetFocus(loc_cd);
    						} else {
    							ComShowCodeMessage("LSE01037");
    							formObj.loc_cd.value="";
    							ComSetFocus(loc_cd);
    						}
    					} else {
    						var errMsg=LseComGetErrMsg(sXml);
    						if ( errMsg != "" ) {
    							ComShowMessage(errMsg);
    						}
    						formObj.loc_cd.value="";
    						ComSetFocus(loc_cd);
    					}
    				}
    			}
    		}
    		break;            
        }
    }
    /**
      * handing process Pop-up<br>
      * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
      * @param object
      * @param Row index
      */
    function openPopup(type, Row, Col) {
        var formObj=document.form;
        if ( type == "1" ) {
            var sUrl="";
            var iWidth=800;
            var iHeight=480;
            var sTargetObjList="";
            var sDisplay="1,0,1,1,1,1,1,1";
            if(formObj.loc_tp[0].selected == true){
                sTargetObjList="rcc_cd:loc_cd";
                sUrl='/opuscntr/COM_ENS_051.do';
                ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
            }else if(formObj.loc_tp[1].selected == true){
                sTargetObjList="lcc_cd:loc_cd";
                sUrl='/opuscntr/COM_ENS_051.do';
                ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
            }
        }
    }
    /**
     * handing process Location Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_yardCd(aryPopupData, Row, Col, sheetIdx) {
        if ( aryPopupData.length > 0 ) {
            document.form.loc_cd.value=aryPopupData[0][3];
        }
    }
  
    /**
      * handling process for input validation
      */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) {
                case IBSEARCH:
                if ( formObj.loc_cd.value == "" ) {
    				ComShowCodeMessage("LSE01046");
    				ComSetFocus(loc_cd);
    				return false;
    				break;
    			}
                break;
            }
        }
        return true;
    }

    /**
     * handling Location blur event
     */
    function obj_blur(){
        var obj=ComGetEvent();
        switch(ComGetEvent("name")){
            case "end_dt":
                //checking number
                ComChkObjValid(obj);
            break;
            case "start_dt":
                //checking number
                ComChkObjValid(obj);
            break;
            default:
                //checking Validation
            break;
        }
    }
    /**
     * copying subsheet
     */
    function subsheet_copy(){
        var pupDate="";
        var pkupDueDt="";
        var authCntrVol=0;
        for(var i=1 ; i <=  sheetObjects[0].RowCount(); i++ ){
        	pupDate=sheetObjects[0].GetCellValue(i, "pup_date");
        	if(pupDate != null && pupDate != ""){
                pupDate=pupDate.replaceStr("-" , "");
        	}
        	var arrRows=new Array();
        	var searchText=sheetObjects[0].GetCellValue(i, "list_key");
        	var strRows=ComFindAll(sheetObjects[1], 1, searchText);
        	strRows=strRows + "";        	
        	arrRows=strRows.replaceStr("|", ",").split(","); 
        	for(var k=0 ; k <  arrRows.length ; k++){
        		var pkupDueDt=sheetObjects[1].GetCellValue(arrRows[k], "pkup_due_dt");
        	   if(pkupDueDt != null && pkupDueDt != "" && pkupDueDt != -1){
                   pkupDueDt=pkupDueDt.replaceStr("-" , "");
        	   }               
               if(  Number(pupDate) <= Number(pkupDueDt)){
            	   authCntrVol=Number(sheetObjects[1].GetCellValue(arrRows[k],"auth_cntr_vol"));
            	   if(authCntrVol > 0){
            		   sheetObjects[0].SetCellValue(i, "auth_no",sheetObjects[1].GetCellValue(arrRows[k], "auth_no"));//auth_no
            		   sheetObjects[0].SetCellValue(i, "pup_vol",sheetObjects[1].GetCellValue(arrRows[k], "pickup_vol"));//pickup_vol
            		   sheetObjects[0].SetCellValue(i, "auth_vol",sheetObjects[1].GetCellValue(arrRows[k], "auth_vol"));//auth_vol
            		   sheetObjects[0].SetCellValue(i, "lstm_cd",sheetObjects[1].GetCellValue(arrRows[k], "lstm_cd"));//lstm_cd
            		   sheetObjects[0].SetCellValue(i, "remark",sheetObjects[1].GetCellValue(arrRows[k], "remark"));//remark
                       sheetObjects[1].SetCellValue(arrRows[k], "auth_cntr_vol",authCntrVol -1);//auth_cntr_vol
                       sheetObjects[0].SetCellEditable(i, "dtChk",1);
                       k=arrRows.length + 10;
                   }else{
                       sheetObjects[0].SetCellEditable(i, "dtChk",0);
                       k=arrRows.length + 10;
                   }
               }        	  
        	}
        }
    	sheetObjects[0].ColumnSort("seq_num");
    }
     /**
      * handling event in case of Change
      */
     function obj_change(){	 
     	var obj=ComGetEvent();
     	var formObj=document.form;
     	if ( ComTrim(ComGetObjValue(obj)) != "" ) {
     		switch(ComGetEvent("name")) {
     		    case "loc_cd":		//Location Code
     		        if ( ComTrim(obj.value) != "" ) {
     			        if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L" ){
     				        doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
     			        }
     		        }
     		    break;
     		    case "loc_tp":
               	   formObj.loc_cd.value="";
               	   formObj.loc_cd.focus();
                break;     		
     		}
     	}
     }	
    
  /* end of developer job */
