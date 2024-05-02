/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3516.js
*@FileTitle : Inland Rates History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.11.08 김민아
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
     * @extends
     * @class ESM_PRI_3516 : ESM_PRI_3516 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3516() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject         = setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo              = initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    }

   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김민아
     * @version 2010.10.27
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
					break;
					
	            case "btns_calendar": //달력버튼
	            	if(!document.getElementById(srcName).disabled){
		                var cal = new ComCalendar();                
		                cal.select(document.form.access_dt, 'yyyy-MM-dd');
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
	 * @author 김민아
	 * @version 2010.10.27
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 김민아
     * @version 2010.10.27
     */      
    function setComboObject(combo_obj){
	        comboObjects[comboCnt++] = combo_obj;
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
    * @author 김민아
    * @version 2010.10.27
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        
        //IBMultiCombo 데이터 셋팅
        //Tariff No
        ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
        document.form.tariff_cd.focus();
   	 	
        var formObj = document.form;
        if (formObj.trf_no.value != "") {//다른 화면에서 호출,Inland Rates Inquiry에서 조회
        	
        	comboObjects[0].Text = formObj.trf_pfx_cd.value + "-" + formObj.trf_no.value;
        	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
       }
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
     * @author 김민아
     * @version 2010.10.27
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		
     	switch(sheetID) {
         	case "sheet1":
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
                     Editable = true;
                     

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|"
                    	 		   + "Inland Rates Name";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	"trf_pfx_cd",			false,	"",	dfNone, 	0,     false,	false,	10);
                     InitDataProperty(0, cnt++ , dtHidden,	30,  	daCenter,	true,	"trf_no",  				false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	30,  	daCenter,	true,	"trf_inlnd_seq",		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	330,  	daLeft, 	true,	"trf_inlnd_nm",     	false,	"",	dfNone, 	0,     false,	false);
                     
                     HeadRowHeight = 28;
                     
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
                     Editable = true;
                     

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|"
                    	 		   + "Amend\nNo.|Effective\nDate|Expiration\nDate|Publish\nDate|Status|Request\nOffice|Creation\nStaff|Approval\nOffice|"
                    	 		   + "TRF_INLND_NM|CRE_DT|ATCH_FILE_ID|ATCH_FILE_NM|TRF_INLND_AMDT_TP_CD";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	"trf_pfx_cd",			false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	30,  	daCenter,	true,	"trf_no",  				false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	30,  	daCenter,	true,	"trf_inlnd_seq",		false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtData,	50,  	daCenter, 	true,	"amdt_seq",     		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	80,  	daCenter, 	true,	"eff_dt",     			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	80,  	daCenter, 	true,	"exp_dt",     			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	80,  	daCenter, 	true,	"pub_dt",  				false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,  	80,   	daCenter, 	true,	"trf_inlnd_sts_cd",    	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData, 	80,   	daCenter, 	true,	"rqst_ofc_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData, 	80,   	daCenter, 	true,	"cre_usr_id",      		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData, 	80,   	daCenter, 	true,	"apro_ofc_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,	30,  	daLeft, 	true,	"trf_inlnd_nm",     	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	30,  	daCenter, 	true,	"cre_dt",     			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	30,   	daCenter, 	true,	"atch_file_id",    		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	30,   	daCenter, 	true,	"atch_file_nm",    		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	0,   	daCenter, 	true,	"trf_inlnd_amdt_tp_cd",	false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataCombo(0, "trf_inlnd_sts_cd", trfInlndStsCdComboText, trfInlndStsCdComboValue);
                     InitDataCombo(0, "trf_inlnd_amdt_tp_cd", trfInlndAmdtTpCdComboText, trfInlndAmdtTpCdComboValue);
                     HeadRowHeight = 28;
                     
	                 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet3":	//download
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 25;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|File Name|Download|1|2|3|4|5|6";
//                     var HeadTitle = "|Download|1|2|3|4|5|6";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false, true);

					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,40,		daCenter,	false,		"ibflag");
					 InitDataProperty(0, cnt++ , dtHidden,     	50,    	daLeft,     false,      "atch_file_nm", false,    	"",	dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++ , dtImage,		20,		daCenter,	false,		"file_dn",		false,      "",	dfNone,	0,	false,	false);
										 
					 InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,		"file_path_url");
					 InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,		"atch_file_id");
					 InitDataProperty(0, cnt++ , dtHidden,	   	50,		daCenter,	false,		"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,		50,  	daCenter,	false,		"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,		50,  	daCenter,	false,		"trf_inlnd_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		50,  	daCenter,	false,		"amdt_seq");
					
					 ImageList(0)= "/hanjin/img/ico_attach.gif";
					 DataLinkMouse("file_dn") = true;
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet4":
         		with (sheetObj) {
                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 1, 100);

                    var HeadTitle1 = "| | | | | | | | | | | | |"
                    	           + "One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
                    
                    var HeadTitle2 = "Flag|Seq.|Loc.\nCode|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN<=|Weight\nMAX>=|Weight\nUnit|Type|Currency|"
                    	           + "Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,	40, daCenter,  	true,	"seq",                          false,  "", dfInteger);
					InitDataProperty(0, cnt++ , dtData,	  	70,	daCenter,	true,	"inlnd_rt_bse_loc_cd",			false,	"",	dfNone, 			0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		160,daLeft,		true,	"inlnd_rt_bse_loc_nm",			false,	"",	dfNone,				0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"inlnd_rt_bse_loc_zip_cd",		false,	"",	dfNone, 		 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_term_cd",  			false,	"",	dfNone, 		 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,   	70, daCenter, 	true,	"inlnd_rt_via_loc_cd", 			false,	"",	dfNone, 			0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,  	70, daCenter, 	true,	"prc_inlnd_rt_trsp_mod_cd",     false,	"",	dfNone, 			0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_min_lmt_wgt",     	false,	"",	dfNullFloat,	 	1,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_lmt_wgt",     		false,	"",	dfNullFloat,	 	1,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_lmt_wgt_ut_cd",		false,	"",	dfNone, 		 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"prc_cgo_tp_cd",     			false,	"",	dfNone, 		 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		70, daCenter,	true,	"curr_cd",     					false,	"",	dfNone, 		 	0,     false,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_one_wy_bx_rt_amt",		false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_one_wy_20ft_rt_amt",		false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_one_wy_40ft_rt_amt",		false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_one_wy_40ft_hc_rt_amt",	false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_one_wy_45ft_rt_amt",		false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_bx_rt_amt",     			false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_20ft_rt_amt",			false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_40ft_rt_amt",			false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_40ft_hc_rt_amt",			false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		40, daCenter, 	true,	"inlnd_45ft_rt_amt",			false,	"",	dfNullInteger,	 	0,     false,	false);
                    InitDataProperty(0, cnt++ , dtData,		200, daLeft, 	true,	"inlnd_rt_rmk",     			false,	"",	dfNone, 		 	0,     false,	false);
                    					 		 		 
	                 WaitImageVisible = false;
        		}
             	break;
              	
     	}
	}
	
    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김민아
     * @version 2010.10.27
     */        
    function initCombo(comboObj, comboNo) {

    	switch(comboObj.id) {     
	    	case "tariff_cd":
	            with(comboObj) {
	                DropHeight = 200;
	                MultiSelect = false;
	                MaxSelect = 1;
	                IMEMode = 0;
	                UseAutoComplete = true;
	                ValidChar(1, 3);
	                MaxLength = 8;
	            }
	            break;
        }
    }
    
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김민아
     * @version 2010.10.27
     */ 	    
     function initControl() {
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
//        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);                      
//        axon_event.addListenerFormat ('blur', 'obj_OnBlur', document.form);
        axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
        
     }
     
     /**
      * OnBeforeActivate   event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_activate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 김민아
      * @version 2010.10.27
      */   
      function obj_activate() {
          var formObj = document.form;
          var srcName = event.srcElement.getAttribute("name");
          ComClearSeparator (event.srcElement);
      }
     
     /**
      * Onbeforedeactivate  event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_deactivate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 김민아
      * @version 2010.10.27
      */   
      function obj_deactivate() {
          var formObj = document.form;
          var eleName = event.srcElement.name;
          
          switch(eleName){
              case "access_dt":
                  ComChkObjValid(event.srcElement);
                  break;     
          }
          
      }
      
      /**
       * OnKeyDown event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param 없음
       * @return 없음
       * @author 김민아
       * @version 2010.11.09
       */  
   	function obj_onKeydown(){
   		//Proposal No,S/C No. 에서 Enter key조회
   	 	var eleName = event.srcElement.name;
   	 	
   	 	if (eleName == "access_dt"){
   		 	var keyValue = null;
   			if(event == undefined || event == null) {
   		    	keyValue = 13;
   			}else{
   		    	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   		  	}
   		   	if (keyValue == 13){
   		    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
   * @author 김민아
   * @version 2010.10.27
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {
	 			case IBSEARCH: // 조회
	 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
	 					return false;
	                }
	 				
		 			formObj.f_cmd.value = SEARCHLIST01;
		 			var param = "f_cmd="             + formObj.f_cmd.value
		 					  + "&trf_pfx_cd="       + formObj.trf_pfx_cd.value
		 					  + "&trf_no="           + formObj.trf_no.value
		 					  + "&access_dt="        + formObj.access_dt.value;
//		 			alert(FormQueryString(formObj));
		 			ComOpenWait(true); //->waiting->start
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3516GS.do", FormQueryString(formObj));
	  				sheetObj.LoadSearchXml(sXml);
	  				
	  				ComOpenWait(false); //->waiting->End
	  				
//	  				sheetObjects[0].selectCell(1, 1);
	  				
	 				break;
	 				
				case IBSEARCH_ASYNC01: // Down Excel
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
				
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
     * @author 김민아
     * @version 2010.10.13
     */
 	function validateForm(sheetObj, formObj, sAction) {
 		
        if(!ComChkValid(document.form)){
        	return false;
        }

 		switch (sAction) {
 		case IBSEARCH: // 조회
			if (ComIsEmpty(comboObjects[0].Text)) {
				ComPriInputValueFailed("select","Tariff Code",comboObjects[0]);
				formObj.tariff_cd.focus();
				return false;
			}
			break;
 		}

 		return true;
 	}
 	
/////////////////////// Sheet Event (S) ///////////////////////
 	
 	/**
 	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
 	 * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.27
 	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;
		
		var inlndSeq = formObj.trf_inlnd_seq.value;
		formObj.trf_inlnd_seq.value = "";
		var findIdx  = sheetObj.findText("trf_inlnd_seq", inlndSeq);
		if(findIdx != -1) sheetObj.selectCell(findIdx, "trf_inlnd_seq");
		
		var selRow = sheetObj.selectRow;
		
		if (OldRow != selRow) {
			formObj.f_cmd.value = SEARCHLIST02;
			var param = "f_cmd="           + formObj.f_cmd.value
					  + "&trf_pfx_cd="     + sheetObj.cellValue(selRow, "trf_pfx_cd")
					  + "&trf_no="         + sheetObj.cellValue(selRow, "trf_no")
					  + "&trf_inlnd_seq="  + sheetObj.cellValue(selRow, "trf_inlnd_seq")
					  + "&access_dt="      + formObj.access_dt.value;
//			alert	(param);
			ComOpenWait(true); //->waiting->start
			var sXml = sheetObj.GetSearchXml("ESM_PRI_3516GS.do", param);
			sheetObjects[1].LoadSearchXml(sXml);
		}
		
		ComOpenWait(false); //->waiting->End
 	}
	
 	/**
 	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
 	 * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.27
 	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;
		var amdtSeq = formObj.amdt_seq.value;
		formObj.amdt_seq.value = "";
		var findIdx  = sheetObj.findText("amdt_seq", amdtSeq);
		if(findIdx != -1) sheetObj.selectRow = findIdx;
		
		var selRow = sheetObj.selectRow;
		
		if (OldRow != selRow) {	
			formObj.f_cmd.value = SEARCH01;
			var param = "f_cmd="           + formObj.f_cmd.value
					  + "&trf_pfx_cd="     + sheetObj.cellValue(selRow, "trf_pfx_cd")
					  + "&trf_no="         + sheetObj.cellValue(selRow, "trf_no")
					  + "&trf_inlnd_seq="  + sheetObj.cellValue(selRow, "trf_inlnd_seq")
					  + "&amdt_seq="       + sheetObj.cellValue(selRow, "amdt_seq")
                      + "&access_dt="      + formObj.access_dt.value;
//			alert	(param);
			ComOpenWait(true); //->waiting->start
			sheetObjects[2].RemoveAll();
			var sXml = sheetObj.GetSearchXml("ESM_PRI_3516GS.do", param);
			sheetObjects[3].LoadSearchXml(sXml);
		}
		
		ComOpenWait(false); //->waiting->End
//		sheetObj.selectCell(NewRow, 1);
 	}
	
    /**
     * 마우스가 Sheet 위에서 움직일 때 발생하는 Event function <br>
     * Sheet의 어떤 영역이든 마우스가 이동 중일 때 Event가 발생한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {Integer} Button 필수 마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {Long} X 필수 X 좌표
     * @param {Long} Y 필수 Y 좌표
     * @return 없음
     * @author 김민아
     * @version 2010.11.17
     */
	function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y)  {
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		if(Row == 1 && (Col == 1 || Col == 2)) {
			sheetObj.ToolTipText(Row, Col) = sheetObj.CellText(Row, "atch_file_nm");
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     * @return 없음
     * @author 김민아
     * @version 2010.11.17
     */
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		if(sheetObj.ColSaveName(Col)!="file_dn") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "atch_file_id");
		return;
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
 	 * @author 김민아
 	 * @version 2010.10.27
 	 */
 	function sheet4_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		var mainSheetObj = sheetObjects[1];
 		var selRow = mainSheetObj.selectRow;
 		
 		// sheet에 조회된 내용을 form Object에 셋팅한다.
 		
 		formObj.trf_inlnd_nm.value = mainSheetObj.CellValue(selRow, "trf_inlnd_nm");
 		formObj.amend_seq.value    = mainSheetObj.CellValue(selRow, "amdt_seq");
 		formObj.status.value       = mainSheetObj.CellValue(selRow, "trf_inlnd_sts_cd");
 			
 		formObj.cre_dt.value = ComGetMaskedValue(mainSheetObj.CellValue(selRow, "cre_dt"), "ymd");
 		formObj.eff_dt.value = ComGetMaskedValue(mainSheetObj.CellValue(selRow, "eff_dt"), "ymd");
 		formObj.exp_dt.value = ComGetMaskedValue(mainSheetObj.CellValue(selRow, "exp_dt"), "ymd");
 		formObj.pub_dt.value = ComGetMaskedValue(mainSheetObj.CellValue(selRow, "pub_dt"), "ymd");
 		
 		formObj.rqst_ofc_cd.value = mainSheetObj.CellValue(selRow, "rqst_ofc_cd");
 		formObj.cre_usr_id.value  = mainSheetObj.CellValue(selRow, "cre_usr_id");
 		formObj.apro_ofc_cd.value = mainSheetObj.CellValue(selRow, "apro_ofc_cd");
 		formObj.trf_inlnd_amdt_tp_cd.value = mainSheetObj.CellValue(selRow, "trf_inlnd_amdt_tp_cd");
//	 	formObj.attach_file.value = mainSheetObj.CellValue(selRow, "attach_file");
 		
 		comboValue2Text(formObj.status.value, formObj.trf_inlnd_amdt_tp_cd.value);
 		
		//Attach file 
		if(mainSheetObj.CellValue(selRow, "atch_file_id") != "") {
			//ComPriXml2Sheet(sheetObjects[1], sXml);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellValue2(1, "atch_file_nm") = mainSheetObj.CellValue(selRow, "atch_file_nm");
			sheetObjects[2].CellValue2(1, "atch_file_id") = mainSheetObj.CellValue(selRow, "atch_file_id");
			sheetObjects[2].CellValue2(1, "file_dn") = 0;
		} else {
			sheetObjects[2].RemoveAll();
		}
 		
 		//Sheet Head Title 셋팅 
 		if(mainSheetObj.RowCount > 0){
 			changeHeadTitle(mainSheetObj, sheetObj, true);
 		}else{
 			changeHeadTitle(mainSheetObj, sheetObj, false);
 		}
 	}
 	
/////////////////////// Sheet Event (E) ///////////////////////
 	
/////////////////////// Combo Event (S) ///////////////////////
 	
   	/**
   	 * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 		tariff_cd_OnChange(comboObj, code, text)
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.27
   	 */
   	function tariff_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
   			if (ComIsEmpty(comboObj.Text)) {
   				formObj.trf_pfx_cd.value = "";
   				formObj.trf_no.value = "";
   				formObj.tariff_nm.value = "";	    	   				
   			}else{
				var arr = code.split("-");
				formObj.trf_pfx_cd.value = arr[0];
				formObj.trf_no.value = arr[1];
				formObj.tariff_nm.value = comboObj.GetText(code, 1);
   			} 
		}
   	}
   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    tariff_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.27
   	 */   	
   	function tariff_cd_OnBlur(comboObj) {
   		
		var formObj = document.form;
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
	   		var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
			formObj.tariff_nm.value = comboObj.GetText(code, 1);
		}
   	}
   	
   	/**
   	 * OnKeyDown 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.27
   	 */
   	function tariff_cd_OnKeyDown(comboObj, KeyCode) {
   		var formObj = document.form;
   		if (KeyCode == 13){
   			if (comboObj.Index > 0){	
   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   			}
   		}
   	}
   	
/////////////////////// Combo Event (E) ///////////////////////
   	
     /**
      * Sheet의 Combo Value값과 Mapping되는 Text를 찾아 해당 form Object에 셋팅한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comboValue2Text()
      * </pre>
      * @param {String} Status Code 필수
      * @param {String} Amdt Type Code 필수
      * @return 없음
  	  * @author 김민아
  	  * @version 2010.11.09
      */ 
     function comboValue2Text(stsCd, amdtTp){
    	 var trfInlndStsCdValueArr    = trfInlndStsCdComboValue.split("|");
    	 var trfInlndStsCdTextArr     = trfInlndStsCdComboText.split("|");
    	 var trfInlndAmdtTpCdValueArr = trfInlndAmdtTpCdComboValue.split("|");
    	 var trfInlndAmdtTpCdTextArr  = trfInlndAmdtTpCdComboText.split("|");
    	 var formObj = document.form;
    	 var arrIdx  = 0;
    	 
    	 if(stsCd == "")  formObj.status.value = "";
    	 else {
        	 var stsCdLen = trfInlndStsCdValueArr.length;
        	 if(stsCdLen > 0){
        		 for(i=0 ; i<stsCdLen ; i++){
        			 if(stsCd == trfInlndStsCdValueArr[i]){
        				 arrIdx = i;
        			 }
        		 }
        		 formObj.status.value = trfInlndStsCdTextArr[arrIdx];
        	 }
    	 }
    	 
    	 arrIdx = 0;
    	 
    	 if(amdtTp == "") formObj.trf_inlnd_amdt_tp_cd.value = "";
    	 else {
        	 var amdtTpLen = trfInlndAmdtTpCdValueArr.length;
        	 if(amdtTpLen > 0){
        		 for(i=0 ; i<amdtTpLen ; i++){
        			 if(amdtTp == trfInlndAmdtTpCdValueArr[i]){
        				 arrIdx = i;
        			 }
        		 }
        		 formObj.trf_inlnd_amdt_tp_cd.value = trfInlndAmdtTpCdTextArr[arrIdx];
        	 }
    	 }
     }
     

 	/**
 	 * Sheet Head Title 셋팅한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param {int} sheetObj sheetObject
   	 * @author 김민아
   	 * @version 2010.11.08
 	 */
    function changeHeadTitle(mainSheetObj, sheetObj, flg) { 
    	
    	var title = "";
    	if(flg){
    		title = mainSheetObj.CellValue(mainSheetObj.SelectRow, "trf_pfx_cd") + "-"
    	          + mainSheetObj.Cellvalue(mainSheetObj.SelectRow, "trf_no")     + " "
    	          + document.form.tariff_nm.value                                   + " - "
    	          + mainSheetObj.Cellvalue(mainSheetObj.SelectRow, "trf_inlnd_nm");
    	}else{
    		title = " ";
    	}
    	
    	var HeadTitle1 = "|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"
			           + "One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
		
		var HeadTitle2 = "Flag|Seq.|Loc.\nCode|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN<=|Weight\nMAX>=|Weight\nUnit|Type|Currency|"
			           + "Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";
		
		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		sheetObj.InitHeadRow(0, HeadTitle1, true);
		sheetObj.InitHeadRow(1, HeadTitle2, true);
		
//		sheetObj.CellAlign(0, 1) = daLeft;
		
    }
    
	/* 개발자 작업  끝 */