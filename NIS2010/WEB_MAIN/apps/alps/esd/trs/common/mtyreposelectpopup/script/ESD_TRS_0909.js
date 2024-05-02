/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0909.js
*@FileTitle : 엠티리포
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-19
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-03-19 eunju son
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0909 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0909() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetObjSingle; //Single Transportation opener
var preSelectRow = 0;

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

	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	//html컨트롤 이벤트초기화
	initControl();
	
}

	/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	    //???? ????
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation?? manual? ???? ??? ????. <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}

	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
	function bkgno_keyup() {
	    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value = "";
	    else
		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
		*/
	}

	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
	    //입력Validation 확인하기
	//    return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	    //?????? ???
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	    //???????
	//    ComKeyOnlyNumber(event.srcElement);
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
				style.height = GetSheetHeight(7);
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo(1, 1, 7, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(6, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle0 = "|Seq|EQ No|TP/SZ|VVD|Mty Repo BKG NO";
			//	var HeadTitle1 = "|Seq|EQ No|TP/SZ|VVD|||";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
			//	InitHeadRow(0, HeadTitle1, true);
				HeadRowHeight = 10;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,    30, daCenter, true, "ibcheck",               false, "", dfNone, 0, true,   true );
				InitDataProperty(0, cnt++, dtData,          60, daCenter, true, "seq",                false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          110, daCenter, true, "eq_no",            false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          70, daCenter, true, "eq_tpsz_cd",            false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          100, daCenter, true, "vvd",                false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          100, daCenter, true, "bkg_no",                false, "", dfNone, 0, false,  false);
		
					
			//AllowEvent4CheckAll = false;
			}
		break;		
	}	
			
}

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	function processButtonClick(){
		try {
			var sheetObject = sheetObjects[0];

		    var formObject = document.form;
			var srcName = window.event.srcElement.getAttribute("name");
			
			// form 이름에 주의하시기 바랍니다. 
			with(document.form) {
				switch (srcName) {
					case "btn_close":
					window.close();
					break;
					
					case "btn_new":
					resetHeader(sheetObject, formObject);
					break;

					case "btn_ok":
						applyCntrSelect(sheetObjects[0]);
					break;
					
					case 'btns_mty_bkg_no':
						rep_Multiful_inquiry(srcName);
						break;
						
					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
				} // end switch
			}// end with
			
		} catch(e) {
			if( e = "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}		

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,return_val) {
	var formObject = document.form;
	formObject.mty_bkg_no.value = rowArray;
}

		
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {

	sheetObj.ShowDebugMsg = false;

	if( sAction == IBSEARCH) {

	      //조회
			formObj.f_cmd.value = SEARCH01;
			
			if( formObj.mty_bkg_no.value == "" ||formObj.mty_bkg_no.value == null ) return;
			
			 var queryStr = '';

			sheetObj.DoSearch4Post("ESD_TRS_0909GS.do", TrsFrmQryString(formObj), queryStr, false);

		
	}
}
/*
function applyCntrSelect(sheetObj){

	var openerMainSheet = opener.sheetObjects[0];
	var checkList = openerMainSheet.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var ibcheckList = sheetObj.FindCheckedRow('ibcheck');
	var ibcheckArray = ibcheckList.split('|');
	var ibcheckCnt = ibcheckArray.length-1; 

	for(var k=0; k<ibcheckArray.length-1; k++){

			openerMainSheet.CellValue(checkArray[k], 'eq_no') = sheetObj.CellValue(ibcheckArray[k], 'eq_no');

	}
	
	window.close();
	
}*/

function applyCntrSelect(sheetObj){

	var openerMainSheet = opener.sheetObjects[0];
	var checkList = openerMainSheet.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var ibcheckList = sheetObj.FindCheckedRow('ibcheck');
	var ibcheckArray = ibcheckList.split('|');
	var ibcheckCnt = ibcheckArray.length-1;
	var ibcheckArray_1 =ibcheckList.split('|');

	
	var checkLength = 0;
	
	
	if( checkArray.length > ibcheckArray.length )  
		checkLength = ibcheckArray.length;
	else
		checkLength = checkArray.length; 

	var k=0;
	var j=0; 

		while( k <= checkArray.length-2 ){
			j=0; 
			while( j <= ibcheckArray.length-2 ){

				if( (k <= checkArray.length-2) && ( j <= ibcheckArray.length-2) ){
						
					if( openerMainSheet.CellValue(checkArray[k], 'eq_tpsz_cd') == sheetObj.CellValue(ibcheckArray[j], 'eq_tpsz_cd')  ){
						if( ibcheckArray_1[j] != 'Y' ){
							openerMainSheet.CellValue(checkArray[k], 'eq_no') = sheetObj.CellValue(ibcheckArray[j], 'eq_no');
							ibcheckArray_1[j] = 'Y';
							k++;
							j=0;
						}else{
							j++;
						}
					}else{
						j++;
					}
				}else{
					j++;
				}

			}
			k++;
		}
	
	window.close();
	
}


/**** header부분을 reset한다. ****/
function resetHeader(sheetObj,formObj){
	
		
	formObj.mty_bkg_no.value='';
	sheetObj.RemoveAll();
	
}
