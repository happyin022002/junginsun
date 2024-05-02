/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportInsertBCImpl.java
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.management.alps.report.integration.ReportInsertDBDAO;
import com.hanjin.syscommon.management.alps.report.vo.ComEmlVO;
import com.hanjin.syscommon.management.alps.report.vo.ComFaxVO;
import com.hanjin.syscommon.management.alps.report.vo.ReportDesignerVO;


/**
 * NIS2010-ReportDesigner Business Logic Logic Basic Command implementation
 * - NIS2010-ReportDesigner에 대한 비지니스 로직을 처리한다.
 *
 * @author YongHoo-Kim
 * @see ReportInsertBC  및 각 DAO 클래스 참조
 * @since J2SE 6.0
 */
public class ReportInsertBCImpl extends BasicCommandSupport implements ReportInsertBC {
	
	// Database Access Object
	private transient ReportInsertDBDAO dbDao = null;

	public ReportInsertBCImpl() {
		dbDao = new ReportInsertDBDAO();
	}

	/**
	 *  ReportDesigner에 대한 insert 이벤트 처리
	 * 
	 * @param ReportDesignerVO reportdesigner
	 * @return insert 성공여부를 담은 checkFlag
	 * @exception EventException
	 */
	@Override
	public String insertReportDesigner(ReportDesignerVO reportdesigner) throws EventException {
		String checkFlag = null;
		String rdSubSysCdDbValue;
		setDefaultRdValue(reportdesigner);
		
		try {
			rdSubSysCdDbValue = dbDao.getRdAppCdDBData(reportdesigner.getRdSubSys()+"%");
			reportdesigner.setRdApplCd(nextRdApplCd(reportdesigner.getRdSubSys(), rdSubSysCdDbValue));
			checkFlag= dbDao.insertReportDesigner(reportdesigner);
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (DAOException e) {
			log.error(e.getMessage(),e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} 
		return checkFlag;
	}

	/**
	 * 모듈에 따른 가장 최근의 RDnumber 조회
	 * 
	 * @param String module
	 * @param String rdsubsyscd
	 * @return 가장 최근의 RDnumber
	 */
	@Override
	public String nextRdApplCd(String module, String rdsubsyscd) {
		return GetNextRdAppCdFacade.nextRdAppCd(module, rdsubsyscd);
	}

	/**
	 *  사용자 입력 없이 정해지는 field값 설정 처리
	 * 
	 * @param ReportDesignerVO reportdesigner
	 */
	@Override
	public void setDefaultRdValue(ReportDesignerVO reportdesigner) {
		reportdesigner.setDeltFlg("1");
		reportdesigner.setCreUsrId("Admin");
		reportdesigner.setUpdUsrId("Admin");
	}
	
	/**
	 * 모듈에 따른 RD 조회<br>
	 * 
	 * @param String rdSubSysCdDbValue
	 * @return List<ReportDesignerVO>
	 */
	@Override
	public List<ReportDesignerVO> searchReportDesigner(String rdSubSysCdDbValue) throws EventException {
		try {
			List<ReportDesignerVO> searchRdModulVOs = dbDao.searchReportDesigner(rdSubSysCdDbValue);
			return searchRdModulVOs;
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * FAX RD 조회
	 * 
	 * @param ComFaxVO faxVO
	 * @return List<ComFaxVO>
	 */
	@Override
	public List<ComFaxVO> searchRdFaxInfo(ComFaxVO faxVO) throws EventException {
		try {	
			List<ComFaxVO> getDataCompreWithDate = getFaxDataCompareWithDate(faxVO);
			List<ComFaxVO> resultComFaxVOs = getFaxDataCompareWithCondition(faxVO, getDataCompreWithDate);
			return resultComFaxVOs;
			
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회조건에 따른 FAX RD 조회
	 * 
	 * @param ComFaxVO faxVO
	 * @param List<ComFaxVO> theDayOfComFaxVOs
	 * @return List<ComFaxVO>
	 */
	List<ComFaxVO> getFaxDataCompareWithCondition(ComFaxVO faxVO, List<ComFaxVO> theDayOfComFaxVOs) {
		List<ComFaxVO> resultFaxVos = new ArrayList<ComFaxVO>();
		
		resultFaxVos = theDayOfComFaxVOs;		
		resultFaxVos = getFaxDataCompareWithRdApplCd(faxVO.getRdApplCd(), resultFaxVos);
		resultFaxVos = getFaxDataCompareWithFaxProcStsCd(faxVO.getFaxProcStsCd(), resultFaxVos);
		resultFaxVos = getFaxDataCompareWithFaxIp(faxVO.getFaxIp(), resultFaxVos);
		resultFaxVos = getFaxDataCompareWithOfcCd(faxVO.getOfcCd(), resultFaxVos);
		
		return resultFaxVos;
	}

	/**
	 * FAX_PROC_STS_CD 조건에 따른 EMail RD 조회
	 * 
	 * @param String faxProcStsCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComFaxVO> getFaxDataCompareWithFaxProcStsCd(String faxProcStsCd, List<ComFaxVO> resultFaxVos) {
		if(paramIsEmptyString(faxProcStsCd)){
			return resultFaxVos;
		} else{
			return existParamFaxProcStsCd(faxProcStsCd, resultFaxVos);
		}
	}
	
	/**
	 * RD_APPL_CD 조건에 따른 EMail RD 조회
	 * 
	 * @param String rdApplCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComFaxVO> getFaxDataCompareWithRdApplCd(String rdApplCd, List<ComFaxVO> resultFaxVos) {
		if(paramIsEmptyString(rdApplCd)){
			return resultFaxVos;
		} else{
			return existParamRdApplCd(rdApplCd, resultFaxVos);
		}
	}

	/**
	 * OFC_CD 조건에 따른 EMail RD 조회
	 * 
	 * @param String ofcCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComFaxVO> getFaxDataCompareWithOfcCd(String ofcCd, List<ComFaxVO> resultFaxVos) {
		if(paramIsEmptyString(ofcCd)){
			return resultFaxVos;
		} else{
			return existParamOfcCd(ofcCd, resultFaxVos);
		}
	}

	/**
	 * FAX_IP 조건에 따른 EMail RD 조회
	 * 
	 * @param String faxIp
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComFaxVO> getFaxDataCompareWithFaxIp(String faxIp, List<ComFaxVO> resultFaxVos) {
		if(paramIsEmptyString(faxIp)){
			return resultFaxVos;
		} else{
			return existParamFaxIp(faxIp, resultFaxVos);
		}
	}

	/**
	 * 사용자가 FAX_PROC_STS_CD 값을 검색조건으로 선택했을 때에 따른 FAX RD 조회
	 * 
	 * @param String faxProcStsCd
	 * @param List<ComFaxVO> resultFaxVos
	 * @return List<ComFaxVO>
	 */
	private List<ComFaxVO> existParamFaxProcStsCd(String faxProcStsCd, List<ComFaxVO> resultFaxVos) {
		List<ComFaxVO> comFaxVOs = new ArrayList<ComFaxVO>();
		
		for(ComFaxVO comFaxVO:resultFaxVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comFaxVO.getFaxProcStsCd()).equals(faxProcStsCd)){
				comFaxVOs.add(comFaxVO);
			}
		}
		return comFaxVOs;
	}
	
	/**
	 * 사용자가 RD_APPL_CD 값을 검색조건으로 선택했을 때에 따른 FAX RD 조회
	 * 
	 * @param String rdApplCd
	 * @param List<ComFaxVO> resultFaxVos
	 * @return List<ComFaxVO>
	 */
	private List<ComFaxVO> existParamRdApplCd(String rdApplCd, List<ComFaxVO> resultFaxVos) {
		List<ComFaxVO> comFaxVOs = new ArrayList<ComFaxVO>();
		
		for(ComFaxVO comFaxVO:resultFaxVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comFaxVO.getRdApplCd()).equals(rdApplCd)){
				comFaxVOs.add(comFaxVO);
			}
		}
		return comFaxVOs;
	}
	
	/**
	 * 사용자가 OFC_CD 값을 검색조건으로 선택했을 때에 따른 FAX RD 조회
	 * 
	 * @param String ofcCd
	 * @param List<ComFaxVO> resultFaxVos
	 * @return List<ComFaxVO>
	 */
	private List<ComFaxVO> existParamOfcCd(String ofcCd, List<ComFaxVO> resultFaxVos) {
		List<ComFaxVO> comFaxVOs = new ArrayList<ComFaxVO>();
		
		for(ComFaxVO comFaxVO:resultFaxVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comFaxVO.getOfcCd()).equals(ofcCd)){
				comFaxVOs.add(comFaxVO);
			}
		}
		return comFaxVOs;
	}
	
	/**
	 * 사용자가 FAX_IP 값을 검색조건으로 선택했을 때에 따른 FAX RD 조회
	 * 
	 * @param String faxIp
	 * @param List<ComFaxVO> resultFaxVos
	 * @return List<ComFaxVO>
	 */
	private List<ComFaxVO> existParamFaxIp(String faxIp, List<ComFaxVO> resultFaxVos) {
		List<ComFaxVO> comFaxVOs = new ArrayList<ComFaxVO>();
		
		for(ComFaxVO comFaxVO:resultFaxVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comFaxVO.getFaxIp()).equals(faxIp)){
				comFaxVOs.add(comFaxVO);
			}
		}
		return comFaxVOs;
	}
	
	/**
	 * 사용자가 FAX_SND_NO 값에 포함된 특정날짜 값을 검색조건으로 선택했을 때에 따른 FAX RD 조회
	 * 
	 * @param ComFaxVO faxVO
	 * @return List<ComFaxVO>
	 */
	List<ComFaxVO> getFaxDataCompareWithDate(ComFaxVO faxVO) throws DAOException {
		List<ComFaxVO> getDataCompareWithDate = dbDao.searchRdFaxInfo(faxVO.getFaxSndNo()+"%");
		return getDataCompareWithDate;
	}
	
	/**
	 * EMail RD 조회
	 * 
	 * @param ComEmlVO emlVO
	 * @return List<ComEmlVO>
	 */
	@Override
	public List<ComEmlVO> searchRdEmlInfo(ComEmlVO emlVO) throws EventException {
		try {	
			List<ComEmlVO> getDataCompreWithDate = getEmlDataCompareWithDate(emlVO);
			List<ComEmlVO> resultComEmlVOs = getEmlDataCompareWithCondition(emlVO, getDataCompreWithDate);
			return resultComEmlVOs;
			
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회조건에 따른 EMail RD 조회
	 * 
	 * @param ComEmlVO emlVO
	 * @param List<ComEmlVO> theDayOfComEmlVOs
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> getEmlDataCompareWithCondition(ComEmlVO emlVO, List<ComEmlVO> theDayOfComEmlVOs) {
		List<ComEmlVO> resultEmlVos = new ArrayList<ComEmlVO>();
		
		resultEmlVos = theDayOfComEmlVOs;
		resultEmlVos = getEmlDataCompareWithRdSubSysCd(emlVO.getRdSubSysCd(), resultEmlVos);
		resultEmlVos = getEmlDataCompareWithEmlProcStsCd(emlVO.getEmlProcStsCd(), resultEmlVos);
		resultEmlVos = getEmlDataCompareWithCreUsrId(emlVO.getCreUsrId(), resultEmlVos);
		resultEmlVos = getEmlDataCompareWithSmtpIp(emlVO.getSmtpIp(), resultEmlVos);
		
		return resultEmlVos;
	}

	/**
	 * EML_PROC_STS_CD 조건에 따른 EMail RD 조회
	 * 
	 * @param String emlProcStsCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> getEmlDataCompareWithEmlProcStsCd(String emlProcStsCd, List<ComEmlVO> resultEmlVos) {
		if(paramIsEmptyString(emlProcStsCd)){
			return resultEmlVos;
		} else{
			return existParamEmlProcStsCd(emlProcStsCd, resultEmlVos);
		}
	}
	
	/**
	 * SMTP_IP 조건에 따른 EMail RD 조회
	 * 
	 * @param String smtpIp
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> getEmlDataCompareWithSmtpIp(String smtpIp, List<ComEmlVO> resultEmlVos) {
		if(paramIsEmptyString(smtpIp)){
			return resultEmlVos;
		} else{
			return existParamSmtpIp(smtpIp, resultEmlVos);
		}
	}

	/**
	 * CRE_USR_ID 조건에 따른 EMail RD 조회
	 * 
	 * @param String creUsrId
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> getEmlDataCompareWithCreUsrId(String creUsrId, List<ComEmlVO> resultEmlVos) {
		if(paramIsEmptyString(creUsrId)){
			return resultEmlVos;
		} else{
			return existParamCreUsrId(creUsrId, resultEmlVos);
		}
	}

	/**
	 * RD_SUB_SYS_CD 조건에 따른 EMail RD 조회
	 * 
	 * @param String rdSubSysCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> getEmlDataCompareWithRdSubSysCd(String rdSubSysCd, List<ComEmlVO> resultEmlVos) {
		if(paramIsEmptyString(rdSubSysCd)){
			return resultEmlVos;
		} else{
			return existParamRdSubSysCd(rdSubSysCd, resultEmlVos);
		}
	}

	/**
	 * 사용자가 EML_PROC_STS_CD 값을 검색조건으로 선택했을 때에 따른 EMail RD 조회
	 * 
	 * @param String emlProcStsCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> existParamEmlProcStsCd(String emlProcStsCd, List<ComEmlVO> resultEmlVos) {
		List<ComEmlVO> comEmlVOs = new ArrayList<ComEmlVO>();
		
		for(ComEmlVO comEmlVO:resultEmlVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comEmlVO.getEmlProcStsCd()).equals(emlProcStsCd)){
				comEmlVOs.add(comEmlVO);
			}
		}
		return comEmlVOs;
	}
	
	/**
	 * 사용자가 SMTP_IP 값을 검색조건으로 선택했을 때에 따른 EMail RD 조회
	 * 
	 * @param String smtpIp
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> existParamSmtpIp(String smtpIp, List<ComEmlVO> resultEmlVos) {
		List<ComEmlVO> comEmlVOs = new ArrayList<ComEmlVO>();
		
		for(ComEmlVO comEmlVO:resultEmlVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comEmlVO.getSmtpIp()).equals(smtpIp)){
				comEmlVOs.add(comEmlVO);
			}
		}
		return comEmlVOs;
	}
	
	/**
	 * 사용자가 CRE_USR_ID 값을 검색조건으로 선택했을 때에 따른 EMail RD 조회
	 * 
	 * @param String creUsrId
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> existParamCreUsrId(String creUsrId, List<ComEmlVO> resultEmlVos) {
		List<ComEmlVO> comEmlVOs = new ArrayList<ComEmlVO>();
		
		for(ComEmlVO comEmlVO:resultEmlVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comEmlVO.getCreUsrId()).equals(creUsrId)){
				comEmlVOs.add(comEmlVO);
			}
		}
		return comEmlVOs;
	}
	
	/**
	 * 사용자가 RD_SUB_SYS_CD 값을 검색조건으로 선택했을 때에 따른 EMail RD 조회
	 * 
	 * @param String rdSubSysCd
	 * @param List<ComEmlVO> resultEmlVos
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> existParamRdSubSysCd(String rdSubSysCd, List<ComEmlVO> resultEmlVos) {
		List<ComEmlVO> comEmlVOs = new ArrayList<ComEmlVO>();
		
		for(ComEmlVO comEmlVO:resultEmlVos){
			if(CheckUtils.checkNullAndReturnStringBlank(comEmlVO.getRdSubSysCd()).equals(rdSubSysCd)){
				comEmlVOs.add(comEmlVO);
			}
		}
		return comEmlVOs;
	}
	
	/**
	 * 사용자가 EML_SND_NO 값에 포함된 특정날짜 값을 검색조건으로 선택했을 때에 따른 EMail RD 조회
	 * 
	 * @param ComEmlVO emlVO
	 * @return List<ComEmlVO>
	 */
	private List<ComEmlVO> getEmlDataCompareWithDate(ComEmlVO emlVO) throws DAOException {
		List<ComEmlVO> getDataCompareWithDate = dbDao.searchRdEmlInfo(emlVO.getEmlSndNo()+"%");
		return getDataCompareWithDate;
	}
	
	/**
	 * 검색조건 값이 있는지 없는지를 판단하는 로직
	 * 
	 * @param String param
	 * @return boolean
	 */
	boolean paramIsEmptyString(String param) {
		return "".equals(param);
	}
}
