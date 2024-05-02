/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0019Event.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstAcceptDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.GrpDurVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;


/**
 * ESM_PRI_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0019HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CstAcceptDurVO cstAcceptDurVO = null;
	
	/** Table Value Object 저장시 사용되는 커스텀 VO */
	private CstPriSpScpDurVO cstPriSpScpDurVO = null;
	/** Table Value Object Multi Data 처리 */
	private CstPriSpScpDurVO[] cstPriSpScpDurVOs = null;	
	
	public CstAcceptDurVO getCstAcceptDurVO() {
		return cstAcceptDurVO;
	}

	public void setCstAcceptDurVO(CstAcceptDurVO cstAcceptDurVO) {
		this.cstAcceptDurVO = cstAcceptDurVO;
	}

	public CstPriSpScpDurVO getCstPriSpScpDurVO() {
		return cstPriSpScpDurVO;
	}

	public void setCstPriSpScpDurVO(CstPriSpScpDurVO cstPriSpScpDurVO) {
		this.cstPriSpScpDurVO = cstPriSpScpDurVO;
	}

	public CstPriSpScpDurVO[] getCstPriSpScpDurVOs() {
		return cstPriSpScpDurVOs;
	}

	public void setCstPriSpScpDurVOs(CstPriSpScpDurVO[] cstPriSpScpDurVOs) {
		this.cstPriSpScpDurVOs = cstPriSpScpDurVOs;
	}

	/** Container VO */
	private GrpDurVO grpDurVO = null;
	
	/** Table Value Object 조회시 사용되는 커스텀 VO */
	private CstAuthorityVO cstAuthorityVO = null;
	
	public CstAuthorityVO getCstAuthorityVO() {
		return cstAuthorityVO;
	}

	public void setCstAuthorityVO(CstAuthorityVO cstAuthorityVO) {
		this.cstAuthorityVO = cstAuthorityVO;
	}

	public GrpDurVO getGrpDurVO() {
		return grpDurVO;
	}

	public void setGrpDurVO(GrpDurVO grpDurVO) {
		this.grpDurVO = grpDurVO;
	}

	/** Table Value Object Multi Data 처리 */
	private PriSpScpDurVO[] priSpScpDurVOs = null;	
	
	public PriSpScpDurVO[] getPriSpScpDurVOs() {
		return priSpScpDurVOs;
	}

	public void setPriSpScpDurVOs(PriSpScpDurVO[] priSpScpDurVOs) {
		this.priSpScpDurVOs = priSpScpDurVOs;
	}

	private PriSpScpDurVO priSpScpDurVO = null;
	
	public PriSpScpDurVO getPriSpScpDurVO() {
		return priSpScpDurVO;
	}

	public void setPriSpScpDurVO(PriSpScpDurVO priSpScpDurVO) {
		this.priSpScpDurVO = priSpScpDurVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpDurVO priSpDurVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpDurVO[] priSpDurVOs = null;
 
	public EsmPri0019Event(){}
	
	public void setPriSpDurVO(PriSpDurVO priSpDurVO){
		this. priSpDurVO = priSpDurVO;
	}

	public void setPriSpDurVOS(PriSpDurVO[] priSpDurVOs){
		this. priSpDurVOs = priSpDurVOs;
	}

	public PriSpDurVO getPriSpDurVO(){
		return priSpDurVO;
	}

	public PriSpDurVO[] getPriSpDurVOS(){
		return priSpDurVOs;
	}

}