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

import com.hanjin.syscommon.common.table.ScgPckPtbTnkVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VMS_SCG-0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg010307Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckPtbTnkVO scgPckPtbTnkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckPtbTnkVO[] scgPckPtbTnkVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckPtbTnkVO scgPckPtbTnk2VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckPtbTnkVO[] scgPckPtbTnk2VOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckPtbTnkVO scgPckPtbTnk3VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckPtbTnkVO[] scgPckPtbTnk3VOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckRefVO scgPckRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckRefVO[] scgPckRefVOs = null;

	public VopScg010307Event(){}
	
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
	
	public void setScgPckPtbTnkVO(ScgPckPtbTnkVO scgPckPtbTnkVO){
		this.scgPckPtbTnkVO = scgPckPtbTnkVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckPtbTnkVOS(ScgPckPtbTnkVO[] scgPckPtbTnkVOs){
		if (scgPckPtbTnkVOs != null) {
			ScgPckPtbTnkVO[] tmpVOs = new ScgPckPtbTnkVO[scgPckPtbTnkVOs.length];
			System.arraycopy(scgPckPtbTnkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckPtbTnkVOs = tmpVOs;
		}
	}

	public ScgPckPtbTnkVO getScgPckPtbTnkVO(){
		return scgPckPtbTnkVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckPtbTnkVO[] getScgPckPtbTnkVOS(){
		ScgPckPtbTnkVO[] rtnVOs = null;
		if (this.scgPckPtbTnkVOs != null) {
			rtnVOs = new ScgPckPtbTnkVO[scgPckPtbTnkVOs.length];
			System.arraycopy(scgPckPtbTnkVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScgPckPtbTnk2VO(ScgPckPtbTnkVO scgPckPtbTnk2VO){
		this.scgPckPtbTnk2VO = scgPckPtbTnk2VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckPtbTnk2VOS(ScgPckPtbTnkVO[] scgPckPtbTnk2VOs){
		if (scgPckPtbTnk2VOs != null) {
			ScgPckPtbTnkVO[] tmpVOs = new ScgPckPtbTnkVO[scgPckPtbTnk2VOs.length];
			System.arraycopy(scgPckPtbTnk2VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckPtbTnk2VOs = tmpVOs;
		}
	}

	public ScgPckPtbTnkVO getScgPckPtbTnk2VO(){
		return scgPckPtbTnk2VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckPtbTnkVO[] getScgPckPtbTnk2VOS(){
		ScgPckPtbTnkVO[] rtnVOs = null;
		if (this.scgPckPtbTnk2VOs != null) {
			rtnVOs = new ScgPckPtbTnkVO[scgPckPtbTnk2VOs.length];
			System.arraycopy(scgPckPtbTnk2VOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScgPckPtbTnk3VO(ScgPckPtbTnkVO scgPckPtbTnk3VO){
		this.scgPckPtbTnk3VO = scgPckPtbTnk3VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckPtbTnk3VOS(ScgPckPtbTnkVO[] scgPckPtbTnk3VOs){
		if (scgPckPtbTnk3VOs != null) {
			ScgPckPtbTnkVO[] tmpVOs = new ScgPckPtbTnkVO[scgPckPtbTnk3VOs.length];
			System.arraycopy(scgPckPtbTnk3VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckPtbTnk3VOs = tmpVOs;
		}
	}

	public ScgPckPtbTnkVO getScgPckPtbTnk3VO(){
		return scgPckPtbTnk3VO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckPtbTnkVO[] getScgPckPtbTnk3VOS(){
		ScgPckPtbTnkVO[] rtnVOs = null;
		if (this.scgPckPtbTnk3VOs != null) {
			rtnVOs = new ScgPckPtbTnkVO[scgPckPtbTnk3VOs.length];
			System.arraycopy(scgPckPtbTnk3VOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}