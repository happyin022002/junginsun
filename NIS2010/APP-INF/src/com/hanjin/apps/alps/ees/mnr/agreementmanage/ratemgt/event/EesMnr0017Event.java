/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesMnr0017Event.java
*@FileTitle : M&R Agreement Attachment_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.12.15 Chang Young Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgmtAtchDataVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chang Young Kim
 * @see ees_mnr_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0017Event(){}

	/** Agreement Attach 조회 조건 및 단건 처리  */
	private AgmtAtchDataVO agmtAtchDataVO = null;
	/** Agreement Attach Multi Data 처리 */
	private AgmtAtchDataVO[] agmtAtchDataVOs = null;
	
	public AgmtAtchDataVO getAgmtAtchDataVO() {
		return agmtAtchDataVO;
	}
	
	public AgmtAtchDataVO[] getAgmtAtchDataVOS(){
		return agmtAtchDataVOs;
	}
	
	public void setAgmtAtchDataVO(AgmtAtchDataVO agmtAtchDataVO) {
		this.agmtAtchDataVO = agmtAtchDataVO;
	}
	
	public void setAgmtAtchDataVOS(AgmtAtchDataVO[] agmtAtchDataVOs){
		this.agmtAtchDataVOs = agmtAtchDataVOs;
	}
}