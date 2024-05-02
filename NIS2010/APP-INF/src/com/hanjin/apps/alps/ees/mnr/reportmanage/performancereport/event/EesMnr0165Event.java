/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0165Event.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.28 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByOfficeVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRegionGRPVO;


/**
 * EES_MNR_0165 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0165HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0165HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0165Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalPFMCByRegionGRPVO disposalPFMCByRegionGRPVO = null;
	private DisposalPFMCByOfficeVO disposalPFMCByOfficeVO = null;

	/** Table Value Object Multi Data 처리 */
	private DisposalPFMCByEQGRPVO[] disposalPFMCByEQGRPVOs = null;

	public EesMnr0165Event(){}

	public void setDisposalPFMCByRegionGRPVO(DisposalPFMCByRegionGRPVO disposalPFMCByRegionGRPVO){
		this. disposalPFMCByRegionGRPVO = disposalPFMCByRegionGRPVO;
	}

	public void setDisposalPFMCByEQGRPVOS(DisposalPFMCByEQGRPVO[] disposalPFMCByEQGRPVOs){
		this. disposalPFMCByEQGRPVOs = disposalPFMCByEQGRPVOs;
	}

	public DisposalPFMCByRegionGRPVO getDisposalPFMCByRegionGRPVO(){
		return disposalPFMCByRegionGRPVO;
	}

	public DisposalPFMCByEQGRPVO[] getDisposalPFMCByEQGRPVOS(){
		return disposalPFMCByEQGRPVOs;
	}

	/**
	 * @return the disposalPFMCByOfficeVO
	 */
	public DisposalPFMCByOfficeVO getDisposalPFMCByOfficeVO() {
		return disposalPFMCByOfficeVO;
	}

	/**
	 * @param disposalPFMCByOfficeVO the disposalPFMCByOfficeVO to set
	 */
	public void setDisposalPFMCByOfficeVO(
			DisposalPFMCByOfficeVO disposalPFMCByOfficeVO) {
		this.disposalPFMCByOfficeVO = disposalPFMCByOfficeVO;
	}
}