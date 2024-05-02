/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0036Event.java
 *@FileTitle : B/L INQUIRY: C/M Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.02 이수빈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Subin
 * @see ESM_BKG_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String cntCd = null;

	/** Table Value Object 조회 조건 처리 */
	private ContainerManifestCondVO containerManifestCondVO = null;
	private UsaContainerManifestListVO[] containerManifestListVOs = null;

	public ContainerManifestCondVO getContainerManifestCondVO() {
		return containerManifestCondVO;
	}

	public void setContainerManifestCondVO(ContainerManifestCondVO containerManifestCondVO) {
		this.containerManifestCondVO = containerManifestCondVO;
	}

	/**
	 * @return the containerManifestListVOs
	 */
	public UsaContainerManifestListVO[] getContainerManifestListVOs() {
		UsaContainerManifestListVO[] rtnVOs = null;
		if (containerManifestListVOs != null)
			rtnVOs = Arrays.copyOf(containerManifestListVOs, containerManifestListVOs.length);
		return rtnVOs;
	}

	/**
	 * @param containerManifestListVOs
	 *            the containerManifestListVOs to set
	 */
	public void setContainerManifestListVOs(UsaContainerManifestListVO[] containerManifestListVOs) {
		if (containerManifestListVOs != null)
			this.containerManifestListVOs = Arrays.copyOf(containerManifestListVOs, containerManifestListVOs.length);
	}

	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}

	/**
	 * @param cntCd
	 *            the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
}