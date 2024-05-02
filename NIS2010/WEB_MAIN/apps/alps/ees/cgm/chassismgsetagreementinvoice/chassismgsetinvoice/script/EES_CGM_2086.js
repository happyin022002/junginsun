/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2086.js
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김창식
*@LastVersion : 1.0 
* 2009.07.06 김창식
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
     * @class ees_cgm_2086 : ees_cgm_2086 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_cgm_2086() {
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
	
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
     */ 
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	          
		var sheetObject1 = sheetObjects[0];
	          
	    /*******************************************************/
	    var formObject = document.form;
	
	    try {
	    	var srcName = window.event.srcElement.getAttribute("name");
	
	        switch(srcName) {
	
	 			case "btn_Add":
	 				doActionIBSheet(sheetObject1,formObject,IBINSERT);
	 				break;
	
	 			case "btn_Delete":
	 				ComRowHideDelete(sheetObject1,"del_chk");
	 				break;
	 					
	 			case "btn_Retrieve":
	 				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	 				break;
	 					
	 			case "btn_Save":
	 				if(doActionIBSheet(sheetObject1,formObject,IBSAVE)){
	 					ComShowCodeMessage("CGM00003"); 
	 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	 				}
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
	 * @param  {object} sheet_obj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet (sheetObjects[i] );
	
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
		}
	 	
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.06
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
	    switch(sheetNo) {
	    	case 1: // sheet1 init
	    		with (sheetObj) {
	    			// 높이 설정
	                style.height = 362;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(8, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)
	
	                var HeadTitle = "||||Reference No.|SML Agreement No.|Lessor Code|Lessor Name";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
	                InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"agmt_ofc_cty_cd");
	                InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"agmt_seq");
	                     
	                InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,	"del_chk",			false,	"", dfNone,	0, true,  true);
	 				InitDataProperty(0, cnt++ , dtData,			195,	daCenter,	false,	"inv_ref_no",		false,	"",	dfNone,	0, false,  true, 25);
	 				InitDataProperty(0, cnt++ , dtPopupEdit,	195,	daCenter,		false,	"agmt_no", 			false,	"",	dfNone,	0, true,  true, 9);
	 				InitDataProperty(0, cnt++ , dtData,			195,	daCenter,	false,	"vndr_seq",			false,	"",	dfNone,	0, false, false);
	 				InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		false,	"vndr_lgl_eng_nm",	false,	"",	dfNone,	0, false, false);
	 										
	 				ShowButtonImage = 2;

	 				InitDataValid(0, "inv_ref_no", vtEngUpOther, "1234567890-;:.,~!@#$%^&*()_+{}|[]");
	 				InitDataValid(0, "agmt_no", vtEngUpOther, "1234567890");
	 			}
	                 
	            break;
	    }
	}
	
	/**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {

	    sheetObj.ShowDebugMsg = false;
	         
	    switch(sAction) {
	    	case IBSEARCH:      //조회
	    		formObj.f_cmd.value = SEARCH;
	    	    formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
	            sheetObj.DoSearch("EES_CGM_2086GS.do",FormQueryString(formObj));
	            
				ComOpenWait(false);	
				break;
	
	    	case IBSAVE:        //저장
	               
	    		var actionFlag = true; 
	 				
	    		var stsRows = sheetObj.FindStatusRow("I|U");
	    		var arrStsRows = stsRows.split(";");
	    	
	    		for (i = 0; i < arrStsRows.length-1; i++) {
	    			var row = arrStsRows[i];
	    			
	 				var invRefNo = sheetObj.cellValue(row, "inv_ref_no");
	 				var agmtCode = sheetObj.cellValue(row, "agmt_no"); 
	 					
	 				if (invRefNo == '' || agmtCode == ''){
	 							
	 					// 저장처리 수행여부 Flag 설정
	 					actionFlag = false;
	 						
	 					if (invRefNo == '') {
	 						ComShowCodeMessage('CGM10004','Refernce No.');
	 						sheetObj.focus();
	 						sheetObj.SelectCell(row, "inv_ref_no", true);
	 					} else if (agmtCode == '') {
	 						ComShowCodeMessage('CGM20007', agmtCode);
	 						sheetObj.focus();
	 						sheetObj.SelectCell(row, "agmt_no", true);
	 					}
	 					    
	 					break;
	 				}
	 			}
	 				
	 			if (actionFlag){	
	 				
	 				// Status 상태가  삭제상태인 Row 를 구함
	 				var delRows = sheetObj.FindStatusRow("D");
		    		var arrDelRows = delRows.split(";");
		    		
		    		// 체크표시된 Row 를 구함.
	 				var chkRows = sheetObj.FindCheckedRow("del_chk");
	 				var arrChkRows = chkRows.split("|");
	 	
	 				// 체크표시가 없고 삭제된 행이 없을 경우 SAVE 를 처리안함	 				
	 				if(arrChkRows.length == 1 && arrDelRows.length == 1){
	 					ComShowCodeMessage('CGM10008');	 					
	 					return false;
	 				} else {	
	 					sheetObj.WaitImageVisible=false;
	 					ComOpenWait(true);	
	 						 					
			 			formObj.f_cmd.value = MULTI;
			 			formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			 			
			 			var sParam = sheetObjects[0].GetSaveString();
		 				sParam = sParam + "&" + FormQueryString(formObj);
		 				
			 			var sXml = sheetObj.GetSaveXml("EES_CGM_2086GS.do", sParam);
		         		sheetObjects[0].LoadSaveXml(sXml);
		         		
						ComOpenWait(false);	
						return true;
	 				}
	 			}
	 				
	            break;
	
	    	case IBINSERT:      // 입력
	 				
	    		sheetObj.DataInsert(-1);
	            break;
	    }
	}
	
	/**
	 * 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event 처리
	 * Agreement No 의 선택 팝업창을 클릭할때 발생한다.
	 * @param  {object} sheetObj	필수 Sheet Object
     * @param  {int} Row			필수 Row
     * @param  {int} Col			필수 Col
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
     */
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		switch(sheetObj.ColSaveName(Col)){
			case "agmt_no":
				ComOpenPopup('/hanjin/EES_CGM_2022.do' , 800, 435, 'setPopupAgreementNo','1,0,1,1,1,1,1,1,1', true, false, Row, Col, 0);
				break;
	 	}
	}
	
    /**
 	 * Agreement 선택 팝업창에서 발생한 Callback 함수 처리
 	 * @param  {Array} aryPopupData	필수 Array Object
     * @param  {int} Row			필수 Row
     * @param  {int} Col			필수 Col
     * @param  {int} sheetIdx		필수 sheetIdx
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
     */
	function setPopupAgreementNo(aryPopupData, row, col, sheetIdx){
		var sheetObject = sheetObjects[0];
		
		sheetObject.CellValue2(row, "agmt_no") = aryPopupData[0][2];
		sheetObject.CellValue2(row, "vndr_seq") = aryPopupData[0][5];
		sheetObject.CellValue2(row, "vndr_lgl_eng_nm") = aryPopupData[0][6];
	}
	
	/**
	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
	 * Agreement No 과 Referece No 의 유효성을 체크한다. 
	 * @param  {object} sheetObj	필수 Sheet Object
     * @param  {int} Row			필수 Row
     * @param  {int} Col			필수 Col
     * @return 없음
     * @author 김창식
     * @version 2009.07.06
	 */
	function sheet1_OnChange(sheetObj, Row, Col){
		var sheetObj = sheetObjects[0];
	 	var formObj = document.form;
	 	
	 	var agmtNoCol = sheetObj.SaveNameCol("agmt_no");
	 	var invRefNoCol = sheetObj.SaveNameCol("inv_ref_no");
	 	
	 	// Column 이 NIS Agreement No 일 경우 실행
	 	if (Col == agmtNoCol && Row !=0) {
	 		
	 		var cellValue = sheetObj.cellValue(Row, Col); 
	 		
	 		if (cellValue != ''){
	 			
	 			var agmtSeq = "000000" + cellValue.substring(3);
	 			cellValue = cellValue.substring(0, 3) + agmtSeq.substring(agmtSeq.length - 6);
	 			
	 			// 문자의 길이가 9가 아니거나 마지막 6자리가 숫자가 아닐경우
	 			if(cellValue.length != 9 || !ComIsNumber(cellValue.substring(3))){

		 			// 체크 메시지 출력
	 				ComShowCodeMessage('CGM10004','Agreement No.');
		 			
	 				// 해당 Cell 값을 Null로 설정
		 			sheetObj.cellValue2(Row, "agmt_no") = "";
		 			sheetObj.cellValue2(Row, "vndr_seq") = "";
		 			sheetObj.cellValue2(Row, "vndr_lgl_eng_nm") = "";
		 			
		 			// 그리드에 포커스 이동
		 			sheetObj.focus();
	 				sheetObj.SelectCell(Row, "agmt_no", true);
		 						
	 			} else {
	 				// Form parameter 에 값 세팅
	 				formObj.agmt_ofc_cty_cd.value = cellValue.substring(0,3);
	 				formObj.agmt_seq.value = cellValue.substring(3);
	 				
	 				// Agreement No 를 DB 에서 조회
	 				formObj.f_cmd.value = SEARCH01;
	 				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			        var sXml = sheetObj.GetSearchXml("EES_CGM_2086GS.do", FormQueryString(formObj), '', true);
			        var amgtCnt = ComGetEtcData(sXml,"AgmtCnt");
			        var vndrSeq = ComGetEtcData(sXml,"vndrSeq");
			        var vndrLglEngNm = ComGetEtcData(sXml,"vndrLglEngNm");
			        
	 				// DB에 Agreement No 가 존재하지 않을 경우
			        if (amgtCnt == 0){
	 					
			        	// 체크 메시지 출력   	
			        	ComShowCodeMessage('CGM10004','Agreement No.');
			        	
			        	// 해당 Cell 값을 Null로 설정
			 			sheetObj.cellValue2(Row, "agmt_no") = "";
			 			sheetObj.cellValue2(Row, "vndr_seq") = "";
			 			sheetObj.cellValue2(Row, "vndr_lgl_eng_nm") = "";
			 			
			 			// 그리드에 포커스 이동
			 			sheetObj.focus();
			 			sheetObj.SelectCell(Row, "agmt_no", true);
		 				
	 				} else {
	 					sheetObj.cellValue2(Row, "agmt_no") = cellValue;
	 					sheetObj.cellValue2(Row, "vndr_seq") = vndrSeq;
	 					sheetObj.cellValue2(Row, "vndr_lgl_eng_nm") = vndrLglEngNm;
	 				}
	 			}
	 		} else {
	 			sheetObj.cellValue2(Row, "agmt_no") = '';
	 			sheetObj.cellValue2(Row, "vndr_seq") = '';
	 			sheetObj.cellValue2(Row, "vndr_lgl_eng_nm") = '';
	 		}
	 	}
	 	
	 	// Column 이 Reference  No 일 경우 실행
	 	if (Col == invRefNoCol && Row !=0) {
	 		var CellValue = sheetObj.cellValue(Row, Col);
	 		
	 		var Row2 = sheetObj.FindText(Col, CellValue, -1);
	 		
	 		if(Row2 > 0){
	 			
	 	        Row2 = sheetObj.FindText(Col, CellValue, Row2+1);
	 	       
	 	        if (Row2 > 0) {
	 	        	ComShowCodeMessage('CGM10017','Reference No.');
	 				// 해당 Cell 값을 Null로 설정
	 				sheetObj.cellValue2(Row, Col) = '';
	 				// 그리드에 포커스 이동
	 				sheetObj.focus();
	 				sheetObj.SelectCell(Row, Col, true);
	 			}
	 		}
	 	}
	}
	
	/* 개발자 작업  끝 */