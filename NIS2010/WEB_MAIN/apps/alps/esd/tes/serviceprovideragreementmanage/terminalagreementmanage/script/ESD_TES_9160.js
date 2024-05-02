/*--==============================================================================
'주  시 스 템 : ESD_TES_9160.jsp
'서브  시스템 : 자바스크립트
'프로그램 ID  : ESD_TES_9160.js
'프로그램 명  : Terminal Excel List Load 및 부모창으로 데이터 전송 처리
'프로그램개요 : Terminal Excel List Load 및 부모창으로 데이터 전송 처리
'작   성   자 :
'작   성   일 :
* 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
==================================================================================
==============================================================================--*/


// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var sheetErrCount = 0;

var	arrCntrTpSz	= ["d2", "d4", "d5", "d7", "d8", "d9", "dw", "dx"
   	    		, "r2", "r4", "r5", "r7", "r8", "r9"
   	    		, "f2", "f4", "f5"
   	    		, "o2", "o4", "o5", "o7"
   	    		, "s2", "s4"
   	    		, "t2", "t4"
   	    		, "a2", "a4", "a5"
   	    		, "p2", "p4"
   	    		, "c2", "c4"];

/** 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_loadexcel":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break;

				case "btn_verify":
					var k = sheetObjects[0].RowCount;
					var err_count = 0;
					var dupRowCount  = 0;
					if(k==0){
						ComShowCodeMessage('TES10087');
						return false;
					}
										
					var dupRowInfo = sheetObjects[0].ColValueDupRows("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28", false, true);

					if(dupRowInfo != ""){
						var dupRow = dupRowInfo.split("|");
						var dupRowNum = dupRow[1].split(",");
						if(dupRowNum.length > 0){

							for(var i=0 ; i<dupRowNum.length ;i++){
								if(sheetObjects[0].CellValue(dupRowNum[i],"3auto_calc_flg")=="Y"){
									sheetObjects[0].RowBackColor(dupRowNum[i]) = sheetObjects[0].RgbColor(255,0,0);
									dupRowCount++;
								}
                       	     }

							if(dupRowCount>0){
								ComShowCodeMessage('TES10119',dupRowCount);     //'총'+msg1+'개의 중복 Row가 있습니다. 다시확인하세요.'
								return false;
							}
						}
					}
					
					doActionIBSheet1(sheetObject1,formObject,IBSEARCH);
					
					if(sheetErrCount==0){
						for(var i=1 ; i<=k ;i++){
							
							if (ComIsNull(sheetObjects[0].CellValue(i+2, '3lgs_cost_cd'))){
								sheetObjects[0].CellBackColor(i+2,'3lgs_cost_cd') = sheetObjects[0].RgbColor(255,0,0);
								err_count++;
							}else{
								sheetObjects[0].CellBackColor(i+2,'3lgs_cost_cd') = sheetObjects[0].RgbColor(0,0,0);
							}
							
							if (ComIsNull(sheetObjects[0].CellValue(i+2, '3auto_calc_flg'))){
								sheetObjects[0].CellBackColor(i+2,'3auto_calc_flg') = sheetObjects[0].RgbColor(255,0,0);
								err_count++;
							}
							if (ComIsNull(sheetObjects[0].CellValue(i+2, '3tml_agmt_vol_ut_cd'))){
								sheetObjects[0].CellBackColor(i+2,'3tml_agmt_vol_ut_cd') = sheetObjects[0].RgbColor(255,0,0);
								err_count++;
							}
							
							if (ComIsNull(sheetObjects[0].CellValue(i+2, '3curr_cd'))){
								sheetObjects[0].CellBackColor(i+2,'3curr_cd') = sheetObjects[0].RgbColor(255,0,0);
								err_count++;
							}
						}
					}
					
					
					if(sheetErrCount > 0 || err_count>0)
					{							
						ComShowCodeMessage('TES10088');    //시트를 수정해 주세요.
						sheetErrCount  =0;
						return false;
					} else if(sheetErrCount == 0 && err_count == 0) {						
						var opener_sheet_obj = window.dialogArguments.document.t2sheet1;
						var appendFlg = "";						
						
						if(opener_sheet_obj.RowCount == 0){							
							ComShowCodeMessage('TES10089');    //Verify가 완료되고 AGMT에 List Up 됩니다.
							appendFlg =true;
						}else if(opener_sheet_obj.RowCount > 0) {							
							appendFlg = ComShowConfirm(ComGetMsg('TES10120'));   //Verify가 완료되었습니다.현재 Terminal Agreement Rate List 존재합니다.기존 Rate List 추가시 확인, Update시 취소를 클릭하세요
						}						
						for(var i=0;i<sheetObjects[0].RowCount;i++){							
							if(sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase() == "IB" || sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase() == "OB" || sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase() == "SAME" ){
                                sheetObjects[0].CellValue2(i+3,"3io_bnd_cd") = sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase();
								
								if(sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase()  == "IB"){
									sheetObjects[0].CellValue2(i+3,"3io_bnd_cd")  = "I";
								}else if(sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase()  == "OB"){
									sheetObjects[0].CellValue2(i+3,"3io_bnd_cd")  = "O";
								}else if(sheetObjects[0].CellValue(i+3,"3io_bnd_cd").toUpperCase()  == "SAME"){
									sheetObjects[0].CellValue2(i+3,"3io_bnd_cd")  = "S";
								}
							}else{
								sheetObjects[0].CellValue(i+3,"3io_bnd_cd") = "";
							}
							
							if(sheetObjects[0].CellValue(i+3,"3ioc_cd").toUpperCase() == "IPC" || sheetObjects[0].CellValue(i+3,"3ioc_cd").toUpperCase() == "OCN" || sheetObjects[0].CellValue(i+3,"3ioc_cd").toUpperCase() == "SAME" ){
								sheetObjects[0].CellValue2(i+3,"3ioc_cd") = sheetObjects[0].CellValue(i+3, "3ioc_cd").toUpperCase();
								if(sheetObjects[0].CellValue(i+3,"3ioc_cd").toUpperCase() == "IPC"){
									sheetObjects[0].CellValue2(i+3,"3ioc_cd")  = "I";
								}else if(sheetObjects[0].CellValue(i+3,"3ioc_cd").toUpperCase() == "OCN"){
									sheetObjects[0].CellValue2(i+3,"3ioc_cd")  = "O";
								}else if(sheetObjects[0].CellValue(i+3,"3ioc_cd").toUpperCase() == "SAME"){
									sheetObjects[0].CellValue2(i+3,"3ioc_cd")  = "S";
								}								
							}else{
								sheetObjects[0].CellValue2(i+3,"3ioc_cd") = "";
							}

							if(sheetObjects[0].CellValue(i+3,"3lane_cd").toUpperCase() == "SAME"){
								sheetObjects[0].CellValue2(i+3,"3lane_cd") = "Sam";
							}else if(sheetObjects[0].CellValue(i+3,"3lane_cd").toUpperCase() == "OTH"){
								sheetObjects[0].CellValue2(i+3,"3lane_cd") = "OTH";
							}else if(sheetObjects[0].CellValue(i+3,"3lane_cd").toUpperCase() != ""){
								sheetObjects[0].CellValue2(i+3,"3lane_cd") = sheetObjects[0].CellValue(i+3,"3lane_cd").toUpperCase();
							}							

							if(sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "SAME" || sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "S"){
								sheetObjects[0].CellValue2(i+3,"3tml_trns_mod_cd") = "S";
							}else if(sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "TRUCK" || sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "T"){
								sheetObjects[0].CellValue2(i+3,"3tml_trns_mod_cd") = "T";
							}else if(sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "RAIL" || sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "R"){
								sheetObjects[0].CellValue2(i+3,"3tml_trns_mod_cd") = "R";
							}else if(sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "BARGE" || sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "B"){
								sheetObjects[0].CellValue2(i+3,"3tml_trns_mod_cd") = "B";
							}else if(sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "FEEDER" || sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "F"){
								sheetObjects[0].CellValue2(i+3,"3tml_trns_mod_cd") = "F";
							}else if(sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "MOTHER" || sheetObjects[0].CellValue(i+3,"3tml_trns_mod_cd").toUpperCase() == "V"){
								sheetObjects[0].CellValue2(i+3,"3tml_trns_mod_cd") = "V";
							}
						}						

						
						//setDtaCurrSht2OprSht(sheetObjects[0], sheetObjects[2]);
						if(appendFlg == true) {
							setDtaCurrSht2OprSht1(sheetObjects[0],'');
						}else if(appendFlg == false) {
							opener_sheet_obj.RemoveAll();
							setDtaCurrSht2OprSht1(sheetObjects[0],'');
						}												

						window.close();
						sheetErrCount  =0;
					}
					break;

				case "btn_close":
					window.close();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
				ComShowMessage (e);
			}
		}
	}

    /**
     * IBSheet Object를 배열로 등록.<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다.<br>
     * 배열은 소스 상단에 정의.<br>
     * @param{ibsheet}	sheet_obj	Sheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화.<br>
     * body 태그의 onLoad 이벤트핸들러 구현.<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다.<br>
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의.<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호.<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다.<br>
     * @param{ibsheet}		sheetObj	Sheet Object
     * @param{int,String}	sheetNo		Sheet No
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 300;
                    var sheetNo = 3;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(76, 2, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)
                	
                	// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    var HeadTitle0 = "Cost Code|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "Applied Date|Applied Date|Applied Date|Applied Date|Lane|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|"
                    + "Tier Vol.|Tier Vol.|OT\nShift|THC|Volume \nUOM|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|"
                    + "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle1 = "Cost Code|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "WD|Sat|Sun|H/D|Lane|Same for all DG|Same for all DG|"
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "Fr|To|OT\nShift|THC|Volume \nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle2 = "Cost Code|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "WD|Sat|Sun|H/D|Lane|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "Fr|To|OT\nShift|THC|Volume \nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Verify\nResult|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, 											KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,    sheetNo +"lgs_cost_cd",     	false,          "",       dfNone,   		0,     false,    	false);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"auto_calc_flg",     	false,          "",       dfNone,   		0,     true,      true);                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"curr_cd",     		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    sheetNo +"thrp_lgs_cost_cd",  	false,          "",       dfNone,   		0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"io_bnd_cd",    		false,          "",       dfNone,   		0,     true,      true,4);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"ioc_cd",    			false,          "",       dfNone,   		0,     true,      true,4);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"tml_trns_mod_cd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"wkdy_flg",     		false,          "",       dfNone,       0,     true,      true);                    
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"sat_flg",     		false,          "",       dfNone,   		0,     true,      true);				//8
                    
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"sun_flg",     		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"hol_flg",     		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"lane_cd",     		false,          "",       dfNone,   		0,     true,      true,4);                   
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"same_dg_none",     	false,          "",       dfNone,       0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"same_dg",     		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    sheetNo +"sep_dg_none",     	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n1st_clss_flg", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n2nd_clss_flg", false,          "",       dfNone,   		0,     true,      true);                 
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n3rd_clss_flg", false,          "",       dfNone,       0,     true,      true);					//17
                    
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n4th_clss_flg", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n5th_clss_flg", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n6th_clss_flg", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n7th_clss_flg", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n8th_clss_flg", false,          "",       dfNone,       0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n9th_clss_flg", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"fm_tr_vol_val",     	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"to_tr_vol_val",     	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    sheetNo +"tml_ovt_shft_cd",    false,          "",       dfNone,   		0,     true,      true,1);                    
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"thc_tp_cd",     		false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    sheetNo +"tml_agmt_vol_ut_cd",	false,          "",       dfNone,   		0,     true,      true);				//28
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d2",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d4",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d5",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d7",     			false,          "",       dfFloat,      2,     true,      true);                                                                                                                                                                2
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d8",     			false,          "",       dfFloat,      2,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d9",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"dw",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"dx",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r2",     			false,          "",       dfFloat,      2,     true,      true);                                                                                                                                			                                              2
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r4",     			false,          "",       dfFloat,      2,     true,      true);					//38
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r5",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r7",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r8",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r9",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"f2",     			false,          "",       dfFloat,      2,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"f4",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"f5",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o2",     			false,          "",       dfFloat,      2,     true,      true);                                                                                                            			                                              2
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o4",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o5",     			false,          "",       dfFloat,      2,     true,      true);					//48
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o7",     			false,          "",       dfFloat,      2,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"s2",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"s4",     			false,          "",       dfFloat,      2,     true,      true);                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"t2",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"t4",     			false,          "",       dfFloat,      2,     true,      true);                                                                                                            			                                              2
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"a2",     			false,          "",       dfFloat,      2,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"a4",     			false,          "",       dfFloat,      2,     true,      true);  
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"a5",     			false,          "",       dfFloat,      2,     true,      true);  
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"p2",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"p4",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"c2",     			false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"c4",     			false,          "",       dfFloat,      2,     true,      true);					//58
                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"teu_rate",     		false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"box_rate",     		false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"move_rate",     		false,          "",       dfFloat,      2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    sheetNo +"gang_hour_rate",	false,          "",       dfFloat,    	2,     true,      true);                    //62
                    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    sheetNo +"ton_rate",     		false,          "",       dfFloat,    	2,     true,      true);                    
                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"verify_result"		, false,          "",       dfNone,   		0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopup,      70,    daCenter,  true,    sheetNo +"agmt_dtl_rmk",     	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"tml_dy_aply_tp_cd",  false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"dcgo_aply_tp_cd",    false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"tml_vol_aply_tp_cd", false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"ts_rt",     			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"tml_agmt_dtl_seq",   false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"vrfyFlg",     		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,   daCenter,  true,    sheetNo +"ibflag" );
                    InitDataProperty(0, cnt++ , dtHidden,      1,     daCenter,  true,    sheetNo +"dg_none",     		false,          "",       dfNone,   		0,     true,      true);


                    RangeBackColor(1, 7, 1, 13) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(2, 13, 2, 27) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 25, 1, 56) = RgbColor(222, 251, 248);   // ENIS

                    InitDataCombo( 0 , sheetNo +"lgs_cost_cd" , window.dialogArguments.lgsCostCDSheet, window.dialogArguments.lgsCostCDSheet);
                    InitDataCombo( 0 , sheetNo +"auto_calc_flg" , "Y|N","Y|N");
                    InitDataCombo( 0 , sheetNo +"tml_agmt_vol_ut_cd" , vol_ut_cdCode, vol_ut_cdCode);
                    //InitDataCombo( 0 , sheetNo +"io_bnd_cd" , io_bnd_codeText, io_bnd_codeCode);
                    //InitDataCombo( 0 , sheetNo +"ioc_cd" , ioc_codeText, ioc_codeCode);
                    InitDataCombo( 0 , sheetNo +"thc_tp_cd" , thc_tp_codeText, thc_tp_codeCode);
                    //InitDataCombo( 0 , sheetNo +"tml_ovt_shft_cd" , tml_ovt_shft_codeCode, tml_ovt_shft_codeCode);
                    InitDataCombo( 0 , sheetNo +"wkdy_flg" 			     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"sat_flg" 			     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"sun_flg" 			     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"hol_flg" 			     , " |Y"," |Y");
                    //InitDataCombo( 0 , sheetNo +"dg_none" 			     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_none" 	     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg" 			     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"sep_dg_none" 	     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n1st_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n2nd_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n3rd_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n4th_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n5th_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n6th_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n8th_clss_flg" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n9th_clss_flg" , " |Y"," |Y");

                    InitDataValid(0, sheetNo+"tml_ovt_shft_cd", vtEngUpOnly);
                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";

                    HeadRowHeight  = 21;
                    HeadRowHeight  = 20;

                    style.height=GetSheetHeight(10);
               }
                break;
             case 2:   //t2sheet1 init
                with (sheetObj) {

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "cost_cd|vrfy";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     30,    daCenter,  true,     "lgs_cost_cd",     false,          "",       dfNone,          0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daLeft,    true,     "vrfy_string",     false,          "",       dfNone,          0,     true,      true,1);

                    CountPosition = 0 ;
                    style.height=GetSheetHeight(4);
                }
                break;
        }
    }



	/**
	 * Sheet관련 프로세스 처리. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {String}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBLOADEXCEL:      //엑셀 올리기
				sheetObj.LoadExcel(false,1,"",116,-1);
				break;
		}
	}

 	/**
 	 * Sheet관련 프로세스 처리. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {String}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
 	 */
	function doActionIBSheet1(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:
				formObj.f_cmd.value = SEARCH;
				var param = sheetObjects[0].GetSaveString(false,false);
				var sXml = sheetObjects[1].GetSearchXml("ESD_TES_9160GS.do", param + '&' + tesFrmQryStr(formObj), "", true);
				sheetObjects[1].LoadSearchXml(sXml);
				break;
		}
	}


    
	/**
	 * popup창의 sheet data를 opener의 특정 sheet로 넘기기 -> 단 동일한 saveName만 해당. <br>
	 * 사용되지 않음 ( 2009-09-23 )
	 * @param {ibsheet}  	ip_sht_obj		현재창의 input sheet 객체
	 * @param {String}  	opr_sht_nm_str	opener의 대상 sheet명
	 */
    function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {

	/*
		(인자: 현재창의 input sheet 객체, opener의 대상 sheet명)
		popup창의 sheet data를 opener의 특정 sheet로 넘기기 -> 단 동일한 saveName만 해당
	*/

    	var formObj = document.form;
    	var opener_obj = window.dialogArguments;
    	var opener_sheet_obj =  opener_obj.document.t2sheet1;
    	var sheetObject = ip_sht_obj;
	//opener_sheet_obj.RemoveAll();

    	for (i=3; i<sheetObject.Rows; i++) //제목은 제외
		{

    		var iRow = opener_sheet_obj.DataInsert(-1);
    		for(j = 0; j <= sheetObject.LastCol; j++)
    		{
    			if (sheetObject.ColSaveName(j) != "")
    			{   // 현재 SaveName이 없는것들을 걸러내기위한조건
    				for(k = 0; k <= opener_sheet_obj.LastCol; k++)
    				{
    					if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j))
    					{
    						opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(k)) = sheetObject.CellValue(i, sheetObject.ColSaveName(j)) ;

    						if( sheetObject.CellValue(i, '3wkdy_flg')	== "Y" &&
    							sheetObject.CellValue(i, '3sat_flg')	== "Y" &&
    							sheetObject.CellValue(i, '3sun_flg')	== "Y" &&
    							sheetObject.CellValue(i, '3hol_flg')	== "Y" ){
    							opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(61)) = "P";
    						} else {
    							opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(61)) = "S";
    						}

							if(sheetObject.CellValue(i, '3dg_none') == "Y"){
								opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(62)) = "N";
							} else if (sheetObject.CellValue(i, '3same_dg_none')== "Y" &&
										sheetObject.CellValue(i, '3same_dg')== "Y"){
								opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(62)) = "A";
							} else {
								opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(62)) = "S";
							}

							if(sheetObject.CellValue(i, '3fm_tr_vol_val')== "1" && 
								sheetObject.CellValue(i, '3to_tr_vol_val')=="MAX"){
								opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(63)) = "N";
							} else {
								opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(63)) = "S";
							}
    					}
    				}
				}
    		}
		}
    	opener_obj.document.form.fileImportFlg.value="Y";
    }


	/**
	 * popup창의 sheet data를 opener의 특정 sheet로 넘기기 -> 단 동일한 saveName만 해당. <br>
	 * @param {ibsheet}		sheet	IBSheet 객체
	 * @param {String}		ErrMsg	Error Message
	 */
	function setDtaCurrSht2OprSht1(sheet, ErrMsg){
		if (sheet.RowCount > 0)
		{
			var queryStr = '';
			var opr_sht_idx = 0;
			var opener_sheet_obj;

			//popup의 sheet data를 COIN에 뿌리기
			queryStr = sheet.GetSaveString(false, false, "3lgs_cost_cd");// + "&prefix=3";

			if (queryStr == null || queryStr == ''){
            //return false;
            } else {
            	opr_sht_idx = 2;
            	opener_sheet_obj = window.dialogArguments.document.t2sheet1;
              	tes_agmt_copy_rows_to(sheet, opener_sheet_obj, "", true, true, "3");
            }

            window.dialogArguments.document.form.fileImportFlg.value = "Y";
            window.close();
		}
	}

	
    /**
     * Sheet 조회후 프로세스 처리. <br>
     */
	function sheet1_OnSearchEnd(){
		var k = sheetObjects[0].RowCount + 4;
		var errCount 		= 0;
		var vrfyFlg ;
		for(var i=3;i<k;i++){
			vrfyFlg = sheetObjects[1].CellValue(i-2, 'vrfy_string').split("|");
			sheetObjects[0].CellValue2(i-2,'3vrfyFlg') = vrfyFlg;
			sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(255,255,255);

			if(sheetObjects[0].CellValue(i, '3auto_calc_flg') == "Y"){

				if(sheetObjects[0].CellValue(i, '3lgs_cost_cd') != sheetObjects[1].CellValue(i-2,0)){
					sheetObjects[0].CellBackColor(i,'3lgs_cost_cd') = sheetObjects[0].RgbColor(255,0,0);
					errCount++;
				}

				// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
				if(sheetObjects[0].CellValue(i, '3lgs_cost_cd').trim() == ""){
					sheetObjects[0].CellBackColor(i,'3lgs_cost_cd') = sheetObjects[0].RgbColor(255,0,0);
					errCount++;
				}

				if (vrfyFlg[0] != sheetObjects[0].CellValue(i, '3auto_calc_flg')){
					sheetObjects[0].CellBackColor(i,'3auto_calc_flg') = sheetObjects[0].RgbColor(255,0,0);
					errCount++;
				}

				if (vrfyFlg[2] == "Y"){
					if(sheetObjects[0].CellValue(i,'3io_bnd_cd').toUpperCase() != "IB" && 
						sheetObjects[0].CellValue2(i,'3io_bnd_cd') != "OB" && 
						sheetObjects[0].CellValue2(i,'3io_bnd_cd').toUpperCase() != "SAME"){
						sheetObjects[0].CellBackColor(i,'3io_bnd_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else if (vrfyFlg[2] == "N"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3io_bnd_cd').trim() != "" ) {
						sheetObjects[0].CellBackColor(i,'3io_bnd_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}
				
				
				if (vrfyFlg[3] == "Y"){
					if(sheetObjects[0].CellValue(i,'3ioc_cd').toUpperCase() != "IPC" && 
						sheetObjects[0].CellValue2(i,'3ioc_cd').toUpperCase() != "OCN" && 
						sheetObjects[0].CellValue2(i,'3ioc_cd').toUpperCase() != "SAME"){
						sheetObjects[0].CellBackColor(i,'3ioc_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else	if (vrfyFlg[3] == "N"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3ioc_cd').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3ioc_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[4] == "Y"){
					if(sheetObjects[0].CellValue(i,'3wkdy_flg') == "" && 
						sheetObjects[0].CellValue(i,'3sat_flg') == "" && 
						sheetObjects[0].CellValue(i,'3sun_flg') == "" && 
						sheetObjects[0].CellValue(i,'3hol_flg') == "" ){
						sheetObjects[0].CellBackColor(i,'3wkdy_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3sat_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3sun_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3hol_flg') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else	if (vrfyFlg[4] == "N"){
					if(sheetObjects[0].CellValue(i,'3wkdy_flg') != "" || 
						sheetObjects[0].CellValue(i,'3sat_flg') != "" || 
						sheetObjects[0].CellValue(i,'3sun_flg') != "" || 
						sheetObjects[0].CellValue(i,'3hol_flg') != "" ){
						sheetObjects[0].CellBackColor(i,'3wkdy_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3sat_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3sun_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3hol_flg') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[5] == "Y"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3lane_cd').trim() == "" ){
						sheetObjects[0].CellBackColor(i,'3lane_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else if (vrfyFlg[5] == "N"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3lane_cd').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3lane_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[6] == "Y"){
					//[CHM-201539189]DG(NONE) 숨김처리로 값을 입력안하면 NONE DG를 선택한 것으로 본다.(CAH D 2015-12-30)
					if( sheetObjects[0].CellValue(i,'3dg_none').trim() == ""
						&& sheetObjects[0].CellValue(i,'3same_dg_none').trim() == ""
						&& sheetObjects[0].CellValue(i,'3same_dg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3sep_dg_none').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n1st_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n2nd_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n3rd_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n4th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n5th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n6th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n7th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n8th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n9th_clss_flg').trim() == "" ){
						sheetObjects[0].CellValue(i,'3dg_none').trim() = "Y";
					}
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if( sheetObjects[0].CellValue(i,'3dg_none').trim() == ""
						&& sheetObjects[0].CellValue(i,'3same_dg_none').trim() == ""
						&& sheetObjects[0].CellValue(i,'3same_dg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3sep_dg_none').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n1st_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n2nd_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n3rd_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n4th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n5th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n6th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n7th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n8th_clss_flg').trim() == ""
						&& sheetObjects[0].CellValue(i,'3dcgo_n9th_clss_flg').trim() == "" ){
						sheetObjects[0].CellBackColor(i,'3dg_none') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3same_dg_none') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3same_dg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3sep_dg_none') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n1st_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n2nd_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n3rd_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n4th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n5th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n6th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n7th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n8th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n9th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else	if (vrfyFlg[6] == "N"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if( sheetObjects[0].CellValue(i,'3dg_none').trim() != ""
						|| sheetObjects[0].CellValue(i,'3same_dg_none').trim() != ""
						|| sheetObjects[0].CellValue(i,'3same_dg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3sep_dg_none').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n1st_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n2nd_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n3rd_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n4th_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n5th_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n6th_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n7th_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n8th_clss_flg').trim() != ""
						|| sheetObjects[0].CellValue(i,'3dcgo_n9th_clss_flg').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3dg_none') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3same_dg_none') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3same_dg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3sep_dg_none') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n1st_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n2nd_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n3rd_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n4th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n5th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n6th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n7th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n8th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dcgo_n9th_clss_flg') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[7] == "Y"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3fm_tr_vol_val').trim() == "" && 
						sheetObjects[0].CellValue(i,'3to_tr_vol_val').trim() == "" ){
						sheetObjects[0].CellBackColor(i,'3fm_tr_vol_val') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3to_tr_vol_val') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else if (vrfyFlg[7] == "N"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3fm_tr_vol_val').trim() != "" || 
						sheetObjects[0].CellValue(i,'3to_tr_vol_val').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3fm_tr_vol_val') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3to_tr_vol_val') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[8] == "Y"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3tml_ovt_shft_cd').trim() == "" ){
						sheetObjects[0].CellBackColor(i,'3tml_ovt_shft_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else if (vrfyFlg[8] == "N"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3tml_ovt_shft_cd').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3tml_ovt_shft_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[9] == "Y"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3thc_tp_cd').trim() == "" ){
						sheetObjects[0].CellBackColor(i,'3thc_tp_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else	if (vrfyFlg[9] != "Y"){
					// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
					if(sheetObjects[0].CellValue(i,'3thc_tp_cd').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3thc_tp_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				//rt_cntr_tpsz_flg
				if (vrfyFlg[20] == "N"){
					if(sheetObjects[0].CellValue(i,'3d2') > 0
						|| sheetObjects[0].CellValue(i,'3d2') > 0
						|| sheetObjects[0].CellValue(i,'3d4') > 0
						|| sheetObjects[0].CellValue(i,'3d5') > 0
						|| sheetObjects[0].CellValue(i,'3d7') > 0
						|| sheetObjects[0].CellValue(i,'3d8') > 0
						|| sheetObjects[0].CellValue(i,'3d9') > 0
						|| sheetObjects[0].CellValue(i,'3dw') > 0
						|| sheetObjects[0].CellValue(i,'3dx') > 0
						|| sheetObjects[0].CellValue(i,'3r4') > 0
						|| sheetObjects[0].CellValue(i,'3r5') > 0
						|| sheetObjects[0].CellValue(i,'3r7') > 0
						|| sheetObjects[0].CellValue(i,'3r8') > 0
						|| sheetObjects[0].CellValue(i,'3r9') > 0
						|| sheetObjects[0].CellValue(i,'3f2') > 0
						|| sheetObjects[0].CellValue(i,'3f4') > 0
						|| sheetObjects[0].CellValue(i,'3o2') > 0
						|| sheetObjects[0].CellValue(i,'3o4') > 0
						|| sheetObjects[0].CellValue(i,'3o5') > 0
						|| sheetObjects[0].CellValue(i,'3o7') > 0
						|| sheetObjects[0].CellValue(i,'3s2') > 0
						|| sheetObjects[0].CellValue(i,'3s4') > 0
						|| sheetObjects[0].CellValue(i,'3t2') > 0
						|| sheetObjects[0].CellValue(i,'3t4') > 0
						|| sheetObjects[0].CellValue(i,'3a2') > 0
						|| sheetObjects[0].CellValue(i,'3a4') > 0
						|| sheetObjects[0].CellValue(i,'3a5') > 0
						|| sheetObjects[0].CellValue(i,'3p2') > 0
						|| sheetObjects[0].CellValue(i,'3p4') > 0
						|| sheetObjects[0].CellValue(i,'3c2') > 0
						|| sheetObjects[0].CellValue(i,'3c4') > 0
						|| sheetObjects[0].CellValue(i,'3f5') > 0 ){

						sheetObjects[0].CellBackColor(i,'3d2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3d2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3d4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3d5') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3d7') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3d8') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3d9') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dw') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3dx') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3r4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3r5') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3r7') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3r8') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3r9') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3f2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3f4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3o2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3o4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3o5') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3o7') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3s2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3s4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3t2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3t4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3a2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3a4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3a5') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3p2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3p4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3c2') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3c4') = sheetObjects[0].RgbColor(255,0,0);
						sheetObjects[0].CellBackColor(i,'3f5') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				//rt_teu_flg
				if (vrfyFlg[21] == "N"){
					if(sheetObjects[0].CellValue(i,'3teu_rate') > 0 ){
						sheetObjects[0].CellBackColor(i,'3teu_rate') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[22] == "N"){
					if(sheetObjects[0].CellValue(i,'3box_rate') > 0 ){
						sheetObjects[0].CellBackColor(i,'3box_rate') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[23] == "N"){
					if(sheetObjects[0].CellValue(i,'3move_rate') > 0 ){
						sheetObjects[0].CellBackColor(i,'3move_rate') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				if (vrfyFlg[25] == "Y"){
					if(sheetObjects[0].CellValue(i,'3tml_trns_mod_cd').trim() == "" ){
						sheetObjects[0].CellBackColor(i,'3tml_trns_mod_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}else if(vrfyFlg[25] == "N"){
					if(sheetObjects[0].CellValue(i,'3tml_trns_mod_cd').trim() != "" ){
						sheetObjects[0].CellBackColor(i,'3tml_trns_mod_cd') = sheetObjects[0].RgbColor(255,0,0);
						errCount++;
					}
				}

				sheetErrCount  = errCount;

				vrfyFlg  = "";
			}
		}
	}


    /**
     * Sheet에 있는 Excel Load후 프로세스 처리. <br>
     * 
     */
	function sheet_OnLoadExcel(){
		var k = sheetObjects[0].RowCount+3;
		var sheetNo = 3;
		var total_rate = "";
		var i =0;
		var j =0;
		var cellNullCheckString = "";
		
		//[CHM-201642186]Upload 이후 Cost Code 또는 Cntr No이 없는 경우 해당 라인을 삭제하는 로직을 추가 2016-06-23
		delBlkRows(sheetObjects[0]);
		
		for(i = k; i>=0; i--) {
			if (sheetObjects[0].CellValue(i,'3lgs_cost_cd')==null ||sheetObjects[0].CellValue(i,'3lgs_cost_cd')==''||sheetObjects[0].CellValue(i,'3lgs_cost_cd').trim()=='') {
				sheetObjects[0].RowDelete(i, false);
			}
		}

		for(i = 3; i < k; i++) {
			for(var l=0; l<arrCntrTpSz.length; l++){
				total_rate  = total_rate+"#"+sheetObjects[0].CellValue(i, "3"+arrCntrTpSz[l]);
			}
			sheetObjects[0].CellValue2(i,"3ts_rt") = total_rate;
			total_rate = "";
		}
		// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
		for(i = 3; i < k; i++) {
			for(j = 0; j < 66; j++) {
				cellNullCheckString = cellNullCheckString + "|" + sheetObjects[0].CellValue(i,j);
			}

			//if(cellNullCheckString == "||||||||||||||||||||||||||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|||||") {
			  if(cellNullCheckString == "||||||||||||||||||||||||||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0"){	                       
				for(var jj = i; jj < k; jj++) {
					sheetObjects[0].RowDelete(i, false);
				}
				break;
			}
			cellNullCheckString = "";
		}

		for(i = 3; i < sheetObjects[0].RowCount + 3; i++) {
			if(ComGetLenByByte(sheetObjects[0].CellValue(i,"3tml_ovt_shft_cd")) > 1 ){
				sheetObjects[0].CellValue(i,"3tml_ovt_shft_cd")  = "";
			}
		}

		for(i = 0; i < sheetObjects[0].RowCount; i++){
			var sheetObj = sheetObjects[0];
			var sheetNo = 3;
			var Row = 3;

			if( sheetObj.CellValue(Row,"3curr_cd") == "KRW" || sheetObj.CellValue(Row,"3curr_cd") == "JPY"){
				sheetObj.InitCellProperty (Row, 30, dtData, daCenter, sheetNo + "d2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, 31, dtData, daCenter, sheetNo + "d4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, 32, dtData, daCenter, sheetNo + "d5", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, 33, dtData, daCenter, sheetNo + "d7", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, 34, dtData, daCenter, sheetNo + "d8", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, 35, dtData, daCenter, sheetNo + "d9", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "dw", dtData, daCenter, sheetNo + "dw", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "dx", dtData, daCenter, sheetNo + "dx", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "r2", dtData, daCenter, sheetNo + "r2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "r4", dtData, daCenter, sheetNo + "r4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "r5", dtData, daCenter, sheetNo + "r5", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "r7", dtData, daCenter, sheetNo + "r7", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "r8", dtData, daCenter, sheetNo + "r8", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "r9", dtData, daCenter, sheetNo + "r9", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "f2", dtData, daCenter, sheetNo + "f2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "f4", dtData, daCenter, sheetNo + "f4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "f5", dtData, daCenter, sheetNo + "f5", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "o2", dtData, daCenter, sheetNo + "o2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "o4", dtData, daCenter, sheetNo + "o4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "o5", dtData, daCenter, sheetNo + "o5", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "o7", dtData, daCenter, sheetNo + "o7", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "s2", dtData, daCenter, sheetNo + "s2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "s4", dtData, daCenter, sheetNo + "s4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "t2", dtData, daCenter, sheetNo + "t2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "t4", dtData, daCenter, sheetNo + "t4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "a2", dtData, daCenter, sheetNo + "a2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "a4", dtData, daCenter, sheetNo + "a4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "a5", dtData, daCenter, sheetNo + "a5", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "p2", dtData, daCenter, sheetNo + "p2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "p4", dtData, daCenter, sheetNo + "p4", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "c2", dtData, daCenter, sheetNo + "c2", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "c4", dtData, daCenter, sheetNo + "c4", "", dfInteger, 0, 18);

				sheetObj.InitCellProperty (Row, sheetNo + "teu_rate", dtData, daCenter, sheetNo + "teu_rate", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "box_rate", dtData, daCenter, sheetNo + "box_rate", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "move_rate", dtData, daCenter, sheetNo + "move_rate", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, sheetNo + "gang_hour_rate", dtData, daCenter, sheetNo + "gang_hour_rate", "", dfInteger, 0, 18);
				// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
				sheetObj.InitCellProperty (Row, sheetNo + "ton_rate", dtData, daCenter, sheetNo + "ton_rate", "", dfInteger, 0, 18);
				Row++;
			}
		}
		sheetObjects[0].ColumnSort("3lgs_cost_cd", "DESC");
	}

	/**
	 * 
	 * @param {ibsheet}		sheetObj
	 * @param {int,String}	row
	 * @param {int,String}	col
	 * @param {String}		Value
	 * @return
	 */
	function sheet_OnChange(sheetObj, row, col, Value) {
		var total_rate = "";
		var i =0;
		var j =0;
		
		for(var l=0; l<arrCntrTpSz.length; l++){
			total_rate  = total_rate+"#"+sheetObjects[0].CellValue(i, "3"+arrCntrTpSz[l]);
		}
		sheetObjects[0].CellValue2(i,"3ts_rt") = total_rate;
		
//		for(i = 29 ;i < 60; i++) {
//			total_rate  = total_rate + "#" + sheetObjects[0].CellValue(row, i);
//		}
//		
//		if (col >28 || col < 61){
//			sheetObjects[0].CellValue2(row, "3ts_rt") = total_rate;
//		}		
		
		if (col == 25) {
			sheetObjects[0].CellValue(row, "3to_tr_vol_val") = sheetObjects[0].CellValue(row, "3to_tr_vol_val").toUpperCase();
			if (sheetObjects[0].CellValue(row, "3to_tr_vol_val") != "MAX") {
				if (!ComIsNumber(sheetObjects[0].CellValue(row, "3to_tr_vol_val"))) {
					sheetObjects[0].CellValue2(row, "3to_tr_vol_val") = " ";
				}
			}
		}
	}
	
	
	/**
	 * 셀에 값이 없을경우 row 삭제 함수
	 * @param {ibsheet}sheet	IBSheet Object
	 * @return
	 */
	function delBlkRows(sheet) {
		if (sheet.RowCount > 0){
			for (var i=sheet.RowCount+3; sheet!=null && i>=3; i--){
				if ((sheet.CellValue(i,'3lgs_cost_cd')==null ||sheet.CellValue(i,'3lgs_cost_cd')=='') &&
					(sheet.CellValue(i,'3auto_calc_flg')==null ||sheet.CellValue(i,'3auto_calc_flg')=='') &&
					(sheet.CellValue(i,'3curr_cd')==null ||sheet.CellValue(i,'3curr_cd')=='') &&
					(sheet.CellValue(i,'3io_bnd_cd')==null ||sheet.CellValue(i,'3io_bnd_cd')=='')) 
				{
					sheet.RowDelete(i, false);
				}
			}
		}
	}
	