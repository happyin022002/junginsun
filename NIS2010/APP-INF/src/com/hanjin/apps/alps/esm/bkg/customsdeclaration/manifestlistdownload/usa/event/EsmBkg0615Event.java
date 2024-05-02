/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0615Event.java
*@FileTitle : US AMS: Manifest EXPORT Transmit (XI)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.01 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_0615HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0615Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** AuthSetup정보 조회조건 */
	private ManifestListCondVO condVO = null;
	/** AuthSetup정보 단건  */
	private UsaManifestSearchDetailVO infoVO = null;
	/** AuthSetup정보 복수 */
	private UsaManifestSearchDetailVO[] infoVOs = null;
	/** backEndJob key. */
	private String key = "";
	/** Actual Vvd */
	private VesselCondVO vesselCondVO = null;
	
	public EsmBkg0615Event(){}

	/** Set Method **/
	public void setCondVO(ManifestListCondVO condVO){
		this. condVO = condVO;
	}
	public void setUsaManifestSearchDetailVO(UsaManifestSearchDetailVO infoVO){
		this. infoVO = infoVO;
	}
	public void setUsaManifestSearchDetailVOS(UsaManifestSearchDetailVO[] infoVOs){
		if(infoVOs != null){
			UsaManifestSearchDetailVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}
	public void setVesselCondVO(VesselCondVO vesselCondVO){
		this. vesselCondVO = vesselCondVO;
	}

	/** Get Method **/
	public ManifestListCondVO getManifestListCondVO(){
		return condVO;
	}
	public UsaManifestSearchDetailVO getUsaManifestSearchDetailVO(){
		return infoVO;
	}
	public UsaManifestSearchDetailVO[] getUsaManifestSearchDetailVOS(){
		UsaManifestSearchDetailVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}
	public VesselCondVO getVesselCondVO(){
		return vesselCondVO;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
}