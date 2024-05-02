/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_EAS_0904GS.jsp
*@FileTitle : Route UnMatch List Detail 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-03
*@LastModifier : HoSam_Lee
*@LastVersion : 1.0
* 2007-12-03 HoSam_Lee
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**
	 * @extends Bkg
	 * @class ESD_EAS_0903 : 예)Route UnMatch List 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0904() {
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
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	

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

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	   //khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
       initSheet(sheetObjects[i],i+1);
       //khlee-마지막 환경 설정 함수 추가
       ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

}


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

//	 var sheetObj = docObjects[0];
//	 var formObj  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_close":
			    window.returnValue = null;
			    window.close();
			break;
		}
	}catch(e){
		if( e == "[object Error]") {
			showErrMessage(getMsg('COM12111')) ;
		} else {
			ComShowMessage(e);
		}
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.DoSearch4Post("ESD_EAS_0904GS.do", EasFrmQryString(formObj));
		break;
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
				// 높이 설정
				style.height = GetSheetHeight(13);
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
				InitRowInfo( 2, 1, 10);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(27, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " Seq.|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail"
				+"|BKG Detail|BKG Detail|BKG Detail|S/O(per CNTR)|AR Inv(per BKG)|CCT Ofc.|Ex.Rate|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;

				var HeadTitle1 = " Seq.|Booking No.|B/L No.|POR|POL|POD|DEL|S/C No.|RFA No.|Cntr No.|Bnd|Term|TRO Ofc.|TRO Loc."
				+"|TRO Q'ty|TRO Amt|Exp Inv.(P)|Rev.(R)\n(BKG)|CCT Ofc.|Ex.Rate|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				HeadRowHeight = 12;
				
				//데이터속성	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	 40,	daCenter,  true,	"seq",				false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		 85,	daCenter,  false,	"bkg_no",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     85,	daCenter,  false,	"bl_no",       false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"por_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"pol_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,  false,	"pod_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"del_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  false,	"sc_no",      	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     80,	daCenter,  false,	"rfa_no",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtHidden,	 70,	daCenter,  false,	"cntr_qty",   	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  false,	"cntr_no",   	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"bnd",         false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"term",        false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"tro_ofc",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_loc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_qty",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,	true,	"tro_amt",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 90,	daRight,    true,	"exp_inv",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 100,	daRight,    true,	"ar_rev",      false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,		 60,	daRight,    true,	"rev_exp",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,   true,	"cct_ofc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daRight,    true,	"ex_rate",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"tro_id",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"so_ofc",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"so_id",       false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"rating_ofc",  false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"rating_id",   false,		  "",	   dfNone,    0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"sts",         false,		  "",	   dfNone,   	0,	 		false,	   false); 
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"trm_type",    false,		  "",	   dfNone,   	0,	 		false,	   false);
				
				//style.height = GetSheetHeight(10) ;
				//DataLinkMouse = true;
				
				HeadRowHeight = 20 ;
		   }
			break;

	}
}

function sheet_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null){
		showErrMessage(errMsg);
	}
}

