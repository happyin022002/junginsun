/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7010Event.java
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

import com.hanjin.syscommon.common.table.DmtUsrRoleMtchVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchUserRoleInfoListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_7010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Chang Bin
 * @see EES_DMT_7010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7010Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    private DmtUsrRoleMtchVO dmtUsrRoleMtchVO  = null;
    private DmtUsrRoleMtchVO[] dmtUsrRoleMtchVOs  = null;
    
    private SearchUserRoleInfoListVO searchUserRoleInfoListVO  = null;
    private SearchUserRoleInfoListVO[] searchUserRoleInfoListVOs  = null;
    
    public EesDmt7010Event(){}

	public DmtUsrRoleMtchVO getDmtUsrRoleMtchVO() {
		return dmtUsrRoleMtchVO;
	}

	public void setDmtUsrRoleMtchVO(DmtUsrRoleMtchVO dmtUsrRoleMtchVO) {
		this.dmtUsrRoleMtchVO = dmtUsrRoleMtchVO;
	}

	public DmtUsrRoleMtchVO[] getDmtUsrRoleMtchVOs() {
		return dmtUsrRoleMtchVOs;
	}

	public void setDmtUsrRoleMtchVOs(DmtUsrRoleMtchVO[] dmtUsrRoleMtchVOs) {
		this.dmtUsrRoleMtchVOs = dmtUsrRoleMtchVOs;
	}
	
	public SearchUserRoleInfoListVO getSearchUserRoleInfoListVO() {
		return searchUserRoleInfoListVO;
	}

	public void setSearchUserRoleInfoListVO(SearchUserRoleInfoListVO searchUserRoleInfoListVO) {
		this.searchUserRoleInfoListVO = searchUserRoleInfoListVO;
	}

	public SearchUserRoleInfoListVO[] getSearchUserRoleInfoListVOs() {
		return searchUserRoleInfoListVOs;
	}

	public void setSearchUserRoleInfoListVOs(SearchUserRoleInfoListVO[] searchUserRoleInfoListVOs) {
		this.searchUserRoleInfoListVOs = searchUserRoleInfoListVOs;
	}
}
