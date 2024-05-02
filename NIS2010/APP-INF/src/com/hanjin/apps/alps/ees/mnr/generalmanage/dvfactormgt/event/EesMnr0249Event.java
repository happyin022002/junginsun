/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EssMnr0249Event.java
*@FileTitle : DV - Leased Unit
*Open Issues :	ALPS MNR-Total-DV 화면에서 E-Mail 및 Domain관리를 통하여 직접 DV를 문의
*Issues :
*Change history :
*@LastModifyDate : 2011.03.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.03.30 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_0249 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0249HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김영오
 * @see EES_MNR_0249HTMLAction 참조
 * @since J2EE 1.6
 */    
public class EesMnr0249Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	public EesMnr0249Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DvLeasedUnitINVO dvLeasedUnitINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DvLeasedUnitVO[] dvLeasedUnitVOs = null;
	
	
	
	public DvLeasedUnitINVO getDvLeasedUnitINVO() {
		return dvLeasedUnitINVO;
	}
	public void setDvLeasedUnitINVO(DvLeasedUnitINVO dvLeasedUnitINVO) {
		this.dvLeasedUnitINVO = dvLeasedUnitINVO;
	}
	public DvLeasedUnitVO[] getDvLeasedUnitVOs() {
		return dvLeasedUnitVOs;
	}
	public void setDvLeasedUnitVOs(DvLeasedUnitVO[] dvLeasedUnitVOs) {
		this.dvLeasedUnitVOs = dvLeasedUnitVOs;
	}
	
}