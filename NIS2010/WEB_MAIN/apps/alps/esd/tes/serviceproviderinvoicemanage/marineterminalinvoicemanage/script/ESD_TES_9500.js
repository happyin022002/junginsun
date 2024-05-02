/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9500.js
*@FileTitle : Total Amount List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수된 MANUAL CNTR목록을 조회한다.
* 1.0 최초 생성
* 2014-06-19 : 박재흥 [CHM-201429999] TES: Cost Code SVXXHC Vol 계산시 TOR data참조 logic
=========================================================*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var err_flag = false;

	//2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수 조회 횟수
	var EDI_init_rtrv_cnt = 0;
	
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
         	    case "btn_close":
    	            window.close();
        	        break;
        	        
         	    case "btn_apply":
         	    	for(var i=0; i<formObject.uom.length; i++){
         	    		if(formObject.uom[i].checked==true){
         	    			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                			if (formObject.uom[i].value == "B" ) {
                        		window.returnValue=Math.floor(parseInt(sheetObjects[0].cellValue(1,"hatch_handl"))/2 );
                        		window.close();
                    		}else{
                    			window.returnValue=sheetObjects[0].cellValue(1,"hatch_handl");
                    			window.close();
                    		}
         	    			
         	    		}
         	    	}

        	        break;        	        
        	        
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet}	sheet_obj	IBsheet object
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
		 var sheetObject = sheetObjects[0];
		 var formObject = document.form;

        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * @param {ibsheet} sheetObj ==> 시트오브젝트
     * @param {int}		sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet init
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
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "STS|VVD|YD_CD|HATCH_HANDL|WORK_COMM|WORK_COMP";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,     	30,    daCenter,  true,    "vvd"   );
                    InitDataProperty(0, cnt++, dtSeq		,       30,    daCenter,  true,    "yd_cd"   							,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "hatch_handl"					,        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "work_comm"	,        false,          "",       dfNone,    0,     true ,       true );

					InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "work_comp"			,        false,          "",       dfNone,    0,     true ,       true );

               }
                break;
        }
    }



	// Sheet관련 프로세스 처리
	/**
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {form}	formObj		form object
	 * @param {String}	sAction		Action value
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:	  //조회
                formObj.f_cmd.value = SEARCH;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9500GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

        }
    }


    /** Manual RVIS의 경우,, Popup창에서 OK버튼을 눌러도 바로DB에 반영되지는 않는다.
     * opener의 rvis hidden sheet에만 관련 data가 저장되어 있기 때문에
     * popup화면 재 open시,, 유저의 작업내용을 다시 보여주기 위해, openr의 hidden sheet를
     * @param {ibsheet}	sheetObj	IBsheet object
     */
    function sheet_OnSearchEnd(sheetObj){
        var openerObj = window.dialogArguments.document.rvis_hidden;
        var formObj = document.form;
        
    	if (sheetObj.RowCount == 0) {
    		alert("No date in TOR");
    		window.close();
    	}else{
    		formObj.hatch_handl.value = sheetObj.cellValue(1, "hatch_handl");
    		formObj.work_comm.value = sheetObj.cellValue(1, "work_comm");
    		formObj.work_comp.value  = sheetObj.cellValue(1, "work_comp");
    		
    	}
    	
    }
    
	/**
	 *  rvis 수량
	 *  
	 * @return
	 */
	function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz =window.dialogArguments.document.t3sheet1.CellValue( document.form.opener_row.value, "cntr_tpsz_cd");

	    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,'rvis_ind_flg') == 1){
	            qty = parseInt(qty) + 1;
	        }
	    }

	    /**
         * UOM이 T(TEU)인 경우 volume 환산
         * return : 환산한 volume
         */
	    if(document.form.vol_tr_ut_cd.value == 'T'){
	        if(cntr_tpsz == 'D4'){
                return parseFloat(qty) * 2;
            }else if(cntr_tpsz == 'D7'){
                return parseFloat(qty) * 2.25;
            }else if(cntr_tpsz == 'D8'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'D9'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'DW'){
                return parseFloat(qty) * 2.65;
            }else if(cntr_tpsz == 'DX'){
                return parseFloat(qty) * 2.25;
            }else{
                return qty;
            }
	    }
	    return qty;
	}
