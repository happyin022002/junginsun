/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4106.jsp
*@FileTitle : Invoice Cancel Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.12 김태균
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
     * @class EES_DMT_4002 : EES_DMT_4002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4106() {
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

	var comboObjects = new Array();
	var comboCnt = 0;

	var ROWMARK = "|";
	var FIELDMARK = "=";
	var IBCANCEL = 51;

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
            		doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        var formObject = document.form;
        
        doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 182;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);


                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle  = " |SEQ|Sel.|Invoice Cancel Reason|INTG_CD_VAL_CTNT";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,				KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,   false,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,				35,		daCenter,	false,		"SEQ");
					InitDataProperty(0, cnt++ , dtRadioCheck,		35,		daCenter,	false,		"radioCheckBox",		false,		"",			dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				180,	daLeft,		false,		"intg_cd_val_dp_desc",	false,		"",			dfNone,		0,			false,		true);	
					InitDataProperty(0, cnt++ , dtHidden,			35,		daCenter,	false,		"intg_cd_val_ctnt",		false,		"",			dfNone,		0,			true,		true);

					CountPosition = 0;

                }
                break;

        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:      //조회
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.

				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);

					if (validateForm(sheetObj,formObj,sAction)) {
						
	                    //ComOpenWait Start
	                    sheetObj.WaitImageVisible=false;
	                    ComOpenWait(true);

	                    sheetObj.DoSearch("EES_DMT_4106GS.do", FormQueryString(formObj));
						
	                    //ComOpenWait End
	                    ComOpenWait(false);
	                    
					}
				}
				break;
				
			case IBSAVE:
				
				var isMultiCancel = ComGetObjValue(formObj.multi) == 'Y';
				ComSetObjValue(formObj.f_cmd, MULTI);
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				// 다중 캔슬일 경우 직접 부모시트의 선택 Row를 읽어온다
				if(isMultiCancel){					
					//ComOpenWait Start
	                sheetObj.WaitImageVisible=false;
	                ComOpenWait(true);
	                
					var opener = window.dialogArguments;
					var opnSheetObj = opener.document.form.sheet1;
					var checkedRows = opnSheetObj.FindCheckedRow("chk").split("|");
					var successRows = [];
					for(var i=0; i < checkedRows.length - 1; i++) {
						// 이후 개별 캔슬 저장 로직과 동일
						var cre_ofc_cd = opnSheetObj.CellValue(checkedRows[i], 'cre_ofc_cd');
		        		var dmdt_inv_no = opnSheetObj.CellValue(checkedRows[i], 'dmdt_inv_no');
		        		var dmdt_trf_cd = opnSheetObj.CellValue(checkedRows[i], 'dmdt_trf_cd');
		        		ComSetObjValue(formObj.cre_ofc_cd, cre_ofc_cd);
		        		ComSetObjValue(formObj.dmdt_inv_no, dmdt_inv_no);
		        		ComSetObjValue(formObj.dmdt_trf_cd, dmdt_trf_cd);
		        		
		        		var sParam1 = sheetObjects[0].GetSaveString(false);
						var sParam = sParam1+"&"+FormQueryString(formObj);
						
						var sXml = sheetObj.GetSaveXml("EES_DMT_4106GS.do", sParam );
						sheetObj.LoadSaveXml(sXml);
						
//						ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
						if (ComGetEtcData(sXml, "SUCCESS_YN") == 'Y') {
							successRows.push(checkedRows[i]);
						}
					}
					//ComOpenWait End
	                ComOpenWait(false);
					//성공시 팝업창을 닫는다
					if(successRows.length != 0){
						window.returnValue = successRows.toString();
						window.close();
					}
				} else {
					var sParam1 = sheetObjects[0].GetSaveString(false);
					var sParam = sParam1+"&"+FormQueryString(formObj);
					
	                //ComOpenWait Start
	                sheetObj.WaitImageVisible=false;
	                ComOpenWait(true);

					var sXml = sheetObj.GetSaveXml("EES_DMT_4106GS.do", sParam );
					sheetObj.LoadSaveXml(sXml);

	                //ComOpenWait End
	                ComOpenWait(false);
	                
					ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
					
					//성공시 팝업창을 닫는다
					if(ComGetObjValue(formObj.success_yn) == "Y"){
						window.returnValue="Y";
						window.close();
					}
				}				
				break;		
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSAVE:
					//선택한 사유가 미존재시
					if(sheetObj.CheckedRows("radioCheckBox") == 0) {
             			ComShowCodeMessage('DMT00173');
             			return false;
             		}
					//선택한 사유가 Other(s)일 경우 Remark미입력시
					var chkRows = sheetObj.FindCheckedRow("radioCheckBox").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var cancel_code = sheetObj.CellValue(chkRows[i], "intg_cd_val_ctnt");
         				if(cancel_code == 'OTH') {
         					if(ComGetObjValue(formObj.cxl_rmk) == "") {
         						ComShowCodeMessage('DMT01038');
             					return false;
         					}
         				}
             		}
				break;
        	}
        }

        return true;
    }
    
    /*
     * 저장 후 메시지 처리함
     */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		
		if(ErrMsg != "") {
			ComShowCodeMessage(ErrMsg);
		}
	}

