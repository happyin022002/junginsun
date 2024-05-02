/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1005.js
*@FileTitle : Commodity Exception Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_1005 :  business script for EES_DMT_1005
     */
    function EES_DMT_1005() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
		this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//  Business Global Variables
    var CONTINENT="CONTI";
    var COUNTRY="CNT";
    var REGION="RGN";
    var STATE="STE";
    var LOCATION="LOC";
    var COMMON_TARIFF_CD="common_tariff_cd"; 
	var ORIGIN="Origin";
	var DESTINATION="Destination";
	var ROWMARK="|";
	var FIELDMARK="=";
	var Mincount=0 ;
	var IBUPDATE=51;
	var IBEXPIRE=52;
	var isNoChangeActive=false;
	var DEF_SHEET_HEIGHT = 417;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
				case "btn_RowAdd":
	        		doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btn_RowCopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;
				case "btn_Update":
					doActionIBSheet(sheetObject1,formObject,IBUPDATE);
					break;
				case "btn_Expire":
					doActionIBSheet(sheetObject1,formObject,IBEXPIRE);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Save":
					sheetObject1.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    ComOpenWait(false);
                    sheetObject1.SetWaitImageVisible(1);
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
     //IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
     	//Current date initializing
    	var formObj=document.form;
//    	var data=getDefaultDate(0).split("|");
//     	ComSetObjValue(formObj.today, data[1].substring(0,4)+data[0].substring(5,7)+data[0].substring(8,10));
    	ComSetObjValue(formObj.today, DmtComOfficeCurrDate(sheetObjects[0], formObj));
        initAxonControl();
        DisableControls();
        
        sheet1_OnLoadFinish(sheet1);
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet4 init
                with(sheetObj){
                
            var HeadTitle1="||Seq.|Commodity|Commodity|Commodity|EFF DT|EXP DT|Free Time|Free Time|F/T Exclusion|F/T Exclusion|F/T Exclusion|Update|Update|svr_id|trf_seq|cmdt_trf_seq|dmdt_trf_cd|org_cmdt_cd|org_eff_dt|org_exp_dt|org_cmdt_add_dys|org_cmdt_ttl_dys|org_xcld_sat_flg|org_xcld_sun_flg|org_xcld_hol_flg";
             var HeadTitle2="||Seq.|Code|Description|Rep.|EFF DT|EXP DT|Add|Total|SAT|SUN|H/day|Office|Name|svr_id|trf_seq|cmdt_trf_seq|ddmt_trf_cd|org_cmdt_cd|org_eff_dt|org_exp_dt|org_cmdt_add_dys|org_cmdt_ttl_dys|org_xcld_sat_flg|org_xcld_sun_flg|org_xcld_hol_flg";
             var headCount=ComCountHeadTitle(HeadTitle1);

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"check" },
                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
                 {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10,  ToolTipText:"Effective Date"},
                 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10,  ToolTipText:"Expiration Date"},
                 {Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_add_dys",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_ttl_dys",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                 {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
                 {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"upd_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_seq" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cmdt_trf_seq" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_cmdt_cd" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_eff_dt" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_exp_dt" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_cmdt_add_dys" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_cmdt_ttl_dys" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_xcld_sat_flg" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_xcld_sun_flg" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_xcld_hol_flg" } ];
              
             InitColumns(cols);

             SetEditable(1);
             SetCountPosition(0);
             SetShowButtonImage(2);
             SetSheetHeight(DEF_SHEET_HEIGHT);
             //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
             //no support[check again]CLT 					SpaceDupCheck=false;
             }
			break;         	
        }
    }    
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      // Retrieve
				//1.Inquiry ago, the parameter is set to a value type or allows selected.
        		ComSetObjValue(formObj.f_cmd, SEARCH);
				setParameters(SEARCH);
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
	                    //ComOpenWait Start
	                    //sheetObj.WaitImageVisible=false;	
//	                    ComOpenWait(true);
	                    //2.Inquiry as a query is run conditions
						sheetObj.DoSearch("EES_DMT_1005GS.do", FormQueryString(formObj) );
	                    //ComOpenWait End
	                    //ComOpenWait(false);
					}
				}
				break;	
        	case IBINSERT:
        		sheetObj.DataInsert(-1);
        		break;
        	case IBCOPYROW:
        		var row=sheetObj.DataCopy();
        		sheetObj.SetCellValue(row, "upd_ofc_cd","",0);
        		sheetObj.SetCellValue(row, "upd_name","",0);
        		break;
        	case IBDELETE:
        		var checkcnt=0;
    			for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
    				if(sheetObj.GetCellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    			
    			if ( sheetObj.GetCellValue(sheetObj.GetSelectRow(),0) != "I" ) {
            		if(ComShowCodeConfirm("DMT00145")){
            			for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
            				var sValue=sheetObj.GetCellValue(i, "eff_dt");
            				if(sheetObj.GetCellValue(i, "check") == "1") {
            					if(sheetObj.GetRowStatus(i) == "I") {
            		    			ComRowHideDelete(sheetObj, "check");
            		    		}else{
    	        		    		if(ComIsDate(sValue, "ymd")) {
    	        		    			var iDay=ComGetDaysBetween(ComReplaceStr(ComGetObjValue(formObj.today),"-",""), sValue);
    	        		    			if(iDay <= 0 ) {
    	        		    				ComShowCodeMessage("DMT00146","Row Delete["+sheetObj.GetCellValue(i, "cmdt_cd")+"]");//Effective Date must be later than today for {msg1}!
    	        		    				sheetObj.SelectCell(i, "eff_dt");
    	        		        			return;
    	        		    			}else{
    	        		    				ComRowHideDelete(sheetObj, "check");
    	        		    			}
    	        		    		}else{
    	        		    			ComShowCodeMessage("COM12132");
    	        		    			sheetObj.SelectCell(i, "eff_dt");
    	    		        			return;
    	        		    		}
            		    		}
            		    	}
            			}
            		}
    			} else {
                    ComRowHideDelete(sheetObj, "check");
                }        		
        		break;
        	case IBUPDATE:
        		var checkcnt=0;
    			for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
    				if(sheetObj.GetCellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    			
        		//if(ComShowCodeConfirm("DMT00145")){
        			for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
        				var sValue=sheetObj.GetCellValue(i, "eff_dt");
        				if(sheetObj.GetCellValue(i, "check") == "1") {
        					if(sheetObj.GetRowStatus(i) == "I") {
								sheetObj.SetCellEditable(i,"eff_dt",1);
    		    				sheetObj.SetCellEditable(i,"exp_dt",1);
    		    				sheetObj.SetCellEditable(i,"cmdt_add_dys",1);
    		    				sheetObj.SetCellEditable(i,"cmdt_ttl_dys",1);
    		    				sheetObj.SetCellEditable(i,"xcld_sat_flg",1);
    		    				sheetObj.SetCellEditable(i,"xcld_sun_flg",1);
    		    				sheetObj.SetCellEditable(i,"xcld_hol_flg",1);
        		    		}else{
	        		    		if(ComIsDate(sValue, "ymd")) {
	        		    			var iDay=ComGetDaysBetween(ComReplaceStr(ComGetObjValue(formObj.today),"-",""), sValue);
	        		    			if(iDay <= 0 ) {
	        		    				ComShowCodeMessage("DMT00146","Update["+sheetObj.GetCellValue(i, "cmdt_cd")+"]");//Effective Date must be later than today for {msg1}!
	        		    				sheetObj.SelectCell(i, "eff_dt");
	        		        			return;
	        		    			}else{
										sheetObj.SetCellEditable(i,"eff_dt",1);
	        		    				sheetObj.SetCellEditable(i,"exp_dt",1);
	        		    				sheetObj.SetCellEditable(i,"cmdt_add_dys",1);
	        		    				sheetObj.SetCellEditable(i,"cmdt_ttl_dys",1);
	        		    				sheetObj.SetCellEditable(i,"xcld_sat_flg",1);
	        		    				sheetObj.SetCellEditable(i,"xcld_sun_flg",1);
	        		    				sheetObj.SetCellEditable(i,"xcld_hol_flg",1);
	        		    			}
	        		    		}else{
	        		    			ComShowCodeMessage("COM12132");
	        		    			sheetObj.SelectCell(i, "eff_dt");
	    		        			return;
	        		    		}
        		    		}
        		    	}
        			}
        		//}
        		break;
        	case IBEXPIRE:
        		var checkcnt=0;
    			for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
    				if(sheetObj.GetCellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    			
        		for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
        			var sValue=sheetObj.GetCellValue(i, "exp_dt");
        			if(sheetObj.GetCellValue(i, "check") == "1") {
        				if(sheetObj.GetRowStatus(i) == "I") {
    		    			sheetObj.SetCellEditable(i,"exp_dt",1);
    		    		}else{
	    		    		if(sValue != "") {
	    		    			//ComShowCodeMessage("DMT00125");
	    		    			ComShowMessage(ComGetMsg("DMT00125")+" ["+sheetObj.GetCellValue(i,"cmdt_cd")+"]");
	    		    			sheetObj.SelectCell(i, "exp_dt");
			        			return false;
	    		    		}else{
			    				sheetObj.SetCellEditable(i,"exp_dt",1);
	    		    		}
    		    		}
    		    	}
    			}
        		break;
	   		case IBCLEAR:       //initializing
	   			initControl();
	   			DisableControls();
				break;
	   		case IBSAVE:
	   			ComSetObjValue(formObj.f_cmd, MULTI);
				setParameters(MULTI);
				if(!validateForm(sheetObj,formObj,sAction)) return;
                //ComOpenWait Start
                sheetObj.DoSave("EES_DMT_1005GS.do", FormQueryString(formObj), -1, false);
                
				break;		
	   		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					if (sheetObj.RowCount()== 0 ) {
				   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
				   	    return;
				   	} else {
				   		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObj), SheetDesign:1,Merge:1 });
				   	}
					
				}; 
				break;
	   		case IBSEARCH_ASYNC01:         // Search
                formObj.f_cmd.value=COMMAND15; 
           		//ComOpenWait Start
	   			sheetObj.SetWaitImageVisible(0);
	   			ComOpenWait(true);
	   				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do",FormQueryString(formObj));
                //ComOpenWait End
                ComOpenWait(false);
                var rtnName=ComGetEtcData(sXml, "rtnName");
                var selRow=document.form.cmdt_row.value;
                if ( rtnName != undefined && rtnName != '') {
                    var rtnNameArr=rtnName.split("|");
                    sheetObjects[0].SetCellValue( selRow , 4 ,rtnNameArr[1],0);
                    sheetObjects[0].SetCellValue( selRow , 5 ,rtnNameArr[2],0);
                } else {
                    ComShowCodeMessage( "DMT00165" , "Commodity code" );
                    sheetObjects[0].SetCellValue( selRow , 3 ,"",0);
                    sheetObjects[0].SetCellValue( selRow , 4 ,"",0);
                    sheetObjects[0].SetCellValue( selRow , 5 ,"",0);
                }
           break;				
		}			
    }    
	function initAxonControl() {  
		axon_event.addListenerFormat('blur',	'obj_blur',		form); // out of focus
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); // Keyboard input
		axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'org_dest_location');	//Enter시 자동Retrieve
	}
	/*
	 * Location field, enter the letters converted to upper case
	 */		
	function obj_keypress(){ 
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}
	/*
	 * Location FocusOut, input digits for the Validation Check
	 */
	function obj_blur() {
		obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110');
			ComClearObject(obj);
		}
	}
	function obj_keydown() {
		if(event.keyCode == 13) {
			//obj = event.srcElement;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	/**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var msg="";
    	with(formObj) {
    		switch(sAction) {
				case IBSEARCH:      // Retrieve
			    	//Tariff Type Valid check
					if(ComTrim(ComGetObjValue(formObj.sel_dmdt_trf_cd)) == "") {
		        		ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Tariff Type"));
		        		return false;
		        	}
			    	//Coverage Continent Valid check
					
			    	if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
			    		ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Continent"));
			    		return false;
			    	}
			    	//Coverage Country Valid check
			    	if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
			    		ComAlertFocus(formObj.combo3, ComGetMsg('COM12113', "Coverage Country"));
			    		return false;
			    	}
			    	//Coverage Country Valid check
			    	if(ComTrim(ComGetObjValue(formObj.org_dest_conti_cd)) == "") {
			    		ComAlertFocus(formObj.combo3, ComGetMsg('COM12113', "Origin Continent"));
			    		return false;
			    	}
			    	break;
				case IBSAVE:      // save
			    	//Check mandatory input
					for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
						if(sheetObj.GetRowStatus(i) == "I" || sheetObj.GetRowStatus(i) == "U" || sheetObj.GetRowStatus(i) == "D") {
							//Commodity
							if(sheetObj.GetCellValue(i, "cmdt_cd") == "") {
								ComShowCodeMessage('DMT02002', "Commodity");
								sheetObj.SelectCell(i, "cmdt_cd");
								return false;
							}
							//EFF DT
							if(sheetObj.GetCellValue(i, "eff_dt") == "") {
								ComShowCodeMessage('DMT02002', "Effective Date");
								sheetObj.SelectCell(i, "eff_dt");
								return false;
							}
							//FREE TIME
							if(sheetObj.GetCellValue(i, "cmdt_add_dys") == 0 && sheetObj.GetCellValue(i, "cmdt_ttl_dys") == 0) {
								ComShowCodeMessage('DMT02002', "["+sheetObj.GetCellValue(i, "cmdt_cd")+"] Free Time");
								sheetObj.SelectCell(i, "cmdt_add_dys");
								return false;
							}
							if(sheetObj.GetCellValue(i, "cmdt_add_dys") > 0 && sheetObj.GetCellValue(i, "cmdt_ttl_dys") > 0) {
								ComShowCodeMessage('DMT02004', "["+sheetObj.GetCellValue(i, "seq")+"]");
                                sheetObj.SelectCell(i, "cmdt_add_dys");
                                return false;
                            }
							//EXP DT, EFF DT  check
							if(sheetObj.GetCellValue(i, "exp_dt") != "") {
								var ret=ComChkPeriod(sheetObj.GetCellValue(i, "eff_dt"), sheetObj.GetCellValue(i, "exp_dt"));	//ret=ComChkPeriod("20080909", "20080908") // result=0
							     																							//ret = ComChkPeriod("20080909", "20080909") // result = 2
							     																							//ret = ComChkPeriod("20080909", "20080910") // result = 1
							     																							//ret = ComChkPeriod("20080909", "2008")     // result = -1
								//eff_dt > exp_dt
								if(ret < 1) {
				    				ComShowMessage(ComGetMsg("DMT01089", "Expiration Date", "Effective Date"));
				        			sheetObj.SelectCell(i, "exp_dt");
//				        			sheetObj.CellValue2(i, "eff_dt") = "";
									return false;
								}
							}
						}
					}
					//data without any changes, if only to check the checkbox to release logic
					for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
						if(sheetObj.GetRowStatus(i) == "U") {
							if(sheetObj.GetCellValue(i, "cmdt_cd") == sheetObj.GetCellValue(i, "org_cmdt_cd")
									&& sheetObj.GetCellValue(i, "eff_dt") == sheetObj.GetCellValue(i, "org_eff_dt")
									&& sheetObj.GetCellValue(i, "exp_dt") == sheetObj.GetCellValue(i, "org_exp_dt")
									&& sheetObj.GetCellValue(i, "cmdt_add_dys") == sheetObj.GetCellValue(i, "org_cmdt_add_dys")
									&& sheetObj.GetCellValue(i, "cmdt_ttl_dys") == sheetObj.GetCellValue(i, "org_cmdt_ttl_dys")
									&& sheetObj.GetCellValue(i, "xcld_sat_flg") == sheetObj.GetCellValue(i, "org_xcld_sat_flg")
									&& sheetObj.GetCellValue(i, "xcld_sun_flg") == sheetObj.GetCellValue(i, "org_xcld_sun_flg")
									&& sheetObj.GetCellValue(i, "xcld_hol_flg") == sheetObj.GetCellValue(i, "org_xcld_hol_flg"))
							{
								sheetObj.SetCellValue(i, "check",0,0);
								sheetObj.SetRowStatus(i,"R");
							}
						}
					}
//					//var dupRows = sheetObj.ColValueDupRows("cmdt_cd",false,true);
//	        		var dupRows = sheetObj.ColValueDupRows("cmdt_cd", false, false);
//	        		alert(dupRows);
//	        		if(dupRows != '') {		
//		        		var arrRow = dupRows.split(",");
//		        		for( var i = 1; i < arrRow.length; i++) {
//		        			alert(i+":"+sheetObj.CellValue(arrRow[i], "cmdt_cd"));
//		        		}
//		        		
//		        		var dupCmdtCd = sheetObj.CellValue(arrRow[0], "cmdt_cd");
//		        		var dupEffDt = sheetObj.CellValue(arrRow[0], "eff_dt");
//			        			        			
//			        	ComShowCodeMessage('DMT00144', "Commodity["+dupCmdtCd+"]");
//			        	sheetObj.SelectRow = arrRow[0];
//			        	return false;
//	        		}
//	        		return false;
					var temp_code="";
					var temp_row="";
	        		// Duplicated Commodity - if the same commodity is included in eff_dt and exp_dt Not
	        		for(var i=2 ; i < sheetObj.RowCount()+2 ; i++) {
	        			for(var j=i+1 ; j < sheetObj.RowCount()+2 ; j++) {
	        				if(sheetObj.GetRowStatus(j) == "R" || sheetObj.GetRowStatus(j) == "D")	continue;
	        				if(sheetObj.GetCellValue(i, "cmdt_cd") == sheetObj.GetCellValue(j, "cmdt_cd")){
	        					temp_code   += sheetObj.GetCellValue(i, "cmdt_cd") + ",";
		        				temp_row	+= j + ",";
		        			}
	        			}
	        		}
	        		var arrData=temp_code.split(",");
	        		var arrRow=temp_row.split(",");
	        		for(var i=0 ; i < arrData.length - 1 ; i++) {
	        			for(var j=2 ; j < sheetObj.RowCount()+2 ; j++) {
	        				if(j == arrRow[i])	continue;
	        				if(sheetObj.GetCellValue(j, "cmdt_cd") != arrData[i])	continue;
	        				var start_dt=sheetObj.GetCellValue(j, "eff_dt");
	        				var end_dt=sheetObj.GetCellValue(j, "exp_dt");
	        				if(end_dt == "") 
	        					end_dt="99991231";
	        				var temp_eff_dt=sheetObj.GetCellValue(arrRow[i], "eff_dt");
	        				var temp_exp_dt=sheetObj.GetCellValue(arrRow[i], "exp_dt");
	        				//eff_dt
	        				if( start_dt <= temp_eff_dt	&& temp_eff_dt <= end_dt) {
	        					ComShowCodeMessage('DMT00144', "Commodity["+sheetObj.GetCellValue(j, "cmdt_cd")+"]");
	        					return false;
	        				}
	        				if(temp_exp_dt != "") {
		        				if( start_dt <= temp_exp_dt && temp_exp_dt <= end_dt) {
		        					ComShowCodeMessage('DMT00144', "Commodity["+sheetObj.GetCellValue(j, "cmdt_cd")+"]");
		        					return false;
		        				}
	        				}
	        			}
	        		}
			    	break;
    		}
    	}
        return true;
    }
	/** 
	 * IBCombo Object set to an array
	 * param : combo_obj 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
	 * Initializing Combo 
	 * param : comboObj , comboNo
	 * adding case as numbers of counting Combos 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj=document.form
	    switch(comboNo) { 
	    	//Tariff Type
	    	case 1:
	    		with (comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
					SetDropHeight(160);
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");  	
					ValidChar(2);
	//no support[check again]CLT 				ValidChar(2,0);		
	//no support[check again]CLT 				IMEMode=0;
					SetMaxLength(4);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObj);
	   		break;
	   		
	    	//Continent
	    	case 2: 
	    	case 5:
	    		with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");  				
					SetDropHeight(160);
					ValidChar(2);
	//no support[check again]CLT 				ValidChar(2,0);		
	//no support[check again]CLT 				IMEMode=0;
					SetMaxLength(1);
		    	}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
			break;
			
	    	//Country
	    	case 3:
	    		with (comboObj) {
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");  
	    		}
	    	case 6:
	    		with (comboObj) {
	    			SetMultiSelect(0);
	    			UseAutoComplet=false;
	    			SetColAlign(0, "left");
	    			SetColAlign(1, "left");
	    			SetColWidth(0, "30");
	    			SetColWidth(1, "200");
	    			SetDropHeight(160);
	    			ValidChar(2);
	//no support[check again]CLT 				ValidChar(2,0);		
	//no support[check again]CLT 				IMEMode=0;
					SetMaxLength(2);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
	    	break;
	    	
	    	//Region
	    	case 4:
	    	case 7:
	    		with (comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
					SetDropHeight(160);
					ValidChar(2);
	//no support[check again]CLT 				ValidChar(2,0);		
	//no support[check again]CLT 				IMEMode=0;
					SetMaxLength(3);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
	    	break;
	    }
	} 	
	
	
	//Tariff Type event
	//OldIndex, OldText, OldCode, NewIndex, NewText, NewCode
	function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		if(comboObj.GetSelectText().length < 4) {
			comboObj.SetSelectText("");
			ComSetFocus(comboObj);
			return;
		}
		search_combo1(comboObj, NewIndex, NewCode , NewText);
	}
	
	function combo1_OnBlur(comboObj) {
		var formObj=document.form;
		var sIndexCode=comboObj.GetSelectIndex();
		var sText=comboObj.GetSelectText();
		if(sIndexCode == -1) {
			comboObj.SetSelectText("");
			ComSetObjValue(formObj.dmdt_trf_nm, "");
		}
	}	
	
	function search_combo1(comboObj, searchIndex, searchText, NewText) {
		var formObj=document.form;
		if (comboObj.GetSelectText().length == 0 ){
			ComSetObjValue(formObj.dmdt_trf_nm, "");
			comboObj.SetSelectText("");
			ComSetFocus(comboObj);
			return;
		}
		ComSetObjValue(formObj.dmdt_trf_nm, searchText);	//To show the text column
		
		var tariffType=NewText;
		if (tariffType == "DMOF" || tariffType == "DTOC" || tariffType == "CTOC" ) {
			OriginDest.innerHTML=DESTINATION;
		}
		
		else if (tariffType == "DMIF" || tariffType == "DTIC" || tariffType == "CTIC" || tariffType == ""){
			OriginDest.innerHTML=ORIGIN;
		}
		
	}
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo1(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	
	
	/*
	 * Changes Continent Search Field, if it's part of Country, Region or State functions that query information
	 */		
	function combo2_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code ){
		search_combo2(comboObj, Index_Code, Text);
	}
	
	
	function search_combo2(comboObj, searchIndex, searchText) {
		
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location initialization
		clearLocation1();
	}
	
	
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo2(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
	function combo3_OnChange(comboObj, Index_Code, Text) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive)	return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region.innerHTML="State";
		} else {
			Region.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		//Continent 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
		//Location initialization
		clearLocation1();
	}
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo3(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		var region_len=comboObj.GetSelectText().length ;
		if (region_len == 0)	return;
		if (isNoChangeActive)	return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(region_len == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive=false;
	}
	function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo4(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Location Search Field, if entered in the Enter Key, Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function checkLocation1(obj) {
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				Region.innerHTML="State";
	    			}else{
	    				Region.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
	/*
	 * Changes Continent Search Field, if it's part of Country, Region or State functions that query information
	 */		
	function combo5_OnChange(comboObj, Index_Code, Text) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
	}
	function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo5(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
	function combo6_OnChange(comboObj, Index_Code, Text) {
		search_combo6(comboObj, Index_Code, Text);
	}
	function search_combo6(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) 			return;
		if (comboObj.GetSelectText().length == 0 ) return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region2.innerHTML="State";
		} else {
			Region2.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		//Continent 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
	}
	function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo6(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function combo7_OnChange(comboObj, Index_Code, Text) {
		search_combo7(comboObj, Index_Code, Text);
	}
	function search_combo7(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) 			return;
		if (comboObj.GetSelectText().length == 0)	return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(comboObj.GetSelectText().length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive=false;
	}
	function combo7_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo7(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 * Location Search Field, if entered in the Enter Key, Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function checkLocation2(obj) {
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				Region2.innerHTML="State";
	    			}else{
	    				Region2.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
	function clearObjectValue(obj) {
		switch(ComGetEvent("name")) {
			case "cvrg_location":
			case "org_dest_location":
				obj.value="";
				break;
			default:
				obj.SetSelectText("");
				break;
		}
	}
    /**
     * sheet 1 pop up click
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnPopupClick(sheetObj, row, col){
  		switch (sheetObj.ColSaveName(col)) {
      		case "cmdt_cd" :
      			var param="?cmdt_cd=" + sheetObj.GetCellValue(row, col);
      			param += "&cmdt_nm=" + sheetObj.GetCellValue(row, col+1);
      			param += "&rep_cmdt_cd=" + sheetObj.GetCellValue(row, col+2);
  				param += "&rep_imdg_lvl_cd=" 
      			ComOpenPopup("COM_ENS_011.do" + param, 780, 470, "getCOM_ENS_011",'1,0,1,1,1', true, false, row, col, 0);
  			    break
  		}
  	}
    //balloon message
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){ 
    	with(sheetObj) {
    		var Row = MouseRow();
    		var Col = MouseCol();
    		if (Row==0 || Row==1) {
    			if (Col == 6) {
    				SetToolTipText(Row, Col, "Effective Date");
    			}
    			else if (Col == 7) {
    				SetToolTipText(Row, Col, "Expiration Date");    				
    			}
    			else {
    				SetToolTipText(Row, Col, "");
    			}
    		}
    		else {
    			SetToolTipText(Row, Col, "");
    		}
    	}
    }
    /**
     * Rep. Select pop-up window Return Value Commodity
     */
    function getCOM_ENS_011(aryPopupData, row, col, sheetIdx){
    	var sheetObject=sheetObjects[0];
		sheetObject.SetCellValue(row, col,aryPopupData[0][2],0);
		sheetObject.SetCellValue(row, "cmdt_nm",aryPopupData[0][3],0);
		sheetObject.SetCellValue(row, "rep_cmdt_cd",aryPopupData[0][4],0);
    }
    function sheet1_OnAfterEdit(sheetObj, row, col) {
    	var formObj=document.form;
    	var sName=sheetObj.ColSaveName(col);
var sValue=sheetObj.GetCellValue(row, col);
    	if(sName == "eff_dt") {
    		if(ComIsDate(sValue, "ymd")) {
//    			var iDay = ComGetDaysBetween(ComGetObjValue(formObj.today), sValue);
//    			if(iDay <= 0 ) {
//    				ComShowMessage(ComGetMsg("COM12133", "Effective Date", "greater", "Today"));
//    				sheetObj.SelectCell(row, col);
//        			sheetObj.CellValue2(row, col) = "";
//    			}
    		}else{
    			ComShowMessage(ComGetMsg("COM12132"));
    			sheetObj.SelectCell(row, col);
    			sheetObj.SetCellValue(row, col,"",0);
    		}
    	} else if(sName == "exp_dt") {
    		if(sValue != "") {
    			var iDay;
    			//exp_dt validation check
    			if(ComIsDate(sValue, "ymd")) {
//        			iDay = ComGetDaysBetween(ComGetObjValue(formObj.today), sValue);
//        			if(iDay <= 0 ) {
//        				ComShowMessage(ComGetMsg("COM12133", "Expiration Date", "greater", "Today"));
//        				sheetObj.SelectCell(row, col);
//            			sheetObj.CellValue2(row, col) = "";
//            			return;
//        			}
        		}else{
        			ComShowMessage(ComGetMsg("COM12132"));
        			sheetObj.SelectCell(row, col);
        			sheetObj.SetCellValue(row, col,"",0);
        			return;
        		}
    			//eff_dt, exp_dt validation check
    			iDay=ComGetDaysBetween(sheetObj.GetCellValue(row, "eff_dt"), sheetObj.GetCellValue(row, "exp_dt"));
    			if(iDay < 0 ) {
    			    ComShowMessage(ComGetMsg("DMT01089", "Expiration Date", "Effective Date"));
        			sheetObj.SelectCell(row, col);
        			sheetObj.SetCellValue(row, col,"",0);
        			return;
    			}
    		}
    	} else if(sName == "cmdt_ttl_dys") {
    		if(sValue== "" && sheetObj.GetCellValue(row, "cmdt_add_dys") == "") {
				ComShowMessage(ComGetMsg("COM12138", "cmdt_add_dys", "cmdt_ttl_dys"));
    			sheetObj.SelectCell(row, col);
    			sheetObj.SetCellValue(row, col,"",0);
    		}
    	}
    }
    function sheet1_OnSearchEnd(sheetObj, code, message) {
    	if(message != "") {
    		DisableControls();
    	}else{
    		EnableControls();
    		//Org Data Copy
    		for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++) {
				sheetObj.SetCellValue(i, "org_cmdt_cd",sheetObj.GetCellValue(i, "cmdt_cd"),0);
				sheetObj.SetCellValue(i, "org_eff_dt",sheetObj.GetCellValue(i, "eff_dt"),0);
				sheetObj.SetCellValue(i, "org_exp_dt",sheetObj.GetCellValue(i, "exp_dt"),0);
				sheetObj.SetCellValue(i, "org_cmdt_add_dys",sheetObj.GetCellValue(i, "cmdt_add_dys"),0);
				sheetObj.SetCellValue(i, "org_cmdt_ttl_dys",sheetObj.GetCellValue(i, "cmdt_ttl_dys"),0);
				sheetObj.SetCellValue(i, "org_xcld_sat_flg",sheetObj.GetCellValue(i, "xcld_sat_flg"),0);
				sheetObj.SetCellValue(i, "org_xcld_sun_flg",sheetObj.GetCellValue(i, "xcld_sun_flg"),0);
				sheetObj.SetCellValue(i, "org_xcld_hol_flg",sheetObj.GetCellValue(i, "xcld_hol_flg"),0);
    			sheetObj.SetRowStatus(i,"R");
    		}
    	}
    }
	/**
     * After saving handling
     */
    function sheet1_OnSaveEnd(sheetObj,  code, ErrMsg){
		var formObj=document.form;
		//ComOpenWait End
        ComOpenWait(false);
		 if(ErrMsg != '') {	// Error when saving
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		 }
    }
    function EnableControls() {
		var formObj=document.form;
		ComEnableObject(formObj.cvrg_location, false);
		ComEnableObject(formObj.org_dest_location, false);
		formObj.cvrg_location.className="input2";
		formObj.org_dest_location.className="input2";
		for(var i=0 ; i < comboObjects.length ; i++) {
			comboObjects[i].SetEnable(0);
		}
    	ComBtnEnable("btn_RowAdd");
    	ComBtnEnable("btn_RowCopy");
    	ComBtnEnable("btn_Delete");
    	ComBtnEnable("btn_Update");
    	ComBtnEnable("btn_Expire");
    	ComBtnEnable("btn_Save");
    	ComBtnEnable("btn_DownExcel");
    }
    function DisableControls() {
		var formObj=document.form;
		ComEnableObject(formObj.cvrg_location, true);
		ComEnableObject(formObj.org_dest_location, true);
		formObj.cvrg_location.className="input";
		formObj.org_dest_location.className="input";
		for(var i=0 ; i < comboObjects.length ; i++) {
			comboObjects[i].SetEnable(1);
		}
    	ComBtnDisable("btn_RowAdd");
    	ComBtnDisable("btn_RowCopy");
    	ComBtnDisable("btn_Delete");
    	ComBtnDisable("btn_Update");
    	ComBtnDisable("btn_Expire");
    	ComBtnDisable("btn_Save");
    	ComBtnDisable("btn_DownExcel");
    }
	// Search criteria field data retrieval Combo
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var index_1=0;
		var index_2=0;
		var index_3=0;
		switch(sAction) {
           case IBSEARCH:      // Search
        	   if (sheetObj.id == "sheet1") {
        		   //3.After handling Retrieving results
        		   var comboDatas;
        		   var comboItems;
        		   switch(sComboAction) {
		               	case SEARCHLIST07:
		               		//1.Inquiry ago, the parameter is set to a value type or allows selected.
		               		ComSetObjValue(formObj.f_cmd, SEARCHLIST07); 
		               		//2.Inquiry as a query is run conditions                 
		               		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		               		//TARIFF LIST
		               		comboItems=ComGetEtcData(sXml, COMMON_TARIFF_CD).split(ROWMARK);	
		               		addComboItem(comboObjects[0], comboItems);
		               		//Coverage Continent
		               		comboDatas=ComGetEtcData(sXml, CONTINENT);
		               		if (comboDatas != undefined) {
		               			comboItems=comboDatas.split(ROWMARK);
		               			//Change the selection to a usable state
		               			comboObjects[1].SetSelectCode("-1");
		               			comboObjects[1].RemoveAll();
		               			addComboItem(comboObjects[1],comboItems);
		               		}
		               		//Coverage Country 
		               		comboDatas=ComGetEtcData(sXml, COUNTRY);
		               		if (comboDatas != undefined) {
		               			comboItems=comboDatas.split(ROWMARK);
		               			comboObjects[2].SetSelectCode("-1");
		               			comboObjects[2].RemoveAll();
		               			addComboItem(comboObjects[2],comboItems); //COUNTRY
		               		}
		               		//Coverage Region
		               		comboDatas=ComGetEtcData(sXml, REGION);
		               		if (comboDatas != undefined) {
		               			comboItems=comboDatas.split(ROWMARK);
		               			comboObjects[3].SetSelectCode("-1");
		               			comboObjects[3].RemoveAll();
		               			addComboItem(comboObjects[3],comboItems); //Region
		               		}
		               		//Coverage Continent
		               		comboDatas=ComGetEtcData(sXml, CONTINENT);
		               		if (comboDatas != undefined) {
		               			comboItems=comboDatas.split(ROWMARK);
		               			//Change the selection to a usable state
		               			comboObjects[4].SetSelectCode("-1");
		               			comboObjects[4].RemoveAll();
		               			addComboItem(comboObjects[4],comboItems);
	                        }
		               		//Coverage Country 
		               		comboDatas=ComGetEtcData(sXml, COUNTRY);
	                        if (comboDatas != undefined) {
	                        	comboItems=comboDatas.split(ROWMARK);
	                        	comboObjects[5].SetSelectCode("-1");
	                        	comboObjects[5].RemoveAll();
	                        	addComboItem(comboObjects[5],comboItems); //COUNTRY
	                        }
	                        //Coverage Region
	                        comboDatas=ComGetEtcData(sXml, REGION);
	                        if (comboDatas != undefined) {
	                        	comboItems=comboDatas.split(ROWMARK);
	                        	comboObjects[6].SetSelectCode("-1");
	                        	comboObjects[6].RemoveAll();
	                        	addComboItem(comboObjects[6],comboItems); //Region
	                        }
		               		break;
        		   		//1. Tariff Type
						case SEARCHLIST:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
							break;							
						//1. CONTINENT LIST
						case SEARCH08:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH08);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo2") {
								index_1=1;
							} else {
								index_1=4;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3") {
								index_1=2;
							} else {
								index_1=5;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo4" || sObj.options.id == "combo2") {
								index_1=3;
							} else {
								index_1=6;
							} 
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//REGION
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4. Continent, CONTRY 
						case SEARCH06:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH06);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));

                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
							if(sObj_name == "combo2" || sObj_name == "combo4" || sObj_name == "cvrg_location") {
								index_1=2;
							}else{
								index_1=5;
							}
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									comboObjects[index_1].SetSelectCode("-1");
									comboObjects[index_1].RemoveAll();
									addComboItem(comboObjects[index_1],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//5. Search CONTINENT of Country
						case SEARCH12:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH12);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3") {
								index_1=1;
							} else {
								index_1=4;
							}
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if( comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//5. Corresponding changes at Country Region Information Inquiry
						case SEARCH03:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));

                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
							if(sObj_name == "combo3" || sObj_name == "combo4" || sObj_name == "cvrg_location") {
								index_1=2;
								index_2=3;
								clearLocation1();
							} else {
								index_1=5;
								index_2=6;
								clearLocation2();
							}
							if(comboObjects[index_1].GetSelectText()== "CA" || comboObjects[index_1].GetSelectText()== "US" ) {
								//State
								comboDatas=ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if(comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();				//Region
								addComboItem(comboObjects[index_2],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//6. State, Region at the time of change, the corresponding Continet, Country, State Lookup
						case SEARCH17:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH17);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo4") {
								index_1=1;
								index_2=2;
								index_3=3;
								clearLocation1();
							} else {
								index_1=4;
								index_2=5;
								index_3=6;
								clearLocation2();
							}
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								//Country List 
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									//Region/State List 
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH13:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH13);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo4") {
								index_1=1;
								index_2=2;
								index_3=3;
								clearLocation1();
							} else {
								index_1=4;
								index_2=5;
								index_3=6;
								clearLocation2();
							}
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								//Country List 
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									//Region/State List 
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4. Location, input Inquiry
						case SEARCH10:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH10);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var location=ComGetObjValue(sObj);
							if(sObj.name == "cvrg_location") {
								index_1=1;
								index_2=2;	//Location initialization
								index_3=3;
								clearLocation1();
							} else {
								index_1=4;
								index_2=5;
								index_3=6;
								clearLocation2();
							}
							//Continent 
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								//Continent Setting
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								//Country List 
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();					//Country
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									//Region/State List 
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
										comboDatas=ComGetEtcData(sXml, STATE);
					    			}else{
										comboDatas=ComGetEtcData(sXml, REGION);
					    			}
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
										//location setting
										ComSetObjValue(sObj, location);
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
					    		ComAlertFocus(sObj, ComGetMsg('DMT00110'));
								clearObjectValue(sObj);
							}
							break;
					}
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * add data  combo field 
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	/**
     * add data  combo field 
     */	
	function addComboItem2(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
    		comboObj.InsertItem(i, ComReplaceStr(comboItem[1],"^"," - ") , comboItem[0]);
    	}   		
	}
	/**
     * add data  combo field 
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
    	}   		
	}
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		//Tariff Type
		ComSetObjValue(formObj.sel_dmdt_trf_cd, comboObjects[0].GetSelectText());
		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, comboObjects[1].GetSelectText());
		ComSetObjValue(formObj.cvrg_cnt_cd, comboObjects[2].GetSelectText());
		
		if(Region.innerHTML == "State") {
			ComSetObjValue(formObj.cvrg_ste_cd, comboObjects[3].GetSelectText());
		}else{
			ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[3].GetSelectText());
		}
		
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[4].GetSelectText());
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[5].GetSelectText());
		
		if(Region2.innerHTML == "State") {
			ComSetObjValue(formObj.org_dest_ste_cd, comboObjects[6].GetSelectText());
		}else{
			ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[6].GetSelectText());
		}
		
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		//cnt_cd 
		ComSetObjValue(formObj.cnt_cd, comboObjects[2].GetSelectText());
	}
	/*
	 * Common code is Inquiry for Combo
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj=document.form;

        var sObj_name = "";
        if ( sObj.name == "cvrg_location" || sObj.name == "org_dest_location"){
        	sObj_name = sObj.name;
        } else {
        	sObj_name = sObj.options.id;
        }
        
		switch(sObj_name) {
			case "combo2":
			case "combo3":
			case "combo4":
			case "cvrg_location":
				//Coverage ComboSetting
				ComSetObjValue(formObj.conti_cd, comboObjects[1].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[2].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[3].GetSelectText());
				ComSetObjValue(formObj.ste_cd, comboObjects[3].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				break;
			case "combo5":
			case "combo6":
			case "combo7":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[4].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[5].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[6].GetSelectText());
				ComSetObjValue(formObj.ste_cd, comboObjects[6].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_location));
				break;	
		}
	}
    /**
     * Select the first item
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
	}	
	/*
	 * Initialize the query result information
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	/*
	 * Location Search Field initialization
	 */		
	function clearLocation1() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}
	/*
	 * Location Search Field initialization
	 */		
	function clearLocation2() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.org_dest_location, "");
	}
	/*
	 *  initializing
	 */		
	function initSearchControls() {
		var formObj=document.form;
		comboObjects[0].SetSelectCode("-1");
		comboObjects[0].RemoveAll();
		comboObjects[1].SetSelectCode("-1");
		comboObjects[1].RemoveAll();
		comboObjects[2].SetSelectCode("-1");
		comboObjects[2].RemoveAll();
		comboObjects[3].SetSelectCode("-1");
		comboObjects[3].RemoveAll();
		comboObjects[4].SetSelectCode("-1");
		comboObjects[4].RemoveAll();
		comboObjects[5].SetSelectCode("-1");
		comboObjects[5].RemoveAll();
		comboObjects[6].SetSelectCode("-1");
		comboObjects[6].RemoveAll();
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");
		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_ste_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_ste_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		ComSetObjValue(formObj.sel_dmdt_trf_cd, "");
		ComSetObjValue(formObj.dmdt_trf_nm, "");
		Region.innerHTML="Region";
		Region2.innerHTML="Region";
	}		
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		initSearchControls();
		initResultControls();
	 	//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    var formObj=document.form;
	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);		//1
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[1]);		//2
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[2]);			//3
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[3]);		//4
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[4]);		//5
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[5]);			//6
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[6]);	//7	    
	}	
    function sheet1_OnChange( sheetObj , Row , Col , Value ) {
        if ( Col == 3 ) {
//        alert("Row [" + Row + "] Col [" + Col + "] Value [" + Value + "]");
            if ( Value == "" ) {
                sheetObjects[0].SetCellValue( Row, 3 ,"",0);
                sheetObjects[0].SetCellValue( Row, 4 ,"",0);
                sheetObjects[0].SetCellValue( Row, 5 ,"",0);
                return false;
            } else {
                document.form.cmdt_cd.value=Value;
                document.form.cmdt_row.value=Row;
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);                
            }
        }
    }
