/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007904Event.java
*@FileTitle : Container Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.19 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;


/**
 * ESM_BKG_0079_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0079_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg007904Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
    private CntrEtcInfoVO bkgEtcInfoVO = null;
    private ContainerVO[] containerVOs = null;
    private BkgCntrSealNoVO[] bkgCntrSealNoVOs = null;
    private CntrAdjVolVO[] cntrAdjVolVOs = null;

    private String bkgNo = null;
    private String blNo = null;
    
    private String scrnAuth = null;
    
    private String cntrNo = null;


    public EsmBkg007904Event(){}

    /**
     * @return the bkgEtcInfoVO
     */
    public CntrEtcInfoVO getBkgEtcInfoVO() {
        return bkgEtcInfoVO;
    }

    /**
     * @param bkgEtcInfoVO the bkgEtcInfoVO to set
     */
    public void setBkgEtcInfoVO(CntrEtcInfoVO bkgEtcInfoVO) {
        this.bkgEtcInfoVO = bkgEtcInfoVO;
    }

    public ContainerVO[] getContainerVOs() {
    	ContainerVO[] rtnVOs = null;
		if (this.containerVOs != null) {
			rtnVOs = Arrays.copyOf(containerVOs, containerVOs.length);
		}
		return rtnVOs;
	}

	public void setContainerVOs(ContainerVO[] containerVOs) {
		if (containerVOs != null) {
			ContainerVO[] tmpVOs = Arrays.copyOf(containerVOs, containerVOs.length);
			this.containerVOs = tmpVOs;
		}
	}

	public BkgCntrSealNoVO[] getBkgCntrSealNoVOs() {
		BkgCntrSealNoVO[] rtnVOs = null;
		if (this.bkgCntrSealNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCntrSealNoVOs, bkgCntrSealNoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCntrSealNoVOs(BkgCntrSealNoVO[] bkgCntrSealNoVOs) {
		if (bkgCntrSealNoVOs != null) {
			BkgCntrSealNoVO[] tmpVOs = Arrays.copyOf(bkgCntrSealNoVOs, bkgCntrSealNoVOs.length);
			this.bkgCntrSealNoVOs = tmpVOs;
		}
	}

	public CntrAdjVolVO[] getCntrAdjVolVOs() {
		CntrAdjVolVO[] rtnVOs = null;
		if (this.cntrAdjVolVOs != null) {
			rtnVOs = Arrays.copyOf(cntrAdjVolVOs, cntrAdjVolVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrAdjVolVOs(CntrAdjVolVO[] cntrAdjVolVOs) {
		if (cntrAdjVolVOs != null) {
			CntrAdjVolVO[] tmpVOs = Arrays.copyOf(cntrAdjVolVOs, cntrAdjVolVOs.length);
			this.cntrAdjVolVOs = tmpVOs;
		}
	}
    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }


	/**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     * @return the blTpCd
     */
    public String getScrnAuth() {
        return scrnAuth;
    }

    /**
     * @param blTpCd the blTpCd to set
     */
    public void setScrnAuth(String scrnAuth) {
        this.scrnAuth = scrnAuth;
    }

    /**
     * @return the cntrNo
     */
    public String getCntrNo() {
        return cntrNo;
    }

    /**
     * @param cntrNo the cntrNo to set
     */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

}