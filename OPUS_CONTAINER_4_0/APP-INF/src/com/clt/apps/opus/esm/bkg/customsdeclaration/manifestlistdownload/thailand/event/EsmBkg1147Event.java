/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmBkg1141Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.03
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.03 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.event;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_1141HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EsmBkg1147Event extends EventSupport {

	public EsmBkg1147Event() {}

	private ThailandVvdInfoCondVO thailandVvdInfoCondVO = null; 
	private List<ThailandVvdInfoVO> thailandVvdInfoVOs = null;
	private List<ThailandVvdInfoCondVO> thailandVvdInfoCondVOs = null;
	private ThailandManifestListCondVO thailandManifestListCondVO = null;
	
	public ThailandVvdInfoCondVO getThailandVvdInfoCondVO() {
		return thailandVvdInfoCondVO;
	}
	public void setThailandVvdInfoCondVO(ThailandVvdInfoCondVO thailandVvdInfoCondVO) {
		this.thailandVvdInfoCondVO = thailandVvdInfoCondVO;
	}
	public List<ThailandVvdInfoVO> getThailandVvdInfoVOs() {
		return thailandVvdInfoVOs;
	}
	public void setThailandVvdInfoVOs(List<ThailandVvdInfoVO> thailandVvdInfoVOs) {
		this.thailandVvdInfoVOs = thailandVvdInfoVOs;
	}
	public List<ThailandVvdInfoCondVO> getThailandVvdInfoCondVOs() {
		return thailandVvdInfoCondVOs;
	}
	public void setThailandVvdInfoCondVOs(
			List<ThailandVvdInfoCondVO> thailandVvdInfoCondVOs) {
		this.thailandVvdInfoCondVOs = thailandVvdInfoCondVOs;
	}
	public ThailandManifestListCondVO getThailandManifestListCondVO() {
		return thailandManifestListCondVO;
	}
	public void setThailandManifestListCondVO(
			ThailandManifestListCondVO thailandManifestListCondVO) {
		this.thailandManifestListCondVO = thailandManifestListCondVO;
	}
	
	

}