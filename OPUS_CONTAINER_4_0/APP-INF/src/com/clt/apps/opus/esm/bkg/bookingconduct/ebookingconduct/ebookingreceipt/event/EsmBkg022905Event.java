/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022905Event.java
*@FileTitle : e-Booking & SI Process Detail(C/M)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.17 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrShpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_05HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022905Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;
	private CmVO cmVO = null;
	private CmVO[] cmVOs = null;

    private String bkgNo = null;
    private String cntrNo = null;

	private BkgBlNoVO bkgBlNoVO = null;

    private ContainerVO[] containerVOs = null;

    private OpusCmVO[] opusCmVOs = null;
    private BkgCntrShpVO[] bkgCntrShpVOs = null;
    
	public EsmBkg022905Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public CmVO getCmVO() {
		return cmVO;
	}

	public void setCmVO(CmVO cmVO) {
		this.cmVO = cmVO;
	}

	public CmVO[] getCmVOs() {
		CmVO[] rtnVOs = null;
		if (this.cmVOs != null) {
			rtnVOs = Arrays.copyOf(cmVOs, cmVOs.length);
		}
		return rtnVOs;
	}

	public void setCmVOs(CmVO[] cmVOs) {
		if(cmVOs != null){
			CmVO[] tmpVOs = Arrays.copyOf(cmVOs, cmVOs.length);
			this.cmVOs  = tmpVOs;
		}
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public void setContainerVOs(ContainerVO[] containerVOs) {
		if(containerVOs != null){
			ContainerVO[] tmpVOs = Arrays.copyOf(containerVOs, containerVOs.length);
			this.containerVOs  = tmpVOs;
		}
	}
	
	public ContainerVO[] getContainerVOs() {
		ContainerVO[] rtnVOs = null;
		if (this.containerVOs != null) {
			rtnVOs = Arrays.copyOf(containerVOs, containerVOs.length);
		}
		return rtnVOs;
	}

    public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
	public OpusCmVO[] getOpusCmVOs() {
		OpusCmVO[] rtnVOs = null;
		if (this.opusCmVOs != null) {
			rtnVOs = Arrays.copyOf(opusCmVOs, opusCmVOs.length);
		}
		return rtnVOs;
	}

	public void setOpusCmVOs(OpusCmVO[] opusCmVOs) {
		if(opusCmVOs != null){
			OpusCmVO[] tmpVOs = Arrays.copyOf(opusCmVOs, opusCmVOs.length);
			this.opusCmVOs  = tmpVOs;
		}
	}

	public BkgCntrShpVO[] getBkgCntrShpVOs() {
		BkgCntrShpVO[] rtnVOs = null;
		if (this.bkgCntrShpVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCntrShpVOs, bkgCntrShpVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCntrShpVOs(BkgCntrShpVO[] bkgCntrShpVOs) {
		if(bkgCntrShpVOs != null){
			BkgCntrShpVO[] tmpVOs = Arrays.copyOf(bkgCntrShpVOs, bkgCntrShpVOs.length);
			this.bkgCntrShpVOs  = tmpVOs;
		}
	}
}