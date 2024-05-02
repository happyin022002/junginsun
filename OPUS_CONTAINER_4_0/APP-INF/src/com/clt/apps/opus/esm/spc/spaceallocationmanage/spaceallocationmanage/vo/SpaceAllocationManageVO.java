/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpaceAllocationManageVO.java
*@FileTitle : SpaceAllocationManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.18 최윤성 
* 1.0 Creation
* 2011.05.03 이석준 [CHM-201110568-01] Bottleneck Check 화면 조건 보완
                                   - SearchSpaceAllocationManage045VVDInfoVO 추가 
=========================================================*/

package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SpaceAllocationManageVO extends AbstractValueObject{
	
	private static final long serialVersionUID = 1L;
	
	private List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocation0042DetailListVOs = null;
	private List<SpaceAllocationManageTempListVO> spaceAllocationManageTempListVOs = null;
	private ConditionVO conditionVO = null;
	private List<DBRowSet> rsList = null;
	private DBRowSet dbRowset = null;
	
	private List<SearchSpaceAllocation0047MasterListVO> searchSpaceAllocation0047MasterListVOs = null;
	private List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailListVOs = null;
	
	private List<SearchSpaceAllocation0044MasterListVO> searchSpaceAllocation0044MasterListVOs = null;
	private List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailListVOs = null;
	
	private List<SearchSpaceAllocationManage045VVDListVO> searchSpaceAllocationManage045VVDListVOs = null;
	private List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyListVOs = null;
	
	private List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocation0053ManageListVOs = null;
	
	private List<SearchSpaceAllocationModelRun0054ListVO> searchSpaceAllocationModelRun0054ListVOs = null;
	
	private List<SearchSpaceAllocationModelListVO> searchSpaceAllocationModelListVOs = null;
	
	private List<SearchNoShowAdjustmentListVO> searchNoShowAdjustmentListVOs = null;
	private List<SearchNoShowDownloadDateListVO> searchNoShowDownloadDateListVOs = null;
	
	private List<SearchSpaceAllocationManage045VVDInfoVO> searchSpaceAllocationManage045VVDInfoVOs = null;

	private String eventCommend = null;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SpaceAllocationManageVO() {}
	
	public List<SearchSpaceAllocation0042DetailListVO> getSearchSpaceAllocation0042DetailListVOs() {
		return searchSpaceAllocation0042DetailListVOs;
	}
	
	public void setSearchSpaceAllocation0042DetailListVOs(List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocation0042DetailListVOs) {
		this.searchSpaceAllocation0042DetailListVOs = searchSpaceAllocation0042DetailListVOs;
	}
	
	public List<SpaceAllocationManageTempListVO> getSpaceAllocationManageTempListVOs() {
		return spaceAllocationManageTempListVOs;
	}
	
	public void setSpaceAllocationManageTempListVOs(List<SpaceAllocationManageTempListVO> spaceAllocationManageTempListVOs) {
		this.spaceAllocationManageTempListVOs = spaceAllocationManageTempListVOs;
	}
	
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
	
	public List<SearchSpaceAllocation0047MasterListVO> getSearchSpaceAllocation0047MasterListVOs() {
		return searchSpaceAllocation0047MasterListVOs;
	}

	public void setSearchSpaceAllocation0047MasterListVOs(
			List<SearchSpaceAllocation0047MasterListVO> searchSpaceAllocation0047MasterListVOs) {
		this.searchSpaceAllocation0047MasterListVOs = searchSpaceAllocation0047MasterListVOs;
	}

	public List<SearchSpaceAllocation0047DetailListVO> getSearchSpaceAllocation0047DetailListVOs() {
		return searchSpaceAllocation0047DetailListVOs;
	}

	public void setSearchSpaceAllocation0047DetailListVOs(
			List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailListVOs) {
		this.searchSpaceAllocation0047DetailListVOs = searchSpaceAllocation0047DetailListVOs;
	}

	public List<SearchSpaceAllocation0044MasterListVO> getSearchSpaceAllocation0044MasterListVOs() {
		return searchSpaceAllocation0044MasterListVOs;
	}

	public void setSearchSpaceAllocation0044MasterListVOs(
			List<SearchSpaceAllocation0044MasterListVO> searchSpaceAllocation0044MasterListVOs) {
		this.searchSpaceAllocation0044MasterListVOs = searchSpaceAllocation0044MasterListVOs;
	}

	public List<SearchSpaceAllocation0044DetailListVO> getSearchSpaceAllocation0044DetailListVOs() {
		return searchSpaceAllocation0044DetailListVOs;
	}

	public void setSearchSpaceAllocation0044DetailListVOs(
			List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailListVOs) {
		this.searchSpaceAllocation0044DetailListVOs = searchSpaceAllocation0044DetailListVOs;
	}

	public String getEventCommend() {
		return eventCommend;
	}

	public void setEventCommend(String eventCommend) {
		this.eventCommend = eventCommend;
	}

	public List<SearchSpaceAllocation0053ManageListVO> getSearchSpaceAllocation0053ManageListVOs() {
		return searchSpaceAllocation0053ManageListVOs;
	}

	public void setSearchSpaceAllocation0053ManageListVOs(
			List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocation0053ManageListVOs) {
		this.searchSpaceAllocation0053ManageListVOs = searchSpaceAllocation0053ManageListVOs;
	}
	
	public List<SearchSpaceAllocationModelRun0054ListVO> getSearchSpaceAllocationModelRun0054ListVOs() {
		return searchSpaceAllocationModelRun0054ListVOs;
	}

	public void setSearchSpaceAllocationModelRun0054ListVOs(
			List<SearchSpaceAllocationModelRun0054ListVO> searchSpaceAllocationModelRun0054ListVOs) {
		this.searchSpaceAllocationModelRun0054ListVOs = searchSpaceAllocationModelRun0054ListVOs;
	}
	
	public List<SearchSpaceAllocationModelListVO> getSearchSpaceAllocationModelListVOs() {
		return searchSpaceAllocationModelListVOs;
	}

	public void setSearchSpaceAllocationModelListVOs(
			List<SearchSpaceAllocationModelListVO> searchSpaceAllocationModelListVOs) {
		this.searchSpaceAllocationModelListVOs = searchSpaceAllocationModelListVOs;
	}

	public List<SearchSpaceAllocationManage045VVDListVO> getSearchSpaceAllocationManage045VVDListVOs() {
		return searchSpaceAllocationManage045VVDListVOs;
	}

	public void setSearchSpaceAllocationManage045VVDListVOs(
			List<SearchSpaceAllocationManage045VVDListVO> searchSpaceAllocationManage045VVDListVOs) {
		this.searchSpaceAllocationManage045VVDListVOs = searchSpaceAllocationManage045VVDListVOs;
	}

	public List<SearchSpaceAllocationManage045QtyListVO> getSearchSpaceAllocationManage045QtyListVOs() {
		return searchSpaceAllocationManage045QtyListVOs;
	}

	public void setSearchSpaceAllocationManage045QtyListVOs(
			List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyListVOs) {
		this.searchSpaceAllocationManage045QtyListVOs = searchSpaceAllocationManage045QtyListVOs;
	}

	public List<SearchNoShowAdjustmentListVO> getSearchNoShowAdjustmentListVOs() {
		return searchNoShowAdjustmentListVOs;
	}

	public void setSearchNoShowAdjustmentListVOs(
			List<SearchNoShowAdjustmentListVO> searchNoShowAdjustmentListVOs) {
		this.searchNoShowAdjustmentListVOs = searchNoShowAdjustmentListVOs;
	}

	public List<SearchNoShowDownloadDateListVO> getSearchNoShowDownloadDateListVOs() {
		return searchNoShowDownloadDateListVOs;
	}

	public void setSearchNoShowDownloadDateListVOs(
			List<SearchNoShowDownloadDateListVO> searchNoShowDownloadDateListVOs) {
		this.searchNoShowDownloadDateListVOs = searchNoShowDownloadDateListVOs;
	}
	
	public List<SearchSpaceAllocationManage045VVDInfoVO> getSearchSpaceAllocationManage045VVDInfoVOs() {
		return searchSpaceAllocationManage045VVDInfoVOs;
	}

	public void setSearchSpaceAllocationManage045VVDInfoVOs(
			List<SearchSpaceAllocationManage045VVDInfoVO> searchSpaceAllocationManage045VVDInfoVOs) {
		this.searchSpaceAllocationManage045VVDInfoVOs = searchSpaceAllocationManage045VVDInfoVOs;
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