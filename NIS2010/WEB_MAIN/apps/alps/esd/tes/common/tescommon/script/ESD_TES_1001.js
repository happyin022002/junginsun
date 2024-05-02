/*
2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
*/

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
//					if (fm_cre_mode!=null && fm_cre_mode.trim()=='Y'){
//						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
//					}					
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
		
		/* 수동 UPLOAD BUTTON을 무조건 비활화 한다. - 자동처리된 것만 VIEW하게 함 */
//		if (!fm_cre_mode.trim()!='Y') {
//			document.all.EDILayer01.style.display = "none";
//		}

		if ( (tml_so_ofc_cty_cd!=null && tml_so_ofc_cty_cd.trim()!='' && tml_so_seq!=null && tml_so_seq.trim()!='') || 
			 (tml_edi_so_ofc_cty_cd!=null && tml_edi_so_ofc_cty_cd.trim()!='' && tml_edi_so_seq!=null && tml_edi_so_seq.trim()!='') ) {
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
                    SheetWidth = mainTable.clientWidth;

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

                    var HeadTitle = "org_file_name|save_file_name|file_size|save_path";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,  false,    "org_file_nm",     false,          "",       dfNone,   		0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,  false,    "sav_file_nm",     false,          "",       dfNone,   		0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        50,     daLeft,  false,    "file_size",     false,          "",       dfNone,   		0,     false,      false, 3);
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
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESD_TES_1001GS.do", tesFrmQryStr(formObj),"",true);
				sheetObj.LoadSearchXml(sXml); 
				break;

           case IBSEARCH_ASYNC01:
				//window.open('TESFileUpload.screen?hld_rmk_inp_nm=hld_rmk','popup_file_upload',tes_getPopupPosition(300,150)+'width=300px, height=150px, location=0, status=0, resizable=1');
				var url_str = 'TESFileUpload.screen';
				url_str += '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str += '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str += '?tml_edi_so_ofc_cty_cd='+formObj.tml_edi_so_ofc_cty_cd.value;
				url_str += '&tml_edi_so_seq='+formObj.tml_edi_so_seq.value;

				window.showModalDialog(url_str, window, "dialogWidth:510px; dialogHeight:220px; help:no; status:no; resizable:yes;");
                /*
				formObj.f_cmd.value = COMMAND24;
				var sXml = sheetObj.GetSearchXml("ESD_TES_1001GS.do", tesFrmQryStr(formObj),"",true);
				sheetObj.LoadSearchXml(sXml); 
				*/
                break;
        
		}
    }

	/**
	 * Sheet 조회후 처리. 
	 * @param {sheet}  			sheet
	 * @param {ErrMsg}  		ErrMsg
	 **/
	function sheet_OnSearchEnd(sheet, ErrMsg) {
		 /* 수동 UPLOAD BUTTON을 무조건 비활화 한다. - 자동처리된 것만 VIEW하게 함 */
//		if (sheet.RowCount > 0){
//			document.all.EDILayer01.style.display = "none";
//		} else {
//			if (fm_cre_mode.trim()=='Y') {
//				document.all.EDILayer01.style.display = "inline";
//			}
//		}
		var moveURL = "apps/alps/esd/tes/common/tescommon/jsp/inc_ESD_TES_1001.jsp?filePath="+sheetObjects[0].CellValue(1,'sav_path_nm')+"&fileName="+sheetObjects[0].CellValue(1,'sav_file_nm');
		ifr_pdf_view_main.location = moveURL; 
	}

	
	/**
	 * FILE VIEW하는 곳에서 FILE LOAD를 시도한 뒤에 호출한다. 
	 **/
	function tes_file_not_found_chk() {
		 /* 수동 UPLOAD BUTTON을 무조건 비활화 한다. - 자동처리된 것만 VIEW하게 함 */
//		if (sheetObjects[0].RowCount > 0) {
//			/** DB RECORD가 있는데 FILE NOT FOUND인 경우는 오류이므로 확인해야 한다. **/
//			document.all.EDILayer01.style.display = "none";
//		} else {
//			/** DB에 저장한 기록이 없고, FILE NOT FOUND인 경우는 새로 추가할 수 있게 한다. **/
//			if (fm_cre_mode.trim()=='Y') {
//				document.all.EDILayer01.style.display = "inline";
//			}
//		}
	}
