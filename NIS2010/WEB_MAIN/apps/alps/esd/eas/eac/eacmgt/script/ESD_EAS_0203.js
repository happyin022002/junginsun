/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0203.js
*@FileTitle : Office Config
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
     * @class ESD_EAS_0203 : ESD_EAS_0203 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0203() {
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
    
	//공통전역변수
    var frm = null;
	var usdRt ="";  // 환율
    
	var sheetObjects = new Array();
	var sheetCnt = 0;

	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	    
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    


	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 	var frm = document.form;
	 	var change = 0;

	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {
	 				
	 			case "btn_save":

 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
		 * body 태그의 onLoad 이벤트핸들러 구현 <br>
		 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param  없음
		 * @return 없음
		 * @see #
		 * @author Choi Do Soon
		 * @version 2009.11.16
		 */
		function loadPage() {
			frm = document.form;
		    for(i=0;i<sheetObjects.length;i++){
				 //-시작 환경 설정 함수 이름 변경
				 ComConfigSheet(sheetObjects[i]);
				 initSheet(sheetObjects[i],i+1);
				 //-마지막 환경 설정 함수 추가
				 ComEndConfigSheet(sheetObjects[i]);
			 }
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    initControl();
		}	 
		
		function initControl() {
			axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		}		
		
		
		function obj_change(){
			var obj = event.srcElement;
			switch(obj.name) {
				case "ofc_eml":
					
					if(frm.ofc_eml.value !="" && !EasIsEmailAddr(frm.ofc_eml.value)){
						// 메일주소를 확인하세요
						ComShowCodeMessage("EAS90074"); // E-mail address check
						frm.ofc_eml.focus();
						return;
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
		 	switch(sheetNo) {
		    	case 1:      //sheet1 init
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
						InitRowInfo(1, 1, 10, 100);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(17, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, true, true, false,false) ;

						var HeadTitle1 = "ibflag|seq|eac_ofc_cd|ofc_eng_nm|ofc_addr|ste_nm|cty_nm|ofc_zip_cd|ofc_phn_no|ofc_fax_no|ofc_eml|eac_ofc_url|ftr_ctnt|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);

						HeadRowHeight = 12;
						//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
						InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
						InitDataProperty(0,	cnt++,	dtData,         100,    daCenter,	false,	"eac_ofc_cd");
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ofc_eng_nm",     	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ofc_addr",       	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ste_nm",         	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "cty_nm",         	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ofc_zip_cd",     	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ofc_phn_no",     	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ofc_fax_no",     	false,    "",      dfNone,          0,          false,        true,   20);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ofc_eml",        	false,    "",      dfNone,          0,          false,        true,   20);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "eac_ofc_url",    	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ftr_ctnt",       	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "cre_usr_id",     	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "cre_dt",         	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "upd_usr_id",     	false,    "",      dfNone,          0,          false,        true,   100);
						InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "upd_dt",         	false,    "",      dfNone,          0,          false,        true,   100);
					}
					break;
		 	}
		}	
		 
		 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			sheetObj.ShowDebugMsg = false;
			
			switch (sAction) {

				// SEARCH LOGIC
				case IBSEARCH:
						sheetObjects[0].RemoveAll();
						frm.f_cmd.value = SEARCH01;
						var sParam = FormQueryString(frm);
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0203GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
					break;

				// SAVE LOGIC
				case IBSAVE:
					if(!validateForm(sheetObj,frm,sAction)) return false;

					
					if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
	            	
					
	            	frm.f_cmd.value = MULTI01;
					var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
			    		ComOpenWait(true);
				        var sXml = sheetObj.GetSaveXml("ESD_EAS_0203GS.do", sParam);
				        
						var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
						if (State != "S") {
							ComShowCodeMessage('COM130103', 'Data');
							ComOpenWait(false);
							return false;
						} else if (State == "S") {
							ComShowCodeMessage('COM130102', 'Data');
						}
						ComOpenWait(false);
			    				
					break;
 				
			}
		}		
		
		 /**
		  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		  */
		  function validateForm(sheetObj,frm,sAction){
		 	 switch(sAction) {
			 	 case IBSAVE :
			 		 if(frm.ofc_eng_nm.value==""){
			 			ComShowCodeMessage('COM130201', 'Office Name(External)'); // Office Name(External)에 값을 입력하셔야 합니다;
			 			return false;
			 		 }
			 		 
					 if(frm.ofc_eml.value !="" && !EasIsEmailAddr(frm.ofc_eml.value)){
						// 메일주소를 확인하세요
						 ComShowCodeMessage("EAS90074"); // E-mail address check
						frm.ofc_eml.focus();
						return false;
					 }
			 		 break;	 		 
		 	 } // end switch()
		 	 return true;
		  }	 		
	 	
		/**
		* Sheet1 의 OnSearchEnd 이벤트처리 <br>
		* @param  {object} sheetObj	필수	 Sheet Object
		* @param  {string} ErrMsg		필수 String
		* @return 없음
		* @version 2014.11.18
		*/ 
		function sheet1_OnSearchEnd(sheetObj, ErrMsg){
			frm.ofc_eng_nm.value  = sheetObj.CellValue(1,"ofc_eng_nm" );
			frm.ofc_addr.value    = sheetObj.CellValue(1,"ofc_addr"   );
			frm.ste_nm.value      = sheetObj.CellValue(1,"ste_nm"     );
			frm.ofc_zip_cd.value  = sheetObj.CellValue(1,"ofc_zip_cd" );
			frm.ofc_phn_no.value  = sheetObj.CellValue(1,"ofc_phn_no" );
			frm.ofc_fax_no.value  = sheetObj.CellValue(1,"ofc_fax_no" );
			frm.ofc_eml.value     = sheetObj.CellValue(1,"ofc_eml"    );
			frm.eac_ofc_url.value = sheetObj.CellValue(1,"eac_ofc_url");
			frm.ftr_ctnt.value    = sheetObj.CellValue(1,"ftr_ctnt"   );


		}
	/* 개발자 작업  끝 */