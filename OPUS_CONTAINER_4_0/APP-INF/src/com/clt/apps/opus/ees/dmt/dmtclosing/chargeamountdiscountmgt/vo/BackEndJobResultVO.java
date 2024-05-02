/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BackEndJobResultVO.java
*@FileTitle : BackEndJobResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2010.02.05 이성훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BackEndJobResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private AfterProgressVO 					afterProgressVO 				= null;
	
	private	List<ChargeCalculationContainerVO>	chargeCalculationContainerVOs	= null;
	
	public void setAfterProgressVO(AfterProgressVO afterProgressVO) {
		this.afterProgressVO = afterProgressVO;
	}
	
	public void setChargeCalculationContainerVOs(List<ChargeCalculationContainerVO>	chargeCalculationContainerVOs) {
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}
	
	public AfterProgressVO getAfterProgressVO() {
		return afterProgressVO;
	}
	
	public List<ChargeCalculationContainerVO> getChargeCalculationContainerVOs() {
		return chargeCalculationContainerVOs;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}
}