/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0031Event.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.syscommon.common.table.ScgPckPkgVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;


/**
 * VMS_SCG-0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg010302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckPkgVO scgPckPkgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckPkgVO[] scgPckPkgVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckPkgVO scgPckPkg2VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckPkgVO[] scgPckPkg2VOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckPkgVO scgPckPkg3VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckPkgVO[] scgPckPkg3VOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckRefVO scgPckRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckRefVO[] scgPckRefVOs = null;

	public VopScg010302Event(){}
	
	public void setScgPckRefVO(ScgPckRefVO scgPckRefVO){
		this.scgPckRefVO = scgPckRefVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckRefVOS(ScgPckRefVO[] scgPckRefVOs){
		if (scgPckRefVOs != null) {
			ScgPckRefVO[] tmpVOs = new ScgPckRefVO[scgPckRefVOs.length];
			System.arraycopy(scgPckRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckRefVOs = tmpVOs;
		}
	}

	public ScgPckRefVO getScgPckRefVO(){
		return scgPckRefVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckRefVO[] getScgPckRefVOS(){
		ScgPckRefVO[] rtnVOs = null;
		if (this.scgPckRefVOs != null) {
			rtnVOs = new ScgPckRefVO[scgPckRefVOs.length];
			System.arraycopy(scgPckRefVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScgPckPkgVO(ScgPckPkgVO scgPckPkgVO){
		this.scgPckPkgVO = scgPckPkgVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckPkgVOS(ScgPckPkgVO[] scgPckPkgVOs){
		if (scgPckPkgVOs != null) {
			ScgPckPkgVO[] tmpVOs = new ScgPckPkgVO[scgPckPkgVOs.length];
			System.arraycopy(scgPckPkgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckPkgVOs = tmpVOs;
		}
	}

	public ScgPckPkgVO getScgPckPkgVO(){
		return scgPckPkgVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckPkgVO[] getScgPckPkgVOS(){
		ScgPckPkgVO[] rtnVOs = null;
		if (this.scgPckPkgVOs != null) {
			rtnVOs = new ScgPckPkgVO[scgPckPkgVOs.length];
			System.arraycopy(scgPckPkgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScgPckPkg2VO(ScgPckPkgVO scgPckPkg2VO){
		this.scgPckPkg2VO = scgPckPkg2VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckPkg2VOS(ScgPckPkgVO[] scgPckPkg2VOs){
		if (scgPckPkg2VOs != null) {
			ScgPckPkgVO[] tmpVOs = new ScgPckPkgVO[scgPckPkg2VOs.length];
			System.arraycopy(scgPckPkg2VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckPkg2VOs = tmpVOs;
		}
	}

	public ScgPckPkgVO getScgPckPkg2VO(){
		return scgPckPkg2VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckPkgVO[] getScgPckPkg2VOS(){
		ScgPckPkgVO[] rtnVOs = null;
		if (this.scgPckPkg2VOs != null) {
			rtnVOs = new ScgPckPkgVO[scgPckPkg2VOs.length];
			System.arraycopy(scgPckPkg2VOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScgPckPkg3VO(ScgPckPkgVO scgPckPkg3VO){
		this.scgPckPkg3VO = scgPckPkg3VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckPkg3VOS(ScgPckPkgVO[] scgPckPkg3VOs){
		if (scgPckPkg3VOs != null) {
			ScgPckPkgVO[] tmpVOs = new ScgPckPkgVO[scgPckPkg3VOs.length];
			System.arraycopy(scgPckPkg3VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckPkg3VOs = tmpVOs;
		}
	}

	public ScgPckPkgVO getScgPckPkg3VO(){
		return scgPckPkg3VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckPkgVO[] getScgPckPkg3VOS(){
		ScgPckPkgVO[] rtnVOs = null;
		if (this.scgPckPkg3VOs != null) {
			rtnVOs = new ScgPckPkgVO[scgPckPkg3VOs.length];
			System.arraycopy(scgPckPkg3VOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
}