/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0506.js
*@FileTitle : Welfare Card Mileage Status
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

	var formObj = document.form;

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
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
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
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:  //   sheet1 Welfare Card Mileage
			with (sheetObj) {
		  	  style.height    = 380; // 높이 설정
			  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
			  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
			  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
			  Editable = true; //전체Edit 허용 여부 [선택, Default false]
			  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			  InitColumnInfo(21, 7, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		
			  // 해더에서 처리할 수 있는 각종 기능을 설정한다
			  InitHeadMode(true, true, true, true, false,false)
			  var HeadTitle1 = "|SEL|SEQ|INCNT NO|RHQ|TEAM|YEAR|Bank|Mileage Period|Mileage Period|Payment\nAmount|Mileage|Mileage|Cash Back|Cash Back|Balance\n(Mileage)|Evidence Attachment\n(Calculation&Obtaining)||Evidence Attachment\n(Collection&Using)||Remark" ;
			  var HeadTitle2 = "|SEL|SEQ|INCNT NO|RHQ|TEAM|YEAR|Bank|From|To|Payment\nAmount|Issued date|Mileage Point|Date|Amount|Balance\n(Mileage)|Evidence Attachment\n(Calculation&Obtaining)||Evidence Attachment\n(Collection&Using)||Remark" ;
		
			  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			  InitHeadRow(0, HeadTitle1, true);
			  InitHeadRow(1, HeadTitle2, true);
		
			  //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			  InitDataProperty(0, cnt++ , dtHiddenStatus,  	45,  daCenter, 	true,       "ibflag",  			false,    	"",  		dfNone,     	0,      true,   true,    	0,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtCheckBox,      	50,  daCenter, 	true,       "chk",  			false,    	"",  		dfNone,     	0,      true,   true );
			  InitDataProperty(0, cnt++ , dtDataSeq,    	40,  daCenter,  true,       "seq");
			  InitDataProperty(0, cnt++ , dtHidden,         60,  daCenter,  true,       "incnt_no",  		false,    	"",  		dfEngUpKey,     0,     	false,  false,  	6,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,          	60,  daCenter,  true,       "rhq_cd",  			false,    	"",  		dfEngUpKey,     0,     	false,  false,  	6,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,          	60,  daCenter,  true,       "team_nm",  		false,    	"",  		dfEngUpKey,     0,     	false,  false,  	6,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,          	40,  daCenter,  true,       "bse_yr",  			false,    	"",  		dfNone,     	0,     	false,  false,    	4,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,          	80,  daCenter, 	true,       "bank_nm",  		false,    	"",  		dfEngUpKey,     0,     	false,  false,    	30,  	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       	70,  daCenter, 	true,      	"mlg_fm_dt",  		false,    	"",	 		dfDateYmd,   	0,     	true,   true,   	8,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,   		70,  daCenter, 	true,		"mlg_to_dt",  		false,    	"",  		dfDateYmd,     	0,     	true,   true,       8,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,           110, daRight, 	true,       "pay_amt",  		false,    	"",			dfInteger,   	0,     	true,   true,    	15,  	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData, 			80,  daCenter, 	true, 	  	"mlg_iss_dt",  		false,    	"",  		dfDateYmd, 	 	0, 		false, 	false,      8,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       	100, daRight, 	true,       "mlg_pnt_amt",  	false,    	"",			dfInteger,   	0,     	true,   true,       15,  	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData, 			80,  daCenter, 	true, 	  	"csh_bak_dt",  		false, 		"",  		dfDateYmd, 	 	0, 		true, 	true,       8,   	false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      		90,  daRight, 	true,       "csh_bak_amt",  	false,    	"",  		dfInteger,    	0,     	true,   true,       18,  	false,   true,     "",    false);		
			  InitDataProperty(0, cnt++ , dtData,       	90,  daRight, 	true,    	"csh_bak_bal_amt",  false,    	"",			dfInteger,  	2,      false,  false,   	18,  	false,   true,     "",    false);
		      InitDataProperty(0, cnt++ , dtPopup,         150,  daCenter, 	true,       "atch_flg",  		false,    	"",			dfNone,     	0,      true,   true);
		      InitDataProperty(0, cnt++ , dtHidden,      	80,  daCenter, 	true,      	"atch_file_lnk_id", false,    	"",			dfNone,    		0,     	false,  false);
	          InitDataProperty(0, cnt++ , dtPopup,  	   150,  daCenter, 	true,    	"atch2_flg",		false,  	"",			dfNone,   		0,  	true,	true,		1,		false,		true,	   "",	  false	);
	          InitDataProperty(0, cnt++ , dtHidden,  		80,  daCenter, 	true,    	"atch_n2nd_file_lnk_id",false, 	"",			dfNone,   		0,  	true,	true,		10,		false,		true,	   "",	  false	);

		      InitDataProperty(0, cnt++ , dtData,       	300, daLeft, 	true,       "incnt_rmk",  		false,    	"",			dfNone,     	0,      true,   true,       1000,	false,   true,     "",    false);
		      
		      InitDataValid(0, "bse_yr", 		    vtNumericOnly);
			}
		break;

	}

}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	var sheetObj = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj, formObject, "SEARCH06");
			break;
			
			case "btn_save":
				doActionIBSheet(sheetObj, formObject, MULTI06);
			break;
			
			case "btn_new":
				formObject.s_fm_dt.value="";
				formObject.s_to_dt.value="";
				sheetObj.RemoveAll();
			break;
			
			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
			break;
			case "btng_row_add":
				sheetObj.DataInsert(-1);
				sheetObj.CellEditable(sheetObj.LastRow,"bse_yr") 	 = true;
				sheetObj.CellEditable(sheetObj.LastRow,"mlg_iss_dt") = true;
				sheetObj.cellvalue(sheetObj.LastRow,"rhq_cd") 		 = "SELHO";
				sheetObj.cellvalue(sheetObj.LastRow,"team_nm") 	     = "SELAGG";
				sheetObj.cellvalue(sheetObj.LastRow,"bank_nm")		 = "Woori Bank";
			break;	

			case "btng_del_row":
				doActionIBSheet(sheetObj, formObject, REMOVE06);
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
		    case "SEARCH06": // Mileage List
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCHLIST06;
				sheetObj.DoSearch4Post("ESD_EAS_0501GS.do", FormQueryString(formObj));
			break;
			
		    case MULTI06: // Mileage Save
		    	if(validateForm(sheetObj, formObj, "MULTI06")){
					formObj.f_cmd.value = MULTI06;
					var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
			        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
			        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			        if (State != "S") {
			        	ComShowCodeMessage('COM12151',"Welfare Card Mileage");
			        } else if (State == "S") {
			        	ComShowCodeMessage('COM12116',"Saving");
			        	doActionIBSheet(sheetObj, formObj, "SEARCH06");
			        }
		    	}
			break;
		    case REMOVE06: // Mileage Delete
				var checkList = sheetObj.FindCheckedRow('chk');
				var checkArray = checkList.split('|');
				for(var k=checkArray.length-sheetObj.HeaderRows; k>=0; k--){
					if(sheetObj.cellvalue(checkArray[k],"incnt_no")==""){
						sheetObj.RowDelete(checkArray[k], false);
					}
				}
				
				sumOfCashMileage(sheetObj);
				
				var checkRow = sheetObj.FindCheckedRow('chk');
				if(validateForm(sheetObj, formObj, "REMOVE06")){
			    	if(checkRow!=""){
						formObj.f_cmd.value = REMOVE06;
						var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
				        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
				        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				        if (State != "S") {
				        	ComShowCodeMessage('COM12151',"Welfare Card Mileage");
				        } else if (State == "S") {
				        	ComShowCodeMessage('COM12167',"Data");
				        	doActionIBSheet(sheetObj, formObj, "SEARCH06");
				        }
			    	}
				}
			break;
			
			case IBDOWNEXCEL:  // EXCEL
				sheetObj.Down2Excel(-1, false, false, true);;
			break;
		}
	}

  /**
   * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
   */
  function sheet1_OnClick(sheetObj, Row, Col, Value) {
  	var formObj = document.form;
  	
      switch (sheetObj.ColSaveName(Col)) {
          case "incnt_rmk":
        	  sheetObj.CellEditable(Row, Col) = false;
 			  ComShowMemoPad(sheetObj, Row, Col, false, 300, 200, 500, true);
 			  sheetObj.CellEditable(Row, Col) = true;
          break;
      } 
  }	
	
 /**
   * sheet1에서 OnChange 이벤트를 발생시킴.
   */
  function sheet1_OnChange (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  var crSumUsdAmt = 0;
	  //그리드 컬럼을 수정하면 chk컬럼 자동체크
//	  sheetObj.CellValue2(row,"chk") = "N";
	  var rowStatus =sheetObj.RowStatus(row);
	  if(rowStatus=="R"){
		   	sheetObj.CellValue2(row,"chk")= "N";
	   }else if(rowStatus=="I" || rowStatus=="U" ){
	   		sheetObj.CellValue2(row,"chk")= "Y";
	   }	  
	  
	  switch(colName){
		  case 'mlg_pnt_amt':
		  case 'csh_bak_amt':
			  sumOfCashMileage(sheetObj);
	      break;
	  }
  }
 

   /**
   * sheet1에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  
	  switch(colName){
	  	case('atch_flg'):
			var atch_file_lnk_id = sheetObj.cellvalue(row,"atch_file_lnk_id");
	  	    var bse_yr = sheetObj.cellvalue(row,"bse_yr");
	  	    var incnt_no = sheetObj.cellvalue(row,"incnt_no");
			var sParam = "cr_flg=Y&mdl_tp_cd=BNF&inv_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id;
	
			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = formObj.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 
			if(atch_file_lnk_id !=""){
				sheetObj.cellvalue(row,"atch_flg") = "Y";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = atch_file_lnk_id;
			}else{	
				sheetObj.cellvalue(row,"atch_flg") = "N";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = "";			}	
			formObj.f_cmd.value = MODIFY05;
			var updParam = "bse_yr="+bse_yr+"&incnt_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id + "&" + FormQueryString(formObj);
	        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", updParam);
	    break;
	  	case('atch2_flg'):
			var atch_file_lnk_id = sheetObj.cellvalue(row,"atch_n2nd_file_lnk_id");
	  	    var bse_yr = sheetObj.cellvalue(row,"bse_yr");
	  	    var incnt_no = sheetObj.cellvalue(row,"incnt_no");
			var sParam = "cr_flg=Y&mdl_tp_cd=BNF&inv_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id;
	
			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = formObj.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 

			if(atch_file_lnk_id !=""){
				sheetObj.cellvalue(row,"atch2_flg") = "Y";
				sheetObj.cellvalue(row,"atch_n2nd_file_lnk_id") = atch_file_lnk_id;		
			}else{	
				sheetObj.cellvalue(row,"atch2_flg") = "N";
				sheetObj.cellvalue(row,"atch_n2nd_file_lnk_id") = "";
			}
			formObj.f_cmd.value = MODIFY10;
			var updParam = "bse_yr="+bse_yr+"&incnt_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id + "&" + FormQueryString(formObj);
	        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", updParam);
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
		case('MULTI06'): // SAVE VESSEL OPERATION
			for(var i=0;i<checkArray.length-1;i++){
				if(sheetObj.cellvalue(checkArray[i],"bse_yr")==""){
					ComShowCodeMessage('COM130201',"YEAR");
					sheetObj.SelectCell(checkArray[i],"bse_yr");
					return false;
				}else if(sheetObj.cellvalue(checkArray[i],"bse_yr").length!=4){
					ComShowCodeMessage('COM132201',"YEAR");
					sheetObj.SelectCell(checkArray[i],"bse_yr");
					return false;		
				}else if(sheetObj.cellvalue(checkArray[i],"mlg_iss_dt")==""){
					ComShowCodeMessage('COM130201',"Issued date");
					sheetObj.SelectCell(checkArray[i],"mlg_iss_dt");
					return false;
				}
			}
		break;
		case('REMOVE06'): // DELETE VESSEL OPERATION

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

	}
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
			if(sheetIdx== "0" ||sheetIdx== "1"){
				sheetObj.CellValue(row, "inv_ofc_cd")  = sheetObj.EtcData('ofc_cd');
			}else if(sheetIdx== "2"){
				sheetObj.CellValue(row, "ofc_cd")  = sheetObj.EtcData('ofc_cd');
			}else if(sheetIdx== "3"){
				sheetObj.CellValue(row, "team_cd")  = sheetObj.EtcData('ofc_cd');	
			}
		}else{
			if(sheetIdx== "0" ||sheetIdx== "1"){
				sheetObj.CellValue(row, "inv_ofc_cd") = "";
			}else if(sheetIdx== "2"){
				sheetObj.CellValue(row, "ofc_cd") = "";
			}else if(sheetIdx== "3"){
				sheetObj.CellValue(row, "team_cd") = "";	
			}
		}
	}
}

/**
 * Mileage Balance 누적.
 * 
 */
function sumOfCashMileage(sheetObj){
	var sumPointAmt = 0;
	var sumCashBackAmt = 0;
	var issSheetObj = sheetObjects[3];
	for(var i=0; i<sheetObj.RowCount;i++){
		sumPointAmt = Number(sumPointAmt)+Number(sheetObj.CellValue(i+2,"mlg_pnt_amt"));
		sumCashBackAmt=  Number(sumCashBackAmt)+Number(sheetObj.CellValue(i+2,"csh_bak_amt"));
		sheetObj.CellValue2(i+2,"csh_bak_bal_amt") = Number(sumPointAmt)-Number(sumCashBackAmt);
	}
}