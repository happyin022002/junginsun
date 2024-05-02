/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0058.js
*@FileTitle : S/C Proposal Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.06 김귀진
* 1.0 최초 생성
=========================================================*/


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/**
 * Customer 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * 
 * 
 **/

    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_apply":
 
   	              doActionIBSheet(sheetObject,formObject,IBSAVE);
         	      break;

        	    case "btn_close":

    	           window.close();
        	       break;

                case "btn_downexcel":
                   doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                   break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
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
    	
    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	 
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
                    //전체 너비 설정
                    style.height = GetSheetHeight(11) ;
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
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "No.|STS|Priority|ORG.LOC|Node|DEST.LOC|Node|Route " ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    "",                false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",          false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  false,    "prio_seq",        true,           "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "org_loc",         false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "org_loc_type",    false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "dest_loc",        false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "dest_loc_type",   false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       470,    daLeft,   false,    "route",           false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "ori_prio_seq",    true,           "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "rout_org_nod_cd", false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "rout_dest_nod_cd",false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "rout_seq",        false,          "",       dfNone,       0,     true,       true);
                    InitDataCombo (0, "prio_seq", " |", " |");

					InitDataValid(0, "org_loc",       vtEngUpOther, "1234567890");
					InitDataValid(0, "org_loc_type",  vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc",      vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc_type", vtEngUpOther, "1234567890");
					
					WaitImageVisible=false;
               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction));
	            ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_PRD_0058GS.do", PrdFQString(formObj));
                priority_seq = sheetObjects[0].EtcData("prio_seq_combo");
                sheetObjects[0].InitDataCombo (0, "prio_seq", sheetObjects[0].EtcData("prio_seq_combo"),sheetObjects[0].EtcData("prio_seq_combo"));
                maxPrioSeq = sheetObjects[0].EtcData("maxPrioSeq");
                
                sheetObj.DoSearch4Post("ESD_PRD_0058GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;
            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction));
            	ComOpenWait(true);
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESD_PRD_0058GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;

           case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.Down2Excel(-1, false, false, true);
                break;
        }
    }

  
    /*
     * priority 를 중복처리 가능하게 되므로 새롭게 만듬 
     * 밑에 같은 이름은 주석으로 막아놈.
     */
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        if(sheetObj.ColSaveName(Col)=="prio_seq" && Value ==0 ){
            sheetObj.CellValue2(Row,"prio_seq") = sheetObj.CellValue(Row,"ori_prio_seq");
            ComShowMessage("Not select Value 0."    );
            return false;
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
    
    function sheet1_OnSaveEnd(sheetObj,errMsg)  {
         //var iRow = document.form.openSheetRow.value;

    	if(errMsg=="" || errMsg == "Data was saved successfully." || errMsg == "Saved data successfully."){
            var openerSheet = window.opener.document.sheet1 ;
            for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                    if(openerSheet.FindText("rout_seq", sheetObj.CellValue( i, "rout_seq") , 0,-1) != -1){
                     	openerSheet.CellValue2( openerSheet.FindText("rout_seq", sheetObj.CellValue( i, "rout_seq") , 0,-1), "prio_seq" ) = sheetObj.CellValue( i, "prio_seq") ;
                     	
                     	if(openerSheet.RowStatus(openerSheet.FindText("rout_seq", sheetObj.CellValue( i, "rout_seq") , 0,-1))=='U'){
                     		openerSheet.RowStatus(openerSheet.FindText("rout_seq", sheetObj.CellValue( i, "rout_seq") , 0,-1)) = 'R';
                     	}
                     	
                    }
            }
            window.close();             
            
         } else {
             ComShowMessage(ComGetMsg('COM12151',''));
             window.close();  
         }

    }    
    