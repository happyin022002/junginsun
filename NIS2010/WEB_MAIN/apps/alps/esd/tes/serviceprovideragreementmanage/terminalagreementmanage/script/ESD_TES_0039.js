/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0039.js
*@FileTitle : Terminal Agreement Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.10 yOng hO lEE
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_TES_0039 : ESD_TES_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_0039() {
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
	var Mincount = 0;
	
	var pre_ret_cond_val = '';

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      * 
      * @param {ibsheet}	sheet_obj  	Sheet Object
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
             ComConfigSheet(sheetObjects[i]);

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         document.form.yd_cd.focus();
         
         /**
  		 * 	[CHM-201533697]detail화면에서 to Summary 버튼 클릭시 이전 화면 검색 결과 유지되도록 설정 
  		 */
         try {
 			 pre_ret_cond_val = '';
 			 var retrieve_tf = false;
 			 var formObj = document.form;
 			 for (var i = 0; i < formObj.elements.length; i++){
 				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
 				     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
 				 {
 					 with (formObj) {
 						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
 							 eval(elements[i].name.substring('pre_cond_'.length,elements[i].name.length)).value = eval(elements[i].name).value;
 							 if (!retrieve_tf) {retrieve_tf = true;}
 						 }
 					 }
 				 }
 			 }
 			 
 			validateYardCode();
			validateVendorCode();
 			if (retrieve_tf) {
 				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 				tes_getInputValue('rhq_ofc_cd', SEARCHLIST09, 'acct_ofc_cd');
 			} else {
 				formObj.delt_flg.value = 'N';
 			}
 		 } catch(e){}    
     }

     /**
      * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
      **/
     document.onclick = processButtonClick;

 	/**
 	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 	 **/
 	function processButtonClick(){
           /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		var sheetObject = sheetObjects[0];
 		var sheetObject2 = sheetObjects[1];

           /*******************************************************/
 		var formObject	= document.form;

 		try {
 			var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {

 				case "btn_retrieve":
 					if (!ComIsNull(formObject.eff_on.value)){
 						if (!ComIsDate(formObject.eff_on)){
 							ComShowCodeMessage('TES10079');
 	   						return false;
 	   					}
 					}
 					
 					doActionIBSheet(sheetObject,formObject,IBSEARCH);

 	 			    tes_getInputValue('rhq_ofc_cd', SEARCHLIST09, 'acct_ofc_cd');

 					break;

  				case "btn_new":
      	            sheetObject.RemoveAll();
      	            formObject.reset();
      	            pre_ret_cond_val = '';
          	        break;

 		   	    case "btn_yard":
 		   	    	var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
 		   	       	var classId = "COM_ENS_061";
 		   	       	var param = '?classId='+classId;
 		   	       	var chkStr = dispaly.substring(0,3)
 		
 		              // radio PopUp
 		              if(chkStr == "1,0") {
 		            	  ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 430, 'getYard', dispaly);
 		              } else {
 		            	  ComShowCodeMessage('TES10004');
 		            	  return;
 		              }
 		   	       	break;
 		
 		   	    case "btn_vndr":
 		   	    	var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
 		   	    	var classId = "COM_ENS_0C1";
 		   	    	var param = '?classId='+classId;
 		   	    	var chkStr = dispaly.substring(0,3);
 		
 		   	    	// radio PopUp
 		   	    	if(chkStr == "1,0") {
 		   	    		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getVender', dispaly);
 		   	    	} else {
 		   	    	ComShowCodeMessage('TES10004');
 		   	    		return;
 		   	    	}
 		   	    	break;
 		
 		   	    case "btns_calendar":
 		   	    	var cal = new ComCalendar();
 		   	    	cal.select(formObject.eff_on, 'yyyy-MM-dd');
 		             		 
 		   	    	break;
 		
 		   	    case "btng_adjustmentscreen":
	   	    		if(!rhqValidChk()){
 		   	    		return false;
 		   	    	} 	
	   	    		
 		   	    	if(sheetObjects[0].SelectRow == 1 || sheetObjects[0].SelectRow == 0){
 		   	    	ComShowCodeMessage('TES10080');
 		   	    		return false;
 		   	    	}
 		   	    	if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 0) == "" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "agmt_no") =="" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ver_no") =="")
 		   	    	{
 		   	    	ComShowCodeMessage('TES10081');
 		   	    		return false;
 		   	    	}

 		   	    	// Contract Office Code(9) 와 Login Office Code로 비교 하던것을 Creation Office Code(17)로 변경. 송민정, 김보영대리 요청. 4341.12.05(12.15CSR적용)
 		   	    	if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cre_ofc_cd") != ofc_cd ){  
 		   	    		ComShowCodeMessage('TES50203');// 20100607 creation office code로 바뀜 
 		   	    		return false;
 		   	    	}
		   	    	
 		   	    	if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_sts_cd") == "C") {
 		   	    		var reg_gb = ComShowConfirm(ComGetMsg('TES10124'));
 		   	    	} else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_sts_cd") == "P"){
 		   	    		var reg_gb = true;
 		   	    	}
 		
 		   	    	if(reg_gb == true){
 		   	    		var agmt_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "agmt_no");
 		   	    		var agmt_ver_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ver_no");
  	    		
 		   	    		location.href="ESD_TES_0034.do?pgmNo=ESD_TES_0034&tml_agmt_ofc_cty_cd="+agmt_no+"&tml_agmt_ver_no="+agmt_ver_no+"&inquiryFlg=Y&sysCommUiTitle=Terminal Agreement Creation %26 Adjustment&sysCommUiNavigation=Terminal S/O > Agreement > Terminal Agreement Creation %26 Adjustment";
 		   	    	} else {
 		   	    		return false;
 		   	    	}
 		   	    	break;
 		
 		   	    case "btng_detail":
 		   	    	if(sheetObjects[0].SelectRow == 1 || sheetObjects[0].SelectRow == 0){
 		   	    		ComShowCodeMessage('TES10080');
 		   	    		return false;
 		   	    	}
 		   	    	if( sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 0) == "" || 
 		   	    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "agmt_no") == "" || 
 		   	    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ver_no") == "" ) {
 		   	    		ComShowCodeMessage('TES10081');
 		   	    		return false;
 		   	    	}
 		   	    	var agmt_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "agmt_no");
 		   	    	var agmt_ver_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ver_no");
 		   	    	
 		   	    	if ( ComIsNull(agmt_no) || ComIsNull(agmt_ver_no) ) {
 		   	    		ComShowCodeMessage('TES10081');
 		   	    		return false;
 		   	    	}
 		
 		   	    	// AGMT/INV 권한 제어
 		   	    	formObject.no_ofc_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cre_ofc_cd");
 		   	    	formObject.no_yd_cd.value  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "yd_cd");
 		   	    	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'goDetail');

// 		   	    	location.href="ESD_TES_0040.do?pgmNo=ESD_TES_0040&agmt_no="+agmt_no+"&agmt_ver_no="+agmt_ver_no+"&sysCommUiTitle=Detail&sysCommUiNavigation=Terminal S/O > Agreement > Terminal Agreement Inquiry";
 		   	    	break;
 		
 		   	    case "btng_downexcel":
 		   	    	//-------------------Auth Excel Download 결재로직 START--------------------------
 		   	    	/*
 		   	    	 * [CHM-201538739]Excel down 사전 결재 진행건 (시범적용) 2015-12-16
 		   	    	 * 모듈명과 화면명 각 모듈에 맞게 하드코딩
 		   	    	 */
	 		   		var authSubSysCd = "TES";
	 		   	    var authPgmNo = "ESD_TES_0039";
 		   	    	
 		   	    	chkXlsBtnPrmtBF(authSubSysCd, authPgmNo, sheetObject);//ETC용 sheet이므로 아무렇게나 넣으셔도 됩니다.
 		   	    	if(xlsDlRstrActFlg == "N"){
 		   	    		/*
 		   	    		 * 기존 액셀 Download 소스
 		   	    		 */
 		   	    		doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 		   	    	}else if(xlsDlRstrActFlg == "Y"){
	 		   	    		if(authAproStsCd == "C" && !(authAproRqstNo==null || authAproRqstNo==undefined || authAproRqstNo==""|| authAproRqstNo.length != 30)){
	 		   	    			/*
	 	 		   	    		 * 기존 액셀 Download 소스
	 	 		   	    		 */
	 		   	    			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	 		   	    		}else if(authAproStsCd == "P"){
	 		   	    			//ComShowMessage("The approval for Excel Download is in progress\n[Rqst No.:"+authAproRqstNo+"]");
	 		   	    			ComShowMessage(ComGetMsg('AUTH00001', authAproRqstNo));
	 		   	    		}else{
	 		   	    			var param = "?sub_sys_cd="+authSubSysCd+"&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no="+authPgmNo;
	 		   	    			chkXlsDnPopup(param); //결재창 Popup
	 		   	    		}
 		   	    	}else{
 		   	    		ComShowMessage(ComGetMsg('AUTH00002'));
 		   	    	}
 		   	    	//-------------------Auth Excel Download 결재로직 END--------------------------
 		   	    	break;
 		
 		   	    case "btng_print":
 		   	    	//-------------------Auth Print 결재로직 START--------------------------
 		   	    	/*
 		   	    	 * [CHM-201538739]Excel down 사전 결재 진행건 (시범적용) 2015-12-16
 		   	    	 * 모듈명과 화면명 각 모듈에 맞게 하드코딩
 		   	    	 */
	 		   	    var authSubSysCd = "TES";
	 		   	    var authPgmNo = "ESD_TES_0039";
	 		   	    
 		   	    	chkXlsBtnPrmtBF(authSubSysCd, authPgmNo, sheetObject);//ETC용 sheet이므로 아무 Sheet나 넣으셔도 됩니다.
 		   	    	if(xlsDlRstrActFlg == "N"){
 		   	    		/*
 		   	    		 * 기존 액셀 Download 소스
 		   	    		 */
	 		   	    	if(sheetObjects[0].RowCount('') > 0){
	 		   	    		var fromObj = new Array();
	 		   	    		var rdObj  	= new Array();
	 		   	    		var parmObj = new Array();
	 		   	    		fromObj[0]	= formObject;        // RD 로 보내기 위해 배열로담는다
	 		   	    		rdObj[0]	= sheetObjects[0];     // Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다
	
	 		   	    		// RD 로 보내기 위한 설정
	 		   	    		parmObj[0] = "1";
	 		   	    		parmObj[1] = "";
	 		   	    		parmObj[2] = "N";
	 		   	    		parmObj[3] = RD_path+"apps/alps/esd/tes/serviceprovideragreementmanage/terminalagreementmanage/report/ESD_TES_0803.mrd";     // RD 화면
	 		   	    		parmObj[4] = rdObj;
	 		   	    		parmObj[5] = fromObj;
	 		   	    		
	 		   	    		rdObjModaless(RdReport , parmObj , 1000 ,700);
	 		   	    	}
	 		   	    	else{
	 		   	    		ComShowMessage(ComGetMsg('TES10078'));
	 		   	    	}
 		   	    	}else if(xlsDlRstrActFlg == "Y"){
	 		   	    		if(authAproStsCd == "C" && !(authAproRqstNo==null || authAproRqstNo==undefined || authAproRqstNo==""|| authAproRqstNo.length != 30)){
	 		   	    			/*
	 	 		   	    		 * 기존 액셀 Download 소스
	 	 		   	    		 */
		 		   	    		if(sheetObjects[0].RowCount('') > 0){
		 	 		   	    		var fromObj = new Array();
		 	 		   	    		var rdObj  	= new Array();
		 	 		   	    		var parmObj = new Array();
		 	 		   	    		fromObj[0]	= formObject;        // RD 로 보내기 위해 배열로담는다
		 	 		   	    		rdObj[0]	= sheetObjects[0];     // Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다
	
		 	 		   	    		// RD 로 보내기 위한 설정
		 	 		   	    		parmObj[0] = "1";
		 	 		   	    		parmObj[1] = "";
		 	 		   	    		parmObj[2] = "N";
		 	 		   	    		parmObj[3] = RD_path+"apps/alps/esd/tes/serviceprovideragreementmanage/terminalagreementmanage/report/ESD_TES_0803.mrd";     // RD 화면
		 	 		   	    		parmObj[4] = rdObj;
		 	 		   	    		parmObj[5] = fromObj;
		 	 		   	    		
		 	 		   	    		rdObjModaless(RdReport , parmObj , 1000 ,700);
		 	 		   	    	}
		 	 		   	    	else{
		 	 		   	    		ComShowMessage(ComGetMsg('TES10078'));
		 	 		   	    	}
	 		   	    		}else if(authAproStsCd == "P"){
	 		   	    			//ComShowMessage("The approval for Excel Download is in progress\n[Rqst No.:"+authAproRqstNo+"]");
	 		   	    			ComShowMessage(ComGetMsg('AUTH00001', authAproRqstNo));
	 		   	    		}else{
	 		   	    			var param = "?sub_sys_cd="+authSubSysCd+"&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no="+authPgmNo;
	 		   	    			chkXlsDnPopup(param); //결재창 Popup
	 		   	    		}
 		   	    	}else{
 		   	    		ComShowMessage(ComGetMsg('AUTH00002'));
 		   	    	}
 		   	    	//-------------------Auth Print 결재로직 END--------------------------
 		   	    	break;

              } // end switch
 		}catch(e) {
 			if( e == "[object Error]") {
 				ComShowCodeMessage('TES21025');
 			} else {
 				ComShowMessage(e);
 			}
 		}
 	}

 	/**
 	 * 시트 초기설정값, 헤더 정의
 	 * 시트가 다수일 경우 시트 수만큼 case 를 추가하여 시트 초기화모듈을 구성한다
     * 
     * @param {ibsheet}		sheetObj  	IBSheet Object
     * @param {int,String}	sheetNo  	Sheet Object 태그의 아이디에 붙인 일련번호
     */
 	function initSheet(sheetObj,sheetNo) {

 		var cnt = 0;

 		switch(sheetNo) {
 			case 1:      //sheet1 init
 				with (sheetObj) {

 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = false;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 2, 1, 9, 100);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(26, 3, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false,false)
 					
 					// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) 
 					var HeadTitle		= "Seq.|Agreement\r\nNo.|Agreement\r\nVer.|Yard Code|S/P\r\nCode|S/P\r\nName(ABBR)|Effective Date|Effective Date|Auto Extension\r\nY/N|GW Contract\r\nLink|Contract Office|Creation Office|Currency|Creation Date|Creation User ID|Creation User Name|Update Date|Update User ID|Update User Name|AGMT Approval\nDate|AGMT\nConfrim|AGMT\nConfrim Date|AGMT Confrim\nUser ID|AGMT Confrim\nName|Deleted\nY/N|AGMT\nStatus";
 					var HeadTitle1	= "Seq.|Agreement\r\nNo.|Agreement\r\nVer.|Yard Code|S/P\r\nCode|S/P\r\nName(ABBR)|From|To|Auto Extension\r\nY/N|GW Contract\r\nLink|Contract Office|Creation Office|Currency|Creation Date|Creation User ID|Creation User Name|Update Date|Update User ID|Update User Name|AGMT Approval\nDate|AGMT\nConfrim|AGMT\nConfrim Date|AGMT Confrim\nUser ID|AGMT Confrim\nName|Deleted\nY/N|AGMT\nStatus";


 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 					InitHeadRow(1, HeadTitle1, true);

 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtSeq,		30,			daCenter,			true,    "",							false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,			true,    "agmt_no",					false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		90,			daCenter,			true,    "ver_no",					false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		90,			daCenter,			true,    "yd_cd",						false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		90,			daCenter,			true,    "vndr_seq",					false,			"",			dfNone,			0,			true,			true	);

 					InitDataProperty(0, cnt++ , dtData,		90,			daCenter,			true,    "vndr_lgl_eng_nm",		false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		70,			daCenter,			true,    "eff_fm_dt",					false,			"",			dfDateYmd,		0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		70,			daCenter,			true,    "eff_to_dt",					false,			"",			dfDateYmd,		0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,			true,    "auto_xtd_flg",				false,			"",			dfNone,			0,			true,			true	);
 					// 비용지급 전표 결재 기능 - 3차  (4347-10-06)
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,			true,    "gw_cont_yn",				false,			"",			dfNone,			0,			true,			true	);
 					
 					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,			true,    "ctrt_ofc_cd",				false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,			true,    "cre_ofc_cd",				false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,			true,    "curr_cd",					false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,			true,    "cre_dt",						false,			"",			dfDateYmd,		0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtHidden,	120,		daCenter,			true,    "cre_usr_id",				false,			"",			dfNone,			0,			true,			true	);
 					
 					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,			true,    "cre_usr_nm",				false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,			true,    "upd_dt",					false,			"",			dfDateYmd,		0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtHidden,	120,		daCenter,			true,    "upd_usr_id",				false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,			true,    "upd_usr_nm",				false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,			true,    "agmt_apro_dt",			false,			"",			dfDateYmd,		0,			true,			true	);

 					// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) 
 					InitDataProperty(0, cnt++ , dtData,		60,			daCenter,			true,    "agmt_cfm_flg",				false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtHidden,	120,		daCenter,			true,    "agmt_cfm_dt",				false,			"",			dfDateYmd,		0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtHidden,	120,		daCenter,			true,    "agmt_cfm_usr_id",		false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,			true,    "agmt_cfm_usr_nm",		false,			"",			dfNone,			0,			true,			true	);
 					InitDataProperty(0, cnt++ , dtData,		70,			daCenter,			true,    "delt_flg",					false,			"",			dfNone,			0,			true,			true	);

 					InitDataProperty(0, cnt++ , dtData,		50,			daCenter,			true,    "tml_agmt_sts_cd",			false,			"",			dfNone,			0,			true,			true	);
 					
 					RangeBackColor(1, 6, 1, 7) = RgbColor(222, 251, 248);   // ALPS
 					RowHeight(0) = 10;
 					RowHeight(1) = 10;
 					// 높이 설정
 					style.height = GetSheetHeight(15);

 				}
 				break;

 		}
 	}


     
 	/**
      *  Sheet관련 프로세스 처리
      * 
      * @param {sheetObj}  	Sheet Object
      * @param {formObj}  	Form Object
      * @param {sAction}  	Action Command
      */
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg = false;
		
 		switch(sAction) {

 			case IBSEARCH:      //조회
 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch4Post("ESD_TES_0039GS.do", tesFrmQryStr(formObj));
 			
			break;

            case IBDOWNEXCEL:        //엑셀 다운로드
//            	sheetObj.Down2Excel(-1, false, false, true);
            	sheetObj.SpeedDown2Excel(-1, true);
            	
            	break;

            case IBLOADEXCEL:        //엑셀 업로드
            	sheetObj.LoadExcel();
            	break;

 		}
 	}


 	/**
	 * Sheet 조회후 처리. 
	 * 
	 * @param {ibsheet}		sheetObj	sheet Objcet
	 **/
 	function sheet1_OnSearchEnd(sheetObj){
 		if (sheetObj.RowCount > 0) {
 			/**
 			 * 조회 조건으로 조회가 성공적으로 된 경우만 pre_cond 조건에 넣는다.
 			 */
 			pre_ret_cond_val = getPreviousRetreiveCondition();
		
	 		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	 			if(sheetObj.CellValue(i,'tml_agmt_sts_cd')=='P'){
	 				sheetObj.ToolTipText(i,'tml_agmt_sts_cd') = 'Processing';
	 			}else if(sheetObj.CellValue(i,'tml_agmt_sts_cd')=='C'){
	 				sheetObj.ToolTipText(i,'tml_agmt_sts_cd') = 'Confirmed';
	 			}
	 		} 		
 		}
 	}


 	/**
 	 * Yard  정보 설정
 	 * 
 	 * @param {Array}	rowArray  	rowArray
 	 */
 	function getYard(rowArray) {
 		var colArray = rowArray[0];
 		document.all.yd_cd.value = colArray[3];
 		document.all.yd_cd_name.value = colArray[4];
 	}

 	/**
 	 * Vendor  정보 설정
 	 * 
 	 * @param {Array}	rowArray  	rowArray
 	 */
 	function getVender(rowArray) {
 		var colArray = rowArray[0];
     	document.all.vndr_seq.value = colArray[2];
     	//document.all.vndr_seq.value = colArray[6];
     	document.all.vndr_seq_name.value = colArray[4];
 	}

 	/**
 	 * Yard Code 유효성 검증
 	 * 
 	 */
 	function validateYardCode() {
 		var formObj = document.form;
 		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == '')
 		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			return false;
		}
	
		if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim())
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');
		}
 	}
	
 	/**
 	 * Yard Code의 유효성 검증
 	 * 
 	 */
 	function checkValidYardCode(){
 		var formObj = document.form;
 		var tmp = '';
 		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
 			tmp = formObj.is_valid_yd_cd.value.split('|');

 			if (tmp.length > 0){
 				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
 				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){
 					formObj.yd_cd_name.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
 					formObj.yd_cd_hidden.value = formObj.yd_cd.value;

 					formObj.yd_cd_deltflg.value = (tmp[9]!=undefined&&tmp[9]!=null?tmp[9]:'');

 					if(formObj.yd_cd_deltflg.value=="Y"){
 							ComShowMessage(ComGetMsg('TES10129'));
 					}

 				} else {
 					formObj.is_valid_yd_cd.value = '';
 					formObj.yd_cd_hidden.value = '';
 					formObj.yd_cd.value = '';
 					formObj.yd_cd_name.value = '';
 					ComShowMessage(ComGetMsg('TES10066'));
 				}
 			} else {
 				formObj.is_valid_yd_cd.value = '';
 				formObj.yd_cd_hidden.value = '';
 				formObj.yd_cd.value = '';
 				formObj.yd_cd_name.value = '';
 				ComShowMessage(ComGetMsg('TES10066'));
 			}
 		} else {
 			formObj.is_valid_yd_cd.value = '';
 			formObj.yd_cd_hidden.value = '';
 			formObj.yd_cd.value = '';
 			formObj.yd_cd_name.value = '';
 			ComShowMessage(ComGetMsg('TES10066'));
 		}
 	}


 	/**
 	 * Vendor Code의 유효성 검증
 	 * 
 	 */
 	function validateVendorCode() {
 		var formObj = document.form;
 		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == '')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
 		
		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}

		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVendorCode');
		}
	}

 	/**
 	 * Vendor Code의 유효성 검증
 	 * 
 	 */
 	function checkValidVendorCode(){
 		var formObj = document.form;
 		var tmp = '';
 		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
 			tmp = formObj.is_valid_vndr_seq.value.split('|');
 			if (tmp.length > 0){
 				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
 				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
 					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
 					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;

 					formObj.vndr_seq_deltflg.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');

 					if(formObj.vndr_seq_deltflg.value=="Y"){
 							ComShowMessage(ComGetMsg('TES10130'));
 					}

 				} else {
 					formObj.is_valid_vndr_seq.value = '';
 					formObj.vndr_seq_hidden.value = '';

 					formObj.vndr_seq.value = '';
 					formObj.vndr_seq_name.value = '';
 					ComShowMessage(ComGetMsg('TES10067'));
 				}
 			} else {
 				formObj.is_valid_vndr_seq.value = '';
 				formObj.vndr_seq_hidden.value = '';
 				formObj.vndr_seq.value = '';
 				formObj.vndr_seq_name.value = '';
 				ComShowMessage(ComGetMsg('TES10067'));
 			}
 		} else {
 			formObj.is_valid_vndr_seq.value = '';
 			formObj.vndr_seq_hidden.value = '';
 			formObj.vndr_seq.value = '';
 			formObj.vndr_seq_name.value = '';
 			ComShowMessage(ComGetMsg('TES10067'));
 		}
 	}
 	
 	 /** goDetail()
 	  * 
 	  * @return
 	  */
 	function goDetail(){
	    if(document.form.auth_ofc_cd.value=="Y"){
	    	location.href="ESD_TES_0040.do?pgmNo=ESD_TES_0040&agmt_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "agmt_no")
	    					+"&agmt_ver_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ver_no")
	    					+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
	    					+"&sysCommUiTitle=Detail&sysCommUiNavigation=Terminal S/O > Agreement > Terminal Agreement Inquiry";
	    }else{
	    	ComShowMessage(ComGetMsg('TES50202'));
	    }
 				
 	}
 	 
 	/**
	 * Input Value Check
	 * 
	 * @param {Object}	obj  	Object
	 */
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';//substring(obj.value,0,obj.maxLength);
			obj.focus();
			return false;
		}
	}

	/**
	 * 숫자 Value Check
	 * 
	 * @param {Object}	obj  	Object
	 */
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj, "-")){
			obj.value = '';
		}
	}

	/**
	 * 영문/숫자 Value Check
	 * 
	 * @param {Object}	obj  	Object
	 */
	function isApNum2(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}
		obj.value = obj.value.toUpperCase();
	}

	/**
	 * 숫자만 Value Check
	 * 
	 * @param {Object}	obj  	Object
	 */
	function isNum(obj){
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}

 	 /** rhqValidChk()
	  * 
	  * @return
	  */
	function rhqValidChk(){
	    if(document.form.rhq_ofc_cd.value !="Y"){
	    	ComShowMessage(ComGetMsg('TES50204'));
	    	return false;
	    }
	    return true;
	}
	
	/**
     * pre_cond 조건 가져오기
     * @return 
     */
    function getPreviousRetreiveCondition(){
    	var retval = '';
    	
    	if (document.form.yd_cd!=undefined && document.form.yd_cd.value!=null && document.form.yd_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_yd_cd="+document.form.yd_cd.value;
    	}
    	if (document.form.vndr_seq!=undefined && document.form.vndr_seq.value!=null && document.form.vndr_seq.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_vndr_seq="+document.form.vndr_seq.value;
    	}
    	if (document.form.eff_agmt!=undefined && document.form.eff_agmt.value!=null && document.form.eff_agmt.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_eff_agmt="+document.form.eff_agmt.value;
    	}
    	if (document.form.eff_on!=undefined && document.form.eff_on.value!=null && document.form.eff_on.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_eff_on="+document.form.eff_on.value;
    	}
    	if (document.form.ctrt_ofc_cd!=undefined && document.form.ctrt_ofc_cd.value!=null && document.form.ctrt_ofc_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_ctrt_ofc_cd="+document.form.ctrt_ofc_cd.value;
    	}
    	//if (document.form.delt_flg!=undefined && document.form.delt_flg.value!=null && document.form.delt_flg.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_delt_flg="+document.form.delt_flg.value;
    	//}
    	if (document.form.tml_agmt_sts_cd!=undefined && document.form.tml_agmt_sts_cd.value!=null && document.form.tml_agmt_sts_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_tml_agmt_sts_cd="+document.form.tml_agmt_sts_cd.value;
    	}
    	if (document.form.cre_ofc_cd2!=undefined && document.form.cre_ofc_cd2.value!=null && document.form.cre_ofc_cd2.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_cre_ofc_cd2="+document.form.cre_ofc_cd2.value;
    	}

    	return retval;
    }
    
    function getSubOffice1(){
    	if(document.form.ctrt_ofc_cd.value != ''){
    		if(document.form.sub_office1.checked == true){
    			document.form.ofc_cd.value = document.form.ctrt_ofc_cd.value;
    			tes_getInputValue('sub_ofc_cd1', SEARCHLIST15, 'ofc_cd');
    		} else {
    			document.form.sub_ofc_cd1.value = '';
    		} 
    	}
    }
    	
    function getSubOffice2(){
    	if(document.form.cre_ofc_cd2.value != ''){
    		if(document.form.sub_office2.checked == true){
    			document.form.ofc_cd.value = document.form.cre_ofc_cd2.value;
    			tes_getInputValue('sub_ofc_cd2', SEARCHLIST15, 'ofc_cd');
    		} else {
    			document.form.sub_ofc_cd2.value = '';
    		}  	
    	}
    }
    
	function getSubOffice1(){
    	if(document.form.sub_office1.checked == true){
    		if(document.form.ctrt_ofc_cd.value != ''){
    			document.form.ofc_cd.value = document.form.ctrt_ofc_cd.value;
    			tes_getInputValue('sub_ofc_cd1', SEARCHLIST15, 'ofc_cd', 'setSubOffice1');
    		} else {
    			ComShowMessage('Please enter Contract Office.');
				document.form.sub_office1.checked = false;
    		}
    	} else {
    		document.form.sub_ofc_cd1.value = '';
    		document.form.ctrt_ofc_cd.value = '';
    	} 
    }
    
    function setSubOffice1(){
    	if(document.form.sub_ofc_cd1.value != ''){
    		document.form.ctrt_ofc_cd.value = document.form.sub_ofc_cd1.value;
    	}
    }
    	
    function getSubOffice2(){
		if(document.form.sub_office2.checked == true){
			if(document.form.cre_ofc_cd2.value != ''){
				document.form.ofc_cd.value = document.form.cre_ofc_cd2.value;
				tes_getInputValue('sub_ofc_cd2', SEARCHLIST15, 'ofc_cd', 'setSubOffice2');
			} else {
				ComShowMessage('Please enter Creation Office.');
				document.form.sub_office2.checked = false;
			}
		} else {
			document.form.sub_ofc_cd2.value = '';
			document.form.cre_ofc_cd2.value = '';
		}  	
    }
    
    function setSubOffice2(){
    	if(document.form.sub_ofc_cd2.value != ''){
    		document.form.cre_ofc_cd2.value = document.form.sub_ofc_cd2.value;
    	}
    }
	
	/* 개발자 작업  끝 */