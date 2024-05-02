/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalTariffQuarterGRPVO.java
*@FileTitle : DisposalTariffQuarterGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.30 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see DisposalTariffQuarterVO
 */

public class DisposalTariffQuarterGRPVO {

	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo");

	/** Table Value Object Multi Data 처리 */
	private List<List<DisposalTariffQuarterVO>> disposalTariffQuarterVOs = null;

	/**
	 * @return the disposalTariffQuarterVOs
	 */
	public List<List<DisposalTariffQuarterVO>> getDisposalTariffQuarterVOs() {
		return disposalTariffQuarterVOs;
	}

	/**
	 * @param disposalTariffQuarterVOs the disposalTariffQuarterVOs to set
	 */
	public void setDisposalTariffQuarterVOs(List<List<DisposalTariffQuarterVO>> disposalTariffQuarterVOs) {
		this.disposalTariffQuarterVOs = disposalTariffQuarterVOs;
	}
}
