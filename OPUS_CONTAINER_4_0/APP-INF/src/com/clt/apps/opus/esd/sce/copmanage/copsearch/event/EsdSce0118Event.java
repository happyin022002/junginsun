/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0118Event.java
*@FileTitle : COP Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import java.util.HashMap;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0118 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0118 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author sanghyun_kim
 * @see COPManageSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("rawtypes")
public class EsdSce0118Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private HashMap parameterMap = null;

	private String cntrNo = "";
    COPInquiryVO conditionVO = null;
	/**
	 * @return Returns the cntrNo.
	 */
	public String getCntr_no() {
		return cntrNo;
	}

	/**
	 * @param cs_cd The cntrNo to set.
	 */
	public void setCntr_no(String cntrNo) {
		this.cntrNo = cntrNo;
	}

    /**
     * @return Returns the parameterMap.
     */
    public HashMap getParameterMap() {
        return parameterMap;
    }

	/**
	 * @param parameterMap The parameterMap to set.
	 */
	public void setParameterMap(HashMap parameterMap) {
		this.parameterMap = parameterMap;
	}
	/**
	 * @param parameterMap_
	 */
	public EsdSce0118Event(){

	}

	/**
	 * @param parameterMap_
	 */
	public EsdSce0118Event(HashMap parameterMap_){
		this.parameterMap = parameterMap_;
	}

	/**
     * Evenct Name 을 반환한다.
     * @return "EsdSce0118Event"
     */
    public String getEventName() {
        return "EsdSce0118Event";
    }
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @return "EsdSce0118Event"
     */
    public String toString() {
        return "EsdSce0118Event";
    }
	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setConditionVO(COPInquiryVO conditionVO){
		this.conditionVO = conditionVO;
	}
	/**
	 * 조회조건 반환
	 * @return
	 */
	public COPInquiryVO getConditionVO(){
		return conditionVO;
	}  
}
