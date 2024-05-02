	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_close":
					  window.close();
				  break;
				  
				case "btn_EDIinvoiceview":
					var url_str = 'ESD_TES_1001Popup.screen';
					url_str += '?tml_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_ofc_cty_cd');
					url_str += '&tml_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_seq');
//					alert('url_str: '+url_str);
					window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
					break;				  

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('ES23028')); //ComShowMessage(OBJECT_ERROR);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet} sheet_obj	ib sheet object
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
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		var formObj = document.form;
		//tes_isNumD(formObj.due_dt,"Y"); 
		//formObj.csr_amt.value = tes_chkAmtFmt(formObj.csr_amt.value);

		if(!ComIsNull(csr_no)){
			doActionIBSheet1(sheetObjects[1],formObj,IBSEARCH);
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        } else {
			ComShowMessage(ComGetMsg('TES40015','CSR No.')); //ComShowMessage('CSR No.가 누락되었습니다.');
		}
    }


     /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {int}		sheetNo		sheet number
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1: 
                with (sheetObj) {
                    style.height=GetSheetHeight(11);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1,10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|SEQ|Invoice No.|Yard|Net Amount|Tax Amount|W.H.T.|Total Amount|Issue Date|Receive Date|Confirm Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
					InitDataProperty(0, cnt++ , dtDataSeq,       30,   daCenter,     false,    "",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       110,   daLeft,     false,    "inv_no",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     false,    "yd_cd",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       100,   daRight,      false,    "ttl_inv_amt",               false,          "",         dfFloat,          2,          false,          false   );
					InitDataProperty(0, cnt++ , dtData,       100,   daRight,      false,    "vat_amt",               false,          "",         dfFloat,          2,          false,          false   );

					InitDataProperty(0, cnt++ , dtData,       100,   daRight,      false,    "whld_tax_amt",               false,          "",         dfFloat,          2,          false,          false   );
					InitDataProperty(0, cnt++ , dtData,       120,   daRight,      false,    "total_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,     false,    "iss_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,     false,    "rcv_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,     false,    "inv_cfm_dt",               false,          "",         dfNone,         0,          false,          false   );

					InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "tml_so_ofc_cty_cd",               false,          "",         dfNone,         0,          false,          false   );
					InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "tml_so_seq",               false,          "",         dfNone,         0,          false,          false   );
					InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "edi_flg",               false,          "",         dfNone,         0,          false,          false   );
					InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "file_chk",               false,          "",         dfNone,         0,          false,          false   );					
					
                }
                break;

             case 2: 
                with (sheetObj) {
	                // 높이 설정
                    style.height = GetSheetHeight(13);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|No of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|ASA No." ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
					InitDataProperty(0, cnt++ , dtData,	150, daCenter,			false,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daCenter,			false,    "vndr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData, 150, daLeft,			false,    "inv_desc",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	40, daCenter,			false,    "no_of_inv",				false,			"",			dfNone,			0,			false,			false	);					

					InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "csr_curr_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daRight,			false,    "csr_amt",				false,			"",			dfFloat,			2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,		    false,    "due_dt",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,			false,    "attr_ctnt2",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "iss_dt",				false,			"",			dfNone,			0,			false,			false	);

					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "rcv_dt",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "vndr_term_nm",				false,			"",			dfNone,			0,			false,			false	);
			   }
                break;
        }
    }

    /** Sheet관련 프로세스 처리
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch4Post("ESD_TES_0101GS.do", tesFrmQryStr(formObj));
			    break;
        }
    }
    
    /**
     * 
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
     * @return
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST01;
			    sheetObj.DoSearch4Post("ESD_TES_0101GS.do", tesFrmQryStr(formObj));
			    break;
        }
    }
    
     /**
      * onclick event처리
      * @param sheetObj
      * @return
      */
  	function sheet1_OnClick(sheetObj){
		try {
	  		if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y' && sheetObj.CellValue(sheetObj.SelectRow,'file_chk') == 'Y') {
	  			document.all.EDILayer01.style.display = "inline";
	  		} else {
	  			document.all.EDILayer01.style.display = "none";
	  		}
		} catch (e){
		}   		
  	}

      /**
       * OnSelectCell event처리
       * @param sheetObj
       * @return
       */
   	function sheet1_OnSelectCell(sheetObj){
		try {
	   		if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y' && sheetObj.CellValue(sheetObj.SelectRow,'file_chk') == 'Y') {
	   			document.all.EDILayer01.style.display = "inline";
	   		} else {
	   			document.all.EDILayer01.style.display = "none";
	   		}
		} catch (e){
		}   		
   	}

    /**	sheet2_OnSearchEnd
     * 
     * @param {ibsheet} sheet2	ibsheet ojbect
     * @param {String}  ErrMsg	err message
     * @return
     */
	function sheet2_OnSearchEnd(sheet2, ErrMsg){
		if (sheet2.RowCount > 0){	
			document.form.vndr_no.value      = tes_lpad(sheet2.CellValue(1,'vndr_no'),6,"0") ;
			document.form.inv_desc.value     = sheet2.CellValue(1,'inv_desc');
			document.form.no_of_inv.value    = sheet2.CellValue(1,'no_of_inv');
			document.form.csr_curr_cd.value  = sheet2.CellValue(1,'csr_curr_cd');
			document.form.csr_amt.value      = sheet2.CellValue(1,'csr_amt');
			document.form.attr_ctnt2.value   = sheet2.CellValue(1,'attr_ctnt2');
			document.form.iss_dt.value       = sheet2.CellValue(1,'iss_dt');
			document.form.rcv_dt.value       = sheet2.CellValue(1,'rcv_dt');
			document.form.vndr_term_nm.value = sheet2.CellValue(1,'vndr_term_nm');
			document.form.due_dt.value       = sheet2.CellValue(1,'due_dt');
			//tes_isNumD(document.form.due_dt,"Y"); 
			document.form.csr_amt.value = tes_chkAmtFmt(document.form.csr_amt.value);
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value     
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }