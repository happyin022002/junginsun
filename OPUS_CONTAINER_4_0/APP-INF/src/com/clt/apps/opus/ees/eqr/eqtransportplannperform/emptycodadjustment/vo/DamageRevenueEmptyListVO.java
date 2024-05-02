/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DamageRevenueEmptyListVO.java
*@FileTitle : DamageRevenueEmptyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.10 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo;

import java.util.HashMap;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DamageRevenueEmptyListVO {
    
    private List<DamageRevenueEmptyListVO01> damageRevenueEmptyListVO01 = null;
    private List<DamageRevenueEmptyListVO02> damageRevenueEmptyListVO02 = null;
    private List<RevenueMTYListCntrTpSzVO> revenueMTYListCntrTpSzVO = null;
    private List<MasterContainerListVO> masterContainerListVO = null;
    private List<BookingContainerListVO> bookingContainerListVO = null;
    
    /**
    * @return the damageRevenueEmptyListVO01
    */
    public List<DamageRevenueEmptyListVO01> getDamageRevenueEmptyListVO01() {
        return damageRevenueEmptyListVO01;
    }



    /**
    * @param damageRevenueEmptyListVO01 the damageRevenueEmptyListVO01 to set
    */
    public void setDamageRevenueEmptyListVO01(
            List<DamageRevenueEmptyListVO01> damageRevenueEmptyListVO01) {
        this.damageRevenueEmptyListVO01 = damageRevenueEmptyListVO01;
    }



    /**
    * @return the damageRevenueEmptyListVO02
    */
    public List<DamageRevenueEmptyListVO02> getDamageRevenueEmptyListVO02() {
        return damageRevenueEmptyListVO02;
    }



    /**
    * @param damageRevenueEmptyListVO02 the damageRevenueEmptyListVO02 to set
    */
    public void setDamageRevenueEmptyListVO02(
            List<DamageRevenueEmptyListVO02> damageRevenueEmptyListVO02) {
        this.damageRevenueEmptyListVO02 = damageRevenueEmptyListVO02;
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
