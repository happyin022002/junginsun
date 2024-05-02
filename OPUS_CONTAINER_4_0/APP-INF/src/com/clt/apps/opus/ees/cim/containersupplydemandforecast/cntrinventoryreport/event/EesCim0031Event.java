/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim0031Event.java
 *@FileTitle : Stock Report (Detail)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.12
 *@LastModifier : 김종준
 *@LastVersion : 1.0
 * 2009.08.12 김종준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim jong jun
 * @see EES_CIM_0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private StockSmryVO stockSmryVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvtOptionVO invtOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private StockSmryVO[] stockSmryVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtOptionVO[] invtOptionVOs = null;

	public EesCim0031Event() {
	}

	public void setStockSmryVO(StockSmryVO stockSmryVO) {
		this.stockSmryVO = stockSmryVO;
	}

	public void setStockSmryVOS(StockSmryVO[] stockSmryVOs) {
		if (stockSmryVOs != null) {
			StockSmryVO[] tmpVOs = new StockSmryVO[stockSmryVOs.length];
			System.arraycopy(stockSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stockSmryVOs = tmpVOs;
		}
	}

	public void setInvtOptionVOS(InvtOptionVO[] invtOptionVOs) {
		if (invtOptionVOs != null) {
			InvtOptionVO[] tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invtOptionVOs = tmpVOs;
		}
	}

	public StockSmryVO getStockSmryVO() {
		return stockSmryVO;
	}

	public StockSmryVO[] getStockSmryVOS() {
		StockSmryVO[] tmpVOs = null;
		if (this.stockSmryVOs != null) {
			tmpVOs = new StockSmryVO[stockSmryVOs.length];
			System.arraycopy(stockSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
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