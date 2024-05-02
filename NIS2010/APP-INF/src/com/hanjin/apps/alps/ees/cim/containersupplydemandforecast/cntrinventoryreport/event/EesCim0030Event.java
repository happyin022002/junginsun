/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0030Event.java
*@FileTitle : Stock Report (Due Data)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.13 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_0030HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EesCim0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private StockByCntrListVO stockByCntrListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvtOptionVO invtOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private StockByCntrListVO[] stockByCntrListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtOptionVO[] invtOptionVOs = null;

	public EesCim0030Event(){}
	
	public void setStockByCntrListVO(StockByCntrListVO stockByCntrListVO){
		this. stockByCntrListVO = stockByCntrListVO;
	}

	public void setStockByCntrListVOS(StockByCntrListVO[] stockByCntrListVOs){
		if (stockByCntrListVOs != null) {
			StockByCntrListVO[] tmpVOs = Arrays.copyOf(stockByCntrListVOs, stockByCntrListVOs.length);
			this.stockByCntrListVOs = tmpVOs;
		}
	}
	public void setInvtOptionVOS(InvtOptionVO[] invtOptionVOs){
		if (invtOptionVOs != null) {
			InvtOptionVO[] tmpVOs = Arrays.copyOf(invtOptionVOs, invtOptionVOs.length);
			this.invtOptionVOs = tmpVOs;
		}
	}
	public StockByCntrListVO getStockByCntrListVO(){
		return stockByCntrListVO;
	}

	public StockByCntrListVO[] getStockByCntrListVOS(){
		StockByCntrListVO[] rtnVOs = null;
		if (this.stockByCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(stockByCntrListVOs, stockByCntrListVOs.length);
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