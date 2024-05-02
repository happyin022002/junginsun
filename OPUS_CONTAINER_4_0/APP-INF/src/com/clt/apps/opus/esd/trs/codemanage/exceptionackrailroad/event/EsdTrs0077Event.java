/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESD_TRS_0077Event.java
 *@FileTitle : Exception Ack Rail Road
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-04-19
 *@LastModifier : S.W. KIM
 *@LastVersion : 1.0
 * 2016-04-19 ksw	   	1.0  최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.event;

import java.util.Arrays;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsExptAckRailVndrVO;

/**
 * ESD_TRS_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String selRailroad;

	/**
	 * 
	 */
	private TrsExptAckRailVndrVO trExptAckRailVndrVO;

	/**
	 * 
	 */
	private TrsExptAckRailVndrVO[] trExptAckRailVndrVOs;

	public String getSelRailroad() {
		return selRailroad;
	}

	public void setSelRailroad(String selRailroad) {
		this.selRailroad = selRailroad;
	}

	public TrsExptAckRailVndrVO getTrExptAckRailVndrVO() {
		return trExptAckRailVndrVO;
	}

	public void setTrExptAckRailVndrVO(TrsExptAckRailVndrVO trExptAckRailVndrVO) {
		this.trExptAckRailVndrVO = trExptAckRailVndrVO;
	}

	public TrsExptAckRailVndrVO[] getTrExptAckRailVndrVOs() {
		TrsExptAckRailVndrVO[] rtnVOs = null;
		if (this.trExptAckRailVndrVOs != null) {
			rtnVOs = Arrays.copyOf(this.trExptAckRailVndrVOs, this.trExptAckRailVndrVOs.length);
		}
		return rtnVOs;
	}

	public void setTrExptAckRailVndrVOs(TrsExptAckRailVndrVO[] trExptAckRailVndrVOs) {
		if (trExptAckRailVndrVOs != null) {
			TrsExptAckRailVndrVO[] tmpVOs = Arrays.copyOf(trExptAckRailVndrVOs, trExptAckRailVndrVOs.length);
			this.trExptAckRailVndrVOs = tmpVOs;
		}
	}

}
