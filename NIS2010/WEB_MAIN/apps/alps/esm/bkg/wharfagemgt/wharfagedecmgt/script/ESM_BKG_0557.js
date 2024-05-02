/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0557.js
*@FileTitle : Wharfage Declare
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : OH DONG HYUN
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
* 2015.08.20 정선용 [CHM-201537039] Split10-Split76-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0557() {
    	this.processButtonClick		= processButtonClick;
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
    var vAccmuDeclaAmt = 0; //누적 신고금액 

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":
            		
            		obj_Init();
            		doActionIBSheet(sheetObject1,formObject,SEARCH01);
            		break;

            	case "btn_add":
            		var maxPortSeq = sheetObject1.RowCount;
            		for(var i=1; i<=sheetObject1.RowCount; i++){
				    	if( maxPortSeq == sheetObject1.CellValue(i,'sheet1_port_seq') ){
				    		++maxPortSeq;
				    	}else if(maxPortSeq < sheetObject1.CellValue(i,'sheet1_port_seq')){
				    		maxPortSeq = Number(sheetObject1.CellValue(i,'sheet1_port_seq'))+1;
				    	}
				    }
					sheetObject1.DataInsert(-1);
					
					sheetObject1.CellValue2(sheetObject1.RowCount,'sheet1_port_seq') = maxPortSeq;
					
				break;
				
				case "btn_del":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;	

	            case "btn_decIF":
	            	formObject.cancel_flag.value = "N";
	            	doActionIBSheet(sheetObjects[0],formObject,COMMAND02);
//	            	doActionIBSheet(sheetObject1,formObject,SEARCH01);
	            	break;	

	            case "btn_changeNoIF":
	            	doActionIBSheet(sheetObjects[0],formObject,COMMAND03);
	            	doActionIBSheet(sheetObject1,formObject,SEARCH01);
	            	break;	

                case "btn_erp":
                    // => Live : /http://erp.hanjin.com/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
                    // => Test : /http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
//                    ComOpenWindow('http://www.naver.com', 'erp', 'width=1024,height=700');
                   // window.open('http://www.naver.com', 'erp', 'width=1024,height=700');
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                   // ComOpenPopup("http://www.naver.com", 1024, 700, "", "1,0", false);

            		// CoBkg.js 의 ERP 호출하는 함수 실행
            		callInboundErp();
                break;

            	case "btn_save":
            		doActionIBSheet(sheetObjects[0],formObject,MULTI);
            		doActionIBSheet(sheetObject1,formObject,SEARCH01);
            		break;				
            	
            	case "btn_send":
            		if (formObject.port_cd.value == 'KRPUS' && formObject.whf_bnd_cd.value == 'IN')
            		{
            			doActionIBSheet(sheetObjects[0],formObject,COMMAND04);
            		}
            		else
            		{
            			doActionIBSheet(sheetObjects[0],formObject,COMMAND01);            			
            		}           		
            		break;				
            	case "btn_calendar1":
	                var cal = new ComCalendar();
	                cal.select(formObject.whf_ntc_dt ,'yyyy-MM-dd');
					break;
            	case "btn_calendar2":
	                var cal = new ComCalendar();
	                cal.select(formObject.whf_pay_dt ,'yyyy-MM-dd');
					break;	
            	case "btn_decCancelIF":
            		formObject.cancel_flag.value = "Y";
            		doActionIBSheet(sheetObjects[0],formObject,COMMAND02);            		
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_Change', document.form);
    	
    	formObject.vvd.focus();
    }
    
    function searcgBySelect(){
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
    }
   
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    /*
     * 조회조건입력시 자동 조회 처리
     */
    function condition_KeyUp(){
    	var formObject = document.form;
    	if( (    ComChkLen(formObject.vvd.value, 9) == "2" ) 
   				&& (ComChkLen(formObject.port_cd.value, 5) == "2" ) ){

    			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 184;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "||하역구분|운임톤/갯수|할인코드|할인율|할인 사유";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix1 = 'sheet1_';
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,			prefix1 + "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	50,		daCenter,		true,			prefix1 + "Chk",				false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,	200,	daLeft,			true,			prefix1 + "unld_tp_cd",			false,			"",      dfNone,				0,		true,		true, 21);
					InitDataProperty(0, cnt++ , dtData, 	180,	daRight,		true,			prefix1 + "ttl_ton_qty",		false,			"",      dfNullFloat,			3,		true,		true, 16);
					InitDataProperty(0, cnt++ , dtCombo,	100,	daCenter,		true,			prefix1 + "kr_whf_dc_cd",		false,			"",      dfNone,				0,		true,		true, 3);
					InitDataProperty(0, cnt++ , dtCombo,	150,	daRight,		true,			prefix1 + "rate",				false,			"",      dfNone,				0,		false,		false, 4);
					InitDataProperty(0, cnt++ , dtCombo,	170,	daLeft,			true,			prefix1 + "kr_whf_dc_rsn_cd",	false,			"",      dfNone,				0,		true,		true, 20);
					InitDataProperty(0, cnt++ , dtHidden,	150,	daRight,		true,			prefix1 + "port_seq",			false,			"",      dfInteger,				0,		false,		true, 3);
					InitDataProperty(0, cnt++ , dtHidden,	150,	daRight,		true,			prefix1 + "upd_usr_id",			false,			"",      dfNone,				0,		false,		true, 3);
					InitDataProperty(0, cnt++ , dtHidden,	150,	daRight,		true,			prefix1 + "upd_dt",				false,			"",      dfNone,				0,		false,		true, 3);
					//InitDataProperty(0, cnt++ , dtDataSeq,     				40,     daCenter,   	true,   		prefix2 + "Seq");
					
					InitDataCombo(0,  prefix1 +"unld_tp_cd",       "1.일반하역|2.기계하역|3.송유관하역|4.무연탄|5.컨테이너 20'이하|6.컨테이너 20'|7.컨테이너 30'|8.컨테이너 40'|9.컨테이너 45'", "1|2|3|4|5|6|7|8|9");
					InitDataCombo(0,  prefix1 +"kr_whf_dc_cd",     "0|1|2|3|4|7|8", "0|1|2|3|4|7|8");
					InitDataCombo(0,  prefix1 +"rate",     		   "0%|20%|50%|70%|80%|100%|30%", "0|1|2|8|3|4|7");
					InitDataCombo(0,  prefix1 +"kr_whf_dc_rsn_cd", "1.조달물품|2.군용물품|3.수출입공컨테이너|4.연안컨테이너전용선|5.투자비보전|6.화주면제|9.기타| |", "1|2|3|4|5|6|9| ");
					
					//InitUserFormat(0, prefix1 +"rate","####%","%");
					
					CountPosition = 0;
					WaitImageVisible=false;
			}
                break;


            case "sheet2":      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 132;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    var HeadTitle1 = "|구분|면제화주|면제화주|면제화주|T/S|T/S|EMPTY|EMPTY|Other\n(IPO)|T/S Total|MTY\nTotal|면제 Total";
										var HeadTitle2 = "|구분|동부제강|현대|동국|SML THRU|CUST T/S|REV.MT|REPO MT|Other\n(IPO)|T/S Total|MTY\nTotal|면제 Total";
										var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true); 
                    var prefix2 = 'sheet2_';
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,			prefix2 + "ibflag");
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			prefix2 + "size_id",			false,			"",      dfNone,		0,		false,		false);
					//InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "hyo_sung_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					//InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "dae_woo_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,		true,			prefix2 + "dong_bu_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "hyun_dai_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "dong_kuk_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,		true,			prefix2 + "thru_ts_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,		true,			prefix2 + "cust_ts_qty",		false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,		true,			prefix2 + "rev_mt_qty",			false,			"",      dfNullFloat,	3,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,		true,			prefix2 + "repo_mt",			false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					80,		daRight,		true,			prefix2 + "otr_qty",			false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		true,			prefix2 + "ts_total",			false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		true,			prefix2 + "mty_total",			false,			"",      dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		true,			prefix2 + "exempt_total",		false,			"",      dfNullFloat,	3,		false,		false);
					
					
					CountPosition = 0;
					WaitImageVisible=false;
			}
                break;
        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case SEARCH:
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value = SEARCH;   
					var aryPrefix = new Array("sheet1_"); 
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0557GS.do",FormQueryString(formObj) );
					
					if (ComGetEtcData(sXml,"mf_ref_no")){
						formObj.mf_ref_no.value = ComGetEtcData(sXml,"mf_ref_no");
						formObj.sail_dt.value   = ComGetEtcData(sXml,"sail_dt"); 
					} else {
						formObj.mf_ref_no.value = '';
						formObj.sail_dt.value   = '';
					}
        		}
        		break;
        
        	case SEARCH01:      //조회
        		ComOpenWait(true);
        		if( validateForm(sheetObj,formObj,sAction) ){
        			var prefix2 = 'sheet2_';
        			var prefix1 = 'sheet1_';	
					formObj.f_cmd.value = SEARCH01;   
					var aryPrefix = new Array("sheet1_", "sheet2_" ); //prefix 문자열 배열
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0557GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml = sXml.split("|$$|");
					
					if (arrXml.length > 0){
						
						sheetObjects[0].LoadSearchXml(arrXml[0]);
						sheetObjects[1].LoadSearchXml(arrXml[1]);
					
						var vNtcDt = ComGetEtcData(arrXml[0],"whf_ntc_dt");
						var vPayDt = ComGetEtcData(arrXml[0],"whf_pay_dt");
						var vWhfDeclNo = '';
						if( vNtcDt != null && vPayDt != null){
							formObj.whf_ntc_dt.value = vNtcDt.substring(0,4)+"-"+ vNtcDt.substring(4,6) + "-" + vNtcDt.substring(6,8);
							formObj.whf_pay_dt.value = vPayDt.substring(0,4)+"-"+ vPayDt.substring(4,6) + "-" + vPayDt.substring(6,8);
							formObj.whf_usr_nm.value = ComGetEtcData(arrXml[0],"whf_usr_nm");
						
							if( "C" == ComGetEtcData(arrXml[0],"whf_cust_knd_cd") ){ // 복수
								formObj.whf_cust_knd_cd[0].checked = true
							} else {
								formObj.whf_cust_knd_cd[1].checked = true
							}
							//TotalAmount
							formObj.whf_rt_amt.value = CommaInputWithPoint( ComGetEtcData(arrXml[0],"whf_rt_amt"), "1" );
							var vNtcAmt = ComGetEtcData(arrXml[0],"ntc_amt");
							//신고금액
							formObj.ntc_amt.value = CommaInputWithPoint( vNtcAmt, "1" );
							vWhfDeclNo = ComGetEtcData(arrXml[0],"whf_decl_no") ;
							//Dec No
							formObj.whf_decl_no.value = vWhfDeclNo;
							
							vCsrNo = ComGetEtcData(arrXml[0],"csr_no") ;
							
							//Csr No
							formObj.csr_no.value = vCsrNo;
							
							//I/B T/S Amount
							formObj.ibts_amt.value = CommaInputWithPoint( ComGetEtcData(arrXml[0],"ibts_amt"), "1" );
							//절사
							formObj.rduc_amt.value = CommaInputWithPoint( ComGetEtcData(arrXml[0],"rduc_amt"), "1" );
							//Commission
							formObj.comm_amt.value = CommaInputWithPoint( ComGetEtcData(arrXml[0],"comm_amt"), "1" );
							//항만
							formObj.port_nm.value = ComGetEtcData(arrXml[0],"port_nm");
							//허가번호1
							formObj.whf_ntc_no_yr.value = ComGetEtcData(arrXml[0],"whf_ntc_no_yr");
							//허가번호2
							formObj.whf_ntc_no_mon.value = ComGetEtcData(arrXml[0],"whf_ntc_no_mon");
							//허가번호3
							formObj.whf_ntc_no_seq.value = ComGetEtcData(arrXml[0],"whf_ntc_no_seq");
							
							var vEdiMsgSndId = ComGetEtcData(arrXml[0],"edi_msg_snd_id");
							formObj.edi_msg_snd_id.value = ComGetEtcData(arrXml[0],"edi_msg_snd_id");
							formObj.cntr_20_ut_rt.value = ComGetEtcData(arrXml[0],"cntr_20_ut_rt");
							formObj.cntr_40_ut_rt.value = ComGetEtcData(arrXml[0],"cntr_40_ut_rt");
							formObj.cntr_45_ut_rt.value = ComGetEtcData(arrXml[0],"cntr_45_ut_rt");
							formObj.blk_ut_rt.value  = ComGetEtcData(arrXml[0],"blk_ut_rt");
							formObj.blk_rt_rto.value = ComGetEtcData(arrXml[0],"blk_rt_rto");
							
							formObj.upd_usr_id.value = sheetObjects[0].CellValue(1, 8);
							formObj.upd_dt.value = sheetObjects[0].CellValue(1, 9);

						}
						/*
						 * 조회성공시
						 */
						ComBtnDisable( "btn_save" );
						ComBtnDisable( "btn_send" );
						ComBtnDisable( "btn_decIF" );
						ComBtnDisable( "btn_changeNoIF" );
						
						if( 'IN' == formObj.whf_bnd_cd.value ){
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_send" );
						} else if( 'II' == formObj.whf_bnd_cd.value ){
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_decIF" );
						} else if( 'OO' == formObj.whf_bnd_cd.value ){
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_send" );
							ComBtnEnable( "btn_decIF" );
						} else {
							ComBtnDisable( "btn_decIF" );
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_send" );
						}

						if ( vWhfDeclNo.length == 19 ){
							ComBtnDisable( "btn_decIF" );                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
							ComBtnEnable( "btn_changeNoIF" );
							ComBtnEnable( "btn_decCancelIF" );
							
							//DEC Cancel시 신고 금액 변경 불가
							formObj.ntc_amt.disabled = true;
						} else {
							ComBtnDisable( "btn_decCancelIF" );
							
							//DEC Cancel시 신고 금액 변경 불가에 대한 복구
							formObj.ntc_amt.disabled = false;
						}
												
						if ( vEdiMsgSndId == '2' ){
							formObj.send.options[0].selected = true ;
						} else if ( vEdiMsgSndId == '3' ){
							formObj.send.options[1].selected = true ;
						} else if ( vEdiMsgSndId == '4' ){
							formObj.send.options[2].selected = true ;
						} else {
							formObj.send.options[3].selected = true ;
						}
						
						if( parseInt( vNtcAmt ) < 1 )
							if ( formObj.port_cd.value == 'KRPTK'){
								changeHaYoek();
								if( formObj.whf_cust_knd_cd[0].checked )
						    		changeCommition( "C" );
						    	else
						    		changeCommition( "U" );
							} else {
								formObj.ntc_amt.value = formObj.whf_rt_amt.value;		
							}
					}
					
        		}
        		ComOpenWait(false);
        		break;
        		
        	case COMMAND04:
        		ComOpenWait(true);
        		if( validateForm(sheetObj,formObj,sAction) ){
        			
					formObj.f_cmd.value = COMMAND04;
					
	    	        var sXml = sheetObj.GetSearchXml("ESM_BKG_0557GS.do", FormQueryString(formObj));
				}
        		
        		var dtCheck  = ComGetEtcData(sXml, "dtCheck");
        		var etaDt = ComGetEtcData(sXml, "etaDt");
        		var frInDt = ComGetEtcData(sXml, "frInDt");
        		var emptyCheck = ComGetEtcData(sXml, "emptyCheck");
        		
        		
//        		if (dtCheck == 'N' && emptyCheck == 'Y')
//        		{
//        			if(!ComShowCodeConfirm('BKG06116', frInDt, etaDt)) return false;
//        			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
//        		}
//        		else
//        		{
        			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);        			
//        		}

        		ComOpenWait(false);
				break;
						
			case COMMAND01 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value = COMMAND01;
					
				    var sParam = ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0557GS.do", sParam);
	    	        if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
					}else{
						ComShowCodeMessage('BKG00205');
					}
	    	        ComOpenWait(false);
				}    
				break;
			case COMMAND02 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value = COMMAND02;					

					sheetObjects.WaitImageVisible = false;
					
					var sParam = ComGetSaveString(sheetObjects);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					alert(sParam);
					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0557GS.do", sParam);
					if( ComBkgErrMessage(sheetObj, SaveXml) ){
						var hisSeq = ComGetEtcData(SaveXml, "HISSEQ");
						formObj.his_seq.value = hisSeq;
						var key = ComGetEtcData(SaveXml, "KEY");						
						intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
//						ComShowCodeMessage('BKG00204');
					}else{			
						ComShowCodeMessage('BKG00205');
						doActionIBSheet(sheetObj,formObj,SEARCH01);
						ComOpenWait(false);
					}
					
				}
				break;
			case COMMAND03 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value = COMMAND03;
					var sParam = ComGetSaveString(sheetObjects);
//					alert(formObj.whf_ntc_no_yr.value);
//					alert(formObj.whf_ntc_no_mon.value);
//					alert(formObj.whf_ntc_no_seq.value);
					sParam += "&" + "whf_ntc_no=" + 
						formObj.whf_ntc_no_yr.value + 
						formObj.whf_ntc_no_mon.value + 
						formObj.whf_ntc_no_seq.value;
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					alert(sParam);
					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0557GS.do", sParam);
					sheetObj.LoadSaveXml(SaveXml);
					ComOpenWait(false);
				}    
				break;	
			
			case MULTI:        //저장
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
				    for(var i=1; i<=sheetObjects[0].RowCount; i++){
				    	if( 'R' == sheetObjects[0].CellValue(i,'sheet1_ibflag') ){
				    		sheetObjects[0].CellValue2(i,'sheet1_ibflag') = 'I';
				    	}
				    }
				            
				    var sParam = ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0557GS.do", sParam);
	    	        sheetObj.LoadSaveXml(SaveXml);
	    	        ComOpenWait(false);
				}    
    	    break;
			case IBDELETE:      // 삭제
				var checked = 0;
				for (var i = 1 ; i <= sheetObj.RowCount +1 ; i++){
					if( sheetObj.CellValue(i,1) == '1' ){
						checked = 1;
						if (sheetObj.CellValue(i,0) != "I"){
							if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.RowHidden( i ) = true;
								sheetObj.RowStatus( i ) = "D";
							}
						}else{
							if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.RowStatus( i ) = "D";
								i--;
							}
						}
					}	
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			
			break;
			case COMMAND05:
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND05;					
				
				var sParam = ComGetSaveString(sheetObjects);
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//				alert(sParam);
				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0557GS.do", sParam);
				ComOpenWait(false);
			break;
			
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
     	
    	var vvd       = formObj.vvd.value;
    	var vpsPortCd = formObj.port_cd.value;
    	var ioBndCd   = formObj.whf_bnd_cd.value;
    	var ntcNoYr   = formObj.whf_ntc_no_yr.value;
    	var ntcNoMon  = formObj.whf_ntc_no_mon.value;
    	var ntcNoSeq  = formObj.whf_ntc_no_seq.value;
    	var whfUsrNm = formObj.whf_usr_nm.value;
    	var rducAmt   = parseFloatWithoutComma( formObj.rduc_amt.value );
    	var commAmt   = parseFloatWithoutComma( formObj.comm_amt.value );
    	var rtAmt     = parseFloatWithoutComma( formObj.whf_rt_amt.value );
    	var whfNtcDt  = formObj.whf_ntc_dt.value;
    	var ntcAmt    = parseFloatWithoutComma( formObj.ntc_amt.value );
    	
    	switch (sAction) {
     		case SEARCH01:
     			if( ComChkLen(vvd, 9) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'vvd');
     				formObj.vvd.focus();
     				return false;
     			}
     			
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				formObj.port_cd.focus();
     				return false;
     			} 
     			return true;
     			break;
     	
     		case SEARCH:
     			if ( ComChkLen(vvd, 9) != "2") {
     				ComShowCodeMessage('BKG00887', 'VVD');
     				return false;
     			}
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				return false;
     			}
     			return true;
     			break;
     		
	 		case MULTI:
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if(formObj.port_cd.value != "KRKAN"){
		 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
			 			if(rtAmt < ntcAmt){
					    	ComShowCodeMessage('BKG06121');
					    	return false;
					    }	 			
					    if(rtAmt != (ntcAmt + rducAmt)){
					    	ComShowCodeMessage('BKG06120');
					    	return false;
					    }
					    
					    if ( (ntcAmt%10 )> 0){
					    	ComShowCodeMessage('BKG06122');
					    	return false;
					    }
		 			}
	 			}
	 			return true;
	 			break;
	 			
	 		case COMMAND04:
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if( '0' == formObj.send.value ){
	 				ComShowCodeMessage('BKG06048')
	 					return false;
	 			}		
	 			return true;
	 			break;
	 			
	 		case COMMAND01:
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if( '0' == formObj.send.value ){
	 				ComShowCodeMessage('BKG06048')
	 					return false;
	 			}		
	 			if(formObj.port_cd.value != "KRKAN"){
		 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
			 			if(rtAmt < ntcAmt){
					    	ComShowCodeMessage('BKG06121');
					    	return false;
					    }
					    if(rtAmt != (ntcAmt + rducAmt)){
					    	ComShowCodeMessage('BKG06120');
					    	return false;
					    }
					    if ( (ntcAmt%10 )> 0){
					    	ComShowCodeMessage('BKG06122');
					    	return false;
					    }
		 			}
	 			}
	 			return true;
	 			break;
	 		
	 		case COMMAND02:
	 			if ( ioBndCd == 'OT' || ioBndCd == 'IT' || ioBndCd == 'IN' ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 		// [VVD 값의 길이 <> 9]
	 			if ( ComChkLen(vvd, 9) != "2" ) { // vvd
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			//[Port값의 길이 <> 5]
	 			if ( ComChkLen(vpsPortCd, 5) != "2" ) { //port
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			//[허가번호값의 길이 <> 12
	 			if ( ComChkLen(ntcNoYr, 4) != "2"  ) { //허가번호
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_yr.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(ntcNoMon, 2) != "2") { //허가번호
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_mon.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(ntcNoSeq, 6) != "2" ) { //허가번호
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_seq.focus();
	 				return false;
	 			}
	 			//허가일자 유효성 검사
//	 			alert("whfNtcDt=[" + whfNtcDt + "]");
	 			if( ! ComIsDate( whfNtcDt,'ymd') ){
	 				ComShowCodeMessage('BKG06052');
	 				formObj.whf_ntc_dt.focus();
	 				return false;
	 			}	
	 			//[담당자 값의 길이 < 3]
	 			if ( whfUsrNm.length < 1 ) { // 담당자
	 				ComShowCodeMessage('BKG00715', '담당자');
	 				formObj.whf_usr_nm.focus();
	 				return false;
	 			}
	 			// [신고 금액 = 0]
	 			if ( ntcAmt == 0 ) {
	 				ComShowCodeMessage('BKG06054');
	 				formObj.whf_usr_nm.focus();
	 				return false;
	 			}
	 			// 2018.02.12 iylee 광양제외
	 			if(formObj.port_cd.value == 'KRPTK'){
	 			// [(Total Amount - 신고 금액)의 절대값 > 100]
		 			if ( Math.abs( rtAmt - ntcAmt )>100 ){
		 				ComShowCodeMessage('BKG06055','100');
		 				formObj.ntc_amt.focus();
		 				return false;
		 			}
		 			//[(신고 금액을 10으로 나눈 나머지)의 절대값 > 100]
		 			if ( Math.abs( (ntcAmt%10) ) > 100 ){
		 				ComShowCodeMessage('BKG06057');
		 				formObj.ntc_amt.focus();
		 				return false;
		 			}
		 			//[절사 > 100]
		 			if ( rducAmt > 100 ){
		 				ComShowCodeMessage('BKG06056','100');
		 				formObj.ntc_amt.focus();
		 				return false;
		 			}
	 			}else{
	 				// 2018.02.12 iylee 광양제외
	 				if(formObj.port_cd.value != 'KRKAN'){
			 			// [(Total Amount - 신고 금액)의 절대값 > 50]
			 			if ( Math.abs( rtAmt - ntcAmt )>50 ){
			 				ComShowCodeMessage('BKG06055','50');
			 				formObj.ntc_amt.focus();
			 				return false;
			 			}
			 			//[(신고 금액을 10으로 나눈 나머지)의 절대값 > 50]
			 			if ( Math.abs( (ntcAmt%10) ) > 50 ){
			 				ComShowCodeMessage('BKG06057');
			 				formObj.ntc_amt.focus();
			 				return false;
			 			}
			 			//[절사 > 50]
			 			if ( rducAmt > 50 ){
			 				ComShowCodeMessage('BKG06056','50');
			 				formObj.ntc_amt.focus();
			 				return false;
			 			}
	 				}
	 			}
		    	if(formObj.port_cd.value != "KRKAN"){
		 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
			 			if(rtAmt < ntcAmt){
					    	ComShowCodeMessage('BKG06121');
					    	return false;
					    }
					    if(rtAmt != (ntcAmt + rducAmt)){
					    	ComShowCodeMessage('BKG06120');
					    	return false;
					    }
					    if ( (ntcAmt%10 )> 0){
					    	ComShowCodeMessage('BKG06122');
					    	return false;
					    }
		 			}
		    	}
	 			if(formObj.cancel_flag.value != 'Y')
	 			{
	 				if(formObj.whf_ntc_dt.value > formObj.whf_pay_dt.value)
	 					{
	 					ComShowMessage('납기일자는 허가일자보다 같거나 커야합니다.');
				    	return false;
	 					}
	 			}
	 			return true;
	 			break;
	 		case COMMAND03:
	 			//[ Bound = "OT" OR Bound = "IT" OR Bound = "IN"] {
	 			if( ioBndCd == 'OT' || ioBndCd == 'IT' || ioBndCd == 'IN' ){
	 				ComShowCodeMessage('BKG06050');
	 				formObj.whf_bnd_cd.focus();
	 			}	
	 			// [허가 번호의 길이 != 12]
	 			if ( ComChkLen(ntcNoYr, 4) != "2"  ) { //허가번호
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_yr.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(ntcNoMon, 2) != "2") { //허가번호
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_mon.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(ntcNoSeq, 6) != "2" ) { //허가번호
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_seq.focus();
	 				return false;
	 			}
	 			// [VVD값의 길이 != 9]
	 			if ( ComChkLen(vvd, 9) != "2" ) { // vvd
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			//[Port값의 길이 != 5]
	 			if ( ComChkLen(vpsPortCd, 5) != "2" ) { //port
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			//2018.02.12 iylee 광양제외
	 			if(formObj.port_cd.value != "KRKAN"){
		 			// [(Total Amount - 신고 금액)의 절대값 > 50]
		 			if ( Math.abs( rtAmt - ntcAmt )>50 ){
		 				ComShowCodeMessage('BKG06055');
		 				formObj.ntc_amt.focus();
		 				return false;
		 			}
	 			}
	 			// [Dec No 길이 != 19]
	 			if ( ComChkLen(formObj.whf_decl_no.value, 19) != "2" ) { // Dec No
	 				ComShowCodeMessage('BKG06058');
	 				return false;
	 			}
		    	if(formObj.port_cd.value != "KRKAN"){
		 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
			 			if(rtAmt < ntcAmt){
					    	ComShowCodeMessage('BKG06121');
					    	return false;
					    }
					    if(rtAmt != (ntcAmt + rducAmt)){
					    	ComShowCodeMessage('BKG06120');
					    	return false;
					    }
					    if ( (ntcAmt%10 )> 0){
					    	ComShowCodeMessage('BKG06122');
					    	return false;
					    }
		 			}
		    	}
				    
	 			return true;
	 			break;
	 		
     	}
     }
    	
    /**
     * 콤마가 있는 숫자형에서 콤마를 제거하고 실수형으로 반환한다.
     * @param targetNum
     * @return
     */
    function parseFloatWithoutComma( targetNum ){
    	return parseFloat( targetNum.split(",").join("") );
    }
    
    /**
     * 데이터를 가공하는 메서드.
     * 
     * @return
     */
     
    /**
     * 첫번째 시트 값이 변동이 있을때 처리하는 메서드.
     * 
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	
    	if( Col == 2 || Col == 3){
    		changeHaYoek();
    	} 
    	if( Col == 4  )
    		sheetObj.CellValue2(Row, "sheet1_rate") = sheetObj.CellValue(Row, "sheet1_kr_whf_dc_cd");
    }
    /**
     * 하역구분 값이 변경됨에 따라 신고금액이 변경되는 메서드.
     * 
     * @return
     */
    function changeHaYoek(){
    	var vTemp = createNtcAmt();
    	if( vTemp != 0 )
    		document.form.ntc_amt.value = CommaInputWithPoint ( String(vTemp), 3 );
    }
    
    /**
     * 1. 그리드_1에 전체 Row 수를 구함
	   2. 전체 Row 수 만큼 반복 수행 {
	 	   1. [할인 사유 없음 && 운임톤 개수 있음] {
		        // 하역 구분에 따라 계산
		        [하역 구분 == "2"] { // Bulk
		            누적 신고 금액 = 누적 신고 금액 + (운임톤 개수 * blk_ut_rt * blk_rt_rto)
		        }
		        ELSE [하역 구분 == "8"] { // Container 40
		            누적 신고 금액 = 누적 신고 금액 + (운임톤 개수 * cntr_40_ut_rt)
		        }
		        ELSE [하역 구분 == "9"] { // Container 45
		            누적 신고 금액 = 누적 신고 금액 + (운임톤 개수 * cntr_45_ut_rt)
		        }
		        ELSE { // Bulk
		            누적 신고 금액 = 누적 신고 금액 + (운임톤 개수 * cntr_20_ut_rt)
		        }
		   }
		}
		3. 최종 누적 신고 금액을 폼_1.신고 금액에 넣음
		    폼_1.신고 금액 = 최종 누적 신고 금액
     * @return
     */ 
    function createNtcAmt(){
    	var prefix1 = 'sheet1_';
    	var formObj = document.form ;
    	var vBlkUtRt    = parseInt( formObj.blk_ut_rt.value ); //blk_ut_rt
    	var vBlkRtRto   = parseInt( formObj.blk_rt_rto.value ); //blk_rt_rto
    	
        var vKrWhfDcRsnCd = "";
        var vRate = "";
        var vOfcCd = formObj.ofc_cd.value;
        var sumFlag = false;
        var portCd = formObj.port_cd.value;
        
    	if(portCd == "KRPTK"){
    		var vCntr40UtRt = formObj.cntr_40_ut_rt.value ; //cntr_40_ut_rt
        	var vCntr45UtRt = formObj.cntr_45_ut_rt.value ; //cntr_45_ut_rt
        	var vCntr20UtRt = formObj.cntr_20_ut_rt.value ; //cntr_20_ut_rt
    	} else {
    		var vCntr40UtRt = parseInt( formObj.cntr_40_ut_rt.value ); //cntr_40_ut_rt
        	var vCntr45UtRt = parseInt( formObj.cntr_45_ut_rt.value ); //cntr_45_ut_rt
        	var vCntr20UtRt = parseInt( formObj.cntr_20_ut_rt.value ); //cntr_20_ut_rt 		
    	}
    	
    	vAccmuDeclaAmt = 0;
    	
    	for( var i=1; i<sheetObjects[0].RowCount+1; i++){
    		var vUnldTpCd  = sheetObjects[0].CellValue(i, prefix1+"unld_tp_cd"); // 하역구분
    		var vTtlTonQty = parseInt( sheetObjects[0].CellValue(i, prefix1+"ttl_ton_qty") ); //운임톤개수
    		
    		vKrWhfDcRsnCd = sheetObjects[0].CellValue(i, prefix1+"kr_whf_dc_rsn_cd").replace(" ","");

            /*
             * 2011.05.03 경종윤
             * 신고 금액 sum 기준에
             * 로그인 office 가 "SELBB", "PUSBS" 이면 할인사유가 null 또는 5.투자비보전 이고
             * 운임톤/갯수 가 0 보다 크면 sum 을 한다.
             * 
             * 로그인 office 가 "SELBB", "PUSBS" 가 아니면 할인사유가 null 이면서 운임톤/갯수 가 0 보다 크면 sum을 한다.
             */

    		/*
             * 2014.03.26 이신원
             * 한국지점 office변경에 따른 수정 (PUSBS, PUSBO -> PUSBB)로
             * 2015.08.07 
             * 조직코드변경 (SELBB->SELSC, PUSBB->PUSSC)
             */
//    		if(vOfcCd == "SELBB" || vOfcCd == "PUSBS") {
   			if(vOfcCd == "SELSC" || vOfcCd == "PUSSC" || vOfcCd == "PUSBS") {
    			if ( (vKrWhfDcRsnCd == "" || vKrWhfDcRsnCd == "5") && parseInt(sheetObjects[0].CellValue(i, prefix1+"ttl_ton_qty")) > 0 ){
    				sumFlag = true;
    			} else {
    				sumFlag = false;
    			}
    		} else {
    			if ( vKrWhfDcRsnCd == "" && parseInt(sheetObjects[0].CellValue(i, prefix1+"ttl_ton_qty")) > 0 ){
                    sumFlag = true;
    			} else {
                    sumFlag = false;
    			}
    		}

    		if(sumFlag){
    			if( "2" == vUnldTpCd ){
    				vAccmuDeclaAmt = vAccmuDeclaAmt + ( (vTtlTonQty * vBlkUtRt)*vBlkRtRto );
    			}else if( "8" == vUnldTpCd ){
    				if(portCd == "KRPTK"){
    					vAccmuDeclaAmt = vAccmuDeclaAmt + Math.floor( (vTtlTonQty * vCntr40UtRt) /10)*10;
    				}else{
    					vAccmuDeclaAmt = vAccmuDeclaAmt + ( (vTtlTonQty * vCntr40UtRt) );
    				}
    			}else if( "9" == vUnldTpCd ){
    				if(portCd == "KRPTK"){
    					vAccmuDeclaAmt = vAccmuDeclaAmt + Math.floor( (vTtlTonQty * vCntr45UtRt)/10 )*10;
    				}else{
    					vAccmuDeclaAmt = vAccmuDeclaAmt + ( (vTtlTonQty * vCntr45UtRt) );
    				}
    			}else{
    				if(portCd == "KRPTK"){
    					vAccmuDeclaAmt = vAccmuDeclaAmt + Math.floor( (vTtlTonQty * vCntr20UtRt)/10 )*10;
    				}else{
    					vAccmuDeclaAmt = vAccmuDeclaAmt + ( (vTtlTonQty * vCntr20UtRt) );
    				}
    			}
    		}
    	}
    	return vAccmuDeclaAmt;
    }
    
    /**
     * 절사 금액 및 Commission 계산 메서드.
     * 
     * 1. 절사 금액 및 Commission 계산 {
		   1. [화주 == 복수(C)] {
		      Commission = TRUNCATE(신고 금액 * 0.03 / 10, 0) * 10
		   }
		   ELSE { // 단수 화주 인 경우
		      Commission = 0
		   }
		   2. 절사 금액 = Total Amount - Commission
		}
     * 
     * 
     * @return
     */
    function changeCommition(val){
    	
    	var formObj   = document.form ;
    	//var vNtcAmt   =((formObj.ntc_amt.value).replace(".","")).split(",").join("");
    	var vNtcAmt   = formObj.ntc_amt.value;
    	var vCommAmt  = 0;
    	//var vTotalAmt = ((formObj.whf_rt_amt.value).replace(".","")).split(",").join("");
    	var vTotalAmt = formObj.whf_rt_amt.value;
    	if( "C" == val )
    		vCommAmt =  parseInt( (parseFloatWithoutComma(vNtcAmt) * 0.03)/10 ) * 10 ;
    	else
    		vCommAmt = 0;

    	formObj.comm_amt.value = CommaInputWithPoint( String( vCommAmt ), 3);
    	formObj.rduc_amt.value = CommaInputWithPoint( String( parseFloatWithoutComma( vTotalAmt ) - parseFloatWithoutComma(vNtcAmt) ), 3 ) ;
    	
    }
    
    /**
     * Total Amount 값 변동시 처리하는 메서드.
     */
    function changeTotalAmtAndNtcAmt(){
    	
    	PointNumberFixed( window.event.srcElement.getAttribute("name"), window.event.srcElement.getAttribute("value") );
    	if( window.event.srcElement.getAttribute("value") != '' ){
	    	if( document.form.whf_cust_knd_cd[0].checked )
	    		changeCommition( "C" );
	    	else
	    		changeCommition( "U" );
    	}
    	
    	// Port가 KRKAN  인 경우 Total Amount 값이 3,000 미만 인 경우 신고 금액에 자동으로 3,000 입력
    	if(window.event.srcElement.getAttribute("name") == "whf_rt_amt"){
	    	if(document.form.port_cd.value == "KRKAN"){
	    		if(window.event.srcElement.getAttribute("value").replace(",","") < 3000){
	    			document.form.ntc_amt.value = "3000";
	    		}else{
	    			document.form.ntc_amt.value = "0";
	    		}
	    	}
    	}
    }
	
    /**
     * 허가번호의 변경에 따른 처리를 하는 메서드.
     * 
     * 1. [Bound <> "OT"] {
		   1. [연도(앞4자리)의 길이 == 4 &&
		         달(중간2자리)의 길이 == 2 &&
		         일련번호(뒤6자리)의 길이 >= 1] {
		      [Dec I/F] 버튼 Enable
		       입력된 일련번호의 앞에 0을 넣어 6자리로 채워 표시
		   }
		   ELSE {
		      [Dec I/F] 버튼 Disable
		   }
		}
     * 
     * 
     */
    function changePermitNum(){
    	
    	var formObj   = document.form ;
    	if( "OT" != formObj.whf_bnd_cd.value ){
	    	var vYear      = formObj.whf_ntc_no_yr.value;
	    	var vMonth     = formObj.whf_ntc_no_mon.value;
	    	var vSerialNum = formObj.whf_ntc_no_seq.value;
	    	var vTemp = 0;
	    	if(  vYear.length == 4 && vMonth.length == 2 && vSerialNum.length >= 1){
	    		vTemp = 6-parseInt(vSerialNum.length);
		    	for( var i=0; i<vTemp; i++){
		    		vSerialNum = "0" + vSerialNum ; 
		    	}
	    	}	
	    	formObj.whf_ntc_no_seq.value = vSerialNum;
    	}	
    }
    
    /**
     * 소숫점 체크
     */
    function PointNumberFixed( name, value ){
   	 	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
        document.getElementById(srcName ).value = CommaInputWithPoint ( srcValue, 3 ) ;
    }
     
     
     /**
      * 조회조건 바꿀때 시트 초기화
      * @return
      */
     function obj_Change() {
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	if (srcName == "whf_bnd_cd") {
     		sheetObjects[0].RemoveAll();
     		sheetObjects[1].RemoveAll();
     		//ComResetAll();
     		formObject.whf_ntc_dt.value = "";
     		formObject.whf_pay_dt.value = "";
     		formObject.whf_usr_nm.value = "";
     		formObject.whf_rt_amt.value = "";
     		formObject.ntc_amt.value = "";
     		formObject.whf_decl_no.value = "";
     		formObject.ibts_amt.value = "";
     		formObject.rduc_amt.value = "";
     		formObject.comm_amt.value = "";
     		formObject.port_nm.value = "";
     		formObject.whf_ntc_no_yr.value = "";
     		formObject.whf_ntc_no_mon.value = "";
     		formObject.whf_ntc_no_seq.value = "";
     		formObject.upd_usr_id.value = "";
     		formObject.upd_dt.value = "";
     	}
     }
      
      /**
       * form 초기화
       * @return
       */
      function obj_Init() {
       	var formObject = document.form;
   		sheetObjects[0].RemoveAll();
   		sheetObjects[1].RemoveAll();
   		//ComResetAll();
   		formObject.whf_ntc_dt.value = "";
   		formObject.whf_pay_dt.value = "";
   		formObject.whf_usr_nm.value = "";
   		formObject.whf_rt_amt.value = "";
   		formObject.ntc_amt.value = "";
   		formObject.whf_decl_no.value = "";
   		formObject.ibts_amt.value = "";
   		formObject.rduc_amt.value = "";
   		formObject.comm_amt.value = "";
   		formObject.port_nm.value = "";
   		formObject.whf_ntc_no_yr.value = "";
   		formObject.whf_ntc_no_mon.value = "";
   		formObject.whf_ntc_no_seq.value = "";
   		formObject.upd_usr_id.value = "";
   		formObject.upd_dt.value = "";
       	
       }
       

       /**
        * BackEndJob 실행결과조회<br>
        * 
        * @param sheetObj
        * @param sKey
        */
      function doActionValidationResult(sheetObj, sKey) {
       	//ComShowMessage("1");
       	var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
       	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
       	var formObject = document.form;

       	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
       	
       	// 에러가 발생했을 경우 대기사항을 종료한다.
       	if (!ComBkgErrMessage(sheetObj, sXml)) {
       		clearInterval(intervalId);
       		ComOpenWait(false);
       		return;
       	}
       	if (sJbStsFlg == "SUCCESS") {
       		clearInterval(intervalId);
       		ComOpenWait(false);
       		// 성공메시지 보여주고
       		ComShowCodeMessage("BKG00204");       		

       		doActionIBSheet(sheetObj,formObject,COMMAND05);
       		doActionIBSheet(sheetObj,formObject,SEARCH01);
       		
       		return;
       	} else if (sJbStsFlg == "FAIL") {
       		//에러
       		clearInterval(intervalId);
       		ComOpenWait(false);

       		formObject.return_values.value = ComResultMessage(sXml);
       		doActionIBSheet(sheetObj,formObject,COMMAND05);
       		// 에러메시지 보여주고
       		ComShowMessage(ComResultMessage(sXml));

       		doActionIBSheet(sheetObj,formObject,SEARCH01);
       	}
      }

    /* 개발자 작업  끝 */    