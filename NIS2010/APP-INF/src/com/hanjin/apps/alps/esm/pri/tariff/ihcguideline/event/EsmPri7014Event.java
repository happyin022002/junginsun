/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7014Event.java
 *@FileTitle : IHC Guideline Creation / Amend ad Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.04.12
 *@LastModifier : 조정민
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;


import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.PriTrfIHCRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_7014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_PRI_7014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7014Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri7014Event(){}
	
	private IHCDetailVO iHCDetailVO = null;
	
	private PriTrfIHCRtVO priTrfIHCRtVO = null;

	private PriTrfIHCRtVO[] priTrfIHCRtVOs = null;
	

	public IHCDetailVO getIHCDetailVO() {
		return iHCDetailVO;
	}

	public void setIHCDetailVO(IHCDetailVO iHCDetailVO) {
		this.iHCDetailVO = iHCDetailVO;
	}

	public PriTrfIHCRtVO[] getPriTrfIHCRtVOs() {
		PriTrfIHCRtVO[] rtnVOs = null;
		if (this.priTrfIHCRtVOs != null) {
			rtnVOs = new PriTrfIHCRtVO[priTrfIHCRtVOs.length];
			System.arraycopy(priTrfIHCRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriTrfIHCRtVOs(PriTrfIHCRtVO[] priTrfIHCRtVOs){
		if(priTrfIHCRtVOs != null){
			PriTrfIHCRtVO[] tmpVOs = new PriTrfIHCRtVO[priTrfIHCRtVOs.length];
			System.arraycopy(priTrfIHCRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTrfIHCRtVOs = tmpVOs;
		}
	}

	public PriTrfIHCRtVO getPriTrfIHCRtVO() {
		return priTrfIHCRtVO;
	}

	public void setPriTrfIHCRtVO(PriTrfIHCRtVO priTrfIHCRtVO) {
		this.priTrfIHCRtVO = priTrfIHCRtVO;
	}

	
}