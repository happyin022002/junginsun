/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0458Event.java
*@FileTitle : ESM_BKG-0458
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0458 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0458HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0458HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0458Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListMfrCondVO japanManifestListMfrCondVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MfrCustModificationVO mfrCustModificationVO = null;
	/** Table Value Object Multi Data 처리 */
	private MfrMndModificationVO mfrMndModificationVO = null;

	public EsmBkg0458Event(){}

	public void setJapanManifestListMfrCondVO(JapanManifestListMfrCondVO japanManifestListMfrCondVO){
		this. japanManifestListMfrCondVO = japanManifestListMfrCondVO;
	}

	public JapanManifestListMfrCondVO getJapanManifestListMfrCondVO(){
		return japanManifestListMfrCondVO;
	}

	public void setJapanMfrCustModificationVO(MfrCustModificationVO mfrCustModificationVO){
		this. mfrCustModificationVO = mfrCustModificationVO;
	}

	public MfrCustModificationVO getJapanMfrCustModificationVO(){
		return mfrCustModificationVO;
	}

	public void setMfrMndModificationVO(MfrMndModificationVO mfrMndModificationVO){
		this. mfrMndModificationVO = mfrMndModificationVO;
	}

	public MfrMndModificationVO getMfrMndModificationVO(){
		return mfrMndModificationVO;
	}
}
