/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0062Event.java
*@FileTitle : FNS_JOO_0062
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.12 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvoiceCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.TextNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;


/**
 * FNS_JOO_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0062HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private String ofccd = "";
    private String flag = "";   
    private String textno = "";
    private String jocrrcd = "";	
 
    private TextNoVO textNoVO = null;
    private TextNoVO[] textNoVOs = null;
    
    private LetterVO letterVO = null;
    private LetterVO[] letterVOs = null;
    
    
    private InvoiceCombinedVO invoiceCombinedVO = null;
    private InvoiceCombinedVO[] invoiceCombinedVOs = null;
    
    /**
     * @return the ofccd
     */
    public String getOfccd() {
        return ofccd;
    }

    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @return the textno
     */
    public String getTextno() {
        return textno;
    }

    /**
     * @return the jocrrcd
     */
    public String getJocrrcd() {
        return jocrrcd;
    }

 
    /**
     * @param ofccd the ofccd to set
     */
    public void setOfccd(String ofccd) {
        this.ofccd = ofccd;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @param textno the textno to set
     */
    public void setTextno(String textno) {
        this.textno = textno;
    }

    /**
     * @param jocrrcd the jocrrcd to set
     */
    public void setJocrrcd(String jocrrcd) {
        this.jocrrcd = jocrrcd;
    }

    /**
     * @return the invoiceCombinedVO
     */
    public InvoiceCombinedVO getInvoiceCombinedVO() {
        return invoiceCombinedVO;
    }

    /**
     * @return the invoiceCombinedVOs
     */
    public InvoiceCombinedVO[] getInvoiceCombinedVOs() {
        InvoiceCombinedVO[] rtnVOs = null;
		if (this.invoiceCombinedVOs != null) {
			rtnVOs = new InvoiceCombinedVO[invoiceCombinedVOs.length];
			System.arraycopy(invoiceCombinedVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }

    /**
     * @param invoiceCombinedVO the invoiceCombinedVO to set
     */
    public void setInvoiceCombinedVO(InvoiceCombinedVO invoiceCombinedVO) {
        this.invoiceCombinedVO = invoiceCombinedVO;
    }

    /**
     * @param invoiceCombinedVOs the invoiceCombinedVOs to set
     */
    public void setInvoiceCombinedVOs(InvoiceCombinedVO[] invoiceCombinedVOs) {
		if (invoiceCombinedVOs != null) {
			InvoiceCombinedVO[] tmpVOs = new InvoiceCombinedVO[invoiceCombinedVOs.length];
			System.arraycopy(invoiceCombinedVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceCombinedVOs = tmpVOs;
		}        
    }

    /**
     * @return the textNoVO
     */
    public TextNoVO getTextNoVO() {
        return textNoVO;
    }

    /**
     * @return the textNoVOs
     */
    public TextNoVO[] getTextNoVOs() {
        TextNoVO[] rtnVOs = null;
		if (this.textNoVOs != null) {
			rtnVOs = new TextNoVO[textNoVOs.length];
			System.arraycopy(textNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
        
    }

    /**
     * @return the letterVO
     */
    public LetterVO getLetterVO() {
        return letterVO;
    }

    /**
     * @return the letterVOs
     */
    public LetterVO[] getLetterVOs() {
        LetterVO[] rtnVOs = null;
		if (this.letterVOs != null) {
			rtnVOs = new LetterVO[letterVOs.length];
			System.arraycopy(letterVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }

    /**
     * @param textNoVO the textNoVO to set
     */
    public void setTextNoVO(TextNoVO textNoVO) {
        this.textNoVO = textNoVO;
    }

    /**
     * @param textNoVOs the textNoVOs to set
     */
    public void setTextNoVOs(TextNoVO[] textNoVOs) {
		if (textNoVOs != null) {
			TextNoVO[] tmpVOs = new TextNoVO[textNoVOs.length];
			System.arraycopy(textNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.textNoVOs = tmpVOs;
		}        
    }

    /**
     * @param letterVO the letterVO to set
     */
    public void setLetterVO(LetterVO letterVO) {
        this.letterVO = letterVO;
    }

    /**
     * @param letterVOs the letterVOs to set
     */
    public void setLetterVOs(LetterVO[] letterVOs) {
		if (letterVOs != null) {
			LetterVO[] tmpVOs = new LetterVO[letterVOs.length];
			System.arraycopy(letterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.letterVOs = tmpVOs;
		}        
        
    }
 
}