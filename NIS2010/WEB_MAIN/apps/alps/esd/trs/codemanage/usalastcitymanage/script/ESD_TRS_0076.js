/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0076.js
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-09-22 juhyun
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
 * @class ESD_TRS_0076 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0076() {
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
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];

		 /*******************************************************/
		 var formObject = document.form;


		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_new":
					formObject.reset();
					sheetObject.RemoveAll();
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btn_save":
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;



			} // end switch
		}catch(e) {
    		if( e == "[object Error]") {
                errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {

		   case IBSEARCH:      //조회

				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TRS_0076GS.do", TrsFrmQryString(formObj));
				break;

			case IBSAVE:        //저장

				formObj.f_cmd.value = MULTI;
				var savexml = sheetObj.DoSave("ESD_TRS_0076GS.do", TrsFrmQryString(formObj),-1,false);
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;  

			case IBINSERT:	  //입력
				
				  //생성 후 기본값 설정하기
				  var Row = sheetObj.DataInsert(-1);
				  sheetObj.CellValue2(Row, 6) = document.form.userid1.value.toUpperCase();
				  sheetObj.CellValue2(Row, 7) = "TAREA";
				  sheetObj.SelectCell(Row, "org_loc_cd");

				  //hidden값에 대문자값을 셋팅
				  document.form.userid1.value = document.form.userid1.value.toUpperCase();
				  document.form.userid2.value = document.form.userid1.value.toUpperCase();
				break;

			 case IBCOPYROW:        //행 복사

				sheetObj.DataCopy();
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

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		var formObject = document.form;
		var sheetObject= sheetObjects[0];
		doActionIBSheet(sheetObject,formObject,IBSEARCH);		
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {

					style.height=GetSheetHeight(10);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1,10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false,false)

					var formObject = document.form;
					var HeadTitle = "Del.|STS|Seq.|Origin Location|Destination Location|Last USA City|Created User ID|Created Office";



					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,  daCenter,  false,    "");
					InitDataProperty(0, cnt++ , dtStatus,     30,  daCenter,  false,    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,        30,  daCenter,  false,    "",     false,          "",       dfNone,   		0,     true,      true);

					InitDataProperty(0, cnt++ , dtPopupEdit, 150,  daCenter,  false,    "org_loc_cd",     true,          "",      	    dfEngUpKey,		0,	     false,	    true,	  5,	 false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtPopupEdit, 150,  daCenter,  false,    "dest_loc_cd",    true,          "",      	    dfEngUpKey,		0,	     false,	    true,	  5,	 false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtPopupEdit, 150,  daCenter,  false,    "lst_loc_cd",     true,          "",       	    dfEngUpKey,		0,	     false,	    true,	  5,	 false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  false,    "cre_usr_id",     false,          "",       dfNone,   		0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  false,    "cre_ofc_cd",     false,          "",       dfNone,   		0,     false,     false);

					sheetObj.ColHidden(1) = true
				}
				break;
		}
	}

	/**
	 * SHEET1을 클릭했을시 팝업이벤트
	 */
	function sheet1_OnPopupClick(sheetObj, row, col)
	{
			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_051_1";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";

			formObject.hid_row.value=row;   //row값을 hidden값으로 넣음
			formObject.hid_col.value=col;   //col값을 hidden값으로 넣음

		if ( sheetObj.ColSaveName(col) == "org_loc_cd" )
		{
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 772, 450, 'getCOM_ENS_051_1', '1,0,1,1,1,1,1,1,1,1,1,1');
		}
		else    if ( sheetObj.ColSaveName(col) == "dest_loc_cd" )
		{
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 772, 450, 'getCOM_ENS_051_1', '1,0,1,1,1,1,1,1,1,1,1,1');
		}
		else    if ( sheetObj.ColSaveName(col) == "lst_loc_cd" )
		{
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 772, 450, 'getCOM_ENS_051_1', '1,0,1,1,1,1,1,1,1,1,1,1');
		}else{

		}
	}

	/**
	 * popSearchPiCommCodeGrid 프로세스 처리
	 */
	function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
		var myUrl = getPopupURL(POPUP_PI_COMM);
		var myOption = getPopupOption(POPUP_PI_COMM);
		var url;

		if(myWin != null) myWin.close();
		url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
		myWin = window.open(url, "piCommCodePop", myOption);
		myWin.focus();
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){

		sheetObj.ShowDebugMsg = false;

		with(formObj){

			switch(sAction) {

			   case IBSEARCH:      //조회
					break;

				case IBSAVE:        //저장
					break;  

				case IBINSERT:	  //입력
					break;
			}

		}

		return true;
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 현재 화면단위 정확한 사용을 위해 임시적으로 SHEET11이라고 임시로 변환시켜놓았음
	 */
	function sheet11_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){

		var formObject = document.form;

		var col_val = OldCol;

		if(col_val==3 || col_val==4 || col_val==5  )
		{
			var x1 = sheetObj.CellValue(OldRow,OldCol);
			var inputStr = delSpace(x1);

			for (var i = 0; i < inputStr.length; i++)
			{
				//if(repeat =="Y"){
				 var oneChar = inputStr.charAt(i)
				 if (oneChar != "")
				 {
					   if ( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) ){
						   continue;
					   }else {
						   var errMessage = ComGetMsg('COM12127','entered data','','');  
							ComShowMessage(errMessage);
						   
						   sheetObj.SelectCell(OldRow, OldCol, true, sheetObj.CellValue(OldRow, OldCol));
						   break;
						}
				 }else{
					 break;
				 }
			}
		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function sheet1_OnChange(sheetObj, row , col , val){

		var formObject = document.form;
		var inputStr = delSpace(val);
		var colName = sheetObj.ColSaveName(col);

		for (var i = 0; i < inputStr.length; i++)
		{
			 var oneChar = inputStr.charAt(i)
			 if (oneChar != "")
			 {
				   if ( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) ){
					   continue;
				   }else {
					   sheetObj.FocusEditMode = -1;
					   sheetObj.FocusStyle = fsHeavy;
					   var errMessage = ComGetMsg('COM12127','entered data','','');  
						ComShowMessage(errMessage);
					   sheetObj.CellValue(row,col)="";
					   formObject.sheet1.SelectCell(row,col);
					   break;
					}
			 }else{
				 break;
			 }
		}


		//한로우에 중복된 결과가 들어가지 못하도록 한다.
		if(!checkKey(sheetObj, row, col)){
		}else{
			switch(colName){
				case 'org_loc_cd':

					var org_loc_cd_check = formObject.sheet1.CellValue(row, "org_loc_cd");
					
					if(org_loc_cd_check !=""){
						formObject.f_cmd.value = SEARCH01;
						var queryString = "col=sc_no&row="+row+"&searchStr="+val+"&"+TrsFrmQryString(formObject);
						sheetObj.DoRowSearch("ESD_TRS_0076_01GS.do", queryString);

						if(!checkLocal(sheetObj.EtcData('CNT_CD'), row, col)) return;
					}
					break;

				case 'dest_loc_cd':

					var dest_loc_cd_check = formObject.sheet1.CellValue(row, "dest_loc_cd");
					
					if(dest_loc_cd_check !=""){
						formObject.f_cmd.value = SEARCH01;
						var queryString = "col=sc_no&row="+row+"&searchStr="+val+"&"+TrsFrmQryString(formObject);
						sheetObj.DoRowSearch("ESD_TRS_0076_01GS.do", queryString);
						if(!checkLocal(sheetObj.EtcData('CNT_CD'), row, col)) return;
					}
					break;

				case 'lst_loc_cd':

					var lst_loc_cd_check = formObject.sheet1.CellValue(row, "lst_loc_cd");
					
					if(lst_loc_cd_check !=""){
						formObject.f_cmd.value = SEARCH01;
						var queryString = "col=sc_no&row="+row+"&searchStr="+val+"&"+TrsFrmQryString(formObject);
						sheetObj.DoRowSearch("ESD_TRS_0076_01GS.do", queryString);
						if(!checkLocal(sheetObj.EtcData('CNT_CD'), row, col)) return;
					}
					break;
			}
		}
	}

	/**
	 * S/C Number 입력시 존재여부체크 
	 *
	 */
	function checkLocal(value, row, col)
	{
		var formObject = document.form;

		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','Local code!','','');
			ComShowMessage(errMessage);
			formObject.sheet1.CellValue2="";
			formObject.sheet1.SelectCell(row, col);
			return false;
		}else{
			formObject.sheet1.SelectCell(row, col+1);
			return true;
		}
	}


	/**
	 * S/C Number 입력시 존재여부체크 
	 *
	 */
	function checkKey(sheetObj, row, col)
	{
		var formObject = document.form;

		var x1 = sheetObj.CellValue(row, 'org_loc_cd');
		var x2 = sheetObj.CellValue(row, 'dest_loc_cd');
		var x3 = sheetObj.CellValue(row, 'lst_loc_cd');

		if( (x1.length >0 && x2.length >0 ) || (x1.length >0 && x3.length >0 ) || (x2.length >0 && x3.length >0 ) ){
			if( x1 == x2 ){
				var errMessage = ComGetMsg('COM12114','Location data!','','');  
				ComShowMessage(errMessage);				
				sheetObj.SelectCell(row, 'dest_loc_cd');
				sheetObj.CellValue(row,'dest_loc_cd')="";
				return false;	
			}else if( x1 == x3 ){
				var errMessage = ComGetMsg('COM12114','Location data!','','');  
				ComShowMessage(errMessage);				
				sheetObj.SelectCell(row, 'lst_loc_cd');
				sheetObj.CellValue(row,'lst_loc_cd')="";
				return false;	
			}else if( x2 == x3 ){
				var errMessage = ComGetMsg('COM12114','Location data!','','');  
				ComShowMessage(errMessage);				
				sheetObj.SelectCell(row, 'lst_loc_cd');
				sheetObj.CellValue(row,'lst_loc_cd')="";
				return false;	
			}else{
				return true;
			}
		}else{
			return true;
		}
	}


	/**
	 * 순수한 영문인지 체크
	 */
	function isAlpha(obj,gubun,s1)
	{
	  var formObject = document.form;		
	  var inputStr = delSpace(obj);

	  for (var i = 0; i < inputStr.length; i++)
	  {
		 var oneChar = inputStr.charAt(i)
		 if (oneChar != "")
		 {
		   if ( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) ){
			   
		   }else {
			   formObject.sheet1.FocusEditMode = -1;
			   formObject.sheet1.CellFontUnderline(gubun,3) = true;
			   formObject.sheet1.FocusStyle = fsSolid;
			   formObject.sheet1.SelectCell(gubun, s1)
			   return false;
			   break;
			   
			 }
		 }else{
			 break;
		 }

	   }
	}


	/**
	 * 문자열 사이의 공백을 제거
	 */
	function delSpace(str)
	{
		var trimstr = str;
		for (var i=0; i< str.length;i++)
		{
			trimstr = trimstr.replace(' ' ,'');
		}
		return trimstr;
	}


	/**
	 * IBTab Object를 초기화 설정
	 * 탭 ID는 tab1,tab2,...
	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index" , 23 );
				InsertTab(1, "Tanker Index" , 23); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price" , 23); 
				InsertTab(5, "FFA Index" , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}


	/**
	 * tab1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}


	/**
	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";

		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";

		//--------------- 요기가 중요 --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}


	/**
	 * 라디오버튼을 누를시 delete상태변경을 위해서 hidden값으로 반대값을 넣는다.
	 */
	function change_val(){

		var formObject = document.form;
		var sheetObject = formObject.sheet1;
		var change=document.form.stsval.value;

		//라디오버튼시 클리어(sheet)
		formObject.sheet1.RemoveAll();

		//헤더상단 타이틀변경
		if(change=="Y"){
			document.form.stsval.value ="N";
			formObject.sheet1.CellValue2(0, 0) = "Liv.";
			//formObject.btng_rowadd.disabled = true;
			formObject.all.btng_rowadd.style.visibility = "hidden";  //visible
		}else{
			document.form.stsval.value ="Y";
			formObject.sheet1.CellValue2(0, 0) = "Del.";
			formObject.all.btng_rowadd.style.visibility = "visible";  //hidden
		}

		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	  

	/**
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_051_1(rowArray) {

		var formObject = document.form;

		//팝업에서 멀티로 선택시에 대비해서 만들어놓았음!!!		
		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			var row_val = formObject.hid_row.value;   //row값을 hidden값으로 넣음
			var col_val = formObject.hid_col.value;   //col값을 hidden값으로 넣음
			var in_val = colArray[3];
			formObject.sheet1.CellValue2(row_val, col_val) = in_val;						
		}
	}