/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0096Event.java
*@FileTitle : CNI User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier : Kang Hwan
*@LastVersion : 1.0
** 2013.07.24 Kang Hwan
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniUsrRoleMtchVO;
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

public class CpsCni0096Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    private CniUsrRoleMtchVO CniUsrRoleMtchVO  = null;
    private CniUsrRoleMtchVO[] CniUsrRoleMtchVOs  = null;
    
    /* Role Code */
    private String roleCd;

    /* Role Description */
    private String roleDesc;

    public CpsCni0096Event(){}


	public CniUsrRoleMtchVO getCniUsrRoleMtchVO() {
		return CniUsrRoleMtchVO;
	}


	public void setCniUsrRoleMtchVO(CniUsrRoleMtchVO CniUsrRoleMtchVO) {
		this.CniUsrRoleMtchVO = CniUsrRoleMtchVO;
	}


	public CniUsrRoleMtchVO[] getCniUsrRoleMtchVOs() {
		return CniUsrRoleMtchVOs;
	}


	public void setCniUsrRoleMtchVOs(CniUsrRoleMtchVO[] CniUsrRoleMtchVOs) {
		this.CniUsrRoleMtchVOs = CniUsrRoleMtchVOs;
	}
	
	/**                                                                
     * Role Code 가져오기
     * @return Role Code
     */                                                                
    public String getRoleCd() {                    
        return roleCd;                                        
    }                     
    
    /**                                                                
     * Role Description 조회
     * @param Role Description
     */                                                                
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;                        
    }


}
