/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0061Event.java
*@FileTitle : Inquiry By BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.28 송호진
* 1.0 Creation
===========================================================
' History :
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경   
' 2009.09.15 송호진 OPUS F/W 적용   
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0061HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0061Event extends EventSupport { 

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRpt0061VO bkgRpt0061VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgRpt0061VO[] bkgRpt0061VOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmCoa0061Event(){}
	
	public void setBkgRpt0061VO(BkgRpt0061VO bkgRpt0061VO){
		this. bkgRpt0061VO = bkgRpt0061VO;
	}
	
	//SJH.20150507.소스품질
	public void setBkgRpt0061VOS(BkgRpt0061VO[] bkgRpt0061VOs){
		if(bkgRpt0061VOs != null){
			BkgRpt0061VO[] tmpVOs = Arrays.copyOf(bkgRpt0061VOs, bkgRpt0061VOs.length);
			this.bkgRpt0061VOs = tmpVOs;
		}
	}

	public BkgRpt0061VO getBkgRpt0061VO(){
		return bkgRpt0061VO;
	}
	
	//SJH.20150507.소스품질
	public BkgRpt0061VO[] getBkgRpt0061VOS(){
		BkgRpt0061VO[] rtnVOs = null;
		if (this.bkgRpt0061VOs != null) {
			rtnVOs = Arrays.copyOf(bkgRpt0061VOs, bkgRpt0061VOs.length);
		}
		return rtnVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
}