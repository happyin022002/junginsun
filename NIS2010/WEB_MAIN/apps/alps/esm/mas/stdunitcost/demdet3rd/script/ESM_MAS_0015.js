/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0015.js
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.08.24 송호진
* 1.0 Creation
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_MAS_0015 : ESM_MAS_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0015() {
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
    var sheetCnt = 0;

    var searchedYrMon = "";
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

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
                case "btn_Month_Copy":
                    doActionIBSheet(sheetObject,formObject,MULTI02);
                    break;					

                case "btng_RowDel":// 행삭제
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;                            
                    
                case "btng_RowAdd"://행 추가
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;          
 
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg(OBJECT_ERROR));
			} else {
			ComShowMessage(e);
			}
		}
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		var formObj = document.form;
		if( formObj.v_ofc_cd.value != "SELOPB" && formObj.v_ofc_cd.value != "SELCSG" && formObj.v_ofc_cd.value != "SELAPM"
		    && formObj.v_ofc_cd.value != "SELCON" ){		
			ComSetDisplay("btn_control",false);    
			ComBtnDisable("btn_Month_Copy");
		}

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
			case 1:	//sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
					Editable = true;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(15, 5, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

					var HeadTitle = "STS|No.||Cost YRMON|TP/SZ|Trade|H_C/A Code|C/A Code|H_SO Code|SO Code|Unit Cost|AMT|Vol.|H_CTRT/AVG|CTRT/AVG" ;
					InitHeadRow(0, HeadTitle,true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,	false,	"");
					InitDataProperty(0, cnt++, dtDummyCheck,    40,  daCenter, false, "chk");
	                InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   false,  "cost_yrmon",         false,  "", dfNone,     0,  false,  false);

					InitDataProperty(0, cnt++ , dtComboEdit,		70,		daCenter,	false,	"cntr_tpsz_cd",			false,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,		70,		daCenter,	false,	"trd_cd",				false,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daLeft,		false,	"stnd_cost_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		200,	daLeft,		false,	"stnd_cost_nm",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daLeft,		false,	"mas_cost_src_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		220,	daLeft,		false,	"mas_cost_src_cd_nm",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"uc_amt",				false,	"",	dfFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"ttl_dmdt_amt",			false,	"",	dfInteger,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"bkg_vol_qty",			false,	"",	dfInteger,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	false,	"cost_ass_bse_cd",		false,	"",	dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"cost_ass_bse_nm",		false,	"",	dfNone,		0,	false,	false);

					CountPosition	= 0 ;
					style.height = GetSheetHeight(14) ;
	                InitDataCombo(0,"cntr_tpsz_cd", tpSzText, tpSzValue,"","");
		            InitDataCombo(0,"trd_cd", trdCdText, trdCdValue,"","");
		            ColHidden("chk") =true;
				}
				break;
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


	function sheet1_OnChange(sheetObj, Row,Col,Value) {
		var sName = sheetObj.ColSaveName(Col);
		if ( sName == "bkg_vol_qty") {
			sheetObj.CellValue2(Row, "uc_amt") = sheetObj.CellValue(Row,"ttl_dmdt_amt")/Value;
		} else if( sName== "ttl_dmdt_amt"){
			sheetObj.CellValue2(Row, "uc_amt") = Value/sheetObj.CellValue(Row,"bkg_vol_qty");
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			case IBSEARCH:	//조회
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_MAS_0015GS.do", masFormQueryString(formObj));
					ComOpenWait(false);
					searchedYrMon = formObj.f_cost_yrmon.value;
				}
				break;

			case IBSAVE:	//저장
				if(validateForm(sheetObj,formObj,sAction)){
				    //삭제된 행을 제외하고 중복된 행을 찾는다.
				    var rowM = sheetObj.ColValueDup("cost_yrmon|cntr_tpsz_cd|trd_cd|stnd_cost_cd", false);
				   
		             if (rowM >= 0) {
	                     ComShowMessage(ComGetMsg("MAS00015","Row "+rowM));
		                 return false;
		            }
		            //필수 입력 체크
		            var sRow = sheetObj.FindStatusRow("I|U");
 		            //받은 결과를 배열로 생성한다.
		            var arrRow = sRow.split(";");
		            for (idx=0; idx<arrRow.length-1; idx++){
                         if(sheetObj.CellValue(arrRow[idx],"cost_yrmon") == ""){
                            ComShowMessage(ComGetMsg("MAS00013","Cost YRMON"));

                            return false;
                        }   
		                if(sheetObj.CellValue(arrRow[idx],"cntr_tpsz_cd") == ""){
                            ComShowMessage(ComGetMsg("MAS00013","TP/SZ"));

		                    return false;
		                }
                        if(sheetObj.CellValue(arrRow[idx],"trd_cd") == ""){
                            ComShowMessage(ComGetMsg("MAS00013","Trade"));

                            return false;
                        }
                        if(sheetObj.CellValue(arrRow[idx],"uc_amt") == "" || sheetObj.CellValue(arrRow[idx],"uc_amt") == "0"){
                            ComShowMessage(ComGetMsg("MAS00013","Unit Cost"));

                            return false;
                        }  
                        if(sheetObj.CellValue(arrRow[idx],"ttl_dmdt_amt") == "" || sheetObj.CellValue(arrRow[idx],"ttl_dmdt_amt") == "0"){
                            ComShowMessage(ComGetMsg("MAS00013","Unit Cost"));

                            return false;
                        }  
		            }
 
				    
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESM_MAS_0015GS.do", masFormQueryString(formObj));
					ComOpenWait(false);
				}
				break;
            case IBDELETE:                  // 행삭제
                //sheetObj.RowDelete(sheetObj.SelectRow, false);
                deleteRowCheck(sheetObj, "chk" ,true);  
                break;
            case IBINSERT:  //행 추가
                var row = sheetObj.DataInsert(-1);
                sheetObj.CellValue2(row, "cost_yrmon") = searchedYrMon.replace("-","");
                sheetObj.CellValue2(row, "stnd_cost_cd") = "43201011";
                sheetObj.CellValue2(row, "stnd_cost_nm") = "CNTR DEM/DET";
                sheetObj.CellValue2(row, "mas_cost_src_cd") = "43201011";
                sheetObj.CellValue2(row, "mas_cost_src_cd_nm") = "CNTR DEM/DET";
                sheetObj.CellValue2(row, "cost_ass_bse_cd") = "F";
                sheetObj.CellValue2(row, "cost_ass_bse_nm") = "Fixed Unit";

                
                break;                
			case IBDOWNEXCEL:	//엑셀 다운로드
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
						sheetObj.Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObj.Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObj.SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObj.SpeedDown2Excel(-1, false, false);
						break;
				}

				break;

            case MULTI02:      //팝업창(Month Copy)
                var display = "0,1";
                ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0015&check_cnt=Y", 250, 200, "DEM/DET 3RD", display, true, false);

                break;
				
		}
	}


	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		var rt = false;
		with(formObj){
			if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
			}else {
				rt = true;
			}
		}
		return rt;
	}
	

	/* 개발자 작업  끝 */