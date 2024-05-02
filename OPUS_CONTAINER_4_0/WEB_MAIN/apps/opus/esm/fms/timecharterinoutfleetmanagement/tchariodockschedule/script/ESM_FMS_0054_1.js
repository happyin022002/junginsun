/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0054_1.js
*@FileTitle  : D/dock Schedule Input
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
     * @class esm_fms_0054_1 : esm_fms_0054_1 definition of biz script for creation screen
     */
//    function esm_fms_0054_1() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    //no support[check again]CLT 	this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    	this.sheet1_OnValidation=sheet1_OnValidation;
//    	this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
//    }
	//  common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
          	switch(srcName) {
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					ComResetAll();
					inputReadOnly("New");
                break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
				case "btn_savetofile":
					if(sheetObject.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
					}	
                break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "phs_out_dt");
					sheetObject.SetCellValue(row, "dck_dur_dys_days","Days");
					sheetObject.SetCellValue(row, "dck_fm_dt_time","0000");
					sheetObject.SetCellValue(row, "dck_to_dt_time","0000");
					sheetObject.SetCellValue(row,"vsl_cd",formObject.vsl_cd.value);
					sheetObject.SetCellValue(row,"dck_sel_cd",formObject.dck_sel_cd.value);
                break;
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert();
					sheetObject.SelectCell(row, "phs_out_dt");
					sheetObject.SetCellValue(row, "dck_dur_dys_days","Days");
					sheetObject.SetCellValue(row, "dck_fm_dt_time","0000");
					sheetObject.SetCellValue(row, "dck_to_dt_time","0000");
					sheetObject.SetCellValue(row,"vsl_cd",formObject.vsl_cd.value);
					sheetObject.SetCellValue(row,"dck_sel_cd",formObject.dck_sel_cd.value);
					break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0022");
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
	 * Insering Vessel Code<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			
	}
    /**
     * Only insert English/Numeric by onkeypress Event of HTML Control <br>
     **/
//    function eng_keypress() {
//        ComKeyOnlyAlphabet('upper');
//    }
     /**
      * Only insert English/Numeric by onkeypress Event of HTML Control <br>
      **/
//     function engnum_keypress() {
//         ComKeyOnlyAlphabet('uppernum');
//     }
    /**
     * Getting Name when changing VslCd <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value="";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    /**
    * Registering IBSheet Object as Array
    * In case there is needs to do batch processing, process saving as Array can be added
    * defining array on the top of source
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
    	$('#vsl_cd').on('blur', function(){
    		vsl_cd_change();
    	});
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
     * Adding first-served function
     */
	function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="/";
        //Axon Event Handling1. Event catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- Code handling to OnBeforeDeactivate(blur) Event of All Controls
//        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- Code handling to onkeypress Event of All Controls having dateformat attribute
//        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Input only Upper case English when inserting Veesel Code
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Getting Name information after inserting Vessel Code
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
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
            case 1:     //sheet1 init
                with(sheetObj){
//		              (21, 0, 0, true);
		              var HeadTitle="|Sel|Seq|Status|Phased Out|PO Port|From D/Dock Date|From D/Dock Date|To D/Dock Date|To D/Dock Date|Dock LOC|Duration|Duration|Yard|Phased In|PI Port|Dry Dock Type|Yd Seq";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"Combo",     Hidden:0, Width:71,   Align:"Center",  ColMerge:0,   SaveName:"flet_dck_sts_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"phs_out_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:66,   Align:"Center",  ColMerge:0,   SaveName:"phs_out_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,InputCaseSensitive:1,AcceptKeys:"E|N" },
		                     {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"dck_fm_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dck_fm_dt_time",       KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"dck_to_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dck_to_dt_time",       KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"dck_loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,   EditLen:5,InputCaseSensitive:1,AcceptKeys:"E|N" },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dck_dur_dys",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dck_dur_dys_days",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Popup",     Hidden:0, Width:115,  Align:"Left",    ColMerge:0,   SaveName:"shp_yd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"phs_in_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:63,   Align:"Center",  ColMerge:0,   SaveName:"phs_in_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,   EditLen:5,InputCaseSensitive:1,AcceptKeys:"E|N" },
		                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"flet_dck_svey_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dck_sel_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dck_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"yd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetDataLinkMouse("phs_out_port_cd",1);
		              SetDataLinkMouse("dck_loc_cd",1);
		              SetDataLinkMouse("phs_in_port_cd",1);
		              SetDataLinkMouse("shp_yd_nm",1);
		              SetUseDefaultTime(0);
//		              SetSheetHeight(430);
		              resizeSheet();
              }
             break;
        }
    }
    // Handling Sheet Process
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:     
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH;
 	        	   	sheetObj.DoSearch("ESM_FMS_0054_1GS.do", FormQueryString(formObj) );
	  	   	  		inputReadOnly("Search");
	  	   	  	}	
                break;
           	case IBSAVE:       
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
	           	var arrSheets=new Array(sheetObj);
				var sParam=ComGetSaveString(arrSheets);
				if (sheetObj.IsDataModified()&& sParam == "") {
					return; 
				}
	 			formObj.f_cmd.value=MULTI;
	 			sheetObj.DoSave("ESM_FMS_0054_1GS.do", FormQueryString(formObj));
                break;
			case IBROWSEARCH:   
				if (Col == "ComCd") {//Status, Dry Dock Type
					formObj.f_cmd.value=SEARCH02;
		   			CoFmsGetCombo("GRID", formObj, sheetObj, "CD01747:CD01748","flet_dck_sts_cd:flet_dck_svey_tp_cd", "flet_dck_sts_cd_text:flet_dck_svey_tp_cd_text");
	    		} else if (Col == "phs_out_port_cd" || Col == "dck_loc_cd" || Col == "phs_in_port_cd") {
					formObj.f_cmd.value=SEARCH04;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj)+"&loc_cd="+sheetObj.GetCellValue(Row,Col));
	    			chkPortCode(sheetObj, sXml, Row, Col);
	    		} else if (Col == "vsl_cd") {
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
				}	
        }
    }
    /**
     * Screen handling by Event <br>
     * @param {String} flag     	Event Separator
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly=false;
//	    	document.images["btn_vslpop"].name="btn_vslpop";
	    	form.btn_vslpop.name="btn_vslpop";
	    	form.btn_vslpop.style.cursor="hand";
    	} else {
	    	if(sheetObjects[0].RowCount()== 1 || flag == "Search") {
		    	form.vsl_cd.readOnly=true;
//		    	document.images["btn_vslpop"].name="no_btn_vslpop";
		    	form.btn_vslpop.name="no_btn_vslpop";
		    	form.btn_vslpop.style.cursor="default";
	    	}
    	}
    }
     /**
      * In case input value is changed
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value) {
 			if (sheetObj.ColSaveName(Col) == "phs_out_port_cd" || sheetObj.ColSaveName(Col) == "dck_loc_cd"
 				|| sheetObj.ColSaveName(Col) == "phs_in_port_cd") {
        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, sheetObj.ColSaveName(Col), Row);
 			} else if (sheetObj.ColSaveName(Col) == "flet_dck_sts_cd") {
 				if (Value == 'E') {
					sheetObj.SetCellEditable(Row, "dck_fm_dt_time",0);
					sheetObj.SetCellEditable(Row, "dck_to_dt_time",0);
					sheetObj.SetCellValue(Row, "dck_fm_dt_time","0000");
					sheetObj.SetCellValue(Row, "dck_to_dt_time","0000");
 				} else {
					sheetObj.SetCellEditable(Row, "dck_fm_dt_time",1);
					sheetObj.SetCellEditable(Row, "dck_to_dt_time",1);
					sheetObj.SetCellValue(Row, "dck_fm_dt_time","");
					sheetObj.SetCellValue(Row, "dck_to_dt_time","");
 				}
 			} else if (sheetObj.ColSaveName(Col) == "phs_out_dt") {
 				if (sheetObj.GetCellValue(Row, "dck_fm_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "dck_fm_dt") < Value) {
 						ComShowCodeMessage('FMS01708');
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			} else if (sheetObj.ColSaveName(Col) == "dck_fm_dt") {
 				if (sheetObj.GetCellValue(Row, "dck_to_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "dck_to_dt") < Value) {
 						ComShowCodeMessage('FMS01709');
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 				if (sheetObj.GetCellValue(Row, "phs_out_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "phs_out_dt") > Value) {
 						ComShowCodeMessage('FMS01710');
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			} else if (sheetObj.ColSaveName(Col) == "dck_to_dt") {
 				if (sheetObj.GetCellValue(Row, "dck_fm_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "dck_fm_dt") > Value) {
 						ComShowCodeMessage('FMS01711');
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 				if (sheetObj.GetCellValue(Row, "phs_in_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "phs_in_dt") < Value) {
 						ComShowCodeMessage('FMS01712');
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			} else if (sheetObj.ColSaveName(Col) == "phs_in_dt") {
 				if (sheetObj.GetCellValue(Row, "dck_to_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "dck_to_dt") > Value) {
 						ComShowCodeMessage('FMS01713');
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			}
 			var frmDt = sheetObj.GetCellValue(Row, 'dck_fm_dt');
 			var toDt = sheetObj.GetCellValue(Row, 'dck_to_dt');
 			if (frmDt != '' && toDt != '') {
 				sheetObj.SetCellValue(Row, 'dck_dur_dys', ComGetDaysBetween(frmDt, toDt));
 			}
	}
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow,NewCol) {
		if (sheetObj.ColSaveName(NewCol) == "dck_fm_dt_time" || sheetObj.ColSaveName(NewCol) == "dck_to_dt_time") {
			if (sheetObj.GetCellValue(NewRow, "flet_dck_sts_cd") == 'E') {
				sheetObj.SetCellEditable(NewRow, "dck_fm_dt_time",0);
				sheetObj.SetCellEditable(NewRow, "dck_to_dt_time",0);
			} else {
				sheetObj.SetCellEditable(NewRow, "dck_fm_dt_time",1);
				sheetObj.SetCellEditable(NewRow, "dck_to_dt_time",1);
			}
 		} 
	}
    /**
     * Checking Port Code <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Name of Type
     * @param {String}  comboCode   Code Value of Type
     * @param {int}  	col   		column index
     **/
    function chkPortCode(sheetObj, sXml, Row, Col) {
    	if (sXml != "" ) {
			if (ComGetEtcData(sXml, "cdName") != undefined) {
	    	} else {
				sheetObj.SetCellValue(Row,Col,'',0);
				ComShowCodeMessage("FMS01079");
				sheetObj.SelectCell(Row, Col);
	    	}
	    }		
    }
     /**
      * In case of clicking PopUp in IBSheep Object
      */
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
	{
		if (sheetObj.ColSaveName(Col) == "phs_out_port_cd") {
			ComOpenPopup("COM_ENS_051.do", 800, 600, "setPortCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "COM_ENS_051");
		} else if (sheetObj.ColSaveName(Col) == "dck_loc_cd") {
			ComOpenPopup("COM_ENS_051.do", 800, 600, "setPortCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "COM_ENS_051");
		} else if (sheetObj.ColSaveName(Col) == "phs_in_port_cd") {
			ComOpenPopup("COM_ENS_051.do", 820, 600, "setPortCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "COM_ENS_051");
		} else if(sheetObj.ColSaveName(Col) == "shp_yd_nm") {
			ComOpenPopup("ESM_FMS_0082.do", 450, 350, "setSheetYardName", "1,0,1,1,1,1", false, false, Row, Col, 0, "esm_fms_0082");
		}
	}
	/**
	* Inserting Port/Location <br>
	* @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	*/
	function setPortCd(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].SetCellValue(Row, Col,aryPopupData[0][3],0);
	}
	/**
	 * Inserting Vendor Code <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVendorCode(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].SetCellValue(Row,Col,aryPopupData[0][5],0);
		sheetObjects[0].SetCellValue(Row,"vndr_lgl_eng_nm",aryPopupData[0][3],0);
	}
	/**
	 * Setting Ship Yard Name and Sequence selected in Yard PopUp into Sheet<br>
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 */
    function setSheetYardName(aryPopupData, Row, Col, sheetIdx){
		 sheetObjects[0].SetCellValue(Row, "shp_yd_nm",aryPopupData[0][4],0);
		 sheetObjects[0].SetCellValue(Row, "yd_seq",aryPopupData[0][3],0);
    }
    /**
     * Handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        if (sAction == IBSAVE) {
			var sRow=sheetObj.FindStatusRow("I|U");
			var arrRow=sRow.split(";");
			var arrLen=arrRow.length-1;
			for (idx=0; idx<arrLen; idx++) { 
				if (sheetObj.GetCellValue(arrRow[idx], "flet_dck_sts_cd") == "C") {
					//Phased Out
					if (sheetObj.GetCellValue(arrRow[idx], "phs_out_dt") == "") {
						ComShowCodeMessage("FMS00004", "Phased Out");
						sheetObj.SelectCell(arrRow[idx], "phs_out_dt");
						return false;
					}
					//PO Port
					if (sheetObj.GetCellValue(arrRow[idx], "phs_out_port_cd") == "") {
						ComShowCodeMessage("FMS00004", "PO Port");
						sheetObj.SelectCell(arrRow[idx], "phs_out_port_cd");
						return false;
					}
					//Dock LOC
					if (sheetObj.GetCellValue(arrRow[idx], "dck_loc_cd") == "") {
						ComShowCodeMessage("FMS00004", "Dock LOC");
						sheetObj.SelectCell(arrRow[idx], "dck_loc_cd");
						return false;
					}
					//Phased In
					if (sheetObj.GetCellValue(arrRow[idx], "phs_in_dt") == "") {
						ComShowCodeMessage("FMS00004", "Phased In");
						sheetObj.SelectCell(arrRow[idx], "phs_in_dt");
						return false;
					}
					//PI Port
					if (sheetObj.GetCellValue(arrRow[idx], "phs_in_port_cd") == "") {
						ComShowCodeMessage("FMS00004", "PI Port");
						sheetObj.SelectCell(arrRow[idx], "phs_in_port_cd");
						return false;
					}
				}
			}
        }
        return true;
    }
    /**
     * Event called to check Validation just before saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Input value of sheetObj
     **/
 	function sheet1_OnValidation(sheetObj,row,col,value) {
 		var fromDate="";
 		var toDate="";
 		var dckFmDtCol=sheetObj.SaveNameCol("dck_fm_dt");
 		var dckFmDtValue=sheetObj.GetCellValue(row,dckFmDtCol);
		var dckFmDtTimeCol=sheetObj.SaveNameCol("dck_fm_dt_time");
		var dckFmDtTimeValue=sheetObj.GetCellValue(row,dckFmDtTimeCol);
		var dckToDtCol=sheetObj.SaveNameCol("dck_to_dt");
		var dckToDtValue=sheetObj.GetCellValue(row,dckToDtCol);
		var dckToDtTimeCol=sheetObj.SaveNameCol("dck_to_dt_time");
		var dckToDtTimeValue=sheetObj.GetCellValue(row,dckToDtTimeCol);
		// Checking To D/Dock Date >= From D/Dock Date 
		if(dckFmDtTimeValue != "" && dckToDtTimeValue != "") {
			fromDate=dckFmDtValue + dckFmDtTimeValue;
			toDate=dckToDtValue + dckToDtTimeValue;
			if(parseInt(fromDate) > parseInt(toDate)) {
				ComShowCodeMessage('FMS01709');
				sheetObj.SetCellValue(row,"dck_to_dt","",0);
				sheetObj.SetCellValue(row,"dck_to_dt_time","",0);
				sheetObj.SelectCell(row,"dck_to_dt");
				sheetObj.ValidateFail(true);
				return;
			}
		}
 	}
     /**
      * In case of clicking PopUp in IBSheep Object
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	}	
 	function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
 		 ComOpenWait(false);// always exist at first line
// 		 if(Code == 0){
// 		  ComShowCodeMessage("COM132601");
// 		}
 	}
 	
 	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	} 	
 	
