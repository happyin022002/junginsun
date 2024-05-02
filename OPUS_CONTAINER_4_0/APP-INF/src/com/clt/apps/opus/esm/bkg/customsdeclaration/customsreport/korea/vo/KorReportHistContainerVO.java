package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistDetailVO;

public class KorReportHistContainerVO extends ReportHistDetailVO {

	List<KorTransHistVO> korTransHistVOs = null;
	private static final long serialVersionUID = 1L;

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the korTransHistVOs
	 */
	public List<KorTransHistVO> getKorTransHistVOs() {
		return korTransHistVOs;
	}

	/**
	 * @param korTransHistVOs the korTransHistVOs to set
	 */
	public void setKorTransHistVOs(List<KorTransHistVO> korTransHistVOs) {
		this.korTransHistVOs = korTransHistVOs;
	}
}