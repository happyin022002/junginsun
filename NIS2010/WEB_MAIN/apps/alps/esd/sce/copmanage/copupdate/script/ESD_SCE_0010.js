/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

    		var srcName = window.event.srcElement.getAttribute("name");
    		var formObj = document.form ;
            switch(srcName) {

        	    case "btn_save":
        	    	if(validateForm(formObj)){
	    	            form.f_cmd.value = MODIFY ;
	    	            form.action      = "ESD_SCE_0010GS.do" ;
	    	            form.submit() ;
        	    	}
        	        break;

        	    case "btns_calendar1":
        	         var cal = new calendarPopup();
            		 cal.select(formObj.estm_date, 'estm_date', 'yyyy-MM-dd');
        	        break;
        	    case "btns_calendar2":
        	         var cal = new calendarPopup();
            		 cal.select(formObj.act_date, 'act_date', 'yyyy-MM-dd');
        	        break;

            } // end switch
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj){
        with(formObj){
			if(formObj.estm_act_dt[0].checked){
				if(isEmpty(formObj.estm_date) || !isDate(formObj.estm_date)){
			        ComShowMessage(getMsg('SCE90003','Estimated Date')) ;
			        formObj.estm_date.focus() ;
			        return false ;
				}
	    	}
	    	else if(formObj.estm_act_dt[1].checked){
				if(isEmpty(formObj.act_date) || !isDate(formObj.act_date)){
			        ComShowMessage(getMsg('SCE90003','Actual Date')) ;
			        formObj.act_date.focus() ;
			        return false ;
				}
	    	}
	    	else {
	    		ComShowMessage(getMsg('SCE90004')) ;
	    		return false ;
	    	}
        }

        return true;
    }
