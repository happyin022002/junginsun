/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0008.js
*@FileTitle : Accrual Batch History
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

    /**
     * @extends 
     * @class ESD_LEA_0008 : business script for ESD_LEA_0008 
     */
    function ESD_LEA_0008() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    var sheetObjects = new Array();
    var sheetCnt = 0;

    document.onclick = processButtonClick;


	function processButtonClick(){	
		
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var formObject = document.form;
	
		try {
			
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
	
				case "btn_retrieve":		
					lea_retrieve(sheetObject,formObject);
					break;
	
				case "btn_downexcel":
					//lea_form2sheet(formObject,sheetObject1);
					//sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
					//sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
					//doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	    	sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	sheetObject. ExcelOption= "";   
					break;

			} // end switch
			
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++] = sheet_obj;
	}
       
	
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
		
			initSheet(sheetObjects[i],i+1);
		
		    ComEndConfigSheet(sheetObjects[i]);
		}
		
		lea_retrieve(sheetObjects[0],document.form);
	}
	
	
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		
		switch(sheetNo) {
		    case 1://IBSheet1 init
		    	with (sheetObj) {
		    		SheetWidth = mainTable.clientWidth;
		    		
		    		// Setting height
					style.height = 400;

					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					MergeSheet = msHeaderOnly;

					Editable = true;
					
					//[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 3, 1, 9, 100);
					
					//[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(30, 6, 0, true);

					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "Batch Condition Item|Batch Condition Item|Batch Condition Item|Batch Condition Item|Batch Condition Item|Batch Condition Item|Batch History|Batch History|Batch History|Batch History|Batch History|Batch History|Batch History|Batch History|Batch History";
					var HeadTitle1 = "Exe.\nMonth|A/P\nClose|R.VVD|Currency|Manual\nInput|I/F|ID|Estimated|Estimated|Actual|Time|Time|Complete" ;
					var HeadTitle2 = "Exe.\nMonth|A/P\nClose|R.VVD|Currency|Manual\nInput|I/F|ID|Count|Update|Mapping & Allocate|Start|End|Complete" ;
					
					//[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);
					
					//[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,       	60,    daCenter,  true,    	"exe_yrmon"	   			  		,        false,          "",       dfNone,     		0,     false,   false);	
					InitDataProperty(0, cnt++ , dtData,       	40,    daCenter,  true,    	"ap_clz_flg_desc"            	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	60,    daCenter,  true,    	"rev_vvd_if_flg_desc"        	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	60,    daCenter,  true,    	"mon_avg_xch_rt_if_flg_desc" 	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	50,    daCenter,  true,    	"mnl_inp_flg_desc"           	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	40,    daCenter,  true,    	"erp_if_flg_desc"            	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,    	"bat_id"                     	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	80,    daRight ,  true,    	"estm_knt"                   	,        false,          "",       dfInteger,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	80,    daRight ,  true,    	"estm_upd_knt"               	,        false,          "",       dfInteger,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      	120,   daRight ,  true,    	"mapg_aloc_knt"              	,        false,          "",       dfInteger,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      	120,   daCenter,  true,    	"bat_st_dt"                  	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      	120,   daCenter,  true,    	"bat_end_dt"                 	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,       	60,    daCenter,  true,    	"bat_cmpl_flg_desc"          	,        false,          "",       dfNone,     		0,     false,   false);
					
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "ap_clz_flg"                 	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "rev_vvd_if_flg"             	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "rev_vvd_if_knt"             	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "mon_avg_xch_rt_if_flg"      	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "mon_avg_xch_rt_if_knt"      	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "mnl_inp_flg"                	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "erp_if_flg"                 	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "erp_if_dt"                  	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "estm_st_dt"                 	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "estm_end_dt"                	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "estm_upd_st_dt"             	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "estm_upd_end_dt"            	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "mapg_aloc_st_dt"            	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "mapg_aloc_end_dt"           	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "err_knt"                    	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "bat_cmpl_flg"               	,        false,          "",       dfNone,     		0,     false,   false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "bat_rmk"                    	,        false,          "",       dfNone,     		0,     false,   false);
					
					RangeBackColor(1, 0, 2, 15) = RgbColor(222, 251, 248);   // ENIS
					HeadRowHeight = 15 ;
					HeadRowHeight = 15 ;
					//style.height = GetSheetHeight(13) ;
		    	}
		    	break;
		    	
                case 2:  //IBSheet1 init
                	with (sheetObj) {
                    	SheetWidth = mainTable.clientWidth;

                        //[HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        MergeSheet = msHeaderOnly;

                        Editable = true;

                        //[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(2, 0, 0, true);

                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle   = "Exe.Year-Month|Exe.Year-Month";
                        var HeadTitle1  = "From|To";

                        //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "exe_yrmon_from"  ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
						InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "exe_yrmon_to"    ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
                                                               
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        style.height = GetSheetHeight(13) ;
                    }
                    break;
		}
	}

	
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	
		switch(sAction) {
	
	       case IBSEARCH: 
	    	   if (!lea_fnChkSearchForm(formObj)) return false;
	    	   formObj.f_cmd.value = SEARCH;
	    	   //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0008GS.do", FormQueryString(formObj));
	    	   
	    	   var searchXml = sheetObj.GetSearchXml("ESD_LEA_0008GS.do", leaFormQueryString(formObj));
	    	   
	    	   //ComShowMessage(searchXml);
	    	   if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
	    	   break;
	
	       case IBSEARCH_ASYNC01: 
	    	   formObj.f_cmd.value = SEARCH01;
	    	   //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0008GS.do", FormQueryString(formObj));
	    	   
	    	   var searchXml = sheetObj.GetSearchXml("ESD_LEA_0008GS.do", leaFormQueryString(formObj));
	    	   //ComShowMessage(searchXml);
	    	   if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
	    	   break;
	
	       case IBDOWNEXCEL:  // excel down
	    	   if(validateForm(sheetObj,formObj,sAction))
				/*
				mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
                     [WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 
				*/
	    	   sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);
	    	   break;
	
	    }
	}


	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (!ComIsNumber(iPage)) {
			   return false;
			}
	    }
		return true;
	}
        
       
	function lea_fnChkSearchForm(formObj){		
		if(!lea_comm_fnChkEmptyObj(formObj.exe_yrmon_from)) return false;  		
		if(!lea_comm_fnChkEmptyObj(formObj.exe_yrmon_to)) return false;
		return true;
	}
       
	
	function lea_retrieve(sheetObject,formObject){
		sheetObject.RemoveAll();
		if(!lea_comm_checkFromDateToDate(formObject.exe_yrmon_from,formObject.exe_yrmon_to)) return false;	  
	    doActionIBSheet(sheetObject,formObject,IBSEARCH);	
		}
    		
       
	function lea_enterRetrieve(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		lea_retrieve(sheetObject,formObject);	
	}
   
	
	function lea_form2sheet(formObj,sheetObj){
		sheetObj.RemoveAll();
		var Row = sheetObj.DataInsert(-1);
		sheetObj.CellValue(Row , "exe_yrmon_from" ) = formObj.exe_yrmon_from.value;
		sheetObj.CellValue(Row , "exe_yrmon_to"   ) = formObj.exe_yrmon_to.value;
	}

