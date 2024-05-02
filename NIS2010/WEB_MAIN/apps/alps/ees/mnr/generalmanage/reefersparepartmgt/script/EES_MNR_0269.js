﻿	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0269.js 
	 *@FileTitle : Reefer Spare Part Inquiry_Pop Up
	 *Open Issues :
	 *Change history : 1. 2015.03.12, CHM-201534633, EXCEL DOWN 기능 추가, 이율규
	 *				   2. 2015.03.12, CHM-201534633, 금액 표기법(,) 변경, 이율규
	 *@LastModifyDate : 2009.09.02
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 *  2009.08.25 권영법
	 * 1.0 Creation
			=========================================================*/
	/****************************************************************************************
			  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
								[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
								기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class ees_mnr_0269 : ees_mnr_0269 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0269() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	//공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//Date 구분자
	var DATE_SEPARATOR = "/";
	var HEADROWS = 2;
	var HEADCOLS = 0;
	var HEADER_TITLE1 = new Array();
	var HEADER_TITLE2 = new Array();
	var HEAD_ADD = new Array();
	var HEAD_VER_SEQ = 0;
	var FIXID_HEADER_COUNT = 12;//고정칼럼 갯수(앞에서부터)
	var COL_WIDTH = 30;
	
    var MAX_ROW = 10;
    var ROW_HEIGHT = 20;
    
    var UT_OPERATION = "O";
    var UT_SHARING = "S";
    var UT_NOT_SUPPLYING = "N";
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_new":
				module_pop();
				break;				
			case "btn_ok":
				comPopupOK();
				break; 
			case "btn_close":    
				self.close();  
				break;
				
			case "btn_downexcel":
				sheetObjects[0].Down2Excel(-1);
				sheetObjects[1].Down2Excel4FreeForm(-1, true);
				
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
	 * Main창 열기
	 */
	function module_pop() {
		var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=EES_MNR_M001&pgmUrl=^hanjin^EES_MNR_0267.do&mainPage=true&pgmNo=EES_MNR_0267";
		var winName = "EES_MNR_0267";
	  	var reqWin = ComOpenWindow(sUrl,winName,"width=1024,height=700, resizable=yes, scrollbars=yes, status=no");
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
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      // sheet1 init
			with (sheetObj) {

                // 높이 설정
                style.height = 250;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                //MergeSheet = msNone;
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                var viewRowCnt = FIXID_HEADER_COUNT + HEAD_ADD.length + 2;// +2는 TTL.QTY, Amount($)
                InitRowInfo(HEADROWS, 1, viewRowCnt, 100);
                
                HEADER_TITLE1.push("_");
				HEADER_TITLE1.push("sel");
				HEADER_TITLE1.push("Seq.");
				HEADER_TITLE1.push("Ivnt No");
				HEADER_TITLE1.push("Invt Seq");
				HEADER_TITLE1.push("Invt Ver Seq");
				HEADER_TITLE1.push("Ver Seq");
				HEADER_TITLE1.push("Lane");
				HEADER_TITLE1.push("VSL Code");
				HEADER_TITLE1.push("VSL Name");
				HEADER_TITLE1.push("OPR");
				
				HEADER_TITLE1.push("Type");
				
				for( var i = 0; i < HEAD_ADD.length; i++){
					//HEADER_TITLE1.push(HEAD_ADD[i].pair_cd_desc);
					HEADER_TITLE1.push(HEAD_ADD[i].vndr_nm);
					HEADER_TITLE1.push(HEAD_ADD[i].vndr_nm);
				}
				
				HEADER_TITLE1.push("TTL.Qty");
				HEADER_TITLE1.push("Amount($)");
				
				HEADER_TITLE2.push("");
				HEADER_TITLE2.push("sel");
				HEADER_TITLE2.push("Seq.");
				HEADER_TITLE2.push("Ivnt No");
				HEADER_TITLE2.push("Invt Seq");
				HEADER_TITLE2.push("Invt Ver Seq");
				HEADER_TITLE2.push("Ver Seq");
				HEADER_TITLE2.push("Lane");
				HEADER_TITLE2.push("VSL Code");
				HEADER_TITLE2.push("VSL Name");
				HEADER_TITLE2.push("OPR");
				HEADER_TITLE2.push("Type");
				
				for( var j = 0; j < HEAD_ADD.length; j++){
					//HEADER_TITLE2.push(HEAD_ADD[j].cd_id);
					HEADER_TITLE2.push(HEAD_ADD[j].spr_ut_mdl_nm);
					HEADER_TITLE2.push(HEAD_ADD[j].spr_ut_mdl_nm);
				}
				
				HEADER_TITLE2.push("TTL.Qty");
				HEADER_TITLE2.push("Amount($)");
				
				var HeadTitle1 = HEADER_TITLE1.join("|");
				var HeadTitle2 = HEADER_TITLE2.join("|");

				var headCount = ComCountHeadTitle(HeadTitle2);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, FIXID_HEADER_COUNT, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);
				
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,    "ibflag");
                InitDataProperty(0, cnt++ , dtHidden,	 	0,		daCenter,  	true,     "sel_chk",				false,          "",      dfNone,      	0,     true,       true);
				
                InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   true,     "Seq");

				InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_no",		false,		"",     dfNone,     	0,      false,      false);
	            InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_seq",		false,		"",     dfNone,     	0,      false,      false);
	            InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_ver_seq",	false,		"",		dfNone,     	0,      false,      false);
	            InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_ver_seq",		false,		"",		dfNone,     	0,      false,      false);
	            				
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,  	true,    "lane_cd",					false,      "",     dfNone,      	0,     	false,      true);
                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,  	true,    "vsl_cd",					false,      "",     dfNone,      	0,  	false,      true);
                InitDataProperty(0, cnt++,	dtData,			200,	daLeft,		true,    "vsl_nm",					false,		"",    	dfNone,			0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			70,		daCenter,  	true,    "crr_cd",					false,      "",     dfNone,      	0,     	false,      false);
                
                InitDataProperty(0, cnt++ , dtCombo,   		40,		daCenter,  	true,    "spr_prt_type_cd",			false,      "",     dfNone,      	0,     	false,       true);
                
                InitDataCombo (0, "spr_prt_type_cd", " |A|B", "N|A|B");
                
                for( var j = 0; j < HEAD_ADD.length; j++){                	
                	//if( HEAD_ADD[j].cd_id == "SI" || HEAD_ADD[j].cd_id == "GE"){
                		COL_WIDTH = 60;                        	
                	//}else{
                	//	COL_WIDTH = 30;
                	//}
                	var colNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                	InitDataProperty(0, cnt++ , dtCombo,	COL_WIDTH,		daCenter,  	false,    colNm,false,      "",     dfNone,      	0,     	false,       false);
//                	InitDataCombo (0, colNm, " |O|S", "N|O|S");
                	InitDataCombo (0, colNm, " |" + UT_OPERATION + "|" + UT_SHARING, UT_NOT_SUPPLYING +"|" + UT_OPERATION + "|" + UT_SHARING);
                	var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                	InitDataProperty(0, cnt++ , dtHidden,	COL_WIDTH,		daCenter,  	false,    colAmtNm,			false,      "",     dfNone,      	0,     	false,       false);
                	
   				}
              
                InitDataProperty(0, cnt++ , dtData,  		70,		daCenter,  	true,    "ttl_qty",				false,      "",     dfNone,      	0,     	false,      false);
                /* 2. 2015.03.12, CHM-201534633, 금액 표기법(,) 변경, 이율규 start */
                InitDataProperty(0, cnt++ , dtData,   		85,		daRight,  	true,    "spr_prt_crnt_amt",						false,      "",     dfNullFloat,      	2,     	false,      false);
                /* 2. 2015.03.12, CHM-201534633, 금액 표기법(,) 변경, 이율규 end */  
                // 10번째 Column부터~ Amt전까지
                for( var j = FIXID_HEADER_COUNT; j < HEADER_TITLE2.length -2; j++){
                	CellAlign(0, j) = daLeft;
                }
			}// end of width
			break;
		case 2:
			with (sheetObj) {
				style.height = 130;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet =  msAll;//msHeaderOnly;
			
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, HEADER_TITLE2.length, 100);
			
				var headTitle1 = HEADER_TITLE2.join("|");								
				var headCount = ComCountHeadTitle(headTitle1);									
				var hiddenColumnCnt = 7 + 3;
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				//InitColumnInfo(headCount-hiddenColumnCnt, 0, 0, true);
				InitColumnInfo(headCount-hiddenColumnCnt, 2, 0, true);
				
               // 해더에서 처리할 수 있는 각종 기능을 설정한다
               InitHeadMode(true, true, true, true, false,false);
	
               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
               InitHeadRow(0, headTitle1, true, true);

               //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
               InitDataProperty(0, cnt++ , dtData,			130,		daCenter,  	true,    "lane_cd",					false,      "",     dfNone,      	0,     	false,      true);
               InitDataProperty(0, cnt++ , dtData,			330,		daCenter,  	true,    "vsl_cd",					false,      "",     dfNone,      	0,  	false,      true);

               for( var j = 0; j < HEAD_ADD.length; j++){            	   
            	   COL_WIDTH = 60;                        	
            	   var colIdNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
            	   InitDataProperty(0, cnt++ , dtData,	COL_WIDTH,		daCenter,  	false,    colIdNm,			false,      "",     dfNone,      	0,     	false,       true);
            	   var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
            	   InitDataProperty(0, cnt++ , dtHidden,	COL_WIDTH,		daCenter,  	false,    colAmtNm,			false,      "",     dfNone,      	0,     	false,       true);
               }
               InitDataProperty(0, cnt++ , dtData,   		70,	daCenter,  	false,    "ttl_qty",				false,      "",     dfNone,      	0,     	false,      false);
               InitDataProperty(0, cnt++ , dtData,   		85,		daRight,  	false,    "spr_prt_crnt_amt",						false,      "",     dfNone,      	0,     	false,      false);
         
               CountPosition = 0;
			}// end of width
       	 break;
	
		}// end of switch
	}
	
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		MnrWaitControl(false);
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	 	
		MnrWaitControl(true);
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;	
		var sXml = sheetObjects[0].GetSearchXml("EES_MNR_0267GS2.do","",FormQueryString(formObj),true);

		//var arrResult = MnrXmlToArray2(sXml);
		
		try{
			var arrResult = MnrXmlToArray2(sXml);
			HEAD_ADD = new Array();
			for( var i = 0; i < arrResult.length; i++){
				HEAD_ADD.push(arrResult[i]);
			}
		}catch(e){
			//alert(e);
		}

		MnrWaitControl(false);
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) 
		{
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value = "";
			sheetObjects[0].RemoveAll();
			MnrWaitControl(false);
			break;	
		
		case IBSEARCH:      //조회
	
			if(!validateForm(sheetObjects[0],formObj,sAction))return;
			formObj.f_gubuns.value = "";
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value = SEARCH; 
			
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0267GS.do", FormQueryString(formObj));
			
			sheetObjects[0].LoadSearchXml(sXml);
			
			setEtcData(sXml);
	
		break;		
	
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
	
		return true;
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		MnrWaitControl(false);
	
		nowLoad = 0;
	
	}     
	
	/**
	 * 화면에 Inventory No, Cre Dt, Cre Usr Id set
	 * @param sXml
	 */
	function setEtcData(sXml){
		var formObj = document.form;
		try{
			if ( ComGetEtcData(sXml, "INVENTORY_NO") == undefined) {
				//formObj.spr_prt_invt_no.value = "";
			}else{
				formObj.spr_prt_invt_no.value = ComGetEtcData(sXml, "INVENTORY_NO");
			}
			if ( ComGetEtcData(sXml, "CRE_DT") == undefined)  {
				formObj.cre_dt.value = "";
			}else{
				formObj.cre_dt.value = ComGetEtcData(sXml, "CRE_DT");
			}
			if ( ComGetEtcData(sXml, "CRE_USR_ID") == undefined)  {
				formObj.cre_usr_nm.value = "";
			}else{
				formObj.cre_usr_nm.value = ComGetEtcData(sXml, "CRE_USR_ID");
			}
			
			
			if ( ComGetEtcData(sXml, "CD_VER_SEQ") == undefined) {
				
			}else{
				var cdVerSeq = ComGetEtcData(sXml, "CD_VER_SEQ");
				formObj.spr_prt_ver_seq.value = cdVerSeq;			 
			}
		}catch(e){

		}
	}
	
	/**
	 * 조회완료시 Summary sheet 설정
	 * @param sheetObj
	 * @param errMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "";
		
		if (errMsg == "") {
//			// 두번째 sheet를 새로 그림
			calculationTotlaAmt();
//            if(sheetObjects[0].RowCount > 0) {
//            	setSheet1Height();
//            	
//            	for(var i = 0; i < 4; i++){
//            		var row = sheetObjects[1].DataInsert(-1);
//	            	sheetObjects[1].CellValue2(row, "lane_cd") = "TOTAL";
//	            	
//	            	
//	            	switch(i){
//	            		case 0:
//			            	sheetObjects[1].CellValue2(row, "vsl_cd") = "TTL.Management";
//			            	sheetObjects[1].CellValue2(row, "spr_prt_crnt_amt") = "TTL.Amount($)";
//			            	
//			            	for( var j = 0; j < HEAD_ADD.length; j++){
//			            		var cdId = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
//			            		sheetObjects[1].CellValue2(row, cdId) = "Quantity";
//			            	}
//		            	break;
//	            		case 1:
//			            	sheetObjects[1].CellValue2(row, "vsl_cd") = "SML Supplying";
//		            	break;
//	            		case 2:
//			            	sheetObjects[1].CellValue2(row, "vsl_cd") = "Sharing";
//		            	break;
//	            		case 3:
//			            	sheetObjects[1].CellValue2(row, "vsl_cd") = "Total";
//			            	
//		            	break;
//	            	}
//            	}// default row/col set
//            	
////            	// value set
//            	for( var i = 0; i < sheetObjects[0].RowCount; i++){
//            		for( var j = 0; j < HEAD_ADD.length; j++){
//            			var colIdNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
//            			var colIdValue = sheetObjects[0].CellValue(Number(i) + HEADROWS, colIdNm);
//            			var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
//            			var colAmtValue = sheetObjects[0].CellValue(Number(i) + HEADROWS, colAmtNm);
//            			
////            			alert(colNm + " : " + colValue + ", " + HEAD_ADD.length + ";; " + j);
//            			
//            			try{
//            				var targetIdx = 0;
//	            			if( colIdValue == "S"){
//	            				targetIdx = 2;
//	            			}else if( colIdValue == "O"){
//	            				targetIdx = 3;
//	            			}else{
//	            				continue;
//	            			}
//	            			var targetIdValue = sheetObjects[1].CellValue(targetIdx, colIdNm);
//            				var targetAmtValue = sheetObjects[1].CellValue(targetIdx, colAmtNm);
//            				var totalIdValue =  sheetObjects[1].CellValue(4, colIdNm);
//            				var totalAmtValue =  sheetObjects[1].CellValue(4, colAmtNm);
//            				var sumAmtValue = sheetObjects[1].CellValue(targetIdx, "spr_prt_crnt_amt");
//            				var sumAmtTotalValue = sheetObjects[1].CellValue(4, "spr_prt_crnt_amt");
//            				if( targetIdValue == ""){
//            					targetIdValue = 0.0;
//            				}
//            				if( totalIdValue == ""){
//            					totalIdValue = 0.0;
//            				}
//            				if( targetAmtValue == ""){
//            					targetAmtValue = 0.0;
//            				}
//            				if( totalAmtValue == ""){
//            					totalAmtValue = 0.0;
//            				}
//            				if( sumAmtValue == ""){
//            					sumAmtValue = 0.0;
//            				}
//            				if( sumAmtTotalValue == ""){
//            					sumAmtTotalValue = 0.0;
//            				}
////            				alert(targetIdx + ":" + colIdNm + " : " + targetIdValue);
//            				sheetObjects[1].CellValue2(targetIdx, colIdNm) = Number(targetIdValue) + 1;	            				
//            				
//            				sheetObjects[1].CellValue2(targetIdx, colAmtNm) = Number(targetAmtValue) + Number(colAmtValue);
//            				sheetObjects[1].CellValue2(targetIdx, "spr_prt_crnt_amt") = Number(sumAmtValue) + Number(colAmtValue);
//            				
//            				sheetObjects[1].CellValue2(4, colIdNm) = Number(totalIdValue) + 1;
//            				
//            				sheetObjects[1].CellValue2(4, colAmtNm) = Number(totalAmtValue) + Number(colAmtValue);
//            				sheetObjects[1].CellValue2(4, "spr_prt_crnt_amt") = Number(sumAmtTotalValue) + Number(colAmtValue);
//            			}catch(e){alert(e);console.log(e);
//						}//end of try
//            			
//            		}//end of for j
//            	}//end of for i
//            }//end of rowCnt if
        }
		MnrWaitControl(false);
	}
	
	/**
	 * Sheet1의 높이 설정
	 */
	function setSheet1Height(){		
//		style.height = 250;
		try{
			
			if( sheetObjects[0].RowCount >= MAX_ROW){
				sheetObjects[0].style.height = 250;
				//alert(sheetObjects[1].RowCount);		        
//			}else if( sheetObjects[0].RowCount < 5 ){
//				//sheetObjects[0].style.height = Number(60) + ((sheetObjects[0].RowCount + 1) * ROW_HEIGHT);
//				sheetObjects[0].style.height = Number(80) + ((sheetObjects[0].RowCount) * ROW_HEIGHT);
			}else{
				sheetObjects[0].style.height = Number(80) + ((sheetObjects[0].RowCount) * ROW_HEIGHT);
			}
		}catch(e){}
	}
	/**
	 * Sheet2의 높이 설정
	 */
	function setSheet2Height(){
		try{
			var sheet2RowCnt = sheetObjects[1].RowCount;
			if( sheet2RowCnt == 6 ) return;
			
			if( sheetObjects[0].RowCount >= MAX_ROW){
			
				if(sheetObjects[1].RowCount == 0 || sheetObjects[1].RowCount == 5){				
					var row = sheetObjects[1].DataInsert(0);
					sheetObjects[1].CellValue2(row, "lane_cd") = "TOTAL";
	            	sheetObjects[1].CellValue2(row, "vsl_cd") = "TTL.Management";
	            	for( var j = 0; j < HEAD_ADD.length; j++){
	            		
	            		var cdId = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
	            		//sheetObjects[1].CellValue2(row, cdId) = HEAD_ADD[j].spr_ut_mdl_nm +".Qty";
	            		sheetObjects[1].CellValue2(row, cdId) = "";
	            		sheetObjects[1].CellBackColor(1, cdId) = sheetObjects[1].RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
	            	}
			        sheetObjects[1].CellValue2(row, "ttl_qty") = "";//"TTL.Qty";		        
			        sheetObjects[1].CellValue2(row, "spr_prt_crnt_amt") = "";//"TTL.Amount($)";
			        sheetObjects[1].CellBackColor(1, "ttl_qty") = sheetObjects[1].RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
			        sheetObjects[1].CellBackColor(1, "spr_prt_crnt_amt") = sheetObjects[1].RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
				}

			}
		}catch(e){}
	}
	
	function calculationTotlaAmt(){
		// 두번째 sheet를 새로 그림
        if(sheetObjects[0].RowCount > 0) {
        	sheetObjects[1].RemoveAll();
        	setSheet1Height();
        	setSheet2Height();
        	
        	var totSheetHeaderRowCnt = 1;
        	var totSheetDataRowCnt = 4;
        	
        	if( sheetObjects[0].RowCount >= MAX_ROW){
        		totSheetHeaderRowCnt = 2;
        	}
        	
        	for(var i = totSheetHeaderRowCnt; i < (totSheetHeaderRowCnt +totSheetDataRowCnt)+1; i++){
        		var row = sheetObjects[1].DataInsert(-1);
            	sheetObjects[1].CellValue2(row, "lane_cd") = "TOTAL";
            	
            	
            	switch(i){
	            	case totSheetHeaderRowCnt:
	        			var sheet2RowCnt = sheetObjects[0].RowCount;
	        			if( sheet2RowCnt == 6 ){
	        				
	        			}else{
	        				sheetObjects[1].CellValue2(row, "vsl_cd") = "TTL.Management";
			            	sheetObjects[1].CellValue2(row, "ttl_qty") = "TTL.Qty";
			            	sheetObjects[1].CellValue2(row, "spr_prt_crnt_amt") = "TTL.Amount($)";
			            	
			            	for( var j = 0; j < HEAD_ADD.length; j++){
			            		var cdId = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
			            		//alert(j + " : " + cdId);
			            		sheetObjects[1].CellValue2(row, cdId) = HEAD_ADD[j].spr_ut_mdl_nm +".Qty";
			            	}
	        			}
	        			
	            	break;
	        		case totSheetHeaderRowCnt + 1:
	        					            	sheetObjects[1].CellValue2(row, "vsl_cd") = "SML Supplying[O]";
	            	break;
	        		case totSheetHeaderRowCnt + 2:
		            	sheetObjects[1].CellValue2(row, "vsl_cd") = "Sharing[S]";
	            	break;
	        		case totSheetHeaderRowCnt + 3:
	        			sheetObjects[1].CellValue2(row, "vsl_cd") = "Not supplying[-]";
	        		break;
	        		case totSheetHeaderRowCnt + 4:
		            	sheetObjects[1].CellValue2(row, "vsl_cd") = "Total";		            	
	            	break;
            	}
        	}// default row/col set
        	
        	// 배경색
        	sheetObjects[1].RowBackColor(totSheetHeaderRowCnt) = sheetObjects[1].RgbColor(200,200,255);
			sheetObjects[1].RowBackColor(totSheetHeaderRowCnt + 1) = sheetObjects[1].RgbColor(255,192,255);
			
			// 굵게
			var rowIdx = totSheetHeaderRowCnt + 1;
			var startCell = 1;
			var endCell = FIXID_HEADER_COUNT + HEAD_ADD.length;
			sheetObjects[1].CellFont("FontBold", rowIdx, startCell, rowIdx, endCell) = true;
			
        	// value set
			var targetTotInx = totSheetHeaderRowCnt + totSheetDataRowCnt;
			
			for( var i = 0; i < sheetObjects[0].RowCount; i++){
        		for( var j = 0; j < HEAD_ADD.length; j++){
        			var colIdNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
        			var colIdValue = sheetObjects[0].CellValue(Number(i) + HEADROWS, colIdNm);
        			var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
        			var colAmtValue = sheetObjects[0].CellValue(Number(i) + HEADROWS, colAmtNm);
        			var colTtl = 0;
        			
        			try{
        				var targetIdx = totSheetHeaderRowCnt;
        				
        				
        				if( colIdValue == UT_OPERATION){
            				targetIdx = totSheetHeaderRowCnt + 1;	            			
            			}else if( colIdValue == UT_SHARING){
            				targetIdx = totSheetHeaderRowCnt + 2;
            			}else if( colIdValue == UT_NOT_SUPPLYING){
            				targetIdx = totSheetHeaderRowCnt + 3;
            			}else{
            				targetIdx = totSheetHeaderRowCnt + 3;
            			}
            			var targetIdValue = sheetObjects[1].CellValue(targetIdx, colIdNm);
        				var targetAmtValue = sheetObjects[1].CellValue(targetIdx, colAmtNm);
        				var totalIdValue =  sheetObjects[1].CellValue(targetTotInx, colIdNm);
        				var totalAmtValue =  sheetObjects[1].CellValue(targetTotInx, colAmtNm);
        				var sumAmtValue = sheetObjects[1].CellValue(targetIdx, "spr_prt_crnt_amt");
        				var sumAmtTotalValue = sheetObjects[1].CellValue(targetTotInx, "spr_prt_crnt_amt");
        				if( targetIdValue == ""){
        					targetIdValue = 0.0;
        				}
        				if( totalIdValue == ""){
        					totalIdValue = 0.0;
        				}
        				if( targetAmtValue == ""){
        					targetAmtValue = 0.0;
        				}
        				
        				if( totalAmtValue == ""){
        					totalAmtValue = 0.0;
        				}
        				if( sumAmtValue == ""){
        					sumAmtValue = 0.0;
        				}
        				if( sumAmtTotalValue == ""){
        					sumAmtTotalValue = 0.0;
        				}
        				
        				if( colIdValue == UT_NOT_SUPPLYING){
        					targetAmtValue = 0.0;
        				}
        				//alert(targetIdx + ":" + colIdNm + " : " + colIdValue + "," + targetIdValue);
        				sheetObjects[1].CellValue2(targetIdx, colIdNm) = Number(targetIdValue) + 1;	            				
        				
        				sheetObjects[1].CellValue2(targetIdx, "ttl_qty") = Number(sheetObjects[1].CellValue(targetIdx, "ttl_qty") ) + 1;
        				
        				sheetObjects[1].CellValue2(targetIdx, colAmtNm) = Number(targetAmtValue) + Number(colAmtValue);
        				sheetObjects[1].CellValue2(targetIdx, "spr_prt_crnt_amt") = Number(sumAmtValue) + Number(colAmtValue);
        				
        				sheetObjects[1].CellValue2(targetTotInx, colIdNm) = Number(totalIdValue) + 1;
        				
        				
        				sheetObjects[1].CellValue2(targetTotInx, colAmtNm) = Number(totalAmtValue) + Number(colAmtValue);
        				sheetObjects[1].CellValue2(targetTotInx, "spr_prt_crnt_amt") = Number(sumAmtTotalValue) + Number(colAmtValue);
        				
        				/* 2. 2015.03.12, CHM-201534633, 금액 표기법(,) 변경, 이율규 start */
        				sheetObjects[1].InitCellProperty(targetIdx, colIdNm, dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetTotInx, colIdNm, dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetIdx, "ttl_qty", dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetTotInx, "ttl_qty", dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetIdx, "spr_prt_crnt_amt", dtData, daRight, "", "", dfNullFloat, 2 ); 
        				sheetObjects[1].InitCellProperty(targetTotInx, "spr_prt_crnt_amt", dtData, daRight, "", "", dfNullFloat, 2 ); 
        				/* 2. 2015.03.12, CHM-201534633, 금액 표기법(,) 변경, 이율규 end */
        			}catch(e){
        				//alert(e);console.log(e);
        			}
        			
        		}// end of for j
        	}//end of for i
        	
			var sumO = MnrNullToZero(sheetObjects[1].CellValue(totSheetHeaderRowCnt + 1, "ttl_qty"));
        	var sumS = MnrNullToZero(sheetObjects[1].CellValue(totSheetHeaderRowCnt + 2, "ttl_qty"));
        	var sumN = MnrNullToZero(sheetObjects[1].CellValue(totSheetHeaderRowCnt + 3, "ttl_qty"));
//        	alert(sumO + " : " + sumS + " : " + sumN);
        	sheetObjects[1].CellValue2(targetTotInx, "ttl_qty") = Number(sumO) + Number(sumS) + Number(sumN);
        }
	}
