/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BCM_CMS_0312HTMLAction.java
*@FileTitle : Customer Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2018-01-19
*@LastModifier : jklim
*@LastVersion : 1.0
* 2018-01-19 jklim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CMS0312 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - BCM_CMS0312HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jaekwan
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class BcmCms0312Event extends EventSupport {

	    private String rqstNo = "";
	    private String grpIndivDiv = "";
	    private String rjctRsnRmk = "";
	    private String rjctRsnCd = "";

	    /**
	     * Constructor<br>
	     */
	    public BcmCms0312Event(){}

		
	    /**
	     * Event 명을 반환<br>
	     * @return String
	     */
	    public String getEventName() {
	        return "BcmCms0312Event";
	    }

	    /**
	     * Class 명을 반환<br>
	     * @return String
	     */
	    public String toString() {
	        return "BcmCms0312Event";
	    }

		/**
		 * Rqst No 반환<br>
		 * @return
		 */
		public String getRqstNo() {
			return rqstNo;
		}

		/**
		 * Rqst No 세팅<br>
		 * @param custCd
		 */
		public void setRqstNo(String rqstNo) {
			this.rqstNo = rqstNo;
		}
		
		/**
		 * Rqst No 반환<br>
		 * @return
		 */
		public String getGrpIndivDiv() {
			return grpIndivDiv;
		}

		/**
		 * Rqst No 세팅<br>
		 * @param custCd
		 */
		public void setGrpIndivDiv(String grpIndivDiv) {
			this.grpIndivDiv = grpIndivDiv;
		}
		
		/**
		 * Reject reason remark 반환<br>
		 * @return
		 */
		public String getRjctRsnRmk() {
			return rjctRsnRmk;
		}

		/**
		 * Reject reason remark<br>
		 * @param rjctRsnRmk
		 */
		public void setRjctRsnRmk(String rjctRsnRmk) {
			this.rjctRsnRmk = rjctRsnRmk;
		}
		
		/**
		 * Reject reason code 반환<br>
		 * @return
		 */
		public String getRjctRsnCd() {
			return rjctRsnCd;
		}

		/**
		 * Reject reason code 세팅<br>
		 * @param rjctRsnCd
		 */
		public void setRjctRsnCd(String rjctRsnCd) {
			this.rjctRsnCd = rjctRsnCd;
		}

}
