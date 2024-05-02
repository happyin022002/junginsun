/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcBankAcctVO.java
*@FileTitle : ArrNtcBankAcctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.10 손윤석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcWdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/* Arrival Notice Form Master */
	private BkgArrNtcWdVO bkgArrNtcWdVO;
	
	/* Arrival Notice Form Detail */
	private BkgArrNtcWdDtlVO[] bkgArrNtcWdDtlVOs;
	
	private MdmOrganizationVO mdmOrganizationVO;
	
	public ArrNtcWdVO() {}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return this.hashFields;
	}

	public BkgArrNtcWdVO getBkgArrNtcWdVO() {
		return bkgArrNtcWdVO;
	}

	public void setBkgArrNtcWdVO(BkgArrNtcWdVO bkgArrNtcWdVO) {
		this.bkgArrNtcWdVO = bkgArrNtcWdVO;
	}

	public BkgArrNtcWdDtlVO[] getBkgArrNtcWdDtlVOs() {
		return bkgArrNtcWdDtlVOs;
	}

	public void setBkgArrNtcWdDtlVOs(BkgArrNtcWdDtlVO[] bkgArrNtcWdDtlVOs) {
		this.bkgArrNtcWdDtlVOs = bkgArrNtcWdDtlVOs;
	}

	public MdmOrganizationVO getMdmOrganizationVO() {
		return mdmOrganizationVO;
	}

	public void setMdmOrganizationVO(MdmOrganizationVO mdmOrganizationVO) {
		this.mdmOrganizationVO = mdmOrganizationVO;
	}




}
