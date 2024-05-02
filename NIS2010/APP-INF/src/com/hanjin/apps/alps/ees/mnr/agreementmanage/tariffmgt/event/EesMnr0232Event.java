/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0232Event.java
*@FileTitle : Disposal Tariff by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.30 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfDtlVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtListVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0232 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0232HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YoungBueb Kwon
 * @see ees_mnr_0232HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0232Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0232Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalTariffINVO disposalTariffINVO = null;

	private DisposalTariffQuarterVO disposalTariffQuarterVO = null;

	/** Table Value Object Multi Data 처리 */
	private CustomMnrDispTrfHdrVO   customMnrDispTrfHdrVO = null;
	private CustomMnrDispTrfDtlVO[] arrayCustomMnrDispTrfDtlVOs = null;

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
		return arrayCustomMnrDispTrfDtlVOs;
	}
	public void setArrayCustomMnrDispTrfDtlVOs(
			CustomMnrDispTrfDtlVO[] arrayCustomMnrDispTrfDtlVOs) {
		this.arrayCustomMnrDispTrfDtlVOs = arrayCustomMnrDispTrfDtlVOs;
	}

	/**
	 * @return the disposalTariffQuarterVO
	 */
	public DisposalTariffQuarterVO getDisposalTariffQuarterVO() {
		return disposalTariffQuarterVO;
	}
	/**
	 * @param disposalTariffQuarterVO the disposalTariffQuarterVO to set
	 */
	public void setDisposalTariffQuarterVO(
			DisposalTariffQuarterVO disposalTariffQuarterVO) {
		this.disposalTariffQuarterVO = disposalTariffQuarterVO;
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