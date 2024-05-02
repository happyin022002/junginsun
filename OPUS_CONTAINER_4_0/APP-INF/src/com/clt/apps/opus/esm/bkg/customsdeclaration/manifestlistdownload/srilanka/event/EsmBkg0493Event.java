/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0493Event.java
*@FileTitle : ESM_BKG-0493
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.10 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0493 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0493HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-0493HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0493Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private SriLankaVesselArrivalCondVO[] sriLankaVesselArrivalCondVOs = null;
	private SriLankaVesselArrivalVO sriLankaVesselArrivalVO = null;
	private SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalTransmitVO = null;
	private String vslcd = null;
	private String skdvoyno = null;
	private String skddircd = null;
	private String vslnm = null;
	private String pgno = null;

	public String getVsl_cd() {
		return vslcd;
	}

	public String getPgNo() {
		return pgno;
	}

	public String getVsl_Nm() {
		return vslnm;
	}

	public void setVsl_Nm(String vslnm) {
		this.vslnm = vslnm;
	}

	public void setPgNO(String pgno) {
		this.pgno = pgno;
	}

	public void setVsl_cd(String vslcd) {
		this.vslcd = vslcd;
	}

	public String getSkd_voy_no() {
		return skdvoyno;
	}

	public void setSkd_voy_no(String skdvoyno) {
		this.skdvoyno = skdvoyno;
	}

	public String getSkd_dir_cd() {
		return skddircd;
	}

	public void setSkd_dir_cd(String skddircd) {
		this.skddircd = skddircd;
	}

	public EsmBkg0493Event() {}

	public SriLankaVesselArrivalCondVO getSriLankaVesselArrivalCondVO() {
		return sriLankaVesselArrivalCondVO;
	}

	public SriLankaVesselArrivalTransmitVO getSriLankaVesselArrivalTransmitVO() {
		return sriLankaVesselArrivalTransmitVO;
	}

	public void setSriLankaVesselArrivalCondVO(SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO) {
		this. sriLankaVesselArrivalCondVO = sriLankaVesselArrivalCondVO;
	}

	public void setSriLankaVesselArrivalVO(SriLankaVesselArrivalVO sriLankaVesselArrivalVO) {
		this. sriLankaVesselArrivalVO = sriLankaVesselArrivalVO;
	}

	public void setSriLankaVesselArrivalTransmitVO(SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalTransmitVO) {
		this. sriLankaVesselArrivalTransmitVO = sriLankaVesselArrivalTransmitVO;
	}

	public SriLankaVesselArrivalVO getSriLankaVesselArrivalVO() {
		return sriLankaVesselArrivalVO;
	}

	public SriLankaVesselArrivalCondVO[] getSriLankaVesselArrivalCondVOS() {
		SriLankaVesselArrivalCondVO[] rtnVOs = null;
		if (this.sriLankaVesselArrivalCondVOs != null) {
			rtnVOs = Arrays.copyOf(sriLankaVesselArrivalCondVOs, sriLankaVesselArrivalCondVOs.length);
		}
		return rtnVOs;
	}

	public void setSriLankaVesselArrivalCondVOs(SriLankaVesselArrivalCondVO[] sriLankaVesselArrivalCondVOs) {
		if (sriLankaVesselArrivalCondVOs != null) {
			SriLankaVesselArrivalCondVO[] tmpVOs = Arrays.copyOf(sriLankaVesselArrivalCondVOs, sriLankaVesselArrivalCondVOs.length);
			this.sriLankaVesselArrivalCondVOs = tmpVOs;
		}
	}


}