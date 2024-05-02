/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1212.js
*@FileTitle : Report Template
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.18
*@LastModifier : 박은정
*@LastVersion : 1.0
* 2013.10.18 박은정
* 1.0 Creation
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
     * @extends 
     * @class esm_bkg_0104  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function esm_bkg_1212() {
	this.processButtonClick	= processButtonClick;
 	this.setSheetObject 		= setSheetObject;
   	this.loadPage 				  = loadPage;
   	this.initSheet 				  = initSheet;
   	this.initControl        = initControl;
   	this.doActionIBSheet 		= doActionIBSheet;
   	this.setTabObject 			= setTabObject;
   	this.validateForm 			= validateForm;    	
}
    
/* 개발자 작업	*/
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}
     
     
 // 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var rptFomNo = "";
var rptFomNm = "";
var rptFomDesc = "";
 
 

 /*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
 	
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
	initControl();
	//멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 		
}
	
	 	
	
    
function initControl() {
 	var formObject = document.form;
    axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
    axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
    axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    axon_event.addListenerForm ('change', 'bkg_change', formObject);
}   
    
    
/*
 * 조회 후 Type이 Common, Shared이면 Editable = false; 
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 
	for(var i=1;i<=sheetObj.RowCount;i++){
   		sheetObj.CellValue2(i, "edit")= 'Double click to edit';
   		sheetObj.CellFontUnderline(i,"edit") = true;
   		sheetObj.CellValue2(i, "ibflag")= 'R';
   	}
   	
}


/*
 *  Search Option or Item Option Modify
 * */
var selected = "";
function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
	selected =  rowIdx;
    if( sheetObj.ColSaveName(colIdx) == "edit" ) {
    	if(sheetObj.CellValue(rowIdx,"rpt_fom_nm" ) ==""){
    		ComShowMessage("Input report name before editing");
        	sheetObj.SelectCell(rowIdx,"rpt_fom_nm");
        	return false;
        }
    	 
    	rptFomNo = sheetObj.CellValue(rowIdx, "rpt_fom_no");
        rptFomNm = sheetObj.CellValue(rowIdx, "rpt_fom_nm");
        rptFomDesc = sheetObj.CellValue(rowIdx, "rpt_fom_desc");
        var checkIbflag = sheetObj.CellValue(rowIdx, "ibflag");
        ComOpenPopup('/hanjin/ESM_BKG_1213.do?checkIbflag='+checkIbflag+'&rptFomNo='+rptFomNo+'&rptFomNm='+rptFomNm+'&rptFomDesc='+rptFomDesc , 780, 705, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Search Option");
        
    }
    				
				
}
   
  
/*********************** KEY EVENT END ********************/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
	var comboObject1 = comboObjects[0]; 
    /*******************************************************/
    var formObject = document.form;
    var srcName = window.event.srcElement.getAttribute("name");
	
	switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			
		case "btn_Save":
			
			doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
		 							 					
		case "btn_RowAdd":
			var addRow     = sheetObject1.RowCount+1;
			//데이터 행 추가
			var row = sheetObject1.DataInsert(addRow);
						
			sheetObject1.CellValue2(row, "edit")= 'Double click to edit';
			sheetObject1.CellFontUnderline(row,"edit") = true;
			break;
		 					
		case "btn_RowDelete":
			ComRowHideDelete(sheetObject1,"sel_chk");
			break;
		case "btn_New":
			form.reset();
			sheetObject1.RemoveAll(); 
			break;
		
		case "btn_Close":		
			self.close();
			break;
		case "btn_Apply":
			if(sheetObject1.CheckedRows("sel_chk")==0){
				ComShowMessage("Please select a row");
				return false;
			} 
			//선택한 로우가 저장되어 있는 로우인지 확인한다.
			doActionIBSheet(sheetObject2,formObject,SEARCH04);
			if(sheetObject2.RowCount==0){
				ComShowMessage("Please save the report column detail to show");
				return false;
			}
			var checkedRow = sheetObject1.FindCheckedRow('sel_chk').split('|');
			opener.searchReportItem(sheetObject1.CellValue(checkedRow, "rpt_fom_no" ));
			self.close(); 
			break;
	    } 
	     	
}
     
   // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
    	case IBSEARCH:      //조회
    		if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.DoSearch("ESM_BKG_1212GS.do", FormQueryString(formObj)  );
			break;
    	case IBSAVE:        //저장
    		formObj.f_cmd.value = MULTI;
    		if(!validateForm(sheetObj,formObj,sAction)) return;
    		
    		var sParam = sheetObj.GetSaveString();
    		sParam += "&" + FormQueryString(formObj);
    		var sXml = sheetObj.DoSave("ESM_BKG_1212GS.do" , sParam);
    		if(sXml==false){
    			ComShowMessage("Failed to save");
    			return false;
    		}
    		formObj.f_cmd.value = SEARCH;
    		sheetObj.DoSearch("ESM_BKG_1212GS.do", FormQueryString(formObj)  );
    		break;	
    	case SEARCH04:        //저장
    		formObj.f_cmd.value = SEARCH04;

			var checkedRow = sheetObjects[0].FindCheckedRow('sel_chk').split('|');
    		sheetObj.DoSearch("ESM_BKG_1212GS.do", FormQueryString(formObj)+"&reportName="+sheetObjects[0].CellValue(checkedRow, "rpt_fom_nm"));
    		break;	
    }
}
     

/**
 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
 * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @version 2009.05.17
 */ 	
function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	var formObject = document.form;
	if (ErrMsg == "") {
		ComBkgSaveCompleted();
		opener.location.reload();
		sheetObj.RemoveAll();
		doActionIBSheet(sheetObj,formObject,IBSEARCH);
	}
}    

 

   
/*
 * Report Name 중복 체크
 * */
function isRptNameDup(rowIdx,p_rpt_fom_nm){
	with (sheetObjects[0]) {
		var rpt_fom_nm;
		for (var i = HeaderRows; i < Rows  ; i++) {
			
			if(rowIdx == i) continue;
			if(CellValue(i, "ibflag") == 'D')	continue;
			
			rpt_fom_nm = CellValue(i, "rpt_fom_nm");
			if( rpt_fom_nm == p_rpt_fom_nm ){
				return true;
			}
		}
	} 
	    	 
	return false;    			
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	
	case IBSAVE:
		
		with (sheetObj) {
			for (var i = HeaderRows; i < Rows  ; i++) {
				if(CellValue(i, "ibflag") == 'R' || CellValue(i, "ibflag") == 'D')	continue;
				if(CellValue(i,  	"rpt_fom_nm")==""){
				ComShowCodeMessage("BKG00625"); 
				sheetObj.SelectCell(i,	"rpt_fom_nm");
				return false;
				}else	if (isRptNameDup(i,CellValue(i,"rpt_fom_nm")))  {
				ComShowCodeMessage("BKG03064",CellValue(i, "rpt_fom_nm")); 
				sheetObj.SelectCell(i, 	"rpt_fom_nm");
				return false;
				}
			
			}//end for
		} //end with(sheetObject[0])
	    	 
		break;
	}
         return true;
}
     


    
   

 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetObj.id) {
	
		case "sheet1":
			with (sheetObj) {
			// 높이 설정
			style.height = 282;
				
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 50);
			
			var HeadTitle1 = "ibflag| Sel. |Seq.|report no|Report Name|Report Form Description|Edit";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(true, true, true, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	                
			
			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++ , dtSeq,					35,		daCenter,		false,		 	"Seq");
			InitDataProperty(0, cnt++ , dtHiddenStatus, 0,	daCenter,		true,		"ibflag");                                                            
			
			InitDataProperty(0, cnt++ , dtDummyCheck,		 	40,	daCenter,		true,		 "sel_chk");
			InitDataProperty(0,	cnt++,	dtSeq,					30,		daCenter,	false,		"seq");
			InitDataProperty(0, cnt++ , dtHidden,					80,	daLeft,		false,	 "rpt_fom_no",			    false,			"",      dfNone,			0,		false,		false,50);
			InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		false,	 "rpt_fom_nm",			    false,			"",      dfNone,			0,		false,		true, 100);
			InitDataProperty(0, cnt++ , dtData,					250,	daLeft,		false,	 "rpt_fom_desc",			    false,			"",      dfNone,			0,		true,		true, 1000);
			InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	false,	 "edit",	false,			"",      dfNone,			0,		false,	false);
					
					
			CountPosition = 0;//[1/3] 페이지 위치 
		}
 				
 					break;
		case "sheet2":
			with (sheetObj) {
			// 높이 설정
			style.height = 50;
				
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 50);
			
			var HeadTitle1 = "ibflag| Sel. |Seq.|report no|Report Name|Report Form Description|Edit";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(true, true, true, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	                
			
			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++ , dtSeq,					35,		daCenter,		false,		 	"Seq");
			InitDataProperty(0, cnt++ , dtHiddenStatus, 0,	daCenter,		true,		"ibflag");                                                            
			
			InitDataProperty(0, cnt++ , dtDummyCheck,		 	40,	daCenter,		true,		 "sel_chk");
			InitDataProperty(0,	cnt++,	dtSeq,					30,		daCenter,	false,		"seq");
			InitDataProperty(0, cnt++ , dtHidden,					80,	daLeft,		false,	 "rpt_fom_no",			    false,			"",      dfNone,			0,		false,		false,50);
			InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		false,	 "rpt_fom_nm",			    false,			"",      dfNone,			0,		false,		true, 100);
			InitDataProperty(0, cnt++ , dtData,					250,	daLeft,		false,	 "rpt_fom_desc",			    false,			"",      dfNone,			0,		true,		true, 1000);
			InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	false,	 "edit",	false,			"",      dfNone,			0,		false,	false);
					
					
			CountPosition = 0;//[1/3] 페이지 위치 
		}
 				
 					break;
	}
}
     
 function sheet1_OnClick(sheetObj, row, col, value){
     var formObject = document.form;
     var colName = sheetObj.ColSaveName(col);
     switch(colName){
         case 'sel_chk':
             
             var initCheck=sheetObj.CellValue(row, 'sel_chk'); 
             //체크가 되어있다면
             if(initCheck =='0'||initCheck =='Y'){
                 var result = sheetObj.FindCheckedRow('sel_chk').split('|');
                 
                 // 다른 체크 있으면 체크 없애기
                 if(result.length >1){
                         sheetObj.CellValue2(result[0], 'sel_chk') = '0';
                
                 }
             }
             break;
             
         
             
     }
}

    
      
	/* 개발자 작업  끝 */    
										
		