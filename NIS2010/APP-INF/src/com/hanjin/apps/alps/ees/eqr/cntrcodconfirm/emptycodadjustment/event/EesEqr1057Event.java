/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1057Event.java
*@FileTitle : Hanger Rack MTY CNTR List / Damage MTY CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2009-08-17 dev098
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.BookingContainerListVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MasterContainerListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_7003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_7003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1057HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1057Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private DamageRevenueEmptyListVO damageRevenueEmptyListVO = null;
    public DamageRevenueEmptyListVO[] damageRevenueEmptyListVOs = null;
    private MasterContainerListVO masterContainerListVO = null;
    public MasterContainerListVO[] masterContainerListVOs = null;    
    private BookingContainerListVO bookingContainerListVO = null;
    public BookingContainerListVO[] bookingContainerListVOs = null;       
    private DamageRevenueListOptionVO damageRevenueListOptionVO = null;
    public DamageRevenueListOptionVO[] damageRevenueListOptionVOs = null;    
    
    private String vvd = "";
    private String version = "";
    private String pod = "";

    public EesEqr1057Event(){}

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
    public DamageRevenueEmptyListVO[] getDamageRevenueEmptyListVOs() {
        return damageRevenueEmptyListVOs;
    }

    /**
    * @param damageRevenueEmptyListVOs the damageRevenueEmptyListVOs to set
    */
    public void setDamageRevenueEmptyListVOs(
            DamageRevenueEmptyListVO[] damageRevenueEmptyListVOs) {
        this.damageRevenueEmptyListVOs = damageRevenueEmptyListVOs;
    }

    /**
    * @return the masterContainerListVO
    */
    public MasterContainerListVO getMasterContainerListVO() {
        return masterContainerListVO;
    }

    /**
    * @param masterContainerListVO the masterContainerListVO to set
    */
    public void setMasterContainerListVO(MasterContainerListVO masterContainerListVO) {
        this.masterContainerListVO = masterContainerListVO;
    }

    /**
    * @return the masterContainerListVOs
    */
    public MasterContainerListVO[] getMasterContainerListVOs() {
        return masterContainerListVOs;
    }

    /**
    * @param masterContainerListVOs the masterContainerListVOs to set
    */
    public void setMasterContainerListVOs(
            MasterContainerListVO[] masterContainerListVOs) {
        this.masterContainerListVOs = masterContainerListVOs;
    }

    /**
    * @return the bookingContainerListVO
    */
    public BookingContainerListVO getBookingContainerListVO() {
        return bookingContainerListVO;
    }

    /**
    * @param bookingContainerListVO the bookingContainerListVO to set
    */
    public void setBookingContainerListVO(
            BookingContainerListVO bookingContainerListVO) {
        this.bookingContainerListVO = bookingContainerListVO;
    }

    /**
    * @return the bookingContainerListVOs
    */
    public BookingContainerListVO[] getBookingContainerListVOs() {
        return bookingContainerListVOs;
    }

    /**
    * @param bookingContainerListVOs the bookingContainerListVOs to set
    */
    public void setBookingContainerListVOs(
            BookingContainerListVO[] bookingContainerListVOs) {
        this.bookingContainerListVOs = bookingContainerListVOs;
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

    /**
    * @return the version
    */
    public String getVersion() {
        return version;
    }

    /**
    * @param version the version to set
    */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
    * @return the pod
    */
    public String getPod() {
        return pod;
    }

    /**
    * @param pod the pod to set
    */
    public void setPod(String pod) {
        this.pod = pod;
    }

    /**
    * @return the damageRevenueListOptionVO
    */
    public DamageRevenueListOptionVO getDamageRevenueListOptionVO() {
        return damageRevenueListOptionVO;
    }

    /**
    * @param damageRevenueListOptionVO the damageRevenueListOptionVO to set
    */
    public void setDamageRevenueListOptionVO(
            DamageRevenueListOptionVO damageRevenueListOptionVO) {
        this.damageRevenueListOptionVO = damageRevenueListOptionVO;
    }

    /**
    * @return the damageRevenueListOptionVOs
    */
    public DamageRevenueListOptionVO[] getDamageRevenueListOptionVOs() {
        return damageRevenueListOptionVOs;
    }

    /**
    * @param damageRevenueListOptionVOs the damageRevenueListOptionVOs to set
    */
    public void setDamageRevenueListOptionVOs(
            DamageRevenueListOptionVO[] damageRevenueListOptionVOs) {
        this.damageRevenueListOptionVOs = damageRevenueListOptionVOs;
    }
    
    
    
}
