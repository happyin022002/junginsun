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
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim jong jun
 * @see EES_CIM_0030HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private StockByCntrListVO stockByCntrListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvtOptionVO invtOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private StockByCntrListVO[] stockByCntrListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtOptionVO[] invtOptionVOs = null;

	public EesCim0030Event() {
	}

	public void setStockByCntrListVO(StockByCntrListVO stockByCntrListVO) {
		this.stockByCntrListVO = stockByCntrListVO;
	}

	public void setStockByCntrListVOS(StockByCntrListVO[] stockByCntrListVOs) {
		if (stockByCntrListVOs != null) {
			StockByCntrListVO[] tmpVOs = new StockByCntrListVO[stockByCntrListVOs.length];
			System.arraycopy(stockByCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stockByCntrListVOs = tmpVOs;
		}
	}

	public void setInvtOptionVOS(InvtOptionVO[] invtOptionVOs) {
		if (invtOptionVOs != null) {
			InvtOptionVO[] tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invtOptionVOs = tmpVOs;
		}
	}

	public StockByCntrListVO getStockByCntrListVO() {
		return stockByCntrListVO;
	}

	public StockByCntrListVO[] getStockByCntrListVOS() {
		StockByCntrListVO[] tmpVOs = null;
		if (this.stockByCntrListVOs != null) {
			tmpVOs = new StockByCntrListVO[stockByCntrListVOs.length];
			System.arraycopy(stockByCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public InvtOptionVO[] getInvtOptionVOS() {
		InvtOptionVO[] tmpVOs = null;
		if (this.invtOptionVOs != null) {
			tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setInvtOptionVO(InvtOptionVO invtOptionVO) {
		this.invtOptionVO = invtOptionVO;
	}

	public InvtOptionVO getInvtOptionVO() {
		return invtOptionVO;
	}

}