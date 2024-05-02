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
         /*******************************************************/
         var formObject = document.form;
         var opener = window.dialogArguments;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_close":
    	            self.close();
        	        break;

        	    case "btn_ok":
                    var chkcnt = sheetObject.CheckedRows(0);
        	    	if(chkcnt < 1){
        	    		ComShowMessage('Select check item');
        	    		return false;
        	    	}
        	    	var chkrow = 0;
        	    	var edi_sts = '';
        	    	var cust_sts = '';
        	    	for(var a = 0 ; a < chkcnt ; a++){
        	    		chkrow = sheetObject.FindCheckedRow(0).split('|')[a];
        	    		if(a == 0){
        	    			edi_sts = sheetObject.CellValue(chkrow, "stnd_cd");
        	    		}else{
        	    			edi_sts = edi_sts + ',' + sheetObject.CellValue(chkrow, "stnd_cd");
        	    		}
        	    	}
        	    	
                    // 2010-03-21 edi_sts 중복 수정 시작
					var ediStsArray = edi_sts.split(",");
					var str = "";
					for(var i=0; i<ediStsArray.length; i++){
						var cnt = 0;							
						for(var k=0; k<ediStsArray.length; k++){
							if(ediStsArray[i] == ediStsArray[k]){
								cnt++;
							}
						}
						if( i== 0){
							str += ediStsArray[i];								
						}else{
							if(cnt == 2){
								if(str.indexOf(ediStsArray[i]) == -1){
									str += ","+ediStsArray[i];									
								}
							}else{
								str += ","+ediStsArray[i];		
							}								
						}
					}
					edi_sts = str;
					
                    // 2010-03-21 edi_sts 중복 수정 끝
					
                    var diff = formObject.diff.value
                    
                    if(diff == 1){
                        for(var a = 0 ; a < chkcnt ; a++){
                            chkrow = sheetObject.FindCheckedRow(0).split('|')[a];
                            if(a == 0){
        	    			    cust_sts = sheetObject.CellValue(chkrow, "cust_cd");
            	    		}else{
            	    			cust_sts = cust_sts + ',' + sheetObject.CellValue(chkrow, "cust_cd");
            	    		}
                        }



                    }                    

                    if(diff == 1){
                        opener.addEdiStsNo(edi_sts,cust_sts);
                    } else {
                        opener.addEdiStsNo(edi_sts);
                    }
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        // 초기화면에서 조회내용을 보기 위한 소스 추후 삭제
         var sheetObject = sheetObjects[0];
         var formObject = document.form;
        //alert(formObject.edi_grp_cd.value);
      	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                    style.height = GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					
                    var HeadTitle = "|EDI Status|Description|CUST Status" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       170,    daCenter,  false,    "stnd_cd",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      170,    daLeft,  false,    "cs_desc",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      170,    daLeft,  false,    "cust_cd",        false,          "",       dfNone,       0,     false,       true);
               }
                break;

        } 
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회              
                formObj.f_cmd.value = SEARCH;                
                selectVal = SceFrmQryString(formObj);
                //alert("IBSEARCH["+selectVal+"]");
                sheetObj.DoSearch4Post("ESD_SCE_0067GS.do", selectVal); 
           break;
        }
           
    }

