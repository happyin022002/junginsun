/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopOpf004603Event.java
*@FileTitle : RDR Creation – HC/45
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0046_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0046_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_OPF_0046_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf004603Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /** Table Value Object 조회 조건 및 단건 처리  */
    private RDRCrtListOptionVO rDRCrtListOptionVO = null;
    private RdrCreatInfoVO rdrCreatInfoVO = null;
    private RdrCreatInfoVO[] rdrCreatInfoVOs = null;
 
    public VopOpf004603Event(){}


    /**
     * @return the rDRCrtListOptionVO
     */
    public RDRCrtListOptionVO getRDRCrtListOptionVO() {
        return rDRCrtListOptionVO;
    }


    /**
     * @param crtListOptionVO the rDRCrtListOptionVO to set
     */
    public void setRDRCrtListOptionVO(RDRCrtListOptionVO crtListOptionVO) {
        rDRCrtListOptionVO = crtListOptionVO;
    }


    /**
     * @return the rdrCreatInfoVO
     */
    public RdrCreatInfoVO getRdrCreatInfoVO() {
        return rdrCreatInfoVO;
    }


    /**
     * @param rdrCreatInfoVO the rdrCreatInfoVO to set
     */
    public void setRdrCreatInfoVO(RdrCreatInfoVO rdrCreatInfoVO) {
        this.rdrCreatInfoVO = rdrCreatInfoVO;
    }


    /**
     * @return the rdrCreatInfoVOs
     */
    public RdrCreatInfoVO[] getRdrCreatInfoVOs() {
        RdrCreatInfoVO[] rtnVOs = null;
		if (this.rdrCreatInfoVOs != null) {
			rtnVOs = Arrays.copyOf(this.rdrCreatInfoVOs, this.rdrCreatInfoVOs.length);
		} // end if
		return rtnVOs;
    }


    /**
     * @param rdrCreatInfoVOs the rdrCreatInfoVOs to set
     */
    public void setRdrCreatInfoVOs(RdrCreatInfoVO[] rdrCreatInfoVOs) {
		if (rdrCreatInfoVOs != null) {
			RdrCreatInfoVO[] tmpVOs = Arrays.copyOf(rdrCreatInfoVOs, rdrCreatInfoVOs.length);
			this.rdrCreatInfoVOs = tmpVOs;
		} // end if
    }

}