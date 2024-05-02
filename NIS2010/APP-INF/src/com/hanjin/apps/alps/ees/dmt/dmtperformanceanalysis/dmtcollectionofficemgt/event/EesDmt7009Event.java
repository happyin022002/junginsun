/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7009Event.java
*@FileTitle : Exception Cost by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.08.03 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_7009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Hwa
 * @see EES_DMT_7009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7009Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private DmtYdExptCostParmVO dmtYdExptCostParmVO  = null;
    
   private DmtYdExptCostVO dmtYdExptCostVO  = null;
    
    private DmtYdExptCostVO[] dmtYdExptCostVOs  = null;    
    
    public EesDmt7009Event(){}

    /**
    * @return the collectionOfficeFinderVO
    */
    public DmtYdExptCostParmVO getDmtYdExptCostParmVO() {
        return dmtYdExptCostParmVO;
    }

    /**
    * @param dmtYdExptCostParmVO the dmtYdExptCostParmVO to set
    */
    public void setDmtYdExptCostParmVO(
            DmtYdExptCostParmVO dmtYdExptCostParmVO) {
        this.dmtYdExptCostParmVO = dmtYdExptCostParmVO;
    }



    /**
    * @return the dmtYdExptCostVO
    */
    public DmtYdExptCostVO getDmtYdExptCostVO() {
        return dmtYdExptCostVO;
    }

    /**
    * @param dmtYdExptCostVO the dmtYdExptCostVO to set
    */
    public void setDmtYdExptCostVO(DmtYdExptCostVO dmtYdExptCostVO) {
        this.dmtYdExptCostVO = dmtYdExptCostVO;
    }

    /**
    * @return the dmtYdExptCostVOs
    */
    public DmtYdExptCostVO[] getDmtYdExptCostVOs() {
        return dmtYdExptCostVOs;
    }

    /**
    * @param dmtYdExptCostVOs the dmtYdExptCostVOs to set
    */
    public void setDmtYdExptCostVOs(DmtYdExptCostVO[] dmtYdExptCostVOs) {
        this.dmtYdExptCostVOs = dmtYdExptCostVOs;
    }

}
