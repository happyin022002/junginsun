/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1023Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.13
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.08.13 김도완
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_1023HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1023Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private StowageManifestCondVO stowageManifestCondVO = null;
	private StiDetailVO[] detailVOs = null;
	private StiDetailCndVO[] detailCndVOs = null;
	private String customs = null;
	private String key = "";

	public EsmBkg1023Event() {}

	public void setUsaStowageManifestCondVO(StowageManifestCondVO stowageManifestCondVO) {
		this.stowageManifestCondVO = stowageManifestCondVO;
	}
	public StowageManifestCondVO getUsaStowageManifestCondVO() {
		return stowageManifestCondVO;
	}

	public void setUsaStowageManifestDetailVOs(StiDetailVO[] detailVOs){
		if(detailVOs != null){
			StiDetailVO[] tmpVOs = Arrays.copyOf(detailVOs, detailVOs.length);
			this.detailVOs = tmpVOs;
		}
	}
	public StiDetailVO[] getUsaStowageManifestDetailVOs() {
		StiDetailVO[] rtnVOs = null;
		if (this.detailVOs != null) {
			rtnVOs = Arrays.copyOf(detailVOs, detailVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCndStowageManifestDetailVOs(StiDetailCndVO[] detailCndVOs){
		if(detailCndVOs != null){
			StiDetailCndVO[] tmpVOs = Arrays.copyOf(detailCndVOs, detailCndVOs.length);
			this.detailCndVOs = tmpVOs;
		}
	}
	public StiDetailCndVO[] getCndStowageManifestDetailVOs() {
		StiDetailCndVO[] rtnVOs = null;
		if (this.detailCndVOs != null) {
			rtnVOs = Arrays.copyOf(detailCndVOs, detailCndVOs.length);
		}
		return rtnVOs;
	}
	
	public String getCustoms() {
		return customs;
	}
	
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
}