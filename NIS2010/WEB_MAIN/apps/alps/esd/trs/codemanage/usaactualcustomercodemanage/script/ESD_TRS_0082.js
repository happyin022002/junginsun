/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0082.js
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-10-16 Kim Jun Ho
* History
* 2010.09.03 최종혁 [CHM-201005753] Actual customer 'Status flag' 변경시 표기사항 일부 변경 요청
* 2011.03.14 손은주 [CHM-201109256][TRS] Actual customer 상의 중복 Default 지정 Block 요청
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0082 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0082() {
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
var sheetObjects 	= new Array();
var sheetCnt 	= 0;
var Mincount 	= 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];

	var formObject = document.form;

	/*******************************************************/	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
	
			case "btn_retrieve":
	
				doActionIBSheet(sheetObject1, formObject, IBSEARCH, "btn_retrieve"  );

				if( sheetObject1.RowCount > 0 ){
					formObject.sel_trsp_act_cust_no.value = sheetObject1.cellValue(1, "trsp_act_cust_no");
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "DETAIL"  );
					doActionIBSheet(sheetObject3, formObject, IBSEARCH, "EXCEL"  );
				}
				break;

			case "btn_new":

				fn_reset();
				break;
					
			case "btng_downexcel":

				doActionIBSheet(sheetObject3, formObject, IBSEARCH, "EXCEL"  );

				doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
				break;

			case "btng_rowadd1":
				doActionIBSheet(sheetObject1,formObject,IBINSERT, srcName);
				sheetObject2.RemoveAll();
				break;

			case "btng_rowadd2":
                
				var checkList = sheetObject1.FindCheckedRow('ib_chk').split('|');

                if(checkList[0]>0) { 
                    var checkCustNo = sheetObject1.cellValue(checkList[0], 'trsp_act_cust_no');
                    if ( checkCustNo == '' || checkCustNo == null)
                    {
                        // 신규등록의 경우 Master Customer No 조회
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH, srcName);
                    } else {
                        doActionIBSheet(sheetObject2,formObject,IBINSERT, srcName);
                    }
                }

				break;

			case "btng_save":
				if (sheetObject2.RowCount == 0)
				{
					ComShowMessage('Please, input the detail data!');
					break;
				}
				doActionIBSheet (sheetObject1, formObject, IBSAVE, "MST"  );
				doActionIBSheet (sheetObject2, formObject, IBSAVE, "DTL"  );
				break;
			case 'btng_customer':
				popCustomer();
				break;
				
			case "btns_multiofc": //M Office
				openMultipleinquiry('OFC', 'Office');
				break;

		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {

	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSEARCH:

			switch(srcName) {

				case "btn_retrieve":
					if(!validateForm(sheetObj, formObj, IBSEARCH	, "btn_retrieve" ))	return false;
					
					document.form.input_cust_cd.value = document.form.input_cust_cd.value.toUpperCase();
					document.form.input_cust_nm.value = document.form.input_cust_nm.value.toUpperCase();
					document.form.input_cre_ofc_cd.value    = document.form.input_cre_ofc_cd.value.toUpperCase();

					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESD_TRS_0082GS.do", TrsFrmQryString(formObj));
					sheetObjects[1].RemoveAll();
					sheetObj.cellValue2(1, 'ib_chk') = 1;
					break;
				
				case "DETAIL":
					formObj.f_cmd.value 				= SEARCH01;
					sheetObj.DoSearch4Post("ESD_TRS_0082GS.do", TrsFrmQryString(formObj));
					break;
				
				case "EXCEL":
					if(!validateForm(sheetObj, formObj, IBSEARCH	, "btn_retrieve" ))	return false;
					
					sheetObjects[2].RemoveAll();
					formObj.f_cmd.value 				= SEARCH03;
					sheetObj.DoSearch4Post("ESD_TRS_0082GS.do", TrsFrmQryString(formObj));
					break;

				case "btng_rowadd2":
					var row = sheetObj.SelectRow;
					var act_cust_cnt_cd = sheetObj.CellValue(row,'act_cust_cnt_cd');
					var act_cust_bnd_cd = sheetObj.CellValue(row,'act_cust_bnd_cd');
					var dor_nod_cd = sheetObj.CellValue(row,'dor_nod_cd');

					var	urlStr = 'ibflag=R&act_cust_cnt_cd='+act_cust_cnt_cd+'&act_cust_bnd_cd='+act_cust_bnd_cd+'&dor_nod_cd='+dor_nod_cd+'&row='+row+'&col=trsp_act_cust_no';
					formObj.f_cmd.value = SEARCH04;
					sheetObj.DoRowSearch('ESD_TRS_0082GS.do',urlStr+'&'+TrsFrmQryString(formObj));

					break;
					
				case "cust_name":
					// Actual Customer Name 조회
					var row = sheetObj.SelectRow;
					var act_cust_cnt_cd = sheetObj.CellValue(row,'act_cust_cnt_cd');
					var	urlStr = 'ibflag=R&act_cust_cnt_cd='+act_cust_cnt_cd+'&row='+row+'&col=act_cust_nm';
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoRowSearch('ESD_TRS_0082GS.do',urlStr+'&'+TrsFrmQryString(formObj));
					
					var cust_nm = sheetObj.EtcData('CUST_NM');
					sheetObj.CellValue(row,'act_cust_nm') = cust_nm;
					if (cust_nm == "") sheetObj.CellValue2(row,'act_cust_cnt_cd') = "";
					break;
			}
			break;

		case IBSAVE	:	
			var sheetObject2 = sheetObjects[1];
			
			if(srcName == "MST") {
				/* 1건도 선택된 데이터 없으면 삭제처리 로직 수행 */
				var checkList 				= sheetObj.FindCheckedRow('ib_chk');
				var checkArray 				= checkList.split('|');
				if(checkArray == '') return false;

				if(!validateForm(sheetObj, formObj, IBSAVE	, "MST" ))	return false;	/* 저장된 Checked Row 확인할 필요없음.	*/

				var checkList = sheetObj.FindCheckedRow('ib_chk').split('|');
				var mst_delt_flg = sheetObj.cellValue(checkList, 'delt_flg');
				if(mst_delt_flg == 'Y')
				{
					var sheet2_rowcount = sheetObject2.rowcount;
					for (i=1; i<sheetObject2.rowcount+1; i++ )
					{
						var dtl_delt_flg = sheetObject2.cellValue(i, 'delt_flg');
						if(dtl_delt_flg == 'N')
						{
							//sheetObject2.CellValue2(i, 'ib_chk') = 1;
							sheetObject2.CellValue2(i, 'delt_flg') = 'Y';
						}
					}
				}
				formObj.f_cmd.value 			= MULTI;
				formObj.mst_dtl_indicator.value	= srcName;
				/* mySheet.DoSave(PageUrl, [SubParam], [Col] , [Quest], [UrlEncode])) 	*/
				sheetObj.DoSave("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), 'ib_chk',false);
			}
			if(srcName == "DTL") {
				if(!validateForm(sheetObj, formObj, IBSAVE	, "DTL" ))	return false;
				formObj.f_cmd.value 			= MULTI;
				formObj.mst_dtl_indicator.value	= srcName;
				/* mySheet.DoSave(PageUrl, [SubParam], [Col] , [Quest], [UrlEncode])) 	*/
				sheetObj.DoSave("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), false);
			}
			break;

		//ExcelDownload
		case IBDOWNEXCEL:
			sheetObj.SpeedDown2Excel(-1, false);
			break;

		// ADD Row
		case IBINSERT:
			//
			sheetObj.DataInsert(-1);

			switch(srcName) {

				case "btng_rowadd1":
					var row = sheetObj.SelectRow;
					sheetObj.CellValue2(row, 'act_cust_bnd_cd')= 'I';
					sheetObj.CellValue2(row, 'ib_chk')= 1;

					if(sheetObj.rowcount > 1) {
						var checked_loc1  = sheetObj.CellValue(row-1, "dr_loc_value");
						if (checked_loc1 == '' || checked_loc1 == null )
						{
							ComShowMessage("Input the door location!.");
							sheetObj.RowDelete(row, false);
							sheetObj.CellValue2(row-1, 'ib_chk')= 1;
							break;
						}

						var checkrow1 = sheetObj.CellValue(row-1, 'trsp_act_cust_no');
						var checkrow2 = sheetObj.CellValue(row, 'trsp_act_cust_no');
						var chk_cre_row1 = sheetObj.CellValue(row-1, 'cre_dt');

						if((checkrow1 == '' || checkrow1 == null || chk_cre_row1 == '' || chk_cre_row1 == null) || (checkrow1 == checkrow2))
						{
							ComShowMessage("You can't add row. Previous input data not saveed.!");
							sheetObj.RowDelete(row, false);
							sheetObj.CellValue2(row-1, 'ib_chk')= 1;
							break;
						}
					}					
					break;
				
				case "btng_rowadd2":
					var row = sheetObj.SelectRow;
					var sheetObject1 = sheetObjects[0];
					
					//Master Delete 되면 Detail Row add 불가
					var mst_row = sheetObject1.FindCheckedRow('ib_chk').split('|');
					var mst_delt_flg = sheetObject1.cellValue(mst_row, 'delt_flg');					
					if (mst_delt_flg == 'Y')
					{
						ComShowMessage('Please change the master status back to "Live"!!');
						sheetObj.RowDelete(row, false);
						break;
					}
					sheetObj.CellValue2(row, 'delt_flg')= 'N';
					sheetObj.CellValue2(row, 'trsp_act_cust_seq') = row ;
					sheetObj.CellValue2(row, 'cre_ofc_cd') = document.form.login_ofc_cd.value;
					sheetObj.CellValue2(row, 'cre_usr_id') = document.form.login_usr_id.value;
					//sheetObj.CellValue2(row, 'ib_chk') = 1 ;
							
					var check_cust = sheetObj.CellValue(1, 'trsp_act_cust_no');
					// Detail sheet의 1번째 key값 cust_no가 존재하면, 첫번째 key값으로 다음 row생성
					if(check_cust.length > 0) {

						var dupcheck1 = sheetObject1.CheckedRows("trsp_act_cust_no");

						if(dupcheck1 > 1)
						{
							ComShowMessage("You can't add row. Previous data not saveed.!");
							var row = sheetObject1.SelectRow;
							sheetObject1.RowDelete(row, false);
							break;
						}
						
						sheetObj.CellValue2(row, 'trsp_act_cust_no') = sheetObj.CellValue(1, 'trsp_act_cust_no');
						//sheetObj.CellValue2(row, 'ib_chk') = 1 ;
					} else {
						// Detail sheet의 1번째 key값 cust_no가 존재하지 않으면,
						// Master sheet의 checked된 cust_no를 가져온다. 이것도 없으면 우선 Master Save 하도록 Message Return

						if(sheetObject1.rowcount > 0 )
						{

							for(i=1; i<sheetObject1.rowcount+1; i++){
								if (sheetObject1.CellValue(i, "ib_chk") == 1 )
								{
									var checked_loc  = sheetObject1.CellValue(i, "dr_loc_value");
									var checked_yard = sheetObject1.CellValue(i, "dr_yard_value");
									var checked_cust_no = sheetObject1.CellValue(i, "trsp_act_cust_no");

									if (checked_loc == '' || checked_yard =="")
									{
										ComShowMessage("Input the door location!.");
										sheetObj.RemoveAll();
										sheetObject1.CellValue2(i, "trsp_act_cust_no") = '';
									}
								}
							}
							sheetObj.CellValue2(1, 'trsp_act_cust_no') = checked_cust_no;
							//sheetObj.CellValue2(1, 'dflt_act_cust_flg') = 1 ;
						}
					}
//					sheetObj.ib_chk.focus();
					break;
			}

			break;
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
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	var formObject = document.form;
	formObject.status.focus();

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
//    ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation
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
//    ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
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
				style.height = 200;
				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Sel|Status|Bound|Door Node|Door Node|Customer Code|Customer Name";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtRadioCheck, 	 40,   daCenter,  true,   "ib_chk");
				InitDataProperty(0, cnt++ , dtCombo,    	 80,   daCenter,  true,	  "delt_flg",				true,		"",			dfNone,			0,       true,		true,		1,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtCombo,     	 80,   daCenter,  true,   "act_cust_bnd_cd",		true,		"",			dfNone,				0,       true,		true,		1,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	 80,   daCenter,  true,   "dr_loc_value",			true,		"",			dfEngUpKey,         0,       true,		true,		5,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	 60,   daCenter,  true,   "dr_yard_value",		true,		"",			dfNone,				0,       true,		true,		2,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	120,   daCenter,  true,   "act_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,       	250,   daLeft,    true,   "act_cust_nm");

				InitDataProperty(0, cnt++ , dtHidden,        80,   daCenter,  true,   "trsp_act_cust_no");
				InitDataProperty(0, cnt++ , dtHidden,     	 80,   daCenter,  true,	  "cre_dt",				false,		"",			dfDateYmd,		0,       false,		false,		8,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtHiddenStatus,  30,   daCenter,  true,   "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,        80,   daCenter,  false,  "dor_nod_cd");

				InitDataCombo(0, 'act_cust_bnd_cd', act_cust_bnd_cdText, act_cust_bnd_cdCode);
				InitDataCombo(0, 'delt_flg', delt_flgText, delt_flgCode);
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 200;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(21, 0, 0, true); 

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Status|Default|Actual Customer Name|Zip Code|Address|TEL No|FAX No|Contact PIC|eMail Address|"
								+ "Remark|Creation Date|Creation Office|Creation User|Update Date|Update User|Deleted Date|Delete Office|Delete User";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(0, cnt++ , dtCheckBox,  40,	daCenter,  true,	"ib_chk");
				InitDataProperty(0, cnt++ , dtCombo,     	80,		daCenter,  true,	"delt_flg",				true,		"",			dfNone,			0,       true,		true,		1,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtCheckBox, 	70, 	daCenter,  true,	"dflt_act_cust_flg",	false,		"",			dfNone,			0,       true,		true,		50,		false,		false,	   "",	  false);

				InitDataProperty(0, cnt++ , dtData,        220,   	  daLeft,  true,	"act_cust_nm",			true,		"",			dfNone,			0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	  daLeft,  true,	"act_cust_zip_cd",   	false,		"",			dfNone,			0,       true,		true,		10,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        200,    	  daLeft,  true,	"act_cust_addr",		false,		"",			dfNone,			0,       true,		true,		200,	false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	  daLeft,  true,	"act_cust_phn_no",		false,		"",			dfNone,			0,       true,		true,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	  daLeft,  true,	"act_cust_fax_no",		false,		"",			dfNone,			0,       true,		true,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	  daLeft,  true,	"cntc_pson_nm",			false,		"",			dfNone,			0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        120,    	  daLeft,  true,	"act_cust_eml",			false,		"",			dfNone,			0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        600,    	  daLeft,  true,	"act_cust_rmk",			false,		"",			dfNone,         0,       true,		true,		1000,	false,		true,	   "",	  false);

				InitDataProperty(0, cnt++ , dtData,      	90,    	daCenter,  true,	"cre_dt",				false,		"",			dfDateYmd,		0,       false,		false,		8,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	90,    	daCenter,  true,	"cre_ofc_cd",			false,		"",			dfNone,			0,       false,		false,		6,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	90,    	daCenter,  true,	"cre_usr_id",			false,		"",			dfEngUpKey,     0,       false,		false,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	90,    	daCenter,  true,	"upd_dt",				false,		"",			dfDateYmd,		0,       false,		false,		8,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	90,    	daCenter,  true,	"upd_usr_id",			false,		"",			dfEngUpKey,     0,       false,		false,		20,		false,		true,	   "",	  false);

				InitDataProperty(0, cnt++ , dtData,      	80,    	daCenter,  true,	"delt_dt",				false,		"",			dfDateYmd,		0,       false,		false,		8,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daCenter,  true,	"delt_ofc_cd",			false,		"",			dfNone,			0,       false,		false,		6,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daCenter,  true,	"delt_usr_id",			false,		"",			dfEngUpKey,     0,       false,		false,		20,		false,		true,	   "",	  false);

				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   	daCenter,  true,	"ibflag");
				InitDataProperty(0, cnt++ , dtHidden,      	80,		daCenter,  true,	"trsp_act_cust_no");
				InitDataProperty(0, cnt++ , dtHidden,      	40,		daCenter,  true,	"trsp_act_cust_seq");

				InitDataCombo(0, 'delt_flg', delt_flgText, delt_flgCode);
				
			}
			break;

		case 3:      //sheet3 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable3.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(22, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Status|Bound|Door|Node|Customer Code|Customer Name|Default|Actual Customer Name|Zip Code|Address|TEL No|FAX No|Contact PIC|eMail Address|"
								+ "Remark|Creation Date|Creation Office|Creation User|Deleted Date|Delete Office|Delete User";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtCombo,     	80,	daCenter,  true,	"delt_flg",				true,		"",			dfNone,			0,       false,		false,		1,		false,		true,	   "",	  false);
				
				InitDataProperty(0, cnt++ , dtCombo,     	80,    	daLeft,  true,   "act_cust_bnd_cd",		true,		"",			dfNone,				0,       true,		true,		1,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,   "dr_loc_value",		true,		"",			dfEngUpKey,         0,       true,		true,		5,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	60,    	daLeft,  true,   "dr_yard_value",		true,		"",			dfNone,				0,       true,		true,		2,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	120,    daLeft,  true,   "act_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,     	150,    daLeft,  true,   "act_cust_nm1");
				InitDataProperty(0, cnt++ , dtData,	     	50,   daCenter,  true,	"dflt_act_cust_flg");
				
				InitDataProperty(0, cnt++ , dtData,     	220,    daLeft,  true,	"act_cust_nm2",			false,		"",			dfNone,			0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"act_cust_zip_cd",   	false,		"",			dfNone,			0,       true,		true,		10,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	200,    daLeft,  true,	"act_cust_addr",		false,		"",			dfNone,			0,       true,		true,		200,	false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"act_cust_phn_no",		false,		"",			dfNone,			0,       true,		true,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"act_cust_fax_no",		false,		"",			dfNone,			0,       true,		true,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"cntc_pson_nm",			false,		"",			dfNone,			0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	120,    daLeft,  true,	"act_cust_eml",			false,		"",			dfNone,			0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	600,    daLeft,  true,	"act_cust_rmk",			false,		"",			dfNone,         0,       true,		true,		1000,	false,		true,	   "",	  false);

				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"cre_dt",				false,		"",			dfDateYmd,		0,       false,		false,		8,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	90,    	daLeft,  true,	"cre_ofc_cd",			false,		"",			dfNone,			0,       false,		false,		6,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	90,    	daLeft,  true,	"cre_usr_id",			false,		"",			dfEngUpKey,     0,       false,		false,		20,		false,		true,	   "",	  false);

				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"delt_dt",				false,		"",			dfDateYmd,		0,       false,		false,		8,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"delt_ofc_cd",			false,		"",			dfNone,			0,       false,		false,		6,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,      	80,    	daLeft,  true,	"delt_usr_id",			false,		"",			dfEngUpKey,     0,       false,		false,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
				
				InitDataCombo(0, 'delt_flg', " |"+delt_flgText, " |"+delt_flgCode);
				InitDataCombo(0, 'act_cust_bnd_cd', " |"+act_cust_bnd_cdText, " |"+act_cust_bnd_cdCode);
			}
			break;
	
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == MULTI){
//			ComShowCodeMessage('COM12116', 'Save');
			
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == MULTI){
			ComShowCodeMessage('COM12116', 'Save');
		}

		var row = sheetObject1.FindCheckedRow('ib_chk').split('|');
		formObj.sel_trsp_act_cust_no.value = sheetObject1.cellValue(row, 'trsp_act_cust_no');
		sheetObj.RemoveAll();
		doActionIBSheet(sheetObj, formObj, IBSEARCH, "DETAIL"  );
		
		var checkList = sheetObject1.FindCheckedRow('ib_chk').split('|');
		sheetObject1.CellValue2(checkList, 'cre_dt')= formObj.login_date.value  ;
	}
}

/**
 * Sheet1 Search End Event
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	var sheetObject2 = sheetObjects[1];

	if( errMsg != null && errMsg != '' ) {
		if((formObj.f_cmd.value == SEARCH04 )||(formObj.f_cmd.value == SEARCH05 )){
			//ComShowMessage(errMsg);
		}else {
			ComShowMessage(errMsg);
		}

		if(formObj.f_cmd.value == SEARCH04) {
			var row = sheetObj.SelectRow;
			sheetObj.RowDelete(row, false);
			sheetObj.CellValue2(row-1, 'ib_chk')= 1;
			formObj.sel_trsp_act_cust_no.value = sheetObj.cellValue(row-1, "trsp_act_cust_no");
			doActionIBSheet(sheetObject2, formObj, IBSEARCH, "DETAIL"  );
		} else if (formObj.f_cmd.value == SEARCH05) {
			var row = sheetObj.SelectRow;
			sheetObj.CellValue2(row, 'act_cust_cnt_cd')= '';
			sheetObj.CellValue2(row, 'act_cust_nm')= '';
		}

	}else {
		if(formObj.f_cmd.value == SEARCH04) {
			//sequence no 채번
			var row = sheetObj.SelectRow;
			sheetObj.CellValue(row, 'trsp_act_cust_no')= sheetObj.EtcData('TEXT');
			doActionIBSheet(sheetObject2,formObj,IBINSERT, "btng_rowadd2");
		}

		if(formObj.f_cmd.value == SEARCH05) {
			//중복된 Customer가 아닐 경우엔  MDM에 등록된 Customer 인지 체크하고 등록된 업체라면 Customer name을 셋팅한다.
			doActionIBSheet(sheetObj,formObj,IBSEARCH, "cust_name");
		}
	}
}

/**
 * Sheet2 Search End Event
 */
 /*
function sheet2_OnSearchEnd(sheetObj, errMsg) {
//	var dflt_flg_row = sheetObj.FindCheckedRow('dflt_act_cust_flg').split('|');
    
    var checkList = sheetObj.FindCheckedRow('dflt_act_cust_flg');


    if(checkList != null && checkList != '') {
        var checkArray = checkList.split('|');
        sheetObj.cellValue2(checkArray, 'ib_chk') = 1;
    }
}*/


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName){

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	switch(sAction) {
			case IBSEARCH:
				switch(srcName){
					case "btn_retrieve":
						var check_cre_ofc_cd 	= document.form.input_cre_ofc_cd.value ;
						var check_cust_cd       = document.form.input_cust_cd.value ;
						var check_dor_loc    	= document.form.dor_loc.value ;
						if( (check_cre_ofc_cd == '' || check_cre_ofc_cd == null) &&
						    (check_cust_cd    == '' || check_cust_cd == null) &&
						    (check_dor_loc    == '' || check_dor_loc == null) ) 
						{
							ComShowMessage('The mandatory inquiry option is not inputted.');
							fn_reset();
							return false;
						}
					break;
				}
				break;

			case IBSAVE: 
				switch(srcName){
					case "MST":

						rowcount = sheetObject1.RowCount;

						for(i=rowcount; i>=0; i--)
						{
							if( (sheetObject1.cellValue(i, 'act_cust_bnd_cd') == '' || sheetObject1.cellValue(i, 'act_cust_bnd_cd') == null) ||
								(sheetObject1.cellValue(i, 'dr_loc_value') == ''    || sheetObject1.cellValue(i, 'dr_loc_value') == null) ||
								(sheetObject1.cellValue(i, 'dr_yard_value') == ''   || sheetObject1.cellValue(i, 'dr_yard_value') == null)	)
							{
								sheetObject1.RowDelete(i, false);
							}

						}
						break;

					case "DTL":
						var rowcount = sheetObject2.RowCount;
						var chk_dflt_cnt =0;
						var chk_live_cnt =0;
						if (sAction == IBSAVE){
							if(rowcount == 0) {
								ComShowMessage('Detail item is not exist!');
								return false;
							}
						}
						var check_dflt_flg 	= sheetObject2.FindCheckedRow('dflt_act_cust_flg').split('|');
						if (check_dflt_flg == ''|| check_dflt_flg == null){check_dflt_flg = 0}

						var checkList = sheetObject1.FindCheckedRow('ib_chk').split('|');
						var	mst_delt_flg = sheetObject1.CellValue(checkList, 'delt_flg');
						var	cust_cd = sheetObject1.CellValue(checkList, 'act_cust_cnt_cd');
						var dtl_delt_flg = sheetObject2.cellValue(check_dflt_flg, 'delt_flg');

						if (dtl_delt_flg == 'Y' && mst_delt_flg != 'Y'){
							ComShowMessage('Please assign "Default" flag to another row');
							sheetObj.CellValue2(check_dflt_flg, 'delt_flg')= 'N' ;
							return false;
						}

						for(var i=0;i<rowcount;i++){
							if(sheetObject2.cellValue(i+1, 'delt_flg')=="N" && sheetObject2.cellValue(i+1, 'dflt_act_cust_flg')=="1" ){
								chk_dflt_cnt++;
							}
							if(sheetObject2.cellValue(i+1, 'delt_flg')=="N"){
								chk_live_cnt++;
							}
						}

						if(chk_live_cnt > 0){
							if(chk_dflt_cnt != 1 && cust_cd!=""){
								ComShowMessage('Please assign "Default" flag');
								return false;
							}
						}
						
						break;
				}
				break;
	}
	return true;
}


/**
 * sheet1 Change Event
 **/
function sheet1_OnChange(sheetObj, row, col, value)
{
	var formObject = document.form;

	var colName = sheetObj.ColSaveName(col);

		switch(colName){

			case 'dr_loc_value':
				if( sheetObj.cellValue(row, 'dr_loc_value') != '' )
				{
					getZoneSheetCombo1(sheetObj, document.form, row, col, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));

				}

				var dor_loc = sheetObj.cellValue(row, 'dr_loc_value');
				var dor_yard = sheetObj.cellValue(row, 'dr_yard_value');
				
				sheetObj.cellValue(row, 'dor_nod_cd') = dor_loc + dor_yard ;

				break;

			case 'dr_yard_value':
				var dor_loc = sheetObj.cellValue(row, 'dr_loc_value');
				var dor_yard = sheetObj.cellValue(row, 'dr_yard_value');
				
				sheetObj.cellValue(row, 'dor_nod_cd') = dor_loc + dor_yard ;
				break;

			case 'ib_chk' :

				formObject.sel_trsp_act_cust_no.value = sheetObj.cellValue(row, "trsp_act_cust_no");
				break;

			case 'act_cust_cnt_cd' :

				sheetObj.CellValue2(row, col) = value.toUpperCase();

				var act_cust_cnt_cd = sheetObj.cellValue(row, 'act_cust_cnt_cd');
				if (act_cust_cnt_cd == null) break;
				
				var act_cust_bnd_cd = sheetObj.CellValue(row,'act_cust_bnd_cd');
				var dor_nod_cd = sheetObj.CellValue(row,'dor_nod_cd');
				
				// 중복여부 Check
				var	urlStr = 'ibflag=R&act_cust_cnt_cd='+act_cust_cnt_cd+'&act_cust_bnd_cd='+act_cust_bnd_cd+'&dor_nod_cd='+dor_nod_cd+'&col=act_cust_nm';
				formObject.f_cmd.value = SEARCH05;
				sheetObj.DoRowSearch('ESD_TRS_0082GS.do',urlStr+'&'+TrsFrmQryString(formObject));			

				sheetObj.CellValue2(row, 'ib_chk')= 1 ;
				break;

			case 'delt_flg' :
			case 'act_cust_bnd_cd':
				sheetObj.cellValue2(row, 'ib_chk') = 1 ;
				break;

	}
}

/**
 * sheet2 Change Event
 **/
function sheet2_OnChange(sheetObj, row, col, value)
{
	var formObject = document.form;


	var colName = sheetObj.ColSaveName(col);

		switch(colName){
			case('act_cust_eml'):
				var eMailchk = new RegExp('^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,6}\\b');
				var aRray = new Array();
				if( value.split(',').length > 1 ) {
					aRray = value.split(',');
					for( var e = 0; e < aRray.length; e++ ) {
						if(!eMailchk.test(aRray[e]) && aRray[e] != '') {
							ComShowCodeMessage('TRS90525');
							sheetObj.CellValue2(row, 'act_cust_eml') = '';
							sheetObj.SelectCell(row, 'act_cust_eml');
						}
					}
				} else if( value.split(';').length > 1 ) {
					aRray = value.split(';');
					for( var e = 0; e < aRray.length; e++ ) {
						if(!eMailchk.test(aRray[e]) && aRray[e] != '') {
							ComShowCodeMessage('TRS90525');
							sheetObj.CellValue2(row, 'act_cust_eml') = '';
							sheetObj.SelectCell(row, 'act_cust_eml');
						}
					}
				} else {
					if(!eMailchk.test(value) && value != '') {
						ComShowCodeMessage('TRS90525');
						sheetObj.CellValue2(row, 'act_cust_eml') = '';
						sheetObj.SelectCell(row, 'act_cust_eml');
					}
				}
			break;

			case('dflt_act_cust_flg'):
				var l_flg = sheetObj.CellValue(row, 'dflt_act_cust_flg');
				for( var i=1; i<(sheetObj.RowCount+1); i++ ) {
					sheetObj.CellValue2(i, 'dflt_act_cust_flg') = '';
				}
				if (l_flg == '1') {
					sheetObj.CellValue2(row, 'dflt_act_cust_flg') = 'Y';
				}else{
					sheetObj.CellValue2(row, 'dflt_act_cust_flg') = 'N';
				}
			break;
	}
}


/**
 * sheet click시 일어나는 이벤트
 **/
function sheet1_OnClick(sheetObj, row, col, value)
{
	if(sheetObj.ReadDataProperty(row, col, 0)==6) 
	{	
		return;
	}
	var colName = sheetObj.ColSaveName(col);

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var formObject = document.form;
	switch(colName){

		case 'act_cust_bnd_cd':
		case 'dr_loc_value':
		case 'dr_yard_value':
		case 'act_cust_cnt_cd':
		case 'delt_flg' :
			sheetObj.cellValue2(row, 'ib_chk') = 1 ;
			break;

		case 'ib_chk':		
		case 'act_cust_nm':
			
			sheetObj.cellValue2(row, 'ib_chk') = 1 ;
			
			var act_cust_no_chk = sheetObject1.cellValue(row, "trsp_act_cust_no");
			if (act_cust_no_chk == null || act_cust_no_chk == '')
			{ 
				sheetObject2.RemoveAll();  //Detail sheet
				break;
			}
			// SHEET2 Detail 1번째 row의 cretaion date가 null이면 save가 안된 상태이기 때문에 return.
			var master_save_chk = sheetObject1.cellValue(row, "cre_dt");
			if (master_save_chk == null || master_save_chk == '')
			{ 
				sheetObject2.RemoveAll();  //Detail sheet
				break;
			}
			
			formObject.sel_trsp_act_cust_no.value = sheetObject1.cellValue(row, "trsp_act_cust_no");
			doActionIBSheet(sheetObject2, formObject, IBSEARCH, "DETAIL"  );
			break;

	}

}
 
/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //Master sheet
	sheetObjects[1].RemoveAll();  //Detail sheet
	sheetObjects[2].RemoveAll();  //Excel sheet

	formObject.dor_nod.RemoveAll();

	formObject.status.value="A";
	formObject.bound.value="A";
	formObject.dor_loc.value="";
	formObject.input_cust_cd.value="";
	formObject.input_cust_nm.value="";
	formObject.sel_trsp_act_cust_no.value="";
	formObject.input_cre_ofc_cd.value=formObject.login_ofc_cd.value;



}	

/**
 *	Inquiry Option
 *	Door Location input, Yard Inquiry
 */
function getComboList(obj)
{
	var yard_obj = null;
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
	var locValue = obj.value;

	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}

	if(obj.name == 'dor_loc'){
		yard_obj = document.dor_nod;

		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}

}

/**
 * Customer Popup
 */
function popCustomer(){
	ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'setCustomerPop', '1,0,1,1,1,1,1,1');
}

/**
 * customer Popup
 */
function setCustomerPop(rowArray){
	var formObj = document.form;
	var colArray = '';
	
	if(rowArray.length>0)
	{
		formObj.input_cust_cd.value = rowArray[0][3];
		//formObj.input_cust_nm.value = rowArray[0][4];
	}

}

function fun_Focus(obj)
{
	var val = obj.value;
	obj.value = val;
	obj.select();
}

/**
 * 공통 Multiple popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if( obj == "OFC" ) {
		formObject.input_cre_ofc_cd.value = reObj;
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

//Office의 Text 변경시
function fun_officeText() {
	document.form.input_cre_ofc_cd.value = document.form.input_cre_ofc_cd.value.toUpperCase();
}
