/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0017Event.java
*@FileTitle : VopVsk0017Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.19 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdBerthWdoVO cstSkdBerthWdoVO = null;
	private YardVO yardVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdBerthWdoVO[] cstSkdBerthWdoVOs = null;
	private YardVO[] yardVOs = null;
	
	public VopVsk0017Event(){}

	/**
	 * @return the cstSkdBerthWdoVO
	 */
	public CstSkdBerthWdoVO getCstSkdBerthWdoVO() {
		return cstSkdBerthWdoVO;
	}

	/**
	 * @param cstSkdBerthWdoVO the cstSkdBerthWdoVO to set
	 */
	public void setCstSkdBerthWdoVO(CstSkdBerthWdoVO cstSkdBerthWdoVO) {
		this.cstSkdBerthWdoVO = cstSkdBerthWdoVO;
	}

	/**
	 * @return the yardVO
	 */
	public YardVO getYardVO() {
		return yardVO;
	}

	/**
	 * @param yardVO the yardVO to set
	 */
	public void setYardVO(YardVO yardVO) {
		this.yardVO = yardVO;
	}

	/**
	 * @return the cstSkdBerthWdoVOs
	 */
	public CstSkdBerthWdoVO[] getCstSkdBerthWdoVOs() {
		CstSkdBerthWdoVO[] rtnVOs =  null;
		if(this.cstSkdBerthWdoVOs != null){
			rtnVOs = new CstSkdBerthWdoVO[cstSkdBerthWdoVOs.length];
			System.arraycopy(cstSkdBerthWdoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return cstSkdBerthWdoVOs;
	}

	/**
	 * @param cstSkdBerthWdoVOs the cstSkdBerthWdoVOs to set
	 */
	public void setCstSkdBerthWdoVOs(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs) {
		if(cstSkdBerthWdoVOs != null){
			CstSkdBerthWdoVO[] tmpVOs = new CstSkdBerthWdoVO[cstSkdBerthWdoVOs.length];
			System.arraycopy(cstSkdBerthWdoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstSkdBerthWdoVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.cstSkdBerthWdoVOs = cstSkdBerthWdoVOs;
	}

	/**
	 * @return the yardVOs
	 */
	public YardVO[] getYardVOs() {
		YardVO[] rtnVOs =  null;
		if(this.yardVOs != null){
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return yardVOs;
	}

	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if(yardVOs != null){
			YardVO[] tmpVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.yardVOs = yardVOs;
	}
	
}