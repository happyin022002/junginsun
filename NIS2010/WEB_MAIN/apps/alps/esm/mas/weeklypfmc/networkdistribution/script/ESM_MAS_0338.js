/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_MAS_0338.js
*@FileTitle : Agreed Network Cost Ratio Table
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.19 송민석
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
     * @class ESM_MAS_0338 : ESM_MAS_0338 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0338() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */


    ﻿
    // 공통전역변수
 
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var selectedRow = 0;
    
 
    // new 버튼 또는 화면 리셋 플래그
    // var isNew = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var eventStatus = "";

    /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 송민석
	  * @version 2017.07.19
	  */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        
        /*******************************************************/
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
              
                case "btn_add":
                    doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
                    break;
                    
                case "btn_del":
                    doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
                    break;
                    
                    
                case "btn_add2":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;
                    
                case "btn_del2":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;      
    
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
                    break;
 
                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;
                case "btn_month_copy":
                    doActionIBSheet(sheetObjects[0], formObject,IBSEARCH_ASYNC01);
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */ 
    function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;
            
    }

 

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function loadPage() {

    	 for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
    
        }

 
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        setYrMon();
     }
    
    /**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function sheet2_OnLoadFinish(sheetObj) {
	   	 sheetObj.WaitImageVisible = false; 
 
    }

   

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */ 
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {
         
 
         
            case "sheet1":      //sheet1 init
                 with (sheetObj) {

                    // 높이 설정
                     style.height = 438;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle =  " |Month|From Lane|From Lane|From Lane|From Lane|From Lane|From Lane|From Lane|From Lane";
                     var HeadTitle2 = " |Month|cost_yrmon_seq|grp_seq|Trade|Lane|IOC|H/B|DIR|Alloc.\nType";

                     var headCount = ComCountHeadTitle(HeadTitle2);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,      "ibflag");
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,  "cost_yrmon"               ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtHidden,         60,    daCenter,   false,  "cost_yrmon_seq"           ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtHidden,         60,    daCenter,   false,  "grp_seq"                  ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtPopup,         60,    daCenter,   false,  "trd_cd"                   ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "rlane_cd"                 ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "ioc_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         50,    daCenter,   false,  "hul_bnd_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);                    
                     InitDataProperty(0, cnt++ , dtData,         50,    daCenter,   false,  "dir_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtCombo,         50,    daCenter,   false,  "bzc_aloc_tp_cd"                   ,  false,   "",  dfNone,  0, true, true,10,false,false);

                     InitDataCombo(0,"bzc_aloc_tp_cd", " |Ratio|Fixed", " |R|F","","",0,"","");  
 
                }
                 break;

            case "sheet2":      //sheet2 init
                 with (sheetObj) {

                    // 높이 설정
                     style.height = 438;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)
                     var HeadTitle =  " |Month|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane|To Lane";

                     var HeadTitle2 = "|Month|cost_yrmon_seq|grp_seq|Trade|Lane|IOC|H/B|Bound|Alloc.\nType|Ratio|Fixed\nAmount|Additional\nCost Flag|Slot Price\nRatio|LO/TS";
                     var headCount = ComCountHeadTitle(HeadTitle2);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,     "ibflag");
                     InitDataProperty(0, cnt++ , dtHidden,         60,    daCenter,   false,  "cost_yrmon"               ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtHidden,         60,    daCenter,   false,  "cost_yrmon_seq"           ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtHidden,         60,    daCenter,   false,  "grp_seq"                  ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtPopup,         60,    daCenter,   false,  "trd_cd"                   ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "rlane_cd"                 ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "ioc_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "hul_bnd_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);                    
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "dir_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);
                     InitDataProperty(0, cnt++ , dtHidden,         60,    daCenter,   false,  "bzc_aloc_tp_cd"                   ,  false,   "",  dfNone,  0, true, true,10,false,false);

                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "bzc_aloc_rto"                   ,  false,   "",  dfNone,  0, true, true,5,false,false);
                     InitDataProperty(0, cnt++ , dtData,         65,    daCenter,   false,  "bzc_aloc_fx_amt"                   ,  false,   "",  dfNone,  0, true, true,12,false,false);
                     InitDataProperty(0, cnt++ , dtCombo,         75,    daCenter,   false,  "ovr_usd_aloc_chg_flg"                   ,  false,   "",  dfNone,  0, true, true,10,false,false);
                     InitDataProperty(0, cnt++ , dtData,         75,    daCenter,   false,  "ovr_usd_aloc_chg_rto"                   ,  false,   "",  dfNone,  0, true, true,5,false,false);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,  "locl_ts_sts_cd"                   ,  false,   "",  dfNone,  0, false, false,10,false,false);

                     InitDataCombo(0,"bzc_aloc_tp_cd", " |Ratio|Fixed", " |R|F","","",0,"","");  
                     InitDataCombo(0,"ovr_usd_aloc_chg_flg", " |Y|N", " |Y|N","","",0,"","");  

                     
                     
                }
                 break;

         }
     }

     /**
      * Sheet관련 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return 없음
      * @author 송민석
      * @version 2017.07.19
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          
            case IBSEARCH:      //조회
            	
            	try {
     			    for (var i = 0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].WaitImageVisible = false;
				    }
				    ComOpenWait(true);
 
                    if (validateForm(sheetObj,document.form,sAction)) {
         
                        
                        formObj.f_cmd.value = SEARCH01;
                         
                        var sXml = sheetObjects[0].GetSearchXml("ESM_MAS_0338GS.do" , FormQueryString(formObj));
                        var arrXml = sXml.split("|$$|");
                        
                        if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);     
                        if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);     



         
                    }
            
	            	 
		            ComOpenWait(false);
					
				 } catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e);
     	            }
     	       } finally {
     	    	   ComOpenWait(false);
     	       }	
     	       
                break;

            case IBSAVE:        //저장
            
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                    
                eventStatus = "IBSAVE";
                
                formObj.f_cmd.value = MULTI01;
                        
                var sParam = FormQueryString(formObj);
                var sParamSheet1 = sheetObjects[1].GetSaveString(true); 
                if ( sParamSheet1 == "") {
                    return;
                }
                    
                sParam += "&" + sParamSheet1;
                
                try {
     			    for (var i = 0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].WaitImageVisible = false;
				    }
				    ComOpenWait(true);
               
	                var sXml = "";
	 
	                sXml = sheetObj.GetSaveXml("ESM_MAS_0338GS.do", sParam);
   	                sheetObjects[1].LoadSaveXml(sXml);
                    
	                ComOpenWait(false);
					
				} catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e);
     	            }
     	        } finally {
     	    	    ComOpenWait(false);
     	        }	
                    
  
                
                break;
                 
        
            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        var idx = sheetObj.DataInsert();
                        var max_seq = ComMasGetMaxExceptDelete(sheetObj, "grp_seq");
                       // alert(idx)
                        var grpSeq = parseInt(max_seq)+1;
                        sheetObj.CellValue2(idx,"grp_seq")=grpSeq;
                        sheetObj.CellValue2(idx,"cost_yrmon")=formObj.saved_cost_yrmon.value.replace("-","");
 
                        var idx2 = sheetObjects[1].DataInsert();
                        sheetObjects[1].CellValue2(idx2,"grp_seq") = grpSeq;
                        sheetObjects[1].CellValue2(idx2,"cost_yrmon") = formObj.saved_cost_yrmon.value.replace("-","");
                        sheetObjects[1].CellValue2(idx2,"locl_ts_sts_cd") = "LO";
                        sheetObjects[1].CellValue2(idx2,"ovr_usd_aloc_chg_flg") = "N";
                        var cost_yrmon_max_seq = ComMasGetMaxExceptDelete(sheetObj, "cost_yrmon_seq");
                        sheetObjects[1].CellValue2(idx2,"cost_yrmon_seq")  = cost_yrmon_max_seq;
                        
                        setLoCellEditable(sheetObjects[1],idx2);
                        sheetObjects[1].ColumnSort("grp_seq|locl_ts_sts_cd|cost_yrmon_seq");

                    }else   if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataInsert(-1);
                        sheetObj.CellValue2(idx,"grp_seq")=sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,"grp_seq")
                        sheetObj.CellValue2(idx, "locl_ts_sts_cd") = "TS";
                        sheetObj.CellValue2(idx, "bzc_aloc_tp_cd") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bzc_aloc_tp_cd");
                        sheetObj.CellValue2(idx,"cost_yrmon")=formObj.saved_cost_yrmon.value.replace("-","");
                        sheetObj.CellValue2(idx,"ovr_usd_aloc_chg_flg") = "N";
                        var cost_yrmon_max_seq = ComMasGetMaxExceptDelete(sheetObj, "cost_yrmon_seq");
                        sheetObj.CellValue2(idx,"cost_yrmon_seq")  = parseInt(cost_yrmon_max_seq)+1;
                        sheetObj.ColumnSort("grp_seq|locl_ts_sts_cd|cost_yrmon_seq","ASC","ASC|ASC|ASC",true);

                    }
                }
                break;
                
            case IBDELETE: // Delete
 
                
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                
                if (sheetObj.id == "sheet1") {
                    //sheetObj.SelectRow
                    var sheetDetail = sheetObjects[1];
                    var grpSeq = sheetObj.CellValue(sheetObj.SelectRow,"grp_seq");
                    var rowCount =  sheetDetail.LastRow;
                    for(var j = sheetDetail.HeaderRows;  j <= rowCount; j++ ){
                        j = sheetDetail.FindText("grp_seq",grpSeq,0);
                        if( j < 0 ){
                            break;
                        }
                        sheetDetail.RowDelete(j,false);
                    }   
                    sheetObj.RowDelete(sheetObj.SelectRow, false);
                    sheetObj.SelectCell(sheetObj.LastRow, "cost_yrmon") ;
                }else if (sheetObj.id == "sheet2") {
                    var locl_ts_sts_cd = sheetObj.CellValue(sheetObj.SelectRow,"locl_ts_sts_cd");
                    if( locl_ts_sts_cd != "LO"){
                        sheetObj.RowDelete(sheetObj.SelectRow, false);
                    }

                }
                
                break;
            case IBSEARCH_ASYNC01: // Month Copy
                var display = "0,1";
                ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0338&check_cnt=Y", 250, 200, "Agreed Network Cost Ratio Creation", display, true, false);
                break;
         }
     }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 송민석
     * @version 2017.07.19
     */
     function validateForm(sheetObj,formObj,sAction){
          switch (sAction) {
          
            case IBSEARCH: // 조회
                
                with(formObj){
                    if(f_cost_yrmon.value == "") {
                        ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                        f_cost_yrmon.focus();
                        return false;
                    }
                }
  
                return true;
                break;
        
            case IBSAVE: // 저장
                //    msgs['MAS00006'] = 'Do you want to save?';
                //    msgs['MAS00007'] = 'There is no contents to save.';
                //    msgs['MAS00015'] = '{?msg1} is duplicated';

                var sheetMaster = sheetObjects[0];
                var sheetDetail = sheetObjects[1];
                
                if(sheetMaster.RowCount == 0){
                    ComShowCodeMessage("MAS00007");//'There is no contents to save.'
                    return false;

                }
                if (!ComShowCodeConfirm("MAS00006")) {//'Do you want to save?';
                    return false;
                }
                //sheet1 dup check
                var rowM = sheetMaster.ColValueDup("trd_cd|rlane_cd|ioc_cd|hul_bnd_cd|dir_cd",false);
                if (rowM >= 0) {
                    ComShowCodeMessage("MAS00015", "From Lane");
                    return false;
               }  
                //sheet1 필수 입력 체크
                var rowCount =  sheetMaster.LastRow;
                for(var j = sheetMaster.HeaderRows;  j <= rowCount; j++ ){
                    var trd_cd = sheetMaster.CellValue(j,"trd_cd");
                    if(  trd_cd == "" ){
                        sheetMaster.SelectCell(j,"cost_yrmon");
                        ComShowCodeMessage("MAS10002", "From Lane");
                        return false;
                     }  
                    
                    var bzc_aloc_tp_cd = sheetMaster.CellValue(j,"bzc_aloc_tp_cd");
                    if(  bzc_aloc_tp_cd == "" ){
                       sheetMaster.SelectCell(j,"bzc_aloc_tp_cd");
                       ComShowCodeMessage("MAS10002", "Alloc. Type");
                       return false;
                    }        
    
                }   
                
                //sheet2 dup check
                //sheet2 필수 입력 체크                
                var rowCount =  sheetDetail.LastRow;
                var grpSeq = 0;
                var preGrpSeq = 0;
                var preIdx = 0;
                var grpCount=1;
                var j = sheetDetail.HeaderRows;
                for(;  j <= rowCount; j++ ){
                    grpSeq = sheetDetail.CellValue(j,"grp_seq");
                    if(  grpSeq == preGrpSeq ){
                       if( sheetDetail.CellValue(preIdx,"trd_cd") == sheetDetail.CellValue(j,"trd_cd") 
                               && sheetDetail.CellValue(preIdx,"rlane_cd") == sheetDetail.CellValue(j,"rlane_cd")
                               && sheetDetail.CellValue(preIdx,"ioc_cd") == sheetDetail.CellValue(j,"ioc_cd")
                               && sheetDetail.CellValue(preIdx,"hul_bnd_cd") == sheetDetail.CellValue(j,"hul_bnd_cd")
                               && sheetDetail.CellValue(preIdx,"dir_cd") == sheetDetail.CellValue(j,"dir_cd") ){
                           doChangeFocustMaster(grpSeq,"cost_yrmon");
                           ComShowCodeMessage("MAS00015", "To Lane4");
                           return false;
                           
                       }
                       grpCount++;
                    }else if( preGrpSeq != 0 ){
                       //alert(preGrpSeq+","+grpCount+","+grpSeq)
                       if( grpCount < 2){//2줄 미만
                           doChangeFocustMaster(grpSeq,"cost_yrmon");
                           ComShowCodeMessage("MAS10002", "To Lane3");
                           return false;
                       }
                       grpCount = 1;

                        
                    }                    
                    preIdx = j;
                    preGrpSeq = grpSeq;
                    
                    //sheet2 필수 입력 체크    
                    var trd_cd = sheetDetail.CellValue(j,"trd_cd");

                    var trd_cd = sheetDetail.CellValue(j,"trd_cd");
                    if(  trd_cd == "" ){
                        doChangeFocustMaster(grpSeq,"cost_yrmon");
                        ComShowCodeMessage("MAS10002", "To Lane2");
                        return false;
                    }  
                    
                    var bzc_aloc_tp_cd = sheetDetail.CellValue(j,"bzc_aloc_tp_cd"); 
                    var locl_ts_sts_cd = sheetDetail.CellValue(j,"locl_ts_sts_cd");

                    if(  locl_ts_sts_cd == "TS" ){
                        if( bzc_aloc_tp_cd == "R"){//ratio
                            if( sheetDetail.CellValue(j,"bzc_aloc_rto") == ""){
                                doChangeFocustMaster(grpSeq,"cost_yrmon");
                                ComShowCodeMessage("MAS10002", "Ratio");
                                return false;                                
                            }

                        }else{//Fixed Amount
                            if( sheetDetail.CellValue(j,"bzc_aloc_fx_amt") == ""){
                                doChangeFocustMaster(grpSeq,"cost_yrmon");
                                ComShowCodeMessage("MAS10002", "Fixed Amount");
                                return false;                                  
                            }
                        }
                        var ovr_usd_aloc_chg_flg = sheetDetail.CellValue(j,"ovr_usd_aloc_chg_flg");
                        if( ovr_usd_aloc_chg_flg == ""){//ratio
                            doChangeFocustMaster(grpSeq,"cost_yrmon");
                            ComShowCodeMessage("MAS10002", "Additional Cost Flag");
                            return false;                                
                     
                        }else if(ovr_usd_aloc_chg_flg == "Y"){
                            if( sheetDetail.CellValue(j,"ovr_usd_aloc_chg_rto") == ""){
                                doChangeFocustMaster(grpSeq,"cost_yrmon");
                                ComShowCodeMessage("MAS10002", "Slot Price Ratio");
                                return false;                                
                            }                           
                        }
                    }else{
                        if( bzc_aloc_tp_cd == "R"){//ratio
                            if( sheetDetail.CellValue(j,"bzc_aloc_rto") != "" && parseInt(sheetDetail.CellValue(j,"bzc_aloc_rto"))<0){
                                doChangeFocustMaster(grpSeq,"cost_yrmon");
                                ComShowCodeMessage("MAS10002", "Correct Ratio");
                                //alert("-1보다 커야함")
                                return false;                                
                            }

                        }                    
                    }  
                }                   
                
                if( grpCount < 2){//2줄 미만
                    doChangeFocustMaster(grpSeq,"cost_yrmon");
                    ComShowCodeMessage("MAS10002", "To Lane1");
                    return false;
                }           
 
                
                
                return true;
                break;
                
            case IBINSERT: // Row Add
                if (formObj.saved_cost_yrmon.value == "") {
                    ComShowCodeMessage('MAS10005',"From Lane");
                    return false;
                }
            
        
                return true;
                break;
                
            
            case IBDELETE: // Delete
 
                
                return true;
                break;
            }

         return true;
     }
     function doChangeFocustMaster(grpSeq,col){
         var dupIdx = sheetObjects[0].FindText("grp_seq",grpSeq);
         sheetObjects[0].SelectCell(dupIdx,col);
     }

   /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Location PopUp을 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 송민석
    * @version 2017.07.19
    */               
    function sheet1_OnPopupClick(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        switch(colName)
        {
            case "trd_cd":
            case "rlane_cd":
            case "ioc_cd":
            case "hul_bnd_cd":
            case "dir_cd":
                
                var sParam = "";
                var rtnVal = ComOpenWindowCenter("/hanjin/ESM_MAS_0340.do?"+sParam, "ESM_MAS_0340", 390, 650, true);      
                if (rtnVal != null){
                    sheetObj.CellValue(Row, "trd_cd") = rtnVal.trd_cd;
                    sheetObj.CellValue(Row, "rlane_cd") = rtnVal.rlane_cd;
                    sheetObj.CellValue(Row, "ioc_cd") = rtnVal.ioc_cd;
                    sheetObj.CellValue(Row, "hul_bnd_cd") = rtnVal.hul_bnd_cd;
                    sheetObj.CellValue(Row, "dir_cd") = rtnVal.dir_cd;
                }     
                break;
        }
        
    
    } 
    


    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Location PopUp을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */               
     function sheet2_OnPopupClick(sheetObj, Row, Col)
     {
         var colName = sheetObj.ColSaveName(Col);
         var formObj = document.form;
         
         switch(colName)
         {
             case "trd_cd":
             case "rlane_cd":
             case "ioc_cd":
             case "hul_bnd_cd":
             case "dir_cd":
                 
                 if( sheetObj.CellValue(Row,"locl_ts_sts_cd" ) == "LO" ){
                     return;
                 }
                 var sParam = "";
                 var rtnVal = ComOpenWindowCenter("/hanjin/ESM_MAS_0340.do?"+sParam, "ESM_MAS_0340", 390, 650, true);      
                 if (rtnVal != null){
                     sheetObj.CellValue2(Row, "trd_cd") = rtnVal.trd_cd;
                     sheetObj.CellValue2(Row, "rlane_cd") = rtnVal.rlane_cd;
                     sheetObj.CellValue2(Row, "ioc_cd") = rtnVal.ioc_cd;
                     sheetObj.CellValue2(Row, "hul_bnd_cd") = rtnVal.hul_bnd_cd;
                     sheetObj.CellValue2(Row, "dir_cd") = rtnVal.dir_cd;


                 }     
                 break;
         }
         
     
     }       
    
    /**
     * sheet에서 데이터가 변경시 호출된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 
     * @param {int} Col 
     * @param {String} Value 
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		var sheetDetail = sheetObjects[1];
		
		if (sName == "bzc_aloc_tp_cd") {
	        var grpSeq = sheetObj.CellValue(Row,"grp_seq");

	        var rowCount =  sheetDetail.LastRow;
	        for(var j = sheetDetail.HeaderRows;  j <= rowCount; j++ ){
	            j = sheetDetail.FindText("grp_seq",grpSeq,j);
	            if( j < 0 ){
	                break;
	            }
	            sheetDetail.CellValue2(j,"bzc_aloc_tp_cd")=Value;

	        }		    
		}else{
            var grpSeq = sheetObj.CellValue(Row,"grp_seq");
            var finedRow = sheetDetail.FindText("grp_seq",grpSeq,0);
            sheetDetail.CellValue2(finedRow,"trd_cd")=sheetObj.CellValue(Row,"trd_cd");
            sheetDetail.CellValue2(finedRow,"rlane_cd")=sheetObj.CellValue(Row,"rlane_cd");
            sheetDetail.CellValue2(finedRow,"ioc_cd")=sheetObj.CellValue(Row,"ioc_cd");
            sheetDetail.CellValue2(finedRow,"hul_bnd_cd")=sheetObj.CellValue(Row,"hul_bnd_cd");
            sheetDetail.CellValue2(finedRow,"dir_cd")=sheetObj.CellValue(Row,"dir_cd");
		}
	}

    /**
     * sheet에서 데이터가 변경시 호출된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 
     * @param {int} Col 
     * @param {String} Value 
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value){
        var colname = sheetObj.ColSaveName(Col);  
        var formObj = document.form;
         
        switch(colname)
        {
             case "bzc_aloc_rto":
             case "bzc_aloc_fx_amt":
                 var grpSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"grp_seq");
                 var i=0;
                 var loRow = 0;
                 var sumValue = 0;
                 var rowCount =  sheetObj.LastRow;

               
                 for(var j = sheetObj.HeaderRows;  j <= rowCount; j++, i++ ){
                     j = sheetObj.FindText("grp_seq",grpSeq,j);
                     if( j < 0 ){
                         break;
                     }
                     if( i== 0){
                         loRow = j;
                         continue;
                     }
                     if( sheetObj.CellValue(j,colname) != ""){
                         sumValue = sumValue + parseInt(sheetObj.CellValue(j,colname));
                     }

                 }  
                 if( colname=="bzc_aloc_fx_amt" ){
                     sheetObj.CellValue2(loRow,"bzc_aloc_fx_amt")=sumValue;                     
                 }else{
                     sheetObj.CellValue2(loRow,"bzc_aloc_rto")=100-sumValue;
                 }
                
                break;
        }
    }  
    
    
    /**
     * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *      locationCellClear(sheetObj,Row)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */         
    function locationCellClear(sheetObj,Row){
        sheetObj.CellValue2(Row,"dtl_loc_def_cd")= "";
        sheetObj.CellValue2(Row,"loc_des")= "";         
        sheetObj.CellValue2(Row,"dtl_loc_tp_cd")= "";
        
        sheetObj.SelectCell(Row,"dtl_loc_def_cd");
    }    
 
    
    /**
    * 저장메세지 지정
    */
    function sheet2_OnSaveEnd(sheetObj,errMsg){
        if(errMsg == ""){
            ComShowMessage(ComGetMsg("MAS00004","Data"));
        }
    }

    
    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        
        if( OldRow != NewRow){
            doRowChange( OldRow, NewRow, OldCol, NewCol);
        }
        //alert(OldRow+","+NewRow)
        //
        }
 
        /**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {int} OldRow 
     * @param {int} NewRow 
     * @param {int} OldCol 
     * @param {int} NewCol 
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function doRowChange( OldRow, NewRow, OldCol, NewCo) {
        var formObj = document.form;
        var adjNewRow = NewRow;
        var sheetM = sheetObjects[0];
        var sheetD = sheetObjects[1];
        
        var grpSeq = sheetM.CellValue(NewRow,"grp_seq");
        var rowCount =  sheetD.LastRow;
        var j = 0;
        for (var i = sheetD.HeaderRows  ; i <= rowCount ; i++) {
            //alert(sheetD.CellValue(i,"grp_seq") )
            if( sheetD.CellValue(i,"grp_seq") == grpSeq ){
                sheetD.RowHidden(i) = false;
                if(j == 0){
                    setLoCellEditable(sheetD,i);
 
                }
                j++;
            }else{
                sheetD.RowHidden(i) = true;
            }
        }
          
    }
    
    function setLoCellEditable(sheetD,row){
        sheetD.CellEditable(row,"bzc_aloc_rto") = false;
        sheetD.CellEditable(row,"bzc_aloc_fx_amt") = false;
        sheetD.CellEditable(row,"ovr_usd_aloc_chg_flg") = false;
        sheetD.CellEditable(row,"ovr_usd_aloc_chg_rto") = false;

    }
     
    
    
    /**
     * 조회 시 etc data에서 맥스시퀀스 세팅. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {String} ErrMsg 
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function sheet1_OnSearchEnd(ErrMsg)  {
        var formObj = document.form;
        formObj.saved_cost_yrmon.value = formObj.f_cost_yrmon.value;
    }
    
    
    
     /**
     * 조회 시 etc data에서 맥스시퀀스 세팅. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {String} ErrMsg 
     * @return 없음
     * @author 송민석
     * @version 2017.07.19
     */
    function sheet2_OnSearchEnd(ErrMsg)  {
         doRowChange( 0, 2, 1, 1) ;

    }
    
    
    function fnYearWeekSet(obj){        
        obj.value = ComGetMaskedValue(obj.value,"ym");
    }

    function ComAddSeparator_Local(obj, sFormat) {
        try {
            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */
    function setYrMon(){
        var formObj = document.form;        
        with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm");
            if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
            var nowYrMon = nowYear + nowMon;
            f_cost_yrmon.value = nowYrMon;
            if(!ComAddSeparator(f_cost_yrmon)) return false;
      
        }
        fnYearWeekSet(document.getElementById("f_cost_yrmon"));
        
    }        

    /* 개발자 작업  끝 */