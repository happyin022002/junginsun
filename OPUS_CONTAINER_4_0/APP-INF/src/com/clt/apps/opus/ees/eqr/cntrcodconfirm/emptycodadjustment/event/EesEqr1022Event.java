/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1022Event.java
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODMasterVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1039 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1039HTMLAction<br>
 * - ServiceCommand Layer PDTO<br>
 *
 * @author 
 * @see EES_CIM_1049HTMLAction
 * @since J2EE 1.6
 */
public class EesEqr1022Event extends EventSupport { 

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object   */
    private EmptyCODMasterVO emptyCODMasterVO = null;
    
    /** Table Value Object Multi Data  */
    private EmptyCODMasterVO[] emptyCODMasterVOs = null;

    private EmptyCODVVDPort01VO emptyCODVVDPortVO = null;   
    
    private EmptyCODVVDPort01VO[] emptyCODVVDPortVOS = null;    
    
    public EesEqr1022Event(){}

    /**
    * @return the emptyCODMasterVO
    */
    public EmptyCODMasterVO getEmptyCODMasterVO() {
        return emptyCODMasterVO;
    }

    /**
    * @param emptyCODMasterVO the emptyCODMasterVO to set
    */
    public void setEmptyCODMasterVO(EmptyCODMasterVO emptyCODMasterVO) {
        this.emptyCODMasterVO = emptyCODMasterVO;
    }

    /**
    * @return the emptyCODMasterVOs
    */
    public EmptyCODMasterVO[] getEmptyCODMasterVOs() {
    	EmptyCODMasterVO[] tmpVOs = null;
		if (this.emptyCODMasterVOs != null) {
			tmpVOs = new EmptyCODMasterVO[emptyCODMasterVOs.length];
			System.arraycopy(emptyCODMasterVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param emptyCODMasterVOs the emptyCODMasterVOs to set
    */
    public void setEmptyCODMasterVOs(EmptyCODMasterVO[] emptyCODMasterVOs) {
    	if (emptyCODMasterVOs != null) {
    		EmptyCODMasterVO[] tmpVOs = new EmptyCODMasterVO[emptyCODMasterVOs.length];
			System.arraycopy(emptyCODMasterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODMasterVOs = tmpVOs;
		}
    }

    /**
    * @return the emptyCODVVDPortVO
    */
    public EmptyCODVVDPort01VO getEmptyCODVVDPortVO() {
        return emptyCODVVDPortVO;
    }

    /**
    * @param emptyCODVVDPortVO the emptyCODVVDPortVO to set
    */
    public void setEmptyCODVVDPortVO(EmptyCODVVDPort01VO emptyCODVVDPortVO) {
        this.emptyCODVVDPortVO = emptyCODVVDPortVO;
    }

    /**
    * @return the emptyCODVVDPortVOS
    */
    public EmptyCODVVDPort01VO[] getEmptyCODVVDPortVOS() {
    	EmptyCODVVDPort01VO[] tmpVOs = null;
		if (this.emptyCODVVDPortVOS != null) {
			tmpVOs = new EmptyCODVVDPort01VO[emptyCODVVDPortVOS.length];
			System.arraycopy(emptyCODVVDPortVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param emptyCODVVDPortVOS the emptyCODVVDPortVOS to set
    */
    public void setEmptyCODVVDPortVOS(EmptyCODVVDPort01VO[] emptyCODVVDPortVOS) {
    	if (emptyCODVVDPortVOS != null) {
    		EmptyCODVVDPort01VO[] tmpVOs = new EmptyCODVVDPort01VO[emptyCODVVDPortVOS.length];
			System.arraycopy(emptyCODVVDPortVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDPortVOS = tmpVOs;
		}
    }
    
}
