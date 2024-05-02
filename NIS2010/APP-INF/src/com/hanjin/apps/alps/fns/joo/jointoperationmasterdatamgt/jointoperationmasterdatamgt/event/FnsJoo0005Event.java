/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0005Event.java
*@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.21 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooStlVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;


/**
 * FNS_JOO_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooStlVvdVO jooStlVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooStlVvdVO[] jooStlVvdVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TargetVVDVO targetVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TargetVVDVO[] targetVVDVOs = null;
	
	/** Input parameter 처리 */
	private JooCodeParamVO jooCodeParamVO = null;
	
	private String joStlOptCd = null;
	
	public FnsJoo0005Event(){}
	
	public void setJooStlVvdVO(JooStlVvdVO jooStlVvdVO){
		this. jooStlVvdVO = jooStlVvdVO;
	}

	public void setJooStlVvdVOS(JooStlVvdVO[] jooStlVvdVOs){
		if (jooStlVvdVOs != null) {
			JooStlVvdVO[] tmpVOs = new JooStlVvdVO[jooStlVvdVOs.length];
			System.arraycopy(jooStlVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooStlVvdVOs = tmpVOs;
		}				
	}

	public void setTargetVVDVO(TargetVVDVO targetVVDVO){
		this. targetVVDVO = targetVVDVO;
	}

	public void setTargetVVDVOS(TargetVVDVO[] targetVVDVOs){
		if (targetVVDVOs != null) {
			TargetVVDVO[] tmpVOs = new TargetVVDVO[targetVVDVOs.length];
			System.arraycopy(targetVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.targetVVDVOs = tmpVOs;
		}				
	}

	public JooStlVvdVO getJooStlVvdVO(){
		return jooStlVvdVO;
	}

	public JooStlVvdVO[] getJooStlVvdVOS(){
		JooStlVvdVO[] rtnVOs = null;
		if (this.jooStlVvdVOs != null) {
			rtnVOs = new JooStlVvdVO[jooStlVvdVOs.length];
			System.arraycopy(jooStlVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	public TargetVVDVO getTargetVVDVO(){
		return targetVVDVO;
	}

	public TargetVVDVO[] getTargetVVDVOS(){
		TargetVVDVO[] rtnVOs = null;
		if (this.targetVVDVOs != null) {
			rtnVOs = new TargetVVDVO[targetVVDVOs.length];
			System.arraycopy(targetVVDVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	public JooCodeParamVO getJooCodeParamVO() {
		return jooCodeParamVO;
	}

	public void setJooCodeParamVO(JooCodeParamVO jooCodeParamVO) {
		this.jooCodeParamVO = jooCodeParamVO;
	}

	public String getJoStlOptCd() {
		return joStlOptCd;
	}

	public void setJoStlOptCd(String joStlOptCd) {
		this.joStlOptCd = joStlOptCd;
	}
}