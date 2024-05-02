/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpNoteConvVO.java
*@FileTitle : GrpNoteConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.08 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo;

import java.io.Serializable;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpNoteConvVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PriRfaNoteConvVO[] priRfaNoteConvVOs = null;
	private PriRfaNoteConvCommVO priRfaNoteConvCommVO = null;
	
	public PriRfaNoteConvVO[] getPriRfaNoteConvVOs() {
		return priRfaNoteConvVOs;
	}	
	public void setPriRfaNoteConvVOs(PriRfaNoteConvVO[] priRfaNoteConvVOs) {
		this.priRfaNoteConvVOs = priRfaNoteConvVOs;
	}
	public PriRfaNoteConvCommVO getPriRfaNoteConvCommVO() {
		return priRfaNoteConvCommVO;
	}
	public void setPriRfaNoteConvCommVO(PriRfaNoteConvCommVO priRfaNoteConvCommVO) {
		this.priRfaNoteConvCommVO = priRfaNoteConvCommVO;
	}
	
	
}

