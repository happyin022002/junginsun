/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_9452.js
*@FileTitle : Retroactive RFA Approval Auth - User Level (History)
*Open Issues :
*Change history :
*@LastModifyDate : 2016-09-02
*@LastModifier : Min-Gyung Lee
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview  Filed Cancel Activity (History) 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_9452 : ESM_PRI_9452 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_9452() {
        this.setSheetObject 		= setSheetObject;
        this.loadPage 				= loadPage;
        this.initSheet 				= initSheet;
        this.processButtonClick		= processButtonClick;
        this.doActionIBSheet 		= doActionIBSheet;
    }

    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1;
    var sheet2;
    //  업무전역변수
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     */ 
    function loadPage() {
        var form = document.form;	
        sheet1 = sheetObjects[0];
        sheet2 = sheetObjects[1];
        sheetCnt = sheetObjects.length ;
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
        
        //sheet1.WaitImageVisible = f alse;    

//        if(form.sc_no.value == "") { window.close(); }	
//
//        doActionIBSheet(sheet2, form, IBBATCH);    
        doActionIBSheet(sheet1, form, IBSEARCH);
    }

    /** 
     * Sheet 기본 설정 및 초기화 <br>
     */ 
    function initSheet(sheetObj, sheetNo) {
    	var form = document.form;
        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                // 높이 설정
                style.height = 200;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1  = "|Office|GID|Name|Y/N|Update\nDate(KST)|Update Staff|Update Staff";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 		"ibflag");
				InitDataProperty(0, cnt++ , dtData,    	100,   	daCenter,  	false,		"auth_apro_usr_ofc_cd", false,   "",      dfNone,     0,			false,       	false);
				InitDataProperty(0, cnt++ , dtData,     100,   	daLeft,  	false,		"auth_apro_usr_id",   	false,  "",      dfNone,     0,			false,       	false);
				InitDataProperty(0, cnt++ , dtData,    	230,   	daLeft,  	false,		"auth_apro_desc",   	false,  "",      dfNone,     0,			false,       	false);
				InitDataProperty(0, cnt++ , dtCombo,     80,    daCenter,   false,   	"auth_apro_use_flg",    false,  	"",  	 dfNone,     0, 		false,   		false);
				InitDataProperty(0, cnt++ , dtData,     100,    daCenter,   false,   	"prog_gdt",    			false,  	"",  	 dfNone,     0, 		false,   		false);
				InitDataProperty(0, cnt++ , dtData,     100,    daLeft,   true,   	"prog_usr_id",    		false,  	"",  	 dfNone,     0, 		false,   		false);
				InitDataProperty(0, cnt++ , dtData,     100,    daLeft,   true,   	"prog_usr_nm",    		false,  	"",  	 dfNone,     0, 		false,   		false);
				
				WaitImageVisible = false;
				InitDataCombo(0,    "auth_apro_use_flg", "YES|NO",    "Y|N"   ,"YES",   "Y");
                }
                break;

        }
    }

    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     */ 
    function processButtonClick(){
        var form = document.form;
        var rdoDateObj = form.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheet1, form, IBSEARCH);
                    //doActionIBSheet(sheet2, form, IBBATCH);
                    break;

                case "btn_excel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;

                case "btn_close":
                    window.close();
                    break;


            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH: //조회

                ComOpenWait(true);
                	
                formObj.f_cmd.value = SEARCHLIST01;
                sheet1.DoSearch("ESM_PRI_9452GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;

            case IBDOWNEXCEL:      //download excel
                sheet1.SpeedDown2Excel(-1);
                break;

        }
    }
