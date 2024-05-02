/**
 * 
 */
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryDetailListVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * @author user
 * 
 */
public class AmsRailListVO extends AbstractValueObject {
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
	private List<RailHistoryDetailListVO> blList;	
	private RailHistoryDetailListVO header;
	private List<RailHistoryDetailListVO> detailList;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public AmsRailListVO() {}
	
	public List<RailHistoryDetailListVO> getBlList() {
		return blList;
	}
	public void setBlList(List<RailHistoryDetailListVO> blList) {
		this.blList = blList;
	}

	public RailHistoryDetailListVO getHeader() {
		return header;
	}
	public void setHeader(RailHistoryDetailListVO header) {
		this.header = header;
	}
	

	public List<RailHistoryDetailListVO> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<RailHistoryDetailListVO> detailList) {
		this.detailList = detailList;
	}

}
