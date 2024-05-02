/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0154Event.java
*@FileTitle : Disposal Tariff by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.09.23 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event;

import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfDtlVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtListVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0154 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YoungBueb Kwon
 * @see ees_mnr_0154HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0154Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0154Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalTariffINVO disposalTariffINVO = null;

	private DisposalTariffRegionVO disposalTariffRegionVO = null;

	/** Table Value Object Multi Data 처리 */
	private CustomMnrDispTrfHdrVO   customMnrDispTrfHdrVO = null;
	private CustomMnrDispTrfDtlVO[] arrayCustomMnrDispTrfDtlVOs = null;
	private DisposalTariffRegionVO[] disposalTariffRegionVOs = null;

	public DisposalTariffINVO getDisposalTariffINVO() {
		return disposalTariffINVO;
	}
	public void setDisposalTariffINVO(DisposalTariffINVO disposalTariffINVO) {
		this.disposalTariffINVO = disposalTariffINVO;
	}
	public CustomMnrDispTrfHdrVO getCustomMnrDispTrfHdrVO() {
		return customMnrDispTrfHdrVO;
	}
	public void setCustomMnrDispTrfHdrVO(CustomMnrDispTrfHdrVO customMnrDispTrfHdrVO) {
		this.customMnrDispTrfHdrVO = customMnrDispTrfHdrVO;
	}
	public CustomMnrDispTrfDtlVO[] getArrayCustomMnrDispTrfDtlVOs() {
		CustomMnrDispTrfDtlVO[] rtnVOs = null;
		if (this.arrayCustomMnrDispTrfDtlVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(arrayCustomMnrDispTrfDtlVOs, arrayCustomMnrDispTrfDtlVOs.length);
		}
		return rtnVOs;
	}
	public void setArrayCustomMnrDispTrfDtlVOs(CustomMnrDispTrfDtlVO[] arrayCustomMnrDispTrfDtlVOs){
		if(arrayCustomMnrDispTrfDtlVOs != null){
			CustomMnrDispTrfDtlVO[] tmpVOs = java.util.Arrays.copyOf(arrayCustomMnrDispTrfDtlVOs, arrayCustomMnrDispTrfDtlVOs.length);
			this.arrayCustomMnrDispTrfDtlVOs = tmpVOs;
		}
	}

	/**
	 * @return the disposalTariffRegionVO
	 */
	public DisposalTariffRegionVO getDisposalTariffRegionVO() {
		return disposalTariffRegionVO;
	}
	/**
	 * @param disposalTariffRegionVO the disposalTariffRegionVO to set
	 */
	public void setDisposalTariffRegionVO(
			DisposalTariffRegionVO disposalTariffRegionVO) {
		this.disposalTariffRegionVO = disposalTariffRegionVO;
	}

	/**
	 * @return the disposalTariffRegionVOs
	 */
	public DisposalTariffRegionVO[] getDisposalTariffRegionVOs() {
		DisposalTariffRegionVO[] rtnVOs = null;
		if (this.disposalTariffRegionVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(disposalTariffRegionVOs, disposalTariffRegionVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param disposalTariffRegionVOs the disposalTariffRegionVOs to set
	 */
	public void setDisposalTariffRegionVOs(DisposalTariffRegionVO[] disposalTariffRegionVOs){
		if(disposalTariffRegionVOs != null){
			DisposalTariffRegionVO[] tmpVOs = java.util.Arrays.copyOf(disposalTariffRegionVOs, disposalTariffRegionVOs.length);
			this.disposalTariffRegionVOs = tmpVOs;
		}
	}

	//조회조건을 받기위한
	private DisposalTariffEffDtINVO disposalTariffEffDtINVO = null;
	//단건조회 결과를 받기위한
	private List<DisposalTariffEffDtListVO> disposalTariffEffDtListVOs = null;

	public DisposalTariffEffDtINVO getDisposalTariffEffDtINVO() {
		return disposalTariffEffDtINVO;
	}
	public void setDisposalTariffEffDtINVO(DisposalTariffEffDtINVO disposalTariffEffDtINVO) {
		this.disposalTariffEffDtINVO = disposalTariffEffDtINVO;
	}
	public List<DisposalTariffEffDtListVO> getDisposalTariffEffDtListVOs() {
		return disposalTariffEffDtListVOs;
	}
	public void setDisposalTariffEffDtListVOs(
			List<DisposalTariffEffDtListVO> disposalTariffEffDtListVOs) {
		this.disposalTariffEffDtListVOs = disposalTariffEffDtListVOs;
	}

}