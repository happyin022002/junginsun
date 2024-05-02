/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0072.js
*@FileTitle : Segregation Simulation in a CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.27 김현욱
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
     * @class VOP_SCG_0072 : VOP_SCG_0072 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0072() {
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
    var sheetObjects = new Array();
    var sheetCnt     = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];

        /*******************************************************/
		var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            
	            case "btn_Un_No":
					var imdg_un_no = ComGetObjValue(formObj.imdg_un_no);
					var paramStr = "";
					if(imdg_un_no.length <= 4 && !isNaN(imdg_un_no)) {
						paramStr = "&imdg_un_no="+imdg_un_no;
					} else {
						if(imdg_un_no.length > 4) {
							if(imdg_un_no.indexOf(",") == -1) {
								paramStr = "&imdg_tec_nm="+imdg_un_no;
							}
						}
					}
                	var sUrl = "/hanjin/VOP_SCG_0002Pop.do?pgmNo=VOP_SCG_0002&pop_yn=Y"+paramStr;
            		ComOpenPopup(sUrl, 1006, 700, "setCallBackUnNoList", "0,1,1,1,1,1,1,1,1", true);
            		
					break;
				
				case "btn2_Segregation_Check":
					doActionIBSheet(sheetObj1, sheetObj2,formObj,IBSEARCH);
					break;
				
				case "btn2_Down_Excel":
                    var paramObj = new Object();
                    paramObj.title = "DG Items in a Container";
                    paramObj.cols = "10";
                    paramObj.columnwidth = "1:5|2:5|3:5|4:5|5:5|6:5|7:5|8:10|9:60|10:10";
                    paramObj.datarowheight   = "0:25";
                    var url = ComScgGetPgmTitle(sheetObj1, paramObj);  
                    sheetObj1.SpeedDown2Excel(-1, false, false, "", url, false, false, "DG Items in a Container", false, "", "", false, "", true );

					if(sheetObj2.RowCount > 0) {
	                    paramObj.title = "Segregation Validation";
	                    paramObj.cols = "7";
	                    paramObj.columnwidth = "1:5|2:5|3:5|4:90|5:5|6:5|7:5";
	                    paramObj.datarowheight   = "0:25";
	                    var url = ComScgGetPgmTitle(sheetObj2, paramObj);  
	                    sheetObj2.SpeedDown2Excel(-1, true, true, "", url, false, false, "Segregation Validation", false, "", "", false, "", true );
					}

					break;	
					
				case "btn_New":
                	ComResetAll();
            		
            		ComSetFocus(formObj.imdg_un_no);
                		
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
     * Sheet1 Combo Change Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 with(sheetObj) { 
    		switch(ColSaveName(Col)) {
    			case "sel_chk":
    				if(Value == 0) {
    					CellValue2(Row, "lq_chk") = 0;
    					CellValue2(Row, "eq_chk") = 0;
    					
    					CellEditable(Row, "lq_chk") = false;
    					CellEditable(Row, "eq_chk") = false;
    					
    					RowStatus(Row) = "R";
    				} else {
    					CellEditable(Row, "lq_chk") = true;
    					CellEditable(Row, "eq_chk") = true;
    				}
    				
    				//Control all-check box
    				var allChk = 0, allCt = 0;
    				for(var chkIdx=HeaderRows; chkIdx<=LastRow; chkIdx++) {
    					if(CellValue(chkIdx, "sel_chk") == 1) allChk++;
    					allCt++;
    				}
    				if(allChk == allCt) CheckAll("sel_chk") = 1;
    				else if(allChk == 0) {
    					CheckAll("sel_chk") = 0;
    					for(var chkIdx=HeaderRows; chkIdx<=LastRow; chkIdx++) {
    						RowStatus(chkIdx) = "R";
        				}
    				}
    				
    				break;
    			case "lq_chk":
    				if(Value == "1") {
    					CellValue2(Row, "eq_chk") = 0;
    				}
    				break;
    			case "eq_chk":
    				if(Value == "1") {
    					CellValue2(Row, "lq_chk") = 0;
    				} 
    				break;
    		}
    	 }
	}
    
    /**
	 * UN Number 팝업의 선택목록 내리기
	 */
	function setCallBackUnNoList(aryPopupData) {
		var sheetObj  = sheetObjects[0];
		
		//sheetObj.removeAll();
		
		var imdg_un_nos = "";
		var tecName     = "";
		var existenceYn = false;
		for (var rowIdx=0; rowIdx<aryPopupData.length; rowIdx++){ 
			existenceYn = false;
			for(var curIdx=sheetObj.HeaderRows; curIdx<=sheetObj.LastRow; curIdx++) {
				if(sheetObj.CellValue(curIdx, "imdg_un_no") == aryPopupData[rowIdx][2]
				   && sheetObj.CellValue(curIdx, "imdg_un_no_seq") == aryPopupData[rowIdx][3]) existenceYn = true;
			}
			
			if(!existenceYn) {				
				sheetObj.DataInsert(-1,0);	//신규행 생성
				imdg_un_nos += aryPopupData[rowIdx][2]+",";
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_un_no")            = aryPopupData[rowIdx][2];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_un_no_seq")        = aryPopupData[rowIdx][3];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_clss_cd")          = aryPopupData[rowIdx][4];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_comp_grp_cd")      = aryPopupData[rowIdx][5];			
				sheetObj.CellValue2(sheetObj.SelectRow, "prp_shp_nm")            = aryPopupData[rowIdx][6];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_tec_nm")           = aryPopupData[rowIdx][7];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_pck_grp_cd")       = aryPopupData[rowIdx][9];			
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_lmt_qty")          = aryPopupData[rowIdx][11];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_expt_qty_cd")      = aryPopupData[rowIdx][12];
				sheetObj.CellValue2(sheetObj.SelectRow, "imdg_subs_rsk_lbl_rmk") = aryPopupData[rowIdx][8];
				
				sheetObj.CellValue(sheetObj.SelectRow, "sel_chk")                = 1;
			}
		}
		
		//모든 Row에 Technical Name 정보가 없으면 열을 숨긴다.
		for(var tecIdx=sheetObj.HeaderRows; tecIdx<=sheetObj.LastRow; tecIdx++) {
			tecName += sheetObj.CellValue(tecIdx, "imdg_tec_nm");
		}
		if(tecName.length > 0) sheetObj.ColHidden("imdg_tec_nm") = false;
		else sheetObj.ColHidden("imdg_tec_nm") = true;
		
		//기본 체크박스 첵!
		//sheetObj.CheckAll("sel_chk") = 1;
		
		if(imdg_un_nos.length > 0) imdg_un_nos = imdg_un_nos.substring(0,imdg_un_nos.length-1);
		//ComSetObjValue(document.form.imdg_un_no, imdg_un_nos);
	}
    
    // 이벤트 Catch Listener
    function initControl() {
         // Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListener('keydown',  'unNoKeyEnter',   'form');
    }
    
    // Enter Key of Un Number form
    function unNoKeyEnter() {
    	var keyValue = event.keyCode;
    	if(keyValue == 13) {
    		if(event.srcElement.name = 'imdg_un_no') 
    			document.getElementById("btn_Un_No").fireEvent("onclick");
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
        
        initControl();
    }

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            
			case "sheet1":      //sheet1 init
                with (sheetObj) {

                    //높이 설정
                    style.height = 192;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "||LQ|EQ|UN No./Seq.|UN No./Seq.|Class|Class|Sub\nrisks|Proper Shipping Name|Technical Name|Packing\nGroup||";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
                    
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		"sel_chk",					false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,	    30,		daCenter,	true,		"lq_chk",					false,      "",				dfNone,		0,			true,		true,  -1, false, true, "", false);
					InitDataProperty(0, cnt++ , dtCheckBox,	    30,		daCenter,	true,		"eq_chk",					false,      "",				dfNone,		0,			true,		true,  -1, false, true, "", false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"imdg_un_no",				false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"imdg_un_no_seq",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"imdg_clss_cd",				false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"imdg_comp_grp_cd",			false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"imdg_subs_rsk_lbl_rmk",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			430,	daLeft,		true,		"prp_shp_nm",				false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"imdg_tec_nm",				false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"imdg_pck_grp_cd",			false,		"",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"imdg_lmt_qty");
 					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"imdg_expt_qty_cd");
					
					CountPosition = 0; 
					
					EditableColorDiff = false;
				}
                break;

			case "sheet2":      //sheet2 init
                with (sheetObj) {

                    //높이 설정
                    style.height = 144;
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

                    var HeadTitle1 = "|UN No./Seq.|UN No./Seq.|SG|Conflicts with|UN No./Seq.|UN No./Seq.|SG";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,       "Status");
                    
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"imdg_un_no1",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"imdg_un_no_seq1",		false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"imdg_segr_grp_no1",	false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			650,	daLeft,		true,		"conflict_desc",		false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"imdg_un_no2",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"imdg_un_no_seq2",		false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"imdg_segr_grp_no2",	false,		"",				dfNone,		0,			true,		true);
					
					CountPosition = 0;
					
					EditableColorDiff = false;
				}
                break;
        }
    }
     
    /**
     * Sheet2 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) { 
    	with(sheetObj) {
    		var rsltStr = "";
    		if(RowCount == 0) {
    			rsltStr = 'Load complies with IMDG Code segregation requirements.';
    		} else {
    			rsltStr = "<font color='#ff0000'>"+'Load does not comply. Segregation is required between pairs of substances listed below.'+"</font>";
    		}
    		document.getElementById("rsltStr").innerHTML = rsltStr;
    	}
    }
     
    /**
     * Sheet1 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	if (sheetObj.MouseCol == 2) {
     		sheetObj.MouseToolTipText = "Limited Q'ty";
     	} else if (sheetObj.MouseCol == 3) {
     		sheetObj.MouseToolTipText = "Excepted Q'ty";
     	} else {
     		sheetObj.MouseToolTipText = "";
     	}
    }
    
    /**
     * Sheet2 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	if (sheetObj.MouseCol == 3 || sheetObj.MouseCol == 7) {
     		sheetObj.MouseToolTipText = "Segregation Group";
     	} else {
     		sheetObj.MouseToolTipText = "";
     	}
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj1, sheetObj2, formObj, sAction) {
        sheetObj2.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj1,formObj,sAction)){
					switch(sheetObj2.id) {
						case "sheet2":
							var sParam = ComGetSaveString(sheetObj1, false, false, -1);	
							if(sParam == "") return;
							
							formObj.f_cmd.value = SEARCH;
							sheetObj2.DoSearch("VOP_SCG_0072GS.do", "f_cmd="+SEARCH+"&"+sParam);
							break;
					}					
				}

				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
		return true;
	}

	/* 개발자 작업  끝 */