/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ReportInsertBC.java
 *@FileTitle : Report Designer Insert
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013-05-21
 *@LastModifier : YongHoo-Kim
 *@LastVersion : 1.0
 * 2013-05-03 YongHoo-Kim
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.management.alps.report.vo.ComEmlVO;
import com.hanjin.syscommon.management.alps.report.vo.ComFaxVO;
import com.hanjin.syscommon.management.alps.report.vo.ReportDesignerVO;

/**
 * NIS2010-ReportDesigner Business Logic Command Interface<br>
 * - NIS2010-ReportDesigner에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author YongHoo-Kim
 * @see ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public interface ReportInsertBC {
	/**
	 * ReportDesigner에 대한 insert 이벤트 처리<br>
	 * 
	 * @param ReportDesignerVO reportdesigner
	 * @return insert 성공여부를 담은 checkFlag
	 * @exception EventException
	 */
	public String insertReportDesigner(ReportDesignerVO reportdesigner) throws EventException;
	
	/**
	 * ReportDesigner에 대한 search 이벤트 처리<br>
	 * 
	 * @param String rdSubSysCdDbValue
	 * @return List<ReportDesignerVO>
	 * @exception EventException
	 */
	public List<ReportDesignerVO> searchReportDesigner(String rdSubSysCdDbValue) throws EventException;
	
	/**
	 * 모듈에 따른 가장 최근의 RDnumber 조회<br>
	 * 
	 * @param String module
	 * @param String rdsubsyscd
	 * @return 가장 최근의 RDnumber
	 */
	public String nextRdApplCd(String module, String rdsubsyscd);

	/**
	 * 사용자 입력 없이 정해지는 field값 설정 처리<br>
	 * 
	 * @param ReportDesignerVO reportdesigner
	 */
	void setDefaultRdValue(ReportDesignerVO reportdesigner);
	
	/**
	 * ComEmlSndInfo 대한 search 이벤트 처리<br>
	 * 
	 * @param ComEmlVO emlVO
	 * @return List<ComEmlVO>
	 * @exception EventException
	 */
	public List<ComEmlVO> searchRdEmlInfo(ComEmlVO emlVO) throws EventException;
	
	/**
	 * ComFaxSndInfo에 대한 search 이벤트 처리<br>
	 * 
	 * @param ComFaxVO faxVO
	 * @return List<ComFaxVO>
	 * @exception EventException
	 */
	public List<ComFaxVO> searchRdFaxInfo(ComFaxVO faxVO) throws EventException;
}
