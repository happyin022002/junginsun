/*=========================================================
*1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_04.js
*@FileTitle  :  S/C Proposal Origin/Destination Arbitrary Charge Creation
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
     * @extends
     * @class ESM_PRI_0003_04 : Business Script for ESM_PRI_0003_04
     */
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var selctRowCount = 0;
	var CONFIRM_ORG_GLINE=false; // Whether guideline copied
	var CONFIRM_DEST_GLINE=false; // Whether guideline copied
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
     * @version 2009.05.18
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
    				buttonControl();
    				break;
    			case "btn_save":
    				doActionIBSheet(sheetObject1, formObj, IBSAVE);
    				buttonControl();
    				break;
    			case "btn_acceptall":
    				doActionIBSheet(sheetObject1,document.form,MODIFY03);
    				break;
    			case "btn_cancelall":
    				doActionIBSheet(sheetObject1,document.form,MODIFY04);
    				break;
    			case "btn_glinecopy":
    				var orgDestTpCd=getOrgDestTpCd();
   	  				confirmGuidelineCopy(sheetObject1, document.form, orgDestTpCd);
    				break;
    			case "btn_gricalc":
    				// Check whether modified data exist on data sheet 1, 2
 					if(sheetObjects[0].IsDataModified()== false){
 						var formObj=document.form;
 						if (formObj.prop_no.value =="" && formObj.amdt_seq.value ==""){
 							ComShowCodeMessage('PRI01055');
 							return;
 						}
 						if(sheetObjects[0].RowCount()== 0) {return;}
 		   	    		var sPropNo=formObj.prop_no.value;
 						var sAmdtSeq=formObj.amdt_seq.value;
 						var sSvcScpCd=formObj.svc_scp_cd.value;
 						var sAddChgTpCd="A";
 						var sOrgDestTpCd="O";
 						if(!formObj.org_dest_tp_cd[0].checked) {
 							sOrgDestTpCd="D";
 						}
 						var sEffDt=formObj.eff_dt.value;
 						var sPropStsCd=formObj.prop_sts_cd.value;
 						var sApplFlg="N";
 		   				var applFlgChk=sheetObjects[0].FindText("gri_appl_tp_cd", "A", 0, -1);
 		   				if(applFlgChk > 0) {
 		   				    sApplFlg="Y";
 		   				}
 						var sParam="sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sSvcScpCd="+sSvcScpCd+"&sAddChgTpCd="+sAddChgTpCd+"&sOrgDestTpCd="+sOrgDestTpCd+"&sEffDt="+sEffDt+"&sApplFlg="+sApplFlg+"&sPropStsCd="+sPropStsCd;
 						ComOpenPopup("ESM_PRI_0109.do?"+sParam, 605, 470, "btn_gricalc_returnVal", "none", false);
 						
 						break;
 					} else {
 						ComShowCodeMessage('PRI01057');
 					}
    			break;
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject1,formObj,IBDOWNEXCEL);
    				break;
    			case "btn_loadexcel":
    				doActionIBSheet(sheetObject1,formObj,IBLOADEXCEL);
    				break;
    			case "btn_rowadd":
    				doActionIBSheet(sheetObject1,formObj,IBINSERT);
    				break;
    			case "btn_rowcopy":
    				doActionIBSheet(sheetObject1,formObj,IBCOPYROW);
    				break;
    			case "btn_delete":
    				doActionIBSheet(sheetObject1,formObj,IBDELETE);
    				break;
    			case "btn_amend":
    				doActionIBSheet(sheetObject1,formObj,COMMAND01);
    				break;
    			case "btn_amendcancel":
    				doActionIBSheet(sheetObject1,formObj,COMMAND02);
    				break;
    			case "btn_accept":
    				doActionIBSheet(sheetObject1,formObj,MODIFY01);
    				break;
    			case "btn_acceptcancel":
    				doActionIBSheet(sheetObject1,formObj,MODIFY02);
    				break;
              } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    
    function btn_gricalc_returnVal(rtnVal) {
    	var formObj=document.form;
    	if (rtnVal != null && rtnVal == "OK") {
	            setProposalStatusSummary(formObj);
	            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
     * @version 2009.05.18
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
     * @version 2009.05.18
     */
    function loadPage() {
    	for(var i=0;i<sheetObjects.length;i++){
    		//Modify Environment Setting Function's name
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//Add Environment Setting Function
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();
    	pageOnLoadFinish();
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
     * @version 2009.05.18
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
    		    with(sheetObj){
		    	        
		    	      var HeadTitle="state|FontType|Sel.|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|GRI|GRI|seq|Note|note_ctnt_text|prop_no|amdt_seq|||chg_seq||||||n1st|pre_note_dp_seq|PER_TYPE";
		
		    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		
		    	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    	                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tmp_type" },
		    	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		    	             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		    	             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		    	             {Type:"Float",     Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		    	             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    	             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    	             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		    	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		    	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		    	             {Type:"Float",     Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		    	             {Type:"Float",     Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"gri_appl_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		    	             {Type:"Text",      Hidden:0, Width:300,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:300,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_text",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"via_port_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pre_note_dp_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"per_type" }];
		    	       
		    	      InitColumns(cols);
		
		    	      SetWaitImageVisible(0);
		    	      SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
		    	      SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		    	      SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		    	      SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		    	      SetColProperty("gri_appl_tp_cd", {ComboText:griApplTpCdText, ComboCode:griApplTpCdValue} );
		    	      SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
		    	      SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
		    	      
		    	      SetColProperty(0 ,"rout_pnt_loc_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		    	      SetColProperty(0 ,"bse_port_def_cd" 		, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		    	      SetColProperty(0 ,"via_port_def_cd" 		, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		    	      SetColProperty(0 ,"note_dp_seq" , {AcceptKeys:"[1234567890]"});
		    	      
		    	      //SetAutoRowHeight(0);
		    	      resizeSheet(); //SetSheetHeight(290);
    	      }
    			break;
    		case "sheet2":
    		    with(sheetObj){
	    	      SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );	
	    	      var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	    	      var headers = [ { Text:"", Align:"Center"} ];
	    	      InitHeaders(headers, info);	
	    	      var cols = [  {Type:"Text", Hidden:1,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];	    	       
	    	      InitColumns(cols);
	    	      SetVisible(0);
    		}    	      
               break;
    	}
    }
    
    function resizeSheet() {
  	   	ComResizeSheet(sheetObjects[0]);
  	}
    
    
    function tmp_object(sheet, row){
		this.row = row;
		this.sheet = sheet;
	}
	var G_TMP_OBJECT;
 	
    /**
	 * sheet1 OnPopupClick event function <br>
	 * calling popup window <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.18
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	var propNO=sheetObj.GetCellValue(Row, "prop_no");
    	var amdtSeq=sheetObj.GetCellValue(Row, "amdt_seq");
    	var svcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
    	var tpCd="";
    	G_TMP_OBJECT = new tmp_object(sheetObj, Row);
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl="ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=L&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
 			ComOpenPopup(sUrl, 700, 320, "rout_pnt_loc_def_cd_returnVal", "0,1", true);
 			
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
 			ComOpenPopup(sUrl, 700, 320, "bse_port_def_cd_returnVal", "0,1", true);
 			
 		} else if (colName == "via_port_def_cd") { //VIA
 			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
 			ComOpenPopup(sUrl, 700, 320, "via_port_def_cd_returnVal", "0,1", true);

 		}  else if (colName == "prc_cmdt_def_cd") { //Commodity
 			var sUrl="ESM_PRI_4027.do?commodity_cmd=CG&grp_cd="+PRI_SP_SCP+"&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
 			ComOpenPopup(sUrl, 700, 350, "prc_cmdt_def_cd_returnVal", "0,1", true);
 			
 		}
    }
    
    function rout_pnt_loc_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	var sheetObj = G_TMP_OBJECT.sheet;
    	if (rtnVal != null){
    		if(!checkRoutePointLocation(sheetObj, G_TMP_OBJECT.row, rtnVal.cd)){
        		return;
        	}
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_pnt_loc_def_nm", rtnVal.nm,0);
			if (rtnVal.cd.length == 5){ //SEtting Location Type
				tpCd="L";
			}
			sheetObj.SetCellValue(G_TMP_OBJECT.row,"rout_pnt_loc_tp_cd", tpCd ,0);
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_pnt_loc_def_cd", rtnVal.cd, 1);
    	}
    }
    
    function bse_port_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	var sheetObj = G_TMP_OBJECT.sheet;
    	if(rtnVal != null){
    		if(!checkBasePort(sheetObj, G_TMP_OBJECT.row, rtnVal.cd)){
    			return;
    		}
    		if(rtnVal.cd.length == 5) { //Modifying Location Type
				tpCd="L";
			} else if(rtnVal.cd.length == 4) { //Modifying Location Type
				tpCd="G";
			}
			sheetObj.SetCellValue(G_TMP_OBJECT.row,"bse_port_tp_cd",tpCd ,0);
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "bse_port_def_cd", rtnVal.cd, 1);
		}
    }
    
    function via_port_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	var sheetObj = G_TMP_OBJECT.sheet;
    	if (rtnVal != null) {
			
			if (rtnVal.cd.length == 5){ //SEtting Location Type
				tpCd="L";
			} else if(rtnVal.cd.length == 4) { //Modifying Location Type
				tpCd="G";
			}
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "via_port_tp_cd", tpCd ,0);
			sheetObj.SetCellEditable(G_TMP_OBJECT.row, "dir_call_flg", 0);//Direct Call not use
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "via_port_def_cd", rtnVal.cd, 1);
		}
    }
    
    function prc_cmdt_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	var sheetObj = G_TMP_OBJECT.sheet;
    	if (rtnVal != null){
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "prc_cmdt_def_cd", rtnVal.cd, 0);
			if(rtnVal.cd.length == 5) {
				tpCd="G";
			} else if(rtnVal.cd.length == 6) {
				tpCd="C";
			}
			sheetObj.SetCellValue(G_TMP_OBJECT.row,"prc_cmdt_tp_cd", tpCd, 0);
		}
    }
    
    
    /**
     * It calls when OnClick event triggered on sheet1 <br>
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
     * @version 2009.05.18
     */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		//Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
		var formObj=document.form;
		var colname=sheetObj.ColSaveName(Col);
		var propStsCd=formObj.prop_sts_cd.value;
		var amdtSeq=formObj.amdt_seq.value;
		switch (colname) {
			case "add_chg_note_ctnt":
				if(propStsCd == "I" && sheetObj.GetCellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.GetCellValue(Row, "src_info_cd") != "AD") {
					if (sheetObj.GetCellValue(Row, "prc_prog_sts_cd") == "I"){
						ComShowMemoPad(sheetObj, Row, Col, false, null, null, null,1);
					}else{
						ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1);
					}
				} else {
					ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1);
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
     * @version 2009.05.18
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
	/**
	 * Calling funciton in case of OnChange event on sheet1<br>
	 * when selecting multi comboBox, showing description and retrieveing validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @param {string} Value Mandatory Value
	 * @return void
	 * @author 
	 * @version 2009.05.18
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var amdt_seq=formObj.amdt_seq.value;
		switch(sName) {
			case "rout_pnt_loc_def_cd": //point
				if(!checkRoutePointLocation(sheetObj, Row, Value)) {
					return;
				}
				checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
				break;
			case "rcv_de_term_cd": //Term
				setTermCode(sheetObj, Row, Value);
				break;
			case "bse_port_def_cd": //base port
				if(!checkBasePort(sheetObj, Row, Value)) { //Comparing with point
					 return;
				}
				checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
 	    		break;
			case "via_port_def_cd":
				checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, true);
				setDirectCall(sheetObj, Row, Value);
 				break;
			case "dir_call_flg":
				setVia(sheetObj, Row, Value);
				break;
			case "rat_ut_cd":
				checkPerType(sheetObj, Row, Value);
				break;
			case "prc_cgo_tp_cd":
				checkCargoType(sheetObj, Row, Value);
				break;
			case "prc_cmdt_def_cd":
				checkCommodity(sheetObj, Row, Value);
	 			break;
			case "prop_frt_rt_amt":
//				if(Value < 0) {
//					ComShowMessage("Negative number is inputted. Please check again.");
//				}
				break;
			case "coffr_frt_rt_amt":
//				if(Value < 0) {
//					ComShowMessage("Negative number is inputted. Please check again.");
//				}
				if(sheetObj.GetCellValue(Row, "prop_frt_rt_amt") == Value) {
					ComShowCodeMessage('PRI01044');
					sheetObj.SetCellValue(Row, "coffr_frt_rt_amt","",0);
					sheetObj.SelectCell(Row, "coffr_frt_rt_amt");
					return;
				}
				if(ComNullToZero(Value) == 0) {
					sheetObj.SetCellValue(Row, "prc_prog_sts_cd","I",0);//Modifying to Initial
				} else {
					sheetObj.SetCellValue(Row, "prc_prog_sts_cd","R",0);//Modifying to Return
				}
				break;
		}
		var propStsCd=formObj.prop_sts_cd.value;
		if(amdt_seq == 0 && propStsCd == 'I') {
			if(sName != "note_dp_seq"){
				if (sheetObj.GetCellValue(Row, "src_info_cd") == "PC") {
					sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
				} else if (sheetObj.GetCellValue(Row, "src_info_cd") == "GC") {
					sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
				}
			}
		}
    }
    /**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		// Location
		if (locCd.length == 5 && isLoc) {
			
			if (cellDefCdNm == "rout_pnt_loc_def_cd" || cellDefCdNm == "via_port_def_cd") {				
				formObj.f_cmd.value=SEARCH05;
				var locCd = sheetObj.GetCellValue(Row, cellDefCdNm);
				formObj.cd.value=locCd;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
					if (cellDefCdNm == "rout_pnt_loc_def_cd") {
						sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrDesc[0][1],0);
					}
				} else {
					locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
					sheetObj.SelectCell(Row, cellDefCdNm);
				}
			
			} else if (cellDefCdNm == "bse_port_def_cd") {				
				formObj.f_cmd.value=COMMAND31;
				formObj.cd.value=locCd;
				var sOriDesGbCd=ComGetObjValue(formObj.org_dest_tp_cd);
				var sParam=FormQueryString(formObj)+"&etc1="+sOriDesGbCd;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				} else {
					ComShowCodeMessage("PRI01137");
					locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
					if (cellDefCdNm == "rout_pnt_loc_def_cd") {
						sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
					}
					sheetObj.SelectCell(Row, cellDefCdNm);
				}
			}			
			
		}
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
 			formObj.f_cmd.value=SEARCH17;
 			formObj.cd.value=locCd;
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm, "G", 0);
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row,cellDefCdNm);
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	/**
     * Re-setting location code <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
		//rout_pnt_loc_def_cd가 clear되면 rout_pnt_loc_def_nm 항상 clear
		if(cellDefCdNm == "rout_pnt_loc_def_cd") {
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
		}
	}
	/**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.05.18
	 **/
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		// Process Axon Event No.1, Event Catch 
 		axon_event.addListenerForm('click', 'obj_click', 		form);
 	}
 	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function obj_click(){
		var formObj=document.form;
		var orgDestTpCd=getOrgDestTpCd();
		if(ComGetEvent("name") == "org_dest_tp_cd") {
			// Check Modified data exists
			if(sheetObjects[0].IsDataModified()) {
				// Will you save modified data?
				if(ComShowCodeConfirm('PRI00006')) {
					// When Error occurred while modifying, Set Radiobutton as first.
					if(doActionIBSheet(sheetObjects[0], formObj, MODIFY05)==false) {
						returnRadioButton();
						formObj.f_cmd.value=SEARCH01;
						sheetObjects[0].DoSearch("ESM_PRI_0003_04GS.do", FormQueryString(formObj), {Sync:1} );
			     		ComOpenWait(false);
						return false;
					}
				} else {
					returnRadioButton();
					return;
				}
			}
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03); // Retrieving Term Code
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			buttonControl();
  			if(((!CONFIRM_ORG_GLINE && orgDestTpCd == "O") || (!CONFIRM_DEST_GLINE && orgDestTpCd == "D")) && sheetObjects[0].RowCount()== 0 && formObj.prop_sts_cd.value == "I") {
  				confirmGuidelineCopy(sheetObjects[0], formObj, orgDestTpCd);
  			}
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
     * @version 2009.05.18
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
	     	case IBSEARCH:  //Retrieve
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		//[Strike Font]-----------------------------------------
	     		var sIdx = sheetObj.HeaderRows();
	     		var eIdx = sheetObj.LastRow();
	     		//init FontStrike
	     		for(var j = sIdx; j < eIdx; j++){
					var sVal = sheetObj.GetCellValue(j, "tmp_type");
					if(sVal == "S" || sVal == "C"){
						sheetObj.SetRowEditable(i, 1);
					}
				}
	     		sheetObj.SetCellFont("FontStrike", sIdx,0,eIdx,sheetObj.LastCol(),0);
	     		//[Strike Font]-----------------------------------------
	     		isAllReadyUse = false;
	     		formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_0003_04GS.do", FormQueryString(formObj), {Sync:2} );
				formObj.gri_btn.value=sheetObj.GetEtcData("btnEnable");
				ComOpenWait(false);
	     		break;
	     	case IBSEARCH_ASYNC01: //Guideline copy
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
				}
	     		formObj.f_cmd.value=SEARCH02;
	     		var sXml=sheetObj.GetSearchData("ESM_PRI_0003_04GS.do", FormQueryString(formObj));
	     		//sheetObj.LoadSaveData(sXml);
	     		// Process Copy if Guideline data exists
	     		if(ComGetEtcData(sXml, "FLAG") == "Y") {
	     			formObj.f_cmd.value=MULTI02;
					sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", FormQueryString(formObj));
					//sheetObj.LoadSaveData(sXml);
					searchAfterSave(formObj, sheetObj, sXml);
	     		}
	     		ComOpenWait(false);
				break;
			case IBSEARCH_ASYNC02: // Setting font style
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;
			case IBSEARCH_ASYNC03: // Retrieving Term Code 
//				formObj.f_cmd.value=SEARCH19;
//				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
//					formObj.cd.value="CD02138";
//				} else {
//					formObj.cd.value="CD02139";
//				}
//				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
//				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					sheetObjects[0].SetColProperty("rcv_de_term_cd", {ComboText:orgRcvDeTermCdText, ComboCode:orgRcvDeTermCdValue} );
				} else {
					sheetObjects[0].SetColProperty("rcv_de_term_cd", {ComboText:destRcvDeTermCdext, ComboCode:destRcvDeTermCdValue} );
				}
				break;
			case IBSEARCH_ASYNC04: //Retrieving row count of Ori, Dest data
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", FormQueryString(formObj));
				var arrDesc=ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 				CONFIRM_ORG_GLINE=true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked=true;
		 				CONFIRM_DEST_GLINE=true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 			}
				}
				break;
			case IBSAVE:
	     		//ComOpenWait(true);
	     		if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			//ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=MULTI01;
	     		var sParam=FormQueryString(formObj);
				var sParamSheet1=sheetObj.GetSaveString();
				sParam += "&" + sParamSheet1;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParam);
				searchAfterSave(formObj, sheetObj, sXml);
				//ComOpenWait(false);
				//doActionIBSheet(sheetObj, formObj, IBSEARCH);
				isAllReadyUse = false;
				formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_0003_04GS.do", FormQueryString(formObj), {Sync:1} );
	     		setSheetDisplay(sheetObj);
	     		//ComOpenWait(false);
	     		ComShowCodeMessage('PRI00101');
	     		break;
			case IBINSERT: //Row Add
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				var idx=sheetObj.DataInsert();
				setGetRowEditable(sheetObj, idx, true, "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|note_dp_seq");
				sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
				sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "add_chg_tp_cd","A");
				sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd));
				sheetObj.SetCellValue(idx, "add_chg_seq",parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "curr_cd","USD");
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
				if(amdt_seq > 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
				}
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
				break;
				
			case IBCOPYROW: //Row Copy
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				var idx=sheetObj.DataCopy();
				if(idx == 0) return false;
				setGetRowEditable(sheetObj, idx, true, "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|note_dp_seq");
				sheetObj.SetCellValue(idx, "chk",0);
				sheetObj.SetCellValue(idx, "add_chg_seq",parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "add_chg_tp_cd", "A");
				sheetObj.SetCellValue(idx, "coffr_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "fnl_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
				//note_dp_seq
//				sheetObj.CellValue(idx, "note_dp_seq") = "";
//				sheetObj.CellValue(idx, "add_chg_note_ctnt") = "";
				sheetObj.SetCellValue(idx, "pre_note_dp_seq","");
				if(amdt_seq > 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
				}
				break;
				
			case IBDELETE: //Row Delete
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				if(amdt_seq == "0") {

					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0) {
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",1,0);
						if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd")!="I"){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",0,0);
							ComShowCodeMessage("PRI01002");
							return;
						}
					}else{
						for(var i=0;i < chkArr.length;i++){
							if (sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd")!="I"){
								ComShowCodeMessage("PRI01002");
								return;
							}
						}
					}
					deleteRowCheck(sheetObj, "chk");
				} else {
					var eff_dt=formObj.eff_dt.value;
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length > 0) {
						for(i=0;i < chkArr.length;i++){
							if(sheetObj.GetCellValue(chkArr[i],"amdt_seq") != amdt_seq) {
								ComShowCodeMessage("PRI01002");
								return;
							}
							if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq) {
								if(sheetObj.GetCellValue(chkArr[i],"src_info_cd") == "AM"
									|| sheetObj.GetCellValue(chkArr[i],"src_info_cd") == "AD"
										|| sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "I") {
									ComShowCodeMessage("PRI01002");
									return;
								}
								deleteRowCheck(sheetObj, "chk");
								return;
							}
						}
						var sRow=0;
						amendRow(sheetObj, document.form, "D");
					} else {
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq") != amdt_seq) {
							ComShowCodeMessage("PRI01002");
							return;
						}
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") == amdt_seq) {
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd") == "AM"
								|| sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd") == "AD"
									|| sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") !="I") {
								ComShowCodeMessage("PRI01002");
							} else {
								sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
								deleteRowCheck(sheetObj, "chk");
							}
						} else {
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk", 1);
							amendRow(sheetObj, formObj, "D");
						}
					}
				}
				break;
			case MODIFY01:	//Accept
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI03;
				acceptRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY02:	//Accept Cancel
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI04;
				acceptCancelRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY03:	//Accept All
//				ComOpenWait(true);
//				if (!validateForm(sheetObj, document.form, sAction)) {
//					ComOpenWait(false);
//					return false;
//				}
//
//				formObj.f_cmd.value = MULTI05;
//				acceptAllRows(sheetObjects[0], document.form);
//				ComOpenWait(false);
//				break;
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI07;
				acceptAllRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY04:	//Cancel All
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI08;
				acceptCancelAllRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
//				ComOpenWait(true);
//				if (!validateForm(sheetObj, document.form, sAction)) {
//					ComOpenWait(false);
//					return false;
//				}
//
//				formObj.f_cmd.value = MULTI06;
//				acceptCancelAllRows(sheetObjects[0], document.form);
//				ComOpenWait(false);
//				break;
			case MODIFY05:
	     		if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			return false;
	     		}
	     		ComOpenWait(true);
				var sParamSheet=sheetObj.GetSaveString()+"&f_cmd="+MULTI01;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParamSheet);
				//sheetObj.LoadSaveData(sXml);
				if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
					ComShowCodeMessage("PRI00101");
				}
				searchAfterSave(formObj, sheetObj, sXml);
				ComOpenWait(false);
	     		break;
			case COMMAND01:	//Amend
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
				if(chkArr.length > 0){
					amendRow(sheetObj, document.form, "M");
				} else {
					sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "chk", 1);
					amendRow(sheetObj, document.form, "M");
				}
				break;
			case COMMAND02: // Amend Cancel
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
				if(chkArr.length > 0){
					if(chkArr.length > 1){
						ComShowCodeMessage("PRI00310");
					}else{
						amendCancelRow(sheetObjects[0], document.form, chkArr[0], "M");
					}
				}else{
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
				}
				break;
			case IBDOWNEXCEL:
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:' ',SheetDesign:1,Merge:1,KeyFieldMark:0 });
				break;
			case IBLOADEXCEL:      //upload excel
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
				var formObj=document.form;
		    	var propNO=formObj.prop_no.value;
		    	var amdtSeq=formObj.amdt_seq.value;
		    	var svcScpCd=formObj.svc_scp_cd.value;
		    	var orgDestTpCd=getOrgDestTpCd();
		    	var effDt=formObj.eff_dt.value;
				var sUrl="/opuscntr/ESM_PRI_0024.do?prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd+"&org_dest_tp_cd="+orgDestTpCd+"&eff_dt="+effDt;
				ComOpenPopup(sUrl, 1250, 450, "", "none", false);
				break;
	    }
	}
	
	var isAllReadyUse = false;
	
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
	 * @version 2009.05.18
	 */
  	function sheet1_OnSearchEnd(sheetObj, code, errMsg)  {

  		 if(isAllReadyUse){
    		 if(selctRowCount != 0){
        		 sheetObj.SetSelectRow(selctRowCount,0);
            	 selctRowCount= 0;
        	 }
    		 return;
    	 }
    	 if(sheetObj.RowCount() > 0 && sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
  			setSheetDisplay(sheetObj);
  			isAllReadyUse = true;
  			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
  		 }
    	 if(sheetObj.RowCount() > 0 && document.form.f_cmd.value == SEARCH03){
        	 sheetObj.CheckAll("chk", 0, 0);
    	 }
 	}
  	
  	
  	/**
     * retrive data after saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {Object} Form Object
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} result after save
     * @return void
     * @author 
     * @version 2014.12.26
     */
  	function searchAfterSave(formObj, sheetObj, sXml) {
  		if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
				var formObj=document.form;
				if(formObj.f_cmd.value == MULTI03 || formObj.f_cmd.value == MULTI04 || formObj.f_cmd.value == MULTI07 || formObj.f_cmd.value == MULTI08) {
					
	
					parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);
					if(formObj.f_cmd.value == MULTI03) {
						ComShowCodeMessage("PRI00108");
					} else if(formObj.f_cmd.value == MULTI04) {
						ComShowCodeMessage("PRI00109");
					}
	
					if (sheetObj.GetEtcData("rValue") != undefined && sheetObj.GetEtcData("rValue") > 0){
						setProposalStatusSummary(formObj);
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else{
					//setSheetDisplay(sheetObj);
					setProposalStatusSummary(formObj);
					if(formObj.f_cmd.value == MULTI02) { // After copying guideline, Retrieve again
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
						ComShowCodeMessage('PRI01017');
					}
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02); //Retrieving Font Style
				}
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
     * @version 2009.05.18
     */
    function pageOnLoadFinish() {
    	initControl();
    	buttonControl();
    	parent.loadTabPage();
    }
    /**
     * Accepting checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
  	function acceptRows(sheetObj,formObj) {
      	var propStsCd=formObj.prop_sts_cd.value;
  		var effDt=formObj.eff_dt.value;
  		var amdtSeq=formObj.amdt_seq.value;
  		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
  		if(chkArr.length == 0) {
  			// selected row is previous one
  			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
  			chkArr[0]=sheetObj.GetSelectRow();
  		}
  		for(var i=0; i<chkArr.length; i++) { // showing error message in case of already accepted item
  			// It's previous amendment.
  			if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				comChangeValue(sheetObj, "chk", "0", "chk", "1");
  				return false;
  			}
  			if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") == "A") {
  				ComShowCodeMessage("PRI01037");
  				comChangeValue(sheetObj, "chk", "0", "chk", "1");
  				return false;
  			}
  		}
  		var trgtArr=ComPriSheetFilterRows(sheetObj, "chk|n1st_cmnc_amdt_seq", "1|"+amdtSeq);
   		if(trgtArr.length == 0) {
   			ComShowCodeMessage("PRI00301");
  			return false;
   		}
   		for(var i=0; i<trgtArr.length; i++) {
   			var prcProgStsCd=sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd");
   			//alert(trgtArr[i]+"|"+prcProgStsCd);
   			if(prcProgStsCd == "A") { // Except Accept
   				continue;
   			}
   			if(propStsCd == "Q") { //Input proposal amount into final in case of request
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt"),0);//Approving Sales.Rep's amount
   			}
   			if(propStsCd == "R") { //in case of return status, Input C/Offer amount into final
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt"),0);//Approving Counter Offer's amount
   			}
   			sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","A");//Modifying Accept
   			/////////// Input Per_type
   			if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
   				sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}
   		}
   		/*var sParam=FormQueryString(formObj);
   		sheetObj.DoSave(sUrl, FormQueryString(formObj), -1, false);*/
   		var sParam=FormQueryString(formObj);
		var sParamSheet=sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow=sheetObj.GetTopRow();
			var lastRow=sheetObj.LastRow();
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}
		sParam=sParam + "&" + sParamSheet;
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParam);
		//sheetObj.LoadSaveData(sXml);
		searchAfterSave(formObj, sheetObj, sXml);
   		comChangeValue(sheetObj, "chk", "0", "chk", "1");
   		return true;
  	}
    /**
     * Accepting all accept targest <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptAllRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
   	function acceptAllRows(sheetObj, formObj) {
   		var sParam=FormQueryString(formObj);
   		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParam);
   		//sheetObj.LoadSaveData(sXml);
		ComShowCodeMessage("PRI00108");
   		searchAfterSave(formObj, sheetObj, sXml);
   		return true;
   	}

    /**
     * Canceling acceptance of checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
   	function acceptCancelRows(sheetObj, formObj) {
      	var propStsCd=formObj.prop_sts_cd.value;
   		var effDt=formObj.eff_dt.value;
   		var amdtSeq=formObj.amdt_seq.value;
   		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
   		if(chkArr.length == 0) {
   			// selected row is previous one
   			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
   			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
   			chkArr[0]=sheetObj.GetSelectRow();
   		}
   		for(var i=0; i<chkArr.length; i++) { //error message in case of not accepted status
   			// At previous amendment, this row got approved
   			if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
   				sheetObj.SetCellValue(chkArr[i], "chk","0",0);
   				ComShowCodeMessage("PRI00313");
   				return false;
   			}
   			// not accepted
   			if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "A") {
				sheetObj.SetCellValue(chkArr[i], "chk","0",0);
				ComShowCodeMessage("PRI01038");
				return false;
			}
   		}
   		var trgtArr=ComPriSheetFilterRows(sheetObj, "chk|n1st_cmnc_amdt_seq", "1|"+amdtSeq+"|"+effDt);
		if(trgtArr.length == 0) {
			ComShowCodeMessage("PRI00301");
			return false;
		}
    	for(var i=0; i<trgtArr.length; i++) {
    		var prcProgStsCd=sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd");
    		var propFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt");
    		var cofferFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt");
    		var fnlFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "fnl_frt_rt_amt");
   			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Resetting final and rollbacking to initial status in case of no Counter Offer amount
   				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","I");
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
   			} else { //Resetting final and rollbacking to Return status in case of existing Counter Offer amount
   				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","R");
  				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
   			}
   			/////////// Input Per_type
   			if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
   				sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}
   		}
    	/*var sParam=FormQueryString(formObj);
		sheetObj.DoSave(sUrl, sParam, -1, false);*/
		var sParam=FormQueryString(formObj);
		var sParamSheet=sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow=sheetObj.GetTopRow();
			var lastRow=sheetObj.LastRow();
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}
		sParam=sParam + "&" + sParamSheet;
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParam);
		//sheetObj.LoadSaveData(sXml);
		searchAfterSave(formObj, sheetObj, sXml);
		comChangeValue(sheetObj, "chk", "0", "chk", "1");
   		return true;
   	}
   	/**
     * Cancelling acceptance with accepted all rows<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelAllRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
    	function acceptCancelAllRows(sheetObj, formObj){
    		var sParam=FormQueryString(formObj);
    		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParam);
    		//sheetObj.LoadSaveData(sXml);
    		ComShowCodeMessage("PRI00109");
    		searchAfterSave(formObj, sheetObj, sXml);
	   		return true;
    	}
//   	function acceptCancelAllRows(sheetObj, formObj){
//   		var amdtSeq = formObj.amdt_seq.value;
//   		var effDt = formObj.eff_dt.value;
//
//   		// Unchecking checked Row
//   		comChangeValue(sheetObj, "chk", "0");
//
//   		// Searcing row index to cancel Accept
//   		var trgtArr = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);
//
//   		if(trgtArr.length == 0) {
//   			ComShowCodeMessage("PRI00330"); //no row with current Amdt seq
//  			return false;
//   		}
//
//   		for(var i=trgtArr.length-1; i>=0; i--) {
//  			if(sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") != "A") { //except Accept
//  				trgtArr.splice(i, 1);
//  			}
//  		}
//
//  		if(trgtArr.length == 0) { //no accepted data
//  			ComShowCodeMessage("PRI00330");
// 			return false;
//  		}
//
//   		for(var i=0; i<trgtArr.length; i++) {
//   			var prcProgStsCd = sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd");
//   			var propFrtRtAmt = sheetObj.CellValue(trgtArr[i], "prop_frt_rt_amt");
//   			var cofferFrtRtAmt = sheetObj.CellValue(trgtArr[i], "coffr_frt_rt_amt");
//   			var fnlFrtRtAmt = sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt");
//
//   			//alert(trgtArr[i]+"|"+prcProgStsCd);
//   			if(prcProgStsCd != "A") { //for only accept
//   				continue;
//   			}
//
//   			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Resetting final and rollbacking to initial status in case of no Counter Offer amount
//   				sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "I";
//   				sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt") = "";
//   			} else { //Resetting final and rollbacking to Return status in case of existing Counter Offer amount
//   				sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "R";
//  				sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt") = "";
//   			}
//   		}
//
//   		/*var sParam = FormQueryString(formObj);
//   		sheetObj.DoSave(sUrl, sParam, -1, false);*/
//
//   		var sParam = FormQueryString(formObj);
//		var sParamSheet = sheetObj.GetSaveString(false);
//		if(sParamSheet == "") {
//			var topRow = sheetObj.TopRow;
//			var lastRow = sheetObj.LastRow;
//
//			for(var i=topRow; i<=lastRow; i++) {
//				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
//				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
//			}
//			return false;
//		}
//
//		sParam = sParam + "&" + sParamSheet;
//		var sXml = sheetObj.GetSaveData("ESM_PRI_0003_04GS.do", sParam);
//		sheetObj.LoadSaveXml(sXml);
//  		return true;
//   	}
 	
    	
   	/**
     * Amending or Deleting selected row (First Processing) <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], "M")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @return 
     * @author NYK
     * @version 2016.02.16
     */
	function amendRow(sheetObj, formObj, sAction){
		//[Strike Font s]-----------------------------------------
		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
		//[Strike Font e]-----------------------------------------
		var cntHeaderRows = sheetObj.HeaderRows();
		if(sAction == "M"){
			var sRow = sheetObj.GetSelectRow();
			var amdt_seq = formObj.amdt_seq.value;
			if(sheetObj.GetCellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq){
				ComShowCodeMessage("PRI01011");
				return;
			}
		}
		var sheetOrgData = sheetObj.ExportData({Type:"json"}).data;
        var sheetChgData = new Array();
        selctRowCount = 0;
        for(var j=0, maxlen = sheetOrgData.length; j < maxlen; j++){
        	var sheetDataObj = new Object();
            if(sheetOrgData[j].chk == 1){
                var sheetDataArr = amendRowDetail(sheetObj,formObj, sheetOrgData[j], sAction, "rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|" +
                        "dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|note_dp_seq");
                sheetChgData.push(sheetDataArr[0]);
                sheetChgData.push(sheetDataArr[1]); 
            }else{
            	sheetChgData.push(sheetOrgData[j]);  
            }
        }
        //[Strike Font s]-----------------------------------------
        if(sAction == "M" || sAction == "D"){
        	selctRowCount = getLastIndexChk(sheetObj, chkArr)+chkArr.length;
        }
        //[Strike Font e]-----------------------------------------
        isAllReadyUse = false;
        var sheetLoadData = new Object();
        sheetLoadData["data"] = sheetChgData;
        sheetObj.LoadSearchData(sheetLoadData);
	}
	
	/**
	 * get Max Row Index in the check's rows
	 */
	function getLastIndexChk(sheetObj, chkArr){
		var result = 0;
		if(chkArr != null && chkArr.length > 0){
			var maxVal = sheetObj.HeaderRows();
			for(var i = 0; i < chkArr.length; i++){
				var tmpVal = parseInt(chkArr[i]);
				if(tmpVal > maxVal){
					maxVal = tmpVal;
				}
			}
			result = maxVal;
		}
		
		return result;
	}
        
   	/**
     * Amending selected row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRowDetail(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
	function amendRowDetail(sheetObj, formObj, sRow, sAction) {
		var prop_no=formObj.prop_no.value;
		var amdt_seq=formObj.amdt_seq.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_exp_dt=formObj.pre_exp_dt.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		var sColNames="rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|" +
		"dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|note_dp_seq";
		var newObj = new Object();
		var preObj = new Object();
		jQuery.extend(newObj, sRow);
		jQuery.extend(preObj, sRow);
		//[Strike Font]-----------------------------------------
        newObj["tmp_type"] = "C";
        //[Strike Font]-----------------------------------------
		newObj["coffr_frt_rt_amt"] = "";
        newObj["fnl_frt_rt_amt"] = "";
        newObj["eff_dt"] = eff_dt;
        newObj["n1st_cmnc_amdt_seq"] = amdt_seq;
        newObj["prc_prog_sts_cd"] = "I";
        newObj["ibflag"] = "U";  
	        
        if(sAction == "M") { //Amend
            newObj["src_info_cd"] = "AM";
            newObj["prop_frt_rt_amt"] = 0;
            newObj["add_chg_note_ctnt#BackColor"] = "#FFFFFF";
            
            preObj["chk#Edit"] = "0";
            var editCellInfo = sColNames.split("|");
            for(var ii=0; ii<editCellInfo.length; ii++){
                newObj[editCellInfo[ii] + "#Edit"] = "1";
            }
        } else if(sAction == "D") { //Delete Amend
            newObj["src_info_cd"] = "AD";
            newObj["rat_ut_cd"] = newObj["per_type"];
            newObj["chk#Edit"] = "1";
        }
        
        newObj["FontColor"] = "#FF0000";  //빨간색 설정
        for(ii = 0; ii < sheetObj.LastCol(); ii++){
            preObj[sheet1.ColSaveName(ii) + "#FontStrike"] = "1";
        }
        preObj["amdt_seq"] = pre_amdt_seq;
        if(dur_dup_flg == "Y") {
            preObj["exp_dt"] = pre_exp_dt;            
        }
        preObj["ibflag"] = "R";
        
        preObj["chk"] = "0";
        preObj["chk#Edit"] = "0";
        var editCellInfo = sColNames.split("|");
        for(var ii=0; ii<editCellInfo.length; ii++){
            preObj[editCellInfo[ii] + "#Edit"] = "0";
        } 
        //[Strike Font]-----------------------------------------
        preObj["tmp_type"] = "S";
        //[Strike Font]-----------------------------------------
        
        return [preObj, newObj];
	}
	
	
	
	/**
     * Canceling amendment of selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
	function amendCancelRow(sheetObj, formObj, sRow, sAction) {
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var amdt_seq=formObj.amdt_seq.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		sheetObj.SetCellValue(sRow, "chk",0);
		// handling in case of  n1st_cmnc_amdt_seq == amdt_seq in A/M/D
		if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") != amdt_seq
				|| (sheetObj.GetCellValue(sRow,"src_info_cd") != "AD"
					&& sheetObj.GetCellValue(sRow,"src_info_cd") != "AM")
					||	sheetObj.GetCellValue(sRow,"prc_prog_sts_cd")!= "I") {
			ComShowCodeMessage("PRI00313");
		 	return false;
		}
		// When DELETE AMENDMENT is Canceled, Check the GROUP LOCATION is valid.
	if(sheetObj.GetCellValue(sRow, "src_info_cd") == "AD" && !checkGroupLocationExist(sheetObj, formObj, sRow)) {
			ComShowCodeMessage("PRI01127", "[LOC Group]");
			return false;
		}
		var amdRow=sRow;
		var preRow=sRow-1;
		// Modifying Font 
		sheetObj.SetCellFont("FontStrike", preRow, 1, preRow, sheetObj.LastCol(), false);
		//[Strike Font]-----------------------------------------
		sheetObj.SetCellValue(preRow, "tmp_type", "", 0);
		//[Strike Font]-----------------------------------------
		sheetObj.SetCellFont("FontItalic", preRow, 1, preRow, sheetObj.LastCol(),0);
		// Modify Amend Sequence
		sheetObj.SetCellValue(preRow, "amdt_seq",sheetObj.GetCellValue(amdRow, "amdt_seq"),0);
		sheetObj.SetCellEditable(preRow, "chk",1);
		if(dur_dup_flg == "Y") {
        	sheetObj.SetCellValue(preRow, "exp_dt",exp_dt,0);
        }
		// When PER_TYPE code is deleted, Input the per_type.
		if (sheetObj.GetCellValue(preRow, "rat_ut_cd") == ""){
			sheetObj.SetCellValue(preRow, "rat_ut_cd",sheetObj.GetCellValue(preRow, "per_type") ,0);
		}
		if(sheetObj.CellSearchValue(amdRow, "amdt_seq") != unescape("%00")) {
			sheetObj.SetRowStatus(preRow,"U");
		}
		sheetObj.RowDelete(amdRow, false);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(preRow, "n1st_cmnc_amdt_seq"), amdt_seq);
		return true;
	}
    /**
     * Function to check whether Group Location is valid <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkGroupLocationExist(sheetObj, formObj, sRow)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param {int} sRow Mandatory ,Cell's Row Index
     * @return void
     * @author 
     * @version 2009.05.18
     */
    function checkGroupLocationExist(sheetObj, formObj, sRow) {
    	if(sheetObj.GetCellValue(sRow, "bse_port_tp_cd") == "G") {
	    	formObj.f_cmd.value=SEARCH17;
	    	formObj.cd.value=sheetObj.GetCellValue(sRow, "bse_port_def_cd");
			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if(arrData[1] == "") {
				return false;
			}
    	}
    	if(sheetObj.GetCellValue(sRow, "via_port_tp_cd") == "G") {
	    	formObj.f_cmd.value=SEARCH17;
	    	formObj.cd.value=sheetObj.GetCellValue(sRow, "via_port_def_cd");
			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if(arrData[1] == "") {
				return false;
			}
    	}
    	return true;
    }
	/**
     * sheet's dir_call_flg editing management function<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setDirectCall(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function setDirectCall(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			sheetObj.SetCellEditable(Row,"dir_call_flg",1);//Direct Call Use Available
		} else {
			sheetObj.SetCellValue(Row,"dir_call_flg","",0);
			sheetObj.SetCellEditable(Row,"dir_call_flg",0);//Direct Call not use
		}
	}
    /**
     * sheet's all dir_call_flg editing management function<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setAllDirectCall(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function setAllDirectCall(sheetObj) {
 		var rCnt=sheetObj.LastRow();
		for (var i=1; i<=rCnt; i++) {
			if (sheetObj.GetCellValue(i, "via_port_def_cd") != "") {
				sheetObj.SetCellEditable(i, "dir_call_flg",0);
			} else if (sheetObj.GetCellValue(i, "dir_call_flg") == "1") {
				sheetObj.SetCellEditable(i, "via_port_def_cd",0);
			}
		}
	}
	/**
     * Function to check whether rout_pnt_loc_tp_cd is valid<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkRoutePointLocation(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if (sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "bse_port_def_cd") == Value) {
			ComShowCodeMessage('PRI01078');
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
			sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			return false;
		}
		return true;
	}
	/**
     * Function to check whether rcv_de_term_cd is valid<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setTermCode(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function setTermCode(sheetObj, Row, Value) {
		if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(Row, "bse_port_def_cd")) {
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
		}
	}
	/**
     * Function to check whether bse_port_def_cd is valid <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function checkBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if (sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     * checking function of via_port_def_cd's validation <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setVia(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function setVia(sheetObj, Row, Value) {
		if (Value == "1") {
			sheetObj.SetCellValue(Row, "via_port_def_cd","", 0);
			sheetObj.SetCellEditable(Row, "via_port_def_cd", 0);
			sheetObj.SetCellBackColor(Row, "via_port_def_cd", "#EFF0F3");
		} else {
			sheetObj.SetCellEditable(Row, "via_port_def_cd", 1);
			sheetObj.SetCellBackColor(Row, "via_port_def_cd", "FFFFFF")
		}
	}

	/**
     * Function to check whether prc_cgo_tp_cd is valid  <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.05.18
     */
    function checkPerType(sheetObj, Row, Value) {
    	var validPerClass="A,F,O,Q,S,P";
    	if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
    		ComShowCodeMessage("PRI08003");
     		sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
    	}
    }
	/**
     * Function to check whether  rat_ut_cd is valid  <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
    function checkCargoType(sheetObj, Row, Value) {
		var validPerClass="A,F,O,Q,S,P";
		var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
        if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
             ComShowCodeMessage("PRI08003");
             sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
        }
 	}
	/**
     * cmdt_cd's validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function checkCommodity(sheetObj, Row, Value) {
		var formObj=document.form;
		if(ComIsNull(Value)) {
			return;
		}
		if(Value.length == 5) { //Group Commodity
			var propNo=sheetObj.GetCellValue(Row, "prop_no");
			var amdtSeq=sheetObj.GetCellValue(Row, "amdt_seq");
			var svcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
			formObj.f_cmd.value=SEARCH10;
			formObj.cd.value=Value;
			sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if(arrData[1] == "") {
				sheetObj.SetCellValue(Row,"prc_cmdt_def_cd", "", 0);
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "", 0);
				sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
			} else {
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "G", 0);
			}
		} else if(Value.length == 6) {
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_PRI_4027GS.do", FormQueryString(formObj)+"&cmdt_cd="+Value);
			var arrDesc=ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
			if (arrDesc == null || arrDesc.length < 1) {
				sheetObj.SetCellValue(Row,"prc_cmdt_def_cd", "", 0);
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "", 0);
				sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
			} else {
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "C", 0);
			}
		} else {
			sheetObj.SetCellValue(Row,"prc_cmdt_def_cd", "", 0);
			sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
		}
	}
	/**
     * Check whether guideline copied. <br>
     * <br><b>Example :</b>
     * <pre>
     *    confirmGuidelineCopy(sheetObjects[0], formObj, orgDestTpCd)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {object} formObj Mandatory Form Object
     * @param {string} orgDestTpCd Mandatory origin, destination separate code
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function confirmGuidelineCopy(sheetObj, formObj, orgDestTpCd) {
		if(ComShowCodeConfirm('PRI01006')) {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
		}
		if(orgDestTpCd == "O") {
			CONFIRM_ORG_GLINE=true;
		} else if(orgDestTpCd == "D") {
			CONFIRM_DEST_GLINE=true;
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
     * @version 2009.05.18
     */
	function setSheetDisplay(sheetObj) {
//		var formObj=document.form;
//		var amdtSeq=formObj.amdt_seq.value;
//		var propStsCd=formObj.prop_sts_cd.value;
//		var aproUsrFlg=form.apro_usr_flg.value;
//		var lgcyIfFlg=form.lgcy_if_flg.value;
//		var sColNames="rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd" +
//						"|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt";
//		var rCnt=sheetObj.RowCount();
//		setSheetGetCellEditable(amdtSeq);
//		if(amdtSeq == 0) {
//			for(var i=1; i<=rCnt; i++) {
//				if(propStsCd == "I") { //Initial
//					if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "I") {
//						sheetObj.SetRowEditable(i,0);
// 						sheetObj.SetCellBackColor(i,"add_chg_note_ctnt",sheetObj.GetEditableColorDiff(1));
//					}else{
//						if(sheetObj.GetCellValue(i, "via_port_def_cd") != "") {
//							sheetObj.SetCellEditable(i, "dir_call_flg",0);
//						} else if(sheetObj.GetCellValue(i, "dir_call_flg") == "1") {
//							sheetObj.SetCellEditable(i, "via_port_def_cd",0);
//						}
//						sheetObj.SetCellBackColor(i, "add_chg_note_ctnt","#FFFFFF");
//					}
//				} else if(propStsCd == "Q") { //Request
//					if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //Possible to input c/offer amount in case of approver
//						sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",1);
//					} else {
//						sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",0);
//					}
//				}
//			}
//			return;
//		}
//		for(var i=1 ; i<=rCnt; i++) {
//			if(sheetObj.GetCellValue(i ,"amdt_seq") != amdtSeq) { // Strikeout, not editable
//				sheetObj.SetCellFont("FontStrike", i, "chk", i, "add_chg_note_ctnt", true);
//				//[Strike Font]-----------------------------------------
//				sheetObj.SetCellValue(i, "tmp_type", "S", 0);
//				var sCmd = formObj.f_cmd.value;
//				if(sCmd == SEARCH01){
//					sheetObj.SetCellValue(i, "ibflag", "", 0);
//				}
//				//[Strike Font]-----------------------------------------
//				sheetObj.SetCellEditable(i, "chk",0);
//				continue;
//			}
//			if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq
//					&& sheetObj.GetCellValue(i, "src_info_cd") != "AD"
//						&& sheetObj.GetCellValue(i, "prc_prog_sts_cd")!= "A"
//					&& propStsCd == "I" ) { //Only Amend Data is GetEditable(). But Check Column GetEnable()
//				setGetRowEditable(sheetObj, i, true, sColNames);
//			}else if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") != amdtSeq){
//				continue;
//			}
//			if(lgcyIfFlg != "Y") {
//				sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
//				//[Strike Font]-----------------------------------------
//				sheetObj.SetCellValue(i, "tmp_type", "C", 0);
//				var sCmd = formObj.f_cmd.value;
//				if(sCmd == SEARCH01){
//					sheetObj.SetCellValue(i, "ibflag", "", 0);
//				}
//				//[Strike Font]-----------------------------------------
//			}
//			if (sheetObj.GetCellValue(i, "src_info_cd") == "AD"){
//				continue;
//			}
//			if(propStsCd == "I") { //Initial
//				if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "I") {
//					sheetObj.SetRowEditable(i,0);
//					sheetObj.SetCellBackColor(i,"add_chg_note_ctnt",sheetObj.GetEditableColorDiff(1));
//				}else{
//					setDirectCall(sheetObj, i, sheetObj.GetCellValue(i, "via_port_def_cd"));
//					sheetObj.SetCellBackColor(i, "add_chg_note_ctnt","#FFFFFF");
//				}
//			} else if(propStsCd == "Q") { //Request
//				if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "A"
//					&& aproUsrFlg == "true"
//						&& sheetObj.GetCellValue(i, "src_info_cd") != "AD" ) { //Possible to input c/offer amount in case of approver
//					sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",1);
//				} else {
//					sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",0);
//				}
//			}
//		}
		
		//extract json object from sheet
		var sheetOrgData = sheetObj.ExportData({Type:"json"}).data;
		if(sheetOrgData == undefined || sheetOrgData == null || sheetOrgData.length == 0) return;
				
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var effDt=formObj.eff_dt.value;
		var propStsCd=formObj.prop_sts_cd.value;
		var aproUsrFlg=form.apro_usr_flg.value;
		var lgcyIfFlg=form.lgcy_if_flg.value;
		var sAllColNames = "chk|seq|rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|coffr_frt_rt_amt|fnl_frt_rt_amt|eff_dt|exp_dt|src_info_cd|prc_prog_sts_cd|gri_appl_tp_cd|gri_appl_amt|note_dp_seq|add_chg_note_ctnt";
		var sAllColArray = sAllColNames.split("|");
		var sColNames="rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd" +
				"|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|note_dp_seq";
		var sColArray = sColNames.split("|");
		
		var sColTargetColor = "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd" +
				"|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|prop_frt_rt_amt|note_dp_seq";
		var sColTargetColorArray = sColTargetColor.split("|");


		var resultSheetObj = new Array();

		var sIdx = sheetObj.HeaderRows();
		var eIdx = sheetObj.LastRow();
		var cLastIdx = sheetObj.LastCol();
		//var disableColorTxt = sheetObj.GetEditableColorDiff(1);
		var enableColorTxt = "#FFFFFF";
		var redColorTxt = "#FF0000";
		var unEditColorText = "#EFF0F3";
		
		//[amdt_seq = 0 start]--------------------
		if(amdtSeq == 0) {
			for(var i=sIdx; i<=eIdx; i++) {
				var jsonIdx = i - sIdx;
				
				//temparay row object
				var tmpRowSheetObj = new Object();
				tmpRowSheetObj = sheetOrgData[jsonIdx];
				
				var r_prc_prog_sts_cd = tmpRowSheetObj["prc_prog_sts_cd"];
				if(propStsCd == "I") { //Initial
					
					makeJsonRowEdit(tmpRowSheetObj, sColArray, "1");
					makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, enableColorTxt);
					tmpRowSheetObj["rout_pnt_loc_def_nm#BackColor"] = unEditColorText;
					
					if(r_prc_prog_sts_cd != "I") {
						makeJsonRowEdit(tmpRowSheetObj, sAllColArray, "0");
						makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, unEditColorText);
						tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = unEditColorText;
					}else{
						if(tmpRowSheetObj["via_port_def_cd"] != "") {
							tmpRowSheetObj["dir_call_flg#Edit"] = "0";
						} else if(tmpRowSheetObj["dir_call_flg"] == "1") {
							tmpRowSheetObj["via_port_def_cd#Edit"] = "0";
						}
						tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = enableColorTxt;
					}
				} else if(propStsCd == "Q") { //Request
					makeJsonRowEdit(tmpRowSheetObj, sColArray, "0");
					makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, unEditColorText);
					tmpRowSheetObj["rout_pnt_loc_def_nm#BackColor"] = unEditColorText;
					
					if(r_prc_prog_sts_cd != "A" && aproUsrFlg == "true") { //Possible to input C/Offer in case of only approver
						tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "1";
					} else {
						tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "0";
					}		
				} else {
					makeJsonRowEdit(tmpRowSheetObj, sColArray, "0");
					makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, unEditColorText);
					tmpRowSheetObj["rout_pnt_loc_def_nm#BackColor"] = unEditColorText;
				}
				resultSheetObj.push(tmpRowSheetObj);
			}
			
			//bind to the sheet with object
			var sheetLoadData = new Object();
	        sheetLoadData["data"] = resultSheetObj;
	        sheetObj.LoadSearchData(sheetLoadData);
			
			return;
		}
		//[amdt_seq = 0 end]--------------------
		
		//[amdt_seq > 0 start]--------------------

		for(var i=sIdx; i<=eIdx; i++) {
			var jsonIdx = i - sIdx;
			
			//temparay row object
			var tmpRowSheetObj = new Object();
			tmpRowSheetObj = sheetOrgData[jsonIdx];
			
			makeJsonRowEdit(tmpRowSheetObj, sColArray, "0");
			makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, unEditColorText);
			tmpRowSheetObj["rout_pnt_loc_def_nm#BackColor"] = unEditColorText;
			
			//compare variable
			var t_amdt_seq = tmpRowSheetObj["amdt_seq"];
			var t_src_info_cd = tmpRowSheetObj["src_info_cd"];
			var t_prc_prog_sts_cd = tmpRowSheetObj["prc_prog_sts_cd"];
			var t_n1st_cmnc_amdt_seq = tmpRowSheetObj["n1st_cmnc_amdt_seq"];
			
			if(t_amdt_seq != amdtSeq) { //Strike previous sequence and not editable
				makeJsonRowFontStrike(tmpRowSheetObj,sAllColArray,"1");
				
				//[Strike Font]-----------------------------------------
				tmpRowSheetObj["tmp_type"] = "S";
				var sCmd = formObj.f_cmd.value;
				if(sCmd == SEARCH01){
					tmpRowSheetObj["ibflag"] = "";
				}
				//[Strike Font]-----------------------------------------
				tmpRowSheetObj["chk#Edit"] = "0";
				resultSheetObj.push(tmpRowSheetObj);
				continue;
			}
			if(t_n1st_cmnc_amdt_seq == amdtSeq	&& t_src_info_cd != "AD"
						                        && t_prc_prog_sts_cd != "A"
					                            && propStsCd == "I") { //not editable for not amended row
				makeJsonRowEdit(tmpRowSheetObj, sColArray, "1");
				makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, enableColorTxt);
				tmpRowSheetObj["rout_pnt_loc_def_nm#BackColor"] = unEditColorText;

			} else if (t_n1st_cmnc_amdt_seq != amdtSeq){
				resultSheetObj.push(tmpRowSheetObj);
				continue;
			}
			if(lgcyIfFlg != "Y") {
				tmpRowSheetObj["FontColor"] = redColorTxt;
				//[Strike Font]-----------------------------------------
				tmpRowSheetObj["tmp_type"] = "C";
				tmpRowSheetObj["chk"] = "0";
				var sCmd = formObj.f_cmd.value;
				if(sCmd == SEARCH01){
					tmpRowSheetObj["ibflag"] = "";
				}
				//[Strike Font]-----------------------------------------
			}

			if(t_src_info_cd == "AD") {
				resultSheetObj.push(tmpRowSheetObj);
				continue;
			}
			if(propStsCd == "I") { //Initial
				if(t_prc_prog_sts_cd != "I") {
					makeJsonRowEdit(tmpRowSheetObj, sAllColArray, "0");
					makeJsonColsBackColor(tmpRowSheetObj, sColTargetColorArray, unEditColorText);
					tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = unEditColorText;
				}else{
					if(ComIsNull(tmpRowSheetObj["via_port_def_cd"])) {
						tmpRowSheetObj["dir_call_flg#Edit"] = "1";//Direct Call Use Available
					} else {
						tmpRowSheetObj["dir_call_flg"] = "0";
						tmpRowSheetObj["dir_call_flg#Edit"] = "0";//Direct Call not use
					}
					tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = enableColorTxt;
				}
			} else if(propStsCd == "Q") { //Request
				if(t_prc_prog_sts_cd != "A"	&& aproUsrFlg == "true"
						                    && t_src_info_cd != "AD" ) { //Possible to input c/offer amount in case of approver
					tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "1";
				} else {
					tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "0";
				}	
			} 
			
			resultSheetObj.push(tmpRowSheetObj);
		}
		
		//bind to the sheet with object
		var sheetLoadData = new Object();
        sheetLoadData["data"] = resultSheetObj;
        sheetObj.LoadSearchData(sheetLoadData);
        
        //[amdt_seq > 0 end]--------------------
		
		
	}
	
	/**
	 * set Row Editable with json
	 * @param {Object} Row Data Info's json
	 * @param {Array} Colums Info Array
	 * @param {String} editable(1) / uneditable(0)
	 */
	function makeJsonRowEdit(rowObj, paramArray, isEditable){
		if(paramArray != undefined && paramArray != null && paramArray.length > 0){
			for(var i = 0; i < paramArray.length; i++){
				rowObj[paramArray[i] + "#Edit"] = isEditable;
	        }
		}
	}
	
	/**
	 * set Cell Font Strike with json
	 * @param {Object} Row Data Info's json
	 * @param {Array} Colums Info Array
	 * @param {String} is FontStrike(1) / is not FontStrike(0)
	 */
	function makeJsonRowFontStrike(rowObj, paramArray, isStrike){
		if(paramArray != undefined && paramArray != null && paramArray.length > 0){
			for(var i = 0; i < paramArray.length; i++){
				rowObj[paramArray[i] + "#FontStrike"] = isStrike;
	        }
		}
	}
	
	/**
	 * set Color backColor with json
	 * @param {Object} Row Data Info's json
	 * @param {Array} Colums Info Array
	 * @param {String} editable(1) / uneditable(0)
	 */
	function makeJsonColsBackColor(rowObj, paramArray, strColor){
		if(paramArray != undefined && paramArray != null && paramArray.length > 0){
			for(var i = 0; i < paramArray.length; i++){
				rowObj[paramArray[i] + "#BackColor"] = strColor;
	        }
		}
	}
	
	
	/**
     * Setting editable for specific columns<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowEditable(sheetObj, i, false, "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (int) Row Mandatory selected Row Index
     * @param (boolean) isEdit Mandatory editablt
     * @param (String) sColNames Mandatory editable setting column name list
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function setGetRowEditable(sheetObj, Row, isEdit, sColNames) {
		var arrColNames=sColNames.split("|");
		var colCnt=arrColNames.length;
		for(i=0; i<=colCnt; i++) {
			//2015.02.09 rout_pnt_loc_def_nm always not edit
			if( arrColNames[i] == "rout_pnt_loc_def_nm") continue;
			sheetObj.SetCellEditable(Row, arrColNames[i],isEdit);
			var cellColor = "#FFFFFF"; // edit color
			if(!isEdit){ 
				cellColor = "EFF0F3";  // non-edit color
			}
			sheetObj.SetCellBackColor(Row, arrColNames[i], cellColor);
		}
	}
	
	/**
     * Setting note_dp_seq <br>
     * <br><b>Example :</b>
     * <pre>
     *    setNoteDefSeq(sheetObj, formObj)
     *    2016.08.02 (Kate) : Note Seq numbering logic is modified so this function won't be used.
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @return void
     * @author 
     * @version 2016.07.15
     */
 	function setNoteDefSeq(sheetObj, formObj) {
 		var amdtSeq=formObj.amdt_seq.value;
 		var rCnt=sheetObj.LastRow();
 		if(amdtSeq == 0) {
 			var noteDpSeq=1;
 			for(var i=1; i<=rCnt; i++) {
 				if(sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "") {
 					sheetObj.SetCellValue(i, "note_dp_seq","");
 					continue;
 				}
 				if(sheetObj.GetCellValue(i, "ibflag") != "D") {
 					sheetObj.SetCellValue(i, "note_dp_seq",noteDpSeq++);
 				}
 			}
 		} else {
 			var noteDpSeq=parseInt(getNoteDefSeqMax(sheetObj))+1;
 			for(var i=1; i<=rCnt; i++) {
 				if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq) {
 					if((sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "" || sheetObj.GetCellValue(i, "ibflag") == "D")
 							&& sheetObj.GetCellValue(i, "pre_note_dp_seq") == "") {
 						sheetObj.SetCellValue(i, "note_dp_seq","");
 						continue;
 					} 					
 					// When Note Seq is delivered from previous Amend Seq
 					if(sheetObj.GetCellValue(i, "pre_note_dp_seq") != ""){
 						continue;
 					}
 					if(sheetObj.GetCellValue(i, "ibflag") != "D") {
 						sheetObj.SetCellValue(i, "note_dp_seq",noteDpSeq++);
 					}
 				}
 			}
 		}
 	}
    
    /**
     * Calculate Maximum value of previous amendment sequence's max_note_seq column <br>
     * 2016.08.02 (Kate) : Note Seq numbering logic is modified so this function won't be used.
     *
     * @param {object} sheetObj Mandatory, IBSheet Object.
     * @return int Max
     * @author 
     * @version 2009.05.18
     */
    function getNoteDefSeqMax(sheetObj) {
    	var formObj=document.form;
    	var amdtSeq=formObj.amdt_seq.value;
        var max=0;
        for(var i=sheetObj.HeaderRows(); sheetObj.RowCount()>0 && i<=sheetObj.LastRow(); i++) {
        	if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") != amdtSeq && ComParseInt(sheetObj.GetCellValue(i, "note_dp_seq")) > max) {
        		max=sheetObj.GetCellValue(i, "note_dp_seq");
            }
        }
        return max;
    }
    
	/**
     * Getting org_dest_tp_cd's value<br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.05.18
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
    /**
     * Changking org_dest_tp_cd's checked status<br>
     * <br><b>Example :</b>
     * <pre>
     *    returnRadioButton()
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.22
     */
    function returnRadioButton() {
     	var formObj=document.form;
     	if(formObj.org_dest_tp_cd[0].checked) {
 			formObj.org_dest_tp_cd[1].checked=true;
 		} else if(formObj.org_dest_tp_cd[1].checked) {
 			formObj.org_dest_tp_cd[0].checked=true;
 		}
    }
    /**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     *		tabLoadSheet("ACE", "1", "ACE", 0, "I", "20090101", "20091230", "20090601", "true", "true")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sPreAmdtSeq Mandatory pre_amdt_seq 
     * @param {string} sPropStsCd Mandatory pro_sts_cd 
     * @param {string} sEffDt Mandatory eff_dt 
     * @param {string} sExpDt Mandatory exp_dt 
     * @param {string} sPreExpDt Mandatory pre_exp_dt 
     * @param (string) sIsReqUsr Mandatory req_usr_flg
     * @param (string) sIsAproUsr Mandatory apro_usr_flg
     * @param (string) sDurDupFlg Mandatory dur_dup_flg
     * @return (String)
     * @author 
     * @version 2009.05.18
     */
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObj=document.form;
		if (formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd
				|| formObj.pre_amdt_seq.value != sPreAmdtSeq || formObj.prop_sts_cd.value != sPropStsCd || formObj.eff_dt.value != sEffDt
				|| formObj.pre_exp_dt.value != sPreExpDt || formObj.exp_dt.value != sExpDt) {
			formObj.prop_no.value=sPropNo;
			formObj.amdt_seq.value=sAmdtSeq;
			formObj.svc_scp_cd.value=sSvcScpCd;
			formObj.pre_amdt_seq.value=sPreAmdtSeq;
			formObj.prop_sts_cd.value=sPropStsCd;
			formObj.eff_dt.value=sEffDt;
			formObj.exp_dt.value=sExpDt;
			formObj.pre_exp_dt.value=sPreExpDt;
			formObj.req_usr_flg.value=sIsReqUsr;
			formObj.apro_usr_flg.value=sIsAproUsr;
			formObj.dur_dup_flg.value=sDurDupFlg;
			formObj.lgcy_if_flg.value=sLgcyIfFlg;
			CONFIRM_ORG_GLINE=false;
			CONFIRM_DEST_GLINE=false;
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC04); //setting Radio Button Default
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC03); //setting Term
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			buttonControl();
			var rCnt=sheetObjects[0].RowCount();
  			var orgDestTpCd=getOrgDestTpCd();
  			if( ((!CONFIRM_ORG_GLINE && orgDestTpCd == "O") || (!CONFIRM_DEST_GLINE && orgDestTpCd == "D"))	&& rCnt == 0 && sPropStsCd == "I" && (sIsAproUsr || sIsReqUsr) ) {
  				confirmGuidelineCopy(sheetObjects[0], formObj, orgDestTpCd);
  			}
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
     * @version 2009.05.18
     */
 	function tabClearSheet() {
		var formObj=document.form;
		formObj.prop_no.value="";
		formObj.amdt_seq.value="";
		formObj.svc_scp_cd.value="";
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
     * @version 2009.05.18
     */
	function tabEnableSheet(flag) {
		var formObj=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory 
     * @return void
     * @author 
     * @version 2009.05.18
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // retrieving
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
  			case IBSAVE: // Saving
  				var amdtSeq=formObj.amdt_seq.value;
				if(!validateArbNoteSeq(sheetObj, amdtSeq)){
					return false;
				}
				if(!ComShowCodeConfirm('PRI00001')) {
	     			return false;
	     		}
				if(!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
				if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
  				if(amdtSeq == 0) {
  					var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|add_chg_note_ctnt", false);
  					if (rowM >= 0) {
  						ComShowCodeMessage("PRI00303", "Sheet", rowM);
  						return false;
  					}
  				} else {
  					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|add_chg_note_ctnt", amdtSeq);
  					if(dupRow >= 0) {
  						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
  						return false;
  					}
  				}
  				// Checking (MIN)MAX_CGO_WGT
  				var sRowIdx = sheetObj.HeaderRows();
  				var eRowIdx = sheetObj.LastRow();
				for(var i=sRowIdx; i<=eRowIdx; i++) {
					var minCgoWgt = sheetObj.GetCellValue(i, "min_cgo_wgt");
					var maxCgoWgt = sheetObj.GetCellValue(i, "max_cgo_wgt");
					if(sheetObj.GetRowStatus(i) != "D" && minCgoWgt > 999.999) {

						ComShowCodeMessage("PRI00336", 'Weight(Ton<=)', '999.999');
						sheetObj.SelectCell(i, "min_cgo_wgt");
						return false;
					}
					if(sheetObj.GetRowStatus(i) != "D" && maxCgoWgt > 999.999) {

						ComShowCodeMessage("PRI00336", 'Weight(<Ton)', '999.999');
						sheetObj.SelectCell(i, "max_cgo_wgt");
						return false;
					}
				}
				for(var i=1; i<=sheetObj.LastRow(); i++){
					if(sheetObj.GetCellValue(i, "add_chg_tp_cd")=="I" && sheetObj.GetCellValue(i, "rcv_de_term_cd")!="D"){
						sheetObj.SetCellValue(i, "add_chg_tp_cd", "A");
					}
				}
				return true;
				break;
    		case IBINSERT: // Row Add
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) {
					ComShowCodeMessage("PRI01002");
					return false;
				}
    			return true;
    			break;
    		case IBCOPYROW: // Row Copy
    			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) {
					ComShowCodeMessage("PRI01002");
					return false;
				}
    			return true;
    			break;
    		case IBDELETE: // Delete
    			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(!enableFlag) {
    				return false;
    			}
    			return true;
    			break;
    		case IBSEARCH_ASYNC01: //Guideline Copy
    			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if (sheetObj.RowCount()> 0) {
    				ComShowCodeMessage("PRI01005");
    				return false;
    			}
    			return true;
    			break;
    		case MODIFY01:	//Accept
	    		if(!ComShowCodeConfirm('PRI00008')) {
					return false;
				}
	    		if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
    			return true;
    			break;
    		case MODIFY02:	//Accept Cancel
	    		if(!ComShowCodeConfirm('PRI00009')) {
					return false;
				}
	    		if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
    		case MODIFY03: //Accept All
	    		if(!ComShowCodeConfirm('PRI01015')) {
					return false;
				}
	    		if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
    		case MODIFY04: //Cancel
	    		if(!ComShowCodeConfirm('PRI01010')) {
					return false;
				}
	    		if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
    		case MODIFY05: // Radio Button Click Save
    			var amdtSeq=formObj.amdt_seq.value;
				if(!validateArbNoteSeq(sheetObj, amdtSeq)){
					return false;
				}
				if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
				if(amdtSeq == 0) {
					var rowM=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|add_chg_note_ctnt", false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
						return false;
					}
				} else {
					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|add_chg_note_ctnt", amdtSeq);
					if(dupRow >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
						return false;
					}
				}
/*				// Checking Proposal amount
				for(var i=sheetObj.GetTopRow(); i<=sheetObj.LastRow(); i++) {
					if(sheetObj.GetCellValue(i, "prop_frt_rt_amt") == 0) {
						ComShowCodeMessage("PRI08010", i, 'proposal rate');
						return false;
					}
				}
				*/
				return true;
				break;
    		case IBLOADEXCEL:
				if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
		}
		return true;
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
     * @version 2009.05.18
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
    /**
     * Modifying Proposal status<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {object} formObj Mandatory Form Object
     * @return void
     * @author 
     * @version 2009.05.18
     */
    function setProposalStatusSummary(formObj) {
    	var orgDestTpCd=getOrgDestTpCd();
    	if(orgDestTpCd == "O") {
    		parent.comUpdateProposalStatusSummary("51", formObj.svc_scp_cd.value);
		} else if(orgDestTpCd == "D") {
			parent.comUpdateProposalStatusSummary("52", formObj.svc_scp_cd.value);
		}
    }
    /**
     * Calling function after closing excel popup <br>
     * <br><b>Example :</b>
     * <pre>
     *    reloadExcelCopy()
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.18
     */
    function reloadExcelCopy() {
    	var formObj=document.form;
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	buttonControl();
    	setProposalStatusSummary(formObj);
    }
    /**
     * Controlling button's authority<br>
     * controlling buttons <br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.18
     */
  	function buttonControl(){
 		var formObj=document.form;
 		var req_usr_flg=formObj.req_usr_flg.value;
 		var apro_usr_flg=formObj.apro_usr_flg.value;
 		var amdt_seq=formObj.amdt_seq.value;
 		var sts=formObj.prop_sts_cd.value;
 		var rCnt=sheetObjects[0].RowCount();
 		try {
 			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_glinecopy");
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowcopy");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			//
			ComBtnDisable("btn_gricalc");
			ComBtnEnable("btn_downexcel");
			ComBtnDisable("btn_loadexcel");
			if(amdt_seq > 0){
				showButton("btn_amend");
				showButton("btn_amendcancel");
				ComBtnDisable("btn_amendcancel");
				ComBtnDisable("btn_amend");
			} else {
				hiddenButton("btn_amend");
				hiddenButton("btn_amendcancel");
			}
			//alert("apro_usr_flg : "+apro_usr_flg+" | req_usr_flg : "+req_usr_flg);
 			switch (sts) {
 				case 'I':   // Initial
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_save");
						if(rCnt == 0) {
							ComBtnEnable("btn_glinecopy");
						}
						if (formObj.gri_btn.value == "T"){
							ComBtnEnable("btn_gricalc");
						}
						ComBtnEnable("btn_loadexcel");
						ComBtnEnable("btn_rowadd");
						ComBtnEnable("btn_rowcopy");
						ComBtnEnable("btn_delete");
						ComBtnEnable("btn_amend");
						ComBtnEnable("btn_amendcancel");
						if(amdt_seq > 0){
 							showButton("btn_amend");
 							showButton("btn_amendcancel");
 						}
					}
 					break;
 				case 'Q':   // Requested
 					if(apro_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 						ComBtnDisable("btn_amend");
						ComBtnDisable("btn_amendcancel");
 					}
 					break;
 				case 'R':   // Returned
 					if(apro_usr_flg == "true") {
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_cancelall");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					} else if(req_usr_flg == "true") {
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_accept");
					}
 					ComBtnDisable("btn_amend");
 					ComBtnDisable("btn_amendcancel");
 					break;
 				case 'A':   // Approved
 					ComBtnDisable("btn_amend");
					ComBtnDisable("btn_amendcancel");
  				case 'F':   // Filed
 					ComBtnDisable("btn_amend");
					ComBtnDisable("btn_amendcancel");
 				case 'C':   // Canceled
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
      * Setting whether Column of sheet is editable <br>
      * <br><b>Example :</b>
      * <pre>
      * 		setSheetCellEditable(0)
      * </pre>
      * @param {string} amdtSeq Mandatory Amend Seq No.
      * @return void
      * @author 
      * @version 2009.05.18
      */
     function setSheetGetCellEditable(amdtSeq){
    	var cnt=3;
    	var cellEditable=true;
    	var mainStatus=document.form.prop_sts_cd.value;
    	var sheetObj=sheetObjects[0];
    	if (amdtSeq == "0"){
        	var editColor="#FFFFFF";//edit
        	if (mainStatus !="I"){
        		editColor="#EFF0F3";
        		cellEditable=false;
        	}
        	sheetObj.SetColEditable("rout_pnt_loc_def_cd", cellEditable);
        	sheetObj.SetColEditable("rout_pnt_loc_def_nm", false);
        	sheetObj.SetColEditable("prc_trsp_mod_cd", cellEditable);
        	sheetObj.SetColEditable("rcv_de_term_cd", cellEditable);
        	sheetObj.SetColEditable("bse_port_def_cd", cellEditable);
        	sheetObj.SetColEditable("via_port_def_cd", cellEditable);
        	sheetObj.SetColEditable("dir_call_flg", cellEditable);
        	sheetObj.SetColEditable("rat_ut_cd", cellEditable);
        	sheetObj.SetColEditable("prc_cgo_tp_cd", cellEditable);
        	sheetObj.SetColEditable("prc_cmdt_def_cd", cellEditable);
        	sheetObj.SetColEditable("curr_cd", cellEditable);
        	sheetObj.SetColEditable("prop_frt_rt_amt", cellEditable);
    		sheetObj.SetColBackColor("rout_pnt_loc_def_cd",editColor);
    		sheetObj.SetColBackColor("prc_trsp_mod_cd",editColor);
    		sheetObj.SetColBackColor("prc_trsp_mod_cd",editColor);
    		sheetObj.SetColBackColor("rcv_de_term_cd",editColor);
    		sheetObj.SetColBackColor("min_cgo_wgt",editColor);
    		sheetObj.SetColBackColor("max_cgo_wgt",editColor);
    		sheetObj.SetColBackColor("bse_port_def_cd",editColor);
    		sheetObj.SetColBackColor("via_port_def_cd",editColor);
    		sheetObj.SetColBackColor("dir_call_flg",editColor);
    		sheetObj.SetColBackColor("rat_ut_cd",editColor);
    		sheetObj.SetColBackColor("prc_cgo_tp_cd",editColor);
    		sheetObj.SetColBackColor("prc_cmdt_def_cd",editColor);
    		sheetObj.SetColBackColor("curr_cd",editColor);
    		sheetObj.SetColBackColor("prop_frt_rt_amt",editColor);
    	}else{
    		unEditColor="#EFF0F3";
        	sheetObj.SetColEditable("rout_pnt_loc_def_cd", false);
        	sheetObj.SetColEditable("rout_pnt_loc_def_nm", false);
        	sheetObj.SetColEditable("prc_trsp_mod_cd", false);
        	sheetObj.SetColEditable("rcv_de_term_cd", false);
        	sheetObj.SetColEditable("bse_port_def_cd", false);
        	sheetObj.SetColEditable("via_port_def_cd", false);
        	sheetObj.SetColEditable("dir_call_flg", false);
        	sheetObj.SetColEditable("rat_ut_cd", false);
        	sheetObj.SetColEditable("prc_cgo_tp_cd", false);
        	sheetObj.SetColEditable("prc_cmdt_def_cd", false);
        	sheetObj.SetColEditable("curr_cd", false);
        	sheetObj.SetColEditable("prop_frt_rt_amt", false);
    		sheetObj.SetColBackColor("rout_pnt_loc_def_cd",unEditColor);
    		sheetObj.SetColBackColor("prc_trsp_mod_cd",unEditColor);
    		sheetObj.SetColBackColor("prc_trsp_mod_cd",unEditColor);
    		sheetObj.SetColBackColor("rcv_de_term_cd",unEditColor);
    		sheetObj.SetColBackColor("min_cgo_wgt",unEditColor);
    		sheetObj.SetColBackColor("max_cgo_wgt",unEditColor);
    		sheetObj.SetColBackColor("bse_port_def_cd",unEditColor);
    		sheetObj.SetColBackColor("via_port_def_cd",unEditColor);
    		sheetObj.SetColBackColor("dir_call_flg",unEditColor);
    		sheetObj.SetColBackColor("rat_ut_cd",unEditColor);
    		sheetObj.SetColBackColor("prc_cgo_tp_cd",unEditColor);
    		sheetObj.SetColBackColor("prc_cmdt_def_cd",unEditColor);
    		sheetObj.SetColBackColor("curr_cd",unEditColor);
    		sheetObj.SetColBackColor("prop_frt_rt_amt",unEditColor);
    	}
     }
     
     /**
      * validate on saving arbitrary note sequence and content
      * 1. Check case with same note sequence but different note content : Hardstop <br>
      * 2. Check case with different note sequence but same note content : Give warning & option to synchronize sequence <br>
      *
      * @author NYK
      * @version 2016.08.02
      */
    function validateArbNoteSeq(sheetObj, amdtSeq){
    	var rCnt = sheetObj.RowCount();
    	if(sheetObj.GetSaveString() == ""){
    		return false;
    	}
    	// validate on case of (1) empty note seq (2) zero note seq (3) note seq starting with 0
		for(var i=1; i<=rCnt; i++) {
			if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq) {
				if(sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "") {
					if(sheetObj.GetCellValue(i, "note_dp_seq") != ""){
						sheetObj.SetCellValue(i, "note_dp_seq","");
						continue;						
					}
				}else{
					if(sheetObj.GetCellValue(i, "ibflag") != "D") {
						if(sheetObj.GetCellValue(i, "note_dp_seq") == ""){
							sheetObj.SelectCell(i, "note_dp_seq");
							ComShowCodeMessage('PRI01042', "note sequence");
							return false;
						}
						if(sheetObj.GetCellValue(i, "note_dp_seq") == "0"
							|| (sheetObj.GetCellValue(i, "note_dp_seq").length > 1 && sheetObj.GetCellValue(i, "note_dp_seq").substring(0, 1) == "0")){
							sheetObj.SelectCell(i, "note_dp_seq");
							ComShowCodeMessage('PRI01042', "valid number on note sequence");
							return false;
						}
					}
				}
			}
		}
    	if(rCnt == 0 || rCnt == sheetObj.RowCount("D")){
    		return true;
    	}
    	// validate on the case where same note seq but different content is entered
    	var seqDupChk = findArbNoteDupRow(sheetObj, "note_dp_seq", amdtSeq);
    	if(seqDupChk != undefined){
    		var rtnVal = getNoteSeqDuplicated(sheetObj, seqDupChk, amdtSeq);
        	if(typeof rtnVal == "string"){
        		sheetObj.SelectCell(rtnVal, "note_dp_seq", false);
        		ComShowCodeMessage('PRI02023', rtnVal);
        		return false;
        	}
    	}
    	// validate on the case where same content but different note seq is entered
    	var ibFlag = "";
    	// duplicated content check is based on only text, not considering empty space on it
    	for(var i=1; i<=sheetObj.RowCount(); i++){
    		ibFlag = sheetObj.GetCellValue(i, "ibflag");
      		sheetObj.SetCellValue(i, "note_ctnt_text", sheetObj.GetCellValue(i, "add_chg_note_ctnt").replace(/\s/gi, ''));
      		sheetObj.SetCellValue(i, "ibflag", ibFlag);
      	}
    	var ctntDupChk = findArbNoteDupRow(sheetObj, "note_ctnt_text", amdtSeq);
    	if(ctntDupChk != undefined){
    		if(!setNoteSeqSynchronized(sheetObj, ctntDupChk, amdtSeq)){
        		return false;
        	}
    	}
    	return true;
     }
    
    /**
     * Check note seq / content's duplication and Return duplicated rows as array <br>
     *
     * @author NYK
     * @version 2016.08.02
     */
    function findArbNoteDupRow(sheetObj, checkStr, amdtSeq){
	 var dupArr = sheetObj.ColValueDupRows(checkStr, false, true).split("|");
	 if(dupArr[0] == undefined || dupArr[0] == ""){
		 return;
	 }
	 var dupArrFirst = dupArr[0].split(",");
	 var dupArrRest = dupArr[1].split(",");
	 var dupArrFinal = new Array();
	 var rtnArrFinal = new Array();
	 var finalArrCnt = 0;
	 // logic to find duplicated row number including first base(reference) row in terms of checkStr parameter
	 for(var k=0; k<dupArrFirst.length; k++){
		 dupArrFinal[finalArrCnt] = dupArrFirst[k];
		 for(var l=0; l<dupArrRest.length; l++){
			 if(sheetObj.GetCellValue(parseInt(dupArrFirst[k]), checkStr) == sheetObj.GetCellValue(parseInt(dupArrRest[l]), checkStr)){
				dupArrFinal[finalArrCnt] += "|" + dupArrRest[l];
			 }
		 }
		 finalArrCnt++;
	 }
	 // exclude empty string case in row duplication check
	 for(var i=0; i<dupArrFinal.length; i++){
		 if(sheetObj.GetCellValue(dupArrFinal[i][0], checkStr) == ""){
			 dupArrFinal.splice(i, 1);
			 break;
		 }
	 }
	 // return duplication row array
	 for(var j=0; j<dupArrFinal.length; j++){
		 rtnArrFinal[j] = dupArrFinal[j].split("|");
	 }
	 return rtnArrFinal;
}
    
    /**
     * After finding duplicated note content with same note sequence, return the first row index of those are duplicated. <br>
      *
      * @author NYK
      * @version 2016.08.02
     */
    function getNoteSeqDuplicated(sheetObj, seqDupChk, amdtSeq) {
    	var seqDupArr = new Array();
    	var seqInitialDupArr = new Array();
    	var seqRestDupArr = new Array();
    	var wrongCnt = 0;
    	var rtnDupRow = "";
    	var rtnDupCtnt = "";
    	for(var i=0; i<seqDupChk.length; i++){
    		if(seqDupChk[i].length <= 1){
    			continue;
    		}else{
    			seqDupArr.length = 0;
    			seqInitialDupArr.length = 0;
    			seqRestDupArr.length = 0;
    			// consider note sequence made in last amendment as target of exisiting note sequences for comparison
    			for(var j=0; j<seqDupChk[i].length; j++){
    				if(sheetObj.GetCellValue(seqDupChk[i][j], "n1st_cmnc_amdt_seq") == amdtSeq){
    					seqInitialDupArr.push(seqDupChk[i][j]);
    				}else{
    					seqRestDupArr.push(seqDupChk[i][j]);
    				}
    				seqDupArr.push(sheetObj.GetCellValue(seqDupChk[i][j], "add_chg_note_ctnt"));
    			}
    		}
    		// return note sequence that is different to other note sequence with same content
    		// duplicated content check is based on only text, not considering empty space on it
    		for(var k=0; k<seqDupArr.length; k++){
    			for(var h=k+1; h<seqDupArr.length; h++){
    				if(seqDupArr[k].replace(/\s/gi, '') != seqDupArr[h].replace(/\s/gi, '')){
    					wrongCnt++;
    					if(seqRestDupArr.length == 0){
    						rtnDupCtnt = sheetObj.GetCellValue(seqInitialDupArr[0], "add_chg_note_ctnt");
    					}else{
    						rtnDupCtnt = sheetObj.GetCellValue(seqRestDupArr[0], "add_chg_note_ctnt");
    					}
    					for(var l=0; l<seqInitialDupArr.length; l++){
    						if(sheetObj.GetCellValue(seqInitialDupArr[l], "add_chg_note_ctnt").replace(/\s/gi, '') != rtnDupCtnt.replace(/\s/gi, '')){
    							rtnDupRow = seqInitialDupArr[l];
    							break;
    						}
    					}
    					break;
    				}
    			}
    			break;
    		}
    		if(wrongCnt > 0){
    			return rtnDupRow;
    		}
    	}
    	return true;
    }
    
    /**
     * Synchronize note sequence equally based on same content <br>
      *
      * @author NYK
      * @version 2016.08.02
     */
    function setNoteSeqSynchronized(sheetObj, ctntDupArr, amdtSeq) {
    	var syncArr = new Array();
    	var allSyncCnt = 0;
    	var rCnt = sheetObj.RowCount();
    	var syncChkArr = new Array();
	   	var syncChkCnt = 0;
	   	// auto match logic is only applied to inserted/updated rows when saving
	   	for(var m=0; m<ctntDupArr.length; m++){
	   		for(var n=0; n<ctntDupArr[m].length; n++){
	   			if(sheetObj.GetCellValue(ctntDupArr[m][n], "src_info_cd") != "AD" && sheetObj.GetCellValue(ctntDupArr[m][n], "n1st_cmnc_amdt_seq") == amdtSeq
	   				&& (sheetObj.GetCellValue(ctntDupArr[m][n], "ibflag") == "I" || sheetObj.GetCellValue(ctntDupArr[m][n], "ibflag") == "U")){
	   				syncChkCnt++;
	   			}
	   		}
	   		if(syncChkCnt>0){
	   			syncChkArr.push("Y");
	   		}else{
	   			syncChkArr.push("N");
	   		}
	   		syncChkCnt = 0;
	   	}
	   	var ctntDupArrCpy = new Array();
	   	for(var o=0; o<ctntDupArr.length; o++){
	   		if(syncChkArr[o].split(":")[0] == "Y"){
	   			ctntDupArrCpy.push(ctntDupArr[o]);
	   		}
	   	}
	   	ctntDupArr = ctntDupArrCpy;
    	// Find minimum value on same note sequence rows
    	for(var i=0; i<ctntDupArr.length; i++){
    		var eachSyncCnt = 0;
    		var minValArr = new Array();
    		minValArr[0] = ctntDupArr[i];
    		minValArr[1] = new Array();
    		var tmpMinArr = new Array();
    		for(j=0; j<ctntDupArr[i].length; j++){
    			minValArr[1].push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
    			if(amdtSeq>0 && (sheetObj.GetCellValue(ctntDupArr[i][j], "n1st_cmnc_amdt_seq") == amdtSeq)){
    				continue;
    			}
    			tmpMinArr.push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
    		}
    		if(tmpMinArr[0] == undefined){
    			minValArr[2] = Math.min.apply(Math, minValArr[1]);
    		}else{
    			minValArr[2] = Math.min.apply(Math, tmpMinArr);
    		}
        	// check whether same content is inputted with different sequence
    		for(var k=0; k<minValArr[1].length; k++){
    			for(var h=k+1; h<minValArr[1].length; h++){
    				if(minValArr[1][k] != minValArr[1][h]){
    					eachSyncCnt++;
    				}
    			}
    		}
    		if(eachSyncCnt > 0){
    			syncArr.push(minValArr);
    			allSyncCnt++;
			}
    	}
    	// Show soft warning(option) to synchronize note sequence based on content
    	if(allSyncCnt>0){
       		if(ComShowCodeConfirm('PRI02024')){
       			for(var i=0; i<syncArr.length; i++){
       				for(var j=0; j<syncArr[i][0].length; j++){
       					if(sheetObj.GetCellValue(syncArr[i][0][j], "n1st_cmnc_amdt_seq") != amdtSeq){
       						continue;
       					}
       					var rowStatus = sheetObj.GetRowStatus(syncArr[i][0][j]);
       					if(sheetObj.GetCellValue(syncArr[i][0][j], "ibflag") == "I" || sheetObj.GetCellValue(syncArr[i][0][j], "ibflag") == "U"){
       						sheetObj.SetCellValue(syncArr[i][0][j], "note_dp_seq", syncArr[i][2]);
       					}
       					if(rowStatus == "R"){
       						sheetObj.SetRowStatus(syncArr[i][0][j], "U");
       					}else{
       						sheetObj.SetRowStatus(syncArr[i][0][j], rowStatus);
       					}
       				}
           		}
       		}
    		}
    	 return true;
    }
    
     