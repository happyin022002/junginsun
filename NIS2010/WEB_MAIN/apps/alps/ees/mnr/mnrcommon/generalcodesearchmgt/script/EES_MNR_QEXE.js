/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EES_MNR_QEXE.js
*@FileTitle : EES_MNR_QEXE
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 박명신
*@LastVersion : 1.0 
* 2009.09.04 박명신  
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
     * @extends Mnr   
     * @class ees_mnr_qexe : ees_mnr_qexe 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */ 
    function ees_mnr_qexe() {    
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
  
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	 
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Run":	
					doActionIBSheet(sheetObj,formObject,IBBATCH);		
				break;  
							 		
				case "btn_FileOpen":
					var msg = "select query."
					//오픈 경로 	
					var local_path = "C:\\hanjin_query";	
																
					var file = sheetObj.OpenFileDialog(msg,"",local_path,"SQL script(*.sql)|*.sql|All files(*.*)|*.*|Backup Files(*.~*)|*.~*");	
						
					if(file.indexOf('\\') == -1){
						break; 					
					}	
					//file load 	   
  					var fileObject = new ActiveXObject("Scripting.FileSystemObject");
									 	
					var fOpen = fileObject.OpenTextFile(file,1);
					var tempTxt = "";
					while(!fOpen.AtEndOfStream){
						tempTxt += fOpen.Readline();	
					}
					fOpen.close();	 
																
					tempTxt = tempTxt.replace(/;/g,';\n\n');				
					formObject.mnr_query.value = tempTxt;  
				break;
				
				case "btn_GetInsert":		
					doActionIBSheet(sheetObj,formObject,IBCREATE);
					break;
										 
				case "btn_SendEDI": 							
					doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01);  			
					//ComOpenWindowCenter("http://203.246.150.28:7001/hanjin/sppMain.ws?authKey=5555", "xx", 1024, 768, false, true);
					break;									 
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
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
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            initSheet(sheetObjects[i],i + 1); 
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
            case "sheet1":
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			}  		  
			break;  		
        }	
    }	
	
 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {	
			case IBBATCH:      //EXE
				if(validateForm(sheetObj,formObj,sAction)){	 
					var query = formObj.mnr_query.value;  
					query = query.replace(/&/g,'☞');   
					var sCondition = new Array (  	
						new Array("EesMnrQexe",query,ComGetObjValue(formObj.run_cnt)) 	
					)			
					var sXml = MnrQexeRun(sheetObj,sCondition);   
									
					if(MnrComGetErrMsg(sXml) == null){
						var arrXml = sXml.split("|$$|");	
						var retValue = new Array();	
						for(var i = 0; i < arrXml.length; i++){ 	  
							retValue[i] =  MnrXml2ComboString(arrXml[i], "cd_id", "cd_desc");
						} 	
						
						var resultStr = "";	
						if(retValue[0] != null){ 
							for(var j = 0; j < retValue[0].length;j++){ 
								var tempText = retValue[0][j].split("|");   
								resultStr += (tempText[0] + "\n RESULT ==>" + tempText[1] + "\n"); 
							}		
						}	
						//정상 처리시 결과 리턴 
						alert(resultStr);	
					} else {
						var exception = "Exception : " + ComGetEtcData(sXml,"Exception");
						var msg = "ERROR MSG : " + MnrComGetErrMsg(sXml)
						//에러 처리시 메세지 리턴
						alert(exception + "\n" + msg); 
					}	
					
				}	     	
				break;  
				
			case IBCREATE:      //GET
				if(validateForm(sheetObj,formObj,sAction)){		 
					var query = formObj.mnr_query.value;  
					query = query.replace(/&/g,'☞');
					var sCondition = new Array (  	
						new Array("EesMnrQexe",query, "GET")    	
					)	
					var comboList = MnrComSearchCombo(sheetObj,sCondition);   
						 
					var tempStr = "";    	 	  												
					if(comboList[0] != null){  	       
						for(var j = 0; j < comboList[0].length;j++){ 
							var tempText = comboList[0][j].split("|");	 		  		
							tempStr += (tempText[1] + "\n"); 						
						}		  			 				    
					}				  
					   
					var resultStr = formObj.mnr_query.value;
					resultStr += "\n\n ============================================  RESULT ============================================\n\n";
					resultStr += tempStr;  
					formObj.mnr_query.value = resultStr;		 		   
				}			     	
				break;  
				
			case IBSEARCH_ASYNC01:      //EDI SEND 
				if(validateForm(sheetObj,formObj,sAction)){		 
					var f_query = '';					
					f_query += 'f_cmd' + '=' + COMMAND40 + '&'; 
					f_query += 'ibflag=X&';	 			
					f_query += 'del_chk=0&'; 	  
					f_query += 'check_type' + '=' + '' + '&';	
					f_query += 'check_value' + '=' + '';	
																		        
					var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
				}				     	
				break;  
					
			case IBCLEAR:      //초기화    
				break;
		}		
    }     


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */         
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){      
			if(sAction==IBSEARCH) {        
				//if (!ComChkValid(formObj)) return false;        
			} 	 	
        }       	
        return true; 
    }
	
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	}             
			   	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
			
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
						
	function obj_change(){ 	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "":       
				   	break;      
			}       
	    } 
	}    
				        
	function obj_keypress(){   
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
					 			              
	    switch(obj.dataformat) {   
	        case "ymd":   
	        case "int":       
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":    
	            ComKeyOnlyNumber(obj, "-.");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup":   
				ComKeyOnlyAlphabet('uppernum');            
	            break; 
	    }         
	}	

/* 개발자 작업  끝 */