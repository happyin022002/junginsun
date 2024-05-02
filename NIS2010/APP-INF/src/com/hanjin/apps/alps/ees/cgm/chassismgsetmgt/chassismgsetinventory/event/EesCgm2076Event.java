/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2076Event.java
*@FileTitle : M.G.Set Inventory Summary
*Open Issues :
*@LastModifyDate : 2009.09.09
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.09 조재성
* 1.0 Creation
* *@Change history :
* 2015.06.22 Chang Young Kim [CHM-201536277] @FileTitle 변경
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import java.util.Arrays;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_2076HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryGeneralINVO mGSInventoryGeneralINVO = null;
	private MGSInventoryGeneralMGTVO mGSInventoryGeneralMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryGeneralINVO[] mGSInventoryGeneralINVOs = null;
	private MGSInventoryGeneralMGTVO[] mGSInventoryGeneralMGTVOs = null;
	
	public EesCgm2076Event(){}

	public MGSInventoryGeneralINVO getMGSInventoryGeneralINVO() {
		return mGSInventoryGeneralINVO;
	}

	public void setMGSInventoryGeneralINVO(
			MGSInventoryGeneralINVO inventoryGeneralINVO) {
		mGSInventoryGeneralINVO = inventoryGeneralINVO;
	}

	public MGSInventoryGeneralMGTVO getMGSInventoryGeneralMGTVO() {
		return mGSInventoryGeneralMGTVO;
	}

	public void setMGSInventoryGeneralMGTVO(
			MGSInventoryGeneralMGTVO inventoryGeneralMGTVO) {
		mGSInventoryGeneralMGTVO = inventoryGeneralMGTVO;
	}

	public MGSInventoryGeneralINVO[] getMGSInventoryGeneralINVOs() {
		MGSInventoryGeneralINVO[] rtnVOs = null;
		if (this.mGSInventoryGeneralINVOs != null) {
			rtnVOs = new MGSInventoryGeneralINVO[mGSInventoryGeneralINVOs.length];
			System.arraycopy(mGSInventoryGeneralINVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryGeneralINVOs(MGSInventoryGeneralINVO[] inventoryGeneralINVOs) {
		if(inventoryGeneralINVOs != null){
			MGSInventoryGeneralINVO[] tmpVOs = Arrays.copyOf(inventoryGeneralINVOs, inventoryGeneralINVOs.length);
			this.mGSInventoryGeneralINVOs = tmpVOs;
		}
	}

	public MGSInventoryGeneralMGTVO[] getMGSInventoryGeneralMGTVOs() {
		MGSInventoryGeneralMGTVO[] rtnVOs = null;
		if (this.mGSInventoryGeneralMGTVOs != null) {
			rtnVOs = new MGSInventoryGeneralMGTVO[mGSInventoryGeneralMGTVOs.length];
			System.arraycopy(mGSInventoryGeneralMGTVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryGeneralMGTVOs(MGSInventoryGeneralMGTVO[] inventoryGeneralMGTVOs) {
		if(inventoryGeneralMGTVOs != null){
			MGSInventoryGeneralMGTVO[] tmpVOs = Arrays.copyOf(inventoryGeneralMGTVOs, inventoryGeneralMGTVOs.length);
			this.mGSInventoryGeneralMGTVOs = tmpVOs;
		}
	}
	

}