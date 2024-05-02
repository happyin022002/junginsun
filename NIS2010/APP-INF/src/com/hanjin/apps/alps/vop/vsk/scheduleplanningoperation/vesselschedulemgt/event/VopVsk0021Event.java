/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0021Event.java
*@FileTitle : VSL SKD Inquiry by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 Jung Jinwoo
* 1.0 Creation
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.SearchDateVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;


/**
 * VOP_VSK_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0021HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdByPortVO cstSkdByPortVO = null;
	private MdmLocationVO mdmLocationVO = null;
	private VvdVO vvdVO = null;
	private SearchDateVO searchDateVO = null;
	private UserDefinedLanePortGroupVO userDefinedLanePortGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdByPortVO[] cstSkdByPortVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;
	private VvdVO[] vvdVOs = null;
	private SearchDateVO[] searchDateVOs = null;
	private UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs = null;

	public VopVsk0021Event(){}

	/**
	 * @return the cstSkdByPortVO
	 */
	public CstSkdByPortVO getCstSkdByPortVO() {
		return cstSkdByPortVO;
	}

	/**
	 * @param cstSkdByPortVO the cstSkdByPortVO to set
	 */
	public void setCstSkdByPortVO(CstSkdByPortVO cstSkdByPortVO) {
		this.cstSkdByPortVO = cstSkdByPortVO;
	}

	public SearchDateVO getSearchDateVO() {
		return searchDateVO;
	}

	public void setSearchDateVO(SearchDateVO searchDateVO) {
		this.searchDateVO = searchDateVO;
	}

	public SearchDateVO[] getSearchDateVOs() {
		SearchDateVO[] rtnVOs =  null;
		if(this.searchDateVOs != null){
			rtnVOs = new SearchDateVO[searchDateVOs.length];
			System.arraycopy(searchDateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return searchDateVOs;
	}

	public void setSearchDateVOs(SearchDateVO[] searchDateVOs) {
		if(searchDateVOs != null){
			SearchDateVO[] tmpVOs = new SearchDateVO[searchDateVOs.length];
			System.arraycopy(searchDateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDateVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.searchDateVOs = searchDateVOs;
	}

	/**
	 * @return the cstSkdByPortVOs
	 */
	public CstSkdByPortVO[] getCstSkdByPortVOs() {
		CstSkdByPortVO[] rtnVOs =  null;
		if(this.cstSkdByPortVOs != null){
			rtnVOs = new CstSkdByPortVO[cstSkdByPortVOs.length];
			System.arraycopy(cstSkdByPortVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return cstSkdByPortVOs;
	}

	/**
	 * @param cstSkdByPortVOs the cstSkdByPortVOs to set
	 */
	public void setCstSkdByPortVOs(CstSkdByPortVO[] cstSkdByPortVOs) {
		if(cstSkdByPortVOs != null){
			CstSkdByPortVO[] tmpVOs = new CstSkdByPortVO[cstSkdByPortVOs.length];
			System.arraycopy(cstSkdByPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstSkdByPortVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.cstSkdByPortVOs = cstSkdByPortVOs;
	}

	/**
	 * @return the mdmLocationVO
	 */
	public MdmLocationVO getMdmLocationVO() {
		return mdmLocationVO;
	}

	/**
	 * @param mdmLocationVO the mdmLocationVO to set
	 */
	public void setMdmLocationVO(MdmLocationVO mdmLocationVO) {
		this.mdmLocationVO = mdmLocationVO;
	}

	/**
	 * @return the mdmLocationVOs
	 */
	public MdmLocationVO[] getMdmLocationVOs() {
		MdmLocationVO[] rtnVOs =  null;
		if(this.mdmLocationVOs != null){
			rtnVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return mdmLocationVOs;
	}

	/**
	 * @param mdmLocationVOs the mdmLocationVOs to set
	 */
	public void setMdmLocationVOs(MdmLocationVO[] mdmLocationVOs) {
		if(mdmLocationVOs != null){
			MdmLocationVO[] tmpVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmLocationVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.mdmLocationVOs = mdmLocationVOs;
	}

	/**
	 * @return the vvdVO
	 */
	public VvdVO getVvdVO() {
		return vvdVO;
	}

	/**
	 * @param vvdVO the vvdVO to set
	 */
	public void setVvdVO(VvdVO vvdVO) {
		this.vvdVO = vvdVO;
	}

	/**
	 * @return the vvdVOs
	 */
	public VvdVO[] getVvdVOs() {
		VvdVO[] rtnVOs =  null;
		if(this.vvdVOs != null){
			rtnVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vvdVOs;
	}

	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if(vvdVOs != null){
			VvdVO[] tmpVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vvdVOs = vvdVOs;
	}

	public UserDefinedLanePortGroupVO getUserDefinedLanePortGroupVO() {
		return userDefinedLanePortGroupVO;
	}

	public void setUserDefinedLanePortGroupVO(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO) {
		this.userDefinedLanePortGroupVO = userDefinedLanePortGroupVO;
	}

	public UserDefinedLanePortGroupVO[] getUserDefinedLanePortGroupVOS() {
		UserDefinedLanePortGroupVO[] rtnVOs =  null;
		if(this.userDefinedLanePortGroupVOs != null){
			rtnVOs = new UserDefinedLanePortGroupVO[userDefinedLanePortGroupVOs.length];
			System.arraycopy(userDefinedLanePortGroupVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return userDefinedLanePortGroupVOs;
	}

	public void setUserDefinedLanePortGroupVOS(UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs) {
		if(userDefinedLanePortGroupVOs != null){
			UserDefinedLanePortGroupVO[] tmpVOs = new UserDefinedLanePortGroupVO[userDefinedLanePortGroupVOs.length];
			System.arraycopy(userDefinedLanePortGroupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.userDefinedLanePortGroupVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.userDefinedLanePortGroupVOs = userDefinedLanePortGroupVOs;
	}
	
}