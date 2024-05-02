/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0025.js
*@FileTitle : Actual SKD Report Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.10 정진우
* 1.0 Creation
* ----------------------------------------------------------------------------------
* 2010.09.17 이준범 [CHM-201006029-01] Actual SKD Creation내 Delete 버튼에 대하여 권한 변경
* 현재 : PUSCOV, CLTCO 인 경우만 활성화
* 변경 : 지역(RHQ) 운항 담당자 권한이 있는 모든 사람에게 권한 부여
* 2011.03.14 진마리아 [CHM-201109291-01] Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.05.13 진마리아 [CHM-201110230-01] VSK-Actual SKD creation 화면 일부 수정 요청(EDI와 Departure Report 정보 구분)
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경 : Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 /ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2012.01.20 진마리아 [CHM-201215858-01] Actual SKD Creation내 Delete 버튼 확성 rule 변경
* 2012.03.20 진마리아 [CHM-201216747-01] Coastal SKD내 Actual SKD 바로 가기 버튼 추가
* 2012.08.28 진마리아 CHM-201219486-01 VSK_DEP_RPT 차단(FCM_DEP_RPT 대체) / ACT SKD과 VMS Data를 구별하여 alert
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * 2009.07.22 저장 시 체크로직 추가요청(모델에 반영되어 있으니 참고)
 * 
 * 
 * 
 * 
 * 
 */
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class vop_vsk_0025.jsp : vop_vsk_0025.jsp 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.initCombo            	= initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
     
   	/* 개발자 작업	*/
	// 현재 포커스를 가지고 있는 객체명 변수
	var focusObj = null;
	
	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;

	var glbDlayRsnCds1 = null;
	var glbDlayRsnNms1 = null;
	var glbDlayRsnCds2 = null;
	var glbDlayRsnNms2 = null;
	var glbVslCondCds = null;
	var glbVslCondNms = null;
	
	var keyDownFlag = false;
	
	var departFont = "#bc8f8f";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		/*******************************************************/
		var sheetObj = sheetObjects[0];
		var formObj = document.form;

     	try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;

 				case "btn_save":
 					doActionIBSheet(sheetObj, formObj, IBSAVE);
 					break;
 					
 				case "btn_delete":
 					doActionIBSheet(sheetObj, formObj, IBDELETE);
 					break;

				case "btn_vvd":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
					break;

				case "btn_new":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
					break;
					
				case "btn_remark_arr":
					if(!document.getElementById(srcName).disabled){
						doActionIBSheet(sheetObj, formObj, COMMAND03);
					}
					break;
					
				case "btn_remark_brth":
					if(!document.getElementById(srcName).disabled){
						doActionIBSheet(sheetObj, formObj, COMMAND04);
					}
					break;
					
				case "btn_remark_dep":
					if(!document.getElementById(srcName).disabled){
						doActionIBSheet(sheetObj, formObj, COMMAND05);
					}
					break;
					
				case "btn_Close":
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
 

	/**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}



	/**
	 * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
	function loadPage() {

		/////////////////////////////////////////////////////////
		if("Y"==document.form.pop_yn.value){
			//팝업버튼영역 보이기
			document.all.popLayer.style.display = "";
		}
		/////////////////////////////////////////////////////////
			
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);

		}

		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		initControl();
		
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		btnImgEnable(document.form.btn_remark_arr, false);
		btnImgEnable(document.form.btn_remark_brth, false);
		btnImgEnable(document.form.btn_remark_dep, false);
		
//		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		delayReasonControl(document.form, false);
		if(document.form.pop_yn.value=="Y"){
			searchCstPopup(document.form);
		}else{
			document.form.vsl_cd.focus();
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(3, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					/*
					 * mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
					 * SortEnable Boolean 선택  해더 행의 소트 가능 여부, Default=true 
					 * ColumnMove Boolean 선택  해더 행의 컬럼 이동 가능 여부, Default=false
					 * AllCheckEnable Boolean 선택  해더 행의 전체 CheckBox 표시 여부, Default=true
					 * UserResize Boolean 선택  해더 행의 컬럼 너비 변경 가능 여부, Default=true
					 * RowMove Boolean 선택  좌측 해더의 행 이동 가능 여부, Default=false
					 * Head3D Boolean 선택  해더 셀의 모양의 입체 여부Default=true 
					 */
					InitHeadMode(false, true, false, true, false, false);

					var HeadTitle1 = "|Sel|Seq";
					

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  							KEYFIELD, 	CALCULOGIC, DATAFORMAT, 		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	FULLINPUT, 	SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtDelCheck,		30,		daCenter,	true,		prefix+"del_chk",					false,		"",			dfNone,				0,			true,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		prefix+"clpt_seq",					false,		"",			dfNone,				0,			true,		true,		-1,			false,		true);
			   }
			   break;
		}
	}


	/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++ , "Vessel Movement" , -1 );
					InsertTab( cnt++ , "Vessel Condition" , -1 );
				}
				break;

		}
	}
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {
	    	case "vps_port_cd":
				with (comboObj) { 
					MultiSelect = false;
					SetTitle("SEQ|Port|C/S|Created");
					SetColAlign("center|left|center|center");        
					SetColWidth("38|70|35|60");
					ShowCol = 1;
					DropHeight = 160;
					ValidChar(2,0);
					MaxLength = 7;
				}
				break;
   	    	case "vsl_arr_dlay_rsn_cd":
   	    	case "vsl_brth_dlay_rsn_cd":
   	    	case "vsl_dep_dlay_rsn_cd":
//   	    	case "plt_unld_dlay_cd":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("40|300");
  					DropHeight = 160;
//					ColBackColor(0) = "#CCFFFD";
//  					ColBackColor(1) = "#CCFFFD";
   		    	}
   	    		break;
   	     }
   	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)){
					var parentObj = formObj.parentNode;
					//Dep에 대해서 색 표시 된 부분을 지운다.
			        var ele = document.form.elements;
			        for(var i=0; i<ele.length; i++){
			        	if(ele[i].style.backgroundColor.toUpperCase() == "#DDDDFF"){
			        		ele[i].style.backgroundColor = "#FFFFFF";
			        	}
			        }
			        
					formObj.f_cmd.value = SEARCH;
					
					var vParam = "vsl_cd=" + formObj.vsl_cd.value
							   + "&skd_voy_no=" + formObj.skd_voy_no.value
							   + "&skd_dir_cd=" + formObj.skd_dir_cd.value
							   + "&vps_port_cd=" + getComboObject("vps_port_cd").Code
							   + "&clpt_ind_seq=" + formObj.clpt_ind_seq.value
							   + "&loc_cd=" + formObj.loc_cd.value
					   		   + "&f_cmd=" + formObj.f_cmd.value;
//					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					var sParam = vParam + "&" + ComGetPrefixParam("sheet1_");
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0025GS.do", vParam);
					ComOpenWait(false);
					showSheetData(sheetObj, formObj, sXml);
				}
				break;

//			case SEARCH01:		//Call Indicator
//				formObj.f_cmd.value = SEARCH01;
//				
//				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0025GS.do", sParam);
//				
//				var ofcList    = ComGetEtcData(sXml, "rhq_list").split("|");		//turn_clpt_ind_seq Name
//				
//				var isExistOfc = false;
//				
//				for (var i=0; i < ofcList.length; i++){
//					if (ofcList[i] == gOfcCd){
//						isExistOfc = true;
//						break;
//					}
//				}
//				
//				if (gOfcCd == "PUSCOV" || gOfcCd == "CLTCO"){
//					isExistOfc = true;
//				}				
//				if (isExistOfc){
//					document.all.target_delete.style.display="";
//				}else{
//					document.all.target_delete.style.display="none";
//				}
//				break;
				
			case SEARCH03:		//vps_port_cd
				formObj.f_cmd.value = SEARCH03;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0025GS.do", sParam);
				var portList = ComGetEtcData(sXml, "port_list");

				ComVskXml2ComboItem(sXml, comboObjects[0], "val", "name");
				
				if(comboObjects[0].GetCount()>0){
					sheetObjects[0].Index = 1;
					getComboObject("vps_port_cd").focus();
				}
				
				break;
			case SEARCH10:		//VSL_CD Check
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH10;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0025GS.do", sParam);
					
					return sXml;
				}
				break;

			case IBSAVE:		//Save
				if(validateForm(sheetObj, formObj, sAction)){
//					if(ComShowCodeConfirm("VSK00038")){
					if(true){
						formObj.f_cmd.value = MULTI;
						
						setVslCondSts(formObj, "N");
						
						//======================================================
	//					var len = document.all.elements.length;
	//					for(i=0; i<len; i++){
	//						var inputObj = document.all.elements[i];
	//						if(inputObj.name.idexOf("wgt") > 0
	//								|| inputObj.name.idexOf("hgt") > 0
	//								|| inputObj.name.idexOf("knt") > 0){
	//				        	inputObj.value = ComAddComma(ComReplaceStr(inputObj, ",", ""));
	//						}
	//					}
						//======================================================
						var sParam = ComGetSaveString(sheetObjects, false);
						sParam += "&" + FormQueryString(formObj);
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSaveXml("VOP_VSK_0025GS.do", sParam);
						ComOpenWait(false);
						sheetObj.LoadSaveXml(sXml);
						
						// SAVE OK 일 경우 저장된 내용 다시 조회.
						var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
						if(nodeText == "OK"){
							doActionIBSheet(sheetObj, formObj, IBSEARCH);
						}
					}
				}
				break;
			
			case IBDELETE:	// PUSCOV 일 경우 삭제 가능.
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = REMOVE;
										
					var sParam = ComGetSaveString(sheetObjects, false);
					    sParam += "&" + FormQueryString(formObj);
					
					sheetObj.WaitImageVisible = false;
					
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0025GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
					
					// DELETE OK 일 경우 다시 조회.
					var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
				}
				break;
				
			case COMMAND02:		//VVD Search
				var vslCd = formObj.vsl_cd.value;
            	
            	if(vslCd == ""){
            		sUrl = "/hanjin/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;
				
			case COMMAND03:		//Remarks
            	var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + formObj.act_arr_rmk.value;
        		var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
        		if(rVal || rVal==""){
        			formObj.act_arr_rmk.value = rVal;
        		}
				break;
				
			case COMMAND04:		//Remarks
            	var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + formObj.act_brth_rmk.value;
        		var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
        		if(rVal || rVal==""){
        			formObj.act_brth_rmk.value = rVal;
        		}
				break;
				
			case COMMAND05:		//Remarks
            	var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + formObj.act_dep_rmk.value;
        		var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
        		if(rVal || rVal==""){
        			formObj.act_dep_rmk.value = rVal;
        		}
				break;

			case IBCLEAR:        //NEW
				clearAllFormData(formObj);
				break;
		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction){
		switch(sAction) {
			case IBSEARCH:      //조회
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (formObj.vsl_cd.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.value = "";
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
				 	formObj.skd_voy_no.focus();
					return false;
				} else if (formObj.skd_voy_no.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.value = "";
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				} else if(getComboObject("vps_port_cd").Code == ""){
					ComShowCodeMessage('VSK00027', "Port Code");
					getComboObject("vps_port_cd").focus();
					return false;
				}
				break;
				
			case IBSAVE:		//Save
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (formObj.vsl_cd.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.value = "";
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
				 	formObj.skd_voy_no.focus();
					return false;
				} else if (formObj.skd_voy_no.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.value = "";
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				} else if(getComboObject("vps_port_cd").Code == ""){
					ComShowCodeMessage('VSK00027', "Port Code");
					getComboObject("vps_port_cd").focus();
					return false;
				} else if(formObj.diff_rmk.value.length > 3999){
					ComShowCodeMessage('VSK00045');
					formObj.diff_rmk.focus();
					return false;
				} else if(formObj.act_arr_rmk.value.length > 1000){
					ComShowCodeMessage('VSK00045');
					formObj.act_arr_rmk.focus();
					return false;
				} else if(formObj.act_brth_rmk.value.length > 1000){
					ComShowCodeMessage('VSK00045');
					formObj.act_brth_rmk.focus();
					return false;
				} else if(formObj.act_dep_rmk.value.length > 1000){
					ComShowCodeMessage('VSK00045');
					formObj.act_dep_rmk.focus();
					return false;
				}
				
				// Vessel Condition 은 저장 된 값보다 이전 상태로 변경 불가.
				var orgStsCd = formObj.org_port_skd_sts_cd.value;
				
				//alert('orgStsCd  ['+orgStsCd+']');
				//alert('act_dep_dt  ['+formObj.act_dep_dt.value+']');
				
				if(orgStsCd == "D"){
					if(formObj.act_dep_dt.value == ""){
						ComShowCodeMessage('VSK00027', "Departure Date");
						formObj.act_dep_dt.focus();
						return false;
					}
				}else if(orgStsCd == "B"){
					if(formObj.act_brth_dt.value == ""){
						ComShowCodeMessage('VSK00027', "Berth Date");
						formObj.act_brth_dt.focus();
						return false;
					}
				}else if(orgStsCd == "A"){
					if(formObj.act_arr_dt.value == ""){
						ComShowCodeMessage('VSK00027', "Arrival Date");
						formObj.act_arr_dt.focus();
						return false;
					}
				}

				//Actual SKD Date Check
				var prePortCd = formObj.pre_port_cd.value;
				var preEtdDt = formObj.pre_etd_dt.value;
				var actArrDt = formObj.act_arr_dt.value;
				var actBrthDt = formObj.act_brth_dt.value;
				var actDepDt = formObj.act_dep_dt.value;
				var nxtEtaDt = formObj.nxt_eta_dt.value;
				var nxtActInpFlg = formObj.nxt_act_inp_flg.value;
				var nxtPortCd	= formObj.nxt_port_cd.value;
				
				// ATA, ATB, ATD 모두 입력이 안되어 있으면 저장 안되도록 막음.
				if(actArrDt == "" && actBrthDt == "" && actDepDt == ""){
					ComShowCodeMessage('VSK00027', "ATA, ATB, ATD");
					if(document.all.item("tabLayer")[1].style.display == "inline"){
						tabObjects[0].SelectedIndex = 0;
					}
					formObj.act_arr_dt.focus();
					return false;
				}
				
				// 이전 Port 의 ETD 보다 ATA 가 이전 날짜이면 막음.
				if(actArrDt != "" && preEtdDt != ""){
					if(!isValidDate(formObj, preEtdDt, actArrDt)){
						ComShowCodeMessage("VSK00055", actArrDt, preEtdDt, prePortCd);
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SelectedIndex = 0;
						}
						
						formObj.act_arr_dt.focus();
						return false;
					}
				}
				
				// ATA 보다 ATB 가 이전 날짜이면 막음.
				if(actArrDt != "" && actBrthDt != ""){
					if(!isValidDate(formObj, actArrDt, actBrthDt)){
						ComShowCodeMessage("VSK00056", actBrthDt, actArrDt);
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SelectedIndex = 0;
						}
						formObj.act_brth_dt.focus();
						return false;
					}
				}else if(actBrthDt != ""){	// ATB 는 입력 되었는데 ATA 가 입력이 안되 있으면 막음.
					ComShowCodeMessage("VSK01017", 'ATA');
					if(document.all.item("tabLayer")[1].style.display == "inline"){
						tabObjects[0].SelectedIndex = 0;
					}
					formObj.act_arr_dt.focus();
					return false;
				}
				
				// ATB 보다 ATD 가 이전 날짜이면 막음.
				if(actBrthDt != "" && actDepDt != ""){
					if(!isValidDate(formObj, actBrthDt, actDepDt)){
						ComShowCodeMessage("VSK00057", actDepDt, actBrthDt);
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SelectedIndex = 0;
						}
						formObj.act_dep_dt.focus();
						return false;
					}
				}else if(actDepDt != "" ){	// ATD 는 입력 되었는데 ATB 가 입력이 안되 있으면 막음.
					if(actArrDt == ""){
						ComShowCodeMessage("VSK01017", 'ATA, ATB');
					}else{
						ComShowCodeMessage("VSK01017", 'ATB');
					}
					if(document.all.item("tabLayer")[1].style.display == "inline"){
						tabObjects[0].SelectedIndex = 0;
					}
					formObj.act_brth_dt.focus();
					return false;
				}
				
				// 다음 Port 의 ETA 가 ATD 보다 이전 날짜이면 막음. 
				if(actDepDt != "" && nxtEtaDt != ""){
					if(nxtActInpFlg == "Y"){
						if(!isValidDate(formObj, actDepDt, nxtEtaDt)){
							ComShowCodeMessage("VSK00058", actDepDt, nxtEtaDt, nxtPortCd);
							if(document.all.item("tabLayer")[1].style.display == "inline"){
								tabObjects[0].SelectedIndex = 0;
							}
							formObj.act_dep_dt.focus();
							return false;
						}
					}
				}
				
				if(formObj.plt_lst_unld_dt.value != ""){
					if(!ComIsDateTime(formObj.plt_lst_unld_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.plt_lst_unld_dt.focus();
						return false;
					}
				}
				if(formObj.bfr_brth_ank_drp_dt.value != ""){
					if(!ComIsDateTime(formObj.bfr_brth_ank_drp_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.bfr_brth_ank_drp_dt.focus();
						return false;
					}
				}
				if(formObj.bfr_brth_ank_off_dt.value != ""){
					if(!ComIsDateTime(formObj.bfr_brth_ank_off_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.bfr_brth_ank_off_dt.focus();
						return false;
					}
				}
				if(formObj.aft_unbrth_ank_drp_dt.value != ""){
					if(!ComIsDateTime(formObj.aft_unbrth_ank_drp_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.aft_unbrth_ank_drp_dt.focus();
						return false;
					}
				}
				if(formObj.aft_unbrth_ank_off_dt.value != ""){
					if(!ComIsDateTime(formObj.aft_unbrth_ank_off_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.aft_unbrth_ank_off_dt.focus();
						return false;
					}
				}
				
				//Delay Reason Check.
				//지연 시간 8시간 발생시 Delay Reason 컬럼을 필수항목으로 바탕색을 바꾸고, 
				//Save시 "Delay Reason 정보를 입력하세요"라는 메시지를 띄우고 해당 컬럼으로 Focus를 이동 시킨다.
				if(formObj.dlay_arr_tm.value != null && formObj.dlay_arr_tm.value != ""){
					if(Number(formObj.dlay_arr_tm.value) >= 8){
						if(getComboObject("vsl_arr_dlay_rsn_cd").Code == ""){
							ComShowCodeMessage('VSK00066');
							getComboObject("vsl_arr_dlay_rsn_cd").focus();
							return false;
						}
					}
				}
				if(formObj.dlay_brth_tm.value != null && formObj.dlay_brth_tm.value != ""){
					if(Number(formObj.dlay_brth_tm.value) >= 8){
						if(getComboObject("vsl_brth_dlay_rsn_cd").Code == ""){
							ComShowCodeMessage('VSK00066');
							getComboObject("vsl_brth_dlay_rsn_cd").focus();
							return false;
						}
					}
				}
				if(formObj.dlay_dep_tm.value != null && formObj.dlay_dep_tm.value != ""){
					if(Number(formObj.dlay_dep_tm.value) >= 8){
						if(getComboObject("vsl_dep_dlay_rsn_cd").Code == ""){
							ComShowCodeMessage('VSK00066');
							getComboObject("vsl_dep_dlay_rsn_cd").focus();
							return false;
						}
					}
				}
				
				//Delay Reson Code에서  OTH 코드로 입력 될 경우 Remark를 반드시 저장하도록 처리함. 2014/08/06
				if(formObj.vsl_arr_dlay_rsn_nm.value == "Others"){
					if(formObj.act_arr_rmk.value == ""){
						ComShowCodeMessage('VSK00044');
						formObj.act_arr_rmk.focus();
						return false;
					}
				}
				
				if(formObj.vsl_brth_dlay_rsn_nm.value == "Others"){
					if(formObj.act_brth_rmk.value == ""){
						ComShowCodeMessage('VSK00044');
						formObj.act_brth_rmk.focus();
						return false;
					}
				}
				
				if(formObj.vsl_dep_dlay_rsn_nm.value == "Others"){
					if(formObj.act_dep_rmk.value == ""){
						ComShowCodeMessage('VSK00044');
						formObj.act_dep_rmk.focus();
						return false;
					}
				}
				break;
				
				case IBDELETE:		//Delete
				
				if(!ComShowCodeConfirm("VSK00005")){
					return false;
				}
				
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (formObj.vsl_cd.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.value = "";
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
				 	formObj.skd_voy_no.focus();
					return false;
				} else if (formObj.skd_voy_no.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.value = "";
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				} else if(getComboObject("vps_port_cd").Code == ""){
					ComShowCodeMessage('VSK00027', "Port Code");
					getComboObject("vps_port_cd").focus();
					return false;
				}
				
				break;
		}

		return true;
	}

	/**
	 * 조회 후 처리로직.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix = sheetObj.id + "_";
		
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var errNode = rootNode.selectNodes("//ERROR");
			if(errNode.length > 0){
				sheetObj.LoadSearchXml(sXml);
				clearAllFormData(formObj);
				formObj.vsl_cd.focus();
				return;
			}else{
				var dataNode = rootNode.selectNodes("//ETC");
				if(dataNode.length > 0){
					// Close Check !
					var skdStsCd = ComGetEtcData(sXml, "SKD_STS_CD");
					var portSkdStsCd = ComGetEtcData(sXml, "PORT_SKD_STS_CD");
					
					if(skdStsCd == "CLO"){
						ComShowCodeMessage("VSK00100");
						// Save Button Disable 처리
						ComBtnDisable("btn_save");
						ComBtnDisable("btn_delete");
					}else{
						ComBtnEnable("btn_save");
						if (VskIsNull(portSkdStsCd)) {
							// Delete Button Disable 처리
							ComBtnDisable("btn_delete");
						}else{
							ComBtnEnable("btn_delete");
						}
					}
			
					setFormToEtcData(sXml);
					
					setDelayTime(formObj);
					delayReasonControl(formObj, false);
					
					glbVslCondCds = ComGetEtcData(sXml, "vsl_cond_cd").split("|");
					glbVslCondNms = ComGetEtcData(sXml, "vsl_cond_nm").split("|");
					
					
					//alert('port_skd_sts_cd  ['+formObj.port_skd_sts_cd.value+']');
					setVslCondSts(formObj);
					formObj.org_port_skd_sts_cd.value = formObj.port_skd_sts_cd.value;
					
					//alert('port_skd_sts_cd  ['+formObj.port_skd_sts_cd.value+']');
					

					glbDlayRsnCds1 = ("|"+ComGetEtcData(sXml, "dlay_rsn_cd")).split("|");	//Delay Reason
					glbDlayRsnNms1 = ("|"+ComGetEtcData(sXml, "dlay_rsn_nm")).split("|");	//Delay Reason
					glbDlayRsnCds2 = ("|"+ComGetEtcData(sXml, "dlay_rsn_cd")).split("|");	//Delay Reason
					glbDlayRsnNms2 = ("|"+ComGetEtcData(sXml, "dlay_rsn_nm")).split("|");	//Delay Reason
					
//					alert(glbDlayRsnCds1);
//					alert(glbDlayRsnNms1);
//					alert(glbDlayRsnCds2);
//					alert(glbDlayRsnNms2);


					var code1 = ["SBW","SMT","SVD","SDA","WAD","WPG","WPC","WPV","WMT","WCA","WIO","WNH","OTH"];
					var code2 = ["BTT","BLS","BDA","BNS","BCW","BCM","BRB","BSP"];
					var tmpCode1 = "";
					var tmpRsn1 = "";
					var tmpCode2 = "";
					var tmpRsn2 = "";
					
					for(i=0; i<=code1.length; i++){
						for(j=0; j<glbDlayRsnCds1.length; j++){
							if(code1[i] == glbDlayRsnCds1[j]){
									tmpCode1 += "|" + glbDlayRsnCds1[j];
									tmpRsn1 += "|" + glbDlayRsnNms1[j];
							}
						}
					}
					
					for(i=0; i<=code2.length; i++){
						for(j=0; j<glbDlayRsnCds2.length; j++){
							if(code2[i] == glbDlayRsnCds2[j]){
								tmpCode2 += "|" + glbDlayRsnCds2[j];
								tmpRsn2 += "|" + glbDlayRsnNms2[j];
							}
						}
					}
					
					glbDlayRsnCds1 = tmpCode1.split('|');
					glbDlayRsnNms1 = tmpRsn1.split('|');
					glbDlayRsnCds2 = tmpCode2.split('|');
					glbDlayRsnNms2 = tmpRsn2.split('|');
					
					
					var vslArrDlayRsnCd = ComGetEtcData(sXml, "VSL_ARR_DLAY_RSN_CD").split("|");	//Delay Reason
					var vslBrthDlayRsnCd = ComGetEtcData(sXml, "VSL_BRTH_DLAY_RSN_CD").split("|");	//Delay Reason
					var vslDepDlayRsnCd = ComGetEtcData(sXml, "VSL_DEP_DLAY_RSN_CD").split("|");	//Delay Reason
	//				var pltUnldDlayCd = ComGetEtcData(sXml, "PLT_UNLD_DLAY_CD").split("|");	//Delay Reason
					
					
					for(var i=0; i<comboObjects.length; i++){
						if(comboObjects[i].id == "vsl_arr_dlay_rsn_cd"){
//							  
													
							appendMultiComboItem(comboObjects[i], glbDlayRsnCds1, glbDlayRsnNms1, vslArrDlayRsnCd);
							setSelectMultiText(comboObjects[i], formObj.vsl_arr_dlay_rsn_nm);
							
						}else if(comboObjects[i].id == "vsl_brth_dlay_rsn_cd"){
							appendMultiComboItem(comboObjects[i], glbDlayRsnCds2, glbDlayRsnNms2, vslBrthDlayRsnCd);
							setSelectMultiText(comboObjects[i], formObj.vsl_brth_dlay_rsn_nm);
						}else if(comboObjects[i].id == "vsl_dep_dlay_rsn_cd"){
							appendMultiComboItem(comboObjects[i], glbDlayRsnCds2, glbDlayRsnNms2, vslDepDlayRsnCd);
							setSelectMultiText(comboObjects[i], formObj.vsl_dep_dlay_rsn_nm);
						}
					}
					
					formObj.diff_rmk.value = ComGetEtcData(sXml, "DIFF_RMK");
					controlDelete();
					controlLayerPopup(formObj);
				}else{
					sheetObj.LoadSearchXml(sXml);
	//				ComShowCodeMessage('VSK00043');
					clearAllFormData(formObj);
					formObj.vsl_cd.focus();
					return;
				}
			}
		}else{
			sheetObj.LoadSearchXml(sXml);
			clearAllFormData(formObj);
			formObj.vsl_cd.focus();
			return;
		}
	}

	/*
	 * =====================================================================
	 * Tab Event
	 * =====================================================================
	 */

	/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */

	function vps_port_cd_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	function vps_port_cd_OnChange(comboObj, Index_Code, Text){
		var formObj = document.form;
		var sText = Text.split('|');
		if(sText[2]==undefined){
			sText = Text.split(',')
		}
		var clptIndSeq = sText[2];
		formObj.clpt_ind_seq.value = clptIndSeq;
		formObj.loc_cd.value = Index_Code;
		clearAllFormData(formObj, "S");
		layer_popup_hide();
	}
	
	function vsl_arr_dlay_rsn_cd_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		setSelectMultiText(comboObj, formObj.vsl_arr_dlay_rsn_nm);
	}
	
	function vsl_brth_dlay_rsn_cd_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		setSelectMultiText(comboObj, formObj.vsl_brth_dlay_rsn_nm);
	}
	
	function vsl_dep_dlay_rsn_cd_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		setSelectMultiText(comboObj, formObj.vsl_dep_dlay_rsn_nm);
	}
	
//	function plt_unld_dlay_cd_OnChange(comboObj, Index_Code, Text) {
//		var formObj = document.form;
//		setSelectMultiText(comboObj, formObj.plt_unld_dlay_nm);
//	}

	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('activate', "obj_activate", form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	// - form 전체 컨트롤 onkeydownup 이벤트에 코드 처리
	}
    
	function obj_change(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
	        switch(srcName) {	
	            case "vsl_cd":
	            	layer_popup_hide();
	            	if(eleObj.value.length == 0){
	            		clearAllFormData(formObj, "N");
	            	}else{
	            		clearAllFormData(formObj, "S");
	            	}
	            	
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		formObj.skd_voy_no.focus();
	            	}else{
	            		formObj.vsl_cd.focus();
	            		return false;
	            	}
	            	break;
	            	
	            case "skd_voy_no":
	            case "skd_dir_cd":
	            	layer_popup_hide();
	            	if(eleObj.value.length == 0){
	            		clearAllFormData(formObj, "N");
	            	}else{
	            		clearAllFormData(formObj, "S");
	            	}
	            	break;
	
	            case "act_arr_dt":
	            case "act_brth_dt":
	            case "act_dep_dt":
//	            	Usr_setDateTime(formObj, srcName);
	            	setDelayTime(formObj);
	            	delayReasonControl(formObj, true);
	            	setVslCondSts(formObj, "N");
	            	
	            	var actArrDt = Usr_replaceDateOrigin(formObj.act_arr_dt.value);
	            	var actBrthDt = Usr_replaceDateOrigin(formObj.act_brth_dt.value);
	            	var actDepDt = Usr_replaceDateOrigin(formObj.act_dep_dt.value);
	            	
	            	if(actArrDt != "" && actBrthDt != "" && actDepDt == ""){
		            	var timeDiffHour = setParsingDiffTime(actArrDt, actBrthDt);
		            	var timeDiffDay = Number(timeDiffHour/24);
		            	if(timeDiffDay > 31 || timeDiffDay < -31){
							ComShowCodeMessage('VSK57025');
		            	}
	            	}
	            	
	            	if(actArrDt == "" && actBrthDt != "" && actDepDt != ""){
	            		var timeDiffHour = setParsingDiffTime(actArrDt, actBrthDt);
		            	var timeDiffDay = Number(timeDiffHour/24);
		            	if(timeDiffDay > 31 || timeDiffDay < -31){
							ComShowCodeMessage('VSK57025');
		            	}
	            	}
	            	
	            	if(actArrDt != "" && actBrthDt != "" && actDepDt != ""){
	            		var timeDiffHour1 = setParsingDiffTime(actArrDt, actBrthDt);
		            	var timeDiffDay1 = Number(timeDiffHour1/24);
		            	
		            	var timeDiffHour2 = setParsingDiffTime(actBrthDt, actDepDt);
		            	var timeDiffDay2 = Number(timeDiffHour2/24);
		            	
		            	if(timeDiffDay1 > 30 || timeDiffDay1 < -30){
		            		if(timeDiffDay2 > 31 || timeDiffDay2 < -31){
								ComShowCodeMessage('VSK57025');
		            		}else{
			            		ComShowCodeMessage('VSK57025');
		            		}
		            	}else if(timeDiffDay2 > 31 || timeDiffDay2 < -31){
		            		ComShowCodeMessage('VSK57025');
		            	}
	            	}
	            	
	            	break;
	            	
//	            case "plt_lst_unld_dt":
//	            case "bfr_brth_ank_drp_dt":
//	            case "bfr_brth_ank_off_dt":
//	            case "aft_unbrth_ank_drp_dt":
//	            case "aft_unbrth_ank_off_dt":
//	            	Usr_setDateTime(formObj, srcName);
	            	break;
	                
	        } // end switch

	        //[TAB] Vessel Condition 의 input Element들의 숫자타입 체크
	        if(srcName){
		        var inputObj = document.getElementsByName(srcName)[0];
		        var parentObj = inputObj.parentNode;
		        while(parentObj.parentNode){
		        	parentObj = parentObj.parentNode;
		        	if(parentObj.tagName.toLowerCase() == "table"){
		        		
			        	if(parentObj.id == "tbl_vsl_cond"){
			        	
			        		//+=======================================================
			        		//소수점 2개이상 있으면 지워버림.
			        		var cCnt = 0;
			        		for(var i=0; i<inputObj.value.length; i++) {
			            		if (".".charCodeAt() == inputObj.value.charCodeAt(i)) {
			            			cCnt++;
			            		}
			            	}
			        		if(cCnt > 1){
			        			inputObj.value = "";
			        			return;
			        		}
			        		//+=======================================================
			        		inputObj.value = ComAddComma(ComReplaceStr(inputObj, ",", ""));
			        		
			        	}else{
			        		break;
			        	}
		        	}
		        }
	        }
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function obj_keypress(){
		var formObj = document.form;
		var srcName = event.srcElement.name;
		
		switch (srcName) {
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(formObj.skd_voy_no);
				break;

		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;

            case "act_arr_dt":
            case "act_brth_dt":
            case "act_dep_dt":
		    case "plt_lst_unld_dt":
            case "bfr_brth_ank_drp_dt":
            case "bfr_brth_ank_off_dt":
            case "aft_unbrth_ank_drp_dt":
            case "aft_unbrth_ank_off_dt":
//            	ComKeyOnlyNumber(document.getElementsByName(srcName)[0], ",:");
            	ComKeyOnlyNumber(document.getElementsByName(srcName)[0]);
            	break;
		}
		
		//[TAB] Vessel Condition 의 input Element들의 숫자타입 체크
		if(srcName){
			var inputObj = document.getElementsByName(srcName)[0];
	        var parentObj = inputObj.parentNode;
	        while(parentObj.parentNode){
	        	parentObj = parentObj.parentNode;
	        	if(parentObj.tagName.toUpperCase() == "TABLE"){
		        	if(parentObj.id == "tbl_vsl_cond"){
		        		VskKeyOnlyNumber(inputObj, ".");
		        		break;
		        	}else{
		        		break;
		        	}
	        	}
	        }
		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var srcName = eleObj.name;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		switch (srcName) {
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		doActionIBSheet(sheetObj, formObj, SEARCH03);
		    		if(keyDownFlag){
		    			getComboObject("vps_port_cd").focus();
		    			keyDownFlag = false;
		    		}else{
		    			formObj.skd_voy_no.focus();
		    		}
		    	}
				break; 
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		doActionIBSheet(sheetObj, formObj, SEARCH03);
		    		formObj.skd_dir_cd.focus();
		    	}
				break;
 
				
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		doActionIBSheet(sheetObj, formObj, SEARCH03);
		    	}
				break; 
		}
		if(srcName){
			var inputObj = event.srcElement;
	        var parentObj = inputObj.parentNode;
	        while(parentObj.parentNode){
	        	parentObj = parentObj.parentNode;
	        	if(parentObj.tagName.toUpperCase() == "TABLE"){
		        	if(parentObj.id == "tbl_vsl_cond"){
		        		VskKeyNumberPointVaild(inputObj);
		        		break;
		        	}else{
		        		break;
		        	}
	        	}
	        }
		}
	}
	
	function obj_keydown(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(focusObj=="vsl_cd"){
			var ctrl = event.ctrlKey;
			var code = event.keyCode;
			if(ctrl && code == 86){ 
				var clipData = window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData = clipData.toUpperCase();
					formObj.vsl_cd.value = clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value = clipData.substring(4, 8);
						formObj.skd_dir_cd.value = clipData.substring(8, 9);
						keyDownFlag = true;
					}
				}
				event.returnValue = false;
			}
		}
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		if(srcName){
			focusObj = srcName;
		}else{
			focusObj = "";
		}
		
		switch(srcName){
			case "act_arr_dt":
			case "act_brth_dt":
			case "act_dep_dt":
			case "plt_lst_unld_dt":
			case "bfr_brth_ank_drp_dt":
			case "bfr_brth_ank_off_dt":
			case "aft_unbrth_ank_drp_dt":
			case "aft_unbrth_ank_off_dt":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				break;
				
//			case "vsl_cd":
//			case "skd_voy_no":
//			case "skd_dir_cd":
//				event.srcElement.select();
//				break;
		}
		
		if(srcName){
			var inputObj = event.srcElement;
	        var parentObj = inputObj.parentNode;
	        while(parentObj.parentNode){
	        	parentObj = parentObj.parentNode;
	        	if(parentObj.tagName.toUpperCase() == "TABLE"){
		        	if(parentObj.id == "tbl_vsl_cond"){
		        		ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
		        		
		        		var oLen = inputObj.value.length;
	            		var dPos = inputObj.value.indexOf(".");
	            		var oCapLen = inputObj.caption.length;
	            		var dCapPos = inputObj.caption.indexOf(".");
	            		
	            		if((oLen - dPos) > (oCapLen - dCapPos)){
	            			event.returnValue = false;
	            			return;
	            		}
	            		
	            		var iVal = inputObj.value.substring(0, dPos);
		        	}else{
		        		break;
		        	}
	        	}
	        }
		}
	}
	
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "act_arr_dt":
			case "act_brth_dt":
			case "act_dep_dt":
			case "plt_lst_unld_dt":
			case "bfr_brth_ank_drp_dt":
			case "bfr_brth_ank_off_dt":
			case "aft_unbrth_ank_drp_dt":
			case "aft_unbrth_ank_off_dt":
				ComChkObjValid(event.srcElement);
				break;
		}

		if(srcName){
			var inputObj = event.srcElement;
	        var parentObj = inputObj.parentNode;
	        while(parentObj.parentNode){
	        	parentObj = parentObj.parentNode;
	        	if(parentObj.tagName.toUpperCase() == "TABLE"){
		        	if(parentObj.id == "tbl_vsl_cond"){
		        		VskKeyNumberPointVaild(inputObj);
		        		ComChkObjValid(event.srcElement);
		        		break;
		        	}else{
		        		break;
		        	}
	        	}
	        }
		}
	}
    
    
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
    
	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 처리.
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj = document.form;
    	
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value = rtnDatas[1];
					clearAllFormData(formObj, "S");
				}
			}
    	}
    }

    /**
     * VVD Code Help (Pop-Up)에서 받은 데이타 처리.
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj = document.form;
		
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value = rtnDatas[2];
					formObj.skd_dir_cd.value = rtnDatas[3];
					clearAllFormData(formObj, "S");
					
					doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
				}
			}
    	}
    }
	
	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
	
	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
		comboObj.RemoveAll();
    	for(var i=0; i<optionCds.length; i++) {
			comboObj.InsertItem(i, optionCds[i]+"|"+optionTxts[i], optionCds[i]);
		}
		comboObj.Code2 = selCode;
	}
	
	
	/**
	 * Multi Combo의 선택된 desc를 해당 inputObj에 보여준다.
	 * @param comboObj
	 * @param inputObj
	 * @return
	 */
	function setSelectMultiText(comboObj, inputObj){
		var idx = comboObj.Index;
		if(comboObj.id == 'vsl_arr_dlay_rsn_cd'){
	    	if(idx != null && idx != undefined){
	    		if(glbDlayRsnNms1[idx] != null && glbDlayRsnNms1[idx] != undefined){
	    			document.getElementsByName(inputObj.name)[0].value = glbDlayRsnNms1[idx];
	    		}else{
	    			document.getElementsByName(inputObj.name)[0].value = "";
	    		}
	    	}
		}else{
	    	if(idx != null && idx != undefined){
	    		if(glbDlayRsnNms2[idx] != null && glbDlayRsnNms2[idx] != undefined){
	    			document.getElementsByName(inputObj.name)[0].value = glbDlayRsnNms2[idx];
	    		}else{
	    			document.getElementsByName(inputObj.name)[0].value = "";
	    		}
	    	}
		}

    	

	}
	
	/**
	 * Delay Reason Combo 변경 Event 시 호출.
	 * @param comboObj
	 * @param inputObj
	 * @return
	 */
	function setSelectedText(comboObj, inputObj){
		var idx = document.getElementsByName(comboObj.name)[0].options.selectedIndex;
    	if(idx != null && idx != undefined){
    		document.getElementsByName(inputObj.name)[0].value = glbDlayRsnNms[idx];
    	}
	}
	
	/**
	 * xml로 받은 전문을 읽어 form 객체들에 value를 찾아 Setting...
	 * @param sXml
	 * @return
	 */
	function setFormToEtcData(sXml){
		var rootNode = VskGetXmlRootNode(sXml);
		if(rootNode.selectNodes("//ETC")){
			var dataNodes = rootNode.selectNodes("//ETC");
			var keyValue = "";
			var inputName = "";
			for(var i=0; i<dataNodes.length; i++){
				keyValue = dataNodes[i].selectSingleNode("@KEY").nodeValue;
				inputName = keyValue.toLowerCase();
				
				if(document.getElementsByName(inputName)[0]){
					var inputObj = document.getElementsByName(inputName)[0];
					if(inputObj.type == "text" || inputObj.type == "hidden"){

						//vessel condition에 대해서는 Departure Report 데이터의 경우 색을 변환하여 보여준다.
						var tab2Obj = false;
						var parentObj = inputObj.parentNode;
				        while(parentObj.parentNode){
				        	parentObj = parentObj.parentNode;
				        	if(parentObj.tagName){
				        		if(parentObj.tagName.toUpperCase() == "TABLE"){
						        	if(parentObj.id == "tbl_vsl_cond"){
						        		tab2Obj = true;
						        	}
						        	break;
					        	}
				        	}
				        }
				        inputObj.value = ComGetEtcData(sXml, keyValue);
						if(tab2Obj){
							var flgValue = ComGetEtcData(sXml, keyValue + "_FLG");
							if(flgValue == "Dep"){
								inputObj.style.backgroundColor = "#DDDDFF";
								//inputObj.style.backgroundColor = departFont;
							}
						}
						
						if(  ComGetEtcData(sXml,"FLAG") != "A" ) 
						{
							if(ComGetEtcData(sXml,"PLT_LST_UNLD_DT")  != "" ){
								document.form.plt_lst_unld_dt.style.backgroundColor = "#DDDDFF";
							}
							if(ComGetEtcData(sXml,"BFR_BRTH_ANK_DRP_DT")  != "" ){
								document.form.bfr_brth_ank_drp_dt.style.backgroundColor= "#DDDDFF";
							}
							if(ComGetEtcData(sXml,"BFR_BRTH_ANK_OFF_DT")  != "" ){
								document.form.bfr_brth_ank_off_dt.style.backgroundColor= "#DDDDFF";
							}
							if(ComGetEtcData(sXml,"AFT_UNBRTH_ANK_DRP_DT")  != "" ){
								document.form.aft_unbrth_ank_drp_dt.style.backgroundColor= "#DDDDFF";
							}
							if(ComGetEtcData(sXml,"AFT_UNBRTH_ANK_OFF_DT")  != "" ){
								document.form.aft_unbrth_ank_off_dt.style.backgroundColor= "#DDDDFF";
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 해당 Form의 Data들을 지운다.
	 * @param formObj
	 * @return
	 */
	function clearAllFormData(formObj, flag){
		var eleObjs = formObj.elements;
		var len = eleObjs.length;
		for(var i=0; i<len; i++){
			if(flag != null && flag != undefined && flag != ""){
				if(eleObjs[i].name == "vsl_cd"
					|| eleObjs[i].name == "skd_voy_no"
					|| eleObjs[i].name == "skd_dir_cd"){
					//pass
				}else{
					ComClearObject(eleObjs[i]);
				}
			}else{
				ComClearObject(eleObjs[i]);
			}
		}
		
		//remark remove
		formObj.diff_rmk.value = "";
		formObj.act_arr_rmk.value = "";
		formObj.act_brth_rmk.value = "";
		formObj.act_dep_rmk.value = "";
		
		//Delay Reason Combo Remove...
		for(var i=0; i<comboObjects.length; i++){
			if(flag == "S") i++;
			comboObjects[i].RemoveAll();
		}
		
		//Delay Reason Editable 설정.
		delayReasonControl(formObj, false);
		
		if(flag != "S" && flag != "N"){
			document.form.vps_port_cd.focus();
		}
		
		//popup hide
		layer_popup_hide();
		
		ComBtnDisable("btn_save");
		document.all.target_delete.style.display="none";
		ComBtnDisable("btn_delete");
		btnImgEnable(document.form.btn_remark_arr, false);
		btnImgEnable(document.form.btn_remark_brth, false);
		btnImgEnable(document.form.btn_remark_dep, false);
		
		//Coastal SKD에서 팝업으로 오픈시 잠겼던 조회조건들을 푼다.
		if(document.form.pop_yn.value=="Y"){
			document.form.vps_port_cd.Enable = true;
			document.form.vsl_cd.readOnly = false;
			document.form.skd_voy_no.readOnly = false;
			document.form.skd_dir_cd.readOnly = false;
			document.form.vsl_cd.className="input1";
			document.form.skd_voy_no.className="input1";
			document.form.skd_dir_cd.className="input1";
//			document.form.pop_yn.value="N";//팝업으로 열린 경우의 로직을 타지 않도록.
		}
	}
	
	/**
	 * Vessel Movement - Vessel Condition 을 Setting...
	 * 조회조건의 Vessel Condition을 상태에 맞는 값을 찾아서 Setting...
	 * 
	 * @param sXml
	 * @param formObj
	 * @return
	 */
	function setVslCondSts(formObj, flag){
		if(glbVslCondCds == null || glbVslCondCds.length < 1) return;
		
		var portSkdStsCd = "";
		
		//alert('setVslCondSts >> setVslCondSts, flag ['+flag+']');
		
		
		if(flag != "N"){
			portSkdStsCd = formObj.port_skd_sts_cd.value;
		}
		
		//alert('setVslCondSts >> port_skd_sts_cd ['+formObj.port_skd_sts_cd.value+']');
		
		if(portSkdStsCd != ""){
			for(var i=0; i<glbVslCondCds.length; i++){
				if(glbVslCondCds[i] == portSkdStsCd){
					formObj.port_skd_sts_nm.value = glbVslCondNms[i];
				}
			}
		}else{
			if (formObj.act_dep_dt.value != ""){
				for(var i=0; i<glbVslCondCds.length; i++){
					if(glbVslCondCds[i] == "D"){
						formObj.port_skd_sts_cd.value = glbVslCondCds[i];
						formObj.port_skd_sts_nm.value = glbVslCondNms[i];
					}
				}
			}else if(formObj.act_brth_dt.value != ""){
				for(var i=0; i<glbVslCondCds.length; i++){
					if(glbVslCondCds[i] == "B"){
						formObj.port_skd_sts_cd.value = glbVslCondCds[i];
						formObj.port_skd_sts_nm.value = glbVslCondNms[i];
					}
				}
			}else{
				for(var i=0; i<glbVslCondCds.length; i++){
					if(glbVslCondCds[i] == "A"){
						formObj.port_skd_sts_cd.value = glbVslCondCds[i];
						formObj.port_skd_sts_nm.value = glbVslCondNms[i];
					}
				}
			}
		}
		
		//::2013-12-04::jsk::ActualSchedule저장시 Indicator업데이트안되는문제해결을위한 코드추가함:://
		formObj.org_port_skd_sts_cd.value = formObj.port_skd_sts_cd.value;
		//alert('setVslCondSts.last >> port_skd_sts_cd ['+formObj.port_skd_sts_cd.value+']');
		//alert('setVslCondSts.last >> org_port_skd_sts_cd ['+formObj.org_port_skd_sts_cd.value+']');
		
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
	
	/**
	 * 날짜를 비교한다.
	 * @param formObj
	 * @param fmDate
	 * @param toDate
	 * @return
	 */
	function isValidDate(formObj, fmDate, toDate){
		if(ComIsDateTime(fmDate, "", "hm") && ComIsDateTime(toDate, "", "hm")){
			if(Usr_replaceDateOrigin(fmDate) < Usr_replaceDateOrigin(toDate)){
				return true;
			}
		}
		return false;
	}
    
    /**
     * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
    		
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH10);
		
		var chkVslCd = ComGetEtcData(sXml, "vsl_chk");
		
		if(chkVslCd == "Y"){
    		//MDM_VSL_CNTR 에 Vessel Code가 존재
    		return true;
    	}else{
    		sheetObj.LoadSearchXml(sXml);
    		formObj.vsl_cd.value = "";
    		formObj.vsl_cd.focus();
    		return false;
    	}
	}
    
    /**
     * Delay Reason 의 상태를 설정한다.
     * 
     * @param formObj
     * @return
     */
    function delayReasonControl(formObj, isFocusFlg){
    	if(Number(formObj.dlay_arr_tm.value) < 8){
    		getComboObject("vsl_arr_dlay_rsn_cd").Code = "";
    		formObj.vsl_arr_dlay_rsn_nm.value = "";
    		getComboObject("vsl_arr_dlay_rsn_cd").Enable = false;
    	}else{
    		getComboObject("vsl_arr_dlay_rsn_cd").Enable = true;
    		if(isFocusFlg){
    			getComboObject("vsl_arr_dlay_rsn_cd").focus();
    		}
    	}
    	if(Number(formObj.dlay_brth_tm.value) < 8){
    		getComboObject("vsl_brth_dlay_rsn_cd").Code = "";
    		formObj.vsl_brth_dlay_rsn_nm.value = "";
    		getComboObject("vsl_brth_dlay_rsn_cd").Enable = false;
    	}else{
    		getComboObject("vsl_brth_dlay_rsn_cd").Enable = true;
    		if(isFocusFlg){
    			getComboObject("vsl_brth_dlay_rsn_cd").focus();
    		}
    	}
    	if(Number(formObj.dlay_dep_tm.value) < 8){
    		getComboObject("vsl_dep_dlay_rsn_cd").Code = "";
    		formObj.vsl_dep_dlay_rsn_nm.value = "";
    		getComboObject("vsl_dep_dlay_rsn_cd").Enable = false;
    	}else{
    		getComboObject("vsl_dep_dlay_rsn_cd").Enable = true;
    		if(isFocusFlg){
    			getComboObject("vsl_dep_dlay_rsn_cd").focus();
    		}
    	}
    	if(formObj.act_arr_dt.value != ""){
    		btnImgEnable(formObj.btn_remark_arr, true);
    	}else{
    		formObj.act_arr_rmk.value = "";
    		btnImgEnable(formObj.btn_remark_arr, false);
    	}
    	if(formObj.act_brth_dt.value != ""){
    		btnImgEnable(formObj.btn_remark_brth, true);
    	}else{
    		formObj.act_brth_rmk.value = "";
    		btnImgEnable(formObj.btn_remark_brth, false);
    	}
    	if(formObj.act_dep_dt.value != ""){
    		btnImgEnable(formObj.btn_remark_dep, true);
    	}else{
    		formObj.act_dep_rmk.value = "";
    		btnImgEnable(formObj.btn_remark_dep, false);
    	}
    }
	
	/**
	 * Date의 구분자들을 제거한다.
	 * @param sDate
	 * @return
	 */
	function Usr_replaceDateOrigin(sDate){
		var rDate = sDate;
		rDate = ComReplaceStr(rDate, "-", "");
		rDate = ComReplaceStr(rDate, ":", "");
		rDate = ComReplaceStr(rDate, " ", "");
		
		return rDate;
	}
    
    /**
     * Delay Time 을 구하여 해당 input 에 넣는다.
     * @param formObj
     * @return
     */
    function setDelayTime(formObj){
    	var vpsEtaDt = Usr_replaceDateOrigin(formObj.vps_eta_dt.value);
    	var vpsEtbDt = Usr_replaceDateOrigin(formObj.vps_etb_dt.value);
    	var vpsEtdDt = Usr_replaceDateOrigin(formObj.vps_etd_dt.value);
    	
    	var lstEtaDt = Usr_replaceDateOrigin(formObj.lst_eta_dt.value);
    	var lstEtbDt = Usr_replaceDateOrigin(formObj.lst_etb_dt.value);
    	var lstEtdDt = Usr_replaceDateOrigin(formObj.lst_etd_dt.value);
    	
    	var actArrDt = Usr_replaceDateOrigin(formObj.act_arr_dt.value);
    	var actBrthDt = Usr_replaceDateOrigin(formObj.act_brth_dt.value);
    	var actDepDt = Usr_replaceDateOrigin(formObj.act_dep_dt.value);
    	
    	var arrTimeDiff = "";
    	var brthTimeDiff = "";
    	var depTimeDiff = "";
    	
    	var sign = "";
    	
    	if(actArrDt != null && actArrDt != ""){
    		if(lstEtaDt != null && lstEtaDt != ""){
    			arrTimeDiff = setParsingDelayTime(lstEtaDt, actArrDt);
    		}else if(vpsEtaDt != null && vpsEtaDt != ""){
    			arrTimeDiff = setParsingDelayTime(vpsEtaDt, actArrDt);
    		}
    	}
    	if(actBrthDt != null && actBrthDt != ""){
    		if(lstEtbDt != null && lstEtbDt != ""){
    			brthTimeDiff = setParsingDelayTime(lstEtbDt, actBrthDt);
    		}else if(vpsEtbDt != null && vpsEtbDt != ""){
    			brthTimeDiff = setParsingDelayTime(vpsEtbDt, actBrthDt);
    		}
    	}
    	if(actDepDt != null && actDepDt != ""){
    		if(lstEtdDt != null && lstEtdDt != ""){
    			depTimeDiff = setParsingDelayTime(lstEtdDt, actDepDt);
    		}else if(vpsEtdDt != null && vpsEtdDt != ""){
    			depTimeDiff = setParsingDelayTime(vpsEtdDt, actDepDt);
    		}
    	}
    	
    	formObj.dlay_arr_tm.value = arrTimeDiff;
    	formObj.dlay_brth_tm.value = brthTimeDiff;
    	formObj.dlay_dep_tm.value = depTimeDiff;
    }
    
    /**
     * Delay Time을 정해진 Format 으로 변환.
     * @param fmDate
     * @param toDate
     * @return
     */
    function setParsingDelayTime(fmDate, toDate){
    	var timeDiff = "";
    	var sign = "";
    	
    	var timeDiff = getTimesBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd")+ComGetMaskedValue(fmDate.substring(8), "hm"), ComGetMaskedValue(toDate.substring(0,8), "ymd")+ComGetMaskedValue(toDate.substring(8), "hm"));
		
		if(Number(timeDiff) < 0){
			timeDiff = "";
		} else{
			timeDiff = parseFloat(timeDiff.toFixed(1));
		}
		
		return timeDiff;
    }
    
    /**
     * Actual Date간의 Diff Time을 정해진 Format 으로 변환.
     * @param fmDate
     * @param toDate
     * @return
     */
    function setParsingDiffTime(fmDate, toDate){
    	var tempTimeDiff = "";
    	var sign = "";
    	
    	var tempTimeDiff = getTimesBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd")+ComGetMaskedValue(fmDate.substring(8), "hm"), ComGetMaskedValue(toDate.substring(0,8), "ymd")+ComGetMaskedValue(toDate.substring(8), "hm"));
		
    	tempTimeDiff = parseFloat(tempTimeDiff.toFixed(1));

		return tempTimeDiff;
    }
    
    /**
     * 두 날짜 사이의 시간을 반환한다. 시간은 sToDate - sFromDate로 계산되며, 둘중 하나라도 날짜포멧이 아닌 경우 결과는 "NaN"으로 리턴된다. <br>
     * @param {string,object} sFromDate   필수,시작일자 문자열 또는 HTML태그(Object)
     * @param {string,object} sToDate     필수,종료일자 문자열 또는 HTML태그(Object)
     * @returns number,두 날짜 사이의 시간<br>
     * NaN : 두 인자 중 날짜가 아닌것이 하나라도 있어서 연산이 불가능한 경우
     */
    function getTimesBetween(sFromDate, sToDate) {
        try {
            var iFromTime = getTimeObj(sFromDate);
            var iToTime   = getTimeObj(sToDate);
            var val = iToTime - iFromTime;
    		return (iToTime - iFromTime) / (60*60*1000) ;
    		
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * 날짜 문자열을 인자로 받아서 new Date()로 년월일시분을 설정하여 반환한다. 인자가 날짜형태가 아니면 null을 반환한다. <br>
     * @param {string,object} sDate   필수,년월일시분 문자열 또는 HTML태그(Object)
     * @return date
     */
    function getTimeObj(sDate) {
        try {
	        sDate = sDate.replace(/\/|\-|\.|\:|\ /g,"");  //날짜구분자,시간구분자,스페이스 없애기
	        
		    var arr = ComNumberArray(7);
	        var iLen = sDate.length;
	        
	        if (iLen>=4) arr[0]  = sDate.substr(0,4);		//year
	    	if (iLen>=6) arr[1]  = sDate.substr(4,2)-1;		//month
	    	if (iLen>=8) arr[2]  = sDate.substr(6,2);		//day
	    	
	        if (iLen>=10) arr[3] = sDate.substr(8,2);		//hours
	        if (iLen>=12) arr[4] = sDate.substr(10,2);		//minutes
	        if (iLen>=14) arr[5] = sDate.substr(12,2);		//seconds
	        if (iLen<=17) arr[6] = sDate.substr(14);		//hour
	        
	        return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
	        
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
	/**
	 * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    btnImgEnable(obj, gb);
	 * </pre>
	 * @param  {form} obj 필수 Html Object
	 * @param  {bool} gb  필수 true : 활성화 false : 비활성화
	 * @return 없음
	 */ 
    function btnImgEnable(obj, gb) {
    	if(obj.constructor == String){
    		obj = document.getElementsByName(obj)[0];        
    	}
    	var btnStyle = obj.style;
    	
    	if (gb){
    		obj.Enable = true;
    		btnStyle.cursor = "hand";
    		btnStyle.filter="";
    		obj.disabled = false;
    	} else {
    		obj.Enable = false;        
    		btnStyle.cursor = "auto";
    		btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
    		obj.disabled = true;
    	}

    }
   
//    function showtip(text) { //매개변수를 받아서 마키에 출력하는 함수
//    	tooltip.innerText=text; //마키태그에 문장을 뿌립니다.
//    	tooltip.style.display="inline"; //마키태그의 보임속성을 지정합니다.
//    }
//
//    function hidetip() {
//    	tooltip.style.display="none" //마키태그의 보임속성을 감춤으로 지정합니다.
//    }
//
//    function movetip() { 
//    	tooltip.style.pixelTop=event.y+document.body.scrollTop; //툴팁의 세로 위치를 이벤트의 위치와 스크롤의 세로위치를 고려해서 지정합니다.
//    	tooltip.style.pixelleft=event.x+document.body.scrollleft+10; //툴팁의 가로위치를 지정합니다. - 스크롤바가 생겨도 레이어의 위치는 틀려지지 않습니다.
//    }
	
	/**
	 * 입력한 날짜를 정해진 포맷으로 변환한다.
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function Usr_setDateTime(formObj, srcName){
		var inputObj = document.getElementsByName(srcName)[0];
		ComAddSeparator(inputObj);
//		if(inputObj != null && inputObj != undefined){
//			if(inputObj.value.length >= 10){
//				var sDate = Usr_replaceDateOrigin(inputObj.value);
//				sDate = ComGetMaskedValue(sDate, "ymdhm");
//				if(ComIsDateTime(sDate, "", "hm")){
//					inputObj.value = sDate;
//				}else{
//					inputObj.value = "";
//				}
//			}else{
//				inputObj.value = "";
//			}
//		}
	}
	
	function msgmove(){
		msg.style.posLeft = event.x - 10 + document.body.scrollLeft;
		msg.style.posTop = event.y + 10 + document.body.scrollTop;
	}
	
	function msgset(strMsg){
		if(strMsg != ""){
			text="<table width=125 bgcolor=#FFFFE0 style='border:1 black solid;'><tr><td>" + strMsg + "</td></tr></table>";
			msg.innerHTML = text;
			msg_box.style.display = "";
		}
	}
	
	function msghide(){
		msg.innerHTML = "";
		msg_box.style.display = "none";
	}
	
	function controlDelete(){
		var formObj = document.form;
		var aryAuth = formObj.usr_auth.value.split("|");
		var isOk = false;
		for(var i=0; i<aryAuth.length; i++){
			if(aryAuth[i]=="VSK01" || aryAuth[i]=="VSK02" || formObj.cre_usr_id.value==formObj.usr_id.value){
				isOk = true;
			}
		}
		if(isOk){
			document.all.target_delete.style.display="";
			ComBtnEnable("btn_delete");
		}else{
			ComBtnDisable("btn_delete");
		}
		
		if(formObj.act_arr_dt.value=="" && formObj.act_brth_dt.value=="" && formObj.act_dep_dt.value==""){
			document.all.target_delete.style.display="none";
			ComBtnDisable("btn_delete");
		}
	}
	
	function searchCstPopup(formObj){
		formObj.vsl_cd.value = formObj.cst_vsl_cd.value;
		formObj.skd_voy_no.value = formObj.cst_skd_voy_no.value;
		formObj.skd_dir_cd.value = formObj.cst_skd_dir_cd.value;

		doActionIBSheet(sheetObjects[0], formObj, SEARCH03);//port 조회
		for(var i=0; i<formObj.vps_port_cd.GetCount(); i++){
			if(formObj.vps_port_cd.GetIndexText(i,1)==formObj.cst_yd_cd.value && formObj.vps_port_cd.GetIndexText(i,2)==formObj.cst_clpt_ind_seq.value){
				formObj.vps_port_cd.Index = i;
				break;
			}
		}
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);//actual skd 조회
		formObj.vps_port_cd.Enable = false;
		formObj.vsl_cd.readOnly = true;
		formObj.skd_voy_no.readOnly = true;
		formObj.skd_dir_cd.readOnly = true;
		formObj.vsl_cd.className="input2";
		formObj.skd_voy_no.className="input2";
		formObj.skd_dir_cd.className="input2";
	}
	
	function controlLayerPopup(formObj){
		if(formObj.act_skd_src_sys_cd.value=="VMS"){
			layer_popup_view();
		}else{
			layer_popup_hide(); 
		}
	}
	
	function layer_popup_hide(){
		var layer_popup = document.getElementById("layer_popup");
		layer_popup.style.visibility = "hidden";
	}
	
	function layer_popup_view(){
		var layer_popup = document.getElementById("layer_popup");
		layer_popup.style.visibility = "visible";
	}

	/* 개발자 작업  끝 */