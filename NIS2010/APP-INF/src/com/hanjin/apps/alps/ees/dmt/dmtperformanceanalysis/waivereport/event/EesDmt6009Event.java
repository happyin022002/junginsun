/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6009Event.java
*@FileTitle : Waive Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.20 mun jung cheol
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_6009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6009Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private WaiveReportParmVO  waiveReportParmVO  = null;

    private WaiveReportParmVO [] waiveReportParmVOs  = null;
    
    private WaiveReportSummaryVO  waiveReportSummaryVO  = null;

    private WaiveReportSummaryVO [] waiveReportSummaryVOs  = null;    

    public EesDmt6009Event(){}

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
        return waiveReportParmVOs;
    }

    /**
    * @param waiveReportParmVOs the waiveReportParmVOs to set
    */
    public void setWaiveReportParmVOs(WaiveReportParmVO[] waiveReportParmVOs) {
        this.waiveReportParmVOs = waiveReportParmVOs;
    }

    /**
    * @return the waiveReportSummaryVO
    */
    public WaiveReportSummaryVO getWaiveReportSummaryVO() {
        return waiveReportSummaryVO;
    }

    /**
    * @param waiveReportSummaryVO the waiveReportSummaryVO to set
    */
    public void setWaiveReportSummaryVO(WaiveReportSummaryVO waiveReportSummaryVO) {
        this.waiveReportSummaryVO = waiveReportSummaryVO;
    }

    /**
    * @return the waiveReportSummaryVOs
    */
    public WaiveReportSummaryVO[] getWaiveReportSummaryVOs() {
        return waiveReportSummaryVOs;
    }

    /**
    * @param waiveReportSummaryVOs the waiveReportSummaryVOs to set
    */
    public void setWaiveReportSummaryVOs(
            WaiveReportSummaryVO[] waiveReportSummaryVOs) {
        this.waiveReportSummaryVOs = waiveReportSummaryVOs;
    }    

}
