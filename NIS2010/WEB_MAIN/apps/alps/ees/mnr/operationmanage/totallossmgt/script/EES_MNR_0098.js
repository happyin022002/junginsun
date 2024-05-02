/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0098.js
 *@FileTitle : Total Loss Collection & Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.28
 *@LastModifier : 박명신
 *@LastVersion : 1.0
 * 2009.09.28 박명신
 * 2009.11.01 YoungBueb Kwon
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.03.12 김영오 [CHM-201110723-01] Close Type, Close Date 두 개 항목에 대하여  로그인 오피스가 SELCON인 경우에만 활성화 처리 나머지 비활성화 처리  
 * 2011.06.09 김민수 [CHM-201111285-01] [MNR] Total Loss 의 하단 Grid 의 D.V Expense , 3rd Party , Disposal 만 존재하게 하고, Scrapping ,Insurance 탭과 Grid 삭제 요청
 * 2011.11.25 신혜정 [CHM-201114720-01] 1. CURR를 다른 통화로 변경 가능하도록 기능 추가(CRRR 옆 컬럼 Amount 가 변경가능하면, CURR도 변경가능하게.)
     								    2. SELCON office 권한을 NYCRA 에도 주도록 화면에 권한 추가
 * 2012.03.06 신혜정 [CHM-201216409] 1. 3rd Party 탭 invoice no drop list box 추가(조회결과 invoice no list로 생성)
                                     2. [CHNG INV No] 버튼 추가. 클릭시 invoice no 업데이트
                                     3. [Invoice Preview] 클릭시 invoice no 묶음단위 조회
 * 2012.03.14 신혜정 [CHM-201216780] 1. Disposal 탭 invoice no 항목(combo box) 추가
                                        - 조회결과 invoice no list로 생성, 
                                        - 중복 invoice no 는 1건으로 처리.
                                     2. [CHNG INV No] 버튼 추가. 클릭시 invoice no 업데이트. 
                                     3. [Invoice Preview] 클릭시 invoice no 묶음단위 조회   
 * 2012.04.17 신혜정 [CHM-201217356] 3rd Party 리스트내 SCAC Code 항목 추가
 *                                  [Confirm]시 Sub Reason 이 Trucker 일 경우 필수 항목 체크 
 * 2012.04.26 신혜정 [CHM-201217485] 3rd Party, disposal 탭에 [Row Add] 버튼 기능 추가   
 * 2012.05.02 신혜정 [CHM-201217379] Disposal 리스트내 buyer Code, buyer name 항목 추가                                 
 * 2012.05.14 신혜정 [CHM-201217883] Total Loss Collection & Inquiry 메인 그리드의 EQ Q'ty(D.V Expense, 3rd Party, Dispolal 해당)  정의 변경
 *                                   3rd Party 리스트에 row add 시 D.V Expense 탭 건수 체크                                    
 * 2012.06.26 김창헌 [CHM-201218561-01] 3rd Party 탭에서 SCAC Code를 입력 가능한 조건 추가
 * 2013.04.11 조경완 [CHM-201323976-01] ALPS-MNR-Total Loss- Collection-Total Loos Collection의 total loss history에서 remarks 입력 글자 수에 따라 줄 바꿈
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
 * @class EES_MNR_0098 : EES_MNR_0098 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0098() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var comboObjects = new Array(); 
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;
	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq = "";
	//History Seq 저장변수
	var historyMnrStsRefNo = "";
	var sSaveRtnXml = "";
	var nowLoad = 0;
	//현제 조회중인 정보
	var currTtlLssNo = "";
	var currTtlLssDtlSeq = "";

	//본사코드
	var HOOfc = "";
	var NYCRA = "NYCRA"; // AMERICA REGIONAL HEADQUARTERS (공통코드 조회 방식으로 조회는 의미가 없음.하드코딩과 동일)

	//메세지 표시용
	var actionType = "";
	//현재구동여부
	var nowLoad=0;

	// 로그인 유저의 Office 레벨 : HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴 (CoMnr.js에서
	// MnrOfficeLevel 함수에 의해 셋팅)
	var strMnrOfficeLevel = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];
		var sheetObject9 = sheetObjects[8];
		var sheetObject10 = sheetObjects[9];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn_period" :
						var cal = new ComCalendarFromTo();
						cal.select(formObject.in_st_dt,  formObject.in_end_dt,  'yyyy-MM-dd');
						break;

					case "btn_Retrieve":
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
						ComBtnDisable("btn_Excel_Down");
						break;

					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						ComBtnDisable("btn_Excel_Down");
						break;

					case "btn_Save":
						actionType = "IBSAVE";
						doActionIBSheet(sheetObject2,formObject,IBSAVE);
						break;

					case "btn_Complete":
						actionType = "COMPLETE";
						doActionIBSheet(sheetObject2,formObject,IBSAVE);
						break;

					case "btn_Delete":
						doActionIBSheet(sheetObject2,formObject,IBSEARCHAPPEND);
						break;

	                //멀티입력
					case "btn_ttl_lss_no_multi":
						rep_Multiful_inquiry("in_ttl_lss_no");
						break;

					//멀티입력
					case "eq_no_multi1":
						rep_Multiful_inquiry("in_rqst_eq_no");
						break;

					/** (Tab) D.V Expense (S) **/
					case "btn_t1RowAdd":
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
						break;
					case "btn_t1InvoicePreview":												
						break;
					case "btn_t1RowDel":
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
						break;
					/** (Tab) D.V Expense (E) **/

					/** (Tab) 3rd Party (S) **/
					case "btn_t2RowAdd":
						doActionIBSheet(sheetObject4,formObject,IBINSERT);
						break;
					case "btn_t2InvoicePreview":
						if(sheetObjects[3].RowCount>0)
						{
							var row=sheetObjects[3].SelectRow;
							var rdParam ='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
							    rdParam +=   'inv_no[' + sheetObjects[3].CellText(row,"inv_no") + '] ';
							    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
								rdParam +=   'payer_code[' + sheetObjects[3].CellValue(row,"payer_code") + '] ';
								rdParam +=   'curr_cd[' + sheetObjects[3].CellValue(row,"curr_cd") + '] ';
								rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
								rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
								if(formObject.rqst_ofc_cd.value.indexOf("PKGSC", 0) == 0){
									formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0188.mrd";
								}else{
									formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";		
								}
							formObject.com_mrdArguments.value =	rdParam;
							formObject.com_mrdBodyTitle.value = "Sale Invoice for Total Loss Equipment";
							var sFeatures = "resizable=yes,width=720,height=800"
							ComOpenRDPopup(sFeatures);
						}
						break;
					case "btn_t2RowDel":
						doActionIBSheet(sheetObject4,formObject,IBDELETE);
						break;
					case "btn_t2ChangeInvNo": 		
						actionType = "CHNGINV";
						doActionIBSheet(sheetObject4, formObject, IBSAVE); // [Chng Inv No] 버튼 클릭
						break;
					/** (Tab) 3rd Party (E) **/

					/** (Tab) Disposal (S) **/
					case "btn_t3RowAdd":
						doActionIBSheet(sheetObject5,formObject,IBINSERT);
						break;
					case "btn_t3InvoicePreview":
						if(sheetObjects[4].RowCount>0)
						{
							var row=sheetObjects[4].SelectRow;
							var rdParam ='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
							    rdParam +=   'inv_no[' + sheetObjects[4].CellText(row,"inv_no") + '] ';
							    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
								rdParam +=   'payer_code[' + sheetObjects[4].CellValue(row,"buyer_code") + '] ';
								rdParam +=   'curr_cd[' + sheetObjects[4].CellValue(row,"curr_cd") + '] ';
								rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
								rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
								if(formObject.rqst_ofc_cd.value.indexOf("PKGSC", 0) == 0){
									formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0188.mrd";
								}else{
									formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";		
								}
							formObject.com_mrdArguments.value =	rdParam;
							formObject.com_mrdBodyTitle.value = "Sale Invoice for Total Loss Equipment";
							var sFeatures = "resizable=yes,width=720,height=800"
							ComOpenRDPopup(sFeatures);
						}
						break;
					case "btn_t3RowDel":
						doActionIBSheet(sheetObject5,formObject,IBDELETE);
						break;
					case "btn_t3ChangeInvNo": 		
						actionType = "CHNGINV";
						doActionIBSheet(sheetObject5, formObject, IBSAVE); // [Chng Inv No] 버튼 클릭
						break;						
					/** (Tab) Disposal (E) **/

					/** (Tab) Scrapping (S) **/
					case "btn_t4RowAdd":
						doActionIBSheet(sheetObject6,formObject,IBINSERT);
						break;
					case "btn_t4InvoicePreview":
						break;
					case "btn_t4RowDel":
						doActionIBSheet(sheetObject6,formObject,IBDELETE);
						break;
					/** (Tab) Scrapping (E) **/

					/** (Tab) Insurance (S) **/
					case "btn_t5RowAdd":
						doActionIBSheet(sheetObject7,formObject,IBINSERT);
						break;
					case "btn_t5InvoicePreview":
						break;
					case "btn_t5RowDel":
						doActionIBSheet(sheetObject7,formObject,IBDELETE);
						break;
					/** (Tab) Insurance (E) **/


					case "btn_Col_Add":
						doActionIBSheet(sheetObject8,formObject,IBINSERT);
						break;

					case "btn_Col_Delete":
						doActionIBSheet(sheetObject8,formObject,IBDELETE);
						break;

					case "btn_RowAdd2":
						history_Insert(sheetObject9);
						break;

					case "btn_RowDel2":
						history_Remove(sheetObject9);
						break;

					case "btn_FileAdd":
						file_Insert(sheetObject10);
						break;

					case "btn_FileDel":
						file_Remove(sheetObject10);
						break;
					//RES Office. PopUp
					case "respb_ofc_cd_popup":
						if(formObject.ttl_lss_sts_cd.value !='HE' && formObject.respb_ofc_cd.readOnly == false)
						{
							if(MnrNullToBlank(formObject.search_ttl_lss_no.value) != ""){
								ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_COM_ENS_071', '1,0', true);
							}
						}
						break;
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);
    	nowLoad=1;

		// Office Level 조회 및 전역변수(strMnrOfficeLevel)에 세팅
		MnrOfficeLevel(currOfcCd, rhqOfcCd);

		//Axon이벤트 초기화
		initControl();

		//IBMultiCombo 초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }

    	// IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBTab 초기화
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }

		//파일업로드 초기화
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");
		//화면초기화
		
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    	
    	ComBtnDisable("btn_Excel_Down");
    	
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	    switch(comboNo) {
	    	case 1:
			case 2:
	    	case 3:
	    	case 4:
	            with (comboObj) {
			       SetColAlign("left");
				   DropHeight = 160;
		        }
	            break;
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

		switch(sheetID) {
			case "sheet1":
	            with (sheetObj) {
	            	
	                // 높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;

	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "||||||||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_no");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"rqst_ofc_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"rqst_dt");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_sts_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_rsn_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_dtl_rsn_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_dt");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"apro_ofc_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_dt");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"acc_flg");
					InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_vsl_cd");
					InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_skd_voy_no");
					InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_skd_dir_cd");
					InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_port_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"file_seq");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"mnr_sts_ref_no");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"respb_ofc_cd");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"respb_ofc_nm");
	                InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"ttl_lss_cfm_dt");

	                CountPosition = 0;
				}
	            break;
			case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 142;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);

					var HeadTitle1 = "|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible OFC|D.V Exnpense|D.V Exnpense|D.V Exnpense|D.V Exnpense|3rd Party|3rd Party|3rd Party|3rd Party|Disposal|Disposal|Disposal|Disposal|Scrapping|Scrapping|Insurance|Insurance|Accident DT|VVD|VVD|VVD|Port";
					var HeadTitle2 = "|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible OFC|EQ Q'ty|Expense|Recovery|Balance|EQ Q'ty|Curr.|Amount|AMT(USD)|EQ Q'ty|Curr.|Amount|AMT(USD)|EQ Q'ty|Amount|EQ Q'ty|Amount|Accident DT|Vessel|Voyage|Direction|Port";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++,  dtHiddenStatus,		 	0,      daCenter,  	false,  	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,       			30,    	daCenter,  	true,  		"Seq",     			false,  "",    	dfNone     );
                    InitDataProperty(0, cnt++ , dtData,					108,	daCenter,	true,		"ttl_lss_no",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					52,		daCenter,	true,		"rqst_ofc_cd",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					73,		daCenter,	true,		"cre_usr_id",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					64,		daCenter,	true,		"rqst_dt",			false,	"",		dfDateYmd,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,				100,	daCenter,	true,		"ttl_lss_sts_cd",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,				80,		daCenter,	true,		"ttl_lss_rsn_cd",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"ttl_lss_dtl_rsn_nm",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					64,		daCenter,	true,		"ttl_lss_dt",		false,	"",		dfDateYmd,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					52,		daCenter,	true,		"apro_ofc_cd",		false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"respb_ofc_cd",		false,	"",		dfNone,			0,	true,	true);

					//반복부
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"dv_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_exp",			false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_recovery",		false,	"|tp_exp|+|ds_exp|+|sc_exp|+|ir_exp|",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_balance",		false,	"|dv_recovery|-|dv_exp|",		dfFloat,		2,	false,	false);

					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"tp_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"tp_curr_cd",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"tp_exp",			false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"tp_usd_exp",			false,	"",		dfFloat,		2,	false,	false);

					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"ds_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"ds_curr_cd",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ds_exp",			false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ds_usd_exp",			false,	"",		dfFloat,		2,	false,	false);

					//히든 데이타로 변경
					InitDataProperty(0, cnt++ , dtHidden,				50,		daRight,	true,		"sc_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,				75,		daRight,	true,		"sc_exp",			false,	"",		dfFloat,		2,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,				50,		daRight,	true,		"ir_eq_qty",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,				75,		daRight,	true,		"ir_exp",			false,	"",		dfFloat,		2,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,				64,		daCenter,	true,		"acc_dt");
					InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,	true,		"acc_vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,	true,		"acc_skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,	true,		"acc_skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,	true,		"acc_port_cd");
					
					//히든 데이타
					InitDataProperty(0, cnt++ , dtHidden,   			0,		daCenter,  	false,   	"mnr_sts_ref_no",    false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   			0,		daCenter,  	false,   	"ttl_lss_dtl_rsn_cd",    false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   			0,		daCenter,  	false,   	"ttl_lss_rmk",    false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   			0,		daCenter,  	false,   	"file_seq",    false,      "",     	dfNone,    		0,      true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	true,		"ttl_lss_cfm_dt",		false,	"",		dfDateYmd,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	true,		"ttl_lss_cfm_id",		false,	"",		dfNone,			0,	false,	false);

                    InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,		true,		"acc_flg");
                    
					InitDataValid(0,  "respb_ofc_cd", vtEngUpOther,"0123456789");

					CountPosition = 0;

				}
                break;

            case "t1sheet1":	// D.V Expense
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Payer Code|Payer Name|Invoice No.|CURR|Pay Amount|Confirm Flg|EQ Status|Close Type|Close Date|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 23, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk",				false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true,	7);
                    InitDataProperty(0, cnt++ , dtData,			95,		daRight,	true,	"dpc_val_amt",			true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		true,	"lessor_nm",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		     85,	daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"payer_name",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			140,	daLeft,	    true,	"inv_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",				true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtCheckBox,		90,		daCenter,	true,	"ttl_lss_cfm_flg",		false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtCombo,		60,		daLeft,		true,	"ttl_lss_dtl_sts_cd",	false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		true,	"ttl_lss_cmpl_cd",		false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtPopupEditFormat,	85, daCenter,  	true,   "ttl_lss_cmpl_dt",     	false,   "", dfDateYmd,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true,	4000);

                    //Hidden
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	"ttl_lss_n3pty_tp_cd",	true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_cnt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"n3pty_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtHidden,		65,		daLeft,		true,	"bank_nm",				false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		65,		daLeft,		true,	"bank_acct_no",			false,	"",	dfNone,			0,	true,	true);
                	InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"respb_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"inv_rgst_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"pay_inv_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no",				false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"mnr_swift_no",			false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"usa_edi_cd",			true,	"",	dfNone,			0,	true,	true, 4);
					InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"buyer_code",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"buyer_name",			false,	"",	dfNone,			0,	false,	false);
					
                    //데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");

					PopupImage  =  "/hanjin/img/btns_calendar.gif";
            		ShowButtonImage = 2;

					MessageText("Sum") = "Total";
					CountPosition = 0;
				}
                break;

            case "t2sheet1":	// 3rd Party
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Sel.|Seq.|EQ Type|EQ No.|Invoice No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Responsible\nOFC|Payer Code|Payer Name|SCAC Code|CURR|3rd Amount|Issue Date|Bank Name|Bank Account|Swift Code|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk",				false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	true,	true,	14);
                    InitDataProperty(0, cnt++ , dtCombo,	    145,	daLeft,	    true,	"inv_no",				false,	"",	dfNone,			0,	true,	true,	20);                    
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true,	7);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"dpc_val_amt",			false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtCombo,		100,	daLeft,		true,	"ttl_lss_n3pty_tp_cd",	true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtPopupEdit,	85,		daCenter,	true,	"respb_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtPopup,		85,		daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"payer_name",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"usa_edi_cd",			true,	"",	dfNone,			0,	true,	true, 4);                    
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",				true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtPopupEditFormat,80, 	daCenter,  	true,   "ttl_lss_bil_dt",     	true,   "", dfDateYmd,		0,	true,	true);
					//InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"n3pty_no",				false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,			75,		daLeft,		true,	"bank_nm",				false,	"",	dfNone,			0,	true,	true,	50);
                    InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		true,	"bank_acct_no",			false,	"",	dfNone,			0,	true,	true,	30);
                    InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		true,	"mnr_swift_no",			false,	"",	dfNone,			0,	true,	true,	50);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true,	4000);
    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_cnt_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"disp_no",				false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_cd",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_dt",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"buyer_code",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"buyer_name",			false,	"",	dfNone,			0,	false,	false);

                    //데이터 Validation
    				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");
    				InitDataValid(0,  "respb_ofc_cd", vtEngUpOther,"0123456789");
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");
					InitDataValid(0,  "mnr_swift_no", vtEngUpOther,"0123456789-");
					InitDataValid(0,  "usa_edi_cd", vtEngUpOther,"0123456789");					

					ImageList(0) = "/hanjin/img/btns_search.gif";
  					ImageList(1) = "/hanjin/img/btns_calendar.gif";

					PopupButtonImage(0, "payer_code") = 0;
					PopupButtonImage(0, "ttl_lss_bil_dt") = 1;  					

					ShowButtonImage = 2;

					MessageText("Sum") = "Total";
					ColHidden("dpc_val_amt")=true;
					CountPosition = 0;
				}
                break;

            case "t3sheet1":	// Disposal
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Sel.|Seq.|EQ Type|EQ No.|Invoice No.|TP/SZ|Term|Yard|Buyer Code|Buyer Name|Disposal No.|CURR|Disposal AMT|Disposal Plan AMT|Remark(s)|Detail Sequence";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	true,	true,	14);
                    InitDataProperty(0, cnt++ , dtCombo,	    145,	daLeft,	    true,	"inv_no",			false,	"",	dfNone,			0,	true,	true,	20);                    
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true,	7);
                    InitDataProperty(0, cnt++ , dtPopup,		85,		daCenter,	true,	"buyer_code",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"buyer_name",			false,	"",	dfNone,			0,	false,	false);                    
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"disp_no",			false,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",			false,	"",	dfNone,			0,	true,	true);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,	true,	"ttl_lss_bil_amt",	false,	"",	dfNullFloat,	2,	false,	false,	13);
    				InitDataProperty(0, cnt++ , dtAutoSumEx,	120,	daRight,	true,	"ttl_lss_incm_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true,	4000);
    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"dpc_val_amt",			false,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_cd",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_dt",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"usa_edi_cd",			true,	"",	dfNone,			0,	true,	true, 4);

    				//데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");
					MessageText("Sum") = "Total";
					
					PopupImage  =  "img/btns_search.gif";
					ShowButtonImage = 2;
					
					CountPosition = 0;
				}
                break;

            case "t4sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true,	7);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",			true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"csr_no",			false,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,	160,	daRight,	true,	"ttl_lss_incm_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	150,	daRight,	true,	"ttl_lss_expn_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true,	4000);

                    //Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",			false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"dpc_val_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",		false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",	false,	"",	dfNone,			0,	true,	true,	20);
    				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"ttl_lss_bil_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",	false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_cd",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_dt",			false,	"",	dfNone,			0,	false,	false);

					//데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");
					MessageText("Sum") = "Total";
					CountPosition = 0;
				}
                break;

            case "t5sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Notification Date|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"del_chk",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			40,	daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtCombo,		70,	daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,	daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	false,	false,	14);
                    InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true,	7);
                    InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"dpc_val_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"inv_no",			true,	"",	dfNone,			0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtCombo,		50,	daCenter,	true,	"curr_cd",			true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtCombo,		90,	daCenter,	true,	"ttl_lss_plc_nm",	false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0, cnt++ , dtAutoSumEx,	95,	daRight,	true,	"ttl_lss_expn_amt",	true,	"",	dfNullFloat,	2,	true,	true,	13);
    				InitDataProperty(0, cnt++ , dtPopupEdit,	115,daCenter,	true,	"cr_end_dt",	    false,	"",	dfDateYmd,		0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			50,	daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true,	4000);
                    //Hidden
                    InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		false,	"ttl_lss_no");
                    InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		false,	"ttl_lss_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		false,	"mnr_inv_tp_cd");
    				InitDataProperty(0, cnt++ , dtHidden,		90,	daCenter,	false,	"csr_no");
					InitDataProperty(0, cnt++ , dtHidden,		130,daLeft,		false,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_cd",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"ttl_lss_cmpl_dt",			false,	"",	dfNone,			0,	false,	false);

					//데이터 Validation
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");
					MessageText("Sum") = "Total";
					ColHidden("dpc_val_amt")=true;
					PopupImage  =  "img/btns_calendar.gif";
					ShowButtonImage = 2;
					CountPosition = 0;
				}
                break;

			case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Sel.|Seq.|Type|Date|Curr.|Amount|Pay Method|CSR No.|Check No.|Inv No.|EQ No|Evidence No.|Remark(s)|Detail Sequence|CLT Sequence";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,		0,	daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,			40,	daCenter,	true,	"del_chk",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,				30,	daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtData,				50, daCenter,  	true,   "type",     			false,  "", dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtPopupEditFormat,	82, daCenter,  	true,   "clt_dt",     			false,  "", dfDateYmd,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtCombo,			50,	daCenter,	true,	"curr_cd",				false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				75,	daRight,	true,	"clt_amt",				true,	"",	dfFloat,	2,	true,	true,	13);
                    InitDataProperty(0, cnt++ , dtCombo,			80,	daLeft,		true,	"inv_pay_mzd_cd",		false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"csr_no",				false,	"",	dfNone,		0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,		0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"inv_no",				false,	"",	dfNone,		0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"rqst_eq_no",			false,	"",	dfNone,		0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	true,	"evidence",				false,	"",	dfNone,		0,	true,	true,	20);
                    InitDataProperty(0, cnt++ , dtData,				100,daLeft,		true,	"ttl_lss_clt_rmk",		false,	"",	dfNone,		0,	true,	true,	4000);
                    //Hidden
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"ttl_lss_no");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"ttl_lss_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"ttl_lss_clt_seq ");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"clt_stl_flg");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"clt_ofc_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		true,	"chk_trns_no");
					//데이터 Validation
					InitDataValid(0,  "ar_chk_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "csr_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");

					CountPosition = 0;

					PopupImage  =  "/hanjin/img/btns_calendar.gif";
            		ShowButtonImage = 2;

					//SELECT 로우 배경색
					SelectionMode = smSelectionRow;
					SelectHighLight = false;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					EditableColorDiff = true;
				}
                break;

			case "sheet4":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

            		var HeadTitle1 = "|Sel|Date|Remark(s)|Creation Office|Creation User";
    				var headCount = ComCountHeadTitle(HeadTitle1);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount + 3, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false,false)

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);

    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
    				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",		false,	"",	dfNone,		0,	true,	true);
    				InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	"mnr_sts_dt",	false,	"",	dfDateYmd,	0,	true,	true);
    				InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,	"mnr_sts_rmk",	false,	"",	dfNone,		0,	true,	true,	4000);
    				InitDataProperty(0, cnt++ , dtData,     	100,	daCenter,	true,	"rqst_ofc_cd",	false,	"",	dfNone,  	0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	true,	"cre_usr_id",	false,	"",	dfNone,		0,	false,	false);

    				//Hidden
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_ref_no");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_dtl_seq");
    				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_grp_tp_cd");

                    PopupImage = "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 2;
					CountPosition = 0;
				}
                break;

			case "sheet5":
                with (sheetObj) {
					var prefix = "";

					// 높이 설정
					style.height = 122;
					// 전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					SheetWidth = 280;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 13, 100);

					var HeadTitle1 = "|Evidence Attached|Evidence Attached|Evidence Attached";
					var HeadTitle2 = "|Sel|File|Download";

					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	120,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);

					CountPosition = 0;

                    ImageList(0)= "/hanjin/img/ico_attach.gif";

					ShowButtonImage = 1;
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
                    InsertTab( cnt++ , "D.V Expense", -1 );
                    InsertTab( cnt++ , "3rd Party", -1 );
                    InsertTab( cnt++ , "Disposal", -1 );
//                    InsertTab( cnt++ , "Scrapping", -1 );
//                    InsertTab( cnt++ , "Insurance", -1 );
                }
                break;
         }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    }

	/**
	 * IBUpload Object 기본설정
	*/
	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = "";
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
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	*/
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
	}

	/**
	 * (Office Code) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setPopUpParam_Sheet2_COM_ENS_071(array) {

		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
	    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=arr[3];
		if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != ""){
			formObj.respb_ofc_cd.value=arr[3];
			formObj.respb_ofc_nm.value=arr[4];
		}

	}
	/**
	 * (Office Code) Pop-up Return Value의 Input Box 처리 부분<br>
	 * @param {array} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setPopUpParam_COM_ENS_071(array) {

		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");

		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];
	    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=formObj.respb_ofc_cd.value;
	}

	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}

	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }

	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;

			case "engup":
	         	if(obj.name == "in_ttl_lss_no" || obj.name == "in_rqst_eq_no"){
					ComKeyOnlyAlphabet('uppernum','45|44');
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change()
	{
		ComChkObjValid(event.srcElement);
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" )
		{
			switch(obj.name)
			{
			case "respb_ofc_cd":
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;
			}
		}
	}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
		var sheetObj = sheetObjects[nItem + 2];
		if((sheetObj.RowCount - sheetObj.RowCount("D")) > 0){
			var Row = sheetObj.SelectRow;
			var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
			currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");
			currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
			var newSeq = 1;
			for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
				with(sheetObjects[7]){
					if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
						sheetObjects[7].CellValue2(x,"seq") = newSeq++;
						sheetObjects[7].RowHidden(x) = false;
					} else {
						sheetObjects[7].RowHidden(x) = true;
					}
				}
			}
		} else {
			for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
				sheetObjects[7].RowHidden(x) = true;
			}
			currTtlLssNo = "";
			currTtlLssDtlSeq = "";
		}

		if(nItem==0)
		{
			ComBtnDisable("btn_t" + (nItem + 1) + "InvoicePreview");
		}else{
			ComBtnEnable("btn_t" + (nItem + 1) + "InvoicePreview");
		}
		
		// [Chng Inv No] 버튼은 3rd Party, Disposal 탭에서만 활성.
		if(nItem == 1 || nItem == 2){
			ComBtnEnable("btn_t" + (nItem +1) + "ChangeInvNo");
		}else{
			ComBtnDisable("btn_t" + (nItem +1) + "ChangeInvNo");
		}
		
    	if(document.form.ttl_lss_sts_cd.value=="HE") //상태가 Complete면
    	{
			ComBtnDisable("btn_Col_Add");
			ComBtnDisable("btn_Col_Delete");
    	}else{
    		if(nItem==0) //DV 탭이 선택될경우
    		{
    			ComBtnDisable("btn_Col_Add");
    			ComBtnDisable("btn_Col_Delete");
    		}else{
    			ComBtnEnable("btn_Col_Add");
    			ComBtnEnable("btn_Col_Delete");
    		}
    	}

    }

	/**
	 * 조회후 Header 값 설정 및 형식 변경
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		//Header 값 설정
	    var Row = sheetObj.FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);

	    if(Row >0)
	    {
	    	sheetObj.SelectRow=Row;
	    }else{
	    	return false;
	    }

		var ttlLssNo		= sheetObj.CellValue(Row, "ttl_lss_no");			//REQ OFC
		var rqstOfcCd		= sheetObj.CellValue(Row, "rqst_ofc_cd");			//REQ OFC
//		var respbOfcCd		= sheetObj.CellValue(Row, "respb_ofc_cd");			//Responsible\nOFC
		var respbOfcNm		= sheetObj.CellValue(Row, "respb_ofc_nm");          //Responsible\nOFC NM
		var rqstDt			= sheetObj.CellValue(Row, "rqst_dt"); 				//REQ DT
		var ttlLssStsCd		= sheetObj.CellValue(Row, "ttl_lss_sts_cd");		//Status
		var ttlLssRsnCd		= sheetObj.CellValue(Row, "ttl_lss_rsn_cd");		//Main Reason
		var ttlLssDtlRsnCd	= sheetObj.CellValue(Row, "ttl_lss_dtl_rsn_cd");	//Sub Reason
		var ttlLssDt		= sheetObj.CellValue(Row, "ttl_lss_dt");			//TLL DT
		var aproOfcCd		= sheetObj.CellValue(Row, "apro_ofc_cd");			//APP OFC
		var fileSeq 		= sheetObj.CellValue(Row, "file_seq");				//File Seq
		var mnrStsRefNo		= sheetObj.CellValue(Row, "mnr_sts_ref_no");		//mnr_sts_ref_no
		var ttlLssCfmDt		= sheetObj.CellValue(Row, "ttl_lss_cfm_dt");		//Close Date

		formObj.ttl_lss_no.value			= ttlLssNo;			//TTL NO
		formObj.rqst_ofc_cd.value			= rqstOfcCd;		//REQ OFC
//		formObj.respb_ofc_cd.value		    = respbOfcCd;		//Responsible\nOFC
		formObj.respb_ofc_nm.value		    = respbOfcNm;		//Responsible\nOFC NM
		formObj.rqst_dt.value 				= rqstDt; 			//REQ DT
		formObj.ttl_lss_sts_cd.value		= ttlLssStsCd; 		//Status
		formObj.ttl_lss_rsn_cd.value		= ttlLssRsnCd; 		//Main Reason
		formObj.ttl_lss_dtl_rsn_cd.value	= ttlLssDtlRsnCd;	//Sub Reason
		formObj.ttl_lss_dt.value			= ttlLssDt;			//TLL DT
		formObj.apro_ofc_cd.value			= aproOfcCd;		//APP OFC
		formObj.mnr_sts_ref_no.value 		= mnrStsRefNo;   	//히스토리 키
		formObj.ttl_lss_cfm_dt.value 		= ttlLssCfmDt;   	//히스토리 키

		//파일 리스트 조회
		if(fileSeq != "" && fileSeq != null){

			var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[9].LoadSearchXml(fileXml);
			}
		}
		//History 리스트 조회
		if(mnrStsRefNo != "" && mnrStsRefNo != null){
			historyMnrStsRefNo = mnrStsRefNo;
			var sXml = MnrStatusHistorySearch(sheetObjects[8], mnrStsRefNo);
			sheetObjects[8].LoadSearchXml(sXml);
		}
	}

	function t1sheet1_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "ttl_lss_cmpl_dt") return;
        var cal = new ComCalendarGrid();
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    }

	/**
	 * 조회후 합계값 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}

	/**
	 * 조회후 합계값 설정 - 3rd Party 탭
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setCalculateTotalSum();
		

		// 조회 결과 리스트의 inv_no 로 Combo list 생성.셋팅.
		setInvNoCombo(sheetObj);
		
		sheetObjects[3].Redraw = false;
		if(("Trucker" == ComTrim(document.form.ttl_lss_dtl_rsn_cd.Text)) && ("Y" == currOfcUS)){
			// Trucker 일 경우, 입력 가능 설정
			for(var i=sheetObjects[3].HeaderRows; i<=sheetObjects[3].LastRow-1; i++){
				sheetObjects[3].CellEditable(i, "usa_edi_cd") = true;
				sheetObjects[3].CellBackColor(i, "usa_edi_cd") = -1;
			}			
		}else{	
			// Trucker 가 아닐경우, SCAC Code null 처리
			for(var i=sheetObjects[3].HeaderRows; i<=sheetObjects[3].LastRow-1; i++){
				sheetObjects[3].CellValue(i, "usa_edi_cd") = "";
				sheetObjects[3].CellEditable(i, "usa_edi_cd") = false;				
				sheetObjects[3].CellBackColor(i, "usa_edi_cd") = -1;
			}
		}
		sheetObjects[3].Redraw = true;		
    }

	/**
	 * 조회후 합계값 설정 - Disposal 탭
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setCalculateTotalSum();
		
		// 조회 결과 리스트의 inv_no 로 Combo list 생성.셋팅.
		setInvNoCombo(sheetObj);
	 }
	
	/**
	 * 조회 결과 리스트의 inv_no 로 Combo list 생성.셋팅.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setInvNoCombo(sheetObj){
		var sheetComboText = "";
		var sheetComboDefault = "";
		var invNo = "";
		var dup = 0;
		for(var j=sheetObj.HeaderRows; j<=sheetObj.LastRow-1; j++){
			invNo = sheetObj.CellText(j, "inv_no");				
			dup = 0;
			// 반복되는 invNo 걸러내기
			for(var k=sheetObj.HeaderRows; k<=sheetObj.LastRow-1; k++){	
				if(j != k && invNo == sheetObj.CellText(k, "inv_no")){
					dup = 1;
				}
			}
			if(dup == 0 || j==1){
				sheetComboText += invNo + "|";
			}
			
			if(j==1){
				sheetComboDefault = invNo;	 
			}
		}	
		sheetObj.InitDataCombo(0, "inv_no", sheetComboText, sheetComboText, sheetComboDefault);
		
	}
	
	/**
	 * 조회후 합계값 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}

	/**
	 * 조회후 합계값 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}

	/**
	 * ROW 변경시 Cell별 수정가능여부설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     	if(HOOfc==currOfcCd || NYCRA == currOfcCd)//로그인 OFFICE가 본사일때, NYCRA 일때
     	{
     		sheetObj.CellEditable(NewRow, "del_chk") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =true;
     		sheetObj.CellEditable(NewRow, "dpc_val_amt") =true;
     		sheetObj.CellEditable(NewRow, "inv_no") =true;
     		sheetObj.CellEditable(NewRow, "curr_cd") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_cfm_flg") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_dtl_sts_cd") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =true;
     	}else{
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =false;
     		sheetObj.CellEditable(NewRow, "dpc_val_amt") =false;
     		sheetObj.CellEditable(NewRow, "inv_no") =false;
     		//sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =false;
     		sheetObj.CellEditable(NewRow, "ttl_lss_cfm_flg") =false;
     		sheetObj.CellEditable(NewRow, "ttl_lss_dtl_sts_cd") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =false;
     	}
     	// 로그인 오피스가 SELCON, NYCRA 인 경우만 활성화
		var logOfcCd = document.form.log_ofc_cd.value;		
		if (logOfcCd != "SELCON" && logOfcCd != "NYCRA"){	
			sheetObj.CellEditable(NewRow, "ttl_lss_cmpl_cd") =false;
			sheetObj.CellEditable(NewRow, "ttl_lss_cmpl_dt") =false;
		}
		
		// 로그인 오피스가 SELCON 인 경우만 활성화
		var logOfcCd = document.form.log_ofc_cd.value;		
		if (logOfcCd != "SELCON"){	
			sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =false;
		}
	}
	/**
	 * ROW 변경시 Cell별 수정가능여부설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t2sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     	if(HOOfc==currOfcCd || NYCRA == currOfcCd)//로그인 OFFICE가 본사일때, NYCRA 일때
     	{
     		sheetObj.CellEditable(NewRow, "del_chk") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =true;
     		sheetObj.CellEditable(NewRow, "dpc_val_amt") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_n3pty_tp_cd") =true;
     		sheetObj.CellEditable(NewRow, "curr_cd") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =true;
     		sheetObj.CellEditable(NewRow, "n3pty_no") =true;
     		sheetObj.CellEditable(NewRow, "bank_nm") =true;
     		sheetObj.CellEditable(NewRow, "bank_acct_no") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =true;
    		var ttlLssN3ptyTpCd = sheetObj.CellValue(NewRow, "ttl_lss_n3pty_tp_cd");
    		//service provider
    		if(ttlLssN3ptyTpCd == "O") {
    			sheetObj.CellEditable(NewRow, "payer_code") =false;
    			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =true;
    		}else if(ttlLssN3ptyTpCd == "N") {
    			sheetObj.CellEditable(NewRow, "payer_code") =false;
    			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =false;
    		}else{

    			sheetObj.CellEditable(NewRow, "payer_code") =true;
    			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =false;
    		}
     	}else{
     		sheetObj.CellEditable(NewRow, "del_chk") =false;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =false;
     		sheetObj.CellEditable(NewRow, "dpc_val_amt") =false;
     		sheetObj.CellEditable(NewRow, "ttl_lss_n3pty_tp_cd") =false;
     		sheetObj.CellEditable(NewRow, "payer_code") =false;
     		//sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =false;
     		sheetObj.CellEditable(NewRow, "n3pty_no") =true;
     		sheetObj.CellEditable(NewRow, "bank_nm") =true;
     		sheetObj.CellEditable(NewRow, "bank_acct_no") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =false;
     	}

		var ttlLssN3ptyTpCd = sheetObj.CellValue(NewRow, "ttl_lss_n3pty_tp_cd");
		//service provider
		if(ttlLssN3ptyTpCd == "O") {
			sheetObj.CellEditable(NewRow, "payer_code") =false;
			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =true;
		}else if(ttlLssN3ptyTpCd == "N") {
			sheetObj.CellEditable(NewRow, "payer_code") =false;
			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =false;
		}else{

			sheetObj.CellEditable(NewRow, "payer_code") =true;
			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =false;
		}
		if(("Trucker" == ComTrim(document.form.ttl_lss_dtl_rsn_cd.Text)) && ("Y" == currOfcUS)){
			sheetObj.CellEditable(NewRow, "usa_edi_cd") = true;
			sheetObj.CellBackColor(NewRow, "usa_edi_cd") = -1;
		}else{
			sheetObj.CellEditable(NewRow, "usa_edi_cd") = false;
			sheetObj.CellBackColor(NewRow, "usa_edi_cd") = -1;
		}
    }
	
	/**
	 * ROW 변경시 Cell별 수정가능여부설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t3sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     	if(HOOfc==currOfcCd || NYCRA == currOfcCd)//로그인 OFFICE가 본사일때, NYCRA 일때
     	{
     		sheetObj.CellEditable(NewRow, "del_chk") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =true;
     		sheetObj.CellEditable(NewRow, "disp_no") =true;
     		sheetObj.CellEditable(NewRow, "curr_cd") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =true;
			var ttlLssBilAmt = sheetObj.CellValue(NewRow, "ttl_lss_bil_amt");
			//service provider
//			if(ttlLssBilAmt == "" || ttlLssBilAmt == "0") {
//				sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =true;
//			}else{
//				sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =false;
//			}
     	}else{
     		
     		sheetObj.CellEditable(NewRow, "del_chk") =false;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =false;
     		sheetObj.CellEditable(NewRow, "disp_no") =false;
     		sheetObj.CellEditable(NewRow, "curr_cd") =false;
     		sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =false;
//			sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =false;
     		
     	}
     	
     	// 로그인 오피스가 SELCON 인 경우만 활성화
		var logOfcCd = document.form.log_ofc_cd.value;		
		if (logOfcCd != "SELCON"){	
			sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =false;
		}
	 }

	/**
	 * ROW 변경시 Cell별 수정가능여부설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t4sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     		sheetObj.CellEditable(NewRow, "del_chk") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =true;
     		sheetObj.CellEditable(NewRow, "curr_cd") =true;
     		sheetObj.CellEditable(NewRow, "csr_no") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_expn_amt") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =true;
	}

	/**
	 * ROW 변경시 Cell별 수정가능여부설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t5sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     		sheetObj.CellEditable(NewRow, "del_chk") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_yd_cd") =true;
     		sheetObj.CellEditable(NewRow, "dpc_val_amt") =true;
     		sheetObj.CellEditable(NewRow, "inv_no") =true;
     		sheetObj.CellEditable(NewRow, "curr_cd") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_plc_nm") =true;
     		sheetObj.CellEditable(NewRow, "ttl_lss_expn_amt") =true;
     		sheetObj.CellEditable(NewRow, "dtl_rmk") =true;
	}

	/**
	 * 조회후 합계값 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateCollectionSum();
	}

	/**
	 * 조회후 툴팁 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows; j<=sheetObj.LastRow; j++) {
			sheetObj.ToolTipText(j,"mnr_sts_rmk") = sheetObj.CellValue(j,"mnr_sts_rmk");
		}
	}

	/**
	 * Total loss history 값 변경후
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet4_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col)  == "mnr_sts_rmk"){
			sheetObj.ToolTipText(Row,"mnr_sts_rmk") = sheetObj.CellValue(Row,"mnr_sts_rmk");
		}
	}

	/**
	 * 쉬트 팝업 클릭시 발생하는 이벤트
	 *     Payer Code,Responsible\nOFC 의 팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) == "ttl_lss_bil_dt"){
			var cal = new ComCalendarGrid();
        	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		} else {
			var ttlLssN3ptyTpCd = sheetObj.CellValue(Row, "ttl_lss_n3pty_tp_cd");
			//service provider
			if(ttlLssN3ptyTpCd == "S") {
				ComOpenPopup("/hanjin/COM_ENS_0C1.do", 700, 450, 'setServiceProvider', '1,0', true);
			//coustomer
			} else if(ttlLssN3ptyTpCd == "C") {

				ComOpenPopup("/hanjin/COM_ENS_041.do", 770, 520, 'setCustomer', '1,0', true);

			} else if(ttlLssN3ptyTpCd == "O") {
				ComOpenPopup("/hanjin/COM_ENS_071.do", 770, 450, 'setCOM_ENS_071', '1,0', true);
			}
		}
	}

	/**
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, Yard, DV.Value, Lessor을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			//Close Type
			else if(colname == 'ttl_lss_cmpl_cd') {
				if(sheetObj.CellValue(Row,Col) != ""){
					if(sheetObj.CellValue(Row,"ttl_lss_cmpl_dt") == ""){
						sheetObj.CellValue2(Row,"ttl_lss_cmpl_dt") = ComGetNowInfo("ymd");
					}
				} else {
					sheetObj.CellValue2(Row,"ttl_lss_cmpl_dt") = "";
				}
			}
		}
	}

	/**
	 * 셀의 값 변경시 발생하는 Event(3rd Party 탭)
	 *     EQ No 를 변경함에 따라 TP/SZ, Yard, DV.Value, Lessor을 재설정한다.
	 *     Payer Type 을 변경함에 따라 Payer Code와 Payer Name을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				//중복인지 체크 
				var chkRow = sheetObj.ColValueDup("rqst_eq_no");
				if(chkRow > 0 && sheetObj.RowStatus(chkRow) != "D"){		 
					ComShowCodeMessage("MNR00006",sheetObj.CellValue(Row,"rqst_eq_no")); // {?msg1} is duplicated
					sheetObj.CellValue2(Row, "rqst_eq_no")=""; 
					sheetObj.SelectCell(Row, "rqst_eq_no", true);       
					return false;    
				//DV에 존재 하는 EQ인지 체크 
				} else {		
					var chkFlag = false; // EQ No 검증
					var chkEqType = true; // EQ Type 검증
					for(var j = sheetObjects[2].HeaderRows; j <= sheetObjects[2].LastRow; j++) {
						
						if(sheetObjects[2].RowStatus(j) != "D" && (sheetObjects[2].CellValue(j,"rqst_eq_no") == sheetObj.CellValue(Row,"rqst_eq_no"))){  
							
							// EQ Type 이 다를 경우, 
							if(sheetObjects[2].CellValue(j,"eq_knd_cd") != sheetObj.CellValue(Row,"eq_knd_cd")){
								chkEqType = false;
							}
							//DV에 존재 하는 EQ이면 true
							chkFlag = true;
							
						}				      
					}			
					if(!chkEqType){
						ComShowCodeMessage("MNR00373"); // EQ Type is wrong. Please check again							 	
						sheetObj.SelectCell(Row, "eq_knd_cd", true);			
						return false;			
					}
										
					if(!chkFlag){					
						ComShowCodeMessage("MNR00339"); // Please input EQ in D.V Expense
						sheetObj.CellValue2(Row, "rqst_eq_no")="";	 	
						sheetObj.SelectCell(Row, "rqst_eq_no", true);			
						return false;			
					} 			
				}					
				setEqNoInfo(sheetObj,Row,Col);
			}
			//RES_OFC
			else if(colname == 'respb_ofc_cd') {
				setOfficeInfo(sheetObj,Row, Col, Value);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Payer Type
			else if(colname=='ttl_lss_n3pty_tp_cd'){
				var payerCode = sheetObj.CellValue(Row, "payer_code");
				if(payerCode != '') {
					//데이터가 초기화됩니다.그래도 변경하시겠습니까?
					if(!ComShowCodeConfirm("MNR00192")) {
						sheetObj.ReturnCellData(Row,Col);
					    return;
					}
					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellValue(Row, "payer_name") = "";
				}
				if(Value=="O")
				{
					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellValue(Row, "payer_name") = "";
					sheetObj.CellEditable(Row, "payer_code") = false;
				}else if(Value=="N") {
					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellValue(Row, "payer_name") = "";
					sheetObj.CellEditable(Row, "payer_code") = false;
				}else{

					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellValue(Row, "payer_name") = "";
					sheetObj.CellEditable(Row, "payer_code") = true;
				}
			}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
		}
	}

	/**
	 * 셀의 값 변경시 발생하는 Event(Disposal 탭)
	 *     EQ No 를 변경함에 따라 TP/SZ, Yard, DV.Value, Lessor을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				//중복인지 체크 
				var chkRow = sheetObj.ColValueDup("rqst_eq_no");
				if(chkRow > 0 && sheetObj.RowStatus(chkRow) != "D"){		 
					ComShowCodeMessage("MNR00006",sheetObj.CellValue(Row,"rqst_eq_no"));
					sheetObj.CellValue2(Row, "rqst_eq_no")=""; 
					sheetObj.SelectCell(Row, "rqst_eq_no", true);       
					return false;    
				//DV에 존재 하는 EQ인지 체크 
				} else {		
					var chkFlag = false; // EQ No 검증
					var chkEqType = true; // EQ Type 검증
					for(var j = sheetObjects[2].HeaderRows; j <= sheetObjects[2].LastRow; j++) {	
						if(sheetObjects[2].RowStatus(j) != "D" && (sheetObjects[2].CellValue(j,"rqst_eq_no") == sheetObj.CellValue(Row,"rqst_eq_no"))){  
							// EQ Type 이 다를 경우, 
							if(sheetObjects[2].CellValue(j,"eq_knd_cd") != sheetObj.CellValue(Row,"eq_knd_cd")){
								chkEqType = false;
							}
							//DV에 존재 하는 EQ이면 true
							chkFlag = true;		
						}				      
					}	
					if(!chkEqType){
						ComShowCodeMessage("MNR00373"); // EQ Type is wrong. Please check again							 	
						sheetObj.SelectCell(Row, "eq_knd_cd", true);			
						return false;			
					}					
								
					if(!chkFlag){					
						ComShowCodeMessage("MNR00339"); // Please input EQ in D.V Expense
						sheetObj.CellValue2(Row, "rqst_eq_no")="";	 	
						sheetObj.SelectCell(Row, "rqst_eq_no", true);			
						return false;			
					} 			
				}					
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Disposal Amt
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			//Disposal Plan Amt
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
		}
	}

	/** 
	 * 쉬트 팝업 클릭시 발생하는 이벤트 
	 *     Buyer Code 의 팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t3sheet1_OnPopupClick(sheetObj, Row,Col){
		if(sheetObj.ColSaveName(Col) == "buyer_code"){
			// buyer code 조회 팝업 띄우기(service provider)
			ComOpenPopup("/hanjin/COM_ENS_0C1.do", 700, 450, 'setServiceProviderBuyer', '1,0', true);
		}
	}	
	
	/**
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, Yard, DV.Value, Lessor을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Scrapping Income AMT
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
			//Scrapping Cost AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}

	/**
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, Yard, DV.Value, Lessor을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Request AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}



	function t1sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		var newSeq = 1;
		for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
			with(sheetObjects[7]){
				if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].CellValue2(x,"seq") = newSeq++;
					sheetObjects[7].RowHidden(x) = false;
				} else {
					sheetObjects[7].RowHidden(x) = true;
				}
			}
		}
    }

	function t2sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		var newSeq = 1;
		for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
			with(sheetObjects[7]){
				if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].CellValue2(x,"seq") = newSeq++;
					sheetObjects[7].RowHidden(x) = false;
				} else {
					sheetObjects[7].RowHidden(x) = true;
				}
			}
		}
    }

	function t3sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		var newSeq = 1;
		for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
			with(sheetObjects[7]){
				if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].CellValue2(x,"seq") = newSeq++;
					sheetObjects[7].RowHidden(x) = false;
				} else {
					sheetObjects[7].RowHidden(x) = true;
				}
			}
		}
    }

	function t4sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		var newSeq = 1;
		for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
			with(sheetObjects[7]){
				if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].CellValue2(x,"seq") = newSeq++;
					sheetObjects[7].RowHidden(x) = false;
				} else {
					sheetObjects[7].RowHidden(x) = true;
				}
			}
		}
    }

	function t5sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq = sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo = 		sheetObj.CellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq =	sheetObj.CellValue(Row,"ttl_lss_dtl_seq");
		var newSeq = 1;
		for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
			with(sheetObjects[7]){
				if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].CellValue2(x,"seq") = newSeq++;
					sheetObjects[7].RowHidden(x) = false;
				} else {
					sheetObjects[7].RowHidden(x) = true;
				}
			}
		}
    }

	/**
	 * 셀의 팝업 클릭시 Event
	 *     Notification Date을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
    function t5sheet1_OnPopupClick(sheetObj, Row,Col,Value){

		 var formObject = document.form;
		   with(sheetObj) {
				var sName = ColSaveName(Col);
	        	switch (sName) {
					case "cr_end_dt":
					 var cal = new ComCalendarGrid("myCal");
				      cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
					break;
				}
	 		}
	}

	/**
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet3_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			var cltTotal=0;
			//Request AMT
			if(colname == 'clt_amt') {
				setCalculateCollectionSum();
			}
		}
	}

	function sheet2_OnDblClick(sheetObj,Row,Col)
    {
		var formObj = document.form;
		with(sheetObj){
			//초기화
			formObj.search_ttl_lss_no.value 	= CellValue(Row,"ttl_lss_no");				//TLL NO
			formObj.ttl_lss_no.value			= CellValue(Row,"ttl_lss_no"); 				//TLL NO
			formObj.ttl_lss_no_text.value 		= CellValue(Row,"ttl_lss_no");			//TLL NO
			formObj.rqst_ofc_cd.value		    = CellText(Row,"rqst_ofc_cd");			//REQ OFC
			formObj.rqst_ofc_cd_nm.value		= CellText(Row,"rqst_ofc_cd");			//REQ OFC
			
			formObj.acc_dt.value 				= CellValue(Row,"acc_dt");				//Accident Dt
			formObj.acc_flg.value 				= CellValue(Row,"acc_flg");				//Accident Dt
			formObj.acc_vsl_cd.value 			= CellValue(Row,"acc_vsl_cd");			//Accident Vessel Code
			formObj.acc_skd_voy_no.value 		= CellValue(Row,"acc_skd_voy_no");		//Accident Schedule Voyage Number
			formObj.acc_skd_dir_cd.value		= CellValue(Row,"acc_skd_dir_cd");		//Accident Schedule Direction Code
			formObj.acc_port_cd.value			= CellValue(Row,"acc_port_cd");			//Accident Port Code
			
			formObj.ttl_lss_no_tmp.value 		= CellValue(Row,"ttl_lss_no");			//Accident Check 후 자동 조회에 사용되는 Tmp
			
			//Office의 지역이 US인지 체크
			var sParam = 'f_cmd=' + SEARCH01 + '&rqst_ofc_cd=' + formObj.rqst_ofc_cd_nm.value;
//			if(CellValue(Row,"acc_flg") == "Y"){
//				formObj.page_separator.value = "Y";
//				sParam = sParam + '&page_separator=Y';
//				ByAccident.style.visibility = "visible";
//				
//			}else{
//				formObj.page_separator.value = "N";
//				ByAccident.style.visibility = "hidden";
//			}
			var sXml = sheetObjects[0].GetSearchXml("EES_MNR_0095GS.do", sParam);
			currOfcUS = ComGetEtcData(sXml, "chkUS");
			
			formObj.apro_ofc_cd.value			= CellValue(Row,"apro_ofc_cd"); 			//APP OFC
			formObj.mnr_sts_ref_no.value 		= CellValue(Row,"mnr_sts_ref_no");   	    //히스토리 키
			var rqstDt=CellValue(Row,"rqst_dt");
			if(rqstDt.length>=8)
			{
				rqstDt=rqstDt.substring(0,4)+ "-" + rqstDt.substring(4,6)+ "-" + rqstDt.substring(6,8);
			}else{
				rqstDt="";
			}
			formObj.rqst_dt.value 				= CellValue(Row,"rqst_dt"); 				//REQ DT
			formObj.rqst_dt_text.value 			= rqstDt; 			//REQ DT
			formObj.ttl_lss_sts_cd.value		= CellValue(Row,"ttl_lss_sts_cd");  		//Status

			formObj.ttl_lss_sts_cd_nm.value		= CellText(Row,"ttl_lss_sts_cd");  	//Status
			formObj.ttl_lss_rsn_cd.value		= CellValue(Row,"ttl_lss_rsn_cd");  		//Main Reason
			formObj.ttl_lss_dtl_rsn_cd.value	= CellValue(Row,"ttl_lss_dtl_rsn_cd"); 		//Sub Reason
			var ttlLssDt=CellValue(Row,"ttl_lss_dt");
			if(ttlLssDt.length>=8)
			{
				ttlLssDt=ttlLssDt.substring(0,4)+ "-" + ttlLssDt.substring(4,6)+ "-" + ttlLssDt.substring(6,8);
			}else{
				ttlLssDt="";
			}
			formObj.ttl_lss_dt.value			= CellValue(Row,"ttl_lss_dt"); 				//TLL DT
			formObj.ttl_lss_dt_text.value		= ttlLssDt; 			//TLL DT
			formObj.apro_ofc_cd_nm.value		= CellText(Row,"apro_ofc_cd"); 		//APP OFC
			formObj.respb_ofc_cd.value 		    = CellValue(Row,"respb_ofc_cd");   	//Responsible\nOFC
			formObj.ttl_lss_cfm_dt.value 		= CellValue(Row,"ttl_lss_cfm_dt");   	//Close Date
			uploadFileSeq=CellValue(Row,"file_seq");                        //FILE SEQ
			formObj.file_seq.value 		    = CellValue(Row,"file_seq");   	//FILE SEQ
			
    		formObj.ttl_lss_rsn_cd.Code = formObj.ttl_lss_rsn_cd.value;
    		formObj.ttl_lss_dtl_rsn_cd.Code = formObj.ttl_lss_dtl_rsn_cd.value;
    		

			if(MnrNullToBlank(formObj.search_ttl_lss_no.value) != ""){
	        	tabObjects[0].SelectedIndex =0;
				if(formObj.apro_ofc_cd_nm.value==currOfcCd)//로그인 OFFICE가 Approval Office일때
	        	{
					if(formObj.ttl_lss_sts_cd.value=="HE")
					{
						formObj.respb_ofc_cd.readOnly=true;
						formObj.respb_ofc_cd.className="input2";
			    		formObj.ttl_lss_rsn_cd.Enable = true;
			    		formObj.ttl_lss_dtl_rsn_cd.Enable = true;						
						ComBtnDisable("btn_Complete");
						ComBtnDisable("btn_cfm_dt"); 
					}
					else
					{
						formObj.respb_ofc_cd.readOnly=false;
			    		formObj.ttl_lss_rsn_cd.Enable = true;
			    		formObj.ttl_lss_dtl_rsn_cd.Enable = true;						
						formObj.respb_ofc_cd.className="input";
						ComBtnEnable("btn_Complete");
						ComBtnEnable("btn_cfm_dt");
					}
	        	}else{
					formObj.respb_ofc_cd.readOnly=true;
		    		formObj.ttl_lss_rsn_cd.Enable = false;
		    		formObj.ttl_lss_dtl_rsn_cd.Enable = false;					
					formObj.respb_ofc_cd.className="input2";
					ComBtnDisable("btn_Complete");
					ComBtnDisable("btn_cfm_dt");
	        	}


	        	if(formObj.ttl_lss_sts_cd.value=="HE")
	        	{
	        		ComBtnDisable("btn_Delete");	
					if(strMnrOfficeLevel=="L1" || NYCRA == currOfcCd) { // NYCRA에도 SELCON와 동일 권한 부여
						ComBtnEnable("btn_Save");
					} else {
						ComBtnDisable("btn_Save");
					}
					for(var i=1; i<=5; i++ )
					{
						ComBtnDisable("btn_t"+i+"RowDel");
					}
					ComBtnDisable("btn_Col_Add");
					ComBtnDisable("btn_Col_Delete");
					ComBtnDisable("btn_RowAdd2");
					ComBtnDisable("btn_RowDel2");
					ComBtnDisable("btn_FileAdd");
					ComBtnDisable("btn_FileDel");
					ComBtnDisable("btn_cfm_dt");
	        	} else {
					if(strMnrOfficeLevel == "L1" || NYCRA == currOfcCd) { // NYCRA에도 SELCON와 동일 권한 부여  
		    			ComBtnEnable("btn_Delete");		
	     			} else {
						ComBtnDisable("btn_Delete");		
	     			}
						
					ComBtnEnable("btn_Save");
					for(var i=1; i<=5; i++ )
					{
						ComBtnEnable("btn_t"+i+"RowDel");
					}
					ComBtnDisable("btn_Col_Add");
					ComBtnDisable("btn_Col_Delete");
					ComBtnEnable("btn_RowAdd2");
					ComBtnEnable("btn_RowDel2");
					ComBtnEnable("btn_FileAdd");
					ComBtnEnable("btn_FileDel");
					ComBtnEnable("btn_cfm_dt");
	        	}
				doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);
			}
			ComBtnEnable("btn_Excel_Down");
			return;
		}
    }
	/**
	 *  sheet2 변경시 발생하는 이벤트
	 *      Header 의 Total Loss No 로 Detail 을 조회한다.
	 * @param {IBSheet}	sheetObj
	 * @param {Int} 	Row
	 * @param {String} 	Col
	 * @return
	 */
	function sheet2_OnChange(sheetObj,Row, Col,Value)
   {
		if(nowLoad==1)
		{
			if(sheetObj.ColSaveName(Col)=="respb_ofc_cd")
			{
				nowLoad=0;
				sheetObj.SelectCell(Row, "respb_ofc_cd", true);
			}

		}else{
			nowLoad=1;
			var formObj = document.form;
			with(sheetObj){
				if(ColSaveName(Col)=="respb_ofc_cd")
				{
					if(CellValue(Row,"respb_ofc_cd")=="")return;
					var retArray=null;
					retArray = MnrGeneralCodeCheck(sheetObj,"OFC",CellValue(Row,"respb_ofc_cd"));
					if(retArray == null){
						ComShowCodeMessage("MNR00165",CellValue(Row,"respb_ofc_cd"),"OFFICE");
						SelectCell(Row, "respb_ofc_cd", true);
						CellValue2(Row,"respb_ofc_cd")="";
						if(formObj.search_ttl_lss_no.value 	== CellValue(Row,"ttl_lss_no"))
						{
							formObj.respb_ofc_cd.value 		    = "";
							formObj.respb_ofc_nm.value 		    = "";
						}

					} else {
						var retArray=retArray[0].split("|");
						if(MnrNullToBlank(ComGetObjValue(formObj.search_ttl_lss_no)) != ""
						&& formObj.search_ttl_lss_no.value 	== CellValue(Row,"ttl_lss_no"))
						{
							formObj.respb_ofc_cd.value=retArray[0];
							formObj.respb_ofc_nm.value=retArray[1];
						}
					}
				}
			}
		}
		nowLoad=0;
   }

	/**
	 * 쉬트2 팝업 클릭시 발생하는 이벤트
	 *     Date 의 달력팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
       if (sheetObj.ColSaveName(Col) != "respb_ofc_cd") return;
       ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_Sheet2_COM_ENS_071', '0,1', true);
	}

	/**
	 * 쉬트 팝업 클릭시 발생하는 이벤트
	 *     Date 의 달력팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet3_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "clt_dt") return;
        var cal = new ComCalendarGrid();
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    }

	/**
	 * 쉬트 팝업 클릭시 발생하는 이벤트
	 *     Date 의 달력팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet4_OnPopupClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col) != "mnr_sts_dt") return;
        var cal = new ComCalendarGrid();
        cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	 
	 /**
	  * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
	  */
	 function sheet4_OnClick(sheetObj, Row, Col, Value) {
	     switch (sheetObj.ColSaveName(Col)) {
	         case "mnr_sts_rmk":
	             sheetObj.CellEditable(Row, Col) = false;
	             ComShowMemoPad(sheetObj, Row, Col, false, 300, 200);
	             break;
	     }
	 } 

	/**
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(actionType == "IBSAVE"){
				ComShowCodeMessage("MNR00153");
			} else if(actionType == "COMPLETE") {

				ComShowCodeMessage("MNR00306");
			} else {
				ComShowCodeMessage("MNR00020");
			}
		}
	}

	/**
	 * 저장후 결과메세지 표시 - 3rd Party 탭
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t2sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(actionType == "CHNGINV"){ // invoice no 업데이트 후 상세데이터 재조회
				
				ComShowCodeMessage("MNR00023");
				doActionIBSheet(sheetObj,document.form,IBROWSEARCH); // 조회 처리
			} 
		}
	}	
	
	/**
	 * 저장후 결과메세지 표시 - Disposal 탭
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t3sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(actionType == "CHNGINV"){ // invoice no 업데이트 후 상세데이터 재조회
				
				ComShowCodeMessage("MNR00023");
				doActionIBSheet(sheetObj,document.form,IBROWSEARCH); // 조회 처리
			} 
		}
	}		
	
	//Responsible\nOFC Check
	function respb_ofc_cd_Check(){
		nowLoad=1;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.respb_ofc_cd.value," ")!="")
		{
			var retArray = MnrGeneralCodeCheck(sheetObj,"OFC",formObj.respb_ofc_cd.value);
		    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",formObj.respb_ofc_cd.value,"OFFICE");
				sheetObjects[1].CellValue2(Row,"respb_ofc_cd")="";
				formObj.respb_ofc_cd.value="";
				formObj.respb_ofc_nm.value="";
				ComSetFocus(formObj.respb_ofc_cd);
				nowLoad=0;
				return false;
			} else {
				var retArray=retArray[0].split("|");
				sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=retArray[0];
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != "")
				{
					formObj.respb_ofc_cd.value=retArray[0];
					formObj.respb_ofc_nm.value=retArray[1];

				}
			}
		}
		nowLoad=0;
		return true;
	}

	//YARD Check
	function ttl_lss_yd_cd_Check(checkYard){
		retArray = MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);
		if(retArray == null){
			return false;
		} else {
			return true;
		}
	}


    /**
     * Sheet1관련 프로세스 처리
     *
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);

	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}


				formObj.in_search_dt_tp.RemoveAll();
				formObj.in_search_dt_tp.EditFontBold = true;
				formObj.in_search_dt_tp.InsertItem(0, "Request DT","R");
				formObj.in_search_dt_tp.InsertItem(1, "Confirm DT","C");
				formObj.in_search_dt_tp.Code2 = "R";

				formObj.in_ofc_cd_tp.RemoveAll();
				formObj.in_ofc_cd_tp.EditFontBold = true;
				formObj.in_ofc_cd_tp.InsertItem(0, "APP OFC","A");
				formObj.in_ofc_cd_tp.InsertItem(1, "REQ/RES OFC ","R");
				formObj.in_ofc_cd_tp.Code2 = "R";

				formObj.in_status_tp.RemoveAll();
				formObj.in_status_tp.InsertItem(0, "Processing","P");
				formObj.in_status_tp.InsertItem(1, "Complete ","C");
				formObj.in_status_tp.Code2 = "P";

				//쉬트 콤보데이타 조회 및 설정
				setSheetCombo(sheetObj);
				formObj.reset();

				//초기값 설정
	    		formObj.in_ttl_lss_no.value		    = "";
				//TLL No
				formObj.ttl_lss_no.value		    = "";
				document.form.t1LossTotal.value ="";     //Loss Total
				document.form.t1RecPlnTotal.value ="";   //Recovery Plan Total
				document.form.t1BalanceTotal.value ="";  //Balance Total

				var toDay = ComGetNowInfo("ymd");
				formObj.respb_ofc_cd.readOnly=true;
				formObj.respb_ofc_cd.className="input2";

				formObj.ttl_lss_cfm_dt.value = toDay;

				//초기값 설정
				var oneYear = ComGetDateAdd(toDay, "Y", -1);
				ComSetObjValue(formObj.in_st_dt,oneYear);
				ComSetObjValue(formObj.in_end_dt,toDay);

				uploadFileSeq = "";
				historyMnrStsRefNo = "";

				//본사가 아니고 본부/지점일때, NYCRA 도 아닐때.
	        	if(HOOfc!=currOfcCd && NYCRA != currOfcCd)
	        	{
	        		sheetObjects[1].Editable = false;

	        	}
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
					    		
				ComBtnDisable("btn_t1InvoicePreview"); //D.V Expense 탭 Invoice Preview Btn disabled
    			ComBtnDisable("btn_Col_Add");
    			ComBtnDisable("btn_Col_Delete");
    			ComBtnDisable("btn_t1ChangeInvNo"); // D.V Expense 탭 Chng Inv No 버튼 disable
				sheetObj.WaitImageVisible = true;
	    		nowLoad=0;
	    		
	    		// Main Reason Combo 초기화
	    		var sCondition = new Array (			
	    				new Array("MnrGenCd","TR", "COMMON")		//Main Reason
	    		)     
	    		
	    		var comboList = MnrComSearchCombo(sheetObj,sCondition);	
	    								
	    		if(comboList[0] != null){
	    			for(var j = 0; j < comboList[0].length;j++){ 
	    				var tempText = comboList[0][j].split("|");  
	    				formObj.ttl_lss_rsn_cd.InsertItem(j, tempText[1] ,tempText[0]);						
	    			}           	
	    		}

	    		formObj.ttl_lss_rsn_cd.SelectedIndex = 0;
	    		formObj.ttl_lss_rsn_cd.Enable = false;
	    		formObj.ttl_lss_dtl_rsn_cd.Enable = false;
	    		break;

        	//조회
            case IBROWSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
    	    		// 모든 쉬트를 초기화
    	    		for (var i = 2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}

    				formObj.f_cmd.value = SEARCH;

					//다중조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0098GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					for(var i = 0; i < arrXml.length; i++){
						if(i == 6){
							var tempStr = arrXml[i];
							tempStr = tempStr.replace(/<TR>/g,'<TR HIDDEN="TRUE">');
							arrXml[i] = tempStr;
						}

						if(i == 0){
							sheetObjects[0].LoadSearchXml(arrXml[i]);
						} else {
							sheetObjects[i + 1].LoadSearchXml(arrXml[i]);
						}
						
					}

					//첫번째 로우 선택
					tabObjects[0].SelectedIndex = 0;
					if((sheetObj.RowCount - sheetObj.RowCount("D")) > 0){
						sheetObjects[2].SelectCell(1,2);

						var dtlSeq 	 = sheetObjects[2].CellValue(1,"ttl_lss_dtl_seq");
						currTtlLssNo = 		sheetObjects[2].CellValue(1,"ttl_lss_no");
						currTtlLssDtlSeq =	sheetObjects[2].CellValue(1,"ttl_lss_dtl_seq");
						var newSeq = 1;
						for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
							with(sheetObjects[7]){
								if(CellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
									sheetObjects[7].CellValue2(x,"seq") = newSeq++;
									sheetObjects[7].RowHidden(x) = false;
								} else {
									sheetObjects[7].RowHidden(x) = true;
								}
							}
						}
					} else {
						for(var x = 1 ; x <= sheetObjects[7].RowCount;x++){
							sheetObjects[7].RowHidden(x) = true;
						}
						currTtlLssNo = "";
						currTtlLssDtlSeq = "";
					}
					
					
					for(var i = 0; i < sheetObjects[2].Rows; i++){
						if(sheetObjects[2].CellValue(i, "ttl_lss_cmpl_cd") == "RE" || sheetObjects[2].CellValue(i, "ttl_lss_cmpl_cd") == "TC"){
							sheetObjects[2].CellEditable(i, "ttl_lss_cmpl_cd") = false;
						}
					}
	            }
                break;

            case IBSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
    				formObj.f_cmd.value = SEARCH01;

    	    		// 모든 쉬트를 초기화
    	    		for (i = 2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}

    				formObj.search_ttl_lss_no.value     = "";   //TLL NO
    				formObj.ttl_lss_no.value            = "";   //TLL NO
    				formObj.ttl_lss_no_text.value 		= "";	//TLL NO
    				formObj.rqst_ofc_cd_nm.value		= "";	//REQ OFC
    				
    				
    				currOfcUS = "";   //Office 지역 US 여부
    				
    				
    				formObj.rqst_dt_text.value 			= ""; 	//REQ DT
    				formObj.ttl_lss_sts_cd_nm.value		= "";  	//Status
    				formObj.ttl_lss_rsn_cd.SelectedIndex = 0;
                    formObj.ttl_lss_dtl_rsn_cd.code = "";
    				formObj.ttl_lss_dt_text.value		= ""; 	//TLL DT
    				formObj.apro_ofc_cd_nm.value		= ""; 	//APP OFC
    				formObj.respb_ofc_cd.value 		    = "";   //Responsible\nOFC
    				formObj.respb_ofc_cd.readOnly=true;
    				formObj.respb_ofc_cd.className="input2";
					formObj.rhq_ofc_cd.value = rhqOfcCd;
					
		    		formObj.ttl_lss_rsn_cd.Code = "";
		    		formObj.ttl_lss_rsn_cd.Enable = false;
		    		formObj.ttl_lss_dtl_rsn_cd.Enable = false;
		    		
					sParam = FormQueryString(formObj);
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0098GS.do", sParam);
				    sheetObjects[1].LoadSearchXml(sXml);
	            }
                break;

            //저장
            case IBSAVE:
    			if(nowLoad != 0) return;
    			nowLoad=1;
    			
            	if(validateForm(sheetObj,formObj,sAction)) {

    				if(actionType == "CHNGINV"){
    					// Chng INv
    					var status = "";
    					for(var j=sheetObj.HeaderRows; j<=sheetObj.LastRow; j++) {
    						if(sheetObj.RowStatus(j)== "U") {
    							status = "U";
    						}
    					}
    					if(status == ""){
    						sheetObj.RowStatus(1) = "U";  //저장이벤트 발생을 위한 상태변경	
    					}
    					
    					formObj.f_cmd.value = MODIFY;
    					
    					sheetObj.InitDataProperty(0, 16 , dtPopupEditFormat, 80, 	daCenter,  	true,   "ttl_lss_bil_dt",     	false,   "", dfDateYmd,		0,	true,	true);

						var sParam = sheetObj.GetSaveString(false) + "&f_cmd="+formObj.f_cmd.value;
						sheetObj.InitDataProperty(0, 16 , dtPopupEditFormat,80, 	daCenter,  	true,   "ttl_lss_bil_dt",     	true,   "", dfDateYmd,		0,	true,	true);
   						
						if(sParam == "" && sheetObj.RowCount>0){
							nowLoad=0;
							return;
						}				
						
						if(!ComShowCodeConfirm("MNR00368")){ // Do you want to change "invoice no" ?
							nowLoad=0;
							return false;
						}else{
							sSaveRtnXml = sheetObj.GetSaveXml("EES_MNR_0098GS.do", sParam);
							sheetObj.LoadSaveXml(sSaveRtnXml);
						}
    					
    				}else{
    					// Save, Complete
            		
	            		formObj.f_cmd.value = MULTI;
	            		formObj.file_seq.value = uploadFileSeq;
	
						//HC HA 구분을 위한 로직 필요
						if(sheetObjects[6].RowCount > 0){
							formObj.ttl_lss_sts_cd.value = "HC";
						} else {
							formObj.ttl_lss_sts_cd.value = "HA";
						}
	
						setRowStausByRequest();  //저장이벤트 발생을 위한 상태변경
						setCloseTypeAndDate();   //Close Type Close Date 각시트에 카피 한다.
	
						// inv_no 콤보 value 인식 보완	
						for(var j=sheetObjects[3].HeaderRows; j<=sheetObjects[3].LastRow-1; j++){
							sheetObjects[3].CellValue(j, "inv_no") = sheetObjects[3].CellText(j, "inv_no");
						}
						for(var j=sheetObjects[4].HeaderRows; j<=sheetObjects[4].LastRow-1; j++){
							sheetObjects[4].CellValue(j, "inv_no") = sheetObjects[4].CellText(j, "inv_no");
						}						
						
						if(actionType == "COMPLETE")
						{
							formObj.ttl_lss_sts_cd.value = "HE";
							formObj.ttl_lss_cfm_dt.value = ComGetNowInfo("ymd");   //Close Date
						}
						//var sParam = ComGetSaveString(sheetObjects);
						tabObjects[0].SelectedIndex=0;
						var sParam1 = sheetObjects[2].GetSaveString(true, true);
	
						if(sParam1=="" && sheetObjects[2].RowCount>0)
						{
							nowLoad=0;
							return;
						}
						tabObjects[0].SelectedIndex=1;
			
						// Sub Reason 이 Trucker 일때, SCAC Code 필수 체크
						if(("Trucker" == ComTrim(formObj.ttl_lss_dtl_rsn_cd.Text)) && ("Y" == currOfcUS)){ 
							sheetObjects[3].InitDataProperty(0, 14, dtData, 80, daCenter, true, "usa_edi_cd", true, "", dfNone, 0, true, true, 4);
						}else{	
							sheetObjects[3].InitDataProperty(0, 14, dtData, 80, daCenter, true, "usa_edi_cd", false, "", dfNone, 0, false, false, 4); 				
						}								
						
						var sParam2 = sheetObjects[3].GetSaveString(true, true);
						sheetObjects[3].InitDataProperty(0, 14, dtData, 80, daCenter, true, "usa_edi_cd", true, "", dfNone, 0, true, true, 4);				
						
						if(sParam2=="" && sheetObjects[3].RowCount > 0)
						{
	
							nowLoad=0;
							return;
						}
						if(sheetObjects[3].IsDataModified){
							for(var i=sheetObjects[3].HeaderRows ;i<=sheetObjects[5].LastRow;i++)
							{
								//BANK NAME 칼럼이 빈값일 경우
								var checkValue2 =ComTrimAll(sheetObjects[3].CellValue(i, "bank_nm")," ");
								if(checkValue1=="" && checkValue2=="")
								{
									ComShowCodeMessage("MNR00172","Bank Name");
									sheetObjects[3].SelectCell(i, "bank_nm",true);
									nowLoad=0;
									return false;
								}
	
								//BANK ACCAUNT칼럼이 빈값일 경우
								var checkValue2 =ComTrimAll(sheetObjects[3].CellValue(i, "bank_acct_no")," ");
								if(checkValue1=="" && checkValue2=="")
								{
									ComShowCodeMessage("MNR00172","Bank Account");
									sheetObjects[3].SelectCell(i, "bank_acct_no",true);
									nowLoad=0;
									return false;
								}
							}
						}
	
						tabObjects[0].SelectedIndex=2;
						var sParam3 = sheetObjects[4].GetSaveString(true, true);
						if(sParam3=="" && sheetObjects[4].RowCount > 0)
						{
	
							nowLoad=0;
							return;
						}
						tabObjects[0].SelectedIndex=3;
						var sParam4 = sheetObjects[5].GetSaveString(true, true);
						if(sParam4=="" && sheetObjects[5].RowCount > 0)
						{
	
							nowLoad=0;
							return;
						}
						if(sheetObjects[5].IsDataModified){
							for(var i=sheetObjects[5].HeaderRows ;i<=sheetObjects[5].LastRow;i++)
							{
	
								//2. 해당 칼럼이 빈값일 경우
								var checkValue1 =ComTrimAll(sheetObjects[5].CellValue(i, "ttl_lss_incm_amt")," ");
								var checkValue2 =ComTrimAll(sheetObjects[5].CellValue(i, "ttl_lss_expn_amt")," ");
								if(checkValue1=="" && checkValue2=="")
								{
									ComShowCodeMessage("MNR00172","at least one item amoung Scrapping Income AMT or Scrapping Cost Amt");
									sheetObjects[5].SelectCell(i, "ttl_lss_incm_amt",true);
									nowLoad=0;
									return false;
								}
	
							}
						}
	
	
						tabObjects[0].SelectedIndex=4;
						var sParam5 = sheetObjects[6].GetSaveString(true, true);
						if(sParam5=="" && sheetObjects[6].RowCount > 0)
						{
	
							nowLoad=0;
							return;
						}
						//Total Loss Collection
						var sParam6 = sheetObjects[7].GetSaveString(true, true);
						sParam6 = ComSetPrifix(sParam6,"coll_");
	
						// Total Loss History
						var sParam7 = sheetObjects[8].GetSaveString(true, true);
						sParam7 = ComSetPrifix(sParam7,"statusHistory_");
	
						var sParam  = FormQueryString(formObj) +"&"+ sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6 +"&"+ sParam7;
	
					    if (sParam == "")
					    {
							nowLoad=0;
					    	return;
					    }
					    
					    sSaveRtnXml = sheetObjects[1].GetSaveXml("EES_MNR_0098GS.do", sParam);
					    sheetObjects[1].LoadSaveXml(sSaveRtnXml);
	
						if(MnrComGetErrMsg(sSaveRtnXml) == null){
							var ttlLssNo = ComGetEtcData(sSaveRtnXml, "totalLossNo");
	
							var targetRow = 0;
							with(sheetObjects[1]){
								for(var j = 2; j <= LastRow;j++){
									if(CellValue(j,"ttl_lss_no") == ttlLssNo){
										targetRow = j;
									}
								}
							}
	
							//마치 선택된것 처럼
							if(targetRow != 0){
								sheetObjects[1].SelectCell(targetRow,1);
								formObj.search_ttl_lss_no.value 	= ttlLssNo;
								formObj.ttl_lss_no.value 	= ttlLssNo;
								if(MnrNullToBlank(formObj.search_ttl_lss_no.value) != ""){
									doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);
								}
							}else{
			    				formObj.search_ttl_lss_no.value     = "";   //TLL NO
			    				formObj.ttl_lss_no.value            = "";   //TLL NO
			    				formObj.ttl_lss_no_text.value 		= "";	//TLL NO
			    				formObj.rqst_ofc_cd_nm.value		= "";	//REQ OFC
			    				
			    				
			    				currOfcUS = "";   //Office 지역 US 여부
			    				
			    				
			    				formObj.rqst_dt_text.value 			= ""; 	//REQ DT
			    				formObj.ttl_lss_sts_cd_nm.value		= "";  	//Status
			    				formObj.ttl_lss_rsn_cd.Code	= "";  	//Main Reason
			    				formObj.ttl_lss_dtl_rsn_cd.Code	= "";	//Sub Reason
					    		formObj.ttl_lss_rsn_cd.Enable = false;
					    		formObj.ttl_lss_dtl_rsn_cd.Enable = false;
			    				formObj.ttl_lss_dt_text.value		= ""; 	//TLL DT
			    				formObj.apro_ofc_cd_nm.value		= ""; 	//APP OFC
			    				formObj.respb_ofc_cd.value 		    = "";   //Responsible\nOFC
			    				formObj.respb_ofc_cd.readOnly=true;
			    				formObj.respb_ofc_cd.className="input2";
	
			    				formObj.tCollectionTotal.value     = "";   //Total Collection
			    				formObj.t1RecPlnTotal.value        = "";   //Recovery Plan Total
			    				formObj.t1LossTotal.value 		   = "";   //Loss Total
			    				formObj.t1BalanceTotal.value	   = "";   //Balance Total
	
			    	    		// 모든 쉬트를 초기화
			    	    		for (i = 2; i < sheetObjects.length; i++) {
			    	    			sheetObjects[i].RemoveAll();
			    	    		}
	
							}
						}
    				} // actionType = Save, Complete
            	}
    			nowLoad=0;
                break;

            //삭제
            case IBSEARCHAPPEND:
            	if(validateForm(sheetObj,formObj,sAction)) {
					actionType = "IBSEARCHAPPEND";
            		formObj.f_cmd.value = REMOVE;

            		setRowStausByRequest();  //저장이벤트 발생을 위한 상태변경

					var sParam1 = sheetObjects[2].GetSaveString(true, true);
					if(sParam1 == "" && sheetObjects[2].IsDataModified){
							return;
					}
					var sParam2 = sheetObjects[3].GetSaveString(true, true);
					if(sParam2 == "" && sheetObjects[3].IsDataModified){
							return;
					}
					var sParam3 = sheetObjects[4].GetSaveString(true, true);
					if(sParam3 == "" && sheetObjects[4].IsDataModified){
							return;
					}
					var sParam4 = sheetObjects[5].GetSaveString(true, true);
					if(sParam4 == "" && sheetObjects[5].IsDataModified){
							return;
					}
					var sParam5 = sheetObjects[6].GetSaveString(true, true);
					if(sParam5 == "" && sheetObjects[6].IsDataModified){
							return;
					}
					//Total Loss Collection
					var sParam6 = sheetObjects[7].GetSaveString(true, true);
					if(sParam6 == "" && sheetObjects[7].IsDataModified){
							return;
					}
					sParam6 = ComSetPrifix(sParam6,"coll_");
					// Total Loss History
					var sParam7 = sheetObjects[8].GetSaveString(true, true);
					sParam7 = ComSetPrifix(sParam7,"statusHistory_");
					var sParam  = FormQueryString(formObj) +"&"+ sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6 +"&"+ sParam7;
				    sParam += "&" + FormQueryString(formObj);
				    sSaveRtnXml = sheetObjects[1].GetSaveXml("EES_MNR_0098GS.do", sParam);	//Total Loss No 를 return 받는다.

					//폼값 초기화
					formObj.rqst_ofc_cd.value		= "";
					formObj.rqst_dt.value 			= "";
					formObj.ttl_lss_sts_cd.value		= "";
					formObj.ttl_lss_rsn_cd.value		= "";
					formObj.ttl_lss_dtl_rsn_cd.value	= "";
					formObj.ttl_lss_dt.value		= "";
					formObj.apro_ofc_cd.value		= "";
					formObj.ttl_lss_no.value		= "";
					formObj.mnr_sts_ref_no.value 		= "";

    				formObj.search_ttl_lss_no.value     = "";   //TLL NO
    				formObj.ttl_lss_no_text.value 		= "";	//TLL NO
    				formObj.rqst_ofc_cd_nm.value		= "";	//REQ OFC
    				
    				
    				currOfcUS = "";   //Office 지역 US 여부
    				
    				
    				formObj.rqst_dt_text.value 			= ""; 	//REQ DT
    				formObj.ttl_lss_sts_cd_nm.value		= "";  	//Status
    				formObj.ttl_lss_rsn_cd.Code		= "";  	//Main Reason
    				formObj.ttl_lss_dtl_rsn_cd.Code	= "";	//Sub Reason
		    		formObj.ttl_lss_rsn_cd.Enable = false;
		    		formObj.ttl_lss_dtl_rsn_cd.Enable = false;
    				formObj.ttl_lss_dt_text.value		= ""; 	//TLL DT
    				formObj.apro_ofc_cd_nm.value		= ""; 	//APP OFC
    				formObj.respb_ofc_cd.value 		    = "";   //Responsible\nOFC
    				formObj.respb_ofc_cd.readOnly=true;
    				formObj.respb_ofc_cd.className="input2";

    				formObj.tCollectionTotal.value     = "";   //Total Collection
    				formObj.t1RecPlnTotal.value        = "";   //Recovery Plan Total
    				formObj.t1LossTotal.value 		   = "";   //Loss Total
    				formObj.t1BalanceTotal.value	   = "";   //Balance Total

					// 모든 쉬트를 초기화
    	    		for (i = 0; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
					sheetObjects[1].LoadSaveXml(sSaveRtnXml);   								//저장 성공확인 메세지를 위한 Load
            	}
                break;

            // Row 입력
			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)) {
					var Row = "";
					if (sheetObj.id == 'sheet3') {
						if(currTtlLssDtlSeq != ""){
							Row = sheetObj.DataInsert(-1);
							var seq = MnrGetViewRowCntCLT(sheetObj,currTtlLssDtlSeq);
							sheetObj.CellValue2(Row, "seq") = seq;
							sheetObj.CellValue2(Row, "type") = "Manual";
							sheetObj.CellValue2(Row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
							sheetObj.CellValue2(Row, "ttl_lss_dtl_seq") = currTtlLssDtlSeq;
							sheetObj.CellValue2(Row, "clt_stl_flg") = "N";
							sheetObj.CellValue2(Row, "clt_ofc_cd ") = formObj.self_ofc.value;
							sheetObj.CellValue2(Row, "chk_trns_no") = "";
							sheetObj.CellValue2(Row, "clt_dt") = ComGetNowInfo("ymd","-");
							//그리드 콤보 값 초기화
							sheetObj.CellValue2(Row, "curr_cd") = "USD";	//CURR
						} else {
							ComShowCodeMessage("MNR00263");
							return;
						}
					} else {
						Row = sheetObj.DataInsert(-1);

						//Total Loss No 설정
						sheetObj.CellValue2(Row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
						//mnr_inv_tp_cd 설정
						if(sheetObj.id == 't1sheet1') {
							sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "DV";
						} else if (sheetObj.id == 't2sheet1') {
							sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "TP";
						} else if (sheetObj.id == 't3sheet1') {
							sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "DS";
						} else if (sheetObj.id == 't4sheet1') {
							sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "SC";
						} else if (sheetObj.id == 't5sheet1') {
							sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "IR";
							sheetObj.CellValue2(Row, "ttl_lss_plc_nm") = "";
						}
						//그리드 콤보 값 초기화
						sheetObj.CellValue2(Row, "curr_cd") = "USD";	//CURR
					}
				}
                break;

    		//Row 삭제
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id != "sheet3"){
						ComRowHideDelete(sheetObj, "del_chk");
					} else {
						MnrRowDelete(sheetObj,"del_chk");
						setCalculateCollectionSum();
					}
				}
				break;

        }
    }

	function MnrGetViewRowCntCLT(sheetObj,dtlSeq){
		var cnt = 1;

		for(var i = 1 ; i <= sheetObj.RowCount; i++){
			if(sheetObj.RowHidden(i) == false){
				if(sheetObj.CellValue(i,"ttl_lss_dtl_seq") == dtlSeq){
					cnt++;
				}
			}
		}
		return cnt;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var formObj = document.form;
		with(formObj){
    		// 조회시 체크
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
			//저장(요청)시
			else if(sAction == IBSAVE) {	
				if(actionType == "CHNGINV"){
					// Chng INv
					if(sheetObj.RowCount < 2){
						ComShowCodeMessage("MNR00369");
						nowLoad=0;
						return false;
					}
					
				}else{
					// Save, Complete
					if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
						ComShowCodeMessage("MNR00261");
						return false;
					}
					//responsible Office check
					if(!respb_ofc_cd_Check()) {return false;}
					//Total Loss 상태값 체크
					if(!checkTotalLossfStatus()) {return false;}
					//필수
					if(!checkMandatory(formObj.ttl_lss_rsn_cd)) {return false;}
					if(!checkMandatory(formObj.ttl_lss_dtl_rsn_cd)) {return false;}
					if(!checkMandatory(formObj.ttl_lss_dt)) {return false;}
					if(!checkMandatory(formObj.apro_ofc_cd)) {return false;}
					//그리드 존재유무
					if(!checkIsDetailRow()) {return false;}
					//각시트별 중복체크
					for (var i=2; i <= 6; i++){
						var Row = sheetObjects[i].ColValueDup("rqst_eq_no");
						if(sheetObjects[i].IsDataModified){
							if(Row>0){
								ComShowCodeMessage("MNR00006",i + "th sheet of " + Row + " row ");
								sheetObjects[i].SelectCell(Row, "rqst_eq_no", true);
								return false;
							}
						}
					}

					var toDay = ComGetNowInfo("ymd");
					if(actionType == "COMPLETE")
					{
						//DV Value
						for(var j=sheetObjects[2].HeaderRows ;j <= sheetObjects[2].LastRow;j++)
						{
							if(sheetObjects[2].CellValue(j,"ibflag")!= "D" && sheetObjects[2].CellValue(j,"seq")!= "0")
							{
								if(sheetObjects[2].CellValue(j,"ttl_lss_cmpl_cd") == ""){
									ComShowCodeMessage("MNR00341");
									sheetObjects[2].SelectCell(j,"ttl_lss_cmpl_cd");
									return false;
								} else {
									if(sheetObjects[2].CellValue(j,"ttl_lss_cmpl_dt") == ""){
										sheetObjects[2].CellValue2(j,"ttl_lss_cmpl_dt")	= toDay;
									}
								}

							}
						}

						if (!ComShowCodeConfirm("MNR00275","Total Loss","Complete")){return false;}
					}else if(actionType == "IBSAVE")
					{
						if (!ComShowCodeConfirm("MNR00275","Total Loss","Save")){return false;}
					}
				}
			}
			//삭제시
			else if(sAction == IBSEARCHAPPEND) {
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
					ComShowCodeMessage("MNR00260");
					return false;
				}

				if (!ComShowCodeConfirm("MNR00275","Total Loss","Delete")){return false;}
			}
			//행추가시 		
			else if (sAction == IBINSERT) {	
				if(sheetObj.id != 'sheet3'){ // Total Loss Collection & Adjustment 그리드에서는 체크하지 않음.
					var dvTabRowCnt = sheetObjects[2].RowCount - sheetObjects[2].RowCount("D");
					var chkTabRowCnt = sheetObj.RowCount - sheetObj.RowCount("D");
					if(dvTabRowCnt <= chkTabRowCnt){	
						ComShowCodeMessage("MNR00339");  		
						return false;	   								
					}	  	 					
				}
			}    		
        }
        return true;
    }

    /* ********* User Functions ************* */
	/**
	 * EES_MNR_0195 Popup의 값을 받은 함수
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
    	var formObj = document.form;

		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.in_ttl_lss_no.value = aryPopupData[0][4];
		}
	}

	/**
	 * Loss Total : DV의 Pay Amount의 합계
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var tabIndex=tabObjects[0].SelectedIndex + 1;
       var sheetIndex=2;
	    var calFlag=false;
		for(var i=sheetIndex;i<sheetIndex + 5;i++)
		{
			if(sheetObjects[i].RowCount >0)
			{
				calFlag=true;
				break;
			}
		}
		if(calFlag==true)
		{
		    var tLossTotal=0;
		    var thrdAmtTotal=0;
		    var disposalAmtTotal=0;
		    var disposalPlanAmtTotal=0;
		    var scrapIncomeAmtTotal=0;
            var scrapCostAmtTotal=0;
            var requestAmtTotal=0;

            for(var i=sheetIndex;i<sheetIndex + 5;i++)
            {
			    if(sheetObjects[i].RowCount >0)
			    {
					for(var j=sheetObjects[i].HeaderRows ;j<=sheetObjects[i].LastRow;j++)
					{
						//삭제 되거나  SEQ가 NULL(0)인 데이타 제외하고 계산
						if(sheetObjects[i].CellValue(j,"ibflag")!="D" && sheetObjects[i].CellValue(j,"seq")!="0")
						{
							if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="DV"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="")
									tLossTotal = getFloatSumData(tLossTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="TP"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="")
									thrdAmtTotal = getFloatSumData(thrdAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="DS"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="")
									disposalAmtTotal = getFloatSumData(disposalAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt")!="")
									disposalPlanAmtTotal = getFloatSumData(disposalPlanAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_incm_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="SC"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt")!="")
									scrapIncomeAmtTotal = getFloatSumData(scrapIncomeAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt")!="")
									scrapCostAmtTotal = getFloatSumData(scrapCostAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="IR"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt")!="")
									requestAmtTotal = getFloatSumData(requestAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							}
						}
					}
			    }
            }
            
            /*t1LossTotal, t1RecPlnTotal, t1BalanceTotal 계산 시작*/
            var tempStr = ComAddComma2((tLossTotal + ""), "#,###");
			eval("document.form.t"+ 1 + "LossTotal.value = tempStr;");

			//2010-03-19 : Recovery Plan Total(tRecPlnTotal) 을 minus(-) 로 표현			
		    var tRecPlnTotal = parseFloat(parseFloat((thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal)*(-1)).toFixed(2));
			tempStr = ComAddComma2((tRecPlnTotal + ""), "#,###");
			eval("document.form.t"+ 1 + "RecPlnTotal.value = tempStr;");

			//2010-03-19 : Recovery Plan Total(tRecPlnTotal) 을 minus(-) 로 수정함에 따라  Loss Total(tLossTotal)을 minus(-) 하지않고 plus(+) 로 변경하여 Balance Total(tBalanceTotal) 값을 도출함.
		    var tBalanceTotal = getFloatSumData(tRecPlnTotal,tLossTotal);
			tempStr = ComAddComma2((tBalanceTotal + ""), "#,###");
			eval("document.form.t"+ 1 + "BalanceTotal.value = tempStr;");
			/*t1LossTotal, t1RecPlnTotal, t1BalanceTotal 계산 종료*/
		}
	}

	/**
	 * parseFloat 버그로 함수로 뺌 <br>
	 * @param a  더할값
	 * @param b  더할값
	 * @return sumResult  결과값
	 */
	function getFloatSumData(a,b){
		var aFloat = parseFloat(a + "");
		var bFloat = parseFloat(b + "");
		var sumResult = parseFloat(aFloat + bFloat).toFixed(2);
		return  parseFloat(sumResult + "");
	}

	/**
	 * Collection Total :Total Loss Collection & Adjustment의 Amount의 합계
	 */
	function setCalculateCollectionSum(){
		var sheetObj=sheetObjects[7];
		var cltTotal=0;
		for(var j=sheetObj.HeaderRows ;j<=sheetObj.LastRow;j++)
		{
			//삭제 되거나  SEQ가 NULL(0)인 데이타 제외하고 계산
			if(sheetObj.CellValue(j,"ibflag")!="D" && sheetObj.CellValue(j,"seq")!="0")
			{
				cltTotal+=parseFloat(sheetObj.CellValue(j,"clt_amt"));
				
			}

		}

		if(sheetObj.RowCount >0)
		{
			document.form.tCollectionTotal.value=cltTotal;
			ComAddSeparator(document.form.tCollectionTotal, "float");
		}else{
			document.form.tCollectionTotal.value=0;
		}
	}

	/**
	 * 쉬트 콤보 데이티 조회 및 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj) {
		var formObj=document.form;
		//쉬트 조회
		var sCondition = new Array (
			new Array("MdmCurrency","", "COMMON")		//Currency
			,new Array("MnrGenCd","CD00071", "COMMON")  //Status 이전 CD00042
			,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00050", "COMMON")  //Total Collection Type
			,new Array("ComIntgCd","CD00809","COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00039", "COMMON")  //Total Loss Status
			,new Array("MnrGenCd","TR", "COMMON")  //Main Reason
			,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
			,new Array("MnrGenCd","CD00072", "COMMON")  //Close Type
			,new Array("MnrGenCd","HOOFC", "COMMON")    //HOOfc Code
			,new Array("MnrGenCd","SELHO","CUSTOM9")	//Eq Kind
		)
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 설정
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i = 0; i < comboList.length; i++) {
			//쉬트콤보별 초기화
			sheetComboText = "";
			sheetComboCode = "";
			sheetComboCodeText = "";
			sheetComboDefault = "";
			for(var j = 0; j < comboList[i].length; j++){
				var tempText = comboList[i][j].split("|");

				if(i == 8 && j == 0){
					sheetComboText +=  " " + "|";
					sheetComboCode +=  " " + "|";
				}

				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";

				if(i==9)
				{
					HOOfc=tempText[0];

				}

				if(j == 0){
					sheetComboDefault = tempText[0];
				}
			}
			//탭별 쉬트 콤보 설정
			for(var k = 1; k < 8; k++)
			{
				if(i == 0) {
					if(k != 1)
					{
						sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 1) {
					if(k == 2) {
					    sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 2) {
					if(k == 3) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 3) {
					if(k == 7) {
						//sheetObjects[k].InitDataCombo (0, "ttl_lss_clt_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 4) {
					if(k == 7) {
						sheetObjects[k].InitDataCombo (0, "inv_pay_mzd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 5) {
					if(k == 1) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 6) {
					if(k == 1) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_rsn_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 7) {
					if(k == 6) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 8) {
					if(k == 2) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_cmpl_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 10){
					if(k != 1 && k != 7 ) {
						sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
			}
		}
	}

	/**
	 * (Responsible Office) 존재여부 체크    처리 부분<br>
	 * @param
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Row 의 CellValue
	 */
	function setOfficeInfo(sheetObj,Row, Col, Value)
	{
		var retArray =  null;
		if (Value!="")
		{
		    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",Value);
			if(retArray == null)
			{
				ComShowCodeMessage("MNR00165",Value,"OFFICE");
				sheetObj.CellValue2(Row,Col)="";
				sheetObj.SelectCell(Row,Col,true);
			}
		}
	}

	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setServiceProvider(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[3].SelectRow;
			var vndrSeq = aryPopupData[0][2];
			var vndrNm  = aryPopupData[0][4];
			sheetObjects[3].CellValue(Row, "payer_code") = vndrSeq;
			sheetObjects[3].CellValue(Row, "payer_name") = vndrNm;
			sheetObjects[3].CellValue(Row, "mnr_prnr_seq") = vndrSeq;
		}
	}
	
	/**
	 * (Service Provider Buyer) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setServiceProviderBuyer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[4].SelectRow;
			var vndrSeq = aryPopupData[0][2];
			var vndrNm  = aryPopupData[0][4];
			sheetObjects[4].CellValue(Row, "buyer_code") = vndrSeq;
			sheetObjects[4].CellValue(Row, "buyer_name") = vndrNm;
		}
	}			

 	/**
	 * COM_ENS_071 의 값을 받은 함수
	 */
	function setCOM_ENS_071(aryPopupData){
    	 var formObj = document.form;
    	 var Row=sheetObjects[3].SelectRow;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[3].CellValue(Row, "respb_ofc_cd") 		= aryPopupData[0][3];
		 }
    }

	/**
	 * (Customer) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setCustomer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row =sheetObjects[3].SelectRow;
			var custCd 			= aryPopupData[0][3];
			var custNm 			= aryPopupData[0][4];
			var mnrPrnrCntCd	= custCd.substring(0,2);
			var mnrPrnrSeq   	= custCd.substring(2);
			sheetObjects[3].CellValue(Row, "payer_code") 		= custCd;
			sheetObjects[3].CellValue(Row, "payer_name") 		= custNm;
			sheetObjects[3].CellValue(Row, "mnr_prnr_cnt_cd")	= mnrPrnrCntCd;
			sheetObjects[3].CellValue(Row, "mnr_prnr_seq") 		= mnrPrnrSeq;
		}
	}

	 /**
     * IBSheet의 file upload 할 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {없음}
     **/
	function file_Insert(sheetObj){
		uploadFileSeq = sheetObj.CellValue(2,"file_seq");

		if(uploadFileSeq == undefined){
			uploadFileSeq = "";
		}

		for(var j = 2; j <= sheetObj.LastRow;j++){
			if (sheetObj.CellValue(j,"org_file_nm") == ""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(j,"org_file_nm");
				return;
			}
		}
		var row = sheetObj.DataInsert(-1);
	}

	 /**
     * IBSheet의 file upload 할 Row를 삭제한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {없음}
     **/
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}

	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet5_OnPopupClick(sheetObj,Row,Col){
	    var upObj = uploadObjects[0];
		var prefix = "";
	 	var fileName = sheetObj.OpenFileDialog("파일선택");

		var badFile = false;
		if(fileName.indexOf("\\") == -1) {
			badFile = true;
		} else {
			var relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1);
			var fileType = 	relativePath.substr(relativePath.lastIndexOf(".") + 1);
			fileType = fileType.toUpperCase();
			//GIF, BMP, TIFF, JPG
			//if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG"){
				badFile = false;
			//}
		}

	 	if(!badFile) {
	 		sheetObj.CellValue2(Row, prefix+ "org_file_nm")= fileName;
	 		upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
	    	var ret = upObj.AddFile(fileName);
	    	fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
	 		sheetObj.CellValue2(Row, Col)= fileName;
			sheetObj.CellValue2(Row, prefix+ "file_dw")= '1';
	 		var file_seq = sheetObj.CellValue(Row, prefix+ "file_seq");
			var file_dtl_seq = sheetObj.CellValue(Row, prefix+ "file_dtl_seq");
			if(file_dtl_seq=="") file_dtl_seq=Row;
			var ibflag='U';
			if(file_seq == "" || uploadFileSeq != "") ibflag='I'; // 최초 저장시 및 저장된 파일 없을때 ibflag을 I로 Setting
			if(file_seq != "" && uploadFileSeq != "") ibflag='U';

			if(uploadFileSeq != "") {
				file_seq = uploadFileSeq;
			}

	 		var sParam = "f_cmd="+COMMAND01;
	 		sParam+= "&mnr_grp_tp_cd=TLL";       // MNR Work Group Type Code
	 		sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
	 		sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경

			upObj.ExtendParam = sParam;

			var sXml = upObj.DoUpload(true);

			uploadFileSeq = ComGetEtcData(sXml,"seqValue");

			if(uploadFileSeq != "" && uploadFileSeq != undefined){
				var fileXml = SearchFileUpload(sheetObj,uploadFileSeq);
				sheetObj.LoadSearchXml(fileXml);
			}
	 	} else {
			ComShowCodeMessage("MNR00217");
		}
	}

	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet5_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";

        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;

		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;

		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}

	/**
	 * Total Loss 상태값을 체크하여 요청(Request)인 경우 false를
	 * 그외의 경우는 true를 리턴한다.
	 * @return  {Boolean}    true/false
	 */
	function checkTotalLossfStatus() {
		var ttlLssStsCd = document.form.ttl_lss_sts_cd.Code; //ttl_lss_sts_cd
		if(ttlLssStsCd == "HR"){
			ComShowCodeMessage("MNR00208","Total Loss", "Request ");
			return false;
		}
		return true;
	}

	/**
     * 저장시 필수 체크
     * @param	{Element}	obj	체크할 Form Element
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {
		    ComShowCodeMessage("MNR00003");
		    return false;
		}
		return true;
	}

	/**
	 * 저장시 그리드 존재유무
	 */
	function checkIsDetailRow(){
		var cnt = 0;
		for (var i=2; i<7; i++) {
			if(sheetObjects[i].RowCount > 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}

		return true;
	}

	/**
	 * Requust버튼 클릭시 저장이벤트를 강제 발생시키기 위해
	 * 존재하는 최초의 1개의 Row상태값만을 'U'로 변경시킴
	 */
	function setRowStausByRequest(){
		for (var i = 2; i < 7; i++) {
			//데이터가 존재하는 시트인 경우만
			if(sheetObjects[i].RowCount > 0) {
				for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
					if(sheetObjects[i].RowStatus(j)== "R") {
					    sheetObjects[i].RowStatus(j) = "U";
						return;
					}
				}
			}
		}
	}

	/**
	 * Close Type Close Date 각시트에 카피 한다.
	 */
	function setCloseTypeAndDate(){
		for(var j = sheetObjects[2].HeaderRows; j <= sheetObjects[2].LastRow; j++) {
			var Eqno =  sheetObjects[2].CellValue(j,"rqst_eq_no");
			var cmplCd =  sheetObjects[2].CellValue(j,"ttl_lss_cmpl_cd");
			var cmplDt =  sheetObjects[2].CellValue(j,"ttl_lss_cmpl_dt");

			//DV 탭을 제외한  탭
			for (var i = 3; i <= 6; i++) {
				for(var k = sheetObjects[i].HeaderRows; k <= sheetObjects[i].LastRow; k++) {
					if(Eqno == sheetObjects[i].CellValue(k,"rqst_eq_no")){
						sheetObjects[i].CellValue2(k,"ttl_lss_cmpl_cd") = cmplCd;
						sheetObjects[i].CellValue2(k,"ttl_lss_cmpl_dt") = cmplDt;
					}
				}
			}
		}
	}

	/**
	 * EQ No 값을 변경함에 따라 TP/SZ, DV.Value, Lessor 값을 재설정한다.
	 *
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		//EQ_TYPE 선택유무 체크
		var eqKndCd = sheetObj.CellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){
			ComShowCodeMessage("MNR00119");
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;
		}
		//EQ No 존재유무 체크
		var rqstEqNo 		= sheetObj.CellValue(Row, "rqst_eq_no");
		var eqKndCd 		= sheetObj.CellValue(Row, "eq_knd_cd");
		var totalLossDate	= ComGetNowInfo("ymd");
		var retArray = MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);

		if(sheetObj.id != "t2sheet1" && sheetObj.id != "t3sheet1") { // 3rd Party, Disposal 은 제외
			if(retArray == null){
				ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No."); // {?msg1} doesn\'t exist, Please check again
				sheetObj.CellValue2(Row,"rqst_eq_no") = "";
				sheetObj.SelectCell(Row, "rqst_eq_no");
				setEqNoInfoClear(sheetObj,Row,Col);
				return;
			}
		}
		//EQ No 관련 항목 조회
		var formObj = document.form;
		var sCostType = "";
		if(eqKndCd == "U"){
			sCostType = "MRDRRC";
		} else if(eqKndCd == "G"){
			sCostType = "MRGSRC";
		} else {
			sCostType = "MRZSRC";
		}
		var sXml = MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr == null){
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd 	= retArr[0][31];	//TP/SZ
		var dpcValAmt	= retArr[0][10];	//DV.Value
		var lessorNm	= retArr[0][16];	//Lessor
		var lstmCd		= retArr[0][19];	//Term
		var ydCd		= retArr[0][18];	//Yard

		//EQ No 관련 항목 설정
		sheetObj.CellValue2(Row,"eq_tpsz_cd") = eqTpszCd;	//TP/SZ
		sheetObj.CellValue2(Row,"lstm_cd") 		= lstmCd;  	//Term
		sheetObj.CellValue2(Row,"ttl_lss_yd_cd")= ydCd;  	//Yard
		if(sheetObj.id == "t1sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt")	= dpcValAmt;	//DV.Value
			sheetObj.CellValue2(Row,"lessor_nm") 	= lessorNm;  	//Lessor
			sheetObj.CellValue2(Row,"ttl_lss_bil_amt")  = dpcValAmt;  	//Pay Amount
			//Invoice No가 없을 경우
			var invNo = sheetObj.CellValue(Row, "inv_no");
			var ofcCd = formObj.rqst_ofc_cd.value;
			var yymm  = totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
				sheetObj.CellValue(Row, "inv_no") = invNo;
//			}
		} else if(sheetObj.id == "t2sheet1") { // 3rd Party
			sheetObj.CellValue2(Row,"dpc_val_amt") 	= dpcValAmt; 	//DV.Value
			//Invoice No가 없을 경우
			var invNo = sheetObj.CellText(Row, "inv_no");
			var ofcCd = formObj.rqst_ofc_cd.value;
			var yymm  = totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"T";
				sheetObj.CellText(Row, "inv_no") = invNo;
				sheetObj.CellValue(Row, "inv_no") = invNo;
//			}
		} else if(sheetObj.id == "t3sheet1") { // Disposal
			sheetObj.CellValue2(Row,"dpc_val_amt") 	= dpcValAmt; 	//DV.Value
			//Invoice No가 없을 경우
			var invNo = sheetObj.CellText(Row, "inv_no");
			var ofcCd = formObj.rqst_ofc_cd.value;
			var yymm  = totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"S";
				sheetObj.CellText(Row, "inv_no") = invNo;
				sheetObj.CellValue(Row, "inv_no") = invNo;
//			}
		} else if(sheetObj.id == "t5sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") 	= dpcValAmt; 	//DV.Value
		}
	}

	/**
	 * EQ No 존재하지 않을 때, 관련정보 삭제
	 *
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; //TP/SZ

		if(sheetObj.id == "t1sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
			sheetObj.CellValue2(Row,"lessor_nm") = "";   //Lessor
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
		}
	}

	/**
	 * Total Loss History 의 Row 추가
	 *
	 * @param sheetObj
	 * @return
	 */
	function history_Insert(sheetObj) {
		var Row = sheetObj.DataInsert(-1);
		if(historyMnrStsRefNo=="" || historyMnrStsRefNo==null){
			sheetObj.CellValue(Row, "mnr_sts_ref_no") = "NEW";
		} else {
			sheetObj.CellValue(Row, "mnr_sts_ref_no") = historyMnrStsRefNo;
		}
		sheetObj.CellValue(Row, "mnr_grp_tp_cd") = "SCR";
		sheetObj.CellValue(Row, "mnr_sts_dt") = ComGetNowInfo("ymd");
		sheetObj.CellValue(Row, "rqst_ofc_cd") = currOfcCd;
		sheetObj.CellValue(Row, "cre_usr_id") = usrId;

	}

	/**
	 * Total Loss History 의 Row 삭제
	 *
	 * @param sheetObj
	 * @return
	 */
    function history_Remove(sheetObj) {
    	ComRowHideDelete(sheetObj, "del_chk");
    }

	/**
	 * rep_Multiful_inquiry 사용시 받는부분
	 * 소스에 붙여서 사용하세요
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getMnr_Multi(rowArray,rtn_val) {
		var formObj = document.form;
		var tempText = "";
		//초기화
		formObj.in_ttl_lss_no.value = '';
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//마지막에 ,를 없애기 위함
		tempText = MnrDelLastDelim(tempText);

		tempText = tempText.toUpperCase();
		eval("document.form." + rtn_val + ".value = '" + tempText + "';");
	}
	/** 
	 * COMBO 변경 이벤트
	 *     Main Reason 변경시 Sub Reason 조회 및 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function ttl_lss_rsn_cd_OnChange(comboObj,Index_Code, Text){
		//Sub Reason 초기화
		var ttlLssDtlRsnCdObj = document.form.ttl_lss_dtl_rsn_cd;
		ttlLssDtlRsnCdObj.RemoveAll();	
		ttlLssDtlRsnCdObj.Code = "";  
	
		//Main Reason 체크
		if(Index_Code == "A" || Index_Code == "") {return;} 
	
		//Sub Reason 조회 및 설정
		ttlLssDtlRsnCdObj.RemoveAll();	
		var sCondition = new Array (
				new Array("MnrGenCd",Index_Code, "COMMON") 		
		)             
		sheetObjects[0].WaitImageVisible = false;
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].WaitImageVisible = true;
		for(var j = 0; j < comboList[0].length;j++){ 
			var tempText = comboList[0][j].split("|");    
			ttlLssDtlRsnCdObj.InsertItem(j, tempText[1] ,tempText[0]);
		}
		ttlLssDtlRsnCdObj.Index = 0;  
	}	

	/** 
	 * COMBO 변경 이벤트
	 *     Sub Reason 변경시 SCAC Code disable 설정(Trucker 일 경우만 입력 가능 설정) 
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */	
	function ttl_lss_dtl_rsn_cd_OnChange(comboObj,Index_Code, Text){
		sheetObjects[3].Redraw = false;
		if(("Trucker" == ComTrim(Text)) && ("Y" == currOfcUS)){
			// Trucker 일 경우, 입력 가능 설정
			for(var i=sheetObjects[3].HeaderRows; i<=sheetObjects[3].LastRow-1; i++){
				sheetObjects[3].CellEditable(i, "usa_edi_cd") = true;
				sheetObjects[3].CellBackColor(i, "usa_edi_cd") = -1;
			}			
		}else{	
			// Trucker 가 아닐경우, SCAC Code null 처리
			for(var i=sheetObjects[3].HeaderRows; i<=sheetObjects[3].LastRow-1; i++){
				sheetObjects[3].CellValue(i, "usa_edi_cd") = "";
				sheetObjects[3].CellEditable(i, "usa_edi_cd") = false;				
				sheetObjects[3].CellBackColor(i, "usa_edi_cd") = -1;
			}
		}
		sheetObjects[3].Redraw = true;
	}	
	
	/**
	 * IBSheet의 특정셀의 글자가 줄바꿈되어 한눈에 볼수 없을때 MemoPad를 이용하여 확인하거나 값을 변경할 때 사용한다. <br>
	 * MemoPad는 TextArea와 버튼으로 구성되며, 값을 확인하고 MemoPad를 닫을때는 ESC키를 누르거나 Close 버튼을 누르거나 HTML 영역을 클릭한다. <br>
	 * MemoPad가 표시될 위치의 셀은 반드시 편집불가능이어야 한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    function sheet1_OnClick(sheetObj, Row, Col, Value) {
	 *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj);
	 *    }
	 *    function sheet2_OnClick(sheetObj, Row, Col, Value) {
	 *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집불가능)
	 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj, Row, Col, true);
	 *    }
	 * </pre>
	 * @param {ibsheet} 	sheetObj    필수,IBSheet Object
	 * @param {int} 		row    		선택,MemoPad를 표시할 셀의 행 Index, default=sheetObj.SelectRow
	 * @param {int} 		col    		선택,MemoPad를 표시할 셀의 컬럼 Index, default=sheetObj.SelectCol
	 * @param {bool} 		bReadOnly	선택,MemoPad에 표시된 값의 편집가능 여부, default=true
	 * @param {int}    		iWidth		선택,MemoPad의 넓이, default=200
	 * @param {int}    		iHeight		선택,MemoPad의 높이, default=200
	 * @see #HideMemoPad
	 * @return 없음<br>
	 */
	//function ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax) {
	function ShowMemoPad(object) {
		try{
			//메모메드 만들기
			if (!initMemoPadThis(4000)) return;
			
			var bReadOnly = false;
			
	        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 CoCalendar.js 있는것을 사용함)
	        var iLeft = 85;
	        var iTop  = 168;
	        var iHeight = 350;
	        var iBottom = 0;
	        var iWidth = 605;
	        
	        //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
	        if (top.document != document && window.frameElement.scrolling=="no") {
	        	//높이초과
	        	if (iTop + iHeight  > document.body.clientHeight) {
	        		iBottom = iTop + sheetObj.RowHeight(row);
	        		if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;  
	        		iTop = iBottom-iHeight;
	        		if (iTop <0) iTop = 0
	        	}
	        	
	        	//넓이초과
	            if (iLeft + iWidth  > document.body.clientWidth)   {
	            	iLeft = document.body.clientWidth - iWidth;    
	            	if (iLeft<0) iLeft = 0;
	            }
	        }
	
	        var _divMemo = document.getElementById(MEMO_DIV_NAME_THIS);
	        var _frameDoc  = document.getElementById(MEMO_FRAME_NAME_THIS).contentWindow.document;
	
			_frameDoc.getElementById("btn_apply_this").style.display = (bReadOnly)?"none":"inline";
	        _frameDoc.getElementById(MEMO_TEXT_NAME_THIS).style.backgroundColor = bReadOnly?"#E8E7EC":"";
	        //_frameDoc.getElementById(MEMO_TEXT_NAME_THIS).style.fontFamily  = object.SheetFontName;
	        _frameDoc.getElementById(MEMO_TEXT_NAME_THIS).style.fontSize  = 11;
			_frameDoc.getElementById(MEMO_TEXT_NAME_THIS).style.height = iHeight-25;
	        _frameDoc.getElementById(MEMO_TEXT_NAME_THIS).value = object.value;
	        _frameDoc.getElementById(MEMO_TEXT_NAME_THIS).readOnly = bReadOnly;
	
			_divMemo.style.width = iWidth;
			_divMemo.style.height = iHeight;
	        _divMemo.style.top = iTop;
	        _divMemo.style.left = iLeft;
	        _divMemo.style.visibility = "visible";
	        _divMemo.focus();	
	
	        ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME_THIS));
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	/**
	 * 표시된 MemoPad를 강제로 닫을때 이 함수를 사용한다. <br>
	 * @param {bool} 	bFocus	선택,닫은 후 처음열었던 IBSheet로 포커스를 설정할지 여부, default=false
	 * @see #ComShowMemoPad
	 * @return 없음<br>
	 */
	function HideMemoPad(bFocus) {
		try {
	        if (document.getElementById(MEMO_DIV_NAME_THIS) == null)  return;
	        document.getElementById(MEMO_DIV_NAME_THIS).style.visibility = "hidden";
	
	        if (bFocus) {
	        	cng_pgm_desc.focus();	//포커스 하는 순간 이 함수가 또 호출되므로 sheetObj 변수로 다시 받았음
	        }
	    } catch(err) { ; }
	}
	
	/**
	 * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
	 * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
	 */
	function setMemoValueThis(sValue, iMax) {
		try {
			if(sValue.length > iMax){
				ComShowMessage("characters long");
	//			document.getElementById(MEMO_FRAME_NAME_THIS).focus();
				return;
			}else{
				//if (memoSheet == null) return;
				
				//memoSheet.CellValue2(memoRow, memoCol) = sValue;
				document.form.cng_pgm_desc.value = sValue;
				HideMemoPad(true);
			}
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	/**
	 * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
	 * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
	 */
	function initMemoPadThis(iMax) {
		try {
	        //메모용 Div가 없으면 생성한다.
	        if (document.getElementById(MEMO_DIV_NAME_THIS) != null) return true;
			
			//메모용 Div 만들기	        
	        var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME_THIS +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
	        document.body.insertBefore(_divMemo);
	
	        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
	        var _frameMemo = document.createElement("<IFRAME id='"+MEMO_FRAME_NAME_THIS+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
	        _divMemo.appendChild(_frameMemo);	        
	
	        var _FrameDoc = _frameMemo.contentWindow.document;
	
			//iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
	        var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.HideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
	        _FrameDoc.appendChild(_FrameDiv);
	        
			//Div안에 Textarea 만들기
	        var _area = _FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME_THIS +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
	        _FrameDiv.appendChild(_area);
	        
	        //Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
	        var _centerTag = _FrameDoc.createElement("<center>");
	        _FrameDiv.appendChild(_centerTag);
			
			//Apply 버튼 만들기
	        var _button1 = _FrameDoc.createElement("<span id='btn_apply_this' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValueThis(document.getElementById(\""+MEMO_TEXT_NAME_THIS+"\").value,"+iMax+");' />");
	        _button1.innerHTML = "Apply";
	        _centerTag.appendChild(_button1);
	        
			//Close 버튼 만들기
	        var _button2 = _FrameDoc.createElement("<span id='btn_close_this' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.HideMemoPad(true);' />");
	        _button2.innerHTML = "Close";
	        _centerTag.appendChild(_button2);
	        
	        //메모용 iFrame 자동 닫기 처리
	        if (document.onmouseup==null || document.onmouseup.toString().indexOf("HideMemoPad") < 0) {
		        //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
		        window.popupMemoOldEventListener = document.onmouseup;
		        if (window.popupMemoOldEventListener != null) {
		        	//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
		            //기존에 document.onmouseup에  정의된 함수가 있는 경우
		            document.onmouseup = new Function("window.popupMemoOldEventListener(); HideMemoPad();");
		        } else {
		            //기존에 document.onmouseup에  정의된 함수가 없는 경우
		            document.onmouseup = HideMemoPad;
		        }
		        
		        //ActiveX에 포커스가 갔을때 메모DiV 닫기
		        var objs = document.getElementsByTagName("OBJECT")
				window.popupMemoOldObjEventListener = new Array(objs.length);
		        for(var i = 0 ; i < objs.length ; i++){
			        window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
			        if (window.popupMemoOldObjEventListener[i] != null) {
			            //기존에 document.onmouseup에  정의된 함수가 있는 경우
			            objs[i].onfocus = new Function("window.popupMemoOldObjEventListener["+i+"](); HideMemoPad();");
			        } else {
			            //기존에 document.onmouseup에  정의된 함수가 없는 경우
			            objs[i].onfocus = HideMemoPad;
			        }
		        }
	        }
	    } catch(err) { ComFuncErrMsg(err.message); return false;}
	    return true;
	}
