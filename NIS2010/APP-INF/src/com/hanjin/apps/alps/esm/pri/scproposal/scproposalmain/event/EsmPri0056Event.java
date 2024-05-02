/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0056Event.java
*@FileTitle : S/C No. Assignement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.10 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpMnSCCpVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpHdrVO;


/**
 * ESM_PRI_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Baek Jin
 * @see ESM_PRI_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0056Event extends EventSupport {
//RsltPriSpMnSCCpVO
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	private CstPriSpHdrVO cstPriSpHdrVO = null;

    public CstPriSpHdrVO getCstPriSpHdrVO() {
		return cstPriSpHdrVO;
	}

	public void setCstPriSpHdrVO(CstPriSpHdrVO cstPriSpHdrVO) {
		this.cstPriSpHdrVO = cstPriSpHdrVO;
	}

	public PriSpHdrVO getPriSpHdrVO() {
		return priSpHdrVO;
	}

	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO) {
		this.priSpHdrVO = priSpHdrVO;
	}


	/** Table Value Object Multi Data 처리 */
    private RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs = null;
    



	public RsltPriSpMnSCCpVO[] getRsltPriSpMnSCCpVOs() {
		return rsltPriSpMnSCCpVOs;
	}

	public void setRsltPriSpMnSCCpVOs(RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs) {
		this.rsltPriSpMnSCCpVOs = rsltPriSpMnSCCpVOs;
	}


	public EsmPri0056Event(){}


	
}