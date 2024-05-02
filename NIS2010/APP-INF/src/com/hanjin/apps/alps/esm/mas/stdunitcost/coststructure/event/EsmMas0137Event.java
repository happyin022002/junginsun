/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0137Event.java
*@FileTitle : Node/Link U/C Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.02
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.08.02 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.TableColumnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.NodLnkCostCodeVO;

/**
 * ESM_MAS_0137 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0137HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author OK-YOUNG IM
 * @see ESM_MAS_0137HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0137Event extends EventSupport {

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

	public EsmMas0137Event(){}

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
	 * @return the nodLnkCostCodeVOs
	 */
	public NodLnkCostCodeVO[] getNodLnkCostCodeVOs() {
		return nodLnkCostCodeVOs;
	}

	/**
	 * @param nodLnkCostCodeVOs the nodLnkCostCodeVOs to set
	 */
	public void setNodLnkCostCodeVOs(NodLnkCostCodeVO[] nodLnkCostCodeVOs) {
		this.nodLnkCostCodeVOs = nodLnkCostCodeVOs;
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
	 * @return the tableColumnVOs
	 */
	public TableColumnVO[] getTableColumnVOs() {
		return tableColumnVOs;
	}

	/**
	 * @param tableColumnVOs the tableColumnVOs to set
	 */
	public void setTableColumnVOs(TableColumnVO[] tableColumnVOs) {
		this.tableColumnVOs = tableColumnVOs;
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

	
	
}