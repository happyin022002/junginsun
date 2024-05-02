/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyBookingForUpdateVO.java
*@FileTitle : MtyBookingForUpdateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.syscommon.common.table.BkgQuantityVO;

public class RepoBkgForUpdateVO {
	/* BkgBlNoVO Start  */
	private BkgBlNoVO bkgBlNoVO = null;

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/* BkgBlNoVO End  */
	/* RepoBkgVO Start  */
	private RepoBkgVO repoBkgVO = null;

	public void setRepoBkgVO(RepoBkgVO repoBkgVO) {
		this.repoBkgVO = repoBkgVO;
	}

	public RepoBkgVO getRepoBkgVO() {
		return repoBkgVO;
	}
	/* RepoBkgVO End  */	
	
	/* RepoCntrVO Start  */
	private RepoCntrVO repoCntrVO = null;

	public void setRepoCntrVO(RepoCntrVO repoCntrVO) {
		this.repoCntrVO = repoCntrVO;
	}

	public RepoCntrVO getRepoCntrVO() {
		return repoCntrVO;
	}
	
	private RepoCntrVO[] repoCntrVOs = null;

	public void setRepoCntrVOs(RepoCntrVO[] repoCntrVOs) {
		this.repoCntrVOs = repoCntrVOs;
	}

	public RepoCntrVO[] getRepoCntrVOs() {
		return repoCntrVOs;
	}	
	
	private List<RepoCntrVO> repoCntr = null;

	public void setRepoCntr(List<RepoCntrVO> repoCntr) {
		this.repoCntr = repoCntr;
	}

	public List<RepoCntrVO> getRepoCntr() {
		return repoCntr;
	}		

	private List<RepoCntrVO> vlCntr = null;

	public void setVlCntr(List<RepoCntrVO> vlCntr) {
		this.vlCntr = vlCntr;
	}

	public List<RepoCntrVO> getVlCntr() {
		return vlCntr;
	}		
	
	private List<RepoCntrVO> cntrTpSz = null;

	public void setCntrTpSz(List<RepoCntrVO> cntrTpSz) {
		this.cntrTpSz = cntrTpSz;
	}

	public List<RepoCntrVO> getCntrTpSz() {
		return cntrTpSz;
	}			
	/* RepoCntrVO End  */		
	/* BkgQuantityVO Start  */
	
	private List<BkgQuantityVO> bkgQuantity = null;

	public void setBkgQuantity(List<BkgQuantityVO> bkgQuantity) {
		this.bkgQuantity = bkgQuantity;
	}

	public List<BkgQuantityVO> getBkgQuantity() {
		return bkgQuantity;
	}			
	/* BkgQuantityVO End  */	
}
