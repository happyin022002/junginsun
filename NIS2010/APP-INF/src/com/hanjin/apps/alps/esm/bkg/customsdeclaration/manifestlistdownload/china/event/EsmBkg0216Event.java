/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0216Event.java
*@FileTitle : EsmBkg0216Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0216 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0216HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0216HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0216Event extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private ManifestListCondVO manifestListCondVO  = null;
	private ManifestListDetailVO[] manifestListDetailVOs = null;

	private String transMode = null;
	private String key = ""; // BackEndJob 등록 키
	
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
		return manifestListDetailVOs;
	}
	/**
	 * @param manifestListDetailVOs the manifestListDetailVOs to set
	 */
	public void setManifestListDetailVOs(
			ManifestListDetailVO[] manifestListDetailVOs) {
		this.manifestListDetailVOs = manifestListDetailVOs;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the transMode
	 */
	public String getTransMode() {
		return transMode;
	}
	/**
	 * @param transMode the transMode to set
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	
}
