/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_008Event.java
*@FileTitle : 구주 FAC 계약 요율 Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-13 Hwang GyeongNam
* 1.0 최초 생성
* 2009-09-04 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtFacAgmtRtVO;

/**
 * ESM_AGT_008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

	public class EsmAgt0008Event extends EventSupport {

		private static final long	serialVersionUID	= 1L;
	
		/** Table Value Object 조회 조건 및 단건 처리 */
		private AgtFacAgmtRtVO	  agtFacAgmtRtVO	 = null;
	
		/** Table Value Object Multi Data 처리 */
		private AgtFacAgmtRtVO[]	agtFacAgmtRtVOs	= null;
	
		public EsmAgt0008Event() {
		}
	
		public void setAgtFacAgmtRtVO(AgtFacAgmtRtVO agtFacAgmtRtVO) {
			this.agtFacAgmtRtVO = agtFacAgmtRtVO;
		}
	
		public void setAgtFacAgmtRtVOS(AgtFacAgmtRtVO[] agtFacAgmtRtVOs) {
			this.agtFacAgmtRtVOs = agtFacAgmtRtVOs;
		}
	
		public AgtFacAgmtRtVO getAgtFacAgmtRtVO() {
			return agtFacAgmtRtVO;
		}
	
		public AgtFacAgmtRtVO[] getAagtFacAgmtRtVOS() {
			return agtFacAgmtRtVOs;
		}

}
