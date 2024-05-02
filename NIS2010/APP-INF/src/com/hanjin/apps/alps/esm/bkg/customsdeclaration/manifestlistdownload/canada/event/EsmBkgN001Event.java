/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : EsmBkgN001Event.java
 *@FileTitle : EsmBkgN001Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.11.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.11.01 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_N001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 
 * @see ESM_BKG_N001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkgN001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ManifestListCondVO manifestListCondVO = null;
	/** 조회결과 단건 */
	private UsaManifestListDetailVO usaManifestListDetailVO = null;
	/** 조회결과 복수 */
	private ManifestListDetailVO[] manifestListDetailVOs = null;
	private String customs = null;

	public EsmBkgN001Event() {
	}

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public UsaManifestListDetailVO getManifestListDetailVO() {
		return usaManifestListDetailVO;
	}

	public void setUsaManifestListDetailVO(UsaManifestListDetailVO manifestListDetailVO) {
		this.usaManifestListDetailVO = manifestListDetailVO;
	}

	public ManifestListDetailVO[] getManifestListDetailVOs() {
		ManifestListDetailVO[] rtnVOs = null;
		if (manifestListDetailVOs != null)
			rtnVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
		return rtnVOs;
	}

	public void setManifestListDetailVOs(ManifestListDetailVO[] manifestListDetailVOs) {
		if (manifestListDetailVOs != null)
			this.manifestListDetailVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
	}

	public String getCustoms() {
		return customs;
	}

	public void setCustoms(String customs) {
		this.customs = customs;
	}

	private String key = "";

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}