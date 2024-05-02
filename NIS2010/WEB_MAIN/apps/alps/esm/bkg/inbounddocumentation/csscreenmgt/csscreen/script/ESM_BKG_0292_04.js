/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292_04.js
*@FileTitle : C/S Screen (
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
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
     * @class esm_bkg_0292_04 : esm_bkg_0292_04 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0292_04() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
    }

    /* 개발자 작업  */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    
    var t5sheet1 = 0;
    var t5sheet2 = 1;
    var t5sheet3 = 2;
    
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    
    var previewSheet = 1;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
     * @param {void}
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function processButtonClick(){
             
        var param = null;
        var sc_no = null;
        var cntr_no = null;
        
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            //비활성화되었다면 리턴
            if(!ComIsBtnEnable(srcName)){
                return;
            }

            switch(srcName) {
                case "btn_t5Preview":
                	if (sheetObjects[t5sheet1].RowCount == 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}
					//RD 정보 구해오기
//                	var bkg_no = sheetObjects[sheetObjects.length-1].CellValue(1, "sheet2_bkg_no");
					var bkg_no = document.form.bkg_no.value;
                	var mrdId = formObject.h_mrd_id.value;
					var loclLangFlg = formObject.h_local_lang_flg.value;

					if(mrdId == ""){
						ComShowCodeMessage("BKG40050");
						return;
					}

					if(bkg_no == ""){
						ComShowCodeMessage("BKG00149");
						return;
					}

					formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
						+ mrdId
						+ ".mrd";
					var strArg = "/rv ";
					strArg += " form_bkgNo['" + bkg_no + "']";
					strArg += " form_revise_YN['']";
					strArg += " form_usrId['" + strUsr_id + "']";
					strArg += " form_tsFlg['N']";
					strArg += " form_loclFlg['" + loclLangFlg + "']";
					strArg += " form_ofcCd['" + lginOfcCd + "']";
					
					if (previewSheet == 1) {
						strArg += " form_remarkCtnt['" + sheetObjects[t5sheet2].CellValue(2,"t5sheet2_"+"diff_rmk") + "']";
						if (sheetObjects[t5sheet2].CellValue(2,"t5sheet2_"+"chg_dp_flg") == "Y") {
							strArg += " form_chgDpFlg['1']";
						} else {
							strArg += " form_chgDpFlg['0']";
						}
					} else {
						strArg += " form_remarkCtnt['" + sheetObjects[t5sheet3].CellValue(2,"t5sheet3_"+"diff_rmk") + "']";
						if (sheetObjects[t5sheet3].CellValue(2,"t5sheet3_"+"chg_dp_flg") == "Y") {
							strArg += " form_chgDpFlg['1']";
						} else {
							strArg += " form_chgDpFlg['0']";
						}
					}

//					strArg += " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
					
					formObject.com_mrdArguments.value = strArg;
					formObject.com_mrdTitle.value = "Arrival Notice Send";
					formObject.com_mrdDisableToolbar.value = "";
					formObject.com_mrdBodyTitle.value = "Arrival Notice Send";
//					ComOpenRDPopup();
					ComOpenRDPopupModal();

                	break;
                case "btn_t5Master":

                	if (sheetObjects[t5sheet1].RowCount == 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}
                	
                	var cust_cnt_cd = sheetObjects[t5sheet1].CellValue(1, "t5sheet1_cust_cnt_cd");
                	var cust_seq = sheetObjects[t5sheet1].CellValue(1, "t5sheet1_cust_seq");
                	
                	param="?pgmNo=ESM_BKG_0240";
                	
//                	ComOpenWindow("/hanjin/ESM_BKG_0240.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
                	ComOpenWindowCenter("/hanjin/ESM_BKG_0240.do"+param, "ESM_BKG_0240", 1024, 670, true);
                	break;
                        
                case "btn_t5SendAn":
                	if (sheetObjects[t5sheet1].RowCount == 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}

//                	var bl_no = sheetObjects[sheetObjects.length-1].CellValue(1, "sheet2_bl_no");
                	var bl_no = document.form.bl_no.value;
                	
                	param="?bl_no="+bl_no+ "&sch_tp=B&autoSearchFlg=Y"+ "&pgmNo=ESM_BKG_0381";
                	
//                	ComOpenWindow("/hanjin/ESM_BKG_0381.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", false);
                	
                	ComOpenWindowCenter("/hanjin/ESM_BKG_0381.do"+param, "ESM_BKG_0381", 1024, 670, true);
                    break;

                case "btn_t5AnTemplate": //btn_t5SendOBl
//                	ComOpenWindow("/hanjin/ESM_BKG_0375.do"+ "?pgmNo=ESM_BKG_0375", "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
                	ComOpenWindowCenter("/hanjin/ESM_BKG_0375.do"+ "?pgmNo=ESM_BKG_0375", "ESM_BKG_0375", 1024, 650, true);
                	break;
                        
                case "btn_t5SendOBl": 
                	if (sheetObjects[t5sheet1].RowCount == 0) {
                		ComShowCodeMessage("BKG40060");
                		return;
                	}
                	
//                	var bl_no = sheetObjects[sheetObjects.length-1].CellValue(1, "sheet2_bl_no");
                	var bl_no = document.form.bl_no.value;
                	param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0218_02";
                	
//                	ComOpenWindow("/hanjin/ESM_BKG_0218_02.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
                	ComOpenWindowCenter("/hanjin/ESM_BKG_0218_02.do"+param, "ESM_BKG_0218_02", 1024, 650, true);
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
      * IBSheet Object를 배열로 등록<br>
      * @param sheet_obj IBSheet Object
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

     /**
      * Sheet 기본 설정 및 초기화<br>
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      * @param {void}
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	if (sheetObjects[i].id == "t5sheet1") {
	            initSheet(sheetObjects[i],i+1);        		
        	} else {
	        	ComConfigSheet (sheetObjects[i] );
	
	            initSheet(sheetObjects[i],i+1);
	
	            ComEndConfigSheet(sheetObjects[i]);
        	}
        }

//        document.form.bkg_no.value = "SGNY1030003";
        
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }        
    }
         
     /**
      * 시트 초기설정값, 헤더 정의<br>
      * @param sheetObj IBSheet Object
      * @param sheetNo  IBSheet의 순서
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var prefix = "";
        var sheetID = sheetObj.id;
        
        switch(sheetID) {        
            case "t5sheet1":      //t5sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                        
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Cust Cd|Cust Nm|Pod Cd|Del Cd|Cust Addr|Cust_Seq|bkg cust tp cd|cust cnt cd";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)
                    
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix = "t5sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_cd",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "cust_nm",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "pod_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "del_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_addr",        false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_seq",         false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "bkg_cust_tp_cd",   false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_cnt_cd",      false,      "",      dfNone,      0,     true,       true);
                    
                    CountPosition = 0;
                }
                break;
            case "t5sheet2":      //t5sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false);

                    var HeadTitle1 = "|KIND|Charge|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER #1|BROKER #1|BROKER #2|BROKER #2|One Time Only|One Time Only|Result Date|Remark(s)||1|2|3|4|5|6|7|8|9|0";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    var prefix = "t5sheet2_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    true,        prefix + "kind_desc",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              50,    daCenter,    true,        prefix + "chg_dp_flg",         false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg1",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no1",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg2",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no2",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg3",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no3",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg4",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no4",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg5",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no5",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "snd_dt",             false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              200,   daCenter,    true,        prefix + "diff_rmk",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_gdt",            false,      "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd1",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd2",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd3",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd4",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd5",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm1",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm2",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm3",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm4",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm5",       false,      "",      dfNone,      0,     false,       false);
                    
                    CountPosition = 0;
                    
                    ScrollBar = 3;

                    AutoRowHeight = false;
                    
                 // 문장이 길경우 글자 사이즈에 따라 [...] 으로 표시함
        			Ellipsis = true;
                }
                break;

            case "t5sheet3":      //t5sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false);
                    
                    var HeadTitle1 = "|KIND|Charge|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER #1|BROKER #1|BROKER #2|BROKER #2|One Time Only|One Time Only|Result Date|Remark(s)||1|2|3|4|5|6|7|8|9|0";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    var prefix = "t5sheet3_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    true,        prefix + "kind_desc",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              50,    daCenter,    true,        prefix + "chg_dp_flg",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg1",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no1",             false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg2",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no2",             false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg3",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no3",             false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg4",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daLeft  ,    false,       prefix + "snd_no4",             false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,          20,    daCenter,    false,       prefix + "snd_flg5",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              170,   daCenter,    false,       prefix + "snd_no5",             false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "snd_dt",              false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              200,   daCenter,    true,        prefix + "diff_rmk",            false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_gdt",             false,      "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd1",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd2",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd3",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd4",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_cd5",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm1",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm2",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm3",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm4",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "snd_rslt_nm5",        false,      "",      dfNone,      0,     false,       false);
                    
                    CountPosition = 0;
                    
                    ScrollBar = 3;

                    AutoRowHeight = false;
                    
                 // 문장이 길경우 글자 사이즈에 따라 [...] 으로 표시함
        			Ellipsis = true;
                }
                break;
                
//            case "sheet2":
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msHeaderOnly;
//
//                    //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//
//                    var HeadTitle = "ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
//                    var headCount = ComCountHeadTitle(HeadTitle);
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, false, true, true, false,false)
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    prefix = "sheet2_";
//                    
//                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30, daCenter,  true,     prefix + "ibflag");
//                    InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "partial",            false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "bl_no",              false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "bkg_no",             false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "split_flg",          false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,   false,   prefix + "bl_tp_cd",           false,          "",     dfNone,         0,      false,      true);
//                    
//                    CountPosition = 0;
//                }
//                break;
                
        }
    }

    /**
     * Sheet관련 프로세스 처리<br>
     * @param sheetObj IBSheet Object
     * @param formObj  UI 화면의 Object
     * @param sAction  IBSEARCH - 조회, COMMAND01, COMMAND02, COMMAND04
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                
            	ComOpenWait(true);
            	sheetObjects[t5sheet1].WaitImageVisible = false;
            	
            	formObj.f_cmd.value = SEARCH;
                var aryPrefix = new Array("t5sheet1_", "t5sheet2_", "t5sheet3_"); //prefix 문자열 배열
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0292_04GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                
                
                var arrXml = sXml.split("|$$|");

                sheetObjects[t5sheet1].Redraw = false;
                sheetObjects[t5sheet1].WaitImageVisible = false;
                sheetObjects[t5sheet1].LoadSearchXml(arrXml[0]);
                sheetObjects[t5sheet1].Redraw = true;

                sheetObjects[t5sheet2].Redraw = false;
                sheetObjects[t5sheet2].WaitImageVisible = false;
                sheetObjects[t5sheet2].LoadSearchXml(arrXml[1]);
                sheetObjects[t5sheet2].Redraw = true;

                sheetObjects[t5sheet3].Redraw = false;
                sheetObjects[t5sheet3].WaitImageVisible = false;
                sheetObjects[t5sheet3].LoadSearchXml(arrXml[2]);
                sheetObjects[t5sheet3].Redraw = true;
                
                var mrdId = ComGetEtcData(arrXml[0], "mrdId");
                var localLangFlg = ComGetEtcData(arrXml[0], "localLangFlg");
                
                document.form.h_mrd_id.value = mrdId;
                document.form.h_local_lang_flg.value = localLangFlg;
                
                sheetObjects[t5sheet1].WaitImageVisible = true;

                ComOpenWait(false);
                
                break;
        }
    }

     /**
      * 화면의 버튼을 비 활성화 시킨다.
      * @param  void
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function buttonColorSet(btn_name, color){
        var tds = document.getElementsByTagName("td");
        var curFlag = null;
     
        if (color == 'red') {
    	    curFlag = "hand";
        } else {
    	    curFlag = "default";
        }
     
        for(var i = 0; i < tds.length; i++) {
            var td=tds[i];

            if(td.name == '•' + btn_name){
           	    td.style.color = color;
           	    td.style.cursor = curFlag;
           	 
           	if (btn_name == "btn_split") {
           	    document.form.h_split.value = color;
           	}
                break;
            }else if(td.name == btn_name){
           	    td.style.color = color;
           	    td.style.cursor = curFlag;
           	 
           	    if (btn_name == "btn_split") {
           		    document.form.h_split.value = color;
           	    }
                break;
            }else{
           	    continue;
            }
        }
    }
    
    /**
     * 화면의 조회 처리 모듈을 통합적으로 관리한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnSearch() {
        
    	fnNoticeClear();
    	
    	doActionIBSheet(sheetObjects[t5sheet1],document.form,IBSEARCH,"","");
    }
    
    
    /**
    * Float 여부를 체크한다.
    * @param  Object  fVal 체크할 값
    * @return Boolean True - Float, False - Float가 아님
    * @author An JinEung
    * @version 2009.11.01
    **/
    function isFloat(fVal) {
    	var temp = 0;
    	var sVal = null;
    	
    	
    	var sIdx = fVal.toString().indexOf(".");
    	
    	if (sIdx > 0) {
	    	var sTemp = fVal.toString();
    		
    		sVal = sTemp.substring(parseInt(sIdx) + 1);
	    	
	    	if (parseInt(sVal) > 0 ) {
	    		return true;
	    	} else {
	    		return false;
	    	}
    	} else {
    		return false;
    	}
    }
        
     /**
      * t5sheet1의 조회가 완료된 시점에 값을 설정한다.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t5sheet1_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum = 0;
    	var maxRow = sheetObj.LastRow;
    	var prefix = "t5sheet1_";
    	var cellValue = "";
    	
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
        		for(i=1;i <= maxRow ; i++){
        			cellValue = sheetObj.CellValue( i,prefix + "bkg_cust_tp_cd");
        			
        			if (cellValue == "C") {
        				document.form.frm_t5sheet1_cust_cd_c.value = sheetObj.CellValue(i, prefix + "cust_cd");
        				document.form.frm_t5sheet1_cust_nm_c.value = sheetObj.CellValue(i, prefix + "cust_nm");
        				document.form.frm_t5sheet1_cust_addr_c.value = sheetObj.CellValue(i, prefix + "cust_addr");
        			} else if (cellValue == "N") {
        				document.form.frm_t5sheet1_cust_cd_n.value = sheetObj.CellValue(i, prefix + "cust_cd");
        				document.form.frm_t5sheet1_cust_nm_n.value = sheetObj.CellValue(i, prefix + "cust_nm");
        				document.form.frm_t5sheet1_cust_addr_n.value = sheetObj.CellValue(i, prefix + "cust_addr");        				
        			} else if (cellValue == "A") {
        				document.form.frm_t5sheet1_cust_cd_a.value = sheetObj.CellValue(i, prefix + "cust_cd");
        				document.form.frm_t5sheet1_cust_nm_a.value = sheetObj.CellValue(i, prefix + "cust_nm");        				
        			}
        		}         	   
            }
        } else {
     	   fnNoticeClear();
        }
    }        

     /**
      * t5sheet2의 조회가 완료된 시점에 값을 설정한다.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t5sheet2_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum = 0;
        
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
        		var maxRow = sheetObj.LastRow;
        		var cellValue = "";
        		var prefix = "t5sheet2_";
        		for(i=1;i <= maxRow ; i++){


        			//전송상태에 따라 글자색 설정
        			for(var q=1;q<6;q++){
        				//FAX
        				cellValue = sheetObj.CellValue( i,prefix + "snd_rslt_cd"+q);
        				if(cellValue == "R"){  // 실패,빨간색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(255,0,0);
        				}else if(cellValue == "B"){  // 성공,파란색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(0,0,255);
        				}else if(cellValue == "X"){  // 검은색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(0,0,0);
        				}else if(cellValue == "P"){  // 진행중,핑크색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(255,0,192);
        				}

        				cellValue = sheetObj.CellValue( i,prefix + "snd_rslt_nm"+q);
        				if(cellValue != "") {
        					sheetObj.ToolTipText(i, prefix + "snd_no"+q) = cellValue;
        				}
        			}
        		}
         		
        		cellValue = sheetObj.CellValue( i,prefix + "snd_gdt");
         		if(cellValue != "") {
    				sheetObj.ToolTipText(i, prefix + "snd_dt") = cellValue;
    			}
            }
        }
    }        
       
     /**
      * t5sheet3의 조회가 완료된 시점에 값을 설정한다.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t5sheet3_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum = 0;
        
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
        		var maxRow = sheetObj.LastRow;
        		var cellValue = "";
        		var prefix = "t5sheet3_";
        		for(i=1;i <= maxRow ; i++){
        			//전송상태에 따라 글자색 설정
        			for(var q=1;q<6;q++){
        				// EMAIL
        				// 이메일 전송 성공/실패 코드 - EML_PROC_STS_CD
        				cellValue = sheetObj.CellValue( i,prefix + "snd_rslt_cd"+q);
        				if(cellValue == "R"){  // 실패,빨간색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(255,0,0);
        				}else if(cellValue == "B"){//성공,파란색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(0,0,255);
        				}else if(cellValue == "X"){  // 검은색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(0,0,0);
        				}else if(cellValue == "P"){  // 진행중,핑크색
        					sheetObj.CellFontColor(i,prefix + "snd_no"+q) = sheetObj.RgbColor(255,0,192);
        				}

        				cellValue = sheetObj.CellValue( i,prefix + "snd_rslt_nm"+q);
       				    if(cellValue != "") {
       					    sheetObj.ToolTipText(i, prefix + "snd_no"+q) = cellValue;
       				    }
        			}
        			
        			cellValue = sheetObj.CellValue( i,prefix + "snd_gdt");
           		    if(cellValue != "") {
    				    sheetObj.ToolTipText(i, prefix + "snd_dt") = cellValue;
    			    }
        		}                
            }
        }
    }        
    
     /**
      * t5sheet2의 목록을 클릭할 때 발생하는 이벤트
      * @param Object  sheetObj IBSheet Object
      * @param Integer row      Row의 위치
      * @param Integer col      Col의 위치
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t5sheet2_OnClick(sheetObj, Row, Col){        	 
        previewSheet = 1;
    }

    /**
     * t5sheet3의 목록을 클릭할 때 발생하는 이벤트
     * @param Object  sheetObj IBSheet Object
     * @param Integer row      Row의 위치
     * @param Integer col      Col의 위치
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function t5sheet3_OnClick(sheetObj, Row, Col){        	 
        previewSheet = 2;
    }


    function fnNoticeClear() {
    	document.form.frm_t5sheet1_cust_cd_c.value = "";
    	document.form.frm_t5sheet1_cust_nm_c.value = "";
    	document.form.frm_t5sheet1_cust_addr_c.value = "";
    	document.form.frm_t5sheet1_cust_cd_n.value = "";
    	document.form.frm_t5sheet1_cust_nm_n.value = "";
    	document.form.frm_t5sheet1_cust_addr_n.value = "";
    	document.form.frm_t5sheet1_cust_cd_a.value = "";
    	document.form.frm_t5sheet1_cust_nm_a.value = "";
    	
    	sheetObjects[t5sheet1].RemoveAll();
    	sheetObjects[t5sheet2].RemoveAll();
    	sheetObjects[t5sheet3].RemoveAll();
//    	sheetObjects[sheetObjects.length-1].RemoveAll();
    }
    
    function fnQueryExec(bkg_no, bl_no) {
    	if (bkg_no != "") {         	
      		document.form.bkg_no.value = bkg_no;
      		document.form.bl_no.value = bl_no;
      		fnSearch();
        }     	
    }
    
    

    /**
    * 더블클릭 이벤트 발생시
    **/
    function t5sheet2_OnDblClick(sheetObj, Row, Col, Value){
        var colName = sheetObj.ColSaveName(Col);


        if( colName == "t5sheet2_" + "diff_rmk"){
            sheetObj.CellEditable(Row, colName) = false;
            ComShowMemoPad(sheetObj, Row, colName, true, 200, 100 );
        }
    }
    
    /**
     * 더블클릭 이벤트 발생시
     **/
     function t5sheet3_OnDblClick(sheetObj, Row, Col, Value){
         var colName = sheetObj.ColSaveName(Col);


         if( colName == "t5sheet3_" + "diff_rmk"){
             sheetObj.CellEditable(Row, colName) = false;
             ComShowMemoPad(sheetObj, Row, colName, true, 200, 100 );
         }
     }    
    /* 개발자 작업  끝 */