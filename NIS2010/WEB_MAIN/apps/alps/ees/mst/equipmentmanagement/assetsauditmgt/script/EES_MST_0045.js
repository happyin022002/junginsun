/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0045.js
*@FileTitle : Container Average Using  Days
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.17 이호선
* 1.0 Creation
* ========================================================
* 2010.10.25 남궁진호 [CHM-201006645-01] 조회조건 Lease Term ComoList에  "ST" Term 추가 
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
     * @class ees_mst_0045 : ees_mst_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0045() {
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
 var head_cntr_tpsz_cd ="";
 var head_pur_list = "";
 var tot_cntr_tpsz_cd ="";
 var comboObjects = new Array();
 var comboCnt = 0 ; 
 
 var IBSEARCH01  = 29;

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
 				case "btn_retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 				break;
 				
 				case "btn_new":
 					sheetObject1.removeAll();
 					formObject.eq_knd_cd[0].checked = true;
 					formObject.report_type[0].checked = true;
 					formObject.lstm_cd.Text = "";
 					formObject.cntr_tpsz_cd.Text = "";
 					formObject.vndr_abbr_nm.Text = "";
 					formObject.man_year.Text = "";
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
 				break;

 				case "btn_downexcel":
 					//sheetObject1.Down2Excel();
 					sheetObject1.SpeedDown2Excel();
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
    	 var formObject = document.form; 
         for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
 			//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         axon_event.addListenerFormat('blur', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	     axon_event.addListenerFormat('focus','obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 	     axon_event.addListener('click', 'eq_knd_cd_click', 'eq_knd_cd'); 	     
     }
      
     /**
      * IBCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }
      
     /**
      * MultiCombo object initial property //LHS
      * @param comboObj
      * @param comboNo
      * @return
      */
     function initCombo (comboObj, comboNo) {
    	 switch(comboObj.id) {
    	 
	 		case "lstm_cd":
				with(comboObj) {
					//BackColor = "cyan";
					DropHeight = 150;
					MultiSelect = true;
					UseAutoComplete = true;
					MultiSeparator = ",";
					Style = 0;
					ValidChar(2,2);
				}
			break;    	 
    	 
    		case "cntr_tpsz_cd":
    			with(comboObj) {
    				//BackColor = "cyan";
    				DropHeight = 150;
    				MultiSelect = true;
    				UseAutoComplete = true;
    				MultiSeparator = ",";
    				Style = 0;
    				ValidChar(2,3);
    			}
    		break;
    		
   	       case "vndr_abbr_nm":
   	        	with(comboObj) {
 			   	    SetTitle("Code|Name");  
			        SetColAlign("center|left");        
			        SetColWidth("60|150"); 	        
				    DropHeight = 160;
    				UseAutoComplete = true;
    				MultiSeparator = ",";   	        		
    				Style = 0;				    
   	            	MultiSelect = true;
   	            	ValidChar(2,1);
   	            }
   	       break;
   	       
   		   case "man_year":
			   with(comboObj) {
				   //BackColor = "cyan";
				   DropHeight = 150;
				   MultiSelect = true;
				   UseAutoComplete = true;
				   MultiSeparator = ",";
				   Style = 0;
				   ValidChar(2,1);
			   }
		   break;   	       
    	 }      	
     }

	 //Axon 이벤트 처리2. 이벤트처리함수
	 function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	 }
	
	 function obj_activate(){
	    ComClearSeparator(event.srcElement);
	 }
	 
     function eq_knd_cd_click(){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
     }
     
 	 function obj_keypress(){
	    
	     obj = event.srcElement;
	     if(obj.dataformat == null) return;
	     window.defaultStatus = obj.dataformat;
	    
	     switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="loc_cd") ComKeyOnlyAlphabet('upper');  //ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "ym":
	            if(obj.name=="bse_yrmon0") ComKeyOnlyNumber(this, "-");
	            if(obj.name=="bse_yrmon1") ComKeyOnlyNumber(this, "-");
	            break;
	     }
	 }
 	
     function sheet1_OnLoadFinish(sheetObj) {
   	     var formObject = document.form;     	
         for(var p=0;p< comboObjects.length;p++){
 	       initCombo (comboObjects[p],p+1);
 	     }
 	     
	     var today = new Date();
	     formObject.yrstr.value = String(today.getYear());
	     
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기 	     
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); //Manufacturer
         
         with (form.lstm_cd) {
	       	 MultiSelect = true;
	         MultiSeparator = ",";
	       	 DropHeight = 270;
	       	 InsertItem(0 , 'ALL','ALL');
	       	 InsertItem(1 , 'OW','OW');
	       	 InsertItem(2 , 'LP','LP');
	       	 InsertItem(3 , 'OL','OL');
	       	 InsertItem(4 , 'LT','LT');
	       	 InsertItem(5 , 'ST','ST');
         }    	
     } 	
 	
     /**
      * TP/SZ 체크박스 체크 이벤트 처리
      * TP/SZ 체크박스 체크시 전체체크,전체해재 기능
      */
     function check_cntr_tpsz_cd_check() {
         var formObject = document.form;
         if ( formObject.chk_cntr_tpsz_cd.checked ) {
    	     comboObjects[0].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
         } else {
    	     comboObjects[0].Code = "";
         }
     }
    
     /**
      * TP/SZ 변경시 이벤트 처리 
      * 전체리스트에서 하나라도 체크 해제 되어 있으면 전체체크박스 해제, 전체가 체크되어 있어야 전체체크박스선택
      */   
     function cntr_tpsz_cd_change(comboObj,value,text) {
         var real_cntr_tpsz_cd = tot_cntr_tpsz_cd.replaceStr("|", ",").split(",")
         var cntr_tpsz_cd  = comboObjects[0].Code.split(",");
         if ( real_cntr_tpsz_cd.length !=cntr_tpsz_cd.length) {
             document.form.chk_cntr_tpsz_cd.checked = false;
         } else {
             document.form.chk_cntr_tpsz_cd.checked = true;
         }
       
   	     if(  0 <= value.indexOf("ALL") ){
		     var strLstmCd =  value.split(",");        	
			 document.form.chk_cntr_tpsz_cd.value = ""; 		    
		 }else{
			 var strTpszCd =  value.replaceStr("|", ",").split(",");
			 document.form.chk_cntr_tpsz_cd.value = strTpszCd;
			 var sTpSz = document.form.chk_cntr_tpsz_cd.value;                         
	     } 	       
     }
    
     /**
     * Multicombo 각각의 Event 처리  //LHS START
     */
     function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
         if(index==0) { 	    	
             var bChk = comboObj.CheckIndex(index);
             if(bChk){
                 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                     comboObj.CheckIndex(i) = false;
                 }
             }
         } else {
             comboObj.CheckIndex(0) = false;
         }
     } 
    
     function vndr_abbr_nm_OnCheckClick(comboObj, index, code) {
         if(index==0) {
             var bChk = comboObj.CheckIndex(index);
             if(bChk){
                 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                     comboObj.CheckIndex(i) = false;
                 }
             }
         } else {
             comboObj.CheckIndex(0) = false;
         }
     }
    
	function man_year_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}
    
    function lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) {
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }    

    /**
	 * cntr_tpsz_cd_OnBlur
	 */
	function cntr_tpsz_cd_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cntr_tpsz_cd_h.value = ComGetObjValue(comboObj);
	}

   /**
	 * vndr_abbr_nm_OnBlur
	 */
	function vndr_abbr_nm_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.vndr_abbr_nm_h.value = ComGetObjValue(comboObj);
	}

	/**
	 * man_year_OnBlur
	 */
	function man_year_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.man_year_h.value = ComGetObjValue(comboObj);
	}    
    
	/**
	 * lstm_cd_OnBlur
	 */
	function lstm_cd_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.lstm_cd_h.value = ComGetObjValue(comboObj);
	}
	 
	/**
	 * combo1_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function cntr_tpsz_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd_h.value = ComGetObjValue(comboObj);
			}
		}
	}
	 
	function vndr_abbr_nm_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.vndr_abbr_nm_h.value = ComGetObjValue(comboObj);
			}
		}
	}
	
	function man_year_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.man_year_h.value = ComGetObjValue(comboObj);
			}
		}
	}	
	
	function lstm_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.lstm_cd_h.value = ComGetObjValue(comboObj);
			}
		}
	}	
    //LHS END
	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 402;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;
                    //MergeSheet = msAll;
 				    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 2, 20, 100);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //A5 코드 추가
                    InitHeadMode(false, false, false, true, false,false);
                    if (headTitle==null || headTitle =="") {
                  	  headTitle = "Lease Term|Manufacture Year|Manufacturer|DIV|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
                    }

                    var headCnt  = headTitle.split("|").length;

                    SheetWidth = (headCnt)*40+55;
                    if ( SheetWidth>975 ) {
                  	  SheetWidth = 975;
                    }
                    InitColumnInfo(headCnt, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle, true);
                    sheetObj.FrozenCols = 5;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,      75,     daCenterTop,	true,	"lstm_cd",	false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,      110,    daCenterTop,	true,	"man_year",		false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,      120,    daCenterTop,	true,	"man_nm",			false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   	  60,     daCenter,		true,	"div",			false,  "",      dfNone,			0,     true,       true);
                     var calcstr = "";
                     for(var i=1 ; i <= headCnt - 5 ; i++){
                    	 if (i < headCnt - 5){
                    	    calcstr = calcstr + "|qty"+i+"|+";
                    	 } else {
                    		calcstr = calcstr + "|qty"+i+"|"; 
                    	 }
                     }
                     InitDataProperty(0, cnt++ , dtAutoSum,   100, 	  daRight,		true,	"qty0",	false,  "",     dfNullInteger,		2,     true,       true);
                     for(var i=1 ; i <= headCnt - 5 ; i++){
                  	   InitDataProperty(0, cnt++ , dtAutoSum,  80,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		2,     true,       true);
                     }
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     cnt = 0;            
                     InitDataProperty(1, cnt++ , dtData,      75,     daCenterTop,	true,	"lstm_cd",	false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(1, cnt++ , dtData,      110,    daCenterTop,	true,	"man_year",		false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(1, cnt++ , dtData,      120,    daCenterTop,	true,	"man_nm",			false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(1, cnt++ , dtData,   	  60,     daCenter,		true,	"div",			false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(1, cnt++ , dtData,   100, 	  daRight,		true,	"qty0",	false,  "",      dfNullInteger,		2,     true,       true);
                     for(var i=1 ; i <= headCnt - 5 ; i++){
                  	   InitDataProperty(1, cnt++ , dtData,  80,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		2,     true,       true);
                     }
                     
                     /*cnt = 0;            
                     InitDataProperty(2, cnt++ , dtData,      75,     daCenterTop,	true,	"lstm_cd",	false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(2, cnt++ , dtData,      110,    daCenterTop,	true,	"man_year",		false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(2, cnt++ , dtData,      120,    daCenterTop,	true,	"man_nm",			false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(2, cnt++ , dtData,   	  60,     daCenter,		true,	"div",			false,  "",      dfNone,			0,     true,       true);
                     InitDataProperty(2, cnt++ , dtAutoSum,   100, 	  daRight,		true,	"qty0",	false,  "",      dfNullInteger,		2,     true,       true);
                     for(var i=1 ; i <= headCnt - 5 ; i++){
                  	   InitDataProperty(2, cnt++ , dtAutoSum,  80,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		2,     true,       true);
                     }                     
                     */            
                     CountPosition = 0;
                }
             break;
         }
     }
      
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction))
					if(sheetObj.id == "sheet1") {
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);						
						form.f_cmd.value = SEARCH;
			            var sXml = sheetObj.GetSearchXml("EES_MST_0045GS.do", FormQueryString(formObj));
			            sheetObj.LoadSearchXml(sXml);
			            ComOpenWait(false);			            
					}
			break;
			
			case IBSEARCH01:
				 form.cntr_tpsz_cd.RemoveAll();
	             form.f_cmd.value = SEARCH02;
	             var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do" , FormQueryString(formObj));
				 var chk = sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchXml(sXml);
					 return;
				 }	             
	             
	             //TP/SZ 조회
	             var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");
	             head_cntr_tpsz_cd = cntr_tpsz_cd;
	             tot_cntr_tpsz_cd = cntr_tpsz_cd;
	             formObj.head_cntr_tpsz_cd.value = head_cntr_tpsz_cd; 
	             var strCntrTpszCd  = cntr_tpsz_cd.split("|");
	             
	             var HeadTitle = "Lease Term|Manufacture Year|Manufacturer|DIV|Total|"+head_cntr_tpsz_cd;
	             
	             sheetObj.Redraw = false;
	             sheetObj.RemoveAll();
	             sheetObj.Reset();
	             initSheet(sheetObj,1,HeadTitle);
	             sheetObj.Redraw = true;  	             
	             
		         with (form.cntr_tpsz_cd) {
		        	 MultiSelect = true;
		             MultiSeparator = ",";
		        	 DropHeight = 270;
		        	 InsertItem(0 , 'ALL','ALL'); 
		        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
	  		        	 InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
		        	 }
		        	 formObj.qtycnt.value = cntr_tpsz_cd.split("|").length;
		         }
		         
		         with (form.man_year) {
		        	 MultiSelect = true;
		             MultiSeparator = ",";
		        	 DropHeight = 270;
		        	 InsertItem(0 , 'ALL','ALL'); 
		        	 InsertItem(1 , formObj.yrstr.value.parseInt(),formObj.yrstr.value.parseInt());
		        	 var j=2;
		        	 for ( var i=formObj.yrstr.value.parseInt()-1; i >= 1980; i--) {
		        		 InsertItem(j, i.toString(), i.toString());
		        		 j++;		        		 
		        	 }
		         }
			break;
			
            case IBSEARCH_ASYNC01://Sheet Combo 데이타 담아오기
	   	 	   formObj.f_cmd.value = SEARCH01;
	   	  	   var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&vndr_seq=");
				 var chk = xml.indexOf("ERROR");
				 if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
					 sheetObj.LoadSearchXml(xml);
					 return;
				 } else {	   	  	   
					 ComXml2ComboItemForLHS(xml, formObj.vndr_abbr_nm, "code", "code|code_nm", 0);
				 }
            break;			
         }
     }
   
     /**
     * Calendar Display
     */
     function popCalendar(type,gubun){
    	 var formObj = document.form;    	 
         var cal = new ComCalendar();
         cal.setDisplayType('month');
         if (gubun == '0'){
            cal.select(formObj.bse_yrmon0, "yyyy-MM");
         } else if (gubun == '1'){
        	 cal.select(formObj.bse_yrmon1, "yyyy-MM"); 
         }
     }   
   
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
         
    /**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
 	function sheet1_OnSearchEnd(sheetObj, msg){
    	 
    	var SumString1 = sheetObj.GetRangeText(sheetObj.LastRow-3,4,sheetObj.LastRow-1,sheetObj.LastCol,"|","^").replace(/\,/gi,"");
		var SumStr = SumString1.split("^");
		var SumSrtValue1 = SumStr[0].split("|");
		var SumSrtValue2 = SumStr[1].split("|");

		sheetObj.RowDelete(sheetObj.LastRow-2, false);
		sheetObj.RowDelete(sheetObj.LastRow-2, false);		
		
		sheetObj.CellValue(sheetObj.LastRow-1, 3) = "Volume";
		sheetObj.CellValue(sheetObj.LastRow,   3) = "Average";
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 0, 2, 3);
		sheetObj.CellValue(sheetObj.LastRow-1, 0) = "Total";

		for(var i=0 in SumSrtValue2){
			sheetObj.SumValue(0, parseInt(i)+4) = SumSrtValue1[i];
			sheetObj.SumText(1, parseInt(i)+4) = ComGetMaskedValue(SumSrtValue2[i], "int") +"("+ComRound(SumSrtValue2[i] / 365, 1)+")";
			sheetObj.CellAlign(sheetObj.LastRow, parseInt(i)+4) = daRight;
		}
 	}         
         
	/* 개발자 작업  끝 */