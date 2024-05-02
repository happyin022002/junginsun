/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7013Event.java
 *@FileTitle : EUR Add-on Guideline Creation / Amend – Load Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.30
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.30 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfFdrRtVO;

/**
 * ESM_PRI_7013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7013HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7013Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private FDRDetailVO fdrDetailVO = null;

	private PriTrfFdrRtVO[] priTrfFdrRtVOs = null;

	private String locCd = null;

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public FDRDetailVO getFdrDetailVO() {
		return fdrDetailVO;
	}

	public void setFdrDetailVO(FDRDetailVO fdrDetailVO) {
		this.fdrDetailVO = fdrDetailVO;
	}

	public PriTrfFdrRtVO[] getPriTrfFdrRtVOs() {
		PriTrfFdrRtVO[] rtnVOs = null;
		if (this.priTrfFdrRtVOs != null) {
			rtnVOs = new PriTrfFdrRtVO[priTrfFdrRtVOs.length];
			System.arraycopy(priTrfFdrRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriTrfFdrRtVOs(PriTrfFdrRtVO[] priTrfFdrRtVOs){
		if(priTrfFdrRtVOs != null){
			PriTrfFdrRtVO[] tmpVOs = new PriTrfFdrRtVO[priTrfFdrRtVOs.length];
			System.arraycopy(priTrfFdrRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTrfFdrRtVOs = tmpVOs;
		}
	}

}
