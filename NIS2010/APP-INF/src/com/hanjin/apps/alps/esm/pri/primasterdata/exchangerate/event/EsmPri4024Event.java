/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4024Event.java
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.24 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.CstGlMonXchRtVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGlMonXchRtVO rsltGlMonXchRtVO = null;
	private CstGlMonXchRtVO cstGlMonXchRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltGlMonXchRtVO[] rsltGlMonXchRtVOs = null;
	private CstGlMonXchRtVO[] cstGlMonXchRtVOs = null;
	
	public EsmPri4024Event(){}
	
	public void setRsltGlMonXchRtVO(RsltGlMonXchRtVO rsltGlMonXchRtVO){
		this. rsltGlMonXchRtVO = rsltGlMonXchRtVO;
	}

	public void setRsltGlMonXchRtVOS(RsltGlMonXchRtVO[] rsltGlMonXchRtVOs){
		if(rsltGlMonXchRtVOs != null){
			RsltGlMonXchRtVO[] tmpVOs = new RsltGlMonXchRtVO[rsltGlMonXchRtVOs.length];
			System.arraycopy(rsltGlMonXchRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGlMonXchRtVOs = tmpVOs;
		}
	}

	public RsltGlMonXchRtVO getRsltGlMonXchRtVO(){
		return rsltGlMonXchRtVO;
	}

	public RsltGlMonXchRtVO[] getRsltGlMonXchRtVOS(){
		RsltGlMonXchRtVO[] rtnVOs = null;
		if (this.rsltGlMonXchRtVOs != null) {
			rtnVOs = new RsltGlMonXchRtVO[rsltGlMonXchRtVOs.length];
			System.arraycopy(rsltGlMonXchRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCstGlMonXchRtVO(CstGlMonXchRtVO cstGlMonXchRtVO){
		this. cstGlMonXchRtVO = cstGlMonXchRtVO;
	}

	public void setCstGlMonXchRtVOS(CstGlMonXchRtVO[] cstGlMonXchRtVOs){
		if(cstGlMonXchRtVOs != null){
			CstGlMonXchRtVO[] tmpVOs = new CstGlMonXchRtVO[cstGlMonXchRtVOs.length];
			System.arraycopy(cstGlMonXchRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstGlMonXchRtVOs = tmpVOs;
		}
	}

	public CstGlMonXchRtVO getCstGlMonXchRtVO(){
		return cstGlMonXchRtVO;
	}

	public CstGlMonXchRtVO[] getCstGlMonXchRtVOS(){
		CstGlMonXchRtVO[] rtnVOs = null;
		if (this.cstGlMonXchRtVOs != null) {
			rtnVOs = new CstGlMonXchRtVO[cstGlMonXchRtVOs.length];
			System.arraycopy(cstGlMonXchRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
}