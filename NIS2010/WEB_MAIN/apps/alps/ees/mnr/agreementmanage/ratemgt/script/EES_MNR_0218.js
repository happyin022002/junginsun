﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0218.js
*@FileTitle : M&R AGREEMENT DETAIL Pop_Up
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.03 함형석
* 1.0 Creation
* 2014-11-06 CSR ID : CHM-201432660 : ALPS MNR-AGMTTARIFF 화면에서 GW-Contract Document와 ALPS MNR-AGMT와 Interface된 결과 값을 보여줄수 있도록 구현 : AA Chang Young Kim, DEV 이상근
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
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
	 * @class EES_MNR_0218 : EES_MNR_0218 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0218() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
	}
/* 개발자 작업	*/
	
 
// 공통전역변수
  
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var tempSheetObjects = new Array();

var sheetObjects = new Array();	
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0; 

// 조회상태 여부 (현제 조회상태인지 아닌지)
var nowRetriveSt = false; 

var retPossible = false;		 

//탭메뉴를 가지고 있는 배열
var uTab = new Array();
var gTab = new Array(); 
var zTab = new Array(); 

//LB 타입일 경우 헤더 배열  eq_type 별 3가지 모두 동일  
var lbHeader = new Array();	 

//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
var uTpSz = new Array();	
var gTpSz = new Array();
var zTpSz = new Array();

//버젼정보의 디폴트
var defVerCode = "1";	
//trsm_mod_cd 의 디폴트  
var defTrsmCode = "";

//초기화인제 구분 
var loadIbclear = false;

var tempEqKndCd = "U";

//이전 trf_no 를 기억하기 위한	
var priTrfNo = "";

var formObj = document.form; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick; 

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	 
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					if(retPossible) {
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					break;
					
				case "btn_new":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
					
				case "btn_close":
					window.close();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		MnrWaitControl(true);
		initControl();	
		//메뉴 구조를 가져오고 타입별로 각 배열에 담는다. 
		setPageInit();
		
		//형식적 initSheet
		initSheet(sheetObjects[0],"sheet1",'','');
						
		ComConfigSheet(sheetObjects[1]);
		initSheet(sheetObjects[1],"sheet2",'','');
		ComEndConfigSheet(sheetObjects[1]);
		
		for(k=0;k<comboObjects.length;k++) {
			initCombo(comboObjects[k],k + 1);
		}
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		formObj.agmt_no.value=formObj.strAgmt_no.value;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	}

	/**
	 * Combo 기본 설정	
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */	 
	function initCombo (comboObj, comboNo) {
		//var cnt  = 0 ;
		var formObject = document.form
		
		switch(comboNo) {
			case 1:
				with (comboObj) {	
					SetTitle("Ver|Creation Date");
					SetColAlign("left|left");
					SetColWidth("50|170");
					DropHeight = 160;
				}
			break;
			
			case 2:
				with (comboObj) {
					SetTitle("Code|Desc");
					SetColAlign("left|left");
					SetColWidth("50|170");
					DropHeight = 160;
				}
			break;
			
			case 4:
				with (comboObj) {
					SetTitle("Tariff No|Tariff Type|Service Provider|EQ Type|Status|Eff.From|Unit|Currency");
					SetColAlign("left|left|left|left|left|center|left|left");
					SetColWidth("140|80|180|80|100|80|80|80");
					DropHeight = 160;
				}
			break;
			
			default :
				with (comboObj) {
					//SetColAlign("left");
					//DropHeight = 160;
				}
			break;
		 }
	}
				
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetType,eq_type,display_type) {  
		var cnt = 0;
		 
		switch(sheetType) {	 
			case "sheet1": 
				with (sheetObj) {
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}  	
			case "sheet2":	  //t1sheet1 init	
				with (sheetObj) {
					// 높이 설정
					style.height = 220; 
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(24, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다.	   
					InitHeadMode(true, true, true, true, false,false);		 
 
					var HeadTitle1 = "|Sel|Cost CTRL\nOffice|Transmission\nMode|EDI ID|Web ID|Tel No|Fax No|E-mail|Remark";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1 , true);	 
   					
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,		daCenter,  	false,   "ibflag"); 
					InitDataProperty(0, cnt++ , dtDummyCheck,   	40,	 daCenter,   false,   "del_check",	 			false,   		 "",	  dfNone,	 0,		true,		true); 
					InitDataProperty(0, cnt++ , dtPopupEdit,	  	70,   	daLeft,  	true,	"aply_ofc_cd",	 		false,			 "",	  dfNone,	0,	 true,	   true); 
							 
					//추가 파트너용 
					InitDataProperty(0, cnt++ , dtCombo,	  		80,   	daLeft,  	false,   "trsm_mod_cd",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		80,		daLeft,  	false,   "edi_id", 					false,   		 "",	  dfNone, 	 0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		80,		daLeft,  	false,   "sp_ptal_id", 				false,   		 "",	  dfNone, 	 0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		80,		daLeft,  	false,   "phn_no", 					false,   		 "",	  dfNone, 	 0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		80,		daLeft,  	false,   "fax_no", 					false,   		 "",	  dfNone, 	 0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		80,		daLeft,  	false,   "mnr_prnr_eml", 			false,   		 "",	  dfNone, 	 0,	 true,	   true);
							
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "agmt_ofc_cty_cd",	 	false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "agmt_seq",	 			false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "agmt_ver_no",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "agmt_ofc_tp_cd",	 		false,		   "",	  dfNone,	0,	 true,	   true);
				 	//추가 파트너용 
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "ctrl_ofc_cd",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "mnr_grp_tp_cd",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "mnr_prnr_tp_cd",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "mnr_prnr_knd_cd",	 	false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "mnr_prnr_sts_cd",	 	false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "mnr_prnr_seq",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "pay_term_dys",	 		false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	false,   "eff_dt",	 				false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	true,	"exp_dt",	 				false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daCenter,  	true,	"mnr_prnr_locl_lang_nm",   false,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 0,   	daLeft,  	false,   "mnr_prnr_lgl_eng_nm",  	false,   		 "",	  dfNone, 	 0,	 false,	  false);
								
					WaitImageVisible = false; 		
									 			
					InitDataValid(0,  "aply_ofc_cd", vtEngUpOther,"0123456789"); 
					InitDataValid(0,  "edi_id", vtEngUpOther,"0123456789"); 
					InitDataValid(0,  "sp_ptal_id", vtEngUpOther,"0123456789"); 
					InitDataValid(0,  "phn_no", vtNumericOther,"-"); 
					InitDataValid(0,  "fax_no", vtNumericOther,"-"); 
					InitDataValid(0,  "mnr_prnr_eml", vtEngDnOther,"0123456789@."); 
					  	 
					PopupImage  =  "/hanjin/img/btns_search.gif";
					ShowButtonImage = 2;
							
					MultiSelection = false;
					//SELECT 로우 배경색		  
					SelectionMode = smSelectionRow;	  
					SelectHighLight = true;			 
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB); 
							 
   					CountPosition = 0;	 

				}
				break;
			case "LB":	  //lb
				with (sheetObj) {
					// 높이 설정
					style.height = 215;
					//전체 너비 설정	 
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100); 

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);		
								
					// 해더에서 처리할 수 있는 각종 기능을 설정한다.	  
					InitHeadMode(true, true, true, true, false,false); 

					var HeadTitle = "|Sel|Seq.|Detail Type|Rate Type|Amount";
						
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
						   
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,		daCenter,  	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   	40,		daCenter,  	true,   "del_check",	 		false,		  "",	  dfNone,	0,		true,		true); 
					InitDataProperty(0, cnt++ , dtSeq,				35,		daCenter,  	true,   "Seq");
					InitDataProperty(0, cnt++ , dtCombo,	  		130,   	daLeft,  	true,   "cost_cd",	 			true,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCombo,	  		130,   	daLeft,  	true,   "cost_dtl_cd",	 		true,		   "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		70,		daRight,  	false,  "agmt_rt_amt",			false,		  "",	  dfFloat, 	2,	 true,	   true);
				 					  					  
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,  "agmt_ofc_cty_cd",	  false,		  "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,  "agmt_seq",				false,		  "",	  dfNone,	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,  "agmt_ver_no",			false,		  "",	  dfNone,	0,	 true,	   true);
																						 			 		   
					//LB형 쉬트 콤보 설정 값이 유동적 			   					 
					var sCondition = new Array (  		
						new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM5"),	
						new Array("MnrGenCd","MRDRRC", "COMMON")	
					)				
										
					var comboList = MnrComSearchCombo(sheetObj,sCondition);	
					//쉬트 콤보데이타에 값을 세팅함	 			
					var sheetComboText = "";
					var sheetComboCode = ""; 
					var sheetComboDefault = ""; 
					//쉬트 콤보 SAVE_NAME			
					var comboSaveNames = new Array();	
					comboSaveNames[0] = "cost_cd"; 	
					comboSaveNames[1] = "cost_dtl_cd"; 
									
					for(var i = 0; i < comboList.length;i++) {
					 	if(comboList[i] != null) {	
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							sheetComboCodeText = "";
							sheetComboDefault = ""; 	
								   
					 		for(var j = 0; j < comboList[i].length;j++) { 
								var tempText = comboList[i][j].split("|");	
								 
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
								if(j ==0) {
									sheetComboDefault = tempText[0];	  	
								}  
							}	
														
							sheetComboText = MnrDelLastDelim(sheetComboText);
							sheetComboCode = MnrDelLastDelim(sheetComboCode);
									
							InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault);
						}	
					}
											 
					//SELECT 로우 배경색		 
					SelectionMode = smSelectionFree;	 
					SelectHighLight = true;		   
					SelectFontBold = false;		   
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 0;	 
				}
				break; 
  				 
			case "TS":	  //ts  
				with (sheetObj) {
					// 높이 설정
					style.height = 215;	
					//전체 너비 설정			
					SheetWidth = mainTable.clientWidth; 
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);
					
					//컬럼 정보 설정전에 미리 루핑 
					var disPlayTpSz = new Array();
					var HeadTitleTemp = "";					
										   					
					if(eq_type == 'U') { 
						disPlayTpSz = uTpSz;		
					} else if(eq_type == 'G') { 
						disPlayTpSz = gTpSz;
					} else if(eq_type == 'Z') { 
						disPlayTpSz = zTpSz;	   
					} 
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);		  
   
					// 해더에서 처리할 수 있는 각종 기능을 설정한다. 
					InitHeadMode(true, true, true, true, false,false);
								
					var HeadTitle = "|Sel|Seq.|Detail Type|TP/SZ|Amount";
						  
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);	   
								
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 50,		daCenter,  	false,   	"ibflag"); 
					InitDataProperty(0, cnt++ , dtDummyCheck,   	 40,		daCenter,  	true,   	"del_check",	 		false,		 "",	  dfNone,		0,	   true,		true);
					InitDataProperty(0, cnt++ , dtSeq,				 35,		daCenter,  	true,	 	"Seq");
					InitDataProperty(0, cnt++ , dtCombo,			 150,   	daLeft,  	true,	 	"cost_dtl_cd",			true,		  "",	  dfNone, 	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtPopup,		 	 70,   		daCenter,  	true,	 	"mnr_rt_tp_cd",			true,		  "",	  dfNone, 	0,	 true,	   true);
				  	InitDataProperty(0, cnt++ , dtData,	  		 70,		daRight,  	false,		"agmt_rt_amt",			false,		 "",	  dfFloat, 	2,	 true,	   true);
														  																							   
					InitDataProperty(0, cnt++ , dtHidden,	  		 140,		daCenter,  	false,		"agmt_ofc_cty_cd",   	false,		 "",	  dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 140,		daCenter,  	false,		"agmt_seq",				false,		 "",	  dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 140,		daCenter,  	false,		"agmt_ver_no",			false,		 "",	  dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		 140,		daCenter,  	false,		"cost_cd",				false,		 "",	  dfNone,		0,	 true,	   true);
							 
					var sCondition = new Array (	   
					 	new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM4") 
					)	 		   
					var comboList = MnrComSearchCombo(sheetObj,sCondition);	  
								 
					var lbComboText = "";
					var lbComboCode = ""; 
					var lbComboDefault = "";
					//TS형 콤보타입 
					if(comboList[0] != null) {	 
						for(var j = 0; j < comboList[0].length;j++) { 
							var tempText = comboList[0][j].split("|");
							 
							lbComboText +=  tempText[1] + "|";
							lbComboCode +=  tempText[0] + "|";
							if(j == 0) {	
								lbComboDefault = tempText[0];	  	
							}				
						}	  
					}   		   
					InitDataCombo (0, "cost_dtl_cd", lbComboText, lbComboCode ,lbComboDefault);	
						
					PopupImage  =  "/hanjin/img/btns_search.gif";
					ShowButtonImage = 2;
					
					//SELECT 로우 배경색
					SelectionMode = smSelectionFree;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 0;
				}
				break;
				
			case "QT":	//qt 
				with (sheetObj) {
					// 높이 설정
					style.height = 215; 
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
					 
					var HeadTitle1 = "|Sel|Seq.|Detail Type|Q'ty|Amount";
				   	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					 
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,		daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   	40,		daCenter,  	true,   	"del_check",	 		false,		  "",	  dfNone,		0,	   true,		true);
					InitDataProperty(0, cnt++ , dtSeq,				35,		daCenter,  	true,	 	"Seq");
					InitDataProperty(0, cnt++ , dtCombo,			150,   	daLeft,  	true,	 	"cost_dtl_cd",   		true,		  	"",	  dfNone, 	 	0,	 true,	   true);
				 								 
					InitDataProperty(0, cnt++ , dtData,	  		70,		daRight,  	false,		"rpr_qty",	 			false,		  "",	  dfInteger,   	0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	  		70,		daRight,  	false,		"agmt_rt_amt",  		false,		  "",	  dfFloat, 		2,	 true,	   true);
							
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,		"agmt_ofc_cty_cd",		false,		  "",	  dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,		"agmt_seq",				false,		  "",	  dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,		"agmt_ver_no",			false,		  "",	  dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtHidden,	  		140,	daCenter,  	false,		"cost_cd",				false,		  "",	  dfNone,		0,	 true,	   true); 
													  
					//QT형 쉬트 콤보 설정 값이 유동적		 
					var sCondition = new Array (	   
					 	new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM4")  
					)  		
					var comboList = MnrComSearchCombo(sheetObj,sCondition);	  
													 
					var lbComboText = "";
					var lbComboCode = "";
					var lbComboDefault = "";
					//QT형 콤보타입 
					if(comboList[0] != null) {   
						for(var j = 0; j < comboList[0].length;j++) { 
							var tempText = comboList[0][j].split("|");
							
							lbComboText +=  tempText[1] + "|";
							lbComboCode +=  tempText[0] + "|"; 
							if(j == 0) {	 
								lbComboDefault = tempText[0];	  	
							}				 
						}	 
					}		
					InitDataCombo (0, "cost_dtl_cd", lbComboText, lbComboCode ,lbComboDefault);	
  											
					//SELECT 로우 배경색		   
					SelectionMode = smSelectionFree;	  
					SelectHighLight = true;		   
					SelectFontBold = false;		   
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 0;
				}  
				break;
		}
	}

	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */ 
	function initTab(tabObj ,disPlayArray ) {
		 with(tabObj) {	   
		 	 RemoveAll();
			 var cnt  = 0 ;
			 for(var j = 0; j < disPlayArray.length;j++) {   
			 	InsertTab( cnt++ , disPlayArray[j][6] , -1 );		   	
		   	 }
			 BaseColor = '#f3f2f8';
		 } 
	}
	
	function initControl() {		
		//Axon 이벤트 처리1. 이벤트catch 
		var formObject = document.form;	   
		axon_event.addListenerForm  ('blur',	 'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',	'obj_activate',	formObject,	'agmt_no');			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	}	 
	  
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
	   tempSheetObjects[sheetCnt++] = sheet_obj;	 
	}
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj; 
	}
	
	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {	 
		comboObjects[comboCnt++] = combo_obj;
	} 
	
	function setPageInit() {   
		//쉬트 순서를 바까준다.   
		for(var i =  0;i < tempSheetObjects.length ;i++) {
			if(tempSheetObjects[i].id == "sheet1") {		
				sheetObjects[0] = tempSheetObjects[i];	 
			} else if(tempSheetObjects[i].id == "sheet2") {  
				sheetObjects[1] = tempSheetObjects[i];	  
			} else if(tempSheetObjects[i].id == "t1sheet1") { 
				sheetObjects[2] = tempSheetObjects[i];	
			} else if(tempSheetObjects[i].id == "t2sheet1") {
				sheetObjects[3] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t3sheet1") {
				sheetObjects[4] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t4sheet1") {
				sheetObjects[5] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t5sheet1") {
				sheetObjects[6] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t6sheet1") {
				sheetObjects[7] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t7sheet1") {
				sheetObjects[8] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t8sheet1") {	
				sheetObjects[9] = tempSheetObjects[i]; 
			} 
		}		 
		//메뉴구조를 가져온다. 가져온 데이타를  각 배열로 쪼갠다.
		doActionIBSheet(sheetObjects[0],document.form,IBRESET);	
	}

	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate() {		 
		ComChkObjValid(event.srcElement); 
	}		
	 	 
	function obj_activate() {   
		var obj = event.srcElement;	   
		//버그성 agmt_no 일단 막아놈	   
		if(obj.name != "agmt_no") {		
			ComClearSeparator(event.srcElement);
			   		
		} else {	  
			obj.style.imeMode = "disabled" ;
		}		   
	}  
		 
	function obj_change() {	 
		var obj	  = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {	  
				case "vndr_seq":   
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01); 
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03);
					formObj.trf_no.Enable = true;	   
				   	break;
				case "agmt_no":	
					formObj.agmt_no.value = formObj.agmt_no.value.substring(0,3) + ComLpad(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length), 6, "0");
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
				case "pay_term_dys":
					//Ctrl Office 정보를 갱신한다. 
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) {	
						sheetObjects[1].CellValue2(i,"pay_term_dys") = ComGetObjValue(formObj.pay_term_dys);	  
					}		
					break;	
				case "eff_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) {	
						sheetObjects[1].CellValue2(i,"eff_dt") = ComGetObjValue(formObj.eff_dt);	  
					}
					break;
				case "exp_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) {	
						sheetObjects[1].CellValue2(i,"exp_dt") = ComGetObjValue(formObj.exp_dt);	  
					}
					break;	
						 
							  
			}	   
		} else {
			switch(obj.name) {	  
				case "vndr_seq":   
					formObj.vndr_nm.value = "";
					formObj.trf_no.RemoveAll();		
					formObj.trf_no.Code = "";
					formObj.trf_no.Enable = false;	   
					  
					//Ctrl Office 정보를 갱신한다. 
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) { 
						sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = "";
						sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = "";
						sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = "";
						sheetObjects[1].CellValue2(i,"pay_term_dys") = "";	   
					}  		 				
				   	break;	
				case "agmt_no":   
					//agmt_ver_no 세팅	   
					formObj.agmt_ver_no.RemoveAll();	 
					formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
					defVerCode = '1';		 
					formObj.agmt_ver_no.Code = defVerCode;	 
				   	break; 
				case "pay_term_dys" :
					//Ctrl Office 정보를 갱신한다. 
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) {	
						sheetObjects[1].CellValue2(i,"pay_term_dys") = "";	
					} 	
					break;	
				case "eff_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) {	
						sheetObjects[1].CellValue2(i,"eff_dt") = "";	  
					}	
					break;
				case "exp_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++) {	 
						sheetObjects[1].CellValue2(i,"exp_dt") = "";	   
					}			
					break;	  	   	
			}  				
		} 	 
	}	   
 						 
	function obj_keypress() { 
		obj = event.srcElement; 
		if(obj.dataformat == null) return;
		window.defaultStatus = obj.dataformat;
		
		switch(obj.dataformat) {
			case "ymd":
			case "ym":
			case "hms":
			case "hm":
			case "jumin":
			case "saupja":
				ComKeyOnlyNumber(obj);
				break; 
			case "int":	  
				ComKeyOnlyNumber(obj); 		
				break; 
			case "float":	
				ComKeyOnlyNumber(obj, "-."); 
				break;
			case "eng": 
				ComKeyOnlyAlphabet(); break;	 
			case "engup":		   
				if(obj.name=="vndr_seq") { 
					ComKeyOnlyNumber(obj);	 
				} else {
					ComKeyOnlyAlphabet('uppernum');	
				}				 
				break;	  
			case "engdn": 
				//포멧 처리를 하지 않기 위해   
				if(obj.name == "phn_no" || obj.name == "fax_no") {  
					ComKeyOnlyNumber(obj, "-");	 
				}   else { 
					ComKeyOnlyAlphabet('lower');	
				}	  
				break; 
		}  		  
	} 	

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.	  
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("tabLayer");
			
			objs[nItem].style.display = "Inline";
			objs[beforetab].style.display = "none"; 
 				
			//--------------- 요기가 중요 --------------------------//
			objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
			//------------------------------------------------------//
			beforetab = nItem;	 	 			 
	}
	
	function trf_no_OnChange(comboObj,Index_Code, Text) { 
		var formObj  = document.form;		  
		if(Index_Code != "") {
			var formObj  = document.form;	   
			var tempText = Text.split("|");
				 
			if(tempText[7] != formObj.curr_cd.Code) {  
				var usrOk = ComShowCodeConfirm("MNR00203",tempText[7]); 
				if(usrOk) {  
					formObj.curr_cd.Code2 = tempText[7];
					ComSetFocus(formObj.agmt_ref_no);		
				} else {  
					formObj.trf_no.Code2 = priTrfNo;	   
					ComSetFocus(formObj.agmt_ref_no);	  
				}	  	 	
			}	 
		}
		priTrfNo = formObj.trf_no.Code;
	}
			 
	function agmt_ver_no_OnChange(comboObj,Index_Code, Text) { 
		var formObj  = document.form;		
		if(comboObj.Code == defVerCode) {
			if(!loadIbclear) {
				ComBtnEnable("btn_save");	 
				ComBtnEnable("btn_del");		 
				ComBtnEnable("btn_versionup");
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_s1del");
				ComBtnEnable("btn_calendar");
				ComBtnEnable("btn_calendar1");			 	
			}
			MnrFormSetReadOnly(formObj,true,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk"); 
			//데이타 수정 가능하게	 
			setComboEnable(false);	 
				
			for(var i = 1; i < sheetObjects.length; i++) {  
				sheetObjects[i].Editable = false;			   
			}   
		} else {  
			if(!loadIbclear) {
				ComBtnDisable("btn_save");	 		
				ComBtnDisable("btn_del");			   
				ComBtnDisable("btn_versionup"); 
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_s1del");
				ComBtnDisable("btn_calendar");
				ComBtnDisable("btn_calendar1");			
			}		
			  										 
			MnrFormSetReadOnly(formObj,true,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			//데이타 수정 못하게		 
			setComboEnable(false);		
					
			for(var i = 1; i < sheetObjects.length; i++) {	  
				sheetObjects[i].Editable = false;	 				
			}			 
		}  	
			
		//초기세팅시에는 조회 안하게	
		if(formObj.agmt_no.value != "NEW" && formObj.agmt_no.value != "") {
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 			
		}		 
	}  	 	
		
	/*						
	function curr_cd_OnChange(comboObj,Index_Code, Text) { 
	}	  
		   
	function agmt_ofc_cd_OnChange(comboObj,Index_Code, Text) { 
	} 
	*/	 
			 
	//EQ_TYPE콤보 이벤트	 
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text) {  
		var formObj  = document.form;	 
		//확인 메세지  
		if(formObj.agmt_no.value == "NEW") {
			var cnt = 0;
			for (var i = 2; i < sheetObjects.length; i++) {
				cnt += sheetObjects[i].RowCount;
			}			
			if(cnt > 0) {
				//변경의사 확인
				if(!ComShowCodeConfirm("MNR00192")) {
					formObj.eq_knd_cd.Code2 = tempEqKndCd;
					return;	
				}				 
			}	 
		}
											  
		var objs = document.all.item("tabLayer");
		tempEqKndCd = comboObj.Code;		   
		 						  
	  	//텝세팅   쉬트세팅 0 1 쉬트는 다른용도로 사용	  		
		//mnr_ord_tp_cd|ibflag|eq_type|dp_seq|tab_type|cost_cd|tab_title|pagerows	
		//QT~~I~~Z~~6~~OT~~MRZSOT~~Other  
		objs[beforetab].style.display = "none"; 
		ComOpenWait(true,true);
		
		if(comboObj.Code == 'U') {
			for(var i = 0; i < uTab.length ; i++) {
				sheetObjects[i + 2].Reset();
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],uTab[i][0],comboObj.Code,uTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],uTab);
			formObj.agmt_type_tpsz.value = ComGetAryJoin(uTpSz, "|");
		} else if (comboObj.Code == 'G') {
			for(var i = 0; i < gTab.length ; i++) {
				sheetObjects[i + 2].Reset();
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],gTab[i][0],comboObj.Code,gTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],gTab);
			formObj.agmt_type_tpsz.value = ComGetAryJoin(gTpSz, "|");
		} else if (comboObj.Code == 'Z') {
			for(var i = 0; i < zTab.length ; i++) {
				sheetObjects[i + 2].Reset();
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],zTab[i][0],comboObj.Code,zTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],zTab);
			formObj.agmt_type_tpsz.value = ComGetAryJoin(zTpSz, "|");
		}
		ComOpenWait(false,true);
		objs[beforetab].style.display = "inline";
		
		//추가 요청 사항 eq_type 변할시 타리프 콤보도 변해야 한다.
		if(formObj.eq_knd_cd.Enable == true) {
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
		}
	}

	//삭제 버튼 클릭시 발생시킬 메세지
	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00020",ErrMsg);
		} else {		  
			ComShowCodeMessage("MNR00048",ErrMsg);
		}
	}

	//저장  버튼 클릭시 발생시킬 메세지 
	function sheet2_OnSaveEnd(sheetObj,ErrMsg) {
		if (ErrMsg == "") {			 
			ComShowCodeMessage("MNR00023",ErrMsg);
		} else {  
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}

	function sheet2_OnPopupClick(sheetObj, row,col) {
		if (sheetObj.ColSaveName(col) != "aply_ofc_cd") return;
		
		var param = "?row=" + row + "&col=" + col;
		ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}

	//오피스코드 벨리데이션 체크  
	function sheet2_OnChange(sheetObj,Row, Col, Value) {
		var retArray =  null;
		if (sheetObj.ColSaveName(Col) == "aply_ofc_cd") {
			doCheckOffice(sheetObj,Row,Col);
		}
	}

	function t1sheet1_OnChange(sheetObj,Row, Col, Value) {
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) = "";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	
	function t2sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t3sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t4sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t5sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t6sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t7sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t8sheet1_OnChange(sheetObj,Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd") {
			var disPlayTpSz = new Array();
			
			if(formObj.eq_knd_cd.Code == 'U') {
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G') {
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z') {
				disPlayTpSz = zTpSz;
			}
			
			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++) {
				if(disPlayTpSz[i] == Value) {
					checkResult = true;
				}
			}
			
			if(!checkResult) {
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		
		switch(sAction) {
			case IBSEARCH:	//조회
				if(validateForm(sheetObj,formObj,sAction)) {
					for(i = 0;i<sheetObjects.length;i++) {
						sheetObjects[i].RemoveAll();
					}
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					//헤더 데이타 세팅
					
					if(arrXml[0] != null) {   
						//agmt_no 를 조회해온걸루 새루 세팅
						ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
						//vndr
						ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
						//version no
						formObj.agmt_ver_no.Code2  = ComGetEtcData(arrXml[0], "agmt_ver_no");
						//currency
						formObj.curr_cd.Code  = ComGetEtcData(arrXml[0], "curr_cd");
						//agmt_ofc_cd
						formObj.agmt_ofc_cd.Code  = ComGetEtcData(arrXml[0], "agmt_ofc_cd");
						//eff dt
						ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
						ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
						//pay_term_dys
						ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
						//agmt sign dt
						ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
						//agmt_ref_no
						ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
						//EQ_TYPE
						formObj.eq_knd_cd.Enable = false;
						formObj.eq_knd_cd.Code  = ComGetEtcData(arrXml[0], "eq_knd_cd");
						//Tariff No
						setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
					}
					
					//쉬트 데이타 세팅
					for(var i = 1; i < arrXml.length + 1; i++) {
						sheetObjects[i].LoadSearchXml(arrXml[i - 1]);
					}
					//조회 상태
					nowRetriveSt = true;
					//isVersionUp 상태표시
					formObj.isversionup.value = "N";
					MnrFormSetReadOnly(formObj,true,"agmt_no");
				}
				break;
				
			case IBRESET:	// 메뉴구조를 가져온다 
				formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
				
				//0 mnr_ord_tp_cd|1 ibflag|2 eq_type|3 dp_seq|4 tab_title|5 pagerows
				var arrResult = MnrXmlToArray(sXml);
				
				var uCnt = 0;
				var gCnt = 0;
				var zCnt = 0;
				if(arrResult != null) {
					//갖고온 데이타를 타입별로 쪼갠다.
					for(var i = 0; i < arrResult.length;i++) {
						if(arrResult[i][2] == "U") {
							uTab[uCnt++] = arrResult[i];
						}
						if(arrResult[i][2] == "Z") {
							zTab[zCnt++] = arrResult[i];
						}
						if(arrResult[i][2] == "G") {
							gTab[gCnt++] = arrResult[i];
						}
					}
				}
				//EQ_TYPE별 타입사이를 조회해서 각 배열에 담는다.  
				var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
				
				if(arrXml != null) {
	 				for(var i = 0; i < arrXml.length; i++) {
						if(i == 0) {
							uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 1) {  
							zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 2) {	
							gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
						}
					}
				}
				break;
				
			case IBCLEAR:	//초기화  
				MnrWaitControl(true);
				loadIbclear = true;
				//쉬트 초기화   
				for(i = 0;i < sheetObjects.length;i++) {   
					sheetObjects[i].RemoveAll();	
					sheetObjects[i].Editable = false;	
				}  
				retPossible = false;
						
				nowRetriveSt = false; 
				
				//isVersionUp 상태표시  
				formObj.isversionup.value = "N";
				//ReadOnly 원상복귀
				MnrFormSetReadOnly(formObj,true,"agmt_no|vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
				//콤보 초기화
				for(var i = 0; i < comboObjects.length;i++) {
					comboObjects[i].RemoveAll();
					comboObjects[i].Enable = true;
				}
				//Tariff 콤보
				formObj.trf_no.Enable = false;
				priTrfNo = "";
				
				//폼 초기화 화면에 보여 지는 값만 리셋
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value = "";
				formObj.pay_term_dys.value = "";
				formObj.agmt_ref_no.value = "";
				formObj.agmt_rmk.value = "";
				//기본적으로 세팅해야 될값을 세팅
				//agreement no 
				formObj.agmt_no.value = "NEW"; //formObj.strAgmt_no.value;//  
				//agmt_ver_no 세팅	
				formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
				defVerCode = '1';
				formObj.agmt_ver_no.Code2 = defVerCode;	 
				//공통콤보 정보를 가져온다.  
				var sCondition = new Array (
				 	new Array("MdmCurrency","","COMMON"),		//CURRENCY
					new Array("MnrOfcGenInfo","","AGMT"),		//agmt_ofc_cd
					new Array("MnrGenCd","SELHO","CUSTOM9"),	//eq_knd_cd
					new Array("MnrGenCd","CD00016", "COMMON")	//trsm_mod_cd SHEET COMBO 
				)
				
				var defCode = "";
				var comboList = MnrComSearchCombo(sheetObj,sCondition);	   
				
				//콤보 설정
				for(var i = 0; i < comboList.length;i++) {
					if(comboList[i] != null) {
						//쉬트콤보별 초기화
						sheetComboText = "";
						sheetComboCode = "";
						for(var j = 0; j < comboList[i].length;j++) { 
							var tempText = comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							//CURRENCY
							if(i==0) {
								formObj.curr_cd.InsertItem(j, comboList[0][j] ,tempText[0]);
							//agmt_ofc_cd
							} else if(i==1) {
								formObj.agmt_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
								if(j == 0) {
									defCode = tempText[0];
									formObj.agmt_ofc_cd.Code = defCode; 
								} 
							//eq_knd_cd
							} else if(i==2) {
								formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
								//넘어온 값을 세팅한다.	   
								if(j == 0) {		 
									defCode = tempText[0];
									formObj.eq_knd_cd.Code = defCode;		 
								}	
							} 
						}
						//trsm_mod_cd 
						if(i==3) {
							sheetObjects[1].InitDataCombo (0, "trsm_mod_cd", sheetComboText, sheetComboCode, sheetComboCode);
						} 
					}
				}
				
				//기본으로  Agreement Office를 하나 깔아줌 
				var Row = sheetObjects[1].DataInsert(-1);	 
				sheetObjects[1].CellValue2(Row,"agmt_ofc_tp_cd") = "COST";	 
				sheetObjects[1].CellValue2(Row,"aply_ofc_cd") = formObj.agmt_ofc_cd2.value; 
				sheetObjects[1].CellValue2(Row,"ctrl_ofc_cd") = formObj.agmt_ofc_cd2.value; 
				sheetObjects[1].CellValue2(Row,"mnr_grp_tp_cd") = "RPR"; 
				sheetObjects[1].CellValue2(Row,"mnr_prnr_tp_cd") = "S"; 
				sheetObjects[1].CellValue2(Row,"mnr_prnr_knd_cd") = "C"; 
				sheetObjects[1].CellValue2(Row,"mnr_prnr_sts_cd") = "C"; 
				
				//AGMT Sign Date 세팅	 
				formObj.agmt_dt.value = ComGetNowInfo("ymd"); 
				//바꼇을지 모르는 값들을 원상복귀 한다.  
				loadIbclear = false;
				
				//RC 타입은 일단 모두 깔아준다. 이벤트 때문에  HARDCODING으로 변경 
				var sCode = sheetObjects[2].GetComboInfo(0,"cost_cd", "Code");
				var arrCode = sCode.split("|"); 
					  
				 
				for(var i = 0;i < arrCode.length;i++) {
					var Row = sheetObjects[2].DataInsert(-1);
					sheetObjects[2].CellEditable(Row,"cost_cd") = false; 
					sheetObjects[2].CellValue2(Row,"cost_cd") = arrCode[i];
				} 	
				
				MnrWaitControl(false);
				break;
				
			case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Service Provider Detail Information  
					var sXml = MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
							
					if(ComGetEtcData(sXml, "vndr_seq") != null) { 
						//Vender nm 세팅		
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						
						//Curr 세팅 	
						formObj.curr_cd.Code  = ComGetEtcData(sXml, "pay_curr_cd"); 
						
						//PAY TERM 세팅 
						var tempPayTerm = ComGetEtcData(sXml, "gen_pay_term_cd");
						
						if(tempPayTerm != "") {
							if("O60" == tempPayTerm || "O45" == tempPayTerm) {
								ComSetObjValue(formObj.pay_term_dys,"0");
							} else if ("IN" == tempPayTerm) { 	
								ComSetObjValue(formObj.pay_term_dys,"5");
							} else if ("OUT" == tempPayTerm) { 	
								ComSetObjValue(formObj.pay_term_dys,"60");
							} else {
								ComSetObjValue(formObj.pay_term_dys,tempPayTerm);
							} 
						}
						
						//Ctrl Office 정보를 갱신한다.
						for(var i = 1; i <= sheetObjects[1].LastRow ;i++) { 
							sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = ComGetEtcData(sXml, "vndr_seq");
							sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = ComGetObjValue(formObj.vndr_nm);
							sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = ComGetObjValue(formObj.vndr_nm);
							sheetObjects[1].CellValue2(i,"pay_term_dys") =ComGetObjValue(formObj.pay_term_dys);
						} 			 				  
					} else {		   
						ComShowCodeMessage("MNR00005", "Service Provider");			  
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, ""); 
						ComSetFocus(formObj.vndr_seq); 	
						ComSetObjValue(formObj.pay_term_dys,"0");
						formObj.curr_cd.Code = "";
						
						//Ctrl Office 정보를 갱신한다.
						for(var i = 1; i <= sheetObjects[1].LastRow ;i++) { 
							sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = "";
							sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = "";
							sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = "";
							sheetObjects[1].CellValue2(i,"pay_term_dys") = "";	  
						}
					}   	
				}	
				break; 		
															
				case IBSEARCH_ASYNC02:	//조회(agreement no 입력시)
					//version no 조회 	
					var sCondition = new Array ( 	
						new Array("MnrAgmtHdr",formObj.agmt_no.value,formObj.agmt_ofc_cd2.value)		
					) 													 
													   				  		   
					var comboList = MnrComSearchCombo(sheetObj,sCondition); 	
					formObj.agmt_ver_no.RemoveAll();	
					if(comboList[0] != null) {	
				 		for(var j = 0; j < comboList[0].length;j++) { 
							var tempText = comboList[0][j].split("|");
								   		   		 		  
							formObj.agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
							//넘어온 값을 세팅한다.	   
							if(j == 0) {		   
								defVerCode = tempText[0];
								formObj.agmt_ver_no2.value= tempText[0]; 
								formObj.agmt_ver_dt.value= tempText[1]; 
									   
							}					  
						}	  
						formObj.agmt_ver_no.Code2 = defVerCode; 
							 
						//********************** IBSEARCH START  **********************// 
						if(validateForm(sheetObj,formObj,IBSEARCH)) {	
							for(i = 0;i<sheetObjects.length;i++) {	 
								sheetObjects[i].RemoveAll();	
						 	}							   
				  			formObj.f_cmd.value = SEARCH;		 
							var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");		  
								
							//헤더 데이타 세팅	 
							if(arrXml[0] != null) {   
								//agmt_no 를 조회해온걸루 새루 세팅		 
								//ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//version no  
								formObj.agmt_ver_no.Code2  = ComGetEtcData(arrXml[0], "agmt_ver_no"); 
								//currency  
								formObj.curr_cd.Code2  = ComGetEtcData(arrXml[0], "curr_cd"); 
								ComSetObjValue(formObj.curr_cd2, ComGetEtcData(arrXml[0], "curr_cd"));
								//agmt_ofc_cd		
								formObj.agmt_ofc_cd.Code2  = ComGetEtcData(arrXml[0], "agmt_ofc_cd"); 	
								//eff dt 
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));		
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys")); 
								//agmt sign dt		
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no   
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE					   
								formObj.eq_knd_cd.Enable = false;
								formObj.eq_knd_cd.Code  = ComGetEtcData(arrXml[0], "eq_knd_cd");
								ComSetObjValue(formObj.eq_knd_cd2, formObj.eq_knd_cd.Text);
								formObj.agmt_rmk.value =  ComGetEtcData(arrXml[0], "agmt_rmk");
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));	
								//CHM-201432660 GW Contract No 추가
								//ComSetObjValue(formObj.gw_contract, ComGetEtcData(arrXml[0], "gw_uq_doc_no"));
								//[CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
								ComSetObjValue(formObj.gw_contract, ComGetEtcData(arrXml[0], "file_atch_flg"));
								
							}
							
							//쉬트 데이타 세팅
							for(var i = 1; i < arrXml.length + 1; i++) {
								sheetObjects[i].LoadSearchXml(arrXml[i - 1]);
							}
							//조회 상태
							nowRetriveSt = true;
							//isVersionUp 상태표시
							formObj.isversionup.value = "N";
							MnrFormSetReadOnly(formObj,true,"agmt_no");
						}
						//********************** IBSEARCH END  **********************//
					} else {
						//agmt_ver_no 세팅
						formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
						formObj.agmt_ver_no.Code = '1';
						defVerCode = '1';
						ComShowCodeMessage("MNR00165","Data");
						ComSetObjValue(formObj.agmt_no, "");
						ComSetFocus(formObj.agmt_no);
					} 
					
					retPossible = true;
				break;
				
			case IBSEARCH_ASYNC03:	//타리프 팝업 조회
			
				formObj.trf_no.RemoveAll();
				
				var ofcCd = formObj.local_ofc_cd.value;
				var mnrTrfKndCd = "LCL";
				var creDtFr = ComGetDateAdd(ComGetNowInfo("ymd"), "y", -1);
				var creDtTo = ComGetNowInfo('ymd');
				var eqKndCd = formObj.eq_knd_cd.Code;
				var mnrTrfStsCd = "HA";
				var vndrSeq = formObj.vndr_seq.value;
				
				var f_query = "";
				f_query += 'f_cmd' + '=' + SEARCH03	+ '&';
				f_query += 'ibflag=X&';
				f_query += 'ofc_cd' + '=' + ofcCd + "&";
				f_query += 'mnr_trf_knd_cd' + '=' + mnrTrfKndCd + "&";
				f_query += 'cre_dt_fr' + '=' + creDtFr + "&";
				f_query += 'cre_dt_to' + '=' + creDtTo + "&";
				f_query += 'eq_knd_cd' + '=' + eqKndCd + "&";
				f_query += 'mnr_trf_sts_cd' + '=' + mnrTrfStsCd + "&";
				f_query += 'vndr_seq' + '=' + vndrSeq;
				
				var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do","" ,f_query,true);
				
				//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no
				var arrResult = MnrXmlToArray(sXml);
				
				formObj.trf_no.InsertItem(0,"","");
				if(arrResult != null) {
					for(var i = 0; i < arrResult.length;i ++) {
						var tempComboText = arrResult[i][19] + "|" + arrResult[i][11] + "|" + arrResult[i][2] + "|" + arrResult[i][21] + "|" + arrResult[i][0] + "|" + arrResult[i][6] + "|" + arrResult[i][25] + "|" + arrResult[i][7];
						formObj.trf_no.InsertItem(i + 1, tempComboText ,arrResult[i][19]);
					}
				}
				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(formObj) {
			switch(sAction) {
				case IBSEARCH:
					if( formObj.agmt_no.value == ""  || formObj.agmt_no.value == "NEW") {
						ComShowCodeMessage("MNR00172","Agreement No For Search ");
						ComSetFocus(formObj.agmt_no);
						return false;
					} else if ( formObj.agmt_ver_no.Code == ""  ) {
						ComShowCodeMessage("MNR00172","Version No For Search ");
						formObj.agmt_ver_no.focus();
						return false;
					} else {
						formObj.agmt_ofc_cty_cd.value = formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value = parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						return true;
					}
					break;
					
				case IBSEARCH_ASYNC01:
					if( ComGetObjText(formObj.vndr_seq) == "" ) {
						ComShowCodeMessage("MNR00172","Service Provider Seq ");
						ComSetFocus(formObj.vndr_seq);
						return false;
					}
					break;
			}
		}
		return true;
	}

	function getMnr_psMulti(aryPopupData,sheet_id,temp_value1) {
		//temp value는 기호에 맞게 사용  0 -> cost_dtl_cd,1 -> cost_cd
		var tempVals = temp_value1.split("|");
		var formObj = document.form;
		var targetSheet = sheetObjects[sheet_id];
		//값이 없는 놈들은 모두 삭제한다.
		var startpoint = targetSheet.RowCount;
		for(var i = startpoint; i >= 1 ; i--) {
			if(targetSheet.CellValue(i,"mnr_rt_tp_cd")	== "") {
				targetSheet.RowDelete(i, false);	//완전 삭제
			}
		}
		
		for(var j = 0; j < aryPopupData.length ; j++) {
			var isHaveTpSz = false;
			for(var i = 1;i <= targetSheet.RowCount;i++) {
				if(targetSheet.CellValue(i,"cost_dtl_cd") == tempVals[0] && targetSheet.CellValue(i,"mnr_rt_tp_cd") == aryPopupData[j]) {
					isHaveTpSz = true;
				}
			}
			
			if(!isHaveTpSz) {
				var Row = targetSheet.DataInsert(-1);
				
				targetSheet.CellValue2(Row,"agmt_ofc_cty_cd") = formObj.agmt_ofc_cty_cd.value;
				targetSheet.CellValue2(Row,"agmt_seq") = formObj.agmt_seq.value;
				targetSheet.CellValue2(Row,"agmt_ver_no") = formObj.agmt_ver_no.Code;
				targetSheet.CellValue2(Row,"mnr_rt_tp_cd") = aryPopupData[j];
				targetSheet.CellValue2(Row,"cost_cd") = tempVals[1];
				targetSheet.CellValue2(Row,"cost_dtl_cd") = tempVals[0];
			}
		}
		
		if(targetSheet.RowCount > 1) {
			targetSheet.SelectCell(1, "agmt_rt_amt", false);
		}
	}

	/**
	 * COM_ENS_071 의 값을 받은 함수	  
	 */
	function getCOM_ENS_071(aryPopupData, row, col, shhetIdx) {
		var formObj = document.form;		  
		
		if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			 sheetObjects[1].CellValue(row,col) = aryPopupData[0][3];
		}
	}

	function setComboEnable(changeValue) {
		var formObj = document.form;
		for(var i = 1; i < comboObjects.length;i++) {
			comboObjects[i].Enable = changeValue;
		}
		
		if(changeValue == true) {
			if(formObj.vndr_seq.value == "") {
				formObj.trf_no.Enable = false;
			} else {
				formObj.trf_no.Enable = true;
			}
		}
		
		if(nowRetriveSt == true) {
			formObj.eq_knd_cd.Enable = false;
		} else {
			formObj.eq_knd_cd.Enable = true;
		}
	}
	
	function setTrfCombo(trfNo) {
		var formObj = document.form;
		
		if(formObj.vndr_seq.value == "") {
			formObj.trf_no.Enable = false;
			formObj.trf_no.RemoveAll();
			formObj.trf_no.Code2 = "";
		} else {
			formObj.trf_no.Enable = true;
			if(formObj.agmt_ver_no.Code == defVerCode) {
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
				formObj.trf_no.Code2 = trfNo;
				formObj.trf_no2.value = trfNo;
			} else {
				formObj.trf_no.RemoveAll();
				formObj.trf_no.InsertItem(0,trfNo,trfNo);
				formObj.trf_no.Code2 = trfNo;
				formObj.trf_no2.value = trfNo;
			}
		}
		
		if(formObj.agmt_ver_no.Code == defVerCode) {
			formObj.trf_no.Enable = true;
		} else {
			formObj.trf_no.Enable = false;
		}
	}

	function doCheckOffice(sheetObj,Row,Col) {
		var checkOffice = sheetObj.CellValue(Row ,Col);
		
		retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
		if(retArray == null) {
			ComShowCodeMessage("MNR00165",checkOffice);
			sheetObj.CellValue2(Row ,Col) = "";
			sheetObj.SelectCell(Row ,Col);
		} else {
			sheetObj.CellValue(Row ,"ctrl_ofc_cd") = sheetObj.CellValue(Row ,Col);
			return;
		}
	}	
	/* 개발자 작업  끝 */