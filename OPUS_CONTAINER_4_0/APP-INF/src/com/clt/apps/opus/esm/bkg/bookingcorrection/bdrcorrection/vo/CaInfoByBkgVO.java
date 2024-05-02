package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0079_02A 화면에서, 조회용 Container VO
 * @author 이남경
 * @since J2EE 1.5
 */
public class CaInfoByBkgVO {

	CaBkgInfoVO         caBkgInfoVO       = null;
	List<CaListByBkgVO> caListByBkgVOs = new ArrayList<CaListByBkgVO>();
	/**
	 * @return the caBkgInfoVO
	 */
	public CaBkgInfoVO getCaBkgInfoVO() {
		return caBkgInfoVO;
	}
	/**
	 * @param caBkgInfoVO the caBkgInfoVO to set
	 */
	public void setCaBkgInfoVO(CaBkgInfoVO caBkgInfoVO) {
		this.caBkgInfoVO = caBkgInfoVO;
	}
	/**
	 * @return the caListByBkgVOs
	 */
	public List<CaListByBkgVO> getCaListByBkgVOs() {
		return caListByBkgVOs;
	}
	/**
	 * @param caListByBkgVOs the caListByBkgVOs to set
	 */
	public void setCaListByBkgVOs(List<CaListByBkgVO> caListByBkgVOs) {
		this.caListByBkgVOs = caListByBkgVOs;
	}


}