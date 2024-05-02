/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0564.js
*@FileTitle : Un-match B/L Status Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview business script for esm_bkg_0564
     * @author CLT
     */

   	/* developer's work*/
 // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
	  * Event handler processing by button name <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 
	  * @author 
	  * @version 2009.04.17
	  */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
	    	        case "btns_calendar1": 
			        	var cal=new ComCalendar();
			        	cal.select(form.rt_aply_dt_from, 'yyyy-MM-dd');
			        	break;
	    	        case "btns_calendar2":
				        var cal=new ComCalendar();
				        cal.select(form.rt_aply_dt_to, 'yyyy-MM-dd');
				        break;
	                case "btn_Retrieve":
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
						break;
					case "btn_New":
						removeAll(formObject);
					    //getComboObject(comboObjects, 'rct_rhq_cd').Code = form.strRhq_ofc_cd.value;
						break;
					case "btn_DownExcel":
 						sheetObjects[1].Down2Excel();
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
         * registering IBSheet Object as list <br>
         * adding process for list in case of needing batch processing with other items <br>
         * defining list on the top of source <br>
         * <br><b>Example :</b>
         * <pre>
         *     setSheetObject(sheetObj);
         * </pre>
         * @param {ibsheet} sheet_obj mandatory IBSheet Object
         * @return 
         * @author 
         * @version 2009.04.17
         */ 
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * registering IBMulti Combo Object as list <br>
         * adding process for list in case of needing batch processing with other items <br>
         * defining list on the top of source <br>
         * <br><b>Example :</b>
         * <pre>
         *     setComboObject(combo_obj);
         * </pre>
         * @param {ibCombo} combo_obj mandatory IBMulti Combo Object
         * @return 
         * @author 
         * @version 2009.04.17
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++]=combo_obj;
     	}
        /**
         * initializing sheet <br>
         * implementing onLoad event handler in body tag <br>
         * adding first-served functions after loading screen.. <br>
         * <br><b>Example :</b>
         * <pre>
         *     loadPage();
         * </pre>
         * @return 
         * @author 
         * @version 2009.04.17
         */
        function loadPage() {
        	 var form=document.form;
     		//initialinzing IBMultiCombo
      	    for(var k=0; k < comboObjects.length; k++){
      	        initCombo(comboObjects[k], k + 1);
      	    }
        	 for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);			
     	    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	    
   	        initIBComboItem();
    	    //doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
    	    //sheetObjects[1].Editable = false;
    	    /*
    	    form.rct_rhq_cd.SetSelectCode("");
    	    form.rt_aply_dt_from.value="2009-01-01";
    	    form.rt_aply_dt_to.value="2009-12-31";
    	    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	    */
    	}
/** 
*  event Keypress  <br>
* checking validation with data format.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param    
* @return 
* @see #
* @author 
* @version 
*/ 
function obj_keypress(){
	var obj=event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //date 
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //number
 	case "number": //number	
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}        
		/**
		 * handling OnKeyPress event. <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     obj_keypress()
		 * </pre>
		 * @param 
		 * @return 
		 * @author 
		 * @version 2009.04.17
		 */ 
        function obj_activate() {
     		ComClearSeparator (event.srcElement);	   
     	}
        /**
         * handling Onbeforedeactivate  event. <br>
         * <br><b>Example :</b>
         * <pre>
         *     obj_deactivate()
         * </pre>
         * @param 
         * @return 
         * @author 
         * @version 2009.04.17
         */ 
     	function obj_deactivate() {
     	    ComChkObjValid(event.srcElement);
     	}
     	/**
         * loading IBSHEET COMBO <br>
         * <br><b>Example :</b>
         * <pre>
         * 		initCombo(comboObj, comboNo)
         * </pre>
         * @return 
         * @author 
         * @version 2009.06.10
         */ 
     	function initCombo(comboObj, comboNo) {
            switch(comboObj.options.id) {
            case "rct_rhq_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
    //no support[check again]CLT 				ValidChar(2, 0);    // alphabet upper case
                    SetMaxLength(6);// 6 digit
                }
                break;    
            case "bkg_ofc_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
    //no support[check again]CLT 				ValidChar(2, 0);    // alphabet upper case
                    SetMaxLength(6);// 6 digit
                }
                break;       
            case "bkg_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                //no support[check again]CLT 	ValidChar(2, 2);    // alphabet upper case + special character
                }
                break;      
            case "auto_rat_flg":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                //no support[check again]CLT 	ValidChar(1, 2);    // alphabet + special character
                }
                break;  
            }
      	}
     	/**
         * return code of comboObjects[0] <br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRctRhqCd();
         * </pre>
         * @return String <br>
         * @author 
         * @version 2009.06.10
         */ 
     	function getRctRhqCd() {
      		return comboObjects[0].GetSelectCode();
      	}
     	/**
         * return code of  comboObjects[1]<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getBkgOfcCd();
         * </pre>
         * @return String <br>
         * @author 
         * @version 2009.06.10
         */ 
        function getBkgOfcCd() {
      		return comboObjects[1].GetSelectCode();
      	}
        /**
         * return code of comboObjects[2]<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getBkgCtrtTpCd();
         * </pre>
         * @return String <br>
         * @author 
         * @version 2009.06.10
         */
        function getBkgCtrtTpCd() {
      		return comboObjects[2].GetSelectCode();
      	}
        /**
         * return code of comboObjects[3]<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getBkgCtrtTpCd();
         * </pre>
         * @return String <br>
         * @author 
         * @version 2009.06.10
         */
        function getAutoRatFlg() {
      		return comboObjects[3].GetSelectCode();
      	}
        /**
         * activating  in case of changing rct_rhq_cd combo<br>
         * searching by qttn_ver_no.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj mandatory,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return    
         * @author 
         * @version 2009.06.10
         */         
        function rct_rhq_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
        	if(comboObj.GetSelectIndex()== "0") {
 				comboObjects[1].RemoveAll();        		
 				return;
 			}
        	if(comboObj.GetItemCount () > 0 && comboObj.GetSelectIndex()!= "-1") {
 				var formObj=document.form;
 				formObj.etc2.value=code;
 				// organization chart combo2
 	        	formObj.f_cmd.value=COMMAND02;
  				var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
 				ComXml2ComboItem(sXml, bkg_ofc_cd, "cd", "cd");
 				//formObj.bkg_ofc_cd.SetSelectCode(formObj.strOfc_cd.value);
 				//formObj.bkg_ofc_cd.InsertItem(0,'','');
 				bkg_ofc_cd.SetSelectCode(formObj.strOfc_cd.value);
 				bkg_ofc_cd.InsertItem(0,'','');
     		} 
       	}
		 /**
		  *  setting Item at IBMultiCombo  <br>
		  * <br><b>Example :</b>
		  * <pre>
		  *     initIBComboItem();
		  * </pre>
		  * @return 
		  * @author 
		  * @version 2009.12.15
		  */
		function initIBComboItem() {
		    var form=document.form;
		    ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'rct_rhq_cd'),         "|", "\t" );
		    getComboObject(comboObjects, 'rct_rhq_cd').SetSelectCode(form.strRhq_ofc_cd.value);
			ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
			ComBkgTextCode2ComboItem(ratingTypeComboValue,   ratingTypeComboText,   getComboObject(comboObjects, 'auto_rat_flg'),       "|", "\t" );
		}
        /**
         * setting sheet initial values and header <br>
         * adding case as numbers of counting sheets <br>
         * <br><b>Example :</b>
         * <pre>
         *     initSheet(sheetObj,1);
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {int} sheetNo mandatory IBSheet Object 
         * @return 
         * @author 
         * @version 2009.04.17
         */  
        function initSheet(sheetObj,sheetNo) {
        	var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
        		case "sheet0":      //hidden 
        		    with(sheetObj){
        	       
        			SetVisible(0);
        	      }       	      

   	             break; 
				case "sheet1":      //sheet1 init
				    with(sheetObj){			        			      
			      var HeadTitle1="RHQ|Office|Unsettled|Unsettled|Unsettled|Unsettled|Unsettled|Unsettled|Unsettled|Unsettled|Unsettled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settle Status|Settle Status|Settle\nTerm";
			      var HeadTitle2="RHQ|Office|Non-Revenue|Non-Revenue|Non-Revenue|Non-Revenue|Revenue|Revenue|Revenue|Total|Total|Non-Revenue|Non-Revenue|Non-Revenue|Non-Revenue|Revenue|Revenue|Revenue|Total|Total|Ratio (%)|Ratio (%)|Settle\nTerm";
			      var HeadTitle3="RHQ|Office|A1|A2|B|C|D|E|F|Error Case|Error B/L|A1|A2|B|C|D|E|F|Error Case|Error B/L|Error Case|Error B/L|Settle\nTerm";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0} );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"},
			                  { Text:HeadTitle3, Align:"Center"} ];
						      InitHeaders(headers, info);
						      var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rct_rhq_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"u_al_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"u_all_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"u_b_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"u_c_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:26,   Align:"Center",  ColMerge:0,   SaveName:"u_d_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:26,   Align:"Center",  ColMerge:0,   SaveName:"u_e_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:26,   Align:"Center",  ColMerge:0,   SaveName:"u_f_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"u_total",      KeyField:0,   CalcLogic:"|u_al_cnt|+|u_all_cnt|+|u_b_cnt|+|u_c_cnt|+|u_d_cnt|+|u_e_cnt|+|u_f_cnt|",Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bl_u_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"s_al_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"s_all_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"s_b_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"s_c_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:26,   Align:"Center",  ColMerge:0,   SaveName:"s_d_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:26,   Align:"Center",  ColMerge:0,   SaveName:"s_e_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:26,   Align:"Center",  ColMerge:0,   SaveName:"s_f_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_total",      KeyField:0,   CalcLogic:"|s_al_cnt|+|s_all_cnt|+|s_b_cnt|+|s_c_cnt|+|s_d_cnt|+|s_e_cnt|+|s_f_cnt|",Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bl_s_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoAvg",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_ratio",      KeyField:0,   CalcLogic:"(|s_total|/(|u_total|+|s_total|)*100)",Format:"Integer", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoAvg",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"s_bl_ratio",   KeyField:0,   CalcLogic:"(|bl_s_cnt|/(|bl_u_cnt|+|bl_s_cnt|)*100)",Format:"Integer", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"AutoAvg",   Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"settle_term",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						      InitColumns(cols);
						      SetEditable(1);
						      ShowSubSum([{StdCol:"rct_rhq_cd", SumCols:"2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20", Sort:false, ShowCumulate:false, CaptionCol:0, OtherColText:"rct_rhq_cd=%s;bkg_ofc_cd=SubTotal;s_ratio=(|s_total|/(|u_total|+|s_total|)*100);s_bl_ratio=(|bl_s_cnt|/(|bl_u_cnt|+|bl_s_cnt|)*100)", AvgCols:"settle_term"}]);
						      SetSheetHeight(490);
			            }

                    break;
            }
        }
        /**
         * handling of Sheet  <br>
         * <br><b>Example :</b>
         * <pre>
         *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {form} formObj mandatory html form object
         * @param {int} sAction mandatory 
         * @return 
         * @author 
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
            	case IBSEARCH:      
            		if (validateForm(sheetObj,formObj,sAction)) {
        	    		ComOpenWait(true);		
        	    		sheetObj.SetWaitImageVisible(0);
            			formObj.f_cmd.value=SEARCH01;
            			sheetObj.DoSearch("ESM_BKG_0564GS.do", FormQueryString(formObj) );
        				ComOpenWait(false);        		
    	        	}
            	    break;
            }
        }
        /**
		 * handling process for input validation <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
		 *         logic;
		 *     }
		 * </pre>
		 * @param {ibsheet} sheetObj mandatory IBSheet Object
		 * @param {form} formObj mandatory html form object
		 * @param {int} sAction mandatory flag
		 * @return bool <br>
		 *          true  : valid<br>
		 *          false : invalid
		 * @author 
		 * @version 2009.04.17
		 */
        function validateForm(sheetObj,formObj,sAction){
       	  switch (sAction) {
   	 		case IBSEARCH: 
		 		var fmDtObj=form.rt_aply_dt_from;
		 		var toDtObj=form.rt_aply_dt_to;
		 		var fmDtValue=fmDtObj.value.replace(/-/g, "");
		 		var toDtValue=toDtObj.value.replace(/-/g, "");
 		 		if(!ComChkObjValid(fmDtObj)) { return false; }
	 			if(!ComChkObjValid(toDtObj)) { return false; }
 		 		if("" == fmDtValue || "" == toDtValue){
 					 ComShowCodeMessage("BKG95025", "Audit Date(Update)"); // "Please input {?msg2}."
 					 if("" == fmDtValue){
 	 					 ComSetFocus(fmDtObj);
 					 }else{
 	 					 ComSetFocus(toDtObj);
 					 }
 					 return false;
 		 		}
	 			if( "" != fmDtValue && "" != toDtValue && ( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) ) {
					 ComShowCodeMessage("BKG95026", "From Date", "To Date");
					 ComSetFocus(fmDtObj);
					 return false;
		 		}
 	 			var fromAddDays=ComGetDateAdd(fmDtValue, "D", 364, "", true);
 	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
 	 				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
 	 				ComSetFocus(fmDtObj);
 	 				return false;
 	 			}
   				return true;
   	 			break;
   	 		}
            return true;
        }
        /** 
    	* OnSearchEnd- event after searching data sheet1 <br>
    	* <br><b>Example :</b>
    	* <pre>
    	* </pre>
    	* @param  {IBSheet} sheetObj : 
    	* @param  {string} errMsg :
    	* @return 
    	* @see #
    	* @author 
    	* @version 2010.01.05
    	*/ 
		function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
			if(sheetObj.RowCount()> 1) {
				var sumrow=sheetObj.FindSubSumRow("rct_rhq_cd");
				var arrRow=sumrow.split("|");
				for (idx=0; idx<arrRow.length; idx++) {
					if(sheetObj.GetCellValue(arrRow[idx],"settle_term")==0){
						sheetObj.SetCellValue(arrRow[idx],"settle_term","");
					}
				}
			}		
			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
			sheetObj.SetSumText(0, "rct_rhq_cd","Grand Total");
			sheetObj.SetSumValue(0,"s_ratio",sheetObj.GetSumValue(0,"s_total")/(sheetObj.GetSumValue(0,"u_total")+sheetObj.GetSumValue(0,"s_total"))*100);
			sheetObj.SetSumValue(0,"s_bl_ratio",sheetObj.GetSumValue(0,"bl_s_cnt")/(sheetObj.GetSumValue(0,"bl_u_cnt")+sheetObj.GetSumValue(0,"bl_s_cnt"))*100);
			sheetObj.SetSumText(0, "s_ratio",sheetObj.GetSumText(0, "s_ratio"));
			sheetObj.SetSumText(0, "s_bl_ratio",sheetObj.GetSumText(0, "s_bl_ratio"));
			sheetObj.SetSumBackColor("#00FFFF");   
    	}
		/**
         * reseting all<br>
         * <br><b>Example :</b>
         * <pre>
         *     removeAll(formObj)
         * </pre>
         * @param {formObj} formObj    
         * @return 
         * @author 
         * @version 2009.06.10
         */
  	 	function removeAll(formObj) {
  	 		formObj.reset();
  	 		comboObjects[0].SetSelectIndex("-1");
  	 		comboObjects[1].SetSelectIndex("-1");
  	 		comboObjects[1].RemoveAll();
  	 		comboObjects[2].SetSelectIndex("-1");
  	 		comboObjects[3].SetSelectIndex("-1");
  	 		rct_rhq_cd.SetSelectCode((form.strRhq_ofc_cd.value).toString());
  	 		sheetObjects[1].RemoveAll();
  		} 
	/* the end of developer's work */
