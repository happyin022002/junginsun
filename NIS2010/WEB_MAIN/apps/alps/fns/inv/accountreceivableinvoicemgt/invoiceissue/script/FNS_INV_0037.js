	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : FNS_INV_0037.js
	 *@FileTitle : (S.China)Invoice Issue (Email)
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.24
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.09.24 정휘택
	 * 1.0 Creation
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
	 * FNS_INV_0037 : FNS_INV_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     FNS_INV_0037()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function FNS_INV_0037() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
		this.initRdConfig			= initRdConfig;
		this.rdOpen					= rdOpen;
		this.setUploadObject		= setUploadObject;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	var uploadObjects = new Array();
	var uploadCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrieve":
				//alert("btn_retrieve");
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
	
			case "btn_preview":
				//alert("btn_preview");
				invPreview(sheetObject1, formObject);
				break; 
	
			case "btn_send":
				//alert("btn_send");   
				invSend(sheetObject1, formObject);      					
				break; 
	
			case "btn_close":
				window.close();
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function setSheetObject(sheetObj){
	
		sheetObjects[sheetCnt++] = sheetObj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function loadPage() {
	
		var formObject = document.form;
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
			//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
		}
	
		//alert(formObject.issue_gubn.value);
	
		if (formObject.issue_gubn.value == "I") {
	
			formObject.f_inv.value = opener.document.form.f_inv.value;
			formObject.t_inv.value = opener.document.form.t_inv.value;
			formObject.flag.value = "M";
			formObject.copy_cnt.value = opener.document.form.copy_cnt.value;
			//formObject.iss_ofc_cd.value = "HKGBB"; 
			formObject.iss_ofc_cd.value = opener.document.form.ar_ofc_cd2.value; 
	
		} else {
	
			formObject.invs.value = opener.document.form.invs_email.value;
			formObject.f_inv.value = opener.document.form.f_inv.value;
			formObject.t_inv.value = opener.document.form.t_inv.value;
			formObject.flag.value = (opener.document.form.sel_option[0].checked ? "S" : "M");
			formObject.copy_cnt.value = opener.document.form.copy_cnt.value;
			formObject.iss_ofc_cd.value = opener.document.form.iss_ofc_cd.value;            
	
		}      
	
		initRdConfig(rdObjects[0]);
		initRdConfig(rdObjects[1]);
		ComConfigUpload(uploadObjects[0], "/hanjin/FNS_INV_0037GS.do");
		sheetObjects[0].ColHidden("f_add") = true;
		sheetObjects[0].ColHidden("f_del") = true;
		sheetObjects[0].ColHidden("f_copy") = true;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		sheetObjects[0].ColHidden("f_add") = false;
		sheetObjects[0].ColHidden("f_del") = false;
		sheetObjects[0].ColHidden("f_copy") = false;
	
		//alert(sheetObjects[0].DataRowHeight);
		
		if(formObject.iss_ofc_cd.value == "SZPSC" || formObject.iss_ofc_cd.value == "CANSO"){
			formObject.title_type[0].disabled = false;
		}else{
			formObject.title_type[0].disabled = true;
		}
	
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj, 0)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */  
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t2sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 480;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;                       
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);			// 단위 데이터 행의 맨 아래 Row를 RowHidden 속성으로 구분한다.
	
			var HeadTitle1 = "|Sel.|VVD|Cust. Code|Cust. Name|Invoice No.|E-mail Address|Fax No.|INV Ref. No.|I/F No.|B/L No.|Port Cd.|Remark(s)|inv_rmk2||Attach letter by VVD||Attach letter by Cust.|Attach more from my PC|Attach more from my PC|Attach more from my PC|Attach more from my PC|File Key|Inv Seq.";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 6, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
			InitHeadMode(false, true, true, true, false, false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
			//데이터속성            [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,   cnt++, dtHiddenStatus,  30,    daCenter,  false,   "ibflag");
	
			InitDataProperty(0,   cnt++, dtCheckBox, 50,    daCenter,  false,    "slt",   	   false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "vvd",   	   false,    "",         dfNone,	 0,          false,      false);
			InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "cust_cd",    false,    "",         dfNone,	 0,          false,      false);
			InitDataProperty(0,   cnt++, dtData,   	 215,   daLeft,    false,    "cust_nm",    false,    "",         dfNone,	 0,          false,      false);
			InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "inv_no",     false,    "",         dfNone,	 0,          false,      false);
	
			InitDataProperty(0,   cnt++, dtData,   	 200,   daLeft,    false,    "cust_eml",      false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0,   cnt++, dtData,   	 200,   daLeft,    false,    "cust_fax_no",   	   false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "inv_ref_no", false,    "",         dfNone,	 0,          false,      false);
			InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "ar_if_no",   false,    "",         dfNone,	 0,          false,      false);
			InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "bl_src_no",  false,    "",         dfNone,	 0,          false,      false);
	
			InitDataProperty(0,   cnt++, dtHidden,   50,    daCenter,  false,    "port_cd",    false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtPopup,    70,    daCenter,  false,    "inv_rmk",    false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtHidden,   100,   daCenter,  false,    "inv_iss_rmk",   false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtCheckBox, 20,    daCenter,  false,    "attach",     false,    "",         dfNone,	 0,          true,       true , 0, false, false, false, true);
			InitDataProperty(0,   cnt++, dtPopup,    130,   daCenter,  false,    "attach_view",    false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtCheckBox, 20,    daCenter,  false,    "attach2",     false,    "",         dfNone,	 0,          true,       true, 0, false, false, false, true);
			InitDataProperty(0,   cnt++, dtPopup,    130,   daCenter,  false,    "attach_view2",    false,    "",         dfNone,	 0,          true,       true);
	
			InitDataProperty(0,   cnt++, dtImage,    50,    daCenter,  false,    "f_add",      false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtImage,    75,    daCenter,  false,    "f_del",      false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtImage,    140,    daCenter,  false,    "f_copy",      false,    "",         dfNone,	 0,          true,       true);
	
			InitDataProperty(0,   cnt++, dtData,     200,   daCenter,  false,    "f_name",     false,    "",         dfNone,	 0,          false,      false);
			InitDataProperty(0,   cnt++, dtHidden,   100,   daCenter,  false,    "f_key",      false,    "",         dfNone,	 0,          true,       true);
			InitDataProperty(0,   cnt++, dtHidden,   50,    daCenter,  false,    "inv_seq",    false,    "",         dfNone,	 0,          true,       true);
	
			ImageList(0) = "img/btng_add.gif";
			ImageList(1) = "img/btng_delete.gif";
			ImageList(2) = "img/btng_copy_to_same_vvd.gif";
	
			ShowButtonImage = 2;		
	
			CountPosition = 2;
	
			WordWrap = true;
			//Ellipsis = true;
	
	
		}
		break;
	
	
		}
	}
	 	 
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH:      //조회
	
		formObj.f_cmd.value = SEARCH01;
		//sheetObj.DoSearch("FNS_INV_0037GS.do", FormQueryString(formObj));
		var sXml = sheetObj.GetSearchXml("FNS_INV_0037GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);
	
		var vvd = "";
		var cust_cd = "";
		var inv_no = "";
		var if_cd = "";
		var bl_no = "";
		var rows = "";		      	    
	
		// vvd, cust_cd, inv_no 가 같을때 row 병합처리
		for (var idx = 0; idx < sheetObj.RowCount + 1; idx++){
	
			if(vvd == sheetObj.CellValue(idx, "vvd") && cust_cd == sheetObj.CellValue(idx, "cust_cd") && inv_no == sheetObj.CellValue(idx, "inv_no")) {
				if_cd = sheetObj.CellValue(idx - 1, "ar_if_no");
				if_cd = if_cd + "\r\n" + sheetObj.CellValue(idx, "ar_if_no");
				bl_no = sheetObj.CellValue(idx - 1, "bl_src_no");
				bl_no = bl_no + "\r\n" + sheetObj.CellValue(idx, "bl_src_no");
	
				rows = rows + (idx - 1) + "|";
	
				sheetObj.CellValue(idx, "ar_if_no") = if_cd;
				sheetObj.CellValue(idx, "bl_src_no") = bl_no;
			} else{
				if_cd = "";
				bl_no = "";
	
			}
	
			vvd = sheetObj.CellValue(idx, "vvd");
			cust_cd = sheetObj.CellValue(idx, "cust_cd");
			inv_no = sheetObj.CellValue(idx, "inv_no");
	
		}
	
		var arrRow = rows.split("|");
	
		for (var idx = arrRow.length - 2; idx >= 0; idx--){
	
			//sheetObj.RowHidden(Number(arrRow[idx])) = true;
			sheetObj.RowDelete(Number(arrRow[idx]), false);
	
		}
	
		sheetObj.CheckAll("slt") = 1;   
		
		var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
		formObj.print_nm.value = sStr;
			
		break;
	
		case IBSAVE:        //저장	    			   
	
		formObj.f_cmd.value = MULTI01;    	
	
	//	sheetObj.DoSave("FNS_INV_0037GS.do", FormQueryString(formObj)); 	
	
		var sParam = FormQueryString(formObj);					
		var sParam1 = sheetObj.GetSaveString(false, true, 1); 	
		//alert(sParam1);
	
		if (sParam1 == "") {	
			formObj.state.value = "";
			return; 
		} else {
			sParam1 = ComSetPrifix(sParam1, "sheet1_");
			sParam = sParam + "&" + sParam1;					   
		}				    
	
		var sXml = sheetObj.GetSaveXml("FNS_INV_0037GS.do", sParam);	
		//sheetObj.LoadSaveXml(sXml);				       
		var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
		formObj.state.value = state;
		var issueCnt = ComGetEtcData(sXml, "issueCnt");
		formObj.issueCnt.value = issueCnt;
		//alert(state);
	
	
		break;
	
		case IBINSERT:      // 입력
	
		formObj.f_cmd.value = MULTI02;    			
		sheetObj.DoSearch("FNS_INV_0037GS.do", FormQueryString(formObj));
		var sXml = sheetObj.GetSearchXml("FNS_INV_0037GS.do", FormQueryString(formObj));
		var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
		formObj.state.value = state;
		//alert(state);
	
		break;
		}
	}
	
	/**
	 * Invoice Remark(FNS_INV_0087) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnPopupClick(sheetObj, Row, Col)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @param {int} Col ibsheet 해당 col
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */  
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		if (sheetObj.ColSaveName(Col) == "inv_rmk") {
			ComOpenWindowCenter("FNS_INV_0087.do", "pop2", 700, 259);
		} else if (sheetObj.ColSaveName(Col) == "attach_view"){
			if (sheetObj.CellValue(sheetObj.SelectRow, "attach_view") == "YES") {
				invPreviewWordingByVVD(sheetObj, document.form);
			}
	
		} else if (sheetObj.ColSaveName(Col) == "attach_view2") {
			if (sheetObj.CellValue(sheetObj.SelectRow, "attach_view2") == "YES") {
				invPreviewWordingByCust(sheetObj, document.form);
			}
	
		}	
	}
	
	/**
	 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     invPreviewWordingByVVD(sheetObj, formObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function invPreviewWordingByVVD(sheetObj, formObj) {     	
	
		var rdFile = "FNS_INV_0524_vvd.mrd"+"|";
		var ofc_cd = formObj.iss_ofc_cd.value;
	
		var vvd = sheetObj.CellValue(sheetObj.SelectRow, "vvd");
		var port_cd = sheetObj.CellValue(sheetObj.SelectRow, "port_cd");
	
		var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"]"+"|";
	
		formObj.com_mrdPath.value = rdFile ;
		formObj.com_mrdArguments.value = rdParam;
	
		ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=L", "pop3", 800, 700);
	
	}
	
	/**
	 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     invPreviewWordingByCust(sheetObj, formObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function invPreviewWordingByCust(sheetObj, formObj) {     	
	
		var rdFile = "FNS_INV_0524_cust.mrd"+"|";
		var ofc_cd = formObj.iss_ofc_cd.value;
	
		var cust_cd = sheetObj.CellValue(sheetObj.SelectRow, "cust_cd");
	
		var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]"+"|";
	
		formObj.com_mrdPath.value = rdFile ;
		formObj.com_mrdArguments.value = rdParam;
	
		ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=L", "pop3", 800, 700);
	
	} 
	
	/**
	 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     invPreview(sheetObj, formObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function invPreview(sheetObj, formObj) {
	
		var sRow = sheetObj.FindCheckedRow(1);
		if (sRow == "") {
			ComShowCodeMessage("INV00025");
			return 0;
		}  
	
		if (formObj.name_type[0].checked) {
			formObj.name_flag.value = "C"; 
		} else if (formObj.name_type[1].checked) {
			formObj.name_flag.value = "E"; 
		}
	
		if (formObj.title_type[0].checked) {
			formObj.title_flag.value = "M"; 
		} else if (formObj.title_type[1].checked) {
			formObj.title_flag.value = "C"; 
		} else if (formObj.title_type[2].checked) {        		
			formObj.title_flag.value = "A"; 
		} else if (formObj.title_type[3].checked) {        		
			formObj.title_flag.value = "H"; 
		}
		var rdFile = "FNS_INV_0517.mrd";
		var rdFiles = "";
		var ofc_cd = formObj.iss_ofc_cd.value;
	
		var arrRow = sRow.split("|");
		var rdParam = "";					
	
		for (var idx = 0; idx < arrRow.length - 1; idx++){
	
			var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
			var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
			var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
			var attach = "N";
			var attach2 = "N";
			var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
	
			rdFiles = rdFiles + rdFile +"|";				
			rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_logo[ORIGINAL] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_customer_name ["+formObj.name_flag.value+"] frm1_title ["+formObj.title_flag.value+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" + "|";
	
			formObj.com_mrdPath.value = rdFiles;
			formObj.com_mrdArguments.value = rdParam;
	
		}			
	
		ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=I", "pop3", 800, 700);
	
	}
	
	/**
	 *  Send 버튼 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     invSend(sheetObj, formObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */   
	function invSend(sheetObj, formObj) {
	
		var sRow = sheetObj.FindCheckedRow(1);
		if (sRow == "") {
			ComShowCodeMessage("INV00025");
			return 0;
		}
	
		if (formObj.name_type[0].checked) {
			formObj.name_flag.value = "C"; 
		} else if (formObj.name_type[1].checked) {
			formObj.name_flag.value = "E"; 
		}
	
		if (formObj.title_type[0].checked) {
			formObj.title_flag.value = "M"; 
		} else if (formObj.title_type[1].checked) {
			formObj.title_flag.value = "C"; 
		} else if (formObj.title_type[2].checked) {        		
			formObj.title_flag.value = "A"; 
		} else if (formObj.title_type[3].checked) {        		
			formObj.title_flag.value = "H"; 
		}
	
		var arrRow = sRow.split("|");
		var v_copy_cnt = formObj.copy_cnt.value;  
	
		// Paper Issue
	
		if (formObj.send_type[0].checked) {				
	
			formObj.send_flag.value = "P"; 
			doActionIBSheet(sheetObj,formObj,IBSAVE);
	
			var attachCnt = 0;
			var attachCnt2 = 0;
	
			if (formObj.state.value == "S") {
				rdObjects[0].SetAppendReport(0);
				for (var idx = 0; idx < arrRow.length - 1; idx++){
					var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
					var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
					var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
					var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
					var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
					var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
					var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
					var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
	
					rdOpen(rdObjects[0], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", formObj.name_flag.value, formObj.title_flag.value);
	
					rdObjects[0].SetAppendReport(1);
	
					for(var j=0; j<v_copy_cnt; j++) {  	
	
						rdOpen(rdObjects[0], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", formObj.name_flag.value, formObj.title_flag.value);
	
					}
	
					rdObjects[0].SetAppendReport(1);
	
					if (idx < arrRow.length - 2) {
	
						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
	
							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[0], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}
	
						} else {
	
							if (attach2 == "Y") {
								attachCnt2++
							}
						}
	
						rdObjects[0].SetAppendReport(1);
	
						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[0], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
	
							}	
	
						} else {
	
							if (attach == "Y") {
								attachCnt++
							}
	
						}
	
					} else {
	
						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[0], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}
	
						rdObjects[0].SetAppendReport(1);
	
						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[0], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}
	
					}
	
				}	
				// 프린터 세팅
		    	var print_nm = form.print_nm.value;
		    	if(print_nm != ""){
		    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
		    	}
	
				rdObjects[0].CMPrint(); //인쇄 시작
				rdObjects[0].SetAppendReport(0);
				ComShowCodeMessage("INV00065", formObj.issueCnt.value);
			}
	
			// E-mail, Fax Issue 
	
		} else if (formObj.send_type[1].checked || formObj.send_type[2].checked){
	
			if (formObj.send_type[1].checked) {
				formObj.send_flag.value = "E";
				formObj.send_flag2.value = "";
				var invNos = "";
				for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
					if (sheetObj.CellValue(idx, "slt") == "1" && sheetObj.CellValue(idx, "cust_eml") == "") {
						invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
						sheetObj.CellValue(idx, "slt") = 0;
					}
				}
				if (invNos != "") {
					ComShowCodeMessage("INV00099", invNos);
				}				
	
			} else {
				formObj.send_flag.value = "F";
				formObj.send_flag2.value = "";
				var invNos = "";
				for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
					if (sheetObj.CellValue(idx, "slt") == "1" && sheetObj.CellValue(idx, "cust_fax_no") == "") {
						invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
						sheetObj.CellValue(idx, "slt") = 0;
					}
				}
				if (invNos != "") {
					ComShowCodeMessage("INV00110", invNos);
				}	
			}
	
			var ofc_cd = formObj.iss_ofc_cd.value;
			var rdFile = "FNS_INV_0517.mrd";
	
			formObj.rd_name.value = rdFile;						
			doActionIBSheet(sheetObj,formObj,IBSAVE);	
			if (formObj.state.value == "S") {
				ComShowCodeMessage("INV00065", formObj.issueCnt.value);
			}
	
			// Paper Issue + E-mail Issue
		} else if (formObj.send_type[3].checked){
	
			var ofc_cd = formObj.iss_ofc_cd.value;
			var rdFile = "FNS_INV_0517.mrd";
	
			formObj.rd_name.value = rdFile;		
	
			formObj.send_flag.value = "E"; 
			formObj.send_flag2.value = "P"; 
			doActionIBSheet(sheetObj,formObj,IBSAVE);
	
			if (formObj.state.value == "S") {
				rdObjects[1].SetAppendReport(0);
	
				for (var idx = 0; idx < arrRow.length - 1; idx++){
	
					var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
					var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
					var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
					var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
					var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
					var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
					var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
	
					if (sheetObj.CellValue(arrRow[idx], "cust_eml") == "") {	
	
						rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", formObj.name_flag.value, formObj.title_flag.value);
						rdObjects[1].SetAppendReport(1);
	
						for(var j=0; j<v_copy_cnt; j++) {  	
	
							rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", formObj.name_flag.value, formObj.title_flag.value);
	
						}
	
						rdObjects[1].SetAppendReport(1);
	
						if (idx < arrRow.length - 2) {							
	
							if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
	
								if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
									rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
									attachCnt2 = 0;
								}
	
							} else {
	
								if (attach2 == "Y") {
									attachCnt2++
								}
							}
	
							rdObjects[1].SetAppendReport(1);
	
							if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
									&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
								if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
									rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
									attachCnt = 0;
								}							
	
							} else {
								if (attach == "Y") {
									attachCnt++
								}
							}
	
						} else {
	
							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
							}
	
							rdObjects[1].SetAppendReport(1);
	
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
							}
	
						}
	
					} else {
	
						for(var j=0; j<v_copy_cnt; j++) {  		
	
							rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", formObj.name_flag.value, formObj.title_flag.value);
	
						}		
	
						rdObjects[1].SetAppendReport(1);
	
						if (idx < arrRow.length - 2) {
	
							if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
	
								if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
									rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
									attachCnt2 = 0;
								}
	
							} else {
	
								if (attach2 == "Y") {
									attachCnt2++
								}
							}
	
							rdObjects[1].SetAppendReport(1);
	
							if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
									&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
								if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
									rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
									attachCnt = 0;
								}							
	
							} else {
								if (attach == "Y") {
									attachCnt++
								}
							}
	
						} else {
	
							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
							}
	
							rdObjects[1].SetAppendReport(1);
	
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
							}
	
						}
	
					}				
	
				}
				// 프린터 세팅
		    	var print_nm = form.print_nm.value;
		    	if(print_nm != ""){
		    		rdObjects[1].SetPrintInfo (print_nm, 1, 1, 4);
		    	}
	
				rdObjects[1].CMPrint(); //인쇄 시작
				rdObjects[1].SetAppendReport(0);
				ComShowCodeMessage("INV00065", formObj.issueCnt.value);
	
			}
	
		}
	
	}
	
	/**
	 *  RD외 첨부파일 업로드 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     invSend(sheetObj, formObj)
	 * </pre>
	 * @param {form} formObj 필수 html form object
	 * @param {String} file_path 업로드할 파일명
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */     
	function fileUpload(formObj, file_path) {
	
		formObj.f_cmd.value = SEARCH02;
	
		var sFile = file_path;
		var upObj = uploadObjects[0];
	
		upObj.Files = "";
	
		// IBUpload에 파일 추가하기
		upObj.AddFile(sFile);
	
		if(upObj.LocalFiles == "") {
			return;
		}
	
		upObj.ExtendParam = FormQueryString(formObj);
		upObj.ParamDecoding = true;
		var sXml = upObj.DoUpload(true);
		var fileKey = ComGetEtcData(sXml, "fileKey");
		//formObj.fileKey.value = fileKey;	
		return fileKey;	 		
	
	}
	
	/**
	 * RD Object 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initRdConfig(rdObject)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function initRdConfig(rdObject){
	
		var Rdviewer = rdObject;
		Rdviewer.style.height = 0;
		Rdviewer.style.width = 0;
		//Rdviewer.DisableToolbar(1)
	
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	
	}
	
	/**
	 * RD File 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @param {String} inv_no Invoice number
	 * @param {String} line_num Description lile 수 
	 * @param {String} user_nm 사용자명
	 * @param {String} ofc_cd office code
	 * @param {String} logo logo 명
	 * @param {String} vvd vvd
	 * @param {String} port_cd port code
	 * @param {String} attach letter wording 첨부 flag
	 * @param {String} cust_nm customer 명
	 * @param {String} title title 구분
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, cust_nm, title){  		
	
		var rdFile = "FNS_INV_0517.mrd";		
	
		var rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_customer_name ["+cust_nm+"] frm1_title ["+title+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
	
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
	
		// 열고자 하는 RD 파일을 지정한다.		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	
	}     
	
	/**
	 * RD File 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     rdOpenWordingByVVD(rdviewer, vvd, port_cd)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @param {String} vvd vvd
	 * @param {String} port_cd port code
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function rdOpenWordingByVVD(rdviewer, vvd, port_cd){   		 
	
		var rdFile = "FNS_INV_0524_vvd.mrd";
		var formObj = document.form;
		var ofc_cd = formObj.iss_ofc_cd.value;
	
		var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"]";
	
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
	
		// 열고자 하는 RD 파일을 지정한다.		
		rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	
	}      
	
	/**
	 * RD File 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     rdOpenWordingByCust(rdviewer, cust_cd)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @param {String} cust_cd Customer Code
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function rdOpenWordingByCust(rdviewer, cust_cd){   		 
	
		var rdFile = "FNS_INV_0524_cust.mrd";
		var formObj = document.form;
		var ofc_cd = formObj.iss_ofc_cd.value;
	
		var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]";
	
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
	
		// 열고자 하는 RD 파일을 지정한다.		
		rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	
	}              
	
	/**
	 * 첨부파일 Add, Delete 버튼 클릭 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnClick(sheetObj, row, col, value)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @param {int} Col ibsheet 해당 col
	 * @param {String} value ibsheet 해당 row, col의 값
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */  
	function sheet1_OnClick(sheetObj, row, col, value) {
	
		var formObj = document.form;
	
		if (sheetObj.ColSaveName(col) == "f_add") {
			if (sheetObj.CellValue(row, "f_key") == "") {
	
				var file = sheetObj.OpenFileDialog("", "", "C:\\","All Files(*.*)|*.*" );
				var fileKey = fileUpload(formObj, file);
				if (fileKey != "" && fileKey != undefined) {
					sheetObj.CellValue(row, "f_name") = file;
					sheetObj.CellValue(row, "f_key") = fileKey;    
				} else {
					sheetObj.CellValue(row, "f_name") = "";
					sheetObj.CellValue(row, "f_key") = "";    
				}       		    		
	
			} else {
	
				if(ComShowCodeConfirm("INV00124")) {
					var file = sheetObj.OpenFileDialog("", "", "C:\\","All Files(*.*)|*.*" );
					var fileKey = fileUpload(formObj, file);            		
					if (fileKey != "" && fileKey != undefined) {
						sheetObj.CellValue(row, "f_name") = file;
						sheetObj.CellValue(row, "f_key") = fileKey;    
					} else {
						sheetObj.CellValue(row, "f_name") = "";
						sheetObj.CellValue(row, "f_key") = "";    
					}
	
				} else {
					return;
				} 			
	
			}
	
		}
	
		if (sheetObj.ColSaveName(col) == "f_del") {
	
			sheetObj.CellValue(row, "f_name") = "";
			sheetObj.CellValue(row, "f_key") = "";
	
		}	
	
		if (sheetObj.ColSaveName(col) == "f_name") {	    	
	
			if (value != "") {
				document.getElementById("key").value = sheetObj.CellValue(row, "f_key");
				sheetObj.HtmlControlEnterKey("downbtn","sheet1");
				sheetObj.HtmlControlEnterKey("downbtn","sheet1");
			}
	
		}
	
		if (sheetObj.ColSaveName(col) == "f_copy") {
	
	
			if (sheetObj.CellValue(row, "f_key") != "") {
				for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
	
					if (sheetObj.CellValue(row, "vvd") == sheetObj.CellValue(idx, "vvd")) {
	
						sheetObj.CellValue2(idx, "f_name") = sheetObj.CellValue(row, "f_name");
						sheetObj.CellValue2(idx, "f_key") = sheetObj.CellValue(row, "f_key");
	
					}
	
				}
	
			}
	
		}
	
	}     
	
	/**
	 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setUploadObject(uploadObj)
	 * </pre>
	 * @param {ibupload} uploadObj IBUpload Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */  
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}    
	
	/**
	 * Help tooltip 을 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     showHelp()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */       
	function showHelp() {
		if(document.getElementById) { 
			var msg = "* Where e-mail address or fax no is brought from\n"
				+ "  - O/B : BKG Contact in BKG/DOC > S/I Contact in BKG/DOC > O/B contact in MDM\n"
				+ "  - I/B : I/B contact in MDM\n"
				+ "  - If nothing in above, e-mail or fax lastly sent is displayed in case of re-issue.\n";
			var elm = document.getElementById("help_layer")      
			elm.innerText = msg;
			elm.style.width = 500;
			//elm.style.height=obj.style.height
			elm.style.top = document.body.scrollTop+event.clientY - 50
			elm.style.left= document.body.scrollLeft+event.clientX - 500
			elm.style.visibility = "visible"
		}
	}
	
	/**
	 * Help tooltip 을 닫는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     showHelp()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */  	
	function hideHelp(){
	
		if(document.getElementById) { 
			var elm=document.getElementById("help_layer")     
			elm.style.visibility="hidden"
		}
	
	}
	
	/* 개발자 작업  끝 */