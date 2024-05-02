/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0003Event.java
*@FileTitle : Segregation Table (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.27 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationTableGrpVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgClssSegrVO;


/**
 * VOP_SCG-0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0003Event extends EventSupport {

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

	public VopScg0003Event(){}
	
	public void setScgImdgClssSegrVO(ScgImdgClssSegrVO scgImdgClssSegrVO){
		this. scgImdgClssSegrVO = scgImdgClssSegrVO;
	}

	public void setScgImdgClssSegrListVO(ScgImdgClssSegrListVO scgImdgClssSegrListVO){
		this. scgImdgClssSegrListVO = scgImdgClssSegrListVO;
	}

	public void setScgImdgCompGrpSegrListVO(ScgImdgCompGrpSegrListVO scgImdgCompGrpSegrListVO){
		this. scgImdgCompGrpSegrListVO = scgImdgCompGrpSegrListVO;
	}

	public void setScgImdgClssSegrVOS(ScgImdgClssSegrVO[] scgImdgClssSegrVOs){
		if(scgImdgClssSegrVOs != null){
			ScgImdgClssSegrVO[] tmpVOs = Arrays.copyOf(scgImdgClssSegrVOs, scgImdgClssSegrVOs.length);
			this.scgImdgClssSegrVOs = tmpVOs;
		}
	}

	public void setScgImdgClssSegrListVOS(ScgImdgClssSegrListVO[] scgImdgClssSegrListVOs){
		if(scgImdgClssSegrListVOs != null){
			ScgImdgClssSegrListVO[] tmpVOs = Arrays.copyOf(scgImdgClssSegrListVOs, scgImdgClssSegrListVOs.length);
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

	public ScgImdgClssSegrVO[] getScgImdgClssSegrVOS(){
		ScgImdgClssSegrVO[] rtnVOs = null;
		if (this.scgImdgClssSegrVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgClssSegrVOs, scgImdgClssSegrVOs.length);
		}
		return rtnVOs;
	}

	public ScgImdgClssSegrListVO[] getScgImdgClssSegrListVOS(){
		ScgImdgClssSegrListVO[] rtnVOs = null;
		if (this.scgImdgClssSegrListVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgClssSegrListVOs, scgImdgClssSegrListVOs.length);
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