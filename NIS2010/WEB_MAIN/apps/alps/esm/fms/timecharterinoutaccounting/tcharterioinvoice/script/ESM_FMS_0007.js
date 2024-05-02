/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0007.js
*@FileTitle : Manhour List
*@LastModifyDate : 2009.05.08
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.08 최우석 
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
     * @class TEU Range Target : TEU Range Target 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0007() {
    	this.processButtonClick		= processButtonClick;
    	this.inputReadOnly			= inputReadOnly;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.obj_keypress		    = obj_keypress;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	this.showSubSum				= showSubSum;
    	this.setCellEditable		= setCellEditable;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.setInitCell			= setInitCell;
    	this.setManHrItmNm			= setManHrItmNm;
    	this.sheet1_OnChange		= sheet1_OnChange;
    	this.initConfirm			= initConfirm;
    	this.setPortCd				= setPortCd;
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
    	var sheetObject1 = sheetObjects[1];
    	
    	/*******************************************************/
    	var formObject = document.form;
    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				if(!initConfirm()) return;
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    		
    			case "btn_new":
    				if(!initConfirm()) return;
    				ComResetAll();
    				break;
    						
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    		       	break;
    		
    			case "btn_add":
    				var row = sheetObject.DataInsert(-1);
    				setInitCell(sheetObject, row);
    				break;
    		
    			case "btn_ins":
    				var row = sheetObject.DataInsert();
    				setInitCell(sheetObject, row);
    				break;
    						
    			case "btn_del":
    				ComRowHideDelete(sheetObject, "DelChk");
    		       	break;
    		    
    			case "btn_manHourItemRegister":
    				ComOpenWindowCenter("ESM_FMS_0072_1.do?popup=yes", "ESM_FMS_0072_1", 500, 375);
    				//ComOpenWindowCenter("ESM_FMS_0072.do?popup=yes", "ESM_FMS_0072", 500, 375);
    				break;
    				
    			case "btn_close":
    				window.close();
    		       	break;
    				
    		} // end switch
    	} catch(e) {
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
        
        sheetObjects[0].ExtendLastCol = false;
        
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    style.height = 250;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Seq|Sel|Manhour Item Name|Port Name|Working Hours|Working Hours|Working Hours|Currency|Amount|slp_tp_cd|slp_func_cd|slp_team_cd|slp_iss_dt|slp_ser_no|slp_seq_no|man_hr_list_seq|org_man_hr_list_seq|csr_slp_flg";
    				var HeadTitle2 = "|Seq|Sel|Manhour Item Name|Port Name|Manager|Clerk|Agent|Currency|Amount|slp_tp_cd|slp_func_cd|slp_team_cd|slp_iss_dt|slp_ser_no|slp_seq_no|man_hr_list_seq|org_man_hr_list_seq|csr_slp_flg";
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    		90,    	daCenter,  	true,    "Seq");
    				InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  	true,    "DelChk");                    
    				InitDataProperty(0, cnt++ , dtPopup, 		250,   	daLeft,  	true,    "man_hr_itm_nm",		true,	"",      		dfNone,      	0,     true,	true);
    				InitDataProperty(0, cnt++ , dtPopupEdit, 	90,    	daCenter,  	true,    "port_cd",   			true,  	"",      		dfEngUpKey,   	0,     true,    true, 5);

    				InitDataProperty(0, cnt++ , dtData,			90,    	daRight,   	false,   "mgr_wrk_amt",   		false,  "",      		dfNullFloat, 	2,     true,	true, 18);
    				InitDataProperty(0, cnt++ , dtData,   		90,    	daRight,   	false,   "mbr_wrk_amt",   		false,  "",      		dfNullFloat, 	2,     true,	true, 18);
    				InitDataProperty(0, cnt++ , dtData,   		90,    	daRight,   	false,   "agn_wrk_amt",     	false,  "",      		dfNullFloat, 	2,     true,	true, 18);
    				InitDataProperty(0, cnt++ , dtData,   		90,    	daCenter,  	true,    "curr_cd",  			true,  	"",      		dfEngUpKey,   	0,     true,	true, 3);
    				InitDataProperty(0, cnt++ , dtData, 		100,   	daRight,   	true,    "Amount",    			false,  "|5|+|6|+|7|",	dfNullFloat, 	2,     false,	false);
    				//InitDataProperty(0, cnt++ , dtAutoSum, 		120,   	daRight,   	true,    "Amount",    			false,  "|5|+|6|+|7|",	dfNullFloat, 	2,     false,	false);

    				InitDataProperty(0, cnt++ , dtHidden, 		30,		daCenter,  	true,    "slp_tp_cd",			false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "slp_func_cd",			false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "slp_team_cd",			false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "slp_iss_dt",			false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "slp_ser_no",			false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "slp_seq_no",			false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "man_hr_list_seq",		false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "org_man_hr_list_seq",	false,	"",      		dfNone,      	0,     false,	false);
    				InitDataProperty(0, cnt++ , dtHidden, 		30,   	daCenter,  	true,    "csr_slp_flg",			false,	"",      		dfNone,      	0,     false,	false);

    				ShowButtonImage = 2;
    				InitDataValid(0, "curr_cd", vtEngUpOnly);
    				InitDataValid(0, "port_cd", vtEngUpOnly);
    				
    				DataLinkMouse("man_hr_itm_nm") = true;
 					DataLinkMouse("port_cd") = true;
               	}
    			break;
        }
    }

    /**
 	 * Sheet관련 프로세스를 처리한다.<br>
 	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
      		case IBSEARCH:      //조회
	      		formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_FMS_0007GS.do", FormQueryString(formObj));
				setCellEditable(sheetObj);
				break;

    		case IBSAVE:        //저장
	    		if(validateForm(sheetObj,formObj,sAction)) {
		  	  		formObj.f_cmd.value = MULTI;
		  	  		var returnValue = sheetObj.DoSave("ESM_FMS_0007GS.do", FormQueryString(formObj));
		  	  		if(returnValue) {
			  	  		showSubSum(sheetObj);
			  	  		setCellEditable(sheetObj);
		  	  		}
		  	  	}
    			break;

    		case IBINSERT:      // 입력
            	break;
        }
    }

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }

    /**
     * IBSheet Object에서 팝업을 클릭시 Manhour Item Select Popup, Location/Port Code Inquiry 팝업창을 띄운다.<br>
     */
    function sheet1_OnPopupClick(sheetObj,Row,Col)
    {
    	with(sheetObj) {
			var sName = ColSaveName(Col);

			if(sName == "man_hr_itm_nm") {
				ComOpenPopup("ESM_FMS_0081.do", 500, 375, "setManHrItmNm", "1,0,1,1,1,1", false, false, Row, Col, 0);
			} else if (sName == "port_cd") {
				ComOpenPopup("COM_ENS_051.do", 720, 480, "setPortCd", "1,0,1,1,1,1", true, false, Row, Col, 0);
			}
		}
    }
    /**
     * curr_cd별로 소계를 계산한다.<br>
     */
    function showSubSum(sheetObj) {
    	sheetObj.ShowSubSum(8, "9", 2, true, false, -1, "curr_cd=%s");
    }
    
    /**
     * csr_slp_flg가 'Y'인 경우 수정불가로 설정한다.<br>
     */ 
    function setCellEditable(sheetObj) {
    	for(var i=2; sheetObj.LastRow; i++) {
    		if(sheetObj.CellValue(i, "Seq") == 0) {
    			break;
    		}
    		
    		if(sheetObj.CellValue(i, "csr_slp_flg") == "Y") {
    			sheetObj.CellEditable(i, "DelChk") = false;
    			sheetObj.CellEditable(i, "man_hr_itm_nm") = false;
    			sheetObj.CellEditable(i, "port_cd") = false;
    			sheetObj.CellEditable(i, "mgr_wrk_amt") = false;
    			sheetObj.CellEditable(i, "mbr_wrk_amt") = false;
    			sheetObj.CellEditable(i, "agn_wrk_amt") = false;
    			sheetObj.CellEditable(i, "curr_cd") = false;
    		}
    	}
    }
     
    /**
     * sheet의 OnSearchEnd이벤트에서 curr_cd별로 소계를 계산한다.<br>
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	showSubSum(sheetObj);
    }
   
    /**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
    	if(sheetObjects[0].isDataModified) {
    		// 입력 및 변경된 데이터가 있습니다.\n\n계속 진행하시겠습니까?
    		var okYn = ComShowCodeConfirm("FMS00002");
    	}
    	
    	return okYn;
    }

    /** 
     * Row 추가시 sheet에 slp_tp_cd, slp_func_cd, slp_team_cd, slp_iss_dt, slp_ser_no, slp_seq_no 정보를 설정한다.<br>
     **/
    function setInitCell(sheetObj, row) {
    	sheetObj.CellValue(row, "slp_tp_cd") = form.slpTpCd.value;
    	sheetObj.CellValue(row, "slp_func_cd") = form.slpFuncCd.value;
    	sheetObj.CellValue(row, "slp_team_cd") = form.slpTeamCd.value;
    	sheetObj.CellValue(row, "slp_iss_dt") = form.slpIssDt.value;
    	sheetObj.CellValue(row, "slp_ser_no") = form.slpSerNo.value;
    	sheetObj.CellValue(row, "slp_seq_no") = form.slpSeqNo.value;
    }
    
    /**
	 * Manhour Item Select 팝업창에서 선택한 name과 시퀀스정보를 해당 Sheet에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
    function setManHrItmNm(aryPopupData, Row, Col, sheetIdx){
		 for(var i=2; i<=sheetObjects[0].LastRow; i++) {
			 if(Row == sheetObjects[0].CellValue(i, "man_hr_list_seq")) {
				 continue;
			 }

			 if(aryPopupData[0][3] == sheetObjects[0].CellValue(i, "man_hr_list_seq")) {
				 ComShowCodeMessage("FMS00008", "Manhour Item Name");
				 return;
			 }
		 }
		 
		 sheetObjects[0].CellValue2(Row, "man_hr_itm_nm") = aryPopupData[0][4];
		 sheetObjects[0].CellValue2(Row, "man_hr_list_seq") = aryPopupData[0][3];
    }

    /**
     * Sheet1의 OnChange 이벤트 발생시 Port Name과 Currency의 Validation을 체크한다.<br>
     */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if(Col == 4) {
			form.f_cmd.value = SEARCH04;
			var portCd = sheetObj.CellValue(Row, "port_cd");
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(form)+"&loc_cd="+portCd);
   			var locNm = ComGetEtcData(sXml, "cdName");

   			if(typeof locNm == "undefined" || locNm == "" ) {
   				sheetObj.CellValue2(Row, "port_cd") = "";
   				ComShowCodeMessage("FMS01079");
				sheetObj.SelectCell(Row, "port_cd");
   			}
		}
		
		if(Col == 8) {
			form.f_cmd.value = SEARCH01;
			var currCd = sheetObj.CellValue(Row, "curr_cd");
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do", FormQueryString(form)+"&curr_cd="+currCd);
   			var currNm = ComGetEtcData(sXml, "currCd");

   			if(typeof currNm == "undefined" || currNm == "" ) {
   				sheetObj.CellValue2(Row, "curr_cd") = "";
   				ComShowCodeMessage("FMS00006", "Currency");
				sheetObj.SelectCell(Row, "curr_cd");
   			}
		}
	}
     
    /**
 	 * Location / Port Code Inquiry 팝업창에서 선택한 Location정보를 해당 Sheet에 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setPortCd(aryPopupData, Row, Col, sheetIdx){
 		sheetObjects[0].CellValue2(Row, Col) = aryPopupData[0][3];
 	}
	/* 개발자 작업  끝 */