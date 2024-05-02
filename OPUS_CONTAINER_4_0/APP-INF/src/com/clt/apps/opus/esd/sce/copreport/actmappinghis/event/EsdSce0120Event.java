/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0120Event.java
*@FileTitle : Actual Mapping History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.actmappinghis.event;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.vo.SearchActMappingHisVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * EsdSce0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김성일
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0120Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
    private RequestDataSetBC dataSet = null;
    SearchActMappingHisVO searchActMappingHisVO = null;	
	/**
     * 생성자
     */
	public EsdSce0120Event(){}
	
	/**
     * 생성자<br>
     * 
     * @param dataSet jsp에서 넘어온 parameter를 저장한 data set
     */
    public EsdSce0120Event(RequestDataSetBC dataSet) {
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
     * 이벤트 명(EsdSce0120Event)을 반환
     * 
     * @return EsdSce0120Event
     */
    public String getEventName() {
        return "EsdSce0120Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0120Event)을 반환
     * 
     * @return String EsdSce0120Event
     */
    public String toString() {
        return "EsdSce0120Event";
    }
    
	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setConditionVO(SearchActMappingHisVO searchActMappingHisVO){
		this.searchActMappingHisVO = searchActMappingHisVO;
	}
	
	/**
	 * 조회조건 반환
	 * @return
	 */
	public SearchActMappingHisVO getSearchActMappingHisVO(){
		return searchActMappingHisVO;
	} 
}
