/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4103.js
*@FileTitle : Sheet Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : Mun Jung Cheol
*@LastVersion : 1.0
* 2009.09.28 Mun Jung Cheol
* 1.0 Creation
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
    * @extends 
    * @class ui_dmt_4103 : ui_dmt_4103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function ui_dmt_4103() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var ROWMARK = "|";
var FIELDMARK = "=";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_save":
            		//버튼권한 추가(2010.04.08)
            		if(ComGetObjValue(formObject.sec_invoice) == "N") {
            			ComShowCodeMessage("DMT01145", "Save");
            			return;
            		}                	
                    if ( formObject.h_user_office.value == formObject.isof.value ) {
                        if ( ComShowConfirm("Will you save this sheet option?") ) {                    
                            doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                        } else {
                            return false;
                        }
                    } else {
                        ComShowCodeMessage( "DMT01103" );
                        return false;
                    }                    
                break;
            
                case "btn2_rowadd01":
                    doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
                break;

                case "btn2_rowdel01":
                    if ( ComShowCodeConfirm("DMT00143") ){ 
                        doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
                    }
                break;

                case "btn2_rowadd02":
                    doActionIBSheet2(sheetObjects[1], formObject, IBINSERT);
                break;

                case "btn2_rowdel02":
                    if ( ComShowCodeConfirm("DMT00143") ){ 
                        doActionIBSheet2(sheetObjects[1],formObject,IBDELETE);
                    }
                break;
                
                case "btn_close":
//                    if ( document.form.tJspno.value == "EES_DMT_4002" ||
//                         document.form.tJspno.value == "EES_DMT_3109" ||
//                         document.form.tJspno.value == "EES_DMT_3108" ||
//                         document.form.tJspno.value == "EES_DMT_4004" ||
//                         document.form.tJspno.value == "EES_DMT_4016-1"
//                       ) {
//                        var opener = window.dialogArguments;
//                        //opener.document.form.tax_rto.value = document.form.taxrto.value;
//                        var tTftp = document.form.tTftp.value;
//                        var tTaxRto = document.form.taxrto.value;
//                        var rtnValTerm = "";
//                        var rtnValIsDt = "";
//                        var tOpnTftp = 0;
//                        if ( tTftp == "DMIF" ) {
//                            tOpnTftp = 3;
//                        } else if ( tTftp == "DTIC" ) {
//                            tOpnTftp = 4;
//                        } else if ( tTftp == "DMOF" ) {
//                            tOpnTftp = 5;
//                        } else if ( tTftp == "DTOC" ) {
//                            tOpnTftp = 6;
//                        } else if ( tTftp == "CTIC" ) {
//                            tOpnTftp = 7;
//                        } else if ( tTftp == "CTOC" ) {
//                            tOpnTftp = 8;
//                        }
//                        for ( var x18 = 2 ; x18 < sheetObjects[0].LastRow+1 ; x18++ ) {
//                            if ( sheetObjects[0].CellValue( x18 , tOpnTftp ) == 1 ) {
//                                rtnValTerm = sheetObjects[0].CellValue( x18 ,  9 );
//                                rtnValIsDt = sheetObjects[0].CellValue( x18 , 10 );
//                            }
//                        }
//                        opener.getSheetOptionData(rtnValTerm,rtnValIsDt,tTaxRto);
//                    }
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        if (document.form.taxrto.value > 0) {
            document.form.rtovat.value = "Y";
            document.form.rtovat.disabled = true;
        } else {
            document.form.rtovat.value = "Y";
            document.form.rtovat.disabled = false;
        }
        
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      // sheet1 init Credit Term
                with (sheetObj) {
                    // 높이 설정
                    style.height = 102;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1  = "|Seq.|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Term (Days)|Due Date||";
                    var HeadTitle2  = "|Seq.|All|DMIF|DTIC|DMOF|DTOC|CTIC|CTOC|Term (Days)|Due Date||";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN, COLMERGE,    SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus ,  0 , daCenter , true  , "ibflag"                                       );
                    InitDataProperty( 0 , cnt++ , dtSeq          , 40 , daCenter , true  , "seqq"                                         );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "alll" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dmif" , false , "" , dfNone , 0 , true , true );  
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dtic" , false , "" , dfNone , 0 , true , true );  
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dmof" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dtoc" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "ctic" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "ctoc" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtData         , 80 , daCenter , true  , "term" , false , "" , dfInteger , 0 , true , true , 2 );
                    InitDataProperty( 0 , cnt++ , dtCombo        , 90 , daCenter , true  , "issd" , false , "" , dfNone , 0 , true , true );
                    
                    InitDataProperty( 0 , cnt++ , dtHidden       , 80 , daCenter , true  , "shtp" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtHidden       , 90 , daCenter , true  , "titl" , false , "" , dfNone , 0 , true , true );

                    InitDataCombo (0, "issd", " |Issue Date|********", "0|1|2");
                    CountPosition = 0;
               }
            break; 

            case "sheet2":      // sheet2 init Customized Title
                with (sheetObj) {
                    // 높이 설정
                    style.height = 102;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1  = "|Seq.|Sheet Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Tariff Type|Customized Title||";
                    var HeadTitle2  = "|Seq.|Sheet Type|All|DMIF|DTIC|DMOF|DTOC|CTIC|CTOC|Customized Title||";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);



                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN, COLMERGE,    SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus ,  0 , daCenter , true  , "ibflag"                                       );
                    InitDataProperty( 0 , cnt++ , dtSeq          , 40 , daCenter , true  , "seqq"                                         );
                    InitDataProperty( 0 , cnt++ , dtCombo        , 80 , daCenter , true  , "shtp" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "alll" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dmif" , false , "" , dfNone , 0 , true , true );  
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dtic" , false , "" , dfNone , 0 , true , true );  
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dmof" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "dtoc" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "ctic" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     , 40 , daCenter , false , "ctoc" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtData         , 90 , daCenter , true  , "titl" , false , "" , dfNone , 0 , true , true , 30 );
                    
                    InitDataProperty( 0 , cnt++ , dtHidden       , 80 , daCenter , true  , "term" , false , "" , dfNone , 0 , true , true );
                    InitDataProperty( 0 , cnt++ , dtHidden       , 90 , daCenter , true  , "issd" , false , "" , dfNone , 0 , true , true );

                    InitDataCombo (0, "shtp", "Invoice|Demand Note|Group Demand|OTS Invoice", "I|D|G|O");
                    CountPosition = 0;
               }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
      
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == 'sheet1') { 
                        for( var i = 0 ; i < sheetObjects.length ; i++ ){
                            sheetObjects[i].RemoveAll();    
                        }               
                        formObj.f_cmd.value = SEARCH;    
                        
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                        
                        var sXml = sheetObj.GetSearchXml("EES_DMT_4103GS.do", FormQueryString(formObj));
                        
ComOpenWait(false);
                        
                        var arrXml = sXml.split("|$$|");
                        var shOptInfo = ComGetEtcData(arrXml[0], "shOptInfo");
                        if ( shOptInfo != undefined && shOptInfo != '' ) {
                            var arrTpSz = shOptInfo.split("|");
                            document.form.isof  .value = arrTpSz[0];
                            document.form.toloca.value = arrTpSz[1]; // LEFT RIGHT
                            document.form.cusref.value = arrTpSz[2]; // Cust. Ref.
                            document.form.telfax.value = arrTpSz[3]; // Tel. Fax
                            document.form.cusvat.value = arrTpSz[4]; // Cust. VAT No.
                            document.form.taxrto.value = arrTpSz[5]; // Tax Rate
                            document.form.rtovat.value = arrTpSz[6]; // 
                            document.form.dcamtr.value = arrTpSz[7]; // 
                        }
                        for( var i = 0 ; i < arrXml.length ; i++ ){
                            sheetObjects[i].LoadSearchXml(arrXml[i]);
                        }
                    }                     
                } else {
                    return;
                }
            break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)) {
                    if ( sheetObj.id == "sheet1") {

                        var rCnt01 = sheetObjects[0].RowCount+2;
                        var rCnt02 = sheetObjects[1].RowCount+2;
                        var dupCnt = 0;
                        var chkCnt = 0;
                        for ( var aaa = 3 ; aaa < 9 ; aaa++ ) {
                            for ( var iii = 2 ; iii < rCnt01 ; iii++ ) {
                                if ( sheetObjects[0].CellValue ( iii , aaa ) == 1 && sheetObjects[0].CellValue ( iii , 0 ) != "D" ) {
                                    dupCnt++;
                                }
                                if ( sheetObjects[0].CellValue ( iii , aaa ) == 1 ) { chkCnt++; }
                            }
                            if ( dupCnt > 1 ) {
                                //ComShowCodeMessage("DMT00144"," Tariff Type Credit Term");
                                ComShowCodeMessage( "DMT01104" );
                                return false;
                            }
                            dupCnt = 0;
                        }
                        if ( chkCnt == 0 && rCnt01 > 2 ) {
                            ComShowCodeMessage("DMT01110","Credit Term");
                            return false;
                        }
                        chkCnt = 0;
                        dupCnt = 0;
                        var tShTp = "";
                        var tShTp2 = "";
                        // 한 컬럼씩 각 로우에 중복여부 검사
                        for ( var aaa = 4 ; aaa < 10 ; aaa++ ) { // 컬럼 4 dmif  5 dtic  6 dmof 7 dtoc  8 ctic  9 ctoc
                            tShTp = "";
                            for ( var iii = 2 ; iii < rCnt02 ; iii++ ) { // 로우
                                if ( sheetObjects[1].CellValue ( iii , aaa ) == 1 && sheetObjects[1].CellValue ( iii , 2 ) == tShTp && sheetObjects[1].CellValue ( iii , 0 ) != "D") { // 선택한 tariff 와 sheet 이 같을 때
                                    dupCnt++;
                                    tShTp = sheetObjects[1].CellValue ( iii , 2 );
                                    if ( dupCnt > 1 ) {
                                        tShTp2 = sheetObjects[1].CellText ( iii , 2 );;
                                    }
                                }
                                if ( iii == 2 && sheetObjects[1].CellValue ( iii , aaa ) == 1 ) {
                                    dupCnt++;
                                    tShTp = sheetObjects[1].CellValue ( iii , 2 ); // 다음 비교를 위해서 선택한 sheet type 저장
                                }
                                if ( sheetObjects[1].CellValue ( iii , aaa ) == 1 ) { chkCnt++; }
                            }
                            if ( dupCnt > 1 ) {
                                ComShowCodeMessage( "DMT01105" , tShTp2 );
                                //ComShowCodeMessage("DMT00144"," Tariff Type Customized Title");
                                return false;
                            }                            
                            dupCnt = 0;
                        }
                        
                        if ( chkCnt == 0 && rCnt02 > 2 ) {
                            ComShowCodeMessage("DMT01110","Customized Title");
                            return false;
                        }
                        for ( var iii = 2 ; iii < rCnt02 ; iii++ ) {
                            if ( sheetObjects[1].CellValue ( iii , 10 ) == '' ) {
                                ComShowCodeMessage("DMT02002","Customized Title ");
                                return false;
                            }
                        }                        
                        
                        formObj.f_cmd.value = MULTI;                
                        var sParam1 = sheetObjects[0].GetSaveString(true);
                        var sParam2 = sheetObjects[1].GetSaveString(true);
                        sParam = sParam1 +  "&" + sParam2 +  "&" + FormQueryString(formObj);
                        
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                        
                        var sXml   = sheetObj.GetSaveXml("EES_DMT_4103GS.do", sParam);
                        sheetObjects[0].LoadSaveXml(sXml);
                        
ComOpenWait(false);
                        
                    }

ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                    
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
                    
ComOpenWait(false);
                    
                }
            break;
            
            case IBINSERT:      // 입력
                var rowno = sheetObj.DataInsert(-1);
                sheetObj.CellValue2(rowno,2) = 1;
                sheetObj.CellValue2(rowno,3) = 1;
                sheetObj.CellValue2(rowno,4) = 1;
                sheetObj.CellValue2(rowno,5) = 1;
                sheetObj.CellValue2(rowno,6) = 1;
                sheetObj.CellValue2(rowno,7) = 1;
                sheetObj.CellValue2(rowno,8) = 1;
                sheetObj.CellValue2(rowno,9) = "0";
                sheetObj.CellValue2(rowno,10) = "1";
            break;

            case IBDELETE:      // 삭제
                if (sheetObj.id == 'sheet1') {  
                    sheetObj.SelectFontBold = false;
                    var delRow = document.form.selectRowNumUp.value;
                    sheetObj.RowHidden(delRow)= true;      //2.행 숨기기
                    sheetObj.RowStatus(delRow)= "D";
                    if ( delRow == sheetObj.RowCount ) {
                        if ( delRow - 1 < 2 ) {
                            return false;
                        }else{
                            document.form.selectRowNumUp.value = delRow - 1;                        
                        }
                    }
                }               
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet2( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBINSERT:      // 입력
                var rowno = sheetObj.DataInsert(-1);
                sheetObj.CellValue2(rowno,3) = 1;
                sheetObj.CellValue2(rowno,4) = 1;
                sheetObj.CellValue2(rowno,5) = 1;
                sheetObj.CellValue2(rowno,6) = 1;
                sheetObj.CellValue2(rowno,7) = 1;
                sheetObj.CellValue2(rowno,8) = 1;
                sheetObj.CellValue2(rowno,9) = 1;
            break;

            case IBDELETE:      // 삭제
                if (sheetObj.id == 'sheet2') {  
                    sheetObj.SelectFontBold = false;
                    var delRow = document.form.selectRowNumDw.value;
                    sheetObj.RowHidden(delRow)= true;      //2.행 숨기기
                    sheetObj.RowStatus(delRow)= "D";
                    if ( delRow == sheetObj.RowCount ) {
                        if ( delRow - 1 < 2 ) {
                            return false;
                        }else{
                            document.form.selectRowNumUp.value = delRow - 1;                        
                        }
                    }
                }               
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

    function sheet1_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            document.form.selectRowNumUp.value = Row;
            if ( Row > 1 && Col == 2 ) {
                if ( Value == 0 ) {
                    CellValue2( Row , 3 ) = 1;
                    CellValue2( Row , 4 ) = 1;
                    CellValue2( Row , 5 ) = 1;
                    CellValue2( Row , 6 ) = 1;
                    CellValue2( Row , 7 ) = 1;
                    CellValue2( Row , 8 ) = 1;
                } else {
                    CellValue2( Row , 3 ) = 0;
                    CellValue2( Row , 4 ) = 0;
                    CellValue2( Row , 5 ) = 0;
                    CellValue2( Row , 6 ) = 0;
                    CellValue2( Row , 7 ) = 0;
                    CellValue2( Row , 8 ) = 0;
                }
            }
            if ( Row > 1 && ( Col == 3 || Col == 4 || Col == 5 || Col == 6 || Col == 7 || Col == 8 ) ) { 
                CellValue2( Row , 2 ) = 0;
            }
        }
    }
    
    function sheet1_OnChange( sheetObj , Row , Col, Value ) {
        with (sheetObj) {
            if ( Row > 1 && Col == 9 ) {
                if ( Value == 0 || Value == '' ) {
                    CellEditable( Row , 10 ) = true;
                    CellValue2( Row , 10 ) = 1;
                } else {
                    CellValue2( Row , 10 ) = 0;
                    CellEditable( Row , 10 ) = false;
                }
            }
            
            if ( Row > 1 && Col == 10 ) {
                if ( Value == 0 && CellValue( Row , 9 ) == 0 ) {
                    ComShowMessage(msgs["DMT01102"]);
                    CellEditable( Row , 10 ) = true;
                    CellValue2( Row , 10 ) = 1;
                    SelectCell( Row , 10 );
                } else if ( Value != 0 && CellValue( Row , 9 ) != 0 ) {
                    CellValue2( Row , 10 ) = 0;
                    CellEditable( Row , 10 ) = false;
                }
            }
        }
    }
    
    function sheet2_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            document.form.selectRowNumDw.value = Row;
            if ( Row > 1 && Col == 3 ) {
                if ( Value == 0 ) {
                    CellValue2( Row , 4 ) = 1;
                    CellValue2( Row , 5 ) = 1;
                    CellValue2( Row , 6 ) = 1;
                    CellValue2( Row , 7 ) = 1;
                    CellValue2( Row , 8 ) = 1;
                    CellValue2( Row , 9 ) = 1;
                } else {
                    CellValue2( Row , 4 ) = 0;
                    CellValue2( Row , 5 ) = 0;
                    CellValue2( Row , 6 ) = 0;
                    CellValue2( Row , 7 ) = 0;
                    CellValue2( Row , 8 ) = 0;
                    CellValue2( Row , 9 ) = 0;                    
                }
            }
            if ( Row > 1 && ( Col == 4 || Col == 5 || Col == 6 || Col == 7 || Col == 8 || Col == 9 ) ) {
                CellValue2( Row , 3 ) = 0;
            }
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        with (sheetObj) {
            if ( RowCount == 0 ) {
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
            } else {
                var tDmif = 1;
                var tDtic = 1;
                var tDmof = 1;
                var tDtoc = 1;
                var tCtic = 1;
                var tCtoc = 1;
                for ( var x18 = 2 ; x18 < LastRow+1 ; x18++ ) {
                    if ( CellValue( x18 , 3 ) == 1 ) { tDmif = 0; }
                    if ( CellValue( x18 , 4 ) == 1 ) { tDtic = 0; }
                    if ( CellValue( x18 , 5 ) == 1 ) { tDmof = 0; }
                    if ( CellValue( x18 , 6 ) == 1 ) { tDtoc = 0; }
                    if ( CellValue( x18 , 7 ) == 1 ) { tCtic = 0; }
                    if ( CellValue( x18 , 8 ) == 1 ) { tCtoc = 0; }
                }
                if ( !( tDmif == 0 && tDtic == 0 && tDmof == 0 && tDtoc == 0 && tCtic == 0 && tCtoc == 0 ) ) {
                    var rowno2 = sheetObj.DataInsert(-1);
                    sheetObj.CellValue2( rowno2 , 2 ) = 0;
                    sheetObj.CellValue2( rowno2 , 3 ) = tDmif;
                    sheetObj.CellValue2( rowno2 , 4 ) = tDtic;
                    sheetObj.CellValue2( rowno2 , 5 ) = tDmof;
                    sheetObj.CellValue2( rowno2 , 6 ) = tDtoc;
                    sheetObj.CellValue2( rowno2 , 7 ) = tCtic;
                    sheetObj.CellValue2( rowno2 , 8 ) = tCtoc;
                    sheetObj.CellValue2( rowno2 , 9 ) = "0";
                    sheetObj.CellValue2( rowno2 ,10 ) = "1";
                }
            }
        }
    }
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        with (sheetObj) {
//            
//            if ( RowCount == 0 ) {
//                doActionIBSheet2(sheetObjects[1], document.form, IBINSERT);
//            }
        }
    }
    
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대+숫자 
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "engup2":
                // 영문대+숫자+예외문자
                DmtComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    
    function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form ); //- 키보드 입력할때
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
        axon_event.addListenerForm('change', 'obj_change', form);
    }
    
function obj_change() {
    obj = event.srcElement;
    if (obj.name == "taxrto") {
        if (obj.value > 0) {
            document.form.rtovat.value = "Y";
            document.form.rtovat.disabled = true;
        } else {
            document.form.rtovat.value = "Y";
            document.form.rtovat.disabled = false;
        }
    }
}
	//window 창이 close 될때 이벤트 발생
	function unLoadPage(){
		if ( document.form.tJspno.value == "EES_DMT_4002" ||
			document.form.tJspno.value == "EES_DMT_3109" ||
		    document.form.tJspno.value == "EES_DMT_3108" ||
		    document.form.tJspno.value == "EES_DMT_4004" ||
		    document.form.tJspno.value == "EES_DMT_4016-1"
		) {
			var opener = window.dialogArguments;
			//opener.document.form.tax_rto.value = document.form.taxrto.value;
			var tTftp = document.form.tTftp.value;
			var tTaxRto = document.form.taxrto.value;
			var rtnValTerm = "";
			var rtnValIsDt = "";
			var tOpnTftp = 0;
			if ( tTftp == "DMIF" ) {
				tOpnTftp = 3;
			} else if ( tTftp == "DTIC" ) {
				tOpnTftp = 4;
			} else if ( tTftp == "DMOF" ) {
				tOpnTftp = 5;
			} else if ( tTftp == "DTOC" ) {
				tOpnTftp = 6;
			} else if ( tTftp == "CTIC" ) {
				tOpnTftp = 7;
			} else if ( tTftp == "CTOC" ) {
				tOpnTftp = 8;
			}
			for ( var x18 = 2 ; x18 < sheetObjects[0].LastRow+1 ; x18++ ) {
				if ( sheetObjects[0].CellValue( x18 , tOpnTftp ) == 1 ) {
	               rtnValTerm = sheetObjects[0].CellValue( x18 ,  9 );
	               rtnValIsDt = sheetObjects[0].CellValue( x18 , 10 );
	           }
	       }
	       opener.getSheetOptionData(rtnValTerm,rtnValIsDt,tTaxRto);
		}	
	}
