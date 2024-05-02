/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0280.js
*@FileTitle : Fuel Surcharge (FUA) Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* History
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


function ESD_TRS_0280() {
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
var tabObjects       = new Array();
var tabCnt           = 0;
var beforetab        = 1;
var currenttab       = 0;

var sheetObjects 	= new Array();
var sheetCnt 	= 0;
var Mincount 	= 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];   //t1sheet1
	var sheetObject1 = sheetObjects[1];  //t2sheet1
	var tabObject = tabObjects[0];
	var formObj = document.form;

	/*******************************************************/	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
	
			case "btn_retrieve":
				if(tabObject.SelectedIndex > 0) {
					if(verifyButtonEvent(sheetObject,'retrieve')){
						//FUE Tab 조회
						doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					}
				} else {
					if(verifyButtonEvent(sheetObject1,'retrieve')){
						//FUA Tab 조회
						doActionIBSheet(sheetObject, formObj, IBSEARCH);
					}
				}
			break;

			case "btn_new":
				fn_reset();
			break;
					
			case "btng_loadexcel1":
				doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
			break;

			case "btng_loadexcel2":
				doActionIBSheet(sheetObject1,formObj,IBLOADEXCEL);
			break;

			case "btn_agmtno":
				openAgmtNo();
			break;
			
			case "btn_serviceprovider":
				rep_OnPopupClick();
			break;
			
			case 'btng_row_del1':
				if(verifyButtonEvent(sheetObject,'rowDel')){
					doActionIBSheet(sheetObject, formObj, IBDELETE, "");
				}
			break;

			case 'btng_row_del2':
				if(verifyButtonEvent(sheetObject1,'rowDel')){
					doActionIBSheet(sheetObject1, formObj, IBDELETE, "");
				}
			break;

			case 'btng_verify1':				
				if(verifyButtonEvent(sheetObject,'verify')){					
					verifyValCheck(sheetObject);
				}
			break;

			case 'btng_verify2':
				if(verifyButtonEvent(sheetObject1,'verify')){
					verifyValCheck(sheetObject1);
				}
			break;
			
			case 'btng_update1':
				if(verifyButtonEvent(sheetObject,'update')){
					fuelScgAgmtUpdate(sheetObject);
				}					
			break;

			case 'btng_update2':
				if(verifyButtonEvent(sheetObject1,'update')){
					fuelScgAgmtUpdate(sheetObject1);
				}					
			break;

			case 'btng_down_excel1':
				if(verifyButtonEvent(sheetObject,'downExcel')){
					sheetObject.Down2Excel(-1, false, false, true);
				}
			break;
			
			case 'btng_down_excel2':
				if(verifyButtonEvent(sheetObject1,'downExcel')){
					sheetObject1.Down2Excel(-1, false, false, true);
				}
			break;
			
			case 'btng_rate_history1':
				if(verifyButtonEvent(sheetObject,'rateHistory')){
					openRateHistory(sheetObject);
				}
			break;
			
			case 'btng_rate_history2':
				if(verifyButtonEvent(sheetObject1,'rateHistory')){
					openRateHistory(sheetObject1);
				}
			break;
			
			case 'btng_verify_rule1':
				openVerifyRull();
			break;
			
			case 'btng_verify_rule2':
				openVerifyRull();
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

//Button Event Validation Check
function verifyButtonEvent(sheetObj,btn_nm){
	var formObj = document.form;
	var rtnVal = true;
	
	if(btn_nm !="retrieve" && sheetObj.RowCount==0){
		ComShowCodeMessage('TRS90390');
		rtnVal = false;
	}
	
	switch(btn_nm) {
		case 'retrieve':
			var agmtno = formObj.fm_agmtno.value;
			var vndr_prmry_seq = formObj.fm_vndr_prmry_seq.value;
			var ctrt_ofc_cd = formObj.fm_ctrt_ofc_cd.value;
			
			//Agreement No 정합성 체크
			if (doengnumcheckNoMsg(agmtno) == false || doNumcheckNoMsg(agmtno.substring(3, agmtno.length)) == false) {
				errMsg = ComGetMsg("TRS90533");
				ComShowMessage(errMsg);
				formObj.fm_agmtno.focus();
				rtnVal = false;
			}

			if( agmtno == "" && vndr_prmry_seq == "" && ctrt_ofc_cd == "" ) { 
				errMsg = ComGetMsg("TRS90124");
				ComShowMessage(errMsg);
				formObj.fm_agmtno.focus();
				rtnVal = false;
			}

		break;
		
		case 'rowDel':
			var checkList 	= sheetObj.FindCheckedRow('chk');
			var checkArray	= checkList.split("|");	
			var authFlg 	= true;
			
			for(var i=0; i<checkArray.length-1; i++){
				if(authFlg){
					if(checkAuth(sheetObj, checkArray[i])== true){
						authFlg = true;
					}else if(checkAuth(sheetObj, checkArray[i])== false && sheetObj.RowStatus( checkArray[i]) == 'I'){
						//Office권한은 없지만 File import한 건은 Row 삭제처리 위해 true
						authFlg = true;
					}else{
						authFlg = false;
					}
				}
			}

			if(authFlg==false){
				errMsg = ComGetMsg("TRS90537");
				ComShowMessage(errMsg);
				rtnVal= false;
			}
				
			return 	rtnVal;	
		break;
		
		case 'verify':
			var checkList 	= sheetObj.FindCheckedRow('chk');
			var checkArray 	= checkList.split("|");
			var authFlg 	= true;

			for(var i=0; i<checkArray.length-1; i++){
				if(authFlg){
					authFlg = checkAuth(sheetObj, checkArray[i])
				}
			}

			if(authFlg==false){
				errMsg = ComGetMsg("TRS90537");
				ComShowMessage(errMsg);
				rtnVal= false;
			}
				
			return 	rtnVal;		
		break;
		
		case 'update':
			var checkList 	= sheetObj.FindCheckedRow('chk');
			var checkArray	= checkList.split("|");	
			var authFlg 	= true;
			for(var i=0; i<checkArray.length-1; i++){
				if(authFlg){
					authFlg = checkAuth(sheetObj, checkArray[i])
				}
			}

			if(authFlg==false){
				errMsg = ComGetMsg("TRS90537");
				ComShowMessage(errMsg);
				rtnVal= false;
			}
			
		break;
		
		case 'btng_rate_history':
			var checkList 	= sheetObj.FindCheckedRow('chk');
			var arrRow 		= checkList.split("|");	
		break;
	}
	
	return rtnVal;
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	var tabObject = tabObjects[0];
	
	switch(sAction) {

		case IBSEARCH:			
			if(tabObject.SelectedIndex > 0) {
				formObj.f_cmd.value = SEARCH03;
			} else {
				formObj.f_cmd.value = SEARCH01;
			}	
			sheetObj.DoSearch4Post("ESD_TRS_0280GS.do", TrsFrmQryString(formObj));
		break;

		case IBDELETE :
			if( sheetObj.CheckedRows("chk") < 1 ) {
				errMsg = ComGetMsg("TRS90036");
				ComShowMessage(errMsg);
				return false;
			} else {
				eq_delete_ui(sheetObj, "chk"); //DB에 저장되지 않은 ROW는 먼저 삭제처리한다.
				if( sheetObj.CheckedRows("chk") < 1 ) return false; //DB에 저장되지 않은 ROW는 삭제처리후 삭제 할 ROW가 없으면 더이상 이벤트를 실행하지 않는다.
				if(!confirm(ComGetMsg('COM12165', 'AGMT Surcharge')) ) return false;
				formObj.f_cmd.value = REMOVE01;
				sheetObj.DoSave("ESD_TRS_0280GS.do", TrsFrmQryString(formObj), "chk", false, true);
			}
		break;
		
		case IBLOADEXCEL:
		    var agmt_no = formObj.fm_agmtno.value;
			var ctrt_ofc_cd = formObj.fm_ctrt_ofc_cd.value;
			var trsp_scg_cd = 'FUA';
			if(tabObjects[0].SelectedIndex > 0) {
				trsp_scg_cd = 'FUE';
			} else {
				trsp_scg_cd = 'FUA';
			}
				
//			if(sheetObjects[0].RowCount == 0) {
//		 		ComShowCodeMessage('TRS90081');
//				return;
//			}
			
//			if(agmt_no !="" && ctrt_ofc_cd !=""){
				sheetObj.LoadExcel();				
				for(var i = sheetObj.RowCount + sheetObj.HeaderRows; i >= sheetObj.HeaderRows; i--){
					sheetObj.CellValue2(i, "trsp_scg_cd") = trsp_scg_cd;
					if(sheetObj.CellValue(i, "trsp_cost_mod_cd") == ""){
						sheetObj.RowDelete(i, false);
					}					
				}
//			}else{
//				ComShowCodeMessage('TRS90081');
//			}
			break;
	}
}

/**
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , "FUA" , -1 );
				InsertTab( cnt++ , "FUE" , -1 );
			}
		break;
	}
}
	
/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function tab1_OnChange(tabObj , nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
  tabObjects[tabCnt++] = tab_obj;
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
	for(k=0;k<tabObjects.length;k++) {
		initTab(tabObjects[k],k+1);
	}
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
	var formObj = document.form;
    axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
 }
	
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var sheetObject  = sheetObjects[0];   //t1sheet1
	var sheetObject1 = sheetObjects[1];   //t2sheet1
	var cnt = 0;

	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 365;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 20, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(80, 7, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle0 = "Sel|Container Verification Result|Container Verification Result|Duplication|Surcharge|AGMT\nType|AGMT NO|Service Provider|Service Provider|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip"
							   + "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size"
							   + "|Contract\nOffice||Update\nUser|Update\nOffice|Confirm\n(Manager Level)|Confirm\nUser|Total\nRate";
				var HeadTitle1 = "Sel|Status|Description|Duplication|Surcharge|AGMT\nType|AGMT NO|Code|Name|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip"
							   + "|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2|AL4|AL5|AL7|D2|D4|D5|D7|R2|R4|R5|R7|R8|R9|A2|A4|F2|F4|F5|T2|T4|S2|S4|O2|O4|O5|O7|P2|P4"
							   + "|Contract\nOffice||Update\nUser|Update\nOffice|Confirm\n(Manager Level)|Confirm\nUser|Total\nRate";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,    DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, 	CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox, 	40,   	daCenter,  	true,   "chk");
				InitDataProperty(0, cnt++ , dtStatus, 		50,   	daCenter,  	true,   "ibflag")
				InitDataProperty(0, cnt++ , dtData,      	120,  	daLeft,   	true,   "rlt",  				false,    	"",  		dfNone,     		0,      false,   	false,  	200,   	false,   	true,     	"",   	false);
				InitDataProperty(0, cnt++ , dtData,       	70,  	daLeft,   	true,   "rlt2",  				false,    	"",  		dfNone,     		0,      false,   	false,  	200,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,      	80,  	daCenter, 	true,   "trsp_scg_cd",  		false,    	"",  		dfNone,     		0,      false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,   		40,   	daCenter,  	true,   "trsp_agmt_rt_tp_cd",	false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daLeft,    	true,   "agmt_no",				false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,     	50,   	daCenter,  	true,   "vndr_seq",				false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,     	140,   	daLeft,  	true,   "vndr_nm",  			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,        	40,   	daCenter,  	true,   "trsp_cost_mod_cd",		false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtCombo,       	40,   	daCenter,  	true,   "agmt_trsp_tp_cd",		false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	40,  	daCenter, 	true,   "cgo_tp_cd",  			false,    	"",  		dfNone,     		0,      false,   	false,    	0,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	70,  	daCenter,  	true,   "cust_cd",  			false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	0,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	80,  	daCenter,  	true,   "cmdt_grp_cd",  		false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	0,   	false,   	true,     	"",   	false);
				InitDataProperty(0, cnt++ , dtCombo,       	80,   	daCenter,   true,   "rail_svc_tp_cd",		false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	70,   	daCenter,  	true,   "eff_fm_dt",			false,		"",			dfDateYmd,			0,      true,		true,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	70,   	daCenter,   true,   "eff_to_dt",			false,		"",			dfDateYmd,			0,      true,		true,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,        	60,   	daCenter,  	true,   "agmt_rout_all_flg",	false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,  	true,   "fm_nod_cd",  			false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       40,  	daCenter,  	true,   "fm_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,  	true,   "via_nod_cd", 	 		false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       40,  	daCenter,  	true,   "via_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,  	true,   "dor_nod_cd",  			false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       40,  	daCenter,  	true,   "dor_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,  	true,   "to_nod_cd",  			false,    	"",  		dfEngUpKey,			0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,       40,  	daCenter,  	true,   "to_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);

				InitDataProperty(0, cnt++ , dtCombo,      	60, 	daCenter,  	true,	"agmt_scg_rt_div_cd",	false,    	"",  		dfNone,     		0,      true,   	true,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCombo,      	70,  	daCenter,  	true,   "curr_cd",  			false,    	"",  		dfNone,     		0,   	true,   	true,   	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daRight,  	true,   "trsp_one_wy_rt",  		false,    	"",  		dfNullFloat,     	2,    	true,   	true,   	15,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daRight,  	true,   "trsp_rnd_rt",  		false,    	"",  		dfNullFloat,     	2,    	true,   	true,   	15,   	false,   	true,     	"",    	false);
				
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_alal",  			false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_dal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_ral",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_aal",  				false,   	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35, 	daCenter,  true,    "eq_fal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,    	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_tal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_sal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_oal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_pal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al2",  				false,    	"", 		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al4",  				false,    	"",  		dfNone,     		0,    	false,   	false,   	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r8",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r9",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_a2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_a4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_f2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_f4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_f5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_t2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_t4",  				false,    	"",  		dfNone,     		0,    	false,   	false,   	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_s2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_s4",  				false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,  	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,  	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_p2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_p4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				
				InitDataProperty(0, cnt++ , dtData,       	70,  	daCenter, 	true,   "ctrt_ofc_cd",  		false,    	"",  		dfNone,     		0,     	false,  	false,  	10,   	false,   	true,  		"", 	false);
				InitDataProperty(0, cnt++ , dtHidden,      	60,   	daLeft,   	true,   "upd_usr_id",			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	100,   	daLeft,   	true,   "upd_usr_nm",			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	60,   	daCenter,  	true,   "upd_ofc_cd",			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,       80,   	daLeft,    	true,   "trsp_agmt_ofc_cty_cd",	false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,       80,   	daLeft,    	true,   "trsp_agmt_seq",		false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "org_eqtype",  			false,    	"",  		dfNone,     		0,    	true,   	true,    	8,  	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "eq_knd_cd",  			false,    	"",  		dfNone,     		0,    	false,   	false,    	8,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "to_wgt",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	9,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "wgt_meas_ut_cd",  		false,    	"",  		dfNone,     		0,    	false,   	false,    	3,   	false,   	true,     	"",    	false);
//				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "trsp_scg_cd",  		false,    	"",  		dfNone,     		0,    	false,   	false,    	3,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtDataSeq,		50,  	daCenter,  	true,   "ui_seqno",  			false,    	"",  		dfNone,     		0,    	true,   	true,    	8,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	60,  	daCenter,  	true,   "ck_vf",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	8,   	false,   	true,     	"",    	false);

				InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
				InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
				InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
				InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
				InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE|VAT|TOL", "FUA|FUE|VAT|TOL");
				sheetObj.ColHidden("ck_vf") = true;
				sheetObj.ColHidden("ui_seqno") = true;
				document.form.header_row.value = HeaderRows-1;
				
				}
			break;
		case 2:      //t2sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 365;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 20, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(80, 7, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle0 = "Sel|Container Verification Result|Container Verification Result|Duplication|Surcharge|AGMT\nType|AGMT NO|Service Provider|Service Provider|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip"
							   + "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size"
							   + "|Contract\nOffice||Update\nUser|Update\nOffice|Confirm\n(Manager Level)|Confirm\nUser|Total\nRate";
				var HeadTitle1 = "Sel|Status|Description|Duplication|Surcharge|AGMT\nType|AGMT NO|Code|Name|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip"
							   + "|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2|AL4|AL5|AL7|D2|D4|D5|D7|R2|R4|R5|R7|R8|R9|A2|A4|F2|F4|F5|T2|T4|S2|S4|O2|O4|O5|O7|P2|P4"
							   + "|Contract\nOffice||Update\nUser|Update\nOffice|Confirm\n(Manager Level)|Confirm\nUser|Total\nRate";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,    DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, 	CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox, 	40,   	daCenter,  	true,   "chk");
				InitDataProperty(0, cnt++ , dtStatus, 		50,   	daCenter,  	true,   "ibflag")
				InitDataProperty(0, cnt++ , dtData,      	120,  	daLeft,   	true,   "rlt",  				false,    	"",  		dfNone,     		0,      false,   	false,  	200,   	false,   	true,     	"",   	false);
				InitDataProperty(0, cnt++ , dtData,       	70,  	daLeft,   	true,   "rlt2",  				false,    	"",  		dfNone,     		0,      false,   	false,  	200,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,      	80,  	daCenter, 	true,   "trsp_scg_cd",  		false,    	"",  		dfNone,     		0,      false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,   		40,   	daCenter,  	true,   "trsp_agmt_rt_tp_cd",	false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daLeft,    	true,   "agmt_no",				false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,     	50,   	daCenter,  	true,   "vndr_seq",				false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,     	140,   	daLeft,  	true,   "vndr_nm",  			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,        	40,   	daCenter,  	true,   "trsp_cost_mod_cd",		false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtCombo,       	40,   	daCenter,  	true,   "agmt_trsp_tp_cd",		false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	40,  	daCenter, 	true,   "cgo_tp_cd",  			false,    	"",  		dfNone,     		0,      false,   	false,    	0,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	70,  	daCenter,  	true,   "cust_cd",  			false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	0,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	80,  	daCenter,  	true,   "cmdt_grp_cd",  		false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	0,   	false,   	true,     	"",   	false);
				InitDataProperty(0, cnt++ , dtCombo,       	80,   	daCenter,   true,   "rail_svc_tp_cd",		false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	70,   	daCenter,  	true,   "eff_fm_dt",			false,		"",			dfDateYmd,			0,      true,		true,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	70,   	daCenter,   true,   "eff_to_dt",			false,		"",			dfDateYmd,			0,      true,		true,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,        	60,   	daCenter,  	true,   "agmt_rout_all_flg",	false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,    		50,  	daCenter,  	true,   "fm_nod_cd",  			false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,  	true,   "fm_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,  	true,   "via_nod_cd", 	 		false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,  	true,   "via_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,  	true,   "dor_nod_cd",  			false,    	"",  		dfEngUpKey, 		0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,  	true,   "dor_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,  	true,   "to_nod_cd",  			false,    	"",  		dfEngUpKey,			0,    	false,  	false,    	5,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,  	true,   "to_nod_yd",  			false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);

				InitDataProperty(0, cnt++ , dtCombo,      	60, 	daCenter,  	true,	"agmt_scg_rt_div_cd",	false,    	"",  		dfNone,     		0,      true,   	true,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCombo,      	70,  	daCenter,  	true,   "curr_cd",  			false,    	"",  		dfNone,     		0,   	true,   	true,   	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daRight,  	true,   "trsp_one_wy_rt",  		false,    	"",  		dfNullFloat,     	2,    	true,   	true,   	15,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daRight,  	true,   "trsp_rnd_rt",  		false,    	"",  		dfNullFloat,     	2,    	true,   	true,   	15,   	false,   	true,     	"",    	false);
				
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_alal",  			false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_dal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_ral",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_aal",  				false,   	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35, 	daCenter,  true,    "eq_fal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,    	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_tal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_sal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_oal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_pal",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al2",  				false,    	"", 		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al4",  				false,    	"",  		dfNone,     		0,    	false,   	false,   	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	35,  	daCenter,  true,    "eq_al7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_d7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r8",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_r9",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_a2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_a4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_f2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_f4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_f5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_t2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_t4",  				false,    	"",  		dfNone,     		0,    	false,   	false,   	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_s2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_s4",  				false,    	"",  		dfNone,     		0,    	false,  	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o5",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,  	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_o7",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,  	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_p2",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	25,  	daCenter,  true,    "eq_p4",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	2,   	false,   	true,     	"",    	false);
				
				InitDataProperty(0, cnt++ , dtData,       	70,  	daCenter, 	true,   "ctrt_ofc_cd",  		false,    	"",  		dfNone,     		0,     	false,  	false,  	10,   	false,   	true,  		"", 	false);
				InitDataProperty(0, cnt++ , dtHidden,      	60,   	daLeft,   	true,   "upd_usr_id",			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	100,   	daLeft,   	true,   "upd_usr_nm",			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtData,      	60,   	daCenter,  	true,   "upd_ofc_cd",			false,		"",			dfNone,				0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,       80,   	daLeft,    	true,   "trsp_agmt_ofc_cty_cd",	false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,       80,   	daLeft,    	true,   "trsp_agmt_seq",		false,		"",			dfNone,         	0,      false,		false,		0,		false,		true,	   	"",	  	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "org_eqtype",  			false,    	"",  		dfNone,     		0,    	true,   	true,    	8,  	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "eq_knd_cd",  			false,    	"",  		dfNone,     		0,    	false,   	false,    	8,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "to_wgt",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	9,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "wgt_meas_ut_cd",  		false,    	"",  		dfNone,     		0,    	false,   	false,    	3,   	false,   	true,     	"",    	false);
//				InitDataProperty(0, cnt++ , dtHidden,    	150,  	daCenter,  	true,   "trsp_scg_cd",  		false,    	"",  		dfNone,     		0,    	false,   	false,    	3,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtDataSeq,		50,  	daCenter,  	true,   "ui_seqno",  			false,    	"",  		dfNone,     		0,    	true,   	true,    	8,   	false,   	true,     	"",    	false);
				InitDataProperty(0, cnt++ , dtCheckBox,   	60,  	daCenter,  	true,   "ck_vf",  				false,    	"",  		dfNone,     		0,    	false,   	false,    	8,   	false,   	true,     	"",    	false);

				InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
				InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
				InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
				InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
				InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE|VAT|TOL", "FUA|FUE|VAT|TOL");
				sheetObj.ColHidden("ck_vf") = true;
				sheetObj.ColHidden("ui_seqno") = true;
				document.form.header_row.value = HeaderRows-1;
				
				}
			break;
	
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function t1sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		
	} 
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	eq_SaveEnd(sheetObj, errMsg);
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function t2sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		
	} 
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
	eq_SaveEnd(sheetObj, errMsg);
}

/**
 * 저장후 발생하는 이벤트를 처리
 */
function eq_SaveEnd(sheetObj, errMsg) {
   if( errMsg.length > 0 ) {
	   ComShowMessage(errMsg);
   } else {
	   if( document.form.f_cmd.value == REMOVE01 ) {
		   eq_delete(sheetObj, "chk"); //삭제하는 함수
		   errMsg = ComGetMsg("TRS90331");
		   ComShowMessage(errMsg);
	   }else if( document.form.f_cmd.value == MULTI01 ) {
		   for(var k=sheetObj.HeaderRows; k<sheetObj.RowCount+sheetObj.HeaderRows; k++) {
			   sheetObj.CellValue2(k, "org_eqtype") = "";
			   sheetObj.RowStatus(k) = "R";
		   }
	   }
   }
}


/**
 * SHEET의 값이 변경되었을 때 발생하는 EVENT
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function t1sheet1_OnChange(sheetObj, row , col , value) {
	eq_OnChange(sheetObj, row , col , value);
    if (sheetObj.RowStatus(row) != 'I' && sheetObj.ColSaveName(col) != "chk") { //chk 비교는 Check 박스 전체체크시 조건 비교자체를 하지 않게 하기 위해 IF문 처리(체크박스 체크시 속도에만 영향)
		var org_eqtype = sheetObj.CellValue(row, "org_eqtype");
		if (org_eqtype.length > 1) org_eqtype = "," + org_eqtype ;
		if( sheetObj.ColSaveName(col) == "eq_d2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_d4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_d5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_d7" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D7', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r7" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R7', '');
			}	
		}else if( sheetObj.ColSaveName(col) == "eq_r8" ) { // 2013.06.26 Add
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R8";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R8', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r9" ) {	// 2011.06.24 추가 [CHM-201111442-01]
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R9";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R9', '');
			}	
		}else if( sheetObj.ColSaveName(col) == "eq_a2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",A2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',A2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_a4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",A4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',A4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_f2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",F2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',F2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_f4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",F4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',F4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_f5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",F5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',F5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_t2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",T2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',T2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_t4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",T4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',T4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_s2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",S2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',S2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_s4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",S4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',S4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o5" ) { //2012.10.15 추가 [CHM-201220540]
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o7" ) { //2018.05.08 추가 [CSR #3841]
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O7', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_p2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",P2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',P2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_p4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",P4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',P4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_alal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",ALAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',ALAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_dal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",DAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',DAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_ral" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",RAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',RAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_aal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_fal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",FAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',FAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_tal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",TAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',TAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_sal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",SAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',SAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_oal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",OAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',OAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_pal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",PAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',PAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al7" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL7', '');
			}
		}
		
		var after_org_eqtype = sheetObj.CellValue(row, "org_eqtype");
		if (after_org_eqtype.length > 1 && after_org_eqtype.substring(0,1) == ",")
			sheetObj.CellValue2(row, "org_eqtype") = sheetObj.CellValue(row, "org_eqtype").substring(1,100); 
	}
}

/**
 * SHEET의 값이 변경되었을 때 발생하는 EVENT
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function t2sheet1_OnChange(sheetObj, row , col , value) {
	eq_OnChange(sheetObj, row , col , value);
    if (sheetObj.RowStatus(row) != 'I' && sheetObj.ColSaveName(col) != "chk") { //chk 비교는 Check 박스 전체체크시 조건 비교자체를 하지 않게 하기 위해 IF문 처리(체크박스 체크시 속도에만 영향)
		var org_eqtype = sheetObj.CellValue(row, "org_eqtype");
		if (org_eqtype.length > 1) org_eqtype = "," + org_eqtype ;
		if( sheetObj.ColSaveName(col) == "eq_d2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_d4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_d5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_d7" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",D7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',D7', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r7" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R7', '');
			}	
		}else if( sheetObj.ColSaveName(col) == "eq_r8" ) { // 2013.06.26 Add
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R8";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R8', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_r9" ) {	// 2011.06.24 추가 [CHM-201111442-01]
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",R9";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',R9', '');
			}	
		}else if( sheetObj.ColSaveName(col) == "eq_a2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",A2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',A2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_a4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",A4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',A4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_f2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",F2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',F2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_f4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",F4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',F4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_f5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",F5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',F5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_t2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",T2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',T2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_t4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",T4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',T4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_s2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",S2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',S2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_s4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",S4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',S4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o5" ) { //2012.10.15 추가 [CHM-201220540]
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_o7" ) { //2018.05.08 추가 [CSR #3841]
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",O7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',O7', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_p2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",P2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',P2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_p4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",P4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',P4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_alal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",ALAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',ALAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_dal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",DAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',DAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_ral" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",RAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',RAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_aal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_fal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",FAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',FAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_tal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",TAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',TAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_sal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",SAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',SAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_oal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",OAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',OAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_pal" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",PAL";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',PAL', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al2" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL2";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL2', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al4" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL4";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL4', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al5" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL5";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL5', '');
			}
		}else if( sheetObj.ColSaveName(col) == "eq_al7" ) {
			if (value == ""){
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype + ",AL7";
			}else{
				sheetObj.CellValue2(row, "org_eqtype") = org_eqtype.replace(',AL7', '');
			}
		}
		
		var after_org_eqtype = sheetObj.CellValue(row, "org_eqtype");
		if (after_org_eqtype.length > 1 && after_org_eqtype.substring(0,1) == ",")
			sheetObj.CellValue2(row, "org_eqtype") = sheetObj.CellValue(row, "org_eqtype").substring(1,100); 
	}
}

/**
 * Sheet에서 값이 변경되었을 경우 발생하는 Event
 */
function eq_OnChange(sheetObj, row , col , value) {
	 //Node변경 조건을 chk가 아닌 경우에 포함시킨 이유는 체크박스 전체 체크시 IF문 비교 자체를 타지 않게하여 체크속도를 높이기 위해서 입니다.
	 if( sheetObj.ColSaveName(col) != "chk" ) {
		 sheetObj.CellValue2(row,'chk') = 1;
		 sheetObj.CellValue2(row,'ck_vf') = 1;
		 sheetObj.CellValue2(row,'rlt') = "";
	 }
}

/**
 * Container Verify 체크
 */
 function verifyValCheck(sheetObj){
	   var formObj = document.form;
	   var idNum = '1';
	   if(tabObjects[0].SelectedIndex > 0) {
		   idNum = '2';		   
	   } else {
		   idNum = '1';		   
	   }
	   //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
	   if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
		   document.getElementById('verify_result_str' + idNum).value="Collect data is being precessed. Please wait.";
		   ComOpenWait(true);		   
		   document.getElementById('btng_verify' + idNum).disabled = false;		   
		   formObj.f_cmd.value   = SEARCH02;
		   //verify가 완료되면 ck_vf의 값은 '1' -> '0'로 변경된다.
		   var check_row = sheetObj.CheckedRows('chk');
		   if(check_row == '')  {
			   ComOpenWait(false);
			   ComShowCodeMessage('TRS90386', 'No Target Data!');
			   return;
		   }
		   var queryStr = sheetObj.GetSaveString(false, true, "chk");

		   document.getElementById('verify_result_str' + idNum).value="Verify is being processed. Please wait.";
		   sheetObj.DoRowSearch("ESD_TRS_0280GS.do", TrsFrmQryString(formObj)+'&'+queryStr,false);
		   document.getElementById('verify_result' + idNum).value = sheetObj.EtcData('err_cnt2');
		   document.getElementById('verify_check_yn' + idNum).value="Y";
		   ComOpenWait(false);//레이어형 대기 이미지 표시
		   if(document.getElementById('verify_result' + idNum).value>0 ){
			   document.getElementById('verify_result_str' + idNum).value="There are 'Verify Error.'";
			   document.getElementById('btng_verify' + idNum).disabled = false;
		   }else{
			   document.getElementById('message' + idNum).value ="";
			   document.getElementById('verify_result_str' + idNum).value="Verify are done. Please click on the 'Update' button to save.";
		   }
	   }else{
		   ComShowMessage('Only 5000 rows or less could be imported at a time.');
	   }
 }

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){
	var formObj = document.form;	

	if(tabObjects[0].SelectedIndex > 0) {
		sheetObjects[1].RemoveAll();
	} else {
		sheetObjects[0].RemoveAll();
	}
	
	formObj.fm_agmtno.value 			= "";
	formObj.fm_vndr_prmry_seq.value 	= "";
	formObj.fm_vndr_prmry_nm.value 		= "";
	formObj.fm_ctrt_ofc_cd.value 		= "";
	formObj.chk_office.checked 			= false;
	formObj.fm_effective_agmt.value 	= "C";
	formObj.fm_trsp_cost_mod_cd.value 	= "A";
	formObj.fm_agmt_trsp_tp_cd.value 	= "";
}	

/**
* enter check
**/
function enterCheck(obj)
{
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'combo_svc_provider':
				if(tabObjects[0].SelectedIndex > 0) {
					getTextVendorSeq(sheetObject1, formObj, obj.value);
				} else {
					getTextVendorSeq(sheetObject, formObj, obj.value);
				}				
			break;
		}
	}
}

function obj_keypress(){
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;

    switch(obj.dataformat) {
        case "engup":
        	ComKeyOnlyAlphabet('uppernum');
		break;
        
        case "num":
			ComKeyOnlyNumber(obj);
        break;    
    }
}


//Include Check Bok를 Click했을 때
function getSubOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.fm_ctrt_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.fm_ctrt_ofc_cd.value = "";
		ComShowMessage("Please input the 'Contract Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0221GS.do?f_cmd="+SEARCH07+"&fm_ctrt_ofc_cd="+prm_office;
		document.form.fm_old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.fm_ctrt_ofc_cd.value = document.form.fm_old_ofc_cd.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.fm_ctrt_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}
//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

/**
 * Fuel Surcharge Agmt Update
 * @param sheetObj
 */
function fuelScgAgmtUpdate(sheetObj){
	  var formObj      	  = document.form;
  	  var sheet2_count    = sheetObj.RowCount;
  	  var check_verify    = sheetObj.CheckedRows('ck_vf');
  	  var check_result    = false;
      var idNum = '1';
	  if(tabObjects[0].SelectedIndex > 0) {
		  idNum = '2';
	  } else {
		  idNum = '1';
	  }
   
  	  for(var k=sheetObj.HeaderRows; k<sheet2_count+sheetObj.HeaderRows; k++){
  		  if (sheetObj.RowStatus(k) != 'R') {
  		      if(sheetObj.CellValue(k, 'rlt') !='OK' ) check_result    = true;
  		  }
  	  }
  	  
  	  if(check_verify > 0 || check_result){
  		  ComShowCodeMessage('TRS90039')
  		  document.getElementById('verify_result_str' + idNum).value="Please click on the 'Verify' button.";
  		  return false;
  	  }
  	  
//  	  var y1 = formObj.fm_agmtno.value;
  	  document.getElementById('message' + idNum).value = "S";
   	  
  	  var verify_2 = document.getElementById('verify_result' + idNum).value;
  	  var verify_3 = document.getElementById('verify_check_yn' + idNum).value;
 
  	  document.getElementById('total_rows_cnt' + idNum).value = sheetObj.RowCount;
 	  
  	  if(sheet2_count >0){
  		  if(verify_2 == 0 && verify_3 == "Y"){

  			  formObj.f_cmd.value   = MULTI01;
  			  sheetObj.DoSave("ESD_TRS_0280GS.do", TrsFrmQryString(formObj), "ibflag", false, true);

  			  if(document.getElementById('message' + idNum).value == "V"){
  			  }else if(document.getElementById('message' + idNum).value == "S"){
  				  document.getElementById('updated_rows_cnt' + idNum).value = document.getElementById('total_rows_cnt' + idNum).value;
  				  document.getElementById('verify_result_str' + idNum).value = "Saving has been completed.";
  			  }
  			  document.getElementById('message' + idNum).value = "";
  		  }else{
  			  ComShowCodeMessage('TRS90039');
  		  }
  	  }	
}

/**
 * Verify Rule 팝업
 */
function openVerifyRull() {
	var formObj = document.form;
	var Option = "width=680,height=700,menubar=0,status=0,scrollbars=3,resizable=0";
	
	window.open('apps/alps/esd/trs/agreementmanage/agreementmanage/html/pair_verify_rule.htm', "popupHelpP", Option);
	
}

/**
 * Rate History PopUp Open
 * @param sheetObj
 */
function openRateHistory(sheetObj){
	 var formObj = document.form;
	 var checkList = sheetObj.FindCheckedRow('chk');
	 var checkArray = checkList.split('|');
	 var resultcheck = 0;
     var chk_trsp_scg_cd = 'FUA';
     if(tabObjects[0].SelectedIndex > 0) {
    	 chk_trsp_scg_cd = 'FUE';
     } else {
    	 chk_trsp_scg_cd = 'FUA';
     }

	 if(checkList.length < 1) {
		 ComShowCodeMessage('TRS90215'); 
		 return;
	 }

	 var agmt_no 			= sheetObj.CellValue(checkArray[0], 'agmt_no');
	 var trsp_agmt_rt_tp_cd	= sheetObj.CellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
	 var trsp_cost_mod_cd 	= sheetObj.CellValue(checkArray[0], 'trsp_cost_mod_cd');
	 var agmt_trsp_tp_cd  	= sheetObj.CellValue(checkArray[0], 'agmt_trsp_tp_cd'); //최초 데이타생성한 ofc
	 var cgo_tp_cd 			= sheetObj.CellValue(checkArray[0], 'cgo_tp_cd');
	 var cust_cd     		= sheetObj.CellValue(checkArray[0], 'cust_cd');
	 var cmdt_grp_cd 		= sheetObj.CellValue(checkArray[0], 'cmdt_grp_cd');
	 var rail_svc_tp_cd 	= sheetObj.CellValue(checkArray[0], 'rail_svc_tp_cd');
	 var fm_nod_cd 			= sheetObj.CellValue(checkArray[0], 'fm_nod_cd');
	 var fm_nod_yd 			= sheetObj.CellValue(checkArray[0], 'fm_nod_yd');
	 var via_nod_cd 		= sheetObj.CellValue(checkArray[0], 'via_nod_cd');
	 var via_nod_yd 		= sheetObj.CellValue(checkArray[0], 'via_nod_yd');
	 var dor_nod_cd 		= sheetObj.CellValue(checkArray[0], 'dor_nod_cd');
	 var dor_nod_yd 		= sheetObj.CellValue(checkArray[0], 'dor_nod_yd');
	 var to_nod_cd  		= sheetObj.CellValue(checkArray[0], 'to_nod_cd');
	 var to_nod_yd  		= sheetObj.CellValue(checkArray[0], 'to_nod_yd');
	 var agmt_route_all_flg = sheetObj.CellValue(checkArray[0], 'agmt_route_all_flg');

	 if(checkArray.length > 1){
		 resultcheck = 1;
		 for(var i=0; i<checkArray.length-1; i++){
			 if(sheetObj.CellValue(checkArray[0], 'trsp_cost_mod_cd') == sheetObj.CellValue(checkArray[i], 'trsp_cost_mod_cd')){                
			 }else{
				 resultcheck++;
			 }
		 }
	 }
	 if(resultcheck == 1){
		 var myOption = "width=980,height=530,menubar=0,status=0,scrollbars=0,resizable=0";
		 var param = "?gubun=save"
			 	   + "&fm_agmtno="+agmt_no
			 	   + "&fm_trsp_agmt_rt_tp_cd="+trsp_agmt_rt_tp_cd
				   + "&chk_agmt_trsp_tp_cd="+agmt_trsp_tp_cd
			       + "&chk_trsp_cost_mod_cd="+trsp_cost_mod_cd
				   + "&chk_cgo_tp_cd="+cgo_tp_cd
				   + "&chk_cust_cd="+cust_cd
				   + "&chk_cmdt_grp_cd="+cmdt_grp_cd
				   + "&chk_rail_svc_tp_cd="+rail_svc_tp_cd
				   + "&chk_fm_nod_cd="+fm_nod_cd
				   + "&chk_fm_nod_yd="+fm_nod_yd
				   + "&chk_via_nod_cd="+via_nod_cd
				   + "&chk_via_nod_yd="+via_nod_yd
				   + "&chk_dor_nod_cd="+dor_nod_cd
				   + "&chk_dor_nod_yd="+dor_nod_yd
				   + "&chk_to_nod_cd="+to_nod_cd
				   + "&chk_to_nod_yd="+to_nod_yd
				   + "&chk_trsp_scg_cd="+chk_trsp_scg_cd
				   + "&chk_agmt_route_all_flg="+agmt_route_all_flg
				   ;

		 myWin = window.open('/hanjin/ESD_TRS_0230.do' + param, "Hispopup", myOption);  		
	 }else if(resultcheck == 0){
		 ComShowCodeMessage('TRS90215');
	 }else if(resultcheck > 1){
		 ComShowCodeMessage('TRS90357');
	 }
}

/*
 * 체크해서 넘긴 데이터를 그리드 상에서 삭제한다. (UI에서 신규로 입력후 저장하지 않은 데이타만 삭제)
 */
function eq_delete_ui(fromSheet, sStatus) {
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		if (fromSheet.CellValue(fromRow,"ibflag") == 'I') {
		    fromSheet.RowDelete(fromRow, false);
		}
	}
}


/**
 * 로그인 오피스로 해당 오피스의 상위/하위 오피스 리스트를 조회하여 화면에서 넘겨 받은 Contract Office 코드와 일치하는 오피스가 있을 경우에만 등록/수정가 가능하도록 체크
 */
function checkAuth(sheetObj, checkedRow) {
	var formObj = document.form;
	var ctrt_ofc_cd = sheetObj.CellValue(checkedRow, 'ctrt_ofc_cd');
	var auth_chk = false;

	formObj.f_cmd.value = SEARCH08;
	var sXml = sheetObj.GetSearchXml("ESD_TRS_0221GS.do", FormQueryString(formObj));
	var arrXml = sXml.split("|$$|");
	
	if( ComGetTotalRows(sXml) > 0 ) {
		var list = TrsXmlToListMap(arrXml);
		for(var i=0; i<list.length; i++) {
			if(ctrt_ofc_cd == list[i]['ofc_cd'])
				auth_chk = true;
		}
	}

	return auth_chk;
}

/*
* Agreement No조회 팝업 Open
*/
function openAgmtNo() {
	var formObj = document.form;
	var Option = "width=700,height=400,menubar=0,status=0,scrollbars=0,resizable=0";
	var agmt_no = formObj.fm_agmtno.value;   
	var param ="?agmt_no="+agmt_no;
	window.open('/hanjin/ESD_TRS_0233.do' + param, "popup", Option);
}

/*
* Agreement No조회 팝업에서  Agreement No를 리턴받는 함수
*/
function getAgmtNo( value, vndr_seq, vndr_nm, row ){
	var formObj = document.form;
	formObj.fm_agmtno.value = value;
}

/**
* S/P 정보를 조회
*/
function  vender_blur(){
	var formObj = document.form;
	var vndr_prmry_seq = formObj.fm_vndr_prmry_seq.value;
	if(vndr_prmry_seq !=""){		
		if(tabObjects[0].SelectedIndex > 0) {
			formObj.t2sheet1.RemoveEtcData();
		} else {
			formObj.t1sheet1.RemoveEtcData();
		}
		formObj.f_cmd.value = SEARCH07;		
		var vndr_nm = "";
		if(tabObjects[0].SelectedIndex > 0) {
			sheetObjects[1].DoRowSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
			vndr_nm  = formObj.t2sheet1.EtcData('VNDR_NM');
		} else {
			sheetObjects[0].DoRowSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
			vndr_nm  = formObj.t1sheet1.EtcData('VNDR_NM');
		}
		if(vndr_nm !="" && vndr_nm != undefined){ //
			formObj.fm_vndr_prmry_nm.value = vndr_nm;
		}else{
			formObj.fm_vndr_prmry_seq.value = "";
			formObj.fm_vndr_prmry_nm.value = "";
		}
	}
}

/*
 * rep_commodity팝업호출
 */
function rep_OnPopupClick() {
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
	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* Service Provider 팝업호출 : 팝업에서 단일 선택을 한경우..
*/
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];
		formObj.fm_vndr_prmry_seq.value =colArray2;
		formObj.fm_vndr_prmry_nm.value =colArray4;
	}
}

/**
* Service Provider 팝업에서 Return
*/
function vndr_OnPopupClick()
{
	var formObject = document.form;
	var check_vndr= formObject.fm_hjscnt.value;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_vndr";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	
	if(check_vndr=="CNT"){
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 772, 419, 'getCOM_ENS_vndr', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
}
/*
 * 체크해서 넘긴 데이터를 그리드 상에서 삭제한다.
 */
function eq_delete(fromSheet, sStatus) {
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
}