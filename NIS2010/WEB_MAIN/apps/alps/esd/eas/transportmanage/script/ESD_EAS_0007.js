/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0007.js
*@FileTitle : Drop Off Charge Tariff List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-15
*@LastModifier : HoSam_Lee
*@LastVersion : 1.0
* 2008-01-15 HoSam_Lee
* 1.0 최초 생성
* 2011-09-23 yong kim
* =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0007 : 예)Drop Off Charge Tariff List 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0007() {
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

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var shtObj = null ;
	var sheetrow = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
	 var sheetObject = sheetObjects[0];
	 /******************************************************/
	 var formObject = document.form;
		
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "bttn_addloc":
				   doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			case "bttn_addts":
				   doActionIBSheet(sheetObject,formObject,IBCOPYROW);
				break;					
			case "bttn_save":
				//zu_openRunning(false); //레이어형 대기 이미지 표시
				sheetObject.WaitImageVisible = false;
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			//case "bttn_remove":
			//	doActionIBSheet(sheetObject,formObject,IBDELETE);
			//	break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case 'btn_customer':
				popCustomer();
				break;
            case "cnt_btn":         
            	with(formObject)
            	{    	    
            	    var v_cnt_cd = sel_cnt_cd.value;
            	    var classId = "COM_ENS_0M1";
        		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
        		    var v_display = "1,0,1,1,1,0,0";
        		    var chkStr = v_display.substring(0,3)
        		  
        		    if(chkStr == "1,0") {
        		    	ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCOM_ENS_0M1_1', v_display, true);
        		    } else {
        			    return;
        		    }
            	}
			break;
    	    case "btn_loadexcel":
    	        doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
  	        break;

		} // end switch
		
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("COM12111" );
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
	
	//fun_getEUROffcd();		
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
	 * BKG Creation manual <br>
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
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = GetSheetHeight(15) ;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "Del.|Sts.|Eff_dt|Loc|Customer|Origin|T/S|Currency|Amount|User ID|Remark|Cre_Offce";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtDelCheck,     40,    daCenter, false,    "r_chk",		      false,          "",       dfNone,    0,     true,     true);
                    InitDataProperty(0, cnt++, dtStatus, 30,    daCenter, false,    "ibflag",		      false,          "",       dfNone,    0,     false,   false);					
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "effdt",            false,          "",       dfNone,    0,     false,   false);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "fm_loc_cd",         true,          "",       dfEngUpKey,0,     false,    true,   5);
					InitDataProperty(0, cnt++, dtPopupEdit,   100,    daCenter, false,    "cust_info",        false,          "",       dfEngUpKey,0,     false,    true,   8);					
					InitDataProperty(0, cnt++, dtCombo,       100,    daCenter, false,    "conti_cd",         false,          "",       dfNone,    0,     true,     true);
					InitDataProperty(0, cnt++, dtData,         50,    daCenter, false,    "cntr_tp_cd",		   true,          "",       dfEngUpKey,0,     false,    true,   2);
					InitDataProperty(0, cnt++, dtData,         90,    daCenter, false,    "curr_cd",           true,          "",       dfEngUpKey,0,     false,    true,   3);
					InitDataProperty(0, cnt++, dtData,         90,    daRight,  false,    "chrr_frt_tax_val", false,          "",       dfNumber,  4,     false,    true,  15); 
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "cre_usr_id",       false,          "",       dfNone,    0,     false,   false,  20); 
					InitDataProperty(0, cnt++, dtData,        100,    daLeft,   false,    "cust_rmk",         false,          "",       dfNone,    0,     true,     true, 250);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "cre_ofc_cd",       false,          "",       dfNone,    0,     false,   false);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "conti_cd_old",     false,          "",       dfNone,    0,     true,     true);
					
					InitDataCombo(0, "conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
				}
				break;
				
		}
	}



function getCOM_ENS_0M1_1(rowArray) {
	
	var colArray = rowArray[0];	
	document.all.sel_cnt_cd.value = colArray[3];
	document.all.sel_cnt_nm.value = colArray[4];
	
	fun_CntEffData();

}	
/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	   case IBSEARCH:	  //조회
		
			if(!validateForm(formObj)) {
				return false;
			}
						
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
			break;

		case IBCLEAR:	   //Clear
			sheetObj.RemoveAll();
			break;
		case IBDOWNEXCEL:  //엑셀내려받기
			sheetObj.SpeedDown2Excel(true);
			break;
        case IBLOADEXCEL:        //엑셀 업로드
        	sheetObj.LoadExcel();
 
            break;			
		case IBINSERT:
			var isEUR = null;
			isEUR = formObj.ctrl_ofc_cd.value;
			
			if( isEUR == null && formObj.ctrl_user_id.value != 'system1'  ) {
				ComShowCodeMessage("EAS90011");
				return false;
			}
		      var Row = sheetObj.DataInsert();
		      
		      sheetObj.CellValue(Row, "cre_usr_id") = formObj.ctrl_user_id.value;
		      break;		
		case IBCOPYROW:
		      var row = sheetObj.DataCopy();
		      sheetObj.CellValue(row, "cntr_tp_cd") = "";
		      sheetObj.CellValue(row, "chrr_frt_tax_val") = "";
		      sheetObj.CellValue(row, "cre_usr_id") = formObj.ctrl_user_id.value;
		      sheetObj.CellValue(row, "cre_ofc_cd") = formObj.ctrl_ofc_cd.value;
		      
		      break;	
		case IBDELETE:
		      sheetObj.RowDelete(sheetObj.CheckedRows, false);		      
		      break;			
        case IBSAVE:        //저장
			
			if(!validateForm(formObj)) {
                return false;
            } 
			
			var verifyCheck = 'N';
			for(yn=sheetObj.HeaderRows ;yn<=sheetObj.LastRow ;yn++ ){
				  if(sheetObj.RowStatus(yn) != 'R'){
					  verifyCheck = 'Y';
				  }
			}
			if(verifyCheck =='Y') {
				
				if(!verifyLocCd(sheetObj)||!verifyCustCd(sheetObj)||!verifyTpszCd(sheetObj)||!verifyCurrCd(sheetObj)){
					return false;            	
				}
			}
// 해당 데이터가 있으면 업데이트 없으면 인서트 로 dup 체크 를 뺀다.
//            //Sheet Dup check
//            if(sheetObj.CheckedRows("r_chk")==0){
//            	alert(1);
//        		if(!chkDupRow(sheetObj)){
//					return;
//				}
//        	}
//            
//            //DB Dup check 
//			if(sheetObj.CheckedRows("r_chk")==0){
//				alert(2);
//        		if(!checkDupData(sheetObj)){
//					return;
//				}
//        	}
	        
//            with(sheetObj) {
//	         	   for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++ ) {  
//	        		   if(sheetObj.RowStatus(i) != 'R'){
//	                    formObj.f_cmd.value = MULTI;
//	                    sheetObj.DoSave("ESD_EAS_0007GS.do" ,EasFrmQryString(formObj)); 
//        	   		   }
//	               }      
//            }
            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESD_EAS_0007GS.do" ,EasFrmQryString(formObj)); 
	}
}


function sheet1_OnPopupClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="cust_info" ){

		openCustPopSheet(sheetObj, row ) ;
	}
}

//날자포맷으로 yyyy-mm-dd
function addBar() {
	var dat="";
	var dt = document.form.newEffDate.value;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '/' + dt.substr(4,2) + '/' + dt.substr(6,2);
		document.form.newEffDate.value = dat;
	}
}


/**
 *  Customer Code 공통 팝업 오픈(sheet)
 */
function openCustPopSheet(sheetObj, row ){
	sheetrow = row;
	shtObj = sheetObj;
	
	ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'setCustPopSheet', '1,0,1,1,1,1,1,1');
}


function setCustPopSheet( rowArray ) {

	var colArray = '';
	
	if(rowArray.length>0)
	{
		shtObj.CellValue(sheetrow, "cust_info") = rowArray[0][3];
	}
	
}

function sheet1_OnClick(sheetObj, Row,Col,Value){
	var isEUR = null;
//	isEUR = document.form.ctrl_user_id.value;
	isEUR = document.form.ctrl_ofc_cd.value;
	if(sheetObj.RowStatus(Row) != 'I' &&  Col == 5) {
//		alert('5'+ sheetObj.ColSaveName(Col));
//		if( isEUR !=  sheetObj.CellValue(Row, "cre_usr_id") ){
		if( isEUR !=  sheetObj.CellValue(Row, "cre_ofc_cd") ){
			ComShowCodeMessage("EAS90012");			
			return false;
		}
	}
	if( sheetObj.RowStatus(Row) != 'I' && Col == 10) {
//		alert('10'+ sheetObj.ColSaveName(Col));
//		if( isEUR !=  sheetObj.CellValue(Row, "cre_usr_id") ){
		if( isEUR !=  sheetObj.CellValue(Row, "cre_ofc_cd") ){
			ComShowCodeMessage("EAS90012");	
			return false;
		}
	}
}

function sheet1_OnChange(sheetObj, Row,Col,Value){
	var isEUR = null;
	isEUR = document.form.ctrl_ofc_cd.value;
	var formObj = document.form;
//	alert('del:'+Row+'VAL: '+Value+' '+ sheetObj.CellValue(Row, "fm_loc_cd"));
	
//    with(sheetObj) {
//  	   for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++ ) {  
//                  if(sheetObj.RowStatus(i) != 'R'){
//  
//                 	 formObj.s_loc_cd.value 		= sheetObj.CellValue(i, "fm_loc_cd");
//                 	 formObj.s_cust_info.value 	= sheetObj.CellValue(i, "cust_info");
//                 	 formObj.s_cntr_tp_cd.value 	= sheetObj.CellValue(i, "cntr_tp_cd");
//                 	 formObj.s_curr_cd.value 	= sheetObj.CellValue(i, "curr_cd");
//                 	 formObj.s_conti_cd.value 	= sheetObj.CellValue(i, "conti_cd");
//                 	 break;
//
//                  }
//           }      
//     }	
	
	formObj.s_loc_cd.value 		= sheetObj.CellValue(Row, "fm_loc_cd");
	formObj.s_cust_info.value 	= sheetObj.CellValue(Row, "cust_info");
	formObj.s_cntr_tp_cd.value 	= sheetObj.CellValue(Row, "cntr_tp_cd");
	formObj.s_curr_cd.value 	= sheetObj.CellValue(Row, "curr_cd");
	formObj.s_conti_cd.value 	= sheetObj.CellValue(Row, "conti_cd");

	if( Col == 0 ) {		
//		alert('isEUR:'+isEUR + ' cre_ofc_cd:'+sheetObj.CellValue(Row, "cre_ofc_cd") );
	//if( Col == 0 && (sheetObj.RowStatus(i) != 'I') ) {		
		if( isEUR !=  sheetObj.CellValue(Row, "cre_ofc_cd") ){
			ComShowCodeMessage("EAS90013");
			sheetObj.CellValue2(Row, "r_chk") = 0;
			return false;
		}
	}
}

function chkDupRow(sheetObj){
	var Rows = sheetObj.ColValueDupRows("fm_loc_cd|cust_info|conti_cd|cntr_tp_cd");
	var arr_rows = null;
	
	if (Rows!=null && Rows.trim()!=''){
		arr_rows = Rows.split(',');
	}
	
	for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
        sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255,0,0);
    }

	if (Rows!=null && Rows.trim()!=''){
    	ComShowCodeMessage("EAS90014");
        return false;
    }else{
        return true;
        
    }
}

function checkDupData(sheetObj){
       var dupCnt = '';
       var formObj = document.form;

       with(sheetObj) {
    	   for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++ ) {  
                    if(sheetObj.RowStatus(i) == 'I'){
	                    var qStr =   "f_cmd=" + SEARCH02
	                                        + "&s_conti_cd=" + CellValue(i, "conti_cd")
	                                        + "&s_cntr_tp_cd=" + CellValue(i, "cntr_tp_cd")
	                                        + "&s_loc_cd=" + CellValue(i, "fm_loc_cd")
	                                        + "&s_cust_info=" + CellValue(i, "cust_info")
//	                                        + "&s_type=" + CellValue(1, "effdt");
	                    					+ "&s_type=" + ComReplaceStr(formObj.s_type.value, "/", "")  ;
	                    
//	                    alert(i+''+ComReplaceStr(formObj.s_type.value, "/", ""));
	                    sheetObj.DoSearch("ESD_EAS_0007GS.do", qStr);
	                    dupCnt = sheetObj.EtcData("dupCnt") ;
		                    if(dupCnt > 0){
//		                    	alert(3);
		                       ComShowCodeMessage("EAS90014");
		                       sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
	                           return false;
		                    }
		                    sheetObj.RowFontColor(i) = sheetObj.RgbColor(0,0,0);
                    }
             }      
       }
       return true;
}


/**
 * sheetObject의 특정 Column 값을 배열로 반환하는 함수.
 *
 * @param sheetObject, RowNumber, 해당Coloumn  <br>
 * @returns Array <br>
 * @author 김영출
 */
function ComGetColumnData(sheetObj, colName){
	var rarr = new Array();
	for(yn=sheetObj.HeaderRows ;yn<=sheetObj.LastRow ;yn++ ){
	  if(sheetObj.RowStatus(yn) != 'R'){
	    rarr.push(sheetObj.CellValue(yn, colName));
	  }
	}
	return rarr;
}

function verifyLocCd(sheetObj){
	var locCnt = '';
	var formObj = document.form;
	var seqArr = ComGetColumnData(sheetObj, "fm_loc_cd");
	var s_fm_loc_cd ='';
	for(rn = 0; rn < seqArr.length; rn++){
		//alert(hbl_seq +"="+ seqArr[rn]);
		if(rn == 0 ){
			
			s_fm_loc_cd = s_fm_loc_cd + seqArr[rn];
		} else {
			
			s_fm_loc_cd = s_fm_loc_cd + ',' + seqArr[rn];
		}
	}
	formObj.s_loc_cd.value 		= s_fm_loc_cd;
	
	
	formObj.f_cmd.value = SEARCH03;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	locCnt = sheetObj.EtcData("locCnt") ;
	
	if(locCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90015");
		return false;	
	}
}

function verifyCustCd(sheetObj){
	var custCnt = '';
	var custInfo = '';
	var formObj = document.form;
	
	var seqArr = ComGetColumnData(sheetObj, "cust_info");
	var s_cust_info ='';
	var s_cust ='';
	for(rn = 0; rn < seqArr.length; rn++){
		//alert(hbl_seq +"="+ seqArr[rn]);
		if(seqArr[rn] == ''){
			s_cust = 'CO0';
		} else {
			s_cust = seqArr[rn];
		}
		if(rn == 0 ){
			
			s_cust_info = s_cust_info + s_cust;
		} else {
			
			s_cust_info = s_cust_info + ',' + s_cust;
		}
	}
	if(s_cust_info == ''){
		s_cust_info = 'CO0';
	}
	formObj.s_cust_info.value 		= s_cust_info;
	
	formObj.f_cmd.value = SEARCH04;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	custCnt 	= sheetObj.EtcData("custCnt");
	custInfo	= sheetObj.EtcData("custInfo");
	
	if(custCnt > 0 || custInfo == 'CO0'){
		return true;
	}else{
		ComShowCodeMessage("EAS90016");
		return false;	
	}
}

function verifyTpszCd(sheetObj){
	var tpszCnt = '';
	var formObj = document.form;
	
//	formObj.s_cntr_tp_cd.value 	= sheetObj.CellValue(i, "cntr_tp_cd");
	var seqArr = ComGetColumnData(sheetObj, "cntr_tp_cd");
	var s_cntr_tp_cd ='';
	for(rn = 0; rn < seqArr.length; rn++){
		//alert(hbl_seq +"="+ seqArr[rn]);
		if(rn == 0 ){
			
			s_cntr_tp_cd = s_cntr_tp_cd + seqArr[rn];
		} else {
			
			s_cntr_tp_cd = s_cntr_tp_cd + ',' + seqArr[rn];
		}
	}
	formObj.s_cntr_tp_cd.value 		= s_cntr_tp_cd;
	
	
	formObj.f_cmd.value = SEARCH05;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	tpszCnt = sheetObj.EtcData("tpszCnt") ;
	
	if(tpszCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90017");
		return false;	
	}
}

function verifyCurrCd(sheetObj){
	var currCnt = '';
	var formObj = document.form;
	//------------------
	var seqArr = ComGetColumnData(sheetObj, "curr_cd");
	var s_curr_cd ='';
	for(rn = 0; rn < seqArr.length; rn++){
		//alert(hbl_seq +"="+ seqArr[rn]);
		if(rn == 0 ){
			
			s_curr_cd = s_curr_cd + seqArr[rn];
		} else {
			
			s_curr_cd = s_curr_cd + ',' + seqArr[rn];
		}
	}
	formObj.s_curr_cd.value 		= s_curr_cd;
	
	//------------------
	formObj.f_cmd.value = SEARCH06;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	currCnt = sheetObj.EtcData("currCnt") ;
	
	if(currCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90018");
		return false;	
	}
}

/*
function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if(errMsg==""){
		doActionIBSheet(sheetObj,formObj,IBSEARCH);	
		showErrMessage('') ;
	}
}
*/

function upperCase(obj) {
	obj.value = obj.value.toUpperCase();
	
}

function selectText(obj) {

	if( obj.name == "sel_cnt_cd" || obj.name == "sel_cnt_nm" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "cust_cnt_seq" || obj.name == "cust_nm" ) {
		document.form.search_choice[1].checked = true;
	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.sel_cnt_cd.value = "";
		document.form.sel_cnt_cd.focus();
		document.form.sel_cnt_nm.value = "";
			
		document.form.search_choice[1].checked = false;
		document.form.cust_cnt_seq.value = "";
		document.form.cust_nm.value = "";
				
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.cust_cnt_seq.value = "";
		document.form.cust_cnt_seq.focus();
		document.form.cust_nm.value = "";
		
		document.form.search_choice[0].checked = false;
		document.form.sel_cnt_cd.value = "";
		document.form.sel_cnt_nm.value = "";
	
	}

}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){

	var result = true ;
	// 검색 조건 입력 여부
	if( !isInputField(formObj) ) {
		result = false ;
	}else if( formObj.s_type.value == 'null' ){
		ComShowCodeMessage("EAS90019");
		result = false;
	}                                                                                                                                                                                                                                                                                                                 

	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( ComIsEmpty(formObj.sel_cnt_cd) && ComIsEmpty(formObj.cust_cnt_seq) ) {
		ComShowCodeMessage("EAS90020");
		
		result = false;
	}
	return result;
}


function fun_CntEffData(){

	var strlen = document.form.sel_cnt_cd.value.length;

	if( strlen > 1 ){

		fun_getEffDate();
	}
}

function fun_CustEffData(){

	var strlen = document.form.cust_cnt_seq.value.length;

	if( strlen > 2 ){
		//alert(document.form.sel_cnt_cd.value.toUpperCase() );
		fun_getEffDate();
	}	
}

//Effect Date Combo를 처리하기 위한 Logic
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
		showErrMessage("Erroe Request XMLHttp");
	}
}

// sel_cnt_cd가 2자리 입력 되었을때
function fun_getEffDate() {
	var doc_cncd = document.form.sel_cnt_cd.value.toUpperCase();
	var doc_cust_cnt_seq = document.form.cust_cnt_seq.value.toUpperCase();

	if( doc_cncd != null || doc_cust_cnt_seq != null ) {
	
		var url = "ESD_EAS_0007GS.do?f_cmd="+SEARCH11+"&sel_cnt_cd="+doc_cncd+"&cust_cnt_seq="+doc_cust_cnt_seq;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subCntorlOffice;
		
		request.send(null);
	} else {
		//document.form.ctrl_ofc_cd.value = document.form.old_ofc_cd.value;
		alert("doc_cncd is null");
	}
}

// Effect Date의 값을 가지고 온다.
function subCntorlOffice() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("EffDate");
			var skxml = docXml.getElementsByTagName("sub-sortKey");
			var cdxml = docXml.getElementsByTagName("sub-code");
			var nmxml = docXml.getElementsByTagName("sub-name");
			
			var sortKeyXml = null;
			var codeXml = null;
			var nameXml = null;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";
				
			//text_effS = "<select style=\"width:100;\" name=\"s_type\" onChance=\"fncselEff();\" >&nbsp;";
			text_effS = "<select style=\"width:100;\" name=\"s_type\" >&nbsp;";

			if( rowXml.length > 0 ){
			
				for( var i = 0; i < rowXml.length; i++ ) {
							
					sortKeyXml = skxml[i].childNodes[0].nodeValue;
					codeXml = cdxml[i].childNodes[0].nodeValue;
					nameXml = nmxml[i].childNodes[0].nodeValue;					

					if( i == 0){
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" selected >"+nameXml+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}
				}
			}
		
			text_effE = "</SELECT>";
			
			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"null\" selected >No Data</OPTION>";
			}
			
			document.form.all.ScriptDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}


/**
 * customer popup
 */
function popCustomer(){
	ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'setCustomerPop', '1,0,1,1,1,1,1,1');
}

/**
 * customer 팝업에서 값 가져오기
 */
function setCustomerPop(rowArray){
	var formObj = document.form;
	var colArray = '';
	
	if(rowArray.length>0)
	{
		formObj.cust_cnt_seq.value = rowArray[0][3];
		formObj.cust_nm.value = rowArray[0][4];
		
		fun_CustEffData();
	}

}

/**
처음에 읽어 와서 eur의 Off_cd를 가지고 있는다..
*/
function fun_getEUROffcd() {
		var url = "ESD_EAS_0007GS.do?f_cmd="+SEARCH01;
		createHttpRequest();
		request.open("GET", url, false);

		request.onreadystatechange = fncEUROffcd;
		
		request.send(null);

}

function fncEUROffcd() {
	if( request.readyState == 4 ) {
		
		if( request.status == 200 ) {
			
			var docXml = request.responseXML;
			//alert(docXml.xml);
			var rowXml = docXml.getElementsByTagName("EUROFFCD");
			var skxml = docXml.getElementsByTagName("sub-sortKey");
			
			var sortKeyXml = null;
			var codeXml = null;
			var nameXml = null;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			Dictionary ();
							

			if( rowXml.length > 0 ){
			
				for( var i = 0; i < rowXml.length; i++ ) {
					sortKeyXml = skxml[i].childNodes[0].nodeValue;
					put(sortKeyXml, sortKeyXml);
				}
				
			}
		}
	}
}

//******************************************************************

function Dictionary () {

    this.nodeObject = new Object();
    this.put = put;
    this.get = get;
    this.keys = keys;
    this.del = del;
}

function put(key, value)
{
    obj = this.nodeObject;

    searchFlag = 0;

    for(var n in obj) {
        if(n == key) {
            obj[key] = value;
            searchFlag = 1;
        }
    }

    if(searchFlag == 0) {
        obj[key] = value;
    }
}


function get(key) {
    obj = this.nodeObject;

    return obj[key];
}

function keys(){
    return this.nodeObject;
}

function del(key) {
    this.put(key, null);
}

function sheet1_OnLoadExcel(sheetObj,ErrMsg){
	var formObj = document.form;
    with(sheetObj) {
 	   for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++ ) {  
                 if(sheetObj.RowStatus(i) == 'I'){
 
                	 formObj.s_loc_cd.value 		= sheetObj.CellValue(i, "fm_loc_cd");
                	 formObj.s_cust_info.value 	= sheetObj.CellValue(i, "cust_info");
                	 formObj.s_cntr_tp_cd.value 	= sheetObj.CellValue(i, "cntr_tp_cd");
                	 formObj.s_curr_cd.value 	= sheetObj.CellValue(i, "curr_cd");
                	 formObj.s_conti_cd.value 	= sheetObj.CellValue(i, "conti_cd");
                	 break;

                 }
          }      
    }

}
//******************************************************************

	