/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr8001Event.java
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-17
*@LastModifier : dev098
*@LastVersion : 1.0
* 2009-08-17 dev098
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODMasterVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDPortVO00;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1049HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr8001Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private EmptyCODMasterVO emptyCODMasterVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private EmptyCODMasterVO[] emptyCODMasterVOs = null;

    private EmptyCODVVDPortVO00 emptyCODVVDPortVO = null;   
    
    private EmptyCODVVDPortVO00[] emptyCODVVDPortVOS = null;    
    
    public EesEqr8001Event(){}

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
    public EmptyCODVVDPortVO00 getEmptyCODVVDPortVO() {
        return emptyCODVVDPortVO;
    }

    /**
    * @param emptyCODVVDPortVO the emptyCODVVDPortVO to set
    */
    public void setEmptyCODVVDPortVO(EmptyCODVVDPortVO00 emptyCODVVDPortVO) {
        this.emptyCODVVDPortVO = emptyCODVVDPortVO;
    }

    /**
    * @return the emptyCODVVDPortVOS
    */
    public EmptyCODVVDPortVO00[] getEmptyCODVVDPortVOS() {
    	EmptyCODVVDPortVO00[] tmpVOs = null;
		if (this.emptyCODVVDPortVOS != null) {
			tmpVOs = new EmptyCODVVDPortVO00[emptyCODVVDPortVOS.length];
			System.arraycopy(emptyCODVVDPortVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param emptyCODVVDPortVOS the emptyCODVVDPortVOS to set
    */
    public void setEmptyCODVVDPortVOS(EmptyCODVVDPortVO00[] emptyCODVVDPortVOS) {
    	if (emptyCODVVDPortVOS != null) {
    		EmptyCODVVDPortVO00[] tmpVOs = new EmptyCODVVDPortVO00[emptyCODVVDPortVOS.length];
			System.arraycopy(emptyCODVVDPortVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDPortVOS = tmpVOs;
		}
    }
    
}
