/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1056Event.java
*@FileTitle : Revenue MTY CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyList01VO;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_7002 PDTO(Data Transfer Object including Parameters)<br>
 * @author 
 * @see EES_EQR_1056HTMLAction 
 * @since J2EE 1.6
 */
public class EesEqr1056Event extends EventSupport {
    private static final long serialVersionUID = 1L;
    
    /** Table Value Object   */
    private DamageRevenueEmptyListVO damageRevenueEmptyListVO = null;
    
    /** Table Value Object Multi Data  */
    private DamageRevenueEmptyList01VO[] damageRevenueEmptyListVOs = null;
    
    private String vvd = "";

    public EesEqr1056Event(){}

    /**
    * @return the damageRevenueEmptyListVO
    */
    public DamageRevenueEmptyListVO getDamageRevenueEmptyListVO() {
        return damageRevenueEmptyListVO;
    }

    /**
    * @param damageRevenueEmptyListVO the damageRevenueEmptyListVO to set
    */
    public void setDamageRevenueEmptyListVO( 
            DamageRevenueEmptyListVO damageRevenueEmptyListVO) {
        this.damageRevenueEmptyListVO = damageRevenueEmptyListVO;
    }

    /**
    * @return the damageRevenueEmptyListVOs
    */
    public DamageRevenueEmptyList01VO[] getDamageRevenueEmptyListVOs() {
    	DamageRevenueEmptyList01VO[] tmpVOs = null;
		if (this.damageRevenueEmptyListVOs != null) {
			tmpVOs = new DamageRevenueEmptyList01VO[damageRevenueEmptyListVOs.length];
			System.arraycopy(damageRevenueEmptyListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param damageRevenueEmptyListVOs the damageRevenueEmptyListVOs to set
    */
    public void setDamageRevenueEmptyListVOs(
            DamageRevenueEmptyList01VO[] damageRevenueEmptyListVOs) {    	
    	if (damageRevenueEmptyListVOs != null) {
    		DamageRevenueEmptyList01VO[] tmpVOs = new DamageRevenueEmptyList01VO[damageRevenueEmptyListVOs.length];
			System.arraycopy(damageRevenueEmptyListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.damageRevenueEmptyListVOs = tmpVOs;
		}
    }

    /**
    * @return the vvd
    */
    public String getVvd() {
        return vvd;
    }

    /**
    * @param vvd the vvd to set
    */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }
    
    
    
}
