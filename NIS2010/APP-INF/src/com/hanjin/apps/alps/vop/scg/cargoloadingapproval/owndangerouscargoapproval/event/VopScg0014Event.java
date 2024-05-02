/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0014Event.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgAuthorizationVO;


/**
 * VOP_SCG-0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String[] crrCd; 
	private String[] polCd;
	private String scgFlg;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRequestListOptionVO scgRequestListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgRequestListOptionVO[] scgRequestListOptionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgAuthorizationVO scgAuthorizationVO = null;

	/** Table Value Object Multi Data 처리 */
	private ScgAuthorizationVO[] scgAuthorizationVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	public VopScg0014Event(){}
	
	public void setScgRequestListOptionVO(ScgRequestListOptionVO scgRequestListOptionVO){
		this. scgRequestListOptionVO = scgRequestListOptionVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgRequestListOptionVOS(ScgRequestListOptionVO[] scgRequestListOptionVOs){
		if (scgRequestListOptionVOs != null) {
			ScgRequestListOptionVO[] tmpVOs = new ScgRequestListOptionVO[scgRequestListOptionVOs.length];
			System.arraycopy(scgRequestListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgRequestListOptionVOs = tmpVOs;
		}
	}

	public void setScgAuthorizationVO(ScgAuthorizationVO scgAuthorizationVO){
		this. scgAuthorizationVO = scgAuthorizationVO;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgAuthorizationVOS(ScgAuthorizationVO[] scgAuthorizationVOs){
		if (scgAuthorizationVOs != null) {
			ScgAuthorizationVO[] tmpVOs = new ScgAuthorizationVO[scgAuthorizationVOs.length];
			System.arraycopy(scgAuthorizationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgAuthorizationVOs = tmpVOs;
		}
	}

	public ScgRequestListOptionVO getScgRequestListOptionVO(){
		return scgRequestListOptionVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgRequestListOptionVO[] getScgRequestListOptionVOS(){
		ScgRequestListOptionVO[] rtnVOs = null;
		if (this.scgRequestListOptionVOs != null) {
			rtnVOs = new ScgRequestListOptionVO[scgRequestListOptionVOs.length];
			System.arraycopy(scgRequestListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public ScgAuthorizationVO getScgAuthorizationVO(){
		return scgAuthorizationVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgAuthorizationVO[] getScgAuthorizationVOS(){
		ScgAuthorizationVO[] rtnVOs = null;
		if (this.scgAuthorizationVOs != null) {
			rtnVOs = new ScgAuthorizationVO[scgAuthorizationVOs.length];
			System.arraycopy(scgAuthorizationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setCrrCd(String[] crrCd)
	{
		if (crrCd != null) {
			String[] tmpVOs = new String[crrCd.length];
			System.arraycopy(crrCd, 0, tmpVOs, 0, tmpVOs.length);
			this.crrCd = tmpVOs;
		}
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public String[] getCrrCd()
	{
		String[] rtnVOs = null;
		if (this.crrCd != null) {
			rtnVOs = new String[crrCd.length];
			System.arraycopy(crrCd, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setPolCd(String[] polCd)
	{
		if (polCd != null) {
			String[] tmpVOs = new String[polCd.length];
			System.arraycopy(polCd, 0, tmpVOs, 0, tmpVOs.length);
			this.polCd = tmpVOs;
		}
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public String[] getPolCd()
	{
		String[] rtnVOs = null;
		if (this.polCd != null) {
			rtnVOs = new String[polCd.length];
			System.arraycopy(polCd, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setScgFlg(String scgFlg)
	{
		this.scgFlg = scgFlg;
	}
	public String getScgFlg()
	{
		return this.scgFlg;
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}
	
}