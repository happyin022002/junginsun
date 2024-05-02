/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr7002Event.java
*@FileTitle : Revenue MTY CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-17
*@LastModifier : dev098
*@LastVersion : 1.0
* 2009-08-17 dev098
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueEmptyList01VO;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_7002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_7002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_7002HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr7002Event extends EventSupport {
    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private DamageRevenueEmptyListVO damageRevenueEmptyListVO = null;
    
    /** Table Value Object Multi Data 처리 */
    public DamageRevenueEmptyList01VO[] damageRevenueEmptyListVOs = null;
    
    private String vvd = "";

    public EesEqr7002Event(){}

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
        return damageRevenueEmptyListVOs;
    }

    /**
    * @param damageRevenueEmptyListVOs the damageRevenueEmptyListVOs to set
    */
    public void setDamageRevenueEmptyListVOs(
            DamageRevenueEmptyList01VO[] damageRevenueEmptyListVOs) {
        this.damageRevenueEmptyListVOs = damageRevenueEmptyListVOs;
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