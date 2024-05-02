/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0048.js
*@FileTitle  : Estimated I/F To ERP(PV)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0048 : esm_fms_0048 definition of biz script for creation screen
     */
 
	// common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
            switch(srcName) {
            	case "btn_retrieve":
            		if (!duration_change()) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	             	sheet1_OnSearchEnd(sheetObject,"");
                break;
				case "btn_new":
					ComResetAll();
					inputReadOnly("New");

					var nowYrMon = ComGetNowInfo("ymd");
					
					var tmpFrYm = ComGetDateAdd(nowYrMon,"M", -6);
					var tmpToYm = ComGetDateAdd(nowYrMon,"M", 0);
					var tmpExeYm = ComGetDateAdd(nowYrMon,"M", -1);
					
					document.form.exe_yrmon.value=gf_GetDateFormat(tmpExeYm,"ym");
					document.form.fr_duration.value=gf_GetDateFormat(tmpFrYm,"ym");
					document.form.to_duration.value=gf_GetDateFormat(tmpToYm,"ym");
					
                break;
				case "btn_DownExcel":
 					if(sheetObject.RowCount() < 1){//no data	
 						ComShowCodeMessage("COM132501");
 					}else{	
// 						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
 						sheetObject.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
 					}	

                break;
				case "btn_save":
					if (ComIsBtnEnable("btn_save")) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
					}	
                break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						//ComRowHideDelete(sheetObject, "DelChk"); 
						FmsRowHideDelete2(sheetObject, "del_chk");
					}
                break;
	 			case "btn_fr_duration":
	 				var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.fr_duration, 'yyyy-MM');
					break;					
	 			case "btn_to_duration":
	 				var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.to_duration, 'yyyy-MM');
					break;
            	case "btn_create":
            		if (!duration_change()) return;
	             	doActionIBSheet(sheetObject,formObject,IBCREATE);
	             	sheet1_OnSearchEnd(sheetObject,"");
                break;	
     			case "btn_exe_yrmon":
     				var cal=new ComCalendar();
    				cal.setDisplayType('month');
    				cal.select(form.exe_yrmon, 'yyyy-MM');
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
     * Handling by Event <br>
     * @param {String} flag     	Event Seperator
     **/
    function inputReadOnly(flag) {
    	var readOnly=true;
    	var cursor="default";
    	var img="no_";
    	if(flag == "New") {
    		readOnly=false;
    		cursor="hand";
    		img="";
    	}
    	form.fr_duration.readOnly=readOnly;
    	form.to_duration.readOnly=readOnly;
    	form.btn_fr_duration.name=img+"btn_fr_duration";
    	form.btn_to_duration.name=img+"btn_to_duration";
    	form.btn_fr_duration.style.cursor=cursor;
    	form.btn_to_duration.style.cursor=cursor;
    	ComBtnEnable("btn_save");
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Comparing From and To after inserting Duration 
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Comparing From and To after inserting Duration 

        //var nowYrMon = ComGetDateAdd(ComGetNowInfo("ym")+"01","M",-1,"-");
        var nowYrMon = ComGetNowInfo("ymd");
    	    
    	var tmpFrYm = ComGetDateAdd(nowYrMon,"M", -6);
    	var tmpToYm = ComGetDateAdd(nowYrMon,"M", 0);
    	var tmpExeYm = ComGetDateAdd(nowYrMon,"M", -1);
    	document.form.exe_yrmon.value=gf_GetDateFormat(tmpExeYm,"ym");
    	document.form.fr_duration.value=gf_GetDateFormat(tmpFrYm,"ym");
    	document.form.to_duration.value=gf_GetDateFormat(tmpToYm,"ym");
    }

    /**
     * Comparing From and To after inserting Duration 
     **/
    function duration_change() {
    	var formObj=document.form;
    	var fr_duration=ComReplaceStr(formObj.fr_duration.value,'-');
    	var to_duration=ComReplaceStr(formObj.to_duration.value,'-');
    	if (fr_duration != '' && to_duration != '') {
    		if (parseFloat(fr_duration) > parseFloat(to_duration)) {
    			ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
    			return false;
    		}
    	}
    	return true;
    }

  /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		             var HeadTitle="|Sel|Seq|Rev. Month|Type|Rev.Lane|VVD|Hire|From Date|To Date|Days|Estimated";
		             var headCount=ComCountHeadTitle(HeadTitle)+7;
		             (headCount, 0, 0, true);
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		 
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"CheckBox", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rev_yrmon",        KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:105,  Align:"Right",   ColMerge:0,   SaveName:"hire_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:109,  Align:"Center",  ColMerge:1,   SaveName:"vst_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:109,  Align:"Center",  ColMerge:1,   SaveName:"ved_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"days",             KeyField:1,   CalcLogic:"sheet_dateDiff(|vst_dt|,|ved_dt|)+1",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:"est_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rev_dir_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"subsumcol" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"exe_yrmon" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"estm_ioc_div_cd" } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
//		             SetSheetHeight(470);
		             resizeSheet();
                      }
                break;
        }
    }
  	//Handling IBSheet's process
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH01;
// 	        	   	sheetObj.DoSearch("ESM_FMS_0048GS.do", ComReplaceStr(FormQueryString(formObj)+"&"+"-",{Append:)} );
 	        	    sheetObj.DoSearch("ESM_FMS_0048GS.do", FormQueryString(formObj));
       	   	  		//inputReadOnly("Search");
	  	   	  	}	
                break;
           	case IBSAVE:        
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			var SaveStr=ComGetSaveString(sheetObj, true, true, -1);

	 			formObj.f_cmd.value=MULTI;
	 			var param=SaveStr + "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_FMS_0048GS.do", param);
				//성공 메세지 출력.
				sheetObj.LoadSaveData(sXml);				
				
                break;
			case IBROWSEARCH:   
				if (Col == "ComCd") {//Status, Dry Dock Type
					CoFmsGetCombo("GRID", formObj, sheetObj, "CD01513","flet_ctrt_tp_cd", "flet_ctrt_tp_cdText");
				}	
                break;
	     	case IBCREATE:      
	   	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH;
	        		//sheetObj.DoSearch("ESM_FMS_0046GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
	        		var rXml=sheetObj.GetSearchData("ESM_FMS_0048GS.do", FormQueryString(formObj));
	        		sheetObj.LoadSearchData(rXml,{Sync:2} );
	        		ComBtnEnable("btn_save");
	  	   	  	}	
	            break;
        }
    }
    /**
     * Handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        return true;
    }
     /**
      * Event occuurring after searching IBSheet
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	//sheetObj.ShowSubSum([{StdCol:"flet_ctrt_tp_cd", SumCols:"est_amt", Sort:false, ShowCumulate:false, CaptionCol:9, CaptionText:"ved_dt=TotalAmount"}]);
		//sheetObj.ShowSubSum([{StdCol:"flet_ctrt_tp_cd", SumCols:"est_amt", Sort:false, ShowCumulate:false, CaptionCol:9, CaptionText:"TotalAmount"}]);
		sheetObj.SetSumText(0,"flet_ctrt_tp_cd","TOTAL");
    }
     /**
      * Event occurring after saving IBSheet
      */
    function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		//Disable Interface to ERP Button 
		ComBtnDisable("btn_save");
	}

    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }