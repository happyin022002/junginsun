/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0462Event.java
*@FileTitle : ESM_BKG-0462
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.18 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0462 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0462HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0462HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0462Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListCondVO japanManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private JapanManifestListCondVO[] japanManifestListCondVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanContainerVO japanContainerVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private JapanContainerVO[] japanContainerVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ManifestModificationVO manifestModificationVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private ManifestModificationVO[] manifestModificationVOs = null;	

	public EsmBkg0462Event(){}
	
	public void setJapanManifestListCondVO(JapanManifestListCondVO japanManifestListCondVO){
		this. japanManifestListCondVO = japanManifestListCondVO;
	}

	public void setJapanManifestListCondVOS(JapanManifestListCondVO[] japanManifestListCondVOs){
		this. japanManifestListCondVOs = japanManifestListCondVOs;
	}
	
	public void setJapanContainerVO(JapanContainerVO japanContainerVO){
		this. japanContainerVO = japanContainerVO;
	}

	public void setJapanContainerVOS(JapanContainerVO[] japanContainerVOs){
		this. japanContainerVOs = japanContainerVOs;
	}	
	
	public void setManifestModificationVO(ManifestModificationVO manifestModificationVO){
		this. manifestModificationVO = manifestModificationVO;
	}

	public void setManifestModificationVOS(ManifestModificationVO[] manifestModificationVOs){
		this. manifestModificationVOs = manifestModificationVOs;
	}	
	
	public JapanManifestListCondVO getJapanManifestListCondVO(){
		return japanManifestListCondVO;
	}
 
	public JapanManifestListCondVO[] getJapanManifestListCondVOS(){
		return japanManifestListCondVOs;
	}	
	
	public JapanContainerVO getJapanContainerVO(){
		return japanContainerVO;
	}

	public JapanContainerVO[] getJapanContainerVOS(){
		return japanContainerVOs;
	}
	
	public ManifestModificationVO getManifestModificationVO(){
		return manifestModificationVO;
	}

	public ManifestModificationVO[] getManifestModificationVOs(){
		return manifestModificationVOs;
	}
}
