/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0206.js
*@FileTitle : Criteria for out guage calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.08 이병규
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
     * @class esm_bkg_0206 : esm_bkg_0206 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0206() {
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

//    // 공통전역변수
//    var tabObjects = new Array();
//    var tabCnt = 0 ;
//    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var valCnt = "";
    var waitFlg = "";
    
    var opener = window.dialogArguments;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {    
	        	case "btn_ok":	
	        		if(!validateForm(sheetObject1, formObject, "btn_ok")) {
	        			return;
	        		}
	        		comPopupOK();					                								
					break;
					
				case "out_btn1":    					                					    	     		
					document.getElementById("imdg_pck_tp_cd").value = "O";
					document.getElementById("pck_tp_seq").value = "1";
					document.getElementById("temp_pck_tp_cd").value = document.getElementById("out_imdg_pck_cd1").value;
					document.getElementById("temp_imdg_pck_desc").value = document.getElementById("out_imdg_pck_desc1").value;				                	
					var url = "ESM_BKG_1045.do";					                	
					ComOpenWindowCenter(url, "ESM_BKG_1045", 700, 660, true);
                	//ComOpenWindow(url, "ESM_BKG_1045", "width=700,height=620", false);
					
					//formObject.imdg_pck_tp_cd.value = "O";
					//formObject.pck_tp_seq.value = "1";
					//formObject.temp_pck_tp_cd.value = formObject.out_imdg_pck_cd1.value;
					//formObject.temp_imdg_pck_desc.value = formObject.out_imdg_pck_desc1.value;
					//window.open("ESM_BKG_1045.do", "ESM_BKG_1045", "");
					//var url = "ESM_BKG_1045.do";					                	
                	//ComOpenWindow(url, "ESM_BKG_1045", "width=700,height=620", false);
					break;
	                	
				case "out_btn2":
                	document.getElementById("imdg_pck_tp_cd").value = "O";
                	document.getElementById("pck_tp_seq").value = "2";
                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("out_imdg_pck_cd2").value;
                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("out_imdg_pck_desc2").value;
                	var url = "ESM_BKG_1045.do";
					ComOpenWindowCenter(url, "ESM_BKG_1045", 700, 660, true);								
					break;
					
				case "intmd_btn1":	
                	document.getElementById("imdg_pck_tp_cd").value = "M";
                	document.getElementById("pck_tp_seq").value = "3";
                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("intmd_imdg_pck_cd1").value;
                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("intmd_imdg_pck_desc1").value;
                	var url = "ESM_BKG_1045.do";
					ComOpenWindowCenter(url, "ESM_BKG_1045", 700, 660, true);								
					break;
	                	
				case "intmd_btn2":		
                	document.getElementById("imdg_pck_tp_cd").value = "M";
                	document.getElementById("pck_tp_seq").value = "4";
                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("intmd_imdg_pck_cd2").value;
                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("intmd_imdg_pck_desc2").value;
                	var url = "ESM_BKG_1045.do";
					ComOpenWindowCenter(url, "ESM_BKG_1045", 700, 660, true);								
					break;	
	                	
	            case "in_btn1":	
	            	document.getElementById("imdg_pck_tp_cd").value = "I";
	            	document.getElementById("pck_tp_seq").value = "5";
	            	document.getElementById("temp_pck_tp_cd").value = document.getElementById("in_imdg_pck_cd1").value;
	            	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("in_imdg_pck_desc1").value;
	            	var url = "ESM_BKG_1045.do";
	            	ComOpenWindowCenter(url, "ESM_BKG_1045", 700, 660, true);								
					break;
	                	
                case "in_btn2":		
                	document.getElementById("imdg_pck_tp_cd").value = "I";
                	document.getElementById("pck_tp_seq").value = "6";
                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("in_imdg_pck_cd2").value;
                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("in_imdg_pck_desc2").value;
                	var url = "ESM_BKG_1045.do";
                	ComOpenWindowCenter(url, "ESM_BKG_1045", 700, 660, true);								
					break;	

				case "btn_Close":
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
        
    function initControl() {    	  
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)      	   
    	axon_event.addListenerForm('blur', 'obj_blur', document.form);
    	//axon_event.addListenerForm('change','obj_change', form);
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  document.form);   
        axon_event.addListenerFormat('keypress', 	   'obj_keypress',   document.form); //- 키보드 입력할때   	    
  	}  
        
    function obj_deactivate(){
    	var objName = event.srcElement.name;
    	switch (objName) {
	     	case "out_imdg_pck_qty1":	
	     		var str = document.getElementById("out_imdg_pck_qty1").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("out_imdg_pck_qty1").value = str;
	     		if(document.getElementById("out_imdg_pck_qty1").value == "NaN"){	     			
	     			document.getElementById("out_imdg_pck_qty1").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		calWgt();
		     	break;
	     	case "in_imdg_pck_qty1":	
	     		var str = document.getElementById("in_imdg_pck_qty1").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("in_imdg_pck_qty1").value = str;
	     		if(document.getElementById("in_imdg_pck_qty1").value == "NaN"){	     			
	     			document.getElementById("in_imdg_pck_qty1").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		calWgt();
		     	break;
	     	case "grs_capa_qty":	
	     		var str = document.getElementById("grs_capa_qty").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("grs_capa_qty").value = str;
	     		if(document.getElementById("grs_capa_qty").value == "NaN"){	     			
	     			document.getElementById("grs_capa_qty").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		calWgt();
	     		break;
	     	case "out_imdg_pck_qty2":	
	     		var str = document.getElementById("out_imdg_pck_qty2").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("out_imdg_pck_qty2").value = str;
	     		if(document.getElementById("out_imdg_pck_qty2").value == "NaN"){	     			
	     			document.getElementById("out_imdg_pck_qty2").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		break;
	     	case "intmd_imdg_pck_qty2":	
	     		var str = document.getElementById("intmd_imdg_pck_qty2").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("intmd_imdg_pck_qty2").value = str;
	     		if(document.getElementById("intmd_imdg_pck_qty2").value == "NaN"){	     			
	     			document.getElementById("intmd_imdg_pck_qty2").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		break;
	     	case "intmd_imdg_pck_qty1":	
	     		var str = document.getElementById("intmd_imdg_pck_qty1").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("intmd_imdg_pck_qty1").value = str;
	     		if(document.getElementById("intmd_imdg_pck_qty1").value == "NaN"){	     			
	     			document.getElementById("intmd_imdg_pck_qty1").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		break;
	     	case "in_imdg_pck_qty2":	
	     		var str = document.getElementById("in_imdg_pck_qty2").value;	     		
	     		str = str.replace(/,/gi, ""); 	     		
	     		str = parseFloat(str);
	     		document.getElementById("in_imdg_pck_qty2").value = str;
	     		if(document.getElementById("in_imdg_pck_qty2").value == "NaN"){	     			
	     			document.getElementById("in_imdg_pck_qty2").value = 0;
	     			ComShowCodeMessage("BKG95079");
	     		}
	     		break;
	     	
    	}    	
    }
    
    function obj_blur(){        	
    	var objName = event.srcElement.name;
         	
    	switch (objName) {
	     	case "out_imdg_pck_cd1":	     	     		
	     		valCnt = "1";	    
	     		document.getElementById("imdg_pck_tp_cd").value = "O";
	     		document.getElementById("out_imdg_pck_cd1").value = (document.getElementById("out_imdg_pck_cd1").value).toUpperCase();
	     		document.getElementById("imdg_pck_cd").value = document.getElementById("out_imdg_pck_cd1").value;
	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	     		break;	
			
	     	case "out_imdg_pck_cd2":     	     		    	     		
	     		valCnt = "2";    	     		
	     		document.getElementById("imdg_pck_tp_cd").value = "O";    	     		
	     		document.getElementById("out_imdg_pck_cd2").value = (document.getElementById("out_imdg_pck_cd2").value).toUpperCase();    	     		
	     		document.getElementById("imdg_pck_cd").value = document.getElementById("out_imdg_pck_cd2").value;    	     		
	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	     		
	     		break;	
			
	     	case "intmd_imdg_pck_cd1":	     		
	     		valCnt = "3";	    
	     		document.getElementById("imdg_pck_tp_cd").value = "M";
	     		document.getElementById("intmd_imdg_pck_cd1").value = (document.getElementById("intmd_imdg_pck_cd1").value).toUpperCase();
	     		document.getElementById("imdg_pck_cd").value = document.getElementById("intmd_imdg_pck_cd1").value;
	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	     		break;	
			
	     	case "intmd_imdg_pck_cd2":	     		
	     		valCnt = "4";	    
	     		document.getElementById("imdg_pck_tp_cd").value = "M";
	     		document.getElementById("intmd_imdg_pck_cd2").value = (document.getElementById("intmd_imdg_pck_cd2").value).toUpperCase();
	     		document.getElementById("imdg_pck_cd").value = document.getElementById("intmd_imdg_pck_cd2").value;
	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	     		break;	
			
	     	case "in_imdg_pck_cd1":	     		
	     		valCnt = "5";	     	
	     		document.getElementById("imdg_pck_tp_cd").value = "I";
	     		document.getElementById("in_imdg_pck_cd1").value = (document.getElementById("in_imdg_pck_cd1").value).toUpperCase();
	     		document.getElementById("imdg_pck_cd").value = document.getElementById("in_imdg_pck_cd1").value;
	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	     		break;	
			
	     	case "in_imdg_pck_cd2":	     		
	     		valCnt = "6";	     	
	     		document.getElementById("imdg_pck_tp_cd").value = "I";
	     		document.getElementById("in_imdg_pck_cd2").value = (document.getElementById("in_imdg_pck_cd2").value).toUpperCase();
	     		document.getElementById("imdg_pck_cd").value = document.getElementById("in_imdg_pck_cd2").value;
	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	     		break;	
	     		
	     	
//	     	case "out_imdg_pck_qty1":
////	     		document.getElementById("out_imdg_pck_qty1").value = parseFloat(document.getElementById("out_imdg_pck_qty1").value);
//	     		var str = document.getElementById("out_imdg_pck_qty1").value;
//	     		
//	     		str = str.replace(/,/gi, ""); 
//	     		
//	     		str = parseFloat(str);
//	     		document.getElementById("out_imdg_pck_qty1").value = str;
//	     		if(document.getElementById("out_imdg_pck_qty1").value == "NaN"){
//	     			
//	     			document.getElementById("out_imdg_pck_qty1").value = 0;
//	     			alert("Input Error!");
//	     		}
//	    		break;
	     		
	     		
    	}
	}   
     
    function obj_keypress(){       
	    switch(event.srcElement.dataformat){
	        case "int":		//숫자
	            ComKeyOnlyNumber(event.srcElement);  
	            break;	    
	        case "float":	//숫자+"."	            
	            ComKeyOnlyNumber(event.srcElement, "."); 
	            break;	    
	    	case "engup":
		        //영문대문자
	    		ComKeyOnlyAlphabet('upper');
		        break;
	        case "engupnum":
	            //숫자+"영문대분자"입력하기
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	    }
	    
		switch (event.srcElement.name) {		
			case "out_imdg_pck_qty1":		    	
				ComKeyOnlyNumber(event.srcElement, ".");   	
    			break;    			
    		case "out_imdg_pck_qty2":		    	
    			ComKeyOnlyNumber(event.srcElement, ".");   	
    			break;    			
		    case "in_imdg_pck_qty1":		    	
		    	ComKeyOnlyNumber(event.srcElement, ".");		    	
    			break;    			
		    case "in_imdg_pck_qty2":		    	
		    	ComKeyOnlyNumber(event.srcElement, "."); 		    	
    			break;     			
		    case "intmd_imdg_pck_qty1":		    	
		    	ComKeyOnlyNumber(event.srcElement, ".");		    	
    			break;    			
		    case "intmd_imdg_pck_qty2":		    	
		    	ComKeyOnlyNumber(event.srcElement, "."); 		    	
    			break;     			
		    case "max_in_pck_qty":		    	
		    	ComKeyOnlyNumber(event.srcElement, "-."); 		    	
    			break;
		}	
	}
        
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {    	
    	initControl();
    	calWgt();
	}
         
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj; 			
    }    
     
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
            case IBSEARCH:      
            	if(validateForm(sheetObj,formObj,sAction)) {							
            		//sheetObj.WaitImageVisible = false;
            		formObj.f_cmd.value = SEARCH;						
            		var rXml = sheetObj.GetSearchXml("ESM_BKG_0206GS.do", FormQueryString(formObj));
					var imdg_pck_desc = ComGetEtcData(rXml, "imdg_pck_desc");
					
					if(valCnt == "1"){
						document.getElementById("out_imdg_pck_desc1").value = imdg_pck_desc;							
						if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
							//ComShowCodeMessage("BKG00044", "1st Outer Package");
							ComAlertFocus(document.getElementById("out_imdg_pck_cd1"),  ComGetMsg("BKG00044", "1st Outer Package"));
						}	
					}
					if(valCnt == "2"){							
						document.getElementById("out_imdg_pck_desc2").value = imdg_pck_desc;
						if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
							//ComShowCodeMessage("BKG00044", "2st Outer Package");
							ComAlertFocus(document.getElementById("out_imdg_pck_cd2"),  ComGetMsg("BKG00044", "2nd Outer Package"));
						}	
					}
					if(valCnt == "3"){
						document.getElementById("intmd_imdg_pck_desc1").value = imdg_pck_desc;
						if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
							//ComShowCodeMessage("BKG00044", "1st Intermediate Package");
							ComAlertFocus(document.getElementById("intmd_imdg_pck_cd1"),  ComGetMsg("BKG00044", "1st Intermediate Package"));
						}	
					}
					if(valCnt == "4"){
						document.getElementById("intmd_imdg_pck_desc2").value = imdg_pck_desc;						
						if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
							//ComShowCodeMessage("BKG00044", "2st Intermediate Package");
							ComAlertFocus(document.getElementById("intmd_imdg_pck_cd2"),  ComGetMsg("BKG00044", "2nd Intermediate Package"));
						}
					}
					if(valCnt == "5"){
						document.getElementById("in_imdg_pck_desc1").value = imdg_pck_desc;						
						if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
							//ComShowCodeMessage("BKG00044", "1st Inner Package");
							ComAlertFocus(document.getElementById("in_imdg_pck_cd1"),  ComGetMsg("BKG00044", "1st Inner Package"));
						}
					}
					if(valCnt == "6"){
						document.getElementById("in_imdg_pck_desc2").value = imdg_pck_desc;						
						if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
							//ComShowCodeMessage("BKG00044", "2st Inner Package");
							ComAlertFocus(document.getElementById("in_imdg_pck_cd2"),  ComGetMsg("BKG00044", "2nd Inner Package"));
						}
					}						
					//sheetObj.WaitImageVisible = true;						
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
    	with(formObj){
        	switch (sAction) {
    			case "btn_ok":
    				if(imdg_lmt_qty_flg.value == "Y"){
//    					- Limited Q'ty 규정을 위반하여 입력되는 application에 대해 팝업 공지 필요 (승인 지연의 주원인 중 하나임)
//    					1) Gross Weight / Outer Package Q'TY 가 30KGS 이 초과하는 경우
	    				var n_out_imdg_pck_qty = out_imdg_pck_qty1.value.replace(",", "");
	    				var n_grs_wgt 		   = grs_wgt.value.replace(",", "");
	    				if(n_out_imdg_pck_qty == "") n_out_imdg_pck_qty = "0";
	    				if(n_grs_wgt 	      == "") n_grs_wgt 			= "0";
	
	    				if(n_out_imdg_pck_qty != "" && Number(n_out_imdg_pck_qty) > 0){
	    		    		if(Number(n_grs_wgt) / Number(n_out_imdg_pck_qty) > 30.0){
	        					ComShowCodeMessage("BKG08272");    		    			
	    		    			return false;
	    		    		}
	    				}    
    				}
    		    	break;		    	
        	}
    	}
        return true;
    }
      
    function calWgt(){              
    	if(document.form.grs_wgt.value != '' && document.form.grs_wgt.value != '0'
    		&& document.form.out_imdg_pck_qty1.value != '' && document.form.out_imdg_pck_qty1.value != '0'){
    		var grs_per_unit = eval(document.form.grs_wgt.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));                        
    		document.form.grs_per_unit.value = commitfy(roundXL(grs_per_unit, 3));
    	} else {
    		document.form.grs_per_unit.value = "N/A";
    	}
        
    	if(document.form.net_wgt.value != '' && document.form.net_wgt.value != '0'
    		&& document.form.in_imdg_pck_qty1.value != '' && document.form.in_imdg_pck_qty1.value != '0'){
    		var net_per_unit = eval(document.form.net_wgt.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
    		document.form.net_per_unit.value = commitfy(roundXL(net_per_unit, 3));
    	} else {
    		document.form.net_per_unit.value = "N/A";
    	}
        
    	if(document.form.grs_capa_qty.value != '' && document.form.grs_capa_qty.value != '0'
    		&& document.form.in_imdg_pck_qty1.value != '' && document.form.in_imdg_pck_qty1.value != '0'){
    		var max_per_unit = eval(document.form.grs_capa_qty.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
    		document.form.max_per_unit.value = commitfy(roundXL(max_per_unit, 3));
    	} else {
    		document.form.max_per_unit.value = "N/A";
    	}       
	}

    function commitfy(n) { 
    	var reg = /(^[+-]?\d+)(\d{3})/;
    	n += '';
    	while(reg.test(n))
    		n = n.replace(reg,'$1'+','+'$2');
    	return n;
    }        
    
    function roundXL(n, digits) {
        if(digits >= 0) return parseFloat(n.toFixed(digits));
        digits = Math.pow(10, digits);
        var t = Math.round(n * digits) / digits;
        return parseFloat(t.toFixed(0));
    }
    
	/* 개발자 작업  끝 */