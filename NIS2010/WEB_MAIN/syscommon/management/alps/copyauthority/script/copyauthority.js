/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : menumanagement.js
*@FileTitle : Menu Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.04
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.03.04 김경범
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
     * @class Menu Management : Menu Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function menumanagement() {
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
	    	    case "btng_rowadd":
		            doActionIBSheet(sheetObject2,formObject,IBINSERT);
	    	        break;

            	case "btn_New":
            		sheetObject1.CellValue2(1,0)="";
            		sheetObject1.CellValue2(1,1)="";
            		sheetObject1.CellValue2(1,2)="";
            		sheetObject1.CellValue2(1,3)="";
            		sheetObject1.CellValue2(1,4)="";
            		sheetObject1.CellValue2(1,5)="";
            		sheetObject1.CellValue2(1,6)="";
            		sheetObject2.RemoveAll();
            		formObject.opt[0].checked = true;
            		formObject.RAP.checked = false;
            		formObject.SUR.checked = false;
            		formObject.OC.checked = false;
            		sheetObject2.DataInsert(-1);
            		break;

            	case "btn_Save":
            		doActionIBSheet(sheetObject2,formObject,IBSAVE);
            		break;

            	case "btn_Close":
            		self.close();
            		break;

            	case "btn_DownExcel":
            		doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
            		sheetObject2.SpeedDown2Excel(0);
            		sheetObject3.SpeedDown2Excel(-1, true, true);
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
     * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
     * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
     * @param {ibsheet} sheet_obj    IBSheet Object
     **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
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
   	            
     	    }
       }
    /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 46;
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
                var HeadTitle = "ID|Name|RHQ|Office|Use Flag|Auth Type|ID DIV" ;
				var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                
                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,   "usr_id",           true,        "",     dfNone,           0,    true,       true);
                InitDataProperty(0, cnt++ , dtData,     100,    daLeft,    false,   "usr_nm",           false,        "",     dfNone,           0,    false,        false);
                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,   "rhq",           false,        "",     dfNone,           0,    false,        false);
                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,   "ofc_cd",           false,        "",     dfNone,           0,    false,        false);
                InitDataProperty(0, cnt++ , dtCombo,    80,  daCenter,  false,   "use_flg",    false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,    80,  daCenter,  false,   "usr_auth_tp_cd",     false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,    80,  daCenter,    false,   "div",     false,        "",     dfNone,       0,        false,       false);

                InitDataCombo (0, "usr_auth_tp_cd", " |Almighty|Super User|Regular|System Admin", " |A|S|R|E"," ");
                InitDataCombo (0, "use_flg", " |Yes|No", " |Y|N"," ");
                InitDataCombo (0, "div", " |LID|GID", " |L|G"," ");

                CountPosition = 0;
                WaitImageVisible = false;
                DataInsert(-1);

            }
            break;

        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 200;
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
                var HeadTitle = "|Del|ID|Name|RHQ|Office|Use Flag|Auth Type|ID DIV" ;
				var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                
                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");	
				InitDataProperty(0, cnt++ , dtDelCheck,		30,		daCenter,		true,		"DEL",			false,			"",      dfNone,		0,		true,		true);
                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,   "usr_id",           true,        "",     dfNone,           0,    false,       true);
                InitDataProperty(0, cnt++ , dtData,     100,    daLeft,    false,   "usr_nm",           false,        "",     dfNone,           0,    false,        false);
                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,   "rhq",           false,        "",     dfNone,           0,    false,        false);
                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,   "ofc_cd",           false,        "",     dfNone,           0,    false,        false);
                InitDataProperty(0, cnt++ , dtCombo,    80,  daCenter,  false,   "use_flg",    false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,    80,  daCenter,  false,   "usr_auth_tp_cd",     false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,    80,  daCenter,    false,   "div",     false,        "",     dfNone,       0,        false,       false);
                
                InitDataCombo (0, "usr_auth_tp_cd", " |Almighty|Super User|Regular|System Admin", " |A|S|R|E"," ");
                InitDataCombo (0, "use_flg", " |Yes|No", " |Y|N"," ");
                InitDataCombo (0, "div", " |LID|GID", " |L|G"," ");

                CountPosition = 0;
                WaitImageVisible = false;
                DataInsert(-1);
            }
            break;

        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
            	formObj.f_cmd.value = MULTI;
                //저장처리
                var formparam = FormQueryString(formObj);
                var usrIDs = "";
                for(var i=1; i<sheetObj.rowCount+1; i++) {
                	usrIDs += sheetObj.CellValue(i, 2) + "@";
                }
                //alert(formparam + "&from_usr_id=" + sheetObjects[0].CellValue(1, "usr_id") + "&to_usr_id=" + usrIDs);
                sheetObjects[1].DoSave("ADM_SYS_0010GS.do", formparam + "&from_usr_id=" + sheetObjects[0].CellValue(1, "usr_id") + "&to_usr_id=" + usrIDs, -1, false);
                alert('Data was saved successfully !');
				break;

			case IBINSERT:      // 입력
				for (var i=0;i<formObj.addrows.value;i++) sheetObj.DataInsert();
				break;
				
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (!formObj.RAP.checked&&!formObj.SUR.checked&&!formObj.OC.checked) {
            	alert('select function !');
                return false;
            }
            if (sheetObjects[0].CellValue(1,"usr_nm")=="") {
            	alert('input from user !');
            	return false;
            }
            if (sheetObj.rowCount==0) {
            	alert('empty to user !');
            	return false;
            }
            for(var i=1; i<sheetObj.rowCount+1; i++) {
            	//alert(sheetObj.CellValue(i,"usr_nm"));
            	if (sheetObj.CellValue(i,"usr_nm")=="") {
            		alert('input to user !');
            		return false;
            	}
            	if (sheetObj.CellValue(i,"usr_auth_tp_cd")!="S"&&formObj.SUR.checked) {
            		alert('there is a user who is not Super User authority !');
            		formObj.SUR.checked = false;
            		return false;
            	}
            }
        }
        return true;
    }
    
    function sheet1_OnChange(sheetObj,Row,Col) {
    	sheetOnChange(sheetObj,Row,Col);
    }
    
    function sheet2_OnChange(sheetObj,Row,Col) {
    	if (sheetObj.ColSaveName(Col)!="DEL") sheetOnChange(sheetObj,Row,Col);
    }
    
    function sheetOnChange(sheetObj,Row,Col) {
    	var formObject = document.form;
		formObject.f_cmd.value = SEARCH05;
		var sXml = sheetObj.GetSearchXml("UserManagementGS.do?usr_id="+sheetObj.CellValue(Row,Col), FormQueryString(formObject));
		if(ComGetEtcData(sXml,"total") != "0"){
			sheetObj.CellValue2(Row, "usr_nm") = ComGetEtcData(sXml,"usr_nm");
			sheetObj.CellValue2(Row, "rhq") = ComGetEtcData(sXml,"rhq");
			sheetObj.CellValue2(Row, "ofc_cd") = ComGetEtcData(sXml,"ofc_cd");
			sheetObj.CellValue2(Row, "use_flg") = ComGetEtcData(sXml,"use_flg");
			sheetObj.CellValue2(Row, "usr_auth_tp_cd") = ComGetEtcData(sXml,"usr_auth_tp_cd");
			sheetObj.CellValue2(Row, "div") = ComGetEtcData(sXml,"div");
		} else {
			alert('no user !');
		}
    }
	/* 개발자 작업  끝 */