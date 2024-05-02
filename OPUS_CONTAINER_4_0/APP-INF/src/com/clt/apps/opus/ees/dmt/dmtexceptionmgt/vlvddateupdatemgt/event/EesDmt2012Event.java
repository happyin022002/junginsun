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

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.event;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVslDtUpdVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.clt.framework.support.layer.event.EventSupport;


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
    	DmtVesselDateUpdateParmVO[] tmpVOs = null;
		if (this.dmtVesselDateUpdateParmVOs != null) {
			tmpVOs = new DmtVesselDateUpdateParmVO[dmtVesselDateUpdateParmVOs.length];
			System.arraycopy(dmtVesselDateUpdateParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param dmtVesselDateUpdateParmVOs the dmtVesselDateUpdateParmVOs to set
    */
    public void setDmtVesselDateUpdateParmVOs(
            DmtVesselDateUpdateParmVO[] dmtVesselDateUpdateParmVOs) {
    	if (dmtVesselDateUpdateParmVOs != null) {
    		DmtVesselDateUpdateParmVO[] tmpVOs = new DmtVesselDateUpdateParmVO[dmtVesselDateUpdateParmVOs.length];
			System.arraycopy(dmtVesselDateUpdateParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtVesselDateUpdateParmVOs = tmpVOs;
		}
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
    	VslDtUpdListVO[] tmpVOs = null;
		if (this.vslDtUpdListVOs != null) {
			tmpVOs = new VslDtUpdListVO[vslDtUpdListVOs.length];
			System.arraycopy(vslDtUpdListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param vslDtUpdListVOs the vslDtUpdListVOs to set
    */
    public void setVslDtUpdListVOs(VslDtUpdListVO[] vslDtUpdListVOs) {
    	if (vslDtUpdListVOs != null) {
    		VslDtUpdListVO[] tmpVOs = new VslDtUpdListVO[vslDtUpdListVOs.length];
			System.arraycopy(vslDtUpdListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslDtUpdListVOs = tmpVOs;
		}
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
    	DmtVslDtUpdVO[] tmpVOs = null;
		if (this.dmtVslDtUpdVOs != null) {
			tmpVOs = new DmtVslDtUpdVO[dmtVslDtUpdVOs.length];
			System.arraycopy(dmtVslDtUpdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param dmtVslDtUpdVOs the dmtVslDtUpdVOs to set
    */
    public void setDmtVslDtUpdVOs(DmtVslDtUpdVO[] dmtVslDtUpdVOs) {
    	if (dmtVslDtUpdVOs != null) {
    		DmtVslDtUpdVO[] tmpVOs = new DmtVslDtUpdVO[dmtVslDtUpdVOs.length];
			System.arraycopy(dmtVslDtUpdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtVslDtUpdVOs = tmpVOs;
		}
    }

}