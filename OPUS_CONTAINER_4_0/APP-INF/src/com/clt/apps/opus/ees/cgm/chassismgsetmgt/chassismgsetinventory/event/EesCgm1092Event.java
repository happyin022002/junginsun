/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1092Event.java
*@FileTitle : 체류 기간별 Chassis 수량집계 inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.17 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1092 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1092HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1092HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1092Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value IN Object 조회 조건 및 단건 처리  */
	private CHSInventoryByStaydaysINVO cHSinventoryByStaydaysINVO = null;
	public CHSInventoryByStaydaysINVO getCHSInventoryByStaydaysINVO() {
		return cHSinventoryByStaydaysINVO;
	}
	public void setCHSInventoryByStaydaysINVO(
			CHSInventoryByStaydaysINVO cHSinventoryByStaydaysINVO) {
		this.cHSinventoryByStaydaysINVO = cHSinventoryByStaydaysINVO;
	}
	
	/** Table Value IN Object 조회 조건 및 단건 처리*/
	private CHSLongStaydaysEnvINVO cHSLongStaydaysEnvINVO = null;
	
	/** Table Value MGT Object 조회 조건 및 단건 처리  */
	private CHSInventoryByStaydaysMGTVO inventoryByStaydaysMGTVO = null;
	/** Table Value Object Multi Data 처리 */
	private CHSInventoryByStaydaysMGTVO[] inventoryByStaydaysMGTVOs = null;
	public EesCgm1092Event(){}

	public CHSInventoryByStaydaysMGTVO getCHSInventoryByStaydaysMGTVO() {
		return inventoryByStaydaysMGTVO;
	}
	public void setCHSInventoryByStaydaysMGTVO(CHSInventoryByStaydaysMGTVO inventoryByStaydaysMGTVO) 
	{
			this.inventoryByStaydaysMGTVO = inventoryByStaydaysMGTVO;
	}
	public CHSInventoryByStaydaysMGTVO[] getCHSInventoryByStaydaysMGTVOs() 
	{
		CHSInventoryByStaydaysMGTVO[] rtnVOs = null;
		if (this.inventoryByStaydaysMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(inventoryByStaydaysMGTVOs, inventoryByStaydaysMGTVOs.length);
		}
		return rtnVOs;
	}
	public void setCHSInventoryByStaydaysMGTVOs(CHSInventoryByStaydaysMGTVO[] inventoryByStaydaysMGTVOs){
		if(inventoryByStaydaysMGTVOs != null){
			CHSInventoryByStaydaysMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByStaydaysMGTVOs, inventoryByStaydaysMGTVOs.length);
			this.inventoryByStaydaysMGTVOs = tmpVOs;
		}
	}
	public CHSLongStaydaysEnvINVO getCHSLongStaydaysEnvINVO() {
		return cHSLongStaydaysEnvINVO;
	}
	public void setCHSLongStaydaysEnvINVO(CHSLongStaydaysEnvINVO longStaydaysEnvINVO) {
		cHSLongStaydaysEnvINVO = longStaydaysEnvINVO;
	}

}