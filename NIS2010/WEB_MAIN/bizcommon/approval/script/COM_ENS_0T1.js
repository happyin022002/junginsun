/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_ENS_0T1.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.11.10 정인선
* 1.0 최초 생성
* 2015.04.14 심성윤 [CHM-201534125] 디폴트 결재라인 체크로직 추가
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
     * @class Error Message Management : Error Message Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function errormessagemanagement() {
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
	
	var IBSAVE02    = 32;
	

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
            	case "btn_Search":
            		if ( document.getElementById("search_text").value == "" ) return;	
            		findXML(document.getElementById("search").value, document.getElementById("search_text").value);
            		break;
            		
            	case "btn_retrieve":    
            		doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                    break;
                    
            	case "btn_save":
        	        if(formObject.sub_sys_cd.value == "") {
        	        	ComShowCodeMessage("COM12113", "Module");
        	        	return;
        	        }
        	        doActionIBSheet(sheetObject2, formObject, IBSAVE);
        	        break;
        	       
            	case "btns_add":
            		var selrow = sheetObjects[0].SelectRow;
                    if ( selrow > 0 ){
                    	sheet1_OnDblClick("", "", "", "");
            		}     	        
            		break;

         	    case "btns_del":
         	    	var selrow = sheetObjects[1].SelectRow;
                    if ( selrow > 0 ){
                    	sheet2_OnDblClick("", "", "", "");
            		}    
         	    	break;
         	    	
        	    case "btn_confirm":
        	        doActionIBSheet(sheetObject2, formObject, IBSAVE);
        	        break; 	
         	    	
        	    case "btn_ok":
        	        returnApprovalRoute();
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
     * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
     * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
     * @param {ibsheet} sheet_obj    IBSheet Object
     **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
    	
        // 기저장된 Approval Route 조회
        var formObject = document.form;
        var mode = formObject.mode.value;
        var sheetObjectUser2 = sheetObjects[1];
        doActionIBSheet(sheetObjectUser2, formObject, IBSEARCH);
       
        //Del버튼 클릭시  GW의 Usr Id와 맵핑 시키기위하여 Usr Id조회
        //EP ID가 Null일 경우 Usr Id조회함.
        formObject.f_cmd.value = SEARCH06;
        
        var sXml = sheetObjectUser2.GetSaveXml("COM_ENS_0T1GS2.do",FormQueryString(formObject));
        //alert(sXml);
        if(sXml != ""){
        	formObject.ep_id.value =ComGetEtcData(sXml,"ep_id");
        }        
 	
    }
    
    /**
     * 결재라인에 결재자가 아무도 없을 때 처리 이벤트 <br>
     * 경고창 출력 후 팝업창 종료 <br>
     * CHM-201534125 - 심성윤<br>
     **/
    function chkDft(){
    	var formObject = document.form;
        var apro_step = '';
        
  		if(!opener)
  			opener = window.dialogArguments;

      	apro_step = opener.document.all[formObject.target_obj_nm.value].value;

      	//결재라인이 비어 있을 때
      	if(apro_step == ''){
      		alert("There is no approval line.\n"+"Please use IT Support on ALPS to send your request.");
      		window.close();
      	}    	
    }
    

    /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "Name|Dept|Title|" ;
					var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     90,   	daLeft,  	false,    	"NAME",        	false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,   false,    	"TEAMNM",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     0,    	daLeft,    	false,    	"BUJAE",        false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,   0,    	daCenter,  	false,    	"CN",       	false,          "",       dfNone,     0,     false,       false);
                    
                    CountPosition = 0;
                }
                break;
                
            case "sheet2":     //IBSheet2 init
            	with (sheetObj) {
	                //전체 너비 설정
	                style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = "|No|Name|Dept|Title|" ;
	               
	                var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
	                //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    	daCenter,  	true,    	"ibflag",           	false,        "",       dfNone,   		0,     false,      false);
	                InitDataProperty(0, cnt++ , dtData,      	30,    	daCenter,  	false, 		"apro_seq",    			false,          "",       dfNone,   	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	90,    daLeft,  	false,   	"apro_usr_nm",      	false,          "",       dfNone,     	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	90,    daCenter,  	false,    	"apro_ofc_cd",      	false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	85,    	daLeft,    	false,    	"apro_usr_jb_tit_nm",   false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,     	0,    	daLeft,    	false,    	"apro_usr_id",      	false,          "",       dfNone,     0,     false,       false);
	                
	                CountPosition = 0
	                CellBackColor(0,"name") = RgbColor(222,251,248);
	                CellBackColor(0,"mail") = CellBackColor(0,"name")  ;

	           }
            break;

        }
    }

     /* Sheet관련 프로세스 처리 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
         
           case IBSAVE02:
	            formObj.f_cmd.value = MULTI01;
            	formObj.frst_apro_usr_id.value = sheetObj.CellValue(sheetObj.RowCount, "apro_usr_id");
            	 
	            var SaveStr = sheetObj.GetSaveString();
	            var sXml = sheetObj.GetSaveXml("COM_ENS_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));

	            if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
			     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
			     		ComShowMessage(rmsg[3]);
			     	} else {
			     		sheetObjects[1].LoadSaveXml(sXml);
					}
				}else{
					 window.close();
				}
  		   break;
         
            case IBSAVE:        //저장
	            // 모두 재입력을 원칙으로 함
	            for(var i=0; i<sheetObj.RowCount; i++) {
	                sheetObj.CellValue2(i + 1, "ibflag") = "I";
	            }
            	
    			formObj.f_cmd.value = MULTI;
    			var SaveStr = sheetObj.GetSaveString();
    			var sXml = sheetObj.GetSaveXml("COM_ENS_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));
    			sheetObj.LoadSaveXml(sXml);
            break;
            
            case IBSEARCH:      //조회
            	formObj.f_cmd.value = SEARCH03;
            	sheetObj.DoSearch("COM_ENS_0T1GS2.do", FormQueryString(formObj));
            break;
            
          
         }
     }

     /* Sheet관련 프로세스 처리 */
     function doActionIBSheet2(sheetObj,formObj,sAction) {
    	 var retval = false;
         switch(sAction) {
         
          //CHM-201534125 심성윤 (2015.04.14)
          //결재라인 체크로직 추가
	         case IBSEARCH_ASYNC03:
		           formObj.f_cmd.value = MULTI02;
		            formObj.frst_apro_usr_id.value = sheetObj.CellValue(sheetObj.RowCount, "apro_usr_id");
	         	 
		            var SaveStr = sheetObj.GetSaveString(true);
		            //Default Approval Step 제거시 경고창 출력
		            if(SaveStr != ""){
			            var sXml = sheetObj.GetSaveXml("COM_ENS_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));
			            var aproChk = ComGetEtcData(sXml,"APRO_STEP_DEF_YN");

			            if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			            	sheetObjects[1].LoadSaveXml(sXml);
			            } else {
			            	if(aproChk == "Y"){
			            		retval = true;
			            		window.close();
			            	} else if(aproChk == "X"){
				            	alert("[SVR] You can't delete basic approval line.");
				            	retval = false;
				            } else {
				            	alert("[EXCEPTION] You can't delete basic approval line.");
				            	retval = false;
				            }
			            }
		            }else{		            	
		            	alert("[SCN2] You can't delete basic approval line.");
		            }
   	 
			   break;
         }
         return retval;
     }

     // OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
    function loadData(data) {
    	var sheetObject = sheetObjects[0];

    	var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
    	for( var i = 0 ; i < data.length ; i++ ) {
    		sheetXml += "<TR><![CDATA[";
    		sheetXml += data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4);	//data[i].get("TEAM");
    		sheetXml += "]]></TR>";
    	}
    	sheetObject.LoadSearchXml(sheetXml+"</DATA></SHEET>");
     }
     
    function sheet1_OnDblClick(sheetObj, row, col, value) {
    	var formObject = document.form;
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
  
        var selrow = sheetObject1.SelectRow;
        if ( selrow > 0 )
        {
            var usr_id = sheetObject1.CellValue(selrow, "CN");
            var usr_nm = sheetObject1.CellValue(selrow, "NAME");
            var ofc_cd = sheetObject1.CellValue(selrow, "TEAMNM"); 
            var title  = sheetObject1.CellValue(selrow, "BUJAE");
            
            // Duplication(중복) 체크
            for(var i=0; i<sheetObject2.RowCount; i++) {
                if(sheetObject2.CellValue(i + 1, "apro_usr_id") == usr_id) {
                    ComShowMessage(usr_id + " is already added");
                    return;
                }
            }
            /*
            if(ofc_cd.length > 6){
                ComShowMessage(ofc_cd + " is wrong code");
                return;
            }
            */
            
            /**
             * I/F된 CSR은 결재라인 추가 불가하도록 한다.
             */
            var csr_no = formObject.csr_no.value;
            if(csr_no != "" && csr_no != undefined){
	        	formObject.f_cmd.value = SEARCH05;
	       	 	var sXml = sheetObject2.GetSaveXml("COM_ENS_0T1GS2.do",FormQueryString(formObject));
	            if ("F" == ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
			     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
			     		ComShowMessage(rmsg[3]);
			     	} else {
			     		sheetObject2.LoadSaveXml(sXml);
			     		return;
					}
				}
            }
       	 	
            // 대상 Sheet로 데이타 이행
            row = sheetObject2.DataInsert(0);
			sheetObject2.CellValue2(row, "apro_usr_nm") =  usr_nm;
			sheetObject2.CellValue2(row, "apro_ofc_cd") =  ofc_cd;            			
			sheetObject2.CellValue2(row, "apro_usr_jb_tit_nm")  =  title; 
			sheetObject2.CellValue2(row, "apro_usr_id") =  usr_id;
			
            // APPROVAL SEQ 재정렬
            var rowCount = sheetObject2.RowCount;
            for(var i=0; i<rowCount; i++) {
                  sheetObject2.CellValue2(i + 1, "apro_seq") = rowCount - i;
            }
            /*
            var rowCount = sheetObject2.RowCount;
            for(var i=0; i<rowCount; i++) {
                  sheetObject2.CellValue2(i + 1, "apro_seq") = i+1;
            }*/
        }
    }
    
 // 소속 Office 자동 펼침 처리
    function officeSearch() {
	 	findXML('TEAMNM', document.getElementById("ofc_cd").value);
    }
    
    //DEL Button 클릭시 처리 로직
    function sheet2_OnDblClick(sheetObj, row, col, value) {
    	var formObject = document.form;
    	var sheetObject2 = sheetObjects[1];
        var selrow = sheetObject2.SelectRow;
        var csr_no = formObject.csr_no.value;
        var apro_rqst_seq = sheetObject2.CellValue(selrow,"apro_seq");
        var apro_usr_id = sheetObject2.CellValue(selrow,"apro_usr_id");
        var apro_cfm_scrn_flg = ComTrimAll(formObject.apro_cfm_scrn_flg);
        var ep_id = ComTrimAll(formObject.ep_id);
        
        //(Only)Approval Confirm화면에서 Edit Approval Step Delete시 자기 자신을 삭제하는지 못하도록 한다.
        // EP ID : GW에서 별도로사용하는 User Id(COM_USER의 USR_ID와 맵핑됨.)
//        if(apro_cfm_scrn_flg !="" && apro_cfm_scrn_flg != undefined && apro_cfm_scrn_flg != null){
//        	if(ep_id !="" && ep_id != undefined && ep_id != null){
//        		if(apro_usr_id !="" && apro_usr_id != undefined && apro_usr_id != null){
//        			if(ep_id == apro_usr_id){
//        				ComShowMessage("The approved route cannot be deleted.");
//        				return;
//        			}
//        		}
//            }
//        }
        
        //승인된 결제라이는 삭제할 수 없다.
        if(csr_no != "" && csr_no != undefined){
        	formObject.f_cmd.value = SEARCH04;
        	 var sXml = sheetObject2.GetSaveXml("COM_ENS_0T1GS2.do","apro_rout_seq="+apro_rqst_seq+"&" + FormQueryString(formObject));
            if ("F" == ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
		    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
		     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
		     		ComShowMessage(rmsg[3]);
		     	} else {
		     		sheetObject2.LoadSaveXml(sXml);
		     		return;
				}
			}
        }
  
        if(selrow > 0) {
            sheetObject2.RowDelete(selrow, false);
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject2.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject2.CellValue2(i + 1, "apro_seq") = rowCount - i;
        }
    }
    
    function returnApprovalRoute() {
    	var formObject = document.form;
        var sheetObject2 = sheetObjects[1];
        var apro_step = "";
        var aproSeqKey = "";
        var wi = sheetObject2.RowCount-1;
       
        for(var i=wi; i<sheetObject2.RowCount; i--) {
        	if(i<0) break;
            if(i != sheetObject2.RowCount-1) {
                apro_step += " - ";
            }
            apro_step += sheetObject2.CellValue(i + 1, "apro_seq")
            apro_step += "/";
            apro_step += sheetObject2.CellValue(i + 1, "apro_usr_id")
            apro_step += "/";
            apro_step += sheetObject2.CellValue(i + 1, "apro_usr_nm")
            apro_step += "/";
            apro_step += sheetObject2.CellValue(i + 1, "apro_ofc_cd")
            apro_step += "/";
            apro_step += sheetObject2.CellValue(i + 1, "apro_usr_jb_tit_nm")
            
			if(sheetObject2.CellValue(i + 1, "apro_seq") == wi+1){
				aproSeqKey = sheetObject2.CellValue(i + 1, "apro_usr_jb_tit_nm") == '' ? sheetObject2.CellValue(i + 1, "apro_usr_nm") : sheetObject2.CellValue(i + 1, "apro_usr_jb_tit_nm") + '/' + sheetObject2.CellValue(i + 1, "apro_usr_nm");
			}
        }

        // 모두 재입력을 원칙으로 함
//        for(var i=0; i<sheetObject2.RowCount; i++) {
//        	sheetObject2.CellValue2(i + 1, "ibflag") = "U";
//        }
        
        
      //CHM-201534125 심성윤 (2015.04.14)
      //결재라인 체크로직 추가
        
        formObject.aproSeqKey.value = aproSeqKey;       
        var csr_no 		 = formObject.csr_no.value;        

        document.form.apro_step.value = apro_step;       
        
        var SaveStr = sheetObject2.GetSaveString(true);
        //디폴트 결재 라인이 비어 있을 때
        if(SaveStr == ""){
        	if (formObject.chk_mt_dft_apro_step_yn.value == 'Y'){
            	alert("[SCN] You can't delete basic approval line.");		            	
            	return false;
        	}
        }
        
        var aproChk = false;
        aproChk = doActionIBSheet2(sheetObject2, formObject, IBSEARCH_ASYNC03);

    	if(aproChk){    		
            // 모달창인 경우는 window 객체로부터 opener를 획득
    		if(!opener)
    			opener = window.dialogArguments;

            opener.document.all[formObject.target_obj_nm.value].value = apro_step;
            opener.document.form.aproSeqKey.value = aproSeqKey;
    	} else {   
    		//exception
    	}
    }
    
    function sheet2_OnSaveEnd(sheet2, ErrMsg){    	
    	//기능 살려둠
    	
    }


	/* 개발자 작업  끝 */