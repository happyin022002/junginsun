/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0721.js
*@FileTitle : Cut Off Time
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.11 최영희
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.27 전성진 [CHM-201006057] Booking Receipt Notice "Full Return Date" 표기 관련 : Notice 체크조건 제거
* 2010.10.29 이일민 [CHM-201006561-01] BKG CCT 팝업 화면에 Empty P/UP Date 항목 추가
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
 * @class esm_bkg_0721 : esm_bkg_0721 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0721() {
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
var prefix1="sheet1_";
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
				case "btn_save":
					if (validateForm(sheetObject,document.form,IBSAVE)){
						doActionIBSheet(sheetObject,document.form,IBSAVE);
					}
                break;
				
//              case "btn_client":
//                  //esm_bkg_0154창 띄우는곳
//                  var pWin  = ComOpenWindowCenter("/hanjin/ESM_BKG_0154POP.do?pgmNo=ESM_BKG_0154", "myWin", 1000,520, true);
//					    
//				break;

				case "btn_close": 
					var bflag=true;
					if (formObject.modifyFlag.value=="Y"){ 
						bflag=ComShowCodeConfirm("BKG00168");
//						break;
					}
					if (bflag){
						window.close();
					}else{							
//						doActionIBSheet(sheetObject,document.form,IBSAVE);
					}					
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
     		ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        } 
		if (!ComIsNull(document.form.bkg_no)){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}	
	}

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetId = sheetObj.id;
				
        switch(sheetId) {
            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 142;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "| | |Port(s)/Yard|System Time|System Time|Manual Update Time|Manual Update Time|Updated by|Notice|Description";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			110,	daLeft,			true,		"nm",				false,	"",      dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daLeft,			true,		"nmtp",				false,	"",      dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		false,		"clz_yd_cd",		false,	"",      dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		"systemdate",		false,	"",      dfDateYmd,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		"systemtime",		false,	"",      dfTimeHm,			0,		false,	true);

					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		"manualupdate",		false,	"",      dfDateYmd,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		"manualupdatetime",	false,	"",      dfTimeHm,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		"mnl_set_usr_id",	false,	"",      dfNone,			0,		false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		"ntc_flg",			false,	"",      dfNone,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		"sys_set_dt_desc",	false,	"",      dfNone,			0,		false,	false);
					
					InitDataProperty(0, cnt++ , dtHidden,		100,	dtHidden,		false,		"clz_tp_cd",		false,	"",      dfNone,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		100,	dtHidden,		false,		"updatebyname",		false,	"",      dfNone,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		100,	dtHidden,		false,		"mnl_set_dt",		false,	"",      dfNone,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		100,	dtHidden,		false,		"bkg_no",			false,	"",      dfNone,			0,		true,	true);

					CountPosition = 0; 
					DataRowMerge(0)=true;
					UseDefaultTime =false;  //현재시간표시여부
					EditEnterBehavior ="tab"; 
				}
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_");
        switch(sAction) {

          	case IBSEARCH:      //조회
				 formObj.f_cmd.value = SEARCH; 
				 var sXml = sheetObj.GetSearchXml("ESM_BKG_0721GS.do", "f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value);
				 sheetObj.Redraw = false; 
				 sheetObj.LoadSearchXml(sXml); 
				 sheetObj.Redraw = true;  
				 
				 formObj.vvd.value=ComGetEtcData(sXml,"vvd");
				 formObj.pol.value=ComGetEtcData(sXml,"pol");
				 formObj.etb.value=ComGetEtcData(sXml,"etb");
				 formObj.etd.value=ComGetEtcData(sXml,"etd");
				 sheetObj.CellBackColor(3, "manualupdatetime") =sheetObj.RgbColor(239,235,239);
				 sheetObj.CellBackColor(4, "manualupdatetime") =sheetObj.RgbColor(239,235,239);
				 var erdRow = sheetObj.FindText("clz_tp_cd", "L"); //Early Release Date
				 if(erdRow > 0){
					 sheetObj.CellEditable(erdRow, "manualupdate") = false; 
				 	 sheetObj.CellEditable(erdRow, "manualupdatetime") = false;
				 }
				 formObj.modifyFlag.value = "N";
			break;
          	case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI; 
				for(var i=1;i<sheetObj.Rows;i++){
					sheetObj.CellValue(i,"ibflag")="U";
					if(sheetObj.CellValue(i,"manualupdatetime").length<4 &&
							sheetObj.CellValue(i,"manualupdate").length>0){
						sheetObj.CellValue2(i,"manualupdatetime") ="00:00";
					}
					sheetObj.CellValue2(i,"mnl_set_dt") = sheetObj.CellValue(i,"manualupdate")
				      											+ sheetObj.CellValue(i,"manualupdatetime");
				}

				var sParam = "f_cmd="+MULTI+"&"+ComGetSaveString(sheetObj);
				if (sParam == "") return; 
//				sParam += "&" + ComGetPrefixParam(arrPreFix);

				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0721GS.do", sParam);
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				sheetObj.LoadSaveXml(sXml);

            	if(State == "S"){
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:				
//				if(formObj.modifyFlag.value == "N"){
//	    			ComShowCodeMessage("BKG00233");
//	    			return false;					
//				}
					
				if(ComIsNull(formObj.bkg_no)){
					ComShowCodeMessage("BKG00835"); 
					return false;
				}
				if (sheetObj.CellValue(2,"manualupdate").length>0){
					if (sheetObj.CellValue(2,"manualupdate")<ComParseInt(ComReplaceStr(formObj.etb.value.substring(0,10)))){						
						return false; 
					}
				}
				if(sheetObj.CellValue(3,"manualupdate").length>0){
					if (sheetObj.CellValue(3,"manualupdate")<ComParseInt(ComReplaceStr(formObj.etb.value.substring(0,10)))){
						ComShowCodeMessage("BKG00079"); 
						return false; 
					}
				}
				if(sheetObj.CellValue(6,"manualupdate").length>0){
					if (sheetObj.CellValue(6,"manualupdate")<ComParseInt(ComReplaceStr(formObj.etb.value.substring(0,10)))){
						ComShowCodeMessage("BKG00079"); 
						return false; 
					}
				}
				
				if(ComGetObjValue(formObj.bdr_Flag) =='Y'){
					ComShowCodeMessage("BKG00106");
					return false;
				}
			break; 
		} 
        return true;
    }
  
	/*
	* ToolTip
	*/
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){  
		if (sheetObj.MouseCol==sheetObj.SaveNameCol("mnl_set_usr_id")){
			sheetObj.MousePointer = "Hand";
			sheetObj.MouseToolTipText =sheetObj.CellText(sheetObj.MouseRow,"updatebyname");
		}else{
			sheetObj.MousePointer = "Default";
			if (sheetObj.MouseToolTipText != ""){ 
				sheetObj.MouseToolTipText = "";
			} 
		}
	}
	
	/*
	* 그리드에 bkg_clz_tm 테이블 키값 대입
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			for (i=1;i<Rows;i++){
			   CellValue(i,"bkg_no") = document.form.bkg_no.value;
			   CellValue2(i,"mnl_set_dt")= CellValue(i,"manualupdate")+CellValue(i,"manualupdatetime");
			   CellValue(i,"ibflag")="R";
		   	}			 
		}
	}
//    /*
//	* 그리드 편집 포커스 이벤트 
//	*/
//	function sheet1_OnAfterEdit(sheetObj,Row,Col){
//		with(sheetObj){   
//			document.form.modifyFlag.value="Y";	
//			if (ColSaveName(Col) ==prefix1+"manualupdate"){
//				CellValue2(Row,prefix1+"manualupdatetime") ="00:00";
//			}
//			if (ColSaveName(Col) ==prefix1+"manualupdate" || ColSaveName(Col) ==prefix1+"manualupdatetime"){
//				CellValue2(Row,prefix1+"mnl_set_dt") =CellValue(Row,prefix1+"manualupdate")+CellValue(Row,prefix1+"manualupdatetime");  
//				SelectCell(Row+1,prefix1+"systemtime",false);				
//			}	
//		}
//	}
//	
//	function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift){
//		with(sheetObj){   
//			if(KeyCode == 46){
//				if (ColSaveName(Col) ==prefix1+"manualupdate"){
//					document.form.modifyFlag.value="Y";	
//					CellValue2(Row,prefix1+"manualupdate") = "";	
//					CellValue2(Row,prefix1+"manualupdatetime") = "";		
//					CellValue2(Row,prefix1+"mnl_set_dt") = "";
//				}
//				if (ColSaveName(Col) ==prefix1+"manualupdatetime"){
//					document.form.modifyFlag.value="Y";	
//					CellValue2(Row,prefix1+"manualupdatetime") ="";	
//				}		
//			}
//		}
//	}
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		with(sheetObj){   
			document.form.modifyFlag.value="Y";	
			if (ColSaveName(Col) =="manualupdate"){
				if(ComIsNull(Value)){
					CellValue2(Row,"manualupdate") = "";	
					CellValue2(Row,"manualupdatetime") = "";		
					CellValue2(Row,"mnl_set_dt") = "";					
				} else {
					if(CellValue(Row,"manualupdatetime").length<4){
						CellValue2(Row,"manualupdatetime") ="00:00";
					} else {
						CellValue2(Row,"mnl_set_dt") = CellValue(Row,"manualupdate")
															 + CellValue(Row,"manualupdatetime");
					}
				}
			}
			if (ColSaveName(Col) =="manualupdatetime"){  
				if(CellValue(Row,"manualupdatetime").length<4){
					CellValue2(Row,"manualupdatetime") ="00:00";
				} else {
					CellValue2(Row,"mnl_set_dt") = CellValue(Row,"manualupdate")
														 + CellValue(Row,"manualupdatetime");
				}		
			}	
		}		
	}
	
	/*
	* 그리드 선택 포커스 이벤트 
	*/
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		with(sheetObj){  
			if (ColSaveName(NewCol) =="mnl_set_usr_id"){
				SelectCell(NewRow+1,"manualupdate",false);
			}
		}
	}
	
	/*
	*체크 박스 여부에 따라 수정여부 
	*/
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){ 		 
//		with(sheetObj){
//			if (CellValue(Row,"systemdate").length>0 || CellValue(Row,"systemtime").length>0
//				||CellValue(Row,"manualupdate").length>0 || CellValue(Row,"manualupdatetime").length>0){
//				document.form.modifyFlag.value="Y";	
//				if (Row == 1){
//					CellValue(Row,"ntc_flg")="1";  
//				} 
//			}else{
//				CellValue(Row,"ntc_flg")="1";  
//			} 
//			
//		}
	}
	
	 
	/* 개발자 작업  끝 */