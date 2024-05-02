/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0013.js
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.19 한동훈
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
     * @class fns_inv_0013 : fns_inv_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0013() {
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /** 
    * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param  없음  
    * @return 없음
    * @see #
    * @author 한동훈
    * @version 2009.10.19
    */ 
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
		         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;								
				
			case "btn_new":
				ComResetAll();
				document.getElementById('del_flg').style.display='none';
				ComSetFocus(form.frm_cust_cnt_cd);	
				break;
			
			case "btn_Pop":
				var param = '?cust_cnt_cd='+formObject.frm_cust_cnt_cd.value+'&cust_seq='+formObject.frm_cust_seq.value+'&pop_yn=Y';
				var Row = 1;
				var Col = 1;
				//ComOpenPopupWithTarget('/hanjin/FNS_INV_0013.do'+param, 920, 660, 'getPopData', '0,1', false, false, Row, Col, 0);
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 660, 'getPopData', '0,0', false, false, "", "", 0);
				break;
				
			case "btn_close":
				window.close();
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
    * IBSheet Object를 sheetObjects 배열로 등록 <br>
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param  {IBSheet} sheetObj IBSheet Object
    * @return 없음
    * @see #
    * @author 한동훈
    * @version 2009.10.19
    */ 
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

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
    * @author 한동훈
    * @version 2009.10.19
    */ 
    function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		axon_event.addListenerForm ('focusout', 'obj_focusout', document.form);
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		document.form.frm_cust_cnt_cd.focus();
		if(document.form.pop_yn.value == "Y"){
			if(document.form.frm_cust_cnt_cd.value != "" && document.form.frm_cust_seq.value != "")
			doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
		}
		initControl();
	}
    
    /** 
     * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
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
    * @author 한동훈
    * @version 2009.10.19
    */ 
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 222;
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

                    var HeadTitle1 = "|cust_cnt_cd|cust_seq|cust_lgl_eng_nm|cust_lgl_eng_nm2|cust_rgst_no|cust_rgst_no2|bzet_addr|zip_cd|phn_no|fax_no|ofc_cd|cnt_cd|ste_nm|cty_nm|cust_rmk|cr_curr_cd|cr_amt|cr_st_dt|cr_end_dt|cr_clt_ofc_cd|ib_cr_term_dys|ob_cr_term_dys|cust_rlse_ctrl_flg|cntc_pson_nm|xch_rt_div_cd|cng_indiv_cd|act_cust_cnt_cd|act_cust_seq|ob_eml|ib_eml|inv_due_dt_dp_flg|cr_cust_rmk|pay_div_cd|bank_acct_no|ownr_nm|tva_no|bzct_nm|bztp_nm|locl_nm|indiv_corp_div_cd|locl_addr1|locl_addr2|locl_addr3|locl_addr4|cr_cust_tp_cd|kr_ib_ofc_cd|locl_zip_cd|ob_phn_no|ob_fax_no|cust_scr_div_cd|cust_scr_locl_amt|scr_st_dt|scr_end_dt|iss_div_cd|cust_cr_due_dt_div_cd|pay_dt_dy1|pay_dt_dy2|PAY_DT_DY3|PAY_DT_DY4|PAY_DT_DY5|PAY_WK_DY_CD|DELT_FLG|SREP_CD|SREP_NM";                        
										var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    		var prefix="sheet1_";
                    		
                    		InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
                    		InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_cnt_cd"			 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_seq"               ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_lgl_eng_nm"        ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_lgl_eng_nm2"       ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_rgst_no"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_rgst_no2"          ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"bzet_addr"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"zip_cd"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"phn_no"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"fax_no"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ofc_cd"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cnt_cd"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ste_nm"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cty_nm"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_rmk"               ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_curr_cd"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_amt"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_st_dt"               ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_end_dt"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_clt_ofc_cd"          ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ib_cr_term_dys"         ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ob_cr_term_dys"         ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_rlse_ctrl_flg"     ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cntc_pson_nm"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"xch_rt_div_cd"          ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cng_indiv_cd"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"act_cust_cnt_cd"        ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"act_cust_seq"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ob_eml"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ib_eml"                 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_due_dt_dp_flg"      ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_cust_rmk"            ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_div_cd"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"bank_acct_no"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ownr_nm"                ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"tva_no" 				 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"bzct_nm"                ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"bztp_nm"                ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"locl_nm"                ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"indiv_corp_div_cd"      ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"locl_addr1"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"locl_addr2"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"locl_addr3"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"locl_addr4"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_cust_tp_cd"          ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"kr_ib_ofc_cd"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"locl_zip_cd"            ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ob_phn_no"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ob_fax_no"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_scr_div_cd"        ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_scr_locl_amt"      ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"scr_st_dt"              ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"scr_end_dt"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"iss_div_cd"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_cr_due_dt_div_cd"  ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_dt_dy1"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_dt_dy2"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_dt_dy3"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_dt_dy4"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_dt_dy5"             ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"pay_wk_dy_cd"           ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"delt_flg"             	 ,	false,	"",	dfNone,	0,	false,	false);					
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"srep_cd"             	 ,	false,	"",	dfNone,	0,	false,	false);
							InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"srep_nm"             	 ,	false,	"",	dfNone,	0,	false,	false);
							
				}
                break;
                
            case "sheet2":    //t1sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 50;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 80);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(6, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "|OFFICE|OUT BOUND|O/B E-MAIL|IN BOUND|I/B E-MAIL";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true, true);

					//데이터속성            [ROW, COL,    DATATYPE,     WIDTH, 	DATAALIGN, 	COLMERGE,  SAVENAME,  		KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,   cnt++ , dtHiddenStatus,	0,	daCenter,	false,	  "ibflag");
					InitDataProperty(0,   cnt++ , dtData,    	70,   	daCenter,  	false,    "ar_ofc_cd",   		false,      "",      	dfNone);
					InitDataProperty(0,   cnt++ , dtData,  		70,   	daCenter,   false,    "out_bound",   		false,      "",      	dfNone);
					InitDataProperty(0,   cnt++ , dtData,    	290,   	daLeft,  	false,    "out_eml",   			false,      "",      	dfNone);
					InitDataProperty(0,   cnt++ , dtData,    	70,   	daCenter,  	false,    "in_bound",			false,      "",      	dfNone);
					InitDataProperty(0,   cnt++ , dtData,  		200,   	daLeft,     false,    "in_eml",    			false,      "",      	dfNone);
					CountPosition = 0;
				}
			break;  
        }
    }

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
    * @author 한동훈
    * @version 2009.10.19
    */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      //조회				            		
        		if(validateForm(sheetObj,formObj,sAction) == false) return false;  
        		ComOpenWait(true);  //대기이미지 표시	

        		if (sheetObj.id == "sheet1") {						
					formObj.f_cmd.value = SEARCH;

					var sXml = sheetObj.GetSearchXml("FNS_INV_0013GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					sheetObjects[0].LoadSearchXml(arrXml[0], false);
					sheetObjects[1].LoadSearchXml(arrXml[1], false);
				}
				ComOpenWait(false); //대기이미지 숨김
				if(sheetObj.RowCount > 0){
					IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
					formObj.frm_cr_amt.value = ComAddComma2(formObj.frm_cr_amt, "#,###.00");
					formObj.frm_cust_scr_locl_amt.value = ComAddComma2(formObj.frm_cust_scr_locl_amt, "#,###");
					
					
					if(formObj.frm_cust_cr_due_dt_div_cd.value == "S"){
						formObj.frm_cust_cr_due_dt_div_cd1.checked = true;
						formObj.frm_cust_cr_due_dt_div_cd2.checked = false;
					}else if(formObj.frm_cust_cr_due_dt_div_cd.value == "I"){
						formObj.frm_cust_cr_due_dt_div_cd1.checked = false;
						formObj.frm_cust_cr_due_dt_div_cd2.checked = true;
					}	
					if(formObj.frm_delt_flg.value == "Y"){
						//formObj.del_flg.style.display="";
						document.getElementById('del_flg').style.display='';
					}else{
						document.getElementById('del_flg').style.display='none';
					}
										
					//frmRESULT.GAME_RESULT[i].checked=true;

					/*
					formObj.frm_grs_rgst_tong_wgt.value = ComAddComma2(formObj.frm_grs_rgst_tong_wgt, "#,###.00");
					formObj.frm_net_rgst_tong_wgt.value = ComAddComma2(formObj.frm_net_rgst_tong_wgt, "#,###.00");
					formObj.frm_dwt_wgt.value = ComAddComma2(formObj.frm_dwt_wgt, "#,###.00");
					formObj.frm_crw_knt.value = ComAddComma2(formObj.frm_crw_knt, "#,###");
					formObj.frm_loa_len.value = ComAddComma2(formObj.frm_loa_len, "#,###.00");
					*/
				} else {					
					formObj.frm_cust_lgl_eng_nm.value = "";
					formObj.frm_cust_rgst_no.value = "";					
					formObj.frm_bzet_addr.value = "";
					formObj.frm_zip_cd.value = "";
					formObj.frm_phn_no.value = "";
					formObj.frm_fax_no.value = "";
					formObj.frm_ofc_cd.value = "";
					formObj.frm_cnt_cd.value = "";
					formObj.frm_ste_nm.value = "";
					formObj.frm_cty_nm.value = "";
					formObj.frm_cust_rmk.value = "";
					formObj.frm_cr_curr_cd.value = "";
					formObj.frm_cr_amt.value = "";
					formObj.frm_cr_st_dt.value = "";
					formObj.frm_cr_end_dt.value = "";
					formObj.frm_cr_clt_ofc_cd.value = "";
					formObj.frm_ib_cr_term_dys.value = "";
					formObj.frm_ob_cr_term_dys.value = "";
					formObj.frm_cust_rlse_ctrl_flg.value = "";
					formObj.frm_cntc_pson_nm.value = "";					
					formObj.frm_xch_rt_div_cd.value = "";
					formObj.frm_cng_indiv_cd.value = "";
//					formObj.frm_ob_eml.value = "";
//					formObj.frm_ib_eml.value = "";					
					formObj.frm_inv_due_dt_dp_flg.value = "";
					formObj.frm_cr_cust_rmk.value = "";
					formObj.frm_pay_div_cd.value = "";
					formObj.frm_bank_acct_no.value = "";
					formObj.frm_ownr_nm.value = "";
					formObj.frm_tva_no.value = "";
					formObj.frm_bzct_nm.value = "";
					formObj.frm_bztp_nm.value = "";
					formObj.frm_locl_nm.value = "";
					formObj.frm_indiv_corp_div_cd.value = "";
					formObj.frm_locl_addr1.value = "";
					formObj.frm_locl_addr2.value = "";
					formObj.frm_locl_addr3.value = "";
					formObj.frm_locl_addr4.value = "";
					formObj.frm_cr_cust_tp_cd.value = "";
					formObj.frm_kr_ib_ofc_cd.value = "";
					formObj.frm_locl_zip_cd.value = "";
					formObj.frm_ob_phn_no.value = "";
					formObj.frm_ob_fax_no.value = "";
					formObj.frm_cust_scr_div_cd.value = "";
					formObj.frm_cust_scr_locl_amt.value = "";
					formObj.frm_scr_st_dt.value = "";
					formObj.frm_scr_end_dt.value = "";
					formObj.frm_iss_div_cd.value = "";
					formObj.frm_cust_cr_due_dt_div_cd1.checked = false;
					formObj.frm_cust_cr_due_dt_div_cd2.checked = false;
					formObj.frm_pay_dt_dy1.value = "";
					formObj.frm_pay_dt_dy2.value = "";
					formObj.frm_pay_dt_dy3.value = "";
					formObj.frm_pay_dt_dy4.value = "";
					formObj.frm_pay_dt_dy5.value = "";
					formObj.pay_wk_dy_cd.value = "";
					formObj.frm_delt_flg.value = "";
					formObj.frm_srep_cd.value = "";
					formObj.frm_srep_nm.value = "";
				}
            break;
		}
    }        

    /** 
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param  {IBSheet} sheetObj : 시트오브젝트  
    * @param  {object} formObj : 폼 오브젝트
    * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
    * @return true, false
    * @see #
    * @author 한동훈
    * @version 2009.10.19
    */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        
        	if (ComIsNull(formObj.frm_cust_seq) && ComIsNull(formObj.frm_cust_rgst_no)) {
				//ComShowCodeMessage('INV00041');
				//ComSetFocus(form.frm_cust_cnt_cd);
				//ComAlertFocus(formObj.frm_cust_seq, "Cust Code or BIZ RGST No. 중 하나를 입력하십시오.");
				ComShowCodeMessage('INV00004');
				ComSetFocus(form.frm_cust_seq);
				return false;
			}
			if(!ComIsNull(formObj.frm_cust_seq) && ComIsNull(formObj.frm_cust_cnt_cd)){
				ComShowCodeMessage('INV00004');
				ComSetFocus(form.frm_cust_cnt_cd);
				return false;
			}
        }
        return true;
    }				                			
    
    /** 
     * PopUp으로 사용될 때, 부모창으로 내려주는 값 테스트 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} formObj : 폼 오브젝트[배열]
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function getPopData(rowArray){
		var colArray = rowArray[0];	
		document.form.frm_cust_cnt_cd.value = colArray[1];
		document.form.frm_cust_seq.value = colArray[2];
	}
		
    /** 
     * 포커스 이동시 자리수 체크하여 자동으로 이동하도록 설정함 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} id_from : 입력되는 form object
     * @param  {object} id_to : 입력 후, 포커스 이동할 form object
     * @param  {number} maxSize : 입력되는 form object의 input value size
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
	function moveNext(id_from,id_to,maxSize) {			
		var cur = document.getElementById(id_from).value;
		curSize = cur.length;
		if (curSize == maxSize) {
			document.getElementById(id_to).focus();
		}
	}
		
	/** 
     * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
  	function obj_focusout() {
  		var sheetObject = sheetObjects[0];
  		var formObject = document.form;
  		switch(event.srcElement.name){
  			case "frm_cust_rgst_no":
  				var rgst = formObject.frm_cust_rgst_no.value;
  				if(rgst.length == 13){
  					formObject.frm_cust_rgst_no.value = rgst.substr(0,6)+"-"+rgst.substr(6,7);
  				}else if(rgst.length == 10){
  					formObject.frm_cust_rgst_no.value = rgst.substr(0,3)+"-"+rgst.substr(3,2)+"-"+rgst.substr(5,5);
  				}
  			break;	  
  			case "frm_cust_seq":
  				var valueCustSeq = formObject.frm_cust_seq.value;
  				if(valueCustSeq != ""){
  					formObject.frm_cust_seq.value = ComLpad(valueCustSeq,6,"0");
  				}
  			break;	
  	    }
  	}
  	
  	function msgmove(gubun){
  		msg.style.posLeft = event.x - 150 + document.body.scrollLeft;
  		msg.style.posTop = event.y - 35 + document.body.scrollTop;
	}
	
  	function msgset(gubun){
  		var formObject = document.form;
  		var textValue = "";
  		var strmsg = "";
  		if(gubun == "1"){
  			textValue = formObject.frm_xch_rt_div_cd.value;
  			if(textValue != "" && textValue != undefined){
	  			if(textValue == "A3"){
	  				strmsg = "All + 3rd LCL";
	  			}else if(textValue == "AA"){
	  				strmsg = "Inbound + Outbound";
	  			}else if(textValue == "I3"){
	  				strmsg = "Inbound + 3rd LCL";
	  			}else if(textValue == "II"){
	  				strmsg = "Inbound";
	  			}else if(textValue == "NN"){
	  				strmsg = "None";
	  			}else if(textValue == "O3"){
	  				strmsg = "Outbound + 3rd LCL";
	  			}else if(textValue == "OO"){
	  				strmsg = "Outbound";
	  			}	  			
  			text ='<table  width=150  bgcolor=#FFFFCC><tr><td style="height: 20px; border: #7896B1 1px solid; font-family: Tahoma,Arial,dotum,gulim; font-size: 14px; color: #606060; text-indent: 2px;  background-color:#CCFFFD;">' + strmsg + '</td></tr></table>';
  	  		msg.innerHTML=text;	
  			}	
  		}else{
  			textValue = formObject.frm_cng_indiv_cd.value;
  			if(textValue != "" && textValue != undefined){
	  			if(textValue == "B"){
	  				strmsg = "Onboard Date";
	  			}else if(textValue == "C"){
	  				strmsg = "Cargo Receiving Date";
	  			}else if(textValue == "N"){
	  				strmsg = "S/A Date";
	  			}else if(textValue == "O"){
	  				strmsg = "Sailing Date";
	  			}
  			text ='<table  width=150  bgcolor=#FFFFCC><tr><td style="height: 20px; border: #7896B1 1px solid; font-family: Tahoma,Arial,dotum,gulim; font-size: 14px; color: #606060; text-indent: 2px;  background-color:#CCFFFD;">' + strmsg + '</td></tr></table>';
  	  		msg.innerHTML=text;	
  			}	
  		}  		
	}

	function msghide(gubun){
		msg.innerHTML='';
	}
	/* 개발자 작업  끝 */