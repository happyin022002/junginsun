/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri9123Event.java
 *@FileTitle : Authority Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.08
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2011.08.08 송민석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.ChangeUserVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComUserVO;


/**
 * ESM_PRI_9123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_9123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_9123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri9123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChangeUserVO changeUserVO = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
	private OrganizationVO organizationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChangeUserVO[]  changeUserVOs= null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComUserVO comUserVO = null;

	/** Custom Value Object 조회 조건 및 단건 처리  */
	private RsltAuthorizationVO rsltAuthorizationVO = null;

	/** Custom Value Object Multi Data 처리 */
	private RsltAuthorizationVO[] rsltAuthorizationVOs = null;
	
	public EsmPri9123Event(){}
	
	public void setChangeUserVO(ChangeUserVO changeUserVO){
		this. changeUserVO = changeUserVO;
	}

	public void setChangeUserVOS(ChangeUserVO[] changeUserVOs){
		if(changeUserVOs != null){
			ChangeUserVO[] tmpVOs = new ChangeUserVO[changeUserVOs.length];
			System.arraycopy(changeUserVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.changeUserVOs = tmpVOs;
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
	
	public ChangeUserVO getChangeUserVO(){
		return changeUserVO;
	}

	public ChangeUserVO[] getChangeUserVOS(){
		ChangeUserVO[] rtnVOs = null;
		if (this.changeUserVOs != null) {
			rtnVOs = new ChangeUserVO[changeUserVOs.length];
			System.arraycopy(changeUserVOs, 0, rtnVOs, 0, rtnVOs.length);
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