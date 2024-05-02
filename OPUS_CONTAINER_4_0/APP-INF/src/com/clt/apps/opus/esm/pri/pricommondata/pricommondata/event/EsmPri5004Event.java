/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_5004HTMLAction.java
*@FileTitle : Service Scope Property Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.17
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.17 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event;

//import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.SvcScpPptVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSvcScpPptVO;

/**
 * ESM_PRI_5004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_5004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_PRI_5004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri5004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	public EsmPri5004Event(){}
	
	private PriSvcScpPptVO priSvcScpPptVO = null;

	private PriSvcScpPptVO[] priSvcScpPptVOs = null;

	private RsltServiceScopePropertyVO rsltServiceScopePropertyVO = null;	
	
	private RsltServiceScopePropertyVO[] rsltServiceScopePropertyVOs = null;	
	
	public PriSvcScpPptVO getPriSvcScpPptVO() {
		return priSvcScpPptVO;
	}

	public void setPriSvcScpPptVO(PriSvcScpPptVO priSvcScpPptVO) {
		this.priSvcScpPptVO = priSvcScpPptVO;
	}
	
	public PriSvcScpPptVO[] getPriSvcScpPptVOs() {
		PriSvcScpPptVO[] tmpVOs = null;
		if (this.priSvcScpPptVOs != null) {
			tmpVOs = new PriSvcScpPptVO[priSvcScpPptVOs.length];
			System.arraycopy(priSvcScpPptVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSvcScpPptVOs(PriSvcScpPptVO[] priSvcScpPptVOs) {
		if (priSvcScpPptVOs != null) {
			PriSvcScpPptVO[] tmpVOs = new PriSvcScpPptVO[priSvcScpPptVOs.length];
			System.arraycopy(priSvcScpPptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSvcScpPptVOs = tmpVOs;
		}
	}

	public RsltServiceScopePropertyVO getRsltServiceScopePropertyVO() {
		return rsltServiceScopePropertyVO;
	}

	public void setRsltServiceScopePropertyVO(RsltServiceScopePropertyVO rsltServiceScopePropertyVO) {
		this.rsltServiceScopePropertyVO = rsltServiceScopePropertyVO;
	}

	public RsltServiceScopePropertyVO[] getRsltServiceScopePropertyVOs() {
		RsltServiceScopePropertyVO[] tmpVOs = null;
		if (this.rsltServiceScopePropertyVOs != null) {
			tmpVOs = new RsltServiceScopePropertyVO[rsltServiceScopePropertyVOs.length];
			System.arraycopy(rsltServiceScopePropertyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltServiceScopePropertyVOs(RsltServiceScopePropertyVO[] rsltServiceScopePropertyVOs) {
		if (rsltServiceScopePropertyVOs != null) {
			RsltServiceScopePropertyVO[] tmpVOs = new RsltServiceScopePropertyVO[rsltServiceScopePropertyVOs.length];
			System.arraycopy(rsltServiceScopePropertyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltServiceScopePropertyVOs = tmpVOs;
		}
	}

	

}