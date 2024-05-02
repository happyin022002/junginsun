/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0228Event.java
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
* 2011.06.24 손은주 [CHM-201111279-01] s-si Process 개선 사항 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySiValAutoVO;

/**
 * ESM_BKG_0228 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0228HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0228HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0228Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExternalRqstListInputVO xterRqstListInputVO = null;

	/** Table Value Object Multi Data 처리 */
	private ExternalRqstListInputVO[] xterRqstListInputVOs = null;

	/** Table Value Object Multi Data 처리 */
	private XterRqstNoVO[] xterRqstNoVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgComboVO bkgcombovo = null;

	/** Table Value Object Multi Data 처리 */
	private BkgComboVO[] bkgcombovos = null;
	
	/** Table Value Object 단건 처리 */
	private ModifySiValAutoVO modifySiValAutoVO = null;

	private String msg;
	private String commit;
	
	public EsmBkg0228Event(){}

	public ExternalRqstListInputVO getXterRqstListInputVO() {
		return xterRqstListInputVO;
	}

	public void setXterRqstListInputVO(ExternalRqstListInputVO xterRqstListInputVO) {
		this.xterRqstListInputVO = xterRqstListInputVO;
	}

	public ExternalRqstListInputVO[] getXterRqstListInputVOs() {
		ExternalRqstListInputVO[] rtnVOs = null;
		if (this.xterRqstListInputVOs != null) {
			rtnVOs = Arrays.copyOf(xterRqstListInputVOs, xterRqstListInputVOs.length);
		}
		return rtnVOs;
	}

	public void setXterRqstListInputVOs(ExternalRqstListInputVO[] xterRqstListInputVOs){
		if(xterRqstListInputVOs != null){
			ExternalRqstListInputVO[] tmpVOs = Arrays.copyOf(xterRqstListInputVOs, xterRqstListInputVOs.length);
			this.xterRqstListInputVOs = tmpVOs;
		}
	}

	public BkgComboVO getBkgcombovo() {
		return bkgcombovo;
	}

	public void setBkgcombovo(BkgComboVO bkgcombovo) {
		this.bkgcombovo = bkgcombovo;
	}

	public BkgComboVO[] getBkgcombovos() {
		BkgComboVO[] rtnVOs = null;
		if (this.bkgcombovos != null) {
			rtnVOs = Arrays.copyOf(bkgcombovos, bkgcombovos.length);
		}
		return rtnVOs;
	}

	public void setBkgcombovos(BkgComboVO[] bkgcombovos){
		if(bkgcombovos != null){
			BkgComboVO[] tmpVOs = Arrays.copyOf(bkgcombovos, bkgcombovos.length);
			this.bkgcombovos = tmpVOs;
		}
	}

	public XterRqstNoVO[] getXterRqstNoVOs() {
		XterRqstNoVO[] rtnVOs = null;
		if (this.xterRqstNoVOs != null) {
			rtnVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
		}
		return rtnVOs;
	}

	public void setXterRqstNoVOs(XterRqstNoVO[] xterRqstNoVOs){
		if(xterRqstNoVOs != null){
			XterRqstNoVO[] tmpVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
			this.xterRqstNoVOs = tmpVOs;
		}
	}

	/**
	 * @param modifySiValAutoVO the modifySiValAutoVO to set
	 */
	public void setModifySiValAutoVO(ModifySiValAutoVO modifySiValAutoVO) {
		this.modifySiValAutoVO = modifySiValAutoVO;
	}

	/**
	 * @return the modifySiValAutoVO
	 */
	public ModifySiValAutoVO getModifySiValAutoVO() {
		return modifySiValAutoVO;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}
}