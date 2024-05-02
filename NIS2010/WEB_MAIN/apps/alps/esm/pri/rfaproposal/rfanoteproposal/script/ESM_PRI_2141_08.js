/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2141_08.js
*@FileTitle : Amendment History - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.09 최성민
* 1.0 Creation
=========================================================
* History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
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
     * @class ESM_PRI_2141_08 : ESM_PRI_2141_08 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2141_08() {
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

	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	
	var sChgCdVisiable = "";
	var delTotal = false;//DETAIL의 마지막 ROW를 삭제할때 사용되는 FLAG
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.10.28
     */
	function processButtonClick(){
       
	}

  /**
    * IBSheet Object를 배열로 등록 <br>
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
    * 배열은 소스 상단에 정의 <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj 필수 IBSheet Object
    * @return 없음
    * @author 최성민
    * @version 2009.10.28
    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}



   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 최성민
    * @version 2009.05.17
    */
	function loadPage() {

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

        loadSts = true;
		parent.loadTabPage();
	}



   /**
    * 시트 초기설정값, 헤더 정의 <br>
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
    * @return 없음
    * @author 최성민
    * @version 2009.05.22
    */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {

			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel.|Seq.|dp_seq|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq" +
							"|1|2|3";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtDataSeq, 		50, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtData,     	700,   	daLeft,  	false,	"note_tit_nm",   	false,	"",	dfNone,	0,	false,	false, 30);

					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "src_info_cd");    
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "prc_prog_sts_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");

                    InitDataValid(0, "note_tit_nm", vtEngOther, PRI_VALID_CHAR);  // 한글제외
                    AutoRowHeight = false;
                    WaitImageVisible = false;

				}
				break;

             case "sheet2":
 				with (sheetObj) {
					// 높이 설정
					style.height = 150;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Sel.|Seq.|Contents|EFF Date|EXP Date|Source|Status|Accepted|Accepted" +
									"|1|2|3|4|5|6|7|8|9|10";
					var HeadTitle2 = "|Sel.|Seq.|Contents|EFF Date|EXP Date|Source|Status|By|On" +
									"|1|2|3|4|5|6|7|8|9|10";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		40,    	daCenter,  	true,	"chk");
					InitDataProperty(0, cnt++ , dtDataSeq, 		50, 	daCenter, 	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,     	350,    daLeft,		true, 	"note_ctnt",   				false,	"",	dfNone, 	0, 		false, 		false, 50);
 					
 					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter, 	true,	"eff_dt",		  			false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter, 	true, 	"exp_dt",   	   			false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtCombo,     	80, 	daCenter, 	true, 	"src_info_cd", 				false,	"",	dfNone, 	0, 		false, 		false);
 					InitDataProperty(0, cnt++ , dtCombo,     	80,     daCenter, 	true, 	"prc_prog_sts_cd", 			false,	"",	dfNone, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtData,   		150,   	daLeft,  	false,	"acpt_usr_nm",				false,	"",	dfNone, 	0,     	false, 		false);
					InitDataProperty(0, cnt++ , dtData,    		70,   	daCenter,  	false,	"acpt_dt",					false,	"",	dfDateYmd,	0,     	false, 		false);
					
 					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	true,	"dp_seq");
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "note_seq");
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "note_ctnt_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	true,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "note_conv_mapg_id");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "note_conv_flg");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	true,  "n1st_cmnc_amdt_seq");

	                InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue);            
	                InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue);    
	                			
 					AutoRowHeight = false;
 					ShowButtonImage = 2; 	
                    WaitImageVisible = false;				
 				}
                 break;
                                  
         	case "sheet3":
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 195; 
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle = "|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
              				"|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type" +
                     		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtHidden,     		40,   daCenter,  true,	"chk");
                     InitDataProperty(0, cnt++ , dtData,	   		50,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,			85,   daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,			85,   daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,       false);
                     InitDataProperty(0, cnt++ , dtCombo,    		80,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,  	    	40,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,        	35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,         	75,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,      	2,     false,       false,	9);
                     InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     false,       false);
                     
                     InitDataProperty(0, cnt++ , dtData,   			35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,  			40,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,      	false, 	3);
                     InitDataProperty(0, cnt++ , dtData,  			50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     false,       false,	3);
                     InitDataProperty(0, cnt++ , dtData,			60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData,			90,  daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     false,       false,	9);
                     InitDataProperty(0, cnt++ , dtCombo,			35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,    		65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData,    		65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     false,       false,	5);                     
                     InitDataProperty(0, cnt++ , dtData,    		65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     false,       false,	5);
                     
                     InitDataProperty(0, cnt++ , dtData,    		65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData,    		70,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,    		70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     false,       false,	6);
                     InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     false,       false,	4);
                     InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     false,       false,	4);
                     InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtCombo,   	 	55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     false,       false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"svc_scp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"prop_no");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");    
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_cmdt_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_tp_cd");
                     
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_vsl_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_voy_no");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_dir_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");
                     
                     InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");										
                     InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
                     InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);   
                     InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
                     InitDataCombo(0, "bkg_hngr_bar_tp_cd", bkgHngrBarTpCdComboText, bkgHngrBarTpCdComboValue); 
                       					 
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 CountPosition = 0;		// Total 숨김
	                 WaitImageVisible = false;
         		}
              	break;

         }
     }
    /**
    * SHEET의 ROW을 클릭할때 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 해당하는 자식SHEET를 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM 필수 HTML태그(Object) 오브젝트
    * @param {ibsheet} sheetD 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} appendRow 필수 SHEET Row 추가 유무
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, sheetC, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (OldRow != NewRow) {
			formObj.note_seq.value = sheetM.CellValue(adjNewRow, "note_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}
	
   /**
    * Special Note 의 DETAIL SHEET를 클릭할때 호출되는 function <br>
    * DETAIL SHEET의 ROW별로 CONVERSION을 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetM 필수 IBSheet Object
    * @param {ibsheet} sheetD 필수 IBSheet Object
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.07.15
    */ 
    function doRowChangeConversion(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (OldRow != NewRow) {				
			formObj.note_seq.value = sheetM.CellValue(NewRow, "note_seq");
			formObj.note_ctnt_seq.value = sheetM.CellValue(NewRow, "note_ctnt_seq");
			formObj.note_conv_mapg_id.value = sheetM.CellValue(NewRow, "note_conv_mapg_id");
			doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
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
     * @author 최성민
     * @version 2009.05.22
     */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		try {
	  		sheetObj.ShowDebugMsg = false;
	  		switch (sAction) {
	  			case IBSEARCH: // 조회
	  				ComOpenWait(true);
		  			for (var i = 0; i < sheetObjects.length; i++) {
						sheetObjects[i].RemoveAll();
					}
	  			  			
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2041_08GS.do" , FormQueryString(formObj));
	  				break;
	  				
	  			case IBSEARCHAPPEND: // 조회
	  				ComOpenWait(true);
	  				formObj.f_cmd.value = SEARCH02;
	  				sheetObj.DoSearch("ESM_PRI_2041_08GS.do" , FormQueryString(formObj));
	  				break;
	  				
	  				
	  			case IBSEARCH_ASYNC01: // 조회
	  				ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH13;
	  				sheetObj.DoSearch("ESM_PRI_2041_08GS.do" , FormQueryString(formObj));
					break;
	  		}
  		}catch(e){
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e);
  			}
  		}finally {
  			 ComOpenWait(false);
  		}
  	}
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 최성민
     * @version 2009.05.19
     */  	
  	 function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
			//하이라이트 처리
			changeSelectBackColor4Master(sheetObj, document.form);
		}
		doRowChange(sheetObjects[0], sheetObjects[1],  sheetObjects[2],OldRow, NewRow, OldCol, NewCol, false);
		
	}
  	 
     /**
      * OnSelectCell 이벤트 발생시 호출되는 function <br>
      * 다른 ROW를 선택할때 재조회한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @return 없음
      * @author 최성민
      * @version 2009.07.15
      */ 
  	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {		
		if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }

    	doRowChangeConversion(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
  	}
  
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2009.06.18
     */
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
 	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 	    var formObj = document.form;
 	    var colname = sheetObj.ColSaveName(Col);  	 
 	    var amdtSeq = formObj.amdt_seq.value;
 	    var effDt = formObj.eff_dt.value;
 	    var propStsCd = formObj.prop_sts_cd.value;
 	    
      	switch(colname)
      	{
      		case "note_ctnt":
	    		ComShowMemoPad(sheetObj, Row, Col, true, 350);
	    		break;      	
      	}
	} 
		
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *         로직처리;
      *     }
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @returns bool <br>
      *          true  : 폼입력값이 유효할 경우<br>
      *          false : 폼입력값이 유효하지 않을 경우
      * @author 최성민
      * @version 2009.04.17
      */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		}
		
		 return true;
	}


 	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
     * @param {string} sPropStsCd 필수 pro_sts_cd 값
     * @param {string} sEffDt 필수 eff_dt 값
     * @param {string} sExpDt 필수 exp_dt 값
     * @param {string} sPreExpDt 필수 pre_exp_dt 값
     * @return 없음
     * @author 최성민
     * @version 2009.05.21
     */ 
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg) {
		var formObject = document.form;
		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
			formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
			formObject.prop_no.value = sPropNo;
			formObject.amdt_seq.value = sAmdtSeq;
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.pre_amdt_seq.value = sPreAmdtSeq; 
			formObject.prop_sts_cd.value = sPropStsCd; 
			formObject.eff_dt.value = sEffDt;
			formObject.exp_dt.value = sExpDt;			
			formObject.pre_exp_dt.value = sPreExpDt ;
			formObject.req_usr_flg.value = sIsReqUsr ;
			formObject.apro_usr_flg.value = sIsAproUsr ;	
//			formObject.dur_dup_flg.value = sDurDupFlg ;
			formObject.dur_dup_flg.value = "Y" ;

			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);		
			
		}
	}

	/**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2009.05.20
     */ 
	function tabClearSheet() {
		var formObject = document.form;

		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
	}
	
	var enableFlag = true;

	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		enableFlag = flag;
	}
	
    /**
    * DETAIL의 SOURCE CODE에 따라 색상 변경하는 function <br>
    * 
    * <br><b>Example :</b>
    * <pre>
    * manageMasterColor(sheetM, sheetD);
    * </pre>
    * @param {object} IBSheet  
    * @param {object} IBSheet
    * @return 없음
    * @author 최성민
    * @version 2009.06.10
    */ 	
    function manageMasterColor(sheetM, sheetD) {
    	//SHEET ROW COUNT
    	var formObj = document.form;
    	var amdt_seq = formObj.amdt_seq.value;
    	var eff_dt = formObj.eff_dt.value;
		
		//AMEND 지정
		var amend_check = false;
		//ALL AMEND DELETE
		var amend_delete_check = false;
		
		try {
  			if(row_count > 0){
  				
  				amend_delete_check = true;
  				
  				for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
  					if(sheetD.CellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
  						if(sheetD.CellValue(i,"src_info_cd") !="AD") {
  							amend_delete_check = false;
	  	  				}
  						
  						if(sheetD.CellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
	  	  					amend_check = true;
	  	  				}
  					}
	  			}
	  			
	  			if(amdt_seq == "0"){
	  				amend_delete_check = false;
	  			}
	  				  			
	  			if(amend_delete_check) {
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=true;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);  
	  			} else if(amend_check){
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);
	  			} else {
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(0,0,0);
	  			}
  			}
		}catch(e) {}
	} 
 
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
		var propStsCd = formObj.prop_sts_cd.value;
		formObj.master_del_chk.value = "N";
		
		//DETAIL의 모든 로우의 SOURCE가 AD일경우 MASTER에 색처리
		for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if(sheetObj.CellValue(i,"amdt_seq") > 0) {
				if(sheetObj.CellValue(i,"src_info_cd") == 'AD') {
					sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
					sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				} else if(sheetObj.CellValue(i,"src_info_cd") == 'AM' || sheetObj.CellValue(i,"src_info_cd") == 'NW') {
					sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				}					
			}
		}

		//하이라이트 처리
		changeSelectBackColor4Master(sheetObj, document.form);
	}
 
    
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		 manageCellEditable (sheetObj);
	}
	
 	/**
 	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	 * @return 없음
 	 * @author 최성민
 	 * @version 2009.05.20
 	 */ 
 	function sheet3_OnSearchEnd(sheetObj, errMsg){ 	
 		for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {	     		
	 		//Route 에서 State 코드일 경우 색상처리
	 		setStateColor(sheetObj, i);
			
	 		//Rule Code 일 경우에는 색상을 지정
	 		//setChargeRuleColor(sheetObj, i);
 		}
 	}
 	
	/**
     * SHEET의 CELL 수정권한을 제어하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	manageCellEditable (sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
     function manageCellEditable (sheetObj) {
	  		
    	 var formObj 		= document.form;
    	 var amdtSeq 		= formObj.amdt_seq.value;
    	 var reqUsrFlg 		= formObj.req_usr_flg.value;
    	 var aproUsrFlg 	= formObj.apro_usr_flg.value;
    	 var propStsCd 		= formObj.prop_sts_cd.value;
    		    	 
    	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
    		     		 
    		  // AMDT_SEQ가 다르면 DISABLE
    		  if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq){ 
    			  sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
    		  }
			 	
    		  if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0){
    			  	sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
					sheetObj.CellBackColor(i,"note_ctnt") = sheetObj.RgbColor(255,255,255);
    		  } else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && amdtSeq > 0){
					sheetObj.CellBackColor(i,"note_ctnt") = -1;
    		  }	 
	  		  
    	 }
     }
  

   	/**
   	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * setStateColor(sheetObj, Row);
   	 * </pre>
   	 * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 IBSheet Object 의 Row Index
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2009.07.09
   	 */ 
  	function setStateColor(sheetObj, Row) {
  		// State 색 구분
  		var pinkColor = sheetObj.RgbColor(255,192,203);
  		
 		if(sheetObj.CellValue(Row, "bkg_por_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
  		}
 		if(sheetObj.CellValue(Row, "bkg_pol_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
  		}
 		if(sheetObj.CellValue(Row, "bkg_pod_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
  		}
 		if(sheetObj.CellValue(Row, "bkg_del_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
  		}
 		
 		if(sheetObj.CellValue(Row, "conv_org_loc_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
  		}
 		if(sheetObj.CellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
  		}
 		if(sheetObj.CellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
  		}
 		if(sheetObj.CellValue(Row, "conv_dest_loc_tp_cd") == "T") {
  			sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
  		} 		
  	
  	}
  	
   	/**
   	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * setChargeRuleColor(sheetObj, Row);
   	 * </pre>
   	 * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 IBSheet Object 의 Row Index
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2009.07.09
   	 */ 
  	function setChargeRuleColor(sheetObj, Row) {
  		// Rule & Charge Code 색 구분
  		var sCodeColor = sheetObj.RgbColor(255,200,200);
  		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
 	 		
  		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
  			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
  			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
  			&& chgRuleDefCd != "RAC" ) {
  			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
  		} else {
  			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
  		} 
  	}

	var loadSts = false;
  	/**
     * 메인에서 호출하는 function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *loadFinishCheck()
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.05.19
     */
	 function loadFinishCheck(){
	     return loadSts;
	 } 
	/* 개발자 작업  끝 */