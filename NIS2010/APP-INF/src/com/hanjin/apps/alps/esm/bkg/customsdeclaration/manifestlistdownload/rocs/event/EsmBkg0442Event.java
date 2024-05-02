/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0442Event.java
*@FileTitle : ESM_BKG-0442
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
* 1.1 2015.04.20 소스보안 [CWE-495,766] 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestConfirmationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0440 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0661HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0442Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsManifestListCondVO rocsManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private RocsManifestListCondVO[] rocsManifestListCondVOs = null;
	
	private RocsManifestConfirmationVO rocsManifestConfirmationVO = null; 
	
	private RocsManifestConfirmationVO[] rocsManifestConfirmationVOs = null;
	
	private ManifestModificationVO manifestModificationVO = null;
	private ManifestModificationVO[] manifestModificationVOs = null;
	
	private RocsBlModificationVO rocsBlModificationVO = null;
	
	 
	private RocsBlKeyVO[] rocsBlKeyVOs = null;
	
    public EsmBkg0442Event(){}
    
    public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO){
		this. rocsManifestListCondVO = rocsManifestListCondVO;
	}
    
    public void setRocsBlModificationVO(RocsBlModificationVO rocsBlModificationVO){
		this. rocsBlModificationVO = rocsBlModificationVO;
	}
    
    public void setRocsManifestConfirmationVO(RocsManifestConfirmationVO rocsManifestConfirmationVO){
		this. rocsManifestConfirmationVO = rocsManifestConfirmationVO;
	}

	public void setRocsManifestListCondVOS(RocsManifestListCondVO[] rocsManifestListCondVOs){
		if(rocsManifestListCondVOs != null){
			RocsManifestListCondVO[] tmpVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
			this.rocsManifestListCondVOs = tmpVOs;
		}
	}
	
	public void setRocsBlKeyVOS(RocsBlKeyVO[] rocsBlKeyVOs){
		if(rocsBlKeyVOs != null){
			RocsBlKeyVO[] tmpVOs = Arrays.copyOf(rocsBlKeyVOs, rocsBlKeyVOs.length);
			this.rocsBlKeyVOs = tmpVOs;
		}
	}
	
	public void setRocsManifestConfirmationVOs(RocsManifestConfirmationVO[] rocsManifestConfirmationVOs){
		if(rocsManifestConfirmationVOs != null){
			RocsManifestConfirmationVO[] tmpVOs = Arrays.copyOf(rocsManifestConfirmationVOs, rocsManifestConfirmationVOs.length);
			this.rocsManifestConfirmationVOs = tmpVOs;
		}
	}
	
	public RocsManifestListCondVO getRocsManifestListCondVO(){
		return rocsManifestListCondVO;
	}
	
	public RocsBlModificationVO getRocsBlModificationVO(){
		return rocsBlModificationVO;
	}
	
	public RocsManifestConfirmationVO getRocsManifestConfirmationVO(){
		return rocsManifestConfirmationVO;
	}
	
	public RocsManifestConfirmationVO[] getRocsManifestConfirmationVOs(){
		RocsManifestConfirmationVO[] rtnVOs = null;
		if (this.rocsManifestConfirmationVOs != null) {
			rtnVOs = Arrays.copyOf(rocsManifestConfirmationVOs, rocsManifestConfirmationVOs.length);
		}
		return rtnVOs;
	}
	
	public RocsBlKeyVO[] getRocsBlKeyVOs(){
		RocsBlKeyVO[] rtnVOs = null;
		if (this.rocsBlKeyVOs != null) {
			rtnVOs = Arrays.copyOf(rocsBlKeyVOs, rocsBlKeyVOs.length);
		}
		return rtnVOs;
	}
 
	public RocsManifestListCondVO[] getRocsManifestListCondVOS(){
		RocsManifestListCondVO[] rtnVOs = null;
		if (this.rocsManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
		}
		return rtnVOs;
	}	
	/**
	 * @param manifestModificationVOs the manifestModificationVOs to set
	 */
	public void setManifestModificationVOs(ManifestModificationVO[] manifestModificationVOs){
		if(manifestModificationVOs != null){
			ManifestModificationVO[] tmpVOs = Arrays.copyOf(manifestModificationVOs, manifestModificationVOs.length);
			this.manifestModificationVOs = tmpVOs;
		}
	}

	/**
	 * @return the manifestModificationVO
	 */
	public ManifestModificationVO getManifestModificationVO() {
		return manifestModificationVO;
	}
	
	/**
	 * @return the manifestModificationVOs
	 */
	public ManifestModificationVO[] getManifestModificationVOs() {
		ManifestModificationVO[] rtnVOs = null;
		if (this.manifestModificationVOs != null) {
			rtnVOs = Arrays.copyOf(manifestModificationVOs, manifestModificationVOs.length);
		}
		return rtnVOs;
	}
	
	 
}
