/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0697Event.java
*@FileTitle : Multi-Seal no input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.18 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0697 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0697HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0697HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0697Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;

    private String bkgNo = null;
    private String bkgNoSplit = null;
    private String cntrNo = null;

	public EsmBkg0697Event(){}

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
     * @return
     */
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
     *
     * @return
     */
    public String getCntrNo() {
        return cntrNo;
    }

    /**
     *
     * @return
     */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
     *
     * @return
     */
    public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

    /**
     *
     * @return
     */
	public void setBkgBlNoVOS(BkgBlNoVO[] bkgBlNoVOs){
		this. bkgBlNoVOs = bkgBlNoVOs;
	}

	   /**
     *
     * @return
     */
	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	   /**
     *
     * @return
     */
	public BkgBlNoVO[] getBkgBlNoVOS(){
		return bkgBlNoVOs;
	}

}