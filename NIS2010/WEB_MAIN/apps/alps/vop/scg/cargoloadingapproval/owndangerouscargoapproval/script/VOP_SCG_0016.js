/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0016.js
*@FileTitle : Awkward CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.06 이도형
* 1.0 Creation
*=========================================================
*History
*2011.01.05 이행지 [CHM-201007766-01] [VO-SCG] 다수 SEQ. REJECT 시 RJT사유 입력 개선요청
*2011.01.12 이행지 [CHM-201108316-01] [SCG] Reject N(all)추가요청
*2012.07.06 조경완 [CHM-201218537-01] [VOP-SCG] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
*2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
*2012.12.17 진마리아 [CHM-201221870-01] [VOP-SCG] AWK application special stowage 수정
*==========================워===============================
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
     * @class vop_scg_0016 : vop_scg_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0016() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;
    
   	var openerObj = window.dialogArguments;
   	var auth_length = 0;
   	
   	var closeChk = 'N';

   	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var sheetObject2 = sheetObjects[2];
    	var sheetObject3 = sheetObjects[3];
    	var sheetObject4 = sheetObjects[4];
    	var sheetObject6 = sheetObjects[5];
    	/*******************************************************/
    	var formObject = document.form;
    	
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

     			case "btn_PolCd":
     				onPopupClick(srcName);
     				break;

     			case "btn_PodCd":
     				onPopupClick(srcName);
     				break;

     			case "btn_RouteDetail":
     				onPopupClick(srcName);
     				break;

     			case "btns_Package":
     				onPopupClick(srcName);
     				break;

     			case "btns_Commodity":
     				onPopupClick(srcName);
     				break;

     			case "btns_DgCntrSeq":
 					onPopupClick(srcName);
     				break;
     				
                case "btn_Criteria":
 					onPopupClick(srcName);
                    break;
     				
                case "btn_Details":
 					onPopupClick(srcName);
                    break;
     				
                case "btn_AttachedFile":
 					onPopupClick(srcName);
                	break;

                case "btn_ApprovalDetails":
                	onPopupClick(srcName);
                	break;

                case "btn_Mail":
	            	sendReqMail(sheetObject1, formObject);
                	break;

                case "btn_Prev":
                	onPopupClick(srcName);
                	break;

                case "btn_Next":
                	onPopupClick(srcName);
                	break;

                case "btn_Close":  
                	
                	 closeChk = "Y";
                	 if(!checkGcraneWeight())
            			 return;
                	
					if (document.form.scg_flg.value=="AWK" || document.form.scg_flg.value=="45"){
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
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

        // IBMultiCombo초기화
        for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k], k + 1);
  			comboObjects[k].Enable = false;
        }
    }

    function sheet1_OnLoadFinish(sheetObj) {
    	loadPage2();
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
        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC01);	//RJT CD Combo 생성
        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC02);
        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
        doActionIBSheet(sheetObjects[0],document.form,SEARCH01);//Booking Combine, Split 정보 조회
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
        var sheetID = sheetObj.id ; 
        switch(sheetID) {

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

                    var HeadTitle1 = "TP/SZ|BKG Q'ty|AK Q'ty";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"cntr_tpsz_cd",		false,	"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	true,	"op_cntr_qty",		false,	"", dfFloat,	2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,		40,		daRight,	false,	"awk_cgo_qty",		false,	"", dfFloat,	2,		false,		true);
										
					CountPosition = 0;					
    			}
    			break;

        	case "sheet2":
    			with (sheetObj) {

    				// 높이 설정
                    style.height = 130;
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
                    InitColumnInfo(38, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "|Seq| |Container No.|Container No.|Vol.|Appr.|awk_cgo_seq|bkg_no|rcv_term_cd|de_term_cd|";
                    	HeadTitle += "pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|net_wgt|cmdt_cd|cmdt_nm|awk_dcgo_seq|ttl_dim_len|ttl_dim_wdt|";
                    	HeadTitle += "ttl_dim_hgt|ovr_fwrd_len|ovr_bkwd_len|ovr_lf_len|ovr_rt_len|ovr_hgt|in_ga_flg|ovr_void_slt_qty|crn_pst_sts_cd|xtd_ovr_qty|";
                    	HeadTitle += "pst_lck_pin_flg|grav_ctr_desc|stwg_rqst_desc|diff_rmk|modifyAproFlg|cntr_cgo_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHidden,			20,		daCenter,		false,	"DelChk"); 
                    InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,		false,	"seq");
                    InitDataProperty(0, cnt++,  dtHiddenStatus,		20,     daCenter,		false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"cntr_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				20,		daCenter,		false,	"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,		false,	"cntr_vol_qty",		false,			"",      dfFloat,			1,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,		false,	"spcl_cgo_apro_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"awk_cgo_seq",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"bkg_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"rcv_term_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"de_term_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"pck_qty",			false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"pck_tp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"grs_wgt",			false,			"",      dfFloat,			3,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"wgt_ut_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"net_wgt",			false,			"",      dfFloat,			3,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"cmdt_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"cmdt_nm",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"awk_dcgo_seq",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ttl_dim_len",		false,			"",      dfNumber,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ttl_dim_wdt",		false,			"",      dfNumber,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ttl_dim_hgt",		false,			"",      dfNumber,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ovr_fwrd_len",		false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ovr_bkwd_len",		false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ovr_lf_len",		false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ovr_rt_len",		false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ovr_hgt",			false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"in_ga_flg",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"ovr_void_slt_qty",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"crn_pst_sts_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"xtd_ovr_qty",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"pst_lck_pin_flg",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"grav_ctr_desc",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"stwg_rqst_desc",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"diff_rmk",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"modifyaproflg",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"temp_ovr_void_qty",false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,		false,	"cntr_cgo_seq",		false,			"",      dfNone,			0,		false,		true);

					CountPosition = 0;
    			}
                break;
                
        	case "sheet3":
    			with (sheetObj) {

    				// 높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 4, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(17, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	                
	                var HeadTitle1 = "bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|grs_ut_cd";
	
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
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"rcv_term_cd",		false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"de_term_cd",		false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"bkg_sts_cd",		false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"corr_n1st_dt",		false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"bdr_flg",			false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"pck_qty",			false,			"",      dfInteger,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"pck_tp_cd",		false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"grs_wgt",			false,			"",      dfFloat,			3,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"wgt_ut_cd",		false,			"",      dfNone,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,		false,		"stwg_cd",			false,			"",      dfNone,			2,		true,		true);
					
					CountPosition = 0;    											
    			}
    			break;
            
        	case "sheet4":
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
            		InitRowInfo(1, 1, 3, 100);
						
            		var HeadTitle1 = "|||Length(CM)|Width(CM)|Height(CM)|awk_cgo_seq|bkg_no|dim_seq";
						
            		var headCount = ComCountHeadTitle(HeadTitle1);

            		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            		InitColumnInfo(9, 0, 0, true);
						
            		// 해더에서 처리할 수 있는 각종 기능을 설정한다
            		InitHeadMode(true, true, false, true, false,false);
						
            		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            		InitHeadRow(0, HeadTitle1, true);
						
            		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            		InitDataProperty(0, 	cnt++,  dtDummyCheck, 	20,			daCenter, 		false, 		"DelChk"); 
            		InitDataProperty(0,		cnt++ , dtSeq,			40,			daCenter,		true,		"seq");
            		InitDataProperty(0,		cnt++ , dtStatus,		30,			daCenter,		true,		"ibflag");
            		InitDataProperty(0,		cnt++ , dtData,			105,		daCenter,		true,		"dim_len",			false,		"",		dfNone,			0,		true,		true);
            		InitDataProperty(0,		cnt++ , dtData,			110,		daCenter,		true,		"dim_wdt",			false,		"",		dfNone,			0,		true,		true);
            		InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,		true,		"dim_hgt",			false,		"",		dfNone,			0,		true,		true); 
            		InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,		true,		"awk_cgo_seq",			false,		"",		dfNone,			0,		true,		true);
            		InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,		true,		"bkg_no",			false,		"",		dfNone,			0,		true,		true); 
            		InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,		true,		"dim_seq",			false,		"",		dfNone,			0,		true,		true);
            		
				}	
				break; 
				
				
        	case "sheet5":
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
            		InitRowInfo(1, 1, 3, 100);
            		
					var HeadTitle1 = "|value|name|TpszCd|Vol.|rcvTerm|deTerm";
            		
            		var headCount = ComCountHeadTitle(HeadTitle1);
            		
            		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            		InitColumnInfo(7, 0, 0, true);
            		
            		// 해더에서 처리할 수 있는 각종 기능을 설정한다
            		InitHeadMode(true, true, false, true, false,false);
            		
            		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            		InitHeadRow(0, HeadTitle1, true);
            		
            		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            		InitDataProperty(0, cnt++,  dtDummyCheck,	20,			daCenter, 		false,	"DelChk"); 						
            		InitDataProperty(0,	cnt++ , dtData,			110,		daCenter,		true,	"val",			false,		"",		dfNone,			0,		true,		true);
            		InitDataProperty(0,	cnt++ , dtData,			100,		daCenter,		true,	"name",			false,		"",		dfNone,			0,		true,		true); 
					InitDataProperty(0,	cnt++ , dtData,			100,		daCenter,		true,	"cntr_tpsz_cd",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0,	cnt++ , dtData,			100,		daCenter,		true,	"cntr_vol_qty",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0,	cnt++ , dtData,			100,		daCenter,		true,	"rcv_term_cd",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0,	cnt++ , dtData,			100,		daCenter,		true,	"de_term_cd",	false,		"",		dfNone,			0,		true,		true);						
            		
				}	
				break;

				//Awkward Cgo Criteria 값	
    		case "sheet6": //sheet6 init
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 0;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "")
    					InitHostInfo(location.hostname, location.port, page_path);
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;
    				//전체Edit 허용 여부 [선택, Default false]
    				Editable = true;
    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 3, 100);
    				var HeadTitle1 = "|EQ Type/Size|Length|Width|Height|Length|Width|Height|Tare Weight";
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(9, 0, 0, true);
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(false, true, false, true, false, false);
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
    				InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "attr_ctnt1", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt2", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt3", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt4", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt5", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt6", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt7", false, "", dfNone, 0, true, true);
    				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt8", false, "", dfNone, 0, true, true);
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
	     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
	     		
	     		var sXml = sheetObj.GetSearchXml("VOP_SCG_0031GS.do", formParams+"&spcl_cgo_cate_cd=AK");
				ComXml2ComboItem(sXml, formObj.spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
				break;

     		case IBSEARCH_ASYNC02: //RqstInfo 조회
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
                  
                    if(ComScgXml2Array(sXml, "dg_flag") == "Y"){
					 document.getElementById("dgFlag").checked = true; 
					 document.getElementById("dgFlag").style.background = "red";
					 }
         		}				
				break;

     		case IBSEARCH_ASYNC03: //Attached File 조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0207GS.do", FormQueryString(formObj)+"&bkg_no="+formObj.bkg_no.value+"&ridr_tp_cd=A");
				if(sXml.indexOf("TOTAL='0'") < 1){
					document.getElementById("btn_AttachedFile").style.color = "red";
				}else{
					document.getElementById("btn_AttachedFile").style.color = "";					
				}
				break;

     		case IBSEARCH:      //조회
				if (formObj.scg_flg.value=="SCG_AWK") {
					oSheetObj = openerObj.sheetObjects[1];
			    	formObj.spcl_cgo_auth_rmk.disabled = true;
			    	formObj.spcl_cgo_auth_rmk.className = "input2";
				}else if (formObj.scg_flg.value=="AWK"){
					oSheetObj = openerObj.sheetObjects[3];
				}else if (formObj.scg_flg.value=="SCG_45") {
					oSheetObj = openerObj.sheetObjects[3];
			    	formObj.spcl_cgo_auth_rmk.disabled = true;
			    	formObj.spcl_cgo_auth_rmk.className = "input2";
				}else if (formObj.scg_flg.value=="45"){
					oSheetObj = openerObj.sheetObjects[5];
				}
			
     			var spcl_cgo_auth_cd = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd");
     			
				if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd") == 'Y' ) {
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;
//			    	formObj.spcl_cgo_auth_cd.options[0].selected = true;
			    	formObj.spcl_cgo_auth_cd.value = spcl_cgo_auth_cd;
			    	comboObjects[0].Enable = false;
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
			    	if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
				    	comboObjects[0].Enable = true;
				    	//formObj.spcl_cgo_auth_rmk.disabled = false;
				    	//formObj.spcl_cgo_auth_rmk.className = "input";
				    	if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className = "input1";			    		
				    	}
			    	}
			    	comboObjects[0].Code2 = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd");
			    	formObj.spcl_cgo_auth_rmk.value = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rmk");
				}else if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd") == 'P') {
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;
//			    	formObj.spcl_cgo_auth_cd.options[3].selected = true;
			    	formObj.spcl_cgo_auth_cd.value = spcl_cgo_auth_cd;
			    	if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
				    	comboObjects[0].Enable = true;
				    	comboObjects[0].BackColor = "#FFFFFF";
				    	//formObj.spcl_cgo_auth_rmk.disabled = false;
				    	//formObj.spcl_cgo_auth_rmk.className = "input";
				    	if (oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className = "input1";			    		
				    	}
			    	}
			    	comboObjects[0].Code = oSheetObj.CellValue(oSheetObj.SelectRow, "spcl_cgo_auth_rjct_cd");
			    	formObj.spcl_cgo_auth_rmk.value = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_rmk");
				}else{
			 		formObj.spcl_cgo_auth_cd.options.length = auth_length;
			    	formObj.spcl_cgo_auth_cd.options[auth_length-1].text = oSheetObj.CellText(oSheetObj.SelectRow, "spcl_cgo_auth_cd");
			 		formObj.spcl_cgo_auth_cd.options[auth_length-1].style.color = "orange";
			    	formObj.spcl_cgo_auth_cd.options[auth_length-1].selected = true;
			    	comboObjects[0].Enable = false;
			    	//formObj.spcl_cgo_auth_rmk.disabled = true;
			    	formObj.spcl_cgo_auth_rmk.value = "";
			    	//formObj.spcl_cgo_auth_rmk.className = "input";
				}
				
				document.getElementById("pol_cd").innerText = oSheetObj.CellValue(oSheetObj.SelectRow, "pol_cd");
				document.getElementById("pod_cd").innerText = oSheetObj.CellValue(oSheetObj.SelectRow, "pod_cd");
				document.getElementById("pol_nod_cd").value = oSheetObj.CellValue(oSheetObj.SelectRow, "pol_yd_cd").substring(5,7);
				document.getElementById("pod_nod_cd").value = oSheetObj.CellValue(oSheetObj.SelectRow, "pod_yd_cd").substring(5,7);
    			if(validateForm(sheetObj,formObj,sAction))
					formObj.f_cmd.value = SEARCH;

    				var resultXml = sheetObj.GetSearchXml("ESM_BKG_0055GS.do", FormQueryString(formObj)); 
    				var arrXml = resultXml.split("|$$|");

    				if (arrXml.length == 6) {
								
    					var etcXml = arrXml[0];

    					sheetObjects[0].LoadSearchXml(arrXml[1], false);
    					sheetObjects[1].LoadSearchXml(arrXml[0], false);
    					sheetObjects[2].LoadSearchXml(arrXml[2], false);
    					sheetObjects[3].LoadSearchXml(arrXml[4], false);
    					sheetObjects[4].LoadSearchXml(arrXml[3], false);
    					sheetObjects[5].LoadSearchXml(arrXml[5], false);
								
    					if(document.getElementById("bkg_no").value == ""){
    						document.getElementById("bkg_no").value = sheetObjects[1].CellValue(1, "bkg_no");
    					}

    					document.getElementById("bl_no").value = sheetObjects[2].CellValue(1, "bl_no");
    					document.getElementById("package_sum").innerText = sheetObjects[2].CellValue(1, "pck_qty");
    					document.getElementById("pck_tp_cd").innerText = sheetObjects[2].CellValue(1, "pck_tp_cd");
    					document.getElementById("weight_sum").innerText = sheetObjects[2].CellText(1, "grs_wgt"); 
    					document.getElementById("wgt_ut_cd").innerText = sheetObjects[2].CellValue(1, "wgt_ut_cd");
    			    	document.getElementById("stwg_cd").innerText = sheetObjects[2].CellValue(1, "stwg_cd");
						
    			    	htmlSheetSync();

						//Attached File 조회
				        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
    				}
    				break;
    				
     		case SEARCH01:
     			if (validateForm(sheetObj, formObj, sAction))
     				formObj.f_cmd.value = SEARCH15;
     			var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", "f_cmd="+SEARCH15+"&bkgNo="+formObj.bkg_no.value);
     			var bkgCombine = ComGetEtcData(sXml, "bkg_combine");
     			var bkgSplit = ComGetEtcData(sXml, "bkg_split");
     			formObj.bkg_combine.value = bkgCombine;
     			formObj.bkg_split.value = bkgSplit;
     			break;

     		case SEARCH02:
			
     			var jXml = null;
    			var wgtPass = "";
    			var cntrTpSzPass = "";
    			var cntrTpSzWgt = "";
    			Row = sheetObjects[1].SelectRow;
    			
     			var jParam = "f_cmd="+COMMAND04;
				jParam = jParam+"&bkg_no="+sheetObjects[1].CellValue(Row, "bkg_no")
						  +"&cntr_no="+sheetObjects[1].CellValue(Row, "cntr_no")
						  +"&grs_wgt="+sheetObjects[1].CellValue(Row, "grs_wgt")
				          +"&cntr_tpsz_cd="+sheetObjects[1].CellValue(Row, "cntr_tpsz_cd")
						  +"&wgt_ut_cd="+sheetObjects[1].CellValue(Row, "wgt_ut_cd");
				
				jXml = sheetObj.GetSearchXml("ESM_BKG_0055GS.do", jParam);
				wgtPass = ComGetEtcData(jXml, "wgt_pass");
				cntrTpSzPass = ComGetEtcData(jXml, "cntr_tp_sz_pass");
				cntrTpSzWgt  = ComGetEtcData(jXml, "cntr_tp_sz_wgt");
				
				if ( "" != wgtPass && wgtPass == 'N') {  // N 일때만 wgtPass 할당됨, WARNIG MSG  
					ComShowCodeMessage("SCG50035");  
				}else if ( "X" == wgtPass ) {  //  VSK_PORT_GNTR_CRN.GRS_MAX_WGT is null 일때, 2014.08.05
					ComShowCodeMessage("SCG50043");  
				}
				
				return true;
				
     			break;
         }
     }

    //업무 자바스크립트 OnKeyPress 이벤트 Catch
    function initControl() {
    	axon_event.addListener('change', 		'auth_OnChange', 	'spcl_cgo_auth_cd');
//    	axon_event.addListener('change', 		'rjct_OnChange', 	'spcl_cgo_auth_rjct_cd');
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

     /**
      * 부모창에서 선택한 conter_no의 값을 활성화 시킨다.
      */
     function sheet2_OnSearchEnd(sheetObj, Row, Col, Value) {
    	 sheetObjects[1].ColumnSort("awk_cgo_seq","ASC");
    	 for (var i=1;i<=sheetObjects[1].RowCount;i++){
    		 if (sheetObjects[1].CellText(i, "awk_cgo_seq") == document.getElementById("awk_cgo_seq").value) {
    			 sheetObj.SelectCell(i,"awk_cgo_seq");
    		 }
    		 setAuthStat(sheetObj, i);
    	 }
     }

     function htmlSheetSync(){
    	 Row = sheetObjects[1].SelectRow;
    	 IBS_CopyRowToForm(sheetObjects[1], form, Row);	   
	   
    	 document.getElementById("frm_pck_qty").innerText = sheetObjects[1].CellText(Row, "pck_qty");
    	 document.getElementById("frm_grs_wgt").innerText = sheetObjects[1].CellText(Row, "grs_wgt");
    	 document.getElementById("frm_net_wgt").innerText = sheetObjects[1].CellText(Row, "net_wgt");
    	 document.getElementById("temp_grs_wgt").value = sheetObjects[1].CellText(Row, "grs_wgt");
    	 document.getElementById("temp_net_wgt").value = sheetObjects[1].CellText(Row, "net_wgt");
    	 document.getElementById("temp_cntr_no").value = sheetObjects[1].CellValue(Row, "cntr_no");
    	 document.getElementById("rcv_term_cd").value = sheetObjects[1].CellValue(Row, "rcv_term_cd");
    	 document.getElementById("de_term_cd").value = sheetObjects[1].CellValue(Row, "de_term_cd");		
    	 document.getElementById("frm_cntr_cgo_seq").value = sheetObjects[1].CellValue(Row, "cntr_cgo_seq");

    	 if (sheetObjects[1].CellValue(Row, "cntr_tpsz_cd") == "D7"){
 			document.getElementById("ttl_dim_len").value = "1,317.6";
			document.getElementById("ttl_dim_wdt").value = "243.8";
			document.getElementById("ttl_dim_hgt").value = "289.6";
			document.getElementById("ovr_fwrd_len").value = "0";
			document.getElementById("ovr_bkwd_len").value = "0";
			document.getElementById("ovr_lf_len").value = "0";
			document.getElementById("ovr_rt_len").value = "0";
			document.getElementById("ovr_hgt").value = "0";
			document.getElementById("ovr_void_slt_qty").value = "0";
			
			sheetObjects[1].CellValue2(Row, "ttl_dim_len") = document.getElementById("ttl_dim_len").value;
			sheetObjects[1].CellValue2(Row, "ttl_dim_wdt") = document.getElementById("ttl_dim_wdt").value;
			sheetObjects[1].CellValue2(Row, "ttl_dim_hgt") = document.getElementById("ttl_dim_hgt").value;
			sheetObjects[1].CellValue2(Row, "ovr_fwrd_len") = document.getElementById("ovr_fwrd_len").value;
			sheetObjects[1].CellValue2(Row, "ovr_bkwd_len") = document.getElementById("ovr_bkwd_len").value;
			sheetObjects[1].CellValue2(Row, "ovr_lf_len") = document.getElementById("ovr_lf_len").value;
			sheetObjects[1].CellValue2(Row, "ovr_rt_len") = document.getElementById("ovr_rt_len").value;
			sheetObjects[1].CellValue2(Row, "ovr_hgt") = document.getElementById("ovr_hgt").value;
			sheetObjects[1].CellValue2(Row, "ovr_void_slt_qty") = document.getElementById("ovr_void_slt_qty").value;
			sheetObjects[1].CellValue2(Row, "temp_ovr_void_qty") = document.getElementById("ovr_void_slt_qty").value;
    	 }else{
    		 document.getElementById("ttl_dim_len").value = sheetObjects[1].CellText(Row, "ttl_dim_len");
    		 document.getElementById("ttl_dim_wdt").value = sheetObjects[1].CellText(Row, "ttl_dim_wdt");
    		 document.getElementById("ttl_dim_hgt").value = sheetObjects[1].CellText(Row, "ttl_dim_hgt");
    		 document.getElementById("ovr_fwrd_len").value = sheetObjects[1].CellText(Row, "ovr_fwrd_len");
    		 document.getElementById("ovr_bkwd_len").value = sheetObjects[1].CellText(Row, "ovr_bkwd_len");
    		 document.getElementById("ovr_lf_len").value = sheetObjects[1].CellText(Row, "ovr_lf_len");
    		 document.getElementById("ovr_rt_len").value = sheetObjects[1].CellText(Row, "ovr_rt_len");
    		 document.getElementById("ovr_hgt").value = sheetObjects[1].CellText(Row, "ovr_hgt");
    		 document.getElementById("ovr_void_slt_qty").value = sheetObjects[1].CellValue(Row, "ovr_void_slt_qty");
    		 sheetObjects[1].CellValue2(Row, "temp_ovr_void_qty") = sheetObjects[1].CellValue(Row, "ovr_void_slt_qty");
    	 }
		
    	 document.getElementById("wgt_ut_cd1").value = sheetObjects[1].CellValue(Row, "wgt_ut_cd");
    	 document.getElementById("wgt_ut_cd2").value = sheetObjects[1].CellValue(Row, "wgt_ut_cd");	 
    	 
    	 document.getElementById("crn_pst_sts_cd").value = sheetObjects[1].CellValue(Row, "crn_pst_sts_cd");
    	 document.getElementById("pst_lck_pin_flg").value = sheetObjects[1].CellValue(Row, "pst_lck_pin_flg");	   
    	 document.getElementById("temp_cntr_no").value = sheetObjects[1].CellValue(Row, "cntr_no");
    	 document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(Row, "cntr_tpsz_cd");	

    	 if(sheetObjects[1].CellValue(Row, "ovr_void_slt_qty") == "0"){
    		 document.getElementById("inGauge").checked = true;
    	 }else{
    		 document.getElementById("inGauge").checked = false;
    	 }
	   
    	 var awk_cgo_seq = sheetObjects[1].CellValue(Row, "awk_cgo_seq")
    	 var findDetail = sheetObjects[3].FindText("awk_cgo_seq", awk_cgo_seq, 0, 2); 
	   
    	 if(sheetObjects[1].RowCount > 0 && findDetail > 0){
    		 document.getElementById("details_button").style.color = "red";
    	 }else{
    		 document.getElementById("details_button").style.color = "";
    	 }
    	 document.getElementById("stwg_rqst_desc").value = sheetObjects[1].CellValue(Row, "stwg_rqst_desc");
    	 document.getElementById("diff_rmk").value = sheetObjects[1].CellValue(Row, "diff_rmk");
     }     

     function auth_OnChange() {
 		var obj      = event.srcElement;
 		var formObj  = document.form;
 		formObj.spcl_cgo_auth_cd.options.length = auth_length-1;
 		if (obj.value == "N" || obj.value == "" || obj.value == "M") {
   			comboObjects[0].Code = "";
   			comboObjects[0].Enable = true;
	    	comboObjects[0].BackColor = "#CCFFFD";
   			//formObj.spcl_cgo_auth_rmk.disabled = false;
   			//formObj.spcl_cgo_auth_rmk.className = "input";
   			formObj.spcl_cgo_auth_rmk.value = "";
   			formObj.apro_ref_no.value = "";
    		document.getElementById("apro_ref_no").disabled = true;
 			document.getElementById("apro_ref_no").className = "input2";
 		}else if (obj.value == "P") {
   			comboObjects[0].Code = "";
 			comboObjects[0].Enable = true;
 			comboObjects[0].BackColor = "#FFFFFF";
 			//formObj.spcl_cgo_auth_rmk.disabled = false;
 			//formObj.spcl_cgo_auth_rmk.className = "input";
   			formObj.spcl_cgo_auth_rmk.value = "";
 			formObj.apro_ref_no.value = "";
 			document.getElementById("apro_ref_no").disabled = true;
 			document.getElementById("apro_ref_no").className = "input2";
 		}else{
   			comboObjects[0].Code = "";
   			comboObjects[0].Enable = false;
   			formObj.spcl_cgo_auth_rmk.value = "";
   			//formObj.spcl_cgo_auth_rmk.disabled = true;
   			//formObj.spcl_cgo_auth_rmk.className = "input";
            if (formObj.scg_flg.value=="AWK" && openerObj.sheetObjects[3].CellText(openerObj.sheetObjects[3].SelectRow, "crr_code") != "SML") {
	    		document.getElementById("apro_ref_no").disabled = false;
	    		document.getElementById("apro_ref_no").className = "input";
            }else if (formObj.scg_flg.value=="45") {
	    		document.getElementById("apro_ref_no").disabled = false;
	    		document.getElementById("apro_ref_no").className = "input";
            }
 		}
     }
 	
     function spcl_cgo_auth_rjct_cd_OnChange(comboObj, code, text) {
  		var formObj  = document.form;
 		
 		if (code == "AAA") {
  			document.getElementById("spcl_cgo_auth_rmk").className = "input1";
 			formObj.spcl_cgo_auth_rmk.value = '';
 		}else{
  			document.getElementById("spcl_cgo_auth_rmk").className = "input";
 			formObj.spcl_cgo_auth_rmk.value = comboObj.GetText(code, 1);
 		}
      }
     
     /**
      * IBSheet Object에서 팝업을 클릭시
      */
     function onPopupClick(srcName){
    	 var formObj = document.form;    
		 var row = formObj.row.value;
		 if (formObj.scg_flg.value=="SCG_AWK") {
			 oSheetObj = openerObj.sheetObjects[1];					
		 }else if (formObj.scg_flg.value=="AWK"){
			 oSheetObj = openerObj.sheetObjects[3];
		 }else if (formObj.scg_flg.value=="SCG_45") {
			 oSheetObj = openerObj.sheetObjects[3];
		 }else if (formObj.scg_flg.value=="45"){
			 oSheetObj = openerObj.sheetObjects[5];
		 }
    	 if (srcName == "btn_PolCd") {
    		 ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd="+formObj.pol_cd.value, 1005, 680, "", '0,0', true);    		 
    	 }else if (srcName == "btn_PodCd" ) {
    		 ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd="+formObj.pod_cd.value, 1005, 680, "", '0,0', true);
    	 }else if (srcName == "btns_Package") {
    	      ComOpenPopup("ESM_BKG_0696POP.do?searcheKeyOpener="+formObj.frm_pck_tp_cd.value, 405, 470, "","0,0,1,1,1", true);
    	 }else if (srcName == "btns_Commodity") {
    		 ComOpenPopup("ESM_BKG_0653.do?cmdt_cd="+formObj.frm_cmdt_cd.value, 823, 700, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btns_DgCntrSeq") {
    		 ComOpenWindowCenter("ESM_BKG_0754.do?bkgNo="+formObj.bkg_no.value+"&cntrNo="+formObj.temp_cntr_no.value+"&cntrTpszCd="+formObj.cntr_tpsz_cd.value, "ESM_BKG_0754", 805, 320, true);
    	 }else if (srcName == "btn_Criteria") {
    		 ComOpenPopup("ESM_BKG_0057.do", 505, 400, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btn_Details") {
    		 ComOpenWindowCenter("ESM_BKG_0756.do?bkgNo="+formObj.bkg_no.value+"&awkCgoSeq="+formObj.awk_cgo_seq.value, "ESM_BKG_0756", 400, 310, true);
    	 }else if (srcName == "btn_AttachedFile") {
    		 ComOpenPopup("ESM_BKG_0207.do?bkg_no="+formObj.bkg_no.value+"&ridr_tp_cd=A&disableYn=Y", 523, 525, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btn_ApprovalDetails") {
    		 ComOpenPopup("VOP_SCG_1016.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value, 1005, 520, "", '0,0', true);
    		 /*VVD별 Aproval History를 보고 싶은겨우 아래 링크를 활성화한다.
    		  * 서동호 부장님 요건 변경으로 인한 BKG_NO별 Aproval History를 보여준다.
    		  * ComOpenPopup("VOP_SCG_1016.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value+"&vsl_cd="+formObj.vvd_cd.value.substring(0,4)+"&skd_voy_no="+formObj.vvd_cd.value.substring(4,8)+"&skd_dir_cd="+formObj.vvd_cd.value.substring(8,9), 1000, 450, "", '0,0', true);
    		 */
    	 }else if (srcName == "btn_Prev") {
    		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
    			 if (!setParentValue()) return false;
    		 }
    		 
    		 if(!checkGcraneWeight())
    			 return;   // POL/POD info 의 해당 yard G/Crane의 max weight with spreader 와 CNTR의 Gross + tare Weight 체크
    		 
    		 if (row == 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 oSheetObj.SelectCell( parseInt(row)-1 , oSheetObj.SelectCol);
    			 formObj.bkg_no.value = oSheetObj.CellValue( parseInt(row)-1 , "bkg_no");
    			 formObj.vvd_cd.value = oSheetObj.CellText(parseInt(row)-1, "vsl_cd")+oSheetObj.CellText(parseInt(row)-1, "skd_voy_no")+oSheetObj.CellText(parseInt(row)-1, "skd_dir_cd");
    			 formObj.awk_cgo_seq.value = oSheetObj.CellValue( parseInt(row)-1 , "awk_cgo_seq");
    			 formObj.row.value = parseInt(row)-1;
    			 loadPage2();
    		 }
    	 }else if (srcName == "btn_Next") {
    		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
    			 if (!setParentValue()) return false;
    		 }
    		 if (row == oSheetObj.LastRow ) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 
    			 if(!checkGcraneWeight())
        			 return;   // POL/POD info 의 해당 yard G/Crane의 max weight with spreader 와 CNTR의 Gross + tare Weight 체크
    			 
    			 
    			 oSheetObj.SelectCell( parseInt(row)+1 , oSheetObj.SelectCol);
    			 formObj.bkg_no.value = oSheetObj.CellValue( parseInt(row)+1 , "bkg_no");
    			 formObj.vvd_cd.value = oSheetObj.CellText(parseInt(row)+1, "vsl_cd")+oSheetObj.CellText(parseInt(row)+1, "skd_voy_no")+oSheetObj.CellText(parseInt(row)+1, "skd_dir_cd");
    			 formObj.awk_cgo_seq.value = oSheetObj.CellValue( parseInt(row)+1 , "awk_cgo_seq");
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
		 if (formObj.scg_flg.value=="SCG_AWK") {
			 oSheetObj = openerObj.sheetObjects[1];					
		 }else if (formObj.scg_flg.value=="AWK"){
			 oSheetObj = openerObj.sheetObjects[3];					
		 }else if (formObj.scg_flg.value=="SCG_45") {
			 oSheetObj = openerObj.sheetObjects[3];					
		 }else if (formObj.scg_flg.value=="45"){
			 oSheetObj = openerObj.sheetObjects[5];
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
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_cd") 		= "Y";
    				 oSheetObj.CellValue( i , "apro_ref_no") 			= formObj.apro_ref_no.value;
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
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd") 	= comboObjects[0].Code;
			 if (comboObjects[0].Code == 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
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

			 if (comboObjects[0].Code == '') {
    			 ComShowCodeMessage('SCG50011', 'RJT Code');
    			 formObj.spcl_cgo_auth_rjct_cd.focus();
    			 return false;
			 }
			 
    		 for (var i = 2; i <= oSheetObj.LastRow; i ++)
    		 {
    			 if (bkgNo == oSheetObj.CellText(i, "bkg_no") && befVVD == oSheetObj.CellText(i, "vsl_cd")+oSheetObj.CellText(i, "skd_voy_no")+oSheetObj.CellText(i, "skd_dir_cd")) {
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_cd") 	= "N";
    				 oSheetObj.CellValue( i , "apro_ref_no")		= formObj.apro_ref_no.value;
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_rjct_cd")		= comboObjects[0].Code
    				 oSheetObj.CellValue( i , "spcl_cgo_auth_rmk")		= formObj.spcl_cgo_auth_rmk.value;
    			 }
    		 }
		 }else if (formObj.spcl_cgo_auth_cd.value != ""){
			 if (comboObjects[0].Code == '') {
    			 ComShowCodeMessage('SCG50011', 'RJT Code');
    			 formObj.spcl_cgo_auth_rjct_cd.focus();
    			 return false;
			 }
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_cd") 		= formObj.spcl_cgo_auth_cd.value;
			 oSheetObj.CellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd") 	= comboObjects[0].Code;
			 if (comboObjects[0].Code == 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
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
    	 var scg_flg   = "";
		 if (formObj.scg_flg.value=="SCG_AWK") {
			 oSheetObj = openerObj.sheetObjects[1];					
	    	 scg_flg   = "AK";
		 }else if (formObj.scg_flg.value=="AWK"){
			 oSheetObj = openerObj.sheetObjects[3];					
	    	 scg_flg   = "AK";
		 }else if (formObj.scg_flg.value=="SCG_45") {
			 oSheetObj = openerObj.sheetObjects[3];					
	    	 scg_flg   = "45";
		 }else if (formObj.scg_flg.value=="45"){
			 oSheetObj = openerObj.sheetObjects[5];
	    	 scg_flg   = "45";
		 }
    	 
		 var crr_cd                 = oSheetObj.CellText(oSheetObj.SelectRow, "crr_cd");
		 var bkg_ref_no             = "";
		 var spcl_cgo_rqst_seq      = "";
    	 
    	 var bkg_no                 = formObj.bkg_no.value; ;
    	 var spcl_cgo_apro_rqst_seq = formObj.spcl_cgo_apro_rqst_seq.value;
		 var vsl_pre_pst_cd         = oSheetObj.CellText(oSheetObj.SelectRow, "vsl_pre_pst_cd");
		 var vsl_seq                = oSheetObj.CellText(oSheetObj.SelectRow, "vsl_seq");
    	 var rgn_shp_opr_cd         = openerObj.document.all.rgn_shp_opr_cd.Code;
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
        	 comboObjects[0].Enable = true;
        	 comboObjects[0].BackColor = "#FFFFFF";
        	 //formObj.spcl_cgo_auth_rmk.disabled = false;
        	 //formObj.spcl_cgo_auth_rmk.className = "input";
        	 formObj.mailYn.value = "Y";
    	 //}
     }     
     
     /*
      * POL/POD info 의 해당 yard G/Crane의 max weight with spreader 와 CNTR의 Gross + tare Weight 체크 
      */
     function checkGcraneWeight() {    	
	    	if(!doActionIBSheet(sheetObjects[0],document.form,SEARCH02)){
	    		return false;
	    	}else{
	    		return true;
	    	} 
     }
     
      // 닫기 이벤트에 대한 checkGcraneWeight 체크
      function win_close() {
    	  if(closeChk != "Y"){
    		  checkGcraneWeight();
    	  }
      }
 
     
	/* 개발자 작업  끝 */