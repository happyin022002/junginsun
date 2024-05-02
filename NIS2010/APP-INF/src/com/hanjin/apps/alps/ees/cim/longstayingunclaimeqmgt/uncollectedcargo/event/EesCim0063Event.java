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

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
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

public class EesCim0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String intgCdId = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private UncollectedCargoVO  uncollectedCargoVO  = null;
	
	/** Table Value Object Multi Data 처리 */
	private UncollectedCargoVO [] uncollectedCargoVOs = null;

	public EesCim0063Event(){}
	
	public void setUncollectedCargoVO (UncollectedCargoVO  uncollectedCargoVO ){
		this. uncollectedCargoVO  = uncollectedCargoVO ;
	}

	public void setUncollectedCargoVOS(UncollectedCargoVO [] uncollectedCargoVOs){
		if (uncollectedCargoVOs != null) {
			UncollectedCargoVO[] tmpVOs = Arrays.copyOf(uncollectedCargoVOs, uncollectedCargoVOs.length);
			this.uncollectedCargoVOs = tmpVOs;
		}
	}

	public UncollectedCargoVO  getUncollectedCargoVO (){
		return uncollectedCargoVO ;
	}

	public UncollectedCargoVO [] getUncollectedCargoVOS(){
			UncollectedCargoVO[] rtnVOs = null;
		if (this.uncollectedCargoVOs != null) {
			rtnVOs = Arrays.copyOf(uncollectedCargoVOs, uncollectedCargoVOs.length);
		}
		return rtnVOs;
	}
	
	public String getIntgCdId() {
		return intgCdId;
	}

	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}
}