/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_002Event.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.event;

import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0071Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public EsdPrd0071Event() {
	}

	private GroupCreationVO groupCreationVO;

	private GroupCreationVO[] groupCreationVOs;

	/**
	 * @return the groupCreationVO
	 */
	public GroupCreationVO getGroupCreationVO() {
		return groupCreationVO;
	}

	/**
	 * @param groupCreationVO the groupCreationVO to set
	 */
	public void setGroupCreationVO(GroupCreationVO groupCreationVO) {
		this.groupCreationVO = groupCreationVO;
	}

	/**
	 * @return the groupCreationVOs
	 */
	public GroupCreationVO[] getGroupCreationVOs() {
		GroupCreationVO[] tmpVOs = null;
		if (this.groupCreationVOs != null) {
			tmpVOs = new GroupCreationVO[this.groupCreationVOs.length];
			System.arraycopy(this.groupCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param groupCreationVOs the groupCreationVOs to set
	 */
	public void setGroupCreationVOs(GroupCreationVO[] groupCreationVOs) {
		if (groupCreationVOs != null) {
			GroupCreationVO[] tmpVOs = new GroupCreationVO[groupCreationVOs.length];
			System.arraycopy(groupCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.groupCreationVOs = tmpVOs;
		}
	}

}
