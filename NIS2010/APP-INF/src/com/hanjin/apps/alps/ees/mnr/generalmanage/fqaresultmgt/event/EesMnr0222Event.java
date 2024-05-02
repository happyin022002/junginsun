/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0222Event.java
*@FileTitle : FQA Result Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.09 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0222 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0222HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyungSeok Ham
 * @see EES_MNR_0222HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0222Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FQAResultMgtINVO fQAResultMgtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVOs = null;
	
	public EesMnr0222Event(){}

	public FQAResultMgtINVO getFQAResultMgtINVO() {
		return fQAResultMgtINVO;      
	} 

	public void setFQAResultMgtINVO(FQAResultMgtINVO fQAResultMgtINVO) {
		this.fQAResultMgtINVO = fQAResultMgtINVO;
	}  

	public MnrFieldQualityAuditResultVO[] getMnrFieldQualityAuditResultVOS(){
		return mnrFieldQualityAuditResultVOs;
	}
	public void setMnrFieldQualityAuditResultVOs(MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVOs) {
		this.mnrFieldQualityAuditResultVOs = mnrFieldQualityAuditResultVOs;
	}

}