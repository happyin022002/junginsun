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

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.framework.support.layer.event.EventSupport;

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
    
    private String tVvd = null;
    private String polCd = null;
	private String key = null;

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
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}


    
}