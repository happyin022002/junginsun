/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0721Event.java
*@FileTitle : Cut Off Time
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.11 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgClzTmVO;


/**
 * ESM_BKG_0721 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0721HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0721HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0721Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ClzTmListVO clzListTmVO = null;

	/** Table Value Object Multi Data 처리 */
	private ClzTmListVO[] clzListTmVOs = null;

	private BkgClzTmVO bkgClzTmVO = null;

	private BkgClzTmVO[] bkgClzTmVOs = null;

	private BkgBlNoVO bkgBlNoVO = null;

	private BkgBlNoVO[] bkgBlNoVOs = null;


	private String bdrFlag = null;

	public EsmBkg0721Event(){}


	public String getBdrFlag() {
		return bdrFlag;
	}

	public void setBdrFlag(String bdrFlag) {
		this.bdrFlag = bdrFlag;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
	}

	public ClzTmListVO getClzListTmVO() {
		return clzListTmVO;
	}

	public void setClzListTmVO(ClzTmListVO clzListTmVO) {
		this.clzListTmVO = clzListTmVO;
	}

	public ClzTmListVO[] getClzListTmVOs() {
		ClzTmListVO[] tmpVOs = null;
		if (this. clzListTmVOs != null) {
			tmpVOs = Arrays.copyOf(clzListTmVOs, clzListTmVOs .length);
		}
		return tmpVOs;
	}

	public void setClzListTmVOs(ClzTmListVO[] clzListTmVOs) {
		if (clzListTmVOs != null) {
			ClzTmListVO[] tmpVOs = Arrays.copyOf(clzListTmVOs, clzListTmVOs .length);
			this. clzListTmVOs = tmpVOs;
		}
	}

	public BkgClzTmVO getBkgClzTmVO() {
		return bkgClzTmVO;
	}

	public void setBkgClzTmVO(BkgClzTmVO bkgClzTmVO) {
		this.bkgClzTmVO = bkgClzTmVO;
	}

	public BkgClzTmVO[] getBkgClzTmVOs() {
		BkgClzTmVO[] tmpVOs = null;
		if (this. bkgClzTmVOs != null) {
			tmpVOs = Arrays.copyOf(bkgClzTmVOs, bkgClzTmVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgClzTmVOs(BkgClzTmVO[] bkgClzTmVOs) {
		if (bkgClzTmVOs != null) {
			BkgClzTmVO[] tmpVOs = Arrays.copyOf(bkgClzTmVOs, bkgClzTmVOs .length);
			this. bkgClzTmVOs = tmpVOs;
		}
	}



}