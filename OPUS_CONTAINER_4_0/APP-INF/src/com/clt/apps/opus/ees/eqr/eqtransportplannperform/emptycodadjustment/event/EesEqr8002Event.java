/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr8002Event.java
*@FileTitle : MTY Repo Inquiry by Period
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-17
*@LastModifier : dev098
*@LastVersion : 1.0
* 2009-08-17 dev098
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_8002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_8002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_8002HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr8002Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private MTYREPOByPeriodVO         mTYREPOByPeriodVO        = null;
    private MTYREPOByPeriodVO[]       mTYREPOByPeriodVOs       = null;
    private MTYREPOByPeriodOptionVO   mTYREPOByPeriodOptionVO  = null;
    private MTYREPOByPeriodOptionVO[] mTYREPOByPeriodOptionVOs = null;    
    
    private String inquirylevel = null;
    private String tpsz         = null;
    private String location     = null;
    private String div          = null;
    private String fromdate     = null;
    private String enddate      = null;

    public EesEqr8002Event(){}

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
    	MTYREPOByPeriodVO[] tmpVOs = null;
		if (this.mTYREPOByPeriodVOs != null) {
			tmpVOs = new MTYREPOByPeriodVO[mTYREPOByPeriodVOs.length];
			System.arraycopy(mTYREPOByPeriodVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param byPeriodVOs the mTYREPOByPeriodVOs to set
    */
    public void setMTYREPOByPeriodVOs(MTYREPOByPeriodVO[] byPeriodVOs) {
    	if (byPeriodVOs != null) {
    		MTYREPOByPeriodVO[] tmpVOs = new MTYREPOByPeriodVO[byPeriodVOs.length];
			System.arraycopy(byPeriodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mTYREPOByPeriodVOs = tmpVOs;
		}
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
    	MTYREPOByPeriodOptionVO[] tmpVOs = null;
		if (this.mTYREPOByPeriodOptionVOs != null) {
			tmpVOs = new MTYREPOByPeriodOptionVO[mTYREPOByPeriodOptionVOs.length];
			System.arraycopy(mTYREPOByPeriodOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param byPeriodOptionVOs the mTYREPOByPeriodOptionVOs to set
    */
    public void setMTYREPOByPeriodOptionVOs(
            MTYREPOByPeriodOptionVO[] byPeriodOptionVOs) {
    	if (byPeriodOptionVOs != null) {
    		MTYREPOByPeriodOptionVO[] tmpVOs = new MTYREPOByPeriodOptionVO[byPeriodOptionVOs.length];
			System.arraycopy(byPeriodOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mTYREPOByPeriodOptionVOs = tmpVOs;
		}
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