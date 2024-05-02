// 공통전역변수
//080929 SHEET HEAD 추가 

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			//showErrMessage("srcName > " + srcName);
            switch(srcName) {

 
        	    case "btn_ok":
					doSetValue(sheetObject,formObject);
        	        //break;

        	    case "btn_close":
      	            self.close();
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	  
    	  

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
                    style.height = GetSheetHeight(15) ;
                    //style.height = 270 ;
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
                    InitColumnInfo(11, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|Chk|POL|POD|Lane|Type|T/Time\n(Day/Hr)|Dir|FDR_FLG|POL ETB|POD ETB";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,    "sSeq",      false,        "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtRadioCheck, 30,    daCenter,  true,    "sChk",      false,        "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "sPol",      true,         "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "sPod",      false,        "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sLane",     true,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sSvcTp",    true,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sTT",       false,        "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sDir",      false,        "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sFdrFlg",   false,        "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sPolEtb",   false,        "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sPodEtb",   false,        "",       dfNone,     0,     true,       true);

		            RangeBackColor(1, 6, 1, 14) = RgbColor(222, 251, 248);   // ENIS
		            HeadRowHeight = 20 ;

					InitDataValid(0, "sPol",   vtEngUpOther, "1234567890");
					
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
				if(validateForm(sheetObj,formObj,sAction));
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_PRD_0040GS.do", PrdFQString(formObj));
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

	/******************************************************************************/


	function doSetValue(sheetObj,formObj){
		
		var openerSheet = opener.document.sheet1 ;
        var tsIdx = '';
        var next =0;
        var sTsPort = '';
        var isLastPod = '';
        tsIdx = formObj.gubun.value;
        sTsPort = formObj.sTsPort.value;
        isLastPod = formObj.isLastPod.value;
       
        if( tsIdx == '4' && sheetObj.CellValue( sheetObj.SelectRow , "sPod") != openerSheet.CellValue( openerSheet.SelectRow, "s_pod") && sTsPort !='Y' ) {
            ComShowMessage(ComGetMsg('PRD90012'));
            return;
        }  
       
		openerSheet.CellValue2( openerSheet.SelectRow, "s_pol"+tsIdx       ) = sheetObj.CellValue( sheetObj.SelectRow , "sPol");
		openerSheet.CellValue2( openerSheet.SelectRow, "s_ts"+tsIdx+"_lane" ) = sheetObj.CellValue( sheetObj.SelectRow , "sLane");
		openerSheet.CellValue2( openerSheet.SelectRow, "s_ts"+tsIdx+"_type" ) = sheetObj.CellValue( sheetObj.SelectRow , "sSvcTp");//aaaaaaa
		openerSheet.CellValue2( openerSheet.SelectRow, "s_pod"+tsIdx       ) = sheetObj.CellValue( sheetObj.SelectRow , "sPod");
		var  sttNm = "";
		
		if(tsIdx == '1'){
			sttNm = "s_n1st_tztm_hrs";
		}else if(tsIdx == '2'){
			sttNm = "s_n2nd_tztm_hrs";
		}else if(tsIdx == '3'){
			sttNm = "s_n3rd_tztm_hrs";
		}else if(tsIdx == '4'){
			sttNm = "s_n4th_tztm_hrs";
		}
		//openerSheet.CellValue2( openerSheet.SelectRow, "s_t_t"+tsIdx        ) = sheetObj.CellValue( sheetObj.SelectRow , "sTT");
		openerSheet.CellValue2( openerSheet.SelectRow, sttNm       ) = sheetObj.CellValue( sheetObj.SelectRow , "sTT");
		
		openerSheet.CellValue2( openerSheet.SelectRow, "s_dir"+tsIdx       ) = sheetObj.CellValue( sheetObj.SelectRow , "sDir"); //bbbbbbbb
		openerSheet.CellValue2( openerSheet.SelectRow, "s_fdr_flg"+tsIdx    ) = sheetObj.CellValue( sheetObj.SelectRow , "sFdrFlg");


        next = ComParseInt(tsIdx)+1;                                                                                                       
        if(tsIdx == '1' ) {                                                                                                              
            openerSheet.CellValue2( openerSheet.SelectRow, "s_pod"+tsIdx+"_etb"   ) = sheetObj.CellValue( sheetObj.SelectRow , "sPodEtb");                                                                
            openerSheet.CellValue2( openerSheet.SelectRow, "s_ts_ind"   ) = 'D';   
            openerSheet.CellValue2( openerSheet.SelectRow, "s_f_u"      ) = 'N';
                                                                        
        }else if(tsIdx == '2' || tsIdx == '3' ){                                                                                         
            openerSheet.CellValue2( openerSheet.SelectRow, "s_pol"+tsIdx+"_etb"    ) = sheetObj.CellValue( sheetObj.SelectRow , "sPolEtb");    
            openerSheet.CellValue2( openerSheet.SelectRow, "s_pod"+tsIdx+"_etb"    ) = sheetObj.CellValue( sheetObj.SelectRow , "sPodEtb");    
            openerSheet.CellValue2( openerSheet.SelectRow, "s_ts_ind"   ) = 'T';                                                               
        }else if(tsIdx == '4'){                                                                                                          
            openerSheet.CellValue2( openerSheet.SelectRow, "s_pol"+tsIdx+"_etb"    ) = sheetObj.CellValue( sheetObj.SelectRow , "sPolEtb"); 
 
        }      
      
        //1,2,3 일때 pod가 destLoc 과 같으면 다음 pod에 넣지 않는다.                                                                     
        if((tsIdx == '1'||tsIdx == '2'||tsIdx == '3') && sheetObj.CellValue(sheetObj.SelectRow , "sPod")!= openerSheet.CellValue( openerSheet.SelectRow, "s_pod")) {  
          
        	
        	
        	if(openerSheet.CellValue( openerSheet.SelectRow, "s_ts"+tsIdx+"_lane" ) =="" ||  openerSheet.CellValue( openerSheet.SelectRow, "s_ts"+tsIdx+"_type" ) =="" ) {
                // ROW COPY 시 는 현재 POD 와 NEXT POL 이 같은지 확인후 지워줌 (지울떄 ? ) 
                if(openerSheet.CellValue( openerSheet.SelectRow , "s_pod"+tsIdx)!= openerSheet.CellValue( openerSheet.SelectRow,  "s_pol"+next  )) {
                    openerSheet.CellValue2( openerSheet.SelectRow, "s_pol"+next       ) = ""; 
                    
                }
                return;
            }
            if(isLastPod !='Y') {
                 openerSheet.CellValue2( openerSheet.SelectRow, "s_pol"+next       ) = sheetObj.CellValue( sheetObj.SelectRow , "sPod");    
            }
            
            if(sTsPort =='Y') {
                openerSheet.CellValue2( openerSheet.SelectRow, "s_ts"+tsIdx+"_port"      ) = sheetObj.CellValue( sheetObj.SelectRow , "sPod");    
            }       
                        
        }
        
      
        
        if(isLastPod =='Y') {
        	
        	
            openerSheet.CellValue2( openerSheet.SelectRow, "s_pod"      ) = sheetObj.CellValue( sheetObj.SelectRow , "sPod");  
        }
        // tsIdx  2,3,4 일때 ST 계산 
        
        if(tsIdx == '2' || tsIdx == '3' || tsIdx == '4' ) { 
            // tsIdx-1 인 podEtb 를 가져온다 
            var sstName = "";
        	if(tsIdx == '2'){ 
        		sstName = "s_n1st_stay_tm_hrs";
        	}else if(tsIdx == '3'){
        		sstName = "s_n2nd_stay_tm_hrs";
        	}else if(tsIdx == '4'){
        		sstName = "s_n3rd_stay_tm_hrs";
        	}
        
        	
            var podEtb = openerSheet.CellValue( openerSheet.SelectRow , "s_pod"+(tsIdx-1)+"_etb" );
            var podEtbNum = 0;
            
        
            
            if( podEtb != '' ){
                podEtbNum = ( (podEtb == 'SUN') ? 7:
                             ( (podEtb == 'MON') ? 6:
                             ( (podEtb == 'TUE') ? 5:
                             ( (podEtb == 'WED') ? 4:
                             ( (podEtb == 'THU') ? 3:
                             ( (podEtb == 'FRI') ? 2:
                             ( (podEtb == 'SAT') ? 1:0)))))));
            } else {
                  //한쪽이 FDR이어서 podEtb 가 ''이면 0으로 넣어준다.
                  openerSheet.CellValue2( openerSheet.SelectRow, sstName    ) = 0;      
                  return true;                                           
            }
            // 
            var polEtb = sheetObj.CellValue( sheetObj.SelectRow , "sPolEtb");
            var polEtbNum = 0;
            
            if( polEtb != '' ){
                polEtbNum = ( (polEtb == 'SUN') ? 7:
                             ( (polEtb == 'MON') ? 6:
                             ( (polEtb == 'TUE') ? 5:
                             ( (polEtb == 'WED') ? 4:
                             ( (polEtb == 'THU') ? 3:
                             ( (polEtb == 'FRI') ? 2:
                             ( (polEtb == 'SAT') ? 1:0)))))));
            }else {
                 openerSheet.CellValue2( openerSheet.SelectRow, sstName   ) = 0;       
           
                 return true;                                           
                                           
            }
            
            
            var calEtb = podEtbNum-polEtbNum;
           
            var st = ( (calEtb == -1)? 7:
                      ( (calEtb == -2)? 6:
                      ( (calEtb == -3)? 5:
                      ( (calEtb == -4)? 4:
                      ( (calEtb == -5)? 3:
                      ( (calEtb == -6)? 2: 
                      ( (calEtb ==  0)? 1:
                      ( (calEtb ==  1)? 1:
                      ( (calEtb ==  2)? 3:
                      ( (calEtb ==  3)? 4:
                      ( (calEtb ==  4)? 5:
                      ( (calEtb ==  5)? 6:
                      ( (calEtb ==  6)? 7: 0))))))))))))) *24;
            
           
            openerSheet.CellValue2( openerSheet.SelectRow, sstName   ) = st;    
            
        }
        var sLnkCnt = getLinkCnt(openerSheet, openerSheet.SelectRow );
        openerSheet.CellValue2( openerSheet.SelectRow, "s_lnk_cnt"       ) = sLnkCnt;	
        
        if(sLnkCnt == 1 ) {
             openerSheet.CellValue2( openerSheet.SelectRow, "s_ts_ind"   )  = 'D';                                                               
        }else if(sLnkCnt > 1 ) {
             openerSheet.CellValue2( openerSheet.SelectRow, "s_ts_ind"   )  = 'T';                                                               
        } else {
            ComShowMessage(ComGetMsg('PRD90105'));
        }
        
	}
	
    function getLinkCnt(sheetObj, insertRow ) {
       
        var findPodIdx =0;
        //-----------------                 
        //  링크의 정보가 빠짐없이 있는지 확인     
        for(index = 1 ; index<  5  ; index++){                     
        	if(sheetObj.CellValue( insertRow , "s_pol"+index)!="" && sheetObj.CellValue( insertRow , "s_ts"+index+"_lane")!="" 
        	&&sheetObj.CellValue( insertRow , "s_ts"+index+"_type")!="" && sheetObj.CellValue( insertRow , "s_pod"+index)!="" ){
        	    findPodIdx++;
        	}            	            	            	
        } 
        return  findPodIdx;      
    }