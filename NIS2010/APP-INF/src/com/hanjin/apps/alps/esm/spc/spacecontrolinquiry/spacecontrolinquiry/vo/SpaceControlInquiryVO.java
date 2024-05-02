/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpaceControlInquriyVO.java
*@FileTitle : SpaceControlInquriyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.18 최윤성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SpaceControlInquiryVO extends AbstractValueObject{
	
	private static final long serialVersionUID = 1L;
	

	private ConditionVO conditionVO = null;
	private List<DBRowSet> rsList = null;
	private DBRowSet dbRowset = null;
	

	private List<SearchSpaceControlInquiry058VVDListVO> searchSpaceControlInquiry058VVDListVOs = null;
	private List<SearchSpaceControlInquiry058QtyListVO> searchSpaceControlInquiry058QtyListVOs = null;

	
	private List<SearchSpaceControlInquiry058VVDInfoVO> searchSpaceControlInquiry058VVDInfoVOs = null;

	private String eventCommend = null;
	private String saqExistFlg = null;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SpaceControlInquiryVO() {}
	
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public DBRowSet getDbRowset(){
		return dbRowset;
	}
	
	public void setDbRowset(DBRowSet dbRowset){
		this.dbRowset = dbRowset;
	}
	
	public List<DBRowSet> getRsList(){
		return rsList;
	}
	
	public void setRsList(List<DBRowSet> rsList){
		this.rsList = rsList;
	}
	
	public String getEventCommend() {
		return eventCommend;
	}

	public void setEventCommend(String eventCommend) {
		this.eventCommend = eventCommend;
	}

	public List<SearchSpaceControlInquiry058VVDListVO> getSearchSpaceControlInquiry058VVDListVOs() {
		return searchSpaceControlInquiry058VVDListVOs;
	}

	public void setSearchSpaceControlInquiry058VVDListVOs(
			List<SearchSpaceControlInquiry058VVDListVO> searchSpaceControlInquiry058VVDListVOs) {
		this.searchSpaceControlInquiry058VVDListVOs = searchSpaceControlInquiry058VVDListVOs;
	}

	public List<SearchSpaceControlInquiry058QtyListVO> getSearchSpaceControlInquiry058QtyListVOs() {
		return searchSpaceControlInquiry058QtyListVOs;
	}

	public void setSearchSpaceControlInquiry058QtyListVOs(
			List<SearchSpaceControlInquiry058QtyListVO> searchSpaceControlInquiry058QtyListVOs) {
		this.searchSpaceControlInquiry058QtyListVOs = searchSpaceControlInquiry058QtyListVOs;
	}

	public List<SearchSpaceControlInquiry058VVDInfoVO> getSearchSpaceControlInquiry058VVDInfoVOs() {
		return searchSpaceControlInquiry058VVDInfoVOs;
	}

	public void setSearchSpaceControlInquiry058VVDInfoVOs(
			List<SearchSpaceControlInquiry058VVDInfoVO> searchSpaceControlInquiry058VVDInfoVOs) {
		this.searchSpaceControlInquiry058VVDInfoVOs = searchSpaceControlInquiry058VVDInfoVOs;
	}
	
	public String getSaqExistFlg() {
		return saqExistFlg;
	}

	public void setSaqExistFlg(String saqExistFlg) {
		this.saqExistFlg = saqExistFlg;
	}

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
}