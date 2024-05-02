/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1523Event.java
*@FileTitle : EsmBkg1523Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaVvdVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1523 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1523HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1523HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1523Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private MalaysiaVvdVO malaysiaVvdVO;
	private MalaysiaVvdVO[] malaysiaVvdVOs;

	/**
	 * @return the malaysiaVvdVO
	 */
	public MalaysiaVvdVO getMalaysiaVvdVO() {
		return malaysiaVvdVO;
	}

	/**
	 * @param malaysiaVvdVO the malaysiaVvdVO to set
	 */
	public void setMalaysiaVvdVO(MalaysiaVvdVO malaysiaVvdVO) {
		this.malaysiaVvdVO = malaysiaVvdVO;
	}

	/**
	 * @return the malaysiaVvdVOs
	 */
	public MalaysiaVvdVO[] getMalaysiaVvdVOs() {
		MalaysiaVvdVO[] rtnVOs = null;
		if (this.malaysiaVvdVOs != null) {
			rtnVOs = new MalaysiaVvdVO[malaysiaVvdVOs.length];
			System.arraycopy(malaysiaVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param malaysiaVvdVOs the malaysiaVvdVOs to set
	 */
	public void setMalaysiaVvdVOs(MalaysiaVvdVO[] malaysiaVvdVOs) {
		if (malaysiaVvdVOs != null) {
			MalaysiaVvdVO[] tmpVOs = new MalaysiaVvdVO[malaysiaVvdVOs.length];
			System.arraycopy(malaysiaVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.malaysiaVvdVOs = tmpVOs;
		}
	}

}
