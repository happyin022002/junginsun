/*=========================================================
 
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0006.js
*@FileTitle  : Term Change Inquiry
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
     * @class EES_LSE_0006 : business script for EES_LSE_0006
     */
    function EES_LSE_0006() {
    	this.processButtonClick=processButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initControl=initControl;
		this.obj_blur=obj_blur;
//		this.obj_focus=obj_focus;
		this.obj_change=obj_change;
//		this.obj_keypress=obj_keypress;
//		this.obj_keyup=obj_keyup;
//		this.obj_keydown=obj_keydown;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.sheet1_OnScrollNext = sheet1_OnScrollNext;
		this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
		this.openPopup=openPopup;
		this.setPopData_Agreement=setPopData_Agreement;
		this.setPopData_Lessor=setPopData_Lessor;
		this.validateForm=validateForm;
		this.clearForm=clearForm;
    }
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
		 var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_retrieve":
						if(ComChkValid(formObj) == true) {
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
						break;
					case "btn_new":
						ComResetAll();
						if(formObj.dcond_tp.value == "01") {
							//div_dcond1.style.display="inline";
							$(".div_dcond1").css("display","");
							//div_dcond2.style.display="none";
							$(".div_dcond2").css("display","none");
				    		ComSetFocus(formObj.agmt_seq1);
				    	} else {
				    		//div_dcond1.style.display="none";
				    		$(".div_dcond1").css("display","none");
							//div_dcond2.style.display="inline";
							$(".div_dcond2").css("display","");
				    		ComSetFocus(formObj.vndr_seq2);
				    	}
						break;
					case "btn_downexcel":
						ComOpenWait(true);
						sheetObjects[1].LoadSearchData(vXmlBuff,{Sync:0} );
						if(sheetObjects[1].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
							}
						ComOpenWait(false);
						break;
					case "btns_search":		//AGMT No.
	 					openPopup("1");
	 					break;
	 				case "btns_search2":	//Lessor
	 					openPopup("2");
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
		/* Axon Control Setting*/
    	initControl();
    	/* begin Focus Setting */
    	if(formObj.dcond_tp.value == "01") {
    		ComSetFocus(formObj.agmt_seq1);
    	} else {
    		ComSetFocus(formObj.vndr_seq2);
    	}
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
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
	    	case "agmt_seq1" :
	    	case "vndr_seq2" :
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
  			case "dcond_tp":
  				if(obj.value == "01") {
  					//div_dcond1.style.display="inline";
  					$(".div_dcond1").css("display","");
  					//div_dcond2.style.display="none";
  					$(".div_dcond2").css("display","none");
  					$("#view1").css("display","");
  					$("#view2").css("display","none");
  					clearForm("vndr_seq2");
  				} else {
  					//div_dcond1.style.display="none";
  					$(".div_dcond1").css("display","none");
  					//div_dcond2.style.display="inline";
  					$(".div_dcond2").css("display","");
  					$("#view1").css("display","none");
  					$("#view2").css("display","");
  					clearForm("agmt_seq1");
  				}
  				ComSetNextFocus(obj);
  				break;
  			case "agmt_seq1":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
				}
				break;
			case "vndr_seq2":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
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
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

	                var HeadTitle1="Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Before|Before|Before|Before|Before|Before|After|After|After|After|After|After";
	                var HeadTitle2="Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|Contract Period|Contract Period|Agreement|Term|Contract No.|Lessor|ERP FA I/F|ERP FA I/F";
	                var HeadTitle3="Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|EFF. Date|EXP. Date|Agreement|Term|Contract No.|Lessor|Date|Y";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                //(headCount, 5, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"},
	                              { Text:HeadTitle3, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bef_agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bef_lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"bef_ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bef_vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bef_lst_bef_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bef_lst_exp_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aft_agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"aft_lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"aft_ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"aft_vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aft_fa_if_dt",      KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"aft_fa_if_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
	                 
	                InitColumns(cols);

	                SetEditable(0);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                SetSheetHeight(420);
	                SetHeaderRowHeight(10);
	                ComResizeSheet(sheetObj);
               }
                break;
			case "sheet2":      //sheet1 init
                with (sheetObj) {
		        
			        var HeadTitle1="Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Before|Before|Before|Before|Before|Before|After|After|After|After|After|After";
			        var HeadTitle2="Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|Contract Period|Contract Period|Agreement|Term|Contract No.|Lessor|ERP FA I/F|ERP FA I/F";
			        var HeadTitle3="Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|EFF. Date|EXP. Date|Agreement|Term|Contract No.|Lessor|Date|Y";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        //(headCount, 5, 0, true);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"},
			                    { Text:HeadTitle3, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bef_agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bef_lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"bef_ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bef_vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bef_lst_bef_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bef_lst_exp_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aft_agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"aft_lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"aft_ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"aft_vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aft_fa_if_dt",      KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"aft_fa_if_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
			         
			        	InitColumns(cols);

			        	SetEditable(0);
			        	SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			        	SetSheetHeight(420);
			        	SetHeaderRowHeight(10);
			        	ComResizeSheet(sheetObj);
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
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						vXmlBuff=sheetObj.GetSearchData("EES_LSE_0006GS.do",FormQueryString(formObj));
						sheetObj.LoadSearchData(vXmlBuff,{Sync:0} );
					}
				}
				break;
			case IBSEARCHAPPEND:
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value=SEARCH;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch("EES_LSE_0006GS.do", CondParam+"&"+ "iPage="+ PageNo,{Append:true} );
					ComOpenWait(false);
				}
				break;
			case IBSEARCH_ASYNC01:
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param="f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.agmt_seq1);
 						sheetObj.WaitImageVisible = false;
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.vndr_seq1, ComGetEtcData(sXml, "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm1,  ComGetEtcData(sXml, "vndr_nm"));
								ComSetObjValue(formObj.lstm_cd1,  ComGetEtcData(sXml, "lstm_cd"));
								ComSetFocus(formObj.vndr_nm1);
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								clearForm("agmt_seq1");
							}
						}
 					}
				}
				break;
			case IBSEARCH_ASYNC02:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq2);
					sheetObj.SetWaitImageVisible(0);//parameter changed[check again]CLT 					
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm2, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetFocus(formObj.vndr_nm2);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq2");
 							ComSetFocus(formObj.vndr_seq2);
 						}
					} else {
						ComShowCodeMessage("LSE01019");
						clearForm("vndr_seq2");
						ComSetFocus(formObj.vndr_seq2);
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
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 820, 480, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "2" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 715, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }
    
    /**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//do nothing
    	ComOpenWait(false);
    }
    
    
	/**
     * handing process Agreement Pop-up Return Value <br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
    		ComSetObjValue(formObj.agmt_seq1, aryPopupData[0][5]);
    		ComSetObjValue(formObj.vndr_seq1, aryPopupData[0][8]);
    		ComSetObjValue(formObj.vndr_nm1,  aryPopupData[0][9]);
    		ComSetObjValue(formObj.lstm_cd1,  aryPopupData[0][7]);
    	}
    }
    /**
	 * handing process Lessor(Service Provider) Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq2, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm2,  aryPopupData[0][4]);
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
    				if(formObj.dcond_tp.value == "01" && formObj.agmt_seq1.value == "") {
    					ComShowCodeMessage("LSE01006");
			    		ComSetFocus(formObj.agmt_seq1);
			    		return false;
    				} else if(formObj.dcond_tp.value == "01" && formObj.vndr_seq1.value == "") {
    					return false;
			    	} else if(formObj.dcond_tp.value == "02" && formObj.vndr_seq2.value == "") {
			    		ComShowCodeMessage("LSE01044");
			    		ComSetFocus(formObj.vndr_seq2);
			    		return false;
			    	}
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}
        return true;
    }
	/**
	 * handling process for input file name
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "agmt_seq1":
				ComSetObjValue(formObj.agmt_seq1,    "");
				ComSetObjValue(formObj.vndr_seq1, 	"");
				ComSetObjValue(formObj.vndr_nm1,  	"");
				ComSetObjValue(formObj.lstm_cd1,     "");
				ComSetFocus(formObj.agmt_seq1);
				break;
			case "vndr_seq2":
				ComSetObjValue(formObj.vndr_seq2, 	"");
				ComSetObjValue(formObj.vndr_nm2,  	"");
				ComSetFocus(formObj.vndr_seq2);
				break;
		}
	}
	/* end of developer job */
