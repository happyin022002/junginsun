/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1525Event.java
*@FileTitle : EsmBkg1525Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaVvdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_1525 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1525HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1525HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1525Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String portCd = null;
	private String etbDt1 = null;
	private String etbDt2 = null;
	private MalaysiaVvdVO[] malaysiaVvdVOs = null;

	/**
	 * @return the malaysiaVvdVOs
	 */
	public MalaysiaVvdVO[] getMalaysiaVvdVOs() {
		MalaysiaVvdVO[] rtnVOs = null;
		if (this.malaysiaVvdVOs != null) {
			rtnVOs = Arrays.copyOf(malaysiaVvdVOs, malaysiaVvdVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param malaysiaVvdVOs the malaysiaVvdVOs to set
	 */
	public void setMalaysiaVvdVOs(MalaysiaVvdVO[] malaysiaVvdVOs) {
		if (malaysiaVvdVOs != null) {
			MalaysiaVvdVO[] tmpVOs = Arrays.copyOf(malaysiaVvdVOs, malaysiaVvdVOs.length);
			this.malaysiaVvdVOs = tmpVOs;
		}
	}

	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @return the etbDt1
	 */
	public String getEtbDt1() {
		return etbDt1;
	}

	/**
	 * @param etbDt1 the etbDt1 to set
	 */
	public void setEtbDt1(String etbDt1) {
		this.etbDt1 = etbDt1;
	}

	/**
	 * @return the etbDt2
	 */
	public String getEtbDt2() {
		return etbDt2;
	}

	/**
	 * @param etbDt2 the etbDt2 to set
	 */
	public void setEtbDt2(String etbDt2) {
		this.etbDt2 = etbDt2;
	}

}
