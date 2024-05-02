/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0093Event.java
*@FileTitle : Disposal Planning
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김완규  
*@LastVersion : 1.0
* 2009.09.07 김완규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see ees_mnr_0093HTMLAction 참조
 * @since J2EE 1.6
 */    
      
public class EesMnr0093Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0093Event(){}   

	/** Scrapping/Donation 조회 조건 및 단건 처리  */
	private ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = null;

	public ExtraDisposalMgtGRPVO getExtraDisposalMgtGRPVO() {
		return extraDisposalMgtGRPVO;
	}

	public void setExtraDisposalMgtGRPVO(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) {
		this.extraDisposalMgtGRPVO = extraDisposalMgtGRPVO;
	}
	
}