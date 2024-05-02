/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0976.js
*@FileTitle : Invoice Office Authority Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.09
*@LastModifier : 유선오
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
* 2011.11.09 유선오 1.0 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
=========================================================*/
/**
 * @extends Trs
 * @class ESD_TRS_0976 : invoice office authority management
 */
function ESD_TRS_0976(){
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

var	ofcSelected = "";
var	invOfcCdSelected = "";
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];
     var formObject = document.form;

	 try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName){
		
		 case "btng_save":
			 for(var k=sheetObject.HeaderRows; k<sheetObject.RowCount+sheetObject.HeaderRows; k++)
			 {
				 if (sheetObject.CellValue(k, "inv_ofc_cd") == "" || sheetObject.CellValue(k, "ofc_cd")== "") {
					 var errMessage = ComGetMsg('COM130403'); 
					 ComShowMessage(errMessage);
					 return;
				 }
			 }
			 var saveRows = sheetObject.FindCheckedRow("sel");
			 var arrRow = saveRows.split("|");
			 if(arrRow.length == 1){
				 var errMessage = ComGetMsg('TRS90215'); 
				 ComShowMessage(errMessage);
				 break;
			 }else     	
				 doActionIBSheet(sheetObject,formObject,IBSAVE);
			 break;
             
		case "btn_retrieve":
	    	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
             break;

 	    case "btns_office": 
 	    	
 	    	invOfcCdSelected = "Y";
 	    	ofcSelected = "N";
 	    	if( validation_check()) {
				var inv_ofc_cd = formObject.inv_ofc_cd.value;
				ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+inv_ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
			}	       
			break;
			
 	    case "btng_office"	:
 	    	
 	    	ofcSelected = "Y";
 	    	invOfcCdSelected = "N";
			if( validation_check1()) {
				var ofc_cd = formObject.ofc_cd.value;
				ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
	    	}
	    	break;
		    
			case 'btng_rowadd':
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
				
			case 'btng_del':
				var vMsg = "";
				var saveRows = sheetObject.FindCheckedRow("sel");
	             var arrRow = saveRows.split("|");
					if(arrRow.length == 1){
						var errMessage = ComGetMsg('TRS90215'); 
						ComShowMessage(errMessage);
						break;
					}
					else if(confirm(ComGetMsg("COM12165", vMsg))){
						doActionIBSheet(sheetObject,formObject, IBDELETE);
           	 }
			 break;	
			 
			case "btn_close":
				window.close();
			break;
			 
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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

function loadPage() {
      
	for(i=0;i<sheetObjects.length;i++){
	//-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
	//-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//html컨트롤 이벤트초기화
	//initControl();
}

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
				style.height = GetSheetHeight(20) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 1 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				var HeadTitle1 = "|status|Invoice Office|Invoice Office|Office|Office|Creation User|Creation Date|Updated User|Updated Date";
					HeadTitle2 = "|status|Code|Name|Code|Name|Creation User|Creation Date|Updated User|Updated Date";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,	   50,	daCenter,   true,	"sel", 			  false,    "",      dfNone,          0,         true,        true);
			    InitDataProperty(0, cnt++ , dtStatus,      75,  daCenter,   true,   "ibflag",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);				
				InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"inv_ofc_cd",     false,    "",      dfNone,          0,         false,       true,6);
				InitDataProperty(0, cnt++ , dtData,       250,	daLeft,     true,	"inv_ofc_eng_nm", false,    "",      dfNone,          0,         false,       false);
				InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"ofc_cd",         false,    "",      dfNone,          0,         false,       true,6);
				InitDataProperty(0, cnt++ , dtData,       250,	daLeft,     true,	"ofc_eng_nm",     false,    "",      dfNone,          0,         false,       false);
				InitDataProperty(0, cnt++ , dtData,       100,	daCenter,   true,	"cre_usr_id",     false,    "",      dfNone,          0,         false,       true);
				InitDataProperty(0, cnt++ , dtData,       150,	daCenter,   true,	"cre_dt",         false,    "",    dfNone,         0,         false,       true);	

				ColHidden('ibflag')= true;
		}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
		        //Office Code조회 
		   case IBSEARCH:                      
				formObj.f_cmd.value = SEARCH20;
				sheetObj.DoSearch("ESD_TRS_0976GS.do", TrsFrmQryString(formObj));
				break;
				//입력
		   case IBINSERT:      
				//생성 후 기본값 설정하기
				var Row = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(Row, "cre_usr_id") = document.form.hid_cre_usr_id.value.toUpperCase();
				sheetObj.CellValue2(Row, "cre_dt") = document.form.hid_cre_date.value;
				sheetObj.CellValue2(Row, "upd_dt") = document.form.hid_cre_date.value;				
				sheetObj.CellValue2(Row, "upd_usr_id") = document.form.hid_cre_usr_id.value.toUpperCase();
				document.form.hid_cre_usr_id.value = document.form.hid_cre_usr_id.value.toUpperCase();
				sheetObj.SelectCell(Row, "inv_ofc_cd");
			    break;	
		        //저장
		   case IBSAVE:        
			   	if(!validateForm(sheetObj, formObj, sAction)) return false;
        		formObj.f_cmd.value = MULTI;
        		
				var formObject = document.form;
				var sheet1_count = formObject.sheet1.RowCount;	//sheet1의 전체로우수를 담는 변수!
				var row_status = "";     
				var k = sheet1_count+1;
				var duple1 ="";
				var duple2 ="";
				var save_val="Y";
				var row_val ="";
				if(save_val =="Y"){
					formObj.f_cmd.value = MULTI;
					var savexml = sheetObjects[0].DoSave("ESD_TRS_0976GS.do", TrsFrmQryString(formObj),"sel","false","true");					
			     	}else{
					var errMessage = ComGetMsg('COM12115','Sheet data','','');  
					ComShowMessage(errMessage);
					formObject.sheet1.SelectCell(row_val, 'inv_ofc_cd');	
				}
				break;
				//row선택 후 삭제 
		   case IBDELETE:
				var checkList = sheetObj.FindCheckedRow('sel');
				if(checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');
				var queryStr = sheetObj.GetSaveString(false, false, "sel");
				formObj.f_cmd.value = REMOVE;
            	sheetObj.DoSave("ESD_TRS_0976GS.do",TrsFrmQryString(formObj),'sel',false);
				for(var k=checkArray.length-2; k>=0; k--)
				{
					sheetObj.RowDelete(checkArray[k], false);
				}
				break;
		  }	
    }catch(e) {
	if( e == "[object Error]") {
		ComShowCodeMessage('COM12111');
	} else {
		ComShowMessage(e);
	}
}
}

/**
 * Surcharge Input Inquiry popup
 **/
function popEdiInquiry(sheetObj,formObj){

	var sheetObj = sheetObjects[0];
	var arrRow = '' ;
	var chkRows = '' ;
	chkRows = sheetObj.FindCheckedRow ("sel");
	arrRow = chkRows.split("|");

		if(arrRow == '' || arrRow.length-1 > 1)
    {
		ComShowMessage("Please select one row");
       	return;
	}
          		
	var myOption = "width=800,height=360,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0976.screen';
	url += '&inv_ofc_cd='+sheetObj.CellValue(arrRow, 'inv_ofc_cd');
	url += '&ofc_cd='+sheetObj.CellValue(arrRow, 'ofc_cd');
	url += '&cre_ofc_id='+sheetObj.CellValue(arrRow, 'cre_ofc_id');
	url += '&cre_usr_id='+sheetObj.CellValue(arrRow, 'cre_usr_id');
	url += '&inv_ofc_eng_nm='+sheetObj.CellValue(arrRow, 'inv_ofc_eng_nm');
	url += '&ofc_eng_nm='+sheetObj.CellValue(arrRow, 'ofc_eng_nm');


	myWin = window.open(url, "popEdiInquiry", myOption);
	myWin.focus();
    ComOpenWindow(url, 'popEdiInquiry', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:400px', true);
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
return true;
}

 function sheet1_OnChange(sheetObj, row, col, value) {
	 
 	var colName = sheetObj.ColSaveName(col);
 	var formObj = document.form;
 	var cmd=formObj.f_cmd.value = SEARCH19;
 	switch(colName)
 	{
 		case ('ofc_cd'):
 			formObj.ofc_cd.value = formObj.ofc_cd.value.toUpperCase();
 		    var ofcCd = sheetObj.CellValue2(row,'ofc_cd') = ComTrim(value.toUpperCase());
 			value = cntrCheckDigit(value);
        	if(ofcCd!=null)
			{
			value = cntrCheckDigit(value);
			sheetObj.CellValue(row, col) = value.toUpperCase();
			formObj.f_cmd.value = SEARCH19;			
			}else {
				sheetObj.CellValue2(row, 'ofc_cd') = "";
				sheetObj.CellValue2(row, 'ofc_eng_nm') = "";
			}
 
 			var urlStr = 'ibflag=R&inv_ofc_cd='+value+'&row='+row+'&col=ofc_eng_nm';
 			sheetObj.DoRowSearch('ESD_TRS_0976GS.do',urlStr+'&'+TrsFrmQryString(formObj));
 			sheetObj.CellValue2(row, 'sel')='1';	
 			var ss = sheetObj.EtcData('ofcEngName');
 			if(ss=="null"||ss==""){
 		    	ComShowCodeMessage('COM12114', 'office code');
				sheetObj.CellValue2(row, 'ofc_cd') = "";
				sheetObj.CellValue2(row, 'ofc_eng_nm') = "";
	 			} else {
	 			sheetObj.CellValue2(row,'ofc_eng_nm')=ss;
	 			}
 			break;
 			
 		case ('inv_ofc_cd'):
 			formObj.inv_ofc_cd.value = formObj.inv_ofc_cd.value.toUpperCase();
 		    var invOfcCd = sheetObj.CellValue2(row,'inv_ofc_cd') =  ComTrim(value.toUpperCase());
 			value = cntrCheckDigit(value);
 		    sheetObj.CellValue2(row, col) = ComTrim(value.toUpperCase());
			if(invOfcCd!=null)
			{   				
				formObj.f_cmd.value = SEARCH19;		
			}else {
				sheetObj.CellValue2(row, 'inv_ofc_cd') = "";
				sheetObj.CellValue2(row, 'inv_ofc_eng_nm') = "";
			}
 			var urlStr = 'ibflag=R&inv_ofc_cd='+value+'&row='+row+'&col=inv_ofc_eng_nm';
 			sheetObj.DoRowSearch('ESD_TRS_0976GS.do',urlStr+'&'+TrsFrmQryString(formObj));
 			sheetObj.CellValue2(row, 'sel')='1';	
 		    var ss = sheetObj.EtcData('ofcEngName');	
 			if(ss=="null" || ss==""){
				ComShowCodeMessage('COM12114', 'invoice office code');
				sheetObj.CellValue2(row, 'inv_ofc_cd') = "";
				sheetObj.CellValue2(row, 'inv_ofc_eng_nm') = "";
 			}else{
 				sheetObj.CellValue2(row, 'inv_ofc_eng_nm')=ss;
 			}
 			break; 	 				
      }
 }
 
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name) {
				
			case 'inv_ofc_cd':
				 sheetObj.RemoveEtcData();
				 getTextInvOfcCd(sheetObj, formObj, obj.value);				 
				 break;
				
			case 'ofc_cd':
				 sheetObj.RemoveEtcData();
				 getTextOfcCd(sheetObj, formObj, obj.value);
				 break;				 
		         }		
		}
}

//ofc_cd 를 비어있는 row에담는다. DO NOT DELETE
function importOfcCd(popSheetObj, obj)
{
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[2];
	var checkList = popSheetObj.FindCheckedRow('ibflag');
	var checkArray = checkList.split('|');
	var row = 0;
	var value = '';
	document.form.f_cmd.value = SEARCH19;

	var queryStr = popSheetObj.GetSaveString(false, false, "ibflag");
	if(queryStr==''){
		return false;
	}

	sheetObj2.DoSearch4Post("ESD_TRS_0976GS.do", queryStr+'&'+TrsFrmQryString(document.form), '', false);
	
	for(var i=0; i<checkArray.length-1; i++){
		if(popSheetObj.CellValue(checkArray[i], 'verify_result') != 'OK'){
			var new_row = sheetObj2.DataInsert(-1);
			sheetObj2.CellValue2(new_row, 'ofc_cd') = popSheetObj.CellValue(checkArray[i], 'ofc_cd');			
		}
	}

	// eq_no가 비어있는 row를 array로 담는다.
	var emptyEqArray = new Array();
	var cnt=0;

	for(var k=2; k<sheetObj.RowCount+2; k++)
	{
	  if(sheetObj.CellValue(k, 'ofc_cd')=='') emptyEqArray[cnt++] = k;
	}

	cnt=0; // insert된 data의 갯수를 센다.
	var tempEqNo = '';

	var loopLength = Math.min(sheetObj2.RowCount ,emptyEqArray.length);

	for(var k=0; k<loopLength;k++)
	{
		sheetObj.CellValue2(emptyEqArray[k], 'ofc_cd')			= sheetObj2.CellValue(k+1, 'ofc_cd');
		sheetObj.CellValue2(emptyEqArray[k], 'ofc_eng_nm')		= sheetObj2.CellValue(k+1, 'ofc_eng_nm');
	}
	
//	obj.close();

}

//움직였을때..
function value_move(row)
{	 	
	 var sheet1_count =formObject.sheet1.RowCount;

	 //부분적으로 색깔을 넣기!!!!(수정가능한 필드)
	 for(var t = 2; t < sheet1_count+1; t++) {
		check_val = formObject.sheet1.RowStatus(t);

			 formObject.sheet1.CellEditable(t,'inv_ofc_cd') = false;
			 formObject.sheet1.CellEditable(t,'ofc_cd') = false;		 
		}
	  	check_val = formObject.sheet1.RowStatus(row);
	  	
	    if(check_val=="I"){
	    formObject.sheet1.RowBackColor(row)=formObject.sheet1.RgbColor(238,255,226);
	    formObject.sheet1.CellEditable(t,'inv_ofc_cd') = true;
        formObject.sheet1.CellEditable(t,'ofc_cd') = true;			   
	    }	
    }
    //invoice office code 를  조회하는  함수
    function getTextInvOfcCd(sheetObj, formObj, inv_ofc_cd) {  
    	
		formObj.f_cmd.value = SEARCH20;
		formObj.inv_ofc_cd.value = lpad(ComTrim(inv_ofc_cd).toUpperCase());
	    sheetObj.DoSearch("ESD_TRS_0976GS.do", TrsFrmQryString(formObj));
        return true;
	}
   //office code 를  조회하는  함수
    function getTextOfcCd(sheetObj, formObj, ofc_cd) { 
	   
		formObj.f_cmd.value = SEARCH20;
		formObj.ofc_cd.value = lpad(ComTrim(ofc_cd).toUpperCase());
		sheetObj.DoSearch("ESD_TRS_0976GS.do", TrsFrmQryString(formObj));
	    return true;
	}
	
    //office code return value. DO NOT DELETE
    function rtn_office_code(obj){
	
	   	if(invOfcCdSelected=="Y") {
		 document.form.inv_ofc_cd.value = obj;
	   	}else {
		 document.form.ofc_cd.value = obj;	
	 }	  
   }
 
    //Invoice Office Code-PopUp Validation Checked- DO NOT DELETE
    function validation_check() {	
 	
 	var prm_office = doSepRemove(document.form.inv_ofc_cd.value.toUpperCase(), " "); //input text
 	var aoffice = prm_office.split(",");
 	if( prm_office == ""){
 		document.form.inv_ofc_cd.value = "";
 		ComShowMessage("Please input the 'S/O Office'!!");
 		return false;
 	}
    else {
        if( aoffice.length == 1 ) {
    	return true;
 	}
    else {
 		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
 		return false;
	}
}
  
   }
 //Office Code-PopUp Validation Checked- DO NOT DELETE
 function validation_check1() {	
 	var prm_office = doSepRemove(document.form.ofc_cd.value.toUpperCase(), " "); //input text
 	var aoffice = prm_office.split(",");
 	if( prm_office == "") {
 		document.form.inv_ofc_cd.value = "";
 		ComShowMessage("Please input the 'S/O Office'!!");
 		return false;
 	    }
 	 else {
 		if( aoffice.length == 1 ) {
 		return true;
 	    }
     else {
 		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
 		return false;
 		}
 	} 
 }
 
 /**
  * 저장후 발생하는 이벤트를 처리
  */
 function sheet1_OnSaveEnd(sheetObj, errMsg) {
	 var formObj = document.form;
	 if( errMsg != null && errMsg != '' ) {
		 //ComShowMessage(errMsg);
	 } else {
		 if(formObj.f_cmd.value == MULTI){
		     ComShowCodeMessage('COM130102', 'Invoice Authority');
		 }else if(formObj.f_cmd.value == REMOVE){
			 ComShowCodeMessage('COM12167', 'Invoice Authority');
		 }
	 }
 }