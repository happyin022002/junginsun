/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : vop_scg_0059.jsp
 *@FileTitle: Special Provisions (Inquiry)
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0059 : vop_scg_0059 business javascript for
     */
//    function vop_scg_0059() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form; 
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    descClear();
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;
                case "btn1_Excel":
                    var paramObj=new Object();
                    paramObj.title="Special Provisions";
//                    paramObj.columnwidth="2:15|3:100";
//                    var url=ComScgGetPgmTitle(sheetObj, paramObj);  
////                    sheetObj.Down2Excel({ HiddenColumn:0,URL:"url",TreeLevel:false});
//                    if(sheetObject.RowCount() < 1){//no data
//               		 ComShowCodeMessage("COM132501");
//       	       		}else{
//       	       		sheetObject.Down2Excel({ HiddenColumn:{HiddenColumn:0}});
//       	       		}
					var sheetExcelObj = sheetObject;
                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
                    paramObj.datarowheight="0:25";
                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
                    
                    if(sheetExcelObj.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
	       	       		var str = sheetExcelObj.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}                    
                    break;  
 				case "btn_OK":
 					if (sheetObject.FindCheckedRow("radio") == "") {
 						ComShowCodeMessage("COM12189");
 						return 0;
 					}
					comPopupOKVOP();
					break;
 				case "btn_Close":
 					ComClosePopup(); 
					break;
             } // end switch
        }catch(e) {
        	if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
        }
     }
 	
	// 부모창의 Target Object에 값 세팅
	function comPopupOKVOP() {
		//alert(preConds.objName);
		// 모달창인 경우는 window 객체로부터 opener를 획득			        
		opener = window.dialogArguments;
		if (!opener) opener=parent; //이 코드 추가할것
			
		var rArray = null; 	// 행데이터를 담고 있는 배열
		var val	   = "";	// Target Object에 세팅할 값
		
		var tagName = opener.document.all[preConds.objName].tagName;
		
		// 단일선택(Radio) 또는 다중선택(CheckBox) 일 때..
		if("radio" == "radio" || "radio" == "checkbox") {
			rArray = getCheckedRows("imdg_spcl_provi_no");
        }
        // 선택박스가 없는경우.. 단일선택
        else {
        	rArray = getSelectedRow("imdg_spcl_provi_no");
        }
		
		val = rArray;
		
		for(var i=1; i<=8; i++){
			var cval = eval("parent.document.form.frm_imdg_spcl_provi_no"+i+".value");
			
			if(val == cval){
				ComShowCodeMessage('SCG50005','Data');   //'{?msg1} is duplicated.'
				parent.document.all[preConds.objName].value = "";
				try {
					// Target Object에 OnChange 이벤트 발생시킨다.
					// => 이것은 Onchange 이벤트를 지정한 Object에만 영향을 끼친다.
					opener.document.all[preConds.objName].fireEvent("onchange");
				} catch(e) {}
				ComClosePopup();
			}
		}
		
		// Target Object에 입력할 값을 획득
		/*for(var i=0; i<rArray.length; i++) {
			if(i == 0) {
				val += rArray[i];
				
				// Combo박스인 경우는 맨 처음 값으로 세팅 후 break
				if(tagName == "SELECT") {								
					break;
				}
			} else {
				// 중복체크 
				if(!chkDup(val, rArray[i]))
					val += "," + rArray[i];
			}
		}*/
		
		// Target Object에 값 세팅
		try {
			opener.document.all[preConds.objName].value = val;
			
			try {
				// Target Object에 OnChange 이벤트 발생시킨다.
				// => 이것은 Onchange 이벤트를 지정한 Object에만 영향을 끼친다.
				//opener.document.all[preConds.objName].fireEvent("onchange");

				// BKG DG Application 호출 용 2015-11-30
				if(opener.set_imdg_un_no_spcl_provi_ctnt() != undefined){
					set_imdg_un_no_spcl_provi_ctnt();
				}
			} catch(e) {}
			ComClosePopup();
			
		}
		catch(e) {
		 	ComShowCodeMessage("COM12111");
		}
		
	}
	
	function chkDup(val, ind) {
		var bDup = false;
		
		var arrVal = val.split(",");
		for(var i=0; i<arrVal.length; i++) {
			if(arrVal[i] == ind) {
				bDup = true;
				break;
			}
		}
		
		return bDup;
	}    
    
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         sheet1_OnLoadFinish(sheetObjects[0]);
         // ::DG RailBilling 2015-12-03 ::
         initConfig();
         
     }
     function sheet1_OnLoadFinish(sheetObj) {         
         if(preConds.pop_yn == 'Y') {
        	 if(sheetObj.GetColHidden("radio") == 1) {
        		 sheetObj.SetColHidden("radio", 0);
        	 }
	         if(preConds.imdg_spcl_provi_no != '') {	         	
	         	if(preConds.imdg_spcl_provi_no != '') ComSetObjValue(document.form.imdg_spcl_provi_no, preConds.imdg_spcl_provi_no);
	         }
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {               
	                var HeadTitle="||No.|Special Provisions||";
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio" },
	                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"imdg_spcl_provi_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000 },
	                       {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetEditableColorDiff(0);              
	                SetColHidden("radio",1);
	                resizeSheet();
                }
                break;
         }
     }
     
     function resizeSheet(){
    	 ComResizeSheet(sheetObjects[0]);
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH;
                        sheetObj.DoSearch("VOP_SCG_0041GS.do", FormQueryString(formObj) );
                    }
                }           
                break;
         }
     }
    /**
      * Dynamically load HTML Control event in page. <br>
      * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects list in turn
      **/
     function initControl() {       
    		var formObject = document.form;
    		// Axon Event Processing 1. Events catch (developers change)
    		//axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); //- When typing the keyboard
    		axon_event.addListenerForm ('keydown', 'ComKeyEnter', document.form);           
     }
     /**
      * Handling Form Object obj_keypress event
      * @param  void
      * @return void
      */     
      function obj_keypress (){
          var obj=ComGetEvent();
          switch(ComGetEvent("name")){
               case 'imdg_spcl_provi_no':
                    ComKeyOnlyNumber(obj);
                    break;
          }
      }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
        return true;
     }
      /**
       * Clicking IBSheet Object
       */
      function sheet1_OnClick(sheetObj,Row, Col, Value) {
         var formObj=document.form;
//         if (sheetObj.ColSaveName(Col) == "imdg_spcl_provi_no" || Col=="imdg_spcl_provi_no") {
         if (sheetObj.ColSaveName(Col) == "imdg_spcl_provi_no") {
        	 formObj.imdg_spcl_provi_no2.value=sheetObj.GetCellValue(Row,"imdg_spcl_provi_no");
        	 formObj.imdg_spcl_provi_desc1.value=sheetObj.GetCellValue(Row,"imdg_spcl_provi_desc");
             formObj.rowNo.value=Row;
         }
      }
      
      function sheet1_OnSearchEnd(sheetObj,errMsg) {
    	  if(sheetObj.RowCount()>0){
    		  sheetObj.SelectCell(1, 3);
              sheet1_OnClick(sheetObj,1, 3);
    	  }
      }
      
    function descCopy(sheetObject)  {           
        var formObj=document.form;
        var rowNo=formObj.rowNo.value;
        if (rowNo != "") {
            sheetObject.SetCellValue(rowNo,"imdg_spcl_provi_desc",formObj.imdg_spcl_provi_desc1.value);
            descClear();
        }
     }
     function descClear()  {
        var formObj=document.form;
        formObj.rowNo.value="";
        formObj.imdg_spcl_provi_no2.value="";
        formObj.imdg_spcl_provi_desc1.value="";   
     }   
     
     // ::DG RailBilling 2015-12-03 ::
     function initConfig(){
    	 var formObj=document.form;
    	 
    	 if(preConds.pop_type=="R"){
    	 sheetObjects[0].SetColHidden("radio", 1);
    	 //sheetObjects[0].SetVisible(0);
   		 //sheetObjects[0].SetEditable(0);
   		 ComEnableObject(formObj.imdg_spcl_provi_no,false);
   		 ComEnableObject(formObj.imdg_spcl_provi_desc1,false);
   		 ComShowObject(formObj.btn_OK, false);
   		 ComShowObject(formObj.btn_Retrieve, false);
   		 ComShowObject(formObj.btn1_Excel, false);
   		 }
     }
