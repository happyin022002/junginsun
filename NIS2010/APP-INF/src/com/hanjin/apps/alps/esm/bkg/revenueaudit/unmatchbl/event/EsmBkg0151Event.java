/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0151Event.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0151 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0151HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_0151HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0151Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	public ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO = null;

	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		this.comBakEndJbVOs = comBakEndJbVOs;
	}
	
	public void setRsltSearchChargeFilteringListVO(RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO) {
		this.rsltSearchChargeFilteringListVO = rsltSearchChargeFilteringListVO;
	}
	
	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		return comBakEndJbVOs;
	}
	
	public RsltSearchChargeFilteringListVO getRsltSearchChargeFilteringListVO() {
		return rsltSearchChargeFilteringListVO;
	}
	
}