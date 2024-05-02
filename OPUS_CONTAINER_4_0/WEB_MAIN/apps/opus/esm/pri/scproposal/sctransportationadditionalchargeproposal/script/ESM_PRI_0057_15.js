/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_15.js
 *@FileTitle  : Amend History Inquiry Origin/Destination IHC
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
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
     * @class ESM_PRI_0057_15 : Business Script for ESM_PRI_0057_15
     */
    function ESM_PRI_0057_15() {
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
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0;
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
     * @version 2009.09.11
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				break;
              }
     	} catch(e) {
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
     * @version 2009.09.11
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
     * @version 2009.09.11
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
    	initControl();
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
     * @version 2009.09.11
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
				with(sheetObj){
					var HeadTitle="Seq.|Point|Description|Zip Code|Zip Code|Trans Mode|Term|Base Port|Per|Cargo Type|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date|prop_no|amdt_seq||||||||";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd" },
					 {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm" },
					 {Type:"Text",     Hidden:0,  Width:20,   Align:"Left",    ColMerge:0,   SaveName:"loc_grd_cnt_cd" },
					 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"loc_grd_cd" },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd" },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd" },
					 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd" },
					 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd" },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd" },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
					 {Type:"Text",     Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm" },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id" } ];
					   
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(240);
					SetEditable(0);
					SetWaitImageVisible(0);
					SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
					SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
					SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
					SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
					SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
					SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
					//SetAutoRowHeight(0);
				}
    			break;
    		case "sheet2":
				with(sheetObj){
					var HeadTitle="status";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
					   
					InitColumns(cols);
					SetEditable(1);
					SetVisible(0);
				}
                break;
    	}
    }
    
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
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
     * @version 2009.09.11
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
  			var formObj=document.form;
			setSheetDisplay(sheetObj);
 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
 		}
 	}   
    /**
     * Calling function in case of Onclick event <br>
     * Calling user info popup<br>
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
     * @version 2009.09.11
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
     * @version 2009.09.11
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
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    //no support[check again]CLT function pageOnLoadFinish() {
    	
    //}
    /**
 	 * Loading HTML control's event on page dynamically<br>
 	 * <br><b>Example :</b>
 	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
 	 * @return void
     * @author 
     * @version 2009.09.11
 	 **/
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		// Process Axon Event No.1, Event Catch 
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.09.11
     */
	function obj_click(){
		var sheetObject1=sheetObjects[0];
		var formObject=document.form;
		if (event.srcElement.name == "org_dest_tp_cd") {
			doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
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
     * @version 2009.09.11
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	     	case IBSEARCH:
	     		ComOpenWait(true);	
	     		formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_0057_15GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
	     		break;
			case IBSEARCH_ASYNC02: // Retrieving font style
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0057_15GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;		
			case IBSEARCH_ASYNC03:
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02138";
				} else {
					formObj.cd.value="CD02139";
				}
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
			case IBSEARCH_ASYNC04: // radio button Select
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0057_15GS.do", FormQueryString(formObj));
				var arrDesc=ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked=true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 			}
				}
				break;
	    }
	}
	/**
     * setting sheet's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.09.11
     */
	function setSheetDisplay(sheetObj) {
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var lgcyIfFlg=form.lgcy_if_flg.value;
		var rCnt=sheetObj.RowCount();
		for(var i=1 ; i<=rCnt; i++) {
			if(sheetObj.GetCellValue(i ,"amdt_seq") != amdtSeq) { // Strikeout, not editable
				sheetObj.SetCellFont("FontStrike", i, "seq", i, "acpt_dt",1);
			} else if(lgcyIfFlg != "Y") {
				sheetObj.SetCellFont("FontColor", i, "seq", i, sheetObj.LastCol(),"#FF0000");// RED
			}
		}
	}
	/**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabLoadSheet("SHA090001", 2, "ACE", true)
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sConChk Mandatory con_chk value
     * @return void
     * @author 
     * @version 2009.09.11
     */    	
     function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
 		var formObj=document.form;
 		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd) {
 			formObj.prop_no.value=sPropNo;
 			formObj.amdt_seq.value=sAmdtSeq;
 			formObj.svc_scp_cd.value=sSvcScpCd;
 			formObj.lgcy_if_flg.value=sLgcyIfFlg;
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC04); // Setting Radio Button Default
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03); //Term
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
 		}
 	}
     /**
      * Function to clear control of tab screen on parent <br>
      * <br><b>Example :</b>
      * <pre>
      * 		tabClearSheet()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.09.11
      */
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
	}     
	var enableFlag=true;
	/**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
	 *  changing font's color of TYPE RADIO button <br>
     * 1) Blue : ALL ACCEPT<br>
     * 2) Red : Amendment<br>
     * <br><b>Example :</b>
     * <pre>
     * 		setTypeFontStyle(sXml);
     * </pre>
     * @param {object} sXml Mandatory Xml Object
     * @return void
     * @author 
     * @version 2009.09.11
     */
     function setTypeFontStyle(sXml) {
     	var arrDesc=ComPriXml2Array(sXml, "org_font_style|dest_font_style");
     	var lgcyIfFlg=form.lgcy_if_flg.value;
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color="blue";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color="black";
 				}
 			} else if(arrDesc[0][0] == "red") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color="red";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color="black";
 				}
 			} else if(arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			}
 			if(arrDesc[0][1] == "blue") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color="blue";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color="black";
 				}
 			} else if(arrDesc[0][1] == "red") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color="red";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color="black";
 				}
 			} else if(arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd2").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd2").style.color="black";
 			}
 		}
    }
    var loadSts=false;
    /**
     * Calling function from main<br>
     * It calls at Loading is completed. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return void
     * @author 
     * @version 2009.09.10
     */
    function loadFinishCheck(){
        return loadSts;
    }	 