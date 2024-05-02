/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0103.js
*@FileTitle  : Repair Estimate EDI Auditing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
 
    /* Global Variables */
	  //var calPop = new calendarPopupGrid();
	  var curTab=1;
	  var beforetab=0;
	  var sheetObjects=new Array();
	  var sheetCnt=0;
	  var rmk_chk=0;
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
  	function loadPage(p_state) {
  		for(i=0;i<sheetObjects.length;i++){
  			//Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}  
  		if(p_state != 1){
  			changeExpenseType(document.form);
  		}
  		document.form.s_n3pty_bil_tp_cd.onchange=s_n3pty_bil_tp_cd_OnChange; 
  		document.form.s_bkg_no_all.onblur=s_bkg_no_all_OnBlur; 
  		document.form.s_bl_no_all.onblur=s_bl_no_all_OnBlur;
  		document.form.s_vvd.onblur=s_vvd_OnBlur;
  		document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange;
  		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
  		document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur1;
  		document.form.s_if_rmk.onfocus=s_if_rmk_OnFocus;
  		 document.form.s_src_vndr_no.onblur = s_src_vndr_no_OnBlur;
  		if(p_state != 1){
  			getTPBGenCombo('s_curr_cd','searchCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd"));
  		}
  		if(p_state == 1){ // In case of pop-up status
  			statusLoad(sheetObjects[0],p_state);
  		}
  	  	document.form.s_if_rmk.value=" Max. 1,000 charactors allowed as the remark.\n" +
  	  				" If more, please attach it with file afer 'Confirmation'";
  	  	
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
  				with (sheetObj) {
  					var cnt=0;
  					
  					
  					(7, 0, 0, true);
  					var HeadTitle="Del.|STS|SEQ|EQ Kind|EQ No.|EQ Type Size|Amount";

  					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

  					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  					var headers = [ { Text:HeadTitle, Align:"Center"} ];
  					InitHeaders(headers, info);

  					var cols = [ {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
  					             {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
  					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ots_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
  					             {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
  					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
  					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
  					             {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",       KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
  					 
  					InitColumns(cols);
  					//SetSheetHeight(300);
  					ComResizeSheet(sheetObjects[0]);
  					
  					SetColProperty("eq_knd_cd", {ComboText:"|"+combo01Text, ComboCode:"|"+combo01Code} );
  					
  					SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	  				SetColProperty(0 ,"eq_tpsz_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
  					
  					SetEditable(1);
  					SetColHidden("ots_dtl_seq",1);
  				}
  				break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "bttn_preview":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_excel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_loadexcel":
   					sheetObject.LoadExcel();
  					break;
  				case "btn_vvd":
  					if(formObject.p_state.value == "1")break
  					var param='?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 420, 'getVVD', '1,0,1,1,1,1,1,1', true);
  					break;
  				case "btn_3rdParty":
  					if(formObject.p_state.value == "1")
  					{
  						var theURL="COM_ENS_041.do";
  	  			      	var features="scroll:no;status:no;help:no;dialogWidth:820px;dialogHeight:420px";
  	  			      	var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
  					}
  					else
  					{
  						get3rdParty( document.all.s_vndr_cust_div_cd.value );
  						
  					}
  					break;
  				case "btn_3rdParty_v":
  					if(formObject.p_state.value == "1")break
  					get3rdParty( "SP" );
  					break;
  				case "btn_location":
  					if(formObject.p_state.value == "1")break
  					 if(!window.event.srcElement.disabled){
  						var param="";
  						ComOpenPopup('/opuscntr/COM_ENS_051.do'+ param, 770, 410, 'getLocation', '1,0,1,1,1,1,1,1');
  				     }
  					break;
  				case "btns_calendar1":
  					if(formObject.p_state.value == "1")break
  					var cal=new ComCalendar();
  					cal.select(formObject.s_if_dt, 'yyyy-MM-dd');
  					break;
  				case "btn_new":
  					formObject.reset();
  					ComClearCombo(formObject.s_n3pty_bil_tp_cd);
  					ComAddComboItem(formObject.s_n3pty_bil_tp_cd, '', '<<Select>>');
  					document.all.s_n3pty_src_no.className="input1";
  					document.all.s_src_vndr_no.className="input1";
  					document.all.s_bkg_no_all.className="input1";
  					sheetObject.RemoveAll();
  			  	  	document.form.s_if_rmk.value=" Max. 1,000 charactors allowed as the remark.\n" +
  	  				" If more, please attach it with file afer 'Confirmation'";	
  			  	    rmk_chk=0 ;
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('TPB90014');
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				//Checking length of input value
  				var lenArr=new Array();
  				lenArr[0]=new Array(formObj.s_bkg_no_all,'BKG No',formObj.s_bkg_no_all.getAttribute("maxlength"),11);
  				lenArr[1]=new Array(formObj.s_bl_no_all,'B/L No',formObj.s_bl_no_all.getAttribute("maxlength"));
  				lenArr[2]=new Array(formObj.s_vvd,'VVD',formObj.s_vvd.getAttribute("maxlength"));
  				if(!checkFormLength(lenArr)){
  					return false;
  				}
  				//Checking Remarks value length
  				var rmkLen=formObj.s_if_rmk.value.length;
  				if(1000 < rmkLen){
  					ComShowCodeMessage("COM12142","Remarks","1000");
  					formObj.s_if_rmk.focus();
  					return false;
  				}
  				//Dividing input value
  				formObj.s_bkg_no.value=formObj.s_bkg_no_all.value;
  				formObj.s_bl_no.value=formObj.s_bl_no_all.value;
  				formObj.s_vsl_cd.value=formObj.s_vvd.value.substring(0,4);
  				formObj.s_skd_voy_no.value=formObj.s_vvd.value.substring(4,8);
  				formObj.s_skd_dir_cd.value=formObj.s_vvd.value.substring(8,9);
  				formObj.s_n3pty_src_no.value=ComTrim(formObj.s_n3pty_src_no.value);
  				formObj.s_src_vndr_no.value=ComTrim(formObj.s_src_vndr_no.value);
  				formObj.s_src_vndr_seq.value=formObj.s_src_vndr_no.value;
  				formObj.f_cmd.value=ADD;
  				// sheetObj.DataInsert();
  				var s_if_ofc_cd=formObj.s_if_ofc_cd.value;
  				var s_eq_no=getEqNoArrayString(sheetObj);
  				var s_bkg_no=formObj.s_bkg_no.value;
  				//Setting isChecked for VVD checking
  				if( document.form.isChecked.value == "0" && ComTrim(document.form.s_vvd.value).length != 0 ){
  	  				ComShowCodeMessage('TPB90072');
  					return;
  				}
//  				var p_state=document.form.p_state.value;
//  				if( p_state == 1){
//              		var pTpbState="";
//              		if(sheetObj.RowCount()>0){
//    		      		for( i=0 ; i<sheetObj.RowCount()-1 ; i++ ){
//    		      			pTpbState += sheetObj.GetCellValue(i+1,'ots_dtl_seq') + "|$|";
//    		      		}
//    		      		pTpbState += sheetObj.GetCellValue(sheetObj.RowCount(),'ots_dtl_seq');
//              		}
//              	}
  				// Controlling Rmk in case of not changed remark saved
  				if(rmk_chk == 0){
  			  	  	document.form.s_if_rmk.value="";		
  				}
				openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no);
//				var duplicationCheckAndSave=openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no);
//                  if ( duplicationCheckAndSave != null && duplicationCheckAndSave == true ) {
//                	  sheetObj.DoSave("ESD_TPB_0103GS.do", tpbFrmQryStr(formObj), "ibflag", false);
//                  	if( p_state == 1){
//                  		window.returnValue=pTpbState;
//                  		ComClosePopup(); 
//                  	}
//                  }
                break;
  			case IBINSERT:	  //Insert
  				if ( document.form.s_bkg_no_all.value.length >= 11 && document.form.s_bkg_no_all.value.length <= 13 ) {
  					openContainerPopup( document.form.s_bkg_no_all.value);
  				}else{
  					sheetObj.DataInsert();
  					s_tpb_seq(sheetObj, sheetObj.GetSelectRow());
  				}
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //Excel download
  				sheetObj.Down2Excel(TPBDown2ExcelOptions);
  				break;
  		}
  	}
  	
  	function saveTPBMenual(rtnVal) {
  		var sheetObj=sheetObjects[curTab-1];
  		var formObj=document.form;
  		var p_state=document.form.p_state.value;
			if( p_state == 1){
      		var pTpbState="";
      		if(sheetObj.RowCount()>0){
	      		for( i=0 ; i<sheetObj.RowCount()-1 ; i++ ){
	      			pTpbState += sheetObj.GetCellValue(i+1,'ots_dtl_seq') + "|$|";
	      		}
	      		pTpbState += sheetObj.GetCellValue(sheetObj.RowCount(),'ots_dtl_seq');
      		}
      	}
  		
  		var duplicationCheckAndSave = rtnVal.duplicationFlag;
  		if ( duplicationCheckAndSave != null && duplicationCheckAndSave == true ) {
      	  sheetObj.DoSave("ESD_TPB_0103GS.do", tpbFrmQryStr(formObj), "ibflag", false);
        	if( p_state == 1){
//        		window.returnValue=pTpbState;
        		if(opener!=null && opener!=undefined){
        			opener.callBackReturn(pTpbState);
        		}
        	}
        }
    }
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  			if(document.all.s_n3pty_src_no.className == "input1"){
  				if(s_n3pty_src_no.value == ""){
  					ComShowCodeMessage('TPB90085',Msg_Required);
  					s_n3pty_src_no.focus();
  					return false;
  				}
  			}
  			if(document.all.s_src_vndr_no.className == "input1"){
  				if(s_src_vndr_no.value == ""){
  					ComShowCodeMessage('TPB90086',Msg_Required);
  					s_src_vndr_no.focus();
  					return false;
  				}
  			}
  			if(document.all.s_bkg_no_all.className == "input1"){
  				if(s_bkg_no_all.value == ""){
  					ComShowCodeMessage('TPB90087',Msg_Required);
  					s_bkg_no_all.focus();
  					return false;
  				}
  			}
  		}
        // Checking amount over 0 in sheet 	
  		for(i=1;i<=sheetObjects[0].RowCount(); i++) {
  			if_amt=sheetObjects[0].GetCellValue(i, "if_amt");
  			if ( if_amt - 0.0 <= 0.0 ) {
  				ComShowCodeMessage('TPB90078', 'Amount'); 
  				sheetObjects[0].SelectCell(i, "if_amt");
  				return false;
  			}
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('TPB90075','Data','','');
  			sheetObj.RemoveAll();
  		}
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnChange
  	 */
  	function sheet1_OnChange(sheetObj, Row, Col, Value){
  		var colNm=sheetObj.ColSaveName(Col);
  		// Checking digit container EQ No.
  		if( colNm == 'eq_no' && Value != '' && sheetObj.GetCellValue(Row,'eq_knd_cd')!=''	||
  				colNm == 'eq_knd_cd' && Value != '' && sheetObj.GetCellValue(Row,'eq_no')!='')
  		{
  			Value=sheetObj.GetCellValue(Row,'eq_no');
  			document.form.s_eq_no.value=Value;
  			document.form.s_eq_knd_cd.value=sheetObj.GetCellValue(Row,'eq_knd_cd');
  			getTPBGenCombo('CheckEqNo','checkEqNo','V','','',new Array('s_eq_knd_cd','s_eq_no'),Value, Row);
  		}
  		if( colNm == 'eq_no' && Value != '' && sheetObj.GetCellValue(Row,'eq_knd_cd') == '')
  		{	
 			ComShowMessage(ComGetMsg('COM12119','EQ Kind'));
  			sheetObj.SetCellValue(Row,'eq_no','');
  		}
  	}
  	/**
  	 *  OnChange event function of Billing Type code
  	 */
  	function s_n3pty_bil_tp_cd_OnChange(){
  		// getEqInfo();
  	}
  	/**
  	 * OnChange event function of BKG No. 
  	 * Getting BL No.
  	 */
  	 function s_bkg_no_all_OnBlur(){
  		 getBLNo( document.form, document.form.s_bkg_no_all, 's_' );
  	 }
  	/**
  	 * OnChange event function of BL No. 
  	 * Getting BKG No.
  	 */
       function s_bl_no_all_OnBlur(){
           var bl_no=document.form.s_bl_no_all.value; 
           var bkg_no=document.form.s_bkg_no_all.value; 
           // if ( bl_no.length==12 && ( ComTrim(bkg_no).length!=11 && ComTrim(bkg_no).length!=13 ) ){
           if ( bl_no.length==12 && bkg_no.length==0 ){
               getTPBGenCombo('s_bkg_no_all','checkBKGNoWithBLNo','T','','',new Array("s_bl_no_all"));  
           } 
       }
  	/**
  	 * This function is removing TRS,TES,POR by Expense Type Combo
  	 */
  	function deleteExpenseType(obj){
  		if(obj != null && obj.length > 0){
  			for(var i=0, j=obj.length; i<j; i++){
  				if(obj.options[i] != null){
  					var sValue=obj.options[i].value;
  					if(sValue == 'TRS' || sValue == 'TES' || sValue == 'POR'){
  						obj.remove(i);
  						j--;
  						deleteExpenseType(obj);
  					}
  				}
  			}
  		}
  	}
  	/**
  	 * This function is making Billing Case Combo by Expense Type
  	 */
  	function changeBillingCase(f){
  		var ifVal=f.s_n3pty_if_tp_cd.value;
  		var expVal=f.s_n3pty_expn_tp_cd.value;
  		if(ifVal == "S"){
  			if(expVal != ""){
  				if(expVal == "MNR"){
  					document.all.s_n3pty_src_no.className="";
  					document.all.s_src_vndr_no.className="";
  					document.all.s_bkg_no_all.className="";
  				}else{
  					document.all.s_n3pty_src_no.className="";
  					document.all.s_src_vndr_no.className="";
  					if(expVal == "TES"){
  						document.all.s_bkg_no_all.className="";
  					}else{
  						document.all.s_bkg_no_all.className="input1";
  					}
  					
  				}
  			}
  		}else if(ifVal == "M"){
  			document.all.s_n3pty_src_no.className="";
  			document.all.s_src_vndr_no.className="";
//  			document.all.bkg_no_class.className="";
  		}else{
  			document.all.s_n3pty_src_no.className="input1";
  			document.all.s_src_vndr_no.className="input1";
  			document.all.s_bkg_no_all.className="input1";
  		}
  		if(expVal == ""){
  			ComClearCombo(f.s_n3pty_bil_tp_cd);
  			ComAddComboItem(f.s_n3pty_bil_tp_cd, "", "");
  		}else{
  			var p_state=document.form.p_state.value;
  			if(p_state == 1){
  				getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_bil_tp_cd", "s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd", "s_jo_display"),"CI");
  			}else{
  				getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_bil_tp_cd", "s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd", "s_jo_display"));
  			}
  		}
  	}
  	function delRowCount(sheetObj){
  		for ( var i=0; i <= sheetObj.RowCount(); i++ ){
  			if(sheetObj.GetCellValue(i,'ibflag') == 'D'){
  				return false;
  			}
  		}
  		return true;
  	}
  	function getFileNo(fileNoReceive){
  		document.form.s_file_no.value=fileNoReceive;
  	}
  	function changeExpenseType(f){
  		var s_n3pty_if_tp_cd=f.s_n3pty_if_tp_cd.value;
  		if(s_n3pty_if_tp_cd == ""){
  			document.all.sheet_bg.style.display="";
  			ComClearCombo(f.s_n3pty_expn_tp_cd);
  			ComAddComboItem(f.s_n3pty_expn_tp_cd, "", "<<Select>>");
  		}else{
  			getTPBGenCombo('s_n3pty_expn_tp_cd','searchExpenseType','F','','2',new Array("s_n3pty_if_tp_cd"));
  		}
  		ComClearCombo(f.s_n3pty_bil_tp_cd);
  		ComAddComboItem(f.s_n3pty_bil_tp_cd, "", "");
  	}
      function openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no){ 
      	var theURL="ESD_TPB_0801.do";
      	theURL += "?s_if_ofc_cd=" + s_if_ofc_cd;
      	theURL += "&s_eq_no=" + s_eq_no;
      	theURL += "&s_bkg_no=" + s_bkg_no;
        // ComShowMessage( theURL );
      	//var features="scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:460px";
//      	var rtnValue =  ComOpenPopupWithTarget(theURL,  800, 460 , "", "none", true);
//     	return rtnValue;
      	ComOpenPopup(theURL, 600, 330, "saveTPBMenual", "0,0,1,1,1,1,1", true);
      }
      function openContainerPopup(s_bkg_no){
      	var theURL="ESD_TPB_0811POP.do";
      	theURL += "?s_bkg_no=" + s_bkg_no;
      	ComOpenPopup(theURL, 500, 350, "getContainerCallBack", "0,1", true);
      }
      
      function getContainerCallBack(resultArr){
    	  if(resultArr.length > 0 ){
				var tempArr;
				for( i=0 ; i<resultArr.length ; i++ ){
					tempArr=resultArr[i].split('|$|');
					sheetObjects[0].DataInsert(-1);
					s_tpb_seq(sheetObjects[0], i+1);
					sheetObjects[0].SetCellValue(i+1,'eq_no',tempArr[0],0);
					if(tempArr[0]!=''){
						sheetObjects[0].SetCellValue(i+1,'eq_knd_cd','U',0);
					}
					sheetObjects[0].SetCellValue(i+1,'eq_tpsz_cd',tempArr[1],0);
				}
			}
      }
      
      function getEqNoArrayString(sheetObj){ 
  		var str='';
  		if(sheetObj.RowCount()> 0){
  			for ( var i=1; i <= sheetObj.RowCount(); i++ ){
  				str += sheetObj.GetCellValue(i,'eq_no')+"|";
  			}
  		}
  		return str;
      }
      /* s_vvd_OnBlur
       * Checking vvd make use of IFRAME
       */
      function s_vvd_OnBlur(){
      	if( document.form.s_vvd != undefined && document.form.s_vvd.value != '' ){
      		document.form.isChecked.value='0';
      		if( document.form.s_vvd.value.length == 9 ){
  		    	// Checkking vvd make use of IFRAME
  				var f=document.frames;
  				var ifr = "0";
  				if(f != undefined){
  					ifr = eval("frame_"+f).length;
  				} else {
  					ifr = "frame_0";
  				}
  				
  				var o=document.createElement("DIV");
  				o.style.display="none";
  				o.innerHTML='<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
  				document.body.appendChild(o);
  				eval(ifr).location.href = "TPBCommonCode.do?mode=T&id=s_vvd&method=searchCheckVVD&s_vvd="+document.form.s_vvd.value + "&otherObjs=" + document.form.s_if_ofc_cd.value ;
  			}else{
  				ComShowCodeMessage('TPB90070');
  				document.form.s_vvd.value='';
  				document.form.s_vvd.focus();
  			}
      	}
      }
      /* s_src_vndr_no_OnBlur
      * 
      * Checking S/P make use of IFRAME
      */
      function s_src_vndr_no_OnBlur()
      {
    	  if( document.form.s_src_vndr_no != undefined && document.form.s_src_vndr_no.value != '' )
    	  {
    		  if( ComIsNumber(document.form.s_src_vndr_no) == false )
    		  {
    			  ComShowCodeMessage('TPB90071');
    			  document.form.s_src_vndr_no.value='';
    			  document.form.s_src_vndr_no.focus();
    		  } else
    		  {
        		  getTPBGenCombo('CheckVendorCode','checkVendorCode','V','','',new Array('s_src_vndr_no'));
    		  }
    	  }
      }
     function s_tpb_seq(sheetObj, selectRow){
       	getTPBGenCombo('s_tpb_seq','getTPBSeq','T','','','',selectRow);
     }
     /* comboPopupLoad
      * Impossible to not selected combo in case of pop-up
      */
      function comboPopupLoad(comboName){
    	  var value=comboName.value;
    	  var text=comboName.options[comboName.selectedIndex].text;
    	  ComClearCombo(comboName);
    	  ComAddComboItem(comboName, value, text);
      }
     /**
	  * This function is removing TRS,TES,POR by Expense Type Combo
	  */
	  function deleteExpenseType(obj){
		if(obj != null && obj.length > 0){
			for(var i=0, j=obj.length; i<j; i++){
				if(obj.options[i] != null){
					var sValue=obj.options[i].value;
					if(sValue == 'TRS' || sValue == 'TES' || sValue == 'POR'){
						obj.remove(i);
						j--;
						deleteExpenseType(obj);
					}
				}
			}
		}
	  }
      function statusLoad(sheetObj,p_state){
  		if(p_state == 1){ // In case of pop-up status
  			sheetObj.SetEditable(0);
  			document.getElementById('btn_add').style.display='none';
	  		document.getElementById('btn_new').style.display='none';
	  		//document.getElementById('btn1_line').style.display='none';
    		ComSetObjValue(document.form.s_n3pty_expn_tp_cd, "TES");
  			ComSetObjValue(document.form.s_curr_cd, document.form.p_curr_cd.value);
  			document.form.s_n3pty_src_no.value=" ";
  			document.form.s_src_vndr_no.value=" ";
  			changeBillingCase(document.form);
  			document.form.s_n3pty_src_no.className="";
			document.form.s_src_vndr_no.className="";
  			var p_eq_no=document.form.p_eq_no.value;
  			var p_eq_tpsz_cd=document.form.p_eq_tpsz_cd.value;
  			var p_if_amt=document.form.p_if_amt.value;
			if( p_eq_no.length > 0 ){
				var pEqNoTempArr;
				var pEqTpszCdTempArr;
				var pIfAmtTempArr;
				pEqNoTempArr=p_eq_no.split('|$|');
				pEqTpszCdTempArr=p_eq_tpsz_cd.split('|$|');
				pIfAmtTempArr=p_if_amt.split('|$|');
				for(i=0;i<pEqNoTempArr.length;i++){
					var row = sheetObj.DataInsert(-1);
					s_tpb_seq(sheetObj,row);
					sheetObj.SetCellValue(row,'eq_no',pEqNoTempArr[i],0);
					sheetObj.SetCellValue(row,'eq_knd_cd','U',0);
					sheetObj.SetCellValue(row,'eq_tpsz_cd',pEqTpszCdTempArr[i],0);
					sheetObj.SetCellValue(row,'if_amt',pIfAmtTempArr[i],0);
				}
			}
			document.form.s_n3pty_src_no.readOnly=true;
			document.form.s_src_vndr_no.readOnly=true;
			document.form.s_bkg_no_all.readOnly=true;
			document.form.s_bl_no_all.readOnly=true;
			document.form.s_if_dt.readOnly=true;
			document.form.s_vvd.readOnly=true;
			document.form.s_yd_cd.readOnly=true;
			s_trd_party_val_OnBlur();
			comboPopupLoad(document.form.s_curr_cd);
			comboPopupLoad(document.form.s_n3pty_expn_tp_cd);
			comboPopupLoad(document.form.s_n3pty_bil_tp_cd);
    	}
  	}

    function s_trd_party_val_OnBlur1(){
    	s_trd_party_val_OnBlur(document.form.s_vndr_cust_div_cd.value);
    } 
      
    //Setting limit Remark
    function s_if_rmk_OnFocus(){
    	if(rmk_chk == 0){
    		document.form.s_if_rmk.value="";
		}
    	rmk_chk=1;
    }
    /* Finishing work */
