/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0063Event.java
*@FileTitle : Uncollected Cargo Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 김현주 
*@LastVersion : 1.0
* 2014.06.23 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoAuthorizerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Joo
 * @see EES_CIM_0063HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private UncollectedCargoAuthorizerVO  uncollectedCargoAuthorizerVO  = null;
	
	public UncollectedCargoAuthorizerVO getUncollectedCargoAuthorizerVO() {
		return uncollectedCargoAuthorizerVO;
	}

	public void setUncollectedCargoAuthorizerVO(
			UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) {
		this.uncollectedCargoAuthorizerVO = uncollectedCargoAuthorizerVO;
	}

	public UncollectedCargoAuthorizerVO[] getUncollectedCargoAuthorizerVOs() {
		UncollectedCargoAuthorizerVO[] rtnVOs = null;
		if (this.uncollectedCargoAuthorizerVOs != null) {
			rtnVOs = Arrays.copyOf(uncollectedCargoAuthorizerVOs, uncollectedCargoAuthorizerVOs.length);
		}
		return rtnVOs;
	}

	public void setUncollectedCargoAuthorizerVOs(
			UncollectedCargoAuthorizerVO[] uncollectedCargoAuthorizerVOs) {
		if (uncollectedCargoAuthorizerVOs != null) {
			UncollectedCargoAuthorizerVO[] tmpVOs = Arrays.copyOf(uncollectedCargoAuthorizerVOs, uncollectedCargoAuthorizerVOs.length);
			this.uncollectedCargoAuthorizerVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private UncollectedCargoAuthorizerVO [] uncollectedCargoAuthorizerVOs = null;

	public EesCim0072Event(){}
	

	
}