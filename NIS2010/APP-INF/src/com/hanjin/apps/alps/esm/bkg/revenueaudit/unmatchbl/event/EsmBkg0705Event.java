/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0705Event.java
*@FileTitle : Audit by Hanger Installation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.22 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListInVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListOutVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.DiversionCAVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0705 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0705HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_0705HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0705Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CODBookingListInVO cODBookingListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public CODBookingListOutVO[] cODBookingListOutVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DiversionCAVO diversionCAVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public DiversionCAVO[] diversionCAVOs = null;

	
	public void setCODBookingListInVO(CODBookingListInVO cODBookingListInVO){
		this. cODBookingListInVO = cODBookingListInVO;
	}

	public CODBookingListInVO getCODBookingListInVO(){
		return cODBookingListInVO;
	}

	/**
	 * @return the bkgRevUmchBkgVOs
	 */
	public CODBookingListOutVO[] getCODBookingListOutVOs() {
		return cODBookingListOutVOs;
	}

	/**
	 * @param bkgRevUmchBkgVOs the bkgRevUmchBkgVOs to set
	 */
	public void setCODBookingListOutVOs(CODBookingListOutVO[] cODBookingListOutVOs) {
		this.cODBookingListOutVOs = cODBookingListOutVOs;
	}

	
	public void setDiversionCAVO(DiversionCAVO diversionCAVO){
		this. diversionCAVO = diversionCAVO;
	}

	public DiversionCAVO getDiversionCAVO(){
		return diversionCAVO;
	}

	/**
	 * @return the diversionCAVOs
	 */
	public DiversionCAVO[] getDiversionCAVOs() {
		return diversionCAVOs;
	}

	/**
	 * @param diversionCAVOs the diversionCAVOs to set
	 */
	public void setDiversionCAVOs(DiversionCAVO[] diversionCAVOs) {
		this.diversionCAVOs = diversionCAVOs;
	}
	
	
	
	
}