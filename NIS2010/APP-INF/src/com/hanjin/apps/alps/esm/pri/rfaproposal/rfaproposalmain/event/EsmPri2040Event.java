/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0036Event.java
*@FileTitle : Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstPriRpAmendVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;


/**
 * ESM_PRI_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2040HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CstPriRpAmendVO cstPriRpAmendVO = null;
	
	public CstPriRpAmendVO getCstPriRpAmendVO() {
		return cstPriRpAmendVO;
	}

	public void setCstPriRpAmendVO(CstPriRpAmendVO cstPriRpAmendVO) {
		this.cstPriRpAmendVO = cstPriRpAmendVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpHdrVO priRpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpHdrVO[] priRpHdrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpMnVO priRpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpMnVO[] priRpMnVOs = null;	

	public PriRpHdrVO getPriRpHdrVO() {
		return priRpHdrVO;
	}

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO) {
		this.priRpHdrVO = priRpHdrVO;
	}

	public PriRpHdrVO[] getPriRpHdrVOs() {
		PriRpHdrVO[] rtnVOs = null;
		if (this.priRpHdrVOs != null) {
			rtnVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpHdrVOs(PriRpHdrVO[] priRpHdrVOs){
		if(priRpHdrVOs != null){
			PriRpHdrVO[] tmpVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpHdrVOs = tmpVOs;
		}
	}

	public PriRpMnVO getPriRpMnVO() {
		return priRpMnVO;
	}

	public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
		this.priRpMnVO = priRpMnVO;
	}

	public PriRpMnVO[] getPriRpMnVOs() {
		PriRpMnVO[] rtnVOs = null;
		if (this.priRpMnVOs != null) {
			rtnVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpMnVOs(PriRpMnVO[] priRpMnVOs){
		if(priRpMnVOs != null){
			PriRpMnVO[] tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpMnVOs = tmpVOs;
		}
	}

	public EsmPri2040Event(){}
	

}