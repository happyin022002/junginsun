/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri201906Event.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.12 공백진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAfilVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;


/**
 * ESM_PRI_2019_06 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2019_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jaeyeon Kim
 * @see ESM_PRI_2019_06HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri201906Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object Multi Data 처리 */
	private PriRpMnVO priRpMnVO = null;
	
	//RsltPriRpAfilVO
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRpAfilVO[] rsltPriRpAfilVO = null;
	
	public PriRpMnVO getPriRpMnVO() {
		return priRpMnVO;
	}

	public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
		this.priRpMnVO = priRpMnVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAfilVO priSpAfilVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAfilVO[] priSpAfilVOs = null;
	


	public EsmPri201906Event(){}
	
	public void setPriRpAfilVO(PriRpAfilVO priSpAfilVO){
		this. priSpAfilVO = priSpAfilVO;
	}

	public void setPriRpAfilVOS(PriRpAfilVO[] priSpAfilVOs){
		if(priSpAfilVOs != null){
			PriRpAfilVO[] tmpVOs = new PriRpAfilVO[priSpAfilVOs.length];
			System.arraycopy(priSpAfilVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpAfilVOs = tmpVOs;
		}
	}

	public PriRpAfilVO getPriRpAfilVO(){
		return priSpAfilVO;
	}

	public PriRpAfilVO[] getPriRpAfilVOS(){
		PriRpAfilVO[] rtnVOs = null;
		if (this.priSpAfilVOs != null) {
			rtnVOs = new PriRpAfilVO[priSpAfilVOs.length];
			System.arraycopy(priSpAfilVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	
	
	public RsltPriRpAfilVO[] getRsltPriRpAfilVO() {
		RsltPriRpAfilVO[] rtnVOs = null;
		if (this.rsltPriRpAfilVO != null) {
			rtnVOs = new RsltPriRpAfilVO[rsltPriRpAfilVO.length];
			System.arraycopy(rsltPriRpAfilVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltPriRpAfilVO(RsltPriRpAfilVO[] rsltPriRpAfilVO){
		if(rsltPriRpAfilVO != null){
			RsltPriRpAfilVO[] tmpVOs = new RsltPriRpAfilVO[rsltPriRpAfilVO.length];
			System.arraycopy(rsltPriRpAfilVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRpAfilVO = tmpVOs;
		}
	}

}