/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022910Event.java
*@FileTitle : e-Booking & SI Process Detail(HBL 1)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.15 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_10 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_10HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_10HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022910Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO = null;
	/** Table Value Object Multi Data 처리 */
	private XterRqstNoVO[] xterRqstNoVOs = null;
	
	private HblVO hblVO = null;	
	private BkgBlNoVO bkgBlNoVO = null;
	private String bkgNo = null;

	public EsmBkg022910Event(){}

	public HblVO getHblVO() {
		return hblVO;
	}

	public void setHblVO(HblVO hblVO) {
		this.hblVO = hblVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO){
		this. xterRqstNoVO = xterRqstNoVO;
	}

	public void setXterRqstNoVOS(XterRqstNoVO[] xterRqstNoVOs){
		if(xterRqstNoVOs != null){
			XterRqstNoVO[] tmpVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
			this.xterRqstNoVOs  = tmpVOs;
		}
	}

	public XterRqstNoVO getXterRqstNoVO(){
		return xterRqstNoVO;
	}

	public XterRqstNoVO[] getXterRqstNoVOS(){
		XterRqstNoVO[] rtnVOs = null;
		if (this.xterRqstNoVOs != null) {
			rtnVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
		}
		return rtnVOs;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
}