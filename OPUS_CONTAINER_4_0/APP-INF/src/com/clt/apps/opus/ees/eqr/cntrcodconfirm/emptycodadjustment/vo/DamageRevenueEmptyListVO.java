/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DamageRevenueEmptyListVO.java
*@FileTitle : DamageRevenueEmptyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo;

import java.util.HashMap;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DamageRevenueEmptyListVO {
    
    private List<DamageRevenueEmptyList01VO> damageRevenueEmptyList01VO = null;
    private List<DamageRevenueEmptyList01VO> damageRevenueEmptyList02VO = null;
    private List<RevenueMTYListCntrTpSzVO> revenueMTYListCntrTpSzVO = null;
    private List<MasterContainerListVO> masterContainerListVO = null;
    private List<BookingContainerListVO> bookingContainerListVO = null;
    
    /**
    * @return the damageRevenueEmptyListVO01
    */
    public List<DamageRevenueEmptyList01VO> getDamageRevenueEmptyListVO01() {
        return damageRevenueEmptyList01VO;
    }



    /**
    * @param damageRevenueEmptyList01VO the damageRevenueEmptyListVO01 to set
    */
    public void setDamageRevenueEmptyListVO01(
            List<DamageRevenueEmptyList01VO> damageRevenueEmptyList01VO) {
        this.damageRevenueEmptyList01VO = damageRevenueEmptyList01VO;
    }



    /**
    * @return the damageRevenueEmptyList02VO
    */
    public List<DamageRevenueEmptyList01VO> getDamageRevenueEmptyListVO02() {
        return damageRevenueEmptyList02VO;
    }



    /**
    * @param damageRevenueEmptyList02VO the damageRevenueEmptyList02VO to set
    */
    public void setDamageRevenueEmptyListVO02(
            List<DamageRevenueEmptyList01VO> damageRevenueEmptyList02VO) {
        this.damageRevenueEmptyList02VO = damageRevenueEmptyList02VO;
    }



    /**
    * @return the revenueMTYListCntrTpSzVO
    */
    public List<RevenueMTYListCntrTpSzVO> getRevenueMTYListCntrTpSzVO() {
        return revenueMTYListCntrTpSzVO;
    }



    /**
    * @param revenueMTYListCntrTpSzVO the revenueMTYListCntrTpSzVO to set
    */
    public void setRevenueMTYListCntrTpSzVO( 
            List<RevenueMTYListCntrTpSzVO> revenueMTYListCntrTpSzVO) {
        this.revenueMTYListCntrTpSzVO = revenueMTYListCntrTpSzVO;
    }



    /**
    * @return the masterContainerListVO
    */
    public List<MasterContainerListVO> getMasterContainerListVO() {
        return masterContainerListVO;
    }



    /**
    * @param masterContainerListVO the masterContainerListVO to set
    */
    public void setMasterContainerListVO(
            List<MasterContainerListVO> masterContainerListVO) {
        this.masterContainerListVO = masterContainerListVO;
    }



    /**
    * @return the bookingContainerListVO
    */
    public List<BookingContainerListVO> getBookingContainerListVO() {
        return bookingContainerListVO;
    }



    /**
    * @param bookingContainerListVO the bookingContainerListVO to set
    */
    public void setBookingContainerListVO(
            List<BookingContainerListVO> bookingContainerListVO) {
        this.bookingContainerListVO = bookingContainerListVO;
    }



    public HashMap<String, String> getColumnValues(){return new HashMap<String, String>();}
}
