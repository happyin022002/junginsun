/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopOpf0046Event.java
*@FileTitle : RDR Creation – Main
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_OPF_0046HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDRCrtListOptionVO rDRCrtListOptionVO = null;
 
	public VopOpf0046Event(){}

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
 

}