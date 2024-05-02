/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : EsmPri9451Event.java
*@FileTitle :  Retroactive RFA Approval Auth - Office Level (History)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : Min-Gyung Lee
*@LastVersion : 1.0
* 2016-09-02 Min-Gyung Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event;


import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsmPri9451Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Min-Gyung Lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsmPri9451Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;


/** RsltAuthHisVO 조회 조건 및 단건 처리  */
private RsltAuthHisVO rsltAuthHisVO = null;


public RsltAuthHisVO getRsltAuthHisVO() {
	return rsltAuthHisVO;
}


public void setRsltAuthHisVO(RsltAuthHisVO rsltAuthHisVO) {
	this.rsltAuthHisVO = rsltAuthHisVO;
}



}
