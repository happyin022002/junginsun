/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7011Event.java
*@FileTitle : DEM/DET User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : Lim Chang Bin
*@LastVersion : 1.0
** 2013.07.16 Lim Chang Bin
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ApproSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchApproSetupInfoListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/** 
 * EES_DMT_7011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Chang Bin
 * @see EES_DMT_7011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ApproSetupVO approSetupVO  = null;
	private SearchApproSetupInfoListVO searchApproSetupInfoListVO = null;
    private SearchApproSetupInfoListVO[] searchApproSetupInfoListVOs  = null;
    
    public EesDmt7011Event(){}


	public ApproSetupVO getApproSetupVO() {
		return approSetupVO;
	}

	public void setApproSetupVO(ApproSetupVO approSetupVO) {
		this.approSetupVO = approSetupVO;
	}


	public SearchApproSetupInfoListVO[] getSearchApproSetupInfoListVOs() {
		return searchApproSetupInfoListVOs;
	}

	public void setSearchApproSetupInfoListVOs(
			SearchApproSetupInfoListVO[] searchApproSetupInfoListVOs) {
		this.searchApproSetupInfoListVOs = searchApproSetupInfoListVOs;
	}

	public SearchApproSetupInfoListVO getSearchApproSetupInfoListVO() {
		return searchApproSetupInfoListVO;
	}

	public void setSearchApproSetupInfoListVO(
			SearchApproSetupInfoListVO searchApproSetupInfoListVO) {
		this.searchApproSetupInfoListVO = searchApproSetupInfoListVO;
	}

    
}
