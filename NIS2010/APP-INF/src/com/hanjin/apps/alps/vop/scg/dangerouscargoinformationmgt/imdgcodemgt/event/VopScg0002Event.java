/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0002Event.java
*@FileTitle : UN Number (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.27 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;


/**
 * VOP_SCG-0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgUnNoVO scgImdgUnNoVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UNNumberListOptionVO unNumberListOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private ScgImdgUnNoVO[] scgImdgUnNoVOs = null;

	public VopScg0002Event(){}
	
	public void setScgImdgUnNoVO(ScgImdgUnNoVO scgImdgUnNoVO){
		this. scgImdgUnNoVO = scgImdgUnNoVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgUnNoVOS(ScgImdgUnNoVO[] scgImdgUnNoVOs){
		if (scgImdgUnNoVOs != null) {
			ScgImdgUnNoVO[] tmpVOs = new ScgImdgUnNoVO[scgImdgUnNoVOs.length];
			System.arraycopy(scgImdgUnNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgUnNoVOs = tmpVOs;
		}
	}

	public void setUNNumberListOptionVO(UNNumberListOptionVO unNumberListOptionVO){
		this. unNumberListOptionVO = unNumberListOptionVO;
	}

	public ScgImdgUnNoVO getScgImdgUnNoVO(){
		return scgImdgUnNoVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgUnNoVO[] getScgImdgUnNoVOS(){
		ScgImdgUnNoVO[] rtnVOs = null;
		if (this.scgImdgUnNoVOs != null) {
			rtnVOs = new ScgImdgUnNoVO[scgImdgUnNoVOs.length];
			System.arraycopy(scgImdgUnNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public UNNumberListOptionVO getUNNumberListOptionVO(){
		return unNumberListOptionVO;
	}
	
	
}