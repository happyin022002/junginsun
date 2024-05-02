/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0000.jsp
*@FileTitle : BIS-B/L Information
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김태경
*@LastVersion : 1.0
*2010.01.22 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisManualListVO;



/**
 * ESM_BIS_0000 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BIS_0000HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BIS_0000HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBis0000Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BisManualListVO bisManualListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BisManualListVO[] bisManualListVOs = null;
	
	private String fromDt	= null;
	private String toDt 	= null;

	public EsmBis0000Event(){}
	
	public BisManualListVO getBisManualListVO(){
		return bisManualListVO;
	}
	public void setBisManualListVO(BisManualListVO bisManualListVO){
		this. bisManualListVO = bisManualListVO;
	}
	public BisManualListVO[] getBisManualListVOS(){
		return bisManualListVOs;
	}
	
	public void setBisManualListVOS(BisManualListVO[] bisManualListVOs){
		this. bisManualListVOs = bisManualListVOs;
	}
	public void setFromDt(String fromDt){
		this.fromDt = fromDt;
	}	
	public void setToDt(String toDt){
		this.toDt = toDt;
	}
	public String getFromDt(){
		return fromDt;
	}
	public String getToDt(){
		return toDt;
	}

}