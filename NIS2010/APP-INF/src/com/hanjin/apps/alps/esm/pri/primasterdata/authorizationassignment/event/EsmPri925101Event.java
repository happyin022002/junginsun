/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmPri925101Event.java
 *@FileTitle : RFA Auth Hardcoding Management (Retro) - Office Level
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.09.02
 *@LastModifier : Min-Gyung Lee
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthAproVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_9251_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_9251_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min-Gyung Lee
 * @see ESM_PRI_9251_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri925101Event extends EventSupport {

	
private static final long serialVersionUID = 1L;



/** RsltAuthAproVO 조회 조건 및 단건 처리  */
private RsltAuthAproVO rsltAuthAproVO = null;

/** RsltAuthAproVO Multi Data 처리 */
private RsltAuthAproVO[] rsltAuthAproVOS = null;

/** RsltAuthAproVO 조회 조건 및 단건 처리  */
private RsltAuthHisVO rsltAuthHisVO = null;

/** RsltAuthAproVO Multi Data 처리 */
private RsltAuthHisVO[] rsltAuthHisVOS = null;	


public void setRsltAuthAproVO(RsltAuthAproVO rsltAuthAproVO){
	this.rsltAuthAproVO = rsltAuthAproVO;
}

public void setRsltAuthAproVOS(RsltAuthAproVO[] rsltAuthAproVOS){
	if(rsltAuthAproVOS != null){
		RsltAuthAproVO[] tmpVOs = new RsltAuthAproVO[rsltAuthAproVOS.length];
		System.arraycopy(rsltAuthAproVOS, 0, tmpVOs, 0, tmpVOs.length);
		this.rsltAuthAproVOS = tmpVOs;
	}
}


public RsltAuthAproVO getRsltAuthAproVO(){
	return rsltAuthAproVO;
}

public RsltAuthAproVO[] getRsltAuthAproVOS(){
	RsltAuthAproVO[] rtnVOs = null;
	if (this.rsltAuthAproVOS != null) {
		rtnVOs = new RsltAuthAproVO[rsltAuthAproVOS.length];
		System.arraycopy(rsltAuthAproVOS, 0, rtnVOs, 0, rtnVOs.length);
	}
	return rtnVOs;
}






public void setRsltAuthHisVO(RsltAuthHisVO rsltAuthHisVO){
	this.rsltAuthHisVO = rsltAuthHisVO;
}

public void setRsltAuthHisVOS(RsltAuthHisVO[] rsltAuthHisVOS){
	if(rsltAuthHisVOS != null){
		RsltAuthHisVO[] tmpVOs = new RsltAuthHisVO[rsltAuthHisVOS.length];
		System.arraycopy(rsltAuthHisVOS, 0, tmpVOs, 0, tmpVOs.length);
		this.rsltAuthHisVOS = tmpVOs;
	}
}


public RsltAuthHisVO getRsltAuthHisVO(){
	return rsltAuthHisVO;
}

public RsltAuthHisVO[] getRsltAuthHisVOS(){
	RsltAuthHisVO[] rtnVOs = null;
	if (this.rsltAuthHisVOS != null) {
		rtnVOs = new RsltAuthHisVO[rsltAuthHisVOS.length];
		System.arraycopy(rsltAuthHisVOS, 0, rtnVOs, 0, rtnVOs.length);
	}
	return rtnVOs;
}
}