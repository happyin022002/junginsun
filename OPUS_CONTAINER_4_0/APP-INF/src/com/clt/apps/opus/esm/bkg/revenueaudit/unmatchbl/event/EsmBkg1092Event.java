/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0151Event.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.29 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_BKG_1092 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1092HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun-Woo, Ryu
 * @see ESM_BKG_1092HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1092Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO = null;

	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	
	public void setRsltSearchAuditByCommodityAndRouteListVO(RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO) {
		this.rsltSearchAuditByCommodityAndRouteListVO = rsltSearchAuditByCommodityAndRouteListVO;
	}
	
	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	
	public RsltSearchAuditByCommodityAndRouteListVO getRsltSearchAuditByCommodityAndRouteListVO() {
		return rsltSearchAuditByCommodityAndRouteListVO;
	}

	public ComBakEndJbVO[] getComBakEndJbVOS() {
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
		}
		return rtnVOs;
	}

	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs) {
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
}