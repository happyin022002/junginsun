/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0222.js
*@FileTitle : EAC Rejection Notice History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.15 백형인
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
     * @class ESD_EAS_0222 : ESD_EAS_0222 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0222() {
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

    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	var rdObjects = new Array();
	var rdCnt = 0;	
	
	var frm = null;

    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
     * IBMultiCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
   	 comboObjects[comboCnt++] = combo_obj;
    }	


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
				case "btng_send":
					doActionIBSheet(sheetObject1,formObject,"btng_send");
					break;
                case "btng_print":
                	rdObjects[0].PrintDialog();
                	break;
                case "btng_close":
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
	    
	   doActionIBCombo(frm.s_ntc_knt_cd)
	   rdInit(rdObjects[0]);
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
					MergeSheet = 7;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(3, 1, 1, 100);

					var HeadTitle1 = "|SEQ";
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtSeq,          30,  	daCenter,   true,   "seq",              	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					
//					SetMergeCell(0, 30, 2, 2); 
//					SetMergeCell(0, 32, 2, 2); 
					
//					InLineColor = RgbColor(255,255,255); 
//					OutLineColor = RgbColor(255,255,255); 
					
				}
				break;
			}
		}
	 

	 /**
	  * rd 환경을 초기화한다.
	  */
	 function rdInit(rdObj){
	 	rdObj.AutoAdjust = true;
//	 	rdObj.HideToolbar();
	 	rdObj.SetSaveDialogEx("", "", "pdf", "pdf");
	 	rdObj.DisableToolbar(13);
	 	rdObj.DisableToolbar(14);
	 	rdObj.DisableToolbar(16);
	 	rdObj.DisableToolbar(17);
	 	rdObj.HideStatusbar();
	 	rdObj.ViewShowMode(0);
	 	rdObj.setbackgroundcolor(255,255,255);
	 	rdObj.SetPageLineColor(255,255,255);
		 
//	 		var Rdviewer = rdObj ;
//		    
////			Rdviewer.AutoAdjust = true;
////			Rdviewer.ViewShowMode(0);
//			Rdviewer.style.height = 0;
//		
//			Rdviewer.setbackgroundcolor(128,128,128);
//			Rdviewer.SetPageLineColor(128,128,128);		 
	 }
	 
	// Combo관련 프로세스 처리
	function doActionIBCombo(comboObj) {
		sheetObj = sheetObjects[0];
		switch(comboObj.id) {
			case "s_ntc_knt_cd":    
				frm.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0222GS.do", FormQueryString(frm));
				frm.s_ntc_knt_cd.RemoveAll();
				ComXml2ComboItem(sXml, frm.s_ntc_knt_cd, "code_cd", "code_nm");
				comboObj.Index=0;
			break;  

		}
	}		

   /**
    * rd를 open한다
    * @param sheetObj
    * @param Row
    * @return
    */
	function s_ntc_knt_cd_OnChange(comboObj,Index_Code, Text){   
		var Rdviewer = rdObjects[0] ;
		// 디버그 용 파라미터
		var rdParam = "/rdebugmode [1] /rp ["+frm.ofc_cd.value+"]["+frm.usr_id.value+"]["+frm.eac_no.value+"]["+Index_Code+"]";
//			var rdParam = "/rp ["+frm.ofc_cd.value+"]["+frm.usr_id.value+"]["+frm.eac_no.value+"]";
		var rdPath = RD_path+'/apps/alps/esd/eas/eac/eacmgt/report/ESD_EAS_0222.mrd';
			Rdviewer.FileOpen(rdPath, RDServer + rdParam);
	}				
	/* 개발자 작업  끝 */