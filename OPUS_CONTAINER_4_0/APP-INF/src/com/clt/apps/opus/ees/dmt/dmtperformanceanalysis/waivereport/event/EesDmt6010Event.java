/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6010Event.java
*@FileTitle : Waive Report by Office Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.21 mun jung cheol
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_6010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6010Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private WaiveReportParmVO  waiveReportParmVO  = null;

    private WaiveReportParmVO [] waiveReportParmVOs  = null;
    
    private WaiveReportDetailVO  waiveReportDetailVO  = null;

    private WaiveReportDetailVO [] waiveReportDetailVOs  = null;    

    public EesDmt6010Event(){}

    /**
    * @return the waiveReportParmVO
    */
    public WaiveReportParmVO getWaiveReportParmVO() {
        return waiveReportParmVO;
    }

    /**
    * @param waiveReportParmVO the waiveReportParmVO to set
    */
    public void setWaiveReportParmVO(WaiveReportParmVO waiveReportParmVO) {
        this.waiveReportParmVO = waiveReportParmVO;
    }

    /**
    * @return the waiveReportParmVOs
    */
    public WaiveReportParmVO[] getWaiveReportParmVOs() {
    	WaiveReportParmVO[] tmpVOs = null;
		if (this.waiveReportParmVOs != null) {
			tmpVOs = new WaiveReportParmVO[waiveReportParmVOs.length];
			System.arraycopy(waiveReportParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param waiveReportParmVOs the waiveReportParmVOs to set
    */
    public void setWaiveReportParmVOs(WaiveReportParmVO[] waiveReportParmVOs) {
    	if (waiveReportParmVOs != null) {
    		WaiveReportParmVO[] tmpVOs = new WaiveReportParmVO[waiveReportParmVOs.length];
			System.arraycopy(waiveReportParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.waiveReportParmVOs = tmpVOs;
		}
    }

    /**
    * @return the waiveReportDetailVO
    */
    public WaiveReportDetailVO getWaiveReportDetailVO() {
        return waiveReportDetailVO;
    }

    /**
    * @param waiveReportDetailVO the waiveReportDetailVO to set
    */
    public void setWaiveReportDetailVO(WaiveReportDetailVO waiveReportDetailVO) {
        this.waiveReportDetailVO = waiveReportDetailVO;
    }

    /**
    * @return the waiveReportDetailVOs
    */
    public WaiveReportDetailVO[] getWaiveReportDetailVOs() {
    	WaiveReportDetailVO[] tmpVOs = null;
		if (this.waiveReportDetailVOs != null) {
			tmpVOs = new WaiveReportDetailVO[waiveReportDetailVOs.length];
			System.arraycopy(waiveReportDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param waiveReportDetailVOs the waiveReportDetailVOs to set
    */
    public void setWaiveReportDetailVOs(WaiveReportDetailVO[] waiveReportDetailVOs) {
    	if (waiveReportDetailVOs != null) {
    		WaiveReportDetailVO[] tmpVOs = new WaiveReportDetailVO[waiveReportDetailVOs.length];
			System.arraycopy(waiveReportDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.waiveReportDetailVOs = tmpVOs;
		}
    }

}
