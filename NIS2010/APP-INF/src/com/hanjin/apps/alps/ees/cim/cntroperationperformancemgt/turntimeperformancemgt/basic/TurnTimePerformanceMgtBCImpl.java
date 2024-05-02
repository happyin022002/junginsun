/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ITurnTimePerformanceFinderBCBCImpl.java
 *@FileTitle : Turn Time by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.04.24 박광석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration.TurnTimePerformanceMgtDBDAO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMvmtCntrListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * - ALPS-CNTROperatioNPerformanceMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Prak Kwang Seok
 * @see TurnTimePerformanceMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TurnTimePerformanceMgtBCImpl extends BasicCommandSupport implements TurnTimePerformanceMgtBC {

	// Database Access Object
	private transient TurnTimePerformanceMgtDBDAO dbDao = null;
	private static String sTime = "T/Time";

	/**
	 * TurnTimePerformanceMgtBCImpl 객체 생성<br>
	 * TurnTimePerformanceMgtDBDAO를 생성한다.<br>
	 */
	public TurnTimePerformanceMgtBCImpl() {
		dbDao = new TurnTimePerformanceMgtDBDAO();
	}

	/**
	 * PortTurnTimeListByPort Detail Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortDetail(
			TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException {
		try {

			return dbDao.searchPortTurnTimeListByPortDetail(tTSearchOptionIngereralVo);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Port TurnTime Detail Retrieve" })
					.getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Port TurnTime Detail Retrieve" })
					.getMessage(), ex);
		}

	}

	/**
	 * PortTurnTimeListByPort Summary Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortSummary(
			TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException {
		try {
			List<TurnTimeByTypeSizeVO> list1 = dbDao.searchPortTurnTimeListByPortSummary(tTSearchOptionIngereralVo);

			List<TurnTimeByTypeSizeVO> list2 = new ArrayList<TurnTimeByTypeSizeVO>();

			TurnTimeByTypeSizeVO vo = null;

			double[] cntr = new double[40];

			double[] days = new double[40];

			double[] ttime = new double[40];

			int x = 0;
			if (x == 0) { // 화면의 TP/SZ 에 따라 컨테이너 타입 표시 여부
				vo = new TurnTimeByTypeSizeVO();

				vo.setPol(list1.get(x).getPol());
				vo.setTotal(list1.get(x).getTotal());

				vo.setCount01(list1.get(x).getCount01());
				vo.setCount02(list1.get(x).getCount02());
				vo.setCount03(list1.get(x).getCount03());
				vo.setCount04(list1.get(x).getCount04());
				vo.setCount05(list1.get(x).getCount05());
				vo.setCount06(list1.get(x).getCount06());
				vo.setCount07(list1.get(x).getCount07());
				vo.setCount08(list1.get(x).getCount08());
				vo.setCount09(list1.get(x).getCount09());
				vo.setCount10(list1.get(x).getCount10());
				vo.setCount11(list1.get(x).getCount11());
				vo.setCount12(list1.get(x).getCount12());
				vo.setCount13(list1.get(x).getCount13());
				vo.setCount14(list1.get(x).getCount14());
				vo.setCount15(list1.get(x).getCount15());
				vo.setCount16(list1.get(x).getCount16());
				vo.setCount17(list1.get(x).getCount17());
				vo.setCount18(list1.get(x).getCount18());
				vo.setCount19(list1.get(x).getCount19());
				vo.setCount20(list1.get(x).getCount20());
				vo.setCount21(list1.get(x).getCount21());
				vo.setCount22(list1.get(x).getCount22());
				vo.setCount23(list1.get(x).getCount23());
				vo.setCount24(list1.get(x).getCount24());
				vo.setCount25(list1.get(x).getCount25());
				vo.setCount26(list1.get(x).getCount26());
				vo.setCount27(list1.get(x).getCount27());
				vo.setCount28(list1.get(x).getCount28());
				vo.setCount29(list1.get(x).getCount29());
				vo.setCount30(list1.get(x).getCount30());
				vo.setCount31(list1.get(x).getCount31());
				vo.setCount32(list1.get(x).getCount32());
				vo.setCount33(list1.get(x).getCount33());
				vo.setCount34(list1.get(x).getCount34());
				vo.setCount35(list1.get(x).getCount35());
				vo.setCount36(list1.get(x).getCount36());
				vo.setCount37(list1.get(x).getCount37());
				vo.setCount38(list1.get(x).getCount38());
				vo.setCount39(list1.get(x).getCount39());
				vo.setCount40(list1.get(x).getCount40());
				list2.add(x, vo);
				x++;
			}

			for (int i = 1; i < list1.size(); i++) {
				int k = 0;

				String strPol = list1.get(i).getPol();
				String strDivision = list1.get(i).getEtc();

				if (strDivision.equals(sTime)) {
					k = 2;
				}

				// Turn Time Row 이면서 총합 Row 가 아니면...
				if (!"".equals(strPol) && strDivision.equals(sTime)) { 

					vo = new TurnTimeByTypeSizeVO();

					vo.setPol(list1.get(i).getPol());
					vo.setTotal(list1.get(i).getTotal());

					vo.setCount01(list1.get(i).getCount01());
					vo.setCount02(list1.get(i).getCount02());
					vo.setCount03(list1.get(i).getCount03());
					vo.setCount04(list1.get(i).getCount04());
					vo.setCount05(list1.get(i).getCount05());
					vo.setCount06(list1.get(i).getCount06());
					vo.setCount07(list1.get(i).getCount07());
					vo.setCount08(list1.get(i).getCount08());
					vo.setCount09(list1.get(i).getCount09());
					vo.setCount10(list1.get(i).getCount10());
					vo.setCount11(list1.get(i).getCount11());
					vo.setCount12(list1.get(i).getCount12());
					vo.setCount13(list1.get(i).getCount13());
					vo.setCount14(list1.get(i).getCount14());
					vo.setCount15(list1.get(i).getCount15());
					vo.setCount16(list1.get(i).getCount16());
					vo.setCount17(list1.get(i).getCount17());
					vo.setCount18(list1.get(i).getCount18());
					vo.setCount19(list1.get(i).getCount19());
					vo.setCount20(list1.get(i).getCount20());
					vo.setCount21(list1.get(i).getCount21());
					vo.setCount22(list1.get(i).getCount22());
					vo.setCount23(list1.get(i).getCount23());
					vo.setCount24(list1.get(i).getCount24());
					vo.setCount25(list1.get(i).getCount25());
					vo.setCount26(list1.get(i).getCount26());
					vo.setCount27(list1.get(i).getCount27());
					vo.setCount28(list1.get(i).getCount28());
					vo.setCount29(list1.get(i).getCount29());
					vo.setCount30(list1.get(i).getCount30());
					vo.setCount31(list1.get(i).getCount31());
					vo.setCount32(list1.get(i).getCount32());
					vo.setCount33(list1.get(i).getCount33());
					vo.setCount34(list1.get(i).getCount34());
					vo.setCount35(list1.get(i).getCount35());
					vo.setCount36(list1.get(i).getCount36());
					vo.setCount37(list1.get(i).getCount37());
					vo.setCount38(list1.get(i).getCount38());
					vo.setCount39(list1.get(i).getCount39());
					vo.setCount40(list1.get(i).getCount40());
					list2.add(x, vo);
					x++;
				}

				if ("".equals(strPol)) { // 총합 Total

					cntr[0] = Double.parseDouble(list1.get(i - k).getCount01());
					cntr[1] = Double.parseDouble(list1.get(i - k).getCount02());
					cntr[2] = Double.parseDouble(list1.get(i - k).getCount03());
					cntr[3] = Double.parseDouble(list1.get(i - k).getCount04());
					cntr[4] = Double.parseDouble(list1.get(i - k).getCount05());
					cntr[5] = Double.parseDouble(list1.get(i - k).getCount06());
					cntr[6] = Double.parseDouble(list1.get(i - k).getCount07());
					cntr[7] = Double.parseDouble(list1.get(i - k).getCount08());
					cntr[8] = Double.parseDouble(list1.get(i - k).getCount09());
					cntr[9] = Double.parseDouble(list1.get(i - k).getCount10());
					cntr[10] = Double.parseDouble(list1.get(i - k).getCount11());
					cntr[11] = Double.parseDouble(list1.get(i - k).getCount12());
					cntr[12] = Double.parseDouble(list1.get(i - k).getCount13());
					cntr[13] = Double.parseDouble(list1.get(i - k).getCount14());
					cntr[14] = Double.parseDouble(list1.get(i - k).getCount15());
					cntr[15] = Double.parseDouble(list1.get(i - k).getCount16());
					cntr[16] = Double.parseDouble(list1.get(i - k).getCount17());
					cntr[17] = Double.parseDouble(list1.get(i - k).getCount18());
					cntr[18] = Double.parseDouble(list1.get(i - k).getCount19());
					cntr[19] = Double.parseDouble(list1.get(i - k).getCount20());
					cntr[20] = Double.parseDouble(list1.get(i - k).getCount21());
					cntr[21] = Double.parseDouble(list1.get(i - k).getCount22());
					cntr[22] = Double.parseDouble(list1.get(i - k).getCount23());
					cntr[23] = Double.parseDouble(list1.get(i - k).getCount24());
					cntr[24] = Double.parseDouble(list1.get(i - k).getCount25());
					cntr[25] = Double.parseDouble(list1.get(i - k).getCount26());
					cntr[26] = Double.parseDouble(list1.get(i - k).getCount27());
					cntr[27] = Double.parseDouble(list1.get(i - k).getCount28());
					cntr[28] = Double.parseDouble(list1.get(i - k).getCount29());
					cntr[29] = Double.parseDouble(list1.get(i - k).getCount30());
					cntr[30] = Double.parseDouble(list1.get(i - k).getCount31());
					cntr[31] = Double.parseDouble(list1.get(i - k).getCount32());
					cntr[32] = Double.parseDouble(list1.get(i - k).getCount33());
					cntr[33] = Double.parseDouble(list1.get(i - k).getCount34());
					cntr[34] = Double.parseDouble(list1.get(i - k).getCount35());
					cntr[35] = Double.parseDouble(list1.get(i - k).getCount36());
					cntr[36] = Double.parseDouble(list1.get(i - k).getCount37());
					cntr[37] = Double.parseDouble(list1.get(i - k).getCount38());
					cntr[38] = Double.parseDouble(list1.get(i - k).getCount39());
					cntr[39] = Double.parseDouble(list1.get(i - k).getCount40());

					days[0] = Double.parseDouble(list1.get(i - (k - 1)).getCount01());
					days[1] = Double.parseDouble(list1.get(i - (k - 1)).getCount02());
					days[2] = Double.parseDouble(list1.get(i - (k - 1)).getCount03());
					days[3] = Double.parseDouble(list1.get(i - (k - 1)).getCount04());
					days[4] = Double.parseDouble(list1.get(i - (k - 1)).getCount05());
					days[5] = Double.parseDouble(list1.get(i - (k - 1)).getCount06());
					days[6] = Double.parseDouble(list1.get(i - (k - 1)).getCount07());
					days[7] = Double.parseDouble(list1.get(i - (k - 1)).getCount08());
					days[8] = Double.parseDouble(list1.get(i - (k - 1)).getCount09());
					days[9] = Double.parseDouble(list1.get(i - (k - 1)).getCount10());
					days[10] = Double.parseDouble(list1.get(i - (k - 1)).getCount11());
					days[11] = Double.parseDouble(list1.get(i - (k - 1)).getCount12());
					days[12] = Double.parseDouble(list1.get(i - (k - 1)).getCount13());
					days[13] = Double.parseDouble(list1.get(i - (k - 1)).getCount14());
					days[14] = Double.parseDouble(list1.get(i - (k - 1)).getCount15());
					days[15] = Double.parseDouble(list1.get(i - (k - 1)).getCount16());
					days[16] = Double.parseDouble(list1.get(i - (k - 1)).getCount17());
					days[17] = Double.parseDouble(list1.get(i - (k - 1)).getCount18());
					days[18] = Double.parseDouble(list1.get(i - (k - 1)).getCount19());
					days[19] = Double.parseDouble(list1.get(i - (k - 1)).getCount20());
					days[20] = Double.parseDouble(list1.get(i - (k - 1)).getCount21());
					days[21] = Double.parseDouble(list1.get(i - (k - 1)).getCount22());
					days[22] = Double.parseDouble(list1.get(i - (k - 1)).getCount23());
					days[23] = Double.parseDouble(list1.get(i - (k - 1)).getCount24());
					days[24] = Double.parseDouble(list1.get(i - (k - 1)).getCount25());
					days[25] = Double.parseDouble(list1.get(i - (k - 1)).getCount26());
					days[26] = Double.parseDouble(list1.get(i - (k - 1)).getCount27());
					days[27] = Double.parseDouble(list1.get(i - (k - 1)).getCount28());
					days[28] = Double.parseDouble(list1.get(i - (k - 1)).getCount29());
					days[29] = Double.parseDouble(list1.get(i - (k - 1)).getCount30());
					days[30] = Double.parseDouble(list1.get(i - (k - 1)).getCount31());
					days[31] = Double.parseDouble(list1.get(i - (k - 1)).getCount32());
					days[32] = Double.parseDouble(list1.get(i - (k - 1)).getCount33());
					days[33] = Double.parseDouble(list1.get(i - (k - 1)).getCount34());
					days[34] = Double.parseDouble(list1.get(i - (k - 1)).getCount35());
					days[35] = Double.parseDouble(list1.get(i - (k - 1)).getCount36());
					days[36] = Double.parseDouble(list1.get(i - (k - 1)).getCount37());
					days[37] = Double.parseDouble(list1.get(i - (k - 1)).getCount38());
					days[38] = Double.parseDouble(list1.get(i - (k - 1)).getCount39());
					days[39] = Double.parseDouble(list1.get(i - (k - 1)).getCount40());

					if (strDivision.equals(sTime)) {
						for (int m = 0; m < cntr.length; m++) {

							if (cntr[m] > 0) {
								ttime[m] = days[m] / cntr[m]; // Turn Time을 구한다.
							}
							else {
								ttime[m] = 0.0;
							}
						}
						vo = new TurnTimeByTypeSizeVO();
						if ("".equals(strPol)) {
							vo.setPol("Total Average");
						}

						vo.setPol(list1.get(i).getPol());
						vo.setTotal(list1.get(i).getTotal());

						vo.setCount01(Double.toString(ttime[0]));
						vo.setCount02(Double.toString(ttime[1]));
						vo.setCount03(Double.toString(ttime[2]));
						vo.setCount04(Double.toString(ttime[3]));
						vo.setCount05(Double.toString(ttime[4]));
						vo.setCount06(Double.toString(ttime[5]));
						vo.setCount07(Double.toString(ttime[6]));
						vo.setCount08(Double.toString(ttime[7]));
						vo.setCount09(Double.toString(ttime[8]));
						vo.setCount10(Double.toString(ttime[9]));
						vo.setCount11(Double.toString(ttime[10]));
						vo.setCount12(Double.toString(ttime[11]));
						vo.setCount13(Double.toString(ttime[12]));
						vo.setCount14(Double.toString(ttime[13]));
						vo.setCount15(Double.toString(ttime[14]));
						vo.setCount16(Double.toString(ttime[15]));
						vo.setCount17(Double.toString(ttime[16]));
						vo.setCount18(Double.toString(ttime[17]));
						vo.setCount19(Double.toString(ttime[18]));
						vo.setCount20(Double.toString(ttime[19]));
						vo.setCount21(Double.toString(ttime[20]));
						vo.setCount22(Double.toString(ttime[21]));
						vo.setCount23(Double.toString(ttime[22]));
						vo.setCount24(Double.toString(ttime[23]));
						vo.setCount25(Double.toString(ttime[24]));
						vo.setCount26(Double.toString(ttime[25]));
						vo.setCount27(Double.toString(ttime[26]));
						vo.setCount28(Double.toString(ttime[27]));
						vo.setCount29(Double.toString(ttime[28]));
						vo.setCount30(Double.toString(ttime[29]));
						vo.setCount31(Double.toString(ttime[30]));
						vo.setCount32(Double.toString(ttime[31]));
						vo.setCount33(Double.toString(ttime[32]));
						vo.setCount34(Double.toString(ttime[33]));
						vo.setCount35(Double.toString(ttime[34]));
						vo.setCount36(Double.toString(ttime[35]));
						vo.setCount37(Double.toString(ttime[36]));
						vo.setCount38(Double.toString(ttime[37]));
						vo.setCount39(Double.toString(ttime[38]));
						vo.setCount40(Double.toString(ttime[39]));
						list2.add(x, vo);
						x++;
					}
				}
			}

			return list2;

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Port TurnTime Summary Retrieve" })
					.getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Port TurnTime Summary Retrieve" })
					.getMessage(), ex);
		}
	}

	/**
	 * TurnTimeListByLaneVVD Summary Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO >
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDSummary(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException {
		try {
			List<TurnTimeByTypeSizeVO> list1 = dbDao.searchPortTurnTimeListByLaneVVDSummary(tTSearchOptionInGereralVO);

			List<TurnTimeByTypeSizeVO> list2 = new ArrayList<TurnTimeByTypeSizeVO>();

			TurnTimeByTypeSizeVO vo = null;

			double[] cntr = new double[40];

			double[] days = new double[40];

			double[] ttime = new double[40];

			int x = 0;
			if (x == 0) {
				vo = new TurnTimeByTypeSizeVO();

				vo.setVvd(list1.get(x).getVvd());
				vo.setTotal(list1.get(x).getTotal());

				vo.setCount01(list1.get(x).getCount01());
				vo.setCount02(list1.get(x).getCount02());
				vo.setCount03(list1.get(x).getCount03());
				vo.setCount04(list1.get(x).getCount04());
				vo.setCount05(list1.get(x).getCount05());
				vo.setCount06(list1.get(x).getCount06());
				vo.setCount07(list1.get(x).getCount07());
				vo.setCount08(list1.get(x).getCount08());
				vo.setCount09(list1.get(x).getCount09());
				vo.setCount10(list1.get(x).getCount10());
				vo.setCount11(list1.get(x).getCount11());
				vo.setCount12(list1.get(x).getCount12());
				vo.setCount13(list1.get(x).getCount13());
				vo.setCount14(list1.get(x).getCount14());
				vo.setCount15(list1.get(x).getCount15());
				vo.setCount16(list1.get(x).getCount16());
				vo.setCount17(list1.get(x).getCount17());
				vo.setCount18(list1.get(x).getCount18());
				vo.setCount19(list1.get(x).getCount19());
				vo.setCount20(list1.get(x).getCount20());
				vo.setCount21(list1.get(x).getCount21());
				vo.setCount22(list1.get(x).getCount22());
				vo.setCount23(list1.get(x).getCount23());
				vo.setCount24(list1.get(x).getCount24());
				vo.setCount25(list1.get(x).getCount25());
				vo.setCount26(list1.get(x).getCount26());
				vo.setCount27(list1.get(x).getCount27());
				vo.setCount28(list1.get(x).getCount28());
				vo.setCount29(list1.get(x).getCount29());
				vo.setCount30(list1.get(x).getCount30());
				vo.setCount31(list1.get(x).getCount31());
				vo.setCount32(list1.get(x).getCount32());
				vo.setCount33(list1.get(x).getCount33());
				vo.setCount34(list1.get(x).getCount34());
				vo.setCount35(list1.get(x).getCount35());
				vo.setCount36(list1.get(x).getCount36());
				vo.setCount37(list1.get(x).getCount37());
				vo.setCount38(list1.get(x).getCount38());
				vo.setCount39(list1.get(x).getCount39());
				vo.setCount40(list1.get(x).getCount40());
				list2.add(x, vo);
				x++;
			}

			for (int i = 1; i < list1.size(); i++) {
				int k = 0;

				String strVvd = list1.get(i).getVvd();
				String strDivision = list1.get(i).getEtc();

				if (strDivision.equals(sTime)) {
					k = 2;
				}

				if (!"".equals(strVvd) && strDivision.equals(sTime)) {

					vo = new TurnTimeByTypeSizeVO();

					vo.setVvd(list1.get(i).getVvd());
					vo.setTotal(list1.get(i).getTotal());

					vo.setCount01(list1.get(i).getCount01());
					vo.setCount02(list1.get(i).getCount02());
					vo.setCount03(list1.get(i).getCount03());
					vo.setCount04(list1.get(i).getCount04());
					vo.setCount05(list1.get(i).getCount05());
					vo.setCount06(list1.get(i).getCount06());
					vo.setCount07(list1.get(i).getCount07());
					vo.setCount08(list1.get(i).getCount08());
					vo.setCount09(list1.get(i).getCount09());
					vo.setCount10(list1.get(i).getCount10());
					vo.setCount11(list1.get(i).getCount11());
					vo.setCount12(list1.get(i).getCount12());
					vo.setCount13(list1.get(i).getCount13());
					vo.setCount14(list1.get(i).getCount14());
					vo.setCount15(list1.get(i).getCount15());
					vo.setCount16(list1.get(i).getCount16());
					vo.setCount17(list1.get(i).getCount17());
					vo.setCount18(list1.get(i).getCount18());
					vo.setCount19(list1.get(i).getCount19());
					vo.setCount20(list1.get(i).getCount20());
					vo.setCount21(list1.get(i).getCount21());
					vo.setCount22(list1.get(i).getCount22());
					vo.setCount23(list1.get(i).getCount23());
					vo.setCount24(list1.get(i).getCount24());
					vo.setCount25(list1.get(i).getCount25());
					vo.setCount26(list1.get(i).getCount26());
					vo.setCount27(list1.get(i).getCount27());
					vo.setCount28(list1.get(i).getCount28());
					vo.setCount29(list1.get(i).getCount29());
					vo.setCount30(list1.get(i).getCount30());
					vo.setCount31(list1.get(i).getCount31());
					vo.setCount32(list1.get(i).getCount32());
					vo.setCount33(list1.get(i).getCount33());
					vo.setCount34(list1.get(i).getCount34());
					vo.setCount35(list1.get(i).getCount35());
					vo.setCount36(list1.get(i).getCount36());
					vo.setCount37(list1.get(i).getCount37());
					vo.setCount38(list1.get(i).getCount38());
					vo.setCount39(list1.get(i).getCount39());
					vo.setCount40(list1.get(i).getCount40());
					list2.add(x, vo);
					x++;
				}

				if ("".equals(strVvd)) {

					cntr[0] = Double.parseDouble(list1.get(i - k).getCount01());
					cntr[1] = Double.parseDouble(list1.get(i - k).getCount02());
					cntr[2] = Double.parseDouble(list1.get(i - k).getCount03());
					cntr[3] = Double.parseDouble(list1.get(i - k).getCount04());
					cntr[4] = Double.parseDouble(list1.get(i - k).getCount05());
					cntr[5] = Double.parseDouble(list1.get(i - k).getCount06());
					cntr[6] = Double.parseDouble(list1.get(i - k).getCount07());
					cntr[7] = Double.parseDouble(list1.get(i - k).getCount08());
					cntr[8] = Double.parseDouble(list1.get(i - k).getCount09());
					cntr[9] = Double.parseDouble(list1.get(i - k).getCount10());
					cntr[10] = Double.parseDouble(list1.get(i - k).getCount11());
					cntr[11] = Double.parseDouble(list1.get(i - k).getCount12());
					cntr[12] = Double.parseDouble(list1.get(i - k).getCount13());
					cntr[13] = Double.parseDouble(list1.get(i - k).getCount14());
					cntr[14] = Double.parseDouble(list1.get(i - k).getCount15());
					cntr[15] = Double.parseDouble(list1.get(i - k).getCount16());
					cntr[16] = Double.parseDouble(list1.get(i - k).getCount17());
					cntr[17] = Double.parseDouble(list1.get(i - k).getCount18());
					cntr[18] = Double.parseDouble(list1.get(i - k).getCount19());
					cntr[19] = Double.parseDouble(list1.get(i - k).getCount20());
					cntr[20] = Double.parseDouble(list1.get(i - k).getCount21());
					cntr[21] = Double.parseDouble(list1.get(i - k).getCount22());
					cntr[22] = Double.parseDouble(list1.get(i - k).getCount23());
					cntr[23] = Double.parseDouble(list1.get(i - k).getCount24());
					cntr[24] = Double.parseDouble(list1.get(i - k).getCount25());
					cntr[25] = Double.parseDouble(list1.get(i - k).getCount26());
					cntr[26] = Double.parseDouble(list1.get(i - k).getCount27());
					cntr[27] = Double.parseDouble(list1.get(i - k).getCount28());
					cntr[28] = Double.parseDouble(list1.get(i - k).getCount29());
					cntr[29] = Double.parseDouble(list1.get(i - k).getCount30());
					cntr[30] = Double.parseDouble(list1.get(i - k).getCount31());
					cntr[31] = Double.parseDouble(list1.get(i - k).getCount32());
					cntr[32] = Double.parseDouble(list1.get(i - k).getCount33());
					cntr[33] = Double.parseDouble(list1.get(i - k).getCount34());
					cntr[34] = Double.parseDouble(list1.get(i - k).getCount35());
					cntr[35] = Double.parseDouble(list1.get(i - k).getCount36());
					cntr[36] = Double.parseDouble(list1.get(i - k).getCount37());
					cntr[37] = Double.parseDouble(list1.get(i - k).getCount38());
					cntr[38] = Double.parseDouble(list1.get(i - k).getCount39());
					cntr[39] = Double.parseDouble(list1.get(i - k).getCount40());

					days[0] = Double.parseDouble(list1.get(i - (k - 1)).getCount01());
					days[1] = Double.parseDouble(list1.get(i - (k - 1)).getCount02());
					days[2] = Double.parseDouble(list1.get(i - (k - 1)).getCount03());
					days[3] = Double.parseDouble(list1.get(i - (k - 1)).getCount04());
					days[4] = Double.parseDouble(list1.get(i - (k - 1)).getCount05());
					days[5] = Double.parseDouble(list1.get(i - (k - 1)).getCount06());
					days[6] = Double.parseDouble(list1.get(i - (k - 1)).getCount07());
					days[7] = Double.parseDouble(list1.get(i - (k - 1)).getCount08());
					days[8] = Double.parseDouble(list1.get(i - (k - 1)).getCount09());
					days[9] = Double.parseDouble(list1.get(i - (k - 1)).getCount10());
					days[10] = Double.parseDouble(list1.get(i - (k - 1)).getCount11());
					days[11] = Double.parseDouble(list1.get(i - (k - 1)).getCount12());
					days[12] = Double.parseDouble(list1.get(i - (k - 1)).getCount13());
					days[13] = Double.parseDouble(list1.get(i - (k - 1)).getCount14());
					days[14] = Double.parseDouble(list1.get(i - (k - 1)).getCount15());
					days[15] = Double.parseDouble(list1.get(i - (k - 1)).getCount16());
					days[16] = Double.parseDouble(list1.get(i - (k - 1)).getCount17());
					days[17] = Double.parseDouble(list1.get(i - (k - 1)).getCount18());
					days[18] = Double.parseDouble(list1.get(i - (k - 1)).getCount19());
					days[19] = Double.parseDouble(list1.get(i - (k - 1)).getCount20());
					days[20] = Double.parseDouble(list1.get(i - (k - 1)).getCount21());
					days[21] = Double.parseDouble(list1.get(i - (k - 1)).getCount22());
					days[22] = Double.parseDouble(list1.get(i - (k - 1)).getCount23());
					days[23] = Double.parseDouble(list1.get(i - (k - 1)).getCount24());
					days[24] = Double.parseDouble(list1.get(i - (k - 1)).getCount25());
					days[25] = Double.parseDouble(list1.get(i - (k - 1)).getCount26());
					days[26] = Double.parseDouble(list1.get(i - (k - 1)).getCount27());
					days[27] = Double.parseDouble(list1.get(i - (k - 1)).getCount28());
					days[28] = Double.parseDouble(list1.get(i - (k - 1)).getCount29());
					days[29] = Double.parseDouble(list1.get(i - (k - 1)).getCount30());
					days[30] = Double.parseDouble(list1.get(i - (k - 1)).getCount31());
					days[31] = Double.parseDouble(list1.get(i - (k - 1)).getCount32());
					days[32] = Double.parseDouble(list1.get(i - (k - 1)).getCount33());
					days[33] = Double.parseDouble(list1.get(i - (k - 1)).getCount34());
					days[34] = Double.parseDouble(list1.get(i - (k - 1)).getCount35());
					days[35] = Double.parseDouble(list1.get(i - (k - 1)).getCount36());
					days[36] = Double.parseDouble(list1.get(i - (k - 1)).getCount37());
					days[37] = Double.parseDouble(list1.get(i - (k - 1)).getCount38());
					days[38] = Double.parseDouble(list1.get(i - (k - 1)).getCount39());
					days[39] = Double.parseDouble(list1.get(i - (k - 1)).getCount40());

					if (strDivision.equals(sTime)) {
						for (int m = 0; m < cntr.length; m++) {

							if (cntr[m] > 0) {
								// ttime[m] = Math.round(days[m]/cntr[m]*10)/10;
								ttime[m] = days[m] / cntr[m];

							}
							else {
								ttime[m] = 0.0;
							}
						}
						vo = new TurnTimeByTypeSizeVO();
						if ("".equals(strVvd)) {
							vo.setVvd("Total Average");
						}

						vo.setVvd(list1.get(i).getVvd());
						vo.setTotal(list1.get(i).getTotal());

						vo.setCount01(Double.toString(ttime[0]));
						vo.setCount02(Double.toString(ttime[1]));
						vo.setCount03(Double.toString(ttime[2]));
						vo.setCount04(Double.toString(ttime[3]));
						vo.setCount05(Double.toString(ttime[4]));
						vo.setCount06(Double.toString(ttime[5]));
						vo.setCount07(Double.toString(ttime[6]));
						vo.setCount08(Double.toString(ttime[7]));
						vo.setCount09(Double.toString(ttime[8]));
						vo.setCount10(Double.toString(ttime[9]));
						vo.setCount11(Double.toString(ttime[10]));
						vo.setCount12(Double.toString(ttime[11]));
						vo.setCount13(Double.toString(ttime[12]));
						vo.setCount14(Double.toString(ttime[13]));
						vo.setCount15(Double.toString(ttime[14]));
						vo.setCount16(Double.toString(ttime[15]));
						vo.setCount17(Double.toString(ttime[16]));
						vo.setCount18(Double.toString(ttime[17]));
						vo.setCount19(Double.toString(ttime[18]));
						vo.setCount20(Double.toString(ttime[19]));
						vo.setCount21(Double.toString(ttime[20]));
						vo.setCount22(Double.toString(ttime[21]));
						vo.setCount23(Double.toString(ttime[22]));
						vo.setCount24(Double.toString(ttime[23]));
						vo.setCount25(Double.toString(ttime[24]));
						vo.setCount26(Double.toString(ttime[25]));
						vo.setCount27(Double.toString(ttime[26]));
						vo.setCount28(Double.toString(ttime[27]));
						vo.setCount29(Double.toString(ttime[28]));
						vo.setCount30(Double.toString(ttime[29]));
						vo.setCount31(Double.toString(ttime[30]));
						vo.setCount32(Double.toString(ttime[31]));
						vo.setCount33(Double.toString(ttime[32]));
						vo.setCount34(Double.toString(ttime[33]));
						vo.setCount35(Double.toString(ttime[34]));
						vo.setCount36(Double.toString(ttime[35]));
						vo.setCount37(Double.toString(ttime[36]));
						vo.setCount38(Double.toString(ttime[37]));
						vo.setCount39(Double.toString(ttime[38]));
						vo.setCount40(Double.toString(ttime[39]));
						list2.add(x, vo);
						x++;
					}
				}
			}

			return list2;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by Lane & VVD Summary Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by Lane & VVD Summary Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * TurnTimeListByLaneVVD Detail Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO >
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDDetail(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException {
		try {

			return dbDao.searchPortTurnTimeListByLaneVVDDetail(tTSearchOptionInGereralVO);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by Lane & VVD Detail Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by Lane & VVD Detail Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * PortTurnTimeLane list를 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPortTurnTimeLaneList(String period, String from, String to, String pol) throws EventException {
		String[] arrVvd = null;
		try {
			arrVvd = dbDao.searchPortTurnTimeLaneList(period, from, to, pol);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Lane List Retrieve" }).getMessage(),
					e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Lane List Retrieve" }).getMessage(),
					ex);
		}
		return arrVvd;
	}

	/**
	 * Yard list를 조회합니다.<br>
	 * 
	 * @param pol
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchYardList(String pol) throws EventException {
		String[] arrVvd = null;
		try {
			arrVvd = dbDao.searchYardList(pol);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Lane List Retrieve" }).getMessage(),
					e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Lane List Retrieve" }).getMessage(),
					ex);
		}
		return arrVvd;
	}
	
	/**
	 * PortTurnTimeVVD list를 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @param lane
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPortTurnTimeVVDList(String period, String from, String to, String pol, String lane)
			throws EventException {
		String[] arrVvd = null;
		try {
			arrVvd = dbDao.searchPortTurnTimeVVDList(period, from, to, pol, lane);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "VVD List Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "VVD List Retrieve" }).getMessage(),
					ex);
		}
		return arrVvd;
	}

	/**
	 * LocationTurnTime Detail Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO TTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 */
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeDetail(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException {
		try {

			TurnTimeByMonthlyWeeklyTrendSetVO list = dbDao.searchLocationTurnTimeDetail(tTSearchOptionInGereralVO);

			List<TurnTimeByMonthlyWeeklyTrendVO> list1 = list.getTurntimebymonthlyweeklytrendvo();

			double[] cntr = new double[26];

			double[] days = new double[26];

			double[] ttime = new double[26];

			for (int i = 0; i < list1.size(); i++) {
				int k = 0;

				String strLocCd = list1.get(i).getLoccode();
				String strTpsz = list1.get(i).getTpsz();
				String strDivision = list1.get(i).getDivision();

				if (strDivision.equals(sTime)) {
					k = 2;
				}

				if (strTpsz.equals("")) { // 소계(SubTotal) 구분
					list1.get(i).setTpsz("Average");

					cntr[0] = Double.parseDouble(list1.get(i - k).getCount01());
					cntr[1] = Double.parseDouble(list1.get(i - k).getCount02());
					cntr[2] = Double.parseDouble(list1.get(i - k).getCount03());
					cntr[3] = Double.parseDouble(list1.get(i - k).getCount04());
					cntr[4] = Double.parseDouble(list1.get(i - k).getCount05());
					cntr[5] = Double.parseDouble(list1.get(i - k).getCount06());
					cntr[6] = Double.parseDouble(list1.get(i - k).getCount07());
					cntr[7] = Double.parseDouble(list1.get(i - k).getCount08());
					cntr[8] = Double.parseDouble(list1.get(i - k).getCount09());
					cntr[9] = Double.parseDouble(list1.get(i - k).getCount10());
					cntr[10] = Double.parseDouble(list1.get(i - k).getCount11());
					cntr[11] = Double.parseDouble(list1.get(i - k).getCount12());
					cntr[12] = Double.parseDouble(list1.get(i - k).getCount13());
					cntr[13] = Double.parseDouble(list1.get(i - k).getCount14());
					cntr[14] = Double.parseDouble(list1.get(i - k).getCount15());
					cntr[15] = Double.parseDouble(list1.get(i - k).getCount16());
					cntr[16] = Double.parseDouble(list1.get(i - k).getCount17());
					cntr[17] = Double.parseDouble(list1.get(i - k).getCount18());
					cntr[18] = Double.parseDouble(list1.get(i - k).getCount19());
					cntr[19] = Double.parseDouble(list1.get(i - k).getCount20());
					cntr[20] = Double.parseDouble(list1.get(i - k).getCount21());
					cntr[21] = Double.parseDouble(list1.get(i - k).getCount22());
					cntr[22] = Double.parseDouble(list1.get(i - k).getCount23());
					cntr[23] = Double.parseDouble(list1.get(i - k).getCount24());
					cntr[24] = Double.parseDouble(list1.get(i - k).getCount25());
					cntr[25] = Double.parseDouble(list1.get(i - k).getCount26());

					days[0] = Double.parseDouble(list1.get(i - (k - 1)).getCount01());
					days[1] = Double.parseDouble(list1.get(i - (k - 1)).getCount02());
					days[2] = Double.parseDouble(list1.get(i - (k - 1)).getCount03());
					days[3] = Double.parseDouble(list1.get(i - (k - 1)).getCount04());
					days[4] = Double.parseDouble(list1.get(i - (k - 1)).getCount05());
					days[5] = Double.parseDouble(list1.get(i - (k - 1)).getCount06());
					days[6] = Double.parseDouble(list1.get(i - (k - 1)).getCount07());
					days[7] = Double.parseDouble(list1.get(i - (k - 1)).getCount08());
					days[8] = Double.parseDouble(list1.get(i - (k - 1)).getCount09());
					days[9] = Double.parseDouble(list1.get(i - (k - 1)).getCount10());
					days[10] = Double.parseDouble(list1.get(i - (k - 1)).getCount11());
					days[11] = Double.parseDouble(list1.get(i - (k - 1)).getCount12());
					days[12] = Double.parseDouble(list1.get(i - (k - 1)).getCount13());
					days[13] = Double.parseDouble(list1.get(i - (k - 1)).getCount14());
					days[14] = Double.parseDouble(list1.get(i - (k - 1)).getCount15());
					days[15] = Double.parseDouble(list1.get(i - (k - 1)).getCount16());
					days[16] = Double.parseDouble(list1.get(i - (k - 1)).getCount17());
					days[17] = Double.parseDouble(list1.get(i - (k - 1)).getCount18());
					days[18] = Double.parseDouble(list1.get(i - (k - 1)).getCount19());
					days[19] = Double.parseDouble(list1.get(i - (k - 1)).getCount20());
					days[20] = Double.parseDouble(list1.get(i - (k - 1)).getCount21());
					days[21] = Double.parseDouble(list1.get(i - (k - 1)).getCount22());
					days[22] = Double.parseDouble(list1.get(i - (k - 1)).getCount23());
					days[23] = Double.parseDouble(list1.get(i - (k - 1)).getCount24());
					days[24] = Double.parseDouble(list1.get(i - (k - 1)).getCount25());
					days[25] = Double.parseDouble(list1.get(i - (k - 1)).getCount26());

					if (strDivision.equals(sTime)) {
						for (int m = 0; m < cntr.length; m++) {

							if (cntr[m] > 0) {
								ttime[m] = days[m] / cntr[m];
							}
							else {
								ttime[m] = 0.0;
							}
						}
						list1.get(i).setCount01(Double.toString(ttime[0]));
						list1.get(i).setCount02(Double.toString(ttime[1]));
						list1.get(i).setCount03(Double.toString(ttime[2]));
						list1.get(i).setCount04(Double.toString(ttime[3]));
						list1.get(i).setCount05(Double.toString(ttime[4]));
						list1.get(i).setCount06(Double.toString(ttime[5]));
						list1.get(i).setCount07(Double.toString(ttime[6]));
						list1.get(i).setCount08(Double.toString(ttime[7]));
						list1.get(i).setCount09(Double.toString(ttime[8]));
						list1.get(i).setCount10(Double.toString(ttime[9]));
						list1.get(i).setCount11(Double.toString(ttime[10]));
						list1.get(i).setCount12(Double.toString(ttime[11]));
						list1.get(i).setCount13(Double.toString(ttime[12]));
						list1.get(i).setCount14(Double.toString(ttime[13]));
						list1.get(i).setCount15(Double.toString(ttime[14]));
						list1.get(i).setCount16(Double.toString(ttime[15]));
						list1.get(i).setCount17(Double.toString(ttime[16]));
						list1.get(i).setCount18(Double.toString(ttime[17]));
						list1.get(i).setCount19(Double.toString(ttime[18]));
						list1.get(i).setCount20(Double.toString(ttime[19]));
						list1.get(i).setCount21(Double.toString(ttime[20]));
						list1.get(i).setCount22(Double.toString(ttime[21]));
						list1.get(i).setCount23(Double.toString(ttime[22]));
						list1.get(i).setCount24(Double.toString(ttime[23]));
						list1.get(i).setCount25(Double.toString(ttime[24]));
						list1.get(i).setCount26(Double.toString(ttime[25]));

					}
				}
				if (strLocCd.equals("")) {
					list1.get(i).setLoccode("Total");

				}
			}

			list.setTurntimebymonthlyweeklytrendvo(list1);

			return list;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "T/Time by Location Detail Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "T/Time by Location Detail Retrieve" }).getMessage(),
					ex);
		}
	}

	/**
	 * LocationTurnTime Summary Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO TTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 */
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeSummary(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException {
		try {

			TurnTimeByMonthlyWeeklyTrendSetVO list = dbDao.searchLocationTurnTimeSummary(tTSearchOptionInGereralVO);

			List<TurnTimeByMonthlyWeeklyTrendVO> list1 = list.getTurntimebymonthlyweeklytrendvo();

			List<TurnTimeByMonthlyWeeklyTrendVO> list2 = new ArrayList<TurnTimeByMonthlyWeeklyTrendVO>();
			TurnTimeByMonthlyWeeklyTrendVO vo = null;

			double[] cntr = new double[26];

			double[] days = new double[26];

			double[] ttime = new double[26];

			int x = 0;
			for (int i = 0; i < list1.size(); i++) {
				int k = 0;

				String strTpsz = list1.get(i).getTpsz();
				String strDivision = list1.get(i).getDivision();
				String strLoccode = list1.get(i).getLoccode();

				if (strDivision.equals(sTime)) {
					k = 2;
				}

				if (!"".equals(strTpsz) && strDivision.equals(sTime)) {

					vo = new TurnTimeByMonthlyWeeklyTrendVO();

					vo.setTpsz(list1.get(i).getTpsz());
					vo.setTotal(list1.get(i).getTotal());
					vo.setLoccode(list1.get(i).getLoccode());

					vo.setCount01(list1.get(i).getCount01());
					vo.setCount02(list1.get(i).getCount02());
					vo.setCount03(list1.get(i).getCount03());
					vo.setCount04(list1.get(i).getCount04());
					vo.setCount05(list1.get(i).getCount05());
					vo.setCount06(list1.get(i).getCount06());
					vo.setCount07(list1.get(i).getCount07());
					vo.setCount08(list1.get(i).getCount08());
					vo.setCount09(list1.get(i).getCount09());
					vo.setCount10(list1.get(i).getCount10());
					vo.setCount11(list1.get(i).getCount11());
					vo.setCount12(list1.get(i).getCount12());
					vo.setCount13(list1.get(i).getCount13());
					vo.setCount14(list1.get(i).getCount14());
					vo.setCount15(list1.get(i).getCount15());
					vo.setCount16(list1.get(i).getCount16());
					vo.setCount17(list1.get(i).getCount17());
					vo.setCount18(list1.get(i).getCount18());
					vo.setCount19(list1.get(i).getCount19());
					vo.setCount20(list1.get(i).getCount20());
					vo.setCount21(list1.get(i).getCount21());
					vo.setCount22(list1.get(i).getCount22());
					vo.setCount23(list1.get(i).getCount23());
					vo.setCount24(list1.get(i).getCount24());
					vo.setCount25(list1.get(i).getCount25());
					vo.setCount26(list1.get(i).getCount26());
					list2.add(x, vo);
					x++;
				}

				if (strTpsz.equals("")) {

					cntr[0] = Double.parseDouble(list1.get(i - k).getCount01());
					cntr[1] = Double.parseDouble(list1.get(i - k).getCount02());
					cntr[2] = Double.parseDouble(list1.get(i - k).getCount03());
					cntr[3] = Double.parseDouble(list1.get(i - k).getCount04());
					cntr[4] = Double.parseDouble(list1.get(i - k).getCount05());
					cntr[5] = Double.parseDouble(list1.get(i - k).getCount06());
					cntr[6] = Double.parseDouble(list1.get(i - k).getCount07());
					cntr[7] = Double.parseDouble(list1.get(i - k).getCount08());
					cntr[8] = Double.parseDouble(list1.get(i - k).getCount09());
					cntr[9] = Double.parseDouble(list1.get(i - k).getCount10());
					cntr[10] = Double.parseDouble(list1.get(i - k).getCount11());
					cntr[11] = Double.parseDouble(list1.get(i - k).getCount12());
					cntr[12] = Double.parseDouble(list1.get(i - k).getCount13());
					cntr[13] = Double.parseDouble(list1.get(i - k).getCount14());
					cntr[14] = Double.parseDouble(list1.get(i - k).getCount15());
					cntr[15] = Double.parseDouble(list1.get(i - k).getCount16());
					cntr[16] = Double.parseDouble(list1.get(i - k).getCount17());
					cntr[17] = Double.parseDouble(list1.get(i - k).getCount18());
					cntr[18] = Double.parseDouble(list1.get(i - k).getCount19());
					cntr[19] = Double.parseDouble(list1.get(i - k).getCount20());
					cntr[20] = Double.parseDouble(list1.get(i - k).getCount21());
					cntr[21] = Double.parseDouble(list1.get(i - k).getCount22());
					cntr[22] = Double.parseDouble(list1.get(i - k).getCount23());
					cntr[23] = Double.parseDouble(list1.get(i - k).getCount24());
					cntr[24] = Double.parseDouble(list1.get(i - k).getCount25());
					cntr[25] = Double.parseDouble(list1.get(i - k).getCount26());

					days[0] = Double.parseDouble(list1.get(i - (k - 1)).getCount01());
					days[1] = Double.parseDouble(list1.get(i - (k - 1)).getCount02());
					days[2] = Double.parseDouble(list1.get(i - (k - 1)).getCount03());
					days[3] = Double.parseDouble(list1.get(i - (k - 1)).getCount04());
					days[4] = Double.parseDouble(list1.get(i - (k - 1)).getCount05());
					days[5] = Double.parseDouble(list1.get(i - (k - 1)).getCount06());
					days[6] = Double.parseDouble(list1.get(i - (k - 1)).getCount07());
					days[7] = Double.parseDouble(list1.get(i - (k - 1)).getCount08());
					days[8] = Double.parseDouble(list1.get(i - (k - 1)).getCount09());
					days[9] = Double.parseDouble(list1.get(i - (k - 1)).getCount10());
					days[10] = Double.parseDouble(list1.get(i - (k - 1)).getCount11());
					days[11] = Double.parseDouble(list1.get(i - (k - 1)).getCount12());
					days[12] = Double.parseDouble(list1.get(i - (k - 1)).getCount13());
					days[13] = Double.parseDouble(list1.get(i - (k - 1)).getCount14());
					days[14] = Double.parseDouble(list1.get(i - (k - 1)).getCount15());
					days[15] = Double.parseDouble(list1.get(i - (k - 1)).getCount16());
					days[16] = Double.parseDouble(list1.get(i - (k - 1)).getCount17());
					days[17] = Double.parseDouble(list1.get(i - (k - 1)).getCount18());
					days[18] = Double.parseDouble(list1.get(i - (k - 1)).getCount19());
					days[19] = Double.parseDouble(list1.get(i - (k - 1)).getCount20());
					days[20] = Double.parseDouble(list1.get(i - (k - 1)).getCount21());
					days[21] = Double.parseDouble(list1.get(i - (k - 1)).getCount22());
					days[22] = Double.parseDouble(list1.get(i - (k - 1)).getCount23());
					days[23] = Double.parseDouble(list1.get(i - (k - 1)).getCount24());
					days[24] = Double.parseDouble(list1.get(i - (k - 1)).getCount25());
					days[25] = Double.parseDouble(list1.get(i - (k - 1)).getCount26());

					if (strDivision.equals(sTime)) {
						for (int m = 0; m < cntr.length; m++) {

							if (cntr[m] > 0) {
								ttime[m] = days[m] / cntr[m];
							}
							else {
								ttime[m] = 0.0;
							}
						}
						vo = new TurnTimeByMonthlyWeeklyTrendVO();
						if ("".equals(strTpsz) && "".equals(strLoccode)) { // 전체 Total
							vo.setLoccode("Total Average");
							// vo.setTpsz("Total Average");
						}
						else { // subTotal
							vo.setTpsz("Average");
						}
						vo.setTotal(list1.get(i).getTotal());
						vo.setLoccode(list1.get(i).getLoccode());
						vo.setCount01(Double.toString(ttime[0]));
						vo.setCount02(Double.toString(ttime[1]));
						vo.setCount03(Double.toString(ttime[2]));
						vo.setCount04(Double.toString(ttime[3]));
						vo.setCount05(Double.toString(ttime[4]));
						vo.setCount06(Double.toString(ttime[5]));
						vo.setCount07(Double.toString(ttime[6]));
						vo.setCount08(Double.toString(ttime[7]));
						vo.setCount09(Double.toString(ttime[8]));
						vo.setCount10(Double.toString(ttime[9]));
						vo.setCount11(Double.toString(ttime[10]));
						vo.setCount12(Double.toString(ttime[11]));
						vo.setCount13(Double.toString(ttime[12]));
						vo.setCount14(Double.toString(ttime[13]));
						vo.setCount15(Double.toString(ttime[14]));
						vo.setCount16(Double.toString(ttime[15]));
						vo.setCount17(Double.toString(ttime[16]));
						vo.setCount18(Double.toString(ttime[17]));
						vo.setCount19(Double.toString(ttime[18]));
						vo.setCount20(Double.toString(ttime[19]));
						vo.setCount21(Double.toString(ttime[20]));
						vo.setCount22(Double.toString(ttime[21]));
						vo.setCount23(Double.toString(ttime[22]));
						vo.setCount24(Double.toString(ttime[23]));
						vo.setCount25(Double.toString(ttime[24]));
						vo.setCount26(Double.toString(ttime[25]));
						list2.add(x, vo);
						x++;
					}
				}
			}
			list.setTurntimebymonthlyweeklytrendvo(list2);

			return list;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by Location Summary Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by Location Summary Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * TurnAroundTimeByTradeLane Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTradeLane(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException {
		try {

			return dbDao.searchTurnAroundTimeByTradeLane(turnAroundTimeSearchOptionVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Turn Around Time TradeLane Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Turn Around Time TradeLane Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * TurnAroundTimeByTPSZTrade Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTPSZTrade(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException {
		try {

			return dbDao.searchTurnAroundTimeByTPSZTrade(turnAroundTimeSearchOptionVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Turn Around Time TPSZTrade Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Turn Around Time TPSZTrade Retrieve" }).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * TurnAroundTimeByLocation Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByLocation(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException {
		try {

			return dbDao.searchTurnAroundTimeByLocation(turnAroundTimeSearchOptionVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "Turn Around Time Location Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "Turn Around Time Location Retrieve" }).getMessage(),
					ex);
		}
	}

	/**
	 * TurnTimeByMovement 를 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovement(TTSearchOptionInGereralVO tTSearchOptionIngereralVo)
			throws EventException {
		try {

			return dbDao.searchTurnTimeByMovement(tTSearchOptionIngereralVo);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by MVMT Summary Tab Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "T/Time by MVMT Summary Tab Retrieve" }).getMessage(), ex);
		}

	}

	/**
	 * TurnTimeByMovementDetail 를 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovementDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo)
			throws EventException {
		try {

			return dbDao.searchTurnTimeByMovementDetail(tTSearchOptionIngereralVo);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "T/Time by MVMT Detail Tab Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "T/Time by MVMT Detail Tab Retrieve" }).getMessage(),
					ex);
		}

	}

	/**
	 * TurnTimeByMovementDetail 를 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo TTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByMvmtCntrListVO> searchTurnTimeByMvmtCntrList(TTSearchOptionInGereralVO tTSearchOptionIngereralVo)
			throws EventException {
		try {

			return dbDao.searchTurnTimeByMvmtCntrList(tTSearchOptionIngereralVo);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "T/Time by MVMT CNTR (Detail) Retrieve" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("CIM00011", new String[] { "T/Time by MVMT CNTR (Detail) Retrieve" }).getMessage(),
					ex);
		}

	}
}