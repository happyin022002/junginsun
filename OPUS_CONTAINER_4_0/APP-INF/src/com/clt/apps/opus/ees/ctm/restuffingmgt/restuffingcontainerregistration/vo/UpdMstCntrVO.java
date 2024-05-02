/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : iRetuffingListVO.java
*@FileTitle : iRetuffingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo;

import java.util.HashMap;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 우경민
 * @since J2EE 1.5
 */

public class UpdMstCntrVO extends AbstractValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Mst_Container Update List */
	private CusCtmMovementVO[] mstUpd = null;
	
	/* Ctm_Movement Update List */
	private CusCtmMovementVO[] ctmUpd = null;

	/* Ctm_Movement Update */
	private CusCtmMovementVO updCtm = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public UpdMstCntrVO() {}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		return this.hashColumns;
	}
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return this.hashFields;
	}
	/**
	 * Mst_Container List
	 * @param mstUpd
	 */
	public CusCtmMovementVO[] getMstUpd() {
		return this.mstUpd;
	}

	/**
	 * Ctm_MOvement List
	 * @param mstUpd
	 */
	public CusCtmMovementVO[] getCtmUpd() {
		return this.ctmUpd;
	}

	/**
	 * Ctm_MOvement List
	 * @param mstUpd
	 */
	public CusCtmMovementVO getupdCtm() {
		return this.updCtm;
	}

	/**
	 * Mst_Container List
	 * @param mstUpd
	 */
	public void setMstUpd(CusCtmMovementVO[] mstUpd) {
		this.mstUpd = mstUpd;
	}

	/**
	 * Mst_Container List
	 * @param mstUpd
	 */
	public void setCtmUpd(CusCtmMovementVO[] ctmUpd) {
		this.ctmUpd = ctmUpd;
	}

	/**
	 * Mst_Container List
	 * @param mstUpd
	 */
	public void setUpdCtm(CusCtmMovementVO ctmUpd) {
		this.updCtm = ctmUpd;
	}

}
