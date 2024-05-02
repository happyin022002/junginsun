/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs3009Event.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederDgCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederReeferCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3009Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String inOfcCd = "";
	private String inCostTrfNo = "";
	private String inRhqCd = "";
	private String inBtnSts = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FeederCostTariffInfoVO feederCostTariffInfoVO = null;
	private FeederCostVO feederCostVO = null;
	private FeederCostSpecialCargoVO feederCostSpecialCargoVO = null;
	private SearchFeederDgCostVO searchFeederDgCostVO = null;
	private SearchFeederReeferCostVO searchFeederReeferCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FeederCostVO[] feederCostVOs = null;
	private FeederCostSpecialCargoVO[] feederCostSpecialCargoVOs = null;
	private SearchFeederDgCostVO[] searchFeederDgCostVOs = null;
	private SearchFeederReeferCostVO[] searchFeederReeferCostVOs = null;
	
	public EsdTrs3009Event(){}
	
	/* FeederCostTariffInfoVO - start */
	public void setFeederCostTariffInfoVO(FeederCostTariffInfoVO feederCostTariffInfoVO){
		this. feederCostTariffInfoVO = feederCostTariffInfoVO;
	}
	
	public FeederCostTariffInfoVO getFeederCostTariffInfoVO(){
		return feederCostTariffInfoVO;
	}
	/* FeederCostTariffInfoVO - end */
	
	/* FeederCostVO - start */
	public void setFeederCostVO(FeederCostVO feederCostVO){
		this. feederCostVO = feederCostVO;
	}

	public void setFeederCostVOS(FeederCostVO[] feederCostVOs){
		this. feederCostVOs = feederCostVOs;
	}

	public FeederCostVO getFeederCostVO(){
		return feederCostVO;
	}

	public FeederCostVO[] getFeederCostVOS(){
		return feederCostVOs;
	}
	/* FeederCostVO - end */
	
	/* FeederCostSpecialCargoVO - start */
	public void setFeederCostSpecialCargoVO(FeederCostSpecialCargoVO feederCostSpecialCargoVO){
		this. feederCostSpecialCargoVO = feederCostSpecialCargoVO;
	}

	public void setFeederCostSpecialCargoVOS(FeederCostSpecialCargoVO[] feederCostSpecialCargoVOs){
		this. feederCostSpecialCargoVOs = feederCostSpecialCargoVOs;
	}

	public FeederCostSpecialCargoVO getFeederCostSpecialCargoVO(){
		return feederCostSpecialCargoVO;
	}

	public FeederCostSpecialCargoVO[] getFeederCostSpecialCargoVOS(){
		return feederCostSpecialCargoVOs;
	}
	/* FeederCostSpecialCargoVO - end */


    public SearchFeederDgCostVO getSearchFeederDgCostVO() {
		return searchFeederDgCostVO;
	}

	public void setSearchFeederDgCostVO(SearchFeederDgCostVO searchFeederDgCostVO) {
		this.searchFeederDgCostVO = searchFeederDgCostVO;
	}

	public SearchFeederReeferCostVO getSearchFeederReeferCostVO() {
		return searchFeederReeferCostVO;
	}

	public void setSearchFeederReeferCostVO(
			SearchFeederReeferCostVO searchFeederReeferCostVO) {
		this.searchFeederReeferCostVO = searchFeederReeferCostVO;
	}

	public SearchFeederDgCostVO[] getSearchFeederDgCostVOs() {
		return searchFeederDgCostVOs;
	}

	public void setSearchFeederDgCostVOs(
			SearchFeederDgCostVO[] searchFeederDgCostVOs) {
		this.searchFeederDgCostVOs = searchFeederDgCostVOs;
	}

	public SearchFeederReeferCostVO[] getSearchFeederReeferCostVOs() {
		return searchFeederReeferCostVOs;
	}

	public void setSearchFeederReeferCostVOs(
			SearchFeederReeferCostVO[] searchFeederReeferCostVOs) {
		this.searchFeederReeferCostVOs = searchFeederReeferCostVOs;
	}
	
	/**
	 * @return the inOfcCd
	 */
	public String getInOfcCd() {
		return inOfcCd;
	}

	/**
     * @return the inCostTrfNo
     */
    public String getInCostTrfNo() {
        return inCostTrfNo;
    }

    /**
     * @return the inRhqCd
     */
    public String getInRhqCd() {
        return inRhqCd;
    }

    /**
     * @return the inBtnSts
     */
    public String getInBtnSts() {
        return inBtnSts;
    }
    
    /**
     * @param ofcCd the inOfcCd to set
     */
    public void setInOfcCd(String ofcCd) {
        inOfcCd = ofcCd;
    }

    /**
     * @param costTrfNo the inCostTrfNo to set
     */
    public void setInCostTrfNo(String costTrfNo) {
    	inCostTrfNo = costTrfNo;
    }
	
    /**
     * @param rhqCd the inRhqCd to set
     */
    public void setInRhqCd(String rhqCd) {
    	inRhqCd = rhqCd;
    }    
    
    /**
     * @param btnSts the inBtnSts to set
     */
    public void setInBtnSts(String btnSts) {
    	inBtnSts = btnSts;
    }
}
