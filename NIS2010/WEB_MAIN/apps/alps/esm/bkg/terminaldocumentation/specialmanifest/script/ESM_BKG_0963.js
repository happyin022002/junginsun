/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0963.js
*@FileTitle : ESM_BKG_0963
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.27 경종윤
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
     * @class ESM_BKG_0963 : ESM_BKG_0963 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0963() {
    	this.processButtonClick		= processButtonClick;
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

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
					case "btn1_Select": // 조회
						doActionIBSheet(sheetObjects[0],document.form,COMMAND01); 
						break;
					case "btn1_Detail": // Bay-Plan Detail 팝업 오픈
						if(sheetObject.RowCount == 0 || sheetObject.SelectRow < 1) return false;
						
						var vayId = sheetObject.CellValue(sheetObject.SelectRow, "bay_pln_id");
						var openType = formObject.openType.value;
						var currMainPageListCnt = formObject.currMainPageListCnt.value;
						sUrl = "ESM_BKG_1091.do?"; // Bay plan Detail Setup 화면
						sParam = "bayId="+vayId+"&openType="+openType+"&currMainPageListCnt="+currMainPageListCnt;
						var rtnVal = ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0961", 740, 500, true);
						
						if(rtnVal != undefined && rtnVal.length > 0) {
							//alert("rtnVal.length : " + rtnVal.length)
							 var obj = new Object();
							 obj = rtnVal ; 
							 window.returnValue = obj;
							 self.close();
						}
						
						
						break;
					case "btn1_Close":
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
        


		
    }
    
 	/**
 	 * 화면 로딩 완료 후 이벤트
 	 * @param sheetObj
 	 * @return
 	 */
 	function sheet1_OnLoadFinish(sheetObj) {
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
 	 }   
    


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
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
                    Editable = true;
                    
                    //Edit 가능 불가능 색상 구분 기능 사용
                    //EditableColorDiff = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Seq.|Bay ID|Date|Vessel|T/VVD|FROM|TO|Sender";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	false,		"seq");     
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bay_pln_id",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"rcv_dt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"vsl",				false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"trnk_vvd_id",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"pol_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"pod_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"upd_usr_id",		false,		"",		dfNone,			0,		false,		false);
					
					// 건수 정보의 표시 위치를 확인하거나 설정한다.
					CountPosition = 2;
					
					//홀수번째 데이터 행의 기본 배경색을 확인하거나 설정한다
					//DataBackColor = RgbColor(192,192,192);

					WaitImageVisible=false;
					
			}
			break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //조회
        	  ComOpenWait(true);
        	  formObj.f_cmd.value = SEARCH;
        	  sheetObj.DoSearch("ESM_BKG_0963GS.do", FormQueryString(formObj));
        	  ComOpenWait(false);
        	  break;

          case COMMAND01:     //Select 버튼 
        	  if(!validateForm(sheetObj,formObj,sAction))return;
        	  sheet1_OnDblClick(sheetObj, sheetObj.SelectRow, sheetObj.SelectCol )
        	  break;
        	  
        }
        
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
			case COMMAND02 : // Select 버튼
				if(sheetObj.RowCount == 0) {
		    		ComShowCodeMessage('BKG00095');
		    		return false;
				}
				break;
    	}

        return true;
    }

    /**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	//ComShowMessage("데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event \n" + "Row : " + Row + "\n" + "Col : " + Col);
    	
    	if(document.form.openType.value == "2") return false;  // openType = "2" => 버튼을 눌러서 오픈된 것이므로 더블클릭 이벤트를 skip한다.

    	var obj = new Object(); 
		obj.cd = sheetObj.CellValue(Row, "bay_pln_id");
		window.returnValue = obj;
		self.close();
    }
    

    

	/* 개발자 작업  끝 */