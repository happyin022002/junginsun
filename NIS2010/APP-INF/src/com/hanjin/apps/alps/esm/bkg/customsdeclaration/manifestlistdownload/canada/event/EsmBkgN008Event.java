/*=========================================================
*Copyright(c) 2017 SMLines
*@FileName : EsmBkgN008Event.java
*@FileTitle : B/L INQUIRY: C/M Information
*Open Issues :
*Change history :
*@LastModifyDate : 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_N008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_N008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_N008HTMLAction 참조 
 * @since J2EE 1.6
 */

public class EsmBkgN008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String cntCd = null;
	
	/** Table Value Object 조회 조건 처리  */
	private ContainerManifestCondVO containerManifestCondVO = null;
	private UsaContainerManifestListVO[] containerManifestListVOs = null;
	
	public ContainerManifestCondVO getContainerManifestCondVO() {
		return containerManifestCondVO;
	}
	public void setContainerManifestCondVO(
			ContainerManifestCondVO containerManifestCondVO) {
		this.containerManifestCondVO = containerManifestCondVO;
	}
	/**
	 * @return the containerManifestListVOs
	 */
	public UsaContainerManifestListVO[] getContainerManifestListVOs() {
		UsaContainerManifestListVO[] rtnVOs = null;
		if (this.containerManifestListVOs != null) {
			rtnVOs = Arrays.copyOf(containerManifestListVOs, containerManifestListVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param containerManifestListVOs the containerManifestListVOs to set
	 */
	public void setContainerManifestListVOs(UsaContainerManifestListVO[] containerManifestListVOs){
		if(containerManifestListVOs != null){
			UsaContainerManifestListVO[] tmpVOs = Arrays.copyOf(containerManifestListVOs, containerManifestListVOs.length);
			this.containerManifestListVOs = tmpVOs;
		}
	}

	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}
	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
}