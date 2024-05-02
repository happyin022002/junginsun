/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0071GS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 2.0
* 2008-03-03 minestar
* 1.0 최초 생성
* 2009-03-10 JSAN [N200903100120] [SCEM] COP History 화면 보완 요청; Event Date 컬럼을 Event 컬럼의 우측에 위치
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 var sheetObj = sheetObjects[0];
	 var formObj  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":

				if(validateForm(sheetObj, formObj, IBSEARCH)){
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
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
		case 1:	  //IBSheet1 init
			with (sheetObj) {

				style.height = GetSheetHeight(10);

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(19, 5, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "SEQ|COP No.|CNTR No.|BKG No.|Event|Event Date|Tp/Sz|Master|MST COP NO|BKG Status|COP Status|RCV Term|O/B Route|Oecan Route|I/B Route|Del Term|User ID|Unmatched" ;
				var HeadTitle1 = "SEQ|COP No.|CNTR No.|BKG No.|Event|Event Date|Tp/Sz|Master|MST COP NO|BKG Status|COP Status|RCV Term|O/B Route|Oecan Route|I/B Route|Del Term|User ID|Unmatched" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	35,		daCenter,	true,	"seq",					false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cop_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,		daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	90,		daCenter,	true,	"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,	   	35,		daCenter,	false,	"r_bkg_no_split",	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	true,	"event",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft,		true,	"cre_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	40,		daCenter,	true,	"cntr_tpsz_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"mst_lcl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"mst_cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	70,		daCenter,	true,	"bkg_sts_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"cop_sts_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"cop_sub_sts_cd",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"r_term",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		true,	"ob_route",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		320,	daCenter,	true,	"ocn_route",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		true,	"ib_route",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"d_term",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"cre_ofd_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"umch_sts_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"ob_bkg_tro_no",		false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"ib_bkg_tro_no",		false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"totcnt",			false,		  "",	   dfNone,   	0,	 		false,	   false);				
				style.height = GetSheetHeight(23) ;
			//	DataLinkMouse = true;
		   }
			break;
	}
}

 
    
  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch(sAction) {
		case IBSEARCH:	  //조회
        	formObj.page_no.value = "1";		
			formObj.f_cmd.value = SEARCHLIST ;
			sheetObj.DoSearch4Post("ESD_SCE_0071GS.do", SceFrmQryString(formObj));
	
			break;

	   case IBDOWNEXCEL:
			  sheetObj.Down2Excel(-1, false, false, true);
			  break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    var result = true;
	if(sAction == IBSEARCH) {
		// 검색 조건 입력 여부
		if( !isInputField(formObj) ) {
			result = false ;
		//} else if( !ComIsEmpty(formObj.bkg_no) && !ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No
	    } else if( !ComIsEmpty(formObj.bkg_no) && ! ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No		
			result = false ;
		//} else if( !ComIsEmpty(formObj.bkg_no_split) && !ComChkObjValid(formObj.bkg_no_split, 2, "BKG No Split") ) { // BKG NO Split
		//	result = false ;
		} else if( !ComIsEmpty(formObj.bl_no) && !ComChkObjValid(formObj.bl_no, 12, "BL No") ) { // BL No
			result = false ;
		} else if( !ComIsEmpty(formObj.cntr_no) && !ComChkObjValid(formObj.cntr_no, 11, "Container No") ) { // Container No
			result = false ;
		} else if( !ComIsEmpty(formObj.cop_no) && !ComChkObjValid(formObj.cop_no, 14, "COP No") ) { // Cop No
			result = false ;
		}
	}

	return result;
}

function isInputField(formObj){
	var result    = false ;
	var fieldType = null ;
	for(i=0; i<formObj.length; i++){
		fieldType = formObj[i].type

		if((fieldType=="checkbox" || fieldType=="radio")){
			if(formObj[i].checked){
				result = true ;
				break ;
			}
		}
		else if(fieldType!="hidden" && !formObj[i].readOnly){
			if(!ComIsEmpty(formObj[i])){
				result = true ;
				break ;
			}
		}
	}

	if(!result){
		ComShowMessage(ComGetMsg('SCE90016')) ;
        formObj.bkg_no.focus() ;
	}
	return result ;
}

function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt = sheetObj.CellValue(3, "totcnt");
	
	if(sheetObj.TotalRows > 0){
		sheetObj.TotalRows = totalCnt;
	}
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
	formObj.page_no.value = PageNo;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch4Post("ESD_SCE_0071GS.do", selectVal, "cur_page=" + PageNo, true);
}

function ComChkObjValid(obj, len, msg) {
	var result = true ;

	if(getLenByByte(obj.value)!==len){
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus() ;
        result = false ;
	}

	return result ;
}

function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj = document.form;
		if( validateForm(formObj) ) {
			formObj.f_cmd.value = "" ;
	//		formObj.target = "_self" ;
	//		formObj.action = "ESD_SCE_0002.do" ;
	//		formObj.submit() ;
		}
	}
}

function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}

// Container No. 의 CheckDigit 을 설정.
function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo = obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = cntrNo;
		return;
	}
	ComChkObjValid(obj, 'eng_num', true, 10);
	var sum = 0;
 	cntrNo = cntrNo.toUpperCase();

	//for(var i=0;i<10;i++){
	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
	//}
	sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
 
	var mod = sum % 11;

	if (mod == 10) mod =0;

	if( isNaN(mod)){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = obj.value;
	}else{
		obj.value = 	cntrNo.substr(0,10);		
		document.getElementById(bitTarget).value = mod;
		document.getElementById(valueTarget).value = obj.value + mod;
	}
}