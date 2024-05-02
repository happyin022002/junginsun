/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : roleinquiry.js
*@FileTitle : Role Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
document.onclick = processButtonClick;

    function processButtonClick(){
         /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

//    	try {
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
        	    	sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"");
        	        break;
            } 
    }

    /**
     * IBSheet Object? ??? ??
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

     function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		//initControl();
	
		 //var sheetObject = sheetObjects[0];
	     //var formObject = document.form;
	     
		
    }
    
 	function initControl() {
		var formObject = document.form;
		 //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}

    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function keypressFormat() {
    	obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	    switch(obj.name) {
  	        case "usr_role_cd":
  	        	ComKeyOnlyAlphabet('upper');
	            break;
  	    }
    }
    
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // ?? ??
                    style.height = 240;
                    //?? ?? ??
                    SheetWidth = mainTable.clientWidth;

                    //Host?? ??[??][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //??Merge ?? [??, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //??Edit ?? ?? [??, Default false]
                    Editable = true;

                    //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    // ???? ??? ? ?? ?? ??? ????
                    InitHeadMode(true, true, true, true, false,false)
                    var HeadTitle;
                   	HeadTitle = "| |Seq.|Role Code|Role Name|Role Desc" ;

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
            
                    //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,20,    daCenter,  false,   "radio",        false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,  false,   "checkbox",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,       40,    daCenter,  false,   "seq",       	  false,          "",       dfNone,   	  0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,   "usr_role_cd",    false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      180,   daLeft,    false,   "usr_role_nm",    false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      180,   daLeft,    false,   "usr_role_desc",  false,          "",       dfNone,       0,     false,       true);
         
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 

               }
                break;

        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:        //??
        	   formObj.f_cmd.value = SEARCH02;
               sheetObj.DoSearch4Post("searchRoleMapping.do", FormQueryString(formObj));
               break;
        }
    }

   /**
     * ?? ????? ?? ????? ???? ??
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }