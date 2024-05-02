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
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstPriRpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriSpMnSCCpVO;
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
	private PriSpMnVO priSpMnVO = null;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstPriRpMnFileDtVO cstPriRpMnFileDtVO = null;

	/** Table Value Object Multi Data 처리 */
    private CstPriRpMnFileDtVO[] cstPriRpMnFileDtVOs = null;


	public CstPriRpMnFileDtVO[] getCstPriSpMnFileDtVOs() {
		CstPriRpMnFileDtVO[] rtnVOs = null;
		if (this.cstPriRpMnFileDtVOs != null) {
			rtnVOs = new CstPriRpMnFileDtVO[cstPriRpMnFileDtVOs.length];
			System.arraycopy(cstPriRpMnFileDtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCstPriSpMnFileDtVOs(CstPriRpMnFileDtVO[] cstPriSpMnFileDtVOs){
		if(cstPriSpMnFileDtVOs != null){
			CstPriRpMnFileDtVO[] tmpVOs = new CstPriRpMnFileDtVO[cstPriSpMnFileDtVOs.length];
			System.arraycopy(cstPriSpMnFileDtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriRpMnFileDtVOs = tmpVOs;
		}
	}

	public CstPriRpMnFileDtVO getCstPriSpMnFileDtVO() {
		return cstPriRpMnFileDtVO;
	}

	public void setCstPriSpMnFileDtVO(CstPriRpMnFileDtVO cstPriRpMnFileDtVO) {
		this.cstPriRpMnFileDtVO = cstPriRpMnFileDtVO;
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
		RsltPriSpMnSCCpVO[] rtnVOs = null;
		if (this.rsltPriSpMnSCCpVOs != null) {
			rtnVOs = new RsltPriSpMnSCCpVO[rsltPriSpMnSCCpVOs.length];
			System.arraycopy(rsltPriSpMnSCCpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltPriSpMnSCCpVOs(RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs){
		if(rsltPriSpMnSCCpVOs != null){
			RsltPriSpMnSCCpVO[] tmpVOs = new RsltPriSpMnSCCpVO[rsltPriSpMnSCCpVOs.length];
			System.arraycopy(rsltPriSpMnSCCpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriSpMnSCCpVOs = tmpVOs;
		}
	}


	public EsmPri0058Event(){}


	
}