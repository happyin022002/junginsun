/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0178Event.java
*@FileTitle : C/M by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0178 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0178HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0178HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0178Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	                
	private CmByCntrVO cmByCntrVO = null;
	
    private String cntrNo = null;
    private String tVvd = null;

	public EsmBkg0178Event(){}

	/**
	 * 
	 * @param cmByCntrVO
	 */
    public void setCmByCntrVO(CmByCntrVO cmByCntrVO) {
        this.cmByCntrVO = cmByCntrVO;
    }

    /**
     * 
     * @return
     */
    public CmByCntrVO getCmByCntrVO() {
        return cmByCntrVO;
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

}