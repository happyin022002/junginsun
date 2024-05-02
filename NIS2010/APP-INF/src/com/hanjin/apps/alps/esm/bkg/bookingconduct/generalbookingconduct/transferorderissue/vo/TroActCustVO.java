package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgTroActRepVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0905 화면에서, EQ tab의 Detail그리드 저장용 Container VO
 * @author 이남경
 * @since J2EE 1.5
 */
public class TroActCustVO {

	List<MdmCustomerVO>   mdmCustomerVO   = new ArrayList<MdmCustomerVO>();
	List<BkgTroActRepVO>  bkgTroActRepVO  = new ArrayList<BkgTroActRepVO>();
	List<BkgTroActCustVO> bkgTroActCustVO = new ArrayList<BkgTroActCustVO>();

	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgTroActRepVO[] bkgTroActRepVOs = null;

	/** Table Value Object Multi Data 처리 */
	private BkgTroActCustVO[] bkgTroActCustVOs = null;
	

	public List<BkgTroActRepVO> getBkgTroActRepVO() {
		return bkgTroActRepVO;
	}

	public void setBkgTroActRepVO(List<BkgTroActRepVO> bkgTroActRepVO) {
		this.bkgTroActRepVO = bkgTroActRepVO;
	}

	public List<BkgTroActCustVO> getBkgTroActCustVO() {
		return bkgTroActCustVO;
	}

	public void setBkgTroActCustVO(List<BkgTroActCustVO> bkgTroActCustVO) {
		this.bkgTroActCustVO = bkgTroActCustVO;
	}

	public BkgTroActRepVO[] getBkgTroActRepVOs() {
		return bkgTroActRepVOs;
	}

	public void setBkgTroActRepVOs(BkgTroActRepVO[] bkgTroActRepVOs) {
		this.bkgTroActRepVOs = bkgTroActRepVOs;
	}

	public BkgTroActCustVO[] getBkgTroActCustVOs() {
		return bkgTroActCustVOs;
	}

	public void setBkgTroActCustVOs(BkgTroActCustVO[] bkgTroActCustVOs) {
		this.bkgTroActCustVOs = bkgTroActCustVOs;
	}

	/**
	 * @return the mdmCustomerVO
	 */
	public List<MdmCustomerVO> getMdmCustomerVO() {
		return mdmCustomerVO;
	}

	/**
	 * @param mdmCustomerVO the mdmCustomerVO to set
	 */
	public void setMdmCustomerVO(List<MdmCustomerVO> mdmCustomerVO) {
		this.mdmCustomerVO = mdmCustomerVO;
	}

	/**
	 * @return the mdmCustomerVOs
	 */
	public MdmCustomerVO[] getMdmCustomerVOs() {
		return mdmCustomerVOs;
	}

	/**
	 * @param mdmCustomerVOs the mdmCustomerVOs to set
	 */
	public void setMdmCustomerVOs(MdmCustomerVO[] mdmCustomerVOs) {
		this.mdmCustomerVOs = mdmCustomerVOs;
	}
}