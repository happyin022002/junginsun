/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0008Event.java
*@FileTitle : Land Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_0008HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EesCim0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvtSmryVO invtSmryVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvtOptionVO invtOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrendListVO[] trendListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtSmryVO[] invtSmryVOs = null;

	public EesCim0008Event(){}
	
	public void setInvtSmryVO(InvtSmryVO invtSmryVO){
		this. invtSmryVO = invtSmryVO;
	}

	public void setTrendListVOS(TrendListVO[] trendListVOs){
		if (trendListVOs != null) {
			TrendListVO[] tmpVOs = Arrays.copyOf(trendListVOs, trendListVOs.length);
			this.trendListVOs = tmpVOs;
		}
	}
	public void setInvtSmryVOs(InvtSmryVO[] invtSmryVOs){
		if (invtSmryVOs != null) {
			InvtSmryVO[] tmpVOs = Arrays.copyOf(invtSmryVOs, invtSmryVOs.length);
			this.invtSmryVOs = tmpVOs;
		}
	}
	public InvtSmryVO getInvtSmryVO(){
		return invtSmryVO;
	}

	public TrendListVO[] getTrendListVOS(){
		TrendListVO[] rtnVOs = null;
		if (this.trendListVOs != null) {
			rtnVOs = Arrays.copyOf(trendListVOs, trendListVOs.length);
		}
		return rtnVOs;
	}
	public InvtSmryVO[] getInvtSmryVOs(){
		InvtSmryVO[] rtnVOs = null;
		if (this.invtSmryVOs != null) {
			rtnVOs = Arrays.copyOf(invtSmryVOs, invtSmryVOs.length);
		}
		return rtnVOs;
	}	
	public void setInvtOptionVO(InvtOptionVO invtOptionVO){
		this.invtOptionVO = invtOptionVO;
	}
	public InvtOptionVO getInvtOptionVO(){
		return invtOptionVO;
	}	

}