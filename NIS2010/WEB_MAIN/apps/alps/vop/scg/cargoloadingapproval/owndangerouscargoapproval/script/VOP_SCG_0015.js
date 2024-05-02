/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0015.js
*@FileTitle : Dangerous CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.17
*@LastModifier : 정운
*@LastVersion : 1.0
* 2009.07.13 이도형
* 1.0 Creation
*=========================================================
*History
*2011.01.05 이행지 [CHM-201007766-01] [VO-SCG] 다수 SEQ. REJECT 시 RJT사유 입력 개선요청
*2011.01.12 이행지 [CHM-201108316-01] [SCG] Reject N(all)추가요청
*=========================================================
**=========================================================
*History
*2011.11.02 표준희 [CHM-201112981-01] [VO-SCG] 위험물 입력 관련 로직 변경 및 추가
*2012.07.05 이혜민 [CHM-201218535-01] [SCG] DG application 조회 화면에 package Q"ty/Type 의 정보 표시
*2012.07.06 조경완 [CHM-201218537-01] [VOP-SCG] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
*2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가 
*2014.01.17  정운   [CHM-201428537-01]	Pre-checking status의 컬럼의 값이 "X"일 때, 붉은색 표시
*=========================================================
*/

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
     * @class VOP_SCG_0015 : VOP_SCG_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0015() {
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

	var comboObjects = new Array();
	var comboCnt = 0;

   	var openerObj = window.dialogArguments;
   	var auth_length = 0;

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
    	var formObject = document.form;
    	/*******************************************************/

    	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

	 			case "btn_RouteDetail":
	 				onPopupClick(srcName);
	 				break;

	 			case "btn_UnInformation":
	 				onPopupClick(srcName);
	 				break;

	 			case "btn_Restrictions":
	 				onPopupClick(srcName);
	 				break;

	 			case "btn_Pre-CheckingReport":
	 				onPopupClick(srcName);
	 				break;

	 			case "btn_PackageQtyType":
	 				onPopupClick(srcName);
	 				break;

	 			case "btn_UnNo":
	 				onPopupClick(srcName);
	 				break;

	 			case "btn_OtherEmergencyInformation":
	 				onPopupClick(srcName);
	 				break;

                case "btn_AttachedFile":
 					onPopupClick(srcName);
                	break;

	            case "btn_ApprovalDetails":
	            	onPopupClick(srcName);
	            	break;
	
	            case "btn_Mail":
	            	sendReqMail(sheetObject2, formObject);
	            	break;
	
	            case "btn_Prev":
	            	onPopupClick(srcName);
	            	break;
	
	            case "btn_Next":
	            	onPopupClick(srcName);
	            	break;
	            	
	            case "btn_Irregular":
	            	onPopupClick(srcName);
	            	break;	
	
	            case "btn_Close":
					if (document.form.scg_flg.value=="DG1" || document.form.scg_flg.value=="DG2"){
						if (setParentValue()) window.close();
					}else{
						window.close();
					}
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj  = document.form;
 		auth_length = formObj.spcl_cgo_auth_cd.options.length;

    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
    	}

    	// IBMultiCombo초기화
    	for(var k=0; k<comboObjects.length; k++){
    		initCombo(comboObjects[k], k + 1);
    	}    	
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
    	loadPage2();
   	    
   	    searchIrrForUnNo(document.form.imdg_un_no.value);
    	//Irregular List 조회
    	
    }
    
    
    
    /**
     * Irregular List for Un No. 조회
     */
    var unData;
    function searchIrrForUnNo(imdg_un_no) {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	formObj.f_cmd.value = SEARCH07;
    	sheetObj.WaitImageVisible = false;	
 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0012GS.do", FormQueryString(formObj)); 	
 	   	sheetObj.WaitImageVisible = true;	
 	   	
 	    unData = ComScgXml2Array(sXml, "imdg_un_no");
 	
 	    var isChk = false;
 	    if(unData != null && unData.length > 0) {
	 	    for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
	 	    	if(imdg_un_no == unData[arrIdx]) isChk = true;
	 	    }
 	    } 
 	
 	    if(isChk) document.getElementById('btn_Irregular').style.color = "red";
 	}
    
    
    function loadPage2() {
    	var formObj  = document.form;
 		
        if (formObj.type.value == "P") {
    		document.getElementById("spcl_cgo_auth_cd").disabled = true;
    		//document.getElementById("spcl_cgo_auth_rmk").disabled = true;
    		document.getElementById("apro_ref_no").disabled = true;
 			document.getElementById("spcl_cgo_auth_cd").className = "input2";
 			document.getElementById("spcl_cgo_auth_rmk").className = "input";
 			document.getElementById("apro_ref_no").className = "input2";
        }
        
    	//html컨트롤 이벤트초기화
    	initControl();
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    	doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC01);
    	doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC02);
    	doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);//Booking Combine, Split 정보 조회
    	
    }

    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var shtID = sheetObj.id;

    	switch(shtID) {
    		case "sheet1":     
    			with (sheetObj) {

    				// 높이 설정
                    style.height = 102;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "TP/SZ|BKG Q'ty|DG Q'ty";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,		70,		daCenter,		false,		"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,		70,		daRight,		true,		"op_cntr_qty",		false,			"",      dfFloat,			2,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,		40,		daRight,		false,		"dcgo_qty",			false,			"",      dfFloat,			2,		false,		true);

                    CountPosition = 0;
    			}
                break;

    		case "sheet2":      //sheet2 init
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
                	Editable = false;

                	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                	InitRowInfo(1, 1, 4, 100);

                	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(57, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, true, true, false,false)

                	var HeadTitle1 = "|Seq||Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no|dg_cgo_seq" +
                					 "|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm|hzd_desc" +
                					 "|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|hcdg_flag|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4" +
                					 "|dcgo_sts_cd|mrn_polut_flg|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt|rada_ut_cd" +
                					 "|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk||meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_dpnd_qty_flg|spcl_rqst_flg|spcl_rqst_desc|rc_seq|awk_cgo_seq|dg_cntr_seq";
                	
                	var HeadTitle1 = "|Seq||Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no|dg_cgo_seq" +
                					 "|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm|hzd_desc" +
                					 "|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|hcdg_flag|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4" +
                					 "|dcgo_sts_cd|mrn_polut_flg|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt|rada_ut_cd" +
                					 "|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk||meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_dpnd_qty_flg|dg_cntr_seq";

                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle1, true);

                	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 	InitDataProperty(0, cnt++,  dtHidden, 			20,		daCenter, 		true, 	"DelChk");
                    InitDataProperty(0, cnt++ , dtDataSeq,			30,		daCenter,		false,	"seq");
                    InitDataProperty(0, cnt++,  dtHiddenStatus,		20,     daCenter,    	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"cntr_no",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				20,		daCenter,		false,	"cntr_tpsz_cd",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,		false,	"cntr_vol_qty",			false,			"",      dfFloat,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,		false,	"spcl_cgo_apro_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,		true,	"cargo_nm",				false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,		true,	"cargo_seq",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"bkg_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"dg_cgo_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"cntr_cgo_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_clss_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_comp_grp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_un_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_un_no_seq",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,		true,	"grs_wgt",				false,			"",      dfFloat,			2,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"wgt_ut_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,		true,	"net_wgt",				false,			"",      dfFloat,			2,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"prp_shp_nm",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"hzd_desc",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"flsh_pnt_cdo_temp",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_pck_grp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"psa_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_lmt_qty_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_expt_qty_flg",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"hcdg_flg",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_subs_rsk_lbl_cd1",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_subs_rsk_lbl_cd2",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_subs_rsk_lbl_cd3",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"imdg_subs_rsk_lbl_cd4",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"dcgo_sts_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"mrn_polut_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"emer_cntc_phn_no_ctnt",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"emer_cntc_pson_nm",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"certi_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"cnee_dtl_desc",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"net_explo_wgt",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"rada_skd_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"rada_amt",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"rada_ut_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"rada_trsp_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"clod_flg",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"cgo_lcl_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"diff_rmk",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"meas_qty",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"rc_flg",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"awk_cgo_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"bb_cgo_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"hcdg_dpnd_qty_flg",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"spcl_rqst_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"spcl_rqst_desc",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"rc_seq",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"awk_cgo_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"dg_cntr_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"dcgo_seq",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,	"approved",				false,			"",      dfNone,			0,		false,		true);

                	CountPosition = 0;
                }
                break;

    		case "sheet3":      //sheet3 init
    			with (sheetObj) {
    	
                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
                    
                    var HeadTitle1 = "bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|crr_pre_chk_cd|opr_pre_chk_cd|segr_pre_chk_cd|pck_pre_chk_cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		"bkg_no",			false,			"",      dfNone,			0,		false,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"bl_no",			false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"vsl_cd",			false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"pol_cd",			false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"pol_nod_cd",		false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"pod_cd",			false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"pod_nod_cd",		false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"bkg_sts_cd",		false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"corr_n1st_dt",		false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"bdr_flg",			false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,		false,		"crr_pre_chk_cd",	false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,		false,		"opr_pre_chk_cd",	false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,		false,		"segr_pre_chk_cd",	false,			"",      dfNone,			2,		true,		true);
	   				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,		false,		"pck_pre_chk_cd",	false,			"",      dfNone,			2,		true,		true);
	   				
	   				CountPosition = 0;
    			}
                break;
                
    		case "sheet4":      //sheet3 init
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
                	InitRowInfo(1, 1, 4, 100);

                	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(96, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                	var HeadTitle1 = "|||Seq|Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no" +
                					 "|dg_cgo_seq|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|grs_capa_qty|prp_shp_nm" +
                					 "|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3" +
                					 "|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_mrn_polut_cd|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt" +
                					 "|rada_ut_cd|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk|bkg_cntr_seq|in_imdg_pck_cd1|in_imdg_pck_cd2|out_imdg_pck_cd1" +
                					 "|out_imdg_pck_cd2|in_imdg_pck_desc1|in_imdg_pck_desc2|out_imdg_pck_desc1|out_imdg_pck_desc2|in_imdg_pck_qty1|in_imdg_pck_qty2|out_imdg_pck_qty1|out_imdg_pck_qty2|max_in_pck_qty" +
                					 "|max_in_pck_tp_cd|hcdg_intmd_bc_rstr_desc|hcdg_pck_rstr_desc|hcdg_tnk_rstr_desc|ltd_qty|ems_no|emer_rspn_gid_no|emer_rspn_gid_chr_no|ctrl_temp_ctnt|emer_temp_ctnt" +
                					 "|dcgo_seq|modifyaproflg|dg_cntr_seq|meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_flg|hcdg_qty|hcdg_dpnd_qty_flg|stwg_temp_ctnt|||||";                 
                      					

                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle1, true);

                	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++,  dtDummyCheck, 	20,		daCenter, 		false, 		"CntrChk"); 
                	InitDataProperty(0, cnt++,  dtDummyCheck,	20,		daCenter, 		false, 		"DelChk");
                	InitDataProperty(0, cnt++,  dtStatus,  		20,     daCenter,    	false,   	"ibflag");
                	InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,		false,		"seq");
                	InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"cntr_no",				false,			"",      dfNone,			0,		true,		true);
                	InitDataProperty(0, cnt++ , dtData,			20,		daCenter,		false,		"cntr_tpsz_cd",			false,			"",      dfNone,			0,		true,		true);
                	InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		false,		"cntr_vol_qty",			false,			"",      dfFloat,			0,		true,		true);
                	InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		"spcl_cgo_apro_cd",		false,			"",      dfNone,			0,		false,		false);
                	InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"",						false,			"",      dfNone,			0,		false,		false);
                	InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"",						false,			"",      dfNone,			0,		false,		false);
                	InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"bkg_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"dg_cgo_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"cntr_cgo_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_clss_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_comp_grp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_un_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_un_no_seq",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"grs_wgt",				false,			"",      dfFloat,			3,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"wgt_ut_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"net_wgt",				false,			"",      dfFloat,			3,		false,		true);

					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"grs_capa_qty",			false,			"",      dfFloat,			3,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"prp_shp_nm",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hzd_desc",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"flsh_pnt_cdo_temp",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_pck_grp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"psa_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_lmt_qty_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_expt_qty_flg",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_subs_rsk_lbl_cd1",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_subs_rsk_lbl_cd2",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_subs_rsk_lbl_cd3",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_subs_rsk_lbl_cd4",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"dcgo_sts_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"mrn_polut_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_mrn_polut_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"emer_cntc_phn_no_ctnt",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"emer_cntc_pson_nm",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"certi_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"cnee_dtl_desc",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"net_explo_wgt",		false,			"",      dfFloat,			1,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"rada_skd_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"rada_amt",				false,			"",      dfFloat,			2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"rada_ut_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"rada_trsp_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"clod_flg",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"cgo_lcl_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"diff_rmk",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"bkg_cntr_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"in_imdg_pck_cd1",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"in_imdg_pck_cd2",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"out_imdg_pck_cd1",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"out_imdg_pck_cd2",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"intmd_imdg_pck_cd1",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"intmd_imdg_pck_cd2",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"in_imdg_pck_desc1",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"in_imdg_pck_desc2",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"out_imdg_pck_desc1",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"out_imdg_pck_desc2",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"intmd_imdg_pck_desc1",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"intmd_imdg_pck_desc2",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"in_imdg_pck_qty1",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"in_imdg_pck_qty2",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"intmd_imdg_pck_qty1",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"intmd_imdg_pck_qty2",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"out_imdg_pck_qty1",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"out_imdg_pck_qty2",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"max_in_pck_qty",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"max_in_pck_tp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hcdg_intmd_bc_rstr_desc",	false,		"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hcdg_pck_rstr_desc",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hcdg_tnk_rstr_desc",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"ltd_qty",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"ems_no",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"emer_rspn_gid_no",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"emer_rspn_gid_chr_no",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"ctrl_temp_ctnt",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"emer_temp_ctnt",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"dcgo_seq",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"modifyaproflg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"dg_cntr_seq",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"meas_qty",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"rc_flg",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"awk_cgo_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"bb_cgo_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hcdg_flg",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hcdg_qty",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"hcdg_dpnd_qty_flg",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_spcl_provi_no",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_crr_rstr_expt_cd",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"spcl_rqst_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"spcl_rqst_desc",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"imdg_expt_qty_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,         50,     daCenter,       true,       "hzd_ctnt",             false,          "",      dfNone,            0,      false,      true);
					InitDataProperty(0, cnt++ , dtData,         50,     daCenter,       true,       "stwg_temp_ctnt",       false,          "",      dfNone,            0,      false,      true);
					//Pre-Checking을 위한 컬럼 추가
                	InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"spcl_cgo_seq",			false,			"",      dfNone,			0,		false,		true);                	
                	InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"spcl_cntr_seq",		false,			"",      dfNone,			0,		false,		true);

                	CountPosition = 0;
    			}
                break;
                
			case "sheet5":      //sheet3 init
    			with (sheetObj) {

					// 높이 설정
					style.height = 100;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "|value|name";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtDummyCheck, 	20,		daCenter, 		false,	"DelChk"); 						
					InitDataProperty(0,	cnt++ , dtData,			110,	daCenter,		true,	"val",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0,	cnt++ , dtData,			100,	daCenter,		true,	"name",			false,		"",		dfNone,			0,		true,		true); 
					InitDataProperty(0,	cnt++ , dtData,			100,	daCenter,		true,	"cntr_tpsz_cd",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0,	cnt++ , dtData,			100,	daCenter,		true,	"cntr_vol_qty",	false,		"",		dfNone,			0,		true,		true);
					
					CountPosition = 0;
    		}
			break; 
    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

	     	case IBSEARCH_ASYNC01: //RJT CD 조회
	     		formObj.f_cmd.value = SEARCH;
	     		
	     		//파라미터 명시적인 생성
	 			var formParams = "";
	     		formParams += "f_cmd="+ComGetObjValue(formObj.f_cmd);
	     		
	     		var sXml = sheetObj.GetSearchXml("VOP_SCG_0031GS.do", formParams+"&spcl_cgo_cate_cd=DG");
				ComXml2ComboItem(sXml, formObj.spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
				break;

     		case IBSEARCH_ASYNC02: //Rqst 조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0015GS.do", FormQueryString(formObj));
         		var arrData = ComScgXml2Array(sXml, "rqst_usr_nm");
         		if (arrData != null && arrData.length > 0) {
					document.getElementById("rqst_usr_nm").innerText = ComScgXml2Array(sXml, "rqst_usr_nm");
					document.getElementById("rqst_usr_id").innerText = ComScgXml2Array(sXml, "rqst_usr_id");
					document.getElementById("rqst_ofc_cd").innerText = ComScgXml2Array(sXml, "rqst_ofc_cd");
					document.getElementById("rqst_gdt").innerText 	 = ComScgXml2Array(sXml, "rqst_gdt");
					document.getElementById("rqst_usr_phn_no").innerText = ComScgXml2Array(sXml, "rqst_usr_phn_no");
					document.getElementById("rqst_usr_eml").innerText = ComScgXml2Array(sXml, "rqst_usr_eml");
         		}
				break;

     		case IBSEARCH_ASYNC03: //Attached File 조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0207GS.do", FormQueryString(formObj)+"&bkg_no="+formObj.bkg_no.value+"&ridr_tp_cd=D");
				if(sXml.indexOf("TOTAL='0'") < 1) {
					document.getElementById("btn_AttachedFile").style.color = "red";
				}else{
					document.getElementById("btn_AttachedFile").style.color = "";
				}
				break;

     		case IBSEARCH:      //조회
				if (formObj.scg_flg.value=="DG1") {
					oSheetObj = openerObj.sheetObjects[1];
				}else if (formObj.scg_flg.value=="SCG_DG"){
					oSheetObj = openerObj.sheetObjects[0];
			    	formObj.spcl_cgo_auth_rmk.disabled = true;
			    	formObj.spcl_cgo_auth_rmk.className = "input2";
				}else if (formObj.scg_flg.value=="DG2"){
					oSheetObj = openerObj.sheetObjects[2];
				}
				
				var spcl_cgo_auth_cd = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd");
				
				if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd") == 'Y' ) {
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;
//			    	formObj.spcl_cgo_auth_cd.options[0].selected = true;
			    	formObj.spcl_cgo_auth_cd.value = spcl_cgo_auth_cd;
			    	comboObjects[1].Enable = false;
			    	//formObj.spcl_cgo_auth_rmk.disabled = true;
			    	formObj.spcl_cgo_auth_rmk.value = "";
			    	//formObj.spcl_cgo_auth_rmk.className = "input";
			    	if (oSheetObj.CellText(oSheetObj.SelectRow, "apro_ref_no") != "") {
				    	formObj.apro_ref_no.disabled = false;
				    	formObj.apro_ref_no.className = "input";			    		
			    	}
			    	formObj.apro_ref_no.value = oSheetObj.CellText(oSheetObj.SelectRow, "apro_ref_no");
			    	formObj.spcl_cgo_auth_rmk.value = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rmk");
				}else if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd") == 'N' ) {
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;
//			    	formObj.spcl_cgo_auth_cd.options[2].selected = true;
			    	formObj.spcl_cgo_auth_cd.value = spcl_cgo_auth_cd;
			    	if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="DG2") {
				    	comboObjects[1].Enable = true;
				    	//formObj.spcl_cgo_auth_rmk.disabled = false;
				    	//formObj.spcl_cgo_auth_rmk.className = "input";
				    	if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className = "input1";
				    	}
			    	}
			    	comboObjects[1].Code2 = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd");
			    	formObj.spcl_cgo_auth_rmk.value = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rmk");
				}else if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd") == 'P') {
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;
//			    	formObj.spcl_cgo_auth_cd.options[3].selected = true;
			    	formObj.spcl_cgo_auth_cd.value = spcl_cgo_auth_cd;
			    	if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="DG2") {
				    	comboObjects[1].Enable = true;
				    	comboObjects[1].BackColor = "#FFFFFF";
				    	//formObj.spcl_cgo_auth_rmk.disabled = false;
				    	//formObj.spcl_cgo_auth_rmk.className = "input";
				    	if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className = "input1";
				    	}
			    	}
			    	comboObjects[1].Code2 = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd");
			    	formObj.spcl_cgo_auth_rmk.value = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rmk");
				}else{
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length;
			    	formObj.spcl_cgo_auth_cd.options[auth_length-1].text = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd");
			 		formObj.spcl_cgo_auth_cd.options[auth_length-1].style.color = "orange";
			    	formObj.spcl_cgo_auth_cd.options[auth_length-1].selected = true;
			    	comboObjects[1].Enable = false;
			    	//formObj.spcl_cgo_auth_rmk.disabled = true;
			    	formObj.spcl_cgo_auth_rmk.value = "";
			    	//formObj.spcl_cgo_auth_rmk.className = "input";
				}
				
				document.getElementById("pol_cd").innerText = oSheetObj.CellValue(oSheetObj.SelectRow, "pol_cd");
				document.getElementById("pod_cd").innerText = oSheetObj.CellValue(oSheetObj.SelectRow, "pod_cd");
				document.getElementById("pol_nod_cd").value = oSheetObj.CellValue(oSheetObj.SelectRow, "pol_yd_cd").substring(5,7);
				document.getElementById("pod_nod_cd").value = oSheetObj.CellValue(oSheetObj.SelectRow, "pod_yd_cd").substring(5,7);
		        //Route Detail 팝업을 띄우기위한 데이타 셋팅
				document.getElementById("bkg_pol_yd_cd").value = oSheetObj.CellValue(oSheetObj.SelectRow, "pol_yd_cd");
				document.getElementById("bkg_pod_yd_cd").value = oSheetObj.CellValue(oSheetObj.SelectRow, "pod_yd_cd");
     			
				if(validateForm(sheetObj,formObj,sAction))
     				formObj.f_cmd.value = SEARCH;

					var resultXml = sheetObj.GetSearchXml("ESM_BKG_0200GS.do", FormQueryString(formObj)); 	         	 
					var arrXml = resultXml.split("|$$|");
					
					
	
					if (arrXml.length == 6) {
						var etcXml = arrXml[0];

						if(formObj.bkg_no.value == formObj.old_bkg_no.value){
							sheetObjects[0].WaitImageVisible = false;
							sheetObjects[1].WaitImageVisible = false;
						}else{
							sheetObjects[0].WaitImageVisible = true;
							sheetObjects[1].WaitImageVisible = true;
						}
						
						if(formObj.bkg_no.value != formObj.old_bkg_no.value){
							sheetObjects[0].LoadSearchXml(arrXml[2], false);
							sheetObjects[1].LoadSearchXml(arrXml[0], false);
						}
						sheetObjects[2].LoadSearchXml(arrXml[3], false);
						sheetObjects[3].LoadSearchXml(arrXml[1], false);
						sheetObjects[4].LoadSearchXml(arrXml[4], false);
						
						sheetObjects[1].ColHidden("tempSeq") = true;
						
						if(document.getElementById("bkg_no").value == ""){
							document.getElementById("bkg_no").value = sheetObjects[2].CellValue(1, "bkg_no");
						}
						
						document.getElementById("bl_no").value = sheetObjects[2].CellValue(1, "bl_no");

						cntrChk();

						var cnt = 0;
						for (var i=1; i <= sheetObjects[1].RowCount; i++){							
							if(sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "Y"){
								cnt++;
							}
							
							var tpszN2 = 0;
							var tpszP2 = 0;
							var tpszR2 = 0;
							var tpszY2 = 0;
							for(var k=1; k <= sheetObjects[3].RowCount; k++){							
								if(sheetObjects[1].CellValue(i, "cntr_no") == sheetObjects[3].CellValue(k, "cntr_no") && sheetObjects[1].CellValue(i, "dg_cntr_seq") == sheetObjects[3].CellValue(k, "dg_cntr_seq")){
									if(sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "Y"){
										tpszY2++;
									}else if(sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "N"){
										tpszN2++;
									}else if(sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "P"){
										tpszP2++;
									}else if(sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "R"){
										tpszR2++;
									}else{
										 
									}
								}
							}
							 
							if(tpszN2 > 0){
								sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "N";
							}
							if(tpszP2 > 0 && tpszN2 == "0"){
								sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "P";
							}
							if(tpszR2 > 0 && tpszN2 == "0" && tpszP2 == "0"){
								sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "R";
							}
							if(tpszY2 > 0 && tpszR2 == "0" && tpszN2 == "0" && tpszP2 == "0"){							
								sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "Y";						
							}
							if(tpszY2 == 0 && tpszR2 == 0 && tpszN2 == 0 && tpszP2 == 0){							
								sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "";							
							}
							if(sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "N"){
								sheetObjects[1].CellFontColor(i, "spcl_cgo_apro_cd") = sheetObjects[1].RgbColor(255, 0, 0);									
							}
							
							setAuthStat(sheetObjects[1], i);							
						}
						
						htmlSheetSync();

						//Attached File 조회
				        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
				        
					    //pre-checking summary setting: BKG 단위로 조회하며 CARGO 별로 한개라도 있으면 X
				        if(sheetObjects[2].CellValue(1, "crr_pre_chk_cd") == "X"){
				        	ComSetObjValue(formObj.pre_crr, "X");
				        	changeObjectColor(formObj.pre_crr.value, "X", "pre_crr", "red", "input2");
				        }else if(sheetObjects[2].CellValue(1, "crr_pre_chk_cd") == "R"){
				        	ComSetObjValue(formObj.pre_crr, "△");
				        	changeObjectColor(formObj.pre_crr.value, "△", "pre_crr", "blue", "input2");
				        }else{
				        	ComSetObjValue(formObj.pre_crr, "O");
				        }
				        if(sheetObjects[2].CellValue(1, "opr_pre_chk_cd") == "X"){
				        	ComSetObjValue(formObj.pre_opr, "X");
				        	changeObjectColor(formObj.pre_opr.value, "X", "pre_opr", "red", "input2");
				        }else if(sheetObjects[2].CellValue(1, "opr_pre_chk_cd") == "R"){
				        	ComSetObjValue(formObj.pre_opr, "△");
				        	changeObjectColor(formObj.pre_opr.value, "△", "pre_opr", "blue", "input2");
				        }else{
				        	ComSetObjValue(formObj.pre_opr, "O");
				        }
				        if(sheetObjects[2].CellValue(1, "segr_pre_chk_cd") == "X"){
				        	ComSetObjValue(formObj.pre_sgr, "X");
				        }else{
				        	ComSetObjValue(formObj.pre_sgr, "O");
				        }
				        if(sheetObjects[2].CellValue(1, "pck_pre_chk_cd") == "X" ){
				        	ComSetObjValue(formObj.pre_pck, "X");
				        }else if(sheetObjects[2].CellValue(1, "pck_pre_chk_cd") == "M" ){
				        	ComSetObjValue(formObj.pre_pck, "M");
				        }else{
				        	ComSetObjValue(formObj.pre_pck, "O");
				        }
				        
						// Pre-Checking Status의 컬럼들이 'X'이면 붉은색으로 표시
//						changeObjectColor(formObj.pre_crr.value, "X", "pre_crr", "red", "input2");
//						changeObjectColor(formObj.pre_opr.value, "X", "pre_opr", "red", "input2");
						changeObjectColor(formObj.pre_pck.value, "X", "pre_pck", "red", "input2");
						changeObjectColor(formObj.pre_sgr.value, "X", "pre_sgr", "red", "input2");
//						changeObjectColor(formObj.pre_crr.value, "△", "pre_crr", "blue", "input2");
//						changeObjectColor(formObj.pre_opr.value, "△", "pre_opr", "blue", "input2");
				        
					}		     			
					break;
					
     		case SEARCH01:

				if(formObj.bkg_no.value == formObj.old_bkg_no.value){
					sheetObj.WaitImageVisible = false;
				}else{
					sheetObj.WaitImageVisible = true;
				}
     			
     			if (validateForm(sheetObj, formObj, sAction))
     				formObj.f_cmd.value = SEARCH01;
     			var sXml = sheetObj.GetSearchXml("ESM_BKG_0200GS.do", FormQueryString(formObj));
     			
     			var arrXml = sXml.split("|$$|");

     			ComXml2ComboItem(arrXml[0], formObj.elements["hzd_ctnt"], "imdg_segr_grp_nm", "imdg_segr_grp_nm");
     			
     		  	break;
     		  	
     		case SEARCH02:
     			
				if(formObj.bkg_no.value == formObj.old_bkg_no.value){
					sheetObj.WaitImageVisible = false;
				}else{
					sheetObj.WaitImageVisible = true;
				}
     			
     			if (validateForm(sheetObj, formObj, sAction))
     				formObj.f_cmd.value = SEARCH15;
     			var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", "f_cmd="+SEARCH15+"&bkgNo="+formObj.bkg_no.value);
     			var bkgCombine = ComGetEtcData(sXml, "bkg_combine");
     			var bkgSplit = ComGetEtcData(sXml, "bkg_split");
     			formObj.bkg_combine.value = bkgCombine;
     			formObj.bkg_split.value = bkgSplit;
     			break;
    	}
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
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "Class 1 Only" , -1 );
                     InsertTab( cnt++ , "Class 7 Only" , -1 );
                     BaseColor = "243,242,248";
                 }
              break;
          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs = document.all.item("tabLayer");
         objs[nItem].style.display = "Inline";
         objs[beforetab].style.display = "none";
         //--------------- 요기가 중요 --------------------------//
         objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab= nItem;
     }

     //업무 자바스크립트 OnKeyPress 이벤트 Catch
     function initControl() {
      	axon_event.addListener('click', 	'auth_OnClick', 'spcl_cgo_auth_cd');
     	axon_event.addListener('change', 	'auth_OnChange', 'spcl_cgo_auth_cd');
     }

     /**
      * Combo 기본 설정
      * Combo의 항목을 설정한다.
      */
     function initCombo(comboObj, comboNo) {
 	    switch(comboObj.id) {
 	        case "spcl_cgo_auth_rjct_cd":
 	            with(comboObj) {
    	  			SetColAlign("center|left");
    	  			SetColWidth("50|500");
    	  			SetTitle("Code|Description");
 	            	DropHeight = 190;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 	            	MaxLength = 3;	//최대입력문자 3자리
 	            	IMEMode = 0;	//초기 한영전환키가 영문
 	            	ValidChar(2,0);	//영문 대문자만 입력
 	            }
 	            break;
 	        
 	        case "hzd_ctnt": 
 	           with(comboObj) {
	  			   DropHeight = 200;
	  			   //Enable = true;
	               initCombo_hzd_ctnt();
	            }
 	            break;
 	      
 	         
 	    }
     }
     
     function initCombo_hzd_ctnt() {

      	with (form.hzd_ctnt) {
      		MultiSelect = true; 
      		MultiSeparator="|";
      	}      
     }
     
     
     function hzd_ctnt_OnCheckClick(comboObj, index, code){

    	 if(comboObj.CheckIndex(index)){
    		 
    		comboObj.CheckIndex(index) = false;
    	 }else{
    		comboObj.CheckIndex(index) = true;
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

     function setAuthStat(sheetObj, row)
     {
     	with(sheetObj)
     	{
     		var auth = CellText(row, "spcl_cgo_apro_cd").substring(0,1);
     		CellFont("FontBold", row, "spcl_cgo_apro_cd") = true;
			switch(auth)
			{
				case "R":
					CellFontColor(row, "spcl_cgo_apro_cd") = RgbColor(255, 134, 43);
					break;
					
				case "Y":
					CellFontColor(row, "spcl_cgo_apro_cd") = RgbColor(77, 150, 75);
					break;
					
				case "N":
					CellFontColor(row, "spcl_cgo_apro_cd") = RgbColor(255, 0, 0);
					break;
					
				case "P":
					CellFontColor(row, "spcl_cgo_apro_cd") = RgbColor(38, 99, 224);
					break;
			}
     	}    	
     }     
    
     function auth_OnChange() {
 		var obj      = event.srcElement;
 		var formObj  = document.form;

 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;

 		if (obj.value == "N" || obj.value == "" || obj.value == "M") {
 			comboObjects[1].Code = "";
   			comboObjects[1].Enable = true;
	    	comboObjects[1].BackColor = "#CCFFFD";
   			//formObj.spcl_cgo_auth_rmk.disabled = false;
   			//formObj.spcl_cgo_auth_rmk.className = "input";
   			formObj.spcl_cgo_auth_rmk.value = "";
   			formObj.apro_ref_no.value = "";
    		document.getElementById("apro_ref_no").disabled = true;
 			document.getElementById("apro_ref_no").className = "input2";
 		}else if (obj.value == "P") {
   			comboObjects[1].Code = "";
 			comboObjects[1].Enable = true;
 			comboObjects[1].BackColor = "#FFFFFF";
 			//formObj.spcl_cgo_auth_rmk.disabled = false;
 			//formObj.spcl_cgo_auth_rmk.className = "input";
   			formObj.spcl_cgo_auth_rmk.value = "";
 			formObj.apro_ref_no.value = "";
 			document.getElementById("apro_ref_no").disabled = true;
 			document.getElementById("apro_ref_no").className = "input2";
 		}else{
   			comboObjects[1].Code = "";
   			comboObjects[1].Enable = false;
   			formObj.spcl_cgo_auth_rmk.value = "";
   			//formObj.spcl_cgo_auth_rmk.disabled = true;
   			//formObj.spcl_cgo_auth_rmk.className = "input";
   			
	    	if (formObj.scg_flg.value=="DG1" && openerObj.sheetObjects[1].CellText(openerObj.sheetObjects[1].SelectRow, "crr_code") != "SML" && (obj.value == "A" || obj.value == "Y")) {
	    		document.getElementById("apro_ref_no").disabled = false;
	    		document.getElementById("apro_ref_no").className = "input";
	    	}else if (formObj.scg_flg.value=="DG2" && openerObj.sheetObjects[2].CellText(openerObj.sheetObjects[2].SelectRow, "crr_code") != "SML" && (obj.value == "A" || obj.value == "Y")) {
	    		document.getElementById("apro_ref_no").disabled = false;
	 			document.getElementById("apro_ref_no").className = "input";
	    	}
 		}
     }

     function spcl_cgo_auth_rjct_cd_OnChange(comboObj, code, text) {	
  		var formObj   = document.form;
		if (code == "AAA") {
 			document.getElementById("spcl_cgo_auth_rmk").className = "input1";
			formObj.spcl_cgo_auth_rmk.value = '';			
		}else{
 			document.getElementById("spcl_cgo_auth_rmk").className = "input";
			formObj.spcl_cgo_auth_rmk.value = comboObj.GetText(code, 1);
		}
		
     }
     /**
      * Sheet관련 컬럼 sheet2_OnClick 엑션 이벤트 처리 
      * @param sheetObj, Row, Col, Value
      */
     function sheet2_OnClick(sheetObj, row, col, val) {
     htmlSheetSync();
    
     }
     
     function sheet2_OnSearchEnd(sheetObj, Row, Col, Value) {
    	 var cntSeq = 0;
    	 sheetObjects[1].ColumnSort("dg_cntr_seq|cargo_seq","ASC");
    	 
    	 for(var i=1; i<=sheetObjects[0].RowCount; i++){
    		 if(Number(sheetObjects[0].CellValue(i, "dcgo_qty")) < 1){
    			 for(var j=1; j<=sheetObjects[1].RowCount; j++){
    				 if(sheetObjects[0].CellValue(i, "cntr_tpsz_cd") == sheetObjects[1].CellValue(j, "cntr_tpsz_cd")){
    					 sheetObjects[1].CellValue2(j, "cntr_vol_qty") = Number(sheetObjects[0].CellValue(i, "dcgo_qty"));
    				 }
    			 }
    		 }
    	 }
    	 
    	 for(var i=1; i<=sheetObjects[1].RowCount; i++){
    		 if (sheetObjects[1].CellValue(i, "dg_cntr_seq") == document.getElementById("dg_cntr_seq").value) {
    			 sheetObjects[1].SelectCell(i, "cntr_no");
    		 }

    		 if(sheetObjects[1].CellValue(i, "rc_seq") != ""){							
    			 sheetObjects[1].CellValue2(i, "cargo_nm") = "RF";
    			 sheetObjects[1].CellValue2(i, "cargo_seq") = sheetObjects[1].CellValue(i, "rc_seq");							
    		 }else if(sheetObjects[1].CellValue(i, "awk_cgo_seq") != ""){
				sheetObjects[1].CellValue2(i, "cargo_nm") = "AWK";
				sheetObjects[1].CellValue2(i, "cargo_seq") = sheetObjects[1].CellValue(i, "awk_cgo_seq");
    		 }else{
    			 cntSeq++;
    		 }

    		 if(cntSeq == sheetObjects[1].RowCount){
    			 sheetObjects[1].ColHidden("cargo_nm") = true;
    			 sheetObjects[1].ColHidden("cargo_seq") = true;
    		 }

    		 var cntr_no = sheetObjects[1].CellValue(j, "cntr_no");
    		    		 if(cntr_no != ""){
    			 var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2); 									
    			 sheetObjects[4].CellValue2(find_row, "DelChk") = "1";  
    		 
    		 }
    	 }
     }
     
//     function sheet3_OnSearchEnd(sheetObj, Row, Col, Value) {
//    	 for (var j=1; j<=sheetObjects[2].RowCount; j++){
//    		 sheetObjects[2].CellValue(j, "bkg_vvd_cd") = sheetObjects[2].CellValue(j, "vsl_cd")
//    	 }
//     }

     function sheet4_OnSearchEnd(sheetObj,formObj, Row, Col, Value) {
    	//Pre-Checking을 위한 컬럼에 값을 셋팅한다.
    	 for (var j=1; j<=sheetObjects[3].RowCount; j++){
    		 sheetObjects[3].CellValue(j, "spcl_cgo_seq") = sheetObjects[3].CellValue(j, "cntr_cgo_seq");
    		 sheetObjects[3].CellValue(j, "spcl_cntr_seq") = sheetObjects[3].CellValue(j, "dg_cntr_seq");
    	 }
    }
     
     function cntrChk(){
    	 Row = sheetObjects[1].SelectRow; 
    	 var cnt=0;
    	 for(var i=1; i<=sheetObjects[3].RowCount; i++){
    	 	 
    		 if(sheetObjects[1].CellValue(Row, "cntr_no") != ""){
    			 if(sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no") 
    				&& 
    				sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(Row, "dg_cntr_seq") 
    				&& sheetObjects[3].CellValue(i, "ibflag") != "D"){		
    				 sheetObjects[3].CellValue2(i, "CntrChk") = "1";
    			 }else if(sheetObjects[3].CellValue(i, "cntr_no") == "" 
    				 && sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(Row, "dg_cntr_seq") 
    				 && sheetObjects[3].CellValue(i, "ibflag") != "D"){		
        				 sheetObjects[3].CellValue2(i, "CntrChk") = "1";
    			 }else{
    				 sheetObjects[3].CellValue2(i, "CntrChk") = "0";
    			 }
    		 }else{
    			 if(sheetObjects[1].CellValue(Row, "cntr_no") == "" 
    				 && sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no") 
    				 && sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(Row, "dg_cntr_seq") 
    				 && sheetObjects[3].CellValue(i, "ibflag") != "D"){
    				 sheetObjects[3].CellValue2(i, "CntrChk") = "1";
    			 }else{
    				 sheetObjects[3].CellValue2(i, "CntrChk") = "0";
    			 }
    		 }
    		 if(sheetObjects[3].CellValue(i, "CntrChk") == "1"){				
    			 var cntr_cgo_seq = sheetObjects[3].CellValue(i, "cntr_cgo_seq");
    			 cnt++;								
    		 }
    		 sheetObjects[3].CellValue2(i, "bkg_cntr_seq") = sheetObjects[3].CellValue(i, "dg_cntr_seq")+sheetObjects[3].CellValue(i, "cntr_cgo_seq");
    	 }
    	 document.getElementById("cntr_cgo_seq_sum").value = cnt;	
     }
     
     function htmlSheetSync(){
    	 Row = sheetObjects[1].SelectRow; 
    	 var cnt=0;
    	 for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
    			if (sheetObjects[1].CellValue(Row, "cntr_no") != "") {
    				if (sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no") && sheetObjects[1].CellValue(Row, "cntr_cgo_seq") == sheetObjects[3].CellValue(i, "cntr_cgo_seq")) {
    					sheetObjects[3].CellValue2(i, "DelChk") = "1";
    				} else {
    					sheetObjects[3].CellValue2(i, "DelChk") = "0";
    				}
    			} else {
    				if (sheetObjects[1].CellValue(Row, "dg_cntr_seq") == sheetObjects[3].CellValue(i, "dg_cntr_seq") && sheetObjects[1].CellValue(Row, "cntr_cgo_seq") == sheetObjects[3].CellValue(i, "cntr_cgo_seq")) {
    					sheetObjects[3].CellValue2(i, "DelChk") = "1";
    				} else {
    					sheetObjects[3].CellValue2(i, "DelChk") = "0";
    				}
    			}
    		}

    	 document.getElementById("dg_cntr_seq").value = sheetObjects[1].CellValue(Row, "dg_cntr_seq");
    		 
    	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
    	var find_row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 0);
    		for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {

    			if (sheetObjects[3].CellValue(find_row, "ibflag") == "D") {

    				if (sheetObjects[3].CellValue(i, "ibflag") != "D") {
    					find_row = i;
    					break;
    				}
    			}
    		}
    
    	 document.form.hzd_ctnt.text2 = sheetObjects[3].CellValue(find_row, "hzd_ctnt");
    	 document.form.stwg_temp_ctnt.text2 = sheetObjects[3].CellValue(find_row, "stwg_temp_ctnt");
         document.getElementById("cntr_no").value = sheetObjects[3].CellValue(find_row, "cntr_no");
    	 document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(Row, "cntr_tpsz_cd");
    	 document.getElementById("cntr_cgo_seq").value = sheetObjects[3].CellValue(find_row, "cntr_cgo_seq");	  
    	 document.getElementById("imdg_clss_cd").value = sheetObjects[3].CellValue(find_row, "imdg_clss_cd");	  
    	 document.getElementById("imdg_comp_grp_cd").value = sheetObjects[3].CellValue(find_row, "imdg_comp_grp_cd");
    	 document.getElementById("imdg_un_no").value = sheetObjects[3].CellValue(find_row, "imdg_un_no");
    	 document.getElementById("grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt");	   
    	 document.getElementById("net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");
    	 document.getElementById("grs_capa_qty").value = sheetObjects[3].CellText(find_row, "grs_capa_qty");
    	 document.getElementById("temp_grs_wgt").value = sheetObjects[3].CellText(Row, "grs_wgt");
    	 document.getElementById("temp_net_wgt").value = sheetObjects[3].CellText(Row, "net_wgt");
    	 document.getElementById("prp_shp_nm").value = sheetObjects[3].CellValue(find_row, "prp_shp_nm");
    	 document.getElementById("hzd_desc").value = sheetObjects[3].CellValue(find_row, "hzd_desc");	  
    	 document.getElementById("stwg_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "stwg_temp_ctnt");
    	 document.getElementById("flsh_pnt_cdo_temp").value = sheetObjects[3].CellValue(find_row, "flsh_pnt_cdo_temp");
    	 document.getElementById("out_dg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd1");
    	 document.getElementById("out_dg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd2");
    	 document.getElementById("out_dg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty1");
    	 document.getElementById("out_dg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty2");
    	 document.getElementById("in_dg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd1");
    	 document.getElementById("in_dg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd2");
    	 document.getElementById("in_dg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty1");
    	 document.getElementById("in_dg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty2"); 
    	 
    	 if (sheetObjects[3].CellValue(find_row, "imdg_pck_grp_cd") == "1") {
    		 document.getElementById("imdg_pck_grp_cd").value = "I";
    	 }else if (sheetObjects[3].CellValue(find_row, "imdg_pck_grp_cd") == "2") {
    		 document.getElementById("imdg_pck_grp_cd").value = "II";
    	 }else if (sheetObjects[3].CellValue(find_row, "imdg_pck_grp_cd") == "3") {
    		 document.getElementById("imdg_pck_grp_cd").value = "III";    		 
    	 }else{
    		 document.getElementById("imdg_pck_grp_cd").value = sheetObjects[3].CellValue(find_row, "imdg_pck_grp_cd");
    	 }
    	 document.getElementById("psa_no").value = sheetObjects[3].CellValue(find_row, "psa_no");	  
    	 document.getElementById("imdg_lmt_qty_flg").value = sheetObjects[3].CellValue(find_row, "imdg_lmt_qty_flg");
    	 document.getElementById("imdg_expt_qty_flg").value = sheetObjects[3].CellValue(find_row, "imdg_expt_qty_flg");	   
    	 if(sheetObjects[3].CellValue(find_row, "hcdg_flg") == "Y"){
    		 document.getElementById("hcdg_flag").value = "HCDG";
    	 }else{
    		 document.getElementById("hcdg_flag").value = "";
    	 }
    	 document.getElementById("imdg_subs_rsk_lbl_cd1").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd1");
    	 document.getElementById("imdg_subs_rsk_lbl_cd2").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd2");
    	 document.getElementById("imdg_subs_rsk_lbl_cd3").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd3");
    	 document.getElementById("imdg_subs_rsk_lbl_cd4").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd4");	   
    	 document.getElementById("dcgo_sts_cd").value = sheetObjects[3].CellValue(find_row, "dcgo_sts_cd");
    	 document.getElementById("mrn_polut_flg").value = sheetObjects[3].CellValue(find_row, "mrn_polut_flg");
    	 document.getElementById("emer_cntc_phn_no_ctnt").value = sheetObjects[3].CellValue(find_row, "emer_cntc_phn_no_ctnt");
    	 document.getElementById("emer_cntc_pson_nm").value = sheetObjects[3].CellValue(find_row, "emer_cntc_pson_nm");
    	 document.getElementById("certi_no").value = sheetObjects[3].CellValue(find_row, "certi_no");
    	 document.getElementById("cnee_dtl_desc").value = sheetObjects[3].CellValue(find_row, "cnee_dtl_desc");
    	 document.getElementById("net_explo_wgt").value = sheetObjects[3].CellValue(find_row, "net_explo_wgt");
    	 document.getElementById("rada_skd_no").value = sheetObjects[3].CellValue(find_row, "rada_skd_no");	   
    	 document.getElementById("rada_amt").value = sheetObjects[3].CellValue(find_row, "rada_amt");
    	 document.getElementById("rada_ut_cd").value = sheetObjects[3].CellValue(find_row, "rada_ut_cd");
    	 document.getElementById("rada_trsp_no").value = sheetObjects[3].CellValue(find_row, "rada_trsp_no");   
    	 document.getElementById("temp_cntr_no").value = sheetObjects[3].CellValue(find_row, "cntr_no");   
    	 document.getElementById("diff_rmk").value = sheetObjects[3].CellValue(find_row, "diff_rmk");
    	 
    	 //Package Q'ty / Type 팝업창으로 넘기는 Hidden 값 셋팅
    	 document.getElementById("in_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd1");
    	 document.getElementById("in_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd2");
    	 document.getElementById("in_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty1");
    	 document.getElementById("in_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty2");
    	 document.getElementById("in_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_desc1");
    	 document.getElementById("in_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_desc2");
    	 document.getElementById("out_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd1");
    	 document.getElementById("out_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd2");
    	 document.getElementById("out_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty1");
    	 document.getElementById("out_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty2");
    	 document.getElementById("out_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_desc1");
    	 document.getElementById("out_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_desc2");    	 
    	 document.getElementById("intmd_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_cd1");
    	 document.getElementById("intmd_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_cd2");
    	 document.getElementById("intmd_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_qty1");
    	 document.getElementById("intmd_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_qty2");
    	 document.getElementById("intmd_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_desc1");
    	 document.getElementById("intmd_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_desc2");
    	 document.getElementById("max_in_pck_qty").value = sheetObjects[3].CellValue(find_row, "max_in_pck_qty");
    	 document.getElementById("max_in_pck_tp_cd").value = sheetObjects[3].CellValue(find_row, "max_in_pck_tp_cd");
    	 document.getElementById("hcdg_intmd_bc_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_intmd_bc_rstr_desc");
    	 document.getElementById("hcdg_pck_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_pck_rstr_desc");
    	 document.getElementById("hcdg_tnk_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_tnk_rstr_desc");
    	 document.getElementById("imdg_expt_qty_cd").value = sheetObjects[3].CellValue(find_row, "imdg_expt_qty_cd");
    	 document.getElementById("ltd_qty").value = sheetObjects[3].CellValue(find_row, "ltd_qty");
    	 
    	 //Other Emergency Information 팝업창으로 넘기는 Hidden 값 셋팅
    	 document.getElementById("ems_no").value = sheetObjects[3].CellValue(find_row, "ems_no");
    	 document.getElementById("emer_rspn_gid_no").value = sheetObjects[3].CellValue(find_row, "emer_rspn_gid_no");
    	 document.getElementById("emer_rspn_gid_chr_no").value = sheetObjects[3].CellValue(find_row, "emer_rspn_gid_chr_no");
    	 document.getElementById("ctrl_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "ctrl_temp_ctnt");
    	 document.getElementById("emer_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "emer_temp_ctnt");
	   	   
    	 document.getElementById("clod_flg").value = sheetObjects[3].CellValue(find_row, "clod_flg");
    	 document.getElementById("rc_flg").value = sheetObjects[3].CellValue(find_row, "rc_flg");
    	 document.getElementById("awk_cgo_flg").value = sheetObjects[3].CellValue(find_row, "awk_cgo_flg");
    	 document.getElementById("bb_cgo_flg").value = sheetObjects[3].CellValue(find_row, "bb_cgo_flg");
    	 document.getElementById("hcdg_flg").value = sheetObjects[3].CellValue(find_row, "hcdg_flg");
    	 document.getElementById("meas_qty").value = sheetObjects[3].CellValue(find_row, "meas_qty");
    	 document.getElementById("hcdg_dpnd_qty_flg").value = sheetObjects[3].CellValue(find_row, "hcdg_dpnd_qty_flg");
    	 document.getElementById("spcl_rqst_flg").value = sheetObjects[3].CellValue(find_row, "spcl_rqst_flg");
    	 document.getElementById("imdg_un_no_seq").value = sheetObjects[3].CellValue(find_row, "imdg_un_no_seq");
    	 
    	 document.getElementById("vsl_cd").innerText = sheetObjects[2].CellValue(1, "vsl_cd");
     }     
     
     
     /**
      * IBSheet Object에서 팝업을 클릭시
      */
     function onPopupClick(srcName){
    	 var formObj = document.form;
		 var row = formObj.row.value;
		 var sParam = ""; 
		 var oSheetObj = "";
		 
		 if (formObj.scg_flg.value=="DG1"){
			 oSheetObj = openerObj.sheetObjects[1];
		 }else if (formObj.scg_flg.value=="SCG_DG"){
			 oSheetObj = openerObj.sheetObjects[0];
		 }else if (formObj.scg_flg.value=="DG2"){
			 oSheetObj = openerObj.sheetObjects[2];
		 }
		 
		 if (srcName == "btn_RouteDetail") {
    		 ComOpenPopup("ESM_BKG_1069.do?bkg_no="+ComGetObjValue(formObj.bkg_no), 706, 440, "ESM_BKG_0092","1,0,1,1,1", true);  								
    	 }else if (srcName == "btn_UnInformation") {
    		 sParam  = "pop_mode=Y";
    		 sParam += "&imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
    		 sParam += "&imdg_un_no_seq="+sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "imdg_un_no_seq");
    		 ComOpenPopup("VOP_SCG_0001Pop.do?pgmNo=VOP_SCG_0001&"+sParam, 1025, 630, "VOP_SCG_0001", "0,0,1,1,1,1,1", true);   		 
    	 }else if (srcName == "btn_Restrictions") {
    		 sParam  = "imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
    		 sParam += "&imdg_un_no_seq="+sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "imdg_un_no_seq");
    		 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
    		 sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
    		 sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
    		 sParam += "&slan_cd=";
    		 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
    		 sParam += "&vsl_cd="+ComGetObjValue(formObj.vvd_cd).substring(0,4);
    		 sParam += "&skd_voy_no="+ComGetObjValue(formObj.vvd_cd).substring(4,8);
    		 sParam += "&skd_dir_cd="+ComGetObjValue(formObj.vvd_cd).substring(8,9);
    		 ComOpenPopup("VOP_SCG_0021.do?"+sParam, 1014, 660, "VOP_SCG_0021", "0,0,1,1,1,1,1", true);
    	 }else if (srcName == "btn_Pre-CheckingReport") {
    		 ComOpenPopup("VOP_SCG_0069.do?pop_type=SR", 940, 910, "VOP_SCG_0069", "0,0,1,1,1,1,1", true);
    	 }else if (srcName == "btn_Irregular") {
    		 imdg_un_no = formObj.imdg_un_no.value;
    		 if(document.getElementById('btn_Irregular').style.color != 'red') imdg_un_no = "";
  	    	 ComOpenWindowCenter("VOP_SCG_0012Pop.do?pgmNo=VOP_SCG_0012&pop_mode=Y&f_cmd=&imdg_un_no="+imdg_un_no, "winIrrList", "1025", "700", true);
    	  } else if (srcName == "btn_PackageQtyType") {
    		 var in_imdg_pck_cd1 = document.getElementById("in_imdg_pck_cd1").value; 
    		 var in_imdg_pck_cd2 = document.getElementById("in_imdg_pck_cd2").value; 
    		 var intmd_imdg_pck_cd1 = document.getElementById("intmd_imdg_pck_cd1").value; 
    		 var intmd_imdg_pck_cd2 = document.getElementById("intmd_imdg_pck_cd2").value; 
    		 var out_imdg_pck_cd1 = document.getElementById("out_imdg_pck_cd1").value; 
    		 var out_imdg_pck_cd2 = document.getElementById("out_imdg_pck_cd2").value; 
    		 var in_imdg_pck_desc1 = document.getElementById("in_imdg_pck_desc1").value; 
    		 var in_imdg_pck_desc2 = document.getElementById("in_imdg_pck_desc2").value; 
    		 var intmd_imdg_pck_desc1 = document.getElementById("intmd_imdg_pck_desc1").value; 
    		 var intmd_imdg_pck_desc2 = document.getElementById("intmd_imdg_pck_desc2").value; 
    		 var out_imdg_pck_desc1 = document.getElementById("out_imdg_pck_desc1").value; 
    		 var out_imdg_pck_desc2 = document.getElementById("out_imdg_pck_desc2").value; 
    		 var in_imdg_pck_qty1 = document.getElementById("in_imdg_pck_qty1").value; 
    		 var in_imdg_pck_qty2 = document.getElementById("in_imdg_pck_qty2").value;	
    		 var intmd_imdg_pck_qty1 = document.getElementById("intmd_imdg_pck_qty1").value; 
    		 var intmd_imdg_pck_qty2 = document.getElementById("intmd_imdg_pck_qty2").value;
    		 var out_imdg_pck_qty1 = document.getElementById("out_imdg_pck_qty1").value; 
    		 var out_imdg_pck_qty2 = document.getElementById("out_imdg_pck_qty2").value;  								
    		 var hcdg_intmd_bc_rstr_desc = document.getElementById("hcdg_intmd_bc_rstr_desc").value;  
    		 var hcdg_pck_rstr_desc = document.getElementById("hcdg_pck_rstr_desc").value;  
    		 var hcdg_tnk_rstr_desc = document.getElementById("hcdg_tnk_rstr_desc").value;  
    		 var ltd_qty = document.getElementById("ltd_qty").value; 
    		 var imdg_expt_qty_cd = document.getElementById("imdg_expt_qty_cd").value; 	 
			 var grs_wgt = document.getElementById("grs_wgt").value;
			 var net_wgt = document.getElementById("net_wgt").value;
			 var grs_capa_qty = document.getElementById("grs_capa_qty").value;

    		 ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1="+in_imdg_pck_cd1+"&in_imdg_pck_cd2="+in_imdg_pck_cd2+"&intmd_imdg_pck_cd1="+intmd_imdg_pck_cd1+"&intmd_imdg_pck_cd2="+intmd_imdg_pck_cd2+"&out_imdg_pck_cd1="+out_imdg_pck_cd1+"&out_imdg_pck_cd2="+out_imdg_pck_cd2+"&in_imdg_pck_desc1="+in_imdg_pck_desc1+"&in_imdg_pck_desc2="+in_imdg_pck_desc2+"&intmd_imdg_pck_desc1="+intmd_imdg_pck_desc1+"&intmd_imdg_pck_desc2="+intmd_imdg_pck_desc2+"&out_imdg_pck_desc1="+out_imdg_pck_desc1+"&out_imdg_pck_desc2="+out_imdg_pck_desc2+"&in_imdg_pck_qty1="+in_imdg_pck_qty1+"&in_imdg_pck_qty2="+in_imdg_pck_qty2+"&intmd_imdg_pck_qty1="+intmd_imdg_pck_qty1+"&intmd_imdg_pck_qty2="+intmd_imdg_pck_qty2+"&out_imdg_pck_qty1="+out_imdg_pck_qty1+"&out_imdg_pck_qty2="+out_imdg_pck_qty2+"&hcdg_intmd_bc_rstr_desc="+hcdg_intmd_bc_rstr_desc+"&hcdg_pck_rstr_desc="+hcdg_pck_rstr_desc+"&hcdg_tnk_rstr_desc="+hcdg_tnk_rstr_desc+"&ltd_qty="+ltd_qty+"&imdg_expt_qty_cd="+imdg_expt_qty_cd  + "&grs_wgt=" + grs_wgt + "&net_wgt=" + net_wgt + "&grs_capa_qty=" + grs_capa_qty, 710, 540, "setDgPkgQtyType", '0,0,1,1,1,1,1', true);
    		 
    		 sParam  = "in_imdg_pck_cd1="+ComGetObjValue(formObj.in_imdg_pck_cd1);
    		 sParam += "&in_imdg_pck_cd2="+ComGetObjValue(formObj.in_imdg_pck_cd2);
    		 sParam += "&out_imdg_pck_cd1="+ComGetObjValue(formObj.out_imdg_pck_cd1);
    		 sParam += "&out_imdg_pck_cd2="+ComGetObjValue(formObj.out_imdg_pck_cd2);    		 
    		 sParam += "&in_imdg_pck_qty1="+ComGetObjValue(formObj.in_imdg_pck_qty1);
    		 sParam += "&in_imdg_pck_qty2="+ComGetObjValue(formObj.in_imdg_pck_qty2);
    		 sParam += "&out_imdg_pck_qty1="+ComGetObjValue(formObj.out_imdg_pck_qty1);
    		 sParam += "&out_imdg_pck_desc2="+ComGetObjValue(formObj.out_imdg_pck_desc2);
    		 sParam += "intmd_imdg_pck_cd1="+ComGetObjValue(formObj.intmd_imdg_pck_cd1);
    		 sParam += "intmd_imdg_pck_cd2="+ComGetObjValue(formObj.intmd_imdg_pck_cd2);
    		 sParam += "&intmd_imdg_pck_qty1="+ComGetObjValue(formObj.intmd_imdg_pck_qty1);
    		 sParam += "&intmd_imdg_pck_qty2="+ComGetObjValue(formObj.intmd_imdg_pck_qty2);
    		 sParam += "&intmd_imdg_pck_desc1="+ComGetObjValue(formObj.intmd_imdg_pck_desc1);
    		 sParam += "&intmd_imdg_pck_desc2="+ComGetObjValue(formObj.intmd_imdg_pck_desc2);  
    		 sParam += "&max_in_pck_qty="+ComGetObjValue(formObj.max_in_pck_qty);
    		 sParam += "&max_in_pck_tp_cd="+ComGetObjValue(formObj.max_in_pck_tp_cd);      		 
    		 sParam += "&hcdg_intmd_bc_rstr_desc="+ComGetObjValue(formObj.hcdg_intmd_bc_rstr_desc);
    		 sParam += "&hcdg_pck_rstr_desc="+ComGetObjValue(formObj.hcdg_pck_rstr_desc);
    		 sParam += "&hcdg_tnk_rstr_desc="+ComGetObjValue(formObj.hcdg_tnk_rstr_desc);
    		 sParam += "&imdg_expt_qty_cd="+ComGetObjValue(formObj.imdg_expt_qty_cd);
    		 sParam += "&ltd_qty="+ComGetObjValue(formObj.ltd_qty);
    		 //ComOpenPopup("ESM_BKG_0206.do?"+sParam, 710, 525, "ESM_BKG_0206",  "0,0,1,1,1,1,1", true);
		 }else if (srcName == "btn_UnNo" ) {
			 sParam  = "imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
			 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
			 sParam += "&prp_shp_nm="+ComGetObjValue(formObj.prp_shp_nm);
			 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
			 ComOpenPopup("ESM_BKG_0204.do?"+sParam, 913, 440, "ESM_BKG_0204", "0,0,1,1,1,1,1", true);			 
    	 }else if (srcName == "btn_OtherEmergencyInformation") {
			 sParam  = "imdg_emer_no="+ComGetObjValue(formObj.ems_no);
			 sParam += "&emer_rspn_gid_no="+ComGetObjValue(formObj.emer_rspn_gid_no);
			 sParam += "&emer_rspn_gid_chr_no="+ComGetObjValue(formObj.emer_rspn_gid_chr_no);
			 sParam += "&ctrl_temp_ctnt="+ComGetObjValue(formObj.ctrl_temp_ctnt);
			 sParam += "&emer_temp_ctnt="+ComGetObjValue(formObj.emer_temp_ctnt);
			 ComOpenPopup("ESM_BKG_0770.do?"+sParam, 505, 215, "ESM_BKG_0770", "0,0,1,1,1,1,1", true);
    	 }else if (srcName == "btn_AttachedFile") {
    		 ComOpenPopup("ESM_BKG_0207.do?bkg_no="+formObj.bkg_no.value+"&ridr_tp_cd=D&disableYn=Y", 523, 525, "ESM_BKG_0207", "0,0,1,1,1,1,1", true);
    	 }else if (srcName == "btn_ApprovalDetails") {
    		 ComOpenPopup("VOP_SCG_1015.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value, 1005, 520, "VOP_SCG_1015", "0,0,1,1,1,1,1", true);
    		 /*VVD별 Aproval History를 보고 싶은겨우 아래 링크를 활성화한다.
    		  * 서동호 부장님 요건 변경으로 인한 BKG_NO별 Aproval History를 보여준다.
    		  * ComOpenPopup("VOP_SCG_1015.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value+"&vsl_cd="+formObj.vvd_cd.value.substring(0,4)+"&skd_voy_no="+formObj.vvd_cd.value.substring(4,8)+"&skd_dir_cd="+formObj.vvd_cd.value.substring(8,9), 1000, 450, "", '0,0', true);
    		  */
    	 }else if (srcName == "btn_Prev") {
    		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="DG2") {
    			 if (!setParentValue()) return false;
    		 }
    		 if (row == 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 oSheetObj.SelectCell( parseInt(row)-1 , oSheetObj.SelectCol);
    			 formObj.old_bkg_no.value = oSheetObj.CellValue( parseInt(row) , "bkg_no");
    			 formObj.bkg_no.value = oSheetObj.CellValue( parseInt(row)-1 , "bkg_no");
    			 formObj.vvd_cd.value = oSheetObj.CellText(parseInt(row)-1, "vsl_cd")+oSheetObj.CellText(parseInt(row)-1, "skd_voy_no")+oSheetObj.CellText(parseInt(row)-1, "skd_dir_cd");
    			 if (formObj.scg_flg.value=="SCG_DG"){
        			 formObj.dg_cntr_seq.value = oSheetObj.CellValue( parseInt(row)-1 , "spcl_cntr_seq");
        			 formObj.cntr_cgo_seq.value = oSheetObj.CellValue( parseInt(row)-1 , "spcl_cgo_seq");
    			 }else {
        			 formObj.dg_cntr_seq.value = oSheetObj.CellValue( parseInt(row)-1 , "dg_cntr_seq");
        			 formObj.cntr_cgo_seq.value = oSheetObj.CellValue( parseInt(row)-1 , "cntr_cgo_seq");
    			 }
    			 formObj.spcl_cgo_apro_rqst_seq.value = oSheetObj.CellValue( parseInt(row)-1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value = parseInt(row)-1;
    			 loadPage2();
    		 }
    	 }else if (srcName == "btn_Next") {
    		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="DG2") {
    			 if (!setParentValue()) return false;
    		 }
    		 if (row == oSheetObj.LastRow ) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 oSheetObj.SelectCell( parseInt(row)+1 , oSheetObj.SelectCol);
    			 formObj.old_bkg_no.value = oSheetObj.CellValue( parseInt(row) , "bkg_no");
    			 formObj.bkg_no.value = oSheetObj.CellValue( parseInt(row)+1 , "bkg_no");
    			 formObj.vvd_cd.value = oSheetObj.CellText(parseInt(row)+1, "vsl_cd")+oSheetObj.CellText(parseInt(row)+1, "skd_voy_no")+oSheetObj.CellText(parseInt(row)+1, "skd_dir_cd");
    			 if (formObj.scg_flg.value=="SCG_DG"){
        			 formObj.dg_cntr_seq.value = oSheetObj.CellValue( parseInt(row)+1 , "spcl_cntr_seq");
        			 formObj.cntr_cgo_seq.value = oSheetObj.CellValue( parseInt(row)+1 , "spcl_cgo_seq");
    			 }else {
        			 formObj.dg_cntr_seq.value = oSheetObj.CellValue( parseInt(row)+1 , "dg_cntr_seq");
        			 formObj.cntr_cgo_seq.value = oSheetObj.CellValue( parseInt(row)+1 , "cntr_cgo_seq");
    			 }
    			 formObj.spcl_cgo_apro_rqst_seq.value = oSheetObj.CellValue( parseInt(row)+1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value = parseInt(row)+1;
    			 loadPage2();
    		 }
    	 }
     }

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
     function setParentValue(){
    	 var formObj = document.form;    
		 var row = formObj.row.value;
		 var oSheetObj = "";
		 
		 if (formObj.scg_flg.value=="DG1"){
		 	 oSheetObj = openerObj.sheetObjects[1];
		 }else if (formObj.scg_flg.value=="SCG_DG"){
			 oSheetObj = openerObj.sheetObjects[0];
		 }else if (formObj.scg_flg.value=="DG2"){
			 oSheetObj = openerObj.sheetObjects[2];
		 }

		 if (formObj.spcl_cgo_auth_cd.value == "A") {
			 var bkgNo 	= formObj.bkg_no.value;
			 var befVVD	= formObj.vvd_cd.value;
			 /*승인을 주지만 승인번호는 입력 안 할 수 있다.
			 if (document.getElementById("apro_ref_no").disabled == false && formObj.apro_ref_no.value == "") {
    			 formObj.apro_ref_no.focus();
    			 ComShowMessage("승인 번호를 입력해 주세요.");
    	    	 return false;
			 }
			 */
    		 for (var i = 2; i <= oSheetObj.LastRow; i ++)
    		 {
    			 if (bkgNo == oSheetObj.CellText(i, "bkg_no") && befVVD == oSheetObj.CellText(i, "vsl_cd")+oSheetObj.CellText(i, "skd_voy_no")+oSheetObj.CellText(i, "skd_dir_cd")) {
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_cd") 	= "Y";
    				 oSheetObj.CellValue( i , "apro_ref_no")		= formObj.apro_ref_no.value;
    			 }
    		 }
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rmk") 		= formObj.spcl_cgo_auth_rmk.value;
		 }else if (formObj.spcl_cgo_auth_cd.value == "Y") {
			 /*승인을 주지만 승인번호는 입력 안 할 수 있다.
			 if (document.getElementById("apro_ref_no").disabled == false && formObj.apro_ref_no.value == "") {
    			 formObj.apro_ref_no.focus();
    			 ComShowMessage("승인 번호를 입력해 주세요.");
    	    	 return false;
			 }
			 */
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_cd") 		= formObj.spcl_cgo_auth_cd.value;
			 oSheetObj.CellValue( parseInt(row) , "apro_ref_no") 			= formObj.apro_ref_no.value;
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rmk") 		= formObj.spcl_cgo_auth_rmk.value;
		 }else if (formObj.spcl_cgo_auth_cd.value == "P") {
			 var bkgNo 	= formObj.bkg_no.value;
			 var befVVD	= formObj.vvd_cd.value;
			 if (formObj.mailYn.value == "Y") {
	    		 for (var i = 2; i <= oSheetObj.LastRow; i ++)
	    		 {
	    			 if (bkgNo == oSheetObj.CellText(i, "bkg_no") && befVVD == oSheetObj.CellText(i, "vsl_cd")+oSheetObj.CellText(i, "skd_voy_no")+oSheetObj.CellText(i, "skd_dir_cd")) {
	    				 oSheetObj.CellValue( i , "spcl_cgo_auth_cd") 	= "P";
	    				 oSheetObj.CellValue( i , "apro_ref_no")		= formObj.apro_ref_no.value;
	    			 }
	    		 }				 
			 }else{
				 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_cd") 		= formObj.spcl_cgo_auth_cd.value;
				 oSheetObj.CellValue( parseInt(row) , "apro_ref_no") 			= formObj.apro_ref_no.value;
			 }
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd")	= comboObjects[1].Code;
			 if (comboObjects[1].Code == 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
    			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    			 formObj.spcl_cgo_auth_rmk.focus();
    			 return false;
			 }else{
				 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rmk") 		= formObj.spcl_cgo_auth_rmk.value;
			 }
		 // 2010.01.07 이행지 [CHM-201007766-01] N(all):M 항목 추가하고 해당 bkg_no, vvd가 같은 것들에 대해 동일하게 적용
		 }else if (formObj.spcl_cgo_auth_cd.value == "M") {
			 var bkgNo 	= formObj.bkg_no.value;
			 var befVVD	= formObj.vvd_cd.value;

			 if (comboObjects[1].Code == '') {
    			 ComShowCodeMessage('SCG50011', 'RJT Code');
    			 formObj.spcl_cgo_auth_rjct_cd.focus();
    			 return false;
			 }
			 
    		 for (var i = 2; i <= oSheetObj.LastRow; i ++)
    		 {
    			 if (bkgNo == oSheetObj.CellText(i, "bkg_no") && befVVD == oSheetObj.CellText(i, "vsl_cd")+oSheetObj.CellText(i, "skd_voy_no")+oSheetObj.CellText(i, "skd_dir_cd")) {
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_cd") 	= "N";
    				 oSheetObj.CellValue( i , "apro_ref_no")		= formObj.apro_ref_no.value;
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_rjct_cd")		= comboObjects[1].Code
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_rmk")		= formObj.spcl_cgo_auth_rmk.value;
    			 }
    		 }
		 }else if (formObj.spcl_cgo_auth_cd.value != ""){
			 if (comboObjects[1].Code == '') {
    			 ComShowCodeMessage('SCG50011', 'RJT Code');
    			 formObj.spcl_cgo_auth_rjct_cd.focus();
    			 return false;
			 }
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_cd") 		= formObj.spcl_cgo_auth_cd.value;
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd")	= comboObjects[1].Code;
			 if (comboObjects[1].Code == 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
    			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    			 formObj.spcl_cgo_auth_rmk.focus();
    			 return false;
			 }else{
				 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rmk") 		= formObj.spcl_cgo_auth_rmk.value;
			 }
		 }
    	 return true;
     }

     /**
      * 요청 메일 보내기
      */
     function sendReqMail(sheetObj, formObj) {
		 var oSheetObj = "";
		 
		 if (formObj.scg_flg.value=="DG1"){
		 	 oSheetObj = openerObj.sheetObjects[1];
		 }else if (formObj.scg_flg.value=="SCG_DG"){
			 oSheetObj = openerObj.sheetObjects[0];
		 }else if (formObj.scg_flg.value=="DG2"){
			 oSheetObj = openerObj.sheetObjects[2];
		 }
		 var crr_cd                 = oSheetObj.CellText(oSheetObj.SelectRow, "crr_cd");
		 var bkg_ref_no             = "";
		 var spcl_cgo_rqst_seq      = "";
    	 var bkg_no                 = formObj.bkg_no.value; ;
    	 var spcl_cgo_apro_rqst_seq = formObj.spcl_cgo_apro_rqst_seq.value;
		 var vsl_pre_pst_cd         = oSheetObj.CellText(oSheetObj.SelectRow, "vsl_pre_pst_cd");
		 var vsl_seq                = oSheetObj.CellText(oSheetObj.SelectRow, "vsl_seq");
    	 var rgn_shp_opr_cd         = openerObj.document.all.rgn_shp_opr_cd.Code;
    	 var scg_flg                = "DG";
    	 var send_type              = "0";
    	 var user_id                = ComGetObjValue(formObj.auth_usr_id);

    	 mailObj.crr_cd = crr_cd;
    	 mailObj.bkg_ref_no = bkg_ref_no;
    	 mailObj.spcl_cgo_rqst_seq = spcl_cgo_rqst_seq;
    	 mailObj.bkg_no = bkg_no;
    	 mailObj.spcl_cgo_apro_rqst_seq = spcl_cgo_apro_rqst_seq;
    	 mailObj.vsl_pre_pst_cd = vsl_pre_pst_cd;
    	 mailObj.vsl_seq = vsl_seq;
    	 mailObj.rgn_shp_opr_cd = rgn_shp_opr_cd;
    	 mailObj.scg_flg = scg_flg;
    	 mailObj.send_type = send_type;
    	 mailObj.user_id = user_id;
 		  	
    	 ComScgSendMail(sheetObj, formObj, mailObj, true, "VOP_SCG_0014GS.do", "authPending()");
    	 
     }
     
     function authPending() {
    	 var formObj   = document.form;
    	 //if (formObj.spcl_cgo_auth_cd.options.length == "5") {
        	 //formObj.spcl_cgo_auth_cd.options[3].selected = true;
    	 	 formObj.spcl_cgo_auth_cd.value = "P"; // Mail발송 후 "P"로 변경됨
        	 comboObjects[1].Enable = true;
        	 comboObjects[1].BackColor = "#FFFFFF";
        	 //formObj.spcl_cgo_auth_rmk.disabled = false;
        	 //formObj.spcl_cgo_auth_rmk.className = "input";
        	 formObj.mailYn.value = "Y";
    	 //}
     }

     /**
      * Making parameter of Pre-Checking
      */
     function makePreChkParam() {
     	var sheetObj2 = sheetObjects[3];
 		var formObj   = document.form;
 		var sParam = "";
 		var oSheetObj = "";
 		
 		if (formObj.scg_flg.value=="DG1"){
 			oSheetObj = openerObj.sheetObjects[1];
 		}else if (formObj.scg_flg.value=="SCG_DG"){
 			oSheetObj = openerObj.sheetObjects[0];
 		}else if (formObj.scg_flg.value=="DG2"){
 			oSheetObj = openerObj.sheetObjects[2];
 		}

 		for(var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++) {
 			if(sheetObj2.RowStatus(i) != 'D') {
 				for(var j=0; j<=sheetObj2.LastCol; j++) {
 					sParam += sheetObj2.ColSaveName(j)+"="+sheetObj2.CellValue(i, j)+"&";
 				}
 			}
 		}
 		
 		sParam += "rgn_shp_opr_cd="+openerObj.document.all.rgn_shp_opr_cd.Code;
 		sParam += "&cgo_opr_cd=SML";
 		sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
 		sParam += "&vsl_cd="+formObj.vvd_cd.value.substring(0,4);
 		sParam += "&skd_voy_no="+formObj.vvd_cd.value.substring(4,8);
 		sParam += "&skd_dir_cd="+formObj.vvd_cd.value.substring(8,9);
// 		sParam += "&crr_cd="+oSheetObj.CellText(oSheetObj.SelectRow, "crr_cd");
// 		sParam += "&slan_cd="+oSheetObj.CellText(oSheetObj.SelectRow, "slan_cd");
// 		sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
// 		sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
 		
 		return sParam;
     }
     
 	/**
 	 * Pre-Checking result Setter - Y:체크후 통과 , N:체크전 , P:체크후 금지
 	 */
 	function setPreChkRslt(rslt) {
 		
 	}
     
 	/**
 	 * Special Request Cargo 정보를 return한다.
 	 */
 	function getCgoSheet() {
 		return sheetObjects[3];
 	}

   	/**
  	 * DG Package Q'ty & Type Setter
  	 */
  	function setDgPkgQtyType(aryPopupData) {
  		var formObj = document.form;
  		ComSetObjValue(formObj.out_imdg_pck_qty1,      aryPopupData[0][7]);
  		ComSetObjValue(formObj.out_imdg_pck_cd1,       aryPopupData[0][8]);
  		ComSetObjValue(formObj.out_imdg_pck_desc1,     aryPopupData[0][9]);
  		ComSetObjValue(formObj.out_imdg_pck_qty2,      aryPopupData[0][10]);
  		ComSetObjValue(formObj.out_imdg_pck_cd2,       aryPopupData[0][11]);
  		ComSetObjValue(formObj.out_imdg_pck_desc2,     aryPopupData[0][12]);
  		
  		ComSetObjValue(formObj.intmd_imdg_pck_qty1,    aryPopupData[0][13]);
  		ComSetObjValue(formObj.intmd_imdg_pck_cd1,     aryPopupData[0][14]);
  		ComSetObjValue(formObj.intmd_imdg_pck_desc1,   aryPopupData[0][15]);
  		ComSetObjValue(formObj.intmd_imdg_pck_qty2,    aryPopupData[0][16]);
  		ComSetObjValue(formObj.intmd_imdg_pck_cd2,     aryPopupData[0][17]);
  		ComSetObjValue(formObj.intmd_imdg_pck_desc2,   aryPopupData[0][18]);
  		
  		ComSetObjValue(formObj.in_imdg_pck_qty1,       aryPopupData[0][19]);
  		ComSetObjValue(formObj.in_imdg_pck_cd1,        aryPopupData[0][20]);
  		ComSetObjValue(formObj.in_imdg_pck_desc1,      aryPopupData[0][21]);
  		ComSetObjValue(formObj.in_imdg_pck_qty2,       aryPopupData[0][22]);
  		ComSetObjValue(formObj.in_imdg_pck_cd2,        aryPopupData[0][23]);
  		ComSetObjValue(formObj.in_imdg_pck_desc2,      aryPopupData[0][24]);
  		
  		ComSetObjValue(formObj.grs_capa_qty,           aryPopupData[0][29]);
  	}	  	 
 	 
	/* 개발자 작업  끝 */