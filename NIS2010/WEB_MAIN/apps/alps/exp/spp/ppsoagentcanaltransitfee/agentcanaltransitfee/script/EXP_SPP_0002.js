/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0002.js
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.22 김성광
* 1.0 Creation
*  
* History
* 2012.02.17 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
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
     * @class EXP_SPP_0002 : EXP_SPP_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EXP_SPP_0002() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_change 			= obj_change;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_activate 			= obj_activate;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setBtnEnable 			= setBtnEnable;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var ROWMARK = "|";
    var FIELDMARK = ",";    
    var ALLOWANCETEU = "cntr_pnm_capa";
    var CHANGEDVALUE = false;
    var GlobalRevYrmon = "";  	//캘린더 선택시 revyr 오브젝트에 change 이벤트가 발생하지 않는 문제 해결을 위해. 
	   							//focus 위치시 값을 저장해놓고
    							//blur 시 이전값과 비교해서 change 이벤트 임의 발생시킴.    

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

    	          case "btn_DownExcel":
    	        	    if(sheetObject1.RowCount <= 0){
    	        	        ComCodeMsgByNoRelatedData();  // There is no related data!
    	        	        return;
    	        	    }else{
    	        	        if(sheetObject1.RowCount > 0){
    	        	        	var strTitle = ""
    	        	        	if(formObject.vndr_cnt_cd.value == "PA"){
    	        	        		strTitle = "  VVD : "+formObject.vvdText.value+",  Rev. Month : "+formObject.rev_yrmon.value+",  TTL Amount : "+formObject.ttl_amt.value+",  Allowance TEU : "+formObject.cntr_pnm_capa.value+"  "  ;
    	        	        	}else{
    	        	        		strTitle = "  VVD : "+formObject.vvdText.value+",  Rev. Month : "+formObject.rev_yrmon.value+",  TTL Amount : "+formObject.ttl_amt.value+",  SCNT : "+formObject.suz_net_tong_wgt.value+",  SDR : "+formObject.locl_xch_rt.value+",  Tier : "+formObject.tr_vol_val.value+"  "  ;
    	        	        	}
    	        	        	sheetObject1.CellValue(0,1)  = strTitle;
    	        	        	sheetObject1.RowHidden(0) = false;
    	        	        	sheetObject1.SpeedDown2Excel(-1,false,false,"","/apps/alps/exp/spp/ppsoagentcanaltransitfee/agentcanaltransitfee/xml/EXP_SPP_0002_FORMAT.xml",true,false,"",false);
    	        	        	sheetObject1.RowHidden(0) = true;
    	        	        }
    	        	    } 
    	        	    break;
						
				  case "btn_Request":
					  	var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					  	if(procSts!="R") break;  //Ready 가 아닌 경우에는 Request 할 수 없음.
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("ADV Payment Rev. Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
					    doActionIBSheet(sheetObject1,formObject,COMMAND01);
						break;
						
				  case "btn_Save":
					    var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					    if(procSts!="" && procSts!="R") break;  //Ready 상태가 아닌 경우에는 Save 할 수 없음.
					    
						//"ADV. Payment TTL Amount" 값과 "Estimate TTL Amount" 값이 서로 다를 경우 메시지 출력 후 return
						//alert(ComReplaceStr(formObject.ttl_amt.value,",","")+" : "+sheetObject1.SumValue(0, "sheet1_rqst_amt"));
					    if(ComReplaceStr(formObject.ttl_amt.value,",","") != sheetObject1.SumValue(0, "sheet1_rqst_amt")){
							ComCodeMsgByUnMatchData("ADV. Payment TTL Amount", "Estimate TTL Amount");  //[{?msg1}] is different from [{?msg2}].
							return;
						}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;	
						
			      case "btns_calendar":
			    	  	GlobalRevYrmon = document.form.rev_yrmon.value;
			        	
			        	var cal = new ComCalendar();
			        		cal.setDisplayType('month');
          					cal.select(formObject.rev_yrmon, 'yyyy-MM');
			        	
			            break;						

            } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("SPP01003");
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
            initControl();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
         
         /**
          * Form데이터포멧 키 프레스 관련 
          */
         function initControl() {
             //- form 전체 컨트롤 중  모든 컨트롤의 OnKeyPress이벤트에 코드 처리        	  
			 axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur 이벤트에 코드 처리 
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus 이벤트에 코드 처리
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnChange이벤트에 코드 처리			 
			 axon_event.addListenerFormat('change', 'obj_change',    	form);
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyUp 이벤트에 코드 처리
			 axon_event.addListenerFormat('keyup', 'obj_keyup',    		form);			 
			// axon_event.addListenerForm('click',	'obj_click',	form); //- 클릭하였을 때
			 //focusSetting
			// document.form.rev_yrmon.focus();
			 GlobalRevYrmon = document.form.rev_yrmon.value;
       	 }
            
         /*
          * OnBlur 이벤트에 코드 처리
          */ 
         function obj_deactivate(){
      	     obj = event.srcElement;
             if(ComChkObjValid(event.srcElement)){
           	     if(obj.name=="rev_yrmon"){  //캘린더에서 날짜 선택시 onchange 이벤트 발생되지 않아 수동으로 처리함.
        		     if(ComReplaceStr(GlobalRevYrmon,"-","") != ComReplaceStr(document.form.rev_yrmon.value,"-","")){
        			     obj_change();
        			     GlobalRevYrmon = document.form.rev_yrmon.value;
        		     }
        		     return; 
        	     }
             }             
         }

         /*
          * OnChange이벤트에 코드 처리
          */
         function obj_change(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
        	       case "rev_yrmon":
        	       case "ttl_amt":
        	       case "suz_net_tong_wgt":	  
        	       case "locl_xch_rt":	
        	       case "tr_vol_val":
        	       case "cntr_pnm_capa":   
        	    	   CHANGEDVALUE = true;
        		       break;
        		   default:
        			   break;
        	   }
         } 
         
         /*
          * OnKeyUp 이벤트에 코드 처리
          */
         function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
        	       case "rev_yrmon":
        	       case "ttl_amt":
        	       case "suz_net_tong_wgt":	  
        	       case "locl_xch_rt":	
        	       case "tr_vol_val":
        	       case "cntr_pnm_capa":   
        	    	   ComKeyEnter('LengthNextFocus');  //maxlength 까지 값이 입력되면 자동으로 다음 object 로 커서 이동.
        		       break;
        		   default:
        			   break;
        	   }
         }         
         
         /*
          * OnFocus 이벤트에 코드 처리
          */
         function obj_activate(){
        	 obj = event.srcElement;
             ComClearSeparator(event.srcElement); 
             ComShowFocusCursor(obj);  //특정 event 로 인해서 사라진 포커스를 보여줌.
         }         

         /*
          * OnKeyPress이벤트에 코드 처리
          */
         function obj_keypress(){
         	 obj = event.srcElement;
        	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

        	 if(obj.dataformat == null) return;
      	    
        	 window.defaultStatus = obj.dataformat;
        	
        	 switch(obj.dataformat) {
        	     case "ymd":
        	     case "ym":
         	 		ComKeyOnlyNumber(obj);
        	 		break;        	    	 
        	     case "hms":
        	     case "hm":
        	     case "jumin":
        	     case "saupja":
        	         ComKeyOnlyNumber(obj);
        	         break;
        	     case "int":
        	         if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
        	         else ComKeyOnlyNumber(obj);
        	         break;
        	     case "float":
        	         ComKeyOnlyNumber(obj, "-.");
        	         break;
        	     case "eng":
        	         ComKeyOnlyAlphabet(); break;
        	     case "engup":
        	         if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
        	         else ComKeyOnlyAlphabet('upper');
        	         break;
        	     case "engdn":
        	         if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
        	         else ComKeyOnlyAlphabet('lower');
        	         break;
        	 }
         }             


        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    	  var sheetid = sheetObj.id;
    	  var onepagerows = document.form.pagerows.value;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 400;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(2, 1, 3, onepagerows);
    							
    							//var HeadTitle1 = "|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Tariff Amount|Diff.|Detail"; //ORG .. BUT DETAIL DEL.
    							
    							var HeadTitle2 = "";       
    							var HeadTitle1 = "|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Hidden3";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 9, 0, true);
    							
    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(false, true, false, true, false,false);
    							
    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							
    							InitHeadRow(0, HeadTitle2, false);
   			                 	InitHeadRow(1, HeadTitle1 , true);

    							var prefix = "sheet1_";
    							//데이터속성          [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtSeq,			50,	daCenter,	true,	"Seq");
    							InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix+"lgs_cost_cd",		false,	"",	dfNone,			0,		false,	true);
    							InitDataProperty(0, cnt++ , dtData,			280,daLeft,		true,	prefix+"lgs_cost_full_nm",	false,	"",	dfNone,			0,		false,	true);
    							InitDataProperty(0, cnt++ , dtAutoSum,		150,daRight,	true,	prefix+"rqst_amt",			false,	"",	dfNullFloat,	2,		true,	true, 18);
    							InitDataProperty(0, cnt++ , dtData,			300,daLeft,		true,	prefix+"diff_rmk" ,			false,	"",	dfNone,			0,		true,	true, 50);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix+"yd_cd",				false,	"",	dfNone,			0,		true,	true);
    							
    							//한글 입력 불가능
    							InitDataValid(0, prefix+"diff_rmk", vtEngOther, "1234567890!@#$%^&*()_-+=[{]}|\\;:\"\'<,>.?/~` ");
    						  	Ellipsis  	 = true;
    							RowHidden(0) = true;
    							
    						}
    						break;   						
						
            }
        }

        /*
         * Sheet관련 프로세스 처리
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				if(validateForm(sheetObj,formObj,sAction)){
					if (sheetObj.id == "sheet1"){
						
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						
						ComClearFormSeparator(formObj);  //마스크  제거
						var sXml = sheetObj.GetSearchXml("EXP_SPP_0002GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSearchXml(sXml);
						
						//sheet1_OnSearchEnd 이벤트가 먼저 실행 된다.
						
						//Allowance TEU 값 셋팅
						var arrRslt = ComGetEtcData(sXml, ALLOWANCETEU).split(FIELDMARK);
						formObj.rev_yrmon.value = ((arrRslt[0]=="")?formObj.ntc_yrmon.value:arrRslt[0]);
						formObj.ttl_amt.value = ((arrRslt[1]=="")? "0.00":arrRslt[1]);
						if(formObj.vndr_cnt_cd.value != "PA") formObj.suz_net_tong_wgt.value = arrRslt[2];
						if(formObj.vndr_cnt_cd.value != "PA")formObj.locl_xch_rt.value = arrRslt[3];
						if(formObj.vndr_cnt_cd.value != "PA")formObj.tr_vol_val.value = arrRslt[4];
						formObj.cnl_tz_proc_sts_cd.value = arrRslt[5];
						if(formObj.vndr_cnt_cd.value == "PA") formObj.cntr_pnm_capa.value = arrRslt[6];
						//formObj.attach_file.value = ComGetEtcData(sXml, "attach_file");
						ComSetFormSeparator(formObj);  //마스크 다시 셋팅						
						
						
						//Request 및 Save 버튼의 활성화 비활성화 처리
						setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());
						CHANGEDVALUE = false;
						GlobalRevYrmon = formObj.rev_yrmon.value;
						
						ComOpenWait(false);
					}
				}
				break;
	              
			  case IBSAVE:		//Save
                if(validateForm(sheetObj,formObj,sAction)){
 	    		  	
  	    		  	//transaction 발생한 건이 없을 경우 return
  					if (!sheetObj.IsDataModified && !CHANGEDVALUE) {				
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}  

  					//multi 데이터 처리
  	    		  	formObj.f_cmd.value = MULTI;   	
  	    		  	formObj.cnl_tz_proc_sts_cd.value = "R";

  	    		    ComClearFormSeparator(formObj);  //마스크  제거
  					var sParam = FormQueryStringOrg(formObj);
  					ComSetFormSeparator(formObj);  //마스크 다시 셋팅

  					var sParam1 = sheetObj.GetSaveString();
   					if (sParam1 == "" && !CHANGEDVALUE) {				
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}
  	    		  	// 저장하시겠습니까?
  	    			if(!ComCodeMsgBySave()) return;  					
  					
  					sParam = sParam + "&" + sParam1;  //Ready
  					
  	  	    		//저장. 저장 후 OnSaveEnd 이벤트 발생
  	  				//sheetObj.ShowDebugMsg = true;
  	  	    		var sXml = sheetObj.GetSaveXml("EXP_SPP_0002GS.do", sParam);
  	  	    		//sheetObj.ShowDebugMsg = false;
  	  	    		sheetObj.LoadSaveXml(sXml);  //저장된 내용 sheet 에 반영 후 OnSaveEnd 이벤트 발생
  	  	    									 //저장 후 새로 조회하지 않아도 됨.
  					
  	    			
  	    			//OnSaveEnd 후에 실행된다.
                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
                		CHANGEDVALUE = false;
                		GlobalRevYrmon = formObj.rev_yrmon.value;
                		formObj.cnl_tz_proc_sts_cd.value = "R";
						//Request 및 Save 버튼의 활성화 비활성화 처리
						setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());	 
						
		    			//adv_py_sts, adv_py_rev_mon, diff_rmk 값을 opener 창에 return.
		            	var strRslt = formObj.cnl_tz_proc_sts_cd.value;
		            	strRslt += "|"+ ComReplaceStr(formObj.rev_yrmon.value,"-","");
		            	strRslt += "|"+ ((formObj.diff_rmk.value.toLowerCase().indexOf("reject")!=-1)?"":formObj.diff_rmk.value);
						window.returnValue = strRslt;
                	}            	
                }
                break;
                
			  case COMMAND01:	//Request
    		  	//transaction 발생한 건이 있을 경우 return
				if (sheetObj.IsDataModified || CHANGEDVALUE) {				
					ComShowCodeMessage("SPP01008");  //There is contents to save. First, save contents!
					return; 
				}  
				
				//multi 데이터 처리
    		  	formObj.f_cmd.value 			 = COMMAND01; 
    		  	formObj.cnl_tz_proc_sts_cd.value ='Q';

    		  	ComClearFormSeparator(formObj);  //마스크  제거
				var sParam = FormQueryStringOrg(formObj);
				ComSetFormSeparator(formObj);  //마스크 다시 셋팅
				
    		  	// Do you want to request contents finally?
    			if(!ComShowCodeConfirm('SPP01009')) return;
    		  	
    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0002GS.do", sParam);
    			
	    		//OnSaveEnd 후에 실행된다.
    			ComShowMessage(ComSaveXml2Message(sXml, "MESSAGE", 0));  //LoadSaveXml 을 하지 않았기 때문에 직접 메시지 띄움.
            	if(!ComSaveXml2IsTagExist(sXml, "ERROR")){  //ERROR 태그가 없으면
            		CHANGEDVALUE = false;
            		GlobalRevYrmon = formObj.rev_yrmon.value;
            		formObj.cnl_tz_proc_sts_cd.value = "Q";
					//Request 및 Save 버튼의 활성화 비활성화 처리
					setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());	            		
    			
	    			//adv_py_sts, adv_py_rev_mon, diff_rmk 값을 opener 창에 return.
	            	var strRslt = formObj.cnl_tz_proc_sts_cd.value;
	            	strRslt += "|"+ ComReplaceStr(formObj.rev_yrmon.value,"-","");
	            	strRslt += "|"+ ((formObj.diff_rmk.value.toLowerCase().indexOf("reject")!=-1)?"":formObj.diff_rmk.value);
					window.returnValue = strRslt;
					self.close();
            	}
    			
    			break;                
           }
        }       
        
        /**
        * Request 및 Save 버튼의 활성화 비활성화 처리
        */        
        function setBtnEnable(procSts){
			//Request 버튼 활성화/비활성화
		    if(procSts!="R"){  //Ready 가 아닌 경우에는 Request 할 수 없음.				
				btn_Request.disabled = true;
		    }else{
		    	btn_Request.disabled = false;
		    }
			
		    //Save 버튼 활성화/비활성화
		    if(procSts!="" && procSts!="R"){  //저장된 적이 없거나 Ready 상태가 아닌 경우에는 Request 할 수 없음.
		    	btn_Save.disabled = true; 
		    }else{
		    	btn_Save.disabled = false;
		    }        	
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 var prefix = "sheet1_";
        	 switch(sAction){
             	 case IBSEARCH:	//조회
             	 	if(ComIsEmpty(formObj.vndr_seq.value)){
             	 		ComCodeMsgByEmptyData("vndr_seq");
             	 		return false;
             	 	}  
	          	 	if(ComIsEmpty(formObj.vvd.value)){
	          	 		ComCodeMsgByEmptyData("vvd");
	         	 		return false;
	         	 	} 
	         	 	if(ComIsEmpty(formObj.yd_cd.value)){
	         	 		ComCodeMsgByEmptyData("yd_cd");
	         	 		return false;
	         	 	} 
	         	 	if(ComIsEmpty(formObj.call_seq.value)){
	         	 		ComCodeMsgByEmptyData("call_seq");
	         	 		return false;
	         	 	} 
	         	 	if(ComIsEmpty(formObj.ntc_yrmon.value)){
	         	 		ComCodeMsgByEmptyData("ntc_yrmon");
	         	 		return false;
	         	 	}          	 	
             	 	break;
             	 
	             default:
	            	break;
        	 }
        	 
        	 return true;
        }
 
        /*
         * sheet1 에 대한 조회 후 이벤트 처리
         */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg){
			var prefix = "sheet1_";
			with(sheetObj){

				var row = LastRow;
				SumText(0, "Seq") = "";
				SumText(0, prefix+"lgs_cost_full_nm") = "Estimate TTL Amount:";
				CellAlign(row, prefix+"lgs_cost_full_nm") = daRight;
				
			}
		}
    		
		/**
         * IBSheet Popup Event
         */
         function sheet1_OnPopupClick(sheetObj,Row,Col){
        	 var prefix = "sheet1_";
 			
             switch (sheetObj.ColSaveName(Col)) {
             	  case prefix + "diff_rmk" :
            	 	   var url = 'VOP_VSK_0218.do?strText='+sheetObj.CellValue(Row,Col);
            	 	   url = encodeURI(url);
            	 	   var rsltObj = ComOpenPopup(url, 340, 335, '', '0,0', true, false, Row, Col, 0, 'compopupRemark');

            	 	   if(rsltObj != undefined){  //닫기 버튼 클릭시의 반환 값 체크
	            	 	   sheetObj.CellValue2(Row, prefix + "diff_rmk") = rsltObj;
	             	   }
                  break;
  				
             }
         }    		

	/* 개발자 작업  끝 */