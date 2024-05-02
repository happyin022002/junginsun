/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0118.jsp
*@FileTitle  : COP Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
// Global variable
var selectVal="" ;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
	try {
	    var srcName=ComGetEvent("name");
        if(srcName != 'cntr_no'){
            formObj.cntr_no.value=toUpperCase(formObj.cntr_no.value);
        }
	    switch(srcName) {
	        case "btn_retrieve":
	           doActionIBSheet(sheetObj,formObj,IBSEARCH);
	        break;
	        case "btn_close":
	        	ComClosePopup(); 
		        break;
	        case "btn_save":
	           if(sheetObj.CheckedRows("flag") > 0){
    	           if(sheetObj.CheckedRows("flag") == '2'){     //  checking in case over two.
        	           var chkRow=sheetObj.FindCheckedRow("flag").split('|');
    	               var old_masterYN=formObj.masterYN.value.split(",");
    	               if((sheetObj.GetCellValue(chkRow[0],"mst_lcl_cd") == 'P') || (sheetObj.GetCellValue(chkRow[1],"mst_lcl_cd") == 'P')){
        	               if((old_masterYN[chkRow[0]-2] == 'P') && (old_masterYN[chkRow[1]-2] == 'P')){     
                               doActionIBSheet(sheetObj,formObj,MODIFY);          
        	               } else {
        	                   doActionIBSheet(sheetObj,formObj,IBSAVE);
        	               }
                       } else {
                           ComShowMessage('MST_LCL_CD have to P');
                       }
    	           } else if(sheetObj.CheckedRows("flag") == '1'){     //only checked
    	               var chkRow=sheetObj.FindCheckedRow("flag").split('|');
    	               if((sheetObj.GetCellValue(chkRow,"cop_sts_cd") == 'C') || (sheetObj.GetCellValue(chkRow,"cop_sts_cd") == 'T') ){
    	            	   if(sheetObj.GetCellValue(chkRow,"mst_lcl_cd") == 'P'){
                               formObj.old_cop_no.value='';
                               formObj.new_cop_no.value=sheetObj.GetCellValue(chkRow, "cop_no");
                               formObj.bkg_no.value=sheetObj.GetCellValue(chkRow, "bkg_no");
                               doActionIBSheet(sheetObj,formObj,IBINSERT);
                           } else {
                               ComShowMessage('MST_LCL_CD have to P');
                           }
                       } else {
                           ComShowMessage('COP_STS have to C,T');
                       }
	               } else {    
    	               ComShowMessage('Please select two item');
    	           }
	           } else {
	               ComShowMessage("Please select item");
	           }
	        break;
	    }
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	switch(sheetNo) {
	    case 1:	  
	       with (sheetObj) {
            var HeadTitle0="|Master|Container\n No.|TP/SZ|CNMV\n Year|CNMV\nSeq.|BKG No.|COP\n Status|Vol|COP No.|PCTL No.|POL|POD|POR|DEL|Trnk\n Vsl.|Trnk Skd\n Voyage No.|Trnk Skd \nDir|DG Spcl Flg|RF Spcl Flg|SPCL\nAWK CGO Flg|BB SPCL\n Flg|RD SPCL\n Flg|HNGR SPCL\n Flg|SOC Flg" ;
            var HeadTitle1="|Master|Container\n No.|TP/SZ|CNMV\n Year|CNMV\nSeq.|BKG No.|COP\n Status|Vol|COP No.|PCTL No.|POL|POD|POR|DEL|Trnk\n Vsl.|Trnk Skd\n Voyage No.|Trnk Skd \nDir|DG Spcl Flg|RF Spcl Flg|SPCL\nAWK CGO Flg|BB SPCL\n Flg|RD SPCL\n Flg|HNGR SPCL\n Flg|SOC Flg" ;

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"},
                      { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mst_lcl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cop_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"pctl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_spcl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_spcl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"spcl_awk_cgo_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb_spcl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rd_spcl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"hngr_spcl_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);

            SetEditable(1);
            SetColProperty('mst_lcl_cd', {ComboText:'Master|Slave', ComboCode:'P|X'} );
//            SetSheetHeight(420);
            resizeSheet();
	       }
	       break;
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     isSearch=true;
     switch(sAction) {
         case IBSEARCH:     
            if(validateForm(formObj)){
                formObj.f_cmd.value=SEARCHLIST;
                sheetObj.DoSearch("ESD_SCE_0118GS.do", SceFrmQryString(formObj), { Sync : 2 } );
                saveArrMNS(sheetObj, formObj);
            } else {
                isSearch=false;
            }
         break;
         case IBSAVE:
            if(validateFormSave(sheetObj,formObj)){
                if( confirm("Are you sure you want to proceed?") ) {
                    formObj.f_cmd.value=SEARCHLIST01;                                         
                    sheetObj.DoSearch("ESD_SCE_0118GS.do", SceFrmQryString(formObj) , { Sync : 2 } );
                    saveArrMNS(sheetObj,formObj);
                }
            }
         break;
         case IBINSERT:
             if( confirm("Are you sure you want to proceed?") ) {
                   formObj.f_cmd.value=MODIFY01;
                   sheetObj.DoSearch("ESD_SCE_0118GS.do", SceFrmQryString(formObj), { Sync : 2 }  );
                   saveArrMNS(sheetObj,formObj);
             }
         break;
         case MODIFY:
            if(validateFormModify(sheetObj,formObj)){    // 'P','P' 일경우~~
                if( confirm("Are you sure you want to proceed?") ) {
                    formObj.f_cmd.value=SEARCHLIST01;                                        
                    sheetObj.DoSearch("ESD_SCE_0118GS.do", SceFrmQryString(formObj) );
                    saveArrMNS(sheetObj,formObj);
                }
            }
         break;
     }
}
function validateForm(formObj){
    var result=false ;
    if(!ComIsEmpty(formObj.cntr_no)){
        result=true ;
    } else {
        ComShowMessage("Please, Insert Container Number");
        result=false;
    }
    return result;
}
function validateFormSave(sheetObj,formObj){
    var SResult=false;
    var rowCnt=sheetObj.CheckedRows(0);
    var chkRows=sheetObj.FindCheckedRow(0) ;
    var arrChkRows=chkRows.split("|") ;
    // retrieving mst_lcl_cd
    var arrMasterSalve=formObj.masterYN.value.split(",");
    var vvd1="";
    var tempVslCd1="";
    var tempVoyCd1="";
    var tempDirCd1="";
    var tempPolCd1="";
    var tempMstLclCd1="";
    var tempCopNo="";
    var vvd2="";
    var tempVslCd2="";
    var tempVoyCd2="";
    var tempDirCd2="";
    var tempPolCd2="";
    var tempMstLclCd2="";
    for(var i=0; i < rowCnt; i++){
        if(i == 0){
			tempVslCd1=sheetObj.GetCellValue(arrChkRows[i], "trnk_vsl_cd");
			tempVoyCd1=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_voy_no");
			tempDirCd1=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_dir_cd");
			tempPolCd1=sheetObj.GetCellValue(arrChkRows[i], "pol_cd");
			tempMstLclCd1=sheetObj.GetCellValue(arrChkRows[i], "mst_lcl_cd");
            vvd1=tempVslCd1+""+tempVoyCd1+""+tempDirCd1;
            if(arrMasterSalve[arrChkRows[i] - 2] == 'P') {                       
            	formObj.old_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
            }
            if(tempMstLclCd1 != 'P'){
				formObj.new_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
				formObj.bkg_no.value=sheetObj.GetCellValue(arrChkRows[i], "bkg_no");
                //formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
            	formObj.cop_no_slave.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
            }
        } else if(i == 1){
			tempVslCd2=sheetObj.GetCellValue(arrChkRows[i], "trnk_vsl_cd");
			tempVoyCd2=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_voy_no");
			tempDirCd2=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_dir_cd");
			tempPolCd2=sheetObj.GetCellValue(arrChkRows[i], "pol_cd");
			tempMstLclCd2=sheetObj.GetCellValue(arrChkRows[i], "mst_lcl_cd");
            vvd2=tempVslCd2+""+tempVoyCd2+""+tempDirCd2;
            if(arrMasterSalve[arrChkRows[i] - 2] == 'P') {
            	formObj.old_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
            }
            if(tempMstLclCd2 != 'P'){
				formObj.new_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
				formObj.bkg_no.value=sheetObj.GetCellValue(arrChkRows[i], "bkg_no");
               // formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
            	formObj.cop_no_slave.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
            }
        }
    }
    if((vvd1 == vvd2) && (tempPolCd1 == tempPolCd2)){
        if(tempMstLclCd1 == 'P' || tempMstLclCd2 == 'P'){
           SResult=true;
        } else {
           SResult=false;
           ComShowMessage('The Choosed item need to have at least Master');
        }
    } else {
        SResult=false;
        ComShowMessage('The Choosed item have to be VVD/POL same');
    }
    return SResult;
}
function validateFormModify(sheetObj,formObj){
    var MResult=false;
    var rowCnt=sheetObj.CheckedRows(0);
    var chkRows=sheetObj.FindCheckedRow(0) ;
    var arrChkRows=chkRows.split("|") ;
    var vvd1="";
    var tempVslCd1="";
    var tempVoyCd1="";
    var tempDirCd1="";
    var tempPolCd1="";
    var tempMstLclCd1="";
    var vvd2="";
    var tempVslCd2="";
    var tempVoyCd2="";
    var tempDirCd2="";
    var tempPolCd2="";
    var tempMstLclCd2="";
    for(var i=0; i < rowCnt; i++){
        if(i == 0){
			tempVslCd1=sheetObj.GetCellValue(arrChkRows[i], "trnk_vsl_cd");
			tempVoyCd1=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_voy_no");
			tempDirCd1=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_dir_cd");
			tempPolCd1=sheetObj.GetCellValue(arrChkRows[i], "pol_cd");
			tempMstLclCd1=sheetObj.GetCellValue(arrChkRows[i], "mst_lcl_cd");
            vvd1=tempVslCd1+""+tempVoyCd1+""+tempDirCd1;
            if(tempMstLclCd1 == 'P'){
				formObj.new_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
				formObj.bkg_no.value=sheetObj.GetCellValue(arrChkRows[i], "bkg_no");
                //formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
				formObj.cop_no_slave.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
				formObj.old_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
            }
        } else if(i == 1){
			tempVslCd2=sheetObj.GetCellValue(arrChkRows[i], "trnk_vsl_cd");
			tempVoyCd2=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_voy_no");
			tempDirCd2=sheetObj.GetCellValue(arrChkRows[i], "trnk_skd_dir_cd");
			tempPolCd2=sheetObj.GetCellValue(arrChkRows[i], "pol_cd");
			tempMstLclCd2=sheetObj.GetCellValue(arrChkRows[i], "mst_lcl_cd");
            vvd2=tempVslCd2+""+tempVoyCd2+""+tempDirCd2;
            if(tempMstLclCd2 == 'P'){
				formObj.new_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
				formObj.bkg_no.value=sheetObj.GetCellValue(arrChkRows[i], "bkg_no");
                //formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
				formObj.cop_no_slave.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
				formObj.old_cop_no.value=sheetObj.GetCellValue(arrChkRows[i], "cop_no");
            }
        }
    }
    if((vvd1 == vvd2) && (tempPolCd1 == tempPolCd2)){
        if(tempMstLclCd1 != tempMstLclCd2 ){
           MResult=true;
        } else {
           MResult=false;
           ComShowMessage('The Choosed item need to have at least Master');
        }
    } else {
        MResult=false;
        ComShowMessage('The Choosed item have to be VVD/POL same');
    }
    return MResult;
}
function saveArrMNS(sheetObj,formObj){
    var rowCnt=sheetObj.RowCount();
    var copNoS="";
    var masterYN="";
    var bkg_no="";
    //var bkg_split = "";
    for(var t=1; t <= rowCnt; t++){
        if(t == 1){
			copNoS=sheetObj.GetCellValue(t+1, "cop_no");
			masterYN=sheetObj.GetCellValue(t+1, "mst_lcl_cd");
			bkg_no=sheetObj.GetCellValue(t+1, "bkg_no");
            //bkg_split = sheetObj.CellValue(t+1, "bkg_no_split"); 
        } else {
			copNoS=copNoS+","+sheetObj.GetCellValue(t+1, "cop_no");
			masterYN=masterYN+","+sheetObj.GetCellValue(t+1, "mst_lcl_cd");
			bkg_no=bkg_no+","+sheetObj.GetCellValue(t+1, "bkg_no");
           // bkg_split = bkg_split+","+sheetObj.CellValue(t+1, "bkg_no_split"); 
        }
    }
    formObj.masterYN.value=masterYN;
}
function toUpperCase(str_){
    str="";
    for(i=0;i<str_.length;i++){
        str+=str_.charAt(i).toUpperCase(); //changing to upper character
    }  
    return str;      
}
function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj=document.form;
		textname.value=textname.value.toUpperCase();
		var sheetObj=sheetObjects[0];
		if( validateForm(formObj) ) {
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
}