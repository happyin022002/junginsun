    /**
     * @extends 
     * @class ESD_SCE_0080 : ESD_SCE_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SCE_0080() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var isSearch = false;

var selRow = 0;
var isFirst1 = 0;
var isFirst2 = 0;

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

    	    formObj.vvd.value = toUpperCase(formObj.vvd.value);
    	    formObj.eve_loc.value = toUpperCase(formObj.eve_loc.value);

    	    switch(srcName){
    	        case "btn_retrieve":
    	           if((formObj.vvd.value != "")){
                       doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	           }  else if((formObj.fmd_dt.value != "" && formObj.tod_dt.value != "") || (formObj.fma_dt.value != "" && formObj.toa_dt.value != "")){
    	        	 
    	               if(formObj.eve_loc.value == ""){
    	            	   ComShowMessage('Please, insert Event Port');
    	               } else {
    	                   var temp_loc = formObj.eve_loc.value.length;
    	                   if(temp_loc < 2){
    	                	   ComShowMessage('Event Port requires a country code 2 words long at least. ');
    	                       break;
    	                   } else if(temp_loc >= 2 && temp_loc < 5){
    	                       if((ComParseInt(ComGetDaysBetween(formObj.fmd_dt.value, formObj.tod_dt.value)) > 2)   ||
                                   (ComParseInt(ComGetDaysBetween(formObj.fma_dt.value, formObj.toa_dt.value)) > 2) ){
    	                    	   ComShowMessage("The period of T.VVD ETD/T.VVD ETA is limited to 3 days in case Event Port doesn't have a full location code. ");    // 5일까지 조회 가능~~
                                    break;
                                } else {
                                    doActionIBSheet(sheetObj,formObj,IBSEARCH);
                                }
    	                   } else { 
    	                       if((ComParseInt(ComGetDaysBetween(formObj.fmd_dt.value, formObj.tod_dt.value)) > 4)   ||
                                   (ComParseInt(ComGetDaysBetween(formObj.fma_dt.value, formObj.toa_dt.value)) > 4) ){
    	                    	   ComShowMessage("The period of T.VVD ETD/T.VVD ETA is limited to 5 days. ");    // 5일까지 조회 가능~~
                                    break;
                                } else {
                                    doActionIBSheet(sheetObj,formObj,IBSEARCH);
                                }
    	                   }
    	               }
    	           }else  if((formObj.vvd.value == "") && (formObj.fmd_dt.value=="") && (formObj.fma_dt.value=="")){
    	        	   ComShowMessage('VVD or  ETD(ETA) date is required ')
    	        	   break;
    	        	   
    	           }else {
    	        	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	           }
    	           break;
//    	        case "btng_send":
//    	           if(sheetObj.CheckedRows("flag")>0){
//    	               var chkrow = 0;
//    	               for(var i = 0 ; i < sheetObj.CheckedRows("flag"); i++){
//    	                   chkrow = sheetObj.FindCheckedRow("flag").split('|')[i];
//    	               }
//    	               doActionIBSheet(sheetObj,formObject,IBINSERT);
//    	           } else {
//    	               alert("Please, Check CheckBox");
//    	           }
//    	           break;

    	        case "btn_new":

//        	       var del_Eve_Sel = formObj.eve_Sel.options;
//        	       var del_Eve_Sel_len = del_Eve_Sel.length;
//        	       for(var t = 1; t <= del_Eve_Sel_len; t++){
//        	           del_Eve_Sel[del_Eve_Sel_len-t] = null;
//        	       }

    	           sheetObj.RemoveAll();
    			   formObj.reset();
    	           break;

                case "btn_saveas":
                    doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
                    break;
                    
    			case "btn_etd_calendar":
    				
    				var cal = new ComCalendarFromTo();
    				cal.displayType = "date";
    				cal.select(formObj.fmd_dt, formObj.tod_dt, 'yyyy-MM-dd');
    				break ;

    			case "btn_eta_calendar":
    				var cal = new ComCalendarFromTo();
    				cal.displayType = "date";
    				cal.select(formObj.fma_dt, formObj.toa_dt, 'yyyy-MM-dd');
    				break ;
    
    	    }
    	}catch(e){
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    function loadPage(){
        for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
		}
    }

    function initSheet(sheetObj,sheetNo){
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 2, 1, 10, 300);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//    				InitColumnInfo(12, 1, 0, true);
                    InitColumnInfo(11, 0, 0, true);
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false);

    				var HeadTitle = "BKG|BL NO|CNTR|EDI\nSTS|CUST\nSTS|LOC|VVD|COP|COP|COP|EDI";
    				var HeadTitle1 = "BKG|BL NO|CNTR|EDI\nSTS|CUST\nSTS|LOC|VVD|Estimated Date|Actual Date|Delays\n(Hours)|Process Date\n(LCL)";

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				InitHeadRow(1, HeadTitle1, true);

//    				InitDataProperty(0, cnt++ , dtHidden,       20,    daCenter,  false,    "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "bkg_no",         false,          "",      dfNone,      0,     true,       true,          30);
//                    InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  true,    "bkg_split",      false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "bl_no",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "cntr_no",        false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,    "edi_sts_cd",        false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,    "cust_sts_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "nod_cd",         false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "vvd",         false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         120,   daCenter,  true,    "estm_dt",        false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         120,   daCenter,  true,    "act_dt",        false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "delays",         false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         120,   daCenter,  true,    "dat_rcv_dt",        false,          "",      dfNone,      0,     true,       true,          30);
                }
                break;
        }
    }

    function sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }

    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo){
        sheetObj.ShowDebugMsg = false;

        switch(sAction){
            case IBSEARCH:      // search
           
               initSheet(sheetObj,1);
               sheetObj.removeAll();
		       formObj.f_cmd.value = SEARCH01;
			   sheetObj.DoSearch4Post("ESD_SCE_0080GS.do", SceFrmQryString(formObj));
               break;


            case IBDOWNEXCEL:
               sheetObj.Down2Excel(-1, false, false, true);
               break;

            case IBSEARCHAPPEND:
               formObj.f_cmd.value = SEARCH01;
			   sheetObj.DoSearch4Post("ESD_SCE_0080GS.do", SceFrmQryString(formObj), "iPage=" + PageNo, true);
			   break;
        }
    }

    function onEnterKey(){

    }

   // Customer 입력 받는 메소드(POP UP 에서 호출한다.)
    function openCustomer(){
//	    window.open ("ESD_SCE_0062.do", "list", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=480");
    	var newWin = window.showModalDialog("ESD_SCE_0062.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
    }
/*
   function onObjectFocusout(formObj){
    	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
    	var sheetObj = sheetObjects[0];
    	sheetObj.ShowDebugMsg = false;
    	formObj.f_cmd.value = COMMAND05;
    	sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));

    	IBS_EtcDataToForm2(formObj,sheetObj);

    	var temp_edi_sts = formObj.edi_sts.value;
    	//var arr_edi_sts = temp_edi_sts.split(",");
    	//for(var i = 0; i < arr_edi_sts.length; i++){
    	//    formObj.eve_Sel.options[i] = new Option(arr_edi_sts[i], arr_edi_sts[i]);
    	//}
    	//formObj.mycust.value = formObj.cs_grp_id.value+""+formObj.tp_id.value+""+formObj.grp_nm.value;
   }*/
    
    // 2010-03-23 mycust 선택되어 있고 customer 변경시 My Performance ~ 메세지 띄워주던것 주석치리
   function onObjectFocusout(formObj){
 
	  // if(formObj.mycust.value == ''){
	    	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
	    	var sheetObj = sheetObjects[0];
	    	sheetObj.ShowDebugMsg = false;
	    	formObj.f_cmd.value = MULTI05;
	    	sheetObj.RemoveEtcData();
	    	if(formObj.cs_grp_id.value !=''){  
	    	  sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));

  		      ComEtcDataToForm(formObj,sheetObj);
  		      /*초기화*/
  		      if(formObj.tp_id.value == ''){
  		    	formObj.cs_grp_id.value = ''
  		      }
	    	}
	  // }else{
	//	     ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
	  // }//if
	   
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
   
   function getXMLAttribute(xml,attribute,index1,index2){//어트리뷰트를 가지고 오는 함수 
   	
		var data = xml.getElementsByTagName(attribute)[index1];
		var data_attribute = data.attributes[index2].nodeValue; 
		return data_attribute;
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
   			  var cIndex4  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts"); 
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
   
   var etc_value_container =  new Array(6);   
   function onObjectTpId(formObj){
       if(formObj.cs_grp_id.value == "" && (formObj.tp_id.value != "" && ComTrim(formObj.tp_id.value) != "")){//전병석 수정
           formObj.tp_id.value = toUpperCase(formObj.tp_id.value);
           var sheetObj = sheetObjects[0];
           sheetObj.ShowDebugMsg = false;
           
           //변수초기화
           initVcontainer(etc_value_container);
           searchingCntEct();
           
           
           var result_cnt   = etc_value_container[0];
           var result_tp_id = etc_value_container[1];
           var cust_cd      = etc_value_container[2];
           var cs_grp_id    = etc_value_container[3];
           var edi_sts      = etc_value_container[4];
           var cs_desc      = etc_value_container[5];
           var param = "?tp_id="+ result_tp_id;
           if(result_cnt > 1){
//               window.open ("ESD_SCE_0068.do"+param, "list", "scrollbars=no,resizable=no,fullscreen=no,width=600,height=390");
        	   var newWin = window.showModalDialog("ESD_SCE_0068.do"+param, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:390px");
           } else {
               //IBS_EtcDataToForm2(formObj,sheetObj) ;
           	
           	formObj.tp_id.value = result_tp_id;
           	formObj.cs_grp_id.value = cs_grp_id;
           	formObj.edi_sts.value = edi_sts;
           	formObj.grp_nm.value = cs_desc;
           	
           }
       }
       /*
       if(formObj.cs_grp_id.value == ""){
           formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
           var sheetObj = sheetObjects[0];
           sheetObj.ShowDebugMsg = false;
           formObj.f_cmd.value = COMMAND03;
           sheetObj.DoSearch("ESD_SCE_0080GS.do",SceFrmQryString(formObj));
           var result_cnt = sheetObj.EtcData("tp_id_cnt");
           var result_tp_id = sheetObj.EtcData("tp_id");

           var param = "?tp_id="+result_tp_id;
           if(result_cnt > 1){
                window.open ("ESD_SCE_0068.do"+param, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=600,height=390");
           } else {
                //IBS_EtcDataToForm2(formObj,sheetObj) ;
        	   ComEtcDataToForm(formObj,sheetObj) ;

                var temp_edi_sts = formObj.edi_sts.value;
            	var arr_edi_sts = temp_edi_sts.split(",");
            	for(var i = 0; i < arr_edi_sts.length; i++){
            	    //formObj.eve_Sel.options[i] = new Option(arr_edi_sts[i], arr_edi_sts[i]);
            		formObj.mycust.options[i] = new Option(arr_edi_sts[i], arr_edi_sts[i]);
            	}
           }
       }*/
   }
   function initVcontainer(array){
 	  //데이터 초기화
       for(var n=0;n<array.length;n++){
       	array[n] = "";
        }//for  
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
   
   function searchingCntEct(){
   	var formObj = document.form;
   	var tp_id = formObj.tp_id.value;
   	var url = "ESD_SCE_0035GS.do?f_cmd="+ MULTI06 +"&tp_id="+ tp_id;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = getCntEct;
		request.send(null);   	
   }
   
   function openESD068Screen(cs_grp_id, tp_id, grp_nm){
        var formObject = document.form;

        formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;

    	onObjectFocusout(formObject);
    }

    function openESD009Screen(cs_grp_id, tp_id, grp_nm){
    	var formObject = document.form;
    	formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;
    	formObject.mycust.value = cs_grp_id+"%"+tp_id+"%"+grp_nm ;

    	onObjectFocusout(formObject);
    }

    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }
        return str;
    }

    function onValueChange(selectName, formObj){
        switch(selectName){
    	    case 'mycust' :
    	       var temp_mycust = formObj.mycust.value;
    	       if(temp_mycust == ""){
    	          formObj.cs_grp_id.value = "";
        	      formObj.tp_id.value = "";
        	      formObj.grp_nm.value = "";
//        	      var del_Eve_Sel = formObj.eve_Sel.options;
//        	      var del_Eve_Sel_len = del_Eve_Sel.length;
//        	      for(var t = 1; t <= del_Eve_Sel_len; t++){
//        	           del_Eve_Sel[del_Eve_Sel_len-t] = null;
//        	      }
    	       } else {
        	       var arr_mycust = temp_mycust.split("%");

        	       formObj.cs_grp_id.value = arr_mycust[0];
        	       formObj.tp_id.value = arr_mycust[1];
        	       formObj.grp_nm.value = arr_mycust[2];

//                   var sheetObj = sheetObjects[0];
//                   formObj.f_cmd.value = SEARCH02;
//                   sheetObj.DoSearch("ESD_SCE_0080GS.do",SceFrmQryString(formObj));
//                   var temp_edi_sts = sheetObj.EtcData("edi_sts");
//                   formObj.edi_sts.value = temp_edi_sts;
//
//                   var arr_edi_sts = temp_edi_sts.split(",");
//                   for(var i = 0;i < arr_edi_sts.length; i++){      // my customer 값에 따른 Event Select 값이 바뀐다....
//                       formObj.eve_Sel.options[i] = new Option(arr_edi_sts[i], arr_edi_sts[i]);
//                   }
    	       }
    	    break;
    	}
    }

    function openCalendar(diff){
        var formObject = document.form;
        var from_date = "";
        var to_date = "";
        var obj_from_date = "";
        var obj_to_date = "";

        switch(diff){
            case '1':
                 from_date = "fmd_dt";
                 to_date = "tod_dt";
                 obj_from_date = formObject.fmd_dt;
                 obj_to_date = formObject.tod_dt;
            break;

            case '2':
                 from_date = "fma_dt";
                 to_date = "toa_dt";
                 obj_from_date = formObject.fma_dt;
                 obj_to_date = formObject.toa_dt;
            break;
        }

        cal = new calendarPopupFromTo();
        cal.displayType = "date";
        cal.select(obj_from_date, from_date,obj_to_date, to_date, 'yyyy-MM-dd');
    }

    function onEnterKey(){

    }

    function openVVDList(){
//    	window.open ("ESD_SCE_0063.do", "list", "scrollbars=no,resizable=yes,fullscreen=no,width=600,height=450");
    	var newWin = window.showModalDialog("ESD_SCE_0063.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:450px");
    }

    function openfunction(){
        var formObject = document.form;
        formObject.action = "ESD_SCE_0080.do?sysCommUiTitle=Vessel Estimation Accuracy&sysCommUiNavigation=Service Delivery > SCEM > Visibility";
    	formObject.submit();
    }

    function addVVDNo(vvds, dist, loc_cd){
        var formObject = document.form;
        if(vvds != ""){
            document.getElementById("vvd").value = vvds
        }
    }

    function openAddPaste(dist){
//    	window.open ("ESD_SCE_0064.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=400,height=360");
    	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
    }

    function addValueNo(dist, multi_value){
        var multis = multi_value.split('\n');

        multi_value = '';
        for(var i = 0 ; i < multis.length ; i++){
            if(multis[i] != ''){
    			if(i == 0){
    				multi_value = multis[i];
    			} else {
    				multi_value = multi_value + ',' + multis[i];
    			}
	   		}
        }
        if(multi_value != ''){
    		document.getElementById(dist).value = multi_value;
    	}
    }

    function sheet_OnSearchEnd(sheetObj,ErrMsg){
        var rowCnt = sheetObj.RowCount;
        var temp_del_dt = "";
        with(sheetObj){
            for(var i =1; i <= rowCnt ;i++){
                del_dt = sheetObj.CellValue(i,"del_dt");
                if(del_dt > 9999){
                    sheetObj.CellValue(i,"del_dt") = 9999;
                }
            }
        }
    }