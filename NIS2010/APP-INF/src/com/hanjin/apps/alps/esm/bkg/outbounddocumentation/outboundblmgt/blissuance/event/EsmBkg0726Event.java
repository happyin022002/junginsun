/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0726Event.java
 *@FileTitle : Group Update for B/L Issue And Onboard Date
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.07.15 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0726 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0726HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_0726HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0726Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private GrpBlDtVO grpBlDtVO = null;
    private GrpBlDtListVO grpBlDtListVO = null;
    
    
    private String tVvd = null;
    private String polCd = null;
    
    private String hrdCdgId = null;
	private String attrCtnt1 = null;
	private String attrCtnt2 = null;
	private String attrCtnt3 = null;

    public EsmBkg0726Event() {}

    /**
     * @param grpBlDtVO the grpBlDtVO to set
     */
    public void setGrpBlDtVO(GrpBlDtVO grpBlDtVO) {
        this.grpBlDtVO = grpBlDtVO;
    }

    /**
     * @return the grpBlDtVO
     */
    public GrpBlDtVO getGrpBlDtVO() {
        return grpBlDtVO;
    }

    
    /**
     * @return the tVvd
     */
    public String getTVvd() {
        return tVvd;
    }

    
    /**
     * @param vvd the tVvd to set
     */
    public void setTVvd(String vvd) {
        tVvd = vvd;
    }

    
    /**
     * @return the polCd
     */
    public String getPolCd() {
        return polCd;
    }

    
    /**
     * @param polCd the polCd to set
     */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * @return hrdCdgId
	 */
	public String getHrdCdgId() {
		return hrdCdgId;
	}

	/**
	 * @param hrdCdgId the hrdCdgId to set
	 */
	public void setHrdCdgId(String hrdCdgId) {
		this.hrdCdgId = hrdCdgId;
	}

	/**
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return attrCtnt1;
	}

	/**
	 * @param attrCtnt1 the attrCtnt1 to set
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}

	/**
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return attrCtnt2;
	}

	/**
	 * @param attrCtnt2 the attrCtnt2 to set
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}

	/**
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return attrCtnt3;
	}

	/**
	 * @param attrCtnt3 the attrCtnt3 to set
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}

	/**
	 * @return the grpBlDtListVO
	 */
	public GrpBlDtListVO getGrpBlDtListVO() {
		return grpBlDtListVO;
	}

	/**
	 * @param grpBlDtListVO the grpBlDtListVO to set
	 */
	public void setGrpBlDtListVO(GrpBlDtListVO grpBlDtListVO) {
		this.grpBlDtListVO = grpBlDtListVO;
	}

}