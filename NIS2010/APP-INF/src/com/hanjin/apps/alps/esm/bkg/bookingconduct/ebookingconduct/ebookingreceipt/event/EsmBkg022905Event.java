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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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

    private AlpsCmVO[] alpsCmVOs = null;

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

	public void setCmVOs(CmVO[] cmVOs){
		if(cmVOs != null){
			CmVO[] tmpVOs = Arrays.copyOf(cmVOs, cmVOs.length);
			this.cmVOs = tmpVOs;
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

	public void setContainerVOs(ContainerVO[] containerVOs){
		if(containerVOs != null){
			ContainerVO[] tmpVOs = Arrays.copyOf(containerVOs, containerVOs.length);
			this.containerVOs = tmpVOs;
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
	
	public AlpsCmVO[] getAlpsCmVOs() {
		AlpsCmVO[] rtnVOs = null;
		if (this.alpsCmVOs != null) {
			rtnVOs = Arrays.copyOf(alpsCmVOs, alpsCmVOs.length);
		}
		return rtnVOs;
	}

	public void setAlpsCmVOs(AlpsCmVO[] alpsCmVOs){
		if(alpsCmVOs != null){
			AlpsCmVO[] tmpVOs = Arrays.copyOf(alpsCmVOs, alpsCmVOs.length);
			this.alpsCmVOs = tmpVOs;
		}
	}
}