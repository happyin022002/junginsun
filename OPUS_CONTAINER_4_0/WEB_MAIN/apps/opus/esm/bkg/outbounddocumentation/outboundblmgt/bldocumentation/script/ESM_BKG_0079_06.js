/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_06.js
*@FileTitle  : Marks & Number/Description of Goods
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var wgt_ut_idx=0;
	var meas_ut_idx=0;
	var frt_term_idx=0;
	var scrnAuth='';
	var descFlag=false;
	// Event handler processing by button click event */ 
	document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
	// Event handler processing by button name */
	function processButtonClick(){
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display="none";
        		}    	    			
    		}
			switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				case "btn_copy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
				break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
				break;
				case "btn_t8New":
					formObject.reset();
					formObject.bkg_no.value='';
				break;
				case "btn_t8Save":
					doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
				case "btn_t8CopyfromDG":
					doActionIBSheet(sheetObject2, formObject, SEARCH02);
				break;
				case "btn_t8CopyfromCM":
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0707.do?func=callbackCmdtDesc&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0707", 650, 400, true);
				break;
				case "btn_t8CopyfromHouseBL":
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0360.do?func=callbackCopyFromHBL&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0360", 750, 500, true);
				break;
				case "find_tmplt_t":
					var bkg_no=formObject.bkg_no.value;
					ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=T&rtn=ttl_pck_desc&bkg_no="+bkg_no, "MnD Template", 600, 410, true);
				break;
				case "find_tmplt_m":
					var bkg_no=formObject.bkg_no.value;
					ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=M&rtn=mk_desc&bkg_no="+bkg_no, "MnD Template", 600, 410, true);
				break;
				case "find_tmplt_d":
					var bkg_no=formObject.bkg_no.value;
					ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=D&rtn=dg_cmdt_desc&bkg_no="+bkg_no, "MnD Template", 600, 410, true);
				break;
				case "btn_t8ExportImportInfo":
					var bkg_no=formObject.bkg_no.value;
					var pkg_qty=formObject.pck_qty.value;
					var pkg_tp=formObject.pck_tp_cd.value;
					var wgt_qty=formObject.act_wgt.value;
					var wgt_tp=formObject.wgt_ut_cd.value;
					var pol_cd=formObject.pol_cd.value;
					var pod_cd=formObject.pod_cd.value;
					if(bkg_no == ''){
						alert("Booking No. is Mandantory. Please input Booking No.!");
						formObject.bkg_no.focus();
						return;
					}

					//2015.03.04 Change default to Brazil
//					var url="ESM_BKG_0361_01.do";
					var url="ESM_BKG_0361_03.do";
					if(pol_cd!=''){
						switch(pol_cd.substring(0,2)) {
							case "US":
								url="ESM_BKG_0361_01.do";
							break;
							case "KR":
								url="ESM_BKG_0361_02.do";
							break;
							case "BR":
								url="ESM_BKG_0361_03.do";
							break;
							case "IN":
								url="ESM_BKG_0361_04.do";
							break;
							case "ID":
								url="ESM_BKG_0361_05.do";
							break;
							case "CA":
								url="ESM_BKG_0361_06.do";
							break;
						}
					}
					url += "?popUpTpCd=B&io_bnd_cd=O&bkg_no=" + bkg_no + "&pkg_qty=" + pkg_qty + "&pkg_tp=" + pkg_tp + "&wgt_qty=" + wgt_qty + "&wgt_tp=" + wgt_tp + "&pol_cd=" + pol_cd + "&pod_cd=" + pod_cd;
					//alert("open --> " + url);
//					ComOpenWindow(url, "ESM_BKG_0361_01", "dialogWidth:650px;dialogHeight:550px", true);
					ComOpenWindowCenter(url, "ESM_BKG_0361_01", 900, 600, true);
				break;
				case "btn_t8POOtherNo":
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0367_01.do?func=callbackPOOtherNo&popUpTpCd=B&bkg_no=" + bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0367_01", 900, 600, true);
				break;
				case "btn_find_package":
					comBkgCallPop0696("callbackPckTp", formObject.pck_tp_cd.value); 
				break;
				case "wgt_ut_cd":
					if(formObject.bdr_flg.value == 'Y' && formObject.corr_flg.value == 'N'){
						formObject.wgt_ut_cd.selectedIndex=wgt_ut_idx;
					}				
				break
				case "frt_term_cd":
					if(formObject.bdr_flg.value == 'Y' && formObject.corr_flg.value == 'N'){
						formObject.frt_term_cd.selectedIndex=frt_term_idx;
					}				
				break
				case "btn_t8multishp":
					if(formObject.bkg_no.value == '' ){
						ComShowMessage(ComGetMsg("BKG00463"));
						formObject.bkg_no.focus();
					}else{
						var url="ESM_BKG_0391.do?func=callbackMultiShp&bkg_no=" + formObject.bkg_no.value+"&ui_no=ESM_BKG_0079_06";
						ComOpenWindowCenter(url, "ESM_BKG_0391", 1100, 595, true);
					}
				break;
				
			} // end switch
		}catch(e) {
    		if( e.name == "TypeError") {
    			return false;
    		}else{
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
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee- Preferences change the name of the function to start
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee- The final configuration functions added
			ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].SetWaitImageVisible(0);
		}
		//iframe Generation
    	//------------------------------------------------>
    	//setInquiryDisableButton event call
   		setInquiryDisableButton();
     	//------------------------------------------------>
		// set init-data for sheets
		if(document.form.bkg_no.value != ''){
			//retrieveSplitNo();
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH) ;
		}
		initControl();
	}
	function initControl() {
		//add listener
		//axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
//	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
		axon_event.addListenerForm('keydown', 'check_Enter', document.form);
		
//		if (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) {
//			  // 처리 로직 작성
//			}
		var word = "";
		var agent = navigator.userAgent.toLowerCase(); 
		var name = navigator.appName; 
		if ( name == "Microsoft Internet Explorer" ) word = "msie "; 
		else { 
			// IE 11 
			if ( agent.search("trident") > -1 ) word = "msie"; 
			else word = "chrome";
		} 

		if (word == "msie") {
			document.getElementById('mk_desc').style.setProperty("width", "160px", "important");
			document.getElementById('dg_cmdt_desc').style.setProperty("width", "305px", "important");
		} else {
			document.getElementById('mk_desc').style.setProperty("width", "155px", "important");
			document.getElementById('dg_cmdt_desc').style.setProperty("width", "290px", "important");
		}
		
		applyShortcut();
	}
	
	function check_Enter() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (event.keyCode == 13) {
			if(ComGetEvent("name") == "mk_desc") return;
			if(ComGetEvent("name") == "dg_cmdt_desc") return;
			if(ComGetEvent("name") == "bkg_no"){
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
			}
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
			    with(sheetObj){
			      var HeadTitle="|Seq.|Val|Name|Desc";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"val" },
			             {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
	        	}
			break;
			case 2:      //sheet1 init
			    with(sheetObj){
				      var HeadTitle1="|Template Seq.|Template Type|Template Name|Contents";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        Wrap:1 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tmplt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tmplt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
				             {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"tmplt_hdr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
				             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"tmplt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:45,    Wrap:1 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetCountPosition(0);
				      SetVisible(0);
		         }
			break;
		}
	}
	// Sheet handling process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj, formObj, sAction)) {
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value=SEARCH;
 					var rXml=sheetObj.GetSearchData("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
					// etcData to Form
					if (rXml != "") sheetObj.LoadSearchData(rXml,{Sync:1} );
					ComEtcDataXmlToForm(rXml, formObj);
					wgt_ut_idx=formObj.wgt_ut_cd.selectedIndex;
					meas_ut_idx=formObj.meas_ut_cd.selectedIndex;
					frt_term_idx=formObj.frt_term_cd.selectedIndex;
					// set Format
					formObj.pck_qty.value=ComAddComma3(formObj.pck_qty.value, "#,###");
					formObj.act_wgt.value=ComAddComma3(formObj.act_wgt.value, "#,###.000");
//					formObj.meas_qty.value=ComAddComma3(formObj.meas_qty.value, "#,###.000");
					if(formObj.meas_qty.value == "" || formObj.meas_qty.value == null || formObj.meas_qty.value == undefined){
						formObj.meas_qty.value="";
					}else{
						formObj.meas_qty.value=ComAddComma3(formObj.meas_qty.value, "#,###.000");
					}
					/* Export & Import Licence */
					changeObjectColor(formObj.xpt_imp_seq.value, "1", "btn_t8ExportImportInfo", "blue", "btn2");

					
					if(formObj.bdr_flg.value == 'Y'){
						document.getElementById("bkg_no").className="input1";
					}else{
						document.getElementById("bkg_no").className="input";
					}
					// CA
					if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N'){
						formObj.pck_qty.readOnly=true;
						formObj.pck_tp_cd.readOnly=true;
						formObj.act_wgt.readOnly=true;
						formObj.cstms_desc.readOnly=true;
						formObj.pck_qty.className="input2";
						formObj.pck_tp_cd.className="input2";
						formObj.act_wgt.className="input2";
						formObj.wgt_ut_cd.className="input2";
						formObj.cstms_desc.className="input2";
						formObj.frt_term_cd.className="input2";
					}else{
						formObj.pck_qty.readOnly=false;
						formObj.pck_tp_cd.readOnly=false;
						formObj.act_wgt.readOnly=false;
						formObj.cstms_desc.readOnly=false;
						formObj.pck_qty.className="input1";
						formObj.pck_tp_cd.className="input1";
						formObj.act_wgt.className="input1";
						formObj.wgt_ut_cd.className="input1";
						formObj.cstms_desc.className="input1";
						formObj.frt_term_cd.className="input1";
					}
					var r_po_other_mdt_itm=formObj.r_po_other_mdt_itm.value;
					var bkg_ref_tp_ml_cd=formObj.bkg_ref_tp_ml_cd.value; 
					var po1=formObj.po_cust_flag.value;
					var po2=formObj.po_ref_flag.value;
					var po3=formObj.po_ref_dtl_flag.value;
					if(r_po_other_mdt_itm != "" && bkg_ref_tp_ml_cd != "" && r_po_other_mdt_itm == bkg_ref_tp_ml_cd){
						ComGetObject("btn_t8POOtherNo").style.setProperty("color", "blue", "important"); 
					}else{
						changeObjectColor(po1, "1", "btn_t8POOtherNo","red","btn2");  
					}
					// btn_t6gridmultishp button color setting
					if(ComGetObjValue(formObj.mlt_shp_flg) == "Y"){
					    ComGetObject("btn_t8multishp").style.setProperty("color", "blue", "important");
					}else{
						ComGetObject("btn_t8multishp").style.setProperty("color", "", "important");
					}
					
					formObj.po_cust_flag.value=(po1=='0') ? 'N' : 'Y';
					formObj.po_ref_flag.value=(po2=='0') ? 'N' : 'Y';
					formObj.po_ref_dtl_flag.value=(po3=='0') ? 'N' : 'Y';
					// data changes check
					formObj.dirty_flag.value='N';
					doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
					// ca controll
					if(parent.t8frame != undefined && typeof(parent.t8frame) == "object") {
						parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value);  
					}
					
					//P/O & Other No. cntr 체크
					if(formObj.po_mrn_ucr_cntr_flg.value == 'Y' ){//red color 버튼 처리--BKG_REFERENCE,BKG_CONTAINER의 CNTR_NO가 다르거나 NULL 일때
						ComGetObject("btn_t8POOtherNo").style.setProperty("color", "red", "important");  
					}else if(formObj.po_mrn_ucr_cntr_flg.value == 'T' ){//blue color
						ComGetObject("btn_t8POOtherNo").style.setProperty("color", "blue", "important");  
					}
				}finally{
					ComOpenWait(false);
				}
				}
			break;
			case SEARCH01:      //word template retrieve
				formObj.f_cmd.value=SEARCH01;
 				sheetObj.DoSearch("ESM_BKG_0079_06GS.do", FormQueryString(formObj), {Sync:2} );
 				copyTemplateList(sheetObj, formObj);
			break;
			case SEARCH02:      //DG retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value=SEARCH02;
 					var rXml=sheetObj.GetSearchData("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					var etcData=ComGetEtcData(rXml, "copy_from_dg");
					//alert(etcData);
					formObj.dg_cmdt_desc.value=(etcData == '')
					                           ? formObj.dg_cmdt_desc.value
											   : formObj.dg_cmdt_desc.value + '\r\n' + etcData;
					// modify
					formObj.dirty_flag.value='Y';
				}finally{
					ComOpenWait(false);
				}
				}
			break;
			case IBSAVE:        //Save
				if(document.form.isInquiry.value == "Y") return false;

				if(validateForm(sheetObj,formObj,sAction)) {
					try {
						ComOpenWait(true); 
						formObj.f_cmd.value=MULTI;
						//alert("sheetObj.RowCount : " + sheetObj.RowCount);
						if(sheetObj.RowCount()==0){
							sheetObj.DataInsert(1);
						}else{
							sheetObj.SetRowStatus(1,"U");
						}
						// unmasked;
						ComClearSeparator(formObj.pck_qty);
						ComClearSeparator(formObj.act_wgt);
						ComClearSeparator(formObj.meas_qty);
						
						// 특수문자 제거 로직 추가
						var v_mk_desc 		= chekcSpecialValue(ComGetObjValue(formObj.mk_desc));
						var v_dg_cmdt_desc 	= chekcSpecialValue(ComGetObjValue(formObj.dg_cmdt_desc));
						var v_cstms_desc 	= chekcSpecialValue(ComGetObjValue(formObj.cstms_desc));
						
						ComSetObjValue(formObj.mk_desc, v_mk_desc);
						ComSetObjValue(formObj.dg_cmdt_desc, v_dg_cmdt_desc);
						ComSetObjValue(formObj.cstms_desc, v_cstms_desc);
						
						// 글자 자릿수 만큼 개행 처리 하기
						lineColsSize(16, formObj.mk_desc);
						lineColsSize(33, formObj.dg_cmdt_desc);
						// whitesapce validation check.....
						if(!dataCheck(formObj.mk_desc.value, 55)){
							alert("Marks & Numbers over line (>55)!!");
							return; 
						}
						if(!dataCheck(formObj.dg_cmdt_desc.value, 55)){
							alert("Description of Goods over line (>55)!!");
							return; 
						}
						
//////////////////////////////////////////////////////////////////////////////////////
						var fstr=FormQueryString(formObj);
			 			var rXml=sheetObj.GetSaveData("ESM_BKG_0079_06GS.do", fstr);
						var rMsg=ComResultMessage(rXml);
						if (rMsg == '') {
			 				sheetObj.LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
							formObj.dirty_flag.value='N';
							ComShowMessage(ComGetMsg("BKG00166"));
							
							doActionIBSheet(sheetObj, formObj, IBSEARCH);
						} else {
							ComShowMessage(rMsg);
						}
//////////////////////////////////////////////////////////////////////////////////////
						
//						descFlag=true;
//						formObj.action="/opuscntr/apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_WordWrap.jsp";
//						formObj.method="post";
//						formObj.target="descRequest";
//						formObj.submit();
					}finally{
						ComOpenWait(false);
					}
				}
			break;
			case COMMAND04:      //booking_split_no  retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.SetWaitImageVisible(0);
					ComSetObjValue(formObj.f_cmd, COMMAND03);
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -15); 
					sheetObj.SetWaitImageVisible(1);
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;
			case IBCOPYROW:      // copy 
				formObj.pck_cmdt_desc.value=getPckDesc();
				if(formObj.rcv_term_cd.value != 'S'){
					formObj.cntr_cmdt_desc.value=formObj.cntr_desc.value;
				}
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\r\n" + formObj.cstms_desc.value;
				formObj.dirty_flag.value='Y';
			break;					
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				with(formObj){
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.select();
							return false;
						}
					}
				}
			break;
			
			case IBSAVE:
				/*
				 * 1. Check whether the changed value.
				 * 2. Message [BKG00350] show 
				*/
				if(document.form.isInquiry.value == "Y") return false;
				with(formObj){
					if(dirty_flag.value != 'Y'){
						return false;
					}
					if(!confirm(ComGetMsg("BKG00350"))){
						return false
					}
					if(bkg_sts_cd.value == 'X'){
						ComShowMessage(ComGetMsg("BKG00433"));
						return false;
					}
					if(ComIsEmpty(bkg_no.value) || bkg_no.value.length < 11){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.select();
						return false;
					}
					if(ComIsEmpty(bl_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bl_no.select();
						return false;
					}
					if (ComIsEmpty(pck_qty.value) || pck_qty.value == '0') {
						ComShowMessage(ComGetMsg('BKG00505'));
						pck_qty.select();
						return false;
					}
					if (ComIsEmpty(pck_tp_cd.value)) {
						ComShowMessage(ComGetMsg('BKG00504'));
						pck_tp_cd.select();
						return false;
					}
					if (ComIsEmpty(act_wgt.value) || act_wgt.value == '0') {
						ComShowMessage(ComGetMsg('BKG00765'));
						act_wgt.select();
						return false;
					}
					if (!ComIsEmpty(meas_qty.value) && parseFloat(meas_qty.value) != 0 && ComIsEmpty(meas_ut_cd.value)) {
						ComShowMessage(ComGetMsg('BKG00445', "Measure Unit"));
						meas_qty.select();
						return false;
					}
					if (ComIsEmpty(meas_qty.value) && !ComIsEmpty(meas_ut_cd.value)) {
						ComShowMessage(ComGetMsg('BKG00445', "Measure"));
						meas_qty.select();
						return false;
					}
					if (ComIsEmpty(cstms_desc.value)) {
						ComShowMessage(ComGetMsg('BKG00767', "[Customs Description]"));
						cstms_desc.focus();
						return false;
					}
					//M&D, C/M print flag check		mk_desc_prn_flg,mf_desc_prn_flg
					if ((mk_desc_prn_flg.checked==true && mf_desc_prn_flg.checked==true) 
							|| (mk_desc_prn_flg.checked==false && mf_desc_prn_flg.checked==false) ){
						ComShowMessage(ComGetMsg('BKG08338'));
						return false;
					}
				}
			break;
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;			
		}
		return true;
	}

	function form1_change(){
		/* upper case */
		/* Check  data changes*/
		document.form.dirty_flag.value='Y';
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "pck_qty":
				//1. returning without modifying when the status of BL is Issue
				//2. Changing the first line of Description of Goods in case of changing Package Qty and Type
				//3. When RCV TERM is 'S', modifying like this - (TTL PKG VALUE) + (PKG code description) IN TOTAL
				if(document.form.cstms_clr_cd.value == 'Y') {
					ComShowMessage(ComGetMsg('BKG00087'));
					 ComGetEvent().select();
					return false;
				}
				// changePackageDesc
				changePackageDesc();
			break;
			case "pck_tp_cd":
				var cVal= ComGetEvent().value;
				if(cVal==''){
					//event.srcElement.focus();
					return false;
				}
 				var rXml=sheetObjects[0].GetSearchData("ESM_BKG_0079_06GS.do", "f_cmd="+SEARCH03+"&pck_tp_cd="+cVal);
				var pckNm=ComGetEtcData(rXml, "pck_nm");
				if(pckNm == undefined || pckNm == ''){
					ComShowMessage(ComGetMsg("BKG00530"));
					 ComGetEvent().select();
					return false;
				}
				//pck_nm
				document.form.pck_nm.value=pckNm;
				// changePackageDesc
				changePackageDesc();
			break;
			case "act_wgt":
				if(document.form.cstms_clr_cd.value == 'Y') {
					ComShowMessage(ComGetMsg('BKG00087'));
				}
			break;
			case "frt_term_cd":
				if(document.form.rc_flg.value == 'Y'){
					if (document.form.frt_term_cd.options[document.form.frt_term_cd.selectedIndex].value == 'C') {
						ComShowMessage(ComGetMsg('BKG00718'));
						return false;
					}
				}
			break;
			case "tp_word_template":
				setTemplateValues('T');
			break;
			case "mk_word_template":
				setTemplateValues('M');
			break;
			case "dg_word_template":
				setTemplateValues('D');
			break;
			case "mk_desc":
			case "dg_cmdt_desc":
			break;
		}
	}
	function t8sheet1_OnSearchEnd(sheetObj, ErrMsg){
		//alert(sheetObj.id + "_OnSearchEnd : " + ErrMsg);
	}
	function t8sheet2_OnSearchEnd(sheetObj, ErrMsg){
		//alert(sheetObj.id + "_OnSearchEnd : " + ErrMsg);
	}
	function copyTemplateList(sheetObj, formObj){
		/* combo object */
		var TCombo=formObj.tp_word_template;
		var MCombo=formObj.mk_word_template;
		var DCombo=formObj.dg_word_template;
		/* remove old value */
		removeOptions(TCombo);
		removeOptions(MCombo);
		removeOptions(DCombo);
		/* set new value */
		var rcnt=sheetObj.RowCount();
		for(ir=1;ir<=rcnt;ir++){
			var tmplt_type=sheetObj.GetCellValue(ir, "tmplt_tp_cd");
			if(tmplt_type=='D'){
				DCombo.options[DCombo.length]=new Option(sheetObj.GetCellValue(ir, "tmplt_hdr_nm") , sheetObj.GetCellValue(ir, "tmplt_seq"));
			}else if(tmplt_type=='M'){
				MCombo.options[MCombo.length]=new Option(sheetObj.GetCellValue(ir, "tmplt_hdr_nm") , sheetObj.GetCellValue(ir, "tmplt_seq"));
			}else if(tmplt_type=='T'){
				TCombo.options[TCombo.length]=new Option(sheetObj.GetCellValue(ir, "tmplt_hdr_nm") , sheetObj.GetCellValue(ir, "tmplt_seq"));
			}
		}
	}
	function setTemplateValues(tmplt_type){
		var sheetObj=sheetObjects[1];
		var lstObj='';
		var tgtObj='';
		var tmplt_seq='';
		var tmplt_ctnt='';
		if(tmplt_type=='D'){
			lstObj=document.form.dg_word_template;
			tgtObj=document.form.dg_cmdt_desc;
		}else if(tmplt_type=='M'){
			lstObj=document.form.mk_word_template;
			tgtObj=document.form.mk_desc;
		}else if(tmplt_type=='T'){
			lstObj=document.form.tp_word_template;
			tgtObj=document.form.ttl_pck_desc;
		}
		tmplt_seq=lstObj.options[lstObj.selectedIndex].value;
		var rowCnt=sheetObj.RowCount();
		for(ir=1;ir<=rowCnt;ir++){
			if(sheetObj.GetCellValue(ir, "tmplt_tp_cd") == tmplt_type && sheetObj.GetCellValue(ir, "tmplt_seq") == tmplt_seq){
				if(tmplt_type=='T'){
//					tgtObj.value=sheetObj.GetCellValue(ir, "tmplt_ctnt");
					tgtObj.value=chekcSpecialValue(sheetObj.GetCellValue(ir, "tmplt_ctnt"));	//특수문자 처리 로직 추가
				}else{
//					tgtObj.value += sheetObj.GetCellValue(ir, "tmplt_ctnt");
					tgtObj.value += chekcSpecialValue(sheetObj.GetCellValue(ir, "tmplt_ctnt"));
				}
			}
		}
	}
	function changePackageDesc() {
		if(document.form.rcv_term_cd.value == 'S'){
			document.form.ttl_pck_desc.value=getPckDesc();
		}
	}
	function getPckDesc(){
		var p=(document.form.pck_qty.value=='') ? 0 : BkgParseInt(ComTrimAll(document.form.pck_qty.value, ','));
		if(p > 1){
			return p + " " + document.form.pck_nm.value + ("BOX"==document.form.pck_nm.value ? "E":"") + "S IN TOTAL";
		}else if(p == 1){
			return p + " " + document.form.pck_nm.value + " IN TOTAL";
		}else{
			return "";
		}
	}
	/* common script */
	function removeOptions(comboObj) {
		var len=comboObj.length;
		for(i=1;i<len;i++) {
			comboObj.remove(len-i);
		}
	}
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	function callbackCopyFromHBL(bl_mk_desc, bl_cmdt_desc){
		document.form.mk_desc.value=bl_mk_desc;
		document.form.dg_cmdt_desc.value=bl_cmdt_desc;
		document.form.dirty_flag.value='Y';
	}
	function callbackPckTp(returnVal){
		if(document.form.obl_iss_flg.value == 'Y') return false;
		document.form.pck_tp_cd.value=returnVal.cd;
		document.form.pck_nm.value=returnVal.nm;
		changePackageDesc();
		document.form.dirty_flag.value='Y';
	}
	function callbackCmdtDesc(pck_cmdt_desc, cntr_cmdt_desc, dg_cmdt_desc, cm_cstms_desc){
		document.form.pck_cmdt_desc.value=pck_cmdt_desc;
		document.form.cntr_cmdt_desc.value=cntr_cmdt_desc;
		document.form.dg_cmdt_desc.value=document.form.dg_cmdt_desc.value + "\r\n" + dg_cmdt_desc;
		if(cm_cstms_desc != '') document.form.cstms_desc.value=cm_cstms_desc;
		document.form.dirty_flag.value='Y';
	}
	function callbackPOOtherNo(po_cust_flag, po_ref_flag, po_ref_dtl_flag, dgc_desc){
		var po1=po_cust_flag;
		var po2=po_ref_flag;
		var po3=po_ref_dtl_flag;
		if(document.form.isInquiry.value == "N"){
			if(po2 == 'Y' || po3 == 'Y'){
				 changeObjectColor("1", "1", "btn_t8POOtherNo", "blue", "btn2");
			}else{
				changeObjectColor(po1, "Y", "btn_t8POOtherNo", "red", "btn2");

			}

		}
		document.form.po_cust_flag.value=po1;
		document.form.po_ref_flag.value=po2;
		document.form.po_ref_dtl_flag.value=po3;
		/**/
		if(dgc_desc != undefined) {
			document.form.dg_cmdt_desc.value=document.form.dg_cmdt_desc.value + "\r\n" + dgc_desc;
		}
		document.form.dirty_flag.value='Y';
	}
	
	/* ESM_BKG_0391 */
	function callbackMultiShp(rArray){
		var mk_desc  ="";
		var cmdt_desc="";
		var re_mk_desc   = "";
		var re_cmdt_desc = "";
		var tmp_mk_desc		=document.form.mk_desc.value;
		var tmp_cmdt_desc	=document.form.dg_cmdt_desc.value;
		if(rArray[0].length>0){
			for(var i=0; i<rArray[0].length;i++){
				//new ver.  ibflag|Sel.|CntrSeq|Container No.|MfSeq.|Package|Package|Package|TP/SZ|Weight|WgtUnit|Measure|MeasUnit|Marks|Marks|Description|Vol|Seal No.1|Seal No.2|HS Code|HS Code|HTS Code|HTS Code|NCM Code|NCM Code|P/O No.|Print";
				if(rArray[0][i][13]=="" && rArray[0][i][15]=="")	continue;
				
				if(rArray[0][i][13]!=""){
					re_mk_desc		+=rArray[0][i][13]+'\r\n\r\n';	
				}
				if(rArray[0][i][15]!=""){
					re_cmdt_desc	+=rArray[0][i][15]+'\r\n\r\n';
				}
			}
		}
		if(re_mk_desc.length>0){
			if(tmp_mk_desc.length > 0){
				mk_desc = tmp_mk_desc +'\r\n'+re_mk_desc.substring(0,re_mk_desc.length-4);
				document.form.mk_desc.value=mk_desc;
			}else{
				mk_desc = re_mk_desc.substring(0,re_mk_desc.length-4);
				document.form.mk_desc.value=mk_desc;
			}
		}
		
		if(re_cmdt_desc.length>0){
			if(tmp_cmdt_desc.length > 0){
				cmdt_desc = tmp_cmdt_desc +'\r\n'+re_cmdt_desc.substring(0,re_cmdt_desc.length-4);
				document.form.dg_cmdt_desc.value=cmdt_desc;
			}else{
				cmdt_desc = re_cmdt_desc.substring(0,re_cmdt_desc.length-4);
				document.form.dg_cmdt_desc.value=cmdt_desc;
			}
		}
		if(re_mk_desc.length>0 || re_cmdt_desc.length>0){
			document.form.dirty_flag.value='Y';
		}
	}	
	/* tab move: check the data changes whether  */
	function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
			doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
		}
	}
	function searchData(bkgNo){
		var formObj=document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		ComSetObjValue(formObj.dirty_flag, "N");
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}
	function setInquiryDisableButton() {
		if(document.form.isInquiry.value == "Y"){
			// button
			ComBtnDisable("btn_t8Save");
			ComBtnDisable("btn_t8CopyfromDG");
			ComBtnDisable("btn_t8CopyfromCM");
			ComBtnDisable("btn_t8CopyfromHouseBL");
		}
	}
	function descSend() {
		if (descFlag) {
			var formObj=document.form;
			var sheetObj=sheetObjects[0];
			formObj.mk_desc.value=descRequest.document.getElementById("mk_desc").value;
			formObj.dg_cmdt_desc.value=descRequest.document.getElementById("dg_cmdt_desc").value;
			var fstr=FormQueryString(formObj);
 			var rXml=sheetObj.GetSaveData("ESM_BKG_0079_06GS.do", fstr);
			var rMsg=ComResultMessage(rXml);
			if (rMsg == '') {
 				sheetObj.LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
				formObj.dirty_flag.value='N';
				ComShowMessage(ComGetMsg("BKG00166"));
			} else {
				ComShowMessage(rMsg);
			}
			descFlag=false;
		}
	}

	/**
	 * 글자 자릿수 만큼 개행 처리 하기
	 * @param cols	자릿수
	 * @param obj	object
	 */
	function lineColsSize(cols, obj){
    	//var str=ComBkgString(obj);
		var str = "";
		if (event==undefined){
			str=obj.value;
		}else{
			str=ComBkgString(obj);
		}

		
        var displayText;
        var parseCols=parseInt(cols);
        var rowArr=str.split("\n");
        
        for(var i=0 ; i < rowArr.length ; i++){
            if(countLineBreaks(rowArr[i]) > 0){
                if(rowArr[i].length > parseCols+1){
                    var loopCnt;
                    if(rowArr[i].length%parseCols > 0){
                        loopCnt=rowArr[i].length/parseCols + 1;
                    }else{
                        loopCnt=rowArr[i].length/parseCols;
                    }
                    for(var j=0 ; j < Math.floor(loopCnt) ; j++){
                        if(i < 1){
                            if(j < 1){
                                displayText=rowArr[i].substring(0,parseCols*(j+1));
                            }else{
                                displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                            }
                        }else{
                            displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                        }
                    }
                    if(countLineBreaks(displayText) > 0){
                        displayText=displayText.substring(0,displayText.length-1);
                    }
                }else{
                    if(i < 1){
                        displayText=rowArr[i];
                    }else{
                        displayText=displayText + "\n" + rowArr[i];
                    }
                }
            }else{
                if(rowArr[i].length > parseCols){
                    var loopCnt;
                    if(rowArr[i].length%parseCols > 0){
                        loopCnt=rowArr[i].length/parseCols + 1;
                    }else{
                        loopCnt=rowArr[i].length/parseCols;
                    }
                    for(var j=0 ; j < Math.floor(loopCnt) ; j++){
                        if(i < 1){
                            if(j < 1){
                                displayText=rowArr[i].substring(0,parseCols*(j+1));
                            }else{
                                displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                            }
                        }else{
                            displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                        }
                    }
                }else{
                    if(i < 1){
                        displayText=rowArr[i];
                    }else{
                        displayText=displayText + "\n" + rowArr[i];
                    }
                }
            }
        }
        obj.value=displayText;
    }

    /*
     * KEY UP 이벤트 처리
     */
    function checkUpdate(obj){
    	var updateString = checkSpecial(obj);	//특수문자 제외 로직
    	if(obj.value != updateString){
        	document.form.dirty_flag.value='Y';	//변경사항 체크
    	}
    }

    /*
     * MOUSE PASTE 이벤트
     */
    function mousePaste(obj){
    	setTimeout(function(){
        	var updateString = checkSpecial(obj);	//특수문자 제외 로직
        	if(obj.value != updateString){
        		document.form.dirty_flag.value="Y";	//변경사항 체크
        	}
    	}, 100)
    }
    
    function onCheck(obj)
    {
    	if(obj.name=="mf_desc_prn_flg"){
    		if(document.form.mf_desc_prn_flg.checked){
        		document.form.mk_desc_prn_flg.checked = false;
    		}else{
    			document.form.mf_desc_prn_flg.checked = true;
    		}
    	}else if(obj.name=="mk_desc_prn_flg"){
    		if(document.form.mk_desc_prn_flg.checked){
        		document.form.mf_desc_prn_flg.checked = false;
    		}else{
    			document.form.mk_desc_prn_flg.checked = true;
    		}
    	}
    }
    
    /**
     * space line check
     */
    function dataCheck(val,rn)
    {
    	var val_line=val.split("\n");
    	var line_data="";
    	
    	var white_line = 0;
    	if(val_line.length>rn){
    		for(var i=0; i< val_line.length; i++){
    			line_data = val_line[i];
    			
    			if(isWhitespaceNotEmpty(line_data)){//blank space ??
    				white_line++;
    			}else{
    				white_line = 0;
    			}
    			
    			if(white_line > rn){
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
