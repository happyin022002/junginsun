/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0039.js
*@FileTitle : S/P Performance Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2009.07.22 조풍연
* 1.0 최초생성
*----------------------------------------------------------
* History
* 2010.11.03 최종혁 1.1 [] Performance Evaluation 조회 로직 재작성
* 2010.11.08 최 선     1.2 [CHM-201006928] Performance Evaluation Save 후, 불필요한 재조회 프로세스 제외 처리
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0039 : Booking 
 */
function ESD_TRS_0039() {
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

                case "btng_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                    
                case "btng_provider":
                    rep_OnPopupClick();
                    break;
 
				case "btns_calendar":
				getCalendar();
				break;
            }
        }catch(e) {
            if( e == "[object Error]") {
                errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
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
	    //Axon
	    /*
	    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
	    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	    */
	}
	

	/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	//            ComKeyOnlyAlphabet('uppernum');
	}
	
	/**
	 * BKG Creation. <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//            form.boo_bkg_no.readOnly =!form.manual.checked;
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
	//            return ComChkObjValid(event.srcElement);
	}
	
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	//            ComClearSeparator(event.srcElement);
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	//            ComKeyOnlyNumber(event.srcElement);
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
                    // 높이 설정
                    style.height = 370;
                    //전체 너비 설정
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
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "STS|SEQ|Work Order\nNumber|||Service Provider|Service Provider|W/O Issue\nDate|Evaluation\nItem # 1 |Evaluation\nItem # 2|Comments|Creation\nDate|Creation\nUser Name";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,    30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,       40,    daCenter,  true,    "");
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "trs_wo_key",			false,          "",      dfNone,      0,     false,       false,          4);
					InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  true,	"trsp_wo_ofc_cty_cd",	false,          "",      dfNone,      0,     false,       false,          4);
					InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  true,	"trsp_wo_seq",			false,          "",      dfNone,      0,     false,       false,          4);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "wo_vndr_seq",			false,          "",      dfNone,      0,     false,       false,          4);

                    InitDataProperty(0, cnt++ , dtData,		 300,   daLeft,  true,      "vndr_lgl_eng_nm",		false,          "",      dfNone,      0,     false,       false,          5);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "cre_dt",				false,          "",      dfDateYmd,   0,     false,       false,          4);
                    InitDataProperty(0, cnt++ , dtCombo,     80,    daCenter,  true,    "wo_ev_grd_cd",			false,          "",      dfNone,      0,     true,        true,           5);
                    InitDataProperty(0, cnt++ , dtCombo,     80,    daCenter,  true,    "shpr_ev_grd_cd",		false,          "",      dfNone,      0,     true,		  true,           4);

                    InitDataProperty(0, cnt++ , dtData,      200,   daCenter,  true,    "ev_ctnt",				false,          "",      dfNone,      0,     true,		  true,           225);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  true,    "cre_dt_1",				false,          "",      dfDateYmd,   0,     false,       false,          4);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "cre_usr_id",			false,          "",      dfNone,      0,     false,       false,          5);

					InitDataCombo(0, 'wo_ev_grd_cd', wo_ev_grd_cdText,wo_ev_grd_cdCode);
					InitDataCombo(0, 'shpr_ev_grd_cd', shpr_ev_grd_cdText,shpr_ev_grd_cdCode);
               }
               break;
           
        }
    }
 


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

          case IBSEARCH:      //조회
          		if(formObj.from_date.value == '' || formObj.to_date.value == ''){
					if(formObj.wonumber.value == ''){
						ComShowCodeMessage("TRS90124");
						return false;
					}
				}
				
				var days_between = ComGetDaysBetween(formObj.from_date , formObj.to_date) ;  // 조회 기간
		   		if( days_between   < 0) {
					ComShowCodeMessage("TRS90118");
					formObj.from_date.focus();
					return false;
				} 
				if ( days_between > 30 ) {
					ComShowMessage(" Possible inquiry period is limited to 1 month.");
					return false;
				}

				formObj.hid_from_date.value = removeBar(formObj.from_date.value);
				formObj.hid_to_date.value = removeBar(formObj.to_date.value);
				formObj.hid_provider.value = formObj.combo_svc_provider.Code;	

				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TRS_0039GS.do", TrsFrmQryString(formObj));
                break;

          case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI;
				var savexml = sheetObj.DoSave("ESD_TRS_0039GS.do", TrsFrmQryString(formObj),-1,false);
				break;         
        }
    }
    
function rep_OnPopupClick()
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}


/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	var comboObj = document.combo_svc_provider;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);

		comboObj.Text = colArray2;
		document.form.svc_provider.value = comboObj.GetText(comboObj.Text, 1);
	}
} 
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }



	/**
	 * 라디오버튼을 누를시 period
	 */
	function fnchange_period(){

		var formObject = document.form;
		var sheetObject = formObject.sheet1;

		if ( formObject.radio_period[0].checked == true ) {
			formObject.hid_period.value="I";   //Issued
		}else if( formObject.radio_period[1].checked == true ) {
			formObject.hid_period.value="E";   //Evaluated
		}else{
			formObject.hid_period.value="";
		}
	}


	//'포커스주기
	function fun_Focus(obj){
		var val = removeBar(obj.value);
		obj.value = val;
		obj.select();
	}

	//'-' 없애기
	function fun_Focus_del(obj){
		var val = removeBar(obj.value);
		obj.value = val;
		obj.select();
	}

	//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
	function removeBar(str) {
	   var value = "";
	   for ( var i = 0; i < str.length; i++ ) {
		  var ch = str.charAt(i);
		  if ( ch != '-' ) value = value + ch;
	   }
	   return value;
	}


	//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
	function commaadd(str) {
	   var value = "";
	   for ( var i = 0; i < str.length; i++ ) {
		  var ch = str.charAt(i);
		  if ( ch == ',' ){
			  value = value + "','";
		  }else{
			  value = value + ch;
		  }
	   }
	   return value;
	}

	//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
	function removeDbval(str) {
	   var value = "";
	   for ( var i = 0; i < str.length; i++ ) {
		  var ch = str.charAt(i);
		  if ( ch != '　' ) value = value + ch;
	   }
	   return value;
	}



	
	/*
	 * 멀티 달력 입력 Pop-Up
	 */
	//var cal = new ComCalendarFromTo();

	function getCalendar() {
		var cal2 = new ComCalendarFromTo();
		cal2.displayType = "date";
		cal2.select(document.form.from_date,document.form.to_date,'yyyy-MM-dd');
	//	cal.select(document.form.from_date, 'from_date', document.form.to_date, 'to_date', 'yyyy-MM-dd');	
	}

	/**
	 * 외부 콤보박스의 리스트 가져오기
	 **/
	function getVendorComboList()
	{
		var formObj = document.form; 
		var vendorNo = formObj.combo_svc_provider.Text ;
		getVendorCombo(formObj.combo_svc_provider, sheetObjects[0], formObj, vendorNo,'','');

	}



	function combo_svc_provider_OnKeyDown(combo, keycode,shift)
	{
		if(keycode == 13)
		{
			searchVendorName(combo);
		}
	}

	function searchVendorName(combo)
	{
		var formObject = document.form;
		formObject.f_cmd.value = SEARCH11;
		formObject.hid_provider.value = combo.Text

		document.form.svc_provider.value = combo.GetText(combo.Text,1);
	}



	/**
	 * service provider combo 선택시 textfield의 값 변경하는 이벤트
	 **/
	function combo_svc_provider_OnChange(combo, Index_Code, Text)
	{
		var formObj = document.form;
		document.form.svc_provider.value = combo.GetText(Index_Code,1);
		formObj.hid_provider.value = formObj.combo_svc_provider.Code;
	}


	/**
	 * service provider combo 선택시 textfield의 값 변경하는 이벤트
	 **/
	function combo_svc_provider_OnBlur(combo, Index_Code, Text)
	{
		//var vndr =combo.GetText(Index_Code,1);
		//if(vndr ==""){
		//	document.form.svc_provider.value="";
		//}

	}


	/**
	 * 팝업호출
	 */
	function wo_OnPopupClick(val)
	{

			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getTRS_ENS_906";
			var xx1=val;  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
	
			var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+xx1;
			ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 320, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');

	}
	  
	/**
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getTRS_ENS_906(rowArray,returnval) {

		var formObject = document.form;

			var x1=document.form.wonumber.value;
			if(x1==""){
				document.form.wonumber.value = rowArray;
				formObject.wonumber.focus();
			}else{
				document.form.wonumber.value = document.form.wonumber.value+","+rowArray;
				formObject.wonumber.focus();
			}

	
	}




	/**
	 * SOcheck.
	 */
	function val_check(obj,val){

		var formObject = document.form;
		var inputStr=obj.value;
		var value=obj.value;
		var charval = "Y";
		var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
		lvobj=obj.value;

		if( lvobj != "" ) {
			for (var i = 0; i < inputStr.length; i++)
			{
				 var oneChar = inputStr.charAt(i)
				 if (oneChar != "")
				 {
					   if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == "," )   ){
					   }else {
						   charval ="N";
						   break;
					   }
				 }else{
					charval ="N";
					break;
				 }
			}

			if(charval=="Y"){
			}else{
				var errMessage = ComGetMsg('COM12130',val,'','');  
				ComShowMessage(errMessage);
				obj.value = "";
				obj.focus();
			}
		}

	}


	/**
	 * sheet click시 일어나는 이벤트
	 **/
	function sheet1_OnChange(sheetObj, row, col, value)
	{
		var formObj = document.form;
		var sheet1_x1 ="";
		var sheet1_x2 ="";
		var sheet1_checkval ="";
		var sheet1_x1val ="";
		var sheet1_count =sheetObjects[0].RowCount;
		var sheet1_check ="";
		var charval="Y";

		if(sheetObj.ReadDataProperty(row, col, 0)==6) 
		{	
			return;
		}
		var colName = sheetObj.ColSaveName(col);

			switch(colName){

				case 'ev_ctnt':

					inputStr = sheetObjects[0].CellValue(row, "ev_ctnt");

					if( inputStr != "" ) {
						for (var i = 0; i < inputStr.length; i++)
						{
							 var oneChar = inputStr.charAt(i)
							 if (oneChar != "")
							 {
								   if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == "," )|| (oneChar == "." )   ){
								   }else {
									   charval ="N";
									   break;
								   }
							 }else{
								charval ="N";
								break;
							 }
						}

						if(charval=="Y"){
							//정상적으로 향후 로직첨가!!
						}else{
							var errMessage = ComGetMsg('COM12130','Comments Lgnguage type','','');  
							ComShowMessage(errMessage);
							sheetObjects[0].CellValue2(row, "ev_ctnt") = "";
							formObj.sheet1.SelectCell(row,"ev_ctnt");
						}
					}

				break;

		}
	}