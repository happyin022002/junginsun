/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0495Event.java
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.02 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0495 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0495HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0495HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0495Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TSListBy1st2ndVVDListInputVO[] tSListBy1st2ndVVDListInputVOs = null;
	
	private TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO = null;
	
	private TsVvdFor1st2ndInputVO[] tsVvdFor1st2ndInputVOs = null;
	
	private BkgBlNoVO bkgBlNoVO =null;
	
	private BkgBlNoVO[] bkgBlNoVOs =null;
	
	private SendTsListVO sendTsListVO = null;
	private SendTsListVO[] sendTsListVOs = null;
	private String strVvd = null;
	
	public EsmBkg0495Event(){}

	public TSListBy1st2ndVVDListInputVO getTSListBy1st2ndVVDListInputVO() {
		return tSListBy1st2ndVVDListInputVO;
	}

	public void setTSListBy1st2ndVVDListInputVO(
			TSListBy1st2ndVVDListInputVO listBy1st2ndVVDListInputVO) {
		tSListBy1st2ndVVDListInputVO = listBy1st2ndVVDListInputVO;
	}

	public TsVvdFor1st2ndInputVO getTsVvdFor1st2ndInputVO() {
		return tsVvdFor1st2ndInputVO;
	}

	public void setTsVvdFor1st2ndInputVO(TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO) {
		this.tsVvdFor1st2ndInputVO = tsVvdFor1st2ndInputVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public SendTsListVO getSendTsListVO() {
		return sendTsListVO;
	}

	public void setSendTsListVO(SendTsListVO sendTsListVO) {
		this.sendTsListVO = sendTsListVO;
	}

	public String getStrVvd() {
		return strVvd;
	}

	public void setStrVvd(String strVvd) {
		this.strVvd = strVvd;
	}

	public TSListBy1st2ndVVDListInputVO[] gettSListBy1st2ndVVDListInputVOs() {
		TSListBy1st2ndVVDListInputVO[] rtnVOs = null;
		if (this.tSListBy1st2ndVVDListInputVOs != null) {
			rtnVOs = Arrays.copyOf(tSListBy1st2ndVVDListInputVOs,
					tSListBy1st2ndVVDListInputVOs.length);
		}
		return rtnVOs;
	}

	public void settSListBy1st2ndVVDListInputVOs(
			TSListBy1st2ndVVDListInputVO[] tSListBy1st2ndVVDListInputVOs) {
		if (tSListBy1st2ndVVDListInputVOs != null) {
			TSListBy1st2ndVVDListInputVO[] tmpVOs = Arrays.copyOf(tSListBy1st2ndVVDListInputVOs,
					tSListBy1st2ndVVDListInputVOs.length);
			this.tSListBy1st2ndVVDListInputVOs = tmpVOs;
		}
	}

	public TsVvdFor1st2ndInputVO[] getTsVvdFor1st2ndInputVOs() {
		TsVvdFor1st2ndInputVO[] rtnVOs = null;
		if (this.tsVvdFor1st2ndInputVOs != null) {
			rtnVOs = Arrays.copyOf(tsVvdFor1st2ndInputVOs,
					tsVvdFor1st2ndInputVOs.length);
		}
		return rtnVOs;
	}

	public void setTsVvdFor1st2ndInputVOs(
			TsVvdFor1st2ndInputVO[] tsVvdFor1st2ndInputVOs) {
		if (tsVvdFor1st2ndInputVOs != null) {
			TsVvdFor1st2ndInputVO[] tmpVOs = Arrays.copyOf(tsVvdFor1st2ndInputVOs,
					tsVvdFor1st2ndInputVOs.length);
			this.tsVvdFor1st2ndInputVOs = tmpVOs;
		}
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public SendTsListVO[] getSendTsListVOs() {
		SendTsListVO[] rtnVOs = null;
		if (this.sendTsListVOs != null) {
			rtnVOs = Arrays.copyOf(sendTsListVOs, sendTsListVOs.length);
		}
		return rtnVOs;
	}

	public void setSendTsListVOs(SendTsListVO[] sendTsListVOs) {
		if (sendTsListVOs != null) {
			SendTsListVO[] tmpVOs = Arrays.copyOf(sendTsListVOs, sendTsListVOs.length);
			this.sendTsListVOs = tmpVOs;
		}
	}
	
	 

}