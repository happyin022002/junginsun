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
package com.hanjin.apps.alps.esm.pri.tariff.tariffcode.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTariffVO;
import com.hanjin.syscommon.common.table.PriSvcScpTrfVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.InPriTariffVO;

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
		return rsltSvcScpCdVOs;
	}

	public void setRsltSvcScpCdVOs(RsltSvcScpCdVO[] rsltSvcScpCdVOs) {
		this.rsltSvcScpCdVOs = rsltSvcScpCdVOs;
	}


	public PriSvcScpTrfVO getPriSvcScpTrfVO() {
		return priSvcScpTrfVO;
	}

	public void setPriSvcScpTrfVO(PriSvcScpTrfVO priSvcScpTrfVO) {
		this.priSvcScpTrfVO = priSvcScpTrfVO;
	}

	public PriSvcScpTrfVO[] getPriSvcScpTrfVOs() {
		return priSvcScpTrfVOs;
	}

	public void setPriSvcScpTrfVOs(PriSvcScpTrfVO[] priSvcScpTrfVOs) {
		this.priSvcScpTrfVOs = priSvcScpTrfVOs;
	}

	public PriTariffVO getPriTariffVO() {
		return priTariffVO;
	}

	public void setPriTariffVO(PriTariffVO priTariffVO) {
		this.priTariffVO = priTariffVO;
	}

	public PriTariffVO[] getPriTariffVOs() {
		return priTariffVOs;
	}

	public void setPriTariffVOs(PriTariffVO[] priTariffVOs) {
		this.priTariffVOs = priTariffVOs;
	}

}