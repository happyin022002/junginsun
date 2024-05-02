/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1125.js
*@FileTitle  : Estimated Pool Chassis Expense(Co-Pool N/P)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_1125 : EES_CGM_1125 business script for
     */
    function EES_CGM_1125() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObject1, formObject, IBSAVE);
 					break;
 				case "btn1_Report":
 					Report();
 					break;
 				case "btns_Calendar":
 				    var cal=new ComCalendar();
 				    cal.setDisplayType("year");
	 				cal.select(formObject.year, "yyyy");
	 				break;
 				case "btn_New":
 					formObj.reset();
               	    formObj.chss_pool_co_cd_text.value="";
 					sheetObject1.RemoveAll();
 					title_chk("1");
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
 					initFormControl(false);
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
         for(i=0;i<sheetObjects.length;i++){
 			//
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
 			//
             ComEndConfigSheet(sheetObjects[i]);
             sheetObjects[i].SetExtendLastCol(0);
//             sheetObjects[i].Visible = 	false;
         }
         formObj=document.form;
         axon_event.addListenerForm  ('beforedeactivate',		'obj_deactivate',   formObj,"chss_pool_tp_cd");
//           axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
//         axon_event.addListener('focusout', 'obj_focusout', 'curr_cd'); 
//         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
      	 axon_event.addListener('click', 'chss_pool_change', 'chss_pool');
      	sheet1_OnLoadFinish(sheet1);
      }
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.SetWaitImageVisible(0);
 		 initControl(sheetObjects[0]);   
		 sheetObj.SetWaitImageVisible(1);
    }
     /**
     * init control of form <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version
     */
    function initControl(sheetObj){
    	// Form object
    	  formObj=document.form;
        // axon event regist
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    	initFormControl(false);
//    	//formObj.chss_pool_co_cd.focus();
    }
     function initFormControl(chk){
    	 formObj.chss_pool[0].disabled=chk;
    	 formObj.chss_pool[1].disabled=chk;
    	 formObj.year.readOnly=chk;
    	 //formObj.chss_pool_co_cd.disabled    = chk;
    	 if(chk == true){
    		 ComEnableObject(formObj.btns_Calendar, false);
    		 chss_pool_co_cd.SetEnable(0);
    		 formObj.year.className="input2";
    	 } else {
    		 ComEnableObject(formObj.btns_Calendar, true);
    		 chss_pool_co_cd.SetEnable(1);
    		 formObj.year.className="input1";
         	 var sysDate=new Date();
        	 var year=sysDate.getFullYear();
        	 formObj.year.value=ComLpad(year, 4, "0");
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
             case 1:      // sheet1 init
            	    with(sheetObj){
		               var HeadTitle1="|Month|Est. Amount|Act. Amount|Fix|month|estm_yrmon|agmt_ofc_cty_cd|agmt_seq|chss_pool_tp_cd|chss_pool_cd|curr_cd";
		               var headCount=ComCountHeadTitle(HeadTitle1);
		
		               SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"month_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Float",     Hidden:0,  Width:330,  Align:"Right",   ColMerge:0,   SaveName:"estm_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:330,  Align:"Right",   ColMerge:0,   SaveName:"inv_smry_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"estm_amt_fx_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"month",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:160,  Align:"Right",   ColMerge:0,   SaveName:"estm_yrmon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:160,  Align:"Right",   ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"chss_pool_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chss_pool_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:160,  Align:"Right",   ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               FitColWidth();
		               SetSheetHeight(400);
                     }
                 break;
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
            	if(validateForm(sheetObj,formObj,sAction)){
	                formObj.f_cmd.value=SEARCH;
	                formObj.chss_pool_cd.value=chss_pool_co_cd.GetSelectCode();
	                if( formObj.chss_pool[0].checked == true){
	                	formObj.chss_pool_tp_cd.value="CP";
	                } else {
	                	formObj.chss_pool_tp_cd.value="NP";
	                }
                	var sXml = sheetObj.DoSearch("EES_CGM_1125GS.do", FormQueryString(formObj) );
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					//initFormControl(fa);
         		}
                break;
 			case IBSAVE:        //saving
 				if(validateForm(sheetObj,formObj,sAction)){
 					for(i=1; i<sheetObj.RowCount()+1; i++){
 						if(sheetObj.GetCellValue(i, "estm_yrmon")==""){
 							sheetObj.SetRowStatus(i,"I");
 							if( formObj.chss_pool[0].checked == true){
 								sheetObj.SetCellValue(i, "chss_pool_tp_cd","CP");
 							} else {
 								sheetObj.SetCellValue(i, "chss_pool_tp_cd","NP");
 							}
 							sheetObj.SetCellValue(i, "chss_pool_cd",chss_pool_co_cd.GetSelectCode());
 							sheetObj.SetCellValue(i, "curr_cd",formObj.curr_cd.value );
 						} else {
 							sheetObj.SetRowStatus(i,"U");
 							sheetObj.SetCellValue(i, "curr_cd",formObj.curr_cd.value );
 						}
 					}
 					var params=sheetObj.GetSaveString(true);
 					formObj.f_cmd.value=MULTI;
 					queryString="f_cmd=" + MULTI ;
 					formObj.chss_pool_cd.value=chss_pool_co_cd.GetSelectCode();
// 					var sXml = sheetObj.DoSave("EES_CGM_1125GS.do", FormQueryString(formObj), -1, false);
 					if(sheetObj.DoSave("EES_CGM_1125GS.do",FormQueryString(formObj), -1, false))
 					{
 					} 
 				}			
                break;
 	        case IBSEARCH_ASYNC01:	// CP Combo retrieve
 	        	if(document.form.chss_pool_tp_cd.value=="CP"){
				    formObj.f_cmd.value=SEARCH02;
 	        	} else {
 	        		formObj.f_cmd.value=SEARCH14;
 	        	}
 	        	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				ss=ComCgmXml2ComboString(sXml, "TOTAL");
				var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
				//IBSHEET GRID outer combo
				makeCPMultiCombo(chss_pool_co_cd, cols, 0, 0);
			    break;
 	        case IBSEARCH_ASYNC02:	// CP Combo retrieve
 	       	    formObj.f_cmd.value=SEARCH;
 	       	    var sXml=sheetObj.GetSearchData("EES_CGM_CURRENCYGS.do", FormQueryString(formObj));
 	            var dataCount=ComGetTotalRows(sXml);
		     	if(dataCount==0){
		     		ComShowCodeMessage('CGM10041','Currency');
//		     		formObj.curr_cd.focus();
		     		formObj.curr_cd.value="";
		     	}
			    break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {
     		case IBSEARCH:
     			if(formObj.year.value == ''){
     				ComShowCodeMessage('CGM10004','Year');
//	           		 formObj.year.focus();
	           		 return false; 
     			}	
     			if(formObj.chss_pool_co_cd_text.value == ''){
     				 ComShowCodeMessage('CGM10004','chss_pool_cd');
	           		 return false; 
     			}	
     			break;
       	    case IBSAVE:
       	    	if(formObj.curr_cd.value == ''){
     				ComShowCodeMessage('CGM10004','Currency');
//	           		 formObj.curr_cd.focus();
	           		 return false; 
     			}	
      		    break;
         }
        return true;
     }
     /** 
     * Object activate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_activate(){
      	ComClearSeparator(event.srcElement);
    } 
     /** 
      * Object Keypress event handling  <br>
      * 
      * @param  
      * @return 
      * @author 
      * @version
      */ 
     function obj_keypress(){
    	 obj=event.srcElement;
    	 if(obj.dataformat == null) return;
    	 window.defaultStatus=obj.dataformat;
    	 switch(obj.dataformat) {
    	 	case "yyyy":
    	 		 if(event.keyCode==13)
    	    	 {
    	 			set_serch();
    	    	 }
    	 		ComKeyOnlyNumber(obj);
    	        break;
    	 	case "eng":
    	 		if(event.keyCode==13)
	   	    	 {
	   	 			set_serch();
	   	    	 }
    	 		ComKeyOnlyAlphabet('upper');
    	        break;
    	 }
     }
       function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
          	cmbObj.RemoveAll();
          	if(arrStr == undefined ){
          		cmbObj.SetSelectIndex("" ,false);
          	} else {
              	var arrCode=arrStr[0].split("|");
              	var arrCode2=arrStr[1].split("|");
              	for (var i=0; i < arrCode.length;i++ ) {
  	          		var arrCode3=arrCode[i].split("|");
  	          		var arrCode4=arrCode2[i].split("|");
  	          		if(document.form.chss_pool_tp_cd.value=="CP"){
  	          			cmbObj.InsertItem(i, arrCode3[codeCol], arrCode3[codeCol]);
  	          		} else {
  	          			cmbObj.InsertItem(i, arrCode4[codeCol], arrCode3[codeCol]);
  	          		}
  	          	}
          	}
        }
       /** 
        * Object deactivate event handling  <br>
        * @param  
        * @return 
        * @author 
        * @version
        */
       function obj_deactivate(){
      	 var formObj=document.form;
      	 obj=event.srcElement;
      	 if(obj.name=="year"  ){
    		 with(formObj){
    			 //var creDtFr = ComReplaceStr(year.value,"","");
	        }
	        ComChkObjValid(event.srcElement);
    	   }
      }
    /**
     * saving, retrieve call
     * @return
     */ 
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(errMsg =='') {   
    		ComShowCodeMessage('CGM00003');
    		set_serch();
		}
    }    
     /**
      * saving, retrieve call
      * @return
      */
     function set_serch()
     {
    	 var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
     }
 	function sheet1_OnChange(sheetObj, Row, Col){
 		 if(Col == 4){
 			 if(sheetObj.GetCellValue(Row, "estm_amt_fx_flg")==1){
 				if ( ComShowCodeConfirm("CGM10085") ){ 
 					sheetObj.SetCellValue(Row, "estm_amt",sheetObj.GetCellValue(Row, "inv_smry_amt"),0);
 	 				sheetObj.SetCellEditable(Row, "estm_amt",0);
 				} else {
 					sheetObj.SetCellEditable(Row, "estm_amt",1);
 					sheetObj.SetCellValue(Row, "estm_amt_fx_flg",0);
 				}
 			 } else {
 				sheetObj.SetCellEditable(Row, "estm_amt",1);
 			 }
 		 }
 	}
 	function sheet1_OnSearchEnd(sheetObj, errMsg) {
 		var cellCurCdVal = sheetObj.GetCellValue(1, "curr_cd");
 		formObj.curr_cd.value = cellCurCdVal != "-1" ? cellCurCdVal : "";
		 for(i=1; i<=sheetObj.RowCount(); i++){
			 if(sheetObj.GetCellValue(i, "estm_amt_fx_flg")==1){
	 	 		sheetObj.SetCellEditable(i, "estm_amt",0);
			 } else {
				sheetObj.SetCellEditable(i, "estm_amt",1);
			 }
		 }
		if(formObj.curr_cd.value==""){
			formObj.curr_cd.value="USD";
		}
 	}
     function chss_pool_co_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
    	document.form.chss_pool_co_cd_text.value = newCode;
     	var sheetObj=sheetObjects[0];
    	if (newIndex != "-1") {
    		set_serch();
    	}
     }
     
     function chss_pool_co_cd_OnBlur() {
    	 document.form.chss_pool_co_cd_text.value = chss_pool_co_cd.GetSelectCode();
     }
     /** 
     * Pool select, grid reset <br>
     * @param  
     * @return 
     * @author 
     * @version
     */ 
   function chss_pool_change() {
   	var formObj=document.form;
    var sheetObject1=sheetObjects[0];
//    formObj.reset();
	sheetObject1.RemoveAll();
	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
	initFormControl(false);
   }
 	 /**
 	  * title control
 	  * @param chk
 	  * @return
 	  */
 	 function title_chk(chk){
 	   var objs=document.all.item("tabLayer");
 	   if(chk=="1")
 	   {
 		   objs[1].style.display="none";
	       objs[0].style.display="Inline";
	       document.form.chss_pool_tp_cd.value="CP";
 	   }
 	   else
 	   {
 		   objs[0].style.display="none";
	       objs[1].style.display="Inline";
	       document.form.chss_pool_tp_cd.value="NP";
 	   }
 	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
 	 }
 	 /**
 	  * popup
 	  * @return
 	  */
     function Report(){
   		    var chss_pool_tp_cd="";
   	    	var year=document.form.year.value;
   	    	if(formObj.year.value == ''){
 				ComShowCodeMessage('CGM10004','Year');
//           		 formObj.year.focus();
           		 return false; 
 			} else {
 				if( formObj.chss_pool[0].checked == true){
 	   	    		chss_pool_tp_cd="CP";
 				} else {
 					chss_pool_tp_cd="NP";
 				}
 				var param="?pgmNo=EES_CGM_1126";
 	   		   	param=param + "&f_cmd=" + SEARCH; 
 	   			param=param + "&chss_pool_tp_cd=" + chss_pool_tp_cd;           	
 	   		   	param=param + "&year=" + year;//.substring(0,4);
 	   		    ComOpenPopup('/opuscntr/EES_CGM_1126.do' + param, 800, 450, "", "1,0", true, false);
 			}
      }
 	  /**
       * curr_cd value check 
       * @return
       */
 	  function obj_focusout(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 obj=event.srcElement;
    	 switch(ComGetEvent("name")){
    	 	case "curr_cd":
    	 		if(formObj.curr_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    	 		} 
    	 		break;
    	 }
      }
	/* developer job end */

