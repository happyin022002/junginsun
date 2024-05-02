/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0154.js
*@FileTitle : Client Default for Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.02.24 변종건 [CHM-201216228-01] ALPS COMMON USER INFORMATION 상 E-mail column을 BKG/DOC Client default 화면으로 이동
* 2012.12.03 김보배 [CHM-201221634] [BKG] Client Default for Booking 화면 보완
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
     * @class esm_bkg_0154 : esm_bkg_0154 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0154() {
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
	 				case "btn_save":
	 					doActionIBSheet(sheetObject1, formObject, IBSAVE);
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
	 * Receiving Term,Delivery Term 콤보 데이타를 가져온다.
	 **/
	 function initComboSetVal(sheetObj,formObj){
	 	formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0154GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		
		if (arrXml.length > 1) 
			ComXml2ComboItem(arrXml[1], formObj.rcv_term_cd, "val", "val|name");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.de_term_cd, "val", "val|name");
		
		formObj.rcv_term_cd.DropHeight = 150;
		formObj.rcv_term_cd.UseAutoComplete = true;
		formObj.de_term_cd.DropHeight = 150;
		formObj.de_term_cd.UseAutoComplete = true;
	 }	
	 
	 /**
	  * Sheet 기본 설정 및 초기화
	  * body 태그의 onLoad 이벤트핸들러 구현
	  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	  */
	 function loadPage() {
	     for(i=0;i<sheetObjects.length;i++){
	
	         //ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         //ComEndConfigSheet(sheetObjects[i]);
	     }
	     
	     /*팝업시 버튼 활성화 방지*/
	     if (ComGetObjValue(document.form.screenName).indexOf("POP") > -1) {
	    	 getButtonTable("btn_save").style.display ="none";
	     }
	     
	     initComboSetVal(sheetObjects[0],document.form);
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	
	 }
	 
	 
	/**
	 * HTML Control의 onkeypress 이벤트에서 키보드 입력을 제어한다.
	 **/
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "eng":
				//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
				//ComKeyOnlyAlphabet();
				ComKeyOnlyAlphabet('uppernum');
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
				ComKeyOnlyAlphabet('num', "45");
			default:	
				//숫자만입력하기(정수,날짜,시간)
				ComKeyOnlyNumber(event.srcElement);
		}
	}
    
      
    
	 function initSheet(sheetObj,sheetNo) {
		 var cnt = 0;
	    switch(sheetNo) {
	        case 1:   //sheet1 init
	            with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
	                
	              //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;
	
	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 15, 100);
	    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(2, 0, 0, true);
	
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false)
	    			var HeadTitle1 = " |";
	
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,         40,    daCenter,  false,   "Seq");
					
					//sheetObj.DataInsert();
	            }
	            break;
	    }
	}
	
	 // Sheet관련 프로세스 처리
	 function doActionIBSheet(sheetObj, formObj, sAction) {
	     sheetObj.ShowDebugMsg = false;
	     switch(sAction) {
	
	 		case IBSEARCH:      //조회
	 			if(validateForm(sheetObj, formObj, sAction)) {
	 				formObj.f_cmd.value = SEARCH;
	    		    var sXml = sheetObj.GetSearchXml("ESM_BKG_0154GS.do", FormQueryString(formObj));
	    		    
	    		    /*usr_id	--사용자 아이디 / 이름
					trnk_vsl_cd	
					trnk_skd_voy_no	
					trnk_skd_dir_cd	
					bkg_cgo_tp_cd	
					rcv_term_cd	  --출발지 서비스 조건(Default 값은 CY로 지정 )
					de_term_cd	  --Default 값은 CY로 지정 (	
					por_cd	
					pol_cd	
					full_rtn_yd_cd	
					mty_pkup_yd_cd	--Empty Container Default값  Default  = 선택
					wgt_ut_cd		--무게 단위  Default 값은 KGS
					meas_ut_cd		--부피 단위 Default 값은 CBM
					cntr_tpsz_cd	--컨테이너 Type/Size  Default 값은 D4
					pre_vsl_cd	
					pre_skd_voy_no	
					pre_skd_dir_cd	
					fwrd_flg	
					rtn_cct_dp_flg	 --Return CY 화물반입마감시간 표시 옵션 Default  = 선택
					tml_cct_dp_flg	 --터미널 CY 화물반입마감시간 표시 옵션  Default = 없음
					doc_cct_dp_flg	 --서류마감 시간 표시 옵션  Default = 선택
					xpt_cstms_cct_dp_flg	--수출세관마감 시간 표시 옵션 Default = 없음
					rail_cct_dp_flg  --Rail 마감 시간 미주지역 오피스 소속인 경우에는 Default = 선택 
					prn_bl_tp_cd	
					prn_chg_tp_cd	
					prn_cntr_tp_cd	
					prn_bl_face_knt	
					prn_bl_ridr_knt	
					dflt_eml	
					dflt_phn_no	
					dflt_fax_no	
					an_prn_rt_flg			--Collect 운임 표시 옵션  Default 값 없음
					an_rmk					--Arrival Notice의 Remark 입력값 Default값 없음
					dot_prn_flg	
					drft_bl_xch_rt_dp_flg	--적용 환율 정보 표시 Default = 선택 (User ID 가 LK 지역 오피스 인 경우 선택 안 함)
					drft_bl_call_sgn_dp_flg	  --호출번호 Default = 선택 (User ID가 KR, TH, SG 오피스 인 경우 선택 안 함)
					drft_bl_mrn_no_dp_flg	  --한국 세관 신고 번호 Default = 선택 안 함 (User ID가 KR 오피스 인 경우만 선택)
					drft_bl_rmk	    --기타 Free Text 정보 입력 Default = Blank 표시
										User ID가 KR 지역 오피스의 경우  WON : 우리은행 006-173481-01-001 ㈜ 한진해운  USD : 외환은행 061-JCD-100183
										User ID가 SG 지역 오피스의 경우
										Please issue cheque to Hanjin Shipping Co., Ltd
					auto_edi_hld_flg -- 추가 2010.01.10
					cre_usr_id	
					cre_dt	
					upd_usr_id	
					upd_dt		*/
	    		    
	    		    if (ComGetEtcData(sXml,"usr_id") != undefined){
	    		    	formSettingVal(formObj,sXml);
	    		    }else{
	    		    	initFormSettingVal(formObj,sXml);
	    		    	ComShowCodeMessage('BKG00095');
	    		    }
	           	}
	             break;
	
	 		case IBSAVE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)) {
	 				formObj.f_cmd.value = MULTI;
	 				checkObjectSaveSetting(formObj.auto_edi_hld_flg);
	 				checkObjectSaveSetting(formObj.rtn_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.tml_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.doc_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.xpt_cstms_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.rail_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.an_prn_rt_flg);
	 				checkObjectSaveSetting(formObj.drft_bl_xch_rt_dp_flg);
	 				checkObjectSaveSetting(formObj.drft_bl_call_sgn_dp_flg);
	 				//checkObjectSaveSetting(formObj.drft_bl_mrn_no_dp_flg);
	 				
	 				checkObjectSaveSetting(formObj.bkg_rct_ntc_rcv_flg);
	 				checkObjectSaveSetting(formObj.mty_rlse_ord_rcv_flg);
	 				checkObjectSaveSetting(formObj.tro_ntc_rcv_flg);
	 				checkObjectSaveSetting(formObj.vskd_dlay_flg);
	 				checkObjectSaveSetting(formObj.drft_wbl_rcv_flg);
	 				checkObjectSaveSetting(formObj.srnd_ntc_rcv_flg);
	 				checkObjectSaveSetting(formObj.an_rcv_flg);
	 				checkObjectSaveSetting(formObj.eur_cgor_flg);
	 				checkObjectSaveSetting(formObj.fcntr_rlse_flg);
	 				checkObjectSaveSetting(formObj.smpl_si_flg);
	 				
	 				sheetObjects[0].WaitImageVisible = false;
	 				ComOpenWait(true); //대기이미지 표시
	 				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0154GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSaveXml(SaveXml);
	 				ComOpenWait(false); //대기이미지 숨김
	 			}
	            break;
	     }
	 }
	 function formSettingVal(formObj,sXml){
		ComSetObjValue(formObj.rcv_term_cd,ComGetEtcData(sXml,"rcv_term_cd"));
		ComSetObjValue(formObj.de_term_cd,ComGetEtcData(sXml,"de_term_cd"));
	 	formObj.mty_pkup_yd_cd.value 	= ComGetEtcData(sXml,"mty_pkup_yd_cd");
	 	formObj.wgt_ut_cd.value 		= ComGetEtcData(sXml,"wgt_ut_cd");
	 	formObj.meas_ut_cd.value 		= ComGetEtcData(sXml,"meas_ut_cd");
	 	formObj.cntr_tpsz_cd.value 		= ComGetEtcData(sXml,"cntr_tpsz_cd");
	 	formObj.dflt_eml.value 			= ComGetEtcData(sXml,"dflt_eml");
	 	formObj.dflt_phn_no.value 		= ComGetEtcData(sXml,"dflt_phn_no");
	 	formObj.dflt_fax_no.value 		= ComGetEtcData(sXml,"dflt_fax_no");
	 	
	 	
	 	checkObjectSetting(formObj.auto_edi_hld_flg,ComGetEtcData(sXml,"auto_edi_hld_flg"));
	 	checkObjectSetting(formObj.rtn_cct_dp_flg,ComGetEtcData(sXml,"rtn_cct_dp_flg"));
	 	checkObjectSetting(formObj.rtn_cct_dp_flg,ComGetEtcData(sXml,"rtn_cct_dp_flg"));
	 	checkObjectSetting(formObj.tml_cct_dp_flg,ComGetEtcData(sXml,"tml_cct_dp_flg"));
	 	checkObjectSetting(formObj.doc_cct_dp_flg,ComGetEtcData(sXml,"doc_cct_dp_flg"));
	 	checkObjectSetting(formObj.xpt_cstms_cct_dp_flg,ComGetEtcData(sXml,"xpt_cstms_cct_dp_flg"));
	 	checkObjectSetting(formObj.rail_cct_dp_flg,ComGetEtcData(sXml,"rail_cct_dp_flg"));
	 	
	 	checkObjectSetting(formObj.an_prn_rt_flg,ComGetEtcData(sXml,"an_prn_rt_flg"));
	 	formObj.an_rmk.value 			= ComGetEtcData(sXml,"an_rmk");                                       
	 	checkObjectSetting(formObj.drft_bl_xch_rt_dp_flg,ComGetEtcData(sXml,"drft_bl_xch_rt_dp_flg"));
	 	checkObjectSetting(formObj.drft_bl_call_sgn_dp_flg,ComGetEtcData(sXml,"drft_bl_call_sgn_dp_flg"));
	 	//checkObjectSetting(formObj.drft_bl_mrn_no_dp_flg,ComGetEtcData(sXml,"drft_bl_mrn_no_dp_flg"));
	 	formObj.drft_bl_rmk.value 		= ComGetEtcData(sXml,"drft_bl_rmk"); 
	 	
	 	
	 	checkObjectSetting(formObj.bkg_rct_ntc_rcv_flg,ComGetEtcData(sXml,"bkg_rct_ntc_rcv_flg"));
	 	checkObjectSetting(formObj.mty_rlse_ord_rcv_flg,ComGetEtcData(sXml,"mty_rlse_ord_rcv_flg"));
	 	checkObjectSetting(formObj.tro_ntc_rcv_flg,ComGetEtcData(sXml,"tro_ntc_rcv_flg"));
	 	checkObjectSetting(formObj.vskd_dlay_flg,ComGetEtcData(sXml,"vskd_dlay_flg"));
	 	checkObjectSetting(formObj.drft_wbl_rcv_flg,ComGetEtcData(sXml,"drft_wbl_rcv_flg"));
	 	checkObjectSetting(formObj.srnd_ntc_rcv_flg,ComGetEtcData(sXml,"srnd_ntc_rcv_flg"));
	 	checkObjectSetting(formObj.an_rcv_flg,ComGetEtcData(sXml,"an_rcv_flg"));
	 	checkObjectSetting(formObj.eur_cgor_flg,ComGetEtcData(sXml,"eur_cgor_flg"));
	 	checkObjectSetting(formObj.fcntr_rlse_flg,ComGetEtcData(sXml,"fcntr_rlse_flg"));
	 	checkObjectSetting(formObj.smpl_si_flg,ComGetEtcData(sXml,"smpl_si_flg"));
	 }
	 function initFormSettingVal(formObj,sXml){
		formObj.rcv_term_cd.value 				= "CY";                          	  	
	 	formObj.de_term_cd.value 				= "CY";
	 	formObj.mty_pkup_yd_cd.value 			= "";
	 	formObj.wgt_ut_cd.value 				= "KGS";                              
	 	formObj.meas_ut_cd.value 				= "CBM";                            
	 	formObj.cntr_tpsz_cd.value 				= "D4";  
	 	formObj.dflt_eml.value					= "";
	 	formObj.dflt_phn_no.value				= "";
	 	formObj.dflt_fax_no.value				= "";
	 	formObj.auto_edi_hld_flg.checked 		= false;   
	 	formObj.auto_edi_hld_flg.value 			= "N";  
	 	formObj.rtn_cct_dp_flg.checked 			= true;   
	 	formObj.rtn_cct_dp_flg.value 			= "Y";  
	 	formObj.tml_cct_dp_flg.checked 			= false;   
	 	formObj.tml_cct_dp_flg.value 			= "N";  
	 	formObj.doc_cct_dp_flg.checked 			= true;      
	 	formObj.doc_cct_dp_flg.value 			= "Y";  
	 	formObj.xpt_cstms_cct_dp_flg.value 		= "N";  
	 	formObj.xpt_cstms_cct_dp_flg.checked 	= false; 
	 	formObj.rail_cct_dp_flg.value 			= "N";  
	 	formObj.rail_cct_dp_flg.checked 		= false; 
	 	formObj.an_prn_rt_flg.value 			= "N";  
	 	formObj.an_prn_rt_flg.checked 			= false;
	 	formObj.an_rmk.value 					= "";  
	 	formObj.drft_bl_xch_rt_dp_flg.checked 	= true;     
	 	formObj.drft_bl_xch_rt_dp_flg.value 	= "Y";             
	 	formObj.drft_bl_call_sgn_dp_flg.checked = true;  
	 	formObj.drft_bl_call_sgn_dp_flg.value 	= "Y";  
	 	//formObj.drft_bl_mrn_no_dp_flg.checked 	= false;    
	 	//formObj.drft_bl_mrn_no_dp_flg.value 	= "N"; 
	 	formObj.drft_bl_rmk.value 				= "";    
	 	
	 	
	 	formObj.bkg_rct_ntc_rcv_flg.checked 			= false;   
	 	formObj.bkg_rct_ntc_rcv_flg.value 			= "N";  
	 	formObj.mty_rlse_ord_rcv_flg.checked 			= false;   
	 	formObj.mty_rlse_ord_rcv_flg.value 			= "N";  
	 	formObj.tro_ntc_rcv_flg.checked 			= false;   
	 	formObj.tro_ntc_rcv_flg.value 			= "N";  
	 	formObj.vskd_dlay_flg.checked 			= false;   
	 	formObj.vskd_dlay_flg.value 			= "N"; 
	 	
	 	formObj.drft_wbl_rcv_flg.checked 		= false;   
	 	formObj.drft_wbl_rcv_flg.value 			= "N";  
	 	formObj.srnd_ntc_rcv_flg.checked 		= false;   
	 	formObj.srnd_ntc_rcv_flg.value 			= "N";  
	 	formObj.an_rcv_flg.checked 				= false;   
	 	formObj.an_rcv_flg.value 				= "N";  
	 	
	 	formObj.eur_cgor_flg.checked 			= false;   
	 	formObj.eur_cgor_flg.value 				= "N";  
	 	formObj.fcntr_rlse_flg.checked 			= false;   
	 	formObj.fcntr_rlse_flg.value 			= "N";  
	 	
	 	formObj.smpl_si_flg.checked 			= false;   
	 	formObj.smpl_si_flg.value 				= "N";  
	 	
	 	if (ComGetEtcData(sXml,"cnt_cd") == "KR"){
	 		formObj.drft_bl_call_sgn_dp_flg.checked = false;  
		    formObj.drft_bl_call_sgn_dp_flg.value 	= "N";   
	 		//formObj.drft_bl_mrn_no_dp_flg.checked 	= true;    
		    //formObj.drft_bl_mrn_no_dp_flg.value 	= "Y"; 
		    formObj.drft_bl_rmk.value = "WON : 우리은행 006-173481-01-001 ㈜ 한진해운  \n USD : 외환은행 061-JCD-100183";
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "LK"){
	 		formObj.drft_bl_xch_rt_dp_flg.checked 	= false;     
		    formObj.drft_bl_xch_rt_dp_flg.value 	= "N";   
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "TH"){
	 		formObj.drft_bl_call_sgn_dp_flg.checked = false;  
		    formObj.drft_bl_call_sgn_dp_flg.value 	= "N";   
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "SG "){	
	 		formObj.drft_bl_call_sgn_dp_flg.checked = false;  
		    formObj.drft_bl_call_sgn_dp_flg.value 	= "N";   
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "US"){	
	 		formObj.rail_cct_dp_flg.checked = true;  
		    formObj.rail_cct_dp_flg.value 	= "Y";   
	 	}
	 }
	 function checkObjectSaveSetting(obj){
		if (obj.checked == true){
			obj.value = "Y";
		}else{
			obj.value = "N";
		}
	 }
	 function checkObjectSetting(obj,val){
		if (val == 'Y'){
			obj.checked = true; 
		}else{
			obj.checked = false; 
	 	}
	 }
	 function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
	 	if (ErrMsg == "") {
	 		ComBkgSaveCompleted();  //서버메세지 처리
		} 	 	
	 }
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	 function validateForm(sheetObj, formObj,sAction){
	     
	     return true;
	 }

	/* 개발자 작업  끝 */