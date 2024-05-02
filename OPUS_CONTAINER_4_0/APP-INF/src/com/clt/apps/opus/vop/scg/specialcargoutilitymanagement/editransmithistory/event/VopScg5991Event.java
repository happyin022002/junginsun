/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0014Event.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.EdiTransmitHistoryHdrVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG-5011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-5011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author dongsoo
 * @see VOP_SCG-5011HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5991Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public VopScg5991Event(){}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EdiTransmitHistoryHdrVO EdiTransmitHistoryHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EdiTransmitHistoryHdrVO[] EdiTransmitHistoryHdrVOs = null;
	
	public EdiTransmitHistoryHdrVO getEdiTransmitHistoryHdrVO() {
		return EdiTransmitHistoryHdrVO;
	}

	public void setEdiTransmitHistoryHdrVO(
			EdiTransmitHistoryHdrVO ediTransmitHistoryHdrVO) {
		EdiTransmitHistoryHdrVO = ediTransmitHistoryHdrVO;
	}

	public EdiTransmitHistoryHdrVO[] getEdiTransmitHistoryHdrVOs() {
		EdiTransmitHistoryHdrVO[] rtnVOs = null;
		if (this.EdiTransmitHistoryHdrVOs != null) {
			rtnVOs = Arrays.copyOf(EdiTransmitHistoryHdrVOs, EdiTransmitHistoryHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setEdiTransmitHistoryHdrVOs(
			EdiTransmitHistoryHdrVO[] ediTransmitHistoryHdrVOs) {
		if(ediTransmitHistoryHdrVOs != null){
			EdiTransmitHistoryHdrVO[] tmpVOs = Arrays.copyOf(ediTransmitHistoryHdrVOs, ediTransmitHistoryHdrVOs.length);
			this.EdiTransmitHistoryHdrVOs = tmpVOs;
		}
	}	
}