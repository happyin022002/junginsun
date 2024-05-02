/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0081.js
*@FileTitle : Booking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
* =======================================================
* 2010.11.30 남궁진호 [CHM-201007281-01] 
*             Accumulative Total, Q Type의  계산로직 변경
* 2011.03.21 신자영 [CHM-201109531-01] JOO/Booking Data Inquiry 기능 보완 - Double Calling Port 정보 표기 방법
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
     * @class FNS_JOO_0081 : FNS_JOO_0081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0081() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var colCnt =0;

    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */ 
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];

             /*******************************************************/
             var formObject = document.form;

     //        try {
                var srcName = window.event.srcElement.getAttribute("name");

                    switch(srcName) {

                        case "btn_Retrieve":
                            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                            break;

                        case "btn_DownExcel":

                            doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
                            break;

                } // end switch
//            }catch(e) {
//                if( e == "[object Error]") {
//                    ComShowMessage(OBJECT_ERROR);
//                } else {
//                    ComShowMessage(e);
//                }
//            }
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
         * IBCombo Object를 배열로 등록
         * param : combo_obj ==> 콤보오브젝트
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj) {
            comboObjects[comboCnt++] = combo_obj;
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
                sheetObjects[i].WaitImageVisible = false;
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            // IBMultiCombo초기화
            for(var k=0; k<comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            initControl();
            document.form.vvd.focus();
        }



         /**
         * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
         * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {int}     sheetNo     sheetObjects 배열에서 순번
         **/
        function initControl() {
            var formObject = document.form;
            axon_event.addListenerForm  ('keydown' , 'ComKeyEnter',  formObject);
            axon_event.addListenerForm  ('keyup'   , 'fnObjKeyUp', formObject );
            axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );


        }
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo, colCnt , sXmlTitle) {

            var cnt = 0;
            var formObj = document.form;
            switch(sheetNo) {

                case 1:      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 440;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet =  msAll;// msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;


                        if(colCnt == undefined){
                            InitRowInfo(1, 1, 1, 100);
                            var HeadTitle1 = "|LDG PORT|LDG PORT|";
                            var headCount = ComCountHeadTitle(HeadTitle1);
                            InitColumnInfo(headCount, 3, 0, true);
                            InitHeadMode(true, true, false, true, false,false);
                            InitHeadRow(0, HeadTitle1 , true);
                            InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,       false,       "Status");
                            InitDataProperty(0, cnt++ , dtData,                 50,     daCenter,       true,       "pol_cd"    ,    false,      "",                     dfNone,             0,          true,       true);
                            InitDataProperty(0, cnt++ , dtData,                 50,     daCenter,       true,       "type"      ,    false,      "",                     dfNone,             0,          true,       true);
                            return;
                        }

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(3, 1, 3, 100);

                        var HeadTitle1 = "|LDG PORT|LDG PORT|";
                        var HeadTitle2 = "|LDG PORT|LDG PORT|";
                        var HeadTitle3 = "|LDG PORT|LDG PORT|";

                        var fixTitlePerOne = "20_qty|40_qty|hc_qty|45_qty";
                        var addFixTitle    = "ac_ttl_20_qty|ac_ttl_40_qty|ac_ttl_hc_qty|ac_ttl_45_qty|ac_teu|ac_mt_teu|ttl_20_qty|ttl_40_qty|ttl_hc_qty|ttl_45_qty|teu|obd|teu_bak|mt_20_cnt|mt_40_cnt|mt_hc_cnt|mt_45_cnt|mt_type_teu|mt_teu";
                        var headCount      = ComCountHeadTitle(HeadTitle1)+colCnt * fixTitlePerOne.split("|").length +( addFixTitle.split("|").length -1 );

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 3, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       //InitHeadMode(true, true, false, true, false,false);
                       InitHeadMode(false, true, false, true, false,false);

                       HeadTitle1 += fnSetTitle( "head1", sXmlTitle);
                       HeadTitle2 += fnSetTitle( "head2", sXmlTitle);
                       HeadTitle3 += fnSetTitle( "head3", sXmlTitle);

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle1 , true);
                       InitHeadRow(1, HeadTitle2 , true);
                       InitHeadRow(2, HeadTitle3 , true);


                       //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,       true,       "Status");
                       InitDataProperty(0, cnt++ , dtData,                 50,     daCenter,       true,       "pol_cd"    ,    false,      "",                     dfNone,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,                 50,     daCenter,       true,       "type"      ,    false,      "",                     dfNone,             0,          true,       true);

                       var CalcuLogic20 = "";
                       var CalcuLogic40 = "";
                       var CalcuLogichc = "";
                       var CalcuLogic45 = "";

                       for (var i=0; i<colCnt; i++) {

                            for(var j=0;j<fixTitlePerOne.split("|").length;j++ ){
                                var aFixTitlePerOne = fixTitlePerOne.split("|");
                                var polCdTitle =  "pod"+(i+1)+"_"+aFixTitlePerOne[j] ;

                                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, polCdTitle, false,"", dfNullInteger, 0, false, true);
                            }
                            if(i<colCnt-1){
                                 CalcuLogic20 += "|pod"+(i+1)+"_20_qty|+";
                                 CalcuLogic40 += "|pod"+(i+1)+"_40_qty|+";
                                 CalcuLogichc += "|pod"+(i+1)+"_hc_qty|+";
                                 CalcuLogic45 += "|pod"+(i+1)+"_45_qty|+";
                            }else{
                                CalcuLogic20 += "|pod"+(i+1)+"_20_qty|";
                                CalcuLogic40 += "|pod"+(i+1)+"_40_qty|";
                                CalcuLogichc += "|pod"+(i+1)+"_hc_qty|";
                                CalcuLogic45 += "|pod"+(i+1)+"_45_qty|";
                            }
                       }

                       var  ratehc  = formObj.ratehc.value;
                       var  rate45  = formObj.rate45.value;

                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ac_ttl_20_qty" ,    false,      "",    dfNullInteger,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ac_ttl_40_qty" ,    false,      "",    dfNullInteger,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ac_ttl_hc_qty" ,    false,      "",    dfNullInteger,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ac_ttl_45_qty" ,    false,      "",    dfNullInteger,             0,          true,       true);

                       var CalcuLogicAcTeu = "|ac_ttl_20_qty|+|ac_ttl_40_qty|*2+|ac_ttl_hc_qty|*"+ratehc+"+|ac_ttl_45_qty|*"+rate45;
                       InitDataProperty(0, cnt++ , dtData,      80,     daCenter,       false,       "ac_teu"      	 ,    false,      "",              dfFloat,           2,          true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,    80,     daCenter,       false,       "ac_mt_teu"     ,    false,      CalcuLogicAcTeu,              dfFloat,           2,          true,       true);

                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ttl_20_qty" ,    false,      CalcuLogic20,    dfInteger,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ttl_40_qty" ,    false,      CalcuLogic40,    dfInteger,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ttl_hc_qty" ,    false,      CalcuLogichc,    dfInteger,             0,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,     daCenter,       false,       "ttl_45_qty" ,    false,      CalcuLogic45,    dfInteger,             0,          true,       true);

                       var CalcuLogicTeu = "|ttl_20_qty|+|ttl_40_qty|*2+|ttl_hc_qty|*"+ratehc+"+|ttl_45_qty|*"+rate45;
                       InitDataProperty(0, cnt++ , dtData,      80,     daCenter,       false,       "teu"      ,    false,      "",                   dfFloat,           2,          true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,    80,     daCenter,       false,       "obd"      ,    false,      "",        dfInteger,           0,          true,       true);

                       InitDataProperty(0, cnt++ , dtHidden,      80,     daCenter,       false,       "mt_20_cnt"      ,    false,      "",                   dfInteger,           0,          true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      80,     daCenter,       false,       "mt_40_cnt"      ,    false,      "",                   dfInteger,           0,          true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      80,     daCenter,       false,       "mt_hc_cnt"      ,    false,      "",                   dfInteger,           0,          true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      80,     daCenter,       false,       "mt_45_cnt"      ,    false,      "",                   dfInteger,           0,          true,       true);

                       var CalcuLogicMt = "|mt_20_cnt|+|mt_40_cnt|*2+|mt_hc_cnt|*"+ratehc+"+|mt_45_cnt|*"+rate45;
                       InitDataProperty(0, cnt++ , dtHidden,      80,     daCenter,       false,       "mt_type_teu"    ,    false,   CalcuLogicMt,            dfFloat,           2,          true,       true);
                       InitDataProperty(0, cnt++ , dtData,      55,     daCenter,       false,       "mt_teu"         ,    false,      "",                   dfInteger,           0,          true,       true);

                       InitDataProperty(0, cnt++ , dtHidden,    80,     daCenter,       false,       "teu_bak"  ,    false,      CalcuLogicTeu,        dfFloat,           2,          true,       true);
                       
                       SetMergeCell(0,   1, 3, 2);
                       SetMergeCell(1,  sheetObj.SaveNameCol( "ac_teu" ) , 2, 1);
                       SetMergeCell(1,  sheetObj.SaveNameCol( "teu" ) , 2, 1);
                       SetMergeCell(0,  sheetObj.SaveNameCol( "mt_teu" ) , 3, 1);

                       WordWrap = true;
                    }
                    break;
            }
         }

        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
                case    IBSEARCH:      //조회
                    if( !validateForm(sheetObj,formObj,sAction) ){return;}
                    ComOpenWait(true);
                    formObj.f_cmd.value = SEARCHLIST01;
                    var param =  FormQueryString(formObj);
                    var sXml  = sheetObj.GetSearchXml("FNS_JOO_0081GS.do", param);
                    var aXml  = sXml.split("|$$|");
                     colCnt = ComGetTotalRows( aXml[0] );
                    ComOpenWait(false);

                    var TRANS_RESULT_KEY = ComGetEtcData(aXml[0], "TRANS_RESULT_KEY");
                    if(TRANS_RESULT_KEY!="S"){
                        sheetObj.LoadSearchXml(  aXml[0] );
                        return;
                    }
                    if(colCnt == "0" ){
                        sheetObj.Reset();
                        initSheet(sheetObj, 1 );
                        sheetObj.LoadSearchXml(  aXml[0] );
                        return;
                    }
                    sheetObj.Reset();
                    ComOpenWait(true);
                    initSheet(sheetObj, 1, colCnt.parseInt(),  aXml[0]);
                    sheetObj.LoadSearchXml(aXml[1]);
                    sheetObj.ReDraw = false;
                    fnMerge(colCnt);      
                    fnCalcTotal(colCnt);
                    sheetObj.ReDraw = true;
                    ComOpenWait(false);
                    break; 

                case    IBDOWNEXCEL : //EXCEL DOWNLOAD

                    /*Title 엑셀 다운. */
                    var paramObj = new Object();
                    paramObj.cols = 30;
                    ComOpenWait(true);
                    var title   = "VSL/VO : "+formObj.vvd.value;
                    var RateHC  = "HC Rate : "+formObj.ratehc.value;
                    var Rate45  = "45 Rate : "+formObj.rate45.value;
                    paramObj.title = title+"     "+RateHC+"    "+Rate45;
                    var url = ComJooGetPgmTitle( sheetObj, paramObj);
                    sheetObj.Down2Excel(-1, false ,false, true, "", url);
                    ComOpenWait(false);
                    break;

                case    IBSEARCH_ASYNC01 : //VSL_VO CODE KEYUP EVENT
                    formObj.f_cmd.value = SEARCH14;
                    var code  = formObj.vvd.value;
                    var param = FormQueryString(formObj)+"&code="+code;
                    var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                    var rowCnt = ComGetTotalRows( sXml );
                    if( rowCnt == "0"){
                    sheetObj.RemoveAll();
                    ComShowCodeMessage("JOO00117", "VSL/VO");
                    formObj.vvd.select();
                    formObj.vvd.focus();
                    return;
                    }else{
                    //var objRetBtn = document.getElementById("btn_retrieve");
                    //objRetBtn.fireEvent("onclick");
                    }
                    break;
            }
        }

        function fnMerge(colCnt){
        	with (sheetObjects[0]) {
                //  Color 처리.
                var bgColor = true;
                for(var idx= HeaderRows ;idx<= RowCount;true ){

                    if(CellValue(idx,"pol_cd" ).indexOf("TOTAL") > -1  ){
                        RowBackColor(idx+0) = RgbColor(252,220,238);
                        RowBackColor(idx+1) = RgbColor(252,220,238);
                        RowBackColor(idx+2) = RgbColor(252,220,238);
                        RowBackColor(idx+3) = RgbColor(252,220,238);
                        idx+=4;

                        if(CellValue(idx,"pol_cd" ) == "TEU"  ){
                            RowBackColor(idx+0) = RgbColor(250,201,228);
                            idx+=1;
                        }
                        continue;
                    }
                    if( bgColor  ){
                        RowBackColor(idx+0) = RgbColor(254,250,145);
                        RowBackColor(idx+1) = RgbColor(254,250,145);
                        RowBackColor(idx+2) = RgbColor(254,250,145);
                        RowBackColor(idx+3) = RgbColor(254,250,145);

                        idx+=4;
                        bgColor = false;
                        continue;
                    }else{
                        bgColor = true;
                        idx+=4;
                    }
                }

                /* TEU 셋 처리
                 *    1. Data 세로 처리하면서,, Data 가로 TEU도 같이 처리.
                 *
                 */
                 var teuIndx=0;
                 
                for(var i=HeaderRows ;i<=LastRow; i++ ){
                     var teusum=0;
                     var acteusum=0;
                     var topidx = i;
                     var cntrsizecnt  = 4;  //"20'|40'|HC|45" (4)COLUMN
                     var cntrtypecnt  = 4;  //D, RF, AK, Q  (4)LINE
                     var wtotalteucnt = 5;  //WTOTAL(4) + TEU(1) LINE
                     var roopCnt      =4;
                     var est1stcount = wtotalteucnt+cntrtypecnt;  // (9) Line

                    if(CellValue( i,"pol_cd" ).indexOf( "TOTAL" ) > -1  ){                    	
                        SetMergeCell( topidx ,  SaveNameCol( "teu" ) , 5, SaveNameCol( "mt_teu" )-SaveNameCol( "teu" )+1 );   //Data 가로 TEU->맨 우측.
                        SetMergeCell( topidx ,  SaveNameCol( "ac_ttl_20_qty" ) , 5, SaveNameCol( "ac_mt_teu" )-SaveNameCol( "ac_ttl_20_qty" )+1 );   //AC Data 가로  TEU
                    
                    }else if(CellValue(   topidx,"pol_cd" ) == "TEU"  ){
                    	 teuIndx = topidx; 
//                    	 alert(i+":"+RowCount)
//                         CellValue( topidx, "teu" ) = CellValue( topidx,"teu_bak" );//Data 세로 TEU

                          //DischPort 당 TEU
//                         for(var j=0;j< colCnt;j++){// colCnt + 1(TTL건도 처리 위해 )
//                             var sv20_qty      = "pod"+(j+1)+"_20_qty";
//                             var sv20_qtyValue = CellValue(topidx,sv20_qty);
//                             var sv40_qty      = "pod"+(j+1)+"_40_qty";
//                             var sv40_qtyValue = CellValue(topidx,sv40_qty);
//                             var svhc_qty      = "pod"+(j+1)+"_hc_qty";
//                             var svhc_qtyValue = CellValue(topidx,svhc_qty);
//                             var sv45_qty 	   = "pod"+(j+1)+"_45_qty";
//                             var sv45_qtyValue = CellValue(topidx,sv45_qty);
//
//                             var teu =  (sv20_qtyValue==""?0:eval(sv20_qtyValue)  )+
//                                        (sv40_qtyValue==""?0:eval(sv40_qtyValue)  )+
//                                        (svhc_qtyValue==""?0:eval(svhc_qtyValue)  )+
//                                        (sv45_qtyValue==""?0:eval(sv45_qtyValue)  );
//
//                             SetMergeCell( topidx ,  SaveNameCol( sv20_qty ) , 1, 4);   //가로  Dis Port 당. TEU 셀병합.
//                             CellValue(topidx,sv20_qty) =    teu;
//                             CellFont("FontBold", topidx,sv20_qty) = true;
//                         }
//                         //ttl
//                        SetMergeCell( topidx ,  SaveNameCol( "ttl_20_qty" ) , 1, 4);      //가로 TEU
//                        RowBackColor( topidx ) = RgbColor(250,201,228);
//                        CellFont("FontBold", topidx,"ttl_20_qty") = true;
                        continue;                    	 
                     }else{ //우측 TEU,  추가요건  : MT TEU와 같이처리

                         
                         //Accumulative Total 계산      -> QUERY에서 SETTING
                         for(var j=0;j< cntrtypecnt;j++){
	                         CellValue( topidx+j, "ac_ttl_20_qty" ) = CellValue( topidx+j, "ttl_20_qty" );
	                         CellValue( topidx+j, "ac_ttl_40_qty" ) = CellValue( topidx+j, "ttl_40_qty" );
	                         CellValue( topidx+j, "ac_ttl_hc_qty" ) = CellValue( topidx+j, "ttl_hc_qty" );
	                         CellValue( topidx+j, "ac_ttl_45_qty" ) = CellValue( topidx+j, "ttl_45_qty" );
                         }

                         //Accumulative Qty total = pre qty total + current qty total - pre pol/matching pod discharge qty
                         if(topidx >= HeaderRows && teuIndx == 0){   // West Accumulative Qty
                        	 if (topidx==HeaderRows){
                        		 cntrtypecnt=0;
                        	 }else{
                        		 cntrtypecnt=4;
                        	 }
                        	 fnCalcMethod(topidx, roopCnt, cntrtypecnt, "pod"+ComParseInt((topidx/cntrsizecnt)+1));    //cntrtypecnt = "D, RF, AK, Q"
                         
                         } else if(topidx == teuIndx+1) {   // EAST 1'ST POL Accumulative Qty
                        	 fnCalcMethod(topidx, roopCnt, est1stcount, "pod"+ComParseInt(((topidx-wtotalteucnt)/cntrsizecnt)+1));    //cntrtypecnt = "D, RF, AK, Q"
                         } else if(topidx > teuIndx+4) {    // EAST 2'nd POL Accumulative Qty below
                        	 fnCalcMethod(topidx, roopCnt, cntrtypecnt, "pod"+ComParseInt(((topidx-wtotalteucnt)/cntrsizecnt)+1));    //cntrtypecnt = "D, RF, AK, Q"
                         }
                         
                       //세로  TEU 머지 처리.
                         teusum += eval( CellValue(topidx  ,"teu_bak" ) );
                         teusum += eval( CellValue(topidx+1,"teu_bak" )  );
                         teusum += eval( CellValue(topidx+2,"teu_bak" ) );
                         teusum += eval( CellValue(topidx+3,"teu_bak" ) );

                         SetMergeCell( topidx ,  SaveNameCol( "teu" ) , 4, 1);
                         CellValue( topidx, "teu" ) = teusum;
                         CellFont("FontBold", topidx,"teu") = true;

                         //세로 Data EMPTY 머지 처리.
                         var emptysum=0;
                         emptysum += eval( CellValue(topidx  ,"mt_type_teu" ) );
                         emptysum += eval( CellValue(topidx+1,"mt_type_teu" ) );
                         emptysum += eval( CellValue(topidx+2,"mt_type_teu" ) );
                         emptysum += eval( CellValue(topidx+3,"mt_type_teu" ) );

                         SetMergeCell( topidx ,  SaveNameCol( "mt_teu" ) , 4, 1);
                         CellValue( topidx, "mt_teu" ) = emptysum;
                         CellFont("FontBold", topidx,"mt_teu") = true;

                         
                         //Accumulative Data 세로 TEU 머지 처리.
//                         CellValue( topidx,   "ac_teu" ) = CellValue( topidx,  "ac_mt_teu" );
//                         CellValue( topidx+1, "ac_teu" ) = CellValue( topidx+1,"ac_mt_teu" );
//                         CellValue( topidx+2, "ac_teu" ) = CellValue( topidx+2,"ac_mt_teu" );
//                         CellValue( topidx+3, "ac_teu" ) = CellValue( topidx+3,"ac_mt_teu" );

                         acteusum += parseFloat( CellValue(topidx  ,"ac_mt_teu" ) );
                         acteusum += parseFloat( CellValue(topidx+1,"ac_mt_teu" ) );
                         acteusum += parseFloat( CellValue(topidx+2,"ac_mt_teu" ) );
                         acteusum += parseFloat( CellValue(topidx+3,"ac_mt_teu" ) );
                         
                         SetMergeCell( topidx ,  SaveNameCol( "ac_teu" ) , 4, 1);
                         CellValue( topidx, "ac_teu" ) = acteusum;
                         CellFont("FontBold", topidx,"ac_teu") = true;
                     }
                     i+=3;                     
                }
        	}
        }
            	
        function fnCalcMethod(topidx, roopCnt, calcMinus, calcLogic) {
            with (sheetObjects[0]) {
            //	alert(topidx+":"+calcMinus+":"+calcLogic)
            	
                var rowsSaveName = ["_20_qty", "_40_qty", "_hc_qty", "_45_qty"];
				for(var j=0; j<roopCnt; j++){
                    var currRow = topidx+j;    
                    
                    for (var k=0; k<rowsSaveName.length; k++) {  
                    	var preQtyTotal  = 0
                    	if (calcMinus == 0){
                    		 preQtyTotal  = 0;
                    	}else{
                    		 preQtyTotal  = ComParseInt(CellValue(currRow - calcMinus, "ac_ttl" + rowsSaveName[k]));
                    	}
	                    var currentQtyTotal =ComParseInt(CellValue(currRow, "ttl" + rowsSaveName[k]));
	                    var podDischargeQty = 0;
	                    var currentTypeQty = 0;
	                                  	                    
	                    if (j ==3){ //Q Type
	                    	var podCol = SaveNameCol(calcLogic + rowsSaveName[k]) ;
	                        var endCol = SaveNameCol( "ac_ttl" + rowsSaveName[k]) ;
	                    	var ttlQty = ComParseInt(CellValue(currRow, "ttl" + rowsSaveName[k]));
	                    	
	                    	for(var c=podCol;c< endCol;c=c+roopCnt){// Q 수량 재정의	  
	                    		var podQty =0;
	                    		if (CellValue(currRow , c) != "" && 
	                                ComParseInt(CellValue(currRow, c))>0 ){
	                    			podQty =  ComParseInt(CellValue(currRow, c));
	        	                   }   
	                    		if ( ttlQty > 0  ){	                    			
	                    			CellValue(currRow, c)=ttlQty - podQty;	
	                    			ttlQty = ttlQty - podQty;
	                    		}
	                         }	                    	
	                    }
	                    
	                    if (CellValue(currRow , calcLogic + rowsSaveName[k]) != "" && 
	                        	ComParseInt(CellValue(currRow, calcLogic + rowsSaveName[k]))>0 ){
	                			currentTypeQty =  ComParseInt(CellValue(currRow, calcLogic + rowsSaveName[k]));
		                 }  
	                    
                        for (var z=currRow;  z > 2; z=z-roopCnt){
                        	var polNm = ComTrimAll(CellValue(z,"pol_cd"));
                        	if (polNm =="WTOTAL" || polNm =="ETOTAL" || polNm =="TEU"){                        		
                        		z= z-5                        		
                        	}                        	
                    		                     	
                        	if (z < topidx && CellValue(z , calcLogic + rowsSaveName[k]) != "" && 
                        		ComParseInt(CellValue(z, calcLogic + rowsSaveName[k]))>0 ){
                        		 var tmp_tot =  ComParseInt(CellValue(z, calcLogic + rowsSaveName[k]));
                        		 podDischargeQty=podDischargeQty+tmp_tot;
                        	}  
                        }
	                       
	                    if (j ==3){ //Q Type	                    	
	                    	var CalcuLogicAcTeu = "|ac_ttl_20_qty|+|ac_ttl_40_qty|*2+|ac_ttl_hc_qty|*2+|ac_ttl_45_qty|*2";
	                    	var CalcuLogicTeu = "|ttl_20_qty|+|ttl_40_qty|*2+|ttl_hc_qty|*2+|ttl_45_qty|*2";
	                    	CellValue(currRow, "ac_ttl" + rowsSaveName[k]) = podDischargeQty +currentTypeQty ;
	                        InitCellProperty(currRow,"ttl" + rowsSaveName[k],dtNull,daCenter,"ttl" + rowsSaveName[k],""); // Q는 pdl,pod의 값이 같을경우만ttl sum에 적용함
	                        CellValue(currRow, "ttl" + rowsSaveName[k]) = currentTypeQty;
	                        
	                        InitCellProperty(currRow,"ac_teu",dtNull,daCenter,"ac_teu",CalcuLogicAcTeu); 
	                        InitCellProperty(currRow,"teu",dtNull,daCenter,"teu",CalcuLogicTeu);
	                    }else{
	                    	
	                    //	alert(preQtyTotal +":"+ currentQtyTotal +": podDischargeQty = " + podDischargeQty)
	                    	CellValue(currRow, "ac_ttl" + rowsSaveName[k]) = preQtyTotal + currentQtyTotal - podDischargeQty ;
	                    }
                    }
                }
            }
        }
        
        function fnCalcTotal(colCnt) { //Q Type의 Total값 계산
        	 var formObj = document.form;
        	with (sheetObjects[0]) {
        		var wRow = FindText("pol_cd", "WTOTAL", 0, 0);
        		var eRow = FindText("pol_cd", "ETOTAL", 0, 0);
        		var rowCnt = RowCount;
        		var podCol = SaveNameCol("pod1_20_qty") ;
                var endCol = SaveNameCol( "ac_ttl_20_qty") ;
                var  ratehc  = formObj.ratehc.value;
                var  rate45  = formObj.rate45.value;
//             alert(wRow+":"+eRow)   
//                alert(wRow+":"+eRow+":"+podCol+":"+endCol)
            	for(var c=podCol;c< endCol;c++){// Q 수량 재정의	  
	                var totwQty = 0;
	                var toteQty = 0;
            		for (var i=6; i < rowCnt; i=i+4){  
            			var podQty =0;
            			var polNm = ComTrimAll(CellValue(i,"pol_cd"));
                    	if (polNm =="WTOTAL" || polNm =="ETOTAL" || polNm =="TEU"){                        		
                    		i= i+5                        		
                    	}   
	            		if (CellValue(i , c) != "" && 
	                       	ComParseInt(CellValue(i, c))>0 ){
	            			podQty =  ComParseInt(CellValue(i, c));
		                  }
	            		if (i< wRow){
	            			totwQty = totwQty +podQty;
	            		}else if(i > wRow+4 && i < eRow){
	            			toteQty = toteQty +podQty;
	            		}
            		} 
            		///////////////wTotal 계산
            		if (wRow >0){
	        			var wtot1=CellValue(wRow, c)==""?0:ComParseInt(CellValue(wRow, c));
	        			var wtot2=CellValue(wRow+1, c)==""?0:ComParseInt(CellValue(wRow+1, c));
	        			var wtot3=CellValue(wRow+2, c)==""?0:ComParseInt(CellValue(wRow+2, c));
	        			var wtot4= totwQty;
	        			var wteu = 0;
	        			if(CellValue(2,c).indexOf("40") > -1  ){
	        				wteu=ComParseInt((wtot1+wtot2+wtot3+wtot4) *2);
	        			 }else if (CellValue(2,c).indexOf("HC") > -1  ){
	        				 wteu=parseFloat((wtot1+wtot2+wtot3)*ratehc+(wtot4*2));
	        			 }else if (CellValue(2,c).indexOf("45") > -1  ){
	        				 wteu=parseFloat((wtot1+wtot2+wtot3)*rate45+(wtot4*2));
	        			 }else{  //20
	        				 wteu=ComParseInt(wtot1+wtot2+wtot3+wtot4);
	        			 }
	        			 
	        			CellValue(wRow+3,c)=totwQty==0?"":totwQty;
	        			CellValue(wRow+4,c)=wteu;
            		}
        			///////////eTotal 계산
        			if (eRow >0){
	        			var etot1=CellValue(eRow, c)==""?0:ComParseInt(CellValue(eRow, c));
	        			var etot2=CellValue(eRow+1, c)==""?0:ComParseInt(CellValue(eRow+1, c));
	        			var etot3=CellValue(eRow+2, c)==""?0:ComParseInt(CellValue(eRow+2, c));
	        			var etot4= toteQty;
	        			var eteu = 0;
	        			if(CellValue(2,c).indexOf("40") > -1  ){
	        				eteu=ComParseInt((etot1+etot2+etot3+etot4) *2);
	        			 }else if (CellValue(2,c).indexOf("HC") > -1  ){
	        				 eteu=parseFloat((etot1+etot2+etot3)*ratehc+(etot4*2));
	        			 }else if (CellValue(2,c).indexOf("45") > -1  ){
	        				 eteu=parseFloat((etot1+etot2+etot3)*rate45+(etot4*2));
	        			 }else{  //20
	        				 eteu=ComParseInt(etot1+etot2+etot3+etot4);
	        			 }
	        			CellValue(eRow+3,c)=toteQty==0?"":toteQty;
	        			CellValue(eRow+4,c)=eteu;
        			}
            	}
            	
            	//////////////////////GTotal
            	var ttlCol = SaveNameCol( "ttl_20_qty") ;
            	var ttlWteu =0;
            	var ttlEteu =0;
            	for(var c=ttlCol;c< ttlCol+4;c++){// Q 수량 재정의	  
	                var totwQty = 0;
	                var toteQty = 0;
            		
            		///////////////wTotal 계산
	                if (wRow >0){
	        			var wtot1=CellValue(wRow, c)==""?0:ComParseInt(CellValue(wRow, c));
	        			var wtot2=CellValue(wRow+1, c)==""?0:ComParseInt(CellValue(wRow+1, c));
	        			var wtot3=CellValue(wRow+2, c)==""?0:ComParseInt(CellValue(wRow+2, c));
	        			var wtot4= CellValue(wRow+3, c)==""?0:ComParseInt(CellValue(wRow+3, c));;
	        			var wteu = 0;
	        			if(CellValue(2,c).indexOf("40") > -1  ){
	        				wteu=ComParseInt((wtot1+wtot2+wtot3+wtot4) *2);
	        			 }else if (CellValue(2,c).indexOf("HC") > -1  ){
	        				 wteu=parseFloat((wtot1+wtot2+wtot3)*ratehc+(wtot4*2));
	        			 }else if (CellValue(2,c).indexOf("45") > -1  ){
	        				 wteu=parseFloat((wtot1+wtot2+wtot3)*rate45+(wtot4*2));
	        			 }else{  //20
	        				 wteu=ComParseInt(wtot1+wtot2+wtot3+wtot4);
	        			 }
	        			InitCellProperty(wRow+4,c,dtNull,daCenter,c,"");
	        			CellValue(wRow+4,c)=wteu;
	        			ttlWteu = ttlWteu+wteu;
	                }
        			///////////eTotal 계산
        			if (eRow>0){
	        			var etot1=CellValue(eRow, c)==""?0:ComParseInt(CellValue(eRow, c));
	        			var etot2=CellValue(eRow+1, c)==""?0:ComParseInt(CellValue(eRow+1, c));
	        			var etot3=CellValue(eRow+2, c)==""?0:ComParseInt(CellValue(eRow+2, c));
	        			var etot4= CellValue(eRow+3, c)==""?0:ComParseInt(CellValue(eRow+3, c));
	        			var eteu = 0;
	        			if(CellValue(2,c).indexOf("40") > -1  ){
	        				eteu=ComParseInt((etot1+etot2+etot3+etot4) *2);
	        			 }else if (CellValue(2,c).indexOf("HC") > -1  ){
	        				 eteu=parseFloat((etot1+etot2+etot3)*ratehc+(etot4*2));
	        			 }else if (CellValue(2,c).indexOf("45") > -1  ){
	        				 eteu=parseFloat((etot1+etot2+etot3)*rate45+(etot4*2));
	        			 }else{  //20
	        				 eteu=ComParseInt(etot1+etot2+etot3+etot4);
	        			 }
	        			InitCellProperty(eRow+4,c,dtNull,daCenter,c,"");
	        			CellValue(eRow+4,c)=eteu;
	        			ttlEteu = ttlEteu+eteu;
        			}
            	}
            	if (wRow>0) CellValue(wRow+4,ttlCol)=ttlWteu;
            	if (eRow>0) CellValue(eRow+4,ttlCol)=ttlEteu;
            	
                 for (var t=0; t<2; t++){
                	 var teuRow = 0;
//                	 alert(wRow+":"+eRow+":"+teuRow)
                	 if (t==0){//wTotal
                		 if (wRow < 0){
                			 teuRow =0;
                		 }else{
                			 teuRow = wRow+4;
                		 }
                	 }else{ //eTotal
                		 if (eRow < 0){
                			 teuRow =0;
                		 }else{
                			 teuRow = eRow+4;
                		 }
                	 }
                    for(var j=0;j< colCnt;j++){// colCnt + 1(TTL건도 처리 위해 )
                    	 if (teuRow == 0){
                			 break;                		
                		 }
                        var sv20_qty      = "pod"+(j+1)+"_20_qty";
                        var sv20_qtyValue = CellValue(teuRow,sv20_qty);
                        var sv40_qty      = "pod"+(j+1)+"_40_qty";
                        var sv40_qtyValue = CellValue(teuRow,sv40_qty);
                        var svhc_qty      = "pod"+(j+1)+"_hc_qty";
                        var svhc_qtyValue = CellValue(teuRow,svhc_qty);
                        var sv45_qty 	   = "pod"+(j+1)+"_45_qty";
                        var sv45_qtyValue = CellValue(teuRow,sv45_qty);

                        var teu =  (sv20_qtyValue==""?0:eval(sv20_qtyValue)  )+
                                   (sv40_qtyValue==""?0:eval(sv40_qtyValue)  )+
                                   (svhc_qtyValue==""?0:eval(svhc_qtyValue)  )+
                                   (sv45_qtyValue==""?0:eval(sv45_qtyValue)  );

                        SetMergeCell( teuRow ,  SaveNameCol( sv20_qty ) , 1, 4);   //가로  Dis Port 당. TEU 셀병합.
                        SetMergeCell( teuRow , ttlCol , 1, 4); 
                        CellValue(teuRow,sv20_qty) =    teu;
                        CellFont("FontBold", teuRow,sv20_qty) = true;
                        CellFont("FontBold", teuRow,ttlCol) = true;
                    }
                 }          
        	}
        }

         /**
          * <pre>
          *    form Element의 KeyPress Event 발생시 처리.
          *
          * </pre>
          * @return
          */
         function fnObjKeyPress(){
             var obj = event.srcElement;
             var formObj = document.form;
             switch (obj.name){
                    case 'vvd':
                          ComKeyOnlyAlphabet( "uppernum" );
                          if( sheetObjects[0].RowCount > 0 ){
                             sheetObjects[0].RemoveAll();
                          }
                          break;
                    case 'ratehc':
                        ComKeyOnlyNumber(obj, ".");
                        if( sheetObjects[0].RowCount > 0 ){
                            sheetObjects[0].RemoveAll();
                         }

                          break;
                    case 'rate45':
                        ComKeyOnlyNumber(obj, ".");
                        if( sheetObjects[0].RowCount > 0 ){
                            sheetObjects[0].RemoveAll();
                         }
                         break;
             }
         }
         function fnObjKeyUp(){
             var obj = event.srcElement;
             var formObj = document.form;
             switch (obj.name){
                    case 'vvd':
                          var maxlength = obj.getAttribute("maxlength");

                          if( obj.value.length == eval(maxlength) ){
                              doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                          }
                          break;
             }
         }

        function fnSetTitle(headType, sXmlTitle){
            var rtrTitle = "";
            var cntTitleCnt = ComGetTotalRows(  sXmlTitle );
            var fixTitlePerOne = "20'|40'|HC|45";
            for(var i=0;i<cntTitleCnt;i++){
                for(var j=0;j<fixTitlePerOne.split("|").length;j++ ){
                    switch (headType) {
                         case "head1":
                              rtrTitle += "DISCH. PORT"+"|";
                              break;

                         case "head2":
                              var  pol_cd  = ComJooGetRowValue(sXmlTitle, i+1, "pol_cd").substring(0, 14);
                              rtrTitle += pol_cd+"|";
                              break;

                         case "head3":
                              var  ctType   = fixTitlePerOne.split("|");
                              rtrTitle += ctType[j] +"|";
                              break;

                    } // end switch
                }
            }// end For

            /*타이틀 Tail 처리 */
            var tailTitle = "TEU|OBD||EMPTY";

            for(var j=0;j<fixTitlePerOne.split("|").length;j++ ){
                switch (headType) {
                    case "head1":
                         rtrTitle += "Accumulative TOTAL|";
                         if(j == fixTitlePerOne.split("|").length-1 ){
                             rtrTitle += "Accumulative TOTAL|EMPTY|";//   EMPTY=MT_TEU
                         }
                         break;

                    case "head2":
                         rtrTitle += "TTL|";
                         if(j == fixTitlePerOne.split("|").length-1 ){
                             rtrTitle+="TEU|EMPTY|";
                         }
                         break;

                    case "head3":
                         var  ctType   = fixTitlePerOne.split("|");
                         rtrTitle += ctType[j] +"|";

                         if(j == fixTitlePerOne.split("|").length-1 ){
                             rtrTitle+="TEU|EMPTY|";
                         }

                         break;

                } // end switch
            }

            for(var j=0;j<fixTitlePerOne.split("|").length;j++ ){
                switch (headType) {
                    case "head1":
                         rtrTitle += "G TOTAL"+"|";
                         if(j == fixTitlePerOne.split("|").length-1 ){
                             rtrTitle += "G TOTAL"+"|"+"G TOTAL|MT_20|MT_40|MT_HC|MT_45|MT_TYPE_CNT|EMPTY";//   EMPTY=MT_TEU
                         }
                         break;

                    case "head2":
                         rtrTitle += "TTL|";
                         if(j == fixTitlePerOne.split("|").length-1 ){
                             rtrTitle+="TEU"+"|"+"OBD"+"|MT_20|MT_40|MT_HC|MT_45|MT_TYPE_CNT|EMPTY";
                         }
                         break;

                    case "head3":
                         var  ctType   = fixTitlePerOne.split("|");
                         rtrTitle += ctType[j] +"|";
                         if(j == fixTitlePerOne.split("|").length-1 ){
                             rtrTitle+="TEU"+"|"+"OBD"+"|MT_20|MT_40|MT_HC|MT_45|MT_TYPE_CNT|EMPTY";
                         }
                         break;

                } // end switch
            }
            return rtrTitle;
        }
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){

            with(formObj){
                switch ( sAction ){
                     case IBSEARCH :
                          if (!ComChkValid(formObj)) return false;
                }
            }
            return true;
        }

	/* 개발자 작업  끝 */