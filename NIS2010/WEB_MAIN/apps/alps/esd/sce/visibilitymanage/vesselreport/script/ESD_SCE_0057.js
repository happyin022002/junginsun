// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;
         var opener = window.dialogArguments;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
	    		case "btns_add":
	    			addDelRow("add");
	    			break;
	
	    		case "btns_del":
	    			addDelRow("del");
	    			break;

        	    case "btn_close":
    	            self.close();
        	        break;

        	    case "btn_ok":
        	    	
        	    	//sheetObjects[1].CheckAll('chk2') = 1;
      
//                    var chkcnt = sheetObject2.CheckedRows('chk2');
//                    var iCheckRow = sheetObject2.FindCheckedRow('chk2');
//
//        	    	if(chkcnt < 1){
//        	    		ComShowMessage('Please select at least one.');
//        	    		
//        	    		return false;
//        	    	}
   	
                    doActionIBSheet(sheetObject2,formObject,IBSAVE);
        	    	opener.openerHidden();
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
    		
 			for(i=0;i<sheetObjects.length;i++){ // sheet 초기화
			//khlee-?? ?? ?? ?? ?? ??
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-??? ?? ?? ?? ??
			ComEndConfigSheet(sheetObjects[i]);
			}
 			
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); // 왼쪽 sheet 데이터 조회
 			doActionIBSheet(sheetObjects[1],document.form,SEARCH07); // 오른쪽 sheet 데이터 조회

    }
		
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,etdeta) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 15, 200);
                    
                    var HeadTitle = "Sel.|Seq.|Item Name" ;
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  false,    "chk",        false,          "",       dfNone,   	0,     true,       true);
				    InitDataProperty(0, cnt++ , dtSeq,		  50,	daCenter,    true,	"",	 false,		  "",	   dfNone,   	0,	 true,	   true);         //SEQ
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "coldesc1",        false,          "",       dfNone,   	0,     false,       true);
                    
                                       
               }
                break;
                
                
            case 2:      //IBSheet2 init
        		with (sheetObj) {
        			// 높이 설정
        			style.height = GetSheetHeight(10) ;

        			// 전체 너비 설정
        			SheetWidth = mainTable.clientWidth;

        			// Host정보 설정[필수][HostIp, Port, PagePath]
        			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

        			// 전체Merge 종류 [선택, Default msNone]
        			MergeSheet = msNone;

        			// 전체Edit 허용 여부 [선택, Default false]
        			Editable = true;

        			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        			InitRowInfo(1, 1, 5, 100);

        			var HeadTitle = "Sel.|Seq.|Selected Items";
        			var headCount = ComCountHeadTitle(HeadTitle);

        			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        			InitColumnInfo(headCount, 0, 0, true);

        			// 해더에서 처리할 수 있는 각종 기능을 설정한다
        			InitHeadMode(true, true, true, true, false, false);

        			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        			InitHeadRow(0, HeadTitle, true);

        			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, false, "chk2");
        			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
        			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "coldesc2", false, "", dfNone, 0, false, false);

        		}
        		break;

        } 
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //왼쪽 화면 조회  
        	   
    		formObj.f_cmd.value = SEARCH06;
    		sheetObj.DoSearch4Post("ESD_SCE_0057GS.do", SceFrmQryString(formObj));

    		break;
    		
           case SEARCH07:      //오른쪽 화면 조회  
        	   
       		formObj.f_cmd.value = SEARCH07;
       		sheetObj.DoSearch4Post("ESD_SCE_0057GS.do", SceFrmQryString(formObj));

       		break;
           
           case IBSAVE:		   //저장
               formObj.f_cmd.value = MULTI;
               sheetObj.DoAllSave("ESD_SCE_0057GS.do", SceFrmQryString(formObj));                
           break;
        
        }      
    }


    function openColumnList(){
    	var formObject = document.form;
    	var edi_grp_cd = toUpperCase(formObject.cs_grp_id.value);
    	window.open ("ESD_SCE_0057.do?edi_grp_cd=" + edi_grp_cd , "list", "scrollbars=no,fullscreen=no,width=765,height=450");
    }   
    
    /**
     * row 추가/삭제
     */
    function addDelRow(type) {

    	if (type == "add") { // 추가 'add' 버튼 클릭 시

    		for ( var i = 1; i < sheetObjects[0].RowCount + 1; i++) {

    			if (sheetObjects[0].CellValue(i, 0) == '1') {
    				var chkValue = true;	// flag
    				for ( var j = 1; j < sheetObjects[1].RowCount + 1; j++) {
    					if (sheetObjects[0].CellValue(i, "coldesc1") == sheetObjects[1].CellValue(j, "coldesc2")) { // 오른쪽 화면에 이미 있는 항목일 경우
    						chkValue = false;
    						break;
    					}
    				}
    				if (chkValue) {	// 오른쪽 화면에 없는 항목을 추가할 경우
    					var row = sheetObjects[1].DataInsert(-1); // 마지막 행에 데이터 생성 후 row 값 반환
    					sheetObjects[1].CellValue2(row, "coldesc2") = sheetObjects[0].CellValue(i, "coldesc1"); // 해당되는 데이터를 오른쪽 화면 반환된 row(마지막 행)에 추가
    				} else {
    					// alert("exist same data");
    				}
    			}
    		}
    	} else { // 삭제 'delete' 버튼 클릭 시
    		var idx = sheetObjects[1].RowCount;
    		for ( var i = 1; i < idx + 1; i++) {
    			for ( var j = 1; j < sheetObjects[1].RowCount + 1; j++) {
    				if (sheetObjects[1].CellValue(j, 0) == '1') { // 체크된 j행
    					sheetObjects[1].RowDelete(j, false); // j행 삭제
    				}
    			}
    		}
    	}
    }

