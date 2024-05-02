/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3502Event.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.event;

import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.InPriTariffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSvcScpTrfVO;
import com.clt.syscommon.common.table.PriTariffVO;

/**
 * ESM_PRI_3502 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3502HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO	MIJIN
 * @see ESM_PRI_3502HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3502Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	public EsmPri3502Event(){}
	
	private PriTariffVO priTariffVO = null;

	private PriTariffVO[] priTariffVOs = null;

	private PriSvcScpTrfVO priSvcScpTrfVO = null;	
	
	private PriSvcScpTrfVO[] priSvcScpTrfVOs = null;	
	
	private RsltSvcScpCdVO rsltSvcScpCdVO = null ;
	
	private RsltSvcScpCdVO[] rsltSvcScpCdVOs = null ;
	
	private InPriTariffVO inPriTariffVO = null;
	
	
	
	
	public InPriTariffVO getInPriTariffVO() {
		return inPriTariffVO;
	}

	public void setInPriTariffVO(InPriTariffVO inPriTariffVO) {
		this.inPriTariffVO = inPriTariffVO;
	}

	public RsltSvcScpCdVO getRsltSvcScpCdVO() {
		return rsltSvcScpCdVO;
	}

	public void setRsltSvcScpCdVO(RsltSvcScpCdVO rsltSvcScpCdVO) {
		this.rsltSvcScpCdVO = rsltSvcScpCdVO;
	}

	public RsltSvcScpCdVO[] getRsltSvcScpCdVOs() {
		RsltSvcScpCdVO[] tmpVOs = null;
		if (this.rsltSvcScpCdVOs != null) {
			tmpVOs = new RsltSvcScpCdVO[rsltSvcScpCdVOs.length];
			System.arraycopy(rsltSvcScpCdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltSvcScpCdVOs(RsltSvcScpCdVO[] rsltSvcScpCdVOs) {
		if (rsltSvcScpCdVOs != null) {
			RsltSvcScpCdVO[] tmpVOs = new RsltSvcScpCdVO[rsltSvcScpCdVOs.length];
			System.arraycopy(rsltSvcScpCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSvcScpCdVOs = tmpVOs;
		}
	}


	public PriSvcScpTrfVO getPriSvcScpTrfVO() {
		return priSvcScpTrfVO;
	}

	public void setPriSvcScpTrfVO(PriSvcScpTrfVO priSvcScpTrfVO) {
		this.priSvcScpTrfVO = priSvcScpTrfVO;
	}

	public PriSvcScpTrfVO[] getPriSvcScpTrfVOs() {
		PriSvcScpTrfVO[] tmpVOs = null;
		if (this.priSvcScpTrfVOs != null) {
			tmpVOs = new PriSvcScpTrfVO[priSvcScpTrfVOs.length];
			System.arraycopy(priSvcScpTrfVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSvcScpTrfVOs(PriSvcScpTrfVO[] priSvcScpTrfVOs) {
		if (priSvcScpTrfVOs != null) {
			PriSvcScpTrfVO[] tmpVOs = new PriSvcScpTrfVO[priSvcScpTrfVOs.length];
			System.arraycopy(priSvcScpTrfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSvcScpTrfVOs = tmpVOs;
		}
	}

	public PriTariffVO getPriTariffVO() {
		return priTariffVO;
	}

	public void setPriTariffVO(PriTariffVO priTariffVO) {
		this.priTariffVO = priTariffVO;
	}

	public PriTariffVO[] getPriTariffVOs() {
		PriTariffVO[] tmpVOs = null;
		if (this.priTariffVOs != null) {
			tmpVOs = new PriTariffVO[priTariffVOs.length];
			System.arraycopy(priTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriTariffVOs(PriTariffVO[] priTariffVOs) {
		if (priTariffVOs != null) {
			PriTariffVO[] tmpVOs = new PriTariffVO[priTariffVOs.length];
			System.arraycopy(priTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTariffVOs = tmpVOs;
		}
	}

}