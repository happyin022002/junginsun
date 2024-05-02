/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9424Event.java
*@FileTitle : Empty Repo BKG Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.18 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9424 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9424HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_9424HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9424Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	
	/** Table Value Object Multi Data 처리 */


	public EsmBkg9424Event(){}
	
	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this.bkgBlNoVO = bkgBlNoVO;
	}	
	
	private String cntrNo = null;

	public void setCntrNo(String cntrNo){
		this. cntrNo = cntrNo;
	}

	public String getCntrNo(){
		return cntrNo;
	}		
	
	private RepoBkgVO repoBkgVO = null;
	
	public RepoBkgVO getRepoBkgVO(){
		return repoBkgVO;
	}

	public void setRepoBkgVO(RepoBkgVO repoBkgVO){
		this.repoBkgVO = repoBkgVO;
	}		
	
	private RepoCntrVO[] repoCntrVOs = null;
	
	public RepoCntrVO[] getRepoCntrVOs(){
		RepoCntrVO[] tmpVOs = null;
		if (this. repoCntrVOs != null) {
			tmpVOs = Arrays.copyOf(repoCntrVOs, repoCntrVOs .length);
		}
		return tmpVOs;
	}

	public void setRepoCntrVOs(RepoCntrVO[] repoCntrVOs){
		if (repoCntrVOs != null) {
			RepoCntrVO[] tmpVOs = Arrays.copyOf(repoCntrVOs, repoCntrVOs .length);
			this. repoCntrVOs = tmpVOs;
		}
	}			
	
	String mvmtOption = null;

	public void setMvmtOption(String mvmtOption){
		this. mvmtOption = mvmtOption;
	}

	public String getMvmtOption(){
		return mvmtOption;
	}
	
	String trunkVvd = null;

	public void setTrunkVvd(String trunkVvd){
		this. trunkVvd = trunkVvd;
	}

	public String getTrunkVvd(){
		return trunkVvd;
	}
	
	
	String bkgMvmtCd = null;

	public void setBkgMvmtCd(String bkgMvmtCd){
		this. bkgMvmtCd = bkgMvmtCd;
	}

	public String getBkgMvmtCd(){
		return bkgMvmtCd;
	}	
}