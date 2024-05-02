/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0224Event.java
*@FileTitle : Hanger Bar Inventory History Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 함형석  
*@LastVersion : 1.0
* 2009.10.09 함형석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomHangerInventoryListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListINVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0224 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0224HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0224HTMLAction 참조
 * @since J2EE 1.6
 */    
     
public class EesMnr0224Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	public EesMnr0224Event(){}   

	private HangerInventoryListINVO hangerInventoryListINVO = null;
	private CustomHangerInventoryListVO[] customHangerInventoryListVOs = null;
	private HangerInventoryListGRPVO hangerInventoryListGRPVO = null;

	public HangerInventoryListINVO getHangerInventoryListINVO() {
		return hangerInventoryListINVO;
	}
	 
	public void setHangerInventoryListINVO(HangerInventoryListINVO hangerInventoryListINVO) {
		this.hangerInventoryListINVO = hangerInventoryListINVO;
	}
	
	public CustomHangerInventoryListVO[] getCustomHangerInventoryListVOs() {
		CustomHangerInventoryListVO[] rtnVOs = null;
		if (this.customHangerInventoryListVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customHangerInventoryListVOs, customHangerInventoryListVOs.length);
		}
		return rtnVOs;
	}
	 
	public void setCustomHangerInventoryListVOs(CustomHangerInventoryListVO[] customHangerInventoryListVOs){
		if(customHangerInventoryListVOs != null){
			CustomHangerInventoryListVO[] tmpVOs = java.util.Arrays.copyOf(customHangerInventoryListVOs, customHangerInventoryListVOs.length);
			this.customHangerInventoryListVOs = tmpVOs;
		}
	}
	
	public HangerInventoryListGRPVO getHangerInventoryListGRPVO() {
		return hangerInventoryListGRPVO;
	}
	 
	public void setHangerInventoryListGRPVO(HangerInventoryListGRPVO hangerInventoryListGRPVO) {
		this.hangerInventoryListGRPVO = hangerInventoryListGRPVO;
	}
}