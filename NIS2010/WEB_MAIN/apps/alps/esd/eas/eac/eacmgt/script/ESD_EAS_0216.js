/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0216.js
*@FileTitle : EAC Reject
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.03 백형인
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
     * @class ESD_EAS_0216 : ESD_EAS_0216 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0216() {
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

    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;    
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/	
		var sheetObject = sheetObjects[0]; 
		/*******************************************************/
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btng_close":
					doActionIBSheet(sheetObject,frm,"btng_close");
				break;
				

                case "btng_reject":
                	doActionIBSheet(sheetObject,frm,"btng_reject");
                	break;
                	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TRS90404');
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
						    Editable = false;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(2, 1, 10, 100);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(4, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, true, true, false,false) ;

							var HeadTitle1 = "|SEQ.|EAC No.|RHQ";
							
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);

							HeadRowHeight = 12;
							//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
							InitDataProperty(0, cnt++ , dtSeq,          50,  	daCenter,   true,   "seq");
							InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "eac_no",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
							InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "rhq_ofc_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
								
						}
						break;
					}
				}
		 
			//SHEET 관련 프로세스 처리
			function doActionIBSheet(sheetObj, frm, sAction) {
				sheetObj.ShowDebugMsg = false;
				var frm = document.form;
				
				switch (sAction) {
					// SEARCH LOGIC
					case "btng_close":
							window.close();
					break;
					case "btng_reject":
		  				frm.f_cmd.value = MODIFY01;
                        frm.ibflag.value="U"; // 폼이 마치 그리드 데이터인척 하는 방법중하나.
						var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		  				var sXml = sheetObj.GetSaveXml("ESD_EAS_0201GS.do", sParam);
		  				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		  				var ErrMsg = EacGetMsgData(sXml);
		  				if (State != "S") {
		  					if (ErrMsg.length > 0) {
		  						ComShowCodeMessage("EAS99999", ErrMsg);
		  					}else{
		  						ComShowCodeMessage("EAS90081"); // confirm Fail
		  					}
		  					ComOpenWait(false);
		  					return false;
		  				} else if (State == "S") {
		  					ComShowCodeMessage("EAS90082")//EAC has been reject
		  					if(opener != null) {
		  						// 일반 팝업인 경우
		  						opener.callBackReject("Y");
		  					} else {
		  						// Modal 팝업인 경우
		  						window.dialogArguments.callBackReject("Y");
		  					}
		  					window.close();
//		  					doActionIBSheet(sheetObjects[0],frm,'btn_retrieve');
		  				}
						break;
  				
				}
			}	 
	 
	 
	 

	/* 개발자 작업  끝 */