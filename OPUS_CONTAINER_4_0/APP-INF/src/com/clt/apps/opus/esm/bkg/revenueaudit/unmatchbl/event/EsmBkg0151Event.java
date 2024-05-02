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
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;

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
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO = null;

	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setRsltSearchChargeFilteringListVO(RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO) {
		this.rsltSearchChargeFilteringListVO = rsltSearchChargeFilteringListVO;
	}
	
	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	
	public RsltSearchChargeFilteringListVO getRsltSearchChargeFilteringListVO() {
		return rsltSearchChargeFilteringListVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOs() {
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
		}
		return rtnVOs;
	}
	public void setComBakEndJbVOs(ComBakEndJbVO[] comBakEndJbVOs) {
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	

}