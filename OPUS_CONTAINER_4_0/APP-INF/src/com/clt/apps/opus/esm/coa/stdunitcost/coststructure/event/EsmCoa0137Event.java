/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0137Event.java
*@FileTitle : Node/Link U/C Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.02
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.08.02 임옥영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.TableColumnVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0137 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0137HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author OK-YOUNG IM
 * @see ESM_COA_0137HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0137Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NodLnkCostCodeVO nodLnkCostCodeVO = null;
	/** Table Value Object Multi Data 처리 */
	private NodLnkCostCodeVO[] nodLnkCostCodeVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TableColumnVO tableColumnVO = null;
	/** Table Value Object Multi Data 처리 */
	private TableColumnVO[] tableColumnVOs = null;
	/**조회조건 f_table_name**/
	private String  fTableName = null;
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	public EsmCoa0137Event(){}

	/**
	 * @return the nodLnkCostCodeVO
	 */
	public NodLnkCostCodeVO getNodLnkCostCodeVO() {
		return nodLnkCostCodeVO;
	}

	/**
	 * @param nodLnkCostCodeVO the nodLnkCostCodeVO to set
	 */
	public void setNodLnkCostCodeVO(NodLnkCostCodeVO nodLnkCostCodeVO) {
		this.nodLnkCostCodeVO = nodLnkCostCodeVO;
	}

	/**
	 * @return the nodLnkCostCodeVOs											//SJH.20150508.소스품질
	 */
	public NodLnkCostCodeVO[] getNodLnkCostCodeVOs() {
		NodLnkCostCodeVO[] rtnVOs = null;
		if (this.nodLnkCostCodeVOs != null) {
			rtnVOs = Arrays.copyOf(nodLnkCostCodeVOs, nodLnkCostCodeVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param nodLnkCostCodeVOs the nodLnkCostCodeVOs to set					//SJH.20150508.소스품질
	 */
	public void setNodLnkCostCodeVOs(NodLnkCostCodeVO[] nodLnkCostCodeVOs){
		if(nodLnkCostCodeVOs != null){
			NodLnkCostCodeVO[] tmpVOs = Arrays.copyOf(nodLnkCostCodeVOs, nodLnkCostCodeVOs.length);
			this.nodLnkCostCodeVOs = tmpVOs;
		}
	}

	/**
	 * @return the tableColumnVO
	 */
	public TableColumnVO getTableColumnVO() {
		return tableColumnVO;
	}

	/**
	 * @param tableColumnVO the tableColumnVO to set
	 */
	public void setTableColumnVO(TableColumnVO tableColumnVO) {
		this.tableColumnVO = tableColumnVO;
	}

	/**
	 * @return the tableColumnVOs													//SJH.20150508.소스품질
	 */
	public TableColumnVO[] getTableColumnVOs() {
		TableColumnVO[] rtnVOs = null;
		if (this.tableColumnVOs != null) {
			rtnVOs = Arrays.copyOf(tableColumnVOs, tableColumnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tableColumnVOs the tableColumnVOs to set								//SJH.20150508.소스품질
	 */
	public void setTableColumnVOs(TableColumnVO[] tableColumnVOs){
		if(tableColumnVOs != null){
			TableColumnVO[] tmpVOs = Arrays.copyOf(tableColumnVOs, tableColumnVOs.length);
			this.tableColumnVOs = tmpVOs;
		}
	}

	/**
	 * @return the fTableName
	 */
	public String getFTableName() {
		return fTableName;
	}

	/**
	 * @param tableName the fTableName to set
	 */
	public void setFTableName(String tableName) {
		fTableName = tableName;
	}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}	

	
	
}