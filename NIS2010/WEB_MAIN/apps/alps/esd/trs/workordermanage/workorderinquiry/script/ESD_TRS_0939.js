/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0939.js
 *@FileTitle : Authorization W/O Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.21
 *@LastModifier : 9014787
 *@LastVersion : 1.0
 * 2015.07.21 9014787
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

var sheetObjects = new Array();
var sheetCnt = 0;
var gvMyRow = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /** **************************************************** */
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject, formObject, IBSEARCH);
        	        break;
        	    case "btn_confirm":
    	            doActionIBSheet(sheetObject, formObject, MULTI01);
        	        break;
        	    case "btn_save":
    	            doActionIBSheet(sheetObject, formObject, MULTI03);
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
     * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
     * 추가한다
     */
    function loadPage() {

       	//if (document.form.auth_apro_rqst_no.value == '') {
    		//ComShowCodeMessage("COM14001", "No.");// 조회를 위한 CSR no가 없습니다.
    		//self.close();
    	//} else {
    		try {
    			for(i=0;i<sheetObjects.length;i++){

    				//khlee-시작 환경 설정 함수 이름 변경
    				ComConfigSheet(sheetObjects[i]);

    				initSheet(sheetObjects[i],i+1);
    				//khlee-마지막 환경 설정 함수 추가
    				ComEndConfigSheet(sheetObjects[i]);
    			}

    			var sheetObject = sheetObjects[0];
    			var formObject = document.form;
    			doActionIBSheet(sheetObject,formObject,IBSEARCH);

    		} catch (e) {
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e);
    			}
    		}
    	//}
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(12);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msHeaderOnly;
				//MergeSheet = msHeaderOnly;msPrevColumnMerge
				MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge; //msAll;
				//msPrevColumnMerge + msHeaderOnly

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(23, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle1 = "Authorization Approval\nRequest No.|W/O No.|S/O No.|S/O Type|Cost\nMode|S/P\nCode|S/P\nName|From Node|Via Node|To Node|Door\nLocation|W/O Instruction|Currency|Nego. Amount|Nego. Amount|Nego. Amount|Additional Amount|Additional Amount|Additional Amount|Additional Amount|Approval\nRemark";
				var HeadTitle2 = "Authorization Approval\nRequest No.|W/O No.|S/O No.|S/O Type|Cost\nMode|S/P\nCode|S/P\nName|From Node|Via Node|To Node|Door\nLocation|W/O Instruction|Currency|Previous\nAmount|Current\nAmount|Nego\nRemark|Previous\nAmount|Current\nAmount|Item|Remark|Approval\nRemark";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				HeadRowHeight = 30;

				//데이터속성    [ROW, COL,  DATATYPE,     WIDTH,  DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,   190,    daCenter,  true,   "auth_apro_rqst_no",     false,          "",       dfNone,	 0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,   "wo_no",                 false,          "",       dfNone,	 0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,   "so_no",                 false,          "",       dfDateYmd, 0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,   "trsp_so_tp_nm",         false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,   "trsp_cost_dtl_mod_nm",  false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,   "vndr_seq",              false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      80,      daLeft,  true,   "vndr_nm",               false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,   "fm_nod_cd",             false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,   "via_nod_cd",            false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,   "to_nod_cd",             false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,   "dor_nod_cd",            false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      100,    daLeft,   true,   "inter_rmk",             false,          "",       dfNone,    0,     false,       false);

                InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,   "curr_cd",               false,          "",       dfNone,   	0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daRight,  true,   "pre_nego_amt",          false,          "",       dfFloat,   	2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daRight,  true,   "nego_amt",              false,          "",       dfFloat,   	2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      140,     daLeft,  true,   "nego_rmk",              false,          "",       dfNone,   	0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      70,    daRight,  false,  "pre_scg_amt",           false,          "",       dfFloat,   	2,     false,       false, 400);
                InitDataProperty(0, cnt++ , dtData,      70,    daRight,  false,  "scg_amt",               false,          "",       dfFloat,   	2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,  "lgs_cost_full_nm",      false,          "",       dfNone,   	0,     false,       false);
                //InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,"trsp_agmt_rt_tp_cd",      false,          "",       dfNone,     0,     false,        false,  10,   false,   true,  "", false);
                InitDataProperty(0, cnt++ , dtData,      140,    daLeft,   false,   "otr_rmk",        	    false,          "",       dfNone,   	0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      300,    daLeft,   true,    "auth_apro_rmk",        false,          "",       dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,   false,   "auth_apro_rqst_no_seq",false,          "",       dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtHiddenStatus,0, daCenter,    false,   "ibflag",               false,          "",       dfNone,   	0,     false,      	false);

                /*SetMergeCell(0, 3, 2, 1);
                SetMergeCell(0, 4, 2, 1);
                SetMergeCell(0, 5, 2, 1);
                SetMergeCell(0, 6, 2, 1);
                SetMergeCell(0, 7, 2, 1);
                SetMergeCell(0, 8, 2, 1);
                SetMergeCell(0, 9, 2, 1);
                SetMergeCell(0, 10, 2, 1);
                SetMergeCell(0, 11, 2, 1);
                SetMergeCell(0, 12, 2, 1);*/

                SelectHighLight = false;
             }
                break;

        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	formObj   
     * @param {String} 	sAction   
     * @return {없음}
     **/
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
               
                formObj.f_cmd.value = SEARCH;                
                selectVal = FormQueryString(formObj);
                sheetObj.DoSearch4Post("ESD_TRS_0939GS.do", selectVal);
                break;

           case MULTI01:
        	   for(var i=0; i<sheetObj.RowCount; i++) {
        		   if(sheetObj.CellValue(i + 2, "auth_apro_rqst_no_seq") == 1) {
                       sheetObj.CellValue2(i + 2, "ibflag") = "U";
                   }else{
                	   sheetObj.CellValue2(i + 2, "ibflag") = "R";
                   }
               }
        	   formObj.f_cmd.value = COMMAND02;
        	   selectVal = FormQueryString(formObj);
        	   sheetObj.DoSave("COM_ENS_0U1GS_AUTH.do", selectVal, -1, false);
        	   break;

           case MULTI03:
        	   for(var i=0; i<sheetObj.RowCount; i++) {
        		   // Row 수만큼 Update 되는것을 방지
        		   if(sheetObj.CellValue(i + 2, "auth_apro_rqst_no_seq") != 1) {
        			   sheetObj.CellValue2(i + 2, "ibflag") = "R";
                   }
               }
        	   formObj.f_cmd.value = COMMAND04;
        	   selectVal = FormQueryString(formObj);
        	   sheetObj.DoSave("COM_ENS_0U1GS_AUTH.do", selectVal, -1, false);
        	   break;
        }
    }
    
    /**
     * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
     * @param {sheet}	t1sheet1	Coincidence sheet
     * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {long}	X			X 좌표
     * @param {long}	Y			Y 좌표
     * @return
     */	
    function sheet1_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
    	var row = t1sheet1.MouseRow;
    	var col = t1sheet1.MouseCol;
    	if (t1sheet1.ColSaveName(col) == "nego_rmk" && row >= 1
    			&& t1sheet1.CellValue(row, "nego_rmk") != null
    			&& t1sheet1.CellValue(row, "nego_rmk") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "nego_rmk");
    	}else if (t1sheet1.ColSaveName(col) == "otr_rmk" && row >= 1
    			&& t1sheet1.CellValue(row, "otr_rmk") != null
    			&& t1sheet1.CellValue(row, "otr_rmk") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "otr_rmk");
    	}else if (t1sheet1.ColSaveName(col) == "vndr_nm" && row >= 1
    			&& t1sheet1.CellValue(row, "vndr_nm") != null
    			&& t1sheet1.CellValue(row, "vndr_nm") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "vndr_nm");
    	}else if (t1sheet1.ColSaveName(col) == "trsp_so_tp_nm" && row >= 1
    			&& t1sheet1.CellValue(row, "trsp_so_tp_nm") != null
    			&& t1sheet1.CellValue(row, "trsp_so_tp_nm") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "trsp_so_tp_nm");
    	}else if (t1sheet1.ColSaveName(col) == "trsp_cost_dtl_mod_nm" && row >= 1
    			&& t1sheet1.CellValue(row, "trsp_cost_dtl_mod_nm") != null
    			&& t1sheet1.CellValue(row, "trsp_cost_dtl_mod_nm") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "trsp_cost_dtl_mod_nm");
    	}else if (t1sheet1.ColSaveName(col) == "inter_rmk" && row >= 1
    			&& t1sheet1.CellValue(row, "inter_rmk") != null
    			&& t1sheet1.CellValue(row, "inter_rmk") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "inter_rmk");
    	}else if (t1sheet1.ColSaveName(col) == "auth_apro_rmk" && row >= 1
    			&& t1sheet1.CellValue(row, "auth_apro_rmk") != null
    			&& t1sheet1.CellValue(row, "auth_apro_rmk") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "auth_apro_rmk");
    	}else if (t1sheet1.ColSaveName(col) == "lgs_cost_full_nm" && row >= 1
    			&& t1sheet1.CellValue(row, "lgs_cost_full_nm") != null
    			&& t1sheet1.CellValue(row, "lgs_cost_full_nm") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "lgs_cost_full_nm");
    	}
    }
    
    
    /**
     * OnsearchEnd 에서 SetMergeCell
     * @param sheetObj
     * @param errMsg
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	var formObj = document.form;
    	
    	if( errMsg != '' ) {
    		ComShowMessage(errMsg);
    	}else{
    		//var auth_apro_rqst_no = '';
    		for(var i =2; i<sheetObj.RowCount+2; i++){
				if(formObj.btn_flag.value == "Y"){
	    			/*if(sheetObj.CellValue(i,'auth_apro_rmk') == ''){
						// 값이 없을경우 Insert 상태 이므로 auth_apro_rqst_no 기준 첫번째 row 만 Edit 가능하게 처리
						if(auth_apro_rqst_no != sheetObj.CellValue(i,'auth_apro_rqst_no')){
							sheetObj.CellEditable(i, 'auth_apro_rmk') = true;
						}
						
						auth_apro_rqst_no = sheetObj.CellValue(i, 'auth_apro_rqst_no');
					}else{
						sheetObj.CellEditable(i, 'auth_apro_rmk') = true;
					}*/
					
					// 값이 없을경우 Insert 상태 이므로 auth_apro_rqst_no_seq 기준 1 만 Edit 가능하게 처리
					if(1 == sheetObj.CellValue(i, 'auth_apro_rqst_no_seq')){
						sheetObj.CellEditable(i, 'auth_apro_rmk') = true;
					}else{
						sheetObj.CellValue2(i, 'auth_apro_rmk') = "";
					}
					
					//auth_apro_rqst_no = sheetObj.CellValue(i, 'auth_apro_rqst_no');
				}else{
					if(1 != sheetObj.CellValue(i, 'auth_apro_rqst_no_seq')){
						sheetObj.CellValue2(i, 'auth_apro_rmk') = "";
					}
				}
				
				// Merge 처리를 위해서
				if(sheetObj.CellValue(i, 'via_nod_cd') == ""){
					sheetObj.CellValue2(i, 'via_nod_cd') = " ";
				}
				
				if(sheetObj.CellValue(i, 'dor_nod_cd') == ""){
					sheetObj.CellValue2(i, 'dor_nod_cd') = " ";
				}

				if(sheetObj.CellValue(i, 'inter_rmk') == ""){
					sheetObj.CellValue2(i, 'inter_rmk') = " ";
				}
				
				if(sheetObj.CellValue(i, 'nego_rmk') == ""){
					sheetObj.CellValue2(i, 'nego_rmk') = " ";
				}
			}
    		
    		// 1개의 Apro 처리를위해서
    		//sheetObj.SetMergeCell(0, 20, 1, 1);
    		
    		// Confirm Mode 가 아닐때 MergeCell
    		/*if(formObj.btn_flag.value != "Y"){
    			sheetObj.SetMergeCell(2, 20, sheetObj.RowCount, 1);
    		}*/
    	}
    }
    
    
    /**
     * 
     * @param sheetObj
     * @param errMsg
     */
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	var formObj = document.form;
    	
    	if( errMsg != '' ) {
    		ComShowMessage(errMsg);
    	}else{
    		
    		if(document.form.f_cmd.value == COMMAND04){
    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
    			ComShowCodeMessage('TRS90511');
    			window.returnValue = 'retrieve';
    		}else{
    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
    			ComShowCodeMessage('TRS90002');
    			window.returnValue = 'retrieve';
    			window.close();
    		}
    	}
    }