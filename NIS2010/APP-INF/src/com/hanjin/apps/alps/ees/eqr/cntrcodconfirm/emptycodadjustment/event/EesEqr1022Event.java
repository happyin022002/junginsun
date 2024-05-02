/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1022Event.java
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODMasterVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1049HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1022Event extends EventSupport { 

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private EmptyCODMasterVO emptyCODMasterVO = null;
    
    /** Table Value Object Multi Data 처리 */
    public EmptyCODMasterVO[] emptyCODMasterVOs = null;

    private EmptyCODVVDPort01VO emptyCODVVDPortVO = null;   
    
    public EmptyCODVVDPort01VO[] emptyCODVVDPortVOS = null;    
    
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
        return emptyCODMasterVOs;
    }

    /**
    * @param emptyCODMasterVOs the emptyCODMasterVOs to set
    */
    public void setEmptyCODMasterVOs(EmptyCODMasterVO[] emptyCODMasterVOs) {
        this.emptyCODMasterVOs = emptyCODMasterVOs;
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
        return emptyCODVVDPortVOS;
    }

    /**
    * @param emptyCODVVDPortVOS the emptyCODVVDPortVOS to set
    */
    public void setEmptyCODVVDPortVOS(EmptyCODVVDPort01VO[] emptyCODVVDPortVOS) {
        this.emptyCODVVDPortVOS = emptyCODVVDPortVOS;
    }
    
}
