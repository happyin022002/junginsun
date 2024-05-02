/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7031_02.js
*@FileTitle : US Inland Add-on Creation & Amendment - Reefer tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
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
     * @class ESM_PRI_7031_02 : ESM_PRI_7031_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7031_02() {
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
    
    var comboObjects = new Array();
    var comboCnt = 0;
	var rslt = false;

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

            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
                break;         
                
            case "btn_save":    
                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;    
                
            case "btn_confirm":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI03);
                break;
                
            case "btn_amend_down":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI04);
                break;
                
            case "btn_cancel_down":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI05);
                break;
                
            case "btn_add_down":    
            	doActionIBSheet(sheetObjects[0],document.form,MULTI09);
                break;                       
                
            case "btn_delete_down":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI06);
                break;              
                
            case "btn_apply":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI07);
                break;
                
            case "btn_gl_tuning":    
                doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
                break;
                
            case "btn_down_excel":    
            	doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
                break;

            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
           	if (srcName == "btn_coffer" || srcName == "btn_approve") {
           		ComOpenWait(false); //->waiting->End
           	}
           	
        }
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
    * IBMulti Combo Object를 배열로 등록 <br>
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
    * 배열은 소스 상단에 정의 <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(combo_obj);
    * </pre>
    * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */       
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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

        //IBMultiCombo초기화    ,"|","\t" );
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initControl();    
        buttonControl("LOAD");
        formObj.ihc_cgo_tp_cd.value = "RF";
    	parent.loadTabPage(1);
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
        
        try{
            switch (sAction) {            
            case IBSEARCH: 		//retrieve form
            	formObj.f_cmd.value = SEARCH19;
                var sXml_Rcv_de_term_cd = "";
                var stdRcvDeTermCd = '';
                if(formObj.org_dest_tp_cd.value == 'O') {
                	stdRcvDeTermCd = "CD02070";
        		} else if(formObj.org_dest_tp_cd.value == 'D') {
        			stdRcvDeTermCd = "CD02071";	
        		}       
                sXml_Rcv_de_term_cd = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd="+stdRcvDeTermCd);
                setIBCombo(sheetObjects[0], sXml_Rcv_de_term_cd, "rcv_de_term_cd", false, 0, "D");
                break;
                
            case SEARCH01:   // retrieve sheet 
            	ComOpenWait(true); //->waiting->start
            	clearAllgridForms();
	 			formObj.f_cmd.value = SEARCH01;	 			
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7031_02GS.do", FormQueryString(formObj));	 	 	 
	 			sheetObj.LoadSearchXml(sXml);	
	 			
	 	        formObj.flat_percent_20_app.value="";   
	 	        formObj.flat_percent_40_app.value="";   
	 	        comboObjects[0].Index = -1;
	 	        comboObjects[1].Index = -1;

	 			if(formObj.amdt_seq.value == "0" && formObj.fic_prop_sts_cd.value == "I" ){		
	 		    	var topRow = sheetObj.TopRow;                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 		    	var lastRow = sheetObj.LastRow;   	 		    	
	 		    	for(var i=topRow; i<=lastRow; i++) {       
						sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt") = true;        
						sheetObj.CellEditable(i, "gline_40ft_frt_rt_amt") = true;   
	 		    	}
	 		    	buttonControl("INIT");	
	 			}else{
	 				buttonControl(formObj.fic_prop_sts_cd.value);	 
	 			}
				setSheet3Style(sheetObj, -1);
	 			ComOpenWait(false); //->waiting->End
                break;   
                
            case IBSAVE: // Save                  
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                ComOpenWait(true); //->waiting->start    
	            if (!ComShowCodeConfirm("PRI00001")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }
            	
                formObj.f_cmd.value = MULTI;
		 		var save_result = 'F';
		 		var sParamSheet1 = sheetObjects[0].GetSaveString(false, true);
                var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                sParam = sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
               
                var sXml = sheetObjects[0].DoSave("ESM_PRI_7031_02GS.do", sParam, -1, false );  
        		ComOpenWait(false); //->waiting->End
        		
		     	if(sXml){
		     		ComPriSaveCompleted();
		     	}   
                break;            
             
                
            case MULTI03: // Confirm
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                break;  
                
			case MULTI04: // Row Amend
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                
	            var checkedCnt = sheetObjects[0].CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow = parseInt(sheetObjects[0].FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObjects[0].SelectRow = curRow;
	        		sheetObjects[0].CellValue2(curRow, "chk") = "0";
	        	}
	        	
	        	var idx = doRowAmend(sheetObj, "AM");
				setSheet3Style(sheetObj, idx - 1);
				setSheet3Style(sheetObj, idx);
				break;	
				
			case MULTI05: // Amend Cancel
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                
	            var checkedCnt = sheetObjects[0].CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow = parseInt(sheetObjects[0].FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObjects[0].SelectRow = curRow;
	        		sheetObjects[0].CellValue2(curRow, "chk") = "0";
	        	}
	        	
	        	var prevIdx = doRowAmendCancel(sheetObj);
	        	setSheet3Style(sheetObj, prevIdx);
				break;
				
			case MULTI06: // Delete
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	        	
	    		var sCheckedRows = sheetObj.FindCheckedRow("chk");
	    		var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	    		
            	for (var i = arrCheckedRows.length - 1; i >= 0; i--) {
	            	if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SelectRow = arrCheckedRows[i];
	               		sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";
	                	
	               		var idx = doRowAmend(sheetObj, "AD");
	        			setSheet3Style(sheetObj, idx - 1);
	        			setSheet3Style(sheetObj, idx);
	            	}
	        	}
	        	deleteRowCheck(sheetObj, "chk");
				break;	
				
			case MULTI09: // Add
                var amdt_seq = formObj.amdt_seq.value;       
                var iRow = sheetObjects[0].DataInsert(-1);
            	// AMD seq. > 0 일경우 폰트 컬러를 red로 
                if(amdt_seq > 0){
                	sheetObjects[0].RowFontColor(iRow) = sheetObjects[0].RgbColor(255,0,0);
                }
                sheetObjects[0].CellEditable(iRow, 'gline_20ft_frt_rt_amt') = true;
                sheetObjects[0].CellEditable(iRow, 'gline_40ft_frt_rt_amt') = true;
                sheetObjects[0].CellValue2(iRow, 'src_info_cd') = 'NW';
                sheetObjects[0].CellValue2(iRow, 'amdt_seq') = amdt_seq;
                sheetObjects[0].CellValue2(iRow, 'n1st_cmnc_amdt_seq') = amdt_seq;
                sheetObjects[0].CellValue2(iRow, 'eff_dt') = formObj.eff_dt.value;
                sheetObjects[0].CellValue2(iRow, 'svc_scp_cd') = formObj.svc_scp_cd.value;
                sheetObjects[0].CellValue2(iRow, 'prc_trf_cre_tp_cd') = 'G';
                sheetObjects[0].CellValue2(iRow, 'ihc_trf_no') = formObj.ihc_trf_no.value;
                sheetObjects[0].CellValue2(iRow, 'ihc_cgo_tp_cd') = formObj.ihc_cgo_tp_cd.value;
                sheetObjects[0].CellValue2(iRow, 'org_dest_tp_cd') = formObj.org_dest_tp_cd.value;
                sheetObjects[0].CellValue2(iRow, 'locl_curr_cd') = formObj.locl_curr_cd.value;
                sheetObjects[0].SelectCell( iRow , "pnt_loc_cd");            
				break;		
				
            case MULTI07: // Apply          
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                } 
                
                ComOpenWait(true); //->waiting->start
	            if (!ComShowCodeConfirm("PRI00014")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }
	            sheetObjects[0].Redraw = false;
            	var amdt_seq = formObj.amdt_seq.value;
            	var eff_dt = formObj.eff_dt.value;
            	var star_idex = sheetObj.HeaderRows;
            	var all_row = sheetObj.Rows;
            	var sheetObj = sheetObjects[0] ;
            	
            	var fixPercent20 = comboObjects[0].Code;
        		var fixPercent40 = comboObjects[1].Code;
        		var flatPercent20App = formObj.flat_percent_20_app.value == '' ? 0 : parseFloat(formObj.flat_percent_20_app.value);
        		var flatPercent40App = formObj.flat_percent_40_app.value == '' ? 0 : parseFloat(formObj.flat_percent_40_app.value);
        		
            	for (var i = star_idex ; i < all_row ; i++ ){
            		if(sheetObjects[0].CellValue( i, "amdt_seq") != sheetObjects[0].CellValue( i, "n1st_cmnc_amdt_seq") ){
            			// 이미 amend 되어 선이 그어진 경우는 적용 X
            			if(!sheetObjects[0].CellFont("FontStrikethru", i, 1, i, sheetObjects[0].LastCol)){
	            			// amount 0 인 항목은 apply 적용 안함
	            			if(sheetObj.CellValue( i , "gline_20ft_frt_rt_amt") != "0" || sheetObj.CellValue( i , "gline_40ft_frt_rt_amt") != "0"){ 
		        				// DataCopy/ Insert 기준 row 를 잡기 위해 Row 설정
		        		        sheetObj.SelectRow = i ;
		        		        var idx = sheetObj.DataCopy();     // new row
		        		        var idx2 = idx-1;                 //origin row
		        		        
		        		        // new row
		        		        sheetObj.CellEditable(idx,"gline_20ft_frt_rt_amt") = true;
		        		        sheetObj.CellEditable(idx,"gline_40ft_frt_rt_amt") = true ;       		        
		        		        sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq")= amdt_seq;
		        		        sheetObj.CellValue2(idx,"eff_dt")= eff_dt;
		        		        sheetObj.CellValue2(idx, "src_info_cd")  = "AM" ;			
		        		        sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
		        		        sheetObj.RowStatus(idx) = "U";	
		
		        		        //origin row
		        		        sheetObj.CellValue2(idx2,"amdt_seq")=amdt_seq-1;
		        		        sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol)=true;
		        		        sheetObj.CellValue2(idx2,"exp_dt") = ComGetDateAdd(sheetObj.CellValue(idx,"eff_dt"), "D", -1);  
		        		        sheetObj.RowStatus(idx2) = "R"; 
		        		        sheetObj.RowEditable(idx2) = false;
		        		        
		        		        if(flatPercent20App != 0 && fixPercent20 != "" && sheetObj.CellValue( i , "gline_20ft_frt_rt_amt") != "0"){
			        				if(fixPercent20 == "F"){
			        					sheetObj.CellValue( idx , "gline_20ft_frt_rt_amt") = parseFloat(sheetObj.CellValue( idx , "gline_20ft_frt_rt_amt")) + flatPercent20App;
			            			}
				            		
				            		if(fixPercent20 == "P"){
				            			sheetObjects[0].CellValue( idx , "gline_20ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( idx , "gline_20ft_frt_rt_amt")) * (1  + (flatPercent20App)/100);
				            		}
		        		        }
			            		
			            		if(flatPercent40App != 0 && fixPercent40 != "" && sheetObj.CellValue( i , "gline_40ft_frt_rt_amt") != "0"){
				            		if(fixPercent40 == "F"){
				            			sheetObjects[0].CellValue( idx , "gline_40ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) + flatPercent40App;
				            		}
				            		
				            		if(fixPercent40 == "P"){
				            			sheetObjects[0].CellValue( idx , "gline_40ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) * (1  + (flatPercent40App)/100);
				            		}
			            		}		            		
			            		i++;
			            		all_row++;	     		
	            			}
            			}
            		} else {
                		if(sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt")){
	        				if(fixPercent20 == "F"){
	        					// amount 0 인 항목은 apply 적용 안함
	        					if(sheetObj.CellValue( i , "gline_20ft_frt_rt_amt") != "0"){ 	
		            				sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt")) + flatPercent20App;
	        					}
	            			}
		            		
		            		if(fixPercent20 == "P"){
		            			// amount 0 인 항목은 apply 적용 안함
	        					if(sheetObj.CellValue( i , "gline_20ft_frt_rt_amt") != "0"){ 	
		            				sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt")) * (1  + (flatPercent20App)/100);
	        					}
		            		}

		            		if(fixPercent40 == "F"){
		            			// amount 0 인 항목은 apply 적용 안함
	        					if(sheetObj.CellValue( i , "gline_40ft_frt_rt_amt") != "0"){ 	
		            				sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) + flatPercent40App;
	        					}
		            		}
		            		
		            		if(fixPercent40 == "P"){
		            			// amount 0 인 항목은 apply 적용 안함
	        					if(sheetObj.CellValue( i , "gline_40ft_frt_rt_amt") != "0"){ 	
		            				sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) * (1  + (flatPercent40App)/100);
	        					}
		            		}
                		}
            		}
            	}
            	sheetObjects[0].Redraw = true;
            	ComOpenWait(false); //->waiting->End
                break;  
                
            case MODIFY01: // g/l tuning
            	ComOpenWait(true); //->waiting->start
	            if (!ComShowCodeConfirm("PRI07016")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }         		
            	
	            var last_row_count = sheetObjects[0].LastRow ;
	            
            	for (var i = sheetObjects[0].HeaderRows; i <= last_row_count; i++) {
            		if(sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt")){
            			var gl20 = sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt");
                		var gl40 = sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt");               			
            			
            			var gl20int =  ""+gl20 * 100 ;
            			var gl40int =  ""+gl40 * 100 ;
            			
            			var gl20trunc = ""+Math.floor(gl20);
            			var gl40trunc = ""+Math.floor(gl40);
            			
        				if(gl20int.substring(gl20int.length, gl20int.length-3) != "000" || gl20int.substring(gl20int.length, gl20int.length-3) != "500" ){
        					if(gl20trunc.charAt(gl20trunc.length-1) == "0" || gl20trunc.charAt(gl20trunc.length-1) == "5" ){
        						sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = parseInt(gl20);
        					}else if(gl20trunc.charAt(gl20trunc.length-1) < 5){						
        						sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = gl20trunc.substr(0, gl20trunc.length -1) + "5" ; 
        					}else if(gl20trunc.charAt(gl20trunc.length-1) > 5){				
        						sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = Math.ceil(gl20 * 0.1) * 10 ;     
        					}        						
            			}

        				if(gl40int.substring(gl40int.length, gl40int.length-3) != "000" || gl40int.substring(gl40int.length, gl40int.length-3) != "500" ){
        					if(gl40trunc.charAt(gl40trunc.length-1) == "0" || gl40trunc.charAt(gl40trunc.length-1) == "5" ){
        						sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = parseInt(gl40);
        					}else if(gl40trunc.charAt(gl40trunc.length-1) < 5){
        						sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = gl40trunc.substr(0, gl40trunc.length -1) + "5" ;       					
        					}else if(gl40trunc.charAt(gl40trunc.length-1) > 5){		
        						sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = Math.ceil(gl40 * 0.1) * 10 ;     		
        					}
	            		}
        				
            		}
            	}
            	ComOpenWait(false); //->waiting->End
                break;    
				
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
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
                InitRowInfo( 3, 1, 20, 100);
    
				var HeadTitle1 = "ibflag|Sel.|Seq|RTSeq|Point|Node Point|Description|Hub|Node Hub|Base\nPort|Node Base\nPort|Contract\nTerm|Trans\nMode|Tariff (USD)|Tariff (USD)|" +
									 "Diff. (USD)|Diff. (USD)|Total Cost|Total Cost|Total Cost|Total Cost|Total Cost|EFF Date|EXP Date|Source|" +
									 "IHC_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|PRC_TRF_CRE_TP_CD|ORG_DEST_TP_CD|IHC_CGO_TP_CD";    
				var HeadTitle2 = "ibflag|Sel.|Seq|RTSeq|Point|Node Point|Description|Hub|Node Hub|Base\nPort|Node Base\nPort|Contract\nTerm|Trans\nMode|Tariff (USD)|Tariff (USD)|" +
									 "Diff. (USD)|Diff. (USD)|USD|USD|Local Currency|Local Currency|Local Currency|EFF Date|EXP Date|Source|" +
									 "IHC_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|PRC_TRF_CRE_TP_CD|ORG_DEST_TP_CD|IHC_CGO_TP_CD";   		
				var HeadTitle3 = "ibflag|Sel.|Seq|RTSeq|Point|Node Point|Description|Hub|Node Hub|Base\nPort|Node Base\nPort|Contract\nTerm|Trans\nMode|20'|40'|" +
									 "20'|40'|20'|40'|Cur.|20'|40'|EFF Date|EXP Date|Source|" +
									 "IHC_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|PRC_TRF_CRE_TP_CD|ORG_DEST_TP_CD|IHC_CGO_TP_CD";     

                var headCount = ComCountHeadTitle(HeadTitle1);
			
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 15 , 0, true);
		
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);           
	
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
				InitHeadRow(1, HeadTitle2, true);  
                InitHeadRow(2, HeadTitle3, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 		daCenter, 	true, 	"ibflag"); 
                InitDataProperty(0, cnt++, dtCheckBox, 			40, 		daCenter, 	true, 	"chk");         
                InitDataProperty(0, cnt++, 	dtDataSeq,     		40,    		daCenter,  	true,  	"Seq");       
                InitDataProperty(0, cnt++, 	dtHidden,    			40,    		daCenter,  	true,  	"rt_seq", false, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, 	dtData, 				50, 		daCenter, 	true, 	"pnt_loc_cd", true, "", dfNone, 0, false, true);                              
                InitDataProperty(0, cnt++, 	dtHidden, 			70, 		daCenter, 	true, 	"pnt_nod_cd", false, "", dfNone, 0, false, false);           
                InitDataProperty(0, cnt++, 	dtData, 				120, 		daLeft,		 	true, 	"pnt_loc_nm", false, "", dfNone, 0, false, false);                                 
                InitDataProperty(0, cnt++, 	dtData, 				50, 		daCenter, 	true, 	"hub_loc_cd", false, "", dfNone, 0, false, true);       
                InitDataProperty(0, cnt++, 	dtHidden, 			70, 		daCenter, 	true, 	"hub_nod_cd", false, "", dfNone, 0, false, false);                   
                InitDataProperty(0, cnt++, 	dtData, 				50, 		daCenter, 	true, 	"bse_port_loc_cd", true, "", dfNone, 0, false, true);    
                InitDataProperty(0, cnt++, 	dtHidden, 			70, 		daCenter, 	true, 	"bse_port_nod_cd", false, "", dfNone, 0, false, false);      
                InitDataProperty(0, cnt++, 	dtCombo, 			70, 		daCenter, 	true, 	"rcv_de_term_cd", true, "", dfNone, 0, false, true);   
                InitDataProperty(0, cnt++, 	dtCombo,				80, 		daCenter, 	true, 	"prc_trsp_mod_cd", true, "", dfNone, 0, false, true);                                   
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"gline_20ft_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"gline_40ft_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);   
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"diff_20ft",	false,		"", dfNone, 0, false, false);                                
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight, 		true, 	"diff_40ft",	false,		"", dfNone, 0, false, false);                 
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"cost_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"cost_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                     
                InitDataProperty(0, cnt++, 	dtData, 				40, 		daCenter, 	true, 	"locl_curr_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"locl_curr_cost_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                       
                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"locl_curr_cost_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                            
                InitDataProperty(0, cnt++, 	dtData, 				90, 		daCenter, 	true, 	"eff_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				90, 		daCenter, 	true, 	"exp_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtCombo, 			80, 		daCenter, 	true, 	"src_info_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"ihc_trf_no", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"prc_trf_cre_tp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"org_dest_tp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"ihc_cgo_tp_cd", false, "", dfNone, 0, false, false); 
                InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);      
                InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);   
                InitDataValid(0, "pnt_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
                InitDataValid(0, "hub_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
                InitDataValid(0, "bse_port_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
                HeadRowHeight = DataRowHeight;
                sheetObj.SetMergeCell (0, 13, 2, 2);  
                sheetObj.SetMergeCell (0, 15, 2, 2);  
                WaitImageVisible = false;  
                Ellipsis = true;
    		}
            break;
            
        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;              

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
                InitRowInfo( 1, 1, 20, 100);
    
				var HeadTitle1 = "ibflag|Seq|SVC_SCP_CD|IHC_TRF_NO|AMDT_SEQ|EFF_DT|COST_TRF_NO|SPCL_COUNT";

                var headCount = ComCountHeadTitle(HeadTitle1);
			
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0 , 0, true);
		
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);           
	
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, 	dtStatus,		30, 		daCenter, 	true, 	"ibflag");   
                InitDataProperty(0, cnt++, 	dtDataSeq,     		40,    		daCenter,  	true,  	"Seq");    
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"ihc_trf_no", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"eff_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"cost_trf_no", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"spcl_count", false, "", dfNone, 0, false, false);       
                WaitImageVisible = false;  
                Ellipsis = true;
    		}
            break;
        }
    }
    
    /**
    * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
    * <br><b>Example :</b>
    * <pre>
    *     initCombo(comboObj,1);
    * </pre>
    * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */         
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) { 			
	 		case "fix_percent_20" :	
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;  
	                InsertItem(i++, "Flat", "F");
	                InsertItem(i++, "%", "P");
	            }
	            break;
    
	 		case "fix_percent_40" :	
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;  
	                InsertItem(i++, "Flat", "F");
	                InsertItem(i++, "%", "P");
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
        case IBSEARCH: // 조회    
            if (comboObjects[0].Index =="-1") {
            	ComShowCodeMessage('PRI00308',"input","Service Scope"); 
            	formObj.svc_scp_combo.focus();
                return false;
            }
        	
            if (formObj.cost_cnt_cd.value == "") {
            	ComShowCodeMessage('PRI00308',"input","Country"); 
                clearAllForms();                
                sheetObjects[0].RemoveAll();      
            	formObj.cost_cnt_cd.focus();
                return false;
            }            
            break;

        case IBSAVE: // Save   
        	clearTooltip();
            if(!sheetObjects[0].IsDataModified){
                ComShowCodeMessage('PRI00301'); 
                return false;
            }

            // row add 의 필수 입력 체크
            for (var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
	            if (sheetObjects[0].CellValue( i, "ibflag") =="I") {
	            	if(sheetObjects[0].CellValue( i, "pnt_loc_cd") ==""){
	            		ComShowCodeMessage('COM130201', sheetObjects[0].CellValue( 0 , "pnt_loc_cd")); 
	            		sheetObjects[0].SelectCell( i, "pnt_loc_cd");
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "bse_port_loc_cd") ==""){
	            		ComShowCodeMessage('COM130201', "Base Port"); 
	            		sheetObjects[0].SelectCell( i, "bse_port_loc_cd");
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "rcv_de_term_cd") ==""){
	            		ComShowCodeMessage('COM130201', "Term"); 
	            		sheetObjects[0].SelectCell( i, "rcv_de_term_cd");
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "prc_trsp_mod_cd") ==""){
	            		ComShowCodeMessage('COM130201', "Trans Mode"); 
	            		sheetObjects[0].SelectCell( i, "prc_trsp_mod_cd");
	            		 return false;
	            	}
	            }
            }
        
    		//Point,Base Port,Term 의 중복 체크
            var duprows = ComPriAmendDupCheckAllRow(sheetObjects[0], "pnt_loc_cd|bse_port_loc_cd|rcv_de_term_cd", formObj.amdt_seq.value );      
    		if(duprows != '-1') {
				var duprows2 = duprows.split(",");	
				for (var x=0; x < duprows2.length-1; x++) {						
					add2Tooltip(duprows2[x], 'pnt_loc_cd', msgs['PRI00302']);
					add2Tooltip(duprows2[x], 'bse_port_loc_cd', msgs['PRI00302']);
					add2Tooltip(duprows2[x], 'rcv_de_term_cd', msgs['PRI00302']);
				}
				
				ComShowCodeMessage('PRI00302'); 
    			sheetObjects[0].SelectCell( duprows2[0], "pnt_loc_cd");
				return false;
    		}
            break;
            
        case MULTI03: // Confirm
            if(sheetObjects[0].IsDataModified){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }

            for (var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
            	
            	if(sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt")){
	            	if(sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") =="0" || sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") ==""){
	            		ComShowCodeMessage('PRI07007', sheetObjects[0].CellValue( i, "pnt_loc_cd"), "Reefer" ); 
	            		sheetObjects[0].SelectCell( i, "gline_20ft_frt_rt_amt" );
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") =="0" || sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") ==""){
	            		ComShowCodeMessage('PRI07007', sheetObjects[0].CellValue( i, "pnt_loc_cd"), "Reefer" ); 
	            		sheetObjects[0].SelectCell( i, "gline_40ft_frt_rt_amt" );
	            		 return false;
	            	}
	            	
	                var gl20 = sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt");
	        		var gl40 = sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt");               			
	    			
	    			var gl20int =  ""+gl20 * 100 ;
	    			var gl40int =  ""+gl40 * 100 ;
	
	    			
	    			if(gl20int.substring(gl20int.length, gl20int.length-3) != "000" && gl20int.substring(gl20int.length, gl20int.length-3) != "500" ){
	    				ComShowCodeMessage('PRI07015', "Reefer" );
	           		 	return false;				
	    			}
	
	    			if(gl40int.substring(gl40int.length, gl40int.length-3) != "000" && gl40int.substring(gl40int.length, gl40int.length-3) != "500" ){
	    				ComShowCodeMessage('PRI07015', "Reefer" );
	           		 	return false;		
	    			}
            	}
            }  
            break;
            
        case MULTI04: // Amend
        	var checkedCnt = sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow = -1;
        	if (checkedCnt == 1) {
        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow = sheetObj.SelectRow;
        	}
        	
        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01011");
        		return false;
        	}
            break;
            
        case MULTI05: // Amend Cancel
        	var checkedCnt = sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow = -1;
        	if (checkedCnt == 1) {
        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow = sheetObj.SelectRow;
        	}
        	
        	// Amend된 행이 아닌경우
        	if (sheetObj.CellValue(curRow, "src_info_cd") != "AM" && sheetObj.CellValue(curRow, "src_info_cd") != "AD") {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01012");
        		return false;
        	}
            break;
            
        case MULTI06: // Delete
        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows = new Array();
        	if (sCheckedRows == "") {
        		arrCheckedRows.push(sheetObj.SelectRow);
        	} else { 
        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
				if (sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "NW"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GM"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PM"
					&& sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}  
            break;
            
        case MULTI09: // Add row
        	return true;
        	break;
            
        case MULTI07: // Apply
           if (comboObjects[0].Code != "" && formObj.flat_percent_20_app.value == "") {
              	ComShowCodeMessage('PRI00308',"input","the ‘20 amount"); 
              	formObj.flat_percent_20_app.focus();
               return false;
           }        	   
        	
            if (comboObjects[0].Code =="" && formObj.flat_percent_20_app.value != "") {
            	ComShowCodeMessage('PRI00308',"select","the ’20 apply condition"); 
            	formObj.fix_percent_20.focus();
                return false;
            }
            
            if (comboObjects[1].Code != "" && formObj.flat_percent_40_app.value == "") {
              	ComShowCodeMessage('PRI00308',"input","the ‘40 amount"); 
              	formObj.flat_percent_40_app.focus();
               return false;
           }        	   
        	
            if (comboObjects[1].Code =="" && formObj.flat_percent_40_app.value != "") {
            	ComShowCodeMessage('PRI00308',"select","the ’40 apply condition"); 
            	formObj.fix_percent_40.focus();
                return false;
            } 
            
            if (comboObjects[0].Code =="" && formObj.flat_percent_20_app.value == "" && comboObjects[1].Code =="" & formObj.flat_percent_40_app.value == "") {
              	ComShowCodeMessage('PRI00351'); 
               return false;
           }
            
            var dot_count_20 = 0;
	    	var f20 = formObj.flat_percent_20_app.value ; 

	    	  for(var i = 0 ; i < f20.length ; i ++){
	    		  if(f20.charAt(i) == "-"){
	    			  if( i != 0){
	        			  ComShowCodeMessage('PRI07018',f20); 
	        			  document.form.flat_percent_20_app.focus();	 	
	        			  return false;
	    			  }
	    		  }
	    		  
	    		  if(f20.charAt(i) == "."){
	    			  dot_count_20++
	    		  }
	    	  }
	
			  if(dot_count_20 > 1 ){
				  ComShowCodeMessage('PRI07018',f20); 
				  document.form.flat_percent_20_app.focus();	 	
				  return false;
			  }        
    		  
	    	  var dot_count_40 = 0;
	    	  var f40 = formObj.flat_percent_40_app.value ; 

	    	  for(var i = 0 ; i < f40.length ; i ++){
	    		  if(f40.charAt(i) == "-"){
	    			  if( i != 0){
	        			  ComShowCodeMessage('PRI07018',f40); 
	        			  document.form.flat_percent_40_app.focus();	 	
	        			  return false;
	    			  }
	    		  }else if(f40.charAt(i) == "."){
	    			  dot_count_40++
	    		  }
	    	  }

    		  if(dot_count_40 > 1 ){
    			  ComShowCodeMessage('PRI07018',f40); 
    			  document.form.flat_percent_40_app.focus();	 	
    			  return false;
    		  }
            break;          
            
        }
        return true;
    }           
    
    /**
    * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     clearAllForms()
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2012.04.17
    */      
    function clearAllForms(){   
        var formObj = document.form;        
        formObj.cost_cnt_cd.value="";
        formObj.ihc_trf_no.value="";
        formObj.amdt_seq.value="";
        formObj.org_dest_tp_cd.value="";
        formObj.eff_dt.value="";
        formObj.fic_prop_sts_cd.value="";   
        formObj.flat_percent_20_app.value="";   
        formObj.flat_percent_40_app.value="";        
        formObj.svc_scp_cd.value = "";

        sheetObjects[0].headCheck(0, "chk") = false;
        sheetObjects[0].headCheck(1, "chk") = false;
        sheetObjects[0].headCheck(2, "chk") = false;
        
		sheetObjects[0].ColHidden("pnt_loc_cd") = false;
		sheetObjects[0].ColHidden("pnt_nod_cd") = true;		
		sheetObjects[0].ColHidden("hub_loc_cd") = false;
		sheetObjects[0].ColHidden("hub_nod_cd") = true;		
		sheetObjects[0].ColHidden("bse_port_loc_cd") = false;
		sheetObjects[0].ColHidden("bse_port_nod_cd") = true;
		
        comboObjects[0].Index ="-1"   
        comboObjects[1].Index ="-1"
        	
        sheetObjects[0].RemoveAll();     
        buttonControl("LOAD");   
    }
    
    /**
     * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms()
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2012.04.17
     */      
     function clearAllgridForms(){   
         var formObj = document.form;        
         sheetObjects[0].headCheck(0, "chk") = false;
         sheetObjects[0].headCheck(1, "chk") = false;
         sheetObjects[0].headCheck(2, "chk") = false;
         sheetObjects[0].RemoveAll();     
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
 		var formObj    = document.form;
		var amdt_seq = formObj.amdt_seq.value;
 			
 		switch (mode) {
 		case "LOAD":	// LOAD screen			 			
 			ComBtnDisable("btn_apply"); 
 			ComBtnDisable("btn_gl_tuning"); 
 			ComBtnDisable("btn_amend_down"); 
 			ComBtnDisable("btn_cancel_down"); 
 			ComBtnDisable("btn_add_down"); 
 			ComBtnDisable("btn_delete_down"); 
 			ComBtnDisable("btn_down_excel"); 	
 			break;
 			
 		case "INIT":	// Initial  & amdt seq = 0
 			ComBtnEnable("btn_apply"); 
 			ComBtnEnable("btn_gl_tuning"); 
 			ComBtnDisable("btn_amend_down"); 
 			ComBtnDisable("btn_cancel_down"); 
 			ComBtnEnable("btn_add_down"); 
 			ComBtnEnable("btn_delete_down"); 
 			ComBtnEnable("btn_down_excel"); 
 			break;
 			
 		case "I":	// Initial  & amdt seq != 0    
 			ComBtnEnable("btn_apply"); 
 			ComBtnEnable("btn_gl_tuning"); 
 			ComBtnEnable("btn_amend_down");
 			ComBtnEnable("btn_cancel_down"); 
 			ComBtnEnable("btn_add_down"); 
 			ComBtnEnable("btn_delete_down"); 
 			ComBtnEnable("btn_down_excel"); 
 			break;
 			
 		case "C":	// Initial  & amdt seq = 0
 			ComBtnDisable("btn_apply"); 
 			ComBtnDisable("btn_gl_tuning"); 
			ComBtnDisable("btn_amend_down"); 
 			ComBtnDisable("btn_cancel_down"); 
 			ComBtnDisable("btn_add_down"); 
 			ComBtnDisable("btn_delete_down"); 
 			ComBtnEnable("btn_down_excel"); 
 			break;
 		}
 	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var sender = sheetObjects[1];	
		var etc4 = formObj.org_dest_tp_cd.value;
		
    	if (colName == "pnt_loc_cd") {
    		var regExp = new RegExp("^" + formObj.cost_cnt_cd.value, "g");
    		if(!regExp.test(Value)) {
    			sheetObj.CellValue2(Row, colName) = "";
    			sheetObj.CellValue2(Row, "pnt_loc_nm") = "";
    			return false;
    		}
    		
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
    	} else if(colName == "bse_port_loc_cd" || colName == "hub_loc_cd") {
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
    	} else if (colName == "gline_20ft_frt_rt_amt") {
    		if(sheetObj.CellValue(Row, 'prc_trf_cre_tp_cd') == 'G') {
    			sheetObj.CellValue2(Row, 'diff_20ft') = 'N/A';
    		} else {
    			var v_gline_20ft_frt_rt_amt = parseFloat(sheetObj.CellValue(Row, 'gline_20ft_frt_rt_amt'));
    			var v_cost_20ft_frt_rt_amt =  parseFloat(sheetObj.CellValue(Row, 'cost_20ft_frt_rt_amt'));
    			var v_result =  parseFloat(Math.round((v_gline_20ft_frt_rt_amt - v_cost_20ft_frt_rt_amt)*100.0)/100.0);
    			if( v_result == Math.floor(v_result) ){
    				v_result = v_result+".00";
    			}    			
    			sheetObj.CellValue2(Row, 'diff_20ft') = ComGetMaskedValue(v_result, "float");
    		}
    	} else if (colName == "gline_40ft_frt_rt_amt") {
    		if(sheetObj.CellValue(Row, 'prc_trf_cre_tp_cd') == 'G') {
    			sheetObj.CellValue2(Row, 'diff_40ft') = 'N/A';
    		} else {
    			var v_gline_40ft_frt_rt_amt = parseFloat(sheetObj.CellValue(Row, 'gline_40ft_frt_rt_amt'));
    			var v_cost_40ft_frt_rt_amt =  parseFloat(sheetObj.CellValue(Row, 'cost_40ft_frt_rt_amt'));
    			var v_result =  parseFloat(Math.round((v_gline_40ft_frt_rt_amt - v_cost_40ft_frt_rt_amt)*100.0)/100.0);
    			if( v_result == Math.floor(v_result) ){
    				v_result = v_result+".00";
    			}
    			sheetObj.CellValue2(Row, 'diff_40ft') = ComGetMaskedValue(v_result, "float");    			
    		}
    	}
    }
    
	/**
	 * 선택된 Row에 대해 Amend or Amend Delete 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowAmend(sheetObj, sAction) {
		var idx = sheetObj.DataCopy();
		var prevIdx = idx - 1;
		
		sheetObj.CellValue2(idx, "eff_dt") = document.form.eff_dt.value;
		sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = document.form.amdt_seq.value;
		sheetObj.CellValue2(idx, "src_info_cd") = sAction;
		if (sAction == "AM") {
			sheetObj.CellValue2(idx, "src_info_cd") = "AM";
		} else if (sAction == "AD") {
			sheetObj.CellValue2(idx, "src_info_cd") = "AD";
		}

		sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value-1;
		
		sheetObj.CellValue2(prevIdx, "exp_dt") = ComGetDateAdd(sheetObj.CellValue(idx,"eff_dt"), "D", -1);  
		sheetObj.RowStatus(prevIdx) = "R";
		sheetObj.RowStatus(idx) = "U";
		return idx;
    }
    
	/**
	 * 선택된 Row에 대해 Amend Cancel 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowAmendCancel(sheetObj) {
    	var idx  = sheetObj.SelectRow;
		var prevIdx = idx - 1;
		
		if (sheetObj.CellValue(idx, "ibflag") != "I") {
			sheetObj.CellValue2(prevIdx, "exp_dt") = sheetObj.CellValue(idx, "exp_dt");
			sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value;
			// 이 부분은 Amend와 Amend Cancel을 반복할 경우, 저장이 안되는 경우를 위한 코드.
			// 이는 IBSheet에서 Amend Cancel시  다시 원복된 값이 조회당시 값과 같다고 인식해서 row의 status를 R로 인식하는 문제. 
			if (sheetObj.CellSearchValue(idx, "amdt_seq") != unescape("%00")) {
				sheetObj.RowStatus(prevIdx) = "U";
			}
		}
		sheetObj.RowDelete(idx, false);		
		return prevIdx;
    }
    
	/**
	 * 특정 row, 또는 Sheet전체에 대해 setLineStyle, setLineEnable함수를 호출하여
	 * 라인의 스타일(폰트색상, 취소선 등)을 만들어준다.
	 * setLineStyle은 메인화면의 함수를 팝업들이 공통적으로 같이 이용하며,
	 * setLineEnable은 각 화면이나 팝업별로 따로 구현되어 있다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheet3Style(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
    
	/**
	 * 주어진 로우에 대해 스타일(색상, 취소선 등)을 적용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setLineStyle(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.RowStatus(idx) == "D") {
    		sheetObj.RowHidden(idx) = true;
    	}
    	
    	// Proposal단계 일 경우 색상처리를 하지 않는다.
    	if (document.form.amdt_seq.value == "0") {
    		return true;
    	}
    	
    	// 이전Seq의 데이터는 Amend된 데이터로 간주하고, 취소선을 긋고, Row를 수정불가로 한다.
    	// 다만 RFA는 RowEditable메쏘드를 이용해 전체 Row를 Uneditable로 처리하고,
    	// S/C의 경우는 Note쪽에서 Conversion화면을 띠워야 하므로 루프를 돌면서 컬럼단위로 Uneditable 처리한다.
    	if (sheetObj.CellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
			sheetObj.RowEditable(idx) = false;
			
			return true;
		} else {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
			sheetObj.RowEditable(idx) = true;
    	}
    	
    	// 이번 회차의 데이타(Insert or Amend)는 font-color를 red로 표시.
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
			sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
    	} else {
    		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
    	}
    	
    	// 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
    	changeSelectBackColor4Rate(sheetObj);
    }
    
	/**
	 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리.
	 * 이 함수는 Sheet3(Rate)를 위한 것이고, 각 팝업마다 같은 이름의 함수들이 각 sheet에 맞게 정의되어 있다.
	 * 
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.fic_prop_sts_cd.value == "I"
    		&& sheetObj.CellValue(idx, "src_info_cd") != "AD") {
	        	sheetObj.CellEditable(idx, "gline_20ft_frt_rt_amt") = true;
	        	sheetObj.CellEditable(idx, "gline_40ft_frt_rt_amt") = true;
		} else {
        	sheetObj.CellEditable(idx, "gline_20ft_frt_rt_amt") = false;
        	sheetObj.CellEditable(idx, "gline_40ft_frt_rt_amt") = false;
		}
    	
    	if(document.form.fic_prop_sts_cd.value == "C"){
    		sheetObj.RowEditable(idx) = false;
    	}else{
    		sheetObj.RowEditable(idx) = true;
    	}
    }

	
 	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
     * @param {string} sPropStsCd 필수 pro_sts_cd 값
     * @param {string} sEffDt 필수 eff_dt 값
     * @param {string} sExpDt 필수 exp_dt 값
     * @param {string} sPreExpDt 필수 pre_exp_dt 값
     * @return 없음
     * @author 최성민
     * @version 2009.05.21
     */ 
	function tabLoadSheet(sIhcTrfNo, sAmdtSeq, sSvcScpCd, sFicPropStsCd, sEffDt, sCostCntCd, sOrgDestTpCd, sLoclCurrCd, sFicPropStsCd ) {
		var formObject = document.form;
		if (formObject.ihc_trf_no.value != sIhcTrfNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd 
		  || formObject.fic_prop_sts_cd.value != sFicPropStsCd || formObject.eff_dt.value != sEffDt || formObject.cost_cnt_cd.value != sCostCntCd
		  || formObject.org_dest_tp_cd.value != sOrgDestTpCd || formObject.fic_prop_sts_cd.value != sFicPropStsCd) {
			formObject.ihc_trf_no.value = sIhcTrfNo;
			formObject.amdt_seq.value = sAmdtSeq;
			formObject.svc_scp_cd.value = sSvcScpCd;		
			formObject.fic_prop_sts_cd.value = sFicPropStsCd; 
			formObject.eff_dt.value = sEffDt; 
			formObject.cost_cnt_cd.value = sCostCntCd ;
			formObject.org_dest_tp_cd.value = sOrgDestTpCd ;
			formObject.locl_curr_cd.value = sLoclCurrCd ;
			formObject.fic_prop_sts_cd.value = sFicPropStsCd;
			buttonControl("LOAD");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			doActionIBSheet(sheetObjects[0], document.form,SEARCH01);
		}
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
                	// Dry rail tariff 의 상태로 back color 조정 
                	if(!sheetObjects[0].CellEditable(i, "gline_20ft_rail_frt_rt_amt")){ 
                		sheetObj.CellBackColor(i, j) = sheetObj.UnEditableColor;
                	}else{
                		sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                	}
                	// 처음 load 시의 컬러로 font color 셋팅 ( 기준 컬러 ; dry tariff )
                    sheetObj.CellFontColor(i, j) = sheetObj.RgbColor(sheetObj.CellFontColor(i, "gline_20ft_rail_frt_rt_amt"),0,0);
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
    }
	
	function add2Tooltip(row, col, msg) {
        var sheetObj = sheetObjects[0];
        sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
        sheetObj.ToolTipText(row, col) +="\n- " +  msg;
        // amnd 상태에서 add 한 row 인 경우 font color = black 으로 셋팅
        sheetObj.CellFontColor(row, col) = sheetObj.RgbColor(0,0,0);
    }
