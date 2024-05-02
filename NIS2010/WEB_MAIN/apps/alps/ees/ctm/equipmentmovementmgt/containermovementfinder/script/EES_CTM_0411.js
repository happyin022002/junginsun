/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0411.js
*@FileTitle : Detail Form
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.17 우경민
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
     * @class EES_CTM_0411 : EES_CTM_0411 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0411() {
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
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");


            switch(srcName) {

                 case "btn_retrieve":
                	 if (!checkFormField()) return;
                     doActionIBSheet(sheetObject1,formObject,IBSEARCH, 1);
                     break;

                 case "btn_eachbkg":
                    ComOpenPopup("/hanjin/EES_CTM_0409.do?" +
                                 "bkg_no=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "bkg_no"), 1020, 682, "", "0,1");
                     break;

                  case "btn_print":
  					if( sheetObject2.rowcount==0 ) {
						errMsg = 'No data found.';
						ComShowMessage("CTM10024");
						return;
					}
					ComOpenPopup("/hanjin/EES_CTM_0459.do", 900, 710, "", "0,1");
					break;

                 case "btn_downexcel":
                	 sheetObjects[1].Down2Excel(0, false, false, true, "", "", false, false, "", false, "ext|cntr_no|cnmv_yr|cnmv_id_no|bkg_no");
                     break;

                 case "btn_clm":
                	 row = sheetObjects[1].SelectRow ;
                	 cntrno = sheetObjects[1].CellValue(row, "cntr_no");
                	 cnmvyr = sheetObjects[1].CellValue(row, "cnmv_yr");
                	 cnmvid = sheetObjects[1].CellValue(row, "cnmv_id_no");
                	 url = "EES_CTM_0443.do?cntr_no=" + cntrno + "&cnmv_yr=" + cnmvyr + "&cnmv_id_no=" + cnmvid;
                	 rtnValue = ComOpenPopup(url, 1000, 550, "", "0,1", true);
                     break;
 		         case "btn_Calendar2":
  		        	var cal = new ComCalendarFromTo();
 		        	    cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
  		        	 break;
 		        case "btn_del":
 		        	cntr_no = document.form.p_cntrno.value;
 		        	chk_val = document.form.check_digit.value;
 		        	tpsz_cd = document.form.ctnr_tpsz_cd.value;
 		        	p_date2 = document.form.p_date2.value;
 		        	p_date1 = document.form.p_date1.value;
                    ComOpenPopup("/hanjin/EES_CTM_0415.do" +
                                 "?p_cntrno=" + cntr_no + "&check_digit=" + chk_val +
                                 "&ctnr_tpsz_cd=" + tpsz_cd + "&p_date2=" + p_date2 +
                                 "&p_date1=" + p_date1, 1020, 682, "", "0,1");
  		        	 break;
 		        case "btn_close":
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

        for (i=0;i<sheetObjects.length;i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        setEventProcess();

        // 로그인한 사용자의 Office코드로 Country코드를 조회
        doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
        
        // p_cntrno input에 value가 있다면 Onload시 조회
        if (document.form.p_cntrno.value != "") {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, 2);
        }

        document.form.p_cntrno.focus();

    }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
              case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 90;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(11, 0, 0, true);

                     // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|TP|B/L No.|Commodity|Commodity|Commodity";

                     // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,	45,   daCenter,  	false,     "cnmv_cyc_no",   				false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	75,   daCenter,    true,    	 "vl",   				false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	47,   daCenter,  	false,     "por_cd",   				false,          "",      dfNone,  			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	47,   daCenter,  	false,     "pol_cd",   				false,          "",      dfNone,    		0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	47,   daCenter,    false,     "relay",    			false,          "",      dfNone, 				0,     true,       true);

                     InitDataProperty(0, cnt++ , dtData,	47,   daCenter,    false,     "pod_cd", 					false,          "",      dfNone,				0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	47,   daCenter,    false,     "del_cd",     			false,          "",      dfNone, 				0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	110,   daCenter,  	false,     "bkg_no",   	false,          "",      dfNone,    		0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	20,   daCenter,  	false,     "bkg_cgo_tp_cd",   	false,          "",      dfNone,    		0,     true,       true);

                     InitDataProperty(0, cnt++ , dtData,	90,   daCenter,    false,     "bl_no",    			false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	90,   daLeft,	  	false,     "rep_cmdt_nm",   	false,          "",      dfNone,  			0,     true,       true);
                     CountPosition = 0;
                     ShowButtonImage = 2;
                }
                 break;


              case 2:      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 300;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(47, 0, 0, true);

                     // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "Seq.|CYC|C|STS|A/F|Origin YD||Return YD||Event Date|VVD Code|Booking No.|F/M|I/O|MSG|TP|DM|HR|HB|D|E|R|SP|S/P|S/P|Mode|Chassis No.|M.G Set|Seal No.|VGM|Waybill|Pick Up No.|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)|Office|User Name|Correction Reason|Remark(s)|ext|||||Last BKG No.|";

                     // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     var sTipAF = "";
                     sTipAF += "[ Auto Flag ]\n";
                     sTipAF += "A : Missing status automatically created by system.\n";
                     sTipAF += "C : (International) \"TS, IC, MT\" Status automatically created after \"VD\"\n";
                     sTipAF += "      (USA domestic) \"CM\" Status automatically created after \"CD\"\n";
                     sTipAF += "N : Once automatically created status (\"A\") modified by manual,\n";
                     sTipAF += "      \"A\" changed to \"N\"\n";
                     sTipAF += "M : Added status.\n";
                     sTipAF += "U : Status updated due to next status.\n";
                     sTipAF += "E : Status created by Master/Lease.\n";
                     sTipAF += "S : Once automatically created status (\"A\") modified by late EDI,\n";
                     sTipAF += "      \"A\" changed to \"S\"\n";
                     sTipAF += "B : Status updated by manual due to error.\n";
                     sTipAF += "G : Once created without VGM, missing VGM is retroactively inserted by later EDI message.";
                                  
                     var sTipIO = "Bound indicator"; //
                     var sTipTP = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
                     var sTipDM = "Damage, Y";
                     var sTipHR = "Hanger Rack, Y";
                     var sTipHB = "Hanger Bar";
                     var sTipD  = "Disposal Candidate, Y";
                     var sTipE  = "Immediate Exit, Y";
                     var sTipR  = "Re-furbishing, Y";
                     var sTipSP = "Special, Y";

                     //데이터속성 [ROW, COL,     daTATYPE, WIDTH,     daTAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC,     daTAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtSeq,       30,     daCenter,    false,    "Seq");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "cnmv_cyc_no");
                     InitDataProperty(0, cnt++, dtData,      40,     daCenter,    false,    "cnmv_co_cd");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "mvmt_sts_cd");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "mvmt_cre_tp_cd",         false,    "",    dfNone,    0,    true,    true,    10,   false,    true,    sTipAF );
                     InitDataProperty(0, cnt++, dtData,      70,     daCenter,    false,    "org_yd_cd");
                     InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "org_yd_nm");
                     InitDataProperty(0, cnt++, dtData,      70,     daCenter,    false,    "dest_yd_cd");
                     InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "dest_yd_nm");
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "cnmv_evnt_dt",           false,    "",    dfUserFormat2);
                     InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "cntr_id");
                     InitDataProperty(0, cnt++, dtData,      90,     daCenter,    false,    "bkg_no");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "fcntr_flg");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "ob_cntr_flg");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "mvmt_edi_msg_tp_id");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "bkg_cgo_tp_cd",          false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipTP );
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "cntr_dmg_flg",           false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipDM );
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "cntr_hngr_rck_cd",       false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipHR );
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "cntr_hngr_bar_atch_knt", false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipHB );
                     InitDataProperty(0, cnt++, dtData,      20,     daCenter,    false,    "cntr_disp_flg",          false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipD );
                     InitDataProperty(0, cnt++, dtData,      20,     daCenter,    false,    "imdt_ext_flg",           false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipE );
                     InitDataProperty(0, cnt++, dtData,      20,     daCenter,    false,    "cntr_xch_cd",            false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipR );
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "spcl_cgo_flg",           false,    "",    dfNone,    0,    true,    true,    0,    false,    true,    sTipSP );
                     InitDataProperty(0, cnt++, dtData,      50,     daCenter,    false,    "vndr_seq");
                     InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "vndr_abbr_nm");
                     InitDataProperty(0, cnt++, dtData,      40,     daCenter,    false,    "mvmt_trsp_mod_cd");
                     InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "chss_no");
                     InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "mgst_no");
                     InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "cntr_seal_no");
                     InitDataProperty(0, cnt++, dtData,      80,     daRight,     false,    "vgm");
                     InitDataProperty(0, cnt++, dtData,      85,     daCenter,    false,    "wbl_no");
                     InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "pkup_no");
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "upd_locl_dt",            false,    "",    dfUserFormat2);
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "cre_locl_dt",            false,    "",    dfUserFormat2);
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "upd_dt",                 false,    "",    dfUserFormat2);
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "cre_dt",                 false,    "",    dfUserFormat2);
                     InitDataProperty(0, cnt++, dtData,      60,     daCenter,    false,    "ofc_cd");
                     InitDataProperty(0, cnt++, dtData,      130,    daLeft,      false,    "usr_nm");
                     InitDataProperty(0, cnt++, dtData,      120,    daCenter,    false,    "modi_tp",                 false,    "",    dfNone,    0,    true,    true);
                     InitDataProperty(0, cnt++, dtData,      160,    daLeft,      false,    "cnmv_rmk");

                     InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,    false,    "ext");
                     InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,    false,    "cntr_no");
                     InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,    false,    "cnmv_yr");
                     InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,    false,    "cnmv_id_no");
                     InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,    false,    "bkg_no");
                     InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,    false,    "lst_bkg_no");
                     
                     
                     InitDataProperty(0, cnt++, dtHidden,    150,    daLeft,      false,    "cnmv_his_col_nm");

                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:");
                     InitUserFormat2(0, "upd_locl_dt", "####-##-## ##:##", "-|:");
                     InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:");
                     InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:");
                     InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:");

                     ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
                     CountPosition = 0;

                }
                 break;
         }
     }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, condParam) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
            	if (condParam == 1) {
                    if (!validateForm(sheetObj,formObj,sAction)) return;
            	}
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                cntrNo = formObj.p_cntrno.value;
                sheetObjects[0].WaitImageVisible = false;
                sheetObjects[1].WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                sheetObj.DataAutoTrim = false;
                xml = sheetObj.GetSearchXml("EES_CTM_0430GS.do", FormQueryString(formObj));
                rtnValue = xml.split("|$$|")
                sheetObjects[0].LoadSearchXml(rtnValue[1]);
                sheetObjects[1].LoadSearchXml(rtnValue[0]);
                lastCnt = sheetObjects[1].LastRow;
                // sheetObjects[0].SelectRow(lastCnt);
                sheetObjects[1].SelectCell(lastCnt, 0);
                sheetObjects[0].SelectCell(sheetObjects[0].LastRow, 0);
                for (i = 1; i <= sheetObjects[1].LastRow; i++) {
                    if (sheetObjects[1].CellValue(i, "ext") == 'Y')
                    sheetObjects[1].CellBackColor(i,"Seq") = sheetObjects[1].RgbColor(164, 120, 255)
                }
                vr = sheetObjects[1].CelLValue(sheetObjects[1].LastRow, "ext");
                lastRow = sheetObjects[0].LastRow;
                sheetObjects[0].CellFont("FontBold", 1, "bkg_no", lastRow, "bkg_no") = true;
                sheetObjects[0].ColFontColor("bkg_no") = sheetObjects[0].RgbColor(0, 0, 255);
                sheetObjects[0].ColFontUnderline("bkg_no") = true;
                sheetObjects[0].DataLinkMouse("bkg_no") = true;
                if (vr == 'Y') {
                    ComBtnEnable("btn_clm");
                } else {
                    ComBtnDisable("btn_clm");
                }

                ComOpenWait(false);
                sheetObjects[0].WaitImageVisible = true;
                sheetObjects[1].WaitImageVisible = true;
                break;

            case COMMAND05:
                // 로그인한 사용자의 Office코드로 국가코드를 조회
                formObj.cnt_cd.value = ComGetEtcData(sheetObj.GetSearchXml("CTMCommonGS.do?f_cmd=" + COMMAND05), "rtnValue");
                break;
        }
    }
    
    
    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	
    	for(var i=1; i<=sheetObj.LastRow; i++){
			var modi_tp = sheetObj.CellValue(i, "modi_tp");
			var cnmv_his_col_nm = sheetObj.CellValue(i, "cnmv_his_col_nm");
			if(modi_tp == 'Update' && cnmv_his_col_nm.length > 0){
				var colArray = cnmv_his_col_nm.split(":");
				for(var k=0;k<colArray.length;k++){
					if(colArray[k] != 'ofc_cd' && colArray[k] != 'usr_nm'){
						if(colArray[k] == 'vndr'){
							sheetObj.CellBackColor(i,"vndr_seq") = sheetObj.RgbColor(255, 246, 18);
							sheetObj.CellBackColor(i,"vndr_abbr_nm") = sheetObj.RgbColor(255, 246, 18);
						}else{
							sheetObj.CellBackColor(i,colArray[k]) = sheetObj.RgbColor(255, 246, 18);
						}
					}
					
				}
			}else if(modi_tp == 'Insert'){
				sheetObj.CellBackColor(i,"modi_tp") = sheetObj.RgbColor(255, 246, 18);
			}
		}
    	
    	
        ComOpenWait(false);
        sheetObjects[1].WaitImageVisible = true;
        sheetObjects[0].WaitImageVisible = true;
        
        
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
//         }
 		if (sAction == IBSEARCH) {
	          if (cancelDate == false){
	        	  return false;
	          }
	        	  
	         }

         return true;
		}
     }


    function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        vr = sheetObjects[1].CelLValue(Row, "ext");
        if (vr == 'Y') {
            ComBtnEnable("btn_clm");
        } else {
            ComBtnDisable("btn_clm");
        }
    }

	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		if (sheetObj.RowCount > 0) {
			// 마우스 위치를 행과 컬럼과 값 가져오기
			var Row = sheetObj.MouseRow;
			var Col = sheetObj.MouseCol;

			if (Row > 0) {
				switch (sheetObj.ColSaveName(Col)) {
				case "org_yd_cd" :
					var orgYdNm = sheetObj.CellValue(Row, "org_yd_nm");
					if (orgYdNm != "") {
						sheetObj.MouseToolTipText = orgYdNm;
						sheetObj.MousePointer = "Hand";
					} else {
						sheetObj.MouseToolTipText = "";
						sheetObj.MousePointer = "Default";
					}
					break;
				case "dest_yd_cd" :
					var destYdNm = sheetObj.CellValue(Row, "dest_yd_nm");
					if (destYdNm != "") {
						sheetObj.MouseToolTipText = destYdNm;
						sheetObj.MousePointer = "Hand";
					} else {
						sheetObj.MouseToolTipText = "";
						sheetObj.MousePointer = "Default";
					}
					break;
				default :
					sheetObj.MouseToolTipText = "";
					sheetObj.MousePointer = "Default";
					break;
				}
			}
		} else {
	        sheetObj.ToolTipText(0, "IO") = "Bound indicator";
	        sheetObj.ToolTipText(0, "TP") = "Cargo type, F: Full, P: Reposition, R: Revenue";
	        sheetObj.ToolTipText(0, "DM") = "Damage, Y";
	        sheetObj.ToolTipText(0, "HR") = "Hanger rack, Y";
	        sheetObj.ToolTipText(0, "HB") = "Hanger Bar";
	        sheetObj.ToolTipText(0, "D")  = "Disposal Candidate, Y";
	        sheetObj.ToolTipText(0, "E")  = "Immediate Exit, Y";
	        sheetObj.ToolTipText(0, "R")  = "Re-stuffing, Y";
	        sheetObj.ToolTipText(0, "SP") = "Special, Y";
		}
    }


    function sheet2_OnDblClick(sheetObj, Row, Col) {
        row = sheetObjects[1].SelectRow ;
        vr = sheetObjects[1].CelLValue(row, "ext");
        if (vr != 'Y') return;
        cntrno = sheetObjects[1].CellValue(row, "cntr_no");
        cnmvyr = sheetObjects[1].CellValue(row, "cnmv_yr");
        cnmvid = sheetObjects[1].CellValue(row, "cnmv_id_no");
        url = "EES_CTM_0443.do?cntr_no=" + cntrno + "&cnmv_yr=" + cnmvyr + "&cnmv_id_no=" + cnmvid;
        rtnValue = ComOpenPopup(url ,1000, 550, "", "0,1", true);
    }


    /**
     * Bkg Inquiry 호출
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var SaveName = sheetObj.ColSaveName(Col);
        if (SaveName != 'bkg_no') return;
        var bkgNo = sheetObj.CellValue(Row, SaveName);
        var param = "?bkg_no="+ bkgNo
                  + "&isPop=N"
                  + "&pgmNo=ESM_BKG_0079_Q";
        ComOpenPopup("/hanjin/ESM_BKG_0079_Q.do" + param, 1024, 730, "", "0,1");
    }


/* 개발자 작업 끝 */