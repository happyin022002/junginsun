// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
                case "cnt_btn":         
                	with(formObject)
                	{    	    
                		
                	    var v_cnt_cd = vndr_cnt_cd.value;
                	    var classId = "COM_ENS_0M1";
            		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
            		    var v_display = "1,0,1,1,1,0,0";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		    	ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCOM_ENS_0M1_1', v_display, true);
            		    } else {
            			    return;
            		    }
                	}
				case "btn_retrieve":
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				
				case "btn_delete":
					doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;

				case "btng_agreementcreation":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btng_agreementcopy":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_ok":
				    doActionIBSheet(sheetObject,formObject,COMMAND01);					  
				  break;

				case "btn_close":
					  window.close();
				  break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
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
					style.height = GetSheetHeight(17) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Chk.|STS|No|Agreement No.|Agreement No.|Vendor|Vendor|Office|Name|Del";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtRadioCheck, 30,    daCenter,  false, "radio",			false ,         "",       dfNone,   		 0,     true,       true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,  	30, 	daCenter,  	false,    	"ibflag",       	false,      "",     	dfNone,   	0,     		false,      true);
 				    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   true, "",					false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   true, "agmt_ofc_cty_cd",		false,           "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true, "agn_agmt_seq",		false,           "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,   true, "vndr_cnt_cd",		false,          "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true, "vndr_seq",			false,          "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   true, "agmt_ofc_cd",		false,          "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      340,    daLeft,   true, "vndr_lgl_eng_nm",	false,      "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true, "delt_flg",			false,          "",       dfNone,          0,     true,      true);
                    //CountPosition  = 0;
				}
				break;

		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.agreement_no.value = "";
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0001GS.do", agtQryStr(formObj));
				break;
			
			case IBDELETE:      //삭제
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESM_AGT_0001GS.do", agtQryStr(formObj));
				break;
			
			case IBINSERT:      //생성
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = ADD;
				//sheetObj.DoSave("ESM_AGT_001GS.do", agtQryStr(formObj));
				sheetObj.DoSave("ESM_AGT_0001GS.do",agtQryStr(formObj),"radio");
				break;
			
			case IBSAVE:       //Agreement Copy
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0001GS.do", agtQryStr(formObj));
				break;
			
			case COMMAND01:       //Agreement Copy
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				comPopupOK();
				break;
		}
	}
	
	function sheet1_OnDblClick(sheetObj, row, col, value) {
		var formObject = document.form;
        var agmt_ofc_cty_cd = sheetObj.CellValue(row, "agmt_ofc_cty_cd");
        var agn_agmt_seq = sheetObj.CellValue(row, "agn_agmt_seq");
        var agmt_ofc_cd = sheetObj.CellValue(row, "agmt_ofc_cd");
        var vndr_seq = sheetObj.CellValue(row, "vndr_seq");
        formObject.agreement_no.value = agmt_ofc_cty_cd + agn_agmt_seq;
        //formObject.agmt_ofc_cd.value = agmt_ofc_cd;
        //formObject.vndr_seq.value = vndr_seq;
        
        
//        sheetObj.CellValue(row,"ibflag") = "U";
        /*
        if(sheetObject1.CellValue(row,dibflag") == "R"){
            formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(row,"agn_agmt_ver_seq");
            doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
            formObject.current.value = formObject.agn_agmt_ver_seq.value;
            formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
        }
        */
    }
	
	/**
     * 팝업에서 Radio로 단일 선택을 한경우..
     */
    function getCOM_ENS_0M1_1(rowArray) {
    	
    	var colArray = rowArray[0];	
    	document.all.vndr_cnt_cd.value = colArray[3];
    }
     /**
      * Office 조회 팝업 열기
      */
     function openWindowOffice(formObj) {
     		
     	var url = "COM_ENS_071.do";
     	var width = 775;
     	var height = 460;
     	var func = "setOffice";
     	var display = "1,0,1";

     	ComOpenPopup(url, width, height, func, display, true);
     }

     /**
      * Office 조회 후 값 Return 받아 셋팅한다.
      */
     function setOffice(rowArray, row, col) {
     	var colArray = rowArray[0];
     	document.form.s_agmt_ofc_cd.value = colArray[3];
     }

   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {

			case IBSEARCH:
        		with(formObj){
        			
                    if (formObj.vndr_cnt_cd.value == "") {
                    	ComShowMessage(ComGetMsg('AGT10001','Country Code')); 
                        formObj.vndr_cnt_cd.focus();
                       return false;
                    }
        		}
        		break;
        	
        	case IBDELETE:
        		if(sheetObj.RowCount == 0){
        	    	ComShowMessage(ComGetMsg('AGT10002','Agent Vendor List'));
        	        return false;
        	    }
        		if(sheetObj.CheckedRows(0) != 1){
        			ComShowCodeMessage('COM12113','checkbox');
        	        return false;
        	    }

        	    var arrRow = sheetObj.FindCheckedRow(0).split("|");

        	    if(sheetObj.CellValue(arrRow[0], "agmt_ofc_cty_cd") == ""){
        	    	ComShowCodeMessage('AGT00082','Agreement No');
        	        return false;
        		}
        	    
        	    if(sheetObj.CellValue(sheetObj.SelectRow, "delt_flg") == "Y"){
        	    	ComShowCodeMessage('AGT00084','');
        	    	return false;
        	    }
		        break; 
        	
        	case IBINSERT:
        		if(sheetObj.RowCount == 0){
        	    	ComShowMessage(ComGetMsg('AGT10002','Agent Vendor List'));
        	        return false;
        	    }
        	    if(sheetObj.CheckedRows(0) != 1){
        	    	ComShowCodeMessage('COM12113','checkbox');
        	        return false;
        	    }
        	    var arrRow = sheetObj.FindCheckedRow(0).split("|");

        	    if(sheetObj.CellValue(arrRow[0], "agmt_ofc_cty_cd") == ""){
        	    	ComShowCodeMessage('AGT00082','Agreement No');
        	        return false;
        		}
		        break;
        		
            case IBSAVE:        
            	if(sheetObj.RowCount == 0){
        	    	ComShowMessage(ComGetMsg('AGT10002','Agent Vendor List'));
        	        return false;
        	    }
//        		if(sheetObj.CheckedRows(0) != 1){
//        			ComShowCodeMessage('COM12113','checkbox');
//        	        return false;
//        	    }

        	    if(formObj.agreement_no.value == ""){
        	    	ComShowCodeMessage('AGT10001','Agreement No. for copy');
        	        formObj.agreement_no.focus();
        	        return false;
        		}else if(formObj.agreement_no.value.length !=9){
        			ComShowCodeMessage('AGT10001','correct Agreement No');
        	        formObj.agreement_no.focus();
        	        return false;
        		}
		        break;     
		    
		    case COMMAND01:
		    	if(sheetObj.RowCount == 0){
        	    	ComShowCodeMessage('AGT10002','Agent Vendor List');
        	        return false;
        	    }
		        var chkRowCnt = sheetObj.CheckedRows(0);             
        		var chkRow = sheetObj.FindCheckedRow(0);
        		chkRow = chkRow.substr(0, chkRow.length -1);

        		if(chkRowCnt > 0){
        		    if(sheetObj.CellValue(chkRow, "agmt_ofc_cty_cd") == "" || sheetObj.CellValue(chkRow, "agn_agmt_seq") == ""){
        		    	ComShowCodeMessage('AGT10010','Agreement No');
        	           return false;
        	        }
        		}        		
        	    
		        break;       		
       	}
       				
		return true;
	}

