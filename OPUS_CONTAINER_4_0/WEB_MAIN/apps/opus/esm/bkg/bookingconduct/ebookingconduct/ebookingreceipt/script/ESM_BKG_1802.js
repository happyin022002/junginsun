/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1801.jsp
*@FileTitle  : Pegasus XML Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var rdObjects=new Array();
	var rdCnt=0;
	var iterator="|$$|";
	var comboObjects=new Array();
	var combo1=null;
	var comboCnt=0;
	var arrMultiCombo;
	var arrWindow=new Array(null,null); 
	// esm_bkg_0229 popup Count
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_upload":
				doActionIBSheet(sheetObjects[0],document.form,"btn_upload","","");
				break;
			case "btn_Close":
				ComClosePopup(); 
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

	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	function initControl() {
		var formObject=document.form;
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
		applyShortcut();
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH,"","");
		initControl();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1: 
			with(sheetObj){
				var HeadTitle1="|Chk|Seq.|RCV Date(KST)|Upload|Request|Request|Request|";
				var HeadTitle2="|Chk|Seq.|RCV Date(KST)|Upload|Sender ID|No.|Seq|";
				SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:5, Page:20, DataGetGetRowMerge:1 } );
				var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers=[ { Text:HeadTitle1, Align:"Center"},
				              { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols=[ {Type:"Status",     Hidden:1, Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"CheckBox",  Hidden:0, Width:60,   	Align:"Center",  ColMerge:1,   SaveName:"slct_flg" },
							{Type:"Text",      Hidden:0, Width:80,   	Align:"Right",   ColMerge:1,   SaveName:"bkg_xter_rcv_msg_seq",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:150,		Align:"Center",  ColMerge:1,   SaveName:"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:80,  	Align:"Center",  ColMerge:0,   SaveName:"upld_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:120,   	Align:"Left",    ColMerge:0,   SaveName:"xter_sndr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:150,   	Align:"Right",   ColMerge:0,   SaveName:"xter_rqst_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:100,   	Align:"Right",   ColMerge:1,   SaveName:"xter_rqst_seq",	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,   	Align:"Right",   ColMerge:1,   SaveName:"xml_and_edi_msg_desc"} ];
				InitColumns(cols);
//				SetDataLinkMouse("xter_rqst_acpt_usr_id");
//				SetDataLinkMouse("upld_usr_id");
//				SetDataLinkMouse("upld_usr_nm");
				SetSheetHeight(355);
			}
			break;
		}
	}
	
	    function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
	        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (sheetObj.id == "sheet1") {
	        		sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
		        	formObj.f_cmd.value=SEARCH;
		        	sheetObj.DoSearch("ESM_BKG_1802GS.do", FormQueryString(formObj)+"&"+ "page_no=1" ,{Sync:2} );
				}
				break;
			case "btn_upload":      //Upload
				formObj.f_cmd.value=MULTI01;
	 			var sXml=sheetObj.GetSaveData("ESM_BKG_1801GS.do", FormQueryString(formObj));
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComShowCodeMessage("BKG00166");
				}else{
					ComShowCodeMessage("BKG00167");										
				}
				break;
				
	        }
	    }

	    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	    	ComOpenWait(false);
			var formObject=document.form;
			formObject.xml_and_edi_msg_desc.value = sheetObjects[0].GetCellValue(2, "xml_and_edi_msg_desc");	    	
	    }
