/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpBlPrtOutVO.java
*@FileTitle : GrpBlPrtOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.05.12 박준용
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

public class GrpBlPrtOutVO {

	List<GrpBlPrtVO> grpBlPrts = new ArrayList<GrpBlPrtVO>();

	/** Table Value Object 조회 조건 및 단건 처리  */

	public List<GrpBlPrtVO> getGrpBlPrts() {
		return grpBlPrts;
	}

	public void setGrpBlPrts(List<GrpBlPrtVO> grpBlPrts) {
		this.grpBlPrts = grpBlPrts;
	}

}