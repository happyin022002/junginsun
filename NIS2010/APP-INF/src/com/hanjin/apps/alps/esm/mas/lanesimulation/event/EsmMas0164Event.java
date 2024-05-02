/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName       : EsmMas0164Event.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2010-01-12
*@LastModifier   : jin-young Yoon
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasSimNonOpExpnVO;

/**
 *  1. 기능 : ESM_MAS_0164 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_MAS_0164HTMLAction에서 작성 <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Yoon jin young/2010.01.12<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 * @author Yoon jin young
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0164Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/**/
	private SearchConditionVO searchConditionVO = null;
	private MasSimNonOpExpnVO[] masSimNonOpExpnVOS = null;

	public EsmMas0164Event(){}	

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
	public MasSimNonOpExpnVO[] getMasSimNonOpExpnVOS() {
		return masSimNonOpExpnVOS;
	}
	public void setMasSimNonOpExpnVOS(MasSimNonOpExpnVO[] masSimNonOpExpnVOS) {
		this.masSimNonOpExpnVOS = masSimNonOpExpnVOS;
	}
	/**
	 * Event 명을 반환한다.
	 */
	public String getEventName() {
        return "EsmMas0164Event";
    }
	/**
	 * Event 명을 반환한다.
	 */
    public String toString() {
        return "EsmMas0164Event";
    }
}
