/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmsPri2050Event.java
*@FileTitle : RFA Proposal Creation - Arbitrary[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.29 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpArbKeyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpTrspAddChgVO;


/**
 * ESM_PRI_2050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2050HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpTrspAddChgVO priRpScpTrspAddChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRpScpArbKeyVO rsltPriRpScpArbKeyVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRpScpTrspAddChgVO rsltPriRpScpTrspAddChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs = null;
	
	public EsmPri2050Event(){}

	public PriRpScpTrspAddChgVO getPriRpScpTrspAddChgVO() {
		return priRpScpTrspAddChgVO;
	}

	public PriRpScpTrspAddChgVO[] getPriRpScpTrspAddChgVOs() {
		PriRpScpTrspAddChgVO[] tmpVOs = null;
		if (this.priRpScpTrspAddChgVOs != null) {
			tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) {
		this.priRpScpTrspAddChgVO = priRpScpTrspAddChgVO;
	}

	public void setPriRpScpTrspAddChgVOs(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs) {
		if (priRpScpTrspAddChgVOs != null) {
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
		RsltPriRpScpTrspAddChgVO[] tmpVOs = null;
		if (this.rsltPriRpScpTrspAddChgVOs != null) {
			tmpVOs = new RsltPriRpScpTrspAddChgVO[rsltPriRpScpTrspAddChgVOs.length];
			System.arraycopy(rsltPriRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltPriRpScpTrspAddChgVO(RsltPriRpScpTrspAddChgVO rsltPriRpScpTrspAddChgVO) {
		this.rsltPriRpScpTrspAddChgVO = rsltPriRpScpTrspAddChgVO;
	}

	public void setRsltPriRpScpTrspAddChgVOs(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) {
		if (rsltPriRpScpTrspAddChgVOs != null) {
			RsltPriRpScpTrspAddChgVO[] tmpVOs = new RsltPriRpScpTrspAddChgVO[rsltPriRpScpTrspAddChgVOs.length];
			System.arraycopy(rsltPriRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRpScpTrspAddChgVOs = tmpVOs;
		}
	}
	

}