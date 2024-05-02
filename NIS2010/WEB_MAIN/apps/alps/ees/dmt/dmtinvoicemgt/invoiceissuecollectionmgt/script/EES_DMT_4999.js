/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : EES_DMT_4999.js
*@FileTitle : Send Invoice To To A/R & ERP By Manual
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2018.03.27 이성훈
* 1.0 Creation
* =========================================================*/
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
     * @class EES_DMT_4999 : EES_DMT_4999 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4999() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0; 
	
	// 버튼 기능 구분을 위한  Action 변수 정의
	var IBSEND		 = 10000;
	var IBLOADEXCEL1 = 10001;
	var IBLOADEXCEL2 = 10002;
	var IBLOADEXCEL3 = 10003;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				// Send Invoice to A/R & ERP
				case "btn_send":
					doActionIBSheet(sheetObj1, formObj, IBSEND);
					break;
					
				// Load Excel ( AR Invoice Main )
 				case "btn_loadexcel1":
 					doActionIBSheet(sheetObj1, formObj, IBLOADEXCEL1);
 					break;
 					
 				// Load Excel ( AR Invoice Charge )
 				case "btn_loadexcel2":
 					doActionIBSheet(sheetObj2, formObj, IBLOADEXCEL2);
 					break;
 					
 				// Load Excel ( AR Invoice Container )
 				case "btn_loadexcel3":
 					doActionIBSheet(sheetObj3, formObj, IBLOADEXCEL3);					

             } // end switch
		} 
		catch(e) {
     		if (e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} 
     		else {
     			ComShowMessage(e);
     		}
     	}
     }

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
	function setSheetObject(sheet_obj) {
		
    	sheetObjects[sheetCnt++] = sheet_obj;
	}

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
	function loadPage() {

    	for (i=0; i<sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
		
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}		
		
  	    //html컨트롤 이벤트초기화
		initControl();
	}

    function initControl() {
    	
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- 키보드 입력할때
	}
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		
	   	switch(event.srcElement.dataformat) {
		  	case "engup":
			   	// 영문대, 숫자
		  		ComKeyOnlyAlphabet('uppernum');
			    break;
			    
		  	case "engup2":
			    // 영문대+숫자+예외문자
		  		DmtComKeyOnlyAlphabet('uppernum', ',');
			    break;
			    
		  	case "int":
			    //숫자 만입력하기
			    ComKeyOnlyNumber(event.srcElement);
			    break;
			    
		  	default:
		      	// 숫자만입력하기(정수,날짜,시간)
		        ComKeyOnlyNumber(event.srcElement);
		}
    }
      
	/**
	  * 시트 초기설정값, 헤더 정의
	  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	  */
	function initSheet(sheetObj, sheetNo) {
		
	    var cnt = 0;
	
	    switch(sheetObj.id) {
	    	case "sheet1":
		        with (sheetObj) {
		             // 높이 설정
		             style.height = 100;
		             // 전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		            //전체Edit 허용 여부 [선택, Default false]
		             Editable = false;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo(1, 1, 2, 100);
		
		             var HeadTitle  = "||Seq.|BL_NO|BL_SRC_NO|INV_SRC_NO|BKG_NO|CUST_CNT_CD|CUST_SEQ|OFC_CD|IF_SRC_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|TRNK_VSL_CD|TRNK_SKD_VOY_NO|TRNK_SKD_DIR_CD|POR_CD|POL_CD|POD_CD|DEL_CD|BKG_TEU_QTY|BKG_FEU_QTY|IO_BND_CD|SLS_OFC_CD|CRE_USR_ID|CRE_OFC_CD|CRE_DT|UPD_USR_ID|UPD_OFC_CD|UPD_DT|INV_REF_NO|INV_RMK|DEST_TRNS_SVC_MOD_CD|CR_INV_NO";
		             
		             var headCount = ComCountHeadTitle(HeadTitle);
		             
		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		             InitColumnInfo(headCount, 0, 0, true);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false);
		
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, true);
		             
		             //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,				KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		             InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter, 	true,   	"ibflag");
		             InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		"CheckBox");
		             InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,	true,		"seq");
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"bl_no",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"bl_src_no",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"inv_src_no",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"bkg_no",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cust_cnt_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cust_seq",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"ofc_cd",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"if_src_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"vsl_cd",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"skd_voy_no",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"skd_dir_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"trnk_vsl_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"trnk_skd_voy_no",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"trnk_skd_dir_cd",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"por_cd",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"pol_cd",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"pod_cd",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"del_cd",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"bkg_teu_qty",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"bkg_feu_qty",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"io_bnd_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"sls_ofc_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_usr_id",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_ofc_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_dt",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_usr_id",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_ofc_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_dt",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"inv_ref_no",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"inv_rmk",				false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"dest_trns_svc_mod_cd",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cr_inv_no",			false,		"",			dfNone,			0,		false,		false);	             
						
		             FrozenCols = SaveNameCol("bkg_no");
					
		             CountPosition = 2;					
		         }
		        break;
		        
	    	case "sheet2":
		        with (sheetObj) {
		             // 높이 설정
		             style.height = 150;
		             // 전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		            //전체Edit 허용 여부 [선택, Default false]
		             Editable = false;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo(1, 1, 2, 100);
		
		             var HeadTitle  = "||Seq.|SRC_IF_DT|SRC_IF_SEQ|CHG_SEQ|CURR_CD|CHG_CD|PER_TP_CD|TRF_RT_AMT|RAT_AS_CNTR_QTY|CHG_AMT|TRF_NO|TVA_FLG|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|SBC_FLG|KKC_FLG";
		             
		             var headCount = ComCountHeadTitle(HeadTitle);
		             
		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		             InitColumnInfo(headCount, 0, 0, true);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false);
		
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, true);
		
		             //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,				KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		             InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter, 	true,   	"ibflag");
		             InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		"CheckBox");
		             InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,	true,		"seq");
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"src_if_dt",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"src_if_seq",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"chg_seq",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"curr_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"chg_cd",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"per_tp_cd",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"trf_rt_amt",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"rat_as_cntr_qty",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"chg_amt",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"trf_no",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"tva_flg",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_usr_id",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_dt",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_usr_id",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_dt",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"sbc_flg",			false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"kkc_flg",			false,		"",			dfNone,			0,		false,		false);
						
		             FrozenCols = SaveNameCol("chg_seq");
					
		             CountPosition = 2;					
		         }
	         break;	
	         
	    	case "sheet3":
		        with (sheetObj) {
		             // 높이 설정
		             style.height = 150;
		             // 전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		            //전체Edit 허용 여부 [선택, Default false]
		             Editable = false;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo(1, 1, 2, 100);
		
		             var HeadTitle  = "||Seq.|SRC_IF_DT|SRC_IF_SEQ|CNTR_SEQ|CNTR_NO|CNTR_TPSZ_CD|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT";
		             
		             var headCount = ComCountHeadTitle(HeadTitle);
		             
		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		             InitColumnInfo(headCount, 0, 0, true);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false);
		
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, true);
		
		             //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,				KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		             InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter, 	true,   	"ibflag");
		             InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		"CheckBox");
		             InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,	true,		"seq");
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"src_if_dt",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"src_if_seq",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cntr_seq",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cntr_no",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cntr_tpsz_cd",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_usr_id",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"cre_dt",		false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_usr_id",	false,		"",			dfNone,			0,		false,		false);
		             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"upd_dt",		false,		"",			dfNone,			0,		false,		false);

		             FrozenCols = SaveNameCol("cntr_seq");
					
		             CountPosition = 2;					
		         }
	         break;		         
	    }
	}
	  
   /**
    * Sheet관련 프로세스 처리 
    */		
	function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {
    		case IBLOADEXCEL1:
    		case IBLOADEXCEL2:
    		case IBLOADEXCEL3:
    			
    			//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);
    			
		        sheetObj.RemoveAll();
    			sheetObj.LoadExcel();
    			
    			//ComOpenWait End
				ComOpenWait(false);

				break;
				
    		case IBSEND:
    			formObj.f_cmd.value = MULTI;

    			var sParam  = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				var sParam2 = sheetObjects[1].GetSaveString();
				var sParam3 = sheetObjects[2].GetSaveString();
    			
				sParam = sParam1 + "&";

				if (sheetObjects[1].IsDataModified == true) {
					sParam2 = ComSetPrifix(sParam2, "subChg");
					sParam = sParam + sParam2 + "&";
				}
				if (sheetObjects[2].IsDataModified == true) {
					sParam3 = ComSetPrifix(sParam3, "subCntr");
					sParam = sParam + sParam3 + "&";
				}
				sParam += "&" + FormQueryString(formObj);
				
				// 전송실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_4999GS.do", sParam);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				// 결과 처리
				sheetObj.LoadSaveXml(sXml);			
    			break;
    	}
	}

	/**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
	function validateForm(sheetObj, formObj, sAction){
		
        return true;
	}
	
	/* 개발자 작업  끝 */