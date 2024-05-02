/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9040.js
*@FileTitle : Total Amount List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];

         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btn_ok":
    	            window.close();
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //showErrMessage("지금은 사용하실 수가 없습니다");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object
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

			setTotalAmountSheet();
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheet_obj) sheet object
     * @param(sheetNo) 	 sheet number
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "VVD|BND|Cost Code|Amount";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

							//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		          InitDataProperty(0, cnt++, dtData 	,     90,    daCenter,  true,     "vvd"      	,        false,          "",       dfNone,    0,     false,       false);
		          InitDataProperty(0, cnt++, dtData		,     90,    daCenter,  true,    "io_bnd_cd" 	,        false,          "",       dfNone,    0,     false,       false);
		          InitDataProperty(0, cnt++, dtData		,     90,    daCenter,  true,    "lgs_cost_cd"	,        false,          "",       dfNone,    0,     false,       false);
		          InitDataProperty(0, cnt++, dtHidden	,     90,    daCenter,  false,    "sum_basis"	,        false,          "",       dfNone,    0,     false,       false);
		          InitDataProperty(0, cnt++, dtAutoSum	,     90,    daCenter,  false,    "inv_amt"     ,        false,          "",      dfFloat,    2,     false,       false);

               }
                break;
        }
    }



  /** Sheet관련 프로세스 처리
  * @param(sheet_obj) 		sheet object
  * @param(formObj) 	 	form  object
  * @param(sAction) 		action 값
  */
  
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBLOADEXCEL:      //조회

                   sheetObj.LoadExcel();
                break;


        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param(sheet_obj) 		sheet object
     * @param(formObj) 	 	form  object
     * @param(sAction) 		action 값
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

        /**
         * total sheet 내용을 넣어줌  
         * @return
         */
		function setTotalAmountSheet(){
			var openerObj 		= window.dialogArguments.document;
			var openerObject 	= openerObj.total_hidden;
			
//			if(document.form.tml_inv_tp_cd.value == "ON"){				// On-Dock Charge Invoice Case
//				openerObject =openerObj.t3sheet1;
//			}else{																					// Marine Terminal Invoice Case
//				openerObject =openerObj.total_hidden;
//			}
			for(var i= openerObject.HeaderRows; i< openerObject.HeaderRows + openerObject.RowCount; i++){

				Row = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].CellValue(Row,"vvd"      ) =  openerObject.CellValue(i,"vvd"      );
				sheetObjects[0].CellValue(Row,"io_bnd_cd"   ) =  openerObject.CellValue(i,"io_bnd_cd"   );
				sheetObjects[0].CellValue(Row,"lgs_cost_cd" ) =  openerObject.CellValue(i,"lgs_cost_cd" );
				sheetObjects[0].CellValue(Row,"sum_basis" ) =  openerObject.CellValue(i,"sum_basis" );
				sheetObjects[0].CellValue(Row,"inv_amt"     ) =  openerObject.CellValue(i,"inv_amt"     );
				sheetObjects[0].ShowSubSum("sum_basis", "inv_amt", -1, true, false, -1, "vvd=VVD Amount;io_bnd_cd=VVD Amount;lgs_cost_cd=VVD Amount;");
	    	//sheetObjects[0].SubSumBackColor = sheetObjects[0].RgbColor(255,255,204);

				sheetObjects[0].RowMerge(Row) 	= true;

			}
			//sheetObjects[0].SubSumBackColor = sheetObjects[0].RgbColor(255,255,204);
			sheetObjects[0].SumBackColor  	= sheetObjects[0].RgbColor(204,204,255);
			sheetObjects[0].SumFontBold 		= true;
			sheetObjects[0].RowMerge(sheetObjects[0].RowCount) 	= true;

	}
