// 공통전역변수
var selectVal = "" ;
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObj = sheetObjects[0];
    var formObj = document.form;

	try {
	    var srcName = window.event.srcElement.getAttribute("name");
        if(srcName != 'cntr_no'){
            formObj.cntr_no.value = toUpperCase(formObj.cntr_no.value);
        }

	    switch(srcName) {
	        case "btn_retrieve":
	           doActionIBSheet(sheetObj,formObj,IBSEARCH);
	        break;
	        case "btn_close":
	        	window.close();
		        break;
		        
	        case "btn_save":
	           if(sheetObj.CheckedRows("flag") > 0){
    	           if(sheetObj.CheckedRows("flag") == '2'){     //  2개 check 했을 경우
        	           var chkRow = sheetObj.FindCheckedRow("flag").split('|');
    	               var old_masterYN = formObj.masterYN.value.split(",");

                       if((sheetObj.CellValue(chkRow[0],"mst_lcl_cd") == 'P') || (sheetObj.CellValue(chkRow[1],"mst_lcl_cd") == 'P')){
        	               if((old_masterYN[chkRow[0]-2] == 'P') && (old_masterYN[chkRow[1]-2] == 'P')){     // old_masterYN 기존에 lcl_cd 값~~
                               doActionIBSheet(sheetObj,formObj,MODIFY);          // 'P','P'일 경우 ~~
        	               } else {
        	                   doActionIBSheet(sheetObj,formObj,IBSAVE);
        	               }
                       } else {
                           ComShowMessage('MST_LCL_CD have to P');
                       }
    	           } else if(sheetObj.CheckedRows("flag") == '1'){     //1개 만 check 했을 경우
    	               var chkRow = sheetObj.FindCheckedRow("flag").split('|');

                       if((sheetObj.CellValue(chkRow,"cop_sts_cd") == 'C') || (sheetObj.CellValue(chkRow,"cop_sts_cd") == 'T') ){
                           if(sheetObj.CellValue(chkRow,"mst_lcl_cd") == 'P'){     //  하나만 check 되고 'X' --> 'P'로 수정
                               formObj.old_cop_no.value = '';
                               formObj.new_cop_no.value = sheetObj.CellValue(chkRow, "cop_no");
                               formObj.bkg_no.value = sheetObj.CellValue(chkRow, "bkg_no");                               
                                                              
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
	               ComShowMessage("Please select two item");
	           }
           
	        break;
	    }
	    
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
		}
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
        ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
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
	    case 1:	  
	       with (sheetObj) {
              style.height = GetSheetHeight(10);
              SheetWidth = mainTable.clientWidth;       
              
              if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

              MergeSheet = msHeaderOnly;
              Editable = true;
              InitRowInfo( 2, 1, 9, 100);
              
              InitColumnInfo(26, 9, 0, true);
              //InitHeadMode(false, true, false, true, false, false);
			  InitHeadMode(true, true, true, true, false,false);              
              
              var HeadTitle0 = "|MST_\nLCL_CD|CNTR_NO|CNTR_\nTPSZ_CD|CNMV_YR|CNMV_\nSEQ|BKG No.|COP_\nSTS_CD|CNTR_\nVOL_QTY|COP_NO|PCTL_NO|POL_CD|POD_CD|POR_CD|DEL_CD|TRNK_\nVSL_CD|TRNK_SKD_\nVOY_NO|TRNK_SKD_\nDIR_CD|DG_\nSPCL_FLG|RF_\nSPCL_FLG|SPCL_\nAWK_CGO_FLG|BB_\nSPCL_FLG|RD_\nSPCL_FLG|HNGR_\nSPCL_FLG|SOC_FLG" ;
			  var HeadTitle1 = "|MST_\nLCL_CD|CNTR_NO|CNTR_\nTPSZ_CD|CNMV_YR|CNMV_\nSEQ|BKG No.|COP_\nSTS_CD|CNTR_\nVOL_QTY|COP_NO|PCTL_NO|POL_CD|POD_CD|POR_CD|DEL_CD|TRNK_\nVSL_CD|TRNK_SKD_\nVOY_NO|TRNK_SKD_\nDIR_CD|DG_\nSPCL_FLG|RF_\nSPCL_FLG|SPCL_\nAWK_CGO_FLG|BB_\nSPCL_FLG|RD_\nSPCL_FLG|HNGR_\nSPCL_FLG|SOC_FLG" ;

              InitHeadRow(0, HeadTitle0, true);
			  InitHeadRow(1, HeadTitle1, true);
              
              InitDataProperty(0, cnt++ , dtCheckBox,  	20,		daCenter,	true,	"flag",				false,		  "",	   dfNone,   	0,	 		true ,	   true );
//			  InitDataProperty(0, cnt++ , dtData,		70,	    daCenter,	true,	"mst_lcl_cd",		false,		  "",	   dfNone,   	0,	 		true,	   true );
              InitDataProperty(0, cnt++ , dtCombo,		70,	    daCenter,	true,	"mst_lcl_cd",		false,		  "",	   dfNone,   	0,	 		true,	   true );
			  InitDataProperty(0, cnt++ , dtData,	   	90,		daCenter,	true,	"cntr_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,	   	70,		daCenter,	true,	"cntr_tpsz_cd",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		60,	    daCenter,	true,	"cnmv_yr",			false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,	  	60,		daCenter,	true,	"cnmv_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,	  	90,		daCenter,	true,	"bkg_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  //InitDataProperty(0, cnt++ , dtData,	   	45,		daCenter,	true,	"bkg_no_split",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"cop_sts_cd",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		60,	    daCenter,	true,	"cntr_vol_qty",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,	   100,		daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,	   130,		daCenter,	true,	"pctl_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  //InitDataProperty(0, cnt++ , dtData,	   130,		daCenter,	true,	"ob_pctl_no",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  //InitDataProperty(0, cnt++ , dtData,	   130,		daCenter,	true,	"ib_pctl_no",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"pol_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		80,	    daCenter,	true,	"pod_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		80,	    daCenter,	true,	"por_cd",		    false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		80,	    daCenter,	true,	"del_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"trnk_vsl_cd",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"trnk_skd_voy_no",	false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"trnk_skd_dir_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);			  			  
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"dg_spcl_flg",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"rf_spcl_flg",		false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"spcl_awk_cgo_flg",	false,		  "",	   dfNone,   	0,	 		false,	   false);
			  InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"bb_spcl_flg",		false,		  "",	   dfNone,   	0,	 		false,	   false);
	   		  InitDataProperty(0, cnt++ , dtData,		70,	    daCenter,	true,	"rd_spcl_flg",		false,		  "",	   dfNone,   	0,	 		false,	   false);
  			  InitDataProperty(0, cnt++ , dtData,		70,	    daCenter,	true,	"hngr_spcl_flg",	false,		  "",	   dfNone,   	0,	 		false,	   false);
  			  InitDataProperty(0, cnt++ , dtData,		10,	    daCenter,	true,	"soc_flg",		    false,		  "",	   dfNone,   	0,	 		false,	   false);
  			  InitDataProperty(0, cnt++ , dtHidden,		10,	    daCenter,	true,	"bkg_sts_cd",	    false,		  "",	   dfNone,   	0,	 		false,	   false);  			  
  			  
			  style.height = GetSheetHeight(22) ;
			  
			  InitDataCombo(0, 'mst_lcl_cd', 'Master|Slave', 'P|X');
	       }
	       break;
	}
}
 
function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     isSearch = true;
     
     switch(sAction) {
         case IBSEARCH:     
            if(validateForm(formObj)){
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_SCE_0118GS.do", SceFrmQryString(formObj));
                saveArrMNS(sheetObj,formObj);
            } else {
                isSearch = false;
            }
         break;
         
         case IBSAVE:
            if(validateFormSave(sheetObj,formObj)){
                if( confirm("Are you sure you want to proceed?") ) {
                    formObj.f_cmd.value = SEARCHLIST01;                                         // S/O 유무 확인~~~
                    sheetObj.DoSearch4Post("ESD_SCE_0118GS.do", SceFrmQryString(formObj)); 
                    saveArrMNS(sheetObj,formObj);
                }
            }
         break;
         
         case IBINSERT:
             if( confirm("Are you sure you want to proceed?") ) {
                   formObj.f_cmd.value = MODIFY01;
                   sheetObj.DoSearch4Post("ESD_SCE_0118GS.do", SceFrmQryString(formObj));
                   saveArrMNS(sheetObj,formObj);
             }
         break;
         
         case MODIFY:
            if(validateFormModify(sheetObj,formObj)){    // 'P','P' 일경우~~
                if( confirm("Are you sure you want to proceed?") ) {
                    formObj.f_cmd.value = SEARCHLIST01;                                         // S/O 유무 확인~~~
                    sheetObj.DoSearch4Post("ESD_SCE_0118GS.do", SceFrmQryString(formObj)); 
                    saveArrMNS(sheetObj,formObj);
                }
            }
         break;
     }
}
 
function validateForm(formObj){
    var result = false ;
    if(!ComIsEmpty(formObj.cntr_no)){
        result = true ;
    } else {
        ComShowMessage("Please, Insert Container Number");
        result = false;
    }
    return result;
}
 
 
function validateFormSave(sheetObj,formObj){
    var SResult = false;
    var rowCnt = sheetObj.CheckedRows(0);
    var chkRows = sheetObj.FindCheckedRow(0) ;
    var arrChkRows = chkRows.split("|") ;

    // 원래의 mst_lcl_cd 값을 가져온다.
    var arrMasterSalve = formObj.masterYN.value.split(",");
    var vvd1 = "";
    var tempVslCd1 = "";
    var tempVoyCd1 = "";
    var tempDirCd1 = "";
    var tempPolCd1 = "";
    var tempMstLclCd1 = "";
    var tempCopNo = "";
    var vvd2 = "";
    var tempVslCd2 = "";
    var tempVoyCd2 = "";
    var tempDirCd2 = "";
    var tempPolCd2 = "";
    var tempMstLclCd2 = "";

    for(var i = 0; i < rowCnt; i++){
        if(i == 0){
            tempVslCd1 = sheetObj.CellValue(arrChkRows[i], "trnk_vsl_cd");
            tempVoyCd1 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_voy_no");
            tempDirCd1 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_dir_cd");
            tempPolCd1 = sheetObj.CellValue(arrChkRows[i], "pol_cd"); 
            tempMstLclCd1 = sheetObj.CellValue(arrChkRows[i], "mst_lcl_cd"); 
            vvd1 = tempVslCd1+""+tempVoyCd1+""+tempDirCd1;
            if(arrMasterSalve[arrChkRows[i] - 2] == 'P') {                       // 처음에 Master/Salve인지 구분
                formObj.old_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no"); 
            }

            if(tempMstLclCd1 == 'P'){
                formObj.new_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                   // Master 쪽 COP_NO 값이다.
                formObj.bkg_no.value = sheetObj.CellValue(arrChkRows[i], "bkg_no"); 
                //formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
                formObj.cop_no_slave.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                 // Slave 쪽 COP_NO 값이다.
            }
        } else if(i == 1){
            tempVslCd2 = sheetObj.CellValue(arrChkRows[i], "trnk_vsl_cd");
            tempVoyCd2 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_voy_no");
            tempDirCd2 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_dir_cd");
            tempPolCd2 = sheetObj.CellValue(arrChkRows[i], "pol_cd");
            tempMstLclCd2 = sheetObj.CellValue(arrChkRows[i], "mst_lcl_cd"); 
            vvd2 = tempVslCd2+""+tempVoyCd2+""+tempDirCd2;
            if(arrMasterSalve[arrChkRows[i] - 2] == 'P') {
                formObj.old_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no"); 
            }
            if(tempMstLclCd2 == 'P'){
                formObj.new_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                   // Master 쪽 COP_NO 값이다.
                formObj.bkg_no.value = sheetObj.CellValue(arrChkRows[i], "bkg_no"); 
               // formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
                formObj.cop_no_slave.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                // Slave 쪽 COP_NO 값이다.
            }
        }
    }
 
 
    // vvd 와 pol 값이 같아야 한다.
    if((vvd1 == vvd2) && (tempPolCd1 == tempPolCd2)){
        if(tempMstLclCd1 == 'P' || tempMstLclCd2 == 'P'){
           SResult = true;
        } else {
           SResult = false;
           ComShowMessage('The Choosed item need to have at least Master');
        }
    } else {
        SResult = false;
        ComShowMessage('The Choosed item have to be VVD/POL same');
    }
    return SResult;
}

function validateFormModify(sheetObj,formObj){
    var MResult = false;
    
    var rowCnt = sheetObj.CheckedRows(0);
    var chkRows = sheetObj.FindCheckedRow(0) ;
    var arrChkRows = chkRows.split("|") ;
    
    var vvd1 = "";
    var tempVslCd1 = "";
    var tempVoyCd1 = "";
    var tempDirCd1 = "";
    var tempPolCd1 = "";
    var tempMstLclCd1 = "";
    
    var vvd2 = "";
    var tempVslCd2 = "";
    var tempVoyCd2 = "";
    var tempDirCd2 = "";
    var tempPolCd2 = "";
    var tempMstLclCd2 = "";
    
    for(var i = 0; i < rowCnt; i++){
        if(i == 0){
            tempVslCd1 = sheetObj.CellValue(arrChkRows[i], "trnk_vsl_cd");
            tempVoyCd1 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_voy_no");
            tempDirCd1 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_dir_cd");
            tempPolCd1 = sheetObj.CellValue(arrChkRows[i], "pol_cd"); 
            tempMstLclCd1 = sheetObj.CellValue(arrChkRows[i], "mst_lcl_cd"); 
            vvd1 = tempVslCd1+""+tempVoyCd1+""+tempDirCd1;
            
            if(tempMstLclCd1 == 'P'){
                formObj.new_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                   // Master 쪽 COP_NO 값이다.
                formObj.bkg_no.value = sheetObj.CellValue(arrChkRows[i], "bkg_no"); 
                //formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
                formObj.cop_no_slave.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                // Slave 쪽 COP_NO 값이다.
                formObj.old_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no"); 
            }
        } else if(i == 1){
            tempVslCd2 = sheetObj.CellValue(arrChkRows[i], "trnk_vsl_cd");
            tempVoyCd2 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_voy_no");
            tempDirCd2 = sheetObj.CellValue(arrChkRows[i], "trnk_skd_dir_cd");
            tempPolCd2 = sheetObj.CellValue(arrChkRows[i], "pol_cd");
            tempMstLclCd2 = sheetObj.CellValue(arrChkRows[i], "mst_lcl_cd"); 
            vvd2 = tempVslCd2+""+tempVoyCd2+""+tempDirCd2;
            
            if(tempMstLclCd2 == 'P'){
                formObj.new_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                   // Master 쪽 COP_NO 값이다.
                formObj.bkg_no.value = sheetObj.CellValue(arrChkRows[i], "bkg_no"); 
                //formObj.bkg_split.value = sheetObj.CellValue(arrChkRows[i], "bkg_no_split"); 
            } else {
                formObj.cop_no_slave.value = sheetObj.CellValue(arrChkRows[i], "cop_no");                // Slave 쪽 COP_NO 값이다.
                formObj.old_cop_no.value = sheetObj.CellValue(arrChkRows[i], "cop_no"); 
            }
        }
    }

    // vvd 와 pol 값이 같아야 한다.
    if((vvd1 == vvd2) && (tempPolCd1 == tempPolCd2)){
        if(tempMstLclCd1 != tempMstLclCd2 ){
           MResult = true;
        } else {
           MResult = false;
           ComShowMessage('The Choosed item need to have at least Master');
        }
    } else {
        MResult = false;
        ComShowMessage('The Choosed item have to be VVD/POL same');
    }
    
    return MResult;
}

function saveArrMNS(sheetObj,formObj){
    var rowCnt = sheetObj.RowCount;
    var copNoS = "";
    var masterYN = "";
    var bkg_no = "";
    //var bkg_split = "";
    
    for(var t = 1; t <= rowCnt; t++){
        if(t == 1){
            copNoS = sheetObj.CellValue(t+1, "cop_no");
            masterYN = sheetObj.CellValue(t+1, "mst_lcl_cd"); 
            bkg_no = sheetObj.CellValue(t+1, "bkg_no"); 
            //bkg_split = sheetObj.CellValue(t+1, "bkg_no_split"); 
        } else {
            copNoS = copNoS+","+sheetObj.CellValue(t+1, "cop_no");
            masterYN = masterYN+","+sheetObj.CellValue(t+1, "mst_lcl_cd"); 
            bkg_no = bkg_no+","+sheetObj.CellValue(t+1, "bkg_no"); 
           // bkg_split = bkg_split+","+sheetObj.CellValue(t+1, "bkg_no_split"); 
        }
    }
    formObj.masterYN.value = masterYN;
}
 
 
function toUpperCase(str_){
    str="";
    for(i=0;i<str_.length;i++){
        str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
    }  
    return str;      
}
 
function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj = document.form;
		textname.value = textname.value.toUpperCase();
		var sheetObj = sheetObjects[0];
		if( validateForm(formObj) ) {
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
}
