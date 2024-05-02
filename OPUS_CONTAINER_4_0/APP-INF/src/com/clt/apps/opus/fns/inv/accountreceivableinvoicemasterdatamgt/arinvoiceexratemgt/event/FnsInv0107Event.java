/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FnsInv0107Event.java
*@FileTitle : VVD Ex. Rate Date History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.21
*@LastModifier : IY Cho
*@LastVersion : 1.0
* 2014.11.21 IY Cho
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateDateHisVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author IY Cho
 * @see FNS_INV_0107HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VVDExrateDateHisVO vvdExrateDateHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VVDExrateDateHisVO[] vvdExrateDateHisVOs = null;
	
	private String ofcCd = "";
	
	private String vvd	= null; 
	
	public FnsInv0107Event(){}


	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public VVDExrateDateHisVO getVvdExrateDateHisVO() {
		return vvdExrateDateHisVO;
	}

	public void setVvdExrateDateHisVO(VVDExrateDateHisVO vvdExrateDateHisVO) {
		this.vvdExrateDateHisVO = vvdExrateDateHisVO;
	}

	public VVDExrateDateHisVO[] getVvdExrateDateHisVOs() {
		VVDExrateDateHisVO[] rtnVOs = null;
		if (this.vvdExrateDateHisVOs != null) {
			rtnVOs = new VVDExrateDateHisVO[vvdExrateDateHisVOs.length];
			System.arraycopy(vvdExrateDateHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setVvdExrateDateHisVOs(VVDExrateDateHisVO[] vvdExrateDateHisVOs) {
		if (vvdExrateDateHisVOs != null) {
			VVDExrateDateHisVO[] tmpVOs = new VVDExrateDateHisVO[vvdExrateDateHisVOs.length];
			System.arraycopy(vvdExrateDateHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdExrateDateHisVOs = tmpVOs;
		}
	}
	

}