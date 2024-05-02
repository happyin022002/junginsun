/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : usermanagement.js
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.19 김경범
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
     * @class User Management : User Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function usermanagement() {
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

				case "btn_ofc_cd":
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 700, 500, "ofc_cd:s_ofc_cd", '0,0,1,1,1,1,1,1', true);
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
    function loadPage(flag) {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1,flag);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		if ( flag ) doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     	        case "s_ofc_cd":
     	        	ComKeyOnlyAlphabet('uppernum');
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
    function initSheet(sheetObj,sheetNo,flag) {
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
                    InitRowInfo(1, 1, 9, 100);
                    var HeadTitle = "|Del|User ID|Password|User Name|User Local Name|Office Code|Log In OFC|Auth Type|Super user's Role|Use Flag|Role|Program|Cell Phone|Phone No|Fax No|Email|Sales Rep|Email from IAM|Job Code|Position|Grade|National|Language|TimeZone|Date Type|Num Type|Create User ID|Create Date|Modi. User ID|Modi. Date|Last Access Date|view_flg" ;
					var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");	
					InitDataProperty(0, cnt++ , dtDelCheck,		30,		daCenter,		true,		"DEL",			false,			"",      dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daLeft,    false,   "usr_id",           true,        "",     dfNone,           0,    false,       true);
                    InitDataProperty(0, cnt++ , dtData,         80,    daLeft,    false,   "usr_pwd",          true,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtData,        150,    daLeft,    false,   "usr_nm",           true,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtData,        150,    daLeft,    false,   "usr_locl_nm",      true,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,       100,    daLeft,    false,   "ofc_cd",           true,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtPopup,       100,    daLeft,    false,   "cng_ofc_cd",           false,        "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtCombo,        80,    daLeft,    false,   "usr_auth_tp_cd",   false,        "",     dfNone,          	0,    !flag,        true);
                    InitDataProperty(0, cnt++ , dtPopup,        110,    daCenter,    false,   "super_role_assign",   	   false,        "",     dfNone,          	0,    true,        true);
                    InitDataProperty(0, cnt++ , dtCombo,        80,    daLeft,    false,   "use_flg",          true,        "",     dfNone,          	0,    true,        true);
                    InitDataProperty(0, cnt++ , dtPopup,        40,    daCenter,  false,   "role_assign",            false,       "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtPopup,        60,    daCenter,  false,   "pgm_assign",            false,       "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,  false,   "mphn_no",          false,       "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,  false,   "xtn_phn_no",       false,       "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,  false,   "fax_no",          false,       "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,         160,    daLeft,  false,   "dflt_eml",          false,       "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  false,   "srep_cd",          false,       "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtData,        160,    daLeft,    false,   "usr_eml",          true,        "",     dfNone,          	0,    false,        true);
                    InitDataProperty(0, cnt++ , dtPopup,        100,    daCenter,  false,   "jb_eng_nm",        false,        "",     dfNone,           0,    true,        true);
                    InitDataProperty(0, cnt++ , dtData,        100,    daCenter,  false,   "psn_eng_nm",       false,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtData,        100,    daCenter,  false,   "grd_eng_nm",       false,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtHidden,       120,    daLeft,    false,   "cnt_cd",           false,       "",     dfNone,          	0,    false,        false);
                    InitDataProperty(0, cnt++ , dtHidden,        80,    daLeft,    false,   "lang_tp_cd",       false,       "",     dfNone,          	0,    false,        false);
                    InitDataProperty(0, cnt++ , dtHidden,       150,    daLeft,    false,   "gmt_tmzn_cd",      false,       "",     dfNone,          	0,    false,        false);
                    InitDataProperty(0, cnt++ , dtHidden,        80,    daLeft,    false,   "cnt_dt_fmt_cd",    false,       "",     dfNone,          	0,    false,        false);
                    InitDataProperty(0, cnt++ , dtHidden,        80,    daLeft,    false,   "cnt_no_fmt_cd",    false,       "",     dfNone,          	0,    false,        false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,   "cre_usr_id",       false,       "",     dfNone,           0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,   "cre_dt",           false,       "",     dfDateYmd,        0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,   "upd_usr_id",       false,       "",     dfNone,           0,    false,        false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,   "upd_dt",           false,       "",     dfDateYmd,        0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,   "lst_lgin_dt",           false,       "",     dfDateYmd,        0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,   "view_flg",           false,       "",     dfDateYmd,        0,    false,       false);
                    InitDataCombo (0, "usr_auth_tp_cd", "Almighty|Super User|Regular|System Admin", "A|S|R|E","Regular");
                    InitDataCombo (0, "use_flg", "Yes|No", "Y|N","Yes");

					CountPosition = 0;

					InitDataValid(0, "ofc_cd", vtEngUpOther, "12345"); 
					InitDataValid(0, "mphn_no", vtNumericOther, "-"); 
					InitDataValid(0, "fax_no", vtNumericOther, "-"); 
					InitDataValid(0, "xtn_phn_no", vtNumericOther, "-"); 
					
					if ( flag ) ColHidden(1) = true;
					
					ShowButtonImage = 3;

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
				sheetObj.DoSearch("UserManagementGS.do", FormQueryString(formObj));
				setUseFlgEditable();
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
                //저장처리
            	formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("UserManagementGS.do", FormQueryString(formObj));
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
	        case "ofc_cd" :
	        	ComOpenPopup('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 700, 474, 'setPrntUsrRoleCd', '0,0,1,1,1,1,1,1', false, false, Row, Col, 0);
	       		break;
	        case "cng_ofc_cd" :
	        	ComOpenWindowCenter('/hanjin/UserManagementOfcCngPop.do?pgmNo=ADM_SYS_0008&admin_page=&usr_id='+sheetObj.CellValue(Row,"usr_id")+"&usr_nm="+encodeURI(sheetObj.CellValue(Row,"usr_nm")),'', 1000, 674, false);
	            break;
	       	case "dev_dt" :
	       			var cal = new ComCalendarGrid();
	       			cal.select(sheetObj, Row, Col, 'yyyyMMdd');
	       			break;
	        case "role_assign" :
	        		var parent_pgm_no = "";
				
					if( typeof(curPgmNo) != 'undefined' ){
						parent_pgm_no = curPgmNo;
					}
			      if(sheetObj.CellValue(Row,"ibflag")=="I" || sheetObj.CellValue(Row,"ibflag")=="U"){
			       	 ComShowCodeMessage('COM12151','Role');
			      }else{
			    	  ComOpenWindowCenter('/hanjin/roleMapping.do?usr_id='+sheetObj.CellValue(Row,"usr_id")+ "&parent_pgm_no=" + parent_pgm_no + "&usr_nm="+encodeURI(sheetObj.CellValue(Row,"usr_nm"))+"&usr_auth_tp_cd="+sheetObj.CellValue(Row,"usr_auth_tp_cd")+"&admin_page="+document.form.admin_page.value, '', '700', '474', true, false);
			         break;
			  	  }
			      break;
	        case "super_role_assign" ://super user 인 경우만 
	              if(sheetObj.CellValue(Row,"ibflag")=="I"){
	            	  ComShowCodeMessage('COM12151','사용자');
	              }else{
	              	var usr_auth_tp_cd = sheetObj.CellValue(Row,"usr_auth_tp_cd");
	              	if(usr_auth_tp_cd != "S") {
	              		ComShowMessage("Only Super User can be assigned Super user's role");
	              		break;
	              	}
	              	ComOpenWindowCenter('/hanjin/roleMapping.do?usr_role_adm_mtch=Y&usr_id='+sheetObj.CellValue(Row,"usr_id")+"&usr_nm="+encodeURI(sheetObj.CellValue(Row,"usr_nm")),'', '700', '474', true, false);
	              }
	              break;
	        case "pgm_assign" :
	            if(sheetObj.CellValue(Row,"ibflag")=="I" || sheetObj.CellValue(Row,"ibflag")=="U"){
	             	 ComShowCodeMessage('COM12151','Role');
	            }else{
	            	ComOpenWindowCenter('/hanjin/userProgramMapping.do?s_usr_id='+sheetObj.CellValue(Row,"usr_id")+"&s_usr_nm="+encodeURI(sheetObj.CellValue(Row,"usr_nm"))+"&s_ofc_cd="+sheetObj.CellValue(Row,"ofc_cd")+"&s_usr_auth_tp_cd="+sheetObj.CellValue(Row,"usr_auth_tp_cd")+"&view_flg="+sheetObj.CellValue(Row,"view_flg"), '', '700', '474', true, false);
	                break;
	        	}
	            break;
	            
	        case "jb_eng_nm" :
//	   			if(sheetObj.CellValue(Row,"ibflag")=="I" || sheetObj.CellValue(Row,"ibflag")=="U"){
//	   				ComShowCodeMessage('COM12151','프로그램');
//	   			}else if(sheetObj.CellValue(Row,"ibflag")=="R" && sheetObj.CellValue(Row,"pgm_mnu_div_cd")=="01"){
//	   				ComShowMessage('메뉴 항목은 역할을 지정할 수 없습니다.');
//	   			}else{
	   				//var url = '/hanjin/progJobMapping.do?pgm_no='+sheetObj.CellValue(Row,"pgm_no")+"&pgm_nm="+escape(sheetObj.CellValue(Row,"pgm_nm"));
	   				var url = '/hanjin/ADM_SYS_0016.do?rqst_usr_id='+sheetObj.CellValue(Row,"usr_id")+"&rqst_ofc_cd="+escape(sheetObj.CellValue(Row,"ofc_cd"));;
	   				ComOpenPopup(url,700,474, '','1,0',true,false,Row,Col,0);
	//    		     ComOpenPopup('/hanjin/programMapping.do?role_cd='+sheetObj.CellValue(Row,prefix + "usr_role_cd")+"&role_nm="+escape(sheetObj.CellValue(Row,prefix + "usr_role_nm")), 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
//	   			}
	   			
	   			break;
        }
	}

    function sheet1_OnChange(sheetObj,Row,Col) {
    	var formObject = document.form;
    	if(Col!=8) return;
    	if(sheetObj.CellValue(Row,Col)!="S") return;
		formObject.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchXml("ADM_SYS_0009GS.do?subSys=&usrId="+sheetObj.CellValue(Row,"usr_id")+"&ofcCd=", FormQueryString(formObject));
		if(ComGetEtcData(sXml,"cnt") == "0"){
			alert("not super user!");
			sheetObj.CellValue2(Row,Col)="R";
		}
    }
    
	function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
			var sheetObject = sheetObjects[0];
			sheetObject.CellValue(row,col)= aryPopupData[0][3];
   	}
   	function setUseFlgEditable(){
		var sheetObject = sheetObjects[0];
   		for(var i=1;i<=sheetObject.LastRow;i++) {
   			if(sheetObject.CellValue(i,"cre_usr_id")!="IAM") sheetObject.CellEditable(i,"use_flg")=almightyFlag;
   			else {
   				sheetObject.CellEditable(i,"use_flg")=false;
   				sheetObject.CellEditable(i,"DEL")=false;
   			}
   		}
   	
   	}
	/* 개발자 작업  끝 */