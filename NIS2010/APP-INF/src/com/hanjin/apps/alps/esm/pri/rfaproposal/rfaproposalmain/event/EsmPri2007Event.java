/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2007Event.java
*@FileTitle : RFA Proposal Creation [Request]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.01 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefUsrVO;


/**
 * ESM_PRI_2007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAproRqstRefUsrVO priRpAproRqstRefUsrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
    private ComOrganizationVO comOrganizationVO = null;
    
    /** Custom Value Object Multi Data 처리 */
    private ComOrganizationVO[] comOrganizationVOs = null;
    
	public EsmPri2007Event(){}
	
	public void setPriRpAproRqstRefUsrVO(PriRpAproRqstRefUsrVO priRpAproRqstRefUsrVO){
		this. priRpAproRqstRefUsrVO = priRpAproRqstRefUsrVO;
	}

	public void setPriRpAproRqstRefUsrVOs(PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs){
		if(priRpAproRqstRefUsrVOs != null){
			PriRpAproRqstRefUsrVO[] tmpVOs = new PriRpAproRqstRefUsrVO[priRpAproRqstRefUsrVOs.length];
			System.arraycopy(priRpAproRqstRefUsrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAproRqstRefUsrVOs = tmpVOs;
		}
	}

	public PriRpAproRqstRefUsrVO getPriRpAproRqstRefUsrVO(){
		return priRpAproRqstRefUsrVO;
	}

	public PriRpAproRqstRefUsrVO[] getPriRpAproRqstRefUsrVOs(){
		PriRpAproRqstRefUsrVO[] rtnVOs = null;
		if (this.priRpAproRqstRefUsrVOs != null) {
			rtnVOs = new PriRpAproRqstRefUsrVO[priRpAproRqstRefUsrVOs.length];
			System.arraycopy(priRpAproRqstRefUsrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the comOrganizationVO
     */
    public ComOrganizationVO getComOrganizationVO () {
        return comOrganizationVO;
    }

    /**
     * @param comOrganizationVO the comOrganizationVO to set
     */
    public void setComOrganizationVO (ComOrganizationVO comOrganizationVO) {
        this.comOrganizationVO = comOrganizationVO;
    }

    /**
     * @return the comOrganizationVOs
     */
    public ComOrganizationVO[] getComOrganizationVOs() {
		ComOrganizationVO[] rtnVOs = null;
		if (this.comOrganizationVOs != null) {
			rtnVOs = new ComOrganizationVO[comOrganizationVOs.length];
			System.arraycopy(comOrganizationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param comOrganizationVOs the comOrganizationVOs to set
     */
    public void setComOrganizationVOs(ComOrganizationVO[] comOrganizationVOs){
		if(comOrganizationVOs != null){
			ComOrganizationVO[] tmpVOs = new ComOrganizationVO[comOrganizationVOs.length];
			System.arraycopy(comOrganizationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comOrganizationVOs = tmpVOs;
		}
    }



}