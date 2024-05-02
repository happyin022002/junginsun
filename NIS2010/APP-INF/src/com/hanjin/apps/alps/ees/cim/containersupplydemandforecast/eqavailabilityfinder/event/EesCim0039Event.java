/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0039Event.java
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

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_0039HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EesCim0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailRepoListVO availRepoListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailOptionVO availOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AvailRepoListVO[] availRepoListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private AvailOptionVO[] availOptionVOs = null;

	public EesCim0039Event(){}
	
	public void setAvailRepoListVO(AvailRepoListVO availRepoListVO){
		this. availRepoListVO = availRepoListVO;
	}

	public void setAvailListVOS(AvailRepoListVO[] availRepoListVOs){
		if (availRepoListVOs != null) {
			AvailRepoListVO[] tmpVOs = Arrays.copyOf(availRepoListVOs, availRepoListVOs.length);
			this.availRepoListVOs = tmpVOs;
		}
	}
	public void setAvailOptionVOS(AvailOptionVO[] availOptionVOs){
		if (availOptionVOs != null) {
			AvailOptionVO[] tmpVOs = Arrays.copyOf(availOptionVOs, availOptionVOs.length);
			this.availOptionVOs = tmpVOs;
		}
	}
	public AvailRepoListVO getAvailRepoListVO(){
		return availRepoListVO;
	}

	public AvailRepoListVO[] getAvailRepoListVOS(){
		AvailRepoListVO[] rtnVOs = null;
		if (this.availRepoListVOs != null) {
			rtnVOs = Arrays.copyOf(availRepoListVOs, availRepoListVOs.length);
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