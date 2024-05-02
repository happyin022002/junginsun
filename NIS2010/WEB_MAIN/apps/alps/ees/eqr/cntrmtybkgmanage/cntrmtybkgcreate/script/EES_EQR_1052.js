/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1052.js
*@FileTitle : Empty Bkg Container List
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.08.07
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.08.07 신용찬
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
     * @class EES_EQR_1052 : EES_EQR_1052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1052() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	//this.setTabObject 			= setTabObject;
    	//this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
    function processButtonClick() {
    	
        // 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용
        var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var formObject   = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		if(!ComIsBtnEnable(srcName) ) return;

            switch(srcName) {
     	        case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,SEARCH01);
        	        break;

				case "btn_new":
					sheetObject.RemoveAll();   // 왼쪽 그리드 제거
					sheetObject1.RemoveAll();  // 오른쪽 드리드 제거
					formObject.pod_yd_cd.RemoveAll(); // POD YD COMBO 제거
					formObject.bkg_no.RemoveAll();    // BKG NO COMBO 제거 
					
					formObject.reset();
					
					break;

				case "btn_print":
					ComShowMessage("print button Click!!");
					break;

				case "btn_downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	            if(sheetObject1.RowCount('') > 0){
    	               doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
    	            }
					
					break;
					
                case "btng_formatexceldown":
                    location.href="apps/alps/ees/eqr/cntrmtybkgmanage/cntrmtybkgcreate/jsp/EES_EQR_1052DL.jsp";
                    break;    
                    
				case "btng_loadexcel":
				  	// vvd 입력여부 확인
					
					if(formObject.vvd.value == "") {
						ComShowCodeMessage("EQR01133"); //Please input VVD Code value.
						formObject.vvd.focus();
						return false;
					}					
					// 그리드 제거할지 확인
				  	if(ComShowConfirm(ComGetMsg("EQR01132"))) {  // Load Excel will reset search grid
				  		// 왼쪽, 오른쪽 그리드 모두 제거
				  		sheetObjects[0].RemoveAll();
				  		sheetObjects[1].RemoveAll(); 
				  		   
		                sheetObject.LoadExcel();
				  	}					

                    break;					

                
                // 중간 add 버튼    
        	    case "btns_add":
        	    	
        	    	ComOpenWait(true); 
        	    	
                    for( i=1; i < sheetObject.RowCount+1; i++) {
                        if(sheetObject.CellValue(i, "t0_sel")==1 && sheetObject.CellValue(i, "t0_vrfy_status")=="OK") {  // SEL 선택되고 VRFY STATUS = OK 인 경우만 오른쪽 이동
                        
							// sheet2에 존재하는 데이타인지 확인
							var t0_cntr_no  = sheetObject.CellValue(i, "t0_cntr_no");
							var count = sheetObject1.FindText("cntr_no", t0_cntr_no);  // 동일 컨네이너 찾기(결과 -1만 중복 아님)

							/*
							for(j=1; j<sheetObject1.RowCount+1; j++) {
								//alert(j +" : "+sheetObject1.CellValue(j, 2));
								if(t0_cntr_no==sheetObject1.CellValue(j, "cntr_no")) {
									count++;
									break;
								}
							}
							*/
						    
						    // sheet2에 존재하지 않으면 옮기는 작업 수행 (-1 : 미존재, 나머지 : 존재)
						    if(count == -1) {                    
			  	            	row = sheetObject1.DataInsert(-1);
        			  	  		sheetObject1.CellValue2(row, "chk") 		=  1;  // 선택상태
        			  	  		sheetObject1.CellValue2(row, "vl_bkg_no") 	=  sheetObject.CellValue(i, "t0_vl_bkg_no");
        			  	  		sheetObject1.CellValue2(row, "cntr_no") 	=  sheetObject.CellValue(i, "t0_cntr_no");
        			  	  		sheetObject1.CellValue2(row, "cntr_tpsz_cd")=  sheetObject.CellValue(i, "t0_cntr_tpsz_cd");
        			  	  		sheetObject1.CellValue2(row, "vd_bkg_no") 	=  "";
        			  	  		sheetObject1.CellValue2(row, "pol_yd") 		=  sheetObject.CellValue(i, "t0_pol_yd_cd");
        			  	  		sheetObject1.CellValue2(row, "clpt_seq") 	=  sheetObject.CellValue(i, "t0_clpt_seq"); 
        			  	  		sheetObject1.CellValue2(row, "mvmt_sts_cd") =  sheetObject.CellValue(i, "t0_mvmt_sts_cd");         			  	  		

        			  	  		sheetObject1.CellValue2(row, "vsl_cd") 		=  sheetObject.CellValue(i, "t0_vsl_cd");   
        			  	  		sheetObject1.CellValue2(row, "skd_voy_no") 	=  sheetObject.CellValue(i, "t0_skd_voy_no");   
        			  	  		sheetObject1.CellValue2(row, "skd_dir_cd") 	=  sheetObject.CellValue(i, "t0_skd_dir_cd");   
        			  	  		        	                    		
							}
        			    }
			      	}
                    
                    ComOpenWait(false); 
                    
                    break;
                
                // 왼쪽 그리드 row insert
        	    case "btng_rowadd":
					if(formObject.vvd.value == "") {
						ComShowCodeMessage("EQR01133");  //Please input VVD Code value.
						formObject.vvd.focus();
						return false;
					}
					
			  	    sheetObject.DataInsert(0);  // 맨위에 입력
			  	    sheetObject.CellEditable(1, "t0_cntr_no") = true; 

                    break;                    

                // 중간 del 버튼 (오른쪽 그리드)    
        	    case "btns_del":
                    var selrow = sheetObject1.SelectRow;
                    if(selrow > 0) {
                    
                    	for( i=sheetObject1.RowCount; i > 0; i--) {
                        	if(sheetObject1.CellValue(i, "chk")==1) {						
								// sheet2의 해당row삭제
                        		sheetObject1.RowDelete(i, false);   
                        	}
                        }
                    }
        	       
                    break;
                    
                    // 왼쪽 del 버튼 (왼쪽 그리드)    
        	    case "btng_rowdel":
                    var selrow = sheetObject.SelectRow;
                    if(selrow > 0) {
                    
                    	for( i=sheetObject.RowCount; i > 0; i--) {
                        	if(sheetObject.CellValue(i, "t0_sel")==1) {						
								// sheet1의 해당row삭제
                        		sheetObject.RowDelete(i, false);   
                        	}
                        }
                    }
        	       
                    break;                    

				case "btng_splitbkgcre":
					
					goMtyBkgSplit();
					break;
            } // end switch
           
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
    			ComShowCodeMessage("EQR90004");
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
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetObject = sheetObjects[0];               
        var formObject = document.form;   		

   		var flag    = formObject.flag.value;
   		var vvd     = formObject.vvd.value;
   		var bkg_no  = formObject.bkg_no.value;   	
   		var open_flag_rob = formObject.open_flag_rob.value;   	

   		if(flag == "S" ) {  // 1018에서 VVD, BKG NO 를 결정하고 들어온 경우 (single)
   		    // LOAD EXCEL, ROW ADD, ROW DEL 비활성화
   			ComBtnDisable("btn_retrieve");   // retrieve
   			ComBtnDisable("btn_new");
   			
   			//CSR : CHM-201538794, VD Split Pop-up 화면 내 Excel File Upload/Download 기능 활성화
   			//ComBtnDisable("btng_formatexceldown");     		   			
   			//ComBtnDisable("btng_loadexcel");   
   			
   			ComBtnDisable("btng_rowadd");    			
   			ComBtnDisable("btng_rowdel");  
   			
   			if(open_flag_rob=="Y") {  // ROB BKG
   				formObject.flag_rob.checked=true;
   				formObject.vvd_rob.Enable = true;
   				searchVVDROB();      // ROB VVD 정보 조회(현재 VVD의 +5개까지 조회)
   			}else {                  // ROB BKG 아닌 평범한 BKG
   				formObject.vvd_rob.Enable = false;
   				searchPodCode();      // 우측하단 pod,eta 정보 조회
   				
   			}
   			   			
   			doActionIBSheet(sheetObject,formObject,IBSEARCH);  // 왼쪽 그리드 조회
   			
   			
   			
   		}else { // flag = "M"
   			//formObject.vvd.readOnly = false;
   		}
   		
   		// BKG NO 없으면 LOAD EXCEL 비활성화

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
                    // 높이 설정
            		var row_num = 14; // single booking
            		
//            		if(document.form.flag.value == "M") row_num = 14; // multi booking
//            		else                                row_num = 15; // single booking
            		
                    style.height = GetSheetHeight(row_num) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false ,false)

                    var HeadTitle = "SEQ|Sel|CNTR No.|TP/SZ|VL BKG No|Verify|MVMT|POL|POD" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false );
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, 		KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,  daCenter,  false,      "",      		false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,  daCenter,  false,    "t0_sel",     		false,      "",       dfNone,   	    0,        true,       true);

                    InitDataProperty(0, cnt++ , dtData,      100,  daLeft,    false,    "t0_cntr_no",      false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,  daLeft,    false,    "t0_cntr_tpsz_cd", false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,       90,  daLeft,    false,    "t0_vl_bkg_no",    false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,  daLeft,    false,    "t0_vrfy_status",  false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,  daLeft,    false,    "t0_mvmt_sts_cd",  false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,  daLeft,    false,    "t0_pol_yd_cd",   	false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,  daLeft,    false,    "t0_pod_yd_cd",      	false,      "",       dfNone,   		0,        false,      true);
                    
                    // HIDDEN AREA
                    InitDataProperty(0, cnt++ , dtHidden,     60,  daLeft,    false,    "t0_vps_etd_dt",   false,      "",       dfUserFormat,   	0,        false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     60,  daLeft,    false,    "t0_clpt_seq",     false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     60,  daLeft,    false,    "t0_vsl_cd",     false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     60,  daLeft,    false,    "t0_skd_voy_no",     false,      "",       dfNone,   		0,        false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     60,  daLeft,    false,    "t0_skd_dir_cd",     false,      "",       dfNone,   		0,        false,      true);

                    
                    sheetObj.InitUserFormat(0, "t0_vps_etd_dt", "####-##-## ##:##:##", "-|:" );

                }
                break;
            case 2:      //IBSheet2 init
                with (sheetObj) {
                    // 높이 설정
        			var row_num = 14; // single booking
        		
//        			if(document.form.flag.value == "M") row_num = 14; // multi booking
//        			else                                row_num = 15; // single booking
        		
                    style.height = GetSheetHeight(row_num) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "SEQ|Sel|VL BKG No|CNTR No|TP/SZ|VD BKG No" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false , false);
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,       		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,          30,  daCenter,  false,    "seq",  			false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtCheckBox,     40,  daCenter,  true,     "chk",           	false,          "",       dfNone,           0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         90,  daLeft,    false,    "vl_bkg_no",    	false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,         90,  daLeft,    false,    "cntr_no",  		false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,         50,  daLeft,    false,    "cntr_tpsz_cd",  	false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,         90,  daLeft,    false,    "vd_bkg_no",  	false,          "",       dfNone,   		0,     false,      true);
                    
                    // HIDDEN AREA                    
                    InitDataProperty(0, cnt++ , dtHidden,       50,  daLeft,    false,    "mvmt_sts_cd",  	false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,       90,  daLeft,    false,    "pol_yd",  	    false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "clpt_seq",  		false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "vsl_cd",  		false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "skd_voy_no",  		false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "skd_dir_cd",  		false,          "",       dfNone,   		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  true,     "ibflag");  
                }
                break;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      // 왼쪽 그리드 조회 (SINGLE BKG 오픈시 자동조회)
                	                	
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch("EES_EQR_1052GS.do", eqrFormQryStr(formObj));

                break;
                
           case SEARCH01:      // RETRIEVE 버튼 클릭        	   
               
           		formObj.vvd.value = formObj.vvd.value.toUpperCase();  // 대문자변환  	

           		if(formObj.vvd.value == null || formObj.vvd.value == "") {
           			ComShowCodeMessage("EQR01129");  //VVD Code is a mandatory item for inquiry.
           			formObj.vvd.focus();
         	   		return false;
           		}else if(formObj.vvd.value.length != 9) { 
           			//Please enter ' + msg1 + ' digits long data.
           			ComShowCodeMessage("EQR90078","9");//9 자리로 입력하세요.
           			return false;
           		}    
               
                // 오른쪽 그리드 제거
                sheetObjects[0].RemoveAll();
               
                formObj.f_cmd.value = SEARCHLIST01;
               	sheetObj.DoSearch("EES_EQR_1052GS.do", eqrFormQryStr(formObj));

               
               break;       
               
			case SEARCH02: // VVD 의 VL BKG NO 콤보 리스트 조회
                formObj.f_cmd.value = SEARCH02; 
                var sXml = sheetObj.GetSearchXml("EES_EQR_1052GS.do" , FormQueryString(formObj)+"&vvd="+formObj.vvd.value);

                ComXml2ComboItem(sXml, formObj.bkg_no, "bkg_no_cd", "bkg_no");
				if(ComGetTotalRows(sXml)*1>0){
				    bkgCdList = ComXml2ComboString(sXml,"code", "name")[0];	
				}
				formObj.bkg_no.Index = 0; // 첫번째 combo 를 강제 선택
				
				break;	                 
                
			case SEARCH03: // LOD_CD 콤보 리스트 조회
                formObj.f_cmd.value = SEARCH03;
                var sXml = "";
                
                if(formObj.flag.value == "S") { // SINGLE split (ROB SPLIT 포함)
                	sXml = sheetObj.GetSearchXml("EES_EQR_1052GS.do" , FormQueryString(formObj)+"&vvd="+formObj.vvd.value+"&vvd_rob="+formObj.vvd_rob.Code+"&open_flag_rob="+formObj.open_flag_rob.value);
                }else {  // MULTI SPLIT
                	sXml = sheetObj.GetSearchXml("EES_EQR_1052GS.do" , FormQueryString(formObj)+"&vvd="+formObj.vvd.value+"&open_flag_rob="+formObj.open_flag_rob.value);                	
                }

                ComXml2ComboItem(sXml, formObj.pod_yd_cd, "to_etb_dt", "to_yd_cd");
				if(ComGetTotalRows(sXml)*1>0){
				    lccCdList = ComXml2ComboString(sXml,"code", "name")[0];	
				}
				
				break;	   
				
			case SEARCH06: // ROB VVD 콤보 리스트 조회
                formObj.f_cmd.value = SEARCH06; 

                var sXml = sheetObj.GetSearchXml("EES_EQR_1052GS.do" , FormQueryString(formObj)+"&vvd="+formObj.vvd.value);

                ComXml2ComboItem(sXml, formObj.vvd_rob, "vvd_nm", "vvd_cd");
				if(ComGetTotalRows(sXml)*1>0){
				    vvdCdList = ComXml2ComboString(sXml,"code", "name")[0];	
				}
				
				break;	   				
					

            case IBSAVE:        //BKS SPLIT 실행
			
             	formObj.f_cmd.value = MULTI;
             	sheetObj.DoSave("EES_EQR_1052GS.do", eqrFormQryStr(formObj));

                break;
                
			case IBDOWNEXCEL:        // excel down

				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case IBLOADEXCEL:        // excel down                
                
				break;

        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            
			case IBDOWNEXCEL:        // excel down

				sheetObj.Down2Excel(-1, true, true, true);
				break;

			case IBLOADEXCEL:        // excel down

                var i = 0;
                var j = 0;
                var excel_cntr_no = "";
                  
                // 화면OPEN 시 이미 선택한 CNTR_List가 있을 경우 Excel Data ADD한다. 
    			//if(sheetObj.LoadExcel(0, 1, "", -1, -1, "", false)) {   //LoadExcel 확인해서 data가져온 경우에 해당 data 조회해 옴. 								          
    			if(sheetObj.LoadExcel(0)) {   //LoadExcel 확인해서 data가져온 경우에 해당 data 조회해 옴. 								          
    				formObj.f_cmd.value = SEARCHLIST02;
                      
                    for(i=1; i<sheetObj.rowcount+1; i++) {
                    	excel_cntr_no += sheetObj.CellValue(i, "t0_cntr_no") + ((i == sheetObj.rowcount ) ? "" : ",");
            	    }            	                	                	    
            	    
                    // [CHM-201324038] Container No 가 없는 경우는 조회중지
            	    if(replaceAll(excel_cntr_no, ",", "") == "" || replaceAll(excel_cntr_no, ",", "") == null) {
            	    	ComShowCodeMessage("EQR90092");  //Please check Container No and enter again.
            	    }else {
            	    	formObj.excel_cntr_no.value = excel_cntr_no;
                       	sheetObj.DoSearch4Post("EES_EQR_1052GS.do", eqrFormQryStr(formObj));         
                    }				
    			}	
    			
				break;


        }
    }    
    
    // sheet2에 표현된 cntr no, cntr type, cntr status 정보를 059로 적용
    // t0_cntr_no     --> t1_cntrno
    // cntr_tpsz   --> t1_tpszno
    // cntr_status --> t1_cntrstatus
	function goMtyBkgSplit() {

		var formObject = document.form;
		var sheetObj   = sheetObjects[1];          // 오른쪽 sheet		
		
		if(sheetObj.RowCount > 0) {
			// pod yd, etb 선택 여부 확인			
			var pod_yd_cd 		= formObject.pod_yd_cd.Text;
			var to_etb_dt 		= formObject.to_etb_dt.value;
			var pod_clpt_ind_seq= formObject.pod_clpt_ind_seq.value;
			
			if(pod_yd_cd=="" || to_etb_dt=="" || pod_clpt_ind_seq=="" ) {
				ComShowCodeMessage("EQR01126"); 
				return false;
			}
			
			// ETB > ETD 인지 여부 확인
			var pol_call_seq = null;
			var pod_call_seq = null;
			var chk_result   = "T";
			
			if(formObject.pod_yd_cd.Code != null) {
				pod_call_seq = formObject.pod_yd_cd.Code.split("%%")[2] * 1; // 숫자로 변형
			}
						
			for(j=1; j<sheetObjects[1].RowCount+1; j++) {
				pol_call_seq = sheetObjects[1].CellValue(j, "clpt_seq") * 1; // 숫자로 변형
				
				if(formObject.open_flag_rob.value == "N") { // ROB 가 아니면 POL-POD 역순 검사합니다.
					if(pod_call_seq <= pol_call_seq) {  // pol yd cd 의 t0_clpt_seq 가 더 크거나 같으면 
						chk_result="F"
							ComShowCodeMessage("EQR01134"); // POD Yard must be later than POL Yard.
						formObject.pod_yd_cd.Text 			= "";
						formObject.pod_yd_cd.Code 			= "";
						formObject.to_etb_dt.value 			= "";
						formObject.pod_clpt_ind_seq.value 	= "";
					
						break;
					}
				}
				
				if(sheetObjects[1].CellValue(j, "vd_bkg_no") != "") { //vd_bkg_no 가 존재하면 이미 split 완료된것이므로 중지
					chk_result="F"
					ComShowCodeMessage("EQR01122"); // Selected data is already exist Repo BKG No.
						
					break;					
				}
					
			}
			
			if(chk_result=="F") return false;  // ETB > ETD 이면 SPLIT 중지  
						
			// BKG SPLIT NO 생성
            doActionIBSheet( sheetObjects[1], formObject,IBSAVE);
            // 오른쪽 그리드 조회
            //
    						
		}else {
			ComShowCodeMessage("EQR90063");  // 선택된 데이타가 없습니다.
		}							
	
	}
	
	/*
	 * POD CODE 검색
	 */
	function searchPodCode() {
        doActionIBSheet(sheetObjects[0],document.form,SEARCH03);		
	}
	
	/*
	 * ROB 의 VVD 검색
	 */
	function searchVVDROB() {
        doActionIBSheet(sheetObjects[0],document.form,SEARCH06);		
	}	
	
	/*
	 * pod code 변경시 이벤트 발생
	 */
    function pod_yd_cd_OnChange() {
    	var formObject = document.form;
	
    	
    	// 선택된 pod 의 날짜 표기
    	formObject.to_etb_dt.value = formObject.pod_yd_cd.Code.split("%%")[1]; 
    	// clpt ind seq 선택
    	formObject.pod_clpt_ind_seq.value = formObject.pod_yd_cd.Code.split("%%")[3]; 
	    
    	// ETB > ETD 인지 여부 확인
    	var pol_call_seq = null;
    	var pod_call_seq = null;
    	pod_call_seq = formObject.pod_yd_cd.Code.split("%%")[2] * 1; // 숫자로 변형	    
		
    	if( ( formObject.flag.value=="S" && !formObject.flag_rob.checked ) || formObject.flag.value=="M") {  // MULTI 일때는 항상 가동, single 이면서 ROB 선택이 아닌경우에 만 가동됨 (ROB 는 선후관계 따지지 않음)

    		for(j=1; j<sheetObjects[1].RowCount+1; j++) {
    			// pol yd cd 의 t0_clpt_seq 가 더 크거나 같으면  *1 을 해서 숫자형으로 변환)
    			pol_call_seq = sheetObjects[1].CellValue(j, "clpt_seq") * 1; // 숫자로 변형
			
    			if(pod_call_seq <= pol_call_seq) {  

    				ComShowCodeMessage("EQR01134"); // 'ETB must be later than ETD.';  
    				formObject.pod_yd_cd.Text 			= "";
    				formObject.pod_yd_cd.Code 			= "";
    				formObject.to_etb_dt.value 			= "";
    				formObject.pod_clpt_ind_seq.value 	= "";
				
    				break;
    			}
    		}
    	}
    	
  
    }   
    
	/*
	 * pod code 변경시 이벤트 발생
	 */
    function vvd_rob_OnChange() {
    	var formObject = document.form;
	
	    // POD 정보 재조회
	    searchPodCode();      // 우측하단 pod,eta 정보 조회
	    	   
  
    }       
    	   
    
    // 저장후 메세지 표현
    function sheet2_OnSaveEnd(sheetObj, errMsg) {
    	if(errMsg=='') {  // 오류 없음.
    		
    		// 저장완료 메세지 표현
    		ComShowCodeMessage("EQR90106");    		
    		
   			ComBtnDisable("btn_retrieve");   // retrieve
   			ComBtnDisable("btn_new");
   			ComBtnDisable("btng_formatexceldown");    		   			
   			ComBtnDisable("btng_loadexcel");    			
   			ComBtnDisable("btng_rowadd");    			
   			ComBtnDisable("btng_rowdel");  
   			
    		// split bkg 버튼 비활성화
   			ComBtnDisable("btng_splitbkgcre");  
   			  			
   			
   			document.form.splitresult.value = "T";  // SPLIT 완료여부 (CLOSE 버튼에서 사용)
    	}

    }    
    
   
    /*
     * VVD 값 변경
     * ONKEYUP 이벤트에서 발생
     */
    function changeVVD() {

    	var formObject = document.form;
    	formObject.vvd.value = formObject.vvd.value.toUpperCase();  // 대문자변환  	    	
	    
    	if(formObject.vvd.value.length != 9) { 
   			//Please enter ' + msg1 + ' digits long data.
   			ComShowCodeMessage("EQR90078","9");//9 자리로 입력하세요.
   			return false;
   		}else {
   			// VVD 유효성 검사
   			formObject.f_cmd.value = SEARCH04; 
   			var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1052GS.do?vvd="+formObject.vvd.value, FormQueryString(formObject));   					
   			var vvd_chk = ComGetEtcData(sXml,"vvd_chk");
		
   			if(vvd_chk == "F") { // 존재하지 않는 vvd
   				ComShowCodeMessage("EQR01131"); // This VVD isn\'t available.
   				formObject.vvd.value = "";
   				formObject.vvd.focus();

   				// 왼쪽, 오른쪽 그리드 제거
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
	        
   				return false;
   			}else if(vvd_chk == "W") { // WATER VVD 는 SPLIT 불가
   				ComShowCodeMessage("EQR01135"); // Please input Trunk VVD
   				formObject.vvd.value = "";
   				formObject.vvd.focus();

   				// 왼쪽, 오른쪽 그리드 제거
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
	        
   				return false;			
   			}
	    
   			// VVD의 BKG NO 검색
   			doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
   			// VVD의 POD 검색
   			doActionIBSheet(sheetObjects[0],document.form,SEARCH03);	
        
   			// 왼쪽, 오른쪽 그리드 제거
   			sheetObjects[0].RemoveAll();
   			sheetObjects[1].RemoveAll();
	    }
    }
    
    /*
     * ROB 체크 값 변경
     * ONCHANGE 이벤트에서 발생
     */
    function changeROB() {
        var formObject = document.form;   			

   		if(formObject.flag_rob.checked) {  // ROB 체크
   			// vvd_rob 활성화
   			formObject.vvd_rob.Enable = true;
   			searchVVDROB();      // ROB VVD 정보 조회(현재 VVD의 +5개까지 조회)
   			formObject.open_flag_rob.value = "Y";
   			
   			// POD정보 제거
   			formObject.pod_yd_cd.RemoveAll(); // POD YD COMBO 제거
   			formObject.to_etb_dt.value = "";  // POD DATE 제거
   			

   		}else {  // ROB 언체크
   			// VVD ROB 비활성화
   			formObject.vvd_rob.Code = "";
   			formObject.vvd_rob.Enable = false;
   			formObject.open_flag_rob.value = "N";   			   		
   			
   			// POD 정보 재조회 (NORMAL BKG 기준 VVD로 검색)
   		    searchPodCode();      // 우측하단 pod,eta 정보 조회
   		}    	
    }
    
    /**
     * LoadExcel 이벤트 발생시 호출되는 function <br>
     * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
     * @version 2009.09.29
     */ 
     function sheet1_OnLoadExcel(sheetObj) {
  	   var formObj = document.form;
  	   var cntrNo = "";
  	   var vvd = formObj.vvd.value;  	   
  	   
  	   // 역순으로 검색해서 결과값이 존재하면 표시, 없으면 FALSE 표시(체크박스 불가능하게 변경)  		
  	   for(var i = sheetObj.Rows-1 ; i >= sheetObj.HeaderRows ; i--){
  		   cntrNo = sheetObj.CellValue(i, "t0_cntr_no");
  	 	     	 	   
  		   searchContainerInfo(sheetObj, formObj, i, vvd, cntrNo);  						
  	   }

     }    
     
 	// Container번호로 Repo 정보 조회
 	function searchContainerInfo(sheetObj, formObject, Row, vvd, cntrNo) {
 		formObject.f_cmd.value = SEARCH05; 
 		var flag = formObject.flag.value;
 		var sXml = sheetObj.GetSearchXml("EES_EQR_1052GS.do?vvd"+vvd+"&excel_cntr_no="+cntrNo+"&flag="+flag, FormQueryString(formObject));   			 		
  		
 		sheetObj.CellValue2(Row, "t0_vl_bkg_no") 	= ComGetEtcData(sXml,"vl_bkg_no");
 		sheetObj.CellValue2(Row, "t0_cntr_tpsz_cd") = ComGetEtcData(sXml,"cntr_tpsz_cd");
 		sheetObj.CellValue2(Row, "t0_vrfy_status") 	= ComGetEtcData(sXml,"vrfy_status");
 		sheetObj.CellValue2(Row, "t0_mvmt_sts_cd") 	= ComGetEtcData(sXml,"mvmt_sts_cd");
 		sheetObj.CellValue2(Row, "t0_pod_yd_cd") 	= ComGetEtcData(sXml,"pod_yd_cd");
 		sheetObj.CellValue2(Row, "t0_pol_yd_cd") 	= ComGetEtcData(sXml,"pol_yd_cd");
 		sheetObj.CellValue2(Row, "t0_vps_etd_dt") 	= ComGetEtcData(sXml,"vps_etd_dt");
 		sheetObj.CellValue2(Row, "t0_clpt_seq") 	= ComGetEtcData(sXml,"clpt_seq");
 		sheetObj.CellValue2(Row, "t0_vsl_cd") 		= ComGetEtcData(sXml,"vsl_cd");
 		sheetObj.CellValue2(Row, "t0_skd_voy_no") 	= ComGetEtcData(sXml,"skd_voy_no");
 		sheetObj.CellValue2(Row, "t0_skd_dir_cd") 	= ComGetEtcData(sXml,"skd_dir_cd");		
 		
 		if(   sheetObj.CellValue(Row, "t0_vrfy_status") != "OK" 
 		   || sheetObj.CellValue(Row, "t0_vl_bkg_no") == "" 
 		   || sheetObj.CellValue(Row, "t0_vl_bkg_no") == null) {  // bkg no = null 이면 적색 표시 
 			 	
 			if(sheetObj.CellValue(Row, "t0_vl_bkg_no") == "" || sheetObj.CellValue(Row, "t0_vl_bkg_no") == null) {
 				sheetObj.CellValue2(Row, "t0_vrfy_status") = "Not Exists";
 			}
 			sheetObj.CellEditable(Row, "t0_sel") = false;   // 체크박스 사용 불능
			sheetObj.CellFontColor(Row ,"t0_vrfy_status") = sheetObj.RgbColor(255,0,0);  // RED
			sheetObj.CellFont("FontBold", Row,"t0_vrfy_status") = true; 			       // BOLD
 		}

 	}     
 	
	// SHEET1 ONCHANGE EVENT 발생
    function sheet1_OnChange(sheetObj, Row, Col, Val) {
    	var formObj = document.form;
    	var colName = sheetObj.ColSaveName(Col);
   	    var vvd = formObj.vvd.value;  
   	   
		// Container 입력
		if(colName=="t0_cntr_no" ) {			
            var searchword = sheetObj.CellValue(Row, colName);
            
    	    if(searchword.length != 11) { 
    			//Please enter ' + msg1 + ' digits long data.
    			ComShowCodeMessage("EQR90078","11");//9 자리로 입력하세요.
    		    return false;
    		}	
    	    
    	    searchContainerInfo(sheetObj, formObj, Row, vvd, searchword);  	
            
		}    

    }
    
	// 조회후 소개 계산
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(i=1; i<sheetObj.RowCount+1; i++) {
			
			//alert( i + " : " + sheetObj.CellValue(i, "t0_vrfy_status"));
			if(sheetObj.CellValue(i, "t0_vrfy_status") != "OK") {  // OK 아니면 적색 표시 
				sheetObj.CellEditable(i, "t0_sel") = false;   // 체크박스 사용 불능
				sheetObj.CellFontColor(i ,"t0_vrfy_status") = sheetObj.RgbColor(255,0,0);  // RED
				sheetObj.CellFont("FontBold", i,"t0_vrfy_status") = true;

			}
		}    	

    }
    
 	
    
	/* 현재창 닫기
	*/
	function closeWindow() {
		
		// bkg create 화면 조회
		if(document.form.splitresult.value == "T") {  // split bkg 이 완료된 경우에만 작동
			var opener = window.dialogArguments; // parent 객체 생성(showModalDialog를 사용했으므로)
			opener.document.form.divflag[1].checked = true;  // radio 버튼 vvd 체크
			opener.document.form.vvdname.value = document.form.vvd.value;  // vvd 값 입력
			opener.searchSplitResult();
		}
		
		// split 화면 닫기
		self.close();			
		
	}

	/* 개발자 작업  끝 */