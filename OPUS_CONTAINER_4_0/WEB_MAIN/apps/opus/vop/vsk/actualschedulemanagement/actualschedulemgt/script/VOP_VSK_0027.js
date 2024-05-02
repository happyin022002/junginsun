/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0027.js
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_vsk_0027.jsp : business script for VOP_VSK_0027.jsp
     */
    function vop_vsk_0027() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.initCombo=initCombo;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;  
    }
	
    var focusObj=null;
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// EDI(Tab - 5)
	//	var glbSaveRcvDt = "";
	//	var glbSaveRcvSeq = "";
	var comboObjects=new Array();
	var comboCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	tabLoad[2]=0;
	tabLoad[3]=0;
	tabLoad[4]=0;
	//Setting contion per each Tab
	var glbFormDataTab1=null;
	var glbFormDataTab2=null;
	var glbFormDataTab3=null;
	var glbFormDataTab4=null;
	var glbFormDataTab5=null;
	//Setting sls_ofc_cd Combo List per each Tab
	var glbSlsOfcArrTab1=null;
	var glbSlsOfcArrTab2=null;
	var glbSlsOfcArrTab3=null;
	var glbSlsOfcArrTab4=null;
	var glbSlsOfcArrTab5=null;
	var gblSubTotalColor=null;
	var glbGrandTotalColor=null;
	//Color public variable
	var glbGreyColor=null;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		/*******************************************************/
		var sheetObj=getCurrentSheet();
		var formObj=document.form;
     	try {
			var srcName=ComGetEvent("name");		
	        if (!ComIsBtnEnable(srcName)) return;  
			//if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_t1Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 				case "btn_t1RLaneRegist":
 					doActionIBSheet(sheetObj, formObj, COMMAND01);
 					break;
 				case "btn_t2Retrieve":
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 				case "btn_t2New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 				case "btn_t2DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
 				case "btn_t3Retrieve":
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 				case "btn_t3New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 				case "btn_t3DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
 				case "btn_t4Retrieve":
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 				case "btn_t4New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 				case "btn_t4DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
 				case "btn_t5Retrieve":
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 				case "btn_t5New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 				case "btn_t5Retry":
 					doActionIBSheet(sheetObj, formObj, IBSAVE);
 					break;
 				case "btn_t5DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
				case "btn_port":
					doActionIBSheet(sheetObj, formObj, COMMAND11);
 					break;
				case "btn_cal1":
					doActionIBSheet(sheetObj, formObj, COMMAND12);
 					break;
				case "btn_cal2":
					doActionIBSheet(sheetObj, formObj, COMMAND14);
 					break;
				case "btn_vvd":
					doActionIBSheet(sheetObj, formObj, COMMAND13);
 					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
	 * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
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
		for(var i=0; i<sheetObjects.length; i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0; k<tabObjects.length; k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		//CTRL Combo Setting.
		doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
		setScsFlgCombo();
		resizeSheet();
		glbFormDataTab1=new Usr_Condi_FormData();
		glbFormDataTab2=new Usr_Condi_FormData();
		glbFormDataTab3=new Usr_Condi_FormData();
		glbFormDataTab4=new Usr_Condi_FormData();
		glbFormDataTab5=new Usr_Condi_FormData();
		glbSubTotalColor="#F7E1EC"; 
		glbGrandTotalColor="#F7E1EC";
		glbGreyColor="#DBDBDB";
		glbOverDaysColor="#F7E1EC";
		initControl();
    }
    /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      //t1sheet1 init
	            with(sheetObj){
              
					var HeadTitle="Revenue Lane for Audit 1|Revenue Lane for Audit 1|Revenue Lane for Audit 1| Revenue Lane for Audit 2| Revenue Lane for Audit 2| Revenue Lane for Audit 2";
					var HeadTitle2="No.|Lane Code|Lane Name|No.|Lane Code|Lane Name";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},
					                { Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",  ColMerge:0,   SaveName:prefix+"seq1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_nm1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",  ColMerge:0,   SaveName:prefix+"seq2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_nm2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
					InitColumns(cols);
					SetSheetHeight(390);
					SetEditable(0);
					SetCountPosition("0");
				}
				break;
			case 2:      //t2sheet1 init
			    with(sheetObj){		     
				      var HeadTitle1="CTRL HQ|CTRL Office|Port|Count|Count|Count|Count|Count|Ratio|Ratio|Ratio";
				      var HeadTitle2="CTRL HQ|CTRL Office|Port|Target Lane|Target VVD|Port Calling|Inputted|Over Input|Input|Overdue|Observance";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rhq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ctrl_ofc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"target_lane_cnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"target_vvd_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ttl_port_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inputted_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"over_input_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"input_rto",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"overdue_rto",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"observance_rto",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
				      InitColumns(cols);
				      SetSheetHeight(390);
				      SetEditable(0);
				      SetCountPosition("0");
				}
				break;
			case 3:      //t3sheet1 init
			    with(sheetObj){
		        		     
		      var HeadTitle="Seq.|Lane|Office|Port|TMNL|VVD|ETA|ATA|Reported Date|Over days|ETB|ATB|Reported Date|Over days|ETD|ATD|Reported Date|Over days";

		      SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:0, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sls_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rpt_ata",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ata_over_days", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:4,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etb_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_brth_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rpt_atb",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"atb_over_days", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:4,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_dep_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rpt_atd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"atd_over_days", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:4,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(367);
		      SetEditable(0);
		      SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"act_arr_dt", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"rpt_ata", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"act_brth_dt", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"rpt_atb", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"act_dep_dt", {Format:"####-##-## ##:##"} );
		      SetColProperty(prefix+"rpt_atd", {Format:"####-##-## ##:##"} );
		            FrozenCols=SaveNameCol(prefix+"vps_eta_dt");
		      }


			    break; 
			case 4:      //t4sheet1 init
	            with(sheetObj){    
			          var HeadTitle="Seq.|Lane|Port|TMNL|VVD|ETA|ETB|ETD|ATA|ATB|ATD";
			
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);

			          var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
				     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_port_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etb_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_arr_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_brth_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_dep_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				           
			          InitColumns(cols);
			          SetSheetHeight(390);
			          SetEditable(0);
			          SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
			          SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
			          SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
			          SetColProperty(prefix+"act_arr_dt", {Format:"####-##-## ##:##"} );
			          SetColProperty(prefix+"act_brth_dt", {Format:"####-##-## ##:##"} );
			          SetColProperty(prefix+"act_dep_dt", {Format:"####-##-## ##:##"} );
			          SetCountPosition("0");
				}
				break; 
			case 5:      //t5sheet1 init
	            with(sheetObj){
				
		          var HeadTitle1="|CHK|Lane|Port|TMNL|VVD|ATA|ATB|ATD|Receiving Date|Result|EDI Flat File|EDI Flat File|EDI Flat File|EDI Flat File|EDI Flat File|EDI Flat File|EDI Flat File|EDI Flat File|EDI Flat File";
		          var HeadTitle2="|CHK|Lane|Port|TMNL|VVD|ATA|ATB|ATD|Receiving Date|Result|Sender ID|IMO No.|Call Sign|Voyage No|VVD|ATA|ATB|ATD|DIS Complete DT";
		
		          SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		              { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			     {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_flg",          KeyField:1 },
			     {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"act_arr_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"act_brth_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dep_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rslt_msg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sndr_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lloyd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"call_sgn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_act_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_act_brth_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_act_dep_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dchg_cmpl_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_vsl_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_skd_dir_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scs_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcvr_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_msg_tp_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_msg_proc_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			           
		          InitColumns(cols);
		          SetSheetHeight(390);
		          SetEditable(1);
		          SetColProperty(prefix+"edi_act_arr_dt", {Format:"####-##-## ##:##"} );
		          SetColProperty(prefix+"edi_act_brth_dt", {Format:"####-##-## ##:##"} );
		          SetColProperty(prefix+"edi_act_dep_dt", {Format:"####-##-## ##:##"} );
		          SetColProperty(prefix+"act_arr_dt", {Format:"####-##-## ##:##"} );
		          SetColProperty(prefix+"act_brth_dt", {Format:"####-##-## ##:##"} );
		          SetColProperty(prefix+"act_dep_dt", {Format:"####-##-## ##:##"} );
		          SetColProperty(prefix+"cre_dt", {Format:"####-##-## ##:##"} );
		          
		          SetColProperty(prefix+"dchg_cmpl_dt", {Format:"####-##-## ##:##"} );
		          
		          FrozenCols=SaveNameCol(prefix+"vvd");
			}
			break; 
         }
     }
	/**
     * initializing Tab
     * setting Tab items
     */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt=0 ;
					InsertItem( "R/Lane" , "");
					InsertItem( "Input Ratio" , "");
					InsertItem( "Detail" , "");
					InsertItem( "Uncompleted Report" , "");
					InsertItem( "EDI SKD Monitoring" , "");
				}
				break;
		}
	}
	/**
   	 * setting combo initial values and header 
   	 * param : comboObj, comboNo
   	 * adding case as numbers of counting combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.id) { 
	    	case "vskd_port_rhq_cd": 
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
  					SetDropHeight(160);
   		    	}
   	    		break;
	    	case "sls_ofc_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
  					SetDropHeight(160);
   		    	}
   	    		break;
   	    	case "tml_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(1);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "70");
					SetColWidth(1, "300");
  					SetDropHeight(160);
  					SetEnable(0);
   		    	}
   	    		break;
   	    	case "scs_flg":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "60");
  					SetDropHeight(80);
  					SetEnable(0);
   		    	}
   	    		break;
   	     }
   	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj, formObj, sAction)){
					if ( sheetObj.id == "t1sheet1"){
						formObj.f_cmd.value=SEARCHLIST01;
						var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t2sheet1"){
						formObj.f_cmd.value=SEARCHLIST02;
						var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t3sheet1"){
						formObj.f_cmd.value=SEARCHLIST03;
						var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t4sheet1"){
						formObj.f_cmd.value=SEARCHLIST04;
						var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet1_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t5sheet1"){
						formObj.f_cmd.value=SEARCHLIST05;
						var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("t5sheet1_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						//All Check Initializing
						sheetObj.CheckAll(sheetObj.id+"_chk_flg",0);
						showSheetData(sheetObj, formObj, sXml);
					}
				}
				break;
			case SEARCH10:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH10;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
					return sXml;
				}
				break;
			case COMMAND01:      // R/Lane Regist
				sUrl="/opuscntr/VOP_VSK_0234.do";
        		ComOpenPopup(sUrl, 720, 450, "returnRLaneRegist", "none", true);
				break;
			case COMMAND02:      // Open
				formObj.f_cmd.value=SEARCH01;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
				var rhqCdArr=("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
				var rhqDescArr=("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
				//CTRL Combo Setting.
				appendMultiComboItem(getComboObject("vskd_port_rhq_cd"), rhqCdArr, rhqDescArr, "", "DEF");
//				appendMultiComboItem(getComboObject("scs_flg"), "ALL", "", "", "DEF");
				break;
			case COMMAND03:      // Control Office
				formObj.f_cmd.value=SEARCH02;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
				return sXml;
//				var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
//				var ctrlOfcArr = null;
//				if(sCtrlOfc != null && sCtrlOfc != undefined){
//					ctrlOfcArr = ("ALL|"+sCtrlOfc).split("|");	//
//				}
//				
//				//CTRL Combo Setting.
//				appendMultiComboItem(getComboObject("sls_ofc_cd"), ctrlOfcArr, ctrlOfcArr, "", "DEF");
				break;
			case COMMAND04:      //vps_port_cd
				if(validateForm(sheetObj, formObj, sAction)){
					var sXml=null;
					if (sheetObj.id == "t5sheet1"){
						formObj.f_cmd.value=SEARCH04;
						var sParam=FormQueryString(formObj);
						sXml=sheetObj.GetSearchData("VSK_COMGS.do", sParam);
					}else{
						formObj.f_cmd.value=SEARCH03;
						var sParam=FormQueryString(formObj);
						sXml=sheetObj.GetSearchData("VOP_VSK_0027GS.do", sParam);
					}
					return sXml;
				}else{
					return "";
				}
				break;
			case COMMAND11:      // btn_port
				if(beforetab > 0){
					//sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043";
					//sUrl = "/opuscntr/VOP_VSK_0043.do?f_cmd=" + COMMAND13;
					sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
					ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
				}
				break;
			case COMMAND12:      // btn_cal1
				var cal=new ComCalendar();
				cal.setEndFunction("returnPeriodHelp");
				cal.select(formObj.fm_dt, 'yyyy-MM-dd');
				break;
			case COMMAND14:      // btn_cal2
				var cal=new ComCalendar();
				cal.setEndFunction("returnPeriodHelp");
				cal.select(formObj.to_dt, 'yyyy-MM-dd');
				break;
			case COMMAND13:      // btn_vvd
				if(beforetab != 0){
					var vsl_cd=formObj.vsl_cd.value;
	            	if(vsl_cd == ""){
	            		//sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219";
	            		//sUrl = "/opuscntr/VOP_VSK_0219.do?f_cmd=" + COMMAND16;
	            		sUrl="/opuscntr/VOP_VSK_0219.do";
	            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
	            	}else{
	            		//sUrl = "/opuscntr/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		//sUrl = "/opuscntr/VOP_VSK_0230.do?f_cmd=" + COMMAND17 + "&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
	            	}
				}
				break;
			case IBSAVE:        //Retry
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI05;
					setSavePointKey(sheetObj, formObj);
					var sParam=ComGetSaveString(sheetObj, false, false, sheetObj.id+"_chk_flg");
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSaveData("VOP_VSK_0027GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveData(sXml);
					var nodeText=ComGetSelectSingleNode(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
				}
				break;
			case IBCLEAR:        //NEW
				clearAllData(sheetObj, formObj);
				break;
			case IBDOWNEXCEL:        	//excel download
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{					 
					 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj),Merge:1,TreeLevel:false,SheetDesign:1 });	
				}
				break;
		}
	}
    /**
     * handling process for input validation
     */
	function validateForm(sheetObj, formObj, sAction){
		var sheetId=sheetObj.id;
		switch(sAction) {
			case IBSEARCH:      //Retrieve
//				if (sheetId != "t1sheet1"){
//					if(!ComShowConfirm("Please check your retrieve conditions. Do you want to continue?")){
//						return false;
//					}
//				}
				// Checking fm_dt < to_dt
				if(!checkPeriod(formObj.fm_dt, formObj.to_dt)){
					ComShowCodeMessage("VSK00025", "End date", "start date");
					return false;
				}
				if (sheetId == "t1sheet1"){
					// Checking period(in 1 month)
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}else if(sheetId == "t2sheet1"){
					if(ComIsNull(formObj.fm_dt)){
						ComShowCodeMessage('VSK00027', "From date");
						formObj.fm_dt.focus();
						return false;
					}else if(ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "To date");
						formObj.to_dt.focus();
						return false;
					}
					// Checking period(in 1 year)
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
						ComShowCodeMessage("VSK00105", "1 year");
						return false;
					}
				}else if(sheetId == "t3sheet1"){
					if(ComIsNull(formObj.fm_dt) || ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "From, To date");
						formObj.btn_cal1.focus();
						return false;
					}
					// Checking period(in 1 month)
//					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
//						ComShowCodeMessage("VSK00105", "1 month");
//						return false;
//					}
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
						ComShowCodeMessage("VSK00105", "1 year");
						return false;
					}
				}else if(sheetId == "t4sheet1"){
					if(ComIsNull(formObj.fm_dt) || ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "From, To date");
						formObj.btn_cal1.focus();
						return false;
					}
					// Checking period(in 1 month)
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}else if(sheetId == "t5sheet1"){
					if(ComIsNull(formObj.fm_dt) || ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "From, To date");
						formObj.btn_cal1.focus();
						return false;
					}
					// Checking period(in 1 month)
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}
				break;
			case COMMAND04:      //Port
				if (sheetObj.id == "t5sheet1"){
					if(ComIsNull(formObj.vps_port_cd) || formObj.vps_port_cd.value.length < 2 ){
						return false;
					}
				}else{
					if(ComIsNull(formObj.vps_port_cd) || formObj.vps_port_cd.value.length < 5 ){
						return false;
					}
				}
				break;
			case IBSAVE:        //Retry
				break;
		}
		return true;
	}
	function checkPeriod(fromDate, toDate){
		var fmDt=ComReplaceStr(fromDate.value, "-", "");
		var toDt=ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * process after retrieve.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXml){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
		if(sXml != null){
		//	var rootNode=VskGetXmlRootNode(sXml);
		//	var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
			if(dataNode){
				var totValue=dataNode.value;
				if(totValue > 0){
//					sheetObj.Redraw = false;
					if(sheetObj.id == "t5sheet1"){
//					if(beforetab == 4){
						if(VskIsNull(formObj.rcv_dt.value) && VskIsNull(formObj.rcv_seq.value)){
							// Retrieve
							sheetObj.LoadSearchData(sXml,{Sync:0} );
							var totCnt=sheetObj.LastRow();
							for(var i=headCnt; i<=totCnt; i++){
								if(sheetObj.GetCellValue(i, prefix+"scs_flg") == "Y"){
									sheetObj.SetCellEditable(i, prefix+"chk_flg",0);
								}
							}
						}else{
							var totCnt=sheetObj.LastRow();
							var saveIdx=0;	// saved RowCount()
							for(var i=headCnt; i<=totCnt; i++){
								if(sheetObj.GetCellValue(i, prefix+"rcv_dt") == formObj.rcv_dt.value && sheetObj.GetCellValue(i, prefix+"rcv_seq") == formObj.rcv_seq.value){
									saveIdx=i;
									break;
								}
							}
							sheetObj.RowDelete(saveIdx, false);				// Deleting original Row
							sheetObj.LoadSearchData(sXml,{Append:1 , Sync:0} );
							// 
							if(sheetObj.GetCellValue(saveIdx, prefix+"scs_flg") == "Y"){
								sheetObj.SetCellEditable(saveIdx, prefix+"chk_flg",0);
							}
							formObj.rcv_dt.value="";
							formObj.rcv_seq.value="";
						}
					}else{
						sheetObj.LoadSearchData(sXml,{Sync:0} );
						var totCnt=sheetObj.LastRow();
						if(sheetObj.id == "t4sheet1"){
	//						in case ATA,ATB,ATD are not inputed, Controling grid color to gray
							for(var i=headCnt; i<=totCnt; i++){
								if(sheetObj.GetCellValue(i, prefix+"act_arr_dt") == ""){
									sheetObj.SetCellBackColor(i, prefix+"act_arr_dt",glbGreyColor);
								}
								if(sheetObj.GetCellValue(i, prefix+"act_brth_dt") == ""){
									sheetObj.SetCellBackColor(i, prefix+"act_brth_dt",glbGreyColor);
								}
								if(sheetObj.GetCellValue(i, prefix+"act_dep_dt") == ""){
									sheetObj.SetCellBackColor(i, prefix+"act_dep_dt",glbGreyColor);
								}
							}
						}
					}
//					sheetObj.Redraw = true;
				}else{
//					sheetObj.Redraw = false;
					sheetObj.LoadSearchData(sXml,{Sync:0} );
//					sheetObj.Redraw = true;
				}
			}
		}
	}
	/*
	 * =====================================================================
	 * Tab Event
	 * =====================================================================
	 */
	/**
	 * Event when clicking Tab
	 * activating selected tab items
	 */
	function tab1_OnChange(tabObj , nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		//--------------- important --------------------------//
				
		for(var i = 0; i<objs.length; i++){
			  if(i != nItem){
			   objs[i].style.display="none";
			   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
			  }
		}
		resizeSheet();
		//------------------------------------------------------//
		beforetab=nItem;
		//Setting retrieving condition and status, data
		setConditionControl(nItem);
	}
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var headCnt=sheetObj.HeaderRows();
 		with(sheetObj)
 		{
 			if(RowCount()> 0){
 				for(var i=0; i<RowCount(); i++){
 					if(GetCellValue(i+HeaderRows(), id+"_port_cd") == "Sub Total"){
 	 					SetRowBackColor(i+HeaderRows(),glbSubTotalColor);
// 	 		 			RowMerge(i+HeaderRows) = true;
 	 				}
 	 			}
 				SetRowBackColor(LastRow(),glbGrandTotalColor);
 			}
// 			ColBackColor(sheetObj.id+"_rhq") = "#E5EAFF";
// 			SetRowBackColor(LastRow(),glbGrandTotalColor);
// 			RowMerge(LastRow) = true;
 		}
 	}
 	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var headCnt=sheetObj.HeaderRows();
 		with(sheetObj)
 		{
 			if(RowCount()> 0){
 				for(var i=0; i<RowCount(); i++){
 					if(Number(GetCellValue(i+HeaderRows(), id+"_atd_over_days")) > 0){
 	 					SetRowBackColor(i+HeaderRows(),glbOverDaysColor);
 	 				}
 	 			}
 			}
 		}
 	}
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	function vskd_port_rhq_cd_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 1){
			var sXml=doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			var sCtrlOfc=ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab2=("ALL|"+sCtrlOfc).split("|");	//
			}
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab2, glbSlsOfcArrTab2, "", "DEF");
			glbFormDataTab2.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 2){
			var sXml=doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			var sCtrlOfc=ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab3=("ALL|"+sCtrlOfc).split("|");	//
			}
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab3, glbSlsOfcArrTab3, "", "DEF");
			glbFormDataTab3.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 3){
			var sXml=doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			var sCtrlOfc=ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab4=("ALL|"+sCtrlOfc).split("|");	//
			}
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab4, glbSlsOfcArrTab4, "", "DEF");
			glbFormDataTab4.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 4){
			var sXml=doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			var sCtrlOfc=ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab5=("ALL|"+sCtrlOfc).split("|");	//
			}
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab5, glbSlsOfcArrTab5, "", "DEF");
			glbFormDataTab5.setVskdPortRhqCd(Index_Code);
		}
	}
	function sls_ofc_cd_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 1){
			glbFormDataTab2.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 2){
			glbFormDataTab3.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 3){
			glbFormDataTab4.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 4){
			glbFormDataTab5.setSlsOfcCd(Index_Code);
		}
	}
	function tml_cd_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setTmlCd(Index_Code);
		}
		else if(beforetab == 1){
			glbFormDataTab2.setTmlCd(Index_Code);
		}
		else if(beforetab == 2){
			glbFormDataTab3.setTmlCd(Index_Code);
		}
		else if(beforetab == 3){
			glbFormDataTab4.setTmlCd(Index_Code);
		}
		else if(beforetab == 4){
			glbFormDataTab5.setTmlCd(Index_Code);
		}
	}
	function scs_flg_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setScsFlg(Index_Code);
		}
		else if(beforetab == 1){
			glbFormDataTab2.setScsFlg(Index_Code);
		}
		else if(beforetab == 2){
			glbFormDataTab3.setScsFlg(Index_Code);
		}
		else if(beforetab == 3){
			glbFormDataTab4.setScsFlg(Index_Code);
		}
		else if(beforetab == 4){
			glbFormDataTab5.setScsFlg(Index_Code);
		}
	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form); 		
//    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		
    	axon_event.addListenerForm('click', 'obj_click', form);
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
//    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	
	}
	function obj_change(){
		var eleObj=event.srcElement;
		var formObj=document.form;
		var sheetObj=getCurrentSheet();
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {	
	            case "vps_port_cd":
	            	if(sheetObj.id == "t5sheet1"){
	            		if(eleObj.value.length > 1){
				    		formObj.country_cd.value=eleObj.value;
			            	var sXml=doActionIBSheet(sheetObj, formObj, COMMAND04);
			            	setTmlCdCombo(sXml);
				            formObj.tml_cd.focus();
				    	}else{
				    		formObj.vps_port_cd.value="";
		            		getComboObject("tml_cd").RemoveAll();
		            		formObj.vps_port_cd.focus();
				    	}
	            	}
	            	if(sheetObj.id == "t1sheet1"){
	            		glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab1.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	            	}else if(sheetObj.id == "t2sheet1"){
	            		glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab2.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	            	}else if(sheetObj.id == "t3sheet1"){
	            		glbFormDataTab3.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab3.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	            	}else if(sheetObj.id == "t4sheet1"){
	            		glbFormDataTab4.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab4.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	            	}else if(sheetObj.id == "t5sheet1"){
	            		glbFormDataTab5.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab5.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	            	}
	            	break;
	            case "vsl_cd":
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		formObj.skd_voy_no.focus();
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
            		if(beforetab == 0){
	        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setVslCd(formObj.vsl_cd.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "skd_voy_no":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "skd_dir_cd":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "lloyd_no":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setLloydNo(formObj.lloyd_no.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "call_sgn_no":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
//	function obj_keypress(){
//		var formObj=document.form;
//		var srcName=event.srcElement.name;
//		switch (srcName) {
//	    	case "vps_port_cd":
//	    		ComKeyOnlyAlphabet('upper');
//				break;
//		    case "vsl_cd":
//		    	ComKeyOnlyAlphabet('uppernum');
//				break;
//		    case "skd_voy_no":
//		    	ComKeyOnlyNumber(formObj.skd_voy_no);
//				break;
//		    case "skd_dir_cd":
//		    	ComKeyOnlyAlphabet('upper');
//            	break;
//		    case "opt_hrs":
//		    	ComKeyOnlyNumber(formObj.opt_hrs);
//            	break;
//		    case "fm_dt":
//		    case "to_dt":
//		    	ComKeyOnlyNumber(event.srcElement);
//		    	break;
//		}
//	}
//	function obj_keyup(){
//		var eleObj=event.srcElement;
//		var formObj=document.form;
//		var sheetObj=getCurrentSheet();
//		switch (eleObj.name) {
//	    	case "vps_port_cd":
//	    		if(eleObj.value.length == 5){
//	    			formObj.tml_cd.focus();
//		    	}
//				break;
//	    	case "vsl_cd":
//	    		if(eleObj.value.length == 4){
//		    		formObj.skd_voy_no.focus();
//		    	}
//				break;
//	    	case "skd_voy_no":
//	    		if(eleObj.value.length == 4){
//		    		formObj.skd_dir_cd.focus();
//		    	}
//				break;
//		}
//	}
    function obj_click(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
		        case "vsl_svc_tp_cd":
		        	if(beforetab == 0){
		    			glbFormDataTab1.setVslSvcTpCd(ComGetObjValue(formObj.vsl_svc_tp_cd));
		    		}
		    		else if(beforetab == 1){
		    			glbFormDataTab2.setVslSvcTpCd(ComGetObjValue(formObj.vsl_svc_tp_cd));
		    		}
		    		else if(beforetab == 2){
		    			glbFormDataTab3.setVslSvcTpCd(ComGetObjValue(formObj.vsl_svc_tp_cd));
		    		}
		    		else if(beforetab == 3){
		    			glbFormDataTab4.setVslSvcTpCd(ComGetObjValue(formObj.vsl_svc_tp_cd));
		    		}
		    		else if(beforetab == 4){
		    			glbFormDataTab5.setVslSvcTpCd(ComGetObjValue(formObj.vsl_svc_tp_cd));
		    		}
		        	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
    }
	function obj_activate() {
		var srcName=event.srcElement.name;
		if(srcName){
			focusObj=srcName;
		}else{
			focusObj="";
		}
		switch(srcName){
			case "fm_dt":
			case "to_dt":
//				if(beforetab == 4){
					ComClearSeparator(event.srcElement);
					event.srcElement.select();
//				}
				break;
		}
	}
	function obj_blur(){
		var srcName=event.srcElement.name;
		switch(srcName){
			case "fm_dt":
			case "to_dt":
//				if(beforetab == 4){
					ComChkObjValid(event.srcElement);
//				}
				break;
		}
	}
//	function obj_keydown(){
//		var formObj=document.form;
//		var sheetObj=sheetObjects[0];
//		if(focusObj=="vsl_cd"){
//			var ctrl=event.ctrlKey;
//			var code=event.keyCode;
//			if(ctrl && code == 86){ 
//				var clipData=window.clipboardData.getData('Text');
//				if(clipData!=null && clipData.length==9){
//					clipData=clipData.toUpperCase();
//					formObj.vsl_cd.value=clipData.substring(0, 4);
//					if(isCheckVslCd(sheetObj, formObj)){
//						formObj.skd_voy_no.value=clipData.substring(4, 8);
//						formObj.skd_dir_cd.value=clipData.substring(8, 9);
//					}
//				}
//				event.returnValue=false;
//			}
//		}
//	}
	/*
	 * =====================================================================
	 * Handling Pop Up Data
	 * =====================================================================
	 */
	/**
	 * After [R/Lane Regist] Button Click, Calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
 	function returnRLaneRegist(rtnObjs){
		var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
//					formObj.sim_dt.value = rtnDatas[1];
//					formObj.sim_no.value = rtnDatas[2];
				}
			}
		}
 	}
	/**
	 * After [Port] Button Click, Calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		//alert(rtnObjs );
		var formObj=document.form;
		var sheetObj=getCurrentSheet();
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value=rtnDatas;
					formObj.loc_cd.value=rtnDatas;
					formObj.country_cd.value=rtnDatas;
					sXml=doActionIBSheet(sheetObj, formObj, COMMAND04);
					if(sheetObj.id == "t5sheet1"){
//	            		if(isCheckPortForm(sheetObj, formObj, sXml)){
	            			setTmlCdCombo(sXml);
		            		formObj.tml_cd.focus();
//		            	}else{
//		            		formObj.vps_port_cd.value = "";
//		            		getComboObject("tml_cd").RemoveAll();
//		            		formObj.vps_port_cd.focus();
//		            	}
	            	}else{
		            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
		            		formObj.vps_port_cd.value="";
		            		formObj.vps_port_cd.focus();
		            	}else{
		            		formObj.tml_cd.focus();
		            	}
	            	}
					if(beforetab == 0){
	        			glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab1.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab2.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab3.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab4.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab5.setTmlCd(getComboObject("tml_cd").GetSelectCode());
	        		}
//					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
//					if(!isCheckPortForm(sheetObj, formObj, sXml)){
//						formObj.vps_port_cd.value = "";
//						formObj.vps_port_cd.focus();
//					}else{
//						formObj.fm_dt.focus();
//					}
				}
			}
		}
	}
	/**
	 * Handlnig data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value=rtnDatas[1];
					if(beforetab == 0){
	        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setVslCd(formObj.vsl_cd.value);
	        		}
				}
			}
    	}
    }
    /**
     * Handlnig data from VVD Code Help (Pop-Up)
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value=rtnDatas[2];
					formObj.skd_dir_cd.value=rtnDatas[3];
					if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab3.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab4.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab5.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
				}
			}
    	}
    }
	/**
	 * 
	 * @param rtnObjs
	 * @return
	 */
	function returnPeriodHelp(rtnObjs){
		var formObj=document.form;
		/*
		 * 2014.12.23 dongsoo
		 * Tab 변경시 Period 값이 바뀌지 않도록 변경 요청
		 * Tab별로 Period를 설정하고 싶으면 주석을 해제
		 */
		//if(beforetab == 0){
        	glbFormDataTab1.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab1.setToDt(formObj.to_dt.value);
		//}
		//else if(beforetab == 1){
        	glbFormDataTab2.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab2.setToDt(formObj.to_dt.value);
		//}
		//else if(beforetab == 2){
        	glbFormDataTab3.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab3.setToDt(formObj.to_dt.value);
		//}
		//else if(beforetab == 3){
        	glbFormDataTab4.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab4.setToDt(formObj.to_dt.value);
		//}
		//else if(beforetab == 4){
        	glbFormDataTab5.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab5.setToDt(formObj.to_dt.value);
		//}
	}
	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
 	/**
 	 * Setting conditions when tab change
 	 * 
 	 * @param nItem
 	 * @return
 	 */
 	function setConditionControl(nItem){
 		var formObj=document.form;
 		switch(nItem) {
			case 0:      //tab1
//				ComEnableManyObjects(false, formObj.vps_port_cd, formObj.fm_dt, formObj.to_dt, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);
				VskEnableObjectControl(formObj.vps_port_cd,  false);
				VskEnableObjectControl(formObj.vsl_cd, false);
				VskEnableObjectControl(formObj.skd_voy_no, false);
				VskEnableObjectControl(formObj.skd_dir_cd, false);
				VskEnableObjectControl(formObj.lloyd_no, false);
				VskEnableObjectControl(formObj.call_sgn_no, false);
				getComboObject("vskd_port_rhq_cd").SetEnable(0);
				getComboObject("sls_ofc_cd").SetEnable(0);
				getComboObject("tml_cd").SetEnable(0);
				getComboObject("scs_flg").SetEnable(0);
//				comboObjects[2].Enable = false;
				VskEnableObjectControl(formObj.btn_port, false);
				VskEnableObjectControl(formObj.btn_cal1, true);
				VskEnableObjectControl(formObj.btn_cal2, true);
				VskEnableObjectControl(formObj.btn_vvd, false);
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				VskEnableObjectControl(formObj.fm_dt, true, true);
				VskEnableObjectControl(formObj.to_dt, true, true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[0], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[1], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[2], true);
//				formObj.fm_dt.className = "input2";
//				formObj.to_dt.className = "input2";
				break;
			case 1:      //tab2
			case 2:      //tab3
			case 3:      //tab4
				VskEnableObjectControl(formObj.vps_port_cd,  true);
				VskEnableObjectControl(formObj.vsl_cd, true);
				VskEnableObjectControl(formObj.skd_voy_no, true);
				VskEnableObjectControl(formObj.skd_dir_cd, true);
				VskEnableObjectControl(formObj.lloyd_no, false);
				VskEnableObjectControl(formObj.call_sgn_no, false);
				getComboObject("vskd_port_rhq_cd").SetEnable(1);
				getComboObject("sls_ofc_cd").SetEnable(1);
				getComboObject("tml_cd").SetEnable(0);
				getComboObject("scs_flg").SetEnable(0);
//				comboObjects[2].Enable = true;
				VskEnableObjectControl(formObj.btn_port, true);
				VskEnableObjectControl(formObj.btn_cal1, true);
				VskEnableObjectControl(formObj.btn_cal2, true);
				VskEnableObjectControl(formObj.btn_vvd, true);
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				VskEnableObjectControl(formObj.fm_dt, true, true);
				VskEnableObjectControl(formObj.to_dt, true, true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[0], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[1], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[2], true);
//				formObj.fm_dt.className = "input1_1";
//				formObj.to_dt.className = "input1_1";
				break;
			case 4:      //tab2
				VskEnableObjectControl(formObj.vps_port_cd,  true);
				VskEnableObjectControl(formObj.vsl_cd, true);
				VskEnableObjectControl(formObj.skd_voy_no, true);
				VskEnableObjectControl(formObj.skd_dir_cd, true);
				VskEnableObjectControl(formObj.lloyd_no, true);
				VskEnableObjectControl(formObj.call_sgn_no, true);
				getComboObject("vskd_port_rhq_cd").SetEnable(1);
				getComboObject("sls_ofc_cd").SetEnable(1);
				getComboObject("tml_cd").SetEnable(1);
				getComboObject("scs_flg").SetEnable(1);
//				comboObjects[2].Enable = true;
				VskEnableObjectControl(formObj.btn_port, true);
				VskEnableObjectControl(formObj.btn_cal1, true);
				VskEnableObjectControl(formObj.btn_cal2, true);
				VskEnableObjectControl(formObj.btn_vvd, true);
				VskEnableObjectControl(formObj.fm_dt, true, true);
				VskEnableObjectControl(formObj.to_dt, true, true);
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[0], false);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[1], false);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[2], false);
//				formObj.fm_dt.className = "input1_1";
//				formObj.to_dt.className = "input1_1";
				break;
		}
		setConditionData(formObj, nItem);
 	}
 	/**
 	 * Returning activating sheet
 	 * @return sheetObj
 	 */
 	function getCurrentSheet(){
 		var sheetObj=null;
 		sheetObj=sheetObjects[beforetab];
 		return sheetObj;
 	}
 	/**
	 * Adding item to Mutil Combo
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
		comboObj.RemoveAll();
		if(optionCdArr != null){
			if(sFlag == "DEF"){
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}else{
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}
			comboObj.SetSelectCode(selCode,false);
		}
	}
	/**
	 * Keeping EDI Key when sheet5 save
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function setSavePointKey(sheetObj, formObj){
		var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var totCnt=sheetObj.LastRow();
    	if(totCnt >= headCnt){
    		for(var i=headCnt; i<=totCnt; i++){
    			if(sheetObj.GetCellValue(i, prefix+"chk_flg")){
    				formObj.rcv_dt.value=sheetObj.GetCellValue(i, prefix+"rcv_dt");
    				formObj.rcv_seq.value=sheetObj.GetCellValue(i, prefix+"rcv_seq");
        			break;
        		}
        	}
    	}
	}
	/**
	 * Setting conditions when tab change
	 * 
	 * @param formObj
	 * @param nItem
	 * @return
	 */
	function setConditionData(formObj, nItem){
		
		switch(nItem) {
			case 0:      //tab1
				if(glbFormDataTab1 != null){
					glbFormDataTab1.setAllFormData();
					getComboObject("vskd_port_rhq_cd").SetSelectCode(glbFormDataTab1.getVskdPortRhqCd(),false);
					getComboObject("sls_ofc_cd").SetSelectCode(glbFormDataTab1.getSlsOfcCd(),false);
					getComboObject("tml_cd").SetSelectCode(glbFormDataTab1.getTmlCd(),false);
					getComboObject("scs_flg").SetSelectCode(glbFormDataTab1.getScsFlg(),false);
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}else{
					formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					formObj.to_dt.value=ComGetNowInfo();
				}
				break;
			case 1:      //tab2
				if(glbFormDataTab2 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab2, glbSlsOfcArrTab2, "", "DEF");
					glbFormDataTab2.setAllFormData();
					getComboObject("tml_cd").SetSelectCode(glbFormDataTab2.getTmlCd(),false);
					getComboObject("scs_flg").SetSelectCode(glbFormDataTab2.getScsFlg(),false);
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}
				break;
			case 2:      //tab3
				if(glbFormDataTab3 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab3, glbSlsOfcArrTab3, "", "DEF");
					glbFormDataTab3.setAllFormData();
					getComboObject("tml_cd").SetSelectCode(glbFormDataTab3.getTmlCd(),false);
					getComboObject("scs_flg").SetSelectCode(glbFormDataTab3.getScsFlg(),false);
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}
				break;
			case 3:      //tab4
				if(glbFormDataTab4 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab4, glbSlsOfcArrTab4, "", "DEF");
					glbFormDataTab4.setAllFormData();
					getComboObject("tml_cd").SetSelectCode(glbFormDataTab4.getTmlCd(),false);
					getComboObject("scs_flg").SetSelectCode(glbFormDataTab4.getScsFlg(),false);
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}
				break;
			case 4:      //tab5
				if(glbFormDataTab5 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab5, glbSlsOfcArrTab5, "", "DEF");
					glbFormDataTab5.setAllFormData();
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetNowInfo();//ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}
				break;
		}
	}
	/**
	 * Setting Tml Cd Combo
	 * @return
	 */
	function setTmlCdCombo(sXml){
		if(sXml == null || sXml == undefined || sXml == ""){
			return;
		}
//		var ydKind = " |" + ComGetEtcData(sXml, "yd_kind");
		var ydCd=ComGetEtcData(sXml, "yd_cd");
		var ydNm=ComGetEtcData(sXml, "yd_nm");
		var ydTxtArr=new Array();
//		var ydKindArr = ydKind.split("|");
		var ydCdArr=ydCd.split("|");
		var ydNmArr=ydNm.split("|");
//		var ydCnt = ydKindArr.length;
		var ydCnt=ydCdArr.length;
//		ydTxtArr[0] = ydKindArr[0] + "|" + ydNmArr[0];
		ydTxtArr[0]=ydCdArr[0] + "|" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
//			ydTxtArr[i] = ydKindArr[i] + "|" + ydNmArr[i];
			ydTxtArr[i]=ydCdArr[i] + "|" + ydNmArr[i];
		}
//		appendMultiComboItem(getComboObject("tml_cd"), ydKindArr, ydTxtArr, ydKindArr[1], "DEF");
		appendMultiComboItem(getComboObject("tml_cd"), ydCdArr, ydTxtArr, "", "DEF");
	}
	/**
	 * Setting Result Code(scs_flg) Combo
	 * @return
	 */
	function setScsFlgCombo(){
		var txtArr=new Array();
		txtArr[0]="ALL";
		txtArr[1]="OK";
		txtArr[2]="Fail";
		var cdArr=new Array();
		cdArr[0]="ALL";
		cdArr[1]="Y";
		cdArr[2]="N";
		appendMultiComboItem(getComboObject("scs_flg"), cdArr, txtArr, "ALL", "DEF");
	}
    /**
     * Returning combo Object with combo id
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt=comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].options.id== comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	return null;
    }
	/**
     * [New] Button Event : Initializing Screen
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	//alert( beforetab);
    	if(beforetab == 0){
        	glbFormDataTab1=new Usr_Condi_FormData();
        	glbFormDataTab1.setAllFormData();
		}
		else if(beforetab == 1){
			glbSlsOfcArrTab2=null;
			getComboObject("sls_ofc_cd").RemoveAll();
			getComboObject("tml_cd").RemoveAll();
        	glbFormDataTab2=new Usr_Condi_FormData();
        	glbFormDataTab2.setAllFormData();
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value=ComGetNowInfo();
			}
		}
		else if(beforetab == 2){
			glbSlsOfcArrTab3=null;
			getComboObject("sls_ofc_cd").RemoveAll();
			getComboObject("tml_cd").RemoveAll();
        	glbFormDataTab3=new Usr_Condi_FormData();
        	glbFormDataTab3.setAllFormData();
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value=ComGetNowInfo();
			}
			//formObj.opt_hrs.value="0";
		}
		else if(beforetab == 3){
			glbSlsOfcArrTab4=null;
			getComboObject("sls_ofc_cd").RemoveAll();
			getComboObject("tml_cd").RemoveAll();
        	glbFormDataTab4=new Usr_Condi_FormData();
        	glbFormDataTab4.setAllFormData();
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value=ComGetNowInfo();
			}
		}
		else if(beforetab == 4){
			glbSlsOfcArrTab5=null;
			getComboObject("sls_ofc_cd").RemoveAll();
			getComboObject("tml_cd").RemoveAll();
        	glbFormDataTab5=new Usr_Condi_FormData();
        	glbFormDataTab5.setAllFormData();
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value=ComGetNowInfo();//ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value=ComGetNowInfo();
			}
		}
    	sheetObj.RemoveAll();
//    	showFieldControl(sheetObj, formObj, false);
//    	
//    	initButton(sheetObj);
//    	
//    	formObj.vsl_cd.focus();
    }
	/**
     * Handling screen as Port Code
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	if(sXml == null || sXml == undefined || sXml == "") return false;
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			formObj.loc_cd.value="";
		}
		return false;
    }
    /**
     * Checking Vessel Code is exist in MDM_VSL_CNTR
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
		var sXml=doActionIBSheet(sheetObj, formObj, SEARCH10);
		var chkVslCd=ComGetEtcData(sXml, "vsl_chk");
		if(chkVslCd == "Y"){
    		return true;
    	}else{
    		sheetObj.LoadSearchData(sXml,{Sync:0} );
    		formObj.vsl_cd.value="";
    		return false;
    	}
	}
	/*
	 * =====================================================================
	 * Form Condition Elements Getter/Setter
	 * =====================================================================
	 */
 	function Usr_Condi_FormData(){
 		this.VskdPortRhqCd="";
 		this.slsOfcCd="";
		this.vpsPortCd="";
		this.tmlCd="";
		this.fmDt="";
		this.toDt="";
		this.vslSvcTpCd="";
		this.scsFlg="";
		this.vslCd="";
		this.skdVoyNo="";
		this.skdDirCd="";
		this.lloydNo="";
		this.callSgnNo="";
	}
	//Usr_Condi_FormData.Getter()
	Usr_Condi_FormData.prototype.getVskdPortRhqCd=function(){
		return this.vskdPortRhqCd;
	}
	Usr_Condi_FormData.prototype.getSlsOfcCd=function(){
		return this.slsOfcCd;
	}
	Usr_Condi_FormData.prototype.getVpsPortCd=function(){
		return this.vpsPortCd;
	}
	Usr_Condi_FormData.prototype.getTmlCd=function(){
		return this.tmlCd;
	}
	Usr_Condi_FormData.prototype.getFmDt=function(){
		return this.fmDt;
	}
	Usr_Condi_FormData.prototype.getToDt=function(){
		return this.toDt;
	}
	Usr_Condi_FormData.prototype.getVslSvcTpCd=function(){
		return this.vslSvcTpCd;
	}
	Usr_Condi_FormData.prototype.getScsFlg=function(){
		return this.scsFlg;
	}
	Usr_Condi_FormData.prototype.getVslCd=function(){
		return this.vslCd;
	}
	Usr_Condi_FormData.prototype.getSkdVoyNo=function(){
		return this.skdVoyNo;
	}
	Usr_Condi_FormData.prototype.getSkdDirCd=function(){
		return this.skdDirCd;
	}
	Usr_Condi_FormData.prototype.getLloydNo=function(){
		return this.lloydNo;
	}
	Usr_Condi_FormData.prototype.getCallSgnNo=function(){
		return this.callSgnNo;
	}
	//Usr_Condi_FormData.Setter()
	Usr_Condi_FormData.prototype.setVskdPortRhqCd=function(sVskdPortRhqCd){
		this.vskdPortRhqCd=sVskdPortRhqCd;
	}
	Usr_Condi_FormData.prototype.setSlsOfcCd=function(sSlsOfcCd){
		this.slsOfcCd=sSlsOfcCd;
	}
	Usr_Condi_FormData.prototype.setVpsPortCd=function(sVpsPortCd){
		this.vpsPortCd=sVpsPortCd;
	}
	Usr_Condi_FormData.prototype.setTmlCd=function(sTmlCd){
		this.tmlCd=sTmlCd;
	}
	Usr_Condi_FormData.prototype.setFmDt=function(sFmDt){
		this.fmDt=sFmDt;
	}
	Usr_Condi_FormData.prototype.setToDt=function(sToDt){
		this.toDt=sToDt;
	}
	Usr_Condi_FormData.prototype.setVslSvcTpCd=function(sVslSvcTpCd){
		this.vslSvcTpCd=sVslSvcTpCd;
	}
	Usr_Condi_FormData.prototype.setScsFlg=function(sScsFlg){
		this.scsFlg=sScsFlg;
	}
	Usr_Condi_FormData.prototype.setVslCd=function(sVslCd){
		this.vslCd=sVslCd;
	}
	Usr_Condi_FormData.prototype.setSkdVoyNo=function(sSkdVoyNo){
		this.skdVoyNo=sSkdVoyNo;
	}
	Usr_Condi_FormData.prototype.setSkdDirCd=function(sSkdDirCd){
		this.skdDirCd=sSkdDirCd;
	}
	Usr_Condi_FormData.prototype.setLloydNo=function(sLloydNo){
		this.lloydNo=sLloydNo;
	}
	Usr_Condi_FormData.prototype.setCallSgnNo=function(sCallSgnNo){
		this.callSgnNo=sCallSgnNo;
	}
	Usr_Condi_FormData.prototype.setAllFormData=function(){
		var formObj=document.form;
		if(ComIsNull(this.getVskdPortRhqCd())){
			getComboObject("vskd_port_rhq_cd").SetSelectCode("ALL",false);
		}else{
			getComboObject("vskd_port_rhq_cd").SetSelectCode(this.getVskdPortRhqCd(),false);
		}
		if(ComIsNull(this.getSlsOfcCd())){
			getComboObject("sls_ofc_cd").SetSelectCode("ALL",false);
		}else{
			getComboObject("sls_ofc_cd").SetSelectCode(this.getSlsOfcCd(),false);
		}
		if(ComIsNull(this.getTmlCd())){
			getComboObject("tml_cd").SetSelectCode("ALL",false);
		}else{
			getComboObject("tml_cd").SetSelectCode(this.getTmlCd(),false);
		}
		if(ComIsNull(this.getScsFlg())){
			getComboObject("scs_flg").SetSelectCode("ALL",false);
		}else{
			getComboObject("scs_flg").SetSelectCode(this.getScsFlg(),false);
		}
		ComSetObjValue(formObj.vsl_svc_tp_cd, this.getVslSvcTpCd());
		formObj.vps_port_cd.value=this.getVpsPortCd();
		formObj.fm_dt.value=this.getFmDt();
		formObj.to_dt.value=this.getToDt();
		formObj.vsl_cd.value=this.getVslCd();
		formObj.skd_voy_no.value=this.getSkdVoyNo();
		formObj.skd_dir_cd.value=this.getSkdDirCd();
		formObj.lloyd_no.value=this.getLloydNo();
		formObj.call_sgn_no.value=this.getCallSgnNo();
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
