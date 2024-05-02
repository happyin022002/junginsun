/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComSec0002Event.java
*@FileTitle : Role Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComAproRoleRqstHdrVO;
import com.hanjin.syscommon.management.alps.role.vo.ComUsrRoleConditionVO;
import com.hanjin.syscommon.management.alps.role.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;


/**
 * COM_SEC_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_SEC_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see COM_SEC_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComSec0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** subSysCd 변수 */
	String subSysCd;
	
	/** rqstUerId 변수 */
	String rqstUsrId;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	MenuListVO menuListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	MenuListVO[] menuListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	ComUsrRoleConditionVO comUsrRoleConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	ComUsrRoleConditionVO[] comUsrRoleConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	UserRoleAuthAproVO userRoleAuthAproVO = null;
	
	/** Table Value Object Multi Data 처리 */
	UserRoleAuthAproVO[] userRoleAuthAproVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	ComAproRoleRqstHdrVO comAproRoleRqstHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	ComAproRoleRqstHdrVO[] comAproRoleRqstHdrVOs = null;
	
	
	public ComSec0002Event(){}
	
	public void setMenuListVO(MenuListVO menuListVO){
		this. menuListVO = menuListVO;
	}

	public void setMenuListVOS(MenuListVO[] menuListVOs){
		if (menuListVOs != null) {
			MenuListVO[] tmpVOs = Arrays.copyOf(menuListVOs, menuListVOs .length);
			this. menuListVOs = tmpVOs;
		}
	}

	public MenuListVO getMenuListVO(){
		return menuListVO;
	}

	public MenuListVO[] getMenuListVOS(){
		MenuListVO[] tmpVOs = null;
		if (this. menuListVOs != null) {
			tmpVOs = Arrays.copyOf(menuListVOs, menuListVOs .length);
		}
		return tmpVOs;
	}

	
	public void setComUsrRoleConditionVO(ComUsrRoleConditionVO comUsrRoleConditionVO){
		this. comUsrRoleConditionVO = comUsrRoleConditionVO;
	}

	public void setComUsrRoleConditionVOS(ComUsrRoleConditionVO[] comUsrRoleConditionVOs){
		if (comUsrRoleConditionVOs != null) {
			ComUsrRoleConditionVO[] tmpVOs = Arrays.copyOf(comUsrRoleConditionVOs, comUsrRoleConditionVOs.length);
			this. comUsrRoleConditionVOs = tmpVOs;
		}
	}

	public ComUsrRoleConditionVO getComUsrRoleConditionVO(){
		return comUsrRoleConditionVO;
	}

	public ComUsrRoleConditionVO[] getComUsrRoleConditionVOS(){
		ComUsrRoleConditionVO[] tmpVOs = null;
		if (this. comUsrRoleConditionVOs != null) {
			tmpVOs = Arrays.copyOf(comUsrRoleConditionVOs, comUsrRoleConditionVOs.length);
		}
		return tmpVOs;
	}

	public String getSubSysCd() {
		return subSysCd;
	}

	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	
	public void setUserRoleAuthAproVO(UserRoleAuthAproVO userRoleAuthAproVO){
		this. userRoleAuthAproVO = userRoleAuthAproVO;
	}

	public void setUserRoleAuthAproVOs(UserRoleAuthAproVO[] userRoleAuthAproVOs){
		if (userRoleAuthAproVOs != null) {
			UserRoleAuthAproVO[] tmpVOs = Arrays.copyOf(userRoleAuthAproVOs, userRoleAuthAproVOs .length);
			this. userRoleAuthAproVOs = tmpVOs;
		}
	}

	public UserRoleAuthAproVO getUserRoleAuthAproVO(){
		return userRoleAuthAproVO;
	}

	public UserRoleAuthAproVO[] getUserRoleAuthAproVOs(){
		UserRoleAuthAproVO[] tmpVOs = null;
		if (this. userRoleAuthAproVOs != null) {
			tmpVOs = Arrays.copyOf(userRoleAuthAproVOs, userRoleAuthAproVOs .length);
		}
		return tmpVOs;
	}

	public ComAproRoleRqstHdrVO getComAproRoleRqstHdrVO() {
		return comAproRoleRqstHdrVO;
	}

	public void setComAproRoleRqstHdrVO(ComAproRoleRqstHdrVO comAproRoleRqstHdrVO) {
		this.comAproRoleRqstHdrVO = comAproRoleRqstHdrVO;
	}

	public ComAproRoleRqstHdrVO[] getComAproRoleRqstHdrVOs() {
		return comAproRoleRqstHdrVOs;
	}

	public void setComAproRoleRqstHdrVOs(
			ComAproRoleRqstHdrVO[] comAproRoleRqstHdrVOs) {
		this.comAproRoleRqstHdrVOs = comAproRoleRqstHdrVOs;
	}

	public String getRqstUsrId() {
		return rqstUsrId;
	}

	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
}