/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0004Event.java
*@FileTitle : Segregation Table (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.28 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationTableGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgClssSegrVO;


/**
 * VOP_SCG-0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgClssSegrVO scgImdgClssSegrVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgClssSegrListVO scgImdgClssSegrListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCompGrpSegrListVO scgImdgCompGrpSegrListVO = null;

	/** Table Value Object Multi Data 처리 */
	private ScgImdgClssSegrVO[] scgImdgClssSegrVOs = null;

	/** Table Value Object Multi Data 처리 */
	private ScgImdgClssSegrListVO[] scgImdgClssSegrListVOs = null;

	/** container VO **/
	private SegregationTableGrpVO segregationTableGrpVO = null;	

	public VopScg0004Event(){}
	
	public void setScgImdgClssSegrVO(ScgImdgClssSegrVO scgImdgClssSegrVO){
		this. scgImdgClssSegrVO = scgImdgClssSegrVO;
	}

	public void setScgImdgClssSegrListVO(ScgImdgClssSegrListVO scgImdgClssSegrListVO){
		this. scgImdgClssSegrListVO = scgImdgClssSegrListVO;
	}

	public void setScgImdgCompGrpSegrListVO(ScgImdgCompGrpSegrListVO scgImdgCompGrpSegrListVO){
		this. scgImdgCompGrpSegrListVO = scgImdgCompGrpSegrListVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgClssSegrVOS(ScgImdgClssSegrVO[] scgImdgClssSegrVOs){
		if (scgImdgClssSegrVOs != null) {
			ScgImdgClssSegrVO[] tmpVOs = new ScgImdgClssSegrVO[scgImdgClssSegrVOs.length];
			System.arraycopy(scgImdgClssSegrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgClssSegrVOs = tmpVOs;
		}
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgClssSegrListVOS(ScgImdgClssSegrListVO[] scgImdgClssSegrListVOs){
		if (scgImdgClssSegrListVOs != null) {
			ScgImdgClssSegrListVO[] tmpVOs = new ScgImdgClssSegrListVO[scgImdgClssSegrListVOs.length];
			System.arraycopy(scgImdgClssSegrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgClssSegrListVOs = tmpVOs;
		}
	}

	public ScgImdgClssSegrVO getScgImdgClssSegrVO(){
		return scgImdgClssSegrVO;
	}

	public ScgImdgClssSegrListVO getScgImdgClssSegrListVO(){
		return scgImdgClssSegrListVO;
	}

	public ScgImdgCompGrpSegrListVO getScgImdgCompGrpSegrListVO(){
		return scgImdgCompGrpSegrListVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgClssSegrVO[] getScgImdgClssSegrVOS(){
		ScgImdgClssSegrVO[] rtnVOs = null;
		if (this.scgImdgClssSegrVOs != null) {
			rtnVOs = new ScgImdgClssSegrVO[scgImdgClssSegrVOs.length];
			System.arraycopy(scgImdgClssSegrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgClssSegrListVO[] getScgImdgClssSegrListVOS(){
		ScgImdgClssSegrListVO[] rtnVOs = null;
		if (this.scgImdgClssSegrListVOs != null) {
			rtnVOs = new ScgImdgClssSegrListVO[scgImdgClssSegrListVOs.length];
			System.arraycopy(scgImdgClssSegrListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	
	
	/** container VO **/
	public SegregationTableGrpVO getSegregationTableGrpVO() {
		return segregationTableGrpVO;
	}
	public void setSegregationTableGrpVO(SegregationTableGrpVO segregationTableGrpVO) {
		this.segregationTableGrpVO = segregationTableGrpVO;
	}	
	

}