/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_1007.js
*@FileTitle : EQR Organization Chart 
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 공통전역변수 */
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var CheckRow;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

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
            /***********************************************************************************************************
                이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
                공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.        
             **********************************************************************************************************/
            /*
               이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
               메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
               (순서상도 form[1]이 되겠죠?) 
               그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
                document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
            */
            switch(srcName) {
                case "btn_retrieve":
                    // Port 여부 세팅
                    if(formObject.chk_port_ind.checked) {
                        formObject.loc_port_ind.value = "1";
                    } else {
                        formObject.loc_port_ind.value = "0";
                    }
                    
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
    
                case "btn_Close":
                    self.close();
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
            } // end switch
        }catch(e) {            
            /*
            자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
            물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
            */
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
 
    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
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
            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        sheetObjects[0].ShowTreeLevel(2,1);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 322 ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 0, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "sts||Location Code|loc_dpth_cd|loc_cd|prnt_loc_id|tlevel";//|rowseq" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [    ROW, COL,  DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,      "ibflag",       false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,     30,    daCenter,   false,      "chk",          false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,        160,    daLeft,     false,      "unit",         false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daLeft,     false,      "loc_dpth_cd",  false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daLeft,     false,      "loc_cd",       false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daLeft,     false,      "prnt_loc_id",  false,      "",         dfNone,     0,          false,      false);
					InitDataProperty(0, cnt++ , dtHidden,       30,    daLeft,     false,      "tlevel",       false,      "",         dfNone,     0,          false,      false);
					
					//sheetObj.RowHidden(0) = true;
                    
					SelectHighLight = false;
                    //WaitImageVisible = false;
					CheckAllImageVisible = true;
					
                    InitTreeInfo(2, "level", RgbColor(0,0,255), true);
                    ShowTreeLevel(2);
                    CountPosition = 2;
                    CountFormat = "";  
               }
                break;

        }
    }
    
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

			case IBSEARCH:        //조회
			    if(!validateForm(sheetObj,formObj,sAction)) {
			        return false;
			    }
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
			    formObj.f_cmd.value = SEARCH;                
			    selectVal = FormQueryString(formObj)
			    sheetObj.DoSearch4Post("EES_EQR_1007GS.do", selectVal);    
				ComOpenWait(false);   
				sheetObj.WaitImageVisible=true;        
			break;
		
            case IBSAVE:
				if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
				formObj.f_cmd.value = MULTI;             
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var SaveStr = FormQueryString(formObj) +"&"+ sheetObj.GetSaveString(true); 
				var sXml = sheetObj.GetSaveXml("EES_EQR_1007GS.do",SaveStr); 
				var transRsltKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				
				if (transRsltKey == "S") {
				    ComShowCodeMessage("EQR01001"); // 저장 성공
				}
				else {
				    ComShowCodeMessage("EQR01002"); // 저장 실패
				}
				ComOpenWait(false);
				sheetObj.WaitImageVisible=true;
			break;
        }
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
        return true;
    }
    var lh = true;   
    var checkLevel = 0 ;
    
	function sheet_OnChange( sheetObj , Row , Col , Value)
    {   
	    var checkedRow = sheetObj.CheckedRows("chk");
	    sheetObj.CountFormat = "["+checkedRow+" / TOTALROWS]";
    }
	
    function sheet_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH)
    {   
	    if(sheetObj.ColSaveName(Col)=="chk" ){
			// 상위 조직 check/uncheck 따라서 하위 조직 check/uncheck
	        if(sheetObj.CellValue(Row,"tlevel")!="5"){
	            for(var i=Row+1; i<=sheetObj.LastRow; i++){
	                if(sheetObj.CellValue(i,"tlevel") > sheetObj.CellValue(Row,"tlevel")){
						// OnClick 은 값 바뀌기 전 이므로 1,0 반대로 함 
	                    sheetObj.CellValue2(i,"chk") = (sheetObj.CellValue(Row,Col)+1)%2; 
	                }else if(sheetObj.CellValue(i,"tlevel") <= sheetObj.CellValue(Row,"tlevel")){
	                    break;
	                }
	            }
	        }   
	        
	        // 하위 조직 check 시 상위 조직도 check
	        if(sheetObj.CellValue(Row,Col) == '0'){ // unchecked 상태에서 클릭 
	            var targetLevel = sheetObj.CellValue(Row,"tlevel")*1 - 1;
	            for(var i=Row-1; i>=sheetObj.HeaderRows; i--){
	                if (sheetObj.CellValue(i, "tlevel") == targetLevel) {
	                    sheetObj.CellValue2(i,"chk") = '1';
	                    targetLevel--;          
	                }
	            }
	        }
			
			// checked 된 갯수 표시
			var checkedRow = sheetObj.CheckedRows("chk");
            if (sheetObj.CellValue(Row, Col) == '0') { // unchecked 상태에서 클릭 
			    checkedRow = checkedRow + 1;
			}else{
				checkedRow = checkedRow - 1;
			}
            sheetObj.CountFormat = "["+checkedRow+" / TOTALROWS]"; 
	    }
    }	
	
    function sheet_OnSearchEnd(sheetObj, ErrMsg){
		var sumChecked = sheetObj.ComputeSum("|1|");
		if(sumChecked == 0){
			sheetObj.CheckAll2("chk") = 1;
		}
		
		var checkedRow = sheetObj.CheckedRows("chk");
        sheetObj.CountFormat = "["+checkedRow+" / TOTALROWS]";  
    }