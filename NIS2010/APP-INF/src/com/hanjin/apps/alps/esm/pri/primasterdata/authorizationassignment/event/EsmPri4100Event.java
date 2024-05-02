/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0009Event.java
*@FileTitle : Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.28 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;


/**
 * ESM_PRI_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0009HTMLAction 참조
 * @since J2EE 1.6
 */ 

public class EsmPri4100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriAuthorizationVO priAuthorizationVO = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
	private OrganizationVO organizationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriAuthorizationVO[] priAuthorizationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComUserVO comUserVO = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
	private RsltAuthorizationVO rsltAuthorizationVO = null;

	/** Custom Value Object Multi Data 처리 */
	private RsltAuthorizationVO[] rsltAuthorizationVOs = null;
	
	public EsmPri4100Event(){}
	
	public void setPriAuthorizationVO(PriAuthorizationVO priAuthorizationVO){
		this. priAuthorizationVO = priAuthorizationVO;
	}

	public void setPriAuthorizationVOS(PriAuthorizationVO[] priAuthorizationVOs){
		if(priAuthorizationVOs != null){
			PriAuthorizationVO[] tmpVOs = new PriAuthorizationVO[priAuthorizationVOs.length];
			System.arraycopy(priAuthorizationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priAuthorizationVOs = tmpVOs;
		}
	}

	public void setOrganizationVO(OrganizationVO organizationVO){
		this.organizationVO = organizationVO;
	}

	public void setComUserVO(ComUserVO comUserVO){
		this.comUserVO = comUserVO;
	}

	public void setRsltAuthorizationVO(RsltAuthorizationVO rsltAuthorizationVO){
		this.rsltAuthorizationVO = rsltAuthorizationVO;
	}
	
	public void setRsltAuthorizationVOS(RsltAuthorizationVO[] rsltAuthorizationVOs){
		if(rsltAuthorizationVOs != null){
			RsltAuthorizationVO[] tmpVOs = new RsltAuthorizationVO[rsltAuthorizationVOs.length];
			System.arraycopy(rsltAuthorizationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltAuthorizationVOs = tmpVOs;
		}
	}
	
	public PriAuthorizationVO getPriAuthorizationVO(){
		return priAuthorizationVO;
	}

	public PriAuthorizationVO[] getPriAuthorizationVOS(){
		PriAuthorizationVO[] rtnVOs = null;
		if (this.priAuthorizationVOs != null) {
			rtnVOs = new PriAuthorizationVO[priAuthorizationVOs.length];
			System.arraycopy(priAuthorizationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public OrganizationVO getOrganizationVO(){
		return organizationVO;
	}

	public ComUserVO getComUserVO(){
		return comUserVO;
	}

	public RsltAuthorizationVO getRsltAuthorizationVO(){
		return rsltAuthorizationVO;
	}
	
	public RsltAuthorizationVO[] getRsltAuthorizationVOS(){
		RsltAuthorizationVO[] rtnVOs = null;
		if (this.rsltAuthorizationVOs != null) {
			rtnVOs = new RsltAuthorizationVO[rsltAuthorizationVOs.length];
			System.arraycopy(rsltAuthorizationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
}