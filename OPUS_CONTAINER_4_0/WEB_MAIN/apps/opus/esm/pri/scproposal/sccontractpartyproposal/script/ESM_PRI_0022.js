/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0022.js
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.21 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_0022 : Business Script for ESM_PRI_0022
     */
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Variable to pass the value to main window. (Not Use)
// var returnData ="";
 var rData="N";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return void
  * @author 
  * @version 2009.04.17
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Amend":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY03);
					break;
				case "btn_AmendCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY04);
					break;
				case "btn_Save":
	 				if (!validateForm(sheetObjects[0],document.form,IBSAVE)) {
	 					return false;
	 				}
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_Accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;
				case "btn_AcceptCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;
				case "btn_Close":
					ComPopUpReturnValue(rData);
					break;
				case "prc_ctrt_pty_tp_cd":
					if (sheetObjects[0].IsDataModified()){
						if (formObject.tp_cd.value =="C"){
							formObject.prc_ctrt_pty_tp_cd[0].checked=true;
						}else{
							formObject.prc_ctrt_pty_tp_cd[1].checked=true;
						}
		 				if (validateForm(sheetObjects[0],document.form,IBSAVE)) {
		 					if (!doActionIBSheet(sheetObjects[0],document.form,IBSAVE)){
		 						return;
		 					}
		 				}
					}
					if (formObject.tp_cd.value =="C"){
						formObject.prc_ctrt_pty_tp_cd[1].checked=true;
						formObject.tp_cd.value="P";
					}else{
						formObject.prc_ctrt_pty_tp_cd[0].checked=true;
						formObject.tp_cd.value="C";
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.04.17
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet <br>
      * implementing onLoad event handler in body tag <br>
      * adding first-served functions after loading screen. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
		 /**/
		 var prcCtrtPtyTpCdCode=prcCtrtPtyTpCdValue.split("|");
		 var prcCtrtPtyTpCdName=prcCtrtPtyTpCdText.split("|");
		 var divStr="";
 		 var checked="";
		 for(var i=0; i<prcCtrtPtyTpCdCode.length; i++){
			if (i == 0)
				checked="checked";
			else
				checked="";
			divStr += "\n";
			divStr += "<input type=\"radio\" name=\"prc_ctrt_pty_tp_cd\" value=\""+prcCtrtPtyTpCdCode[i]+"\" id=\"prc_ctrt_pty_tp_cd_"+i+"\" class=\"trans\""+checked+"><label for=\"prc_ctrt_pty_tp_cd_"+i+"\"><span id=\"tp"+(i+1)+"\">"+prcCtrtPtyTpCdName[i]+"</span></label></input>";
			if(i < prcCtrtPtyTpCdCode.length)
				divStr += "&nbsp;";
		 }
		 document.getElementById("prcCtrtPtyTpCd").innerHTML= divStr;
		 document.form.tp_cd.value=prcCtrtPtyTpCdCode[0];
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 buttonControl();
		 
		 $("#sc_no1, #sc_no2, #amdt_seq, #prop_no, #cust_cd, #cust_seq, #cust_nm").prop("readOnly", true);
     }
  	/**
  	 * Handling body tag's unonLoad event handler <br>
  	 * adding the functions when screen is closing.<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *     unloadPage();
  	 * </pre>
  	 * @return void
  	 * @author 
  	 * @version 2009.08.17
  	 */      
	 function unloadPage(){
		 window.returnValue=rData;
	 }         
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
	                 var HeadTitle="|sel|prop_no|amdt_seq|prc_ctrt_pty_tp_cd|cust_cnt_cd|cust_seq|ctrt_cust_val_sgm_cd|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|"
	                 HeadTitle += "Contract Party|Address|Signature|Title|EFF Date|EXP Date|Source|Source|Status|Status||||";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
	
	                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                Wrap:1 },
				                  {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	                 if (amdt_seq == "0"){
	                	 cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200,   Wrap:1 });
	                	 cols.push({Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200,   Wrap:1 });
	                	 cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100,   Wrap:1 });
	                	 cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100,   Wrap:1 });
	                 }else{
	                	 cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200,   Wrap:1 });
	                	 cols.push({Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200,   Wrap:1 });
	                	 cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100,   Wrap:1 });
	                	 cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100,   Wrap:1 });
	                 }
	                 	cols.push({Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	                 	cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
	      
	                 InitColumns(cols);
	
	                 SetEditable(1);
	                 SetWaitImageVisible(0);
	                 SetColHidden("chk",1);
	                 resizeSheet(); //SetSheetHeight(120);
             	}
                break;
         }
     }
     
     function resizeSheet() { 
    	 ComResizeSheet(sheetObjects[0]); 
     }
     
     /**
      * Handling sheet's processes <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {form} formObj mandatory html form object
      * @param {int} sAction mandatory,Constant Variable
      * @return void
      * @author 
      * @version 2009.04.17
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg(false);
		try{
	          switch(sAction) {
	 	 		case IBSEARCH_ASYNC10:
					document.form.prc_ctrt_pty_tp_cd[0].checked=true;	
			        //srcInfocd		        
		 			sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
			        //status
		 			sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
	 				break;
	 	 		case IBSEARCH_ASYNC20: // execute option 
					formObj.f_cmd.value=SEARCH11;
	 	 			var eleName="";
	 	 			var sXml=sheetObj.GetSearchData("ESM_PRI_0022GS.do" , FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "cd|etc1");
					var lgcyIfFlg=document.form.lgcy_if_flg.value;
					for (var i=0; arrData !=null && i < arrData.length; i++) {
						if (arrData[i][0] == "P" ){
							eleName="tp2";
						}else{
							eleName="tp1";
						}
						document.getElementById(eleName).style.fontWeight="bold";
						switch (arrData[i][1]){
							case "0":
				 				document.getElementById(eleName).style.fontWeight="";
				 				document.getElementById(eleName).style.color="black";
								break;
							case "1":
				 				document.getElementById(eleName).style.color="black";
								break;
							case "2":
								if (lgcyIfFlg == "Y"){
									document.getElementById(eleName).style.color="black";
								}else{
									document.getElementById(eleName).style.color="red";
								}
								break;
							case "3":
								if (lgcyIfFlg == "Y"){
									document.getElementById(eleName).style.color="black";
								}else{
									document.getElementById(eleName).style.color="blue";
								}							
								break;
						}
					}	 	 		
					break;	
	 	 		case IBSEARCH:      //Retrieving			
	 				formObj.f_cmd.value=SEARCH;
	 	 			ComOpenWait(true); //->waiting->start
	 	 			sheetObj.DoSearch("ESM_PRI_0022GS.do", FormQueryString(formObj) );
	 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
	 				ComOpenWait(false); //->waiting->End
	 				break;
	 			case IBSAVE:        
	 				ComOpenWait(true); //->waiting->start 
	 				formObj.f_cmd.value=MULTI;
	 				var sParam=FormQueryString(formObj);
	 				var sParamSheet=sheetObj.GetSaveString();
	 				if (!sheetObj.IsDataModified()&& sParamSheet == "") {
	 					ComShowCodeMessage("PRI00301");
	 					return false;
	 				}	 			 	
	 				if (sheetObj.IsDataModified()&& sParamSheet == "") {
	 					return false;
	 				}	 	
	 				var sXml=sheetObj.GetSaveData("ESM_PRI_0022GS.do", sParam+"&"+sParamSheet);
	 				sheetObj.LoadSaveData(sXml);
	 				ComOpenWait(false); //->waiting->End
	 				break;
	 			 case MODIFY01:        //accept
	 			 	ComOpenWait(true); //->waiting->start 
		            if (!ComShowCodeConfirm("PRI00008")) {
		            	return false;
		            } 			 
					formObj.f_cmd.value=MODIFY01;
					var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0022GS.do");
	 				ComOpenWait(false); //->waiting->End
					break;			
	 			 case MODIFY02:        //accept cancel
	 			 	ComOpenWait(true); //->waiting->start 
		            if (!ComShowCodeConfirm("PRI00009")) {
		            	return false;
		            } 			 
					formObj.f_cmd.value=MODIFY02;
					var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0022GS.do");
	 				ComOpenWait(false); //->waiting->End
					break;
	 			 case MODIFY03:        //amend
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{						
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");						
						}
					}else{ 					
						comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");
					}
	 			 	sheetObj.SelectCell(2, "ctrt_pty_nm");
					break;	 			 
	 			 case MODIFY04:        //amend cancel
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");		
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");
					}	
					break;	
	          }//end switch			  
		} catch (e) {
			if (e == "[object Error]") {
			    ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally{
			if (sAction == IBSEARCH_ASYNC10 || sAction == MODIFY03 || sAction == MODIFY04) {
				return;
			}
			ComOpenWait(false); //->waiting->End
		}
      }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.05.20
     */ 	 	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
  		var sCols="ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm";
  		searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value); 	   
		buttonControl();
	}         
     /**
      * calling function when occurring OnSaveEnd event <br>
      * After save completed, Declare Editable columns. <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {string} ErrMsg mandatory from server
      * @return void
      * @author 
      * @version 2009.04.17
      */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	  var formObj=document.form;
    	  if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
// 			if (formObj.prc_ctrt_pty_tp_cd[1].checked){
// 				returnData = sheetObjects[0].CellValue(sheetObjects[0].RowCount,"ctrt_pty_nm");
// 			}
 			rData="Y";
 			parent.comUpdateProposalStatusSummary("04", "");
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
 		}
 	}          
  /**
   * calling function in case of OnSelectCell event <br>
   * <br><b>Example :</b>
   * <pre>
   *		
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {int} OldRow Mandatory ,previous selected cell's Row Index
   * @param {int} OldCol Mandatory Previous selected Cell's Column Index
   * @param {int} NewRow Mandatory ,current selected cell's Row Index
   * @param {int} NewCol Mandatory ,current selected cell's Column Index
   * @return void
   * @author 
   * @version 2009.04.17
   */        	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
       if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
       }
	}       
		/**
      * Controlling button's authority<br>
      * controlling buttons <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControl()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */
      function buttonControl(){
 			var formObj=document.form;
 			var reqUsrFlg=formObj.req_usr_flg.value;
 			var aproUsrFlg=formObj.apro_usr_flg.value;
 			var amdt_seq=formObj.amdt_seq.value;
 			var sts=formObj.prop_sts_cd.value;
			if(amdt_seq == 0) {
 				hiddenButton("btn_Amend");
 				hiddenButton("btn_AmendCancel");
 			} else {
 				showButton("btn_Amend");
 				showButton("btn_AmendCancel");	
 			}			
 			if (aproUsrFlg == "false" && reqUsrFlg == "false"){
 				ComBtnDisable("btn_Save");
 				hiddenButton("btn_Amend");
 				hiddenButton("btn_AmendCancel");
 				ComBtnDisable("btn_Accept");
 				ComBtnDisable("btn_AcceptCancel");
				for (var i=1; i <= sheetObjects[0].RowCount();i++){
					sheetObjects[0].SetCellEditable(i,"ctrt_pty_nm",0);
					sheetObjects[0].SetCellEditable(i,"ctrt_pty_addr",0);
					sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_nm",0);
					sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_tit_nm",0);
				}	
 				return;
 			}
 			try{
 				switch(sts) { 				
 					case 'I':   // Initial	
 						ComBtnDisable("btn_Accept");
 						ComBtnDisable("btn_AcceptCancel");
 						for (var i=1; i <= sheetObjects[0].RowCount();i++){
 							if (sheetObjects[0].GetCellValue(i, "prc_prog_sts_cd") == "I"){
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_nm",1);
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_addr",1);
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_nm",1);
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_tit_nm",1);
 							}else{
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_nm",0);
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_addr",0);
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_nm",0);
 	 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_tit_nm",0);
 							}
 						}	
 						break;
 					case 'A': // Approved X, Retrieving O,downexcel O
 						ComBtnDisable("btn_Save");
 						ComBtnDisable("btn_Amend");
 						ComBtnDisable("btn_AmendCancel");
 						ComBtnDisable("btn_Accept");
 						ComBtnDisable("btn_AcceptCancel");
 						break;
 					case 'Q':// Requested  
 						ComBtnDisable("btn_Save");
 						ComBtnDisable("btn_Amend");
 						ComBtnDisable("btn_AmendCancel");
 						if (aproUsrFlg == "true"){
 							ComBtnEnable("btn_Accept");
 							ComBtnEnable("btn_AcceptCancel");
 						}else{
 							ComBtnDisable("btn_Accept");
 							ComBtnDisable("btn_AcceptCancel");							
 						}
 						for (var i=1; i <= sheetObjects[0].RowCount();i++){
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_nm",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_addr",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_nm",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_tit_nm",0);
 						}						
 						break;
 					case 'R':  // Returned accept only 
 						ComBtnDisable("btn_Save");
 						ComBtnDisable("btn_Amend");
 						ComBtnDisable("btn_AmendCancel");						
 						if(reqUsrFlg == "true"){
 							ComBtnDisable("btn_Accept");
 							ComBtnDisable("btn_AcceptCancel");
 						}
 						if (aproUsrFlg == "true"){
 							ComBtnEnable("btn_Accept");
 							ComBtnEnable("btn_AcceptCancel");
 						}
 						for (var i=1; i <= sheetObjects[0].RowCount();i++){
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_nm",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_addr",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_nm",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_tit_nm",0);
 						}
 						break;
 					case 'F': // Filed
 						ComBtnDisable("btn_Save");
 						ComBtnDisable("btn_Amend");
 						ComBtnDisable("btn_AmendCancel"); 						
 						ComBtnDisable("btn_Accept");
 						ComBtnDisable("btn_AcceptCancel");
 						for (var i=1; i <= sheetObjects[0].RowCount();i++){
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_nm",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_addr",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_nm",0);
 							sheetObjects[0].SetCellEditable(i,"ctrt_pty_sgn_tit_nm",0);
 						}
 						break;
 					case 'C': //  // Cancled
 						break;
 					default:
 	    				showButton("btn_Amend");
 	    				showButton("btn_AmendCancel");
 	    				ComBtnEnable("btn_Accept");
 	    				ComBtnEnable("btn_AcceptCancel");
 						break;
 				} 		
 		} catch (e) {
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e.message);
 			}
 		}
 	}    
  /**
   * handling process for input validation <br>
   * <br><b>Example :</b>
   * <pre>
   *     if (validateForm(sheetObj,document.form,IBSAVE)) {
   *        handling logic
   *     }
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {form} formObj mandatory html form object
   * @param {int} sAction mandatory,Constant Variable
   * @returns bool <br>
   *          true  : valid<br>
   *          false : inValid
   * @author 
   * @version 2009.04.17
   */
    function validateForm(sheetObj,formObj,sAction){
 		switch (sAction) {	
   			case IBSAVE: // Saving
		 	if (!ComPriConfirmSave()) {
                 return false;
             }
   			break;
     	}
 		return true;
    }
