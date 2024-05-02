/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0070VO.java
*@FileTitle : VopScg0070VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.20 김현욱 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpDtlVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김현욱
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class VopScg0070VO {

	private static final long serialVersionUID = 1L;
	
	/* VO Info */
	private List<ScgImdgSegrGrpVO> scgImdgSegrGrpl = null;
	private ScgImdgSegrGrpVO[] scgImdgSegrGrps = null;
	
	/* VO Info */
	private List<ScgImdgSegrGrpDtlVO> scgImdgSegrGrpDtll = null;
	private ScgImdgSegrGrpDtlVO[] scgImdgSegrGrpDtls = null;
	private ScgImdgSegrGrpDtlVO   scgImdgSegrGrpDtl = null;
	
	public VopScg0070VO() {}

	public VopScg0070VO(List<ScgImdgSegrGrpVO> scgImdgSegrGrpl, List<ScgImdgSegrGrpDtlVO> scgImdgSegrGrpDtll) {
		this.scgImdgSegrGrpl = scgImdgSegrGrpl;
		this.scgImdgSegrGrpDtll = scgImdgSegrGrpDtll;
	}
	
	public VopScg0070VO(ScgImdgSegrGrpVO[] scgImdgSegrGrps, ScgImdgSegrGrpDtlVO[] scgImdgSegrGrpDtls) {
		this.scgImdgSegrGrps = scgImdgSegrGrps;
		this.scgImdgSegrGrpDtls = scgImdgSegrGrpDtls;
	}
	
	/**
	 * VO Info
	 * @return scgImdgSegrGrpl
	 */
	public List<ScgImdgSegrGrpVO> getScgImdgSegrGrpVOL() {
		return this.scgImdgSegrGrpl;
	}
	
	/**
	 * VO Info
	 * @return scgImdgSegrGrpDtll
	 */
	public List<ScgImdgSegrGrpDtlVO> getScgImdgSegrGrpDtlVOL() {
		return this.scgImdgSegrGrpDtll;
	}
	
	/**
	 * VO Info
	 * @return scgImdgSegrGrps
	 */
	public ScgImdgSegrGrpVO[] getScgImdgSegrGrpVOS() {
		return this.scgImdgSegrGrps;
	}
	
	/**
	 * VO Info
	 * @return scgImdgSegrGrpDtls
	 */
	public ScgImdgSegrGrpDtlVO[] getScgImdgSegrGrpDtlVOS() {
		return this.scgImdgSegrGrpDtls;
	}
	
	/**
	 * VO Info
	 * @return scgImdgSegrGrpDtl
	 */
	public ScgImdgSegrGrpDtlVO getScgImdgSegrGrpDtlVO() {
		return this.scgImdgSegrGrpDtl;
	}
	
	/**
	 * VO Info
	 * @param scgImdgSegrGrpl
	 */
	public void setScgImdgSegrGrpVOL(List<ScgImdgSegrGrpVO> scgImdgSegrGrpl) {
		this.scgImdgSegrGrpl = scgImdgSegrGrpl;
	}
	
	/**
	 * VO Info
	 * @param scgImdgSegrGrpDtll
	 */
	public void setScgImdgSegrGrpDtlVOL(List<ScgImdgSegrGrpDtlVO> scgImdgSegrGrpDtll) {
		this.scgImdgSegrGrpDtll = scgImdgSegrGrpDtll;
	}
	
	/**
	 * VO Info
	 * @param scgImdgSegrGrps
	 */
	public void setScgImdgSegrGrpVOS(ScgImdgSegrGrpVO[] scgImdgSegrGrps) {
		this.scgImdgSegrGrps = scgImdgSegrGrps;
	}
	
	/**
	 * VO Info
	 * @param scgImdgSegrGrpDtls
	 */
	public void setScgImdgSegrGrpDtlVOS(ScgImdgSegrGrpDtlVO[] scgImdgSegrGrpDtls) {
		this.scgImdgSegrGrpDtls = scgImdgSegrGrpDtls;
	}
	
	/**
	 * VO Info
	 * @param scgImdgSegrGrpDtl
	 */
	public void setScgImdgSegrGrpDtlVO(ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtl) {
		this.scgImdgSegrGrpDtl = scgImdgSegrGrpDtl;
	}
}
