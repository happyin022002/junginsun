/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0311.js
*@FileTitle : ESM_BKG-0311
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장지영
*@LastVersion : 1.0
* 2009.09.29 장지영
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0311() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    }
    
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
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용함 *****/
    		         var sheetObject1 = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");
        		
        		if(srcName != "btn_splitPop"){
            		if(layList.style.display != "none"){
            			layList.style.display = "none";
            		}    	    			
        		}

        		switch(srcName) {
        		
						case "btn_splitPop":			
							doActionIBSheet(sheetObjects[0],formObject,COMMAND04);					
							break;
    							
    					case "btn_retrieve":
    						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    						break;
    					
    					case "btn_add":
    						doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
    						break;
    						
    					case "btn_delete":
    						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
    						break;
    					
    					case "btn_save":
    						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
    						break;  
							 
						case "btn_downexcel": 			 								 
							sheetObject1.SpeedDown2Excel(-1, false, false, "", "", false, false,
									"", false, "Chk", "");
							break;
    							
    					case "btn_edi":
     						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01); 		
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

            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
            axon_event.addListenerFormat("keypress","obj_Keypress", document.form);        	 
            axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');       
            axon_event.addListenerForm("click", "obj_Click", document.form); 
	
            setFormatByMfTpCd("09E");
      		if (document.form.usr_ofc_cd.value == "SRGBA") {
      			document.form.pol_code.value = "IDSRG";
      			document.form.pod_code.value = "";
      			document.form.mf_tp_cd[0].disabled = true;
      		}
      		else if (document.form.usr_ofc_cd.value == "SUBBA") {
      			document.form.pol_code.value = "IDSUB";
      			document.form.pod_code.value = "";
      			document.form.mf_tp_cd[0].disabled = true;
      		}
      		else if (document.form.usr_ofc_cd.value == "JKTBA") {
      			document.form.pol_code.value = "IDJKT";
      			document.form.pod_code.value = "";
      			document.form.mf_tp_cd[1].disabled = true;
      		}
      		else if (document.form.usr_ofc_cd.value == "BLWBA") {
      			document.form.pol_code.value = "IDBLW";
      			document.form.pod_code.value = "";
      			document.form.mf_tp_cd[0].disabled = true;
      		}
            ComSetFocus(document.form.vvd);	
        }
         

function obj_Click() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "mf_tp_cd") {
		setFormatByMfTpCd(srcValue);
	}
}



       /**
        * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
        **/
       function obj_Keypress(){
           var srcName = event.srcElement.getAttribute("name");
           var srcValue = event.srcElement.getAttribute("value");	
           switch(event.srcElement.dataformat){
           	case "uppernum":
                   //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                   ComKeyOnlyAlphabet('uppernum');
                   break;
           	case "upper":
                   //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                   ComKeyOnlyAlphabet('upper');
                   break;            
            case "ymd":            
               	ComKeyOnlyNumber(event.srcElement);
                   if (srcValue.length == 4) {
                   	document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
                   }
                   if (srcValue.length == 7) {
                     document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
                   }
                     break;            
               default:
                   //숫자만입력하기(정수,날짜,시간)
                   ComKeyOnlyNumber(event.srcElement);
           }
       }


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    				var sheetID = sheetObj.id;
    				
            switch(sheetID) {
              case "sheet1":      //sheet1 init 
                    with (sheetObj) {
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
                        InitRowInfo( 1, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(20, 0, 0, true); 
                        
                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "|Sel.|Seq.|BKG No.|B/L No.|T/VVD|POR|POL|POD|DEL|PEB Number|PEB Date Issued|Customs Office|Qualifier|Usrl16|";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);


                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,      daCenter,  	 false,  	"ibflag");
    	                InitDataProperty(0, cnt++ , dtCheckBox,	    40,     daCenter,    false,     "Chk");                   
                    	InitDataProperty(0, cnt++ , dtDataSeq,	    35,     daCenter,    false,     "Seq",             false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,    false,     "bkg_no",      	   false,    "",      dfNone, 			0,     true,		true);
    					InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,    false,     "bl_no",       	   false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	70,     daCenter,    false,     "vvd",	      	   false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "por_cd",          false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "pol_cd",          false,    "",      dfNone, 			0,     false,		false); 
     					InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "pod_cd",   	   false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
    					InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,  	 false,     "del_cd",  		   false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,	 false,     "id_xpt_no",       false,    "",      dfNone, 			0,     true,		true,	6);
    					InitDataProperty(0, cnt++ , dtData,      	110,    daCenter,  	 false,     "id_xpt_no_iss_dt",false,    "",      dfUserFormat, 	0,     true,		true);
    					InitDataProperty(0, cnt++ , dtCombo,      	100,    daCenter,  	 false,     "id_ofc_cd",  	   false,    "",      dfNone, 			0,     true,		true);
    					InitDataProperty(0, cnt++ , dtCombo,      	65,     daCenter,    false,     "id_decl_cd",      false,    "",      dfNone, 			0,     true,		true);
    					InitDataProperty(0, cnt++ , dtData,      	10,     daCenter,  	 false,     "id_xpt_imp_seq",     false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,      	60,     daCenter,  	 false,     "vsl_cd",  	       false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,      	35,     daCenter,    false,     "skd_voy_no",      false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,      	80,     daCenter,  	 false,     "skd_dir_cd",  	   false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,      	80,     daCenter,  	 false,     "temp_id_xpt_no",  false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,      	10,     daCenter,  	 false,     "xpt_imp_seq",     false,    "",      dfNone, 			0,     false,		false);

    					InitDataValid(0, "bkg_no", vtEngUpOther, "0123456789");
    					InitDataValid(0, "por_cd", vtEngUpOnly);
    					InitDataValid(0, "pol_cd", vtEngUpOnly);
    					InitDataValid(0, "pod_cd", vtEngUpOnly);
    					InitDataValid(0, "del_cd", vtEngUpOnly);
    					InitDataValid(0, "id_xpt_no", vtNumericOnly);
    					InitUserFormat(0, "id_xpt_no_iss_dt", "####-##-##", "-" );
    					
    					InitDataCombo(
    							0,
    							"id_ofc_cd",
    							"|BANBA|JKTBA|SRGBA|SUBBA|",
    							"|010700|040300|060100|070100", "");
    					InitDataCombo(
    							0,
    							"id_decl_cd",
    							"|PEB|PKB|",
    							"|E|K","");
                   }
                    break;
                    
          	case "sheet2": //sheet2 init
    		with (sheetObj) {

    			// 높이 설정
    			style.height = 0;
    			// 전체 너비 설정
    			SheetWidth = mainTable.clientWidth;

    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;

    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = false;

    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 5, 100);

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(2, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, false, true, false, false)

    			var HeadTitle1 = "|flat_file";
    			//var HeadTitle2 = "Seq|M|VVD|Carrier|CNTR|TP|Seal No.1|Seal No.2|CGO Type|Yard|POL|POD|F/POD|Stowage|Gross Weight|CGO Type|IMO|DM|Trans|Loading Date|Customs\nDescription|Booking No.|Call Sign|Vessel Name|EDI Receiving Date";

    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle1, false);
                
    			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
    			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
    			// SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,      daCenter,  	 false,  	"ibflag");
    			InitDataProperty(0, cnt++, dtData, 300, daLeft, false, "flat_file");
    		}
    		break;
             

    		
            }
        }


         /**
          * 시트에 키필드 Validation 체크 및 해당 코드의 description 조회
          */
         function sheet1_OnChange(sheetObj, Row, Col, Value){
        	var formObj = document.form;
        	if(sheetObjects[0].ColSaveName(Col) == "bkg_no"){
        		formObj.f_cmd.value = SEARCH01;
        		formObj.strBkgNo.value = sheetObjects[0].CellValue(Row, "bkg_no");
        		if(formObj.strBkgNo.value != ""){
        			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
        		}else{
        			sheetObjects[0].CellValue2(Row, "bl_no") = "";
        			sheetObjects[0].CellValue2(Row, "vvd") = "";
        			sheetObjects[0].CellValue2(Row, "por_cd") = "";
        			sheetObjects[0].CellValue2(Row, "pol_cd") = "";
        			sheetObjects[0].CellValue2(Row, "pod_cd") = "";
        			sheetObjects[0].CellValue2(Row, "del_cd") = "";
        		}
        	}
         }         
         
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
    			case IBSEARCH:      //조회
    				    
    				if(!validateForm(sheetObj,formObj,sAction)) {
    					return false;
    				}
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				initSheet(sheetObjects[0],0);
    				formObj.f_cmd.value = SEARCH;  
    				formObj.vsl_cd.value     = formObj.vvd.value.substring(0,4);
    				formObj.skd_voy_no.value = formObj.vvd.value.substring(4,8);
    				formObj.skd_dir_cd.value = formObj.vvd.value.substring(8);
    			    formObj.pol_cd.value = formObj.pol_code.value; 
    			    formObj.pod_cd.value = formObj.pod_code.value;
    					
    				sheetObjects[0].RemoveAll();    					     					
     				sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0311GS.do", FormQueryString(formObj));
     				    
    				var arrXml = sXml.split("|$$|");
    					 
    			   	if (arrXml.length > 0) {			   	  		 
    			   	  	sheetObjects[0].LoadSearchXml(arrXml[0]);
    			   	}    
    			   	ComEtcDataToForm(formObj, sheetObj);

    				var sheet1RowSize = sheetObjects[0].RowCount;
    				for ( var i = 1; i <= sheet1RowSize; i++) {
    					if (formObj.usr_ofc_cd.value == "SRGBA") {
    						sheetObjects[0].CellValue2(i, "id_ofc_cd") = "060100";
    						sheetObjects[0].CellValue2(i, "id_decl_cd") = "K";
    					}
    					if (formObj.usr_ofc_cd.value == "SUBBA") {
    						sheetObjects[0].CellValue2(i, "id_ofc_cd") = "070100";
    						sheetObjects[0].CellValue2(i, "id_decl_cd") = "K";
    					}
    					if (formObj.usr_ofc_cd.value == "JKTBA") {
    						sheetObjects[0].CellValue2(i, "id_ofc_cd") = "040300";
    						sheetObjects[0].CellValue2(i, "id_decl_cd") = "E";
    					}
    					if (formObj.usr_ofc_cd.value == "BANBA") {
    						sheetObjects[0].CellValue2(i, "id_ofc_cd") = "010700";
    						sheetObjects[0].CellValue2(i, "id_decl_cd") = "K";
    					}
    					if (sheetObjects[0].CellValue (i, "id_xpt_no") == "") {
    						sheetObjects[0].CellValue2(i, "temp_id_xpt_no") = "";
    						sheetObjects[0].CellValue2(i, "id_xpt_no") = "000000"
    					}
    					else {
    						sheetObjects[0].CellValue2(i, "temp_id_xpt_no") = sheetObjects[0].CellValue (i, "id_xpt_no");
    					}

						var idSeq = sheetObjects[0].CellValue(i-1, "id_xpt_imp_seq");
    					if (sheetObjects[0].CellValue (i, "bl_no") == sheetObjects[0].CellValue (i-1, "bl_no")) {
    						idSeq++;
    						sheetObjects[0].CellValue2(i, "id_xpt_imp_seq") = idSeq;
    					}
    					else {
    						idSeq = 0;
    						sheetObjects[0].CellValue2(i, "id_xpt_imp_seq") = "1";
    					}
    				}
    				ComOpenWait(false);
    			   	   
    			break;

    		       case IBROWSEARCH:   // B/L No, VVD, POL, POD, DEL 조회
    		            sheetObj.WaitImageVisible = false; 
    		       		formObj.bkg_no.value = formObj.strBkgNo.value
    					var sXml = sheetObj.GetSaveXml("ESM_BKG_0311GS.do", FormQueryString(formObj));
    					var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
    					var row = sheetObj.SelectRow;
    					if(state == "S"){
    						if(formObj.f_cmd.value == SEARCH01){
    							sheetObjects[0].CellValue2(row, "bl_no") = ComGetEtcData(sXml,"bl_no");
    							sheetObjects[0].CellValue2(row, "vvd") = ComGetEtcData(sXml,"vvd");
    							sheetObjects[0].CellValue2(row, "por_cd") = ComGetEtcData(sXml,"por_cd");
    							sheetObjects[0].CellValue2(row, "pol_cd") = ComGetEtcData(sXml,"pol_cd");
    							sheetObjects[0].CellValue2(row, "pod_cd") = ComGetEtcData(sXml,"pod_cd");
    							sheetObjects[0].CellValue2(row, "del_cd") = ComGetEtcData(sXml,"del_cd");
    							formObj.bkg_no.value = "";
    							
    	    					if (formObj.usr_ofc_cd.value == "SRGBA") {
    	    						sheetObjects[0].CellValue2(row, "id_ofc_cd") = "060100";
    	    						sheetObjects[0].CellValue2(row, "id_decl_cd") = "K";
    	    					}
    	    					if (formObj.usr_ofc_cd.value == "SUBBA") {
    	    						sheetObjects[0].CellValue2(row, "id_ofc_cd") = "070100";
    	    						sheetObjects[0].CellValue2(row, "id_decl_cd") = "K";
    	    					}
    	    					if (formObj.usr_ofc_cd.value == "JKTBA") {
    	    						sheetObjects[0].CellValue2(row, "id_ofc_cd") = "040300";
    	    						sheetObjects[0].CellValue2(row, "id_decl_cd") = "E";
    	    					}
    	    					if (formObj.usr_ofc_cd.value == "BANBA") {
    	    						sheetObjects[0].CellValue2(row, "id_ofc_cd") = "010700";
    	    						sheetObjects[0].CellValue2(row, "id_decl_cd") = "K";
    	    					}
    	    					if (sheetObjects[0].CellValue (row, "id_xpt_no") == "") {
    	    						sheetObjects[0].CellValue2(row, "temp_id_xpt_no") = "";
    	    						sheetObjects[0].CellValue2(row, "id_xpt_no") = "000000"
    	    					}
    	    					else {
    	    						sheetObjects[0].CellValue2(row, "temp_id_xpt_no") = sheetObjects[0].CellValue (row, "id_xpt_no");
    	    					}
    						}
    					}
    					else{
    						ComBkgErrMessage(sheetObj, sXml);
    						sheetObjects[0].CellValue2(row, "bkg_no") = "";
    						sheetObjects[0].CellValue2(row, "bl_no") = "";
    						sheetObjects[0].CellValue2(row, "vvd") = "";
    						sheetObjects[0].CellValue2(row, "por_cd") = "";
    						sheetObjects[0].CellValue2(row, "pol_cd") = "";
    						sheetObjects[0].CellValue2(row, "pod_cd") = "";
    						sheetObjects[0].CellValue2(row, "del_cd") = "";
    						sheetObjects[0].SelectCell(row, "bkg_no");
							formObj.bkg_no.value = "";
    					}

    		            sheetObj.WaitImageVisible = true; 
    					break;
    				
    			case IBINSERT:      // 입력
    				sheetObj.DataInsert(-1);
    			break;
    				
    			case IBDELETE:
    				ComRowHideDelete(sheetObj,"Chk");
    			break;

				case IBSAVE: //저장
				if (sheetObjects[0].IsDataModified)
				{
					if(validateForm(sheetObj,formObj,sAction))
					{
						formObj.f_cmd.value = MULTI;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
	    				var sheet1RowSize = sheetObjects[0].RowCount;
	    				for ( var i = 1; i <= sheet1RowSize; i++) {
	    					if (sheetObjects[0].CellValue(i, "temp_id_xpt_no") == "") {
	    						sheetObjects[0].CellValue2(i, "ibflag") = "I";
	    					}	    					
	    				}
						sheetObj.DoSave("ESM_BKG_0311GS.do", FormQueryString(formObj),-1,false);
						// 처리하고 나면 한번 더 조회한다
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
						ComOpenWait(false);
					} 
				} else {
					ComShowCodeMessage("BKG00115");
					return false;
				}
    			break;

				case IBSEARCH_ASYNC01: //저장
					if (validateForm(sheetObj, formObj, sAction)) {
						if (sheetObj.id == "sheet2") {
							sheetObj.WaitImageVisible = false;

							/*
							 * 2010.12.14
							 * BL_ISSUE DATA가 없는 BKG 리스트 조회함( CONFIRM MSG 파라메터로 사용하기 위해)
							 * pagerows 는 TRUE : BL_ISSUE DATE 가 없는 BKG 문자열, FALSE : 실제 EDI File Download
							 */
							ComOpenWait(true);
							formObj.f_cmd.value = MULTI02;
							formObj.pagerows.value = "TRUE";
							var xmlStr = sheetObj.GetSaveXml("ESM_BKG_0311GS.do", FormQueryString(formObj));
							sheetObj.LoadSaveXml(xmlStr);

							ComOpenWait(false);
							
							var msgParam = sheetObj.CellValue(1, "flat_file");
							
							var msgParamBkgNo = Array();
							
							if(msgParam != "") {
								msgParamBkgNo = msgParam.split(",");
							}
							
							if(msgParamBkgNo.length > 0 && sheetObjects[0].RowCount == msgParamBkgNo.length) {
								if(msgParam != "" ) {
									ComShowMessage(ComGetMsg("BKG06128", msgParam));
									return false;
					            }
								
							} else {
								if(msgParam != "" && !ComShowConfirm(ComGetMsg("BKG06127", msgParam))) {
									return false;
					            }
							}
							
							
							
							ComOpenWait(true);
							formObj.f_cmd.value = MULTI02;
							formObj.pagerows.value = "FALSE";
							var xmlStr = sheetObj.GetSaveXml("ESM_BKG_0311GS.do", FormQueryString(formObj));
							
							var sResult = ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
							if (sResult == "F") {
								sheetObj.LoadSaveXml(xmlStr);
							}			
							else {
								sheetObj.LoadSaveXml(xmlStr);
								//sheetObj.RemoveAll();
								//var row = sheetObj.DataInsert(-1);
								if (sheetObj.RowCount > 0) {
									//sheetObj.CellValue2(row, "flat_file") = sValue;
									var flatFileNm = formObj.vvd.value + "_"
										+ formObj.pol_cd.value + "_" + formObj.pod_cd.value
										+ "_" + ComGetObjValue(formObj.mf_tp_cd) + "_"
										+ ComReplaceStr(ComGetNowInfo("ymd"), "-", "")
										+ "_"
										+ ComReplaceStr(ComGetNowInfo("hms"), ":", "")
										+ "_OB";
									//var flatFileNm = formObj.vvd.value + ComGetObjValue(formObj.mf_tp_cd);
									sheetObj.Down2Text("","","1", flatFileNm, "", "", false, false, true);
								}
							}
							ComOpenWait(false);

						}
					}
				break;
				
				case COMMAND04:      //booking split no조회 
					if(validateForm(sheetObj,formObj,sAction)) {
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						formObj.f_cmd.value = COMMAND03;
						var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
						var bkg_split_no_list = ComGetEtcData(rXml, "bkg_split_no_list");
						if(bkg_split_no_list.indexOf("<option") < 0) 
						{
							ComOpenWait(false);
							return false;
						}
						layList.innerHTML = bkg_split_no_list;
						if(layList.style.display == "none"){
							var obj = formObj.bkg_no;
							var top = document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 37;
							var left = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
							layList.style.top = top;					
							layList.style.left = left;
							layList.style.display = "inline";
						}
						var obj = document.getElementsByName("bkg_split_no_list");
						obj[0].style.height = "35";
						ComOpenWait(false);
					}else{
						return false;
					}					
				break;
            }
        }
 
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch (sAction) {
  			case IBSEARCH: // 조회
  		 
  			if (formObj.vvd.value == "" ) 
  			{
  				ComShowCodeMessage('BKG00213');
  				formObj.vvd.focus();
  				return false;
  			}  
  			
  			if (formObj.vvd.value.length > 0 && formObj.vvd.value.length < 9) 
  			{
  				ComShowCodeMessage('BKG00213');
  				formObj.vvd.focus();
  				return false;
  			}

  			return true;  
  			break;  			
  			
  			case IBSAVE: // 저장
				
			return true;
			break;
  			
  			case IBSEARCH_ASYNC01:
				
			return true;
			break;
			
			case COMMAND04:
				
			return true;
			break;		
  			 
     	 }
        }  

         /**
          * 화면 폼 입력 필드에 MaxLength 만큼 값이 들어오면,
          * 자동으로 다음 필드로 Focus 이동
         **/
         function obj_KeyUp() {
         	     
         	    var formObject = document.form;        
         	    var srcName = window.event.srcElement.getAttribute("name");
         	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
         	    var srcValue = window.event.srcElement.getAttribute("value");
         	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
         	    	ComSetNextFocus();        	    		
         	    }
         }

         /**
          * 엔터 입력시 조회 
          * @return
          */  
           function obj_ComKeyEnter() {
           	
               var formObject = document.form;
               var srcName = window.event.srcElement.getAttribute("name");
                    
               if(srcName != "") {         		 
                 	ComKeyEnter();
                }         	         
        }

      	  function bkgSplitNoList(split_list){
      		document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
      		layList.style.display="none";
          }          

          function setFormatByMfTpCd(mfTpCd) {
          	ComEnableObject(document.form.pol_code, true);
          	ComEnableObject(document.form.pod_code, true);
          	switch (mfTpCd) {
          	case "09E":
          		if (document.form.usr_ofc_cd.value == "SRGBA") {
          			document.form.pol_code.value = "";
          			document.form.pod_code.value = "IDSRG";
          		}
          		else if (document.form.usr_ofc_cd.value == "SUBBA") {
          			document.form.pol_code.value = "";
          			document.form.pod_code.value = "IDSUB";
          		}
          		else if (document.form.usr_ofc_cd.value == "JKTBA") {
          			document.form.pol_code.value = "";
          			document.form.pod_code.value = "IDJKT";
          		}
          		else if (document.form.usr_ofc_cd.value == "BLWBA") {
          			document.form.pol_code.value = "";
          			document.form.pod_code.value = "IDBLW";
          		}
          		break;
          	case "10E":
      			document.form.pod_code.value = "";
          		ComSetFocus(document.form.pod_code);
          		break;
          	case "04E":
      			document.form.pol_code.value = "";
      			document.form.pod_code.value = "";  
          		ComSetFocus(document.form.pod_code);
          		break;
          	case "05E":
      			document.form.pod_code.value = ""; 
          		ComSetFocus(document.form.pod_code);
          		break;
          	case "08X":
          		if (document.form.usr_ofc_cd.value == "SRGBA") {
          			document.form.pod_code.value = "IDSRG";
          			document.form.pol_code.value = "";
          		}
          		else if (document.form.usr_ofc_cd.value == "SUBBA") {
          			document.form.pod_code.value = "IDSUB";
          			document.form.pol_code.value = "";
          		}
          		else if (document.form.usr_ofc_cd.value == "JKTBA") {
          			document.form.pod_code.value = "IDJKT";
          			document.form.pol_code.value = "";
          		}
          		else if (document.form.usr_ofc_cd.value == "BLWBA") {
          			document.form.pod_code.value = "IDBLW";
          			document.form.pol_code.value = "";
          		}
          		break;
          	}
          }