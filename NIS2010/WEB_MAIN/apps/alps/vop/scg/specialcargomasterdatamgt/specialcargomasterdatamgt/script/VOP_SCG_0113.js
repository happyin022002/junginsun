/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0034.js
*@FileTitle : Partner’s Contact Point for SPCL CGO (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이도형
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

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
					break;
					
				case "btn_RowDelete":
					if (ComIsBtnEnable("btn_RowDelete")) ComRowHideDelete(sheetObject, "del_chk");
					break;	
				
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
					
				case "btn_Close":
					window.close();
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
		 
    	 for(i=0;i<sheetObjects.length;i++){
	    	 //khlee-시작 환경 설정 함수 이름 변경
    		 ComConfigSheet (sheetObjects[i] );
    		 initSheet(sheetObjects[i],i+1);
    		 //khlee-마지막 환경 설정 함수 추가
	         ComEndConfigSheet(sheetObjects[i]);
	     } 
    	 
    	 var sheetObject = sheetObjects[0];
		 var formObject = document.form;
		 doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
         			style.height = 250;
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
         			InitColumnInfo(4, 0, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(true, true, false, true, false,false)

         			var HeadTitle = "|Sel.|POL|E-mail|";

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
         			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",				false,	"",      dfNone,    0,     true,	true);   
         			InitDataProperty(0, cnt++ , dtData,        	80,    	daCenter,	true,   "pol_cd",				false, 	"",      dfNone,    0,     true,    true,   5);
         			InitDataProperty(0, cnt++ , dtData,        	310,    daLeft,	   	true,   "cntc_pson_eml_ctnt",	false, 	"",      dfNone,    0,     true,    true);
                
         			InitDataValid(0, "pol_cd", vtEngUpOnly);
         		}
         		break;
         }
     }
     
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
             case IBSEARCH:
            	 formObj.f_cmd.value = SEARCH;
            	 sheetObj.DoSearch("VOP_SCG_0113GS.do", FormQueryString(formObj));
            	 
            	 break;
            	 
             case IBSAVE:
            	 formObj.f_cmd.value = MULTI;
            	 sheetObj.DoSave("VOP_SCG_0113GS.do", FormQueryString(formObj), '-1', false);
            	 
            	 break;
         }
     }

//  	
//    /**
//     * IBSheet Object에서 입력값이 변경된 경우
//     */
//	function sheet1_OnChange(sheetObj, Row, Col, Value){
//
//		var code = Value;
//		if (sheetObj.ColSaveName(Col) == "pol_cd" && code !="") {
//
//		}
//	}
     