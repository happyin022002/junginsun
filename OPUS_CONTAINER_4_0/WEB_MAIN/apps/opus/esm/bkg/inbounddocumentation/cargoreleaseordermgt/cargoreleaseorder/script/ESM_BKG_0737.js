/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0737.js
*@FileTitle  : eDO Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class esm_bkg_0737 : business script for esm_bkg_0737
     */
    function esm_bkg_0737() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
             var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_submit":
                    checkBoxDataSet();
                    doActionIBSheet(sheetObject1,document.form,MULTI01);
                    break;
                case "btn_close":
                	ComClosePopup(); 
                break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
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
        var edoRqstStsArray=new Array();
        var arrParam=document.getElementById("h_approvals").value.substring(0,document.getElementById("h_approvals").value.lastIndexOf(";"));
        edoRqstStsArray=arrParam.split(";");
        if(edoRqstStsArray[0] == 'T'){
            document.getElementsByName("rdo_5JN")[0].checked=true;
            for(var idx=0; idx < document.getElementsByName("rdo_5JN").length; idx++){
                document.getElementsByName("rdo_5JN")[idx].disabled=false;
            }
        }
        if(edoRqstStsArray[1] == 'T'){
            document.getElementsByName("rdo_5JM")[0].checked=true;
            for(var idx=0; idx < document.getElementsByName("rdo_5JM").length; idx++){
                document.getElementsByName("rdo_5JM")[idx].disabled=false;
            }
        }
        if(edoRqstStsArray[2] == 'T'){
            document.getElementsByName("rdo_5JK")[0].checked=true;
            for(var idx=0; idx < document.getElementsByName("rdo_5JK").length; idx++){
                document.getElementsByName("rdo_5JK")[idx].disabled=false;
            }
        }
        var edoTpCds=new Array("5JN","5JM","5JK");
        for(var idx=1; idx <4; idx++ ){
            var j=sheetObjects[0].DataInsert(-1);
            sheetObjects[0].SetCellValue(j, "edo_tp_cd",edoTpCds[idx-1]);
            sheetObjects[0].SetCellValue(j, "edo_ack_cd",'N');
            sheetObjects[0].SetCellValue(j, "rqst_no",document.getElementById("rqst_no").value);
            sheetObjects[0].SetCellValue(j, "bkg_no",document.getElementById("bkg_no").value);
        }
    }
    //Axon event handling
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with(sheetObj){
	              var HeadTitle1=" |edo_tp_cd|edo_ack_cd|rej_rmk|rqst_no|bkg_no";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"edo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"edo_ack_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rej_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rqst_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(0);
	              SetCountPosition(0);
	              SetVisible(0);
	              }	
                  break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
    	if (!opener) opener=window.dialogArguments;
        if(!opener) opener=parent;
        
        switch(sAction) {
            case MULTI01:
                //checking MRN NO and MSN NO
                if(document.getElementById("mrn_no").value =='' || document.getElementById("msn_no").value ==''){
                    ComShowCodeMessage("BKG40093");
                    //Unable to Send without MRN, MSN No.
                    return;
                }
                if(document.getElementById("h_last_rlse_sts_cd").value !='R' && document.getElementsByName("rdo_5JN")[1].checked){
                    ComShowCodeMessage("BKG40081");
                    return;
                }
                if(document.form.de_term_desc.value =='Door' && 
                   document.form.pod_cd.value != document.form.del_cd.value && 
                   document.form.rdo_5JM[1].checked ){   
                	 if(!ComShowCodeConfirm('BKG43033')){
                         return false;
                     }
                }
                var cnt=0;
                for(var idx=1; idx <= sheetObjects[0].RowCount(); idx++){
                	if(sheetObjects[0].GetCellValue(idx, "edo_ack_cd") == 'N'){
                        cnt ++;
                    }
                }
                if(cnt == 3){
                    ComShowCodeMessage("BKG40082");
                    return;
                }
                if(document.form.self_trans_chk_flg.value == 'Y'){
                	opener.pressSelfTransToTMNL('ES');
                }
                if( !ComShowCodeConfirm('BKG00447') ){
                    return false;
                }
                formObj.f_cmd.value=MULTI01;
                sheetObj.DoSave("ESM_BKG_0737GS.do", FormQueryString(formObj),-1,0);
            break;
        }
    }
   /**
    * in case of clicking radio button
    */
    function TransmitDataSet(edoAckCd){
        switch(event.srcElement.name){
            case 'rdo_5JN' :
                idx=1;
                break ;
            case 'rdo_5JM' :
                idx=2;
                break ;
            case 'rdo_5JK' :
                idx=3;
                break ;
            default :
                break ;
        }//end switch
        if( edoAckCd =='R' || edoAckCd =='P' ){  
            document.all.rej_rmk[idx-1].readOnly=false
            document.all.rej_rmk[idx-1].className="input";
        }else{
            document.all.rej_rmk[idx-1].readOnly=true
            document.all.rej_rmk[idx-1].className="input2";
            document.all.rej_rmk[idx-1].value="";
            sheetObjects[0].SetCellValue(idx, "rej_rmk","");
        }
        if(idx==2 && edoAckCd =='A'){ 
            document.form.self_trans_chk_flg.value='Y';
        }        
        sheetObjects[0].SetCellValue(idx, "edo_ack_cd",edoAckCd);
        sheetObjects[0].SetCellValue(idx, "rej_rmk",document.getElementsByName("rej_rmk")[parseInt(idx-1)].value);
    }
    /**
     * setting inserted hold content at sheet
     */
    function rejRmkDataSet(idx){
        sheetObjects[0].SetCellValue(idx, "rej_rmk",document.getElementsByName("rej_rmk")[idx-1].value);
    }
    /**
     * setting eDO Transmit result at hidden column
     */
    function checkBoxDataSet(){
    	var str=sheetObjects[0].GetCellValue(1, "edo_ack_cd")+','+sheetObjects[0].GetCellValue(2, "edo_ack_cd")+','+sheetObjects[0].GetCellValue(3, "edo_ack_cd");
        document.getElementById("edo_ack_cd_arr").value=str;
    }
    /**
     * process list after save sheet1 : return eDO Transmit result at parents window
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (!opener) opener=window.dialogArguments;
        if(!opener) opener=parent;
    	opener.edoCheckBoxColorSet(document.getElementById("edo_ack_cd_arr").value);
    	ComClosePopup(); 
    }  
