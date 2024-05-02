﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0065.js
*@FileTitle  : Cargo Tracking EDI Save - Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
// 공통전역변수

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObject = document.form;

    	var srcName = window.event.srcElement.getAttribute("name");
    	var opener = window.dialogArguments;
    	switch(srcName) {
    		case "btn_save":
    			        var prefix ="sheet1_";
            			formObject.nod.value = toUpperCase(formObject.nod.value);
            			formObject.f_cmd.value = SEARCH01;
                        //선택된 EDI STS에 따른 CUST STS의 검색 조건을 다시 세팅
                        document.form.cust_opt.value =  " edi_grp_cd = '"+document.form.cs_grp_id.value+"' AND EDI_STND_STS_CD = '"+document.form.edi_sts.value+"' ";
                        //document.form.cust_st.value = document.form.cust_sts.value;
        				formObject.action = 'ESD_SCE_0065.do';						

                        //부모창 값을 읽어와 저장합니다.
        				if(!opener) opener=parent;
    		            var openersh = opener.sheetObjects[0] ;  // opener sheet1
                        var iCheckRow2 = openersh.FindCheckedRow("flag");
                		var arrRow = iCheckRow2.split("|");
                		var bkg_no = '';
                		var cntr_no = '';
                		var edi_sts = '';
                		var cs_grp_id = '';

                		for (idx=0; idx<arrRow.length-1; idx++)
                		{ 
                			if(idx == 0){
                				bkg_no = openersh.CellText(arrRow[idx],prefix + 'bkg_no');
                				cntr_no = openersh.CellText(arrRow[idx],prefix+ 'cntr_no');
                			}else{
                				bkg_no = bkg_no + "|" + openersh.CellText(arrRow[idx],prefix + 'bkg_no');
                				cntr_no = cntr_no + "|" + openersh.CellText(arrRow[idx],prefix + 'cntr_no');
                			}
                		}    		            
            			cs_grp_id = formObject.cs_grp_id.value;                        
                        document.form.bkg_no.value = bkg_no;  
                        document.form.cntr_no.value = cntr_no; 
                        document.form.cs_grp_id.value = cs_grp_id;
                        if(document.form.act_dt.value.length < 19){
                        	alert("Please, Insert Actual Date");
                        	return;                        	
                        }
                        if(document.form.nod.value.length < 5){
                        	alert("Please, Insert Location");
                        	return;
                        }

        				var btn_v = document.getElementById('btn_v');	
        				btn_v.innerHTML = "<tr>-->EDI Save Processing......</tr>";	

        				formObject.submit();
    		break;
			case "btn_close":
				opener.researchScreen();
				window.close();
			break;
    	}
    }

    function toUpperCase(str_){
       str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }  
        return str;      
    }

    function enterCheck(){
    	var formObject = document.form;
    	var str = formObject.act_dt.value;

    	if(event.keyCode > 57 && event.keyCode != 8 && event.keyCode != 229 && event.keyCode < 96 && event.keyCode > 105){

    		str = str.substring(0,str.length-1);
    		formObject.act_dt.value = str;

			 formObject.act_dt.value = str;
    		return false;
    	}

    	if(event.keyCode != 8){  
			 if(str.length == 4 || str.length == 7){
			 	str = str + "/";    	 	
			 }else if(str.length == 10){
			 	str = str + " ";
			 }else if(str.length == 13){
			 	str = str + ":";
			 }else if(str.length == 16){
			 	str = str + ":";
			 }
			 formObject.act_dt.value = str;
    	} else {
    	     if(str.length == 4 ){
    	         str = str.substring(0,3);
    	     } else if(str.length == 7){
    	         str = str.substring(0,6);
    	     } else if(str.length == 10){
    	         str = str.substring(0,9);
    	     } else if(str.length == 13){
    	         str = str.substring(0,12);
    	     } else if(str.length == 16){
    	         str = str.substring(0,15);
    	     }
    		 formObject.act_dt.value = str;
    	}
    }

    function comboChange(str){
        //선택된 EDI STS 저장
        document.form.edi_selected_idx.value =  document.all['edi_sts'].selectedIndex;

        //선택된 EDI STS에 따른 CUST STS의 검색 조건을 다시 세팅
        document.form.cust_opt.value =  " edi_grp_cd = '"+document.form.cs_grp_id.value+"' AND EDI_STND_STS_CD = '"+document.form.edi_sts.value+"' ";

        //화면을 Reload할 Action 
        screenReload();

    }    

    function custcomboChange(str,val){

      document.form.cust_sts.value = val;

    }        

    //화면 load시 호출하는 함수
    function loadPage(){

        //이전화면에서 선택한 EDI STS를 표시하기 위해  
        document.all['edi_sts'].selectedIndex = document.form.edi_selected_idx.value;

    }