/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : scheduleLog.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2008.12.29
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2008.12.29 김경범
* 1.0 최초 생성
=========================================================*/
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
		         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

							case "btn_Retrieve":
									doActionIBSheet(sheetObject1,formObject,IBSEARCH);
									break;

							case "btn_DirectExcute":
								doActionIBSheet(sheetObject1,formObject,IBSAVE);
									break;

							case "btn_LogDownload":
								document.log_ifr.downloadFile();
									break;

							case "btn_DownExcel":
								sheetObject1.Down2Excel();
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
				ComConfigSheet (sheetObjects[i]);

				initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			initControl();
		}
    
    function initControl() {
      	var formObject = document.form;
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }
      
      //업무 자바스크립트 OnKeyPress 이벤트 처리
      function keypressFormat() {
      	obj = event.srcElement;
    	    if(obj.dataformat == null) return;
    	    window.defaultStatus = obj.dataformat;
    	    switch(obj.name) {
	        case "pgm_no":
	        	ComKeyOnlyAlphabet('uppernum',"95");
	            break;
	        case "skd_id":
	        	ComKeyOnlyNumber(obj);
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
				var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 202;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|Log ID|Job ID|Job Type|Program No.|Out Log|Error Log|Status|Start Time|End Time|Elapsed Time|||";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,		true,			"log_id",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,			"skd_id",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,	daCenter,		true,			"skd_tp_cd",		false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,		true,			"pgm_no",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtPopup,		80,	daCenter,			true,			"out",		false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopup,		80,	daCenter,			true,			"err",		false,			"",      dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		90,		daCenter,		true,			"sts_cd",					false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		true,			"st_tm",			false,			"",      dfUserFormat2,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		true,			"end_tm",				false,			"",      dfUserFormat2,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,			"elapsed_time",				false,			"",      dfTimeHm,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,		true,			"std_out_file",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,		true,			"std_err_file",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,		true,			"machine",			false,			"",      dfNone,				0,		false,		false);

					InitDataCombo(0, "skd_tp_cd", "Direct|Reserved|Scheduled", "D|R|S");
					InitDataCombo(0, "sts_cd", "RUNNING|STARTING|SUCCESS|FAILURE|TERMINATED|ON_ICE|INACTIVE|ACTIVATED|RESTART|ON_HOLD|QUE_WAIT", "1|3|4|5|6|7|8|9|10|11|12");

					InitUserFormat2(0, "st_tm", "####-##-## ##:##:##", "-|:" );
					InitUserFormat2(0, "end_tm", "####-##-## ##:##:##", "-|:" );

					CountPosition = 0;

					PopupImage = "/hanjin/img/btns_inquiry.gif";
                    ShowButtonImage = 2;
			}
            break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction))
					if (sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						//alert(FormQueryString(formObj));
						sheetObj.DoSearch("BatchScheduleLogGS.do", FormQueryString(formObj));
					}
			break;

        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
	    		with(formObj){
	                if (formObj.pgm_no.value == "" && formObj.skd_id.value == "") {
	                	alert('Input Job ID or Progarm No.'); 
	                    formObj.pgm_no.focus();
	                   return false;
	                }
	    		}
	    		break;
        }
        return true;
    }
   
      /**
     * Program Name Data List OpenWindow. <br>
     * @param {int}	Row	행번호
     * @param {int}	Col	컬럼번호
     **/
     function sheet1_OnPopupClick(sheetObj,Row,Col){
         switch (sheetObj.ColSaveName(Col)) {
         case "out" :
 	   		getFileContents(sheetObj.CellValue(Row, "machine"),sheetObj.CellValue(Row, "std_out_file"));
 	   		break;
 	   	case "err" :
 	   		getFileContents(sheetObj.CellValue(Row, "machine"),sheetObj.CellValue(Row, "std_err_file"));
 	   		break;
 	   	}
     }
    
    function getFileContents(machine, filepath){
        var frm = document.form;
        var url = '';
        if ( machine == 'ktx6600b' ) url = 'http://203.246.130.159:7310';
        else if ( machine == 'kox6600b' ) url = 'http://203.246.130.137:7310';
        else if ( machine == 'kox6600c' ) url = 'http://203.246.130.138:7310';
        else if ( machine == 'kox6600d' ) url = 'http://203.246.130.139:7310';
        else if ( machine == 'kox6600e' ) url = 'http://203.246.130.145:7310';
        else if ( machine == 'kos5220f' ) url = 'http://203.246.130.154:7310';
        else url = '';
        frm.target = "log_ifr";
        frm.filepath.value=filepath;
        frm.action = url+"/hanjin/syscommon/management/alps/schedule/jsp/fileview.jsp";
        frm.submit();
    }
