/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0058Event.java
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

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpMnSCCpVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Baek Jin
 * @see ESM_PRI_0058HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0058Event extends EventSupport {
//RsltPriSpMnSCCpVO
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstPriSpMnFileVO cstPriSpMnFileVO = null;
	



	public CstPriSpMnFileVO getCstPriSpMnFileVO() {
		return cstPriSpMnFileVO;
	}

	public void setCstPriSpMnFileVO(CstPriSpMnFileVO cstPriSpMnFileVO) {
		this.cstPriSpMnFileVO = cstPriSpMnFileVO;
	}


	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstPriSpMnFileDtVO cstPriSpMnFileDtVO = null;

	/** Table Value Object Multi Data 처리 */
    private CstPriSpMnFileDtVO[] cstPriSpMnFileDtVOs = null;


	public CstPriSpMnFileDtVO[] getCstPriSpMnFileDtVOs() {
		return cstPriSpMnFileDtVOs;
	}

	public void setCstPriSpMnFileDtVOs(CstPriSpMnFileDtVO[] cstPriSpMnFileDtVOs) {
		this.cstPriSpMnFileDtVOs = cstPriSpMnFileDtVOs;
	}

	public CstPriSpMnFileDtVO getCstPriSpMnFileDtVO() {
		return cstPriSpMnFileDtVO;
	}

	public void setCstPriSpMnFileDtVO(CstPriSpMnFileDtVO cstPriSpMnFileDtVO) {
		this.cstPriSpMnFileDtVO = cstPriSpMnFileDtVO;
	}

	public PriSpMnVO getPriSpMnVO() {
		return priSpMnVO;
	}

	public void setPriSpMnVO(PriSpMnVO priSpMnVO) {
		this.priSpMnVO = priSpMnVO;
	}


	/** Table Value Object Multi Data 처리 */
    private RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs = null;
    



	public RsltPriSpMnSCCpVO[] getRsltPriSpMnSCCpVOs() {
		return rsltPriSpMnSCCpVOs;
	}

	public void setRsltPriSpMnSCCpVOs(RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs) {
		this.rsltPriSpMnSCCpVOs = rsltPriSpMnSCCpVOs;
	}


	public EsmPri0058Event(){}


	
}