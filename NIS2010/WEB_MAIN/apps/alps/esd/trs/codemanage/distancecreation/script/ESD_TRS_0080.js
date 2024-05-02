/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0080.js
*@FileTitle : Distance
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2010.03.18 cjh
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.17 최 선  1.1 [] SAVE시, Distance 중복 등록  현상 처리
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0080 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0080() {
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
                    if ( ComIsEmpty(formObject.frm_node) && ComIsEmpty(formObject.to_node) )
                    {
                        ComShowCodeMessage("COM12138" , "From Node" , "To Node");
                        return;
                    }
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

				//쉬트1에 한개의 로우 추가
                case "btng_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;

				//저장버튼을 누를시
                case "btng_save":
                	
                    var saveRows = sheetObject.FindCheckedRow("sel");

                    var arrRow = saveRows.split("|");
					
					if(arrRow.length == 0){
						var errMessage = ComGetMsg('TRS90215');  
						ComShowMessage(errMessage);
						break;
					}
                	
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

				//저장버튼을 누를시
                case "btng_delete":
                    
                     var delRows = sheetObject.FindCheckedRow("sel");

                     var arrRow = delRows.split("|");

                     for (idx=arrRow.length-2; idx>=0; idx--){ 

                         if (sheetObject.RowStatus(arrRow[idx]) == "I" )
                         {
                             sheetObject.RowDelete (arrRow[idx] , false);
                         }
                     }
                    
                    
                     var chkRows = sheetObject.FindCheckedRow("sel");

                    if ( chkRows == "") return;                                         
                     var chkRow = chkRows.split("|");

                     for (idx=chkRow.length-2; idx>=0; idx--){ 
                         if (sheetObject.CellValue(chkRow[idx] , "delt_flg" ) == "D" )
                         {
                                ComShowMessage("It was deleted.");
                                return;
                         }
                     }
                     
                    formObject.del_gubun.value = "D";
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                    
				//저장버튼을 누를시
                case "btng_live":

                    var chkRows = sheetObject.FindCheckedRow("sel");
                                         
                     var chkRow = chkRows.split("|");

                     for (idx=chkRow.length-2; idx>=0; idx--){ 
                         if (sheetObject.CellValue(chkRow[idx] , "delt_flg" ) == "" )
                         {
                                ComShowMessage("It is live.");
                                return;
                         }
                     }
                     
                    formObject.del_gubun.value = "L";
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                    
				//btns_frmnode 버튼을 누를시 FromNode Popup창
				case "btns_frmnode": 
					openHireYardPopup('getFromNode');
				break;

				//btns_tonode 버튼을 누를시 ToNode Popup창
				case "btns_tonode": 
					openHireYardPopup('getToNode');
				break;

				//btns_tonode 버튼을 누를시 history 팝업을 뛰운다.
				case "btng_history": 
					doOpenPopup(sheetObject,formObject,'auto');
				break;

				//btns_tonode 버튼을 누를시 history 팝업을 뛰운다.
				case "btn_reset": 
					fn_reset();
				break;
				case "btng_fileselect":
					doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
					break;

				case "btng_downexcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
					break;
					
				case "btng_verify":
					verifyValues(sheetObject, formObject);
				break;	

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowCodeMessage("TRS90392");
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
		var formObject = document.form;
		formObject.frm_node.focus();

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
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Sel.|Del.\nMark|STS|Seq.|From Node|From Node|From\nZip Code|To Node|To Node|To\nZip Code|Distance|Distance|"
                                    +"Converted\nDistance|Converted\nDistance|Creation\nDate|Creation\nUser Name|Update\nDate|Update\nUser Name|duple1|duple2";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,				KEYFIELD, CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,  40,   daCenter,  true,    "sel");
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,		"delt_flg",			false,		"",			dfNone,         0,       false,		false,		5,		false,		false,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtStatus,    30,   daCenter,  true,    "ibflag");      
                    InitDataProperty(0, cnt++ , dtSeq,       40,   daCenter,  true,		"seq");      
                    InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,		"fm_nod_cd",			true,		"",			dfEngUpKey,         0,       false,		true,		5,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,		"fm_nod_cd_sub",		true,		"",			dfNone,				0,       false,		true,		2,		false,		true,	   "",	  false);

                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  true,    "fm_nod_zip_cd_ctnt",   false,		"",			dfNone,	      		0,		 true,		true,		15,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "to_nod_cd",			true,		"",			dfEngUpKey,         0,       false,		true,		5,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,    "to_nod_cd_sub",		true,		"",			dfNone,				0,       false,		true,		4,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  true,    "to_nod_zip_cd_ctnt",   false,		"",			dfNone,			    0,       true,		true,		15,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight,   true,    "bzc_dist",				false,		"",			dfFloat,			2,       true,		true,		100,	false,		true,	   "",	  false);

                    InitDataProperty(0, cnt++ , dtCombo,     50,    daCenter,  true,    "dist_meas_ut_cd",		false,		"",			dfNone,				0,       true,		true,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight,   true,    "conv_dist",			false,		"",			dfFloat,			2,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtCombo,     40,    daCenter,  true,    "conv_meas_ut_cd",		false,		"",			dfNone,				0,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "cre_dt",				false,		"",			dfDateYmd,			0,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "cre_usr_id",			false,		"",			dfEngUpKey,         0,       false,		false,		100,	false,		true,	   "",	  false);

                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "upd_dt",				false,		"",			dfDateYmd,			0,       false,		false,		100,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  true,    "upd_usr_id",			false,		"",			dfEngUpKey,         0,       false,		false,		100,	false,		true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtHidden,      75,    daCenter,  true,    "duple1",				false,		"",			dfEngUpKey,         0,       false,		false,		100,	false,		true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtHidden,      75,    daCenter,  true,    "duple2",				false,		"",			dfEngUpKey,         0,       false,		false,		100,	false,		true,	   "",	  false);
				
					InitDataCombo(0, 'dist_meas_ut_cd', "Km|ML", dist_meas_ut_cdCode);
					InitDataCombo(0, 'conv_meas_ut_cd', conv_meas_ut_cdText,conv_meas_ut_cdCode);
                 
               }
                break;
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			//조회
			case IBSEARCH:     
                if(validateForm(sheetObj,formObj,sAction))
                {
                	formObj.verify_check_yn.value="N";
					//조회이전에 from값을 위해서 합치는 작업
					//if(document.frm_yard.Code != '' && formObj.frm_node.value != '')
					//{
						formObj.hid_frm_node.value = formObj.frm_node.value+formObj.frm_yard.Code;
					//}else{
					//	formObj.hid_frm_node.value = '';
					//}


					//조회이전에 to값을 위해서 합치는 작업
					//if(document.to_yard.Code != '' && formObj.to_node.value != '')
					//{
						formObj.hid_to_node.value = formObj.to_node.value+formObj.to_yard.Code;
					//}else{
					//	formObj.hid_to_node.value = '';
					//}

					//조회로직 호출
//					sheetObj.removeAll();
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESD_TRS_0080GS.do", TrsFrmQryString(formObj));

//					var formObject = document.form;
//					formObject.opner_from_node.value ="";
//					formObject.opner_from_zip_code.value ="";
//					formObject.opner_to_node.value ="";
//					formObject.opner_to_zip_code.value ="";
                }
                break;

			//저장
            case IBSAVE:        

        			if(!validateForm(sheetObj, formObj, sAction)) return false;

					var formObject = document.form;
					//저장이전에 from값을 위해서 합치는 작업

					if(document.frm_yard.Code != '' && formObj.frm_node.value != '')
					{
						formObj.hid_frm_node.value = formObj.frm_node.value+formObj.frm_yard.Code;
					}else{
						formObj.hid_frm_node.value = '';
					}

					//저장이전에 to값을 위해서 합치는 작업
					if(document.to_yard.Code != '' && formObj.to_node.value != '')
					{
						formObj.hid_to_node.value = formObj.to_node.value+formObj.to_yard.Code;
					}else{
						formObj.hid_to_node.value = '';
					}

					document.form.hid_cre_usr_id.value = document.form.hid_cre_usr_id.value.toUpperCase();
					document.form.hid_upd_usr_id.value = document.form.hid_upd_usr_id.value.toUpperCase();

					var sheet1_count = formObject.sheet1.RowCount;	//sheet1의 전체로우수를 담는 변수!
					var row_status = "";     
					var k = sheet1_count+1;
					var duple1 ="";
					var duple2 ="";
					var save_val="Y";
					var row_val ="";

					//sheet1에서 루프를 돌면서 중복데이타는 중복이 되지않도록 하는 로직
					if(sheet1_count >0){
						for(var t = 1; t < k; t++) {
							row_status = formObject.sheet1.RowStatus(t);	//루프를 돌면서 상태를 읽어온다.
							if(row_status =="I" ){
								duple2 = formObject.sheet1.CellValue(t, "duple2");
								if(duple2 =="N"){
									save_val ="N"; 
									row_val =t;
									break;
								}else{
									save_val ="Y"; 
								}
							}else{
								save_val ="Y"; 
							}
						}
					}

					if(save_val =="Y"){
						//저장로직호출
						formObj.f_cmd.value = MULTI;
						var savexml = sheetObj.DoSave("ESD_TRS_0080GS.do", TrsFrmQryString(formObj),"sel",false);
					}else{
						var errMessage = ComGetMsg('COM12115','Sheet data','','');  
						ComShowMessage(errMessage);
						formObject.sheet1.SelectCell(row_val, 'fm_nod_cd');
					}
                break;

			//엑셀 다운로드
			case IBDOWNEXCEL:        
				sheetObj.Down2Excel(-1, false, false, true);
              break;

			case IBLOADEXCEL: // 엑셀 업로드
				sheetObj.RemoveAll();
				sheetObj.LoadExcel();
				break;
				
			// 입력
			case IBINSERT:      
				  //생성 후 기본값 설정하기
				  var Row = sheetObj.DataInsert(-1);
				  sheetObj.CellValue2(Row, "cre_dt") = document.form.hid_cre_date.value;
				  sheetObj.CellValue2(Row, "cre_usr_id") = document.form.hid_cre_usr_id.value.toUpperCase();
				  //sheetObj.CellValue2(Row, "hid_upd_usr_id") = document.form.hid_upd_usr_id.value.toUpperCase();
				  document.form.hid_cre_usr_id.value = document.form.hid_cre_usr_id.value.toUpperCase();
				  document.form.hid_upd_usr_id.value = document.form.hid_upd_usr_id.value.toUpperCase();
				  sheetObj.SelectCell(Row, "fm_nod_cd");
				  distance(Row);
                break;
                
			case IBDELETE:      
				  //생성 후 기본값 설정하기

				  formObj.f_cmd.value = MULTI02;
				  var savexml = sheetObj.DoSave("ESD_TRS_0080GS.do", TrsFrmQryString(formObj), "sel",false);
				  formObj.f_cmd.value = SEARCH;
				  sheetObj.DoSearch4Post("ESD_TRS_0080GS.do", TrsFrmQryString(formObj));
                break;
        }
    }


	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo,OnePageRow){
        var formObj = document.form;
        formObj.page_no.value = PageNo;
        formObj.f_cmd.value = SEARCH01;
		sheetObj.DoSearch4Post("ESD_TRS_0080GS.do", CondParam,'', true);
    
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
	 * From Node 팝업에 대한 리턴값
	 */
	function getFromNode(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var node = colArray[3];
		var lvLoc = node.substring(0, 5);
		var lvYard = node.substring(5, 7);
		formObject.frm_node.value = lvLoc;
		getYardZoneCombo(document.frm_yard, sheetObjects[0], formObject, lvLoc);
		document.frm_yard.CODE = lvYard;
	}


	/**
	 * To Node 팝업에 대한 리턴값
	 */
	function getToNode(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var node = colArray[3];

		var lvLoc = node.substring(0, 5);
		var lvYard = node.substring(5, 7);
		formObject.to_node.value = lvLoc;
		getYardZoneCombo(document.to_yard, sheetObjects[0], formObject, lvLoc);
		document.to_yard.CODE = lvYard;
	}



	/*
	 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
	 */
	function getComboList_val(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류

		var formObj = document.form;
		var formObject = document.form;
		var charval = "Y";
		var inputStr=obj.value;
		var lvFromNode = "";
		var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
		var yard_obj = null;
		obj.value = lvobj;

		if( lvobj == "" ) {
			obj.value = "";

			if(obj.name == 'frm_node') yard_obj = document.frm_yard;
			else if(obj.name == 'to_node') yard_obj = document.to_yard;
			
			var locValue = obj.value;

			if(ComTrim(locValue) == ''){
				yard_obj.RemoveAll();
				return;
			}

		} else if( lvobj.length != 5 ) {
			ComShowCodeMessage("TRS90074");
			if(sep=="F"){
				//formObject.frm_node.value = "";
				formObject.frm_node.select();
				formObject.frm_node.focus();
				document.frm_yard.RemoveAll();

			}else if(sep=="T"){
				//formObject.frm_node.value = "";
				formObject.to_node.select();
				formObject.to_node.focus();
				document.to_yard.RemoveAll();

			}else{
			}
			//return false;
		}else{
			for (var i = 0; i < inputStr.length; i++)
			{
				 var oneChar = inputStr.charAt(i)
				 if (oneChar != "")
				 {
					   if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" )){
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
				if( sep == 'F' ){
					lvFromNode = getYardZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
				}else if( sep == 'T' ){
					lvToNode = getYardZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
				}else{
				}
			}else{

				if( sep == 'F' ){				
					var errMessage = ComGetMsg('COM12130','FROM NODE DATA','','');  
					ComShowMessage(errMessage);
					obj.value = "";
					formObj.frm_node.focus();
					formObj.frm_node.select();
					document.frm_yard.RemoveAll();
				}else if( sep == 'T' ){
					var errMessage = ComGetMsg('COM12130','TO NODE DATA','','');  
					ComShowMessage(errMessage);
					obj.value = "";
					formObj.to_node.focus();
					formObj.to_node.select();
					document.to_yard.RemoveAll();
				}
			}
		}
	}


	/**
	 * han_check.(한글체크)
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
	 * 포커스이벤트
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
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
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
	 * sheet click시 일어나는 이벤트
	 **/
	function sheet1_OnClick(sheetObj, row, col, value)
	{
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

			case 'sel':
				value_move(row);
			break;
		
			case 'seq':
				value_move(row);
				break;

			case 'fm_nod_cd':
				value_move(row);
				break;

			case 'fm_nod_cd_sub':
				value_move(row);
				break;

			case 'fm_nod_zip_cd_ctnt':
				value_move(row);
				break;			

			case 'to_nod_cd':
				value_move(row);
				break;

			case 'to_nod_cd_sub':
				value_move(row);
				break;

			case 'to_nod_zip_cd_ctnt':
				value_move(row);
				break;		
		
			case 'bzc_dist':
				value_move(row);
				break;		

			case 'dist_meas_ut_cd':
				value_move(row);
				break;	

			case 'conv_dist':
				value_move(row);
				break;			

			case 'conv_meas_ut_cd':
				value_move(row);
				break;	

			case 'cre_dt':
				value_move(row);
				break;	

			case 'cre_usr_id':
				value_move(row);
				break;	

			case 'upd_dt':
				value_move(row);
				break;	

			case 'upd_usr_id':
				value_move(row);
				break;	


				
		
		}


		if(sheetObj.ReadDataProperty(row, col, 0)==6) 
		{	
			return;
		}

		if(!sheetObj.CellEditable(row, col)) return;



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
				value_move(row);
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
				value_move(row);
				break;
		
		}
	}


	/**
	 * sheet click시 일어나는 이벤트
	 **/
	function value_move(row)
	{
		var formObject = document.form;
		var fm_nod = formObject.sheet1.CellValue(row, "fm_nod_cd")+formObject.sheet1.CellValue(row, "fm_nod_cd_sub");
		var fm_nod_zip_cd = formObject.sheet1.CellValue(row, "fm_nod_zip_cd_ctnt");
		var to_nod = formObject.sheet1.CellValue(row, "to_nod_cd")+formObject.sheet1.CellValue(row, "to_nod_cd_sub");
		var to_nod_zip_cd = formObject.sheet1.CellValue(row, "to_nod_zip_cd_ctnt");
		var check_val="";

		formObject.opner_from_node.value =fm_nod;
		formObject.opner_from_zip_code.value =fm_nod_zip_cd;
		formObject.opner_to_node.value =to_nod;
		formObject.opner_to_zip_code.value =to_nod_zip_cd;

		var sheet1_count =formObject.sheet1.RowCount;

		if(sheet1_count >0){
			for(var t = 1; t < sheet1_count+1; t++) {
				check_val = formObject.sheet1.RowStatus(t);
				if(check_val!="I"){
					formObject.sheet1.RowBackColor(t)=15723503;
				}
			}
		}


		//부분적으로 색깔을 넣기!!!!(수정가능한 필드)
		for(var t = 1; t < sheet1_count+1; t++) {
			check_val = formObject.sheet1.RowStatus(t);
			if(check_val!="I"){
			    formObject.sheet1.CellEditable(t,'fm_nod_zip_cd_ctnt') = true;
			    formObject.sheet1.CellEditable(t,'to_nod_zip_cd_ctnt') = true;
				formObject.sheet1.CellEditable(t,'bzc_dist') = true;
				formObject.sheet1.CellEditable(t,'dist_meas_ut_cd') = true;
			}
		}//for(var t = 1; t < p; t++) {

		check_val = formObject.sheet1.RowStatus(row);
		if(check_val!="I"){
			formObject.sheet1.RowBackColor(row)=formObject.sheet1.RgbColor(238,255,226);
		}

	}



	/**
	 * sheet click시 일어나는 이벤트
	 **/
	function sheet1_OnChange(sheetObj, row, col, value)
	{

		var formObject = document.form;
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
						getYardZoneSheetCombo1(sheetObj, document.form, row, col, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
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
						getYardZoneSheetCombo1(sheetObj, document.form, row, col, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
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

						if(gubun =="KM"){
							sheetObj.CellValue2(row, 'conv_dist') = val_1/1.609344;
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "ML";
						}else{
							sheetObj.CellValue2(row, 'conv_dist') = val_1*1.609344;
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "KM";
						}
					}
					break;


				case 'dist_meas_ut_cd':

				if( sheetObj.cellValue(row, 'bzc_dist') != '' )   //1 Mile = 1.609344km
					{
						gubun = sheetObj.cellValue(row, 'dist_meas_ut_cd')
						val_1 = sheetObj.cellValue(row, 'bzc_dist')

						if(gubun =="KM"){
							sheetObj.CellValue2(row, 'conv_dist') = Math.round(val_1/1.609344);
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "ML";
						}else{
							sheetObj.CellValue2(row, 'conv_dist') = Math.round(val_1*1.609344);
							sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "KM";
						}
					}
					break;

				case 'fm_nod_zip_cd_ctnt':

					var charval = "Y";

					if( sheetObj.cellValue(row, 'fm_nod_zip_cd_ctnt') != '' )  
					{
						inputStr = sheetObj.cellValue(row, 'fm_nod_zip_cd_ctnt');

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

						if(charval !="Y"){
							var errMessage = ComGetMsg('COM12130','FROM ZIP CODE','','');  
							ComShowMessage(errMessage);
							formObject.sheet1.CellValue2(row, 'fm_nod_zip_cd_ctnt')="";
							formObject.sheet1.SelectCell(row, 'fm_nod_zip_cd_ctnt');
						}else{
							formObject.sheet1.SelectCell(row, 'to_nod_cd');
						}

					}
					break;


				case 'to_nod_zip_cd_ctnt':

					var charval = "Y";

					if( sheetObj.cellValue(row, 'to_nod_zip_cd_ctnt') != '' )  
					{
						inputStr = sheetObj.cellValue(row, 'to_nod_zip_cd_ctnt');

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

						if(charval !="Y"){
							var errMessage = ComGetMsg('COM12130','TO ZIP CODE','','');  
							ComShowMessage(errMessage);
							formObject.sheet1.CellValue2(row, 'to_nod_zip_cd_ctnt')="";
							formObject.sheet1.SelectCell(row, 'to_nod_zip_cd_ctnt');
						}else{
							formObject.sheet1.SelectCell(row, 'dist_meas_ut_cd');
						}

					}
					break;
		}
	}


	/**
	 * dupl_check1 중복체크 이벤트
	 **/
	function dupl_check(row){

		var formObject = document.form;
		
		formObject.verify_check_yn.value="N";	

		//var b_dupl = formObject.sheet1.ColValueDup("duple1"); // EXCEL UPLOAD 후 DUPLE 체크 정확히 되지 않아 아래에 따로 구현함. 201002 KYS
		var b_dupl = 0;
		var cmpStr = formObject.sheet1.CellValue(row, 'fm_nod_cd')
			+ formObject.sheet1.CellValue(row, 'fm_nod_cd_sub')
			+ formObject.sheet1.CellValue(row, 'to_nod_cd')
			+ formObject.sheet1.CellValue(row, 'to_nod_cd_sub');
		
		var cmpStr2= "";
		for(var i=0; i<formObject.sheet1.RowCount; i++){
			if(row!=i+1){
				cmpStr2 = formObject.sheet1.CellValue(i+1, 'fm_nod_cd')
				+ formObject.sheet1.CellValue(i+1, 'fm_nod_cd_sub')
				+ formObject.sheet1.CellValue(i+1, 'to_nod_cd')
				+ formObject.sheet1.CellValue(i+1, 'to_nod_cd_sub');
				
				if(cmpStr == cmpStr2) {
					b_dupl = i+1;
					break;
				}	
			}	
		}

		if(b_dupl>0){
			var errMessage = ComGetMsg('COM12115','NODE DATA','','');  
			ComShowMessage(errMessage);
			//formObject.sheet1.CellValue2(row, 'fm_nod_cd')="";
			formObject.sheet1.SelectCell(row, 'fm_nod_cd');
			//formObject.sheet1.RowBackColor(row)=formObject.sheet1.RgbColor(107,178,118);   //중복데이타
			formObject.sheet1.CellValue2(row, 'duple2')="N";
			return false;
		}else{
			formObject.sheet1.CellValue2(row, 'duple2')="";
			//formObject.sheet1.RowBackColor(row) = 15723503;
			formObject.sheet1.CellBackColor(row, 'bzc_dist') = 0; 
			formObject.sheet1.CellBackColor(row, 'dist_meas_ut_cd') = 0; 
//			dupl_check2(row);
		}

	}

	
	/**
	 * dupl_check2 중복체크 이벤트
	 **/
	function dupl_check2(row) {

		var formObject = document.form;
		var status = formObject.sheet1.RowStatus(row);	
		var valcheck = formObject.sheet1.CellValue(row, 'duple2');
		
		if( status=="U") return true;
		
		if (valcheck != "N") { // 화면상에서 중복아닌대상

			var fm_nod_cd = formObject.sheet1.CellValue(row, "fm_nod_cd");
			var fm_nod_cd_sub = formObject.sheet1.CellValue(row, "fm_nod_cd_sub");
			var to_nod_cd = formObject.sheet1.CellValue(row, "to_nod_cd");
			var to_nod_cd_sub = formObject.sheet1.CellValue(row, "to_nod_cd_sub");

			formObject.f_cmd.value = SEARCH01;
			var queryString = "ibflag=I&fm_nod_cd=" + fm_nod_cd + "&" + "fm_nod_cd_sub="
					+ fm_nod_cd_sub + "&" + "to_nod_cd=" + to_nod_cd + "&"
					+ "to_nod_cd_sub=" + to_nod_cd_sub + "&"
					+ TrsFrmQryString(formObject);
			//formObject.sheet1.DoSearch4Post("ESD_TRS_0080GS.do", queryString);
			formObject.sheet1.DoRowSearch("ESD_TRS_0080GS.do", queryString,false);

			var check_val = formObject.sheet1.EtcData('CNT_CD');
			if (check_val == 0) {
				formObject.sheet1.CellValue2(row, 'duple2') = "";
				formObject.sheet1.CellBackColor(row, 'bzc_dist') = 0;
				formObject.sheet1.CellBackColor(row, 'dist_meas_ut_cd') = 0;
				return true;
			} else {
				// 업데이트 여부 확인
				var confirmStr = "[from node : " + fm_nod_cd + fm_nod_cd_sub + ", to node : " + to_nod_cd + to_nod_cd_sub
				 					+ "] 기  정보가 존재합니다. 업데이트 하시겠습니까?";
				if(confirm(confirmStr)){
					// 업데이트 할 경우 status를 "U"로 설정. focus. 
					formObject.sheet1.RowStatus(row) = "U";
					formObject.sheet1.SelectCell(row, 'fm_nod_cd');
				}
				else{
					// 업데이트 하지 않을 경우 check 해제
					formObject.sheet1.CellValue2(row, "sel") = 0;
				}	
				return false;
			}
		}
		else {
			return false;
		}
	}

	/**
	* Verify 체크
	*/
	function verifyValues(sheetObj, formObject){
		
		document.all.btng_verify.disabled = true;

		var chkRows = sheetObj.FindCheckedRow("sel");
		if (chkRows == null || chkRows == ""){
			ComShowCodeMessage("TRS90215");
			document.all.btng_verify.disabled = false;
			return;
		}
		
		//ComOpenWait(true);
		var chkRow = chkRows.split("|");
		
		// Sheet Data 정합성 확인
		var rowIdx = 0; 
		var colIdx = 0; 
		var verifyResult = true;
		
		for (var rowIdx = 0; rowIdx<chkRow.length-1; rowIdx++) {
			for(var colIdx = 0; colIdx<20; colIdx++){
				verifyResult = verifySheetData(sheetObj, chkRow[rowIdx], colIdx, "")
				if(!verifyResult) break;
			}
			if(!verifyResult) break;
		}
		
		if(!verifyResult) {
			ComOpenWait(false);
			document.all.btng_verify.disabled = false;
			return false; // 정합성에 맞지 않는 data 있는 경우 verify 중단
		}
		
		for (var rowIdx = 0; rowIdx<chkRow.length-1; rowIdx++) {
			// 기존 데이터와 중복 여부 확인
			//if(!dupl_check2(idx)) break;
			dupl_check2(chkRow[rowIdx]);
		}
		
		//ComOpenWait(false);
		ComShowCodeMessage("TRS90375");
		document.all.btng_verify.disabled = false;
		formObject.verify_check_yn.value="Y";
	}
	
	/**
	 * upload 한 excel 파일의 데이터 정합성을 검증(sheet1_OnChange 와 동일한 내용. return value 가 있는 것 만 다름.  
	 */
	function verifySheetData(sheetObj, row, col, value) {
		
		var formObject = document.form;
		var gubun = "";
		var val_1 = "";
		var val_2 = "";
		var duple1 = "";
		var duple2 = "";
		var x1 = "";
		var x2 = "";
		var x3 = "";
		var x4 = "";

		x1 = sheetObj.cellValue(row, 'fm_nod_cd');
		x2 = sheetObj.cellValue(row, 'fm_nod_cd_sub');
		x3 = sheetObj.cellValue(row, 'to_nod_cd');
		x4 = sheetObj.cellValue(row, 'to_nod_cd_sub');
		
		var colName = sheetObj.ColSaveName(col);

		switch (colName) {
		case 'fm_nod_cd':
			if (sheetObj.cellValue(row, 'fm_nod_cd') != '') {
				
				var result = getYardZoneSheetComboDist(sheetObj, document.form, row, col, sheetObj.ColSaveName(col + 1), sheetObj.cellValue(row, colName));
				if(!result) return false;
			}
			break;

		case 'to_nod_cd':
			if (sheetObj.cellValue(row, 'to_nod_cd') != '') {
				var result = getYardZoneSheetComboDist(sheetObj, document.form, row, col, sheetObj.ColSaveName(col + 1), sheetObj.cellValue(row, colName));
				if(!result) return false;
			}
			break;

		case 'fm_nod_cd_sub':
			if (sheetObj.cellValue(row, 'fm_nod_cd') != '') {
			}
			break;

		case 'to_nod_cd_sub':
			if (sheetObj.cellValue(row, 'to_nod_cd') != '') {
			}
			break;

		case 'bzc_dist':
			if (sheetObj.cellValue(row, 'bzc_dist') != '') // 1 Mile = 1.609344km
			{
				gubun = sheetObj.cellValue(row, 'dist_meas_ut_cd');
				val_1 = sheetObj.cellValue(row, 'bzc_dist');

				if (gubun == "KM") {
					sheetObj.CellValue2(row, 'conv_dist') = val_1 / 1.609344;
					sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "ML";
				} else {
					sheetObj.CellValue2(row, 'conv_dist') = val_1 * 1.609344;
					sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "KM";
				}
			}
			break;

		case 'dist_meas_ut_cd':
			if (sheetObj.cellValue(row, 'bzc_dist') != '') // 1 Mile = 1.609344km
			{
				gubun = sheetObj.cellValue(row, 'dist_meas_ut_cd')
				val_1 = sheetObj.cellValue(row, 'bzc_dist')

				if (gubun == "KM") {
					sheetObj.CellValue2(row, 'conv_dist') = Math.round(val_1 / 1.609344);
					sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "ML";
				} else {
					sheetObj.CellValue2(row, 'conv_dist') = Math
							.round(val_1 * 1.609344);
					sheetObj.CellValue2(row, 'conv_meas_ut_cd') = "KM";
				}
			}
			break;

		case 'fm_nod_zip_cd_ctnt':
			var charval = "Y";

			if (sheetObj.cellValue(row, 'fm_nod_zip_cd_ctnt') != '') {
				inputStr = sheetObj.cellValue(row, 'fm_nod_zip_cd_ctnt');

				for ( var i = 0; i < inputStr.length; i++) {
					var oneChar = inputStr.charAt(i)
					if (oneChar != "") {
						if ((oneChar >= "a" && oneChar <= "z")
								|| (oneChar >= "A" && oneChar <= "Z")
								|| (oneChar >= "0" && oneChar <= "9")
								|| (oneChar == "-")) {
						} else {
							charval = "N";
							break;
						}
					} else {
						charval = "N";
						break;
					}
				}

				if (charval != "Y") {
					var errMessage = ComGetMsg('COM12130', 'FROM ZIP CODE', '', '');
					ComShowMessage(errMessage);
					formObject.sheet1.CellValue2(row, 'fm_nod_zip_cd_ctnt') = "";
					formObject.sheet1.SelectCell(row, 'fm_nod_zip_cd_ctnt');
					return false;
				} else {
					formObject.sheet1.SelectCell(row, 'to_nod_cd');
				}

			}
			break;

		case 'to_nod_zip_cd_ctnt':
			var charval = "Y";

			if (sheetObj.cellValue(row, 'to_nod_zip_cd_ctnt') != '') {
				inputStr = sheetObj.cellValue(row, 'to_nod_zip_cd_ctnt');

				for ( var i = 0; i < inputStr.length; i++) {
					var oneChar = inputStr.charAt(i)
					if (oneChar != "") {
						if ((oneChar >= "a" && oneChar <= "z")
								|| (oneChar >= "A" && oneChar <= "Z")
								|| (oneChar >= "0" && oneChar <= "9")
								|| (oneChar == "-")) {
						} else {
							charval = "N";
							break;
						}
					} else {
						charval = "N";
						break;
					}
				}

				if (charval != "Y") {
					var errMessage = ComGetMsg('COM12130', 'TO ZIP CODE', '', '');
					ComShowMessage(errMessage);
					formObject.sheet1.CellValue2(row, 'to_nod_zip_cd_ctnt') = "";
					formObject.sheet1.SelectCell(row, 'to_nod_zip_cd_ctnt');
					return false;
				} else {
					formObject.sheet1.SelectCell(row, 'dist_meas_ut_cd');
				}

			}
			break;
		}
		
		return true;
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {

		switch(sAction) {
			case IBSEARCH:
				break;
		
			case IBSAVE:
				
				var saveRows = sheetObj.FindCheckedRow("sel");
				var arrRow = saveRows.split("|");
				
				// 선택된 row가 없을 경우
				if (arrRow == "" || arrRow == null || arrRow.length == 0) {
					ComShowCodeMessage("TRS90215");
					return false;
				}
		
				// dist_meas_ut_cd 입력 여부 체크 - mandatory 항목임. 
				for (var idx = arrRow.length - 2; i >= 0; i--) {
					if (sheetObj.CellValue(arrRow[idx], "dist_meas_ut_cd") == "") {
						ComShowCodeMessage("COM130404", "Distance Measure Unit Code");
						return false;
					}
				}
				
				// verify가 실행되었는지 체크
				if(formObj.verify_check_yn.value!="Y"){
					ComShowCodeMessage("TRS90039");
					return false;
				}
		
				break;
		}	
		return true;
	}

	/**
	 * history 팝업호출이벤트
	 **/
	function doOpenPopup(sheetObject,formObject,gubun){
		var w       = 800;
		var h       = 440;
		var screenW = screen.width;
		var screenH = screen.height;
		var posX    = (screenW-w)/2;
		var posY    = (screenH-h)/2;
		var url   = "";
		url   = 'ESD_TRS_0934.do';

	    var CheckRow = sheetObject.CheckedRows("sel");

	    if(CheckRow != 1){
			ComShowCodeMessage('TRS90036');
			return false;
	    }
	    
	    var CheckRow2 = sheetObject.FindCheckedRow("sel");
	    
	    var row = CheckRow2.split("|");
	    var fm_node = sheetObject.CellValue(row, "fm_nod_cd")+sheetObject.CellValue(row, "fm_nod_cd_sub");
		var to_node = sheetObject.CellValue(row, "to_nod_cd")+sheetObject.CellValue(row, "to_nod_cd_sub");
		
		formObject.opner_from_node.value = fm_node;
		formObject.opner_to_node.value = to_node;
		
		
		if(fm_node =="" || to_node=="" ){
			var errMessage = ComGetMsg('COM12113','Sheet data','','');  
			ComShowMessage(errMessage);
		}else{

			var param = TrsFrmQryString(formObject);
			if(param.length > 0){
				url   = url + "?" + param;
			}

			var popWin  = window.open(url, "history", "status=0,width="+w+",height="+h+",resizable=0,scrollbars=0,left="+posX+",top="+posY);
			popWin.focus();
		}
	}

	
	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!= "") return;

		//doActionIBSheet(sheetObj,document.form,IBSEARCH);
		for(var k=1; k<sheetObj.RowCount+1; k++)
		{
			sheetObj.CellValue2(k, "duple1") = "";
			sheetObj.CellValue2(k, "duple2") = "";
			sheetObj.RowStatus(k) = "R";
		}
	}
	
	function getYardZoneSheetComboDist(sheetObj, formObject, row, col, colName, value)
	{
		var srcValue = sheetObj.CellValue(row, colName);
		sheetObj.InitCellProperty(row, colName, dtCombo);
		formObject.f_cmd.value = SEARCH01;
		var queryString = "isZone=A&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
		sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
		
		fm_yard_value = sheetObj.EtcData('nod');
		sheetObj.RemoveEtcData();
		sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value) 

		if(fm_yard_value == '')
		{
			ComShowMessage(ComGetMsg('COM12161', value));
			sheetObj.CellValue2(row, col)="";
			sheetObj.SelectCell(row, col);
			return false;
		}
		return true;
	}

	/**
	 * Excel 파일 업로드 후 Sheet 처리 
	 */
	function sheet1_OnLoadExcel(sheetObj) {
		var formObject = document.form;
		for(var i=0; i<formObject.sheet1.RowCount; i++){
			sheet1_OnChange(sheetObj, i+1, 11, "");
		}	
		formObject.verify_check_yn.value="N";
	}

	/**
	 * 최초 로딩되어질때 구분
	 */
	function distance(row){

		var formObject = document.form;
		var gubun = formObject.sheet1.cellValue(row, 'dist_meas_ut_cd');

		if(gubun =="KM"){
			formObject.sheet1.CellValue2(row, 'conv_meas_ut_cd') = "ML";
		}else{
			formObject.sheet1.CellValue2(row, 'conv_meas_ut_cd') = "KM";
		}
	}



	/**
	 * 리셋펑션
	 */
	function fn_reset(){

		var formObject = document.form;	

		sheetObjects[0].RemoveAll();
		
		formObject.frm_node.value="";
		formObject.to_node.value="";
		formObject.frm_zip.value="";
		formObject.to_zip.value="";

		formObject.frm_yard.RemoveAll(); // combo 데이터삭제
		formObject.to_yard.RemoveAll(); // combo 데이터삭제

	}	

