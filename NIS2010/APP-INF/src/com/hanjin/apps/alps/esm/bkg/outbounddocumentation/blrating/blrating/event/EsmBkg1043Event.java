/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1043Event.java
*@FileTitle : Container Rate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.04 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_1043HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1043Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrRtOutVO cntrRtVO = null;
	private CntrRtOutVO[] cntrRtVOs = null;

	private String bkgNo = null;
	private String blNo = null;
    
	public EsmBkg1043Event(){}
	
    
    /**
     * @return the cntrRtVO
     */
    public CntrRtOutVO getCntrRtOutVO() {
        return cntrRtVO;
    }

    
    /**
     * @param cntrRtVO the cntrRtVO to set
     */
    public void setCntrRtOutVO(CntrRtOutVO cntrRtVO) {
        this.cntrRtVO = cntrRtVO;
    }

    
    /**
     * @return the cntrRtVOs
     */
    public CntrRtOutVO[] getCntrRtOutVOs() {
		CntrRtOutVO[] rtnVOs = null;
		if (this.cntrRtVOs != null) {
			rtnVOs = Arrays.copyOf(cntrRtVOs, cntrRtVOs.length);
		}
		return rtnVOs;
    }

    
    /**
     * @param cntrRtVOs the cntrRtVOs to set
     */
    public void setCntrRtOutVOs(CntrRtOutVO[] cntrRtVOs){
		if(cntrRtVOs != null){
			CntrRtOutVO[] tmpVOs = Arrays.copyOf(cntrRtVOs, cntrRtVOs.length);
			this.cntrRtVOs = tmpVOs;
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

}