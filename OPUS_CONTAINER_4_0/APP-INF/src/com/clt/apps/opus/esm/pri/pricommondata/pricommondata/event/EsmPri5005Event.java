/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_5005HTMLAction.java
*@FileTitle : Service Scope Property Mapping Creation
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
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyMappingVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSvcScpPptVO;
import com.clt.syscommon.common.table.PriSvcScpPptMapgVO;

/**
 * ESM_PRI_5005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_5005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_PRI_5005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri5005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	public EsmPri5005Event(){}
	
	
	// 5004
	private PriSvcScpPptVO priSvcScpPptVO = null;

	private PriSvcScpPptVO[] priSvcScpPptVOs = null;
	// 5005
	private PriSvcScpPptMapgVO priSvcScpPptMapgVO = null;

	private PriSvcScpPptMapgVO[] priSvcScpPptMapgVOs = null;
	
	
	// 5004
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
	
	// 5005
	public PriSvcScpPptMapgVO getPriSvcScpPptMapgVO() {
		return priSvcScpPptMapgVO;
	}

	public void setPriSvcScpPptMapgVO(PriSvcScpPptMapgVO priSvcScpPptMapgVO) {
		this.priSvcScpPptMapgVO = priSvcScpPptMapgVO;
	}
	
	public PriSvcScpPptMapgVO[] getPriSvcScpPptMapgVOs() {
		PriSvcScpPptMapgVO[] tmpVOs = null;
		if (this.priSvcScpPptMapgVOs != null) {
			tmpVOs = new PriSvcScpPptMapgVO[priSvcScpPptMapgVOs.length];
			System.arraycopy(priSvcScpPptMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSvcScpPptMapgVOs(PriSvcScpPptMapgVO[] priSvcScpPptMapgVOs) {
		if (priSvcScpPptMapgVOs != null) {
			PriSvcScpPptMapgVO[] tmpVOs = new PriSvcScpPptMapgVO[priSvcScpPptMapgVOs.length];
			System.arraycopy(priSvcScpPptMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSvcScpPptMapgVOs = tmpVOs;
		}
	}
	

}