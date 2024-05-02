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
package com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0071Event extends EventSupport{

	/**
	 *
	 */
	public EsdPrd0071Event(){
    }
    private GroupCreationVO groupCreationVO;
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
        return groupCreationVOs;
    }
    /**
     * @param groupCreationVOs the groupCreationVOs to set
     */
    public void setGroupCreationVOs(GroupCreationVO[] groupCreationVOs) {
        this.groupCreationVOs = groupCreationVOs;
    }
    private GroupCreationVO[] groupCreationVOs;

}
