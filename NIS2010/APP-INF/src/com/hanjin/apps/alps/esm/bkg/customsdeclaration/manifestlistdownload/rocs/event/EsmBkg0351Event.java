/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0351Event.java
*@FileTitle : ESM_BKG-0351
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
* 1.1 2015.04.20 소스보안 [CWE-495,766] 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlSeqVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0351 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0351HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0351HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0351Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsManifestListCondVO rocsManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private RocsManifestListCondVO[] rocsManifestListCondVOs = null;
	private RocsBlSeqVO[] rocsBlSeqVOs = null;
    public EsmBkg0351Event(){}
    
    public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO){
		this. rocsManifestListCondVO = rocsManifestListCondVO;
	}

	public void setRocsManifestListCondVOS(RocsManifestListCondVO[] rocsManifestListCondVOs){
		if(rocsManifestListCondVOs != null){
			RocsManifestListCondVO[] tmpVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
			this.rocsManifestListCondVOs = tmpVOs;
		}
	}
	public void setRocsBlKeyVOS(RocsBlSeqVO[] rocsBlKeyVOs){
		if(rocsBlKeyVOs != null){
			RocsBlSeqVO[] tmpVOs = Arrays.copyOf(rocsBlKeyVOs, rocsBlKeyVOs.length);
			this.rocsBlSeqVOs = tmpVOs;
		}
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
	public RocsBlSeqVO[] getRocsBlSeqVOs(){
		RocsBlSeqVO[] rtnVOs = null;
		if (this.rocsBlSeqVOs != null) {
			rtnVOs = Arrays.copyOf(rocsBlSeqVOs, rocsBlSeqVOs.length);
		}
		return rtnVOs;
	}
	
	 
}
