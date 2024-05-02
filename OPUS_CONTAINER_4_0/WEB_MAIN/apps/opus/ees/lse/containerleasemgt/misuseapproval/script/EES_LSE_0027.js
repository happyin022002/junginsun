/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0027.js
*@FileTitle  : Mis Use In & Out Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_LSE_0027 : business script for EES_LSE_0027
     */

   	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	//file up load Object Array
	var uploadFileSeq="";
	var fileUploadFlag=false;
	var fileSaveFlag=false;
	var vOrgModCd="O";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_RowAdd":
 					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject, formObj, IBINSERT);
 					} else {
 						ComSetFocus(formObj.rtrn_loc);
 					}
 					break;
 				case "btn_Delete":
 					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject, "del_chk");
 					} else {
 						ComSetFocus(formObj.rtrn_loc);
 					}
 					break;
                case "btn_New":
					ComResetAll();
					vOrgModCd="O";
					/* Request Number */
    				doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC01);
					ComSetFocus(formObj.rtrn_loc);
					break;
                case "btn_Save":
                    doActionIBSheet(sheetObject,formObj,IBSAVE);
                    break;
				case "btns_search":		//Return Location
 					openPopup("1");
 					break;
 				case "btns_search2":	//Currency Code
 					openPopup("2");
 					break;
 				case "mss_rqst_io_mod_cd" :
	  				if ( ComGetObjValue(srcObj) != vOrgModCd ) {
	  					vOrgModCd=ComGetObjValue(srcObj);
	  					sheetObject.RemoveAll();
	  					/* Request Number */
    					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC01);
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
    function loadPage() {
		var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initUpload();
        sheet1_OnLoadFinish(sheet1);
        $("#curr_cd").blur(function(){
        	obj_change();
        });
        $("#rtrn_loc").blur(function(){
        	obj_change();
        });
    }

    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/LSE_INTGS.do'
 			,Files:[
 			]
	 		,BeforeAddFile : function(result){ 
	 			return true;
			}
	 		,AfterSaveStatus : function(result) {  
				var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileName=ComGetEtcData(sXml,"filename");
	 				pSheetObj.SetCellValue(pRow, "rqst_file_sav_id",uploadFileName,0);
					fileUploadFlag=false;
	      		}else {
					ComShowMessage(result.msg);
				}
				ComOpenWait(false);				
 			}
	 		,AfterAddFile:function(result){
				var files = result.files;
				var fileName= files[files.length-1].GetFileName();
		 		ComOpenWait(true);
		 		fileUploadFlag=true;
		 		pSheetObj.SetCellValue(pRow, "rqst_file_sav_nm",fileName,0);
		 		upload1.SaveStatus();
	 		}
 		});
 	}
    
    function sheet1_OnMouseMove(sheetObj, e) {
	  	  var row     = sheetObj.MouseRow(),
	        col     = sheetObj.MouseCol(),
	        info    = null;
	  	  var saveName = sheetObj.ColSaveName(col);

	  	  var linkFlag=sheetObj.GetCellValue(row, col) != "";
	  	  sheetObj.SetDataLinkMouse("rqst_file_sav_nm",linkFlag);
	  	  var editFlag = sheetObj.GetCellEditable( row , col);
	      if (row > 0 && saveName=="rqst_file_sav_nm"  && editFlag == 1) {
				if ( fileUploadFlag ) {
		    		return;
		    	}

	            info = sheetObj.GetCellElement(row, col, 1);

	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	  	  }
	  }
    
    
    /*function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "mss_use_plc_nm":	//Yard Code No Pop-up
					openPopup("3", Row, Col);
					break;
				case "rqst_file_sav_nm":	//Yard Code No Pop-up
					if ( fileUploadFlag ) {
			    		return;
			    	}

		            info = sheetObj.GetCellElement(Row, Col, 1);

		    		pSheetObj = sheetObj;
					pRow = Row;
					pCol = Col;

		            upload1.SetFileUploadElement(info);
			}
 		}
    }*/
    /**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
     	/* IBMulti Combo Item Setting */
    	 doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        /* Axon Control Setting*/
    	initControl();
    	/* registering after Approval Number */
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
    	/* Value Setting */
		vOrgModCd=ComGetObjValue(mss_rqst_io_mod_cd);
    	/* Focus Setting */
    	ComSetFocus(formObj.rtrn_loc);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerFormat('change', 		'obj_change',  	formObj); 
		axon_event.addListenerForm('click',			'obj_click',	formObj);
  	}
	//setting event Duplicate
	var preEventType=null;
  	/**
	 * handling Location blur event
	 **/
	function obj_blur() {
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")) {
	    	case "rtrn_loc" :
	            ComChkObjValid(obj);
	    		break;
	    	case "curr_cd" :
	            ComChkObjValid(obj);
	    		break;
	    	default:
	            /* checking Validation */
	            ComChkObjValid(obj);
	        	break;
	    }
	    preEventType=event.type;
	}
	
	/**
	 * handling event in case of Change
	 */
	function obj_change() {
		var obj=ComGetEvent();
		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "rtrn_loc":	//Return Location
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
				}
				break;
  			case "n1st_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
				}
				break;
  			case "n2nd_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
				}
				break;
  			case "n3rd_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);
				}
				break;
  			case "n4th_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC06);
				}
				break;
			case "curr_cd":		//Currency Code
				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC07);
				}
				break;
		}
	}
	
   	/**
     * handling event in case of Click
     */
   	function obj_click() {
   		var obj=ComGetEvent();
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "rqst_usr_id":
  				if(obj.value != "") {
  					//user info.
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

	                var HeadTitle="|Sel.|CNTR No.|TP/SZ|Lease\nTerm|MVMT|POD|POL|MU O/I Date|MU By/From|Yard|Per Diem|Handle On\nCharge|Liable Party|||||Request Reason|Request File Attachment|";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                //(headCount, 6, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                          {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },	                        	                          
	                          {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                          {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"mss_usd_dt",        KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	                          {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"mss_usd_fm_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
	                          {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mss_use_plc_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
	                          {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"pd_chg_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	                          {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"lft_chg_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	                          {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"libor_pty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rqst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rqst_loc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
	                          {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"rqst_rsn_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
	                          {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"rqst_file_sav_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"rqst_file_sav_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetShowButtonImage(3);
	                SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                SetColProperty(0 ,"mss_use_plc_nm" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                
	                //SetSheetHeight(390);
	                ComResizeSheet(sheetObj, 90);
               }
                break;
        }
    }
	/**
	 * handling process for Sheet
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
				sheetObj.SetWaitImageVisible(0);
				//Container Type/Size Grid Combo Item Setting
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
				if ( sXml != "" ) {
					sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:ComGetEtcData(sXml ,"cntr_tpsz_nm"), ComboCode:ComGetEtcData(sXml,"cntr_tpsz_cd")} );
				}
				//----------------------------------------------------------
				//Lease Term Grid Combo Item Setting
				//formObj.f_cmd.value = SEARCH01;
				//sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
				//if ( sXml != "" ) {
				//	sheetObj.InitDataCombo(0, "lstm_cd", " |"+ ComGetEtcData(sXml, "lease_term_nm"), " |"+ ComGetEtcData(sXml, "lease_term_cd"));
				//}
				//----------------------------------------------------------
				sheetObj.SetWaitImageVisible(1);
				break;
			case IBSAVE:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=MULTI;
						sheetObj.DoSave("EES_LSE_0027GS.do", FormQueryString(formObj));
					}
				}
				break;
			case IBSEARCH_ASYNC01:
				//Request No Setting
				sheetObj.SetWaitImageVisible(0);
				var param="f_cmd="+SEARCH01+"&ofc_cd="+ComGetObjValue(formObj.rqst_ofc_cd);
				var sXml=sheetObj.GetSearchData("EES_LSE_0027GS.do",param);
				sheetObj.SetWaitImageVisible(1);
				if(sXml != "") {
					if ( ComGetEtcData(sXml, "rqst_no") != undefined ) {
						if ( ComGetEtcData(sXml, "rqst_no") != "" ) {
							var vRqstNo=ComGetEtcData(sXml, "rqst_no");
							ComSetObjValue(formObj.rqst_no,  vRqstNo);
							// handing button after retrieve
    						LseComBtnControl(true, "btn_RowAdd|btn_Delete");
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.rqst_no.value="";
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						formObj.rqst_no.value="";
					}
				}
				break;
			case IBSEARCH_ASYNC02:	// retrieving in case input Form Return Location
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param="f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(rtrn_loc);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					setAsycData_ReturnLoc(sXml, rtrn_loc);
					//공통에서 Next로 값을 넘겨 Focus이벤트 X
					//ComSetFocus(formObj.rtrn_loc);
				}
				break;
			case IBSEARCH_ASYNC03:	//retrieving in case input Form Return Location
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param="f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(n1st_ref_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					setAsycData_ReturnLoc(sXml,n1st_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC04:	//retrieving in case input Form Return Location
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param="f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(n2nd_ref_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					setAsycData_ReturnLoc(sXml,n2nd_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC05:	//retrieving in case input Form Return Location
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param="f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(n3rd_ref_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					setAsycData_ReturnLoc(sXml, n3rd_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC06:	//retrieving in case input Form Return Location
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param="f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(n4th_ref_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					setAsycData_ReturnLoc(sXml,n4th_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC07:	//retrieving in case input Form Currency Code
 				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(curr_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetNextFocus(curr_cd);
						} else {
							ComShowCodeMessage("LSE01048");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetFocus(curr_cd);
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						ComSetObjValue(formObj.curr_cd, "");
						ComSetFocus(curr_cd);
					}
				}
				break;
 			case IBINSERT:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var Row=sheetObj.DataInsert(-1);
	  					var editFlag=vOrgModCd == "I";
  						sheetObj.SetCellEditable(Row, "cntr_tpsz_cd",editFlag);
  						sheetObj.SetCellValue(Row,"cntr_tpsz_cd",editFlag ? "D2" : "",0);
  						sheetObj.SetCellValue(Row,"lstm_cd",editFlag ? "MI" : "",0);
  						sheetObj.SetCellValue(Row,"rqst_no",formObj.rqst_no.value,0);
						sheetObj.SetCellValue(Row,"rqst_loc_nm",formObj.rqst_ofc_cd.value,0);
						sheetObj.SelectCell(Row,"cntr_no");
						
						if (!OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
							sheetObj.SetCellEditable(Row, "pd_chg_rt_amt", 0);
						}
					}
				}
				break;
        }
    }
    /**
     * handling process for Return Location
     */
    function setAsycData_ReturnLoc(sXml, obj) {
    	var formObj=document.form;
    	if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
				if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
					var vLocCd=ComGetEtcData(sXml, "scc_cd");
		    		var vTmpStr=formObj.n1st_ref_ofc_cd.value +","
		    					+ formObj.n2nd_ref_ofc_cd.value +","
		    					+ formObj.n3rd_ref_ofc_cd.value +","
		    					+ formObj.n4th_ref_ofc_cd.value;
					var vTmpArr=vTmpStr.split(vLocCd);
					if(obj.name == "rtrn_loc") {
						if(formObj.n1st_ref_ofc_cd.value == "") {
							if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n1st_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n1st_ref_ofc_cd, vLocCd);
			    			}
			    		} else if(formObj.n2nd_ref_ofc_cd.value == "") {
			    			if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n2nd_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n2nd_ref_ofc_cd, vLocCd);
			    			}
			    		} else if(formObj.n3rd_ref_ofc_cd.value == "") {
			    			if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n3rd_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n3rd_ref_ofc_cd, vLocCd);
			    			}
			    		} else if(formObj.n4th_ref_ofc_cd.value == "") {
			    			if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n4th_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n4th_ref_ofc_cd, vLocCd);
			    			}
			    		} else {
			    			ComShowCodeMessage("LSE01029");
			    		}
			    		ComSetObjValue(obj, "");
			    		ComSetFocus(obj);
					} else {
						if(vTmpArr.length > 2) {
		    				ComShowCodeMessage("LSE01030");
		    	 			ComSetObjValue(obj, "");
		    	 			ComSetFocus(obj);
		    			} else {
		    				ComSetObjValue(obj, vLocCd);
		    				ComSetNextFocus(obj);
		    			}
					}
		    	} else {
					ComShowCodeMessage("LSE01037");
		    	 	ComSetObjValue(obj, "");
		    	 	ComSetFocus(obj);
				}
			} else {
				var errMsg=LseComGetErrMsg(sXml);
				if ( errMsg != "" ) {
					ComShowMessage(errMsg);
				}
				ComSetObjValue(obj, "");
				ComSetFocus(obj);
			}
		}
    }
    /**
	 * handling event when changing Sheet.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "cntr_no":
					//checking whether cntr_no duplicate 
					var dupRow=ColValueDup("cntr_no", false);
					if(GetCellValue(dupRow, "cntr_no") != "" && dupRow != -1) {
						ComShowCodeMessage("LSE01075", GetCellValue(dupRow, "cntr_no"));
						clearForm("cntr_no");
						SelectCell(dupRow, "cntr_no");
					}
					//checking whether cntr_no validation
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="  + SEARCH02
						+ "&cntr_no="+ GetCellValue(Row,Col);
						SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_0027GS.do",param);
 						SetWaitImageVisible(1);
 						if(sXml != "") {
							if ( ComGetEtcData(sXml, "exist_flag") != undefined ) {
								if(ComGetEtcData(sXml, "exist_flag") == "TRUE") {
									ComShowCodeMessage("LSE01140", Value);
									clearForm("cntr_no");
								}
							}
						}
					}
					// retrieving cntr_no information
					if(GetCellValue(Row,Col) != "" && vOrgModCd == "O") {
						var param="f_cmd="  + SEARCH03
						+ "&cntr_no="+ GetCellValue(Row,Col);
						SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_0027GS.do",param);
 						SetWaitImageVisible(1);
 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "cntr_no") != undefined) {
				 				if (ComGetEtcData(sXml, "cntr_no") != "") {
				 					SetCellValue(Row,"cntr_no",ComGetEtcData(sXml, "cntr_no"),0);
				 					SetCellValue(Row,"agmt_cty_cd",ComGetEtcData(sXml, "agmt_cty_cd"),0);
				 					SetCellValue(Row,"agmt_seq",ComGetEtcData(sXml, "agmt_seq"),0);
				 					SetCellValue(Row,"cntr_tpsz_cd",ComGetEtcData(sXml, "cntr_tpsz_cd"),0);
				 					SetCellValue(Row,"lstm_cd",ComGetEtcData(sXml, "lstm_cd"),0);
				 					SetCellValue(Row,"mvmt_sts_cd",ComGetEtcData(sXml, "mvmt_sts_cd"),0);
				 					SetCellValue(Row,"pod_cd",ComGetEtcData(sXml, "pod_cd"),0);
				 					SetCellValue(Row,"pol_cd",ComGetEtcData(sXml, "pol_cd"),0);
				 					SetCellValue(Row,"mss_usd_dt",ComGetEtcData(sXml, "cnmv_dt"),0);
				 					SetCellValue(Row,"mss_use_plc_nm",ComGetEtcData(sXml, "crnt_yd_cd"),0);
				 					SetCellValue(Row,"pd_chg_rt_amt",ComGetEtcData(sXml, "pdm_amt"),0);
				 					SetCellValue(Row,"lft_chg_rt_amt",ComGetEtcData(sXml, "lon_amt"),0);
		 						} else {
		 							ComShowCodeMessage("LSE01075");
		 							clearForm("cntr_no");
		 						}
 							} else {
 								var errMsg=LseComGetErrMsg(sXml);
 								if ( errMsg != "") {
 									ComShowMessage(errMsg);
 								} else {
									ComShowCodeMessage("LSE01074");
 								}
 								clearForm("cntr_no");
 								SelectCell(Row,Col);
 							}
 						}
					}
					break;
				case "mss_use_plc_nm":		// Grid Yard Code Check
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd=" + SEARCH02 + "&location=" + GetCellValue(Row,Col) + "&inquiryLevel=Y";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_CIM_0018GS.do",param);
 						var sCheck=ComGetEtcData(sXml, "check");
						if (sCheck != "OK") {
							SetCellValue(Row,"mss_use_plc_nm","",0);
							ComShowCodeMessage("LSE01048");
						}
						sheetObj.SetWaitImageVisible(1);
					}
					break;
			}
 		}
 	}
 	/**
 	 * handling event in case of Pop-up Click sheet1<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */ 
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "mss_use_plc_nm":	//Yard Code No Pop-up
					openPopup("3", Row, Col);
					break;
			}
 		}
    }
    /**
     * calling event after retrieving t1Sheet1
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
	    	//checking whether cntr_no duplicate 
			var dupRow=ColValueDup("cntr_no", false);
			if(GetCellValue(dupRow, "cntr_no") != "" && dupRow != -1) {
				ComShowCodeMessage("LSE01075", GetCellValue(dupRow, "cntr_no"));
				ValidateFail(true);
				SelectCell(dupRow, "cntr_no");
			}
    	}
    }
	/**
     * calling event after saving Sheet1
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		// handing button after saving
    		LseComBtnControl(false, "btn_RowAdd|btn_Delete");
    		sheetObj.SetColFontColor("rqst_file_sav_nm","#0000FF");
    	}
    }
    /**
     * calling event after retrieving Sheet1
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//sheetObj.FitColWidth();
    }
	/**
	 * sheet1_OnClick
	 */
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
//		if(sheetObj.GetMousePointer!= "Hand") return;
		with(sheetObj) {
			if(GetCellText(Row, sName.replace("_nm", "_id")) != "") {
                switch(sName) {
                    case "rqst_file_sav_nm":
                        location.href="/opuscntr/FileDownload?key="+GetCellText(Row, "rqst_file_sav_id");
                        break;
                }
			}
		}
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Return Location. Popup for FORM, 2:Currency Code Popup for FORM
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_051.do', 795, 480, "setPopData_ReturnLoc", "1,0,1,1,1,1,1", true);
    	} else if ( type == "2" ) {
			ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 450, 'setPopData_Currency', '1,0,1', true);
    	} else if ( type == "3" ) {
    		ComOpenPopup("/opuscntr/COM_ENS_061.do", 755, 550, "setPopData_YardCode", "1,0,1,1,1,1,1,1", true, false, Row, Col, 0);
    	}
    	return;
    }
	/**
     * handing process for Location Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_ReturnLoc(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
    		var vLocCd=aryPopupData[0][8];	//SCC
    		var vTmpStr=formObj.n1st_ref_ofc_cd.value +","
    					+ formObj.n2nd_ref_ofc_cd.value +","
    					+ formObj.n3rd_ref_ofc_cd.value +","
    					+ formObj.n4th_ref_ofc_cd.value;
			var vTmpArr=vTmpStr.split(vLocCd);
			if(formObj.n1st_ref_ofc_cd.value == "") {
				if(vTmpArr.length > 1) {
					ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n1st_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n1st_ref_ofc_cd, vLocCd);
    			}
    		} else if(formObj.n2nd_ref_ofc_cd.value == "") {
    			if(vTmpArr.length > 1) {
    				ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n2nd_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n2nd_ref_ofc_cd, vLocCd);
    			}
    		} else if(formObj.n3rd_ref_ofc_cd.value == "") {
    			if(vTmpArr.length > 1) {
    				ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n3rd_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n3rd_ref_ofc_cd, vLocCd);
    			}
    		} else if(formObj.n4th_ref_ofc_cd.value == "") {
    			if(vTmpArr.length > 1) {
    				ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n4th_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n4th_ref_ofc_cd, vLocCd);
    			}
    		} else {
    			ComShowCodeMessage("LSE01029");
    		}
    	}
    }
	/**
	 * handing process for Currency Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.curr_cd, aryPopupData[0][2]);
		}
	}
	/**
      * handing process for Yard Code Pop-up Return Value<br>
      * @param Return value array
      * @param Row index
      * @param Col index
      * @param Sheet Array index
      */
     function setPopData_YardCode(aryPopupData, Row, Col, sheetIdx) {
     	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "mss_use_plc_nm":
						SetCellValue(Row, sName,aryPopupData[0][3],0);//Yard
						break;
					default :	//do nothing
				}
			}
		}
     }
	/**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			//return checkDupData(sheetObj);
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
    }
	/**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch(fieldName) {
			case "cntr_no":
				with(sheetObj) {
					SetCellValue(GetSelectRow(), "cntr_no","",0);
					SetCellValue(GetSelectRow(), "agmt_cty_cd","",0);
					SetCellValue(GetSelectRow(), "agmt_seq","",0);
					SetCellValue(GetSelectRow(), "cntr_tpsz_cd","",0);
					SetCellValue(GetSelectRow(), "lstm_cd","",0);
					SetCellValue(GetSelectRow(), "mvmt_sts_cd","",0);
					SetCellValue(GetSelectRow(), "pod_cd","",0);
					SetCellValue(GetSelectRow(), "pol_cd","",0);
					SetCellValue(GetSelectRow(), "mss_usd_dt","",0);
					SetCellValue(GetSelectRow(), "mss_use_plc_nm","",0);
					SetCellValue(GetSelectRow(), "pd_chg_rt_amt","",0);
					SetCellValue(GetSelectRow(), "lft_chg_rt_amt","",0);
				}
				break;
			default :	//do nothing
		}
	}
	/* end of developer job */
