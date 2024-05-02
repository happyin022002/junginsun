/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0003.js
*@FileTitle : Request Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.27 김성광
* 1.0 Creation
*  
* History
* 2012.03.12 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
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
     * @class EXP_SPP_0003 : EXP_SPP_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EXP_SPP_0003() {
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
    	this.setCreditsTotal 		= setCreditsTotal;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick 		= sheet1_OnDblClick;
    	this.setCellEditable 		= setCellEditable;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	this.sheet1_OnPopupClick 	= sheet1_OnPopupClick;
    	
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var ROWMARK = "|";
    var FIELDMARK = ",";    
    var ALLOWANCETEU = "cntr_pnm_capa";
    var CHANGEDVALUE = false;   //rev_yrmon, ttl_amt, suz_net_tong_wgt, locl_xch_rt, tr_vol_val, cntr_pnm_capa, scg_rt_amt 값의 변경 유무
    var GlobalNtcYrmon = "";  	//캘린더 선택시 revyr 오브젝트에 change 이벤트가 발생하지 않는 문제 해결을 위해. 
	   							//focus 위치시 값을 저장해놓고
    							//blur 시 이전값과 비교해서 change 이벤트 임의 발생시킴.

	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	var fileUploadFlag = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){ 
        	
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
            var sheetObject = sheetObjects[0]; 
            var sheetObject1 	 = sheetObjects[1];
            var sheetObject_file = sheetObjects[2];
//            var sheetObject1 = sheetObjects[0];
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
    	        	        	//var strTitle = "  VVD : "+formObject.vvdText.value+",  Rev. Month : "+formObject.rev_yrmon.value+",  TTL Amount : "+formObject.ttl_amt.value+",  Transit Date : "+formObject.trns_dt.value+",  SCNT : "+formObject.suz_net_tong_wgt.value+",  SDR : "+formObject.locl_xch_rt.value+",  Tier : "+formObject.tr_vol_val.value+",  Limit Surcharge Amt : "+formObject.scg_rt_amt.value+",  Allowance TEU : "+formObject.cntr_pnm_capa.value+"  "  ;
    	        	        	var strTitle = ""
        	        	        if(formObject.vndr_cnt_cd.value == "PA"){
        	        	        	strTitle = "  VVD : "+formObject.vvdText.value+",  Rev. Month : "+formObject.rev_yrmon.value+",  TTL Amount : "+formObject.ttl_amt.value+",  Transit Date : "+formObject.trns_dt.value+",  Allowance TEU : "+formObject.cntr_pnm_capa.value+"  "  ;
        	        	        }else{
        	        	        	strTitle = "  VVD : "+formObject.vvdText.value+",  Rev. Month : "+formObject.rev_yrmon.value+",  TTL Amount : "+formObject.ttl_amt.value+",  Transit Date : "+formObject.trns_dt.value+",  SCNT : "+formObject.suz_net_tong_wgt.value+",  SDR : "+formObject.locl_xch_rt.value+",  Tier : "+formObject.tr_vol_val.value+",  Limit Surcharge Amt : "+formObject.scg_rt_amt.value+"  "  ;
        	        	        }
    	        	        	sheetObject1.CellValue(0,1)  = strTitle;
    	        	        	sheetObject1.RowHidden(0) = false;
    	        	        	sheetObject1.SpeedDown2Excel(1,false,false,"","/apps/alps/exp/spp/ppsoagentcanaltransitfee/agentcanaltransitfee/xml/EXP_SPP_0003_FORMAT.xml",true,false,"",false,"level|sheet1_yd_cd|sheet1_dseq|sheet1_aseq|sheet1_lgs_cost_cd_clss_lvl|sheet1_file_upload|sheet1_file_delete|sheet1_file_upld_nm|sheet1_file_sav_id");
    	        	        	sheetObject1.RowHidden(0) = true;
    	        	        }
    	        	    } 
    	        	    break;
						
				  case "btn_Request":
					  	var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					    if(procSts!="R") break;  //Ready 가 아닌 경우에는 Request 할 수 없음.
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("Invoice Rev. Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
					    doActionIBSheet(sheetObject1,formObject,COMMAND01);
						break;
						
				  case "btn_Save":
					    var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					    if(procSts!="" && procSts!="R") break;  //Ready 상태가 아닌 경우에는 Save 할 수 없음.
					    
						if(ComReplaceStr(formObject.ttl_amt.value,",","") != sheetObject1.SumValue(0, "sheet1_rqst_amt")){
							ComCodeMsgByUnMatchData("Actual invoice TTL Amount", "Debits TTL Amount");  //[{?msg1}] is different from [{?msg2}].
							return;
						}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;	
					/*	
			      case "btns_calendar":
			    	  	GlobalNtcYrmon = document.form.rev_yrmon.value;
			        	var cal = new ComCalendar();
			        		cal.setDisplayType('month');
          					cal.select(formObject.rev_yrmon, 'yyyy-MM');
			            break;						
					*/
					case "btn_FileAdd":
						var insertRowNo = 0;
						var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
						if(procSts!="" && procSts!="R") break;  //Ready 가 아닌 경우에는 File Add 할 수 없음.
					    sheetObject.DataInsert(sheetObject.Rows-1);
		    		    insertRowNo = sheetObject.Rows-1;  //맨 마지막 이전 줄로 삽입됨.
		    		    // sheetObject.CellValue(insertRowNo, "sq") = insertRowNo;
		    		    sheetObject.CellImage(insertRowNo, "file_upload") = 1;
		    		    
					break;

					case "btn_FileDelete":
						var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					    if(procSts!="" && procSts!="R") break;  //Ready 가 아닌 경우에는 File Delete 할 수 없음.
						//ComRowDelete(sheetObject,"del_chk")
						//sheetObject.RowDelete(sheetObject.SelectRow,false);
					    sheetObject.RowHidden(sheetObject.SelectRow)= true;		//2.행 숨기기		
					    sheetObject.RowStatus(sheetObject.SelectRow)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
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
       	 * IBUpload Object를 uploadObjects 배열에 등록
       	 * 배열은 소스 상단에 정의
       	 */
       	function setUploadObject(uploadObj){
       		uploadObjects[uploadCnt++] = uploadObj;
       	}

       	function initUpload(uploadObj, uploadNo) {
       		uploadObj.Files = "";
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
            
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			ComConfigUpload(uploadObjects[0], "/hanjin/SPP_INTGS.do");
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
			
			 //focusSetting
			 //document.form.rev_yrmon.focus();
			 GlobalNtcYrmon = document.form.rev_yrmon.value;
       	 }
            
         /*
          * OnBlur 이벤트에 코드 처리
          */
         function obj_deactivate(){
      	     obj = event.srcElement;
             if(ComChkObjValid(event.srcElement)){
           	     if(obj.name=="rev_yrmon"){  //캘린더에서 날짜 선택시 onchange 이벤트 발생되지 않아 수동으로 처리함.
        		     if(ComReplaceStr(GlobalNtcYrmon,"-","") != ComReplaceStr(document.form.rev_yrmon.value,"-","")){
        			     obj_change();
        			     GlobalNtcYrmon = document.form.rev_yrmon.value;
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
        	       case "scg_rt_amt":	   
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
        	       case "scg_rt_amt":	   
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
          * OnKeyUp 이벤트에 코드 처리
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

					case "sheet2":
		                with (sheetObj) {
							var prefix = "";
		
							// 전체 너비 설정
							SheetWidth = mainTable.clientWidth;
							// 높이 설정
							style.height = 85;
		
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;
		
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
		
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 13, 100);
		
							var HeadTitle1 = "|Del|File Attach|File Attach|";
		
							var headCount = ComCountHeadTitle(HeadTitle1);
		
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, false);
		
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);
		
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
		
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	 prefix + "ibflag");
		                    //InitDataProperty(0, cnt++ , dtData,			20,	daLeft,		true,	prefix+"sq",				false,	"", dfNone, 		0, 		false, 	true);
							InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,	 prefix+"del_chk",		false,		"",	dfNone,		0,		true,	true);
							InitDataProperty(0, cnt++ , dtImage,		20,		daCenter,	true,	 prefix + "file_upload",		false,  	"",		dfNone,		 0,		true,	    true);
							InitDataProperty(0, cnt++ , dtData,    		155,    daLeft,  	true,    prefix + "file_upld_nm",     	false,      "",     dfNone,      0,     true,		true);
							InitDataProperty(0, cnt++ , dtHidden,     	100,    daCenter,  	false,   prefix + "file_sav_id",   		false,      "",     dfNone,      0,     true,      true);
		
							CountPosition = 0;
		
							//ImageList에 이미지를 설정한다.
						  	ImageList(0)= "/hanjin/img/btns_search_off.gif";
						  	ImageList(1) = "/hanjin/img/btns_search.gif"; 
						  	InitDataImage(0, prefix + "file_upload", daCenter);
							ShowButtonImage = 1;
							ScrollBar = 2;
					}
					break;
					
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
    							
    							var HeadTitle2 = ""; 
    							var HeadTitle1 = "|Seq.|Hidden3|ITEM|COST CODE|CREDITS|DEBITS|Balance|Remark|Hidden1|Hidden2|Hidden4|Hidden5|File Attach|File Attach|File Attach|file id";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 6, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(false, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							
    							InitHeadRow(0, HeadTitle2, false);
   			                 	InitHeadRow(1, HeadTitle1 , true);

    							var prefix = "sheet1_";
    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtData,			60,	daLeft,		true,	prefix+"sq",				false,	"", dfNone, 		0, 		false, 	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"level",					false,	"",	dfNone,			0,		true,	true); 
    							InitDataProperty(0, cnt++ , dtData,			240,daLeft,		true,	prefix+"lgs_cost_full_nm",	false,	"",	dfNone,			0,		false,	true);
    							InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	prefix+"lgs_cost_cd",		false,	"",	dfNone,			0,		false,	true);    							
    							InitDataProperty(0, cnt++ , dtAutoSum,		120,daRight,	true,	prefix+"credits_amt",		false,	"",	dfNullFloat,	2,		false,	true, 18);
    							InitDataProperty(0, cnt++ , dtAutoSum,		120,daRight,	true,	prefix+"rqst_amt",			false,	"",	dfNullFloat,	2,		true,	true, 18);
    							InitDataProperty(0, cnt++ , dtAutoSum,		120,daRight,	true,	prefix+"balance",			false,	"|sheet1_credits_amt|-|sheet1_rqst_amt|", dfNullFloat, 2, true, true);
    							InitDataProperty(0, cnt++ , dtData,			180,daLeft,		true,	prefix+"diff_rmk" ,			false,	"",	dfNone,			0,		true,	true, 50);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix+"yd_cd",				false,	"",	dfNone,			0,		true,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix+"dseq",				false,	"",	dfNone,			0,		true,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix+"aseq",				false,	"",	dfNone,			0,		true,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix+"lgs_cost_cd_clss_lvl", false, "", dfNone, 0, true, true);
    							InitDataProperty(0, cnt++ , dtImage,		20,	daCenter,	true,	prefix+"file_upload",		false,  "",	dfNone,			0,		true,	true);
    							InitDataProperty(0, cnt++ , dtImage,		20,	daCenter,	true,	prefix+"file_delete",		false,  "",	dfNone,			0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			200,daLeft,		true,	prefix+"file_upld_nm",		false,	"",	dfNone,			0,		false,	false);
    							InitDataProperty(0, cnt++ , dtHidden,		200,daLeft,		true,	prefix+"file_sav_id",		false,	"",	dfNone,			0,		true,	true);
    							
    							InitTreeInfo(prefix+"lgs_cost_full_nm", prefix+"level");
    							//한글 입력 불가능
    							InitDataValid(0, prefix+"diff_rmk", vtEngOther, "1234567890!@#$%^&*()_-+=[{]}|\\;:\"\'<,>.?/~` ");

    							//ImageList에 이미지를 설정한다.
    							ImageList(0)= "/hanjin/img/btns_search_off.gif";
    						  	ImageList(1) = "/hanjin/img/btns_search.gif"; 
    						  	ImageList(2) = "/hanjin/img/btn_del.gif"; 
    						  	InitDataImage(0, prefix + "file_upload", daCenter);
    						  	InitDataImage(0, prefix + "file_delete", daCenter);
    						  	ShowButtonImage = 1;

    							Ellipsis  = true;
    							RowHidden(0) = true;
    						}
    						break;   						
    						
					case "hidden_sheets_file":
		                with (sheetObj) {
							var prefix = "hidden_sheets_file_";
		
							// 전체 너비 설정
							SheetWidth = mainTable.clientWidth;
							// 높이 설정
							style.height = 62;
		
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;
		
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
		
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 13, 100);
		
							var HeadTitle1 = "||";
		
							var headCount = ComCountHeadTitle(HeadTitle1);
		
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);
		
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);
		
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
		
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix + "ibflag");
		                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix + "lgs_cost_cd",		false,	"",	dfNone,		0,		false,	true);
							InitDataProperty(0, cnt++ , dtData,     	200,    daCenter,  	false,  prefix + "file_sav_id",   	false,  "", dfNone,      0,     true,   true);
		
							CountPosition = 0;
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
				
				if(validateForm(sheetObj,formObj,sAction)){
					if (sheetObj.id == "sheet1"){
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						
						var prefix = "sheet1_";
						ComClearFormSeparator(formObj);  //마스크  제거
						var sXml = sheetObj.GetSearchXml("EXP_SPP_0003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSearchXml(sXml);
						
						//다른 모든 트리는 Child까지 접기
						sheetObj.ShowTreeLevel(0,1);						
						
						//sheet1_OnSearchEnd 이벤트가 먼저 실행 된다.
						
						//Allowance TEU 값 셋팅
						var arrRslt = ComGetEtcData(sXml, ALLOWANCETEU).split(FIELDMARK);
						formObj.rev_yrmon.value = ((arrRslt[0]=="")?formObj.ntc_yrmon.value:arrRslt[0]);
						formObj.ttl_amt.value = ((arrRslt[1]=="")? "0.00":arrRslt[1]);
						formObj.cnl_tz_proc_sts_cd.value = arrRslt[5];
						if(formObj.vndr_cnt_cd.value != "PA") formObj.suz_net_tong_wgt.value = arrRslt[2];
						if(formObj.vndr_cnt_cd.value != "PA") formObj.locl_xch_rt.value = arrRslt[3];
						if(formObj.vndr_cnt_cd.value != "PA") formObj.tr_vol_val.value = arrRslt[4];
						if(formObj.vndr_cnt_cd.value == "PA") formObj.cntr_pnm_capa.value = arrRslt[6];
						if(formObj.vndr_cnt_cd.value != "PA") formObj.scg_rt_amt.value = arrRslt[7];
						ComSetFormSeparator(formObj);  //마스크 다시 셋팅						

						//level 1 인 row 의 rqst_amt, diff_rmk 셀 편집 불가능 처리, level 2 인 row 의  rqst_amt auto sun 행에서 제외
						sheetObj.CellEditable(2, prefix+"rqst_amt") = false;
						sheetObj.CellEditable(2, prefix+"diff_rmk") = false;
						//RIMITTANCE FM HANJIN 값에 대한 Balance 값 삭제
						sheetObj.CellText(2, prefix+"balance") = "";
						
						for(ix=2;ix<=sheetObj.RowCount+1;ix++){
							//auto 합계행에서 제외. 2 level rqst_amt
							
							if(sheetObj.CellValue(ix, prefix+"lgs_cost_cd_clss_lvl")=="A"){
								sheetObj.RowSumable(ix) = false;
								//Balance 값 삭제
								sheetObj.CellText(ix, prefix+"balance") = "";
								//Credit 값 삭제
								sheetObj.CellText(ix, prefix+"credits_amt") = "";								
							}
							//셀 편집 불가능 처리
							setCellEditable(sheetObj, ix, prefix+"rqst_amt");
							setCellEditable(sheetObj, ix, prefix+"diff_rmk");
							
							//File upload 이미지 처리
							if((formObj.cnl_tz_proc_sts_cd.value=="" || formObj.cnl_tz_proc_sts_cd.value=="R") && sheetObj.CellText(ix, prefix+"lgs_cost_cd") != "")
								sheetObj.CellImage(ix, prefix +"file_upload") = 1;
							else if(sheetObj.CellValue(ix, prefix+"lgs_cost_cd").length == "")
								sheetObj.CellImage(ix, prefix +"file_upload") = "";
							else
								sheetObj.CellImage(ix, prefix +"file_upload") = 0;
							//File Delete 이미지 처리
							if(formObj.cnl_tz_proc_sts_cd.value == "R" && sheetObj.CellText(ix, prefix+"file_sav_id") != ""){
								sheetObj.CellImage(ix, prefix +"file_delete") = 2;
							}

							if(sheetObj.CellValue(ix, prefix+"rqst_amt") == 0 && formObj.addRowFlag.value == "Y"){
								//sheetObj.CellText(ix, prefix+"rqst_amt") = "";
								sheetObj.CellText(ix, prefix+"balance") = "";
							}
						}
						//CREDITS 의 TOTAL 은 RIMITTANCE FM HANJIN 의 CREDITS 값 그대로.
						setCreditsTotal(sheetObj);

						//Request, Save, File Add, File Del 버튼의 활성화 비활성화 처리
						setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());
						CHANGEDVALUE = false;
						GlobalNtcYrmon = formObj.rev_yrmon.value;
						
						ComOpenWait(false);
					}
					else if (sheetObj.id == "sheet2"){
						formObj.f_cmd.value = SEARCH01;
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						
						ComClearFormSeparator(formObj);  //마스크  제거
						var sXml = sheetObj.GetSearchXml("EXP_SPP_0003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
						sheetObj.LoadSearchXml(sXml);
						
						ComOpenWait(false);
					}
				}
				break;
	              
			  case IBSAVE:		//Save  
				
				if(validateForm(sheetObj,formObj,sAction)){
                	//File Sheet 설정
                	setFileSave(sheetObj);
                	
  	    		  	//transaction 발생한 건이 없을 경우 return
  	    		  	//alert(sheetObj.IsDataModified +" : "+ CHANGEDVALUE +" : "+ sheetObjects[0].IsDataModified);
  					if (!sheetObj.IsDataModified && !CHANGEDVALUE && !sheetObjects[0].IsDataModified) {				
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
  					var sParamFile = sheetObjects[2].GetSaveString();
 					//alert(sParamFile);
  					
  					if (sParam1 == "" && !CHANGEDVALUE && sParamFile == "") {				
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}
 					
  	    		  	// 저장하시겠습니까?
  	    			if(!ComCodeMsgBySave()) return;
  	    			
  	    			ComOpenWait(true);
  	    			
  					sParam = sParam + "&" + sParam1+ "&" + sParamFile;  //Ready
  	    		  	
  	    		  	//저장. 저장 후 OnSaveEnd 이벤트 발생
  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0003GS.do", sParam);
  	    			//sheetObj.ShowDebugMsg = false;
  	    			sheetObj.LoadSaveXml(sXml);  //저장된 내용 sheet 에 반영 후 OnSaveEnd 이벤트 발생
  	    									 				//저장 후 새로 조회하지 않아도 됨.
  	    			//if(svRslt){
  	    			//	ComCodeMsgBySaveSuccess();
  	    			//}else{
  	    			//	ComCodeMsgBySaveFailed();
  	    			//}
  	    			ComOpenWait(false);
  	    			
  	    			//OnSaveEnd 후에 실행된다.
                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
                		CHANGEDVALUE = false;
                		GlobalNtcYrmon = formObj.rev_yrmon.value;
                		formObj.cnl_tz_proc_sts_cd.value = "R";
						//Request 및 Save 버튼의 활성화 비활성화 처리
						setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());	 
						
		    			//inv_sts, inv_rev_mon, diff_rmk 값을 opener 창에 return.
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
    		  	formObj.f_cmd.value = COMMAND01; 
    		  	formObj.cnl_tz_proc_sts_cd.value ='Q';

    		  	ComClearFormSeparator(formObj);  //마스크  제거
				var sParam = FormQueryStringOrg(formObj);
				ComSetFormSeparator(formObj);  //마스크 다시 셋팅
				
    		  	// Do you want to request contents finally?
    			if(!ComShowCodeConfirm('SPP01009')) return;
    		  	
    		  	//저장. 저장 후 OnSaveEnd 이벤트 발생
				//sheetObj.ShowDebugMsg = true;
    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0003GS.do", sParam);
    			
	    		//OnSaveEnd 후에 실행된다.
    			ComShowMessage(ComSaveXml2Message(sXml, "MESSAGE", 0));  //LoadSaveXml 을 하지 않았기 때문에 직접 메시지 띄움.
            	if(!ComSaveXml2IsTagExist(sXml, "ERROR")){  //ERROR 태그가 없으면
            		CHANGEDVALUE = false;
            		GlobalNtcYrmon = formObj.rev_yrmon.value;
            		formObj.cnl_tz_proc_sts_cd.value = "Q";
					//Request 및 Save 버튼의 활성화 비활성화 처리
					setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());	            		
    			
	    			//inv_sts, inv_rev_mon, diff_rmk 값을 opener 창에 return.
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
		    
		    //File Add 버튼 활성화/비활성화
		    if(procSts!="" && procSts!="R"){  //저장된 적이 없거나 Ready 상태가 아닌 경우에는 File Add 할 수 없음.
		    	btn_FileAdd.disabled = true; 
		    }else{
		    	btn_FileAdd.disabled = false; 
		    } 
		    //File Del 버튼 활성화/비활성화
		    if(procSts!="" && procSts!="R"){  //저장된 적이 없거나 Ready 상태가 아닌 경우에는 File Del 할 수 없음.
		    	btn_FileDelete.disabled = true;
		    }else{
		    	btn_FileDelete.disabled = false;
		    } 
		    
        }
        
        /*
         * Credits Total 값 재계산
         */
        function setCreditsTotal(sheetObj){
        	var prefix = "sheet1_";
			var tmpCredits = sheetObj.CellValue(2, prefix+"credits_amt");
			if(tmpCredits=="") tmpCredits=0;
			sheetObj.SumValue(0, prefix+"credits_amt") = tmpCredits;        	
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
             	 
	        	 case IBSAVE:  //SAVE
	        		if(formObj.vndr_cnt_cd.value != "PA" && formObj.addRowFlag.value != "Y"){
		        		if(formObj.suz_net_tong_wgt.value == ""){
		        			ComCodeMsgByMandatoryFieldMiss("SCNT");
		        			formObj.suz_net_tong_wgt.focus();
		         	 		return false;
		        		} 
		        		
		        		if(formObj.locl_xch_rt.value == ""){
		        			ComCodeMsgByMandatoryFieldMiss("SDR");
		        			formObj.locl_xch_rt.focus();
		         	 		return false;
		        		} 
		        		
		        		if(formObj.tr_vol_val.value == ""){
		        			ComCodeMsgByMandatoryFieldMiss("Tier");
		        			formObj.tr_vol_val.focus();
		         	 		return false;
		        		}
		        		
	        			if(formObj.scg_rt_amt.value == ""){
	        				ComCodeMsgByMandatoryFieldMiss("Limit Time");
	        				formObj.scg_rt_amt.focus();
	        				return false;
	        			}
	        			
	        			if(formObj.scg_rt_amt.value != "" && (formObj.scg_rt_amt.value > 99 || !Numberchk(formObj.scg_rt_amt.value))){
	        				ComCodeMsgByInvalidRangeData("Limit Time");
	        				return false;
	        			}
	        		}

	        	 	var cnowDvsn = false;
	        	 	for(var i = 2; i <= sheetObj.LastRow;i++){
	        	 		//cost가 Owner Account(CNOW)의 경우 파일 Attach 필수
	        	        if( sheetObj.CellText(i, prefix+"lgs_cost_cd").length > 4 && sheetObj.CellText(i, prefix+"lgs_cost_cd").substring(0,4) == "CNOW" && sheetObj.CellValue(i, prefix+"rqst_amt") != "0" &&sheetObj.CellText(i, prefix+"file_sav_id") == "" ) {
	        	        	cnowDvsn = true;
	        	 		}
	        	 	}
	        	 	if(cnowDvsn){
	        	 		ComShowCodeMessage("SPP00025");
        	 			return false;
	        	 	}
	        		break;
	        		 
	             default:
	            	break;
        	 }
        	 
        	 return true;
        }

         /**
         * 저장처리 전에 유효성 검사를 할수 있도록 발생하는 Event
         * @param sheetObj
    	 * @param Row
    	 * @param Col
    	 * @param Value
         */
        /*
        function sheet1_OnValidation(sheetObj, Row, Col, Value) {
        	with(sheetObj) {
    	    	if(CellValue(Row, "lgs_cost_cd") == "CNOW" && CellValue(Row, "file_sav_id") == "") {
    				ComShowCodeMessage("SPP00025");
    				ValidateFail = true;
    			}
        	}
        }
		*/
 		/**
         * sheet1 에 더블클릭 이벤트 발생
         */          
        function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
        	var prefix = "sheet1_";
        	var colId = sheetObj.ColSaveName(Col);
        	switch(colId){
        		case prefix+"rqst_amt":
        		case prefix+"diff_rmk":	
        			setCellEditable(sheetObj, Row, colId);
        			break;
        		default:
        			break;
        	}
        }
        
		/**
        * Cell Editable false 설정
        */        
        function setCellEditable(sheetObj, Row, colId){
        	var prefix = "sheet1_";
        	var cdLength = sheetObj.CellValue(Row, prefix+"lgs_cost_cd").length;
        	if(cdLength==4){
        		sheetObj.CellEditable(Row, colId) = false;
        	}        	
        }
        
        /*
         * sheet1 값 변경 시
         */
        function sheet1_OnChange(sheetObj, Row, Col, Value){
         	var prefix = "sheet1_";
         	var formObject = document.form;
        	var colId = sheetObj.ColSaveName(Col);
        	switch(colId){
        	    case prefix+"rqst_amt":
					//Balance 값 삭제
					sheetObj.CellText(Row, prefix+"balance") = "";        	    	
        	    	
        	    	var lgsCostCd = sheetObj.CellValue(Row, prefix+"lgs_cost_cd");
        	    	if(lgsCostCd.trim()=="") break;
					var tmpRow = sheetObj.findText(prefix+"lgs_cost_cd",lgsCostCd.substring(0,4));
					if(tmpRow==-1) break;
					var tmpNextRow = sheetObj.findText(prefix+"lgs_cost_cd_clss_lvl","D",tmpRow+1);
					
				
					if(tmpNextRow==-1) tmpNextRow = sheetObj.RowCount+2;
					if((tmpRow+1)>(tmpNextRow-1)) break;
					//부분합 다시 계산
					sheetObj.CellValue2(tmpRow, Col) = sheetObj.ComputeSum("|sheet1_rqst_amt|", tmpRow+1, tmpNextRow-1);
					//CREDITS 의 TOTAL 은 RIMITTANCE FM HANJIN 의 CREDITS 값 그대로.
					setCreditsTotal(sheetObj);					
					break;
        	}
        	formObject.ttl_amt.value = sheetObj.SumValue(0, "sheet1_rqst_amt");
        }

        /*
         * sheet1 검색 후 이벤트
         */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg){
			var prefix = "sheet1_";
			var formObject = document.form;
			var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
			with(sheetObj){
				
				var row = LastRow;
				SumText(0, "Seq") = "";
				SumText(0, prefix+"lgs_cost_full_nm") = "TTL Amount:";
				CellAlign(row, prefix+"lgs_cost_full_nm") = daRight;
				
				ColFontUnderline(prefix+"file_upld_nm") = true;
 				DataLinkMouse(prefix+"file_upld_nm") = true;
			}
		}
    		
         /*
         * sheet1 에 대한 조회 후 이벤트 처리
         */
		function sheet2_OnSearchEnd(sheetObj, ErrMsg){
			var prefix = "";
			var formObject = document.form;
			var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
			with(sheetObj){
				
				for(var i = 1; i <= sheetObj.LastRow;i++){
					if(procSts!="" && procSts!="R" ) 
						CellImage(i, prefix +"file_upload") = 0;
					else 
						CellImage(i, prefix +"file_upload") = 1;
					//CellValue2(i, prefix +"sq") = 1;
				}
				ColFontUnderline(prefix+"file_upld_nm") = true;
				DataLinkMouse(prefix+"file_upld_nm") = true;
		        
			  	
			  	
			}
		}
        /**
         * 파일 다운받기 <br>
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {ibsheet} row     	sheet 선택된 row
         * @param {ibsheet} col     	sheet 선택된 col
         * @param {String} 	value     	파일명
         **/
        function sheet1_OnClick(sheetObj,Row,Col,value){
        	var prefix = "sheet1_";
        	var formObject = document.form;
        	var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
	        switch (sheetObj.ColSaveName(Col)) {
	       	  	case prefix + "file_upld_nm" :
	       	  		if (sheetObj.ColSaveName(Col)!= prefix+"file_upld_nm" || 
	       	  				sheetObj.RowStatus(Row)=="I") {
			         		return;
			         	}
			         	if(sheetObj.CellText(Row, prefix+"file_upld_nm") == "") return;
			         	
			         	if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") {
			         		return;
			         	}
			         	
			         	var frm1 = document.formFile;
			         	//location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
			         	formFile.action = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
			         	formFile.submit();
			         	return;
			        break;
	       	  	case prefix +"file_upload":
	       	  				
	 					if ( fileUploadFlag || (procSts!="" && procSts!="R")) {
				    		return;
				    	}
	 					var upObj = uploadObjects[0];
				    	var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
					 	//var fileName = sheetObj.OpenFileDialog("", "", "", "Excel|*.xls|Excel|*.XLS|Text|*.txt|Text|*.TXT");
					 	var fileName = "";
					 	var fileType     = "";
						var badFile = false;
						if(filePath == "<USER_CANCEL>"){		
							return;
						}
						if ( filePath.indexOf("\\") == -1 ) {
							badFile = true;
						} else {
							fileName = filePath.substr(filePath.lastIndexOf("\\") + 1);         // File Name
							fileType     = fileName.substr(fileName.lastIndexOf(".") + 1);  // File Type
			      			fileType = fileType.toUpperCase();
			      			//XLS ,TXT, XLSX, CSV
			      			/*if( fileType != "XLS" && fileType != "TXT" && fileType != "XLSX" && fileType != "CSV"){
			      				badFile = true;
			      			}
			      			*/
						}
	
					 	if ( !badFile ) {
					 		ComOpenWait(true);
		  			 		fileUploadFlag = true;
					 		sheetObj.CellValue2(Row, prefix+"file_upld_nm")= fileName;			    //파일명 설정
					 	//	sheetObj.CellFontUnderline(Row, prefix+"file_upld_nm") = false;			//다운로드 링크 해제
					 	// 기존파일을 모두 지운후 추가함
					 		upObj.Files = "";
					 		var ret  = upObj.AddFile(filePath);
		  			 		var sXml = upObj.DoUpload(true);
		  					uploadFileName = ComGetEtcData(sXml,"filename");
		  					sheetObj.CellValue2(Row, prefix+"file_sav_id") = uploadFileName;
		  					sheetObj.CellImage(Row, prefix +"file_delete") = 2;
		  					fileUploadFlag = false;
		  					ComOpenWait(false);
					 	} else {
					 		if ( filePath != "<USER_CANCEL>" ) {
					 			ComShowCodeMessage("SPP01026");
					 		}
						}
					 	break;
	       	  	case prefix +"file_delete":
   	  				
 					if ( procSts!="" && procSts!="R") {
			    		return;
			    	}
 					if(sheetObj.CellText(Row, prefix+"file_upld_nm") == "" || sheetObj.CellText(Row, prefix+"file_sav_id") == ""){
 						return;
 					}
 					sheetObj.CellValue2(Row, prefix+"file_sav_id") = "";
 					sheetObj.CellValue2(Row, prefix+"file_upld_nm") = "";
 					sheetObj.CellImage(Row, prefix +"file_delete") = "";
				 	break;
	        	 }
        }

     	/**
          * 파일 선택하기 <br>
          * @param {ibsheet} sheetObj    IBSheet Object
          * @param {ibsheet} Row     	sheetObj의 선택된 Row
          * @param {ibsheet} Col     	sheetObj의 선택된 Col
          **/
/*     	function sheet2_OnPopupClick(sheetObj,Row,Col){
     	    
       	   var prefix = "";
     	}
     	*/
     	/**
          * 파일 다운받기 <br>
          * @param {ibsheet} sheetObj    IBSheet Object
          * @param {ibsheet} Row     	sheetObj의 선택된 Row
          * @param {ibsheet} Col     	sheetObj의 선택된 Col
          * @param {String} 	Value     	파일명
          **/
     	function sheet2_OnClick(sheetObj,Row,Col,Value){
     		 var prefix = "";
     		 var formObject = document.form;
     		 var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
     		 switch (sheetObj.ColSaveName(Col)) {
	     	  	case prefix + "file_upld_nm" :
	
		      		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") break;
		      		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") break;
		         	
		         	var frm1 = document.formFile;
		         	//location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		         	frm1.action = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		         	frm1.submit();
		      		return;
		      	break;
       	  	case prefix +"file_upload":
       	  		
   				if ( fileUploadFlag || (procSts!="" && procSts!="R")) {
   		    		return;
   		    	}
   				var upObj = uploadObjects[0];
   		    	var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
   			 	//var fileName = sheetObj.OpenFileDialog("", "", "", "Excel|*.xls|Excel|*.XLS|Text|*.txt|Text|*.TXT");
   			 	var fileName = "";
   			 	var fileType     = "";
   				var badFile = false;
   				if(filePath == "<USER_CANCEL>"){		
						return;
					}
   				if ( filePath.indexOf("\\") == -1 ) {
   					badFile = true;
   				} else {
   					fileName = filePath.substr(filePath.lastIndexOf("\\") + 1);         // File Name
   					fileType = fileName.substr(fileName.lastIndexOf(".") + 1);  // File Type
   	      			fileType = fileType.toUpperCase();
   	      			//XLS ,TXT, XLSX, CSV
   	      			/*if( fileType != "XLS" && fileType != "TXT" && fileType != "XLSX" && fileType != "CSV"){
   	      				badFile = true;
   	      			}
   	      			*/
   				}

   			 	if ( !badFile ) {
   			 		ComOpenWait(true);
     			 		fileUploadFlag = true;
   			 		sheetObj.CellValue2(Row, prefix+"file_upld_nm")= fileName;			    //파일명 설정
   			 	//	sheetObj.CellFontUnderline(Row, prefix+"file_upld_nm") = false;			//다운로드 링크 해제
   			 	// 기존파일을 모두 지운후 추가함
   			 		upObj.Files = "";
   			 		var ret  = upObj.AddFile(filePath);
     			 		var sXml = upObj.DoUpload(true);
     					uploadFileName = ComGetEtcData(sXml,"filename");
     					//alert(uploadFileName);
     					sheetObj.CellValue2(Row, prefix+"file_sav_id") = uploadFileName;
     					fileUploadFlag = false;
     					ComOpenWait(false);
   			 	} else {
   			 		if ( filePath != "<USER_CANCEL>" ) {
   			 			ComShowCodeMessage("SPP01026");
   			 		}
   				}
       	  		
			 	break;
        	 }

     	}

        	/**
           * 저장 파일 셋팅 <br>
           * @param {ibsheet} sheetObj    IBSheet Object
           **/
          function setFileSave(sheetObj){
     		var prefix1 = "sheet1_";
     		var prefix2 = "";
     		var prefix3 = "hidden_sheets_file_";
     		//alert("setFileSave Start");
           sheetObjects[2].RemoveAll();
           var insertRowNo = 0;
           for(var i = 2; i <= sheetObj.LastRow;i++){
	        	 if (sheetObj.CellValue(i,prefix1+"file_sav_id") != ""){
	        		 sheetObjects[2].DataInsert(sheetObjects[2].Rows-1);
	     	    	 insertRowNo = sheetObjects[2].Rows-1;  //맨 마지막 이전 줄로 삽입됨.
	     	    	 //alert(insertRowNo);
	        		 sheetObjects[2].CellValue2(insertRowNo, prefix3+"file_sav_id") = sheetObj.CellValue(i,prefix1+"file_sav_id");
	        		 sheetObjects[2].CellValue2(insertRowNo, prefix3+"lgs_cost_cd") = sheetObj.CellValue(i,prefix1+"lgs_cost_cd");
	        	 }
	         }
	         for(var i = 1; i <= sheetObjects[0].LastRow;i++){
	        	 if (sheetObjects[0].CellValue(i,prefix2+"file_sav_id") != "" && sheetObjects[0].CellValue(i,prefix2+"del_chk") !="1" ){
	        		 //alert(sheetObjects[0].CellValue(i,prefix2+"file_sav_id"));
	        		 sheetObjects[2].DataInsert(sheetObjects[2].Rows-1);
	     	    	 insertRowNo = sheetObjects[2].Rows-1;  //맨 마지막 이전 줄로 삽입됨.
	        		 sheetObjects[2].CellValue2(insertRowNo, prefix3+"file_sav_id") = sheetObjects[0].CellValue(i,prefix2+"file_sav_id");
	        		 sheetObjects[2].CellValue2(insertRowNo, prefix3+"lgs_cost_cd") = "";
	        	 }
	         }
	         
	      		//alert("setFileSave End");
	         
     	}

	/* 개발자 작업  끝 */