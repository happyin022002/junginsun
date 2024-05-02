/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EurCustomsTransmissionBackEndJob.java
 *@FileTitle : EurCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.15
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.10.15 경종윤
 * 1.0 Creation
 * --------------------------------------------------
 * History
 * 2011.11.21 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
 * 2015.04.23 소스보안 [CWE-495,766]  수정
 * 2015.10.06 소스보안 라이브 반영
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.basic;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyoung Jong Yun
 * @see EurCustomsTransmissionBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EurCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO manifestTransmitVO = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private String pgmNo;


	/**
	 * 다운로드 할 데이터 세팅 0484화면.<br>
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
	public Object doStart() throws Exception {
		
		CustomsTransmissionBC command = new EurCustomsTransmissionBCImpl();
		
		/*
		if (pgmNo.startsWith("ESM_BKG_0484") 
				|| pgmNo.startsWith("ESM_BKG_0257")) {	// Sitpro or CTA
			command = new EurCustomsTransmissionBCImpl();
			command.transmitManifest(manifestTransmitVO);
		}
		*/
		if(pgmNo.startsWith("ESM_BKG_0257")) { // CTA
			command.transmitManifest(manifestTransmitVOs, null);
		} else if(pgmNo.startsWith("ESM_BKG_0484")) { // SITPRO
			command.transmitManifest(manifestTransmitVOs);
		}
		
		return null;
	}

	/**
	 * @return the manifestTransmitVOs
	 */
	public ManifestTransmitVO[] getManifestTransmitVOs() {
		ManifestTransmitVO[] rtnVOs = null;
		if (this.manifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manifestTransmitVOs the manifestTransmitVOs to set
	 */
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs){
		if(manifestTransmitVOs != null){
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
	}
	

	
}