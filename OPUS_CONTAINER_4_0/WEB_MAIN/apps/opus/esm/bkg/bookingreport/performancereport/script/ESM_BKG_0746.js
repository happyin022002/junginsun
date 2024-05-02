/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0746.js
*@FileTitle  : Vessel Utilization Status vs. BSA by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
 // 공통전역변수
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var combo1=null;
 var comboCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj; 		
     }
     
     function setComboObject(combo_obj){
     	 comboObjects[comboCnt++]=combo_obj;
     } 
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {    	 
    	 
         for(var i=0;i<sheetObjects.length;i++){
         	ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i], i + 1);
    		ComEndConfigSheet(sheetObjects[i]);
    		//sheetObjects[i].SetWaitImageVisible(0);
         }
         
         //MultiCombo초기화 
	 	 for(var k=0;k<comboObjects.length;k++){
	 		 initCombo(comboObjects[k],comboObjects[k].options.id);
	 	 }
	 	 
	 	 initControl();
	 	 doActionIBSheet(sheetObjects[0],document.form,INIT);
	 	 document.form.etd_from_dt.value=getCalculatedDate(0,-1,0,"-");
		 document.form.etd_to_dt.value=getCalculatedDate(0,0,0,"-"); 
//		 document.form.slan_cd.value 	 = "KJS";
     }
      /**
       * 콤보 초기설정값
       * @param {IBMultiCombo} comboObj  comboObj
       */
       function initCombo(comboObj, comboId) {
     	  comboObj.SetMultiSelect(0);
     //no support[check again]CLT 	  
     	  comboObj.UseCode=false;
     	  comboObj.SetUseEdit(0);
     	  //comboObj.LineColor = "#ffffff";
     	  //comboObj.SetColAlign("left|left");
     	  comboObj.SetMultiSeparator(",");
     	  comboObj.SetDropHeight(150);
     	  //UseAutoComplete = true; // 편집시 자동 코드 검색
       }    
       /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
	     var formObject=document.form;
	     var srcName=ComGetEvent("name");
	     var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	     var srcValue=window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
          /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject=document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
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
      var headCount=0
      var headCount2=0
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
 				switch(sheetID) {
 					case "sheet1":
 						with(sheetObj){	 				        
	 				        var HeadTitle1="Lane|VVD|BSA|BSA|Utilization|Utilization|Lifting Total|Lifting Total";
	 				        var HeadTitle2="Lane|VVD|E|W|E|W|E|W";
	 				        for (var i=0 ; i < 40 ; i++){
	 				        	HeadTitle1 += "|DIS|Load|ROB";
	 				        	HeadTitle2 += "|DIS|Load|ROB";
	 				        } 
	 				        headCount=ComCountHeadTitle(HeadTitle1);
	
	 				        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	 				        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	 				        var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	 				        InitHeaders(headers, info);
	 				       
	 				        
	 				        var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Lane",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"VVD",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"BSA_E",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"BSA_W",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"Util_E",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"Util_W",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"Lift_E",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"Lift_W",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
	 				        
			            for (var i = 0 ; i < 40 ; i++){
			            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"DIS"+i,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
			            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"Load"+i,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
			            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ROB"+i,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
			            } 
			            for (var i = 0 ; i < 120 ; i++){
			            	/*SetMergeCell(0, 8+i, 2, 1);*/
			            }
 				            InitColumns(cols);
 				            
 				            SetEditable(1);
 				            SetCountPosition(0);
 				            SetSheetHeight(390);
 						}
 						break;
 					case "sheet2":
 					    with(sheetObj){ 							
 							var HeadTitle1="vps_lane_cd|vvd|BSA_east|BSA_west|LIFTING_ttl_e|LIFTING_ttl_w|ttl_local_e|ttl_local_w|ttl_ts_e|ttl_ts_w|ttl_ipc_e|ttl_ipc_w|ttl_tps_e|ttl_tps_w|ttl_eur_e|ttl_eur_w|ttl_mty_e|ttl_mty_w";
 							for (var i=0+1 ; i < 40+1 ; i++){
 								HeadTitle1 += "|port"+ i +"|total_loading"+ i +"|total_discharging"+ i +"|eta"+ i +"|etd"+ i;
 								HeadTitle1 += "|l_local"+ i +"|d_local"+ i +"|l_ts"+ i +"|d_ts"+ i +"|l_ipc"+ i +"|d_ipc"+ i +"|l_tps"+ i +"|d_tps"+ i +"|l_eur"+ i +"|d_eur"+ i +"|l_mty"+ i +"|d_mty"+ i +"|last_port_loading"+ i +"|util"+ i+"|util_indi"+i;
 							}
 							headCount2=ComCountHeadTitle(HeadTitle1);

 							SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

 							var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
 							var headers = [ { Text:HeadTitle1, Align:"Center"}]; 							
 							InitHeaders(headers, info);

 							var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vps_lane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"BSA_east",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"BSA_west",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"LIFTING_ttl_e",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"LIFTING_ttl_w",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_local_e",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_local_w",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_ts_e",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_ts_w",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_ipc_e",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_ipc_w",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_tps_e",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_tps_w",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_eur_e",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_eur_w",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_mty_e",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 },
	 				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_mty_w",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 } ];
 				            for (var i = 0+1 ; i < 40 +1; i++){
 				            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"port"+i,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
 				            	cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"total_loading"+i,     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 });
 				            	cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"total_discharging"+i, KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0 });
 				            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"eta"+i,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
 				            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"etd"+i,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
 				            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"l_local"+i,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
 				            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"d_local"+i,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
 				            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"l_ts"+i,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"d_ts"+i,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"l_ipc"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"d_ipc"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"l_tps"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"d_tps"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"l_eur"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"d_eur"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"l_mty"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"d_mty"+i,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"last_port_loading"+i, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0 });
		 				       	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"util"+i,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 });
		 				       	cols.push({Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"util_indi"+i,         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 });
 				            }
 				 
 				            InitColumns(cols);
	
 				            SetEditable(0);
 				            SetCountPosition(0);
 				            SetSheetHeight(390);
 						}
 						break;
				}//end switch
 	}
   // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
      function processButtonClick(){
           /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
           var sheetObject1=sheetObjects[0];
           /*******************************************************/
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_Retrieve":  					
  					doActionIBSheet(sheetObject1,formObject,SEARCH);
  					break;
  				case "btn_New":
  					ComResetAll();
  					break;
  				case "btn_DownExcel":
  					//sheetObject1.SpeedDown2Excel(-1);
  					if(sheetObject1.RowCount() < 1){//no data
  		        		ComShowCodeMessage("COM132501");
  		        	}else{
  		        		sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
  		        	}
  					
  					break;
  				case "btn_Rawdata":
  					sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
  					//sheetObjects[1].Down2Excel(-1);
  					break;
  				case "btn_Print":
  					//goPrint();
  					sheetObject1.Down2Excel({ HiddenColumn:1 });
  					break;	
  				case "btn_calendar":
 					var cal=new ComCalendarFromTo();
 	                cal.select(formObject.etd_from_dt, formObject.etd_to_dt, 'yyyy-MM-dd');
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
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
           case INIT:      //TRADE CODE SEARCH	          
           		formObj.f_cmd.value=INIT;   
//parameter changed[check again]CLT            		
           		var searchXml=sheetObj.GetSearchData("ESM_BKG_0746GS.do", FormQueryString(formObj));
           		//Trade code
				ComBkgXml2ComboItem(searchXml, trd_cd, "trd_cd", "trd_cd");
				comboObjects[0].InsertItem(0, "All", "");
				comboObjects[0].SetSelectIndex(0, false);
				comboObjects[1].InsertItem(0, "All", "");
				comboObjects[1].SetSelectIndex(0, false);
				comboObjects[2].InsertItem(0, "All", "");
				comboObjects[2].SetSelectIndex(0, false);
				
           break;
           case COMMAND01:     //SUB TRADE CODE SEARCH
           		formObj.f_cmd.value=SEARCH01;   
//parameter changed[check again]CLT            		
           		var searchXml=sheetObj.GetSearchData("ESM_BKG_0746GS.do", FormQueryString(formObj));
           		comboObjects[1].RemoveAll();
           		comboObjects[2].RemoveAll();
           		//Trade code
				ComBkgXml2ComboItem(searchXml, sub_trd_cd, "sub_trd_cd", "sub_trd_cd");							
				comboObjects[1].InsertItem(0, "All", "");
				comboObjects[1].SetSelectIndex(0, false);
				comboObjects[2].InsertItem(0, "All", "");
				comboObjects[2].SetSelectIndex(0, false);
           break;
           case COMMAND02:     //SUB TRADE CODE SEARCH
	      		formObj.f_cmd.value=SEARCH02;   
//parameter changed[check again]CLT 	      		
	      		var searchXml=sheetObj.GetSearchData("ESM_BKG_0746GS.do", FormQueryString(formObj));
	      		comboObjects[2].RemoveAll();
	      		//Trade code
				ComBkgXml2ComboItem(searchXml, vsl_slan_dir_cd, "vsl_slan_dir_cd", "vsl_slan_dir_cd");							
				comboObjects[2].InsertItem(0, "All", "");
				comboObjects[2].SetSelectIndex(0, false);
		   break;
           case SEARCH:     //Main Search >>> BSA by Lane
           		if(!validateForm(sheetObj,formObj,sAction)) return;
	     		sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);  
 				
 				setTimeout( function () { //@ setTimeout ########################################################### 				
	           		formObj.f_cmd.value=SEARCH;   				
	  //         	sheetObj.DoSearch("ESM_BKG_0746GS.do", FormQueryString(formObj));
	//parameter changed[check again]CLT 				
	           		var sXml=sheetObj.GetSearchData("ESM_BKG_0746GS.do", FormQueryString(formObj));
					var arrSXml=sXml.split("|$$|");	  
						
					sheetObjects[0].LoadSearchData(arrSXml[0],{Sync:1} );
					sheetObjects[1].LoadSearchData(arrSXml[1],{Sync:1} );
					sheetObjects[0].RenderSheet(0);
	           		if (sheetObjects[0].SearchRows()> 0){
	           			var maxSize=8 + eval(ComGetEtcData(arrSXml[0], "max_port_seq"))*3;
	           			if(maxSize + 2 < headCount) maxSize  += 2;
	           			for (var i=8 ; i < headCount ; i++){
	           				if( maxSize > i)
	           					sheetObjects[0].SetColHidden(i,0);
	           				else
	           					sheetObjects[0].SetColHidden(i,1);
	           			}
	           		}
					sheetObjects[0].RenderSheet(1);
					sheetObjects[1].RenderSheet(0);
	           		if (sheetObjects[1].SearchRows()> 0){
	           			var maxSize=18 + eval(ComGetEtcData(arrSXml[0], "max_port_seq"))*20;
	           			//if(maxSize + 2 < headCount2) maxSize  += 2;
	           			for (var i=18 ; i < headCount2 ; i++){
	           				if( maxSize > i)
	           					sheetObjects[1].SetColHidden(i,0);
	           				else
	           					sheetObjects[1].SetColHidden(i,1);
	           			}
	          		}	
					sheetObjects[1].RenderSheet(1);
	
					ComOpenWait(false);
 				} , 100);//@ setTimeout end ###########################################################					
           break;		
         }
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (formObj.dt_tp[0].checked == true){
    		 if (formObj.etd_from_dt.value == '' || formObj.etd_to_dt.value == ''){
    			 ComShowCodeMessage("BKG00499");//Period are mandatory items.
    			 formObj.etd_from_dt.focus();
    			 return false;
    		 }
    		 if (ComGetDaysBetween(formObj.etd_from_dt.value, formObj.etd_to_dt.value) > 180){
    			 //ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
    			 ComShowCodeMessage('COM132001','Port ETD','180Days')
    			 formObj.etd_from_dt.focus();
    			 return false;
    		 }
    	 }else{
    		 if (formObj.cost_year.value == '' || formObj.cost_morth.value == ''){
    			 ComShowCodeMessage("BKG00499");//Period are mandatory items.
    			 formObj.cost_year.focus();
    			 return false;
    		 }else{
    			 formObj.cost_yrmon.value=formObj.cost_year.value + formObj.cost_morth.value;
    		 }
    	 }
    	 if (trd_cd.GetSelectCode() == '' && formObj.slan_cd.value == ''){
    		 ComShowCodeMessage("COM130201", "Trade or Lane");//Please input Trade or Lane.
			 formObj.slan_cd.focus();
			 return false;
    	 }
         return true;
     }
     /**
	  * Trade Combo Change Event
      */
	 function trd_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode){
		 var formObj=document.form;
		 if (NewText == 'All'){
			 comboObjects[1].RemoveAll();
			 comboObjects[2].RemoveAll();
			 comboObjects[1].InsertItem(0, "All", "");
			 comboObjects[2].InsertItem(0, "All", "");
			 comboObjects[1].index2=0;
			 comboObjects[2].index2=0;
		 }else{
			 doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
		 }
	 }
	  /**
	  * Sub Trade Combo Change Event
      */
	 function sub_trd_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode){
		 var formObj=document.form;
		 if (NewText == 'All'){
			 comboObjects[2].RemoveAll();
			 comboObjects[2].InsertItem(0, "All", "");
			 comboObjects[2].index2=0;
		 }else{
			 doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
		 }
	 }
	  /**
      * Week 날짜 계산
      */  
      function changeWeek(){
    	  var formObj=document.form;
    	  var week=formObj.cost_wk.value * 7;
    	  formObj.cost_year.value=getCalculatedDate(0,0,-week,"").substring(0, 4);
    	  formObj.cost_morth.value=getCalculatedDate(0,0,-week,"").substring(4, 6);
    	  formObj.cost_yrmon.value=getCalculatedDate(0,0,-week,"").substring(0, 6);
      }
      /**
       * 날짜 조회조건 선택
       */  
       function choiceDt(tp){
    	  var formObj=document.form;
    	  if (tp == 'ymd'){
     		  formObj.dt_tp[0].checked=true;
     	  }else{
     		  formObj.dt_tp[1].checked=true;
     	  }
       }
	  /**
      * 날짜 계산 함수
      */
     function getCalculatedDate(iYear,iMonth,iDay,seperator)
     {
     	//현재 날짜 객체를 얻어옴
     	var gdCurDate=new Date();
     	//현재 날짜에 날짜 계산
     	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
     	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
     	gdCurDate.setDate(gdCurDate.getDate() + iDay);
     	//실제 사용할 연,월,일 변수 받기
     	var giYear=gdCurDate.getFullYear();
     	var giMonth=gdCurDate.getMonth()+1;
     	var giDay=gdCurDate.getDate();
     	//월,일의 자릿수를 2자리로 맞춘다.
     	giMonth="0" + giMonth;
     	giMonth=giMonth.substring(giMonth.length-2,giMonth.length);
     	giDay="0" + giDay;
     	giDay=giDay.substring(giDay.length-2,giDay.length);
     	//alert(giYear + seperator + giMonth + seperator + giDay);
     	//display 형태 맞추기
     	return giYear + seperator + giMonth + seperator + giDay;	
     }
      /**
       * RD(Report Designer) Print
       */
       function goPrint(){	
    	   var sheetObj=sheetObjects[0];
    	   var formObj=document.form;
    	   var vvds=formObj.vvds.value;
    	   
    	   var tempStr=vvds.split(",");
    	   
    	   for (var i=0 ; i < tempStr.length ; i++){
    		   if (i == 0){
    			   vvds="'" + tempStr[i] + "'"
    		   }else{
    			   vvds += ",'" + tempStr[i] + "'"
    		   }
    	   }
    	   var rdPath="apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0818.mrd";
    	   formObj.com_mrdTitle.value="Vessel Utilization Status BSA by Lane";
  	 	   formObj.com_mrdBodyTitle.value="Vessel Utilization Status BSA by Lane";
  	 	   formObj.com_mrdPath.value=rdPath;
  	 	   formObj.com_mrdArguments.value="/ronepgrpt /rremakerpt /rv VVDS[" + vvds + "]";
  	 	   //ComDebug(formObj.com_mrdArguments.value);
  	 	   //alert(formObj.com_mrdArguments.value);
  	 	   ComOpenRDPopup();
       }
	/* 개발자 작업  끝 */   
