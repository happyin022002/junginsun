// ??????
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var mainPage;
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
        	    	if(mainPage == undefined){                    	
        	    		sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"0|1");
        	    	} else {
        	    		sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"");
                    }
        	        break;
            } // end switch
/*
    }catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    	*/
    }

    /**
     * IBSheet Object? ??? ??
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

     function loadPage(mainpage) {
    	mainPage = mainpage;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		initControl();
		
//		if(window.dialogArguments.document.form.mnr_disp_trf_grp_cd!=undefined)
//		{
//			var formObject = document.form;
//			Text=window.dialogArguments.document.form.mnr_disp_trf_grp_cd.value;
//			if(Text=="RHQ")
//			{
//				formObject.ofc_lev.value="2";
//				formObject.ofc_lev.disabled=true;
//			}
//			else if(Text != "RHQ")
//			{
//				formObject.ofc_lev.length=0;
//				var selOptions=[["1","SHQ"],
//					           ["3","GOF"],
//					           ["4","SOF"],
//					           ["5","LOF"],		
//					           ["6","AGT"]]
//				formObject.ofc_lev.length=selOptions.length;
//				for(var i=0;i<selOptions.length;i++)
//				{
//					formObject.ofc_lev.options[i].value=selOptions[i][0];
//					formObject.ofc_lev.options[i].text=selOptions[i][1];
//				}
//				formObject.ofc_lev.value="1";
//				formObject.ofc_lev.Disabled=false;
//			}
//
//		}
		 var sheetObject = sheetObjects[0];
	     var formObject = document.form;
	     
		
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
  	        case "ofc_pts_cd":
  	        	ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "ofc_cd":
  	        	ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "loc_cd":
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
                    if(mainPage == undefined){
                    	HeadTitle = "| |Seq.|Office|Office Name|Office Type|Location|Address|" ;
                    }else{
                    	HeadTitle = "Seq.|Office|Office Name|Office Type|Location|Address|" ;
                    }

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
            
                    //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    if(mainPage == undefined){
                    	InitDataProperty(0, cnt++ , dtRadioCheck,20,    daCenter,  false,   "radio",        false,          "",       dfNone,	    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,  false,   "checkbox",        false,          "",       dfNone,   	0,     true,       true);
                    }
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,   "seq",        false,          "",       dfNone,   	0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,   "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      180,   daLeft,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      78,    daCenter,  false,   "ofc_knd_cd",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,   "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      190,    	daLeft,  false,    	"ofc_addr",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    	daCenter,  false,    "prnt_ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
               }
                break;

        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:        //??
                if(validateForm(sheetObj,formObj,sAction))
               
                formObj.f_cmd.value = SEARCH;                
                selectVal = FormQueryString(formObj);
                sheetObj.DoSearch4Post("COM_ENS_071GS.do", selectVal);               
               
           break;
           case IBSEARCHAPPEND:  // ??? ??
                formObj.f_cmd.value = SEARCHLIST;              
                sheetObj.DoSearch4Post("COM_ENS_071GS.do", selectVal, "iPage=" + PageNo, true);
           break;

        }
    }

    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {

       // TODO:sheet? ???? ??? ? ????? doActionIBSheet ??? ?? ??????.
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
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
