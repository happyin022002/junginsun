/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0025Event.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.CstPriRpAfilVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAfilVO;


/**
 * ESM_PRI_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2003_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jaeyeon Kim
 * @see ESM_PRI_2003_06HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri200306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	//CstPriRpAfilVO
	//RsltPriRpAfilVO
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstPriRpAfilVO cstPriRpAfilVO = null;	
	
	public CstPriRpAfilVO getCstPriRpAfilVO() {
		return cstPriRpAfilVO;
	}

	public void setCstPriRpAfilVO(CstPriRpAfilVO cstPriRpAfilVO) {
		this.cstPriRpAfilVO = cstPriRpAfilVO;
	}

	/** Table Value Object Multi Data 처리 */
	private RsltPriRpAfilVO[] rsltPriRpAfilVO = null;
	
	
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

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAfilVO priSpAfilVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAfilVO[] priSpAfilVOs = null;

	public EsmPri200306Event(){}
	
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

}