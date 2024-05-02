/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1023Event.java
*@FileTitle : MTY Repo Inquiry by Period
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1023HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1023Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private MTYREPOByPeriodVO         mTYREPOByPeriodVO        = null;
    public  MTYREPOByPeriodVO[]       mTYREPOByPeriodVOs       = null;
    private MTYREPOByPeriodOptionVO   mTYREPOByPeriodOptionVO  = null;
    public  MTYREPOByPeriodOptionVO[] mTYREPOByPeriodOptionVOs = null;    
    
    private String inquirylevel = null;
    private String tpsz         = null;
    private String location     = null;
    private String div          = null;
    private String fromdate     = null;
    private String enddate      = null;

    public EesEqr1023Event(){}

    /**
    * @return the mTYREPOByPeriodVO
    */
    public MTYREPOByPeriodVO getMTYREPOByPeriodVO() {
        return mTYREPOByPeriodVO;
    }

    /**
    * @param byPeriodVO the mTYREPOByPeriodVO to set
    */
    public void setMTYREPOByPeriodVO(MTYREPOByPeriodVO byPeriodVO) {
        mTYREPOByPeriodVO = byPeriodVO;
    }

    /**
    * @return the mTYREPOByPeriodVOs
    */
    public MTYREPOByPeriodVO[] getMTYREPOByPeriodVOs() {
        return mTYREPOByPeriodVOs;
    }

    /**
    * @param byPeriodVOs the mTYREPOByPeriodVOs to set
    */
    public void setMTYREPOByPeriodVOs(MTYREPOByPeriodVO[] byPeriodVOs) {
        mTYREPOByPeriodVOs = byPeriodVOs;
    }

    /**
    * @return the mTYREPOByPeriodOptionVO
    */
    public MTYREPOByPeriodOptionVO getMTYREPOByPeriodOptionVO() {
        return mTYREPOByPeriodOptionVO;
    }

    /**
    * @param byPeriodOptionVO the mTYREPOByPeriodOptionVO to set
    */
    public void setMTYREPOByPeriodOptionVO(MTYREPOByPeriodOptionVO byPeriodOptionVO) {
        mTYREPOByPeriodOptionVO = byPeriodOptionVO;
    }

    /**
    * @return the mTYREPOByPeriodOptionVOs
    */
    public MTYREPOByPeriodOptionVO[] getMTYREPOByPeriodOptionVOs() {
        return mTYREPOByPeriodOptionVOs;
    }

    /**
    * @param byPeriodOptionVOs the mTYREPOByPeriodOptionVOs to set
    */
    public void setMTYREPOByPeriodOptionVOs(
            MTYREPOByPeriodOptionVO[] byPeriodOptionVOs) {
        mTYREPOByPeriodOptionVOs = byPeriodOptionVOs;
    }

    /**
    * @return the inquirylevel
    */
    public String getInquirylevel() {
        return inquirylevel;
    }

    /**
    * @param inquirylevel the inquirylevel to set
    */
    public void setInquirylevel(String inquirylevel) {
        this.inquirylevel = inquirylevel;
    }

    /**
    * @return the tpsz
    */
    public String getTpsz() {
        return tpsz;
    }

    /**
    * @param tpsz the tpsz to set
    */
    public void setTpsz(String tpsz) {
        this.tpsz = tpsz;
    }

    /**
    * @return the location
    */
    public String getLocation() {
        return location;
    }

    /**
    * @param location the location to set
    */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
    * @return the div
    */
    public String getDiv() {
        return div;
    }

    /**
    * @param div the div to set
    */
    public void setDiv(String div) {
        this.div = div;
    }

    /**
    * @return the fromdate
    */
    public String getFromdate() {
        return fromdate;
    }

    /**
    * @param fromdate the fromdate to set
    */
    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    /**
    * @return the enddate
    */
    public String getEnddate() {
        return enddate;
    }

    /**
    * @param enddate the enddate to set
    */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
 
    
    
}