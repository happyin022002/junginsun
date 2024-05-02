/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ACCESSHISTORY.js
*@FileTitle : AccessHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.02.01 김경범
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
     * @class ACCESSHISTORY : ACCESSHISTORY 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ACCESSHISTORY() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
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

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_New":
				    formObject.usrId.value = "";
				    formObject.usrNm.value = "";
				    for(var i=0;i<formObject.subSys.GetCount();i++)
				    	formObject.subSys.CheckIndex(i) = false;
				    formObject.admin.value = "";
				    formObject.rhq.value = "";
				    formObject.ofcCd.value = "";
				    formObject.pgmNo.value = "";
				    formObject.pgmNm.value = "";
					break;

				case "btng_rowadd":
		            doActionIBSheet(sheetObject1,formObject,IBINSERT);
	    	        break;

				case "btn_DownExcel":
            		doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;

            	case "btn_Save":
            		doActionIBSheet(sheetObject1,formObject,IBSAVE);
            		break;

            	case "btn_ofc_cd":
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 700, 500, "ofc_cd:ofcCd", '0,0,1,1,1,1,1,1', true);
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

				initSheet(sheetObjects[i],i+1,false);
	        //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
			var tmp = subSysCd.substring(1,subSysCd.length-1).split(", ");
			with (document.form.subSys) {
				MultiSelect = true;
				MultiSeparator = ",";
				DropHeight = 140;
				for ( var i=0; i<tmp.length-1; i++) {
					InsertItem(i, tmp[i], tmp[i]);
				}
			}
		}
    
    function initControl() {
      	var formObject = document.form;
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)
   	  	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
   	  	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }

    function obj_deactivate(){
    	 ComChkObjValid(event.srcElement);
   }

   function obj_activate(){
    	 ComClearSeparator(event.srcElement);
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
		    case "dateFrom":
		        ComKeyOnlyNumber(obj, "-"); 
	            break;
		    case "dateTo":
		        ComKeyOnlyNumber(obj, "-"); 
	            break;
    	    }
      }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,flag) {
        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 360;
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

                    var HeadTitle1 = "|Del|User ID|User Name(KOR)|User Name(ENG)|RHQ|Office|Tel|Mail|Module|Pgm ID|Pgm Name|Admin|Create Date";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");	
					InitDataProperty(0, cnt++ , dtDelCheck,		30,		daCenter,		true,		"DEL",				false,		"",      	dfNone,		0,			true,		true);
  					InitDataProperty(0, cnt++ , dtData,			60,  	daCenter,  		false,    	"usr_id",     		false,		"",      	dfNone,     0,     		false,		true);
  					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,    		false,    	"usr_locl_nm",  	false,		"",       	dfNone,  	0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,    		false,    	"usr_nm",    	 	false,      "",       	dfNone,    	0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,  		false,    	"rhq",	     		false,      "",       	dfNone,    	0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtData,			55,  	daCenter,  		false,    	"ofc_cd",          	false,      "",       	dfNone,     0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtData,			100,  	daLeft,  		false,    	"xtn_phn_no",      	false,      "",       	dfNone,     0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtData,			100,  	daCenter,  		false,    	"usr_eml",	     	false,      "",       	dfNone,  	0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtCombo,		50,  	daCenter,  		false,    	"module",     		false,      "",       	dfNone,     0,     		false,		true);
  					InitDataProperty(0, cnt++ , dtData,			90,  	daCenter,  		false,    	"pgm_no",     		false,      "",       	dfNone,  	0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtData,			100,  	daLeft,  		false,    	"pgm_nm",	     	false,      "",       	dfNone,    	0,     		false,		false);
  					InitDataProperty(0, cnt++ , dtCombo,		50,  	daCenter,  		false,    	"admin",     		false,      "",       	dfNone,    	0,     		flag,		true);
                    InitDataProperty(0, cnt++ , dtData,         100,	daCenter,		false,		"cre_dt",			false,		"",			dfDateYmd,	0,			false,		false);

  					var tmp = subSysCd.substring(1,subSysCd.length-1).split(", ");
  					InitDataCombo (0, "module", tmp.join("|"), tmp.join("|"), "");
  					InitDataCombo (0, "admin", "Yes|No", "Y|N", "N");
			}
            break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
			    	ComOpenWait(true);
			        sheetObj.WaitImageVisible = false;
			    	var summary = (formObj.opt[0].checked)?true:false;
			    	sheetObj.removeAll();
			    	initSheet(sheetObj,1,summary);
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ADM_SYS_0009GS.do", FormQueryString(formObj));
					if (sXml != "") sheetObj.LoadSearchXml(sXml);
			    	ComOpenWait(false);
				}
				break;
			
			case IBDOWNEXCEL:		// Excel download
				sheetObj.Down2Excel();
				break;

			case IBINSERT:      // 입력
				for (var i=0;i<formObj.addrows.value;i++) sheetObj.DataInsert();
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
                //저장처리
            	formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ADM_SYS_0009GS.do", FormQueryString(formObj));
				break;
        }
    }
    
    function sheet1_OnChange(sheetObj,Row,Col) {
    	var formObject = document.form;
    	
    	if(Col==12){
    		var userid = sheetObj.CellValue(Row, "usr_id");
    		for(var i=1; i<sheetObj.rowCount+1; i++) {
    			if(userid == sheetObj.CellValue(i,"usr_id") ){
    				sheetObj.CellValue(i,"admin") = sheetObj.CellValue(Row,"admin");
    			}
            }

    	}
    	
    	if(Col!=2) return;
		formObject.f_cmd.value = SEARCH05;
		var sXml = sheetObj.GetSearchXml("UserManagementGS.do?usr_id="+sheetObj.CellValue(Row,Col), FormQueryString(formObject));
		if(ComGetEtcData(sXml,"total") != "0"){
			sheetObj.CellValue2(Row, "usr_nm") = ComGetEtcData(sXml,"usr_nm");
			sheetObj.CellValue2(Row, "rhq") = ComGetEtcData(sXml,"rhq");
			sheetObj.CellValue2(Row, "ofc_cd") = ComGetEtcData(sXml,"ofc_cd");
			sheetObj.CellValue2(Row, "usr_eml") = ComGetEtcData(sXml,"usr_eml");
			sheetObj.CellValue2(Row, "usr_locl_nm") = ComGetEtcData(sXml,"usr_locl_nm");
			sheetObj.CellValue2(Row, "xtn_phn_no") = ComGetEtcData(sXml,"xtn_phn_no");
		} else {
			alert('no user !');
		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            for(var i=1; i<sheetObj.rowCount+1; i++) {
            	//alert(sheetObj.CellValue(i,"usr_nm"));
            	if (sheetObj.CellValue(i,"usr_nm")=="") {
            		alert('input user id !');
            		return false;
            	}
            }
        }
        return true;
    }
	/* 개발자 작업  끝 */