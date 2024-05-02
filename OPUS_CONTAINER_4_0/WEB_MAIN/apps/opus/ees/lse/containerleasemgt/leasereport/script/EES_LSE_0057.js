/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0057.js
*@FileTitle  : Total Container Inventory by Lease Term & TY/SZ 
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
	 * @class EES_LSE_0057 : business script for EES_LSE_0057
	 */

	/* developer job */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var vCntrTpszHdr="| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz=vCntrTpszHdr.split("|");
	var vCntrTpszCnt=vArrCntrTpsz.length;
	var vOrcLstmCd="";
   	var vOrcCntrTpszCd="";
   	var vCnmvStsCd="";
   	var appendPageNo = 1;
   	var appendCondParam = "";
   	var rtv_total = 0;
   	var strLessorCode = "";
   	var strLessorName = "";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					dcondTD.innerHTML="&nbsp;"
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;
				case "btn_more":
	                doActionIBSheet(sheetObject2, formObj, IBSEARCHAPPEND, appendCondParam, appendPageNo);
	                break;
				case "btn_New":
					dcondTD.innerHTML="&nbsp;"
					ComResetAll();
					//sheetObject1.SheetWidth=984;
					for( var i=1; i < vCntrTpszCnt; i++ ) {
						if(vArrCntrTpsz[i] != "") {
							eval('sheetObject1.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
						} else {
							eval('sheetObject1.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
						}
					}
					rtv_total="0";
					formObj.loc_cd.value="";
					formObj.loc_cd.readOnly=true;
					formObj.loc_cd.className="input2";
					ComBtnDisable("btn_more");
					ComEnableObject(formObj.btns_search1, false);
					ComSetFocus(formObj.combo1);
					strLessorCode = "";
				   	strLessorName = "";
					comboObjects[3].SetSelectIndex(0);
					break;
				case "btn_DownExcel":
					//sheetObject1.SpeedDown2Excel(-1);
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true,DownCols: makeHiddenSkipCol(sheetObject1)});
						}
					break;
				case "btn_DownExcel2":
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
						}
					
					break;
				case "chk_expand":
					/* setting tree level */
					if ( srcObj.checked ) {
						sheetObject1.ShowTreeLevel(-1);
					} else {
						sheetObject1.ShowTreeLevel(0);
						sheetObject2.RemoveAll();
						dcondTD.innerHTML="&nbsp;"
					}
					break;
				case "btns_search1":
					// Location Search
					openPopup("1");
					break;
				case "btns_search2": 	// Form Lessor Search
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
	 * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj = document.form;
    	sheetObjects[0].SetWaitImageVisible(0);
		formObj.f_cmd.value=SEARCH12;
		var sXml=sheetObjects[0].GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObjects[0].SetWaitImageVisible(1);
		if(sXml != "") {
			if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != undefined ) {
				if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != "" ) {
					vCntrTpszHdr=ComGetEtcData(sXml, "cntr_tpsz_hd");
					vArrCntrTpsz=vCntrTpszHdr.split("|");
					vCntrTpszCnt=vArrCntrTpsz.length;
				}
			}
		}
		var formObj=document.form;
		formObj.pagerows.value=5000;
		for( var i=0 ; i < sheetObjects.length; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		ComBtnDisable("btn_more");
		sheet1_OnLoadFinish(sheet1);
		sheet2_OnLoadFinish(sheet2);
    }
    /**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
 		/* Axon Control Setting*/
		initControl();
		/* Focus Setting */
		ComSetFocus(formObj.combo1);
		ComEnableObject(formObj.btns_search1, false);
    }
    /**
	 * calling event after Load-Finish
	 */
    function sheet2_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Container Type Size Dynamic Header Setting */
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
		ComConfigSheet (sheetObjects[0] );
		initSheet(sheetObjects[0],1);
		ComEndConfigSheet(sheetObjects[0]);
//no support[implemented common]CLT 		sheetObjects[0].ScrollBar=3;
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//  		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',		'obj_change',	formObj); 
  	}
	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=ComGetEvent();
	    switch(ComGetEvent("name")){
	    	case "vndr_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	    	case "loc_cd" :
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(obj);
	        	break;
	    }
	}
   	/**
	 * Onhandling event in case of Change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch(ComGetEvent("name")) {
			case "loc_tp":		//Location Type
				if(obj.value == "") {
					formObj.loc_cd.value="";
					formObj.loc_cd.readOnly=true;
					formObj.loc_cd.className="input2";
					ComEnableObject(formObj.btns_search1, false);
					ComSetFocus(comboObjects[0]);
				} else {
					formObj.loc_cd.readOnly=false;
					formObj.loc_cd.className="input1";
					ComEnableObject(formObj.btns_search1, true);
					ComSetFocus(formObj.loc_cd);
				}
				break;
			case "loc_cd":
    			if(obj.value != "" && ComChkObjValid(obj, false)) {
    				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    			}
    			break;
    		case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
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
		var sheetid=sheetObj.id;
        switch(sheetid) {
            case "sheet1":
                with (sheetObj) {
	                var HeadTitle="|Lease Term / AGMT No.|AGMT No.||||Ref No.|Payment Type|Lessor Code|Lessor|Total"+ vCntrTpszHdr +"|";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"level_no",      KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"lstm_cd",    TreeCol:1,  KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0, Width:80,   Align:"Left",  ColMerge:0,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lse_pay_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"tpsz_total",    KeyField:0,   CalcLogic:"",   Format:"Integer" }];
	                for(var i=1; i < vCntrTpszCnt; i++) {
	                	var tpsz_dp_no="tpsz_dp"+ ComLpad(i, 2, "0");
	                	cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:tpsz_dp_no,      KeyField:0,   CalcLogic:"",   Format:"Integer" });
                        if (vArrCntrTpsz[i] != "") {
                            eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
                        } else {
                            eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
                        }
	                }
                    cols.push({Type:"AutoSum",       Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"",    KeyField:0,   CalcLogic:"",   Format:"Integer" });
  	                InitColumns(cols);
	                SetEditable(0);
	                SetColHidden("auto_sum",1);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                FrozenCols=5;
	                SetSheetHeight(220);
				}
				break;
			case "sheet2":
                with (sheetObj) {
				    var HeadTitle="Seq.|Lessor Code|Lessor|CNTR No.|TP/SZ|Term|On-hire Date|On-hire Yard|F/Days|Min On-hire Days|Used Days|Current Status|MVMT Yard|MVMT|MVMT Date";
				    var headCount=ComCountHeadTitle(HeadTitle);
				    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				    var headers = [ { Text:HeadTitle, Align:"Center"} ];
				    InitHeaders(headers, info);
				    var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Right",  ColMerge:1,   SaveName:"seq_no" },
				              {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd" },
				              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"onh_free_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer" },
				              {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"min_onh_dys",   KeyField:0,   CalcLogic:"",   Format:"Integer" },
				              {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"used_dys",      KeyField:0,   CalcLogic:"",   Format:"Integer" },
				              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
				              {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd" } ];
				    InitColumns(cols);
				    SetEditable(0);
				    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
				    SetSheetHeight(220);
				}
				break;
        }
    }
	/**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "combo1":
	        	with(comboObj) {
	            	SetDropHeight(250);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
	        	}
	        	break;
	        case "combo2":
	        	with(comboObj) {
	            	SetDropHeight(200);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
	            }
	        	break;
	        case "combo3":
	        	with(comboObj) {
	            	SetDropHeight(200);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
	            }
	        	break;
	    }
	}
	
	/**
	 * IBMulti Combo Item Setting
	 * XML의 ETC Data에 담겨진 Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
	 * param : sXml     ==> IBSheet 결과 XML
	 * param : comboObj ==> Combo Object
	 * param : sTextNm  ==> Combo Item Text Name in XML ETC Date
	 * param : sCodeNm  ==> Combo Item Code Name in XML ETC Date
	 * delim : delim    ==> Combo Item Text/Code Name Delimeter
	 */
	function LseComXml2ComboItem01(sXml, comboObj, sTextNm, sCodeNm, delim) {
		var strText=ComGetEtcData(sXml, sTextNm);
	    var strCode=ComGetEtcData(sXml, sCodeNm);
	    LseComText2ComboItem01(comboObj, strText, strCode, delim);
	}
	
	/**
	 * IBMulti Combo Item Setting
	 * Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
	 * param : comboObj ==> Combo Object
	 * param : sTextNm ==> Combo Item Text
	 * param : sCodeNm ==> Combo Item Code
	 * delim : delim   ==> Combo Item Text/Code Delimeter
	 */	
	function LseComText2ComboItem01(comboObj, strText, strCode, delim) {
		   var arrStrText=strText.split(delim);
		   var arrStrCode=strCode.split(delim);
		   LseComMakeComboObject01(comboObj, arrStrText, arrStrCode);
	}
	
	
	/**
	 * IBMulti Combo Item Setting
	 * param : comboObj ==> Combo Object
	 * param : arrStrNm ==> Combo Item Text Array
	 * param : arrStrCd ==> Combo Item Code Array
	 */
	function LseComMakeComboObject01(comboObj, arrStrText, arrStrCode) {
		var itemCnt=comboObj.GetItemCount();
		for ( var i=0 ; i < arrStrCode.length ; i++ ) {
			if(arrStrText[i] != "SO" && arrStrText[i] != "MO") {
				comboObj.InsertItem((i+itemCnt), arrStrText[i], arrStrCode[i]);
			}
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
    function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBCREATE:
	        	sheetObj.SetWaitImageVisible(0);
	        	//Lease Term Combo Item Setting
				formObj.f_cmd.value=SEARCH01;
				var sXml_1=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value=SEARCH02;
				var sXml_2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
				//Container Movement Status Combo Item Setting Start
				formObj.f_cmd.value=SEARCH11;
				var sXml_3=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
				formObj.f_cmd.value=SEARCH09;	
				var intgCdId='CD30090';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
		        sheetObj.SetWaitImageVisible(1);
				if(sXml_1 != "") {
					comboObjects[0].InsertItem(0 , 'ALL','');
					LseComXml2ComboItem01(sXml_1, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
					vOrcLstmCd=ComGetEtcData(sXml_1, "lease_term_cd");
				}
	            if ( sXml_2 != "" ) {
	            	comboObjects[1].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml_2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd=ComGetEtcData(sXml_2, "cntr_tpsz_cd");
	            }
	            if ( sXml_3 != "" ) {
	            	comboObjects[2].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml_3, comboObjects[2], "mvmt_sts_cd", "mvmt_sts_cd", "|");
	            	vCnmvStsCd=ComGetEtcData(sXml_3, "mvmt_sts_cd");
	            }
	            if (xml != "") {
					var schargeType=ComGetEtcData(xml, "code_nm");
					var arrchargeType=schargeType.split("@");
					MakeComboObject(comboObjects[3], arrchargeType, 1, 0);
				}
	            break;
           case IBSEARCH: 
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						formObj.lstm_cd.value=ComGetObjValue(comboObjects[0]);
						formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObjects[1]);
						formObj.cnmv_sts_cd.value=ComGetObjValue(comboObjects[2]);
						sheetObj.RemoveAll();
						sheetObj.SetWaitImageVisible(0);
	         			ComOpenWait(true);
	         			setTimeout( function () {
		         			var sXml=sheetObj.GetSearchData("EES_LSE_0057GS.do", FormQueryString(formObj));
							if ( sXml != "" ) {
								/*var comboVal=ComGetObjValue(comboObjects[1]);
								if ( comboVal != "" ) {
									for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
										eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
									}
									var arrComboVal=comboVal.split(",");
									for ( var i=0 ; i < arrComboVal.length ; i++ ) {
										for( var j=1; j < vCntrTpszCnt; j++ ) {
											if(arrComboVal[i] == vArrCntrTpsz[j]) {
												eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '",0);');
												break;
											}
										}
									}
								} else {
									for( var i=1; i < vCntrTpszCnt; i++ ) {
										if(vArrCntrTpsz[i] != "") {
											eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
										} else {
											eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
										}
									}
								}*/
								
								sheetObj.LoadSearchData(sXml,{Sync:0} );
								
								ComOpenWait(false);
							}
						} , 100);
					}
				}
				break;
			case IBSEARCH_ASYNC01: 	//Container Type Size Dynamic Header Setting
				sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH12;
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
				sheetObj.SetWaitImageVisible(1);
				if(sXml != "") {
					if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != undefined ) {
						if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != "" ) {
							vCntrTpszHdr=ComGetEtcData(sXml, "cntr_tpsz_hd");
							vArrCntrTpsz=vCntrTpszHdr.split("|");
							vCntrTpszCnt=vArrCntrTpsz.length;
						}
					}
				}
				break;
			case IBSEARCH_ASYNC02:	// retrieving for Location
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						formObj.f_cmd.value=SEARCH05;
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocTp=ComGetObjValue(formObj.loc_tp);
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
 			case IBSEARCH_ASYNC03:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");
					}
				}
				break;
 			case IBSEARCHAPPEND:
				if(sheetObj.id == "sheet2") {
					formObj.f_cmd.value=SEARCH01;
					
					//sheetObj.SetWaitImageVisible(1);
					ComOpenWait(true);
					sheetObj.DoSearch("EES_LSE_0057GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );
					
				}
				break;
        }
    }
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	var lstTotal = rtv_total;
    	if (sheetObj.RowCount()< lstTotal) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	 appendPageNo = 1;
            ComBtnDisable("btn_more");
        }
  
		ComOpenWait(false);
		sheetObj.SetWaitImageVisible(0);
	}
    
	/**
	 * handling event in case of Scroll-Next sheet<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
//method change[check again]CLT 	function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
//		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
//	}
	/**
	 * handling event in case of Mouse-Move sheet
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var isFlag=GetRowLevel(MouseRow()) >= 0;
			SetDataLinkMouse("lstm_cd",GetRowLevel(MouseRow()) > 0);
			SetDataLinkMouse("vndr_abbr_nm",isFlag);
			SetDataLinkMouse("tpsz_total",isFlag);
			for(var i=1; i < vCntrTpszCnt; i++) {
				var tpsz_dp_no="tpsz_dp"+ ComLpad(i, 2, "0");
            	SetDataLinkMouse(tpsz_dp_no,isFlag);
			}
		}
	}
	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var sLocCd=sheetObj.GetCellValue(Row,"loc_cd");
		var param="";
		appendCondParam = "";
		if(sheetObj.GetRowLevel(Row) > 0) {
			//ComSetObjValue(formObj.hcond_vndr_seq, sheetObj.GetCellValue(Row,"vndr_seq"));
			ComSetObjValue(formObj.hcond_vndr_seq,formObj.vndr_seq.value);
		}
		switch (sName) {
			case "tpsz_dp01": case "tpsz_dp02": case "tpsz_dp03":
			case "tpsz_dp04": case "tpsz_dp05": case "tpsz_dp06":
			case "tpsz_dp07": case "tpsz_dp08": case "tpsz_dp09":
			case "tpsz_dp10": case "tpsz_dp11": case "tpsz_dp12":
			case "tpsz_dp13": case "tpsz_dp14": case "tpsz_dp15":
			case "tpsz_dp16": case "tpsz_dp17": case "tpsz_dp18":
			case "tpsz_dp19": case "tpsz_dp20": case "tpsz_dp21":
			case "tpsz_dp22": case "tpsz_dp23": case "tpsz_dp24":
			case "tpsz_dp25": case "tpsz_dp26": case "tpsz_dp27":
			case "tpsz_dp28": case "tpsz_dp29": case "tpsz_dp30":
				param="&lstm_cd=" + findTopLevelLstmText(sheetObj, Row)
				      + "&cnmv_sts_cd=" + ComGetObjValue(formObj.hcond_mvsts_cd)
					  + "&cntr_tpsz_cd=" + sheetObj.GetCellText(0, Col)
					  + "&vndr_seq="+ ComGetObjValue(formObj.hcond_vndr_seq)
					  + "&agmt_cty_cd=" + sheetObj.GetCellValue(Row,"agmt_cty_cd")
					  + "&agmt_seq=" + sheetObj.GetCellValue(Row,"agmt_seq")						  
					  + "&lse_pay_tp_cd=" + sheetObj.GetCellValue(Row,"lse_pay_tp_cd");
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML="Lease Term : "+ findTopLevelLstmText(sheetObj, Row)
					+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.GetCellValue(Row,"agmt_no")
					+ ",&nbsp;&nbsp;Lessor : "+ sheetObj.GetCellValue(Row,"vndr_abbr_nm")
						   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.GetCellText(0, Col);
				}
				break;
			case "tpsz_total":
			case "vndr_abbr_nm":
				param="&lstm_cd=" + findTopLevelLstmText(sheetObj, Row)
				      + "&cnmv_sts_cd=" + ComGetObjValue(formObj.hcond_mvsts_cd)
					  + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&vndr_seq="+ ComGetObjValue(formObj.hcond_vndr_seq)
					  + "&agmt_cty_cd=" + sheetObj.GetCellValue(Row,"agmt_cty_cd")
					  + "&agmt_seq=" + sheetObj.GetCellValue(Row,"agmt_seq")						  
					  + "&lse_pay_tp_cd=" + sheetObj.GetCellValue(Row,"lse_pay_tp_cd");
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML="Lease Term : "+ findTopLevelLstmText(sheetObj, Row)
					+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.GetCellValue(Row,"agmt_no")
					+ ",&nbsp;&nbsp;Lessor : "+ sheetObj.GetCellValue(Row,"vndr_abbr_nm");
				}
				break;
			case "lstm_cd":
				if(sheetObj.GetMousePointer== "Hand") {
					param="&lstm_cd=" + findTopLevelLstmText(sheetObj, Row)
					      + "&cnmv_sts_cd=" + ComGetObjValue(formObj.hcond_mvsts_cd)
						  + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq="+ ComGetObjValue(formObj.hcond_vndr_seq)
						  + "&agmt_cty_cd=" + sheetObj.GetCellValue(Row,"agmt_cty_cd")
						  + "&agmt_seq=" + sheetObj.GetCellValue(Row,"agmt_seq")						  
						  + "&lse_pay_tp_cd=" + sheetObj.GetCellValue(Row,"lse_pay_tp_cd");
					dcondTD.innerHTML="Lease Term : "+ findTopLevelLstmText(sheetObj, Row)
					+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.GetCellValue(Row,"agmt_no");
				}
				break;
		}
		
		if ( param != "") {
			var rowTotal = ""+sheetObj.GetCellValue(Row,Col);
			rowTotal = rowTotal.replace(/,/gi, '');
			if(rowTotal == "") rowTotal = 0;
			rtv_total=rowTotal;
			if(Number(rowTotal) > 5000) {
				ComBtnEnable("btn_more");
			}else{
				ComBtnDisable("btn_more");
			}
			
			if(sheetObj.GetRowLevel(Row) >= 0) {
				param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params);
			}else if(sheetObj.GetRowLevel(Row) == -1){
				var allRowCount = sheetObj.RowCount();
				var allTpVal = "";
				for(var i=1;i<allRowCount + 1;i++) {
					if(sheetObj.GetRowLevel(i) == 0) {
						allTpVal = allTpVal+","+sheetObj.GetCellValue(i,"lstm_cd");
					}
				}
				
				param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params)+"&g_ttl="+allTpVal;
			}
			
			strLessorCode = sheetObj.GetCellValue(Row,"vndr_seq");
			strLessorName = sheetObj.GetCellValue(Row,"vndr_abbr_nm");
			
			appendPageNo=1;
			sheetObjects[1].SetWaitImageVisible(0);
			ComOpenWait(true);
			appendCondParam = param;
			sheetObjects[1].DoSearch("EES_LSE_0057GS.do",param );
		}
	}
	/**
	 * sheet1_OnMouseDown
	 * handling event in case of Mouse_Down sheet
	 */
	function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {
		var formObj=document.form;
		var sRow=sheetObj.MouseRow();
		var sCol=sheetObj.MouseCol();
		var sName=sheetObj.ColSaveName(sCol);
		var sLocCd=sheetObj.GetCellValue(sRow,"loc_cd");
		var param="";
		if(sRow > sheetObj.HeaderRows()&& sRow == sheetObj.LastRow()){
			switch (sName) {
				case "tpsz_dp01": case "tpsz_dp02": case "tpsz_dp03":
				case "tpsz_dp04": case "tpsz_dp05": case "tpsz_dp06":
				case "tpsz_dp07": case "tpsz_dp08": case "tpsz_dp09":
				case "tpsz_dp10": case "tpsz_dp11": case "tpsz_dp12":
				case "tpsz_dp13": case "tpsz_dp14": case "tpsz_dp15":
				case "tpsz_dp16": case "tpsz_dp17": case "tpsz_dp18":
				case "tpsz_dp19": case "tpsz_dp20": case "tpsz_dp21":
				case "tpsz_dp22": case "tpsz_dp23": case "tpsz_dp24":
				case "tpsz_dp25": case "tpsz_dp26": case "tpsz_dp27":
				case "tpsz_dp28": case "tpsz_dp29": case "tpsz_dp30":
					param="&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
					      + "&cnmv_sts_cd=" + ComGetObjValue(formObj.hcond_mvsts_cd)
						  + "&cntr_tpsz_cd=" + sheetObj.GetCellText(0, sCol)
						  + "&vndr_seq="+ ComGetObjValue(formObj.hcond_vndr_seq)
						  + "&agmt_cty_cd=" + sheetObj.GetCellValue(sRow,"agmt_cty_cd")
						  + "&agmt_seq=" + sheetObj.GetCellValue(sRow,"agmt_seq");
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML="Lease Term : "+ findTopLevelLstmText(sheetObj, sRow)
						+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.GetCellValue(sRow,"agmt_no")
						+ ",&nbsp;&nbsp;Lessor : "+ sheetObj.GetCellValue(sRow,"vndr_abbr_nm")
							   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.GetCellText(0, sCol);
					}
					break;
				case "tpsz_total":
				case "vndr_abbr_nm":
					param="&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
					      + "&cnmv_sts_cd=" + ComGetObjValue(formObj.hcond_mvsts_cd)
						  + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq="+ ComGetObjValue(formObj.hcond_vndr_seq)
						  + "&agmt_cty_cd=" + sheetObj.GetCellValue(sRow,"agmt_cty_cd")
						  + "&agmt_seq=" + sheetObj.GetCellValue(sRow,"agmt_seq");
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML="Lease Term : "+ findTopLevelLstmText(sheetObj, sRow)
						+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.GetCellValue(sRow,"agmt_no")
						+ ",&nbsp;&nbsp;Lessor : "+ sheetObj.GetCellValue(sRow,"vndr_abbr_nm");
					}
					break;
				case "lstm_cd":
					param="&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
					      + "&cnmv_sts_cd=" + ComGetObjValue(formObj.hcond_mvsts_cd)
						  + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq="+ ComGetObjValue(formObj.hcond_vndr_seq)
						  + "&agmt_cty_cd=" + sheetObj.GetCellValue(sRow,"agmt_cty_cd")
						  + "&agmt_seq=" + sheetObj.GetCellValue(sRow,"agmt_seq");
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML="Lease Term : "+ findTopLevelLstmText(sheetObj, sRow)
						+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.GetCellValue(sRow,"agmt_no");
					}
					break;
			}
			if ( param != "" && sheetObj.GetRowLevel(sRow) >= 0) {
				
				strLessorCode = sheetObj.GetCellValue(Row,"vndr_seq");
				strLessorName = sheetObj.GetCellValue(Row,"vndr_abbr_nm");
				
				param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params);
				sheetObjects[1].SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObjects[1].DoSearch("EES_LSE_0057GS.do",param );
				ComOpenWait(false);
			}
		}
	}
	/**
	 * returing Lease Term for Agreement
	 */
	function findTopLevelLstmText(sheetObj, rowIdx) {
		var vLstmText="";
		with(sheetObj) {
			for(var i=rowIdx; i >= HeaderRows(); i--) {
				if(GetRowLevel(i) == "0") {
					vLstmText=sheetObj.GetCellValue(i,"lstm_cd");
					break;
				}
			}
		}
		return vLstmText;
	}
	
	
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
		with(sheetObj) {
			
			RenderSheet(0);
			var comboVal=ComGetObjValue(comboObjects[1]);
			if ( comboVal != "" ) {
				for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
					eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
				}
				var arrComboVal=comboVal.split(",");
				for ( var i=0 ; i < arrComboVal.length ; i++ ) {
					for( var j=1; j < vCntrTpszCnt; j++ ) {
						if(arrComboVal[i] == vArrCntrTpsz[j]) {
							eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '",0);');
							break;
						}
					}
				}
			} else {
				for( var i=1; i < vCntrTpszCnt; i++ ) {
					if(vArrCntrTpsz[i] != "") {
						eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
					} else {
						eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
					}
				}
			}

			ShowTreeLevel(formObj.chk_expand.checked);
			var formObj=document.form;
			formObj.hcond_vndr_seq.value=ComGetObjValue(formObj.vndr_seq);
			formObj.hcond_lstm_cd.value=ComGetObjValue(formObj.lstm_cd);
			formObj.hcond_tpsz_cd.value=ComGetObjValue(formObj.cntr_tpsz_cd);
			formObj.hcond_mvsts_cd.value=ComGetObjValue(formObj.cnmv_sts_cd);
			formObj.hcond_params.value="&loc_cd=" + ComGetObjValue(formObj.loc_cd)
					  				   + "&loc_tp=" + ComGetObjValue(formObj.loc_tp);
			if(SearchRows()> 0) { 
                var totalVal = 0;
                var viewCnt = 0;
                for(var j=10; j < LastCol(); j++) {
                    totalVal = GetCellText(LastRow()-1, j);
                    if(totalVal == 0) {
                        SetColHidden(j,1);
                    }
                    else {
                        SetCellText(LastRow(), j , totalVal);
                        viewCnt++;
                    }
                }
                SetColHidden(LastCol(),1);
                RowDelete(LastRow()-1, false);
                SetMergeCell(LastRow(), 1, 1, 5);
                SetCellValue(LastRow(), "lstm_cd","G.TTL",0);
                //SetSheetWidth(310 + (viewCnt * 80));
            }
			
			RenderSheet(1);
		}
    }
    /**
	 * handling event in case of OnCheckClick combo1
	 * @return
	 */
	function combo1_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
	/**
	 * handling event in case of OnCheckClick combo1
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
	/**
	 * handling event in case of OnCheckClick combo1
	 * @return
	 */
	function combo3_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
    /**
	 * combo2_OnBlur
	 */
	//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

	function combo1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.lstm_cd.value=ComGetObjValue(comboObj);
	}
    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
	}
	/**
	 * combo3_OnBlur
	 */
	function combo3_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.cnmv_sts_cd.value=ComGetObjValue(comboObj);
	}
	/**
	 * combo1_OnKeyDown
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.lstm_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	/**
	 * combo2_OnKeyDown
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	/**
	 * combo3_OnKeyDown
	 */
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cnmv_sts_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	} else if ( type == "2" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    }
    /**
	 * handling event in case of Lessor(Service Provider) Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
    				if(formObj.loc_cd.className == "input1" && formObj.loc_cd.value == "") {
    					ComShowCodeMessage("LSE01046");
    					ComSetFocus(formObj.loc_cd);
						return false;
    				}
    				return true;
    				break;
				default :	//do nothing
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
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
		}
	}
	/**
	 * creating combo object(Spec No * Type/Size)
	 */
	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "ALL", "ALL");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex(0 ,true);
	} 
	/* end of developer job */
