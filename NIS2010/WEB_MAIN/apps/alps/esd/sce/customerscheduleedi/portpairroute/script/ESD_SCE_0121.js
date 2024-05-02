/**                                                                      
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.         
     * @author SM LINE                                                      // 공통전역변수
     */                                                                  var tabObjects = new Array();
                                                                         var tabCnt = 0 ;
    /**                                                                  var beforetab = 1;
     * @extends                                                          
     * @class ESD_SCE_0121 : ESD_SCE_0121 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.var docObjects = new Array();
     */                                                                  var sheetCnt = 0;
    function ESD_SCE_0121() {                                            
    	this.processButtonClick		= tprocessButtonClick;               var isSearch = false;
    	this.setSheetObject 		= setSheetObject;                    
    	this.loadPage 				= loadPage;                          var selRow = 0;
    	this.initSheet 				= initSheet;                         var isFirst1 = 0;
    	this.initControl            = initControl;                       var isFirst2 = 0; 
    	this.doActionIBSheet 		= doActionIBSheet;                   var grp_cust;
    	this.setTabObject 			= setTabObject;                      
    	this.validateForm 			= validateForm;                      var firstSel = -1;
    	this.setComboObject 		= setComboObject;
    }     
                                                                   
// 공통전역변수
var pageNo =1 ;

var sheetObjects = new Array();
var comboCnt = 0;
var comboObjects = new Array();

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){

   sheetObjects[sheetCnt++] = sheet_obj;

}	
//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
//ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];
     //var sheetObject1 = sheetObjects[1];
     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		// 버튼이 disable 인지 확인한다.
          //if(srcName != null && !isEmpty2(srcName)) {
           //   var btnDis  = eval("formObject."+srcName+".disabled");
          //    if (btnDis) return;
          //}
        /****************************
         enterKey 처리
        *****************************/
          
        var srcObj=window.event.srcElement.nodeName;
        var keyObj=window.event.keyCode;
        if(srcObj =='INPUT' && keyObj ==13) {
            srcName ='btn_retrieve';
//            showErrMessage(srcName+':srcName')
        }
        
        /****************************/
        switch(srcName) {

    	    case "btn_retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

    	    case "btn_save":
	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;

    	    case "btn_downexcel":
    	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	        break;
    	    case "btn_add":
    	        doActionIBSheet(sheetObject,formObject,IBINSERT);
    	        break;        	        
/*
       	    case "btn_save_partner":
    	        doActionIBSheet(sheetObject,formObject, MULTI01);
    	        break;         	        
*/

			case "btn_por_port_cd":
				selectPort(formObject, 'POR');
    	        break;

			case "btn_pol_port_cd":
	            selectPort(formObject, 'POL');
    	        break;

			case "btn_pod_port_cd":
	            selectPort(formObject, 'POD');
    	        break;

			case "btn_del_port_cd":
				selectPort(formObject, 'DEL');
    	        break;
    	        
			case "ts_type":
	            selectType();
    	        break;
			case "no_use_flag":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;				

			case "btn_ocn":
				doActionIBSheet(sheetObject,formObject,SEARCH02);
    	        break;	

        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			//showErrMessage("지금은 사용하실 수가 없습니다");
		} else {
			//showErrMessage(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){

    //khlee-시작 환경 설정 함수 이름 변경
       ComConfigSheet(sheetObjects[i]);
       initSheet(sheetObjects[i],i+1);
      
    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    /* IBMultiCombo 초기화 */
 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {		 
 		initCombo(comboObjects[k], k+1);
 	}	
	    
    initControl();
    doActionIBSheet(sheetObjects[0],document.form,SEARCH09);

}


/**
 * MultiCombo object initial property //LHS
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo (comboObj, comboNo) {
	 switch(comboObj.id) {
   	 case "partner_id_cd":
		with(comboObj) {
			//BackColor = "cyan";
//   		SetTitle("Id|Desc");
   		SetColWidth("200|300");
			DropHeight = 150;
			MultiSelect = false;
			UseAutoComplete = true;
			MultiSeparator = ",";
			Style = 1;
			ValidChar(2,3);
//			UseCode = false;				
		}
	break;
	 }      	
} 


/* initControl() */
        function initControl() {
        	//axon_event.addListenerFormat('blur',     'obj_blur',  	 form);
        	//axon_event.addListenerFormat('focus',    'obj_focus', 	 form);
        	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        	axon_event.addListenerFormat('keyup', 	 'obj_keyup', 	 form);
        }

/** 
         * Object 의 Keypress 이벤트에 대한 처리  <br>
         * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
         * @param  없음
         * @return 없음
         * @author 김종옥
         * @version 2009.06.15
         */ 
        function obj_keypress(){
         	obj = event.srcElement;
         	if(obj.dataformat == null) return;
         	 	
         	window.defaultStatus = obj.dataformat;
         	 
         	switch(obj.dataformat) {
         	    case "engup":
         	        ComKeyOnlyAlphabet('upper');
         	        break;
         	}
        }    
        
        /** 
         * Object 의 Keypress 이벤트에 대한 처리  <br>
         * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
         * @param  없음
         * @return 없음
         * @author 김종옥
         * @version 2009.06.15
         */ 
        function obj_keyup(){
        	
        	var formObj = document.form;
         	obj = event.srcElement;
         	
         	if(obj.dataformat == null) return;
         	 	
         	window.defaultStatus = obj.dataformat;
         	 
         	switch(obj.dataformat) {
         	    case "engup":
         	    /*
         	        if(document.form.vsl_cd.value.length == 4 ){
         	        	//loc_cd_onchange();
        	    		formObj.f_cmd.value = SEARCH02;
        	    		var sXml = sheetObjects[2].GetSearchXml("VOP_OPF_0003GS.do", SceFrmQryString(formObj));
        	    		var sVslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
        	    		if(sVslEngNm=="null" || sVslEngNm==null || sVslEngNm==""){
        	    			formObj.vsl_eng_nm.value = "";
        	    		}else{
        	    			formObj.vsl_eng_nm.value = sVslEngNm;
        	    		}
         	        }
         	        break;
         	        */
         	}
        }

/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetNo) {
     
         case 1:      //IBSheet1 init
        	 
             with (sheetObj) {
                 //전체 너비 설정
                 style.height = GetSheetHeight(12) ;
                 //style.height = 270 ;
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 9, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(21, 4, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle =  "SEQ|No \nUse|STS|POR|POL|1st T/S|2nd T/S|3rd T/S|POD|DEL|Block Lane|Ocean\n Flag|C.Date|C.User|No Use.\nDate|No Use.\nUser";
                 var HeadTitle1 = "SEQ|No \nUse|STS|POR|POL|Port|Port|Port|POD|DEL|Block Lane|Ocean\n Flag|C.Date|C.User|No Use.\nDate|No Use.\nUser";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);
                 InitHeadRow(1, HeadTitle1, false);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,    "sSeq",     	false,          "",       dfNone,   	0,  false, false, 3,         true);
                 InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "sCheck",    	false,          "",       dfNone,	    0,  true,  false, 1,         true);
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  true,    "ibflag",  	false,          "",       dfNone,	    0,  true,  true,  5,         true);
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "por_cd",     	false,          "",       dfEngUpKey,  	0,  false, true,  5,         true);
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "pol_cd",     	true,           "",       dfEngUpKey,  	0,  false, true,  5,         true);                 
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "n2nd_pol_cd", false,           "",       dfEngUpKey,  	0,  false, true,  5,         false);
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "n3rd_pol_cd",  false,           "",       dfEngUpKey,  	0,  false, true,  5,         false);
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "n4th_pol_cd", false,           "",       dfEngUpKey,  	0,  false, true,  5,         false);
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "pod_cd",    	true,           "",       dfEngUpKey,  	0,  false, true,  5,         false);                 
                 InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "del_cd",    	false,          "",       dfEngUpKey,  	0,  false, true,  5,         false);
                 InitDataProperty(0, cnt++ , dtPopup,  150,    daCenter,  true,    "block_lanes",false,          "",       dfNone,  	0,  true, true,  1,         false);
                 InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    "ocean_flag", false,          "",       dfNone,  	0,  false, false,  1,         true);
                 InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  true,    "cre_dt",   	false,          "",       dfUserFormat2, 0, false, false, 12,        true);
                 InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "cre_usr_id",  false,          "",       dfNone,     	0,  false, false, 20,        true);
                 InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  true,    "upd_dt",   	false,          "",       dfUserFormat2, 0, false, false, 12,        false);
                 InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "upd_usr_id",  false,           "",       dfNone,  	     0, false, false, 20,        false);
                 //hidden fields                 
				 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "use_flg",    false,          "",       dfNone, 		 0, false, false, 1,         true);
				 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "mnl_use_flg", false,          "",       dfNone, 		 0, false, false, 1,         true);				 
				 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "cust_trd_prnr_id",    false,          "",       dfNone, 		 0, false, false, 20,        false);
				 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "rout_rcv_dt", false,          "",       dfNone, 		 0, false, false, 20,        false);
				 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "rout_seq",   false,          "",       dfNone, 		 0, false, false, 20,        false);				 
				 
				 InitDataValid(0, "por_cd", vtEngUpOnly);			
				 InitDataValid(0, "pol_cd", vtEngUpOnly);	
				 InitDataValid(0, "n2nd_pol_cd", vtEngUpOnly);	
				 InitDataValid(0, "n3rd_pol_cd", vtEngUpOnly);	
				 InitDataValid(0, "n4th_pol_cd", vtEngUpOnly);	
				 InitDataValid(0, "pod_cd", vtEngUpOnly);	
				 InitDataValid(0, "del_cd", vtEngUpOnly);	
//				 InitDataValid(0, "block_lanes", vtEngUpOnly);	
				 
                 //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
		         InitDataCombo (0, "ocean_flag", " |Standard|Guide|Manual", " |S|G|M", "Standard");
		         //InitDataCombo (0, "ocean_flag", " |Guide|Standard|Temporary|Add Call|Validation|Doubt|Not Used|Deleted", " |G|S|T|A|V|O|N|D");   // Route Flag - add 2007.12.11		         
				 InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
				 InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:" );				 

		         RangeBackColor(1, 5, 1, 9) = RgbColor(222, 251, 248);   // ENIS
		         HeadRowHeight = 20 ;
		            
             }
             break;

     }
    
 }

 
	
 // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg = false;

       switch(sAction) {

          case IBSEARCH:      //조회
        	  
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(!mandatoryChk(formObj)) break;
				if(!ComChkRequired(formObj)) return;
				formObj.f_cmd.value = SEARCH;
				//alert(SceFrmQryString(formObj));
				sheetObj.DoSearch4Post("ESD_SCE_0121GS.do", SceFrmQryString(formObj));
				break;
           case IBSAVE:        //저장
        	   if(!validateForm(sheetObj,formObj,sAction)) return;
               formObj.f_cmd.value = MULTI;
               //alert(SceFrmQryString(formObj));
               sheetObj.DoSave("ESD_SCE_0121GS.do", SceFrmQryString(formObj));
               formObj.f_cmd.value = SEARCH;
               sheetObj.DoSearch4Post("ESD_SCE_0121GS.do", SceFrmQryString(formObj));
               break;

          case IBINSERT:      // 입력
        	    var in_row = sheetObj.DataInsert(-1);   
        	    sheetObj.CellEditable(in_row,"block_lanes") = false;

        	    
				break;

          case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;
				
          case SEARCH01:
				document.getElementById('partner_id').value = document.getElementById('partner_id').value.toUpperCase();
                sheetObj.ShowDebugMsg = false;
              	formObj.f_cmd.value = SEARCH01; 
              	//sheetObj.DoSearch("ESD_SCE_120GS.do",SceFrmQryString(formObj));
              	var sXml = sheetObj.GetSearchXml("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
        	    var partner_name = ComGetEtcData(sXml, "partner_name");
        	    
              	//var partner_name = sheetObj.EtcData("partner_name");
                document.getElementById('partner_name').value = partner_name;
                ComEtcDataToForm(formObj,sheetObj) ;            

                sheetObj.RemoveAll();
                break; 

          case SEARCH02:         
//      	    	alert(sheetObj.CellValue(sheetObj.selectedRow,"por_cd"));
//      	    	alert(sheetObj.selectRow);
	      		var rout_rcv_dt = sheetObj.CellValue(sheetObj.selectRow,"rout_rcv_dt");
	      		if(rout_rcv_dt =='') {
	      			return;
	      		}
	      		
	    		var rout_seq = sheetObj.CellValue(sheetObj.selectRow,"rout_seq");
	        	var por_cd = sheetObj.CellValue(sheetObj.selectRow,"por_cd");
	        	var pol_cd = sheetObj.CellValue(sheetObj.selectRow,"pol_cd");
//	        	var n1st_pol_cd = sheetObj.CellValue(sheetObj.selectRow,"n1st_pol_cd");
//	        	var n1st_pod_cd = sheetObj.CellValue(sheetObj.selectRow,"n1st_pod_cd");
	        	var n2nd_pol_cd = sheetObj.CellValue(sheetObj.selectRow,"n2nd_pol_cd");
	        	var n3rd_pol_cd = sheetObj.CellValue(sheetObj.selectRow,"n3rd_pol_cd");
	        	
	        	var pod_cd = sheetObj.CellValue(sheetObj.selectRow,"pod_cd");
	        	var del_cd = sheetObj.CellValue(sheetObj.selectRow,"del_cd");
	        	var block_lanes = sheetObj.CellValue(sheetObj.selectRow,"block_lanes");
	            
	        	var param = '?por_cd=' + por_cd+ '&pol_cd=' + pol_cd+ '&pod_cd=' + pod_cd+ '&del_cd=' + del_cd
	        	            + '&rout_rcv_dt=' + rout_rcv_dt + '&rout_seq=' + rout_seq 
	        	            + '&n2nd_pol_cd=' + n2nd_pol_cd  
	        	            + '&n3rd_pol_cd=' + n3rd_pol_cd  
	        	            + '&block_lanes=' + block_lanes+ "&mode=pop&pgmNo=ESD_SCE_0126";
        	//      	    	alert(param);
      	    	winObject = window.open("/hanjin/ESD_SCE_0126.do" + param, "SM LINEPI", "height=550, width=1000, top=0");
        	  break; 
          case SEARCH09: //open
        	    formObj.f_cmd.value = SEARCH09;
        	    var sXml = sheetObj.GetSearchXml("ESD_SCE_0121GS.do", FormQueryString(formObj));
        	    ComXml2ComboItem(sXml, formObj.partner_id_cd, "val", "combo_cd|name");        	  
        	    break; 
        	  
       }
   }
   
   /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
	
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){

       }
       switch(sAction) {
      		case IBSAVE:
       		   if(formObj.partner_id.value == ""){
      	           ComShowCodeMessage("COM12114" ,"TP ID",'','');
      	           return false;		   
      		   }
      		   if(formObj.partner_name.value == ""){
      	           ComShowCodeMessage("COM12114" ,"TP NAME",'','');
      	           return false;		   
      		   } 
      		   //grid의 validation check
      		   //
      		   var rowCnt = sheetObj.Rows;
      		   var startRow = 2;
      		   
      		   for(var i=startRow; i<rowCnt; i++){

      			   var rowStatus = sheetObj.RowStatus(i);
      			   var checkRow = i - 1;  
      			   if(rowStatus == 'I'){
      				   if(sheetObj.CellValue(i, "n4th_pol_cd")!= '' ){
       					  if(sheetObj.CellValue(i, "n2nd_pol_cd")== ''){
         						  ComShowCodeMessage("COM12130" ,'['+checkRow+'] row',"1st T/S Port",'');
         						  sheetObj.SelectCell(i, "n2nd_pol_cd");       						  
         						  return false;
       					  }
       					  if(sheetObj.CellValue(i, "n3rd_pol_cd")== ''){
         						  ComShowCodeMessage("COM12130" ,'['+checkRow+'] row',"2nd T/S Port",'');
         						  sheetObj.SelectCell(i, "n3rd_pol_cd");       						  
          					  return false;
       					  }    					  
       				   }   
      				   if(sheetObj.CellValue(i, "n3rd_pol_cd") != '' ){
      					  if(sheetObj.CellValue(i, "n2nd_pol_cd")== ''){
        						  ComShowCodeMessage("COM12130" ,'['+checkRow+'] row',"1st T/S Port",'');
        						  sheetObj.SelectCell(i, "n2nd_pol_cd");       						  
        						  return false;
      					  }
      				   }        				   
      			   }//End of if
      			  // sheetObj.CellValue(i, "por_cd")== sheetObj.CellValue(i, "por_cd").toUpperCase();
      		   }//End of for
      		   break;
      			
      		   
       }
       return true;
   }

	
   function mandatoryChk(formObj) {
	   if(formObj.partner_id.value == "" || formObj.partner_name.value == ""){
           ComShowCodeMessage("COM12114" ,"TP ID",'','');
           return false;		   
	   }
       return true;
   }

   
	function getPartnerName(){
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        /*******************************************************/
        var formObj = document.form;

	   if(formObj.partner_id.value == "" ){
           ComShowCodeMessage("COM12114" ,"TP ID",'','');
           return false;		   
	   }
		doActionIBSheet(sheetObject,formObj,SEARCH01);
	
	}   

	function changeSelect(gubun) {
		var frm = document.form;
		var val = frm.select1[frm.select1.selectedIndex].value;
		frm.ts_type.value = val; 
	}

	function selectType() {
	    var frm = document.form;
        var ts_type = frm.ts_type.value;
	    var param = '?&ts_type='+ts_type;

       //comPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1");
       
	}

	var portInd = '';
	function selectPort(frm, pt){
		portInd = pt;
		var param = '';
		if(pt == 'POR') param = '?loc_cd='+frm.por_port_cd.value;
		if(pt == 'POL') param = '?loc_cd='+frm.pol_port_cd.value;
		if(pt == 'POD') param = '?loc_cd='+frm.pod_port_cd.value;
		if(pt == 'DEL') param = '?loc_cd='+frm.del_port_cd.value;
		//ComShowCodeMessage("o param : " + param);
		comPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];
		var frm = document.form;
		if(portInd == 'POR'){
			 frm.por_port_cd.value = cArray[3];
		}		
		if(portInd == 'POL'){
			 frm.pol_port_cd.value = cArray[3];
		}
		if(portInd == 'POD'){
			 frm.pod_port_cd.value = cArray[3];
		}
		if(portInd == 'DEL'){
			 frm.del_port_cd.value = cArray[3];
		}		
	}

	function doOcnRouteInfo(sheetObject) {
//		doOcnRouteInfo(sheetObject,formObject,SEARCH01);
	    var formObj = document.form;
	    
	    var param = '?loc_cd=' + document.getElementsByName("location_code")[0].value + "&mode=pop&pgmNo=ESD_SCE_0126";
	    winObject = window.open("/hanjin/ESD_SCE_0126.do" + param, "SM LINEPI", "height=450, width=1020, top=0");
	}	
	
	function partner_id_cd_OnChange(comboObj, code, text) {
//		alert(comboObj.GetText(ComGetObjValue(document.form.partner_id_cd),1));
//		alert(comboObj.GetText( code,1));
		document.form.partner_id.value = code;
		document.form.partner_name.value = comboObj.GetText( code,1);
		
	}
	
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		if (sheetObj.ColSaveName(Col) == "block_lanes") {
	  		var sUrl = "/hanjin/ESD_SCE_0124.do";
	  		var rout_rcv_dt = sheetObj.CellValue(Row,  sheetObj.SaveNameCol("rout_rcv_dt"));
	  		var rout_seq = sheetObj.CellValue(Row,  sheetObj.SaveNameCol("rout_seq"));
	  		var param = "?gubun=A&rout_rcv_dt="+rout_rcv_dt+"&rout_seq="+rout_seq;
	  		ComOpenPopup(sUrl + param, 428, 430, "", "none",true);
//	  		var sUrl = "/hanjin/ESD_SCE_0124.do";
//	  		var partner_id = document.form.partner_id.value;
//	  		var pol_cd = sheetObj.CellValue(Row,  sheetObj.SaveNameCol("pol_cd"));
//	  		var pod_cd = sheetObj.CellValue(Row,  sheetObj.SaveNameCol("pod_cd"));
//	  		var rout_seq = sheetObj.CellValue(Row,  sheetObj.SaveNameCol("rout_seq"));
//	  		var param = "?gubun=B&cust_trd_prnr_id="+partner_id+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&rout_seq="+rout_seq;
//	  		ComOpenPopup(sUrl + param, 428, 430, "", "none",true);
		}
	}
	
    function popOk(gubun, blockSel){
  	  var sheetObj = "";
//  	  if(gubun == "is_dct_adj_dy"){
//	    	  var i = sheetObjects[0].selectRow;
//	    	  sheetObjects[0].CellValue2(i, sheetObjects[0].SaveNameCol(prefix1+"block_lane")) = blockSel;
//  	  }else{	//B
	     var i = sheetObjects[0].selectRow;
  	  	  sheetObjects[0].CellValue2(i, sheetObjects[0].SaveNameCol("block_lanes"))  = blockSel;
//  	  }
    }

    function sheet1_OnDblClick(sheetObj, Row, Col, value) {
   	
    	var formObj = document.form;
		var rout_rcv_dt = sheetObj.CellValue(sheetObj.selectRow,"rout_rcv_dt");
  		if(rout_rcv_dt =='') {
  			return;
  		}
		var rout_seq = sheetObj.CellValue(sheetObj.selectRow,"rout_seq");
    	var por_cd = sheetObj.CellValue(sheetObj.selectRow,"por_cd");
    	var pol_cd = sheetObj.CellValue(sheetObj.selectRow,"pol_cd");
    	var n2nd_pol_cd = sheetObj.CellValue(sheetObj.selectRow,"n2nd_pol_cd");
    	var n3rd_pol_cd = sheetObj.CellValue(sheetObj.selectRow,"n3rd_pol_cd");
    	var pod_cd = sheetObj.CellValue(sheetObj.selectRow,"pod_cd");
    	var del_cd = sheetObj.CellValue(sheetObj.selectRow,"del_cd");
    	var block_lanes = sheetObj.CellValue(sheetObj.selectRow,"block_lanes");
        
    	var param = '?por_cd=' + por_cd+ '&pol_cd=' + pol_cd+ '&pod_cd=' + pod_cd+ '&del_cd=' + del_cd
    	            + '&rout_rcv_dt=' + rout_rcv_dt + '&rout_seq=' + rout_seq 
    	            + '&n2nd_pol_cd=' + n2nd_pol_cd  
    	            + '&n3rd_pol_cd=' + n3rd_pol_cd  
    	            + '&block_lanes=' + block_lanes+ "&mode=pop&pgmNo=ESD_SCE_0126";
    	winObject = window.open("/hanjin/ESD_SCE_0126.do" + param, "SM LINEPI", "height=550, width=1000, top=0");


    }    
	/**
 *  LOC(ROR/POL/POD/EDL) 팝업 오픈 &&&
 *
 * @param multi multi check 여부
 * @param custCd Customer Code
 * @param custNm Customer Name
 * @param ofcCd Sales Office
 * @param custSgmt Segmentation
 * 2008.6.24 LOC(ROR/POL/POD/EDL)팝업창 추가
 */
	/*
function openLocPopUp(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
                    locState, locEqOfc, locPortInd, sysCode){
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;

	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "conti_cd",     contiCd) ;
	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
	param += getURLParam(multi, "cnt_cd",       cntCd) ;
	param += getURLParam(multi, "loc_state",    locState) ;
	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
	param += getURLParam(multi, "loc_cd",       locCd) ;
	param += getURLParam(multi, "loc_desc",     locDesc) ;
	param += getURLParam(multi, "loc_port_ind", locPortInd) ;
	param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;
	ComOpenPopup('ESD_SCE_0109.do' + param, 800, 470, 'setValFromLocPop', display) ;
	contiCdFld    = contiCd ;
	scontiCdFld   = scontiCd ;
	cntCdFld      = cntCd ;
	locStateFld   = locState ;
	locEqOfcFld   = locEqOfc ;
	locCdFld      = locCd ;
	locDescFld    = locDesc ;
	locPortIndFld = locPortInd ;
	sysCodeFld    = sysCode ;
	multiChkYN    = multi
}
	*/