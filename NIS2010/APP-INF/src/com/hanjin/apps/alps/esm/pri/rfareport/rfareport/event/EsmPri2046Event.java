/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2046Event.java
*@FileTitle : Retroactive RFA monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.24 최성환
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRpRetroInfoVO;

/**
 * ESM_PRI_2046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 최성환
 * @see ESM_PRI_2046HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltPriRpRetroInfoVO[] rsltPriRpRetroInfoVOs = null;

	public EsmPri2046Event(){}
	
	/* set */
	public void setRsltPriRpRetroInfoVO(RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO){
		this.rsltPriRpRetroInfoVO = rsltPriRpRetroInfoVO;
	}
	public void setRsltPriRpRetroInfoVOS(RsltPriRpRetroInfoVO[] rsltPriRpRetroInfoVOs){
		if(rsltPriRpRetroInfoVOs != null){
			RsltPriRpRetroInfoVO[] tmpVOs = new RsltPriRpRetroInfoVO[rsltPriRpRetroInfoVOs.length];
			System.arraycopy(rsltPriRpRetroInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRpRetroInfoVOs = tmpVOs;
		}
	}
	
	/* get */
	public RsltPriRpRetroInfoVO getRsltPriRpRetroInfoVO(){
		return rsltPriRpRetroInfoVO;
	}
	public RsltPriRpRetroInfoVO[] getRsltPriRpRetroInfoVOS(){
		RsltPriRpRetroInfoVO[] rtnVOs = null;
		if (this.rsltPriRpRetroInfoVOs != null) {
			rtnVOs = new RsltPriRpRetroInfoVO[rsltPriRpRetroInfoVOs.length];
			System.arraycopy(rsltPriRpRetroInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}