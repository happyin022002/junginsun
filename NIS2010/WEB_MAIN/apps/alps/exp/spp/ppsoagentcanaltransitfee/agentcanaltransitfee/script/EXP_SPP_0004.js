/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0004.js
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.30 김성광
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
     */

    /**
     * @extends 
     * @class EXP_SPP_0004 : EXP_SPP_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EXP_SPP_0004() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setTabObject 			= setTabObject;
    	this.initTab 				= initTab;
    	this.tab1_OnChange          = tab1_OnChange;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate 		= obj_deactivate;
    	this.obj_activate 			= obj_activate;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setBtnEnable 			= setBtnEnable;
    	this.computeEndBal 			= computeEndBal;
    	this.t1sheet1_OnAfterEdit 	= t1sheet1_OnAfterEdit;
    	this.t1sheet1_OnChange 		= t1sheet1_OnChange;
    	this.t1sheet1_OnSelectCell 	= t1sheet1_OnSelectCell;
    	this.setCountReCalc 		= setCountReCalc;
    	
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var tabObjects = new Array();
    var tabClicks  = new Array(3);  //해당 탭이 클릭되 었는가 셋팅.
    var tabCnt = 0 ;
    var beforetab = 1;			    //이전 탭 번호 기억
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];
             var sheetObject2 = sheetObjects[1];
             var sheetObject3 = sheetObjects[2];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	              case "btn_DownExcel":
  	        	        if(sheetObject1.RowCount <= 0){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수 
		        	        ComCodeMsgByNoRelatedData();  // There is no related data!
		        	        return;
	        	        }else{
		        	        if(sheetObject1.RowCount > 0){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
		        	        	sheetObject1.Down2Excel(-1,true,true,true,"","",false,false,"Requested MSA BALANCE");  //hidden 필드내려받지않음.
		        	        }
	        	        } 
	        	        break;
	        	        
	              case "btn_DownExcel2":
	        	        if(sheetObject2.RowCount <= 0){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수 
		        	        ComCodeMsgByNoRelatedData();  // There is no related data!
		        	        return;
	        	        }else{
		        	        if(sheetObject2.RowCount > 0){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
		        	        	sheetObject2.Down2Excel(-1,true,true,true,"","",false,false,"Requested MSA REMITTANCE");  //hidden 필드내려받지않음.
		        	        }
	        	        } 
	        	        break;
	        	        
	              case "btn_DownExcel3":
	        	        if(sheetObject3.RowCount <= 0){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수 
		        	        ComCodeMsgByNoRelatedData();  // There is no related data!
		        	        return;
	        	        }else{
		        	        if(sheetObject3.RowCount > 0){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
		        	        	sheetObject3.Down2Excel(-1,true,true,true,"","",false,false,"Requested MSA DISBURSEMENT");  //hidden 필드내려받지않음.
		        	        }
	        	        } 
	        	        break;	        	        
	
				  case "btn_Request":
					  	var procSts = formObject.pso_msa_sts_cd.value.trim();
					    if(procSts!="R") break;  //Ready 가 아닌 경우에는 Request 할 수 없음.
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("Working Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
					    doActionIBSheet(sheetObject1,formObject,COMMAND01);
						break;
						
				  case "btn_Save":
					    var procSts = formObject.pso_msa_sts_cd.value.trim();
					    if(procSts!="" && procSts!="R") break;  //Ready 상태가 아닌 경우에는 Save 할 수 없음.
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("Working Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
	    				
	            } // end switch
            
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("SPP01003");
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
         * IBTab Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setTabObject(tab_obj){
             tabObjects[tabCnt++] = tab_obj;
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
                         tabClicks[cnt]=false;
                         InsertTab( cnt++ , " (A)STATEMENT OF BALANCE" , -1 );
                         tabClicks[cnt]=false;
                         InsertTab( cnt++ , " (B)DETAILS OF REMITTANCE" , -1 );
                         tabClicks[cnt]=false;
                         InsertTab( cnt++ , " (C)DETAILS OF DISBURSEMENT" , -1 );
                     }
                  break;
              }
         }  
          
          /**
          * Tab 클릭시 이벤트 관련
          * 선택한 탭의 요소가 활성화 된다.
          */
         function tab1_OnChange(tabObj, nItem){  //nItem -> 0, 1, 2
            var objs = document.all.item("tabLayer");

         	//클릭한 탭과 매치되는 레이어의 표시 여부
 	    	objs[nItem].style.display = "Inline";
 	    	objs[beforetab].style.display = "none";

 	    	//레이어의 zindex 값 변경
 	    	//--------------- 요기가 중요 --------------------------//
 	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	    	//----------------------------------------------------//
 	    	beforetab= nItem;
 	    	
 	    	//첫번째 탭이나 두번째 탭을 클릭했을 때 한번도 클릭한 적이 없을 경우 해당 페이지 정보를 조회해온다.
 	    	if((nItem === 1 || nItem === 2) && tabClicks[nItem] == false){
 	    		doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);
 	    	}
 	    	
 	    	//해당 탭이 클릭된 적이 있음을 저장
 	    	tabClicks[nItem] = true;
         }           

        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
         function loadPage() {

            for(i=0;i<sheetObjects.length;i++){
            	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            initControl();
            
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
         
         /**
         * Form데이터포멧 키 프레스 관련 
         */
         function initControl() {
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur 이벤트에 코드 처리        	 
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus 이벤트에 코드 처리
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
			 axon_event.addListenerFormat('keypress', 'obj_keypress',   form);			 

			 //focusSetting
			 document.form.rev_yrmon.focus();
			 document.form.rev_yrmon.blur();
      	 } 
         
         /*
          * OnBlur 이벤트에 코드 처리
          */
         function obj_deactivate(){
      	     obj = event.srcElement;
             ComChkObjValid(event.srcElement);             
         }
         
         /*
          * OnFocus 이벤트에 코드 처리
          */
         function obj_activate(){
        	 obj = event.srcElement;
             ComClearSeparator(event.srcElement);    
             ComShowFocusCursor(obj);  //특정 event 로 인해서 사라진 포커스를 보여줌.
         }
          
         /*
          * OnKeyPress 이벤트 처리
          */
          function obj_keypress(){
              switch(event.srcElement.dataformat){
          	      case "ym":
          	        //숫자만입력하기
          	        ComKeyOnlyNumber(event.srcElement);          	        
          	        break;
          	        
          	      default:
          	        //숫자만입력하기
          	        ComKeyOnlyNumber(event.srcElement);
          	        break;
              }
          }          

        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    	  var sheetid = sheetObj.id;
    	  var onepagerows = document.form.pagerows.value;
          switch(sheetid) {

    				case "t1sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 340;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(2, 1, 3, onepagerows);

    							var HeadTitle1 = "|Seq.|Hidden5|Hidden4|ITEM|Amount|Amount|Remark|Hidden1|Hidden2|Hidden3|Hidden6";
    							var HeadTitle2 = "|Seq.|Hidden5|Hidden4|ITEM|Debit|Credit|Remark|Hidden1|Hidden2|Hidden3|Hidden6";							
    							
    							var headCount = ComCountHeadTitle(HeadTitle1); 
    							

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(false, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);

    							var prefix = "t1sheet1_";
    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		60,		daCenter,	true,	prefix+"seq");
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	prefix+"msa_seq");
    							InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	prefix+"pso_msa_amt_tp_cd",		false,	"",	dfNone,	0,	true,	true);
    							InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix+"item",			false,	"",	dfNone,			0,	false,	false);
    							InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,	prefix+"amount_debit",	false,	"",	dfNullFloat,	2,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,	prefix+"amount_credit",	false,	"",	dfNullFloat,	2,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		true,	prefix+"diff_rmk",		false,	"",	dfEngKey,		0,	true,	true, 50);
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"rev_yrmon");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"vndr_seq");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"pso_msa_sts_cd");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"exist");
    							
    							//한글 입력 불가능
    							InitDataValid(0, prefix+"diff_rmk", vtEngOther, "1234567890!@#$%^&*()_-+=[{]}|\\;:\"\'<,>.?/~` ");
    					}
    					break;


    				case "t2sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 260;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, onepagerows);

    							var HeadTitle1 = "|Seq.|Date|Vessel/Voyage/Direction|Amount";						
    							
    							var headCount = ComCountHeadTitle(HeadTitle1); 
    							

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);
    							var prefix = "t2sheet1_";
    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		70,		daCenter,	true,	"Seq");
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"trns_dt",	false,	"",	dfDateYmd,	0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"vvd",		false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daRight,	true,	prefix+"amount",	false,	"",	dfNullFloat,2,	false,	false, 18);

    					}
    					break;


    				case "t3sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 280;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, onepagerows);

    							var HeadTitle1 = "|Seq.|Date|Vessel/Voyage/Direction|Amount";
    							
    							var headCount = ComCountHeadTitle(HeadTitle1); 
    							

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);

    							var prefix = "t3sheet1_";
    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		70,		daCenter,	true,	"Seq");
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"trns_dt",	false,	"",	dfDateYmd,	0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daCenter,	true,	prefix+"vvd",		false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			270,	daRight,	true,	prefix+"amount",	false,	"",	dfNullFloat,2,	false,	false, 18);

    					}
    					break;
    						
    						
          }
        }

        /*
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

             case IBSEARCH:  //Search
		       	if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "t1sheet1"){
						var prefix = "t1sheet1_";
			       		formObj.f_cmd.value = SEARCH;
			       		ComClearFormSeparator(formObj);  //마스크  제거
    					sheetObj.DoSearch("EXP_SPP_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
    					ComSetFormSeparator(formObj);  //마스크 다시 셋팅
    					
    					//조회된 건수가 없으면 break
    					if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수

    					//소계 구하기
    					//ShowSubSum(StdCol, SumCols, [PosBottom], [Sort], [ShowCumulate], [CaptionCol], [OtherColText], [AvgCols], [IsSumEx])
    					//alert(sheetObj.RowCount);  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
    					var sumCols = prefix+"amount_debit"+"|"+prefix+"amount_credit";
    					var otherColText = prefix+"seq="+(sheetObj.TotalRows+1)+";"+prefix+"item=Total";
    					var captionCol = sheetObj.SaveNameCol(prefix+"item");
    					sheetObj.ShowSubSum(prefix+"vndr_seq", sumCols, true, false, false, captionCol, otherColText); 
    					//alert(sheetObj.RowCount);  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
    					
    					//Ending Balance
    					computeEndBal(sheetObj);
    					
    					//Others의 항목은 Editable로 변경 
    					var tmpRow = sheetObj.findText(prefix+"pso_msa_amt_tp_cd","O");
    					sheetObj.CellEditable(tmpRow, prefix+"amount_debit") = true;
    					sheetObj.CellEditable(tmpRow, prefix+"amount_credit") = true;
    					
    					//MSA 값이 존재하지 않을 경우 Row 상태값 변경(처음에는 모든 데이터를 저장처리 하기 위해)
    					if(sheetObj.CellValue(sheetObj.TopRow, prefix+"exist")=='N'){
    						for(ix=sheetObj.TopRow;ix<=sheetObj.RowCount;ix++){  //RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
    							sheetObj.RowStatus(ix) = 'I';
    						}
    					}
    					
    					formObj.pso_msa_sts_cd.value = sheetObj.CellValue(sheetObj.TopRow, prefix+"pso_msa_sts_cd");    					
						//Request 및 Save 버튼의 활성화 비활성화 처리
						setBtnEnable(formObj.pso_msa_sts_cd.value.trim());
						
						//t1sheet1 위의 count 재계산
						setCountReCalc(sheetObj);
					}
					
					else if ( sheetObj.id == "t2sheet1"){
						var prefix = "t2sheet1_";
			       		formObj.f_cmd.value = SEARCH02;
			       		ComClearFormSeparator(formObj);  //마스크  제거
						sheetObj.DoSearch("EXP_SPP_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						ComSetFormSeparator(formObj);  //마스크 다시 셋팅

    					//조회된 건수가 없으면 break
    					if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수
					}
					
				    else if ( sheetObj.id == "t3sheet1"){
				    	var prefix = "t3sheet1_";
			       		formObj.f_cmd.value = SEARCH03;
			       		ComClearFormSeparator(formObj);  //마스크  제거			       		
					  	sheetObj.DoSearch("EXP_SPP_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						ComSetFormSeparator(formObj);  //마스크 다시 셋팅					  	

    					//조회된 건수가 없으면 break
    					if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수
				    }
					
		       	}
				break;
			
			 case IBSAVE:  //Save		 
		       	if(validateForm(sheetObj,formObj,sAction)){
  	    		  	//transaction 발생한 건이 없을 경우 return
  					if (!sheetObj.IsDataModified) {				
  						ComCodeMsgByNoContentsSave();
  						return; 
  					} 
  					
  					//multi 데이터 처리
  	    		  	formObj.f_cmd.value = MULTI;
  	    		  	formObj.pso_msa_sts_cd.value = "R";
  	    		  	
  	    		    ComClearFormSeparator(formObj);  //마스크  제거 
  					var sParam = FormQueryStringOrg(formObj);
  					ComSetFormSeparator(formObj);  //마스크 다시 셋팅
  					
  					var sParam1 = sheetObj.GetSaveString();
  					
  					if (sParam1 == "") {
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}
  					
  	    		  	// 저장하시겠습니까?
  	    			if(!ComCodeMsgBySave()) return;   
  	    		  	
  					sParam = sParam + "&" + sParam1;  //Ready
  	    		  	
  	    		  	//저장. 저장 후 OnSaveEnd 이벤트 발생
  					//sheetObj.ShowDebugMsg = true;
  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0004GS.do", sParam);
  	    			//sheetObj.ShowDebugMsg = false;
  	    			sheetObj.LoadSaveXml(sXml);  //저장된 내용 sheet 에 반영 후 OnSaveEnd 이벤트 발생
  	    										 //저장 후 새로 조회하지 않아도 됨.
  	    			
  	    			//OnSaveEnd 후에 실행된다.
                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
                		formObj.pso_msa_sts_cd.value = "R";
						//Request 및 Save 버튼의 활성화 비활성화 처리
						setBtnEnable(formObj.pso_msa_sts_cd.value.trim());	 
						
		    			//msa 값을 opener 창에 return.
		            	var strRslt = formObj.pso_msa_sts_cd.value;
		            	strRslt += ROWMARK;
						window.returnValue = strRslt;
                	}
		       	}
	            break;
	              
			 case COMMAND01:  //Request
 		  	    //transaction 발생한 건이 있을 경우 return
				if (sheetObj.IsDataModified) {				
					ComShowCodeMessage("SPP01008");  //There is contents to save. First, save contents!
					return; 
				}

				//multi 데이터 처리
				formObj.f_cmd.value 		 = COMMAND01;
				formObj.pso_msa_sts_cd.value ='Q';

				ComClearFormSeparator(formObj);  //마스크  제거 
				var sParam = FormQueryStringOrg(formObj);
				ComSetFormSeparator(formObj);  //마스크 다시 셋팅
				
	 		  	//Do you want to request contents finally?
	 			if(!ComShowCodeConfirm('SPP01009')) return;
	 			
    		  	//저장. 저장 후 OnSaveEnd 이벤트 발생
				//sheetObj.ShowDebugMsg = true;
    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0004GS.do", sParam);
    			//sheetObj.ShowDebugMsg = false;
    			//sheetObj.LoadSaveXml(sXml);  //저장된 내용 sheet 에 반영. 서버에서보내온 메시지 출력. 후 OnSaveEnd 이벤트 발생
    			//							   //sheet 내용이 저장된게 아니기에 주석처리 했음.
    			
	    		//OnSaveEnd 후에 실행된다.
    			ComShowMessage(ComSaveXml2Message(sXml, "MESSAGE", 0));  //LoadSaveXml 을 하지 않았기 때문에 직접 메시지 띄움.
            	//if(ComSaveXml2Message(sXml, "MESSAGE", 0).indexOf("OK")!=-1){  //SC 에서 success 면 OK 를 UserMessage 로 보내도록 처리했음.
            	if(!ComSaveXml2IsTagExist(sXml, "ERROR")){  //ERROR 태그가 없으면
            		formObj.pso_msa_sts_cd.value = "Q";
					//Request 및 Save 버튼의 활성화 비활성화 처리
					setBtnEnable(formObj.pso_msa_sts_cd.value.trim());	            		
    			
	    			//msa 값을 opener 창에 return.
	            	var strRslt = formObj.pso_msa_sts_cd.value;
	            	strRslt += ROWMARK;
					window.returnValue = strRslt;
					self.close();
            	}	 			
			    
				break;
            }
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
           switch(sAction){
		       	 case IBSEARCH:	//조회
			  	 	if(ComIsEmpty(formObj.vndr_seq.value)){
			  	 		ComCodeMsgByEmptyData("vndr_seq");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.rev_yrmon.value)){
			  	 		ComCodeMsgByEmptyData("rev_yrmon");
			  	 		return false;
			  	 	}          	 	
			  	 	break;
			  	 	
		       	 case IBSAVE:  //SAVE
			  	 	if(ComIsEmpty(formObj.vndr_seq.value)){
			  	 		ComCodeMsgByEmptyData("vndr_seq");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.rev_yrmon.value)){
			  	 		ComCodeMsgByEmptyData("rev_yrmon");
			  	 		return false;
			  	 	} 		       	 
		       	    break;
			  	 	
	             default:
		            break;			  	 	
           }
           return true;
        }
         
         /**
          * Request 및 Save 버튼의 활성화 비활성화 처리
          */        
          function setBtnEnable(procSts){
  			//Request 버튼 활성화/비활성화
  		    if(procSts!="R"){  //Ready 가 아닌 경우에는 Request 할 수 없음.				
  				btn_Request.disabled = true;
  		    }else{
  		    	btn_Request.disabled = false;
  		    }
  			
  		    //Save 버튼 활성화/비활성화
  		    if(procSts!="" && procSts!="R"){  //저장된 적이 없거나 Ready 상태가 아닌 경우에는 Request 할 수 없음.
  		    	btn_Save.disabled = true; 
  		    }else{
  		    	btn_Save.disabled = false;
  		    }        	
          }         
        
        /**
         * Ending Balance 값 다시 구하기
         */
        function computeEndBal(sheetObj){
        	var prefix = "t1sheet1_";
			var arrRowNo = sheetObj.FindSubSumRow().split(ROWMARK);  //소계행 반환
			var tmpCreditVal = sheetObj.CellValue(arrRowNo[0],prefix+"amount_credit");  //소계값 구하기
			var tmpDebitVal = sheetObj.CellValue(arrRowNo[0],prefix+"amount_debit");  //소계값 구하기
			var tmpEndingVal = ComParseInt(tmpCreditVal) - ComParseInt(tmpDebitVal);  //credit-debit

			//RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
			sheetObj.SumText(0, prefix+"seq") = (sheetObj.RowCount+1) + ""; 
			sheetObj.SumText(0, prefix+"item") = "Ending Balance";			
			if(tmpEndingVal<0){
				sheetObj.SumValue(0, prefix+"amount_debit") = Math.abs(tmpEndingVal);
				sheetObj.SumValue(0, prefix+"amount_credit") = 0;
			}else{
				sheetObj.SumValue(0, prefix+"amount_debit") = 0;
				sheetObj.SumValue(0, prefix+"amount_credit") = Math.abs(tmpEndingVal);
			}
        }
         
         /**
          * t1sheet1 의 특정 셀의 값을 편집한 직후에 발생하는 Event
          * amount_debit과 amount_create의 Other항목이 변경된 경우 합계데이터를 재계산한다.
          */
         function t1sheet1_OnAfterEdit(sheetObj, Row, Col){
        	var prefix = "t1sheet1_";
        	var tmpMsaClassCd = sheetObj.CellValue(Row, prefix+"pso_msa_amt_tp_cd");
        	var colId = sheetObj.ColSaveName(Col);
        	if(tmpMsaClassCd=="O" && (colId==prefix+"amount_debit" || colId==prefix+"amount_credit")){
        		//Total 값 다시 구하기
            	var arrRowNo = sheetObj.FindSubSumRow().split(ROWMARK);  //소계행 반환        
            	//RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수
        		//TopRow : 데이터행의 최 상단 행 index
        		//LastRow : 데이터행의 최 하단 행 index. 소계 및 합계 행 포함.
        		sheetObj.CellValue2(arrRowNo[0], Col) = sheetObj.ComputeSum("|" + Col + "|", sheetObj.TopRow, sheetObj.LastRow-2);  
        		
	        	//Ending Balance 값 다시 구하기 
	        	computeEndBal(sheetObj);
        	}
         	return;
         }
          
        /*
         * t1sheet1 값 변경 시
         */
        function t1sheet1_OnChange(sheetObj, Row, Col, Value){
         	var prefix = "sheet1_";        	 
        	var colId = sheetObj.ColSaveName(Col);
        	switch(colId){
        	    case prefix+"amount_debit":
        	    case prefix+"amount_credit":
					break;
					
				default:
					//t1sheet1 에서 어떤 컬럼에서든 onchange 발생시 dtAutoSum 컬럼에 대한 자동 계산이 일어나기 때문에 
					//default 부분에 Ending Balance 을 다시 구하도록 처리했음.
		        	//Ending Balance 값 다시 구하기 
		        	computeEndBal(sheetObj);					
					break;
        	}
        } 
         
         /*
          * t1sheet1 셀 이동시
          * row 추가시 자동 호출됨.
          */         
        function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
        	setCountReCalc(sheetObj);
        }
        
        /*
         * t1sheet1 위의 count 재계산
         * t1sheet1 조회시 호출해주어야함. row 삭제시에도 호출해주어야함.
         */         
        function setCountReCalc(sheetObj){
        	//RowCount : 소계행포함(합계행제외)한 트랜잭션(CRUD)처리된 전체 데이터 행 개수 
 			//소계전의 ROWCOUNT(전체 입력+수정+삭제 건수) 값과 소계후의 ROWCOUNT 값이 서로 다르다.
 			//따라서, CountFormat 값을 새로 셋팅했다. 합계와 소계는 레코드 개수에서 제외하기 위해서.
 			sheetObj.CountFormat = "[SELECTDATAROW / "+(sheetObj.RowCount-1)+"]";
        }
        
        
      
	/* 개발자 작업  끝 */