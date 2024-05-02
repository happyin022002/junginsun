/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChassisMgsetInventoryBCImpl.java
 *@FileTitle : Factor Adjustment by Location
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.03
 *@LastModifier : 김상수
 *@LastVersion : 1.97
 *
 * 2009.05.13 박의수
 *     1.0 Creation
 *
 * 2009.10.29 조재성
 *
 * 2010.08.03 김상수
 *     [CHM-201004960-01] Genset Ineventory Logic error 수정건
 *         : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
 * 2014-05-28 Justin Han recovered R4J defects.
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic;

import java.util.ArrayList;
import java.util.List;

import com.bluecast.util.DuplicateKeyException;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration.ChassisMgsetInventoryDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsDetailVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsOptionVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsSmryVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSBareMVMTDataVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Eui-su Park 
 * @see EES_CGM_1114EventResponse,ChassisMgsetInventoryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInventoryBCImpl extends BasicCommandSupport implements ChassisMgsetInventoryBC {

	// Database Access Object
	private transient ChassisMgsetInventoryDBDAO dbDao = null;

	/**
	 * ChassisMgsetInventoryBCImpl 객체 생성<br>
	 * ChassisMgsetInventoryDBDAO를 생성한다.<br>
	 */
	public ChassisMgsetInventoryBCImpl() {
		dbDao = new ChassisMgsetInventoryDBDAO(); 
	}


	/**
	 * Chassis Inventory 에 count 된 장비별 상세 list 를 조회. Retrieve [EES_CGM_1091]<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryGeneralListBasic(CHSInventoryDtlINVO chsInventoryDtlINVO) throws EventException {
		try {
			
			if(chsInventoryDtlINVO.getProgramId().equals("1118")){
				// EES_CGM_1118 에서 호출하였다면  Term Change List 반환
				String      vndr_seq      = chsInventoryDtlINVO.getVndrSeq();
				String[] 	vndr_seq2     = null;
 
				String      sts_evnt_ofc_cd   = chsInventoryDtlINVO.getStsEvntOfcCd();
				String[] 	sts_evnt_ofc_cd2  = null;
				String      old_agmt_lstm_cd  = chsInventoryDtlINVO.getOldAgmtLstmCd();
				String[] 	old_agmt_lstm_cd2 = null;
				
				String      new_agmt_lstm_cd  = chsInventoryDtlINVO.getNewAgmtLstmCd();
				
				//2014-05-28 Justin Han recovered R4J defects.
				StringBuffer new_agmt_lstm_cd_tmp = new StringBuffer();
				StringBuffer old_agmt_lstm_cd_tmp = new StringBuffer();
				StringBuffer vndr_seq_tmp = new StringBuffer();
				StringBuffer sts_evnt_ofc_cd_tmp = new StringBuffer();
				
								
				String[] 	new_agmt_lstm_cd2 = null;
				String  tmp = "";
				if(new_agmt_lstm_cd != null && !new_agmt_lstm_cd.trim().equals("")){
					new_agmt_lstm_cd2 = new_agmt_lstm_cd.split(",");
					for (int j=0; j<new_agmt_lstm_cd2.length; j++) {
						tmp = new_agmt_lstm_cd2[j].trim();
						if(j==0)
						{
//							new_agmt_lstm_cd = "'"+ tmp+"'";
							new_agmt_lstm_cd_tmp.append("'").append(tmp).append("'");
						}
						else
						{
//							new_agmt_lstm_cd = new_agmt_lstm_cd+ ",'"+ tmp+"'";
							new_agmt_lstm_cd_tmp.append(",'").append(tmp).append("'");
						}
					}
//					chsInventoryDtlINVO.setNewAgmtLstmCd(new_agmt_lstm_cd);
					chsInventoryDtlINVO.setNewAgmtLstmCd(new_agmt_lstm_cd_tmp.toString());
				}
				
				
				if(old_agmt_lstm_cd != null && !old_agmt_lstm_cd.trim().equals("")){
					old_agmt_lstm_cd2 = old_agmt_lstm_cd.split(",");
					for (int j=0; j<old_agmt_lstm_cd2.length; j++) {
						tmp = old_agmt_lstm_cd2[j].trim();
						if(j==0)
						{
//							old_agmt_lstm_cd = "'"+ tmp+"'";
							old_agmt_lstm_cd_tmp.append("'").append(tmp).append("'");
						}
						else
						{
//							old_agmt_lstm_cd = old_agmt_lstm_cd+ ",'"+ tmp+"'";
							old_agmt_lstm_cd_tmp.append(",'").append(tmp).append("'");
						}
					}
//					chsInventoryDtlINVO.setOldAgmtLstmCd(old_agmt_lstm_cd);
					chsInventoryDtlINVO.setOldAgmtLstmCd(old_agmt_lstm_cd_tmp.toString());
				}
				
				if(vndr_seq != null && !vndr_seq.trim().equals("")){
					vndr_seq2 = vndr_seq.split(",");
					for (int j=0; j<vndr_seq2.length; j++) {
						tmp = vndr_seq2[j].trim();
						if(j==0)
						{
//							vndr_seq = "'"+ tmp+"'";
							vndr_seq_tmp.append("'").append(tmp).append("'");
						}
						else
						{
//							vndr_seq = vndr_seq+ ",'"+ tmp+"'";
							vndr_seq_tmp.append(",'").append(tmp).append("'");
						}
					}
//					chsInventoryDtlINVO.setVndrSeq(vndr_seq);
					chsInventoryDtlINVO.setVndrSeq(vndr_seq_tmp.toString());
				}
				
				
				if(sts_evnt_ofc_cd != null && !sts_evnt_ofc_cd.trim().equals("")){
					sts_evnt_ofc_cd2 = sts_evnt_ofc_cd.split(",");
					for (int j=0; j<sts_evnt_ofc_cd2.length; j++) {
						tmp = sts_evnt_ofc_cd2[j].trim();
						if(j==0)
						{
//							sts_evnt_ofc_cd = "'"+ tmp+"'";
							sts_evnt_ofc_cd_tmp.append("'").append(tmp).append("'");
						}
						else
						{
//							sts_evnt_ofc_cd = sts_evnt_ofc_cd+ ",'"+ tmp+"'";
							sts_evnt_ofc_cd_tmp.append(",'").append(tmp).append("'");
						}
					}
//					chsInventoryDtlINVO.setStsEvntOfcCd(sts_evnt_ofc_cd);
					chsInventoryDtlINVO.setStsEvntOfcCd(sts_evnt_ofc_cd_tmp.toString());
				}
				
				
				
				
				
				return dbDao.searchCHSTermChangeListData(chsInventoryDtlINVO);
				
			} else if (chsInventoryDtlINVO.getProgramId().equals("1010") || chsInventoryDtlINVO.getProgramId().equals("1019")) {
				
				String vndr_seq = chsInventoryDtlINVO.getVndrSeq();
				String kind     = chsInventoryDtlINVO.getKind();
				//2014-05-28 Justin Han recovered R4J defects.
				StringBuffer vndr_seq_tmp = new StringBuffer();
				
				if(vndr_seq!= null && vndr_seq.equals("")){
					
					String[] 	vndrSeq2 =  null;
					if(!kind.equals("L") && chsInventoryDtlINVO.getProgramId().equals("1010")){
						String  tmp = "";
						vndrSeq2 = vndr_seq.split(",");
						for (int j=0; j<vndrSeq2.length; j++) {
							tmp = vndrSeq2[j].trim();
							if(j==0)
							{
//								vndr_seq = "('"+ tmp.substring(0,3)+"',"+Integer.parseInt( tmp.substring(3, tmp.length()))+")";
								vndr_seq_tmp.append("('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt( tmp.substring(3, tmp.length()))).append(")");
							}
							else
							{
//								vndr_seq = vndr_seq+ ",('"+ tmp.substring(0,3)+"',"+Integer.parseInt( tmp.substring(3, tmp.length()))+")";
								vndr_seq_tmp.append(",('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt( tmp.substring(3, tmp.length()))).append(")");
							}
						}
					}
				}
//				chsInventoryDtlINVO.setVndrSeq(vndr_seq);
				chsInventoryDtlINVO.setVndrSeq(vndr_seq_tmp.toString());

				// chungpa 20100405 combo 변경 single => multi start
				if (chsInventoryDtlINVO.getProgramId().equals("1010"))
				{
					//String crntLocCd = chsInventoryGeneralINVO.getCrntLocCd();
					String agmtLstmCd = chsInventoryDtlINVO.getSAgmtLstmCd();
					if(agmtLstmCd != null && !agmtLstmCd.equals("")){
						agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
						chsInventoryDtlINVO.setSAgmtLstmCd(agmtLstmCd);
					}
				}
				//chungpa 20100405 combo 변경 single => multi end
				return dbDao.searchCHSOnOffhireDtlListData(chsInventoryDtlINVO);
				
			} else if (chsInventoryDtlINVO.getProgramId().equals("1092")) { // chungpa 20090728 1092 popup
				// Inventory List
				
				// 문자열 치환을 위한 작업
				//String crntLocCd = chsInventoryDtlINVO.getCrntLocCd();
				String eqTpszCd = chsInventoryDtlINVO.getEqTpszCd();
				String crntYdCd = chsInventoryDtlINVO.getCrntYdCd();
				String agmtLstmCd = chsInventoryDtlINVO.getAgmtLstmCd();
				String chssMvmtStsCd = chsInventoryDtlINVO.getChssMvmtStsCd();
				
				/*
				if(crntLocCd != null && !crntLocCd.equals("")){
					crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntLocCd(crntLocCd);
				}
				*/
				if(eqTpszCd != null && !eqTpszCd.equals("")){
					eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setEqTpszCd(eqTpszCd);
				}				
				if(crntYdCd != null && !crntYdCd.equals("")){
					crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntYdCd(crntYdCd);
				}
				
				if(agmtLstmCd != null && !agmtLstmCd.equals("")){
					agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setAgmtLstmCd(agmtLstmCd);
				}
				
				if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
					chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setChssMvmtStsCd(chssMvmtStsCd);
				}
				
				return dbDao.searchCHSInventoryByStaydaysListData(chsInventoryDtlINVO);
			} else if(chsInventoryDtlINVO.getProgramId().equals("1098")) { // chungpa 20090729 1098 popup)

				String sTmp = chsInventoryDtlINVO.getAgmtNo();
				//2014-05-28 Justin Han recovered R4J defects.
				StringBuffer sTmp_tmp = new StringBuffer();
				
				if(sTmp != null && !sTmp.equals("") )
				{
					String[] agmtNo	= null;
					String  tmp = "";
					agmtNo = sTmp.split(",");
					log.debug("searchCHSInventoryByAgmtBasic ==========AgmtNo=="+agmtNo.length);
					for (int j=0; j<agmtNo.length; j++) {
						tmp = agmtNo[j].trim();
						if(j==0)
						{
//							sTmp = "('"+tmp.substring(0,3)+"',"+Integer.parseInt(tmp.substring(3,tmp.length()))+")";
							sTmp_tmp.append("('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt(tmp.substring(3,tmp.length()))).append(")");
						}
						else
						{
//							sTmp = sTmp+ ",('"+tmp.substring(0,3)+"',"+Integer.parseInt(tmp.substring(3,tmp.length()))+")";
							sTmp_tmp.append(",('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt(tmp.substring(3,tmp.length()))).append(")");
						}
					}
//					log.debug("searchCHSInventoryByAgmtBasic ==========sTmp=="+sTmp);
//					chsInventoryDtlINVO.setAgmtNo(sTmp);
					log.debug("searchCHSInventoryByAgmtBasic ==========sTmp=="+sTmp_tmp.toString());
					chsInventoryDtlINVO.setAgmtNo(sTmp_tmp.toString());
				}	
				
				String crntYdCd = chsInventoryDtlINVO.getCrntYdCd();
				if(crntYdCd != null && !crntYdCd.equals("")){
					crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntYdCd(crntYdCd);
				}
			
				String vndrSeq = chsInventoryDtlINVO.getVndrSeq();
				if(vndrSeq != null && !vndrSeq.equals("")){
					vndrSeq = "'" + vndrSeq.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setVndrSeq(vndrSeq);
				}
				
				return dbDao.searchCHSInventoryByAgmtListData(chsInventoryDtlINVO); 
			}else if (chsInventoryDtlINVO.getProgramId().equals("1100")) { // chungpa 20090728 1092 popup
				// Inventory List
				
				// 문자열 치환을 위한 작업
				//String crntLocCd = chsInventoryDtlINVO.getCrntLocCd();
				String eqTpszCd = chsInventoryDtlINVO.getEqTpszCd();
				String crntYdCd = chsInventoryDtlINVO.getCrntYdCd();
				String agmtLstmCd = chsInventoryDtlINVO.getAgmtLstmCd();
				String chssMvmtStsCd = chsInventoryDtlINVO.getChssMvmtStsCd();
				
				/*
				if(crntLocCd != null && !crntLocCd.equals("")){
					crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntLocCd(crntLocCd);
				}
				*/
				
				if(eqTpszCd != null && !eqTpszCd.equals("")){
					eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setEqTpszCd(eqTpszCd);
				}
						
				if(crntYdCd != null && !crntYdCd.equals("")){
					crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntYdCd(crntYdCd);
				}
				
				if(agmtLstmCd != null && !agmtLstmCd.equals("")){
					agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setAgmtLstmCd(agmtLstmCd);
				}
				
				if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
					chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setChssMvmtStsCd(chssMvmtStsCd);
				}
				
				return dbDao.searchCHSInventoryByOnhireYearListData(chsInventoryDtlINVO);
			} 
			else {
				// Inventory List
				
				// 문자열 치환을 위한 작업
				//String crntLocCd = chsInventoryDtlINVO.getCrntLocCd();
				String eqTpszCd = chsInventoryDtlINVO.getEqTpszCd();
				String crntYdCd = chsInventoryDtlINVO.getCrntYdCd();
				String agmtLstmCd = chsInventoryDtlINVO.getAgmtLstmCd();
				String chssMvmtStsCd = chsInventoryDtlINVO.getChssMvmtStsCd();
				/*
				if(crntLocCd != null && !crntLocCd.equals("")){
					crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntLocCd(crntLocCd);
				}
				*/
				if(eqTpszCd != null && !eqTpszCd.equals("")){
					eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setEqTpszCd(eqTpszCd);
				}
				if(crntYdCd != null && !crntYdCd.equals("")){
					crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setCrntYdCd(crntYdCd);
				}
				
				if(agmtLstmCd != null && !agmtLstmCd.equals("")){
					agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setAgmtLstmCd(agmtLstmCd);
				}
				
				if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
					chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
					chsInventoryDtlINVO.setChssMvmtStsCd(chssMvmtStsCd);
				}
				
				return dbDao.searchCHSInventoryGeneralListData(chsInventoryDtlINVO);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * M.G.Set Inventory 에 count 된 장비별 상세 list 를 조회. Retrieve [EES_CGM_2084]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryGeneralListBasic(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws EventException {
		try {
			
			log.debug("getProgramId========"+mgsInventoryDtlINVO.getProgramId());
			if(mgsInventoryDtlINVO.getProgramId().equals("2028")){
				String sStrEvntOfcCd = mgsInventoryDtlINVO.getStsEvntOfcCd();
				String sVndrSeq      = mgsInventoryDtlINVO.getSVndrSeq();
				String sAgmtLstmCd   = mgsInventoryDtlINVO.getSAgmtLstmCd();
				log.debug("getSAgmtLstmCd========"+mgsInventoryDtlINVO.getSAgmtLstmCd());
				String s2AgmtLstmCd  = mgsInventoryDtlINVO.getS2AgmtLstmCd();
				if(sStrEvntOfcCd != null && !sStrEvntOfcCd.equals("")){
					sStrEvntOfcCd =   "'" + sStrEvntOfcCd.replaceAll(",", "','") + "'" ;
					mgsInventoryDtlINVO.setStsEvntOfcCd(sStrEvntOfcCd);
				}
				
				if(sVndrSeq != null && !sVndrSeq.equals("")){
					sVndrSeq =   "'" + sVndrSeq.replaceAll(",", "','") + "'" ;
					mgsInventoryDtlINVO.setSVndrSeq(sVndrSeq);
				}
				
				if(sAgmtLstmCd != null && !sAgmtLstmCd.equals("")){
					sAgmtLstmCd =   "'" + sAgmtLstmCd.replaceAll(",", "','") + "'" ;
					mgsInventoryDtlINVO.setSAgmtLstmCd(sAgmtLstmCd);
				}
				
				if(s2AgmtLstmCd != null && !s2AgmtLstmCd.equals("")){
					s2AgmtLstmCd =   "'" + s2AgmtLstmCd.replaceAll(",", "','") + "'" ;
					mgsInventoryDtlINVO.setS2AgmtLstmCd(s2AgmtLstmCd);
				}
				
				// EES_CGM_2084 에서 호출하였다면  Term Change List 반환 
				return dbDao.searchMGSTermChangeListData(mgsInventoryDtlINVO);
			}else if(mgsInventoryDtlINVO.getProgramId().equals("2077"))
			{
				String sCrntOfcCd = mgsInventoryDtlINVO.getSCrntOfcCd();
				String sVndrSeq = mgsInventoryDtlINVO.getSVndrSeq();
				String sAgmtLstmCd = mgsInventoryDtlINVO.getSAgmtLstmCd();
				
				if(sCrntOfcCd != null && !sCrntOfcCd.equals("")){ 
					sCrntOfcCd = "'" + sCrntOfcCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSCrntOfcCd(sCrntOfcCd);
				}
				
				if(sVndrSeq != null && !sVndrSeq.equals("")){
					sVndrSeq = "'" + sVndrSeq.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSVndrSeq(sVndrSeq);
				}

				if(sAgmtLstmCd != null && !sAgmtLstmCd.equals("")){
					sAgmtLstmCd = "'" + sAgmtLstmCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSAgmtLstmCd(sAgmtLstmCd);
				}				
				return dbDao.searchMGSInventoryByLessorAgmtListData(mgsInventoryDtlINVO);
			}else if(mgsInventoryDtlINVO.getProgramId().equals("2078"))
			{
				String sCrntYdCd = mgsInventoryDtlINVO.getSCrntYdCd();
				String sVndrSeq = mgsInventoryDtlINVO.getSVndrSeq();
				String sAgmtLstmCd = mgsInventoryDtlINVO.getSAgmtLstmCd();
				
				if(sCrntYdCd != null && !sCrntYdCd.equals("")){
					sCrntYdCd = "'" + sCrntYdCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSCrntYdCd(sCrntYdCd);
				}
				
				if(sVndrSeq != null && !sVndrSeq.equals("")){
					sVndrSeq = "'" + sVndrSeq.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSVndrSeq(sVndrSeq);
				}

				if(sAgmtLstmCd != null && !sAgmtLstmCd.equals("")){
					sAgmtLstmCd = "'" + sAgmtLstmCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSAgmtLstmCd(sAgmtLstmCd);
				}				
				return dbDao.searchMGSInventoryByLessorTermListData(mgsInventoryDtlINVO);
			}else if(mgsInventoryDtlINVO.getProgramId().equals("2079"))
			{
				String sCrntOfcCd = mgsInventoryDtlINVO.getSCrntOfcCd();
				if(sCrntOfcCd != null && !sCrntOfcCd.equals("")){
					sCrntOfcCd = "'" + sCrntOfcCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSCrntOfcCd(sCrntOfcCd);
				}			
				
				String tmp_inq_fm_dys = mgsInventoryDtlINVO.getS1InqFmDys();
				String tmp_inq_to_dys = mgsInventoryDtlINVO.getS1InqToDys();
				tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
				tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
				mgsInventoryDtlINVO.setS1InqFmDys(tmp_inq_fm_dys);
				mgsInventoryDtlINVO.setS1InqToDys(tmp_inq_to_dys);
				
				return dbDao.searchMGSInventoryByOfficeListData(mgsInventoryDtlINVO);
			}else if(mgsInventoryDtlINVO.getProgramId().equals("2080"))
			{
				String sCrntYdCd = mgsInventoryDtlINVO.getSCrntYdCd();
				String sVndrSeq = mgsInventoryDtlINVO.getSVndrSeq();
				
				if(sCrntYdCd != null && !sCrntYdCd.equals("")){
					sCrntYdCd = "'" + sCrntYdCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSCrntYdCd(sCrntYdCd);
				}
				
				if(sVndrSeq != null && !sVndrSeq.equals("")){
					sVndrSeq = "'" + sVndrSeq.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSVndrSeq(sVndrSeq);
				}
	
				return dbDao.searchMGSInventoryByLocationLessorListData (mgsInventoryDtlINVO);
			}else if(mgsInventoryDtlINVO.getProgramId().equals("2020") || mgsInventoryDtlINVO.getProgramId().equals("2012"))
			{
				if(mgsInventoryDtlINVO.getProgramId().equals("2012")){
					String vndr_seq = mgsInventoryDtlINVO.getSVndrSeq();
					//2014-05-28 Justin Han recovered R4J defects.
					StringBuffer vndr_seq_tmp = new StringBuffer();
					
					String kind     = mgsInventoryDtlINVO.getS2Group1();
					if(vndr_seq!= null && vndr_seq.equals("")){
						
						String[] 	vndrSeq2 =  null;
						if(!kind.equals("L") && mgsInventoryDtlINVO.getProgramId().equals("2012")){
							String  tmp = "";
							vndrSeq2 = vndr_seq.split(",");
							for (int j=0; j<vndrSeq2.length; j++) {
								tmp = vndrSeq2[j].trim();
								if(j==0)
								{
//									vndr_seq = "('"+ tmp.substring(0,3)+"',"+Integer.parseInt( tmp.substring(3, tmp.length()))+")";
									vndr_seq_tmp.append("('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt( tmp.substring(3, tmp.length()))).append(")");
								}
								else
								{
//									vndr_seq = vndr_seq+ ",('"+ tmp.substring(0,3)+"',"+Integer.parseInt( tmp.substring(3, tmp.length()))+")";
									vndr_seq_tmp.append( ",('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt( tmp.substring(3, tmp.length()))).append(")");
								}
							}
						}
					}
//					mgsInventoryDtlINVO.setSVndrSeq(vndr_seq);
					mgsInventoryDtlINVO.setSVndrSeq(vndr_seq_tmp.toString());
				}
				
				
	            log.debug("s_crnt_loc_cd========"+mgsInventoryDtlINVO.getSCrntLocCd());
	            
	            // chungpa 20100405 combo 변경 single => multi start
	            if(mgsInventoryDtlINVO.getProgramId().equals("2012"))
	            {
					//String crntLocCd = chsInventoryGeneralINVO.getCrntLocCd();
					String agmtLstmCd = mgsInventoryDtlINVO.getSAgmtLstmCd();
					if(agmtLstmCd != null && !agmtLstmCd.equals("")){
						agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
						mgsInventoryDtlINVO.setSAgmtLstmCd(agmtLstmCd);
					}
	            }
	            //chungpa 20100405 combo 변경 single => multi end
				return dbDao.searchMGSInventoryByLostSummaryListData (mgsInventoryDtlINVO);
			}
			else { // DEFAULT PROGRAM ID : 2076 
				
				// chungpa 20091021 2076 detail popup error fix start
				String sCrntYdCd = mgsInventoryDtlINVO.getSCrntYdCd();
				if(sCrntYdCd != null && !sCrntYdCd.equals("")){
					sCrntYdCd = "'" + sCrntYdCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSCrntYdCd(sCrntYdCd);
				}
				
				String sEqTpszCd = mgsInventoryDtlINVO.getSEqTpszCd();
				if(sEqTpszCd != null && !sEqTpszCd.equals("")){
					sEqTpszCd = "'" + sEqTpszCd.replaceAll(",", "','") + "'";
					mgsInventoryDtlINVO.setSEqTpszCd(sEqTpszCd);
				}
				// chungpa 20091021 2076 detail popup error fix end.
				
				// Inventory List
				return dbDao.searchMGSInventoryGeneralListData(mgsInventoryDtlINVO);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}	
	
	/**
	 * Chassis 기본적 인벤토리 조회 화면인 General Inventory 산출.. Retrieve [EES_CGM_1089]<br>
	 * 
	 * @param chsInventoryGeneralINVO CHSInventoryGeneralINVO
	 * @return List<CHSInventoryGeneralMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSInventoryGeneralMGTVO> searchCHSInventoryGeneralBasic(CHSInventoryGeneralINVO chsInventoryGeneralINVO) throws EventException {
		try {
			//String crntLocCd = chsInventoryGeneralINVO.getCrntLocCd();
			String crntYdCd = chsInventoryGeneralINVO.getCrntYdCd();
			String eqTpszCd = chsInventoryGeneralINVO.getEqTpszCd();
			String agmtLstmCd = chsInventoryGeneralINVO.getAgmtLstmCd();
			String chssMvmtStsCd = chsInventoryGeneralINVO.getChssMvmtStsCd();
			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryGeneralINVO.setCrntLocCd(crntLocCd);
			}
			*/
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				chsInventoryGeneralINVO.setCrntYdCd(crntYdCd);
			}
			
			if(eqTpszCd != null && !eqTpszCd.equals("")){
				eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
				chsInventoryGeneralINVO.setEqTpszCd(eqTpszCd);
			}
			
			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				chsInventoryGeneralINVO.setAgmtLstmCd(agmtLstmCd);
			}
			
			if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
				chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
				chsInventoryGeneralINVO.setChssMvmtStsCd(chssMvmtStsCd);
			}
			
			return dbDao.searchCHSInventoryGeneralData(chsInventoryGeneralINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Inventory By staying days 산출.  [EES_CGM_1092]<br>
	 * 
	 * @param chsInventoryByStaydaysINVO CHSInventoryByStaydaysINVO   
	 * @return List<CHSInventoryByStaydaysMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByStaydaysMGTVO> searchCHSInventoryByStaydaysBasic( CHSInventoryByStaydaysINVO chsInventoryByStaydaysINVO) throws EventException {
		try {
			String eqTpszCd = chsInventoryByStaydaysINVO.getEqTpszCd();
			String agmtLstmCd = chsInventoryByStaydaysINVO.getAgmtLstmCd();
			String chssMvmtStsCd = chsInventoryByStaydaysINVO.getChssMvmtStsCd();
			String crntYdCd = chsInventoryByStaydaysINVO.getCrntYdCd();
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			
			if(eqTpszCd != null && !eqTpszCd.equals("")){
				eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setEqTpszCd(eqTpszCd);
			}
			
			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setAgmtLstmCd(agmtLstmCd);
			}
			
			if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
				chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setChssMvmtStsCd(chssMvmtStsCd);
			}
			
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntYdCd(crntYdCd);
			}

			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			return dbDao.searchCHSInventoryByStaydaysData(chsInventoryByStaydaysINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  User ID 별 Inventory By Long Staying Days 화면에서 쓰이는 그룹 기준 날짜 정보를 조회한다.  [EES_CGM_1094]<br>
	 * 
	 * @param chsLongStaydaysEnvINVO CHSLongStaydaysEnvINVO 
	 * @param account SignOnUserAccount  
	 * @return List<CHSLongStaydaysEnvMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSLongStaydaysEnvMGTVO> searchCHSLongstayEnvBasic(CHSLongStaydaysEnvINVO chsLongStaydaysEnvINVO, SignOnUserAccount account) throws EventException {
		try {
			chsLongStaydaysEnvINVO.setStayDysInpUsrId(account.getUsr_id());
			return dbDao.searchCHSLongstayEnvData(chsLongStaydaysEnvINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	
	/**
	 * User ID 별 Inventory By Long Staying Days 화면에서 쓰이는 그룹 기준 날짜를 설정한다.  [EES_CGM_1094]<br>
	 * 
	 * @param cHSLongStaydaysEnvINVOs CHSLongStaydaysEnvINVO[] 
	 * @param account SignOnUserAccount  
	 * @exception DAOException
	 * @exception Exception
	 */	
	public void manageCHSLongstayEnvBasic(CHSLongStaydaysEnvINVO[] cHSLongStaydaysEnvINVOs, SignOnUserAccount account)throws EventException {
		// Response 객체를 담기위한 Map 객체
		//Map<String, Object> responseData = new HashMap<String, Object>();
		try {
			// ETC Data 를  담기위한 Map 객체
			//Map<String, String> etcData = new HashMap<String, String>();
			CHSLongStaydaysEnvINVO          tmp  = new CHSLongStaydaysEnvINVO();

			List<CHSLongStaydaysEnvINVO> updateVoList = new ArrayList<CHSLongStaydaysEnvINVO>();
			
			for ( int i=0; i<cHSLongStaydaysEnvINVOs.length; i++ ) {
				tmp = cHSLongStaydaysEnvINVOs[i];
				tmp.setStayDysInpUsrId(account.getUsr_id());
				updateVoList.add(tmp);
				dbDao.modifyCHSLongstayEnvData(updateVoList);
			}
			//etcData = CHSLongStaydaysEnvINVO.getColumnValues();
			//Response Data 설정
			//responseData.put(WebKeys.ER_ETCDATA, etcData);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		//return responseData;
	}
	
	/**
	 * Inventory By Agreement 산출. [EES_CGM_1098]<br>
	 * 
	 * @param cHSInventoryByAgmtINVO CHSInventoryByAgmtINVO 
	 * @return List<CHSInventoryByAgmtMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByAgmtMGTVO> searchCHSInventoryByAgmtBasic( CHSInventoryByAgmtINVO cHSInventoryByAgmtINVO) throws EventException {
		try {
			String crntYdCd = cHSInventoryByAgmtINVO.getCrntYdCd();
			
			
			/* 추후 crnt_loc_cd 가 멀티로 추가될 경우 적용예정
			String crntLocCd = cHSInventoryByAgmtINVO.getCrntLocCd();
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			String sTmp = cHSInventoryByAgmtINVO.getAgmtNo();
			
			//2014-05-28 Justin Han recovered R4J defects.
			StringBuffer sTmp_tmp = new StringBuffer();
			
			if(sTmp != null && !sTmp.equals("") )
			{
				String[] agmtNo	= null;
				String  tmp = "";
				agmtNo = sTmp.split(",");
				log.debug("searchCHSInventoryByAgmtBasic ==========AgmtNo=="+agmtNo.length);
				for (int j=0; j<agmtNo.length; j++) {
					tmp = agmtNo[j].trim();
					if(j==0)
					{
//						sTmp = "('"+tmp.substring(0,3)+"',"+Integer.parseInt(tmp.substring(3,tmp.length()))+")";
						sTmp_tmp.append("('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt(tmp.substring(3,tmp.length()))).append(")");
					}
					else
					{
//						sTmp = sTmp+ ",('"+tmp.substring(0,3)+"',"+Integer.parseInt(tmp.substring(3,tmp.length()))+")";
						sTmp_tmp.append( ",('").append(tmp.substring(0,3)).append("',").append(Integer.parseInt(tmp.substring(3,tmp.length()))).append(")");
					}
				}
//				log.debug("searchCHSInventoryByAgmtBasic ==========sTmp=="+sTmp);
//				cHSInventoryByAgmtINVO.setAgmtNo(sTmp);
				
				log.debug("searchCHSInventoryByAgmtBasic ==========sTmp=="+sTmp_tmp.toString());
				cHSInventoryByAgmtINVO.setAgmtNo(sTmp_tmp.toString());
			}			
			
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				cHSInventoryByAgmtINVO.setCrntYdCd(crntYdCd);
			}

			return dbDao.searchCHSInventoryByAgmtData(cHSInventoryByAgmtINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}	
	
	/**
	 * Inventory By On-hire year  산출. [EES_CGM_1100]<br>
	 * 
	 * @param cHSInventoryByOnhireYearINVO CHSInventoryByOnhireYearINVO 
	 * @return List<CHSInventoryByOnhireYearMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByOnhireYearMGTVO> searchCHSInventoryByOnhireYearBasic( CHSInventoryByOnhireYearINVO cHSInventoryByOnhireYearINVO) throws EventException {
		try {
			String eqTpszCd = cHSInventoryByOnhireYearINVO.getEqTpszCd();
			String agmtLstmCd = cHSInventoryByOnhireYearINVO.getAgmtLstmCd();
			String chssMvmtStsCd = cHSInventoryByOnhireYearINVO.getChssMvmtStsCd();
			String crntYdCd = cHSInventoryByOnhireYearINVO.getCrntYdCd();
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			if(eqTpszCd != null && !eqTpszCd.equals("")){
				eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
				cHSInventoryByOnhireYearINVO.setEqTpszCd(eqTpszCd);
			}
			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				cHSInventoryByOnhireYearINVO.setAgmtLstmCd(agmtLstmCd);
			}
			if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
				chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
				cHSInventoryByOnhireYearINVO.setChssMvmtStsCd(chssMvmtStsCd);
			}
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				cHSInventoryByOnhireYearINVO.setCrntYdCd(crntYdCd);
			}
			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			return dbDao.searchCHSInventoryByOnhireYearData (cHSInventoryByOnhireYearINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}		
	
	/**
	 * Inventory Variation 산출. [EES_CGM_1102]<br>
	 * 
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationBasic ( CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws EventException {
		try {
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			String tmp_inq_fm_dys = cHSInventoryByVariationINVO.getInqFmDys();
			String tmp_inq_to_dys = cHSInventoryByVariationINVO.getInqToDys();
			
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			
			cHSInventoryByVariationINVO.setInqFmDys(tmp_inq_fm_dys);
			cHSInventoryByVariationINVO.setInqToDys(tmp_inq_to_dys);
			
			return dbDao.searchCHSInventoryByVariationStsData(cHSInventoryByVariationINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}		
	
	/**
	 * Inventory Variation Detail List 산출. [EES_CGM_1103]<br>
	 * 
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return List<CHSInventoryByVariationDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlListBasic  ( CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws EventException {
		try {
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			String tmp_inq_fm_dys = cHSInventoryByVariationDtlINVO.getInqFmDys();
			String tmp_inq_to_dys = cHSInventoryByVariationDtlINVO.getInqToDys();
			
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			
			cHSInventoryByVariationDtlINVO.setInqFmDys(tmp_inq_fm_dys);
			cHSInventoryByVariationDtlINVO.setInqToDys(tmp_inq_to_dys);
			
			return dbDao.searchCHSInventoryByVariationDtlListData(cHSInventoryByVariationDtlINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}		
	
	/**
	 * Utilization Factor by Yard 정보 조회(Yard 조회)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO   
	 * @return List<CHSUtilFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactorBasic(CHSUtilFactorINVO cHSUtilFactorINVO) throws EventException{
		try {
			
			return dbDao.searchCHSUtilFactortData (cHSUtilFactorINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Utilization Factor by Yard 상세 정보 조회(Container status 조회)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO 
	 * @return List<CHSUtilFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactorDtlBasic(CHSUtilFactorINVO cHSUtilFactorINVO) throws EventException {
		try {
			
			return dbDao.searchCHSUtilFactortDtlData (cHSUtilFactorINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	
	/**
	 * Utilization Factor by Yard 정보 저장(Yard/Status 저장)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO
	 * @param cHSUtilFactorINVOs1 CHSUtilFactorINVO[]  
	 * @param cHSUtilFactorINVOs2 CHSUtilFactorINVO[]  
	 * @param account SignOnUserAccount 	
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSUtilFactorBasic(CHSUtilFactorINVO  cHSUtilFactorINVO, CHSUtilFactorINVO[]  cHSUtilFactorINVOs1, CHSUtilFactorINVO[]  cHSUtilFactorINVOs2, SignOnUserAccount account) throws EventException{
		List<CHSUtilFactorINVO> insert1 = new ArrayList<CHSUtilFactorINVO>();
		List<CHSUtilFactorINVO> update1 = new ArrayList<CHSUtilFactorINVO>();
		List<CHSUtilFactorINVO> insert2 = new ArrayList<CHSUtilFactorINVO>();
		List<CHSUtilFactorINVO> update2 = new ArrayList<CHSUtilFactorINVO>();
		
		CHSUtilFactorINVO mp = new CHSUtilFactorINVO();
		
		List<CHSUtilFactorMGTVO> tmpData = null;
		List<CHSUtilFactorMGTVO> tmpDtlData = null;

		try
		{
			tmpData = dbDao.searchCHSUtilFactortData (cHSUtilFactorINVO);
			tmpDtlData = dbDao.searchCHSUtilFactortDtlData (cHSUtilFactorINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		try
		{
			for(int i=0; i<cHSUtilFactorINVOs1.length; i++){
				if(cHSUtilFactorINVOs1[i].getIbflag().equals("I")
				   || cHSUtilFactorINVOs1[i].getIbflag().equals("U"))
				{
					mp = new CHSUtilFactorINVO();
					mp.setChssUsgRto(cHSUtilFactorINVOs1[i].getChssUsgRto());
					mp.setCnmvStsCd(cHSUtilFactorINVOs1[i].getCnmvStsCd());
					mp.setCntrDryRfIndCd(cHSUtilFactorINVOs1[i].getCntrDryRfIndCd());
					mp.setCntrPsnStsCd(cHSUtilFactorINVOs1[i].getCntrPsnStsCd());
					mp.setEg5PreKntQty(cHSUtilFactorINVOs1[i].getEg5PreKntQty());
					
					mp.setLocCd(cHSUtilFactorINVO.getLocCd()); 	//form key
					mp.setYdCd(cHSUtilFactorINVOs1[i].getYdCd());	//form key(x), sheet1key(0)
					
					mp.setUpdUsrId(account.getUsr_id());
					mp.setCreUsrId(account.getUsr_id());
					mp.setIbflag(cHSUtilFactorINVOs1[i].getIbflag());
					
					boolean isExist = false;
					for(int j=0; j<tmpData.size(); j++)
					{
						if(tmpData.get(j).getYdCd().equals(mp.getYdCd()))
						{
							update1.add(mp);
							isExist = true;
							break;
						}
					}
					if(isExist == false)
					{
						insert1.add(mp);
					}
				}
			}
			for(int i=0; i<cHSUtilFactorINVOs2.length; i++){
				if(cHSUtilFactorINVOs2[i].getIbflag().equals("I")
						   || cHSUtilFactorINVOs2[i].getIbflag().equals("U"))
				{			
					mp = new CHSUtilFactorINVO();
					mp.setChssUsgRto(cHSUtilFactorINVOs2[i].getChssUsgRto());
					mp.setCnmvStsCd(cHSUtilFactorINVOs2[i].getCnmvStsCd());
					mp.setCntrPsnStsCd(cHSUtilFactorINVOs2[i].getCntrPsnStsCd());
					mp.setEg5PreKntQty(cHSUtilFactorINVOs2[i].getEg5PreKntQty());
					
					mp.setCntrDryRfIndCd(cHSUtilFactorINVO.getCntrDryRfIndCd());//form column
					mp.setLocCd(cHSUtilFactorINVO.getLocCd()); 					//form column
					mp.setYdCd(cHSUtilFactorINVO.getYdCd()); 					//sheet1 키 -> form column
					
					mp.setUpdUsrId(account.getUsr_id());
					mp.setCreUsrId(account.getUsr_id());
					mp.setIbflag(cHSUtilFactorINVOs2[i].getIbflag());
					
					boolean isExist = false;
					for(int j=0; j<tmpDtlData.size(); j++)
					{
						if(tmpDtlData.get(j).getYdCd().equals(mp.getYdCd())
							&& tmpDtlData.get(j).getLocCd().equals(mp.getLocCd())
							&& tmpDtlData.get(j).getCntrDryRfIndCd().equals(mp.getCntrDryRfIndCd())
							&& tmpDtlData.get(j).getCnmvStsCd().equals(mp.getCnmvStsCd())
						)
						{
							update2.add(mp);
							isExist = true;
							break;
						}
					}
					if(isExist == false)
					{
						insert2.add(mp);
					}
				}
			}		
			log.debug("####### insert1.size() #######" + insert1.size());
			log.debug("####### update1.size() #######" + update1.size());
			log.debug("####### insert2.size() #######" + insert2.size());
			log.debug("####### update2.size() #######" + update2.size());
		
			if(insert1.size()>0)
			{
				dbDao.addCHSEg5CountData(insert1); 
			}
			if(update1.size()>0)
			{
				dbDao.modifyCHSEg5CountData(update1);
			}
			if(insert2.size()>0)
			{
				dbDao.addCHSUtilizationUsageData(insert2); 
			}
			if(update2.size()>0)
			{
				dbDao.modifyCHSUtilizationUsageData(update2); 
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Chassis Utilization report 정보 조회(Chassis Utilization조회) [EES_CGM_1112] <br>
	 *  
	 * @param cHSUtilizationINVO CHSUtilizationINVO 
	 * @return CHSUtilizationMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */	
	public CHSUtilizationMGTVO  searchCHSUtilizationRptBasic(CHSUtilizationINVO cHSUtilizationINVO) throws EventException
	{
		//List[] voList = new ArrayList[4];
		try {
			CHSUtilizationMGTVO cHSUtilizationMGTVO = new CHSUtilizationMGTVO();
			String tmp_inq_fm_dys = cHSUtilizationINVO.getInqFmDys();
			String tmp_inq_to_dys = cHSUtilizationINVO.getInqToDys();
			
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			
			cHSUtilizationINVO.setInqFmDys(tmp_inq_fm_dys);
			cHSUtilizationINVO.setInqToDys(tmp_inq_to_dys);
			
			String cnrtSccCd = cHSUtilizationINVO.getSccCd();
			if(cnrtSccCd != null && !cnrtSccCd.equals("")){
				cnrtSccCd = "'" + cnrtSccCd.replaceAll(",", "','") + "'";
				cHSUtilizationINVO.setSccCd(cnrtSccCd);
			}
			
			//W
			cHSUtilizationINVO.setCntrPsnStsCd("W");
			//voList[0] = dbDao.searchCHSUtilizationRptWGData(cHSUtilizationINVO);
			cHSUtilizationMGTVO.setList0(dbDao.searchCHSUtilizationRptWGData(cHSUtilizationINVO));
			//G
			cHSUtilizationINVO.setCntrPsnStsCd("G");
			//voList[1] = dbDao.searchCHSUtilizationRptWGData(cHSUtilizationINVO);
			cHSUtilizationMGTVO.setList1(dbDao.searchCHSUtilizationRptWGData(cHSUtilizationINVO));
			cHSUtilizationINVO.setCntrPsnStsCd("");
			//voList[2] = dbDao.searchCHSUtilizationRptInventoryData(cHSUtilizationINVO);
			//voList[3] = dbDao.searchCHSUtilizationRptEtcData(cHSUtilizationINVO);
			cHSUtilizationMGTVO.setList2(dbDao.searchCHSUtilizationRptInventoryData(cHSUtilizationINVO));
			cHSUtilizationMGTVO.setList3(dbDao.searchCHSUtilizationRptEtcData(cHSUtilizationINVO));
			
			
			return cHSUtilizationMGTVO;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 조회 조건별 Historical Report 산출. [EES_CGM_1113] <br>
	 *  
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return List<CHSHistoricalRptMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportBasic(CHSHistoricalRptINVO cHSHistoricalRptINVO) throws EventException
	{
		try {
			
	      	/*
	      	"I|Chassis Inventory";
	      	"C|Container Status";
			"v|Available Chassis";
			"A|Assigned Days";
			"U|Usage Days";
			"t|Utilization (%)";
			*/
			
			String tmp_inq_fm_dys = cHSHistoricalRptINVO.getInqFmDys();
			String tmp_inq_to_dys = cHSHistoricalRptINVO.getInqToDys();
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			cHSHistoricalRptINVO.setInqFmDys(tmp_inq_fm_dys);
			cHSHistoricalRptINVO.setInqToDys(tmp_inq_to_dys);
			
			String crntLccCd = cHSHistoricalRptINVO.getCrntLccCd();
			if(crntLccCd != null && !crntLccCd.equals("")){
				crntLccCd = "'" + crntLccCd.replaceAll(",", "', '") + "'";
				cHSHistoricalRptINVO.setCrntLccCd(crntLccCd);
			}
			
			String crntSccCd = cHSHistoricalRptINVO.getCrntSccCd();
			if(crntSccCd != null && !crntSccCd.equals("")){
				crntSccCd = "'" + crntSccCd.replaceAll(",", "', '") + "'";
				cHSHistoricalRptINVO.setCrntSccCd(crntSccCd);
			}
			
			String crntYdCd = cHSHistoricalRptINVO.getCrntYdCd();
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "', '") + "'";
				cHSHistoricalRptINVO.setCrntYdCd(crntYdCd);
			}
			
			if(cHSHistoricalRptINVO.getReportType().equals("I"))
				return dbDao.searchCHSHistoricalReportByInvtData (cHSHistoricalRptINVO);
			else if(cHSHistoricalRptINVO.getReportType().equals("C"))
			{
				//cnmv_sts_cd 적용
				String cnmvStsCd = cHSHistoricalRptINVO.getCnmvStsCd();
				
				cnmvStsCd = cnmvStsCd.replaceAll(",G","");
				cnmvStsCd = cnmvStsCd.replaceAll(",W","");
				cnmvStsCd = cnmvStsCd.replaceAll("G,","");
				cnmvStsCd = cnmvStsCd.replaceAll("W,","");
				cnmvStsCd = cnmvStsCd.replaceAll("G","");
				cnmvStsCd = cnmvStsCd.replaceAll("W","");
				if(cnmvStsCd.equals(""))
				{
					cHSHistoricalRptINVO.setCnmvStsCd(cnmvStsCd);
				}
				if(cnmvStsCd != null && !cnmvStsCd.equals("")){
					cnmvStsCd = "'" + cnmvStsCd.replaceAll(",", "','") + "'";
					cHSHistoricalRptINVO.setCnmvStsCd(cnmvStsCd);
				}
				
				//cntr_psn_sts_cd 적용
				String cntrPsnStsCd = cHSHistoricalRptINVO.getCntrPsnStsCd();
				if(cntrPsnStsCd!= null && !cntrPsnStsCd.equals("")){
					cntrPsnStsCd = "'" + cntrPsnStsCd.replaceAll(",", "','") + "'";
					cHSHistoricalRptINVO.setCntrPsnStsCd(cntrPsnStsCd);
				}
				
				return dbDao.searchCHSHistoricalReportByCntrStsData (cHSHistoricalRptINVO);
			}else if(cHSHistoricalRptINVO.getReportType().equals("v"))
				return dbDao.searchCHSHistoricalReportByAvailChsData (cHSHistoricalRptINVO);
			else if(cHSHistoricalRptINVO.getReportType().equals("A"))
				return dbDao.searchCHSHistoricalReportByAsgnDayData (cHSHistoricalRptINVO);
			else if(cHSHistoricalRptINVO.getReportType().equals("U"))
				return dbDao.searchCHSHistoricalReportByUsageDayData (cHSHistoricalRptINVO);
			else if(cHSHistoricalRptINVO.getReportType().equals("t"))
				return dbDao.searchCHSHistoricalReportByUtilizationData (cHSHistoricalRptINVO);
			else
				throw new DAOException();
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * ESP(Equipment Standard Pool)  Report 산출 변수를 조회한다. [EES_CGM_1114] <br>
	 *  
	 * @param cHSEspFactorINVO CHSEspFactorINVO 
	 * @return List<CHSEspFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSEspFactorMGTVO> searchCHSEspFactorBasic (CHSEspFactorINVO cHSEspFactorINVO) throws EventException
	{
		try {
			
			return dbDao.searchCHSEspAdjustData (cHSEspFactorINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
	}
	
	
	/**
	 * ESP(Equipment Standard Pool)  Report 산출 변수를 설정한다. [EES_CGM_1114] <br>
	 *  
	 * @param cHSEspFactorINVOs CHSEspFactorINVO[] 
	 * @exception DAOException
	 * @exception Exception
	 */	
	public void manageCHSEspFactorBasic (CHSEspFactorINVO[] cHSEspFactorINVOs) throws EventException
	{
		try
		{
			List<CHSEspFactorINVO> insertList = new ArrayList<CHSEspFactorINVO>();
			List<CHSEspFactorINVO> updateList = new ArrayList<CHSEspFactorINVO>();		
			for(int i=0; i<cHSEspFactorINVOs.length; i++){
				if(cHSEspFactorINVOs[i].getIbflag().equals("I"))
				{
					insertList.add(cHSEspFactorINVOs[i]);
				}else if(cHSEspFactorINVOs[i].getIbflag().equals("U"))
				{
					updateList.add(cHSEspFactorINVOs[i]);
				}
			}

			if(insertList.size()>0)
			{
				for(int i=0; i< insertList.size(); i++)
					dbDao.addCHSEspAdjustData(insertList.get(i)); 
			}
			if(updateList.size()>0)
			{
				for(int i=0; i< updateList.size(); i++)
					dbDao.modifyCHSEspAdjustData(updateList.get(i));
			}
	
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 조회시작  [EES_CGM_1115] <br>
	 *  
	 * @param cHSEspReportINVO CHSEspReportINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSEspReportBasicBackEndJobStart  (CHSEspReportINVO cHSEspReportINVO) throws EventException
	{
		try {
			// BC 객체 생성
			ChassisMgsetInventoryEspReportBackEndJob command = new ChassisMgsetInventoryEspReportBackEndJob();
			command.setCHSEspReportINVO(cHSEspReportINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, cHSEspReportINVO.getUserId(), "Request Expense");
			return backEndJobKey;
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
	}
	/**
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 조회  [EES_CGM_1115] <br>
	 *  
	 * @param key String 
	 * @return List<CHSEspReportMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSEspReportMGTVO> searchCHSEspReportBasic  (String key) throws EventException
	//public List<CHSEspReportMGTVO> searchCHSEspReportBasic  (CHSEspReportINVO cHSEspReportINVO) throws EventException
	{
		/* 기존 non-batch job 
		try {
			String tmp_throughput_inq_fm_dys = cHSEspReportINVO.getTroughputInqFmDys();
			String tmp_throughput_inq_to_dys = cHSEspReportINVO.getTroughputInqToDys();
			tmp_throughput_inq_fm_dys = tmp_throughput_inq_fm_dys.replaceAll("-", "");
			tmp_throughput_inq_to_dys = tmp_throughput_inq_to_dys.replaceAll("-", "");
			cHSEspReportINVO.setTroughputInqFmDys(tmp_throughput_inq_fm_dys);
			cHSEspReportINVO.setTroughputInqToDys(tmp_throughput_inq_to_dys);
			
			String tmp_turntime_inq_fm_dys = cHSEspReportINVO.getTroughputInqFmDys();
			String tmp_turntime_inq_to_dys = cHSEspReportINVO.getTroughputInqToDys();
			tmp_turntime_inq_to_dys = cHSEspReportINVO.getTroughputInqToDys();
			tmp_turntime_inq_fm_dys = tmp_turntime_inq_fm_dys.replaceAll("-", "");
			tmp_turntime_inq_to_dys = tmp_turntime_inq_to_dys.replaceAll("-", "");
			cHSEspReportINVO.setTroughputInqFmDys(tmp_turntime_inq_fm_dys);
			cHSEspReportINVO.setTroughputInqToDys(tmp_turntime_inq_to_dys);
			
			return dbDao.searchCHSEspReportData  (cHSEspReportINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
		*/
		try {
			return dbDao.searchCHSEspReportDataFile(key);					
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 기본적 인벤토리 조회 화면인 M.G.Set Inventory Summary 산출.  [EES_CGM_2076]<br>
	 * 
	 * @param mGSInventoryGeneralINVO MGSInventoryGeneralINVO   
	 * @return List<MGSInventoryGeneralMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryGeneralMGTVO> searchMGSInventoryGeneralBasic(MGSInventoryGeneralINVO mGSInventoryGeneralINVO) throws EventException
	{
		try {
			String eqTpszCd = mGSInventoryGeneralINVO.getEqTpszCd();
			String crntYdCd = mGSInventoryGeneralINVO.getCrntYdCd();
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			
			if(eqTpszCd != null && !eqTpszCd.equals("")){
				eqTpszCd = "'" + eqTpszCd.replaceAll(",", "','") + "'";
				mGSInventoryGeneralINVO.setEqTpszCd(eqTpszCd);
			}
			
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				mGSInventoryGeneralINVO.setCrntYdCd(crntYdCd);
			}

			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			
			return dbDao.searchMGSInventoryGeneralData(mGSInventoryGeneralINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * [EES_CGM_2075] : [Retrieve] <br>
	 * M.G.Set Inventory Detail SEARCH Basic Implement<br>
	 *
	 * @param mGSInventoryDetailINVO MGSInventoryDetailINVO
	 * @return List<MGSInventoryDetailMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSInventoryDetailMGTVO> searchMGSInventoryDetailBasic(MGSInventoryDetailINVO mGSInventoryDetailINVO) throws EventException
	{
		MGSInventoryDetailINVO invo = new MGSInventoryDetailINVO();
		List<MGSInventoryDetailMGTVO> resultVo = new ArrayList<MGSInventoryDetailMGTVO>();
		
		String sEqNo		= mGSInventoryDetailINVO.getEqNo();
		String sLocList		= mGSInventoryDetailINVO.getLocList();
		
		try {
			// Genset No(eq_no) 
			if(sEqNo != null && !sEqNo.trim().equals("")) {
				sEqNo = "'" + sEqNo.replaceAll(",", "','") + "'";
				invo.setEqNo(sEqNo);
			}
			
			// Location List
			if(sLocList != null && !sLocList.trim().equals("")) {
				sLocList = "'" + sLocList.replaceAll(",", "','") + "'";
				invo.setLocList(sLocList);
			}
			
			// Location CD
			invo.setLocCd(mGSInventoryDetailINVO.getLocCd());
			
			// Active Status(aciac_div_cd)
			if(mGSInventoryDetailINVO.getAciacDivCd().equals("All")) {
				invo.setAciacDivCd("");
			} else {
				invo.setAciacDivCd(mGSInventoryDetailINVO.getAciacDivCd());
			}
			
			// M.G.Set Type(eq_tpsz_cd)
			if(mGSInventoryDetailINVO.getEqTpszCd().equals("All")) {
				invo.setEqTpszCd("");
			} else {
				invo.setEqTpszCd(mGSInventoryDetailINVO.getEqTpszCd());
			}
			
			// Attach/Detach(atch_dtch)
			if(mGSInventoryDetailINVO.getAtchDtch().equals("All")) {
				invo.setAtchDtch("");
			} else {
				invo.setAtchDtch(mGSInventoryDetailINVO.getAtchDtch());
			}
			
			// Staying Days (over)(sty_dys_ov)
			invo.setStyDysOv(mGSInventoryDetailINVO.getStyDysOv());
			
			resultVo = dbDao.searchMGSInventoryDetailData(invo);
			
			return resultVo;
			
		}catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Inventory By Lessor and Agreement Type (UMG/CLG) 별 Summary 조회  [EES_CGM_2077]<br>
	 * 
	 * @param mGSInventoryByLessorAgmtINVO MGSInventoryByLessorAgmtINVO   
	 * @return List<MGSInventoryByLessorAgmtMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLessorAgmtMGTVO> searchMGSInventoryByLessorAgmtBasic (MGSInventoryByLessorAgmtINVO mGSInventoryByLessorAgmtINVO) throws EventException
	{
		try {
			String crntOfcCd = mGSInventoryByLessorAgmtINVO.getCrntOfcCd();
			String vndrSeq = mGSInventoryByLessorAgmtINVO.getVndrSeq();
			String agmtLstmCd = mGSInventoryByLessorAgmtINVO.getAgmtLstmCd();
			
			if(crntOfcCd != null && !crntOfcCd.equals("")){
				crntOfcCd = "'" + crntOfcCd.replaceAll(",", "','") + "'";
				mGSInventoryByLessorAgmtINVO.setCrntOfcCd(crntOfcCd);
			}
			
			if(vndrSeq != null && !vndrSeq.equals("")){
				vndrSeq = "'" + vndrSeq.replaceAll(",", "','") + "'";
				mGSInventoryByLessorAgmtINVO.setVndrSeq(vndrSeq);
			}

			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				mGSInventoryByLessorAgmtINVO.setAgmtLstmCd(agmtLstmCd);
			}
			return dbDao.searchMGSInventoryByLessorAgmtData (mGSInventoryByLessorAgmtINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
	}
	
	/**
	 * Inventory By Lessor and Term(Lessor, Lease Term 별 장비 Inventory)에서 Location 별 Term 별 장비 TP/SZ 를 카운트하여 조회.  [EES_CGM_2078]<br>
	 * 
	 * @param mGSInventoryByLessorTermINVO MGSInventoryByLessorTermINVO   
	 * @return List<MGSInventoryByLessorTermMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLessorTermMGTVO> searchMGSInventoryByLessorTermBasic  (MGSInventoryByLessorTermINVO mGSInventoryByLessorTermINVO) throws EventException
	{
		try {
			String crntYdCd = mGSInventoryByLessorTermINVO.getCrntYdCd();
			String vndrSeq = mGSInventoryByLessorTermINVO.getVndrSeq();
			String agmtLstmCd = mGSInventoryByLessorTermINVO.getAgmtLstmCd();
			
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				mGSInventoryByLessorTermINVO.setCrntYdCd(crntYdCd);
			}
			
			if(vndrSeq != null && !vndrSeq.equals("")){
				vndrSeq = "'" + vndrSeq.replaceAll(",", "','") + "'";
				mGSInventoryByLessorTermINVO.setVndrSeq(vndrSeq);
			}

			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				mGSInventoryByLessorTermINVO.setAgmtLstmCd(agmtLstmCd);
			}
			return dbDao.searchMGSInventoryByLessorTermData  (mGSInventoryByLessorTermINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 * Inventory By Creation office On-hire Office 별, 기간별 장비 Inventory 산출.  [EES_CGM_2079]<br>
	 * 
	 * @param mGSInventoryByOfficeINVO MGSInventoryByOfficeINVO   
	 * @return List<MGSInventoryByOfficeMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByOfficeMGTVO> searchMGSInventoryByOfficeBasic  (MGSInventoryByOfficeINVO mGSInventoryByOfficeINVO) throws EventException
	{
		try {
			String crntOfcCd = mGSInventoryByOfficeINVO.getCrntOfcCd();
			
			if(crntOfcCd != null && !crntOfcCd.equals("")){
				crntOfcCd = "'" + crntOfcCd.replaceAll(",", "','") + "'";
				mGSInventoryByOfficeINVO.setCrntOfcCd(crntOfcCd);
			}
			
			String tmp_inq_fm_dys = mGSInventoryByOfficeINVO.getInqFmDys();
			String tmp_inq_to_dys = mGSInventoryByOfficeINVO.getInqToDys();
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			mGSInventoryByOfficeINVO.setInqFmDys(tmp_inq_fm_dys);
			mGSInventoryByOfficeINVO.setInqToDys(tmp_inq_to_dys);
			
			return dbDao.searchMGSInventoryByOfficeData(mGSInventoryByOfficeINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}				
	}
	
	/**
	 * Location& Lessor별 Inventory를 산출.  [EES_CGM_2080]<br>
	 * 
	 * @param mGSInventoryByLocationLessorINVO MGSInventoryByLocationLessorINVO   
	 * @return List<MGSInventoryByLocationLessorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLocationLessorMGTVO> searchMGSInventoryByLocationLessorBasic (MGSInventoryByLocationLessorINVO mGSInventoryByLocationLessorINVO) throws EventException
	{
		try {
			String crntYdCd = mGSInventoryByLocationLessorINVO.getCrntYdCd();
			String vndrSeq = mGSInventoryByLocationLessorINVO.getVndrSeq();
			
			if(crntYdCd != null && !crntYdCd.equals("")){
				crntYdCd = "'" + crntYdCd.replaceAll(",", "','") + "'";
				mGSInventoryByLocationLessorINVO.setCrntYdCd(crntYdCd);
			}
			
			if(vndrSeq != null && !vndrSeq.equals("")){
				vndrSeq = "'" + vndrSeq.replaceAll(",", "','") + "'";
				mGSInventoryByLocationLessorINVO.setVndrSeq(vndrSeq);
			}

			return dbDao.searchMGSInventoryByLocationLessorData (mGSInventoryByLocationLessorINVO);
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
	}
	
	/**
	 * Inventory Variation 산출시작. Back End Job  [EES_CGM_1102] <br>
	 *  
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSInventoryByVariationBasicBackEndJobStart  (CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws EventException
	{
		try {
			// BC 객체 생성
			ChassisMgsetInventoryVariationStatusBackEndJob command = new ChassisMgsetInventoryVariationStatusBackEndJob();
			command.setCHSInventoryByVariationINVO(cHSInventoryByVariationINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, cHSInventoryByVariationINVO.getUserId(), "Request Expense");
			return backEndJobKey;
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 * Inventory Variation 산출끝. Back End Job  [EES_CGM_1102] <br>
	 *  
	 * @param key String 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationBasicFile  (String key) throws EventException
	{
		try {
			return dbDao.searchCHSInventoryByVariationDataFile(key);					
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Inventory Variation 산출시작. Back End Job  [EES_CGM_1103] <br>
	 *  
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSInventoryByVariationDtlBasicBackEndJobStart  (CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws EventException
	{
		try {
			// BC 객체 생성
			ChassisMgsetInventoryVariationStatusDtlBackEndJob command = new ChassisMgsetInventoryVariationStatusDtlBackEndJob();
			command.setCHSInventoryByVariationDtlINVO(cHSInventoryByVariationDtlINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, cHSInventoryByVariationDtlINVO.getUserId(), "Request Expense");
			return backEndJobKey;
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}			
	}

	/**
	 * Inventory Variation 산출끝. Back End Job  [EES_CGM_1103] <br>
	 *  
	 * @param key String 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlBasicFile  (String key) throws EventException
	{
		try {
			return dbDao.searchCHSInventoryByVariationDtlDataFile(key);					
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}
	
	/**
	 * 연도별 자산 집계현황을 조회한다.<br>
	 * 
	 * @author J.H
	 * @category EES_CGM_1153
	 * @category searchCHSAssetsSmryListBasic   
	 * 
	 * @param CHSAssetsOptionVO chsAssetsOptionVO
	 * @return List<CHSAssetsSmryVO>
	 * @exception EventException
	 */			
	public List<CHSAssetsSmryVO> searchCHSAssetsSmryListBasic(CHSAssetsOptionVO chsAssetsOptionVO) throws EventException {
		try {
			return dbDao.searchCHSAssetsSmryListData(chsAssetsOptionVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}			
	}		
    
	/**
	 * 연도별 자산 현황을 장비별로 상세 조회한다.<br>
	 * 
	 * @author J.H
	 * @category EES_CGM_1154
	 * @category searchCHSAssetsDetailListBasic  
	 * 
	 * @param CHSAssetsSmryVO chsAssetsSmryVO
	 * @return List<CHSAssetsDetailVO>
	 * @exception EventException
	 */			
	public List<CHSAssetsDetailVO> searchCHSAssetsDetailListBasic(CHSAssetsSmryVO chsAssetsSmryVO) throws EventException {
		try {
			return dbDao.searchCHSAssetsDetailListData(chsAssetsSmryVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}			
	}


	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return List<MGSBareMVMTDataVO>
	 * @exception EventException
	 */
	public List<MGSBareMVMTDataVO> searchBareMGSet(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		try {
			return dbDao.searchBareMGSetData(mGSBareMVMTDataVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 *  조회한다.<br>
	 * 
	 * @param  mGSBareMVMTDataVO MGSBareMVMTDataVO
	 * @return chk_mgset String
	 * @exception EventException
	 */	
	public String searchMGSetNo(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		try {
			
			DBRowSet rs = dbDao.searchBareMGSetNoData(mGSBareMVMTDataVO);
			String chk_mgset = "";
			if(rs.next()) {
				chk_mgset = rs.getString("CHK_MGSET");
			}
			
			return chk_mgset;
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String eqTpszCd
	 * @exception EventException
	 */
	public String[] searchEqTpszCd(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		try {
			
			DBRowSet rs = dbDao.searchEqTpszCdData(mGSBareMVMTDataVO);
			String[] eqTpszCd = new String [2];
			if(rs.next()) {
				eqTpszCd[0] = rs.getString("EQ_TPSZ_CD");
				eqTpszCd[1] = rs.getString("ORG_YD_CD");
			}
			return eqTpszCd;
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String chk
	 * @exception EventException
	 */
	public String checkBareMGSetContNoData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		try {
			DBRowSet rs = dbDao.checkBareMGSetContNoData(mGSBareMVMTDataVO);
			String chk = "";
			if(rs.next()) {
				chk = rs.getString("CHK_EQNO");
			}
			return chk;
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	/**
	 *  UMG CASE  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String[] chk
	 * @exception EventException
	 */
	public String[] searchBareMGSetCLGData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchBareMGSetCLGData(mGSBareMVMTDataVO);
			String[] chk = new String [2];
			if(rs.next()) {
				chk[0] = rs.getString("MVMT");
				chk[1] = rs.getString("LSDAYS");
			}
			return chk;
		
		}catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String chk
	 * @exception EventException
	 */
	public String checkBareMGSetChsNoData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		try {
			DBRowSet rs = dbDao.checkBareMGSetChsNoData(mGSBareMVMTDataVO);
			String chk = "";
			if(rs.next()) {
				chk = rs.getString("CHK_CHSNO");
			}
			return chk;
			
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  UMG CASE  조회한다.<br>
	 * 
	 * @author ksm
	 * @category EES_CGM_2213
	 * @category   
	 * 
	 * @param mGSBareMVMTDataVO MGSBareMVMTDataVO 
	 * @return chk String[]
	 * @exception EventException
	 */
	public String[] searchBareMGSetUMGData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException {
		 try {
		DBRowSet rs = dbDao.searchBareMGSetUMGData(mGSBareMVMTDataVO);
		String[] chk = new String [2];
		if(rs.next()) {
			chk[0] = rs.getString("MVMT");
			chk[1] = rs.getString("LSDAYS");
		}
		return chk;
		
	}catch (DAOException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
	}catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
	}
	}

	/**
	 *  데이터 입력 수정 삭제 처리.<br>
	 * 
	 * @author ksm
	 * @category EES_CGM_2213
	 * @category   
	 * 
	 * @param MGSBareMVMTDataVO[] mGSBareMVMTDataVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMGSetDefaultData(MGSBareMVMTDataVO[] mGSBareMVMTDataVOs, SignOnUserAccount account) throws EventException {
		
		try {
			List<MGSBareMVMTDataVO> insertVoList = new ArrayList<MGSBareMVMTDataVO>();
			List<MGSBareMVMTDataVO> updateVoList = new ArrayList<MGSBareMVMTDataVO>();
			List<MGSBareMVMTDataVO> deleteVoList = new ArrayList<MGSBareMVMTDataVO>();
			
			for ( int i=0; i<mGSBareMVMTDataVOs.length; i++ ) {
				String status =mGSBareMVMTDataVOs[i].getDelChk();				
				if(status.equals("1")){
					mGSBareMVMTDataVOs[i].setIbflag("D");
				}
//				String bmp =mGSBareMVMTDataVOs[i].getMgstBareBmpFlg();
//				String bmt =mGSBareMVMTDataVOs[i].getMgstBareBmtFlg();
				
//				if(bmp.equals("1"))	mGSBareMVMTDataVOs[i].setMgstBareBmpFlg("Y");  // bmp check
//				else				mGSBareMVMTDataVOs[i].setMgstBareBmpFlg("N");  // bmp uncheck
//				
//				if(bmt.equals("1"))	mGSBareMVMTDataVOs[i].setMgstBareBmtFlg("Y");  // bmt check
//				else				mGSBareMVMTDataVOs[i].setMgstBareBmtFlg("N");  // bmt uncheck
								
				mGSBareMVMTDataVOs[i].setUpdUsrId(account.getUsr_id());
				mGSBareMVMTDataVOs[i].setCreOfcCd(account.getOfc_cd());
				
				if ( mGSBareMVMTDataVOs[i].getIbflag().equals("I")){ // insert					
					insertVoList.add(mGSBareMVMTDataVOs[i]);
				} else if ( mGSBareMVMTDataVOs[i].getIbflag().equals("U")){  // modify
					updateVoList.add(mGSBareMVMTDataVOs[i]);
				} else if ( mGSBareMVMTDataVOs[i].getIbflag().equals("D")){  // delete
					deleteVoList.add(mGSBareMVMTDataVOs[i]);
				}				
			} 

			if ( insertVoList.size() > 0 ) {
				dbDao.addBareMGSetData(insertVoList);
				dbDao.modifyCgmEquipmentMaster(insertVoList); // MGSET MASTER 정보 수정
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntDefaultCurrS(updateVoList);
				dbDao.modifyCgmEquipmentMaster(updateVoList); // MGSET MASTER 정보 수정
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntDefaultCurrS(deleteVoList);
			}
			
		} catch(DuplicateKeyException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12115",new String[]{"Country Code"}).getMessage());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		
	}



}
