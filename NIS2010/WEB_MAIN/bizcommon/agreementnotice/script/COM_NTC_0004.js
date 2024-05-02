/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_NTC_0004.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : YJ Jeon
*@LastVersion : 1.0
* 2014.01.27 YJ Jeon
* 1.0 Creation
=========================================================
* History
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
     * @class COM_NTC_0004 : COM_NTC_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function COM_NTC_0004() {
    	this.processButtonClick			= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initControl           		= initControl;
    	this.doActionIBSheet 			= doActionIBSheet;
    	this.validateForm 				= validateForm;
    	this.searchTariffCodeName     	= searchTariffCodeName;
        this.sheet1_OnChange 			= sheet1_OnChange;
    }
    
   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
		
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_Downexcel": //저장
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
					break;
					
				case "btn_Close": //조회
					close_check();
//					window.close();
					break;							
					
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
//	
//    /**
//    * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
//    * <br><b>Example :</b>
//    * <pre>
//    *     initControl()
//    * </pre>
//    * @param 없음
//    * @return 없음
//    * @author 공백진
//    * @version 2009.04.17
//    */    
//     function initControl() {
//         //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
//        //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//        //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
//        //axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);            
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
//        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
//
//        ComClearSeparator (document.form.trf_no,"eng"); //한글 변환 키 막기 
//        ComClearSeparator (document.form.trf_nm,"eng"); //한글 변환 키 막기 
//     }
//    
//
//
//     /**
//      * OnKeyDown event를 처리한다. <br>
//      * <br><b>Example :</b>
//      * <pre>
//      *
//      * </pre>
//      * @param 없음
//      * @return 없음
//      * @author 서미진
//      * @version 2010.11.03
//      */
//     function obj_keydown(){
//         //enter key조회
//         var eleName = event.srcElement.name;
//         if (eleName == "trf_cd"|| eleName == "trf_nm"){
//             if (event.keyCode == 13){
//                 doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
//             }
//         }
//     }    
//	
//
  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
    * @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */
	function loadPage() {
		var formObj = document.form;
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);	
		}
		doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
		formObj.agmt_cnt.value = 0
		if(sheetObjects[0].CellValue(2, "agmt_cnt")!=""){
			formObj.agmt_cnt.value = sheetObjects[0].CellValue(2, "agmt_cnt")
		}
	}

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 서미진
     * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
     	case "sheet1":
     		with (sheetObj) {
                 // 높이 설정
//                 style.height = 200;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 100, 100);

                 var HeadTitle1 = "|No.|System|AGMT No.|Service Provider|Type|Create Office|Creation User|Creation User|Live User|Effective Date|Expire Date|Last Update|agmt_cnt";
				 var HeadTitle2 = "|No.|System|AGMT No.|Service Provider|Type|Create Office|ID|Name|Live User|Effective Date|Expire Date|Last Update|agmt_cnt";           
				 var headCount = ComCountHeadTitle(HeadTitle1);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// 
				 InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                               
				 InitHeadRow(1, HeadTitle2, true); 

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 	daCenter, 	true, 	"ibflag"); 
                 InitDataProperty(0, cnt++, 	dtSeq,         		40,    	daCenter,  	true,   "Seq");           
                 InitDataProperty(0, cnt++, 	dtData, 		    80, 	daCenter, 	true, 	"sys_cd");                                
                 InitDataProperty(0, cnt++ , 	dtData,				80,	    daCenter,	true,	"agmt_no");
                 InitDataProperty(0, cnt++ , 	dtData,			   100,		daLeft,		true,	"vndr_nm");
                 InitDataProperty(0, cnt++ , 	dtData,			    70,		daCenter,	true,	"agmt_trsp_tp_cd");
                 InitDataProperty(0, cnt++ , 	dtData,				80,		daCenter,	true,	"ctrt_ofc_cd");
                 InitDataProperty(0, cnt++ , 	dtData,				80,		daCenter,	true,	"ctrt_cre_usr_id");
                 InitDataProperty(0, cnt++ , 	dtData,				80,		daLeft,		true,	"ctrt_cre_usr_nm");
                 InitDataProperty(0, cnt++ , 	dtData,				80,		daCenter,	true,	"live_flg");
                 InitDataProperty(0, cnt++ , 	dtData,			   120,		daLeft,		true,	"agmt_eff_dt", false,	"",		dfTimeHm);
                 InitDataProperty(0, cnt++ , 	dtData,			   120,		daLeft,		true,	"agmt_exp_dt", false,	"",		dfTimeHm);
                 InitDataProperty(0, cnt++ , 	dtData,			   120,		daLeft,		true,	"ctrt_upd_dt", false,	"",		dfTimeHms);
                 InitDataProperty(0, cnt++ , 	dtHidden,			80,		daRight,	true,	"agmt_cnt");
                 WaitImageVisible = false;   		
     		}
          	break;
     	}
	}

	
  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 서미진
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {																		
		 		case SEARCH01: // System Name Combo	 			
		
		 			formObj.f_cmd.value = SEARCH01;		 			
		 			sheetObj.DoSearch("COM_NTC_0004GS.do", FormQueryString(formObj));	
	 		 		break;	
		 		
		 		case IBDOWNEXCEL:	 			
		 			sheetObj.Down2Excel(-1);			
 		 			break;	 							    
	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
	}
 	
 	
 	/**                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>                                                                                                                                                                                                                                                                                                                                                                                                             
	 * <br><b>Example :</b>                                                                                                                                                                                                                                                                                                                                                                                                                                         
	 * <pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	 *                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	 * </pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	 * @param {ibsheet} sheetObj 필수 IBSheet Object                                                                                                                                                                                                                                                                                                                                                                                                                
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지                                                                                                                                                                                                                                                                                                                                                                                                           
	 * @return 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	 * @author 전윤주                                                                                                                                                                                                                                                                                                                                                                                                                                               
	 * @version 2009.06.04                                                                                                                                                                                                                                                                                                                                                                                                                                          
	 */                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	function sheet1_OnSearchEnd(sheetObj, errMsg) { 
		if (errMsg == "") {			
			var n = sheetObj.HeaderRows + sheetObj.RowCount;
		    var i = sheetObj.HeaderRows;
		    for (i = sheetObj.HeaderRows ; i < n; i++) {
		    	if (sheetObj.CellValue(i, 'live_flg')== 'N') {
		    		sheetObj.CellFontColor(i,'ctrt_cre_usr_id') = sheetObj.RgbColor(255,0,0);
		            sheetObj.CellFontColor(i,'ctrt_cre_usr_nm') = sheetObj.RgbColor(255,0,0);
		            sheetObj.CellFontColor(i,'live_flg') = sheetObj.RgbColor(255,0,0);
		        }
		    }		    
		    
		    if(sheetObj.CellValue(2, 'sys_cd') != 'TRS'){		    	
		    	sheetObj.ColHidden("agmt_trsp_tp_cd") = true;		    	
		    }
		}			                                                                                                                                                                                                                                                                                                                                                                                                                       
	}   
 	
	//오늘 하루 열지 않기를 check 했을 때 쿠키 값을 세팅한다.
 	function close_check(){
		if(document.form.Notice.checked){
		      setCookie( "notice", "1" , 1);
		  }
		window.close()
	} 	
 	
 	function setCookie(name, value, expiredays){
		   var todayDate = new Date();
		   todayDate.setDate(todayDate.getDate() + expiredays);
		   document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";"
 	}


	/* 개발자 작업  끝 */