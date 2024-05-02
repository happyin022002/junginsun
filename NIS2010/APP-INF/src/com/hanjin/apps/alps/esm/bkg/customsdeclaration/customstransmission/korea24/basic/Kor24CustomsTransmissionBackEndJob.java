/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : Kor24CustomsTransmissionBackEndJob.java
 *@FileTitle : Kor24CustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.01.26
 *@LastModifier : 박성진
 *@LastVersion : 1.0
 * 2011.01.26 박성진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;


/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Sung Jin
 * @see
 * @since J2EE 1.4
 */
public class Kor24CustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO manifestTransmitVO = null;
	private String pgmNo;

	/**
	 * 다운로드 할 데이터 세팅<br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 */
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	/**
	 * 화면ID세팅<br>
	 *
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start<br>
	 *
	 * @return Object
	 */
	public String doStart() throws Exception {

		Kor24CustomsTransmissionBC command = null;
		if (pgmNo.startsWith("ESM_BKG_1344") ) {	// KOR
			command = new Kor24CustomsTransmissionBCImpl();
			return command.transmitManifest(manifestTransmitVO);
		}

		return "Y";
	}


}
