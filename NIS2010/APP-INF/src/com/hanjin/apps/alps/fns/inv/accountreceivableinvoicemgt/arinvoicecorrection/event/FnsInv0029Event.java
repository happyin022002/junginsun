/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0029Event.java
*@FileTitle : Manual System Clear
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.04 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvArChgVO;


/**
 * FNS_INV_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
	
	private String ifNo1 = "";
	private String ifNo2 = "";
	private String ifNo3 = "";
	private String ifNo4 = "";
	private String ifNo5 = "";
	private String ifNo6 = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SysClearVO sysClearVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArChgVO[] invArChgVOs = null;

	public FnsInv0029Event(){}
	
	public void setInvArChgVOS(InvArChgVO[] invArChgVOs){
		this. invArChgVOs = invArChgVOs;
	}

	/**
	 * @return the ifNo5
	 */
	public String getIfNo5() {
		return ifNo5;
	}

	/**
	 * @param ifNo5 the ifNo5 to set
	 */
	public void setIfNo5(String ifNo5) {
		this.ifNo5 = ifNo5;
	}

	/**
	 * @return the ifNo6
	 */
	public String getIfNo6() {
		return ifNo6;
	}

	/**
	 * @param ifNo6 the ifNo6 to set
	 */
	public void setIfNo6(String ifNo6) {
		this.ifNo6 = ifNo6;
	}

	/**
	 * @return the ifNo1
	 */
	public String getIfNo1() {
		return ifNo1;
	}

	/**
	 * @param ifNo1 the ifNo1 to set
	 */
	public void setIfNo1(String ifNo1) {
		this.ifNo1 = ifNo1;
	}

	/**
	 * @return the ifNo2
	 */
	public String getIfNo2() {
		return ifNo2;
	}

	/**
	 * @param ifNo2 the ifNo2 to set
	 */
	public void setIfNo2(String ifNo2) {
		this.ifNo2 = ifNo2;
	}

	/**
	 * @return the ifNo3
	 */
	public String getIfNo3() {
		return ifNo3;
	}

	/**
	 * @param ifNo3 the ifNo3 to set
	 */
	public void setIfNo3(String ifNo3) {
		this.ifNo3 = ifNo3;
	}

	/**
	 * @return the ifNo4
	 */
	public String getIfNo4() {
		return ifNo4;
	}

	/**
	 * @param ifNo4 the ifNo4 to set
	 */
	public void setIfNo4(String ifNo4) {
		this.ifNo4 = ifNo4;
	}

	public InvArChgVO[] getInvArChgVOS(){
		return invArChgVOs;
	}

	public SysClearVO getSysClearVo() {
		return sysClearVo;
	}

	public void setSysClearVo(SysClearVO sysClearVo) {
		this.sysClearVo = sysClearVo;
	}

}