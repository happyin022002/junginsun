/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3903.js
*@FileTitle : Inland Cost Management – Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
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
     * @class ESD_AOC_3903 : esd_aoc_3903 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_aoc_3903() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var opener = window.dialogArguments;
var first_curr_flag = false;
var second_curr_flag = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
//			case "btn_add":
//				if( formObject.grp_radio[1].checked == true ){
//					for( var idx = 0; idx < parseInt(formObject.amt_tier.value); idx++ ){
//						sheetObject.DataInsert(-1);
//					}
//					for( var idx = 1 + parseInt(sheetObject.HeaderRows); idx <= sheetObject.LastRow; idx++ ){
//						if( sheetObject.CellValue(idx, "from") == "" ){
//							sheetObject.CellEditable(idx, "to") = false;
//						}
//					}
//				}
//				break;

			case "btn_apply1":
				if( formObject.grp_radio[0].checked == true ){ //Interval Amount 처리시
					var errFlg = "N";
					var dflt_amt = 0;
					if( formObject.from_amt.value == "" ){
						dflt_amt = 0;
					} else{
						dflt_amt = parseInt(formObject.from_amt.value);
					}
					
					if( formObject.itval_amt.value != "" && formObject.itval_amt.value != "0" ){
						for( var idx = 0 + parseInt(opener.sheetObjects[0].HeaderRows); idx <= opener.sheetObjects[0].LastRow; idx++ ){
							var locGrpCd = "";
							
							if( parseFloat(opener.sheetObjects[0].CellValue(idx,"inlnd_40ft_ttl_amt")) - dflt_amt <= 0 ){
								locGrpCd = "1";
							} else if( dflt_amt == 0 ){
								locGrpCd = String(parseInt((parseFloat(opener.sheetObjects[0].CellValue(idx,"inlnd_40ft_ttl_amt")) - dflt_amt) / parseInt(formObject.itval_amt.value) + 1));
							} else{
								locGrpCd = String(parseInt((parseFloat(opener.sheetObjects[0].CellValue(idx,"inlnd_40ft_ttl_amt")) - dflt_amt) / parseInt(formObject.itval_amt.value) + 2));
							}
							
							var locGrpCdLength = locGrpCd.length;
							if( locGrpCdLength <= 3 ){
								for( jdx = 0; jdx < 3 - locGrpCdLength; jdx++ ){
									locGrpCd = "0" + locGrpCd;
								}
								
								if( opener.sheetObjects[0].CellValue(idx, "curr_cd") == comboObjects[0].Code ){
									opener.sheetObjects[0].CellValue2(idx,"loc_grp_no") = formObject.cnt_cd.value + locGrpCd;
								}
							} else{
								errFlg = "Y";
							}
						}
						
						if( errFlg == "Y" ){
							ComShowCodeMessage("AOC90019");
							return;
						}
					} else{
						ComShowCodeMessage("COM130201","Interval Amount");
						return;
					}
					
					if( formObject.cnt_cd.value != "CN" ){
						window.close();
					} else{
						if( comboObjects[0].Code == "CNY" ){
							first_curr_flag = true;
						} else if( comboObjects[0].Code == "HKD" ){
							second_curr_flag = true;
						}
						ComShowCodeMessage("COM12116","LOC group Apply");
					}
				}
				break;
				
			case "btn_apply2":
				if( formObject.grp_radio[1].checked == true ){ //Amount Tier 처리시
					for( var idx = 0 + parseInt(sheetObject.HeaderRows); idx <= sheetObject.LastRow - 1; idx++ ){
						if( sheetObject.CellValue(idx+1,"loc_grp_cd") != "" ){
							if( parseInt(sheetObject.CellValue(idx,"from")) >= parseInt(sheetObject.CellValue(idx+1,"from")) ){
								ComShowCodeMessage("AOC90013");
								return;
							}
						}
					}
					for( var idx = 0 + parseInt(opener.sheetObjects[0].HeaderRows); idx <= opener.sheetObjects[0].LastRow; idx++ ){
						var grpCd = "";
						for( var jdx = 0 + parseInt(sheetObject.HeaderRows); jdx <= sheetObject.LastRow; jdx++ ){
							if( sheetObject.CellValue(jdx,"loc_grp_cd") != "" ){
								if( parseInt(sheetObject.CellValue(jdx,"from")) <= parseFloat(opener.sheetObjects[0].CellValue(idx,"inlnd_40ft_ttl_amt")) ){
									grpCd = sheetObject.CellValue(jdx,"loc_grp_cd");
								}
							}
							
							if( opener.sheetObjects[0].CellValue(idx, "curr_cd") == comboObjects[0].Code ){
								opener.sheetObjects[0].CellValue2(idx,"loc_grp_no") = grpCd;
							}
						}
					}
					
					if( formObject.cnt_cd.value != "CN" ){
						window.close();
					} else{
						if( comboObjects[0].Code == "CNY" ){
							first_curr_flag = true;
						} else if( comboObjects[0].Code == "HKD" ){
							second_curr_flag = true;
						}
						ComShowCodeMessage("COM12116","LOC group Apply");
					}
				}
				break;

			case "btn_close":
				if( first_curr_flag == true && second_curr_flag == true ){
					window.close();
				} else{
					ComShowCodeMessage("AOC90041");
					return;
				}
				break;


		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("AOC90004");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
function loadPage(){
	for( var i = 0; i < sheetObjects.length; i++ ){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for( var c=0; c < comboObjects.length; c++ ){
		initCombo(comboObjects[c], c+1);
	}
	
	initControl();
	initSet();
}

 
function initCombo(comboObj, comboNo) {
	var idx = 0;
	
	switch(comboObj.id) {
		case "co_curr_cd":
			with(comboObj) {
				if( document.form.cnt_cd.value != "CN" ){
					InsertItem(idx++, document.form.curr_cd.value, document.form.curr_cd.value);
					Code = document.form.curr_cd.value;
					Enable = false;
				} else{
					InsertItem(idx++, "CNY", "CNY");
					InsertItem(idx++, "HKD", "HKD");
					Code = "CNY";
					Enable = true;
				}
				SetColAlign("center")
			}
			break;
	}
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
//    axon_event.addListener('click', 'obj_click', 'manual');    		//Click
//    axon_event.addListener('keyup', 'obj_keyup', 'boo_bkg_no'); 		//Key Up
//    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
}


/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}


/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}


/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur(){
}

/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+"영문대소"입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
		
		default:
	}
}
//Axon 이벤트 처리2. 이벤트처리함수 --- end

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
				//높이 설정
				style.height = GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 23);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, true, false, false) ;

				var HeadTitle1 =  "LOC\nGroup|Amout Tier|Amout Tier";
				var HeadTitle2 =  "LOC\nGroup|From|To";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtData,   		   100,	daCenter, 	true,    	"loc_grp_cd",		false, 		"", 		dfNone, 		0, 			false, 		false, 			 10, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   210,	daCenter, 	true,    	"from",				false, 		"", 		dfNullInteger, 	0, 			false, 		false, 			 10, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   210,	daCenter, 	true,    	"to",      			false, 		"", 		dfNullInteger, 	0, 			true, 		true, 			 10, 	false,	 	false, 		"", 		false);
			}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
//		case IBSEARCH:		//Retrieve
//			if(!validateForm(sheetObj,formObj,sAction)) return;
//	   		formObj.f_cmd.value = SEARCH;
//	   		sheetObj.DoSearch4Post("ESD_AOC_3903GS.do", AocFrmQryString(formObj));
//	   		break;
//	   		
//		case IBDOWNEXCEL:	//Down Excel
//			if(!validateForm(sheetObj,formObj,sAction)) return;
//			sheetObj.Down2Excel(-1, false, false, true);
//			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
//	switch(sAction){
//		case MULTI:
//			//그리드 데이터 없을 경우
//			if( sheetObj.RowCount <= 0 ){
//				return false;
//			}
//			break;
//	}
	
	return true;
}

function initSet(){
	sheetObjects[0].DataInsert(-1);
	sheetObjects[0].CellValue(parseInt(sheetObjects[0].HeaderRows),"from") = 0;
	sheetObjects[0].CellValue(parseInt(sheetObjects[0].HeaderRows),"loc_grp_cd") = document.form.cnt_cd.value + "001";
	change_grp_radio("I");
}
/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
}
 
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var xRow = 0;

	if( sName == "to" ){
		if( sheetObj.LastRow == Row ){
			sheetObj.DataInsert(-1);
		}
//		if( sheetObj.CellValue(Row+1,"from") != 0 ){
//			if( parseInt(Value) <= parseInt(sheetObj.CellValue(Row,"from")) ){
//				alert("abc1");
//				return;
//			}
//			if( sheetObj.CellValue(Row+1,"to") != "" && parseInt(Value) >= parseInt(sheetObj.CellValue(Row+1,"to")) ){
//				alert("abc2");
//				return;
//			}
//		}
		
		var seq = String(Row + 2 - parseInt(sheetObj.HeaderRows));
		var seqLength = seq.length;
		for( var idx = 0; idx < 3 - seqLength; idx++ ){
			seq = "0" + seq;
		}
		sheetObj.CellValue2(Row+1,"loc_grp_cd") = document.form.cnt_cd.value + seq;
		sheetObj.CellValue2(Row+1,"from") = parseInt(Value)+1;
		sheetObj.CellEditable(Row+1, "to") = true;
		sheetObj.SelectCell(Row+1, "to");
	}
}


function change_grp_radio(value){
	if( value == "I" ){
		document.form.from_amt.enabled = true;
		document.form.from_amt.readOnly = false;
		document.form.from_amt.className = "input";
		document.form.itval_amt.enabled = true;
		document.form.itval_amt.readOnly = false;
		document.form.itval_amt.className = "input";
		
		sheetObjects[0].Editable = false;
		ComBtnEnable("btn_apply1");
		ComBtnDisable("btn_apply2");
	} else{
		document.form.from_amt.enabled = false;
		document.form.from_amt.readOnly = true;
		document.form.from_amt.className = "input2";
		document.form.itval_amt.enabled = false;
		document.form.itval_amt.readOnly = true;
		document.form.itval_amt.className = "input2";
		
		sheetObjects[0].Editable = true;
		ComBtnDisable("btn_apply1");
		ComBtnEnable("btn_apply2");
	}
}
