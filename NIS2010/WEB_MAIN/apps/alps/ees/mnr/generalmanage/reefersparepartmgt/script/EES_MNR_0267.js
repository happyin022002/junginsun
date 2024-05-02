﻿	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0267.js 
	 *@FileTitle : Reefer Spare Part VSL Inventory Creation
	 *Open Issues :
	 *Change history : 1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규
	 *@LastModifyDate : 2014.11.23
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 *  2014.11.23 노영현
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
	 * @class ees_mnr_0267 : ees_mnr_0267 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0267() {
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

    var prefix = "sheet1_";
    var MAX_ROW = 10;
    var ROW_HEIGHT = 20;
    
    var UT_OPERATION = "O";
    var UT_SHARING = "S";
    var UT_NOT_SUPPLYING = "N";
	//===================================================================================
	//Form 이벤트 처리
	//===================================================================================
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {

	 	
	    //Axon 이벤트 처리1. 이벤트catch
		//axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
		//axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
		//axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
		axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
		//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
		
		getSheetHeader();//Header 가져오기
		
	}

	/**
	* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	**/
	function obj_keypress(){
		switch (event.srcElement.name) {    

		}	
	}

	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_deactivate(){
		
	}

	/**
	 * HTML Control Foucs in
	 */
	function obj_activate(){
	   ComClearSeparator(event.srcElement);
	}
	
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
	
			case "btn_new":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
							
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
				
			case "btn_save":				
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_codeinquiry":
				codeInquiryPopup();
				break;	
				
			case "btn_del":
				doActionIBSheet(sheetObjects[0], formObject,IBDELETE);
				break;
			case "btn_RowAdd":				
				doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
				break;
			case "btn_RowDel":
				if(sheetObjects[0].FindCheckedRow("sel_chk") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
				//if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "sel_chk");
				//}
				break;
				
			case "btn_downexcel":
				//1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규 start
				sheetObjects[0].Down2Excel(-1, false, false, true, "", "", false, false, "", false, "1");
				sheetObjects[1].Down2Excel4FreeForm(-1, true);
				//1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규 end
				/*
				sheetObjects[3].RemoveAll();
				// copy Data
				sheetObjects[0].Copy2SheetCol(
						sheetObjects[3]		//TargetSheet IBSheet 필수  붙여넣기 할 타겟 IBSheet 오브젝트 
						,""//sColNms //SrcColumns String 선택  복사할 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
						,"" //DestColumns String 선택  붙여넣을 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
						,-1 //StartRow Long 선택  복사할 대상시트의 시작 Row Index,Default=-1(데이터 첫행 의미)  
						,-1 //EndRow Long 선택  복사할 대상시트의 마지막 Row Index, Default=-1(데이터 마지막행 의미)  
						,-1 //DestRow Long 선택  붙여넣기대상Sheet의 시작 Row Index, Default=-1 
						,2 //AddType Long 선택  붙여넣기 유형, Default=0(overwrite)  1:insert 2:append 
						,true//useSameSaveName Boolean 선택  컬럼 매핑시 각 시트의 SaveName을 비교할지 여부, Default=false  
						,false//raiseChangeEvent Boolean 선택 OnChange Event를 발생할지 여부, Default=false 
						,""//SrcCheckCol Long / String 선택  복사Sheet에서 특정컬럼을 기준으로 체크된 행만 복사	// Default=""(모든 Row 의미)  
						,""///DestCheckCol Long / String 선택  붙여넣기대상Sheet에서 특정컬럼을 기준으로 체크된 행만 붙여넣는다., Default=""(모든 Row 의미) 
				);
				// total sheet data copy
				var totSheetHeaderRowCnt = 1;
	        	var totSheetDataRowCnt = 4;
	        	
	        	if( sheetObjects[0].RowCount >= MAX_ROW){
	        		totSheetHeaderRowCnt = 2;
	        	}
	        	totSheetHeaderRowCnt++;
				for(var i = totSheetHeaderRowCnt; i < (totSheetHeaderRowCnt +totSheetDataRowCnt); i++){
		        	var row = sheetObjects[3].DataInsert(-1);
		        		
		            //sheetObjects[3].CellValue2(row, "lane_cd") = "TOTAL";
	            	switch(i){
	            		
	            		case totSheetHeaderRowCnt:
	            			sheetObjects[3].CellValue2(row, "vsl_nm") = "SML Supplying[O]";
		            	break;
	            		case totSheetHeaderRowCnt + 1:
			            	sheetObjects[3].CellValue2(row, "vsl_nm") = "Sharing[S]";
		            	break;
	            		case totSheetHeaderRowCnt + 2:
	            			sheetObjects[3].CellValue2(row, "vsl_nm") = "Not supplying[-]";
	            		break;
	            		case totSheetHeaderRowCnt + 3:
			            	sheetObjects[3].CellValue2(row, "vsl_nm") = "Total";		            	
		            	break;
	            	}	
		            sheetObjects[3].CellValue2(row, "ttl_qty") = sheetObjects[1].CellValue(i, "ttl_qty");
		            sheetObjects[3].CellValue2(row, "spr_prt_crnt_amt") = sheetObjects[1].CellValue(i, "spr_prt_crnt_amt");
		            
		            for( var j = 0; j < HEAD_ADD.length; j++){	            		
	            		var cdId = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
	            		sheetObjects[3].CellValue2(row, cdId) = sheetObjects[1].CellValue(i, cdId);	            		
	            	}
				}
		
				
				// set Excel header
				var excelHeaderArr = new Array();

				excelHeaderArr.push("sel_chk");
				excelHeaderArr.push("Seq");
				excelHeaderArr.push("spr_prt_invt_no");
				excelHeaderArr.push("spr_prt_invt_seq");
				excelHeaderArr.push("spr_prt_invt_ver_seq");
				excelHeaderArr.push("spr_prt_ver_seq");
				
                for( var j = 0; j < HEAD_ADD.length; j++){
                	var colNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                	var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                	excelHeaderArr.push(colAmtNm);
   				}
                
                                
                var excelHeader = excelHeaderArr.join("|");//header에서 제거할 칼럼들
                //sheetObjects[0].SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,excelHeader);
                sheetObjects[3].SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,excelHeader);
*/
				break;
			case "btn_upload":
				doActionIBSheet(sheetObjects[0], formObject, IBLOADEXCEL);
				break;
			case "btn_formatdown":
				var cnt = sheetObjects[0].RowCount;
				if(cnt<=0) {
					var Row = sheetObjects[0].DataInsert(-1); 
				}
				// set Excel header
				var excelHeaderArr = new Array();
//				excelHeaderArr.push("lane_cd");
//				excelHeaderArr.push("vsl_cd");
//				excelHeaderArr.push("vsl_nm");
//				excelHeaderArr.push("crr_cd");
//				excelHeaderArr.push("spr_prt_tp_cd");
//				excelHeaderArr.push("lane_cd");
				
				excelHeaderArr.push("sel_chk");
				excelHeaderArr.push("Seq");
				excelHeaderArr.push("spr_prt_invt_no");
				excelHeaderArr.push("spr_prt_invt_seq");
				excelHeaderArr.push("spr_prt_invt_ver_seq");
				excelHeaderArr.push("spr_prt_ver_seq");
				
                for( var j = 0; j < HEAD_ADD.length; j++){
                	
                	var colNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                	var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                	excelHeaderArr.push(colAmtNm);
   				}
                
                                
                var excelHeader = excelHeaderArr.join("|");//header에서 제거할 칼럼들
                //sheetObjects[0].SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,"sel_chk|spr_prt_lst_amt|spr_prt_ver_seq|cre_dt");
                sheetObjects[0].SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,excelHeader);
				
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
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;

        switch(sheetid) {
        	
             case "sheet1":
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

                    
                    HEADER_TITLE1 = new Array();
                    HEADER_TITLE2 = new Array();
                    
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
//					alert(HeadTitle1);
//					alert(HeadTitle2);
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, FIXID_HEADER_COUNT, 0, true);
					
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false)
                    
        			
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, false);

    				
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,    "ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox,	 	40,		daCenter,  	true,     "sel_chk",				false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   true,     "Seq");

					InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_no",		false,		"",     dfNone,     	0,      false,      false);
		            InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_seq",		false,		"",     dfNone,     	0,      false,      false);
		            InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_ver_seq",	false,		"",		dfNone,     	0,      false,      false);
		            InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_ver_seq",		false,		"",		dfNone,     	0,      false,      false);
		            
					InitDataProperty(0, cnt++ , dtPopupEdit,	60,		daCenter,  	true,    "lane_cd",					false,      "",     dfEngUpKey,      	0,     	false,      true,	3);
                    InitDataProperty(0, cnt++ , dtPopupEdit,	60,		daCenter,  	true,    "vsl_cd",					false,      "",     dfEngUpKey,      	0,  	false,      true,	4);
                    InitDataProperty(0, cnt++,	dtData,			200,	daLeft,		true,    "vsl_nm",				false,		"",    	dfNone,			0,		false,		false);
                    //InitDataProperty(0, cnt++ , dtPopupEditFormat,	70,	daCenter,  	true,    "crr_cd",				false,      "",     dfNone,      	0,     	false,      true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,  	true,    "crr_cd",				false,      "",     dfNone,      	0,     	false,      false);
                    
                    InitDataProperty(0, cnt++ , dtCombo,   		40,		daCenter,  	true,    "spr_prt_tp_cd",			false,      "",     dfNone,      	0,     	false,       true);
                    
                    InitDataCombo (0, "spr_prt_tp_cd", " |A|B", "N|A|B");
                    
                    for( var j = 0; j < HEAD_ADD.length; j++){
                    	
                    	//if( HEAD_ADD[j].cd_id == "SI" || HEAD_ADD[j].cd_id == "GE"){
                    		COL_WIDTH = 60;                        	
                    	//}else{
                    	//	COL_WIDTH = 30;
                    	//}
                    	var colNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                    	InitDataProperty(0, cnt++ , dtCombo,	COL_WIDTH,		daCenter,  	false,    colNm,false,      "",     dfNone,      	0,     	true,       true);
                    	//InitDataCombo (0, colNm, " |O|S", "N|O|S");

                    	InitDataCombo (0, colNm, " |" + UT_OPERATION + "|" + UT_SHARING, UT_NOT_SUPPLYING +"|" + UT_OPERATION + "|" + UT_SHARING);
                    	//InitDataCombo (0, colNm, UT_NOT_SUPPLYING +"|" + UT_OPERATION + "|" + UT_SHARING, UT_NOT_SUPPLYING +"|" + UT_OPERATION + "|" + UT_SHARING);
                    	var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                    	InitDataProperty(0, cnt++ , dtHidden,	COL_WIDTH,		daCenter,  	false,    colAmtNm,			false,      "",     dfNone,      	0,     	false,       true);
                    	
       				}
                    InitDataProperty(0, cnt++ , dtData,  		70,		daCenter,  	true,    "ttl_qty",				false,      "",     dfNone,      	0,     	false,      false);
                    /*1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규 start*/
                    InitDataProperty(0, cnt++ , dtData,   		95,		daRight,  	true,    "spr_prt_crnt_amt",	false,      "",     dfNullFloat,      	2,     	false,      false);
                    /*1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규 end*/
                    //해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					//InitHeadColumn(0, HEAD_ADD.join("|"), daLeft);
					
                    InitDataValid(0, "lane_cd", vtEngUpOnly);
                    InitDataValid(0, "vsl_cd", vtEngUpOther, "0123456789");
                    ShowButtonImage = 1;
                    
                    // 12번째 Column부터~ Amt전까지
                    for( var j = FIXID_HEADER_COUNT; j < HEADER_TITLE2.length -2; j++){
                    	CellAlign(0, j) = daLeft;
                    }
				}// end of width
				break;
             case "sheet2":
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
//	 				alert("sheet2 " + headTitle1);
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
      					
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,  	true,    "lane_cd",					false,      "",     dfNone,      	0,     	false,      true);
                    InitDataProperty(0, cnt++ , dtData,			370,		daCenter,  	true,    "vsl_cd",				false,      "",     dfNone,      	0,  	false,      true);

                    for( var j = 0; j < HEAD_ADD.length; j++){
                    	COL_WIDTH = 60;                        	
                    	var colIdNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                    	InitDataProperty(0, cnt++ , dtData,	COL_WIDTH,		daCenter,  	false,    colIdNm,			false,      "",     dfNone,      	0,     	false,       true);
                    	var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                    	InitDataProperty(0, cnt++ , dtHidden,	COL_WIDTH,		daCenter,  	false,    colAmtNm,		false,      "",     dfNone,      	0,     	false,       true);
                    	
       				}
                    InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,  	false,    "ttl_qty",				false,      "",     dfNone,      	0,     	false,      false);
                    InitDataProperty(0, cnt++ , dtData,   		95,		daCenter,  	false,    "spr_prt_crnt_amt",		false,      "",     dfNone,      	0,     	false,      false);
               
                    CountPosition = 0;
				}// end of width
            	 break;
             case "sheet3":     // sheet1 init 엑셀 업로드용 숨김 그리드
 				with (sheetObj) {
 					// 높이 설정
 					style.height = 422;
 		
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;
 			
 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 			
 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;
 			
 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 			
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(HEADROWS, 1, 15, 100);
 					
 					var sheet3HEADER_TITLE1 = new Array();
 					var sheet3HEADER_TITLE2 = new Array();
 					sheet3HEADER_TITLE1.push("");
 					sheet3HEADER_TITLE1.push("Lane");
 					sheet3HEADER_TITLE1.push("VSL Code");
 					sheet3HEADER_TITLE1.push("VSL Name");
 					sheet3HEADER_TITLE1.push("OPR");
					
 					sheet3HEADER_TITLE1.push("Type");
					
					for( var i = 0; i < HEAD_ADD.length; i++){
						sheet3HEADER_TITLE1.push(HEAD_ADD[i].vndr_nm);
					}
					sheet3HEADER_TITLE2.push("");
 					sheet3HEADER_TITLE2.push("Lane");
 					sheet3HEADER_TITLE2.push("VSL Code");
 					sheet3HEADER_TITLE2.push("VSL Name");
 					sheet3HEADER_TITLE2.push("OPR");
 					sheet3HEADER_TITLE2.push("Type");
 					
 					for( var j = 0; j < HEAD_ADD.length; j++){
						sheet3HEADER_TITLE2.push(HEAD_ADD[j].spr_ut_mdl_nm);
					}
 					
 					var HeadTitle1 = sheet3HEADER_TITLE1.join("|");
					var HeadTitle2 = sheet3HEADER_TITLE2.join("|");
					var headCount = ComCountHeadTitle(HeadTitle2);
 					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);
 			
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false, false)
 			
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);
 		            
 		            //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 		            InitDataProperty(0, cnt++,		dtHiddenStatus,			20,			daCenter,		true,     "ibflag");		                                 		                        
 		            InitDataProperty(0, cnt++,		dtData,					100,		daLeft,			true,     "lane_cd",	false,		"",      	dfNone,			0,			true,		true);
 		            InitDataProperty(0, cnt++,		dtData,					100,		daLeft,			true,     "vsl_cd",		false,		"",         dfNone,     	0,          true,      true);
 		            InitDataProperty(0, cnt++,		dtData,					50,			daCenter,		true,     "vsl_nm",		false,		"",         dfNone,     	0,          true,      true);		           
 		            InitDataProperty(0, cnt++,		dtData,					100,		daCenter,		true,     "crr_cd",		false,		"",         dfNone,     	0,          true,       true);
 		            InitDataProperty(0, cnt++,		dtData,					100,		daCenter,		true,     "spr_prt_tp_cd",		false,		"",         dfNone,     	0,          true,       true);
 		           
 		            for( var j = 0; j < HEAD_ADD.length; j++){
						var colIdNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
						InitDataProperty(0, cnt++ , dtData,	COL_WIDTH,		daCenter,  	false,    colIdNm,			false,      "",     dfNone,      	0,     	false,       true);
					}
 		           
 		           
 				}// end of with 				
 				break;
             case "sheet4": // Excel Down 시 Total 도 함께 넣기 위해 sheet1을 COPY
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 250;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     var viewRowCnt = FIXID_HEADER_COUNT + HEAD_ADD.length + 2;// +2는 TTL.QTY, Amount($)
                     InitRowInfo(HEADROWS, 1, viewRowCnt, 100);
                     
                     var HeadTitle1 = HEADER_TITLE1.join("|");
                     var HeadTitle2 = HEADER_TITLE2.join("|");
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, FIXID_HEADER_COUNT, 0, true);
 					
                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, false, false, true, false,false)
                     
         			
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, false);

     				
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,   false,    "ibflag");
                     InitDataProperty(0, cnt++, dtCheckBox,	 	40,		daCenter,  	true,     "sel_chk",				false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++, dtSeq, 			30,		daCenter,   true,     "Seq");

                     InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_no",		false,		"",     dfNone,     	0,      false,      false);
                     InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_seq",		false,		"",     dfNone,     	0,      false,      false);
                     InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_invt_ver_seq",	false,		"",		dfNone,     	0,      false,      false);
                     InitDataProperty(0, cnt++,	dtHidden,		0,		daCenter,	true,     "spr_prt_ver_seq",		false,		"",		dfNone,     	0,      false,      false);

                     InitDataProperty(0, cnt++, dtPopupEdit,	60,		daCenter,  	true,    "lane_cd",					false,      "",     dfEngUpKey,      	0,     	false,      true,	3);
                     InitDataProperty(0, cnt++, dtPopupEdit,	60,		daCenter,  	true,    "vsl_cd",					false,      "",     dfEngUpKey,      	0,  	false,      true,	4);
                     InitDataProperty(0, cnt++,	dtData,			200,	daLeft,		true,    "vsl_nm",				false,		"",    	dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++, dtData,			70,		daCenter,  	true,    "crr_cd",				false,      "",     dfNone,      	0,     	false,      false);
                     
                     InitDataProperty(0, cnt++, dtCombo,   		40,		daCenter,  	true,    "spr_prt_tp_cd",			false,      "",     dfNone,      	0,     	false,       true);
                     
                     InitDataCombo (0, "spr_prt_tp_cd", " |A|B", "N|A|B");
                     
                     for( var j = 0; j < HEAD_ADD.length; j++){
                    	 COL_WIDTH = 60;                        	
                     	var colNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                     	InitDataProperty(0, cnt++ , dtCombo,	COL_WIDTH,		daCenter,  	false,    colNm,false,      "",     dfNone,      	0,     	true,       true);
                     	
                     	InitDataCombo (0, colNm, " |" + UT_OPERATION + "|" + UT_SHARING, UT_NOT_SUPPLYING +"|" + UT_OPERATION + "|" + UT_SHARING);
                     	var colAmtNm = "cd_amt_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                     	InitDataProperty(0, cnt++ , dtHidden,	COL_WIDTH,		daCenter,  	false,    colAmtNm,			false,      "",     dfNone,      	0,     	false,       true);
                     	
                     }
                     InitDataProperty(0, cnt++ , dtData,  		70,		daCenter,  	true,    "ttl_qty",				false,      "",     dfInteger,      	0,     	false,      false);
                     InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,  	true,    "spr_prt_crnt_amt",	false,      "",     dfNullFloat,      	2,     	false,      false);
                     
                     InitDataValid(0, "lane_cd", vtEngUpOnly);
                     InitDataValid(0, "vsl_cd", vtEngUpOther, "0123456789");
                     ShowButtonImage = 1;
                     
                     
 				}// end of width
 				break;
        }

	}
	
    /**
     * IBCombo 기본 설정
     */
    function initCombo() {
    	var formObj = document.form;
    	with (formObj.combo_spr_prt_invt_no) {
    		
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("150");
			DropHeight = 160;
	
			Enable = true;
		}
    	
    	formObj.combo_spr_prt_invt_no.RemoveAll();
		formObj.combo_spr_prt_invt_no.Code2="-1";
    	
		// go Search : inventory_no로 combo 만들기
		formObj.f_cmd.value = SEARCH;
		var sXml   = sheetObjects[0].GetSearchXml("EES_MNR_0268GS.do", FormQueryString(formObj));
		/////////////
		var dataCount = ComGetTotalRows(sXml);// 데이터 건수
		if (dataCount > 0) {
			var arrResult = MnrXmlToArray(sXml);
			if(arrResult != null && arrResult != undefined){
				formObj.combo_spr_prt_invt_no.InsertItem(0, " ", "0");
				for(var i = 1; i <= arrResult.length;i ++){ 		
					formObj.combo_spr_prt_invt_no.InsertItem(i, arrResult[i-1][18] ,String(i));			
				}
				formObj.combo_spr_prt_invt_no.Index=0;
			} else {					
				ComShowCodeMessage("MNR00041");
			}
		}//
		
		
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
	
			initSheet(sheetObjects[i],i + 1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
   	 	}
   	 	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

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
				formObj.f_cmd.value = "";
				formObj.spr_prt_invt_no.value = "";
				formObj.cre_dt.value = "";
				formObj.cre_usr_nm.value = "";
//				sheetObjects[0].RemoveAll();
//				sheetObjects[1].RemoveAll();
				sheetObjects[0].Reset();
				sheetObjects[1].Reset();
				
				initCombo();
				initSheet(sheetObjects[0],1);
				initSheet(sheetObjects[1],2);
				MnrWaitControl(false);
				
				break;	
			case IBINSERT:
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				var sprPrtInvtNo = "";	
				var sprPrtInvtSeq = "";
				var sprPrtInvtVerSeq = "";
				var sprPrtVerSeq = "";// header version
				for( var i = 0; i < sheetObjects[0].DataRows; i++){
					sprPrtInvtNo = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_invt_no");	
					sprPrtInvtSeq = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_invt_seq");
					sprPrtInvtVerSeq = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_invt_ver_seq");
					sprPrtVerSeq = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_ver_seq");
					if( sprPrtInvtNo != "" && sprPrtInvtSeq != "" && sprPrtInvtVerSeq != ""){
						break;
					}
				}
				
				// VERSION SEQ가 없으면 HEADER의 VERSION SEQ를 사용
				if( sprPrtVerSeq == "" || sprPrtVerSeq == undefined){
					sprPrtVerSeq = HEAD_VER_SEQ;
				}
				//alert("sprPrtInvtNo=" + sprPrtInvtNo + ",sprPrtVerSeq = " + sprPrtVerSeq + ":" + HEAD_VER_SEQ);
				var row = sheetObjects[0].DataInsert(-1);
//				sheetObjects[0].CellValue2(row, "sel_chk") = "1";
				sheetObjects[0].CellValue2(row, "spr_prt_invt_no") = sprPrtInvtNo;
//				sheetObjects[0].CellValue2(row, "spr_prt_invt_seq") = "1";
				sheetObjects[0].CellValue2(row, "spr_prt_invt_ver_seq") = sprPrtInvtVerSeq;
				sheetObjects[0].CellValue2(row, "spr_prt_ver_seq") = sprPrtVerSeq;
				
				setSheet1Height();//높이설정
				MnrWaitControl(false);
	            break;
			case IBSAVE:
				
				if(!validateForm(sheetObjects[0],formObj,sAction))return;
				MnrWaitControl(true);
				
				formObj.f_cmd.value = MULTI;
				var sParam = "";
				
				sParam = setSaveParam("I");
				sParam += "&" + FormQueryString(formObj);

//				alert(sParam);
							
				//ComDebug(sParam);
				var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0267GS.do", sParam);
//				alert(sXml);
				
				sheetObjects[0].LoadSaveXml(sXml);
				//alert("LOADED");
//				alert(MnrComGetErrMsg(sXml));
				if(MnrComGetErrMsg(sXml) == null || MnrComGetErrMsg(sXml) ==  undefined){
					
					var invtNo = ComGetEtcData(sXml, "INVENTORY_NO");
					var orgInvtNo = formObj.spr_prt_invt_no.value;
					//alert("init data " + invtNo + ":" + orgInvtNo);
					initCombo();
					
					if ( invtNo == undefined) {
						formObj.combo_spr_prt_invt_no.Text = orgInvtNo;
						//formObj.spr_prt_invt_no.value = "";
					}else{
						
						//formObj.spr_prt_invt_no.value = ComGetEtcData(sXml, "INVENTORY_NO");
						formObj.combo_spr_prt_invt_no.Text = ComGetEtcData(sXml, "INVENTORY_NO");
//						var itemIdx = formObj.combo_spr_prt_invt_no.FindIndex ( invtNo, 0);
//						alert(itemIdx);
					}
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
				}
//				sheetObjects[0].LoadSearchXml(sXml);
//				
//				if( sheetObjects[0].RowCount == 0){
//					sheetObjects[1].RemoveAll();
//				}				
				
//				setEtcData(sXml);
//				calculationTotlaAmt();
				
				break;
			case IBSEARCH:      //조회
				if(!validateForm(sheetObjects[0],formObj,sAction))return;
				
//				// Header 조회.
//				var headerResult = getSheetHeader();
//				if( !headerResult){
//					return;
//				}
				
//				MnrWaitControl(true);
//				nowLoad = 1;
				formObj.f_gubuns.value = "";
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				
				formObj.f_cmd.value = SEARCH; 
				
				var sXml   = sheetObj.GetSearchXml("EES_MNR_0267GS.do", FormQueryString(formObj));
				//alert(sXml);
				
				setEtcData(sXml);
				initSheet(sheetObjects[0],1);
				initSheet(sheetObjects[1],2);
				sheetObjects[0].LoadSearchXml(sXml);
				break;
				
			case IBDELETE:
//				if(sheetObj.FindCheckedRow("sel_chk") == ""){ 
//					ComShowCodeMessage("MNR00038","DELETE ");
//					return false;             	   
//				}
				if(ComShowCodeConfirm("MNR00026")){
//					ComRowHideDelete(sheetObj, "sel_chk");
				
					var delRowCnt = 0;
					for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
						//if (sheetObjects[0].FindCheckedRow("sel_chk") == "1"){
							if(sheetObjects[0].CellValue(i, "ibflag") == "I") { //신규행의 경우 그리드에서만 삭제
								sheetObjects[0].RowDelete(i, false);
							}else{
								sheetObjects[0].CellValue(i, "ibflag") = "D";
								delRowCnt++;
							}
						//}
					}
					
					if( delRowCnt > 0){
						if(!validateForm(sheetObj,formObj,sAction))return;
						
						formObj.f_cmd.value = REMOVE;
	
						var sParam = setSaveParam("D");
						//alert(sParam);
						sParam += "&" + FormQueryString(formObj);
						
						var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0267GS.do", sParam);

						sheetObjects[0].LoadSaveXml(sXml);
						if( sheetObjects[0].RowCount == 0){
							sheetObjects[1].RemoveAll();
						}
						initCombo();
						setEtcData(sXml);
						calculationTotlaAmt();
						
					}
				}
	            break;
			case IBLOADEXCEL :
				
				sheetObjects[2].LoadExcel(-1,1,"","-1","-1","",true,false,""); 
				
				// 1. 기존 Key Data 검색
				var selChk = 1;
				var sprPrtInvtNo = "";
				var sprPrtInvtVerSeq = "";
				var sprPrtVerSeq = HEAD_VER_SEQ;
				// 2. 존재하는 Data 여부
				try{
//					alert(sheetObjects[2].HeaderRows + " : " + sheetObjects[0].HeaderRows);
//				//기존 중복 데이터 덮어쓰기	
				for(var i = sheetObjects[2].Rows; sheetObjects[2].HeaderRows<=i; i--) {
					
					var laneCdI = sheetObjects[2].CellValue(i, "lane_cd");
					var vslCdI = sheetObjects[2].CellValue(i, "vsl_cd");
					var vslNmI = sheetObjects[2].CellValue(i, "vsl_nm");
					var crrCdI = sheetObjects[2].CellValue(i, "crr_cd");
					var tpCdI = sheetObjects[2].CellValue(i, "spr_prt_tp_cd");
					
					if( vslCdI == undefined){
						continue;
					}
					
					for(var j=sheetObjects[0].HeaderRows; j<sheetObjects[0].Rows; j++) {
						// INVENTORY NO, VER_SEQ 가져옴
						if( sheetObjects[0].CellValue(j, "spr_prt_invt_no") != ""
							&& sheetObjects[0].CellValue(j, "spr_prt_invt_ver_seq") != "" ){
							
							sprPrtInvtNo = sheetObjects[0].CellValue(j, "spr_prt_invt_no");
							sprPrtInvtVerSeq = sheetObjects[0].CellValue(j, "spr_prt_invt_ver_seq");
							sprPrtVerSeq = sheetObjects[0].CellValue(j, "spr_prt_ver_seq");
						}

						var laneCdJ = sheetObjects[0].CellValue(j, "lane_cd");
						var vslCdJ = sheetObjects[0].CellValue(j, "vsl_cd");
						var vslNmJ = sheetObjects[0].CellValue(j, "vsl_nm");
						var crrCdJ = sheetObjects[0].CellValue(j, "crr_cd");
						var tpCdJ = sheetObjects[0].CellValue(j, "spr_prt_tp_cd");
						
						
						//alert(tpCd + " :: " + eval(tpCd).length);
						if( tpCdI != "A" && tpCdI != "B"){
							tpCdI = "N";
						}// Sheet에서 올라온 값 중에서 S,O가 아닌것은 'N'으로 Set.
						
						if(laneCdI == laneCdJ 
	                    	&& vslCdI == vslCdJ
	                    	//&& vslNmI == vslNmJ
	                    	&& crrCdI == crrCdJ
	                    	&& tpCdI == tpCdJ ) {
							
							for( var x= 0; x < HEAD_ADD.length; x++){
		                    	
		                    	var colNm = "cd_id_"+HEAD_ADD[x].spr_prt_vndr_seq+"_"+HEAD_ADD[x].spr_ut_mdl_nm;
		                    	var colValue = sheetObjects[2].CellValue(i, colNm);
		                    	colValue = colValue.toUpperCase();
		                    	if( colValue == "O"){
		                    		
		                    	}else if( colValue == "S"){
		                    		
		                    	}else{
		                    		colValue = "N";
		                    	}		                    	
		                    	sheetObjects[0].CellValue2(j, colNm) = colValue;
		       				}
							sheetObjects[2].RowDelete(i, false);
						}else{
							
						}
  												
					}
					
				}// end of for i
				}catch(e){
					//alert(e);					
				}
//				alert(sheetObjects[2].Rows);
				//신규 데이터 그리드에 추가
				for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].Rows; i++) {	
					var row = sheetObjects[0].DataInsert(-1);	
					
					sheetObjects[0].CellValue2(row, "spr_prt_invt_no") = sprPrtInvtNo;
					sheetObjects[0].CellValue2(row, "spr_prt_invt_ver_seq")	= sprPrtInvtVerSeq;
					sheetObjects[0].CellValue2(row, "spr_prt_ver_seq")	= sprPrtVerSeq;
					sheetObjects[0].CellValue2(row, "lane_cd") = sheetObjects[2].CellValue(i, "lane_cd");
					sheetObjects[0].CellValue2(row, "vsl_cd") = sheetObjects[2].CellValue(i, "vsl_cd");
					sheetObjects[0].CellValue2(row, "vsl_nm") = sheetObjects[2].CellValue(i, "vsl_nm");
					sheetObjects[0].CellValue2(row, "crr_cd") = sheetObjects[2].CellValue(i, "crr_cd");
					sheetObjects[0].CellValue2(row, "spr_prt_tp_cd") = sheetObjects[2].CellValue(i, "spr_prt_tp_cd");
					
					for( var j = 0; j < HEAD_ADD.length; j++){
                    	var colNm = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
                    	var colValue = sheetObjects[2].CellValue(i, colNm);
                    	colValue = colValue.toUpperCase();
                    	if( colValue == "O"){
                    		
                    	}else if( colValue == "S"){
                    		
                    	}else{
                    		colValue = "N";
                    	}		      
                    	sheetObjects[0].CellValue2(row, colNm) = colValue;
       				}						
				}
				
				sheetObjects[2].RemoveAll();
				setSheet1Height();//높이설정  
				break;
			
		}//end of switch
	}
	
	function getSheetHeader(){
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;	
		var sXml = sheetObjects[0].GetSearchXml("EES_MNR_0267GS2.do","",FormQueryString(formObj),true);

		try{
			var arrResult = MnrXmlToArray2(sXml);
			HEAD_ADD = new Array();
			for( var i = 0; i < arrResult.length; i++){
				HEAD_ADD.push(arrResult[i]);
				HEAD_VER_SEQ = arrResult[i].spr_prt_ver_seq;
			}
			formObj.spr_prt_ver_seq.value = HEAD_VER_SEQ;
		}catch(e){
//			alert(e);
			return false;
		}
		return true;
		
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction==IBSAVE)	{
				// duplication check
				var dupRows = sheetObj.ColValueDupRows("vsl_cd|vsl_nm|spr_prt_tp_cd",false);
				if(dupRows != -1 && dupRows != ""){
					ComShowCodeMessage("MNR00006","VSL CD and Type CD");
					return false;
				}
				
				//alert(sheetObjects[0].DataRows);
				// mandatory check
				for( var i = 0; i < sheetObjects[0].ROWCOUNT; i++){
					var headRowCnt = sheetObjects[0].HeadersRows;
					var vslCd = sheetObj.CellValue(Number(i) + HEADROWS, "vsl_cd");	
					var vslNm = sheetObj.CellValue(Number(i) + HEADROWS, "vsl_nm");
					var crrCd = sheetObj.CellValue(Number(i) + HEADROWS, "crr_cd");
					var typeCd = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_tp_cd");
					
					//alert(vslCd + " : " + vslNm + " : " + crrCd);
					if( vslCd == "" || vslNm == "" || crrCd == "" ){
						ComShowCodeMessage("MNR00003","VSL CD");
						return false;
					}
					// typeCd는 없을 수 있음.

				}
				
				
			} else if(sAction==IBSEARCH){
				
				//var invtNo	= ComGetObjValue(formObj.spr_prt_invt_no);
				var invtNo = formObj.combo_spr_prt_invt_no.Text;
				invtNo = ComTrim(invtNo);
				if(invtNo=='') {
					ComShowCodeMessage("MNR00003","Inventory No");
					formObj.combo_spr_prt_invt_no.focus();
				    return false;
				}
				
				var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
				if(sRow != ""){ // sheet 수정내용 있음				                               	
					if(!ComShowCodeConfirm("MNR00007"))	{
						return false;
					}
				}
				
				formObj.spr_prt_invt_no.value = invtNo;
				
			}
		}
	
		return true;
	}
	
	/**
	 * 화면에 Inventory No, Cre Dt, Cre Usr Id set
	 * @param sXml
	 */
	function setEtcData(sXml){
		var formObj = document.form;
		try{
			//alert(sXml);
			if ( ComGetEtcData(sXml, "INVENTORY_NO") == undefined) {
				//formObj.spr_prt_invt_no.value = "";
			}else{
				formObj.combo_spr_prt_invt_no.Text = ComGetEtcData(sXml, "INVENTORY_NO");
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
			
			// Header 조회를 위해
			if ( ComGetEtcData(sXml, "CD_VER_SEQ") == undefined) {
				
			}else{
				//alert("get cd verseq");
				//alert(HEAD_ADD.length);
				var cdVerSeq = ComGetEtcData(sXml, "CD_VER_SEQ");
				// Header 조회.
				var headerResult = getSheetHeader();
				if( !headerResult){
					return;
				}
				formObj.spr_prt_ver_seq.value = cdVerSeq;				 
			}
			
		}catch(e){

		}
	}
	/**
	 * 저장할 Grid Param 설정
	 * @returns {String}
	 */
	function setSaveParam(saveFlag){
		var sheetObj = sheetObjects[0];
		var rowCnt = sheetObjects[0].RowCount;
		var sParam = "";
		var idx = 0;
		for( var i = 0; i < rowCnt; i++){
			var ibflag = sheetObj.CellValue(Number(i) + HEADROWS, "ibflag");
			if( saveFlag == "D"){
				ibflag = "D";
			}
			var sprPrtInvtNo = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_invt_no");	
			var sprPrtInvtSeq = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_invt_seq");
			var sprPrtInvtVerSeq = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_invt_ver_seq");
			var sprPrtVerSeq = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_ver_seq");
			var laneCd = sheetObj.CellValue(Number(i) + HEADROWS, "lane_cd");
			var vslCd = sheetObj.CellValue(Number(i) + HEADROWS, "vsl_cd");
			var ops = sheetObj.CellValue(Number(i) + HEADROWS, "vps_port_cd");
			var typeCd = sheetObj.CellValue(Number(i) + HEADROWS, "spr_prt_tp_cd");
			
			//validation check  할 것.
			if(laneCd == ""){
				// message
				return;
			}
			if(vslCd == ""){
				// message
				return;
			}
			
			for( var j = 0; j < HEAD_ADD.length; j++){
				if( idx == 0){
					sParam += "ibflag=" + ibflag;
				}else{
					sParam += "&ibflag=" + ibflag;
				}
				idx++;
				
				if( sprPrtInvtSeq == ""){
					sprPrtInvtSeq = j;
				}
				sParam += "&sel_chk=" + sheetObj.CellValue(Number(i) + HEADROWS, "sel_chk");
				sParam += "&Seq=" + sheetObj.CellValue(Number(i) + HEADROWS, "Seq");

				//SPR_PRT_VNDR_SEQ, SPR_PRT_TP_CD, SPR_UT_MDL_NM, SPR_UT_SHR_CD
				sParam += "&spr_prt_invt_no=" + sprPrtInvtNo;
				sParam += "&spr_prt_invt_seq=" + sprPrtInvtSeq;
				sParam += "&spr_prt_invt_ver_seq=" + sprPrtInvtVerSeq;
				sParam += "&spr_prt_ver_seq=" + sprPrtVerSeq;				
				sParam += "&lane_cd=" + laneCd;
				sParam += "&vsl_cd=" + vslCd;
				sParam += "&vps_port_cd=" + ops;	
				
				
				var cdId = "cd_id_"+HEAD_ADD[j].spr_prt_vndr_seq+"_"+HEAD_ADD[j].spr_ut_mdl_nm;
				//SPR_PRT_VNDR_SEQ, SPR_UT_MDL_NM
				var cdIdArr = cdId.split("_");

				if( typeCd == ""){
					typeCd = "N";//default;
				}
				sParam += "&spr_prt_tp_cd=" + typeCd;
										
				
				var cdIdValue = sheetObj.CellValue(Number(i) + HEADROWS, cdId);
				//sParam += "&spr_ut_shr_cd=" + cdIdValue;
				//sParam += "&spr_ut_mdl_nm=" + HEAD_ADD[j].pair_cd_id;
				
				sParam += "&spr_prt_vndr_seq=" + cdIdArr[2];
				sParam += "&spr_ut_mdl_nm=" + cdIdArr[3];
				sParam += "&spr_ut_shr_cd=" + cdIdValue;
			}
		}

		sParam = ComSetPrifix(sParam, prefix);
		return sParam;
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
	/**
	 * 조회완료시 Summary sheet 설정
	 * @param sheetObj
	 * @param errMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "";
		
		if (errMsg == "") {
			calculationTotlaAmt();
        }
		
		formObj.spr_prt_invt_no.vale = "";//조회 Key 초기화
		MnrWaitControl(false);
	}     
	
	/**
	 * 하위 Total Grid 값 계산
	 */
	function calculationTotlaAmt(){
		// 두번째 sheet를 새로 그림
        if(sheetObjects[0].RowCount > 0) {
        	sheetObjects[1].RemoveAll();
        	setSheet1Height();//높이조절 하면서 Header Set
        	setSheet2Height();
        	
        	var totSheetHeaderRowCnt = 1;
        	var totSheetDataRowCnt = 4;
        	
        	if( sheetObjects[0].RowCount >= MAX_ROW){
        		totSheetHeaderRowCnt = 2;
        	}       	
        	
        	
        	for(var i = totSheetHeaderRowCnt; i < (totSheetHeaderRowCnt +totSheetDataRowCnt)+1; i++){
        		var row = sheetObjects[1].DataInsert(-1);
        		
            	sheetObjects[1].CellValue2(row, "lane_cd") = "TOTAL";
//            	if( sheetObjects[0].RowCount >= MAX_ROW && i == totSheetHeaderRowCnt){
//        			//alert(i + "==" + totSheetHeaderRowCnt);
//            		sheetObjects[1].RowHeight(totSheetHeaderRowCnt) = 40;
//            	}            	
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
        	}// default ro	w/col set
        	
        	// 배경색
			sheetObjects[1].RowBackColor(totSheetHeaderRowCnt + 1) = sheetObjects[1].RgbColor(255,192,255);
			sheetObjects[1].RowBackColor(totSheetHeaderRowCnt) = sheetObjects[1].RgbColor(200,200,255);
			
			
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
        				//test
        				
        				//test
        				/* 1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규 start */
        				sheetObjects[1].InitCellProperty(targetIdx, colIdNm, dtData, daCenter, "", "", dfInteger );
        				sheetObjects[1].InitCellProperty(targetTotInx, colIdNm, dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetIdx, "ttl_qty", dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetTotInx, "ttl_qty", dtData, daCenter, "", "", dfInteger ); 
        				sheetObjects[1].InitCellProperty(targetIdx, "spr_prt_crnt_amt", dtData, daRight, "", "", dfNullFloat, 2 ); 
        				sheetObjects[1].InitCellProperty(targetTotInx, "spr_prt_crnt_amt", dtData, daRight, "", "", dfNullFloat, 2 ); 
        				/* 1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규 end */
        			}catch(e){
        				//alert(e);console.log(e);
        			}
        			
        		}// end of for j
        	}//end of for i
//        	
        	var sumO = MnrNullToZero(sheetObjects[1].CellValue(totSheetHeaderRowCnt + 1, "ttl_qty"));
        	var sumS = MnrNullToZero(sheetObjects[1].CellValue(totSheetHeaderRowCnt + 2, "ttl_qty"));
        	var sumN = MnrNullToZero(sheetObjects[1].CellValue(totSheetHeaderRowCnt + 3, "ttl_qty"));
//        	alert(sumO + " : " + sumS + " : " + sumN);
        	sheetObjects[1].CellValue2(targetTotInx, "ttl_qty") = Number(sumO) + Number(sumS) + Number(sumN);        	
        }
	}
	
	/**
	 * Code Inquiry 팝업창 호출
	 */
	function codeInquiryPopup(){
		MnrWaitControl(true);
		var formObject = document.form;
		var sprPrtVerSeq = formObject.spr_prt_ver_seq.value;
		ComOpenPopup("EES_MNR_0270.do?spr_prt_ver_seq="+sprPrtVerSeq, 1000, 560, '', '0,0', true); 

		MnrWaitControl(false);
	}
	/**
	 * Sheet Column 클릭 시 Popup
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if(sheetObj.ColSaveName(Col) == "vsl_cd"){			
			vslInfoPopup();
		}else if(sheetObj.ColSaveName(Col) == "lane_cd"){
			MnrWaitControl(true);
			ComOpenPopup("COM_ENS_081.do", 780, 420, 'setPopUpParamSheet_COM_ENS_081', '0,1', true);
			MnrWaitControl(false); 
		}else if(sheetObj.ColSaveName(Col) == "crr_cd"){
			MnrWaitControl(true);
			var sUrl = "/hanjin/VOP_VSK_0043.do";
			ComOpenPopup(sUrl, 422, 520, "setPopupParamSheet_VOP_VSK_0043", "0,0", true);
			MnrWaitControl(false);
		}
	}
	
	function vslInfoPopup(){
		MnrWaitControl(true);
		var Row=sheetObjects[0].SelectRow;
		var vslCd = sheetObjects[0].CellValue(Row, "vsl_cd");	
		ComOpenPopup("COM_ENS_0A1.do?vsl_cd="+vslCd, 620, 460, 'setPopUpParam_COM_ENS_0A1', '0,1', true);
		MnrWaitControl(false); 
	}
	/**
	 * Sheet 값이 변경되었을 때
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 */
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObject = document.form;
		var colName = sheetObj.ColSaveName(col);
		switch(colName){
			case 'vsl_cd':
				//formObj.f_cmd.value = SEARCH;                
                //var selectVal = FormQueryString(formObj);
				var selectVal = "f_cmd=" + SEARCH;
				selectVal += "&vsl_cd=" + value;
                var sXml = sheetObjects[0].GetSearchXml("COM_ENS_0A1GS.do","",selectVal,true);
				
				try{
					if (ComGetTotalRows(sXml) < 1) {
						// open popup
						vslInfoPopup();
					}else{
						var arrResult = MnrXmlToArray2(sXml);
						if( arrResult.length == 1){						
							//set value
							var resultArr = new Array();
							resultArr.push("");//ibflag
							resultArr.push("");//radio
							resultArr.push("");//checked
							resultArr.push(arrResult[0].vsl_cd);
							resultArr.push(arrResult[0].vsl_eng_nm);
							resultArr.push(arrResult[0].crr_cd);
							
							setPopUpParam_COM_ENS_0A1(resultArr);
						}else{
							// open popup
							vslInfoPopup();
						}
					}
				}catch(e){
					//alert(e);
				}

			break;
		}
	}
	// Lane Cd 
	function setPopUpParamSheet_COM_ENS_081(array) {

    	if(array == null)return;
    	var formObj = document.form;
    	var str = array + "";
    	var arr = str.split(",");
 
    	sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lane_cd") = arr[3];
    }
	
	// VSL CD
	function setPopUpParam_COM_ENS_0A1(array) {
    	if(array == null)return;
    	var str = array + "";	
    	var arr = str.split(',');
    	var Row=sheetObjects[0].SelectRow;
    	
    	sheetObjects[0].CellValue2(Row,"vsl_cd")=arr[3];
    	sheetObjects[0].CellValue2(Row,"vsl_nm")=arr[4];
    	sheetObjects[0].CellValue2(Row,"crr_cd")=arr[5];
		var checkVsl=sheetObjects[0].CellValue(Row,"vsl_cd");
		sheetObjects[0].CellValue2(Row,"vsl_cd")=checkVsl.toUpperCase();
		checkVsl=checkVsl.toUpperCase();

		//맞는 EQ_NUMBER Equipment Information 를 표시한다.
		setVesselInfo(sheetObjects[0],Row,checkVsl);	
    }
	/**
	 * 맞는 EQ_NUMBER Equipment Information 를 표시한다.
	 * @param sheetObj
	 * @param Row
	 * @param vsl_cd
	 */
	function setVesselInfo(sheetObj,Row,vsl_cd){
		
		var formObj = document.form;
		var sXml = MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr =  MnrXmlToArray(sXml); 
		//0vsl_eng_nm|1 ibflag|2 skd_dir_cd| 3 skd_voy_no|4 pagerows|5 vsl_slan_cd|6 vsl_cd|
		//0 imm_ext|1 mvmt_dt|2 dv_cur|3 rpr_yd|4 sp_name|5 flg_rmk|6 manu_dt|7 pagerows|8 dv_value|9 ibflag|10 off_hire|11 mvmt_cd|12 dsp_flag|13 hngr_flg_yd|14 lessor_nm|15 hngr_rck_cd|16 crnt_yd_cd|17 lstm_cd|18 eq_no|19 hngr_flg_dt|20 bar_atch_knt|21 status|22 bar_tp_cd|23 dmg_flag|24 cost|25 eq_type|26 rpr_type|27 eq_tpsz_cd|28 rpr_dt						
		if(retArr != null){  
			
			sheetObjects[0].CellValue2(Row,"vsl_nm")=retArr[0][0];
			sheetObjects[0].CellValue2(Row,"lane_cd")=retArr[0][5];
			//Lane	
			if(retArr[0][5]=="")
			{
				ComShowCodeMessage("MNR00254",vsl_cd + " of Veseel Code","Lane");
				
				//Lane	
				sheetObjects[0].CellValue2(Row,"lane_cd")="";
				//Vessel Name	
				sheetObjects[0].CellValue2(Row,"vsl_nm")="";
				//Crr Cd	
				sheetObjects[0].CellValue2(Row,"crr_cd")="";
				sheetObjects[0].CellValue2(Row,"vsl_cd")="";     
				sheetObjects[0].SelectCell(Row,"vsl_cd"); 
			} 

		} else {			
			//VSL_nm	
			sheetObjects[0].CellValue2(Row,"vsl_nm")="";
			//Lane	
			sheetObjects[0].CellValue2(Row,"lane_cd")="";

			ComShowCodeMessage("MNR00165",vsl_cd,"Vessel Code");          				
			sheetObjects[0].CellValue2(Row,"vsl_cd")="";     
			sheetObjects[0].SelectCell(Row,"vsl_cd");  

		}	
		MnrWaitControl(false);

	}
	
	function setPopupParamSheet_VOP_VSK_0043(rtnObjs){
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
//					sheetObjects[0].CellValue2(Row,"vps_port_cd") = rtnDatas[2];
					sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"vps_port_cd") =  rtnDatas[2];
				}
			}
		}
	}// end of function
	function setPopupParamSheet_EES_MNR_0270(rtnObjs){
		
	}
	
	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "spr_prt_invt_no":
  				if(event.keyCode == '13'){
	  				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	  				break;
  				}
  		}
  	}
