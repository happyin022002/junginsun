/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : RdFaxInfoEvent.java
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
import com.hanjin.syscommon.management.alps.report.vo.ComFaxVO;

/**
 * ReportDesigner 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RdFaxInfoHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author YongHoo-Kim
 * @see RdFaxInfoHTMLAction 참조
 * @since J2SE 6.0
 */
public class RdFaxInfoEvent extends EventSupport {

	private static final long serialVersionUID = -719140180240696961L;
	private ComFaxVO faxVO = null;

	/**
	 * RdFaxInfoEvent 객체 생성<br>
	 */
	public RdFaxInfoEvent() {
	};

	/**
	 * RdFaxInfoEvent 객체 생성<br>
	 * 
	 * @param ComFaxVO faxVO
	 */
	public RdFaxInfoEvent(ComFaxVO faxVO) {
		this.faxVO = faxVO;
	}

	/**
	 * ComFax VO객체를 반환한다.<br>
	 * 
	 * @return ComFaxVO
	 */
	public ComFaxVO getComFaxVO() {
		return faxVO;
	}

	/**
	 * ComFax VO객체를 set한다.<br>
	 * 
	 * @param ComFaxVO faxVO
	 */
	public void setComFaxVO(ComFaxVO faxVO) {
		this.faxVO = faxVO;
	}
}
