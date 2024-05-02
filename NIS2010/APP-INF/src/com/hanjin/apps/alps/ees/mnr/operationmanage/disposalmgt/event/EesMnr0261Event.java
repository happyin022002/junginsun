/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EesMnr0258Event.java
*@FileTitle : Hanger Rack/Bar Using Report Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 신혜정 
*@LastVersion : 1.0
* 2012.04.12 신혜정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.framework.support.layer.event.EventSupport;
         
/** 
 * EES_MNR_0261 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0261HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 신혜정 
 * @see EES_MNR_0261HTMLAction 참조
 * @since J2EE 1.4 
 */
public class EesMnr0261Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalNVO disposalINVO = null;

	public EesMnr0261Event(){}

	public DisposalNVO getDisposalNVO() {
		return disposalINVO;
	}

	public void setDisposalNVO(DisposalNVO disposalINVO) {
		this.disposalINVO = disposalINVO;
	}
	
}