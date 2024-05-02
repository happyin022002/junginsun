/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0035.js
*@FileTitle : Prepayments Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.22 윤세영
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 
* 2014.07.25 민정호 CHM-20430993 [Develop-FMS-JOO]비용 전표 상신용 Approval 구축
* 10만불 이상 금액에 대해서 CEO 결재 승인 기능 추가
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
     * @class ESM_FMS_0035 : ESM_FMS_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0035() {
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
	var prefix = "sheet1_";
	
	var rdObjects = new Array();
    var rdCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

       /*******************************************************/
       var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {

            	case "btn_retrieve":
	       	   	  	if(validateForm(sheetObject,formObject,srcName)){
		             	if(!CoFmsInitConfirm(sheetObject)) return;
		             	
		             	if (ComIsBtnEnable("btn_retrieve")) {
		             	
							ComOpenPopup("ESM_FMS_0074.do?" + FormQueryString(formObject), 900, 373,"searchVvdList", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0074");
						 
						}
					}	 
                break;

				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					
					ComResetAll();
					inputReadOnly("New");
                break;

				case "btn_save":
					if (ComIsBtnEnable("btn_save")) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
                	}
                	
                break;

				case "btn_slipInquiry":
					ComOpenPopup("ESM_FMS_0041_1.do?popup=yes", 1024, 590,"", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0041_1");
					//ComOpenPopup("ESM_FMS_0041.do?popup=yes", 1024, 590,"", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0041");
                break;
	
				case "btn_print":
					rdOpen(rdObjects[0], document.form);
                break;

				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0022");
					break;
					 
				case "btn_ctrtpop":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
						 return;
					 }
					 
					 ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI", 520, 405,"setContractNo", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0023");
					 break;
                
				case "eff_dt_cal":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.eff_dt, 'yyyy-MM-dd');
					break;	
					
    			case "apro_step_btn" :
    				if(form.csr_no.value != "") return; 
    				var v_ofc_cd = formObject.slp_ofc_cd.value;
    	    	    
    	    	    
    	    	    var v_sub_sys_cd = "FMS";
    	            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
    					ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
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

        //khlee-시작 환경 설정 함수 이름 변경
           ComConfigSheet (sheetObjects[i] );

           initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
           ComEndConfigSheet(sheetObjects[i]);
        }

        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();

        //RD
		initRdConfig(rdObjects[0]);
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'				, 'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        
      //2010.11.24 이상민 [CHM-201007233-01] : vsl_cd 는 eng_keypress-> engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'engnum_keypress', 'vsl_cd');
        
        axon_event.addListener  ('keypress', 'obj_keypress' , form);				//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Vessel Code 입력 후 Name 정보 가져오기
        axon_event.addListener  ('change'  , 'currencyOnChange', 'csr_curr_cd');			//- Currency Code 입력 후 Name 정보 가져오기

        //CSR Date에 오늘 일자 세팅
        setCsrDate();
        
		//Prepayment Retrieve Button Disable 하기
		ComBtnDisable("btn_retrieve");

		//Print Button Disable 하기
		ComBtnDisable("btn_print");
    }
    
	/**
	 * CSR Date에 오늘 일자 세팅
	 */
	function setCsrDate() {
        var now=new Date();

        var y=now.getYear()+"";
        var M=now.getMonth()+1;
        if (M < 10) M = '0'+M;
        var d=now.getDate();
        if (d < 10) d = '0'+d;

        document.form.slp_iss_dt.value = ComGetMaskedValue(y+M+d, "ymd");
	}
    
	/**
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		
		//선박 대 계약 자동 매치
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
	}
    
    /**
	 * Contract No 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		contract_no_change();
	}
    
    /**
	 * 미 정리된 선급금 전표를 항차별로 분리한다.<br>
	 * @param {arry} aryPopupData
	 */
	function searchVvdList(aryPopupData){
		form.slp_desc.value    = aryPopupData[0][3]
		form.org_slip_no.value = aryPopupData[0][4]
		form.acct_cd.value     = aryPopupData[0][6]
		form.slp_amt.value     = aryPopupData[0][8]
		form.org_slp_tp_cd.value   = aryPopupData[0][9]
		form.org_slp_func_cd.value = aryPopupData[0][10]
		form.org_slp_ofc_cd.value  = aryPopupData[0][11]
		form.org_slp_iss_dt.value  = aryPopupData[0][12]
		form.org_slp_ser_no.value  = aryPopupData[0][13]
		form.org_slp_seq_no.value  = aryPopupData[0][5]
		form.ctr_cd.value      = aryPopupData[0][14]
		form.slp_loc_cd.value  = aryPopupData[0][15]
		form.vvd_exp_dt.value  = aryPopupData[0][16]
		form.vvd_eff_dt.value  = aryPopupData[0][17]
		form.inv_seq.value  = aryPopupData[0][18]

    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	/**
     * Contract No 선택 시 해당 Name 을 가져온다. <br>
     **/
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'flet_ctrt_no');
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value = "";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }

    
    /**
     * Effective Date 변경 시 체크한다. <br>
     **/
    function eff_dt_change() {
    	if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');
    	}
    }
	
	/**
     * IBSheet 입력값 중 Currency Code값의 존재 여부를 판단하다. <br>
     * @return {없음}
     **/
    function currencyOnChange() {
			
    	if (form.csr_curr_cd.value.trim().length == 3) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'csr_curr_cd');
    	}
	}

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	    obj = event.srcElement;
	    if (obj.name == 'eff_dt') {
	    	eff_dt_change();
	    }
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:     //sheet1 init
                with (sheetObj) {

					// 높이 설정
					style.height = 342;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 2, 3, 100);

					var HeadTitle1 = "|Seq.|Acct Code|Vendor Code|Center Code|City|Eff. Date|Slip Amount||||||";
					var HeadTitle2 = "|Seq.|Description|Description|Description|VVD Code||Key Number|||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,      	90,		daCenter,	true,	prefix+"slp_seq_no",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	130,	daCenter,	false,	prefix+"acct_cd",				false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	130,	daCenter,	false,	prefix+"vndr_seq",				false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	130,	daCenter,	false,	prefix+"ctr_cd",				false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	130,	daCenter,	false,	prefix+"slp_loc_cd",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,	false,	prefix+"eff_dt",				false,	"",	dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   		200,	daRight,	false,	prefix+"csr_amt",				false,	"",	dfFloat,			2,	false,	true);

					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"org_slp_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"org_slp_func_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"org_slp_ofc_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"org_slp_iss_dt");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"org_slp_ser_no");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"org_slp_seq_no");

					cnt = 0;
					InitDataProperty(1, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix+"ibflag1");
					InitDataProperty(1, cnt++ , dtData,      	90,		daCenter,	true,	prefix+"slp_seq_no1",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(1, cnt++ , dtData,      	130,	daLeft,		false,	prefix+"csr_desc",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(1, cnt++ , dtData,     	130,	daLeft,		false,	prefix+"csr_desc1",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(1, cnt++ , dtData,      	130,	daLeft,		false,	prefix+"csr_desc2",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(1, cnt++ , dtData,   	   	130,	daCenter,	false,	prefix+"vvd_cd",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(1, cnt++ , dtData,   	   	150,	daCenter,	false,	prefix+"dummy1",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(1, cnt++ , dtData,   	   	200,	daCenter,	false,	prefix+"slp_key_no",			false,	"",	dfNone,			0,	false,	false);

					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"ppay_hir_no");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"inv_seq");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"vvd_eff_dt");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"vvd_exp_dt");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"trns_amt",				false,	"",	dfFloat,		2);
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  prefix+"lsg_gr_no");

    				DataRowMerge(1) = true;
	
	                SetSortDialog(false);

             	}
             break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value = SEARCH01;
	        		sheetObj.DoSearch("ESM_FMS_0074GS.do", FormQueryString(formObj));
	        	   
	  	   	  		inputReadOnly("Search");
	  	   	  	}	

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
	 				 			
	 			formObj.f_cmd.value = MULTI;	 			
	 			sheetObj.DoSave("ESM_FMS_0035GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					CoFmsGetCombo("GRID", formObj, sheetObj, "CD01751","flet_ppay_rlt_cd", "flet_ppay_rlt_cdText");


	    		} else if (Col == "vsl_cd") {
					
					formObj.f_cmd.value = SEARCH01;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));

		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				initDefaultContractNo(); //선박 대 계약 자동 매치
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
	    		} else if (Col == "flet_ctrt_no") {
					
					formObj.f_cmd.value = SEARCH;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0035GS.do" , FormQueryString(formObj));
		   			var fletCtrtTpCd = ComGetEtcData(sXml, "fletCtrtTpCd");
		   			
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "" ) {
		   				formObj.flet_ctrt_tp_cd.value = fletCtrtTpCd;
		   				formObj.vndr_seq.value = ComGetEtcData(sXml, "vndrSeq");
		   				formObj.vndr_nm.value = ComGetEtcData(sXml, "vndrNm");
					}
	    		} else if (Col == "eff_dt") {
					formObj.f_cmd.value = SEARCH09;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(formObj),"-",""));
		
		   			var effDt = ComGetEtcData(sXml, "effDt");
		   			if(typeof effDt == "undefined" || effDt == "" ) {
						formObj.eff_dt.value = "";
						ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
						return;
					} else {
		   				formObj.csr_desc.value = "Hire Settlement "+formObj.vsl_cd.value + " " + formObj.eff_dt.value.substring(0,7);
		   				ComBtnEnable("btn_retrieve");
					}
	        	} else if(Col == "csr_curr_cd") {
	        		formObj.f_cmd.value = SEARCH01;
	        		
	        		var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj)+"&curr_cd="+formObj.csr_curr_cd.value);
	        		
		   			var currCd = ComGetEtcData(sXml, "currCd");
		   			
		   			if(typeof currCd == "undefined" || currCd == "") {
		   				formObj.csr_curr_cd.value = "";
						ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS01142"));
		   			}
				}
				break;
				
			case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치		
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll; 
				
				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				if(formObj.flet_ctrt_no.value != ""){
					contract_no_change();
				}
				break;	

        }
    }

   
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly = false;
	    	form.eff_dt.readOnly = false;
	    	
	    	document.images["btn_vslpop"].name = "btn_vslpop";
	    	form.btn_vslpop.style.cursor = "hand";
	    	document.images["btn_ctrtpop"].name = "btn_ctrtpop";
	    	form.btn_ctrtpop.style.cursor = "hand";
	    	document.images["eff_dt_cal"].name = "eff_dt_cal";
	    	form.eff_dt_cal.style.cursor = "hand";
	    	
	        //CSR Date에 오늘 일자 세팅
	        setCsrDate();

    	} else {
	    	if(sheetObjects[0].RowCount == 1 || flag == "Search") {
		    	form.vsl_cd.readOnly = true;
		    	form.eff_dt.readOnly = true;
		    	
		    	document.images["btn_vslpop"].name = "no_btn_vslpop";
		    	form.btn_vslpop.style.cursor = "default";
		    	document.images["btn_ctrtpop"].name = "no_btn_ctrtpop";
		    	form.btn_ctrtpop.style.cursor = "default";
		    	document.images["eff_dt_cal"].name = "no_eff_dt_cal";
		    	form.eff_dt_cal.style.cursor = "default";
	    	}
    	}

		ComBtnEnable("btn_save");

		//Print Button Disable 하기
		ComBtnDisable("btn_print");
    }

   /**
      * IBSheet를 조회 후 실행되는 이벤트
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){

		if (sheetObj.RowCount > 2) {//Account Code 111431의 경우 금액 수정 못함
			sheetObj.CellEditable(2, prefix+"csr_amt") = false;
		}
		
 		ComColFontName(sheetObj, prefix+"csr_amt", "Courier New"); 	
 		ComColFontName(sheetObj, prefix+"slp_loc_cd", "Courier New"); 	
		
		setTotalAmount(sheetObj);

	}

     /**
      * IBSheet를 조회 후 DR, CR의 Total Amount를 구함
      */
    function setTotalAmount(sheetObj){

    	var LastRow = sheetObj.LastRow;
    	var DrAmt = 0;
    	var CrAmt = parseFloat(sheetObj.cellValue(2, prefix+"csr_amt"))*-1;
    	
    	for (var i=4; i<=LastRow; i++) {

	    	DrAmt = DrAmt + parseFloat(sheetObj.CellValue(i, prefix+"csr_amt"));
	    	i++;
	    }
	    
		var formObj = document.form;
		formObj.dr_amt.value = ComAddComma(DrAmt.toFixed(2));
		formObj.cr_amt.value = ComAddComma(CrAmt.toFixed(2));
		

    }

     /**
      * IBSheet를 저장 후 실행되는 이벤트
      */
    function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		//CSR No. Setting
		var slpSerNo = sheetObj.EtcData("slp_ser_no");
		if(typeof slpSerNo != "undefined" && slpSerNo != "" ) {
			var formObj = document.form;
			formObj.csr_no.value = formObj.slp_tp_cd.value + formObj.slp_func_cd.value
								 + formObj.slp_ofc_cd.value + ComReplaceStr(formObj.slp_iss_dt.value,"-","").substring(2,8) + slpSerNo; 

			//Save Button Disable 하기
			ComBtnDisable("btn_save");
			//Print Button Disable 하기
			ComBtnEnable("btn_print");

		}	 			
		
	}

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value)
	{
		if (Col == 7) {//CSR Amount
			
			setTotalAmount(sheetObj);
		
		}
		
	}
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        if (sAction == IBSAVE) {
			var csr_desc = formObj.csr_desc.value;
			if (csr_desc.trim() == "") {
				ComAlertFocus(formObj.csr_desc, ComGetMsg("FMS01507"));
        		return false;
        	}

			var eff_dt = formObj.eff_dt.value;
			if (eff_dt.trim() == "") {
				ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01506"));
        		return false;
        	}

			var drAmt = parseFloat(ComReplaceStr(formObj.dr_amt.value,',',''));
			var crAmt = parseFloat(ComReplaceStr(formObj.cr_amt.value,',',''));
			if (drAmt != crAmt) {
				ComShowCodeMessage("FMS01508");
        		return false;
        	}
        	
        	//Prepayment Hire No
        	formObj.ppay_hir_no.value = sheetObj.CellValue(5, prefix+"org_slp_tp_cd");

        }

        return true;
    }

    /**
   	 * 페이지에 있는 RD Object를 로드한다. <br>
   	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
   	 * @param {rdObject} rdObject    RD Object
   	 **/
   	function initRdConfig(rdObject){
   	    var Rdviewer = rdObject ;
   	    Rdviewer.style.height = 0;
   	    Rdviewer.style.width = 0;
   	    
   	    Rdviewer.AutoAdjust = true;
   	    Rdviewer.ViewShowMode(0);

   		Rdviewer.setbackgroundcolor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);
   	}

 	function rdOpen(rdObject, formObject){
 		if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}
 		
 		var Rdviewer = rdObject ;
 		
		rdParam = RD_FormQueryString(formObject,1);
		var rdParam = '/rv '+ rdParam;
		var rdFile = 'ESM_FMS_031.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer + rdParam + " /rop /rprintnexit ");
 	}
 	
 	//선박 대 계약 자동 매치
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
    
	/* 개발자 작업  끝 */