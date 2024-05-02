/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0032.js
*@FileTitle : SPCL CGO RSO (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.04 이도형
* 1.0 Creation
* -------------------------------------------------------- 
* History 
* 2012.01.17 서석진 [CHM-201115272] RSO 설정및 지역 본부 hard coding 로직 수정 요청
* 처리내역 :RHQ1,RHQ2 GRID 클릭시 콤보박스형태로 조회후 선택하여 저장,수정 할수있게 UI,로직 수정
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
     * @class vop_scg_0032 : vop_scg_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0032() {
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

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sStr ="";
   // var sStr ="|SHAAS|NYCNA|"; 

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

     			case "btn_RowAdd":
     				var row = sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, 2);
					break;
				
				case "btn_RowInsert":
					var row = sheetObject.DataInsert();
					sheetObject.SelectCell(row, 2);
					break; 
				
				case "btn_RowCopy":
					var row = sheetObject.DataCopy();
					sheetObject.SelectCell(row, 2);
					break;
					
				case "btn_RowDelete":					
					ComRowHideDelete(sheetObject, "del_chk");
					break;	
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
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
    	 doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	 for(i=0;i<sheetObjects.length;i++){
    		 //khlee-시작 환경 설정 함수 이름 변경
    		 ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
    	 }
     }

     function sheet1_OnLoadFinish(sheetObj) {
         //html컨트롤 이벤트초기화
         initControl();   
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;

         switch(sheetNo) {
         	case 1:      //t1sheet1 init
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 460;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msNone;

         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;

         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 1, 1, 3, 100);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(12, 0, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)

         			var HeadTitle = "|Sel.|No.|Code|Description|RHQ1|RHQ2|RHQ3|RHQ4|RHQ5|RHQ6";

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
         			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",				false,	"",     dfNone,    	0,  true,   true);
                    InitDataProperty(0, cnt++ , dtDataSeq,      30,     daCenter);
         			InitDataProperty(0, cnt++ , dtData,        	80,    daCenter,   true,	"rgn_shp_opr_cd",     	true,   "",     dfNone,		0,  false,  true, 3,	true);
         			InitDataProperty(0, cnt++ , dtData,        	250,    daLeft,	   	true,   "rgn_shp_opr_desc",		false,  "",		dfNone,    	0,  true,	true, 20);
         			InitDataProperty(0, cnt++ , dtCombo,		90,    daCenter,   true,   "rgn_shp_opr_rhq_cd1", 	false,   "",     dfNone,     0,  true,  true,	1,	true);
         			InitDataProperty(0, cnt++ , dtCombo,		90,    daCenter,   true,   "rgn_shp_opr_rhq_cd2", 	false,   "",     dfNone,     0,  true,  true,	1,	true);
         			InitDataProperty(0, cnt++ , dtCombo,		90,    daCenter,   true,   "rgn_shp_opr_rhq_cd3", 	false,   "",     dfNone,     0,  true,  true,	1,	true);
         			InitDataProperty(0, cnt++ , dtCombo,		90,    daCenter,   true,   "rgn_shp_opr_rhq_cd4", 	false,   "",     dfNone,     0,  true,  true,	1,	true);
         			InitDataProperty(0, cnt++ , dtCombo,		90,    daCenter,   true,   "rgn_shp_opr_rhq_cd5", 	false,   "",     dfNone,     0,  true,  true,	1,	true);
         			InitDataProperty(0, cnt++ , dtCombo,		90,    daCenter,   true,   "rgn_shp_opr_rhq_cd6", 	false,   "",     dfNone,     0,  true,  true,	1,	true);
    				InitDataProperty(0, cnt++ , dtHidden,      	30,	    daLeft,	   	true,   "delt_flg",  			false,  "",		dfNone,		0,	true,	true);

    	 			InitDataValid(0, "rgn_shp_opr_cd", vtEngUpOnly);
    	 			InitDataCombo(0, "rgn_shp_opr_rhq_cd1",sStr,sStr);
	        		InitDataCombo(0, "rgn_shp_opr_rhq_cd2",sStr,sStr);
	        		InitDataCombo(0, "rgn_shp_opr_rhq_cd3",sStr,sStr);
	        		InitDataCombo(0, "rgn_shp_opr_rhq_cd4",sStr,sStr);
	        		InitDataCombo(0, "rgn_shp_opr_rhq_cd5",sStr,sStr);
	        		InitDataCombo(0, "rgn_shp_opr_rhq_cd6",sStr,sStr);
         		}	
         		break;

         }
         return 1;
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
	      	case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
		        		formObj.f_cmd.value = SEARCH;
		        	   	sheetObj.DoSearch("VOP_SCG_0032GS.do", FormQueryString(formObj));		        	   	
					}
				}			
	    	   	break;
	      	case SEARCH01:      //조회
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.id == "sheet1") {
	        		formObj.f_cmd.value = SEARCH01;
	        		var sXml = sheetObj.GetSearchXml("VOP_SCG_0032GS.do", FormQueryString(formObj));	
		  		    sStr = ComGetEtcData(sXml,"ofc_n8th_lvl_cd");
				}
			}			
    	   	break;
		
			case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("VOP_SCG_0032GS.do", FormQueryString(formObj), '-1', false);
	 			break;
          					
         }
     }

  	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {    	
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE) {
  			var dupRow = sheetObj.ColValueDupRows("rgn_shp_opr_cd", false, true);
 			if(dupRow != "") {
				ComShowCodeMessage('SCG50005', 'Data');
				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
					sheetObj.SelectCell(dupRow.split("|")[1], 2);
				}else{
					sheetObj.SelectCell(dupRow.split("|")[0], 2);					
				}
				return;
			}
    	 }
         return true;
     }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function sheet1_OnChange(sheetObj,Row, Col, Value){
    	 if (sheetObj.ColSaveName(Col) == "rgn_shp_opr_cd") {
    		 var bfCode = sheetObj.CellValue(Row,"rgn_shp_opr_cd");
    		 if (bfCode != "" && bfCode.length != 3) { 
    			 ComShowCodeMessage('SCG50006', 'Code', '3');
    			 sheetObj.SelectCell(Row, Col);
    		 }

    	 }else if (sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd1") != ""||sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd2") != ""||
    	           sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd3") != ""||sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd4") != ""||
    	           sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd5") != ""||sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd6") != ""){

    	           for(i=1; i<7; i++){
    	              for(j=2; j<7; j++){
        	              if (i != j && (sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd"+i) != "" && sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd"+j) != "") && (sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd"+i) == sheetObj.CellValue(Row,"rgn_shp_opr_rhq_cd"+j))){
    	                   ComShowCodeMessage('SCG50005', 'RHQ Value');
    	                   sheetObj.CellValue(Row,Col)= "";
    	                   break;
    	                  }
    	              }
    	           }
    	 }
 			
     }

    
       

	/* 개발자 작업  끝 */