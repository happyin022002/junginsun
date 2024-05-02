/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0101Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-10-30 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import java.util.Arrays;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApInvHdrVO;

/**
 * ESD_TES_101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0101Event extends EventSupport {
	
	private ApInvHdrVO 		apInvHdrVO 	= null;
	private ApInvHdrVO[] 	apInvHdrVOs = null;
	
	/**
	 * @return the apInvHdrVO
	 */
	public ApInvHdrVO getApInvHdrVO() {
		return apInvHdrVO;
	}
	/**
	 * @param apInvHdrVO the apInvHdrVO to set
	 */
	public void setApInvHdrVO(ApInvHdrVO apInvHdrVO) {
		this.apInvHdrVO = apInvHdrVO;
	}
	/**
	 * @return the apInvHdrVOs
	 */
	public ApInvHdrVO[] getApInvHdrVOs() {
		ApInvHdrVO[] rtnVOs = null;
		if (this.apInvHdrVOs != null) {
			rtnVOs = Arrays.copyOf(apInvHdrVOs, apInvHdrVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param apInvHdrVOs the apInvHdrVOs to set
	 */
	public void setApInvHdrVOs(ApInvHdrVO[] apInvHdrVOs){
		if(apInvHdrVOs != null){
			ApInvHdrVO[] tmpVOs = Arrays.copyOf(apInvHdrVOs, apInvHdrVOs.length);
			this.apInvHdrVOs = tmpVOs;
		}
	}
	

}