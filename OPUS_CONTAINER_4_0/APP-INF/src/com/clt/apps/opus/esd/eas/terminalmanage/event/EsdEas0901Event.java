/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0901Event.java
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-22
*@LastModifier : Yaini
*@LastVersion : 1.0
* 2008-11-24 Yaini
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.event;

import java.util.Collection;

import com.clt.apps.opus.esd.eas.common.util.RequestDataSet;
import com.clt.apps.opus.esd.eas.terminalmanage.vo.TrsExpnAudRmkVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0901Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author Yaini
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0901Event extends EventSupport {
	
	String bkgNo = "";
	String expnTpCd = "";
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setExpnTpCd(String expnTpCd) {
		this.expnTpCd = expnTpCd;
	}	
	
    public String getExpnTpCd() {
		return expnTpCd;
	}	
	
	TrsExpnAudRmkVO[] trsExpnAudRmkVOs 					= null;
	private TrsExpnAudRmkVO trsExpnAudRmkVO = null;
	
	
	/**
	 * @return the trsExpnAudRmkVOs
	 */
	public TrsExpnAudRmkVO[] getTrsExpnAudRmkVOs() {
		return trsExpnAudRmkVOs;
	}
	/**
	 * @param trsExpnAudRmkVOs the trsExpnAudRmkVOs to set
	 */
	public void setTrsExpnAudRmkVOs(TrsExpnAudRmkVO[] trsExpnAudRmkVOs) {
		this.trsExpnAudRmkVOs = trsExpnAudRmkVOs;
	}
	
	/**
	 * @return the trsExpnAudRmkVO
	 */
	public TrsExpnAudRmkVO getTrsExpnAudRmkVO() {
		return trsExpnAudRmkVO;
	}

	/**
	 * @param trsExpnAudRmkVO the trsExpnAudRmkVO to set
	 */
	public void setTrsExpnAudRmkVO(TrsExpnAudRmkVO trsExpnAudRmkVO) {
		this.trsExpnAudRmkVO = trsExpnAudRmkVO;
	}
	
	

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
	private RequestDataSet dataSet = null;
	private Collection easRoutunmat = null;

		
	
	/**
	 * ESD_EAS_002Event에서 SCE_COP_HDR 데이터 타입의 매개변수
	 * @param eas_routunmat 
	 */
	public void setROUunmat(Collection eas_routunmat) {
		this.easRoutunmat = eas_routunmat;
	}

	/**
	 * @return Returns eas_routunmat.
	 */

	public Collection getROUunmat() {
		return easRoutunmat;
	}

	/**
     * 생성자<br>
     */
    public EsdEas0901Event() {

    }

    /**
     * 생성자<br>
     *
     * @param dataSet jsp에서 넘어온 parameter를 저장한 data set
     */
    public EsdEas0901Event(RequestDataSet dataSet) {
        this.dataSet = dataSet;
    }

    /**
     * RequestDataSetBC를 리턴
     *
     * @return dataSet String
     */
    public RequestDataSet getDataSet(){
        return dataSet;
    }
    
    /**
     * 이벤트 명(ESD_EAS_0901Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "ESD_EAS_0901Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_0901Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "ESD_EAS_0901Event";
    }


}
