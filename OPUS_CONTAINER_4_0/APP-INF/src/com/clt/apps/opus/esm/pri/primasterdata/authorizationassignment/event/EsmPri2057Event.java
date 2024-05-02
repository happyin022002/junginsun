/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2057Event.java
 *@FileTitle : Authority Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.08.14 문동규
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event;

import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.PriAuthorizationVO;


/**
 * ESM_PRI_2057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2057Event extends EventSupport {

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
	
	public EsmPri2057Event(){}
	
	public void setPriAuthorizationVO(PriAuthorizationVO priAuthorizationVO){
		this. priAuthorizationVO = priAuthorizationVO;
	}

	public void setPriAuthorizationVOS(PriAuthorizationVO[] priAuthorizationVOs){
		if (priAuthorizationVOs != null) {
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
		if (rsltAuthorizationVOs != null) {
			RsltAuthorizationVO[] tmpVOs = new RsltAuthorizationVO[rsltAuthorizationVOs.length];
			System.arraycopy(rsltAuthorizationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltAuthorizationVOs = tmpVOs;
		}
	}
	
	public PriAuthorizationVO getPriAuthorizationVO(){
		return priAuthorizationVO;
	}

	public PriAuthorizationVO[] getPriAuthorizationVOS(){
		PriAuthorizationVO[] tmpVOs = null;
		if (this.priAuthorizationVOs != null) {
			tmpVOs = new PriAuthorizationVO[priAuthorizationVOs.length];
			System.arraycopy(priAuthorizationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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
		RsltAuthorizationVO[] tmpVOs = null;
		if (this.rsltAuthorizationVOs != null) {
			tmpVOs = new RsltAuthorizationVO[rsltAuthorizationVOs.length];
			System.arraycopy(rsltAuthorizationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}