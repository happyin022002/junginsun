/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0109Event.java
*@FileTitle : Hanger Rack/Bar Installation/Uninstallation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.20 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * ees_mnr_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQFlagListINVO eQFlagListINVO = null;

	/** Table Value Object Multi Data 처리 */
	private CustomMnrEqStsVO[] customMnrEqStsVOs = null;

	/** Table Value Object Multi Data 처리 */
	private CustomMnrFlgHisVO[] customMnrFlgHisVOs = null;

	private HangerInventoryListGRPVO hangerInventoryListGRPVO = null;
	private GeneralWOGRPVO  generalWOGRPVO = null;

	public EesMnr0109Event(){}

	public GeneralWOGRPVO getGeneralWOGRPVO() {
		return generalWOGRPVO;
	}

	public void setExtraWOGRPVO(GeneralWOGRPVO generalWOGRPVO) {
		this.generalWOGRPVO = generalWOGRPVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public CustomMnrFlgHisVO[] getCustomMnrFlgHisVOs() {
		CustomMnrFlgHisVO[] rtnVOs = null;
		if (this.customMnrFlgHisVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrFlgHisVOs, customMnrFlgHisVOs.length);
		}
		return rtnVOs;
	}

	public void setCustomMnrFlgHisVOs(CustomMnrFlgHisVO[] customMnrFlgHisVOs){
		if(customMnrFlgHisVOs != null){
			CustomMnrFlgHisVO[] tmpVOs = java.util.Arrays.copyOf(customMnrFlgHisVOs, customMnrFlgHisVOs.length);
			this.customMnrFlgHisVOs = tmpVOs;
		}
	}

	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO;
	}

	public void setEQFlagListINVO(EQFlagListINVO flagListINVO) {
		eQFlagListINVO = flagListINVO;
	}

	public CustomMnrEqStsVO[] getCustomMnrEqStsVOs() {
		CustomMnrEqStsVO[] rtnVOs = null;
		if (this.customMnrEqStsVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrEqStsVOs, customMnrEqStsVOs.length);
		}
		return rtnVOs;
	}

	public void setCustomMnrEqStsVOs(CustomMnrEqStsVO[] customMnrEqStsVOs){
		if(customMnrEqStsVOs != null){
			CustomMnrEqStsVO[] tmpVOs = java.util.Arrays.copyOf(customMnrEqStsVOs, customMnrEqStsVOs.length);
			this.customMnrEqStsVOs = tmpVOs;
		}
	}

	public HangerInventoryListGRPVO getHangerInventoryListGRPVO() {
		return hangerInventoryListGRPVO;
	}

	public void setHangerInventoryListGRPVO(HangerInventoryListGRPVO hangerInventoryListGRPVO) {
		this.hangerInventoryListGRPVO = hangerInventoryListGRPVO;
	}
}