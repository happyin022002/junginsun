/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1604Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.OrganizationChartVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefUsrVO;


/**
 * ESM_BKG_1604 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1604HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_1604HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1604Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAproRqstRefUsrVO priRpAproRqstRefUsrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
    private OrganizationChartVO organizationChartVO = null;
    
    /** Custom Value Object Multi Data 처리 */
    private OrganizationChartVO[] organizationChartVOs = null;
    
	public EsmBkg1604Event(){}
	
	public void setPriRpAproRqstRefUsrVO(PriRpAproRqstRefUsrVO priRpAproRqstRefUsrVO){
		this. priRpAproRqstRefUsrVO = priRpAproRqstRefUsrVO;
	}

	public void setPriRpAproRqstRefUsrVOs(PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs){
		if(priRpAproRqstRefUsrVOs != null){
			PriRpAproRqstRefUsrVO[] tmpVOs = Arrays.copyOf(priRpAproRqstRefUsrVOs, priRpAproRqstRefUsrVOs.length);
			this.priRpAproRqstRefUsrVOs = tmpVOs;
		}
	}

	public PriRpAproRqstRefUsrVO getPriRpAproRqstRefUsrVO(){
		return priRpAproRqstRefUsrVO;
	}

	public PriRpAproRqstRefUsrVO[] getPriRpAproRqstRefUsrVOs(){
		PriRpAproRqstRefUsrVO[] rtnVOs = null;
		if (this.priRpAproRqstRefUsrVOs != null) {
			rtnVOs = Arrays.copyOf(priRpAproRqstRefUsrVOs, priRpAproRqstRefUsrVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the comOrganizationVO
     */
    public OrganizationChartVO getOrganizationChartVO () {
        return organizationChartVO;
    }

    /**
     * @param comOrganizationVO the comOrganizationVO to set
     */
    public void setOrganizationChartVO (OrganizationChartVO organizationChartVO) {
        this.organizationChartVO = organizationChartVO;
    }

    /**
     * @return the comOrganizationVOs
     */
    public OrganizationChartVO[] getOrganizationChartVOs() {
		OrganizationChartVO[] rtnVOs = null;
		if (this.organizationChartVOs != null) {
			rtnVOs = Arrays.copyOf(organizationChartVOs, organizationChartVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param comOrganizationVOs the comOrganizationVOs to set
     */
    public void setOrganizationChartVOs(OrganizationChartVO[] organizationChartVOs){
		if(organizationChartVOs != null){
			OrganizationChartVO[] tmpVOs = Arrays.copyOf(organizationChartVOs, organizationChartVOs.length);
			this.organizationChartVOs = tmpVOs;
		}
    }



}