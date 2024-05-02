/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg007906Event.java
 *@FileTitle : Marks & Number/Description of Goods
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.28 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0079_06 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0079_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0079_06HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg007906Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private MndVO             mndVO            = null;
    private MndVO[]           mndVOS           = null;
    private String            bkgNo            = null;
    private String            bkgNoSplit       = null;
    private String            blNo             = null;
    private String            blTpCd           = null;
    private String            pckTpCd        = null;

    public EsmBkg007906Event() {}

    /**
     *
     * @param mndVO
     */
    public void setMndVO(MndVO mndVO) {
        this.mndVO = mndVO;
    }


    /**
     *
     * @return
     */
    public MndVO getMndVO() {
        return mndVO;
    }


    public MndVO[] getMndVOS() {
    	MndVO[] rtnVOs = null;
		if (this.mndVOS != null) {
			rtnVOs = Arrays.copyOf(mndVOS, mndVOS.length);
		}
		return rtnVOs;
	}

	public void setMndVOS(MndVO[] mndVOS) {
		if (mndVOS != null) {
			MndVO[] tmpVOs = Arrays.copyOf(mndVOS, mndVOS.length);
			this.mndVOS = tmpVOs;
		}
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
     * @param bkgNo
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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
     * @param bkgNoSplit
     */
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
     *
     * @return
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     *
     * @param blNo
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
     * @param blTpCd
     */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }


    /**
     * @return the pck_tp_cd
     */
    public String getPckTpCd() {
        return pckTpCd;
    }


    /**
     * @param pck_tp_cd the pck_tp_cd to set
     */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

}