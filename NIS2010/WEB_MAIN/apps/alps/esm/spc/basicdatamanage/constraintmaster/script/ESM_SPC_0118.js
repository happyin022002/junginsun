/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0118.js
*@FileTitle : Report From
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 김승만
*@LastVersion : 1.0
*Cr반영용
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_SPC_0118 : ESM_SPC_0118 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0118() {
    this.processButtonClick = processButtonClick ; 
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.chgGroup           = chgGroup           ;
    this.selGroup_onChange  = selGroup_onChange  ;
    this.sheet1_OnDblClick  = sheet1_OnDblClick  ;
    this.sheet2_OnDblClick  = sheet2_OnDblClick  ;
    this.sheet2_OnMouseMove = sheet2_OnMouseMove ;
    this.sheet2_OnSaveEnd   = sheet2_OnSaveEnd   ;
    this.addRow             = addRow             ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
}


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        try {
            switch(srcName) {
                case "btn_New":
                    sheetObject1.RemoveAll();
                    formObject.reset();
                    break;

                case "btn_Delete":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE);
                    sheetObject1.RemoveAll();
                    //formObject.reset();
                    
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject1,formObject, IBSAVE);
                    break;

                case "btns_add":
                    var sRowStr = sheetObject.GetSelectionRows("/");   //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    var arr = sRowStr.split("/");

                    for (var j=0; j<arr.length; j++) {
                        var findRow = sheetObject1.FindText("dp_seq", sheetObject.CellValue(arr[j],"dp_seq"), 0, -1);
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
                    break;

                case "btns_up":
                    var sRowStr = sheetObject1.GetSelectionRows("/");  //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    var arr = sRowStr.split("/");

                    sheetObject1.DataMove(Number(arr)-1);

                    break;

                case "btns_down":
                    var sRowStr = sheetObject1.GetSelectionRows("/");  //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    var arr = sRowStr.split("/");

                    sheetObject1.DataMove(Number(arr)+2);

                    break;

                case "btn_Close":
                    var col_desc = "";
                    var col_nm = "";
                    var param = "";
                    var lstcol = sheetObject1.LastRow ;
                    
                    for(var i = 1; i <= lstcol; i++ ){
                        col_desc = col_desc + sheetObject1.CellValue(i, "to") ;
                        col_nm = col_nm + sheetObject1.CellValue(i, "rpt_itm_col_nm") ;
                        if(i != lstcol){
                            col_desc = col_desc + "|";
                            col_nm = col_nm + "|";
                        }
                    }
                    opener.document.form.f_header.value = col_nm;
                    opener.document.form.f_headernm.value = col_desc;
                    opener.chgInitSheet();
                    if(document.form.saveYn[1].checked){
                        param = ComGetObjValue(formObject.f_selgroup);
                    }
                    opener.chgGroup(param);
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        
        //멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            //initCombo(comboObjects[k], k+1);
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        
        
        doActionIBSheet(sheetObject,formObject,IBSEARCH);  // 데이타를 보기위해 바로 호출 (추후 삭제)
        //preFormSet();
    }
     /**
      * 멀티콤보 항목을 설정한다.
      */
      function initCombo(comboObj, comboId) {
     	 with (comboObj) {
     		DropHeight = 200;
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
                    SheetWidth = mainTable1.clientWidth;                //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(7, 0, 0, true);                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = "Sts|2|3|4|5|6|From" ;
                    InitHeadRow(0, HeadTitle, false);                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,      30,    daCenter,  true,     "lstatus");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "pgm_no");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "rpt_fom_desc");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "dp_seq");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "rpt_itm_col_nm");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "rpt_fom_no");
                    InitDataProperty(0, cnt++, dtData,        80,    daLeft,    true,     "from",   false,  "",   dfNone,   0,   false,  false);

                    SelectionMode = smSelectionList;
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(11) ;
                }
                break;

            case 2:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable2.clientWidth;                    //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                              //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                        //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(8, 0, 0, true);                          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, true,false);     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = "Sts|2|3|4|5|6|To|0" ;
                    InitHeadRow(0, HeadTitle, false);                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,30,    daCenter,  true,     "lstatus");
 
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "pgm_no");
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "rpt_fom_desc");
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "dp_seq");
                    InitDataProperty(0, cnt++,  dtHidden,      30,    daCenter,  true,     "rpt_itm_col_nm");
                    InitDataProperty(0, cnt++, dtHidden,      30,    daCenter,  true,     "rpt_fom_no");
                    InitDataProperty(0, cnt++ , dtData,        80,    daLeft,    true,     "to",        false,    "",       dfNone,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtDataSeq,30,    daCenter,  true,     "sht_seq");
                    
                    ColHidden(cnt-1) = true;
                    SelectionMode = smSelectionList;
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(11) ;
                }
                break;
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
     *  그룹코드 변경시
     *  sheet2정보를 조회한다.
     */
     function f_selgroup_OnChange(obj, code){
        var formObj = document.form;
        var sheetObject1 = sheetObjects[1];
//       var a = document.getElementById('f_selgroup').options[document.getElementById('f_selgroup').options.selectedIndex].text;
//        var a=$("#f_selgroup option:selected").val();
//        var b =$("select[f_selgroup=f_selgroup]").val();
        formObj.rpt_fom_nm.value = formObj.f_selgroup.text;
        formObj.f_cmd.value = SEARCHLIST02;
        //20100414 이중환, FormQueryString -> coaFormQueryString 변경
        sheetObject1.DoSearch4Post("ESM_SPC_0118GS.do", FormQueryString(formObj)); 
        
        formObj.f_savename.value = formObj.f_selgroup.Text;
        formObj.f_group.value = formObj.f_selgroup.Text;
        formObj.f_rpt_fom_desc.value = sheetObject1.CellValue(1,"rpt_fom_desc");
    }

    /**
     *  sheet1에서 선택된 정보를 sheet2에 추가한다.
     */
    function sheet1_OnDblClick(sheetObj , row, col , value) {
        var sheetObj2 = sheetObjects[1];
        var findRow = sheetObj2.FindText("rpt_itm_col_nm", sheetObj.CellValue(row,"rpt_itm_col_nm"), 0, -1);
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

    function sheet2_OnMouseMove(sheetObj, button, shift, x, y){
        // 마우스 위치를 행과 컬럼 가져오기
        var row = sheetObj.MouseRow;
        var col = sheetObj.MouseCol;
    }

    /**
     * sheet2를 저장하고 나서 처리할 사항
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg){
    	var formObj = document.form; 
        var grop_cd = sheetObj.EtcData("selGroup");
        // save group combo를 변경시킨다
        //-----------------------------
        doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
        ComSetObjValue(formObj.f_selgroup,grop_cd);
        //-----------------------------
        if(ErrMsg==''){
        	ComShowCodeMessage("COM130102", "Data");
        }
        
    }

    /**
     * sheet1의 내용을 sheet2에 추가한다.
     */
    function addRow(selRow){
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var row = sheetObj2.DataInsert(-1);

        // 문제점 : pgm_no이 디폴드 값이 들어간다.
        //         저장시점에 사용할때 문제의 소지가 있으므로 이것을 사용하는 것을 피해야한다.
        //         대신 selGroup의 값을 사용하기 바란다.
        sheetObj2.CellValue(row, "pgm_no")  = sheetObj1.CellValue(selRow, "pgm_no");
        sheetObj2.CellValue(row, "rpt_fom_desc") = sheetObj1.CellValue(selRow, "rpt_fom_desc");
        sheetObj2.CellValue(row, "dp_seq")        =  sheetObj1.CellValue(selRow, "dp_seq");
        sheetObj2.CellValue(row, "rpt_itm_col_nm")    =  sheetObj1.CellValue(selRow, "rpt_itm_col_nm");
        sheetObj2.CellValue(row, "rpt_fom_no")    =  sheetObj1.CellValue(selRow, "rpt_fom_no");
        sheetObj2.CellValue(row, "to")                =  sheetObj1.CellValue(selRow, "from");
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
        	case IBCLEAR:          //조회
	        	formObj.f_cmd.value = SEARCHLIST12;
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0118GS2.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_selgroup, "code", "name");
				break;
			
            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCHLIST;
                //20100414 이중환, FormQueryString -> coaFormQueryString 변경
                sheetObj.DoSearch4Post("ESM_SPC_0118GS.do", FormQueryString(formObj));
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)) {
                	// 업무처리중 버튼사용 금지 처리
                	formObj.sht_flag.value="";
                	shtCheck(formObj);//시트(to) 체크
                	var formObj = document.form;
                	
                	var shtFlag=formObj.sht_flag.value
                	sheetObj.WaitImageVisible = false;
					
					ComOpenWait(true);
                    formObj.f_cmd.value = MULTI;
                    if(shtFlag=="Y"){
                    	formObj.f_dividename.value = "titlesave";
                    }else{
                    	formObj.f_dividename.value = "save";
                    }
                    
                    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
                    sheetObj.DoAllSave("ESM_SPC_0118GS.do", FormQueryString(formObj));
                    ComOpenWait(false);
                    //sheet2_OnSaveEnd(sheetObj, "");
                }
                break;

            case IBDELETE:        //삭제
                if(validateForm(sheetObj,formObj,sAction)) {
                    for(j=1; j<= sheetObj.LastRow; j++) sheetObj.RowStatus(j) = "D";
                    // 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = MULTI;
                    formObj.f_dividename.value = "delete";
                    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
                    sheetObj.DoAllSave("ESM_SPC_0118GS.do", FormQueryString(formObj));
                    
                    ComOpenWait(false);
                }
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	var formObj = document.form;
            if (saveYn[1].checked){
                if(f_savename.value == ""){
                    // [SPC13056] : 저장할 그룹명을 입력하세요.
                	ComShowMessage(ComGetMsg("COM12114", "Reprot Name"));
                    if(sAction == IBSAVE)f_savename.focus();
                    if(sAction == IBDELETE)f_selgroup.focus();
                    return false;
                }
//                else if(f_savename.value != ""){
//                	var a = ComGetObjText(formObj.f_selgroup);//document.getElementById('f_selgroup').option[0].text;
//                	
//                }
            } else {
                if(f_savename.value == ""){
                    saveYn[1].checked = true;
                    // [SPC13056] : 저장할 그룹명을 입력하세요.
                    ComShowMessage(getMsg("SPC13056"));
                    if(sAction == IBSAVE)f_savename.focus();
                    if(sAction == IBDELETE)f_selgroup.focus();
                    return false;
                }
            }
        }

        return true;
    }
    
    function preFormSet(){
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	if(document.form.f_p_col_desc.value!="" && document.form.f_p_call_cnt.value=="1"){
	    	var arr = document.form.f_p_col_desc.value.split("|");
	    	for (var k=0; k<arr.length; k++) {
	    		 var row = sheetObject1.DataInsert(-1);
	    		 for(var i=1; i<=sheetObject.LastRow; i++){
	    			if(sheetObject.CellValue(i,"from")==arr[k]){
	    				sheetObject1.CellValue(row, "pgm_no")  = sheetObject.CellValue(i, "pgm_no");
	    				sheetObject1.CellValue(row, "rpt_fom_desc") = sheetObject.CellValue(i, "rpt_fom_desc");
	    				sheetObject1.CellValue(row, "dp_seq")        = sheetObject.CellValue(i, "dp_seq");
	    				sheetObject1.CellValue(row, "rpt_itm_col_nm")    = sheetObject.CellValue(i, "rpt_itm_col_nm");
	    				sheetObject1.CellValue(row, "rpt_fom_no")    = sheetObject.CellValue(i, "rpt_fom_no");
	    				sheetObject1.CellValue(row, "to")                = sheetObject.CellValue(i, "from");
	    			}
	    		 }
	    	}
    	}
    }
    function shtCheck(formObj){
    	var sheetObject1 = sheetObjects[1];
    	var formObj1 = document.form;
    	var tpCount = 0;
    	for(var i=1; i<=sheetObject1.LastRow; i++){
			if(sheetObject1.CellValue(i,"dp_seq")!=sheetObject1.CellValue(i,"sht_seq")){
				sheetObject1.CellValue(i, "lstatus") = "I";
			}else{				
				tpCount=tpCount+1;
				if(sheetObject1.LastRow == tpCount){
					formObj1.sht_flag.value="Y";
				}
			}
			
		 }
    	return false;
    }