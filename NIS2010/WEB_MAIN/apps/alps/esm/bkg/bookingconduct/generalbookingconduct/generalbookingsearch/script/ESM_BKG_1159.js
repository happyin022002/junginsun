// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

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
        	        break;

        	    case "btn_OK":
                    comPopupOK();
        	        break;

        	    case "btn2_Down_Excel":
        	    	sheetObject.Down2Excel(false,false,true,false,"","",false,false,"",false,"0|1|2");        	    	
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
    	var formObject = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('change'				, 'cust_cnt_cd_OnChange'	, form);
    }
    
  //업무 자바스크립트 OnKeyPress 이벤트 처리
    function keypressFormat() {
    	obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	    switch(obj.name) {
  	        case "cust":
  	        	ComKeyOnlyNumber(obj);
  	            break;
  	        case "ofc_cd":
  	        	ComKeyOnlyAlphabet('upper');
  	        	break;
  	        case "cust_nm":
//  	        	ComKeyOnlyAlphabet('upper','32');
	            break;
  	        case "cust_cd":
	        	ComKeyOnlyAlphabet('upper');
	            break;
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
        if(document.form.cust_cd.value !="US"){
 			document.form.area_cd.className = "input2";
 			document.form.area_cd.readOnly = true;
 		}else{
 			document.form.area_cd.className = "input";
 			document.form.area_cd.readOnly = false;
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
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(19, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    
                    var HeadTitle = "||Seq.|Status|Type|Cust. Code|Financial Risk|No Use|Customer Name|S.OFC|Location|City|Location code|ST|Address|ZIP|TEL|Group Code|Vndr Code" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false, "radio",   				false,          "",       dfNone,	    0,     true,        true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false, "checkbox",   			false,          "",       dfNone,   	0,     true,        true);
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false, "seq",     				false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,		 70,    daCenter,  false, "pb",				   	    false,          "",       dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData,      0,     daCenter,  false, "rvis_cntr_cust_tp_cd",   false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false, "cust_cd", 				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  false, "booking_alert_to_date",  false,		    "",       dfNone,		0,	   false,		false);                    
                    InitDataProperty(0, cnt++ , dtData,	     70,	daCenter,  false, "no_use",			        false,		    "",	      dfNone,		0,	   false,		false);                    
                    InitDataProperty(0, cnt++ , dtData,      200,   daLeft  ,  false, "cust_nm", 				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false, "ofc_cd",  				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,     daCenter,  false, "loc_cd",   			    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,     daCenter,  false, "cty_nm",   			    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      150,   daCenter,  false, "location_code",   		false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,     daCenter,  false, "ste_cd",   			    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      300,   daLeft,    false, "bzet_addr",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daLeft,    false, "zip_cd",   			    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,   daRight,   false, "phn_no",   			    false,          "",       dfNone,   	0,     false,       true);       
                    InitDataProperty(0, cnt++ , dtData,      0,     daCenter,  false, "cust_grp_id",   		    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,     daCenter,  false, "vndr_seq",     			false,          "",       dfNone,   	0,     false,       true);
                    
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
               }
                break;

        }
    }



    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 




  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                	
                	 formObj.f_cmd.value = SEARCH;
                     selectVal = FormQueryString(formObj);
//                     sheetObj.UseZipFile = true;
                     
                     var sXml = sheetObj.GetSearchXml("ESM_BKG_1159GS.do", selectVal);
                     sheetObj.LoadSearchXml(sXml);
//                     sheetObj.ShowDebugMsg = false;
//                     sheetObj.DoSearch("COM_ENS_041GS.do?UseZipFile=true", selectVal);
                }else{
                	return true;
                }
           
           break;
           case IBSEARCHAPPEND:  // 페이징 조회
           
           formObj.f_cmd.value = SEARCH;         
           sheetObj.DoSearch4Post("ESM_BKG_1159GS.do", selectVal, "iPage=" + PageNo, true);  
           break;

        }
    }



   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction){
         case IBSEARCH:
        	 if(formObj.prgm_id.value =="ESM_BKG_1054" ){
        		 if(ComIsNull(formObj.cust_cd.value)){
	    			 ComShowCodeMessage("BKG95046", "Customer Country Code");
	    			 formObj.cust_cd.focus();
	    			 return false;        		 
        		 }
        	 }else{
        		 if(ComIsNull(formObj.cust.value) && formObj.cust_nm.value.length < 2){
        			 ComShowCodeMessage("BKG95046", "Customer Code No. or Name");
        			 formObj.cust.focus();
        			 return false;
        		 }
        	 }
        	 
        	  //space나 특수문자만 조회할 경우 막음
        if(!ComIsNull(formObj.cust_nm.value)){
          	if(ComTrimAll(formObj.cust_nm.value, "~","`","!","@","#","$","%","^","*","&","(",")","-","_","=","|","+","<",">", ",",".","'",":",";","?","/"," ").length <= 0 ||ComTrimAll(formObj.cust_nm.value).length <= 0){
          		ComShowCodeMessage("BKG43048");
          		 formObj.cust_nm.focus();
                 return false;
          	}
         }
        }

        return true;
    }

     /**
      * DEL 콤보 Change 이벤트 발생 처리<br>
      * DEL CD 를 DEL 선택한 코드값으로 변경한다.<br>
      * 
      * @return 
      * @author 
      * @version 2009.07.09
      */
     function cust_cnt_cd_OnChange() {
     	var formObj = document.form;
     	if(formObj.cust_cd.value !="US"){
     		document.form.area_cd.className = "input2";
 			document.form.area_cd.readOnly = true;
     	}else{
     		document.form.area_cd.className = "input";
 			document.form.area_cd.readOnly = false;
     	}
     }