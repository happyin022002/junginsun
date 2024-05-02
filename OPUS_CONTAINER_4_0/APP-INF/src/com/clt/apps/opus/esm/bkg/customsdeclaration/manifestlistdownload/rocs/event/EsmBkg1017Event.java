/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1017Event.java
 *@FileTitle : ESM_BKG-1017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-1017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG-1017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LIM JAE TAEK
 * @see ESM_BKG-1017HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1017Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private RocsBlVO rocsBlVO = null;
	private RocsBlKeyVO rocsBlKeyVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RocsVesselArrivalCondVO rocsVesselArrivalCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private RocsVesselArrivalCondVO[] rocsVesselArrivalCondVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RocsManifestListCondVO rocsManifestListCondVO = null;
	private RocscrnVO rocscrnVO = null;
	private String vslcd = null;
	private String skdvoyno = null;
	private String skddircd = null;
	private String frmcrnnumber = null;
	private String ofccd = null;
	private String userid = null;
	private String bkgno = null;

	public String getVsl_cd() {
		return vslcd;
	}

	public String getOfc_cd() {
		return ofccd;
	}

	public void setOfc_cd(String ofccd) {
		this.ofccd = ofccd;
	}

	public String getUser_id() {
		return userid;
	}

	public void setUser_id(String userid) {
		this.userid = userid;
	}

	public String getBkg_no() {
		return bkgno;
	}

	public void setBkg_no(String bkgno) {
		this.bkgno = bkgno;
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

	public String getFrm_crn_number() {
		return frmcrnnumber;
	}

	public void setFrm_crn_number(String frmcrnnumber) {
		this.frmcrnnumber = frmcrnnumber;
	}

	public void setBlVO(RocsBlVO rocsBlVO) {
		this.rocsBlVO = rocsBlVO;
	}

	public RocsBlVO getBlVO() {
		return rocsBlVO;
	}

	public RocsBlKeyVO getRocsBlKeyVO() {
		return rocsBlKeyVO;
	}

	public EsmBkg1017Event() {
	}

	public void setRocsBlKeyVO(RocsBlKeyVO rocsBlKeyVO) {
		this.rocsBlKeyVO = rocsBlKeyVO;
	}

	public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO) {
		this.rocsManifestListCondVO = rocsManifestListCondVO;
	}

	public void setRocscrnVO(RocscrnVO rocscrnVO) {
		this.rocscrnVO = rocscrnVO;
	}

	public void setRocsVesselArrivalCondVO(RocsVesselArrivalCondVO rocsVesselArrivalCondVO) {
		this.rocsVesselArrivalCondVO = rocsVesselArrivalCondVO;
	}

	public void setRocsVesselArrivalCondVOS(RocsVesselArrivalCondVO[] rocsVesselArrivalCondVOs) {
		if (rocsVesselArrivalCondVOs != null)
			this.rocsVesselArrivalCondVOs = Arrays.copyOf(rocsVesselArrivalCondVOs, rocsVesselArrivalCondVOs.length);
	}

	public RocsManifestListCondVO getRocsManifestListCondVO() {
		return rocsManifestListCondVO;
	}

	public RocsVesselArrivalCondVO getRocsVesselArrivalCondVO() {
		return rocsVesselArrivalCondVO;
	}

	public VesselCondVO[] getRocsVesselArrivalCondVOS() {
		VesselCondVO[] rtnVOs = null;
		if (rocsVesselArrivalCondVOs != null)
			rtnVOs = Arrays.copyOf(rocsVesselArrivalCondVOs, rocsVesselArrivalCondVOs.length);
		return rtnVOs;
	}

	public RocscrnVO getRocscrnVO() {
		return rocscrnVO;
	}

}