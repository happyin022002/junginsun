/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0073.js
*@FileTitle : A/R Office Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.09 한동훈
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
     * @class fns_inv_0073 : fns_inv_0073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0073() {
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
	 
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
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

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");


            switch(srcName) {

                 case "btn_Retrieve":
                	 doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                     break;

                 case "btn_New":
                	 if(formObject.modifyGb.value == 'Y'){	//modifyGb : Y-수정함, N-수정안함
                		 if(!ComShowCodeConfirm("INV00069")) return;
                	 }
                	 ComResetAll();
                	 //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
                	 ComSetFocus(form.ar_ofc_cd);
                     break;

                 case "btn_Save":
                	 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                     break;
                     
                 case "btn_RowAdd":                
 					var sheetIdx = sheetObjects[1].DataInsert(-1);
                     break;
                     
                 case "btn_Delete":
                	 //doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
                	 //alert(sheetObjects[1].SelectCol+"::"+sheetObjects[1].SelectRow);
                	 sheetObjects[1].CellValue(sheetObjects[1].SelectRow,sheetObjects[1].SelectCol) = "";
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
 	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 	 * 배열은 소스 상단에 정의
 	 * </pre>
 	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
 	 * @return 없음
 	 * @see #
 	 * @author 한동훈
 	 * @version 2009.10.19
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
      * @author 한동훈
      * @version 2009.10.19
      */
     function loadPage() {
    	 for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
    	 }
    	//IBMultiCombo초기화
 		for(var k=0; k<comboObjects.length; k++){
 			initCombo(comboObjects[k],k+1);
 		}
    	     	 
    	 initControl();
    	 axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, "rdoCity");
    	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
    	 ComSetFocus(document.form.ar_ofc_cd);
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
	
   //Axon 이벤트 처리2. 이벤트처리함수
 	function obj_deactivate(){
 		switch(event.srcElement.name){
			case "inv_vat_chg_rt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;			
 		} 	    
 	}
     
     /** 
 	 * 콤보 초기설정값<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {IBMultiCombo} comboObj  comboObj
 	 * @return 없음
 	 * @see #
 	 * @author 박정진
 	 * @version 2009.10.19
 	 */
   	function initCombo(comboObj, comboNo) {
 		switch (comboObj.id) {
 			case "ar_ofc_cd2":
 				with (comboObj) {
 					//SetColAlign("left");
 	                //SetColWidth("50");
 	                //SetTitle("Office Code");
 					//MultiSelect = false;
 					//UseAutoComplete = true;
 					//DropHeight = 200;
 					ValidChar(2,0);
 					MaxLength = 6;
 				}
 				break;
 			case "inv_vat_chg_cd":
 				with (comboObj) {
 					//SetColAlign("left");
 	                //SetColWidth("50");
 	                //SetTitle("Office Code");
 					//MultiSelect = false;
 					//UseAutoComplete = true;
 					//DropHeight = 200;
 					ValidChar(2,0);
 					MaxLength = 3;
 				}
 				break;
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
              case "sheet1":      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 240;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

 					var HeadTitle = "|ar_ofc_cd|inv_iss_tp_cd|inv_snd_tp_cd|dmdt_ar_inv_iss_flg|n3pty_bil_ar_inv_flg|dmdt_inv_aply_bl_flg|cpy_inv_knt|xch_rt_rvs_flg|xch_rt_usd_tp_cd|xch_rt_n3rd_tp_cd|tml_inv_iss_flg|ots_smry_cd|inv_dup_flg|inv_mlt_bl_iss_flg|delt_flg|cre_usr_id|cre_dt|upd_usr_id|upd_dt|inv_vat_chg_cd|inv_vat_chg_rt|mnr_ar_inv_iss_flg|inv_eml_split_flg|ar_ofc_ob_grp_eml|ar_ofc_ib_grp_eml|dod_ar_inv_iss_flg|mri_locl_chg_aply_flg";
 					

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                     var prefix="sheet1_";
                     InitDataProperty(0, 	cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ar_ofc_cd"				,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_iss_tp_cd"         ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_snd_tp_cd"         ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"dmdt_ar_inv_iss_flg"   ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"n3pty_bil_ar_inv_flg"  ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"dmdt_inv_aply_bl_flg"  ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cpy_inv_knt"           ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"xch_rt_rvs_flg"        ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"xch_rt_usd_tp_cd"      ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"xch_rt_n3rd_tp_cd"     ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"tml_inv_iss_flg"       ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ots_smry_cd"           ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_dup_flg"           ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_mlt_bl_iss_flg"    ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"delt_flg"              ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cre_usr_id"            ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cre_dt"                ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"upd_usr_id"            ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"upd_dt"                ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_vat_chg_cd"        ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_vat_chg_rt"        ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"mnr_ar_inv_iss_flg"    ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"inv_eml_split_flg"     ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ar_ofc_ob_grp_eml"     ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ar_ofc_ib_grp_eml"     ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"dod_ar_inv_iss_flg"    ,	false,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"mri_locl_chg_aply_flg"    ,	false,	"",	dfNone,	0,	true,	true);
                }
                 break;
                 
              case "sheet2":      //sheet1 init
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
                      InitRowInfo(1, 1, 3, 100);

                      var HeadTitle1 = "|Approved Charge Code|Approved Charge Code|Approved Charge Code|Approved Charge Code|Approved Charge Code|Approved Charge Code";
                      var headCount = ComCountHeadTitle(HeadTitle1);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false);

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);

                      var rowCnt = 0;

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,		00,		daCenter,		false,		"hdnStatus");
						InitDataProperty(rowCnt,	cnt++,	dtCombo,    		 	100,	daCenter,		false,		"chg_cd1",			false,		"",		dfNone,		0,		true,		true);
						InitDataProperty(rowCnt,	cnt++,	dtCombo,    		 	100,	daCenter,		false,		"chg_cd2",			false,		"",		dfNone,		0,		true,		true);
						InitDataProperty(rowCnt,	cnt++,	dtCombo,    		 	100,	daCenter,		false,		"chg_cd3",			false,		"",		dfNone,		0,		true,		true);
						InitDataProperty(rowCnt,	cnt++,	dtCombo,    		 	100,	daCenter,		false,		"chg_cd4",			false,		"",		dfNone,		0,		true,		true);						
						InitDataProperty(rowCnt,	cnt++,	dtCombo,    		 	100,	daCenter,		false,		"chg_cd5",			false,		"",		dfNone,		0,		true,		true);
						InitDataProperty(rowCnt,	cnt++,	dtCombo,    		 	100,	daCenter,		false,		"chg_cd6",			false,		"",		dfNone,		0,		true,		true);						
					/*
						InitDataCombo(0, "chg_cd1", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE");
						InitDataCombo(0, "chg_cd2", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE");
						InitDataCombo(0, "chg_cd3", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE");
						InitDataCombo(0, "chg_cd4", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE");
						InitDataCombo(0, "chg_cd5", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE");
						InitDataCombo(0, "chg_cd6", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE", " |OFT|BAF|CAF|AAA|BBB|CCC|DDD|EEE");
						*/
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
      * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
      * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
      * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH_ASYNC10: //CreditCustomer Office 조회         		
         		formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0073GS.do", FormQueryString(formObj));
         		
				//ofc_cd
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
				MakeComboObject_OfcCd(formObj.ar_ofc_cd2, arrStr, "N", "N");
				
         		//chg_cd         						
         		var sStrChg = ComGetEtcData(sXml,"chg_cd");
         		addCellComboItem(sheetObjects[1],sStrChg,"chg_cd1",false);
         		addCellComboItem(sheetObjects[1],sStrChg,"chg_cd2",false);
         		addCellComboItem(sheetObjects[1],sStrChg,"chg_cd3",false);
         		addCellComboItem(sheetObjects[1],sStrChg,"chg_cd4",false);
         		addCellComboItem(sheetObjects[1],sStrChg,"chg_cd5",false);
         		addCellComboItem(sheetObjects[1],sStrChg,"chg_cd6",false);

         		var arrStr = sStrChg.split("|");
         		MakeComboObject2_1(formObj.inv_vat_chg_cd, arrStr);		        
         		break;
 			case IBSEARCH:      //조회			
 				if(!validateForm(sheetObj,formObj,sAction)) return; 							
				formObj.f_cmd.value = SEARCH;	
				formObj.ar_ofc_cd.value = formObj.ar_ofc_cd2.Text;
				//sheetObj.DoSearch("FNS_INV_0073GS.do", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchXml("FNS_INV_0073GS.do" , FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				sheetObjects[0].LoadSearchXml(arrXml[0], false);

				var sStrChg = ComGetEtcData(sXml,"chg_cd");				
				sheetObjects[1].RemoveAll();
				if(sheetObj.RowCount > 0){
					var arrStrChg = sStrChg.split("|");
					var sheetIdx = 0;
					var k = 0;
					for (var i = 1; i < arrStrChg.length;i++ ) {
						if(arrStrChg[i] != ""){
							k = i%6;
							if(k==0) k=6;
							if(k == 1){
								sheetIdx = sheetObjects[1].DataInsert(-1);
							}
							sheetObjects[1].CellValue2(sheetIdx,"chg_cd"+k) = arrStrChg[i];
						}
					}
				}
				if(sheetObj.RowCount > 0){
					dataSearch(sheetObjects[0],formObj)
 					formObj.proc_gb.value = 'U';
				}else{
					//sheetObj.Reset();					
					dataSearch(sheetObjects[0],formObj,"Y");
					formObj.proc_gb.value = 'I';
					ComSetFocus(form.inv_iss_tp_cd);
				}
				formObj.modifyGb.value = 'N';
				/*
				var sXml = sheetObj.GetSearchXml("FNS_INV_0073GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|"); 				
				sheetObj.LoadSearchXml(arrXml[0]);
				*/
                 break;

 			case IBSAVE:        //저장
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				var result = "";
 				var proc_gb = formObj.proc_gb.value;
 				dataSave(sheetObj,formObj,proc_gb); 				
 				
 				result = sheetObj.DoSave("FNS_INV_0073GS.do", FormQueryString(formObj));
 				if(result) {
 					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 				}
 				formObj.modifyGb.value = 'N';
                 break;
                 
// 			case IBDELETE:        //저장		
//           	 	var proc_gb = formObj.proc_gb.value;
// 				if(proc_gb == ""){
// 					alert("Do delete after search!");
// 					return false;
// 				}	
// 				var result = "";
// 				formObj.proc_gb.value = 'D';
// 				var proc_gb = formObj.proc_gb.value;
// 				dataSave(sheetObj,formObj,proc_gb);
// 				result = sheetObj.DoSave("FNS_INV_0073GS.do", FormQueryString(formObj));
// 				if(result) {
// 					ComResetAll();
// 					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
// 				}else{
// 					formObj.proc_gb.value = 'U';
// 				}				
//                 break;    
 			
         }
     }
     
     /** 
      * 조회 후, 데이타 값 세팅 및 check <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {String} init : 초기화('Y'), 조회후('N')
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function dataSearch(sheetObj,formObj,init){
    	if(init == 'Y'){
    		formObj.inv_iss_tp_cd.value = "";
	    	formObj.cpy_inv_knt.value = "";
 			formObj.inv_snd_tp_cd1[0].checked = false;
 			formObj.inv_snd_tp_cd1[1].checked = false;
 			formObj.inv_snd_tp_cd1[2].checked = false;
 			
 			formObj.inv_eml_tns[0].checked = false;
 			formObj.inv_eml_tns[1].checked = false;
 			
 			formObj.xch_rt_usd_tp_cd.value = "";
			formObj.xch_rt_n3rd_tp_cd.value = "";
			formObj.xch_rt_rvs_flg.value = "";
			formObj.ots_smry_cd.value = "";
			formObj.inv_dup_flg.value = "";
			formObj.inv_mlt_bl_iss_flg.value = "";
			formObj.dmdt_inv_aply_bl_flg.value = "";
			formObj.dmdt_ar_inv_iss_flg.value = "";
			formObj.n3pty_bil_ar_inv_flg.value = "";
			formObj.tml_inv_iss_flg.value = "";
			formObj.proc_gb.value = "";
			formObj.inv_snd_tp_cd.value = "";
			//formObj.inv_vat_chg_cd.value = "";
			formObj.inv_vat_chg_cd.text = "";
			formObj.inv_vat_chg_rt.value = "";
			formObj.mnr_ar_inv_iss_flg.value = "";
			formObj.ar_ofc_ob_grp_eml.value = "";
			formObj.ar_ofc_ib_grp_eml.value = "";
			formObj.dod_ar_inv_iss_flg.value = "";
			formObj.mri_locl_chg_aply_flg.value = "";
 		}else{
	    	formObj.inv_iss_tp_cd.value = sheetObj.CellValue(1,"inv_iss_tp_cd");
	    	formObj.cpy_inv_knt.value = sheetObj.CellValue(1,"cpy_inv_knt");
			var inv_snd_tp_cd = sheetObj.CellValue(1,"inv_snd_tp_cd");
			if(inv_snd_tp_cd.substring(0,1) == 'Y') {
				formObj.inv_snd_tp_cd1[0].checked = true;
			}else{
				formObj.inv_snd_tp_cd1[0].checked = false;
			}
			if(inv_snd_tp_cd.substring(1,2) == 'Y') {
				formObj.inv_snd_tp_cd1[1].checked = true;
			}else{
				formObj.inv_snd_tp_cd1[1].checked = false;
			}
			if(inv_snd_tp_cd.substring(2,3) == 'Y') {
				formObj.inv_snd_tp_cd1[2].checked = true;			
			}else{
				formObj.inv_snd_tp_cd1[2].checked = false;
			}
			
			// ????
			var inv_eml_tp_cd = sheetObj.CellValue(1,"inv_eml_split_flg");
			if(inv_eml_tp_cd == 'Y') {
				formObj.inv_eml_split_flg[1].checked = true;
			}else{
				formObj.inv_eml_split_flg[0].checked = true;
			}
			
			formObj.xch_rt_usd_tp_cd.value = sheetObj.CellValue(1,"xch_rt_usd_tp_cd");
			formObj.xch_rt_n3rd_tp_cd.value = sheetObj.CellValue(1,"xch_rt_n3rd_tp_cd");
			formObj.xch_rt_rvs_flg.value = sheetObj.CellValue(1,"xch_rt_rvs_flg");
			formObj.ots_smry_cd.value = sheetObj.CellValue(1,"ots_smry_cd");
			formObj.inv_dup_flg.value = sheetObj.CellValue(1,"inv_dup_flg");
			formObj.inv_mlt_bl_iss_flg.value = sheetObj.CellValue(1,"inv_mlt_bl_iss_flg");
			formObj.dmdt_inv_aply_bl_flg.value = sheetObj.CellValue(1,"dmdt_inv_aply_bl_flg");
			formObj.dmdt_ar_inv_iss_flg.value = sheetObj.CellValue(1,"dmdt_ar_inv_iss_flg");
			formObj.n3pty_bil_ar_inv_flg.value = sheetObj.CellValue(1,"n3pty_bil_ar_inv_flg");
			formObj.tml_inv_iss_flg.value = sheetObj.CellValue(1,"tml_inv_iss_flg");
			//formObj.inv_vat_chg_cd.value = sheetObj.CellValue(1,"inv_vat_chg_cd");
			formObj.inv_vat_chg_cd.text = sheetObj.CellValue(1,"inv_vat_chg_cd");
			formObj.mnr_ar_inv_iss_flg.value = sheetObj.CellValue(1,"mnr_ar_inv_iss_flg");
			formObj.ar_ofc_ob_grp_eml.value = sheetObj.CellValue(1,"ar_ofc_ob_grp_eml");
			formObj.ar_ofc_ib_grp_eml.value = sheetObj.CellValue(1,"ar_ofc_ib_grp_eml");
			formObj.dod_ar_inv_iss_flg.value = sheetObj.CellValue(1,"dod_ar_inv_iss_flg");
			formObj.mri_locl_chg_aply_flg.value = sheetObj.CellValue(1,"mri_locl_chg_aply_flg");
			if(sheetObj.CellValue(1,"inv_vat_chg_rt") != ""){
				formObj.inv_vat_chg_rt.value = ComAddComma2(sheetObj.CellValue(1,"inv_vat_chg_rt"), "#,###.00");
			}
 		}
     }
     
     /** 
      * 저장 후, 데이타 값 세팅 및 check <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {String} proc_gb : 등록(I), 수정(U), 삭제(D)여부 세팅
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function dataSave(sheetObj,formObj,proc_gb){
    	 var ib_flag = "";
//    	if(proc_gb == ""){
//			alert("Do save after search!");
//			return false;
//    	}else if(proc_gb == "I"){
    	if(proc_gb == "I" || proc_gb == "" ){
			formObj.f_cmd.value = MULTI01;
			ib_flag = "I";
			var sheetIdx = sheetObjects[0].DataInsert(-1);
		}else if(proc_gb == "U"){
			formObj.f_cmd.value = MULTI01;
			ib_flag = "U";
		}else if(proc_gb == "D"){
			formObj.f_cmd.value = MULTI03;
			ib_flag = "D";
		}    	
    	sheetObj.CellValue2(1,"ar_ofc_cd") = formObj.ar_ofc_cd.value;
    	sheetObj.CellValue2(1,"inv_iss_tp_cd") = formObj.inv_iss_tp_cd.value;
    	sheetObj.CellValue2(1,"cpy_inv_knt") = formObj.cpy_inv_knt.value;    	
    	var inv_snd_tp_cd1 = 'N';
    	var inv_snd_tp_cd2 = 'N';
    	var inv_snd_tp_cd3 = 'N';
    	if(formObj.inv_snd_tp_cd1[0].checked == true) inv_snd_tp_cd1 = 'Y';
    	if(formObj.inv_snd_tp_cd1[1].checked == true) inv_snd_tp_cd2 = 'Y';
    	if(formObj.inv_snd_tp_cd1[2].checked == true) inv_snd_tp_cd3 = 'Y';
    	sheetObj.CellValue2(1,"inv_snd_tp_cd") = inv_snd_tp_cd1+inv_snd_tp_cd2+inv_snd_tp_cd3;
    	
    	sheetObj.CellValue2(1,"inv_eml_split_flg") = formObj.inv_eml_split_flg[0].checked == true ?  'N' : 'Y';
    	
    	sheetObj.CellValue2(1,"xch_rt_usd_tp_cd") = formObj.xch_rt_usd_tp_cd.value;
    	sheetObj.CellValue2(1,"xch_rt_n3rd_tp_cd") = formObj.xch_rt_n3rd_tp_cd.value;
    	sheetObj.CellValue2(1,"xch_rt_rvs_flg") = formObj.xch_rt_rvs_flg.value;
    	sheetObj.CellValue2(1,"ots_smry_cd") = formObj.ots_smry_cd.value;
    	sheetObj.CellValue2(1,"inv_dup_flg") = formObj.inv_dup_flg.value;
    	sheetObj.CellValue2(1,"inv_mlt_bl_iss_flg") = formObj.inv_mlt_bl_iss_flg.value;
    	sheetObj.CellValue2(1,"dmdt_inv_aply_bl_flg") = formObj.dmdt_inv_aply_bl_flg.value;
    	sheetObj.CellValue2(1,"dmdt_ar_inv_iss_flg") = formObj.dmdt_ar_inv_iss_flg.value;
    	sheetObj.CellValue2(1,"n3pty_bil_ar_inv_flg") = formObj.n3pty_bil_ar_inv_flg.value;
    	sheetObj.CellValue2(1,"tml_inv_iss_flg") = formObj.tml_inv_iss_flg.value;
    	//sheetObj.CellValue2(1,"inv_vat_chg_cd") = formObj.inv_vat_chg_cd.value;
    	sheetObj.CellValue2(1,"inv_vat_chg_cd") = formObj.inv_vat_chg_cd.text;
    	sheetObj.CellValue2(1,"inv_vat_chg_rt") = formObj.inv_vat_chg_rt.value.replace(',','');
    	sheetObj.CellValue2(1,"mnr_ar_inv_iss_flg") = formObj.mnr_ar_inv_iss_flg.value;
    	sheetObj.CellValue2(1,"ar_ofc_ob_grp_eml") = formObj.ar_ofc_ob_grp_eml.value;
    	sheetObj.CellValue2(1,"ar_ofc_ib_grp_eml") = formObj.ar_ofc_ib_grp_eml.value;
    	sheetObj.CellValue2(1,"dod_ar_inv_iss_flg") = formObj.dod_ar_inv_iss_flg.value;
    	sheetObj.CellValue2(1,"mri_locl_chg_aply_flg") = formObj.mri_locl_chg_aply_flg.value;
    	//sheetObj.CellValue2(1,"ibflag") = ib_flag;
    	sheetObj.RowStatus(1)  = ib_flag;
    	
    	
    	//CHG_CD 등록
    	var chg_cd_txt = "";
		for (var i=1; i<=sheetObjects[1].RowCount; i++) {
			for(var j=1; j<=6; j++){
				var chg_cd_val = sheetObjects[1].CellValue(i,"chg_cd"+j)				
				if(chg_cd_val != ""){
					chg_cd_txt = chg_cd_txt +"|"+ sheetObjects[1].CellValue(i,"chg_cd"+j);
				}
			}
		}
		formObj.chg_cd.value = chg_cd_txt;
    	
    	//alert(proc_gb+"::"+sheetObj.CellValue(1,"ibflag"));
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
    	 switch(sAction) {
			case IBSEARCH:
	         	if (formObj.ar_ofc_cd2.Text == "") {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(form.ar_ofc_cd2);
	 				return false;
	 			}	         	
	 			break;
			case IBSAVE:
//				if(formObj.proc_gb.value == ""){
//					alert("Do save after search!");
//					return false;
//		    	}
				if (ComIsNull(formObj.inv_iss_tp_cd)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.inv_iss_tp_cd);
	 				return;
	 			}
				if (ComIsNull(formObj.cpy_inv_knt)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.cpy_inv_knt);
	 				return false;
	 			}
				if (ComIsNull(formObj.xch_rt_usd_tp_cd)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.xch_rt_usd_tp_cd);
	 				return false;
	 			}
				if (ComIsNull(formObj.xch_rt_n3rd_tp_cd)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.xch_rt_n3rd_tp_cd);
	 				return false;
	 			}
				if (ComIsNull(formObj.ots_smry_cd)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.ots_smry_cd);
	 				return false;
	 			}
				if (ComIsNull(formObj.inv_dup_flg)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.inv_dup_flg);
	 				return false;
	 			}
				if (ComIsNull(formObj.inv_mlt_bl_iss_flg)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.inv_mlt_bl_iss_flg);
	 				return false;
	 			}
				if (ComIsNull(formObj.dmdt_inv_aply_bl_flg)) {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(formObj.dmdt_inv_aply_bl_flg);
	 				return false;
	 			}
				break;
    	 }
      return true;
     }
     
     /** 
      * 업무 자바스크립트 OnChange 이벤트 처리 <br>
      * 선택한 항목이 combo list에 있는 데이타 인지 체크 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} comboObj : 폼 오브젝트
      * @param  {int} idx_cd : 선택한 항목에 대한 value값
      * @param  {String} text : 선택한 항목에 대한 text값
      * @param  {String} code : 선택한 항목에 대한 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
     function ar_ofc_cd2_OnChange(comboObj,Index_Code, Text){
    	 //ComResetAll();
    	 //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
    	 //ComSetFocus(form.ar_ofc_cd);
    	 //alert(idx_cd+"::"+text+"::"+code);
    	 //sheetObjects[0].Reset();    	 
    	 sheetObjects[0].RowDelete(-1,false)   
    	 //dataSearch(sheetObjects[0],document.form, 'Y');  

    	 if (document.form.ar_ofc_cd2.Text != "") {    		 
    		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    		
    	 }
     }
     
     /** 
      * 업무 자바스크립트 OnChange 이벤트 처리 <br>
      * 선택한 항목이 combo list에 있는 데이타 인지 체크 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} comboObj : 폼 오브젝트
      * @param  {int} idx_cd : 선택한 항목에 대한 value값
      * @param  {String} text : 선택한 항목에 대한 text값
      * @param  {String} code : 선택한 항목에 대한 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
     function inv_vat_chg_cd_OnChange(comboObj,Index_Code, Text){  	 
    	 if(Text != ""){
 	    	//리스트에 있는 ofc_cd 인지 체크
    		var formObject = document.form.inv_vat_chg_cd;
    		var itemindex = comboObj.FindIndex ( Text, 0); 
    		if(itemindex == "-1"){
    			ComShowCodeMessage('INV00041',"["+Text+"]");
    			formObject.focus();
	    		formObject.text = "";
        		return false;
    		}
     		
     	}
     }          
     
     /** 
      * form object에서 수정이 있을경우 세팅하여 수정여부 체크하여 new 버튼클릭시 체크. <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function modify_gb(){
    	 document.form.modifyGb.value = 'Y';
    	 
     }
     
     /** 
      * sheet상에서 데이타를 받아 sheet의 콤보박스에 세팅. <br>
      * curr_cd : currency code 세팅
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {String} comboValues : 세팅할 값
      * @param  {String} colName : sheet에서 세팅할 컬럼
      * @return (boolean) isCellCombo : CellComboItem, InitDataCombo
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */		
 	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
 		var sRow = sheetObj.SelectRow;
 		var comboTxt = "";
 		var comboVal = "";
 		var comboItems;
 		var comboItem;
 		var ROWMARK = "|";
 		var FIELDMARK = "=";

 		comboValues = "|"+" "+comboValues;
 		if (comboValues != undefined) {
 			comboItems = comboValues.split(ROWMARK);
 			for (var i = 1 ; i < comboItems.length ; i++) {
 				comboItem = comboItems[i].split(FIELDMARK);
 				if (comboItem[0] != "") {
 					comboTxt += comboItem[0];
 					comboVal += comboItem[0];
 				}
 				if (i < comboItems.length-1) {
 					comboTxt += ROWMARK;
 					comboVal += ROWMARK;
 				}				
 			}
 		}
 		
 		if (isCellCombo) {
 			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
 		}
 		else {
 			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
 		}
 	}
 	
 	/** 
     * combo List에 데이타를 세팅하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} cmbObj : 폼 오브젝트
     * @param  {String} arrStr : | 구분자로 구분되는 스트링 문자
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function MakeComboObject2_1(cmbObj, arrStr) {
  	 	cmbObj.RemoveAll();   	 	
  		for (var i = 1; i < arrStr.length;i++ ) {
  			var arrStr2 = arrStr[i].split("|");
  			cmbObj.InsertItem(i-1, arrStr2, arrStr2);
  			//var ar_ofc_cd = arrStr2[1];
  			//cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
  		}
  		cmbObj.InsertItem(0, "", "");
  	 }    
	
	
	function sheet2_OnChange(sheetObj, Row, Col){
		if( sheetObj.CellValue(Row,Col)!=""){
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH03;		
			formObj.chk_chg_cd.value = sheetObj.CellValue(Row,Col);
			var sXml = sheetObj.GetSearchXml("FNS_INV_0073GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			var dataVal = ComGetEtcData(arrXml[0],"ofcCd");
			if(dataVal != ""){
				ComShowCodeMessage("INV00177",sheetObj.CellValue(Row,Col),dataVal);
				sheetObj.SelectCell(Row, Col);
				sheetObj.CellValue(Row, Col)="";
			}
		}
  	}
     
	/* 개발자 작업  끝 */