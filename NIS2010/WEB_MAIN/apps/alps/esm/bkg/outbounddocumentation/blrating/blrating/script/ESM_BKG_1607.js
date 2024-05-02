/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1607.js
*@FileTitle : Doc Surcharge Exemption Approval Remark
*Open Issues :
*Change history :
*@LastModifyDate : 20
*@LastModifier : Jeongmin CHO
*@LastVersion : 1.0
* 2010.02.12 Jeongmin CHO
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_BKG_1607 : ESM_BKG_1607 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1607() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            
            case "btn_Approve":
        		if(!opener) opener = window.dialogArguments; 
        		var openerForm =  opener.document.form;
        		var openerSheet =  opener.sheetObjects[0];
        		
        		for(var i = sheetObject1.HeaderRows; i <= sheetObject1.LastRow; i++){
            		for(var j = openerSheet.HeaderRows; j <  openerSheet.HeaderRows + openerSheet.RowCount; j++) {
            			if((sheetObject1.CellValue(i,"bkg_no") == openerSheet.CellValue(j,"bkg_no"))
            					&&(sheetObject1.CellValue(i,"chg_amd_seq") == openerSheet.CellValue(j,"chg_amd_seq"))){
            				 openerSheet.CellValue2(j,"apro_rmk") = sheetObject1.CellValue(i,"apro_rmk");
            			}
            		}
        		}
        		opener.doActionIBSheet(openerSheet,openerForm,IBSEARCH_ASYNC01);
        		window.close();
                break;
                
            case "btn_Reject":
        		if(!opener) opener = window.dialogArguments; 
        		var openerForm =  opener.document.form;
        		var openerSheet =  opener.sheetObjects[0];
        		
        		for(var i = sheetObject1.HeaderRows; i <= sheetObject1.LastRow; i++){
            		for(var j = openerSheet.HeaderRows; j <  openerSheet.HeaderRows + openerSheet.RowCount; j++) {
            			if((sheetObject1.CellValue(i,"bkg_no") == openerSheet.CellValue(j,"bkg_no"))
            					&&(sheetObject1.CellValue(i,"chg_amd_seq") == openerSheet.CellValue(j,"chg_amd_seq"))){
            				 openerSheet.CellValue2(j,"apro_rmk") = sheetObject1.CellValue(i,"apro_rmk");
            			}
            		}
        		}
        		opener.doActionIBSheet(openerSheet,openerForm,IBSEARCH_ASYNC02);
        		window.close();
                break;
                
            case "btn_Close":
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        
		if(!opener) opener = window.dialogArguments; 
		var openerForm =  opener.document.form;
		var openerSheet =  opener.sheetObjects[0];

		if(document.form.gubun.value == "A"){
	 		eval('DIV_BNT2').style.display = 'none';
	 		eval('DIV_BNT1').style.display = 'block';
		}else{
	 		eval('DIV_BNT1').style.display = 'none';
	 		eval('DIV_BNT2').style.display = 'block';
		}

 		
		var selRows = openerSheet.FindCheckedRow("chk");
		var idxArr = selRows.split("|");
		for(var i=0; i < idxArr.length-1; i++) {
    		var row = sheetObjects[0].DataInsert(-1);
    		sheetObjects[0].CellValue2(row,"bkg_no") = openerSheet.CellValue(idxArr[i],"bkg_no");
    		sheetObjects[0].CellValue2(row,"chg_amd_seq") = openerSheet.CellValue(idxArr[i],"chg_amd_seq");
		}
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 300;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "Seq.|Booking No.||Approval Remark";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,          40,   daCenter,    true,  "seq");
                    InitDataProperty(0, cnt++, dtData,			110,  daCenter,    true,  "bkg_no",              false,    "",      dfNone,      0,    false,   false);
                    InitDataProperty(0, cnt++, dtHidden,		110,  daCenter,    true,  "chg_amd_seq",         false,    "",      dfNone,      0,    false,   false);
                    InitDataProperty(0, cnt++, dtData,			200,  daLeft,  	   true,  "apro_rmk",	         false,    "",      dfNone,      0,    false,   false);
                    
                
                    CountPosition = 0;
            }
                
            break;

        }
    }


    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        case IBSEARCH:      //조회
            
            break;

        
        }
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
    	switch(colname){
	    	case "apro_rmk":
	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200); 
	    		break;
    	} 

   }
    
    // 검색 완료 이벤트 처리
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

    }    
    

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
            
          	case IBSEARCH:
       	    	break;
    
            }
        }
         
        return true;
    }    
    

	/* 개발자 작업  끝 */