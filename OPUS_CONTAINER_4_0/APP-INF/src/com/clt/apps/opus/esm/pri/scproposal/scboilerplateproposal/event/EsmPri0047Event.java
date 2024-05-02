/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0047Event.java
*@FileTitle : Bolier Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplSearchVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstPriSpBlplVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.SCCopyVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpBlplCtntVO;
import com.clt.syscommon.common.table.PriSpBlplVO;


/**
 * ESM_PRI_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstBlplSearchVO cstBlplSearchVO = null; 
	
	public CstBlplSearchVO getCstBlplSearchVO() {
		return cstBlplSearchVO;
	}

	public void setCstBlplSearchVO(CstBlplSearchVO cstBlplSearchVO) {
		this.cstBlplSearchVO = cstBlplSearchVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstBlplCopyVO cstBlplCopyVO = null;
	
	public CstBlplCopyVO getCstBlplCopyVO() {
		return cstBlplCopyVO;
	}

	public void setCstBlplCopyVO(CstBlplCopyVO cstBlplCopyVO) {
		this.cstBlplCopyVO = cstBlplCopyVO;
	}

	/** Table Value Object Multi Data 처리 */
	private CstPriSpBlplVO cstPriSpBlplVO = null;
	
	public CstPriSpBlplVO getCstPriSpBlplVO() {
		return cstPriSpBlplVO;
	}

	public void setCstPriSpBlplVO(CstPriSpBlplVO cstPriSpBlplVO) {
		this.cstPriSpBlplVO = cstPriSpBlplVO;
	}

	/** Table Value Object Multi Data 처리 */
	private PriSpBlplCtntVO[] priSpBlplCtntVOs = null;
	


	public PriSpBlplCtntVO[] getPriSpBlplCtntVOs() {
		PriSpBlplCtntVO[] tmpVOs = null;
		if (this.priSpBlplCtntVOs != null) {
			tmpVOs = new PriSpBlplCtntVO[priSpBlplCtntVOs.length];
			System.arraycopy(priSpBlplCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpBlplCtntVOs(PriSpBlplCtntVO[] priSpBlplCtntVOs) {
		if (priSpBlplCtntVOs != null) {
			PriSpBlplCtntVO[] tmpVOs = new PriSpBlplCtntVO[priSpBlplCtntVOs.length];
			System.arraycopy(priSpBlplCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpBlplCtntVOs = tmpVOs;
		}
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCCopyVO sCCopyVO = null;		
	public SCCopyVO getSCCopyVO() {
		return sCCopyVO;
	}

	public void setSCCopyVO(SCCopyVO copyVO) {
		sCCopyVO = copyVO;
	}

	//RsltPriSpBlplVO
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSpBlplVO rsltPriSpBlplVO = null;		
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSpBlplCtntVO rsltPriSpBlplCtntVO = null;		
	
	//RsltPriSpBlplHeaderVO
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpBlplVO priSpBlplVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpBlplCtntVO priSpBlplCtntVO = null;	
	
	public PriSpBlplCtntVO getPriSpBlplCtntVO() {
		return priSpBlplCtntVO;
	}

	public void setPriSpBlplCtntVO(PriSpBlplCtntVO priSpBlplCtntVO) {
		this.priSpBlplCtntVO = priSpBlplCtntVO;
	}

	/** Table Value Object Multi Data 처리 */
	private PriSpBlplVO[] priSpBlplVOs = null;
	
	/** container vo  */
	private BlplPropVO blplPropVO = null;
	
	public PriSpBlplVO[] getPriSpBlplVOs() {
		PriSpBlplVO[] tmpVOs = null;
		if (this.priSpBlplVOs != null) {
			tmpVOs = new PriSpBlplVO[priSpBlplVOs.length];
			System.arraycopy(priSpBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpBlplVOs(PriSpBlplVO[] priSpBlplVOs) {
		if (priSpBlplVOs != null) {
			PriSpBlplVO[] tmpVOs = new PriSpBlplVO[priSpBlplVOs.length];
			System.arraycopy(priSpBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpBlplVOs = tmpVOs;
		}
	}

	public BlplPropVO getBlplPropVO() {
		return blplPropVO;
	}

	public void setBlplPropVO(BlplPropVO blplPropVO) {
		this.blplPropVO = blplPropVO;
	}

	public RsltPriSpBlplVO getRsltPriSpBlplVO() {
		return rsltPriSpBlplVO;
	}

	public void setRsltPriSpBlplVO(RsltPriSpBlplVO rsltPriSpBlplVO) {
		this.rsltPriSpBlplVO = rsltPriSpBlplVO;
	}

	public RsltPriSpBlplCtntVO getRsltPriSpBlplCtntVO() {
		return rsltPriSpBlplCtntVO;
	}

	public void setRsltPriSpBlplCtntVO(RsltPriSpBlplCtntVO rsltPriSpBlplCtntVO) {
		this.rsltPriSpBlplCtntVO = rsltPriSpBlplCtntVO;
	}


	
	public RsltPriSpBlplHeaderVO getRsltPriSpBlplHeaderVO() {
		return rsltPriSpBlplHeaderVO;
	}

	public void setRsltPriSpBlplHeaderVO(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) {
		this.rsltPriSpBlplHeaderVO = rsltPriSpBlplHeaderVO;
	}



	public EsmPri0047Event(){}
	
	public void setPriSpBlplVO(PriSpBlplVO priSpBlplVO){
		this. priSpBlplVO = priSpBlplVO;
	}

	public void setPriSpBlplVOS(PriSpBlplVO[] priSpBlplVOs){
		if (priSpBlplVOs != null) {
			PriSpBlplVO[] tmpVOs = new PriSpBlplVO[priSpBlplVOs.length];
			System.arraycopy(priSpBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpBlplVOs = tmpVOs;
		}
	}

	public PriSpBlplVO getPriSpBlplVO(){
		return priSpBlplVO;
	}

	public PriSpBlplVO[] getPriSpBlplVOS(){
		PriSpBlplVO[] tmpVOs = null;
		if (this.priSpBlplVOs != null) {
			tmpVOs = new PriSpBlplVO[priSpBlplVOs.length];
			System.arraycopy(priSpBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}