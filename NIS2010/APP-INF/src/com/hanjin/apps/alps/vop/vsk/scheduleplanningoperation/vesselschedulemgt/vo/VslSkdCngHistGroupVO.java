/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VslSkdCngHistGroupVO.java
*@FileTitle : VslSkdCngHistGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.08.28 정상기
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정상기
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdCngHistGroupVO {

	private static final long serialVersionUID = 1L;
	
	private List<VskVslSkdVO>		vskVslSkdVOs		= null;
	private List<VslSkdCngHisDtlVO>	vslSkdCngHisDtlVOs	= null;
	private String					sFromEventSystem	= null;
	
	public VslSkdCngHistGroupVO() {}

	/**
	 * @return the vskVslSkdVOs
	 */
	public List<VskVslSkdVO> getVskVslSkdVOs() {
		return vskVslSkdVOs;
	}
	
	/**
	 * @return the vslSkdCngHisDtlVOs
	 */
	public List<VslSkdCngHisDtlVO> getVslSkdCngHisDtlVOs() {
		return vslSkdCngHisDtlVOs;
	}
	
	/**
	 * @return the sFromEventSystem
	 */
	public String getFromEventSystem() {
		return sFromEventSystem;
	}

	/**
	 * @param vskVslSkdVOs the vskVslSkdVOs to set
	 */
	public void setVskVslSkdVOs(List<VskVslSkdVO> vskVslSkdVOs) {
		this.vskVslSkdVOs = vskVslSkdVOs;
	}
	/**
	 * @param vslSkdCngHisDtlVOs the vslSkdCngHisDtlVOs to set
	 */
	public void setVslSkdCngHisDtlVOs(List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs) {
		this.vslSkdCngHisDtlVOs = vslSkdCngHisDtlVOs;
	}
	
	/**
	 * @param the sFromEventSystem
	 */
	public void setFromEventSystem(String sFromEventSystem) {
		this.sFromEventSystem	= sFromEventSystem;
	}
		
}