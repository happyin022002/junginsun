/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopOpf004606Event.java
*@FileTitle : RDR Creation – Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;


/**
 * VOP_OPF_0046_06 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0046_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_OPF_0046_06HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf004606Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

    private RDRCrtListOptionVO rDRCrtListOptionVO = null;
    private RdrCreatInfoVO rdrCreatInfoVO = null;
    private RdrCreatInfoVO[] rdrCreatInfoVOs = null;
 
    public VopOpf004606Event(){}


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
 			rtnVOs = new RdrCreatInfoVO[rdrCreatInfoVOs.length];
 			System.arraycopy(rdrCreatInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
    }


    /**
     * @param rdrCreatInfoVOs the rdrCreatInfoVOs to set
     */
    public void setRdrCreatInfoVOs(RdrCreatInfoVO[] rdrCreatInfoVOs) {
        if (rdrCreatInfoVOs != null) {
    		RdrCreatInfoVO[] tmpVOs = new RdrCreatInfoVO[rdrCreatInfoVOs.length];
			System.arraycopy(rdrCreatInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rdrCreatInfoVOs = tmpVOs;
		}
    }
}