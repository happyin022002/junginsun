/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1068Event.java
*@FileTitle : TPB Issue Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.27 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_1068HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bkgNo = "";
	
	private String ntcSeq = "";
	
	private TpbInfoVO  tpbInfoVO = null;
	
	private TpbInfoVO[] tpbInfoVOs = null;
	
		
	public EsmBkg1068Event(){}
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param ntcSeq the ntcSeq to set
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
	}

	/**
	 * @return the ntcSeq
	 */
	public String getNtcSeq() {
		return ntcSeq;
	}

	/**
	 * @param tpbInfoVO the tpbInfoVO to set
	 */
	public void setTpbInfoVO(TpbInfoVO tpbInfoVO) {
		this.tpbInfoVO = tpbInfoVO;
	}

	/**
	 * @return the tpbInfoVO
	 */
	public TpbInfoVO getTpbInfoVO() {
		return tpbInfoVO;
	}

	/**
	 * @param tpbInfoVOs the tpbInfoVOs to set
	 */
	public void setTpbInfoVOs(TpbInfoVO[] tpbInfoVOs) {
		this.tpbInfoVOs = tpbInfoVOs;
	}

	/**
	 * @return the tpbInfoVOs
	 */
	public TpbInfoVO[] getTpbInfoVOs() {
		return tpbInfoVOs;
	}
}