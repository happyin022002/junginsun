/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9130.js
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-29
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-29 parkyeonjin
* 1.0 최초 생성
* 2007-01-04 parkyeonjin
* 1.1 요건변경 : io_bnd_cd 삭제
* 2011.07.15 윤태승 [CHM-201111696-01] TES의 BKG no. 참조로직 변경을 위한 타당성 검토 및 변경요청
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

         	    case "btn_loadexcel":
         	    		//ComShowMessage("btn_loadexcel button click");
         	    		formObject.excel_chk.value = "";
     	            doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);

        	        break;

         	    case "btn_verify":
    	            //ComShowMessage("btn_verify button click");
         	        if(formObject.excel_chk.value == "N"){
    	            	ComShowMessage(ComGetMsg('TES22601')); //ComShowMessage("EXCEL FILE SOURCE DATA가 잘못되었습니다.");
    	            	return false;
    	            }
   	            	verifyContainerList();
          	    	if(formObject.verify_chk.value == null || formObject.verify_chk.value =="" || formObject.verify_chk.value != "Y"){
     	    			ComShowMessage(ComGetMsg('TES22602')); //ComShowMessage("Verify를 수행하지 않았습니다.");
     	    			return false;
         	    	}
          	    	
//         	    		var openerSheetObj1 = window.opener.form.t1sheet1; // Coincidence
//	    	          var openerSheetObj2 = window.opener.form.t2sheet1; // Discrepancy
//         	    		var openerSheetObj1 = window.dialogArguments.document.t1sheet1; // Coincidence
//	    	          var openerSheetObj2 = window.dialogArguments.document.t2sheet1; // Discrepancy
//	    	          copySheet(sheetObject,openerSheetObj1,openerSheetObj2);
//	    	          ComShowMessage(ComGetMsg('TES40043',sheetObject.ROWCOUNT)); //ComShowMessage('총 '+sheetObject.ROWCOUNT+'개 Verify 되었습니다.');
//	    	          window.close();

        	        break;

         	    case "btn_ok":
    	            //ComShowMessage("btn_ok button click");
    	          	break;

         	    case "btn_close":
    	            window.close();
        	        break;

                case "btn_sampleExecl":
                    location.href="apps/alps/esd/tes/serviceproviderinvoicemanage/ondockrailchargeinvoicemanage/jsp/ESD_TES_9130DL.jsp";
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

        initValue(window.dialogArguments.document.form, document.form);

    }

 		function initValue(openerObj, formObj){
			formObj.vndr_seq.value          = openerObj.vndr_seq.value;
			formObj.yd_cd.value             = openerObj.yd_cd.value;
			formObj.rcv_dt.value            = openerObj.rcv_dt.value;
			formObj.tml_so_ofc_cty_cd.value = openerObj.tml_so_ofc_cty_cd.value;
			formObj.tml_so_seq.value        = openerObj.tml_so_seq.value;
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
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = " Sts|Seq.|CNTR No.|Type/Size|F/M|I/O|Working Date|";
                                //vvd_no|vndr_seq|"+
        						//	  "yd_cd|rcv_dt|bkg_no|bkg_no_split|fm_nod_cd|to_nod_cd|dg|clm_dt|"+
        						//	  "rb_dt|dy|dscr_ind_cd|dscr_ind_nm";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "ibflag"			     ,	   false,          "",      dfNone,      0,     false,       true );
                    InitDataProperty(0, cnt++, dtDataSeq,    	60,    daCenter,  true,    ""        			 ,	false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData	,      100,    daCenter,  true,    "cntr_no"       ,  true,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData	,       70,    daCenter,  true,    "cntr_tpsz_cd"  ,  true,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData	,       50,    daCenter,  false,   "cntr_sty_cd" ,  false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData	,       50,    daCenter,  false,   "io_bnd_cd" ,  true,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData	,       80,    daCenter,  false,   "wrk_dt"				 ,	true,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "vvd_no"        ,  false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "vndr_seq"      ,  false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "yd_cd"       	 ,  false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "rcv_dt"      	 ,  false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "bkg_no" 			 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "bkg_no_split"  ,  false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "fm_nod_cd" 		 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "to_nod_cd"  	 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "dcgo_clss_cd"  		 			 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "clm_dt"  		 	 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden	,       80,    daCenter,  false,   "rail_bil_dt"  		 	 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "dy"  		 			 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "dscr_ind_cd",  false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "dscr_ind_nm",	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "dscr_dtl_ind_cd",	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "bb_cgo_flg"						 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "awk_cgo_flg"						 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "rc_flg"						 ,	false,          "",       dfNone,    0,     true,       true);
//                    InitDataProperty(0, cnt++, dtHidden ,       80,    daCenter,  false,   "remark"				 ,	false,          "",       dfNone,    0,     true,       true);
                    InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
                    InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "cntr_sty_cd", vtEngUpOther, "");
                    InitDataValid(0, "io_bnd_cd", vtEngUpOther, "");
    								// 데이타 Count format [선택한포커스행/전체건수] 로 적용
 										CountFormat = "[SELECTDATAROW / ROWCOUNT]";


               }
                break;
        }
    }



    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBLOADEXCEL:      //조회
                sheetObj		 .RemoveAll();
                sheetObj.LoadExcel(-1);
//                checkExcelData(sheetObj);
                break;

            case IBSEARCH:      			//조회
                formObj.f_cmd.value = SEARCH;
                var param = sheetObj.GetSaveString(false,false);
                var saveXml = sheetObj.GetSearchXml("ESD_TES_9130GS.do",  param+'&'+tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                if (saveXml != "") sheetObj.LoadSaveXml(saveXml,true);
                break;
        }
    }

    function sheet_OnLoadExcel(sheetObj){
    	
    	//[CHM-201642186]Upload 이후 Cost Code 또는 Cntr No이 없는 경우 해당 라인을 삭제하는 로직을 추가 2016-06-23
    	delBlkRows(sheetObj);
    	
		document.form.excel_chk.value="Y";

	 	for(var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows+sheetObj.RowCount); i++){
	 		if(sheetObj.CellValue(i, "cntr_no").length != 11 || !ComIsAlphabet(sheetObj.CellValue(i, "cntr_no"), "n")){
	 			sheetObj.CellBackColor(i, "cntr_no") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 		}
	 		if(sheetObj.CellValue(i, "cntr_sty_cd").length != 1 || !(sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "M"
	 		                                                      || sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "F")){
	 			sheetObj.CellBackColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 		}
	 		if(!ComIsDate(sheetObj.CellValue(i, "wrk_dt"))){
	 			sheetObj.CellBackColor(i, "wrk_dt") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "wrk_dt") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 		}
	 		if(sheetObj.CellValue(i, "io_bnd_cd").length != 1 || !ComIsAlphabet(sheetObj.CellValue(i, "io_bnd_cd"), "n")){
	 			sheetObj.CellBackColor(i, "io_bnd_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
	 			sheetObj.CellFontColor(i, "io_bnd_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
	 			document.form.excel_chk.value="N";
	 		}

		}
		var Rows = sheetObj.ColValueDupRows("cntr_no|cntr_sty_cd|wrk_dt|io_bnd_cd");
		if(Rows != ''){
    		var arr_rows = Rows.split(',');
    		for (var i=0; (arr_rows!=null||arr_row.trim() !='') && i<arr_rows.length; i++){
    			sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255, 0, 0);
    			document.form.excel_chk.value="N";
    		}
		}
	}

	function sheet_OnSaveEnd(sheetObj){
        window.close();
        window.dialogArguments.fileImp();
        var count = parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount);
		ComShowMessage(count+ComGetMsg('TES40043')); //ComShowMessage((parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount))+ '건의 List가 verify완료되었습니다.');

    }

    function verifyContainerList(){
    	var formObj = document.form;
		//ComShowMessage("verifyContainerList");

  		if(sheetObjects[0].RowCount < 1){
  			ComShowMessage(ComGetMsg('TES40017')); //ComShowMessage("File이 Import가 되지않았습니다.");
  			return false;
  		}
		
  		if(formObj.excel_chk.value == "N"){
		  	ComShowMessage(ComGetMsg('TES22601')); //ComShowMessage("EXCEL FILE SOURCE DATA가 잘못되었습니다.");
		  	return false;
		 }
        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	formObj.verify_chk.value="Y";
   }




    function sumaryByItem2OpenerForm(sheetObject){
			var openerFormObj = window.dialogArguments.document.form;

			var cntTot     = 0;
			var cntSizeD2  = 0;
			var cntSizeD4  = 0;
			var cntSizeD5  = 0;
			var cntSizeD7  = 0;
			var cntSizeD8  = 0;
			var cntSizeD9  = 0;
			var cntSizeDW  = 0;
			var cntSizeDX  = 0;
			var cntSizeR2  = 0;
			var cntSizeR4  = 0;
			var cntSizeR5  = 0;
			var cntSizeR7  = 0;
			var cntSizeR8  = 0;
			var cntSizeR9  = 0;
			var cntSizeF2  = 0;
			var cntSizeF4  = 0;
			var cntSizeO2  = 0;
			var cntSizeO4  = 0;
			var cntSizeO5  = 0;
			var cntSizeS2  = 0;
			var cntSizeS4  = 0;
			var cntSizeT2  = 0;
			var cntSizeT4  = 0;
			var cntSizeA2  = 0;
			var cntSizeA4  = 0;
			var cntSizeA5  = 0;
			var cntSizeP2  = 0;
			var cntSizeP4  = 0;
			//var cntSizeZ2  = 0;
			//var cntSizeZ4  = 0;
			var cntSizeC2  = 0;
			var cntSizeC4  = 0;
			var cntFull    = 0;
			var cntTs      = 0;
			var cntSameTs  = 0;
			var cntEmpty   = 0;
                                        
    	for(var i=sheetObject.HeaderRows ; i<sheetObject.HeaderRows + sheetObject.RowCount; i++){
				if(sheetObject.CellValue(i, "dscr_ind_cd"  ) == "CO"){
					cntTot++;
					if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D2") 		 cntSizeD2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D4") cntSizeD4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D5") cntSizeD5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D7") cntSizeD7++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D8") cntSizeD8++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D9") cntSizeD9++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DW") cntSizeDW++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DX") cntSizeDX++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R2") cntSizeR2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R4") cntSizeR4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R5") cntSizeR5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R7") cntSizeR7++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R8") cntSizeR8++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R9") cntSizeR9++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F2") cntSizeF2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F4") cntSizeF4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O2") cntSizeO2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O4") cntSizeO4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O5") cntSizeO5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S2") cntSizeS2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S4") cntSizeS4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T2") cntSizeT2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T4") cntSizeT4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A2") cntSizeA2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A4") cntSizeA4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A5") cntSizeA4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P2") cntSizeP2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P4") cntSizeP4++;
				  //else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z2") cntSizeZ2++;
				  //else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z4") cntSizeZ4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "C2") cntSizeC2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "C4") cntSizeC4++;

				  if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "F") 		 cntFull++;
				  else if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "M") cntEmpty++;

				}
			}
			openerFormObj.size_d2		.value =  addComma(cntSizeD2);
			openerFormObj.size_d4       .value =  addComma(cntSizeD4);
			openerFormObj.size_d5       .value =  addComma(cntSizeD5);
			openerFormObj.size_d7       .value =  addComma(cntSizeD7);
			openerFormObj.size_d8       .value =  addComma(cntSizeD8);
			openerFormObj.size_d9       .value =  addComma(cntSizeD9);
			openerFormObj.size_dw       .value =  addComma(cntSizeDW);
			openerFormObj.size_dx       .value =  addComma(cntSizeDX);
			openerFormObj.size_r2       .value =  addComma(cntSizeR2);
			openerFormObj.size_r4       .value =  addComma(cntSizeR4);
			openerFormObj.size_r5       .value =  addComma(cntSizeR5);
			openerFormObj.size_r7       .value =  addComma(cntSizeR7);
			openerFormObj.size_r8       .value =  addComma(cntSizeR8);
			openerFormObj.size_r9       .value =  addComma(cntSizeR9);
			openerFormObj.size_f2       .value =  addComma(cntSizeF2);
			openerFormObj.size_f4       .value =  addComma(cntSizeF4);
			openerFormObj.size_o2       .value =  addComma(cntSizeO2);
			openerFormObj.size_o4       .value =  addComma(cntSizeO4);
			openerFormObj.size_o5       .value =  addComma(cntSizeO5);
			openerFormObj.size_s2       .value =  addComma(cntSizeS2);
			openerFormObj.size_s4       .value =  addComma(cntSizeS4);
			openerFormObj.size_t2       .value =  addComma(cntSizeT2);
			openerFormObj.size_t4       .value =  addComma(cntSizeT4);
			openerFormObj.size_a2       .value =  addComma(cntSizeA2);
			openerFormObj.size_a4       .value =  addComma(cntSizeA4);
			openerFormObj.size_a5       .value =  addComma(cntSizeA5);
			openerFormObj.size_p2       .value =  addComma(cntSizeP2);
			openerFormObj.size_p4       .value =  addComma(cntSizeP4);
			//openerFormObj.size_z2       .value =  addComma(cntSizeZ2);
			//openerFormObj.size_z4       .value =  addComma(cntSizeZ4);
			openerFormObj.size_c2       .value =  addComma(cntSizeC2);
			openerFormObj.size_c4       .value =  addComma(cntSizeC4);

			openerFormObj.container_tot .value =  addComma(cntTot);
			openerFormObj.full          .value =  addComma(cntFull);
			openerFormObj.empty         .value =  addComma(cntEmpty);

    }

	/**
	 * 셀에 값이 없을경우 row 삭제 함수
	 * @param {ibsheet}sheet	IBSheet Object
	 * @return
	 */
	function delBlkRows(sheet) {
		if (sheet.RowCount > 0){
			for (var i=sheet.RowCount; sheet!=null && i>=sheet.HeaderRows; i--){
				if ((sheet.CellValue(i,'cntr_no')==null ||sheet.CellValue(i,'cntr_no')=='' ||sheet.CellValue(i,'cntr_no').trim()=='') &&
					(sheet.CellValue(i,'cntr_tpsz_cd')==null ||sheet.CellValue(i,'cntr_tpsz_cd')=='' ||sheet.CellValue(i,'cntr_tpsz_cd').trim()=='') &&
					(sheet.CellValue(i,'io_bnd_cd')==null ||sheet.CellValue(i,'io_bnd_cd')=='' ||sheet.CellValue(i,'io_bnd_cd').trim()=='') &&
					(sheet.CellValue(i,'wrk_dt')==null ||sheet.CellValue(i,'wrk_dt')=='' ||sheet.CellValue(i,'wrk_dt').trim()=='') ) 
				{
					sheet.RowDelete(i, false);
				}
			}
		}
	}

//    /**
//     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//        }
//
//        return true;
//    }
//
//  /*
//   * LOAD된 EXCEL DATA를 CHECK 하여 중복데이터를 SHEET에서 삭제해준다.
//   *
//   */
//
//	 function checkExcelData(sheetObj){
//	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
//
//	 		if(sheetObj.CellValue(i, "cntr_no").length != 11||
//	 		   !chk_AlphaNumber(sheetObj.CellValue(i, "cntr_no"))){
//	 			sheetObj.CellBackColor(i, "cntr_no") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "cntr_tpsz_cd").length != 2 ||
//	 		   !chk_AlphaNumber(sheetObj.CellValue(i, "cntr_tpsz_cd"))){
//	 			sheetObj.CellBackColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "cntr_sty_cd").length != 1 ||
//	 		    !(sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "M" ||
//	 		      sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "F")){
//	 			sheetObj.CellBackColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(!chk_Date(sheetObj.CellValue(i, "wrk_dt"))){
//	 			sheetObj.CellBackColor(i, "wrk_dt") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
//	 			sheetObj.CellFontColor(i, "wrk_dt") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
//	 			document.form.excel_chk.value="N";
//	 		}
//
//	 		//dup CHECK
//		}
//	}
//
//
//
//   function formValue2Sheet(sheetObj){
//   	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
//			sheetObj.CellValue(i, "vndr_seq"	)  =  document.form.vndr_seq .value;
//			sheetObj.CellValue(i, "yd_cd"   	)  =  document.form.yd_cd		 .value;
//			sheetObj.CellValue(i, "rcv_dt"  	)  =  document.form.rcv_dt	 .value;
//		}
//
//  }
//
//	function copySheet(fromSheetObj,toSheetObj1,toSheetObj2){
//			var openerFormObj = window.dialogArguments.document.form;
//
//   	toSheetObj1.RemoveAll(); // Coincidece Sheet
//   	toSheetObj2.RemoveAll(); // Discrepancy Sheet
//   	for(var i=fromSheetObj.HeaderRows ; i<fromSheetObj.HeaderRows + fromSheetObj.RowCount; i++){
//			if(fromSheetObj.CellValue(i, "dscr_ind_cd"  ) == "CO"){ // Coincidece
//				var Row = toSheetObj1.DataInsert(-1);
//				//ComShowMessage(Row);
//
//				toSheetObj1.CellValue(Row, "sts"  		  				)  = "I";
//				toSheetObj1.CellValue(Row, "vvd_no"  		  			)  = fromSheetObj.CellValue(i, "vvd_no"  	   	);
//				toSheetObj1.CellValue(Row, "vndr_seq"		  			)  = fromSheetObj.CellValue(i, "vndr_seq"	   	);
//				toSheetObj1.CellValue(Row, "cntr_no"      			)  = fromSheetObj.CellValue(i, "cntr_no"      );
//				toSheetObj1.CellValue(Row, "cntr_tpsz_cd" 			)  = fromSheetObj.CellValue(i, "cntr_tpsz_cd" );
//				toSheetObj1.CellValue(Row, "cntr_sty_cd"			  )  = fromSheetObj.CellValue(i, "cntr_sty_cd");
//				toSheetObj1.CellValue(Row, "wrk_dt"     				)  = fromSheetObj.CellValue(i, "wrk_dt"  			);
//				toSheetObj1.CellValue(Row, "bkg_no" 	      		)  = fromSheetObj.CellValue(i, "bkg_no" 	 		);
//				toSheetObj1.CellValue(Row, "bkg_no_split"  			)  = fromSheetObj.CellValue(i, "bkg_no_split" );
//				toSheetObj1.CellValue(Row, "dcgo_clss_cd"     	)  = fromSheetObj.CellValue(i, "dcgo_clss_cd"  					);
//				toSheetObj1.CellValue(Row, "clm_dt"     				)  = fromSheetObj.CellValue(i, "clm_dt"  			);
//				toSheetObj1.CellValue(Row, "rail_bil_dt"     		)  = fromSheetObj.CellValue(i, "rail_bil_dt"  			);
//				toSheetObj1.CellValue(Row, "tml_so_ofc_cty_cd" 	)  = document.form.tml_so_ofc_cty_cd.value;
//				toSheetObj1.CellValue(Row, "tml_so_seq"        	)  = document.form.tml_so_seq				.value;
//				toSheetObj1.CellValue(Row, "vrfy_rslt_ind_cd"   )  = "CO";
//				toSheetObj1.CellValue(Row, "vsl_cd"						 	)  = fromSheetObj.CellValue(i, "vvd_no"  	   	).substring(0,4);
//				toSheetObj1.CellValue(Row, "skd_voy_no"					)  = fromSheetObj.CellValue(i, "vvd_no"  	   	).substring(4,8);
//				toSheetObj1.CellValue(Row, "skd_dir_cd"					)  = fromSheetObj.CellValue(i, "vvd_no"  	   	).substring(8,9);
//				toSheetObj1.CellValue(Row, "dscr_ind_cd"     		)  = fromSheetObj.CellValue(i, "dscr_ind_cd");
//				toSheetObj1.CellValue(Row, "dscr_ind_nm"     		)  = fromSheetObj.CellValue(i, "dscr_ind_nm");
//				toSheetObj1.CellValue(Row, "dscr_dtl_ind_cd"    )  = fromSheetObj.CellValue(i, "dscr_dtl_ind_cd");
//				toSheetObj1.CellValue(Row, "bb_cgo_flg"         )  = fromSheetObj.CellValue(i, "bb_cgo_flg");
//				toSheetObj1.CellValue(Row, "awk_cgo_flg"        )  = fromSheetObj.CellValue(i, "awk_cgo_flg");
//				toSheetObj1.CellValue(Row, "rc_flg"       			)  = fromSheetObj.CellValue(i, "rc_flg");
//
//				if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "F"){
//					toSheetObj1.CellBackColor(Row, "cntr_sty_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj1.CellFontColor(Row, "cntr_sty_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}else if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "T"){
//					toSheetObj1.CellBackColor(Row, "cntr_tpsz_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj1.CellFontColor(Row, "cntr_tpsz_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}
//
//			}else{		// Discrepancy
//				var Row = toSheetObj2.DataInsert(-1);
//				//ComShowMessage(Row);
//
//				toSheetObj2.CellValue(Row, "sts"  		  				)  = "I";
//				toSheetObj2.CellValue(Row, "vvd_no"  		  			)  = fromSheetObj.CellValue(i, "vvd_no"  	   	);
//				toSheetObj2.CellValue(Row, "vndr_seq"		  			)  = fromSheetObj.CellValue(i, "vndr_seq"	   	);
//				toSheetObj2.CellValue(Row, "cntr_no"      			)  = fromSheetObj.CellValue(i, "cntr_no"      );
//				toSheetObj2.CellValue(Row, "cntr_tpsz_cd" 			)  = fromSheetObj.CellValue(i, "cntr_tpsz_cd" );
//				toSheetObj2.CellValue(Row, "cntr_sty_cd"			  )  = fromSheetObj.CellValue(i, "cntr_sty_cd");
//				toSheetObj2.CellValue(Row, "wrk_dt"     				)  = fromSheetObj.CellValue(i, "wrk_dt"  			);
//				toSheetObj2.CellValue(Row, "bkg_no" 	      		)  = fromSheetObj.CellValue(i, "bkg_no" 	 		);
//				toSheetObj2.CellValue(Row, "bkg_no_split"  			)  = fromSheetObj.CellValue(i, "bkg_no_split" );
//				toSheetObj2.CellValue(Row, "dcgo_clss_cd"     	)  = fromSheetObj.CellValue(i, "dcgo_clss_cd"  					);
//				toSheetObj2.CellValue(Row, "clm_dt"     				)  = fromSheetObj.CellValue(i, "clm_dt"  			);
//				toSheetObj2.CellValue(Row, "rail_bil_dt"     		)  = fromSheetObj.CellValue(i, "rail_bil_dt"  			);
//				toSheetObj2.CellValue(Row, "tml_so_ofc_cty_cd" 	)  = document.form.tml_so_ofc_cty_cd.value;
//				toSheetObj2.CellValue(Row, "tml_so_seq"        	)  = document.form.tml_so_seq				.value;
//				toSheetObj2.CellValue(Row, "vrfy_rslt_ind_cd"   )  = "DC";
//				toSheetObj2.CellValue(Row, "vsl_cd"						 	)  = fromSheetObj.CellValue(i, "vvd_no"  	   	).substring(0,4);
//				toSheetObj2.CellValue(Row, "skd_voy_no"					)  = fromSheetObj.CellValue(i, "vvd_no"  	   	).substring(4,8);
//				toSheetObj2.CellValue(Row, "skd_dir_cd"					)  = fromSheetObj.CellValue(i, "vvd_no"  	   	).substring(8,9);
//				toSheetObj2.CellValue(Row, "dscr_ind_cd"     		)  = fromSheetObj.CellValue(i, "dscr_ind_cd");
//				toSheetObj2.CellValue(Row, "dscr_ind_nm"     		)  = fromSheetObj.CellValue(i, "dscr_ind_nm");
//				toSheetObj2.CellValue(Row, "dscr_dtl_ind_cd"   )  = fromSheetObj.CellValue(i, "dscr_dtl_ind_cd");
//				toSheetObj2.CellValue(Row, "bb_cgo_flg"         )  = fromSheetObj.CellValue(i, "bb_cgo_flg");
//				toSheetObj2.CellValue(Row, "awk_cgo_flg"        )  = fromSheetObj.CellValue(i, "awk_cgo_flg");
//				toSheetObj2.CellValue(Row, "rc_flg"       			)  = fromSheetObj.CellValue(i, "rc_flg");
//
//				if(toSheetObj2.CellValue(Row,"dscr_dtl_ind_cd") == "F"){
//					toSheetObj2.CellBackColor(Row, "cntr_sty_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj2.CellFontColor(Row, "cntr_sty_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}else if(toSheetObj2.CellValue(Row,"dscr_dtl_ind_cd") == "T"){
//					toSheetObj2.CellBackColor(Row, "cntr_tpsz_cd") = toSheetObj1.RgbColor(255, 255, 102); //노란색 바탕
//					toSheetObj2.CellFontColor(Row, "cntr_tpsz_cd") = toSheetObj1.RgbColor(255, 0, 0);		 // 빨간색 글씨
//				}
//			}
//		}
//
//		toSheetObj1.CountFormat = "[SELECTDATAROW / ROWCOUNT]";
//		toSheetObj2.CountFormat = "[SELECTDATAROW / ROWCOUNT]";
//		//openerFormObj의 Cost calc List 재계산.
//		openerFormObj.cost_calc_mode.value = "N";
//
//		sumaryByItem2OpenerForm(fromSheetObj);
//		toSheetObj1.Editable = true;
//		toSheetObj2.Editable = true;
//
//	}


	function deleteComma(src){
		// comma를 제거
		var src = String(src);
		if (src==null || trim(src)==''){
			return '';
		}
		return src.replace(/,/gi,'');
	}

	function addComma(src){
		// comma를 3자리마다 끼워넣기
		var src = String(src);
		if (src==null || trim(src)==''){
			return '';
		}
		var re = /(-?\d+)(\d{3})/;
		while (re.test(src)) {
			src = src.replace(re, "$1,$2");
		}
		return  src;
	}


