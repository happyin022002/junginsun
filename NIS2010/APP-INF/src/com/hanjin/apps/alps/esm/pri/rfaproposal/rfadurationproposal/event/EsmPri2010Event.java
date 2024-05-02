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
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;


/**
 * ESM_PRI_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_2010HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmPri2010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	//CstScpDurVO
	/** Table Value Object 저장시 사용되는 커스텀 VO */
	private CstScpDurVO cstScpDurVO = null;
	
	public CstScpDurVO getCstScpDurVO() {
		return cstScpDurVO;
	}

	public void setCstScpDurVO(CstScpDurVO cstScpDurVO) {
		this.cstScpDurVO = cstScpDurVO;
	}

	/** Table Value Object 저장시 사용되는 커스텀 VO */
	private CstPriRpScpDurVO cstPriRpScpDurVO = null;
	/** Table Value Object Multi Data 처리 */
	private CstPriRpScpDurVO[] cstPriRpScpDurVOs = null;	
	
	public CstPriRpScpDurVO getCstPriRpScpDurVO() {
		return cstPriRpScpDurVO;
	}

	public void setCstPriRpScpDurVO(CstPriRpScpDurVO cstPriRpScpDurVO) {
		this.cstPriRpScpDurVO = cstPriRpScpDurVO;
	}

	public CstPriRpScpDurVO[] getCstPriRpScpDurVOs() {
		CstPriRpScpDurVO[] rtnVOs = null;
		if (this.cstPriRpScpDurVOs != null) {
			rtnVOs = new CstPriRpScpDurVO[cstPriRpScpDurVOs.length];
			System.arraycopy(cstPriRpScpDurVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCstPriRpScpDurVOs(CstPriRpScpDurVO[] cstPriRpScpDurVOs){
		if(cstPriRpScpDurVOs != null){
			CstPriRpScpDurVO[] tmpVOs = new CstPriRpScpDurVO[cstPriRpScpDurVOs.length];
			System.arraycopy(cstPriRpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriRpScpDurVOs = tmpVOs;
		}
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
	private PriRpScpDurVO[] priRpScpDurVOs = null;	
	
	public PriRpScpDurVO[] getPriRpScpDurVOs() {
		PriRpScpDurVO[] rtnVOs = null;
		if (this.priRpScpDurVOs != null) {
			rtnVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpScpDurVOs(PriRpScpDurVO[] priRpScpDurVOs){
		if(priRpScpDurVOs != null){
			PriRpScpDurVO[] tmpVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpDurVOs = tmpVOs;
		}
	}

	private PriRpScpDurVO priRpScpDurVO = null;
	
	public PriRpScpDurVO getPriRpScpDurVO() {
		return priRpScpDurVO;
	}

	public void setPriRpScpDurVO(PriRpScpDurVO priRpScpDurVO) {
		this.priRpScpDurVO = priRpScpDurVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpDurVO priRpDurVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpDurVO[] priRpDurVOs = null;
 
	public EsmPri2010Event(){}
	
	public void setPriRpDurVO(PriRpDurVO priRpDurVO){
		this. priRpDurVO = priRpDurVO;
	}

	public void setPriRpDurVOS(PriRpDurVO[] priRpDurVOs){
		if(priRpDurVOs != null){
			PriRpDurVO[] tmpVOs = new PriRpDurVO[priRpDurVOs.length];
			System.arraycopy(priRpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpDurVOs = tmpVOs;
		}
	}

	public PriRpDurVO getPriRpDurVO(){
		return priRpDurVO;
	}

	public PriRpDurVO[] getPriRpDurVOS(){
		PriRpDurVO[] rtnVOs = null;
		if (this.priRpDurVOs != null) {
			rtnVOs = new PriRpDurVO[priRpDurVOs.length];
			System.arraycopy(priRpDurVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}