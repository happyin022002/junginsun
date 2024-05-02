/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiDmt2012Event.java
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김재진
*@LastVersion : 1.0
* 2009.08.26 김재진
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVslDtUpdVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_DMT_2012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_DMT_2012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jae Jin
 * @see EES_DMT_2012HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private DmtVesselDateUpdateParmVO dmtVesselDateUpdateParmVO  = null;
	
	private DmtVesselDateUpdateParmVO[] dmtVesselDateUpdateParmVOs  = null;
	
	private VslDtUpdListVO vslDtUpdListVO = null;
	
	private VslDtUpdListVO[] vslDtUpdListVOs = null;

    private DmtVslDtUpdVO dmtVslDtUpdVO = null;   
    
    private DmtVslDtUpdVO[] dmtVslDtUpdVOs = null;	
	
	public EesDmt2012Event(){}

    /**
    * @return the dmtVesselDateUpdateParmVO
    */
    public DmtVesselDateUpdateParmVO getDmtVesselDateUpdateParmVO() {
        return dmtVesselDateUpdateParmVO;
    }

    /**
    * @param dmtVesselDateUpdateParmVO the dmtVesselDateUpdateParmVO to set
    */
    public void setDmtVesselDateUpdateParmVO(
            DmtVesselDateUpdateParmVO dmtVesselDateUpdateParmVO) {
        this.dmtVesselDateUpdateParmVO = dmtVesselDateUpdateParmVO;
    }

    /**
    * @return the dmtVesselDateUpdateParmVOs
    */
    public DmtVesselDateUpdateParmVO[] getDmtVesselDateUpdateParmVOs() {
        return dmtVesselDateUpdateParmVOs;
    }

    /**
    * @param dmtVesselDateUpdateParmVOs the dmtVesselDateUpdateParmVOs to set
    */
    public void setDmtVesselDateUpdateParmVOs(
            DmtVesselDateUpdateParmVO[] dmtVesselDateUpdateParmVOs) {
        this.dmtVesselDateUpdateParmVOs = dmtVesselDateUpdateParmVOs;
    }

    /**
    * @return the vslDtUpdListVO
    */
    public VslDtUpdListVO getVslDtUpdListVO() {
        return vslDtUpdListVO;
    }

    /**
    * @param vslDtUpdListVO the vslDtUpdListVO to set
    */
    public void setVslDtUpdListVO(VslDtUpdListVO vslDtUpdListVO) {
        this.vslDtUpdListVO = vslDtUpdListVO;
    }

    /**
    * @return the vslDtUpdListVOs
    */
    public VslDtUpdListVO[] getVslDtUpdListVOs() {
        return vslDtUpdListVOs;
    }

    /**
    * @param vslDtUpdListVOs the vslDtUpdListVOs to set
    */
    public void setVslDtUpdListVOs(VslDtUpdListVO[] vslDtUpdListVOs) {
        this.vslDtUpdListVOs = vslDtUpdListVOs;
    }

    /**
    * @return the dmtVslDtUpdVO
    */
    public DmtVslDtUpdVO getDmtVslDtUpdVO() {
        return dmtVslDtUpdVO;
    }

    /**
    * @param dmtVslDtUpdVO the dmtVslDtUpdVO to set
    */
    public void setDmtVslDtUpdVO(DmtVslDtUpdVO dmtVslDtUpdVO) {
        this.dmtVslDtUpdVO = dmtVslDtUpdVO;
    }

    /**
    * @return the dmtVslDtUpdVOs
    */
    public DmtVslDtUpdVO[] getDmtVslDtUpdVOs() {
        return dmtVslDtUpdVOs;
    }

    /**
    * @param dmtVslDtUpdVOs the dmtVslDtUpdVOs to set
    */
    public void setDmtVslDtUpdVOs(DmtVslDtUpdVO[] dmtVslDtUpdVOs) {
        this.dmtVslDtUpdVOs = dmtVslDtUpdVOs;
    }

}