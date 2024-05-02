/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0505.js
*@FileTitle : Refrigerator Parts Credit Status
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 
* 2016.04.26 Create
* 1.0 최초 생성
=========================================================*/

/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends EAS
 * @class ESD_EAS_0501
 */
function ESD_EAS_0501() {
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
var sheetCnt 	= 0;
var Mincount = 0;

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
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int}  sheetNo sheetObjects 배열에서 순번
 */
	function initControl() {
	axon_event.addListenerForm  ( 'blur'     ,'obj_blur'      ,document.form ); //- 포커스 나갈때
	axon_event.addListenerFormat( 'focus'    ,'obj_focus'     ,document.form ); //- 포커스 들어갈때
	axon_event.addListenerForm  ( 'change'   ,'obj_change'    ,document.form );
	axon_event.addListenerFormat( 'keypress', 'keypressFormat',document.form); //- 키보드 입력할때

	}
	

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var sheetObject   = sheetObjects[0];
	var sheetObject1  = sheetObjects[1]; 
	var cnt = 0;
	
	switch(sheetNo) {
			
		case 1:      //sheet1 Refrigerator Parts Credit
			with (sheetObj) {
			//style.height = GetSheetHeight(8); // 높이 설정
			style.height = 220;
			SheetWidth = gridTable1.clientWidth; //전체 너비 설정
			//SheetWidth = mainTable2.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

		   //전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 9, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23,6, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)

		   var HeadTitle1 = "|SEL|SEQ|Classification|Classification|Classification|Credit Issued|Credit Issued|Credit Issued|Credit Issued|Credit Issued|Credit Issued|Used Sum Amount|Balance|Refri.CNTR Lease Information|Refri.CNTR Lease Information|Refri.CNTR Lease Information|Refri.CNTR Lease Information|Refri.CNTR Lease Information|Evidence Attachment\n(Calculation&Obtaining)||Remark|USD Rate";
		   var HeadTitle2 = "|SEL|SEQ|RHQ|TEAM|Maker|Issue date|Curr.|Unit Credit|Qty|Credit total|Reason|Used Sum Amount|Balance|Lessor|AGMT No|TERM|TYPE/SIZE|Draft NO|Evidence Attachment\n(Calculation&Obtaining)||Remark|USD Rate";

			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus, 45,  	daCenter, 	true,   "ibflag",  			false,    	"",  	dfNone,     	0,     	true,   true,    	0,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtCheckBox,     40,  	daCenter, 	true,   "chk",  			false,    	"",  	dfNone,     	0,     	true,   true );
			InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,  	true,   "cr_iss_no",  		false,    	"",  	dfEngUpKey,     0,     	false,  false,  	11,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,  	true,   "rhq_cd",  			false,    	"",  	dfEngUpKey,     0,     	false,  false,  	6,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,  	true,   "team_cd",  		false,    	"",  	dfEngUpKey,     0,     	false,  false,  	6,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtCombo,      	100, 	daLeft,     true,   "mkr_cd",  			false,    	"",  	dfNone,     	0,     	false,  false,		2,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,      	80, 	daCenter,   true,   "cr_iss_dt",  		false,    	"",  	dfDateYmd,     	0,     	false,  false,  	10,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtCombo,      	80,  	daCenter, 	true,   "curr_cd",  		false,    	"",  	dfNone,     	0,     	false,  false,    	3,   	false,   true,     "",    false);		
			InitDataProperty(0, cnt++ , dtData,       	80,  	daRight,   	true,   "cr_iss_ut_amt",  	false,    	"",  	dfNullFloat,    2,     	true,   true,    	15,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,      	60,  	daRight,   	true,   "cr_iss_qty",  		false,    	"",  	dfInteger,     	0,     	true,   true,  		9,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,      	100, 	daRight, 	true,   "cr_iss_ttl_amt",  	false,    	"",  	dfNullFloat,    2,     	true,   true,    	15,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,       	100, 	daLeft,   	true,   "cr_iss_rsn",  		false,    	"",	 	dfNone,   	 	0,     	true,   true,   	500,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtHidden,   	100,  	daRight, 	true,	"cr_sum_usd_amt", 	false,    	"",  	dfNullFloat,    2,     	true,   true,       16,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,   		100,  	daRight, 	true,	"cr_bal_amt",  		false,    	"|cr_iss_ttl_amt|-|cr_sum_usd_amt|",  	dfNullFloat,2,     	true,    true,       15,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,       	100,  	daLeft, 	true,   "lr_nm",  			false,    	"",		dfEngUpKey,   	0,     	true,   true,    	100,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData, 		65,  	daCenter, 	true, 	"agmt_no",  		false,    	"",  	dfNone, 	 	0, 		true, 	true,       10,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,       	65,  	daCenter, 	true,   "lstm_cd",  		false,    	"",		dfEngUpKey,   	0,     	true,   true,    	2,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtCombo, 		65,  	daCenter, 	true, 	"eq_tpsz_cd",  		false, 		"",  	dfNone, 	 	0, 		true, 	true,       4,   	false,   true,     "",    false);
			InitDataProperty(0, cnt++ , dtData,       	150, 	daLeft,   	true,   "cr_iss_evid_no",  	false,    	"",	 	dfNone,   	 	0,     	true,   true,   	500,   	false,   true,     "",    false);
		    InitDataProperty(0, cnt++ , dtPopup,       	150,  	daCenter, 	true,   "atch_flg",  		false,    	"",		dfNone,     	0,      true,   true,       11,		false,	 true,	   "",	  false);
            InitDataProperty(0, cnt++ , dtHidden,  		80,   	daCenter,  	true,   "atch_file_lnk_id",	false,  	"",		dfNone,   		0,  	true,	true,		10,		false,	 true,	   "",	  false);
			InitDataProperty(0, cnt++ , dtData,       	100, 	daLeft,   	true,   "cr_iss_rmk",  		false,    	"",	 	dfNone,   	 	0,     	true,   true,   	50,   	false,   true,     "",    false);
            InitDataProperty(0, cnt++ , dtHidden,  		80,   	daRight,  	true,   "usd_rt",			false,  	"",		dfNullFloat,   	2,  	false,	false,		15,		false,	 true,	   "",	  false);	            
            
            InitDataCombo(0, 'curr_cd'," |"+curr_cdText, " |"+curr_cdCode);
		    InitDataCombo(0, 'mkr_cd', " |"+mkr_cdText, " |"+mkr_cdCode);
		    InitDataCombo(0, 'eq_tpsz_cd', " |R2|R4|R5|R7|R8|R9", " |R2|R4|R5|R7|R8|R9");
		                InitDataValid(0, "rhq_cd", 			vtEngUpOnly);
            InitDataValid(0, "team_cd", 		vtEngUpOnly);
			}
		break;
				
		case 2: //sheet2 Refrigerator Parts Credit Used
			with (sheetObj) {
				//style.height = GetSheetHeight(8); // 높이 설정
				style.height = 150;
				SheetWidth = gridTable2.clientWidth; //전체 너비 설정
				//SheetWidth = mainTable2.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
			   var HeadTitle1 = "|SEL|Issue No|SEQ|Ued Seq|Credit Used|Credit Used|Credit Used|Credit Used|Credit Used|Credit Used|Credit Used";
			   var HeadTitle2 = "|SEL|Issue No|SEQ|Ued Seq|Used date|Office|Amount|Sum of\neach Using|Evidence Attachment\n(Collection&Using)||Reason";

				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 45,  	daCenter, 	true,   "ibflag",  			false,    	"",  	dfNone,     	0,     	true,   true,    	0,   	false,   true,     "",    false);
				InitDataProperty(0, cnt++ , dtCheckBox,     50,  	daCenter, 	true,   "chk",  			false,    	"",  	dfNone,     	0,     	true,   true );
				InitDataProperty(0, cnt++ , dtHidden,       90,  	daCenter,  	true,   "cr_iss_no",  		false,    	"",  	dfEngUpKey,     0,     	false,  false,  	11,   	false,   true,     "",    false);
				InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
				InitDataProperty(0, cnt++ , dtHidden,       40,  	daCenter,  	true,   "cr_usd_seq",  		false,    	"",  	dfNone,     	0,     	false,  false,  	4,   	false,   true,     "",    false);
				InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,  	true,   "cr_usd_dt",  		false,    	"",  	dfDateYmd,     	0,     	true,   true,  	    10,   	false,   true,     "",    false);
				InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,  	true,   "cr_usd_ofc_cd",  	false,    	"",  	dfEngUpKey,     0,     	true,   true,  	    6,   	false,   true,     "",    false);
				InitDataProperty(0, cnt++ , dtData,      	120, 	daRight,    true,   "cr_usd_amt",  		false,    	"",  	dfNullFloat,    2,     	true,   true,		16,   	false,   true,     "",    false);
				InitDataProperty(0, cnt++ , dtData,      	120, 	daRight,    true,   "cr_sum_usd_amt",  	false,    	"",  	dfNullFloat,    2,     	false,  false,  	16,   	false,   true,     "",    false);
			    InitDataProperty(0, cnt++ , dtPopup,        150,  	daCenter, 	true,   "atch_flg",  		false,    	"",		dfNone,     	0,      true,   true,       11,		false,	 true,	   "",	  false);
	            InitDataProperty(0, cnt++ , dtHidden,  		80,   	daCenter,  	true,   "atch_file_lnk_id",	false,  	"",		dfNone,   		0,  	true,	true,		10,		false,	 true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	250,  	daLeft,   	true,   "cr_usd_rsn",  	    false,    	"",  	dfNone,    		0,     	true,  true,    	500,   	false,   true,     "",    false);
				
				InitDataValid(0, "cr_usd_ofc_cd", 			vtEngUpOnly);
			}
		break;
	}

}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){


/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var formObject = document.form;

	/*******************************************************/	

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, "SEARCH04");
				sheetObject2.RemoveAll();
			break;
			
			case "btng_save1":
				doActionIBSheet(sheetObject1, formObject, MULTI04);
			break;
			
			case "btn_maker":
				summaryMakerPopUp();
			break;
			
			case "btn_new":
				formObject.s_fm_dt.value="";
				formObject.s_to_dt.value="";
				formObject.s_mkr_cd.value="";
				formObject.s_cr_usd_ofc_cd.value="";
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
			break;	
			
			case "btng_save2":
				doActionIBSheet(sheetObject2, formObject, MULTI05);
			break;
					
			case "btng_downexcel1":
				sheetObject1.Down2Excel(-1, false, false, true);
			break;
			case "btng_downexcel2":
				sheetObject2.Down2Excel(-1, false, false, true);
			break;
			case "btng_load_excel1":
				sheetObject1.LoadExcel();
			break;
			
			case "btng_load_excel2":
				sheetObject2.LoadExcel();
			break;
			
			case "btng_row_add1":
				sheetObject1.DataInsert(-1);
				sheetObject1.CellEditable(sheetObject1.LastRow,"rhq_cd") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"team_cd") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"mkr_cd") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"cr_iss_dt") = true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"curr_cd") 	= true;
				sheetObject2.RemoveAll();
			break;				

			case "btng_row_add2":
				sheetObject2.DataInsert(-1);
				sheetObject2.cellvalue(sheetObject2.LastRow,"cr_iss_no") = sheetObject1.cellvalue(sheetObject1.SelectRow,"cr_iss_no");
			break;				


			case "btng_del_row1":
				doActionIBSheet(sheetObject1, formObject, REMOVE04);
			break;
	
			case "btng_del_row2":
				doActionIBSheet(sheetObject2, formObject, REMOVE05);
			break;

			case "btns_calendar_s":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.s_fm_dt, 'yyyy-MM-dd');
   	        break;

            case "btns_calendar_e":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.s_to_dt, 'yyyy-MM-dd');
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

	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

		    case "SEARCH04": // M&R Credit Issue
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCHLIST04;
				sheetObj.DoSearch4Post("ESD_EAS_0501GS.do", FormQueryString(formObj));
			break;

		    case MULTI04: //M&R Credit Issue Save
		    	if(validateForm(sheetObj, formObj, "MULTI04")){
					formObj.f_cmd.value = MULTI04;
					var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
			        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
			        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			        if (State != "S") {
			        	ComShowCodeMessage('COM12151',"Refrigerator Parts Credit Issue");
			        } else if (State == "S") {
			        	ComShowCodeMessage('COM12116',"Saving");
			        	doActionIBSheet(sheetObj, formObj, "SEARCH04");
			        	sheetObjects[1].RemoveAll();
			        }
		    	}
			break;
			
		    case MULTI05: //M&R Credit Used Save
		    	if(validateForm(sheetObj, formObj, "MULTI05")){
					formObj.f_cmd.value = MULTI05;
					var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
			        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
			        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			        var issSheetObj = sheetObjects[0];
			        var selRow ="";
			        var crIssNo="";
			       
			        if (State != "S") {
			        	ComShowCodeMessage('COM12151',"Refrigerator Parts Credit Used");
			        } else if (State == "S") {
			        	ComShowCodeMessage('COM12116',"Saving");
			        	selRow = sheetObjects[0].SelectRow;
			        	doActionIBSheet(issSheetObj, formObj, "SEARCH04");
			        	issSheetObj.SelectCell(selRow,"cr_iss_no");
			        	crIssNo = issSheetObj.CellValue(selRow,"cr_iss_no");
			        	sheetObj.DoSearch4Post("ESD_EAS_0501GS.do", "f_cmd="+SEARCHLIST05+"&str_cr_iss_no="+crIssNo);
			        }
		    	}
			break;

		    case REMOVE04: //M&R Credit Issue Delete
				var checkList = sheetObj.FindCheckedRow('chk');
				var checkArray = checkList.split('|');
				for(var k=checkArray.length-sheetObj.HeaderRows; k>=0; k--){
					if(sheetObj.cellvalue(checkArray[k],"cr_iss_no")==""){
						sheetObj.RowDelete(checkArray[k], false);
					}
				}
				var checkRow = sheetObj.FindCheckedRow('chk');
				if(validateForm(sheetObj, formObj, "REMOVE04")){
					if(checkRow!=""){
						formObj.f_cmd.value = REMOVE04;
						var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
				        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
				        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				        if (State != "S") {
				        	ComShowCodeMessage('COM12151',"Refrigerator Parts Credit Issue");
				        } else if (State == "S") {
				        	ComShowCodeMessage('COM12167',"Data");
				        	doActionIBSheet(sheetObj, formObj, "SEARCH04");
				        	sheetObjects[1].RemoveAll();
				        }
					}
				}
			break;
			
		    case REMOVE05: //M&R Credit Used Delete
				var checkList = sheetObj.FindCheckedRow('chk');
				var checkArray = checkList.split('|');
				for(var k=checkArray.length-sheetObj.HeaderRows; k>=0; k--){
					if(sheetObj.cellvalue(checkArray[k],"cr_usd_seq")==""){
						sheetObj.RowDelete(checkArray[k], false);
					}
				}
				
				sumOfEachUsing(sheetObj);
				
				var checkRow = sheetObj.FindCheckedRow('chk');
				if(validateForm(sheetObj, formObj, "REMOVE05")){
			    	if(checkRow!=""){
						formObj.f_cmd.value = REMOVE05;
						var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
				        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
				        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				        var cr_iss_no = sheetObj.cellvalue(sheetObj.SelectRow,"cr_iss_no");
				        var issSheetObj = sheetObjects[0];
				        var selRow ="";
				        if (State != "S") {
				        	ComShowCodeMessage('COM12151',"Refrigerator Parts Credit Used");
				        } else if (State == "S") {
				        	ComShowCodeMessage('COM12167',"Data");
				        	selRow = sheetObjects[0].SelectRow;
				        	doActionIBSheet(issSheetObj, formObj, "SEARCH04");
				        	issSheetObj.SelectCell(selRow,"cr_iss_no");
				        	sheetObj.DoSearch4Post("ESD_EAS_0501GS.do", "f_cmd="+SEARCHLIST05+"&str_cr_iss_no="+cr_iss_no);
				        }
			    	}
				}
			break;

		}
	}

	/**
	 * M&R Credit Issue Grid Double click event
	 */
	function sheet1_OnDblClick(sheetObj,row, col){
		var formObj = document.form;
		var sheetUsdObj = sheetObjects[1];
		var colName = sheetObj.ColSaveName(col);

		switch(colName){
			case('cr_iss_no'):
			case('rhq_cd'):
			case('team_cd'):
			case('mkr_cd'):
			case('cr_iss_dt'):
			case('curr_cd'):	
			case('cr_bal_amt'):	
			    var cr_iss_no = sheetObj.cellvalue(row,"cr_iss_no");
				if(cr_iss_no!=""){
					sheetUsdObj.RemoveAll();
					formObj.f_cmd.value = SEARCHLIST05;
					sheetUsdObj.DoSearch4Post("ESD_EAS_0501GS.do", FormQueryString(formObj)+"&str_cr_iss_no="+cr_iss_no);
				}
			break;	
		}
	}

  
  /**
   * Sheet5에서 OnChange 이벤트를 발생시킴.
   */
  function sheet2_OnChange (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  var crSumUsdAmt = 0;
	  var cr_usd_ofc_cd= "";
	  
	  //그리드 컬럼을 수정하면 chk컬럼 자동체크
//	  sheetObj.CellValue2(row,"chk") = "N";
	  var rowStatus =sheetObj.RowStatus(row);
	  if(rowStatus=="R"){
		   	sheetObj.CellValue2(row,"chk")= "N";
	   }else if(rowStatus=="I" || rowStatus=="U" ){
	   		sheetObj.CellValue2(row,"chk")= "Y";
	   }
	  
	  switch(colName){
		  case 'cr_usd_amt':
			  sumOfEachUsing(sheetObj);
	      break;
	      
		  case 'cr_usd_ofc_cd':	
			  cr_usd_ofc_cd = sheetObj.CellValue(row,"cr_usd_ofc_cd")
			  checkOfcCd(cr_usd_ofc_cd,row,0);
		  break;
	  }
  }
 
   /**
   * Sheet4에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  
	  switch(colName){
	  	case('atch_flg'):
			var atch_file_lnk_id = sheetObj.cellvalue(row,"atch_file_lnk_id");
	  	    var cr_iss_no = sheetObj.cellvalue(row,"cr_iss_no");
			var sParam = "cr_flg=Y&mdl_tp_cd=MNR&inv_no="+cr_iss_no+"&atch_file_lnk_id="+atch_file_lnk_id;
	
			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = formObj.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 
			
			if(atch_file_lnk_id !=""){
				sheetObj.cellvalue(row,"atch_flg") = "Y";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = atch_file_lnk_id;
			}else{	
				sheetObj.cellvalue(row,"atch_flg") = "N";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = "";
			}
			formObj.f_cmd.value = MODIFY04;
			var updParam = "cr_iss_no="+cr_iss_no+"&atch_file_lnk_id="+atch_file_lnk_id + "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", updParam);
	    break;   	
	  }
  }  
  
  /**
   * Sheet4에서 Popup 이벤트를 발생시킴.
   */
  function sheet2_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  
	  switch(colName){
	  	case('atch_flg'):
			var atch_file_lnk_id = sheetObj.cellvalue(row,"atch_file_lnk_id");
	  	    var cr_iss_no = sheetObj.cellvalue(row,"cr_iss_no");
	  	    var cr_usd_seq = sheetObj.cellvalue(row,"cr_usd_seq");
			var sParam = "cr_flg=Y&mdl_tp_cd=MNR&inv_no="+cr_iss_no+"&atch_file_lnk_id="+atch_file_lnk_id;
	
			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = formObj.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 
			
			if(atch_file_lnk_id !=""){
				sheetObj.cellvalue(row,"atch_flg") = "Y";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = atch_file_lnk_id;
			}else{	
				sheetObj.cellvalue(row,"atch_flg") = "N";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = "";
			}
			formObj.f_cmd.value = MODIFY09;
			var updParam = "cr_iss_no="+cr_iss_no+"&cr_usd_seq="+cr_usd_seq+"&atch_file_lnk_id="+atch_file_lnk_id + "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", updParam);
	    break;   	
	  }
  }  
  
 /**
   * Sheet4에서 OnChange 이벤트를 발생시킴.
   */
  function sheet1_OnChange (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  var ttl_qty = 0;
	  var team_cd= "";
	  
	  //그리드 컬럼을 수정하면 chk컬럼 자동체크
//	  sheetObj.CellValue2(row,"chk") = "N";
	  var rowStatus =sheetObj.RowStatus(row);
	  if(rowStatus=="R"){
		   	sheetObj.CellValue2(row,"chk")= "N";
	   }else if(rowStatus=="I" || rowStatus=="U" ){
	   		sheetObj.CellValue2(row,"chk")= "Y";
	   }
	  
	  switch(colName){
		  case 'cr_iss_ut_amt':	
		  case 'cr_iss_qty':	
	  		 sheetObj.CellValue(row,"cr_iss_ttl_amt") = Number(sheetObj.CellValue(row,'cr_iss_ut_amt'))* Number(sheetObj.CellValue(row,'cr_iss_qty'))
		  break;
	  		 
		  case 'team_cd':	
			  team_cd = sheetObj.CellValue(row,"team_cd")
			  checkOfcCd(team_cd,row,0);
		  break;
			  
	  }
  }	

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
    var formObj = document.form;
	var checkList = sheetObj.FindCheckedRow('chk');
	var checkArray = checkList.split('|');
	
	if(sheetObj.RowCount < 1){
		ComShowCodeMessage('COM130401');
		return false;		
	}
	
	if(checkList == '') {
		ComShowCodeMessage('COM12176');
		return false;
	}

	switch(sAction){
		case('MULTI04'): // SAVE M&R Credit Issue
			for(var i=0;i<checkArray.length-1;i++){
				if(sheetObj.cellvalue(checkArray[i],"rhq_cd")==""){
					ComShowCodeMessage('COM130201',"RHQ");
					sheetObj.SelectCell(checkArray[i],"rhq_cd");
					return false;					
				}else if(sheetObj.cellvalue(checkArray[i],"team_cd")==""){
					ComShowCodeMessage('COM130201',"TEAM");
					sheetObj.SelectCell(checkArray[i],"team_cd");
					return false;
				}else if(sheetObj.cellvalue(checkArray[i],"mkr_cd")==""){
					ComShowCodeMessage('COM130201',"Maker");
					sheetObj.SelectCell(checkArray[i],"mkr_cd");
					return false;
				}else if(sheetObj.cellvalue(checkArray[i],"cr_iss_dt")==""){
					ComShowCodeMessage('COM130201',"Issue Date");
					sheetObj.SelectCell(checkArray[i],"cr_iss_dt");
					return false;	
				}else if(sheetObj.cellvalue(checkArray[i],"curr_cd")==""){
					ComShowCodeMessage('COM130201',"Currency");
					sheetObj.SelectCell(checkArray[i],"curr_cd");
					return false;					
				}
			}
		break;
		case('MULTI05'): // SAVE M&R Credit Used
			for(var i=0;i<checkArray.length-1;i++){
				if(sheetObj.cellvalue(checkArray[i],"cr_usd_dt")==""){
					ComShowCodeMessage('COM130201',"Used date");
					sheetObj.SelectCell(checkArray[i],"cr_usd_dt");
					return false;					
				}else if(sheetObj.cellvalue(checkArray[i],"cr_usd_amt")==""){
					ComShowCodeMessage('COM130201',"Amount");
					sheetObj.SelectCell(checkArray[i],"cr_usd_amt");
					return false;
				}else if(Number(sheetObj.cellvalue(checkArray[i],"cr_usd_amt"))=="0"){
					ComShowCodeMessage('COM132201',"Amount");
					sheetObj.SelectCell(checkArray[i],"cr_usd_amt");
					return false;	
				}
			}
		break;
		case('REMOVE04'): // DELETE M&R Credit Issue
		break;
		
		case('REMOVE05'): // DELETE M&R Credit Used
		break;			
	
	 }
	return true;
}


///////////////////////////////////////////////////////////////////////////////
// 월 체크
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12  ) {
		return true;
	} else {
		return false;
	}
}

//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	        	ComKeyOnlyAlphabet('upper');
	        break;
	            
	        case "number":
	        	ComKeyOnlyNumber(obj);
	        break;
	    }
}
/**
* HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다. <br>
* 예를 들어 다음과 같이 사용한다.<br>
*     &lt;input type="text" name="txtAmt" <font color="red">onKeyPress="ComKeyOnlyNumber(this)"</font>&gt; <br>
* 인자로 사용되는 sSubChar 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.<br>
* <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
* <br><b>Example :</b>
* <pre>
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this)"&gt;
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-")"&gt;
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-.,")"&gt;
* </pre>
* @param {object} obj      필수,대상 HTML태그(Object)
* @param {string} sSubChar 선택,숫자이외의 부가 글자
* @returns 없음 <br>
* @see #ComKeyOnlyAlphabet
*/
function ComKeyOnlyNumberChk(obj,sSubChar){
   try {
       var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

       if(keyValue >= 48 && keyValue <= 57) {//숫자
           event.returnValue = true;

       } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
       	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
       	for(var i=0; i<sSubChar.length; i++) {
        		if (keyValue == sSubChar.charCodeAt(i)) {
	                event.returnValue = true;
	                return;
       		}
       	}
           event.returnValue = false;
       } else {
           event.returnValue = false;
       }
   } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * HTML Control의 onblur이벤트 처리<br>
 **/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name) {
		case "s_fm_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
		break;	
		case "s_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
		break;
	}
}

/**
 * HTML Control의 onfocus이벤트 처리<br>
 **/
function obj_focus(){
	var obj = event.srcElement;
	switch(obj.name) {	
	case "s_fm_dt":
		ComClearSeparator(obj);
		obj.select();
		break;	
	case "s_to_dt":
		ComClearSeparator(obj);
		obj.select();
		break;
	}
}
/**
 * HTML Control의 onChange이벤트 처리<br>
 **/
function obj_change(){
	var obj = event.srcElement;
	switch(obj.name) {
		case "s_fm_dt":
		case "s_to_dt":
			if(!ComChkObjValid(obj)){
				obj.value = "";
				obj.focus();
			};
		break;
		
		case "s_inv_vndr_seq":
			vender_change();
		break;
	}
} 	

//Combo관련 프로세스 처리
function doActionIBCombo(comboObj) {
	var sheetObj = sheetObjects[0];
	switch(comboObj.id) {
    	case "s_rhq_ofc_cd":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        formObj.s_inv_ofc_cd.RemoveAll();
	        ComXml2ComboItem(sXml, formObj.s_inv_ofc_cd, "ofc_cd", "ofc_cd");
	    	formObj.s_inv_ofc_cd.InsertItem(0, "", "");
	    	formObj.s_inv_ofc_cd.code2 = formObj.s_inv_ofc_cd.value
    	break;
	}
}

/**
 * function summaryMakerPopUp 호출
 */
function summaryMakerPopUp(){
	var formObj = document.form;
	var sParam = Array();
	
	sParam[0] = "s_fm_dt="+ formObj.s_fm_dt.value;
	sParam[1] = "s_to_dt="+ formObj.s_to_dt.value;
	sParam[2] = "s_mkr_cd="+ formObj.s_mkr_cd.value;
	sParam[3] = "s_cr_usd_ofc_cd="+ formObj.s_cr_usd_ofc_cd.value;
	
	var theURL = "ESD_EAS_0503.do?"+sParam.join("&");
   	var winName = "TotalStatusByMakerPopup";
   	var features = "scroll:no;status:no;resizable=yes;help:no;dialogWidth:450px;dialogHeight:400px";
   	ComOpenWindow(theURL,winName,features,true);
}
/**
 * M&R Credit Used Sum of each using 금액 합산.
 * 
 */
function sumOfEachUsing(sheetObj){
	var crSumUsdAmt = 0;
	var issSheetObj = sheetObjects[0];
	for(var i=0; i<sheetObj.RowCount;i++){
	  crSumUsdAmt = Number(crSumUsdAmt)+Number(sheetObj.CellValue(i+2,"cr_usd_amt"));
	  sheetObj.CellValue2(i+2,"cr_sum_usd_amt")= crSumUsdAmt;
	}
	
	issSheetObj.CellValue2(issSheetObj.SelectRow,"cr_sum_usd_amt") = crSumUsdAmt;
}


/**
 * 그리드 상의 RHQ Validation check
 * @param sheetObj
 * @param rhq_ofc_cd
 */
function checkRhqOfcCd(sheetObj,rhq_ofc_cd,row){
	if(rhq_ofc_cd !=""){
		sheetObj.DoRowSearch("ESD_EAS_0501GS.do","f_cmd="+SEARCH01+"&rhq_ofc_cd="+rhq_ofc_cd);
		var rtnVal = sheetObj.EtcData('rhq_ofc_cd');
		if(rtnVal !="" && rtnVal !=null && rtnVal != undefined){
			sheetObj.CellValue(row, "rhq_cd")  = sheetObj.EtcData('rhq_ofc_cd');
		}else{
			sheetObj.CellValue(row, "rhq_cd") = "";
		}
	}
}

/**
 * Grid에 입력된 Office Code에 대한 Validation
 * @param ofc_cd
 * @param row
 * @param sheetIdx
 */
function checkOfcCd(ofc_cd,row,sheetIdx){
	var sheetObj = sheetObjects[sheetIdx];
	if(ofc_cd !=""){
		sheetObj.DoRowSearch("ESD_EAS_0501GS.do","f_cmd="+SEARCH02+"&ofc_cd="+ofc_cd);
		
		var rtnVal = sheetObj.EtcData('ofc_cd');
		if(rtnVal !="" && rtnVal !=null && rtnVal != undefined){
			if(sheetIdx== "0"){
				sheetObj.CellValue(row, "team_cd")  = sheetObj.EtcData('ofc_cd');
			}else if(sheetIdx== "1"){	
				sheetObj.CellValue(row, "cr_usd_ofc_cd")  = sheetObj.EtcData('ofc_cd');
			}
		}else{
			if(sheetIdx== "0"){
				sheetObj.CellValue(row, "team_cd") = "";				
			}else if(sheetIdx== "1"){
				sheetObj.CellValue(row, "cr_usd_ofc_cd") = "";
			}
		}
	}
}
