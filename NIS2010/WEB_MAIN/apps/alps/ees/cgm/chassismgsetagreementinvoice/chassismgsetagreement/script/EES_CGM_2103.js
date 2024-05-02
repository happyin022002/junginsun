/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2103.js
*@FileTitle : Lease Agreement Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.18 김창식
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends 
     * @class ees_cgm_2103 : ees_cgm_2103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_2103() {
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


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.18
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
        var sheetObject1 = sheetObjects[0];
          
        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
 				case "btn_Close":
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
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.18
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
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.18
     */
    function loadPage() {
    	var formObj = document.form;
    	
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	
    	// IBMultiCombo 초기화 
    	comboObjects[comboCnt++] = document.agmt_ver_no;
    	for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
    	
    	// Tab Object 초기화 
 		for(k=0;k<tabObjects.length;k++){
 			initTab(tabObjects[k],k+1);
 		}
 		
 		// 조회
 		if(validateForm(sheetObjects[0], formObj,IBSEARCH) != false) {
        	doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
        }
    }


    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김창식
     * @version 2009.06.18
     */
    function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;

         switch(sheetID) {
         	case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 160;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(12, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "|M.G.Set No.|Yard|Fueling Date|Current Running Hours|Fuel Q’ty(Gallon)|Fuel Rate|Fuel Amount|Labor Amount|Total Amount(USD)|Chassis No.|Reefer Container No.";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,   true,		"Status");
 					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopup,			100,	daCenter,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				150,	daRight,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				100,	daRight,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				100,	daRight,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				100,	daRight,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				100,	daRight,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				120,	daRight,	false,		"",		false,		"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,		"",		false,		"",		dfNone,			0,			true,		true);	
 					InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	false,		"",		false,		"",		dfNone,		2,			true,		true);	
 					
 					ShowButtonImage = 2;
 					
 			   }
                 break;

         }
    }
 
    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
     * @return 없음
     * @author 김창식
     * @version 2009.06.18
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
	            formObj.f_cmd.value = SEARCH;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
	     		sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_2103GS.do" , FormQueryString(formObj), '', true);
	              
	     		// tab1 Sheet Object
	     		sheetObjects[0].LoadSearchXml(sXml);
	     		
	     		// ETC DATA 값을  FORM OBJECT 에 세팅
	     		setEtcDataToForm(formObj, sheetObjects[0]);
		 	    ComOpenWait(false);
	     		// 전체 데이터 건수를 가져온다.
	     		var dataCount = ComGetTotalRows(sXml);
	     		
	     		if(dataCount != null && dataCount > 0){
	     		
	     			// Agreement Version Multi Combo 설정
	         		var cols = ComCgmXml2ComboString(sXml, "agmt_ver_no", "agmt_ver_no");
		         	ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
		         	comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
	     		} else {
	     			ComShowCodeMessage('CGM10012');
    	 			window.close();
	     		}
	            break;
        }
    }
     
    /**
     * ETC 데이터를 Form Tag 에 설정한다. <br>
     * @param  {object} formObj	 필수
     * @param  {object} sheetObj 필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.18
     */
    function setEtcDataToForm(formObj, sheetObj){
     	
    	formObj.eq_knd_cd.value 		= ComCgmNullToBlank(sheetObj.EtcData("eq_knd_cd"));
    	formObj.agmt_ofc_cty_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_ofc_cty_cd"));
  		formObj.agmt_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_seq"));
  		formObj.agmt_no.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_no"));
  		formObj.agmt_ref_no.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_ref_no"));
  		formObj.agmt_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_dt"));
  		formObj.agmt_iss_ofc_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_iss_ofc_cd"));
  		formObj.agmt_eff_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_eff_dt"));
  		formObj.agmt_exp_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_exp_dt"));
  		formObj.eff_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("eff_dt"));
  		formObj.exp_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("exp_dt"));
  		formObj.vndr_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("vndr_seq"));
  		formObj.vndr_lgl_eng_nm.value 	= ComCgmNullToBlank(sheetObj.EtcData("vndr_lgl_eng_nm"));
  		formObj.onh_hndl_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("onh_hndl_rt_amt"));
  		formObj.offh_hndl_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("offh_hndl_rt_amt"));
  		formObj.pay_term_dys.value 		= ComCgmNullToBlank(sheetObj.EtcData("pay_term_dys"));
  		formObj.mon_dpc_rt_amt.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mon_dpc_rt_amt")),2);
  		formObj.max_dpc_rt_amt.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("max_dpc_rt_amt")),2);
  		formObj.init_dpc_rt_amt.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("init_dpc_rt_amt")),2);
  		formObj.diff_rmk.value 			= ComCgmNullToBlank(sheetObj.EtcData("diff_rmk"));
  		formObj.agmt_lstm_cd.value		= ComCgmNullToBlank(sheetObj.EtcData("agmt_lstm_cd"));
  		
   		comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
   		
   		formObj.onh_init_val_amt_clg.value 		= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("onh_init_val_amt_clg")),2);
   		formObj.mgst_potc_scg_rt_amt_clg.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_potc_scg_rt_amt_clg")),2);
   		formObj.mgst_prtc_scg_rt_amt_clg.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_prtc_scg_rt_amt_clg")),2);
   		formObj.mgst_bldp_rt_amt_clg.value 		= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_bldp_rt_amt_clg")),2);
   		formObj.mgst_lse_fx_rt_amt_clg.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_lse_fx_rt_amt_clg")),2);
        
   		formObj.onh_init_val_amt_umg.value 		= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("onh_init_val_amt_umg")),2);
   		formObj.mgst_potc_scg_rt_amt_umg.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_potc_scg_rt_amt_umg")),2);
   		formObj.mgst_prtc_scg_rt_amt_umg.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_prtc_scg_rt_amt_umg")),2);
   		formObj.mgst_bldp_rt_amt_umg.value 		= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_bldp_rt_amt_umg")),2);
   		formObj.mgst_lse_fx_rt_amt_umg.value 	= ComCgmAmountFormat(ComCgmNullToZero(sheetObj.EtcData("mgst_lse_fx_rt_amt_umg")),2);	 
    }     



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.06.18
     */  
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
          	switch(sAction){
          	 	case IBSEARCH:	// 조회
          	 		var agmtNo = formObj.agmt_no.value;
          	 		var result = true;
          	 	
          	 		if(agmtNo != ""){
          	 			if(agmtNo.length <= 3){
          	 				result = false;
          	 			} else {
          	 				if(ComIsNumber(agmtNo.substring(3))==false){
          	 					result = false;
          	 				}
          	 			}
          	 		} else {
          	 			result = false;
          	 		}
          	 		
          	 		if(!result){
        	 			ComShowCodeMessage('CGM10004','Agreement No.');
        	 			window.close();
        	 			return false;
        	 		} else {
        	 			return true;
        	 		}
          	 			
          	 		break;
          	}
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
 						InsertTab( cnt++ , "Rental Rate" , -1 );
 						InsertTab( cnt++ , "Depr. For Casualty" , -1 );
 						InsertTab( cnt++ , "Surcharge" , -1 );
 					}
 					break;

 			}
 	}

 	/**
 	 * Tab 클릭시 이벤트 관련
 	 * 선택한 탭의 요소가 활성화 된다.
 	*/
 	function tab1_OnChange(tabObj , nItem){

 		var objs = document.all.item("tabLayer");

 			objs[nItem].style.display = "Inline";
 			objs[beforetab].style.display = "none";

 			//--------------- 요기가 중요 --------------------------//
 			objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 			//------------------------------------------------------//
 			beforetab= nItem;
 	}

 	/** 
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 김창식
     * @version 2009.06.15
     */ 
    function initCombo(comboObj) {
     	switch(comboObj.id) {
 	    	case "agmt_ver_no":
 	 	 		var cnt=0;
 	  	        with(comboObj) {
 	  	        	Code = "";
 	  	            Text = "";
 	  	            DropHeight = 100;
 	  	            MultiSelect = false;
 	  	            MaxSelect = 1;	    
 	  	            UseCode = true;
 	  	            Enable = true;
 	  	        }
 	  	        
 	  	        break;
     	}
    }  
    
    /**
     * Agreement Version No 의 Change 이벤트를 정의한다. <br>
     * @param  {string} Index_Code 필수
     * @param  {string} Text 필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */
     function agmt_ver_no_OnChange(Index_Code, Text){
     	var formObj = document.form;
     	
     	if(validateForm(sheetObjects[0], formObj, IBSEARCH) != false) {
         	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
         }
     } 

	/* 개발자 작업  끝 */