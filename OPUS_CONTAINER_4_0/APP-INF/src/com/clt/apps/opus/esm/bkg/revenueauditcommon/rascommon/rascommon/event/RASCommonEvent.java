/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PricommonEvent.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.16 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmChargeVO;


/**
 * RASCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  PRICommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see RASCommonHTMLAction 참조
 * @since J2EE 1.6
 */

public class RASCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCdListVO rsltCdListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltCdListVO[] rsltCdListVOs = null;
	
	private MdmChargeVO mdmChargeVO = null;
	
	public RASCommonEvent(){}

	/**
	 * @return the rsltCdListVO
	 */
	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	/**
	 * @param rsltCdListVO the rsltCdListVO to set
	 */
	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}

	/**
	 * @return the mdmChargeVO
	 */
	public MdmChargeVO getMdmChargeVO() {
		return mdmChargeVO;
	}

	public RsltCdListVO[] getRsltCdListVOs() {
		RsltCdListVO[] rtnVOs = null;
		if (this.rsltCdListVOs != null) {
			rtnVOs = Arrays.copyOf(rsltCdListVOs, rsltCdListVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltCdListVOs(RsltCdListVO[] rsltCdListVOs) {
		if (rsltCdListVOs != null) {
			RsltCdListVO[] tmpVOs = Arrays.copyOf(rsltCdListVOs, rsltCdListVOs.length);
			this.rsltCdListVOs = tmpVOs;
		}
	}

	/**
	 * @param mdmChargeVO the mdmChargeVO to set
	 */
	public void setMdmChargeVO(MdmChargeVO mdmChargeVO) {
		this.mdmChargeVO = mdmChargeVO;
	}


}