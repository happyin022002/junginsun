/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DblWblOutVO.java
*@FileTitle : DblWblOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.09 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Container Value Object<br>
 * - 조회결과를 전송하는 Container VO<br>
 *
 * @author 박준용
 * @since J2EE 1.5
 */

public class DblWblOutVO implements java.io.Serializable {

	private static final long serialVersionUID = 3067716341665794766L;

	List<DblWblVO> dblWbls = new ArrayList<DblWblVO>();
	List<DblWblCntVO> dblWblCnts = new ArrayList<DblWblCntVO>();

	public List<DblWblCntVO> getDblWblCnts() {
		return dblWblCnts;
	}

	public void setDblWblCnts(List<DblWblCntVO> dblWblCnts) {
		this.dblWblCnts = dblWblCnts;
	}

	public List<DblWblVO> getDblWbls() {
		return dblWbls;
	}

	public void setDblWbls(List<DblWblVO> dblWbls) {
		this.dblWbls = dblWbls;
	}
	
}
