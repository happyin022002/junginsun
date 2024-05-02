
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;

	var opener_obj = window.dialogArguments;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btng_save":
					if (sheetObjects[0].RowCount == 0){
						ComShowMessage(ComGetMsg('TES40056')); //ComShowMessage('저장할 data가 없습니다.');
					}
					if (!ComShowConfirm('Do you want to save ?')){
						break;
					}
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg('TES21025')); //ComShowMessage(OBJECT_ERROR);
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		var formObj = document.form;
		tes_isNumD(formObj.due_dt,"Y"); 
		formObj.csr_amt.value = tes_chkAmtFmt(formObj.csr_amt.value);

		if(!ComIsNull(csr_no)){
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        } else {
			ComShowMessage(ComGetMsg('TES40015','CSR No.')); //ComShowMessage('CSR No.가 누락되었습니다.');
		}
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
                    style.height = GetSheetHeight(11);
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
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "|SEQ|Incorrect\nOnes|Invoice No.|Net Amount|Tax Amount|W.H.T.|Total Amount|Issue Date|Receive Date|Confirm Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
					InitDataProperty(0, cnt++ , dtDataSeq,       30,   daCenter,     false,    "",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtCheckBox,   60,   daCenter,     false,    "chk",               false,          "",         dfNone,         0,          true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       110,   daLeft,     false,    "inv_no",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       90,   daRight,      false,    "ttl_inv_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    
					InitDataProperty(0, cnt++ , dtData,       90,   daRight,      false,    "vat_amt",               false,          "",         dfFloat,          2,          false,          false   );
					InitDataProperty(0, cnt++ , dtData,       90,   daRight,      false,    "whld_tax_amt",               false,          "",         dfFloat,          2,          false,          false   );
					InitDataProperty(0, cnt++ , dtData,       120,   daRight,      false,    "total_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,     false,    "iss_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,     false,    "rcv_dt",               false,          "",         dfNone,         0,          false,          false   );

					InitDataProperty(0, cnt++ , dtData,       90,   daCenter,     false,    "inv_cfm_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "tml_so_ofc_cty_cd",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "tml_so_seq",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "aft_act_flg",               false,          "",         dfNone,         0,          false,          false   );

					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
               }
                break;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch4Post("ESD_TES_0025GS.do", tesFrmQryStr(formObj));
			    break;

			case IBSAVE:        //저장
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				formObj.f_cmd.value = MULTI;
				var param = sheetObj.GetSaveString(true);
				var sXml = sheetObj.GetSaveXml("ESD_TES_0025GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(sXml,true);
                break;
        }
    }

	function sheet1_OnClick(sheet1, Row,Col,Value){
		if (sheet1.ColSaveName(Col) == 'inv_no'){
//			ComShowMessage(' cell value:' + sheet1.CellValue(Row,'chk') );
		}
	}

	function sheet1_OnSaveEnd(sheet1, ErrMsg){
		if (sheet1.RowCount > 0){	
			for (var i=sheet1.HeaderRows; i<(sheet1.HeaderRows + sheet1.RowCount); i++){
				if (sheet1.CellValue(i,'aft_act_flg')!=undefined && sheet1.CellValue(i,'aft_act_flg')=='N'){
					opener_obj.retrieve();
					window.close();
					break;
				}
			}
		}
	}

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
     * MInimize 클릭시 이벤트 관련
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
            objs.style.display = "none";


            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
            sheetObjects[0].focus();
            sheetObjects[0].ViewRows  =20;

        }
        else
        {
            objs.style.display = "inline";

            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
            sheetObjects[0].focus();
            sheetObjects[0].ViewRows  =10;

        }

    }