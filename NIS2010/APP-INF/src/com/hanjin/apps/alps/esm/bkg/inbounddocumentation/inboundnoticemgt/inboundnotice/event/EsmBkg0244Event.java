/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmBkg0244Event.java
*@FileTitle : A/N Also Notify Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 김수현
*@LastVersion : 1.0
* 2016.02.22 김수현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgArrNtcAntfyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0244 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0244HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_0244HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0244Event extends EventSupport{

	private static final long serialVersionUID = 1L;

	private BkgArrNtcAntfyVO[] bkgArrNtcAntfyVOs;
	private BkgArrNtcAntfyVO bkgArrNtcAntfyVO;
 
	/**
	 * @return the psaVvdVO
	 */
	public BkgArrNtcAntfyVO getBkgArrNtcAntfyVO() {
		return bkgArrNtcAntfyVO;
	}
 
	/**
	 * @param psaVvdVO the psaVvdVO to set
	 */
	public void setBkgArrNtcAntfyVO(BkgArrNtcAntfyVO bkgArrNtcAntfyVO) {
		this.bkgArrNtcAntfyVO = bkgArrNtcAntfyVO;
	}

	/**
	 * @return the psaVvdVOs
	 */
	public BkgArrNtcAntfyVO[] getBkgArrNtcAntfyVOs() {
		BkgArrNtcAntfyVO[] rtnVOs = null;
		if (this.bkgArrNtcAntfyVOs != null) {
			rtnVOs = Arrays.copyOf(bkgArrNtcAntfyVOs, bkgArrNtcAntfyVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param psaVvdVOs the psaVvdVOs to set
	 */
	public void setBkgArrNtcAntfyVOs(BkgArrNtcAntfyVO[] searchBkgBookingVOs){
		if(searchBkgBookingVOs != null){
			BkgArrNtcAntfyVO[] tmpVOs = Arrays.copyOf(searchBkgBookingVOs, searchBkgBookingVOs.length);
			this.bkgArrNtcAntfyVOs = tmpVOs;
		}
	}

}
