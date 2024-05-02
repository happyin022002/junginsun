/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0026.js
*@FileTitle  : Immediate Exit Inquiry 
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
     * @class EES_LSE_0026 : business script for EES_LSE_0026
     */
   	/* developer job */
	// common global variables
	var vXmlBuff;
	var sheetObjects=new Array();
	var sheetCnt=0;
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
				case "btn_retrive":
					if(ComChkValid(formObj) == true) {
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}
					break;
				case "btn_new":
					ComResetAll();
					formObj.loc_cd.readOnly=true;
					formObj.loc_cd.className="input2";
					formObj.cntr_no.className="input2";
					formObj.agmt_seq.className="input1";
					formObj.cntr_no.readOnly=true;
					ComEnableObject(formObj.btns_search2, false);
					ComSetFocus(formObj.agmt_seq);
					break;
				case "btn_downExcel":
					ComOpenWait(true);
					sheetObjects[1].LoadSearchData(vXmlBuff,{Sync:1} );
					//sheetObjects[1].SpeedDown2Excel(-1);
					if(sheetObjects[1].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
					}
					ComOpenWait(false);
					break;
				case "btns_search":		//retrieving for AGMT No.
 					openPopup("1");
 					break;
 				case "btns_search2":	//retrieving for Location.
 					openPopup("2");
 					break;
 				case "chk_cntr":
					if ( srcObj.checked ) {
						clearForm("agmt_seq");
						formObj.cntr_no.className="input1";
						formObj.agmt_seq.className="input";
						formObj.cntr_no.readOnly=false;
						ComSetFocus(formObj.cntr_no);
					} else {
						formObj.cntr_no.value="";
						formObj.cntr_no.className="input2";
						formObj.agmt_seq.className="input1";
						formObj.cntr_no.readOnly=true;
						ComSetFocus(formObj.agmt_seq);
					}
					break;
 				case "cntr_no_multi":	// inputting multi
 					if(form.chk_cntr.checked == true) {
 						rep_Multiful_inquiry("cntr_no");
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
    
    function rep_Multiful_inquiry(input_obj) {
       	var formObject=document.form;
       	var cmdt_cd_val=""; // 향후 사용가능 예정변수
       	var rep_cmdt_cd_val=""; // 향후 사용가능 예정변수
       	var cmdt_desc_val=""; // 향후 사용가능 예정변수
       	var classId="getLse_Multi";
       	var xx1=input_obj; // CONTI
       	var xx2=""; // SUB CONTI
       	var xx3=""; // COUNTRY
       	var xx4=""; // STATE
       	var xx5=""; // CONTROL OFFIC
       	var xx6=""; // LOC CODE
       	var xx7=""; // LOC NAME
       	var xx8="";
       	var xx9="";
       	var param="?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3
       			+ "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6
       			+ "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
       	ComOpenPopup('EES_LSE_1002.do' + param, 400, 330, 'getLse_Multi',
       			'1,0');
    }
    function getLse_Multi(rowArray,ret_val) {
    	var formObj=document.form;
    	var tempText="";
    	//initializing
    	formObj.cntr_no.value='';
    	for(var i=0; i<rowArray.length; i++) {
    		var colArray=rowArray[i];
    		tempText +=  rowArray[i] + ',';
    	}
    	//clearing comma(,)
    	tempText=LseDelLastDelim(tempText);
    	tempText=tempText.toUpperCase();
    	eval("document.form." + ret_val + ".value='" + tempText + "';");
    }
    
    /**
     * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
     * 
     * @param {String}
     *            str 제거 대상 String
     * @return {String} str 제거된 String
     * @author 박영진
     * @version 2009.06.04
     */
    function LseDelLastDelim(str) {
    	// 마지막에 &를 없애기 위함
    	if (str != "") {
    		str=str.substr(0, str.length - 1);
    	}
    	return str;
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
		/* Axon Control Setting*/
    	initControl();
    	/* Focus Setting */
    	ComEnableObject(formObj.btns_search2, false);
    	ComSetFocus(formObj.agmt_seq);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',   		'obj_change',  	formObj); 
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
	    	case "agmt_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
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
  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
				}
				break;
			case "loc_tp":		//Location Type
				formObj.loc_cd.value="";
				if(obj.value == "") {
					formObj.loc_cd.readOnly=true;
					formObj.loc_cd.className="input2";
					ComEnableObject(formObj.btns_search2, false);
				} else {
					formObj.loc_cd.readOnly=false;
					formObj.loc_cd.className="input";
					ComEnableObject(formObj.btns_search2, true);
					formObj.loc_cd.maxLength=obj.value == "5" ? 7 : 5;
					ComSetNextFocus(obj);
				}
				break;
			case "loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
  					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  					}
  				}
  				break;
  			case "cntr_no":
  				if ( ComTrim(obj.value) != "" ) {
					//doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
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
        var formObj=document.form;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

	                var HeadTitle="|Seq.|Imme Exit|CNTR No.|TP/SZ|On-hire|On-hire|Current Yard|MVMT|ACT Date|F/M||";
	                var HeadTitle1="|Seq.|Imme Exit|CNTR No.|TP/SZ|Date|Yard|Current Yard|MVMT|ACT Date|F/M||";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                //(13, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	                       {Type:"CheckBox",  Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,TrueValue:"Y", FalseValue:"N" },
	                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:160,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:160,   Align:"Center",  ColMerge:1,   SaveName:"onh_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:160,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:160,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	                InitColumns(cols);
	
	                SetEditable(0);
	                //InitHeadMode(true,true,GetEditable(),true,false,false);
	                FitColWidth();
	                SetShowButtonImage(1);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                //SetSheetHeight(379);
	                ComResizeSheet(sheetObj);
	                SetColWidth("full_flg", 50);
	                SetHeaderRowHeight(10);
               }
                break;
           	case 2:      //t1sheet1 init
                with (sheetObj) {

           	   var HeadTitle="|Seq.|Imme Exit|CNTR No.|TP/SZ|On-hire|On-hire|Current Yard|MVMT|ACT Date|F/M||";
           	   var HeadTitle1="|Seq.|Imme Exit|CNTR No.|TP/SZ|Date|Yard|Current Yard|MVMT|ACT Date|F/M||";
           	   var headCount=ComCountHeadTitle(HeadTitle);
           	   //(13, 0, 0, true);

           	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

           	   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
           	   var headers = [ { Text:HeadTitle, Align:"Center"},
           	                 { Text:HeadTitle1, Align:"Center"} ];
           	   InitHeaders(headers, info);

           	   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
           	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
           	             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"onh_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
           	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           	    
           	   InitColumns(cols);

           	   SetEditable(0);
           	   //InitHeadMode(true,true,GetEditable(),true,false,false);
           	   SetWaitImageVisible(0);
           	   FitColWidth();
           	   SetShowButtonImage(1);
           	   SetCountFormat("[SELECTDATAROW / TOTALROWS]");
          	    SetSheetHeight(379);
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
			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						vXmlBuff=sheetObj.GetSearchData("EES_LSE_0025GS.do",FormQueryString(formObj));
						sheetObj.LoadSearchData(vXmlBuff,{Sync:0} );
					}
				}
				break;
			case IBSEARCH_ASYNC01:	//retrieving when input Form Agreement No.
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						formObj.f_cmd.value=SEARCH03;
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
 						sheetObj.SetWaitImageVisible(1);
 						if ( sXml != "" ) {
 							var vLstmCd=ComGetEtcData(sXml, "lstm_cd");
	 						if ( vLstmCd != undefined ) {
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
								ComSetObjValue(formObj.lstm_cd,  ComGetEtcData(sXml, "lstm_cd"));
								ComSetObjValue(formObj.ref_no,   ComGetEtcData(sXml, "ref_no"));
								ComSetObjValue(formObj.ctrt_no,   ComGetEtcData(sXml, "lse_ctrt_no"));
								ComSetObjValue(formObj.free_dys, ComGetEtcData(sXml, "lse_free_dys"));
								ComSetObjValue(formObj.ofc_cd,   ComGetEtcData(sXml, "ofc_cd"));
								ComSetObjValue(formObj.eff_dt,   ComGetEtcData(sXml, "eff_dt"));
								ComSetObjValue(formObj.exp_dt,   ComGetEtcData(sXml, "exp_dt"));
								ComSetNextFocus(formObj.agmt_seq);
 							} else {
 								var errMsg=LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								clearForm("agmt_seq");
 								ComSetFocus(formObj.agmt_seq);
 							}
 						}
 					}
				}
				break;
			case IBSEARCH_ASYNC02:	// retrieving for Location
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp=formObj.loc_tp[formObj.loc_tp.selectedIndex].text;
 						var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd="";
									switch (vLocTp) {
										case "RCC":
											vLocCd=ComGetEtcData(sXml, "rcc_cd");
											break;
										case "LCC":
											vLocCd=ComGetEtcData(sXml, "lcc_cd");
											break;
										case "SCC":
											vLocCd=ComGetEtcData(sXml, "scc_cd");
											break;
									}
									formObj.loc_cd.value=vLocCd;
									ComSetFocus(formObj.loc_cd);
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd.value="";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value="";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC03:	// retrieving for Yard
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.loc_cd)
 								  + "&mode=yard";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetFocus(formObj.loc_cd);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.loc_cd.value="";
							ComSetFocus(formObj.loc_cd);
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC04:	// retrieving for Container
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH17+"&cntr_no="+ComGetObjValue(formObj.cntr_no);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetFocus(formObj.cntr_no);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.cntr_no.value="";
							ComSetFocus(formObj.cntr_no);
						}
					}
				}
 				break;
        }
    }
    /**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.FitColWidth();
    }
    /**
     * handing process Pop-up<br>
     * @param type 1:Agreement No. Popup for FORM, 2:Location Code Popup for FORM
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "2" ) {
			switch(formObj.loc_tp.value) {
    			case "1" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "4" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "5" :	//Yard
					ComOpenPopup("/opuscntr/COM_ENS_061.do",755, 550, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	}
    	return;
    }
    /**
      * handling process for Agreement Pop-up Return Value<br>
      * @param Return value array
      * @param Row index
      * @param Col index
      * @param Sheet Array index
      */
     function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj=sheetObjects[SheetIdx];
     	var formObj=document.form;
     	if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
    		ComSetObjValue(formObj.ref_no,   aryPopupData[0][6]);
    		ComSetObjValue(formObj.ctrt_no,  aryPopupData[0][15]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][8]);
    		ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][9]);
    		ComSetObjValue(formObj.lstm_cd,  aryPopupData[0][7]);
    		ComSetObjValue(formObj.eff_dt,   aryPopupData[0][10]);
			ComSetObjValue(formObj.exp_dt,   aryPopupData[0][11]);
			ComSetObjValue(formObj.free_dys, ComAddComma(aryPopupData[0][12]));
			ComSetObjValue(formObj.ofc_cd,   aryPopupData[0][13]);
			ComSetNextFocus(formObj.agmt_seq);
     	}
     }
	/**
      * handling process for DeliveryLoc(Yard) Pop-up Return Value<br>
      * @param Return value array
      * @param Row index
      * @param Col index
      * @param Sheet Array index
      */
     function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj=sheetObjects[SheetIdx];
     	var formObj=document.form;
     	if ( aryPopupData.length > 0 ) {
     		if ( formObj.loc_tp.value == "5" ) {
				ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
			}
     	}
     }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH: 
					if(formObj.agmt_seq.className == "input1" && formObj.agmt_seq.value == "") {
						if ( formObj.lstm_cd.value == "" ) {
							ComShowCodeMessage("LSE01006");
							ComSetFocus(formObj.agmt_seq);
							return false;
							break;
						}
					} else if(formObj.cntr_no.className == "input1" && formObj.cntr_no.value == "") {
						ComShowCodeMessage("LSE01064");
						ComSetFocus(formObj.cntr_no);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
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
		switch(fieldName) {
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetObjValue(formObj.ref_no,      "");
				ComSetObjValue(formObj.ctrt_no,     "");
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.lstm_cd,     "");
				ComSetObjValue(formObj.eff_dt,  	"");
				ComSetObjValue(formObj.exp_dt,      "");
				ComSetObjValue(formObj.free_dys,  	"");
				ComSetObjValue(formObj.ofc_cd,      "");
				formObj.loc_tp.value="";
				formObj.loc_cd.readOnly=true;
				formObj.loc_cd.className="input2";
				ComSetFocus(formObj.agmt_seq);
				break;
		}
	}
	/* end of developer job */
