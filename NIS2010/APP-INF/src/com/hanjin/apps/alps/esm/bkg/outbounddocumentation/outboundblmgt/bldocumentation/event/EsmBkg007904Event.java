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
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;


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
    private CmBkgInfoVO cmBkgInfoVO = null;

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
    
    /**
     * @return the cmBkgInfoVO
     */
    public CmBkgInfoVO getCmBkgInfoVO() {
        return cmBkgInfoVO;
    }
    
    /**
     * @param cmBkgInfoVO the cmBkgInfoVO to set
     */
    public void setCmBkgInfoVO(CmBkgInfoVO cmBkgInfoVO) {
        this.cmBkgInfoVO = cmBkgInfoVO;
    }

    /**
     * @return the bkgContainerVOs
     */
    public ContainerVO[] getContainerVOs() {
        return containerVOs;
    }

    /**
     * @param bkgContainerVOs the bkgContainerVOs to set
     */
    public void setContainerVOs(ContainerVO[] containerVOs) {
        this.containerVOs = containerVOs;
    }

    /**
     * @return the bkgCntrSealNoVOs
     */
    public BkgCntrSealNoVO[] getBkgCntrSealNoVOs() {
        return bkgCntrSealNoVOs;
    }

    /**
     * @param cntrAdjVolVOs
     */
    public void setCntrAdjVolVOs(CntrAdjVolVO[] cntrAdjVolVOs) {
        this.cntrAdjVolVOs  = cntrAdjVolVOs;
    }
    
    public CntrAdjVolVO[] getCntrAdjVolVOs() {
        return cntrAdjVolVOs;
    }

    /**
     * @param bkgCntrSealNoVOs the bkgCntrSealNoVOs to set
     */
    public void setBkgCntrSealNoVOs(BkgCntrSealNoVO[] bkgCntrSealNoVOs) {
        this.bkgCntrSealNoVOs = bkgCntrSealNoVOs;
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