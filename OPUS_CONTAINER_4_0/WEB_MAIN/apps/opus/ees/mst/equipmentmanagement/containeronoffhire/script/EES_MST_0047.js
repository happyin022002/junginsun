/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0047.js
*@FileTitle  : Reefer Unit Info Inquiry and Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class ees_mst_0047 : ees_mst_0047 business script for
 */

	 // common static variable
	 var sheetObjects=new Array();
	 var comboObjects=new Array();
	 var sheetCnt=0;
	 var tcnt=0;
	 var comboCnt=0 ; 
	 var blurflg=false; 
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 /**
	  * initializing sheet
	  * implementing onLoad event handler in body tag
	  * adding first-served functions after loading screen.
	  */
	 function loadPage() {
		 for(i=0;i<sheetObjects.length;i++){
	         ComConfigSheet(sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         ComEndConfigSheet(sheetObjects[i]);
	     }
		 
		/* with (rstr_usg_lbl) {
		 	SetMultiSelect(1);
		 	SetMultiSeparator(",");
		 	SetDropHeight(150);
		}   */
		 
		         
		 comboObjects[1].RemoveAll();
		 comboObjects[1].InsertItem(0 , 'ALL',''); 
	        
		 comboObjects[1].SetItemCheck(0,1);
		 comboObjects[1].SetEnable(1);
	        
	     initControl();
	  	 for ( var k=0 ; k < comboObjects.length ; k++ ) {
	 		initCombo(comboObjects[k], k+1);
	 	 }
	  	 sheetObj = sheetObjects[0];
	      var formObject = document.form;      
	      doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01); //TP/SZ,MVMT Status,Lease Term data 가져오기
	      doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02); //TP/SZ,MVMT Status,Lease Term data 가져오기
	      
	      sheet1_OnLoadFinish(sheetObj);
	 }
	 
	 
	 function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if (isExceedMaxRow(msg))return;
		
		var sheetObject1=sheetObjects[0];
        var formObject=document.form;
		formObject.cntr_nos.value="";
		if (sheetObject1.RowCount()> 0){
			formObject.cntr_nos.value=sheetObject1.GetCellValue(1,"cntr_no");
		    doActionIBSheet(sheetObject1,document.form,IBSEARCH);
		} else {
    		return;							
		}			
	}
	 
	 
	 function sheet1_OnLoadFinish(sheetObj) {
		 var formObj = document.form;
		 formObj.f_cmd.value=SEARCH08;			
		 var xml="";
		 xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
		 var comboItems=ComGetEtcData(xml, "unit_type").split("|");
		 
		 var rfTpCdCode = "";
		 var rfTpCdText = "";
		 var rfTpCdArr = "";
		 for(var i=0;i<comboItems.length;i++) {
			 rfTpCdArr = comboItems[i].split(",");
			 rfTpCdCode = rfTpCdCode + "|" + rfTpCdArr[0];
			 rfTpCdText =  rfTpCdText + "|" + rfTpCdArr[1];
		 }	
		
		 sheetObj.SetColProperty("rf_tp_cd", {ComboText:rfTpCdText, ComboCode:rfTpCdCode} );
		 			
		formObj.f_cmd.value=SEARCH11;			
		var xml="";
		xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
		var comboItems=ComGetEtcData(xml, "rf_humid_ctrl_val_cd").split("|");
		
		var rfHCVCdCode = "";
		 var rfHCVCdText = "";
		 var rfHCVCdArr = "";
		 for(var i=0;i<comboItems.length;i++) {
			 rfHCVCdArr = comboItems[i].split(",");
			 rfHCVCdCode = rfHCVCdCode + "|" + rfHCVCdArr[0];
			 rfHCVCdText =  rfHCVCdText + "|" + rfHCVCdArr[1];
		 }	
		 sheetObj.SetColProperty("rf_humid_ctrl_val_cd", {ComboText:rfHCVCdText, ComboCode:rfHCVCdCode} );
	}
	  
	 /** 
	     * MultiCombo object initial property //LHS
	     * @param comboObj
	     * @param comboNo
	     * @return
	     */
	    function initCombo (comboObj, comboNo) {
	   	 switch(comboObj.options.id) {
		   	 case "combo1":
				with(comboObj) {
					SetDropHeight(150);
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetMultiSeparator(",");
					Style=0;
					combo1.SetSelectIndex(0);
				}
			break;
			case "combo2":
				with(comboObj) {
					SetDropHeight(150);
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetMultiSeparator(",");
					Style=0;
				}
			break;
	   	 }      	
	 }
	 /**
      * registering IBsheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){        
         sheetObjects[sheetCnt++]=sheet_obj;
     }
   	/**
	  * registering IBCombo Object as list
	  * adding process for list in case of needing batch processing with other items 
	  * defining list on the top of source
	*/
     function setComboObject(combo_obj){
         comboObjects[comboCnt++]=combo_obj;
     }
     
 	 // Axon handling event
 	 // 1. event catch
 	 function initControl() {
 		var formObj=document.form;
 		axon_event.addListenerFormat('blur',	'obj_blur',          form);   //- handling OnBeforeDeactivate event of all control except rdoCity 		
        axon_event.addListenerFormat('focus',   'obj_focus',         form);   //- handling OnBeforeDeactivate event of all control that has dataformat attribute
        axon_event.addListenerForm('change',	'obj_change',	     formObj); 
        axon_event.addListener('change', 'ru_lable_type_OnChange', 'ru_lable_type', '');
 	    // axon_event.addListener('keydown',		'ComKeyEnter',	     'form'); //- when key down
 	    // axon_event.addListenerFormat('keypress','obj_keypress',	     form);   //- when key down
  	}
// 	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    var vKeyCode=event.keyCode;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
//	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
//	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
//	            break;
//	        case "ymd":
//	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
//	        	break;
//	    }
//	}
	//Axon handling event2. 이벤트처리함수
	function obj_blur(){
		var formObj=document.form;
		var obj=event.srcElement;
	    if (event.srcElement.name == "hire_date"){
	    }else if(event.srcElement.name == "vndr_seq") {
	    	
	    	//ComChkObjValid(obj, true, false, false);
            //break;
	    }else {
            //Validation  check(lenth, format, max, min etc)
            ComChkObjValid(obj);
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
    		case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  				}
  				break;
		}
	}
	//Axon handling event2. 이벤트처리함수
	function obj_focus(){
		var formObj=document.form;
		var obj=event.srcElement;
	    if (event.srcElement.name == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    }	
	}
     // Event handler processing by button name */
     function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var formObject=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
	     		case "btns_vndr":	// Lessor Code 가져오기 팝업
	     			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 700, 540, "vndr_seq:vndr_seq|vndr_abbr_nm:vndr_abbr_nm|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "0,0,1,1,1,1", true);
				break;	           	
				case "btn_retrieve":
					if (formObject.vndr_seq.value == "") {
						ComShowCodeMessage("MST00001", "Lessor");
					} else {
						formObject.cntr_nos.value="";
						sheetObject1.RemoveAll();
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
				break;
				case "btn_loadexcel" :
					sheetObject1.RemoveAll();
					//var ccheck = sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false});
					var ccheck = sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",Append:false});
							
				break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	        	    }
				break;	
				case "btn_rulabel_cd":	//RU Label 조회 팝업
					var par_rulabel_type = form.hid_rulabel_type.value;
					var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
					var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
					var loc_code="";
					ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
					break;
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.vndr_seq.value="";
					formObject.vndr_abbr_nm.value="";
					formObject.vndr_lgl_eng_nm.value="";
					formObject.cntr_nos.value="";
					formObject.sts_flg[0].checked=true;
					formObject.mi_flg[0].checked=true;
					formObject.agmt_seq.value="";
					formObject.rstr_usg_lbl.value="";
					formObject.hid_rulabel_type.value="";
					formObject.agmt_cty_cd.value="HHO";
					for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
						comboObjects[0].SetItemCheck(i,0);
					}
					comboObjects[0].SetItemCheck(0,1);
					formObject.lstm_cd.value="";
					for(var i=1 ; i < comboObjects[2].GetItemCount(); i++ ){
						comboObjects[2].SetItemCheck(i,0);
					}
					comboObjects[2].SetItemCheck(0,1);
					formObject.cntr_tpsz_cd.value="";
					
					form.ru_lable_type.options[0].selected = true;
					comboObjects[1].RemoveAll();
			        comboObjects[1].InsertItem(0 , 'ALL',''); 
			        
			        comboObjects[1].SetItemCheck(0,1);
			        comboObjects[1].SetEnable(1);
			        
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE)
				break;
					
                case "ComOpenPopupWithTargetAgmtNo": //agmt no
                	if (formObject.agmt_seq.readOnly == false)
                		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 1000, 480, 'setPopData_Agreement', '0,0,1', true); 			                	
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
      * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
      * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
      * @returns string <br>
      */
     function ComToHtml2(obj){
         try {
             //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
             var str = getArgValue(obj);

             str = str.replace(/&/gi, "@amp;");
             return str;
         } catch(err) { ComFuncErrMsg(err.message); }
     }
     
     
     /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // t1sheet1 init
            	    with(sheetObj){
		               var HeadTitle1="|CNTR No.|TP/SZ|Term|On Hire Date|AGMT No|RU Label Type|RU Label Value|Maker Name|Maker Code|Unit Type|Humidity Control|Compressor|Model No|Refrigerant|Min Temp(℃)|Max Temp(℃)|a|b|c|d|e|f";
		               SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"onh_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_tp",     KeyField:0,   CalcLogic:"",   Format:""		,            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_desc",     KeyField:0,   CalcLogic:"",   Format:""		,            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rf_mkr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"PopupEdit",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rf_mkr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:6 },
		                      {Type:"Combo",   Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"rf_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Combo",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"rf_humid_ctrl_val_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rf_cmpr_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rf_mdl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:45 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rf_rfr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , EditLen:25},
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"min_temp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3 },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"max_temp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aeflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"beflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ceflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"deflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eeflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"feflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetShowButtonImage(1);
		               FrozenCols=6;
		               SetColProperty(0 ,"rf_mkr_seq" , {AcceptKeys:"N" , InputCaseSensitive:1});
		               SetColProperty(0 ,"min_temp" , {AcceptKeys:"N|[-]" , InputCaseSensitive:1});
		               SetColProperty(0 ,"max_temp" , {AcceptKeys:"N|[-]" , InputCaseSensitive:1});
		               //SetColProperty(0,"rf_tp_cd", {ComboText:"|CA (Controlled Atmosphere)|DF (Deep Freezer)|MG (Magnum)|HU (Humidity)|UF (Ultra Freezer)", ComboCode:"|C|D|M|H|U"} );
		              // SetSheetHeight(410);
		               resizeSheet();
             		}
                 break;
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
 				case "rf_mkr_seq":
 					var strRfMkrSeq = sheetObj.GetCellValue(Row,Col);
 					if(strRfMkrSeq != "") {
	 					var param="f_cmd="+SEARCH06+"&vndr_seq="+strRfMkrSeq;
						sheetObj.SetWaitImageVisible(1);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								sheetObj.SetCellValue(Row,"rf_mkr_nm",ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							sheetObj.SetCellValue(Row,Col,"");
	 						}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							sheetObj.SetCellValue(Row,Col,"");
						}
						sheetObj.SetWaitImageVisible(0);
 					}else{
 						sheetObj.SetCellValue(Row,"rf_mkr_nm","");
 					}
 					break;
 				default :
 					//do nothing
 			}
 		}
  	}
 	
 	
 	function sheet1_OnPopupClick(sheetObj, Row,Col,Value){
        if (sheetObj.ColSaveName(Col) == "rf_mkr_seq"){
        	ComOpenPopup("/opuscntr/COM_ENS_0C1.do",700, 540, "setPopData_Agreement1", "0,0,1,1,1,1", true, true, Row, Col);
        } 
   }
 	
 	function setPopData_Agreement1(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj=document.form;
  	    var sheetObj=sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	    	sheetObj.SetCellValue(Row,"rf_mkr_nm",aryPopupData[0][4]);
  	    	sheetObj.SetCellValue(Row,"rf_mkr_seq",aryPopupData[0][2]);
  	    }
  	} 	     
 	
     // handling process for sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction)){
				 var aecnt=0;
				 var becnt=0;
				 var cecnt=0;
				 var decnt=0;
				 var eecnt=0;    
				 var fecnt=0; 
				 var tmpCntrNo="";
				 
				 if (formObj.cntr_nos.value != ""){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);				
					formObj.f_cmd.value=SEARCH;
		     	    var sParam=ComGetSaveString(sheetObjects[0]);
		     	    sParam += "&" + FormQueryString(formObj);
		     	    var sXml=sheetObj.GetSearchData("EES_MST_0047GS.do", sParam);
		     	    ComOpenWait(false);		     	    
		     	    var chk=sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					   return;
					} else {
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					} 	
	        		
				 } else {
	                 sheetObj.SetWaitImageVisible(0);
	                 ComOpenWait(true); 						
					 formObj.f_cmd.value=SEARCH01;
		     	     var sParam=ComGetSaveString(sheetObjects[0]);
		     	     sParam += "&" + FormQueryString(formObj);
		     	     var sXml=sheetObj.GetSearchData("EES_MST_0047GS.do", sParam);
		     	     ComOpenWait(false);
		     	     var chk=sXml.indexOf("ERROR");
					 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					   return;
					 } else {
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					 } 					 
				 }
             }
			break;
			case IBSEARCH_ASYNC01:
				/* Lease Term Form Combo Item Setting */
				sheetObj.SetWaitImageVisible(0);
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
				var chk=sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchData(sXml,{Sync:0} );
					 return;
				 }	  
				 //Lease Term retrieve
		         var lstmCd=ComGetEtcData(sXml,"lease_term_cd");
		         var strLstmCd=lstmCd.split("|");
		         with (combo1) {		        
		        	 combo1.InsertItem(0 , 'ALL','ALL'); 
		        	 var t=1;
		        	 for ( var i=1; i<=strLstmCd.length; i++) {
		        		 if (strLstmCd[i-1]=="LT" ||strLstmCd[i-1]=="ST" ||strLstmCd[i-1]=="OF" || strLstmCd[i-1]=="SI" || strLstmCd[i-1]=="MI" || strLstmCd[i-1]=="SH"){ 
		        			 combo1.InsertItem(t, strLstmCd[i-1], strLstmCd[i-1]);
		        			 t++;
		        		 }
		        	 }		        	 
		         }
				break;
		     case IBSEARCH_ASYNC02:
		    	 sheetObj.SetWaitImageVisible(0);
		         form.f_cmd.value=SEARCH02;
		         var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do" , FormQueryString(formObj));
				 var chk=sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchData(sXml,{Sync:0} );
					 return;
				 }	             
		         //TP/SZ retrieve
		         var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");
		         tot_cntr_tpsz_cd=cntr_tpsz_cd;
		         var strCntrTpszCd=cntr_tpsz_cd.split("|");
		         with (combo2) {		        
		        	 combo2.InsertItem(0 , 'ALL','ALL'); 
		        	 var t=1;
		        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
		        		 if (strCntrTpszCd[i-1].substring(0,1)=="R"){ 
		        			 combo2.InsertItem(t, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
		        			 t++;
		        		 }
		        	 }		        	 
		         }
			break;
			case IBSAVE:
				//dup checking
		        var chkUpdate=false;
		        for (var i=1; i <= sheetObj.RowCount(); i++){
		        	sheetObj.SetRowStatus(i,"U");
		        	if (sheetObj.GetRowStatus(i) == "U"){
		        		chkUpdate=true;
		        		break;
		        	}	
		        }
		        if (!chkUpdate){
		        	ComShowCodeMessage("MST00012");
		        	return;
		        }
		        var strErrChk = "";
		        for(var i=sheetObj.RowCount(); i >= 1; i--){
					if (sheetObj.GetCellValue(i,"aeflg") != "E" &&
						sheetObj.GetCellValue(i,"beflg") != "E" &&
						sheetObj.GetCellValue(i,"ceflg") != "E" &&
						sheetObj.GetCellValue(i,"deflg") != "E" &&
						sheetObj.GetCellValue(i,"eeflg") != "E" &&
						sheetObj.GetCellValue(i,"feflg") != "E"){
					}else{
						strErrChk = "Y";
						break;
					}
				}		
		        
		        if(strErrChk == "Y") {
		        	ComShowCodeMessage("MST01026");
		        	return false;
		        }
		        
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);				
		    	formObj.f_cmd.value=MULTI;
     	        var sParam=ComGetSaveString(sheetObjects[0]);
     	        sParam += "&" + FormQueryString(formObj);
     	        var sXml=sheetObj.GetSaveData("EES_MST_0047GS.do", sParam);
     	        ComOpenWait(false);
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					return;
				} else {  	     	        
					ComShowCodeMessage("MST01025");
				}
				/*for(var i=sheetObj.RowCount(); i >= 1; i--){
					if (sheetObj.GetCellValue(i,"aeflg") != "E" &&
						sheetObj.GetCellValue(i,"beflg") != "E" &&
						sheetObj.GetCellValue(i,"ceflg") != "E" &&
						sheetObj.GetCellValue(i,"deflg") != "E" &&
						sheetObj.GetCellValue(i,"eeflg") != "E" &&
						sheetObj.GetCellValue(i,"feflg") != "E"){
						sheetObj.RowDelete(i,false);
					}
				}		
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);*/
			break;
			
			case IBSEARCH_ASYNC03:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_lgl_eng_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_lgl_eng_nm);
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
         }
     }
     
     /**
      * calling event after retrieving Sheet
 	 * @param sheetObj
 	 * @param ErrMsg
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	//do nothing
    	 var formObj=document.form;
    	 var sheetObj = sheetObjects[0];
    	 var aecnt=0;
		 var becnt=0;
		 var cecnt=0;
		 var decnt=0;
		 var eecnt=0;    
		 var fecnt=0; 
		 var tmpCntrNo="";
    	 if (formObj.cntr_nos.value != ""){
    		 var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
    		 var arrRow=dupRows.split(",");
		    for (var i=1; i <= sheetObj.RowCount(); i++){
		    	sheetObj.SetRowStatus(i,"U");
		    	if (sheetObj.GetCellValue(i,"aeflg") == "E"){ //Term Error
		    		sheetObj.SetCellFontColor(i,"lstm_cd","#FF0000");
					sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
				    aecnt++;
				}
		    	if (sheetObj.GetCellValue(i,"beflg") == "E"){ //CNTR_Tp_SZ Code Error
		    		sheetObj.SetCellFontColor(i,"cntr_tpsz_cd","#FF0000");
					sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
				    becnt++;
				}
		    	if (sheetObj.GetCellValue(i,"ceflg") == "E"){ //RF_MKR_SEQ Code Error
		    		sheetObj.SetCellFontColor(i,"rf_mkr_seq","#FF0000");
					sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
				    cecnt++;
				}  
		    	var tmpMinTemp=sheetObj.GetCellValue(i,"min_temp");
				if (!ComIsNumber(tmpMinTemp, "-") && !ComIsNull(tmpMinTemp)){
					sheetObj.SetCellValue(i,"deflg","E");
					sheetObj.SetCellFontColor(i,"min_temp","#FF0000");
					sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
				    decnt++;
				}
				var tmpMaxTemp=sheetObj.GetCellValue(i,"max_temp");
				if (!ComIsNumber(tmpMaxTemp, "-") && !ComIsNull(tmpMaxTemp)){
					sheetObj.SetCellValue(i,"eeflg","E");
					sheetObj.SetCellFontColor(i,"max_temp","#FF0000");
					sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
				    eecnt++;
				}    
				if (!ComIsNull(tmpMinTemp) && !ComIsNull(tmpMaxTemp)) {
					if (tmpMinTemp > tmpMaxTemp){
						sheetObj.SetCellValue(i,"deflg","E");
						sheetObj.SetCellValue(i,"eeflg","E");
						sheetObj.SetCellFontColor(i,"min_temp","#FF0000");
						sheetObj.SetCellFontColor(i,"max_temp","#FF0000");
						decnt++;
						eecnt++;
					}
				}
				if (sheetObj.GetCellValue(i,"cntr_tpsz_cd") == ""){ //존재하지않는 컨테이너
					sheetObj.SetCellBackColor(i,"cntr_no","#FF3C3C");
					sheetObj.SetRowStatus(i,"R");
					fecnt++;
				}
			}
    		 var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
    		 var arrRow=dupRows.split(",");
	         if (dupRows != ""){
	             for( var t=0; t<arrRow.length; t++){
	            	 tmpCntrNo=tmpCntrNo + sheetObj.GetCellValue(arrRow[t],"cntr_no")+",";
	            	 if (sheetObj.GetCellValue(arrRow[t],"cntr_no")   == sheetObj.GetCellValue(arrRow[t],"cntr_no") ){
		       			     sheetObj.SelectCell(arrRow[t], "cntr_no", true);
		       			     sheetObj.SetCellFontColor(arrRow[t],"cntr_no","#FF0000");
		       			     sheetObj.SetCellValue(arrRow[t],"feflg","E",0);
		       			     sheetObj.SetRowStatus(arrRow[t],"R");
		       			     fecnt++;
		            	 }
	             }
	             ComShowCodeMessage("MST00002", tmpCntrNo);
	         }
		    if (aecnt > 0 || becnt > 0 || cecnt > 0 || decnt > 0 || eecnt > 0 || fecnt > 0){
		    	ComShowCodeMessage("MST01026");
		    }
    	 }
     	ComOpenWait(false);
     }
     
     /**
      * MultiSelect속성을 이용하는 경우, checking박스를 클릭하는 순간 발생한다.
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
      * combo1_OnBlur
      */
     function combo1_OnBlur(comboObj, Index_Code, Text) {
     	var formObj=document.form;
     	if( comboObj.GetItemCheck(0)){
     		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
     			comboObj.SetItemCheck(i,0);
     		}
     		formObj.lstm_cd.value="";
     	}else if(comboObj.GetSelectText()== ""){
     		comboObj.SetItemCheck(0,1);
     		formObj.lstm_cd.value="";
     	}else{
     	    formObj.lstm_cd.value=ComGetObjValue(comboObj);
     	}
     }
     /**
      * combo1_OnKeyDown
      */
     function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
     	with(comboObj) {
     		if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
     			comboObj.SetSelectText("");
     		}else if(KeyCode == 13){
      		    sheetObjects[0].RemoveAll();
      			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		}
     	}
     }
     /**
      * MultiSelect속성을 이용하는 경우, checking박스를 클릭하는 순간 발생한다.
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
      * combo2_OnBlur
      */
     function combo2_OnBlur(comboObj, Index_Code, Text) {
     	var formObj=document.form;
     	if( comboObj.GetItemCheck(0)){
     		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
     			comboObj.SetItemCheck(i,0);
     		}
     		formObj.cntr_tpsz_cd.value="";
     	}else if(comboObj.GetSelectText()== ""){
     		comboObj.SetItemCheck(0,1);
     		formObj.cntr_tpsz_cd.value="";
     	}else{
     	    formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
     	}
     }
     /**
      * combo2_OnKeyDown
      */
     function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
     	with(comboObj) {
     		if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
     			comboObj.SetSelectText("");
     		}else if(KeyCode == 13){
      		    sheetObjects[0].RemoveAll();
      			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		}
     	}
     }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
   	/**
   	 * handling Currency Pop-up Return Value <br>
   	 * @param {arry} Return value array of returned Values Pop-up screen
   	 * @param  Row index
   	 * @param Col index
   	 * @paramsheet Array index
   	 */
  	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj=document.form;
  	    var sheetObj=sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	  	    if (aryPopupData[0][7] != "ST" && aryPopupData[0][7] != "LT"){
  	  	    		formObj.agmt_cty_cd.value="";
  	  	    		formObj.agmt_seq.value=""; 	    		   		
  	  	    		ComShowCodeMessage("MST01003");
  	  	    		ComSetFocus(formObj.agmt_seq);
  	  	    		return;
  	  	    }
  	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][4]);
  	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
  	    }
  	} 	     

	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}
	
	/**
     * MultiSelect�띿꽦���댁슜�섎뒗 寃쎌슦, checking諛뺤뒪瑜��대┃�섎뒗 �쒓컙 諛쒖깮�쒕떎.
     * @return
     */
    function rstr_usg_lbl_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    
    
	/**
     * in case of onChange combo event    
     */
    function ru_lable_type_OnChange(){
    	var formObj = document.form;
    	
		var lblVal = formObj.ru_lable_type.value;
		comboOnChange(lblVal);
    }
    
    /**
     * handling in case of onChange combo event 
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */   
    function comboOnChange(lblVal){ 	
    	var formObj=document.form;
    	comboObjects[1].RemoveAll();
    	//sheetObjects[1].WaitImageVisible=false;
        form.f_cmd.value=SEARCH02;
        var ruLabelType=lblVal;
    	var param="&ru_label_type="+ruLabelType;
    	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
    	var chk=sXml.indexOf("ERROR");
    	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    		 sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
    		 return;
    	}	             
    	 
    	var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
        var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
         
        comboObjects[1].InsertItem(0 , 'ALL',''); 
        if(strRstrUsgTblNm.length >= 1) {
        	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
        		 var arrCode=strRstrUsgTblNm[i].split("|");
        		 if(arrCode[0] != ""){
        			 comboObjects[1].InsertItem(i+1, arrCode[0], arrCode[0]);
        		 }
        	}	
        }
        comboObjects[1].SetItemCheck(0,1);
        comboObjects[1].SetEnable(1);
    }
    