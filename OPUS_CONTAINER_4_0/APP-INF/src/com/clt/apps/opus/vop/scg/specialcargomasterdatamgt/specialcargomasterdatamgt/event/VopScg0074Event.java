/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0073Event.java
*@FileTitle : Special Provisions for Segregation (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.08 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String imdgsclprovino = "";
	private String imdgUnNo     = "";
	private String imdgUnNoSeq = "";	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSpclProvisVO scgImdgSpclProvisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgSpclProvisVO[] scgImdgSpclProvisVOs = null;

	public VopScg0074Event(){}
 

    /**
     * @return the imdgsclprovino
     */
    public String getImdgsclprovino() {
        return imdgsclprovino;
    }
 

    /**
     * @param imdgsclprovino the imdgsclprovino to set
     */
    public void setImdgsclprovino(String imdgsclprovino) {
        this.imdgsclprovino = imdgsclprovino;
    }


    /**
     * @return the scgImdgSpclProvisVO
     */
    public ScgImdgSpclProvisVO getScgImdgSpclProvisVO() {
        return scgImdgSpclProvisVO;
    }


    /**
     * @return the scgImdgSpclProvisVOs
     */
    public ScgImdgSpclProvisVO[] getScgImdgSpclProvisVOs() {
        ScgImdgSpclProvisVO[] rtnVOs = null;
		if (this.scgImdgSpclProvisVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgSpclProvisVOs, scgImdgSpclProvisVOs.length);
		}
		return rtnVOs;
    }


    /**
     * @param scgImdgSpclProvisVO the scgImdgSpclProvisVO to set
     */
    public void setScgImdgSpclProvisVO(ScgImdgSpclProvisVO scgImdgSpclProvisVO) {
        this.scgImdgSpclProvisVO = scgImdgSpclProvisVO;
    }


    /**
     * @param scgImdgSpclProvisVOs the scgImdgSpclProvisVOs to set
     */
    public void setScgImdgSpclProvisVOs(ScgImdgSpclProvisVO[] scgImdgSpclProvisVOs) {
		if(scgImdgSpclProvisVOs != null){
			ScgImdgSpclProvisVO[] tmpVOs = Arrays.copyOf(scgImdgSpclProvisVOs, scgImdgSpclProvisVOs.length);
			this.scgImdgSpclProvisVOs = tmpVOs;
		}
    }

 
    /**
     * @return the imdgUnNo
     */
    public String getImdgUnNo() {
        return imdgUnNo;
    }


    /**
     * @return the imdgUnNoSeq
     */
    public String getImdgUnNoSeq() {
        return imdgUnNoSeq;
    }


    /**
     * @param imdgUnNo the imdgUnNo to set
     */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
    }


    /**
     * @param imdgUnNoSeq the imdgUnNoSeq to set
     */
    public void setImdgUnNoSeq(String imdgUnNoSeq) {
        this.imdgUnNoSeq = imdgUnNoSeq;
    }
 
}