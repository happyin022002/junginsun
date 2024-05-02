/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0004.js
 *@FileTitle : Tariff List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.31
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.06.03 박명종
 * 1.0 Creation
 *  
 * History
 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
 * 2011.04.22 진마리아 CHM-201109292-01 Location Code(숫자포함)의 Validation 체크로직 수정
 * 2011.07.15 김기종 CHM-201111662-01 Formula 및 Condition ID 입력 변경 & 칼럼 숨김 요청
 * 2011.11.10 진마리아 CHM-201114331-01 [VOP-PSO] Formula Selection 내 Add Row 로직 변경건
 * 2013.07.23 SKY    CHM-201325679  [VOP-PSO] Tariff 생성시 effective date 값 변경
 * 2014.03.20 이윤정 [CHM-201429328] [PSO] Tariff Creation 화면에서 Invoice 생성 여부와 관계없이 Delete 버튼 활성화
 * 2014.07.07 이성훈 CHM-201430928 Port 기준으로 조회되는 Currency 호출로직을 Service Provider 기준으로 변경
 * 2014.07.16 이성훈   CHM-201430928    Port Tariff Contract 및 URL 저장
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
 * @class Service Provider Help : Service Provider Help 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0004() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;    	
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var gSheet2_obj_list_no = "";		//sheet2에서 Object 		콤보가  변경될때, 변경 전 값을 갖고 있음.
var gSheet2_object_code_dsp = "";	//sheet2에서 UOM 		콤보가  변경될때, 변경 전 값을 갖고 있음.
var gSheet2_object_code = "";		//sheet2에서 UOM 		콤보가  변경될때, 변경 전 값을 갖고 있음.
var gSheet2_rate_code = "";			//sheet2에서 Rate Type 	콤보가  변경될때, 변경 전 값을 갖고 있음.
var gColumnCountInSheet2 = 0;		//sheet2의 Column Count
var gSelectEvent = true;			//Sheet1 Row삭제시 OnSelect Event 발생시키지 않음.
var gObjUomInSheet2 = new Object();

var WIDTH_FORMULA_POPUP = 700;		//VOP_PSO_0209.do Popup 
var HEIGHT_FORMULA_POPUP = 420;
var WIDTH_CONDITION_CREATION_POPUP = 800;	//VOP_PSO_0206.do Popup
var HEIGHT_CONDITION_CREATION_POPUP = 290;
var WIDTH_COPY_POPUP = 750;	//VOP_PSO_0211.do Popup
var HEIGHT_COPY_POPUP = 650;
var POP_TITLE_0206 = "Formula Condition";		//VOP_PSO_0004의 특정 버튼에서 띄울때만 'Rate Condition'이 됨.
var HEIGHT_SHEET2 = 275;
var HEIGHT_SHEET3 = 102;

var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
var conditionXML = "";	//페이지로딩시 조회조건 세팅용 쿼리 결과
var searchVersionXML = "";	//Version 조회결과

var arrFormulaNo = new Array();	//페이지로딩시 Formula_No IN (1, 2) 가져옴 
var rowIdx = 10;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var sheetObject5 = sheetObjects[4];
	var sheetObject6 = sheetObjects[5];	//Base Dummy

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		
			case "btn_RowAdd":
				if( !validateForm(sheetObject1,formObject,IBSEARCH)) return;
				
				var prefix = "sheet1_";	
				var selectRow = sheetObject1.SelectRow;
	
				if( comboObjects[3].Text == "" ) {	// comboObjects[4] -> 3 으로 변경완료]
					ComShowCodeMessage('PSO00005');
					return;
				}
				
				/*조회결과가 없을시
				 */   
				 
				if( sheetObject1.RowCount == 0 ){	//신규 첫행

				} else if(sheetObject1.RowCount > 0){	//두번째 행부터
					if( sheetObject1.CellValue( sheetObject1.LastRow, "sheet1_formula_no") == ""){ 
						ComShowCodeMessage('PSO00003');
						return;
					}			
				}
	
				//UK 채번 
				var minVal = f_GetMinValInSheet(sheetObject1, "sheet1_uk") - 1;
				sheetObject1.DataInsert(-1);
				
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[0]", "rows" : "0,1", "col" : "sheet1_del_chk"}]);
                 
				selectRow = eval(sheetObject1.SelectRow);
				sheetObject1.CellValue2(selectRow, "sheet1_seq") = 10;
				sheetObject1.CellValue2(selectRow, "sheet1_uk") = minVal;	//음수값으로 UK설정함, Base Child에 UK전달  
				//sheetObject1.CellValue2(selectRow, "sheet1_seq2") = " ";	//
				sheetObject1.CellValue2(selectRow, "sheet1_upd_mnu_no_cond") = "1";	//빵집에서 만든 것으로 인식시킴		
			break;

			case "btn_Delete":	//It is complicated. 
				var prefix = "sheet1_";	
				var selectRowBf = eval(sheetObject1.SelectRow);
				gSelectEvent = false;
			
				//체크된 행 삭제 (Sheet6, Sheet2)
				for( var i=sheetObject1.LastRow; i>=sheetObject1.HeaderRows; i-- ) { 
					if(sheetObject1.CellValue(i, prefix + "del_chk") == 1){
						var sheet1_uk = sheetObject1.CellValue(i, prefix + "uk");
						
						f_RemoveDummyByBase(sheet1_uk);	//Dummy(Sheet6)	삭제
						if(sheetObject2.RowCount > 0){
							//Sheet2 삭제
							if(sheetObject2.CellValue(sheetObject2.HeaderRows, "sheet2_uk") == sheet1_uk){
								sheetObject2.RemoveAll();
								sheetObject3.RemoveAll();
							}
						}
					}
				} 
			
				//체크된 행 삭제 (Sheet1)
				sheetObject1.Redraw = false;
				for( var i=sheetObject1.LastRow; i>=sheetObject1.HeaderRows; i-- ) {
					if(sheetObject1.CellValue(i, prefix + "del_chk") == 1){
						sheetObject1.RowDelete( i, false );
					}
				}
				sheetObject1.Redraw = true;

				//[2009.11.18] Sheet1의 Row 삭제중에는 OnSelect Event를 발생시키지 않고, 최종 Focus된 Row의 정보를 가져온다.
				//if(selectRowBf == sheetObject1.SelectRow){	//삭제후 row가 바뀌지 않으면, onSelect Event가 발생하지 않는다.	
					var seletedRow = sheetObject1.SelectRow;
					f_SetComboItemByFormula(sheetObject1.CellValue(seletedRow, "sheet1_foml_sys_desc"));	//선택된 행의 Formula에 속한 Object만을 Combo로 만들기
					f_CopyDummy2Base(sheetObject1.CellValue(seletedRow, "sheet1_uk"));
					document.getElementById("foml_desc").innerHTML = sheetObject1.RowCount > 0 ? sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_foml_desc") : "";
					document.getElementById("cond_desc").innerHTML = sheetObject1.RowCount > 0 ? sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cond_desc") : "";
				//}
				sheetObject1.Redraw = true;	//한번 더 Redraw
				gSelectEvent = true;
				f_ControlGridCopyButton();	//Grid Copy Button
			break;		
			
			case "btn_RowAdd2":	//[2009.11.05] '///' 주석은 현업테스트시 데이터입력을 용이하게 하기 위한 조치
			
				  if(formObject.row_cnt.value <=0 ) {formObject.row_cnt.value = 1 ;}
			         
				     for( var i=1; i<=formObject.row_cnt.value; i++ ) { 
				    
						if( !validateForm(sheetObject2,formObject,IBSEARCH)) return;
						
						var selectRow1 = sheetObject1.SelectRow;
						
						var prefix = "sheet2_";	
						
						if (selectRow1 < 0 || sheetObject1.RowCount == 0) {
							ComShowCodeMessage('PSO00022', "[Base Formula]");		//Please select {?msg1}.
							return;
						} 
						else {
							if (sheetObject1.CellValue(selectRow1, "sheet1_formula_no") == "") {
								ComShowCodeMessage('PSO00036', "[Formula ID]");		//Please input {?msg1}.
								return;
							}
						}

					//	if (comboObjects[3].Text == "") {	// comboObjects[4] -> 3 으로 변경완료
							///ComShowCodeMessage('PSO00005');
							///return;
					//	}		
						
						/*조회결과가 없을시, Row Add 가 안 됨
						 */   
					//	if (sheetObject2.RowCount == 0) {	//신규 첫행

					//	} 
					//	else if (sheetObject2.RowCount > 0) {	//두번째 행부터
					//		if (sheetObject2.CellValue(sheetObject2.LastRow, "sheet2_rate_code") == "F") {
					//			if (sheetObject2.CellValue( sheetObject2.LastRow, "sheet2_obj_list_no") == ""
					//				||	sheetObject2.CellValue( sheetObject2.LastRow, "sheet2_rate_value") == "") { 
									///ComShowCodeMessage('PSO00003');
									///return;
						//		}						
						//	} 
						//	else {
						//		if (sheetObject2.CellValue( sheetObject2.LastRow, "sheet2_obj_list_no") == "" 
						//			||  sheetObject2.CellValue( sheetObject2.LastRow, "sheet2_range_from") == ""
						//			||	sheetObject2.CellValue( sheetObject2.LastRow, "sheet2_range_to") == "" 
						//			||	sheetObject2.CellValue( sheetObject2.LastRow, "sheet2_rate_value") == "") { 
									///ComShowCodeMessage('PSO00003');
									///return;
						//		}		
						//	}
						//}

						sheetObject2.DataInsert(-1);  
						//HeadCheck Uncheck
						f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[1]", "rows" : "0,1", "col" : "sheet2_del_chk"}]);
					
						var selectRow2 = eval(sheetObject2.SelectRow);
						var selectRow6 = eval(sheetObject6.SelectRow);
						sheetObject2.CellValue2(selectRow2, "sheet2_uk") = sheetObject1.CellValue(selectRow1, "sheet1_uk");  
						sheetObject2.CellValue2(selectRow2, "sheet2_obj_list_no") = "";	//콤보 디폴트선택을 없애기위해
						sheetObject2.CellValue2(selectRow2, "sheet2_rate_code") = "";	
						if (selectRow2 == sheetObject2.HeaderRows) {	//첫번째 신규행은
							sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_seq") = 10;
						} 
						
						//else if (selectRow2 > sheetObject2.HeaderRows) {	//두번째 행부터는 이전 행 복사하여 디폴트 표현
						//	sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_obj_list_no") = sheetObject2.CellValue(sheetObject2.LastRow - 1, "sheet2_obj_list_no");
						//	sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_object_code_dsp") = sheetObject2.CellValue(sheetObject2.LastRow - 1, "sheet2_object_code_dsp");
						//	if (sheetObject2.CellValue(sheetObject2.LastRow - 1, "sheet2_rate_code") != "F") {
						//		sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_seq") = sheetObject2.CellValue(sheetObject2.LastRow - 1, "sheet2_seq");
						//		sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_rate_code") = sheetObject2.CellValue(sheetObject2.LastRow - 1, "sheet2_rate_code");
								//sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_range_from") = ""+(eval(sheetObject2.CellValue(  sheetObject2.LastRow - 1 , "sheet2_range_to"))+1);
						//		sheetObject2.CellEditable(sheetObject2.LastRow, "sheet2_condition") 	= false;
						//		sheetObject2.CellEditable(sheetObject2.LastRow, "sheet2_cons_als_nm") 	= false;
						//	} 
							else {
								sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_seq") = Number(sheetObject2.CellValue(sheetObject2.LastRow - 1, "sheet2_seq")) + 10;
							}
						//}
						//Rate Type이 Fixed일 경우 Range From,To Col Hidden처리
						//f_SetRateTypeRangeColShow();
				     }
				     formObject.row_cnt.value ="";
				     document.form.row_cnt.value = "1";
						break;
					
			case "btn_Delete2":
				var prefix = "sheet2_";	
				var selectRow = eval(sheetObject2.SelectRow);
				
				//체크된 행 삭제
				for( var i=sheetObject2.LastRow; i>=sheetObject2.HeaderRows; i-- ) {
					if(sheetObject2.CellValue(i, "sheet2_del_chk") == 1){
						sheetObject2.RowDelete( i, false );
					}
				}
				
				if(sheetObject2.LastRow < sheetObject2.HeaderRows){
					ComBtnEnable("btn_RowAdd2");
				}
				
				f_RearrangeInSheet2();
				
				//Rate Type이 Fixed일 경우 Range From,To Col Hidden처리
				f_SetRateTypeRangeColShow();
				break;		
			
			case "btn_RowAdd3":		//Regular Value
				if( !validateForm(sheetObject4,formObject,IBSEARCH)) return;
				
				sheetObject3.DataInsert(-1);
				var selectRow3 = eval(sheetObject3.SelectRow);
				sheetObject3.CellValue2(selectRow3, "sheet3_obj_list_no") = "";	//콤보 디폴트선택을 없애기위해
				
				break;
			
			case "btn_Delete3":		//Regular Value	
				//체크된 행 삭제
				for( var i=sheetObject3.LastRow; i>=sheetObject3.HeaderRows; i-- ) {
					if(sheetObject3.CellValue(i, "sheet3_del_chk") == 1){
						sheetObject3.RowDelete( i, false );
					}
				}
				break;
				
			case "btn_RowAdd4":		//Surcharge
				if( !validateForm(sheetObject4,formObject,IBSEARCH)) return;
				
				sheetObject4.DataInsert(-1);
				
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[3]", "rows" : "0,1", "col" : "sheet4_del_chk"}]);
				
				//sheetObject4.CellValue2(sheetObject4.LastRow, "sheet4_seq2") = "0";
				sheetObject4.CellValue2(sheetObject4.LastRow, "sheet4_upd_mnu_no_cond") = "1";	//빵집
				selectRow = eval(sheetObject4.SelectRow);
				sheetObject4.CellValue2(sheetObject4.LastRow, "sheet4_seq") = 10*selectRow; 
				
				//Call sheet4_Onchange()
				sheetObject4.CellValue2(sheetObject4.LastRow, "sheet4_method_code") = ""; 
				sheetObject4.CellValue(sheetObject4.LastRow, "sheet4_method_code") = "A"; 
				
				break;
	
			case "btn_Delete4":		//Surcharge	
				//체크된 행 삭제
				for( var i=sheetObject4.LastRow; i>=sheetObject4.HeaderRows; i-- ) {
					if(sheetObject4.CellValue(i, "sheet4_del_chk") == 1){
						sheetObject4.RowDelete( i, false );
					}
				}
				break;
				
			case "btn_RowAdd5":		//Discount
				if( !validateForm(sheetObject5,formObject,IBSEARCH)) return;
				
				sheetObject5.DataInsert(-1);
				
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[4]", "rows" : "0,1", "col" : "sheet5_del_chk"}]);
				
				//sheetObject5.CellValue2(sheetObject5.LastRow, "sheet5_seq2") = "0";
				sheetObject5.CellValue2(sheetObject5.LastRow, "sheet5_upd_mnu_no_cond") = "1";
				selectRow = eval(sheetObject5.SelectRow);
				sheetObject5.CellValue2(sheetObject5.LastRow, "sheet5_seq") = 10*selectRow; 
	
				//Call sheet5_Onchange()
				sheetObject5.CellValue2(sheetObject5.LastRow, "sheet5_method_code") = ""; 
				sheetObject5.CellValue(sheetObject5.LastRow, "sheet5_method_code") = "A"; 
				
				break;
				
			case "btn_Delete5":		//Discount	
				//체크된 행 삭제
				for( var i=sheetObject5.LastRow; i>=sheetObject5.HeaderRows; i-- ) {
					if(sheetObject5.CellValue(i, "sheet5_del_chk") == 1){
						sheetObject5.RowDelete( i, false );
					}
				}
				break;	

			case "btn_GridCopy":
				var selectRow = sheetObjects[0].SelectRow;
				
				//Formula를 선택하지 않으면, Grid Copy 금지
				if(selectRow < 0 || sheetObject1.RowCount == 0){
					ComShowCodeMessage('PSO00022', "[Base Formula]");
					return;
				} else{
					if(sheetObject1.CellValue(selectRow, "sheet1_formula_no") == ""){
						ComShowCodeMessage('PSO00036', "[Formula ID]");
						return;
					}
				}
				
				if(selectRow > sheetObjects[0].HeaderRows){	
					f_CopyDummy2Base(sheetObjects[0].CellValue(selectRow - 1, "sheet1_uk"));
					for(i=sheetObjects[1].HeaderRows; i<sheetObjects[1].LastRow+1; i++){ 
						sheetObjects[1].CellValue2(i, "sheet2_uk") = sheetObjects[0].CellValue(selectRow, "sheet1_uk");
					}
				} 
	
				break;
	

			case "btn_port_cd":
				var sUrl = "/hanjin/VOP_VSK_0043.do?op=0043";
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
				if(rVal){
					formObject.port_cd.value = rVal;
					loadTerminal();				//COMBO YARD
					f_SetComboAccount(rVal);	//COMBO ACCOUNT		
					f_RemoveAllSheet();
					comboObjects[0].focus();
				}
				break;
				
			case "btns_VendorSeq":
				//ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 430, 'setVendorSeq', '1,0,1,1,1', true);
				ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setVendorSeq', '0,0', true, true);
				break;
				
			case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal = new ComCalendar();
				cal.select(formObject.from_date, 'yyyy-MM-dd');
			break;
	
			case "btns_Calendar2" :		// Agreement Date (To Date)
				var cal = new ComCalendar();
				cal.select(formObject.to_date, 'yyyy-MM-dd');
			break;
			
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);	
				formObject.csearch.value = "1";
				break;
	
			case "btn_New":
				formObject.csearch.value = "";
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break;
				
			case "btn_Save":
				ComOpenWait(true);
				doActionIBSheet(sheetObject1,formObject,IBSAVE);	
				ComOpenWait(false);
				break;
				
			case "btn_DataDelete":
				ComOpenWait(true);
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
				ComOpenWait(false);
				break;
				
			case "btn_Copy":
				if( formObject.port_cd.value == '' || formObject.port_cd.value.length != 5) {
					ComShowCodeMessage("PSO00003", "[Port]");	
					formObject.port_cd.focus();
					return; 
				}	
				if( comboObjects[2].Code == '' ) {
					ComShowCodeMessage("PSO00003", "[Account/Cost]");	
					//formObject.vndr_seq.focus();
					return; 
				}	
				if( formObject.vndr_seq.value == '' ) {
					ComShowCodeMessage("PSO00003", "[Service Provider]");	
					formObject.vndr_seq.focus();
					return; 
				}	
				
				var param  = "port_cd="   + sheetObjects[0].UrlEncoding(formObject.port_cd.value);
				    param += "&yd_cd="    + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 
				    param += "&acct_cd="  + sheetObjects[0].UrlEncoding(comboObjects[1].Code);
				    param += "&acct_nm="  + sheetObjects[0].UrlEncoding(formObject.account_nm.value);
				    param += "&cost_cd="  + sheetObjects[0].UrlEncoding(comboObjects[2].Code);
				    param += "&cost_nm="  + sheetObjects[0].UrlEncoding(formObject.lgs_cost_nm.value);
				    param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(Number(formObject.vndr_seq.value));
				    param += "&vndr_nm="  + sheetObjects[0].UrlEncoding(formObject.vndr_lgl_eng_nm.value);
				
				var sUrl = "/hanjin/VOP_PSO_0212.do?" + param;
				var sFeatures = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_COPY_POPUP + ",height=" + HEIGHT_COPY_POPUP;
				ComOpenWindow(sUrl, "COPY", sFeatures, false);
				
				break;
				
				// ======================================================================================================
				// 수정일자 : 2014.07.07
				// 수정내용 : Contract/Regulation 필드 추가
				// ======================================================================================================
				case "btn_cntr_cd":
					var param  = "yd_chg_no=" + sheetObject1.UrlEncoding(ComGetObjValue(formObject.yd_chg_no));
			            param += "&yd_chg_ver_seq=" + sheetObject1.UrlEncoding(comboObjects[4].Code);	// comboObjects[3] -> 4 으로 변경완료
			            param += "&caller=" + "0004";
					ComOpenPopup("VOP_PSO_0041.do?" + param, 422, 530, "setContract", "1,0,1,1,1,1,1", false);
					break;				
				// ======================================================================================================

				// ======================================================================================================
				// 수정일자 : 2014.07.07
				// 수정내용 : Remark 필드 추가
				// ======================================================================================================
				case "btn_port_trf_rmk":
					// 화면에서 직접 remark 를 팝업화면으로 전달하다가, 
					// 추가변경요청으로 size 가 4000byte까지 늘어나면서(약 3800 character 을 초과하면서) ibsheet 에서 에러가 발생됨
					// remark 팝업화면에서 조회를 통해서 가져오도록 수정함. 2014.08.06			
					var param  = "yd_chg_no=" + sheetObject1.UrlEncoding(ComGetObjValue(formObject.yd_chg_no));
		            	param += "&yd_chg_ver_seq=" + sheetObject1.UrlEncoding(comboObjects[4].Code);	// comboObjects[3] -> 4 으로 변경완료
					    param += "&caller=" + "0004";
					ComOpenPopup("VOP_PSO_0042.do?" + param, 422, 350, "setPortTrfRmk", "1,0,1,1,1,1,1", true);
					break;				
				// ======================================================================================================					

		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function loadTerminal() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	comboObjects[0].RemoveAll();
	formObj.f_cmd.value = COMMAND01;
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
	addComboItem(comboObjects[0], comboItems);
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
	//Version Combo
	comboObjects[4].Enable = false;	// comboObjects[3] -> 4 으로 변경완료

	initControl(sheetObjects[0]);
	
	//xsheet1_OnLoadFinish(sheetObjects[0]);
	//xsheet2_OnLoadFinish(sheetObjects[1]);
	//xsheet3_OnLoadFinish(sheetObjects[2]);
}


/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  {object} sheetObj	필수
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */
function initControl(sheetObj){
	// Form 객체 선언
	formObj = document.form;
	setToday(formObj.from_date);
	formObj.to_date.value = '9999-12-31';
	
//	setToday(formObj.to_date);
	
	
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('click', 'obj_click', form);
	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
	axon_event.addListenerForm  ('drop', 'obj_drop', form);
}


/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	switch(comboNo) {  
		case 1:		//Yard 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				SetColAlign("center|left");        
				SetColWidth("40|300");
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자
				MaxLength = 2;
			}
	
			break; 
			
		case 2:		//Account 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
				MaxLength = 6;
			}
			
			break; 			
		case 3:		//Cost 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 6;
			}
			
			break; 			
		case 4:		//Version 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
			}
			
			break; 			
	
		case 5:		//Currency
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 3;
			}
	
			break; 	
	} 
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */ 
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			if(obj.name=="vndr_seq"){
				//ComKeyOnlyNumber(obj,",");
				ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
			} else if(obj.name=="org_vndr_nm"){
				ComKeyOnlyAlphabet('num')
			} else {
				ComKeyOnlyNumber(obj);
			}
			break;
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			if(obj.name=="vsl_slan_cd"){
				ComKeyOnlyAlphabet('uppernum');
			} else {
				ComKeyOnlyAlphabet('upper');
			}
			
			break;
		case "engdn":
			if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
			else ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}


 /**
  * 콤보필드에 데이터를 추가해준다. (Currency, Yard)
  */	
 function addComboItem(comboObj,comboItems) {
 	for (var i = 0 ; i < comboItems.length ; i++) {
 		var comboItem = comboItems[i].split(FIELDMARK);
 		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
 	}   		
 }

 /**
  * 콤보필드에 데이터를 추가해준다.(Version 전용)
  */	
 function addComboItemVersion(comboObj,comboItems) {
 	for (var i = 0 ; i < comboItems.length ; i++) {
 		var comboItem = comboItems[i].split(FIELDMARK);
 		//Text : Version|FromDt~ToDt|Curr_Cd
 		comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3], comboItem[1] );
 		//최신 Version만 보여주기로 함
// 		if(i == 0) break;
 	}   		
 }
  
 /**
  * 콤보필드에 데이터를 추가해준다. (Account)
  * EGSUZ,PAPAC Port의 경우, 511911 Account만 보여줌 
  */	 
 function addComboItemAccount(isCanal) {
 	 
 	comboObjects[1].UseCode = true;
 	comboObjects[1].RemoveAll();
 	
 	var comboItems = ComGetEtcData(conditionXML, "account").split(ROWMARK);
 	var comboItem = "";
 	if(comboItems != ""){
 		
 		if(isCanal == "CANAL_X"){			//Canal이 아닌 경우
 			for (var i = 0 ; i < comboItems.length ; i++) {
 				comboItem = comboItems[i].split(FIELDMARK);
 				if(comboItem[1] != "511911"){
 					comboObjects[1].InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
 				}
 			}   
 		} else if(isCanal == "CANAL_O"){	//Canal인 경우	
 			var accountForCanal = ComGetEtcData(conditionXML, "accountForCanal").split(FIELDMARK);
 			comboObjects[1].InsertItem(-1, accountForCanal[1] + "|" + accountForCanal[0], accountForCanal[1]);
 		}
 		
 		comboObjects[1].Index = 0;
 	}else{
 		ComShowMessage("There is no registered account at this office.");
 	}
 }
  
 /**
  * 콤보필드에 데이터를 추가해준다. (Cost)
  */	
 function addComboItemCost(code) {	
 	comboObjects[2].UseCode = true;
 	comboObjects[2].RemoveAll();
 	
 	var accountItems = ComGetEtcData(conditionXML, "account" ).split(ROWMARK);
 	var accountItem = "";
 	var costItems = ComGetEtcData(conditionXML, "cost" ).split(ROWMARK);
 	var costItem = "";
 	
  	for (var i = 0 ; i < costItems.length ; i++) {
  		accountItem = accountItems[i].split(FIELDMARK);
  		
  		if(accountItem[1] == code){ 		
 	 		costItem = costItems[i].split(FIELDMARK);
 	 		comboObjects[2].InsertItem(-1, costItem[0] + "|" + costItem[1], costItem[0]);
  		}
  	}  
  	comboObjects[2].Index = 0;
  	
 } 


 /**
  * 콤보필드에 데이터를 추가해준다. (Object/Method in Sheets)
  */	
 function makeItemObject(comboItems) {	
 	var comboCode= "";
 	var comboText= "";
 	
 	var arrComboItems = comboItems.split("|");
 	var preCode = "";
 	for (i = 0 ; i < arrComboItems.length ; i++) {
 		var comboItem = arrComboItems[i].split(",");
 		//comboItem[0] : PSO_OBJ_CD                       
 		//comboItem[1] : PSO_OBJ_CD_DSP                   
 		//comboItem[2] : PSO_MEAS_UT_CD                   
 		//comboItem[3] : PSO_MEAS_UT_CD_DSP               
 		//comboItem[4] : OBJ_LIST_NO                      

 		///if(preCode != comboItem[0]){
 			comboCode += "|" + comboItem[4];
 			comboText += "|" + comboItem[1] + "\t" + comboItem[3];
 		///}
 		///preCode = comboItem[0];
 	}  
 	
 	comboCode = comboCode.substr(1);	//Code
 	comboText = comboText.substr(1); 	//Text
 	
 	return new Array(comboCode, comboText);
 }
  
/**
 * 콤보필드에 데이터를 추가해준다. (Object/Method in Regular Value Sheet)
 */	
function makeItemObjectInRegVal(comboItems) {	
	var comboCode= "";
	var comboText= "";

	var arrComboItems = comboItems.split("|");
	var preCode = "";
	for (i = 0 ; i < arrComboItems.length ; i++) {
		var comboItem = arrComboItems[i].split(",");
		//if(preCode != comboItem[0]){
			comboCode += "|" + comboItem[4];
			comboText += "|" + comboItem[1] + "\t" + comboItem[3];
		//}
		//preCode = comboItem[0];
	}  
	
	comboCode = comboCode.substr(1);	//Code
	comboText = comboText.substr(1); 	//Text
	
	return new Array(comboCode, comboText);
}  

 /**
  * 콤보필드에 데이터를 추가해준다. (UOM in Sheets)
  */	
 function makeItemUOM(comboItems, objCd) {
 	var comboCode= "";
 	var comboText= "";
 		
 	var arrComboItems = comboItems.split("|");
 	for (i = 0 ; i < arrComboItems.length ; i++) {
 		var comboItem = arrComboItems[i].split(",");	//[0]:Object Code, [1]:UOM Code, [2]:UOM Name
 		if(objCd == comboItem[0]){
 			comboCode += "|" + comboItem[1];
 			comboText += "|" + comboItem[2];
 		}
 	}  
 	
 	comboCode = comboCode.substr(1);	//Code
 	comboText = comboText.substr(1); 	//Text
 	
 	return new Array(comboCode, comboText);	 
 }


 function obj_keyup(){
	 var eleObj = event.srcElement;
	 var formObj = document.form;

	 switch (eleObj.name) {
		 case "port_cd":
			 if(eleObj.value.length == 5){
				 doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			 } else{
				 comboObjects[0].RemoveAll();
			 }
			 f_RemoveAllSheet();
			 break;

		 case "from_date":
			 if(eleObj.value.length == 8){
				 //formObj.to_date.focus();
			 }
			 break; 
		 case "to_date":
			 if(eleObj.value.length == 8){
				 //formObj.port_cd.focus();
			 }
			 break;
	 }
 }
 
function obj_paste(){
	var eleObj = event.srcElement;
	var formObj = document.form;
	
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");		//영대문자
		break;
		
		case "vndr_seq":
			gf_SetControlPastePattern(event, "0");		//숫자
		break;			
		
		case "from_date":
			gf_SetControlPastePattern(event, "0");		//숫자
		break;			
		
		case "to_date":
			gf_SetControlPastePattern(event, "0");		//숫자
		break;			
	}
} 

//Drag & Drop으로 값을 입력하는 것은 배제함
function obj_drop(){
	event.returnValue = false;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 125;
			
			MultiSelection = false;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|||D/F|Formula|Formula|Condition|Condition|Condition|foml_sys_desc|Compulsory|UK";
			var HeadTitle2 = "|||D/F|ID|DESC|ID|DESC||foml_sys_desc|Compulsory|UK";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
			InitDataProperty(0, cnt++ , dtHidden	  ,	40,		daCenter,	true,		prefix+"seq" );
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"default2",   		false,		"",			dfNone,			0,		true, 		true,		-1,		false,		false,		"",		false);
			//InitDataProperty(0, cnt++ , dtPopupEdit,	90,		daCenter,	true,		prefix+"formula_no",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	110,	daCenter,	true,		prefix+"formula_no",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daLeft,		true,		prefix+"foml_desc",  		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	110,	daCenter,	true,		prefix+"condition",   		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daLeft,		true,		prefix+"cond_desc",   		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtImage,		60,		daCenter,	true,		prefix+"upd_mnu_no_cond",	false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"foml_sys_desc",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"cpls_flg",			false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"uk",   				false,		"",			dfNone,			0,		false, 		false);	//Unique, Hidden

			CountPosition = 0;
			ImageList("0") = "img/btng_condition.gif";			//upd_mnu_no_cond(O), seq2(X)
			ImageList("1") = "img/btng_condition.gif";			//
			ImageList("2") = "img/btng_condition_h.gif"; 		//
			ShowButtonImage = 1;
			
			InitDataValid(0, prefix+"formula_no", vtNumericOnly); //숫자만 입력
			InitDataValid(0, prefix+"condition", vtNumericOnly); //숫자만 입력

		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = HEIGHT_SHEET2;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "||Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
			var HeadTitle2 = "||Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
			var headCount = ComCountHeadTitle(HeadTitle1);
			gColumnCountInSheet2 = headCount;
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet2_";

			//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag"		);
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk"		);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"seq", 				false,		"",			dfNone,			0,		false,		false			);
			InitDataProperty(0, cnt++ , dtCombo,		130,	daCenter,	true,		prefix+"obj_list_no"		);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"object_code_dsp",	false,		"",			dfNone,			0,		false,  	false);
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,		prefix+"rate_code"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",		false,		"",			dfNone,			4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",			false,		"",			dfNone,			4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",			false,		"",			dfNone,			0,		false, 		false, 		3 );
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rate_value",		false,		"",			dfNumber,		10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"condition",			false);
			InitDataProperty(0, cnt++ , dtHidden,		140,	daLeft,		true,		prefix+"cond_desc",  		false,		"",			dfNone,			0,		false, 		false, 		15);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"object_name");
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"uom");
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,		prefix+"cons_als_nm",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"uk",				false,		"",			dfNumber,		4,		true,  		true, 		14);	//Unique, Hidden	
			
			InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Fixed\tObject X Fixed Rate" , "R|F", "", "R");
			CountPosition = 2;
			//PopupImage  =  "img/btng_condition.gif";
			ShowButtonImage = 1;

		}
		break;

	case "sheet3":			//Regular Value
		with (sheetObj) {
			// 높이 설정
			style.height = HEIGHT_SHEET3;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|||Regular Value|Regular Value|Regular Value";
			var HeadTitle2 = "|||Object|UOM|Value";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet3_";

			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag"		);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"del_chk"		);
			InitDataProperty(0, cnt++ , dtHidden,		190,	daCenter,	true,		prefix+"obj_list_no");		//dtCombo -> dtHidden 로 변경. Readonly로 바뀜에 따라
			InitDataProperty(0, cnt++ , dtData,			190,	daCenter,	true,		prefix+"obj_list_nm");
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"pso_meas_ut_cd_dsp", 	false,		"",			dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"regular_value",			false,		"",			dfNumber,	4,		true,  		true, 		14);

			CountPosition = 0;
		}
		break;

	case "sheet4":
		with (sheetObj) {

			// 높이 설정
			style.height = 122;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|SUM.Option.";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet4_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix+"del_chk");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"seq");
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+"rate_value",	false,		"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix+"foml_desc",		false,	"",	dfNone,				0,		false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtImage,		80,		daCenter,	true,		prefix+"upd_mnu_no_cond",	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	prefix+"sum_option");
			
			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			CountPosition = 0;

			InitDataValid(0, prefix+"formula_no", vtNumericOnly); //숫자만 입력
			InitDataValid(0, prefix+"condition", vtNumericOnly); //숫자만 입력
			
			//ImageList(0)  = "img/btng_condition.gif";			// seq2
			ImageList("0") = "img/btng_condition.gif";			//upd_mnu_no_cond(O), seq2(X)
			ImageList("1") = "img/btng_condition.gif";			//
			ImageList("2") = "img/btng_condition_h.gif"; 		//

			ShowButtonImage = 1;
		}
		break;

	case "sheet5":
		with (sheetObj) {

			// 높이 설정
			style.height = 122;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|SUM.Option";
			
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet5_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix+"del_chk");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"seq");
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+"rate_value",	false,		"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix+"foml_desc",		false,	"",	dfNone,				0,		false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtImage,		80,		daCenter,	true,		prefix+"upd_mnu_no_cond",	false,	"",			dfNone,			0,		true,  true);	
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	prefix+"sum_option");
			
			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			CountPosition = 0;

			InitDataValid(0, prefix+"formula_no", vtNumericOnly); //숫자만 입력
			InitDataValid(0, prefix+"condition", vtNumericOnly); //숫자만 입력
			
			ImageList("0") = "img/btng_condition.gif";			//upd_mnu_no_cond(O), seq2(X)
			ImageList("1") = "img/btng_condition.gif";			//
			ImageList("2") = "img/btng_condition_h.gif"; 		//

			ShowButtonImage = 1;
		}
		break;
		
	case "sheet6":		//Base Dummy
		with (sheetObj) {
			// 높이 설정
			style.height = 235;
	
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
	
			var HeadTitle1 = "||Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
			var HeadTitle2 = "||Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet6_";
	
			//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag"		);
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk"		);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"seq", 			false,		"",			dfNone,				0,		false,	false			);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"obj_list_no"		);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"object_code_dsp"		);
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		prefix+"rate_code"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",	false,		"",			dfNone,	4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",		false,		"",			dfNone,	4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",		false,		"",			dfNone,		0,		false, 	false, 		3 );
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rate_value",	false,		"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtPopup,		100,	daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,		0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"object_name");
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"uom");
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,		prefix+"cons_als_nm",	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"uk",			false,		"",			dfNumber,	4,		true,  		true, 		14);	//Unique, Hidden
	
			InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Range2\tRange Rate Only|Fixed\tObject X Fixed Rate" , "R|S|F", "", "R");
			CountPosition = 2;
			ShowButtonImage = 1;
	
		}
		break;
	
	case "sheet7":	//Dummy Sheet that is not initialized
		break;	
		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // 조회
			
			var aryPrefix = new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_");        
			if( !validateForm(sheetObj,formObj,sAction)) return;
			ComBtnEnable("btn_RowAdd");
			formObj.f_cmd.value = SEARCH;//COMBO
			
			f_SetHeadUnCheckAll();	//모든 sheet의 HeadCheck 지우기
			f_RemoveAllSheet(); 
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0004GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
		
			sheetObjects[0].Redraw = false;
			sheetObjects[5].Redraw = false;
			sheetObjects[2].Redraw = false;
			sheetObjects[3].Redraw = false;
			sheetObjects[4].Redraw = false;
	
			sheetObjects[0].WaitImageVisible = false;
			sheetObjects[5].WaitImageVisible = false;
			sheetObjects[2].WaitImageVisible = false;
			sheetObjects[3].WaitImageVisible = false;
			sheetObjects[4].WaitImageVisible = false;
			
			sheetObjects[0].LoadSearchXml(arrXml[0]); 

			sheetObjects[5].LoadSearchXml(arrXml[1]); 

			sheetObjects[2].LoadSearchXml(arrXml[2]); 
			
			sheetObjects[3].LoadSearchXml(arrXml[3]);
			
			sheetObjects[4].LoadSearchXml(arrXml[4]); 
		
			if (sheetObjects[0].RowCount > 0) {
				f_CopyDummy2Base(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_uk"));
			}
			
			sheetObjects[0].Redraw = true;
			sheetObjects[5].Redraw = true;
			sheetObjects[2].Redraw = true;
			sheetObjects[3].Redraw = true;
			sheetObjects[4].Redraw = true;
			
			sheetObjects[0].WaitImageVisible = false;
			sheetObjects[5].WaitImageVisible = false;
			sheetObjects[2].WaitImageVisible = false;
			sheetObjects[3].WaitImageVisible = false;
			sheetObjects[4].WaitImageVisible = false;
			
			f_AfterRetrieve();
		
			ComOpenWait(false);
		break;
		
		case IBSEARCH_ASYNC01:	//초기 조회조건 Setting   
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_" );
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
	
			sheetObjects[0].WaitImageVisible = false;
	
			conditionXML = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var arrXml = conditionXML.split("|$$|");
			
			//Object Setting in Sheets (1, 2)
			var comboItems = ComGetEtcData(conditionXML, "objlist");
			var arrCodeTextObject = makeItemObject(comboItems);
	
			//Base Sheet의 Object Combo Setting
			sheetObjects[1].InitDataCombo(0, "sheet2_obj_list_no", arrCodeTextObject[1], arrCodeTextObject[0]);		  	            		  
	
			//Object Setting in Sheet Regular Value
			/* dtCombo -> dtHidden 으로 변경
			comboItems = ComGetEtcData(conditionXML, "objListByTpCd");
			arrCodeTextObject = makeItemObjectInRegVal(comboItems);
			sheetObjects[2].InitDataCombo(0, "sheet3_obj_list_no", arrCodeTextObject[1], arrCodeTextObject[0]);
			*/
			
			//콤보필드를 초기화시킨다. (Account)
			comboObjects[1].RemoveAll();
	
			//콤보필드를 초기화시킨다. (Cost)
			comboObjects[2].RemoveAll();
	
			//콤보필드를 초기화시킨다. (Currency)
			//var localCurrency = ComGetEtcData(conditionXML, "localCurrency" );
			comboObjects[3].RemoveAll();				// comboObjects[4] -> 3 으로 변경완료
			comboItems = ComGetEtcData(conditionXML, "currency" ).split(ROWMARK);
			addComboItem(comboObjects[3],comboItems);	// comboObjects[4] -> 3 으로 변경완료
			//comboObjects[4].Code2 = localCurrency;	//지역통화로 세팅 
			
			//
			var arrFormula4Loading = ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k = 0;
			for(i=0; i<arrFormula4Loading.length; i++){
				arrKeyVal = arrFormula4Loading[i].split("|@DELIM|");
				for(j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k] = arrKeyVal[j];
					k++;             
				}
				if(k == 4) break;
			}
	
		break;
		
		case IBSAVE:        //저장
			var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_", "sheet6_", "sheet7_");
			f_RemoveDummyByBase(sheetObj.CellValue(sheetObjects[0].SelectRow, "sheet1_uk"));	//Dummy 	삭제
			f_CopyBase2Dummy(sheetObj.CellValue(sheetObjects[0].SelectRow, "sheet1_uk"));		//Dummy 	추가
			
			formObj.f_cmd.value = MULTI;
			if (!validateForm(sheetObj,formObj,sAction)) return;
		
			/*
		     * @param {ibsheet,array} 	sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
		     * @param {string} 			bUrlEncode   선택,QueryString 인코딩여부, default=true
		     * @param {bool}    		allSave      선택,sheet 전체를 xml string으로 만들지 여부, default=false
		     * @param {int,string}  	col          선택,대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
			 */
			var sParam = ComGetSaveString(sheetObjects, true, true);	//모든 rows를 전송한다.
			if (sParam == "") return;
			//ComDebug("[Debug] \n" + sParam + "\n");	//alert
			formObj.yd_chg_ver_seq.value = comboObjects[4].Code; 		// comboObjects[3] -> 4 으로 변경완료
			ComOpenWait(true);
			sheetObjects[0].WaitImageVisible = false;
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			//sheetObjects[5].ColumnSort("sheet6_uk|sheet6_seq|sheet6_range_from", "ASC", "DESC|ASC|ASC", true);
			var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0004GS.do", sParam);
			var error = ComGetEtcData(sXml , "ERROR");
			if(ComTrim(error) == "Y"){
				ComShowMessage("Not defined object Rate, please check it again.");	//필수
				return;
			}
			
		
			sheetObjects[0].LoadSaveXml(sXml);
			sheetObjects[0].Redraw = true; 
			sheetObjects[1].Redraw = true; 
			sheetObjects[2].Redraw = true; 
			
			searchVersion();

			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);	//2015.04.22 추가
	
			ComOpenWait(false);
		break;
		
		case IBCLEAR:  
			f_SetHeadUnCheckAll();	//모든 sheet의 HeadCheck 지우기
			//Port
			formObj.port_cd.value = "";
			comboObjects[0].RemoveAll();
			
			//Account
			comboObjects[1].RemoveAll();
			formObj.account_nm.value = "";
			
			//Cost
			comboObjects[2].RemoveAll();
			formObj.lgs_cost_nm.value = "";
			
			//Service Provider
			formObj.vndr_seq.value = "";
			formObj.vndr_lgl_eng_nm.value = "";

			//Origin
			formObj.org_vndr_nm.value = "";
			
			//Date
			setToday(formObj.from_date);
//			setToday(formObj.to_date);
			formObj.to_date.value = "9999-12-31";

			//Version
			comboObjects[4].RemoveAll();			// comboObjects[3] -> 4 으로 변경완료
			
			//Currency
			//comboObjects[4].Code2 = ComGetEtcData(conditionXML, "localCurrency" );	
			comboObjects[3].Code2 = "";	 			// comboObjects[4] -> 3 으로 변경완료
	
			//URL
			ComSetObjValue(formObj.port_trf_url, "");
			
			//Contract/Regulation
			ComSetObjValue(formObj.contract, "");
			
			//Remark
			ComSetObjValue(formObj.port_trf_rmk, "");
			
			//Sheets	
			f_RemoveAllSheet("IBCLEAR");
			
			
		break;        
		
		case IBDELETE:      // 삭제
			formObj.f_cmd.value = REMOVE;
			if(!validateForm(sheetObj,formObj,sAction)) return;
			if(!confirm(msgs["PSO00020"])) return;
			
			ComOpenWait(true);
			sheetObjects[0].WaitImageVisible = false;
			sParam = FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0004GS.do", sParam);
		
			sheetObjects[0].LoadSaveXml(sXml);
			
			searchVersion();
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			ComOpenWait(false);
		break;
	
		case COMMAND05:	//Port Code [keyup:5자리]  
		    formObj.f_cmd.value = COMMAND05;	//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal = formObj.port_cd.value;
				loadTerminal();
				f_SetComboAccount(rVal);
				comboObjects[0].focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
		break;

		case COMMAND06:	//Service Provider   
			formObj.f_cmd.value = COMMAND06;//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var spName = ComGetEtcData(sXml, "spName");		//Service Provider Name
			formObj.vndr_lgl_eng_nm.value = spName;
		
			if (spName != "") {
		
			} 
			else {
				ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
				formObj.vndr_seq.focus();
				formObj.vndr_seq.value = "";
			}
			
		break;	

		case COMMAND08:      // COPY후 조회
		
			//Copy Popup에서 얻어온 값
			var param = formObj.copy_condition.value;
			var aryPrefix = new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_");   
			f_SetHeadUnCheckAll();	//모든 sheet의 HeadCheck 지우기
			f_RemoveAllSheet(); 
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0004GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");

			sheetObjects[0].Redraw = false;
			sheetObjects[5].Redraw = false;
			sheetObjects[2].Redraw = false;
			sheetObjects[3].Redraw = false;
			sheetObjects[4].Redraw = false;
			
			sheetObjects[0].LoadSearchXml(arrXml[0]); 

			sheetObjects[5].LoadSearchXml(arrXml[1]); 

			sheetObjects[2].LoadSearchXml(arrXml[2]); 
			
			sheetObjects[3].LoadSearchXml(arrXml[3]); 
			
			sheetObjects[4].LoadSearchXml(arrXml[4]); 
			
			if(sheetObjects[0].RowCount > 0){
				f_CopyDummy2Base(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_uk"));
			}
		
			sheetObjects[0].Redraw = true;
			sheetObjects[5].Redraw = true;
			sheetObjects[2].Redraw = true;
			sheetObjects[3].Redraw = true;
			sheetObjects[4].Redraw = true;
			
			f_AfterRetrieve();
			ComOpenWait(false);
		break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		
		case IBSEARCH:
			//Port
			if(port_cd.value.length < 5){
				ComShowCodeMessage('PSO00007');
				port_cd.focus();
				return false;
			}	

			//Yard
			if( comboObjects[0].Code == ''){
				ComShowCodeMessage('PSO00008');
				combo1.focus();
				return false;
			}	

			//Yard	
			//if( comboObjects[0].Code.split(",").length > 1 ){
			//	ComShowCodeMessage('PSO00006');
			//	return false;
			//}	
			
			//Account
			if( comboObjects[1].Code == ''){
				ComShowCodeMessage('PSO00003', "[Account]");	//필수항목
				comboObjects[1].focus();

				return false;
			}					

			//Cost
			if( comboObjects[2].Code == ''){
				ComShowCodeMessage('PSO00003', "[Cost CD]");	//필수항목
				comboObjects[2].focus();
				
				return false;
			}	

			//Service Provider
			if(vndr_seq.value == ''){
				ComShowCodeMessage('PSO00011');
				vndr_seq.focus();

				return false;
			}	

			if(from_date.value == ''){
				ComShowCodeMessage('PSO00009');
				from_date.focus();
				return false;
			}	

			if(to_date.value == ''){
				ComShowCodeMessage('PSO00009');
				to_date.focus();

				return false;
			}	

			//Ver.	
			if( comboObjects[4].Code == ''){	// comboObjects[3] -> 4 으로 변경완료
				ComShowCodeMessage('PSO00003', "[Version]");	//필수항목
				comboObjects[4].focus();		// comboObjects[3] -> 4 으로 변경완료

				return false;
			}	

			//Currency	
			if( comboObjects[3].Code == ''){ 	// comboObjects[4] -> 3 으로 변경완료
				ComShowCodeMessage('PSO00003', "[Currency]");	//필수항목
				comboObjects[3].focus(); 		// comboObjects[4] -> 3 으로 변경완료
				
				return false;
			}	

			break;

		case IBSAVE:	
			
			if(port_cd.value == ''){
				ComShowCodeMessage('PSO00007');
				port_cd.focus();
				return false;
			}	

			if( comboObjects[0].Code == ''){
				ComShowCodeMessage('PSO00008');
				combo1.focus();
				return false;
			}	

			if( comboObjects[0].Code.split(",").length > 1 ){
				ComShowCodeMessage('PSO00006');
				return false;
			}	
			
			//Account
			if( comboObjects[1].Code == ''){
				ComShowCodeMessage('PSO00003', "[Account]");	//필수항목
				comboObjects[1].focus();

				return false;
			}				
			
			//Cost
			if( comboObjects[2].Code == ''){
				ComShowCodeMessage('PSO00010');
				comboObjects[2].focus();
				return false;
			}	

			if(comboObjects[3].Code == ''){			// comboObjects[4] -> 3 으로 변경완료
				ComShowCodeMessage('PSO00013');
				from_date.focus();
				return false;
			}	


			if(from_date.value == ''){
				ComShowCodeMessage('PSO00009');
				from_date.focus();
				return false;
			}	

			if(to_date.value == ''){
				ComShowCodeMessage('PSO00009');
				to_date.focus();

				return false;
			}	

			if( vndr_seq.value == ''){
				ComShowCodeMessage('PSO00011');
				vndr_seq.focus();

				return false;
			}	

			if( csearch.value != '' && comboObjects[4].Code == ''){	// comboObjects[3] -> 4 으로 변경완료
				ComShowCodeMessage('PSO00012');
				combo5.focus();

				return false;
			}	
			
			if( sheetObjects[0].LastRow < sheetObjects[0].HeaderRows ){
				ComShowCodeMessage('PSO00017');	//Base에는 최소 한건의 데이터를 입력하셔야 합니다.
				return false;
			}
			
			//Base
			var strRows = "";
			for(i=sheetObjects[0].HeaderRows; i<sheetObjects[0].LastRow+1; i++){ 
				var prefix = "sheet1_";
				var formula_no 	= sheetObjects[0].CellValue(i, prefix + "formula_no");
				var condition 	= sheetObjects[0].CellValue(i, prefix + "condition");
				var uk 			= sheetObjects[0].CellValue(i, prefix + "uk");

				if(formula_no == "") {
					ComShowCodeMessage("PSO00003", "[Base : Formula]");	//필수
					return false;
				}

				//Tariff 없이 Formula만 입력했을 경우,
				if(sheetObjects[5].FindText("sheet6_uk", uk) == -1){
					strRows += "," + (i - sheetObjects[0].HeaderRows + 1);
				}
			}	
			//입력 안 된 Row를 알려준다.
			if(strRows != ""){
				ComShowCodeMessage("PSO00003", "[Base : " + strRows.substring(1) + " Row]");	//필수
				return false;
			}
			
			//Base Ragular Value	//[2010.01.13:ReadOnly로 변경]
			/*
			if(sheetObjects[2].RowCount > 0){
				for(i=sheetObjects[2].HeaderRows; i<sheetObjects[2].LastRow+1; i++){ 
					var prefix = "sheet3_";
					var object 			= sheetObjects[2].CellValue(i, prefix + "obj_list_no");
					var regular_value 	= sheetObjects[2].CellValue(i, prefix + "regular_value");
					
					if(object == ""){
						ComShowCodeMessage("PSO00003", "[Regular Value : Object]");	//필수
						return false;
					}
	
					if(regular_value == ""){
						ComShowCodeMessage("PSO00003", "[Regular Value : Value]");	//필수
						return false;
					}
				}
			}
			*/
			
			//Base Total 
			if(sheetObjects[5].RowCount > 0){
				if(sheetObjects[5].RowCount > 150){
					//ComOpenWait(true);
					ComShowCodeMessage("PSO00029");	//"It can take long time to save data if there are a lot of data."	//ComOpenWait()의 이미지가 나타나지 않아 alert()을 띄웠음
				}
				for(i=sheetObjects[5].HeaderRows; i<sheetObjects[5].HeaderRows + sheetObjects[5].RowCount; i++){	
					var prefix = "sheet6_";
					var obj_list_no		= sheetObjects[5].CellValue(i, prefix + "obj_list_no");
					var rate_code 		= sheetObjects[5].CellValue(i, prefix + "rate_code");
					var range_from 		= sheetObjects[5].CellValue(i, prefix + "range_from").replace(/[,:]/g, ""); 	//ComReplaceStr(from_date.value,"-","");
					var range_to 		= sheetObjects[5].CellValue(i, prefix + "range_to").replace(/[,:]/g, "");	//comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "");
					var rate_value 		= sheetObjects[5].CellValue(i, prefix + "rate_value");
	
					if(ComTrim(obj_list_no) == ""){
						ComShowCodeMessage("PSO00003", "[Base : Object]");	//필수
						return false;
					}
										
					if(rate_code != "F" && range_from == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range From]");	//필수
						return false;
					}
					if(rate_code != "F" && range_to == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range To]");	//필수
						return false;
					}
					if(rate_value == ""){
						ComShowCodeMessage("PSO00003", "[Base : Rate]");	//필수
						return false;
					}
					
					if(Number(range_from) > Number(range_to)){
						ComShowCodeMessage("PSO00018", "[Base : Range To]", "[Base : Range From]");	//{?msg1} 값은 {?msg2} 값보다 커야 합니다.;
						return false;
					}
				}
			}
			
			//Surcharge
			if(sheetObjects[3].RowCount > 0){
				for(i=1; i<sheetObjects[3].RowCount+1; i++){		
					var prefix = "sheet4_";
					var method_code = sheetObjects[3].CellValue(i, prefix + "method_code");
					var rate_value  = sheetObjects[3].CellValue(i, prefix + "rate_value");
					var formula_no  = sheetObjects[3].CellValue(i, prefix + "formula_no");
					
					if(ComTrim(method_code) == ""){
						ComShowCodeMessage("PSO00003", "[Surcharge : Method]");	//필수
						return false;
					}
					
					if(ComTrim(rate_value) == ""){
						ComShowCodeMessage("PSO00003", "[Surcharge : Rate]");	//필수
						return false;
					}
	
					if(ComTrim(formula_no) == ""){
						ComShowCodeMessage("PSO00003", "[Surcharge : Formula ID]");	//필수
						return false;
					}
				}
			}
			
			//Discount
			if(sheetObjects[4].RowCount > 0){
				for(i=1; i<sheetObjects[4].RowCount+1; i++){				
					var prefix = "sheet5_";
					var method_code = sheetObjects[4].CellValue(i, prefix + "method_code");
					var rate_value  = sheetObjects[4].CellValue(i, prefix + "rate_value");
					var formula_no  = sheetObjects[4].CellValue(i, prefix + "formula_no");
					
					if(ComTrim(method_code) == ""){
						ComShowCodeMessage("PSO00003", "[Discount : Method]");	//필수
						return false;
					}
					
					if(ComTrim(rate_value) == ""){
						ComShowCodeMessage("PSO00003", "[Discount : Rate]");	//필수
						return false;
					}
					
					if(ComTrim(formula_no) == ""){
						ComShowCodeMessage("PSO00003", "[Discount : Formula ID]");	//필수
						return false;
					}
				}
			}

			break;
			
		case IBDELETE: 
			if(port_cd.value == ''){
				ComShowCodeMessage('PSO00007');
				port_cd.focus();
				return false;
			}	

			if( comboObjects[0].Code == ''){
				ComShowCodeMessage('PSO00008');
				combo1.focus();
				return false;
			}	

			if(vndr_seq.value == ''){
				ComShowCodeMessage('PSO00011');
				vndr_seq.focus();

				return false;
			}	

			if( comboObjects[4].Code == ''){	// comboObjects[3] -> 4 으로 변경완료
				ComShowCodeMessage('PSO00012');
				combo5.focus();

				return false;
			}	

			break;
		}      
	}

	return true;
}
 
/********************************************************************************************************************
 * <OnLoadFinish : OnLoadFinish가 OnLoad보다 먼저 발생하여 문제가 되므로, 이의 해결을 위해 loadPage()에서 xsheet1_OnLoadFinish()을 호출함>                                       
 ********************************************************************************************************************
 * 1. 조회조건 Combo 또는 Sheet 內 Combo에 채울 값들을 가져온다.                                  
 * 2. VOP_PSO_0036 화면의 'Tariff Update' Button을 Click하여 호출된 경우라면, 조회조건 Setting과 검색이 동시에 이뤄진다.                                                     
 ********************************************************************************************************************/
function sheet1_OnLoadFinish(sheetObj){ 
	var formObj = document.form;
	
	//1. 조회조건 Combo 또는 Sheet 內 Combo에 채울 값들을 가져온다.  
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
	
	comboObjects[4].Enable = false;	//Version Combo를 선택할 수 없도록 수정함. 최근 Version으로 고정	// comboObjects[3] -> 4 으로 변경완료
	formObj.port_cd.focus();
	
	//2. VOP_PSO_0036 화면의 'Tariff Update' Button을 Click하여 호출된 경우라면, 조회조건 Setting과 검색이 동시에 이뤄진다.
	var movedFrom = formObj.moved_from.value;
	var movedParams = formObj.moved_params.value;
	if(movedFrom != ""){
		if(movedParams != ""){
			f_RetrieveMovedFrom(movedParams);
		}
	}
	formObj.moved_from.value = "";
}

//function sheet2_OnLoadFinish(sheetObj){    2015.01.23 surcharge의 데이터가 조회가 안돼 일단 막음
//	document.getElementById("div_surcharge").style.display = "none";
//}

//function sheet3_OnLoadFinish(sheetObj){
//	document.getElementById("div_discount").style.display = "none";
//}

/**
* Sheet 조회완료 후 이벤트 발생
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	//Rate Type이 Fixed일 경우 Range From,To Col Hidden처리
	f_SetRateTypeRangeColShow();
}

/**
* IBSheet Popup Event
*/
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula 팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula1', '0,0', true, false, Row, Col, 1);
		break;	 
	
		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition1', '0,0', true, false, Row, Col, 1);
		break;	
	}
}


function setCondition(aryPopupData, row, col, sheetIdx){
	var sheetObject = sheetObjects[sheetIdx];


	var prefix = "sheet"+(sheetIdx+1)+"_";

	sheetObject.CellValue2(row,prefix+"formula_no")= aryPopupData[0][1];
	sheetObject.CellValue2(row,prefix+"fomul_desc")= aryPopupData[0][2];
}
 
/********************************************************************************************************************
 * <Base(Master) Sheet : Row 선택시 (NewRow, OldRow)>                                       
 ********************************************************************************************************************
 * 1. NewRow의 Formula에 속하는 Object로, Base(Detail) Sheet의 Object Combo를 채운다.                                
 * 2. OldRow의 Data를 Base(Dummy) Sheet에서 삭제한다.  
 * 3. Base(Detail) Data를 Base(Dummy)에 복사한다. 
 * 4. NewRow에 해당하는 Base(Dummy) Data를 Base(Detail)에 복사한다.                                                  
 ********************************************************************************************************************/
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){	
	var formObj = document.form;

	if(gSelectEvent == false) return;	//Sheet1 Row삭제시 OnSelectCell Event를 발생시키지 말것

	if(OldRow == NewRow) return;
	
	f_ControlGridCopyButton();			//Grid Copy Button
	
	//1. NewRow의 Formula에 속하는 Object로, Base(Detail) Sheet의 Object Combo를 채운다. 		
	f_SetComboItemByFormula(sheetObj.CellValue(NewRow, "sheet1_foml_sys_desc"));

	//2. OldRow의 Data를 Base(Dummy) Sheet에서 삭제한다. 삭제된 Row수 return 
	var deletedRows = f_RemoveDummyByBase(sheetObj.CellValue(OldRow, "sheet1_uk"));
	//if(deletedRows > 150){
		sheetObjects[1].WaitImageVisible = false;
		//ComOpenWait(true);
	//}
	
	//3. Base(Detail) Data를 Base(Dummy)에 복사한다.
	f_CopyBase2Dummy(sheetObj.CellValue(OldRow, "sheet1_uk"));
	
	//4. NewRow에 해당하는 Base(Dummy) Data를 Base(Detail)에 복사한다.
	f_CopyDummy2Base(sheetObj.CellValue(NewRow, "sheet1_uk"));
	
	document.getElementById("foml_desc").innerHTML = sheetObj.CellValue(NewRow, "sheet1_foml_desc");	//Formula Description
	document.getElementById("cond_desc").innerHTML = sheetObj.CellValue(NewRow, "sheet1_cond_desc");	//Condition Description
	
	//Header Checkbox in sheet2 제어
	//gf_SetHeadCheck(sheetObjects[1], "0,1", "sheet2_del_chk");
	
	//ComOpenWait(false);
	gSelectEvent = true;
	
}

/**
 * Row 변경시
 */ 
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
	if(OldRow == NewRow){
		//return;
	}
 	
	if(sheetObj.RowCount < 1){
		return;
 	}
 	
	var prefix = "sheet2_";

	f_SetCellProperty(sheetObj, NewRow);
	
	switch (sheetObj.ColSaveName(NewCol)) {
	}
}

/**
 * IBSheet Popup Event
 */
function sheet2_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition2', '0,0', true, false, Row, Col, 1); 
			f_RearrangeConditionInSheet2(Row);
		break;	 
	}
}

function setCond(aryPopupData, row, col, sheetIdx){
	var sheetObject = sheetObjects[sheetIdx];


	var prefix = "sheet"+(sheetIdx+1)+"_";

	sheetObject.CellValue2(row,prefix+"formula")= aryPopupData[0][1];
	sheetObject.CellValue2(row,prefix+"foml_desc")= aryPopupData[0][2];
}


/**
* IBSheet Popup Event
*/
function sheet4_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet4_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula 팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula4', '0,0', true, false, Row, Col, 1);
		break;	 
	
		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition4', '0,0', true, false, Row, Col, 1);
		break;	 
	}
}

/**
 * IBSheet Popup Event
 */
function sheet5_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet5_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula 팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula5', '0,0', true, false, Row, Col, 1);
		break;	 
	
		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition5', '0,0', true, false, Row, Col, 1);
		break;	 
	}
} 

/**
 * 
 */
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
	 	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :		//prefix + "seq2" :				//Condition 생성 팝업
		
			var riceStore = sheetObj.CellValue(Row, prefix + "upd_mnu_no_cond");
			if(riceStore == "2"){	//쌀집에서 만든 Condition일 경우
				return; 
			}
		
			var condNo = sheetObj.CellValue(Row, prefix + "condition"); 
			var sUrl = "/hanjin/VOP_PSO_0206.do?type=B&cond_no=" + condNo + "&pop_title_0206=" + sheetObjects[0].UrlEncoding(POP_TITLE_0206);
			sUrl += "&seq="+sheetObj.CellValue(Row,2);
			
			var newCondNoAndCondDesc = ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
			
			if(newCondNoAndCondDesc != undefined){
				sheetObj.CellValue2(Row, prefix + "condition") = newCondNoAndCondDesc.split("||")[0];
				sheetObj.CellValue2(Row, prefix + "cond_desc") = newCondNoAndCondDesc.split("||")[1];
				document.getElementById("cond_desc").innerHTML = newCondNoAndCondDesc.split("||")[1];
			}
		
		break;
		
		case prefix + "del_chk" :			
 			//Data영역이 체크해제되면 헤더도 체크해제된다.
 	        ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
 	
 		break;	
	}
}

/**
 * IBSheet OnClick Event
 */
function sheet2_OnClick(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :			
 			//Data영역이 체크해제되면 헤더도 체크해제된다.
 	        ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
 	
 		break;	
	}
}

/**
 * IBSheet OnClick Event
 */
function sheet3_OnClick(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :			
			//Data영역이 체크해제되면 헤더도 체크해제된다.
			ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
			
			break;	
	}
}
 
 /**
  * 
  */
 function sheet4_OnClick(sheetObj,Row,Col) {
 	var formObj = document.form;
 	var prefix = "sheet4_";
 	sheetObj.ShowDebugMsg = false;

 	switch (sheetObj.ColSaveName(Col)) {
 		case prefix + "upd_mnu_no_cond" :		//prefix + "seq2" :	//Condition 생성 팝업
 		
			var riceStore = sheetObj.CellValue(Row, prefix + "upd_mnu_no_cond");
			if(riceStore == "2"){	//쌀집에서 만든 Condition일 경우
				return; 
			}

 			var condNo = sheetObj.CellValue(Row, prefix + "condition"); 
 			var sUrl  = "/hanjin/VOP_PSO_0206.do?type=S&cond_no=" + condNo + "&pop_title_0206=" + sheetObjects[0].UrlEncoding(POP_TITLE_0206);
 			    sUrl += "&seq="+sheetObj.CellValue(Row,2);

 			var newCondNoAndCondDesc = ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
 			
 			if(newCondNoAndCondDesc != undefined){
 				sheetObj.CellValue2(Row, prefix + "condition") = newCondNoAndCondDesc.split("||")[0];
 				sheetObj.CellValue2(Row, prefix + "cond_desc") = newCondNoAndCondDesc.split("||")[1];
 			}
 		
 		break;
 			
 		case prefix + "del_chk" :			
 			//Data영역이 체크해제되면 헤더도 체크해제된다.
 	        ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
 	
 		break;	
 	}
 }


 /**
  * IBSheet OnClick Event
  */
 function sheet5_OnClick(sheetObj,Row,Col) {
 	var formObj = document.form;
 	var prefix = "sheet5_";
 	sheetObj.ShowDebugMsg = false;

 	switch (sheetObj.ColSaveName(Col)) {
 		case prefix + "upd_mnu_no_cond" :		//prefix + "seq2" :	//Condition 생성 팝업
 		
			var riceStore = sheetObj.CellValue(Row, prefix + "upd_mnu_no_cond");
			if(riceStore == "2"){	//쌀집에서 만든 Condition일 경우
				return; 
			}

 			var condNo = sheetObj.CellValue(Row, prefix + "condition"); 
 			var sUrl = "/hanjin/VOP_PSO_0206.do?type=D&cond_no=" + condNo + "&pop_title_0206=" + sheetObjects[0].UrlEncoding(POP_TITLE_0206);
 			sUrl += "&seq="+sheetObj.CellValue(Row,2);

 			var newCondNoAndCondDesc = ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
 			
 			if(newCondNoAndCondDesc != undefined){
 				sheetObj.CellValue2(Row, prefix + "condition") = newCondNoAndCondDesc.split("||")[0];
 				sheetObj.CellValue2(Row, prefix + "cond_desc") = newCondNoAndCondDesc.split("||")[1];
 			}
 			
 		break;
 		
 		case prefix + "del_chk" :			
 			//Data영역이 체크해제되면 헤더도 체크해제된다.
 			ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
 	
 		break;	
 	}
 }
 
 
function sheet3_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {

}

/*
 * 
 */
function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaListId(sheetObj,Row,"1",val);
			break;	
		case prefix + "condition" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaListId(sheetObj,Row,"2",val);
			break;
	}
}
 /*
  * Sheet1 Formula,Condition 칼럼 값 변경 조회.
  */
function f_SetCondFormulaListId(sheetObj,row,formcond,val){
	var param = "f_cmd="+SEARCH;
    param = param + "&formcond="+formcond+"&combo1="+val;
    
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0209GS.do", param );
	if (ComIsNull(ComGetEtcData(sXml, "id"))){
		if (formcond == "1"){
			setFormula1Val(sheetObj, row, "ID", "", "");
		}else{
			setCondition1Val(sheetObj, row, "ID", "", "");
		}
	}else{
		var code = ComGetEtcData(sXml, "id");
		var name = ComGetEtcData(sXml, "descript");
		if (formcond == "1"){
			var fomlSysDesc = ComGetEtcData(sXml, "foml_sys_desc");
			setFormula1Val(sheetObj, row, code, name, fomlSysDesc);
		}else{
			var riceStore = ComGetEtcData(sXml, "upd_mnu_no_cond");
			setCondition1Val(sheetObj,row, code, name, riceStore);
		}
	}
}		
  /*
   * Sheet4,5 Formula,Condition 칼럼 값 변경 조회.
   */
 function f_SetCondFormulaDesc(sheetObj,prefix,Row,formcond,val){
 	var param = "f_cmd="+SEARCH;
     param = param + "&formcond="+formcond+"&combo1="+val;
     
 	var sXml = sheetObj.GetSearchXml("VOP_PSO_0209GS.do", param );
 	if (ComIsNull(ComGetEtcData(sXml, "id"))){
 		if (formcond == "1"){
 			sheetObj.CellValue2(Row, prefix + "formula_no") = "";
			sheetObj.CellValue2(Row, prefix + "foml_desc") = "";
 		}else{
 			sheetObj.CellValue2(Row, prefix + "condition") = "";
			sheetObj.CellValue2(Row, prefix + "cond_desc") = "";
 		}
 	}else{
 		var code = ComGetEtcData(sXml, "id");
 		var name = ComGetEtcData(sXml, "descript");
 		if (formcond == "1"){
 			sheetObj.CellValue2(Row, prefix + "formula_no") = code;
			sheetObj.CellValue2(Row, prefix + "foml_desc") = name;
 		}else{
 			var riceStore = ComGetEtcData(sXml, "upd_mnu_no_cond");
 			sheetObj.CellValue2(Row, prefix + "condition") = code;
			sheetObj.CellValue2(Row, prefix + "cond_desc") = name;
			sheetObj.CellValue2(Row, prefix+"upd_mnu_no_cond") = riceStore;
 		}
 	}
 }		

/*
 * 
 */
function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "range_from" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
	
		case prefix + "range_to" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
	
		case prefix + "rate_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
	} 
}	
 
function sheet3_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;
	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "regular_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, "");
			}

		break;
	}	
}

function sheet4_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet4_";
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
		
		case prefix + "rate_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, "");
			}
			break;
		case prefix + "formula_no" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"1",val);
			break;	
		case prefix + "condition" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"2",val);
			break;	
		break;
	}	
} 

function sheet5_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet5_";
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
		
		case prefix + "rate_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, "");
			}
			break;
		case prefix + "formula_no" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"1",val);
			break;	
		case prefix + "condition" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"2",val);
			break;
	}	
} 

/*
 *  정수부분, 소수부분 자리수 이하 설정
 */
function f_SetCipherLess(val, integerPlace, decimalPlace){
	var arrVal = val.split(".");
	
	if(arrVal.length == 1){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
	} else if(arrVal.length == 2){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
		if(arrVal[1].length > decimalPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
			return false;
		}
	}	
	return true;
}

/**
 * Yard
 */
function combo1_OnChange(){
	form.year.value = "";
	searchVersion();
	f_RemoveAllSheet();
}
 
function combo1_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");	//영문대문자,숫자만 입력 가능	
}  
 
/**
 * Account CD
 */
function combo2_OnChange(){
	var formObject = document.form;
	formObject.account_nm.value = comboObjects[1].GetIndexText(comboObjects[1].Index, 1);

	//Cost Combo Setting
	addComboItemCost(comboObjects[1].Code);
	form.year.value = "";
	searchVersion();
	f_RemoveAllSheet();

	if(comboObjects[1].Index < 0){
		combo3_OnChange();
	}
}

function combo2_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");	//숫자만 입력 가능
}
  
/**
 * Cost CD
 */
function combo3_OnChange(){
	
 	var formObject = document.form; 
 	formObject.lgs_cost_nm.value = comboObjects[2].GetIndexText(comboObjects[2].Index, 1);
 	form.year.value = "";
 	//콤보필드를 초기화시킨다.
 	searchVersion();
}

function combo3_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");	//영문대문자만 입력 가능	
}    

/**
 * Version
 */
function combo5_OnChange(comb, Index_Code, Text){	// combo4 -> combo5 변경완료
	var formObject = document.form;
	 	
	var data = comb.GetIndexText(comb.Index, 1).split("~");	//DT 
	
	formObject.from_date.value = data[0];
	formObject.to_date.value   = data[1];
	
	var localCurrency = ComGetEtcData(searchVersionXML, "localCurrency" );
 
	var curr_cd = comb.GetIndexText(comb.Index, 2);						//CURR_CD 
	if(curr_cd == "") curr_cd = localCurrency;							//Version 콤보에 Currency값이 없을 경우, 지역통화
	// =====================================================================================================
	// 수정일자 : 2014.07.08
	// 수정내용 : Port 기준으로 조회되는 Currency 호출로직을 Service Provider 기준으로 변경
	// =====================================================================================================
	//if(curr_cd == "") curr_cd = "USD";								//지역통화가 없을 경우, "USD"
	//if(comboObjects[4].GetText(curr_cd, 0) == "") curr_cd = "USD";	//콤보에 데이터가 없을 경우, "USD"
	// =====================================================================================================
	comboObjects[3].Code = curr_cd;			// comboObjects[4] -> 3 으로 변경완료

	
	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	for(i=0; i<comboItems.length; i++){
		var comboItem = comboItems[i].split(FIELDMARK);
		if (i == comb.Index) {
			
			// Compulsory
			if (comboItem[4] == "Y") {	
				formObject.cpls_flg.checked = true;
			} 
			else {
				formObject.cpls_flg.checked = false;				
			}
	        //[CHM-201429328] [PSO] Tariff Creation 화면에서 Invoice 생성 여부와 관계없이 Delete 버튼 활성화
//			if(comboItem[5] == ""){		//Delete Button		
//				ComBtnEnable("btn_DataDelete");		
//			} else{						//Invoice 생성시, Delete 버튼 비활성화
//				ComBtnDisable("btn_DataDelete");
//			}
			
			// Origin
			if (comboItem[6] != undefined && comboItem[6] != "") {
				/*
				var arrOrg = new Array();	//Origin에 ,가 있을 수 있으므로 (index=6 이상인 것)
				for(k=6; k<comboItem.length; k++){
					arrOrg[k-6] = comboItem[k];
				}
				formObject.org_vndr_nm.value = arrOrg.join(",");
				*/
//				formObject.org_vndr_nm.value = comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "");
				formObject.org_vndr_nm.value = (comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "")).replace(/[,:]/g, "");
			} 
			else {
				formObject.org_vndr_nm.value = "";
			}
			
			// URL
			if (typeof(comboItem[7]) != "undefined") {
				ComSetObjValue(formObject.port_trf_url, comboItem[7]);
			}
			else {
				ComSetObjValue(formObject.port_trf_url, "");
			}
			
			// Remark
			if (typeof(comboItem[8]) != "undefined") {
				
				// ==========================================================================================
				// 필드구분자로 ',' 를 사용하기 때문에, Remark 에 ',' 를 사용할 경우 오류가 발생됨.
				// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주기 때문에 이전 문자로 복원해야 됨.
				// ==========================================================================================				
				var portTrfRmk = comboItem[8];
				if (portTrfRmk.indexOf("^") > -1) {
					portTrfRmk = portTrfRmk.split("^").join(",");
				}
				//===========================================================================================
				ComSetObjValue(formObject.port_trf_rmk, comboItem[8]);
			}
			else {
				ComSetObjValue(formObject.port_trf_rmk, "");
			}
			
			// Contract/Regulation
			if (typeof(comboItem[9]) != "undefined") {

				// ==========================================================================================
				// 필드구분자로 ',' 를 사용하기 때문에, 파일명 구분자에 ',' 를 사용할 경우 오류가 발생됨.
				// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주기 때문에 이전 문자로 복원해야 됨.
				// ==========================================================================================				
				var contract = comboItem[9];
				if (contract.indexOf("^") > -1) {
					contract = contract.split("^").join(",");
				}
				//===========================================================================================
				ComSetObjValue(formObject.contract, contract);
			}
			else {
				ComSetObjValue(formObject.contract, "");
			}
			
			break;
		}
	}
}
  
/*
 * Currency
 */ 
function combo4_OnKeyDown(comboObj, KeyCode, Shift){			// combo5 -> combo4 변경완료
	 gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");	//영문대문자만 입력 가능	
}    

/********************************************************************************************************************
 * <Tariff Version 조회>                          
 ********************************************************************************************************************
 * 1. 조회조건중 Port/Yard/Account/Cost/Provider 변경시 호출됨 
 * 2. 이미 Simple Tariff 입력화면에서 입력되었다면, Alert()후 Data Clear   
 * 3. 최종 Version을 Version Combo에 보여주고 Combo를 비활성화함                               
 ********************************************************************************************************************/   
function searchVersion(){
	var formObj = document.form;
	comboObjects[4].RemoveAll();	// comboObjects[3] -> 4 으로 변경완료

	formObj.f_cmd.value = COMMAND02;

	var port_cd = formObj.port_cd.value;
	var yard_cd = comboObjects[0].Code;
	var acct_cd = comboObjects[1].Code;
	var cost_cd = comboObjects[2].Code;
	var vndr_seq = formObj.vndr_seq.value;
	var year = formObj.year.value;
	
	if(port_cd == "" || yard_cd == "" || cost_cd == "" || vndr_seq == ""){
		//return;
	}

	//1.Combo OnChange
	//searchVersionXML = sheetObjects[0].GetSearchXml("VOP_PSO_0004GS.do", FormQueryString(formObj));
	//2.Combo OnChange 발생시, Focus 잃지 않게 하기 (초기화되지 않은 Dummy Sheet 이용)
	searchVersionXML = sheetObjects[sheetObjects.length-1].GetSearchXml("VOP_PSO_0004GS.do", FormQueryString(formObj));
	//Simple, Complex 따지기 	 
	var errorMessage = ComGetEtcData(searchVersionXML, "errorMessage" );
	if(errorMessage != undefined && errorMessage != ""){
		ComShowCodeMessage("PSO00025", "[Simple Tariff]");	//"This data is already input to {?msg1}.";
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		return;
	}

	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	if( comboItems != "" ){ 
		addComboItemVersion(comboObjects[4],comboItems);		// comboObjects[3] -> 4 으로 변경완료
		formObj.yd_chg_no.value = comboItems[0].split(FIELDMARK)[0];		
	} else{
		comboObjects[4].InsertItem(0, "001|" + ComGetNowInfo() + "~" + "9999" + "-12-31", "001");	// comboObjects[3] -> 4 으로 변경완료
		formObj.yd_chg_no.value = "";
	}
	
	comboObjects[4].Index = 0;		// comboObjects[3] -> 4 으로 변경완료
}

/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 */
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 */
 function obj_blur(){

	 var formObj = document.form;
	 obj = event.srcElement;      	

	 with(formObj){
		 if(obj.name=="from_date" || obj.name=="to_date"){
			 var creDtFr = ComReplaceStr(from_date.value,"-","");
			 var creDtTo = ComReplaceStr(to_date.value,"-","");

			 switch(obj.name) {

				 case "from_date":	// Agreement From Date
					 if(creDtFr != '' && creDtTo != ''){
						 if(creDtFr > creDtTo){
							 ComShowCodeMessage('COM12133','To date','From date','greater');
							 from_date.value='';
							 from_date.focus();
						 }

					 }
				 break;
	
				 case "to_date":	// Agreement To Date
					 if(creDtFr != '' && creDtTo != ''){
						 if(creDtFr > creDtTo){
							 ComShowCodeMessage('COM12133','To date','From date','greater');
							 to_date.value='';
							 to_date.focus();
						 }

					 }
				 break;	
			 }

			 if(form.year.value == ""){
				 form.year.value = creDtFr.substr(0,4);
			 }
//			 searchVersion();
			 ComChkObjValid(event.srcElement);
		 }

		 switch(obj.name) {

//			 case "port_cd":		//영문대문자가 아니면 Clear
//				var val = obj.value; 
//            	for(var i=0; i<val.length; i++) {
//            		if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
//            			formObj.port_cd.value = "";
//        				formObj.port_cd.focus();
//        				break;
//            		}
//            	}
//			 break;
	
			 case "vndr_seq":	//Service Provider
				 if (obj.value != "") {
					var val = obj.value;
					if (isNaN(val)) {	//숫자가 아니면						 
						formObj.vndr_seq.value = "";
					 	formObj.vndr_lgl_eng_nm.value = "";
					 	return;
					}
		
					doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
					form.year.value = "";
					searchVersion();
				 } else{
					 formObj.vndr_lgl_eng_nm.value = "";
					 form.year.value = "";
					 searchVersion();
				 }
			 break;
		 }	
	 }
 }

 function obj_click(){

	 var formObj = document.form;
	 obj = event.srcElement;      	

	 with(formObj){
		 if(obj.name=="cSur"){
			 if(cSur.checked){
				 if(validateForm(sheetObjects[3],formObj,IBSEARCH)){
					 document.getElementById("div_surcharge").style.display = "inline";
					 surRowAdd.fireEvent('onclick'); //btn_RowAdd4(Surcharge) Event 발생
				 }else{
					 cSur.checked = false;
				 }
			 } else{	//Uncheck의 목적은 Surcharge Data를 삭제하는 것임
				 document.getElementById("div_surcharge").style.display = "none";
			 	 sheetObjects[3].RemoveAll();
			 }
		 }
		 if(obj.name=="cDis"){
			 if(cDis.checked){
				 if(validateForm(sheetObjects[4],formObj,IBSEARCH)){
					 document.getElementById("div_discount").style.display = "inline";
					 disRowAdd.fireEvent('onclick'); //btn_RowAdd5(Discount) Event 발생
				 }else{
					 cDis.checked = false;
				 }
			 } else{	//Uncheck의 목적은 Discount Data를 삭제하는 것임
				 document.getElementById("div_discount").style.display = "none";
			 	 sheetObjects[4].RemoveAll();
			 }
		 }
	 }
 }  
 
/**
 * 
 */
function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			//Formula가 변경되면, sheet2를 지움
			sheetObjects[1].RemoveAll();
		break;
	}
}

/********************************************************************************************************************
 * <Base(Detail) OnChange>                          
 ********************************************************************************************************************
 * 1. Object    변경 : 변경가능시 UOM을 바꾼다. Seq. Numbering한다.
 * 2. UOM       변경 : UOM에 따라 Range(From/To)의 Type을 바꾼다.
 * 3. Rate Type 변경 : 변경가능시 Seq. Numbering한다.                                   
 ********************************************************************************************************************/  
function sheet2_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
			var arrComboText = sheetObj.GetComboInfo(Row, Col, "Text").split("|"); 
			var idx   		 = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			
			if(idx == -1){
				return;
			}
			sheetObj.CellValue2(Row, prefix + "object_code_dsp") = arrComboText[idx].split("\t")[1];
			
			if(f_CheckType(Row, "obj_list_no") == true){	
				f_RearrangeInSheet2();
			}
			
			//Range Clear
			sheetObj.CellValue2(Row, prefix + "range_from") = "";
			sheetObj.CellValue2(Row, prefix + "range_to") = "";
		break;
		
		case prefix + "object_code_dsp" : 	//UOM변경시 Range(From/To) Type 바꿈
			f_SetCellProperty(sheetObj, Row);
		break;

		case prefix + "rate_code" :
			if(f_CheckType(Row, "rate_code") == true){		
				f_RearrangeInSheet2();
			}
			//Rate Type이 Fixed일 경우 Range From,To Col Hidden처리
			f_SetRateTypeRangeColShow();
		break;
	
	}
}

/********************************************************************************************************************
 * <Base(Detail) Object, Rate Type Combo 변경시, 변경전 값을 전역변수에 넣는다.>                          
 ********************************************************************************************************************
 *                                   
 ********************************************************************************************************************/ 
function sheet2_OnBeforeEdit(sheetObj, Row,Col){

	var formObj = document.form;
	var prefix = "sheet2_";
	
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
			gSheet2_obj_list_no = sheetObj.CellValue(Row,Col);
			gSheet2_object_code_dsp = sheetObj.CellValue(Row, prefix + "object_code_dsp");
		break;			
		
		case prefix + "rate_code" :
			gSheet2_rate_code = sheetObj.CellValue(Row,Col);
		break;	
	}
}

/**
 * 
 */
function sheet3_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
	
			var arrComboText = sheetObj.GetComboInfo(Row, Col, "Text").split("|"); 
			var idx   		 = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			
			if(idx == -1){
				return;
			}
			sheetObj.CellValue2(Row, prefix + "pso_meas_ut_cd_dsp") = arrComboText[idx].split("\t")[1];
		break;
	}
}

/**
* 
*/
function sheet4_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet4_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "method_code" :
			if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "A"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[0];	//Formula_No = 1
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[1];	//Formula_No = 1
			} else if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "R"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[2];	//Formula_No = 2
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[3];	//Formula_No = 2
			}
			break;
	}
}

/**
* 
*/
function sheet5_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet5_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "method_code" :
			if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "A"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[0];	//Formula_No = 1
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[1];	//Formula_No = 1
			} else if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "R"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[2];	//Formula_No = 2
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[3];	//Formula_No = 2
			}
			break;
	}
} 

/**
 * vendor 팝업설정
 */
function setVendorSeq(aryPopupData, row, col, sheetIdx){
	/*COM_ENS_0C1.do 팝업 호출시 
	var formObj = document.form;
	formObj.vndr_seq.value = aryPopupData[0][2];
	formObj.vndr_lgl_eng_nm.value = aryPopupData[0][4];
	combo3_OnChange();
	*/
	
	/*VOP_PSO_0205.do*/
	var formObj = document.form;
	formObj.vndr_seq.value = aryPopupData[0][1];
	formObj.vndr_lgl_eng_nm.value = aryPopupData[0][2];
	combo3_OnChange();
}  
 
/**
 * Formula 팝업설정
 */
function setFormula1(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var formObject = document.form;
	var prefix = "sheet1_";
	var sheetObj = sheetObjects[0];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var fomlSysDesc = aryPopupData[0][8];	//FOML_SYS_DESC
	
	setFormula1Val(sheetObj, row, code, name, fomlSysDesc);
}
 /**
  * Sheet1 Formula 값 조회후 이벤트 처리
  */ 
 function setFormula1Val(sheetObj,row, code, name, fomlSysDesc){
	var prefix = "sheet1_"; 
	if(code == "ID"){
		sheetObj.CellValue(row,prefix+"formula_no") = "";
		sheetObj.CellValue(row,prefix+"foml_desc")  = "";
		sheetObj.CellValue(row,prefix+"foml_sys_desc")  = "";
		document.getElementById("foml_desc").innerHTML = "";
	} else{
		sheetObj.CellValue(row,prefix+"formula_no") = code;
		sheetObj.CellValue(row,prefix+"foml_desc")  = name;
		sheetObj.CellValue(row,prefix+"foml_sys_desc")  = fomlSysDesc;
		document.getElementById("foml_desc").innerHTML = name;
	}
	f_SetComboItemByFormula(sheetObj.CellValue(sheetObj.SelectRow, "sheet1_foml_sys_desc"));	//선택된 행의 Formula에 속한 Object만을 Combo로 만들기
	f_ControlGridCopyButton();	//Grid Copy Button
} 
/**
 * Condition 팝업설정
 */ 
function setCondition1(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var formObject = document.form;
	var prefix = "sheet1_";
	var sheetObj = sheetObjects[0];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var riceStore = aryPopupData[0][7];	//2이면 쌀집에서 만든 데이터이므로  Condition생성팝업을 띄우지 않는다.
	
	setCondition1Val(sheetObj,row, code, name, riceStore);
}   
 /**
 * Sheet1 Condition 값 조회후 이벤트 처리
 */  
function setCondition1Val(sheetObj,row, code, name, riceStore){
	var prefix = "sheet1_";
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition")  = "";
		sheetObj.CellValue2(row,prefix+"cond_desc")  = "";
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = "";
		//formObject.cond_desc.value = "";
		document.getElementById("cond_desc").innerHTML = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition")  = code;
		sheetObj.CellValue2(row,prefix+"cond_desc")  = name;
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = riceStore;
		//formObject.cond_desc.value = name;
		document.getElementById("cond_desc").innerHTML = name;
	}   
} 
/**
 * Condition 팝업설정
 */ 
function setCondition2(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet2_";
	var sheetObj = sheetObjects[1];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition") = "";
		sheetObj.CellValue2(row,prefix+"cond_desc")  = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition") = code;
		sheetObj.CellValue2(row,prefix+"cond_desc")  = name;
	}
}  

/**
 * Formula 팝업설정
 */
function setFormula4(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet4_";
	var sheetObj = sheetObjects[3];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"formula_no") = "";
		sheetObj.CellValue2(row,prefix+"foml_desc")  = "";
	} else{
		sheetObj.CellValue2(row,prefix+"formula_no") = code;
		sheetObj.CellValue2(row,prefix+"foml_desc")  = name;
	}
}
 
/**
 * Condition 팝업설정
 */ 
function setCondition4(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet4_";
	var sheetObj = sheetObjects[3];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var riceStore = aryPopupData[0][7];	//2이면 쌀집에서 만든 데이터이므로  Condition생성팝업을 띄우지 않는다.
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition")= "";
		sheetObj.CellValue2(row,prefix+"cond_desc")= "";
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition")= code;
		sheetObj.CellValue2(row,prefix+"cond_desc")= name;
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = riceStore;
	}
}  
 
/**
 * Formula 팝업설정
 */
function setFormula5(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet5_";
	var sheetObj = sheetObjects[4];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"formula_no") = "";
		sheetObj.CellValue2(row,prefix+"foml_desc")  = "";
	} else{
		sheetObj.CellValue2(row,prefix+"formula_no") = code;
		sheetObj.CellValue2(row,prefix+"foml_desc")  = name;
	}
}
 
/**
 * Condition 팝업설정
 */ 
function setCondition5(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet5_";
	var sheetObj = sheetObjects[4];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var riceStore = aryPopupData[0][7];	//2이면 쌀집에서 만든 데이터이므로  Condition생성팝업을 띄우지 않는다.
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition")= "";
		sheetObj.CellValue2(row,prefix+"cond_desc")= "";
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition")= code;
		sheetObj.CellValue2(row,prefix+"cond_desc")= name;
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = riceStore;
	}
}  

/*
 * 
 */ 
function f_SetComboAccount(portCd){ 
	//GLOBAL conditionXML
	if( portCd == 'EGSUZ' ||  portCd == 'PAPAC' ){
		//Account
		comboObjects[1].Text = ""; 
		comboObjects[1].Enable = false; 
		form.account_nm.value = "";
		//Cost
		comboObjects[2].Enable = true;
		form.lgs_cost_nm.value = "";

		addComboItemAccount("CANAL_O");
	} else {
		//Account
		comboObjects[1].Enable = true; 
		form.account_nm.value = "";
		//Cost
		comboObjects[2].Text = ""; 
		comboObjects[2].Enable = false;
		form.lgs_cost_nm.value = "";

		addComboItemAccount("CANAL_X");	
	}			
}

/********************************************************************************************************************
 * <Copy Popup 화면(VOP_PSO_0212)에서 'OK' Button을 Click할 때>                          
 ********************************************************************************************************************
 * 1. VOP_PSO_0212화면이 닫히면서 form.copy_condition에 조회조건을 넣어준다.
 * 2. 화면상의 조회조건과는 상관없이 Popup에서 보내준 조건으로 조회한다.                                        
 ********************************************************************************************************************/ 
function f_RetrieveAfterCopy(){		
	var formObject = document.form;
	var param = formObj.copy_condition.value;
	doActionIBSheet(sheetObjects[0], formObject, COMMAND08);
}

/*
 * Sheet2를 Sheet6로 복사
 */
function f_CopyBase2Dummy(oldUk){ 
	var sXml = f_MakeSearchXml4CopyBase2Dummy(oldUk);
	sheetObjects[5].WaitImageVisible = false;
	sheetObjects[5].LoadSearchXml(sXml, true, -1);	//Append
}

/*
 * Sheet6를 Sheet2로 복사
 */
function f_CopyDummy2Base(uk){
	var sXml = f_MakeSearchXml4CopyDummy2Base(uk);
	sheetObjects[1].Redraw = false;  
	sheetObjects[1].WaitImageVisible = false;
	sheetObjects[1].LoadSearchXml(sXml);
	f_RearrangeInSheet2();
	sheetObjects[1].Redraw = true;
}

/*
 * Sheet6에 있는 Sheet2데이터를 삭제
 */
function f_RemoveDummyByBase(uk){
	 
	var xxx = ComFindAll(sheetObjects[5], "sheet6_uk", uk) + "";
	if(xxx == "-1"){
		return;
	}
	var zzz = xxx.split("|");
	if(zzz.length == 0){
		return;
	}
	 
	//UK 행 삭제
	sheetObjects[5].Redraw = false; 
	for( var i=Number(zzz[zzz.length-1]); i>=Number(zzz[0]); i-- ) {
		sheetObjects[5].RowDelete( i, false );
	}
	
	sheetObjects[5].Redraw = true; 
	
	return zzz.length;	//삭제된 Rows수
}

/********************************************************************************************************************
 * <Base(Detail) Object 또는 Rate Type 변경시 : 연속된 Row에서는 동일 Object, UOM, Rate Type 中 'Fixed' 존재 여부 Check>                          
 ********************************************************************************************************************
 * 1. 연속된 Row에 동일 Object, UOM, Rate Type 中 'Fixed'가 존재하면, Alert()후, 이전 값으로 Setting한다.                                          
 ********************************************************************************************************************/  
function f_CheckType(Row, section){
	var sheetObj = sheetObjects[1];
	var prefix = "sheet2_";
	var is_type_f = true;
	if(sheetObj.CellValue(Row, prefix + "rate_code") == "F"){		//Fixed
		
		//object, object_code, rate_code 동일 여부 체크
		var pre_obj_list_no	= "";
		var pre_rate_code	= "";
		
		var obj_list_no		= "";
		var rate_code 		= "";
		
		for(i=Row-1; i<=Row+1; i++){ 
			pre_obj_list_no		= i == sheetObj.HeaderRows ? "-1" : sheetObj.CellValue(i-1, prefix + "obj_list_no");
			pre_rate_code		= i == sheetObj.HeaderRows ? "-1" : sheetObj.CellValue(i-1, prefix + "rate_code");

			obj_list_no 	= sheetObj.CellValue(i, prefix + "obj_list_no");
			rate_code 		= sheetObj.CellValue(i, prefix + "rate_code");
			
			if(obj_list_no == pre_obj_list_no && rate_code == pre_rate_code && pre_rate_code == "F"){	//바로 윗 row와 같다면
				
				if(section == "obj_list_no"){
					ComShowCodeMessage("PSO00024", "[Object]");		//동일 Object에 Fixed 타입의 데이터가 이미 입력되었습니다. 따라서 [Object] 변경이 불가능합니다.	 
					sheetObj.CellValue2(Row, prefix + "obj_list_no") = gSheet2_obj_list_no;			//이전 값으로 세팅
					sheetObj.CellValue2(Row, prefix + "object_code_dsp") = gSheet2_object_code_dsp;			//이전 값으로 세팅
				} else if(section == "rate_code"){
					ComShowCodeMessage("PSO00024", "[Rate Type]");	//동일 Object에 Fixed 타입의 데이터가 이미 입력되었습니다. 따라서 [Rate Type] 변경이 불가능합니다.	 
					sheetObj.CellValue2(Row, prefix + "rate_code") = gSheet2_rate_code;		//Fixed로 변경하지 않고, 이전 값으로 세팅
				}
				
				is_type_f = false;
				break;
			}
		}				
		
		if(is_type_f == true){
			sheetObj.CellValue2(Row, prefix + "range_from") = "";
			sheetObj.CellValue2(Row, prefix + "range_to") = "";
			sheetObj.CellEditable(Row, prefix + "range_from") = false;
			sheetObj.CellEditable(Row, prefix + "range_to") = false;
		}

	} else{
		sheetObj.CellEditable(Row, prefix + "range_from") = true;
		sheetObj.CellEditable(Row, prefix + "range_to") = true;
	}
	
	return is_type_f;
}

function f_SetRateTypeRangeColShow(){
	var sheetObj = sheetObjects[1];
	var prefix = "sheet2_";
	with (sheetObj) { 
		if (f_IsRowChkVal(sheetObj,prefix,"rate_code","R")){
			ColHidden(prefix + "range_from") = false;
			ColHidden(prefix + "range_to") = false;
		}else{
			ColHidden(prefix + "range_from") = true;
			ColHidden(prefix + "range_to") = true;
		}
	}
}
function f_IsRowChkVal(sheetObj,prefix,colName,chkVal){
	var is_chk_row = false;
	
	with (sheetObj) {
		for(i=HeaderRows; i <= LastRow; i++){
			if (CellValue(i,prefix+colName) == chkVal){
				is_chk_row = true;
				return is_chk_row;
			}
		}
	}	
	return is_chk_row;
}
/********************************************************************************************************************
 * <Base(Detail) Sheet의 Data에 따른 Seq. Numbering, Cell 활성화 등 각종 제약사항 표현>                          
 ********************************************************************************************************************
 * 1. Seq.는 10부터 시작하여 10씩 증가한다.                             
 * 2. Object, UOM, Rate Type이 같으면 동일 Seq.를 갖는다.                             
 * 3. 연속된 Row에서는 동일 Object, UOM, Rate Type 中 'Fixed'는 가질 수 없다. 
 * 4. Rate Type이 'Fixed'일 경우, Range(From/To)는 값이 없다.
 * 5. 동일 Seq.이면 Rate Condition과 Alias는 같다.                                              
 ********************************************************************************************************************/ 
function  f_RearrangeInSheet2(){
	var prefix = "sheet2_";
	var sheetObj = sheetObjects[1];
	sheetObj.Redraw = false; 
	
	var pre_seq 			= 0;
	var pre_obj_list_no		= "";
	var pre_object_code_dsp = "";
	var pre_rate_code 		= "";

	var obj_list_no			= "";
	var object_code_dsp 	= "";
	var rate_code 			= "";
	
	var condition = "";
	var cond_desc = "";
	var alias = "";
	
	for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){ 
		pre_seq 			= i == sheetObj.HeaderRows ? 0											   		: Number(sheetObj.CellValue(i-1, prefix + "seq"));
		pre_obj_list_no		= i == sheetObj.HeaderRows ? "-1" 	   									   		: sheetObj.CellValue(i-1, prefix + "obj_list_no");
		pre_object_code_dsp	= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "object_code_dsp")	: sheetObj.CellValue(i-1, prefix + "object_code_dsp");
		pre_rate_code		= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "rate_code")   		: sheetObj.CellValue(i-1, prefix + "rate_code");
		pre_condition		= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "condition")   		: sheetObj.CellValue(i-1, prefix + "condition");
		pre_cond_desc		= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "cond_desc")   		: sheetObj.CellValue(i-1, prefix + "cond_desc");
		pre_alias			= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "cons_als_nm") 		: sheetObj.CellValue(i-1, prefix + "cons_als_nm");

		obj_list_no 	= sheetObj.CellValue(i, prefix + "obj_list_no");
		object_code_dsp	= sheetObj.CellValue(i, prefix + "object_code_dsp");
		rate_code 		= sheetObj.CellValue(i, prefix + "rate_code");
		condition 		= sheetObj.CellValue(i, prefix + "condition");
		cond_desc 		= sheetObj.CellValue(i, prefix + "cond_desc");
		alias	 		= sheetObj.CellValue(i, prefix + "cons_als_nm");
		
		if(obj_list_no == pre_obj_list_no && rate_code == pre_rate_code && rate_code != "F"){	//바로 윗 row와 같다면
			sheetObj.CellValue2(i, prefix + "seq") 				= pre_seq;
			sheetObj.CellValue2(i, prefix + "object_code_dsp") 	= pre_object_code_dsp;
			sheetObj.CellValue2(i, prefix + "rate_code") 		= pre_rate_code;
			sheetObj.CellValue2(i, prefix + "condition") 		= pre_condition;
			sheetObj.CellValue2(i, prefix + "cond_desc") 		= pre_cond_desc;
			sheetObj.CellValue2(i, prefix + "cons_als_nm") 		= pre_alias;
			
			sheetObj.CellEditable(i, prefix + "condition") 		= false;
			sheetObj.CellEditable(i, prefix + "cons_als_nm") 	= false;
		} else{
			sheetObj.CellValue2(i, prefix + "seq") 				= pre_seq + 10;
			sheetObj.CellValue2(i, prefix + "object_code_dsp") 	= object_code_dsp;
			sheetObj.CellValue2(i, prefix + "rate_code") 		= rate_code;
			sheetObj.CellValue2(i, prefix + "condition") 		= condition;
			sheetObj.CellValue2(i, prefix + "cond_desc") 		= cond_desc;
			sheetObj.CellValue2(i, prefix + "cons_als_nm") 		= alias;
					
			sheetObj.CellEditable(i, prefix + "condition") 		= true;
			sheetObj.CellEditable(i, prefix + "cons_als_nm") 	= true;
		}
		
		if(rate_code == "F"){
			sheetObj.CellValue2(i, prefix + "range_from") = "";
			sheetObj.CellValue2(i, prefix + "range_to") = "";
			sheetObj.CellEditable(i, prefix + "range_from") = false;
			sheetObj.CellEditable(i, prefix + "range_to") = false;
		}
		
	}		
	sheetObj.Redraw = true; 
}

/********************************************************************************************************************
 * <Base(Detail) Sheet의 Data에 따른 Seq. Numbering, Cell 활성화 등 각종 제약사항 표현>                          
 ********************************************************************************************************************
 * 1. Seq.는 10부터 시작하여 10씩 증가한다.                             
 * 2. Object, UOM, Rate Type이 같으면 동일 Seq.를 갖는다.                             
 * 3. 연속된 Row에서는 동일 Object, UOM, Rate Type 中 'Fixed'는 가질 수 없다. 
 * 4. Rate Type이 'Fixed'일 경우, Range(From/To)는 값이 없다.
 * 5. 동일 Seq.이면 Rate Condition과 Alias는 같다.                                              
 ********************************************************************************************************************/
function  f_RearrangeConditionInSheet2(Row){
	var prefix = "sheet2_";
	var sheetObj = sheetObjects[1];
	sheetObj.Redraw = false; 
	
	var pre_obj_list_no		= "";
	var pre_object_code_dsp = "";
	var pre_rate_code 		= "";
	
	var obj_list_no			= "";
	var object_code_dsp 	= "";
	var rate_code 			= "";
	
	var condition = "";
	var cond_desc = "";
	var alias = "";
	
	for(i=Row; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){ 
		
		if(i == Row){
			continue;
		}
		
		pre_obj_list_no		= i == sheetObj.HeaderRows ? "-1" 	   									   		: sheetObj.CellValue(i-1, prefix + "obj_list_no");
		pre_object_code_dsp	= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "object_code_dsp")	: sheetObj.CellValue(i-1, prefix + "object_code_dsp");
		pre_rate_code		= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "rate_code")   		: sheetObj.CellValue(i-1, prefix + "rate_code");
		pre_condition		= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "condition")   		: sheetObj.CellValue(i-1, prefix + "condition");
		pre_cond_desc		= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "cond_desc")   		: sheetObj.CellValue(i-1, prefix + "cond_desc");
		pre_alias			= i == sheetObj.HeaderRows ? sheetObj.CellValue(i, prefix + "cons_als_nm") 		: sheetObj.CellValue(i-1, prefix + "cons_als_nm");
		
		obj_list_no 	= sheetObj.CellValue(i, prefix + "obj_list_no");
		object_code_dsp	= sheetObj.CellValue(i, prefix + "object_code_dsp");
		rate_code 		= sheetObj.CellValue(i, prefix + "rate_code");
		condition 		= sheetObj.CellValue(i, prefix + "condition");
		cond_desc 		= sheetObj.CellValue(i, prefix + "cond_desc");
		alias	 		= sheetObj.CellValue(i, prefix + "cons_als_nm");
		
		if(obj_list_no == pre_obj_list_no && rate_code == pre_rate_code && rate_code != "F"){	//바로 윗 row와 같다면
			sheetObj.CellValue2(i, prefix + "condition") 		= pre_condition;
			sheetObj.CellValue2(i, prefix + "cond_desc") 		= pre_cond_desc;
			sheetObj.CellValue2(i, prefix + "cons_als_nm") 		= pre_alias;
			
			sheetObj.CellEditable(i, prefix + "condition") 		= false;
			sheetObj.CellEditable(i, prefix + "cons_als_nm") 	= false;
		} else{
			break;
		
			sheetObj.CellValue2(i, prefix + "condition") 		= condition;
			sheetObj.CellValue2(i, prefix + "cond_desc") 		= cond_desc;
			sheetObj.CellValue2(i, prefix + "cons_als_nm") 		= alias;
			
			sheetObj.CellEditable(i, prefix + "condition") 		= true;
			sheetObj.CellEditable(i, prefix + "cons_als_nm") 	= true;
		}
		
	}		
	sheetObj.Redraw = true; 
}

/*
 * 모든 Sheet 지우기
 * @History 
 *  -김차장님 요청(임시) : Param section 추가 (Key변경시 return,  New Click시 clear)
 */
function f_RemoveAllSheet(section){
	/******************************/
	if(section == undefined){
		return;
	} else if(section == "IBCLEAR"){
		//지우기
	}
	/******************************/
	  
	var formObject = document.form;
	//Sheets	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	document.getElementById("cSur").checked = false;
	document.getElementById("cDis").checked = false;
	document.getElementById("div_surcharge").style.display = "none";
	document.getElementById("div_discount").style.display = "none";
	document.getElementById("foml_desc").innerHTML = "";
	document.getElementById("cond_desc").innerHTML = "";
	formObject.cpls_flg.checked = false;
}

function f_AfterRetrieve(){
	if(sheetObjects[2].RowCount > 0){
		sheetObjects[2].style.height = HEIGHT_SHEET3;
		sheetObjects[1].style.height = HEIGHT_SHEET2;
	} else{		
		sheetObjects[2].style.height = 0;
		sheetObjects[1].style.height = HEIGHT_SHEET2+HEIGHT_SHEET3;
	}
	
	if(sheetObjects[3].RowCount > 0){
		document.getElementById("cSur").checked = true;
		document.getElementById("div_surcharge").style.display = "inline";
	} else{		
		document.getElementById("cSur").checked = false;
		document.getElementById("div_surcharge").style.display = "none";
	}
	
	if(sheetObjects[4].RowCount > 0){
		document.getElementById("cDis").checked = true;
		document.getElementById("div_discount").style.display = "inline";
	} else{		
		document.getElementById("cDis").checked = false;
		document.getElementById("div_discount").style.display = "none";
	}
	
	if(sheetObjects[0].RowCount > 0){
		document.form.cpls_flg.checked = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_cpls_flg") == "Y" ? true : false;
	} else{
		document.form.cpls_flg.checked = false;
	}
}

/********************************************************************************************************************
 * <Grid Copy Button 제어>                                       
 ********************************************************************************************************************
 * 1. 바로 윗행의 Formula No와 같은 경우 Grid Copy Button을 활성화시킨다.
 ********************************************************************************************************************/
function f_ControlGridCopyButton(){
	
	return;	//[2010.02.26] 다른 Formula의 Object도 Copy 가능하게 변경
	
	var sheetObj = sheetObjects[0];
	var selectedRow = sheetObj.SelectRow;
	
	//첫째행
	if(selectedRow == sheetObj.HeaderRows){
		ComBtnDisable("btn_GridCopy");
	} else{
		var foml_no_1 = sheetObj.CellValue(selectedRow, "sheet1_formula_no");	
		var foml_no_2 = sheetObj.CellValue(selectedRow-1, "sheet1_formula_no");
		//바로 윗행의 Formula와 같으면
		if(foml_no_1 != "" && foml_no_1 == foml_no_2){			
			ComBtnEnable("btn_GridCopy");
		} else{
			ComBtnDisable("btn_GridCopy");			
		}
	}
}

/********************************************************************************************************************
 * <VOP_PSO_0036 화면의 'Tariff Update' Button을 Click하여 호출된 경우>                                       
 ********************************************************************************************************************
 * 1. movedParams는 조회조건들의 Key:Value 쌍을 '||'로 연결한 문자열이다.
 * 2. 조회조건을 Setting한 후, Data를 조회한다.                                                     
 ********************************************************************************************************************/
function f_RetrieveMovedFrom(movedParams){
	var formObj = document.form; 
	var arrMovedParams = movedParams.split("||");	//key::val
	var verSeq = "001";

	
	for(i=0; i<arrMovedParams.length; i++){
		
		var key_val = arrMovedParams[i].split("::");
		var key = key_val[0];
		var val = key_val[1];
		//Port
		if(key == "port_cd"){
			formObj.port_cd.value = val;
			doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
		}
		//Year
		if(key == "year"){			
			formObj.year.value = val;
		}
		//Yard
		if(key == "yd_cd"){
			comboObjects[0].Code = val; 
		}
		
		//Account
		if(key == "acct_cd"){
			comboObjects[1].Code = val;  
		}
		
		//Cost
		if(key == "cost_cd"){
			comboObjects[2].Code = val; 
		}
				
		//Service Provider
		if(key == "vndr_seq"){		
			formObj.vndr_seq.value = val;
			doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
		}
		
		//yard Charge Version Sequence
		if(key == "ver_seq"){
			if(val < 10){
				val = "00"+val;
			}else if(val < 100){
				val = "0"+val;
			}
			verSeq = val;
		}
	}
	ComOpenWait(true);
	searchVersion();
	comboObjects[4].Code = verSeq;		// comboObjects[3] -> 4 으로 변경완료
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);	
	ComOpenWait(false);
}

/********************************************************************************************************************
 * <Base(Master) RowAdd시, UK값을 채번한다.>                          
 ********************************************************************************************************************
 *                                           
 ********************************************************************************************************************/ 
function f_GetMinValInSheet(sheetObj, col){
	var minVal = 0;
	var tmpVal = 0;
	if(sheetObj.RowCount == 0){
		minVal = 0;
	} else{
		for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow+1; i++){
			tmpVal = Number(sheetObj.CellValue(i, col));
			if(tmpVal < minVal){
				minVal = tmpVal;
			}
		}
	}
	return minVal;
}

/********************************************************************************************************************
 * <Base(Master) Formula에 속한 Object로만 콤보로 만들기>                          
 ********************************************************************************************************************
 * 1. sheet1_foml_sys_desc 中에서 [45]를 제외하여 Base(Detail) Object Combo를 만든다.                                        
 ********************************************************************************************************************/ 
function f_SetComboItemByFormula(fomlSysDesc){
	var regExp = /\[[0-9]+\]|<[0-9]+>/gim;
	var result = fomlSysDesc.match(regExp);

	if(result != null){
		var strObjCode = "," + result.join(",").replace(/\[45\]/g, "").replace(/\[|\]|<|>/g, "") + ",";	//Rate 제외
	
		var comboItems = ComGetEtcData(conditionXML, "objlist");
		
	 	var comboCode= "";
	 	var comboText= "";
	 	
	 	var arrComboItems = comboItems.split("|");
	 	for (i = 0 ; i < arrComboItems.length ; i++) {
	 		var comboItem = arrComboItems[i].split(",");
	 		//comboItem[0] : PSO_OBJ_CD                       
	 		//comboItem[1] : PSO_OBJ_CD_DSP                   
	 		//comboItem[2] : PSO_MEAS_UT_CD                   
	 		//comboItem[3] : PSO_MEAS_UT_CD_DSP               
	 		//comboItem[4] : OBJ_LIST_NO                      
	
	 		if(strObjCode.indexOf("," + comboItem[4] + ",") > -1){
				comboCode += "|" + comboItem[4];
				comboText += "|" + comboItem[1] + "\t" + comboItem[3];
	 		}
	 	}
	 	
	 	comboCode = comboCode.substr(1);	//Code
	 	comboText = comboText.substr(1); 	//Text
		
		//Base Sheet의 Object Combo Setting
		sheetObjects[1].InitDataCombo(0, "sheet2_obj_list_no", comboText, comboCode);	
	} else{
		//Base Sheet의 Object Combo Setting
		sheetObjects[1].InitDataCombo(0, "sheet2_obj_list_no", "", "");
	}
}

/********************************************************************************************************************
 * <Base(Detail) UOM에 따라 Range의 Type변경 (시간, 숫자)>                          
 ********************************************************************************************************************
 *                                     
 ********************************************************************************************************************/ 
function f_SetCellProperty(sheetObj, row){
	var prefix = "sheet2_";
	var val = sheetObj.CellValue(row, prefix + "object_code_dsp");	//UOM
	if(val == "TIME"){
		sheetObj.InitCellProperty(row, prefix + "range_from", dtNull, daCenter,  prefix + "range_from" , "", dfTimeHm);
		sheetObj.InitCellProperty(row, prefix + "range_to", dtNull, daCenter,  prefix + "range_to" , "", dfTimeHm);
	} else{			
		sheetObj.InitCellProperty(row, prefix + "range_from", dtNull, daCenter,  prefix + "range_from" , "", dfNumber);
		sheetObj.InitCellProperty(row, prefix + "range_to", dtNull, daCenter,  prefix + "range_to" , "", dfNumber);
	}	
}

/********************************************************************************************************************
 * <Base(Master) NewRow에 해당하는 Base(Dummy) Data를 얻는다.>                          
 ********************************************************************************************************************
 * 1. Base(Dummy) Data를 Base(Detail)에 복사하는 IBSheet 내장함수의 속도가 느려서 Sheet에 Mapping하는 Data를 생성한다.     
 * 2. Data 생성시, Column명에 주의한다. (Prefix : sheet2 -> sheet6)                                    
 ********************************************************************************************************************/ 
function f_MakeSearchXml4CopyDummy2Base(uk)  {
	var sheetObj = sheetObjects[5];
	try {
		var allXml = "";
		var hColSep = "|";
		var sColSep = "☜☞";
		var sColOrder = "";

		var aryTD = new Array(gColumnCountInSheet2);
		for(var i = 0; i < gColumnCountInSheet2; i++){
			aryTD[i] = sheetObj.ColSaveName(i).replace(/sheet6/g, "sheet2");
		}
		sColOrder = aryTD.join(hColSep);
		
		allXml  = "<?xml version='1.0'  ?>\n" 
			    + "<SHEET>\n";
		allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";

		var arrRow = new Array();
		var k = 0;
		
		var aryTR  = new Array();
		
		for( var ir=sheetObj.HeaderRows; ir<sheetObj.RowCount + sheetObj.HeaderRows; ir++ ) {
			if(sheetObj.CellValue(ir, "sheet6_uk") == uk){
				for(var ic = 0; ic<gColumnCountInSheet2; ic++){
					//TD-셀의 값을 변수에 저장한다.
					aryTD[ic] = sheetObj.CellValue(ir, ic);
				}
				aryTR[k++] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			}
		}
		
		allXml += aryTR.join("\n")
			    + "  \n</DATA>\n"
		        + "</SHEET>";
		
		aryTD = new Array();
		aryTR = new Array();
		
		return allXml;
	} catch(err) { ComFuncErrMsg(err.message); }
}  

/********************************************************************************************************************
 * <Base(Detail) Data를 얻는다.>                          
 ********************************************************************************************************************
 * 1. Base(Detail) Data를 Base(Dummy)에 복사하는 IBSheet 내장함수의 속도가 느려서 Sheet에 Mapping하는 Data를 생성하였음
 * 2. Data 생성시, Column명에 주의한다. (Prefix : sheet6 -> sheet2) 
 * 3. Base(Detail) Data 中 Range(From/To)의 경우는, Mask를 보존하여 복사한다.                                        
 ********************************************************************************************************************/ 
function f_MakeSearchXml4CopyBase2Dummy(oldUk)  {
	var sheetObj = sheetObjects[1];
	try {
		var allXml = "";
		var hColSep = "|";
		var sColSep = "☜☞";
		var sColOrder = "";
	
		var aryTD = new Array(gColumnCountInSheet2);
		for(var i = 0; i < gColumnCountInSheet2; i++){
			aryTD[i] = sheetObj.ColSaveName(i).replace(/sheet2/g, "sheet6");
		}
		sColOrder = aryTD.join(hColSep);
		
		allXml = "<?xml version='1.0'  ?>\n" 
			   + "<SHEET>\n"
		       + "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
		
		var aryTR  = new Array();
		
		for( var ir=sheetObj.HeaderRows; ir<sheetObj.RowCount + sheetObj.HeaderRows; ir++ ) {
			for(var ic = 0; ic<gColumnCountInSheet2; ic++){
				//TD-셀의 값을 변수에 저장한다.
				if(sheetObj.ColSaveName(ic) == "sheet2_range_from" || sheetObj.ColSaveName(ic) == "sheet2_range_to"){
					//Range 값일 경우, Mask를 보존한다.
					aryTD[ic] = sheetObj.CellText(ir, ic);
				} else{
					aryTD[ic] = sheetObj.CellValue(ir, ic);
				}
			}
			aryTR[ir-sheetObj.HeaderRows] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
		}
		
		allXml += aryTR.join("\n");
		allXml += "  \n</DATA>\n"
		       +  "</SHEET>";
			
			aryTD = new Array();
			aryTR = new Array();
		
		return allXml;
	} catch(err) { ComFuncErrMsg(err.message); }
}  

function f_SetHeadUnCheckAll(){
	var objHeadCheck = [
	                    {"sheetObj" : "sheetObjects[0]", "rows" : "0,1", "col" : "sheet1_del_chk"}
	                   ,{"sheetObj" : "sheetObjects[1]", "rows" : "0,1", "col" : "sheet2_del_chk"}                   
                       ,{"sheetObj" : "sheetObjects[3]", "rows" : "0",   "col" : "sheet4_del_chk"}                 
                       ,{"sheetObj" : "sheetObjects[4]", "rows" : "0",   "col" : "sheet5_del_chk"}              
					   ];
	gf_SetHeadUnCheckAll(objHeadCheck);
}

function f_SetHeadUnCheck(objHeadCheck){
	gf_SetHeadUnCheckAll(objHeadCheck);
}

/**
 * Remark 팝업설정
 */
function setPortTrfRmk(rtnValue) {
	
	ComSetObjValue(document.form.port_trf_rmk, rtnValue);
}

/**
 * Contract 팝업설정
 */
function setContract(rtnValue) {
	
	ComSetObjValue(document.form.contract, rtnValue);
}

/* 개발자 작업  끝 */