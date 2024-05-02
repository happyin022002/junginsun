/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022903Event.java
*@FileTitle : e-Booking & SI Process Detail(CONTAINER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.10 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;


/**
 * ESM_BKG_0229_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022903Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    private CntrEtcInfoVO bkgEtcInfoVO = null;
    private CntrEtcInfoVO[] bkgEtcInfoVOs = null;
    private ContainerVO containerVO = null;
    private ContainerVO[] containerVOs = null;
    private BkgCntrSealNoVO bkgCntrSealNoVO = null;
    private BkgCntrSealNoVO[] bkgCntrSealNoVOs = null;
    private BkgBookingInfoVO bkgBookingInfoVO = null;

    private String bkgNo = null;

	private BkgBlNoVO bkgBlNoVO = null;
	private XterRqstNoVO xterRqstNoVO= null;

	//cntr tpsz 조회
	private String cntrNo = null;

	public EsmBkg022903Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public CntrEtcInfoVO getBkgEtcInfoVO() {
		return bkgEtcInfoVO;
	}

	public void setBkgEtcInfoVO(CntrEtcInfoVO bkgEtcInfoVO) {
		this.bkgEtcInfoVO = bkgEtcInfoVO;
	}

	public CntrEtcInfoVO[] getBkgEtcInfoVOs() {
		CntrEtcInfoVO[] rtnVOs = null;
		if (this.bkgEtcInfoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgEtcInfoVOs, bkgEtcInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgEtcInfoVOs(CntrEtcInfoVO[] bkgEtcInfoVOs){
		if(bkgEtcInfoVOs != null){
			CntrEtcInfoVO[] tmpVOs = Arrays.copyOf(bkgEtcInfoVOs, bkgEtcInfoVOs.length);
			this.bkgEtcInfoVOs = tmpVOs;
		}
	}

	public ContainerVO getContainerVO() {
		return containerVO;
	}

	public void setContainerVO(ContainerVO containerVO) {
		this.containerVO = containerVO;
	}

	public ContainerVO[] getContainerVOs() {
		ContainerVO[] rtnVOs = null;
		if (this.containerVOs != null) {
			rtnVOs = Arrays.copyOf(containerVOs, containerVOs.length);
		}
		return rtnVOs;
	}

	public void setContainerVOs(ContainerVO[] containerVOs){
		if(containerVOs != null){
			ContainerVO[] tmpVOs = Arrays.copyOf(containerVOs, containerVOs.length);
			this.containerVOs = tmpVOs;
		}
	}

	public BkgCntrSealNoVO getBkgCntrSealNoVO() {
		return bkgCntrSealNoVO;
	}

	public void setBkgCntrSealNoVO(BkgCntrSealNoVO bkgCntrSealNoVO) {
		this.bkgCntrSealNoVO = bkgCntrSealNoVO;
	}

	public BkgCntrSealNoVO[] getBkgCntrSealNoVOs() {
		BkgCntrSealNoVO[] rtnVOs = null;
		if (this.bkgCntrSealNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCntrSealNoVOs, bkgCntrSealNoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCntrSealNoVOs(BkgCntrSealNoVO[] bkgCntrSealNoVOs){
		if(bkgCntrSealNoVOs != null){
			BkgCntrSealNoVO[] tmpVOs = Arrays.copyOf(bkgCntrSealNoVOs, bkgCntrSealNoVOs.length);
			this.bkgCntrSealNoVOs = tmpVOs;
		}
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public BkgBookingInfoVO getBkgBookingInfoVO() {
		return bkgBookingInfoVO;
	}

	public void setBkgBookingInfoVO(BkgBookingInfoVO bkgBookingInfoVO) {
		this.bkgBookingInfoVO = bkgBookingInfoVO;
	}

    public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
}