/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_0140.js
*@FileTitle : MOT/SSE Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.24 송호진
* 1.0 Creation
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
* 2013.08.29 송호진 [CHM-201431591] MOT Filing 양식 변경 - O.EIC, O.SLF 추가
* 2013.11.20 송호진 [CHM-201432654] MOT/SSE Filing (2014/12/01 부) 열 추가 : POD, D.Term
* 2016.01.13 [CHM-201539514] SSE Agreement Filing 상 Surcharge 추가 요청 Requested By SELCMA / Kim GyungUk
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
     * @class ESM_PRI_0140 : ESM_PRI_0140 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0140() {
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
    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var sheet1;
    var sheet2;
    //  업무전역변수
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function loadPage() {
        var form = document.form;	
        sheet1 = sheetObjects[0];
        sheet2 = sheetObjects[1];
        sheetCnt = sheetObjects.length ;
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
        
	   	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
		 
		// 당일 날짜로 default setting
		gCurrDate = ComGetDateAdd(null, "D", 0)
		 	
	    //form.exec_dt.value = gCurrDate;
	    form.fr_file_dt.value = gCurrDate;
	    form.to_file_dt.value = gCurrDate;
        sheet1.WaitImageVisible = false;    

    }

     /**
      * OnKeyDown event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param 없음
      * @return 없음
      * @author 강효진
      * @version 2010.04.26
      */       
     function obj_keydown(){
        //enter key조회
        var eleName = event.srcElement.name;
        if (eleName == "fr_file_dt" || eleName == "to_file_dt"){
            var keyValue = null;
            if(event == undefined || event == null) {
         	   keyValue = 13;
            }else{
         	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            }
            if (keyValue == 13){
            	if (validateForm(sheet1, form, IBSEARCH)) {
            		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            	}
            }
        }
     }

     /** 
      * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
      * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음  
      * @return 없음
      * @see #
      * @author 강효진
      * @version 2010.04.23
      */ 
     function obj_deactivate() {
         var form = document.form;
         var formObj = event.srcElement;

         ComChkObjValid(formObj);
     }
      
     
    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                	// 높이 설정
                	style.height = 450;
                	//전체 너비 설정
                	SheetWidth = mainTable.clientWidth;

                	//Host정보 설정[필수][HostIp, Port, PagePath]
                	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                	//전체Merge 종류 [선택, Default msNone]
                	//MergeSheet = msAll;

                	//전체Edit 허용 여부 [선택, Default false]
                	//Editable = true;

                	//Row의 자동 줄바꿈 하지 않음
                	AutoRowHeight = false;

                	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                	InitRowInfo( 1, 1, 3, 100);

                	var HeadTitle = "|File Date|Seq.|BKG Source|BKG No.|Carrier|Contract No.|Contract Holder|Shipper Name|Lane|Origin\n(POR)|POD|Dest\n(DEL)|D.Term|CNTR\nType|CMDT\nType|Actual\nCustomer|Pre-Relay|Post-Relay|Size" +
									"|MQC1|MQC2|Rate|Commission|BAF|CAF|O.THC|D.THC|*APS|*CSR|*PSC|*PCC|*PCS|*STF|D.ACT|D.DDC|D.DDF|D.NFC|O.ENS|O.EIC|O.SLF|O/D|T.DIS|T.GOH|T.WSC|OBS|BCC|BLR|LBP|CTC|LSI|O.CMS|D.OCP|D.DCS|Effective\nDate|Expiry\nDate|Remark(s)";
                	var headCount = ComCountHeadTitle(HeadTitle);

                	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(headCount, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false, false)

                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle, true);

                	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++ , dtHiddenStatus,	100,	daCenter,	false,	"Status");
                	InitDataProperty(0, cnt++ , dtData,  80,	daCenter,	false,	"bat_exe_dt", 			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  30,	daRight,	false,	"seq",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  80,	daCenter,	false,	"bkg_src_tp_cd",		false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  100,	daCenter,	false,	"bkg_no",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"carrier",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  90,	daCenter,	false,	"ctrt_no",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"ctrt_hld_nm",			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"shpr_nm",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"lane",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"por_cd",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"mot_file_ib_port_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"del_cd",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"mot_file_de_term_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cntr_tp",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cmdt_tp",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"act_cust_nm",			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"mot_file_pre_rly_port_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"mot_file_pst_rly_port_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cntr_sz",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"mqc1",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"mqc2",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oft_rt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  80,	daRight,	false,	"blnk1",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"baf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"caf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"othc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dthc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"aps_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"csr_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"psc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"pcc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"pcs_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"stf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dact_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dddc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dddf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dnfc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oens_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oeic_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oslf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"od_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"tdis_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"tgoh_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"twsc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"obs_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"bcc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"blr_amt",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"lbp_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"ctc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"lsi_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"ocms_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"docp_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"ddcs_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"eff_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"exp_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  120,	daLeft,		false,	"remark",				false,"",dfNone,	0,false,false);
                	
                	ColHidden ( "bat_exe_dt" ) = true;
                	ColHidden ( "bkg_src_tp_cd" ) = true;
                	ColHidden ( "bkg_no" ) = true;
                	
                }
                break;
            case "sheet2":
                with (sheet2) {
                	// 높이 설정
                	//style.height = 0;
                	//전체 너비 설정
                	//SheetWidth = mainTable.clientWidth;

                	//Host정보 설정[필수][HostIp, Port, PagePath]
                	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                	//전체Merge 종류 [선택, Default msNone]
                	//MergeSheet = msAll;

                	//전체Edit 허용 여부 [선택, Default false]
                	//Editable = true;

                	//Row의 자동 줄바꿈 하지 않음
                	AutoRowHeight = false;

                	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                	InitRowInfo( 1, 1, 3, 100);

                	var HeadTitle = "|File Date|Seq.|BKG Source|BKG No.|Carrier|Contract No.|Contract Holder|Shipper Name|Lane|Origin\n(POR)|POD|Dest\n(DEL)|D.Term|CNTR\nType|CMDT\nType|Actual\nCustomer|Pre-Relay|Post-Relay|Size" +
                					"|MQC1|MQC2|Rate|Commission|BAF|CAF|O.THC|D.THC|*APS|*CSR|*PSC|*PCC|*PCS|*STF|D.ACT|D.DDC|D.DDF|D.NFC|O.ENS|O.EIC|O.SLF|O/D|T.DIS|T.GOH|T.WSC|OBS|BCC|BLR|LBP|CTC|LSI|O.CMS|D.OCP|D.DCS|Effective\nDate|Expiry\nDate|Remark(s)";
                	var headCount = ComCountHeadTitle(HeadTitle);

                	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(headCount, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false, false)

                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle, true);

                	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++ , dtHiddenStatus,	100,	daCenter,	false,	"Status");
                	InitDataProperty(0, cnt++ , dtData,  80,	daCenter,	false,	"bat_exe_dt", 			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  30,	daRight,	false,	"seq", 					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  80,	daCenter,	false,	"bkg_src_tp_cd",		false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  100,	daCenter,	false,	"bkg_no",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"carrier",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  90,	daCenter,	false,	"ctrt_no",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"ctrt_hld_nm",			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"shpr_nm",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"lane",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"por_cd",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"mot_file_ib_port_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"del_cd",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"mot_file_de_term_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cntr_tp",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cmdt_tp",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"act_cust_nm",			false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"mot_file_pre_rly_port_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"mot_file_pst_rly_port_cd",	false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cntr_sz",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"mqc1",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"mqc2",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oft_rt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  80,	daRight,	false,	"blnk1",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"baf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"caf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"othc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dthc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"aps_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"csr_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"psc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"pcc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"pcs_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"stf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dact_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dddc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dddf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"dnfc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oens_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oeic_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oslf_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"od_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"tdis_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"tgoh_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"twsc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"obs_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"bcc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"blr_amt",					false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"lbp_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"ctc_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"lsi_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"ocms_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"docp_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"ddcs_amt",				false,"",dfNone,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"eff_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"exp_dt",				false,"",dfDateYmd,	0,false,false);
                	InitDataProperty(0, cnt++ , dtData,  120,	daLeft,		false,	"remark",				false,"",dfNone,	0,false,false);
                	
                	ColHidden ( "bat_exe_dt" ) = true;
                	ColHidden ( "bkg_src_tp_cd" ) = true;
                	ColHidden ( "bkg_no" ) = true;
                	
                }
                break;

        }
    }


    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function processButtonClick(){
        var form = document.form;
        var rdoDateObj = form.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":
                	if (validateForm(sheet1, form, IBSEARCH)) {
                		doActionIBSheet(sheet1, form, IBSEARCH);
                	}
                    break;

                case "btn_Downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;
/*
       		    case "btns_calendar1": //From 달력버튼
					var cal = new ComCalendar();
					cal.select(form.fr_file_dt, 'yyyy-MM-dd');
					break;
*/
       		    case "btns_calendar": //To 달력버튼
       		    	var cal = new ComCalendarFromTo();
                    cal.select(form.fr_file_dt, form.to_file_dt, 'yyyy-MM-dd');
                    break;

                case "btn_close":
                    window.close();
                    break;


            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH: //조회

                ComOpenWait(true);

                formObj.f_cmd.value = SEARCH;
                setParam(formObj);
                sheet1.DoSearch("ESM_PRI_0140GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;

            case IBDOWNEXCEL:      //download excel
            
            	if ( sheetObj.rowCount <= 0) return;

            	//sheetObj.SpeedDown2Excel(-1);
                
            	var saveFileName = sheetObj.SaveFileDialog("ExcelDown", "", "C:\\","엑셀파일(*.xls)|*.xls" );
	            
            	var inqTp = ComGetObjValue ( formObj.inq_tp_rdo );
            	var inqTpNm = "";
            	var dayBetween = ComGetDaysBetween ( formObj.fr_file_dt.value, formObj.to_file_dt.value );
            	var colList = "0" + ( dayBetween > 0 ? "|1" : "" ) + "|2" + ( inqTp == "2" ? "|3|4" : "" ) + "|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56";
            	//var colList = "0" + ( dayBetween > 0 ? "|1" : "" ) + "|2" + ( inqTp == "2" ? "|3|4" : "" ) + "|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53"; <<< 컬럼 추가시 반드시 갯수만큼 늘림(중요)
            	var bkgColHiddenFlag = true;
            	var dtColHiddenFlag = true;
            		
            	if ( inqTp == "1" ) {
            		inqTpNm = "Log";
            	} else if ( inqTp == "2" ) { 
            		inqTpNm = "LogWithBkg";
            		bkgColHiddenFlag = false;
            	} else if ( inqTp == "3" ) {
            		inqTpNm = "File";
            	}
            	
            	if ( dayBetween > 0 ) {
            		dtColHiddenFlag = false;
            	}
            	
            	sheetObjects[1].ColHidden ( "bat_exe_dt" ) = dtColHiddenFlag;
            	sheetObjects[1].ColHidden ( "bkg_src_tp_cd" ) = bkgColHiddenFlag;
            	sheetObjects[1].ColHidden ( "bkg_no" ) = bkgColHiddenFlag;
            		
	            if (saveFileName == '' || saveFileName == "<USER_CANCEL>") {
	            	return;
	            } else {

	            	ComOpenWait(true);
	            	var currSearchBgnRow = 1;
	            	var nextSearchBgnRow = 1;
	            	
	            	var filePath = saveFileName .substr ( 0, saveFileName.lastIndexOf("\\") + 1 ) ;	            	

	            	do {
	            		
		            	var sameDateRange = sheetObj.GetColSameDataRange ( currSearchBgnRow, "bat_exe_dt" ).split("|");
	            		nextSearchBgnRow = parseInt(sameDateRange[1]) + 1;

	            		var fileName = "";

	            		var datePart =  ComReplaceStr( sheetObj.CellValue ( currSearchBgnRow, "bat_exe_dt"), "-", "." );
		            	if ( nextSearchBgnRow - currSearchBgnRow <= 50000 ) {
		            		fileName = filePath + datePart + "_MOTFiling_" + inqTpNm + ".xls";
		            		sheetObjects[1].RemoveAll();
		            		sheetObj.Copy2SheetCol ( sheetObjects[1], colList, colList, currSearchBgnRow, nextSearchBgnRow - 1, -1, 2, true  );
		            		sheetObjects[1].SpeedDown2Excel ( -1, false, false, fileName );
		            	} else {
		            		var idx = 0;
		            		var ordNumDesc = "";
		            		do {
		            			idx++;
		            			if ( idx == 1) ordNumDesc = idx+"st";
		            			else if ( idx == 2 ) ordNumDesc = idx+"nd";
		            			else if ( idx == 3 ) ordNumDesc = idx+"rd";
		            			else if ( idx > 4 ) ordNumDesc = idx+"th";
		            			fileName = filePath + datePart + "_MOTFiling_" + inqTpNm + ordNumDesc + ".xls";
			            		sheetObjects[1].RemoveAll();
		            			sheetObj.Copy2SheetCol ( sheetObjects[1], colList, colList, currSearchBgnRow, Math.Min ( currSearchBgnRow + 49999, nextSearchBgnRow - 1 ), -1, 2, true  );
		            			sheetObjects[1].SpeedDown2Excel ( -1, false, false, fileName );
		            			currSearchBgnRow = Math.Min( currSearchBgnRow + 49999, nextSearchBgnRow - 1 ) + 1;
		            		} while ( currSearchBgnRow < nextSearchBgnRow ) ;
		            	}
		            	currSearchBgnRow = nextSearchBgnRow	;	            	
	            	} while ( nextSearchBgnRow < sheetObj.rowCount )
		            ComOpenWait(false);

	            }
	           	break;
                //sheet1.SpeedDown2Excel(-1);
                
                break;

        }
    }

     
	function setParam(formObj){
	/*	
		var laneChkList = "";                                                                                                                                                                                                                                                                                                                                                                                                                    
		var rCnt = formObj.lane_chk.length;                                                                                                                                                                                                                                                                                                                                                                                              
		for (i = 0; i < rCnt; i++) {                                                                                                                                                                                                                                                                                                                                                                                                            
			if (formObj.lane_chk[i].checked) {                                                                                                                                                                                                                                                                                                                                                                                       
				if (laneChkList != "") {                                                                                                                                                                                                                                                                                                                                                                                                 
					laneChkList += ", ";                                                                                                                                                                                                                                                                                                                                                                                              
				}                                                                                                                                                                                                                                                                                                                                                                                                                       
				laneChkList += "'" + formObj.lane_chk[i].value + "'";                                                                                                                                                                                                                                                                                                                                                                         
			}                                                                                                                                                                                                                                                                                                                                                                                                                               
		}
		formObj.lane_list.value = laneChkList;
				*/
		formObj.inq_tp_cd.value = ComGetObjValue ( formObj.inq_tp_rdo );
		
	}


	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	 function validateForm(sheetObj,formObj,sAction){
		  var frFileDt = form.fr_file_dt;
		  var toFileDt = form.to_file_dt;
		  var execDt = form.exec_dt;
		  
		  switch (sAction) {

		      case IBSEARCH: //조회

			      //Filing Date 입력했는지 mandatory validation
			      if(formObj.fr_file_dt.value == "") {
			    	  ComShowCodeMessage("PRI00335", frFileDt.caption);
			    	  ComSetFocus(frFileDt);
			    	  return false;
			      }
			      if(formObj.to_file_dt.value == "") {
			    	  ComShowCodeMessage("PRI00335", toFileDt.caption);
			    	  ComSetFocus(toFileDt);
			    	  return false;
			      }
		
			      // from date가 to date보다 큰지 validation
			      if(!ComChkObjValid(frFileDt)) { return false; }
			      if(!ComChkObjValid(toFileDt)) { return false; }
			      		
                  // msgs['PRI07055'] = 'Please check effective date (31 day validation)';
			      var ret = ComGetDaysBetween(frFileDt, toFileDt);
			      if(ret > 31) {
				      ComShowCodeMessage("PRI07057", "31");
    			      ComSetFocus(frFileDt);
    			      return false;
    			  }
                  break;
		  }

		 return true;
	 }
 	/**
      * OnSearchEnd 시 발생한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} ErrMsg    
      * @return 없음
      * @author 이승준
      * @version 2009.06.10
      */
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
  		var formObj = document.form;
  		if ( formObj.inq_tp_cd.value == "2") {
  			sheetObj.ColHidden ( "bkg_src_tp_cd" ) = false;
  			sheetObj.ColHidden ( "bkg_no" ) = false;
  		} else {
  			sheetObj.ColHidden ( "bkg_src_tp_cd" ) = true;
  			sheetObj.ColHidden ( "bkg_no" ) = true;  			
  		}
  		
  		if ( ComGetDaysBetween ( formObj.fr_file_dt.value, formObj.to_file_dt.value ) >= 1 ) {
  			sheetObj.ColHidden ( "bat_exe_dt" ) = false;
  		} else {
  			sheetObj.ColHidden ( "bat_exe_dt" ) = true;
  		}
  		
  	}
  	
    /**
     * IBMultiCombo 에 Item을 setting한다. <br>
     */
    function initIBComboItem() {
    	var form = document.form;
        ComPriTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'f_scp'),          "|", "\t" );
        ComPriTextCode2ComboItem(rhqComboValue,        rhqComboText,        getComboObject(comboObjects, 'f_req_rhq'),                 "|", "\t" );
        
        //alert(getComboObject(comboObjects, 'f_req_rhq'));
        ComSetObjValue(getComboObject(comboObjects, 'f_req_rhq'), ComGetObjValue(form.login_rhq_ofc_cd));
    }
  	
	/* 개발자 작업  끝 */