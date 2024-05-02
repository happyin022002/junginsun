/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0106Event.java
*@FileTitle : Port Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.02.01 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckCreationVO;


/**
 * VOP_AOM_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0107HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String pkgCd = "";
	
	private String pkgCdSeq = "";
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckCreationVO ScgPckCreationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckCreationVO[] ScgPckCreationVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckRefVO scgPckRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckRefVO[] scgPckRefVOs = null;

	public VopScg0107Event(){}
	
	public void setScgPckCreationVO(ScgPckCreationVO ScgPckCreationVO){
		this. ScgPckCreationVO = ScgPckCreationVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckCreationVOS(ScgPckCreationVO[] ScgPckCreationVOs){
		if (ScgPckCreationVOs != null) {
			ScgPckCreationVO[] tmpVOs = new ScgPckCreationVO[ScgPckCreationVOs.length];
			System.arraycopy(ScgPckCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ScgPckCreationVOs = tmpVOs;
		}
	}

	public ScgPckCreationVO getScgPckCreationVO(){
		return ScgPckCreationVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckCreationVO[] getScgPckCreationVOS(){
		ScgPckCreationVO[] rtnVOs = null;
		if (this.ScgPckCreationVOs != null) {
			rtnVOs = new ScgPckCreationVO[ScgPckCreationVOs.length];
			System.arraycopy(ScgPckCreationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
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
	
	/**
	 * @return the pkgCd
	 */
	public String getPkgCd() {
		return pkgCd;
	}

	/**
	 * @param pkgCd the pkgCd to set
	 */
	public void setPkgCd(String pkgCd) {
		this.pkgCd = pkgCd;
	}

	/**
	 * @return the pkgCdSeq
	 */
	public String getPkgCdSeq() {
		return pkgCdSeq;
	}

	/**
	 * @param pkgCdSeq the pkgCdSeq to set
	 */
	public void setPkgCdSeq(String pkgCdSeq) {
		this.pkgCdSeq = pkgCdSeq;
	}
	 
}