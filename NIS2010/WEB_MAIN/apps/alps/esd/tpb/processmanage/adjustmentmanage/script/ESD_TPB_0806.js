/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0806.js
*@FileTitle : Adjustment Approval Review Message
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-29
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초생성
* 2009-09-29 Sun, Choi 1.1 ALPS Migration
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
     * @class ESD_TPB_0806 : ESD_TPB_0806 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0806() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
	/* 개발자 작업	*/
	/* 공통전역변수 */
	//var calPop = new calendarPopupGrid();
	var curTab = 1;
	var beforetab = 0;
	var docObjects = new Array();
	var sheetCnt = 0;
	
	var processCloseCase = "0";
	
	/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
  				InsertTab(0, "Dry Index" , 23 );
  				InsertTab(1, "Tanker Index" , 23); 
  				InsertTab(2, "Time Charter" , 23 );
  				InsertTab(3, "Bunker Price" , 23 );
  				InsertTab(4, "Ship Price" , 23); 
  				InsertTab(5, "FFA Index" , 23 );
  				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}
  	}
  	
  	/**
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
  	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.BackColor="#FFFFFF";
  		tabObj.TabBackColor(nItem)="146,174,230";
  	
  		var objs = document.all.item("tabLayer");
  		objs[beforetab].style.display = "none";
  		objs[nItem].style.display = "Inline";
  	
  		//--------------- 요기가 중요 --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
  		objs[beforetab].style.zIndex = 0;
  		objs[nItem].style.zIndex = 9;
  		//------------------------------------------------------//
  		beforetab= nItem;
  	}

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * comSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setDocumentObject(sheet_obj){
  		docObjects[sheetCnt++] = sheet_obj;
  	}
  	
  	/**
  	 * Sheet 기본 설정 및 초기화 
  	 * body 태그의 onLoad 이벤트핸들러 구현
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	 */
  	function loadPage() {
//  		processCloseCase = document.form.processCloseCase.value; 
//  		
//          // guide message output
//          switch (processCloseCase){
//              case "1" : 
//                  document.all.div_guide_message.innerHTML = "<img class='star'> " + getMsg("TPB90042");
//                  break;
//              case "2" : 
//                  document.all.div_guide_message.innerHTML = "<img class='star'> " + getMsg("TPB90043");
//                  break;
//              case "3" : 
//                  document.all.div_guide_message.innerHTML = "<img class='star'> " + getMsg("TPB90044");
//                  break;
//                  
//              default : 
//                  window.returnValue = null;
//                  window.close();
//                  break;
//          }
  		for(i=0;i<docObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			comConfigSheet(docObjects[i],SYSTEM_ENIS);
  			initSheet(docObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			comEndConfigSheet(docObjects[i]);
  		}

//  		doActionIBSheet(docObjects[0],document.form,IBINSERT); // 최초 1 row 추가 
  	}

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
  					style.height = 180;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msNone;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 10);
  		
  		            switch (processCloseCase){
                       case "1" : 
          					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          					InitColumnInfo(4, 0, 0, true);
          
          					// 해더에서 처리할 수 있는 각종 기능을 설정한다
          					InitHeadMode(true, true, false, true, false, false)
          		
          					var HeadTitle = "Booking No.|C/A No.|Charge Code|Note";
          
          					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          					InitHeadRow(0, HeadTitle, true);
          		
          					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          					//InitDataProperty(0, cnt++, dtRadioCheck, 30,   daCenter,  true,    "select",                   false,          "",       dfNone,    0,      true,       false);					
          					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    "bkg_no",              false,          "",       dfNone,    0,     true,       true, 11);
          					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    "ca_no",               false,          "",       dfNone,    0,     true,       true, 10);
          					InitDataProperty(0, cnt++, dtData,      70,   daCenter,  true,    "chg_cd",              false,          "",       dfNone,    0,     true,       true, 3); 
          					InitDataProperty(0, cnt++, dtData,      200,   daCenter,  true,    "note",                false,          "",       dfNone,    0,     true,       true, 200); 

                           break; 		                

                       case "2" : 
          					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          					InitColumnInfo(3, 0, 0, true);
          
          					// 해더에서 처리할 수 있는 각종 기능을 설정한다
          					InitHeadMode(true, true, false, true, false, false)
          		
          					var HeadTitle = "Credit Note No.|CSR No.|Note";
          
          					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          					InitHeadRow(0, HeadTitle, true);
          		
          					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          					//InitDataProperty(0, cnt++, dtRadioCheck, 30,   daCenter,  true,    "select",                   false,          "",       dfNone,    0,      true,       false);					
          					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    "cn_no",              false,          "",       dfNone,    0,     true,       true, 5);
          					InitDataProperty(0, cnt++, dtData,      150,   daCenter,  true,    "csr_no",               false,          "",       dfNone,    0,     true,       true, 20);
          					InitDataProperty(0, cnt++, dtData,      200,   daCenter,  true,    "note",              false,          "",       dfNone,    0,     true,       true, 200); 

                           break; 		                

                       case "3" : 
          					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          					InitColumnInfo(5, 0, 0, true);
          
          					// 해더에서 처리할 수 있는 각종 기능을 설정한다
          					InitHeadMode(true, true, false, true, false, false)
          		
          					var HeadTitle = "TTL INV No.|Disposal INV No.|Credit Note No.|CSR No.|Note";
          
          					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          					InitHeadRow(0, HeadTitle, true);
          		
          					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          					//InitDataProperty(0, cnt++, dtRadioCheck, 30,   daCenter,  true,    "select",                   false,          "",       dfNone,    0,      true,       false);					
          					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    "ttl_inv_no",              false,          "",       dfNone,    0,     true,       true, 20);
          					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    "dps_inv_no",               false,          "",       dfNone,    0,     true,       true, 20);
          					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    "cn_no",              false,          "",       dfNone,    0,     true,       true, 5);
          					InitDataProperty(0, cnt++, dtData,      140,   daCenter,  true,    "csr_no",               false,          "",       dfNone,    0,     true,       true, 20);
          					InitDataProperty(0, cnt++, dtData,      200,   daCenter,  true,    "note",              false,          "",       dfNone,    0,     true,       true, 200); 

                           break; 		                
  		            }
  					
  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = docObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save":
  				    var rtnVal = new Array(4);
  				    rtnVal[0] = document.form.s_file_no.value;
  				    rtnVal[1] = document.form.s_ra_rmk.value;
  				    rtnVal[2] = document.form.s_wrtf_rsn_cd.value;
  				    
  				   // alert('1');
                      if ( rtnVal==null || rtnVal.length==0){
                          ComShowMessage(ComGetMsg("TPB90045"));
                          return;
                      } else {
                             window.returnValue = rtnVal;
                             window.close();
                      }
  					break;					
  				case "btn_ok": /// on ok button click
  					break;
  				case "btn_filesearch":
  					// openFileUploadPopup(document.form.s_file_no.value, 'getFileNo', 'Y', 'Y');
  					document.form.s_file_no.value = openFileUploadModalPopup(document.form.s_file_no.value, 'getFileNo', 'Y', 'Y');
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					sheetObject.ExcelPrint = "PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_close":
  				    window.returnValue = null;
  				    window.close();
  				    break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg("COM12111"));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert(-1);		    
  				break;
  		   case IBSEARCH:	  //조회
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  		   if(!checkTPBForm(formObj)) return false;
  		}
  		
  		return true;
  	}
  	
      function makeMessageArray(sheetObj){

          var HeadTitleArr = null;
          var saveNameArr = null;
          
          var colon = ":";
          var comma = ", ";
          
          var tempRowVal = "";
          var tempRowStr = "";
          var tempStr = "";
          var validRowCount = 0; 
          
          var returnValArr = new Array();
          
  		for(var i=1;i<=sheetObj.RowCount;i++){

              tempRowStr = "";
  		    for(var k=0; k<HeadTitleArr.length; k++){
  		        tempStr = sheetObj.CellValue(i, k);
  			    if (trim(tempStr).length > 0){
      		        if ( tempRowStr.length > 0){
      		            tempRowStr += comma;
      		        }
  		            tempRowStr += HeadTitleArr[k] + colon + tempStr; 
  		        }
  		    }
  		    
  		    if ( tempRowStr.length > 0 ){
  		         returnValArr[returnValArr.length] = tempRowStr;
  		    }
  		    // showErrMessage(tempRowStr);
  		}
          // showErrMessage(returnValArr.length);
          
          return returnValArr;
      }

  	function getFileNo(fileNoReceive){
  		document.form.s_file_no.value = fileNoReceive;
//  		ifr.document.location.href = "TPBFileDownload.do?fileNo="+document.form.s_file_no.value+"&f_cmd="+SEARCH+"&downloadLink=Y&col=1";
  	}