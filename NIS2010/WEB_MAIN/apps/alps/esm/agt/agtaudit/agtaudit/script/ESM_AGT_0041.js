// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];


         /*******************************************************/
         var formObject = document.form;
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_new":
                    sheetObject1.RemoveAll();
                    formObject.reset();
                    formObject.slct_itm_fom_seq.selectedIndex = 0;
                    break;

        	    case "btn_delete":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE);
                    sheetObject1.RemoveAll();
                    formObject.reset();
                    break;

        	    case "btn_save":
                    doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;

        	    case "btns_add":
                    var sRowStr = sheetObject.GetSelectionRows("/");   //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    var arr = sRowStr.split("/");
                    
                    for (var j=0; j<arr.length; j++) {
                        var findRow = sheetObject1.FindText("rpt_itm_cd", sheetObject.CellValue(arr[j],"rpt_itm_cd"), 0, -1);
                        if(findRow < 0){
                            // findRow가 -1면 동일한 데이터가 없는 것
                            // 해당 데이터를 sheet2에 추가한다.
                            //--------------------------------------
                            addRow(arr[j]);
                            //--------------------------------------
                        }
                    }
                    break;

        	    case "btns_del":
                    var sRowStr = sheetObject1.GetSelectionRows("/");  //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"

                    if(sRowStr.length > 0) {
                        var arr = sRowStr.split("/");
                        // Ctrl키 혹은 Shift키를 누르고 다중 선택을 했을 경우
                        // Row number가 작은것 부턱 Row를 삭제하면 원하는 결과가 나오지 않는다
                        // 그래서 Row number가 큰것 부터 삭제하기 위해 reverse()를 사용하였다.
                        //--------------------------------------------------------- 
                        arr.reverse();  //배열의 값을 역순으로 변경한다.
                        //--------------------------------------------------------- 

                        for (var k=0; k<arr.length; k++) {
                            sheetObject1.RowDelete(arr[k], false);
                        }
                    }
                    break;

        	    case "btn_close":
                    popUpClose();
                    break;

        	    case "btn_ok":
        	    	popUpOk(sheetObject1, formObject);
        	        break;

            } // end switch
    	}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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

        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        doActionIBSheet(sheetObject,formObject,IBSEARCH);  // 데이타를 보기위해 바로 호출 (추후 삭제)

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
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Sts|2|3|4|5|From" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "ibflag");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "slct_itm_fom_seq");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "slct_itm_fom_desc");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "rpt_itm_cd");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "rpt_itm_col_nm");
                    InitDataProperty(0, cnt++, dtData,        80,    daLeft,    true,     "rpt_itm_desc",   false,  "",   dfNone,   0,   false,  false);
                    
                    SelectionMode = smSelectionList;
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(11) ;
               }
                break;
            case 2:      //sheet1 init
                with (sheetObj) {
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
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Sts|2|3|4|5|To" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,     "ibflag");
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "slct_itm_fom_seq");
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "slct_itm_fom_desc");
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "rpt_itm_cd");       
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "rpt_itm_col_nm");             
                    InitDataProperty(0, cnt++ , dtData,        80,    daLeft,    true,     "rpt_itm_desc",        false,    "",       dfNone,       0,     false,       false);
                    
                    SelectionMode = smSelectionList;
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(11) ;
               }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESM_AGT_0041GS.do", agtQryStr(formObj));
                break;
                
            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)) {
                    if(ComShowConfirm(ComGetMsg("COM12147", "Report Form", "", "")) == 1) {
                        formObj.f_cmd.value = MULTI;
                        formObj.saveFlag.value = "I";
                        formObj.txtGroup.value = formObj.slct_itm_fom_seq[formObj.slct_itm_fom_seq.selectedIndex].text;
                        sheetObj.DoAllSave("ESM_AGT_0041GS.do", agtQryStr(formObj));
                    }
                }
                break;
                
            case IBDELETE:        //삭제
            	
            	if(validateForm(sheetObj,formObj,sAction)) {
                    if(ComShowConfirm(ComGetMsg("COM12165", "Report Form", "", "")) == 1) {
                        for(j=1; j<= sheetObj.LastRow; j++) sheetObj.RowStatus(j) = "D";
//                    	for(i=1; i<=sheetObj.RowCount; i++){
//                    		sheetObj.SetStatus(i) = "D";
//                    	}                            
                        formObj.f_cmd.value = MULTI;
                        formObj.saveFlag.value = "D";
                        
                        formObj.txtGroup.value = formObj.slct_itm_fom_seq[formObj.slct_itm_fom_seq.selectedIndex].text;
                        sheetObj.DoAllSave("ESM_AGT_0041GS.do", agtQryStr(formObj));
                    }
                }
                break;
            
        }
    }

    /**
     *  sheet1에서 선택된 정보를 sheet2에 추가한다.
     */
    function sheet1_OnDblClick(sheetObj , row, col , value) {
        var sheetObj2 = sheetObjects[1];
        var findRow = sheetObj2.FindText("rpt_itm_cd", sheetObj.CellValue(row,"rpt_itm_cd"), 0, -1);
        
        if(findRow < 0){
            // findRow가 -1면 동일한 데이터가 없는 것
            // 해당 데이터를 sheet2에 추가한다.
            //--------------------------------------
            addRow(row);
            //--------------------------------------
        }
    }
    
    /**
     * sheet2의 선택된 정보를 삭제한다.
     */
    function sheet2_OnDblClick(sheetObj, row, col, value){
        sheetObj.RowDelete(row, false);
    }
    
    /**
     * sheet2에서 마우스가 이동했을 경우
     */    
    function sheet2_OnMouseMove(sheetObj, button, shift, x, y){
        // 마우스 위치를 행과 컬럼 가져오기
        var row = sheetObj.MouseRow;
        var col = sheetObj.MouseCol;
    }

    /**
     * sheet2를 저장하고 나서 처리할 사항
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg){
        reSetRptGroup(sheetObj.EtcData("groupSeq"));
        sheetObj.RemoveEtcData();
        
		if(!opener) // 모달인 경우 Opener를 구해온다.
			opener = window.dialogArguments;
		opener.reSetRptGroup();	// Opener의 Customized RPT Form를 재조회한다.        
        //-----------------------------
    }
    
    /**
     * sheet1의 내용을 sheet2에 추가한다.
     */
    function addRow(selRow){
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var row = sheetObj2.DataInsert(-1);
        
        // 문제점 : slct_itm_fom_seq이 디폴드 값이 들어간다.
        //         저장시점에 사용할때 문제의 소지가 있으므로 이것을 사용하는 것을 피해야한다.
        //         대신 cboRptGroup의 값을 사용하기 바란다.
        sheetObj2.CellValue(row, "slct_itm_fom_seq")  = sheetObj1.CellValue(selRow, "slct_itm_fom_seq");
        sheetObj2.CellValue(row, "slct_itm_fom_desc") = sheetObj1.CellValue(selRow, "slct_itm_fom_desc");
        sheetObj2.CellValue(row, "rpt_itm_cd")        =  sheetObj1.CellValue(selRow, "rpt_itm_cd");
        sheetObj2.CellValue(row, "rpt_itm_col_nm")    =  sheetObj1.CellValue(selRow, "rpt_itm_col_nm");
        sheetObj2.CellValue(row, "rpt_itm_desc")                =  sheetObj1.CellValue(selRow, "rpt_itm_desc");
    }

    /**
     *  그룹코드 변경시
     *  sheet2정보를 조회한다.
     */
    function cboRptGroup_OnChange(obj) {
        var formObj = document.form;
        var sheetObject1 = sheetObjects[1];
                
        formObj.f_cmd.value = SEARCH01;
        sheetObject1.DoSearch4Post("ESM_AGT_0041GS.do", agtQryStr(formObj));
        formObj.save_name.value = obj[obj.selectedIndex].text;
        formObj.txtGroup.value = obj[obj.selectedIndex].text;
    }

    /**
     *  radio 버튼 변경시
     */
    function btnCtrl(value) {
        if(value == "Y") {
            document.all.div_save.style.display = "block";
            document.all.div_ok.style.display = "none";
        } else {
            document.all.div_save.style.display = "none";
            document.all.div_ok.style.display = "block";
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */     
    function validateForm(sheetObj, formObj, sAction){
    	
    	with(formObj){
        	if (save_yn[1].checked){
//            	alert(save_yn[1].checked)
                if(sAction == IBSAVE) {
                    if(save_name.value == ""){
                    	ComShowMessage(ComGetMsg("AGT10029")); // 저장할 그룹명을 입력하세요.
                        save_name.focus();
                        return false;
                    }

                    if(sheetObj.RowCount <= 0) {
                    	ComShowMessage(ComGetMsg("AGT10022", "save")); // There is no contents to save
                        return false;
                    }

                } else if(sAction == IBDELETE) {
                	if(formObj.slct_itm_fom_seq[formObj.slct_itm_fom_seq.selectedIndex].text == ""){
                    	ComShowMessage(ComGetMsg("AGT10030")); // 삭제할 그룹명을 선택하세요..
                    	slct_itm_fom_num.focus();
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
    /**
     * Group combo 데이타를 재조회한다.
     */
    function reSetRptGroup(groupSeq){

        var formObj = document.form;
        
        formObj.f_cmd.value = "";
        formObj.param1.value = "div_rptGroup"; // divId
        formObj.param2.value = "slct_itm_fom_seq";  // cboNm
        formObj.param3.value = groupSeq;    // defaultValue
        formObj.param4.value = " onChange='cboRptGroup_OnChange(this);' style='width:120'";   // addProperties
        formObj.param5.value = "rptGroup";     // workName
        formObj.param6.value = formObj.userId.value; // param(userId)
        formObj.param7.value = " ";            // allYN
        formObj.param8.value = "";             // addOption
        
        formObj.target = "frmHidden";
        formObj.action = "ESM_AGT_COMBO.do";
        formObj.submit();
    }

    /**
     * OK 버튼 클릭시 처리
     */   
	function popUpOk(sheetObj,formObj) {
//		alert(sheetObj.RowCount);
        var col_desc = "";
        var col_nm = "";
        var param = "";
        var lstcol = sheetObj.LastRow ;
//        alert(lstcol);

        if(sheetObj.RowCount <= 0) {
        	ComShowMessage(ComGetMsg("AGT10022", "apply")); // There is no contents to save
            return false;
        }
                    
        for(var i = 1; i <= lstcol; i++ ){
        	col_desc = col_desc + sheetObj.CellValue(i, "rpt_itm_desc") ;
            col_nm = col_nm + sheetObj.CellValue(i, "rpt_itm_col_nm") ;
            if(i != lstcol){
            	col_desc = col_desc + "|";
                col_nm = col_nm + "|";
            }
        }
        
     // 모달인 경우 Opener를 구해온다.
        
		if(!opener) {
			opener = window.dialogArguments;
		}
		opener.reSetHeader(col_desc, col_nm);
		window.close();
	} 
	
    /**
     * Close 버튼 클릭시 처리
     */   
	function popUpClose() {
	    /*
		if(!opener) // 모달인 경우 Opener를 구해온다.
			opener = window.dialogArguments;
		opener.reSetRptGroup();
		*/ 
	    window.close();
	}
	