/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0142Event.java
*@FileTitle : Pop Up_Tariff Code Finding
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event;


import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung young hun
 * @see EES_MNR_0142HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0142Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private RepairCodeFindListGRPVO repairCodeFindListGRPVO = null;

	public RepairCodeFindListGRPVO getRepairCodeFindListGRPVO() {
		return repairCodeFindListGRPVO;
	}

	public void setRepairCodeFindListGRPVO(
			RepairCodeFindListGRPVO repairCodeFindListGRPVO) {
		this.repairCodeFindListGRPVO = repairCodeFindListGRPVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}