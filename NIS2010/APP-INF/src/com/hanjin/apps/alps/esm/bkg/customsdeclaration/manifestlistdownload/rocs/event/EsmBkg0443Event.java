/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0443Event.java
*@FileTitle : ESM_BKG-0443
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
* 1.1 2015.04.20 소스보안 [CWE-495,766] 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0443 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0443HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0443HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0443Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsManifestListCondVO rocsManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private RocsManifestListCondVO[] rocsManifestListCondVOs = null;
	
	private RocscrnVO rocscrnVO = null;
	
	private String frmCrnNumber = null;  
	private String vslCd = null;  
	 
	public String getFrm_crn_number() {
		return frmCrnNumber;
	}

	public void setFrmCrnNumber(String frmCrnNumber) {
		this.frmCrnNumber = frmCrnNumber;
	}

	private String skdVoyNo = null;  
	private String skdDirCd = null;  
	
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public EsmBkg0443Event(){}
	
	public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO){
		this. rocsManifestListCondVO = rocsManifestListCondVO;
	}

	public void setRocsManifestListCondVOS(RocsManifestListCondVO[] rocsManifestListCondVOs){
		if(rocsManifestListCondVOs != null){
			RocsManifestListCondVO[] tmpVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
			this.rocsManifestListCondVOs = tmpVOs;
		}
	}
	
	public void setRocscrnVO(RocscrnVO rocscrnVO){
		this. rocscrnVO = rocscrnVO;
	}
	
	public RocsManifestListCondVO getRocsManifestListCondVO(){
		return rocsManifestListCondVO;
	}
 
	public RocsManifestListCondVO[] getRocsManifestListCondVOS(){
		RocsManifestListCondVO[] rtnVOs = null;
		if (this.rocsManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
		}
		return rtnVOs;
	}
	
	public RocscrnVO getRocscrnVO(){
		return rocscrnVO;
	}
	
}
