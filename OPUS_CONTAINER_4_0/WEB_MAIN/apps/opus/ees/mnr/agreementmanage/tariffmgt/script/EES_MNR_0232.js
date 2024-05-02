/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName :  EES_MNR_0232.js
*@FileTitle : Disposal Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0232 : EES_MNR_0232 - Defining a script used by screen
     */
    function EES_MNR_0232() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.obj_blur=obj_blur;
    	this.obj_focus=obj_focus;
    	this.obj_change=obj_change;
    	this.obj_keypress=obj_keypress;
    	this.obj_keyup=obj_keyup;
    	this.obj_keydown=obj_keydown;
    	this.doActionIBSheet=doActionIBSheet;
    	this.openPopup=openPopup;
    	this.setPopData_Currency=setPopData_Currency;
    	this.validateForm=validateForm;
    	this.clearForm=clearForm;
    }
   	/* Developer's task	*/
   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR="99FFFF";
	var MNR_TOTCOL_BACK_COLOR="C9D5EB";
	var cntrTpSz=new Array();
	var chssTpSz=new Array();
	var gsetTpSz=new Array();
	var vCntrTpszHdr="| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz=vCntrTpszHdr.split("|");
	var vCntrTpszCnt=vArrCntrTpsz.length;
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick() {
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        var sheetObject5=sheetObjects[4];
        var tabObj=tabObjects[0];
        /*******************************************************/
        var formObj=document.form;
     	try {
 			var srcName=ComGetEvent("name");
 			if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;
 				case "btn_New":
 					ComResetAll();
					setDynamicEqTpszHeader(sheetObjects[0], "U");
					formObj.p_loc_cd.ReadOnly=true;
					formObj.p_loc_cd.className="input2";
					ComEnableObject(formObj.btns_search, false);
					for(i=0; i < sheetObjects.length; i++) {
						sheetObjects[i].SetCellText(0, "rcc_cd" ,"RCC");
					}
					for(var i=0; i < tabObj.GetCount(); i++) {
						tabObj.SetTabDisable(i, false);
					}
					tabObj.SetSelectedIndex(0);
					ComSetFocus(formObj.p_trf_eff_yr);
					formObj.p_trf_eff_qtr_no.selectedIndex = 0;
 					break;
 				case "btns_calendar1":
 					var cal=new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObj.p_trf_eff_yr, 'yyyy');
             	 	break;
             	case "btns_search":	//Form Location. Retrieving pop-up
 					openPopup("1");
 					break;
             	case "btn_DownExcel1":
             	case "btn_DownExcel2":
             	case "btn_DownExcel3":
             	case "btn_DownExcel4":
             		if(sheetObject5.RowCount() < 1){//no data
             			ComShowCodeMessage("COM132501");
             		}else{
             			sheetObject5.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject5), SheetDesign:1,Merge:1 });
             		}             		
					break;
 			} // end switch
     	} catch(e) {
     		if(e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	var formObj=document.form;
		for(i=0; i < sheetObjects.length; i++) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* IBTab Initializing */
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
		ComSetFocus(formObj.p_trf_eff_yr);
    	ComEnableObject(formObj.btns_search, false);
    	for(i=0; i < sheetObjects.length; i++) {
    		sheetObjects[i].SetCellText(0, "rcc_cd" ,"RCC");
    	}
    }
    /**
	 * Event handling of OnLoadFinish of t1sheet1
	 */

    // Axon event handling
  	// 1. catching event
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj);
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj);
//  	axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',   		'obj_change',  	formObj);
  	}
	//Prevent duplicate events
	var preEventType=null;
  	// 2. Event-handling functions -- Start
  	/**
	 * Event handling of blur of elements
	 **/
	function obj_blur() {
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")) {
	    	case "p_trf_eff_yr":
  				//Validation checking of total length, format, max value, min value, etc
	            ComChkObjValid(obj, true, false, false);
	    		break;
	        default: //do nothing
	        	ComChkObjValid(obj);
	        	break;
	    }
	}
	/**
	 * Event handling of focus of elements
	 */
	function obj_focus() {
		var obj=ConGetEvent();
	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//Clearing separator
		    ComClearSeparator(obj);
	    }
	}
	/**
	 * Event handlling of change of elements
	 */
	function obj_change() {
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var tabObj=tabObjects[0];
		switch(ComGetEvent("name")) {
			case "p_trf_eff_qtr_no":	//Effective Quarter
				for(var i=0; i < tabObj.GetCount(); i++) {
					if(obj.value == "") {
						tabObj.SetTabDisable(i, false);
					} else {					
						tabObj.SetTabDisable(i, obj.value != i + 1)
					}
				}
				if(obj.value == "") {
					tabObj.SetSelectedIndex(0);
				} else {
					tabObj.SetSelectedIndex(obj.value -1);
				}
				break;
			case "p_eq_knd_cd":			//Equipment Type
				for(i=0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
				setDynamicEqTpszHeader(sheetObjects[0], obj.value);
				break;
			case "p_loc_tp":			//Location Type
				formObj.p_loc_cd.value="";
				if(obj.value == "0") {
					formObj.p_loc_cd.readOnly=true;
					formObj.p_loc_cd.className="input2";
					ComEnableObject(formObj.btns_search, false);
					for(i=0; i < sheetObjects.length; i++) {
						sheetObjects[i].SetCellText(0, "rcc_cd" ,"RCC");
					}
				} else {
					formObj.p_loc_cd.readOnly=false;
					formObj.p_loc_cd.className="input";
					ComEnableObject(formObj.btns_search, true);
					ComSetNextFocus(obj);
					for(i=0; i < sheetObjects.length; i++) {
						if(obj.value == "1") {
							sheetObjects[i].SetCellText(0, "rcc_cd" ,"LCC");
						} else if(obj.value == "2") {
							sheetObjects[i].SetCellText(0, "rcc_cd" ,"SCC");
						}
					}
				}
				break;
			case "p_loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
		}
	}
	/**
	 * Event handling of keypress of elements
	 */
  	
  	/**
  	 * Event handling of keyup of elements
  	 */
  
   	/**
     * Event handling of keydown of elements
     */   
  	//2. Event-handling functions -- End
	/**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
	                var cnt=0 ;
					InsertItem( "1/4 Quarter" , "");
					InsertItem( "2/4 Quarter" , "");
					InsertItem( "3/4 Quarter" , "");
					InsertItem( "4/4 Quarter" , "");
                }
             break;
         }
    }
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	
    	//--------------- Important logic --------------------------//
    	 for(var i = 0; i<objs.length; i++){
			  if(i != nItem){
			   objs[i].style.display="none";
			   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
			  }
		}
    	//------------------------------------------------------//    	    	
    	beforetab=nItem;
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj, sheetNo) {
    	var formObj=document.form;
		var sheetid=sheetObj.id;
		var cnt=0;
		switch(sheetid) {
			case "t1sheet1":
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
		          with(sheetObj){
						var HeadTitle="||Quarter|||RCC|LOC|Currency"+ vCntrTpszHdr;
					   	var headCount=ComCountHeadTitle(HeadTitle);
					   	var vDataType=sheetid == "t5sheet1" ? dtData : dtHidden;
					
					   	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:8, DataRowMerge:0 } );
					
					   	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					   	var headers = [ { Text:HeadTitle, Align:"Center"} ];
					   	InitHeaders(headers, info);
					
				   		var cols = [ {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_eff_yr",      KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_eff_qtr_no",  KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_eff_qtr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"" } ];
				   		for(var i = 1; i < vCntrTpszCnt; i++) {
				   			var tpsz_dp_no = "tpsz_dp"+ ComLpad(i, 2, "0");
				   			cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:tpsz_dp_no,        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
				   			if(vArrCntrTpsz[i] != "") {
//				   				eval('GetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
				   				GetColHidden(tpsz_dp_no,0);
						   } else {
//							   	eval('GetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
							   	GetColHidden(tpsz_dp_no,2);
						   	}
				   		}					
				       SetCountFormat("[SELECTDATAROW / TOTALROWS]");
				       InitColumns(cols);						
				       SetEditable(0);				   
//				       SetSheetHeight(410);
				       resizeSheet( sheetObj );
				   }
			break;
		}
	}
	/**
	 * Sheet processing-related processes
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCREATE:
				//Equipment Type/Size Grid Header Item Setting
				initDynamicEqTpszCd(sheetObj);
				setDynamicEqTpszHeader(sheetObj, formObj.p_eq_knd_cd.value);
				break;
			case IBSEARCH:			//Retrieving
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "t1sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("EES_MNR_0232GS.do" , FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
				        for( var i=0 ; i < arrXml.length ; i++ ){
				            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
//				            setDynamicTabSheetsHeader(sheetObjects[i]);
				        }
						ComOpenWait(false);
						sheetObj.SetWaitImageVisible(1);
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// Location Retrieving
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "t1sheet1") {
						var vLocType=formObj.p_loc_tp.value;
						var vLocCode=formObj.p_loc_cd.value;
 						var param="f_cmd="+SEARCH+"&loc_cd=&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&loc_state=";
 						if(vLocType == "1") {//p_loc_tp is 'RCC'
							param += "&rcc_cd="+ vLocCode +"&lcc_cd=";
 						} else {//p_loc_tp is 'LCC'
							param += "&rcc_cd=&lcc_cd="+ vLocCode;
 						}
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_051GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) < 1 ) {
							ComShowCodeMessage("MNR00117");
 							formObj.p_loc_cd.value="";
							ComSetFocus(formObj.p_loc_cd);
						}
					}
				}
 				break;
		}
    }
	/**
	 * Calling function when finished retrieve
	 * @param sheetObj
	 * @param ErrMsg
     */
    function setDynamicTabSheetsHeader(sheetObj) {
    	with(sheetObj) {
    		var formObj=document.form;
			var viewCnt=0;
			if(LastRow()> HeaderRows()) {
				for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
					var cellData=eval('GetCellValue(LastRow(), "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					if(cellData <= 0) {
						eval('SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
					}
				}
				for(var i=0; i <= SearchRows(); i++) {
					if(GetCellValue(i, "loc_cd") == "AVG.") {
						SetRowBackColor(i,MNR_TOTCOL_BACK_COLOR);
					}
					if(sheetObj.id == "t5sheet1" && GetCellValue(i, "rcc_cd") == "") {
						SetRowHidden(i,1);
					}
				}
				SetRowHidden(LastRow(),1);
			}
    	}
    }
	/**
     * Pop-up Open<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row The object is row index in case of IBSheet
     * @param Col The object is column index in case of IBSheet
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.p_loc_tp.value) {
    			case "1" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 490,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 490,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	}
    	return;
    }
	/**
	 * Assigning each array by EQ_TYPE size
	 */
	function initDynamicEqTpszCd(sheetObj) {
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind","");
		if(arrXml != null) {
			for(var i=0; i < arrXml.length; i++) {
				if(i == 0){//U
					cntrTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){//Z
					chssTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){//G
					gsetTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}
	/**
	 * Equipment Type/Size Grid Header Setting
	 */
	function setDynamicEqTpszHeader(sheetObj, eqKndCd) {
		var eqTpSzAry=new Array();
		if(eqKndCd == "U") {
			eqTpSzAry=cntrTpSz;
		} else if(eqKndCd == "Z") {
			eqTpSzAry=chssTpSz;
		} else {//eqKndCd is 'G'
			eqTpSzAry=gsetTpSz;
		}
		if(eqTpSzAry.length > 0) {
			var eqTpSzStr="|"+ eqTpSzAry.toString().replace(/,/g, "|");
			vCntrTpszHdr=eqTpSzStr;
			vArrCntrTpsz=eqTpSzStr.split("|");
			vCntrTpszCnt=vArrCntrTpsz.length;
			for(i=0; i < sheetObjects.length; i++) {
				/* Resetting IBSheet */
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i], i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
		}
	}
    /**
	 * Validating process for input form data
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //Retrieving
					if(formObj.p_trf_eff_yr.value == "") {
						ComShowCodeMessage("MNR00172", "Effective Year");
						ComSetFocus(formObj.p_trf_eff_yr);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}
        return true;
	}
  	/**
	 * Clearing form elements<br>
	 * @param fieldName
	 * @deprecated 2009.06.22
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			default :	//do nothing
		}
	}
	
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setDynamicTabSheetsHeader(sheetObj);
	}
	
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setDynamicTabSheetsHeader(sheetObj);
	}
	
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setDynamicTabSheetsHeader(sheetObj);
	}
	
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setDynamicTabSheetsHeader(sheetObj);
	}
	
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setDynamicTabSheetsHeader(sheetObj);
	}
	/* End of developer's task */
