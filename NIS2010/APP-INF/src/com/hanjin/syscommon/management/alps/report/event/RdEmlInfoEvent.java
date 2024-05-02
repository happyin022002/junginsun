/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : RdEmlInfoEvent.java
 *@FileTitle : Report Designer Insert
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013-05-21
 *@LastModifier : YongHoo-Kim
 *@LastVersion : 1.0
 * 2013-05-21 YongHoo-Kim
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.report.vo.ComEmlVO;

/**
 * ReportDesigner 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RdEmlInfoHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author YongHoo-Kim
 * @see RdEmlInfoHTMLAction 참조
 * @since J2SE 6.0
 */
public class RdEmlInfoEvent extends EventSupport {

	private static final long serialVersionUID = -719140180240696961L;
	private ComEmlVO emlVO = null;

	/**
	 * RdEmlInfoEvent 객체 생성<br>
	 */
	public RdEmlInfoEvent() {
	};

	/**
	 * RdEmlInfoEvent 객체 생성<br>
	 * 
	 * @param ComEmlVO emlVO
	 */
	public RdEmlInfoEvent(ComEmlVO emlVO) {
		this.emlVO = emlVO;
	}

	/**
	 * ComEml VO객체를 반환한다.<br>
	 * 
	 * @return emlVO
	 */
	public ComEmlVO getComEmlVO() {
		return emlVO;
	}

	/**
	 * ComEml VO객체를 set한다.<br>
	 * 
	 * *@param ComEmlVO emlVO
	 */
	public void setComEmlVO(ComEmlVO emlVO) {
		this.emlVO = emlVO;
	}
}
