/*****************************************************
 * history
 * 2010.12.15 김영철 [] IRG상 BKG&Temp Flag 적용
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var isFirst = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;
	
	try {
		var opener = window.dialogArguments;
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_apply":
				var result = 
				doActionIBSheet2(sheetObject, sheetObject1, formObject, IBSAVE);

				opener.researchScreen();
				//window.opener.researchScreen();
				if(result){
					window.close();					
				}

			break;
	        case "btn_close":
	        	window.close();
		        break;			
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,sheet2LoopCnt) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				style.height = 140 ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(18, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Seq.|COP No.|Container No.|Current Activity|Location\n(Yard / Zone)|Actual\nDate / Time|Planned\nDelivery Date / Time|Estimated\nDelivery Date / Time|Estimated\nTotal Cost(USD)" ;
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq,    50, daCenter, false, "", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  160, daCenter, false, "cop_no",  false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,   85, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  230, daCenter, false, "act_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,   80, daCenter, false, "nod_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden,100, daCenter, false, "act_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  170, daCenter, false, "planed_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  170, daCenter, false, "est_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight,  false, "estm_cost", false, "", dfNullInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 95, daRight, false, "bkg_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "cop_sts_cd", false, "", dfNone, 0, false, true);
				
		
				// header 테이블의 컬럼값과 맞추기 위해서... 컬럼명을 임으로 사용했다.
				// 첫번째것은 ioBndCd 값이고  두번째는 copCostActGrpCd 이다. 또한 세번째는 PCTL_NO, 네번쩨는 org_nod_cd이다 착오없길.
				//InitDataProperty(0, cnt++, dtHidden, 95, daRight, false, "ob_itchg_ctnt", false, "", dfNone, 0, false, true);
				//InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "ib_itchg_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 95, daRight, false, "", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "pctl_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "cop_sub_sts_cd", false, "", dfNone, 0, false, true);
				//InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "max_grp_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "max_dtl_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, false, "ioBndCd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);				
			}
		break;

		case 2:      //IBSheet2 init
			with (sheetObj) {
				var newTitle = "";
				var loopCnt = 4;
				
				if(sheet2LoopCnt != null) {
					loopCnt = parseInt(sheet2LoopCnt);
				}
				if(loopCnt > 0) {
					for(var i = 0; i < loopCnt; i++) {
						newTitle += "|" + "Location\n(Yard / Zone)|Mode";
					}
				} else {
					newTitle = "|Location\n(Yard / Zone)|Mode";
				}

				var aryTitle = newTitle.split("|");
				var colCnt = aryTitle.length - 1;
				var colcount = colCnt + 7 ; 
                	
				//전체 너비 설정
				style.height = 190 ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(colcount+1+1, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
				var HeadTitle  = "Select|PCTLNO" + newTitle + "|Location\n(Yard / Zone)|Estimated\nDelivery Time|Estimated\nTotal Cost|Combined|TmpFlg" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				var modbsize = 70 ;
				var ydbsize = 110;
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck, 50, daCenter, true, "chk",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "pctl_no", false, "", dfNone, 0, false, true);
			
				for (var i = 0; i <loopCnt; i++) {
					InitDataProperty(0, cnt++, dtData, ydbsize, daCenter, true, "", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, modbsize, daCenter, true, "", false, "", dfNone,0, false, true);
				}
				InitDataProperty(0, cnt++, dtData,  ydbsize, daCenter, true, "", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  150, daCenter, true, "", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  100, daRight, true, "est_dlv_tm", false, "", dfNullInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  100, daCenter, true, "est_tot_cost", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden,100, daRight, true, "inlnd_rout_tmp_flg", false, "", dfNone, 0, false, true); 
				InitDataProperty(0, cnt++, dtHidden,100, daRight, true, "io_bnd_cd", false, "", dfNone, 0, false, true); // 2008-06-20 Combined Flag 추가
				InitDataProperty(0, cnt++, dtHidden,100, daRight, true, "", false, "", dfNone, 0, false, true); // 2008-06-20 Combined Flag 추가	
						
			}
		break;
	}
}

// Sheet 조회 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	if(formObj.f_cmd.value == '') {
		switch(sAction) {
			case IBSEARCH:      //조회(화면 로딩후 자동조회) 
		
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCHLIST;
					
					sheetObj.DoSearch4Post("ESD_SCE_0009Search.do", SceFrmQryString(formObj));
				
					if(sheetObj.RowCount == 0){
						//ComShowMessage(ComGetMsg('COM12113', 'Possible Mode Infomation')) ;
						ComShowMessage('COP has been closed');
						break;
					}
					
					formObj.f_cmd.value = SEARCHLIST02;
					var queryStr = sheetObj.GetSaveString(true);
				
					var sXml = sheetObjects[1].GetSearchXml("ESD_SCE_0009Search2.do",queryStr+"&"+SceFrmQryString(formObj),"",false);
					sheetObjects[1].LoadSearchXml(sXml);
	
					var sheet2MaxCnt = sheetObjects[1].EtcData("maxCnt");
					var sxml2 = sheetObjects[1].EtcData("sxml2");

					sheetObj.RemoveEtcData();
					sheetObjects[1].RemoveAll();
					sheetObjects[1].Reset();
					initSheet(sheetObjects[1],2,sheet2MaxCnt);
					sheetObjects[1].LoadSearchXml(sxml2);
				}
				
			break;
		}
	}
}
    
// Apply 처리
function doActionIBSheet2(sheetObj1, sheetObj2, formObj,sAction) {
	sheetObj1.ShowDebugMsg = false;
	switch(sAction) {
		case IBSAVE:
			if(validateForm(sheetObj2,formObj,sAction)) {
				formObj.f_cmd.value = MULTI01;
				sheetObj1.DoAllSave("ESD_SCE_0009Update.do", SceFrmQryString(formObj));
				return true;
			}else{
				return false;
			}
		break ;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj) {
		switch(sAction){
			case IBSAVE :
				if(sheetObj.CheckedRows("chk")==0){
					ComShowMessage(ComGetMsg('COM12113', 'Possible Mode Infomation')) ;
					return false ;
				}
				var iCheckRow = sheetObj.FindCheckedRow("chk");
				var arrRow = iCheckRow.split("|");
				if(sheetObj.CellValue(arrRow[0], "inlnd_rout_tmp_flg")=="Y"){
					if(!ComShowCodeConfirm("SCE90049")) return false ;
				}
//				return true ;
			break ;
			default :
			break ;
		}
	}
	return true;
}
    
function sheet2_OnChange(sheetObj2, row, col){
	var pctlNo = sheetObj2.CellValue(row, "pctl_no") ;
	var ioBndCd = sheetObj2.CellValue(row, "io_bnd_cd") ;
	var sheetObj1 = sheetObjects[0] ;
	var rowCnt    = sheetObj1.RowCount ;
    	
	for(i=1; i<=rowCnt; i++){
		sheetObj1.CellValue2(i, "pctl_no") = pctlNo ;
		sheetObj1.CellValue2(i, "io_bnd_cd") = ioBndCd ;
	}
}
    
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if(ErrMsg==""){			
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		ComShowMessage(ComGetMsg('SCE90013')) ;
	}
}