/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopOpf004604Event.java
*@FileTitle : RDR Creation – RF
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
 * VOP_OPF_0046_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0046_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_OPF_0046_04HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf004604Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /** Table Value Object 조회 조건 및 단건 처리  */
    private RDRCrtListOptionVO rDRCrtListOptionVO = null;
    private RdrCreatInfoVO         rdrCreatInfoVO = null;
    private RdrCreatInfoVO[]      rdrCreatInfoMainTradeVOs = null; //MainTrade
    private RdrCreatInfoVO[]      rdrCreatInfoInterPortVOs = null;//InterPort
    
    public VopOpf004604Event(){}

    /**
     * @return the rDRCrtListOptionVO
     */
    public RDRCrtListOptionVO getRDRCrtListOptionVO() {
        return rDRCrtListOptionVO;
 
    }

    /**
     * @return the rdrCreatInfoVO
     */
    public RdrCreatInfoVO getRdrCreatInfoVO() {
        return rdrCreatInfoVO;
    }

    /**
     * @return the rdrCreatInfoMainTradeVOs
     */
    public RdrCreatInfoVO[] getRdrCreatInfoMainTradeVOs() {
        RdrCreatInfoVO[] rtnVOs = null;
 		
 		if (this.rdrCreatInfoMainTradeVOs != null) {
 			rtnVOs = new RdrCreatInfoVO[rdrCreatInfoMainTradeVOs.length];
 			System.arraycopy(rdrCreatInfoMainTradeVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
    }

    /**
     * @return the rdrCreatInfoInterPortVOs
     */
    public RdrCreatInfoVO[] getRdrCreatInfoInterPortVOs() {
        RdrCreatInfoVO[] rtnVOs = null;
 		
 		if (this.rdrCreatInfoMainTradeVOs != null) {
 			rtnVOs = new RdrCreatInfoVO[rdrCreatInfoInterPortVOs.length];
 			System.arraycopy(rdrCreatInfoInterPortVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
    }

    /**
     * @param crtListOptionVO the rDRCrtListOptionVO to set
     */
    public void setRDRCrtListOptionVO(RDRCrtListOptionVO crtListOptionVO) {
        rDRCrtListOptionVO = crtListOptionVO;
    }

    /**
     * @param rdrCreatInfoVO the rdrCreatInfoVO to set
     */
    public void setRdrCreatInfoVO(RdrCreatInfoVO rdrCreatInfoVO) {
        this.rdrCreatInfoVO = rdrCreatInfoVO;
    }

    /**
     * @param rdrCreatInfoMainTradeVOs the rdrCreatInfoMainTradeVOs to set
     */
    public void setRdrCreatInfoMainTradeVOs(
        RdrCreatInfoVO[] rdrCreatInfoMainTradeVOs) {
    	if (rdrCreatInfoMainTradeVOs != null) {
    		RdrCreatInfoVO[] tmpVOs = new RdrCreatInfoVO[rdrCreatInfoMainTradeVOs.length];
			System.arraycopy(rdrCreatInfoMainTradeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rdrCreatInfoMainTradeVOs = tmpVOs;
		}
    }

    /**
     * @param rdrCreatInfoInterPortVOs the rdrCreatInfoInterPortVOs to set
     */
    public void setRdrCreatInfoInterPortVOs(
            RdrCreatInfoVO[] rdrCreatInfoInterPortVOs) {
   
        if (rdrCreatInfoInterPortVOs != null) {
        	RdrCreatInfoVO[] tmpVOs = new RdrCreatInfoVO[rdrCreatInfoInterPortVOs.length];
			System.arraycopy(rdrCreatInfoInterPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rdrCreatInfoInterPortVOs = tmpVOs;
		}
    }

 
}