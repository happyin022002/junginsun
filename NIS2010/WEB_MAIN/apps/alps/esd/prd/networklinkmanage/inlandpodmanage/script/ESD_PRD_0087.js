/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0227.js
*@FileTitle : Agreement Rate History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-03-18 cjh
* 1.0 최초 생성
* HISTORY
* 
=========================================================*/
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var openWindownm     = 'AGMT';
var sheetObjects     = new Array();
var sheetCnt         = 0;
var comboObjects 	 = new Array();		// 민정호-추가
var comboCnt = 0;
document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
var Mincount = 0;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
   var sheetObject = sheetObjects[0];
   var formObject = document.form;
   
   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {


			case "btng_save":		// 추가-민정호
				//doActionIBSheet(sheetObject,formObject,IBSAVE);
				//alert(ComGetObjValue(comboObjects[0])+'::'+comboObjects[0].Text  );
				window.dialogArguments.getImdg_Multi(ComGetObjValue(comboObjects[0]));
				window.close();
				break;			
				
			case "btn_close":
			 	window.close();
				break;

				
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
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
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
 }
/**
* Sheet 기본 설정 및 초기화 
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
	}

	/* IBMultiCombo 초기화 */
 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {		// 민정호-추가
 		initCombo(comboObjects[k], k+1);
 	}	
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {
         	case "sheet1":      // sheet1 init
         		with (sheetObj) {
	         		// 높이 설정
//	     			style.height = 428;
	    			style.height = 0; // 높이 설정
	    			SheetWidth = 0; //전체 너비 설정
	     			// 전체 너비 설정
	     			SheetWidth = mainTable.clientWidth;
	     			
	     			//Host정보 설정[필수][HostIp, Port, PagePath]
	     			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	     			//전체Merge 종류 [선택, Default msNone]
	     			MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	     			Editable = true;
	
	     			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	     			InitRowInfo( 1, 1, 3, 100);
	
	     			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	     			InitColumnInfo(1, 0, 0, true);
	
	     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	     			InitHeadMode(true, true, true, true, false,false)
	
	     			var HeadTitle ="";
//	     			var HeadTitle = "||UN No./Seq.|UN No./Seq.|Class|Class|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|Special\nProvisions|Limited\nQuantities|EmS|Stowage and\nSegregation|HJS\nRestrictions|||||||||||||";
	     			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	     			InitHeadRow(0, HeadTitle, true);
	
	     			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
//	     			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,	"checkbox");
//	     			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"imdg_un_no",			false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"imdg_un_no_seq",		false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,	"imdg_clss_cd",			false,	"",		dfNone,			0,			false,		false); 					
//					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"imdg_comp_grp_cd",		false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			390,	daLeft,		false,	"prp_shp_nm",			false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtHidden,		170,	daLeft,		false,	"imdg_tec_nm");
//					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_subs_rsk_lbl_cd",	false,	"",		dfNone,			0,			false,		false); 					
//					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"imdg_pck_grp_cd",		false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,	"imdg_spcl_provi_no",	false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_lmt_qty",			false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_emer_no",			false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			390,	daLeft,		false,	"segr_desc",			false,	"",		dfNone,			0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,	"imdg_crr_rstr_expt_nm",false,	"",		dfNone,			0,			false,		false);
//					
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_expt_qty_cd");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_subs_rsk_lbl_rmk");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"psa_no");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_flg");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_pck_rstr_desc");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_intmd_bc_rstr_desc");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_tnk_rstr_desc");					
//					
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_ctrl_temp");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"emer_rspn_gid_no");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"emer_rspn_gid_chr_no");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_emer_temp");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_lmt_qty_meas_ut_cd");
//					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_mrn_polut_cd");
//					
//         			ScrollTrack		= false;
//					MassOfSearch 	= 0;
//					
//					ColHidden("checkbox") = false;
//					EditableColorDiff = false;
         		}
         		break;
         }
     }




function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {



		case IBSEARCH_ASYNC01: // Class 조회
    		sheetObj.WaitImageVisible = false;
           formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESD_PRD_0087GS.do", FormQueryString(formObj));
			//Class
			ComXml2ComboItem(sXml, formObj.imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd|imdg_clss_cd_desc");
			break;

    }
		sheetObj.WaitImageVisible = true;
}


//function setSheetObject(sheet_obj) {
//	sheetObjects[sheetCnt++] = sheet_obj;
//}

//function openAgmtHdrPopup() {
//	var formObject = document.form;
//	var Option = "width=724,height=290,menubar=0,status=0,scrollbars=0,resizable=0";
//	var agmt_no = formObject.fm_agmtno.value;  
//	var agmt_no ="";
//	var param ="?agmt_no="+agmt_no;
//	window.open('/hanjin/ESD_TRS_0220.do' + param, "popup", Option);
//}

/**
 * 외부 콤보박스의 리스트 가져오기
 */
// function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
// 	var formObj = document.form;
// 	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
//
// 	obj.value = lvobj;
// 	if( lvobj == "" ) {
// 		obj.value = "";
// 		comObj.RemoveAll();
// 		return false;
// 	} else if( lvobj.length != 5 ) {
// 		errMsg = ComGetMsg("TRS90074");
// 		ComShowMessage(errMsg);
// 		obj.focus();
// 		return false;
// 	}
// 	if( !doengnumcheck(lvobj) ) {
// 		obj.value = "";
// 		comObj.RemoveAll();
// 		obj.focus();
// 		return false;
// 	}
// 	if( sep == 'F' ) {
// 		formObj.TRSP_SO_EQ_KIND.value = "";
// 		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
// 		formObj.fm_fm_nod_yd.value = fm_nod_yd;
// 	} else if( sep == 'V' ) {
// 		formObj.TRSP_SO_EQ_KIND.value = "";
// 		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
// 	} else if( sep == 'T' ) {
// 		formObj.TRSP_SO_EQ_KIND.value = "A";
// 		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
// 	} else if( sep == 'D' ) {
// 		formObj.TRSP_SO_EQ_KIND.value = "";
// 		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
// 	}
// 	comObj.focus();
// }
 
 /**
 * Sheet 확대/축소
 */
//function Minimize(nItem) {
//	var objs = document.all.item("MiniLayer");
//	if( nItem == "1" ) {
//		objs.style.display = "none";
//		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(19);
//	} else {
//		objs.style.display = "inline";
//		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(13);
//	}
//}
 
//###################################################################################
 
/**
 * EQ 조회
 **/
// function getTypeSizeList(sheetObj, formObject)
// {
// 	 sheetObj.WaitImageVisible  = false;
// 	 formObject.f_cmd.value = SEARCH03;
// 	 var queryString = TrsFrmQryString(formObject);
// 	 sheetObj.DoRowSearch("ESD_TRS_0231GS.do", queryString);
// 	 sheetObj.WaitImageVisible  = true;
// 	 return sheetObj.EtcData('TPSZ');
// }   
 
/**
 * EQ 조회
 **/  
//function getTypeSizeCombo(comboObj)
//{
//	  var formObj = document.form;
//	  var TySzList = getTypeSizeList(sheetObjects[1], formObj);	  
//	  var TySzArray = new Array();	  	 
//	  TySzArray = TySzList.split("|");
//	  comboObj.RemoveAll();
//	  comboObj.InsertItem(0, "ALL", "ALL");
//	  for(var i=1; i<TySzArray.length+1; i++)
//	  {		
//		  comboObj.InsertItem(i, TySzArray[i-1], TySzArray[i-1]);
//	  }	  
////	  comboObj.Index=0;	  		
//
//
//    // 추가-민정호
//    // Eq Type 세팅
//	var sw = 0;
//	comboObjects[4].UseCode = false;	
//	var eqtpsz = formObj.fm_eqtpsz.value;
//	for(var j = 1; j < comboObjects[4].GetCount(); j++) {
//		if(eqtpsz == comboObjects[4].GetText (j, 0)){		
//			comboObjects[4].CheckIndex(j) = true;
//			sw = 1;
//		}
//	} 	 
//	if(sw == 0) comboObjects[4].CheckIndex(0) = true;
//	comboObjects[4].UseCode = true;	
//} 
 
 /**
  * MultiCombo object initial property //LHS
  * @param comboObj
  * @param comboNo
  * @return
  */
 function initCombo (comboObj, comboNo) {
 	 switch(comboObj.id) {
    	 case "imdg_clss_cd":
 		with(comboObj) {
 			//BackColor = "cyan";
    		SetTitle("Class|Definition");
    		SetColWidth("50|700");
 			DropHeight = 150;
 			MultiSelect = true;
 			UseAutoComplete = true;
 			MultiSeparator = ",";
 			Style = 1;
 			ValidChar(2,3);
// 			UseCode = false;				// 민정호-추가
 		}
 	break;
 	 }      	
 } 
 
 /**
  * IBCombo Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
 */
// function setComboObject(combo_obj){
//	 alert(7);
//	 alert(combo_obj);
//	 comboObjects[0] = combo_obj;
////     comboObjects[comboCnt++] = combo_obj;
//     alert(8);
//     
// }
  
//function sheet_tpsz_OnLoadFinish(sheetObj) {	
//	getTypeSizeCombo(document.combo1);		// 민정호-추가	
////	comboObjects[4].CheckIndex(0) = true;
//}  
  
  
 /**
  * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
  * @return
  */
 function combo1_OnCheckClick(comboObj, index, code) { 	
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	} 	
 }


 /**
  * combo1_OnBlur
  */
 function combo1_OnBlur(comboObj, Index_Code, Text) {
 	var formObj = document.form;
 	if( comboObj.CheckIndex(0)){
 		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
 			comboObj.CheckIndex(i) = false;
 		}
 		formObj.fm_eqtpsz.value = "";
 	}else if(comboObj.Text == ""){
 		comboObj.CheckIndex(0) = true;
 		formObj.fm_eqtpsz.value = "";
 	}else{
 	    formObj.fm_eqtpsz.value = ComGetObjValue(comboObj);
 	}
 }
  
 /**
  * combo1_OnKeyDown
  */
 function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
 	with(comboObj) {
 		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
 			comboObj.Text = "";
 		}
 	}
 }
 
  /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
//function validateForm(sheetObj,formObj,sAction){
//	var cnt = 0;
//	switch(sAction){
//		case IBSAVE:
//			for(var k=2; k<sheetObj.RowCount+2; k++)
//			{
//				if(sheetObj.RowStatus(k)=='U'){
//					cnt++;
//				}
//			}			
//			
//			if(cnt > 0){
//				return true;
//			}else{
//				return false;
//			}
//	}
//} 
   
 function sheet1_OnLoadFinish(sheetObj) {
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
 
 } 
   