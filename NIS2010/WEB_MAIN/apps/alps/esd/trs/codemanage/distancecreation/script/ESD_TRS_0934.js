/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0934 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0934() {
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

				//조회시 이벤트
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

				//클로즈 버튼을 누를시 팝업화면이 닫힌다.
        	    case "btn_close":
    	            window.close();
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

		//팝업이 온로드 될시에 전화면에서 넘겨준 값을 확인해서 부적절하게 들어온경우는 조회로직을 못타게 하는 부분입니다.
		var formObject = document.form;
		var sheetObject = sheetObjects[0];

		var opner_from_node =formObject.opner_from_node.value;
		var opner_from_zip_code =formObject.opner_from_zip_code.value;
		var opner_to_node =formObject.opner_to_node.value;
		var opner_to_zip_code =formObject.opner_to_zip_code.value;

		if(opner_from_node =="" && opner_from_zip_code =="" ){
		}else{
			//적절한 파라미터 값이 넘어왔을시 자동 조회로직을 호출한다.
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                    // 높이 설정
                    style.height = 240;
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
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "STS|Seq.|From Node|From Node|From\nZip Code|To Node|To Node|To\nZip Code|Distance|Distance|"
                                    +"Converted Distance|Converted Distance|Creation\nDate|Creation\nUser Name";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,				KEYFIELD, CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtDelCheck,  30,   daCenter,  true,    "");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,    30,   daCenter,  true,    "ibflag");      
                    InitDataProperty(0, cnt++ , dtSeq,       40,   daCenter,  true,		"seq");      
                    InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,		"fm_nod_cd",			false,		"",			dfEngUpKey,         0,       false,		false,		5,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      20,   daCenter,  true,		"fm_nod_cd_sub",		false,		"",			dfNone,				0,       false,		false,		2,		false,		true,	   "",	  false);

                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "fm_nod_zip_cd_ctnt",   false,		"",			dfPostNo,			0,		 false,		false,		50,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "to_nod_cd",			false,		"",			dfEngUpKey,         0,       false,		false,		5,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      20,    daCenter,  true,    "to_nod_cd_sub",		false,		"",			dfNone,				0,       false,		false,		4,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "to_nod_zip_cd_ctnt",   false,		"",			dfPostNo,			0,       false,		false,		50,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight,   true,    "bzc_dist",				false,		"",			dfFloat,			2,       false,		false,		100,	false,		true,	   "",	  false);

                    InitDataProperty(0, cnt++ , dtCombo,     40,    daCenter,  true,    "dist_meas_ut_cd",		false,		"",			dfNone,				0,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,     120,    daRight,   true,    "conv_dist",			false,		"",			dfFloat,			6,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtCombo,     40,    daCenter,  true,    "conv_meas_ut_cd",		false,		"",			dfNone,				0,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "cre_dt",				false,		"",			dfDateYmd,			0,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "cre_usr_id",			false,		"",			dfEngUpKey,         0,       false,		false,		100,	false,		true,	   "",	  false);

					InitDataCombo(0, 'dist_meas_ut_cd', dist_meas_ut_cdText,dist_meas_ut_cdCode);
					InitDataCombo(0, 'conv_meas_ut_cd', conv_meas_ut_cdText,conv_meas_ut_cdCode);
                 
               }
                break;
        }
    }



   /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

		switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction))
                {
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoSearch4Post("ESD_TRS_0934GS.do", TrsFrmQryString(formObj));
                }
                break;
        }
    }



   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		}
        return true;
    }



	/**
	 * han_check. (한글 체크 모드)
	 */
	function han_check(obj, comObj, sep){

		var formObject = document.form;
		var inputStr=obj.value;
		var value=obj.value;
		var charval = "Y";

		for (var i = 0; i < inputStr.length; i++)
		{
			 var oneChar = inputStr.charAt(i)
			 if (oneChar != "")
			 {
				   if ((oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == "-") ){
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

			if( sep == 'F' ){				
				var errMessage = ComGetMsg('COM12130','FROM ZIP DATA','','');  
				ComShowMessage(errMessage);
				obj.value = "";
				formObject.frm_zip.focus();
				formObject.frm_zip.select();
			}else if( sep == 'T' ){
				var errMessage = ComGetMsg('COM12130','TO ZIP DATA','','');  
				ComShowMessage(errMessage);
				obj.value = "";
				formObject.to_zip.focus();
				formObject.to_zip.select();
			}
		}
	}



	/**
	 * 포커스주기
	 */
	function fun_Focus(obj){
		var val = obj.value;
		obj.value = val;
		obj.select();
	}

	
	/**
	 * 공통 Node popup
	 */
	 function openHireYardPopup(objName) {
		var formObject = document.form;
		var cmdt_cd_val ="";		//향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";	//향후 사용가능 예정변수
		var cmdt_desc_val ="";		//향후 사용가능 예정변수
		var classId = objName;
		var xx1 = ""; //CONTI
		var xx2 = ""; //SUB CONTI
		var xx3 = ""; //COUNTRY
		var xx4 = ""; //STATE
		var xx5 = ""; //CONTROL OFFIC
		var xx6 = ""; //LOC CODE
		var xx7 = ""; //LOC NAME
		var xx8 = "";
		var xx9 = "";
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
	}



	/**
	 * sheet click시 일어나는 이벤트(쉬트1에서 콤보박스 값을 변경시 중복 체크 및 기타이벤트)
	 **/
	function sheet11_OnClick(sheetObj, row, col, value)
	{

		if(sheetObj.ReadDataProperty(row, col, 0)==6) 
		{	
			return;
		}

		if(!sheetObj.CellEditable(row, col)) return;

		var duple1 = "";
		var duple2 = "";
		var x1 ="";
		var x2 ="";
		var x3 ="";
		var x4 ="";

		x1 =sheetObj.cellValue(row, 'fm_nod_cd');
		x2 =sheetObj.cellValue(row, 'fm_nod_cd_sub');
		x3 =sheetObj.cellValue(row, 'to_nod_cd');
		x4 =sheetObj.cellValue(row, 'to_nod_cd_sub');

		var colName = sheetObj.ColSaveName(col);

		switch(colName){

			case 'fm_nod_cd_sub':
				
				if( sheetObj.cellValue(row, 'fm_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_nod_cd'));
					if((x1!="" && x3!="")  ){
						duple1 = sheetObj.cellValue(row, 'fm_nod_cd')+sheetObj.cellValue(row, 'fm_nod_cd_sub')+sheetObj.cellValue(row, 'to_nod_cd')+sheetObj.cellValue(row, 'to_nod_cd_sub');
						sheetObj.CellValue2(row, 'duple1')=duple1;
						dupl_check(row);
					}
				}
				break;

			case 'to_nod_cd_sub':
				
				if( sheetObj.cellValue(row, 'to_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_nod_cd'));
					if((x1!="" && x3!="") ){
						duple1 = sheetObj.cellValue(row, 'fm_nod_cd')+sheetObj.cellValue(row, 'fm_nod_cd_sub')+sheetObj.cellValue(row, 'to_nod_cd')+sheetObj.cellValue(row, 'to_nod_cd_sub');
						sheetObj.CellValue2(row, 'duple1')=duple1;
						dupl_check(row);
					}

				}
				break;
		}
	}



	/**
	 * sheet click시 일어나는 이벤트(현재는 조회이므로 사용치 않지만 향후 수정로직 첨부시 사용가능성이 존재!)
	 **/
	function sheet11_OnChange(sheetObj, row, col, value)
	{

		var gubun = "";
		var val_1 = "";
		var val_2 = "";
		var duple1 = "";
		var duple2 = "";
		var x1 ="";
		var x2 ="";
		var x3 ="";
		var x4 ="";

		x1 =sheetObj.cellValue(row, 'fm_nod_cd');
		x2 =sheetObj.cellValue(row, 'fm_nod_cd_sub');
		x3 =sheetObj.cellValue(row, 'to_nod_cd');
		x4 =sheetObj.cellValue(row, 'to_nod_cd_sub');

		var colName = sheetObj.ColSaveName(col);

			switch(colName){

				case 'fm_nod_cd':
					if( sheetObj.cellValue(row, 'fm_nod_cd') != '' )
					{
						getYardSheetCombo1(sheetObj, document.form, row, col, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
						if((x1!="" && x3!="") ){
							duple1 = sheetObj.cellValue(row, 'fm_nod_cd')+sheetObj.cellValue(row, 'fm_nod_cd_sub')+sheetObj.cellValue(row, 'to_nod_cd')+sheetObj.cellValue(row, 'to_nod_cd_sub');
							sheetObj.CellValue2(row, 'duple1')=duple1;
							dupl_check(row);
						}
					}
					break;


				case 'to_nod_cd':
					
					if( sheetObj.cellValue(row, 'to_nod_cd') != '' )
					{
						getYardSheetCombo1(sheetObj, document.form, row, col, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
						if((x1!="" && x3!="") ){
							duple1 = sheetObj.cellValue(row, 'fm_nod_cd')+sheetObj.cellValue(row, 'fm_nod_cd_sub')+sheetObj.cellValue(row, 'to_nod_cd')+sheetObj.cellValue(row, 'to_nod_cd_sub');
							sheetObj.CellValue2(row, 'duple1')=duple1;
							dupl_check(row);
						}
					}
					break;

				case 'fm_nod_cd_sub':
					
					if( sheetObj.cellValue(row, 'fm_nod_cd') != '' )
					{
						if((x1!="" && x3!="")  ){
							duple1 = sheetObj.cellValue(row, 'fm_nod_cd')+sheetObj.cellValue(row, 'fm_nod_cd_sub')+sheetObj.cellValue(row, 'to_nod_cd')+sheetObj.cellValue(row, 'to_nod_cd_sub');
							sheetObj.CellValue2(row, 'duple1')=duple1;
							dupl_check(row);
						}
					}
					break;

				case 'to_nod_cd_sub':
					
					if( sheetObj.cellValue(row, 'to_nod_cd') != '' )
					{
						if((x1!="" && x3!="") ){
							duple1 = sheetObj.cellValue(row, 'fm_nod_cd')+sheetObj.cellValue(row, 'fm_nod_cd_sub')+sheetObj.cellValue(row, 'to_nod_cd')+sheetObj.cellValue(row, 'to_nod_cd_sub');
							sheetObj.CellValue2(row, 'duple1')=duple1;
							dupl_check(row);
						}

					}
					break;


				case 'bzc_dist':
					
					if( sheetObj.cellValue(row, 'bzc_dist') != '' )   //1 Mile = 1.609344km
					{
						gubun = sheetObj.cellValue(row, 'dist_meas_ut_cd');
						val_1 = sheetObj.cellValue(row, 'bzc_dist');

						if(gubun =="K"){
							sheetObj.CellValue2(row, 'conv_dist') = val_1/1.609344;
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "M";
						}else{
							sheetObj.CellValue2(row, 'conv_dist') = val_1*1.609344;
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "K";
						}
					}
					break;


				case 'dist_meas_ut_cd':

				if( sheetObj.cellValue(row, 'bzc_dist') != '' )   //1 Mile = 1.609344km
					{
						gubun = sheetObj.cellValue(row, 'dist_meas_ut_cd')
						val_1 = sheetObj.cellValue(row, 'bzc_dist')

						if(gubun =="K"){
							sheetObj.CellValue2(row, 'conv_dist') = Math.round(val_1/1.609344);
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "M";
						}else{
							sheetObj.CellValue2(row, 'conv_dist') = Math.round(val_1*1.609344);
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "K";
						}
					}
					break;
		}
	}



	/**
	 * 중복데이타1 검증하기 위해서 필요함!!
	 **/
	function dupl_check(row){

		var formObject = document.form;

		var b_dupl = formObject.sheet1.ColValueDup("duple1");	//임의로 만든 쉬트컬럼에서 중복여부 값을 읽어옴

		if(b_dupl>0){
			var errMessage = ComGetMsg('COM12115','NODE DATA','','');  
			ComShowMessage(errMessage);
			//formObject.sheet1.CellValue2(row, 'fm_nod_cd')="";
			formObject.sheet1.SelectCell(row, 'fm_nod_cd');
			formObject.sheet1.RowBackColor(row)=formObject.sheet1.RgbColor(238,255,226);   //중복데이타
			formObject.sheet1.CellValue2(row, 'duple2')="N";
			return false;
		}else{
			formObject.sheet1.CellValue2(row, 'duple2')="";
			formObject.sheet1.RowBackColor(row) = 15723503;
			formObject.sheet1.CellBackColor(row, 'bzc_dist') = 0; 
			formObject.sheet1.CellBackColor(row, 'dist_meas_ut_cd') = 0; 
			dupl_check2(row);
		}

	}

	

	/**
	 * 중복데이타2 검증하기 위해서 필요함!!
	 **/
	function dupl_check2(row){

		var formObject = document.form;

		var status = formObject.sheet1.RowStatus(row);				//sheet1에서의 상태값

		var valcheck = formObject.sheet1.CellValue(row, 'duple2');	//임의로 만든 쉬트컬럼에서 중복여부 값을 읽어옴

		//화면상에서 중복아닌대상일 경우
		if(valcheck!="N"){   

			var fm_nod_cd = formObject.sheet1.CellValue(row, "fm_nod_cd");
			var fm_nod_cd_sub = formObject.sheet1.CellValue(row, "fm_nod_cd_sub");
			var to_nod_cd = formObject.sheet1.CellValue(row, "to_nod_cd");
			var to_nod_cd_sub = formObject.sheet1.CellValue(row, "to_nod_cd_sub");
				
			formObject.f_cmd.value = SEARCH01;
			var queryString = "fm_nod_cd="+fm_nod_cd+"&"+"fm_nod_cd_sub="+fm_nod_cd_sub+"&"+"to_nod_cd="+to_nod_cd+"&"+"to_nod_cd_sub="+to_nod_cd_sub+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoSearch4Post("ESD_TRS_0080GS.do", queryString);
		
			var check_val = formObject.sheet1.EtcData('CNT_CD');	

			//쉬트 체크박스를 선택하지 않은경우
			if( check_val == 0){
				formObject.sheet1.CellValue2(row, 'duple2')="";
				formObject.sheet1.RowBackColor(row) = 15723503;
				formObject.sheet1.CellBackColor(row, 'bzc_dist') = 0; 
				formObject.sheet1.CellBackColor(row, 'dist_meas_ut_cd') = 0; 
			}else{
				var errMessage = ComGetMsg('COM12115','NODE DATA','','');  
				ComShowMessage(errMessage);
				formObject.sheet1.SelectCell(row, 'fm_nod_cd');
				formObject.sheet1.RowBackColor(row)=formObject.sheet1.RgbColor(238,255,226);   //중복데이타
				formObject.sheet1.CellValue2(row, 'duple2')="N";
			}
		}else{

		}

	}