/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0034Event.java
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_0034HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EesCim0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailListVO availListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailOptionVO availOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AvailListVO[] availListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private AvailOptionVO[] availOptionVOs = null;

	public EesCim0034Event(){}
	
	public void setAvailListVO(AvailListVO availListVO){
		this. availListVO = availListVO;
	}

	public void setAvailListVOS(AvailListVO[] availListVOs){
		if (availListVOs != null) {
			AvailListVO[] tmpVOs = Arrays.copyOf(availListVOs, availListVOs.length);
			this.availListVOs = tmpVOs;
		}
	}
	public void setAvailOptionVOS(AvailOptionVO[] availOptionVOs){
			if (availOptionVOs != null) {
			AvailOptionVO[] tmpVOs = Arrays.copyOf(availOptionVOs, availOptionVOs.length);
			this.availOptionVOs = tmpVOs;
		}
	}
	public AvailListVO getAvailListVO(){
		return availListVO;
	}

	public AvailListVO[] getAvailListVOS(){
		AvailListVO[] rtnVOs = null;
		if (this.availListVOs != null) {
			rtnVOs = Arrays.copyOf(availListVOs, availListVOs.length);
		}
		return rtnVOs;
	}
	public AvailOptionVO[] getAavailOptionVOS(){
		AvailOptionVO[] rtnVOs = null;
		if (this.availOptionVOs != null) {
			rtnVOs = Arrays.copyOf(availOptionVOs, availOptionVOs.length);
		}
		return rtnVOs;
	}	
	public void setAvailOptionVO(AvailOptionVO availOptionVO){
		this.availOptionVO = availOptionVO;
	}
	public AvailOptionVO getAvailOptionVO(){
		return availOptionVO;
	}	

}