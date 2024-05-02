/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0109.js
*@FileTitle  : Location Query/POR/POL/POD/DEL(Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                 MODIFY=4; REMOVE=5; EMOVELIST=6 MULTI=7
                    OTHER CASE  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
    /**
     * tab1의 onChange Event handler processing
     * IBSheetConfig.js Event handler processing
     */
    function tab1_OnChange(nItem){
        ChangeTab(document.all.tab1,nItem);
    }
    /**
     * IBTab Object when clicked shows the contents of that tab
      */
    function ChangeTab(tabObj,nItem){
          tabObj.SetBackColor("#FFFFFF");
        //no support[check again]CLT tabObj.TabBackColor(nItem)="146,174,230";
        var objs=document.all.item("tabLayer");
        objs[beforetab].style.display="none";
        objs[nItem].style.display="Inline";
        //---------------  --------------------------//
        //objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        objs[beforetab].style.zIndex=0;
        objs[nItem].style.zIndex=9;
        //------------------------------------------------------//
        beforetab=nItem;
    }
    /**
     * registering IBSheet Object as list
     * ComSheetObject(id) Call
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
         var sheetObject=sheetObjects[0];
        var formObject=document.form;
      	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        //sheetObj.UseUtf8 = true;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
			             var HeadTitle="||No|Location|Name|Conti|Sub Conti|Region|Country|State|SCC|ECC|LCC|RCC|Control Office|Port" ;
			
			             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
			
			             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle, Align:"Center"} ];
			             InitHeaders(headers, info);
			
			             var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_state",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eq_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"loc_port_ind",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			              
			             InitColumns(cols);
			             SetSheetHeight(350);
			             SetEditable(1);
                      }


                break;
        }
    }
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */    
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                    // 
                    if(formObject.chk_port_ind.checked) {
                        formObject.loc_port_ind.value="Y";
                    } else {
                        formObject.loc_port_ind.value="N";
                    }
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;
                case "btn_close":
                	ComClosePopup(); 
        	        break;
        	    case "btn_ok":
        	    	// 
					//ComOpenPopupOK();
        	    	//comPopupOK(sheetObject,formObject);
        	    	
        	    	var locCd = "";
        	    	var checkRows = sheetObject.FindCheckedRow("check");
        	    	var arrRow = checkRows.split("|");
        	    	if(checkRows == ""||checkRows == null) {
        				ComShowMessage("선택된 값이 없습니다."); 
        				return;
        			}else{
        				locCd= sheetObject.GetCellValue(arrRow[0], "loc_cd")
        				parent.addLocCdNo(locCd);
        			}
//        	     	if (!opener) opener=parent; 
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
    /* handling sheet process */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:        
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCH;                
                selectVal=FormQueryString(formObj);
                iPageNo = 1;
                 sheetObj.DoSearch("ESD_SCE_0109GS.do", selectVal );
           break;
           case IBSEARCHAPPEND:  
                formObj.f_cmd.value=SEARCHLIST;  
                 sheetObj.DoSearch("ESD_SCE_0109GS.do", selectVal+"&"+ "iPage=" + PageNo, {Append:true} );
           break;
        }
    }

    var iPageNo = 1;
    function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
        if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
        doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
    }
     
     
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            /*if(formObj.cnt_cd.value == "") {
              ComShowMessage("You must input Country code");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value.length < 2) {
              ComShowMessage("Country code must be 2 characters");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value == "US" && formObj.loc_state.value == "") {
              ComShowMessage("You must input State");
              setFocus(formObj.loc_state);
              return false;
            }*/     
        }
        return true;
    }
     function sheet_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
    }
     

     



