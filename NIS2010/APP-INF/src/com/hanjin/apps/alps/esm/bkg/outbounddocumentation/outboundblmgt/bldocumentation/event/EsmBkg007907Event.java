/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007907Event.java
*@FileTitle : C/M by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0079_07HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg007907Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CmVO cmVO = null;
	private CmVO[] cmVOs = null;

    private String bkgNo = null;
    private String bkgNoSplit = null;
    private String blNo = null;
    private String blTpCd = null;
    private String cntrNo = null;
    private String brzCmdtCd = null;


	public EsmBkg007907Event(){}


    /**
     *
     * @return
     */
    public String getBlNo() {
        return blNo;
    }



	/**
     *
     * @return
     */
    public String getBlTpCd() {
        return blTpCd;
    }

    /**
     *
     * @return
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     *
     * @return
     */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }

    /**
     *
     * @return
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     *
     * @return
     */
    public String getBkgNoSplit() {
        return bkgNoSplit;
    }

    /**
     *
     * @return
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     *
     * @return
     */
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
     *
     * @return
     */
    public String getCntrNo(){
        return cntrNo;
    }

    /**
     *
     * @param cntrNo
     */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
     * @return brzCmdtCd
     */
    public String getBrzCmdtCd() {
		return brzCmdtCd;
	}


	/**
	 * @param brzCmdtCd
	 */
	public void setBrzCmdtCd(String brzCmdtCd) {
		this.brzCmdtCd = brzCmdtCd;
	}
    /**
     *
     * @param cmVO
     */
	public void setCmVO(CmVO cmVO){
		this. cmVO = cmVO;
	}

	/**
	 *
	 * @param cmVOs
	 */
	public void setCmVOS(CmVO[] cmVOs){
		this. cmVOs = cmVOs;
	}

	/**
	 *
	 * @return
	 */
	public CmVO getCmVO(){
		return cmVO;
	}

	/**
	 *
	 * @return
	 */
	public CmVO[] getCmVOS(){
		return cmVOs;
	}

}