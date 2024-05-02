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
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
        return waiveReportParmVOs;
    }

    /**
    * @param waiveReportParmVOs the waiveReportParmVOs to set
    */
    public void setWaiveReportParmVOs(WaiveReportParmVO[] waiveReportParmVOs) {
        this.waiveReportParmVOs = waiveReportParmVOs;
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
        return waiveReportDetailVOs;
    }

    /**
    * @param waiveReportDetailVOs the waiveReportDetailVOs to set
    */
    public void setWaiveReportDetailVOs(WaiveReportDetailVO[] waiveReportDetailVOs) {
        this.waiveReportDetailVOs = waiveReportDetailVOs;
    }

}
