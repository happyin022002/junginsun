/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0006Event.java
*@FileTitle : Ex. Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.24 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvVvdXchRtVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;


/**
 * FNS_INV-0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV-0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV-0006HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVVDExRateVO searchVVDExRateVO = null;
	private MdmSvcScpVO mdmSvcScpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvVvdXchRtVO[] invVvdXchRtVOs = null;

	public FnsInv0006Event(){}
	
	public void setSearchVVDExRateVO(SearchVVDExRateVO searchVVDExRateVO){
		this. searchVVDExRateVO = searchVVDExRateVO;
	}

	public SearchVVDExRateVO getSearchVVDExRateVO(){
		return searchVVDExRateVO;
	}

	public InvVvdXchRtVO[] getInvVvdXchRtVOs() {
		InvVvdXchRtVO[] rtnVOs = null;
		if (this.invVvdXchRtVOs != null) {
			rtnVOs = new InvVvdXchRtVO[invVvdXchRtVOs.length];
			System.arraycopy(invVvdXchRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setInvVvdXchRtVOs(InvVvdXchRtVO[] invVvdXchRtVOs) {
		if (invVvdXchRtVOs != null) {
			InvVvdXchRtVO[] tmpVOs = new InvVvdXchRtVO[invVvdXchRtVOs.length];
			System.arraycopy(invVvdXchRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invVvdXchRtVOs = tmpVOs;
		}
	}

	/**
	 * @return the mdmSvcScpVO
	 */
	public MdmSvcScpVO getMdmSvcScpVO() {
		return mdmSvcScpVO;
	}

	/**
	 * @param mdmSvcScpVO the mdmSvcScpVO to set
	 */
	public void setMdmSvcScpVO(MdmSvcScpVO mdmSvcScpVO) {
		this.mdmSvcScpVO = mdmSvcScpVO;
	}

	
	

}