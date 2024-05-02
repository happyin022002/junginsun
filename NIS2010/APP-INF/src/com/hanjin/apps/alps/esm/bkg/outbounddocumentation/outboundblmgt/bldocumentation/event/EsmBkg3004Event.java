/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg3004Event.java
*@FileTitle : BKG Interface Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_3004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_3004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0079_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg3004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgIfManageInVO bkgIfManageInVO = null;
	private BkgIfManageInVO[] bkgIfManageInVOs;
	private BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO = null;
	private BkgIfManagerEdiInputVO[] bkgIfManagerEdiInputVOs;
	private BkgIfManagerEdiVO bkgIfManagerEdiVO = null;
	private BkgIfManagerEdiVO[] bkgIfManagerEdiVOs;
	private CustTpIdVO[] custTpIdVOs = null;
	
	private BkgBlNoVO[] bkgBlNoVOs = null;
	

    private String bkgNo = null;
    private String blNo = null;
    private String cntrNo = null;
	private String typeGbn = null;


    public EsmBkg3004Event(){}

    /**
     * @return the bkgIfMangeInVO
     */
    public BkgIfManageInVO getBkgIfManageInVO() {
        return bkgIfManageInVO;
    }

    /**
     * @param bkgIfMangeInVO the bkgIfMangeInVO to set
     */
    public void setBkgIfManageInVO(BkgIfManageInVO bkgIfManageInVO) {
        this.bkgIfManageInVO = bkgIfManageInVO;
    }
    
    /**
     * @return the bkgIfMangeInVO
     */
    public BkgIfManageInVO[] getBkgIfManageInVOs() {
        return bkgIfManageInVOs;
    }

    /**
     * @param bkgIfMangeInVO the bkgIfMangeInVO to set
     */
    public void setBkgIfManageInVOs(BkgIfManageInVO[] bkgIfManageInVOs) {
        this.bkgIfManageInVOs = bkgIfManageInVOs;
    }
    
    
    /**
     * @return the bkgIfManagerEdiInputVO
     */
    public BkgIfManagerEdiInputVO getBkgIfManagerEdiInputVO() {
        return bkgIfManagerEdiInputVO;
    }

    /**
     * @param BkgIfManagerEdiInputVO the BkgIfManagerEdiInputVO to set
     */
    public void setBkgIfManagerEdiInputVO(BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO) {
        this.bkgIfManagerEdiInputVO = bkgIfManagerEdiInputVO;
    }
    
    /**
     * @return the BkgIfManagerEdiInputVO
     */
    public BkgIfManagerEdiInputVO[] getBkgIfManagerEdiInputVOs() {
        return bkgIfManagerEdiInputVOs;
    }

    /**
     * @param BkgIfManagerEdiInputVO the BkgIfManagerEdiInputVO to set
     */
    public void setBkgIfManagerEdiInputVOs(BkgIfManagerEdiInputVO[] bkgIfManagerEdiInputVOs) {
        this.bkgIfManagerEdiInputVOs = bkgIfManagerEdiInputVOs;
    }
    
    /**
     * @return the BkgIfManagerEdiVO
     */
    public BkgIfManagerEdiVO getBkgIfManagerEdiVO() {
        return bkgIfManagerEdiVO;
    }

    /**
     * @param BkgIfManagerEdiVO the BkgIfManagerEdiVO to set
     */
    public void setBkgIfManagerEdiVO(BkgIfManagerEdiVO bkgIfManagerEdiVO) {
        this.bkgIfManagerEdiVO = bkgIfManagerEdiVO;
    }
    
    /**
     * @return the BkgIfManagerEdiVO
     */
    public BkgIfManagerEdiVO[] getBkgIfManagerEdiVOs() {
        return bkgIfManagerEdiVOs;
    }

    /**
     * @param BkgIfManagerEdiVO the BkgIfManagerEdiVO to set
     */
    public void setBkgIfManagerEdiVOs(BkgIfManagerEdiVO[] bkgIfManagerEdiVOs) {
        this.bkgIfManagerEdiVOs = bkgIfManagerEdiVOs;
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
     * @return the typeGbn
     */
    public String getTypeGbn() {
        return typeGbn;
    }

    /**
     * @param typeGbn the typeGbn to set
     */
    public void setTypeGbn(String typeGbn) {
        this.typeGbn = typeGbn;
    }
    
	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}
	
	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}
	
	public CustTpIdVO[] getCustTpIdVOs() {
		return custTpIdVOs;
	}

	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs) {
		this.custTpIdVOs = custTpIdVOs;
	}
}