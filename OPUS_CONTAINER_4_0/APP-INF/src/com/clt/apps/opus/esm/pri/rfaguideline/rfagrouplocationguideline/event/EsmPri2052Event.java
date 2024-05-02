/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2052Event.java
*@FileTitle : RFA Guideline Creation - Location Group [Load Exce]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.03 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event;

import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRgGrpLocVO;


/**
 * ESM_PRI_2052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2052HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgGrpLocDtlVO priRgGrpLocDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRgGrpLocDtlVO[] priRgGrpLocDtlVOs = null;
		
	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRgGrpLocVO priRgGrpLocVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRgGrpLocVO[] priRgGrpLocVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private GrpLocGlineVO grpLocGlineVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltPriRgGrpVO rsltPriRgGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRgGrpVO[] rsltPriRgGrpVOs = null;
	
	public EsmPri2052Event(){}
	
	public void setPriRgGrpLocDtlVO(PriRgGrpLocDtlVO priRgGrpLocDtlVO){
		this. priRgGrpLocDtlVO = priRgGrpLocDtlVO;
	}

	public void setPriRgGrpLocDtlVOS(PriRgGrpLocDtlVO[] priRgGrpLocDtlVOs){
		if (priRgGrpLocDtlVOs != null) {
			PriRgGrpLocDtlVO[] tmpVOs = new PriRgGrpLocDtlVO[priRgGrpLocDtlVOs.length];
			System.arraycopy(priRgGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgGrpLocDtlVOs = tmpVOs;
		}
	}

	public PriRgGrpLocDtlVO getPriRgGrpLocDtlVO(){
		return priRgGrpLocDtlVO;
	}

	public PriRgGrpLocDtlVO[] getPriRgGrpLocDtlVOS(){
		PriRgGrpLocDtlVO[] tmpVOs = null;
		if (this.priRgGrpLocDtlVOs != null) {
			tmpVOs = new PriRgGrpLocDtlVO[priRgGrpLocDtlVOs.length];
			System.arraycopy(priRgGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriRgGrpLocDtlVO[] getPriRgGrpLocDtlVOs() {
		PriRgGrpLocDtlVO[] tmpVOs = null;
		if (this.priRgGrpLocDtlVOs != null) {
			tmpVOs = new PriRgGrpLocDtlVO[priRgGrpLocDtlVOs.length];
			System.arraycopy(priRgGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriRgGrpLocVO getPriRgGrpLocVO() {
		return priRgGrpLocVO;
	}

	public PriRgGrpLocVO[] getPriRgGrpLocVOs() {
		PriRgGrpLocVO[] tmpVOs = null;
		if (this.priRgGrpLocVOs != null) {
			tmpVOs = new PriRgGrpLocVO[priRgGrpLocVOs.length];
			System.arraycopy(priRgGrpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public GrpLocGlineVO getGrpLocGlineVO() {
		return grpLocGlineVO;
	}

	public void setPriRgGrpLocDtlVOs(PriRgGrpLocDtlVO[] priRgGrpLocDtlVOs) {
		if (priRgGrpLocDtlVOs != null) {
			PriRgGrpLocDtlVO[] tmpVOs = new PriRgGrpLocDtlVO[priRgGrpLocDtlVOs.length];
			System.arraycopy(priRgGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgGrpLocDtlVOs = tmpVOs;
		}
	}

	public void setPriRgGrpLocVO(PriRgGrpLocVO priRgGrpLocVO) {
		this.priRgGrpLocVO = priRgGrpLocVO;
	}

	public void setPriRgGrpLocVOs(PriRgGrpLocVO[] priRgGrpLocVOs) {
		if (priRgGrpLocVOs != null) {
			PriRgGrpLocVO[] tmpVOs = new PriRgGrpLocVO[priRgGrpLocVOs.length];
			System.arraycopy(priRgGrpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgGrpLocVOs = tmpVOs;
		}
	}

	public void setGrpLocGlineVO(GrpLocGlineVO grpLocGlineVO) {
		this.grpLocGlineVO = grpLocGlineVO;
	}

	public RsltPriRgGrpVO getRsltPriRgGrpVO() {
		return rsltPriRgGrpVO;
	}

	public void setRsltPriRgGrpVO(RsltPriRgGrpVO rsltPriRgGrpVO) {
		this.rsltPriRgGrpVO = rsltPriRgGrpVO;
	}

	public RsltPriRgGrpVO[] getRsltPriRgGrpVOs() {
		RsltPriRgGrpVO[] tmpVOs = null;
		if (this.rsltPriRgGrpVOs != null) {
			tmpVOs = new RsltPriRgGrpVO[rsltPriRgGrpVOs.length];
			System.arraycopy(rsltPriRgGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltPriRgGrpVOs(RsltPriRgGrpVO[] rsltPriRgGrpVOs) {
		if (rsltPriRgGrpVOs != null) {
			RsltPriRgGrpVO[] tmpVOs = new RsltPriRgGrpVO[rsltPriRgGrpVOs.length];
			System.arraycopy(rsltPriRgGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRgGrpVOs = tmpVOs;
		}
	}
	
	

}