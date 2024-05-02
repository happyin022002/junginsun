/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0111.js
*@FileTitle : S/C Performance Summary - View B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.04 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview S/C Performance Summary - View B/L 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_0111 : ESM_PRI_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0111() {
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
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
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

        sheet1.WaitImageVisible = false;    

        if(form.sc_no.value == "") { window.close(); }	

        doActionIBSheet(sheet2, form, IBBATCH);    

    }

    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                    //높이 설정
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    var HeadTitle1 = "Seq.|B/L No.|VVD|Shipper|Consignee|Notify|F/Forwarder|A/Notify|A/Customer|Commodity|POR|POL|POD|DEL|B/L Onboard\nDate|Container No.|CNTR TP|Lane|Commodity Group|B/L CRD|Receiving Term|Delivery Term|FEU|Vol.";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ , dtSeq     ,40     ,daCenter   ,true    ,"seq"             );                                  
                    InitDataProperty(0, cnt++ , dtData    ,90     ,daCenter   ,false   ,"bl_no"          ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daCenter   ,false   ,"vvd"            ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"s_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"c_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"n_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"f_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"a_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false); 
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"act_cust_nm"    ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"cmdt_nm"        ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"por_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"pol_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"pod_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"del_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,75     ,daCenter   ,false   ,"bl_obrd_dt"     ,false   ,""        ,dfDateYmd      ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,90     ,daCenter   ,false   ,"cntr_no"    	 ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"cntr_tpsz_cd"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"slan_cd"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,140     ,daCenter   ,false   ,"grp_cmdt_cd"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,80     ,daCenter   ,false   ,"cgo_rcv_dt"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,100     ,daCenter   ,false   ,"rcv_term_cd"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,100     ,daCenter   ,false   ,"de_term_cd"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtAutoSum    ,60     ,daRight    ,false   ,"op_cntr_qty"    ,false   ,""        ,dfNullFloat    	 ,3         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtAutoSum    ,30     ,daRight    ,false   ,"cntr_vol_qty"	 ,false   ,""        ,dfNullFloat    	 ,2         ,false     ,false);

                    AutoSumBottom = 1;
                }
                break;

            case "sheet2": // find_text 용
                with (sheet2) {

                    //높이 설정
                    style.height = 80;
                    //전체 너비 설정
                    SheetWidth = 300;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    var HeadTitle1 = "f_text1"
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME   ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"f_text1"  ,false   ,""        ,dfNone    ,0 );

                    var idx = sheet2.DataInsert();

                    Visible = false; // backendjob 용으로 같이씀 참고 : 0015

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
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function processButtonClick(){
        var form = document.form;
        var rdoDateObj = form.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                    //doActionIBSheet(sheet1, form, IBSEARCH);
                    doActionIBSheet(sheet2, form, IBBATCH);
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

    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;

        switch(sAction) {
            case IBBATCH: //backendjob 조회

                try {

                    ComOpenWait(true);
                    sheet1.WaitImageVisible = false;
                    sheet2.WaitImageVisible = false;	    	

                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheet2.GetSearchXml("ESM_PRI_0111GS.do", FormQueryString(formObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value = backendJobKey;
                        sheet2.RequestTimeOut = 10000;
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
                        // getBackEndJobStatus함수
                        // 실행 - 재귀호출
                    }else{
                        ComOpenWait(false);
                    }
                }catch(e){
                    ComShowMessage(e);
                    ComOpenWait(false);
                }

                break;

            case IBSEARCH: //조회

                ComOpenWait(true);

                formObj.f_cmd.value = SEARCH;
                sheet1.DoSearch("ESM_PRI_0111GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;

            case IBDOWNEXCEL:      //download excel
                //SpeedDown2Excel(-1);
                //sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
                sheet1.SpeedDown2Excel(-1);
                break;

        }
    }

    /** 
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function getBackEndJobStatus() {
        try {
            var form = document.form;	
            form.f_cmd.value = SEARCH;
            var sXml = sheet2.GetSearchXml("ESM_PRI_0111GS.do", FormQueryString(form));
            var jobState = ComGetEtcData(sXml, "jb_sts_flg");
            if (jobState == "3") {
                getBackEndJobLoadFile();
                clearInterval(timer);
            } else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
                ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
                clearInterval(timer);	
                ComOpenWait(false);	
            } else if (jobState == "5") {
                ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
                clearInterval(timer);
                ComOpenWait(false);	
            }
        }catch(e){
            ComShowMessage(e);
            ComOpenWait(false);
        }
    }

    /** 
     * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital) <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function getBackEndJobLoadFile() {
        try {	
            var form = document.form;
            form.f_cmd.value = SEARCHLIST;

            //var sXml = sheet1.GetSearchXml("ESM_PRI_0111GS.do", FormQueryString(form));
            //sheet1.LoadSearchXml(sXml);
            // DoSearch4Fx 용
            sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOCALC";
            sheet1.DoSearch4Fx("ESM_PRI_0111GS.do", FormQueryString(form));
//            sheet1.DoSearch("ESM_PRI_0111GS.do", FormQueryString(form));

            //form.result.value = ComGetEtcData(sXml, "RESULT");
        }catch(e){
            ComShowMessage(e);
        }finally{        	
            ComOpenWait(false);        		
        }
    }