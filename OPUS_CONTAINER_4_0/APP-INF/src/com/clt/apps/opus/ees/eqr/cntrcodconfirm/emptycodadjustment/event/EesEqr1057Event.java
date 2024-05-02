/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1057Event.java
*@FileTitle : Hanger Rack MTY CNTR List / Damage MTY CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.BookingContainerListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MasterContainerListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_7003 PDTO(Data Transfer Object including Parameters)<br>
 *
 * @author 
 * @see EES_EQR_1057HTMLAction 
 * @since J2EE 1.6
 */
public class EesEqr1057Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private DamageRevenueEmptyListVO damageRevenueEmptyListVO = null;
    private DamageRevenueEmptyListVO[] damageRevenueEmptyListVOs = null;
    private MasterContainerListVO masterContainerListVO = null;
    private MasterContainerListVO[] masterContainerListVOs = null;    
    private BookingContainerListVO bookingContainerListVO = null;
    private BookingContainerListVO[] bookingContainerListVOs = null;       
    private DamageRevenueListOptionVO damageRevenueListOptionVO = null;
    private DamageRevenueListOptionVO[] damageRevenueListOptionVOs = null;    
    
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
    	DamageRevenueEmptyListVO[] tmpVOs = null;
		if (this.damageRevenueEmptyListVOs != null) {
			tmpVOs = new DamageRevenueEmptyListVO[damageRevenueEmptyListVOs.length];
			System.arraycopy(damageRevenueEmptyListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param damageRevenueEmptyListVOs the damageRevenueEmptyListVOs to set
    */
    public void setDamageRevenueEmptyListVOs(
            DamageRevenueEmptyListVO[] damageRevenueEmptyListVOs) {
    	if (damageRevenueEmptyListVOs != null) {
    		DamageRevenueEmptyListVO[] tmpVOs = new DamageRevenueEmptyListVO[damageRevenueEmptyListVOs.length];
			System.arraycopy(damageRevenueEmptyListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.damageRevenueEmptyListVOs = tmpVOs;
		}
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
    	MasterContainerListVO[] tmpVOs = null;
		if (this.masterContainerListVOs != null) {
			tmpVOs = new MasterContainerListVO[masterContainerListVOs.length];
			System.arraycopy(masterContainerListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param masterContainerListVOs the masterContainerListVOs to set
    */
    public void setMasterContainerListVOs(
            MasterContainerListVO[] masterContainerListVOs) {
    	if (masterContainerListVOs != null) {
    		MasterContainerListVO[] tmpVOs = new MasterContainerListVO[masterContainerListVOs.length];
			System.arraycopy(masterContainerListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.masterContainerListVOs = tmpVOs;
		}
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
    	BookingContainerListVO[] tmpVOs = null;
		if (this.bookingContainerListVOs != null) {
			tmpVOs = new BookingContainerListVO[bookingContainerListVOs.length];
			System.arraycopy(bookingContainerListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param bookingContainerListVOs the bookingContainerListVOs to set
    */
    public void setBookingContainerListVOs(
            BookingContainerListVO[] bookingContainerListVOs) {
    	if (bookingContainerListVOs != null) {
    		BookingContainerListVO[] tmpVOs = new BookingContainerListVO[bookingContainerListVOs.length];
			System.arraycopy(bookingContainerListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bookingContainerListVOs = tmpVOs;
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
    	DamageRevenueListOptionVO[] tmpVOs = null;
		if (this.damageRevenueListOptionVOs != null) {
			tmpVOs = new DamageRevenueListOptionVO[damageRevenueListOptionVOs.length];
			System.arraycopy(damageRevenueListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param damageRevenueListOptionVOs the damageRevenueListOptionVOs to set
    */
    public void setDamageRevenueListOptionVOs(
            DamageRevenueListOptionVO[] damageRevenueListOptionVOs) {
    	if (damageRevenueListOptionVOs != null) {
    		DamageRevenueListOptionVO[] tmpVOs = new DamageRevenueListOptionVO[damageRevenueListOptionVOs.length];
			System.arraycopy(damageRevenueListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.damageRevenueListOptionVOs = tmpVOs;
		}
    }
    
    
    
}
