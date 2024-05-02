/*--==============================================================================
'주  시 스 템 : ESD_TES_9170.jsp
'서브  시스템 : 자바스크립트
'프로그램 ID  : ESD_TES_9170.js
'프로그램 명  : Storage Excel List Load 및 부모창으로 데이터 전송 처리								
'프로그램개요 : Storage Excel List Load 및 부모창으로 데이터 전송 처리				
'작   성   자 : 
'작   성   일 : 
* 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
* 2016-01-11 [CHM-201539086] : AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경
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
					if( k == 0 ) {
						ComShowCodeMessage('TES10087');
						return false;		
					}         
									
					var dupRowInfo = sheetObjects[0].ColValueDupRows("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38", false, true);
									
					if(dupRowInfo != ""){															
						var dupRow = dupRowInfo.split("|");											
											
						var dupRowNum = dupRow[1].split(",");	
						
						if(dupRowNum.length > 0){											
							for(var i=0 ; i<dupRowNum.length ;i++){																								
								sheetObjects[0].RowBackColor(dupRowNum[i])	= sheetObjects[0].RgbColor(255,0,0);
							}
							ComShowCodeMessage('TES10119', dupRowNum.length);
							return false;
						}	
					}
									 
					doActionIBSheet1(sheetObject1,formObject,IBSEARCH);	
									
					if(sheetErrCount==0){
						for(var i=1 ; i<=k ;i++){         	     			
							if (ComIsNull(sheetObjects[0].CellValue(i+2, 0))){ 
								sheetObjects[0].CellBackColor(i+2,0) = sheetObjects[0].RgbColor(255,0,0);
								err_count++;			     		  			   					
							}else{
								sheetObjects[0].CellBackColor(i+2,0) = sheetObjects[0].RgbColor(0,0,0);
							}
												
							if (ComIsNull(sheetObjects[0].CellValue(i+2, 1))){ 
								sheetObjects[0].CellBackColor(i+2,1) = sheetObjects[0].RgbColor(255,0,0);	
								err_count++;	
							}	else{	
								sheetObjects[0].CellBackColor(i+2,1) = sheetObjects[0].RgbColor(0,0,0);
							}						
												
							if (ComIsNull(sheetObjects[0].CellValue(i+2, 2))){ 
								sheetObjects[0].CellBackColor(i+2,2) = sheetObjects[0].RgbColor(255,0,0);		
								err_count++;					     		  			   					
							}else{
								sheetObjects[0].CellBackColor(i+2,2) = sheetObjects[0].RgbColor(0,0,0);
							}	
												
							if (ComIsNull(sheetObjects[0].CellValue(i+2, 3))){ 
								sheetObjects[0].CellBackColor(i+2,3) = sheetObjects[0].RgbColor(255,0,0);	
								err_count++;						     		  				   					
							}else{
								sheetObjects[0].CellBackColor(i+2,3) = sheetObjects[0].RgbColor(0,0,0);
							}	
												
							if (ComIsNull(sheetObjects[0].CellValue(i+2, 37))){	//UOM 자리이동 
								sheetObjects[0].CellBackColor(i+2,37) = sheetObjects[0].RgbColor(255,0,0);	
								err_count++;						     		  				   					
							}else{
								sheetObjects[0].CellBackColor(i+2,37) = sheetObjects[0].RgbColor(0,0,0);
							}
						}
					}	
									
					if(sheetErrCount > 0 || err_count > 0){  
						ComShowCodeMessage('TES10088');
						sheetErrCount = 0;
						return false;         	     			
					}else if(sheetErrCount == 0 && err_count == 0) { 
	
						var opener_sheet_obj = window.dialogArguments.document.t4sheet1;
						var appendFlg = "";
						if(opener_sheet_obj.RowCount==0){
							ComShowCodeMessage('TES10089');  
							appendFlg =true;
						}else if(opener_sheet_obj.RowCount>0){
							appendFlg = ComShowConfirm(ComGetMsg('TES10121'));  
						}
	         	     			
						for(var i=0;i<sheetObjects[0].RowCount;i++){
													
							if(sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase() == "IB" || sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase() == "OB" || sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase() == "SAME" ){							
								sheetObjects[0].CellValue2(i+3,"5io_bnd_cd") = sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase();														
															
								if(sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase()  == "IB"){
									sheetObjects[0].CellValue2(i+3,"5io_bnd_cd")  = "I";
								}else	if(sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase()  == "OB"){
									sheetObjects[0].CellValue2(i+3,"5io_bnd_cd")  = "O";
								}else	if(sheetObjects[0].CellValue(i+3,"5io_bnd_cd").toUpperCase()  == "SAME"){
									sheetObjects[0].CellValue2(i+3,"5io_bnd_cd")  = "S";
								}					
							}else{
								sheetObjects[0].CellValue(i+3,"5io_bnd_cd") = "";
							} 					
													
							if(sheetObjects[0].CellValue(i+3,"5sat_flg_fd").toUpperCase() == "E"){
								sheetObjects[0].CellValue2(i+3,"5sat_flg_fd") = "Y";							
							}else if(sheetObjects[0].CellValue(i+3,"5sat_flg_fd").toUpperCase() == "I"){
								sheetObjects[0].CellValue2(i+3,"5sat_flg_fd") = "";					
							}
													
							if(sheetObjects[0].CellValue(i+3,"5sun_flg_fd").toUpperCase() == "E"){
								sheetObjects[0].CellValue2(i+3,"5sun_flg_fd") = "Y";							
							}else if(sheetObjects[0].CellValue(i+3,"5sun_flg_fd").toUpperCase() == "I"){
								sheetObjects[0].CellValue2(i+3,"5sun_flg_fd") = "";					
							}		
													
							if(sheetObjects[0].CellValue(i+3,"5hol_flg_fd").toUpperCase() == "E"){
								sheetObjects[0].CellValue2(i+3,"5hol_flg_fd") = "Y";							
							}else if(sheetObjects[0].CellValue(i+3,"5hol_flg_fd").toUpperCase() == "I"){
								sheetObjects[0].CellValue2(i+3,"5hol_flg_fd") = "";					
							}
													
							if(sheetObjects[0].CellValue(i+3,"5to_tr_dys").toUpperCase() == "MAX"){
								sheetObjects[0].CellValue2(i+3,"5to_tr_dys") = sheetObjects[0].CellValue(i+3,"5to_tr_dys").toUpperCase();							
							}
						}		         	     			
	         	     			
						//setDtaCurrSht2OprSht(sheetObjects[0], sheetObjects[2]);  
						if(appendFlg==true){
							setDtaCurrSht2OprSht1(sheetObjects[0],'');         	     			
						}else if(appendFlg==false){ 
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
				ComShowMessage(e);
			}
		}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
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
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{int,String}	sheetNo		Sheet No
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					sheetNo = 5;
                	                 	
					// 높이 설정
                    style.height = 300;
                                        
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(115, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //var HeadTitle1 = "Cost\nCode|FD/FP|I/O|Volume\nUOM|DG|FT Day|Tier Vol.|Tier Vol.|Exclude Date|Exclude Date|Exclude Date|Comm.\nTime of\na Day|FP\nTEU|Rate|Rate|Rate|Rate\nTEU|Rate\nBox|Rate\nMove|Days|Days|Days|Curr\nency|Remark";
                    //var HeadTitle2 = "Cost\nCode|FD/FP|I/O|Volume\nUOM|DG|FT Day|Fr|To|SA|SU|Ho|Comm.\nTime of\na Day|FP\nTEU|D2|D4|…|Rate\nTEU|Rate\nBox|Rate\nMove|D2|D4|…|Curr\nency|Remark";
                    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    var HeadTitle0 = "Cost Code|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|"
                    + "Exclude Date|Exclude Date|Exclude Date|"
                    + "DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|"
                    + "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|"
                    + "Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|"
                    + "Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|"
                    + "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle1 = "Cost Code|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "Same for all DG|Same for all DG|"
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "SA|SU|Ho|"
                    + "Same for all DG|Same for all DG|"
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "From|To|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|"
                    + "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle2 = "Cost Code|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "SA|SU|Ho|"
                    + "No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "From|To|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|"
                    + "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Verify\nResult|Remark";                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);                    
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  													KEYFIELD, 		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,   sheetNo+ "lgs_cost_cd",   						false,          "",       dfNone,   		0,     false,     false);																																	
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  true,   sheetNo+ "curr_cd",   								false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,   sheetNo+ "tml_sto_agmt_tp_cd",    		false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "cmnc_hrmnt",     						false,          "",       dfUserFormat,   		0,     true,      true, 5);																																																																		
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "ft_dys",     								false,          "",       dfNone,   		0,     true,      true);			//4																														
                    
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,   sheetNo+ "io_bnd_cd",     						false,          "",       dfNone,       0,     true,      true, 4);                    		
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_none_fd",     			false,          "",       dfNone,   		0,     true,      true);																																	                    
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_fd",     						false,          "",       dfNone,   		0,     true,      true);																																	                      
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "sep_dg_none_fd",     				false,          "",       dfNone,       0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n1st_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);							//9
                    
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n2nd_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);																																	                                                                                                                              																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n3rd_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n4th_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n5th_clss_flg_fd",     false,          "",       dfNone,       0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n6th_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);							//14																															
                    
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n7th_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);																																	                                                                                                                              																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n8th_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n9th_clss_flg_fd",     false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   sheetNo+ "sat_flg_fd",     						false,          "",       dfNone,       0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   sheetNo+ "sun_flg_fd",     						false,          "",       dfNone,   		0,     true,      true);			//19																																
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   sheetNo+ "hol_flg_fd",     						false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_none_r",     	     	false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_r",    				     	false,          "",       dfNone,       0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "sep_dg_none_r",     	      false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n1st_clss_flg_r",      false,          "",       dfNone,   		0,     true,      true);							//24																															

                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n2nd_clss_flg_r",     	false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n3rd_clss_flg_r",      false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n4th_clss_flg_r",     	false,          "",       dfNone,       0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n5th_clss_flg_r",     	false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n6th_clss_flg_r",      false,          "",       dfNone,   		0,     true,      true);							//29																															

                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n7th_clss_flg_r",      false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n8th_clss_flg_r",      false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n9th_clss_flg_r",      false,          "",       dfNone,       0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   sheetNo+ "fm_tr_dys",     						false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   sheetNo+ "to_tr_dys",     						false,          "",       dfNone,   		0,     true,      true, 3);				//34																															

                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "fp_calc_prd_cd",     				false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   sheetNo+ "fp_teu_qty",     						false,          "",       dfInteger,   	0,     true,      true, 5);																																	
                    InitDataProperty(0, cnt++ , dtCombo,      65,    daCenter,  true,   sheetNo+ "tml_agmt_vol_ut_cd",   			false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d2_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d4_fd",     								false,          "",       dfInteger,    0,     true,      true);				//39
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d5_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d7_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	                                                                                                                                                        
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d8_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d9_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dw_fd",     								false,          "",       dfInteger,   	0,     true,      true);				//44
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dx_fd",     								false,          "",       dfInteger,    0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r2_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	                                                                                                                                                          
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r4_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r5_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r7_fd",     								false,          "",       dfInteger,   	0,     true,      true);				//49
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r8_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r9_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f2_fd",     								false,          "",       dfInteger,    0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f4_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	                                                                                                                                                          
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f5_fd",     								false,          "",       dfInteger,   	0,     true,      true);				//54
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o2_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o4_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o5_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o7_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s2_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s4_fd",     								false,          "",       dfInteger,    0,     true,      true);				//59																														
                                                                                                                                                          
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t2_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t4_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a2_fd",     								false,          "",       dfInteger,   	0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a4_fd",     								false,          "",       dfInteger,   	0,     true,      true);		
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a5_fd",     								false,          "",       dfInteger,   	0,     true,      true);				//64
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p2_fd",     								false,          "",       dfInteger,    0,     true,      true);				//65																																
                                                                                                                                                          
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p4_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c2_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c4_fd",     								false,          "",       dfInteger,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d2_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d4_r",     									false,          "",       dfFloat,   	  2,     true,      true);			//70
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d5_r",     									false,          "",       dfFloat,      2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d7_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d8_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d9_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dw_r",     									false,          "",       dfFloat,   	  2,     true,      true);			//75
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dx_r",     									false,          "",       dfFloat,      2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r2_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r4_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r5_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r7_r",     									false,          "",       dfFloat,   	  2,     true,      true);			//80
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r8_r",     									false,          "",       dfFloat,   	  2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r9_r",     									false,          "",       dfFloat,   	  2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f2_r",     									false,          "",       dfFloat,      2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f4_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f5_r",     									false,          "",       dfFloat,   	  2,     true,      true);			//85
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o2_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o4_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o5_r",     									false,          "",       dfFloat,   	  2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o7_r",     									false,          "",       dfFloat,   	  2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s2_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s4_r",     									false,          "",       dfFloat,      2,     true,      true);			//90																																
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t2_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t4_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a2_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a4_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a5_r",     									false,          "",       dfFloat,   	  2,     true,      true);			//95
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p2_r",     									false,          "",       dfFloat,      2,     true,      true);			//96																															
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p4_r",     									false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c2_r",     									false,          "",       dfFloat,   	  2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c4_r",     									false,          "",       dfFloat,   	  2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "teu_rate",									false,          "",       dfFloat,      2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "box_rate",     							false,          "",       dfFloat,   	  2,     true,      true);				//101
                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "move_rate",     							false,          "",       dfFloat,   	  2,     true,      true);																																	
                 // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "ton_rate",     								false,          "",       dfFloat,   	  2,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "verify_result",								false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtPopup,		70,    daCenter,  true,   sheetNo+ "agmt_dtl_rmk",     						false,          "",       dfNone,   		0,     true,      true);																																	
                    InitDataProperty(0, cnt++ , dtHidden,	1,    daCenter,  true,   sheetNo+ "xcld_dy_aply_tp_cd",						false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtHidden,	1,    daCenter,  true,   sheetNo+ "auto_calc_flg",     							false,          "",       dfNone,   		0,     true,      true);					//107
                    InitDataProperty(0, cnt++ , dtHidden,	1,    daCenter,  true,   sheetNo+ "ts_rt",     									false,          "",       dfNone,   		0,     true,      true);											
                    InitDataProperty(0, cnt++ , dtHidden,	1,    daCenter,  true,   sheetNo+ "vrfyFlg",     								false,          "",       dfNone,   		0,     true,      true);											
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,   daCenter,  true,   sheetNo+ "ibflag" );
                    InitDataProperty(0, cnt++ , dtHidden,	1,    daCenter,  true,   sheetNo+ "dg_none_fd",	    			    		false,          "",       dfNone,   		0,     true,      true);																																			

                    InitDataProperty(0, cnt++ , dtHidden,	1,    daCenter,  true,   sheetNo+ "dg_none_r",                				false,          "",       dfNone,   		0,     true,      true);						//112																											
                  
		            CellBackColor(1,7) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 20,  1, 23) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(2,  8, 2, 37) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 36, 1, 37) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 39, 1, 91) = RgbColor(222, 251, 248);   // ENIS

                    HeadRowHeight  =21;
                    HeadRowHeight  =20;
                    style.height=GetSheetHeight(10);                     
                     
                    InitDataCombo( 0 , sheetNo +"lgs_cost_cd" , window.dialogArguments.lgsCostCDSheet, window.dialogArguments.lgsCostCDSheet);  
                    InitDataCombo( 0 , sheetNo +"tml_agmt_vol_ut_cd" , vol_ut_cdCode, vol_ut_cdCode);
                    InitDataCombo( 0 , sheetNo +"tml_sto_agmt_tp_cd" , tml_sto_agmt_tp_codeCode, tml_sto_agmt_tp_codeCode);                         
                    InitDataCombo( 0 , sheetNo +"io_bnd_cd" , io_bnd_codeText, io_bnd_codeCode);    
                    InitDataCombo( 0 , sheetNo +"ft_dys" , " |F", " |F");
                    InitDataCombo( 0 , sheetNo +"fp_calc_prd_cd" , " |D|M", " |D|M");                                                                                                                   
                    
					InitDataValid(0, "5sat_flg_fd", vtCharOnly,"Y");
					InitDataValid(0, "5sun_flg_fd", vtCharOnly,"Y"); 
					InitDataValid(0, "5hol_flg_fd", vtCharOnly,"Y");
                    
                    //InitDataCombo( 0 , sheetNo +"dg_none_fd" 			     , " |Y"," |Y");	             
                    InitDataCombo( 0 , sheetNo +"same_dg_none_fd" 	     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_fd" 			     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"sep_dg_none_fd" 	     , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n1st_clss_flg_fd" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n2nd_clss_flg_fd" , " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n3rd_clss_flg_fd" , " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n4th_clss_flg_fd" , " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n5th_clss_flg_fd" , " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n6th_clss_flg_fd" , " |Y"," |Y");                     
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg_fd" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n8th_clss_flg_fd" , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n9th_clss_flg_fd" , " |Y"," |Y");
                    
                    //InitDataCombo( 0 , sheetNo +"dg_none_r" 			, " |Y"," |Y");	             
                    InitDataCombo( 0 , sheetNo +"same_dg_none_r" 	    , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_r" 			, " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"sep_dg_none_r" 	    , " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n1st_clss_flg_r" 	, " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n2nd_clss_flg_r" 	, " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n3rd_clss_flg_r" 	, " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n4th_clss_flg_r" 	, " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n5th_clss_flg_r" 	, " |Y"," |Y"); 
                    InitDataCombo( 0 , sheetNo +"dcgo_n6th_clss_flg_r" 	, " |Y"," |Y");                     
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg_r" 	, " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n8th_clss_flg_r" 	, " |Y"," |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n9th_clss_flg_r" 	, " |Y"," |Y");
                     
                    InitUserFormat(0 , sheetNo+ "cmnc_hrmnt", "##:##", ":" );                    
                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";                              
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
                    InitDataProperty(0, cnt++ , dtData,     30,    daCenter,  true,     "",     false,          "",       dfNone,          0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daLeft,    true,     "",     false,          "",       dfNone,   		0,     true,      true,1);                   
		               
                    CountPosition = 0 ;
                    style.height=GetSheetHeight(4);

				}
				break;                   
		}
	}


	/**
	 * Sheet 관련 프로세스 처리. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {String}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBLOADEXCEL:      //엑셀 올리기
				sheetObj.LoadExcel(false,1,"",116,-1);
				break;
		}
	}

 	/**
 	 * Sheet 관련 프로세스 처리. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {String}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
 	 */
	function doActionIBSheet1(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:            					 
				formObj.f_cmd.value = SEARCH;               
				var param = sheetObjects[0].GetSaveString(false,false);
				var sXml = sheetObjects[1].GetSearchXml("ESD_TES_9170GS.do", param+'&'+tesFrmQryStr(formObj),"",true);
				sheetObjects[1].LoadSearchXml(sXml); 								              		
				break;         	
		}
	}  


	/**
	 * popup 창의 sheet data 를 opener 의 특정 sheet 로 넘기기 -> 단 동일한 saveName만 해당. <br>
	 * 사용되지 않음 ( 2009-09-23 )
	 * @param {ibsheet}  	ip_sht_obj		현재창의 input sheet 객체
	 * @param {String}  	opr_sht_nm_str	opener 의 대상 sheet 명
	 */
    function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {
    	
    	/*
		(인자: 현재창의 input sheet 객체, opener의 대상 sheet명)
		popup창의 sheet data를 opener의 특정 sheet로 넘기기 -> 단 동일한 saveName만 해당
    	 */

		var formObj = document.form;		
		var total_rate = 0;
		var i = 0; 	
		var opener_obj = window.dialogArguments;	
		var opener_sheet_obj =  opener_obj.document.t4sheet1;
		var sheetObject = ip_sht_obj;     
		//opener_sheet_obj.RemoveAll();
	
		for (i=3; i<sheetObject.Rows; i++) //제목은 제외
		{	
			var iRow = opener_sheet_obj.DataInsert(-1);			
			for(j=0; j<=sheetObject.LastCol; j++)
			{
				if (sheetObject.ColSaveName(j) != "") 
				{   // 현재 SaveName이 없는것들을 걸러내기위한조건					
					for(k=0; k<=opener_sheet_obj.LastCol; k++)
					{
						if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j))
						{
							opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(k)) = sheetObject.CellValue(i, sheetObject.ColSaveName(j)) ;
						}
					}
				}
			}		
		}
		opener_obj.document.form.fileImportFlg.value="Y";	
	}

	/**
	 * popup 창의 sheet data 를 opener 의 특정 sheet 로 넘기기 -> 단 동일한 saveName만 해당. <br>
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
			queryStr = sheet.GetSaveString(false, false)+"&prefix=5";
			
			if (queryStr == null || queryStr == '') {
				//return false;
			} else {
				opr_sht_idx = 2;
				opener_sheet_obj = window.dialogArguments.document.t4sheet1;
				tes_agmt_copy_rows_to(sheet, opener_sheet_obj, "", false, true, "5");				
			}		
			
			window.dialogArguments.document.form.fileImportFlg.value = "Y";	
			window.close();
		}
	}


    /**
     * Sheet Excel Load 후 프로세스 처리. <br>
     * 
     */
	function sheet_OnLoadExcel(){				
		var k = sheetObjects[0].RowCount+3;
		var sheetNo = 5; 
		var j=0;
   		var daysTotalRate = 0;
   		var rateTotalRate = 0;
   		var total_rate_day = "";
   		var total_rate_rate = ""; 
   		var cellNullCheckString  = "";
   		var i=0; 
   		
   		//[CHM-201642186]Upload 이후 Cost Code 또는 Cntr No이 없는 경우 해당 라인을 삭제하는 로직을 추가 2016-06-23
   		delBlkRows(sheetObjects[0]);
   		
   		// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
		for(i=3;i<k;i++){				
			for(j=0;j<106;j++){ 
				cellNullCheckString = cellNullCheckString+"|"+sheetObjects[0].CellValue(i,j);
			}
			if(cellNullCheckString=="||||||||||||||||||||||||||||||||||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||"){
				for(var jj=i;jj<k;jj++){
					sheetObjects[0].RowDelete(i, false);
				}
				break;
			} 
			cellNullCheckString = "";
		}	  	

		for(var i=3;i<k;i++){
			for(var l=0; l<arrCntrTpSz.length; l++){
			//for(j= 38 ;j< 69;j++){		 	 			
	 			total_rate_day  = total_rate_day+"#"+sheetObjects[0].CellValue(i, "5"+arrCntrTpSz[l]+"_fd");
	 			daysTotalRate = parseInt(sheetObjects[0].CellValue(i, "5"+arrCntrTpSz[l]+"_fd"))+daysTotalRate; 
	 		}
	 			
			for(var l=0; l<arrCntrTpSz.length; l++){
 	 		//for(j= 69 ;j< 100;j++){
	 			total_rate_rate  = total_rate_rate+"#"+sheetObjects[0].CellValue(i, "5"+arrCntrTpSz[l]+"_r");
	 			rateTotalRate = parseInt(sheetObjects[0].CellValue(i, "5"+arrCntrTpSz[l]+"_r"))+rateTotalRate;
	 		}
	 		
	 		if(daysTotalRate==0 && rateTotalRate>0){
	 			sheetObjects[0].CellValue2(i,"5ts_rt") = total_rate_rate;			
	 		}else if(daysTotalRate>0 && rateTotalRate==0){
	 			sheetObjects[0].CellValue2(i,"5ts_rt") = total_rate_day;		
	 		}else if(daysTotalRate>0 && rateTotalRate>0){
	 			sheetObjects[0].CellValue2(i,"5ts_rt") = total_rate_rate;	
	 		}else{
	 			sheetObjects[0].CellValue2(i,"5ts_rt") = total_rate_rate;	
	 		}	
	   		daysTotalRate = 0;
	   		rateTotalRate = 0;
	   		total_rate_day = "";
	   		total_rate_rate = "";  						         
		}
		
		for(var i=0;i<sheetObjects[0].RowCount;i++){
			var sheetObj = sheetObjects[0];	       
       
			if( sheetObj.CellValue(Row,"5curr_cd") == "KRW" || sheetObj.CellValue(Row, "5curr_cd") == "JPY"){	         			
				sheetObj.InitCellProperty (Row, "5d2_r", dtData, daCenter, "5d2_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5d4_r", dtData, daCenter, "5d4_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5d5_r", dtData, daCenter, "5d5_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5d7_r", dtData, daCenter, "5d7_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5d8_r", dtData, daCenter, "5d8_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5d9_r", dtData, daCenter, "5d9_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5dw_r", dtData, daCenter, "5dw_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5dx_r", dtData, daCenter, "5dx_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5r2_r", dtData, daCenter, "5r2_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5r4_r", dtData, daCenter, "5r4_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5r5_r", dtData, daCenter, "5r5_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5r7_r", dtData, daCenter, "5r7_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5r8_r", dtData, daCenter, "5r8_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5r9_r", dtData, daCenter, "5r9_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5f2_r", dtData, daCenter, "5f2_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5f4_r", dtData, daCenter, "5f4_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5f5_r", dtData, daCenter, "5f5_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5o2_r", dtData, daCenter, "5o2_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5o4_r", dtData, daCenter, "5o4_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5o5_r", dtData, daCenter, "5o5_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5o7_r", dtData, daCenter, "5o7_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5s2_r", dtData, daCenter, "5s2_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5s4_r", dtData, daCenter, "5s4_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5t2_r", dtData, daCenter, "5t2_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5t4_r", dtData, daCenter, "5t4_r", "", dfInteger, 0, 18); 
				sheetObj.InitCellProperty (Row, "5a2_r", dtData, daCenter, "5a2_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5a4_r", dtData, daCenter, "5a4_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5a5_r", dtData, daCenter, "5a5_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5p2_r", dtData, daCenter, "5p2_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5p4_r", dtData, daCenter, "5p4_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5c2_r", dtData, daCenter, "5c2_r", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5c4_r", dtData, daCenter, "5c4_r", "", dfInteger, 0, 18);
				
				sheetObj.InitCellProperty (Row, "5teu_rate", dtData, daCenter, "5teu_rate", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5box_rate", dtData, daCenter, "5box_rate", "", dfInteger, 0, 18);
				sheetObj.InitCellProperty (Row, "5move_rate", dtData, daCenter, "5move_rate", "", dfInteger, 0, 18);     
				// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
				sheetObj.InitCellProperty (Row, "5ton_rate", dtData, daCenter, "5ton_rate", "", dfInteger, 0, 18);       				
	   		} 
		}		
	}

	
    /**
     * Sheet 조회후 프로세스 처리. <br>
     */
	function sheet1_OnSearchEnd(){		
		var k = sheetObjects[0].RowCount+4;  		
		var vrfyFlg ;
		var vrfyRateSum = 0;
		var vrfyDysSum 	= 0;
		var errCount 		= 0;
 		
		var totalErrCount = 0;
						
		for(var i=3;i<k;i++){			
			vrfyFlg = sheetObjects[1].CellValue(i-2, 1).split("|");
			sheetObjects[0].CellValue2(i-2,106) = vrfyFlg;
			sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(255,255,255);		      
			vrfyDysSum = parseInt(sheetObjects[0].CellValue(i,'5d2_fd'))
						+ parseInt(sheetObjects[0].CellValue(i,'5d4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5d5_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5d7_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5d8_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5d9_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5dw_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5dx_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5r4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5r5_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5r7_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5r8_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5r9_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5f2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5f4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5o2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5o4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5o5_fd'))
						+ parseInt(sheetObjects[0].CellValue(i,'5o7_fd'))
						+ parseInt(sheetObjects[0].CellValue(i,'5s2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5s4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5t2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5t4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5a2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5a4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5a5_fd')) 
						+ parseInt(sheetObjects[0].CellValue(i,'5p2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5p4_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5c2_fd'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5c4_fd'))
						+ parseInt(sheetObjects[0].CellValue(i,'5f5_fd')); 
								  
			vrfyRateSum = parseInt(sheetObjects[0].CellValue(i,'5d2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5d4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5d5_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5d7_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5d8_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5d9_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5dw_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5dx_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5r4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5r5_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5r7_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5r8_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5r9_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5f2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5f4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5o2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5o4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5o5_r'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5o7_r'))
						+ parseInt(sheetObjects[0].CellValue(i,'5s2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5s4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5t2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5t4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5a2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5a4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5a5_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5p2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5p4_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5c2_r'))   
						+ parseInt(sheetObjects[0].CellValue(i,'5c4_r'))  
						+ parseInt(sheetObjects[0].CellValue(i,'5f5_r')); 								
								
			if(sheetObjects[0].CellValue(i, '5lgs_cost_cd') != sheetObjects[1].CellValue(i-2,0)){ 
				sheetObjects[0].CellBackColor(i,'5lgs_cost_cd') = sheetObjects[0].RgbColor(255,0,0);	
				errCount++; 
			}
			// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
			if(sheetObjects[0].CellValue(i, '5lgs_cost_cd').trim() == ""){ 
				sheetObjects[0].CellBackColor(i,'5lgs_cost_cd') = sheetObjects[0].RgbColor(255,0,0);	
				errCount++; 
			}			
			
			if (vrfyFlg[0] == "Y"){
				sheetObjects[0].CellValue2(i, '5auto_calc_flg') = "Y";	
			}

			// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
			if( sheetObjects[0].CellValue(i, '5tml_agmt_vol_ut_cd') == "C" && 
				sheetObjects[0].CellValue(i, '5ft_dys').trim() == ""){					
				if(sheetObjects[0].CellValue(i, '5teu_rate')>0){
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
										
				}else if(sheetObjects[0].CellValue(i, '5box_rate')>0){
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
								
				}else if(sheetObjects[0].CellValue(i, '5move_rate')>0){
					sheetObjects[0].CellBackColor(i,'5move_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)										
				} else if (sheetObjects[0].CellValue(i, '5ton_rate') > 0) {
					sheetObjects[0].CellBackColor(i,'5ton_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					
				}
			}
			
			// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
			if(	sheetObjects[0].CellValue(i, '5tml_agmt_vol_ut_cd') == "T" && 
				sheetObjects[0].CellValue(i, '5ft_dys').trim() == ""){
				
				if(vrfyDysSum>0 || vrfyRateSum>0){
				}else if(sheetObjects[0].CellValue(i, '5teu_rate')==0.00){
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
								
				}else if(sheetObjects[0].CellValue(i, '5box_rate')>0){
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
									
				}else if(sheetObjects[0].CellValue(i, '5move_rate')>0){
					sheetObjects[0].CellBackColor(i,'5move_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)										
				} else if (sheetObjects[0].CellValue(i, '5ton_rate') > 0) {
					sheetObjects[0].CellBackColor(i,'5ton_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					
				}				
			}
			
			// 2010-05-03 [CHM-201003698] : TES AGMT File Upload에서 Space 인식건
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			if( sheetObjects[0].CellValue(i, '5tml_agmt_vol_ut_cd') == "B" && 
				sheetObjects[0].CellValue(i, '5ft_dys').trim() == ""){
				
				if(sheetObjects[0].CellValue(i, '5teu_rate')>0){
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
											
				}else if(sheetObjects[0].CellValue(i, '5box_rate')==0.00){
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
										
				}else if(sheetObjects[0].CellValue(i, '5move_rate')>0){
					sheetObjects[0].CellBackColor(i,'5move_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
											
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)										
				} else if (sheetObjects[0].CellValue(i, '5ton_rate') > 0) {
					sheetObjects[0].CellBackColor(i,'5ton_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					
				}				
			}
			
			if(	sheetObjects[0].CellValue(i, '5tml_agmt_vol_ut_cd') == "M" && 
				sheetObjects[0].CellValue(i, '5ft_dys').trim() == ""){
				if(sheetObjects[0].CellValue(i, '5teu_rate')>0){
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
										
				}else if(sheetObjects[0].CellValue(i, '5box_rate')>0){
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
													
				}else if(sheetObjects[0].CellValue(i, '5move_rate')==0.00){
					sheetObjects[0].CellBackColor(i,'5move_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
										
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)										
				} else if (sheetObjects[0].CellValue(i, '5ton_rate') > 0) {
					sheetObjects[0].CellBackColor(i,'5ton_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					
				}
			}
			
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			if(	sheetObjects[0].CellValue(i, '5tml_agmt_vol_ut_cd') == "W" && 
					sheetObjects[0].CellValue(i, '5ft_dys').trim() == "") {
				if (sheetObjects[0].CellValue(i, '5teu_rate') > 0 ) {
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
					
				} else if (sheetObjects[0].CellValue(i, '5box_rate') > 0 ) {
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
					
				} else if (sheetObjects[0].CellValue(i, '5move_rate') > 0 ) {
					sheetObjects[0].CellBackColor(i,'5move_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
					
				} else if (sheetObjects[0].CellValue(i, '5ton_rate') == 0.00) {
					sheetObjects[0].CellBackColor(i,'5ton_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
					
				}				
			}
			
			if(sheetObjects[0].CellValue(i, '5ft_dys')=="F"){
				if(sheetObjects[0].CellValue(i, '5teu_rate')>0){
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
										
				}else if(sheetObjects[0].CellValue(i, '5box_rate')>0){
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
													
				}else if(sheetObjects[0].CellValue(i, '5move_rate')>0){
					sheetObjects[0].CellBackColor(i,'5move_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	

					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)										
				} else if (sheetObjects[0].CellValue(i, '5ton_rate') > 0) {
					sheetObjects[0].CellBackColor(i,'5ton_rate') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;	
					
				}				
			}				
						
			
			if (vrfyFlg[11] == "Y"){
				if(sheetObjects[0].CellValue(i,'5cmnc_hrmnt').trim() == ""){ 
					sheetObjects[0].CellBackColor(i,'5cmnc_hrmnt') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
				} 
			}else	if (vrfyFlg[11] == "N"){
				if(sheetObjects[0].CellValue(i,'5cmnc_hrmnt').trim() != ""){ 
					sheetObjects[0].CellBackColor(i,'5cmnc_hrmnt') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
				} 
			}

			if (vrfyFlg[12] == "Y" && sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd')=="FD"){
				if(sheetObjects[0].CellValue(i,'5io_bnd_cd').trim() == ""){ 
					sheetObjects[0].CellBackColor(i,'5io_bnd_cd') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
				} 				 
			}else if (vrfyFlg[12] == "N"){
				if(sheetObjects[0].CellValue(i,'5io_bnd_cd').trim() != ""){ 
					sheetObjects[0].CellBackColor(i,'5io_bnd_cd') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
				} 
			}				
			
			if (vrfyFlg[13] == "Y"){
				if(sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd') != "FD" && sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd') != "FP"){ 
					sheetObjects[0].CellBackColor(i,'5tml_sto_agmt_tp_cd') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
				} 
			}else if (vrfyFlg[13] == "N"){
				if(sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd').trim() != ""){ 
					sheetObjects[0].CellBackColor(i,'5tml_sto_agmt_tp_cd') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;
				} 
			}	
			
			if (sheetObjects[0].CellValue(i,'5ft_dys')=="F" && vrfyFlg[14] == "Y"){
				//[CHM-201539189]DG(NONE) 숨김처리로 값을 입력안하면 NONE DG를 선택한 것으로 본다.(CAH D 2015-12-30)
				if( sheetObjects[0].CellValue(i,'5dg_none_fd').trim() == "" 
					&& sheetObjects[0].CellValue(i,'5same_dg_none_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5same_dg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5sep_dg_none_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n1st_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n2nd_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n3rd_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n4th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n5th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n6th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n7th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n8th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n9th_clss_flg_fd').trim() == "" ){ 
					sheetObjects[0].CellValue(i,'5dg_none_fd') = "Y";
				}
				if( sheetObjects[0].CellValue(i,'5dg_none_fd').trim() == "" 
					&& sheetObjects[0].CellValue(i,'5same_dg_none_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5same_dg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5sep_dg_none_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n1st_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n2nd_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n3rd_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n4th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n5th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n6th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n7th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n8th_clss_flg_fd').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n9th_clss_flg_fd').trim() == "" ){ 
					sheetObjects[0].CellBackColor(i,'5dg_none_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5same_dg_none_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5same_dg_fd') = sheetObjects[0].RgbColor(255,0,0);			
					sheetObjects[0].CellBackColor(i,'5sep_dg_none_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n1st_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n2nd_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n3rd_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n4th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n5th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n6th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n7th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n8th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n9th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	 
					errCount++;
				} 
			}else if (vrfyFlg[14] == "N"){
				if( sheetObjects[0].CellValue(i,'5dg_none_fd').trim() == "Y" 
					|| sheetObjects[0].CellValue(i,'5same_dg_none_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5same_dg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5sep_dg_none_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n1st_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n2nd_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n3rd_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n4th_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n5th_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n6th_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n7th_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n8th_clss_flg_fd').trim() == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n9th_clss_flg_fd').trim() == "Y" ){ 
					sheetObjects[0].CellBackColor(i,'5dg_none_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5same_dg_none_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5same_dg_fd') = sheetObjects[0].RgbColor(255,0,0);			
					sheetObjects[0].CellBackColor(i,'5sep_dg_none_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n1st_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n2nd_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n3rd_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n4th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n5th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n6th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n7th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n8th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n9th_clss_flg_fd') = sheetObjects[0].RgbColor(255,0,0); 
					errCount++;
				} 
			} 
			
			if (sheetObjects[0].CellValue(i,'5ft_dys')=="" && vrfyFlg[16] == "Y"){
				//[CHM-201539189]DG(NONE) 숨김처리로 값을 입력안하면 NONE DG를 선택한 것으로 본다.(CAH D 2015-12-30)
				if( sheetObjects[0].CellValue(i,'5dg_none_r').trim() == "" 
					&& sheetObjects[0].CellValue(i,'5same_dg_none_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5same_dg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5sep_dg_none_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n1st_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n2nd_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n3rd_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n4th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n5th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n6th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n7th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n8th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n9th_clss_flg_r').trim() == "" ){ 
					sheetObjects[0].CellValue(i,'5dg_none_r') = "Y";
				}
				if( sheetObjects[0].CellValue(i,'5dg_none_r').trim() == "" 
					&& sheetObjects[0].CellValue(i,'5same_dg_none_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5same_dg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5sep_dg_none_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n1st_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n2nd_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n3rd_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n4th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n5th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n6th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n7th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n8th_clss_flg_r').trim() == ""
					&& sheetObjects[0].CellValue(i,'5dcgo_n9th_clss_flg_r').trim() == "" ){ 
					sheetObjects[0].CellBackColor(i,'5dg_none_r') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5same_dg_none_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5same_dg_r') = sheetObjects[0].RgbColor(255,0,0);			
					sheetObjects[0].CellBackColor(i,'5sep_dg_none_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n1st_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n2nd_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n3rd_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n4th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n5th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n6th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n7th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n8th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n9th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	 
					errCount++;
				} 
			}else if (vrfyFlg[16] == "N"){
				if( sheetObjects[0].CellValue(i,'5dg_none_r') == "Y" 
					|| sheetObjects[0].CellValue(i,'5same_dg_none_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5same_dg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5sep_dg_none_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n1st_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n2nd_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n3rd_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n4th_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n5th_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n6th_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n7th_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n8th_clss_flg_r') == "Y"
					|| sheetObjects[0].CellValue(i,'5dcgo_n9th_clss_flg_r') == "Y" ){ 
					sheetObjects[0].CellBackColor(i,'5dg_none_r') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5same_dg_none_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5same_dg_r') = sheetObjects[0].RgbColor(255,0,0);			
					sheetObjects[0].CellBackColor(i,'5sep_dg_none_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n1st_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n2nd_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n3rd_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n4th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n5th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n6th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n7th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n8th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5dcgo_n9th_clss_flg_r') = sheetObjects[0].RgbColor(255,0,0); 
					errCount++;
				}
			}		
			
			if (vrfyFlg[17] == "Y" && sheetObjects[0].CellValue(i,'5ft_dys')=="F" && 
				sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd')=="FD"){
				
				if( sheetObjects[0].CellValue(i,'5fm_tr_dys') != "" && sheetObjects[0].CellValue(i,'5to_tr_dys') != ""){ 
					sheetObjects[0].CellBackColor(i,'5fm_tr_dys') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5to_tr_dys') = sheetObjects[0].RgbColor(255,0,0);
					errCount++;		
				}
			}else if (vrfyFlg[17] == "Y" && sheetObjects[0].CellValue(i,'5ft_dys').trim() == "" && 
					sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd')=="FD"){
				
				if( sheetObjects[0].CellValue(i,'5fm_tr_dys') == "" || sheetObjects[0].CellValue(i,'5to_tr_dys') == "" ){ 
					sheetObjects[0].CellBackColor(i,'5fm_tr_dys') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5to_tr_dys') = sheetObjects[0].RgbColor(255,0,0);		
					errCount++;
				} 
			}else if (vrfyFlg[17] == "N"){
				
				if( sheetObjects[0].CellValue(i,'5fm_tr_dys').trim() != "" ||
					sheetObjects[0].CellValue(i,'5to_tr_dys').trim() != "" ){ 
					sheetObjects[0].CellBackColor(i,'5fm_tr_dys') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5to_tr_dys') = sheetObjects[0].RgbColor(255,0,0);		
					errCount++;
				} 
			}
			
			if (vrfyFlg[18] == "Y" && sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd')=="FP"){
				if( sheetObjects[0].CellValue(i,'5fp_calc_prd_cd').trim() == "" ){ 	
					sheetObjects[0].CellBackColor(i,'5fp_calc_prd_cd') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++; 
				}
			}else if (vrfyFlg[18] == "N"){
				if( sheetObjects[0].CellValue(i,'5fp_calc_prd_cd').trim() != "" ){ 
					sheetObjects[0].CellBackColor(i,'5fp_calc_prd_cd') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;			
				} 
			}
			
			if (vrfyFlg[19] == "Y" && sheetObjects[0].CellValue(i,'5tml_sto_agmt_tp_cd')=="FP"){
				if( sheetObjects[0].CellValue(i,'5fp_teu_qty') == 0 ){ 
					sheetObjects[0].CellBackColor(i,'5fp_teu_qty') = sheetObjects[0].RgbColor(255,0,0);	
					errCount++;			
				}else if(sheetObjects[0].CellValue(i,'5teu_rate')==0 && sheetObjects[0].CellValue(i,'5box_rate')==0){
					//sheetObjects[0].CellBackColor(i,'5fp_teu_qty') = sheetObjects[0].RgbColor(255,0,0);	
					sheetObjects[0].CellBackColor(i,'5teu_rate') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5box_rate') = sheetObjects[0].RgbColor(255,0,0);		
					errCount++;					
				} 
			}else if (vrfyFlg[19] == "N"){
				if( sheetObjects[0].CellValue(i,'5fp_teu_qty') > 0 ){ 
					sheetObjects[0].CellBackColor(i,'5fp_teu_qty') = sheetObjects[0].RgbColor(255,0,0);		
					errCount++;		
				}
			}
					
			if (sheetObjects[0].CellValue(i,'5ft_dys') == "F"){
			}else if(sheetObjects[0].CellValue(i,'5ft_dys').trim() == "" ){
				if(vrfyDysSum > 0 ){ 
					sheetObjects[0].CellBackColor(i,'5d2_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5d2_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5d4_fd') = sheetObjects[0].RgbColor(255,0,0);				
					sheetObjects[0].CellBackColor(i,'5d5_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5d7_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5d8_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5d9_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5dw_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5dx_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5r2_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5r4_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5r5_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5r7_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5r8_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5r9_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5f2_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5f4_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5o2_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5o4_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5o5_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5o7_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5s2_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5s4_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5t2_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5t4_fd') = sheetObjects[0].RgbColor(255,0,0);
					sheetObjects[0].CellBackColor(i,'5a2_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5a4_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5a5_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5p2_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5p4_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5c2_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5c4_fd') = sheetObjects[0].RgbColor(255,0,0); 
					sheetObjects[0].CellBackColor(i,'5f5_fd') = sheetObjects[0].RgbColor(255,0,0); 
					errCount++;
				} 
			}

			if(sheetObjects[0].CellValue(i, '5tml_sto_agmt_tp_cd') == "FP"){
				if(sheetObjects[0].CellValue(i,'5fp_calc_prd_cd').trim() == ""){ 
						sheetObjects[0].CellBackColor(i,'5fp_calc_prd_cd') = sheetObjects[0].RgbColor(255,0,0);
				}
			}else	if(sheetObjects[0].CellValue(i, '5tml_sto_agmt_tp_cd') == "FD"){
				if(sheetObjects[0].CellValue(i,'5fp_calc_prd_cd').trim() != ""){ 
						sheetObjects[0].CellBackColor(i,'5fp_calc_prd_cd') = sheetObjects[0].RgbColor(255,0,0);
				}			
			}		
		
			if(sheetObjects[0].CellValue(i, '5tml_sto_agmt_tp_cd') == "FP"){ 
				sheetObjects[0].CellValue(i,'5d2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5d4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5d5_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5d7_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5d8_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5d9_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5dw_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5dx_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5r2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5r4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5r5_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5r7_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5r8_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5r9_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5f2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5f4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5o2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5o4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5o5_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5o7_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5s2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5s4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5t2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5t4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5a2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5a4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5a5_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5p2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5p4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5c2_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5c4_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5f5_fd')      = 0.00;
				sheetObjects[0].CellValue(i,'5d2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5d4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5d5_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5d7_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5d8_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5d9_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5dw_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5dx_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5r2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5r4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5r5_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5r7_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5r8_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5r9_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5f2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5f4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5o2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5o4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5o5_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5o7_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5s2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5s4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5t2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5t4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5a2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5a4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5a5_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5p2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5p4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5c2_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5c4_r')       = 0.00;
				sheetObjects[0].CellValue(i,'5f5_r')       = 0.00;
				//sheetObjects[0].CellValue(i,'5box_rate')   = 0.00;
				//sheetObjects[0].CellValue(i,'5move_rate')  = 0.00; 				
			}
			
			sheetErrCount  = errCount;
			if(errCount>0){
					//break;
			}
			
			vrfyFlg  = "";
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
				if ((sheet.CellValue(i,'5lgs_cost_cd')==null ||sheet.CellValue(i,'5lgs_cost_cd')=='' ||sheet.CellValue(i,'5lgs_cost_cd').trim()=='' ) &&
					(sheet.CellValue(i,'5curr_cd')==null ||sheet.CellValue(i,'5curr_cd')=='' ||sheet.CellValue(i,'5curr_cd').trim()=='') &&
					(sheet.CellValue(i,'5tml_sto_agmt_tp_cd')==null ||sheet.CellValue(i,'5tml_sto_agmt_tp_cd')=='' ||sheet.CellValue(i,'5tml_sto_agmt_tp_cd')==''))   
				{
					sheet.RowDelete(i, false);
				}
			}
		}
	}