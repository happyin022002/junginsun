/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TariffContainerVO.java
*@FileTitle : TariffContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.09.04 진마리아 
* 1.0 Creation
*
* History
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffGRPVO {

	private static final long serialVersionUID = 1L;
	
	/** simulation by vvd 정보 */ 
	private List<TariffSimByVvdVO> tariffSimByVvdVOs = null;

	/** detail 정보(0039 excel위한) */
	private List<CalcTariffResultVO> calcTariffResultVOs = null;
	
	private Map<String, String> yards;
	private Map<String, String> accts;
	
	public TariffGRPVO() {}

	public List<TariffSimByVvdVO> getTariffSimByVvdVOs() {
		return tariffSimByVvdVOs;
	}

	public void setTariffSimByVvdVOs(List<TariffSimByVvdVO> tariffSimByVvdVOs) {
		this.tariffSimByVvdVOs = tariffSimByVvdVOs;
	}
	
	public List<CalcTariffResultVO> getCalcTariffResultVOs() {
		return calcTariffResultVOs;
	}

	public void setCalcTariffResultVOs(List<CalcTariffResultVO> calcTariffResultVOs) {
		this.calcTariffResultVOs = calcTariffResultVOs;
	}

	public Map<String, String> getYards() {
		return yards;
	}

	public void setYards(Map<String, String> yards) {
		this.yards = yards;
	}

	public Map<String, String> getAccts() {
		return accts;
	}

	public void setAccts(Map<String, String> accts) {
		this.accts = accts;
	}

}
