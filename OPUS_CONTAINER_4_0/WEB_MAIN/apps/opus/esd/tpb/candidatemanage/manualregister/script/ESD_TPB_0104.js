/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0104.js
*@FileTitle  : EAC Registration 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/

/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESD_TPB_0104 : Defining logic script for ESD_TPB_0104 screen
 */
    /* Global Variables */
	  var curTab=1;
	  var beforetab=0;
	  var sheetObjects=new Array();
	  var sheetCnt=0;
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
  		 formObject = document.form;
	   	 var objs=document.all.item("tabLayer");
	   	 objs[nItem].style.display="Inline";
	   	 for(var i = 0; i< objs.length; i++){
	       	  if(i != nItem){
		        	   objs[i].style.display="none";
		        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
	   	}
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
  			ComEndConfigSheet(sheetObjects[i]);
  		}
//  		document.form.s_n3pty_bil_tp_cd.onchange=s_n3pty_bil_tp_cd_OnChange; 
//  		document.form.s_bkg_no_all.onblur=s_bkg_no_all_OnBlur; 
//  		document.form.s_bl_no_all.onblur=s_bl_no_all_OnBlur; 
//  		document.form.s_vvd.onblur=s_vvd_OnBlur;
//  		document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange;
//  		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
//  		document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur;
//  		document.form.s_src_vndr_no.onblur = s_src_vndr_no_OnBlur;
  		getTPBGenCombo('s_curr_cd','searchEACCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd"));
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
				      var HeadTitle="Del.|STS|EQ Kind|EQ No.|EQ Type Size|Amount";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
				             {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      
				      SetColProperty("eq_knd_cd", {ComboText:"|"+combo01Text, ComboCode:"|"+combo01Code} );
				      
				      SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	  				  SetColProperty(0 ,"eq_tpsz_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	  				  
				      SetSheetHeight(280);
                  }
   				break;
   		}
   	}
   	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		 try {
  			var srcName=ComGetEvent("name");
  			if(ComGetBtnDisable(srcName)) return false;
  			with(document.form) {
  				switch (srcName) {
	  				case "btn_add":
	  					doActionIBSheet(sheetObject,formObject,IBINSERT);
	  					break;
  					case "btn_save":
  						doActionIBSheet(sheetObject,formObject,IBSAVE);
  						break;
  	  				case "btn_vvd":
  	  					var param='?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  	  					ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  	  					break;
  					case "btn_3rdParty":
  						get3rdParty( document.all.s_vndr_cust_div_cd.value );
  						break;
  					case "btn_3rdParty_v":
  						get3rdParty( "SP" );
  						break;
  					case "btn_new":
  						formObject.reset();
  						sheetObject.RemoveAll();
  						break;
  	  				case "btn_location":
  	  					 if(!window.event.srcElement.disabled){
  	  						var param="";
  	  						ComOpenPopup('/opuscntr/COM_ENS_051.do'+ param, 770, 470, 'getLocation', '1,0,1,1,1,1,1,1');
  	  				     }
  	  					break;
  	  				case "btns_calendar1":
  	  					var cal=new ComCalendar();
  	  					cal.select(formObject.s_if_dt, 'yyyy-MM-dd');
  	  					break;
  				} // end switch
  			}// end with
  		} catch(e) {
  			if( e="[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing file upload - Getting fileNo  */
  	function getFileNo(fileNoReceive){
  		document.form.s_file_no.value=fileNoReceive;
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
				sheetObj.DoSearch("ESD_TPB_0104GS.do", tpbFrmQryStr(formObj) );
				break;
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
  				//Dividing input value
  				formObj.s_bkg_no.value=formObj.s_bkg_no_all.value;
  				formObj.s_bl_no.value=formObj.s_bl_no_all.value;
  				formObj.s_vsl_cd.value=formObj.s_vvd.value.substring(0,4);
  				formObj.s_skd_voy_no.value=formObj.s_vvd.value.substring(4,8);
  				formObj.s_skd_dir_cd.value=formObj.s_vvd.value.substring(8,9);
  				formObj.s_src_vndr_seq.value=formObj.s_src_vndr_no.value;
  				formObj.f_cmd.value=ADD;
  				// sheetObj.DataInsert();
  				var s_if_ofc_cd=formObj.s_if_ofc_cd.value;
  				var s_eq_no=getEqNoArrayString(sheetObj); // '|' Indicator 
  				var s_bkg_no=formObj.s_bkg_no.value;
  				if( document.form.isChecked.value == "0" && ComTrim(document.form.s_vvd.value).length != 0 ){
  					ComShowCodeMessage('TPB90072');
  					return;
  				}
  				//Setting isChecked for VVD checking 				
  				var duplicationCheckAndSave=openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no);
                  if ( duplicationCheckAndSave != null && duplicationCheckAndSave == true ) {
                	  sheetObj.DoSave("ESD_TPB_0104GS.do", tpbFrmQryStr(formObj), "ibflag", false);
                  }
                  sheetObj.RemoveAll();
  				break;
  			case IBINSERT:	  //Insert
				if ( document.form.s_bkg_no_all.value.length >= 11 && document.form.s_bkg_no_all.value.length <= 13 ) {
  					var resultArr=openContainerPopup( document.form.s_bkg_no_all.value);
  					if( resultArr.length > 0 ){
  						var tempArr;
  						for( i=0 ; i<resultArr.length ; i++ ){
  							tempArr=resultArr[i].split('|$|');
  							sheetObj.DataInsert(i);
  							sheetObj.SetCellValue(i+1,'eq_no',tempArr[0],0);
  							if(tempArr[0]!=''){
  								//sheetObj.CellValue2(i+1,'eq_tp_cd') = 'C';
  								sheetObj.SetCellValue(i+1,'eq_knd_cd','U',0);
  							}
  							sheetObj.SetCellValue(i+1,'eq_tpsz_cd',tempArr[1],0);
  						}
  					}
  				}else{
  					sheetObj.DataInsert();
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
  			ComShowMessage(ComGetMsg('COM12149','Data','',''));
  			sheetObj.RemoveAll();
  		} 				
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnChange
  	 * 
  	 */
  	function sheet1_OnChange(sheetObj, Row, Col, Value){
  		var colNm=sheetObj.ColSaveName(Col);
  		//Checking digit container EQ No.
  		if( colNm == 'eq_no' && Value != '' && sheetObj.GetCellValue(Row,'eq_knd_cd')!=''	|| colNm == 'eq_knd_cd' && Value != '' && sheetObj.GetCellValue(Row,'eq_no')!='')
  	  	{
  			Value=sheetObj.GetCellValue(Row,'eq_no');
  	  		document.form.s_eq_no.value=Value;
  	  		document.form.s_eq_knd_cd.value=sheetObj.GetCellValue(Row,'eq_knd_cd');
  	  		getTPBGenCombo('CheckEqNo','checkEqNo','V','','',new Array('s_eq_knd_cd','s_eq_no'),Value);
  	  	}
  		if( colNm == 'eq_no' && Value != '' && sheetObj.GetCellValue(Row,'eq_knd_cd') == '')
  		{	
 			ComShowMessage(ComGetMsg('COM12119','EQ Kind'));
  			sheetObj.SetCellValue(Row,'eq_no','');
  		}
  	}
  	/**
  	 * OnChange event function of Billing Type code
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
        if ( bl_no.length==12 && bkg_no.length==0 ){
            getTPBGenCombo('s_bkg_no_all','checkBKGNoWithBLNo','T','','',new Array("s_bl_no_all"));  
        } 
    }
   	 /* s_vvd_OnBlur
      * Checking vvd make use of IFRAME
      */
     function s_vvd_OnBlur(){
     	if( document.form.s_vvd != undefined && document.form.s_vvd.value != '' ){
     		document.form.isChecked.value='0';
     		if( document.form.s_vvd.value.length == 9 ){
 		    	//Checking vvd make use of IFRAME
 				var f=document.frames;
 				var ifr="frame_"+f.length;
 				var o=document.createElement("DIV");
 				o.style.display="none";
 				o.innerHTML='<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
 				document.body.appendChild(o);
 				eval("document."+ifr).location.href  ="TPBCommonCode.do?mode=T&id=s_vvd&method=searchCheckVVD&s_vvd="+document.form.s_vvd.value + "&otherObjs=" + document.form.s_if_ofc_cd.value ;
 			} else{
 				ComShowCodeMessage('TPB90070');
 				document.form.s_vvd.value='';
// 				document.form.s_vvd.focus();
 			}
     	}
     }
     /* s_src_vndr_no_OnBlur
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
//   			  document.form.s_src_vndr_no.focus();
   		  } else
   		  {
       		  getTPBGenCombo('CheckVendorCode','checkVendorCode','V','','',new Array('s_src_vndr_no'));
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
  					//ComShowMessage("'S/P Invoice No' " + Msg_Required);
  					ComShowCodeMessage('TPB90085',Msg_Required);
//  					s_n3pty_src_no.focus();
  					return false;
  				}
  			}
  			if(document.all.s_src_vndr_no.className == "input1"){
  				if(s_src_vndr_no.value == ""){
  					//ComShowMessage("'S/P' " + Msg_Required);
  					ComShowCodeMessage('TPB90086',Msg_Required);
//  					s_src_vndr_no.focus();
  					return false;
  				}
  			}
  			if(document.all.s_bkg_no_all.className == "input1"){
  				if(s_bkg_no_all.value == ""){
  					//ComShowMessage("'Booking No' " + Msg_Required);
  					ComShowCodeMessage('TPB90087',Msg_Required);
//  					s_bkg_no_all.focus();
  					return false;
  				}
  			}
  			if(document.all.s_vndr_cust_div_cd.className == "input1"){
  				if(s_src_vndr_no.value == ""){
  					//ComShowMessage("'3rd Party' " + Msg_Required);
  					ComShowCodeMessage('TPB90088',Msg_Required);
//  					s_vndr_cust_div_cd.focus();
  					return false;
  				}
  			}
  			if(document.all.s_trd_party_val.className == "input1"){
  				if(s_trd_party_val.value == ""){
  					//ComShowMessage("'3rd Party Value' " + Msg_Required);
  					ComShowCodeMessage('TPB90089',Msg_Required);
//  					s_trd_party_val.focus();
  					return false;
  				}
  			}
  			if(document.all.s_trd_party_nm.className == "input1"){
  				if(s_trd_party_nm.value == ""){
  					//ComShowMessage("'3rd Party Name' " + Msg_Required);
  					ComShowCodeMessage('TPB90090',Msg_Required);
//  					s_trd_party_nm.focus();
  					return false;
  				}
  			}
  		}
  		//Checking amount over 0 in sheet
  		for(i=1;i<=sheetObjects[0].RowCount(); i++) {
  			if_amt=sheetObjects[0].GetCellValue(i, "if_amt");
  			if ( if_amt - 0.0 <= 0.0 ) {
  				ComShowMessage( ComGetMsg ('COM12114', 'Amount') ); 
  				sheetObjects[0].SelectCell(i, "if_amt");
  				return false; 
  			}
  		}
  		return true;
  	}
	/**
	 * This function is making Billing Case Combo by Expense Type
	 */
	function changeBillingCase(f){
		var expVal=f.s_n3pty_expn_tp_cd.value;
		if(expVal == ""){
			ComClearCombo(f.s_n3pty_bil_tp_cd);
			ComAddComboItem(f.s_n3pty_bil_tp_cd, "", "<<Select>>");
		}else{
			getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_bil_tp_cd", "s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd", "s_jo_display")); 
  			if(expVal == "MNR"){
  				document.all.s_bkg_no_all.className="";
  			}else{
  				document.all.s_bkg_no_all.className="input1";
  			}
		}
	}
      function openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no){
      	var theURL="ESD_TPB_0801.do";
      	theURL += "?s_if_ofc_cd=" + s_if_ofc_cd;
      	theURL += "&s_eq_no=" + s_eq_no;
      	theURL += "&s_bkg_no=" + s_bkg_no;
          // ComShowMessage( theURL );
      	var features="scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:460px";
      	var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
     	return rtnValue;
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
      
      function openContainerPopup(s_bkg_no, s_bkg_no_split){
      	var theURL="ESD_TPB_0811.do";
      	theURL += "?s_bkg_no=" + s_bkg_no;
      	theURL += "&s_bkg_no_split=" + s_bkg_no_split;
      	var features="scroll:no;status:no;help:no;dialogWidth:340px;dialogHeight:350px";
      	var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
      	return rtnValue;
      }