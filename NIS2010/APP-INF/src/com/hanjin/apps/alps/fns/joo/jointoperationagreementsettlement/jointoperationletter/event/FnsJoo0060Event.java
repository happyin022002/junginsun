/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0060Event.java
*@FileTitle : MCS Letter Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.TextNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0060HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private String ofccd = "";
    private String flag = "";   
    private String textno = "";
    private String jocrrcd = "";
    private String joltrseq = "";
    
	private TextNoVO textNoVO = null;
	private TextNoVO[] textNoVOs = null;

    private McsLetterVO mcsLetterVO = null;
    private McsLetterVO[] mcsLetterVOs = null;
	
    private LetterVO letterVO = null;
    private LetterVO[] letterVOs = null;
    
    private McsCombinedVO mcsCombinedVO = null;
    
	public FnsJoo0060Event(){}
	
	public void setTextNoVO(TextNoVO textNoVO){
		this. textNoVO = textNoVO;
	}

	public void setTextNoVOS(TextNoVO[] textNoVOs){
		if (textNoVOs != null) {
			TextNoVO[] tmpVOs = new TextNoVO[textNoVOs.length];
			System.arraycopy(textNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.textNoVOs = tmpVOs;
		}		
	}

	public TextNoVO getTextNoVO(){
		return textNoVO;
	}

	public TextNoVO[] getTextNoVOS(){
		TextNoVO[] rtnVOs = null;
		if (this.textNoVOs != null) {
			rtnVOs = new TextNoVO[textNoVOs.length];
			System.arraycopy(textNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

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
     * @return the mcsLetterVO
     */
    public McsLetterVO getMcsLetterVO() {
        return mcsLetterVO;
    }

    /**
     * @return the mcsLetterVOs
     */
    public McsLetterVO[] getMcsLetterVOs() {
        McsLetterVO[] rtnVOs = null;
		if (this.mcsLetterVOs != null) {
			rtnVOs = new McsLetterVO[mcsLetterVOs.length];
			System.arraycopy(mcsLetterVOs, 0, rtnVOs, 0, rtnVOs.length);
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
     * @param mcsLetterVO the mcsLetterVO to set
     */
    public void setMcsLetterVO(McsLetterVO mcsLetterVO) {
        this.mcsLetterVO = mcsLetterVO;
    }

    /**
     * @param mcsLetterVOs the mcsLetterVOs to set
     */
    public void setMcsLetterVOs(McsLetterVO[] mcsLetterVOs) {
		if (mcsLetterVOs != null) {
			McsLetterVO[] tmpVOs = new McsLetterVO[mcsLetterVOs.length];
			System.arraycopy(mcsLetterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mcsLetterVOs = tmpVOs;
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

    /**
     * @return the textno
     */
    public String getTextno() {
        return textno;
    }

    /**
     * @param textno the textno to set
     */
    public void setTextno(String textno) {
        this.textno = textno;
    }

    /**
     * @return the mcsCombinedVO
     */
    public McsCombinedVO getMcsCombinedVO() {
        return mcsCombinedVO;
    }

    /**
     * @param mcsCombinedVO the mcsCombinedVO to set
     */
    public void setMcsCombinedVO(McsCombinedVO mcsCombinedVO) {
        this.mcsCombinedVO = mcsCombinedVO;
    }

    /**
     * @return the jocrrcd
     */
    public String getJocrrcd() {
        return jocrrcd;
    }

    /**
     * @param jocrrcd the jocrrcd to set
     */
    public void setJocrrcd(String jocrrcd) {
        this.jocrrcd = jocrrcd;
    }

    /**
     * @return the joltrseq
     */
    public String getjoltrseq() {
        return joltrseq;
    }

    /**
     * @param joltrseq the joltrseq to set
     */
    public void setjoltrseq(String joltrseq) {
        this.joltrseq = joltrseq;
    }

}