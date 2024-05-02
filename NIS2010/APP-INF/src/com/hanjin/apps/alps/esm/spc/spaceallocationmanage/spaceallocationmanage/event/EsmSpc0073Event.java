/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg0073Event.java
*@FileTitle : Customer/Commodity inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.08 신자영
* 1.0 Creation
* 2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchActualCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_SPC_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0073HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmSpc0073Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActualCustomerVO infoVO = null;
	public SearchActualCustomerVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(SearchActualCustomerVO infoVO) {
		this.infoVO = infoVO;
	}

	public SearchActualCustomerVO[] getInfoVOs() {
		SearchActualCustomerVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = new SearchActualCustomerVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(SearchActualCustomerVO[] infoVOs) {
		if (infoVOs != null) {
			SearchActualCustomerVO[] tmpVOs = new SearchActualCustomerVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private SearchActualCustomerVO[] infoVOs = null;



	public EsmSpc0073Event(){}

	private static final long serialVersionUID = 1L;


}