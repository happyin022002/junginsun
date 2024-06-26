/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2051Event.java
 *@FileTitle : RFA Proposal Creation - Arbitrary[Load Excel]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.03
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpArbKeyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * ESM_PRI_2051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Eun Sup
 * @see ESM_PRI_2051HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2051Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpTrspAddChgVO priRpScpTrspAddChgVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltPriRpScpArbKeyVO rsltPriRpScpArbKeyVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltPriRpScpTrspAddChgVO rsltPriRpScpTrspAddChgVO = null;

	/** Table Value Object Multi Data 처리 */
	private RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs = null;

	public EsmPri2051Event() {
	}

	public PriRpScpTrspAddChgVO getPriRpScpTrspAddChgVO() {
		return priRpScpTrspAddChgVO;
	}

	public PriRpScpTrspAddChgVO[] getPriRpScpTrspAddChgVOs() {
		PriRpScpTrspAddChgVO[] rtnVOs = null;
		if (this.priRpScpTrspAddChgVOs != null) {
			rtnVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) {
		this.priRpScpTrspAddChgVO = priRpScpTrspAddChgVO;
	}

	public void setPriRpScpTrspAddChgVOs(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs){
		if(priRpScpTrspAddChgVOs != null){
			PriRpScpTrspAddChgVO[] tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpTrspAddChgVOs = tmpVOs;
		}
	}

	public RsltPriRpScpArbKeyVO getRsltPriRpScpArbKeyVO() {
		return rsltPriRpScpArbKeyVO;
	}

	public void setRsltPriRpScpArbKeyVO(RsltPriRpScpArbKeyVO rsltPriRpScpArbKeyVO) {
		this.rsltPriRpScpArbKeyVO = rsltPriRpScpArbKeyVO;
	}

	public RsltPriRpScpTrspAddChgVO getRsltPriRpScpTrspAddChgVO() {
		return rsltPriRpScpTrspAddChgVO;
	}

	public RsltPriRpScpTrspAddChgVO[] getRsltPriRpScpTrspAddChgVOs() {
		RsltPriRpScpTrspAddChgVO[] rtnVOs = null;
		if (this.rsltPriRpScpTrspAddChgVOs != null) {
			rtnVOs = new RsltPriRpScpTrspAddChgVO[rsltPriRpScpTrspAddChgVOs.length];
			System.arraycopy(rsltPriRpScpTrspAddChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltPriRpScpTrspAddChgVO(RsltPriRpScpTrspAddChgVO rsltPriRpScpTrspAddChgVO) {
		this.rsltPriRpScpTrspAddChgVO = rsltPriRpScpTrspAddChgVO;
	}

	public void setRsltPriRpScpTrspAddChgVOs(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs){
		if(rsltPriRpScpTrspAddChgVOs != null){
			RsltPriRpScpTrspAddChgVO[] tmpVOs = new RsltPriRpScpTrspAddChgVO[rsltPriRpScpTrspAddChgVOs.length];
			System.arraycopy(rsltPriRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRpScpTrspAddChgVOs = tmpVOs;
		}
	}

}