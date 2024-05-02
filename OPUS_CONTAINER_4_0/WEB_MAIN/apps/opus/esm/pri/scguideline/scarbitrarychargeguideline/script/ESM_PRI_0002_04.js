/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002_04.js
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.05 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 
   /**
     * @fileoverview .
     * @author 
     */

    /**
     * @extends 
     * @class Origin/Destination Arbitrary Charge Guideline Inquiry : Business Script for Origin/Destination Arbitrary Charge Guideline Inquiry 
     */

    // common global variables

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var enableFlag = true;


    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.05
     */
    function processButtonClick(){
    	 

    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
    		switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						fontChange();
					}
					break;						
				
				case "btn_DownExcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}else{
		                ComShowCodeMessage('PRI08001');
		                return false;
					}
					break;

				case "dest_tp_cd":
					obj_click();
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
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.10.05
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
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
     * @version 2009.10.05
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
     * @version 2009.10.05
     */
    function initSheet(sheetObj,sheetNo) {
    	  var cnt=0;
  		 var sheetID=sheetObj.id; 		  
  			    switch(sheetID) {
 		 			   case "sheet1":
 		 				  with(sheetObj){
	 			   var HeadTitle="|Sel.|Seq.|ARBSEQ|pnttpcd|Point|Description|Term|Trans. Mode|bptpcd|Base Port|vptpcd|VIA|Weight\n(Ton <=)|Weight\n( > Ton)|Direct Call|Per|Cargo Type|Cur|Rate|svcscpcd|glineseq|orgdesttpcd";
	 			   var headCount=ComCountHeadTitle(HeadTitle);
	 			   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	 			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
	 			   InitHeaders(headers, info);
	
	 			   var cols = [ {Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	 			             {Type:"DummyCheck",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	 			             {Type:"Seq",       	Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",   Sort:0 },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"arb_seq" },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_tp_cd" },
	 			             {Type:"Text", 			Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	 			             {Type:"Text",      	Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 			             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 			             {Type:"Combo",     	Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_tp_cd" },
	 			             {Type:"Text", 			Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_port_tp_cd" },
	 			             {Type:"Text", 			Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	 			             {Type:"Float",     	Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",     	   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:7},
	 			             {Type:"Float",     	Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:7},
	 			             {Type:"CheckBox",  	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    EditLen:-1 },
	 			             {Type:"Combo",     	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 			             {Type:"Combo",     	Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 			             {Type:"Combo",     	Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 			             {Type:"Float",     	Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
	 			             {Type:"Text",      	Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" } ];
	 			    
	 			   InitColumns(cols);
	
	 			   SetEditable(1);
	 			   SetImageList(0,"img/btns_search_off.gif");
	 			   SetImageList(1,"img/btns_search.gif");
	 			   SetWaitImageVisible(0);
	 			   SetShowButtonImage(2);
	 			   resizeSheet(); //SetSheetHeight(360);
    			}
    			break;
    	}
    }
    
    function resizeSheet() {
 	   	ComResizeSheet(sheetObjects[0]);
    }
    
    
    function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
    	sheetObj.ReNumberSeq();    
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
     * @version 2009.10.05
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH_ASYNC01: // When screen is loading, Customer type retrieves again
    			var firstCheck = false;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSaveData("ESM_PRI_0002_04GS.do" , FormQueryString(formObj));			
				var arrData = ComPriXml2Array(sXml, "typecd|typecount");
				var obj = document.form;
				if (parseInt(arrData[0][1]) > 0) {
					document.getElementById("dest_tp_cd1").style.fontWeight = "bold";
					formObj.dest_tp_cd[0].checked = true;
					obj.org_dest_tp_cd.value = "O";
					firstCheck = true;
				}else{
					document.getElementById("dest_tp_cd1").style.fontWeight = "";
					formObj.dest_tp_cd[0].checked = true;
				}

				if (parseInt(arrData[1][1]) > 0) {
					document.getElementById("dest_tp_cd2").style.fontWeight = "bold";
					if (!firstCheck){
						formObj.dest_tp_cd[1].checked = true;
						obj.org_dest_tp_cd.value = "D";
					}
				}else{
					document.getElementById("dest_tp_cd2").style.fontWeight = "";
				}		
				break;
				
 			case IBCLEAR: 
 				
 				var sXml = "";
 			
				formObj.f_cmd.value = COMMAND14;
				formObj.cd.value = "PER:CUR";		//per combo:currency combo		
				
				sXml = sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				
				var aXml = sXml.split("|$$|");
				
				if ( aXml[0] != null) setIBCombo(sheetObj,aXml[0],"rat_ut_cd",true,0);	
				if ( aXml[1] != null) setIBCombo(sheetObj,aXml[1],"curr_cd",true,0,"USD");	
				
         		formObj.f_cmd.value = COMMAND13;
         		// Common  trans mode,term,cargo
         		formObj.cd.value = "CD01720:N:CD02138:N:CD01701:Y";// "Y" When the name is code or desc   
         		
 				sXml = sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
 				
 				var arrXml = sXml.split("|$$|");
 				if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"prc_trsp_mod_cd",true,0);					
 				if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"rcv_de_term_cd", true,0);
 				if ( arrXml[2] != null)	setIBCombo(sheetObj,arrXml[2],"prc_cgo_tp_cd", false, 0,"","");
 			
			case IBSEARCH:      //Retrieving
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;	
				var sXml=sheetObj.GetSearchData("ESM_PRI_0002_04GS.do", FormQueryString(formObj)); 								
				sheetObj.LoadSaveData(sXml,{Sync:0});								
				ComOpenWait(false);
             	break;

			case IBDOWNEXCEL: 
				var colNames = "Seq|rout_pnt_loc_def_cd|loc_des|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|via_port_def_cd|min_cgo_wgt|max_cgo_wgt|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|curr_cd|frt_rt_amt";
				sheetObj.Down2Excel({DownCols:colNames, CheckBoxOnValue:"Y", CheckBoxOffValue:"N"}); 
				break;
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
     * @version 2009.10.05
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
    		case IBSEARCH: // retrieving			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;    	  

            case IBDOWNEXCEL: // 
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            }
	            break;				
    	  }
         return true;
     }

    /**
     * Handling Axon event for radio butotn <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param  void
     * @returns void
     * @author 
     * @version 2009.10.05
     */ 	 
    function initControl() {
    	// Process Axon Event No.1, Event Catch 
    	//axon_event.addListener('click', 'obj_click', 'dest_tp_cd');
    }
 	
    /**
     * calling function in case of Clicking radio button <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param  void
     * @returns void
     * @author 
     * @version 2009.10.05
     */ 	
 	function obj_click() {
 		var obj = document.form;
 		if (obj.dest_tp_cd[0].checked == true){
 			obj.org_dest_tp_cd.value = "O";
 			obj.cd.value="CD02138"; // origin
 		} else {
 			obj.org_dest_tp_cd.value = "D";
 			obj.cd.value="CD02139"; //dest
 		}

		// Common term
		obj.f_cmd.value = SEARCH19;
//		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(obj));
		var sXml = sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(obj));
		setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0);	  	 		
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	}
     
 	/**
     * Function to modify font of radio button<br>
     * Show BOLD if data exists<br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.10.05
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj = document.form;
		var fontBold ="";
    	var eleName ="";
		
 		if (formObj.dest_tp_cd[0].checked == true){
 			eleName ="dest_tp_cd1";
 		}else{
 			eleName ="dest_tp_cd2";
 		}
 		if (row_count > 0) {
 			fontBold = "bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight = fontBold;
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
     * @version 2009.10.05
     */ 	  	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		for(i = 1 ; i < sheetObj.Rows; i++){
			if (sheetObj.GetCellValue(i, "dir_call_flg") =="1" ){
				sheetObj.CellEditable(i,"via_port_def_cd") = false;
			}
		}
		
		if(sheetObj.RowCount() > 0) {
			ComBtnDisable("btn_LoadExcel");
		}else{
			ComBtnEnable("btn_LoadExcel");
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
     * @version 2009.10.05
     */ 
    function pageOnLoadFinish() {
    	
    	initControl();     	
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);     	
     	parent.loadTabPage();     	
    }
     
    /**
     * Decide Editable option using the status of parent window. <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param  void
     * @return {Boolean} true(Editable, Status of Main is NO) false (Non-Editable, Status of Main is Yes)
     * @author 
     * @version 2009.10.05
     */    
    function getMainStatus(){
    	var mainStatus = parent.document.form.cfm_flg.value;
    	var editStatus = true;
    	if (mainStatus == "Yes"){
    		editStatus = false;
    	}
    	return editStatus;
    }
 	
  	
    /**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sGlineSeq Mandatory gline_seq
     * @return void
     * @author 
     * @version 2009.10.05
     */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;	
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,  IBSEARCH);
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
     * @version 2009.10.05
     */ 		 
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
		
		sheetObjects[0].RemoveAll();
		
	}     
	 
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
     * @version 2009.10.05
     */ 	 
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
				
	}
	
