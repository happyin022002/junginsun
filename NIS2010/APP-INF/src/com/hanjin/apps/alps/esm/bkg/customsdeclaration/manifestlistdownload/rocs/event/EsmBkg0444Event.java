/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0444Event.java
*@FileTitle : ESM_BKG-0444
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
* 1.1 2015.04.27 소스보안 [CWE-495,766] 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;
import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0444 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0444HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-0444HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0444Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private RocsBlVO rocsBlVO = null; 	
	 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsVesselArrivalCondVO rocsVesselArrivalCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RocsVesselArrivalCondVO[] rocsVesselArrivalCondVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsManifestListCondVO rocsManifestListCondVO = null; 
	private RocscrnVO rocscrnVO = null;
	private String vslCd = null;  
	private String skdVoyNo = null;  
	private String skdDirCd = null;  
	private String frmCrnNumber = null;  
	private String ofcCd = null;
	private String userId = null;
	private String bkgNo = null;
	public String getVsl_cd() {
		return vslCd;
	}

	public String getOfc_cd() {
		return ofcCd;
	}

	public void setOfc_cd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String userId) {
		this.userId = userId;
	}

	public String getBkg_no() {
		return bkgNo;
	}

	public void setBkg_no(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setVsl_cd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkd_voy_no() {
		return skdVoyNo;
	}

	public void setSkd_voy_no(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkd_dir_cd() {
		return skdDirCd;
	}

	public void setSkd_dir_cd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getFrm_crn_number() {
		return frmCrnNumber;
	}

	public void setFrm_crn_number(String frmCrnNumber) {
		this.frmCrnNumber = frmCrnNumber;
	}

	public void setBlVO(RocsBlVO rocsBlVO){
		this. rocsBlVO = rocsBlVO;
	}	
	
	public RocsBlVO getBlVO(){
		return rocsBlVO;
	}

	public EsmBkg0444Event(){}
	
	 public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO){
			this. rocsManifestListCondVO = rocsManifestListCondVO;
		}
	 public void setRocscrnVO(RocscrnVO rocscrnVO){
			this. rocscrnVO = rocscrnVO;
		} 
	public void setRocsVesselArrivalCondVO(RocsVesselArrivalCondVO rocsVesselArrivalCondVO){
		this. rocsVesselArrivalCondVO = rocsVesselArrivalCondVO;
	}

	public void setRocsVesselArrivalCondVOS(RocsVesselArrivalCondVO[] rocsVesselArrivalCondVOs){
		if(rocsVesselArrivalCondVOs != null){
			RocsVesselArrivalCondVO[] tmpVOs = Arrays.copyOf(rocsVesselArrivalCondVOs, rocsVesselArrivalCondVOs.length);
			this.rocsVesselArrivalCondVOs = tmpVOs;
		}
	}	
	
	public RocsManifestListCondVO getRocsManifestListCondVO(){
		return rocsManifestListCondVO;
	} 
	public RocsVesselArrivalCondVO getRocsVesselArrivalCondVO(){
		return rocsVesselArrivalCondVO;
	}

	public VesselCondVO[] getRocsVesselArrivalCondVOS(){
		VesselCondVO[] rtnVOs = null;
		if (this.rocsVesselArrivalCondVOs != null) {
			rtnVOs = Arrays.copyOf(rocsVesselArrivalCondVOs, rocsVesselArrivalCondVOs.length);
		}
		return rtnVOs;
	}	
	public RocscrnVO getRocscrnVO(){
		return rocscrnVO;
	}

}