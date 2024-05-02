/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1052.js
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :

　
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------For JSDoc ------------------*/


    /**
     * @extends 
     * @class vop_opf_1052 : vop_opf_1052 business script for
     */
    function vop_opf_1052() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	//this.initSheet 				= initSheet;
    	//this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
    /* Developer performance	*/

    // common global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;
    

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
       　
	     var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if(ComGetBtnDisable(srcName)) return false; 
            switch(srcName) {
				case "btn_send":
					if(validateForm(sheetObject1,formObject)){
						//ComSendMail();
						doActionIBSheet(sheetObject1 ,formObject,IBSEARCH);
						self.close();
						//formObject.submit();
					}
					break;
					
				case "btn_close":
					self.close();
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {

			for(i=0;i<sheetObjects.length;i++){

	        //change start configuration method name 
				ComConfigSheet (sheetObjects[i] );

				initSheet(sheetObjects[i],i+1);
	        //add last configuration method 
				ComEndConfigSheet(sheetObjects[i]);
			}
	}
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // setting height
                    style.height = 150;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information [mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "status";
					var headCount = ComCountHeadTitle(HeadTitle);
					
                    //setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, null, true);
                    
                    //data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
				}
                break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	    
	      case IBSEARCH:      //sending mail
	        //formObj.f_cmd.value = SEARCH;
	        sheetObj.DoSearch("VOP_OPF_2052GS.do", FormQueryString(formObj));
	        break;
 	         
	    }
	}
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if(isNull(title.value)){
        		ComShowMessage("[Subject] is mandatory item.");
        		title.focus();
        		return false;
        	}
        	else if(isNull(receiver_eml.value)){
        		ComShowMessage("[Receiver Email] is mandatory item.");
        		receiver_eml.focus();
        		return false;
        	}
        	else if(isNull(content.value)){
        		ComShowMessage("[Content] is mandatory item.");
        		content.focus();
        		return false;
        	}
        }

        return true;
    }
    
    /**
     * checking Null in window form input value
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }

	/* Developer performance  end */