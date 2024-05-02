/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0166Event.java
*@FileTitle : Disposal PFMC by EQ
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.30 민정호
* 1.0 Creation
*========================================================
* 2010.11.30 남궁진호 [CHM-201007327_01] Disposal Performance 화면에서 장비별 Detail 내역을 팝업으로 조회
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQListVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;


/**
 * EES_MNR_0166 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0166HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0166HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0166Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalPFMCByEQVO disposalPFMCByEQVO = null;

	private DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private DisposalPFMCByEQListVO[] disposalPFMCByEQListVOs = null;

	public EesMnr0166Event(){}

	public void setDisposalPFMCByEQVO(DisposalPFMCByEQVO disposalPFMCByEQVO){
		this. disposalPFMCByEQVO = disposalPFMCByEQVO;
	}

	public void setDisposalPFMCByEQListVOS(DisposalPFMCByEQListVO[] disposalPFMCByEQListVOs){
		this. disposalPFMCByEQListVOs = disposalPFMCByEQListVOs;
	}

	public DisposalPFMCByEQVO getDisposalPFMCByEQVO(){
		return disposalPFMCByEQVO;
	}

	public DisposalPFMCByEQListVO[] getDisposalPFMCByEQListVOS(){
		return disposalPFMCByEQListVOs;
	}

	/**
	 * @return the disposalPFMCByEqDetailVO
	 */
	public DisposalPFMCByEqDetailVO getDisposalPFMCByEqDetailVO() {
		return disposalPFMCByEqDetailVO;
	}

	/**
	 * @param disposalPFMCByEqDetailVO the disposalPFMCByEqDetailVO to set
	 */
	public void setDisposalPFMCByEqDetailVO(
			DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO) {
		this.disposalPFMCByEqDetailVO = disposalPFMCByEqDetailVO;
	}
}