/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0237Event.java
*@FileTitle : e-Booking & SI Set Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.19 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemTpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgCustChkPntVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0237 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0237HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0237HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0237Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String  chkPntTpCd  = null;
	private String  chkPntItmSeq  = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCustChkPntVO bkgCustChkPntVO = null;
	private BkgChkPntItemVO bkgChkPntItemVO = null;
	private BkgChkPntItemTpVO bkgChkPntItemTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCustChkPntVO[] bkgCustChkPntVOs = null;
	private BkgChkPntItemVO[] bkgChkPntItemVOs = null;
	private BkgChkPntItemTpVO[] bkgChkPntItemTpVOs = null;

	public EsmBkg0237Event(){}
	

	public String getChkPntTpCd() {
		return chkPntTpCd;
	}

	public void setChkPntTpCd(String chkPntTpCd) {
		this.chkPntTpCd = chkPntTpCd;
	}

	public String getChkPntItmSeq() {
		return chkPntItmSeq;
	}

	public void setChkPntItmSeq(String chkPntItmSeq) {
		this.chkPntItmSeq = chkPntItmSeq;
	}

	public BkgCustChkPntVO getBkgCustChkPntVO(){
		return bkgCustChkPntVO;
	}
	
	public void setBkgCustChkPntVO(BkgCustChkPntVO bkgCustChkPntVO){
		this. bkgCustChkPntVO = bkgCustChkPntVO;
	}
	
	public BkgChkPntItemVO getBkgChkPntItemVO() {
		return bkgChkPntItemVO;
	}


	public void setBkgChkPntItemVO(BkgChkPntItemVO bkgChkPntItemVO) {
		this.bkgChkPntItemVO = bkgChkPntItemVO;
	}


	public BkgChkPntItemTpVO getBkgChkPntItemTpVO() {
		return bkgChkPntItemTpVO;
	}


	public void setBkgChkPntItemTpVO(BkgChkPntItemTpVO bkgChkPntItemTpVO) {
		this.bkgChkPntItemTpVO = bkgChkPntItemTpVO;
	}

	public void setBkgCustChkPntVOs(BkgCustChkPntVO[] bkgCustChkPntVOs){
		if(bkgCustChkPntVOs != null){
			BkgCustChkPntVO[] tmpVOs = Arrays.copyOf(bkgCustChkPntVOs, bkgCustChkPntVOs.length);
			this.bkgCustChkPntVOs = tmpVOs;
		}
	}	


	public BkgCustChkPntVO[] getBkgCustChkPntVOs(){
		BkgCustChkPntVO[] rtnVOs = null;
		if (this.bkgCustChkPntVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCustChkPntVOs, bkgCustChkPntVOs.length);
		}
		return rtnVOs;
	}


	public BkgChkPntItemVO[] getBkgChkPntItemVOs() {		
		BkgChkPntItemVO[] rtnVOs = null;
		if (this.bkgChkPntItemVOs != null) {
			rtnVOs = Arrays.copyOf(bkgChkPntItemVOs, bkgChkPntItemVOs.length);
		}		
		return rtnVOs;
	}


	public void setBkgChkPntItemVOs(BkgChkPntItemVO[] bkgChkPntItemVOs) {		
		if(bkgChkPntItemVOs != null){
			BkgChkPntItemVO[] tmpVOs = Arrays.copyOf(bkgChkPntItemVOs, bkgChkPntItemVOs.length);
			this.bkgChkPntItemVOs = tmpVOs;
		}		
	}


	public BkgChkPntItemTpVO[] getBkgChkPntItemTpVOs() {		
		BkgChkPntItemTpVO[] rtnVOs = null;
		if (this.bkgChkPntItemTpVOs != null) {
			rtnVOs = Arrays.copyOf(bkgChkPntItemTpVOs, bkgChkPntItemTpVOs.length);
		}		
		return rtnVOs;
	}


	public void setBkgChkPntItemTpVOs(BkgChkPntItemTpVO[] bkgChkPntItemTpVOs) {		
		if(bkgChkPntItemTpVOs != null){
			BkgChkPntItemTpVO[] tmpVOs = Arrays.copyOf(bkgChkPntItemTpVOs, bkgChkPntItemTpVOs.length);
			this.bkgChkPntItemTpVOs = tmpVOs;
		}				
	}


}