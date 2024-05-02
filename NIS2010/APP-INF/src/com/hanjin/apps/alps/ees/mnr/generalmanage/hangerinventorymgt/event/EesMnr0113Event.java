/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0113Event.java
*@FileTitle : Hanger Bar Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 박정민  
*@LastVersion : 1.0
* 2015.01.28 박정민 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomHangerInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomNewHangerInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박정민
 * @see ees_mnr_0113HTMLAction 참조
 * @since J2EE 1.6
 */    
     
public class EesMnr0113Event extends EventSupport {

	private static final long serialVersionUID = 5267894201476483348L;

	public EesMnr0113Event(){}   

	private HangerInventoryListINVO hangerInventoryListINVO = null;
	private CustomHangerInventoryListVO[] customHangerInventoryListVOs = null;
	private CustomNewHangerInventoryListVO[] customNewHangerInventoryListVOs = null;
	private HangerInventoryListGRPVO hangerInventoryListGRPVO = null;

	public HangerInventoryListINVO getHangerInventoryListINVO() {
		return hangerInventoryListINVO;
	}
	 
	public void setHangerInventoryListINVO(HangerInventoryListINVO hangerInventoryListINVO) {
		this.hangerInventoryListINVO = hangerInventoryListINVO;
	}
	
	public CustomHangerInventoryListVO[] getCustomHangerInventoryListVOs() {
		return customHangerInventoryListVOs;
	}
	 
	public void setCustomHangerInventoryListVOs(CustomHangerInventoryListVO[] customHangerInventoryListVOs) {
		this.customHangerInventoryListVOs = customHangerInventoryListVOs;
	}

	public CustomNewHangerInventoryListVO[] getCustomNewHangerInventoryListVOs() {
		return customNewHangerInventoryListVOs;
	}
	 
	public void setCustomNewHangerInventoryListVOs(CustomNewHangerInventoryListVO[] customNewHangerInventoryListVOs) {
		this.customNewHangerInventoryListVOs = customNewHangerInventoryListVOs;
	}

	public HangerInventoryListGRPVO getHangerInventoryListGRPVO() {
		return hangerInventoryListGRPVO;
	}
	 
	public void setHangerInventoryListGRPVO(HangerInventoryListGRPVO hangerInventoryListGRPVO) {
		this.hangerInventoryListGRPVO = hangerInventoryListGRPVO;
	}
}