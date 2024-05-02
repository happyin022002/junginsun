/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0125.jsp
*@FileTitle  : JO TPB Modification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */
    /**
     * @extends 
     * @class ESD_TPB_0125 : ESD_TPB_0125 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0125() {
    	this.processButtonClick=processButtonClick;
        this.setSheetObject=setSheetObject;
        this.setComboObject=setComboObject;
        this.setTabObject=setTabObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;        
        this.initControl=initControl;
        this.initTab=initTab;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
    }
    /* Global Variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  var currentRow=0;
  	/**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
InsertItem( "Dry Index" , "");
InsertItem( "Tanker Index" , "");
InsertItem( "Time Charter" , "");
InsertItem( "Bunker Price" , "");
InsertItem( "Ship Price" , "");
InsertItem( "FFA Index" , "");
  //no support[check again]CLT 				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e.message);
  		}
  	}
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.SetBackColor("#FFFFFF");
  //no support[check again]CLT 		tabObj.TabBackColor(nItem)="146,174,230";
  		var objs=document.all.item("tabLayer");
  		objs[beforetab].style.display="none";
  		objs[nItem].style.display="Inline";
  		//--------------- Notice --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//Not a click button in case of zIndex under 2
  		objs[beforetab].style.zIndex=0;
  		objs[nItem].style.zIndex=9;
  		//------------------------------------------------------//
  		beforetab=nItem;
  	}
  	/**
  	 * Register as an IBSheet Object array
  	 * This is called from comSheetObject(id)
  	 * Process can add in case of future necessity to process other items
  	 * Array defined at the top of the source
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++]=sheet_obj;
  	}
  	/**
  	 * Initializing sheet
  	 * To implement onLoad event of body tag
  	 * Add functionality to after loading screen.
  	 */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
  			document.form.s_n3pty_no.value=document.form.s_n3pty_no_strs_link.value
  		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}
//  		axon_event.addListenerFormat("keypress","obj_Keypress", document.form);     // uppereng
  	}
  	/**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  			    with(sheetObj){
  				      var cnt=0;
  				    
  				      var HeadTitle1="Del.|STS|csrvaild|editable|ots_dtl_seq|TPB No.|SEQ|Exp. Type|Exp. Type|S/P Inv No.|BKG No.|B/L No.|VVD|EQ No.|3rd Party|3rd Party|TPB Status|Curr.|Confirmed|n3pty_bil_tp_cd|bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|vsl_cd|skd_voy_no|finc_dir_cd|vvd_cd|vndr_seq|cust_cnt_cd|cust_seq|n3pty_ofc_cd";
  				      var HeadTitle2="Del.|STS|csrvaild|editable|ots_dtl_seq|TPB No.|SEQ|Main|Sub|S/P Inv No.|BKG No.|B/L No.|VVD|EQ No.|Code|Name|TPB Status|Curr.|Confirmed|n3pty_bil_tp_cd|bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|vsl_cd|skd_voy_no|finc_dir_cd|vvd_cd|vndr_seq|cust_cnt_cd|cust_seq|n3pty_ofc_cd";

  				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1 } );

  				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  				      var headers = [ { Text:HeadTitle1, Align:"Center"},
  				                  { Text:HeadTitle2, Align:"Center"} ];
  				      InitHeaders(headers, info);

  				      var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
  				             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
  				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"csrvalid",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"editable",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ots_dtl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_dp_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_sub_sys_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no_visible",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no_all",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"g_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 },
  				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cust_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:0 },
  				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_party_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:0 },
  				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ots_sts_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cfm_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"finc_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
  				       
  				      InitColumns(cols);

  				      SetEditable(1);
	                  sheetObj.SetDataLinkMouse("vndr_cust_div_cd",1);
  				      sheetObj.SetDataLinkMouse("trd_party_val",1);
  				      SetColProperty("vndr_cust_div_cd", {ComboText:"|"+combo01Text, ComboCode:"|"+combo01Code} );
  				      //SetSheetHeight(450);
  				      ComResizeSheet(sheetObjects[0]);
  				      SetRangeBackColor(1,7,1,8,"#555555");
  				      SetRangeBackColor(1,14,1,15,"#555555");
		      }
  			    break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab ****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_jotpbcancel":
  					doActionIBSheet(sheetObject,formObject,COMMAND01);
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieve
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESD_TPB_0125GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				//Checking VVD(Impossible to save in case of blank or different VVD)
				var vvdDiffVal=0;
				for(var idx=2;idx<=sheetObj.RowCount()+1;idx++)
				{
if(sheetObj.GetCellValue(2,'g_vvd') != sheetObj.GetCellValue(idx,'g_vvd'))
					{
						vvdDiffVal++;
					}
				}
				if(vvdDiffVal != 0)
				{
					ComShowCodeMessage('TPB90070');
					return false;
				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0125GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //Excel download
  				if(sheetObj.RowCount() < 1){//no data
  					ComShowCodeMessage("COM132501");
  				}else{
  					sheetObj.Down2Excel(TPBDown2ExcelOptions);
  				}
  				break;
  			case COMMAND01: // JO TPB Cancel
  				formObj.f_cmd.value=REMOVE; // COMMAND01==1
  				sheetObj.SetRowStatus(2,'U');
  				sheetObj.DoSave("ESD_TPB_0125GS.do", tpbFrmQryStr(formObj));
  				if( sheetObj.RowCount()> 0 ){
  					sheetObj.SetRowStatus(2,'R');
  				}
  		}
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for ( var i=2; i <= sheetObj.RowCount()+1; i++ ){
  			//Showing available to pop-up in 3rd Party item - underline
  			if(sheetObj.GetCellValue(i, "vndr_cust_div_cd") != "" ){
   				sheetObj.SetCellFontUnderline(i, "vndr_cust_div_cd",1);
  			}
  			if(sheetObj.GetCellValue(i, "trd_party_val") != "" ){
   				sheetObj.SetCellFontUnderline(i, "trd_party_val",1);
  			}
  			// Processing by EDITABLE_YN column
  			if(sheetObj.GetCellValue(i,"editable")=="Y"){
  				sheetObj.SetCellEditable(i,          "bkg_no_all",1);
  				sheetObj.SetCellEditable(i,           "bl_no_all",1);
  				sheetObj.SetCellEditable(i,               "g_vvd",1);
  				sheetObj.SetCellEditable(i,               "eq_no",1);
  			}else if(sheetObj.GetCellValue(i,"editable")=="N"){
  				sheetObj.SetRowEditable(i,0);
  			}
  		}
  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 27, 12);
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('COM12149','Data','','');
  		}
  		for ( var i=2; i <= sheetObj.RowCount()+1; i++ ){
  			if(sheetObj.GetCellValue(i,"editable")=="Y"){
				sheetObj.SetCellEditable(i,          "bkg_no_all",1);
				sheetObj.SetCellEditable(i,           "bl_no_all",1);
				sheetObj.SetCellEditable(i,               "g_vvd",1);
				sheetObj.SetCellEditable(i,               "eq_no",1);
  			}else if(sheetObj.GetCellValue(i,"editable")=="N"){
				sheetObj.SetRowEditable(i,0);
			}
  		}
  	}
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		var colNm=sheetObj.ColSaveName(Col);
  		//Calling 3rd Party Selection
  		if( colNm == 'vndr_cust_div_cd'||colNm == 'trd_party_val' ){
  			var vndr_cust_div_cd=sheetObj.GetCellValue(Row, "vndr_cust_div_cd");
  			var trd_party_val=sheetObj.GetCellValue(Row, "trd_party_val");
  			var param;
  			var theURL;
  			var winName;
  			var features;
  			param="?vndr_cust_div_cd="+sheetObj.GetCellValue(Row,"vndr_cust_div_cd")+"&trd_party_val="+sheetObj.GetCellValue(Row,"trd_party_val");
  			theURL="ESD_TPB_0809.do"+param;
  			winName="ESD_TPB_0809";
  			features="scroll:no;status:no;help:no;dialogWidth:450px;dialogHeight:250px";
  			var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
	    	
  		}
  	}
  	
  	function callback0809(divCd, trdVal){  		
		gen3rdParty(divCd, trdVal);
  	}
  	
  	
  	function sheet1_OnPopupClick(sheetObj,Row,Col){
  		get3rdPartyTarget_sheet( sheetObj.GetCellValue(Row,"vndr_cust_div_cd"), Row,Col,sheetObj );
  	}
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  		var row_cnt=sheetObj.RowCount()+1;
  		currentRow=Row;
  		var bkg_no_all=sheetObj.GetCellValue(Row, "bkg_no_all");
  		bkg_no_all=ComTrim(bkg_no_all).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.SetCellValue(Row, "bkg_no_all",bkg_no_all,0);
  		var bl_no_all=sheetObj.GetCellValue(Row, "bl_no_all");
  		bl_no_all=ComTrim(bl_no_all).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.SetCellValue(Row, "bl_no_all",bl_no_all,0);
  		var g_vvd=sheetObj.GetCellValue(Row, "g_vvd");
  		g_vvd=ComTrim(g_vvd).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.SetCellValue(Row, "g_vvd",g_vvd,0);
  		var eq_no=sheetObj.GetCellValue(Row, "eq_no");
  		eq_no=ComTrim(eq_no).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.SetCellValue(Row, "eq_no",eq_no,0);
  		//////////////////////////////////////////////////////
  		var vndr_cust_div_cd=sheetObj.GetCellValue(Row, "vndr_cust_div_cd");
  		var trd_party_val=sheetObj.GetCellValue(Row, "trd_party_val");
  		trd_party_val=ComTrim(trd_party_val).toUpperCase(); // ComTrim & UPPER CASE 
  		var n3pty_bil_tp_cd=sheetObj.GetCellValue(Row, "n3pty_bil_tp_cd");
  		sheetObj.SetCellValue(Row, "trd_party_val",trd_party_val,0);
  		var colNm=sheetObj.ColSaveName(Col);
  		if ( colNm == 'trd_party_val' && ( vndr_cust_div_cd=="V" || vndr_cust_div_cd=="C" || vndr_cust_div_cd=="S" ) ){ // Add colNm condition By Kim Jin-seung In 2008-05-21
  	          document.all.s_vndr_cust_div_cd.value=vndr_cust_div_cd; // input type hidden
  	          document.all.s_trd_party_val.value=trd_party_val; // input type hidden
  	          // ComShowMessage(" .. " +Row);
  	          getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); 
  	    }
  	    //Checking in case of changed of TPB element
  	    //Changing from trd_party_val to "" in case of changed vndr_cust_div_cd
  	    if(sheetObj.ColSaveName(Col) =="vndr_cust_div_cd" ){
  		    for ( var i=2; i <= row_cnt; i++ ){
  				sheetObj.SetCellValue(i, "vndr_cust_div_cd",vndr_cust_div_cd,0);
  				sheetObj.SetCellValue(i, "trd_party_val","",0);
  			}
  	    }
  	    //Validation Check
  		if( colNm == 'bkg_no_all' && Value != '')
  		{
  			document.form.s_bkg_no.value=Value;
  			getTPBGenCombo('CheckBkgNo','checkBLNo','V','','',new Array('s_bkg_no'),Value);
  		}
  		if( colNm == 'bl_no_all' && Value != '')
  		{
  			document.form.s_bl_no_all.value=Value;
  			getTPBGenCombo('CheckBlNo','checkBKGNoWithBLNo','V','','',new Array('s_bl_no_all'),Value);
  		}
  		if( colNm == 'g_vvd' && Value.length >= 9)
  		{
  			document.form.s_vvd.value=Value;
  			getTPBGenCombo('CheckVvdNo','searchCheckVVD','V','','',new Array('s_vvd','otherObjs'),Value);
  		}
  		else if(colNm == 'g_vvd' && Value.length < 9 && Value.length != '')
  		{
  			ComShowCodeMessage('TPB90070');
  			sheetObjects[0].SetCellValue(currentRow, "g_vvd","",0);
  		}
  	}
  	function bkgAutoInput(chkFlg,chkVal){
  	    if(chkFlg == false)
  	    {
  	    	ComShowCodeMessage('TPB90100');
			sheetObjects[0].SetCellValue(currentRow, "bkg_no_all","",0);
  	    }
  	    else
  	    {
  	    	sheetObjects[0].SetCellValue(currentRow,"bl_no_all",chkVal,0);
	    	sheetObjects[0].SetCellValue(currentRow,"bl_no",chkVal,0);
  	    }
  	}
  	function blAutoInput(chkFlg,chkVal){
  		if(chkFlg == false)
  		{
  			ComShowCodeMessage('TPB90101');
			sheetObjects[0].SetCellValue(currentRow, "bl_no_all","",0);
	    }
	    else
	    {
	    	sheetObjects[0].SetCellValue(currentRow,"bkg_no_all",chkVal,0);
	    	sheetObjects[0].SetCellValue(currentRow,"bkg_no",chkVal,0);
	    }
  	}
  	function vvdAutoInput(chkFlg){
  	    //Setting from all row to same value in case of input VVD
  		if(chkFlg == false)
  		{
  			ComShowCodeMessage('TPB90070');
			sheetObjects[0].SetCellValue(currentRow, "g_vvd","",0);
	    }
	    else
	    {
	    	var n3pty_bil_tp_cd=sheetObjects[0].GetCellValue(currentRow, "n3pty_bil_tp_cd");
	    	var row_cnt=sheetObjects[0].RowCount()+1;
	    	g_vvd=sheetObjects[0].GetCellValue(-1, "g_vvd");
		    for ( var i=2; i <= row_cnt; i++ )
		    {
		    	sheetObjects[0].SetCellValue(i, "g_vvd",g_vvd,0);
				if( n3pty_bil_tp_cd == 'JO' ){
					sheetObjects[0].SetCellValue(i, "vvd_cd",g_vvd,0);
				}else{
					sheetObjects[0].SetCellValue(i, "vsl_cd",g_vvd.substring(0,4),0);
					sheetObjects[0].SetCellValue(i, "skd_voy_no",g_vvd.substring(4,8),0);
					sheetObjects[0].SetCellValue(i, "finc_dir_cd",g_vvd.substring(8,10),0);
				}
			}
	    }
  	}
  	/** Saving for same change in case of modified BL_NO, modified BKG_NO **/
  	var _TEMP_VALUE;
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
  		var colNm=sheetObj.ColSaveName(NewCol);
  		/** Saving for same element changing in case of modify - BL_NO, BKG_NO **/
  		if( colNm == "bl_no_all" || colNm == "bkg_no_all" ){
  			_TEMP_VALUE=sheetObj.GetCellValue(NewRow,NewCol);
  		}
  		if( sheetObj.GetCellValue(NewRow, "editable") == "Y" ){
  			//document.form.btn_jotpbcancel.style.display = "";
  			sheetObj.SetCellEditable(NewRow,0,1);
  		}else if( sheetObj.GetCellValue(NewRow, "editable") == "N" ){
  			//document.form.btn_jotpbcancel.style.display = "none";
  			sheetObj.SetCellEditable(NewRow,0,0);
  		}
      }
      function gen3rdParty( vndr_cust_div_cd, trd_party_val ){
    	  var sheet1 = sheetObjects[0];
      	var len=sheet1.RowCount()+1;
  		trd_party_val=ComTrim(trd_party_val).toUpperCase(); // TRIM & UPPER CASE 
  		//Setting same value of all Row in case of trd_party_val input
  		for(var i=2 ; i<=len ; i++ ){
  			sheet1.SetCellValue(i,"vndr_cust_div_cd",vndr_cust_div_cd);
  			sheet1.SetCellValue(i,"trd_party_val",trd_party_val);
  			if( vndr_cust_div_cd == 'V' ){
  				sheet1.SetCellValue(i, "vndr_seq",trd_party_val,0);
  				sheet1.SetCellValue(i, "cust_cnt_cd","",0);
  				sheet1.SetCellValue(i, "cust_seq","",0);
  				sheet1.SetCellValue(i, "n3pty_ofc_cd","",0);
  			}else if( vndr_cust_div_cd == 'C' ){
  				sheet1.SetCellValue(i, "cust_cnt_cd",trd_party_val.substring(0,2),0);
  				sheet1.SetCellValue(i, "cust_seq",trd_party_val.substring(2,8),0);
  				sheet1.SetCellValue(i, "vndr_seq","",0);
  				sheet1.SetCellValue(i, "n3pty_ofc_cd","",0);
  			}else if( vndr_cust_div_cd == 'S' ){
  				sheet1.SetCellValue(i, "n3pty_ofc_cd",trd_party_val,0);
  				sheet1.SetCellValue(i, "vndr_seq","",0);
  				sheet1.SetCellValue(i, "cust_cnt_cd","",0);
  				sheet1.SetCellValue(i, "cust_seq","",0);
  			}
  		}
      }
      /**
       * Controlling keyboard input in onkeypress event of HTML Control
       **/
   	function obj_Keypress(){
   		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   		var srcName=ComGetEvent("name");
   		var srcValue=event.srcElement.getAttribute("value");
   		switch(event.srcElement.dataformat) {
   		case "engupnum"://upper case, numbers input
   			ComKeyOnlyAlphabet('uppernum', "45"); 
   			break;
   		default:     //alphabet + numbers
   			ComKeyOnlyAlphabet('uppernum'); break;
   		}
   	}
	/* Finishing work */
