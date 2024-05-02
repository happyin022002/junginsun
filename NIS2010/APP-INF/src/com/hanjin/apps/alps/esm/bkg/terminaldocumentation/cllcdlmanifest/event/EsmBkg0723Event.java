/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0723Event.java
*@FileTitle : ESM_BKG_0723
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0723 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0723HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0723HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0723Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	private CllCdlTransmitVO[] cllCdlTransmitVOs = null;
	
	private String inPortCd = null;
	private String inListType = null;
	
	private String key = "";

	public EsmBkg0723Event(){}

	public void setCllCdlTransmitVOs(CllCdlTransmitVO[] cllCdlTransmitVOs){
		if(cllCdlTransmitVOs != null){
			CllCdlTransmitVO[] tmpVOs = Arrays.copyOf(cllCdlTransmitVOs, cllCdlTransmitVOs.length);
			this.cllCdlTransmitVOs = tmpVOs;
		}
	}

	public CllCdlTransmitVO[] getCllCdlTransmitVOs(){
		CllCdlTransmitVO[] rtnVOs = null;
		if (this.cllCdlTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(cllCdlTransmitVOs, cllCdlTransmitVOs.length);
		}
		return rtnVOs;
	}
	
	public void setInPortCd(String inPortCd){
		this.inPortCd = inPortCd;
	}

	public String getInPortCd(){
		return inPortCd;
	}	
	
	public String getInListType() {
		return inListType;
	}

	public void setInListType(String inListType) {
		this.inListType = inListType;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
}