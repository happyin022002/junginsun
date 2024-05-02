/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropVO.java
*@FileTitle : RsltPropVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.04.16 변영주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

import java.io.Serializable;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class RsltPropListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<RsltPropMnVO> RsltPropMnVOs = null;
	private List<RsltPropMnScpListVO> RsltPropMnScpListVOs = null;	
	
	public List<RsltPropMnVO> getRsltPropMnVOs() {
		return RsltPropMnVOs;
	}
	public void setRsltPropMnVOs(List<RsltPropMnVO> list) {
		this.RsltPropMnVOs = list;
	}
	public List<RsltPropMnScpListVO> getRsltPropMnScpListVOs() {
		return RsltPropMnScpListVOs;
	}
	public void setRsltPropMnScpListVOs(List<RsltPropMnScpListVO> RsltPropMnScpListVOs) {
		this.RsltPropMnScpListVOs = RsltPropMnScpListVOs;
	}

	

	
	
}
