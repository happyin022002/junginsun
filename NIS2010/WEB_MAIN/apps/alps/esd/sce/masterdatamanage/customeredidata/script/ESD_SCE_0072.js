﻿// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var isSearch = false;

var selRow = 0;
var isFirst1 = 0;
var isFirst2 = 0;
var sheet1Cols = 0;

// 공통전역변수
var pageNo =1 ;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObj = sheetObjects[0];
    	/*******************************************************/
    	var formObj = document.form;

    	try{
    	    var srcName = window.event.srcElement.getAttribute("name");

    	    formObj.pol.value = toUpperCase(formObj.pol.value);
            formObj.pod.value = toUpperCase(formObj.pod.value);
            formObj.vvd.value = toUpperCase(formObj.vvd.value);
            formObj.del.value = toUpperCase(formObj.del.value);
            formObj.por.value = toUpperCase(formObj.por.value);
            formObj.edi_sts_con.value = toUpperCase(formObj.edi_sts_con.value);
            formObj.bkg_no.value = toUpperCase(formObj.bkg_no.value);
            formObj.bl_no.value = toUpperCase(formObj.bl_no.value);
            formObj.cntr_no.value = toUpperCase(formObj.cntr_no.value);

    	    switch(srcName){
    	        case "btn_retrieve":
    	    
    	           var arr_bkg_no = formObj.bkg_no.value.split(",");
       	           var arr_bl_no = formObj.bl_no.value.split(",");
       	           var arr_cntr_no = formObj.cntr_no.value.split(",");
       	           var arr_vvd = formObj.vvd.value.split(",");

                   if(arr_bkg_no.length < 100 && arr_bl_no.length < 100 && arr_cntr_no.length < 100 && arr_vvd.length < 100){
                       doActionIBSheet(sheetObj,formObj,IBSEARCH);
                   } else {
                       ComShowMessage('Bkg_NO/Bl_NO/Cntr_NO/VVD is limited to 100');
                   }
    	           break;
    	        case "btn_new":
    	           sheetObj.RemoveAll();
    	 		   formObj.reset();
    	 		   loadPage();
    	           break;

    	        case "btn_saveas":
    	           doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
    	           break;
    	    }
    	}catch(e){
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }

    function loadPage(){
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
     //   makingFirstSelectionBox();
        
        for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
        doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC01); 
    }
    
    function initCombo(comboObj, comboNo) {
    	switch (comboObj.id) {
    	case 'mycust':
    		with (comboObj) {
    			DropHeight = 260;
    			MultiSelect = false;
    			MaxSelect = 1;
    			UseAutoComplete = true;
    			MaxLength = 0;
    			IMEMode = 0;
    			ValidChar(2, 0);
    			SetColWidth("120|200|100|100|200");
    		}
    		break;
    	}
    }
    
    var request = null;
    function createHttpRequest() {
    	try{
    		request = new XMLHttpRequest();
    	} catch(trymicrosoft) {
    		try{
    			request = new ActiveXObject("Msxml2.XMLHTTP");
    		} catch(othermicosoft) {
    			try{
    				request = new ActiveXObject("Microsoft.XMLHTTP");
    			} catch(failed) {
    				request = null;
    			}
    		}
    	}
    	if( request == null ) {
    		ComShowMessage("Erroe Request XMLHttp");
    	}
    }
    
    /*OnChangeEvent 발생시에 결과값을 가지고 오는 함수*/
    var vContainer_edi_sts = new Array(2);
    function getChangeSelectionBoxResult(){
    	initVcontainer(vContainer_edi_sts);
    	if( request.readyState == 4 ) {
    		    if( request.status == 200 ) 
    		    {
      			  var delimination = "☜☞";
    			  var docXml  = request.responseXML;
    			  var rIndex  = docXml.getElementsByTagName("TR").length;
    			  var cIndex1  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts_con");
    			  var cIndex2  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cust_cd");
    			  var fRow    = docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;
    			     if(rIndex >0)
                     {
    			    	 vContainer_edi_sts[0] = (fRow.split(delimination))[cIndex1];//edi_sts setting
    			    	 vContainer_edi_sts[1] = (fRow.split(delimination))[cIndex2];//cust_cd setting
                     }else{
                    	 initVcontainer(vContainer_edi_sts);
                     }
    			}
    		     else
    			{
    				   return;
    			}//if

       }//if

    }

    /*tp_id 가 두개 이상인 경우 팝업창을 띄우는 역활을 한다.*/
    function searchingCntEct(){
    	var formObj = document.form;
    	var tp_id = formObj.tp_id.value;
    	var url = "ESD_SCE_0072GS.do?f_cmd="+ SEARCHLIST02 +"&tp_id="+ tp_id;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = getCntEct;
		request.send(null);   	
    }
    
    function initVcontainer(array){
  	  //데이터 초기화
        for(var n=0;n<array.length;n++){
        	array[n] = "";
         }//for  
    }
    function getCntEct(){
    	var cnt = 0;
    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) 
    		    {
    			  var delimination = "☜☞";
    			  var docXml = request.responseXML;
    			  var rIndex  = docXml.getElementsByTagName("ETC").length;
    			  for(var n=0;n<=rIndex;n++){
    				  if(docXml.getElementsByTagName("ETC")[n].getAttribute("KEY") != "" &&
    				     docXml.getElementsByTagName("ETC")[n].getAttribute("KEY").indexOf('tp_id_cnt') != -1)
    				  {    			
    					  cnt = docXml.getElementsByTagName("ETC")[n].firstChild.nodeValue;
    					  break;
    				  }
    			  }
    	
    			  var cIndex1  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"tp_id");   			  
    			  var cIndex2  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cust_cd");
    			  var cIndex3  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_grp_id"); 
    			  var cIndex4  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts_con"); 
    			  var cIndex5  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_desc");
    			  var fRow = null;
    			  if(rIndex >0)
                  {     				
    			    etc_value_container[0] = cnt;//count setting    			    
    			    if(cnt >0){
    			    	fRow = docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;  
        			    etc_value_container[1] = (fRow.split(delimination))[cIndex1]; //tp_id setting
        			    etc_value_container[2] = (fRow.split(delimination))[cIndex2]; //cust_cd setting
        			    etc_value_container[3] = (fRow.split(delimination))[cIndex3]; //cs_grp_id setting
        			    etc_value_container[4] = (fRow.split(delimination))[cIndex4]; //edi_sts setting
        			    etc_value_container[5] = (fRow.split(delimination))[cIndex5]; //cs_desc setting 
    			    }//if

                  }
                  else
                  { 
                	  initVcontainer(etc_value_container);
                  }//if
                  
    			}else{
    				return;
    			}//if

    		}//if
    }
    function getXMLAttribute(xml,attribute,index1,index2){//어트리뷰트를 가지고 오는 함수 
    	
		var data = xml.getElementsByTagName(attribute)[index1];
		var data_attribute = data.attributes[index2].nodeValue; 
		return data_attribute;
    }
    
    function getFiledNames(colorder){
    	if(colorder != ""){
    		return colorder.split("|");
    	}else{
    		
    		return;
    	}
    }
    
    function getFieldNameIndex(array,fName){//행의 인덱스를 가지고 오는 함수 
    	var index = -1;
    	for(var n=0;n<array.length;n++){
    		if(array[n] == fName) 
    			{
    			  index = n;
    			  break;
    			}
    		
    	}//for
    	return index;
    }
    
    function getTextXML(){//XML 을 텍스트로 가지고 오는 함수 
		var textDoc = request.responseText();//TEXT 버전 XML 
    	return textDoc;
    }
    function initSheet(sheetObj,sheetNo){
        var cnt = 0;

        var  xs = document.form.edi_sts_con.value;
        var  os = document.form.cust_cd.value;
        var  chmissontime = document.form.missOntime[0].checked
    	//서버와의 연결시간이 초과하여 10분으로 설정을 한다.
    	sheetObj.RequestTimeOut = 600;
        switch(sheetNo){
            case 1:
                with(sheetObj){
                	//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    style.height = GetSheetHeight(10) ;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msNone;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 2, 1, 10, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(26 + getEdiStsTileCnt(sheetObjects[1]) , 4, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle0 = "|BKG NO|BL NO|CNTR NO|CNTR TP/SZ|SHPR CD|SHPR NM|FWRD CD|FWRD NM|CNEE CD|CNEE NM|NTFY CD|NTFY NM|ANFY CD|ANFY NM|LANE|T-VVD|PRE VVD|PST VVD|POR|POL|POD|DEL|SC NO|RFA NO"+ getEdiStsTile(sheetObjects[1], 's_rpt_col_desc') + "|PFMC";
                    var HeadTitle1 = "|BKG NO|BL NO|CNTR NO|CNTR TP/SZ|SHPR CD|SHPR NM|FWRD CD|FWRD NM|CNEE CD|CNEE NM|NTFY CD|NTFY NM|ANFY CD|ANFY NM|LANE|T-VVD|PRE VVD|PST VVD|POR|POL|POD|DEL|SC NO|RFA NO"+ getEdiStsTile(sheetObjects[1], 's_cust_edi_sts_cd')+"|PFMC";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,  20,	daCenter,  true,	"ibflag"	  ,		false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'bkg_no'      ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'bl_no'       ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	100,daCenter,	true,	'cntr_no'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daCenter,	true,	'cntr_tpsz_cd',		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'shpr_cd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daLeft,		true,	'shpr_nm'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'fwrd_cd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daLeft,		true,	'fwrd_nm'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daCenter,	true,	'cnee_cd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daLeft,		true,	'cnee_nm'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daCenter,	true,	'ntfy_cd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daLeft,		true,	'ntfy_nm'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daCenter,	true,	'anfy_cd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daLeft,		true,	'anfy_nm'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	't_lane'      ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	't_vvd'       ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daCenter,	true,	'pre_vvd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtHidden,  	80,	daCenter,	true,	'pst_vvd'     ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'por_nod_cd'  ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'pol_nod_cd'  ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'pod_nod_cd'  ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'del_nod_cd'  ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'sc_no'       ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'rfa_no'      ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );

    				for(var j=1; j<sheetObjects[1].RowCount+1; j++){
    					if(sheetObjects[1].CellValue(j, 's_use_flg')=='1' && sheetObjects[1].CellValue(j, 's_edi_sts_flg')=='Y'){
	    					var colN = (sheetObjects[1].CellValue(j, 's_rpt_col_desc')+'_v_'+sheetObjects[1].CellValue(j, 's_cust_edi_sts_cd')).toLowerCase()
	    					InitDataProperty(0, cnt++ , dtData,  	120,	daCenter,	true,	colN,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    					}
    				}
    				InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	'pfmc'       ,		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				sheet1Cols = cnt-1; //PFMC 는  HIDDEN 처리에서 제외시키기 위해서 -1 까지만 COUNT 한다.
                }
                break;
            case 2:
                with(sheetObj){
                	//전체 너비 설정
                    SheetWidth = hiddenTable.clientWidth;;
                    style.height = GetSheetHeight(10) ;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(8, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);


    				var HeadTitle = "STS|s_use_flg|s_rpt_col_seq|s_rpt_col_nm|s_rpt_col_desc|s_edi_sts_flg|s_cust_edi_sts_cd|s_hidden_flg" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHidden,  150,	daCenter,  true,	"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_use_flg",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_rpt_col_seq",		false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_rpt_col_nm",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_rpt_col_desc",		false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_edi_sts_flg",		false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_cust_edi_sts_cd",	false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"s_hidden_flg",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				
                }
                break;
            case 3:
                with(sheetObj){
                	//전체 너비 설정
                    SheetWidth = hiddenTable.clientWidth;;
                    style.height = GetSheetHeight(10) ;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(5, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

    				var HeadTitle = "edi_grp_cd|cust_trd_prnr_id|edi_grp_desc|edi_cgo_rmk|edi_sts" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"edi_grp_cd",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"cust_trd_prnr_id",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"edi_grp_desc",		false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"edi_cgo_rmk",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"edi_sts",		false,		  "",	   dfNone,   	0,	 		true ,	   true);
                }
                break;
            case 4:
                with(sheetObj){
                	//전체 너비 설정
                    SheetWidth = hiddenTable.clientWidth;;
                    style.height = GetSheetHeight(10) ;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(5, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

    				var HeadTitle = "cs_grp_id|tp_id|cs_desc|cust_cd|edi_sts" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"cs_grp_id",		false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"tp_id",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"cs_desc",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"cust_cd",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,  150,	daCenter,  true,	"edi_sts",			false,		  "",	   dfNone,   	0,	 		true ,	   true);
                }
                break;
        }
    }

    // sheetObjects[1]에 조회된   COLUMN 내용에 맞춰 sheetObjects[0]의 컬럼을 숨기고 보여준다.
    function setSheetColHidden(){	
    	var sheetObj1 = sheetObjects[0];
    	var sheetObj2 = sheetObjects[1];
    	var colName_s1 = '';
    	var colName_s2 = '';
    	initSheet(sheetObj1, 1);
    	setEdiSubSts();
    	for(var j=1; j<sheet1Cols; j++){
    		colName_s1 = sheetObj1.ColSaveName(j);
    		sheetObj1.ColHidden(colName_s1) = true;    	   	
	    	for(var i=1; i<sheetObj2.RowCount+1; i++){
	    		if(sheetObj2.CellValue(i, 's_edi_sts_flg')=='Y'){
	    			colName_s2 = (sheetObj2.CellValue(i, 's_rpt_col_desc')+'_v_'+sheetObj2.CellValue(i, 's_cust_edi_sts_cd')).toLowerCase();
	    		}else{
	    			colName_s2 = sheetObj2.CellValue(i, 's_rpt_col_nm').toLowerCase();
	    		}
	    		if(colName_s1 == colName_s2){
	    			sheetObj1.ColHidden(colName_s1) = false;
	    			break;
	    		}
	    	}
    	}
    }
    
    function getEdiStsTile(sheetObj, colName){
    	var titleStr = '';
    	for(var i=1; i<sheetObj.RowCount+1; i++){
    		if(sheetObj.CellValue(i, 's_use_flg')=='1' && sheetObj.CellValue(i, 's_edi_sts_flg')=='Y') titleStr = titleStr+'|'+sheetObj.CellValue(i, colName);
    	}
    	return titleStr;
    }
    
    function setEdiSubSts(){
    	var subSts = '';
    	var ediSts = '';
    	var cnt = 0;
    	for(var i=1; i<sheetObjects[1].RowCount+1; i++){
    		if(sheetObjects[1].CellValue(i, 's_use_flg')=='1' && sheetObjects[1].CellValue(i, 's_edi_sts_flg')=='Y') 
    		{
    			if(cnt==0){
    				ediSts = sheetObjects[1].CellValue(i, 's_rpt_col_desc');
    				subSts = sheetObjects[1].CellValue(i, 's_cust_edi_sts_cd');
    			}else{
    				ediSts = ediSts+','+sheetObjects[1].CellValue(i, 's_rpt_col_desc');
    				subSts = subSts+','+sheetObjects[1].CellValue(i, 's_cust_edi_sts_cd');
    			}
    			cnt++;
    			
    		}
    	}
    	document.form.edi_sts.value = ediSts;
    	document.form.cust_cd.value = subSts;
    }
    
    function getEdiStsTileCnt(sheetObj){
    	var cnt = 0;
    	for(var i=1; i<sheetObj.RowCount+1; i++){
    		if(sheetObj.CellValue(i, 's_use_flg')=='1' && sheetObj.CellValue(i, 's_edi_sts_flg')=='Y') cnt += 1;
    	}
    	return cnt;
    }
    
    // Customer 입력 받는 메소드(POP UP 에서 호출한다.)
    function openCustomer(){
    	var formObject = document.form;
        var temp_mycust = formObject.mycust.Text;
        if(temp_mycust == ''){
        	var newWin = window.showModalDialog("ESD_SCE_0062.do?mycust=3", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
        } else {
            ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH:
                 if(validateForm(formObj)){
                	setSheetColHidden();
                    if(formObj.missOntime[0].checked){    //missing 조회
                        formObj.f_cmd.value = SEARCH01;
                        sheetObj.DoSearch4Post("ESD_SCE_0072GS.do", SceFrmQryString(formObj));

                    } else {                                 //on-time Performance
                         formObj.f_cmd.value = SEARCH02;
                         sheetObj.DoSearch4Post("ESD_SCE_0072GS.do", SceFrmQryString(formObj));
                    }
               }
               break;

            case SEARCHLIST01:
            	formObj.f_cmd.value = SEARCHLIST01;
            	sheetObj.DoSearch4Post("ESD_SCE_0072GS.do", SceFrmQryString(formObj));
            break;

            case IBDOWNEXCEL:
            	var currnt = sheetObj.EvalNow().substring(0,10);
            	var filesysdate = currnt.replaceStr("-","");
            	var compayName  = formObj.grp_nm.value.replaceStr(" ","");
            	if (formObj.missOntime[0].checked){
            	    var filename = filesysdate+"_"+compayName+"_Missing";
            	}else {
            		var filename = filesysdate+"_"+compayName+"_OnTime";	
            	}
            	var file =   sheetObj.SaveFileDialog("Save As", filename, "C:\\","Excel(*.xlsx)|*.xlsx|(*.*)|*.*" );
                	sheetObj.SpeedDown2Excel(-1, false,false, file);

            break;
            
            case IBSEARCH_ASYNC01:	//콤보 조회
				comboObjects[0].RemoveAll();
				formObj.f_cmd.value = SEARCH05;
				var sXml = sheetObj.GetSearchXml("ESD_SCE_0072GS.do", FormQueryString(formObj));
				
				ComSceXml2ComboItem(sXml, formObj.mycust, "edi_cgo_rmk", "edi_cgo_rmk|edi_sts|edi_grp_cd|cust_trd_prnr_id|edi_grp_desc");
				comboObjects[0].InsertItem(0, ''); 
				sheetObj.LoadSearchXml(sXml, false); 
			break;	
        }
    }
    
    function searchEdiGrpCgoSts(formObj){
    	//alert("searchEdiGrpCgoSts")
    	doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
    }
    
    function doActionIBSheet2(sheetObj, formObj, sAction){
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH:
            if(formObj.cs_grp_id.value == '') return;
	    	formObj.f_cmd.value = SEARCH03;
	    	formObj.edi_sts.value = formObj.edi_sts_con.value;
	        selectVal = SceFrmQryString(formObj);
	        sheetObj.DoSearch4Post("ESD_SCE_0073GS.do", selectVal);
	        break;
        }
    }
    
    function mycust_OnChange(comboObj, Index_Code, Text){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[2];
    	if (formObj.mycust.Text != ''){
    		formObj.cs_grp_id.value = sheetObj.cellValue(Number(comboObj.Index), 'edi_grp_cd');
    		formObj.tp_id.value = sheetObj.cellValue(Number(comboObj.Index), 'cust_trd_prnr_id');
    		formObj.grp_nm.value = sheetObj.cellValue(Number(comboObj.Index), 'edi_grp_desc');
    		formObj.edi_sts_con.value = sheetObj.cellValue(Number(comboObj.Index), 'edi_sts');
    		formObj.bzc_col.value = '';
    	}    	
    	doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
    }
    

    function validateForm(formObj){
        var result = false ;
        if(!ComIsEmpty(formObj.cs_grp_id)){          	
        	
        	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
       	    var formObject = document.form;                       	        	    
       	    if(!ComIsEmpty(formObject.podetadate1) && !ComIsEmpty(formObject.podetadate2)){
       	     formObject.podetadate1_hidden.value =  dateConverting(formObject.podetadate1.value);
       	     formObject.podetadate2_hidden.value  = dateConverting(formObject.podetadate2.value);   
       	    }else{
          	     formObject.podetadate1_hidden.value =  "";
           	     formObject.podetadate2_hidden.value  = "";       	    	
       	    }
       	    if(!ComIsEmpty(formObject.poletddate1) && !ComIsEmpty(formObject.poletddate2)){
     	          formObject.poletddate1_hidden.value =  dateConverting(formObject.poletddate1.value);
     	          formObject.poletddate2_hidden.value  = dateConverting(formObject.poletddate2.value); 
       	    }else{
   	          formObject.poletddate1_hidden.value =  "";
 	          formObject.poletddate2_hidden.value  = "";       	    	
       	    }    	
            result =  true;
            if(!ComIsEmpty(formObj.vvd) || !ComIsEmpty(formObj.bkg_no)
            || !ComIsEmpty(formObj.bl_no) || !ComIsEmpty(formObj.cntr_no)){
            	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
            	 var formObject = document.form;                       	        	    
            	    if(!ComIsEmpty(formObject.podetadate1) && !ComIsEmpty(formObject.podetadate2)){
            	     formObject.podetadate1_hidden.value =  dateConverting(formObject.podetadate1.value);
            	     formObject.podetadate2_hidden.value  = dateConverting(formObject.podetadate2.value);   
            	    }else{
               	     formObject.podetadate1_hidden.value =  "";
            	     formObject.podetadate2_hidden.value  = "";  
            	    }
            	    if(!ComIsEmpty(formObject.poletddate1) && !ComIsEmpty(formObject.poletddate2)){
          	          formObject.poletddate1_hidden.value =  dateConverting(formObject.poletddate1.value);
          	          formObject.poletddate2_hidden.value  = dateConverting(formObject.poletddate2.value); 
            	    }else{
            	          formObject.poletddate1_hidden.value =  "";
              	          formObject.poletddate2_hidden.value  = "";            	    	
            	    }
            	    if(!ComIsEmpty(formObject.fm_dt1) && !ComIsEmpty(formObject.to_dt1)){
            	          formObject.fm_dt.value =  dateConverting(formObject.fm_dt1.value);
            	          formObject.to_dt.value  = dateConverting(formObject.to_dt1.value); 
              	    }else{
              	          formObject.fm_dt.value =  "";
                	      formObject.to_dt.value  = "";            	    	
              	    }
                result = true;
            } else {
                if(!ComIsEmpty(formObj.poletddate1) || !ComIsEmpty(formObj.poletddate2)
                 || !ComIsEmpty(formObj.podetadate1) || !ComIsEmpty(formObj.podetadate2)
                 || !ComIsEmpty(formObj.fm_dt1) || !ComIsEmpty(formObj.to_dt1)){
                    if(!ComIsEmpty(formObj.poletddate1) || !ComIsEmpty(formObj.poletddate2)){
                        if(ComIsEmpty(formObj.pol)){
                            ComShowMessage('Either location or country code of POL is required.');
                             formObj.pol.focus();
                             result = false;
                        } else {
                             var temp_pol = formObj.pol.value.length;
                             if(temp_pol < 2){
                                 ComShowMessage('POL requires a country code 2 words long at least.');
                                 result = false;
                             } else if(temp_pol >= 2 && temp_pol < 5){
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletddate1.value, formObj.poletddate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 3 days in case POL doesn't have a full location code.");
                                      result = false
                                 } else {
                                	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject = document.form;                       	 
                                	 formObject.poletddate1_hidden.value =  dateConverting(formObject.poletddate1.value);
                                	 formObject.poletddate2_hidden.value  = dateConverting(formObject.poletddate2.value); 
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value =  "";
                                   	     formObject.podetadate2_hidden.value  = "" 
                                	 }//if                               	 
                                	 
                                     result = true;
                                 }
                             } else {
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletddate1.value, formObj.poletddate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result = false;
                                 } else {
                                	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject = document.form;                       	 
                                	 formObject.poletddate1_hidden.value =  dateConverting(formObject.poletddate1.value);
                                	 formObject.poletddate2_hidden.value  = dateConverting(formObject.poletddate2.value);    
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value =  "";
                                   	     formObject.podetadate2_hidden.value  = "" 
                                	 }//if                                	 
                                     result = true;
                                 }
                             }
                        }
                    }
                  
                    if(!ComIsEmpty(formObj.podetadate1) || !ComIsEmpty(formObj.podetadate2)){
                        if(ComIsEmpty(formObj.pod)){
                             ComShowMessage('Either location or country code of POD is required.');
                             formObj.pod.focus();
                             result = false;
                        } else {
                            var tmep_pod = formObj.pod.value.length;
                            if(tmep_pod < 2){
                                ComShowMessage('POD requires a country code 2 words long at least.');
                                result = false;
                            } else if(tmep_pod >= 2 && tmep_pod < 5){
                                 if((ComParseInt(ComGetDaysBetween(formObj.podetadate1.value, formObj.podetadate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 3 days in case POD doesn't have a full location code.");    // 5일까지 조회 가능~~
                                      result = false
                                 } else {
                                  	 var formObject = document.form;                       	 
                                	 formObject.podetadate1_hidden.value =  dateConverting(formObject.podetadate1.value);
                                	 formObject.podetadate2_hidden.value  = dateConverting(formObject.podetadate2.value);  
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                             	          formObject.poletddate1_hidden.value =  "";
                            	          formObject.poletddate2_hidden.value  = "";  
                               	 }//if                                	 
                                     result = true;
                                 }
                            } else {
                                if((ComParseInt(ComGetDaysBetween(formObj.podetadate1.value, formObj.podetadate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result = false;
                                 } else {
                                     //데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject = document.form;                       	 
                                	 formObject.podetadate1_hidden.value =  dateConverting(formObject.podetadate1.value);
                                	 formObject.podetadate2_hidden.value  = dateConverting(formObject.podetadate2.value);
                                	 
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                             	          formObject.poletddate1_hidden.value =  "";
                            	          formObject.poletddate2_hidden.value  = "";  
                               	 }//if                                	 
                                     result = true;
                                 }
                            }
                        } 
                    }
                if(!ComIsEmpty(formObj.fm_dt1) || !ComIsEmpty(formObj.to_dt1)){    
	                	if(formObj.office_id.value == "SELCOS" || formObj.office_id.value == "SELCOL" || formObj.office_id.value == "SELCOT" || formObj.office_id.value == "SELCON" || formObj.user_id.value == "2007803" || formObj.user_id.value == "2007819" || formObj.user_id.value == "2007818" || formObj.user_id.value == "2000320" || formObj.user_id.value.substring(0,3) == "TES"){
	                		if((ComParseInt(ComGetDaysBetween(formObj.fm_dt1.value, formObj.to_dt1.value)) > 30) ){
	                			ComShowMessage("The period of Event Date is limited to 31 days.");    // 31일까지 조회 가능~~
	                			result = false;
	                		} else {
	                			//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
	                			var formObject = document.form;                       	 
	                			formObject.fm_dt.value =  dateConverting(formObject.fm_dt1.value);
	                			formObject.to_dt.value  = dateConverting(formObject.to_dt1.value);
	                  	 
	                				if(ComIsEmpty(formObject.fm_dt1) || ComIsEmpty(formObject.to_dt1)){
	                					formObject.fm_dt.value =  "";
	                					formObject.to_dt.value  = "";  
	                				}//if                                	 
	                			result = true;
	                		}
	                	}else{
	                		if((ComParseInt(ComGetDaysBetween(formObj.fm_dt1.value, formObj.to_dt1.value)) > 9) ){
	                			ComShowMessage("The period of Event Date is limited to 10 days.");    // 31일까지 조회 가능~~
	                			result = false;
	                		} else {
	                			//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
	                			var formObject = document.form;                       	 
	                			formObject.fm_dt.value =  dateConverting(formObject.fm_dt1.value);
	                			formObject.to_dt.value  = dateConverting(formObject.to_dt1.value);
	                  	 
	                				if(ComIsEmpty(formObject.fm_dt1) || ComIsEmpty(formObject.to_dt1)){
	                					formObject.fm_dt.value =  "";
	                					formObject.to_dt.value  = "";  
	                				}//if                                	 
	                			result = true;
	                		}
	                	}
                	}
                } else {
                    ComShowMessage(ComGetMsg('COM12113',"one of followings: VVD,BKG NO,CNTR NO or BL NO."));
                    result = false;
                }
          
            }
        } else {
            ComShowMessage(ComGetMsg('COM12113',"EDI Customer Group."));
            result = false;
        }


        return result;
    }

    // Customer 에서 찾기 버튼
    function openESD009Screen(cs_grp_id, tp_id, grp_nm){
    	var formObject = document.form;
    	formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;
    	//formObject.mycust.value = "";
    	formObject.mycust.Text ="";
    	onObjectFocusout(formObject);
    }
    
    function onObjectFocusout(formObj){
    	//alert("onObjectFocusout")
		if(formObj.cs_grp_id.value == '') return;
    	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
    	formObj.bzc_col.value = '';
    	doActionIBSheet(sheetObjects[3], formObj, SEARCHLIST01);
    	comboObjects[0].Text = "";
    	searchEdiGrpCgoSts(formObj);
    }

    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }
        return str;
    }

    function openEDIsts(){
    	var formObject = document.form;
    	if(formObject.mycust.Text == ''){
    		var cs_grp_id ="";
            if(ComTrim(formObject.cs_grp_id.value) != '' && ComTrim(formObject.cs_grp_id.value) != "")   
            	cs_grp_id = formObject.cs_grp_id.value.toUpperCase();
   	     	var url = "ESD_SCE_0067.do?edi_grp_cd=" + cs_grp_id + "&diff=1"  + "&f_cmd=" + SEARCH + "&cs=99988888";
   	        var newWin = window.showModalDialog(url , window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:400px");
   	        searchEdiGrpCgoSts(formObject);
    	} else {
    	    ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
    	}
    }

    function openMyReport(){
        var formObject = document.form;
        var selCnt = formObject.mycust.length;

        var edi_grp_cd = toUpperCase(formObject.cs_grp_id.value);
        if(selCnt == 0){    // selCnt 가 0 이면 new 화면으로 이동
        	var newWin = window.showModalDialog("ESD_SCE_0073.do?newOld=1&pgmNo=ESD_SCE_0072", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:470px");
        } else {            // selCnt 가 0 이 아니면 modify 화면으로 이동
        	var newWin = window.showModalDialog("ESD_SCE_0073.do?newOld=2&pgmNo=ESD_SCE_0072", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:470px");
        }
    }

    function addEdiStsNo(edi_sts,cust_cd){
    	if(edi_sts != ''){
    			document.getElementById('edi_sts_con').value = edi_sts;
    			document.getElementById('cust_cd').value = cust_cd;
    	}
    }

    function openVVDList(){
    	var newWin = window.showModalDialog("ESD_SCE_0063.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:450px");
    }

    function addVVDNo(vvds, dist, loc_cd){
    	var formObject = document.form;
    	if(vvds != ''){
    		document.getElementById('vvd').value = vvds;
    		if(dist == 'D'){
	    		formObject.pol.value = toUpperCase(loc_cd);
    		}else{
    			formObject.pod.value = toUpperCase(loc_cd);
    		}
    	}
    }

    function onEnterKey(){

    }
    var etc_value_container =  new Array(6);
    // tp_id가 2개 이상일 경우 팝업~~
    function onObjectTpId(formObj){
        if(formObj.cs_grp_id.value == "" && (formObj.tp_id.value != "" && ComTrim(formObj.tp_id.value) != "")){//전병석 수정
        	
            formObj.tp_id.value = toUpperCase(formObj.tp_id.value);
            var sheetObj = sheetObjects[0];
            sheetObj.ShowDebugMsg = false;

            
            //formObj.f_cmd.value = COMMAND02;
        	//sheetObj.DoSearch("ESD_SCE_0072GS.do",SceFrmQryString(formObj));
            //변수초기화
            initVcontainer(etc_value_container);
            searchingCntEct();
            
        	/*예전소스*/
            //var result_cnt = sheetObj.EtcData("tp_id_cnt");
            //var result_tp_id = sheetObj.EtcData("tp_id");
            //var cust_cd = sheetObj.EtcData("cust_cd");
            //document.getElementById('cust_cd').value = sheetObj.EtcData("cust_cd");
            
        	/*바뀐소스*/
            
            
            var result_cnt   = etc_value_container[0];
            var result_tp_id = etc_value_container[1];
            var cust_cd      = etc_value_container[2];
            var cs_grp_id    = etc_value_container[3];
            var edi_sts      = etc_value_container[4];
            var cs_desc      = etc_value_container[5];
            
            document.getElementById('cust_cd').value = cust_cd;           

            var param = "?tp_id="+ result_tp_id;
            if(result_cnt > 1){
            	var newWin = window.showModalDialog("ESD_SCE_0068.do"+param, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:390px");
            } else {
                //IBS_EtcDataToForm2(formObj,sheetObj) ;
            	formObj.tp_id.value = result_tp_id;
            	formObj.cust_cd.value = cust_cd;
            	formObj.cs_grp_id.value = cs_grp_id;
            	formObj.edi_sts_con.value = edi_sts;
            	formObj.grp_nm.value = cs_desc;
            }
        }
    }

    function openCalendar(diff){
        var formObject = document.form;
        var from_date = "";
        var to_date = "";
        var obj_from_date = "";
        var obj_to_date = "";
        var cal = new ComCalendarFromTo();
        switch(diff){
           case '1':
               from_date =  "poletddate1";
               to_date   =  "poletddate2";
               obj_from_date = formObject.poletddate1;
               obj_to_date   = formObject.poletddate2;  
               cal.displayType = "date";
               cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');                 
           break;

           case '2':
             from_date =  "podetadate1";
             to_date   = "podetadate2";
             obj_from_date = formObject.podetadate1;
             obj_to_date = formObject.podetadate2;              
             cal.displayType = "date";
             cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd'); 
           break;
           case '3':
               from_date =  "fm_dt1";
               to_date   = "to_dt1";
               obj_from_date = formObject.fm_dt1;
               obj_to_date = formObject.to_dt1;              
               cal.displayType = "date";
               cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd'); 
             break;
        }



    }
    function dateConverting(date){
    	if(date != ''){
    		return ComTrimAll(date, "-");  
    	}//if
    	return '';
    }
    function sheet4_OnSearchEnd(sheetObj,ErrMsg){
    	var formObj = document.form;
    	if( ErrMsg != '' ) {
    		ComShowMessage(ErrMsg);
    	}else{
    		if(formObj.f_cmd.value == SEARCHLIST01 ){
    			
    			if(sheetObj.RowCount>0){
	    			formObj.cs_grp_id.value     = sheetObj.CellValue(1,'cs_grp_id');
	             	formObj.tp_id.value         = sheetObj.CellValue(1,'tp_id');
	           		formObj.grp_nm.value        = sheetObj.CellValue(1,'cs_desc');
	           		formObj.edi_sts_con.value       = sheetObj.CellValue(1,'edi_sts');
    			}else{
    				formObj.cs_grp_id.value     = '';
                 	formObj.tp_id.value         = '';
               		formObj.grp_nm.value        = '';
               		formObj.edi_sts_con.value   = '';
    			}
    		}
    	}
    }

    function onValueChange(selectName, formObj){
        switch(selectName){
            case 'mycust' :
               var temp_mycust = formObj.mycust.Text;
               if(temp_mycust == ""){
    	          formObj.cs_grp_id.value = "";
        	      formObj.tp_id.value = "";
        	      formObj.grp_nm.value = "";
        	      formObj.edi_sts_con.value = "";
    	       } else {
         	       var arr_mycust = temp_mycust.split("%");

        	       formObj.cs_grp_id.value = arr_mycust[0];
        	       formObj.tp_id.value = arr_mycust[1];
        	       formObj.grp_nm.value = arr_mycust[2];

        	       //formObj.f_cmd.value = SEARCH03;
                   //sheetObjects[0].DoSearch("ESD_SCE_0072GS.do", SceFrmQryString(formObj));
        	       
        	       onChangeSelectionBox();
                   //var edi_sts = sheetObjects[0].EtcData("edi_sts");
                   //var cust_cd = sheetObjects[0].EtcData("cust_cd");
                   //formObj.edi_sts.value = edi_sts;
                   //formObj.cust_cd.value = cust_cd;
        	       formObj.edi_sts_con.value = vContainer_edi_sts[0];
        	       formObj.cust_cd.value = vContainer_edi_sts[1];
        	  }
    	    break;
        }
    }

    function open073Screen(reportName, ediCdInfo, temp_edi_sts,temp_cust_sts, temp_basic_form){
        var arr_temp = ediCdInfo.split("%");

        var formObject = document.form;
        formObject.cs_grp_id.value = arr_temp[0];
        formObject.tp_id.value = arr_temp[1];
        formObject.grp_nm.value = arr_temp[2];
        formObject.edi_sts_con.value = temp_edi_sts;
        formObject.cust_cd.value = temp_cust_sts;
        formObject.bzc_col.value = temp_basic_form;
        formObject.mycust.Text = reportName;
        searchEdiGrpCgoSts(formObject);
    }

    
    function openESD068Screen(cs_grp_id, tp_id, grp_nm){
        var formObject = document.form;
        formObject.cs_grp_id.value = cs_grp_id;
    	onObjectFocusout(formObject);
    	formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;
    }

    function openAddPaste(dist){
		var formObject = document.form;
		var cntr_no = formObject.cntr_no.value;
		var bkg_no = formObject.bkg_no.value;
		var bl_no = formObject.bl_no.value;
		var vvd = formObject.vvd.value;
			if (dist == 'cntr_no'){
				var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
			}else {
				var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
			}
    }

    function addValueNo(dist, multi_value){
        var multis = multi_value.split('\n');

        multi_value = '';
        for(var i = 0 ; i < multis.length ; i++){
        	if (dist == 'cntr_no'){
        		if(multis[i] != ''){
        			if(i == 0){
        				multi_value = CheckDigitSplit1(multis[i]);
        			}else{
        				multi_value = multi_value + ',' + CheckDigitSplit1(multis[i]);
        			}
        		}
        	}else {
        		if(multis[i] != ''){
        			if(i == 0){
        				multi_value = multis[i];
        			}else{
        				multi_value = multi_value + ',' + multis[i];
        			}
        		}
        	}
        }
        if(multi_value != ''){
        	if (dist == 'cntr_no'){
        		document.getElementById(dist).value = multi_value;
    			document.getElementById("cntr_no_nonbit").value = multi_value;
    			document.getElementById("cntr_no_split").value = "";
        	}else {
        		document.getElementById(dist).value = multi_value;
        	}
    	}
    }

    function CheckDigit(obj){
        var rtnval = cntrCheckDigit(obj);
        obj.value  = rtnval;
    }

    
 // Container No. 의 CheckDigit 을 설정.
    function CheckDigitSplit( obj, bitTarget, valueTarget){
    	var cntrNo = obj.value;
    	var orginNo = obj.value;
    	if (cntrNo.length < 10){
    		document.getElementById(bitTarget).value = '';
    		document.getElementById(valueTarget).value = cntrNo;
    		return;
    	}
    	ComChkObjValid(obj, 'eng_num', true, 10);
    	var sum = 0;
     	cntrNo = cntrNo.toUpperCase();

      	if (orginNo.length == 10){
     		sum = ComGetCntrChkDgt( cntrNo.substr(0,10));	
     		var mod = sum % 11;

     		if (mod == 10) mod =0;

     		if( isNaN(mod)){
     			document.getElementById(bitTarget).value = '';
     			document.getElementById(valueTarget).value = obj.value;
     		}else{
     			obj.value = 	cntrNo.substr(0,10);
     			document.getElementById(bitTarget).value = mod;
     			document.getElementById(valueTarget).value = obj.value + mod;
     		}
     	}else {
     		document.getElementById(bitTarget).value = '';
 			document.getElementById(valueTarget).value = obj.value;
     	}

    }
    
    // Container No.를 POPUP에서 받은 값의 CheckDigit 을 설정.
     function CheckDigitSplit1(obj){ 
    	 var formObject = document.form
    	var cntrNo = obj;
    	var cnrtNoStr = obj;
    	var returnvalue = "";
    	if (cntrNo.length < 10){
    			return cnrtNoStr;
    	}
    	ComChkObjValid(formObject.cntr_no, 'eng_num', true, 10);
    	var sum = 0;
     	cntrNo = cntrNo.toUpperCase();

    	sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
     
    	var mod = sum % 11;

    	if (mod == 10) mod =0;

    	if( isNaN(mod)){
    		returnvalue = cnrtNoStr;
    		return returnvalue;
    	}else{
    		cnrtNoStr  = 	cntrNo.substr(0,10);		
    		returnvalue = cnrtNoStr + mod;
    		return returnvalue;
    		
    	}
    }
    