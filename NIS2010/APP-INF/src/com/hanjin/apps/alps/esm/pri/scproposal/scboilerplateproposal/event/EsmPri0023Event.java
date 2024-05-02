/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0023Event.java
*@FileTitle : Bolier Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.SCCopyVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSpBlplVO;


/**
 * ESM_PRI_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0023Event extends EventSupport {

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
		return priSpBlplCtntVOs;
	}

	public void setPriSpBlplCtntVOs(PriSpBlplCtntVO[] priSpBlplCtntVOs) {
		this.priSpBlplCtntVOs = priSpBlplCtntVOs;
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
		return priSpBlplVOs;
	}

	public void setPriSpBlplVOs(PriSpBlplVO[] priSpBlplVOs) {
		this.priSpBlplVOs = priSpBlplVOs;
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



	public EsmPri0023Event(){}
	
	public void setPriSpBlplVO(PriSpBlplVO priSpBlplVO){
		this. priSpBlplVO = priSpBlplVO;
	}

	public void setPriSpBlplVOS(PriSpBlplVO[] priSpBlplVOs){
		this. priSpBlplVOs = priSpBlplVOs;
	}

	public PriSpBlplVO getPriSpBlplVO(){
		return priSpBlplVO;
	}

	public PriSpBlplVO[] getPriSpBlplVOS(){
		return priSpBlplVOs;
	}

}