/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7022Event.java
 *@FileTitle : Tariff code mapping
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.04.29
 *@LastModifier : 김보배
 *@LastVersion : 1.0
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.TariffCodeMappingVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7022HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author BOBAE KIM
 * @see ESM_PRI_7022HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7022Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String cntCd;
	private TariffCodeMappingVO[] tariffCodeMappingVOs = null;

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public TariffCodeMappingVO[] getTariffCodeMappingVOs() {
		return tariffCodeMappingVOs;
	}

	public void setTariffCodeMappingVOs(TariffCodeMappingVO[] tariffCodeMappingVOs) {
		this.tariffCodeMappingVOs = tariffCodeMappingVOs;
	}


}
