/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022911Event.java
*@FileTitle : e-Booking & SI Process Detail(HBL 2)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.12 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_11 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_11HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_11HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022911Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;
	private BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs = null;
	private BkgBlNoVO bkgBlNoVO = null;
	
	public EsmBkg022911Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}
	
	public BkgUsaCstmsFileNoVO[] getBkgUsaCstmsFileNoVOs() {
		BkgUsaCstmsFileNoVO[] rtnVOs = null;
		if (this.bkgUsaCstmsFileNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgUsaCstmsFileNoVOs, bkgUsaCstmsFileNoVOs.length);
		}
		return rtnVOs;
	}
	
	public void setBkgUsaCstmsFileNoVOs(BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs){
		if(bkgUsaCstmsFileNoVOs != null){
			BkgUsaCstmsFileNoVO[] tmpVOs = Arrays.copyOf(bkgUsaCstmsFileNoVOs, bkgUsaCstmsFileNoVOs.length);
			this.bkgUsaCstmsFileNoVOs = tmpVOs;
		}
	}
	
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

}