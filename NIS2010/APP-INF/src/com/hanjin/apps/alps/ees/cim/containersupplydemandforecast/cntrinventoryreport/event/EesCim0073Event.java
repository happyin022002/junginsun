/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0073Event.java
*@FileTitle : Land Inventory with Optimum Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.02.18 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author doo ki min
 * @see EES_CIM_0073HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EesCim0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrendListVO trendListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvtOptionVO invtOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrendListVO[] trendListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtOptionVO[] invtOptionVOs = null;

	public EesCim0073Event(){}
	
	public void setTrendListVO(TrendListVO trendListVO){
		this. trendListVO = trendListVO;
	}

	public void setTrendListVOS(TrendListVO[] trendListVOs){
			if (trendListVOs != null) {
			TrendListVO[] tmpVOs = Arrays.copyOf(trendListVOs, trendListVOs.length);
			this.trendListVOs = tmpVOs;
		}
	}
	public void setInvtOptionVOS(InvtOptionVO[] invtOptionVOs){
			if (invtOptionVOs != null) {
			InvtOptionVO[] tmpVOs = Arrays.copyOf(invtOptionVOs, invtOptionVOs.length);
			this.invtOptionVOs = tmpVOs;
		}
	}
	public TrendListVO getTrendListVO(){
		return trendListVO;
	}

	public TrendListVO[] getTrendListVOS(){
		TrendListVO[] rtnVOs = null;
		if (this.trendListVOs != null) {
			rtnVOs = Arrays.copyOf(trendListVOs, trendListVOs.length);
		}
		return rtnVOs;
	}
	public InvtOptionVO[] getInvtOptionVOS(){
		InvtOptionVO[] rtnVOs = null;
		if (this.invtOptionVOs != null) {
			rtnVOs = Arrays.copyOf(invtOptionVOs, invtOptionVOs.length);
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