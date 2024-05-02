/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesMnr0255Event.java
*@FileTitle : Hanger Rack & Bar Installation/Removal Load Excel_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.15
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2011.09.15 신혜정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_mnr_0255 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0255HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyeJung Shin
 * @see ees_mnr_0255HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesMnr0255Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0255Event(){}
	
	private HangerInventoryListGRPVO hangerInventoryListGRPVO = null;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public HangerInventoryListGRPVO getHangerInventoryListGRPVO() {
		return hangerInventoryListGRPVO; 
	}

	public void setHangerInventoryListGRPVO(HangerInventoryListGRPVO hangerInventoryListGRPVO) {
		this.hangerInventoryListGRPVO = hangerInventoryListGRPVO;
	}  		
	
}