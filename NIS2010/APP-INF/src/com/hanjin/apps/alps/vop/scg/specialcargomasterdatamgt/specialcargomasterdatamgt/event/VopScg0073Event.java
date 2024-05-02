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
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0073HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String imdgsclprovino = "";
	private String imdgunno     = "";
	private String imdgunnoseq = "";	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSpclProvisVO scgImdgSpclProvisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgSpclProvisVO[] scgImdgSpclProvisVOs = null;

	public VopScg0073Event(){}
 

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
    //2015.08.17 Secure Coding 적용 [CWE-495]
    public ScgImdgSpclProvisVO[] getScgImdgSpclProvisVOs() {
		ScgImdgSpclProvisVO[] rtnVOs = null;
		if (this.scgImdgSpclProvisVOs != null) {
			rtnVOs = new ScgImdgSpclProvisVO[scgImdgSpclProvisVOs.length];
			System.arraycopy(scgImdgSpclProvisVOs, 0, rtnVOs, 0, rtnVOs.length);
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
    //2015.08.17 Secure Coding 적용 [CWE-495]
    public void setScgImdgSpclProvisVOs(ScgImdgSpclProvisVO[] scgImdgSpclProvisVOs) {
		if (scgImdgSpclProvisVOs != null) {
			ScgImdgSpclProvisVO[] tmpVOs = new ScgImdgSpclProvisVO[scgImdgSpclProvisVOs.length];
			System.arraycopy(scgImdgSpclProvisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgSpclProvisVOs = tmpVOs;
		}
    }


    /**
     * @return the imdgunno
     */
    public String getImdgunno() {
        return imdgunno;
    }


    /**
     * @return the imdgunnoseq
     */
    public String getImdgunnoseq() {
        return imdgunnoseq;
    }


    /**
     * @param imdgunno the imdgunno to set
     */
    public void setImdgunno(String imdgunno) {
        this.imdgunno = imdgunno;
    }


    /**
     * @param imdgunnoseq the imdgunnoseq to set
     */
    public void setImdgunnoseq(String imdgunnoseq) {
        this.imdgunnoseq = imdgunnoseq;
    }

 
 
 
}