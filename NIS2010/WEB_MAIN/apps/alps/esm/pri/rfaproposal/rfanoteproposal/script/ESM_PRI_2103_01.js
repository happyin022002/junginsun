/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2103_01.js
*@FileTitle : Proposal & Amendment Creation - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.09 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
* 2015.04.02 송호진 [CHM-201535140] S/C Note conversion에 중복 체크 로직 수정요청 - validateDupCheck 상의 로직 오류 수정 
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
     * @class ESM_PRI_2103_01 : ESM_PRI_2103_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2103_01() {
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
	var amendFlag = false; //AMEND, AMEND CANCEL을 번갈아가면서 작업할때 메세지창을 없애기 위함.

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
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
		
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_acceptall":
					if(validateForm(sheetObject2,formObject,MODIFY01)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY01);
					}
					break;
					
				case "btn_cancelall":
					if(validateForm(sheetObject2,formObject,MODIFY02)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY02);
					}
					break;
				
				case "btn_rowadd1":
					if(validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
					
				case "btn_rowadd2":
					if(validateForm(sheetObject2,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
					break;
		
				case "btn_delete1":
					if(validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
					
				case "btn_delete2":
					if(validateForm(sheetObject2,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
					break;
					
				case "btn_amend":
					if(validateForm(sheetObject2,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND01);
					}
					break;
					
				case "btn_amendcancel":
					if(validateForm(sheetObject2,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND02);
					}
					break;
					
				case "btn_accept":
					if(validateForm(sheetObject2,formObject,MODIFY03)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY03);
					}
					break;	
					
				case "btn_acceptcancel":
					if(validateForm(sheetObject2,formObject,MODIFY04)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY04);
					}
					break;	
					
					
				case "btn_copy":
					if(validateFormConversion(sheetObject3,formObject,COMMAND11)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND11);
					}
					break;
					
				case "btn_paste":
					if(validateFormConversion(sheetObject3,formObject,COMMAND12)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND12);
					}
					break;
					
				case "btn_rowadd3":
					if(validateFormConversion(sheetObject3,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
					}
					break;
					
				case "btn_rowcopy":
					if(validateFormConversion(sheetObject3,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
					}
					break;
					
				case "btn_delete3":
					if(validateFormConversion(sheetObject3,formObject,COMMAND13)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND13);
					}
					break;

			
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
		
		buttonControl();
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
					style.height = 119;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel.|Seq.|dp_seq|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq" +
							"|1|2|3|4";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtDataSeq, 		50, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq", 			true,	"",	dfNullInteger);
					InitDataProperty(0, cnt++ , dtData,     	700,   	daLeft,  	false,	"note_tit_nm",   	true,	"",	dfNone,	0,	true,	true, 30);

					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "src_info_cd");    
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "prc_prog_sts_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "dp_fix_flg");

                    InitDataValid(0, "note_tit_nm", vtEngOther, PRI_VALID_CHAR);  // 한글제외
                    AutoRowHeight = false;
                    WaitImageVisible = false;

				}
				break;

             case "sheet2":
 				with (sheetObj) {
					// 높이 설정
					style.height = 119;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel.|Seq.|Contents|EFF Date|EXP Date|Source|Status" +
									"|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtDataSeq, 		50, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,     	550,    daLeft,		false, 	"note_ctnt",   				true,	"",	dfNone, 	0, 		false, 		false, 50);
 					
 					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter, 	false,	"eff_dt",		  			false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter, 	false, 	"exp_dt",   	   			false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtCombo,     	80, 	daCenter, 	false, 	"src_info_cd", 				false,	"",	dfNone, 	0, 		false, 		false);
 					InitDataProperty(0, cnt++ , dtCombo,     	80,    daCenter, 	false, 	"prc_prog_sts_cd", 			false,	"",	dfNone, 	0, 		false,  	false);
					
 					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq", 					true,	"",	dfNullInteger);
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_ctnt_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_conv_mapg_id");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_conv_flg");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prev_note_conv_mapg_id");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "temp_note_conv_mapg_id"); //amend cancel 시 임시로 사용
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "bef_eff_dt");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "bef_exp_dt");
	                 					
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
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle = "|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
                     		"|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type" +
                     		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,     	40,   daCenter,  true,	"chk");
                     InitDataProperty(0, cnt++ , dtComboEdit,	   	50,   daCenter,  true,	"chg_rule_def_cd",			true,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEditFormat,	85,   daCenter,  true,	"eff_dt",  					true,	"",	dfDateYmd,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEditFormat,	85,   daCenter,  true,	"exp_dt",     				true,	"",	dfDateYmd, 		 	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,    		80,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,  	    	40,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,        	35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,         	75,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,      	2,     true,       true,	9);
                     InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,   		35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,  			40,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
                     InitDataProperty(0, cnt++ , dtPopupEdit,  		50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		90,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
                     InitDataProperty(0, cnt++ , dtCombo,			35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
                     
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtCombo,			150,  daCenter,  true,	"bkg_esvc_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	80,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     true,       true,	7);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
                     InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
                     InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
                     InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,   	 	55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
                     
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

                     /////////////////////////////////////////////////////////////////////////////////////////
                     //STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_cnt_cd");
                       
                     
                     InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");										
                     InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
                     InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);            
                     InitDataCombo(0, "bkg_prc_cgo_tp_cd", bkgPrcCgoTpCdComboText, bkgPrcCgoTpCdComboValue);
                     InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
                     InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
                     InitDataCombo(0, "bkg_hngr_bar_tp_cd", bkgHngrBarTpCdComboText, bkgHngrBarTpCdComboValue);            
                     InitDataCombo(0, "bkg_rat_ut_cd", bkgRatUtCdComboText, bkgRatUtCdComboValue);
                     InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);         
                     InitDataCombo(0, "bkg_esvc_tp_cd", bkgEsvcTpCdComboText, bkgEsvcTpCdComboValue);         
                     //InitDataCombo(0, "chg_rule_def_cd", chargeRuleCdComboText,chargeRuleCdComboValue);                    
                     //sChgCdVisiable = chargeRuleCdComboText;	//초기로딩값 세팅
                                     
                     InitDataValid(0, "chg_rule_def_cd", 			vtEngUpOnly);
                     InitDataValid(0, "bkg_imdg_clss_cd", 			vtNumericOther, "."); 
 					 InitDataValid(0, "bkg_cmdt_def_cd", 			vtEngUpOther, "1234567890");
 					 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					 InitDataValid(0, "bkg_por_def_cd", 			vtEngUpOther, "1234567890");
 					 InitDataValid(0, "bkg_pol_def_cd", 			vtEngUpOther, "1234567890");
 					 InitDataValid(0, "bkg_pod_def_cd", 			vtEngUpOther, "1234567890");
 					 InitDataValid(0, "bkg_del_def_cd", 			vtEngUpOther, "1234567890");
					 InitDataValid(0, "bkg_ts_port_def_cd", 		vtEngUpOther, "1234567890");
					 
					 InitDataValid(0, "bkg_slan_cd", 				vtEngUpOnly);
					 InitDataValid(0, "bkg_vvd_cd", 				vtEngUpOther, "1234567890");
					 InitDataValid(0, "bkg_yd_cd", 					vtEngUpOther, "1234567890"); // 영문대문자와 숫자만 입력
					 
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 CountPosition = 0;		// Total 숨김
			 		 ImageList(0) = "img/btns_calendar.gif";
			 		 PopupButtonImage(0, "eff_dt") = 0;
			 		 PopupButtonImage(0, "exp_dt") = 0;
	                 WaitImageVisible = false;
         		}
              	break;

         }
     }

	var isFiredNested = false;
	var supressConfirm = false;
	/**
	 * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
    
        if (!isFiredNested && (OldRow != NewRow)) {
        	if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
            	&& (sheetObjects[0].IsDataModified)) {
            	isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                	isFiredNested = true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested = false;
                	}
                } else {
                	isFiredNested = true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
            }
            
            if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D" && (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified)) {
                isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    var rslt = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested = true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested = false;
                	}
                } else {
                    isFiredNested = true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                	return -1;
                }
            }
    
            if (sAction == IBINSERT) {
                isFiredNested = true;
                var idx = sheetObjects[0].DataInsert();
                isFiredNested = false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested = true;
                var idx = sheetObjects[0].DataCopy();
                isFiredNested = false;
                return idx;
            } else {
            	formObj.note_seq.value = sheetObjects[0].CellValue(NewRow, "note_seq");
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
            }
        }
    }
    
	/**
	 * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
        var adjNewRow = NewRow;
    
        if (!isFiredNested && (OldRow != NewRow) && !amendFlag) {
            if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D"
            	&& (sheetObjects[1].IsDataModified && sheetObjects[2].IsDataModified)) {
                isFiredNested = true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
               
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows);
                    rslt = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested = true;
	                    sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested = false;
                	}
                } else {
                    isFiredNested = true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                	return -1;
                }
            }
    
            if (sAction == IBINSERT) {
                isFiredNested = true;
                var idx = sheetObjects[1].DataInsert();
                isFiredNested = false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested = true;
                var idx = sheetObjects[1].DataCopy();
                isFiredNested = false;
                return idx;
            } else {
                LoadingComplete = false;
                formObj.note_seq.value = sheetObjects[1].CellValue(NewRow, "note_seq");
				formObj.note_ctnt_seq.value = sheetObjects[1].CellValue(NewRow, "note_ctnt_seq");
				formObj.note_conv_mapg_id.value = sheetObjects[1].CellValue(NewRow, "note_conv_mapg_id");
				doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC01);
                LoadingComplete = true;
            }
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
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested = true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (sheetD.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (sheetC.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetM.DataInsert();
				isFiredNested = false;
				return idx;
			} else {
				formObj.note_seq.value = sheetM.CellValue(adjNewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
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
				
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetD.IsDataModified && !amendFlag) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetM.DataInsert();
				isFiredNested = false;
				return idx;
			} else {
				formObj.note_seq.value = sheetM.CellValue(NewRow, "note_seq");
				formObj.note_ctnt_seq.value = sheetM.CellValue(NewRow, "note_ctnt_seq");
				formObj.note_conv_mapg_id.value = sheetM.CellValue(NewRow, "note_conv_mapg_id");
				doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
			}
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
	  			case IBCLEAR: // 화면 로딩시 
	  				//CODE
		 			initComboChargeRuleCode(sheetObj, formObj); 				
	  				break;
	  			
	  			case IBSEARCH: // 조회
	  				ComOpenWait(true);
		  			for (var i = 0; i < sheetObjects.length; i++) {
						sheetObjects[i].RemoveAll();
					}
	
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2003_01GS.do" , FormQueryString(formObj));
	  				break;
	  				
	  			case IBSEARCHAPPEND: // 조회
	  				ComOpenWait(true);
	  				formObj.f_cmd.value = SEARCH02;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
	  				sheetObj.LoadSearchXml(sXml);
	  				break;
	  				
	  			case IBSEARCH_ASYNC01: // 조회
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			
		 			////////////////////////////////////////////////////////////////////////////////	
		 			formObj.f_cmd.value = SEARCH13;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");			
					
					if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
					}
				
					sheetObj.LoadSearchXml(sXml);
					break;
	  		
	  			case IBSAVE: // 저장  	
					if(!validateForm(sheetObjects[0],formObj,IBSAVE)) {
						return false;
					}
										
	  				if (!supressConfirm && !ComPriConfirmSave()) {
	  					return false;
	  				}

	  				ComOpenWait(true);
	  			    ////////////////////////////////////////////////////////////////////////////////////
	  			    // AMEND 가 존재하는 데이터는 DP_SEQ를 변경하지 않는다. - 계약서상의 순서가 변경되면 안됨.
	  			    var amdtSeq = formObj.amdt_seq.value;
	  			    var tRow = sheetObjects[0].FindStatusRow("I|D");
	  			    var tStatus = tRow.split(";");
	  			    if(tStatus.length-1 > 0) {
				    	//SEQ-1의 DP_SEQ MAX값 
		  			    formObj.f_cmd.value = SEARCH03;
		  				var sXml = "";
		  				
		  				for (var i = 0, n = 10 ; i < n ; i++) {
		  					sXml = sheetObj.GetSearchXml("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				
		  				var maxDpSeq = parseInt(ComGetEtcData(sXml,"TITLE_MAX_DP_SEQ"),10);

						for(var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
							if(sheetObjects[0].CellValue(i, "dp_fix_flg") != "Y" && sheetObjects[0].RowStatus(i) != "D") {
								maxDpSeq ++;
								sheetObjects[0].CellValue2(i, "dp_seq") = maxDpSeq;
							}
			  			}
	  			    }
	  			    
	  			    var cRow = sheetObjects[1].FindStatusRow("I|D");
				    var cStatus = cRow.split(";");
				    if(cStatus.length-1 > 0) {
				    	//SEQ-1의 DP_SEQ MAX값 
		  			    formObj.f_cmd.value = SEARCH04;
		  			    formObj.note_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_seq");

		  			    var sXml = "";
		  				
		  				for (var i = 0, n = 10 ; i < n ; i++) {
		  					sXml = sheetObj.GetSearchXml("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				
		  				var maxDtlDpSeq = parseInt(ComGetEtcData(sXml,"CONTENT_MAX_DP_SEQ"),10);
						
						for(var i = sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow; i++) {
							if(sheetObjects[1].CellValue(i, "prev_note_conv_mapg_id") == "" && sheetObjects[1].RowStatus(i) != "D") {
								maxDtlDpSeq ++;
								sheetObjects[1].CellValue2(i, "dp_seq") = maxDtlDpSeq;
							}
			  			}
				    }
				    /////////////////////////////////////////////////////////////////////////////////////
	
	  				formObj.f_cmd.value = MULTI01;
	  				var sParam = FormQueryString(formObj);
	  				
	  				var sParamSheet1 = sheetObjects[0].GetSaveString();
	  				if (sParamSheet1 != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
	  				var sParamSheet2 = sheetObjects[1].GetSaveString();
	  				if (sParamSheet2 != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	  				}
	  				var sParamSheet3 = sheetObjects[2].GetSaveString();
	  				if (sParamSheet3 != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	  				}
	  				
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_01GS.do", sParam);
	  				//LoadSaveXml의 순서를 거꾸로 해야 한다. - DELETE저장시 문제발생함.
	  				sheetObjects[2].LoadSaveXml(sXml);
	  				sXml = ComDeleteMsg(sXml);
	  				sheetObjects[1].LoadSaveXml(sXml);
	  				sXml = ComDeleteMsg(sXml);
	  				sheetObjects[0].LoadSaveXml(sXml);
	  				formObj.master_del_chk.value = "N";
	  				formObj.amend_func.value = "";
	  				
	  				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
	  					return false;
	  				} else {
	  					return true;
	  				}
	  				
	  				break;
	  				
	  			case IBINSERT: // Row Add
	
					var eff_dt 		 = formObj.eff_dt.value;
					var exp_dt 		 = formObj.exp_dt.value;
					var amdt_seq 	 = formObj.amdt_seq.value;
				
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					//DELETE가 아니면 N처리
					formObj.master_del_chk.value = "N";
					
					if (sheetObj.id == "sheet1") {
						var idx = doRowChange1(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
	
						if (idx < 0) {
							return false;
						}
						sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
						sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
						sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObj.CellValue2(idx, "note_seq") = parseInt(ComPriGetMax(sheetObj, "note_seq")) + 1;
						sheetObj.CellValue2(idx, "note_tp_cd") = formObj.note_tp_cd.value;
						sheetObj.SelectCell(idx, "note_tit_nm");
						
						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
						
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();		
				
					}
					
					if (sheetObj.id == "sheet2") {
							                
						if(sheetObjects[0].RowCount==0){
							ComShowCodeMessage("PRI01004");
							return;							
						}
						
						// insert Amend 중 Amend pair 사이에 끼어들게 되는 경우를 제외							
						if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!= amdt_seq ){	
							ComShowCodeMessage("PRI00313");
						 	return;
						}		
						
						var idx = doRowChange2(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
		                if (idx < 0) {
		                    return false;
		                }
											
						if(amdt_seq == 0){	
							sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
							sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
							sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
							sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
							sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;	
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							
							var note_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_seq");
							sheetObj.CellValue2(idx, "note_seq") = note_seq;
							sheetObj.CellValue2(idx, "note_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1;
							sheetObj.CellValue2(idx, "note_tp_cd") = formObj.note_tp_cd.value;
							sheetObj.CellValue2(idx, "note_conv_mapg_id") = getSYSGUID();
							
							sheetObj.SelectCell(idx, "note_ctnt");
							
							
							sheetObj.CellBackColor(idx,"note_ctnt") = sheetObj.RgbColor(255,255,255);
							
														
						}else{
							sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
							sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
							sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
							sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
							sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;	
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							
							var note_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_seq");
							sheetObj.CellValue2(idx, "note_seq") = note_seq;
							sheetObj.CellValue2(idx, "note_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1;
							sheetObj.CellValue2(idx, "note_tp_cd") = formObj.note_tp_cd.value;
							sheetObj.CellValue2(idx, "note_conv_mapg_id") = getSYSGUID();
							
							sheetObj.SelectCell(idx, "note_ctnt");
							
							sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
							sheetObj.CellBackColor(idx,"note_ctnt") = sheetObj.RgbColor(255,255,255);						
							
						}
						
						sheetObjects[2].RemoveAll();
						
						//MASTER 색상 변경
						manageMasterColor(sheetObjects[0], sheetObjects[1]);
										
				
						//Conversion 버튼 컨트롤
						sheetObjects[2].Editable = true;
						buttonControlConv();
						
	
		    			//하이라이트처리
						changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
						
					}
					
					/* CONVERSION - START */
					if (sheetObj.id == "sheet3") {
		
						var idx = sheetObj.DataInsert();	 			
			  			sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;						
						sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
						sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
						sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
						sheetObj.CellValue2(idx, "note_conv_mapg_id") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
						sheetObj.CellValue2(idx, "note_conv_tp_cd") = "P"; //Proposal Special Note
						sheetObj.CellValue2(idx, "note_conv_seq") = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;					
						sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
						
						//note_conv_flg 설정
						setNoteConvFlg(sheetObj);
											
						//Code 에 Default 값이 존재할경우 적용
						defaultColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
						//Editable를 세팅한다.
						disableColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
					}
					/* CONVERSION - END */
	  				break;
	  				
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}				
					var amdt_seq = formObj.amdt_seq.value;
					var eff_dt = formObj.eff_dt.value;
					
					// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					////////////////////////////////////////////////////
					
					if (sheetObj.id == "sheet1") {
						if(amdt_seq=="0"){
							if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}
							
				        	var delCnt = deleteRowCheck(sheetObj, "chk");
							if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}
							
						} else {
							
							for(var i=0;i < chkArr.length;i++){
								//MASTER에 src_info_cd가 NW가 아니면 AMEND데이터가 존재하는것임.
								//선택 ROW에 선을 긋고 빨간색 처리
								
								if(sheetObj.CellValue(chkArr[i], "src_info_cd") != "NW") {
									//DETAIL에서 AMEND처리시 변경될 컬럼들을 MASTER에 임시저장하고 서버에서 DETAIL에 적용한다.
									sheetObj.CellValue2(chkArr[i], "src_info_cd") = "AD";
									sheetObj.CellValue2(chkArr[i], "prc_prog_sts_cd") = "I";
									sheetObj.CellValue2(chkArr[i], "eff_dt") = eff_dt;
									////////////////////////////////////////////////////////
									//SHEET에서 삭제처리하지 않음.
									sheetObj.CellValue2(chkArr[i], "chk") = "0";
									sheetObj.RowStatus(chkArr[i]) = "U";
									////////////////////////////////////////////////////////
									sheetObj.CellFont("FontStrikethru", chkArr[i], 1, chkArr[i], sheetObj.LastCol)=true;
									sheetObj.CellFont("FontColor", chkArr[i], 1, chkArr[i], sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
								}
							}
							////////////////////////////////////////////////////////////////
							// AMEND된 데이터를 AMEND CANCE처리												
							sheetObjects[1].CheckAll2("chk") = "1";
							var chkArrDtl = ComPriSheetCheckedRows(sheetObjects[1], "chk");
							
							for(var i=0; chkArrDtl != null && i<chkArrDtl.length;i++){
						    	if(sheetObjects[1].CellValue(Number(chkArrDtl[i]),"n1st_cmnc_amdt_seq") == amdt_seq 
									&& (sheetObjects[1].CellValue(Number(chkArrDtl[i]),"src_info_cd") == "AM" )){
						    		
						    		//2009.09.28일변경- 이전 MAPPING ID에 해당하는 데이터를 가져와서 현재 AMDT_SEQ에 해당하는 MAPPING ID를 세팅한다.
			  						//1. CONVERSION의 데이터를 원복하기 위해서 임시로 MAPPING ID를 TEMP에 저장한다.
						    		sheetObjects[1].CellValue2(Number(chkArrDtl[i])-1, "temp_note_conv_mapg_id") = sheetObjects[1].CellValue(Number(chkArrDtl[i]), "note_conv_mapg_id");
						    		sheetObjects[1].CellValue2(Number(chkArrDtl[i])-1, "bef_eff_dt") = sheetObjects[1].CellValue(Number(chkArrDtl[i]), "bef_eff_dt");
						    		sheetObjects[1].CellValue2(Number(chkArrDtl[i])-1, "bef_exp_dt") = sheetObjects[1].CellValue(Number(chkArrDtl[i]), "bef_exp_dt");
			  						
			  						comSheetAmendCancelRow(sheetObjects[1],formObj,Number(chkArrDtl[i]),"M", "note_ctnt");
			  						
			  						sheetObjects[1].CellValue2(Number(chkArrDtl[i])-1, "note_conv_mapg_id") = sheetObjects[1].CellValue(Number(chkArrDtl[i])-1, "temp_note_conv_mapg_id");
			  						sheetObjects[1].CellEditable(Number(chkArrDtl[i])-1, "chk") = true;
			  					}
						    }
							
							
							sheetObjects[1].CheckAll2("chk") = "1";
							var chkArrDtl = ComPriSheetCheckedRows(sheetObjects[1], "chk");
							var sRow = 0;
						    for(var i=0;chkArrDtl != null && i<chkArrDtl.length;i++){
						    	amendFlag = true;
						    	if(sheetObjects[1].CellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
						    		//AMEND DELETE
									comSheetAmendRow(sheetObjects[1],formObj,Number(chkArrDtl[i])+sRow,"D","note_ctnt");
						    		sRow++;	
								} else if(sheetObjects[1].CellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")==amdt_seq 
									&& (sheetObjects[1].CellValue(Number(chkArrDtl[i])+sRow,"src_info_cd") == "AD" )) {								
									sheetObjects[1].CellValue2(Number(chkArrDtl[i])+Number(sRow), "chk") = "0";
								}
						    	amendFlag = false;
						    }

						    //나머지 삭제처리
						    deleteRowCheck(sheetObjects[1], "chk");
						    						    
						    //DELETE후에 다른ROW자동선택되도록 하기위함.
							if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}				
				        	var delCnt = deleteRowCheck(sheetObj, "chk");			        	
							if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}
						}
						
						//MASTER에서의 DELETE임을 체크하는 FLAG
						//서버단에서 UDPATE/DELETE시 사용됨.
						formObj.master_del_chk.value = "Y";
												
					} else if (sheetObj.id == "sheet2") {
						if(amdt_seq=="0"){
						    //DELETE후에 다른ROW자동선택되도록 하기위함.
							if (sheetObj.id == "sheet2" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[2].RemoveAll();
							}
						    						
				        	var delCnt = deleteRowCheck(sheetObj, "chk");
							if (delCnt > 0 && sheetObj.id == "sheet2" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[2].RemoveAll();
							}
						} else {
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq 
										||(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq &&
												(sheetObj.CellValue(chkArr[i],"src_info_cd") =="AM" || sheetObj.CellValue(chkArr[i],"src_info_cd")=="AD"))){
									ComShowCodeMessage("PRI00313");
									return;
								}
							}
		
							var sRow = 0;
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(Number(chkArr[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									amendFlag = true;
									//AMEND DELETE
									comSheetAmendRow(sheetObj,formObj,Number(chkArr[i])+sRow,"D","note_ctnt");
						    		sRow++;	
						    		amendFlag = false;
								}
							}
							
							//나머지 삭제처리
							//DELETE후에 다른ROW자동선택되도록 하기위함.
							if (sheetObj.id == "sheet2" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[2].RemoveAll();
							}
						    						
				        	var delCnt = deleteRowCheck(sheetObj, "chk");
							if (delCnt > 0 && sheetObj.id == "sheet2" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[2].RemoveAll();
							}
						}
						formObj.master_del_chk.value = "N";
					}
					

					//DETAIL의 모든 ROW를 삭제할경우 체크
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00020')){
			  				ComOpenWait(true);
			  				//MASTER에 체크되어 있는 데이터를 언체크한다.
							sheetObjects[0].CheckAll2("chk") = 0;
							sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "chk") = "1";
					    								
							if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
							
							var delCnt = deleteRowCheck(sheetObjects[0], "chk");

							if (delCnt > 0 && sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
							}
						}
					}
										
					//Conversion Delete 처리
					manageConvButton (sAction);
					//MASTER 색상 변경
					manageMasterColor(sheetObjects[0], sheetObjects[1]);
					
					break;
	  			  									
	  			case MODIFY01: // Accept All
		  			if(ComShowCodeConfirm("PRI01015")) {	  				
		  				var amdtSeq = formObj.amdt_seq.value;
		  				//현재 보이는 SHEET의 STATUS를 변경한다.
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "A", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "I|"+amdtSeq);

		  				ComOpenWait(true);
		  				formObj.f_cmd.value = MULTI02;
		  				var sParam = FormQueryString(formObj);
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_01GS.do", sParam);
		  				sheetObj.LoadSaveXml(sXml);		
					}
	  				break;
	  			
	  			case MODIFY02: // Cancel All
		  			if(ComShowCodeConfirm("PRI01010")) {
		  				var amdtSeq = formObj.amdt_seq.value;
		  				//현재 보이는 SHEET의 STATUS를 변경한다.
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "I", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "A|"+amdtSeq);

		  				ComOpenWait(true);
		  				formObj.f_cmd.value = MULTI03;
		  				var sParam = FormQueryString(formObj);
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_01GS.do", sParam);
		  				sheetObj.LoadSaveXml(sXml);	  
					}
	  				break;			
	
	  			case MODIFY03: // Accept
		  			if(ComShowCodeConfirm("PRI00008")) {
		  				formObj.f_cmd.value = MULTI04;
		  				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_01GS.do");
		  			}
	   				break;	
	  				
	  				
	  			case MODIFY04: // Accept Cancel
	  				if(ComShowCodeConfirm("PRI00009")) {	
	  					formObj.f_cmd.value = MULTI05;
		  				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_01GS.do");
	  				}
	  				break;			
	  				
	  			case COMMAND01: // Amend
	  			 	
	  				//변경된 CONVERSION데이터가 존재할 경우 저장후 AMEND를 진행해야 한다.
	  				//AMEND->AMEND CANCEL->AMEND 반복진행할 경우 오류발생:AMEND CANCEL경우 CONVERSION을 전체삭제후 조회해서 가져오기때문임.
	  				//기존에 CONV데이터가 존재하는 상태에서 다시 INSERT하는 경우가 발생하므로 에러발생함.
	  				if(sheetObjects[2].IsDataModified){
	  					if (ComShowCodeConfirm("PRI00006")) {
	  	                    supressConfirm = true;
	  	                    var rslt = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	  	                    supressConfirm = false;
	  	                    if(!rslt) {
	  	                    	return false;
	  	                    }
	  	                } else {
	  	                	return false;
	  	                }
	  				}

	  				//AMEND, AMEND CANCEL, DELETE를 번갈아가면서 작업할때 메세지창을 없애기 위함.-위의경우 제외
	  				amendFlag = true;
	  				  				
	  				ComOpenWait(true);
	  				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{
	  						var trueYN = comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","note_ctnt");
	  						if(trueYN) {
		  						//MASTER 색상 변경
		  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
		  						//Conversion Delete 처리
		  						manageConvButton (sAction);
	  						}
	  					}
	  				}else{
	  					var trueYN = comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M","note_ctnt");
	  					if(trueYN) {
							//MASTER 색상 변경
							manageMasterColor(sheetObjects[0], sheetObjects[1]);
							//Conversion Delete 처리
							manageConvButton (sAction);
	  					}
	  				}
	  				sheetObj.SelectCell(sheetObj.SelectRow, "note_ctnt", false);
	  				
	  				amendFlag = false;
	  				break;			
	  			
	  			case COMMAND02: // Amend Cancel
	  				amendFlag = true;
	  				ComOpenWait(true);
				
	  				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{
	  						//2009.09.28일변경- 이전 MAPPING ID에 해당하는 데이터를 가져와서 현재 AMDT_SEQ에 해당하는 MAPPING ID를 세팅한다.
	  						//1. CONVERSION의 데이터를 원복하기 위해서 임시로 MAPPING ID를 TEMP에 저장한다.
	  						var cStatus = sheetObj.RowStatus(sheetObj.SelectRow-1);
	  						sheetObj.CellValue2(sheetObj.SelectRow-1, "temp_note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "note_conv_mapg_id");
	  						sheetObj.CellValue2(sheetObj.SelectRow-1, "bef_eff_dt") = sheetObj.CellValue(sheetObj.SelectRow, "bef_eff_dt");
	  						sheetObj.CellValue2(sheetObj.SelectRow-1, "bef_exp_dt") = sheetObj.CellValue(sheetObj.SelectRow, "bef_exp_dt");
	  						sheetObj.RowStatus(sheetObj.SelectRow-1) = cStatus;
	  						
	  						//2. AMEND CANCEL 처리
	  						var trueYN = comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "note_ctnt");
	  						
	  						if(trueYN) {
		  						//MASTER 색상 변경
		  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
		  						
		  						//3. CONTENT의 MAPPING ID를 원복시킨다.
		  						sheetObj.CellValue2(sheetObj.SelectRow, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "temp_note_conv_mapg_id");
		  							  						
		  						//4. Conversion Delete & update
		  						manageConvButton (sAction);
		  						
								sheetObj.RowStatus(sheetObj.SelectRow) = "U";
	  						}
	  						
	  					
	  					}
	  				}else{ 
	  					//2009.09.28일변경- 이전 MAPPING ID에 해당하는 데이터를 가져와서 현재 AMDT_SEQ에 해당하는 MAPPING ID를 세팅한다.
						//CONVERSION의 데이터를 원복하기 위해서 임시로 MAPPING ID를 TEMP에 저장한다.
  						var cStatus = sheetObj.RowStatus(sheetObj.SelectRow-1);
						sheetObj.CellValue2(sheetObj.SelectRow-1, "temp_note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "note_conv_mapg_id");
						sheetObj.CellValue2(sheetObj.SelectRow-1, "bef_eff_dt") = sheetObj.CellValue(sheetObj.SelectRow, "bef_eff_dt");
						sheetObj.CellValue2(sheetObj.SelectRow-1, "bef_exp_dt") = sheetObj.CellValue(sheetObj.SelectRow, "bef_exp_dt");
  						sheetObj.RowStatus(sheetObj.SelectRow-1) = cStatus;
							
						var trueYN = comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "note_ctnt");
						
	  					if(trueYN) {
							//MASTER 색상 변경
							manageMasterColor(sheetObjects[0], sheetObjects[1]);						
							//CONTENT의 MAPPING ID를 원복시킨다.							
							sheetObj.CellValue2(sheetObj.SelectRow, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "temp_note_conv_mapg_id");
							
							//Conversion Delete & update
							manageConvButton (sAction);
							
							sheetObj.RowStatus(sheetObj.SelectRow) = "U";
	  					}
	  				}
	  				
	  				amendFlag = false;
	  				
	  				break;	
	  				
	  				
	  			case COMMAND11: //COPY
					var iCheckRow = sheetObj.FindCheckedRow("chk");
					//카피하시겠습니까?
					if((ComShowCodeConfirm("PRI00012")) ) {			
						if(iCheckRow != "") {
							comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
						}
						
		  				ComOpenWait(true);
						formObj.f_cmd.value = MULTI12;
						sheetObj.DoSave("ESM_PRI_2003_01GS.do", FormQueryString(formObj), -1, false);
						//sheetObj.CheckAll2("chk") = "0";
					}
					break;
					
	  			case COMMAND12: //PASTE			
					//붙여넣기 하시겠습니까?
					if((ComShowCodeConfirm("PRI00016")) ) {
		  				ComOpenWait(true);
						// NOTE CONVERSION RULE
						var sCd = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
						var sNm = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
			 			//////////////////////////////////////////////////////////////					
						formObj.f_cmd.value = SEARCH14;
						var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_01GS.do", FormQueryString(formObj));				
						var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd"); 
				      	
				      	if(arrData != null && arrData.length > 0) {
				      		//콤보리스트에 추가후 InitDataCombo 호출
				      		for(var i=0; i<arrData.length; i++){						
								if (sCd.indexOf(arrData[i][0]) < 0) {
									sCd += "|" + arrData[i][0];
									sNm += "|" + arrData[i][0];
								}
							}					
							sheetObj.InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
							//////////////////////////////////////						
				      		sheetObj.LoadSearchXml(sXml, true);
				      				    
				      		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
				      		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
				      		var arrRow = ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
				      		
				      		if(arrRow != null && arrRow.length > 0) {  
				      			
				      			for(var i=0; i<arrRow.length; i++) {
					      			sheetObj.RowStatus(arrRow[i]) 						= "I";
					      			sheetObj.CellValue2(arrRow[i], "note_conv_seq") 	= maxSeq + i;
					      			sheetObj.CellValue2(arrRow[i], "note_conv_mapg_id") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
					      			sheetObj.CellValue2(arrRow[i], "svc_scp_cd") 		= formObj.svc_scp_cd.value;
					      			sheetObj.CellValue2(arrRow[i], "prop_no") 			= formObj.prop_no.value;
									sheetObj.CellValue2(arrRow[i], "amdt_seq") 			= formObj.amdt_seq.value;
									
					      			sheetObj.CellValue2(arrRow[i], "note_conv_tp_cd") 	= "P"; //Proposal Special Note					
				      			}
				      		}
				      	} else {
				      		ComShowCodeMessage("PRI00328");
				      	}
					}
			      	
					break;
				
	  			case IBCOPYROW:
					copySheetData(sheetObj);
					break;
					
	  			case COMMAND13: // Delete
					var iCheckRow = sheetObj.FindCheckedRow("chk");
					if(iCheckRow == ""){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}
					iCheckRow = sheetObj.FindCheckedRow("chk");	
					
					if(iCheckRow != "") {
						deleteRowCheck(sheetObj, "chk");
					}
					
					//note_conv_flg 설정
					setNoteConvFlg(sheetObj);
					
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
     * 1. AMEND, AMEND CANCEL, DELETE 시에 MAPPING ID를 관리한다. <br>
     * 2. CONVERSION 버튼을 컨트롤한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {int} sAction 필수 Button Action
     * @return 없음
     * @author 최성민
     * @version 2009.06.22
     */ 
  	 function manageConvButton (sAction) {
  		var sheetObj = sheetObjects[1];
  		var formObj = document.form;
		var amdtSeq = formObj.amdt_seq.value;
		var effDt 	= formObj.eff_dt.value;
		var expDt 	= formObj.exp_dt.value;
		
		var ibFlag = sheetObj.RowStatus(sheetObj.SelectRow);
		
		//sAction
		formObj.amend_func.value = sAction;
		
		if(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") == amdtSeq) {
			
			if(sAction == COMMAND01 && amdtSeq == sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
				var cStatus = sheetObj.RowStatus(sheetObj.SelectRow-1);
				sheetObj.CellValue2(sheetObj.SelectRow-1, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow-1, "prev_note_conv_mapg_id");
				sheetObj.RowStatus(sheetObj.SelectRow-1) = cStatus;
				
				if(getValidRowCount(sheetObjects[2]) > 0) {
					for(var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {
						sheetObjects[2].RowEditable(i) = true;
						//AMEND REQUEST 할때 EFF_DT, EXP_DT 변경
						//1. conversion.eff_dt < amend.eff_dt -> amend.eff_dt로 변경
						//2. conversion.eff_dt > amend.eff_dt -> 그대로
						//3. conversion.eff_dt > amend.exp_dt -> 삭제	
						//4. conversion.exp_dt < amend.eff_dt -> 삭제
						
						if(sheetObjects[2].CellValue(i, "eff_dt") < effDt) {
							sheetObjects[2].CellValue2(i, "eff_dt") = effDt;
						} 

						if(sheetObjects[2].CellValue(i, "exp_dt") > expDt) {
							sheetObjects[2].CellValue2(i, "exp_dt") = expDt;
						}

						if(sheetObjects[2].CellValue(i, "eff_dt") > expDt) {
							sheetObjects[2].RowHidden(i)= true;
							sheetObjects[2].RowStatus(i)= "D";
						}
						
						if(sheetObjects[2].CellValue(i, "exp_dt") < effDt) {
							sheetObjects[2].RowHidden(i)= true;
							sheetObjects[2].RowStatus(i)= "D";
						}

						disableColumnValidation(sheetObjects[2], i, 2, sheetObjects[2].CellValue(i,"chg_rule_def_cd"));
						

				 		//Route 에서 State 코드일 경우 색상처리
				 		setStateColor(sheetObjects[2], i);
						
				 		//Rule Code 일 경우에는 색상을 지정
				 		//setChargeRuleColor(sheetObjects[2], i);
					}
				}
				
				ComBtnEnable("btn_copy");
				ComBtnEnable("btn_paste");
				ComBtnEnable("btn_rowadd3");
				ComBtnEnable("btn_rowcopy");
				ComBtnEnable("btn_delete3");
					
			} else if(sAction == COMMAND02 && amdtSeq != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
				sheetObjects[2].RemoveAll();
	  			
	 			// NOTE CONVERSION RULE
				var sCd = sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Code");
				var sNm = sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Text");
	 			
	 			////////////////////////////////////////////////////////////////////////////////	
				//이전 SEQ의 CONVERSION을 가져온다.
	 			formObj.f_cmd.value = SEARCH13;
	 			//이전 MAPPING ID
	 			formObj.note_conv_mapg_id.value = sheetObj.CellValue(sheetObj.SelectRow, "prev_note_conv_mapg_id");
				var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
				var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");			
				
				if (arrData != null && arrData.length > 0) {
					for(var i=0; i<arrData.length; i++){						
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}					
					sheetObjects[2].InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
				}			
				sheetObjects[2].LoadSearchXml(sXml);
				
				
				//CONTENT의 AMEND처리전  EFF_DT
				var oldEffDt = sheetObj.CellValue(sheetObj.SelectRow,"eff_dt");
				//CONTENT의 AMEND처리전  EXP_DT
				var oldExpDt = sheetObj.CellValue(sheetObj.SelectRow,"exp_dt");
				//이전 SEQ의 EFF_DT
				var befEffDt = sheetObj.CellValue(sheetObj.SelectRow,"bef_eff_dt");
				//이전 SEQ의 EXP_DT
				var befExpDt = sheetObj.CellValue(sheetObj.SelectRow,"bef_exp_dt");
				//현재 SEQ에 해당하는 CONVERSION를 삭제하기위하여 세팅
				formObj.note_ctnt_seq.value = sheetObj.CellValue(sheetObj.SelectRow, "note_ctnt_seq");
								
				if(getValidRowCount(sheetObjects[2]) > 0) {
					for(var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {

						sheetObjects[2].RowEditable(i) = false;
						sheetObjects[2].RowStatus(i)= "I";
						
						//MAPPING ID 현재것으로 교체
						//SEQ 현재것으로 교체
						//EFF_DT, EXP_DT 현재것으로 교체
						sheetObjects[2].CellValue2(i, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "temp_note_conv_mapg_id");
						sheetObjects[2].CellValue2(i, "amdt_seq") = sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq");
						
						//이전SEQ의 CONVERSION 로딩후 이전 SEQ의 EFF_DT 와 비교하여 같으면 CONTENT의 AMEND처리전  EFF_DT로변경
						if(sheetObjects[2].CellValue(i, "eff_dt") == befEffDt) {
							sheetObjects[2].CellValue2(i, "eff_dt") = oldEffDt;
						}
						//이전SEQ의 CONVERSION 로딩후 이전 SEQ의 EXP_DT 와 비교하여 같으면 CONTENT의 AMEND처리전  EXP_DT로변경
						if(sheetObjects[2].CellValue(i, "exp_dt") == befExpDt) {
							sheetObjects[2].CellValue2(i, "exp_dt") = oldExpDt;
						}
						/*
						//현재SEQ의 DURATION을 벗어나면 삭제
						if(sheetObjects[2].CellValue(i, "eff_dt") > oldExpDt) {
							sheetObjects[2].RowHidden(i)= true;
							sheetObjects[2].RowStatus(i)= "D";
						} 
						//현재SEQ의 DURATION을 벗어나면 삭제
						if(sheetObjects[2].CellValue(i, "exp_dt") < oldEffDt) {
							sheetObjects[2].RowHidden(i)= true;
							sheetObjects[2].RowStatus(i)= "D";
						} 
						 */
						if(sheetObjects[2].CellValue(i, "eff_dt") < oldEffDt) {
							sheetObjects[2].CellValue2(i, "eff_dt") = oldEffDt;
						} 

						if(sheetObjects[2].CellValue(i, "exp_dt") > oldExpDt) {
							sheetObjects[2].CellValue2(i, "exp_dt") = oldExpDt;
						}


				 		//Route 에서 State 코드일 경우 색상처리
				 		setStateColor(sheetObjects[2], i);
						
				 		//Rule Code 일 경우에는 색상을 지정
				 		//setChargeRuleColor(sheetObjects[2], i);
					}
				}
				
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
				
			}  else if(sAction == IBDELETE && amdtSeq == sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")
					&& (sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") == "AD")) {
				var cStatus = sheetObj.RowStatus(sheetObj.SelectRow-1);
				sheetObj.CellValue2(sheetObj.SelectRow-1, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow-1, "prev_note_conv_mapg_id");
				sheetObj.RowStatus(sheetObj.SelectRow-1) = cStatus;
				
				sheetObjects[2].RemoveAll();
				
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
				
			} else if(sAction == IBDELETE && amdtSeq != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
				//현재 SEQ에서 ADD한 CONTENT데이터를 삭제하면 ROW-1데이터가 선택되어 지는데 이때 처리하기 위해서 사용됨.
				for(var i = sheetObjects[2].HeaderRows; getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow; i++) {
					sheetObjects[2].RowEditable(i) = false;
					
			 		//Route 에서 State 코드일 경우 색상처리
			 		setStateColor(sheetObjects[2], i);
					
			 		//Rule Code 일 경우에는 색상을 지정
			 		//setChargeRuleColor(sheetObjects[2], i);
				}
				
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
			} else if(ibFlag == "D" ) {
				sheetObjects[2].RemoveAll();			
			}
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
		doRowChange1(OldRow, NewRow, OldCol, NewCol);
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

    	doRowChange2(OldRow, NewRow, OldCol, NewCol);
  	}
 
  /**
   * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
   * sheet1의 전체체크를 컨트롤한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
   * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
   * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
   * @return 없음
   * @author 최성민
   * @version 2009.05.19
   */ 	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
		}
	}
   /**
    * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
    * sheet2의 전체체크를 컨트롤한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */	
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
		}
	}
    /**
     * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
     * sheet3의 전체체크를 컨트롤한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 최성민
     * @version 2009.05.19
     */	
	function sheet3_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
		}
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
 	    var propStsCd = formObj.prop_sts_cd.value;
 	    
      	switch(colname)
      	{
      		case "note_ctnt":
	    		sheetObj.CellEditable(Row,"note_ctnt") = false;
	    	
	    		if(propStsCd == "I"){
		    		if (amdtSeq == 0){
		    			sheetObj.CellBackColor(Row,"note_ctnt") = sheetObj.RgbColor(255,255,255);
		    			readOnly = false; 	    			
		    		}
					else if(sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
						if (sheetObj.CellValue(Row , "src_info_cd") != "AD"){
							if (propStsCd =="I"){
								readOnly = false;
								sheetObj.CellBackColor(Row,"note_ctnt") = sheetObj.RgbColor(255,255,255);
							}else{
								readOnly = true;
								sheetObj.CellBackColor(Row,"note_ctnt") = -1;
							}						
						}else{// src_info_cd 가 AD이면 수정금지
							readOnly = true;
							sheetObj.CellBackColor(Row,"note_ctnt") = -1;
						}
					}else{
						readOnly = true;
						sheetObj.CellBackColor(Row,"note_ctnt") = -1;
					}
	    		} else {
	    			readOnly = true;
	    			sheetObj.CellBackColor(Row,"note_ctnt") = -1;
	    		}
	    		
	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 550);
	    		break;      	
      	}
	}  

 
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 최성민
     * @version 2009.06.22
     */ 		
   	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
    	 var formObj = document.form;

    	 //Main 의 Amendment Summary 관련 function
    	 parent.comUpdateProposalStatusSummary("32", formObj.svc_scp_cd.value);
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
	
		case IBSAVE: // 저장

			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
		
			if (sheetObjects[0].IsDataModified && ComTrim(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_tit_nm") == "")) {
				ComShowCodeMessage("PRI00316", "Title");
				return false;
			}

			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
				
					ComShowCodeMessage("PRI00319", "Special Note");
				return false;
			}

			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			
			if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			
			if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
				return false;
			}
			
			var rowM = ComPriAmendDupCheck(sheetObjects[0], "note_tit_nm", formObj.amdt_seq.value);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}			

			//CONTENT에서는 중복체크하지 않는다 로 변경. - S/C와 동일
			/*
			var dupRow = ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|note_ctnt", formObj.amdt_seq.value);
			if (dupRow >= 0) {
				sheetObjects[1].SelectRow = dupRow;
				ComShowCodeMessage("PRI00303", "Sheet2", dupRow);
				return false;
			}
			*/
			
			/* CONVERSION - START */
	     	var amdtSeq	= formObj.amdt_seq.value;
			if(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq")  == amdtSeq
					&& sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq")== amdtSeq) {
				if(!checkDuration(sheetObjects[2])) {
	   				return false;
	   			}
			}
			   			
   			//FOCUS가 ROW이동될때마다 체크하는 방식을 SAVE할때 체크하는걸로 수정 - 잘못된 데이터가 이행될 경우가 존재하기 때문임.
   			for(var i = sheetObjects[2].HeaderRows; getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow; i++) {
	  	 		//삭제데이터는 체크하지 않는다.
	  	 		if(sheetObjects[2].RowStatus(i) == "D") {
	  	 			continue;
	  	 		}
	  	 		
   				if(!checkMandatoryValidation(sheetObjects[2], i)) {
 					return false;
 				}
   			}
   			   			
   			
   			if (sheetObjects[2].IsDataModified ) {
				
				for(var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {	 			
		 			if(sheetObjects[2].CellValue(i, "bkg_vvd_cd") != ""  && sheetObjects[2].CellValue(i, "bkg_vvd_cd").length != 9 && sheetObjects[2].RowStatus(i) != "D") {
		 				sheetObjects[2].SelectCell(i, "bkg_vvd_cd");
		 				ComShowCodeMessage("PRI01065", "VVD", "9");
		 				return false;
		 			}
		 		}
				
				//중복체크
				if(!validateDupCheck(sheetObjects[2])) {
					 return false;
				}
			}

   			/* CONVERSION - END */
   			
						
			break;
			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			
			if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}

			if (sheetObj.id == "sheet3" && getValidRowCount(sheetObjects[1]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}
			
			break;
			
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 

			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			
			break;
						
		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}

  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;
			
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}

  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
			
			
		case MODIFY03: // Accept
		
			// 선택된 ROW 리스트/////////////////////////////////
			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
			
				if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
			
		case MODIFY04: // Accept cancel
			// 선택된 ROW 리스트/////////////////////////////////
			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
		
				if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
		
			
			
  		case COMMAND01: // Amend	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			
			break;
			
  		case COMMAND02: // Amend Cancel	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			
			break;
		}
		
		 return true;
	}
	 
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateFormConversion(sheetObj,document.form,IBSAVE)) {
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
 	function validateFormConversion(sheetObj, formObj, sAction) {
 		 
 		switch (sAction) { 		
	   		case IBCOPYROW:
	   			if(!checkDuration(sheetObj)) {
	   				return false;
	   			}
	   			
	   			if(sheetObj.RowCount > 0) {
	   				//mandatory check
	 				if(!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
	 					return false;
	 				}
	   			}
	 			break;
	 			
	   		case IBINSERT:
	   			if(sheetObj.RowCount > 0) {
	   				//mandatory check
	 				if(!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
	 					return false;
	 				}
	   			}
	 			break;	  			
	 	
	 		case COMMAND11:
	 			var iCheckRow = sheetObj.FindCheckedRow("chk");
	 			
	 			if(iCheckRow == "") {
	 				ComShowCodeMessage("PRI00327");
	 				return false;
	 			}	 							
	 			break;
	 			
	 		case COMMAND12:
	 							
	 			break;
	 			
	 		case COMMAND13:
				if (getValidRowCount(sheetObj) == 0) {
					return false;					
				}
				
	 			break;
 		}

 		return true;
 	}
 	 
  	/**
  	 * SHEET ROW 중복체크를 하는 FUNCTION <br>
  	 * 모든 항목이 같고 EFF_DT와 EXP_DT가 중첩이 발생할경우에 중복체크를 한다. <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * validateDupCheck(sheetObj)
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
  	 * @return boolean
  	 * @author 최성민
  	 * @version 2009.05.20
  	 */ 
  	function validateDupCheck(sheetObj) {
  		
  		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
			 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd" +
			 		"|bkg_slan_cd|bkg_vvd_cd|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd", false, true);
  		
  		if (rowM != "") {
 			// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
 			// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
 			var rowDupKeyList = rowM.split("|");
 			
 			//var rowDup = rowM.replace("|", ","); 			
 			//중복되는 모든ROW
 			//var rowArr = rowDup.split(",");
 			
 			var rowArr = rowDupKeyList[0].split(",");
 			var rowObj = rowDupKeyList[1].split(",");
 			
  			var dupValue = "";
  			var temValue = "";						
  			var firstEffDt = "";
  			var firstExpDt = "";						
  			var SecondEffDt = "";
  			var SecondExpDt = "";
 			var hrows = sheetObj.HeaderRows;
  			
  			for(var i=0; i<rowArr.length; i++) {
  				dupValue  = sheetObj.CellValue(rowArr[i], "chg_rule_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_rat_ut_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_imdg_clss_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_cmdt_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pod_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_del_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_por_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pol_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_slan_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_vvd_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_soc_flg");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_dir_call_flg");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_ts_port_def_cd");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_min_cgo_wgt");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_max_cgo_wgt");
  				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_hngr_bar_tp_cd");
  				
  				for(var j=0; j<rowObj.length; j++) {
  					temValue  = sheetObj.CellValue(rowObj[j], "chg_rule_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_rat_ut_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_prc_cgo_tp_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_imdg_clss_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_cmdt_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pod_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_del_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_por_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pol_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_slan_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_vvd_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_soc_flg");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_dir_call_flg");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_ts_port_def_cd");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_min_cgo_wgt");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_max_cgo_wgt");
  					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_hngr_bar_tp_cd");
  					
  					//if(i != j) {
	  					if(dupValue == temValue) {
	  						firstEffDt = sheetObj.CellValue(rowArr[i], "eff_dt");
	  						firstExpDt = sheetObj.CellValue(rowArr[i], "exp_dt");
	  						
	  						SecondEffDt = sheetObj.CellValue(rowObj[j], "eff_dt");
	  						SecondExpDt = sheetObj.CellValue(rowObj[j], "exp_dt");
	  						
	  						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	  							ComShowCodeMessage("PRI00303", "Sheet3", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	  						     return false;
	  			 			}
	  			 			
	  			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	  			 				ComShowCodeMessage("PRI00303", "Sheet3", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	  						     return false;
	  			 			}
	  						
	  					} //if
  					//} //if
  				} //for
  				
  			} //for
  			
  		} //if
  		
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
					
			buttonControl();

	        doActionIBSheet(sheetObjects[2],document.form,IBCLEAR);
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
		formObject.pre_amdt_seq.value = "";
		formObject.prop_sts_cd.value = "";
		formObject.eff_dt.value = "";
		formObject.exp_dt.value = "";			
		formObject.pre_exp_dt.value = "";
		formObject.req_usr_flg.value = "";
		formObject.apro_usr_flg.value = "";
		formObject.dur_dup_flg.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		buttonControl("CLEAR");
		
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
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
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
		var row_count = getValidRowCount(sheetD);
    	var formObj = document.form;
    	var amdt_seq = formObj.amdt_seq.value;
		
		//AMEND 지정
		var amend_check = false;
		//ALL AMEND DELETE
		var amend_delete_check = false;
		
		try {
  			if(row_count > 0){
  				
  				amend_delete_check = true;
  				
	  			for(var i=1 ; i <= row_count; i++){
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
	  			
	  			//하이라이트 처리
	  			changeSelectBackColor4Master(sheetObjects[0], formObj);
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
		formObj.amend_func.value = "";
			
		//DETAIL의 모든 로우의 SOURCE가 AD일경우 MASTER에 색처리
		for(var i=1; i<=sheetObj.RowCount; i++ ) {
			if(sheetObj.CellValue(i,"amdt_seq") > 0) {
				if(sheetObj.CellValue(i,"src_info_cd") == 'AD') {
					sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
					sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					//sheetObj.RowEditable(i) = false;
				} else if(sheetObj.CellValue(i,"src_info_cd") == 'AM' || sheetObj.CellValue(i,"src_info_cd") == 'NW') {
					sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				}					
			}				

			if(propStsCd != "I") {
				sheetObj.CellEditable(i,"note_tit_nm") = false;
			}
		}

		//하이라이트 처리
		changeSelectBackColor4Master(sheetObj, formObj);
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
		 var formObj = document.form;
		 var amdtSeq = formObj.amdt_seq.value;	     
		 manageCellEditable (sheetObj);
		 
		 //줄그어진 ROW가 존재할경우에 ROW+1을 선택하게 처리한다.
		 if(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != amdtSeq){
			 sheetObj.SelectCell(sheetObj.SelectRow+1, sheetObj.SelectCol);
		 }
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
 		if(errMsg == "") {
	 		var formObj = document.form;
	     	var amdtSeq	= formObj.amdt_seq.value;
	     	var propStsCd = formObj.prop_sts_cd.value;
	     		 	
	     	var n1stCmncAmdtSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq");
	     	
	     	for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {	
	     		if(propStsCd == "I" && n1stCmncAmdtSeq == amdtSeq ) {
	     			disableColumnValidation(sheetObj, i, 2, sheetObj.CellValue(i,"chg_rule_def_cd"));
	     		} else {
	     			sheetObj.RowEditable(i) = false;
	     		}
	     		
		 		//Route 에서 State 코드일 경우 색상처리
		 		setStateColor(sheetObj, i);
				
		 		//Rule Code 일 경우에는 색상을 지정
		 		//setChargeRuleColor(sheetObj, i);
	 		}
	     	// S/I 컬럼은 Scope을 TPW, ACW로 제한
	     	if(formObj.svc_scp_cd.value == 'TPW' || formObj.svc_scp_cd.value == 'ACW'){
	     		sheetObj.ColHidden("bkg_esvc_tp_cd") = false;
	     	}else{
	     		sheetObj.ColHidden("bkg_esvc_tp_cd") = true;
	     	}
			//버튼 컨트롤
			buttonControlConv();
			
 		}
 	}
 	 
 	 
   /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 최성민
    * @version 2009.06.25
    */  
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
    	var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		switch(colName)
    	{
			case "chg_rule_def_cd":		
				
				if (Value != null && Value != "" && Value.length == 3) {
					//DEFAULT 데이터처리
					defaultColumnValidation(sheetObj, Row, Col, Value);
					//컬럼 disable 처리
					disableColumnValidation(sheetObj, Row, Col, Value);
					
					var sCode = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
					var sText = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");

					if (sCode.indexOf(Value) < 0) {
						formObj.f_cmd.value = COMMAND09;
						sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
						
						var arrData = ComPriXml2Array(sXml, "cd|nm");
						if (arrData != null && arrData.length > 0) {
							sCode += "|" + Value;
							sText += "|" + Value;
							sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
							
							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
						} else {
							sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
						}
					}
					
					insertChargeRuleType(sheetObj, Row);
				} else {
					sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
				}

 				// Rule & Charge Code 색 구분
 				//setChargeRuleColor(sheetObj, Row);
				break;
				
				
			case "eff_dt":	
				var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
				var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
				
				if(sheetObj.CellValue(Row, "eff_dt") < effDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.CellValue2(Row, "eff_dt") = effDt;
					sheetObj.SelectCell(Row,"eff_dt");
				}
				
				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
					ComShowCodeMessage("PRI00306");
					sheetObj.CellValue2(Row, "eff_dt") = effDt;
					sheetObj.SelectCell(Row,"eff_dt");
				}
				break;
				
			case "exp_dt":	
				var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
				var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
				
				if(sheetObj.CellValue(Row, "exp_dt") > expDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.CellValue2(Row, "exp_dt") = expDt;
					sheetObj.SelectCell(Row,"exp_dt");
				}
				
				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
					ComShowCodeMessage("PRI00306");
					sheetObj.CellValue2(Row, "exp_dt") = expDt;
					sheetObj.SelectCell(Row,"exp_dt");
				}
				break;
				
			case "bkg_prc_cgo_tp_cd": 	
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				
				if(chgRuleDefCd == "APP"){
					if(Value != "DG") {
						ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
						sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") = "";
					}
				}
				
				if(Value == "DG") {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = true;
				} else {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = false;
					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
				}
				break;	
				
			case "bkg_cmdt_def_cd":	
				
				if (Value.length == 5) { //Group Commodity
					var propNo = formObj.prop_no.value;
					var amdtSeq = formObj.amdt_seq.value;
					var svcScpCd = formObj.svc_scp_cd.value;

					formObj.f_cmd.value = SEARCH10;
					formObj.cd.value = Value;
					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=rpscp");
					var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				
					if(arrData[1] != ""){
						sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") = Value;
						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = 'G';
					} else {
						sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
						sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
						sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
					}

				} else if (Value.length == 6) {
	    			formObj.f_cmd.value = SEARCH08;
	    			//COMMODITY CODE 앞에 '0'문자로 채움
	    			formObj.cd.value = ComLpad(Value, 6, "0");
	    			
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
 					if (arrData[1] != "") {
 						sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = Value;
 						//6자리일경우 COMMODITY CODE임
						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "C";
 					}else{
	  					sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = "";
	  					sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 					}
				} else {
					sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
					sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
				}
				
	    		break;
	    		
			case "bkg_por_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_por_def_cd") = arrData[0];
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_por_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_por_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_por_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_por_def_cd") = "";
  					sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_por_def_cd") ; 				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
	    		break;	
	    		
			case "bkg_pol_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_pol_def_cd") = arrData[0];
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_pol_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_pol_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_pol_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_pol_def_cd") = "";
  					sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_pol_def_cd");  				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
	    		break;	
	    		
			case "bkg_pod_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_pod_def_cd") = arrData[0];
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_pod_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_pod_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_pod_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_pod_def_cd") = "";
  					sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_pod_def_cd");  				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
	    		break;	
	    		
			case "bkg_del_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_del_def_cd") = arrData[0];
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_del_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_del_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_del_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_del_def_cd") = "";
  					sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_del_def_cd");  				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
	    		break;	
	    		
			case "rt_appl_tp_cd":	
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				var rtOpCd = 	sheetObj.CellValue(Row, "rt_op_cd");

				if(Value == "A" || Value == "F") {
 					sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 					sheetObj.CellValue2(Row, "curr_cd") 		= "USD";
 					sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
 					sheetObj.CellEditable(Row, "rt_op_cd")		= true;
					sheetObj.CellEditable(Row, "curr_cd")		= true;
					sheetObj.CellEditable(Row, "frt_rt_amt")	= true;
 				} else {
 					sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 					sheetObj.CellValue2(Row, "curr_cd") 		= "";
 					sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 					sheetObj.CellEditable(Row, "rt_op_cd")		= false;
 					sheetObj.CellEditable(Row, "curr_cd") 		= false;
 					sheetObj.CellEditable(Row, "frt_rt_amt")	= false;
 				}
 				
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 					&& chgRuleDefCd != "RAC" ) {
 		    		 					
 					if( Value == "F") {
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellEditable(Row, "rt_op_cd") 	= false;
 					}
 					
 					if( Value == "A") {
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellEditable(Row, "curr_cd") 	= false;
 					}
 					
 	    		} else if(chgRuleDefCd == "ADD" || chgRuleDefCd == "ARB") {
 	    			if (Value == "I" || Value == "A"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 	    				sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 						
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			} else if (Value == "S" || Value == "N"){
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 					} else {
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= true;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 						sheetObj.CellValue2(Row, "curr_cd") 	= "USD";
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
 					}
 	    		} else if(chgRuleDefCd == "NOT") {
 	    			if (Value != "I" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "I";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "APP") {
 	    			if (Value != "S" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 						sheetObj.CellValue2(Row, "curr_cd") 		= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "TYP") {
 	    			
 	    			if (Value == "A"){ 	    	    				
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 						sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 	    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 	    			} else if (Value == "N"){ 	    	    				
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 	    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
 	    			}
 	    		}
				
	    		break;
	    		
			case "rt_op_cd":
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				var rtApplTpCd = 	sheetObj.CellValue(Row, "rt_appl_tp_cd");
				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
										
					if( rtApplTpCd == "F") {
			    		if(Value == ">" || Value == "<" ) {
			    			ComShowCodeMessage("PRI00326");
			    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
			    			sheetObj.SelectCell(Row, "rt_op_cd");
			    		}
		    		}
				} else if(chgRuleDefCd == "RAR") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
				} else if(chgRuleDefCd == "RAP") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		} else if(chgRuleDefCd == "DOR") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		} else if(chgRuleDefCd == "TYP") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		}
	    		break;	
	    		    		    		
			case "bkg_ts_port_def_cd":	    		
	    		if (Value.length == 5){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = arrData[0];
						sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "L";
						 						
						//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
						sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
						
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_ts_port_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
	  					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
  					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");  	
  					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
	    		}
	    	
	    		sheetObj.CellBackColor(Row,"bkg_ts_port_def_cd") = 0;
	    		break;	
	    		
			case "bkg_dir_call_flg":
	    		if (Value == "Y"){
	    			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
	    			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
	    		} else {
	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
	    		}
	    		break;	
	    		
			case "bkg_slan_cd":
				if (Value.length == 3){
	    			formObj.f_cmd.value = COMMAND26;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_slan_cd") = arrData[0];
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_slan_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_slan_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_slan_cd");  				
	    		}
	    		break;
	    		
			case "bkg_vvd_cd":
				if (Value.length == 9){
					
					var vslCd 		= Value.substring(0,4);
					var skdVoyNo 	= Value.substring(4,8);
					var skdDirCd 	= Value.substring(8,9);
							
	    			var sParam = "f_cmd="+COMMAND27;
	    			sParam += "&cd="+vslCd;
	    			sParam += "&etc1="+skdVoyNo;
	    			sParam += "&etc2="+skdDirCd;
	  
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	
	  				if (arrData != null && arrData.length > 0) {
	  					sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= arrData[0];
						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= vslCd;
						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= skdVoyNo;
						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= skdDirCd;
						
  					}else{
						sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
  						sheetObj.SelectCell(Row, "bkg_vvd_cd");
	  					
  					}
	    		} else{	
	    			sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
					sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
					sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
					sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
	    			sheetObj.SelectCell(Row, "bkg_vvd_cd");	
 						
	    		}
	    		break;
	    		
			case "bkg_imdg_clss_cd":
				if (Value.length > 0){
	    			formObj.f_cmd.value = COMMAND30;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = arrData[0];
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_imdg_clss_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
  					sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");  				
	    		}
	    		break;
	    		
			case "curr_cd":
				var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
				if(chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD"){
	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
	 	    			
	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
	 					sheetObj.CellValue2(Row, "curr_cd") = "USD";
	 					sheetObj.SelectCell(Row, "curr_cd");
	 	    		}
				}
	    		break;
	    		
	    		
			case "bkg_yd_cd":
				checkTerminalCode(sheetObj, Row, Value);
	    		break;
    	}
		
	}
	
	 /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 달력 DIV를 호출한다. <br>
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
     function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var colname = sheetObj.ColSaveName(Col);
 	    var formObj = document.form;
 	    var pinkColor = sheetObj.RgbColor(255,192,203);
 	    
      	switch(colname)
      	{
  	    	case "eff_dt":
  	    		cal = new ComCalendarGrid();
  	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
  	    		break;
  	    	case "exp_dt":
  	    		cal = new ComCalendarGrid();
  	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
  	    		break;
  	    		
  	    	case "bkg_cmdt_def_cd":
  	    		var sUrl = "/hanjin/ESM_PRI_4027.do?"
  	   	    		sUrl += "commodity_cmd=CG";
  	   	    		sUrl += "&grp_cd="+PRI_RP_SCP;
  	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
  	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
  	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
  	   	    	
  	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
  	  			if (rtnVal != null){
  	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;	
  	  				//6자리일경우 COMMODITY CODE임
  	  				sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = rtnVal.tp;
  	  			}
  	  			break;
  	  			
  	    	case "bkg_por_def_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "bkg_por_def_cd") = rtnVal.cd;
	  				sheetObj.CellValue2(Row, "bkg_por_tp_cd") = rtnVal.tp;
	  				
	  				//State 일경우 배경에 분홍처리
	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_por_cnt_cd") = rtnVal.cnt_cd;
	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
	  				} else {
	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
	  				}
	  			}
  				break;
  				
  	    	case "bkg_pol_def_cd":
	  			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "bkg_pol_def_cd") = rtnVal.cd;
	  				sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = rtnVal.tp;
	  				//State 일경우 배경에 분홍처리
	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_pol_cnt_cd") = rtnVal.cnt_cd;
	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
	  				} else {
	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
	  				}
	  			}
  				break;
  				
  	    	case "bkg_pod_def_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "bkg_pod_def_cd") = rtnVal.cd;
	  				sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = rtnVal.tp;
	  				//State 일경우 배경에 분홍처리
	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_pod_cnt_cd") = rtnVal.cnt_cd;
	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
	  				} else {
	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
	  				}
	  			}
  				break;
  				
  	    	case "bkg_del_def_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "bkg_del_def_cd") = rtnVal.cd;
	  				sheetObj.CellValue2(Row, "bkg_del_tp_cd") = rtnVal.tp;
	  				//State 일경우 배경에 분홍처리
	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_del_cnt_cd") = rtnVal.cnt_cd;
	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
	  				} else {
	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
	  				}
	  			}
  				break;
  				  				
  	    	case "bkg_ts_port_def_cd":	
  				var sUrl = "/hanjin/ESM_PRI_4026.do?";
  				var sParam = "&location_cmd=L";
  					
  				var rtnVal = ComPriOpenWindowCenter(sUrl+sParam, "ESM_PRI_4026",700, 325, true);
  				if (rtnVal != null){
  					sheetObj.CellValue2(Row, Col) = rtnVal.cd;
  					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = rtnVal.tp;			
  				}
  				break;	
  				
  	    	case "bkg_slan_cd":	
  				var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);
  					
  				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
  				if (rtnVal != null){
  					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
  				}
  				break;		
  				
  	    	case "bkg_vvd_cd":	
  				var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);
  					
  				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
  				if (rtnVal != null){
  					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
  					sheetObj.SelectCell(Row, Col);
  				}
  				break;
  				
  	    	case "bkg_yd_cd":
  				var bkgYdCd = sheetObj.CellValue(Row, Col);
  				var display = '0,0,1,1,1,1,1,1,1,1,1,1';
  				var param = '?mode=yard&node_cd='+bkgYdCd;
  				//공통사용 팝업 호출
  				ComPriOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'callBackTerminalCode', display, true);
  				break;
  			   
      	}    	 

     } 
     
 	/**
 	 * Terminal Code 조회 popup 화면이 닫힐때 호출되는 function <br>
 	 * popup에서 내려받은 코드를 보여준다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {String} locTp 필수 location 구분코드(사용않음)
 	 * @param {array} rArray 코드값 array
 	 * @return 없음
 	 * @author 최성민
 	 * @version 2010.04.23
 	 */
 	function callBackTerminalCode(rowArray){
 		 var colArray = rowArray[0];
 	     if(rowArray != null) {
 	    	 sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "bkg_yd_cd") = colArray[3];
 	     } else {
 	    	 sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "bkg_yd_cd") = "";
 	     }
 	}
 	
	/**
     * bkg_yd_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTerminalCode(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 최성민
     * @version 2010.04.23
     */ 
	function checkTerminalCode(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		var formObj = document.form;
		if (Value.length == 7) {
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObjects[0].GetSearchXml("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
			var arrDesc = ComPriXml2Array(sXml, "yd_cd");
			
			if(arrDesc == null || arrDesc.length < 1) {
				sheetObj.CellValue2(Row, "bkg_yd_cd") = "";
			}
		} else {
			sheetObj.CellValue2(Row, "bkg_yd_cd") = "";
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
    		     		 
    		 if(amdtSeq > 0) {  		 
       		  	// AMDT_SEQ가 다르면 DISABLE
       		  	if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq){ 
       		  		sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
       		  		sheetObj.RowEditable(i) = false;
       		  	}
       		  	
       		  	if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq){
       		  		sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
					sheetObj.CellBackColor(i,"note_ctnt") = sheetObj.RgbColor(255,255,255);
       		  	} else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq){
					sheetObj.CellBackColor(i,"note_ctnt") = -1;
       		  	}
    		 } else {
    			 sheetObj.CellBackColor(i,"note_ctnt") = sheetObj.RgbColor(255,255,255);
    		 }
    		 
    		 if(propStsCd != "I") {
    			 sheetObj.CellBackColor(i,"note_ctnt") = -1;
    		 }
    	 }
     }
  
 
  	  /**
      * RULE CODE와 SURCHARGE코드로 CODE COMBO를 구현하는  function <br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 form Object
      * @return 없음
      * @author 최성민
      * @version 2009.07.02
      */
	function initComboChargeRuleCode(sheetObj, formObj) {
		// NOTE CONVERSION RULE
		var sCd = "";
		var sNm = "";
		formObj.f_cmd.value = COMMAND19;
		//계약 유형(etc1)  	- S: S/C - R: RFA
		var tXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=R&etc2=P");
		var arrData = ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
			
		    var arrCode = arrData[0].split("|");
		    var arrName = arrData[1].split("|");
		    var conData = "";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i] = arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData = conData.concat(arrName[i]);
		    }
		
		    arrData[1] = conData;
		}
						
		if (arrData != null){
			sCd = " |" + arrData[0];
			sNm = " |" + arrData[1];			        
		} else {
			sCd = " |";
			sNm = " |";
		}
		////////////////////////////////////////////////////////////////
		// SURCHARGE
		formObj.f_cmd.value = COMMAND12;
		tXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
		arrData = ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
		    var arrCode = arrData[0].split("|");
		    var arrName = arrData[1].split("|");
		    var conData = "";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i] = arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData = conData.concat(arrName[i]);
		    }
		
		    arrData[1] = conData;
		}
		
		
		if (arrData != null){
			sCd += (" |" + arrData[0]);
			sNm += (" |" + arrData[1]);			        
		}
		
		sChgCdVisiable = sNm;
		sheetObj.InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
	}
	

 
 	/**
 	 * ROUTE의 항목에 데이터 입력시 해당하는 ROUTE의 TYPE CODE를 세팅하는 FUNCTION <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} Len 필수 이벤트가 발생한 해당 셀의 Value Length
 	 * @return 없음
 	 * @author 최성민
 	 * @version 2009.07.15
 	 */ 
    function getLocationTypeCode(sheetObj, Row, Col, Len) {
    	var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		switch(colName)
    	{
			case "bkg_por_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "G";
		    	}
		    	break;
		    	
			case "bkg_pol_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "G";
		    	} 
		    	break;

			case "bkg_pod_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "G";
		    	} 
		    	break;
		    	
			case "bkg_del_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "G";
		    	} 
		    	break;		    
    	}
    	
    }

	/**
	 * Duration 의 Validation function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 최성민
	 * @version 2009.07.15
	 */ 
    function checkDuration(sheetObj) {
		var formObj = document.form;
		var rowCount = getValidRowCount(sheetObj);
		var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
		if(rowCount > 0){
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
 				if (sheetObj.RowStatus(i) == "D") {
					continue;
				}
 				
				if(sheetObj.CellValue(i, "eff_dt") < effDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.CellValue2(i, "eff_dt") = effDt;
					sheetObj.SelectCell(i, "eff_dt");
					return false;
				}
				
				if(sheetObj.CellValue(i, "eff_dt") > sheetObj.CellValue(i, "exp_dt") ){
					ComShowCodeMessage("PRI00306");
					sheetObj.CellValue2(i, "eff_dt") = effDt;
					sheetObj.CellValue2(i, "exp_dt") = expDt;
					sheetObj.SelectCell(i, "eff_dt");
					return false;
				}
				
				if(sheetObj.CellValue(i, "exp_dt") > expDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.CellValue2(i, "exp_dt") = expDt;
					sheetObj.SelectCell(i, "exp_dt");
					return false;
				}
			}
		}
		
		return true;
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
	      

	      
      /**
       * CODE항목 선택시 CODE값에 따라 수정가능한 항목을 체크하는 function <br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
       * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
       * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */           
      function disableColumnValidation(sheetObj, Row, Col, Value) {
    	
    	initColumnEditable(sheetObj, Row, Col, Value);
    	
 		switch(Value)
     	{
     		case "APP":	
     			sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= false;
     			//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= false;
     			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
     			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= false;
     			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= false;
				break;
				
     		case "NOT":	
     			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
				break;
					
     		case "RAS":	
     			
     			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
				break;
					
 			case "ARB":	
 				//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;

				if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				}
 				break;
 				
 			case "ADD":
 				//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;

				if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				}
 				break;
 				
 			case "TYP":
 				//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;				
 				break;
 				
 			case "RAR":
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				break;
 				
 			case "RAP":
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				break;
 				
 			case "DOR":
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;				
 				break;
 				
 			default:  //SURCHARGE 												
		    	if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
				}
 				break;
     	}
  	}
       
       /**
        * SHEET에 보이는 항목들을 EDITABLE 초기화하는 function <br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditable(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
        * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
        * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
        * @return 없음
        * @author 최성민
        * @version 2009.07.02
        */           
       function initColumnEditable(sheetObj, Row, Col, Value) {    	   
    	   	sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= true;
	   	   	sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= true;
	   	   	sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= true;
				
	   	   	if(sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
	   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd")		= true;
	   	   	} else {
	   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") 		= false;
	   	   	}
			sheetObj.CellEditable(Row, "rt_op_cd") 					= true;
			sheetObj.CellEditable(Row, "curr_cd") 					= true;
			sheetObj.CellEditable(Row, "frt_rt_amt") 				= true;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= true;
			
			sheetObj.CellEditable(Row, "bkg_slan_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_vvd_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_soc_flg") 				= true;
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 		= true;
			
			if(sheetObj.CellValue(Row, "bkg_ts_port_def_cd") != "") {
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= false;
			} else {
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= true;
			}
			
			if(sheetObj.CellValue(Row, "bkg_dir_call_flg") == "Y") {
				sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= false;
			} else {
				sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= true;
			}			
			
			sheetObj.CellEditable(Row, "bkg_yd_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_esvc_tp_cd") 			= true;
			
   	}

    /**
     * CODE항목 선택시 CODE TYPE에 따라 필수 컬럼을 체크하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	checkMandatoryValidation(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */ 	
  	function checkMandatoryValidation(sheetObj, Row) {
  		var rowCount = sheetObj.RowCount; 		
  		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");

 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
 			
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
 	 	 	//} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
 					//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 필수입력항목 지정.(7/21)
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") { 			
	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
	 			// BKG SOURCE부분의 PER를 필수 입력 항목 변경 요청 - 2009.11.09
				if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			}
 		} else if (chgRuleDefCd == "APP") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "NOT") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}  			
 		} else if (chgRuleDefCd == "RAS") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001) {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "ARB") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ADD") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "TYP") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "" && sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00325","Per","Cargo Type");
 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAR") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_por_def_cd") == "" && sheetObj.CellValue(Row, "bkg_pol_def_cd") == "" 
 				 && sheetObj.CellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.CellValue(Row, "bkg_del_def_cd") == "") {
 				//POR, POL,POD,DEL중 1개이상 입력 				 				
 				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
 				sheetObj.SelectCell(Row, "bkg_por_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAP") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_cmdt_def_cd") == "") {
 				ComShowCodeMessage("PRI00316","Commodity");
 				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "DOR") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			}
 		} 

 		return true;
  	}
  	
     /**
      * CODE항목 선택시 CODE TYPE에 따라 컬럼항목 DEFAULT 처리하는 function <br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	defaultColumnValidation(sheetObj, Row, Col, Value);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
      * @return 없음
      * @author 최성민
      * @version 2009.07.02
      */ 	
  	function defaultColumnValidation(sheetObj, Row, Col, Value) {
 	 	
    	initColumnValue(sheetObj, Row);
    	  
 		switch(Value)
     	{	
 			case "TYP":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 		= "D4";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "A";
 				break;
 				
 			case "NOT":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "I";			
 				break;
 			
 			case "RAS":
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "RAR":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "RAP":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "DOR":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "ARB":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
 			case "ADD":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
 			default:
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
     	}
  	}
      
  /**
   * 데이터를 초기화하는 function <br>
   * 
   * <br><b>Example :</b>
   * <pre>
   *	initColumnValue(sheetObj, Row);
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
   * @return 없음
   * @author 최성민
   * @version 2009.07.02
   */ 	
   	function initColumnValue(sheetObj, Row) {
  	 		
     	  sheetObj.CellValue2(Row, "rt_appl_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "rt_op_cd") 						= "";
     	  sheetObj.CellValue2(Row, "curr_cd") 						= "";
     	  sheetObj.CellValue2(Row, "frt_rt_amt") 					= "";
     	  sheetObj.CellValue2(Row, "pay_term_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_por_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_por_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pol_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pol_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pod_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pod_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_del_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_del_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_slan_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_vsl_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_skd_voy_no") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_skd_dir_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_soc_flg") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_dir_call_flg") 				= "";
     	 
     	  sheetObj.CellValue2(Row, "bkg_vvd_cd") 					= "";  
     	  
     	  sheetObj.CellValue2(Row, "bkg_hngr_bar_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_min_cgo_wgt") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_max_cgo_wgt") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_yd_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_esvc_tp_cd") 				= "";    	 
   	}
	
    /**
     * SHEET ROW를 멀티 복사하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copySheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2010.03.23
     */	
 	function copySheetData(sheetObj) {
	    
  		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
  		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
  		var sCheckRow = sheetObj.FindCheckedRow("chk");
		if(sCheckRow == ""){
			sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
		}
		sCheckRow = sheetObj.FindCheckedRow("chk");	
		
 		var aCheckArr = ComRtrim(sCheckRow, '|').split("|");
 		
 		if(aCheckArr != null && aCheckArr.length > 0) {
 			for(var i=aCheckArr.length-1; i>=0; i--) {
 				sheetObj.SelectRow = aCheckArr[i];
 				var idx = sheetObj.DataCopy();
      			sheetObj.CellValue2(idx, "note_conv_seq") 	= maxSeq;      	
      			sheetObj.CellValue2(idx, "chk") = 0;

      			// State 색 구분
      			setStateColor(sheetObj, idx);
      			// Rule & Charge Code 색 구분
      			//setChargeRuleColor(sheetObj, idx);
      			      			
      			maxSeq++;
 			}
 		}
 	}
 	
 	/**
      * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
      * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
      * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @return 없음
      * @author 최성민
      * @version 2009.07.02
      */	
 	function insertChargeRuleType(sheetObj, Row) {
 		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
 			
 			//CHARGE
 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
 		} else {
 			//RULE
 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
 		}
 	}

   	  /**
       * RULE CODE와 SURCHARGE코드로 CODE COMBO를 구현하는  function <br>
       * <br><b>Example :</b>
       * <pre>
       *	initComboChargeRuleCode(sheetObj, formObj);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 form Object
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */
	function initComboChargeRuleCode(sheetObj, formObj) {
		// NOTE CONVERSION RULE
		var sCd = "";
		var sNm = "";
		formObj.f_cmd.value = COMMAND19;
		//계약 유형(etc1)  	- S: S/C - R: RFA
		var tXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=R&etc2=P");
		var arrData = ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
			
		    var arrCode = arrData[0].split("|");
		    var arrName = arrData[1].split("|");
		    var conData = "";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i] = arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData = conData.concat(arrName[i]);
		    }
		
		    arrData[1] = conData;
		}
						
		if (arrData != null){
			sCd = " |" + arrData[0];
			sNm = " |" + arrData[1];			        
		} else {
			sCd = " |";
			sNm = " |";
		}
		////////////////////////////////////////////////////////////////
		// SURCHARGE
		formObj.f_cmd.value = COMMAND12;
		tXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
		arrData = ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
		    var arrCode = arrData[0].split("|");
		    var arrName = arrData[1].split("|");
		    var conData = "";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i] = arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData = conData.concat(arrName[i]);
		    }
		
		    arrData[1] = conData;
		}
		
		
		if (arrData != null){
			sCd += (" |" + arrData[0]);
			sNm += (" |" + arrData[1]);			        
		}
		
		sChgCdVisiable = sNm;
		sheetObj.InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
	}
       
  /**
    * SYS_GUID()값을 리턴하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param 없음
    * @return sValue EtcData
    * @author 최성민
    * @version 2009.08.13
    */       
    function getSYSGUID() {
    	var formObj = document.form;
    	formObj.f_cmd.value = COMMAND38;
		var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		var sValue = ComGetEtcData(sXml,"SYS_GUID");
		return sValue;
    }	
    
    /**
     * NOTE CONVERSION FLAG를 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2009.08.13
     */ 
    function setNoteConvFlg(sheetObj) {
    	var convFlg = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_flg");
    	var rowCount = getValidRowCount(sheetObj);
    	    	
    	if(rowCount > 0) {
    		if(convFlg == "N") {
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_flg") = "Y";
    		}
    	} else {
    		if(convFlg == "Y") {
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_flg") = "N";
    		}
    	}
    }
    	     
	/**
     * 버튼 권한 컨트롤 function <br>
     * 버튼을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl(mode)
     * </pre>
     * @param {string} mode 필수 사용자 권한이나 모드
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
  	function buttonControl(mode){
 		var formObj = document.form;
 		var req_usr_flg = formObj.req_usr_flg.value;
 		var apro_usr_flg = formObj.apro_usr_flg.value; 		
 		var amdt_seq = formObj.amdt_seq.value;
 		var sts = formObj.prop_sts_cd.value;
 		var row_cnt = sheetObjects[0].RowCount;
 		try{		
 				ComBtnDisable("btn_retrieve");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_acceptall");
				ComBtnDisable("btn_cancelall");
				ComBtnDisable("btn_rowadd1");
				ComBtnDisable("btn_delete1");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_delete2");
				hiddenButton("btn_amend");
				hiddenButton("btn_amendcancel");
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");

				if(mode == "CLEAR") {
					return;
				}
				
 			switch(sts) {
 				case 'I':   // Initial
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_rowadd1");
 						ComBtnEnable("btn_delete1");
 						ComBtnEnable("btn_rowadd2");
 						ComBtnEnable("btn_delete2");
 						ComBtnEnable("btn_amend");
 						ComBtnEnable("btn_amendcancel");
 						
 						if(amdt_seq > 0){
 							showButton("btn_amend");
 							showButton("btn_amendcancel");
 						}
 						
 						ComBtnEnable("btn_copy");
 						ComBtnEnable("btn_paste");
 						ComBtnEnable("btn_rowadd3");
 						ComBtnEnable("btn_rowcopy");
 						ComBtnEnable("btn_delete3");
 					}				
 					break;
 					
 				case 'Q':   // Requested
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg == "true" ){
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}
 					break;
 					
 				case 'R':   // Returned
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}				
 					break;
 					
 				case 'A':   // Approved
 	 				ComBtnEnable("btn_retrieve");
 				case 'F':   // Filed
 	 				ComBtnEnable("btn_retrieve");
 				case 'C':   // Cancled
 	 				ComBtnEnable("btn_retrieve");
 					break;		
 			}	
 			
 		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
 		}
 	}

     
     
 	/**
      * 버튼 권한 컨트롤 function <br>
      * 버튼을 제어한다. <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControlConv()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 최성민
      * @version 2009.04.17
      */
   	function buttonControlConv(){
  		var formObj = document.form;
  		var req_usr_flg = formObj.req_usr_flg.value;
  		var apro_usr_flg = formObj.apro_usr_flg.value; 
  		var sts = formObj.prop_sts_cd.value;
      	var amdtSeq	= formObj.amdt_seq.value;
      	
  		try{
  			switch(sts) {
  				case 'I':   // Initial
  					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
  						
  						if(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq") != amdtSeq 
  								|| (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq")  == amdtSeq
  										&& sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq")!= amdtSeq)) {
  								ComBtnDisable("btn_copy");
  								ComBtnDisable("btn_paste");
  								ComBtnDisable("btn_rowadd3");
  								ComBtnDisable("btn_rowcopy");
  								ComBtnDisable("btn_delete3");
  						} else {
  								ComBtnEnable("btn_copy");
  								ComBtnEnable("btn_paste");
  								ComBtnEnable("btn_rowadd3");
  								ComBtnEnable("btn_rowcopy");
  								ComBtnEnable("btn_delete3");
  						}
  					}				
  					break;  				
  			}	
  			
  		} catch (e) {
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
    
	/* 개발자 작업  끝 */