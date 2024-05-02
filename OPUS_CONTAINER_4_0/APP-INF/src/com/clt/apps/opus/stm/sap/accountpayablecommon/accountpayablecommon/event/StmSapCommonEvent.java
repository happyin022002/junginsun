/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSapCommonEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TaxCodeVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayableCommonSC 실행요청<br>
 * - AccountPayableCommonSC View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see StmSapCommonEvent 참조
 * @since J2EE 1.6
 */

public class StmSapCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SapCommonVO sapCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private SapCommonVO[] sapCommonVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TaxCodeVO taxCodeVO = null;

	/** Table Value Object Multi Data 처리 */
	private TaxCodeVO[] taxCodeVOs = null;	

	public StmSapCommonEvent() {}

	public SapCommonVO getSapCommonVO() {
		return sapCommonVO;
	}

	public void setSapCommonVO(SapCommonVO sapCommonVO) {
		this.sapCommonVO = sapCommonVO;
	}

	public SapCommonVO[] getSapCommonVOs() {
		SapCommonVO[] rtnVOs = null;
		if(this.sapCommonVOs != null) {
			rtnVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setSapCommonVOs(SapCommonVO[] sapCommonVOs) {
		if(sapCommonVOs != null) {
			SapCommonVO[] tmpVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sapCommonVOs = tmpVOs;
		}
	}

	public TaxCodeVO getTaxCodeVO() {
		return taxCodeVO;
	}

	public void setTaxCodeVO(TaxCodeVO taxCodeVO) {
		this.taxCodeVO = taxCodeVO;
	}

	public TaxCodeVO[] getTaxCodeVOs() {
		TaxCodeVO[] rtnVOs = null;
		if(this.taxCodeVOs != null) {
			rtnVOs = new TaxCodeVO[taxCodeVOs.length];
			System.arraycopy(taxCodeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTaxCodeVOs(TaxCodeVO[] taxCodeVOs) {
		if(taxCodeVOs != null) {
			TaxCodeVO[] tmpVOs = new TaxCodeVO[taxCodeVOs.length];
			System.arraycopy(taxCodeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.taxCodeVOs = tmpVOs;
		}

	}	

}