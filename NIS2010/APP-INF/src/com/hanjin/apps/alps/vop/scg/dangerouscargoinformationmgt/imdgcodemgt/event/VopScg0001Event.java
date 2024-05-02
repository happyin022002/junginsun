/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0001Event.java
*@FileTitle : UN Number
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.18 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgSubsRskLblVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.AutoCreationVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberGrpVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;


/**
 * VOP_SCG-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0001HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UNNumberListOptionVO unNumberListOptionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSubsRskLblVO scgImdgSubsRskLblVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgUnNoSegrListVO scgImdgUnNoSegrListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSegrGrpVO scgImdgSegrGrpVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgExptQtyVO scgImdgExptQtyVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AutoCreationVO autoCreationVO = null;

	/** Table Value Object Multi Data 처리 */
	private ScgImdgSubsRskLblVO[] scgImdgSubsRskLblVOs = null;

	/** Table Value Object Multi Data 처리 */
	private ScgImdgSegrGrpVO[] scgImdgSegrGrpVOs = null;

	/** container VO **/
	private UNNumberGrpVO unNumberGrpVO = null;	
	
	public VopScg0001Event(){}
	
	public void setUNNumberListOptionVO(UNNumberListOptionVO unNumberListOptionVO){
		this. unNumberListOptionVO = unNumberListOptionVO;
	}

	public void setScgImdgSubsRskLblVO(ScgImdgSubsRskLblVO scgImdgSubsRskLblVO){
		this. scgImdgSubsRskLblVO = scgImdgSubsRskLblVO;
	}

	public void setScgImdgUnNoSegrListVO(ScgImdgUnNoSegrListVO scgImdgUnNoSegrListVO){
		this. scgImdgUnNoSegrListVO = scgImdgUnNoSegrListVO;
	}

	public void setScgImdgSegrGrpVO(ScgImdgSegrGrpVO scgImdgSegrGrpVO){
		this. scgImdgSegrGrpVO = scgImdgSegrGrpVO;
	}

	public void setScgImdgExptQtyVO(ScgImdgExptQtyVO scgImdgExptQtyVO){
		this. scgImdgExptQtyVO = scgImdgExptQtyVO;
	}

	public void setAutoCreationVO(AutoCreationVO autoCreationVO){
		this. autoCreationVO = autoCreationVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgSubsRskLblVOS(ScgImdgSubsRskLblVO[] scgImdgSubsRskLblVOs){
		if (scgImdgSubsRskLblVOs != null) {
			ScgImdgSubsRskLblVO[] tmpVOs = new ScgImdgSubsRskLblVO[scgImdgSubsRskLblVOs.length];
			System.arraycopy(scgImdgSubsRskLblVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgSubsRskLblVOs = tmpVOs;
		}
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgSegrGrpVOS(ScgImdgSegrGrpVO[] scgImdgSegrGrpVOs){
		if (scgImdgSegrGrpVOs != null) {
			ScgImdgSegrGrpVO[] tmpVOs = new ScgImdgSegrGrpVO[scgImdgSegrGrpVOs.length];
			System.arraycopy(scgImdgSegrGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgSegrGrpVOs = tmpVOs;
		}
	}
	
	
	public UNNumberListOptionVO getUNNumberListOptionVO(){
		return unNumberListOptionVO;
	}
	
	public ScgImdgSubsRskLblVO getScgImdgSubsRskLblVO(){
		return scgImdgSubsRskLblVO;
	}

	public ScgImdgUnNoSegrListVO getScgImdgUnNoSegrListVO(){
		return scgImdgUnNoSegrListVO;
	}

	public ScgImdgSegrGrpVO getScgImdgSegrGrpVO(){
		return scgImdgSegrGrpVO;
	}

	public ScgImdgExptQtyVO getScgImdgExptQtyVO(){
		return scgImdgExptQtyVO;
	}

	public AutoCreationVO getAutoCreationVO(){
		return autoCreationVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgSegrGrpVO[] getScgImdgSegrGrpVOS(){
		ScgImdgSegrGrpVO[] rtnVOs = null;
		if (this.scgImdgSegrGrpVOs != null) {
			rtnVOs = new ScgImdgSegrGrpVO[scgImdgSegrGrpVOs.length];
			System.arraycopy(scgImdgSegrGrpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgSubsRskLblVO[] getScgImdgSubsRskLblVOS(){
		ScgImdgSubsRskLblVO[] rtnVOs = null;
		if (this.scgImdgSubsRskLblVOs != null) {
			rtnVOs = new ScgImdgSubsRskLblVO[scgImdgSubsRskLblVOs.length];
			System.arraycopy(scgImdgSubsRskLblVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public UNNumberGrpVO getUNNumberGrpVO() {
		return unNumberGrpVO;
	}
	public void setUNNumberGrpVO(UNNumberGrpVO unNumberGrpVO) {
		this.unNumberGrpVO = unNumberGrpVO;
	}	
}