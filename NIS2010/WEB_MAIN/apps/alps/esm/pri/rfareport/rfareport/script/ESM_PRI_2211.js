/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0111.js
*@FileTitle : Master RFA Inquiry (& Copied RFA List) - B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Master RFA Inquiry (& Copied RFA List) - B/L List 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
                    var HeadTitle1 = "Seq.|Scope|RFA No.|AMD No.|Source|Customer\nType|Customer\nName|Contract\nOffice|Contract\nS.Rep|Loading\nOffice|Loading\nS.Rep|Rev.\nWK|B/L No.|Lane|VVD|SHPR|CNEE|F/F|CMDT|POR|R.Term|POL|POD|DEL|D.Term|B/L Onboard\nDate|CNTR No.|CNTR TP|TEU*";
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow( 0, HeadTitle1, true);

//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ , dtSeq     ,30     ,daCenter   ,true    ,"seq"             );
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"svc_scp_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,80     ,daCenter   ,false   ,"rfa_no"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"amdt_seq"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,140     ,daCenter   ,false   ,"src"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,80     ,daCenter   ,false   ,"cust_tp"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,230     ,daCenter   ,false   ,"cust_nm"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"ctrt_ofc_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"ctrt_srep_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"ob_sls_ofc_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"ob_srep_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"cost_wk"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,90     ,daCenter   ,false   ,"bl_no"          ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"slan_cd"        ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daCenter   ,false   ,"vsl_cd"            ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,200    ,daLeft     ,false   ,"s_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,200    ,daLeft     ,false   ,"c_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,200    ,daLeft     ,false   ,"f_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,120    ,daLeft     ,false   ,"cmdt"        ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"por_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"r_term"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"pol_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"pod_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"del_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"d_term"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    
                    InitDataProperty(0, cnt++ , dtData    ,90     ,daCenter   ,false   ,"bl_obrd_dt"     ,false   ,""        ,dfDateYmd      ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,90     ,daCenter   ,false   ,"cntr_no"    	 ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"cntr_tpsz_cd"   ,false   ,""        ,dfNone    	 ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData	  ,30     ,daCenter    ,false   ,"teu"    ,false   ,""        ,dfNone    	 ,3         ,false     ,false);

                    if("M" == ComGetObjValue(form.rfa_tp_cd)){
                    	ColHidden("source") = true;
                    	ColHidden("cust_tp") = true;
                    	ColHidden("cust_nm") = true;
                    	ColHidden("ctrt_ofc_cd") = true;
                    	ColHidden("ctrt_srep_cd") = true;
                    }
                    	
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
                sheet1.DoSearch("ESM_PRI_2211GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;

            case IBDOWNEXCEL:      //download excel
                sheet1.SpeedDown2Excel(-1);
                break;

        }
    }
