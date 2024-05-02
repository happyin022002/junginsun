/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce001Event.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 1.0
* 2008-03-03 minestar
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.cophsitory.event;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * EsdSce0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author minestar
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0071Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
    private RequestDataSetBC dataSet = null;
    COPInquiryVO conditionVO = null;	
	/**
     * 생성자
     */
	public EsdSce0071Event(){}
	
	/**
     * 생성자<br>
     * 
     * @param dataSet jsp에서 넘어온 parameter를 저장한 data set
     */
    public EsdSce0071Event(RequestDataSetBC dataSet) {
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
     * 이벤트 명(EsdSce0071Event)을 반환
     * 
     * @return EsdSce0071Event
     */
    public String getEventName() {
        return "EsdSce0071Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0071Event)을 반환
     * 
     * @return String EsdSce0071Event
     */
    public String toString() {
        return "EsdSce0071Event";
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
