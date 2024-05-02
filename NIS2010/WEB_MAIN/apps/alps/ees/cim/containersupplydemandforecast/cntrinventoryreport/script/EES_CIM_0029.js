/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0029.js
*@FileTitle : Stock Report (CNTR Data)
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.13 김종준
* 1.0 Creation
=========================================================*/
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
         var shtCnt = 0;
         var sheet1 = sheetObjects[shtCnt++];


         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_Downexcel":
            		sheet1.SpeedDown2Excel(true);
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
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);		
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id ; 

        switch(sheetID) {
            
             case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 275;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
                   
                    var HeadTitle1 = "Yard|CNTR No.|TP/SZ|Damage|Term|BKG No.|VVD|Gate In";
                     

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData, 	  	 65,    daCenterTop,true,   "loc_cd",  		false,          "",      dfNone     );
                    InitDataProperty(0, cnt++ , dtData, 		120,    daCenter,  	true,   "cntr_no",  	false,          "",      dfNone,       0     );
                    InitDataProperty(0, cnt++ , dtData, 		 45,    daCenter,  	true,   "cntr_tpsz_cd", false,          "",      dfNone,       0     );
                    InitDataProperty(0, cnt++ , dtCheckBox,		 60,   	daCenter,  	true,	"dmg_flg",     	false,			"",		 dfNone);
                    InitDataProperty(0, cnt++ , dtData,     	 50,    daCenter,  	true,   "lstm_cd", 		false,          "",      dfNone,       0     );
                    InitDataProperty(0, cnt++ , dtData,     	120,    daCenter,  	true,   "bkg_no",  		false,          "",      dfNone,       0     );
                    InitDataProperty(0, cnt++ , dtData,     	 80,    daCenter,  	true,   "vvd",       	false,          "",      dfNone,       0     );
                    InitDataProperty(0, cnt++ , dtData,   		 90,    daCenter,  	true,   "cnmv_dt",    	false,          "",      dfDateYmd,       0     );
                }
                break; 

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   sheetObj.WaitImageVisible=false;
	    	   ComOpenWait(true);	    	   
	    	   formObj.f_cmd.value = SEARCH;
	    	   sheetObj.DoSearch("EES_CIM_0029GS.do",FormQueryString(formObj));
	    	   ComOpenWait(false);
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

    /**
     * 화면 조회 종료후 프로세스 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject = document.form;
    	var obj_cntr_tpsz_cd = formObject.obj_cntr_tpsz_cd.value;
    	obj_cntr_tpsz_cd = obj_cntr_tpsz_cd.split("|")
    	
    	var cnt_cntr_tpsz_cd = sheetObj.CellValue(sheetObj.LastRow, "cntr_no");
    	cnt_cntr_tpsz_cd = cnt_cntr_tpsz_cd.split("|");
    	var totStr = "";
    	for ( var i=0; i<cnt_cntr_tpsz_cd.length; i++) {
    		if ( cnt_cntr_tpsz_cd[i] > 0 ) {
    			totStr = totStr + obj_cntr_tpsz_cd[i] +" : "+ComAddComma(eval(cnt_cntr_tpsz_cd[i]))+",  ";
    		}
    	}
    	totStr = totStr.trim().substr(0,totStr.length-3);
    	formObject.total_cnt.value = ComAddComma(sheetObj.rowCount-1);
    	formObject.total.value = totStr;
    	sheetObj.RowDelete(sheetObj.LastRow,false);
    	sheetObj.SelectHighLight = false;
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	    