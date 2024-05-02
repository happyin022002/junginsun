/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0019.js
*@FileTitle  : NB Delivery Schedule Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class NB Delivery Schedule Creation : NB Delivery Schedule Creation definition of biz script for creation screen
     */

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
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		switch(srcName) {
     			case "btn_retrieve":
     				if(!initConfirm()) return;
     				if(form.btn_periodFlag[0].checked) {
     					form.periodFlag.value="date";
     					form.vslDeDt1.value=form.vslDeDate1.value.replace(/-/g,"");
     					form.vslDeDt2.value=form.vslDeDate2.value.replace(/-/g,"");
     				} else if(form.btn_periodFlag[1].checked) {
     					form.periodFlag.value="month";
     					form.vslDeDt1.value=form.vslDeMonth1.value.replace("-","");
     					form.vslDeDt2.value=form.vslDeMonth2.value.replace("-","");
     				} else if(form.btn_periodFlag[2].checked) {
     					form.periodFlag.value="year";
     					form.vslDeDt1.value=form.vslDeYear1.value;
     					form.vslDeDt2.value=form.vslDeYear2.value;
     				}
     				if(form.vslCdSize1.value != "" && form.vslCdSize1.value != "") {
	     				if(form.btn_vslCdSizeFlag[0].checked) {
	     					form.vslCdSizeFlag.value="max";
	     				} else if(form.btn_vslCdSizeFlag[1].checked) {
	     					form.vslCdSizeFlag.value="14ton";
	     				}
     				}
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    		 		break;
     			case "btn_new":
     				if(!initConfirm()) return;
    		 		ComResetAll();
    		 		document.getElementById("style1").style.display="";
 					document.getElementById("style2").style.display="none";
 					document.getElementById("style3").style.display="none";
     				break;
     			case "btn_save":
     				doActionIBSheet(sheetObject,formObject,IBSAVE);
     				break;
     			case "btn_add":
					var row=sheetObject.DataInsert(-1);
     				break;
     			case "btn_ins":
					var row=sheetObject.DataInsert();
					break;
     			case "btn_del":
     				ComRowHideDelete(sheetObject, "DelChk");
					break;
     			case "btn_periodFlag":
     				if(form.btn_periodFlag[0].checked) {
     					document.getElementById("style1").style.display="";
     					document.getElementById("style2").style.display="none";
     					document.getElementById("style3").style.display="none";     					
     				} else if(form.btn_periodFlag[1].checked) {
     					document.getElementById("style1").style.display="none";
     					document.getElementById("style2").style.display="";
     					document.getElementById("style3").style.display="none";
     				} else if(form.btn_periodFlag[2].checked) {
     					document.getElementById("style1").style.display="none";
     					document.getElementById("style2").style.display="none";
     					document.getElementById("style3").style.display="";
     				}
     				break;
     			case "btn_vslDeDate1":
     			case "btn_vslDeMonth1":
     			case "btn_vslDeYear1":
     				var cal=new ComCalendar();
     				if(form.btn_periodFlag[0].checked) {
     					cal.setDisplayType('date');
    					cal.select(form.vslDeDate1, 'yyyy-MM-dd');
     				} else if(form.btn_periodFlag[1].checked) {
     					cal.setDisplayType('month');
    					cal.select(form.vslDeMonth1, 'yyyy-MM');
     				} else if(form.btn_periodFlag[2].checked) {
     					cal.setDisplayType('year');
    					cal.select(form.vslDeYear1, 'yyyy');
     				}
					break;					
     			case "btn_vslDeDate2":
     			case "btn_vslDeMonth2":
     			case "btn_vslDeYear2":
     				var cal=new ComCalendar();
     				if(form.btn_periodFlag[0].checked) {
     					cal.setDisplayType('date');
    					cal.select(form.vslDeDate2, 'yyyy-MM-dd');
     				} else if(form.btn_periodFlag[1].checked) {
     					cal.setDisplayType('month');
    					cal.select(form.vslDeMonth2, 'yyyy-MM');
     				} else if(form.btn_periodFlag[2].checked) {
     					cal.setDisplayType('year');
     					cal.select(form.vslDeYear2, 'yyyy');
     				}
					break;
     			case "btn_yard":
     				ComOpenPopup("ESM_FMS_0082.do", 370, 360, "setFormYardName", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0082");
     				break;
     			case "btn_owner":
     				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setFromOwnerName", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0083");
     				break;
     			case "btn_ydClr":
     				form.shpYdNm.value="";
     				form.ydSeq.value="";
     				break;
     			case "btn_ownrClr":
     				form.ownrNm.value="";
     				form.ownrSeq.value="";
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
     * Setting whether using relavent Object by Condition <br>
     **/
    function inputReadOnly(flag) {
    	if(flag == "1") {
    		form.btn_periodFlag[0].disabled=true;
    		form.btn_periodFlag[1].disabled=true;
    		form.btn_periodFlag[2].disabled=true;
    		form.vslDeDate1.readOnly=true;
			form.vslDeDate2.readOnly=true;
			form.vslDeMonth1.readOnly=true;
			form.vslDeMonth2.readOnly=true;
			form.vslDeYear1.readOnly=true;
			form.vslDeYear2.readOnly=true;
    		form.vslCdSize1.readOnly=true;
    		form.vslCdSize2.readOnly=true;
    		document.images["btn_vslDeDate1"].name="";
    		form.btn_vslDeDate1.style.cursor="default";
    		document.images["btn_vslDeMonth1"].name="";
    		form.btn_vslDeMonth1.style.cursor="default";
    		document.images["btn_vslDeYear1"].name="";
    		form.btn_vslDeYear1.style.cursor="default";
    		document.images["btn_vslDeDate2"].name="";
    		form.btn_vslDeDate2.style.cursor="default";
    		document.images["btn_vslDeMonth2"].name="";
    		form.btn_vslDeMonth2.style.cursor="default";
    		document.images["btn_vslDeYear2"].name="";
    		form.btn_vslDeYear2.style.cursor="default";
    		document.images["btn_yard"].name="";
    		form.btn_yard.style.cursor="default";
    		document.images["btn_owner"].name="";
    		form.btn_owner.style.cursor="default";
    		form.btn_vslCdSizeFlag[0].disabled=true;
    		form.btn_vslCdSizeFlag[1].disabled=true;
    		form.shpNm.readOnly=true;
    	} else {
    		document.getElementById("style1").style.display="";
			document.getElementById("style2").style.display="none";
			document.getElementById("style3").style.display="none";
    		form.btn_periodFlag[0].disabled=false;
    		form.btn_periodFlag[1].disabled=false;
    		form.btn_periodFlag[2].disabled=false;
    		form.vslDeDate1.readOnly=false;
			form.vslDeDate2.readOnly=false;
			form.vslDeMonth1.readOnly=false;
			form.vslDeMonth2.readOnly=false;
			form.vslDeYear1.readOnly=false;
			form.vslDeYear2.readOnly=false;
    		form.vslCdSize1.readOnly=false;
    		form.vslCdSize2.readOnly=false;
    		document.images["btn_vslDeDate1"].name="btn_vslDeDate1";
    		form.btn_vslDeDate1.style.cursor="hand";
    		document.images["btn_vslDeMonth1"].name="btn_vslDeMonth1";
    		form.btn_vslDeMonth1.style.cursor="hand";
    		document.images["btn_vslDeYear1"].name="btn_vslDeYear1";
    		form.btn_vslDeYear1.style.cursor="hand";
    		document.images["btn_vslDeDate2"].name="btn_vslDeDate2";
    		form.btn_vslDeDate2.style.cursor="hand";
    		document.images["btn_vslDeMonth2"].name="btn_vslDeMonth2";
    		form.btn_vslDeMonth2.style.cursor="hand";
    		document.images["btn_vslDeYear2"].name="btn_vslDeYear2";
    		form.btn_vslDeYear2.style.cursor="hand";
    		document.images["btn_yard"].name="btn_yard";
    		form.btn_yard.style.cursor="hand";
    		document.images["btn_owner"].name="btn_owner";
    		form.btn_owner.style.cursor="hand";
    		form.btn_vslCdSizeFlag[0].disabled=false;
    		form.btn_vslCdSizeFlag[1].disabled=false;
    		form.shpNm.readOnly=false;
    	}
    }
    /**
	 * Setting Ship Yard Name and Sequence selected in Yard PopUp into Form item.<br>
	 * @param {arry} aryPopupData
	 */
	function setFormYardName(aryPopupData){
		form.ydSeq.value=aryPopupData[0][3];
		form.shpYdNm.value=aryPopupData[0][4];
		form.btn_ydClr.checked=true;
	}
    /**
	 * Setting Head Ownership Name and Sequence selected in Owner PopUp into Form item<br>
	 * @param {arry} aryPopupData
	 */
	function setFromOwnerName(aryPopupData){
        form.ownrSeq.value=aryPopupData[0][3];
        form.ownrNm.value=aryPopupData[0][4];
        form.btn_ownrClr.checked=true;
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
	 * Setting Head Ownership Name and Sequence selected in Owner PopUp into Sheet<br>
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 */
	function setSheetOwnerName(aryPopupData, Row, Col, sheetIdx){
		 sheetObjects[0].SetCellValue(Row, "ownr_nm",aryPopupData[0][4],0);
		 sheetObjects[0].SetCellValue(Row, "ownr_seq",aryPopupData[0][3],0);
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
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
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
		    	      var HeadTitle="|Sel|Seq|Ship's Full Name|New Building Hull No.|Nominal TEU|14Ton Hom|Reefer|Speed|Period|Trading House|Estimated Delivery|Yard|Owner|shp_de_seq|yd_seq|ownr_seq";
		    	      var headCount=ComCountHeadTitle(HeadTitle);
		    	      (headCount, 0, 0, true);
		    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		    	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		    	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"shp_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
		    	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"shp_bld_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		    	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vsl_dznd_capa",       KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bse_14ton_vsl_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rf_cntr_plg_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"shp_spd_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"flet_ctrt_dur_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trd_hus_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
		    	             {Type:"Date",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"vsl_de_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Popup",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"shp_yd_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Popup",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ownr_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"shp_de_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"yd_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ownr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(1);
		    	      SetShowButtonImage(2);
		    	      SetDataLinkMouse("shp_yd_nm",1);
		    	      SetDataLinkMouse("ownr_nm",1);
//		    	      SetSheetHeight(400);
		    	      resizeSheet();
    	      }
    			break;
    	}
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/  
	function initControl() {
		DATE_SEPARATOR="-";
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- Code handling to OnBeforeDeactivate(blur) Event of All Controls
//		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- Code handling to onkeypress Event of All Controls having dateformat attribute
//		axon_event.addListenerFormat('focus', 'obj_activate', form);
	}
	/**
     * Handling sheet process<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      
	    		if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_FMS_0019GS.do", FormQueryString(formObj) );
				}
    			break;
    		case IBSAVE:        
		  	  	formObj.f_cmd.value=MULTI;
		  	  	sheetObj.DoSave("ESM_FMS_0019GS.do", FormQueryString(formObj));
		  	  	break;
    		case IBINSERT:     
    			break;
    	}
    }
    /**
     * Checking Validation of Duration in onblur Event of HTML Control<br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	if((event.srcElement.name == "vslDeDate1") ||
    	   (event.srcElement.name == "vslDeDate2") ||
    	   (event.srcElement.name == "vslDeMonth1") ||
    	   (event.srcElement.name == "vslDeMonth2") ||
    	   (event.srcElement.name == "vslDeYear1") ||
    	   (event.srcElement.name == "vslDeYear2")) {
    		ComChkObjValid(event.srcElement);
    	} else {
    		ComChkObjValid(event.srcElement);
    	}
    }
    /**
     * Only insert Numeric by onkeypress Event of HTML Control<br>
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//			case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "float":
//		        ComKeyOnlyNumber(event.srcElement, ".");
//				break;
//			default:
//		        ComKeyOnlyNumber(event.srcElement);
//    	}
//    }
    /**
     * Handling process for input validation<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	var	exptElems="";
     	if(form.btn_periodFlag[0].checked) {
     		exptElems="vslDeMonth1|vslDeMonth2|vslDeYear1|vslDeYear2";
     	} else if(form.btn_periodFlag[1].checked) {
     		exptElems="vslDeDate1|vslDeDate2|vslDeYear1|vslDeYear2";
     	} else if(form.btn_periodFlag[2].checked) {
     		exptElems="vslDeDate1|vslDeDate2|vslDeMonth1|vslDeMonth2";
     	}
     	if (!ComFmsChkValid(formObj, exptElems)) {
     		return false;
     	}
    	if((form.vslCdSize1.value == "") && (form.vslCdSize2.value == "")) {
    		form.vslCdSizeFlag.value="";
    	}
    	with(formObj){
    		if((vslCdSize1.value == "") &&
    		   (vslCdSize2.value != "")) {
    			ComAlertFocus(formObj.vslCdSize1, ComGetMsg("FMS00011", "Vessel Size"));
    			return false;
    		}
    		if((vslCdSize1.value != "") &&
    		   (vslCdSize2.value == "")) {
    			ComAlertFocus(formObj.vslCdSize2, ComGetMsg("FMS00011", "Vessel Size"));
    			return false;
    		}
    		if(parseInt(vslCdSize1.value.replace(",","")) > parseInt(vslCdSize2.value.replace(",",""))) { 
    			vslCdSize2.value="";
    			ComAlertFocus(formObj.vslCdSize2, ComGetMsg("FMS00010", "To Vessel Size", "From Vessel Size"));
    			return false;
    		}
    	}
    	return true;
    }
    /**
     * Open Yard PopUp and Owner PopUp when clicking PopUp in IBSheet Object<br>
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col){
		with(sheetObj) {
			var sName=ColSaveName(Col);
			if(sName == "shp_yd_nm") {
				ComOpenPopup("ESM_FMS_0082.do", 400, 340, "setSheetYardName", "1,0,1,1,1,1", true, false, Row, Col, 0, "esm_fms_0082");
			} else if (sName == "ownr_nm") {
				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setSheetOwnerName", "1,0,1,1,1,1", true, false, Row, Col, 0, "esm_fms_0083");
			}
		}
	}
    /**
     * Checking Going ahead in case changed data is existing <br>
     **/
    function initConfirm() {
    	var okYn=true;
    	if(sheetObjects[0].IsDataModified()) {
    		var okYn=ComShowCodeConfirm("FMS00002");
    	}
    	return okYn;
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control<br>
     */
//    function obj_activate() {
//        ComClearSeparator(event.srcElement);
//    }

    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }    