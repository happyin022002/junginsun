/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkgEvent.java
*@FileTitle :  Multi Rate BKG List for Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2016.08.19 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgList1VO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.SearchHJSSalesAmountListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongmin Cho
 * @see ESM_BKG_0698HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1427Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MultiRateBkgList1VO multiRateBkgList1VO = null;
	
	/** Save Multi Data 처리 */
    private MultiRateBkgList1VO[] multiRateBkgList1VOs = null;

	/**
	 * @return the multiRateBkgList1VO
	 */
	public MultiRateBkgList1VO getMultiRateBkgList1VO() {
		return multiRateBkgList1VO;
	}

	/**
	 * @param MultiRateBkgList1VO the multiRateBkgList1VO to set
	 */
	public void setMultiRateBkgList1VO(MultiRateBkgList1VO multiRateBkgList1VO) {
		this.multiRateBkgList1VO = multiRateBkgList1VO;
	}

	/** ValueObject Array Getter - Create/Update/Delete */
	public MultiRateBkgList1VO[] getMultiRateBkgList1VOs() {
		return multiRateBkgList1VOs;
	}

	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMultiRateBkgList1VOs(MultiRateBkgList1VO[] multiRateBkgList1VOs) {
		this.multiRateBkgList1VOs = multiRateBkgList1VOs;
	}
}