/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0015Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.29 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_1008HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** AuthSetup정보 조회조건 */
	private AuthSetupListCondVO condVO = null;
	/** AuthSetup정보 단건  */
	private AuthSetupListVO infoVO = null;
	/** AuthSetup정보 복수 */
	private AuthSetupListVO[] infoVOs = null;
	private List<AuthSetupListVO> infoVOLs = null;
	
	public EsmBkg1008Event(){}

	/** Set Method **/
	public void setCondVO(AuthSetupListCondVO condVO){
		this. condVO = condVO;
	}
	public void setAuthSetupListVO(AuthSetupListVO infoVO){
		this. infoVO = infoVO;
	}
	public void setAuthSetupListVOS(AuthSetupListVO[] infoVOs){
		if(infoVOs != null){
			AuthSetupListVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}
	public void setAuthSetupListVOLS(List<AuthSetupListVO> infoVOLs){
		this. infoVOLs = infoVOLs;
	}

	/** Get Method **/
	public AuthSetupListCondVO getAuthSetupListCondVO(){
		return condVO;
	}
	public AuthSetupListVO getAuthSetupListVO(){
		return infoVO;
	}
	public AuthSetupListVO[] getAuthSetupListVOS(){
		AuthSetupListVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}
	public List<AuthSetupListVO> getAuthSetupListVOLS(){
		return infoVOLs;
	}
}