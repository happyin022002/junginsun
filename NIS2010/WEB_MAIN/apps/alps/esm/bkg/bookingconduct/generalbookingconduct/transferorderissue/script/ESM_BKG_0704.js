/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0704.js
*@FileTitle : TRO-Multi
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation 
* --------------------------------------------------------
* History
* 2010.10.19 신자영 [CHM-201006495-01] TRO (KOR) Status 변경 (User ID 및 정렬 순서)
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
     * @class esm_bkg_0704 : esm_bkg_0704 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0704() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
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
        //var sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Close":
					self.close();
					break;
				
				case "btn_t2bRetrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1); 
            ComEndConfigSheet(sheetObjects[i]);            
        }
        
        //initParam();  //form 객체에 한번만
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
				with (sheetObj) {
                    // 높이 설정
                    style.height = 170;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					//2010.10.19 신자영 [CHM-201006495-01] Booking Staff -> User ID
					var HeadTitle = " ||Order No.|I/F Date|ACK|VVD CD|Processing Message|User ID||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);					
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);                   
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,			20,		daCenter,	false,		"Seq");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	false,		"ord_no",			false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"if_dt",			false,			"",      dfUserFormat2,         0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		    55,		daCenter,	true,		"ack_sts_cd",		false,			"",      dfNone,				0,		true,		true);  //dtCombo
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"vvd",				false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			230,	daLeft,		true,		"rqst_ord_msg",	    false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		"doc_usr_id",		false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,		"bkg_sts_cd",		false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,		"usr_nm",    		false,			"",      dfNone,				0,		true,		true);
					
					InitUserFormat2(0, "if_dt", "####-##-## ##:##", "-|:" );
				}
				break;
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          	case IBSEARCH:      //조회	              		     	
	          	formObj.f_cmd.value = SEARCH;
          	    sheetObj.DoSearch("ESM_BKG_0704GS.do", FormQueryString(formObj));
                break;
        }
	}
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	if (sheetObj.SearchRows>0) {
    		var t_bkg_sts_cd = sheetObj.CellValue(1, "bkg_sts_cd"); 
    		if (t_bkg_sts_cd != "") {
    			document.all.bkg_sts_cd.innerHTML = "("+t_bkg_sts_cd+")";	
    		}    		
    	}
    }

	// 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			var row = MouseRow;
			var col = MouseCol;
			
			var colname = ColSaveName(col);
			
			switch(colname){
				case "doc_usr_id":
					if (row > 0 && row <= sheetObj.SearchRows && "" != CellValue(row, col)){
						MouseToolTipText = CellValue(row, "usr_nm");
					} else { 
						MouseToolTipText = "";
					}
					break;
				default :
					MouseToolTipText = "";
			}
		}
	}

	/* 개발자 작업  끝 */