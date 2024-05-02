/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : programmanagement.js
*@FileTitle : Program Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.17
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.17 김경범
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
     * @class Program Management : Program Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ProgramManagement() {
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
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_Add":
            		doActionIBSheet(sheetObject1,formObject,IBINSERT);
            		break;
            		
            	case "btn_Retrieve":
            		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            		break;

            	case "btn_Save":
            		doActionIBSheet(sheetObject1,formObject,IBSAVE);
            		break;

            	case "btn_Copy":
            		ComOpenWindowCenter('ADM_SYS_0010.do?MENU=Y', '', 640, 460);
            		break;

            	case "btn_DownExcel":
            		doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
			//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH)
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
    	        case "s_pgm_no":
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
                    style.height = 322;
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
                    var HeadTitle1 = "|Del|Pgm No|Pgm Name|Description|Link Name|Role|Office|Job|Div.|Type|Developer|Devel Date|Popup|Usage|Use Flag";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 		COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");	
					InitDataProperty(0, cnt++ , dtDelCheck,			30,		daCenter,		true,		"DEL",				false,		"",      	dfNone,		0,			true,		true);
  					InitDataProperty(0, cnt++ , dtData,             100,  	daCenter,  		false,    	"pgm_no",     		true,       "",      	dfNone,     0,     		false,      true);
  					InitDataProperty(0, cnt++ , dtData,            	200,  	daLeft,    		false,    	"pgm_nm",     		true,       "",       	dfNone,  	0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtData,            	200,  	daLeft,    		false,    	"pgm_desc",     	false,      "",       	dfNone,    	0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtData,            	150,  	daLeft,    		false,    	"pgm_url",     		false,      "",       	dfNone,    	0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtPopup,            40,  	daCenter,  		false,    	"roles",          	false,      "",       	dfNone,     0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtPopup,            40,  	daCenter,  		false,    	"ofcs",          	false,      "",       	dfNone,     0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtPopup,            40,  	daCenter,  		false,    	"jobs",          	false,      "",       	dfNone,     0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtCombo,            50,  	daCenter,  		false,    	"pgm_mnu_div_cd", 	false,      "",       	dfNone,  	0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtCombo,            50,  	daCenter,  		false,    	"pgm_tp_cd",     	false,      "",       	dfNone,  	0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtData,             70,  	daCenter,  		false,    	"dev_nm",     		false,      "",       	dfNone,     0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtPopupEditFormat,  80,  	daCenter,  		false,    	"dev_dt",     		false,      "",       	dfDateYmd,  0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtCombo,            50,  	daCenter,  		false,    	"popup_flg",     	false,      "",       	dfNone,    	0,     		true,       true);
  					InitDataProperty(0, cnt++ , dtData,             50,  	daCenter,  		false,    	"use_flg",     		false,      "",       	dfNone,    	0,     		false,      false);
  					InitDataProperty(0, cnt++ , dtData,             50,  	daCenter,  		false,    	"pgm_use_flg",     	false,      "",       	dfNone,    	0,     		true,      	true);

                    InitDataCombo (0, "pgm_mnu_div_cd", "Program|Menu", "02|01","02");
                    InitDataCombo (0, "pgm_tp_cd", "Online|Report|Batch", "00|01|02","00");
                    InitDataCombo (0, "popup_flg", "Y|N", "Y|N","N");
                    //InitDataCombo (0, "use_flg", "사용|미사용", "Y|N","Y");

					CountPosition = 0;
					ImageList(0) = "/hanjin/img/btns_calendar.gif";
					ImageList(1) = "/hanjin/img/btns_search.gif";
                    PopupButtonImage(0,"dev_dt") = 0;
                    PopupButtonImage(0,"roles") = 1;
                    ShowButtonImage = 2;
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
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction))return;
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ProgramManagementGS.do", FormQueryString(formObj));
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
                //저장처리
            	formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ProgramManagementGS.do", FormQueryString(formObj));
				break;

			case IBINSERT:      // 입력
				row = sheetObj.DataInsert(-1);
				break;

			case IBDOWNEXCEL:	//엑셀다운로드
				sheetObj.SpeedDown2Excel(1);
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
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
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
       		case "dev_dt" :
       			var cal = new ComCalendarGrid();
       			cal.select(sheetObj, Row, Col, 'yyyyMMdd');
       			break;
       		
       		case "roles" :
       			if(sheetObj.CellValue(Row,"ibflag")=="I" || sheetObj.CellValue(Row,"ibflag")=="U"){
       				ComShowCodeMessage('COM12151','프로그램');
       			}else if(sheetObj.CellValue(Row,"ibflag")=="R" && sheetObj.CellValue(Row,"pgm_mnu_div_cd")=="01"){
       				ComShowMessage('메뉴 항목은 역할을 지정할 수 없습니다.');
       			}else{
       				var url = '/hanjin/progRoleMapping.do?pgm_no='+sheetObj.CellValue(Row,"pgm_no")+"&pgm_nm="+escape(sheetObj.CellValue(Row,"pgm_nm"));
       				ComOpenPopup(url,700,474, '','1,0',true,false,Row,Col,0);
//    		     ComOpenPopup('/hanjin/programMapping.do?role_cd='+sheetObj.CellValue(Row,prefix + "usr_role_cd")+"&role_nm="+escape(sheetObj.CellValue(Row,prefix + "usr_role_nm")), 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
       			}
       			break;
       			
       		case "ofcs" :
       			if(sheetObj.CellValue(Row,"ibflag")=="I" || sheetObj.CellValue(Row,"ibflag")=="U"){
       				ComShowCodeMessage('COM12151','프로그램');
       			}else if(sheetObj.CellValue(Row,"ibflag")=="R" && sheetObj.CellValue(Row,"pgm_mnu_div_cd")=="01"){
       				ComShowMessage('메뉴 항목은 역할을 지정할 수 없습니다.');
       			}else{
       				var param = "pgm_no=" + sheetObj.CellValue(Row,"pgm_no") + "&pgm_nm=" + sheetObj.CellValue(Row,"pgm_nm");
       				ComOpenPopup('/hanjin/Office_Management.do?' + param, 700, 650, 'setPrntUsrRoleCd', '0,0', false, false, Row, Col, 0);
       			}
       			
       			break;
       			
       		case "jobs" :
       			if(sheetObj.CellValue(Row,"ibflag")=="I" || sheetObj.CellValue(Row,"ibflag")=="U"){
       				ComShowCodeMessage('COM12151','프로그램');
       			}else if(sheetObj.CellValue(Row,"ibflag")=="R" && sheetObj.CellValue(Row,"pgm_mnu_div_cd")=="01"){
       				ComShowMessage('메뉴 항목은 역할을 지정할 수 없습니다.');
       			}else{
       				var param = 'pgm_no='+sheetObj.CellValue(Row,"pgm_no")+"&pgm_nm="+escape(sheetObj.CellValue(Row,"pgm_nm"));
       				ComOpenPopup('/hanjin/ADM_SYS_0023.do?' + param, 700, 445, "setPopupData", "0,0", true, false, Row, Col, 0);
       			}
       			
       			break;
        }
	}
     
    
    function sheet1_OnSearchEnd(sheetObj){
    	
    	/*
    	 
    	 sheetObj.ReDraw = false;
    	for(var int = 1; int < sheetObj.RowCount; int++) 
		{
    		if(sheetObj.CellValue(int, "pgm_mnu_div_cd") == "02")//프로그램일 경우 수정불가
    		{
    			sheetObj.CellEditable(int,"pgm_nm") = false;
    		}
    	
		}
    	//
    	sheetObj.CellValue2(0, "level") = "Level (-)";
    sheetObj.ReDraw = true;
    */
    }
    
    function sheet1_OnChange(sheetObj,Row,Col){
    	
  if(Col==2){//프로그램번호
	  var pgmno = sheetObj.CellValue(Row, 2);// 변경된 pgm_no 
  		sheetObj.CellValue(Row, 5) = "/hanjin/"+pgmno+".do";
  }
      	 if(Col == 3 || Col == 8){//프로그램명 or 구분코드
      	 	//alert(1);
      		 var pgmnm = sheetObj.CellValue(Row, 3);// 변경된 컬럼
      	
      		
      		 var div = sheetObj.CellValue(Row, 8);// 01:Menu 02:Program
      		
      		 if(div == '02' && sheetObj.CellValue(Row,"ibflag") == "I")//등록구분이 프로그램이고 신규등록이다
      		 {
      			 for(var int = 1; int < sheetObj.RowCount; int++) 
      			 {
      				 //if(int != Row)
      				 //{
      					 var or_pgmnm = sheetObj.CellValue(int, 3);
      				// }
      				 if(or_pgmnm == pgmnm)
      				 {
      					 ComShowMessage("동일한 Program Nm이 존재합니다.");
      					 
      					 if(Col == 3)
       					 {
      						 sheetObj.CellValue(Row, Col) = "";
       					 }
      					 else if(Col == 8)
       					 {
      						 sheetObj.CellValue(Row,Col) = "01"//menu
      						 sheetObj.CellValue(Row, 3) = "";

       					 }
      					 return;
       				 
      				 }
       			}//end for
      			 
      	     }
      		
      	 }// end if(Col == 3 || Col == 8)
      	 
      	
       }
    
    
    
    
	function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
		//doActionIBSheet(sheetObject[0],formObject,IBSEARCH);
	}

	/* 개발자 작업  끝 */