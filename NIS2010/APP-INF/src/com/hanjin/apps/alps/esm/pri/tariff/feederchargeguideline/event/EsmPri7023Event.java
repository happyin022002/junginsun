/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7023Event.java
 *@FileTitle : Add-on Tariff Creation & Amendment – Special Cargo
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7023HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7023Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String svcScpCd = null;

	private String fdrTrfNo = null;

	private String verMapgSeq = null;

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	public String getFdrTrfNo() {
		return fdrTrfNo;
	}

	public void setFdrTrfNo(String fdrTrfNo) {
		this.fdrTrfNo = fdrTrfNo;
	}

	public String getVerMapgSeq() {
		return verMapgSeq;
	}

	public void setVerMapgSeq(String verMapgSeq) {
		this.verMapgSeq = verMapgSeq;
	}

}
