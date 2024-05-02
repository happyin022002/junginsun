/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0201Event.java
*@FileTitle : Simulation No. Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.06 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0201 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0201HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0201HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0201Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RqstSimNoVO rqstSimNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RqstSimNoVO[] rqstSimNoVOs = null;

	public VopVsk0201Event(){}
	
	public void setRqstSimNoVO(RqstSimNoVO rqstSimNoVO){
		this. rqstSimNoVO = rqstSimNoVO;
	}

	public void setRqstSimNoVOS(RqstSimNoVO[] rqstSimNoVOs){
		if (rqstSimNoVOs != null) {
			RqstSimNoVO[] tmpVOs = Arrays.copyOf(rqstSimNoVOs, rqstSimNoVOs.length);
			this.rqstSimNoVOs = tmpVOs;
		} // end if
	}

	public RqstSimNoVO getRqstSimNoVO(){
		return rqstSimNoVO;
	}

	public RqstSimNoVO[] getRqstSimNoVOS(){
		RqstSimNoVO[] rtnVOs = null;
		if (this.rqstSimNoVOs != null) {
			rtnVOs = Arrays.copyOf(this.rqstSimNoVOs, this.rqstSimNoVOs.length);
		} // end if
		return rtnVOs;
	}

}