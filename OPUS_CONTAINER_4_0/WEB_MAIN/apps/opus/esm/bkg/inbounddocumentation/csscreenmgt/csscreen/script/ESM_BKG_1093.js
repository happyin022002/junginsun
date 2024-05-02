/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1093.js
*@FileTitle  : Inbound C/S USA_Instruction Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // Common global variable    
    var sheetObjects=new Array();
    var sheetCnt=0;
    var iNodeCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function processButtonClick() {
        /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_close":
                	ComClosePopup(); 
                    break;
                case "btn_save":
                	doActionIBSheet(sheetObjects[0], document.form,IBSAVE);
                	break;
            }
    }
    /**
    * registering IBSheet Object as list<br>
    * adding process for list in case of needing batch processing with other items <br>
    * defining list on the top of source <br>
    * 
    * @param {IBSheet} sheet_obj mandatory, IBSheet control
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen. <br>
    * 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    /**
    * setting sheet initial values and header<br>
    * adding case as numbers of counting sheets <br>
    * 
    * @param {ibsheet} sheetObj mandatory, IBSheet Object
    * @param {number}  sheetNo mandatory, IBSheet Object serial number
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
	              var HeadTitle1="ibflag|instr_rmk_seq|cre_usr_id|usr_nm|bkg_no|upd_locl_dt|upd_locl_gdt|instr_rmk";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"instr_rmk_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_gdt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"instr_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(0);
	              SetVisible(0);
            }
                break;
        }
    }
    /**
    * Sheet handling process <br>
    * 
    * @param {ibsheet} sheetObj mandatory, IBSheet Object
    * @param {object}  formObj  mandatory, HTML Form Object
    * @param {string}  sAction  mandatory, Action Name 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH:      //Retrieve
            	if(!validateForm(sheetObj,formObj,sAction)) return;
                ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
                // (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])                	
             	sheetObj.DoSearch("ESM_BKG_1093GS.do", FormQueryString(formObj) );
            	ComOpenWait(false);
                break;
            case IBSAVE:   //Save
            	if(validateForm(sheetObj, formObj, sAction)){
	                formObj.f_cmd.value=MODIFY;
	                if( !ComShowCodeConfirm('COM12147') ){
	                    return false;
	                }
	                var param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&instr_rmk=" + formObj.instr_rmk.value;	                
 	                var sXml=sheetObj.GetSaveData("ESM_BKG_1093GS.do", param);
 	                sheetObj.LoadSaveData(sXml);
	                sXml=ComDeleteMsg(sXml);   
	                //sheetObjects["blIss"].LoadSaveXml(sXml);
	            }
            	break;                
            case IBDELETE:   //Delete
                formObj.f_cmd.value=REMOVE;
                if( !ComShowCodeConfirm('BKG00535') ){
                    return  false;
                }
                var param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&instr_rmk_seq=" + formObj.instr_rmk_seq.value;	                
                 var sXml=sheetObj.GetSaveData("ESM_BKG_1093GS.do", param);
                 sheetObj.LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);   
                //sheetObjects["blIss"].LoadSaveXml(sXml);
                break;                
        }
    }
    /**
    * handling process for input validation <br>
    * 
    * @param {ibsheet} sheetObj mandatory, IBSheet Object
    * @param {object}  formObj  mandatory, HTML Form Object
    * @param {string}  sAction  mandatory, Action Name 
    * @return boolean Form Returns whether the object is validated. (valid true -> true, valid false -> false)
    * @author 
    * @version 2009.07.09
    */
    function validateForm(sheetObj,formObj,sAction) {
    	if(sAction ==IBSEARCH){
            if (!ComChkValid(formObj)) return false;
        		with(formObj) {
            }
    	}else if(sAction ==IBSAVE){
        	// remark value check.
        	if(ComIsNull(document.form.instr_rmk)){
                ComShowCodeMessage('BKG00877'); 
                ComSetFocus(document.form.instr_rmk);
                return false;
            }
    	}        
        return true;
    }
    /**
     * Upon completion of sheet1 to set the value to lookup.
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg  Error Messages
     * @return void
     * @author
     * @version 2009.11.01
     **/
   function sheet1_OnSearchEnd(sheetObj, Code , ErrMsg){
       var blNo=null;
       if (ErrMsg == "") {
           if(sheetObj.RowCount()> 0){
        	   fnDispRemark(sheetObj);
           }
       }
   }    
     /**
      * post-processing to saved sheet1
      */
     function sheet1_OnSaveEnd(sheetObj, Code ,ErrMsg){
         if (iNodeCnt > 0) {
        	 fnRemoveNode(iNodeCnt);
         }
         document.form.instr_rmk.value="";
    	 doActionIBSheet(sheetObj, document.form,IBSEARCH);         
     }     
    function fnRemoveRemark(){
    	var basicDiv=document.getElementById("div1");
    	div.innerHTML="";
		basicDiv.appendChild(div);		
    }
    function fnDispRemark(sheetObj){
    	var basicDiv=document.getElementById("div1");
    	var strHead="<tr class='h23'> <td style='padding-left:3;' width='745px'> ";
    	var strBody="<input type='text' style='width:670px; ' class='noinput3' "; //body width modify 
    	var strButton="<td style='padding-left:1;' width='' class='stm' ";
    	var strDate="<td width='120px'><input type='text'";
    	var strName="<Td><input type='text' style='width:135px; ' class='noinput3' ";
    	var strSeq="<td width=''><input type='hidden'";
    	var strHtml="";
    	var nCount=sheetObj.RowCount();
    	var strRemark="";
    	var strInstrRmk="";
    	var strUpdLoclDt="";
    	var strInstrRmkSeq="";
    	var strUsrNm="";
    	var strCreUsrId="";
    	iNodeCnt=0;
    	for (var i=1; i <= nCount; i++) {
    		strUsrNm=sheetObj.GetCellValue(i,"usr_nm");
    		strInstrRmk=sheetObj.GetCellValue(i,"instr_rmk");
    		strUpdLoclDt=sheetObj.GetCellValue(i,"upd_locl_dt");
    		strInstrRmkSeq=sheetObj.GetCellValue(i,"instr_rmk_seq");
    		strCreUsrId=sheetObj.GetCellValue(i,"cre_usr_id");
    		strRemark=strInstrRmk;
    		var div=document.createElement("div");
    		if (strCreUsrId == strUsr_id) {
        		strHtml=strHead + 
        		          strBody + " name='txt_rmk"+i+"' id='txt_rmk"+i+"' value='" + strRemark + "' readonly='true'></td>" + 
        		          strDate + " name='txt_upd_locl_dt"+i+"' id='txt_upd_locl_dt"+i+"' align='top' style='width:110px;' class='noinput3' value='" + strUpdLoclDt + "' readonly='true'></td>" + 
        		          strName + " name='txt_usr_nm"+i+"' id='txt_usr_nm"+i+"' align='top' style='width:50px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strUsrNm + "' readonly='true'></td>" + 
                          strSeq + " name='instr_rmk_seq"+i+"' id='instr_rmk_seq"+i+"' style='width:0px;' class='input2' value='" + strInstrRmkSeq + "' readonly='true'></td>" +
                          "<td width='' class=''><button type='button'  class='btn_etc' name='btn_delete"+i+"' id='btn_delete"+i+"' OnClick='fnDeleteNode("+strInstrRmkSeq+")' align='absmiddle' >Delete</button></td> </tr>";
    		} else {
        		          strHtml=strHead + 
        		          strBody + " name='txt_rmk"+i+"' id='txt_rmk"+i+"' value='" + strRemark + "' readonly='true'></td>" + 
		                  strDate + " name='txt_upd_locl_dt"+i+"' id='txt_upd_locl_dt"+i+"' align='top' style='width:110px;' class='noinput3' value='" + strUpdLoclDt + "' readonly='true'></td>" + 
        		          strName + " name='txt_usr_nm"+i+"' id='txt_usr_nm"+i+"' align='top' style='width:120px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strUsrNm + "' readonly='true'></td>" + 
		                  strSeq + " name='instr_rmk_seq"+i+"' id='instr_rmk_seq"+i+"' style='width:0px;' class='input2' value='" + strInstrRmkSeq + "' readonly='true'></td> </tr>";
    		}
    		div.innerHTML=strHtml;
    		basicDiv.appendChild(div);  
    		iNodeCnt=iNodeCnt + 1;
    	}
    }    
    function fnRemoveNode(iCnt) {
    	var div=document.getElementById("div1");
        var reset_div=div.cloneNode(false);
        div.parentNode.replaceChild(reset_div, div);
    }
    function fnDeleteNode(iSeq) {

    	document.form.instr_rmk_seq.value=iSeq;
    	doActionIBSheet(sheetObjects[0], document.form, IBDELETE); 
    }
