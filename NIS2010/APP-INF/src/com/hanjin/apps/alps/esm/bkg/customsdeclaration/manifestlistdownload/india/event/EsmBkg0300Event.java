/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0300Event.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.20 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFromDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0300 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0300HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0300HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0300Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	// 조회 조건
	private InPrintFormCondVO inPrintFormCondVO = null;
	
	// 조회 리턴
	private InPrintFromDetailVO indiaFormSettingDescVO = null;
	
	// 등록,입력
	private InPrintFormModiVO[] inPrintFormModiVOs = null;
	
	public EsmBkg0300Event(){}

	/**
	 * @return the inPrintFormCondVO
	 */
	public InPrintFormCondVO getInPrintFormCondVO() {
		return inPrintFormCondVO;
	}

	/**
	 * @param inPrintFormCondVO the inPrintFormCondVO to set
	 */
	public void setInPrintFormCondVO(InPrintFormCondVO inPrintFormCondVO) {
		this.inPrintFormCondVO = inPrintFormCondVO;
	}

	/**
	 * @return the indiaFormSettingDescVO
	 */
	public InPrintFromDetailVO getIndiaFormSettingDescVO() {
		return indiaFormSettingDescVO;
	}

	/**
	 * @param indiaFormSettingDescVO the indiaFormSettingDescVO to set
	 */
	public void setIndiaFormSettingDescVO(
			InPrintFromDetailVO indiaFormSettingDescVO) {
		this.indiaFormSettingDescVO = indiaFormSettingDescVO;
	}

	/**
	 * @return the inPrintFormModiVOs
	 */
	public InPrintFormModiVO[] getInPrintFormModiVOs() {
		return inPrintFormModiVOs;
	}

	/**
	 * @param inPrintFormModiVOs the inPrintFormModiVOs to set
	 */
	public void setInPrintFormModiVOs(InPrintFormModiVO[] inPrintFormModiVOs) {
		this.inPrintFormModiVOs = inPrintFormModiVOs;
	}

	
	
	
}