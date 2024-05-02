/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1015Event.java
*@FileTitle : Relay Vessel Group Assign by relay Port_VVD Assign
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.21 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;


/**
 * ESM_BKG_1015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_1015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	private String assignTpCd = null;
	private String formerTrnkFlg = null;
	private String nextTrnkFlg = null;

	public EsmBkg1015Event(){}

	public String getAssignTpCd() {
		return assignTpCd;
	}

	public void setAssignTpCd(String assignTpCd) {
		this.assignTpCd = assignTpCd;
	}

	public String getFormerTrnkFlg() {
		return formerTrnkFlg;
	}

	public void setFormerTrnkFlg(String formerTrnkFlg) {
		this.formerTrnkFlg = formerTrnkFlg;
	}

	public String getNextTrnkFlg() {
		return nextTrnkFlg;
	}

	public void setNextTrnkFlg(String nextTrnkFlg) {
		this.nextTrnkFlg = nextTrnkFlg;
	}
	
	 

}