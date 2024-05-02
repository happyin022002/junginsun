/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1060Event.java
*@FileTitle : Manual Booking Number Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.18 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;



/**
 * ESM_BKG_1060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min, DongJin
 * @see ESM_BKG_1060HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private BkgChnBkgNoGenVO[] bkgChnBkgNoGenVOs = null;
	
	public EsmBkg1060Event(){}

	public ChnMnlBkgNoGenCondVO getChnMnlBkgNoGenCondVO() {
		return chnMnlBkgNoGenCondVO;
	}

	public void setChnMnlBkgNoGenCondVO(ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) {
		this.chnMnlBkgNoGenCondVO = chnMnlBkgNoGenCondVO;
	}

	public BkgChnBkgNoGenVO[] getBkgChnBkgNoGenVOs() {
		return bkgChnBkgNoGenVOs;
	}

	public void setBkgChnBkgNoGenVOs(BkgChnBkgNoGenVO[] bkgChnBkgNoGenVOs) {
		this.bkgChnBkgNoGenVOs = bkgChnBkgNoGenVOs;
	}
	
}