/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PricommonEvent.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.16 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.event;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriCommonVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriTariffVO;

/**
 * PRICommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  PRICommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Sungsoo
 * @see PRICommonHTMLAction 참조
 * @since J2EE 1.4
 */

public class PricommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCdListVO rsltcdlistvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltCdListVO[] rsltcdlistvos = null;
	
	private PriAuthorizationVO priAuthorizationVO = null;
	private PriAuthorizationVO[] priAuthorizationVOS = null;

	private ComOrganizationVO comOrganizationVO = null;

	private MdmChargeVO mdmChargeVO = null;
	
	private MdmSlsRepVO mdmSlsRepVO = null;
	
	private ComUpldFileVO comUpldFileVO = null;
	
	private RsltCompensationChargeComboListVO   rsltCompensationChargeComboListVO = null;	
	private RsltCompensationChargeComboListVO[] rsltCompensationChargeComboListVOS = null;	
	
	private CheckUpdateDateVO checkUpdateDateVO = null;
	
	private PriTariffVO priTariffVO = null;
	
	private PriCommonVO priCommonVO = null;

	public PriTariffVO getPriTariffVO() {
		return priTariffVO;
	}

	public void setPriTariffVO(PriTariffVO priTariffVO) {
		this.priTariffVO = priTariffVO;
	}

	private String key = null;
	
	public PricommonEvent(){}
	
	public void setCheckUpdateDateVO(CheckUpdateDateVO checkUpdateDateVO){
		this. checkUpdateDateVO = checkUpdateDateVO;
	}
	public CheckUpdateDateVO getCheckUpdateDateVO(){
		return  checkUpdateDateVO ;
	}

	
	public void setRsltCdListVO(RsltCdListVO rsltcdlistvo){
		this. rsltcdlistvo = rsltcdlistvo;
	}

	public void setRsltCdListVOS(RsltCdListVO[] rsltcdlistvos){
		if(rsltcdlistvos != null){
			RsltCdListVO[] tmpVOs = new RsltCdListVO[rsltcdlistvos.length];
			System.arraycopy(rsltcdlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltcdlistvos = tmpVOs;
		}
	}

	public RsltCdListVO getRsltCdListVO(){
		return rsltcdlistvo;
	}

	public RsltCdListVO[] getRsltCdListVOS(){
		RsltCdListVO[] rtnVOs = null;
		if (this.rsltcdlistvos != null) {
			rtnVOs = new RsltCdListVO[rsltcdlistvos.length];
			System.arraycopy(rsltcdlistvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriAuthorizationVO getPriAuthorizationVO() {
		return priAuthorizationVO;
	}

	public void setPriAuthorizationVO(PriAuthorizationVO priAuthorizationVO) {
		this.priAuthorizationVO = priAuthorizationVO;
	}
	
	public PriAuthorizationVO[] getPriAuthorizationVOS() {
		PriAuthorizationVO[] rtnVOs = null;
		if (this.priAuthorizationVOS != null) {
			rtnVOs = new PriAuthorizationVO[priAuthorizationVOS.length];
			System.arraycopy(priAuthorizationVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltCompensationChargeComboListVO(RsltCompensationChargeComboListVO rsltCompensationChargeComboListVO) {
		this.rsltCompensationChargeComboListVO = rsltCompensationChargeComboListVO;
	}
	
	public RsltCompensationChargeComboListVO getRsltCompensationChargeComboListVO() {
		return this.rsltCompensationChargeComboListVO;
	}

	public void setRsltCompensationChargeComboListVOS(RsltCompensationChargeComboListVO[] rsltCompensationChargeComboListVOS){
		if(rsltCompensationChargeComboListVOS != null){
			RsltCompensationChargeComboListVO[] tmpVOs = new RsltCompensationChargeComboListVO[rsltCompensationChargeComboListVOS.length];
			System.arraycopy(rsltCompensationChargeComboListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltCompensationChargeComboListVOS = tmpVOs;
		}
	}
	
	public RsltCompensationChargeComboListVO[] getRsltCompensationChargeComboListVOS() {
		RsltCompensationChargeComboListVO[] rtnVOs = null;
		if (this.rsltCompensationChargeComboListVOS != null) {
			rtnVOs = new RsltCompensationChargeComboListVO[rsltCompensationChargeComboListVOS.length];
			System.arraycopy(rsltCompensationChargeComboListVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setPriAuthorizationVOS(PriAuthorizationVO[] priAuthorizationVOS){
		if(priAuthorizationVOS != null){
			PriAuthorizationVO[] tmpVOs = new PriAuthorizationVO[priAuthorizationVOS.length];
			System.arraycopy(priAuthorizationVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priAuthorizationVOS = tmpVOs;
		}
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
     * @return the mdmChargeVO
     */
    public MdmChargeVO getMdmChargeVO () {
        return mdmChargeVO;
    }

    /**
     * @param mdmChargeVO the mdmChargeVO to set
     */
    public void setMdmChargeVO (MdmChargeVO mdmChargeVO) {
        this.mdmChargeVO = mdmChargeVO;
    }

    /**
     * @return the mdmSlsRepVO
     */
    public MdmSlsRepVO getMdmSlsRepVO () {
        return mdmSlsRepVO;
    }

    /**
     * @param mdmSlsRepVO the mdmSlsRepVO to set
     */
    public void setMdmSlsRepVO (MdmSlsRepVO mdmSlsRepVO) {
        this.mdmSlsRepVO = mdmSlsRepVO;
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

    /**
     * @return the comUpldFileVO
     */
    public ComUpldFileVO getComUpldFileVO() {
        return comUpldFileVO;
    }

    /**
     * @param comUpldFileVO the comUpldFileVO to set
     */
    public void setComUpldFileVO(ComUpldFileVO comUpldFileVO) {
        this.comUpldFileVO = comUpldFileVO;
    }

	public PriCommonVO getPriCommonVO() {
		return priCommonVO;
	}

	public void setPriCommonVO(PriCommonVO priCommonVO) {
		this.priCommonVO = priCommonVO;
	}
}