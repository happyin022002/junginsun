/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0006Event.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-30 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0006Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
    private RequestDataSetBC dataSet = null;
    private String clickBtnNm = "";
    private String copNo = "";
    private COPDetailVO copDetailVO = null;
	private COPUpdateInfoVO copUpdateInfoVO = null;    
    /**
	 * @return Returns the copNo.
	 */
	public String getCopNo() {
		return copNo;
	}

	/**
	 * @param copNo The copNo to set.
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * @return Returns the clickBtnNm.
	 */
	public String getClickBtnNm() {
		return clickBtnNm;
	}

	/**
	 * @param clickBtnNm The clickBtnNm to set.
	 */
	public void setClickBtnNm(String clickBtnNm) {
		this.clickBtnNm = clickBtnNm;
	}

	/**
	 * @return Returns the clickBtnNm.
	 */
	public COPDetailVO getCOPDetailVO() {
		return copDetailVO;
	}

	/**
	 * @param copDetailVO The copDetailVO to set.
	 */
	public void setCOPDetailVO(COPDetailVO copDetailVO) {
		this.copDetailVO = copDetailVO;
	}
	
	/**
     * 생성자<br>
     */
    public EsdSce0006Event() {
    	
    }

    /**
     * 생성자<br>
     * 
     * @param dataSet jsp에서 넘어온 parameter를 저장한 data set
     */
    public EsdSce0006Event(RequestDataSetBC dataSet) {
        this.dataSet = dataSet;
    }

    /**
     * RequestDataSetBC를 리턴
     * 
     * @return dataSet String
     */
    public RequestDataSetBC getDataSet(){
        return dataSet;
    }

    /**
     * 이벤트 명(EsdSce0006Event)을 반환
     * 
     * @return response String
     */
    public String getEventName() {
        return "EsdSce0006Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0006Event)을 반환
     * 
     * @return response String
     */
    public String toString() {
        return "EsdSce0006Event";
    }

	public COPUpdateInfoVO getCOPUpdateInfoVO(){
		return copUpdateInfoVO;
	}
	public void setCOPUpdateInfoVO(COPUpdateInfoVO copUpdateInfoVO){
		this.copUpdateInfoVO = copUpdateInfoVO;
	}
	public void setCOPUpdateInfoVO(COPUpdateInfoVO copUpdateInfoVO, String userId){
		this.copUpdateInfoVO = copUpdateInfoVO;
		copUpdateInfoVO.setUserId(userId);
	}	    
}
