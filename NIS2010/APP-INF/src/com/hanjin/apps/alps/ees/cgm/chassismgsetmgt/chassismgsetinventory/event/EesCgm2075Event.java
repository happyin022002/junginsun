/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesCgm2075Event.java
*@FileTitle : M.G.Set Inventory Detail
*@Open Issues : [CHM-201536277] ALPS-Genset] Genset Inventory Detail 조회기능 신규개발 요청
*@LastModifyDate : 2015.06.22
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2015.06.22 Chang Young Kim
* 1.0 Creation
*@Change history :
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chang Young Kim
 * @see EES_CGM_2075HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryDetailINVO mgsInventoryDetailINVO = null;
	
	public EesCgm2075Event(){}

	public MGSInventoryDetailINVO getMGSInventoryDetailINVO() {
		return mgsInventoryDetailINVO;
	}

	public void setMGSInventoryDetailINVO(MGSInventoryDetailINVO mgsInventoryDetailINVO) {
		this.mgsInventoryDetailINVO = mgsInventoryDetailINVO;
	}
}