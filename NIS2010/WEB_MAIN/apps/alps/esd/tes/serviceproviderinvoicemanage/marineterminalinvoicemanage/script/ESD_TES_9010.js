// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0 ;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/** processButtonClick
	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var sheetObject  = sheetObjects[0];
        var formObject = document.form;

    	try {
    	    var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btn_verify":
         	    	//[CHM-201642186]Upload 이후 Cost Code 또는 Cntr No이 없는 경우 해당 라인을 삭제하는 로직을 추가 2016-06-23
         	    	delBlkRows(sheetObject);
         	    	
         	        verifyContainerList();
         	        if(formObject.verify_chk.value == null || formObject.verify_chk.value =="" || formObject.verify_chk.value != "Y"){
         	            ComShowMessage(ComGetMsg('TES22602')); //ComShowMessage("Verify를 수행하지 않았습니다.");
         	            return false;
         	        }
//         	    	var openerSheetObj1 = window.dialogArguments.document.t1sheet1; // Coincidence
//	    	        var openerSheetObj2 = window.dialogArguments.document.t2sheet1; // Discrepancy
        	        break;

         	    case "btn_loadexcel":
					// eBilling - B
					if (window.dialogArguments.document.form.edi_flg.value == 'Y'){
						return false;
					}
					// eBilling - E
         	        if(ComGetObjValue(formObject.file_import_yn) != "Y"){
         	            ComShowMessage("Please select YES at File Import.");
         	    		return false;
         	    	}
    	            doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        	        break;

         	    case "btn_chkdigit":
        	        if(sheetObject.RowCount > 0){
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
                    }
        	        break;

         	    case "btn_rowadd":
        	        if(ComGetObjValue(formObject.file_import_yn) == "Y"){
        	            ComShowMessage('Select NO at File Import to use this function');
        	            return false;
        	        }
                    // CHM-201641075 Get CNTR List화면에서 Multi-Row Add기능 추가 - 2016-04-15
					for (var i = 0; i < formObject.rowsadd.value; i++) {
	        	        var row = sheetObject.DataInsert(-1);
	        	        sheetObject.CellValue(row,'io_bnd_cd') = formObject.io_bnd_cd.value;
					}

        	        break;

         	    case "btn_rowdel":
        	        formObject.excel_chk.value = 'N';
//        	        sheetObject.RowDelete(sheetObject.SelectRow , false);

        	        var selectedRow = sheetObject.GetSelectionRows('|').split('|');
        	        for(var i=selectedRow.length-1; i>=0; i--){
        	            sheetObject.RowDelete(selectedRow[i], false);
        	        }
        	        break;

         	    case "btn_retrieve":
         	        if(formObject.wo_no.value == '' || formObject.wo_no.value == null){
         	            ComShowMessage("Please enter W/O No.");
         	    		return false;
         	    	}
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);
        	        break;

         	    case "btn_close":
    	            window.close();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i< comboObjects.length;i++){
            initCombo (comboObjects[i],i+1);
        }
    	
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initValue(window.dialogArguments.document.form, document.form);

        
        /** [CHM-201429211] calling port의 yard가 복수일 경우 port값과 calling이 되는 port의 모든 yard를 combo에 뿌리고 사용자에 의해 선택가능하게 한단다.(털보 요청)  **/
//        alert('CLPT_YD_KNT: ' + CLPT_YD_KNT + '\n VRFY_TERMINAL_LIST: ' + VRFY_TERMINAL_LIST);
//        if (CLPT_YD_KNT!=null && !isNaN(CLPT_YD_KNT) && parseInt(CLPT_YD_KNT,10)>1) {
//            var VRFY_TERMINAL_DEF	= document.form.yd_cd.value!=null&&document.form.yd_cd.value!=''?document.form.yd_cd.value.substring(0,5):'';
//            if (VRFY_TERMINAL_LIST!=null) {
//            	initCombo(comboObjects[0], 1, VRFY_TERMINAL_LIST, VRFY_TERMINAL_DEF);
//            	document.all.vrfy_terminal.style.display = "inline";
//            	alert("In case of double berthing, select correct yard code to get container list");
//            } else {
//            	document.all.vrfy_terminal.style.display = "none";
//            	comboObjects[0].RemoveAll();
//            }
//        } else {
//        	document.all.vrfy_terminal.style.display = "none";
//        }
        
    }
    
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param (object)	combo_obj	combo object
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /** Combo 기본 설정 
     *  Combo의 항목을 설정한다.
     * @param {comoObj}	comboObj	combo Object
     * @param {int}		comboNo 	combo no
     * @param {String}	combo_val 	combo value
     * @param {String}	def_val 	def value
     */ 
    function initCombo (comboObj, comboNo, combo_val, def_val) {
        var cnt  = 0 ;
        switch(comboNo) {
            case 1:
                with (comboObj) {
                    SetColAlign('left');
					SetColWidth('50');
					DropHeight=150;

					var tmp = '';
					if (combo_val!=null){tmp = combo_val.split('|');}
					for (var i=0; tmp!=null && i<tmp.length; i++){
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					if (def_val!=undefined && def_val!=null && def_val.trim()!=''){
						Code = def_val;
					} else {
						Code = '';
					}
				}
                break;
         }
    }
    
    /** sheet 초기화 
     * 
     * @param openerObj		opener object
     * @param formObj		from	object
     * @return
     */ 
	function initValue(openerObj, formObj){//alert("vvd_type===>"+openerObj.vvd_type.value);
		formObj.vvd.value    = openerObj.vvd.value;
		formObj.vvd_type.value = openerObj.vvd_type.value;
		formObj.io_bnd_cd.value = openerObj.io_bnd_cd.value;  
		formObj.vndr_seq.value  = openerObj.vndr_seq.value;
		formObj.yd_cd.value     = openerObj.yd_cd.value;
		formObj.rcv_dt.value    = openerObj.rcv_dt.value;
		formObj.iss_dt.value    = openerObj.iss_dt.value;
		formObj.tml_so_ofc_cty_cd.value = openerObj.tml_so_ofc_cty_cd.value;
		formObj.tml_so_seq.value = openerObj.tml_so_seq.value;
		formObj.atb_dt.value = openerObj.atb_dt.value;
		formObj.call_yd_ind_seq.value = openerObj.call_yd_ind_seq.Code;
		formObj.clpt_ind_seq.value = openerObj.clpt_ind_seq.value;
		formObj.file_import_yn[0].checked = true;
		formObj.hjs_list_yn[0].checked = true;
		formObj.manual_input_yn[0].checked = true;
		formObj.manual_input_yn[0].disabled = true;
		formObj.manual_input_yn[1].disabled = true;
		formObj.import_tp_all.checked = true;
		formObj.import_ts_tp[0].checked = false;
		formObj.import_ts_tp[1].checked = false;
		formObj.import_fm_tp[0].checked = false;
		formObj.import_fm_tp[1].checked = false;
		formObj.import_tp_all.disabled = true;
		formObj.import_ts_tp[0].disabled = true;
		formObj.import_ts_tp[1].disabled = true;
		formObj.import_fm_tp[0].disabled = true;
		formObj.import_fm_tp[1].disabled = true;
		ComEnableObject(formObj.wo_no, false);

//alert("formObj.vvd_type.value===>"+formObj.vvd_type.value);
		
		if(formObj.vvd_type.value == "H" || formObj.vvd_type.value == "C"){
        	formObj.file_import_yn[0].checked  = true;
        } // 조회값이 B일 경우 :  File Import Radio Button의 'Yes'를 Default Check하고 'No'는 비활성화(선택할 수 없음)
        else if(formObj.vvd_type.value == "B"){
            formObj.file_import_yn[0].checked  = true;
            formObj.file_import_yn[1].disabled = true;
    	}

		// eBilling ----- B
    	if(openerObj.edi_flg.value == 'Y'){
    	    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
    	}
		// eBilling ----- E
    	
    	//doubling Calling check
    	if(formObj.yd_cd.value != '' && formObj.vvd.value != ''){
    		tes_getInputValue('call_yd_seq_chk', SEARCH24, 'yd_cd|vvd');
    	}
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * @param : sheetObj ==> 시트오브젝트, 
     * @param : sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
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
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "Status|Seq|CNTR No.|Type/Size|F/M|I/O|Working Date|Remark";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 20,    daCenter,  false,   "ibflag"			  ,	false,          "",       dfNone,    0,     false,      true);
                    InitDataProperty(0, cnt++, dtDataSeq,    	30,    daCenter,  true,    ""        		  ,	false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData	,      100,    daCenter,  true,    "cntr_no"          , false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtCombo	,       70,    daCenter,  true,    "cntr_tpsz_cd"     , false,          "",       dfNone,    0,     false,      true);
                    InitDataProperty(0, cnt++, dtCombo	,       35,    daCenter,  false,   "cntr_sty_cd"      , false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtCombo	,       35,    daCenter,  false,   "io_bnd_cd" 		  , false,          "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++, dtData	,       80,    daCenter,  false,   "wrk_dt"			  ,	false,          "",       dfNone,    0,     true,       true,  8);
                    InitDataProperty(0, cnt++, dtData	,       60,    daCenter,  false,   "remark"			  ,	false,          "",       dfNone,    0,     false,      false);
                    
                    InitDataCombo(0 , "cntr_sty_cd"		, cntr_sty_cdCode	     , cntr_sty_cdCode);
                    // Data 정제 작업 일환으로 Combo로 수정 ( 2009-09-01 )
                    InitDataCombo(0 , "io_bnd_cd"		, io_bnd_cdCode		, io_bnd_cdCode);
                    InitDataCombo(0 , "cntr_tpsz_cd" , document.form.cntr_tpsz_cd.value, document.form.cntr_tpsz_cd.value);
                    
                    InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");

                    // 데이타 Count format [선택한포커스행/전체건수] 로 적용
 					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
               }
               break;
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

    /** vefify 적용
     * 
     * @return
     */ 
    function verifyContainerList(){
        var formObj = document.form;

        if(formObj.import_tp_all.checked == true){
            formObj.all_tp.value = 'Y';
        }else{
            formObj.all_tp.value = 'N';
        }

        formObj.fm_tp.value = '';
        formObj.ts_tp.value = '';
        
        for(var i=0; i<2; i++){
            if(formObj.import_fm_tp[i].checked == true){
                formObj.fm_tp.value = formObj.fm_tp.value + formObj.import_fm_tp[i].desc;
            }
            if(formObj.import_ts_tp[i].checked == true){
                formObj.ts_tp.value = formObj.ts_tp.value + formObj.import_ts_tp[i].desc;
            }
        }

		if(ComGetObjValue(formObj.file_import_yn) == "N"){
		    for(var i=sheetObjects[0].HeaderRows ; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
		    
			     sheetObjects[0].RowFontColor(i) = sheetObjects[0].RgbColor(0, 0, 0);
			     if(sheetObjects[0].CellValue(i,"remark") == 'Duplicate'){
			         sheetObjects[0].CellValue(i,"remark") = '';
			         
			     }
			     
		    }
		    
		    if(ComGetObjValue(formObj.manual_input_yn) == "N"){
		        //  W/O No로 조회한 Container 가 없는경우 SML List Only를 검색한다.
		        if(sheetObjects[0].RowCount == 0){
		            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
		        }else{
		            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		        }
		    }else{
		        if(sheetObjects[0].RowCount < 1){
		            ComShowMessage('Please insert CNTR information');
		            return false;
		        }
		        if(validateManualInput() == false){
		            return false;
		        }
		        if(mandatoryCheck() == false){
		            return false;
		        }
		        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		    }
		}else{

		    /**
		     * row delete 기능 추가.
		     * Excel Load시 sheet_OnLoadExcel(sheet)를 수행하지만,
		     * row delete기능을 수행했거나 Column에 값 수정이 발생한경우
		     * formObj.excel_chk.value 값이 'N'으로 변한다.
		     * 이 경우 다시한번 sheet_OnLoadExcel를 수행하도록 수정함
		     */
		    if(formObj.excel_chk.value == "N"){

		        sheet_OnLoadExcel(sheetObjects[0]);
		    }
		    if(sheetObjects[0].RowCount < 1){
		        ComShowMessage(ComGetMsg('TES40017')); //ComShowMessage("File이 Import가 되지않았습니다.");
		        return false;
		    }
		    if(formObj.excel_chk.value == "N"){
		        ComShowMessage(ComGetMsg('TES22601')); //ComShowMessage("EXCEL FILE SOURCE DATA가 잘못되었습니다.");
		        return false;
		    }


		    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		}
		formObj.verify_chk.value="Y";
    }

    /** Sheet관련 프로세스 처리
     *  @param sheetObj 	sheet 	Object
     *  @param formObj 		form 	Object
     *  @param sAction 		sAction Object
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            //SML List Only VERIFY
            case IBSEARCH_ASYNC03:      			//조회
                formObj.f_cmd.value = SEARCH03;
                var saveXml = sheetObj.GetSearchXml("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                //ComShowMessage(searchXml);
				if (saveXml != "") sheetObj.LoadSaveXml(saveXml,true);
                break;

            //Check Digit
            case IBSEARCH_ASYNC01:      			//조회
                formObj.f_cmd.value = SEARCH01;
            	//alert("SEARCH01:"+SEARCH01);
                var param = sheetObj.GetSaveString(false,false);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9010GS.do", param +'&'+ tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                //ComShowMessage(searchXml);
				if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;

            //Manual Input File Verify
            case IBSEARCH_ASYNC02:      			//조회
                formObj.f_cmd.value = SEARCH02;
            	//alert("SEARCH02:"+SEARCH02);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
				if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;

            //Work Order Calling
            case IBSEARCH_ASYNC04:      			//조회
                formObj.f_cmd.value = SEARCH04;
            //alert("SEARCH04:"+SEARCH04);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                //ComShowMessage(searchXml);
				if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBLOADEXCEL:      //조회
           		sheetObj.RemoveAll();
                sheetObj.LoadExcel(-1);
//                checkExcelData(sheetObj);
//				formValue2Sheet(sheetObj);
                break;

            //FILE VERIFY
            case IBSEARCH:      			//조회
                formObj.f_cmd.value = SEARCH;
		        var param = sheetObj.GetSaveString(true);
		        var saveXml = sheetObj.GetSearchXml("ESD_TES_9010GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.RemoveAll();
				//ComShowMessage(searchXml);
				if (saveXml != "") sheetObj.LoadSaveXml(saveXml,true);
                break;
        }
    }

    /** doActionIBSheet1
     * 
     * @param sheetObj 	sheetObj value
     * @param formObj	formObj value
     * @param sAction	Action value
     * @return
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      			//조회
                formObj.f_cmd.value = SEARCH03;
                //alert("SEARCH03:"+SEARCH03);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                //ComShowMessage(searchXml);
				if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;
        }
    }
    
    /** 저장후 메시지 보여줌
     * 
     * @param sheetObj
     * @return
     */
    function sheet_OnSaveEnd(sheetObj){
    	window.close();
        window.dialogArguments.fileimp();
        var count = parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount);
		ComShowMessage(count+ComGetMsg('TES40043')); //ComShowMessage((parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount))+ '건의 List가 verify완료되었습니다.');
        
    }
    
    /** sheet 변경후 
     * 
     * @param sheetObj	
     * @param row
     * @param col
     * @param value
     * @return
     */
    function sheet_OnChange(sheetObj, row, col, value) {
        if (sheetObj.ColSaveName(col) == 'cntr_no' || sheetObj.ColSaveName(col) == 'cntr_tpsz_cd'
           || sheetObj.ColSaveName(col) == 'cntr_sty_cd' || sheetObj.ColSaveName(col) == 'wrk_dt' ){
            document.form.excel_chk.value = 'N';
        }
    }


    /** excel 로드
     * 
     * @param sheetObj
     * @return
     */
    function sheet_OnLoadExcel(sheetObj){

		//[CHM-201642186]Upload 이후 Cost Code 또는 Cntr No이 없는 경우 해당 라인을 삭제하는 로직을 추가 2016-06-23
		delBlkRows(sheetObj);
		
		document.form.excel_chk.value="Y";
		

	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
	 		
	 		//alert(sheetObj.HeaderRows);
	 		// Data 정제 작업 일환으로 대문자로 변경 ( 2009-09-01 )
	 		sheetObj.CellValue(i, "cntr_tpsz_cd")	= sheetObj.CellText(i, "cntr_tpsz_cd").toUpperCase();
	 		sheetObj.CellValue(i, "cntr_sty_cd")	= sheetObj.CellText(i, "cntr_sty_cd").toUpperCase();
	 		sheetObj.CellValue(i, "io_bnd_cd")	= sheetObj.CellText(i, "io_bnd_cd").toUpperCase();

	 		if(sheetObj.CellValue(i, "cntr_no").length == 0 || !ComIsAlphabet(sheetObj.CellValue(i, "cntr_no"), "n")){
	 			sheetObj.CellBackColor(i, "cntr_no") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 			sheetObj.CellValue(i,"remark") = 'CNTR No.';
	 		}
 		
	 		if(sheetObj.CellValue(i, "cntr_sty_cd").length != 1 || !(sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "M"
	 		                                                      || sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "F")){
	 			sheetObj.CellBackColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 			sheetObj.CellValue(i,"remark") = 'Full/Empty';
	 		}

	 		if(sheetObj.CellValue(i, "io_bnd_cd").length != 1 || !(sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() == "I"
	 			||sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() == "O")
	 			||sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() != document.form.io_bnd_cd.value){
	 			
	 			//alert(sheetObj.CellBackColor(i, "io_bnd_cd"));
	 			sheetObj.CellBackColor(i, "io_bnd_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "io_bnd_cd") = sheetObj.RgbColor(255, 0, 0);	   // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 			sheetObj.CellValue(i,"remark") = 'Bound';
	 			
	 		}

	 		if(!ComIsDate(sheetObj.CellValue(i, "wrk_dt"))){
	 			sheetObj.CellBackColor(i, "wrk_dt") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "wrk_dt") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 			sheetObj.CellValue(i,"remark") = 'Working Date';
	 		}
	 		
		}

		var Rows;
		Rows = sheetObj.ColValueDupRows("cntr_no");
		var arr_rows = Rows.split(',');
		for (var i=0; arr_rows!='' && i<arr_rows.length; i++){
			sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255, 0, 0);
			document.form.excel_chk.value="N";
			sheetObj.CellValue(arr_rows[i],"remark") = 'Duplicate';
		}
	}

    /** sml_list_only sts 보여줌
     * 
     * @return
     */
	function sml_list_only_sts(){
	    var formObj = document.form;
	    if(formObj.file_import_yn[0].checked  == true){
	        formObj.hjs_list_yn[0].disabled = false;
	        formObj.hjs_list_yn[1].disabled = false;
	        formObj.manual_input_yn[0].disabled = true;
	        formObj.manual_input_yn[1].disabled = true;

    		formObj.import_tp_all.disabled = true;
    		formObj.import_ts_tp[0].disabled = true;
    		formObj.import_ts_tp[1].disabled = true;
    		formObj.import_fm_tp[0].disabled = true;
    		formObj.import_fm_tp[1].disabled = true;
    		ComEnableObject(formObj.wo_no, false);
	    }else{
//	        if(formObj.manual_input_yn[0].checked == true){
//	            formObj.hjs_list_yn[0].disabled = false;
//	            formObj.hjs_list_yn[1].disabled = false;
//    	        formObj.manual_input_yn[0].disabled = false;
//    	        formObj.manual_input_yn[1].disabled = false;
//	        }else{
    	        formObj.hjs_list_yn[1].checked  = true;
    	        formObj.hjs_list_yn[0].disabled = true;
    	        formObj.hjs_list_yn[1].disabled = true;
    	        formObj.manual_input_yn[0].disabled = false;
    	        formObj.manual_input_yn[1].disabled = false;

    	        if(formObj.manual_input_yn[0].checked == true){
            		formObj.import_tp_all.disabled = true;
            		formObj.import_ts_tp[0].disabled = true;
            		formObj.import_ts_tp[1].disabled = true;
            		formObj.import_fm_tp[0].disabled = true;
            		formObj.import_fm_tp[1].disabled = true;
            		ComEnableObject(formObj.wo_no, false);
    	        }else{
            		formObj.import_tp_all.disabled = false;
            		formObj.import_ts_tp[0].disabled = false;
            		formObj.import_ts_tp[1].disabled = false;
            		formObj.import_fm_tp[0].disabled = false;
            		formObj.import_fm_tp[1].disabled = false;
            		ComEnableObject(formObj.wo_no, true);
    	        }

//	        }
	    }
	}
	
	/** mandatoryCheck
	 *  cntr no 검사 
	 * @return
	 */
	function mandatoryCheck(){
	    var sheetObj  = sheetObjects[0];
	    var err_flag = false;
	    for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,'cntr_no').length == 0 ){
	            ComShowMessage('Please input CNTR No.');
	            return false
	        }
	    }
	}
	
	/** 매뉴얼로 입력시 유효성 검사
	 * 
	 * @return
	 */
	function validateManualInput(){
	    var sheetObj  = sheetObjects[0];
	    var err_flag = false;
	    for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
	        if(!(sheetObj.CellValue(i,'wrk_dt').length == 8 || sheetObj.CellValue(i,'wrk_dt').length == 0)){
	            sheetObj.CellFontColor(i,'wrk_dt') = sheetObj.RgbColor(255, 0, 0);
	            err_flag = true;
	        }

	        if(sheetObj.CellValue(i,'wrk_dt').length == 8){

    	        var year = sheetObj.CellValue(i,'wrk_dt').substring(0,4);
    	        var month = sheetObj.CellValue(i,'wrk_dt').substring(4,6);
    	        var day = sheetObj.CellValue(i,'wrk_dt').substring(6,8);

    	        if ( ComParseInt( year ) >= 1900  && ComIsMonth( month ) && ComIsDay( year,month ,day) ){
    	            sheetObj.CellFontColor(i,'wrk_dt') = sheetObj.RgbColor(0, 0, 0);
    	        }else{
    	            sheetObj.CellFontColor(i,'wrk_dt') = sheetObj.RgbColor(255, 0, 0);
    	            err_flag = true;
    	        }
	        }

	        if(sheetObj.CellValue(i,'cntr_no').length != 11){
	            sheetObj.CellFontColor(i,'cntr_no') = sheetObj.RgbColor(255, 0, 0);
	            err_flag = true;
	        }

	        var cntr_char = sheetObj.CellValue(i,'cntr_no').substring(0,4);
	        var cntr_num = sheetObj.CellValue(i,'cntr_no').substring(4,11);

	        if (ComIsContainsCharsOnly(cntr_char,'ABCDEFGHIJKLMNOPQRSTUVWXYZ') && ComIsNumber(cntr_num)){
	            sheetObj.CellFontColor(i,'cntr_no') = sheetObj.RgbColor(0, 0, 0);
	        }else{
	            sheetObj.CellFontColor(i,'cntr_no') = sheetObj.RgbColor(255, 0, 0);
	            err_flag = true;
	        }
	    }

        var Rows;
		Rows = sheetObj.ColValueDupRows("cntr_no");
		var arr_rows = Rows.split(',');
		for (var i=0; arr_rows!='' && i<arr_rows.length; i++){
			sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255, 0, 0);
			err_flag = true;
			sheetObj.CellValue(arr_rows[i],"remark") = 'Duplicate';
		}

	    if(err_flag == true){
	        ComShowMessage("Please check the column in red.");
	        return false;
	    }


	}
	
	/**
	 * 셀에 값이 없을경우 row 삭제 함수
	 * @param {ibsheet}sheet	IBSheet Object
	 * @return
	 */
	function delBlkRows(sheet) {
		if (sheet.RowCount > 0){
			for (var i=sheet.RowCount; sheet!=null && i>=0; i--){
				if ((sheet.CellValue(i,'cntr_no')==null ||sheet.CellValue(i,'cntr_no')=='') &&
					(sheet.CellValue(i,'cntr_tpsz_cd')==null ||sheet.CellValue(i,'cntr_tpsz_cd')=='') &&
					(sheet.CellValue(i,'cntr_sty_cd')==null ||sheet.CellValue(i,'cntr_sty_cd')=='') &&
					(sheet.CellValue(i,'io_bnd_cd')==null ||sheet.CellValue(i,'io_bnd_cd')=='') &&
					(sheet.CellValue(i,'wrk_dt')==null ||sheet.CellValue(i,'wrk_dt')=='') ) 
				{
					sheet.RowDelete(i, false);
				}
			}
		}
	}


//    /**
//     * LOAD된 EXCEL DATA를 CHECK
//     **/
//	 function checkExcelData(sheetObj){
//	 	//ComShowMessage(sheetObj.RowCount);
//	 	document.form.excel_chk.value="Y";
//	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
//	 		if(sheetObj.CellValue(i, "cntr_no").length != 11 || !ComIsAlphabet(sheetObj.CellValue(i, "cntr_no"))){
//	 			sheetObj.CellBackColor(i, "cntr_no") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "cntr_tpsz_cd").length != 2 || !ComIsAlphabet(sheetObj.CellValue(i, "cntr_tpsz_cd"))){
//	 			sheetObj.CellBackColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "cntr_sty_cd").length != 1 || !(sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "M"
//	 		                                                      || sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "F")){
//	 			sheetObj.CellBackColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "io_bnd_cd").length != 1 || !(sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() == "I"
//	 		                                                  ||sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() == "O")
//	 		                                                  ||sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() != document.form.io_bnd_cd.value){
//	 			sheetObj.CellBackColor(i, "io_bnd_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "io_bnd_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(!chk_Date(sheetObj.CellValue(i, "wrk_dt"))){
//	 			sheetObj.CellBackColor(i, "wrk_dt") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "wrk_dt") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		for(var j= i+1 ; j<sheetObj.HeaderRows + sheetObj.RowCount; j++){
//				if(sheetObj.CellValue(i, "cntr_no") == sheetObj.CellValue(j, "cntr_no")){
//		 			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//		 			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//		 			sheetObj.RowBackColor(j) = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//		 			sheetObj.RowFontColor(j) = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 				document.form.excel_chk.value="N";
//
//				}
//			}
//		}
//	}



//    function sheet_OnSearchEnd(sheetObj, ErrMsg){
//        var hidden_sheet = sheetObjects[1];
//        var queryStr = '';
//        var opr_sht_idx = 0;
//        var opener_sheet_obj;
//
//		if (sheetObj.RowCount > 0){
//			for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
//				/** 한 ROW씩 SERVER에 VERIFY를 왔다갔다 하면서 ROW STATUS가 'I' -> 'R'로 변경된다. 반드시 다시 'I'로 변경해서 넘겨야한다. **/
//				sheetObj.RowStatus(i) = 'I';
//			}
//
//
//
//
//			//popup의 sheet data를 COIN에 뿌리기
//			queryStr = sheetObj.GetSaveString(false, false, 'co_flg');
//			if (queryStr==null || queryStr==''){
//				//return false;
//			} else {
//				opr_sht_idx = 0; //TO COINCIDENCE
//				opener_sheet_obj = window.dialogArguments.document.t1sheet1;
//				tes_copy_rows_to(opener_sheet_obj, queryStr, true);
//			}
//
//			//popup의 sheet data를 DSCP에 뿌리기
//			opener_sheet_obj = window.dialogArguments.document.t2sheet1;
//			queryStr = sheetObj.GetSaveString(false, false, 'dc_flg');
//			if(queryStr==null || queryStr==''){
////				return false;
//			} else {
//				opr_sht_idx = 1; //TO DISCREPANCY
//				tes_copy_rows_to(opener_sheet_obj, queryStr, true);
//			}
////			opener_sheet_obj = window.dialogArguments.document.t2sheet1;
//
//			for(var i=opener_sheet_obj.HeaderRows; i<opener_sheet_obj.HeaderRows+opener_sheet_obj.RowCount; i++){
//    			if(opener_sheet_obj.CellValue(i,"dscr_dtl_ind_cd") == "I"){
//    				opener_sheet_obj.CellBackColor(i, "io_bnd_cd"	) = opener_sheet_obj.RgbColor(255, 255, 102); //노란색 바탕
//    				opener_sheet_obj.CellFontColor(i, "io_bnd_cd"	) = opener_sheet_obj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//    			}else if(opener_sheet_obj.CellValue(i,"dscr_dtl_ind_cd") == "F"){
//    				opener_sheet_obj.CellBackColor(i, "cntr_sty_cd") = opener_sheet_obj.RgbColor(255, 255, 102); //노란색 바탕
//    				opener_sheet_obj.CellFontColor(i, "cntr_sty_cd") = opener_sheet_obj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//    			}else if(opener_sheet_obj.CellValue(i,"dscr_dtl_ind_cd") == "T"){
//    				opener_sheet_obj.CellBackColor(i, "cntr_tpsz_cd") = opener_sheet_obj.RgbColor(255, 255, 102); //노란색 바탕
//    				opener_sheet_obj.CellFontColor(i, "cntr_tpsz_cd") = opener_sheet_obj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//    			}
//			}
//
//		    //SML List Only찾기..
//		    for(var i=hidden_sheet.HeaderRows; i<(hidden_sheet.HeaderRows+hidden_sheet.RowCount); i++){
//		        hidden_sheet.RowStatus(i) = 'I';
//		        if(sheetObj.FindText('cntr_no', hidden_sheet.CellValue(i,'cntr_no'))>0){
//		            hidden_sheet.CellValue(i,'dc_flg') = '';
//		        }
//		    }
//		    queryStr = hidden_sheet.GetSaveString(false,false,'dc_flg');
//		    if(queryStr == null || queryStr == ''){
//		        //return false;
//		    }else{
//		        tes_copy_rows_to(opener_sheet_obj, queryStr, true);
//		    }
//			window.focus();
//			var count = parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount);
//			ComShowMessage(count+ComGetMsg('TES40043')); //ComShowMessage((parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount))+ '건의 List가 verify완료되었습니다.');
//			window.close();
//		}
//	}


//    function formValue2Sheet(sheetObj){
//        for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
//            sheetObj.CellValue(i, "vvd"  	)  =  document.form.vvd.value;
//            sheetObj.CellValue(i, "vndr_seq"	)  =  document.form.vndr_seq.value;
//            sheetObj.CellValue(i, "yd_cd"   	)  =  document.form.yd_cd.value;
//            sheetObj.CellValue(i, "rcv_dt"  	)  =  document.form.rcv_dt.value;
//        }
//    }


//	function copySheet(fromSheetObj,toSheetObj1,toSheetObj2){
//	    var openerFormObj = window.dialogArguments.document.form;
////		ComShowMessage(openerFormObj.laneComboItems.value);
//
//        toSheetObj1.RemoveAll(); // Coincidece Sheet
//        toSheetObj2.RemoveAll(); // Discrepancy Sheet
//        for(var i=fromSheetObj.HeaderRows ; i<fromSheetObj.HeaderRows + fromSheetObj.RowCount; i++){
//			if(fromSheetObj.CellValue(i, "dscr_ind_cd"  ) == "CO"){ // Coincidece
//				var Row = toSheetObj1.DataInsert(-1);
//				//ComShowMessage(Row);
//    		    toSheetObj1.CellComboItem(Row, 'lane_cd', openerFormObj.laneComboItems.value,  openerFormObj.laneComboItems.value);
//
//				toSheetObj1.CellValue(Row, "sts"  		  		)  = "I";
//				toSheetObj1.CellValue(Row, "vvd"  		  	)  = fromSheetObj.CellValue(i, "vvd");
//				toSheetObj1.CellValue(Row, "vndr_seq"		  	)  = fromSheetObj.CellValue(i, "vndr_seq");
//				toSheetObj1.CellValue(Row, "cntr_no"      		)  = fromSheetObj.CellValue(i, "cntr_no");
//				toSheetObj1.CellValue(Row, "cntr_tpsz_cd" 		)  = fromSheetObj.CellValue(i, "cntr_tpsz_cd");
//				toSheetObj1.CellValue(Row, "cntr_sty_cd"		)  = fromSheetObj.CellValue(i, "cntr_sty_cd");
//				toSheetObj1.CellValue(Row, "locl_ts_ind_cd"     )  = fromSheetObj.CellValue(i, "locl_ts_ind_cd");
//				toSheetObj1.CellValue(Row, "io_bnd_cd" 		    )  = fromSheetObj.CellValue(i, "io_bnd_cd");
//				toSheetObj1.CellValue(Row, "ioc_cd" 		    )  = fromSheetObj.CellValue(i, "ioc_cd");
//				toSheetObj1.CellValue(Row, "lane_cd" 	      	)  = fromSheetObj.CellValue(i, "lane_cd");
//				toSheetObj1.CellValue(Row, "rcvde_term_ind_cd"  )  = fromSheetObj.CellValue(i, "rcvde_term_ind_cd");
//				toSheetObj1.CellValue(Row, "pre_yd_cd"     		)  = fromSheetObj.CellValue(i, "pre_yd_cd");
//				toSheetObj1.CellValue(Row, "same_ts"     		)  = fromSheetObj.CellValue(i, "same_ts");
//				toSheetObj1.CellValue(Row, "wrk_dt"     		)  = fromSheetObj.CellValue(i, "wrk_dt");
//				toSheetObj1.CellValue(Row, "dcgo_clss_cd" 		)  = fromSheetObj.CellValue(i, "dcgo_clss_cd");
//				toSheetObj1.CellValue(Row, "bkg_no" 		  	)  = fromSheetObj.CellValue(i, "bkg_no");
//				toSheetObj1.CellValue(Row, "bkg_no_split" 		)  = fromSheetObj.CellValue(i, "bkg_no_split");
//
//				toSheetObj1.CellValue(Row, "tml_so_ofc_cty_cd" 	)  = document.form.tml_so_ofc_cty_cd.value;
//				toSheetObj1.CellValue(Row, "tml_so_seq"        	)  = document.form.tml_so_seq.value;
//				toSheetObj1.CellValue(Row, "vrfy_rslt_ind_cd"   )  = "CO";
//				//toSheetObj1.CellValue(Row, "dscr_ind_cd"   	)  = "CO";
//
//
//				toSheetObj1.CellValue(Row, "vsl_cd"				)  = fromSheetObj.CellValue(i, "vvd").substring(0,4);
//				toSheetObj1.CellValue(Row, "skd_voy_no"			)  = fromSheetObj.CellValue(i, "vvd").substring(4,8);
//				toSheetObj1.CellValue(Row, "skd_dir_cd"			)  = fromSheetObj.CellValue(i, "vvd").substring(8,9);
//				toSheetObj1.CellValue(Row, "dscr_ind_nm"     	)  = fromSheetObj.CellValue(i, "dscr_ind_nm");
//				toSheetObj1.CellValue(Row, "dscr_dtl_ind_cd"    )  = fromSheetObj.CellValue(i, "dscr_dtl_ind_cd");
//				toSheetObj1.CellValue(Row, "bb_cgo_flg"         )  = fromSheetObj.CellValue(i, "bb_cgo_flg");
//				toSheetObj1.CellValue(Row, "awk_cgo_flg"        )  = fromSheetObj.CellValue(i, "awk_cgo_flg");
//				toSheetObj1.CellValue(Row, "rc_flg"       		)  = fromSheetObj.CellValue(i, "rc_flg");
//
//				if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "I"){
//					toSheetObj1.CellBackColor(Row, "io_bnd_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj1.CellFontColor(Row, "io_bnd_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}else if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "F"){
//					toSheetObj1.CellBackColor(Row, "cntr_sty_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj1.CellFontColor(Row, "cntr_sty_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}else if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "T"){
//					toSheetObj1.CellBackColor(Row, "cntr_tpsz_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj1.CellFontColor(Row, "cntr_tpsz_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}
//
//			}else{		// Discrepancy
//				var Row2 = toSheetObj2.DataInsert(-1);
//				//ComShowMessage(Row);
//
//    		toSheetObj2.CellComboItem(Row2, 'lane_cd', openerFormObj.laneComboItems.value,  openerFormObj.laneComboItems.value);
//
//				toSheetObj2.CellValue(Row2, "sts"  		  		)  = "I";
//				toSheetObj2.CellValue(Row2, "vvd"  		  	)  = fromSheetObj.CellValue(i, "vvd");
//				toSheetObj2.CellValue(Row2, "vndr_seq"		  	)  = fromSheetObj.CellValue(i, "vndr_seq");
//				toSheetObj2.CellValue(Row2, "cntr_no"      		)  = fromSheetObj.CellValue(i, "cntr_no");
//				toSheetObj2.CellValue(Row2, "cntr_tpsz_cd" 		)  = fromSheetObj.CellValue(i, "cntr_tpsz_cd");
//				toSheetObj2.CellValue(Row2, "cntr_sty_cd"		)  = fromSheetObj.CellValue(i, "cntr_sty_cd");
//				toSheetObj2.CellValue(Row2, "locl_ts_ind_cd"    )  = fromSheetObj.CellValue(i, "locl_ts_ind_cd");
//				toSheetObj2.CellValue(Row2, "io_bnd_cd" 		)  = fromSheetObj.CellValue(i, "io_bnd_cd");
//				toSheetObj2.CellValue(Row2, "ioc_cd" 		    )  = fromSheetObj.CellValue(i, "ioc_cd");
//				toSheetObj2.CellValue(Row2, "lane_cd" 	      	)  = fromSheetObj.CellValue(i, "lane_cd");
//				toSheetObj2.CellValue(Row2, "rcvde_term_ind_cd" )  = fromSheetObj.CellValue(i, "rcvde_term_ind_cd");
//				toSheetObj2.CellValue(Row2, "pre_yd_cd"     	)  = fromSheetObj.CellValue(i, "pre_yd_cd");
//				toSheetObj2.CellValue(Row2, "same_ts"     		)  = fromSheetObj.CellValue(i, "same_ts");
//				toSheetObj2.CellValue(Row2, "wrk_dt"     		)  = fromSheetObj.CellValue(i, "wrk_dt");
//				toSheetObj2.CellValue(Row2, "dcgo_clss_cd"   	)  = fromSheetObj.CellValue(i, "dcgo_clss_cd");
//				toSheetObj2.CellValue(Row2, "bkg_no" 		  	)  = fromSheetObj.CellValue(i, "bkg_no");
//				toSheetObj2.CellValue(Row2, "bkg_no_split" 		)  = fromSheetObj.CellValue(i, "bkg_no_split");
//
//				toSheetObj2.CellValue(Row2, "tml_so_ofc_cty_cd"	)  = document.form.tml_so_ofc_cty_cd.value;
//				toSheetObj2.CellValue(Row2, "tml_so_seq"       	)  = document.form.tml_so_seq				.value;
//				toSheetObj2.CellValue(Row2, "vrfy_rslt_ind_cd"  )  = "DC";
//
//				toSheetObj2.CellValue(Row2, "dscr_ind_cd"   	)  = fromSheetObj.CellValue(i, "dscr_ind_cd");
//				toSheetObj2.CellValue(Row2, "vsl_cd"			)  = fromSheetObj.CellValue(i, "vvd"  	     ).substring(0,4);
//				toSheetObj2.CellValue(Row2, "skd_voy_no"		)  = fromSheetObj.CellValue(i, "vvd"  	   	 ).substring(4,8);
//				toSheetObj2.CellValue(Row2, "skd_dir_cd"		)  = fromSheetObj.CellValue(i, "vvd"  	   	 ).substring(8,9);
//				toSheetObj2.CellValue(Row2, "dscr_ind_nm"     	)  = fromSheetObj.CellValue(i, "dscr_ind_nm");
//				toSheetObj2.CellValue(Row2, "dscr_dtl_ind_cd"   )  = fromSheetObj.CellValue(i, "dscr_dtl_ind_cd");
//				toSheetObj2.CellValue(Row2, "bb_cgo_flg"        )  = fromSheetObj.CellValue(i, "bb_cgo_flg");
//				toSheetObj2.CellValue(Row2, "awk_cgo_flg"       )  = fromSheetObj.CellValue(i, "awk_cgo_flg");
//				toSheetObj2.CellValue(Row2, "rc_flg"       		)  = fromSheetObj.CellValue(i, "rc_flg");
//
//				if(toSheetObj2.CellValue(Row2,"dscr_dtl_ind_cd") == "I"){
//					toSheetObj2.CellBackColor(Row2, "io_bnd_cd"	) = toSheetObj2.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj2.CellFontColor(Row2, "io_bnd_cd"	) = toSheetObj2.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}else if(toSheetObj2.CellValue(Row2,"dscr_dtl_ind_cd") == "F"){
//					toSheetObj2.CellBackColor(Row2, "cntr_sty_cd") = toSheetObj2.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj2.CellFontColor(Row2, "cntr_sty_cd") = toSheetObj2.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}else if(toSheetObj2.CellValue(Row2,"dscr_dtl_ind_cd") == "T"){
//					toSheetObj2.CellBackColor(Row2, "cntr_tpsz_cd") = toSheetObj2.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj2.CellFontColor(Row2, "cntr_tpsz_cd") = toSheetObj2.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}
//
//			}
//		}
//
//		toSheetObj1.CountFormat = "[SELECTDATAROW / ROWCOUNT]";
//		toSheetObj2.CountFormat = "[SELECTDATAROW / ROWCOUNT]";
//		//openerFormObj의 Cost calc List 재계산.
//		openerFormObj.cost_calc_mode.value = "N";
//
//		sumaryByItem2OpenerForm(fromSheetObj);
//	}





//   /**
//     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
////            if (!isNumber(iPage)) {
////
////                return false;
////            }
//        }
//
//        return true;
//    }

///** opener의 t1sheet1의 onsearch END시 실행되므로 삭제해도 될듯...**/
//    function sumaryByItem2OpenerForm(sheetObject){
//        var openerFormObj = window.dialogArguments.document.form;
//
//		var cntTot		 = 0;
//		var cntSizeD2  = 0;  				var cntSizeO2  = 0;
//		var cntSizeD4  = 0;         var cntSizeO4  = 0;
//		var cntSizeD5  = 0;         var cntSizeS2  = 0;
//		var cntSizeD7  = 0;         var cntSizeS4  = 0;
//		var cntSizeD8  = 0;         var cntSizeT2  = 0;
//		var cntSizeD9  = 0;         var cntSizeT4  = 0;
//		var cntSizeDW  = 0;         var cntSizeA2  = 0;
//		var cntSizeDX  = 0;         var cntSizeA4  = 0;
//		var cntSizeR2  = 0;         var cntSizeP2  = 0;
//		var cntSizeR4  = 0;         var cntSizeP4  = 0;
//		var cntSizeR5  = 0;         var cntSizeZ2  = 0;
//		var cntSizeF2  = 0;         var cntSizeZ4  = 0;
//		var cntSizeF4  = 0;
//		var cntFull		 = 0;					var cntEmpty   = 0;
//		var cntTs			 = 0;					var cntSameTs	 = 0;
//    	for(var i=sheetObject.HeaderRows ; i<sheetObject.HeaderRows + sheetObject.RowCount; i++){
//			if(sheetObject.CellValue(i, "dscr_ind_cd"  ) == "CO"){
//			    cntTot++;
//				if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D2") 	   cntSizeD2++;
//				else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D4") cntSizeD4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D5") cntSizeD5++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D7") cntSizeD7++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D8") cntSizeD8++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D9") cntSizeD9++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DW") cntSizeDW++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DX") cntSizeDX++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R2") cntSizeR2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R4") cntSizeR4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R5") cntSizeR5++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F2") cntSizeF2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F4") cntSizeF4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O2") cntSizeO2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O4") cntSizeO4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S2") cntSizeS2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S4") cntSizeS4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T2") cntSizeT2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T4") cntSizeT4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A2") cntSizeA2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A4") cntSizeA4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P2") cntSizeP2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P4") cntSizeP4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z2") cntSizeZ2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z4") cntSizeZ4++;
//
//                if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "F") 	   cntFull++;
//                else if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "M")   cntEmpty++;
//
//                if(sheetObject.CellValue(i, "locl_ts_ind_cd" 	) == "T")  cntTs++;
//                if(sheetObject.CellValue(i, "same_ts" ) == "T")            cntSameTs++;
//            }
//        }
//		openerFormObj.size_d2				.value = 	addComma(cntSizeD2);
//		openerFormObj.size_d4       .value =  addComma(cntSizeD4);
//		openerFormObj.size_d5       .value =  addComma(cntSizeD5);
//		openerFormObj.size_d7       .value =  addComma(cntSizeD7);
//		openerFormObj.size_d8       .value =  addComma(cntSizeD8);
//		openerFormObj.size_d9       .value =  addComma(cntSizeD9);
//		openerFormObj.size_dw       .value =  addComma(cntSizeDW);
//		openerFormObj.size_dx       .value =  addComma(cntSizeDX);
//		openerFormObj.size_r2       .value =  addComma(cntSizeR2);
//		openerFormObj.size_r4       .value =  addComma(cntSizeR4);
//		openerFormObj.size_r5       .value =  addComma(cntSizeR5);
//		openerFormObj.size_f2       .value =  addComma(cntSizeF2);
//		openerFormObj.size_f4       .value =  addComma(cntSizeF4);
//		openerFormObj.size_o2       .value =  addComma(cntSizeO2);
//		openerFormObj.size_o4       .value =  addComma(cntSizeO4);
//		openerFormObj.size_s2       .value =  addComma(cntSizeS2);
//		openerFormObj.size_s4       .value =  addComma(cntSizeS4);
//		openerFormObj.size_t2       .value =  addComma(cntSizeT2);
//		openerFormObj.size_t4       .value =  addComma(cntSizeT4);
//		openerFormObj.size_a2       .value =  addComma(cntSizeA2);
//		openerFormObj.size_a4       .value =  addComma(cntSizeA4);
//		openerFormObj.size_p2       .value =  addComma(cntSizeP2);
//		openerFormObj.size_p4       .value =  addComma(cntSizeP4);
//		openerFormObj.size_z2       .value =  addComma(cntSizeZ2);
//		openerFormObj.size_z4       .value =  addComma(cntSizeZ4);
//
//		openerFormObj.container_tot .value =  addComma(cntTot);
//		openerFormObj.full          .value =  addComma(cntFull);
//		openerFormObj.empty         .value =  addComma(cntEmpty);
//		openerFormObj.same_ts       .value =  addComma(cntTs);
//		//openerFormObj.bkg_ts        .value =  addComma(cntTs);
//		//openerFormObj.same_ts       .value =  addComma(cntSameTs);
//    }


//	function deleteComma(src){
//		// comma를 제거
//		var src = String(src);
//		if (src==null || trim(src)==''){
//			return '';
//		}
//		return src.replace(/,/gi,'');
//	}


//	function addComma(src){
//	    // comma를 3자리마다 끼워넣기
//		var src = String(src);
//		if (src==null || trim(src)==''){
//			return '';
//		}
//		var re = /(-?\d+)(\d{3})/;
//		while (re.test(src)) {
//			src = src.replace(re, "$1,$2");
//		}
//		return  src;
//	}
