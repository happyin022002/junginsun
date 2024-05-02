/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0057_18.js
*@FileTitle  : Amendment History Inquiry Contract Parties Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
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
     * @class ESM_PRI_0057_18 : Business Script for ESM_PRI_0057_18
     */
    function ESM_PRI_0057_18() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
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
	  * @version 2009.09.21
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
				case "prc_ctrt_pty_tp_cd":
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
     * @version 2009.09.21
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
     * @version 2009.09.21
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//Modify Environment Setting Function's name
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//Add Environment Setting Function
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();
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
			divStr += "<input type=\"radio\" name=\"prc_ctrt_pty_tp_cd\" value=\""+prcCtrtPtyTpCdCode[i]+"\" class=\"trans\""+checked+"><span id=\"tp"+(i+1)+"\">"+prcCtrtPtyTpCdName[i]+"</input>";
			if(i < prcCtrtPtyTpCdCode.length)
				divStr += "&nbsp;&nbsp;&nbsp;&nbsp;";
		 }
		document.getElementById("div_prcCtrtPtyTpCd").innerHTML="<div id=\"div_prcCtrtPtyTpCd\">"+ divStr +"</div>";
		
		loadSts=true;
     	parent.loadTabPage();
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
     * @version 2009.09.21
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	var amdt_seq=document.form.amdt_seq.value;
    	switch(sheetID) {    	
    		case "sheet1":      // sheet1 init    		
				with(sheetObj){
					var HeadTitle="|prop_no|amdt_seq|prc_ctrt_pty_tp_cd|cust_cnt_cd|cust_seq|ctrt_cust_val_sgm_cd|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|"
					HeadTitle += "Contract Party|Address|Signature|Title|EFF Date|EXP Date|Source|Source|Status|Status|Accept Staff/Team||Accept Date|";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
					if (amdt_seq == "0"){
						  cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
						  cols.push({Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
						  cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
						  cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 });
					 }else{
						  cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
						  cols.push({Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
						  cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
						  cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					 }
					  cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					  cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 });
					 
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(240);
					SetEditable(0);
					SetWaitImageVisible(0);
					SetColHidden("chk",1);
					//SetAutoRowHeight(0);
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
     * @version 2009.09.21
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {    	
    		case IBSEARCH_ASYNC10: // Retrieving service scope when loading screen
 	 			//radio button data check
    			document.form.prc_ctrt_pty_tp_cd[0].checked=true;
	    		formObj.f_cmd.value=COMMAND13;
	    		// common Source // Common Status
	    		formObj.cd.value="CD02064:N:CD01719:N";
	    		// "Y" in case of code|desc
	    		var sXml=sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
	    		var arrXml=sXml.split("|$$|");
	    		if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"src_info_cd", false, 0, "NW"); 				
	    		if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_prog_sts_cd", false, 0, "I");
	    		break;
 	 		case IBSEARCH_ASYNC20: // execute option 
 	 			formObj.f_cmd.value=SEARCH11;
 	 			var eleName="";
 	 			var sXml=sheetObj.GetSearchData("ESM_PRI_0057_18GS.do" , FormQueryString(formObj));
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
 	 			ComOpenWait(true);
 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
 					ComShowCodeMessage('PRI08001');
 					ComOpenWait(false);
 					return false;
 				}				
 				formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("ESM_PRI_0057_18GS.do", FormQueryString(formObj) );
 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
 				ComOpenWait(false);
 				break;
    	}//end switch
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
     * @version 2009.09.21
     */ 	 	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
  		var sCols="ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm";
  		searchEndFontChange(sheetObj, sCols, document.form.lgcy_if_flg.value); 	   
	}         
    /**
     * Calling function in case of Onclick event <br>
     * Calling User Info Popup<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @returns void
     * @author  
     * @version 2009.09.21
     */
    function sheet1_OnClick (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "acpt_usr_nm":
                if (Value != "") {
                	ComUserPopup(sheetObj.GetCellValue(Row,"acpt_usr_id"));
                }
                break;
        }
    } 
    /**
   	 * calling function in case of OnSelectCell event <br>
     * Displaying different highlight color at Amend Row<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.09.21
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {

        }
    }
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @return void
     * @author 
     * @version 2009.09.21
     */ 
	function pageOnLoadFinish() {
		loadSts=true;
     	parent.loadTabPage();
    }
    /**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sConChk Optional con_chk value
	 * @param {string} sLgcyIfFlg Mandatory lgcy_if_flg value	 
     * @return void
     * @author 
     * @version 2009.09.21
     */ 		    	
     function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
    	var formObj=document.form;
    	if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq) {
   			formObj.prop_no.value=sPropNo;
   			formObj.amdt_seq.value=sAmdtSeq;
   			formObj.lgcy_if_flg.value=sLgcyIfFlg;
   			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);
   			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   		}
    }
  	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.09.21
     */ 		 
  	function tabClearSheet() {
  		var formObject=document.form;
  		formObject.prop_no.value="";
  		formObject.amdt_seq.value="";
  		sheetObjects[0].RemoveAll();
 	}
  	var enableFlag=true;
  	/**
  	 * Calling function from main<br>
  	 * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * tabEnableSheet(flag)
  	 * </pre>
  	 * @param {boolean} flag Mandatory from Main screen
  	 * @return void
  	 * @author 
  	 * @version 2009.09.21
  	 */
  	function tabEnableSheet(flag) {
  		var formObject=document.form;	
  		enableFlag=flag;
  		sheetObjects[0].SetEditable(flag);
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
     * @version 2009.09.21
     */
     function validateForm(sheetObj,formObj,sAction){
 		switch (sAction) {
 			case IBSEARCH: // retrieving			
 				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "") {
  					ComShowCodeMessage('PRI08001');
  					return false;
  				}
 				return true;
  				break;
 		}
 		return true;
 	}
    var loadSts=false;
  	/**
  	 * Function to check whether Tab screen of Parent is loaded from Frame or not<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 		loadFinishCheck()
  	 * </pre>
  	 * @param  void
  	 * @return bool  loadSts  <br>
  	 *               true  : load completed
  	 *               false : load not completed
  	 * @author 
  	 * @version 2009.09.21
  	 */ 	
    function loadFinishCheck(){
         return loadSts;
    }     