
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
						
            switch(srcName) {

                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "dbtn_retrieve":
                    doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
                    break;

    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				break;

    			case "dbtn_new":
    				sheetObject2.RemoveAll();
    				formObject.reset();
    				break;

        	    case "btn_save":
    	                   doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "dbtn_save":
        	               //alert("dbtn_save");
        	               //if(validationSAVE(sheetObject2){ 	
        	               //    alert("dbtn_save OK");    
    	                       doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC02);
        	               //}    
        	           
        	        break;

//        	    case "btn_saveas":
//    	            //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//        	        break;
//
//          	    case "btng_save":
//        	        doActionIBSheet(sheetObject,formObject,IBSAVE);
//        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
    	            if (sheetObject.CellValue(sheetObject.RowCount-1, "r_cop_expt_tp_cd")=="TypeSEQ") {
    	                sheetObject.CellValue2(sheetObject.RowCount, "r_cop_expt_tp_cd") = 1;
    	            }else {
        	            sheetObject.CellValue2(sheetObject.RowCount, "r_cop_expt_tp_cd") = eval(sheetObject.CellValue(sheetObject.RowCount-1, "r_cop_expt_tp_cd"))+1;
    	            }
        	        break;

        	    case "dbtng_rowadd":
    	            doActionIBSheet(sheetObject2,formObject,IBINSERT);
        	        break;

        	    case "btn_downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "dbtn_downexcel":
    	            doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComShowCodeMessage('COM12111') ;
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = 175 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    InitHeadMode(true, true, true, true, false,false);

                    //var HeadTitle = "Del.|STS|Exception Type|Description|Exception Category" ;
										var HeadTitle = "Del.|STS|SEQ|Exception Type|Exception Type Description|User ID|Updated Date|Active" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   false,    "r_seq",               false,         "",       dfNone,   	0,          true,       true);
										InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,   false,   "rDelCheck",           false,         "",       dfNone,   	0,          true,       true);
										InitDataProperty(0, cnt++ , dtStatus,        30,    daCenter,   false,   "r_ibflag",            false,         "",       dfNone,   	0,          true,       true);
                    //InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   false,    "r_seq",               false,         "",       dfNone,   	0,          true,       true);
										InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	false,	"r_cop_expt_tp_cd",		false,          "",       dfNone,   	0,			false,       false,		2);
										InitDataProperty(0, cnt++ , dtData,			230,	daLeft,		false,	"r_cop_expt_tp_nm",		true,          "",       dfEngKey,   	0,			true,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			450,	daLeft,		false,	"r_cop_expt_tp_desc",	true,          "",       dfEngKey,	0,			true,       true,		500);
										InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"r_usr_id",	         	false,         "",       dfNone,   	0,			false,      false,		20);
										InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"r_upd_dt",		        false,         "",       dfNone,   	0,			false,      false,		20);
                    InitDataProperty(0, cnt++ , dtCombo,		 40,	daCenter,	false,	"r_act_flg",			false,          "",       dfNone,	0,			true,       false);
                    
                    var nums    = "1234567890" ;
                    var spChars = "!@#$%^&*()_+<>?,./'\" " ;
                    
                    InitDataValid(0, 2, vtEngOther, nums);
                    InitDataValid(0, 3, vtEngOther, nums + spChars);
                    InitDataValid(0, 4, vtEngOther, nums + spChars);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo (0, "r_act_flg", "Y|N", "Y|N");
               }
                break;
            case 2:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = 300 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 16, 200);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                     InitHeadMode(true, true, true, true, false,false);




                    //var HeadTitle = "Del.|STS|Exception Type|Description|Exception Category" ;
					//var HeadTitle1 = "Del.|STS|TypeSEQ|Exception Type|Detail TypeSEQ|Exception Type Detail|Exception Type Detail Description|From-Activity(1)|From-Activity(1)|To-Activity(2)|To-Activity(2)|User ID|Updated Date|Active" ;
					//var HeadTitle2 = "Del.|STS|TypeSEQ|Exception Type|Detail TypeSEQ|Exception Type Detail|Exception Type Detail Description|Activity|Description|Activity|Description|User ID|Updated Date|Active" ;
					var HeadTitle1 = "Del.|STS|SEQ|Exception Type||Exception Type Detail|Exception Type Detail Description||From-Activity(1)|From-Activity(1)||To-Activity(2)|To-Activity(2)|User ID|Updated Date|Active" ;
					//var HeadTitle2 = "Del.|STS|TypeSEQ|Exception Type|Detail TypeSEQ|Exception Type Detail|Exception Type Detail Description|Activity|Description|Activity|Description|User ID|Updated Date|Active" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true); 

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,   true,   "fDelCheck",           false,         "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtStatus,        30,    daCenter,   true,   "f_ibflag",            false,         "",       dfNone,   	0,          true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtCombo,	    180,	daLeft,	true,	"f_cop_expt_tp_cd",     true,          "",       dfNone,   	0,			false,       true);
					//InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	"f_cop_expt_tp_nm",		false,          "",       dfNone,   	0,			false,       false,		300);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,	    daCenter,	false,	"f_cop_expt_tp_dtl_cd", false,          "",       dfNone,   	0,			false,       false,		3);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"f_cop_expt_tp_dtl_nm",		true,          "",       dfEngKey,   0,			true,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"f_cop_expt_tp_dtl_desc",	true,          "",       dfEngKey,	0,			true,       true,		500);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,  	daLeft,	    true,	"f_fm_expt_cd",	        false,         "",       dfNone,   	0,			    true,       true);
					InitDataProperty(0, cnt++ , dtCombo,		80,  	daLeft,	    true,	"f_fm_act",	         	true,         "",       dfNone,   	0,			    true,       true);
					InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	"f_fm_act_nm",		    false,          "",       dfNone,   	0,			false,       false,		300);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,  	daLeft,	    true,	"f_to_expt_cd",	        false,         "",       dfNone,   	0,			    true,       true);
					InitDataProperty(0, cnt++ , dtComboEdit,	80,  	daLeft,	    true,	"f_to_act",	         	false,         "",       dfNone,   	0,			    true,       true);
					InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	"f_to_act_nm",		    false,          "",       dfNone,   	0,			false,       false,		300);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"f_usr_id",	         	false,         "",       dfNone,   	0,			false,     false,		20);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"f_upd_dt",		        false,         "",       dfNone,   	0,			false,     false,		20);
                    InitDataProperty(0, cnt++ , dtCombo,		40,	    daCenter,	true,	"f_act_flg",			false,          "",       dfNone,	0,			true,       false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,		0,  	daLeft,	    true,	"f_validation",	        false,         "",       dfNone,   	0,			    true,       true);
                    //InitDataProperty(0, cnt++ , dtDataStatus,	 30,	daLeft,		false,	"f_cop_expt_tp_desc",	true,          "",       dfEngKey,	0,			true,       true,		500);
                    
                    var nums    = "1234567890" ;
                    var spChars = "!@#$%^&*()_+<>?,./'\" " ;

//추후 입력 Validation이 필요한 경우                    
//                    InitDataValid(0, 3, vtEngOther, nums + spChars);
//                    InitDataValid(0, 4, vtEngOther, nums + spChars);
//                    InitDataValid(0, 5, vtEngOther, nums + spChars);

    				//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
    				InitDataCombo (0, "f_cop_expt_tp_cd"  , " |" + copExptTpText  , " |" + copExptTpCode);
    				InitDataCombo (0, "f_fm_act" , " |" + actCDText, " |"+actCDCode);
    				InitDataCombo (0, "f_to_act" , " |" + actCDText, " |"+actCDCode);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo (0, "f_act_flg", "Y|N", "Y|N");
                    
               }
                break;                
        }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
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



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObject2 = sheetObjects[1];

        switch(sAction) {

           case IBSEARCH:      //조회(Exception Type)
                 formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_SCE_0026Search.do", SceFrmQryString(formObj)+ "&" + ComGetPrefixParam("r_"));

                break;

           case IBINSERT:      // 입력
                 sheetObj.DataInsert(-1);

                break;

            case IBSAVE:        //저장
            //alert("저장"+SceFrmQryString(formObj));
                formObj.f_cmd.value = MULTI;
                //alert(sheetObj.CellValue(5, "r_act_flg"));
                sheetObj.DoSave("ESD_SCE_0026Search.do", SceFrmQryString(formObj));
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_SCE_0026Search.do", SceFrmQryString(formObj)+ "&" + ComGetPrefixParam("r_"));

				break;

           case IBDOWNEXCEL:        //엑셀 다운로드

              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBSEARCH_ASYNC01:						//조회(Exception Type Detail)
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch4Post("ESD_SCE_0026GS2.do", SceFrmQryString(formObj)+ "&" + ComGetPrefixParam("f_"));
              break;  
          
           case IBSEARCH_ASYNC02:
           			formObj.f_cmd.value = MULTI01;
                sheetObj.DoSave("ESD_SCE_0026GS2.do", SceFrmQryString(formObj));
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch4Post("ESD_SCE_0026GS2.do", SceFrmQryString(formObj)+ "&" + ComGetPrefixParam("f_"));
              break;    
           case IBSEARCH_ASYNC03:
                formObj.f_cmd.value = SEARCH03;
                //alert("IBSEARCH_ASYNC03 "+SceFrmQryString(formObj));
                sheetObj.DoSearch4Post("ESD_SCE_0026GS2.do", SceFrmQryString(formObj)+ "&" + ComGetPrefixParam("f_"));
              break;   

        }
    }
    
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg==""){
			var formObj = document.form ;
			doActionIBSheet(sheetObj,formObj,IBSEARCH) ;
			doActionIBSheet(sheetObj, null, formObj, IBSEARCH) ;
			ComShowCodeMessage('SCE90005') ;
		}
	}
	
	function sheet1_OnChange(sheetObj, row, col){
//		var colName = sheetObj.ColSaveName(col) ;
//		//alert("onchange");
//		if(colName=="r_cop_expt_tp_cd"){
//			if(sheetObj.CellValue(row,col)=="00"){
//				showErrMessage(getMsg('SCE90029', "Exception Type", "00")) ;
//				sheetObj.CellValue(row,col) = "" ;
//				sheetObj.SelectCell(row,col) ;
//			}
//		}
	}
		
		/* sheet[0] 데이터 더블 클릭 시  */
    function sheet1_OnDblClick(Row,Col){
      if(Col>0){
      		document.form.f_expt_tp.value=Col;
      		//alert("sheet1_OnDblClick "+document.form.f_expt_tp.value);
          doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC03);
      }
    } 
    
	function sheet2_OnChange(sheetObj, row, col){
			// Exception Type Name 세팅 & To-Activity CellEditable 세팅
    	if(sheetObj.ColSaveName(col) == "f_cop_expt_tp_cd"){//col==3
    		//입력가능 필드 체크
//    		alert("cellText = " + sheetObj.CellText(row, col) + " / cellValue = " + sheetObj.CellValue(row, col));
    		if(sheetObj.CellValue(row, col)=="2"){ 
    		    sheetObj.CellValue2(row, "f_to_act") = ''; // 11
    		    sheetObj.CellValue2(row, "f_to_act_nm") = ''; // 12
    		    sheetObj.CellEditable(row, "f_to_act") = false; //11
    		}else{
    		    sheetObj.CellEditable(row, "f_to_act") = true; //11
    		}
    	}else if(sheetObj.ColSaveName(col) == "f_fm_act" || sheetObj.ColSaveName(col) == "f_to_act"){ // col==8||col==11
    	    sheetObj.CellValue2(row, col+1) = actCDNames[sheetObj.CellValue(row, col)] ;
    	    
    	    if(sheetObj.CellValue(row, "f_ibflag")=='I' || sheetObj.CellValue(row, "f_ibflag")=='U'){
    	        if(ComIsEmpty(sheetObj.CellValue(row, "f_cop_expt_tp_dtl_nm"))){
                    ComShowMessage('Please input Exception Type Detail') ;
                    sheetObj.SelectCell(row, "f_cop_expt_tp_dtl_nm", false); 
                    return false ;
                }else if(ComIsEmpty(sheetObj.CellValue(row, "f_cop_expt_tp_dtl_desc"))){
                    ComShowMessage('Please input Exception Type Detail Description') ;
                    sheetObj.SelectCell(row, "f_cop_expt_tp_dtl_desc", false); 
                    return false ;
                }else if(ComIsEmpty(sheetObj.CellValue(row, "f_fm_act"))){
                    ComShowMessage('Please input From Activity') ;
                    sheetObj.SelectCell(row, "f_fm_act", false); 
                    return false ;
                }else if(ComIsEmpty(sheetObj.CellValue(row, "f_to_act")) && sheetObj.CellValue(row, 3)=="1" && col==11 ){
                    ComShowMessage('Please input To Activity') ;
                    sheetObj.SelectCell(row, "f_to_act", false); 
                    return false ;
                }else if((sheetObj.CellValue(row, "f_cop_expt_tp_cd")=="1" && sheetObj.ColSaveName(col) == "f_to_act") 
                		|| (sheetObj.CellValue(row, "f_cop_expt_tp_cd")!="1" && sheetObj.ColSaveName(col) == "f_fm_act")){ // 3, 11, 3, 2
                    //Rowsearch start : Max Code Data for input data of Exception Type 2 
                    var param  = "f_cmd="    + SEARCH ;
		            		param += "&row="      + row ;
		            		param += "&col="      + col ;
		            		param += "&fm_expt_tp_cd=" + sheetObj.CellValue(row, "f_cop_expt_tp_cd");
		            		param += "&fm_expt_tp_dtl_nm=" + sheetObj.CellValue(row, "f_cop_expt_tp_dtl_nm");
		            		param += "&fm_expt_tp_dtl_desc=" + sheetObj.CellValue(row, "f_cop_expt_tp_dtl_desc");
		            		param += "&fm_act=" + sheetObj.CellValue(row, "f_fm_act");
		            		param += "&to_act=" + sheetObj.CellValue(row, "f_to_act");
		            		param += "&f_cop_expt_tp_dtl_cd=f_cop_expt_tp_dtl_cd";
		            		param += "&f_fm_expt_cd=f_fm_expt_cd";
		            		param += "&f_to_expt_cd=f_to_expt_cd";
		            		param += "&f_validation=f_validation";            
		            		
		            		//sheetObj.DoRowSearch ("ESD_SCE_0026GS3.do", param);
		            		var sXml = sheetObj.GetSearchXml("ESD_SCE_0026GS3.do", param);
										var f_fm_expt_cd_val = ComGetEtcData(sXml, "f_fm_expt_cd");
										var f_validation_val = ComGetEtcData(sXml, "f_validation");
										var f_cop_expt_tp_dtl_cd_val = ComGetEtcData(sXml, "f_cop_expt_tp_dtl_cd");
										var f_to_expt_cd_val = ComGetEtcData(sXml, "f_to_expt_cd");
		            		
		            		sheetObj.CellValue2(row, "f_fm_expt_cd") = f_fm_expt_cd_val;
		            		sheetObj.CellValue2(row, "f_validation") = f_validation_val;
		            		sheetObj.CellValue2(row, "f_cop_expt_tp_dtl_cd") = f_cop_expt_tp_dtl_cd_val;
		            		sheetObj.CellValue2(row, "f_to_expt_cd") = f_to_expt_cd_val;
		            		
		            		//alert("fmexpt:"+sheetObj.CellValue(row, "f_fm_expt_cd"));
		            		//alert("fmexpt:"+sheetObj.CellValue(row, "f_fm_expt_cd")+"toexpt:"+sheetObj.CellValue(row, "f_to_expt_cd")+" validation:"+sheetObj.CellValue(row, "f_validation"));
		            		if(sheetObj.CellValue(row, "f_validation")=="Y"){
		                        ComShowMessage( "SEQ "+row+"  Data Duplicated.") ;	
		                        sheetObj.SelectCell(row, col, false);             		         
            				}
            		
                }
    	    }
    	}
    	
    function validationSAVE(sheetObj){
        alert("-1");
        var result = true;
        alert("0");
        for(i=0; i<sheetObj.RowCount; i++){
            if(sheetObj.CellValue(i,"f_ibflag")=="I" && sheetObj.CellValue(i,"f_validation")=="Y"){
                alert("1");
                ComShowMessage( "SEQ "+i+"  Data Duplicated.") ;
                alert("2");
                sheetObj.SelectRow(i,false);
                alert("3");
                result = false;
            }        
            
        }
        
        alert(result);
        return result;
    }    	
    	
    	
    	//Row Validation
//        if(sheetObj.CellValue(row, "f_ibflag")=='I' && ){

    		// Max Exception Type Detail SEQ 구하기
//    		var param  = "f_cmd="    + SEARCH ;
//    		param += "&row="      + row ;
//    		param += "&cop_expt_tp_dtl_cd=cop_expt_tp_dtl_cd" ;
//    		param += "&cop_expt_tp_cd="    + sheetObj.CellValue(row, "f_cop_expt_tp_cd") ;
//    		
//    		sheetObj.DoRowSearch ("ESD_SCE_0026GS3.do", param);

    		//DoRowSearch("grid_rowdata.jsp", "id=1234&Row="+Row, false);

//            if(isEmpty(sheetObj.CellValue(sheetObj.SelectRow, "f_cop_expt_tp_cd"))){
//                showErrMessage('Please input Exception Type') ;
//                sheetObj.SelectCell(row, "f_cop_expt_tp_cd", false); 
//                result = false ;
//            }else if(isEmpty2(sheetObj.CellValue(sheetObj.SelectRow, "f_cop_expt_tp_dtl_nm"))){
//                showErrMessage('Please input Exception Type Detail') ;
//                sheetObj.SelectCell(row, "f_cop_expt_tp_dtl_nm", false); 
//                result = false ;
//            }else if(isEmpty2(sheetObj.CellValue(sheetObj.SelectRow, "f_cop_expt_tp_dtl_desc"))){
//                showErrMessage('Please input Exception Type Detail Description') ;
//                sheetObj.SelectCell(row, "f_cop_expt_tp_dtl_desc", false); 
//                result = false ;
//            }else if(isEmpty2(sheetObj.CellValue(sheetObj.SelectRow, "f_fm_act"))){
//                showErrMessage('Please input From Activity') ;
//                sheetObj.SelectCell(row, "f_fm_act", false); 
//                result = false ;
//            }else if(isEmpty2(sheetObj.CellValue(sheetObj.SelectRow, "f_to_act")) && sheetObj.CellValue(sheetObj.SelectRow, "f_cop_expt_tp_cd")==1){
//                showErrMessage('Please input To Activity') ;
//                sheetObj.SelectCell(row, "f_to_act", false); 
//                result = false ;
//            }                  
//        }           
    	
    	
	}



//    function sheet2_CellComboItem(row, col, ComboText, ComboCode){
//        sheetObj.CellValue2(row, col) = actNames[sheetObj.CellValue(row, col).substring(3,7)];
//        alert();
//    } 