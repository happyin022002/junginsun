/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MalaysiaManifestDownloadBackEndJob.java.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier :
**@LastVersion : 1.0
* 2015.11.11
* 1.0 Creation
*
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;


/**
 * OPUS-CustomsDeclaration Business Logic Command Interface<br>
 * - OPUS-CustomsDeclaration 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see MalaysiaManifestDownloadBCImpl 참조
 * @since J2EE 1.6
 */

@SuppressWarnings("serial")
public class MalaysiaManifestDownloadBackEndJob extends BackEndCommandSupport{

	private String pgmNo = "";
	private MalaysiaImpStsVO[] malaysiaImpStsVOs = null;

	/**
	 * 화면ID세팅
	 *
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * ESM_BKG_1522 Param
	 *
	 * @param MalaysiaImpStsVO[] malaysiaImpStsVOs
	 */
	public void setMalaysiaImpStsVOs(MalaysiaImpStsVO[] malaysiaImpStsVOs) {
		if (malaysiaImpStsVOs != null) {
			MalaysiaImpStsVO[] tmpVOs = Arrays.copyOf(malaysiaImpStsVOs, malaysiaImpStsVOs.length);
			this.malaysiaImpStsVOs = tmpVOs;
		}
	}

	/**
	 * BackEndCommand Start
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		try {
			if (pgmNo.startsWith("ESM_BKG_1522-Save")) {
				command.manageImpSts(this.malaysiaImpStsVOs);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return "Success";
	}


}
