//* csr N200903120230 20080414  [PRD] Ocean Route 기능 보완
//* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
// 공통전역변수 


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];

         /*******************************************************/
         var formObject = document.form;

      try {
      var srcName = window.event.srcElement.getAttribute("name");

      switch(srcName) {

        case "btn_retrieve":
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
            break;

        case "btn_new":
            sheetObject.RemoveAll();
            formObject.reset();
            break;

        case "btn_ok":
            doSetValue(sheetObject,formObject);
            break;
        case "btn_close":
            window.close();
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

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
                    //style.height = 240;

                    //전체 너비 설정
                    //SheetWidth = mainTable.clientWidth;
                    //전체 너비 설정
                    style.height = GetSheetHeight(20) ;
                    //style.height = 270 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(58, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "Seq.|Chk|Ocn Flag|Rmk|Rmk|Priority|POL|Lane|Type|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hour)|S/Time\n(Day)";
                    var HeadTitle2 = "Seq.|Chk|Ocn Flag|Type|Note|Priority|POL|Lane|Type|Port|Lane|Type|Port|Lane|Type|Port|Lane|Type|POD|T/Time\n(Day/Hour)|S/Time\n(Day)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtSeq,      50,    daCenter,  true,    "sSeq");
                    InitDataProperty(0, cnt++, dtCheckBox, 30,    daCenter,  true,    "sChk");
                    InitDataProperty(0, cnt++, dtCombo,    70,    daCenter,  true,    "sRouteFlg",      true,           "",       dfNone,  	0,     true,       true); //20090320
                    InitDataProperty(0, cnt++, dtCombo,    60,    daLeft,    true,    "sRmk",         false,          "",       dfNone, 	0,     true,       true);
					InitDataProperty(0, cnt++, dtData,    100,    daLeft,    true,    "s_route_note", false,          "",       dfNone, 	0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,    60,    daCenter,  true,    "sPrior",       false,          "",       dfNone,  0,     true,      true);
                    
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sPol",         false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sLane",        false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sLaneTp",      false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTS1Port",     false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs1Lane",     false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs1LaneTp",   false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs2Port",     false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs2Lane",     false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs2LaneTp",   false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs3Port",      false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs3Lane",      false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sTs3Type",      false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,    "sPod",         false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     70,    daCenter,  true,    "sFmtTTime",    false,          "",       dfUserFormat2,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,     70,    daCenter,  true,    "sFmtSTime",    false,          "",       dfUserFormat2,    0,     false,       true);


                    // Hidden Fields
                    InitDataProperty(0, cnt++, dtHidden,   70,    daCenter,  true,    "sTTime",       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtHidden,   70,    daCenter,  true,    "sSTime",       false,          "",       dfNone,    0,     false,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol1",        false,          "",       dfNone,  0,     false,      true);
	   				InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod1",        false,          "",       dfNone, 	0,     false,      true);
	                  
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sDir1",        false,          "",       dfNone,  0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sFdrFlg1",     false,          "",       dfNone,   0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol2",        false,          "",       dfNone,  0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod2",        false,          "",       dfNone, 	0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sDir2",        false,          "",       dfNone,  0,     false,      true);

	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sFdrFlg2",     false,          "",       dfNone,   0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol3",        false,          "",       dfNone,  0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod3",        false,          "",       dfNone, 	0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sDir3",        false,          "",       dfNone,  0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sFdrFlg3",     false,          "",       dfNone,   0,     false,      true);

	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol4",        false,          "",       dfNone,  0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod4",        false,          "",       dfNone, 	0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sDir4",        false,          "",       dfNone,  0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sFdrFlg4",     false,          "",       dfNone,   0,     false,      true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sTT1",         false,          "",       dfNone,   0,     true,       true);

	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sTT2",         false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sTT3",         false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sTT4",         false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sST1",         false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sST2",         false,          "",       dfNone,   0,     true,       true);
	                
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sST3",         false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sTsInd",       false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod1Etb",     false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol2Etb",     false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod2Etb",     false,          "",       dfNone,   0,     true,       true);

	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol3Etb",     false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPod3Etb",     false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sPol4Etb",     false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sLnkCnt",      false,          "",       dfNone,  0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sFdrUsd",      false,          "",       dfNone,  0,     true,       true);
	                
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sTgExist",     false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sDoubtFlg",    false,          "",       dfNone,   0,     true,       true);
	                InitDataProperty(0, cnt++, dtHidden,   20,    daCenter,  true,    "sDupAllow",    false,          "",       dfNone,   0,     true,       true);
	                 
	                RangeBackColor(1, 5, 1, 13) = RgbColor(222, 251, 248);   // alps
	                InitUserFormat2(0, "sFmtTTime", "##D-##H", "D|-|H" );
	                InitUserFormat2(0, "sFmtSTime", "##D-##H", "D|-|H" );
	                InitComboNoMatchText(true);
	                
	                InitDataCombo (0, "sRouteFlg", " |Guide|Standard|Temporary|Validation", " |G|S|T|V");   // 20090317
		            InitDataCombo (0, "sRmk", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others");   // 20090317
		            InitDataCombo (0, "sPrior", " |1|2|3|4|5|6|7|8|9|10", " |1|2|3|4|5|6|7|8|9|10");
		            
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
           		ComOpenWait(true);
           		formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESD_PRD_0032GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;

        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


  function doSetValue(sheetObj,formObj){
    var openerSheet = opener.document.sheet1 ;
    
    if(!otherFlagChk(sheetObj)){                	
        ComShowMessage(ComGetMsg('PRD90124'));
        return;            
    } 

    if(sheetObj.CheckedRows("sChk")>0) {
      var checkedRow = sheetObj.FindCheckedRow("sChk");
      var arrRow     = checkedRow.split("|");
      for(i=0;i<arrRow.length-1;i++){
    	  if(sheetObj.CellValue(arrRow[i], "sDoubtFlg") == "Y"){
            if(!CONFIRM(ComGetMsg('PRD90053'))){
                continue;
            } else {
                sheetObj.CellValue2( arrRow[i] , "sDupAllow" ) = "Y";
            }
    	  }
        
        var iRow = openerSheet.DataInsert(-1);
        var insertRow = arrRow[i];
        if(insertRow=='') break;
               
        // 내려준 데이터는 수정을 못하게 한다. 
        openerSheet.RowEditable(iRow) = false;
        
        openerSheet.CellValue2( iRow, "s_seq"        ) = "";
        openerSheet.CellValue2( iRow, "s_del"        ) = "";
        openerSheet.RowStatus(iRow) = "I";
        openerSheet.CellValue2( iRow, "s_pol"        ) = sheetObj.CellValue( insertRow , "sPol");
        openerSheet.CellValue2( iRow, "s_lane"       ) = sheetObj.CellValue( insertRow , "sLane");
        openerSheet.CellValue2( iRow, "s_svc_type"    ) = sheetObj.CellValue( insertRow , "sLaneTp");//aaaaaaa
        openerSheet.CellValue2( iRow, "s_ts1_port"    ) = sheetObj.CellValue( insertRow , "sTS1Port");
        openerSheet.CellValue2( iRow, "s_ts1_lane"    ) = sheetObj.CellValue( insertRow , "sTs1Lane"); //sTs1Lane
        openerSheet.CellValue2( iRow, "s_ts1_type"    ) = sheetObj.CellValue( insertRow , "sTs1LaneTp"); //bbbbbbbb
        openerSheet.CellValue2( iRow, "s_ts2_port"    ) = sheetObj.CellValue( insertRow , "sTs2Port");
        openerSheet.CellValue2( iRow, "s_ts2_lane"    ) = sheetObj.CellValue( insertRow , "sTs2Lane");
        openerSheet.CellValue2( iRow, "s_ts2_type"    ) = sheetObj.CellValue( insertRow , "sTs2LaneTp"); //ccccccc

        openerSheet.CellValue2( iRow, "s_ts3_port"    ) = sheetObj.CellValue( insertRow , "sTs3Port");
        openerSheet.CellValue2( iRow, "s_ts3_lane"    ) = sheetObj.CellValue( insertRow , "sTs3Lane");
        openerSheet.CellValue2( iRow, "s_ts3_type"    ) = sheetObj.CellValue( insertRow , "sTs3LaneTp"); //ccccccc
        openerSheet.CellValue2( iRow, "s_fmt_t_time"      ) = sheetObj.CellValue( insertRow , "sFmtTTime");
        openerSheet.CellValue2( iRow, "s_fmt_s_time"      ) = sheetObj.CellValue( insertRow , "sFmtSTime");
        
        openerSheet.CellValue2( iRow, "s_route_flg") = sheetObj.CellValue( insertRow , "sRouteFlg");
        
        //hidden
        openerSheet.CellValue2( iRow, "s_pod"        ) = sheetObj.CellValue( insertRow , "sPod");
        openerSheet.CellValue2( iRow, "s_t_time"      ) = sheetObj.CellValue( insertRow , "sTTime");
        openerSheet.CellValue2( iRow, "s_s_time"      ) = sheetObj.CellValue( insertRow , "sSTime");
        openerSheet.CellValue2( iRow, "s_prior"      ) = sheetObj.CellValue( insertRow , "sPrior");
        openerSheet.CellValue2( iRow, "s_f_u"         ) = sheetObj.CellValue( insertRow , "sFdrUsd");
        openerSheet.CellValue2( iRow, "s_c_date"      ) = "";
        openerSheet.CellValue2( iRow, "s_rout_seq"         ) = "";
        openerSheet.CellValue2( iRow, "s_pol1"            ) = sheetObj.CellValue( insertRow , "sPol1"     );
        openerSheet.CellValue2( iRow, "s_pod1"            ) = sheetObj.CellValue( insertRow , "sPod1"     );
        
        openerSheet.CellValue2( iRow, "s_dir1"            ) = sheetObj.CellValue( insertRow , "sDir1"     );
        openerSheet.CellValue2( iRow, "s_fdr_flg1"         ) = sheetObj.CellValue( insertRow , "sFdrFlg1"  );
        openerSheet.CellValue2( iRow, "s_pol2"            ) = sheetObj.CellValue( insertRow , "sPol2"     );
        openerSheet.CellValue2( iRow, "s_pod2"            ) = sheetObj.CellValue( insertRow , "sPod2"     );

        openerSheet.CellValue2( iRow, "s_dir2"            ) = sheetObj.CellValue( insertRow , "sDir2"     );
        openerSheet.CellValue2( iRow, "s_fdr_flg2"         ) = sheetObj.CellValue( insertRow , "sFdrFlg2"  );
        openerSheet.CellValue2( iRow, "s_pol3"            ) = sheetObj.CellValue( insertRow , "sPol3"     );
        openerSheet.CellValue2( iRow, "s_pod3"            ) = sheetObj.CellValue( insertRow , "sPod3"     );
        
        openerSheet.CellValue2( iRow, "s_dir3"            ) = sheetObj.CellValue( insertRow , "sDir3"     );
        openerSheet.CellValue2( iRow, "s_fdr_flg3"         ) = sheetObj.CellValue( insertRow , "sFdrFlg3"  );
        openerSheet.CellValue2( iRow, "s_pol4"            ) = sheetObj.CellValue( insertRow , "sPol4"     );
        openerSheet.CellValue2( iRow, "s_pod4"            ) = sheetObj.CellValue( insertRow , "sPod4"     );
        
        openerSheet.CellValue2( iRow, "s_dir4"            ) = sheetObj.CellValue( insertRow , "sDir4"     );
        openerSheet.CellValue2( iRow, "s_fdr_flg4"         ) = sheetObj.CellValue( insertRow , "sFdrFlg4"  );
        openerSheet.CellValue2( iRow, "s_route_rmk"             ) = sheetObj.CellValue( insertRow , "sRmk"  );
        openerSheet.CellValue2( iRow, "s_route_note"             ) = sheetObj.CellValue( insertRow , "s_route_note"  );
        // temp 일 경우 s_ocn_rout_tmp_exp_dt 를 한달로 강제 셋팅해준다. 
        if(sheetObj.CellValue(insertRow, "sRouteFlg") == "T" ) { 
        	openerSheet.CellValue2(iRow, "s_ocn_rout_tmp_exp_dt") =ComGetDateAdd(null, "D", 30);
        	openerSheet.CellValue2(iRow, "s_ocn_rout_tmp_flg")='Y';  //jsy
        }else if(sheetObj.CellValue(insertRow, "sRouteFlg") != "T"){ //201507 PHR T 이외의 flag는 tmp_flg 컬럼'N' 처리
        	openerSheet.CellValue2(iRow, "s_ocn_rout_tmp_flg")='N'; 
        }
        
        openerSheet.CellValue2( iRow, "s_n1st_tztm_hrs"     ) = sheetObj.CellValue( insertRow , "sTT1"      );
        openerSheet.CellValue2( iRow, "s_n2nd_tztm_hrs"     ) = sheetObj.CellValue( insertRow , "sTT2"      );
        openerSheet.CellValue2( iRow, "s_n3rd_tztm_hrs"     ) = sheetObj.CellValue( insertRow , "sTT3"      );
        openerSheet.CellValue2( iRow, "s_n4th_tztm_hrs"     ) = sheetObj.CellValue( insertRow , "sTT4"      );
        openerSheet.CellValue2( iRow, "s_n1st_stay_tm_hrs"   ) = sheetObj.CellValue( insertRow , "sST1"      );
        openerSheet.CellValue2( iRow, "s_n2nd_stay_tm_hrs"   ) = sheetObj.CellValue( insertRow , "sST2"      );
        openerSheet.CellValue2( iRow, "s_n3rd_stay_tm_hrs"   ) = sheetObj.CellValue( insertRow , "sST3"      );
        openerSheet.CellValue2( iRow, "s_ts_ind_cd"         ) = sheetObj.CellValue( insertRow , "sTsInd"    );
        openerSheet.CellValue2( iRow, "s_pod1_etb"         ) = sheetObj.CellValue( insertRow , "sPod1Etb"  );
        openerSheet.CellValue2( iRow, "s_pol2_etb"         ) = sheetObj.CellValue( insertRow , "sPol2Etb"  );
        openerSheet.CellValue2( iRow, "s_pod2_etb"         ) = sheetObj.CellValue( insertRow , "sPod2Etb"  );
        openerSheet.CellValue2( iRow, "s_pol3_etb"         ) = sheetObj.CellValue( insertRow , "sPol3Etb"  );
        openerSheet.CellValue2( iRow, "s_pod3_etb"         ) = sheetObj.CellValue( insertRow , "sPod3Etb"  );
        openerSheet.CellValue2( iRow, "s_pol4_etb"         ) = sheetObj.CellValue( insertRow , "sPol4Etb"  );
        openerSheet.CellValue2( iRow, "s_lnk_cnt"          ) = sheetObj.CellValue( insertRow , "sLnkCnt"   );
        openerSheet.CellValue2( iRow, "s_upd_ind_cd"        ) = "";
        openerSheet.CellValue2( iRow, "s_dup_allow"        ) = sheetObj.CellValue( insertRow , "sDupAllow" );

      }
      
      opener.ocnRoutSave();
    }

  }
  
  
  /**
   * OK 버튼 클릭 전에 Type이 The Ohter이면서 Note가 null 인 경우 Message 처리
   * @return
   */
  function otherFlagChk(sheetObj){
  	i = 0;
  	
  	for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){  		
  	    // Priority Check    	        	    
          if(  (sheetObj.CellValue(i, "sRmk") == "The Others" ) && ( ComTrim(sheetObj.CellValue(i, "s_route_note")) == "") ){                          
              return false;
          }                
      }
      return true;
  }
  
  // Duplication Route check - Doubt Route 인 경우, Warning Message 띄워줌.
  // Not Used 인 경우 Warning Message 없이 Temporary로 Update
  function sheet1_OnChange(sheetObj, Row, Col, Val) {
     sheetObj.ShowDebugMsg = false;
    if(sheetObj.CellValue(Row, "sRouteFlg") == "T" ) { // && sheetObj.CellValue(Row, "sRmk") == "The Others") { //jsy 201301
    	sheetObj.CellEditable(Row, "s_route_note") = true;
    } else {
    	sheetObj.CellEditable(Row, "s_route_note") = false;
    }
      
    if( sheetObj.ColSaveName(Col) == "sRouteFlg" && Val == "T") {
        ComShowMessage("Please select a type of temp flag.");

        sheetObj.SelectCell(Row, "sRmk");
        sheetObj.CellValue2(Row, "sRmk")='Space Shortage';
        sheetObj.CellValue2(Row, "s_route_note")='';  
    } 
    else if(sheetObj.ColSaveName(Col) == "sRouteFlg" && Val != "T") {
        sheetObj.CellValue2(Row, "sRmk")='';  
        sheetObj.CellValue2(Row, "s_route_note")=''; 
    }
    
    if(sheetObj.CellValue(Row, "sRouteFlg") == "V" ) {  // 201507 PHR validation flag 선택 불가 팝업 추가
        ComShowMessage(ComGetMsg('PRD90104','Validation'));
        sheetObj.CellValue2(Row,"sRouteFlg") = 'S'; 
    }
//jsy 201301 -------------------    
//    else if(sheetObj.ColSaveName(Col) == "sRmk" && Val != "The Others") {
//    	sheetObj.CellValue2(Row, "s_route_note")='';     	
//    }
//    else if(sheetObj.ColSaveName(Col) == "s_route_note" && Val != " ") { 
//    	if(sheetObj.CellValue(Row, "sRmk") != "The Others") {        	
//    		sheetObj.CellValue2(Row, "s_route_note")='';
//    	}
//    }
    
    
    // S 일때 DROP BOX에서 SELECT 하면 못하게 처리 
    var idx   = sheetObj.GetComboInfo(Row, "sRmk", "SelectedIndex");
    if(  (sheetObj.CellValue(Row, "sRouteFlg") != "T" ) &&   (sheetObj.ColSaveName(Col) == "sRmk") && idx >0){

        sheetObj.CellValue2(Row, "sRmk")=' '; 
        ComShowMessage(ComGetMsg('PRD90103'));
    }  	    
    if(  (sheetObj.CellValue(Row, "sRouteFlg") == "T" ) &&  (sheetObj.ColSaveName(Col) == "sRmk") && idx < 1){
    
        sheetObj.SelectCell(Row, "sRmk");
        sheetObj.CellValue2(Row, "sRmk")='Space Shortage';
        ComShowMessage(ComGetMsg('PRD90102'));
        
    }      
             
    if( sheetObj.ColSaveName(Col) == "sChk") {
    	if(Val == "1"){
            sheetObj.DoRowSearch("ESD_PRD_0032_ROW_GS.do", "f_cmd="+SEARCH11+"&org_loc_cd="+sheetObj.CellValue(Row, "sPol") +"&dest_loc_cd="+sheetObj.CellValue(Row, "sPod") 
                                                     +"&n1st_pol_cd="+sheetObj.CellValue(Row,"sPol1") + "&n1st_pod_cd="+sheetObj.CellValue(Row, "sPod1")+ "&n1st_lane_cd="+sheetObj.CellValue(Row, "sLane")
                                                     +"&n2nd_pol_cd="+sheetObj.CellValue(Row,"sPol2") + "&n2nd_pod_cd="+sheetObj.CellValue(Row, "sPod2")+ "&n2nd_lane_cd="+sheetObj.CellValue(Row, "sTs1Lane")
                                                     +"&n3rd_pol_cd="+sheetObj.CellValue(Row,"sPol3") + "&n3rd_pod_cd="+sheetObj.CellValue(Row, "sPod3")+ "&n3rd_lane_cd="+sheetObj.CellValue(Row, "sTs2Lane")
                                                     +"&n4th_pol_cd="+sheetObj.CellValue(Row,"sTs3Port") + "&n4th_pod_cd="+sheetObj.CellValue(Row, "sPod4")+ "&n4th_lane_cd="+sheetObj.CellValue(Row, "sTs3Lane")
                                                     +"&row="+Row+"&col="+Col );

            if(sheetObj.EtcData("rowCount")==0) {
        	    sheetObj.CellValue2(Row,"sDoubtFlg")="";
        	    sheetObj.CellValue2(Row,"sDupAllow")="";
        	} 
        	
        } else {
             sheetObj.CellValue2(Row, "sChk") = "0";
             sheetObj.CellValue2(Row, "sDupAllow") = "";
        }
    }
     
}

function CONFIRM(msg1)
{
	msg1 = "\n" +
       "────────────────────────────────     \n\n" +
       "\n" +
       "" + msg1 + "\n" +
       "\n" +
       "\n────────────────────────────────     \n" +
       "If you click 'Cancel' button, this route can't be created.";
	return confirm(msg1);
}

/**
 * 
 * @return
 */
function sheet1_OnLoadFinish() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}