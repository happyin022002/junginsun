/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1162Event.java
*@FileTitle : ESM_BKG_1162
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2013.07.04 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1162 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1162HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  경종윤
 * @see ESM_BKG_1162HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1162Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private ManifestListCondVO   manifestListCondVO = null;
	private ManifestListDetailVO[] manifestListDetailVOs = null;
	private String key = "";

	/**
	 * @return the manifestListCondVO
	 */
	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	/**
	 * @param manifestListCondVO the manifestListCondVO to set
	 */
	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	
	
	/**
	 * @return the manifestListDetailVOs
	 */
	public ManifestListDetailVO[] getManifestListDetailVOs() {
		ManifestListDetailVO[] rtnVOs = null;
		if (this.manifestListDetailVOs != null) {
			rtnVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manifestListDetailVOs the manifestListDetailVOs to set
	 */
	public void setManifestListDetailVOs(ManifestListDetailVO[] manifestListDetailVOs){
		if(manifestListDetailVOs != null){
			ManifestListDetailVO[] tmpVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
