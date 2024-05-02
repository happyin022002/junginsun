/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7035.js
*@FileTitle : Rail Hub – Port pair deletion 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.28
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation 
=========================================================
* History                                                    
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
     * @class ESM_PRI_7035 : ESM_PRI_7035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7035() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
	
    var isClear = true;
    var returnData = false;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2012.04.17
     */
    function processButtonClick() {
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {              
                if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                    return false;
                }
            }

            switch (srcName) {

            case "btn_down_excel":    
            	doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
                break;
                
            case "btn_load_excel":    
                doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
                break;   
                
            case "btn_delete_from_tariff":    
                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				if(!returnData){
					return;
				}
				window.returnValue = returnData;
				window.close();
				break; 
                
            case "btn_row_add":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI01);
                break;
                
            case "btn_row_copy":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI03);
                break;
                
            case "btn_row_delete":    
            	doActionIBSheet(sheetObjects[0],document.form,MULTI02);
                break;            
                
            case "btn_check":    
                doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
                break;
                
			case "btn_close":
				self.close();
				break;

            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
           	ComOpenWait(false); //->waiting->End
        }
    }
    
    /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */
    function loadPage() {
    	 var formObj = document.form;
         for (var i = 0; i < sheetObjects.length; i++) { 
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);   
            initSheet(sheetObjects[i], i + 1);          
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();   
        doActionIBSheet(sheetObjects[0],document.form,MULTI01);
    }
        
    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 공백진
     * @version 2012.04.17
     */        
     function setSheetObject(sheet_obj) {
         sheetObjects[sheetCnt++] = sheet_obj;
     }    
    
    /**
    * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */    
     function initControl() {
            //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
//        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
//        axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
        axon_event.addListenerForm('click', 'obj_click', document.form);   
        axon_event.addListenerForm('change', 'obj_change', document.form);
     }     
     
     /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2012.04.17
     */      
     function obj_keypress() {
         var srcValue = event.srcElement.getAttribute("value");
         var srcName = event.srcElement.getAttribute("name");
         
         switch (event.srcElement.dataformat) {
             case "engup":
                 ComKeyOnlyAlphabet('upper');  
                 break;
                 
             case "engupnum":
            	 ComKeyOnlyAlphabet('uppernum');
            	 break;      
            	 
             case "int":
                 ComKeyOnlyNumber(event.srcElement);
                 break;
                 
             case "float":
                 ComKeyOnlyNumber(event.srcElement, ".");
                 break;
                 
             case "ymd":
              	  ComKeyOnlyNumber(event.srcElement);
                 break;
                 
             case "apply":
            	 ComKeyOnlyNumber(event.srcElement, "-.");
                break;
             default:
         }       
     }         
    
    /**
    * Sheet관련 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj 필수 html form object
    * @param {int} sAction 필수 프로세스 플래그 상수
    * @return 없음
    * @author 서미진
    * @version 2012.05.14
    */   
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        var formObj = document.form;
        
        try{
            switch (sAction) {            
                
			case SEARCH02: // Load Excel
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				ComOpenWait(true);
				sheetObjects[0].Redraw = false;
				if (strFilePath != "<USER_CANCEL>") {
					sheetObj.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				
				if (sheetObj.RowCount > 0) {
					buttonControl("ADD"); 					
		            for(var i = sheetObj.LastRow; i >= sheetObj.HeaderRows; i--){
						if(sheetObjects[0].CellValue(i, 'hub_loc_cd') == "" && sheetObjects[0].CellValue(i, 'bse_port_loc_cd') == ""){
						   sheetObjects[0].RowDelete(i, false);
						}
					}
				}
				sheetObjects[0].Redraw = true;
		     	break;
                
            case SEARCH01:   // check
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                ComOpenWait(false); //->waiting->End
                break;   
                
			case MULTI01: // Add
                var iRow = sheetObj.DataInsert(-1);
        		sheetObj.CellValue(iRow, "ihc_trf_no") = formObj.ihc_trf_no.value ;
        		sheetObj.CellValue(iRow, "amdt_seq") = formObj.amdt_seq.value ;
        		sheetObj.CellValue(iRow, "svc_scp_cd") = formObj.svc_scp_cd.value ;
        		sheetObj.CellValue(iRow, "org_dest_tp_cd") = formObj.org_dest_tp_cd.value ;
        		sheetObj.CellValue(iRow, "ihc_cgo_tp_cd") = formObj.ihc_cgo_tp_cd.value ;	       
        		sheetObj.CellValue(iRow, 'rcv_de_term_cd') = formObj.rcv_de_term_cd.value;
        		sheetObj.SelectCell(iRow, "hub_loc_cd");
                buttonControl("ADD");   
				break;		
				
			case MULTI02: // Delete
				if(sheetObj.RowCount > 0){
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}
		        	//deleteRowCheck(sheetObj, "chk");
		            var checkRow = sheetObj.FindCheckedRow("chk");
		            var arrRow = checkRow.split("|");
					for (var idx=arrRow.length-2; idx>=0; idx--){
						sheetObj.RowDelete(arrRow[idx],false) ;		 
					}		            	        	
				}
				buttonControl("ADD");   
				if (sheetObj.RowCount == 0) {
					buttonControl("LOAD");   
				}
				break;		
				
			case MULTI03: // Row copy
				if(sheetObj.RowCount > 0){
					var sCheckedRows = sheetObj.FindCheckedRow("chk");
					var arrCheckedRows = sCheckedRows.split("|");
					for( var i = 0 ; i < arrCheckedRows.length-1; i++){					
						sheetObj.SelectRow = arrCheckedRows[i] ;	
	     		        var idx = sheetObj.DataCopy();     
	     		        arrCheckedRows[i+1] = parseInt(arrCheckedRows[i+1])+1;
					}
            	}
				buttonControl("ADD");   
				break;		
                
            case IBSAVE: // Save                  
                ComOpenWait(true); //->waiting->start           
	            if (!ComShowCodeConfirm("PRI00002")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }
                formObj.f_cmd.value = MULTI;
		 		var sParamSheet1 = sheetObjects[0].GetSaveString(false);
                var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                sParam = sParam + "&" + sParamSheet1;
	 			var sXml = sheetObj.GetSaveXml("ESM_PRI_7035GS.do", sParam);	
	 			var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	if(save_result != "F" ){
		     		returnData = true;
		     	} 
        		ComOpenWait(false); //->waiting->End 
                break;            
 
			case IBDOWNEXCEL:
				sheetObj.Down2Excel(-1, true, true);
				break;
				
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
		}finally {
			 ComOpenWait(false);
		}
    }
    
    /**
    * 시트 초기설정값, 헤더 정의 <br>
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
        
        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 330;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;              

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
                InitRowInfo( 2, 1, 20, 100);
    
				var HeadTitle1 = "ibflag|Sel.|Seq|Rail\nHub|Description|Base\nPort|IHC_TRF_NO|AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD|IHC_CGO_TP_CD|Term";    
				var HeadTitle2 = "ibflag|Sel.|Seq|Rail\nHub|Description|Base\nPort|IHC_TRF_NO|AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD|IHC_CGO_TP_CD|Term";  	

                var headCount = ComCountHeadTitle(HeadTitle1);
			
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0 , 0, true);
		
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);           
	
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  
                InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
				InitHeadRow(1, HeadTitle2, true);  

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 		daCenter, 	true, 	"ibflag"); 
                InitDataProperty(0, cnt++, dtCheckBox, 			40, 		daCenter, 	true, 	"chk");         
                InitDataProperty(0, cnt++, 	dtDataSeq,     		40,    		daCenter,  	true,  	"Seq");            
                InitDataProperty(0, cnt++, 	dtData, 				60, 		daCenter, 	true, 	"hub_loc_cd", true, "", dfNone, 0, true, true,5);                                    
                InitDataProperty(0, cnt++, 	dtData, 				260, 		daLeft,		 	true, 	"pnt_loc_nm", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, 	dtData,				50, 		daCenter, 	true, 	"bse_port_loc_cd", true, "", dfNone, 0, true, true,5);       
                InitDataProperty(0, cnt++, 	dtHidden, 			50, 		daCenter, 	true, 	"ihc_trf_no", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden,				50, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			50, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			50, 		daCenter, 	true, 	"org_dest_tp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			50, 		daCenter, 	true, 	"ihc_cgo_tp_cd", false, "", dfNone, 0, false, false);  
                InitDataProperty(0, cnt++, 	dtHidden, 			70, 		daCenter, 	true, 	"rcv_de_term_cd", false, "", dfNone, 0, false, false);   
                InitDataValid(0, "hub_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
                InitDataValid(0, "bse_port_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
                WaitImageVisible = false;  
                Ellipsis = true;
    		}
            break;
        }
    }
 
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateForm(sheetObj,document.form,IBSAVE)) {
    *         로직처리;
    *     }
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj 필수 html form object
    * @param {int} sAction 필수 프로세스 플래그 상수
    * @return bool <br>
    *          true  : 폼입력값이 유효할 경우<br>
    *          false : 폼입력값이 유효하지 않을 경우
    * @author 공백진
    * @version 2012.04.17
    */
    function validateForm(sheetObj, formObj, sAction) {
    	var formObj = document.form;
        
        switch (sAction) {
        case SEARCH01:   // check
        	isClear = true;
        	clearTooltip();

    		//Point,Base Port 의 중복 체크
    		var duprows2 = sheetObj.ColValueDupRows("hub_loc_cd|bse_port_loc_cd", false, true);
    		if(duprows2 != '') {
				var arrRow = duprows2.split("|");
				for (idx=0; idx < arrRow.length; idx++) {
					var duprows = arrRow[idx].split(",");
					for (var x=0; x < duprows.length; x++) {
						add2Tooltip(duprows[x], 'hub_loc_cd', msgs['PRI00302']);
						add2Tooltip(duprows[x], 'bse_port_loc_cd', msgs['PRI00302']);
						isClear = false;
					}
				 }
    		}

            for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){     
            	if(sheetObj.CellValue( i , "hub_loc_cd") == ""){
            		add2Tooltip( i, 'hub_loc_cd', msgs['PRI01001']);
            		isClear = false;
            	}
            
	        	if(sheetObj.CellValue( i , "bse_port_loc_cd") == ""){
            		add2Tooltip( i, 'bse_port_loc_cd', msgs['PRI01001']);
            		isClear = false;
	        	}

        		sheetObj.CellValue( i , "ihc_trf_no") = formObj.ihc_trf_no.value ;
        		sheetObj.CellValue( i , "amdt_seq") = formObj.amdt_seq.value ;
        		sheetObj.CellValue( i , "svc_scp_cd") = formObj.svc_scp_cd.value ;
        		sheetObj.CellValue( i , "org_dest_tp_cd") = formObj.org_dest_tp_cd.value ;
        		sheetObj.CellValue( i , "ihc_cgo_tp_cd") = formObj.ihc_cgo_tp_cd.value ;	   
        		sheetObj.CellValue( i, 'rcv_de_term_cd') = formObj.rcv_de_term_cd.value;
            }
            
    		formObj.f_cmd.value = SEARCH01;
	 		var sParam = sheetObj.GetSaveString(false, true);
	 		sParam += "&" + FormQueryString(formObj);        	
 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7035GS.do", sParam);	
 	        var arrData  = ComPriXml2Array(sXml, "hub_loc_cd|bse_port_loc_cd");   
 	        if(arrData != undefined){ 	
 	        	for(var i = 0; i < arrData.length; i++){
	 	            for(var j = sheetObj.HeaderRows; j <= sheetObj.LastRow; j++){
	 	            	if(arrData[i][0] == sheetObj.CellValue( j , "hub_loc_cd")){
	 	            		if(arrData[i][1] == sheetObj.CellValue( j , "bse_port_loc_cd")){
		 	            		add2Tooltip(j, 'hub_loc_cd', msgs['PRI07037']);
		 	            		add2Tooltip(j, 'bse_port_loc_cd', msgs['PRI07037']);
		 	            		isClear = false;
	 	            		}
	 	            	}
	 	            }
 	        	}
 	        }

 	       if (isClear) {
        	   ComBtnEnable("btn_delete_from_tariff"); 
        	   return false;
           }else{
 	    	   ComBtnDisable("btn_delete_from_tariff");               
               return true;
           }
            break;
        }
        return true;
    }           
    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var sender = sheetObjects[0];	
		var etc4 = formObj.org_dest_tp_cd.value;

    	if(colName == "hub_loc_cd") {
    		if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp&etc4=" + etc4;
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "pnt_loc_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, colName) = "";
		    		sheetObj.CellValue2(Row, "pnt_loc_nm") = "";
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				
				var param = "&cd=" + Value + "&nm=rpscp&etc4=" + etc4;
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "pnt_loc_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, colName) = "";
		    		sheetObj.CellValue2(Row, "pnt_loc_nm") = "";
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, colName) = "";
	    		sheetObj.CellValue2(Row, "pnt_loc_nm") = "";
	    		return false;
			} 
    	}else if(colName == "bse_port_loc_cd") {
    		if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp&etc4=" + etc4;
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				
				if (!(arrData != null && arrData.length > 0 && arrData[1] != "")) {
					sheetObj.CellValue2(Row, colName) = "";
					return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				
				var param = "&cd=" + Value + "&nm=rpscp&etc4=" + etc4;
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (!(arrData != null && arrData.length > 0 && arrData[1] != "")) {
					sheetObj.CellValue2(Row, colName) = "";
					return false;
				}
			} else {
				sheetObj.CellValue2(Row, colName) = "";
	    		return false;
			} 
    	}
    }

    
	function add2Tooltip(row, col, msg) {
        var sheetObj = sheetObjects[0];
        	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
        	sheetObj.ToolTipText(row, col) +="\n- " +  msg;
    }
	
	function clearTooltip() {
        var sheetObj = sheetObjects[0];
        var n = sheetObj.HeaderRows + sheetObj.RowCount;
        var m = sheetObj.LastCol;
        var i = sheetObj.HeaderRows;
        var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
            for (j = 0 ; j <= m ; j++) {
                if (sheetObj.ToolTipText(i, j) != "") {
                    sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
    }
	
/**
    * 화면의 버튼을 상태에 따라 활성,비활성화 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     buttonControl();
    * </pre>
    * @param   없음
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */ 
 	function buttonControl(mode) {			
 		switch (mode) {
 		case "LOAD":	// LOAD screen		
 	        ComBtnDisable("btn_delete_from_tariff");  	 
 	        
 	        ComBtnEnable("btn_row_add"); 
 	        ComBtnDisable("btn_row_copy"); 
 	        ComBtnDisable("btn_row_delete"); 
 	        ComBtnDisable("btn_check"); 
 			break;
 			
 		case "ADD":	// exist data			
 			ComBtnDisable("btn_delete_from_tariff");  	 
 			
        	ComBtnEnable("btn_check");
        	ComBtnEnable("btn_row_copy"); 
        	ComBtnEnable("btn_row_delete"); 
 			break;
 		}
 	}
