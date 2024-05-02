/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EQMatchBackNLoadFactorMgtBCImpl.java
 *@FileTitle : Location M/B by Logistics-Wise
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :   
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration.EQMatchBackNLoadFactorMgtDBDAO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.CargoFlowMapSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS--CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see EES_CIM_1023EventResponse,EQMatchBackNLoadFactorMgtBC DAO class reference
 * @since J2EE 1.6
 */
public class EQMatchBackNLoadFactorMgtBCImpl extends BasicCommandSupport implements EQMatchBackNLoadFactorMgtBC {

	// Database Access Object
	private transient EQMatchBackNLoadFactorMgtDBDAO dbDao = null;

	/**
	 * EQMatchBackNLoadFactorMgtBCImpl object creation <br>
	 * EQMatchBackNLoadFactorMgtDBDAO creation <br>
	 */
	public EQMatchBackNLoadFactorMgtBCImpl() {
		dbDao = new EQMatchBackNLoadFactorMgtDBDAO();
	}

	/**
	 * Retrieving [Terminal MatchBack] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseSummary(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		try {
			// return dbDao.searchTMLMBByLogisticWiseSummary
			// (mBSearchOptionInGereralVO);
			List<QuantityByTypeSizeVO> list = dbDao.searchTMLMBByLogisticWiseSummary(mBSearchOptionInGereralVO);

			double[] inQty = new double[40];

			double[] outQty = new double[40];

			double[] mbQty = new double[40];

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>();
			QuantityByTypeSizeVO vo = null;
			int x = 0;
			if (x == 0) {

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(list.get(x).getLocCd());
				vo.setYardCd(list.get(x).getYardCd());
				vo.setTotal(list.get(x).getTotal());
				vo.setQty0(list.get(x).getQty0());
				vo.setQty1(list.get(x).getQty1());
				vo.setQty2(list.get(x).getQty2());
				vo.setQty3(list.get(x).getQty3());
				vo.setQty4(list.get(x).getQty4());
				vo.setQty5(list.get(x).getQty5());
				vo.setQty6(list.get(x).getQty6());
				vo.setQty7(list.get(x).getQty7());
				vo.setQty8(list.get(x).getQty8());
				vo.setQty9(list.get(x).getQty9());
				vo.setQty10(list.get(x).getQty10());
				vo.setQty11(list.get(x).getQty11());
				vo.setQty12(list.get(x).getQty12());
				vo.setQty13(list.get(x).getQty13());
				vo.setQty14(list.get(x).getQty14());
				vo.setQty15(list.get(x).getQty15());
				vo.setQty16(list.get(x).getQty16());
				vo.setQty17(list.get(x).getQty17());
				vo.setQty18(list.get(x).getQty18());
				vo.setQty19(list.get(x).getQty19());
				vo.setQty20(list.get(x).getQty20());
				vo.setQty21(list.get(x).getQty21());
				vo.setQty22(list.get(x).getQty22());
				vo.setQty23(list.get(x).getQty23());
				vo.setQty24(list.get(x).getQty24());
				vo.setQty25(list.get(x).getQty25());
				vo.setQty26(list.get(x).getQty26());
				vo.setQty27(list.get(x).getQty27());
				vo.setQty28(list.get(x).getQty28());
				vo.setQty29(list.get(x).getQty29());
				vo.setQty30(list.get(x).getQty30());
				vo.setQty31(list.get(x).getQty31());
				vo.setQty32(list.get(x).getQty32());
				vo.setQty33(list.get(x).getQty33());
				vo.setQty34(list.get(x).getQty34());
				vo.setQty35(list.get(x).getQty35());
				vo.setQty36(list.get(x).getQty36());
				vo.setQty37(list.get(x).getQty37());
				vo.setQty38(list.get(x).getQty38());
				vo.setQty39(list.get(x).getQty39());
				list2.add(x, vo);
				x++;
			}

			for (int i = 1; i < list.size(); i++) {
				int k = 0;

				String strYardCd = list.get(i).getYardCd();
				String strLocCd = list.get(i).getLocCd();
				String strDivision = list.get(i).getDivision();

				if (strDivision.equals("M/B(%)")) {
					k = 3;
				}
				// putting Match Back data into VO (SUMMARY Tab)
				if (!"".equals(strYardCd) && strDivision.equals("M/B(%)")) {
					vo = new QuantityByTypeSizeVO();

					vo.setLocCd(list.get(i).getLocCd());
					vo.setYardCd(list.get(i).getYardCd());
					vo.setTotal(list.get(i).getTotal());

					vo.setQty0(list.get(i).getQty0());
					vo.setQty1(list.get(i).getQty1());
					vo.setQty2(list.get(i).getQty2());
					vo.setQty3(list.get(i).getQty3());
					vo.setQty4(list.get(i).getQty4());
					vo.setQty5(list.get(i).getQty5());
					vo.setQty6(list.get(i).getQty6());
					vo.setQty7(list.get(i).getQty7());
					vo.setQty8(list.get(i).getQty8());
					vo.setQty9(list.get(i).getQty9());
					vo.setQty10(list.get(i).getQty10());
					vo.setQty11(list.get(i).getQty11());
					vo.setQty12(list.get(i).getQty12());
					vo.setQty13(list.get(i).getQty13());
					vo.setQty14(list.get(i).getQty14());
					vo.setQty15(list.get(i).getQty15());
					vo.setQty16(list.get(i).getQty16());
					vo.setQty17(list.get(i).getQty17());
					vo.setQty18(list.get(i).getQty18());
					vo.setQty19(list.get(i).getQty19());
					vo.setQty20(list.get(i).getQty20());
					vo.setQty21(list.get(i).getQty21());
					vo.setQty22(list.get(i).getQty22());
					vo.setQty23(list.get(i).getQty23());
					vo.setQty24(list.get(i).getQty24());
					vo.setQty25(list.get(i).getQty25());
					vo.setQty26(list.get(i).getQty26());
					vo.setQty27(list.get(i).getQty27());
					vo.setQty28(list.get(i).getQty28());
					vo.setQty29(list.get(i).getQty29());
					vo.setQty30(list.get(i).getQty30());
					vo.setQty31(list.get(i).getQty31());
					vo.setQty32(list.get(i).getQty32());
					vo.setQty33(list.get(i).getQty33());
					vo.setQty34(list.get(i).getQty34());
					vo.setQty35(list.get(i).getQty35());
					vo.setQty36(list.get(i).getQty36());
					vo.setQty37(list.get(i).getQty37());
					vo.setQty38(list.get(i).getQty38());
					vo.setQty39(list.get(i).getQty39());
					list2.add(x, vo);
					x++;
				}

				if ("".equals(strYardCd) && "".equals(strLocCd)) {

					inQty[0] = Double.parseDouble(list.get(i - k).getQty0());
					inQty[1] = Double.parseDouble(list.get(i - k).getQty1());
					inQty[2] = Double.parseDouble(list.get(i - k).getQty2());
					inQty[3] = Double.parseDouble(list.get(i - k).getQty3());
					inQty[4] = Double.parseDouble(list.get(i - k).getQty4());
					inQty[5] = Double.parseDouble(list.get(i - k).getQty5());
					inQty[6] = Double.parseDouble(list.get(i - k).getQty6());
					inQty[7] = Double.parseDouble(list.get(i - k).getQty7());
					inQty[8] = Double.parseDouble(list.get(i - k).getQty8());
					inQty[9] = Double.parseDouble(list.get(i - k).getQty9());
					inQty[10] = Double.parseDouble(list.get(i - k).getQty10());
					inQty[11] = Double.parseDouble(list.get(i - k).getQty11());
					inQty[12] = Double.parseDouble(list.get(i - k).getQty12());
					inQty[13] = Double.parseDouble(list.get(i - k).getQty13());
					inQty[14] = Double.parseDouble(list.get(i - k).getQty14());
					inQty[15] = Double.parseDouble(list.get(i - k).getQty15());
					inQty[16] = Double.parseDouble(list.get(i - k).getQty16());
					inQty[17] = Double.parseDouble(list.get(i - k).getQty17());
					inQty[18] = Double.parseDouble(list.get(i - k).getQty18());
					inQty[19] = Double.parseDouble(list.get(i - k).getQty19());
					inQty[20] = Double.parseDouble(list.get(i - k).getQty20());
					inQty[21] = Double.parseDouble(list.get(i - k).getQty21());
					inQty[22] = Double.parseDouble(list.get(i - k).getQty22());
					inQty[23] = Double.parseDouble(list.get(i - k).getQty23());
					inQty[24] = Double.parseDouble(list.get(i - k).getQty24());
					inQty[25] = Double.parseDouble(list.get(i - k).getQty25());
					inQty[26] = Double.parseDouble(list.get(i - k).getQty26());
					inQty[27] = Double.parseDouble(list.get(i - k).getQty27());
					inQty[28] = Double.parseDouble(list.get(i - k).getQty28());
					inQty[29] = Double.parseDouble(list.get(i - k).getQty29());
					inQty[30] = Double.parseDouble(list.get(i - k).getQty30());
					inQty[31] = Double.parseDouble(list.get(i - k).getQty31());
					inQty[32] = Double.parseDouble(list.get(i - k).getQty32());
					inQty[33] = Double.parseDouble(list.get(i - k).getQty33());
					inQty[34] = Double.parseDouble(list.get(i - k).getQty34());
					inQty[35] = Double.parseDouble(list.get(i - k).getQty35());
					inQty[36] = Double.parseDouble(list.get(i - k).getQty36());
					inQty[37] = Double.parseDouble(list.get(i - k).getQty37());
					inQty[38] = Double.parseDouble(list.get(i - k).getQty38());
					inQty[39] = Double.parseDouble(list.get(i - k).getQty39());

					outQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0());
					outQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1());
					outQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2());
					outQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3());
					outQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4());
					outQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5());
					outQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6());
					outQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7());
					outQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8());
					outQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9());
					outQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10());
					outQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11());
					outQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12());
					outQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13());
					outQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14());
					outQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15());
					outQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16());
					outQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17());
					outQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18());
					outQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19());
					outQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20());
					outQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21());
					outQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22());
					outQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23());
					outQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24());
					outQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25());
					outQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26());
					outQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27());
					outQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28());
					outQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29());
					outQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30());
					outQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31());
					outQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32());
					outQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33());
					outQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34());
					outQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35());
					outQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36());
					outQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37());
					outQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38());
					outQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39());

					if (strDivision.equals("M/B(%)")) {
						for (int m = 0; m < outQty.length; m++) {

							if (inQty[m] >= outQty[m]) {
								if (outQty[m] > 0) {
									mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
								}
								else {
									mbQty[m] = 0;
								}
							}
							else if (outQty[m] > 0) {
								mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
							}
							else {
								mbQty[m] = 0;
							}
						}
						vo = new QuantityByTypeSizeVO();
						vo.setTotal(list.get(i).getTotal());
						vo.setQty0(Double.toString(mbQty[0]));
						vo.setQty1(Double.toString(mbQty[1]));
						vo.setQty2(Double.toString(mbQty[2]));
						vo.setQty3(Double.toString(mbQty[3]));
						vo.setQty4(Double.toString(mbQty[4]));
						vo.setQty5(Double.toString(mbQty[5]));
						vo.setQty6(Double.toString(mbQty[6]));
						vo.setQty7(Double.toString(mbQty[7]));
						vo.setQty8(Double.toString(mbQty[8]));
						vo.setQty9(Double.toString(mbQty[9]));
						vo.setQty10(Double.toString(mbQty[10]));
						vo.setQty11(Double.toString(mbQty[11]));
						vo.setQty12(Double.toString(mbQty[12]));
						vo.setQty13(Double.toString(mbQty[13]));
						vo.setQty14(Double.toString(mbQty[14]));
						vo.setQty15(Double.toString(mbQty[15]));
						vo.setQty16(Double.toString(mbQty[16]));
						vo.setQty17(Double.toString(mbQty[17]));
						vo.setQty18(Double.toString(mbQty[18]));
						vo.setQty19(Double.toString(mbQty[19]));
						vo.setQty20(Double.toString(mbQty[20]));
						vo.setQty21(Double.toString(mbQty[21]));
						vo.setQty22(Double.toString(mbQty[22]));
						vo.setQty23(Double.toString(mbQty[23]));
						vo.setQty24(Double.toString(mbQty[24]));
						vo.setQty25(Double.toString(mbQty[25]));
						vo.setQty26(Double.toString(mbQty[26]));
						vo.setQty27(Double.toString(mbQty[27]));
						vo.setQty28(Double.toString(mbQty[28]));
						vo.setQty29(Double.toString(mbQty[29]));
						vo.setQty30(Double.toString(mbQty[30]));
						vo.setQty31(Double.toString(mbQty[31]));
						vo.setQty32(Double.toString(mbQty[32]));
						vo.setQty33(Double.toString(mbQty[33]));
						vo.setQty34(Double.toString(mbQty[34]));
						vo.setQty35(Double.toString(mbQty[35]));
						vo.setQty36(Double.toString(mbQty[36]));
						vo.setQty37(Double.toString(mbQty[37]));
						vo.setQty38(Double.toString(mbQty[38]));
						vo.setQty39(Double.toString(mbQty[39]));
						list2.add(x, vo);
						x++;

					}
				}
			}

			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "TMNL M/B By Logistics-wise Summary Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "TMNL M/B By Logistics-wise Summary Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Terminal MatchBack Detail] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseDetail(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		try {
			return dbDao.searchTMLMBByLogisticWiseDetail(mBSearchOptionInGereralVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "TMNL M/B By Logistics-wise Detail Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "TMNL M/B By Logistics-wise Detail Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Lane MatchBack] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchLaneMBByLogisticWise(MBSearchOptionInGereralVO mBSearchOptionInGereralVO)
			throws EventException {
		try {
			List<QuantityByTypeSizeVO> list = dbDao.searchLaneMBByLogisticWise(mBSearchOptionInGereralVO);

			double[] inQty = new double[40];

			double[] outQty = new double[40];

			double[] mbQty = new double[40];
			
			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>(); 
			QuantityByTypeSizeVO vo = null;

			if (list.size() > 1) {

				int x = 0;
				int lastRNo = 0;
				lastRNo = list.size() - 1;
//				log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLaneMBByLogisticWise 1020 lastRNo [" + lastRNo+ "]");
				if (x == 0) {

					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(list.get(lastRNo).getLocCd());
					vo.setTotal(list.get(lastRNo).getTotal());
					vo.setQty0(list.get(lastRNo).getQty0());
					vo.setQty1(list.get(lastRNo).getQty1());
					vo.setQty2(list.get(lastRNo).getQty2());
					vo.setQty3(list.get(lastRNo).getQty3());
					vo.setQty4(list.get(lastRNo).getQty4());
					vo.setQty5(list.get(lastRNo).getQty5());
					vo.setQty6(list.get(lastRNo).getQty6());
					vo.setQty7(list.get(lastRNo).getQty7());
					vo.setQty8(list.get(lastRNo).getQty8());
					vo.setQty9(list.get(lastRNo).getQty9());
					vo.setQty10(list.get(lastRNo).getQty10());
					vo.setQty11(list.get(lastRNo).getQty11());
					vo.setQty12(list.get(lastRNo).getQty12());
					vo.setQty13(list.get(lastRNo).getQty13());
					vo.setQty14(list.get(lastRNo).getQty14());
					vo.setQty15(list.get(lastRNo).getQty15());
					vo.setQty16(list.get(lastRNo).getQty16());
					vo.setQty17(list.get(lastRNo).getQty17());
					vo.setQty18(list.get(lastRNo).getQty18());
					vo.setQty19(list.get(lastRNo).getQty19());
					vo.setQty20(list.get(lastRNo).getQty20());
					vo.setQty21(list.get(lastRNo).getQty21());
					vo.setQty22(list.get(lastRNo).getQty22());
					vo.setQty23(list.get(lastRNo).getQty23());
					vo.setQty24(list.get(lastRNo).getQty24());
					vo.setQty25(list.get(lastRNo).getQty25());
					vo.setQty26(list.get(lastRNo).getQty26());
					vo.setQty27(list.get(lastRNo).getQty27());
					vo.setQty28(list.get(lastRNo).getQty28());
					vo.setQty29(list.get(lastRNo).getQty29());
					vo.setQty30(list.get(lastRNo).getQty30());
					vo.setQty31(list.get(lastRNo).getQty31());
					vo.setQty32(list.get(lastRNo).getQty32());
					vo.setQty33(list.get(lastRNo).getQty33());
					vo.setQty34(list.get(lastRNo).getQty34());
					vo.setQty35(list.get(lastRNo).getQty35());
					vo.setQty36(list.get(lastRNo).getQty36());
					vo.setQty37(list.get(lastRNo).getQty37());
					vo.setQty38(list.get(lastRNo).getQty38());
					vo.setQty39(list.get(lastRNo).getQty39());
					list2.add(x, vo);
					x++;
				}

				for (int i = 0; i < lastRNo; i++) {
					int k = 0;

					// String strLanecd = list.get(i).getLaneCd();
					String strVvd = list.get(i).getVvd();
					String strDivision = list.get(i).getDivision();

					if (strDivision.equals("Balance")) {
						k = 2;
					}
					else if (strDivision.equals("M/B(%)")) {
						k = 3;
					}

					// log.debug("####### searchLaneMBByLogisticWise ("+i+") strVvd      ["
					// + strVvd + "]");
					// log.debug("####### searchLaneMBByLogisticWise ("+i+") strDivision ["
					// + strDivision + "]");

					if (strVvd.equals("ZZZZZZZZZZ")) {
						// list.get(i).setVvd("Total");
						// log.debug("####### searchLaneMBByLogisticWise ("+i+") setVvd S.Total");
						inQty[0] = Double.parseDouble(list.get(i - k).getQty0());
						inQty[1] = Double.parseDouble(list.get(i - k).getQty1());
						inQty[2] = Double.parseDouble(list.get(i - k).getQty2());
						inQty[3] = Double.parseDouble(list.get(i - k).getQty3());
						inQty[4] = Double.parseDouble(list.get(i - k).getQty4());
						inQty[5] = Double.parseDouble(list.get(i - k).getQty5());
						inQty[6] = Double.parseDouble(list.get(i - k).getQty6());
						inQty[7] = Double.parseDouble(list.get(i - k).getQty7());
						inQty[8] = Double.parseDouble(list.get(i - k).getQty8());
						inQty[9] = Double.parseDouble(list.get(i - k).getQty9());
						inQty[10] = Double.parseDouble(list.get(i - k).getQty10());
						inQty[11] = Double.parseDouble(list.get(i - k).getQty11());
						inQty[12] = Double.parseDouble(list.get(i - k).getQty12());
						inQty[13] = Double.parseDouble(list.get(i - k).getQty13());
						inQty[14] = Double.parseDouble(list.get(i - k).getQty14());
						inQty[15] = Double.parseDouble(list.get(i - k).getQty15());
						inQty[16] = Double.parseDouble(list.get(i - k).getQty16());
						inQty[17] = Double.parseDouble(list.get(i - k).getQty17());
						inQty[18] = Double.parseDouble(list.get(i - k).getQty18());
						inQty[19] = Double.parseDouble(list.get(i - k).getQty19());
						inQty[20] = Double.parseDouble(list.get(i - k).getQty20());
						inQty[21] = Double.parseDouble(list.get(i - k).getQty21());
						inQty[22] = Double.parseDouble(list.get(i - k).getQty22());
						inQty[23] = Double.parseDouble(list.get(i - k).getQty23());
						inQty[24] = Double.parseDouble(list.get(i - k).getQty24());
						inQty[25] = Double.parseDouble(list.get(i - k).getQty25());
						inQty[26] = Double.parseDouble(list.get(i - k).getQty26());
						inQty[27] = Double.parseDouble(list.get(i - k).getQty27());
						inQty[28] = Double.parseDouble(list.get(i - k).getQty28());
						inQty[29] = Double.parseDouble(list.get(i - k).getQty29());
						inQty[30] = Double.parseDouble(list.get(i - k).getQty30());
						inQty[31] = Double.parseDouble(list.get(i - k).getQty31());
						inQty[32] = Double.parseDouble(list.get(i - k).getQty32());
						inQty[33] = Double.parseDouble(list.get(i - k).getQty33());
						inQty[34] = Double.parseDouble(list.get(i - k).getQty34());
						inQty[35] = Double.parseDouble(list.get(i - k).getQty35());
						inQty[36] = Double.parseDouble(list.get(i - k).getQty36());
						inQty[37] = Double.parseDouble(list.get(i - k).getQty37());
						inQty[38] = Double.parseDouble(list.get(i - k).getQty38());
						inQty[39] = Double.parseDouble(list.get(i - k).getQty39());

						outQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0());
						outQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1());
						outQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2());
						outQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3());
						outQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4());
						outQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5());
						outQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6());
						outQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7());
						outQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8());
						outQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9());
						outQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10());
						outQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11());
						outQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12());
						outQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13());
						outQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14());
						outQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15());
						outQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16());
						outQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17());
						outQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18());
						outQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19());
						outQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20());
						outQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21());
						outQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22());
						outQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23());
						outQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24());
						outQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25());
						outQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26());
						outQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27());
						outQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28());
						outQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29());
						outQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30());
						outQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31());
						outQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32());
						outQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33());
						outQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34());
						outQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35());
						outQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36());
						outQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37());
						outQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38());
						outQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39());


						if (strDivision.equals("M/B(%)")) {

							for (int m = 0; m < outQty.length; m++) {

								if (inQty[m] >= outQty[m]) {

									if (outQty[m] > 0) {
										mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
									}
									else {
										mbQty[m] = 0;
									}

								}
								else if (outQty[m] > 0) {

									mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);

								}
								else {

									mbQty[m] = 0;

								}

							}

							list.get(i).setQty0(Double.toString(mbQty[0]));
							list.get(i).setQty1(Double.toString(mbQty[1]));
							list.get(i).setQty2(Double.toString(mbQty[2]));
							list.get(i).setQty3(Double.toString(mbQty[3]));
							list.get(i).setQty4(Double.toString(mbQty[4]));
							list.get(i).setQty5(Double.toString(mbQty[5]));
							list.get(i).setQty6(Double.toString(mbQty[6]));
							list.get(i).setQty7(Double.toString(mbQty[7]));
							list.get(i).setQty8(Double.toString(mbQty[8]));
							list.get(i).setQty9(Double.toString(mbQty[9]));
							list.get(i).setQty10(Double.toString(mbQty[10]));
							list.get(i).setQty11(Double.toString(mbQty[11]));
							list.get(i).setQty12(Double.toString(mbQty[12]));
							list.get(i).setQty13(Double.toString(mbQty[13]));
							list.get(i).setQty14(Double.toString(mbQty[14]));
							list.get(i).setQty15(Double.toString(mbQty[15]));
							list.get(i).setQty16(Double.toString(mbQty[16]));
							list.get(i).setQty17(Double.toString(mbQty[17]));
							list.get(i).setQty18(Double.toString(mbQty[18]));
							list.get(i).setQty19(Double.toString(mbQty[19]));
							list.get(i).setQty20(Double.toString(mbQty[20]));
							list.get(i).setQty21(Double.toString(mbQty[21]));
							list.get(i).setQty22(Double.toString(mbQty[22]));
							list.get(i).setQty23(Double.toString(mbQty[23]));
							list.get(i).setQty24(Double.toString(mbQty[24]));
							list.get(i).setQty25(Double.toString(mbQty[25]));
							list.get(i).setQty26(Double.toString(mbQty[26]));
							list.get(i).setQty27(Double.toString(mbQty[27]));
							list.get(i).setQty28(Double.toString(mbQty[28]));
							list.get(i).setQty29(Double.toString(mbQty[29]));
							list.get(i).setQty30(Double.toString(mbQty[30]));
							list.get(i).setQty31(Double.toString(mbQty[31]));
							list.get(i).setQty32(Double.toString(mbQty[32]));
							list.get(i).setQty33(Double.toString(mbQty[33]));
							list.get(i).setQty34(Double.toString(mbQty[34]));
							list.get(i).setQty35(Double.toString(mbQty[35]));
							list.get(i).setQty36(Double.toString(mbQty[36]));
							list.get(i).setQty37(Double.toString(mbQty[37]));
							list.get(i).setQty38(Double.toString(mbQty[38]));
							list.get(i).setQty39(Double.toString(mbQty[39]));

						}

					} // END OF if(strVvd.equals(""))

				} // End Of for ( int i=0; i< list.size(); i++ ) {

				for (int i = 0; i < lastRNo; i++) {

					vo = new QuantityByTypeSizeVO();

					vo.setLaneCd(list.get(i).getLaneCd());
					vo.setVvd(list.get(i).getVvd());
					vo.setDivision(list.get(i).getDivision());
					vo.setTotal(list.get(i).getTotal());

					vo.setQty0(list.get(i).getQty0());
					vo.setQty1(list.get(i).getQty1());
					vo.setQty2(list.get(i).getQty2());
					vo.setQty3(list.get(i).getQty3());
					vo.setQty4(list.get(i).getQty4());
					vo.setQty5(list.get(i).getQty5());
					vo.setQty6(list.get(i).getQty6());
					vo.setQty7(list.get(i).getQty7());
					vo.setQty8(list.get(i).getQty8());
					vo.setQty9(list.get(i).getQty9());
					vo.setQty10(list.get(i).getQty10());
					vo.setQty11(list.get(i).getQty11());
					vo.setQty12(list.get(i).getQty12());
					vo.setQty13(list.get(i).getQty13());
					vo.setQty14(list.get(i).getQty14());
					vo.setQty15(list.get(i).getQty15());
					vo.setQty16(list.get(i).getQty16());
					vo.setQty17(list.get(i).getQty17());
					vo.setQty18(list.get(i).getQty18());
					vo.setQty19(list.get(i).getQty19());
					vo.setQty20(list.get(i).getQty20());
					vo.setQty21(list.get(i).getQty21());
					vo.setQty22(list.get(i).getQty22());
					vo.setQty23(list.get(i).getQty23());
					vo.setQty24(list.get(i).getQty24());
					vo.setQty25(list.get(i).getQty25());
					vo.setQty26(list.get(i).getQty26());
					vo.setQty27(list.get(i).getQty27());
					vo.setQty28(list.get(i).getQty28());
					vo.setQty29(list.get(i).getQty29());
					vo.setQty30(list.get(i).getQty30());
					vo.setQty31(list.get(i).getQty31());
					vo.setQty32(list.get(i).getQty32());
					vo.setQty33(list.get(i).getQty33());
					vo.setQty34(list.get(i).getQty34());
					vo.setQty35(list.get(i).getQty35());
					vo.setQty36(list.get(i).getQty36());
					vo.setQty37(list.get(i).getQty37());
					vo.setQty38(list.get(i).getQty38());
					vo.setQty39(list.get(i).getQty39());
					list2.add(x, vo);
					x++;
				}
			}
			// list2.clear();
			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Lane M/B by Logistics-wise Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Lane M/B by Logistics-wise Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Location MatchBack] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInSummary(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {

//		log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByLogisticWiseInSummary Start");
		try {
			List<QuantityByTypeSizeVO> list = dbDao.searchLocationMBByLogisticWiseInSummary(mBSearchOptionInGereralVO);

			// List<QuantityByTypeSizeVO> listYN =
			// dbDao.searchTPSZViewYN(mBSearchOptionInGereralVO);

			double[] inQty = new double[41]; 	// InBound

			double[] outQty = new double[41];	// OutBound

			double[] mbQty = new double[41];	// Match Back

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>();
			QuantityByTypeSizeVO vo = null;
			QuantityByTypeSizeVO vo2 = null;
			int x = 0;
			int lastRNo = 0;
			lastRNo = list.size() - 1;
//			log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByLogisticWiseInSummary lastRNo [" + lastRNo+ "]");
			if (x == 0) {

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(list.get(lastRNo).getLocCd());
				vo.setTotal(list.get(lastRNo).getTotal());
				vo.setQty0(list.get(lastRNo).getQty0());
				vo.setQty1(list.get(lastRNo).getQty1());
				vo.setQty2(list.get(lastRNo).getQty2());
				vo.setQty3(list.get(lastRNo).getQty3());
				vo.setQty4(list.get(lastRNo).getQty4());
				vo.setQty5(list.get(lastRNo).getQty5());
				vo.setQty6(list.get(lastRNo).getQty6());
				vo.setQty7(list.get(lastRNo).getQty7());
				vo.setQty8(list.get(lastRNo).getQty8());
				vo.setQty9(list.get(lastRNo).getQty9());
				vo.setQty10(list.get(lastRNo).getQty10());
				vo.setQty11(list.get(lastRNo).getQty11());
				vo.setQty12(list.get(lastRNo).getQty12());
				vo.setQty13(list.get(lastRNo).getQty13());
				vo.setQty14(list.get(lastRNo).getQty14());
				vo.setQty15(list.get(lastRNo).getQty15());
				vo.setQty16(list.get(lastRNo).getQty16());
				vo.setQty17(list.get(lastRNo).getQty17());
				vo.setQty18(list.get(lastRNo).getQty18());
				vo.setQty19(list.get(lastRNo).getQty19());
				vo.setQty20(list.get(lastRNo).getQty20());
				vo.setQty21(list.get(lastRNo).getQty21());
				vo.setQty22(list.get(lastRNo).getQty22());
				vo.setQty23(list.get(lastRNo).getQty23());
				vo.setQty24(list.get(lastRNo).getQty24());
				vo.setQty25(list.get(lastRNo).getQty25());
				vo.setQty26(list.get(lastRNo).getQty26());
				vo.setQty27(list.get(lastRNo).getQty27());
				vo.setQty28(list.get(lastRNo).getQty28());
				vo.setQty29(list.get(lastRNo).getQty29());
				vo.setQty30(list.get(lastRNo).getQty30());
				vo.setQty31(list.get(lastRNo).getQty31());
				vo.setQty32(list.get(lastRNo).getQty32());
				vo.setQty33(list.get(lastRNo).getQty33());
				vo.setQty34(list.get(lastRNo).getQty34());
				vo.setQty35(list.get(lastRNo).getQty35());
				vo.setQty36(list.get(lastRNo).getQty36());
				vo.setQty37(list.get(lastRNo).getQty37());
				vo.setQty38(list.get(lastRNo).getQty38());
				vo.setQty39(list.get(lastRNo).getQty39());
				list2.add(x, vo);
				x++;
			}

			for (int i = 0; i < lastRNo; i++) {
				int k = 0;

				String strDivision = list.get(i).getDivision();

				if (strDivision.equals("M/B(%)")) {
					k = 3;
				}

				if (strDivision.equals("M/B(%)")) {
					vo = new QuantityByTypeSizeVO();

					vo.setLocCd(list.get(i).getLocCd());
					vo.setTotal(list.get(i).getTotal());

					vo.setQty0(list.get(i).getQty0());
					vo.setQty1(list.get(i).getQty1());
					vo.setQty2(list.get(i).getQty2());
					vo.setQty3(list.get(i).getQty3());
					vo.setQty4(list.get(i).getQty4());
					vo.setQty5(list.get(i).getQty5());
					vo.setQty6(list.get(i).getQty6());
					vo.setQty7(list.get(i).getQty7());
					vo.setQty8(list.get(i).getQty8());
					vo.setQty9(list.get(i).getQty9());
					vo.setQty10(list.get(i).getQty10());
					vo.setQty11(list.get(i).getQty11());
					vo.setQty12(list.get(i).getQty12());
					vo.setQty13(list.get(i).getQty13());
					vo.setQty14(list.get(i).getQty14());
					vo.setQty15(list.get(i).getQty15());
					vo.setQty16(list.get(i).getQty16());
					vo.setQty17(list.get(i).getQty17());
					vo.setQty18(list.get(i).getQty18());
					vo.setQty19(list.get(i).getQty19());
					vo.setQty20(list.get(i).getQty20());
					vo.setQty21(list.get(i).getQty21());
					vo.setQty22(list.get(i).getQty22());
					vo.setQty23(list.get(i).getQty23());
					vo.setQty24(list.get(i).getQty24());
					vo.setQty25(list.get(i).getQty25());
					vo.setQty26(list.get(i).getQty26());
					vo.setQty27(list.get(i).getQty27());
					vo.setQty28(list.get(i).getQty28());
					vo.setQty29(list.get(i).getQty29());
					vo.setQty30(list.get(i).getQty30());
					vo.setQty31(list.get(i).getQty31());
					vo.setQty32(list.get(i).getQty32());
					vo.setQty33(list.get(i).getQty33());
					vo.setQty34(list.get(i).getQty34());
					vo.setQty35(list.get(i).getQty35());
					vo.setQty36(list.get(i).getQty36());
					vo.setQty37(list.get(i).getQty37());
					vo.setQty38(list.get(i).getQty38());
					vo.setQty39(list.get(i).getQty39());
					list2.add(x, vo);
					x++;

					inQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + inQty[0];
					inQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + inQty[1];
					inQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + inQty[2];
					inQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + inQty[3];
					inQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + inQty[4];
					inQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + inQty[5];
					inQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + inQty[6];
					inQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + inQty[7];
					inQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + inQty[8];
					inQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + inQty[9];
					inQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + inQty[10];
					inQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + inQty[11];
					inQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + inQty[12];
					inQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + inQty[13];
					inQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + inQty[14];
					inQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + inQty[15];
					inQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + inQty[16];
					inQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + inQty[17];
					inQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + inQty[18];
					inQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + inQty[19];
					inQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + inQty[20];
					inQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + inQty[21];
					inQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + inQty[22];
					inQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + inQty[23];
					inQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + inQty[24];
					inQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + inQty[25];
					inQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + inQty[26];
					inQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + inQty[27];
					inQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + inQty[28];
					inQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + inQty[29];
					inQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + inQty[30];
					inQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + inQty[31];
					inQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + inQty[32];
					inQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + inQty[33];
					inQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + inQty[34];
					inQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + inQty[35];
					inQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + inQty[36];
					inQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + inQty[37];
					inQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + inQty[38];
					inQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + inQty[39];
					inQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + inQty[40];

					outQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + outQty[0];
					outQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + outQty[1];
					outQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + outQty[2];
					outQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + outQty[3];
					outQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + outQty[4];
					outQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + outQty[5];
					outQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + outQty[6];
					outQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + outQty[7];
					outQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + outQty[8];
					outQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + outQty[9];
					outQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + outQty[10];
					outQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + outQty[11];
					outQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + outQty[12];
					outQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + outQty[13];
					outQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + outQty[14];
					outQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + outQty[15];
					outQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + outQty[16];
					outQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + outQty[17];
					outQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + outQty[18];
					outQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + outQty[19];
					outQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + outQty[20];
					outQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + outQty[21];
					outQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + outQty[22];
					outQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + outQty[23];
					outQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + outQty[24];
					outQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + outQty[25];
					outQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + outQty[26];
					outQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + outQty[27];
					outQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + outQty[28];
					outQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + outQty[29];
					outQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + outQty[30];
					outQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + outQty[31];
					outQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + outQty[32];
					outQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + outQty[33];
					outQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + outQty[34];
					outQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + outQty[35];
					outQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + outQty[36];
					outQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + outQty[37];
					outQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + outQty[38];
					outQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + outQty[39];
					outQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + outQty[40];

				}
			}
			for (int m = 0; m < outQty.length; m++) {

				if (inQty[m] >= outQty[m]) {
					if (outQty[m] > 0) {
						mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
					}
					else {
						mbQty[m] = 0;
					}
				}
				else if (outQty[m] > 0) {
					mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
				}
				else {
					mbQty[m] = 0;
				}
			}
			vo2 = new QuantityByTypeSizeVO();
			vo2.setTotal(Double.toString(mbQty[40]));
			vo2.setQty0(Double.toString(mbQty[0]));
			vo2.setQty1(Double.toString(mbQty[1]));
			vo2.setQty2(Double.toString(mbQty[2]));
			vo2.setQty3(Double.toString(mbQty[3]));
			vo2.setQty4(Double.toString(mbQty[4]));
			vo2.setQty5(Double.toString(mbQty[5]));
			vo2.setQty6(Double.toString(mbQty[6]));
			vo2.setQty7(Double.toString(mbQty[7]));
			vo2.setQty8(Double.toString(mbQty[8]));
			vo2.setQty9(Double.toString(mbQty[9]));
			vo2.setQty10(Double.toString(mbQty[10]));
			vo2.setQty11(Double.toString(mbQty[11]));
			vo2.setQty12(Double.toString(mbQty[12]));
			vo2.setQty13(Double.toString(mbQty[13]));
			vo2.setQty14(Double.toString(mbQty[14]));
			vo2.setQty15(Double.toString(mbQty[15]));
			vo2.setQty16(Double.toString(mbQty[16]));
			vo2.setQty17(Double.toString(mbQty[17]));
			vo2.setQty18(Double.toString(mbQty[18]));
			vo2.setQty19(Double.toString(mbQty[19]));
			vo2.setQty20(Double.toString(mbQty[20]));
			vo2.setQty21(Double.toString(mbQty[21]));
			vo2.setQty22(Double.toString(mbQty[22]));
			vo2.setQty23(Double.toString(mbQty[23]));
			vo2.setQty24(Double.toString(mbQty[24]));
			vo2.setQty25(Double.toString(mbQty[25]));
			vo2.setQty26(Double.toString(mbQty[26]));
			vo2.setQty27(Double.toString(mbQty[27]));
			vo2.setQty28(Double.toString(mbQty[28]));
			vo2.setQty29(Double.toString(mbQty[29]));
			vo2.setQty30(Double.toString(mbQty[30]));
			vo2.setQty31(Double.toString(mbQty[31]));
			vo2.setQty32(Double.toString(mbQty[32]));
			vo2.setQty33(Double.toString(mbQty[33]));
			vo2.setQty34(Double.toString(mbQty[34]));
			vo2.setQty35(Double.toString(mbQty[35]));
			vo2.setQty36(Double.toString(mbQty[36]));
			vo2.setQty37(Double.toString(mbQty[37]));
			vo2.setQty38(Double.toString(mbQty[38]));
			vo2.setQty39(Double.toString(mbQty[39]));
			list2.add(x, vo2);
			x++;
//			log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtBC.searchLocationMBByLogisticWiseInSummary End");
			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by Logistics-wise Summary Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by Logistics-wise Summary Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Location MatchBack Detail] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInDetail(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		try {
			//log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByLogisticWiseInDetail Start");
			List<QuantityByTypeSizeVO> list = dbDao.searchLocationMBByLogisticWiseInDetail(mBSearchOptionInGereralVO);

			//log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtBC.searchLocationMBByLogisticWiseInDetail End");
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by Logistics-wise Detail Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by Logistics-wise Detail Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Load Factory Trade] <br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @param account
	 * @return String
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public String searchLoadFactorByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO,
			SignOnUserAccount account) throws EventException {
		EQMatchBackNLoadFactorMgtBackEndJob backEndJob = new EQMatchBackNLoadFactorMgtBackEndJob();
		backEndJob.setJobType("searchLoadFactorByTrade");
		backEndJob.setSearchOptionByTradeLaneVvdVO(searchOptionByTradeLaneVvdVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "L/F by Trade Retrieve BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "L/F by Trade Retrieve BackEndJob" })
					.getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Location MatchBack Trend] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return MatchBackByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByLogisticWiseByTrend(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByLogisticWiseByTrend Start");
		try {

			MatchBackByMonthlyWeeklyTrendSetVO list = dbDao.searchLocationMBByLogisticWiseByTrend(mBSearchOptionInGereralVO);

			List<QuantityByTypeSizeVO> list1 = list.getQuantitybytypesizevo();

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>();
			QuantityByTypeSizeVO vo = null;

			double[] inQty = new double[27];

			double[] outQty = new double[27];

			double[] mbQty = new double[27];

			double[] inQty2 = new double[27];

			double[] outQty2 = new double[27];

			double[] mbQty2 = new double[27];

			String xTempLocCdVal = "";

			int x = 0;
			for (int i = 0; i < list1.size(); i++) {
				int k = 0;

				// String strTpsz = list1.get(i).getVvd();
				String strDivision = list1.get(i).getDivision();
				String strLoccode = list1.get(i).getLocCd();

				if (strDivision.equals("M/B(%)")) {
					k = 3;
				}

				// process for S.Total & G.Total
				if (strLoccode.equals(xTempLocCdVal) || i == 0) {

					// adding retrieve result List 
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(list1.get(i).getLocCd());
					vo.setVvd(list1.get(i).getVvd());
					vo.setDivision(list1.get(i).getDivision());
					vo.setTotal(list1.get(i).getTotal());
					vo.setQty0(list1.get(i).getQty0());
					vo.setQty1(list1.get(i).getQty1());
					vo.setQty2(list1.get(i).getQty2());
					vo.setQty3(list1.get(i).getQty3());
					vo.setQty4(list1.get(i).getQty4());
					vo.setQty5(list1.get(i).getQty5());
					vo.setQty6(list1.get(i).getQty6());
					vo.setQty7(list1.get(i).getQty7());
					vo.setQty8(list1.get(i).getQty8());
					vo.setQty9(list1.get(i).getQty9());
					vo.setQty10(list1.get(i).getQty10());
					vo.setQty11(list1.get(i).getQty11());
					vo.setQty12(list1.get(i).getQty12());
					vo.setQty13(list1.get(i).getQty13());
					vo.setQty14(list1.get(i).getQty14());
					vo.setQty15(list1.get(i).getQty15());
					vo.setQty16(list1.get(i).getQty16());
					vo.setQty17(list1.get(i).getQty17());
					vo.setQty18(list1.get(i).getQty18());
					vo.setQty19(list1.get(i).getQty19());
					vo.setQty20(list1.get(i).getQty20());
					vo.setQty21(list1.get(i).getQty21());
					vo.setQty22(list1.get(i).getQty22());
					vo.setQty23(list1.get(i).getQty23());
					vo.setQty24(list1.get(i).getQty24());
					vo.setQty25(list1.get(i).getQty25());
					list2.add(x, vo);
					x++;

					if (strDivision.equals("M/B(%)")) {
						// S.Total
						inQty[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty[0];
						inQty[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty[1];
						inQty[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty[2];
						inQty[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty[3];
						inQty[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty[4];
						inQty[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty[5];
						inQty[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty[6];
						inQty[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty[7];
						inQty[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty[8];
						inQty[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty[9];
						inQty[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty[10];
						inQty[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty[11];
						inQty[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty[12];
						inQty[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty[13];
						inQty[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty[14];
						inQty[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty[15];
						inQty[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty[16];
						inQty[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty[17];
						inQty[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty[18];
						inQty[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty[19];
						inQty[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty[20];
						inQty[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty[21];
						inQty[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty[22];
						inQty[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty[23];
						inQty[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty[24];
						inQty[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty[25];
						inQty[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty[26]; // total

						outQty[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty[0];
						outQty[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty[1];
						outQty[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty[2];
						outQty[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty[3];
						outQty[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty[4];
						outQty[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty[5];
						outQty[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty[6];
						outQty[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty[7];
						outQty[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty[8];
						outQty[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty[9];
						outQty[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty[10];
						outQty[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty[11];
						outQty[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty[12];
						outQty[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty[13];
						outQty[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty[14];
						outQty[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty[15];
						outQty[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty[16];
						outQty[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty[17];
						outQty[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty[18];
						outQty[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty[19];
						outQty[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty[20];
						outQty[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty[21];
						outQty[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty[22];
						outQty[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty[23];
						outQty[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty[24];
						outQty[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty[25];
						outQty[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty[26]; // total

						// G.Total
						inQty2[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty2[0];
						inQty2[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty2[1];
						inQty2[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty2[2];
						inQty2[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty2[3];
						inQty2[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty2[4];
						inQty2[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty2[5];
						inQty2[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty2[6];
						inQty2[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty2[7];
						inQty2[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty2[8];
						inQty2[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty2[9];
						inQty2[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty2[10];
						inQty2[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty2[11];
						inQty2[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty2[12];
						inQty2[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty2[13];
						inQty2[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty2[14];
						inQty2[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty2[15];
						inQty2[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty2[16];
						inQty2[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty2[17];
						inQty2[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty2[18];
						inQty2[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty2[19];
						inQty2[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty2[20];
						inQty2[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty2[21];
						inQty2[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty2[22];
						inQty2[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty2[23];
						inQty2[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty2[24];
						inQty2[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty2[25];
						inQty2[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty2[26]; // total

						outQty2[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty2[0];
						outQty2[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty2[1];
						outQty2[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty2[2];
						outQty2[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty2[3];
						outQty2[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty2[4];
						outQty2[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty2[5];
						outQty2[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty2[6];
						outQty2[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty2[7];
						outQty2[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty2[8];
						outQty2[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty2[9];
						outQty2[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty2[10];
						outQty2[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty2[11];
						outQty2[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty2[12];
						outQty2[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty2[13];
						outQty2[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty2[14];
						outQty2[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty2[15];
						outQty2[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty2[16];
						outQty2[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty2[17];
						outQty2[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty2[18];
						outQty2[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty2[19];
						outQty2[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty2[20];
						outQty2[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty2[21];
						outQty2[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty2[22];
						outQty2[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty2[23];
						outQty2[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty2[24];
						outQty2[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty2[25];
						outQty2[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty2[26]; // total
					} // end if if(strDivision.equals("M/B(%")){

				}
				else if (!strLoccode.equals(xTempLocCdVal) || i != 0) { // if(strLoccode.equals(xTempLocCdVal)){
					// calculating sub total in case of location code change

					// if(strDivision.equals("I/B")){
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(xTempLocCdVal);
					vo.setVvd("Total");
					vo.setDivision("I/B");
					vo.setTotal(Double.toString(inQty[26]));
					vo.setQty0(Double.toString(inQty[0]));
					vo.setQty1(Double.toString(inQty[1]));
					vo.setQty2(Double.toString(inQty[2]));
					vo.setQty3(Double.toString(inQty[3]));
					vo.setQty4(Double.toString(inQty[4]));
					vo.setQty5(Double.toString(inQty[5]));
					vo.setQty6(Double.toString(inQty[6]));
					vo.setQty7(Double.toString(inQty[7]));
					vo.setQty8(Double.toString(inQty[8]));
					vo.setQty9(Double.toString(inQty[9]));
					vo.setQty10(Double.toString(inQty[10]));
					vo.setQty11(Double.toString(inQty[11]));
					vo.setQty12(Double.toString(inQty[12]));
					vo.setQty13(Double.toString(inQty[13]));
					vo.setQty14(Double.toString(inQty[14]));
					vo.setQty15(Double.toString(inQty[15]));
					vo.setQty16(Double.toString(inQty[16]));
					vo.setQty17(Double.toString(inQty[17]));
					vo.setQty18(Double.toString(inQty[18]));
					vo.setQty19(Double.toString(inQty[19]));
					vo.setQty20(Double.toString(inQty[20]));
					vo.setQty21(Double.toString(inQty[21]));
					vo.setQty22(Double.toString(inQty[22]));
					vo.setQty23(Double.toString(inQty[23]));
					vo.setQty24(Double.toString(inQty[24]));
					vo.setQty25(Double.toString(inQty[25]));
					list2.add(x, vo);
					x++;
					// }else if(strDivision.equals("O/B")){
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(xTempLocCdVal);
					vo.setVvd("Total");
					vo.setDivision("O/B");
					vo.setTotal(Double.toString(outQty[26]));
					vo.setQty0(Double.toString(outQty[0]));
					vo.setQty1(Double.toString(outQty[1]));
					vo.setQty2(Double.toString(outQty[2]));
					vo.setQty3(Double.toString(outQty[3]));
					vo.setQty4(Double.toString(outQty[4]));
					vo.setQty5(Double.toString(outQty[5]));
					vo.setQty6(Double.toString(outQty[6]));
					vo.setQty7(Double.toString(outQty[7]));
					vo.setQty8(Double.toString(outQty[8]));
					vo.setQty9(Double.toString(outQty[9]));
					vo.setQty10(Double.toString(outQty[10]));
					vo.setQty11(Double.toString(outQty[11]));
					vo.setQty12(Double.toString(outQty[12]));
					vo.setQty13(Double.toString(outQty[13]));
					vo.setQty14(Double.toString(outQty[14]));
					vo.setQty15(Double.toString(outQty[15]));
					vo.setQty16(Double.toString(outQty[16]));
					vo.setQty17(Double.toString(outQty[17]));
					vo.setQty18(Double.toString(outQty[18]));
					vo.setQty19(Double.toString(outQty[19]));
					vo.setQty20(Double.toString(outQty[20]));
					vo.setQty21(Double.toString(outQty[21]));
					vo.setQty22(Double.toString(outQty[22]));
					vo.setQty23(Double.toString(outQty[23]));
					vo.setQty24(Double.toString(outQty[24]));
					vo.setQty25(Double.toString(outQty[25]));
					list2.add(x, vo);
					x++;
					// }else if(strDivision.equals("Bal")){
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(xTempLocCdVal);
					vo.setVvd("Total");
					vo.setDivision("Balance");
					vo.setTotal(Double.toString(inQty[26] - outQty[26]));
					vo.setQty0(Double.toString(inQty[0] - outQty[0]));
					vo.setQty1(Double.toString(inQty[1] - outQty[1]));
					vo.setQty2(Double.toString(inQty[2] - outQty[2]));
					vo.setQty3(Double.toString(inQty[3] - outQty[3]));
					vo.setQty4(Double.toString(inQty[4] - outQty[4]));
					vo.setQty5(Double.toString(inQty[5] - outQty[5]));
					vo.setQty6(Double.toString(inQty[6] - outQty[6]));
					vo.setQty7(Double.toString(inQty[7] - outQty[7]));
					vo.setQty8(Double.toString(inQty[8] - outQty[8]));
					vo.setQty9(Double.toString(inQty[9] - outQty[9]));
					vo.setQty10(Double.toString(inQty[10] - outQty[10]));
					vo.setQty11(Double.toString(inQty[11] - outQty[11]));
					vo.setQty12(Double.toString(inQty[12] - outQty[12]));
					vo.setQty13(Double.toString(inQty[13] - outQty[13]));
					vo.setQty14(Double.toString(inQty[14] - outQty[14]));
					vo.setQty15(Double.toString(inQty[15] - outQty[15]));
					vo.setQty16(Double.toString(inQty[16] - outQty[16]));
					vo.setQty17(Double.toString(inQty[17] - outQty[17]));
					vo.setQty18(Double.toString(inQty[18] - outQty[18]));
					vo.setQty19(Double.toString(inQty[19] - outQty[19]));
					vo.setQty20(Double.toString(inQty[20] - outQty[20]));
					vo.setQty21(Double.toString(inQty[21] - outQty[21]));
					vo.setQty22(Double.toString(inQty[22] - outQty[22]));
					vo.setQty23(Double.toString(inQty[23] - outQty[23]));
					vo.setQty24(Double.toString(inQty[24] - outQty[24]));
					vo.setQty25(Double.toString(inQty[25] - outQty[25]));
					list2.add(x, vo);
					x++;
					// }else if(strDivision.equals("M/B(%)")){
					for (int m = 0; m < outQty.length; m++) {

						if (inQty[m] >= outQty[m]) {
							if (outQty[m] > 0) {
								mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
							}
							else {
								mbQty[m] = 0;
							}
						}
						else if (outQty[m] > 0) {
							mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
						}
						else {
							mbQty[m] = 0;
						}
					}
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(xTempLocCdVal);
					vo.setVvd("Total");
					vo.setDivision("M/B(%)");
					vo.setTotal(Double.toString(mbQty[26]));
					vo.setQty0(Double.toString(mbQty[0]));
					vo.setQty1(Double.toString(mbQty[1]));
					vo.setQty2(Double.toString(mbQty[2]));
					vo.setQty3(Double.toString(mbQty[3]));
					vo.setQty4(Double.toString(mbQty[4]));
					vo.setQty5(Double.toString(mbQty[5]));
					vo.setQty6(Double.toString(mbQty[6]));
					vo.setQty7(Double.toString(mbQty[7]));
					vo.setQty8(Double.toString(mbQty[8]));
					vo.setQty9(Double.toString(mbQty[9]));
					vo.setQty10(Double.toString(mbQty[10]));
					vo.setQty11(Double.toString(mbQty[11]));
					vo.setQty12(Double.toString(mbQty[12]));
					vo.setQty13(Double.toString(mbQty[13]));
					vo.setQty14(Double.toString(mbQty[14]));
					vo.setQty15(Double.toString(mbQty[15]));
					vo.setQty16(Double.toString(mbQty[16]));
					vo.setQty17(Double.toString(mbQty[17]));
					vo.setQty18(Double.toString(mbQty[18]));
					vo.setQty19(Double.toString(mbQty[19]));
					vo.setQty20(Double.toString(mbQty[20]));
					vo.setQty21(Double.toString(mbQty[21]));
					vo.setQty22(Double.toString(mbQty[22]));
					vo.setQty23(Double.toString(mbQty[23]));
					vo.setQty24(Double.toString(mbQty[24]));
					vo.setQty25(Double.toString(mbQty[25]));
					list2.add(x, vo);
					x++;

					// S.Total
					inQty[0] = 0;
					inQty[1] = 0;
					inQty[2] = 0;
					inQty[3] = 0;
					inQty[4] = 0;
					inQty[5] = 0;
					inQty[6] = 0;
					inQty[7] = 0;
					inQty[8] = 0;
					inQty[9] = 0;
					inQty[10] = 0;
					inQty[11] = 0;
					inQty[12] = 0;
					inQty[13] = 0;
					inQty[14] = 0;
					inQty[15] = 0;
					inQty[16] = 0;
					inQty[17] = 0;
					inQty[18] = 0;
					inQty[19] = 0;
					inQty[20] = 0;
					inQty[21] = 0;
					inQty[22] = 0;
					inQty[23] = 0;
					inQty[24] = 0;
					inQty[25] = 0;
					inQty[26] = 0; // total

					outQty[0] = 0;
					outQty[1] = 0;
					outQty[2] = 0;
					outQty[3] = 0;
					outQty[4] = 0;
					outQty[5] = 0;
					outQty[6] = 0;
					outQty[7] = 0;
					outQty[8] = 0;
					outQty[9] = 0;
					outQty[10] = 0;
					outQty[11] = 0;
					outQty[12] = 0;
					outQty[13] = 0;
					outQty[14] = 0;
					outQty[15] = 0;
					outQty[16] = 0;
					outQty[17] = 0;
					outQty[18] = 0;
					outQty[19] = 0;
					outQty[20] = 0;
					outQty[21] = 0;
					outQty[22] = 0;
					outQty[23] = 0;
					outQty[24] = 0;
					outQty[25] = 0;
					outQty[26] = 0; // total

					// adding retrieve result List
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(list1.get(i).getLocCd());
					vo.setVvd(list1.get(i).getVvd());
					vo.setDivision(list1.get(i).getDivision());
					vo.setTotal(list1.get(i).getTotal());
					vo.setQty0(list1.get(i).getQty0());
					vo.setQty1(list1.get(i).getQty1());
					vo.setQty2(list1.get(i).getQty2());
					vo.setQty3(list1.get(i).getQty3());
					vo.setQty4(list1.get(i).getQty4());
					vo.setQty5(list1.get(i).getQty5());
					vo.setQty6(list1.get(i).getQty6());
					vo.setQty7(list1.get(i).getQty7());
					vo.setQty8(list1.get(i).getQty8());
					vo.setQty9(list1.get(i).getQty9());
					vo.setQty10(list1.get(i).getQty10());
					vo.setQty11(list1.get(i).getQty11());
					vo.setQty12(list1.get(i).getQty12());
					vo.setQty13(list1.get(i).getQty13());
					vo.setQty14(list1.get(i).getQty14());
					vo.setQty15(list1.get(i).getQty15());
					vo.setQty16(list1.get(i).getQty16());
					vo.setQty17(list1.get(i).getQty17());
					vo.setQty18(list1.get(i).getQty18());
					vo.setQty19(list1.get(i).getQty19());
					vo.setQty20(list1.get(i).getQty20());
					vo.setQty21(list1.get(i).getQty21());
					vo.setQty22(list1.get(i).getQty22());
					vo.setQty23(list1.get(i).getQty23());
					vo.setQty24(list1.get(i).getQty24());
					vo.setQty25(list1.get(i).getQty25());
					list2.add(x, vo);
					x++;

					if (strDivision.equals("M/B(%)")) {
						// S.Total
						inQty[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty[0];
						inQty[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty[1];
						inQty[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty[2];
						inQty[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty[3];
						inQty[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty[4];
						inQty[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty[5];
						inQty[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty[6];
						inQty[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty[7];
						inQty[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty[8];
						inQty[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty[9];
						inQty[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty[10];
						inQty[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty[11];
						inQty[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty[12];
						inQty[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty[13];
						inQty[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty[14];
						inQty[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty[15];
						inQty[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty[16];
						inQty[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty[17];
						inQty[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty[18];
						inQty[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty[19];
						inQty[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty[20];
						inQty[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty[21];
						inQty[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty[22];
						inQty[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty[23];
						inQty[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty[24];
						inQty[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty[25];
						inQty[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty[26]; // total

						outQty[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty[0];
						outQty[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty[1];
						outQty[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty[2];
						outQty[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty[3];
						outQty[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty[4];
						outQty[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty[5];
						outQty[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty[6];
						outQty[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty[7];
						outQty[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty[8];
						outQty[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty[9];
						outQty[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty[10];
						outQty[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty[11];
						outQty[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty[12];
						outQty[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty[13];
						outQty[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty[14];
						outQty[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty[15];
						outQty[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty[16];
						outQty[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty[17];
						outQty[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty[18];
						outQty[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty[19];
						outQty[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty[20];
						outQty[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty[21];
						outQty[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty[22];
						outQty[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty[23];
						outQty[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty[24];
						outQty[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty[25];
						outQty[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty[26]; // total

						// G.Total
						inQty2[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty2[0];
						inQty2[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty2[1];
						inQty2[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty2[2];
						inQty2[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty2[3];
						inQty2[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty2[4];
						inQty2[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty2[5];
						inQty2[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty2[6];
						inQty2[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty2[7];
						inQty2[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty2[8];
						inQty2[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty2[9];
						inQty2[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty2[10];
						inQty2[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty2[11];
						inQty2[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty2[12];
						inQty2[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty2[13];
						inQty2[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty2[14];
						inQty2[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty2[15];
						inQty2[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty2[16];
						inQty2[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty2[17];
						inQty2[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty2[18];
						inQty2[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty2[19];
						inQty2[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty2[20];
						inQty2[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty2[21];
						inQty2[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty2[22];
						inQty2[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty2[23];
						inQty2[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty2[24];
						inQty2[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty2[25];
						inQty2[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty2[26]; // total

						outQty2[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty2[0];
						outQty2[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty2[1];
						outQty2[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty2[2];
						outQty2[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty2[3];
						outQty2[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty2[4];
						outQty2[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty2[5];
						outQty2[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty2[6];
						outQty2[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty2[7];
						outQty2[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty2[8];
						outQty2[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty2[9];
						outQty2[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty2[10];
						outQty2[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty2[11];
						outQty2[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty2[12];
						outQty2[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty2[13];
						outQty2[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty2[14];
						outQty2[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty2[15];
						outQty2[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty2[16];
						outQty2[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty2[17];
						outQty2[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty2[18];
						outQty2[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty2[19];
						outQty2[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty2[20];
						outQty2[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty2[21];
						outQty2[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty2[22];
						outQty2[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty2[23];
						outQty2[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty2[24];
						outQty2[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty2[25];
						outQty2[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty2[26]; // total
					} // end if if(strDivision.equals("M/B(%")){
				}// end if if(strLoccode.equals(xTempLocCdVal)){
				xTempLocCdVal = strLoccode;
			} // end for for ( int i=0; i< list1.size(); i++ ) {

			// if(strDivision.equals("I/B")){
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd(xTempLocCdVal);
			vo.setVvd("Total");
			vo.setDivision("I/B");
			vo.setTotal(Double.toString(inQty[26]));
			vo.setQty0(Double.toString(inQty[0]));
			vo.setQty1(Double.toString(inQty[1]));
			vo.setQty2(Double.toString(inQty[2]));
			vo.setQty3(Double.toString(inQty[3]));
			vo.setQty4(Double.toString(inQty[4]));
			vo.setQty5(Double.toString(inQty[5]));
			vo.setQty6(Double.toString(inQty[6]));
			vo.setQty7(Double.toString(inQty[7]));
			vo.setQty8(Double.toString(inQty[8]));
			vo.setQty9(Double.toString(inQty[9]));
			vo.setQty10(Double.toString(inQty[10]));
			vo.setQty11(Double.toString(inQty[11]));
			vo.setQty12(Double.toString(inQty[12]));
			vo.setQty13(Double.toString(inQty[13]));
			vo.setQty14(Double.toString(inQty[14]));
			vo.setQty15(Double.toString(inQty[15]));
			vo.setQty16(Double.toString(inQty[16]));
			vo.setQty17(Double.toString(inQty[17]));
			vo.setQty18(Double.toString(inQty[18]));
			vo.setQty19(Double.toString(inQty[19]));
			vo.setQty20(Double.toString(inQty[20]));
			vo.setQty21(Double.toString(inQty[21]));
			vo.setQty22(Double.toString(inQty[22]));
			vo.setQty23(Double.toString(inQty[23]));
			vo.setQty24(Double.toString(inQty[24]));
			vo.setQty25(Double.toString(inQty[25]));
			list2.add(x, vo);
			x++;
			// }else if(strDivision.equals("O/B")){
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd(xTempLocCdVal);
			vo.setVvd("Total");
			vo.setDivision("O/B");
			vo.setTotal(Double.toString(outQty[26]));
			vo.setQty0(Double.toString(outQty[0]));
			vo.setQty1(Double.toString(outQty[1]));
			vo.setQty2(Double.toString(outQty[2]));
			vo.setQty3(Double.toString(outQty[3]));
			vo.setQty4(Double.toString(outQty[4]));
			vo.setQty5(Double.toString(outQty[5]));
			vo.setQty6(Double.toString(outQty[6]));
			vo.setQty7(Double.toString(outQty[7]));
			vo.setQty8(Double.toString(outQty[8]));
			vo.setQty9(Double.toString(outQty[9]));
			vo.setQty10(Double.toString(outQty[10]));
			vo.setQty11(Double.toString(outQty[11]));
			vo.setQty12(Double.toString(outQty[12]));
			vo.setQty13(Double.toString(outQty[13]));
			vo.setQty14(Double.toString(outQty[14]));
			vo.setQty15(Double.toString(outQty[15]));
			vo.setQty16(Double.toString(outQty[16]));
			vo.setQty17(Double.toString(outQty[17]));
			vo.setQty18(Double.toString(outQty[18]));
			vo.setQty19(Double.toString(outQty[19]));
			vo.setQty20(Double.toString(outQty[20]));
			vo.setQty21(Double.toString(outQty[21]));
			vo.setQty22(Double.toString(outQty[22]));
			vo.setQty23(Double.toString(outQty[23]));
			vo.setQty24(Double.toString(outQty[24]));
			vo.setQty25(Double.toString(outQty[25]));
			list2.add(x, vo);
			x++;
			// }else if(strDivision.equals("Bal")){
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd(xTempLocCdVal);
			vo.setVvd("Total");
			vo.setDivision("Balance");
			vo.setTotal(Double.toString(inQty[26] - outQty[26]));
			vo.setQty0(Double.toString(inQty[0] - outQty[0]));
			vo.setQty1(Double.toString(inQty[1] - outQty[1]));
			vo.setQty2(Double.toString(inQty[2] - outQty[2]));
			vo.setQty3(Double.toString(inQty[3] - outQty[3]));
			vo.setQty4(Double.toString(inQty[4] - outQty[4]));
			vo.setQty5(Double.toString(inQty[5] - outQty[5]));
			vo.setQty6(Double.toString(inQty[6] - outQty[6]));
			vo.setQty7(Double.toString(inQty[7] - outQty[7]));
			vo.setQty8(Double.toString(inQty[8] - outQty[8]));
			vo.setQty9(Double.toString(inQty[9] - outQty[9]));
			vo.setQty10(Double.toString(inQty[10] - outQty[10]));
			vo.setQty11(Double.toString(inQty[11] - outQty[11]));
			vo.setQty12(Double.toString(inQty[12] - outQty[12]));
			vo.setQty13(Double.toString(inQty[13] - outQty[13]));
			vo.setQty14(Double.toString(inQty[14] - outQty[14]));
			vo.setQty15(Double.toString(inQty[15] - outQty[15]));
			vo.setQty16(Double.toString(inQty[16] - outQty[16]));
			vo.setQty17(Double.toString(inQty[17] - outQty[17]));
			vo.setQty18(Double.toString(inQty[18] - outQty[18]));
			vo.setQty19(Double.toString(inQty[19] - outQty[19]));
			vo.setQty20(Double.toString(inQty[20] - outQty[20]));
			vo.setQty21(Double.toString(inQty[21] - outQty[21]));
			vo.setQty22(Double.toString(inQty[22] - outQty[22]));
			vo.setQty23(Double.toString(inQty[23] - outQty[23]));
			vo.setQty24(Double.toString(inQty[24] - outQty[24]));
			vo.setQty25(Double.toString(inQty[25] - outQty[25]));
			list2.add(x, vo);
			x++;
			// }else if(strDivision.equals("M/B(%)")){
			for (int m = 0; m < outQty.length; m++) {

				if (inQty[m] >= outQty[m]) {
					if (outQty[m] > 0) {
						mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
					}
					else {
						mbQty[m] = 0;
					}
				}
				else if (outQty[m] > 0) {
					mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
				}
				else {
					mbQty[m] = 0;
				}
			}
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd(xTempLocCdVal);
			vo.setVvd("Total");
			vo.setDivision("M/B(%)");
			vo.setTotal(Double.toString(mbQty[26]));
			vo.setQty0(Double.toString(mbQty[0]));
			vo.setQty1(Double.toString(mbQty[1]));
			vo.setQty2(Double.toString(mbQty[2]));
			vo.setQty3(Double.toString(mbQty[3]));
			vo.setQty4(Double.toString(mbQty[4]));
			vo.setQty5(Double.toString(mbQty[5]));
			vo.setQty6(Double.toString(mbQty[6]));
			vo.setQty7(Double.toString(mbQty[7]));
			vo.setQty8(Double.toString(mbQty[8]));
			vo.setQty9(Double.toString(mbQty[9]));
			vo.setQty10(Double.toString(mbQty[10]));
			vo.setQty11(Double.toString(mbQty[11]));
			vo.setQty12(Double.toString(mbQty[12]));
			vo.setQty13(Double.toString(mbQty[13]));
			vo.setQty14(Double.toString(mbQty[14]));
			vo.setQty15(Double.toString(mbQty[15]));
			vo.setQty16(Double.toString(mbQty[16]));
			vo.setQty17(Double.toString(mbQty[17]));
			vo.setQty18(Double.toString(mbQty[18]));
			vo.setQty19(Double.toString(mbQty[19]));
			vo.setQty20(Double.toString(mbQty[20]));
			vo.setQty21(Double.toString(mbQty[21]));
			vo.setQty22(Double.toString(mbQty[22]));
			vo.setQty23(Double.toString(mbQty[23]));
			vo.setQty24(Double.toString(mbQty[24]));
			vo.setQty25(Double.toString(mbQty[25]));
			list2.add(x, vo);
			x++;

			// setting G.Total 
			// if(strDivision.equals("I/B")){
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd("");
			vo.setVvd("G.Total");
			vo.setDivision("I/B");
			vo.setTotal(Double.toString(inQty2[26]));
			vo.setQty0(Double.toString(inQty2[0]));
			vo.setQty1(Double.toString(inQty2[1]));
			vo.setQty2(Double.toString(inQty2[2]));
			vo.setQty3(Double.toString(inQty2[3]));
			vo.setQty4(Double.toString(inQty2[4]));
			vo.setQty5(Double.toString(inQty2[5]));
			vo.setQty6(Double.toString(inQty2[6]));
			vo.setQty7(Double.toString(inQty2[7]));
			vo.setQty8(Double.toString(inQty2[8]));
			vo.setQty9(Double.toString(inQty2[9]));
			vo.setQty10(Double.toString(inQty2[10]));
			vo.setQty11(Double.toString(inQty2[11]));
			vo.setQty12(Double.toString(inQty2[12]));
			vo.setQty13(Double.toString(inQty2[13]));
			vo.setQty14(Double.toString(inQty2[14]));
			vo.setQty15(Double.toString(inQty2[15]));
			vo.setQty16(Double.toString(inQty2[16]));
			vo.setQty17(Double.toString(inQty2[17]));
			vo.setQty18(Double.toString(inQty2[18]));
			vo.setQty19(Double.toString(inQty2[19]));
			vo.setQty20(Double.toString(inQty2[20]));
			vo.setQty21(Double.toString(inQty2[21]));
			vo.setQty22(Double.toString(inQty2[22]));
			vo.setQty23(Double.toString(inQty2[23]));
			vo.setQty24(Double.toString(inQty2[24]));
			vo.setQty25(Double.toString(inQty2[25]));
			list2.add(x, vo);
			x++;
			// }else if(strDivision.equals("O/B")){
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd("");
			vo.setVvd("G.Total");
			vo.setDivision("O/B");
			vo.setTotal(Double.toString(outQty2[26]));
			vo.setQty0(Double.toString(outQty2[0]));
			vo.setQty1(Double.toString(outQty2[1]));
			vo.setQty2(Double.toString(outQty2[2]));
			vo.setQty3(Double.toString(outQty2[3]));
			vo.setQty4(Double.toString(outQty2[4]));
			vo.setQty5(Double.toString(outQty2[5]));
			vo.setQty6(Double.toString(outQty2[6]));
			vo.setQty7(Double.toString(outQty2[7]));
			vo.setQty8(Double.toString(outQty2[8]));
			vo.setQty9(Double.toString(outQty2[9]));
			vo.setQty10(Double.toString(outQty2[10]));
			vo.setQty11(Double.toString(outQty2[11]));
			vo.setQty12(Double.toString(outQty2[12]));
			vo.setQty13(Double.toString(outQty2[13]));
			vo.setQty14(Double.toString(outQty2[14]));
			vo.setQty15(Double.toString(outQty2[15]));
			vo.setQty16(Double.toString(outQty2[16]));
			vo.setQty17(Double.toString(outQty2[17]));
			vo.setQty18(Double.toString(outQty2[18]));
			vo.setQty19(Double.toString(outQty2[19]));
			vo.setQty20(Double.toString(outQty2[20]));
			vo.setQty21(Double.toString(outQty2[21]));
			vo.setQty22(Double.toString(outQty2[22]));
			vo.setQty23(Double.toString(outQty2[23]));
			vo.setQty24(Double.toString(outQty2[24]));
			vo.setQty25(Double.toString(outQty2[25]));
			list2.add(x, vo);
			x++;
			// }else if(strDivision.equals("Bal")){
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd("");
			vo.setVvd("G.Total");
			vo.setDivision("Balance");
			vo.setTotal(Double.toString(inQty2[26] - outQty2[26]));
			vo.setQty0(Double.toString(inQty2[0] - outQty2[0]));
			vo.setQty1(Double.toString(inQty2[1] - outQty2[1]));
			vo.setQty2(Double.toString(inQty2[2] - outQty2[2]));
			vo.setQty3(Double.toString(inQty2[3] - outQty2[3]));
			vo.setQty4(Double.toString(inQty2[4] - outQty2[4]));
			vo.setQty5(Double.toString(inQty2[5] - outQty2[5]));
			vo.setQty6(Double.toString(inQty2[6] - outQty2[6]));
			vo.setQty7(Double.toString(inQty2[7] - outQty2[7]));
			vo.setQty8(Double.toString(inQty2[8] - outQty2[8]));
			vo.setQty9(Double.toString(inQty2[9] - outQty2[9]));
			vo.setQty10(Double.toString(inQty2[10] - outQty2[10]));
			vo.setQty11(Double.toString(inQty2[11] - outQty2[11]));
			vo.setQty12(Double.toString(inQty2[12] - outQty2[12]));
			vo.setQty13(Double.toString(inQty2[13] - outQty2[13]));
			vo.setQty14(Double.toString(inQty2[14] - outQty2[14]));
			vo.setQty15(Double.toString(inQty2[15] - outQty2[15]));
			vo.setQty16(Double.toString(inQty2[16] - outQty2[16]));
			vo.setQty17(Double.toString(inQty2[17] - outQty2[17]));
			vo.setQty18(Double.toString(inQty2[18] - outQty2[18]));
			vo.setQty19(Double.toString(inQty2[19] - outQty2[19]));
			vo.setQty20(Double.toString(inQty2[20] - outQty2[20]));
			vo.setQty21(Double.toString(inQty2[21] - outQty2[21]));
			vo.setQty22(Double.toString(inQty2[22] - outQty2[22]));
			vo.setQty23(Double.toString(inQty2[23] - outQty2[23]));
			vo.setQty24(Double.toString(inQty2[24] - outQty2[24]));
			vo.setQty25(Double.toString(inQty2[25] - outQty2[25]));
			list2.add(x, vo);
			x++;
			// }else if(strDivision.equals("M/B(%)")){
			for (int m = 0; m < outQty2.length; m++) {

				if (inQty2[m] >= outQty2[m]) {
					if (outQty2[m] > 0) {
						mbQty2[m] = Math.round(outQty2[m] / inQty2[m] * 100);
					}
					else {
						mbQty2[m] = 0;
					}
				}
				else if (outQty2[m] > 0) {
					mbQty2[m] = Math.round((inQty2[m] / outQty2[m] * (-1)) * 100);
				}
				else {
					mbQty2[m] = 0;
				}
			}
			vo = new QuantityByTypeSizeVO();
			vo.setLocCd("");
			vo.setVvd("G.Total");
			vo.setDivision("M/B(%)");
			vo.setTotal(Double.toString(mbQty2[26]));
			vo.setQty0(Double.toString(mbQty2[0]));
			vo.setQty1(Double.toString(mbQty2[1]));
			vo.setQty2(Double.toString(mbQty2[2]));
			vo.setQty3(Double.toString(mbQty2[3]));
			vo.setQty4(Double.toString(mbQty2[4]));
			vo.setQty5(Double.toString(mbQty2[5]));
			vo.setQty6(Double.toString(mbQty2[6]));
			vo.setQty7(Double.toString(mbQty2[7]));
			vo.setQty8(Double.toString(mbQty2[8]));
			vo.setQty9(Double.toString(mbQty2[9]));
			vo.setQty10(Double.toString(mbQty2[10]));
			vo.setQty11(Double.toString(mbQty2[11]));
			vo.setQty12(Double.toString(mbQty2[12]));
			vo.setQty13(Double.toString(mbQty2[13]));
			vo.setQty14(Double.toString(mbQty2[14]));
			vo.setQty15(Double.toString(mbQty2[15]));
			vo.setQty16(Double.toString(mbQty2[16]));
			vo.setQty17(Double.toString(mbQty2[17]));
			vo.setQty18(Double.toString(mbQty2[18]));
			vo.setQty19(Double.toString(mbQty2[19]));
			vo.setQty20(Double.toString(mbQty2[20]));
			vo.setQty21(Double.toString(mbQty2[21]));
			vo.setQty22(Double.toString(mbQty2[22]));
			vo.setQty23(Double.toString(mbQty2[23]));
			vo.setQty24(Double.toString(mbQty2[24]));
			vo.setQty25(Double.toString(mbQty2[25]));
			list2.add(x, vo);

			list.setQuantitybytypesizevo(list2);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by Logistics-wise Trend Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by Logistics-wise Trend Retrieve" }).getMessage(), ex);
		} // end try
	}

	/**
	 * Retrieving [Service Mode MatchBack] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchMBByServiceMode(MBSearchOptionInGereralVO mBSearchOptionInGereralVO)
			throws EventException {

		try {
			log.debug("####### EQMatchBackNLoadFactorMgtBC.searchMBByServiceMode Start");

			List<QuantityByTypeSizeVO> list = dbDao.searchMBByServiceMode(mBSearchOptionInGereralVO); 

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>(); 
			QuantityByTypeSizeVO vo = null;

			double[] sLocInnQty = new double[41];
			double[] sLocOutQty = new double[41];

			double[] sIpiInnQty = new double[41];
			double[] sIpiOutQty = new double[41];

			double[] sMlbInnQty = new double[41];
			double[] sMlbOutQty = new double[41];

			double[] sTotallQty = new double[41];

			double[] gLocInnQty = new double[41];
			double[] gLocOutQty = new double[41];

			double[] gIpiInnQty = new double[41];
			double[] gIpiOutQty = new double[41];

			double[] gMlbInnQty = new double[41];
			double[] gMlbOutQty = new double[41];

			double[] gTotallQty = new double[41];

			String xTempLocCdVal = "";

			if (list.size() > 1) {

				int x = 0;
				int lastRNo = 0;
				lastRNo = list.size() - 1;
//				log.debug("####### EQMatchBackNLoadFactorMgtBC.searchMBByServiceMode 1032 lastRNo [" + lastRNo + "]");
				if (x == 0) {

					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(list.get(lastRNo).getLocCd());
					vo.setTotal(list.get(lastRNo).getTotal());
					vo.setQty0(list.get(lastRNo).getQty0());
					vo.setQty1(list.get(lastRNo).getQty1());
					vo.setQty2(list.get(lastRNo).getQty2());
					vo.setQty3(list.get(lastRNo).getQty3());
					vo.setQty4(list.get(lastRNo).getQty4());
					vo.setQty5(list.get(lastRNo).getQty5());
					vo.setQty6(list.get(lastRNo).getQty6());
					vo.setQty7(list.get(lastRNo).getQty7());
					vo.setQty8(list.get(lastRNo).getQty8());
					vo.setQty9(list.get(lastRNo).getQty9());
					vo.setQty10(list.get(lastRNo).getQty10());
					vo.setQty11(list.get(lastRNo).getQty11());
					vo.setQty12(list.get(lastRNo).getQty12());
					vo.setQty13(list.get(lastRNo).getQty13());
					vo.setQty14(list.get(lastRNo).getQty14());
					vo.setQty15(list.get(lastRNo).getQty15());
					vo.setQty16(list.get(lastRNo).getQty16());
					vo.setQty17(list.get(lastRNo).getQty17());
					vo.setQty18(list.get(lastRNo).getQty18());
					vo.setQty19(list.get(lastRNo).getQty19());
					vo.setQty20(list.get(lastRNo).getQty20());
					vo.setQty21(list.get(lastRNo).getQty21());
					vo.setQty22(list.get(lastRNo).getQty22());
					vo.setQty23(list.get(lastRNo).getQty23());
					vo.setQty24(list.get(lastRNo).getQty24());
					vo.setQty25(list.get(lastRNo).getQty25());
					vo.setQty26(list.get(lastRNo).getQty26());
					vo.setQty27(list.get(lastRNo).getQty27());
					vo.setQty28(list.get(lastRNo).getQty28());
					vo.setQty29(list.get(lastRNo).getQty29());
					vo.setQty30(list.get(lastRNo).getQty30());
					vo.setQty31(list.get(lastRNo).getQty31());
					vo.setQty32(list.get(lastRNo).getQty32());
					vo.setQty33(list.get(lastRNo).getQty33());
					vo.setQty34(list.get(lastRNo).getQty34());
					vo.setQty35(list.get(lastRNo).getQty35());
					vo.setQty36(list.get(lastRNo).getQty36());
					vo.setQty37(list.get(lastRNo).getQty37());
					vo.setQty38(list.get(lastRNo).getQty38());
					vo.setQty39(list.get(lastRNo).getQty39());
					list2.add(x, vo);
					x++;
				}

				for (int i = 0; i < lastRNo; i++) {
					int k = 0;

					String strLocCd = list.get(i).getLocCd();
					String strVvd = list.get(i).getVvd();
					String strDivision = list.get(i).getDivision();

					if (strDivision.equals("M/B(%)")) {
						k = 3;
					}

					if (xTempLocCdVal.equals(strLocCd) || i == 0) {
						// adding to result List
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(strLocCd);
						vo.setVvd(strVvd);
						vo.setDivision(strDivision);
						vo.setTotal(list.get(i).getTotal());
						vo.setQty0(list.get(i).getQty0());
						vo.setQty1(list.get(i).getQty1());
						vo.setQty2(list.get(i).getQty2());
						vo.setQty3(list.get(i).getQty3());
						vo.setQty4(list.get(i).getQty4());
						vo.setQty5(list.get(i).getQty5());
						vo.setQty6(list.get(i).getQty6());
						vo.setQty7(list.get(i).getQty7());
						vo.setQty8(list.get(i).getQty8());
						vo.setQty9(list.get(i).getQty9());
						vo.setQty10(list.get(i).getQty10());
						vo.setQty11(list.get(i).getQty11());
						vo.setQty12(list.get(i).getQty12());
						vo.setQty13(list.get(i).getQty13());
						vo.setQty14(list.get(i).getQty14());
						vo.setQty15(list.get(i).getQty15());
						vo.setQty16(list.get(i).getQty16());
						vo.setQty17(list.get(i).getQty17());
						vo.setQty18(list.get(i).getQty18());
						vo.setQty19(list.get(i).getQty19());
						vo.setQty20(list.get(i).getQty20());
						vo.setQty21(list.get(i).getQty21());
						vo.setQty22(list.get(i).getQty22());
						vo.setQty23(list.get(i).getQty23());
						vo.setQty24(list.get(i).getQty24());
						vo.setQty25(list.get(i).getQty25());
						vo.setQty26(list.get(i).getQty26());
						vo.setQty27(list.get(i).getQty27());
						vo.setQty28(list.get(i).getQty28());
						vo.setQty29(list.get(i).getQty29());
						vo.setQty30(list.get(i).getQty30());
						vo.setQty31(list.get(i).getQty31());
						vo.setQty32(list.get(i).getQty32());
						vo.setQty33(list.get(i).getQty33());
						vo.setQty34(list.get(i).getQty34());
						vo.setQty35(list.get(i).getQty35());
						vo.setQty36(list.get(i).getQty36());
						vo.setQty37(list.get(i).getQty37());
						vo.setQty38(list.get(i).getQty38());
						vo.setQty39(list.get(i).getQty39());
						list2.add(x, vo);
						x++;

						if (strVvd.equals("LOC")) { // Service Mode Local
							if (strDivision.equals("M/B(%)")) {
								// S.Total LOC
								sLocInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + sLocInnQty[0];
								sLocInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + sLocInnQty[1];
								sLocInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + sLocInnQty[2];
								sLocInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + sLocInnQty[3];
								sLocInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + sLocInnQty[4];
								sLocInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + sLocInnQty[5];
								sLocInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + sLocInnQty[6];
								sLocInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + sLocInnQty[7];
								sLocInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + sLocInnQty[8];
								sLocInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + sLocInnQty[9];
								sLocInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + sLocInnQty[10];
								sLocInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + sLocInnQty[11];
								sLocInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + sLocInnQty[12];
								sLocInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + sLocInnQty[13];
								sLocInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + sLocInnQty[14];
								sLocInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + sLocInnQty[15];
								sLocInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + sLocInnQty[16];
								sLocInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + sLocInnQty[17];
								sLocInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + sLocInnQty[18];
								sLocInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + sLocInnQty[19];
								sLocInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + sLocInnQty[20];
								sLocInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + sLocInnQty[21];
								sLocInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + sLocInnQty[22];
								sLocInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + sLocInnQty[23];
								sLocInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + sLocInnQty[24];
								sLocInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + sLocInnQty[25];
								sLocInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + sLocInnQty[26];
								sLocInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + sLocInnQty[27];
								sLocInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + sLocInnQty[28];
								sLocInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + sLocInnQty[29];
								sLocInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + sLocInnQty[30];
								sLocInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + sLocInnQty[31];
								sLocInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + sLocInnQty[32];
								sLocInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + sLocInnQty[33];
								sLocInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + sLocInnQty[34];
								sLocInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + sLocInnQty[35];
								sLocInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + sLocInnQty[36];
								sLocInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + sLocInnQty[37];
								sLocInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + sLocInnQty[38];
								sLocInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + sLocInnQty[39];
								sLocInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + sLocInnQty[40];

								sLocOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + sLocOutQty[0];
								sLocOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + sLocOutQty[1];
								sLocOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + sLocOutQty[2];
								sLocOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + sLocOutQty[3];
								sLocOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + sLocOutQty[4];
								sLocOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + sLocOutQty[5];
								sLocOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + sLocOutQty[6];
								sLocOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + sLocOutQty[7];
								sLocOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + sLocOutQty[8];
								sLocOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + sLocOutQty[9];
								sLocOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + sLocOutQty[10];
								sLocOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + sLocOutQty[11];
								sLocOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + sLocOutQty[12];
								sLocOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + sLocOutQty[13];
								sLocOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + sLocOutQty[14];
								sLocOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + sLocOutQty[15];
								sLocOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + sLocOutQty[16];
								sLocOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + sLocOutQty[17];
								sLocOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + sLocOutQty[18];
								sLocOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + sLocOutQty[19];
								sLocOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + sLocOutQty[20];
								sLocOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + sLocOutQty[21];
								sLocOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + sLocOutQty[22];
								sLocOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + sLocOutQty[23];
								sLocOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + sLocOutQty[24];
								sLocOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + sLocOutQty[25];
								sLocOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + sLocOutQty[26];
								sLocOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + sLocOutQty[27];
								sLocOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + sLocOutQty[28];
								sLocOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + sLocOutQty[29];
								sLocOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + sLocOutQty[30];
								sLocOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + sLocOutQty[31];
								sLocOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + sLocOutQty[32];
								sLocOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + sLocOutQty[33];
								sLocOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + sLocOutQty[34];
								sLocOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + sLocOutQty[35];
								sLocOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + sLocOutQty[36];
								sLocOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + sLocOutQty[37];
								sLocOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + sLocOutQty[38];
								sLocOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + sLocOutQty[39];
								sLocOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + sLocOutQty[40];

								// G.Total LOC
								gLocInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + gLocInnQty[0];
								gLocInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + gLocInnQty[1];
								gLocInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + gLocInnQty[2];
								gLocInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + gLocInnQty[3];
								gLocInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + gLocInnQty[4];
								gLocInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + gLocInnQty[5];
								gLocInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + gLocInnQty[6];
								gLocInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + gLocInnQty[7];
								gLocInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + gLocInnQty[8];
								gLocInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + gLocInnQty[9];
								gLocInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + gLocInnQty[10];
								gLocInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + gLocInnQty[11];
								gLocInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + gLocInnQty[12];
								gLocInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + gLocInnQty[13];
								gLocInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + gLocInnQty[14];
								gLocInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + gLocInnQty[15];
								gLocInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + gLocInnQty[16];
								gLocInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + gLocInnQty[17];
								gLocInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + gLocInnQty[18];
								gLocInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + gLocInnQty[19];
								gLocInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + gLocInnQty[20];
								gLocInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + gLocInnQty[21];
								gLocInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + gLocInnQty[22];
								gLocInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + gLocInnQty[23];
								gLocInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + gLocInnQty[24];
								gLocInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + gLocInnQty[25];
								gLocInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + gLocInnQty[26];
								gLocInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + gLocInnQty[27];
								gLocInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + gLocInnQty[28];
								gLocInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + gLocInnQty[29];
								gLocInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + gLocInnQty[30];
								gLocInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + gLocInnQty[31];
								gLocInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + gLocInnQty[32];
								gLocInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + gLocInnQty[33];
								gLocInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + gLocInnQty[34];
								gLocInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + gLocInnQty[35];
								gLocInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + gLocInnQty[36];
								gLocInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + gLocInnQty[37];
								gLocInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + gLocInnQty[38];
								gLocInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + gLocInnQty[39];
								gLocInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + gLocInnQty[40];

								gLocOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + gLocOutQty[0];
								gLocOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + gLocOutQty[1];
								gLocOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + gLocOutQty[2];
								gLocOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + gLocOutQty[3];
								gLocOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + gLocOutQty[4];
								gLocOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + gLocOutQty[5];
								gLocOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + gLocOutQty[6];
								gLocOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + gLocOutQty[7];
								gLocOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + gLocOutQty[8];
								gLocOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + gLocOutQty[9];
								gLocOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + gLocOutQty[10];
								gLocOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + gLocOutQty[11];
								gLocOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + gLocOutQty[12];
								gLocOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + gLocOutQty[13];
								gLocOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + gLocOutQty[14];
								gLocOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + gLocOutQty[15];
								gLocOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + gLocOutQty[16];
								gLocOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + gLocOutQty[17];
								gLocOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + gLocOutQty[18];
								gLocOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + gLocOutQty[19];
								gLocOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + gLocOutQty[20];
								gLocOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + gLocOutQty[21];
								gLocOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + gLocOutQty[22];
								gLocOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + gLocOutQty[23];
								gLocOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + gLocOutQty[24];
								gLocOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + gLocOutQty[25];
								gLocOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + gLocOutQty[26];
								gLocOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + gLocOutQty[27];
								gLocOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + gLocOutQty[28];
								gLocOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + gLocOutQty[29];
								gLocOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + gLocOutQty[30];
								gLocOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + gLocOutQty[31];
								gLocOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + gLocOutQty[32];
								gLocOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + gLocOutQty[33];
								gLocOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + gLocOutQty[34];
								gLocOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + gLocOutQty[35];
								gLocOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + gLocOutQty[36];
								gLocOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + gLocOutQty[37];
								gLocOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + gLocOutQty[38];
								gLocOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + gLocOutQty[39];
								gLocOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + gLocOutQty[40];
							} // end if if(strDivision.equals("M/B(%")){ LOC
						}
						else if (strVvd.equals("IPI")) { // Service Mode IPI
							if (strDivision.equals("M/B(%)")) {
								// S.Total IPI
								sIpiInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + sIpiInnQty[0];
								sIpiInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + sIpiInnQty[1];
								sIpiInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + sIpiInnQty[2];
								sIpiInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + sIpiInnQty[3];
								sIpiInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + sIpiInnQty[4];
								sIpiInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + sIpiInnQty[5];
								sIpiInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + sIpiInnQty[6];
								sIpiInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + sIpiInnQty[7];
								sIpiInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + sIpiInnQty[8];
								sIpiInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + sIpiInnQty[9];
								sIpiInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + sIpiInnQty[10];
								sIpiInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + sIpiInnQty[11];
								sIpiInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + sIpiInnQty[12];
								sIpiInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + sIpiInnQty[13];
								sIpiInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + sIpiInnQty[14];
								sIpiInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + sIpiInnQty[15];
								sIpiInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + sIpiInnQty[16];
								sIpiInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + sIpiInnQty[17];
								sIpiInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + sIpiInnQty[18];
								sIpiInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + sIpiInnQty[19];
								sIpiInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + sIpiInnQty[20];
								sIpiInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + sIpiInnQty[21];
								sIpiInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + sIpiInnQty[22];
								sIpiInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + sIpiInnQty[23];
								sIpiInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + sIpiInnQty[24];
								sIpiInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + sIpiInnQty[25];
								sIpiInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + sIpiInnQty[26];
								sIpiInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + sIpiInnQty[27];
								sIpiInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + sIpiInnQty[28];
								sIpiInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + sIpiInnQty[29];
								sIpiInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + sIpiInnQty[30];
								sIpiInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + sIpiInnQty[31];
								sIpiInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + sIpiInnQty[32];
								sIpiInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + sIpiInnQty[33];
								sIpiInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + sIpiInnQty[34];
								sIpiInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + sIpiInnQty[35];
								sIpiInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + sIpiInnQty[36];
								sIpiInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + sIpiInnQty[37];
								sIpiInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + sIpiInnQty[38];
								sIpiInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + sIpiInnQty[39];
								sIpiInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + sIpiInnQty[40];

								sIpiOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + sIpiOutQty[0];
								sIpiOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + sIpiOutQty[1];
								sIpiOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + sIpiOutQty[2];
								sIpiOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + sIpiOutQty[3];
								sIpiOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + sIpiOutQty[4];
								sIpiOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + sIpiOutQty[5];
								sIpiOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + sIpiOutQty[6];
								sIpiOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + sIpiOutQty[7];
								sIpiOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + sIpiOutQty[8];
								sIpiOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + sIpiOutQty[9];
								sIpiOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + sIpiOutQty[10];
								sIpiOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + sIpiOutQty[11];
								sIpiOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + sIpiOutQty[12];
								sIpiOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + sIpiOutQty[13];
								sIpiOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + sIpiOutQty[14];
								sIpiOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + sIpiOutQty[15];
								sIpiOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + sIpiOutQty[16];
								sIpiOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + sIpiOutQty[17];
								sIpiOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + sIpiOutQty[18];
								sIpiOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + sIpiOutQty[19];
								sIpiOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + sIpiOutQty[20];
								sIpiOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + sIpiOutQty[21];
								sIpiOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + sIpiOutQty[22];
								sIpiOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + sIpiOutQty[23];
								sIpiOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + sIpiOutQty[24];
								sIpiOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + sIpiOutQty[25];
								sIpiOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + sIpiOutQty[26];
								sIpiOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + sIpiOutQty[27];
								sIpiOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + sIpiOutQty[28];
								sIpiOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + sIpiOutQty[29];
								sIpiOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + sIpiOutQty[30];
								sIpiOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + sIpiOutQty[31];
								sIpiOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + sIpiOutQty[32];
								sIpiOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + sIpiOutQty[33];
								sIpiOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + sIpiOutQty[34];
								sIpiOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + sIpiOutQty[35];
								sIpiOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + sIpiOutQty[36];
								sIpiOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + sIpiOutQty[37];
								sIpiOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + sIpiOutQty[38];
								sIpiOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + sIpiOutQty[39];
								sIpiOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + sIpiOutQty[40];

								// G.Total IPI
								gIpiInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + gIpiInnQty[0];
								gIpiInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + gIpiInnQty[1];
								gIpiInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + gIpiInnQty[2];
								gIpiInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + gIpiInnQty[3];
								gIpiInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + gIpiInnQty[4];
								gIpiInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + gIpiInnQty[5];
								gIpiInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + gIpiInnQty[6];
								gIpiInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + gIpiInnQty[7];
								gIpiInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + gIpiInnQty[8];
								gIpiInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + gIpiInnQty[9];
								gIpiInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + gIpiInnQty[10];
								gIpiInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + gIpiInnQty[11];
								gIpiInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + gIpiInnQty[12];
								gIpiInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + gIpiInnQty[13];
								gIpiInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + gIpiInnQty[14];
								gIpiInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + gIpiInnQty[15];
								gIpiInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + gIpiInnQty[16];
								gIpiInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + gIpiInnQty[17];
								gIpiInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + gIpiInnQty[18];
								gIpiInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + gIpiInnQty[19];
								gIpiInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + gIpiInnQty[20];
								gIpiInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + gIpiInnQty[21];
								gIpiInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + gIpiInnQty[22];
								gIpiInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + gIpiInnQty[23];
								gIpiInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + gIpiInnQty[24];
								gIpiInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + gIpiInnQty[25];
								gIpiInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + gIpiInnQty[26];
								gIpiInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + gIpiInnQty[27];
								gIpiInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + gIpiInnQty[28];
								gIpiInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + gIpiInnQty[29];
								gIpiInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + gIpiInnQty[30];
								gIpiInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + gIpiInnQty[31];
								gIpiInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + gIpiInnQty[32];
								gIpiInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + gIpiInnQty[33];
								gIpiInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + gIpiInnQty[34];
								gIpiInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + gIpiInnQty[35];
								gIpiInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + gIpiInnQty[36];
								gIpiInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + gIpiInnQty[37];
								gIpiInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + gIpiInnQty[38];
								gIpiInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + gIpiInnQty[39];
								gIpiInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + gIpiInnQty[40];

								gIpiOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + gIpiOutQty[0];
								gIpiOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + gIpiOutQty[1];
								gIpiOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + gIpiOutQty[2];
								gIpiOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + gIpiOutQty[3];
								gIpiOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + gIpiOutQty[4];
								gIpiOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + gIpiOutQty[5];
								gIpiOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + gIpiOutQty[6];
								gIpiOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + gIpiOutQty[7];
								gIpiOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + gIpiOutQty[8];
								gIpiOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + gIpiOutQty[9];
								gIpiOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + gIpiOutQty[10];
								gIpiOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + gIpiOutQty[11];
								gIpiOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + gIpiOutQty[12];
								gIpiOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + gIpiOutQty[13];
								gIpiOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + gIpiOutQty[14];
								gIpiOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + gIpiOutQty[15];
								gIpiOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + gIpiOutQty[16];
								gIpiOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + gIpiOutQty[17];
								gIpiOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + gIpiOutQty[18];
								gIpiOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + gIpiOutQty[19];
								gIpiOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + gIpiOutQty[20];
								gIpiOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + gIpiOutQty[21];
								gIpiOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + gIpiOutQty[22];
								gIpiOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + gIpiOutQty[23];
								gIpiOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + gIpiOutQty[24];
								gIpiOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + gIpiOutQty[25];
								gIpiOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + gIpiOutQty[26];
								gIpiOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + gIpiOutQty[27];
								gIpiOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + gIpiOutQty[28];
								gIpiOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + gIpiOutQty[29];
								gIpiOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + gIpiOutQty[30];
								gIpiOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + gIpiOutQty[31];
								gIpiOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + gIpiOutQty[32];
								gIpiOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + gIpiOutQty[33];
								gIpiOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + gIpiOutQty[34];
								gIpiOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + gIpiOutQty[35];
								gIpiOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + gIpiOutQty[36];
								gIpiOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + gIpiOutQty[37];
								gIpiOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + gIpiOutQty[38];
								gIpiOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + gIpiOutQty[39];
								gIpiOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + gIpiOutQty[40];
							} // end if if(strDivision.equals("M/B(%")){ IPI
						}
						else if (strVvd.equals("MLB")) { // Service Mode MLB
							if (strDivision.equals("M/B(%)")) {
								// S.Total MLB
								sMlbInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + sMlbInnQty[0];
								sMlbInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + sMlbInnQty[1];
								sMlbInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + sMlbInnQty[2];
								sMlbInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + sMlbInnQty[3];
								sMlbInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + sMlbInnQty[4];
								sMlbInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + sMlbInnQty[5];
								sMlbInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + sMlbInnQty[6];
								sMlbInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + sMlbInnQty[7];
								sMlbInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + sMlbInnQty[8];
								sMlbInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + sMlbInnQty[9];
								sMlbInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + sMlbInnQty[10];
								sMlbInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + sMlbInnQty[11];
								sMlbInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + sMlbInnQty[12];
								sMlbInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + sMlbInnQty[13];
								sMlbInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + sMlbInnQty[14];
								sMlbInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + sMlbInnQty[15];
								sMlbInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + sMlbInnQty[16];
								sMlbInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + sMlbInnQty[17];
								sMlbInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + sMlbInnQty[18];
								sMlbInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + sMlbInnQty[19];
								sMlbInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + sMlbInnQty[20];
								sMlbInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + sMlbInnQty[21];
								sMlbInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + sMlbInnQty[22];
								sMlbInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + sMlbInnQty[23];
								sMlbInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + sMlbInnQty[24];
								sMlbInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + sMlbInnQty[25];
								sMlbInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + sMlbInnQty[26];
								sMlbInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + sMlbInnQty[27];
								sMlbInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + sMlbInnQty[28];
								sMlbInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + sMlbInnQty[29];
								sMlbInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + sMlbInnQty[30];
								sMlbInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + sMlbInnQty[31];
								sMlbInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + sMlbInnQty[32];
								sMlbInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + sMlbInnQty[33];
								sMlbInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + sMlbInnQty[34];
								sMlbInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + sMlbInnQty[35];
								sMlbInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + sMlbInnQty[36];
								sMlbInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + sMlbInnQty[37];
								sMlbInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + sMlbInnQty[38];
								sMlbInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + sMlbInnQty[39];
								sMlbInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + sMlbInnQty[40];

								sMlbOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + sMlbOutQty[0];
								sMlbOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + sMlbOutQty[1];
								sMlbOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + sMlbOutQty[2];
								sMlbOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + sMlbOutQty[3];
								sMlbOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + sMlbOutQty[4];
								sMlbOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + sMlbOutQty[5];
								sMlbOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + sMlbOutQty[6];
								sMlbOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + sMlbOutQty[7];
								sMlbOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + sMlbOutQty[8];
								sMlbOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + sMlbOutQty[9];
								sMlbOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + sMlbOutQty[10];
								sMlbOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + sMlbOutQty[11];
								sMlbOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + sMlbOutQty[12];
								sMlbOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + sMlbOutQty[13];
								sMlbOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + sMlbOutQty[14];
								sMlbOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + sMlbOutQty[15];
								sMlbOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + sMlbOutQty[16];
								sMlbOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + sMlbOutQty[17];
								sMlbOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + sMlbOutQty[18];
								sMlbOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + sMlbOutQty[19];
								sMlbOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + sMlbOutQty[20];
								sMlbOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + sMlbOutQty[21];
								sMlbOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + sMlbOutQty[22];
								sMlbOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + sMlbOutQty[23];
								sMlbOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + sMlbOutQty[24];
								sMlbOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + sMlbOutQty[25];
								sMlbOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + sMlbOutQty[26];
								sMlbOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + sMlbOutQty[27];
								sMlbOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + sMlbOutQty[28];
								sMlbOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + sMlbOutQty[29];
								sMlbOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + sMlbOutQty[30];
								sMlbOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + sMlbOutQty[31];
								sMlbOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + sMlbOutQty[32];
								sMlbOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + sMlbOutQty[33];
								sMlbOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + sMlbOutQty[34];
								sMlbOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + sMlbOutQty[35];
								sMlbOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + sMlbOutQty[36];
								sMlbOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + sMlbOutQty[37];
								sMlbOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + sMlbOutQty[38];
								sMlbOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + sMlbOutQty[39];
								sMlbOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + sMlbOutQty[40];

								// G.Total MLB
								gMlbInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + gMlbInnQty[0];
								gMlbInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + gMlbInnQty[1];
								gMlbInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + gMlbInnQty[2];
								gMlbInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + gMlbInnQty[3];
								gMlbInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + gMlbInnQty[4];
								gMlbInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + gMlbInnQty[5];
								gMlbInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + gMlbInnQty[6];
								gMlbInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + gMlbInnQty[7];
								gMlbInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + gMlbInnQty[8];
								gMlbInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + gMlbInnQty[9];
								gMlbInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + gMlbInnQty[10];
								gMlbInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + gMlbInnQty[11];
								gMlbInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + gMlbInnQty[12];
								gMlbInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + gMlbInnQty[13];
								gMlbInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + gMlbInnQty[14];
								gMlbInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + gMlbInnQty[15];
								gMlbInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + gMlbInnQty[16];
								gMlbInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + gMlbInnQty[17];
								gMlbInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + gMlbInnQty[18];
								gMlbInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + gMlbInnQty[19];
								gMlbInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + gMlbInnQty[20];
								gMlbInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + gMlbInnQty[21];
								gMlbInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + gMlbInnQty[22];
								gMlbInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + gMlbInnQty[23];
								gMlbInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + gMlbInnQty[24];
								gMlbInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + gMlbInnQty[25];
								gMlbInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + gMlbInnQty[26];
								gMlbInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + gMlbInnQty[27];
								gMlbInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + gMlbInnQty[28];
								gMlbInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + gMlbInnQty[29];
								gMlbInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + gMlbInnQty[30];
								gMlbInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + gMlbInnQty[31];
								gMlbInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + gMlbInnQty[32];
								gMlbInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + gMlbInnQty[33];
								gMlbInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + gMlbInnQty[34];
								gMlbInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + gMlbInnQty[35];
								gMlbInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + gMlbInnQty[36];
								gMlbInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + gMlbInnQty[37];
								gMlbInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + gMlbInnQty[38];
								gMlbInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + gMlbInnQty[39];
								gMlbInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + gMlbInnQty[40];

								gMlbOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + gMlbOutQty[0];
								gMlbOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + gMlbOutQty[1];
								gMlbOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + gMlbOutQty[2];
								gMlbOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + gMlbOutQty[3];
								gMlbOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + gMlbOutQty[4];
								gMlbOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + gMlbOutQty[5];
								gMlbOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + gMlbOutQty[6];
								gMlbOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + gMlbOutQty[7];
								gMlbOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + gMlbOutQty[8];
								gMlbOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + gMlbOutQty[9];
								gMlbOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + gMlbOutQty[10];
								gMlbOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + gMlbOutQty[11];
								gMlbOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + gMlbOutQty[12];
								gMlbOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + gMlbOutQty[13];
								gMlbOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + gMlbOutQty[14];
								gMlbOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + gMlbOutQty[15];
								gMlbOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + gMlbOutQty[16];
								gMlbOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + gMlbOutQty[17];
								gMlbOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + gMlbOutQty[18];
								gMlbOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + gMlbOutQty[19];
								gMlbOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + gMlbOutQty[20];
								gMlbOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + gMlbOutQty[21];
								gMlbOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + gMlbOutQty[22];
								gMlbOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + gMlbOutQty[23];
								gMlbOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + gMlbOutQty[24];
								gMlbOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + gMlbOutQty[25];
								gMlbOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + gMlbOutQty[26];
								gMlbOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + gMlbOutQty[27];
								gMlbOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + gMlbOutQty[28];
								gMlbOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + gMlbOutQty[29];
								gMlbOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + gMlbOutQty[30];
								gMlbOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + gMlbOutQty[31];
								gMlbOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + gMlbOutQty[32];
								gMlbOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + gMlbOutQty[33];
								gMlbOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + gMlbOutQty[34];
								gMlbOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + gMlbOutQty[35];
								gMlbOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + gMlbOutQty[36];
								gMlbOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + gMlbOutQty[37];
								gMlbOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + gMlbOutQty[38];
								gMlbOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + gMlbOutQty[39];
								gMlbOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + gMlbOutQty[40];
							} // end if if(strDivision.equals("M/B(%")){ MLB
						} // END OF if( strVvd.equals("LOC") ){

					}
					else if (!xTempLocCdVal.equals(strLocCd) || i != 0) { // Total

						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("I/B");
						vo.setTotal(Double.toString(sLocInnQty[40] + sIpiInnQty[40] + sMlbInnQty[40]));
						vo.setQty0(Double.toString(sLocInnQty[0] + sIpiInnQty[0] + sMlbInnQty[0]));
						vo.setQty1(Double.toString(sLocInnQty[1] + sIpiInnQty[1] + sMlbInnQty[1]));
						vo.setQty2(Double.toString(sLocInnQty[2] + sIpiInnQty[2] + sMlbInnQty[2]));
						vo.setQty3(Double.toString(sLocInnQty[3] + sIpiInnQty[3] + sMlbInnQty[3]));
						vo.setQty4(Double.toString(sLocInnQty[4] + sIpiInnQty[4] + sMlbInnQty[4]));
						vo.setQty5(Double.toString(sLocInnQty[5] + sIpiInnQty[5] + sMlbInnQty[5]));
						vo.setQty6(Double.toString(sLocInnQty[6] + sIpiInnQty[6] + sMlbInnQty[6]));
						vo.setQty7(Double.toString(sLocInnQty[7] + sIpiInnQty[7] + sMlbInnQty[7]));
						vo.setQty8(Double.toString(sLocInnQty[8] + sIpiInnQty[8] + sMlbInnQty[8]));
						vo.setQty9(Double.toString(sLocInnQty[9] + sIpiInnQty[9] + sMlbInnQty[9]));
						vo.setQty10(Double.toString(sLocInnQty[10] + sIpiInnQty[10] + sMlbInnQty[10]));
						vo.setQty11(Double.toString(sLocInnQty[11] + sIpiInnQty[11] + sMlbInnQty[11]));
						vo.setQty12(Double.toString(sLocInnQty[12] + sIpiInnQty[12] + sMlbInnQty[12]));
						vo.setQty13(Double.toString(sLocInnQty[13] + sIpiInnQty[13] + sMlbInnQty[13]));
						vo.setQty14(Double.toString(sLocInnQty[14] + sIpiInnQty[14] + sMlbInnQty[14]));
						vo.setQty15(Double.toString(sLocInnQty[15] + sIpiInnQty[15] + sMlbInnQty[15]));
						vo.setQty16(Double.toString(sLocInnQty[16] + sIpiInnQty[16] + sMlbInnQty[16]));
						vo.setQty17(Double.toString(sLocInnQty[17] + sIpiInnQty[17] + sMlbInnQty[17]));
						vo.setQty18(Double.toString(sLocInnQty[18] + sIpiInnQty[18] + sMlbInnQty[18]));
						vo.setQty19(Double.toString(sLocInnQty[19] + sIpiInnQty[19] + sMlbInnQty[19]));
						vo.setQty20(Double.toString(sLocInnQty[20] + sIpiInnQty[20] + sMlbInnQty[20]));
						vo.setQty21(Double.toString(sLocInnQty[21] + sIpiInnQty[21] + sMlbInnQty[21]));
						vo.setQty22(Double.toString(sLocInnQty[22] + sIpiInnQty[22] + sMlbInnQty[22]));
						vo.setQty23(Double.toString(sLocInnQty[23] + sIpiInnQty[23] + sMlbInnQty[23]));
						vo.setQty24(Double.toString(sLocInnQty[24] + sIpiInnQty[24] + sMlbInnQty[24]));
						vo.setQty25(Double.toString(sLocInnQty[25] + sIpiInnQty[25] + sMlbInnQty[25]));
						vo.setQty26(Double.toString(sLocInnQty[26] + sIpiInnQty[26] + sMlbInnQty[26]));
						vo.setQty27(Double.toString(sLocInnQty[27] + sIpiInnQty[27] + sMlbInnQty[27]));
						vo.setQty28(Double.toString(sLocInnQty[28] + sIpiInnQty[28] + sMlbInnQty[28]));
						vo.setQty29(Double.toString(sLocInnQty[29] + sIpiInnQty[29] + sMlbInnQty[29]));
						vo.setQty30(Double.toString(sLocInnQty[30] + sIpiInnQty[30] + sMlbInnQty[30]));
						vo.setQty31(Double.toString(sLocInnQty[31] + sIpiInnQty[31] + sMlbInnQty[31]));
						vo.setQty32(Double.toString(sLocInnQty[32] + sIpiInnQty[32] + sMlbInnQty[32]));
						vo.setQty33(Double.toString(sLocInnQty[33] + sIpiInnQty[33] + sMlbInnQty[33]));
						vo.setQty34(Double.toString(sLocInnQty[34] + sIpiInnQty[34] + sMlbInnQty[34]));
						vo.setQty35(Double.toString(sLocInnQty[35] + sIpiInnQty[35] + sMlbInnQty[35]));
						vo.setQty36(Double.toString(sLocInnQty[36] + sIpiInnQty[36] + sMlbInnQty[36]));
						vo.setQty37(Double.toString(sLocInnQty[37] + sIpiInnQty[37] + sMlbInnQty[37]));
						vo.setQty38(Double.toString(sLocInnQty[38] + sIpiInnQty[38] + sMlbInnQty[38]));
						vo.setQty39(Double.toString(sLocInnQty[39] + sIpiInnQty[39] + sMlbInnQty[39]));
						list2.add(x, vo);
						x++;

						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("O/B");
						vo.setTotal(Double.toString(sLocOutQty[40] + sIpiOutQty[40] + sMlbOutQty[40]));
						vo.setQty0(Double.toString(sLocOutQty[0] + sIpiOutQty[0] + sMlbOutQty[0]));
						vo.setQty1(Double.toString(sLocOutQty[1] + sIpiOutQty[1] + sMlbOutQty[1]));
						vo.setQty2(Double.toString(sLocOutQty[2] + sIpiOutQty[2] + sMlbOutQty[2]));
						vo.setQty3(Double.toString(sLocOutQty[3] + sIpiOutQty[3] + sMlbOutQty[3]));
						vo.setQty4(Double.toString(sLocOutQty[4] + sIpiOutQty[4] + sMlbOutQty[4]));
						vo.setQty5(Double.toString(sLocOutQty[5] + sIpiOutQty[5] + sMlbOutQty[5]));
						vo.setQty6(Double.toString(sLocOutQty[6] + sIpiOutQty[6] + sMlbOutQty[6]));
						vo.setQty7(Double.toString(sLocOutQty[7] + sIpiOutQty[7] + sMlbOutQty[7]));
						vo.setQty8(Double.toString(sLocOutQty[8] + sIpiOutQty[8] + sMlbOutQty[8]));
						vo.setQty9(Double.toString(sLocOutQty[9] + sIpiOutQty[9] + sMlbOutQty[9]));
						vo.setQty10(Double.toString(sLocOutQty[10] + sIpiOutQty[10] + sMlbOutQty[10]));
						vo.setQty11(Double.toString(sLocOutQty[11] + sIpiOutQty[11] + sMlbOutQty[11]));
						vo.setQty12(Double.toString(sLocOutQty[12] + sIpiOutQty[12] + sMlbOutQty[12]));
						vo.setQty13(Double.toString(sLocOutQty[13] + sIpiOutQty[13] + sMlbOutQty[13]));
						vo.setQty14(Double.toString(sLocOutQty[14] + sIpiOutQty[14] + sMlbOutQty[14]));
						vo.setQty15(Double.toString(sLocOutQty[15] + sIpiOutQty[15] + sMlbOutQty[15]));
						vo.setQty16(Double.toString(sLocOutQty[16] + sIpiOutQty[16] + sMlbOutQty[16]));
						vo.setQty17(Double.toString(sLocOutQty[17] + sIpiOutQty[17] + sMlbOutQty[17]));
						vo.setQty18(Double.toString(sLocOutQty[18] + sIpiOutQty[18] + sMlbOutQty[18]));
						vo.setQty19(Double.toString(sLocOutQty[19] + sIpiOutQty[19] + sMlbOutQty[19]));
						vo.setQty20(Double.toString(sLocOutQty[20] + sIpiOutQty[20] + sMlbOutQty[20]));
						vo.setQty21(Double.toString(sLocOutQty[21] + sIpiOutQty[21] + sMlbOutQty[21]));
						vo.setQty22(Double.toString(sLocOutQty[22] + sIpiOutQty[22] + sMlbOutQty[22]));
						vo.setQty23(Double.toString(sLocOutQty[23] + sIpiOutQty[23] + sMlbOutQty[23]));
						vo.setQty24(Double.toString(sLocOutQty[24] + sIpiOutQty[24] + sMlbOutQty[24]));
						vo.setQty25(Double.toString(sLocOutQty[25] + sIpiOutQty[25] + sMlbOutQty[25]));
						vo.setQty26(Double.toString(sLocOutQty[26] + sIpiOutQty[26] + sMlbOutQty[26]));
						vo.setQty27(Double.toString(sLocOutQty[27] + sIpiOutQty[27] + sMlbOutQty[27]));
						vo.setQty28(Double.toString(sLocOutQty[28] + sIpiOutQty[28] + sMlbOutQty[28]));
						vo.setQty29(Double.toString(sLocOutQty[29] + sIpiOutQty[29] + sMlbOutQty[29]));
						vo.setQty30(Double.toString(sLocOutQty[30] + sIpiOutQty[30] + sMlbOutQty[30]));
						vo.setQty31(Double.toString(sLocOutQty[31] + sIpiOutQty[31] + sMlbOutQty[31]));
						vo.setQty32(Double.toString(sLocOutQty[32] + sIpiOutQty[32] + sMlbOutQty[32]));
						vo.setQty33(Double.toString(sLocOutQty[33] + sIpiOutQty[33] + sMlbOutQty[33]));
						vo.setQty34(Double.toString(sLocOutQty[34] + sIpiOutQty[34] + sMlbOutQty[34]));
						vo.setQty35(Double.toString(sLocOutQty[35] + sIpiOutQty[35] + sMlbOutQty[35]));
						vo.setQty36(Double.toString(sLocOutQty[36] + sIpiOutQty[36] + sMlbOutQty[36]));
						vo.setQty37(Double.toString(sLocOutQty[37] + sIpiOutQty[37] + sMlbOutQty[37]));
						vo.setQty38(Double.toString(sLocOutQty[38] + sIpiOutQty[38] + sMlbOutQty[38]));
						vo.setQty39(Double.toString(sLocOutQty[39] + sIpiOutQty[39] + sMlbOutQty[39]));
						list2.add(x, vo);
						x++;

						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("Balance");
						vo.setTotal(Double.toString((sLocInnQty[40] + sIpiInnQty[40] + sMlbInnQty[40])
								- (sLocOutQty[40] + sIpiOutQty[40] + sMlbOutQty[40])));
						vo.setQty0(Double.toString((sLocInnQty[0] + sIpiInnQty[0] + sMlbInnQty[0])
								- (sLocOutQty[0] + sIpiOutQty[0] + sMlbOutQty[0])));
						vo.setQty1(Double.toString((sLocInnQty[1] + sIpiInnQty[1] + sMlbInnQty[1])
								- (sLocOutQty[1] + sIpiOutQty[1] + sMlbOutQty[1])));
						vo.setQty2(Double.toString((sLocInnQty[2] + sIpiInnQty[2] + sMlbInnQty[2])
								- (sLocOutQty[2] + sIpiOutQty[2] + sMlbOutQty[2])));
						vo.setQty3(Double.toString((sLocInnQty[3] + sIpiInnQty[3] + sMlbInnQty[3])
								- (sLocOutQty[3] + sIpiOutQty[3] + sMlbOutQty[3])));
						vo.setQty4(Double.toString((sLocInnQty[4] + sIpiInnQty[4] + sMlbInnQty[4])
								- (sLocOutQty[4] + sIpiOutQty[4] + sMlbOutQty[4])));
						vo.setQty5(Double.toString((sLocInnQty[5] + sIpiInnQty[5] + sMlbInnQty[5])
								- (sLocOutQty[5] + sIpiOutQty[5] + sMlbOutQty[5])));
						vo.setQty6(Double.toString((sLocInnQty[6] + sIpiInnQty[6] + sMlbInnQty[6])
								- (sLocOutQty[6] + sIpiOutQty[6] + sMlbOutQty[6])));
						vo.setQty7(Double.toString((sLocInnQty[7] + sIpiInnQty[7] + sMlbInnQty[7])
								- (sLocOutQty[7] + sIpiOutQty[7] + sMlbOutQty[7])));
						vo.setQty8(Double.toString((sLocInnQty[8] + sIpiInnQty[8] + sMlbInnQty[8])
								- (sLocOutQty[8] + sIpiOutQty[8] + sMlbOutQty[8])));
						vo.setQty9(Double.toString((sLocInnQty[9] + sIpiInnQty[9] + sMlbInnQty[9])
								- (sLocOutQty[9] + sIpiOutQty[9] + sMlbOutQty[9])));
						vo.setQty10(Double.toString((sLocInnQty[10] + sIpiInnQty[10] + sMlbInnQty[10])
								- (sLocOutQty[10] + sIpiOutQty[10] + sMlbOutQty[10])));
						vo.setQty11(Double.toString((sLocInnQty[11] + sIpiInnQty[11] + sMlbInnQty[11])
								- (sLocOutQty[11] + sIpiOutQty[11] + sMlbOutQty[11])));
						vo.setQty12(Double.toString((sLocInnQty[12] + sIpiInnQty[12] + sMlbInnQty[12])
								- (sLocOutQty[12] + sIpiOutQty[12] + sMlbOutQty[12])));
						vo.setQty13(Double.toString((sLocInnQty[13] + sIpiInnQty[13] + sMlbInnQty[13])
								- (sLocOutQty[13] + sIpiOutQty[13] + sMlbOutQty[13])));
						vo.setQty14(Double.toString((sLocInnQty[14] + sIpiInnQty[14] + sMlbInnQty[14])
								- (sLocOutQty[14] + sIpiOutQty[14] + sMlbOutQty[14])));
						vo.setQty15(Double.toString((sLocInnQty[15] + sIpiInnQty[15] + sMlbInnQty[15])
								- (sLocOutQty[15] + sIpiOutQty[15] + sMlbOutQty[15])));
						vo.setQty16(Double.toString((sLocInnQty[16] + sIpiInnQty[16] + sMlbInnQty[16])
								- (sLocOutQty[16] + sIpiOutQty[16] + sMlbOutQty[16])));
						vo.setQty17(Double.toString((sLocInnQty[17] + sIpiInnQty[17] + sMlbInnQty[17])
								- (sLocOutQty[17] + sIpiOutQty[17] + sMlbOutQty[17])));
						vo.setQty18(Double.toString((sLocInnQty[18] + sIpiInnQty[18] + sMlbInnQty[18])
								- (sLocOutQty[18] + sIpiOutQty[18] + sMlbOutQty[18])));
						vo.setQty19(Double.toString((sLocInnQty[19] + sIpiInnQty[19] + sMlbInnQty[19])
								- (sLocOutQty[19] + sIpiOutQty[19] + sMlbOutQty[19])));
						vo.setQty20(Double.toString((sLocInnQty[20] + sIpiInnQty[20] + sMlbInnQty[20])
								- (sLocOutQty[20] + sIpiOutQty[20] + sMlbOutQty[20])));
						vo.setQty21(Double.toString((sLocInnQty[21] + sIpiInnQty[21] + sMlbInnQty[21])
								- (sLocOutQty[21] + sIpiOutQty[21] + sMlbOutQty[21])));
						vo.setQty22(Double.toString((sLocInnQty[22] + sIpiInnQty[22] + sMlbInnQty[22])
								- (sLocOutQty[22] + sIpiOutQty[22] + sMlbOutQty[22])));
						vo.setQty23(Double.toString((sLocInnQty[23] + sIpiInnQty[23] + sMlbInnQty[23])
								- (sLocOutQty[23] + sIpiOutQty[23] + sMlbOutQty[23])));
						vo.setQty24(Double.toString((sLocInnQty[24] + sIpiInnQty[24] + sMlbInnQty[24])
								- (sLocOutQty[24] + sIpiOutQty[24] + sMlbOutQty[24])));
						vo.setQty25(Double.toString((sLocInnQty[25] + sIpiInnQty[25] + sMlbInnQty[25])
								- (sLocOutQty[25] + sIpiOutQty[25] + sMlbOutQty[25])));
						vo.setQty26(Double.toString((sLocInnQty[26] + sIpiInnQty[26] + sMlbInnQty[26])
								- (sLocOutQty[26] + sIpiOutQty[26] + sMlbOutQty[26])));
						vo.setQty27(Double.toString((sLocInnQty[27] + sIpiInnQty[27] + sMlbInnQty[27])
								- (sLocOutQty[27] + sIpiOutQty[27] + sMlbOutQty[27])));
						vo.setQty28(Double.toString((sLocInnQty[28] + sIpiInnQty[28] + sMlbInnQty[28])
								- (sLocOutQty[28] + sIpiOutQty[28] + sMlbOutQty[28])));
						vo.setQty29(Double.toString((sLocInnQty[29] + sIpiInnQty[29] + sMlbInnQty[29])
								- (sLocOutQty[29] + sIpiOutQty[29] + sMlbOutQty[29])));
						vo.setQty30(Double.toString((sLocInnQty[30] + sIpiInnQty[30] + sMlbInnQty[30])
								- (sLocOutQty[30] + sIpiOutQty[30] + sMlbOutQty[30])));
						vo.setQty31(Double.toString((sLocInnQty[31] + sIpiInnQty[31] + sMlbInnQty[31])
								- (sLocOutQty[31] + sIpiOutQty[31] + sMlbOutQty[31])));
						vo.setQty32(Double.toString((sLocInnQty[32] + sIpiInnQty[32] + sMlbInnQty[32])
								- (sLocOutQty[32] + sIpiOutQty[32] + sMlbOutQty[32])));
						vo.setQty33(Double.toString((sLocInnQty[33] + sIpiInnQty[33] + sMlbInnQty[33])
								- (sLocOutQty[33] + sIpiOutQty[33] + sMlbOutQty[33])));
						vo.setQty34(Double.toString((sLocInnQty[34] + sIpiInnQty[34] + sMlbInnQty[34])
								- (sLocOutQty[34] + sIpiOutQty[34] + sMlbOutQty[34])));
						vo.setQty35(Double.toString((sLocInnQty[35] + sIpiInnQty[35] + sMlbInnQty[35])
								- (sLocOutQty[35] + sIpiOutQty[35] + sMlbOutQty[35])));
						vo.setQty36(Double.toString((sLocInnQty[36] + sIpiInnQty[36] + sMlbInnQty[36])
								- (sLocOutQty[36] + sIpiOutQty[36] + sMlbOutQty[36])));
						vo.setQty37(Double.toString((sLocInnQty[37] + sIpiInnQty[37] + sMlbInnQty[37])
								- (sLocOutQty[37] + sIpiOutQty[37] + sMlbOutQty[37])));
						vo.setQty38(Double.toString((sLocInnQty[38] + sIpiInnQty[38] + sMlbInnQty[38])
								- (sLocOutQty[38] + sIpiOutQty[38] + sMlbOutQty[38])));
						vo.setQty39(Double.toString((sLocInnQty[39] + sIpiInnQty[39] + sMlbInnQty[39])
								- (sLocOutQty[39] + sIpiOutQty[39] + sMlbOutQty[39])));
						list2.add(x, vo);
						x++;

						for (int m = 0; m < sLocInnQty.length; m++) {

							if ((sLocInnQty[m] + sIpiInnQty[m] + sMlbInnQty[m]) >= (sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m])) {
								if ((sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m]) > 0) {
									sTotallQty[m] = Math.round((sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m])
											/ (sLocInnQty[m] + sIpiInnQty[m] + sMlbInnQty[m]) * 100);
								}
								else {
									sTotallQty[m] = 0;
								}
							}
							else if ((sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m]) > 0) {
								sTotallQty[m] = Math.round(((sLocInnQty[m] + sIpiInnQty[m] + sMlbInnQty[m])
										/ (sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m]) * (-1)) * 100);
							}
							else {
								sTotallQty[m] = 0;
							}
						}
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("M/B(%)");
						vo.setTotal(Double.toString(sTotallQty[40]));
						vo.setQty0(Double.toString(sTotallQty[0]));
						vo.setQty1(Double.toString(sTotallQty[1]));
						vo.setQty2(Double.toString(sTotallQty[2]));
						vo.setQty3(Double.toString(sTotallQty[3]));
						vo.setQty4(Double.toString(sTotallQty[4]));
						vo.setQty5(Double.toString(sTotallQty[5]));
						vo.setQty6(Double.toString(sTotallQty[6]));
						vo.setQty7(Double.toString(sTotallQty[7]));
						vo.setQty8(Double.toString(sTotallQty[8]));
						vo.setQty9(Double.toString(sTotallQty[9]));
						vo.setQty10(Double.toString(sTotallQty[10]));
						vo.setQty11(Double.toString(sTotallQty[11]));
						vo.setQty12(Double.toString(sTotallQty[12]));
						vo.setQty13(Double.toString(sTotallQty[13]));
						vo.setQty14(Double.toString(sTotallQty[14]));
						vo.setQty15(Double.toString(sTotallQty[15]));
						vo.setQty16(Double.toString(sTotallQty[16]));
						vo.setQty17(Double.toString(sTotallQty[17]));
						vo.setQty18(Double.toString(sTotallQty[18]));
						vo.setQty19(Double.toString(sTotallQty[19]));
						vo.setQty20(Double.toString(sTotallQty[20]));
						vo.setQty21(Double.toString(sTotallQty[21]));
						vo.setQty22(Double.toString(sTotallQty[22]));
						vo.setQty23(Double.toString(sTotallQty[23]));
						vo.setQty24(Double.toString(sTotallQty[24]));
						vo.setQty25(Double.toString(sTotallQty[25]));
						vo.setQty26(Double.toString(sTotallQty[26]));
						vo.setQty27(Double.toString(sTotallQty[27]));
						vo.setQty28(Double.toString(sTotallQty[28]));
						vo.setQty29(Double.toString(sTotallQty[29]));
						vo.setQty30(Double.toString(sTotallQty[30]));
						vo.setQty31(Double.toString(sTotallQty[31]));
						vo.setQty32(Double.toString(sTotallQty[32]));
						vo.setQty33(Double.toString(sTotallQty[33]));
						vo.setQty34(Double.toString(sTotallQty[34]));
						vo.setQty35(Double.toString(sTotallQty[35]));
						vo.setQty36(Double.toString(sTotallQty[36]));
						vo.setQty37(Double.toString(sTotallQty[37]));
						vo.setQty38(Double.toString(sTotallQty[38]));
						vo.setQty39(Double.toString(sTotallQty[39]));
						list2.add(x, vo);
						x++;

						sLocInnQty[40] = 0;
						sIpiInnQty[40] = 0;
						sMlbInnQty[40] = 0;
						sLocOutQty[40] = 0;
						sIpiOutQty[40] = 0;
						sMlbOutQty[40] = 0;
						sLocInnQty[0] = 0;
						sIpiInnQty[0] = 0;
						sMlbInnQty[0] = 0;
						sLocOutQty[0] = 0;
						sIpiOutQty[0] = 0;
						sMlbOutQty[0] = 0;
						sLocInnQty[1] = 0;
						sIpiInnQty[1] = 0;
						sMlbInnQty[1] = 0;
						sLocOutQty[1] = 0;
						sIpiOutQty[1] = 0;
						sMlbOutQty[1] = 0;
						sLocInnQty[2] = 0;
						sIpiInnQty[2] = 0;
						sMlbInnQty[2] = 0;
						sLocOutQty[2] = 0;
						sIpiOutQty[2] = 0;
						sMlbOutQty[2] = 0;
						sLocInnQty[3] = 0;
						sIpiInnQty[3] = 0;
						sMlbInnQty[3] = 0;
						sLocOutQty[3] = 0;
						sIpiOutQty[3] = 0;
						sMlbOutQty[3] = 0;
						sLocInnQty[4] = 0;
						sIpiInnQty[4] = 0;
						sMlbInnQty[4] = 0;
						sLocOutQty[4] = 0;
						sIpiOutQty[4] = 0;
						sMlbOutQty[4] = 0;
						sLocInnQty[5] = 0;
						sIpiInnQty[5] = 0;
						sMlbInnQty[5] = 0;
						sLocOutQty[5] = 0;
						sIpiOutQty[5] = 0;
						sMlbOutQty[5] = 0;
						sLocInnQty[6] = 0;
						sIpiInnQty[6] = 0;
						sMlbInnQty[6] = 0;
						sLocOutQty[6] = 0;
						sIpiOutQty[6] = 0;
						sMlbOutQty[6] = 0;
						sLocInnQty[7] = 0;
						sIpiInnQty[7] = 0;
						sMlbInnQty[7] = 0;
						sLocOutQty[7] = 0;
						sIpiOutQty[7] = 0;
						sMlbOutQty[7] = 0;
						sLocInnQty[8] = 0;
						sIpiInnQty[8] = 0;
						sMlbInnQty[8] = 0;
						sLocOutQty[8] = 0;
						sIpiOutQty[8] = 0;
						sMlbOutQty[8] = 0;
						sLocInnQty[9] = 0;
						sIpiInnQty[9] = 0;
						sMlbInnQty[9] = 0;
						sLocOutQty[9] = 0;
						sIpiOutQty[9] = 0;
						sMlbOutQty[9] = 0;
						sLocInnQty[10] = 0;
						sIpiInnQty[10] = 0;
						sMlbInnQty[10] = 0;
						sLocOutQty[10] = 0;
						sIpiOutQty[10] = 0;
						sMlbOutQty[10] = 0;
						sLocInnQty[11] = 0;
						sIpiInnQty[11] = 0;
						sMlbInnQty[11] = 0;
						sLocOutQty[11] = 0;
						sIpiOutQty[11] = 0;
						sMlbOutQty[11] = 0;
						sLocInnQty[12] = 0;
						sIpiInnQty[12] = 0;
						sMlbInnQty[12] = 0;
						sLocOutQty[12] = 0;
						sIpiOutQty[12] = 0;
						sMlbOutQty[12] = 0;
						sLocInnQty[13] = 0;
						sIpiInnQty[13] = 0;
						sMlbInnQty[13] = 0;
						sLocOutQty[13] = 0;
						sIpiOutQty[13] = 0;
						sMlbOutQty[13] = 0;
						sLocInnQty[14] = 0;
						sIpiInnQty[14] = 0;
						sMlbInnQty[14] = 0;
						sLocOutQty[14] = 0;
						sIpiOutQty[14] = 0;
						sMlbOutQty[14] = 0;
						sLocInnQty[15] = 0;
						sIpiInnQty[15] = 0;
						sMlbInnQty[15] = 0;
						sLocOutQty[15] = 0;
						sIpiOutQty[15] = 0;
						sMlbOutQty[15] = 0;
						sLocInnQty[16] = 0;
						sIpiInnQty[16] = 0;
						sMlbInnQty[16] = 0;
						sLocOutQty[16] = 0;
						sIpiOutQty[16] = 0;
						sMlbOutQty[16] = 0;
						sLocInnQty[17] = 0;
						sIpiInnQty[17] = 0;
						sMlbInnQty[17] = 0;
						sLocOutQty[17] = 0;
						sIpiOutQty[17] = 0;
						sMlbOutQty[17] = 0;
						sLocInnQty[18] = 0;
						sIpiInnQty[18] = 0;
						sMlbInnQty[18] = 0;
						sLocOutQty[18] = 0;
						sIpiOutQty[18] = 0;
						sMlbOutQty[18] = 0;
						sLocInnQty[19] = 0;
						sIpiInnQty[19] = 0;
						sMlbInnQty[19] = 0;
						sLocOutQty[19] = 0;
						sIpiOutQty[19] = 0;
						sMlbOutQty[19] = 0;
						sLocInnQty[20] = 0;
						sIpiInnQty[20] = 0;
						sMlbInnQty[20] = 0;
						sLocOutQty[20] = 0;
						sIpiOutQty[20] = 0;
						sMlbOutQty[20] = 0;
						sLocInnQty[21] = 0;
						sIpiInnQty[21] = 0;
						sMlbInnQty[21] = 0;
						sLocOutQty[21] = 0;
						sIpiOutQty[21] = 0;
						sMlbOutQty[21] = 0;
						sLocInnQty[22] = 0;
						sIpiInnQty[22] = 0;
						sMlbInnQty[22] = 0;
						sLocOutQty[22] = 0;
						sIpiOutQty[22] = 0;
						sMlbOutQty[22] = 0;
						sLocInnQty[23] = 0;
						sIpiInnQty[23] = 0;
						sMlbInnQty[23] = 0;
						sLocOutQty[23] = 0;
						sIpiOutQty[23] = 0;
						sMlbOutQty[23] = 0;
						sLocInnQty[24] = 0;
						sIpiInnQty[24] = 0;
						sMlbInnQty[24] = 0;
						sLocOutQty[24] = 0;
						sIpiOutQty[24] = 0;
						sMlbOutQty[24] = 0;
						sLocInnQty[25] = 0;
						sIpiInnQty[25] = 0;
						sMlbInnQty[25] = 0;
						sLocOutQty[25] = 0;
						sIpiOutQty[25] = 0;
						sMlbOutQty[25] = 0;
						sLocInnQty[26] = 0;
						sIpiInnQty[26] = 0;
						sMlbInnQty[26] = 0;
						sLocOutQty[26] = 0;
						sIpiOutQty[26] = 0;
						sMlbOutQty[26] = 0;
						sLocInnQty[27] = 0;
						sIpiInnQty[27] = 0;
						sMlbInnQty[27] = 0;
						sLocOutQty[27] = 0;
						sIpiOutQty[27] = 0;
						sMlbOutQty[27] = 0;
						sLocInnQty[28] = 0;
						sIpiInnQty[28] = 0;
						sMlbInnQty[28] = 0;
						sLocOutQty[28] = 0;
						sIpiOutQty[28] = 0;
						sMlbOutQty[28] = 0;
						sLocInnQty[29] = 0;
						sIpiInnQty[29] = 0;
						sMlbInnQty[29] = 0;
						sLocOutQty[29] = 0;
						sIpiOutQty[29] = 0;
						sMlbOutQty[29] = 0;
						sLocInnQty[30] = 0;
						sIpiInnQty[30] = 0;
						sMlbInnQty[30] = 0;
						sLocOutQty[30] = 0;
						sIpiOutQty[30] = 0;
						sMlbOutQty[30] = 0;
						sLocInnQty[31] = 0;
						sIpiInnQty[31] = 0;
						sMlbInnQty[31] = 0;
						sLocOutQty[31] = 0;
						sIpiOutQty[31] = 0;
						sMlbOutQty[31] = 0;
						sLocInnQty[32] = 0;
						sIpiInnQty[32] = 0;
						sMlbInnQty[32] = 0;
						sLocOutQty[32] = 0;
						sIpiOutQty[32] = 0;
						sMlbOutQty[32] = 0;
						sLocInnQty[33] = 0;
						sIpiInnQty[33] = 0;
						sMlbInnQty[33] = 0;
						sLocOutQty[33] = 0;
						sIpiOutQty[33] = 0;
						sMlbOutQty[33] = 0;
						sLocInnQty[34] = 0;
						sIpiInnQty[34] = 0;
						sMlbInnQty[34] = 0;
						sLocOutQty[34] = 0;
						sIpiOutQty[34] = 0;
						sMlbOutQty[34] = 0;
						sLocInnQty[35] = 0;
						sIpiInnQty[35] = 0;
						sMlbInnQty[35] = 0;
						sLocOutQty[35] = 0;
						sIpiOutQty[35] = 0;
						sMlbOutQty[35] = 0;
						sLocInnQty[36] = 0;
						sIpiInnQty[36] = 0;
						sMlbInnQty[36] = 0;
						sLocOutQty[36] = 0;
						sIpiOutQty[36] = 0;
						sMlbOutQty[36] = 0;
						sLocInnQty[37] = 0;
						sIpiInnQty[37] = 0;
						sMlbInnQty[37] = 0;
						sLocOutQty[37] = 0;
						sIpiOutQty[37] = 0;
						sMlbOutQty[37] = 0;
						sLocInnQty[38] = 0;
						sIpiInnQty[38] = 0;
						sMlbInnQty[38] = 0;
						sLocOutQty[38] = 0;
						sIpiOutQty[38] = 0;
						sMlbOutQty[38] = 0;
						sLocInnQty[39] = 0;
						sIpiInnQty[39] = 0;
						sMlbInnQty[39] = 0;
						sLocOutQty[39] = 0;
						sIpiOutQty[39] = 0;
						sMlbOutQty[39] = 0;

						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(strLocCd);
						vo.setVvd(strVvd);
						vo.setDivision(strDivision);
						vo.setTotal(list.get(i).getTotal());
						vo.setQty0(list.get(i).getQty0());
						vo.setQty1(list.get(i).getQty1());
						vo.setQty2(list.get(i).getQty2());
						vo.setQty3(list.get(i).getQty3());
						vo.setQty4(list.get(i).getQty4());
						vo.setQty5(list.get(i).getQty5());
						vo.setQty6(list.get(i).getQty6());
						vo.setQty7(list.get(i).getQty7());
						vo.setQty8(list.get(i).getQty8());
						vo.setQty9(list.get(i).getQty9());
						vo.setQty10(list.get(i).getQty10());
						vo.setQty11(list.get(i).getQty11());
						vo.setQty12(list.get(i).getQty12());
						vo.setQty13(list.get(i).getQty13());
						vo.setQty14(list.get(i).getQty14());
						vo.setQty15(list.get(i).getQty15());
						vo.setQty16(list.get(i).getQty16());
						vo.setQty17(list.get(i).getQty17());
						vo.setQty18(list.get(i).getQty18());
						vo.setQty19(list.get(i).getQty19());
						vo.setQty20(list.get(i).getQty20());
						vo.setQty21(list.get(i).getQty21());
						vo.setQty22(list.get(i).getQty22());
						vo.setQty23(list.get(i).getQty23());
						vo.setQty24(list.get(i).getQty24());
						vo.setQty25(list.get(i).getQty25());
						vo.setQty26(list.get(i).getQty26());
						vo.setQty27(list.get(i).getQty27());
						vo.setQty28(list.get(i).getQty28());
						vo.setQty29(list.get(i).getQty29());
						vo.setQty30(list.get(i).getQty30());
						vo.setQty31(list.get(i).getQty31());
						vo.setQty32(list.get(i).getQty32());
						vo.setQty33(list.get(i).getQty33());
						vo.setQty34(list.get(i).getQty34());
						vo.setQty35(list.get(i).getQty35());
						vo.setQty36(list.get(i).getQty36());
						vo.setQty37(list.get(i).getQty37());
						vo.setQty38(list.get(i).getQty38());
						vo.setQty39(list.get(i).getQty39());
						list2.add(x, vo);
						x++;

						if (strVvd.equals("LOC")) {
							if (strDivision.equals("M/B(%)")) {
								// S.Total LOC
								sLocInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + sLocInnQty[0];
								sLocInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + sLocInnQty[1];
								sLocInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + sLocInnQty[2];
								sLocInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + sLocInnQty[3];
								sLocInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + sLocInnQty[4];
								sLocInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + sLocInnQty[5];
								sLocInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + sLocInnQty[6];
								sLocInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + sLocInnQty[7];
								sLocInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + sLocInnQty[8];
								sLocInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + sLocInnQty[9];
								sLocInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + sLocInnQty[10];
								sLocInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + sLocInnQty[11];
								sLocInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + sLocInnQty[12];
								sLocInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + sLocInnQty[13];
								sLocInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + sLocInnQty[14];
								sLocInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + sLocInnQty[15];
								sLocInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + sLocInnQty[16];
								sLocInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + sLocInnQty[17];
								sLocInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + sLocInnQty[18];
								sLocInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + sLocInnQty[19];
								sLocInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + sLocInnQty[20];
								sLocInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + sLocInnQty[21];
								sLocInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + sLocInnQty[22];
								sLocInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + sLocInnQty[23];
								sLocInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + sLocInnQty[24];
								sLocInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + sLocInnQty[25];
								sLocInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + sLocInnQty[26];
								sLocInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + sLocInnQty[27];
								sLocInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + sLocInnQty[28];
								sLocInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + sLocInnQty[29];
								sLocInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + sLocInnQty[30];
								sLocInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + sLocInnQty[31];
								sLocInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + sLocInnQty[32];
								sLocInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + sLocInnQty[33];
								sLocInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + sLocInnQty[34];
								sLocInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + sLocInnQty[35];
								sLocInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + sLocInnQty[36];
								sLocInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + sLocInnQty[37];
								sLocInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + sLocInnQty[38];
								sLocInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + sLocInnQty[39];
								sLocInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + sLocInnQty[40];

								sLocOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + sLocOutQty[0];
								sLocOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + sLocOutQty[1];
								sLocOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + sLocOutQty[2];
								sLocOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + sLocOutQty[3];
								sLocOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + sLocOutQty[4];
								sLocOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + sLocOutQty[5];
								sLocOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + sLocOutQty[6];
								sLocOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + sLocOutQty[7];
								sLocOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + sLocOutQty[8];
								sLocOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + sLocOutQty[9];
								sLocOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + sLocOutQty[10];
								sLocOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + sLocOutQty[11];
								sLocOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + sLocOutQty[12];
								sLocOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + sLocOutQty[13];
								sLocOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + sLocOutQty[14];
								sLocOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + sLocOutQty[15];
								sLocOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + sLocOutQty[16];
								sLocOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + sLocOutQty[17];
								sLocOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + sLocOutQty[18];
								sLocOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + sLocOutQty[19];
								sLocOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + sLocOutQty[20];
								sLocOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + sLocOutQty[21];
								sLocOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + sLocOutQty[22];
								sLocOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + sLocOutQty[23];
								sLocOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + sLocOutQty[24];
								sLocOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + sLocOutQty[25];
								sLocOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + sLocOutQty[26];
								sLocOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + sLocOutQty[27];
								sLocOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + sLocOutQty[28];
								sLocOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + sLocOutQty[29];
								sLocOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + sLocOutQty[30];
								sLocOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + sLocOutQty[31];
								sLocOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + sLocOutQty[32];
								sLocOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + sLocOutQty[33];
								sLocOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + sLocOutQty[34];
								sLocOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + sLocOutQty[35];
								sLocOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + sLocOutQty[36];
								sLocOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + sLocOutQty[37];
								sLocOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + sLocOutQty[38];
								sLocOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + sLocOutQty[39];
								sLocOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + sLocOutQty[40];

								// G.Total LOC
								gLocInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + gLocInnQty[0];
								gLocInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + gLocInnQty[1];
								gLocInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + gLocInnQty[2];
								gLocInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + gLocInnQty[3];
								gLocInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + gLocInnQty[4];
								gLocInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + gLocInnQty[5];
								gLocInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + gLocInnQty[6];
								gLocInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + gLocInnQty[7];
								gLocInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + gLocInnQty[8];
								gLocInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + gLocInnQty[9];
								gLocInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + gLocInnQty[10];
								gLocInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + gLocInnQty[11];
								gLocInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + gLocInnQty[12];
								gLocInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + gLocInnQty[13];
								gLocInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + gLocInnQty[14];
								gLocInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + gLocInnQty[15];
								gLocInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + gLocInnQty[16];
								gLocInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + gLocInnQty[17];
								gLocInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + gLocInnQty[18];
								gLocInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + gLocInnQty[19];
								gLocInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + gLocInnQty[20];
								gLocInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + gLocInnQty[21];
								gLocInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + gLocInnQty[22];
								gLocInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + gLocInnQty[23];
								gLocInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + gLocInnQty[24];
								gLocInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + gLocInnQty[25];
								gLocInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + gLocInnQty[26];
								gLocInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + gLocInnQty[27];
								gLocInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + gLocInnQty[28];
								gLocInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + gLocInnQty[29];
								gLocInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + gLocInnQty[30];
								gLocInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + gLocInnQty[31];
								gLocInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + gLocInnQty[32];
								gLocInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + gLocInnQty[33];
								gLocInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + gLocInnQty[34];
								gLocInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + gLocInnQty[35];
								gLocInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + gLocInnQty[36];
								gLocInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + gLocInnQty[37];
								gLocInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + gLocInnQty[38];
								gLocInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + gLocInnQty[39];
								gLocInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + gLocInnQty[40];

								gLocOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + gLocOutQty[0];
								gLocOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + gLocOutQty[1];
								gLocOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + gLocOutQty[2];
								gLocOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + gLocOutQty[3];
								gLocOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + gLocOutQty[4];
								gLocOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + gLocOutQty[5];
								gLocOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + gLocOutQty[6];
								gLocOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + gLocOutQty[7];
								gLocOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + gLocOutQty[8];
								gLocOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + gLocOutQty[9];
								gLocOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + gLocOutQty[10];
								gLocOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + gLocOutQty[11];
								gLocOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + gLocOutQty[12];
								gLocOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + gLocOutQty[13];
								gLocOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + gLocOutQty[14];
								gLocOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + gLocOutQty[15];
								gLocOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + gLocOutQty[16];
								gLocOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + gLocOutQty[17];
								gLocOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + gLocOutQty[18];
								gLocOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + gLocOutQty[19];
								gLocOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + gLocOutQty[20];
								gLocOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + gLocOutQty[21];
								gLocOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + gLocOutQty[22];
								gLocOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + gLocOutQty[23];
								gLocOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + gLocOutQty[24];
								gLocOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + gLocOutQty[25];
								gLocOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + gLocOutQty[26];
								gLocOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + gLocOutQty[27];
								gLocOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + gLocOutQty[28];
								gLocOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + gLocOutQty[29];
								gLocOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + gLocOutQty[30];
								gLocOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + gLocOutQty[31];
								gLocOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + gLocOutQty[32];
								gLocOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + gLocOutQty[33];
								gLocOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + gLocOutQty[34];
								gLocOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + gLocOutQty[35];
								gLocOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + gLocOutQty[36];
								gLocOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + gLocOutQty[37];
								gLocOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + gLocOutQty[38];
								gLocOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + gLocOutQty[39];
								gLocOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + gLocOutQty[40];
							} // end if if(strDivision.equals("M/B(%")){ LOC
						}
						else if (strVvd.equals("IPI")) { // if(
							// strVvd.equals("LOC")
							// ){
							if (strDivision.equals("M/B(%)")) {
								// S.Total IPI
								sIpiInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + sIpiInnQty[0];
								sIpiInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + sIpiInnQty[1];
								sIpiInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + sIpiInnQty[2];
								sIpiInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + sIpiInnQty[3];
								sIpiInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + sIpiInnQty[4];
								sIpiInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + sIpiInnQty[5];
								sIpiInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + sIpiInnQty[6];
								sIpiInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + sIpiInnQty[7];
								sIpiInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + sIpiInnQty[8];
								sIpiInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + sIpiInnQty[9];
								sIpiInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + sIpiInnQty[10];
								sIpiInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + sIpiInnQty[11];
								sIpiInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + sIpiInnQty[12];
								sIpiInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + sIpiInnQty[13];
								sIpiInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + sIpiInnQty[14];
								sIpiInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + sIpiInnQty[15];
								sIpiInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + sIpiInnQty[16];
								sIpiInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + sIpiInnQty[17];
								sIpiInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + sIpiInnQty[18];
								sIpiInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + sIpiInnQty[19];
								sIpiInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + sIpiInnQty[20];
								sIpiInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + sIpiInnQty[21];
								sIpiInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + sIpiInnQty[22];
								sIpiInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + sIpiInnQty[23];
								sIpiInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + sIpiInnQty[24];
								sIpiInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + sIpiInnQty[25];
								sIpiInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + sIpiInnQty[26];
								sIpiInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + sIpiInnQty[27];
								sIpiInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + sIpiInnQty[28];
								sIpiInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + sIpiInnQty[29];
								sIpiInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + sIpiInnQty[30];
								sIpiInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + sIpiInnQty[31];
								sIpiInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + sIpiInnQty[32];
								sIpiInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + sIpiInnQty[33];
								sIpiInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + sIpiInnQty[34];
								sIpiInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + sIpiInnQty[35];
								sIpiInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + sIpiInnQty[36];
								sIpiInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + sIpiInnQty[37];
								sIpiInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + sIpiInnQty[38];
								sIpiInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + sIpiInnQty[39];
								sIpiInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + sIpiInnQty[40];

								sIpiOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + sIpiOutQty[0];
								sIpiOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + sIpiOutQty[1];
								sIpiOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + sIpiOutQty[2];
								sIpiOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + sIpiOutQty[3];
								sIpiOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + sIpiOutQty[4];
								sIpiOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + sIpiOutQty[5];
								sIpiOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + sIpiOutQty[6];
								sIpiOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + sIpiOutQty[7];
								sIpiOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + sIpiOutQty[8];
								sIpiOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + sIpiOutQty[9];
								sIpiOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + sIpiOutQty[10];
								sIpiOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + sIpiOutQty[11];
								sIpiOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + sIpiOutQty[12];
								sIpiOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + sIpiOutQty[13];
								sIpiOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + sIpiOutQty[14];
								sIpiOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + sIpiOutQty[15];
								sIpiOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + sIpiOutQty[16];
								sIpiOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + sIpiOutQty[17];
								sIpiOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + sIpiOutQty[18];
								sIpiOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + sIpiOutQty[19];
								sIpiOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + sIpiOutQty[20];
								sIpiOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + sIpiOutQty[21];
								sIpiOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + sIpiOutQty[22];
								sIpiOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + sIpiOutQty[23];
								sIpiOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + sIpiOutQty[24];
								sIpiOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + sIpiOutQty[25];
								sIpiOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + sIpiOutQty[26];
								sIpiOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + sIpiOutQty[27];
								sIpiOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + sIpiOutQty[28];
								sIpiOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + sIpiOutQty[29];
								sIpiOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + sIpiOutQty[30];
								sIpiOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + sIpiOutQty[31];
								sIpiOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + sIpiOutQty[32];
								sIpiOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + sIpiOutQty[33];
								sIpiOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + sIpiOutQty[34];
								sIpiOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + sIpiOutQty[35];
								sIpiOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + sIpiOutQty[36];
								sIpiOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + sIpiOutQty[37];
								sIpiOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + sIpiOutQty[38];
								sIpiOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + sIpiOutQty[39];
								sIpiOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + sIpiOutQty[40];

								// G.Total IPI
								gIpiInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + gIpiInnQty[0];
								gIpiInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + gIpiInnQty[1];
								gIpiInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + gIpiInnQty[2];
								gIpiInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + gIpiInnQty[3];
								gIpiInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + gIpiInnQty[4];
								gIpiInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + gIpiInnQty[5];
								gIpiInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + gIpiInnQty[6];
								gIpiInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + gIpiInnQty[7];
								gIpiInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + gIpiInnQty[8];
								gIpiInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + gIpiInnQty[9];
								gIpiInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + gIpiInnQty[10];
								gIpiInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + gIpiInnQty[11];
								gIpiInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + gIpiInnQty[12];
								gIpiInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + gIpiInnQty[13];
								gIpiInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + gIpiInnQty[14];
								gIpiInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + gIpiInnQty[15];
								gIpiInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + gIpiInnQty[16];
								gIpiInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + gIpiInnQty[17];
								gIpiInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + gIpiInnQty[18];
								gIpiInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + gIpiInnQty[19];
								gIpiInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + gIpiInnQty[20];
								gIpiInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + gIpiInnQty[21];
								gIpiInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + gIpiInnQty[22];
								gIpiInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + gIpiInnQty[23];
								gIpiInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + gIpiInnQty[24];
								gIpiInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + gIpiInnQty[25];
								gIpiInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + gIpiInnQty[26];
								gIpiInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + gIpiInnQty[27];
								gIpiInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + gIpiInnQty[28];
								gIpiInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + gIpiInnQty[29];
								gIpiInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + gIpiInnQty[30];
								gIpiInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + gIpiInnQty[31];
								gIpiInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + gIpiInnQty[32];
								gIpiInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + gIpiInnQty[33];
								gIpiInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + gIpiInnQty[34];
								gIpiInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + gIpiInnQty[35];
								gIpiInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + gIpiInnQty[36];
								gIpiInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + gIpiInnQty[37];
								gIpiInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + gIpiInnQty[38];
								gIpiInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + gIpiInnQty[39];
								gIpiInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + gIpiInnQty[40];

								gIpiOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + gIpiOutQty[0];
								gIpiOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + gIpiOutQty[1];
								gIpiOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + gIpiOutQty[2];
								gIpiOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + gIpiOutQty[3];
								gIpiOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + gIpiOutQty[4];
								gIpiOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + gIpiOutQty[5];
								gIpiOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + gIpiOutQty[6];
								gIpiOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + gIpiOutQty[7];
								gIpiOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + gIpiOutQty[8];
								gIpiOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + gIpiOutQty[9];
								gIpiOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + gIpiOutQty[10];
								gIpiOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + gIpiOutQty[11];
								gIpiOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + gIpiOutQty[12];
								gIpiOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + gIpiOutQty[13];
								gIpiOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + gIpiOutQty[14];
								gIpiOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + gIpiOutQty[15];
								gIpiOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + gIpiOutQty[16];
								gIpiOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + gIpiOutQty[17];
								gIpiOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + gIpiOutQty[18];
								gIpiOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + gIpiOutQty[19];
								gIpiOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + gIpiOutQty[20];
								gIpiOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + gIpiOutQty[21];
								gIpiOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + gIpiOutQty[22];
								gIpiOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + gIpiOutQty[23];
								gIpiOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + gIpiOutQty[24];
								gIpiOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + gIpiOutQty[25];
								gIpiOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + gIpiOutQty[26];
								gIpiOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + gIpiOutQty[27];
								gIpiOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + gIpiOutQty[28];
								gIpiOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + gIpiOutQty[29];
								gIpiOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + gIpiOutQty[30];
								gIpiOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + gIpiOutQty[31];
								gIpiOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + gIpiOutQty[32];
								gIpiOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + gIpiOutQty[33];
								gIpiOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + gIpiOutQty[34];
								gIpiOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + gIpiOutQty[35];
								gIpiOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + gIpiOutQty[36];
								gIpiOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + gIpiOutQty[37];
								gIpiOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + gIpiOutQty[38];
								gIpiOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + gIpiOutQty[39];
								gIpiOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + gIpiOutQty[40];
							} // end if if(strDivision.equals("M/B(%")){ IPI
						}
						else if (strVvd.equals("MLB")) { // if(
							// strVvd.equals("LOC")
							// ){
							if (strDivision.equals("M/B(%)")) {
								// S.Total MLB
								sMlbInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + sMlbInnQty[0];
								sMlbInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + sMlbInnQty[1];
								sMlbInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + sMlbInnQty[2];
								sMlbInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + sMlbInnQty[3];
								sMlbInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + sMlbInnQty[4];
								sMlbInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + sMlbInnQty[5];
								sMlbInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + sMlbInnQty[6];
								sMlbInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + sMlbInnQty[7];
								sMlbInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + sMlbInnQty[8];
								sMlbInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + sMlbInnQty[9];
								sMlbInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + sMlbInnQty[10];
								sMlbInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + sMlbInnQty[11];
								sMlbInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + sMlbInnQty[12];
								sMlbInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + sMlbInnQty[13];
								sMlbInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + sMlbInnQty[14];
								sMlbInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + sMlbInnQty[15];
								sMlbInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + sMlbInnQty[16];
								sMlbInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + sMlbInnQty[17];
								sMlbInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + sMlbInnQty[18];
								sMlbInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + sMlbInnQty[19];
								sMlbInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + sMlbInnQty[20];
								sMlbInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + sMlbInnQty[21];
								sMlbInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + sMlbInnQty[22];
								sMlbInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + sMlbInnQty[23];
								sMlbInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + sMlbInnQty[24];
								sMlbInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + sMlbInnQty[25];
								sMlbInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + sMlbInnQty[26];
								sMlbInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + sMlbInnQty[27];
								sMlbInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + sMlbInnQty[28];
								sMlbInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + sMlbInnQty[29];
								sMlbInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + sMlbInnQty[30];
								sMlbInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + sMlbInnQty[31];
								sMlbInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + sMlbInnQty[32];
								sMlbInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + sMlbInnQty[33];
								sMlbInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + sMlbInnQty[34];
								sMlbInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + sMlbInnQty[35];
								sMlbInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + sMlbInnQty[36];
								sMlbInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + sMlbInnQty[37];
								sMlbInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + sMlbInnQty[38];
								sMlbInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + sMlbInnQty[39];
								sMlbInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + sMlbInnQty[40];

								sMlbOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + sMlbOutQty[0];
								sMlbOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + sMlbOutQty[1];
								sMlbOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + sMlbOutQty[2];
								sMlbOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + sMlbOutQty[3];
								sMlbOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + sMlbOutQty[4];
								sMlbOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + sMlbOutQty[5];
								sMlbOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + sMlbOutQty[6];
								sMlbOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + sMlbOutQty[7];
								sMlbOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + sMlbOutQty[8];
								sMlbOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + sMlbOutQty[9];
								sMlbOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + sMlbOutQty[10];
								sMlbOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + sMlbOutQty[11];
								sMlbOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + sMlbOutQty[12];
								sMlbOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + sMlbOutQty[13];
								sMlbOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + sMlbOutQty[14];
								sMlbOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + sMlbOutQty[15];
								sMlbOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + sMlbOutQty[16];
								sMlbOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + sMlbOutQty[17];
								sMlbOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + sMlbOutQty[18];
								sMlbOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + sMlbOutQty[19];
								sMlbOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + sMlbOutQty[20];
								sMlbOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + sMlbOutQty[21];
								sMlbOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + sMlbOutQty[22];
								sMlbOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + sMlbOutQty[23];
								sMlbOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + sMlbOutQty[24];
								sMlbOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + sMlbOutQty[25];
								sMlbOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + sMlbOutQty[26];
								sMlbOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + sMlbOutQty[27];
								sMlbOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + sMlbOutQty[28];
								sMlbOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + sMlbOutQty[29];
								sMlbOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + sMlbOutQty[30];
								sMlbOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + sMlbOutQty[31];
								sMlbOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + sMlbOutQty[32];
								sMlbOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + sMlbOutQty[33];
								sMlbOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + sMlbOutQty[34];
								sMlbOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + sMlbOutQty[35];
								sMlbOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + sMlbOutQty[36];
								sMlbOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + sMlbOutQty[37];
								sMlbOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + sMlbOutQty[38];
								sMlbOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + sMlbOutQty[39];
								sMlbOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + sMlbOutQty[40];

								// G.Total MLB
								gMlbInnQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + gMlbInnQty[0];
								gMlbInnQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + gMlbInnQty[1];
								gMlbInnQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + gMlbInnQty[2];
								gMlbInnQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + gMlbInnQty[3];
								gMlbInnQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + gMlbInnQty[4];
								gMlbInnQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + gMlbInnQty[5];
								gMlbInnQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + gMlbInnQty[6];
								gMlbInnQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + gMlbInnQty[7];
								gMlbInnQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + gMlbInnQty[8];
								gMlbInnQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + gMlbInnQty[9];
								gMlbInnQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + gMlbInnQty[10];
								gMlbInnQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + gMlbInnQty[11];
								gMlbInnQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + gMlbInnQty[12];
								gMlbInnQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + gMlbInnQty[13];
								gMlbInnQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + gMlbInnQty[14];
								gMlbInnQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + gMlbInnQty[15];
								gMlbInnQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + gMlbInnQty[16];
								gMlbInnQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + gMlbInnQty[17];
								gMlbInnQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + gMlbInnQty[18];
								gMlbInnQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + gMlbInnQty[19];
								gMlbInnQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + gMlbInnQty[20];
								gMlbInnQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + gMlbInnQty[21];
								gMlbInnQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + gMlbInnQty[22];
								gMlbInnQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + gMlbInnQty[23];
								gMlbInnQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + gMlbInnQty[24];
								gMlbInnQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + gMlbInnQty[25];
								gMlbInnQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + gMlbInnQty[26];
								gMlbInnQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + gMlbInnQty[27];
								gMlbInnQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + gMlbInnQty[28];
								gMlbInnQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + gMlbInnQty[29];
								gMlbInnQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + gMlbInnQty[30];
								gMlbInnQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + gMlbInnQty[31];
								gMlbInnQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + gMlbInnQty[32];
								gMlbInnQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + gMlbInnQty[33];
								gMlbInnQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + gMlbInnQty[34];
								gMlbInnQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + gMlbInnQty[35];
								gMlbInnQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + gMlbInnQty[36];
								gMlbInnQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + gMlbInnQty[37];
								gMlbInnQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + gMlbInnQty[38];
								gMlbInnQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + gMlbInnQty[39];
								gMlbInnQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + gMlbInnQty[40];

								gMlbOutQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + gMlbOutQty[0];
								gMlbOutQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + gMlbOutQty[1];
								gMlbOutQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + gMlbOutQty[2];
								gMlbOutQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + gMlbOutQty[3];
								gMlbOutQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + gMlbOutQty[4];
								gMlbOutQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + gMlbOutQty[5];
								gMlbOutQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + gMlbOutQty[6];
								gMlbOutQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + gMlbOutQty[7];
								gMlbOutQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + gMlbOutQty[8];
								gMlbOutQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + gMlbOutQty[9];
								gMlbOutQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + gMlbOutQty[10];
								gMlbOutQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + gMlbOutQty[11];
								gMlbOutQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + gMlbOutQty[12];
								gMlbOutQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + gMlbOutQty[13];
								gMlbOutQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + gMlbOutQty[14];
								gMlbOutQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + gMlbOutQty[15];
								gMlbOutQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + gMlbOutQty[16];
								gMlbOutQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + gMlbOutQty[17];
								gMlbOutQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + gMlbOutQty[18];
								gMlbOutQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + gMlbOutQty[19];
								gMlbOutQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + gMlbOutQty[20];
								gMlbOutQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + gMlbOutQty[21];
								gMlbOutQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + gMlbOutQty[22];
								gMlbOutQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + gMlbOutQty[23];
								gMlbOutQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + gMlbOutQty[24];
								gMlbOutQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + gMlbOutQty[25];
								gMlbOutQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + gMlbOutQty[26];
								gMlbOutQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + gMlbOutQty[27];
								gMlbOutQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + gMlbOutQty[28];
								gMlbOutQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + gMlbOutQty[29];
								gMlbOutQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + gMlbOutQty[30];
								gMlbOutQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + gMlbOutQty[31];
								gMlbOutQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + gMlbOutQty[32];
								gMlbOutQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + gMlbOutQty[33];
								gMlbOutQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + gMlbOutQty[34];
								gMlbOutQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + gMlbOutQty[35];
								gMlbOutQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + gMlbOutQty[36];
								gMlbOutQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + gMlbOutQty[37];
								gMlbOutQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + gMlbOutQty[38];
								gMlbOutQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + gMlbOutQty[39];
								gMlbOutQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + gMlbOutQty[40];
							} // end if if(strDivision.equals("M/B(%")){ MLB
						} // END OF if( strVvd.equals("LOC") ){
					} // end of if( xTempLocCdVal.equals(strLocCd) || i==0 ){
					xTempLocCdVal = strLocCd;
				} // end for

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(sLocInnQty[40] + sIpiInnQty[40] + sMlbInnQty[40]));
				vo.setQty0(Double.toString(sLocInnQty[0] + sIpiInnQty[0] + sMlbInnQty[0]));
				vo.setQty1(Double.toString(sLocInnQty[1] + sIpiInnQty[1] + sMlbInnQty[1]));
				vo.setQty2(Double.toString(sLocInnQty[2] + sIpiInnQty[2] + sMlbInnQty[2]));
				vo.setQty3(Double.toString(sLocInnQty[3] + sIpiInnQty[3] + sMlbInnQty[3]));
				vo.setQty4(Double.toString(sLocInnQty[4] + sIpiInnQty[4] + sMlbInnQty[4]));
				vo.setQty5(Double.toString(sLocInnQty[5] + sIpiInnQty[5] + sMlbInnQty[5]));
				vo.setQty6(Double.toString(sLocInnQty[6] + sIpiInnQty[6] + sMlbInnQty[6]));
				vo.setQty7(Double.toString(sLocInnQty[7] + sIpiInnQty[7] + sMlbInnQty[7]));
				vo.setQty8(Double.toString(sLocInnQty[8] + sIpiInnQty[8] + sMlbInnQty[8]));
				vo.setQty9(Double.toString(sLocInnQty[9] + sIpiInnQty[9] + sMlbInnQty[9]));
				vo.setQty10(Double.toString(sLocInnQty[10] + sIpiInnQty[10] + sMlbInnQty[10]));
				vo.setQty11(Double.toString(sLocInnQty[11] + sIpiInnQty[11] + sMlbInnQty[11]));
				vo.setQty12(Double.toString(sLocInnQty[12] + sIpiInnQty[12] + sMlbInnQty[12]));
				vo.setQty13(Double.toString(sLocInnQty[13] + sIpiInnQty[13] + sMlbInnQty[13]));
				vo.setQty14(Double.toString(sLocInnQty[14] + sIpiInnQty[14] + sMlbInnQty[14]));
				vo.setQty15(Double.toString(sLocInnQty[15] + sIpiInnQty[15] + sMlbInnQty[15]));
				vo.setQty16(Double.toString(sLocInnQty[16] + sIpiInnQty[16] + sMlbInnQty[16]));
				vo.setQty17(Double.toString(sLocInnQty[17] + sIpiInnQty[17] + sMlbInnQty[17]));
				vo.setQty18(Double.toString(sLocInnQty[18] + sIpiInnQty[18] + sMlbInnQty[18]));
				vo.setQty19(Double.toString(sLocInnQty[19] + sIpiInnQty[19] + sMlbInnQty[19]));
				vo.setQty20(Double.toString(sLocInnQty[20] + sIpiInnQty[20] + sMlbInnQty[20]));
				vo.setQty21(Double.toString(sLocInnQty[21] + sIpiInnQty[21] + sMlbInnQty[21]));
				vo.setQty22(Double.toString(sLocInnQty[22] + sIpiInnQty[22] + sMlbInnQty[22]));
				vo.setQty23(Double.toString(sLocInnQty[23] + sIpiInnQty[23] + sMlbInnQty[23]));
				vo.setQty24(Double.toString(sLocInnQty[24] + sIpiInnQty[24] + sMlbInnQty[24]));
				vo.setQty25(Double.toString(sLocInnQty[25] + sIpiInnQty[25] + sMlbInnQty[25]));
				vo.setQty26(Double.toString(sLocInnQty[26] + sIpiInnQty[26] + sMlbInnQty[26]));
				vo.setQty27(Double.toString(sLocInnQty[27] + sIpiInnQty[27] + sMlbInnQty[27]));
				vo.setQty28(Double.toString(sLocInnQty[28] + sIpiInnQty[28] + sMlbInnQty[28]));
				vo.setQty29(Double.toString(sLocInnQty[29] + sIpiInnQty[29] + sMlbInnQty[29]));
				vo.setQty30(Double.toString(sLocInnQty[30] + sIpiInnQty[30] + sMlbInnQty[30]));
				vo.setQty31(Double.toString(sLocInnQty[31] + sIpiInnQty[31] + sMlbInnQty[31]));
				vo.setQty32(Double.toString(sLocInnQty[32] + sIpiInnQty[32] + sMlbInnQty[32]));
				vo.setQty33(Double.toString(sLocInnQty[33] + sIpiInnQty[33] + sMlbInnQty[33]));
				vo.setQty34(Double.toString(sLocInnQty[34] + sIpiInnQty[34] + sMlbInnQty[34]));
				vo.setQty35(Double.toString(sLocInnQty[35] + sIpiInnQty[35] + sMlbInnQty[35]));
				vo.setQty36(Double.toString(sLocInnQty[36] + sIpiInnQty[36] + sMlbInnQty[36]));
				vo.setQty37(Double.toString(sLocInnQty[37] + sIpiInnQty[37] + sMlbInnQty[37]));
				vo.setQty38(Double.toString(sLocInnQty[38] + sIpiInnQty[38] + sMlbInnQty[38]));
				vo.setQty39(Double.toString(sLocInnQty[39] + sIpiInnQty[39] + sMlbInnQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(sLocOutQty[40] + sIpiOutQty[40] + sMlbOutQty[40]));
				vo.setQty0(Double.toString(sLocOutQty[0] + sIpiOutQty[0] + sMlbOutQty[0]));
				vo.setQty1(Double.toString(sLocOutQty[1] + sIpiOutQty[1] + sMlbOutQty[1]));
				vo.setQty2(Double.toString(sLocOutQty[2] + sIpiOutQty[2] + sMlbOutQty[2]));
				vo.setQty3(Double.toString(sLocOutQty[3] + sIpiOutQty[3] + sMlbOutQty[3]));
				vo.setQty4(Double.toString(sLocOutQty[4] + sIpiOutQty[4] + sMlbOutQty[4]));
				vo.setQty5(Double.toString(sLocOutQty[5] + sIpiOutQty[5] + sMlbOutQty[5]));
				vo.setQty6(Double.toString(sLocOutQty[6] + sIpiOutQty[6] + sMlbOutQty[6]));
				vo.setQty7(Double.toString(sLocOutQty[7] + sIpiOutQty[7] + sMlbOutQty[7]));
				vo.setQty8(Double.toString(sLocOutQty[8] + sIpiOutQty[8] + sMlbOutQty[8]));
				vo.setQty9(Double.toString(sLocOutQty[9] + sIpiOutQty[9] + sMlbOutQty[9]));
				vo.setQty10(Double.toString(sLocOutQty[10] + sIpiOutQty[10] + sMlbOutQty[10]));
				vo.setQty11(Double.toString(sLocOutQty[11] + sIpiOutQty[11] + sMlbOutQty[11]));
				vo.setQty12(Double.toString(sLocOutQty[12] + sIpiOutQty[12] + sMlbOutQty[12]));
				vo.setQty13(Double.toString(sLocOutQty[13] + sIpiOutQty[13] + sMlbOutQty[13]));
				vo.setQty14(Double.toString(sLocOutQty[14] + sIpiOutQty[14] + sMlbOutQty[14]));
				vo.setQty15(Double.toString(sLocOutQty[15] + sIpiOutQty[15] + sMlbOutQty[15]));
				vo.setQty16(Double.toString(sLocOutQty[16] + sIpiOutQty[16] + sMlbOutQty[16]));
				vo.setQty17(Double.toString(sLocOutQty[17] + sIpiOutQty[17] + sMlbOutQty[17]));
				vo.setQty18(Double.toString(sLocOutQty[18] + sIpiOutQty[18] + sMlbOutQty[18]));
				vo.setQty19(Double.toString(sLocOutQty[19] + sIpiOutQty[19] + sMlbOutQty[19]));
				vo.setQty20(Double.toString(sLocOutQty[20] + sIpiOutQty[20] + sMlbOutQty[20]));
				vo.setQty21(Double.toString(sLocOutQty[21] + sIpiOutQty[21] + sMlbOutQty[21]));
				vo.setQty22(Double.toString(sLocOutQty[22] + sIpiOutQty[22] + sMlbOutQty[22]));
				vo.setQty23(Double.toString(sLocOutQty[23] + sIpiOutQty[23] + sMlbOutQty[23]));
				vo.setQty24(Double.toString(sLocOutQty[24] + sIpiOutQty[24] + sMlbOutQty[24]));
				vo.setQty25(Double.toString(sLocOutQty[25] + sIpiOutQty[25] + sMlbOutQty[25]));
				vo.setQty26(Double.toString(sLocOutQty[26] + sIpiOutQty[26] + sMlbOutQty[26]));
				vo.setQty27(Double.toString(sLocOutQty[27] + sIpiOutQty[27] + sMlbOutQty[27]));
				vo.setQty28(Double.toString(sLocOutQty[28] + sIpiOutQty[28] + sMlbOutQty[28]));
				vo.setQty29(Double.toString(sLocOutQty[29] + sIpiOutQty[29] + sMlbOutQty[29]));
				vo.setQty30(Double.toString(sLocOutQty[30] + sIpiOutQty[30] + sMlbOutQty[30]));
				vo.setQty31(Double.toString(sLocOutQty[31] + sIpiOutQty[31] + sMlbOutQty[31]));
				vo.setQty32(Double.toString(sLocOutQty[32] + sIpiOutQty[32] + sMlbOutQty[32]));
				vo.setQty33(Double.toString(sLocOutQty[33] + sIpiOutQty[33] + sMlbOutQty[33]));
				vo.setQty34(Double.toString(sLocOutQty[34] + sIpiOutQty[34] + sMlbOutQty[34]));
				vo.setQty35(Double.toString(sLocOutQty[35] + sIpiOutQty[35] + sMlbOutQty[35]));
				vo.setQty36(Double.toString(sLocOutQty[36] + sIpiOutQty[36] + sMlbOutQty[36]));
				vo.setQty37(Double.toString(sLocOutQty[37] + sIpiOutQty[37] + sMlbOutQty[37]));
				vo.setQty38(Double.toString(sLocOutQty[38] + sIpiOutQty[38] + sMlbOutQty[38]));
				vo.setQty39(Double.toString(sLocOutQty[39] + sIpiOutQty[39] + sMlbOutQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString((sLocInnQty[40] + sIpiInnQty[40] + sMlbInnQty[40])
						- (sLocOutQty[40] + sIpiOutQty[40] + sMlbOutQty[40])));
				vo.setQty0(Double.toString((sLocInnQty[0] + sIpiInnQty[0] + sMlbInnQty[0])
						- (sLocOutQty[0] + sIpiOutQty[0] + sMlbOutQty[0])));
				vo.setQty1(Double.toString((sLocInnQty[1] + sIpiInnQty[1] + sMlbInnQty[1])
						- (sLocOutQty[1] + sIpiOutQty[1] + sMlbOutQty[1])));
				vo.setQty2(Double.toString((sLocInnQty[2] + sIpiInnQty[2] + sMlbInnQty[2])
						- (sLocOutQty[2] + sIpiOutQty[2] + sMlbOutQty[2])));
				vo.setQty3(Double.toString((sLocInnQty[3] + sIpiInnQty[3] + sMlbInnQty[3])
						- (sLocOutQty[3] + sIpiOutQty[3] + sMlbOutQty[3])));
				vo.setQty4(Double.toString((sLocInnQty[4] + sIpiInnQty[4] + sMlbInnQty[4])
						- (sLocOutQty[4] + sIpiOutQty[4] + sMlbOutQty[4])));
				vo.setQty5(Double.toString((sLocInnQty[5] + sIpiInnQty[5] + sMlbInnQty[5])
						- (sLocOutQty[5] + sIpiOutQty[5] + sMlbOutQty[5])));
				vo.setQty6(Double.toString((sLocInnQty[6] + sIpiInnQty[6] + sMlbInnQty[6])
						- (sLocOutQty[6] + sIpiOutQty[6] + sMlbOutQty[6])));
				vo.setQty7(Double.toString((sLocInnQty[7] + sIpiInnQty[7] + sMlbInnQty[7])
						- (sLocOutQty[7] + sIpiOutQty[7] + sMlbOutQty[7])));
				vo.setQty8(Double.toString((sLocInnQty[8] + sIpiInnQty[8] + sMlbInnQty[8])
						- (sLocOutQty[8] + sIpiOutQty[8] + sMlbOutQty[8])));
				vo.setQty9(Double.toString((sLocInnQty[9] + sIpiInnQty[9] + sMlbInnQty[9])
						- (sLocOutQty[9] + sIpiOutQty[9] + sMlbOutQty[9])));
				vo.setQty10(Double.toString((sLocInnQty[10] + sIpiInnQty[10] + sMlbInnQty[10])
						- (sLocOutQty[10] + sIpiOutQty[10] + sMlbOutQty[10])));
				vo.setQty11(Double.toString((sLocInnQty[11] + sIpiInnQty[11] + sMlbInnQty[11])
						- (sLocOutQty[11] + sIpiOutQty[11] + sMlbOutQty[11])));
				vo.setQty12(Double.toString((sLocInnQty[12] + sIpiInnQty[12] + sMlbInnQty[12])
						- (sLocOutQty[12] + sIpiOutQty[12] + sMlbOutQty[12])));
				vo.setQty13(Double.toString((sLocInnQty[13] + sIpiInnQty[13] + sMlbInnQty[13])
						- (sLocOutQty[13] + sIpiOutQty[13] + sMlbOutQty[13])));
				vo.setQty14(Double.toString((sLocInnQty[14] + sIpiInnQty[14] + sMlbInnQty[14])
						- (sLocOutQty[14] + sIpiOutQty[14] + sMlbOutQty[14])));
				vo.setQty15(Double.toString((sLocInnQty[15] + sIpiInnQty[15] + sMlbInnQty[15])
						- (sLocOutQty[15] + sIpiOutQty[15] + sMlbOutQty[15])));
				vo.setQty16(Double.toString((sLocInnQty[16] + sIpiInnQty[16] + sMlbInnQty[16])
						- (sLocOutQty[16] + sIpiOutQty[16] + sMlbOutQty[16])));
				vo.setQty17(Double.toString((sLocInnQty[17] + sIpiInnQty[17] + sMlbInnQty[17])
						- (sLocOutQty[17] + sIpiOutQty[17] + sMlbOutQty[17])));
				vo.setQty18(Double.toString((sLocInnQty[18] + sIpiInnQty[18] + sMlbInnQty[18])
						- (sLocOutQty[18] + sIpiOutQty[18] + sMlbOutQty[18])));
				vo.setQty19(Double.toString((sLocInnQty[19] + sIpiInnQty[19] + sMlbInnQty[19])
						- (sLocOutQty[19] + sIpiOutQty[19] + sMlbOutQty[19])));
				vo.setQty20(Double.toString((sLocInnQty[20] + sIpiInnQty[20] + sMlbInnQty[20])
						- (sLocOutQty[20] + sIpiOutQty[20] + sMlbOutQty[20])));
				vo.setQty21(Double.toString((sLocInnQty[21] + sIpiInnQty[21] + sMlbInnQty[21])
						- (sLocOutQty[21] + sIpiOutQty[21] + sMlbOutQty[21])));
				vo.setQty22(Double.toString((sLocInnQty[22] + sIpiInnQty[22] + sMlbInnQty[22])
						- (sLocOutQty[22] + sIpiOutQty[22] + sMlbOutQty[22])));
				vo.setQty23(Double.toString((sLocInnQty[23] + sIpiInnQty[23] + sMlbInnQty[23])
						- (sLocOutQty[23] + sIpiOutQty[23] + sMlbOutQty[23])));
				vo.setQty24(Double.toString((sLocInnQty[24] + sIpiInnQty[24] + sMlbInnQty[24])
						- (sLocOutQty[24] + sIpiOutQty[24] + sMlbOutQty[24])));
				vo.setQty25(Double.toString((sLocInnQty[25] + sIpiInnQty[25] + sMlbInnQty[25])
						- (sLocOutQty[25] + sIpiOutQty[25] + sMlbOutQty[25])));
				vo.setQty26(Double.toString((sLocInnQty[26] + sIpiInnQty[26] + sMlbInnQty[26])
						- (sLocOutQty[26] + sIpiOutQty[26] + sMlbOutQty[26])));
				vo.setQty27(Double.toString((sLocInnQty[27] + sIpiInnQty[27] + sMlbInnQty[27])
						- (sLocOutQty[27] + sIpiOutQty[27] + sMlbOutQty[27])));
				vo.setQty28(Double.toString((sLocInnQty[28] + sIpiInnQty[28] + sMlbInnQty[28])
						- (sLocOutQty[28] + sIpiOutQty[28] + sMlbOutQty[28])));
				vo.setQty29(Double.toString((sLocInnQty[29] + sIpiInnQty[29] + sMlbInnQty[29])
						- (sLocOutQty[29] + sIpiOutQty[29] + sMlbOutQty[29])));
				vo.setQty30(Double.toString((sLocInnQty[30] + sIpiInnQty[30] + sMlbInnQty[30])
						- (sLocOutQty[30] + sIpiOutQty[30] + sMlbOutQty[30])));
				vo.setQty31(Double.toString((sLocInnQty[31] + sIpiInnQty[31] + sMlbInnQty[31])
						- (sLocOutQty[31] + sIpiOutQty[31] + sMlbOutQty[31])));
				vo.setQty32(Double.toString((sLocInnQty[32] + sIpiInnQty[32] + sMlbInnQty[32])
						- (sLocOutQty[32] + sIpiOutQty[32] + sMlbOutQty[32])));
				vo.setQty33(Double.toString((sLocInnQty[33] + sIpiInnQty[33] + sMlbInnQty[33])
						- (sLocOutQty[33] + sIpiOutQty[33] + sMlbOutQty[33])));
				vo.setQty34(Double.toString((sLocInnQty[34] + sIpiInnQty[34] + sMlbInnQty[34])
						- (sLocOutQty[34] + sIpiOutQty[34] + sMlbOutQty[34])));
				vo.setQty35(Double.toString((sLocInnQty[35] + sIpiInnQty[35] + sMlbInnQty[35])
						- (sLocOutQty[35] + sIpiOutQty[35] + sMlbOutQty[35])));
				vo.setQty36(Double.toString((sLocInnQty[36] + sIpiInnQty[36] + sMlbInnQty[36])
						- (sLocOutQty[36] + sIpiOutQty[36] + sMlbOutQty[36])));
				vo.setQty37(Double.toString((sLocInnQty[37] + sIpiInnQty[37] + sMlbInnQty[37])
						- (sLocOutQty[37] + sIpiOutQty[37] + sMlbOutQty[37])));
				vo.setQty38(Double.toString((sLocInnQty[38] + sIpiInnQty[38] + sMlbInnQty[38])
						- (sLocOutQty[38] + sIpiOutQty[38] + sMlbOutQty[38])));
				vo.setQty39(Double.toString((sLocInnQty[39] + sIpiInnQty[39] + sMlbInnQty[39])
						- (sLocOutQty[39] + sIpiOutQty[39] + sMlbOutQty[39])));
				list2.add(x, vo);
				x++;

				for (int m = 0; m < sLocInnQty.length; m++) {

					if ((sLocInnQty[m] + sIpiInnQty[m] + sMlbInnQty[m]) >= (sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m])) {
						if ((sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m]) > 0) {
							sTotallQty[m] = Math.round((sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m])
									/ (sLocInnQty[m] + sIpiInnQty[m] + sMlbInnQty[m]) * 100);
						}
						else {
							sTotallQty[m] = 0;
						}
					}
					else if ((sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m]) > 0) {
						sTotallQty[m] = Math.round(((sLocInnQty[m] + sIpiInnQty[m] + sMlbInnQty[m])
								/ (sLocOutQty[m] + sIpiOutQty[m] + sMlbOutQty[m]) * (-1)) * 100);
					}
					else {
						sTotallQty[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(sTotallQty[40]));
				vo.setQty0(Double.toString(sTotallQty[0]));
				vo.setQty1(Double.toString(sTotallQty[1]));
				vo.setQty2(Double.toString(sTotallQty[2]));
				vo.setQty3(Double.toString(sTotallQty[3]));
				vo.setQty4(Double.toString(sTotallQty[4]));
				vo.setQty5(Double.toString(sTotallQty[5]));
				vo.setQty6(Double.toString(sTotallQty[6]));
				vo.setQty7(Double.toString(sTotallQty[7]));
				vo.setQty8(Double.toString(sTotallQty[8]));
				vo.setQty9(Double.toString(sTotallQty[9]));
				vo.setQty10(Double.toString(sTotallQty[10]));
				vo.setQty11(Double.toString(sTotallQty[11]));
				vo.setQty12(Double.toString(sTotallQty[12]));
				vo.setQty13(Double.toString(sTotallQty[13]));
				vo.setQty14(Double.toString(sTotallQty[14]));
				vo.setQty15(Double.toString(sTotallQty[15]));
				vo.setQty16(Double.toString(sTotallQty[16]));
				vo.setQty17(Double.toString(sTotallQty[17]));
				vo.setQty18(Double.toString(sTotallQty[18]));
				vo.setQty19(Double.toString(sTotallQty[19]));
				vo.setQty20(Double.toString(sTotallQty[20]));
				vo.setQty21(Double.toString(sTotallQty[21]));
				vo.setQty22(Double.toString(sTotallQty[22]));
				vo.setQty23(Double.toString(sTotallQty[23]));
				vo.setQty24(Double.toString(sTotallQty[24]));
				vo.setQty25(Double.toString(sTotallQty[25]));
				vo.setQty26(Double.toString(sTotallQty[26]));
				vo.setQty27(Double.toString(sTotallQty[27]));
				vo.setQty28(Double.toString(sTotallQty[28]));
				vo.setQty29(Double.toString(sTotallQty[29]));
				vo.setQty30(Double.toString(sTotallQty[30]));
				vo.setQty31(Double.toString(sTotallQty[31]));
				vo.setQty32(Double.toString(sTotallQty[32]));
				vo.setQty33(Double.toString(sTotallQty[33]));
				vo.setQty34(Double.toString(sTotallQty[34]));
				vo.setQty35(Double.toString(sTotallQty[35]));
				vo.setQty36(Double.toString(sTotallQty[36]));
				vo.setQty37(Double.toString(sTotallQty[37]));
				vo.setQty38(Double.toString(sTotallQty[38]));
				vo.setQty39(Double.toString(sTotallQty[39]));
				list2.add(x, vo);
				x++;

				// G.Total
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("LOC");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(gLocInnQty[40]));
				vo.setQty0(Double.toString(gLocInnQty[0]));
				vo.setQty1(Double.toString(gLocInnQty[1]));
				vo.setQty2(Double.toString(gLocInnQty[2]));
				vo.setQty3(Double.toString(gLocInnQty[3]));
				vo.setQty4(Double.toString(gLocInnQty[4]));
				vo.setQty5(Double.toString(gLocInnQty[5]));
				vo.setQty6(Double.toString(gLocInnQty[6]));
				vo.setQty7(Double.toString(gLocInnQty[7]));
				vo.setQty8(Double.toString(gLocInnQty[8]));
				vo.setQty9(Double.toString(gLocInnQty[9]));
				vo.setQty10(Double.toString(gLocInnQty[10]));
				vo.setQty11(Double.toString(gLocInnQty[11]));
				vo.setQty12(Double.toString(gLocInnQty[12]));
				vo.setQty13(Double.toString(gLocInnQty[13]));
				vo.setQty14(Double.toString(gLocInnQty[14]));
				vo.setQty15(Double.toString(gLocInnQty[15]));
				vo.setQty16(Double.toString(gLocInnQty[16]));
				vo.setQty17(Double.toString(gLocInnQty[17]));
				vo.setQty18(Double.toString(gLocInnQty[18]));
				vo.setQty19(Double.toString(gLocInnQty[19]));
				vo.setQty20(Double.toString(gLocInnQty[20]));
				vo.setQty21(Double.toString(gLocInnQty[21]));
				vo.setQty22(Double.toString(gLocInnQty[22]));
				vo.setQty23(Double.toString(gLocInnQty[23]));
				vo.setQty24(Double.toString(gLocInnQty[24]));
				vo.setQty25(Double.toString(gLocInnQty[25]));
				vo.setQty26(Double.toString(gLocInnQty[26]));
				vo.setQty27(Double.toString(gLocInnQty[27]));
				vo.setQty28(Double.toString(gLocInnQty[28]));
				vo.setQty29(Double.toString(gLocInnQty[29]));
				vo.setQty30(Double.toString(gLocInnQty[30]));
				vo.setQty31(Double.toString(gLocInnQty[31]));
				vo.setQty32(Double.toString(gLocInnQty[32]));
				vo.setQty33(Double.toString(gLocInnQty[33]));
				vo.setQty34(Double.toString(gLocInnQty[34]));
				vo.setQty35(Double.toString(gLocInnQty[35]));
				vo.setQty36(Double.toString(gLocInnQty[36]));
				vo.setQty37(Double.toString(gLocInnQty[37]));
				vo.setQty38(Double.toString(gLocInnQty[38]));
				vo.setQty39(Double.toString(gLocInnQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("LOC");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(gLocOutQty[40]));
				vo.setQty0(Double.toString(gLocOutQty[0]));
				vo.setQty1(Double.toString(gLocOutQty[1]));
				vo.setQty2(Double.toString(gLocOutQty[2]));
				vo.setQty3(Double.toString(gLocOutQty[3]));
				vo.setQty4(Double.toString(gLocOutQty[4]));
				vo.setQty5(Double.toString(gLocOutQty[5]));
				vo.setQty6(Double.toString(gLocOutQty[6]));
				vo.setQty7(Double.toString(gLocOutQty[7]));
				vo.setQty8(Double.toString(gLocOutQty[8]));
				vo.setQty9(Double.toString(gLocOutQty[9]));
				vo.setQty10(Double.toString(gLocOutQty[10]));
				vo.setQty11(Double.toString(gLocOutQty[11]));
				vo.setQty12(Double.toString(gLocOutQty[12]));
				vo.setQty13(Double.toString(gLocOutQty[13]));
				vo.setQty14(Double.toString(gLocOutQty[14]));
				vo.setQty15(Double.toString(gLocOutQty[15]));
				vo.setQty16(Double.toString(gLocOutQty[16]));
				vo.setQty17(Double.toString(gLocOutQty[17]));
				vo.setQty18(Double.toString(gLocOutQty[18]));
				vo.setQty19(Double.toString(gLocOutQty[19]));
				vo.setQty20(Double.toString(gLocOutQty[20]));
				vo.setQty21(Double.toString(gLocOutQty[21]));
				vo.setQty22(Double.toString(gLocOutQty[22]));
				vo.setQty23(Double.toString(gLocOutQty[23]));
				vo.setQty24(Double.toString(gLocOutQty[24]));
				vo.setQty25(Double.toString(gLocOutQty[25]));
				vo.setQty26(Double.toString(gLocOutQty[26]));
				vo.setQty27(Double.toString(gLocOutQty[27]));
				vo.setQty28(Double.toString(gLocOutQty[28]));
				vo.setQty29(Double.toString(gLocOutQty[29]));
				vo.setQty30(Double.toString(gLocOutQty[30]));
				vo.setQty31(Double.toString(gLocOutQty[31]));
				vo.setQty32(Double.toString(gLocOutQty[32]));
				vo.setQty33(Double.toString(gLocOutQty[33]));
				vo.setQty34(Double.toString(gLocOutQty[34]));
				vo.setQty35(Double.toString(gLocOutQty[35]));
				vo.setQty36(Double.toString(gLocOutQty[36]));
				vo.setQty37(Double.toString(gLocOutQty[37]));
				vo.setQty38(Double.toString(gLocOutQty[38]));
				vo.setQty39(Double.toString(gLocOutQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("LOC");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString(gLocInnQty[40] - gLocOutQty[40]));
				vo.setQty0(Double.toString(gLocInnQty[0] - gLocOutQty[0]));
				vo.setQty1(Double.toString(gLocInnQty[1] - gLocOutQty[1]));
				vo.setQty2(Double.toString(gLocInnQty[2] - gLocOutQty[2]));
				vo.setQty3(Double.toString(gLocInnQty[3] - gLocOutQty[3]));
				vo.setQty4(Double.toString(gLocInnQty[4] - gLocOutQty[4]));
				vo.setQty5(Double.toString(gLocInnQty[5] - gLocOutQty[5]));
				vo.setQty6(Double.toString(gLocInnQty[6] - gLocOutQty[6]));
				vo.setQty7(Double.toString(gLocInnQty[7] - gLocOutQty[7]));
				vo.setQty8(Double.toString(gLocInnQty[8] - gLocOutQty[8]));
				vo.setQty9(Double.toString(gLocInnQty[9] - gLocOutQty[9]));
				vo.setQty10(Double.toString(gLocInnQty[10] - gLocOutQty[10]));
				vo.setQty11(Double.toString(gLocInnQty[11] - gLocOutQty[11]));
				vo.setQty12(Double.toString(gLocInnQty[12] - gLocOutQty[12]));
				vo.setQty13(Double.toString(gLocInnQty[13] - gLocOutQty[13]));
				vo.setQty14(Double.toString(gLocInnQty[14] - gLocOutQty[14]));
				vo.setQty15(Double.toString(gLocInnQty[15] - gLocOutQty[15]));
				vo.setQty16(Double.toString(gLocInnQty[16] - gLocOutQty[16]));
				vo.setQty17(Double.toString(gLocInnQty[17] - gLocOutQty[17]));
				vo.setQty18(Double.toString(gLocInnQty[18] - gLocOutQty[18]));
				vo.setQty19(Double.toString(gLocInnQty[19] - gLocOutQty[19]));
				vo.setQty20(Double.toString(gLocInnQty[20] - gLocOutQty[20]));
				vo.setQty21(Double.toString(gLocInnQty[21] - gLocOutQty[21]));
				vo.setQty22(Double.toString(gLocInnQty[22] - gLocOutQty[22]));
				vo.setQty23(Double.toString(gLocInnQty[23] - gLocOutQty[23]));
				vo.setQty24(Double.toString(gLocInnQty[24] - gLocOutQty[24]));
				vo.setQty25(Double.toString(gLocInnQty[25] - gLocOutQty[25]));
				vo.setQty26(Double.toString(gLocInnQty[26] - gLocOutQty[26]));
				vo.setQty27(Double.toString(gLocInnQty[27] - gLocOutQty[27]));
				vo.setQty28(Double.toString(gLocInnQty[28] - gLocOutQty[28]));
				vo.setQty29(Double.toString(gLocInnQty[29] - gLocOutQty[29]));
				vo.setQty30(Double.toString(gLocInnQty[30] - gLocOutQty[30]));
				vo.setQty31(Double.toString(gLocInnQty[31] - gLocOutQty[31]));
				vo.setQty32(Double.toString(gLocInnQty[32] - gLocOutQty[32]));
				vo.setQty33(Double.toString(gLocInnQty[33] - gLocOutQty[33]));
				vo.setQty34(Double.toString(gLocInnQty[34] - gLocOutQty[34]));
				vo.setQty35(Double.toString(gLocInnQty[35] - gLocOutQty[35]));
				vo.setQty36(Double.toString(gLocInnQty[36] - gLocOutQty[36]));
				vo.setQty37(Double.toString(gLocInnQty[37] - gLocOutQty[37]));
				vo.setQty38(Double.toString(gLocInnQty[38] - gLocOutQty[38]));
				vo.setQty39(Double.toString(gLocInnQty[39] - gLocOutQty[39]));
				list2.add(x, vo);
				x++;

				for (int m = 0; m < gLocInnQty.length; m++) {

					if (gLocInnQty[m] >= gLocOutQty[m]) {
						if ((gLocOutQty[m]) > 0) {
							gTotallQty[m] = Math.round(gLocOutQty[m] / gLocInnQty[m] * 100);
						}
						else {
							gTotallQty[m] = 0;
						}
					}
					else if (gLocOutQty[m] > 0) {
						gTotallQty[m] = Math.round((gLocInnQty[m] / gLocOutQty[m] * (-1)) * 100);
					}
					else {
						gTotallQty[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("LOC");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(gTotallQty[40]));
				vo.setQty0(Double.toString(gTotallQty[0]));
				vo.setQty1(Double.toString(gTotallQty[1]));
				vo.setQty2(Double.toString(gTotallQty[2]));
				vo.setQty3(Double.toString(gTotallQty[3]));
				vo.setQty4(Double.toString(gTotallQty[4]));
				vo.setQty5(Double.toString(gTotallQty[5]));
				vo.setQty6(Double.toString(gTotallQty[6]));
				vo.setQty7(Double.toString(gTotallQty[7]));
				vo.setQty8(Double.toString(gTotallQty[8]));
				vo.setQty9(Double.toString(gTotallQty[9]));
				vo.setQty10(Double.toString(gTotallQty[10]));
				vo.setQty11(Double.toString(gTotallQty[11]));
				vo.setQty12(Double.toString(gTotallQty[12]));
				vo.setQty13(Double.toString(gTotallQty[13]));
				vo.setQty14(Double.toString(gTotallQty[14]));
				vo.setQty15(Double.toString(gTotallQty[15]));
				vo.setQty16(Double.toString(gTotallQty[16]));
				vo.setQty17(Double.toString(gTotallQty[17]));
				vo.setQty18(Double.toString(gTotallQty[18]));
				vo.setQty19(Double.toString(gTotallQty[19]));
				vo.setQty20(Double.toString(gTotallQty[20]));
				vo.setQty21(Double.toString(gTotallQty[21]));
				vo.setQty22(Double.toString(gTotallQty[22]));
				vo.setQty23(Double.toString(gTotallQty[23]));
				vo.setQty24(Double.toString(gTotallQty[24]));
				vo.setQty25(Double.toString(gTotallQty[25]));
				vo.setQty26(Double.toString(gTotallQty[26]));
				vo.setQty27(Double.toString(gTotallQty[27]));
				vo.setQty28(Double.toString(gTotallQty[28]));
				vo.setQty29(Double.toString(gTotallQty[29]));
				vo.setQty30(Double.toString(gTotallQty[30]));
				vo.setQty31(Double.toString(gTotallQty[31]));
				vo.setQty32(Double.toString(gTotallQty[32]));
				vo.setQty33(Double.toString(gTotallQty[33]));
				vo.setQty34(Double.toString(gTotallQty[34]));
				vo.setQty35(Double.toString(gTotallQty[35]));
				vo.setQty36(Double.toString(gTotallQty[36]));
				vo.setQty37(Double.toString(gTotallQty[37]));
				vo.setQty38(Double.toString(gTotallQty[38]));
				vo.setQty39(Double.toString(gTotallQty[39]));
				list2.add(x, vo);
				x++;

				// /////////////////// LOC

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("IPI");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(gIpiInnQty[40]));
				vo.setQty0(Double.toString(gIpiInnQty[0]));
				vo.setQty1(Double.toString(gIpiInnQty[1]));
				vo.setQty2(Double.toString(gIpiInnQty[2]));
				vo.setQty3(Double.toString(gIpiInnQty[3]));
				vo.setQty4(Double.toString(gIpiInnQty[4]));
				vo.setQty5(Double.toString(gIpiInnQty[5]));
				vo.setQty6(Double.toString(gIpiInnQty[6]));
				vo.setQty7(Double.toString(gIpiInnQty[7]));
				vo.setQty8(Double.toString(gIpiInnQty[8]));
				vo.setQty9(Double.toString(gIpiInnQty[9]));
				vo.setQty10(Double.toString(gIpiInnQty[10]));
				vo.setQty11(Double.toString(gIpiInnQty[11]));
				vo.setQty12(Double.toString(gIpiInnQty[12]));
				vo.setQty13(Double.toString(gIpiInnQty[13]));
				vo.setQty14(Double.toString(gIpiInnQty[14]));
				vo.setQty15(Double.toString(gIpiInnQty[15]));
				vo.setQty16(Double.toString(gIpiInnQty[16]));
				vo.setQty17(Double.toString(gIpiInnQty[17]));
				vo.setQty18(Double.toString(gIpiInnQty[18]));
				vo.setQty19(Double.toString(gIpiInnQty[19]));
				vo.setQty20(Double.toString(gIpiInnQty[20]));
				vo.setQty21(Double.toString(gIpiInnQty[21]));
				vo.setQty22(Double.toString(gIpiInnQty[22]));
				vo.setQty23(Double.toString(gIpiInnQty[23]));
				vo.setQty24(Double.toString(gIpiInnQty[24]));
				vo.setQty25(Double.toString(gIpiInnQty[25]));
				vo.setQty26(Double.toString(gIpiInnQty[26]));
				vo.setQty27(Double.toString(gIpiInnQty[27]));
				vo.setQty28(Double.toString(gIpiInnQty[28]));
				vo.setQty29(Double.toString(gIpiInnQty[29]));
				vo.setQty30(Double.toString(gIpiInnQty[30]));
				vo.setQty31(Double.toString(gIpiInnQty[31]));
				vo.setQty32(Double.toString(gIpiInnQty[32]));
				vo.setQty33(Double.toString(gIpiInnQty[33]));
				vo.setQty34(Double.toString(gIpiInnQty[34]));
				vo.setQty35(Double.toString(gIpiInnQty[35]));
				vo.setQty36(Double.toString(gIpiInnQty[36]));
				vo.setQty37(Double.toString(gIpiInnQty[37]));
				vo.setQty38(Double.toString(gIpiInnQty[38]));
				vo.setQty39(Double.toString(gIpiInnQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("IPI");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(gIpiOutQty[40]));
				vo.setQty0(Double.toString(gIpiOutQty[0]));
				vo.setQty1(Double.toString(gIpiOutQty[1]));
				vo.setQty2(Double.toString(gIpiOutQty[2]));
				vo.setQty3(Double.toString(gIpiOutQty[3]));
				vo.setQty4(Double.toString(gIpiOutQty[4]));
				vo.setQty5(Double.toString(gIpiOutQty[5]));
				vo.setQty6(Double.toString(gIpiOutQty[6]));
				vo.setQty7(Double.toString(gIpiOutQty[7]));
				vo.setQty8(Double.toString(gIpiOutQty[8]));
				vo.setQty9(Double.toString(gIpiOutQty[9]));
				vo.setQty10(Double.toString(gIpiOutQty[10]));
				vo.setQty11(Double.toString(gIpiOutQty[11]));
				vo.setQty12(Double.toString(gIpiOutQty[12]));
				vo.setQty13(Double.toString(gIpiOutQty[13]));
				vo.setQty14(Double.toString(gIpiOutQty[14]));
				vo.setQty15(Double.toString(gIpiOutQty[15]));
				vo.setQty16(Double.toString(gIpiOutQty[16]));
				vo.setQty17(Double.toString(gIpiOutQty[17]));
				vo.setQty18(Double.toString(gIpiOutQty[18]));
				vo.setQty19(Double.toString(gIpiOutQty[19]));
				vo.setQty20(Double.toString(gIpiOutQty[20]));
				vo.setQty21(Double.toString(gIpiOutQty[21]));
				vo.setQty22(Double.toString(gIpiOutQty[22]));
				vo.setQty23(Double.toString(gIpiOutQty[23]));
				vo.setQty24(Double.toString(gIpiOutQty[24]));
				vo.setQty25(Double.toString(gIpiOutQty[25]));
				vo.setQty26(Double.toString(gIpiOutQty[26]));
				vo.setQty27(Double.toString(gIpiOutQty[27]));
				vo.setQty28(Double.toString(gIpiOutQty[28]));
				vo.setQty29(Double.toString(gIpiOutQty[29]));
				vo.setQty30(Double.toString(gIpiOutQty[30]));
				vo.setQty31(Double.toString(gIpiOutQty[31]));
				vo.setQty32(Double.toString(gIpiOutQty[32]));
				vo.setQty33(Double.toString(gIpiOutQty[33]));
				vo.setQty34(Double.toString(gIpiOutQty[34]));
				vo.setQty35(Double.toString(gIpiOutQty[35]));
				vo.setQty36(Double.toString(gIpiOutQty[36]));
				vo.setQty37(Double.toString(gIpiOutQty[37]));
				vo.setQty38(Double.toString(gIpiOutQty[38]));
				vo.setQty39(Double.toString(gIpiOutQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("IPI");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString(gIpiInnQty[40] - gIpiOutQty[40]));
				vo.setQty0(Double.toString(gIpiInnQty[0] - gIpiOutQty[0]));
				vo.setQty1(Double.toString(gIpiInnQty[1] - gIpiOutQty[1]));
				vo.setQty2(Double.toString(gIpiInnQty[2] - gIpiOutQty[2]));
				vo.setQty3(Double.toString(gIpiInnQty[3] - gIpiOutQty[3]));
				vo.setQty4(Double.toString(gIpiInnQty[4] - gIpiOutQty[4]));
				vo.setQty5(Double.toString(gIpiInnQty[5] - gIpiOutQty[5]));
				vo.setQty6(Double.toString(gIpiInnQty[6] - gIpiOutQty[6]));
				vo.setQty7(Double.toString(gIpiInnQty[7] - gIpiOutQty[7]));
				vo.setQty8(Double.toString(gIpiInnQty[8] - gIpiOutQty[8]));
				vo.setQty9(Double.toString(gIpiInnQty[9] - gIpiOutQty[9]));
				vo.setQty10(Double.toString(gIpiInnQty[10] - gIpiOutQty[10]));
				vo.setQty11(Double.toString(gIpiInnQty[11] - gIpiOutQty[11]));
				vo.setQty12(Double.toString(gIpiInnQty[12] - gIpiOutQty[12]));
				vo.setQty13(Double.toString(gIpiInnQty[13] - gIpiOutQty[13]));
				vo.setQty14(Double.toString(gIpiInnQty[14] - gIpiOutQty[14]));
				vo.setQty15(Double.toString(gIpiInnQty[15] - gIpiOutQty[15]));
				vo.setQty16(Double.toString(gIpiInnQty[16] - gIpiOutQty[16]));
				vo.setQty17(Double.toString(gIpiInnQty[17] - gIpiOutQty[17]));
				vo.setQty18(Double.toString(gIpiInnQty[18] - gIpiOutQty[18]));
				vo.setQty19(Double.toString(gIpiInnQty[19] - gIpiOutQty[19]));
				vo.setQty20(Double.toString(gIpiInnQty[20] - gIpiOutQty[20]));
				vo.setQty21(Double.toString(gIpiInnQty[21] - gIpiOutQty[21]));
				vo.setQty22(Double.toString(gIpiInnQty[22] - gIpiOutQty[22]));
				vo.setQty23(Double.toString(gIpiInnQty[23] - gIpiOutQty[23]));
				vo.setQty24(Double.toString(gIpiInnQty[24] - gIpiOutQty[24]));
				vo.setQty25(Double.toString(gIpiInnQty[25] - gIpiOutQty[25]));
				vo.setQty26(Double.toString(gIpiInnQty[26] - gIpiOutQty[26]));
				vo.setQty27(Double.toString(gIpiInnQty[27] - gIpiOutQty[27]));
				vo.setQty28(Double.toString(gIpiInnQty[28] - gIpiOutQty[28]));
				vo.setQty29(Double.toString(gIpiInnQty[29] - gIpiOutQty[29]));
				vo.setQty30(Double.toString(gIpiInnQty[30] - gIpiOutQty[30]));
				vo.setQty31(Double.toString(gIpiInnQty[31] - gIpiOutQty[31]));
				vo.setQty32(Double.toString(gIpiInnQty[32] - gIpiOutQty[32]));
				vo.setQty33(Double.toString(gIpiInnQty[33] - gIpiOutQty[33]));
				vo.setQty34(Double.toString(gIpiInnQty[34] - gIpiOutQty[34]));
				vo.setQty35(Double.toString(gIpiInnQty[35] - gIpiOutQty[35]));
				vo.setQty36(Double.toString(gIpiInnQty[36] - gIpiOutQty[36]));
				vo.setQty37(Double.toString(gIpiInnQty[37] - gIpiOutQty[37]));
				vo.setQty38(Double.toString(gIpiInnQty[38] - gIpiOutQty[38]));
				vo.setQty39(Double.toString(gIpiInnQty[39] - gIpiOutQty[39]));
				list2.add(x, vo);
				x++;

				for (int m = 0; m < gLocInnQty.length; m++) {

					if (gIpiInnQty[m] >= gIpiOutQty[m]) {
						if (gIpiOutQty[m] > 0) {
							gTotallQty[m] = Math.round(gIpiOutQty[m] / gIpiInnQty[m] * 100);
						}
						else {
							gTotallQty[m] = 0;
						}
					}
					else if (gIpiOutQty[m] > 0) {
						gTotallQty[m] = Math.round((gIpiInnQty[m] / gIpiOutQty[m] * (-1)) * 100);
					}
					else {
						gTotallQty[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("IPI");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(gTotallQty[40]));
				vo.setQty0(Double.toString(gTotallQty[0]));
				vo.setQty1(Double.toString(gTotallQty[1]));
				vo.setQty2(Double.toString(gTotallQty[2]));
				vo.setQty3(Double.toString(gTotallQty[3]));
				vo.setQty4(Double.toString(gTotallQty[4]));
				vo.setQty5(Double.toString(gTotallQty[5]));
				vo.setQty6(Double.toString(gTotallQty[6]));
				vo.setQty7(Double.toString(gTotallQty[7]));
				vo.setQty8(Double.toString(gTotallQty[8]));
				vo.setQty9(Double.toString(gTotallQty[9]));
				vo.setQty10(Double.toString(gTotallQty[10]));
				vo.setQty11(Double.toString(gTotallQty[11]));
				vo.setQty12(Double.toString(gTotallQty[12]));
				vo.setQty13(Double.toString(gTotallQty[13]));
				vo.setQty14(Double.toString(gTotallQty[14]));
				vo.setQty15(Double.toString(gTotallQty[15]));
				vo.setQty16(Double.toString(gTotallQty[16]));
				vo.setQty17(Double.toString(gTotallQty[17]));
				vo.setQty18(Double.toString(gTotallQty[18]));
				vo.setQty19(Double.toString(gTotallQty[19]));
				vo.setQty20(Double.toString(gTotallQty[20]));
				vo.setQty21(Double.toString(gTotallQty[21]));
				vo.setQty22(Double.toString(gTotallQty[22]));
				vo.setQty23(Double.toString(gTotallQty[23]));
				vo.setQty24(Double.toString(gTotallQty[24]));
				vo.setQty25(Double.toString(gTotallQty[25]));
				vo.setQty26(Double.toString(gTotallQty[26]));
				vo.setQty27(Double.toString(gTotallQty[27]));
				vo.setQty28(Double.toString(gTotallQty[28]));
				vo.setQty29(Double.toString(gTotallQty[29]));
				vo.setQty30(Double.toString(gTotallQty[30]));
				vo.setQty31(Double.toString(gTotallQty[31]));
				vo.setQty32(Double.toString(gTotallQty[32]));
				vo.setQty33(Double.toString(gTotallQty[33]));
				vo.setQty34(Double.toString(gTotallQty[34]));
				vo.setQty35(Double.toString(gTotallQty[35]));
				vo.setQty36(Double.toString(gTotallQty[36]));
				vo.setQty37(Double.toString(gTotallQty[37]));
				vo.setQty38(Double.toString(gTotallQty[38]));
				vo.setQty39(Double.toString(gTotallQty[39]));
				list2.add(x, vo);
				x++;

				// ///////////////// IPI

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("MLB");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(gMlbInnQty[40]));
				vo.setQty0(Double.toString(gMlbInnQty[0]));
				vo.setQty1(Double.toString(gMlbInnQty[1]));
				vo.setQty2(Double.toString(gMlbInnQty[2]));
				vo.setQty3(Double.toString(gMlbInnQty[3]));
				vo.setQty4(Double.toString(gMlbInnQty[4]));
				vo.setQty5(Double.toString(gMlbInnQty[5]));
				vo.setQty6(Double.toString(gMlbInnQty[6]));
				vo.setQty7(Double.toString(gMlbInnQty[7]));
				vo.setQty8(Double.toString(gMlbInnQty[8]));
				vo.setQty9(Double.toString(gMlbInnQty[9]));
				vo.setQty10(Double.toString(gMlbInnQty[10]));
				vo.setQty11(Double.toString(gMlbInnQty[11]));
				vo.setQty12(Double.toString(gMlbInnQty[12]));
				vo.setQty13(Double.toString(gMlbInnQty[13]));
				vo.setQty14(Double.toString(gMlbInnQty[14]));
				vo.setQty15(Double.toString(gMlbInnQty[15]));
				vo.setQty16(Double.toString(gMlbInnQty[16]));
				vo.setQty17(Double.toString(gMlbInnQty[17]));
				vo.setQty18(Double.toString(gMlbInnQty[18]));
				vo.setQty19(Double.toString(gMlbInnQty[19]));
				vo.setQty20(Double.toString(gMlbInnQty[20]));
				vo.setQty21(Double.toString(gMlbInnQty[21]));
				vo.setQty22(Double.toString(gMlbInnQty[22]));
				vo.setQty23(Double.toString(gMlbInnQty[23]));
				vo.setQty24(Double.toString(gMlbInnQty[24]));
				vo.setQty25(Double.toString(gMlbInnQty[25]));
				vo.setQty26(Double.toString(gMlbInnQty[26]));
				vo.setQty27(Double.toString(gMlbInnQty[27]));
				vo.setQty28(Double.toString(gMlbInnQty[28]));
				vo.setQty29(Double.toString(gMlbInnQty[29]));
				vo.setQty30(Double.toString(gMlbInnQty[30]));
				vo.setQty31(Double.toString(gMlbInnQty[31]));
				vo.setQty32(Double.toString(gMlbInnQty[32]));
				vo.setQty33(Double.toString(gMlbInnQty[33]));
				vo.setQty34(Double.toString(gMlbInnQty[34]));
				vo.setQty35(Double.toString(gMlbInnQty[35]));
				vo.setQty36(Double.toString(gMlbInnQty[36]));
				vo.setQty37(Double.toString(gMlbInnQty[37]));
				vo.setQty38(Double.toString(gMlbInnQty[38]));
				vo.setQty39(Double.toString(gMlbInnQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("MLB");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(gMlbOutQty[40]));
				vo.setQty0(Double.toString(gMlbOutQty[0]));
				vo.setQty1(Double.toString(gMlbOutQty[1]));
				vo.setQty2(Double.toString(gMlbOutQty[2]));
				vo.setQty3(Double.toString(gMlbOutQty[3]));
				vo.setQty4(Double.toString(gMlbOutQty[4]));
				vo.setQty5(Double.toString(gMlbOutQty[5]));
				vo.setQty6(Double.toString(gMlbOutQty[6]));
				vo.setQty7(Double.toString(gMlbOutQty[7]));
				vo.setQty8(Double.toString(gMlbOutQty[8]));
				vo.setQty9(Double.toString(gMlbOutQty[9]));
				vo.setQty10(Double.toString(gMlbOutQty[10]));
				vo.setQty11(Double.toString(gMlbOutQty[11]));
				vo.setQty12(Double.toString(gMlbOutQty[12]));
				vo.setQty13(Double.toString(gMlbOutQty[13]));
				vo.setQty14(Double.toString(gMlbOutQty[14]));
				vo.setQty15(Double.toString(gMlbOutQty[15]));
				vo.setQty16(Double.toString(gMlbOutQty[16]));
				vo.setQty17(Double.toString(gMlbOutQty[17]));
				vo.setQty18(Double.toString(gMlbOutQty[18]));
				vo.setQty19(Double.toString(gMlbOutQty[19]));
				vo.setQty20(Double.toString(gMlbOutQty[20]));
				vo.setQty21(Double.toString(gMlbOutQty[21]));
				vo.setQty22(Double.toString(gMlbOutQty[22]));
				vo.setQty23(Double.toString(gMlbOutQty[23]));
				vo.setQty24(Double.toString(gMlbOutQty[24]));
				vo.setQty25(Double.toString(gMlbOutQty[25]));
				vo.setQty26(Double.toString(gMlbOutQty[26]));
				vo.setQty27(Double.toString(gMlbOutQty[27]));
				vo.setQty28(Double.toString(gMlbOutQty[28]));
				vo.setQty29(Double.toString(gMlbOutQty[29]));
				vo.setQty30(Double.toString(gMlbOutQty[30]));
				vo.setQty31(Double.toString(gMlbOutQty[31]));
				vo.setQty32(Double.toString(gMlbOutQty[32]));
				vo.setQty33(Double.toString(gMlbOutQty[33]));
				vo.setQty34(Double.toString(gMlbOutQty[34]));
				vo.setQty35(Double.toString(gMlbOutQty[35]));
				vo.setQty36(Double.toString(gMlbOutQty[36]));
				vo.setQty37(Double.toString(gMlbOutQty[37]));
				vo.setQty38(Double.toString(gMlbOutQty[38]));
				vo.setQty39(Double.toString(gMlbOutQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("MLB");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString(gMlbInnQty[40] - gMlbOutQty[40]));
				vo.setQty0(Double.toString(gMlbInnQty[0] - gMlbOutQty[0]));
				vo.setQty1(Double.toString(gMlbInnQty[1] - gMlbOutQty[1]));
				vo.setQty2(Double.toString(gMlbInnQty[2] - gMlbOutQty[2]));
				vo.setQty3(Double.toString(gMlbInnQty[3] - gMlbOutQty[3]));
				vo.setQty4(Double.toString(gMlbInnQty[4] - gMlbOutQty[4]));
				vo.setQty5(Double.toString(gMlbInnQty[5] - gMlbOutQty[5]));
				vo.setQty6(Double.toString(gMlbInnQty[6] - gMlbOutQty[6]));
				vo.setQty7(Double.toString(gMlbInnQty[7] - gMlbOutQty[7]));
				vo.setQty8(Double.toString(gMlbInnQty[8] - gMlbOutQty[8]));
				vo.setQty9(Double.toString(gMlbInnQty[9] - gMlbOutQty[9]));
				vo.setQty10(Double.toString(gMlbInnQty[10] - gMlbOutQty[10]));
				vo.setQty11(Double.toString(gMlbInnQty[11] - gMlbOutQty[11]));
				vo.setQty12(Double.toString(gMlbInnQty[12] - gMlbOutQty[12]));
				vo.setQty13(Double.toString(gMlbInnQty[13] - gMlbOutQty[13]));
				vo.setQty14(Double.toString(gMlbInnQty[14] - gMlbOutQty[14]));
				vo.setQty15(Double.toString(gMlbInnQty[15] - gMlbOutQty[15]));
				vo.setQty16(Double.toString(gMlbInnQty[16] - gMlbOutQty[16]));
				vo.setQty17(Double.toString(gMlbInnQty[17] - gMlbOutQty[17]));
				vo.setQty18(Double.toString(gMlbInnQty[18] - gMlbOutQty[18]));
				vo.setQty19(Double.toString(gMlbInnQty[19] - gMlbOutQty[19]));
				vo.setQty20(Double.toString(gMlbInnQty[20] - gMlbOutQty[20]));
				vo.setQty21(Double.toString(gMlbInnQty[21] - gMlbOutQty[21]));
				vo.setQty22(Double.toString(gMlbInnQty[22] - gMlbOutQty[22]));
				vo.setQty23(Double.toString(gMlbInnQty[23] - gMlbOutQty[23]));
				vo.setQty24(Double.toString(gMlbInnQty[24] - gMlbOutQty[24]));
				vo.setQty25(Double.toString(gMlbInnQty[25] - gMlbOutQty[25]));
				vo.setQty26(Double.toString(gMlbInnQty[26] - gMlbOutQty[26]));
				vo.setQty27(Double.toString(gMlbInnQty[27] - gMlbOutQty[27]));
				vo.setQty28(Double.toString(gMlbInnQty[28] - gMlbOutQty[28]));
				vo.setQty29(Double.toString(gMlbInnQty[29] - gMlbOutQty[29]));
				vo.setQty30(Double.toString(gMlbInnQty[30] - gMlbOutQty[30]));
				vo.setQty31(Double.toString(gMlbInnQty[31] - gMlbOutQty[31]));
				vo.setQty32(Double.toString(gMlbInnQty[32] - gMlbOutQty[32]));
				vo.setQty33(Double.toString(gMlbInnQty[33] - gMlbOutQty[33]));
				vo.setQty34(Double.toString(gMlbInnQty[34] - gMlbOutQty[34]));
				vo.setQty35(Double.toString(gMlbInnQty[35] - gMlbOutQty[35]));
				vo.setQty36(Double.toString(gMlbInnQty[36] - gMlbOutQty[36]));
				vo.setQty37(Double.toString(gMlbInnQty[37] - gMlbOutQty[37]));
				vo.setQty38(Double.toString(gMlbInnQty[38] - gMlbOutQty[38]));
				vo.setQty39(Double.toString(gMlbInnQty[39] - gMlbOutQty[39]));
				list2.add(x, vo);
				x++;

				for (int m = 0; m < gMlbInnQty.length; m++) {

					if (gMlbInnQty[m] >= gMlbOutQty[m]) {
						if (gMlbOutQty[m] > 0) {
							gTotallQty[m] = Math.round(gMlbOutQty[m] / gMlbInnQty[m] * 100);
						}
						else {
							gTotallQty[m] = 0;
						}
					}
					else if (gMlbOutQty[m] > 0) {
						gTotallQty[m] = Math.round((gMlbInnQty[m] / gMlbOutQty[m] * (-1)) * 100);
					}
					else {
						gTotallQty[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("Total");
				vo.setVvd("MLB");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(gTotallQty[40]));
				vo.setQty0(Double.toString(gTotallQty[0]));
				vo.setQty1(Double.toString(gTotallQty[1]));
				vo.setQty2(Double.toString(gTotallQty[2]));
				vo.setQty3(Double.toString(gTotallQty[3]));
				vo.setQty4(Double.toString(gTotallQty[4]));
				vo.setQty5(Double.toString(gTotallQty[5]));
				vo.setQty6(Double.toString(gTotallQty[6]));
				vo.setQty7(Double.toString(gTotallQty[7]));
				vo.setQty8(Double.toString(gTotallQty[8]));
				vo.setQty9(Double.toString(gTotallQty[9]));
				vo.setQty10(Double.toString(gTotallQty[10]));
				vo.setQty11(Double.toString(gTotallQty[11]));
				vo.setQty12(Double.toString(gTotallQty[12]));
				vo.setQty13(Double.toString(gTotallQty[13]));
				vo.setQty14(Double.toString(gTotallQty[14]));
				vo.setQty15(Double.toString(gTotallQty[15]));
				vo.setQty16(Double.toString(gTotallQty[16]));
				vo.setQty17(Double.toString(gTotallQty[17]));
				vo.setQty18(Double.toString(gTotallQty[18]));
				vo.setQty19(Double.toString(gTotallQty[19]));
				vo.setQty20(Double.toString(gTotallQty[20]));
				vo.setQty21(Double.toString(gTotallQty[21]));
				vo.setQty22(Double.toString(gTotallQty[22]));
				vo.setQty23(Double.toString(gTotallQty[23]));
				vo.setQty24(Double.toString(gTotallQty[24]));
				vo.setQty25(Double.toString(gTotallQty[25]));
				vo.setQty26(Double.toString(gTotallQty[26]));
				vo.setQty27(Double.toString(gTotallQty[27]));
				vo.setQty28(Double.toString(gTotallQty[28]));
				vo.setQty29(Double.toString(gTotallQty[29]));
				vo.setQty30(Double.toString(gTotallQty[30]));
				vo.setQty31(Double.toString(gTotallQty[31]));
				vo.setQty32(Double.toString(gTotallQty[32]));
				vo.setQty33(Double.toString(gTotallQty[33]));
				vo.setQty34(Double.toString(gTotallQty[34]));
				vo.setQty35(Double.toString(gTotallQty[35]));
				vo.setQty36(Double.toString(gTotallQty[36]));
				vo.setQty37(Double.toString(gTotallQty[37]));
				vo.setQty38(Double.toString(gTotallQty[38]));
				vo.setQty39(Double.toString(gTotallQty[39]));
				list2.add(x, vo);
				x++;

				// //////////////////MLB

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(gLocInnQty[40] + gIpiInnQty[40] + gMlbInnQty[40]));
				vo.setQty0(Double.toString(gLocInnQty[0] + gIpiInnQty[0] + gMlbInnQty[0]));
				vo.setQty1(Double.toString(gLocInnQty[1] + gIpiInnQty[1] + gMlbInnQty[1]));
				vo.setQty2(Double.toString(gLocInnQty[2] + gIpiInnQty[2] + gMlbInnQty[2]));
				vo.setQty3(Double.toString(gLocInnQty[3] + gIpiInnQty[3] + gMlbInnQty[3]));
				vo.setQty4(Double.toString(gLocInnQty[4] + gIpiInnQty[4] + gMlbInnQty[4]));
				vo.setQty5(Double.toString(gLocInnQty[5] + gIpiInnQty[5] + gMlbInnQty[5]));
				vo.setQty6(Double.toString(gLocInnQty[6] + gIpiInnQty[6] + gMlbInnQty[6]));
				vo.setQty7(Double.toString(gLocInnQty[7] + gIpiInnQty[7] + gMlbInnQty[7]));
				vo.setQty8(Double.toString(gLocInnQty[8] + gIpiInnQty[8] + gMlbInnQty[8]));
				vo.setQty9(Double.toString(gLocInnQty[9] + gIpiInnQty[9] + gMlbInnQty[9]));
				vo.setQty10(Double.toString(gLocInnQty[10] + gIpiInnQty[10] + gMlbInnQty[10]));
				vo.setQty11(Double.toString(gLocInnQty[11] + gIpiInnQty[11] + gMlbInnQty[11]));
				vo.setQty12(Double.toString(gLocInnQty[12] + gIpiInnQty[12] + gMlbInnQty[12]));
				vo.setQty13(Double.toString(gLocInnQty[13] + gIpiInnQty[13] + gMlbInnQty[13]));
				vo.setQty14(Double.toString(gLocInnQty[14] + gIpiInnQty[14] + gMlbInnQty[14]));
				vo.setQty15(Double.toString(gLocInnQty[15] + gIpiInnQty[15] + gMlbInnQty[15]));
				vo.setQty16(Double.toString(gLocInnQty[16] + gIpiInnQty[16] + gMlbInnQty[16]));
				vo.setQty17(Double.toString(gLocInnQty[17] + gIpiInnQty[17] + gMlbInnQty[17]));
				vo.setQty18(Double.toString(gLocInnQty[18] + gIpiInnQty[18] + gMlbInnQty[18]));
				vo.setQty19(Double.toString(gLocInnQty[19] + gIpiInnQty[19] + gMlbInnQty[19]));
				vo.setQty20(Double.toString(gLocInnQty[20] + gIpiInnQty[20] + gMlbInnQty[20]));
				vo.setQty21(Double.toString(gLocInnQty[21] + gIpiInnQty[21] + gMlbInnQty[21]));
				vo.setQty22(Double.toString(gLocInnQty[22] + gIpiInnQty[22] + gMlbInnQty[22]));
				vo.setQty23(Double.toString(gLocInnQty[23] + gIpiInnQty[23] + gMlbInnQty[23]));
				vo.setQty24(Double.toString(gLocInnQty[24] + gIpiInnQty[24] + gMlbInnQty[24]));
				vo.setQty25(Double.toString(gLocInnQty[25] + gIpiInnQty[25] + gMlbInnQty[25]));
				vo.setQty26(Double.toString(gLocInnQty[26] + gIpiInnQty[26] + gMlbInnQty[26]));
				vo.setQty27(Double.toString(gLocInnQty[27] + gIpiInnQty[27] + gMlbInnQty[27]));
				vo.setQty28(Double.toString(gLocInnQty[28] + gIpiInnQty[28] + gMlbInnQty[28]));
				vo.setQty29(Double.toString(gLocInnQty[29] + gIpiInnQty[29] + gMlbInnQty[29]));
				vo.setQty30(Double.toString(gLocInnQty[30] + gIpiInnQty[30] + gMlbInnQty[30]));
				vo.setQty31(Double.toString(gLocInnQty[31] + gIpiInnQty[31] + gMlbInnQty[31]));
				vo.setQty32(Double.toString(gLocInnQty[32] + gIpiInnQty[32] + gMlbInnQty[32]));
				vo.setQty33(Double.toString(gLocInnQty[33] + gIpiInnQty[33] + gMlbInnQty[33]));
				vo.setQty34(Double.toString(gLocInnQty[34] + gIpiInnQty[34] + gMlbInnQty[34]));
				vo.setQty35(Double.toString(gLocInnQty[35] + gIpiInnQty[35] + gMlbInnQty[35]));
				vo.setQty36(Double.toString(gLocInnQty[36] + gIpiInnQty[36] + gMlbInnQty[36]));
				vo.setQty37(Double.toString(gLocInnQty[37] + gIpiInnQty[37] + gMlbInnQty[37]));
				vo.setQty38(Double.toString(gLocInnQty[38] + gIpiInnQty[38] + gMlbInnQty[38]));
				vo.setQty39(Double.toString(gLocInnQty[39] + gIpiInnQty[39] + gMlbInnQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(gLocOutQty[40] + gIpiOutQty[40] + gMlbOutQty[40]));
				vo.setQty0(Double.toString(gLocOutQty[0] + gIpiOutQty[0] + gMlbOutQty[0]));
				vo.setQty1(Double.toString(gLocOutQty[1] + gIpiOutQty[1] + gMlbOutQty[1]));
				vo.setQty2(Double.toString(gLocOutQty[2] + gIpiOutQty[2] + gMlbOutQty[2]));
				vo.setQty3(Double.toString(gLocOutQty[3] + gIpiOutQty[3] + gMlbOutQty[3]));
				vo.setQty4(Double.toString(gLocOutQty[4] + gIpiOutQty[4] + gMlbOutQty[4]));
				vo.setQty5(Double.toString(gLocOutQty[5] + gIpiOutQty[5] + gMlbOutQty[5]));
				vo.setQty6(Double.toString(gLocOutQty[6] + gIpiOutQty[6] + gMlbOutQty[6]));
				vo.setQty7(Double.toString(gLocOutQty[7] + gIpiOutQty[7] + gMlbOutQty[7]));
				vo.setQty8(Double.toString(gLocOutQty[8] + gIpiOutQty[8] + gMlbOutQty[8]));
				vo.setQty9(Double.toString(gLocOutQty[9] + gIpiOutQty[9] + gMlbOutQty[9]));
				vo.setQty10(Double.toString(gLocOutQty[10] + gIpiOutQty[10] + gMlbOutQty[10]));
				vo.setQty11(Double.toString(gLocOutQty[11] + gIpiOutQty[11] + gMlbOutQty[11]));
				vo.setQty12(Double.toString(gLocOutQty[12] + gIpiOutQty[12] + gMlbOutQty[12]));
				vo.setQty13(Double.toString(gLocOutQty[13] + gIpiOutQty[13] + gMlbOutQty[13]));
				vo.setQty14(Double.toString(gLocOutQty[14] + gIpiOutQty[14] + gMlbOutQty[14]));
				vo.setQty15(Double.toString(gLocOutQty[15] + gIpiOutQty[15] + gMlbOutQty[15]));
				vo.setQty16(Double.toString(gLocOutQty[16] + gIpiOutQty[16] + gMlbOutQty[16]));
				vo.setQty17(Double.toString(gLocOutQty[17] + gIpiOutQty[17] + gMlbOutQty[17]));
				vo.setQty18(Double.toString(gLocOutQty[18] + gIpiOutQty[18] + gMlbOutQty[18]));
				vo.setQty19(Double.toString(gLocOutQty[19] + gIpiOutQty[19] + gMlbOutQty[19]));
				vo.setQty20(Double.toString(gLocOutQty[20] + gIpiOutQty[20] + gMlbOutQty[20]));
				vo.setQty21(Double.toString(gLocOutQty[21] + gIpiOutQty[21] + gMlbOutQty[21]));
				vo.setQty22(Double.toString(gLocOutQty[22] + gIpiOutQty[22] + gMlbOutQty[22]));
				vo.setQty23(Double.toString(gLocOutQty[23] + gIpiOutQty[23] + gMlbOutQty[23]));
				vo.setQty24(Double.toString(gLocOutQty[24] + gIpiOutQty[24] + gMlbOutQty[24]));
				vo.setQty25(Double.toString(gLocOutQty[25] + gIpiOutQty[25] + gMlbOutQty[25]));
				vo.setQty26(Double.toString(gLocOutQty[26] + gIpiOutQty[26] + gMlbOutQty[26]));
				vo.setQty27(Double.toString(gLocOutQty[27] + gIpiOutQty[27] + gMlbOutQty[27]));
				vo.setQty28(Double.toString(gLocOutQty[28] + gIpiOutQty[28] + gMlbOutQty[28]));
				vo.setQty29(Double.toString(gLocOutQty[29] + gIpiOutQty[29] + gMlbOutQty[29]));
				vo.setQty30(Double.toString(gLocOutQty[30] + gIpiOutQty[30] + gMlbOutQty[30]));
				vo.setQty31(Double.toString(gLocOutQty[31] + gIpiOutQty[31] + gMlbOutQty[31]));
				vo.setQty32(Double.toString(gLocOutQty[32] + gIpiOutQty[32] + gMlbOutQty[32]));
				vo.setQty33(Double.toString(gLocOutQty[33] + gIpiOutQty[33] + gMlbOutQty[33]));
				vo.setQty34(Double.toString(gLocOutQty[34] + gIpiOutQty[34] + gMlbOutQty[34]));
				vo.setQty35(Double.toString(gLocOutQty[35] + gIpiOutQty[35] + gMlbOutQty[35]));
				vo.setQty36(Double.toString(gLocOutQty[36] + gIpiOutQty[36] + gMlbOutQty[36]));
				vo.setQty37(Double.toString(gLocOutQty[37] + gIpiOutQty[37] + gMlbOutQty[37]));
				vo.setQty38(Double.toString(gLocOutQty[38] + gIpiOutQty[38] + gMlbOutQty[38]));
				vo.setQty39(Double.toString(gLocOutQty[39] + gIpiOutQty[39] + gMlbOutQty[39]));
				list2.add(x, vo);
				x++;

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString((gLocInnQty[40] + gIpiInnQty[40] + gMlbInnQty[40])
						- (gLocOutQty[40] + gIpiOutQty[40] + gMlbOutQty[40])));
				vo.setQty0(Double.toString((gLocInnQty[0] + gIpiInnQty[0] + gMlbInnQty[0])
						- (gLocOutQty[0] + gIpiOutQty[0] + gMlbOutQty[0])));
				vo.setQty1(Double.toString((gLocInnQty[1] + gIpiInnQty[1] + gMlbInnQty[1])
						- (gLocOutQty[1] + gIpiOutQty[1] + gMlbOutQty[1])));
				vo.setQty2(Double.toString((gLocInnQty[2] + gIpiInnQty[2] + gMlbInnQty[2])
						- (gLocOutQty[2] + gIpiOutQty[2] + gMlbOutQty[2])));
				vo.setQty3(Double.toString((gLocInnQty[3] + gIpiInnQty[3] + gMlbInnQty[3])
						- (gLocOutQty[3] + gIpiOutQty[3] + gMlbOutQty[3])));
				vo.setQty4(Double.toString((gLocInnQty[4] + gIpiInnQty[4] + gMlbInnQty[4])
						- (gLocOutQty[4] + gIpiOutQty[4] + gMlbOutQty[4])));
				vo.setQty5(Double.toString((gLocInnQty[5] + gIpiInnQty[5] + gMlbInnQty[5])
						- (gLocOutQty[5] + gIpiOutQty[5] + gMlbOutQty[5])));
				vo.setQty6(Double.toString((gLocInnQty[6] + gIpiInnQty[6] + gMlbInnQty[6])
						- (gLocOutQty[6] + gIpiOutQty[6] + gMlbOutQty[6])));
				vo.setQty7(Double.toString((gLocInnQty[7] + gIpiInnQty[7] + gMlbInnQty[7])
						- (gLocOutQty[7] + gIpiOutQty[7] + gMlbOutQty[7])));
				vo.setQty8(Double.toString((gLocInnQty[8] + gIpiInnQty[8] + gMlbInnQty[8])
						- (gLocOutQty[8] + gIpiOutQty[8] + gMlbOutQty[8])));
				vo.setQty9(Double.toString((gLocInnQty[9] + gIpiInnQty[9] + gMlbInnQty[9])
						- (gLocOutQty[9] + gIpiOutQty[9] + gMlbOutQty[9])));
				vo.setQty10(Double.toString((gLocInnQty[10] + gIpiInnQty[10] + gMlbInnQty[10])
						- (gLocOutQty[10] + gIpiOutQty[10] + gMlbOutQty[10])));
				vo.setQty11(Double.toString((gLocInnQty[11] + gIpiInnQty[11] + gMlbInnQty[11])
						- (gLocOutQty[11] + gIpiOutQty[11] + gMlbOutQty[11])));
				vo.setQty12(Double.toString((gLocInnQty[12] + gIpiInnQty[12] + gMlbInnQty[12])
						- (gLocOutQty[12] + gIpiOutQty[12] + gMlbOutQty[12])));
				vo.setQty13(Double.toString((gLocInnQty[13] + gIpiInnQty[13] + gMlbInnQty[13])
						- (gLocOutQty[13] + gIpiOutQty[13] + gMlbOutQty[13])));
				vo.setQty14(Double.toString((gLocInnQty[14] + gIpiInnQty[14] + gMlbInnQty[14])
						- (gLocOutQty[14] + gIpiOutQty[14] + gMlbOutQty[14])));
				vo.setQty15(Double.toString((gLocInnQty[15] + gIpiInnQty[15] + gMlbInnQty[15])
						- (gLocOutQty[15] + gIpiOutQty[15] + gMlbOutQty[15])));
				vo.setQty16(Double.toString((gLocInnQty[16] + gIpiInnQty[16] + gMlbInnQty[16])
						- (gLocOutQty[16] + gIpiOutQty[16] + gMlbOutQty[16])));
				vo.setQty17(Double.toString((gLocInnQty[17] + gIpiInnQty[17] + gMlbInnQty[17])
						- (gLocOutQty[17] + gIpiOutQty[17] + gMlbOutQty[17])));
				vo.setQty18(Double.toString((gLocInnQty[18] + gIpiInnQty[18] + gMlbInnQty[18])
						- (gLocOutQty[18] + gIpiOutQty[18] + gMlbOutQty[18])));
				vo.setQty19(Double.toString((gLocInnQty[19] + gIpiInnQty[19] + gMlbInnQty[19])
						- (gLocOutQty[19] + gIpiOutQty[19] + gMlbOutQty[19])));
				vo.setQty20(Double.toString((gLocInnQty[20] + gIpiInnQty[20] + gMlbInnQty[20])
						- (gLocOutQty[20] + gIpiOutQty[20] + gMlbOutQty[20])));
				vo.setQty21(Double.toString((gLocInnQty[21] + gIpiInnQty[21] + gMlbInnQty[21])
						- (gLocOutQty[21] + gIpiOutQty[21] + gMlbOutQty[21])));
				vo.setQty22(Double.toString((gLocInnQty[22] + gIpiInnQty[22] + gMlbInnQty[22])
						- (gLocOutQty[22] + gIpiOutQty[22] + gMlbOutQty[22])));
				vo.setQty23(Double.toString((gLocInnQty[23] + gIpiInnQty[23] + gMlbInnQty[23])
						- (gLocOutQty[23] + gIpiOutQty[23] + gMlbOutQty[23])));
				vo.setQty24(Double.toString((gLocInnQty[24] + gIpiInnQty[24] + gMlbInnQty[24])
						- (gLocOutQty[24] + gIpiOutQty[24] + gMlbOutQty[24])));
				vo.setQty25(Double.toString((gLocInnQty[25] + gIpiInnQty[25] + gMlbInnQty[25])
						- (gLocOutQty[25] + gIpiOutQty[25] + gMlbOutQty[25])));
				vo.setQty26(Double.toString((gLocInnQty[26] + gIpiInnQty[26] + gMlbInnQty[26])
						- (gLocOutQty[26] + gIpiOutQty[26] + gMlbOutQty[26])));
				vo.setQty27(Double.toString((gLocInnQty[27] + gIpiInnQty[27] + gMlbInnQty[27])
						- (gLocOutQty[27] + gIpiOutQty[27] + gMlbOutQty[27])));
				vo.setQty28(Double.toString((gLocInnQty[28] + gIpiInnQty[28] + gMlbInnQty[28])
						- (gLocOutQty[28] + gIpiOutQty[28] + gMlbOutQty[28])));
				vo.setQty29(Double.toString((gLocInnQty[29] + gIpiInnQty[29] + gMlbInnQty[29])
						- (gLocOutQty[29] + gIpiOutQty[29] + gMlbOutQty[29])));
				vo.setQty30(Double.toString((gLocInnQty[30] + gIpiInnQty[30] + gMlbInnQty[30])
						- (gLocOutQty[30] + gIpiOutQty[30] + gMlbOutQty[30])));
				vo.setQty31(Double.toString((gLocInnQty[31] + gIpiInnQty[31] + gMlbInnQty[31])
						- (gLocOutQty[31] + gIpiOutQty[31] + gMlbOutQty[31])));
				vo.setQty32(Double.toString((gLocInnQty[32] + gIpiInnQty[32] + gMlbInnQty[32])
						- (gLocOutQty[32] + gIpiOutQty[32] + gMlbOutQty[32])));
				vo.setQty33(Double.toString((gLocInnQty[33] + gIpiInnQty[33] + gMlbInnQty[33])
						- (gLocOutQty[33] + gIpiOutQty[33] + gMlbOutQty[33])));
				vo.setQty34(Double.toString((gLocInnQty[34] + gIpiInnQty[34] + gMlbInnQty[34])
						- (gLocOutQty[34] + gIpiOutQty[34] + gMlbOutQty[34])));
				vo.setQty35(Double.toString((gLocInnQty[35] + gIpiInnQty[35] + gMlbInnQty[35])
						- (gLocOutQty[35] + gIpiOutQty[35] + gMlbOutQty[35])));
				vo.setQty36(Double.toString((gLocInnQty[36] + gIpiInnQty[36] + gMlbInnQty[36])
						- (gLocOutQty[36] + gIpiOutQty[36] + gMlbOutQty[36])));
				vo.setQty37(Double.toString((gLocInnQty[37] + gIpiInnQty[37] + gMlbInnQty[37])
						- (gLocOutQty[37] + gIpiOutQty[37] + gMlbOutQty[37])));
				vo.setQty38(Double.toString((gLocInnQty[38] + gIpiInnQty[38] + gMlbInnQty[38])
						- (gLocOutQty[38] + gIpiOutQty[38] + gMlbOutQty[38])));
				vo.setQty39(Double.toString((gLocInnQty[39] + gIpiInnQty[39] + gMlbInnQty[39])
						- (gLocOutQty[39] + gIpiOutQty[39] + gMlbOutQty[39])));
				list2.add(x, vo);
				x++;

				for (int m = 0; m < gLocInnQty.length; m++) {

					if ((gLocInnQty[m] + gIpiInnQty[m] + gMlbInnQty[m]) >= (gLocOutQty[m] + gIpiOutQty[m] + gMlbOutQty[m])) {
						if ((gLocOutQty[m] + gIpiOutQty[m] + gMlbOutQty[m]) > 0) {
							gTotallQty[m] = Math.round((gLocOutQty[m] + gIpiOutQty[m] + gMlbOutQty[m])
									/ (gLocInnQty[m] + gIpiInnQty[m] + gMlbInnQty[m]) * 100);
						}
						else {
							gTotallQty[m] = 0;
						}
					}
					else if ((gLocOutQty[m] + gIpiOutQty[m] + gMlbOutQty[m]) > 0) {
						gTotallQty[m] = Math.round(((gLocInnQty[m] + gIpiInnQty[m] + gMlbInnQty[m])
								/ (gLocOutQty[m] + gIpiOutQty[m] + gMlbOutQty[m]) * (-1)) * 100);
					}
					else {
						gTotallQty[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(gTotallQty[40]));
				vo.setQty0(Double.toString(gTotallQty[0]));
				vo.setQty1(Double.toString(gTotallQty[1]));
				vo.setQty2(Double.toString(gTotallQty[2]));
				vo.setQty3(Double.toString(gTotallQty[3]));
				vo.setQty4(Double.toString(gTotallQty[4]));
				vo.setQty5(Double.toString(gTotallQty[5]));
				vo.setQty6(Double.toString(gTotallQty[6]));
				vo.setQty7(Double.toString(gTotallQty[7]));
				vo.setQty8(Double.toString(gTotallQty[8]));
				vo.setQty9(Double.toString(gTotallQty[9]));
				vo.setQty10(Double.toString(gTotallQty[10]));
				vo.setQty11(Double.toString(gTotallQty[11]));
				vo.setQty12(Double.toString(gTotallQty[12]));
				vo.setQty13(Double.toString(gTotallQty[13]));
				vo.setQty14(Double.toString(gTotallQty[14]));
				vo.setQty15(Double.toString(gTotallQty[15]));
				vo.setQty16(Double.toString(gTotallQty[16]));
				vo.setQty17(Double.toString(gTotallQty[17]));
				vo.setQty18(Double.toString(gTotallQty[18]));
				vo.setQty19(Double.toString(gTotallQty[19]));
				vo.setQty20(Double.toString(gTotallQty[20]));
				vo.setQty21(Double.toString(gTotallQty[21]));
				vo.setQty22(Double.toString(gTotallQty[22]));
				vo.setQty23(Double.toString(gTotallQty[23]));
				vo.setQty24(Double.toString(gTotallQty[24]));
				vo.setQty25(Double.toString(gTotallQty[25]));
				vo.setQty26(Double.toString(gTotallQty[26]));
				vo.setQty27(Double.toString(gTotallQty[27]));
				vo.setQty28(Double.toString(gTotallQty[28]));
				vo.setQty29(Double.toString(gTotallQty[29]));
				vo.setQty30(Double.toString(gTotallQty[30]));
				vo.setQty31(Double.toString(gTotallQty[31]));
				vo.setQty32(Double.toString(gTotallQty[32]));
				vo.setQty33(Double.toString(gTotallQty[33]));
				vo.setQty34(Double.toString(gTotallQty[34]));
				vo.setQty35(Double.toString(gTotallQty[35]));
				vo.setQty36(Double.toString(gTotallQty[36]));
				vo.setQty37(Double.toString(gTotallQty[37]));
				vo.setQty38(Double.toString(gTotallQty[38]));
				vo.setQty39(Double.toString(gTotallQty[39]));
				list2.add(x, vo);
				x++;

			}

			//log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtBC.searchMBByServiceMode End");
			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Service Mode Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Service Mode Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Location Booking MatchBack] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInSummary(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseInSummary 1027 Start");
		try {
			List<QuantityByTypeSizeVO> list = dbDao.searchLocationMBByBKGWiseInDetail(mBSearchOptionInGereralVO);

			double[] inQty = new double[41];

			double[] outQty = new double[41];

			double[] mbQty = new double[41];

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>();
			QuantityByTypeSizeVO vo = null;
			QuantityByTypeSizeVO vo2 = null;
			int x = 0;

			int lastRNo = 0;
			lastRNo = list.size() - 1;
		//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseInSummary lastRNo [" + lastRNo+ "]");
			if (x == 0) {

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(list.get(lastRNo).getLocCd());
				vo.setTotal(list.get(lastRNo).getTotal());
				vo.setQty0(list.get(lastRNo).getQty0());
				vo.setQty1(list.get(lastRNo).getQty1());
				vo.setQty2(list.get(lastRNo).getQty2());
				vo.setQty3(list.get(lastRNo).getQty3());
				vo.setQty4(list.get(lastRNo).getQty4());
				vo.setQty5(list.get(lastRNo).getQty5());
				vo.setQty6(list.get(lastRNo).getQty6());
				vo.setQty7(list.get(lastRNo).getQty7());
				vo.setQty8(list.get(lastRNo).getQty8());
				vo.setQty9(list.get(lastRNo).getQty9());
				vo.setQty10(list.get(lastRNo).getQty10());
				vo.setQty11(list.get(lastRNo).getQty11());
				vo.setQty12(list.get(lastRNo).getQty12());
				vo.setQty13(list.get(lastRNo).getQty13());
				vo.setQty14(list.get(lastRNo).getQty14());
				vo.setQty15(list.get(lastRNo).getQty15());
				vo.setQty16(list.get(lastRNo).getQty16());
				vo.setQty17(list.get(lastRNo).getQty17());
				vo.setQty18(list.get(lastRNo).getQty18());
				vo.setQty19(list.get(lastRNo).getQty19());
				vo.setQty20(list.get(lastRNo).getQty20());
				vo.setQty21(list.get(lastRNo).getQty21());
				vo.setQty22(list.get(lastRNo).getQty22());
				vo.setQty23(list.get(lastRNo).getQty23());
				vo.setQty24(list.get(lastRNo).getQty24());
				vo.setQty25(list.get(lastRNo).getQty25());
				vo.setQty26(list.get(lastRNo).getQty26());
				vo.setQty27(list.get(lastRNo).getQty27());
				vo.setQty28(list.get(lastRNo).getQty28());
				vo.setQty29(list.get(lastRNo).getQty29());
				vo.setQty30(list.get(lastRNo).getQty30());
				vo.setQty31(list.get(lastRNo).getQty31());
				vo.setQty32(list.get(lastRNo).getQty32());
				vo.setQty33(list.get(lastRNo).getQty33());
				vo.setQty34(list.get(lastRNo).getQty34());
				vo.setQty35(list.get(lastRNo).getQty35());
				vo.setQty36(list.get(lastRNo).getQty36());
				vo.setQty37(list.get(lastRNo).getQty37());
				vo.setQty38(list.get(lastRNo).getQty38());
				vo.setQty39(list.get(lastRNo).getQty39());
				list2.add(x, vo);
				x++;
			}

			for (int i = 0; i < lastRNo; i++) {
				int k = 0;

				// String strYardCd = list.get(i).getYardCd();
				// String strLocCd = list.get(i).getLocCd();
				String strDivision = list.get(i).getDivision();

				if (strDivision.equals("M/B(%)")) {
					k = 3;
				}

				if (strDivision.equals("M/B(%)")) {
					vo = new QuantityByTypeSizeVO();

					vo.setLocCd(list.get(i).getLocCd());
					// vo.setYardCd(list.get(i).getYardCd());
					vo.setTotal(list.get(i).getTotal());

					vo.setQty0(list.get(i).getQty0());
					vo.setQty1(list.get(i).getQty1());
					vo.setQty2(list.get(i).getQty2());
					vo.setQty3(list.get(i).getQty3());
					vo.setQty4(list.get(i).getQty4());
					vo.setQty5(list.get(i).getQty5());
					vo.setQty6(list.get(i).getQty6());
					vo.setQty7(list.get(i).getQty7());
					vo.setQty8(list.get(i).getQty8());
					vo.setQty9(list.get(i).getQty9());
					vo.setQty10(list.get(i).getQty10());
					vo.setQty11(list.get(i).getQty11());
					vo.setQty12(list.get(i).getQty12());
					vo.setQty13(list.get(i).getQty13());
					vo.setQty14(list.get(i).getQty14());
					vo.setQty15(list.get(i).getQty15());
					vo.setQty16(list.get(i).getQty16());
					vo.setQty17(list.get(i).getQty17());
					vo.setQty18(list.get(i).getQty18());
					vo.setQty19(list.get(i).getQty19());
					vo.setQty20(list.get(i).getQty20());
					vo.setQty21(list.get(i).getQty21());
					vo.setQty22(list.get(i).getQty22());
					vo.setQty23(list.get(i).getQty23());
					vo.setQty24(list.get(i).getQty24());
					vo.setQty25(list.get(i).getQty25());
					vo.setQty26(list.get(i).getQty26());
					vo.setQty27(list.get(i).getQty27());
					vo.setQty28(list.get(i).getQty28());
					vo.setQty29(list.get(i).getQty29());
					vo.setQty30(list.get(i).getQty30());
					vo.setQty31(list.get(i).getQty31());
					vo.setQty32(list.get(i).getQty32());
					vo.setQty33(list.get(i).getQty33());
					vo.setQty34(list.get(i).getQty34());
					vo.setQty35(list.get(i).getQty35());
					vo.setQty36(list.get(i).getQty36());
					vo.setQty37(list.get(i).getQty37());
					vo.setQty38(list.get(i).getQty38());
					vo.setQty39(list.get(i).getQty39());
					list2.add(x, vo);
					x++;

					inQty[0] = Double.parseDouble(list.get(i - k).getQty0()) + inQty[0];
					inQty[1] = Double.parseDouble(list.get(i - k).getQty1()) + inQty[1];
					inQty[2] = Double.parseDouble(list.get(i - k).getQty2()) + inQty[2];
					inQty[3] = Double.parseDouble(list.get(i - k).getQty3()) + inQty[3];
					inQty[4] = Double.parseDouble(list.get(i - k).getQty4()) + inQty[4];
					inQty[5] = Double.parseDouble(list.get(i - k).getQty5()) + inQty[5];
					inQty[6] = Double.parseDouble(list.get(i - k).getQty6()) + inQty[6];
					inQty[7] = Double.parseDouble(list.get(i - k).getQty7()) + inQty[7];
					inQty[8] = Double.parseDouble(list.get(i - k).getQty8()) + inQty[8];
					inQty[9] = Double.parseDouble(list.get(i - k).getQty9()) + inQty[9];
					inQty[10] = Double.parseDouble(list.get(i - k).getQty10()) + inQty[10];
					inQty[11] = Double.parseDouble(list.get(i - k).getQty11()) + inQty[11];
					inQty[12] = Double.parseDouble(list.get(i - k).getQty12()) + inQty[12];
					inQty[13] = Double.parseDouble(list.get(i - k).getQty13()) + inQty[13];
					inQty[14] = Double.parseDouble(list.get(i - k).getQty14()) + inQty[14];
					inQty[15] = Double.parseDouble(list.get(i - k).getQty15()) + inQty[15];
					inQty[16] = Double.parseDouble(list.get(i - k).getQty16()) + inQty[16];
					inQty[17] = Double.parseDouble(list.get(i - k).getQty17()) + inQty[17];
					inQty[18] = Double.parseDouble(list.get(i - k).getQty18()) + inQty[18];
					inQty[19] = Double.parseDouble(list.get(i - k).getQty19()) + inQty[19];
					inQty[20] = Double.parseDouble(list.get(i - k).getQty20()) + inQty[20];
					inQty[21] = Double.parseDouble(list.get(i - k).getQty21()) + inQty[21];
					inQty[22] = Double.parseDouble(list.get(i - k).getQty22()) + inQty[22];
					inQty[23] = Double.parseDouble(list.get(i - k).getQty23()) + inQty[23];
					inQty[24] = Double.parseDouble(list.get(i - k).getQty24()) + inQty[24];
					inQty[25] = Double.parseDouble(list.get(i - k).getQty25()) + inQty[25];
					inQty[26] = Double.parseDouble(list.get(i - k).getQty26()) + inQty[26];
					inQty[27] = Double.parseDouble(list.get(i - k).getQty27()) + inQty[27];
					inQty[28] = Double.parseDouble(list.get(i - k).getQty28()) + inQty[28];
					inQty[29] = Double.parseDouble(list.get(i - k).getQty29()) + inQty[29];
					inQty[30] = Double.parseDouble(list.get(i - k).getQty30()) + inQty[30];
					inQty[31] = Double.parseDouble(list.get(i - k).getQty31()) + inQty[31];
					inQty[32] = Double.parseDouble(list.get(i - k).getQty32()) + inQty[32];
					inQty[33] = Double.parseDouble(list.get(i - k).getQty33()) + inQty[33];
					inQty[34] = Double.parseDouble(list.get(i - k).getQty34()) + inQty[34];
					inQty[35] = Double.parseDouble(list.get(i - k).getQty35()) + inQty[35];
					inQty[36] = Double.parseDouble(list.get(i - k).getQty36()) + inQty[36];
					inQty[37] = Double.parseDouble(list.get(i - k).getQty37()) + inQty[37];
					inQty[38] = Double.parseDouble(list.get(i - k).getQty38()) + inQty[38];
					inQty[39] = Double.parseDouble(list.get(i - k).getQty39()) + inQty[39];
					inQty[40] = Double.parseDouble(list.get(i - k).getTotal()) + inQty[40];

					outQty[0] = Double.parseDouble(list.get(i - (k - 1)).getQty0()) + outQty[0];
					outQty[1] = Double.parseDouble(list.get(i - (k - 1)).getQty1()) + outQty[1];
					outQty[2] = Double.parseDouble(list.get(i - (k - 1)).getQty2()) + outQty[2];
					outQty[3] = Double.parseDouble(list.get(i - (k - 1)).getQty3()) + outQty[3];
					outQty[4] = Double.parseDouble(list.get(i - (k - 1)).getQty4()) + outQty[4];
					outQty[5] = Double.parseDouble(list.get(i - (k - 1)).getQty5()) + outQty[5];
					outQty[6] = Double.parseDouble(list.get(i - (k - 1)).getQty6()) + outQty[6];
					outQty[7] = Double.parseDouble(list.get(i - (k - 1)).getQty7()) + outQty[7];
					outQty[8] = Double.parseDouble(list.get(i - (k - 1)).getQty8()) + outQty[8];
					outQty[9] = Double.parseDouble(list.get(i - (k - 1)).getQty9()) + outQty[9];
					outQty[10] = Double.parseDouble(list.get(i - (k - 1)).getQty10()) + outQty[10];
					outQty[11] = Double.parseDouble(list.get(i - (k - 1)).getQty11()) + outQty[11];
					outQty[12] = Double.parseDouble(list.get(i - (k - 1)).getQty12()) + outQty[12];
					outQty[13] = Double.parseDouble(list.get(i - (k - 1)).getQty13()) + outQty[13];
					outQty[14] = Double.parseDouble(list.get(i - (k - 1)).getQty14()) + outQty[14];
					outQty[15] = Double.parseDouble(list.get(i - (k - 1)).getQty15()) + outQty[15];
					outQty[16] = Double.parseDouble(list.get(i - (k - 1)).getQty16()) + outQty[16];
					outQty[17] = Double.parseDouble(list.get(i - (k - 1)).getQty17()) + outQty[17];
					outQty[18] = Double.parseDouble(list.get(i - (k - 1)).getQty18()) + outQty[18];
					outQty[19] = Double.parseDouble(list.get(i - (k - 1)).getQty19()) + outQty[19];
					outQty[20] = Double.parseDouble(list.get(i - (k - 1)).getQty20()) + outQty[20];
					outQty[21] = Double.parseDouble(list.get(i - (k - 1)).getQty21()) + outQty[21];
					outQty[22] = Double.parseDouble(list.get(i - (k - 1)).getQty22()) + outQty[22];
					outQty[23] = Double.parseDouble(list.get(i - (k - 1)).getQty23()) + outQty[23];
					outQty[24] = Double.parseDouble(list.get(i - (k - 1)).getQty24()) + outQty[24];
					outQty[25] = Double.parseDouble(list.get(i - (k - 1)).getQty25()) + outQty[25];
					outQty[26] = Double.parseDouble(list.get(i - (k - 1)).getQty26()) + outQty[26];
					outQty[27] = Double.parseDouble(list.get(i - (k - 1)).getQty27()) + outQty[27];
					outQty[28] = Double.parseDouble(list.get(i - (k - 1)).getQty28()) + outQty[28];
					outQty[29] = Double.parseDouble(list.get(i - (k - 1)).getQty29()) + outQty[29];
					outQty[30] = Double.parseDouble(list.get(i - (k - 1)).getQty30()) + outQty[30];
					outQty[31] = Double.parseDouble(list.get(i - (k - 1)).getQty31()) + outQty[31];
					outQty[32] = Double.parseDouble(list.get(i - (k - 1)).getQty32()) + outQty[32];
					outQty[33] = Double.parseDouble(list.get(i - (k - 1)).getQty33()) + outQty[33];
					outQty[34] = Double.parseDouble(list.get(i - (k - 1)).getQty34()) + outQty[34];
					outQty[35] = Double.parseDouble(list.get(i - (k - 1)).getQty35()) + outQty[35];
					outQty[36] = Double.parseDouble(list.get(i - (k - 1)).getQty36()) + outQty[36];
					outQty[37] = Double.parseDouble(list.get(i - (k - 1)).getQty37()) + outQty[37];
					outQty[38] = Double.parseDouble(list.get(i - (k - 1)).getQty38()) + outQty[38];
					outQty[39] = Double.parseDouble(list.get(i - (k - 1)).getQty39()) + outQty[39];
					outQty[40] = Double.parseDouble(list.get(i - (k - 1)).getTotal()) + outQty[40];

				}
			}
			for (int m = 0; m < outQty.length; m++) {

				if (inQty[m] >= outQty[m]) {
					if (outQty[m] > 0) {
						mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
					}
					else {
						mbQty[m] = 0;
					}
				}
				else if (outQty[m] > 0) {
					mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
				}
				else {
					mbQty[m] = 0;
				}
			}
			vo2 = new QuantityByTypeSizeVO();
			vo2.setTotal(Double.toString(mbQty[40]));
			vo2.setQty0(Double.toString(mbQty[0]));
			vo2.setQty1(Double.toString(mbQty[1]));
			vo2.setQty2(Double.toString(mbQty[2]));
			vo2.setQty3(Double.toString(mbQty[3]));
			vo2.setQty4(Double.toString(mbQty[4]));
			vo2.setQty5(Double.toString(mbQty[5]));
			vo2.setQty6(Double.toString(mbQty[6]));
			vo2.setQty7(Double.toString(mbQty[7]));
			vo2.setQty8(Double.toString(mbQty[8]));
			vo2.setQty9(Double.toString(mbQty[9]));
			vo2.setQty10(Double.toString(mbQty[10]));
			vo2.setQty11(Double.toString(mbQty[11]));
			vo2.setQty12(Double.toString(mbQty[12]));
			vo2.setQty13(Double.toString(mbQty[13]));
			vo2.setQty14(Double.toString(mbQty[14]));
			vo2.setQty15(Double.toString(mbQty[15]));
			vo2.setQty16(Double.toString(mbQty[16]));
			vo2.setQty17(Double.toString(mbQty[17]));
			vo2.setQty18(Double.toString(mbQty[18]));
			vo2.setQty19(Double.toString(mbQty[19]));
			vo2.setQty20(Double.toString(mbQty[20]));
			vo2.setQty21(Double.toString(mbQty[21]));
			vo2.setQty22(Double.toString(mbQty[22]));
			vo2.setQty23(Double.toString(mbQty[23]));
			vo2.setQty24(Double.toString(mbQty[24]));
			vo2.setQty25(Double.toString(mbQty[25]));
			vo2.setQty26(Double.toString(mbQty[26]));
			vo2.setQty27(Double.toString(mbQty[27]));
			vo2.setQty28(Double.toString(mbQty[28]));
			vo2.setQty29(Double.toString(mbQty[29]));
			vo2.setQty30(Double.toString(mbQty[30]));
			vo2.setQty31(Double.toString(mbQty[31]));
			vo2.setQty32(Double.toString(mbQty[32]));
			vo2.setQty33(Double.toString(mbQty[33]));
			vo2.setQty34(Double.toString(mbQty[34]));
			vo2.setQty35(Double.toString(mbQty[35]));
			vo2.setQty36(Double.toString(mbQty[36]));
			vo2.setQty37(Double.toString(mbQty[37]));
			vo2.setQty38(Double.toString(mbQty[38]));
			vo2.setQty39(Double.toString(mbQty[39]));
			list2.add(x, vo2);
			x++;
		//	log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseInSummary 1027 End");
			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by BKG-Wise Summary Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by BKG-Wise Summary Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Location Booking MatchBack Detail] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInDetail(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		try {
		//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseInDetail 1027 Start");
			List<QuantityByTypeSizeVO> list = dbDao.searchLocationMBByBKGWiseInDetail(mBSearchOptionInGereralVO);

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>();
			QuantityByTypeSizeVO vo = null;
			int x = 0;

			int lastRNo = 0;
			lastRNo = list.size() - 1;
		//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseInSummary lastRNo [" + lastRNo+ "]");
			if (x == 0) {

				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(list.get(lastRNo).getLocCd());
				vo.setTotal(list.get(lastRNo).getTotal());
				vo.setQty0(list.get(lastRNo).getQty0());
				vo.setQty1(list.get(lastRNo).getQty1());
				vo.setQty2(list.get(lastRNo).getQty2());
				vo.setQty3(list.get(lastRNo).getQty3());
				vo.setQty4(list.get(lastRNo).getQty4());
				vo.setQty5(list.get(lastRNo).getQty5());
				vo.setQty6(list.get(lastRNo).getQty6());
				vo.setQty7(list.get(lastRNo).getQty7());
				vo.setQty8(list.get(lastRNo).getQty8());
				vo.setQty9(list.get(lastRNo).getQty9());
				vo.setQty10(list.get(lastRNo).getQty10());
				vo.setQty11(list.get(lastRNo).getQty11());
				vo.setQty12(list.get(lastRNo).getQty12());
				vo.setQty13(list.get(lastRNo).getQty13());
				vo.setQty14(list.get(lastRNo).getQty14());
				vo.setQty15(list.get(lastRNo).getQty15());
				vo.setQty16(list.get(lastRNo).getQty16());
				vo.setQty17(list.get(lastRNo).getQty17());
				vo.setQty18(list.get(lastRNo).getQty18());
				vo.setQty19(list.get(lastRNo).getQty19());
				vo.setQty20(list.get(lastRNo).getQty20());
				vo.setQty21(list.get(lastRNo).getQty21());
				vo.setQty22(list.get(lastRNo).getQty22());
				vo.setQty23(list.get(lastRNo).getQty23());
				vo.setQty24(list.get(lastRNo).getQty24());
				vo.setQty25(list.get(lastRNo).getQty25());
				vo.setQty26(list.get(lastRNo).getQty26());
				vo.setQty27(list.get(lastRNo).getQty27());
				vo.setQty28(list.get(lastRNo).getQty28());
				vo.setQty29(list.get(lastRNo).getQty29());
				vo.setQty30(list.get(lastRNo).getQty30());
				vo.setQty31(list.get(lastRNo).getQty31());
				vo.setQty32(list.get(lastRNo).getQty32());
				vo.setQty33(list.get(lastRNo).getQty33());
				vo.setQty34(list.get(lastRNo).getQty34());
				vo.setQty35(list.get(lastRNo).getQty35());
				vo.setQty36(list.get(lastRNo).getQty36());
				vo.setQty37(list.get(lastRNo).getQty37());
				vo.setQty38(list.get(lastRNo).getQty38());
				vo.setQty39(list.get(lastRNo).getQty39());
				list2.add(x, vo);
				x++;
			}

			for (int i = 0; i < lastRNo; i++) {

				vo = new QuantityByTypeSizeVO();

				vo.setLocCd(list.get(i).getLocCd());
				vo.setDivision(list.get(i).getDivision());
				vo.setTotal(list.get(i).getTotal());

				vo.setQty0(list.get(i).getQty0());
				vo.setQty1(list.get(i).getQty1());
				vo.setQty2(list.get(i).getQty2());
				vo.setQty3(list.get(i).getQty3());
				vo.setQty4(list.get(i).getQty4());
				vo.setQty5(list.get(i).getQty5());
				vo.setQty6(list.get(i).getQty6());
				vo.setQty7(list.get(i).getQty7());
				vo.setQty8(list.get(i).getQty8());
				vo.setQty9(list.get(i).getQty9());
				vo.setQty10(list.get(i).getQty10());
				vo.setQty11(list.get(i).getQty11());
				vo.setQty12(list.get(i).getQty12());
				vo.setQty13(list.get(i).getQty13());
				vo.setQty14(list.get(i).getQty14());
				vo.setQty15(list.get(i).getQty15());
				vo.setQty16(list.get(i).getQty16());
				vo.setQty17(list.get(i).getQty17());
				vo.setQty18(list.get(i).getQty18());
				vo.setQty19(list.get(i).getQty19());
				vo.setQty20(list.get(i).getQty20());
				vo.setQty21(list.get(i).getQty21());
				vo.setQty22(list.get(i).getQty22());
				vo.setQty23(list.get(i).getQty23());
				vo.setQty24(list.get(i).getQty24());
				vo.setQty25(list.get(i).getQty25());
				vo.setQty26(list.get(i).getQty26());
				vo.setQty27(list.get(i).getQty27());
				vo.setQty28(list.get(i).getQty28());
				vo.setQty29(list.get(i).getQty29());
				vo.setQty30(list.get(i).getQty30());
				vo.setQty31(list.get(i).getQty31());
				vo.setQty32(list.get(i).getQty32());
				vo.setQty33(list.get(i).getQty33());
				vo.setQty34(list.get(i).getQty34());
				vo.setQty35(list.get(i).getQty35());
				vo.setQty36(list.get(i).getQty36());
				vo.setQty37(list.get(i).getQty37());
				vo.setQty38(list.get(i).getQty38());
				vo.setQty39(list.get(i).getQty39());
				list2.add(x, vo);
				x++;

			}

		//	log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseInDetail 1027 End");
			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by BKG-Wise Detail Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by BKG-Wise Detail Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Location Booking MatchBack Trend] <br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return MatchBackByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByBKGWiseByTrend(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException {
		//log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseByTrend 1027 Start");
		try {

			MatchBackByMonthlyWeeklyTrendSetVO list = dbDao.searchLocationMBByBKGWiseByTrend(mBSearchOptionInGereralVO);

			List<QuantityByTypeSizeVO> list1 = list.getQuantitybytypesizevo();

			List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>();
			QuantityByTypeSizeVO vo = null;

			double[] inQty = new double[27];

			double[] outQty = new double[27];

			double[] mbQty = new double[27];

			double[] inQty2 = new double[27];

			double[] outQty2 = new double[27];

			double[] mbQty2 = new double[27];

			String xTempLocCdVal = "";

			if (list1.size() > 0) {

				int x = 0;
				for (int i = 0; i < list1.size(); i++) {
					int k = 0;

					// String strTpsz = list1.get(i).getVvd();
					String strDivision = list1.get(i).getDivision();
					String strLoccode = list1.get(i).getLocCd();

					if (strDivision.equals("M/B(%)")) {
						k = 3;
					}

					// process for S.Total & G.Total
					if (strLoccode.equals(xTempLocCdVal) || i == 0) {

						// adding to result List
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(list1.get(i).getLocCd());
						vo.setVvd(list1.get(i).getVvd());
						vo.setDivision(list1.get(i).getDivision());
						vo.setTotal(list1.get(i).getTotal());
						vo.setQty0(list1.get(i).getQty0());
						vo.setQty1(list1.get(i).getQty1());
						vo.setQty2(list1.get(i).getQty2());
						vo.setQty3(list1.get(i).getQty3());
						vo.setQty4(list1.get(i).getQty4());
						vo.setQty5(list1.get(i).getQty5());
						vo.setQty6(list1.get(i).getQty6());
						vo.setQty7(list1.get(i).getQty7());
						vo.setQty8(list1.get(i).getQty8());
						vo.setQty9(list1.get(i).getQty9());
						vo.setQty10(list1.get(i).getQty10());
						vo.setQty11(list1.get(i).getQty11());
						vo.setQty12(list1.get(i).getQty12());
						vo.setQty13(list1.get(i).getQty13());
						vo.setQty14(list1.get(i).getQty14());
						vo.setQty15(list1.get(i).getQty15());
						vo.setQty16(list1.get(i).getQty16());
						vo.setQty17(list1.get(i).getQty17());
						vo.setQty18(list1.get(i).getQty18());
						vo.setQty19(list1.get(i).getQty19());
						vo.setQty20(list1.get(i).getQty20());
						vo.setQty21(list1.get(i).getQty21());
						vo.setQty22(list1.get(i).getQty22());
						vo.setQty23(list1.get(i).getQty23());
						vo.setQty24(list1.get(i).getQty24());
						vo.setQty25(list1.get(i).getQty25());
						list2.add(x, vo);
						x++;

						if (strDivision.equals("M/B(%)")) {
							// S.Total
							inQty[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty[0];
							inQty[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty[1];
							inQty[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty[2];
							inQty[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty[3];
							inQty[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty[4];
							inQty[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty[5];
							inQty[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty[6];
							inQty[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty[7];
							inQty[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty[8];
							inQty[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty[9];
							inQty[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty[10];
							inQty[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty[11];
							inQty[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty[12];
							inQty[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty[13];
							inQty[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty[14];
							inQty[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty[15];
							inQty[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty[16];
							inQty[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty[17];
							inQty[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty[18];
							inQty[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty[19];
							inQty[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty[20];
							inQty[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty[21];
							inQty[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty[22];
							inQty[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty[23];
							inQty[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty[24];
							inQty[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty[25];
							inQty[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty[26]; // total

							outQty[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty[0];
							outQty[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty[1];
							outQty[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty[2];
							outQty[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty[3];
							outQty[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty[4];
							outQty[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty[5];
							outQty[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty[6];
							outQty[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty[7];
							outQty[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty[8];
							outQty[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty[9];
							outQty[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty[10];
							outQty[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty[11];
							outQty[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty[12];
							outQty[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty[13];
							outQty[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty[14];
							outQty[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty[15];
							outQty[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty[16];
							outQty[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty[17];
							outQty[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty[18];
							outQty[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty[19];
							outQty[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty[20];
							outQty[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty[21];
							outQty[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty[22];
							outQty[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty[23];
							outQty[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty[24];
							outQty[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty[25];
							outQty[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty[26]; // total

							// G.Total
							inQty2[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty2[0];
							inQty2[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty2[1];
							inQty2[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty2[2];
							inQty2[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty2[3];
							inQty2[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty2[4];
							inQty2[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty2[5];
							inQty2[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty2[6];
							inQty2[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty2[7];
							inQty2[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty2[8];
							inQty2[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty2[9];
							inQty2[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty2[10];
							inQty2[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty2[11];
							inQty2[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty2[12];
							inQty2[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty2[13];
							inQty2[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty2[14];
							inQty2[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty2[15];
							inQty2[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty2[16];
							inQty2[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty2[17];
							inQty2[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty2[18];
							inQty2[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty2[19];
							inQty2[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty2[20];
							inQty2[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty2[21];
							inQty2[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty2[22];
							inQty2[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty2[23];
							inQty2[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty2[24];
							inQty2[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty2[25];
							inQty2[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty2[26]; // total

							outQty2[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty2[0];
							outQty2[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty2[1];
							outQty2[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty2[2];
							outQty2[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty2[3];
							outQty2[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty2[4];
							outQty2[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty2[5];
							outQty2[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty2[6];
							outQty2[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty2[7];
							outQty2[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty2[8];
							outQty2[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty2[9];
							outQty2[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty2[10];
							outQty2[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty2[11];
							outQty2[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty2[12];
							outQty2[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty2[13];
							outQty2[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty2[14];
							outQty2[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty2[15];
							outQty2[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty2[16];
							outQty2[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty2[17];
							outQty2[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty2[18];
							outQty2[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty2[19];
							outQty2[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty2[20];
							outQty2[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty2[21];
							outQty2[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty2[22];
							outQty2[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty2[23];
							outQty2[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty2[24];
							outQty2[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty2[25];
							outQty2[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty2[26]; // total
						} // end if if(strDivision.equals("M/B(%")){

					}
					// calculating sub total in case of Location code change
					else if (!strLoccode.equals(xTempLocCdVal) || i != 0) { // if(strLoccode.equals(xTempLocCdVal)){
						
						// if(strDivision.equals("I/B")){
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("I/B");
						vo.setTotal(Double.toString(inQty[26]));
						vo.setQty0(Double.toString(inQty[0]));
						vo.setQty1(Double.toString(inQty[1]));
						vo.setQty2(Double.toString(inQty[2]));
						vo.setQty3(Double.toString(inQty[3]));
						vo.setQty4(Double.toString(inQty[4]));
						vo.setQty5(Double.toString(inQty[5]));
						vo.setQty6(Double.toString(inQty[6]));
						vo.setQty7(Double.toString(inQty[7]));
						vo.setQty8(Double.toString(inQty[8]));
						vo.setQty9(Double.toString(inQty[9]));
						vo.setQty10(Double.toString(inQty[10]));
						vo.setQty11(Double.toString(inQty[11]));
						vo.setQty12(Double.toString(inQty[12]));
						vo.setQty13(Double.toString(inQty[13]));
						vo.setQty14(Double.toString(inQty[14]));
						vo.setQty15(Double.toString(inQty[15]));
						vo.setQty16(Double.toString(inQty[16]));
						vo.setQty17(Double.toString(inQty[17]));
						vo.setQty18(Double.toString(inQty[18]));
						vo.setQty19(Double.toString(inQty[19]));
						vo.setQty20(Double.toString(inQty[20]));
						vo.setQty21(Double.toString(inQty[21]));
						vo.setQty22(Double.toString(inQty[22]));
						vo.setQty23(Double.toString(inQty[23]));
						vo.setQty24(Double.toString(inQty[24]));
						vo.setQty25(Double.toString(inQty[25]));
						list2.add(x, vo);
						x++;
						// }else if(strDivision.equals("O/B")){
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("O/B");
						vo.setTotal(Double.toString(outQty[26]));
						vo.setQty0(Double.toString(outQty[0]));
						vo.setQty1(Double.toString(outQty[1]));
						vo.setQty2(Double.toString(outQty[2]));
						vo.setQty3(Double.toString(outQty[3]));
						vo.setQty4(Double.toString(outQty[4]));
						vo.setQty5(Double.toString(outQty[5]));
						vo.setQty6(Double.toString(outQty[6]));
						vo.setQty7(Double.toString(outQty[7]));
						vo.setQty8(Double.toString(outQty[8]));
						vo.setQty9(Double.toString(outQty[9]));
						vo.setQty10(Double.toString(outQty[10]));
						vo.setQty11(Double.toString(outQty[11]));
						vo.setQty12(Double.toString(outQty[12]));
						vo.setQty13(Double.toString(outQty[13]));
						vo.setQty14(Double.toString(outQty[14]));
						vo.setQty15(Double.toString(outQty[15]));
						vo.setQty16(Double.toString(outQty[16]));
						vo.setQty17(Double.toString(outQty[17]));
						vo.setQty18(Double.toString(outQty[18]));
						vo.setQty19(Double.toString(outQty[19]));
						vo.setQty20(Double.toString(outQty[20]));
						vo.setQty21(Double.toString(outQty[21]));
						vo.setQty22(Double.toString(outQty[22]));
						vo.setQty23(Double.toString(outQty[23]));
						vo.setQty24(Double.toString(outQty[24]));
						vo.setQty25(Double.toString(outQty[25]));
						list2.add(x, vo);
						x++;
						// }else if(strDivision.equals("Bal")){
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("Balance");
						vo.setTotal(Double.toString(inQty[26] - outQty[26]));
						vo.setQty0(Double.toString(inQty[0] - outQty[0]));
						vo.setQty1(Double.toString(inQty[1] - outQty[1]));
						vo.setQty2(Double.toString(inQty[2] - outQty[2]));
						vo.setQty3(Double.toString(inQty[3] - outQty[3]));
						vo.setQty4(Double.toString(inQty[4] - outQty[4]));
						vo.setQty5(Double.toString(inQty[5] - outQty[5]));
						vo.setQty6(Double.toString(inQty[6] - outQty[6]));
						vo.setQty7(Double.toString(inQty[7] - outQty[7]));
						vo.setQty8(Double.toString(inQty[8] - outQty[8]));
						vo.setQty9(Double.toString(inQty[9] - outQty[9]));
						vo.setQty10(Double.toString(inQty[10] - outQty[10]));
						vo.setQty11(Double.toString(inQty[11] - outQty[11]));
						vo.setQty12(Double.toString(inQty[12] - outQty[12]));
						vo.setQty13(Double.toString(inQty[13] - outQty[13]));
						vo.setQty14(Double.toString(inQty[14] - outQty[14]));
						vo.setQty15(Double.toString(inQty[15] - outQty[15]));
						vo.setQty16(Double.toString(inQty[16] - outQty[16]));
						vo.setQty17(Double.toString(inQty[17] - outQty[17]));
						vo.setQty18(Double.toString(inQty[18] - outQty[18]));
						vo.setQty19(Double.toString(inQty[19] - outQty[19]));
						vo.setQty20(Double.toString(inQty[20] - outQty[20]));
						vo.setQty21(Double.toString(inQty[21] - outQty[21]));
						vo.setQty22(Double.toString(inQty[22] - outQty[22]));
						vo.setQty23(Double.toString(inQty[23] - outQty[23]));
						vo.setQty24(Double.toString(inQty[24] - outQty[24]));
						vo.setQty25(Double.toString(inQty[25] - outQty[25]));
						list2.add(x, vo);
						x++;
						// }else if(strDivision.equals("M/B(%)")){
						for (int m = 0; m < outQty.length; m++) {

							if (inQty[m] >= outQty[m]) {
								if (outQty[m] > 0) {
									mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
								}
								else {
									mbQty[m] = 0;
								}
							}
							else if (outQty[m] > 0) {
								mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
							}
							else {
								mbQty[m] = 0;
							}
						}
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(xTempLocCdVal);
						vo.setVvd("Total");
						vo.setDivision("M/B(%)");
						vo.setTotal(Double.toString(mbQty[26]));
						vo.setQty0(Double.toString(mbQty[0]));
						vo.setQty1(Double.toString(mbQty[1]));
						vo.setQty2(Double.toString(mbQty[2]));
						vo.setQty3(Double.toString(mbQty[3]));
						vo.setQty4(Double.toString(mbQty[4]));
						vo.setQty5(Double.toString(mbQty[5]));
						vo.setQty6(Double.toString(mbQty[6]));
						vo.setQty7(Double.toString(mbQty[7]));
						vo.setQty8(Double.toString(mbQty[8]));
						vo.setQty9(Double.toString(mbQty[9]));
						vo.setQty10(Double.toString(mbQty[10]));
						vo.setQty11(Double.toString(mbQty[11]));
						vo.setQty12(Double.toString(mbQty[12]));
						vo.setQty13(Double.toString(mbQty[13]));
						vo.setQty14(Double.toString(mbQty[14]));
						vo.setQty15(Double.toString(mbQty[15]));
						vo.setQty16(Double.toString(mbQty[16]));
						vo.setQty17(Double.toString(mbQty[17]));
						vo.setQty18(Double.toString(mbQty[18]));
						vo.setQty19(Double.toString(mbQty[19]));
						vo.setQty20(Double.toString(mbQty[20]));
						vo.setQty21(Double.toString(mbQty[21]));
						vo.setQty22(Double.toString(mbQty[22]));
						vo.setQty23(Double.toString(mbQty[23]));
						vo.setQty24(Double.toString(mbQty[24]));
						vo.setQty25(Double.toString(mbQty[25]));
						list2.add(x, vo);
						x++;

						// S.Total
						inQty[0] = 0;
						inQty[1] = 0;
						inQty[2] = 0;
						inQty[3] = 0;
						inQty[4] = 0;
						inQty[5] = 0;
						inQty[6] = 0;
						inQty[7] = 0;
						inQty[8] = 0;
						inQty[9] = 0;
						inQty[10] = 0;
						inQty[11] = 0;
						inQty[12] = 0;
						inQty[13] = 0;
						inQty[14] = 0;
						inQty[15] = 0;
						inQty[16] = 0;
						inQty[17] = 0;
						inQty[18] = 0;
						inQty[19] = 0;
						inQty[20] = 0;
						inQty[21] = 0;
						inQty[22] = 0;
						inQty[23] = 0;
						inQty[24] = 0;
						inQty[25] = 0;
						inQty[26] = 0; // total

						outQty[0] = 0;
						outQty[1] = 0;
						outQty[2] = 0;
						outQty[3] = 0;
						outQty[4] = 0;
						outQty[5] = 0;
						outQty[6] = 0;
						outQty[7] = 0;
						outQty[8] = 0;
						outQty[9] = 0;
						outQty[10] = 0;
						outQty[11] = 0;
						outQty[12] = 0;
						outQty[13] = 0;
						outQty[14] = 0;
						outQty[15] = 0;
						outQty[16] = 0;
						outQty[17] = 0;
						outQty[18] = 0;
						outQty[19] = 0;
						outQty[20] = 0;
						outQty[21] = 0;
						outQty[22] = 0;
						outQty[23] = 0;
						outQty[24] = 0;
						outQty[25] = 0;
						outQty[26] = 0; // total

						// adding to result List
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(list1.get(i).getLocCd());
						vo.setVvd(list1.get(i).getVvd());
						vo.setDivision(list1.get(i).getDivision());
						vo.setTotal(list1.get(i).getTotal());
						vo.setQty0(list1.get(i).getQty0());
						vo.setQty1(list1.get(i).getQty1());
						vo.setQty2(list1.get(i).getQty2());
						vo.setQty3(list1.get(i).getQty3());
						vo.setQty4(list1.get(i).getQty4());
						vo.setQty5(list1.get(i).getQty5());
						vo.setQty6(list1.get(i).getQty6());
						vo.setQty7(list1.get(i).getQty7());
						vo.setQty8(list1.get(i).getQty8());
						vo.setQty9(list1.get(i).getQty9());
						vo.setQty10(list1.get(i).getQty10());
						vo.setQty11(list1.get(i).getQty11());
						vo.setQty12(list1.get(i).getQty12());
						vo.setQty13(list1.get(i).getQty13());
						vo.setQty14(list1.get(i).getQty14());
						vo.setQty15(list1.get(i).getQty15());
						vo.setQty16(list1.get(i).getQty16());
						vo.setQty17(list1.get(i).getQty17());
						vo.setQty18(list1.get(i).getQty18());
						vo.setQty19(list1.get(i).getQty19());
						vo.setQty20(list1.get(i).getQty20());
						vo.setQty21(list1.get(i).getQty21());
						vo.setQty22(list1.get(i).getQty22());
						vo.setQty23(list1.get(i).getQty23());
						vo.setQty24(list1.get(i).getQty24());
						vo.setQty25(list1.get(i).getQty25());
						list2.add(x, vo);
						x++;

						if (strDivision.equals("M/B(%)")) {
							// S.Total
							inQty[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty[0];
							inQty[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty[1];
							inQty[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty[2];
							inQty[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty[3];
							inQty[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty[4];
							inQty[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty[5];
							inQty[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty[6];
							inQty[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty[7];
							inQty[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty[8];
							inQty[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty[9];
							inQty[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty[10];
							inQty[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty[11];
							inQty[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty[12];
							inQty[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty[13];
							inQty[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty[14];
							inQty[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty[15];
							inQty[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty[16];
							inQty[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty[17];
							inQty[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty[18];
							inQty[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty[19];
							inQty[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty[20];
							inQty[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty[21];
							inQty[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty[22];
							inQty[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty[23];
							inQty[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty[24];
							inQty[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty[25];
							inQty[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty[26]; // total

							outQty[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty[0];
							outQty[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty[1];
							outQty[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty[2];
							outQty[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty[3];
							outQty[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty[4];
							outQty[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty[5];
							outQty[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty[6];
							outQty[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty[7];
							outQty[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty[8];
							outQty[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty[9];
							outQty[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty[10];
							outQty[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty[11];
							outQty[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty[12];
							outQty[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty[13];
							outQty[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty[14];
							outQty[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty[15];
							outQty[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty[16];
							outQty[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty[17];
							outQty[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty[18];
							outQty[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty[19];
							outQty[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty[20];
							outQty[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty[21];
							outQty[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty[22];
							outQty[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty[23];
							outQty[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty[24];
							outQty[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty[25];
							outQty[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty[26]; // total

							// G.Total
							inQty2[0] = Double.parseDouble(list1.get(i - k).getQty0()) + inQty2[0];
							inQty2[1] = Double.parseDouble(list1.get(i - k).getQty1()) + inQty2[1];
							inQty2[2] = Double.parseDouble(list1.get(i - k).getQty2()) + inQty2[2];
							inQty2[3] = Double.parseDouble(list1.get(i - k).getQty3()) + inQty2[3];
							inQty2[4] = Double.parseDouble(list1.get(i - k).getQty4()) + inQty2[4];
							inQty2[5] = Double.parseDouble(list1.get(i - k).getQty5()) + inQty2[5];
							inQty2[6] = Double.parseDouble(list1.get(i - k).getQty6()) + inQty2[6];
							inQty2[7] = Double.parseDouble(list1.get(i - k).getQty7()) + inQty2[7];
							inQty2[8] = Double.parseDouble(list1.get(i - k).getQty8()) + inQty2[8];
							inQty2[9] = Double.parseDouble(list1.get(i - k).getQty9()) + inQty2[9];
							inQty2[10] = Double.parseDouble(list1.get(i - k).getQty10()) + inQty2[10];
							inQty2[11] = Double.parseDouble(list1.get(i - k).getQty11()) + inQty2[11];
							inQty2[12] = Double.parseDouble(list1.get(i - k).getQty12()) + inQty2[12];
							inQty2[13] = Double.parseDouble(list1.get(i - k).getQty13()) + inQty2[13];
							inQty2[14] = Double.parseDouble(list1.get(i - k).getQty14()) + inQty2[14];
							inQty2[15] = Double.parseDouble(list1.get(i - k).getQty15()) + inQty2[15];
							inQty2[16] = Double.parseDouble(list1.get(i - k).getQty16()) + inQty2[16];
							inQty2[17] = Double.parseDouble(list1.get(i - k).getQty17()) + inQty2[17];
							inQty2[18] = Double.parseDouble(list1.get(i - k).getQty18()) + inQty2[18];
							inQty2[19] = Double.parseDouble(list1.get(i - k).getQty19()) + inQty2[19];
							inQty2[20] = Double.parseDouble(list1.get(i - k).getQty20()) + inQty2[20];
							inQty2[21] = Double.parseDouble(list1.get(i - k).getQty21()) + inQty2[21];
							inQty2[22] = Double.parseDouble(list1.get(i - k).getQty22()) + inQty2[22];
							inQty2[23] = Double.parseDouble(list1.get(i - k).getQty23()) + inQty2[23];
							inQty2[24] = Double.parseDouble(list1.get(i - k).getQty24()) + inQty2[24];
							inQty2[25] = Double.parseDouble(list1.get(i - k).getQty25()) + inQty2[25];
							inQty2[26] = Double.parseDouble(list1.get(i - k).getTotal()) + inQty2[26]; // total

							outQty2[0] = Double.parseDouble(list1.get(i - (k - 1)).getQty0()) + outQty2[0];
							outQty2[1] = Double.parseDouble(list1.get(i - (k - 1)).getQty1()) + outQty2[1];
							outQty2[2] = Double.parseDouble(list1.get(i - (k - 1)).getQty2()) + outQty2[2];
							outQty2[3] = Double.parseDouble(list1.get(i - (k - 1)).getQty3()) + outQty2[3];
							outQty2[4] = Double.parseDouble(list1.get(i - (k - 1)).getQty4()) + outQty2[4];
							outQty2[5] = Double.parseDouble(list1.get(i - (k - 1)).getQty5()) + outQty2[5];
							outQty2[6] = Double.parseDouble(list1.get(i - (k - 1)).getQty6()) + outQty2[6];
							outQty2[7] = Double.parseDouble(list1.get(i - (k - 1)).getQty7()) + outQty2[7];
							outQty2[8] = Double.parseDouble(list1.get(i - (k - 1)).getQty8()) + outQty2[8];
							outQty2[9] = Double.parseDouble(list1.get(i - (k - 1)).getQty9()) + outQty2[9];
							outQty2[10] = Double.parseDouble(list1.get(i - (k - 1)).getQty10()) + outQty2[10];
							outQty2[11] = Double.parseDouble(list1.get(i - (k - 1)).getQty11()) + outQty2[11];
							outQty2[12] = Double.parseDouble(list1.get(i - (k - 1)).getQty12()) + outQty2[12];
							outQty2[13] = Double.parseDouble(list1.get(i - (k - 1)).getQty13()) + outQty2[13];
							outQty2[14] = Double.parseDouble(list1.get(i - (k - 1)).getQty14()) + outQty2[14];
							outQty2[15] = Double.parseDouble(list1.get(i - (k - 1)).getQty15()) + outQty2[15];
							outQty2[16] = Double.parseDouble(list1.get(i - (k - 1)).getQty16()) + outQty2[16];
							outQty2[17] = Double.parseDouble(list1.get(i - (k - 1)).getQty17()) + outQty2[17];
							outQty2[18] = Double.parseDouble(list1.get(i - (k - 1)).getQty18()) + outQty2[18];
							outQty2[19] = Double.parseDouble(list1.get(i - (k - 1)).getQty19()) + outQty2[19];
							outQty2[20] = Double.parseDouble(list1.get(i - (k - 1)).getQty20()) + outQty2[20];
							outQty2[21] = Double.parseDouble(list1.get(i - (k - 1)).getQty21()) + outQty2[21];
							outQty2[22] = Double.parseDouble(list1.get(i - (k - 1)).getQty22()) + outQty2[22];
							outQty2[23] = Double.parseDouble(list1.get(i - (k - 1)).getQty23()) + outQty2[23];
							outQty2[24] = Double.parseDouble(list1.get(i - (k - 1)).getQty24()) + outQty2[24];
							outQty2[25] = Double.parseDouble(list1.get(i - (k - 1)).getQty25()) + outQty2[25];
							outQty2[26] = Double.parseDouble(list1.get(i - (k - 1)).getTotal()) + outQty2[26]; // total
						} // end if if(strDivision.equals("M/B(%")){
					}// end if if(strLoccode.equals(xTempLocCdVal)){
					xTempLocCdVal = strLoccode;
				} // end for for ( int i=0; i< list1.size(); i++ ) {

				// if(strDivision.equals("I/B")){
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(inQty[26]));
				vo.setQty0(Double.toString(inQty[0]));
				vo.setQty1(Double.toString(inQty[1]));
				vo.setQty2(Double.toString(inQty[2]));
				vo.setQty3(Double.toString(inQty[3]));
				vo.setQty4(Double.toString(inQty[4]));
				vo.setQty5(Double.toString(inQty[5]));
				vo.setQty6(Double.toString(inQty[6]));
				vo.setQty7(Double.toString(inQty[7]));
				vo.setQty8(Double.toString(inQty[8]));
				vo.setQty9(Double.toString(inQty[9]));
				vo.setQty10(Double.toString(inQty[10]));
				vo.setQty11(Double.toString(inQty[11]));
				vo.setQty12(Double.toString(inQty[12]));
				vo.setQty13(Double.toString(inQty[13]));
				vo.setQty14(Double.toString(inQty[14]));
				vo.setQty15(Double.toString(inQty[15]));
				vo.setQty16(Double.toString(inQty[16]));
				vo.setQty17(Double.toString(inQty[17]));
				vo.setQty18(Double.toString(inQty[18]));
				vo.setQty19(Double.toString(inQty[19]));
				vo.setQty20(Double.toString(inQty[20]));
				vo.setQty21(Double.toString(inQty[21]));
				vo.setQty22(Double.toString(inQty[22]));
				vo.setQty23(Double.toString(inQty[23]));
				vo.setQty24(Double.toString(inQty[24]));
				vo.setQty25(Double.toString(inQty[25]));
				list2.add(x, vo);
				x++;
				// }else if(strDivision.equals("O/B")){
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(outQty[26]));
				vo.setQty0(Double.toString(outQty[0]));
				vo.setQty1(Double.toString(outQty[1]));
				vo.setQty2(Double.toString(outQty[2]));
				vo.setQty3(Double.toString(outQty[3]));
				vo.setQty4(Double.toString(outQty[4]));
				vo.setQty5(Double.toString(outQty[5]));
				vo.setQty6(Double.toString(outQty[6]));
				vo.setQty7(Double.toString(outQty[7]));
				vo.setQty8(Double.toString(outQty[8]));
				vo.setQty9(Double.toString(outQty[9]));
				vo.setQty10(Double.toString(outQty[10]));
				vo.setQty11(Double.toString(outQty[11]));
				vo.setQty12(Double.toString(outQty[12]));
				vo.setQty13(Double.toString(outQty[13]));
				vo.setQty14(Double.toString(outQty[14]));
				vo.setQty15(Double.toString(outQty[15]));
				vo.setQty16(Double.toString(outQty[16]));
				vo.setQty17(Double.toString(outQty[17]));
				vo.setQty18(Double.toString(outQty[18]));
				vo.setQty19(Double.toString(outQty[19]));
				vo.setQty20(Double.toString(outQty[20]));
				vo.setQty21(Double.toString(outQty[21]));
				vo.setQty22(Double.toString(outQty[22]));
				vo.setQty23(Double.toString(outQty[23]));
				vo.setQty24(Double.toString(outQty[24]));
				vo.setQty25(Double.toString(outQty[25]));
				list2.add(x, vo);
				x++;
				// }else if(strDivision.equals("Bal")){
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString(inQty[26] - outQty[26]));
				vo.setQty0(Double.toString(inQty[0] - outQty[0]));
				vo.setQty1(Double.toString(inQty[1] - outQty[1]));
				vo.setQty2(Double.toString(inQty[2] - outQty[2]));
				vo.setQty3(Double.toString(inQty[3] - outQty[3]));
				vo.setQty4(Double.toString(inQty[4] - outQty[4]));
				vo.setQty5(Double.toString(inQty[5] - outQty[5]));
				vo.setQty6(Double.toString(inQty[6] - outQty[6]));
				vo.setQty7(Double.toString(inQty[7] - outQty[7]));
				vo.setQty8(Double.toString(inQty[8] - outQty[8]));
				vo.setQty9(Double.toString(inQty[9] - outQty[9]));
				vo.setQty10(Double.toString(inQty[10] - outQty[10]));
				vo.setQty11(Double.toString(inQty[11] - outQty[11]));
				vo.setQty12(Double.toString(inQty[12] - outQty[12]));
				vo.setQty13(Double.toString(inQty[13] - outQty[13]));
				vo.setQty14(Double.toString(inQty[14] - outQty[14]));
				vo.setQty15(Double.toString(inQty[15] - outQty[15]));
				vo.setQty16(Double.toString(inQty[16] - outQty[16]));
				vo.setQty17(Double.toString(inQty[17] - outQty[17]));
				vo.setQty18(Double.toString(inQty[18] - outQty[18]));
				vo.setQty19(Double.toString(inQty[19] - outQty[19]));
				vo.setQty20(Double.toString(inQty[20] - outQty[20]));
				vo.setQty21(Double.toString(inQty[21] - outQty[21]));
				vo.setQty22(Double.toString(inQty[22] - outQty[22]));
				vo.setQty23(Double.toString(inQty[23] - outQty[23]));
				vo.setQty24(Double.toString(inQty[24] - outQty[24]));
				vo.setQty25(Double.toString(inQty[25] - outQty[25]));
				list2.add(x, vo);
				x++;
				// }else if(strDivision.equals("M/B(%)")){
				for (int m = 0; m < outQty.length; m++) {

					if (inQty[m] >= outQty[m]) {
						if (outQty[m] > 0) {
							mbQty[m] = Math.round(outQty[m] / inQty[m] * 100);
						}
						else {
							mbQty[m] = 0;
						}
					}
					else if (outQty[m] > 0) {
						mbQty[m] = Math.round((inQty[m] / outQty[m] * (-1)) * 100);
					}
					else {
						mbQty[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd(xTempLocCdVal);
				vo.setVvd("Total");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(mbQty[26]));
				vo.setQty0(Double.toString(mbQty[0]));
				vo.setQty1(Double.toString(mbQty[1]));
				vo.setQty2(Double.toString(mbQty[2]));
				vo.setQty3(Double.toString(mbQty[3]));
				vo.setQty4(Double.toString(mbQty[4]));
				vo.setQty5(Double.toString(mbQty[5]));
				vo.setQty6(Double.toString(mbQty[6]));
				vo.setQty7(Double.toString(mbQty[7]));
				vo.setQty8(Double.toString(mbQty[8]));
				vo.setQty9(Double.toString(mbQty[9]));
				vo.setQty10(Double.toString(mbQty[10]));
				vo.setQty11(Double.toString(mbQty[11]));
				vo.setQty12(Double.toString(mbQty[12]));
				vo.setQty13(Double.toString(mbQty[13]));
				vo.setQty14(Double.toString(mbQty[14]));
				vo.setQty15(Double.toString(mbQty[15]));
				vo.setQty16(Double.toString(mbQty[16]));
				vo.setQty17(Double.toString(mbQty[17]));
				vo.setQty18(Double.toString(mbQty[18]));
				vo.setQty19(Double.toString(mbQty[19]));
				vo.setQty20(Double.toString(mbQty[20]));
				vo.setQty21(Double.toString(mbQty[21]));
				vo.setQty22(Double.toString(mbQty[22]));
				vo.setQty23(Double.toString(mbQty[23]));
				vo.setQty24(Double.toString(mbQty[24]));
				vo.setQty25(Double.toString(mbQty[25]));
				list2.add(x, vo);
				x++;

				// setting G.Total
				// if(strDivision.equals("I/B")){
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("I/B");
				vo.setTotal(Double.toString(inQty2[26]));
				vo.setQty0(Double.toString(inQty2[0]));
				vo.setQty1(Double.toString(inQty2[1]));
				vo.setQty2(Double.toString(inQty2[2]));
				vo.setQty3(Double.toString(inQty2[3]));
				vo.setQty4(Double.toString(inQty2[4]));
				vo.setQty5(Double.toString(inQty2[5]));
				vo.setQty6(Double.toString(inQty2[6]));
				vo.setQty7(Double.toString(inQty2[7]));
				vo.setQty8(Double.toString(inQty2[8]));
				vo.setQty9(Double.toString(inQty2[9]));
				vo.setQty10(Double.toString(inQty2[10]));
				vo.setQty11(Double.toString(inQty2[11]));
				vo.setQty12(Double.toString(inQty2[12]));
				vo.setQty13(Double.toString(inQty2[13]));
				vo.setQty14(Double.toString(inQty2[14]));
				vo.setQty15(Double.toString(inQty2[15]));
				vo.setQty16(Double.toString(inQty2[16]));
				vo.setQty17(Double.toString(inQty2[17]));
				vo.setQty18(Double.toString(inQty2[18]));
				vo.setQty19(Double.toString(inQty2[19]));
				vo.setQty20(Double.toString(inQty2[20]));
				vo.setQty21(Double.toString(inQty2[21]));
				vo.setQty22(Double.toString(inQty2[22]));
				vo.setQty23(Double.toString(inQty2[23]));
				vo.setQty24(Double.toString(inQty2[24]));
				vo.setQty25(Double.toString(inQty2[25]));
				list2.add(x, vo);
				x++;
				// }else if(strDivision.equals("O/B")){
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("O/B");
				vo.setTotal(Double.toString(outQty2[26]));
				vo.setQty0(Double.toString(outQty2[0]));
				vo.setQty1(Double.toString(outQty2[1]));
				vo.setQty2(Double.toString(outQty2[2]));
				vo.setQty3(Double.toString(outQty2[3]));
				vo.setQty4(Double.toString(outQty2[4]));
				vo.setQty5(Double.toString(outQty2[5]));
				vo.setQty6(Double.toString(outQty2[6]));
				vo.setQty7(Double.toString(outQty2[7]));
				vo.setQty8(Double.toString(outQty2[8]));
				vo.setQty9(Double.toString(outQty2[9]));
				vo.setQty10(Double.toString(outQty2[10]));
				vo.setQty11(Double.toString(outQty2[11]));
				vo.setQty12(Double.toString(outQty2[12]));
				vo.setQty13(Double.toString(outQty2[13]));
				vo.setQty14(Double.toString(outQty2[14]));
				vo.setQty15(Double.toString(outQty2[15]));
				vo.setQty16(Double.toString(outQty2[16]));
				vo.setQty17(Double.toString(outQty2[17]));
				vo.setQty18(Double.toString(outQty2[18]));
				vo.setQty19(Double.toString(outQty2[19]));
				vo.setQty20(Double.toString(outQty2[20]));
				vo.setQty21(Double.toString(outQty2[21]));
				vo.setQty22(Double.toString(outQty2[22]));
				vo.setQty23(Double.toString(outQty2[23]));
				vo.setQty24(Double.toString(outQty2[24]));
				vo.setQty25(Double.toString(outQty2[25]));
				list2.add(x, vo);
				x++;
				// }else if(strDivision.equals("Bal")){
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("Balance");
				vo.setTotal(Double.toString(inQty2[26] - outQty2[26]));
				vo.setQty0(Double.toString(inQty2[0] - outQty2[0]));
				vo.setQty1(Double.toString(inQty2[1] - outQty2[1]));
				vo.setQty2(Double.toString(inQty2[2] - outQty2[2]));
				vo.setQty3(Double.toString(inQty2[3] - outQty2[3]));
				vo.setQty4(Double.toString(inQty2[4] - outQty2[4]));
				vo.setQty5(Double.toString(inQty2[5] - outQty2[5]));
				vo.setQty6(Double.toString(inQty2[6] - outQty2[6]));
				vo.setQty7(Double.toString(inQty2[7] - outQty2[7]));
				vo.setQty8(Double.toString(inQty2[8] - outQty2[8]));
				vo.setQty9(Double.toString(inQty2[9] - outQty2[9]));
				vo.setQty10(Double.toString(inQty2[10] - outQty2[10]));
				vo.setQty11(Double.toString(inQty2[11] - outQty2[11]));
				vo.setQty12(Double.toString(inQty2[12] - outQty2[12]));
				vo.setQty13(Double.toString(inQty2[13] - outQty2[13]));
				vo.setQty14(Double.toString(inQty2[14] - outQty2[14]));
				vo.setQty15(Double.toString(inQty2[15] - outQty2[15]));
				vo.setQty16(Double.toString(inQty2[16] - outQty2[16]));
				vo.setQty17(Double.toString(inQty2[17] - outQty2[17]));
				vo.setQty18(Double.toString(inQty2[18] - outQty2[18]));
				vo.setQty19(Double.toString(inQty2[19] - outQty2[19]));
				vo.setQty20(Double.toString(inQty2[20] - outQty2[20]));
				vo.setQty21(Double.toString(inQty2[21] - outQty2[21]));
				vo.setQty22(Double.toString(inQty2[22] - outQty2[22]));
				vo.setQty23(Double.toString(inQty2[23] - outQty2[23]));
				vo.setQty24(Double.toString(inQty2[24] - outQty2[24]));
				vo.setQty25(Double.toString(inQty2[25] - outQty2[25]));
				list2.add(x, vo);
				x++;
				// }else if(strDivision.equals("M/B(%)")){
				for (int m = 0; m < outQty2.length; m++) {

					if (inQty2[m] >= outQty2[m]) {
						if (outQty2[m] > 0) {
							mbQty2[m] = Math.round(outQty2[m] / inQty2[m] * 100);
						}
						else {
							mbQty2[m] = 0;
						}
					}
					else if (outQty2[m] > 0) {
						mbQty2[m] = Math.round((inQty2[m] / outQty2[m] * (-1)) * 100);
					}
					else {
						mbQty2[m] = 0;
					}
				}
				vo = new QuantityByTypeSizeVO();
				vo.setLocCd("");
				vo.setVvd("G.Total");
				vo.setDivision("M/B(%)");
				vo.setTotal(Double.toString(mbQty2[26]));
				vo.setQty0(Double.toString(mbQty2[0]));
				vo.setQty1(Double.toString(mbQty2[1]));
				vo.setQty2(Double.toString(mbQty2[2]));
				vo.setQty3(Double.toString(mbQty2[3]));
				vo.setQty4(Double.toString(mbQty2[4]));
				vo.setQty5(Double.toString(mbQty2[5]));
				vo.setQty6(Double.toString(mbQty2[6]));
				vo.setQty7(Double.toString(mbQty2[7]));
				vo.setQty8(Double.toString(mbQty2[8]));
				vo.setQty9(Double.toString(mbQty2[9]));
				vo.setQty10(Double.toString(mbQty2[10]));
				vo.setQty11(Double.toString(mbQty2[11]));
				vo.setQty12(Double.toString(mbQty2[12]));
				vo.setQty13(Double.toString(mbQty2[13]));
				vo.setQty14(Double.toString(mbQty2[14]));
				vo.setQty15(Double.toString(mbQty2[15]));
				vo.setQty16(Double.toString(mbQty2[16]));
				vo.setQty17(Double.toString(mbQty2[17]));
				vo.setQty18(Double.toString(mbQty2[18]));
				vo.setQty19(Double.toString(mbQty2[19]));
				vo.setQty20(Double.toString(mbQty2[20]));
				vo.setQty21(Double.toString(mbQty2[21]));
				vo.setQty22(Double.toString(mbQty2[22]));
				vo.setQty23(Double.toString(mbQty2[23]));
				vo.setQty24(Double.toString(mbQty2[24]));
				vo.setQty25(Double.toString(mbQty2[25]));
				list2.add(x, vo);

				list.setQuantitybytypesizevo(list2);

			} // if ( list1.size() > 0 ) {

		//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchLocationMBByBKGWiseByTrend 1027 End");
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by BKG-Wise Trend Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Location M/B by BKG-Wise Trend Retrieve" }).getMessage(), ex);
		} // end try
	}

	/**
	 * Retrieving [Cargo Flow Map] <br>
	 * 
	 * @param searchOptionByFromToVO
	 * @return List<QuantityByTypeSizeVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<QuantityByTypeSizeVO> searchCargoFlowMap(SearchOptionByFromToVO searchOptionByFromToVO)
			throws EventException {
	//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchCargoFlowMap 1029 Start");
		try {
			if(searchOptionByFromToVO.getDirectionWise().equals("L")){       			// Retrieving Loc_Loc
				List<QuantityByTypeSizeVO> list = new ArrayList<QuantityByTypeSizeVO>(); 
				
				list = dbDao.searchCargoFlowMapLoc(searchOptionByFromToVO);
				return list;
			}else{																		// Retrieving From,To	
				CargoFlowMapSetVO list4 = dbDao.searchCargoFlowMap(searchOptionByFromToVO);
				List<QuantityByTypeSizeVO> listSum = list4.getQuantitybytypesizevo2(); // result
				// S.Total
				List<QuantityByTypeSizeVO> list = list4.getQuantitybytypesizevo(); // result
				List<QuantityByTypeSizeVO> list2 = new ArrayList<QuantityByTypeSizeVO>(); // for return
	
			//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchCargoFlowMap 1029 list.size() [" + list.size() + "]");
				if (list.size() > 1) {
					
					QuantityByTypeSizeVO vo = null;
					// QuantityByTypeSizeVO vo2 = null;
					double[] volQty = new double[41]; // G.Total Vol
					double[] volQtyT = new double[41]; 
					double[] ratQty = new double[41];
	
					int x = 0;
					int lastRNo = 0;
					lastRNo = list.size() - 1;
				//	log.debug("####### EQMatchBackNLoadFactorMgtBC.searchCargoFlowMap 1029 lastRNo [" + lastRNo + "]");
					if (x == 0) {
	
						vo = new QuantityByTypeSizeVO();
						vo.setLocCd(list.get(lastRNo).getLocCd());
						vo.setTotal(list.get(lastRNo).getTotal());
						vo.setQty0(list.get(lastRNo).getQty0());
						vo.setQty1(list.get(lastRNo).getQty1());
						vo.setQty2(list.get(lastRNo).getQty2());
						vo.setQty3(list.get(lastRNo).getQty3());
						vo.setQty4(list.get(lastRNo).getQty4());
						vo.setQty5(list.get(lastRNo).getQty5());
						vo.setQty6(list.get(lastRNo).getQty6());
						vo.setQty7(list.get(lastRNo).getQty7());
						vo.setQty8(list.get(lastRNo).getQty8());
						vo.setQty9(list.get(lastRNo).getQty9());
						vo.setQty10(list.get(lastRNo).getQty10());
						vo.setQty11(list.get(lastRNo).getQty11());
						vo.setQty12(list.get(lastRNo).getQty12());
						vo.setQty13(list.get(lastRNo).getQty13());
						vo.setQty14(list.get(lastRNo).getQty14());
						vo.setQty15(list.get(lastRNo).getQty15());
						vo.setQty16(list.get(lastRNo).getQty16());
						vo.setQty17(list.get(lastRNo).getQty17());
						vo.setQty18(list.get(lastRNo).getQty18());
						vo.setQty19(list.get(lastRNo).getQty19());
						vo.setQty20(list.get(lastRNo).getQty20());
						vo.setQty21(list.get(lastRNo).getQty21());
						vo.setQty22(list.get(lastRNo).getQty22());
						vo.setQty23(list.get(lastRNo).getQty23());
						vo.setQty24(list.get(lastRNo).getQty24());
						vo.setQty25(list.get(lastRNo).getQty25());
						vo.setQty26(list.get(lastRNo).getQty26());
						vo.setQty27(list.get(lastRNo).getQty27());
						vo.setQty28(list.get(lastRNo).getQty28());
						vo.setQty29(list.get(lastRNo).getQty29());
						vo.setQty30(list.get(lastRNo).getQty30());
						vo.setQty31(list.get(lastRNo).getQty31());
						vo.setQty32(list.get(lastRNo).getQty32());
						vo.setQty33(list.get(lastRNo).getQty33());
						vo.setQty34(list.get(lastRNo).getQty34());
						vo.setQty35(list.get(lastRNo).getQty35());
						vo.setQty36(list.get(lastRNo).getQty36());
						vo.setQty37(list.get(lastRNo).getQty37());
						vo.setQty38(list.get(lastRNo).getQty38());
						vo.setQty39(list.get(lastRNo).getQty39());
						list2.add(x, vo);
						x++;
					}
	
					// calculating G.Total Vol Sum
					for (int i = 0; i < listSum.size(); i++) {
						volQty[0] = Double.parseDouble(listSum.get(i).getQty0()) + volQty[0];
						volQty[1] = Double.parseDouble(listSum.get(i).getQty1()) + volQty[1];
						volQty[2] = Double.parseDouble(listSum.get(i).getQty2()) + volQty[2];
						volQty[3] = Double.parseDouble(listSum.get(i).getQty3()) + volQty[3];
						volQty[4] = Double.parseDouble(listSum.get(i).getQty4()) + volQty[4];
						volQty[5] = Double.parseDouble(listSum.get(i).getQty5()) + volQty[5];
						volQty[6] = Double.parseDouble(listSum.get(i).getQty6()) + volQty[6];
						volQty[7] = Double.parseDouble(listSum.get(i).getQty7()) + volQty[7];
						volQty[8] = Double.parseDouble(listSum.get(i).getQty8()) + volQty[8];
						volQty[9] = Double.parseDouble(listSum.get(i).getQty9()) + volQty[9];
						volQty[10] = Double.parseDouble(listSum.get(i).getQty10()) + volQty[10];
						volQty[11] = Double.parseDouble(listSum.get(i).getQty11()) + volQty[11];
						volQty[12] = Double.parseDouble(listSum.get(i).getQty12()) + volQty[12];
						volQty[13] = Double.parseDouble(listSum.get(i).getQty13()) + volQty[13];
						volQty[14] = Double.parseDouble(listSum.get(i).getQty14()) + volQty[14];
						volQty[15] = Double.parseDouble(listSum.get(i).getQty15()) + volQty[15];
						volQty[16] = Double.parseDouble(listSum.get(i).getQty16()) + volQty[16];
						volQty[17] = Double.parseDouble(listSum.get(i).getQty17()) + volQty[17];
						volQty[18] = Double.parseDouble(listSum.get(i).getQty18()) + volQty[18];
						volQty[19] = Double.parseDouble(listSum.get(i).getQty19()) + volQty[19];
						volQty[20] = Double.parseDouble(listSum.get(i).getQty20()) + volQty[20];
						volQty[21] = Double.parseDouble(listSum.get(i).getQty21()) + volQty[21];
						volQty[22] = Double.parseDouble(listSum.get(i).getQty22()) + volQty[22];
						volQty[23] = Double.parseDouble(listSum.get(i).getQty23()) + volQty[23];
						volQty[24] = Double.parseDouble(listSum.get(i).getQty24()) + volQty[24];
						volQty[25] = Double.parseDouble(listSum.get(i).getQty25()) + volQty[25];
						volQty[26] = Double.parseDouble(listSum.get(i).getQty26()) + volQty[26];
						volQty[27] = Double.parseDouble(listSum.get(i).getQty27()) + volQty[27];
						volQty[28] = Double.parseDouble(listSum.get(i).getQty28()) + volQty[28];
						volQty[29] = Double.parseDouble(listSum.get(i).getQty29()) + volQty[29];
						volQty[30] = Double.parseDouble(listSum.get(i).getQty30()) + volQty[30];
						volQty[31] = Double.parseDouble(listSum.get(i).getQty31()) + volQty[31];
						volQty[32] = Double.parseDouble(listSum.get(i).getQty32()) + volQty[32];
						volQty[33] = Double.parseDouble(listSum.get(i).getQty33()) + volQty[33];
						volQty[34] = Double.parseDouble(listSum.get(i).getQty34()) + volQty[34];
						volQty[35] = Double.parseDouble(listSum.get(i).getQty35()) + volQty[35];
						volQty[36] = Double.parseDouble(listSum.get(i).getQty36()) + volQty[36];
						volQty[37] = Double.parseDouble(listSum.get(i).getQty37()) + volQty[37];
						volQty[38] = Double.parseDouble(listSum.get(i).getQty38()) + volQty[38];
						volQty[39] = Double.parseDouble(listSum.get(i).getQty39()) + volQty[39];
						volQty[40] = Double.parseDouble(listSum.get(i).getTotal()) + volQty[40];
					}
	
					double tempSTotalVal = 0;
					// int tempSTotalValIDX = 0;
					String xTempVal = "";
	
					int y = 0;
					for (int i = 0; i < lastRNo; i++) {
						String strLocCd = list.get(i).getLocCd();
	
						if (strLocCd.equals(xTempVal) || i == 0) {
	
							// adding to result List
							vo = new QuantityByTypeSizeVO();
							vo.setLocCd(list.get(i).getLocCd());
							vo.setVvd(list.get(i).getVvd());
							vo.setDivision(list.get(i).getDivision());
							vo.setIbflag(list.get(i).getIbflag());
							vo.setTotal(list.get(i).getTotal());
							vo.setQty0(list.get(i).getQty0());
							vo.setQty1(list.get(i).getQty1());
							vo.setQty2(list.get(i).getQty2());
							vo.setQty3(list.get(i).getQty3());
							vo.setQty4(list.get(i).getQty4());
							vo.setQty5(list.get(i).getQty5());
							vo.setQty6(list.get(i).getQty6());
							vo.setQty7(list.get(i).getQty7());
							vo.setQty8(list.get(i).getQty8());
							vo.setQty9(list.get(i).getQty9());
							vo.setQty10(list.get(i).getQty10());
							vo.setQty11(list.get(i).getQty11());
							vo.setQty12(list.get(i).getQty12());
							vo.setQty13(list.get(i).getQty13());
							vo.setQty14(list.get(i).getQty14());
							vo.setQty15(list.get(i).getQty15());
							vo.setQty16(list.get(i).getQty16());
							vo.setQty17(list.get(i).getQty17());
							vo.setQty18(list.get(i).getQty18());
							vo.setQty19(list.get(i).getQty19());
							vo.setQty20(list.get(i).getQty20());
							vo.setQty21(list.get(i).getQty21());
							vo.setQty22(list.get(i).getQty22());
							vo.setQty23(list.get(i).getQty23());
							vo.setQty24(list.get(i).getQty24());
							vo.setQty25(list.get(i).getQty25());
							vo.setQty26(list.get(i).getQty26());
							vo.setQty27(list.get(i).getQty27());
							vo.setQty28(list.get(i).getQty28());
							vo.setQty29(list.get(i).getQty29());
							vo.setQty30(list.get(i).getQty30());
							vo.setQty31(list.get(i).getQty31());
							vo.setQty32(list.get(i).getQty32());
							vo.setQty33(list.get(i).getQty33());
							vo.setQty34(list.get(i).getQty34());
							vo.setQty35(list.get(i).getQty35());
							vo.setQty36(list.get(i).getQty36());
							vo.setQty37(list.get(i).getQty37());
							vo.setQty38(list.get(i).getQty38());
							vo.setQty39(list.get(i).getQty39());
							list2.add(x, vo);
							x++;
	
							volQtyT[0] = Double.parseDouble(list.get(i).getQty0());
							volQtyT[1] = Double.parseDouble(list.get(i).getQty1());
							volQtyT[2] = Double.parseDouble(list.get(i).getQty2());
							volQtyT[3] = Double.parseDouble(list.get(i).getQty3());
							volQtyT[4] = Double.parseDouble(list.get(i).getQty4());
							volQtyT[5] = Double.parseDouble(list.get(i).getQty5());
							volQtyT[6] = Double.parseDouble(list.get(i).getQty6());
							volQtyT[7] = Double.parseDouble(list.get(i).getQty7());
							volQtyT[8] = Double.parseDouble(list.get(i).getQty8());
							volQtyT[9] = Double.parseDouble(list.get(i).getQty9());
							volQtyT[10] = Double.parseDouble(list.get(i).getQty10());
							volQtyT[11] = Double.parseDouble(list.get(i).getQty11());
							volQtyT[12] = Double.parseDouble(list.get(i).getQty12());
							volQtyT[13] = Double.parseDouble(list.get(i).getQty13());
							volQtyT[14] = Double.parseDouble(list.get(i).getQty14());
							volQtyT[15] = Double.parseDouble(list.get(i).getQty15());
							volQtyT[16] = Double.parseDouble(list.get(i).getQty16());
							volQtyT[17] = Double.parseDouble(list.get(i).getQty17());
							volQtyT[18] = Double.parseDouble(list.get(i).getQty18());
							volQtyT[19] = Double.parseDouble(list.get(i).getQty19());
							volQtyT[20] = Double.parseDouble(list.get(i).getQty20());
							volQtyT[21] = Double.parseDouble(list.get(i).getQty21());
							volQtyT[22] = Double.parseDouble(list.get(i).getQty22());
							volQtyT[23] = Double.parseDouble(list.get(i).getQty23());
							volQtyT[24] = Double.parseDouble(list.get(i).getQty24());
							volQtyT[25] = Double.parseDouble(list.get(i).getQty25());
							volQtyT[26] = Double.parseDouble(list.get(i).getQty26());
							volQtyT[27] = Double.parseDouble(list.get(i).getQty27());
							volQtyT[28] = Double.parseDouble(list.get(i).getQty28());
							volQtyT[29] = Double.parseDouble(list.get(i).getQty29());
							volQtyT[30] = Double.parseDouble(list.get(i).getQty30());
							volQtyT[31] = Double.parseDouble(list.get(i).getQty31());
							volQtyT[32] = Double.parseDouble(list.get(i).getQty32());
							volQtyT[33] = Double.parseDouble(list.get(i).getQty33());
							volQtyT[34] = Double.parseDouble(list.get(i).getQty34());
							volQtyT[35] = Double.parseDouble(list.get(i).getQty35());
							volQtyT[36] = Double.parseDouble(list.get(i).getQty36());
							volQtyT[37] = Double.parseDouble(list.get(i).getQty37());
							volQtyT[38] = Double.parseDouble(list.get(i).getQty38());
							volQtyT[39] = Double.parseDouble(list.get(i).getQty39());
							volQtyT[40] = Double.parseDouble(list.get(i).getTotal());
	
							tempSTotalVal = Double.parseDouble(listSum.get(y).getTotal());
							for (int m = 0; m < volQtyT.length; m++) {
								ratQty[m] = Math.round((volQtyT[m] / tempSTotalVal) * 100);
							}
	
							vo = new QuantityByTypeSizeVO();
							vo.setLocCd(list.get(i).getLocCd());
							vo.setVvd(list.get(i).getVvd());
							vo.setDivision(list.get(i).getDivision());
							vo.setIbflag("Ratio");
							vo.setTotal(checkStringInteger(Double.toString(ratQty[40])) + "%");
							vo.setQty0(checkStringInteger(Double.toString(ratQty[0])) + "%");
							vo.setQty1(checkStringInteger(Double.toString(ratQty[1])) + "%");
							vo.setQty2(checkStringInteger(Double.toString(ratQty[2])) + "%");
							vo.setQty3(checkStringInteger(Double.toString(ratQty[3])) + "%");
							vo.setQty4(checkStringInteger(Double.toString(ratQty[4])) + "%");
							vo.setQty5(checkStringInteger(Double.toString(ratQty[5])) + "%");
							vo.setQty6(checkStringInteger(Double.toString(ratQty[6])) + "%");
							vo.setQty7(checkStringInteger(Double.toString(ratQty[7])) + "%");
							vo.setQty8(checkStringInteger(Double.toString(ratQty[8])) + "%");
							vo.setQty9(checkStringInteger(Double.toString(ratQty[9])) + "%");
							vo.setQty10(checkStringInteger(Double.toString(ratQty[10])) + "%");
							vo.setQty11(checkStringInteger(Double.toString(ratQty[11])) + "%");
							vo.setQty12(checkStringInteger(Double.toString(ratQty[12])) + "%");
							vo.setQty13(checkStringInteger(Double.toString(ratQty[13])) + "%");
							vo.setQty14(checkStringInteger(Double.toString(ratQty[14])) + "%");
							vo.setQty15(checkStringInteger(Double.toString(ratQty[15])) + "%");
							vo.setQty16(checkStringInteger(Double.toString(ratQty[16])) + "%");
							vo.setQty17(checkStringInteger(Double.toString(ratQty[17])) + "%");
							vo.setQty18(checkStringInteger(Double.toString(ratQty[18])) + "%");
							vo.setQty19(checkStringInteger(Double.toString(ratQty[19])) + "%");
							vo.setQty20(checkStringInteger(Double.toString(ratQty[20])) + "%");
							vo.setQty21(checkStringInteger(Double.toString(ratQty[21])) + "%");
							vo.setQty22(checkStringInteger(Double.toString(ratQty[22])) + "%");
							vo.setQty23(checkStringInteger(Double.toString(ratQty[23])) + "%");
							vo.setQty24(checkStringInteger(Double.toString(ratQty[24])) + "%");
							vo.setQty25(checkStringInteger(Double.toString(ratQty[25])) + "%");
							vo.setQty26(checkStringInteger(Double.toString(ratQty[26])) + "%");
							vo.setQty27(checkStringInteger(Double.toString(ratQty[27])) + "%");
							vo.setQty28(checkStringInteger(Double.toString(ratQty[28])) + "%");
							vo.setQty29(checkStringInteger(Double.toString(ratQty[29])) + "%");
							vo.setQty30(checkStringInteger(Double.toString(ratQty[30])) + "%");
							vo.setQty31(checkStringInteger(Double.toString(ratQty[31])) + "%");
							vo.setQty32(checkStringInteger(Double.toString(ratQty[32])) + "%");
							vo.setQty33(checkStringInteger(Double.toString(ratQty[33])) + "%");
							vo.setQty34(checkStringInteger(Double.toString(ratQty[34])) + "%");
							vo.setQty35(checkStringInteger(Double.toString(ratQty[35])) + "%");
							vo.setQty36(checkStringInteger(Double.toString(ratQty[36])) + "%");
							vo.setQty37(checkStringInteger(Double.toString(ratQty[37])) + "%");
							vo.setQty38(checkStringInteger(Double.toString(ratQty[38])) + "%");
							vo.setQty39(checkStringInteger(Double.toString(ratQty[39])) + "%");
							list2.add(x, vo);
							x++;
	
						}
						else if (!strLocCd.equals(xTempVal)) {
	
							vo = new QuantityByTypeSizeVO();
							vo.setLocCd(xTempVal);
							vo.setVvd("");
							vo.setDivision("Total");
							vo.setIbflag("Vol");
							vo.setTotal(listSum.get(y).getTotal());
							vo.setQty0(listSum.get(y).getQty0());
							vo.setQty1(listSum.get(y).getQty1());
							vo.setQty2(listSum.get(y).getQty2());
							vo.setQty3(listSum.get(y).getQty3());
							vo.setQty4(listSum.get(y).getQty4());
							vo.setQty5(listSum.get(y).getQty5());
							vo.setQty6(listSum.get(y).getQty6());
							vo.setQty7(listSum.get(y).getQty7());
							vo.setQty8(listSum.get(y).getQty8());
							vo.setQty9(listSum.get(y).getQty9());
							vo.setQty10(listSum.get(y).getQty10());
							vo.setQty11(listSum.get(y).getQty11());
							vo.setQty12(listSum.get(y).getQty12());
							vo.setQty13(listSum.get(y).getQty13());
							vo.setQty14(listSum.get(y).getQty14());
							vo.setQty15(listSum.get(y).getQty15());
							vo.setQty16(listSum.get(y).getQty16());
							vo.setQty17(listSum.get(y).getQty17());
							vo.setQty18(listSum.get(y).getQty18());
							vo.setQty19(listSum.get(y).getQty19());
							vo.setQty20(listSum.get(y).getQty20());
							vo.setQty21(listSum.get(y).getQty21());
							vo.setQty22(listSum.get(y).getQty22());
							vo.setQty23(listSum.get(y).getQty23());
							vo.setQty24(listSum.get(y).getQty24());
							vo.setQty25(listSum.get(y).getQty25());
							vo.setQty26(listSum.get(y).getQty26());
							vo.setQty27(listSum.get(y).getQty27());
							vo.setQty28(listSum.get(y).getQty28());
							vo.setQty29(listSum.get(y).getQty29());
							vo.setQty30(listSum.get(y).getQty30());
							vo.setQty31(listSum.get(y).getQty31());
							vo.setQty32(listSum.get(y).getQty32());
							vo.setQty33(listSum.get(y).getQty33());
							vo.setQty34(listSum.get(y).getQty34());
							vo.setQty35(listSum.get(y).getQty35());
							vo.setQty36(listSum.get(y).getQty36());
							vo.setQty37(listSum.get(y).getQty37());
							vo.setQty38(listSum.get(y).getQty38());
							vo.setQty39(listSum.get(y).getQty39());
							list2.add(x, vo);
							x++;
	
							volQtyT[0] = Double.parseDouble(listSum.get(y).getQty0());
							volQtyT[1] = Double.parseDouble(listSum.get(y).getQty1());
							volQtyT[2] = Double.parseDouble(listSum.get(y).getQty2());
							volQtyT[3] = Double.parseDouble(listSum.get(y).getQty3());
							volQtyT[4] = Double.parseDouble(listSum.get(y).getQty4());
							volQtyT[5] = Double.parseDouble(listSum.get(y).getQty5());
							volQtyT[6] = Double.parseDouble(listSum.get(y).getQty6());
							volQtyT[7] = Double.parseDouble(listSum.get(y).getQty7());
							volQtyT[8] = Double.parseDouble(listSum.get(y).getQty8());
							volQtyT[9] = Double.parseDouble(listSum.get(y).getQty9());
							volQtyT[10] = Double.parseDouble(listSum.get(y).getQty10());
							volQtyT[11] = Double.parseDouble(listSum.get(y).getQty11());
							volQtyT[12] = Double.parseDouble(listSum.get(y).getQty12());
							volQtyT[13] = Double.parseDouble(listSum.get(y).getQty13());
							volQtyT[14] = Double.parseDouble(listSum.get(y).getQty14());
							volQtyT[15] = Double.parseDouble(listSum.get(y).getQty15());
							volQtyT[16] = Double.parseDouble(listSum.get(y).getQty16());
							volQtyT[17] = Double.parseDouble(listSum.get(y).getQty17());
							volQtyT[18] = Double.parseDouble(listSum.get(y).getQty18());
							volQtyT[19] = Double.parseDouble(listSum.get(y).getQty19());
							volQtyT[20] = Double.parseDouble(listSum.get(y).getQty20());
							volQtyT[21] = Double.parseDouble(listSum.get(y).getQty21());
							volQtyT[22] = Double.parseDouble(listSum.get(y).getQty22());
							volQtyT[23] = Double.parseDouble(listSum.get(y).getQty23());
							volQtyT[24] = Double.parseDouble(listSum.get(y).getQty24());
							volQtyT[25] = Double.parseDouble(listSum.get(y).getQty25());
							volQtyT[26] = Double.parseDouble(listSum.get(y).getQty26());
							volQtyT[27] = Double.parseDouble(listSum.get(y).getQty27());
							volQtyT[28] = Double.parseDouble(listSum.get(y).getQty28());
							volQtyT[29] = Double.parseDouble(listSum.get(y).getQty29());
							volQtyT[30] = Double.parseDouble(listSum.get(y).getQty30());
							volQtyT[31] = Double.parseDouble(listSum.get(y).getQty31());
							volQtyT[32] = Double.parseDouble(listSum.get(y).getQty32());
							volQtyT[33] = Double.parseDouble(listSum.get(y).getQty33());
							volQtyT[34] = Double.parseDouble(listSum.get(y).getQty34());
							volQtyT[35] = Double.parseDouble(listSum.get(y).getQty35());
							volQtyT[36] = Double.parseDouble(listSum.get(y).getQty36());
							volQtyT[37] = Double.parseDouble(listSum.get(y).getQty37());
							volQtyT[38] = Double.parseDouble(listSum.get(y).getQty38());
							volQtyT[39] = Double.parseDouble(listSum.get(y).getQty39());
							volQtyT[40] = Double.parseDouble(listSum.get(y).getTotal());
	
							for (int m = 0; m < volQtyT.length; m++) {
								ratQty[m] = Math.round((volQtyT[m] / volQty[40]) * 100);
							}
	
							vo = new QuantityByTypeSizeVO();
							vo.setLocCd(xTempVal);
							vo.setVvd("");
							vo.setDivision("Total");
							vo.setIbflag("Ratio");
							vo.setTotal(checkStringInteger(Double.toString(ratQty[40])) + "%");
							vo.setQty0(checkStringInteger(Double.toString(ratQty[0])) + "%");
							vo.setQty1(checkStringInteger(Double.toString(ratQty[1])) + "%");
							vo.setQty2(checkStringInteger(Double.toString(ratQty[2])) + "%");
							vo.setQty3(checkStringInteger(Double.toString(ratQty[3])) + "%");
							vo.setQty4(checkStringInteger(Double.toString(ratQty[4])) + "%");
							vo.setQty5(checkStringInteger(Double.toString(ratQty[5])) + "%");
							vo.setQty6(checkStringInteger(Double.toString(ratQty[6])) + "%");
							vo.setQty7(checkStringInteger(Double.toString(ratQty[7])) + "%");
							vo.setQty8(checkStringInteger(Double.toString(ratQty[8])) + "%");
							vo.setQty9(checkStringInteger(Double.toString(ratQty[9])) + "%");
							vo.setQty10(checkStringInteger(Double.toString(ratQty[10])) + "%");
							vo.setQty11(checkStringInteger(Double.toString(ratQty[11])) + "%");
							vo.setQty12(checkStringInteger(Double.toString(ratQty[12])) + "%");
							vo.setQty13(checkStringInteger(Double.toString(ratQty[13])) + "%");
							vo.setQty14(checkStringInteger(Double.toString(ratQty[14])) + "%");
							vo.setQty15(checkStringInteger(Double.toString(ratQty[15])) + "%");
							vo.setQty16(checkStringInteger(Double.toString(ratQty[16])) + "%");
							vo.setQty17(checkStringInteger(Double.toString(ratQty[17])) + "%");
							vo.setQty18(checkStringInteger(Double.toString(ratQty[18])) + "%");
							vo.setQty19(checkStringInteger(Double.toString(ratQty[19])) + "%");
							vo.setQty20(checkStringInteger(Double.toString(ratQty[20])) + "%");
							vo.setQty21(checkStringInteger(Double.toString(ratQty[21])) + "%");
							vo.setQty22(checkStringInteger(Double.toString(ratQty[22])) + "%");
							vo.setQty23(checkStringInteger(Double.toString(ratQty[23])) + "%");
							vo.setQty24(checkStringInteger(Double.toString(ratQty[24])) + "%");
							vo.setQty25(checkStringInteger(Double.toString(ratQty[25])) + "%");
							vo.setQty26(checkStringInteger(Double.toString(ratQty[26])) + "%");
							vo.setQty27(checkStringInteger(Double.toString(ratQty[27])) + "%");
							vo.setQty28(checkStringInteger(Double.toString(ratQty[28])) + "%");
							vo.setQty29(checkStringInteger(Double.toString(ratQty[29])) + "%");
							vo.setQty30(checkStringInteger(Double.toString(ratQty[30])) + "%");
							vo.setQty31(checkStringInteger(Double.toString(ratQty[31])) + "%");
							vo.setQty32(checkStringInteger(Double.toString(ratQty[32])) + "%");
							vo.setQty33(checkStringInteger(Double.toString(ratQty[33])) + "%");
							vo.setQty34(checkStringInteger(Double.toString(ratQty[34])) + "%");
							vo.setQty35(checkStringInteger(Double.toString(ratQty[35])) + "%");
							vo.setQty36(checkStringInteger(Double.toString(ratQty[36])) + "%");
							vo.setQty37(checkStringInteger(Double.toString(ratQty[37])) + "%");
							vo.setQty38(checkStringInteger(Double.toString(ratQty[38])) + "%");
							vo.setQty39(checkStringInteger(Double.toString(ratQty[39])) + "%");
							list2.add(x, vo);
							x++;
	
							// adding list
							vo = new QuantityByTypeSizeVO();
							vo.setLocCd(list.get(i).getLocCd());
							vo.setVvd(list.get(i).getVvd());
							vo.setDivision(list.get(i).getDivision());
							vo.setIbflag(list.get(i).getIbflag());
							vo.setTotal(list.get(i).getTotal());
							vo.setQty0(list.get(i).getQty0());
							vo.setQty1(list.get(i).getQty1());
							vo.setQty2(list.get(i).getQty2());
							vo.setQty3(list.get(i).getQty3());
							vo.setQty4(list.get(i).getQty4());
							vo.setQty5(list.get(i).getQty5());
							vo.setQty6(list.get(i).getQty6());
							vo.setQty7(list.get(i).getQty7());
							vo.setQty8(list.get(i).getQty8());
							vo.setQty9(list.get(i).getQty9());
							vo.setQty10(list.get(i).getQty10());
							vo.setQty11(list.get(i).getQty11());
							vo.setQty12(list.get(i).getQty12());
							vo.setQty13(list.get(i).getQty13());
							vo.setQty14(list.get(i).getQty14());
							vo.setQty15(list.get(i).getQty15());
							vo.setQty16(list.get(i).getQty16());
							vo.setQty17(list.get(i).getQty17());
							vo.setQty18(list.get(i).getQty18());
							vo.setQty19(list.get(i).getQty19());
							vo.setQty20(list.get(i).getQty20());
							vo.setQty21(list.get(i).getQty21());
							vo.setQty22(list.get(i).getQty22());
							vo.setQty23(list.get(i).getQty23());
							vo.setQty24(list.get(i).getQty24());
							vo.setQty25(list.get(i).getQty25());
							vo.setQty26(list.get(i).getQty26());
							vo.setQty27(list.get(i).getQty27());
							vo.setQty28(list.get(i).getQty28());
							vo.setQty29(list.get(i).getQty29());
							vo.setQty30(list.get(i).getQty30());
							vo.setQty31(list.get(i).getQty31());
							vo.setQty32(list.get(i).getQty32());
							vo.setQty33(list.get(i).getQty33());
							vo.setQty34(list.get(i).getQty34());
							vo.setQty35(list.get(i).getQty35());
							vo.setQty36(list.get(i).getQty36());
							vo.setQty37(list.get(i).getQty37());
							vo.setQty38(list.get(i).getQty38());
							vo.setQty39(list.get(i).getQty39());
							list2.add(x, vo);
							x++;
	
							volQtyT[0] = Double.parseDouble(list.get(i).getQty0());
							volQtyT[1] = Double.parseDouble(list.get(i).getQty1());
							volQtyT[2] = Double.parseDouble(list.get(i).getQty2());
							volQtyT[3] = Double.parseDouble(list.get(i).getQty3());
							volQtyT[4] = Double.parseDouble(list.get(i).getQty4());
							volQtyT[5] = Double.parseDouble(list.get(i).getQty5());
							volQtyT[6] = Double.parseDouble(list.get(i).getQty6());
							volQtyT[7] = Double.parseDouble(list.get(i).getQty7());
							volQtyT[8] = Double.parseDouble(list.get(i).getQty8());
							volQtyT[9] = Double.parseDouble(list.get(i).getQty9());
							volQtyT[10] = Double.parseDouble(list.get(i).getQty10());
							volQtyT[11] = Double.parseDouble(list.get(i).getQty11());
							volQtyT[12] = Double.parseDouble(list.get(i).getQty12());
							volQtyT[13] = Double.parseDouble(list.get(i).getQty13());
							volQtyT[14] = Double.parseDouble(list.get(i).getQty14());
							volQtyT[15] = Double.parseDouble(list.get(i).getQty15());
							volQtyT[16] = Double.parseDouble(list.get(i).getQty16());
							volQtyT[17] = Double.parseDouble(list.get(i).getQty17());
							volQtyT[18] = Double.parseDouble(list.get(i).getQty18());
							volQtyT[19] = Double.parseDouble(list.get(i).getQty19());
							volQtyT[20] = Double.parseDouble(list.get(i).getQty20());
							volQtyT[21] = Double.parseDouble(list.get(i).getQty21());
							volQtyT[22] = Double.parseDouble(list.get(i).getQty22());
							volQtyT[23] = Double.parseDouble(list.get(i).getQty23());
							volQtyT[24] = Double.parseDouble(list.get(i).getQty24());
							volQtyT[25] = Double.parseDouble(list.get(i).getQty25());
							volQtyT[26] = Double.parseDouble(list.get(i).getQty26());
							volQtyT[27] = Double.parseDouble(list.get(i).getQty27());
							volQtyT[28] = Double.parseDouble(list.get(i).getQty28());
							volQtyT[29] = Double.parseDouble(list.get(i).getQty29());
							volQtyT[30] = Double.parseDouble(list.get(i).getQty30());
							volQtyT[31] = Double.parseDouble(list.get(i).getQty31());
							volQtyT[32] = Double.parseDouble(list.get(i).getQty32());
							volQtyT[33] = Double.parseDouble(list.get(i).getQty33());
							volQtyT[34] = Double.parseDouble(list.get(i).getQty34());
							volQtyT[35] = Double.parseDouble(list.get(i).getQty35());
							volQtyT[36] = Double.parseDouble(list.get(i).getQty36());
							volQtyT[37] = Double.parseDouble(list.get(i).getQty37());
							volQtyT[38] = Double.parseDouble(list.get(i).getQty38());
							volQtyT[39] = Double.parseDouble(list.get(i).getQty39());
							volQtyT[40] = Double.parseDouble(list.get(i).getTotal());
	
							y++;
							tempSTotalVal = Double.parseDouble(listSum.get(y).getTotal());
							for (int m = 0; m < volQtyT.length; m++) {
								ratQty[m] = Math.round((volQtyT[m] / tempSTotalVal) * 100);
							}
	
							vo = new QuantityByTypeSizeVO();
							vo.setLocCd(list.get(i).getLocCd());
							vo.setVvd(list.get(i).getVvd());
							vo.setDivision(list.get(i).getDivision());
							vo.setIbflag("Ratio");
							vo.setTotal(checkStringInteger(Double.toString(ratQty[40])) + "%");
							vo.setQty0(checkStringInteger(Double.toString(ratQty[0])) + "%");
							vo.setQty1(checkStringInteger(Double.toString(ratQty[1])) + "%");
							vo.setQty2(checkStringInteger(Double.toString(ratQty[2])) + "%");
							vo.setQty3(checkStringInteger(Double.toString(ratQty[3])) + "%");
							vo.setQty4(checkStringInteger(Double.toString(ratQty[4])) + "%");
							vo.setQty5(checkStringInteger(Double.toString(ratQty[5])) + "%");
							vo.setQty6(checkStringInteger(Double.toString(ratQty[6])) + "%");
							vo.setQty7(checkStringInteger(Double.toString(ratQty[7])) + "%");
							vo.setQty8(checkStringInteger(Double.toString(ratQty[8])) + "%");
							vo.setQty9(checkStringInteger(Double.toString(ratQty[9])) + "%");
							vo.setQty10(checkStringInteger(Double.toString(ratQty[10])) + "%");
							vo.setQty11(checkStringInteger(Double.toString(ratQty[11])) + "%");
							vo.setQty12(checkStringInteger(Double.toString(ratQty[12])) + "%");
							vo.setQty13(checkStringInteger(Double.toString(ratQty[13])) + "%");
							vo.setQty14(checkStringInteger(Double.toString(ratQty[14])) + "%");
							vo.setQty15(checkStringInteger(Double.toString(ratQty[15])) + "%");
							vo.setQty16(checkStringInteger(Double.toString(ratQty[16])) + "%");
							vo.setQty17(checkStringInteger(Double.toString(ratQty[17])) + "%");
							vo.setQty18(checkStringInteger(Double.toString(ratQty[18])) + "%");
							vo.setQty19(checkStringInteger(Double.toString(ratQty[19])) + "%");
							vo.setQty20(checkStringInteger(Double.toString(ratQty[20])) + "%");
							vo.setQty21(checkStringInteger(Double.toString(ratQty[21])) + "%");
							vo.setQty22(checkStringInteger(Double.toString(ratQty[22])) + "%");
							vo.setQty23(checkStringInteger(Double.toString(ratQty[23])) + "%");
							vo.setQty24(checkStringInteger(Double.toString(ratQty[24])) + "%");
							vo.setQty25(checkStringInteger(Double.toString(ratQty[25])) + "%");
							vo.setQty26(checkStringInteger(Double.toString(ratQty[26])) + "%");
							vo.setQty27(checkStringInteger(Double.toString(ratQty[27])) + "%");
							vo.setQty28(checkStringInteger(Double.toString(ratQty[28])) + "%");
							vo.setQty29(checkStringInteger(Double.toString(ratQty[29])) + "%");
							vo.setQty30(checkStringInteger(Double.toString(ratQty[30])) + "%");
							vo.setQty31(checkStringInteger(Double.toString(ratQty[31])) + "%");
							vo.setQty32(checkStringInteger(Double.toString(ratQty[32])) + "%");
							vo.setQty33(checkStringInteger(Double.toString(ratQty[33])) + "%");
							vo.setQty34(checkStringInteger(Double.toString(ratQty[34])) + "%");
							vo.setQty35(checkStringInteger(Double.toString(ratQty[35])) + "%");
							vo.setQty36(checkStringInteger(Double.toString(ratQty[36])) + "%");
							vo.setQty37(checkStringInteger(Double.toString(ratQty[37])) + "%");
							vo.setQty38(checkStringInteger(Double.toString(ratQty[38])) + "%");
							vo.setQty39(checkStringInteger(Double.toString(ratQty[39])) + "%");
							list2.add(x, vo);
							x++;
						} // end if
	
						xTempVal = strLocCd;
					} // end for
	
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(xTempVal);
					vo.setVvd("");
					vo.setDivision("Total");
					vo.setIbflag("Vol");
					vo.setTotal(listSum.get(y).getTotal());
					vo.setQty0(listSum.get(y).getQty0());
					vo.setQty1(listSum.get(y).getQty1());
					vo.setQty2(listSum.get(y).getQty2());
					vo.setQty3(listSum.get(y).getQty3());
					vo.setQty4(listSum.get(y).getQty4());
					vo.setQty5(listSum.get(y).getQty5());
					vo.setQty6(listSum.get(y).getQty6());
					vo.setQty7(listSum.get(y).getQty7());
					vo.setQty8(listSum.get(y).getQty8());
					vo.setQty9(listSum.get(y).getQty9());
					vo.setQty10(listSum.get(y).getQty10());
					vo.setQty11(listSum.get(y).getQty11());
					vo.setQty12(listSum.get(y).getQty12());
					vo.setQty13(listSum.get(y).getQty13());
					vo.setQty14(listSum.get(y).getQty14());
					vo.setQty15(listSum.get(y).getQty15());
					vo.setQty16(listSum.get(y).getQty16());
					vo.setQty17(listSum.get(y).getQty17());
					vo.setQty18(listSum.get(y).getQty18());
					vo.setQty19(listSum.get(y).getQty19());
					vo.setQty20(listSum.get(y).getQty20());
					vo.setQty21(listSum.get(y).getQty21());
					vo.setQty22(listSum.get(y).getQty22());
					vo.setQty23(listSum.get(y).getQty23());
					vo.setQty24(listSum.get(y).getQty24());
					vo.setQty25(listSum.get(y).getQty25());
					vo.setQty26(listSum.get(y).getQty26());
					vo.setQty27(listSum.get(y).getQty27());
					vo.setQty28(listSum.get(y).getQty28());
					vo.setQty29(listSum.get(y).getQty29());
					vo.setQty30(listSum.get(y).getQty30());
					vo.setQty31(listSum.get(y).getQty31());
					vo.setQty32(listSum.get(y).getQty32());
					vo.setQty33(listSum.get(y).getQty33());
					vo.setQty34(listSum.get(y).getQty34());
					vo.setQty35(listSum.get(y).getQty35());
					vo.setQty36(listSum.get(y).getQty36());
					vo.setQty37(listSum.get(y).getQty37());
					vo.setQty38(listSum.get(y).getQty38());
					vo.setQty39(listSum.get(y).getQty39());
					list2.add(x, vo);
					x++;
	
					volQtyT[0] = Double.parseDouble(listSum.get(y).getQty0());
					volQtyT[1] = Double.parseDouble(listSum.get(y).getQty1());
					volQtyT[2] = Double.parseDouble(listSum.get(y).getQty2());
					volQtyT[3] = Double.parseDouble(listSum.get(y).getQty3());
					volQtyT[4] = Double.parseDouble(listSum.get(y).getQty4());
					volQtyT[5] = Double.parseDouble(listSum.get(y).getQty5());
					volQtyT[6] = Double.parseDouble(listSum.get(y).getQty6());
					volQtyT[7] = Double.parseDouble(listSum.get(y).getQty7());
					volQtyT[8] = Double.parseDouble(listSum.get(y).getQty8());
					volQtyT[9] = Double.parseDouble(listSum.get(y).getQty9());
					volQtyT[10] = Double.parseDouble(listSum.get(y).getQty10());
					volQtyT[11] = Double.parseDouble(listSum.get(y).getQty11());
					volQtyT[12] = Double.parseDouble(listSum.get(y).getQty12());
					volQtyT[13] = Double.parseDouble(listSum.get(y).getQty13());
					volQtyT[14] = Double.parseDouble(listSum.get(y).getQty14());
					volQtyT[15] = Double.parseDouble(listSum.get(y).getQty15());
					volQtyT[16] = Double.parseDouble(listSum.get(y).getQty16());
					volQtyT[17] = Double.parseDouble(listSum.get(y).getQty17());
					volQtyT[18] = Double.parseDouble(listSum.get(y).getQty18());
					volQtyT[19] = Double.parseDouble(listSum.get(y).getQty19());
					volQtyT[20] = Double.parseDouble(listSum.get(y).getQty20());
					volQtyT[21] = Double.parseDouble(listSum.get(y).getQty21());
					volQtyT[22] = Double.parseDouble(listSum.get(y).getQty22());
					volQtyT[23] = Double.parseDouble(listSum.get(y).getQty23());
					volQtyT[24] = Double.parseDouble(listSum.get(y).getQty24());
					volQtyT[25] = Double.parseDouble(listSum.get(y).getQty25());
					volQtyT[26] = Double.parseDouble(listSum.get(y).getQty26());
					volQtyT[27] = Double.parseDouble(listSum.get(y).getQty27());
					volQtyT[28] = Double.parseDouble(listSum.get(y).getQty28());
					volQtyT[29] = Double.parseDouble(listSum.get(y).getQty29());
					volQtyT[30] = Double.parseDouble(listSum.get(y).getQty30());
					volQtyT[31] = Double.parseDouble(listSum.get(y).getQty31());
					volQtyT[32] = Double.parseDouble(listSum.get(y).getQty32());
					volQtyT[33] = Double.parseDouble(listSum.get(y).getQty33());
					volQtyT[34] = Double.parseDouble(listSum.get(y).getQty34());
					volQtyT[35] = Double.parseDouble(listSum.get(y).getQty35());
					volQtyT[36] = Double.parseDouble(listSum.get(y).getQty36());
					volQtyT[37] = Double.parseDouble(listSum.get(y).getQty37());
					volQtyT[38] = Double.parseDouble(listSum.get(y).getQty38());
					volQtyT[39] = Double.parseDouble(listSum.get(y).getQty39());
					volQtyT[40] = Double.parseDouble(listSum.get(y).getTotal());
	
					for (int m = 0; m < volQtyT.length; m++) {
						ratQty[m] = Math.round((volQtyT[m] / volQty[40]) * 100);
					}
	
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd(xTempVal);
					vo.setVvd("");
					vo.setDivision("Total");
					vo.setIbflag("Ratio");
					vo.setTotal(checkStringInteger(Double.toString(ratQty[40])) + "%");
					vo.setQty0(checkStringInteger(Double.toString(ratQty[0])) + "%");
					vo.setQty1(checkStringInteger(Double.toString(ratQty[1])) + "%");
					vo.setQty2(checkStringInteger(Double.toString(ratQty[2])) + "%");
					vo.setQty3(checkStringInteger(Double.toString(ratQty[3])) + "%");
					vo.setQty4(checkStringInteger(Double.toString(ratQty[4])) + "%");
					vo.setQty5(checkStringInteger(Double.toString(ratQty[5])) + "%");
					vo.setQty6(checkStringInteger(Double.toString(ratQty[6])) + "%");
					vo.setQty7(checkStringInteger(Double.toString(ratQty[7])) + "%");
					vo.setQty8(checkStringInteger(Double.toString(ratQty[8])) + "%");
					vo.setQty9(checkStringInteger(Double.toString(ratQty[9])) + "%");
					vo.setQty10(checkStringInteger(Double.toString(ratQty[10])) + "%");
					vo.setQty11(checkStringInteger(Double.toString(ratQty[11])) + "%");
					vo.setQty12(checkStringInteger(Double.toString(ratQty[12])) + "%");
					vo.setQty13(checkStringInteger(Double.toString(ratQty[13])) + "%");
					vo.setQty14(checkStringInteger(Double.toString(ratQty[14])) + "%");
					vo.setQty15(checkStringInteger(Double.toString(ratQty[15])) + "%");
					vo.setQty16(checkStringInteger(Double.toString(ratQty[16])) + "%");
					vo.setQty17(checkStringInteger(Double.toString(ratQty[17])) + "%");
					vo.setQty18(checkStringInteger(Double.toString(ratQty[18])) + "%");
					vo.setQty19(checkStringInteger(Double.toString(ratQty[19])) + "%");
					vo.setQty20(checkStringInteger(Double.toString(ratQty[20])) + "%");
					vo.setQty21(checkStringInteger(Double.toString(ratQty[21])) + "%");
					vo.setQty22(checkStringInteger(Double.toString(ratQty[22])) + "%");
					vo.setQty23(checkStringInteger(Double.toString(ratQty[23])) + "%");
					vo.setQty24(checkStringInteger(Double.toString(ratQty[24])) + "%");
					vo.setQty25(checkStringInteger(Double.toString(ratQty[25])) + "%");
					vo.setQty26(checkStringInteger(Double.toString(ratQty[26])) + "%");
					vo.setQty27(checkStringInteger(Double.toString(ratQty[27])) + "%");
					vo.setQty28(checkStringInteger(Double.toString(ratQty[28])) + "%");
					vo.setQty29(checkStringInteger(Double.toString(ratQty[29])) + "%");
					vo.setQty30(checkStringInteger(Double.toString(ratQty[30])) + "%");
					vo.setQty31(checkStringInteger(Double.toString(ratQty[31])) + "%");
					vo.setQty32(checkStringInteger(Double.toString(ratQty[32])) + "%");
					vo.setQty33(checkStringInteger(Double.toString(ratQty[33])) + "%");
					vo.setQty34(checkStringInteger(Double.toString(ratQty[34])) + "%");
					vo.setQty35(checkStringInteger(Double.toString(ratQty[35])) + "%");
					vo.setQty36(checkStringInteger(Double.toString(ratQty[36])) + "%");
					vo.setQty37(checkStringInteger(Double.toString(ratQty[37])) + "%");
					vo.setQty38(checkStringInteger(Double.toString(ratQty[38])) + "%");
					vo.setQty39(checkStringInteger(Double.toString(ratQty[39])) + "%");
	
					list2.add(x, vo);
					x++;
	
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd("G.Total");
					vo.setVvd("");
					vo.setDivision("");
					vo.setIbflag("Vol");
					vo.setTotal(Double.toString(volQty[40]));
					vo.setQty0(Double.toString(volQty[0]));
					vo.setQty1(Double.toString(volQty[1]));
					vo.setQty2(Double.toString(volQty[2]));
					vo.setQty3(Double.toString(volQty[3]));
					vo.setQty4(Double.toString(volQty[4]));
					vo.setQty5(Double.toString(volQty[5]));
					vo.setQty6(Double.toString(volQty[6]));
					vo.setQty7(Double.toString(volQty[7]));
					vo.setQty8(Double.toString(volQty[8]));
					vo.setQty9(Double.toString(volQty[9]));
					vo.setQty10(Double.toString(volQty[10]));
					vo.setQty11(Double.toString(volQty[11]));
					vo.setQty12(Double.toString(volQty[12]));
					vo.setQty13(Double.toString(volQty[13]));
					vo.setQty14(Double.toString(volQty[14]));
					vo.setQty15(Double.toString(volQty[15]));
					vo.setQty16(Double.toString(volQty[16]));
					vo.setQty17(Double.toString(volQty[17]));
					vo.setQty18(Double.toString(volQty[18]));
					vo.setQty19(Double.toString(volQty[19]));
					vo.setQty20(Double.toString(volQty[20]));
					vo.setQty21(Double.toString(volQty[21]));
					vo.setQty22(Double.toString(volQty[22]));
					vo.setQty23(Double.toString(volQty[23]));
					vo.setQty24(Double.toString(volQty[24]));
					vo.setQty25(Double.toString(volQty[25]));
					vo.setQty26(Double.toString(volQty[26]));
					vo.setQty27(Double.toString(volQty[27]));
					vo.setQty28(Double.toString(volQty[28]));
					vo.setQty29(Double.toString(volQty[29]));
					vo.setQty30(Double.toString(volQty[30]));
					vo.setQty31(Double.toString(volQty[31]));
					vo.setQty32(Double.toString(volQty[32]));
					vo.setQty33(Double.toString(volQty[33]));
					vo.setQty34(Double.toString(volQty[34]));
					vo.setQty35(Double.toString(volQty[35]));
					vo.setQty36(Double.toString(volQty[36]));
					vo.setQty37(Double.toString(volQty[37]));
					vo.setQty38(Double.toString(volQty[38]));
					vo.setQty39(Double.toString(volQty[39]));
					list2.add(x, vo);
					x++;
	
					vo = new QuantityByTypeSizeVO();
					vo.setLocCd("G.Total");
					vo.setVvd("");
					vo.setDivision("");
					vo.setIbflag("Ratio");
					vo.setTotal(setRatio(volQty[40]));
					vo.setQty0(Double.toString(Math.round((volQty[0] / volQty[40]) * 100)) + "%");
					vo.setQty1(Double.toString(Math.round((volQty[1] / volQty[40]) * 100)) + "%");
					vo.setQty2(Double.toString(Math.round((volQty[2] / volQty[40]) * 100)) + "%");
					vo.setQty3(Double.toString(Math.round((volQty[3] / volQty[40]) * 100)) + "%");
					vo.setQty4(Double.toString(Math.round((volQty[4] / volQty[40]) * 100)) + "%");
					vo.setQty5(Double.toString(Math.round((volQty[5] / volQty[40]) * 100)) + "%");
					vo.setQty6(Double.toString(Math.round((volQty[6] / volQty[40]) * 100)) + "%");
					vo.setQty7(Double.toString(Math.round((volQty[7] / volQty[40]) * 100)) + "%");
					vo.setQty8(Double.toString(Math.round((volQty[8] / volQty[40]) * 100)) + "%");
					vo.setQty9(Double.toString(Math.round((volQty[9] / volQty[40]) * 100)) + "%");
					vo.setQty10(Double.toString(Math.round((volQty[10] / volQty[40]) * 100)) + "%");
					vo.setQty11(Double.toString(Math.round((volQty[11] / volQty[40]) * 100)) + "%");
					vo.setQty12(Double.toString(Math.round((volQty[12] / volQty[40]) * 100)) + "%");
					vo.setQty13(Double.toString(Math.round((volQty[13] / volQty[40]) * 100)) + "%");
					vo.setQty14(Double.toString(Math.round((volQty[14] / volQty[40]) * 100)) + "%");
					vo.setQty15(Double.toString(Math.round((volQty[15] / volQty[40]) * 100)) + "%");
					vo.setQty16(Double.toString(Math.round((volQty[16] / volQty[40]) * 100)) + "%");
					vo.setQty17(Double.toString(Math.round((volQty[17] / volQty[40]) * 100)) + "%");
					vo.setQty18(Double.toString(Math.round((volQty[18] / volQty[40]) * 100)) + "%");
					vo.setQty19(Double.toString(Math.round((volQty[19] / volQty[40]) * 100)) + "%");
					vo.setQty20(Double.toString(Math.round((volQty[20] / volQty[40]) * 100)) + "%");
					vo.setQty21(Double.toString(Math.round((volQty[21] / volQty[40]) * 100)) + "%");
					vo.setQty22(Double.toString(Math.round((volQty[22] / volQty[40]) * 100)) + "%");
					vo.setQty23(Double.toString(Math.round((volQty[23] / volQty[40]) * 100)) + "%");
					vo.setQty24(Double.toString(Math.round((volQty[24] / volQty[40]) * 100)) + "%");
					vo.setQty25(Double.toString(Math.round((volQty[25] / volQty[40]) * 100)) + "%");
					vo.setQty26(Double.toString(Math.round((volQty[26] / volQty[40]) * 100)) + "%");
					vo.setQty27(Double.toString(Math.round((volQty[27] / volQty[40]) * 100)) + "%");
					vo.setQty28(Double.toString(Math.round((volQty[28] / volQty[40]) * 100)) + "%");
					vo.setQty29(Double.toString(Math.round((volQty[29] / volQty[40]) * 100)) + "%");
					vo.setQty30(Double.toString(Math.round((volQty[30] / volQty[40]) * 100)) + "%");
					vo.setQty31(Double.toString(Math.round((volQty[31] / volQty[40]) * 100)) + "%");
					vo.setQty32(Double.toString(Math.round((volQty[32] / volQty[40]) * 100)) + "%");
					vo.setQty33(Double.toString(Math.round((volQty[33] / volQty[40]) * 100)) + "%");
					vo.setQty34(Double.toString(Math.round((volQty[34] / volQty[40]) * 100)) + "%");
					vo.setQty35(Double.toString(Math.round((volQty[35] / volQty[40]) * 100)) + "%");
					vo.setQty36(Double.toString(Math.round((volQty[36] / volQty[40]) * 100)) + "%");
					vo.setQty37(Double.toString(Math.round((volQty[37] / volQty[40]) * 100)) + "%");
					vo.setQty38(Double.toString(Math.round((volQty[38] / volQty[40]) * 100)) + "%");
					vo.setQty39(Double.toString(Math.round((volQty[39] / volQty[40]) * 100)) + "%");
					list2.add(x, vo);
					x++;
				} // if( list.size() > 0 ){
			//	log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtBC.searchCargoFlowMap 1029 End");
				return list2;
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Cargo Flow Map Retrieve" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Cargo Flow Map Retrieve" })
					.getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Previous Weeks] <br>
	 * 
	 * @param searchOptionByFromToVO
	 * @return List<SearchBatchJobStatusVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<SearchBatchJobStatusVO> searchPreviousWeeks(SearchOptionByFromToVO searchOptionByFromToVO)
			throws EventException {
		try {
			return dbDao.searchPreviousWeeks(searchOptionByFromToVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Batch Job Status] <br>
	 * 
	 * @param searchOptionByFromToVO
	 * @return List<SearchBatchJobStatusVO>
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<SearchBatchJobStatusVO> searchBatchJobStatus(SearchOptionByFromToVO searchOptionByFromToVO)
			throws EventException {
		try {
			return dbDao.searchBatchJobStatus(searchOptionByFromToVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieving [Vessel MatchBack] <br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @param account
	 * @return String
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public String searchMBByVessel(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO, SignOnUserAccount account)
			throws EventException {
		EQMatchBackNLoadFactorMgtBackEndJob backEndJob = new EQMatchBackNLoadFactorMgtBackEndJob();
		backEndJob.setJobType("searchMBByVessel");
		backEndJob.setSearchOptionByTradeLaneVvdVO(searchOptionByTradeLaneVvdVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),
					"Match-Back by Vessel Retrieve BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Vessel Retrieve BackEndJob" }).getMessage(), ex);
		}

	}

	/**
	 * Retrieving [MatchBack By Vessel Lane List] By Trade <br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @return String[]
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public String[] searchMBByVesselLaneListByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO)
			throws EventException {
		String[] arrLane = null;
		try {
			arrLane = dbDao.searchMBByVesselLaneListByTrade(searchOptionByTradeLaneVvdVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Vessel LaneListByTrade" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Vessel LaneListByTrade" }).getMessage(), ex);
		}
		return arrLane;
	}

	/**
	 * Retrieving [MatchBack By Vessel VVD List] By Trade,Lane <br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @return String[]
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public String[] searchMBByVesselVvdListByTradeLane(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO)
			throws EventException {
		String[] arrVvd = null;
		try {
			arrVvd = dbDao.searchMBByVesselVvdListByTradeLane(searchOptionByTradeLaneVvdVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Vessel VvdListByTradeLane" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Match-Back by Vessel VvdListByTradeLane" }).getMessage(), ex);
		}
		return arrVvd;
	}

	/**
	 * return ratio <br>
	 * 
	 * @param arg
	 * @return String
	 */
	private String setRatio(double arg) {
		if (arg > 0) {
			return "100%";
		}
		else {
			return "0%";
		}
	}

	/**
	 * return string value after deleting "." <br>
	 * 
	 * @param xTempVal
	 * @return String
	 */
	private String checkStringInteger(String xTempVal) {
		String xVal01 = xTempVal;
		if (xVal01 == null || xVal01.equals("")) {
			xVal01 = "0";
		}
		if (xVal01.indexOf(".") != -1) {
			xVal01 = xVal01.substring(0, xVal01.indexOf("."));
		}
		return xVal01;
	}

	/**
	 * return ratio <br>
	 * 
	 * @param innVal
	 * @param outVal
	 * @return String
	 * 
	 *         private String calcRationFloat( double innVal, double outVal ){
	 *         String rtnStrVal = "0"; NumberFormat nf =
	 *         NumberFormat.getInstance(); nf.setMaximumFractionDigits(1);
	 *         nf.setMinimumFractionDigits(1); if ( (innVal - outVal) >= 0 ){ if
	 *         ( innVal == 0 ){ rtnStrVal = "0" ; }else{ rtnStrVal = nf.format(
	 *         ( outVal / innVal ) * 100 ) +""; } }else{ if ( outVal == 0 ){
	 *         rtnStrVal = "0" ; }else{ rtnStrVal = nf.format( ( innVal / outVal
	 *         ) * (-1) * 100 ) +""; } } return
	 *         checkStringRemoveZero(rtnStrVal); }
	 */
	/*
	 * 
	 * TEU Total : calculation logic = Full TEU Sum { 20’+ 2 ( 40’+ H/C’+ 45’) } + MTY TEU
	 * Sum { 20’+ 2 ( 40’+ H/C’+ 45’) }
	 * 
	 * converting ft value into TEU using 40ft(40’/ HC/ 45’) x2, putting in action below logic Full = If ( Full I/B vol >
	 * Full O/B vol , + Full O/B ÷ Full I/B , - Full I/B ÷ Full O/B ) EQ = If (
	 * Full & MTY I/B vol > Full & MTY O/B vol , + Full & MTY O/B ÷ Full & MTY
	 * I/B , - Full & MTY I/B ÷ Full & MTY O/B )
	 */
	/**
	 * return 0 in case of 0.0 <br>
	 * 
	 * @param xTempVal
	 * @return String
	 * 
	 *         private String checkStringRemoveZero( String xTempVal ){ String
	 *         xVal01 = xTempVal; // log.debug("@@@@@@@ xVal01 [" + xVal01 +
	 *         "]"); String xVal02 = ""; if ( xVal01 == null ||
	 *         xVal01.equals("") ) { xVal01 = "0"; } if ( xVal01.equals("-0.0")
	 *         ) { xVal01 = "0"; } if ( xVal01.indexOf(".") != -1 ) { xVal02 =
	 *         xVal01.substring( xVal01.indexOf(".")+1 , xVal01.length() ); //
	 *         log.debug("@@@@@@@ xVal01.substring( " + xVal01.indexOf(".") +
	 *         " , " + xVal01.length() + " ) [" + xVal01.substring(
	 *         xVal01.indexOf(".") , xVal01.length() ) + "]"); if (
	 *         xVal02.equals("0") ) { xVal01 = xVal01.substring( 0 ,
	 *         xVal01.indexOf(".") ); } } // log.debug("@@@@@@@ "); return
	 *         xVal01; }
	 */
	/**
	 * Retrieving PortMBVVD list <br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @param lane
	 * @return String[]
	 * @exception EventException
	 * @exception DAOException
	 * @exception Exception
	 */
	public String[] searchPortMBVVDList(String period, String from, String to, String pol, String lane)
			throws EventException {
		String[] arrVvd = null;
		try {
			arrVvd = dbDao.searchPortMBVVDList(period, from, to, pol, lane);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "MB VVD List Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "MB VVD List Retrieve" }).getMessage(), ex);
		}
		return arrVvd;
	}

	/**
	 * retrieving status value for BackEndJob result <br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
	}
}
