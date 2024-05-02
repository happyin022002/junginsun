/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EmptyCODAdjustmentBCImpl.java
 *@FileTitle : MTY COD Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration.EmptyCODAdjustmentDBDAO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.BookingContainerListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyList01VO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODMasterVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODPortSumVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MasterContainerListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.PODListByVVDVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.RevenueMTYListCntrTpSzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-COD Confirm Business Logic Basic Command implementation<br>
 * - OPUS-COD Confirm<br>
 * 
 * @author 
 * @see EES_CIM_1038 EventResponse,EmptyCODAdjustmentBC 
 * @since J2EE 1.6
 */
public class EmptyCODAdjustmentBCImpl extends BasicCommandSupport implements EmptyCODAdjustmentBC {

	// Database Access Object
	private transient EmptyCODAdjustmentDBDAO dbDao = null;

	/**
	 * EmptyCODAdjustmentBCImpl <br>
	 * EmptyCODAdjustmentDBDAO<br>
	 */
	public EmptyCODAdjustmentBCImpl() {
		dbDao = new EmptyCODAdjustmentDBDAO();
	}

	/**
	 * [ MTY Repo Inquiry by Period ]<br>
	 * 
	 * @param mTYREPOByPeriodOptionVO MTYREPOByPeriodOptionVO
	 * @return List<MTYREPOByPeriodVO>
	 * @exception EventException
	 */
	public List<MTYREPOByPeriodVO> searchMTYREPOByPeriod(MTYREPOByPeriodOptionVO mTYREPOByPeriodOptionVO)
			throws EventException {
		try {
			List<MTYREPOByPeriodVO> list = dbDao.searchMTYREPOByPeriod(mTYREPOByPeriodOptionVO);

			String[] viewFlag = new String[17];
			viewFlag[0] = list.get(0).getD2();
			viewFlag[1] = list.get(0).getD4();
			viewFlag[2] = list.get(0).getD5();
			viewFlag[3] = list.get(0).getD7();
			viewFlag[4] = list.get(0).getR2();
			viewFlag[5] = list.get(0).getR5();
			viewFlag[6] = list.get(0).getR9();
			viewFlag[7] = list.get(0).getO2();
			viewFlag[8] = list.get(0).getS2();
			viewFlag[9] = list.get(0).getO4();
			viewFlag[10] = list.get(0).getS4();
			viewFlag[11] = list.get(0).getF2();
			viewFlag[12] = list.get(0).getA2();
			viewFlag[13] = list.get(0).getF4();
			viewFlag[14] = list.get(0).getA4();
			viewFlag[15] = list.get(0).getF5();
			viewFlag[16] = list.get(0).getO5();

			int x = 0;
			List<MTYREPOByPeriodVO> list2 = new ArrayList<MTYREPOByPeriodVO>();
			MTYREPOByPeriodVO vo = null;
			double[] discQty = new double[17]; // disc S.Total
			double[] loadQty = new double[17]; // load S.Total
			double[] discQtyG = new double[17]; // disc G.Total
			double[] loadQtyG = new double[17]; // load G.Total
			String tDiv = "";
			String cPort = "";
			String tPort = "";

			if (list.size() > 1) {

				for (int i = 1; i < list.size(); i++) {

					tDiv = list.get(i).getDiv();
					cPort = list.get(i).getPort();

					if (i == 1) {

						vo = new MTYREPOByPeriodVO();
						vo.setPort(list.get(i).getPort());
						vo.setVvd(list.get(i).getVvd());
						vo.setEtb(list.get(i).getEtb());
						vo.setDiv(list.get(i).getDiv());
						vo.setGubun(list.get(i).getGubun());
						vo.setD2(setViewValue(list.get(i).getD2(), viewFlag[0]));
						vo.setD4(setViewValue(list.get(i).getD4(), viewFlag[1]));
						vo.setD5(setViewValue(list.get(i).getD5(), viewFlag[2]));
						vo.setD7(setViewValue(list.get(i).getD7(), viewFlag[3]));
						vo.setR2(setViewValue(list.get(i).getR2(), viewFlag[4]));
						vo.setR5(setViewValue(list.get(i).getR5(), viewFlag[5]));
						vo.setR9(setViewValue(list.get(i).getR9(), viewFlag[6]));
						vo.setO2(setViewValue(list.get(i).getO2(), viewFlag[7]));
						vo.setS2(setViewValue(list.get(i).getS2(), viewFlag[8]));
						vo.setO4(setViewValue(list.get(i).getO4(), viewFlag[9]));
						vo.setS4(setViewValue(list.get(i).getS4(), viewFlag[10]));
						vo.setF2(setViewValue(list.get(i).getF2(), viewFlag[11]));
						vo.setA2(setViewValue(list.get(i).getA2(), viewFlag[12]));
						vo.setF4(setViewValue(list.get(i).getF4(), viewFlag[13]));
						vo.setA4(setViewValue(list.get(i).getA4(), viewFlag[14]));
						vo.setF5(setViewValue(list.get(i).getF5(), viewFlag[15]));
						vo.setO5(setViewValue(list.get(i).getO5(), viewFlag[16]));

						list2.add(x, vo);
						x++;

						if (tDiv.equals("Load")) {

							loadQty[0] = Double.parseDouble(list.get(i).getD2()) + loadQty[0];
							loadQty[1] = Double.parseDouble(list.get(i).getD4()) + loadQty[1];
							loadQty[2] = Double.parseDouble(list.get(i).getD5()) + loadQty[2];
							loadQty[3] = Double.parseDouble(list.get(i).getD7()) + loadQty[3];
							loadQty[4] = Double.parseDouble(list.get(i).getR2()) + loadQty[4];
							loadQty[5] = Double.parseDouble(list.get(i).getR5()) + loadQty[5];
							loadQty[6] = Double.parseDouble(list.get(i).getR9()) + loadQty[6];
							loadQty[7] = Double.parseDouble(list.get(i).getO2()) + loadQty[7];
							loadQty[8] = Double.parseDouble(list.get(i).getS2()) + loadQty[8];
							loadQty[9] = Double.parseDouble(list.get(i).getO4()) + loadQty[9];
							loadQty[10] = Double.parseDouble(list.get(i).getS4()) + loadQty[10];
							loadQty[11] = Double.parseDouble(list.get(i).getF2()) + loadQty[11];
							loadQty[12] = Double.parseDouble(list.get(i).getA2()) + loadQty[12];
							loadQty[13] = Double.parseDouble(list.get(i).getF4()) + loadQty[13];
							loadQty[14] = Double.parseDouble(list.get(i).getA4()) + loadQty[14];
							loadQty[15] = Double.parseDouble(list.get(i).getF5()) + loadQty[15];
							loadQty[16] = Double.parseDouble(list.get(i).getO5()) + loadQty[16];

							loadQtyG[0] = Double.parseDouble(list.get(i).getD2()) + loadQtyG[0];
							loadQtyG[1] = Double.parseDouble(list.get(i).getD4()) + loadQtyG[1];
							loadQtyG[2] = Double.parseDouble(list.get(i).getD5()) + loadQtyG[2];
							loadQtyG[3] = Double.parseDouble(list.get(i).getD7()) + loadQtyG[3];
							loadQtyG[4] = Double.parseDouble(list.get(i).getR2()) + loadQtyG[4];
							loadQtyG[5] = Double.parseDouble(list.get(i).getR5()) + loadQtyG[5];
							loadQtyG[6] = Double.parseDouble(list.get(i).getR9()) + loadQtyG[6];
							loadQtyG[7] = Double.parseDouble(list.get(i).getO2()) + loadQtyG[7];
							loadQtyG[8] = Double.parseDouble(list.get(i).getS2()) + loadQtyG[8];
							loadQtyG[9] = Double.parseDouble(list.get(i).getO4()) + loadQtyG[9];
							loadQtyG[10] = Double.parseDouble(list.get(i).getS4()) + loadQtyG[10];
							loadQtyG[11] = Double.parseDouble(list.get(i).getF2()) + loadQtyG[11];
							loadQtyG[12] = Double.parseDouble(list.get(i).getA2()) + loadQtyG[12];
							loadQtyG[13] = Double.parseDouble(list.get(i).getF4()) + loadQtyG[13];
							loadQtyG[14] = Double.parseDouble(list.get(i).getA4()) + loadQtyG[14];
							loadQtyG[15] = Double.parseDouble(list.get(i).getF5()) + loadQtyG[15];
							loadQtyG[16] = Double.parseDouble(list.get(i).getO5()) + loadQtyG[16];

						}
						else if (tDiv.equals("Disc")) {

							discQty[0] = Double.parseDouble(list.get(i).getD2()) + discQty[0];
							discQty[1] = Double.parseDouble(list.get(i).getD4()) + discQty[1];
							discQty[2] = Double.parseDouble(list.get(i).getD5()) + discQty[2];
							discQty[3] = Double.parseDouble(list.get(i).getD7()) + discQty[3];
							discQty[4] = Double.parseDouble(list.get(i).getR2()) + discQty[4];
							discQty[5] = Double.parseDouble(list.get(i).getR5()) + discQty[5];
							discQty[6] = Double.parseDouble(list.get(i).getR9()) + discQty[6];
							discQty[7] = Double.parseDouble(list.get(i).getO2()) + discQty[7];
							discQty[8] = Double.parseDouble(list.get(i).getS2()) + discQty[8];
							discQty[9] = Double.parseDouble(list.get(i).getO4()) + discQty[9];
							discQty[10] = Double.parseDouble(list.get(i).getS4()) + discQty[10];
							discQty[11] = Double.parseDouble(list.get(i).getF2()) + discQty[11];
							discQty[12] = Double.parseDouble(list.get(i).getA2()) + discQty[12];
							discQty[13] = Double.parseDouble(list.get(i).getF4()) + discQty[13];
							discQty[14] = Double.parseDouble(list.get(i).getA4()) + discQty[14];
							discQty[15] = Double.parseDouble(list.get(i).getF5()) + discQty[15];
							discQty[16] = Double.parseDouble(list.get(i).getO5()) + discQty[16];

							discQtyG[0] = Double.parseDouble(list.get(i).getD2()) + discQtyG[0];
							discQtyG[1] = Double.parseDouble(list.get(i).getD4()) + discQtyG[1];
							discQtyG[2] = Double.parseDouble(list.get(i).getD5()) + discQtyG[2];
							discQtyG[3] = Double.parseDouble(list.get(i).getD7()) + discQtyG[3];
							discQtyG[4] = Double.parseDouble(list.get(i).getR2()) + discQtyG[4];
							discQtyG[5] = Double.parseDouble(list.get(i).getR5()) + discQtyG[5];
							discQtyG[6] = Double.parseDouble(list.get(i).getR9()) + discQtyG[6];
							discQtyG[7] = Double.parseDouble(list.get(i).getO2()) + discQtyG[7];
							discQtyG[8] = Double.parseDouble(list.get(i).getS2()) + discQtyG[8];
							discQtyG[9] = Double.parseDouble(list.get(i).getO4()) + discQtyG[9];
							discQtyG[10] = Double.parseDouble(list.get(i).getS4()) + discQtyG[10];
							discQtyG[11] = Double.parseDouble(list.get(i).getF2()) + discQtyG[11];
							discQtyG[12] = Double.parseDouble(list.get(i).getA2()) + discQtyG[12];
							discQtyG[13] = Double.parseDouble(list.get(i).getF4()) + discQtyG[13];
							discQtyG[14] = Double.parseDouble(list.get(i).getA4()) + discQtyG[14];
							discQtyG[15] = Double.parseDouble(list.get(i).getF5()) + discQtyG[15];
							discQtyG[16] = Double.parseDouble(list.get(i).getO5()) + discQtyG[16];

						}

						tPort = cPort;

					}
					else if (i != 1 && cPort.equals(tPort)) { // if ( i == 1 ){

						vo = new MTYREPOByPeriodVO();
						vo.setPort(list.get(i).getPort());
						vo.setVvd(list.get(i).getVvd());
						vo.setEtb(list.get(i).getEtb());
						vo.setDiv(list.get(i).getDiv());
						vo.setGubun(list.get(i).getGubun());
						vo.setD2(setViewValue(list.get(i).getD2(), viewFlag[0]));
						vo.setD4(setViewValue(list.get(i).getD4(), viewFlag[1]));
						vo.setD5(setViewValue(list.get(i).getD5(), viewFlag[2]));
						vo.setD7(setViewValue(list.get(i).getD7(), viewFlag[3]));
						vo.setR2(setViewValue(list.get(i).getR2(), viewFlag[4]));
						vo.setR5(setViewValue(list.get(i).getR5(), viewFlag[5]));
						vo.setR9(setViewValue(list.get(i).getR9(), viewFlag[6]));
						vo.setO2(setViewValue(list.get(i).getO2(), viewFlag[7]));
						vo.setS2(setViewValue(list.get(i).getS2(), viewFlag[8]));
						vo.setO4(setViewValue(list.get(i).getO4(), viewFlag[9]));
						vo.setS4(setViewValue(list.get(i).getS4(), viewFlag[10]));
						vo.setF2(setViewValue(list.get(i).getF2(), viewFlag[11]));
						vo.setA2(setViewValue(list.get(i).getA2(), viewFlag[12]));
						vo.setF4(setViewValue(list.get(i).getF4(), viewFlag[13]));
						vo.setA4(setViewValue(list.get(i).getA4(), viewFlag[14]));
						vo.setF5(setViewValue(list.get(i).getF5(), viewFlag[15]));
						vo.setO5(setViewValue(list.get(i).getO5(), viewFlag[16]));

						list2.add(x, vo);
						x++;

						if (tDiv.equals("Load")) {

							loadQty[0] = Double.parseDouble(list.get(i).getD2()) + loadQty[0];
							loadQty[1] = Double.parseDouble(list.get(i).getD4()) + loadQty[1];
							loadQty[2] = Double.parseDouble(list.get(i).getD5()) + loadQty[2];
							loadQty[3] = Double.parseDouble(list.get(i).getD7()) + loadQty[3];
							loadQty[4] = Double.parseDouble(list.get(i).getR2()) + loadQty[4];
							loadQty[5] = Double.parseDouble(list.get(i).getR5()) + loadQty[5];
							loadQty[6] = Double.parseDouble(list.get(i).getR9()) + loadQty[6];
							loadQty[7] = Double.parseDouble(list.get(i).getO2()) + loadQty[7];
							loadQty[8] = Double.parseDouble(list.get(i).getS2()) + loadQty[8];
							loadQty[9] = Double.parseDouble(list.get(i).getO4()) + loadQty[9];
							loadQty[10] = Double.parseDouble(list.get(i).getS4()) + loadQty[10];
							loadQty[11] = Double.parseDouble(list.get(i).getF2()) + loadQty[11];
							loadQty[12] = Double.parseDouble(list.get(i).getA2()) + loadQty[12];
							loadQty[13] = Double.parseDouble(list.get(i).getF4()) + loadQty[13];
							loadQty[14] = Double.parseDouble(list.get(i).getA4()) + loadQty[14];
							loadQty[15] = Double.parseDouble(list.get(i).getF5()) + loadQty[15];
							loadQty[16] = Double.parseDouble(list.get(i).getO5()) + loadQty[16];

							loadQtyG[0] = Double.parseDouble(list.get(i).getD2()) + loadQtyG[0];
							loadQtyG[1] = Double.parseDouble(list.get(i).getD4()) + loadQtyG[1];
							loadQtyG[2] = Double.parseDouble(list.get(i).getD5()) + loadQtyG[2];
							loadQtyG[3] = Double.parseDouble(list.get(i).getD7()) + loadQtyG[3];
							loadQtyG[4] = Double.parseDouble(list.get(i).getR2()) + loadQtyG[4];
							loadQtyG[5] = Double.parseDouble(list.get(i).getR5()) + loadQtyG[5];
							loadQtyG[6] = Double.parseDouble(list.get(i).getR9()) + loadQtyG[6];
							loadQtyG[7] = Double.parseDouble(list.get(i).getO2()) + loadQtyG[7];
							loadQtyG[8] = Double.parseDouble(list.get(i).getS2()) + loadQtyG[8];
							loadQtyG[9] = Double.parseDouble(list.get(i).getO4()) + loadQtyG[9];
							loadQtyG[10] = Double.parseDouble(list.get(i).getS4()) + loadQtyG[10];
							loadQtyG[11] = Double.parseDouble(list.get(i).getF2()) + loadQtyG[11];
							loadQtyG[12] = Double.parseDouble(list.get(i).getA2()) + loadQtyG[12];
							loadQtyG[13] = Double.parseDouble(list.get(i).getF4()) + loadQtyG[13];
							loadQtyG[14] = Double.parseDouble(list.get(i).getA4()) + loadQtyG[14];
							loadQtyG[15] = Double.parseDouble(list.get(i).getF5()) + loadQtyG[15];
							loadQtyG[16] = Double.parseDouble(list.get(i).getO5()) + loadQtyG[16];

						}
						else if (tDiv.equals("Disc")) {

							discQty[0] = Double.parseDouble(list.get(i).getD2()) + discQty[0];
							discQty[1] = Double.parseDouble(list.get(i).getD4()) + discQty[1];
							discQty[2] = Double.parseDouble(list.get(i).getD5()) + discQty[2];
							discQty[3] = Double.parseDouble(list.get(i).getD7()) + discQty[3];
							discQty[4] = Double.parseDouble(list.get(i).getR2()) + discQty[4];
							discQty[5] = Double.parseDouble(list.get(i).getR5()) + discQty[5];
							discQty[6] = Double.parseDouble(list.get(i).getR9()) + discQty[6];
							discQty[7] = Double.parseDouble(list.get(i).getO2()) + discQty[7];
							discQty[8] = Double.parseDouble(list.get(i).getS2()) + discQty[8];
							discQty[9] = Double.parseDouble(list.get(i).getO4()) + discQty[9];
							discQty[10] = Double.parseDouble(list.get(i).getS4()) + discQty[10];
							discQty[11] = Double.parseDouble(list.get(i).getF2()) + discQty[11];
							discQty[12] = Double.parseDouble(list.get(i).getA2()) + discQty[12];
							discQty[13] = Double.parseDouble(list.get(i).getF4()) + discQty[13];
							discQty[14] = Double.parseDouble(list.get(i).getA4()) + discQty[14];
							discQty[15] = Double.parseDouble(list.get(i).getF5()) + discQty[15];
							discQty[16] = Double.parseDouble(list.get(i).getO5()) + discQty[16];

							discQtyG[0] = Double.parseDouble(list.get(i).getD2()) + discQtyG[0];
							discQtyG[1] = Double.parseDouble(list.get(i).getD4()) + discQtyG[1];
							discQtyG[2] = Double.parseDouble(list.get(i).getD5()) + discQtyG[2];
							discQtyG[3] = Double.parseDouble(list.get(i).getD7()) + discQtyG[3];
							discQtyG[4] = Double.parseDouble(list.get(i).getR2()) + discQtyG[4];
							discQtyG[5] = Double.parseDouble(list.get(i).getR5()) + discQtyG[5];
							discQtyG[6] = Double.parseDouble(list.get(i).getR9()) + discQtyG[6];
							discQtyG[7] = Double.parseDouble(list.get(i).getO2()) + discQtyG[7];
							discQtyG[8] = Double.parseDouble(list.get(i).getS2()) + discQtyG[8];
							discQtyG[9] = Double.parseDouble(list.get(i).getO4()) + discQtyG[9];
							discQtyG[10] = Double.parseDouble(list.get(i).getS4()) + discQtyG[10];
							discQtyG[11] = Double.parseDouble(list.get(i).getF2()) + discQtyG[11];
							discQtyG[12] = Double.parseDouble(list.get(i).getA2()) + discQtyG[12];
							discQtyG[13] = Double.parseDouble(list.get(i).getF4()) + discQtyG[13];
							discQtyG[14] = Double.parseDouble(list.get(i).getA4()) + discQtyG[14];
							discQtyG[15] = Double.parseDouble(list.get(i).getF5()) + discQtyG[15];
							discQtyG[16] = Double.parseDouble(list.get(i).getO5()) + discQtyG[16];

						}

						tPort = cPort;

					}
					else if (i != 1 && !cPort.equals(tPort)) { // if ( i == 1) {

						vo = new MTYREPOByPeriodVO();
						vo.setPort(tPort);
						vo.setVvd("Total");
						vo.setEtb("");
						vo.setDiv("Load");
						vo.setGubun(list.get(i).getGubun());
						vo.setD2(setViewValue(Double.toString(loadQty[0]), viewFlag[0]));
						vo.setD4(setViewValue(Double.toString(loadQty[1]), viewFlag[1]));
						vo.setD5(setViewValue(Double.toString(loadQty[2]), viewFlag[2]));
						vo.setD7(setViewValue(Double.toString(loadQty[3]), viewFlag[3]));
						vo.setR2(setViewValue(Double.toString(loadQty[4]), viewFlag[4]));
						vo.setR5(setViewValue(Double.toString(loadQty[5]), viewFlag[5]));
						vo.setR9(setViewValue(Double.toString(loadQty[6]), viewFlag[6]));
						vo.setO2(setViewValue(Double.toString(loadQty[7]), viewFlag[7]));
						vo.setS2(setViewValue(Double.toString(loadQty[8]), viewFlag[8]));
						vo.setO4(setViewValue(Double.toString(loadQty[9]), viewFlag[9]));
						vo.setS4(setViewValue(Double.toString(loadQty[10]), viewFlag[10]));
						vo.setF2(setViewValue(Double.toString(loadQty[11]), viewFlag[11]));
						vo.setA2(setViewValue(Double.toString(loadQty[12]), viewFlag[12]));
						vo.setF4(setViewValue(Double.toString(loadQty[13]), viewFlag[13]));
						vo.setA4(setViewValue(Double.toString(loadQty[14]), viewFlag[14]));
						vo.setF5(setViewValue(Double.toString(loadQty[15]), viewFlag[15]));
						vo.setO5(setViewValue(Double.toString(loadQty[16]), viewFlag[16]));
						
						list2.add(x, vo);
						x++;

						vo = new MTYREPOByPeriodVO();
						vo.setPort(tPort);
						vo.setVvd("Total");
						vo.setEtb("");
						vo.setDiv("Disc");
						vo.setGubun(list.get(i).getGubun());
						vo.setD2(setViewValue(Double.toString(discQty[0]), viewFlag[0]));
						vo.setD4(setViewValue(Double.toString(discQty[1]), viewFlag[1]));
						vo.setD5(setViewValue(Double.toString(discQty[2]), viewFlag[2]));
						vo.setD7(setViewValue(Double.toString(discQty[3]), viewFlag[3]));
						vo.setR2(setViewValue(Double.toString(discQty[4]), viewFlag[4]));
						vo.setR5(setViewValue(Double.toString(discQty[5]), viewFlag[5]));
						vo.setR9(setViewValue(Double.toString(discQty[6]), viewFlag[6]));
						vo.setO2(setViewValue(Double.toString(discQty[7]), viewFlag[7]));
						vo.setS2(setViewValue(Double.toString(discQty[8]), viewFlag[8]));
						vo.setO4(setViewValue(Double.toString(discQty[9]), viewFlag[9]));
						vo.setS4(setViewValue(Double.toString(discQty[10]), viewFlag[10]));
						vo.setF2(setViewValue(Double.toString(discQty[11]), viewFlag[11]));
						vo.setA2(setViewValue(Double.toString(discQty[12]), viewFlag[12]));
						vo.setF4(setViewValue(Double.toString(discQty[13]), viewFlag[13]));
						vo.setA4(setViewValue(Double.toString(discQty[14]), viewFlag[14]));
						vo.setF5(setViewValue(Double.toString(discQty[15]), viewFlag[15]));
						vo.setO5(setViewValue(Double.toString(discQty[16]), viewFlag[16]));

						list2.add(x, vo);
						x++;

						for (int m = 0; m < loadQty.length; m++) {
							loadQty[m] = 0;
							discQty[m] = 0;
						}

						vo = new MTYREPOByPeriodVO();
						vo.setPort(list.get(i).getPort());
						vo.setVvd(list.get(i).getVvd());
						vo.setEtb(list.get(i).getEtb());
						vo.setDiv(list.get(i).getDiv());
						vo.setGubun(list.get(i).getGubun());
						vo.setD2(setViewValue(list.get(i).getD2(), viewFlag[0]));
						vo.setD4(setViewValue(list.get(i).getD4(), viewFlag[1]));
						vo.setD5(setViewValue(list.get(i).getD5(), viewFlag[2]));
						vo.setD7(setViewValue(list.get(i).getD7(), viewFlag[3]));
						vo.setR2(setViewValue(list.get(i).getR2(), viewFlag[4]));
						vo.setR5(setViewValue(list.get(i).getR5(), viewFlag[5]));
						vo.setR9(setViewValue(list.get(i).getR9(), viewFlag[6]));
						vo.setO2(setViewValue(list.get(i).getO2(), viewFlag[7]));
						vo.setS2(setViewValue(list.get(i).getS2(), viewFlag[8]));
						vo.setO4(setViewValue(list.get(i).getO4(), viewFlag[9]));
						vo.setS4(setViewValue(list.get(i).getS4(), viewFlag[10]));
						vo.setF2(setViewValue(list.get(i).getF2(), viewFlag[11]));
						vo.setA2(setViewValue(list.get(i).getA2(), viewFlag[12]));
						vo.setF4(setViewValue(list.get(i).getF4(), viewFlag[13]));
						vo.setA4(setViewValue(list.get(i).getA4(), viewFlag[14]));
						vo.setF5(setViewValue(list.get(i).getF5(), viewFlag[15]));
						vo.setO5(setViewValue(list.get(i).getO5(), viewFlag[16]));

						list2.add(x, vo);
						x++;

						if (tDiv.equals("Load")) {

							loadQty[0] = Double.parseDouble(list.get(i).getD2()) + loadQty[0];
							loadQty[1] = Double.parseDouble(list.get(i).getD4()) + loadQty[1];
							loadQty[2] = Double.parseDouble(list.get(i).getD5()) + loadQty[2];
							loadQty[3] = Double.parseDouble(list.get(i).getD7()) + loadQty[3];
							loadQty[4] = Double.parseDouble(list.get(i).getR2()) + loadQty[4];
							loadQty[5] = Double.parseDouble(list.get(i).getR5()) + loadQty[5];
							loadQty[6] = Double.parseDouble(list.get(i).getR9()) + loadQty[6];
							loadQty[7] = Double.parseDouble(list.get(i).getO2()) + loadQty[7];
							loadQty[8] = Double.parseDouble(list.get(i).getS2()) + loadQty[8];
							loadQty[9] = Double.parseDouble(list.get(i).getO4()) + loadQty[9];
							loadQty[10] = Double.parseDouble(list.get(i).getS4()) + loadQty[10];
							loadQty[11] = Double.parseDouble(list.get(i).getF2()) + loadQty[11];
							loadQty[12] = Double.parseDouble(list.get(i).getA2()) + loadQty[12];
							loadQty[13] = Double.parseDouble(list.get(i).getF4()) + loadQty[13];
							loadQty[14] = Double.parseDouble(list.get(i).getA4()) + loadQty[14];
							loadQty[15] = Double.parseDouble(list.get(i).getF5()) + loadQty[15];
							loadQty[16] = Double.parseDouble(list.get(i).getO5()) + loadQty[16];

							loadQtyG[0] = Double.parseDouble(list.get(i).getD2()) + loadQtyG[0];
							loadQtyG[1] = Double.parseDouble(list.get(i).getD4()) + loadQtyG[1];
							loadQtyG[2] = Double.parseDouble(list.get(i).getD5()) + loadQtyG[2];
							loadQtyG[3] = Double.parseDouble(list.get(i).getD7()) + loadQtyG[3];
							loadQtyG[4] = Double.parseDouble(list.get(i).getR2()) + loadQtyG[4];
							loadQtyG[5] = Double.parseDouble(list.get(i).getR5()) + loadQtyG[5];
							loadQtyG[6] = Double.parseDouble(list.get(i).getR9()) + loadQtyG[6];
							loadQtyG[7] = Double.parseDouble(list.get(i).getO2()) + loadQtyG[7];
							loadQtyG[8] = Double.parseDouble(list.get(i).getS2()) + loadQtyG[8];
							loadQtyG[9] = Double.parseDouble(list.get(i).getO4()) + loadQtyG[9];
							loadQtyG[10] = Double.parseDouble(list.get(i).getS4()) + loadQtyG[10];
							loadQtyG[11] = Double.parseDouble(list.get(i).getF2()) + loadQtyG[11];
							loadQtyG[12] = Double.parseDouble(list.get(i).getA2()) + loadQtyG[12];
							loadQtyG[13] = Double.parseDouble(list.get(i).getF4()) + loadQtyG[13];
							loadQtyG[14] = Double.parseDouble(list.get(i).getA4()) + loadQtyG[14];
							loadQtyG[15] = Double.parseDouble(list.get(i).getF5()) + loadQtyG[15];
							loadQtyG[16] = Double.parseDouble(list.get(i).getO5()) + loadQtyG[16];

						}
						else if (tDiv.equals("Disc")) {

							discQty[0] = Double.parseDouble(list.get(i).getD2()) + discQty[0];
							discQty[1] = Double.parseDouble(list.get(i).getD4()) + discQty[1];
							discQty[2] = Double.parseDouble(list.get(i).getD5()) + discQty[2];
							discQty[3] = Double.parseDouble(list.get(i).getD7()) + discQty[3];
							discQty[4] = Double.parseDouble(list.get(i).getR2()) + discQty[4];
							discQty[5] = Double.parseDouble(list.get(i).getR5()) + discQty[5];
							discQty[6] = Double.parseDouble(list.get(i).getR9()) + discQty[6];
							discQty[7] = Double.parseDouble(list.get(i).getO2()) + discQty[7];
							discQty[8] = Double.parseDouble(list.get(i).getS2()) + discQty[8];
							discQty[9] = Double.parseDouble(list.get(i).getO4()) + discQty[9];
							discQty[10] = Double.parseDouble(list.get(i).getS4()) + discQty[10];
							discQty[11] = Double.parseDouble(list.get(i).getF2()) + discQty[11];
							discQty[12] = Double.parseDouble(list.get(i).getA2()) + discQty[12];
							discQty[13] = Double.parseDouble(list.get(i).getF4()) + discQty[13];
							discQty[14] = Double.parseDouble(list.get(i).getA4()) + discQty[14];
							discQty[15] = Double.parseDouble(list.get(i).getF5()) + discQty[15];
							discQty[16] = Double.parseDouble(list.get(i).getO5()) + discQty[16];

							discQtyG[0] = Double.parseDouble(list.get(i).getD2()) + discQtyG[0];
							discQtyG[1] = Double.parseDouble(list.get(i).getD4()) + discQtyG[1];
							discQtyG[2] = Double.parseDouble(list.get(i).getD5()) + discQtyG[2];
							discQtyG[3] = Double.parseDouble(list.get(i).getD7()) + discQtyG[3];
							discQtyG[4] = Double.parseDouble(list.get(i).getR2()) + discQtyG[4];
							discQtyG[5] = Double.parseDouble(list.get(i).getR5()) + discQtyG[5];
							discQtyG[6] = Double.parseDouble(list.get(i).getR9()) + discQtyG[6];
							discQtyG[7] = Double.parseDouble(list.get(i).getO2()) + discQtyG[7];
							discQtyG[8] = Double.parseDouble(list.get(i).getS2()) + discQtyG[8];
							discQtyG[9] = Double.parseDouble(list.get(i).getO4()) + discQtyG[9];
							discQtyG[10] = Double.parseDouble(list.get(i).getS4()) + discQtyG[10];
							discQtyG[11] = Double.parseDouble(list.get(i).getF2()) + discQtyG[11];
							discQtyG[12] = Double.parseDouble(list.get(i).getA2()) + discQtyG[12];
							discQtyG[13] = Double.parseDouble(list.get(i).getF4()) + discQtyG[13];
							discQtyG[14] = Double.parseDouble(list.get(i).getA4()) + discQtyG[14];
							discQtyG[15] = Double.parseDouble(list.get(i).getF5()) + discQtyG[15];
							discQtyG[16] = Double.parseDouble(list.get(i).getO5()) + discQtyG[16];

						}

						tPort = cPort;

					}// if ( i == 1 ) {

				} // FOR

				// Last Port, add Grand Total 
				vo = new MTYREPOByPeriodVO();
				vo.setPort(tPort);
				vo.setVvd("Total");
				vo.setEtb("");
				vo.setDiv("Load");
				vo.setGubun(list.get(list.size()-1).getGubun());
				vo.setD2(setViewValue(Double.toString(loadQty[0]), viewFlag[0]));
				vo.setD4(setViewValue(Double.toString(loadQty[1]), viewFlag[1]));
				vo.setD5(setViewValue(Double.toString(loadQty[2]), viewFlag[2]));
				vo.setD7(setViewValue(Double.toString(loadQty[3]), viewFlag[3]));
				vo.setR2(setViewValue(Double.toString(loadQty[4]), viewFlag[4]));
				vo.setR5(setViewValue(Double.toString(loadQty[5]), viewFlag[5]));
				vo.setR9(setViewValue(Double.toString(loadQty[6]), viewFlag[6]));
				vo.setO2(setViewValue(Double.toString(loadQty[7]), viewFlag[7]));
				vo.setS2(setViewValue(Double.toString(loadQty[8]), viewFlag[8]));
				vo.setO4(setViewValue(Double.toString(loadQty[9]), viewFlag[9]));
				vo.setS4(setViewValue(Double.toString(loadQty[10]), viewFlag[10]));
				vo.setF2(setViewValue(Double.toString(loadQty[11]), viewFlag[11]));
				vo.setA2(setViewValue(Double.toString(loadQty[12]), viewFlag[12]));
				vo.setF4(setViewValue(Double.toString(loadQty[13]), viewFlag[13]));
				vo.setA4(setViewValue(Double.toString(loadQty[14]), viewFlag[14]));
				vo.setF5(setViewValue(Double.toString(loadQty[15]), viewFlag[15]));
				vo.setO5(setViewValue(Double.toString(loadQty[16]), viewFlag[16]));

				list2.add(x, vo);
				x++;

				vo = new MTYREPOByPeriodVO();
				vo.setPort(tPort);
				vo.setVvd("Total");
				vo.setEtb("");
				vo.setDiv("Disc");
				vo.setGubun(list.get(list.size()-1).getGubun());
				vo.setD2(setViewValue(Double.toString(discQty[0]), viewFlag[0]));
				vo.setD4(setViewValue(Double.toString(discQty[1]), viewFlag[1]));
				vo.setD5(setViewValue(Double.toString(discQty[2]), viewFlag[2]));
				vo.setD7(setViewValue(Double.toString(discQty[3]), viewFlag[3]));
				vo.setR2(setViewValue(Double.toString(discQty[4]), viewFlag[4]));
				vo.setR5(setViewValue(Double.toString(discQty[5]), viewFlag[5]));
				vo.setR9(setViewValue(Double.toString(discQty[6]), viewFlag[6]));
				vo.setO2(setViewValue(Double.toString(discQty[7]), viewFlag[7]));
				vo.setS2(setViewValue(Double.toString(discQty[8]), viewFlag[8]));
				vo.setO4(setViewValue(Double.toString(discQty[9]), viewFlag[9]));
				vo.setS4(setViewValue(Double.toString(discQty[10]), viewFlag[10]));
				vo.setF2(setViewValue(Double.toString(discQty[11]), viewFlag[11]));
				vo.setA2(setViewValue(Double.toString(discQty[12]), viewFlag[12]));
				vo.setF4(setViewValue(Double.toString(discQty[13]), viewFlag[13]));
				vo.setA4(setViewValue(Double.toString(discQty[14]), viewFlag[14]));
				vo.setF5(setViewValue(Double.toString(discQty[15]), viewFlag[15]));
				vo.setO5(setViewValue(Double.toString(discQty[16]), viewFlag[16]));

				list2.add(x, vo);
				x++;

				vo = new MTYREPOByPeriodVO();
				vo.setPort("");
				vo.setVvd("Grand Total");
				vo.setEtb("");
				vo.setDiv("Load");
				vo.setGubun("L");
				vo.setD2(setViewValue(Double.toString(loadQtyG[0]), viewFlag[0]));
				vo.setD4(setViewValue(Double.toString(loadQtyG[1]), viewFlag[1]));
				vo.setD5(setViewValue(Double.toString(loadQtyG[2]), viewFlag[2]));
				vo.setD7(setViewValue(Double.toString(loadQtyG[3]), viewFlag[3]));
				vo.setR2(setViewValue(Double.toString(loadQtyG[4]), viewFlag[4]));
				vo.setR5(setViewValue(Double.toString(loadQtyG[5]), viewFlag[5]));
				vo.setR9(setViewValue(Double.toString(loadQtyG[6]), viewFlag[6]));
				vo.setO2(setViewValue(Double.toString(loadQtyG[7]), viewFlag[7]));
				vo.setS2(setViewValue(Double.toString(loadQtyG[8]), viewFlag[8]));
				vo.setO4(setViewValue(Double.toString(loadQtyG[9]), viewFlag[9]));
				vo.setS4(setViewValue(Double.toString(loadQtyG[10]), viewFlag[10]));
				vo.setF2(setViewValue(Double.toString(loadQtyG[11]), viewFlag[11]));
				vo.setA2(setViewValue(Double.toString(loadQtyG[12]), viewFlag[12]));
				vo.setF4(setViewValue(Double.toString(loadQtyG[13]), viewFlag[13]));
				vo.setA4(setViewValue(Double.toString(loadQtyG[14]), viewFlag[14]));
				vo.setF5(setViewValue(Double.toString(loadQtyG[15]), viewFlag[15]));
				vo.setO5(setViewValue(Double.toString(loadQtyG[16]), viewFlag[16]));

				list2.add(x, vo);
				x++;

				vo = new MTYREPOByPeriodVO();
				vo.setPort("");
				vo.setVvd("");
				vo.setEtb("");
				vo.setDiv("Disc");
				vo.setGubun("D");
				vo.setD2(setViewValue(Double.toString(discQtyG[0]), viewFlag[0]));
				vo.setD4(setViewValue(Double.toString(discQtyG[1]), viewFlag[1]));
				vo.setD5(setViewValue(Double.toString(discQtyG[2]), viewFlag[2]));
				vo.setD7(setViewValue(Double.toString(discQtyG[3]), viewFlag[3]));
				vo.setR2(setViewValue(Double.toString(discQtyG[4]), viewFlag[4]));
				vo.setR5(setViewValue(Double.toString(discQtyG[5]), viewFlag[5]));
				vo.setR9(setViewValue(Double.toString(discQtyG[6]), viewFlag[6]));
				vo.setO2(setViewValue(Double.toString(discQtyG[7]), viewFlag[7]));
				vo.setS2(setViewValue(Double.toString(discQtyG[8]), viewFlag[8]));
				vo.setO4(setViewValue(Double.toString(discQtyG[9]), viewFlag[9]));
				vo.setS4(setViewValue(Double.toString(discQtyG[10]), viewFlag[10]));
				vo.setF2(setViewValue(Double.toString(discQtyG[11]), viewFlag[11]));
				vo.setA2(setViewValue(Double.toString(discQtyG[12]), viewFlag[12]));
				vo.setF4(setViewValue(Double.toString(discQtyG[13]), viewFlag[13]));
				vo.setA4(setViewValue(Double.toString(discQtyG[14]), viewFlag[14]));
				vo.setF5(setViewValue(Double.toString(discQtyG[15]), viewFlag[15]));
				vo.setO5(setViewValue(Double.toString(discQtyG[16]), viewFlag[16]));

				list2.add(x, vo);
				x++;

			}

			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028",
					new String[] { "MTY Repo Inquiry by Period Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028",
					new String[] { "MTY Repo Inquiry by Period Retrieve" }).getMessage(), ex);
		}

	}

	/**
	 * EmptyCODAdjustmentBCImpl<br>
	 * @param String val
	 * @param String flag
	 * @return String val
	 * @exception EventException
	 */
	public String setViewValue(String val, String flag) {
		if (flag.equals("N")) {
			val = "";
		}
		return val;
	}

	/**
	 * [PODListByVVD]<br>
	 * @param week
	 * @param vvd
	 * @return List<PODListByVVDVO>
	 * @exception EventException
	 */
	public List<PODListByVVDVO> searchPODListByVVD(String week, String vvd) throws EventException {
		List<PODListByVVDVO> list = null;
		try {
			list = dbDao.searchPODListByVVD(week, vvd);

			if (list.size() < 1) {
				throw new EventException(new ErrorHandler("EQR21010").getMessage());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Search port information in vvd <br>
	 * 
	 * @param vvd
	 * @return List<PODListByVVDVO>
	 * @exception EventException
	 */
	public List<PODListByVVDVO> searchPODListByVVD2(String vvd) throws EventException {
		try {
			return dbDao.searchPODListByVVD2(vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * [MTY COD Confirmation]delete<br>
	 * 
	 * @param vvd
	 * @exception EventException
	 */
	public void deleteConfirmation(String vvd) throws EventException {
		try {
			dbDao.removeMTYREPOPlan(vvd);	// delete Confirmation 
			dbDao.deleteVvdRemark2(vvd);	// delete VVD Remark 
		//	log.debug("####### DELETE DONE ");
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * [MTY COD Confirmation]save<br>
	 * 
	 * @param vvd
	 * @param lane
	 * @param bay
	 * @param version
	 * @param remarkC
	 * @param sh2RC
	 * @param n1stEtb
	 * @param emptyCODVVDPortVOS
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String manageMTYREPOPlan(String vvd, String lane, String bay, String version, String remarkC, String sh2RC,
			String n1stEtb, EmptyCODVVDPort01VO[] emptyCODVVDPortVOS, SignOnUserAccount account) throws EventException {
		int rCnt = 0;
		try {

			if (emptyCODVVDPortVOS.length > 0) {
			
				String sMnlInpFlg = "";
			
				sMnlInpFlg = searchMnlInpFlgCheck(vvd);

				EmptyCODVVDVO vo = new EmptyCODVVDVO();
				vo.setVvd(vvd);
				vo.setDiv("C");
				vo.setRemark(remarkC); // Confirmation Remark 

				saveVvdRemark(vo, account); // Simulation Remark 
				dbDao.removeMTYREPOPlan(vvd); 
				dbDao.insertMTYREPOPlanVVD(vvd, lane, bay, version, remarkC, sh2RC, n1stEtb, "V", account,sMnlInpFlg);
			
				for (int i = 0; i < emptyCODVVDPortVOS.length; i++) {
					if (!(emptyCODVVDPortVOS[i].getIbflag()).equals("D")) {
						if (i != 1) {

							if (i == 0 && !(emptyCODVVDPortVOS[i].getIbflag()).equals("D")) { // Original Load 
								emptyCODVVDPortVOS[i].setPodCd("ZZZZZ"); 
								emptyCODVVDPortVOS[i].setYdCd("");
								emptyCODVVDPortVOS[i].setClptindseq("0");
								if("SKIP".equals(emptyCODVVDPortVOS[i].getEtb())){
									emptyCODVVDPortVOS[i].setEtb("");
								}
								dbDao.insertMTYREPOPlanPORT(vvd, lane, bay, version, remarkC, sh2RC, "C",
										emptyCODVVDPortVOS[i], account); // Onboard Total
							}
							else if (i > 1 && i < (2 + Integer.parseInt(sh2RC)) // Additonal Load sheet  count 
									&& !(emptyCODVVDPortVOS[i].getIbflag()).equals("D")) {
								if("SKIP".equals(emptyCODVVDPortVOS[i].getEtb())){
									emptyCODVVDPortVOS[i].setEtb("");
								}
								dbDao.insertMTYREPOPlanPORT(vvd, lane, bay, version, remarkC, sh2RC, "L",
										emptyCODVVDPortVOS[i], account); // Additonal Load
							}
							else {
								if("SKIP".equals(emptyCODVVDPortVOS[i].getEtb())){
									emptyCODVVDPortVOS[i].setEtb("");
								}

								dbDao.insertMTYREPOPlanPORT(vvd, lane, bay, version, remarkC, sh2RC, "D",
										emptyCODVVDPortVOS[i], account); // Discharge
							}

							rCnt++;
						} // IF
					} // IF
				} // FOR

			}
	    } catch (EventException de) {   
	        throw de;   
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Confirmation Save" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Confirmation Save" })
					.getMessage(), ex);
		}
		return rCnt + "";
	}

	/**
	 * [MTYCODList] [Retrieve] <br>
	 * 
	 * @param week
	 * @param trade
	 * @return EmptyCODMasterVO
	 * @exception EventException
	 */
	public EmptyCODMasterVO searchMTYCODList(String week, String trade) throws EventException {
		try {
			String sHead[] = null;
			EmptyCODMasterVO emptyCODMasterVO = new EmptyCODMasterVO();
			EmptyCODVVDPortVO emptyCODVVDPortVO = new EmptyCODVVDPortVO();

			EmptyCODVVDPortVO emptyPortSumVO = null;
			EmptyCODVVDPortVO emptyCODVVDPort = null;

			List<EmptyCODVVDVO> list = null;
			List<EmptyCODVVDVO> listadd = new ArrayList<EmptyCODVVDVO>();

			// Port vo
			List<EmptyCODVVDPortVO> portVoAdd = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo1 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo1Add = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo2 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo2Add = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo3 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo3Add = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo4 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo4Add = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo5 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVo5Add = new ArrayList<EmptyCODVVDPortVO>();
			
			// Port SUM VO.
			List<EmptyCODVVDPortVO> portVoPodSum1 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSum2 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSum3 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSum4 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSum5 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSumTot1 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSumTot2 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSumTot3 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSumTot4 = new ArrayList<EmptyCODVVDPortVO>();
			List<EmptyCODVVDPortVO> portVoPodSumTot5 = new ArrayList<EmptyCODVVDPortVO>();

			sHead = dbDao.searchHead(week); // head information

			list = dbDao.searchMTYCODList(week, trade); 
			String div = "";
			for (int i = 0; i < list.size(); i++) {
				EmptyCODVVDVO vo = (EmptyCODVVDVO) list.get(i);
				div = vo.getWeekdivision();

				if ("1".equals(div)) { // weekDivision
					if ("1".equals(vo.getCodcfmctscd())) { // getCodcfmctscd = 1
						portVo1 = dbDao.searchBayplanPortList(vo, week);
						portVo1Add.addAll(portVo1);
					}
					else { // getCodcfmctscd <> 1
						portVo1 = dbDao.searchSimulationPortList(vo, week);
						portVo1Add.addAll(portVo1);
					}
				}
				else if ("2".equals(div)) { 
					if ("1".equals(vo.getCodcfmctscd())) { 
						portVo2 = dbDao.searchBayplanPortList(vo, week);
						portVo2Add.addAll(portVo2);
					}
					else {	
						portVo2 = dbDao.searchSimulationPortList(vo, week);
						portVo2Add.addAll(portVo2);
					}

				}
				else if ("3".equals(div)) { 
					if ("1".equals(vo.getCodcfmctscd())) {
						portVo3 = dbDao.searchBayplanPortList(vo, week);
						portVo3Add.addAll(portVo3);
					}
					else {

						portVo3 = dbDao.searchSimulationPortList(vo, week);
						portVo3Add.addAll(portVo3);
					}

				}
				else if ("4".equals(div)) { 
					if ("1".equals(vo.getCodcfmctscd())) {
						portVo4 = dbDao.searchBayplanPortList(vo, week);
						portVo4Add.addAll(portVo4);
					}
					else {
						portVo4 = dbDao.searchSimulationPortList(vo, week);
						portVo4Add.addAll(portVo4);
					}

				}
				else if ("5".equals(div)) { 
					if ("1".equals(vo.getCodcfmctscd())) {
						portVo5 = dbDao.searchBayplanPortList(vo, week);
						portVo5Add.addAll(portVo5);
					}
					else {
						portVo5 = dbDao.searchSimulationPortList(vo, week);
						portVo5Add.addAll(portVo5);
					}

				}

			}
			
			portVoAdd.addAll(portVo1Add);
			portVoAdd.addAll(portVo2Add);
			portVoAdd.addAll(portVo3Add);
			portVoAdd.addAll(portVo4Add);
			portVoAdd.addAll(portVo5Add);
			listadd.addAll(list);

			for (int i = 0; i < portVoAdd.size(); i++) {
				emptyCODVVDPortVO = portVoAdd.get(i);

				if ("1".equals(emptyCODVVDPortVO.getEtbweekdivision())) {

					portVoPodSum1.add(emptyCODVVDPortVO);

				}
				else if ("2".equals(emptyCODVVDPortVO.getEtbweekdivision())) {

					portVoPodSum2.add(emptyCODVVDPortVO);

				}
				else if ("3".equals(emptyCODVVDPortVO.getEtbweekdivision())) {

					portVoPodSum3.add(emptyCODVVDPortVO);

				}
				else if ("4".equals(emptyCODVVDPortVO.getEtbweekdivision())) {
					portVoPodSum4.add(emptyCODVVDPortVO);

				}
				else if ("5".equals(emptyCODVVDPortVO.getEtbweekdivision())) {
					portVoPodSum5.add(emptyCODVVDPortVO);

				}
			}

			boolean flag = false;

			for (int i = 0; i < portVoPodSum1.size(); i++) {
				emptyCODVVDPort = portVoPodSum1.get(i);
				flag = false;
				String podTemp = emptyCODVVDPort.getPod();

				if (portVoPodSumTot1.size() > 0) {
					for (int j = 0; j < portVoPodSumTot1.size(); j++) {
						
						if (portVoPodSumTot1.get(j).getPod().equals(podTemp)) {

							emptyPortSumVO = new EmptyCODVVDPortVO();
							emptyPortSumVO.setPod(podTemp);
							emptyPortSumVO.setD2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD2())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getD2())));
							emptyPortSumVO.setD4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD4())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getD4())));
							emptyPortSumVO.setD5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD5())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getD5())));
							emptyPortSumVO.setD7(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD7())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getD7())));
							emptyPortSumVO.setA2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA2())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getA2())));
							emptyPortSumVO.setA4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA4())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getA4())));
							emptyPortSumVO.setF2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF2())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getF2())));
							emptyPortSumVO.setF4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF4())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getF4())));
							emptyPortSumVO.setF5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF5())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getF5())));
							emptyPortSumVO.setO2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO2())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getO2())));
							emptyPortSumVO.setO4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO4())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getO4())));
							emptyPortSumVO.setO5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO5())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getO5())));
							emptyPortSumVO.setR2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR2())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getR2())));
							emptyPortSumVO.setR5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR5())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getR5())));
							emptyPortSumVO.setR9(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR9())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getR9())));
							emptyPortSumVO.setS2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS2())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getS2())));
							emptyPortSumVO.setS4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS4())
									+ Integer.parseInt(portVoPodSumTot1.get(j).getS4())));
							portVoPodSumTot1.remove(j);
							portVoPodSumTot1.add(emptyPortSumVO);
							flag = true;
							break;
						}
					}
					if (!flag) { 
						emptyPortSumVO = new EmptyCODVVDPortVO();
						emptyPortSumVO.setPod(podTemp);
						emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
						emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
						emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
						emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
						emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
						emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
						emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
						emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
						emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
						emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
						emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
						emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
						emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
						emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
						emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
						emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
						emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

						portVoPodSumTot1.add(emptyPortSumVO);

					}

				}
				else { 

					emptyPortSumVO = new EmptyCODVVDPortVO();
					emptyPortSumVO.setPod(podTemp);
					emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
					emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
					emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
					emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
					emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
					emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
					emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
					emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
					emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
					emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
					emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
					emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
					emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
					emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
					emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
					emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
					emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

					portVoPodSumTot1.add(emptyPortSumVO);

				}
			}

			for (int i = 0; i < portVoPodSum2.size(); i++) {
				emptyCODVVDPort = portVoPodSum2.get(i);
				flag = false;

				String podTemp = emptyCODVVDPort.getPod();
				if (portVoPodSumTot2.size() > 0) {
					for (int j = 0; j < portVoPodSumTot2.size(); j++) {
						if (portVoPodSumTot2.get(j).getPod().equals(podTemp)) {
							emptyPortSumVO = new EmptyCODVVDPortVO();
							emptyPortSumVO.setPod(podTemp);
							emptyPortSumVO.setD2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD2())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getD2())));
							emptyPortSumVO.setD4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD4())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getD4())));
							emptyPortSumVO.setD5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD5())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getD5())));
							emptyPortSumVO.setD7(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD7())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getD7())));
							emptyPortSumVO.setA2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA2())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getA2())));
							emptyPortSumVO.setA4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA4())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getA4())));
							emptyPortSumVO.setF2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF2())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getF2())));
							emptyPortSumVO.setF4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF4())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getF4())));
							emptyPortSumVO.setF5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF5())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getF5())));
							emptyPortSumVO.setO2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO2())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getO2())));
							emptyPortSumVO.setO4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO4())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getO4())));
							emptyPortSumVO.setO5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO5())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getO5())));
							emptyPortSumVO.setR2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR2())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getR2())));
							emptyPortSumVO.setR5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR5())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getR5())));
							emptyPortSumVO.setR9(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR9())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getR9())));
							emptyPortSumVO.setS2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS2())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getS2())));
							emptyPortSumVO.setS4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS4())
									+ Integer.parseInt(portVoPodSumTot2.get(j).getS4())));

							portVoPodSumTot2.remove(j);
							portVoPodSumTot2.add(emptyPortSumVO);
							flag = true;
							break;
						}
					}
					if (!flag) {
						emptyPortSumVO = new EmptyCODVVDPortVO();
						emptyPortSumVO.setPod(podTemp);
						emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
						emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
						emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
						emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
						emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
						emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
						emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
						emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
						emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
						emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
						emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
						emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
						emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
						emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
						emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
						emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
						emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

						portVoPodSumTot2.add(emptyPortSumVO);

					}

				}
				else {
					emptyPortSumVO = new EmptyCODVVDPortVO();
					emptyPortSumVO.setPod(podTemp);
					emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
					emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
					emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
					emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
					emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
					emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
					emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
					emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
					emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
					emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
					emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
					emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
					emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
					emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
					emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
					emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
					emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

					portVoPodSumTot2.add(emptyPortSumVO);

				}
			}
			
			for (int i = 0; i < portVoPodSum3.size(); i++) {
				emptyCODVVDPort = portVoPodSum3.get(i);
				flag = false;
				String podTemp = emptyCODVVDPort.getPod();
				if (portVoPodSumTot3.size() > 0) {
					for (int j = 0; j < portVoPodSumTot3.size(); j++) {

						if (portVoPodSumTot3.get(j).getPod().equals(podTemp)) {

							emptyPortSumVO = new EmptyCODVVDPortVO();
							emptyPortSumVO.setPod(podTemp);
							emptyPortSumVO.setD2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD2())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getD2())));
							emptyPortSumVO.setD4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD4())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getD4())));
							emptyPortSumVO.setD5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD5())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getD5())));
							emptyPortSumVO.setD7(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD7())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getD7())));
							emptyPortSumVO.setA2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA2())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getA2())));
							emptyPortSumVO.setA4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA4())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getA4())));
							emptyPortSumVO.setF2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF2())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getF2())));
							emptyPortSumVO.setF4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF4())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getF4())));
							emptyPortSumVO.setF5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF5())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getF5())));
							emptyPortSumVO.setO2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO2())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getO2())));
							emptyPortSumVO.setO4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO4())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getO4())));
							emptyPortSumVO.setO5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO5())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getO5())));
							emptyPortSumVO.setR2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR2())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getR2())));
							emptyPortSumVO.setR5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR5())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getR5())));
							emptyPortSumVO.setR9(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR9())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getR9())));
							emptyPortSumVO.setS2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS2())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getS2())));
							emptyPortSumVO.setS4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS4())
									+ Integer.parseInt(portVoPodSumTot3.get(j).getS4())));

							portVoPodSumTot3.remove(j);
							portVoPodSumTot3.add(emptyPortSumVO);

							flag = true;
							break;
						}
					}
					if (!flag) {
						emptyPortSumVO = new EmptyCODVVDPortVO();
						emptyPortSumVO.setPod(podTemp);
						emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
						emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
						emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
						emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
						emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
						emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
						emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
						emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
						emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
						emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
						emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
						emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
						emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
						emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
						emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
						emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
						emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

						portVoPodSumTot3.add(emptyPortSumVO);

					}

				}
				else {
					emptyPortSumVO = new EmptyCODVVDPortVO();
					emptyPortSumVO.setPod(podTemp);
					emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
					emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
					emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
					emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
					emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
					emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
					emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
					emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
					emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
					emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
					emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
					emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
					emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
					emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
					emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
					emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
					emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

					portVoPodSumTot3.add(emptyPortSumVO);
				}
			}

			for (int i = 0; i < portVoPodSum4.size(); i++) {
				emptyCODVVDPort = portVoPodSum4.get(i);
				flag = false;
				String podTemp = emptyCODVVDPort.getPod();
				if (portVoPodSumTot4.size() > 0) {
					for (int j = 0; j < portVoPodSumTot4.size(); j++) {
						if (portVoPodSumTot4.get(j).getPod().equals(podTemp)) {
							emptyPortSumVO = new EmptyCODVVDPortVO();
							emptyPortSumVO.setPod(podTemp);
							emptyPortSumVO.setD2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD2())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getD2())));
							emptyPortSumVO.setD4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD4())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getD4())));
							emptyPortSumVO.setD5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD5())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getD5())));
							emptyPortSumVO.setD7(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD7())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getD7())));
							emptyPortSumVO.setA2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA2())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getA2())));
							emptyPortSumVO.setA4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA4())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getA4())));
							emptyPortSumVO.setF2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF2())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getF2())));
							emptyPortSumVO.setF4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF4())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getF4())));
							emptyPortSumVO.setF5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF5())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getF5())));
							emptyPortSumVO.setO2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO2())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getO2())));
							emptyPortSumVO.setO4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO4())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getO4())));
							emptyPortSumVO.setO5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO5())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getO5())));
							emptyPortSumVO.setR2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR2())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getR2())));
							emptyPortSumVO.setR5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR5())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getR5())));
							emptyPortSumVO.setR9(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR9())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getR9())));
							emptyPortSumVO.setS2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS2())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getS2())));
							emptyPortSumVO.setS4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS4())
									+ Integer.parseInt(portVoPodSumTot4.get(j).getS4())));

							portVoPodSumTot4.remove(j);
							portVoPodSumTot4.add(emptyPortSumVO);
							flag = true;
							break;
						}
					}
					if (!flag) {
						emptyPortSumVO = new EmptyCODVVDPortVO();
						emptyPortSumVO.setPod(podTemp);
						emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
						emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
						emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
						emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
						emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
						emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
						emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
						emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
						emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
						emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
						emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
						emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
						emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
						emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
						emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
						emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
						emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

						portVoPodSumTot4.add(emptyPortSumVO);

					}

				}
				else {
					emptyPortSumVO = new EmptyCODVVDPortVO();
					emptyPortSumVO.setPod(podTemp);
					emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
					emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
					emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
					emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
					emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
					emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
					emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
					emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
					emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
					emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
					emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
					emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
					emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
					emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
					emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
					emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
					emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

					portVoPodSumTot4.add(emptyPortSumVO);

				}
			}

			for (int i = 0; i < portVoPodSum5.size(); i++) {
				emptyCODVVDPort = portVoPodSum5.get(i);
				flag = false;
				String podTemp = emptyCODVVDPort.getPod();
				if (portVoPodSumTot5.size() > 0) {
					for (int j = 0; j < portVoPodSumTot5.size(); j++) {
						if (portVoPodSumTot5.get(j).getPod().equals(podTemp)) {
							emptyPortSumVO = new EmptyCODVVDPortVO();
							emptyPortSumVO.setPod(podTemp);
							emptyPortSumVO.setD2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD2())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getD2())));
							emptyPortSumVO.setD4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD4())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getD4())));
							emptyPortSumVO.setD5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD5())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getD5())));
							emptyPortSumVO.setD7(String.valueOf(Integer.parseInt(emptyCODVVDPort.getD7())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getD7())));
							emptyPortSumVO.setA2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA2())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getA2())));
							emptyPortSumVO.setA4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getA4())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getA4())));
							emptyPortSumVO.setF2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF2())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getF2())));
							emptyPortSumVO.setF4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF4())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getF4())));
							emptyPortSumVO.setF5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getF5())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getF5())));
							emptyPortSumVO.setO2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO2())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getO2())));
							emptyPortSumVO.setO4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO4())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getO4())));
							emptyPortSumVO.setO5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getO5())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getO5())));
							emptyPortSumVO.setR2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR2())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getR2())));
							emptyPortSumVO.setR5(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR5())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getR5())));
							emptyPortSumVO.setR9(String.valueOf(Integer.parseInt(emptyCODVVDPort.getR9())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getR9())));
							emptyPortSumVO.setS2(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS2())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getS2())));
							emptyPortSumVO.setS4(String.valueOf(Integer.parseInt(emptyCODVVDPort.getS4())
									+ Integer.parseInt(portVoPodSumTot5.get(j).getS4())));

							portVoPodSumTot5.remove(j);
							portVoPodSumTot5.add(emptyPortSumVO);
							flag = true;
							break;
						}
					}
					if (!flag) {
						emptyPortSumVO = new EmptyCODVVDPortVO();
						emptyPortSumVO.setPod(podTemp);
						emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
						emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
						emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
						emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
						emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
						emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
						emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
						emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
						emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
						emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
						emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
						emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
						emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
						emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
						emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
						emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
						emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

						portVoPodSumTot5.add(emptyPortSumVO);

					}
				}
				else {
					emptyPortSumVO = new EmptyCODVVDPortVO();
					emptyPortSumVO.setPod(podTemp);
					emptyPortSumVO.setD2(emptyCODVVDPort.getD2());
					emptyPortSumVO.setD4(emptyCODVVDPort.getD4());
					emptyPortSumVO.setD5(emptyCODVVDPort.getD5());
					emptyPortSumVO.setD7(emptyCODVVDPort.getD7());
					emptyPortSumVO.setA2(emptyCODVVDPort.getA2());
					emptyPortSumVO.setA4(emptyCODVVDPort.getA4());
					emptyPortSumVO.setF2(emptyCODVVDPort.getF2());
					emptyPortSumVO.setF4(emptyCODVVDPort.getF4());
					emptyPortSumVO.setF5(emptyCODVVDPort.getF5());
					emptyPortSumVO.setO2(emptyCODVVDPort.getO2());
					emptyPortSumVO.setO4(emptyCODVVDPort.getO4());
					emptyPortSumVO.setO5(emptyCODVVDPort.getO5());
					emptyPortSumVO.setR2(emptyCODVVDPort.getR2());
					emptyPortSumVO.setR5(emptyCODVVDPort.getR5());
					emptyPortSumVO.setR9(emptyCODVVDPort.getR9());
					emptyPortSumVO.setS2(emptyCODVVDPort.getS2());
					emptyPortSumVO.setS4(emptyCODVVDPort.getS4());

					portVoPodSumTot5.add(emptyPortSumVO);

				}
			}
			
			emptyCODMasterVO.setEmptycodvvdportvo(portVo1Add);
			emptyCODMasterVO.setEmptycodvvdportvo2(portVo2Add);
			emptyCODMasterVO.setEmptycodvvdportvo3(portVo3Add);
			emptyCODMasterVO.setEmptycodvvdportvo4(portVo4Add);
			emptyCODMasterVO.setEmptycodvvdportvo5(portVo5Add);

			emptyCODMasterVO.setEmptycodvvdportvo6(portVoPodSumTot1);
			emptyCODMasterVO.setEmptycodvvdportvo7(portVoPodSumTot2);
			emptyCODMasterVO.setEmptycodvvdportvo8(portVoPodSumTot3);
			emptyCODMasterVO.setEmptycodvvdportvo9(portVoPodSumTot4);
			emptyCODMasterVO.setEmptycodvvdportvo10(portVoPodSumTot5);

			emptyCODMasterVO.setEmptycodvvdport5Zoovo(portVoAdd); 	
			emptyCODMasterVO.setEmptycodvvdvo(listadd); 			
			emptyCODMasterVO.setHead(sHead);						
			return emptyCODMasterVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Simulation Retrieve" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Simulation Retrieve" })
					.getMessage(), ex);
		}

	}

	/**
	 * [COD Simulation By VVD] [SAVE] <br>
	 * 
	 * @param emptyCODMasterVO
	 * @param account
	 * @exception EventException
	 */
	public void manageCODByVVD(EmptyCODMasterVO emptyCODMasterVO, SignOnUserAccount account) throws EventException {
		try {
			List<EmptyCODVVDVO> insertVoList1 = new ArrayList<EmptyCODVVDVO>();
			List<EmptyCODVVDPortVO> insertVoList2 = new ArrayList<EmptyCODVVDPortVO>();

			List<EmptyCODVVDVO> deleteVoList1 = new ArrayList<EmptyCODVVDVO>();
			List<EmptyCODVVDPortVO> deleteVoList2 = new ArrayList<EmptyCODVVDPortVO>();

			EmptyCODVVDPortVO[] emptyCODVVDPortVO = null;
			emptyCODVVDPortVO = emptyCODMasterVO.getEmptycodvvdportaddvos();
			EmptyCODVVDVO[] emptyCODVVDVO = null;
			emptyCODVVDVO = emptyCODMasterVO.getEmptycodvvdvos();

			if (emptyCODVVDPortVO != null) {
				for (int i = 0; i < emptyCODVVDPortVO.length; i++) {
					if (emptyCODVVDPortVO[i].getStatus().equals("I") || emptyCODVVDPortVO[i].getStatus().equals("D")) {
						deleteVoList2.add(emptyCODVVDPortVO[i]); 
					}
				}
			}
			if (emptyCODVVDVO != null) {
				for (int i = 0; i < emptyCODVVDVO.length; i++) {
					if (emptyCODVVDVO[i].getStatus().equals("I")) {

						deleteVoList1.add(emptyCODVVDVO[i]); 
					}
				}
			}

			if (emptyCODVVDVO != null) {
				for (int i = 0; i < emptyCODVVDVO.length; i++) {
					if (emptyCODVVDVO[i].getStatus().equals("I")) {
						emptyCODVVDVO[i].setCreusrid(account.getUsr_id());
						emptyCODVVDVO[i].setUpdusrid(account.getUsr_id());
						emptyCODVVDVO[i].setOfccd(account.getOfc_cd());

						if (emptyCODVVDVO[i].getDiv().equals("B") || emptyCODVVDVO[i].getDiv().equals("I")) {
							emptyCODVVDVO[i].setDiv("S");
						}
						else if (emptyCODVVDVO[i].getDiv().equals("C")) { 
							emptyCODVVDVO[i].setDiv("M");
						}
						
						insertVoList1.add(emptyCODVVDVO[i]);
					}
				}
			}

			if (emptyCODVVDPortVO != null) {
				for (int i = 0; i < emptyCODVVDPortVO.length; i++) {
					if (emptyCODVVDPortVO[i].getStatus().equals("I")) {
						emptyCODVVDPortVO[i].setCreusrid(account.getUsr_id());
						emptyCODVVDPortVO[i].setUpdusrid(account.getUsr_id());
						emptyCODVVDPortVO[i].setOfccd(account.getOfc_cd());
						if("SKIP".equals(emptyCODVVDPortVO[i].getEtb())){
							emptyCODVVDPortVO[i].setEtb("");
						}
						insertVoList2.add(emptyCODVVDPortVO[i]);

					}
				}

			}
			
			if (deleteVoList2.size() > 0) {
				dbDao.deleteEmptyCODVVDPort(deleteVoList2);
			}

			if (deleteVoList1.size() > 0) {
				dbDao.deleteEmptyCODVVD(deleteVoList1);
			}

			if (insertVoList1.size() > 0) {
				dbDao.addEmptyCODVVD(insertVoList1);
			}

			if (insertVoList2.size() > 0) {
				dbDao.addEmptyCODVVDPort(insertVoList2);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Simulation Save" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Simulation Save" })
					.getMessage(), ex);
		}
	}

	/**
	 * [MTY COD Confirmation] [Retrieve] <br>
	 * 
	 * @param vvd
	 * @param version
	 * @param emptyCODMasterVO
	 * @return List<EmptyCODMasterVO>
	 * @exception EventException
	 */
	public EmptyCODMasterVO searchMTYREPOPlan(String vvd, String version, EmptyCODMasterVO emptyCODMasterVO)
			throws EventException {
		try {
			List<EmptyCODVVDPort01VO> emptyCODMasterVO0 = new ArrayList<EmptyCODVVDPort01VO>();
			List<EmptyCODVVDPort01VO> emptyCODMasterVO1 = new ArrayList<EmptyCODVVDPort01VO>();
			List<EmptyCODVVDPort01VO> emptyCODMasterVO2 = new ArrayList<EmptyCODVVDPort01VO>();

			if (version.equals("I")) { // BayPlan
				EmptyCODVVDPort01VO vo = new EmptyCODVVDPort01VO();
				vo.setPodCd("Volume by POD");
				vo.setYdCd("Volume by POD");
				vo.setD2("");
				vo.setD4("");
				vo.setD5("");
				vo.setD7("");
				vo.setR2("");
				vo.setR5("");
				vo.setR9("");
				vo.setO2("");
				vo.setS2("");
				vo.setO4("");
				vo.setS4("");
				vo.setF2("");
				vo.setA2("");
				vo.setF4("");
				vo.setA4("");
				vo.setF5("");
				vo.setO5("");
				emptyCODMasterVO0.add(0, vo);
				vo = new EmptyCODVVDPort01VO();
				vo.setPodCd("Additional Load");
				vo.setYdCd("Additional Load");
				vo.setD2("");
				vo.setD4("");
				vo.setD5("");
				vo.setD7("");
				vo.setR2("");
				vo.setR5("");
				vo.setR9("");
				vo.setO2("");
				vo.setS2("");
				vo.setO4("");
				vo.setS4("");
				vo.setF2("");
				vo.setA2("");
				vo.setF4("");
				vo.setA4("");
				vo.setF5("");
				vo.setO5("");
				emptyCODMasterVO0.add(1, vo);
				emptyCODMasterVO1 = dbDao.searchMTYREPOPlanL(vvd, "L",version);
				emptyCODMasterVO2 = dbDao.searchMTYREPOPlan2(vvd);
			}
			else if (version.equals("C")) { // ConFirm
				emptyCODMasterVO0 = dbDao.searchMTYREPOPlanV(vvd, "C",version);
				emptyCODMasterVO1 = dbDao.searchMTYREPOPlanL(vvd, "L",version);
				emptyCODMasterVO2 = dbDao.searchMTYREPOPlanD(vvd, "D",version);
			}
			else if (version.equals("B")) { // Intra BKG
				EmptyCODVVDPort01VO vo = new EmptyCODVVDPort01VO();
				vo.setPodCd("Volume by POD");
				vo.setYdCd("Volume by POD");
				vo.setD2("");
				vo.setD4("");
				vo.setD5("");
				vo.setD7("");
				vo.setR2("");
				vo.setR5("");
				vo.setR9("");
				vo.setO2("");
				vo.setS2("");
				vo.setO4("");
				vo.setS4("");
				vo.setF2("");
				vo.setA2("");
				vo.setF4("");
				vo.setA4("");
				vo.setF5("");
				vo.setO5("");
				emptyCODMasterVO0.add(0, vo);
				vo = new EmptyCODVVDPort01VO();
				vo.setPodCd("Additional Load");
				vo.setYdCd("Additional Load");
				vo.setD2("");
				vo.setD4("");
				vo.setD5("");
				vo.setD7("");
				vo.setR2("");
				vo.setR5("");
				vo.setR9("");
				vo.setO2("");
				vo.setS2("");
				vo.setO4("");
				vo.setS4("");
				vo.setF2("");
				vo.setA2("");
				vo.setF4("");
				vo.setA4("");
				vo.setF5("");
				vo.setO5("");
				emptyCODMasterVO0.add(1, vo);
				emptyCODMasterVO1 = dbDao.searchMTYREPOPlanL(vvd, "L",version);
				emptyCODMasterVO2 = dbDao.searchMTYREPOPlanD(vvd, "D",version);
			}
			else if(!version.equals("##")){
				EmptyCODVVDPort01VO vo = new EmptyCODVVDPort01VO();
				vo.setPodCd("Volume by POD");
				vo.setYdCd("Volume by POD");
				vo.setD2("");
				vo.setD4("");
				vo.setD5("");
				vo.setD7("");
				vo.setR2("");
				vo.setR5("");
				vo.setR9("");
				vo.setO2("");
				vo.setS2("");
				vo.setO4("");
				vo.setS4("");
				vo.setF2("");
				vo.setA2("");
				vo.setF4("");
				vo.setA4("");
				vo.setF5("");
				vo.setO5("");
				emptyCODMasterVO0.add(0, vo);
				vo = new EmptyCODVVDPort01VO();
				vo.setPodCd("Additional Load");
				vo.setYdCd("Additional Load");
				vo.setD2("");
				vo.setD4("");
				vo.setD5("");
				vo.setD7("");
				vo.setR2("");
				vo.setR5("");
				vo.setR9("");
				vo.setO2("");
				vo.setS2("");
				vo.setO4("");
				vo.setS4("");
				vo.setF2("");
				vo.setA2("");
				vo.setF4("");
				vo.setA4("");
				vo.setF5("");
				vo.setO5("");
				emptyCODMasterVO0.add(1, vo);				
				
			}

			String txtHRD = dbDao.searchHRDInformation(vvd); // HR,Rev.MTY,DMG 
			EmptyCODMasterVO list = new EmptyCODMasterVO();

			list.setListEmptyCODVVDPortVO00(emptyCODMasterVO0);
			list.setListEmptyCODVVDPortVO01(emptyCODMasterVO1);
			list.setListEmptyCODVVDPortVO02(emptyCODMasterVO2);
			list.setTxtHRD(txtHRD);

			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Confirmation Retrieve" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MTY COD Confirmation Retrieve" })
					.getMessage(), ex);
		}
	}

	/**
	 * [VVDInformation] [Retrieve]<br>
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVVDInformation(String vvd) throws EventException {
		try {
			log.debug("####### EmptyCODAdjustmentBCImpl.searchVVDInformation 1039 @@@@@@@@@@");
			return dbDao.searchVVDInformation(vvd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * [YardNETBByVVDPort] [Retrieve]<br>
	 * 
	 * @param vvd
	 * @param port
	 * @param editIbFlag
	 * @return List<EmptyCODMasterVO>
	 * @exception EventException
	 */
	public List<EmptyCODPortSumVO> searchYardNETBByVVDPort(String vvd, String port, String editIbFlag)
			throws EventException {
		try {
			return dbDao.searchYardNETBByVVDPort(vvd, port, editIbFlag);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * [YardNETBByPort] [Retrieve]<br>
	 * 
	 * @param vvd
	 * @param port
	 * @param editIbFlag
	 * @return List<EmptyCODMasterVO>
	 * @exception EventException
	 */
	public List<EmptyCODPortSumVO> searchYardNETBByPort(String vvd, String port, String editIbFlag)
			throws EventException {
		try {
			return dbDao.searchYardNETBByPort(vvd, port, editIbFlag);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * [RevenueMTYList] [Retrieve]<br>
	 * 
	 * @param vvd
	 * @param pod
	 * @param damageRevenueEmptyListVO
	 * @return DamageRevenueEmptyListVO
	 * @exception EventException
	 */
	public DamageRevenueEmptyListVO searchRevenueMTYList(String vvd, String pod,
			DamageRevenueEmptyListVO damageRevenueEmptyListVO) throws EventException {
		try {
			List<DamageRevenueEmptyList01VO> list01 = new ArrayList<DamageRevenueEmptyList01VO>();
			List<DamageRevenueEmptyList01VO> list02 = new ArrayList<DamageRevenueEmptyList01VO>();
			List<RevenueMTYListCntrTpSzVO> list03 = new ArrayList<RevenueMTYListCntrTpSzVO>();

			list01 = dbDao.searchRevenueMTYList01(vvd, pod);
			list02 = dbDao.searchRevenueMTYList02(vvd, pod);
			list03 = dbDao.searchRevenueMTYList03(vvd, pod);

			DamageRevenueEmptyListVO list = new DamageRevenueEmptyListVO();

			list.setDamageRevenueEmptyListVO01(list01);
			list.setDamageRevenueEmptyListVO02(list02);
			list.setRevenueMTYListCntrTpSzVO(list03);

			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "Revenue MTY CNTR List Retrieve" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "Revenue MTY CNTR List Retrieve" })
					.getMessage(), ex);
		}
	}

	/**
	 * [DamageHangerMTYList] [Retrieve]<br>
	 * 
	 * @param damageRevenueListOptionVO
	 * @param damageRevenueEmptyListVO
	 * @return DamageRevenueEmptyListVO
	 * @exception EventException
	 */
	public DamageRevenueEmptyListVO searchDamageHangerMTYList(DamageRevenueListOptionVO damageRevenueListOptionVO,
			DamageRevenueEmptyListVO damageRevenueEmptyListVO) throws EventException {
		try {
			List<MasterContainerListVO> list01 = new ArrayList<MasterContainerListVO>();
			List<BookingContainerListVO> list02 = new ArrayList<BookingContainerListVO>();
			List<RevenueMTYListCntrTpSzVO> list03 = new ArrayList<RevenueMTYListCntrTpSzVO>();

			list01 = dbDao.searchDamageHangerMTYList01(damageRevenueListOptionVO);
			list02 = dbDao.searchDamageHangerMTYList02(damageRevenueListOptionVO);
			list03 = dbDao.searchDamageHangerMTYList03(damageRevenueListOptionVO);

			DamageRevenueEmptyListVO list = new DamageRevenueEmptyListVO();

			list.setMasterContainerListVO(list01);
			list.setBookingContainerListVO(list02);
			list.setRevenueMTYListCntrTpSzVO(list03);

			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "DMG MTY CNTR List Retrieve" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "DMG MTY CNTR List Retrieve" })
					.getMessage(), ex);
		}
	}

	/**
	 * [PODListByVVD] [Retrieve]<br>
	 * 
	 * @param vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVvdRemark(String vvd) throws EventException { 
		try {
			return dbDao.searchVvdRemark(vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "VVD Remark Retrieve" }).getMessage(),
					ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "VVD Remark Retrieve" }).getMessage(),
					ex);
		}

	}

	/**
	 * [VvdRemark] [Retrieve]<br>
	 * 
	 * @param emptyCODVVDVO
	 * @param account
	 * @exception EventException
	 */
	public void saveVvdRemark(EmptyCODVVDVO emptyCODVVDVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.saveVvdRemark(emptyCODVVDVO, account.getUsr_id(), account.getOfc_cd());

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "VVD Remark Save" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "VVD Remark Save" }).getMessage(), ex);
		}
	}

	/**
	 * Delete Event<br>
	 * @param emptyCODVVDVO
	 * @exception EventException
	 */
	public void deleteVvdRemark(EmptyCODVVDVO emptyCODVVDVO) throws EventException {
		try {
			dbDao.deleteVvdRemark(emptyCODVVDVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "VVD Remark Delete" }).getMessage(),
					ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "VVD Remark Delete" }).getMessage(),
					ex);
		}
	}

	/**
	 * searchYardCode <br>
	 * @param yardcode
	 * @return String
	 * @exception EventException
	 */
	public String searchYardCode(String yardcode) throws EventException {
		try {

			return dbDao.searchYardCode(yardcode);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "Yard Code Retrieve" }).getMessage(),
					ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "Yard Code Retrieve" }).getMessage(),
					ex);
		}
	}
	
	/**
	 * searchMnlInpFlgCheck <br> 
	 * @param vvd
	 * @return String
	 * @exception EventException
	 */
	private String searchMnlInpFlgCheck(String vvd) throws EventException {
		try {

			return dbDao.searchMnlInpFlgCheck(vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MnlInpFlgCheck Retrieve" }).getMessage(),
					ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[] { "MnlInpFlgCheck Retrieve" }).getMessage(),
					ex);
		}
	}	
	
	/**
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException 
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException {
		String check = null;
		try {		
			check = dbDao.checkLocation(locLevel ,locCD);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("EQR10028",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	

}