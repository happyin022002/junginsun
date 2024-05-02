/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : EsdSce0010Event.java
*@FileTitle : COP EST DATE/TIME 일괄 업데이트
*Open Issues :
*Change history :
*@LastModifyDate : 20006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 20006-10-02 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copupdate.event;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsdSce0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0010Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	RequestDataSetBC dataSet = null ;

	/**
	 * 생성자
	 *
	 */
	public EsdSce0010Event(){}
	
	/**
	 * 생성자
	 * 
	 * @param dataSet jsp에서 넘어온 parameter를 저장한 RequestDataSetBC
	 */
	public EsdSce0010Event(RequestDataSetBC dataSet){
		this.dataSet = dataSet ;
	}
	
	/**
	 * dataSet을 리턴
	 * 
	 * @return dataSet RequestDataSet
	 */
	public RequestDataSetBC getDataSet(){
		return this.dataSet ;
	}

	/**
     * 이벤트 명(EsdSce0010Event)을 반환
     * 
     * @return EsdSce0010Event
     */
	public String getEventName() {
		return "EsdSce0010Event";
	}

	
	/**
     * 객체 표현 문자열(EsdSce0010Event)을 반환
     * 
     * @return EsdSce0010Event
     */
	public String toString() {
		return "EsdSce0010Event";
	}

}
