	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;


	/**
	 *  버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick = processButtonClick;

	/**
	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 **/
    function processButtonClick() {
		 var sheetObject = sheetObjects[0];
         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");
            
			switch(srcName) {
				case "btn_fileselect":
        	    break;

         	    case "btn_close":
    	            window.close();
        	    break;
            }
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
		for(var i=0; i<sheetObjects.length; i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		if ( (inv_no!=null && inv_no.trim()!='' && inv_vndr_seq!=null && inv_vndr_seq.trim()!='')  ) {
			if (sheetObjects[0].RowCount == 0) {
				/* file 경로를 조회해서 iframe에 걸어 화면에 뿌린다. */
				fileRetreive();
			}
		}
	}

	/**
     * 시트 초기설정값, 헤더 정의
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {sheetObj}  	Sheet Object
     * @param {sheetNo}  	Sheet Object 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:   //t1sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(10);
                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
                    SheetWidth = 100;


                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "file_name|save_file_name|file_size|save_path";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,  false,    "file_nm",         false,          "",       dfNone,   		0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,  false,    "sav_file_nm",     false,          "",       dfNone,   		0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        50,     daLeft,  false,    "file_size",       false,          "",       dfNone,   		0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        200,    daLeft,  false,    "sav_path_nm",     false,          "",       dfNone,   		0,     false,      false, 3);
				}
                break;
		}
    }

	/**
	 * file 경로를 조회해서 iframe에 걸어 화면에 뿌린다. 
	 **/
    function fileRetreive() {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}

	/**
     * Sheet Action 
     * @param {sheetObj}  	Sheet Object
     * @param {formObj}  	Form Object
     * @param {sAction}  	Action Command
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

		   case IBSEARCH:
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0330GS.do", TrsFrmQryString(formObj),"",true);
				sheetObj.LoadSearchXml(sXml); 
		   break;
		}
    }

	/**
	 * Sheet 조회후 처리. 
	 * @param {sheet}  			sheet
	 * @param {ErrMsg}  		ErrMsg
	 **/
	function sheet_OnSearchEnd(sheet, ErrMsg) {
		var moveURL = "apps/alps/esd/trs/invoicemanage/invoiceinquirycorrection/jsp/ESD_TRS_0340.jsp?filePath="+sheetObjects[0].CellValue(1,'sav_path_nm')+"&fileName="+sheetObjects[0].CellValue(1,'sav_file_nm');
		ifr_pdf_view_main.location = moveURL; 
	}
