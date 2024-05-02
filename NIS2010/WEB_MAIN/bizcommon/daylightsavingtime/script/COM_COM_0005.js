/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_COM_0005.js
*@FileTitle  : DaylightSavingTime
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 공통전역변수 */ 
function COM_COM_0005(){
	this.processButtonClick = processButtonClick;
	this.sheet_OnLoadExcel = sheet_OnLoadExcel;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initControl = initControl;
	this.keypressFormat = keypressFormat;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.sheet_OnVScroll = sheet_OnVScroll;
	this.validateForm = validateForm;
} 
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
		 
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			//if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
            	case "btn_Retrieve":
            		doActionIBSheet(sheetObject,formObject,IBSEARCH);
            		break;
            	case "btn_New":
            		sheetObject.RemoveAll();
		            formObject.reset();
            		break;
            	case "btn_Close":
            		self.close();
            		//ComClosePopup(); 
            		break;
            	case "btn_OK":
            		comPopupOK();
            		break;
            	case "btn_loadExcel": 
					//160222 추가 cdh 기존 팝업 clear하고 load한다. load된 data는 저장한다. 
            		sheetObject.LoadExcel(); 
                    break;
            	case "btn_Excelsave":  
					//160222 추가 cdh 기존 팝업 clear하고 load한다. load된 data는 저장한다. 
            		// 신규로만 처리 , 처리하시겠습니까?
            		doActionIBSheet(sheetObject,formObject,COMMAND08);
            		
                    break;           
            	case "btn_DownExcel":
            		if(sheetObject.RowCount < 1){//no data
            			ComShowCodeMessage("COM132501");
            			}else{
 
            				for(var i = 1 ; i <= sheetObject.RowCount; i++){
            					var OrgValue = sheetObject.CellValue(i, "delt_flg");
            					if(OrgValue=="Active")OrgValue = "N"
        						if(OrgValue=="Delete")OrgValue = "Y"
                    						
        							sheetObject.CellValue(i, "delt_flg") = OrgValue;
            				}
            				
            				//sheetObj.Down2Excel({ DownCols:"1|2|3|4|5|6|7|8|9|10|11|12|13|14|15", HiddenColumn:false,Merge:false,TreeLevel:false });
            				sheetObject.SpeedDown2Excel(1);
            				for(var i = 1 ; i <= sheetObject.RowCount; i++){
            					var OrgValue = sheetObject.CellValue(i, "delt_flg");
            					if(OrgValue=="N")OrgValue = "Active"
        						if(OrgValue=="Y")OrgValue = "Delete"
                    						
        							sheetObject.CellValue(i, "delt_flg") = OrgValue;
            				}
            			}
        	        break;
			} // end switch
		}catch(e) {            
			/*
        		자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        		물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
			 */
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	// exce load후 
	function sheet_OnLoadExcel(sheetObj, code, msg){
       // $("#id_esave").css("display","inline-block");
 	}
    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
   
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
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        initControl();
	}
     function initControl() {
     	var formObject=document.form;
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }
   //업무 자바스크립트 OnKeyPress 이벤트 처리
     function keypressFormat() {
     	obj=event.srcElement;
   	    if(obj.dataformat == null) return;
   	    window.defaultStatus=obj.dataformat;
   	    switch(ComGetEvent("name")) {
   	        case "s_dst_cnt_cd":
   	        	ComKeyOnlyAlphabet('upper');
   	        	break;
   	        case "dst_yr":
   	          ComKeyOnlyNumber(event.srcElement); 
   	          break;
   	    }
     }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
 	
        var cnt=0;
        //sheetObj.UseUtf8 = true;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
	            	style.height = 260;
	            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	                
	    	         InitRowInfo( 1, 1, 5, 50);	         
	    	         InitColumnInfo(15, 0, 0, true);
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 //InitHeadMode(false, true, true, false, false, false);
	    	         InitHeadMode(true, true, true, true, false,false);  
		              var mdmYN=document.form.mdm_yn.value;
		              var HeadTitle="||Seq.|DST Code|County|DST Year|DST Diff(Min)|DST Start Date|DST End Date|Not Applying State|ST_DST_HRMNT|END_DST_HRMNT|ST_DST_RULE_DESC|END_DST_RULE_DESC" ;
		              if(mdmYN.replace(/\s/g,"") != ""){
		              HeadTitle += "|Status";
		              }
		              
		              InitHeadRow(0, HeadTitle, true);
		              
		     		 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		              InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
		              InitDataProperty(0, cnt++ , dtCheckBox,       20,    daCenter,  true,      "radio", 				false,          "",         dfNone,      0,     true,        true);
		              InitDataProperty(0, cnt++ , dtSeq,    		30,    daCenter,  true,      "no", 				false,          "",         dfNone,      0,     true,        true);
		  			  InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,  false,     "dst_id",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,  false,     "dst_cnt_cd",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,  false,     "dst_yr",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "dst_mnts",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "st_dst_dt",		false,          "",      	dfDateYmd,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "end_dst_dt",		false,          "",      	dfDateYmd,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtHidden,      	0,   daCenter,  false,     "dst_not_aply_ste_cd",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtHidden,      	0,   daCenter,  false,     "st_dst_hrmnt",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtHidden,      	0,   daCenter,  false,     "end_dst_hrmnt",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtHidden,      	0,   daCenter,  false,     "st_dst_rule_desc",		false,          "",      	dfNone,      0,     false,       true);
		  			  InitDataProperty(0, cnt++ , dtHidden,      	0,   daCenter,  false,     "end_dst_rule_desc",		false,          "",      	dfNone,      0,     false,       true);
		  			  if(mdmYN.replace(/\s/g,"") != ""){
		  				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "delt_flg",		false,          "",      	dfNone,      0,     false,       true);  	
		  			  }		
		  			CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
		             }
                break;
                 
        }
    }
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg =false;
        switch(sAction) {
          case IBSEARCH:        //조회
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCH;     
                formObj.dst_cnt_cd.value=formObj.s_dst_cnt_cd.value;     
                
                selectVal=FormQueryString(formObj)
                //sheetObj.DoSearch("COM_COM_0005GS.do", selectVal+"&iPage=" + iPageNo );
                
                //sheetObj.RenderSheet(0);
				//sheetObj.SetWaitImageVisible(1);
				var sXml=sheetObj.GetSearchXml("COM_COM_0005GS.do", selectVal);
				sheetObj.LoadSearchXml(sXml);
	    		
           break;
           case IBSEARCHAPPEND:  // 페이징 조회
                formObj.f_cmd.value=SEARCH;  
                 sheetObj.DoSearch4Post("COM_COM_0005GS.do", selectVal, "iPage=" + PageNo, true); 
           break;
           case COMMAND08: //cdh 추가 160222 excel load 멀티 저장 
        	   if(ComShowCodeConfirm("COM130101", "Data")){
	        	   formObj.f_cmd.value=MULTI01;
				     
				   var params = "f_cmd="+formObj.f_cmd.value;
				   params += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false) );
				   var sXml = sheetObj.GetSaveData("BCM_CCD_0024GS.do", params);
				   var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				   if(result != "F"){
	                   ComShowCodeMessage("COM130102", "Data");
	                   doActionIBSheet(sheetObj, formObj, IBSEARCH);
	               }else{
	                   ComShowCodeMessage("COM130103", "Data");
	               }
        	   }
		   break;
        }
    }

    function sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
    	//alert("RowCount : "+sheetObjects[0].RowCount+"/total : "+sheetObjects[0].TotalRows );
        // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
   	 //if (sheetObjects[0].RowCount < 50) return;
   	 //doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
   	 //alert(PageNo);
   	//var arrName = PageNo.split("&"); 
   	//var arrValue = arrName[6].split("=");
     //ipageNo = Number(arrValue[1])+1;
   	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            /*if(formObj.cnt_cd.value == "") {
              showErrMessage("You must input Country code");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value.length < 2) {
              showErrMessage("Country code must be 2 characters");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value == "US" && formObj.loc_state.value == "") {
              showErrMessage("You must input State");
              setFocus(formObj.loc_state);
              return false;
            }*/     
        }
        return true;
    }
