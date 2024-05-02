/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralInvoiceAuditBCImpl.java
 *@FileTitle : Requested MSA
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration.GeneralInvoiceAuditDBDAO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.ExpressionListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.IoRatioVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.RoundTruncVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TermDueVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommonutil.BizComPsoUtil;
import com.clt.apps.opus.vop.pso.psocommonutil.PsoConstants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.PsoChargeVO;
import com.clt.syscommon.common.table.PsoChgDtlVO;
import com.clt.syscommon.common.table.PsoYdChgVO;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 *
 * @author
 * @see Reference each DAO class of
 *      VOP_PSO-0018EventResponse,GeneralInvoiceAuditBC
 * @since J2EE 1.6
 */
public class GeneralInvoiceAuditBCImpl extends BasicCommandSupport implements GeneralInvoiceAuditBC {

	// Database Access Object
	private transient GeneralInvoiceAuditDBDAO dbDao = null;

	// HashMap<String, String> MAP_OBJ_VAL = new HashMap<String, String>();

	/**
	 * Creating object GeneralInvoiceAuditBCImpl<br>
	 * Creating GeneralInvoiceAuditDBDAO<br>
	 */
	public GeneralInvoiceAuditBCImpl() {
		dbDao = new GeneralInvoiceAuditDBDAO();
		// initMapObjVal();
	}

	/**
	 * parameterized constructor
	 * 
	 * @param dataSource
	 */
	public GeneralInvoiceAuditBCImpl(String dataSource) {
		dbDao = new GeneralInvoiceAuditDBDAO(dataSource);
		// initMapObjVal();
	}

	/**
	 * Put in action Tariff calculation by using key value input and parameter
	 * value
	 * 
	 * @category TariffCalcEngine
	 * @param CalcTariffVO calcTariffVO
	 * @return CalcTariffResultVO
	 * @throws EventException
	 */
	public CalcTariffResultVO calGeneralInvAudit(CalcTariffVO calcTariffVO) throws EventException {
		log.debug(	"\n============================================================================"+
					"\n Tariff calGeneralInvAudit START."+
					"\n============================================================================");
		int rowsNumberOfDesc = 0;
		CalcTariffResultVO vo = new CalcTariffResultVO();

		List<ExpressionListVO> list = null;
		//
		try {
			// Sorting : B, S, D
			list = dbDao.searchExpression(calcTariffVO.getYdChgNo(), calcTariffVO.getYdChgVerSeq());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : searchExpression" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : searchExpression" }).getMessage(), ex);
		}

		float fval = 0;
		float fval2 = 0;
		CalcTariffResultVO resultvo = null;
		StringBuilder dspSb = new StringBuilder();
		StringBuilder runSb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			ExpressionListVO listvo = list.get(i);
			// map.put("CalcType", listvo.getPsoChgTpCd());
			calcTariffVO.setCalcType(listvo.getPsoChgTpCd());
			boolean isContinue = false;
			try {
				if (listvo.getSysXprDesc() != null && !"".equals(listvo.getSysXprDesc())) {
					//if (!listvo.getSysXprDesc().equals(""))
						// if(listvo.getValflg().equals("Y"))
					log.debug(	"\n============================================================================"+
								"\n>>------------------->[Tariff calcTariff Info Start]" +
								"\n>>from		:=" +calcTariffVO.getFrom() +
								"\n>>vvd		:=" +calcTariffVO.getVvd() +
								"\n>>ydCd		:=" + calcTariffVO.getYdCd() +
								"\n>>clptIndSeq :=" + calcTariffVO.getClptIndSeq() +
								"\n>>ydChgNo	:=" + calcTariffVO.getYdChgNo() +
								"\n>>ydChgVerSeq:=" + calcTariffVO.getYdChgVerSeq() +
								"\n>>chgXprNo	:=" + listvo.getChgXprNo() +
								"\n>>calcType	:=" + calcTariffVO.getCalcType() +
								"\n>>------------------->[Tariff calcTariff Info E n d]" +
							    "\n============================================================================");
					
					resultvo = calcTariff(calcTariffVO, listvo);
				}
			} catch (Exception ex) {
				isContinue = true;
				log.error("\n##########################################################\nTariff Calculation : calcTariff Exception. isContinue ["+isContinue+"]");
				continue;
				//throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : calcTariff" }).getMessage(), ex);
			}

			if (resultvo != null) {
				if (!resultvo.getTariffAmount().equals("") && !resultvo.getTariffAmount().equals("empty") && resultvo.getTariffAmount() != null) {

					if (listvo.getPsoChgTpCd().equals("D")){ // Discount -=
						fval -= Float.parseFloat(resultvo.getTariffAmount());
					} else {
						fval2 = Float.parseFloat(resultvo.getTariffAmount());
						fval += fval2;// Float.parseFloat(resultvo.getTariffAmount());
					}
					if (listvo.getPsoChgTpCd().equals("B")) {
						dspSb.append("[B]: " + resultvo.getDisplayFormulaDesc());
						runSb.append("[B]: " + resultvo.getRuntimeFormulaDesc());

						// map.put("Base", fval+"");
						calcTariffVO.setBase(fval + "");
						calcTariffVO.setBaseTariffAmount(fval + ""); // 2015.04.16 NYK Add S/D 일때 분기를 하기 위한 부분입니다.

						rowsNumberOfDesc++;
					} else if (listvo.getPsoChgTpCd().equals("S")) {
						dspSb.append("\n[S]: " + resultvo.getDisplayFormulaDesc());
						runSb.append("\n[S]: " + resultvo.getRuntimeFormulaDesc());

						// map.put("Surcharge", fval2+"");
						calcTariffVO.setSurcharge(fval2 + "");

						rowsNumberOfDesc++;
					} else if (listvo.getPsoChgTpCd().equals("D")) {
						dspSb.append("\n[D]: " + resultvo.getDisplayFormulaDesc());
						runSb.append("\n[D]: " + resultvo.getRuntimeFormulaDesc());

						rowsNumberOfDesc++;
					}
				} else {
					if (listvo.getPsoChgTpCd().equals("B")) {
						dspSb.append("[B]: " + resultvo.getDisplayFormulaDesc());
						runSb.append("[B]: " + resultvo.getRuntimeFormulaDesc());

						rowsNumberOfDesc++;
					} else if (listvo.getPsoChgTpCd().equals("S")) {
						dspSb.append("\n[S]: " + resultvo.getDisplayFormulaDesc());
						runSb.append("\n[S]: " + resultvo.getRuntimeFormulaDesc());

						rowsNumberOfDesc++;
					} else if (listvo.getPsoChgTpCd().equals("D")) {
						dspSb.append("\n[D]: " + resultvo.getDisplayFormulaDesc());
						runSb.append("\n[D]: " + resultvo.getRuntimeFormulaDesc());

						rowsNumberOfDesc++;
					}

				}
				
				if (resultvo.getTariffObjList() != null && resultvo.getTariffObjList().size() > 0) {
					vo.setTariffObjList(resultvo.getTariffObjList());
				}
				
				log.debug(  "\n============================================================================"+
							"\n>>------------------->[After Tariff Ammount Start]" +
							"\nPsoChgTpCd         :=" +listvo.getPsoChgTpCd() +
							"\nResult TariffAmount:=" + resultvo.getTariffAmount() +
							"\nBase Tariff Amount :=" + calcTariffVO.getBaseTariffAmount() +
							"\nyfval              :=" + fval +
							"\nyfval2             :=" + fval2 +
							"\ndspSb              :=" + dspSb.toString() +
							"\nrunSb              :=" + runSb.toString() +
							"\n>>------------------->[After Tariff Ammount E n d]" +
						  	"\n============================================================================");
				
			}			
		}

		// calculating by outbound value
		RoundTruncVO rtvo1in = new RoundTruncVO();
		rtvo1in.setIoBndCd("O");
		rtvo1in.setRatio("100");
		rtvo1in.setCurrCd(calcTariffVO.getCurrCd());// map.get("currCd"));
		rtvo1in.setCalcAmt(fval + "");
		log.debug("\ncalGeneralInvAudit Before Outbound TariffAmount CalcAmt ["+rtvo1in.getCalcAmt()+"]");
		RoundTruncVO rtvo1out1 = new RoundTruncVO();
		try {
			rtvo1out1 = dbDao.getRoundTruncAmt(rtvo1in);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getRoundTruncAmt" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getRoundTruncAmt" }).getMessage(), ex);
		}
		log.debug("\ncalGeneralInvAudit After Outbound TariffAmount CalcAmt ["+rtvo1out1.getCalcAmt()+"]");
		fval = Float.parseFloat(rtvo1out1.getCalcAmt());

		if (resultvo != null) {
			log.debug("\ncalGeneralInvAudit TariffAmount setting value ["+fval+"]");
			vo.setTariffAmount(fval + "");
			// vo.setDisplayFormulaDesc(resultvo.getDisplayFormulaDesc());
			// vo.setRuntimeFormulaDesc(resultvo.getRuntimeFormulaDesc());
			vo.setDisplayFormulaDesc(dspSb.toString());
			vo.setRuntimeFormulaDesc(runSb.toString());

			vo.setPagerows(rowsNumberOfDesc + "");

			// vo.setTariffObjList(resultvo.getTariffObjList());
		}
		
		log.debug("\n============================================================================"+
				  "\n Tariff calGeneralInvAudit E N D."+
				  "\n============================================================================");
		return vo;
	}

	/**
	 * Put in action actual Tariff calculation while interpreting ObjectList
	 * 
	 * @param CalcTariffVO calcTariffVO
	 * @param ExpressionListVO expressListVO
	 * @return CalcTariffResultVO
	 * @throws EventException
	 */
	private CalcTariffResultVO calcTariff(CalcTariffVO calcTariffVO, ExpressionListVO expressListVO) throws EventException {
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation START."+
				  "\n============================================================================");
		String prefixLogText = "\nm(^^)m ==> ";
		CalcTariffResultVO vo = new CalcTariffResultVO();
		String regex = "(\\[[0-9]+\\]@[0-9]+<[0-9]+>)|(\\[[0-9]+\\]@[0-9]+)|(\\[[0-9]+\\])";
		String input = expressListVO.getSysXprDesc();

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input); // get a matcher object

		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		while (m.find()) {
			if (tMap.get(m.start()) == null) {
				tMap.put(m.start(), input.substring(m.start(), m.end()));
			}
		}

		Object[] strObjs = tMap.values().toArray();

		log.debug(prefixLogText+"Tariff Calculation expressListVO.getSysXprDesc():=\n" + expressListVO.getSysXprDesc());
		
		if (strObjs.length == 0) {
			log.debug(prefixLogText+" There is no any Objects.");
			return null;
		}

		int[] objNos = new int[strObjs.length];
		int[] refObjNos = new int[strObjs.length];

		HashMap<String, String> hMap = new HashMap<String, String>();
		String strTmp = "";
		String[] strList = null;
		String tariffNo = "";

		String strObjVal = "";
		String strRate = "";
		String strObjListNo = "";

		String vvd 			= calcTariffVO.getVvd();	// map.get("vvd");//vvd
		String ydCd 		= calcTariffVO.getYdCd();	// map.get("ydCd");//YD_CD
		String lgsCostCd 	= calcTariffVO.getLgsCostCd();	// map.get("lgsCostCd");//Logistics
		String ydChgNo 		= calcTariffVO.getYdChgNo();	// map.get("ydChgNo");
		String ydChgVerSeq 	= calcTariffVO.getYdChgVerSeq();// map.get("ydChgVerSeq");
		String strType 		= calcTariffVO.getCalcType();	// map.get("CalcType");

		String clptIndSeq 	= calcTariffVO.getClptIndSeq();//2016.04.26 Double calling port Add

		//2015.12.23 Regular Value 저장.
		HashMap<String, String> regularValueMap = new HashMap<String, String>();
		//2016.04.26 Double calling port Add 조건 추가 : clptIndSeq 가 존재 하지 않을때 MIN 으로 재조회 한다.
		if(StringUtils.isEmpty(clptIndSeq)){
			try {
				clptIndSeq = dbDao.selectClptIndSeq(vvd, ydCd);// expr
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : selectClptIndSeq" }).getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : selectClptIndSeq" }).getMessage(), ex);
			}
		}
		
		log.debug(prefixLogText+" Before VVD Data vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]");
		//2016.04.06 Add : 버츄얼이 아닌 실제 VVD를 조회 한다. 
		//SCWT0022N|SGSIN04|1|SGSIN : vvd|ydcd|clptIndSeq|port
		String validVvd = getValidVvd(vvd, ydCd, clptIndSeq);
		if(!StringUtils.isEmpty(validVvd)){
			String arrayValidVvd[] = validVvd.split("\\|", 4);
			vvd 		= StringUtils.isEmpty(arrayValidVvd[0]) ? vvd 			: arrayValidVvd[0];
			ydCd 		= StringUtils.isEmpty(arrayValidVvd[1]) ? vvd 			: arrayValidVvd[1];
			clptIndSeq 	= StringUtils.isEmpty(arrayValidVvd[2]) ? clptIndSeq 	: arrayValidVvd[2];
		}
		log.debug(prefixLogText+" After VVD Data vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]");
		
		String repVslCd = "";// TBN항차에 대응하는 대응항차
		String cntrVslClssCapa = calcTariffVO.getCntrVslClssCapa();
		try {
			repVslCd = dbDao.getRepVslCd(vvd, cntrVslClssCapa);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getRepVslCd" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getRepVslCd" }).getMessage(), ex);
		}

		String repVvd = "";
		if (repVslCd != null) {
			if (!repVslCd.equals("")) {
				repVvd = repVslCd + vvd.substring(4);
			} else {
				repVvd = vvd;
			}
		} else {
			repVvd = vvd;
		}

		
		//2016.04.18 Null Object Default Case에서 [45]@1111<37> or [45]@1111 일때의 Object를 템프 변수에 Get 하고 비교 로직을 태움.
		String tmpRangeObjNo = "";
		
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Object Setting START."+
				  "\n============================================================================");
		/**
		 * 2009.12.16 repVvd를 사용해야 할 Object List
		 * 1,13,14,16,28,29,30,31,35,36,39,58,63,73,74,81,82,83,87,99
		 * 
		 */
		for (int i = 0; i < strObjs.length; i++) {
			// [##]@##의 형태를 해석해야 한다.
			strTmp = strObjs[i].toString();
			// [45]@254<28>
			strList = strTmp.split("@");// 0번째는 -> OBJECT 1번째는 Tariff NUmber
			
			log.debug(prefixLogText+"Tariff Calculation Object Loop strObjs[i] [" + strTmp+"].");
			
			if (strList != null && strList.length >= 2) {
				String[] strInfo = strList[1].split("<");
				if (strInfo.length >= 2) {
					objNos[i] = Integer.parseInt(strList[0].replace("[", "").replace("]", ""));
					tariffNo = strInfo[0];
					refObjNos[i] = Integer.parseInt(strInfo[1].replace("<", "").replace(">", ""));
				} else {// [45]@254
					objNos[i] = Integer.parseInt(strList[0].replace("[", "").replace("]", ""));
					tariffNo = strList[1];
				}
			} else {
				// String[] strInfo=strList[0].split("<");
				// if(strInfo!=null){
				// if(strInfo.length >= 2){
				// objNos[i] = Integer.parseInt(strInfo[0].replace("[",
				// "").replace("]", ""));
				// refObjNos[i] = Integer.parseInt(strInfo[1].replace("<",
				// "").replace(">", ""));
				// }
				// else{
				objNos[i] = Integer.parseInt(strList[0].replace("[", "").replace("]", ""));
				// }
				// }
			}

			log.debug(prefixLogText+"==CHECK FROM :=["+calcTariffVO.getFrom()+"] CHECK Object NO :=["+strObjs[i].toString()+"] ==> CHECK Value :=["+calcTariffVO.hMap.get(strObjs[i].toString())+"]=================");
			
			if (objNos[i] != 45 && objNos[i] != 46 && objNos[i] != 117 && calcTariffVO.getFrom().equals("SIMULATION")) {
				log.debug(prefixLogText+"==============SIMULATION && ![45] && ![46] && ![117] Case objNo:=["+strObjs[i].toString()+"]=================");
				switch (objNos[i]) {
					case 18:// Constant1
					case 19:// Constant2
					case 20:// Constant3
					case 21:// Constant4
					case 22:// Constant5
						String strConstant = "1";
						hMap.put(strObjs[i].toString(), strConstant); // Setting '1'
						log.debug(prefixLogText+"SIMULATION Constant1,2,3,4,5 ["+strObjs[i].toString()+"]:=["+strConstant+"]");
						break;
					default : 
						String strDefaultValue = calcTariffVO.hMap.get(strObjs[i].toString());
						log.debug(prefixLogText+"SIMULATION Other Object Before ["+strObjs[i].toString()+"] is default value ["+strDefaultValue+"]");

						//2016.02.26 Modify.
						if(strDefaultValue.equals("null")) strDefaultValue = "";
						
						log.debug(prefixLogText+"SIMULATION Other Object After 1 ["+strObjs[i].toString()+"] is default value ["+strDefaultValue+"]");
						
						hMap.put(strObjs[i].toString(), strDefaultValue);
						
						log.debug(prefixLogText+"SIMULATION Other Object After 2 ["+strObjs[i].toString()+"]:=["+strDefaultValue+"]");
						break;
				}
				
				//hMap.put(strObjs[i].toString(), calcTariffVO.hMap.get(strObjs[i].toString()));
			} else {
				log.debug(prefixLogText+"==============TARIFF NO:=[" + tariffNo +"] objNo:=["+objNos[i]+"]=================");
				String strCaseText = prefixLogText+" Case ["+objNos[i]+"] =>";
				switch (objNos[i]) {
				/**
				 * PSO_OBJ_CD - PSO_OBJ_CD_DSP - PSO_MEAS_UT_CD - PSO_MEAS_UT_CD_DSP - OBJ_LIST_NO
				 * 
				 * 32 - Arrival Draft - 3 - METER - 47
				 * 32 - Arrival Draft - 4 - FEET - 2
				 * 49 - Arrival Draft - 1 - 3 - METER - 48
				 * 49 - Arrival Draft - 1 - 4 - FEET - 49 - 
				 * 50 - Arrival Line Handing Hour - 1 - HOUR - 50 - 
				 * 51 - Arrival No. of TUG - 5 - EA (COUNT) - 6
				 * 52 - Arrival POB - 1 - HOUR - 51 - 
				 * 7 - Arrival Tug Power - 6 - HP - 8
				 * 20 - Arrival Tug Used Hour - 1 - HOUR - 10
				 * 53 - Barge - 12 - FLAG - 52
				 * 35 - Boat - 12 - FLAG - 17
				 * 58 - Buoy - 12 - FLAG - 57
				 * 33 - Departure Draft - 3METER - 3
				 * 68 - Departure Draft 1 - 3 - METER - 25
				 * 69 - Departure Draft 2 - 4 - FEET - 26
				 * 70 - Departure Line handing Hour - 1 - HOUR - 60
				 * 71 - Departure No. of TUG - 5 - EA (COUNT) - 7
				 * 72 - Departure POB - 1 - HOUR - 61
				 * 73 - Departure TUG used Hour - 1 - HOUR - 62
				 * 46 - Departure Tug Power - 6 - HP - 9
				 * 47 - Departure Tug Used Hour - 1 - HOUR - 11
				 * 82 - Holiday - 12 - FLAG - 75
				 * 83 - I/B Volume/Blocksize - 11 - N/A (BLANK) - 76
				 * 84 - IN - 12 - FLAG - 77
				 * 38 - Inbound Volume - 7 - TON - 32
				 * 85 - Inspection - 12 - FLAG - 78
				 * 123 - Limit Time - 11 - N/A (BLANK) - 116
				 * 93 - Night - 12 - FLAG - 86
				 * 95 - O/B Volume/Blocksize - 11 - N/A (BLANK) - 88
				 * 96 - OUT - 12 - FLAG - 89
				 * 39 - Outbound Volume - 7 - TON - 33
				 * 121 - SDR - 11 - N/A (BLANK) - 114
				 * 104 - Sanitation - 12 - FLAG - 97
				 * 37 - Sluge Volume - 7 - TON - 40
				 * 122 - TIER - 11 - N/A (BLANK) - 115
				 * 116 - TUG - Rope - 12 - FLAG - 110
				 */
				case 1: // Allowance TEU
					// SELECT CNTR_PNM_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD =
					// :VSL_CD
					String strAllwTeu = getAllwTeu(repVvd);
					hMap.put(strObjs[i].toString(), strAllwTeu);
					log.debug(strCaseText+" Allowance TEU ["+strObjs[i].toString()+"]:=["+strAllwTeu+"]");
					break;
				case 2: // Arrival Draft Feet
					String strArvDrft = getArvDrftFeet(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strArvDrft);
					log.debug(strCaseText+" Arrival Draft Feet ["+strObjs[i].toString()+"]:=["+strArvDrft+"]");
					break;
				case 3: // Departure Draft Meter
				case 25: // Departure Draft1 Meter
					String strDprDftMeter = getDprDftMeter(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDprDftMeter);
					log.debug(strCaseText+" Departure Draft Meter["+strObjs[i].toString()+"]:=["+strDprDftMeter+"]");
					break;

				case 4: // Arrival No. of Tractor
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					String strArvNoOfTrk = getArvNoOfTrk(ydChgNo, ydChgVerSeq, 4 + "");
					hMap.put(strObjs[i].toString(), strArvNoOfTrk);
					log.debug(strCaseText+" Arrival No. of Tractor["+strObjs[i].toString()+"]:=["+strArvNoOfTrk+"]");
					break;
				case 5: // Departure No. of Tractor
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					String strDprNoOfTrk = getDprNoOfTrk(ydChgNo, ydChgVerSeq, 5 + "");
					hMap.put(strObjs[i].toString(), strDprNoOfTrk);
					log.debug(strCaseText+" Departure No. of  Tractor["+strObjs[i].toString()+"]:=["+strDprNoOfTrk+"]");
					break;
				case 6: // Arrival No. of Tug
					// SELECT T1.ARR_TUG_BOT_KNT FROM VSK_ACT_PORT_SKD T1,
					// VSK_VSL_PORT_SKD T2 WHERE 1 = 1 AND T1.VSL_CD = T2.VSL_CD
					// AND T1.SKD_VOY_NO = T2.SKD_VOY_NO AND T1.SKD_DIR_CD =
					// T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND
					// T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX'
					// AND T1.SKD_VOY_NO = '0036' AND T1.SKD_DIR_CD = 'E' AND
					// T2.YD_CD = 'KRINCYP'

					String strArvNoOfTug = getArvNoOfTug(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strArvNoOfTug);
					log.debug(strCaseText+" Arrival No. of Tug ["+strObjs[i].toString()+"]:=["+strArvNoOfTug+"]");
					break;
				case 7: // Departure No. of Tug

					String strDprNoOfTug = getDprNoOfTug(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDprNoOfTug);
					log.debug(strCaseText+" Departure No. of Tug ["+strObjs[i].toString()+"]:=["+strDprNoOfTug+"]");
					break;
				case 8: // Arrival Tug Power
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO
					String strArvTugPwr = getArvTugPwr(ydChgNo, ydChgVerSeq, 8 + "");
					hMap.put(strObjs[i].toString(), strArvTugPwr);
					log.debug(strCaseText+" Arrival Tug Power ["+strObjs[i].toString()+"]:=["+strArvTugPwr+"]");
					break;
				case 9: // Departure Tug Power
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					String strDprTugPwr = getDprTugPwr(ydChgNo, ydChgVerSeq, 9 + "");
					hMap.put(strObjs[i].toString(), strDprTugPwr);
					log.debug(strCaseText+" Departure Tug Power ["+strObjs[i].toString()+"]:=["+strDprTugPwr+"]");
					break;
				case 10: // Arrival Tug Used Hour
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO
					String strArvTugUsedHour = getArvTugUsedHour(ydChgNo, ydChgVerSeq, 10 + "");
					hMap.put(strObjs[i].toString(), strArvTugUsedHour);
					log.debug(strCaseText+" Arrival Tug Used Hour ["+strObjs[i].toString()+"]:=["+strArvTugUsedHour+"]");
					break;
				case 11: // Departure Tug Used Hour
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					String strDprTugUsedHour = getDprTugUsedHour(ydChgNo, ydChgVerSeq, 11 + "");
					hMap.put(strObjs[i].toString(), strDprTugUsedHour);
					log.debug(strCaseText+" Departure Tug Used Hour ["+strObjs[i].toString()+"]:=["+strDprTugUsedHour+"]");
					break;
				case 13: // BeamFeet
					// SELECT ROUND(VSL_WDT * 3.28, 4) FROM MDM_VSL_CNTR WHERE
					// VSL_CD = 'BAHX'
					String strBeamFeet = getBeamFeet(repVvd);
					hMap.put(strObjs[i].toString(), strBeamFeet);
					log.debug(strCaseText+" BeamFeet ["+strObjs[i].toString()+"]:=["+strBeamFeet+"]");
					break;
				case 14: // BeamMeter
					// SELECT VSL_WDT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'

					String strBeamMeter = getBeamMeter(repVvd);
					hMap.put(strObjs[i].toString(), strBeamMeter);
					log.debug(strCaseText+" BeamMeter ["+strObjs[i].toString()+"]:=["+strBeamMeter+"]");
					break;
				case 15: // Berthing Hour(D-B)
					// SELECT ROUND((VPS_ETD_DT - VPS_ETB_DT) * 24, 2) FROM
					// VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO =
					// '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND
					// CALL_YD_IND_SEQ = '1'
					String strBerthingHour = getBerthingHour(vvd, ydCd, clptIndSeq);
					// if(strBerthingHour == null || strBerthingHour.equals(""))
					// strBerthingHour = "null"; //[2010.04.13:jmh] close
					hMap.put(strObjs[i].toString(), strBerthingHour);
					log.debug(strCaseText+" Berthing Hour(D-B) ["+strObjs[i].toString()+"]:=["+strBerthingHour+"]");
					break;
					
				case 166: // Berthing Date(D-B) //NYK Modify 2014.10.07
					//SELECT (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1
					//FROM VSK_VSL_PORT_SKD 
					//WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0167' AND SKD_DIR_CD = 'E' 
					//AND YD_CD = 'CNSHAM1' AND CALL_YD_IND_SEQ = '1'
					String strBerthingDate = getBerthingDate(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strBerthingDate);
					log.debug(strCaseText+" Berthing Date(D-B) ["+strObjs[i].toString()+"]:=["+strBerthingDate+"]");
					break;
				case 16: // Block Size
					// SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) *
					// NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR
					// WHERE VSL_CD = :VSL_CD
					String strBlockSize = getBlockSize(repVvd);
					hMap.put(strObjs[i].toString(), strBlockSize);
					log.debug(strCaseText+" Block Size ["+strObjs[i].toString()+"]:=["+strBlockSize+"]");
					break;
				case 18:// Constant1
				case 19:// Constant2
				case 20:// Constant3
				case 21:// Constant4
				case 22:// Constant5
					String strConstant = "1";
					hMap.put(strObjs[i].toString(), strConstant); // Setting '1'
					log.debug(strCaseText+" Constant1,2,3,4,5 ["+strObjs[i].toString()+"]:=["+strConstant+"]");
					break;
				case 23:// Country of Last Port
					String strCntLastPort = getCntLastPort(vvd, ydCd, clptIndSeq);
					if (strCntLastPort == null || strCntLastPort.equals(""))
						strCntLastPort = "''/*no found : Country of Last Port*/";
					hMap.put(strObjs[i].toString(), strCntLastPort);
					log.debug(strCaseText+" Country of Last Port ["+strObjs[i].toString()+"]:=["+strCntLastPort+"]");
					break;
				case 24:// Country of Next Port

					String strCntNextPort = getCntNextPort(vvd, ydCd, clptIndSeq);
					if (strCntNextPort == null || strCntNextPort.equals(""))
						strCntNextPort = "''/*no found : Country of Next Port*/";
					hMap.put(strObjs[i].toString(), strCntNextPort);
					log.debug(strCaseText+" Country of Next Port ["+strObjs[i].toString()+"]:=["+strCntNextPort+"]");
					break;

				case 26: // Departure Draft Feet
					String strDprDftFeet = getDprDftFeet(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDprDftFeet);
					log.debug(strCaseText+" Departure Draft Feet ["+strObjs[i].toString()+"]:=["+strDprDftFeet+"]");
					break;
				case 27:// Garbage Volume
					String strGarbageVol = getGarbageVol(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strGarbageVol);
					log.debug(strCaseText+" Garbage Volume ["+strObjs[i].toString()+"]:=["+strGarbageVol+"]");
					break;
				case 28: // GRT
				case 73:// GRT 1
				case 74:// GRT 2
					String strGRT = getVslGrt(repVvd);
					hMap.put(strObjs[i].toString(), strGRT);
					log.debug(strCaseText+" GRT ["+strObjs[i].toString()+"]:=["+strGRT+"]");
					break;
				case 29: // NRT
					// SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD =
					// 'BAHX'
					String strNRT = getVslNrt(repVvd);
					hMap.put(strObjs[i].toString(), strNRT);
					log.debug(strCaseText+" NRT ["+strObjs[i].toString()+"]:=["+strNRT+"]");
					break;
				case 30: // LOAFEET
					// SELECT ROUND(LOA_LEN * 3.28, 4) FROM MDM_VSL_CNTR WHERE
					// VSL_CD = 'BAHX'

					String strLOAFeet = getLoaFeet(repVvd);
					// .... .....
					hMap.put(strObjs[i].toString(), strLOAFeet);
					log.debug(strCaseText+" LOAFeet ["+strObjs[i].toString()+"]:=["+strLOAFeet+"]");
					break;
				case 31: // LOAMETER
					// SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'

					String strLOA = getLoaMeter(repVvd);
					hMap.put(strObjs[i].toString(), strLOA);
					log.debug(strCaseText+" LOAMeter ["+strObjs[i].toString()+"]:=["+strLOA+"]");
					break;
				case 34: // Lane
					// SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = 'BAHX'
					// AND SKD_VOY_NO = '0036' AND SKD_DIR_CD = 'E'

					String strLane = getLane(vvd);
					hMap.put(strObjs[i].toString(), "'" + strLane + "'");
					log.debug(strCaseText+" Lane ["+strObjs[i].toString()+"]:=["+strLane+"]");
					break;

				case 35: //
					// SELECT VSL_RGST_CNT_CD FROM mdm_vsl_cntr WHERE VSL_CD =
					// 'HPSH'

					String strNalVsl = getNalVsl(vvd);
					hMap.put(strObjs[i].toString(), "'" + strNalVsl + "'");
					log.debug(strCaseText+" Nationality of Vessel ["+strObjs[i].toString()+"]:=[" + strNalVsl+"]");
					break;

				case 36: // No. of Crew

					String strNoOfCrew = getNoOfCrew(repVvd);
					hMap.put(strObjs[i].toString(), strNoOfCrew);
					log.debug(strCaseText+" No. of Crew ["+strObjs[i].toString()+"]:=[" + strNoOfCrew+"]");
					break;
				case 38: // SCNT
					String strScnt = "";

					strScnt = calcTariffVO.getScnt();// map.get("SCNT");
					if (strScnt == null || strScnt.equals(""))
						strScnt = getScnt(vvd);
					hMap.put(strObjs[i].toString(), strScnt);
					log.debug(strCaseText+" SCNT ["+strObjs[i].toString()+"]:=[" + strScnt+"]");
					break;

				case 40: // Sludge Volume
					String strSludgeVol = getSludgeVol(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strSludgeVol);
					log.debug(strCaseText+" Sludge Volume ["+strObjs[i].toString()+"]:=[" + strSludgeVol+"]");
					break;

				case 32:// Inbound Volume

					String strInboundVolume = getInboundVolume(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strInboundVolume);
					log.debug(strCaseText+" Inbound Volume ["+strObjs[i].toString()+"]:=[" + strInboundVolume+"]");
					break;
				case 33:// Outbound Volume

					String strOutboundVolume = getOutboundVolume(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strOutboundVolume);
					log.debug(strCaseText+" Outbound Volume ["+strObjs[i].toString()+"]:=[" + strOutboundVolume+"]");
					break;
				case 37:// Anchoring Hour

					String strAnchoringHour = getAnchoringHour(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strAnchoringHour);
					log.debug(strCaseText+" Anchoring Hour ["+strObjs[i].toString()+"]:=[" + strAnchoringHour+"]");
					break;
				case 39:// Ship Unit
					String strShipUnit = getShipUnit(repVvd);
					hMap.put(strObjs[i].toString(), strShipUnit);
					log.debug(strCaseText+" Ship Unit ["+strObjs[i].toString()+"]:=[" + strShipUnit+"]");
					break;
				case 41:
					String strCall = "1";
					hMap.put(strObjs[i].toString(), strCall);
					log.debug(strCaseText+" Vessel Call ["+strObjs[i].toString()+"]:=[" + strCall+"]");
				 	break;
				
				case 42:// Vessel Visit
					String strVisit = "1";
					hMap.put(strObjs[i].toString(), strVisit);
					log.debug(strCaseText+" Vessel Visit ["+strObjs[i].toString()+"]:=[" + strVisit+"]");
					break;
				case 45:// get in RATE --PSO_TARIFF

					log.debug(strCaseText+" >>> in RATE[45] START.");
					if (tariffNo.equals(""))
						tariffNo = "-1";// TEST DATA
					String psoTrfTpCd = getPsoTrfTpCd(tariffNo);
					if (psoTrfTpCd.equals("R")) {
						log.debug(strCaseText+" [R] Range Type Case START=============================================. ");
						log.debug(strCaseText+" [R] previousInfo refObjNos [" + refObjNos[i] + "] value " + ":=" + hMap.get("[" + refObjNos[i] + "]")); // 이전정보를 참조 할 경우
						
						// TariffDetail을 이전 값으로 찔러서 해당 Rate값을 구해 온다.
						if (hMap.get("[" + refObjNos[i] + "]") == null) {
							log.debug(strCaseText+" [R] Range Type Case refObjNos null case. ");
							
							if (calcTariffVO.getFrom().equals("SIMULATION")) {
								//if(StringUtils.isEmpty(vvd)){
									strObjVal = calcTariffVO.hMap.get("[" + refObjNos[i] + "]");
									log.debug(strCaseText+" [R] Range Type Case refObjNos null case and SIMULATION vvd null case strObjVal ["+strObjVal+"]. ");
								//}else{
								//	strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, refObjNos[i], repVvd);
								//	log.debug(strCaseText+" [R] Range Type Case refObjNos null case and SIMULATION vvd not null case strObjVal ["+strObjVal+"]. ");
								//}
							} else {
								strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, refObjNos[i], repVvd);
								log.debug(strCaseText+" [R] Range Type Case refObjNos null case and Normal(Estimate:Batch/Screen) case strObjVal ["+strObjVal+"]. ");
							}
							/*
							if (calcTariffVO.getFrom().equals("SIMULATION")) {
								strObjVal = calcTariffVO.hMap.get("[" + refObjNos[i] + "]");
								log.debug(strCaseText+" [R] Range Type Case refObjNos null case and SIMULATION case strObjVal ["+strObjVal+"]. ");
							} else {
								strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, refObjNos[i], repVvd);
								log.debug(strCaseText+" [R] Range Type Case refObjNos null case and Normal(Estimate:Batch/Screen) case strObjVal ["+strObjVal+"]. ");
							}*/
						} else {
							strObjVal = hMap.get("[" + refObjNos[i] + "]");
							log.debug(strCaseText+" [R] Range Type Case refObjNos not null case strObjVal ["+strObjVal+"]. ");
						}
						
						log.debug(strCaseText+" [R] Before previousInfo RATE ["+strObjs[i].toString()+"]:= strObjVal [" + strObjVal+"]"); // 이전정보를 참조 할 경우
						
						String tmpObjVal = StringUtils.replace(strObjVal, "'", "");						
						
						log.debug(strCaseText+" [R] Before previousInfo RATE ["+strObjs[i].toString()+"] Ori Value [" + strRate+"] Replace Value ["+tmpObjVal+"]"); // 이전정보를 참조 할 경우
						
						//strRate = getTrfRtAmt(tariffNo, strObjVal, "1");
						strRate = getTrfRtAmt(tariffNo, tmpObjVal, "1");
						
						//2016.04.18 Add.
						tmpRangeObjNo = String.valueOf(refObjNos[i]);
						
						log.debug(strCaseText+" [R] After previousInfo RATE ["+strObjs[i].toString()+"]:=[" + strRate+"] tmpRangeObjNo ["+tmpRangeObjNo+"]"); // 이전정보를 참조 할 경우
						
						
						log.debug(strCaseText+" [R] Range Type Case E N D=============================================. ");
					} else if (psoTrfTpCd.equals("S")) {// R2 의 경우 Rate 온리이다. 이경우 해당 RATE가 어떤 레이트 인지 찾아야 한다.
						// 해당 RATE가 어떤 Object의 레이트인지를 구하기 위해 PSO_TARIFF의 테이블을 tariffNo로 찔러서 Object의 타입을 구한다.
						log.debug(strCaseText+" [S] RangeRateOnly Type Case START=============================================. ");
						strObjListNo = ""; //초기화.
						strObjListNo = getObjListNo(tariffNo);
						int iObjListNo = -1; // /
						if (strObjListNo != null)
							iObjListNo = Integer.parseInt(strObjListNo);
						
						log.debug(strCaseText+" [S] RangeRateOnly Type : iObjListNo :=" + iObjListNo);
						
						if (calcTariffVO.getFrom().equals("SIMULATION")) {
							if(StringUtils.isEmpty(vvd)){
								strObjVal = calcTariffVO.hMap.get("[" + iObjListNo + "]");
								log.debug(strCaseText+" [S] RangeRateOnly Type Case SIMULATION vvd null case strObjVal ["+strObjVal+"]. ");
							}else{
								strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, iObjListNo, repVvd);
								log.debug(strCaseText+" [R] Range Type Case SIMULATION vvd not null case strObjVal ["+strObjVal+"]. ");
							}
						} else {
							strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, iObjListNo, repVvd);
							log.debug(strCaseText+" [R] Range Type Case Normal(Estimate:Batch/Screen) case strObjVal ["+strObjVal+"]. ");
						}
						
						/*
						if (calcTariffVO.getFrom().equals("SIMULATION")) {
							strObjVal = calcTariffVO.hMap.get("[" + iObjListNo + "]");
							log.debug(strCaseText+" [S] RangeRateOnly Type Case SIMULATION case strObjVal ["+strObjVal+"]. ");
						} else {
							strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, iObjListNo, repVvd);
							log.debug(strCaseText+" [R] Range Type Case Normal(Estimate:Batch/Screen) case strObjVal ["+strObjVal+"]. ");
						}*/
						
						log.debug(strCaseText+" [S] Before previousInfo RATE ["+strObjs[i].toString()+"]:=strObjVal [" + strObjVal+"]");
						
						String tmpObjVal = StringUtils.replace(strObjVal, "'", "");						
						
						log.debug(strCaseText+" [S] Before previousInfo RATE ["+strObjs[i].toString()+"] Ori Value [" + strRate+"] Replace Value ["+tmpObjVal+"]"); // 이전정보를 참조 할 경우
						
						//strRate = getTrfRtAmt(tariffNo, strObjVal, "1");
						strRate = getTrfRtAmt(tariffNo, tmpObjVal, "1");
						

						//2016.04.18 Add.
						tmpRangeObjNo = strObjListNo;
						
						log.debug(strCaseText+" [S] After previousInfo RATE ["+strObjs[i].toString()+"]:=[" + strRate+"] tmpRangeObjNo ["+tmpRangeObjNo+"]");
						
						log.debug(strCaseText+" [S] RangeRateOnly Type Case E N D=============================================. ");
					} else {
						// F /// null --> s, d 의 경우 null 1개의 값 만을 가지고 있기 때문에..  PSO_TRF_DTL에 하나의 값만 가지고 있다.
						log.debug(strCaseText+" [F] Fixed Type Case START=============================================. ");
						
						strRate = getTrfRtAmt(tariffNo, null, "2");
						// strRate = "0.1";
						log.debug(strCaseText+" [F] Fixed Type RATE ["+strObjs[i].toString()+"]:=[" + strRate+"]");
						
						log.debug(strCaseText+" [F] Fixed Type Case E N D=============================================. ");
					}

					//if (strRate == null || strRate.equals("")) strRate = "null";
					if (StringUtils.isEmpty(strRate)){
						log.debug(strCaseText+" in RATE ["+strObjs[i].toString()+"] strRate is Null to String null Input.");
						strRate = "null";
					}
					hMap.put(strObjs[i].toString(), strRate);
					
					log.debug(strCaseText+" in RATE ["+strObjs[i].toString()+"]:=[" + strRate+"] E N D.");
					break;
				case 46:// Base 에서 계산 된 결과 값으로 치환
					//String strType = "";
					// S, D 인 경우만 처리
					//strType = calcTariffVO.getCalcType();// map.get("CalcType");
					String strBase = calcTariffVO.getBase();// map.get("Base");
					if (strType.equals("S") || strType.equals("D")) {
						hMap.put(strObjs[i].toString(), strBase);
					}
					log.debug(strCaseText+" Base ["+strObjs[i].toString()+"]:=[" + strBase+"]");
					break;
				case 47:// Arrival Draft Meter
					String strArvDrftMeter = getArvDrftMeter(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strArvDrftMeter);
					log.debug(strCaseText+" Arrival Draft Meter ["+strObjs[i].toString()+"]:=[" + strArvDrftMeter+"]");
					break;
				case 48:// Arrival Draft 1 Meter
					String strArvDrftOneMeter = getArvDrftOneMeter(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strArvDrftOneMeter);
					log.debug(strCaseText+" Arrival Draft Meter 1 ["+strObjs[i].toString()+"]:=[" + strArvDrftOneMeter+"]");
					break;
				case 49:// Arrival Draft1 Feet
					String strArvDrftOneFeet = getArvDrftOneFeet(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strArvDrftOneFeet);
					log.debug(strCaseText+" Arrival Draft1 Feet ["+strObjs[i].toString()+"]:=[" + strArvDrftOneFeet+"]");
					break;
				case 51:// Arrival POB
					String strArrPob = getArrPob(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strArrPob);
					log.debug(strCaseText+" Arrival POB ["+strObjs[i].toString()+"]:=[" + strArrPob+"]");
					break;
				case 55:// Bound
					String strBound = getBound(vvd, ydCd);
					hMap.put(strObjs[i].toString(), "'" + strBound + "'");
					log.debug(strCaseText+" Bound ["+strObjs[i].toString()+"]:=[" + strBound+"]");
					break;
				case 56:// Bunker Volume
					String strBkerVol = getBkerVol(vvd);
					hMap.put(strObjs[i].toString(), strBkerVol);
					log.debug(strCaseText+" Bunker Volume ["+strObjs[i].toString()+"]:=[" + strBkerVol+"]");
					break;
				case 58:// Carrier
					String strCarrier = getCarrier(repVvd);
					hMap.put(strObjs[i].toString(), "'" + strCarrier + "'");
					log.debug(strCaseText+" Carrier ["+strObjs[i].toString()+"]:=[" + strCarrier+"]");
					break;
				case 59:
					String strValueNo = "'N'";
					hMap.put(strObjs[i].toString(), strValueNo);
					log.debug(strCaseText+" TODO ["+strObjs[i].toString()+"]:=[" + strValueNo+"]");
					break;
				case 61://Departure POB
					String strDepPob = getDepPob(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDepPob);
					log.debug(strCaseText+" Departure POB ["+strObjs[i].toString()+"]:=[" + strDepPob+"]");
					break;
				case 63:// Design Capacity
					String strDesignCapacity = getDesignCapacity(repVvd);
					hMap.put(strObjs[i].toString(), strDesignCapacity);
					log.debug(strCaseText+" Design Capacity ["+strObjs[i].toString()+"]:=[" + strDesignCapacity+"]");
					break;
				case 64:// DWT
					String strDwt = getDwt(vvd);
					hMap.put(strObjs[i].toString(), strDwt);
					log.debug(strCaseText+" DWT ["+strObjs[i].toString()+"]:=[" + strDwt+"]");
					break;
				/*
				 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
				 */
				case 65:// ETB Date
					String strEtbDate = getEtbDate(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtbDate);
					log.debug(strCaseText+" ETB Date ["+strObjs[i].toString()+"]:=[" + strEtbDate+"]");
					break;
				case 66:// ETB Month
					String strEtbMonth = getEtbMonth(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtbMonth);
					log.debug(strCaseText+" ETB Month ["+strObjs[i].toString()+"]:=[" + strEtbMonth+"]");
					break;
				case 67:// ETB Time
				case 68:// ETB1 Time
					String strEtbTime = getEtbTime(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtbTime);
					log.debug(strCaseText+" ETB Time ["+strObjs[i].toString()+"]:=[" + strEtbTime+"]");
					break;
				/*
				 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
				 */
				case 69:// ETD Date
					String strEtdDate = getEtdDate(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtdDate);
					log.debug(strCaseText+" ETD Date ["+strObjs[i].toString()+"]:=[" + strEtdDate+"]");
					break;
				case 70:// ETD Month
					String strEtdMonth = getEtdMonth(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtdMonth);
					log.debug(strCaseText+" ETD Month ["+strObjs[i].toString()+"]:=[" + strEtdMonth+"]");
					break;
				case 71:// ETD Time
				case 72:// ETD1 Time
					String strEtdTime = getEtdTime(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtdTime);
					log.debug(strCaseText+" ETD Time ["+strObjs[i].toString()+"]:=[" + strEtdTime+"]");
					break;

				case 76:// I/B Volume/Blocksize
					String strIbVolBsz = getIBVolBsz(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strIbVolBsz);
					log.debug(strCaseText+" I/B Volume/Blocksize ["+strObjs[i].toString()+"]:=[" + strIbVolBsz+"]");
					break;
					
				case 77: // IN
					String strInFlag = calcTariffVO.getIoFlag();// map.get("ioFlag");
					String strDftValue = "";
					if (strInFlag != null) {
						if (strInFlag.equals("IN")) {
							strDftValue = "'Y'";
							//hMap.put(strObjs[i].toString(), "'Y'");
						} else {
							strDftValue = "'N'";
							//hMap.put(strObjs[i].toString(), "'N'");
						}
						hMap.put(strObjs[i].toString(), strDftValue);
					}
					vo.addTariffObjList(77);
					log.debug(strCaseText+" IN ["+strObjs[i].toString()+"]:=[" + strDftValue+"]");
					break;
				case 79:// last Issued Invoice ETD
					String strLastInvEtd = getLastInvEtd(vvd, ydCd, clptIndSeq, lgsCostCd);
					hMap.put(strObjs[i].toString(), strLastInvEtd);
					log.debug(strCaseText+" last Issued Invoice ETD ["+strObjs[i].toString()+"]:=[" + strLastInvEtd+"]");
					break;
				case 80:// LastPort
					/*
					 * "select
					 * SUBSTR(MAX(A.vps_Etd_dt||NVL(A.yd_cd,A.vps_Port_cd||'
					 * ')),-7,7) from vsk_vsl_port_skd A, ( select slan_cd,
					 * vsl_cd, vps_port_cd, vps_etd_dt from vsk_vsl_port_skd
					 * where vsl_cd = 'HYST' and skd_voy_no ='1407' and
					 * skd_dir_cd = 'E' and yd_cd = @yd_cd --and vps_port_cd =
					 * (YD_CD)--'KRPUS' ) B where A.vps_etd_dt < B.vps_Etd_dt
					 * and A.vsl_cd = B.vsl_cd and A.slan_cd = B.slan_cd"
					 */
					String strLastPort = getLastPort(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strLastPort);
					log.debug(strCaseText+" Last Port ["+strObjs[i].toString()+"]:=[" + strLastPort+"]");
					break;
				case 81:// LOA 1
				case 82:// LOA 2
				case 83:// LOA 3
					// SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
					String strLoa = getLoa(repVvd);
					hMap.put(strObjs[i].toString(), strLoa);
					log.debug(strCaseText+" LOA 1,2,3 ["+strObjs[i].toString()+"]:=[" + strLoa+"]");
					break;
				case 85:// Next Port
					String strNextPort = getNextPort(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strNextPort);
					log.debug(strCaseText+" Next Port ["+strObjs[i].toString()+"]:=[" + strNextPort+"]");
					break;
				case 86:// Night 의 여부 Y , N값이 들어 온다. 아무값이 안들어 오면 default값을 구한다.
					String strNightYN = "'N'";
					hMap.put(strObjs[i].toString(), strNightYN);
					log.debug(strCaseText+" Night ["+strObjs[i].toString()+"]:=[" + strNightYN+"]");
					break;
				case 87:// NRT1
					// SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD =
					// 'BAHX'
					String strNrt1 = getNrtOne(repVvd);
					hMap.put(strObjs[i].toString(), strNrt1);
					log.debug(strCaseText+" NRT1 ["+strObjs[i].toString()+"]:=[" + strNrt1+"]");
					break;
				case 89: // OUT
					String strOutFlag = calcTariffVO.getIoFlag();// map.get("ioFlag");
					String strOutDftValue = "";
					if (strOutFlag != null) {
						if (strOutFlag.equals("OUT")) {
							strOutDftValue="'Y'";
							//hMap.put(strObjs[i].toString(), "'Y'");
						} else {
							strOutDftValue="'N'";
							//hMap.put(strObjs[i].toString(), "'N'");
						}
						hMap.put(strObjs[i].toString(), strOutDftValue);
					}
					vo.addTariffObjList(89);
					log.debug(strCaseText+" OUT ["+strObjs[i].toString()+"]:=[" + strOutFlag+"]");
					break;
				case 90:// Pilot Off
					String strPOff = getPOff(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), "'" + strPOff + "'");
					log.debug(strCaseText+" Pilot Off ["+strObjs[i].toString()+"]:=[" + strPOff+"]");
					break;
				case 91:// POB
					String strPob = getPob(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), "'" + strPob + "'");
					log.debug(strCaseText+" POB ["+strObjs[i].toString()+"]:=[" + strPob+"]");
					break;
				case 92:// Rehandling Volume
					String strRhVol = getRhVol(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strRhVol);
					log.debug(strCaseText+" Rehandling Volume ["+strObjs[i].toString()+"]:=[" + strRhVol+"]");
					break;
				case 93:// Remain Vessel Call
					String strRemainVesselCall = getRemainVesselCall(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strRemainVesselCall);
					log.debug(strCaseText+" Rehandling Vessel Call ["+strObjs[i].toString()+"]:=[" + strRemainVesselCall+"]");
					break;
				case 94:// Monthly Vessel Call
					String strMonthlyVesselCall = getMonthlyVesselCall(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strMonthlyVesselCall);
					log.debug(strCaseText+" Monthly Vessel Call ["+strObjs[i].toString()+"]:=[" + strMonthlyVesselCall+"]");
					break;
				case 95:// sameVvd
					String strSameVvd = getSameVvd(vvd, ydCd);
					hMap.put(strObjs[i].toString(), strSameVvd);
					log.debug(strCaseText+" sameVvd ["+strObjs[i].toString()+"]:=[" + strSameVvd+"]");
					break;
				case 96:// Yearly Vessel Call
					String strYearlyVesselCall = getYearlyVesselCall(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strYearlyVesselCall);
					log.debug(strCaseText+" Yearly Vessel Call ["+strObjs[i].toString()+"]:=[" + strYearlyVesselCall+"]");
					break;
				case 98:// SCNT1
					String strScnt1 = calcTariffVO.getScntOne();// map.get("SCNT1");
					if (strScnt1 == null || strScnt1.equals(""))
						strScnt = getScnt(vvd);
					hMap.put(strObjs[i].toString(), strScnt1);
					log.debug(strCaseText+" SCNT1 ["+strObjs[i].toString()+"]:=[" + strScnt1+"]");
					break;
				case 99:// ShipUnitOne
					String strShipUnitOne = getShipUnitOne(repVvd);
					hMap.put(strObjs[i].toString(), strShipUnitOne);
					log.debug(strCaseText+" ShipUnit1 ["+strObjs[i].toString()+"]:=[" + strShipUnitOne+"]");
					break;
				case 100:// Summer Draft(F)
					String strSmmrDftF = getSmmrDftF(repVvd);
					hMap.put(strObjs[i].toString(), strSmmrDftF);
					log.debug(strCaseText+" Summer Draft(F) ["+strObjs[i].toString()+"]:=[" + strSmmrDftF+"]");
					break;
				case 101:// Summer Draft(M)
					String strSmmrDftM = getSmmrDftM(repVvd);
					hMap.put(strObjs[i].toString(), strSmmrDftM);
					log.debug(strCaseText+" Summer Draft(M) ["+strObjs[i].toString()+"]:=[" + strSmmrDftM+"]");
					break;
				case 112:// Water Volume
					String strWatVol = getWatVol(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strWatVol);
					log.debug(strCaseText+" Water Volume ["+strObjs[i].toString()+"]:=[" + strWatVol+"]");
					break;
				case 114:// SDR
					String strSdr = calcTariffVO.getSDR();// map.get("SDR");
					if (strSdr == null || strSdr.equals(""))
						strSdr = getSdr();
					hMap.put(strObjs[i].toString(), strSdr);
					log.debug(strCaseText+" SDR ["+strObjs[i].toString()+"]:=[" + strSdr+"]");
					break;

				case 115:// Tier
					String strTier = "";
					//if ("Y".equals(calcTariffVO.getEstFlg())) {
						strTier = getTier(vvd, ydCd);
					//} else {
					//	strTier = calcTariffVO.getTier();// map.get("Tier");
					//}
					
						
					if (strTier != null) {
						hMap.put(strObjs[i].toString(), strTier);
					}
					log.debug(strCaseText+" Tier ["+calcTariffVO.getEstFlg()+"]["+strObjs[i].toString()+"]:=[" + strTier+"]");
					break;

				case 116:// Limit Time
					String strLimitTime;
					if ("Y".equals(calcTariffVO.getEstFlg())) {
						strLimitTime = getLimitTime(vvd, ydCd);
					} else {
						strLimitTime = calcTariffVO.getLimitTm();// map.get("LimitTime");
					}
					if (strLimitTime != null) {
						hMap.put(strObjs[i].toString(), strLimitTime);
					}
					log.debug(strCaseText+" Limit Time ["+calcTariffVO.getEstFlg()+"]["+strObjs[i].toString()+"]:=[" + strLimitTime+"]");
					break;
				case 117:// Surcharge Amount
					// Discount 인 경우만 처리
					//strType = calcTariffVO.getCalcType();// map.get("CalcType");
					String strSurcharge = calcTariffVO.getSurcharge();// map.get("Surcharge");
					if (strType.equals("D"))
						hMap.put(strObjs[i].toString(), strSurcharge);
					log.debug(strCaseText+" Surcharge Amount ["+strObjs[i].toString()+"]:=[" + strSurcharge+"]");
					break;
				case 118: // Block Size1 (Obj 16 Block Size와 동일한 값을 return 한다.)
					// SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) *
					// NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR
					// WHERE VSL_CD = :VSL_CD
					strBlockSize = getBlockSize(repVvd);
					hMap.put(strObjs[i].toString(), strBlockSize);
					log.debug(strCaseText+" Block Size 1 ["+strObjs[i].toString()+"]:=[" + strBlockSize+"]");
					break;
				case 120:// DEM/DET Holiday(ETB)
					String strDdHolEtb = getDemdetHolidayETB(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDdHolEtb);
					log.debug(strCaseText+" DEM/DET Holiday(ETB) ["+strObjs[i].toString()+"]:=[" + strDdHolEtb+"]");
					break;
				case 121:// DEM/DET Holiday(ETD)
					String strDdHolEtd = getDemdetHolidayETD(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDdHolEtd);
					log.debug(strCaseText+" DEM/DET Holiday(ETD) ["+strObjs[i].toString()+"]:=[" + strDdHolEtd+"]");
					break;
				case 122:// Ownership
					String strOwnrship = getOwnrship(vvd);
					hMap.put(strObjs[i].toString(), strOwnrship);
					log.debug(strCaseText+" Ownership ["+strObjs[i].toString()+"]:=[" + strOwnrship+"]");
					break;
				case 123:// ETB(H)
					String strEtbHr = getEtbHr(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtbHr);
					log.debug(strCaseText+" ETB(H) ["+strObjs[i].toString()+"]:=[" + strEtbHr+"]");
					break;
				case 124:// ETD(H)
					String strEtdHr = getEtdHr(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtdHr);
					log.debug(strCaseText+" ETD(H) ["+strObjs[i].toString()+"]:=[" + strEtdHr+"]");
					break;
				case 126:// I/B (TON)
					String strInboundTon = getInboundTon(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strInboundTon);
					log.debug(strCaseText+" I/B (TON) ["+strObjs[i].toString()+"]:=[" + strInboundTon+"]");
					break;
				case 127:// O/B (TON)
					String strOutboundTon = getOutboundTon(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strOutboundTon);
					log.debug(strCaseText+" O/B (TON) ["+strObjs[i].toString()+"]:=[" + strOutboundTon+"]");
					break;
				case 128:// RH (TON)
					String strRhTon = getRhTon(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strRhTon);
					log.debug(strCaseText+" RH (TON) ["+strObjs[i].toString()+"]:=[" + strRhTon+"]");
					break;
				case 129:// ETA (H)
					String strEtaHour = getEtaHour(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtaHour);
					log.debug(strCaseText+" ETA (H) ["+strObjs[i].toString()+"]:=[" + strEtaHour+"]");
					break;
				case 130:// Cargo Volume(Ton)
					String strCargoVolume = getCargoVolumeTon(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strCargoVolume);
					log.debug(strCaseText+" Cargo Volume(Ton) ["+strObjs[i].toString()+"]:=[" + strCargoVolume+"]");
					break;
				case 131:// Vessel Volume(FR)
				case 164:// Vessel Volume(FR)1
				case 165:// Vessel Volume(FR)2
					String strVesselVolumeFr = getVesselVolumeFr(vvd);
					hMap.put(strObjs[i].toString(), strVesselVolumeFr);
					log.debug(strCaseText+" Vessel Volume(FR) ["+strObjs[i].toString()+"]:=[" + strVesselVolumeFr+"]");
					break;
				case 132:// Loaded TEU At Last Port
					String strLoadedTeuLastPort = getstrLoadedTeuLastPort(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strLoadedTeuLastPort);
					log.debug(strCaseText+" Loaded TEU at Last Port ["+strObjs[i].toString()+"]:=[" + strLoadedTeuLastPort+"]");
					break;
				/*
				 * CHM-201005567-01 동일 노선이 해당 Port에 연간 기항하는 횟수를 조회하는 로직을 추가
				 */
				case 133:// Yearly Vessel Call Lane
					String strYearlyVesselCallLane = getYearlyVesselCallLane(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strYearlyVesselCallLane);
					log.debug(strCaseText+" Yearly Vessel Call Lane ["+strObjs[i].toString()+"]:=[" + strYearlyVesselCallLane+"]");
					break;
				case 134:// vessel volume(CI)
					String strVesselVolume = getVesselVolumeCi(vvd, ydCd);
					hMap.put(strObjs[i].toString(), strVesselVolume);
					log.debug(strCaseText+" Vessel Volume Ci ["+strObjs[i].toString()+"]:=[" + strVesselVolume+"]");
					break;
				case 135:// LOA * Beam
					String strLoaBeam = getLoaBeam(vvd);
					hMap.put(strObjs[i].toString(), strLoaBeam);
					log.debug(strCaseText+" LOA*BM ["+strObjs[i].toString()+"]:=[" + strLoaBeam+"]");
					break;
				/*
				 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
				 */
				case 136:// ETB Day
					String strEtbDay = getEtbDay(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtbDay);
					log.debug(strCaseText+" ETB Day ["+strObjs[i].toString()+"]:=[" + strEtbDay+"]");
					break;
				case 137:// ETD Day
					String strEtdDay = getEtdDay(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtdDay);
					log.debug(strCaseText+" ETD Day ["+strObjs[i].toString()+"]:=[" + strEtdDay+"]");
					break;
				case 138:// SUN
					String strSun = "'SUN'";
					hMap.put(strObjs[i].toString(), strSun);
					log.debug(strCaseText+" SUN ["+strObjs[i].toString()+"]:=[" + strSun+"]");
					break;
				case 139:// MON
					String strMon = "'MON'";
					hMap.put(strObjs[i].toString(), strMon);
					log.debug(strCaseText+" MON ["+strObjs[i].toString()+"]:=[" + strMon+"]");
					break;
				case 140:// TUE
					String strTue = "'TUE'";
					hMap.put(strObjs[i].toString(), strTue);
					log.debug(strCaseText+" TUE ["+strObjs[i].toString()+"]:=[" + strTue+"]");
					break;
				case 141:// WED
					String strWed = "'WED'";
					hMap.put(strObjs[i].toString(), strWed);
					log.debug(strCaseText+" WED ["+strObjs[i].toString()+"]:=[" + strWed+"]");
					break;
				case 142:// THU
					String strThu = "'THU'";
					hMap.put(strObjs[i].toString(), strThu);
					log.debug(strCaseText+" THU ["+strObjs[i].toString()+"]:=[" + strThu+"]");
					break;
				case 143:// FRI
					String strFri = "'FRI'";
					hMap.put(strObjs[i].toString(), strFri);
					log.debug(strCaseText+" FRI ["+strObjs[i].toString()+"]:=[" + strFri+"]");
					break;
				case 144:// SAT
					String strSat = "'SAT'";
					hMap.put(strObjs[i].toString(), strSat);
					log.debug(strCaseText+" SAT ["+strObjs[i].toString()+"]:=[" + strSat+"]");
					break;
				case 146:// Loaded TEU At Last Port 1
					strObjVal = getstrLoadedTeuLastPort1(vvd, ydCd, clptIndSeq);
					log.debug(strCaseText+" Loaded TEU at Last Port ["+strObjs[i].toString()+"]:=[" + strObjVal+"]");
					break;
				/*
				 * CHM-201007132-01 신규 Object DEM/DET Holiday ETB/ETD (except Day) 추가
				 */
				case 147:// DEM/DET Holiday ETB (except Day)
					String strDemdetHolidayETBExceptDay = searchDemdetHolidayETBExceptDay(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDemdetHolidayETBExceptDay);
					log.debug(strCaseText+" DEM/DET Holiday ETB(except Day) ["+strObjs[i].toString()+"]:=[" + strDemdetHolidayETBExceptDay+"]");
					break;
				case 148:// DEM/DET Holiday ETD (except Day)
					String strDemdetHolidayETDExceptDay = searchDemdetHolidayETDExceptDay(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDemdetHolidayETDExceptDay);
					log.debug(strCaseText+" DEM/DET Holiday ETD(except Day) ["+strObjs[i].toString()+"]:=[" + strDemdetHolidayETDExceptDay+"]");
					break;
				/*
				 * CHM-201111356-01 신규 Object 추가 ETA(T), ETA1(T)
				 */
				case 149:// ETA Time
				case 150:// ETA1 Time
					String strEtaTime = getEtaTime(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtaTime);
					log.debug(strCaseText+" ETA Time ["+strObjs[i].toString()+"]:=[" + strEtaTime+"]");
					break;
				/*
				 * CHM-201111356-01 신규 Object 추가 NRT 2
				 */
				case 151: // NRT2
					String strNrt2 = getNrtOne(repVvd); // same with NRT1
					hMap.put(strObjs[i].toString(), strNrt2);
					log.debug(strCaseText+" NRT 2 ["+strObjs[i].toString()+"]:=[" + strNrt2+"]");
					break;

				case 152:// DEM/DET Holiday(ETA)
					String strDdHolEta = getDemdetHolidayETA(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDdHolEta);
					log.debug(strCaseText+" DEM/DET Holiday(ETA) ["+strObjs[i].toString()+"]:=[" + strDdHolEta+"]");
					break;

				case 153:// DEM/DET Holiday ETA (except Day)
					String strDemdetHolidayETAExceptDay = searchDemdetHolidayETAExceptDay(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDemdetHolidayETAExceptDay);
					log.debug(strCaseText+" DEM/DET Holiday ETA(except Day) ["+strObjs[i].toString()+"]:=[" + strDemdetHolidayETAExceptDay+"]");
					break;

				case 154: // Duration
					String duration = getDuration(vvd);
					hMap.put(strObjs[i].toString(), duration);
					log.debug(strCaseText+" Duration ["+strObjs[i].toString()+"]:=[" + duration+"]");
					break;

				case 155: // Previous Port(TW)
					String previousTaiwanPort = getPreviousTaiwanPort(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), previousTaiwanPort);
					log.debug(strCaseText+" Previous Port(TW) ["+strObjs[i].toString()+"]:=[" + previousTaiwanPort+"]");
					break;
					
				case 156: // Yearly Vessel Call Port
					String yearlyVesselCallPort = getYearlyVesselCallPort(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), yearlyVesselCallPort);
					log.debug(strCaseText+" Yearly Vessel Call Port ["+strObjs[i].toString()+"]:=[" + yearlyVesselCallPort+"]");
					break;
					
				case 157: // ETA Date
					String strEtaDate =  getEtaDate(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtaDate);
					log.debug(strCaseText+" ETA Date ["+strObjs[i].toString()+"]:=[" + strEtaDate+"]");
					break;
					
				case 158: // Berthing Hour(D-A)
					String strBerthingHourDA = getBerthingHourDA(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strBerthingHourDA);
					log.debug(strCaseText+" Berthing Hour(D-A) ["+strObjs[i].toString()+"]:=[" + strBerthingHourDA+"]");
					break;
					
				case 159: // ETA Day
					String strEtaDay = getEtaDay(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtaDay);
					log.debug(strCaseText+" ETA Day ["+strObjs[i].toString()+"]:=[" + strEtaDay+"]");
					break;
					
				case 160:// ETA Month
					String strEtaMonth = getEtaMonth(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strEtaMonth);
					log.debug(strCaseText+" ETA Month ["+strObjs[i].toString()+"]:=[" + strEtaMonth+"]");
					break;
					
				case 161:// Inbound Volume(Ton) / Vessel Volume(FR)
					String strInboundDivideVessel = getInboundDivideVessel(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strInboundDivideVessel);
					log.debug(strCaseText+" Inbound Volume(Ton) / Vessel Volume(FR) ["+strObjs[i].toString()+"]:=[" + strInboundDivideVessel+"]");
					break;
					
				case 162:// Outbound Volume(Ton) / Vessel Volume(FR)
					String strOutboundDivideVessel = getOutboundDivideVessel(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strOutboundDivideVessel);
					log.debug(strCaseText+" Outbound Volume(Ton) / Vessel Volume(FR) ["+strObjs[i].toString()+"]:=[" + strOutboundDivideVessel+"]");
					break;
					
				case 163: // SCGT <<<비슷함 case 38: // SCNT>>>
					String strScgt = "";
	
					strScgt = calcTariffVO.getScgt();// map.get("SCGT");
					if (strScgt == null || strScgt.equals(""))
						strScgt = getScgt(vvd);
					hMap.put(strObjs[i].toString(), strScgt);
					log.debug(strCaseText+" SCGT ["+strObjs[i].toString()+"]:=[" + strScgt+"]");
					break;
					/*case 167: // ESIscore
					String strESIScore = "";
	
					strESIScore = calcTariffVO.getESIScore();// map.get("SCGT");
					if (strESIScore == null || strESIScore.equals(""))
						strESIScore = getESIScore(vvd);
					hMap.put(strObjs[i].toString(), strESIScore);
					log.debug(strCaseText+" ESIscore ["+strObjs[i].toString()+"]:=[" + strESIScore+"]");
					break;
				
				case 168://B/T Power(BHP) - Bow Thurust Power
					String strBowThurustPowerBHP = getBowThurustPowerBHP(vvd);
					hMap.put(strObjs[i].toString(), strBowThurustPowerBHP);
					log.debug(strCaseText+" Bow Thurust Power(BHP) ["+strObjs[i].toString()+"]:=[" + strBowThurustPowerBHP+"]");
					break;	
				case 169://B/T Power(KW)  - Bow Thurust Power
					String strBowThurustPowerKW = getBowThurustPowerKW(vvd);
					hMap.put(strObjs[i].toString(), strBowThurustPowerKW);
					log.debug(strCaseText+" Bow Thurust Power(KW) ["+strObjs[i].toString()+"]:=[" + strBowThurustPowerKW+"]");
					break;*/
					
				//2016.11.02 Add Object	
				case 174: //Last Yard
					String strLastYard = getLastYard(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strLastYard);
					log.debug(strCaseText+" Last Yard ["+strObjs[i].toString()+"]:=[" + strLastYard+"]");
					break;
				case 175: //Current Yard (인자로 넘어온 데이터 재사용)
					String strCurrentYard = getCurrentYard(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strCurrentYard);
					log.debug(strCaseText+" Current Yard ["+strObjs[i].toString()+"]:=[" + strCurrentYard+"]");
					break;
				case 176: //Next Yard
					String strNextYard = getNextYard(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strNextYard);
					log.debug(strCaseText+" Next Yard ["+strObjs[i].toString()+"]:=[" + strNextYard+"]");
					break;
				case 177: //Double Call
					String strDoubleCall = getDoubleCall(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strDoubleCall);
					log.debug(strCaseText+" Double Call ["+strObjs[i].toString()+"]:=[" + strDoubleCall+"]");
					break;
				case 178: //Port Seq : Current terminal Port Seq(인자로 넘어온 데이터 재사용 :CLPT_IND_SEQ)
					String strPortSeq = getPortSeq(vvd, ydCd, clptIndSeq);
					hMap.put(strObjs[i].toString(), strPortSeq);
					log.debug(strCaseText+" Port Seq ["+strObjs[i].toString()+"]:=[" + strPortSeq+"]");
					break;

				default:
					log.debug(prefixLogText+">>>>> in default");
					break;
				}

				// Manually Input ---> 
				/**
				 * Estimate : 
				 *  > Estimate 일때만 Default Value 를 찾아서 넣어 준다.
				 *  > calcTariffVO.getEstFlg() = Y
				 *  > Estimate Expense Creation ( VOP_PSO_0010 ) : Expense Apply
				 *  > Estimate Creation ( VOP_PSO_0009 ) : Batch
				 * SIMULATION :  : 
				 *  > calcTariffVO.getFrom().equals("SIMULATION")
				 * INVOICE :
				 *  > Port charge Invoice Creation ( VOP_PSO_0014 ) : Sheet Account 선택시에만 마킹한다.
				 * 
				 * hMap.put("[6]", calcTariffVO.getArrnt());
				 * hMap.put("[7]", calcTariffVO.getDepnt());
				 * hMap.put("[8]", calcTariffVO.getArrtp());
				 * hMap.put("[9]", calcTariffVO.getDeptp());
				 * hMap.put("[10]", calcTariffVO.getArrtuh());
				 * hMap.put("[11]", calcTariffVO.getDeptuh());
				 * hMap.put("[17]", calcTariffVO.getBoat());
				 * hMap.put("[50]", calcTariffVO.getArrlh());
				 * hMap.put("[52]", calcTariffVO.getBarge());
				 * hMap.put("[57]", calcTariffVO.getBuoy());
				 * hMap.put("[60]", calcTariffVO.getDeplh());
				 * hMap.put("[75]", calcTariffVO.getHoliday());
				 * hMap.put("[78]", calcTariffVO.getInspection());
				 * hMap.put("[86]", calcTariffVO.getNight());
				 * hMap.put("[97]", calcTariffVO.getSanitation());
				 * hMap.put("[110]", calcTariffVO.getTugrope());
				 * hMap.put("[111]", calcTariffVO.getUsdHr());
				 */
				String curObjVal = "";
				String curObjDftVal = "";
				HashMap<String, String> dftMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_MANUAL_VALUE_OBJECT_NO);
				if(dftMap.containsKey(objNos[i]+"")){
					curObjDftVal = getRegularValueByObjNo(ydChgNo, ydChgVerSeq, objNos[i]+"");
					log.debug(prefixLogText+"########## >> ## Check ARRAY_DEFAULT_MANUAL_VALUE_OBJECT_NO Case ["+objNos[i]+""+"] >> Manually Default FLAG Object No ["+objNos[i]+"]:=[" + curObjDftVal + "]");
				}
				
				log.debug("\n============================================================================"+
						  "\n Tariff Calculation Manually Input Object Find START."+
						  "\n============================================================================");
				switch (objNos[i]) {
					case 6://Arrival No. of Tug
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getArrNT();// map.get("[6]");
						
						//curObjVal = calcTariffVO.getArrNT();// map.get("[6]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Arr.NT["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 7://Departure No. of Tug
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getDepNT();// map.get("[7]");
						
						//curObjVal = calcTariffVO.getDepNT();// map.get("[7]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Dep.NT["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 8://Arrival Tug Power
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getArrTP();// map.get("[8]");
						
						//curObjVal = calcTariffVO.getArrTP();// map.get("[8]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Arr.TP["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 9://Departure Tug Power
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getDepTP();// map.get("[9]");
						
						//curObjVal = calcTariffVO.getDepTP();// map.get("[9]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Dep.TP["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 10://Arrival Tug Used Hour
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getArrTUH();// map.get("[10]");
						
						//curObjVal = calcTariffVO.getArrTUH();// map.get("[10]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Arr.TUH["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 11://Departure Tug Used Hour
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getDepTUH();// map.get("[11]");
						
						//curObjVal = calcTariffVO.getDepTUH();// map.get("[11]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Dep.TUH["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 17://Boat
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getBoat();// map.get("[17]");

						//curObjVal = calcTariffVO.getBoat();// map.get("[17]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Boat["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 50://Arrival Line Handing Hour
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getArrLH();// map.get("[50]");
						
						//curObjVal = calcTariffVO.getArrLH();// map.get("[50]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Arr.LH["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 52://Barge
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getBarge();// map.get("[52]");
						
						//curObjVal = calcTariffVO.getBarge();// map.get("[52]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Barge["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 57://Buoy
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getBuoy();// map.get("[57]");
						
						//curObjVal = calcTariffVO.getBuoy();// map.get("[57]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Buoy["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 60://Departure Line handing Hour
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getDepLH();// map.get("[60]");
						
						//curObjVal = calcTariffVO.getDepLH();// map.get("[60]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Dep.LH["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 75://Holiday
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getHoliday();// map.get("[75]");
						
						//curObjVal = calcTariffVO.getHoliday();// map.get("[75]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Holiday["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					/**
					 * hMap.put("[78]", auditDataValidVos[i].getInspection());
					 * hMap.put("[86]", auditDataValidVos[i].getNight());
					 * hMap.put("[97]", auditDataValidVos[i].getSanitation());
					 * hMap.put("[110]", auditDataValidVos[i].getTugrope());
					 */
	
					case 78://Inspection
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getInspection();// map.get("[78]");
						
						//curObjVal = calcTariffVO.getInspection();// map.get("[78]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Inspection["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 86://Night
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getNight();// map.get("[86]");
						
						//curObjVal = calcTariffVO.getNight();// map.get("[86]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Night["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 97://Sanitation
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getSanit();// map.get("[97]");
						
						//curObjVal = calcTariffVO.getSanit();// map.get("[97]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Sanitation["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 110://TUG Rope
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getTUGRope();// map.get("[110]");
						
						//curObjVal = calcTariffVO.getTUGRope();// map.get("[110]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input TugRope["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 111://Used Hour
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getUsdhrs();// map.get("[110]");
						
						//curObjVal = calcTariffVO.getUsdhrs();// map.get("[110]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input TugRope["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 119://New Service
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getNewservice();// map.get("[119]");
						
						//curObjVal = calcTariffVO.getNewservice();// map.get("[119]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input NewService["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 125://Co-pilot
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getCopilot();// map.get("[125]");
						
						//curObjVal = calcTariffVO.getCopilot();// map.get("[125]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Co-Pilot["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 114://sdr
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getSDR();// map.get("[114]");
						
						//curObjVal = calcTariffVO.getSDR();// map.get("[114]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input SDR["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 115://tier
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getTier();// map.get("[115]");
						
						//curObjVal = calcTariffVO.getTier();// map.get("[115]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Tier["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 116://limit time
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getLimitTm();// map.get("[116]");
						
						//curObjVal = calcTariffVO.getLimitTm();// map.get("[116]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Limit Time["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 170://others
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getOthers();// map.get("[170]");
						
						//curObjVal = calcTariffVO.getOthers();// map.get("[170]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input Others["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					case 171://other value
						curObjVal = "Y".equals(calcTariffVO.getEstFlg()) ? curObjDftVal : calcTariffVO.getOtherValue();// map.get("[171]");
						
						//curObjVal = calcTariffVO.getOtherValue();// map.get("[171]");
						if (curObjVal != null) {
							if (!curObjVal.equals("")) {
								hMap.put(strObjs[i].toString(), curObjVal);
								log.debug(strCaseText+"Manually Input OtherValue["+strObjs[i].toString()+"]:=[" + curObjVal + "]");
							}
						}
						break;
					default:
						break;
				}
				log.debug("\n============================================================================"+
						  "\n Tariff Calculation Manually Input Object Find E N D."+
						  "\n============================================================================");
				// Manually Input <---

				log.debug("\n============================================================================"+
						  "\n Tariff Calculation Default Value(Regular Value) Object Find START."+
						  "\n============================================================================");
				String objVal = hMap.get(strObjs[i].toString());
				log.debug(prefixLogText+"Regular Before Value Obj No : [" + objNos[i] + "] Map Key : ["+strObjs[i].toString()+"]:=[" + objVal +"]");

				if (StringUtils.isEmpty(objVal) || objVal.equals("0")) {
					log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Replace Default Value[0,Y/N] Start================================");
					String tmpStrObjVal = objVal;//2016.03.18
					//String tmpOriObjNoKey = objNos[i] + "";
					String tmpObjNoKey = objNos[i] + "";
					
					log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Before getRegularValue tmpObjNoKey["+tmpObjNoKey+"] tmpStrObjVal ["+tmpStrObjVal+"] E n d.");
					//45 Case 일때 처리 로직 추가.
					if(tmpObjNoKey.equals("45")){
						tmpObjNoKey = tmpRangeObjNo;
					}
					
					objVal = getRegularValue(ydChgNo, ydChgVerSeq, tmpObjNoKey);
					log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> After getRegularValue tmpObjNoKey["+tmpObjNoKey+"] objVal ["+objVal+"] E n d.");
					
					//2016.03.18 Default 0을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(0) 를 셋팅한다.
					HashMap<String, String> dftZeroAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_ZERO_ALLOW_OBJECT_NO);
					if(dftZeroAllowMap.containsKey(tmpObjNoKey)){							
						log.debug(prefixLogText+"[Zero & Flag]Null Value  >> Before Default Zero Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + objVal +"] Start.");
						if(StringUtils.isEmpty(objVal)){
							if(StringUtils.isEmpty(tmpStrObjVal)){
								objVal = "0";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
							}else{
								objVal = tmpStrObjVal;
							}
						}
						log.debug(prefixLogText+"[Zero & Flag]Null Value  >> After Default Zero Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + objVal +"] E n d.");
					}
					
					//2016.04.14 Default N Flag을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(N) 를 셋팅한다.
					HashMap<String, String> dftFlagAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_FLAG_ALLOW_OBJECT_NO);
					if(dftFlagAllowMap.containsKey(tmpObjNoKey)){				
						log.debug(prefixLogText+"[Zero & Flag]Null Value  >> Before Default Flag Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + objVal +"] Start.");
						
						if(StringUtils.isEmpty(objVal)){
							if(StringUtils.isEmpty(tmpStrObjVal)){
								objVal = "'N'";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
							}else{
								objVal = tmpStrObjVal;
							}
						}
						log.debug(prefixLogText+"[Zero & Flag]Null Value  >> After Default Flag Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + objVal +"] E n d.");
					}
					
					hMap.put(strObjs[i].toString(), objVal);
					
					//2015.12.23 Add Reqular Value Add
					regularValueMap.put(strObjs[i].toString(), objVal);
					log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Regular Value [" + tmpObjNoKey + "]:=[" + objVal +"]");
					log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Replace Default Value[0,Y/N] E n d================================");
				}
			
				/*
				if (objVal == null) {
					objVal = getRegularValue(ydChgNo, ydChgVerSeq, objNos[i] + "");
					hMap.put(strObjs[i].toString(), objVal);
					
					//2015.12.23 Add Reqular Value Add
					regularValueMap.put(strObjs[i].toString(), objVal);
					log.debug(prefixLogText+"Regular After Value ObjVal is Null [" + objNos[i] + "]:=[" + objVal +"]");
				} else {
					if (objVal.equals("") || objVal.equals("0")) {
						
						String tmpStrObjVal = objVal;//2016.03.18
						
						objVal = getRegularValue(ydChgNo, ydChgVerSeq, objNos[i] + "");
						
						//2016.03.18 Default 0을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(0) 를 셋팅한다.
						HashMap<String, String> dftZeroAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_ZERO_ALLOW_OBJECT_NO);
						if(dftZeroAllowMap.containsKey(strObjs[i].toString())){							
							log.debug(prefixLogText+"Default Value(Regular Value) >> Default Zero Allow Object [" + strObjs[i].toString() + "]:=Before Object Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"]");
							if(StringUtils.isEmpty(strObjVal)){
								if(StringUtils.isEmpty(tmpStrObjVal)){
									objVal = "0";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
								}else{
									objVal = tmpStrObjVal;
								}
							}
						}
						
						//2016.04.14 Default N Flag을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(N) 를 셋팅한다.
						HashMap<String, String> dftFlagAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_FLAG_ALLOW_OBJECT_NO);
						if(dftFlagAllowMap.containsKey(strObjs[i].toString())){				
							log.debug(prefixLogText+"Null Value >> Before Default Flag Allow Object [" + strObjs[i].toString() + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
							
							if(StringUtils.isEmpty(strObjVal)){
								if(StringUtils.isEmpty(tmpStrObjVal)){
									strObjVal = "N";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
								}else{
									strObjVal = tmpStrObjVal;
								}
							}
							log.debug(prefixLogText+"Null Value >> After Default Flag Allow Object [" + strObjs[i].toString() + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
						}
						
						hMap.put(strObjs[i].toString(), objVal);
						
						//2015.12.23 Add Reqular Value Add
						regularValueMap.put(strObjs[i].toString(), objVal);
						log.debug(prefixLogText+"Regular After Value ObjVal is Zero [" + objNos[i] + "]:=[" + objVal +"]");
					}
				}
				*/
				log.debug("\n============================================================================"+
						  "\n Tariff Calculation Default Value(Regular Value) Object Find E N D."+
						  "\n============================================================================");

			}// End of Else

		}
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Object Setting E N D."+
				  "\n============================================================================");

		// String[] strXpr = sysXprDesc.split("\\|\\$\\$\\|");//계산식 amount를 위한 string
		String calXpr = "";
		String calDspXpr = "";
		String dspXpr = "";// dfltSysXprDesc; //Display를 위한 String
		
		String inCalXpr = "";
		String inCalDspXpr = "";
		String inDspXpr = "";
		
		String outCalXpr = "";
		String outCalDspXpr = "";
		String outDspXpr = "";
		
		//boolean isBaseZeroAmount = false; //Base Amount 가 0이면 D/S Amount를 구할 필요가 없음.

		calXpr = expressListVO.getSysXprDesc();
		calDspXpr = expressListVO.getDfltSysXprUsrDesc();
		dspXpr = expressListVO.getDfltSysXprValDesc();
		
		inCalXpr = calXpr;
		inCalDspXpr = calDspXpr;
		inDspXpr = dspXpr;
		
		outCalXpr = calXpr;
		outCalDspXpr = calDspXpr;
		outDspXpr = dspXpr;
		
		log.debug("\n============================================================================"+
				  "\n>>>---before calXpr:=" + calXpr +
				  "\n>>>---before calDspXpr:=" + calDspXpr +
				  "\n>>>---before dspXpr:=" + dspXpr +
				  "\n============================================================================");
		
		if (calXpr == null		) 	calXpr = "'null'";
		if (calDspXpr == null	)	calXpr = "null";
		if (dspXpr == null		)	calXpr = "null";

		// Check 'IN' and 'OUT' conditions are all 'Y'.
		boolean inCondi = false;
		boolean outCondi = false;
		for(Object obj : strObjs){
			if("[77]".equals(obj.toString())){
				if("'Y'".equals(hMap.get(obj.toString()))){
					inCondi = true;
					log.debug(prefixLogText+"Object [77]=Y inCondi ["+inCondi+"]");
				}
			}else if("[89]".equals(obj.toString())){
				if("'Y'".equals(hMap.get(obj.toString()))){
					outCondi = true;
					log.debug(prefixLogText+"Object [89]=Y outCondi ["+inCondi+"]");
				}
			}
		}
		
		//2015.12.16 실제 사용된 수식의 0 Value를 체크하기 위한 변수 선언.
		//2015.12.16 Add zero
		int iObjectZeroValueCnt = 0;
		String zeroCalXpr 		= calXpr;
		String zeroCalDspXpr 	= calDspXpr;
		String zeroDspXpr 		= dspXpr;
		
		String zeroInCalXpr 	= calXpr;
		String zeroInCalDspXpr 	= calDspXpr;
		String zeroInDspXpr 	= dspXpr;
		
		String zeroOutCalXpr 	= calXpr;
		String zeroOutCalDspXpr = calDspXpr;
		String zeroOutDspXpr 	= dspXpr;
		

		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Replace Object Value START."+
				  "\n============================================================================");
		// Object Value replace
		for (int i = 0; i < strObjs.length; i++) {
			if (strObjs[i].toString().equals("[45]")) // 이경우는 replace를 하면 안된다.
			//if (strObjs[i].toString().equals("[45]") && !strType.equals("B")) // 2015.12.11 Base 일때 Object * Rate 인 경우가 아닌경우 replace를 하면 안된다.
				continue;
			
			String strRplc = hMap.get(strObjs[i].toString());
			
			log.debug(prefixLogText+"Replace Object ["+i+"]>>>---Object Key ["+strObjs[i].toString()+"] value(strRplc) ["+strRplc+"]");

			if (strObjs[i].toString().indexOf("@") != -1) {
				for (int k = i; k < strObjs.length; k++) {
					String tmp = hMap.get(strObjs[k].toString());
					if (strObjs[k].toString().indexOf(strObjs[i].toString() + "<") != -1) {
						calXpr = calXpr.replace(strObjs[k].toString(), tmp);
						calDspXpr = calDspXpr.replace(strObjs[k].toString(), tmp);
						dspXpr = dspXpr.replace(strObjs[k].toString(), tmp);
					}
				}
			}
			if (strRplc != null) {
				//if (strRplc.equals("''")) strRplc = "null";
				log.debug(prefixLogText+"Replace Object Before strRplc ["+strRplc+"].");
				//if (StringUtil.isEmpty(strRplc)) {
				if((strRplc.trim() == null) || (strRplc.trim().equals(""))){
					boolean isReplaceValue = false;
					isReplaceValue = isStrOperator(calXpr, strObjs[i].toString());
					strRplc = isReplaceValue ? "null" : "0";
				}
				log.debug(prefixLogText+"Replace Object After strRplc ["+strRplc+"].");
				
				//2015.12.11 Add
				if(StringUtils.isEmpty(strRplc) || strRplc.equals("0")) iObjectZeroValueCnt++;
				
				log.debug(prefixLogText+"Replace Object After 0 Count strRplc ["+strRplc+"] iObjectZeroValueCnt ["+iObjectZeroValueCnt+"].");
				
				calXpr = calXpr.replace(strObjs[i].toString(), strRplc);
				calDspXpr = calDspXpr.replace(strObjs[i].toString(), strRplc);
				dspXpr = dspXpr.replace(strObjs[i].toString(), strRplc);
				
				if(inCondi && outCondi){
					// IN/OUT Expression ==> do not replace [77:IN / 89:OUT / 46:BASE / 117:SURCHARGE] 
					if(!"[77]".equals(strObjs[i].toString()) &&
							!"[89]".equals(strObjs[i].toString()) &&
							!"[46]".equals(strObjs[i].toString()) &&
							!"[117]".equals(strObjs[i].toString())){
						inCalXpr = inCalXpr.replace(strObjs[i].toString(), strRplc);
						inCalDspXpr = inCalDspXpr.replace(strObjs[i].toString(), strRplc);
						inDspXpr = inDspXpr.replace(strObjs[i].toString(), strRplc);
						
						outCalXpr = outCalXpr.replace(strObjs[i].toString(), strRplc);
						outCalDspXpr = outCalDspXpr.replace(strObjs[i].toString(), strRplc);
						outDspXpr = outDspXpr.replace(strObjs[i].toString(), strRplc);
					}
				}
			} // if (strRplc != null) end.
		}
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Replace Object Value E N D."+
				  "\n============================================================================");
		
		
		if(inCondi && outCondi){
			log.debug(prefixLogText+"Replace Object inCondi && outCondi Case START======================.");
			inCalXpr = inCalXpr.replace("[77]", "'Y'");
			inCalXpr = inCalXpr.replace("[89]", "'N'");
			inCalDspXpr = inCalDspXpr.replace("[77]", "'Y'");
			inCalDspXpr = inCalDspXpr.replace("[89]", "'N'");
			inDspXpr = inDspXpr.replace("[77]", "'Y'");
			inDspXpr = inDspXpr.replace("[89]", "'N'");
			
			outCalXpr = outCalXpr.replace("[77]", "'N'");
			outCalXpr = outCalXpr.replace("[89]", "'Y'");
			outCalDspXpr = outCalDspXpr.replace("[77]", "'N'");
			outCalDspXpr = outCalDspXpr.replace("[89]", "'Y'");
			outDspXpr = outDspXpr.replace("[77]", "'N'");
			outDspXpr = outDspXpr.replace("[89]", "'Y'");
			
			if("D".equals(strType) || "S".equals(strType)){
				log.debug(prefixLogText+"Replace Object inCondi && outCondi S/D Type ["+strType+"]  InBase ["+calcTariffVO.getInBase()+"] OutBase ["+calcTariffVO.getOutBase()+"]");
				inCalXpr = inCalXpr.replace("[46]", calcTariffVO.getInBase());
				inCalDspXpr = inCalDspXpr.replace("[46]", calcTariffVO.getInBase());
				inDspXpr = inDspXpr.replace("[46]", calcTariffVO.getInBase());
				
				outCalXpr = outCalXpr.replace("[46]", calcTariffVO.getOutBase());
				outCalDspXpr = outCalDspXpr.replace("[46]", calcTariffVO.getOutBase());
				outDspXpr = outDspXpr.replace("[46]", calcTariffVO.getOutBase());

				if("D".equals(strType)){
					log.debug(prefixLogText+"Replace Object inCondi && outCondi D Type ["+strType+"] Object [117] InSurcharge ["+calcTariffVO.getInSurcharge()+"] OutSurcharge ["+calcTariffVO.getOutSurcharge()+"]");
					
					inCalXpr 	= inCalXpr.replace		("[117]", calcTariffVO.getInSurcharge());
					inCalDspXpr = inCalDspXpr.replace	("[117]", calcTariffVO.getInSurcharge());
					inDspXpr 	= inDspXpr.replace		("[117]", calcTariffVO.getInSurcharge());
					
					outCalXpr 	= outCalXpr.replace		("[117]", calcTariffVO.getOutSurcharge());
					outCalDspXpr= outCalDspXpr.replace	("[117]", calcTariffVO.getOutSurcharge());
					outDspXpr 	= outDspXpr.replace		("[117]", calcTariffVO.getOutSurcharge());
				}
			}
			log.debug(prefixLogText+"Replace Object inCondi && outCondi Case E N D======================.");
		}
		
		/*
		 *2015.12.16 0 Value 정책 추가.
		 *개요
		 * AS-IS Object Value 0 체크일때 Condition 에 따른 정상 수식에는 0 이 없지만
		 * 다른 Condition 수식에 0 이 있으면 check 로 나타나는 문제가 있으므로 최종 결과 수식으로 체크 하기 위한 부분.
		 * 1. 기존 수식과 Object 치환부분을 1 Copy 떠서 0 Value > zero 문자로 치환한다.
		 * 2. 수식을 구하는 부분에서 Condition 에 맞는 수식만 zero 체크 한다.
		 */
		//2015.12.16 Add zero
		/*====================================================================*/
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Replace Object Value(Zero Case) START."+
				  "\n============================================================================");
		for (int i = 0; i < strObjs.length; i++) {
			if (strObjs[i].toString().equals("[45]")) // 이경우는 replace를 하면 안된다.
				continue;
			
			String objValue = hMap.get(strObjs[i].toString());
			
			log.debug(prefixLogText+"Zero Before Replace Object ["+i+"]>>>---Object Key ["+strObjs[i].toString()+"] value(objValue) ["+objValue+"]");

			if (strObjs[i].toString().indexOf("@") != -1) {
				for (int k = i; k < strObjs.length; k++) {
					String objKey = hMap.get(strObjs[k].toString());
					if (strObjs[k].toString().indexOf(strObjs[i].toString() + "<") != -1) {
						zeroCalXpr 		= zeroCalXpr.replace	(strObjs[k].toString(), objKey);
						zeroCalDspXpr 	= zeroCalDspXpr.replace	(strObjs[k].toString(), objKey);
						zeroDspXpr 		= zeroDspXpr.replace	(strObjs[k].toString(), objKey);
					}
				}
			}
			if (objValue != null) {
				if(StringUtils.isEmpty(objValue)){
					if(isStrOperator(zeroCalXpr, strObjs[i].toString())){
						objValue = "null";
					}else{
						if(regularValueMap.containsKey(strObjs[i].toString())){
							String tmpReqularValue = regularValueMap.get(strObjs[i].toString());
							log.debug(prefixLogText+"Zero ReqularValue Object ["+i+"] 1 >>>---Object Key ["+strObjs[i].toString()+"] value(objValue) ["+tmpReqularValue+"]");
							if(StringUtils.isEmpty(tmpReqularValue)){
								objValue = "0 /*zero*/";
							}
						}else{
							objValue = "0 /*zero*/";
						}
					}
					//objValue = isStrOperator(zeroCalXpr, strObjs[i].toString()) ? "null" : "0 /*zero*/";
				}
				
				log.debug(prefixLogText+"Zero After Replace Object ["+i+"]>>>---Object Key ["+strObjs[i].toString()+"] value(objValue) ["+objValue+"]");
				
				zeroCalXpr 		= zeroCalXpr.replace	(strObjs[i].toString(), objValue);
				zeroCalDspXpr 	= zeroCalDspXpr.replace	(strObjs[i].toString(), objValue);
				zeroDspXpr 		= zeroDspXpr.replace	(strObjs[i].toString(), objValue);
				
				if(inCondi && outCondi){
					// IN/OUT Expression ==> do not replace [77:IN / 89:OUT / 46:BASE] 
					if(!"[77]".equals(strObjs[i].toString()) &&
							!"[89]".equals(strObjs[i].toString()) &&
							!"[46]".equals(strObjs[i].toString()) &&
							!"[117]".equals(strObjs[i].toString())){
						zeroInCalXpr 	= zeroInCalXpr.replace		(strObjs[i].toString(), objValue);
						zeroInCalDspXpr = zeroInCalDspXpr.replace	(strObjs[i].toString(), objValue);
						zeroInDspXpr 	= zeroInDspXpr.replace		(strObjs[i].toString(), objValue);
						
						zeroOutCalXpr 	= zeroOutCalXpr.replace		(strObjs[i].toString(), objValue);
						zeroOutCalDspXpr= zeroOutCalDspXpr.replace	(strObjs[i].toString(), objValue);
						zeroOutDspXpr 	= zeroOutDspXpr.replace		(strObjs[i].toString(), objValue);
					}
				}
			} // if (strRplc != null) end.
		}
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Replace Object Value(Zero Case) E N D."+
				  "\n============================================================================");
		
		if(inCondi && outCondi){
			log.debug(prefixLogText+"Replace Object Zero inCondi && outCondi Case START======================.");
			zeroInCalXpr 		= zeroInCalXpr.replace		("[77]", "'Y'");
			zeroInCalXpr 		= zeroInCalXpr.replace		("[89]", "'N'");
			zeroInCalDspXpr 	= zeroInCalDspXpr.replace	("[77]", "'Y'");
			zeroInCalDspXpr 	= zeroInCalDspXpr.replace	("[89]", "'N'");
			zeroInDspXpr 		= zeroInDspXpr.replace		("[77]", "'Y'");
			zeroInDspXpr 		= zeroInDspXpr.replace		("[89]", "'N'");
			
			zeroOutCalXpr 		= zeroOutCalXpr.replace		("[77]", "'N'");
			zeroOutCalXpr 		= zeroOutCalXpr.replace		("[89]", "'Y'");
			zeroOutCalDspXpr 	= zeroOutCalDspXpr.replace	("[77]", "'N'");
			zeroOutCalDspXpr 	= zeroOutCalDspXpr.replace	("[89]", "'Y'");
			zeroOutDspXpr 		= zeroOutDspXpr.replace		("[77]", "'N'");
			zeroOutDspXpr 		= zeroOutDspXpr.replace		("[89]", "'Y'");
			
			if("D".equals(strType) || "S".equals(strType)){
				log.debug(prefixLogText+"Replace Object Zero inCondi && outCondi S/D Type ["+strType+"]  InBase ["+calcTariffVO.getInBase()+"] OutBase ["+calcTariffVO.getOutBase()+"]");
				zeroInCalXpr 	= zeroInCalXpr.replace		("[46]", calcTariffVO.getInBase());
				zeroInCalDspXpr = zeroInCalDspXpr.replace	("[46]", calcTariffVO.getInBase());
				zeroInDspXpr 	= zeroInDspXpr.replace		("[46]", calcTariffVO.getInBase());
				
				zeroOutCalXpr 	= zeroOutCalXpr.replace		("[46]", calcTariffVO.getOutBase());
				zeroOutCalDspXpr= zeroOutCalDspXpr.replace	("[46]", calcTariffVO.getOutBase());
				zeroOutDspXpr 	= zeroOutDspXpr.replace		("[46]", calcTariffVO.getOutBase());
				
				if("D".equals(strType)){
					log.debug(prefixLogText+"Replace Object Zero inCondi && outCondi D Type ["+strType+"] Object [117] InSurcharge ["+calcTariffVO.getInSurcharge()+"] OutSurcharge ["+calcTariffVO.getOutSurcharge()+"]");
					
					zeroInCalXpr 	= zeroInCalXpr.replace		("[117]", calcTariffVO.getInSurcharge());
					zeroInCalDspXpr = zeroInCalDspXpr.replace	("[117]", calcTariffVO.getInSurcharge());
					zeroInDspXpr 	= zeroInDspXpr.replace		("[117]", calcTariffVO.getInSurcharge());
					
					zeroOutCalXpr 	= zeroOutCalXpr.replace		("[117]", calcTariffVO.getOutSurcharge());
					zeroOutCalDspXpr= zeroOutCalDspXpr.replace	("[117]", calcTariffVO.getOutSurcharge());
					zeroOutDspXpr 	= zeroOutDspXpr.replace		("[117]", calcTariffVO.getOutSurcharge());
				}
			}
			log.debug(prefixLogText+"Replace Object Zero inCondi && outCondi Case E N D======================.");
		}
		/*====================================================================*/
		
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation After Condition Value."+
				  "\n>>>---after strType		:=[" + strType 		+ "]" +
				  "\n>>>---after inCondi		:=[" + inCondi 		+ "]" +
				  "\n>>>---after outCondi		:=[" + outCondi 	+ "]" +
				  "\n>>>---after calXpr			:=[" + calXpr 		+ "]" +
				  "\n>>>---after calDspXpr		:=[" + calDspXpr	+ "]" +
				  "\n>>>---after dspXpr			:=[" + dspXpr 		+ "]" +
				  "\n>>>---after zeroCalXpr		:=[" + zeroCalXpr 	+ "]" +
				  "\n>>>---after zeroCalDspXpr	:=[" + zeroCalDspXpr+ "]" +
				  "\n>>>---after zeroDspXpr		:=[" + zeroDspXpr 	+ "]" +
				  "\n>>>---after iObjectZeroValueCnt:=[" + iObjectZeroValueCnt + "]" +
				  "\n============================================================================");
		
		// select dual
		List<CalcTariffResultVO> list = null;
		List<CalcTariffResultVO> inResult = null;
		List<CalcTariffResultVO> outResult = null;
		
		//2015.12.16 Add zero Value 체크를 위한 수식.
		List<CalcTariffResultVO> zeroList = null;

		log.debug("\n============================================================================"+
				  "\n ["+strType+"] Tariff Calculation Execute Amount START."+
				  "\n============================================================================");
		try {
			log.debug(prefixLogText+"["+strType+"] Execute Amount executeTariff Call.");
			list = dbDao.executeTariff(calXpr, calDspXpr, dspXpr);// expr
			
			if(inCondi && outCondi){
				log.debug(prefixLogText+"["+strType+"] Execute Amount executeTariff inCondi && outCondi Call.");
				inResult = dbDao.executeTariff(inCalXpr, inCalDspXpr, inDspXpr);// expr
				outResult = dbDao.executeTariff(outCalXpr, outCalDspXpr, outDspXpr);// expr
			}
			
			//2015.12.16 Add zero
			/*====================================================================*/
			log.debug(prefixLogText+"["+strType+"] Execute Amount executeTariff Zero Check Case Call.");
			zeroList = dbDao.executeTariff(zeroCalXpr, zeroCalDspXpr, zeroDspXpr);
			/*====================================================================*/
		} catch (DAOException ex) {
			log.debug(prefixLogText+"Execute Amount Tariff DAO Error [" + ex.getMessage() + "]");
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : executeTariff" }).getMessage(), ex);
		} catch (Exception ex) {
			log.debug(prefixLogText+"Execute Amount Exception Error [" + ex.getMessage() + "]");
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : executeTariff" }).getMessage(), ex);
		}
		
		log.debug(prefixLogText+"Execute Amount list size [" + list.size() + "] zero List size ["+zeroList.size()+"]");
		
		String iDisFormDesc = "";
		String iRunFormDesc = "";
		String oDisFormDesc = "";
		String oRunFormDesc = "";
		
		StringBuffer tmpDisplaySb = new StringBuffer();
		StringBuffer tmpRuntimeSb = new StringBuffer();
		
		if(inCondi && outCondi){
			log.debug(prefixLogText+"In/Out Tariff Amount Find inCondi && outCondi Case START======================.");
			String inAmt = inResult.get(0).getTariffAmount();
			String outAmt = outResult.get(0).getTariffAmount();
			
			//2015.12.09 In/Out Amount Null Value 일때 아래에서 [info] 를 넣어주기 위한 방편			
			if(StringUtils.isEmpty(inAmt)){
				inAmt = "0";
			}
			if(StringUtils.isEmpty(outAmt)){
				outAmt = "0";
			}
			vo.setInAmt(inAmt);
			vo.setOutAmt(outAmt);			
			
			iDisFormDesc = inResult.get(0).getDisplayFormulaDesc();
			iRunFormDesc = inResult.get(0).getRuntimeFormulaDesc();
			
			oDisFormDesc = outResult.get(0).getDisplayFormulaDesc();
			oRunFormDesc = outResult.get(0).getRuntimeFormulaDesc();
			
			if(StringUtils.isNotEmpty(StringUtils.trimToEmpty(iDisFormDesc))){
				tmpDisplaySb.append(iDisFormDesc);
			}
			
			if(StringUtils.isNotEmpty(StringUtils.trimToEmpty(oDisFormDesc))){
				if(StringUtils.isNotEmpty(StringUtils.trimToEmpty(tmpDisplaySb.toString()))){
					tmpDisplaySb.append(" + ");
				}
				tmpDisplaySb.append(oDisFormDesc);
			}
			
			if(StringUtils.isNotEmpty(StringUtils.trimToEmpty(iRunFormDesc))){
				tmpRuntimeSb.append(iRunFormDesc);
			}
			
			if(StringUtils.isNotEmpty(StringUtils.trimToEmpty(oRunFormDesc))){
				if(StringUtils.isNotEmpty(StringUtils.trimToEmpty(tmpRuntimeSb.toString()))){
					tmpRuntimeSb.append(" + ");
				}
				tmpRuntimeSb.append(oRunFormDesc);
			}
			
			if("B".equals(strType)){
				calcTariffVO.setInBase(inAmt);
				calcTariffVO.setOutBase(outAmt);
				
				log.debug(prefixLogText+"In/Out Tariff Amount Find inCondi && outCondi strType ["+strType+"] inAmt["+inAmt+"] outAmt["+inAmt+"]");
			}else if("S".equals(strType)){
				calcTariffVO.setInSurcharge(inAmt);
				calcTariffVO.setOutSurcharge(outAmt);
				
				log.debug(prefixLogText+"In/Out Tariff Amount Find inCondi && outCondi strType ["+strType+"] InSurcharge["+inAmt+"] OutSurcharge["+inAmt+"]");
			}

			log.debug(prefixLogText+"In/Out Tariff Amount Find inCondi && outCondi Case E N D======================.");
		}

		log.debug("\n============================================================================"+
				  "\n ["+strType+"] Tariff Calculation Execute Amount E N D."+
				  "\n============================================================================");
		
		boolean isCheckCalXpr = false;
		String[] checkValueArr = new String[]{"no-rate","null","no found"};

		if(StringUtils.indexOfAny(calXpr, checkValueArr) > -1) isCheckCalXpr = true;
		log.debug(prefixLogText+"Tariff Calculation Check Condition => 1st calXpr isCheckCalXpr["+isCheckCalXpr+"].");
		
		//2015.12.16 Add zero
		boolean isZeroCheckCalXpr 		= false;
		String[] checkZeroValueArr = new String[]{"zero"};		

		log.debug("\n============================================================================"+
				  "\n ["+strType+"] Tariff Calculation Check Condition START."+
				  "\n============================================================================");
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				CalcTariffResultVO rlt = list.get(i);				
				
				String rltDisplayForulaDesc 	= rlt.getDisplayFormulaDesc();
				String rltRuntimeFormulaDesc 	= rlt.getRuntimeFormulaDesc();
				
				String chkTmpDisplay			= "";
				String chkTmpRuntime			= "";
				
				log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => 2nd calXpr Before isCheckCalXpr ["+isCheckCalXpr+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"].");
				//2015.12.16 Add. 정상 수식이 아닐때 다시 결과값을 가지고 체크 하도록 수정.
				if(isCheckCalXpr){
					if(StringUtils.indexOfAny(rltDisplayForulaDesc, checkValueArr) > -1){
						isCheckCalXpr = true; 	// 비정상 수식.
					}else{
						isCheckCalXpr = false; 	// 정상 수식으로 인정.
					}
				}
				log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => 2nd calXpr After isCheckCalXpr ["+isCheckCalXpr+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"].");
				
				
				//2015.12.16 Add zero
				/*====================================================================*/
				if(zeroList != null && zeroList.size() > 0){
					for (int ii = 0; ii < zeroList.size(); ii++) {
						CalcTariffResultVO zeroVo = zeroList.get(ii);
						log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Zero Before DisplayFormulaDesc ["+zeroVo.getDisplayFormulaDesc()+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"]");
						
						if(StringUtils.indexOfAny(zeroVo.getDisplayFormulaDesc(), checkZeroValueArr) > -1) isZeroCheckCalXpr = true;
						
						log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Zero After DisplayFormulaDesc ["+zeroVo.getDisplayFormulaDesc()+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"]");
						
					}
				}
				/*====================================================================*/
				
				log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Last Check isCheckCalXpr ["+isCheckCalXpr+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"].");
				
				if(inCondi && outCondi){
					vo.setTariffAmount(new BigDecimal(vo.getInAmt()).add(new BigDecimal(vo.getOutAmt())).toString());
				}else{
					vo.setTariffAmount(rlt.getTariffAmount());
				}
				

				if (rlt.getTariffAmount() != null) {
					
					if(inCondi && outCondi){
						chkTmpDisplay = StringUtils.isEmpty(StringUtils.trimToEmpty(tmpDisplaySb.toString()))	? dspXpr 	: tmpDisplaySb.toString();
						chkTmpRuntime = StringUtils.isEmpty(StringUtils.trimToEmpty(tmpRuntimeSb.toString())) 	? calDspXpr : tmpRuntimeSb.toString();
					}else{
						chkTmpDisplay = StringUtils.isEmpty(StringUtils.trimToEmpty(rltDisplayForulaDesc))	? dspXpr 	: rltDisplayForulaDesc;
						chkTmpRuntime = StringUtils.isEmpty(StringUtils.trimToEmpty(rltRuntimeFormulaDesc)) ? calDspXpr : rltRuntimeFormulaDesc;
					}
					log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Tariff Amount not null value ["+rlt.getTariffAmount()+"] In.");
					if (!rlt.getTariffAmount().equals("0")) {
						log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case In strType ["+strType+"] isCheckCalXpr["+isCheckCalXpr+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"].");
						if(inCondi && outCondi){
							if(isCheckCalXpr){//2015.12.10 null, no found, no-rate 존재
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case inCondi && outCondi --> isCheckCalXpr["+isCheckCalXpr+"] [check] In.");
								vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }"); //tmpDisplaySb.toString()
								vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //tmpRuntimeSb.toString()
							}else if(isZeroCheckCalXpr){
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case inCondi && outCondi --> iObjectZeroValueCnt["+iObjectZeroValueCnt+"] [check] In.");
								vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay+ " }"); //tmpDisplaySb.toString()
								vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime+ " }"); //tmpRuntimeSb.toString()
							}else{
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case inCondi && outCondi --> Normal In.");
								vo.setDisplayFormulaDesc(chkTmpDisplay); //tmpDisplaySb.toString()
								vo.setRuntimeFormulaDesc(chkTmpRuntime); //tmpRuntimeSb.toString()
							}
						}else{
							if(isCheckCalXpr){//2015.12.10 null, no found, no-rate 존재
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case --> isCheckCalXpr["+isCheckCalXpr+"] [check] In.");
								vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");//dspXpr
								vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
							}else if(isZeroCheckCalXpr){
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case --> iObjectZeroValueCnt["+iObjectZeroValueCnt+"] [check] In.");
								vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");//dspXpr
								vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
							}else{
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount not 0 case --> Normal In.");
								vo.setDisplayFormulaDesc(chkTmpDisplay); //rltDisplayForulaDesc
								vo.setRuntimeFormulaDesc(chkTmpRuntime); //rltRuntimeFormulaDesc
							}
						}
					} else {
						log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Description Tariff Amount 0 case In strType ["+strType+"] isCheckCalXpr["+isCheckCalXpr+"] isZeroCheckCalXpr["+isZeroCheckCalXpr+"].");
						//2015.12.09 In/Out 실제 계산된 값이 Amount Null Value 일때 [info] 를 넣어주기 위한 방편
						if (strType.equals("B")) {
							if(isCheckCalXpr){//2015.12.10 null, no found, no-rate 존재
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [B] Description Tariff Amount 0 case --> isCheckCalXpr["+isCheckCalXpr+"] [check] In.");
								vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");//dspXpr
								vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
							}else if(isZeroCheckCalXpr){
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [B] Description Tariff Amount 0 case --> iObjectZeroValueCnt["+iObjectZeroValueCnt+"] [check] In.");
								vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");//dspXpr
								vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
							}else{
								if(StringUtils.indexOfAny(calXpr, checkValueArr) > -1){
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [B] Description Tariff Amount 0 case --> Normal In [check] In.");
									vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");//dspXpr
									vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
								}else{
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [B] Description Tariff Amount 0 case --> Normal In [info] In.");
									vo.setDisplayFormulaDesc("[info]:= { " + chkTmpDisplay + " }");//dspXpr
									vo.setRuntimeFormulaDesc("[info]:= { " + chkTmpRuntime + " }"); //calDspXpr
								}
							}
						} else {
							if(inCondi && outCondi){
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case inCondi && outCondi In.");
								if(isCheckCalXpr){//2015.12.10 null, no found, no-rate 존재
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case inCondi && outCondi --> isCheckCalXpr["+isCheckCalXpr+"] [check] In.");
									vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }"); //tmpDisplaySb.toString()
									vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //tmpRuntimeSb.toString()
								}else if(isZeroCheckCalXpr){
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case inCondi && outCondi --> iObjectZeroValueCnt["+iObjectZeroValueCnt+"] [check] In.");
									vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay+ " }"); //tmpDisplaySb.toString()
									vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime+ " }"); //tmpRuntimeSb.toString()
								}else{
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case inCondi && outCondi --> Normal In.");
									vo.setDisplayFormulaDesc(chkTmpDisplay); //tmpDisplaySb.toString()
									vo.setRuntimeFormulaDesc(chkTmpRuntime); //tmpRuntimeSb.toString()
								}
								
								//vo.setDisplayFormulaDesc(tmpDisplaySb.toString());
								//vo.setRuntimeFormulaDesc(tmpRuntimeSb.toString());
							}else{
								log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case Normal In.");
								
								if(isCheckCalXpr){//2015.12.10 null, no found, no-rate 존재
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case --> isCheckCalXpr["+isCheckCalXpr+"] [check] In.");
									vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");	//dspXpr
									vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
								}else if(isZeroCheckCalXpr){
									log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case --> iObjectZeroValueCnt["+iObjectZeroValueCnt+"] [check] In.");
									vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }");	//dspXpr
									vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
								}else{
									if(StringUtils.indexOfAny(calXpr, checkValueArr) > -1){
										log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case --> Normal In [check] In.");
										vo.setDisplayFormulaDesc("[check]:= { " + chkTmpDisplay + " }"); //dspXpr
										vo.setRuntimeFormulaDesc("[check]:= { " + chkTmpRuntime + " }"); //calDspXpr
									}else{
										log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => [S][D] Type Description Tariff Amount 0 case --> Normal In [info] In.");
										vo.setDisplayFormulaDesc("[info]:= { " + chkTmpDisplay + " }");	//dspXpr
										vo.setRuntimeFormulaDesc("[info]:= { " + chkTmpRuntime + " }"); //calDspXpr
									}
								}								
								//vo.setDisplayFormulaDesc(rltDisplayForulaDesc);
								//vo.setRuntimeFormulaDesc(rltRuntimeFormulaDesc);
							}
						}
					}
				} else {// 계산값이 null이면
					log.debug(prefixLogText+"Tariff Calculation Check Condition Loop["+i+"] => Tariff Amount null value In.");
					vo.setDisplayFormulaDesc(rltDisplayForulaDesc);
					vo.setRuntimeFormulaDesc(rltRuntimeFormulaDesc);
				}
				
				log.debug(  "\n============================================================================"+
						    "\n ["+strType+"][B/S/D] Tariff Calculation Check Condition Value."+
						    "\n>>>---strType					:=[" + strType +"]"+
						    "\n>>>---inCondi / outCondi			:=[" + inCondi +"/"+ outCondi +"]"+
						    "\n>>>---isCheckCalXpr				:=[" + isCheckCalXpr +"]"+
						    "\n>>>---isZeroCheckCalXpr			:=[" + isZeroCheckCalXpr +"]"+
						    "\n>>>---getTariffAmount()			:=[" + rlt.getTariffAmount() +"]"+
						    "\n>>>---rlt.getDisplayFormulaDesc():=[" + rltDisplayForulaDesc +"]"+
						    "\n>>>---rlt.getRuntimeFormulaDesc():=[" + rltRuntimeFormulaDesc +"]"+
						    "\n>>>---tmpDisplaySb				:=[" + tmpDisplaySb.toString() +"]"+
						    "\n>>>---tmpRuntimeSb				:=[" + tmpRuntimeSb.toString() +"]"+
						    "\n>>>---dspXpr						:=[" + dspXpr +"]"+
						    "\n>>>---calDspXpr					:=[" + calDspXpr +"]"+
						  "\n============================================================================");

				
				// 컬럼 길이 4000 Byte 제약 조건 때문에 수식을 제한하도록 함.
				if(vo.getDisplayFormulaDesc() != null && vo.getDisplayFormulaDesc().length() > 4000){
					vo.setDisplayFormulaDesc(vo.getDisplayFormulaDesc().substring(0, 3500));
				}
				if(vo.getRuntimeFormulaDesc() != null && vo.getRuntimeFormulaDesc().length() > 4000){
					vo.setRuntimeFormulaDesc(vo.getRuntimeFormulaDesc().substring(0, 3500));
				}
			}
		}
		

		log.debug("\n============================================================================"+
				  "\n ["+strType+"] Tariff Calculation Check Condition E N D."+
				  "\n============================================================================");
		
		//Base 금액이 0일때는 Surcharge/Discount 금액 0으로 치환한다.
		log.debug(prefixLogText+"Base Amount = 0 Check Case Before strType ["+strType+"]>>>---getBaseTariffAmount ["+calcTariffVO.getBaseTariffAmount()+"] Zero Marking Start.");
		if(("D".equals(strType) || "S".equals(strType))){
			Double dTmpAmount = NumberUtils.toDouble(calcTariffVO.getBaseTariffAmount(), 0d);
			if((NumberUtils.compare(dTmpAmount, 0d) == 0 || StringUtils.isEmpty(calcTariffVO.getBaseTariffAmount()))){
				vo.setTariffAmount("0");
				log.debug(prefixLogText+"Base Amount = 0 Check Case >> Base Amount ["+calcTariffVO.getBaseTariffAmount()+"] Discount, Surcharge Zero Amount ["+vo.getTariffAmount()+"]");
			}
		}
		log.debug(prefixLogText+"Base Amount = 0 Check Case After strType ["+strType+"]>>>---getBaseTariffAmount ["+calcTariffVO.getBaseTariffAmount()+"] Zero Marking E n d.");
		
		
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation Last Condition Value."+
			      "\n>>>---Last strType:=[" + strType +"]"+
			      "\n>>>---Last inCondi:=[" + inCondi + "] outCondi:=["+ outCondi +"]"+
				  "\n>>>---Last DisplayFormulaDesc:=[" + vo.getDisplayFormulaDesc() +"]"+
				  "\n>>>---Last RuntimeFormulaDesc:=[" + vo.getRuntimeFormulaDesc() +"]"+
				  "\n>>>---Last tmpDisplaySb:=[" + tmpDisplaySb.toString() +"]"+
				  "\n>>>---Last tmpRuntimeSb:=[" + tmpRuntimeSb.toString() +"]"+
				  "\n>>>---Last TariffAmount:=[" + vo.getTariffAmount() +"]"+
				  "\n============================================================================");
		
		log.debug("\n============================================================================"+
				  "\n Tariff Calculation E N D."+
				  "\n============================================================================");
		return vo;
	}
	
	/**
	 *   
	 * @category Obj65_ETBDate
	 * @param String expr
	 * @param String str
	 * @return boolean isOp
	 * @throws EventException
	 */	
	private boolean isStrOperator(String expr, String str) {		
		boolean isOp = false;
		log.debug("\nm(^^)m ==> isStrOperator START=====================isOp ["+isOp+"].");
		log.debug("\nm(^^)m ==> =============================================="
				 + "\n expr : ["+expr+"]"
				 + "\n str : ["+str+"]"
				 + "\nm(^^)m ==> ==============================================");
		
		int i = expr.indexOf(str);
		
		if (i > -1) {		// 치환할 문자가 존재할 경우
			String expr2 = expr.substring(i + str.length()).replaceAll(" ", "");	// 다음문자를 찾기위해 빈공백을 제거한다.
			
			log.debug("\nm(^^)m ==> isStrOperator 22 expr2 ["+expr2+"].");
			
			if(!StringUtils.isEmpty(expr2)){ 
				char ch = expr2.charAt(0);
				
				switch(ch) {
					case '=':
					case '>':
					case '<':
						isOp = true;
					break;
				}
			}
		}
		log.debug("\nm(^^)m ==> isStrOperator E N D=====================isOp ["+isOp+"].");
		return isOp;		
	}

	/**
	 * case 65://ETB DATE
	 * 
	 * @category Obj65_ETBDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtbDate(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtbDate(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj65_ETBDate" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj65_ETBDate" }).getMessage(), ex);
		}
	}

	/**
	 * case 79://last Issued Invoice ETD
	 * 
	 * @category Obj79_lastIssuedInvoiceETD
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @param String lgsCostCd
	 * @return String
	 * @throws EventException
	 */
	private String getLastInvEtd(String vvd, String ydCd, String clptIndSeq, String lgsCostCd) throws EventException {
		try {
			return dbDao.getLastInvEtd(vvd, ydCd, clptIndSeq, lgsCostCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj79_lastIssuedInvoiceETD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj79_lastIssuedInvoiceETD" }).getMessage(), ex);
		}
	}

	/**
	 * case 24://Country of Next Port
	 * 
	 * @category Obj24_CountryofNextPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getCntNextPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getCntNextPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj24_CountryofNextPort" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj24_CountryofNextPort" }).getMessage(), ex);
		}
	}

	/**
	 * case 23://Country of Last Port
	 * 
	 * @category Obj23_CountryofLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getCntLastPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getCntLastPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj23_CountryofLastPort" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj23_CountryofLastPort" }).getMessage(), ex);
		}
	}

	/**
	 * case 37://Anchoring Hour
	 * 
	 * @category Obj37_AnchoringHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getAnchoringHour(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getAnchoringHour(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj37_AnchoringHour" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj37_AnchoringHour" }).getMessage(), ex);
		}
	}

	/**
	 * case 90:/Pilot Off
	 * 
	 * @category Obj90_POff
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getPOff(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getPOff(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj90_POff" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj90_POff" }).getMessage(), ex);
		}
	}

	/**
	 * case 91://POB
	 * 
	 * @category Obj91_Pob
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getPob(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getPob(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj91_Pob" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj91_Pob" }).getMessage(), ex);
		}
	}

	/**
	 * case 92://Rehandling Volume
	 * 
	 * @category Obj92_RhVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getRhVol(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getRhVol(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj92_RhVol" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj92_RhVol" }).getMessage(), ex);
		}
	}

	/**
	 * case 93://Remain Vessel Call
	 * 
	 * @category Obj93_RemainVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getRemainVesselCall(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getRemainVesselCall(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj93_RemainVesselCall" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj93_RemainVesselCall" }).getMessage(), ex);
		}
	}

	/**
	 * case 112://Water Volume
	 * 
	 * @category Obj112_WatVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getWatVol(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getWatVol(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj112_WatVol" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj112_WatVol" }).getMessage(), ex);
		}
	}

	/**
	 * case 33://Outbound Volume
	 * 
	 * @category Obj33_OutbundVolume
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getOutboundVolume(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getOutboundVolume(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj33_OutbundVolume" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj33_OutbundVolume" }).getMessage(), ex);
		}
	}

	/**
	 * case 32://Inbound Volume
	 * 
	 * @category Obj32_InboundVolume
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getInboundVolume(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getInboundVolume(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj32_InboundVolume" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj32_InboundVolume" }).getMessage(), ex);
		}
	}

	/**
	 * case 126://Inbound Ton
	 * 
	 * @category Obj126_InboundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getInboundTon(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getInboundTon(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj126_InboundTon" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj126_InboundTon" }).getMessage(), ex);
		}
	}

	/**
	 * case 127://Outbound Ton
	 * 
	 * @category Obj127_OutbundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getOutboundTon(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getOutboundTon(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj127_OutbundTon" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj127_OutbundTon" }).getMessage(), ex);
		}
	}

	/**
	 * case 128://Rehandling Ton
	 * 
	 * @category Obj128_RhTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getRhTon(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getRhTon(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj128_RhTon" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj128_RhTon" }).getMessage(), ex);
		}
	}

	/**
	 * case 129://ETA Hour
	 * 
	 * @category Obj129_EtaHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtaHour(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtaHour(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj129_EtaHour" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj129_EtaHour" }).getMessage(), ex);
		}
	}

	/**
	 * case 130://Cargo Volume Ton
	 * 
	 * @category Obj130_CargoVolumeTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getCargoVolumeTon(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getCargoVolumeTon(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj130_CargoVolumeTon" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj127_CargoVolumeTon" }).getMessage(), ex);
		}
	}

	/**
	 * case 131://Vessel Volume(FR)
	 * 
	 * @category Obj131_VesselVolumeFr
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getVesselVolumeFr(String vvd) throws EventException {
		try {
			return dbDao.getVesselVolumeFr(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj131_VesselVolumeFr" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj131_VesselVolumeFr" }).getMessage(), ex);
		}
	}

	/**
	 * Get Regular Value
	 * 
	 * @category getRegularValue
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getRegularValue(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getRegularValue(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getRegularValue" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getRegularValue" }).getMessage(), ex);
		}
	}

	/**
	 * case 71://ETD Time case 72://ETD1 Time
	 * 
	 * @category Obj71_EtdTime
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtdTime(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtdTime(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj71_EtdTime" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj71_EtdTime" }).getMessage(), ex);
		}
	}

	/**
	 * case 70://ETD Month
	 * 
	 * @category Obj70_EtdMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtdMonth(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtdMonth(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj70_EtdMonth" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj70_EtdMonth" }).getMessage(), ex);
		}
	}

	/**
	 * case 76://I/B Volume/Blocksize
	 * 
	 * @category Obj76_IBVolBsz
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getIBVolBsz(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getIBVolBsz(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj76_IBVolBsz" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj76_IBVolBsz" }).getMessage(), ex);
		}
	}

	/**
	 * case 88://O/B Volume/Blocksize
	 * 
	 * @category Obj88_OBVolBsz
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getOBVolBsz(String vvd, String ydCd) throws EventException {
		try {
			return dbDao.getOBVolBsz(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj88_OBVolBsz" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj88_OBVolBsz" }).getMessage(), ex);
		}
	}

	/**
	 * case 69://ETD Date
	 * 
	 * @category Obj69_EtdDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtdDate(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtdDate(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj69_EtdDate" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj69_EtdDate" }).getMessage(), ex);
		}
	}

	/**
	 * case 67://ETB Time
	 * 
	 * @category Obj67_EtbTime
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtbTime(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtbTime(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj67_EtbTime" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj67_EtbTime" }).getMessage(), ex);
		}
	}

	/**
	 * case 66://ETB Month
	 * 
	 * @category Obj66_EtbMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtbMonth(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtbMonth(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj66_EtbMonth" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj66_EtbMonth" }).getMessage(), ex);
		}
	}

	/**
	 * case 120://DEM/DET Holiday(ETB)
	 * 
	 * @category Obj120_DemdetHolidayETB
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDemdetHolidayETB(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDemdetHolidayETB(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj120_DemdetHolidayETB" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj120_DemdetHolidayETB" }).getMessage(), ex);
		}
	}

	/**
	 * case 121://DEM/DET Holiday(ETD)
	 * 
	 * @category Obj120_DemdetHolidayETB
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDemdetHolidayETD(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDemdetHolidayETD(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj121_DemdetHolidayETD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj121_DemdetHolidayETD" }).getMessage(), ex);
		}
	}

	/**
	 * case 152://DEM/DET Holiday(ETA)
	 * 
	 * @category Obj120_DemdetHolidayETA
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDemdetHolidayETA(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDemdetHolidayETA(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj121_DemdetHolidayETD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj121_DemdetHolidayETD" }).getMessage(), ex);
		}
	}

	/**
	 * case 122://Ownership In case of Owner of Vessel chosen is own , "Y" / In
	 * case of Charter, "N"
	 * 
	 * @category Obj122_Ownership
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getOwnrship(String vvd) throws EventException {
		try {
			return dbDao.getOwnrship(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj122_Ownership" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj122_Ownership" }).getMessage(), ex);
		}
	}

	/**
	 * case 123://ETB(H)
	 * 
	 * @category Obj123_ETB(H)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtbHr(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtbHr(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj123_ETB(H)" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj123_ETB(H)" }).getMessage(), ex);
		}
	}

	/**
	 * case 124://ETD(H)
	 * 
	 * @category Obj124_ETD(H)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtdHr(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtdHr(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj124_ETD(H)" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj124_ETD(H)" }).getMessage(), ex);
		}
	}

	/**
	 * case 149://ETA Time case 150://ETA1 Time
	 * 
	 * @category Obj149_EtaTime
	 * @category Obj150_Eta1Time
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtaTime(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtaTime(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj149_EtaTime/Obj150_Eta1Time" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj149_EtaTime/Obj150_Eta1Time" }).getMessage(), ex);
		}
	}

	/**
	 * @param CalcTariffVO
	 *            calcTariffVO
	 * @param int[] objNos
	 * @param String strObjVal
	 * @param String vvd
	 * @param String ydCd
	 * @param String lgsCostCd
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String clptIndSeq
	 * @param int i
	 * @param int iObjListNo
	 * @param String repVvd
	 * @return String
	 * @throws EventException
	 */
	private String getObjectValue(CalcTariffVO calcTariffVO, int[] objNos, String strObjVal, String vvd, String ydCd, String lgsCostCd, String ydChgNo, String ydChgVerSeq, String clptIndSeq, int i, int iObjListNo, String repVvd) throws EventException {
		log.debug("\n============================================================================"+
				  "\n getObjectValue START."+
				  "\n strObjVal 	= ["+strObjVal+"]"+
				  "\n vvd 			= ["+vvd+"]"+
				  "\n ydCd 			= ["+ydCd+"]"+
				  "\n lgsCostCd 	= ["+lgsCostCd+"]"+
				  "\n ydChgNo 		= ["+ydChgNo+"]"+
				  "\n ydChgVerSeq 	= ["+ydChgVerSeq+"]"+
				  "\n clptIndSeq 	= ["+clptIndSeq+"]"+
				  "\n i 			= ["+i+"]"+
				  "\n iObjListNo 	= ["+iObjListNo+"]"+
				  "\n repVvd 		= ["+repVvd+"]"+
				  "\n============================================================================");
		String prefixLogText = "\nm(^^)m ==> getObjectValue ObjListNO ["+iObjListNo+"] :: ";
		
		switch (iObjListNo) {
			// Replace Pattern = str([a-z,A-Z])*\s=
			// --> strObjVal =
			case 1: // Allowance TEU
				log.debug(prefixLogText+"Allowance TEU" + "[" + 1 + "]");
				strObjVal = getAllwTeu(repVvd);
				// hMap.put(strObjs[i].toString(), strAllwTeu);
				break;
			case 2: // Arrival Draft
				log.debug(prefixLogText+"Arrival Draft Feet" + "[" + 2 + "]");
				strObjVal = getArvDrftFeet(vvd, ydCd, clptIndSeq);
				// hMap.put(strObjs[i].toString(), strArvDrft);
				break;
			case 3: // Departure Draft Meter
			case 25: // Departure Draft1 Meter
				log.debug(prefixLogText+"Departure Draft Meter" + "[" + 3 + "]");
				strObjVal = getDprDftMeter(vvd, ydCd, clptIndSeq);
				// hMap.put(strObjs[i].toString(), strDprDft);
				break;
			case 4: // Arrival No. of Tractor
				log.debug(prefixLogText+"Arrival No. of Tractor" + "[" + 4 + "]");
				strObjVal = getArvNoOfTrk(ydChgNo, ydChgVerSeq, 4 + "");
				// hMap.put(strObjs[i].toString(), strArvNoOfTrk);
				break;
			case 5: // Departure No. of Tractor
				log.debug(prefixLogText+"Departure No. of  Tractor" + "[" + 5 + "]");
				strObjVal = getDprNoOfTrk(ydChgNo, ydChgVerSeq, 5 + "");
				// hMap.put(strObjs[i].toString(), strDprNoOfTrk);
				break;
			case 6: // Arrival No. of Tug
				log.debug(prefixLogText+"Arrival No. of Tug" + "[" + 6 + "]");
				strObjVal = getArvNoOfTug(vvd, ydCd, clptIndSeq);
				// hMap.put(strObjs[i].toString(), strArvNoOfTug);
				break;
			case 7: // Departure No. of Tug
				log.debug(prefixLogText+"Departure No. of Tug" + "[" + 7 + "]");
				strObjVal = getDprNoOfTug(vvd, ydCd, clptIndSeq);
				// hMap.put(strObjs[i].toString(), strDprNoOfTug);
				break;
			case 8: // Arrival Tug Power
				log.debug(prefixLogText+"Arrival Tug Power" + "[" + 8 + "]");
				strObjVal = getArvTugPwr(ydChgNo, ydChgVerSeq, 8 + "");
				// hMap.put(strObjs[i].toString(), strArvTugPwr);
				break;
			case 9: // Departure Tug Power
				log.debug(prefixLogText+"Departure Tug Power" + "[" + 9 + "]");
				strObjVal = getDprTugPwr(ydChgNo, ydChgVerSeq, 9 + "");
				// hMap.put(strObjs[i].toString(), strDprTugPwr);
				break;
			case 10: // Arrival Tug Used Hour
				log.debug(prefixLogText+"Arrival Tug Used Hour" + "[" + 10 + "]");
				strObjVal = getArvTugUsedHour(ydChgNo, ydChgVerSeq, 10 + "");
				// hMap.put(strObjs[i].toString(), strArvTugUsedHour);
				break;
			case 11: // Departure Tug Used Hour
				log.debug(prefixLogText+"Departure Tug Used Hour" + "[" + 11 + "]");
				strObjVal = getDprTugUsedHour(ydChgNo, ydChgVerSeq, 11 + "");
				// hMap.put(strObjs[i].toString(), strDprTugUsedHour);
				break;
			case 13: // BeamFeet
				log.debug(prefixLogText+"Beam" + "[" + 13 + "]");
				strObjVal = getBeamFeet(repVvd);
				// hMap.put(strObjs[i].toString(), strBeamFeet);
				break;
			case 14: // BeamMeter
				log.debug(prefixLogText+"Beam" + "[" + 14 + "]");
				strObjVal = getBeamMeter(repVvd);
				// hMap.put(strObjs[i].toString(), strBeamMeter);
				break;
			case 15: // Berthing Hour
				log.debug(prefixLogText+"Berthing Hour" + "[" + 15 + "]");
				strObjVal = getBerthingHour(vvd, ydCd, clptIndSeq);
				// hMap.put(strObjs[i].toString(), strBerthingHour);
				break;
			case 166: //Berthing Date(D-B)
	    	   	//SELECT (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1 FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
	    	   	log.debug(prefixLogText+"Berthing Date(D-B)" + "[" +166+"]");
	    	   	strObjVal = getBerthingDate(vvd, ydCd, clptIndSeq);
	    	   	//hMap.put(strObjs[i].toString(), strBerthingDate);
	    	   	break;
			case 16: // Block Size
				log.debug(prefixLogText+"Block Size" + "[" + 16 + "]");
				strObjVal = getBlockSize(repVvd);
				// hMap.put(strObjs[i].toString(), strBlockSize);
				break;
			case 18:// Constant1
			case 19:// Constant2
			case 20:// Constant3
			case 21:// Constant4
			case 22:// Constant5
				log.debug(prefixLogText+"Constant" + "[" + objNos[i] + "]");
				strObjVal = "1";
				break;
			case 23:// Country of Last Port
				strObjVal = getCntLastPort(vvd, ydCd, clptIndSeq);
				if (strObjVal == null || strObjVal.equals(""))
					strObjVal = "''/*no found : Country of Last Port*/";
				log.debug(prefixLogText+"Country of Last Port[23] in [45]:=" + strObjVal);
				break;
			case 24:// Country of Next Port
	
				strObjVal = getCntNextPort(vvd, ydCd, clptIndSeq);
				if (strObjVal == null || strObjVal.equals(""))
					strObjVal = "''/*no found : Country of Next Port*/";
				log.debug(prefixLogText+"Country of Next Port[24] in [45]:=" + strObjVal);
				break;
			case 26: // Departure Draft Feet
				strObjVal = getDprDftFeet(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Departure Draft Feet in [45] " + "[" + 26 + "]:=" + strObjVal);
				break;
			case 27: // Garbage Volume
				strObjVal = getGarbageVol(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"arbage Volume[27] in [45]:=" + strObjVal);
				break;
			case 28:// GRT
			case 73:// GRT 1
			case 74:// GRT 2
				log.debug(prefixLogText+"> in RATE2 at GRT[28]");
				strObjVal = getVslGrt(repVvd);
				break;
			case 29:// NRT
				log.debug(prefixLogText+"> in RATE2 at NRT[29]");
				strObjVal = getVslNrt(repVvd);
				break;
			case 30: // LOAFEET
				log.debug(prefixLogText+"LOAFeet" + "[" + 31 + "]");
				strObjVal = getLoaFeet(repVvd);
				break;
			case 31: // LOAMETER
				log.debug(prefixLogText+"LOAMeter" + "[" + 30 + "]");
				strObjVal = getLoaMeter(repVvd);
				break;
			case 32:// Inbound Volume
				strObjVal = getInboundVolume(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Inbound Volume[32] in [45]:=" + strObjVal);
				break;
			case 33:// Outbound Volume
				strObjVal = getOutboundVolume(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Outbound Volume[33] in [45]:=" + strObjVal);
				break;
			case 34: // Lane
				log.debug(prefixLogText+"Lane" + "[" + 34 + "]");
				strObjVal = "'" + getLane(vvd) + "'";
				break;
			case 35: //
				strObjVal = getNalVsl(vvd);
				log.debug(prefixLogText+"Nationality of Vessel [35] in [45]:=" + strObjVal);
				break;
			case 36: // No. of Crew
				strObjVal = getNoOfCrew(repVvd);
				log.debug(prefixLogText+"No. of Crew in [45]" + "[" + 36 + "]:=" + strObjVal);
				break;
			case 37:// Anchoring Hour
				strObjVal = getAnchoringHour(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Anchoring Hour[37] in [45]:=" + strObjVal);
				break;
			case 38: // SCNT
				String strSCNT = calcTariffVO.getScnt();// map.get("SCNT");
				if (strSCNT == null || strSCNT.equals(""))
					strSCNT = getScnt(vvd);
				strObjVal = strSCNT;
				log.debug(prefixLogText+"SCNT in [45]" + "[" + 38 + "]:=" + strObjVal);
				break;
		   case 163: //SCGT
			    String strSCGT = calcTariffVO.getScgt();//map.get("SCGT");
			    if(strSCGT==null||strSCGT.equals(""))
			    	strSCGT = getScgt(vvd);
		   		strObjVal = strSCGT;
		   		log.debug(prefixLogText+"SCGT in [45]" + "[" +163+"]:="+strObjVal);
	    		//hMap.put(strObjs[i].toString(), strScgt);
		   		break;
			case 39:// Ship Unit
	
				log.debug(prefixLogText+"Ship Unit" + "[" + 39 + "]");
				strObjVal = getShipUnit(repVvd);
				break;
			case 40: // Sludge Volume
				log.debug(prefixLogText+"Sludge Volume" + "[" + 39 + "]");
				strObjVal = getSludgeVol(vvd, ydCd, clptIndSeq);
				break;
			case 41:// Vessel Visit
				log.debug(prefixLogText+"Vessel Call" + "[" + 41 + "]");
				strObjVal = "1";
				break;
			case 42:// Vessel Visit
				log.debug(prefixLogText+"Vessel Visit" + "[" + 42 + "]");
				strObjVal = "1";
				break;
			case 46:
	
				String strType = calcTariffVO.getCalcType();// map.get("CalcType");
				String strBase = calcTariffVO.getBase();// map.get("Base");
				if (strType.equals("S") || strType.equals("D")) {
					strObjVal = strBase;
				}
				log.debug(prefixLogText+"in [45] Base[46] :=" + strObjVal);
				break;
			case 47:// Arrival Draft Meter
				strObjVal = getArvDrftMeter(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Arrival Draft Meter in [45]" + "[" + 47 + "]:=" + strObjVal);
				break;
			case 48:// Arrival Draft 1 Meter
				strObjVal = getArvDrftOneMeter(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Arrival Draft1 Meter in [45]" + "[" + 48 + "]:=" + strObjVal);
				break;
			case 49:// Arrival Draft1 Feet
				strObjVal = getArvDrftOneFeet(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Arrival Draft1 Feet in [45]" + "[" + 49 + "]:=" + strObjVal);
				break;
			case 51:// Arrival POB
				strObjVal = getArrPob(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Arrival POB in [45]" + "[" + 51 + "]:=" + strObjVal);
				break;
			case 55:// Bound
				strObjVal = getBound(vvd, ydCd);
				log.debug(prefixLogText+"Bound in [45]" + "[" + 55 + "]:=" + strObjVal);
				break;
			case 56:// Bunker Volume
				strObjVal = getBkerVol(vvd);
				log.debug(prefixLogText+"Bunker Volume in [45]" + "[" + 56 + "]:=" + strObjVal);
				break;
			case 58:// Carrier
				strObjVal = getCarrier(repVvd);
				log.debug(prefixLogText+"in [45] Carrier [58] :=" + strObjVal);
				break;
			case 59:
	
				strObjVal = "'N'";
				break;
			case 61:// Departure POB
				strObjVal = getDepPob(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Departure POB in [45]" + "[" + 61 + "]:=" + strObjVal);
				break;
			case 63:// Design Capacity
				strObjVal = getDesignCapacity(repVvd);
				log.debug(prefixLogText+"Design Capacity in [45]" + "[" + 63 + " ]:=" + strObjVal);
				break;
			case 64:// DWT
				strObjVal = getDwt(vvd);
				log.debug(prefixLogText+"DWT in [45]" + "[" + 64 + " ]:=" + strObjVal);
				break;
			case 65:// ETB Date
				strObjVal = getEtbDate(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"In[45] ETB Date[65]:=" + strObjVal);
				break;
			case 66:// ETB Month
				strObjVal = getEtbMonth(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETB Month in [45]" + "[" + 66 + " ]:=" + strObjVal);
				break;
			case 67:// ETB Time
			case 68:// ETB1 Time
				strObjVal = getEtbTime(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETB Time in [45]" + "[" + 67 + " ]:=" + strObjVal);
				break;
			case 69:// ETD Date
				strObjVal = getEtdDate(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETD Date in [45]" + "[" + iObjListNo + " ]:=" + strObjVal);
				break;
			case 70:// ETD Month
				strObjVal = getEtdMonth(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETD Month in [45]" + "[" + iObjListNo + " ]:=" + strObjVal);
				break;
			case 71:// ETD Time
			case 72:// ETD1 Time
				strObjVal = getEtdTime(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETD Time in [45]" + "[" + iObjListNo + " ]:=" + strObjVal);
				break;
			case 76:// I/B Volume/Blocksize
	
				strObjVal = getIBVolBsz(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"I/B Volume/Blocksize in[45]" + "[" + 76 + " ]:=" + strObjVal);
				break;
			case 79:// last Issued Invoice ETD
	
				strObjVal = getLastInvEtd(vvd, ydCd, clptIndSeq, lgsCostCd);
				log.debug(prefixLogText+"last Issued Invoice ETD[79] in [45]:=" + strObjVal);
				break;
			case 80:// LastPort
				strObjVal = getLastPort(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Last Port [80] in [45]:=" + strObjVal);
				break;
			case 81:// LOA 1
			case 82:// LOA 2
			case 83:// LOA 3
				log.debug(prefixLogText+"getLoa" + "[" + objNos[i] + "]");
				strObjVal = getLoa(repVvd);
				break;
			case 85:// Next Port
	
				strObjVal = getNextPort(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"In [45] Next Port[85]:=" + strObjVal);
				break;
			case 87:// NRT1
				strObjVal = getNrtOne(repVvd);
				log.debug(prefixLogText+"[45]>>NRT1[87] :=" + strObjVal);
				break;
			case 88:// O/B Volume/Blocksize
	
				strObjVal = getOBVolBsz(vvd, ydCd);
				log.debug(prefixLogText+"I/B Volume/Blocksize in[45]" + "[" + 88 + " ]:=" + strObjVal);
				break;
			case 90:// Pilot Off
				strObjVal = "'" + getPOff(vvd, ydCd, clptIndSeq) + "'";
				log.debug(prefixLogText+"Pilot Off in[45]" + "[" + 90 + " ]:=" + strObjVal);
				break;
			case 91:// POB
	
				strObjVal = "'" + getPob(vvd, ydCd, clptIndSeq) + "'";
				log.debug(prefixLogText+"POB in[45]" + "[" + 91 + " ]:=" + strObjVal);
				break;
			case 92:// Rehandling Volume
				strObjVal = getRhVol(vvd, ydCd, clptIndSeq);
				log.debug("Rehandling Volume in[45]" + "[" + 92 + " ]:=" + strObjVal);
				break;
			case 93:// Remain Vessel Call
	
				strObjVal = getRemainVesselCall(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"[45]>>Remain Vessel Call" + "[93] :=" + strObjVal);
				break;
			case 94:// Monthly Vessel Call
				strObjVal = getMonthlyVesselCall(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"[45]>>Monthly Vessel Call" + "[" + 94 + "] :=" + strObjVal);
				break;
			case 95:// sameVvd
				log.debug(prefixLogText+"sameVvd" + "[" + 95 + "]");
				strObjVal = getSameVvd(vvd, ydCd);
				break;
			case 96:// Yearly Vessel Call
				strObjVal = getYearlyVesselCall(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45]>>>Yearly Vessel Call" + "[" + 96 + "] :=" + strObjVal);
				break;
			case 98: // SCNT1
				log.debug(prefixLogText+"SCNT1" + "[" + 98 + "]");
				String strSCNT1 = calcTariffVO.getScntOne();// map.get("SCNT1");
				if (strSCNT1 == null || strSCNT1.equals(""))
					strSCNT1 = getScnt(vvd);
				strObjVal = strSCNT1;
				break;
			case 99:// ShipUnitOne
				strObjVal = getShipUnitOne(repVvd);
				log.debug(prefixLogText+"ShipUnit1[99] in [45]:=" + strObjVal);
				break;
			case 100:// Summer Draft(F)
				strObjVal = getSmmrDftF(repVvd);
				log.debug(prefixLogText+"Summer Draft(F)[100] in [45]:=" + strObjVal);
				break;
			case 101:// Summer Draft(M)
				strObjVal = getSmmrDftM(repVvd);
				log.debug(prefixLogText+"Summer Draft(M)[101] in [45]:=" + strObjVal);
				break;
			case 112:// Water Volume
	
				strObjVal = getWatVol(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Water Volume[112] in [45]:=" + strObjVal);
				break;
			case 114:// SDR
				log.debug(prefixLogText+"SDR" + "[" + 114 + "]");
				String strSdr = calcTariffVO.getSDR();// map.get("SDR");
				if (strSdr == null || strSdr.equals(""))
					strSdr = getSdr();
				strObjVal = strSdr;
				break;
			case 115:// Tier
				String strTier;
				//if ("Y".equals(calcTariffVO.getEstFlg())) {
					strTier = getTier(vvd, ydCd);
				//} else {
				//	strTier = calcTariffVO.getTier();// map.get("Tier");
				//}
				if (strTier != null) {
					strObjVal = strTier;
				}
				log.debug(prefixLogText+"in [45] Tier [115]:=" + strObjVal);
				break;
			case 116:// Limit Time
				String strLimitTime;
				if ("Y".equals(calcTariffVO.getEstFlg())) {
					strLimitTime = getLimitTime(vvd, ydCd);
				} else {
					strLimitTime = calcTariffVO.getLimitTm();// map.get("LimitTime");
				}
				if (strLimitTime != null) {
					strObjVal = strLimitTime;
				}
				log.debug(prefixLogText+"in [45] Limit Time [116]:=" + strObjVal);
				break;
			case 117:// Surcharge Amount
	
				strType = calcTariffVO.getCalcType();// map.get("CalcType");
				String strSurcharge = calcTariffVO.getSurcharge();// map.get("Surcharge");
				if (strType.equals("D"))
					strObjVal = strSurcharge;
				log.debug(prefixLogText+"Surcharge Amount [117] in [45] :=" + strObjVal);
				break;
			case 118: // Block Size1
				log.debug(prefixLogText+"Block Size1" + "[" + 118 + "]");
				strObjVal = getBlockSize(repVvd);
				break;
			case 120:// DEM/DET Holiday(ETB)
				strObjVal = getDemdetHolidayETB(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] DEM/DET Holiday(ETB) [120]:=" + strObjVal);
				break;
			case 121:// DEM/DET Holiday(ETD)
				strObjVal = getDemdetHolidayETD(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] DEM/DET Holiday(ETD) [121]:=" + strObjVal);
				break;
			case 122:// Ownership
				strObjVal = getOwnrship(vvd);
				log.debug(prefixLogText+"in[45] Ownership [122]:=" + strObjVal);
				break;
			case 123:// ETB(H)
				strObjVal = getEtbHr(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] ETB(H) [123]:=" + strObjVal);
				break;
			case 124:// ETD(H)	
				strObjVal = getEtdHr(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] ETD(H) [124]:=" + strObjVal);
				break;
			case 126:// I/B (TON)	
				strObjVal = getInboundTon(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] I/B (TON) [126]:=" + strObjVal);
				break;
			case 127:// O/B (TON)	
				strObjVal = getOutboundTon(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] O/B (TON) [127]:=" + strObjVal);
				break;
			case 128:// RH (TON)
				strObjVal = getRhTon(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] RH (TON) [128]:=" + strObjVal);
				break;
			case 129:// ETA (H)
				strObjVal = getEtaHour(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] ETA (H) [129]:=" + strObjVal);
				break;
			case 130:// Cargo Volume(Ton)
				strObjVal = getCargoVolumeTon(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] Cargo Volume(Ton) [130]:=" + strObjVal);
				break;
			case 131:// Vessel Volume(FR)
	 	    case 164://Vessel Volume(FR)1
	 	    case 165://Vessel Volume(FR)2
				strObjVal = getVesselVolumeFr(vvd);
				log.debug(prefixLogText+"in[45] Vessel Volume(FR) [131]:=" + strObjVal);
				break;
			case 132:// Loaded TEU At Last Port
				strObjVal = getstrLoadedTeuLastPort(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] Loaded TEU at Last Port [132] :=" + strObjVal);
				break;
			case 133:// Yearly Vessel Call Lane
				strObjVal = getYearlyVesselCallLane(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45]>>>Yearly Vessel Call Lane" + "[" + 133 + "] :=" + strObjVal);
				break;
			case 134:// vessel volume(CI)
				strObjVal = getVesselVolumeCi(vvd, ydCd);
				log.debug(prefixLogText+"in[45]>>>Vessel Volume Ci" + "[" + 134 + "] :=" + strObjVal);
				break;
			case 135:// LOA * Beam
				strObjVal = getLoaBeam(vvd);
				log.debug(prefixLogText+"in[45]>>>LOA*BM" + "[" + 135 + "] :=" + strObjVal);
				break;
			case 136:// ETB DAY
				strObjVal = getEtbDay(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"In[45] ETB Day [136]:=" + strObjVal);
				break;
			case 137:// ETD DAY
				strObjVal = getEtdDay(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"In[45] ETD Day [137]:=" + strObjVal);
				break;
			case 138:// SUN
				strObjVal = "'SUN'";
				log.debug(prefixLogText+"In[45] SUN [138]:=" + strObjVal);
				break;
			case 139:// MON
				strObjVal = "'MON'";
				log.debug(prefixLogText+"In[45] MON [139]:=" + strObjVal);
				break;
			case 140:// TUE
				strObjVal = "'TUE'";
				log.debug(prefixLogText+"In[45] TUE [140]:=" + strObjVal);
				break;
			case 141:// WED
				strObjVal = "'WED'";
				log.debug(prefixLogText+"In[45] WED [141]:=" + strObjVal);
				break;
			case 142:// THU
				strObjVal = "'THU'";
				log.debug(prefixLogText+"In[45] THU [142]:=" + strObjVal);
				break;
			case 143:// FRI
				strObjVal = "'FRI'";
				log.debug(prefixLogText+"In[45] FRI [143]:=" + strObjVal);
				break;
			case 144:// SAT
				strObjVal = "'SAT'";
				log.debug(prefixLogText+"In[45] SAT [144]:=" + strObjVal);
				break;
			case 146:// Loaded TEU At Last Port 1
				strObjVal = getstrLoadedTeuLastPort1(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"in[45] Loaded TEU at Last Port [146] :=" + strObjVal);
				break;
	
			case 147:// DEM/DET Holiday ETB (except Day)
				strObjVal = searchDemdetHolidayETBExceptDay(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"DEM/DET Holiday ETB(except Day) [147] :=" + strObjVal);
				break;
			case 148:// DEM/DET Holiday ETD (except Day)
				strObjVal = searchDemdetHolidayETDExceptDay(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"DEM/DET Holiday ETD(except Day) [148] :=" + strObjVal);
				break;
	
			case 149:// ETA Time
			case 150:// ETA1 Time
				strObjVal = getEtaTime(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETA Time" + "[" + objNos[i] + " ]:=" + strObjVal);
				break;
	
			case 151: // NRT2
				strObjVal = getNrtOne(repVvd); // same NRT1
				log.debug(prefixLogText+"NRT2" + "[" + objNos[i] + "]:=" + strObjVal);
				break;
	
			case 152:// DEM/DET Holiday(ETD)	
				strObjVal = getDemdetHolidayETA(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"DEM/DET Holiday(ETA) [152] :=" + strObjVal);
				break;
	
			case 153:// DEM/DET Holiday ETD (except Day)
				strObjVal = searchDemdetHolidayETAExceptDay(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"DEM/DET Holiday ETA(except Day) [153] :=" + strObjVal);
				break;
	
			case 154: // Duration
				strObjVal = getDuration(vvd);
				log.debug(prefixLogText+"Duration [154] :=" + strObjVal);
				break;
	
			case 155: // Previous Port(TW)
				strObjVal = getPreviousTaiwanPort(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Previous Port(TW) [155] :=" + strObjVal);
				break;
				
			case 156: // Yearly Vessel Call Port
				strObjVal = getYearlyVesselCallPort(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Yearly Vessel Call Port [156] :=" + strObjVal);
				break;
				
			case 157: // ETA Date
				strObjVal = getEtaDate(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETA Date [157] :=" + strObjVal);
				break;
				
			case 158: // Berthing Hour(D-A)
				strObjVal = getBerthingHourDA(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Berthing Hour(D-A) [158] :=" + strObjVal);
				break;
				
			case 159://ETA DAY
				strObjVal = getEtaDay(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETA Day [159] :="+strObjVal);
				break;
				
			case 160://ETA Month
				strObjVal = getEtaMonth(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"ETA Month [160] :="+strObjVal);
				break;
				
			case 161://Inbound Volume(Ton) / Vessel Volume(FR)
				strObjVal = getInboundDivideVessel(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Inbound Volume(Ton) / Vessel Volume(FR) [161] :="+strObjVal);
				break;
				
			case 162://Outbound Volume(Ton) / Vessel Volume(FR)
				strObjVal = getOutboundDivideVessel(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+"Outbound Volume(Ton) / Vessel Volume(FR) [162] :="+strObjVal);
				break;
			/*case 167: //ESIscore
				String strESIScore  = calcTariffVO.getESIScore();//map.get("ESIScore");
				if(strESIScore==null||strESIScore.equals(""))
					strESIScore = getESIScore(vvd);
				strObjVal = strESIScore;
				log.debug(prefixLogText+"ESIscore in [45]" + "[" +167+"]:="+strObjVal);
				//hMap.put(strObjs[i].toString(), strESIScore);
				break;	
			case 168://B/T Power(BHP) - Bow Thurust Power
				strObjVal = getBowThurustPowerBHP(vvd);
				log.debug(prefixLogText+"B/T Power(BHP)[168] :="+strObjVal);
				break;		
			case 169://B/T Power(KW)  - Bow Thurust Power
				strObjVal = getBowThurustPowerKW(vvd);
				log.debug(prefixLogText+"B/T Power(KW)[169] :="+strObjVal);
				break;*/
				
			//2016.11.02 Add Object	
			case 174: //Last Yard
				strObjVal = getLastYard(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+" Last Yard [" + objNos[i] +"]:=[" + strObjVal+"]");
				break;
			case 175: //Current Yard (인자로 넘어온 데이터 재사용)
				strObjVal = getCurrentYard(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+" Current Yard [" + objNos[i] +"]:=[" + strObjVal+"]");
				break;
			case 176: //Next Yard
				strObjVal = getNextYard(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+" Next Yard [" + objNos[i] +"]:=[" + strObjVal+"]");
				break;
			case 177: //Double Call
				strObjVal = getDoubleCall(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+" Double Call [" + objNos[i] +"]:=[" + strObjVal+"]");
				break;
			case 178: //Port Seq : Current terminal Port Seq(인자로 넘어온 데이터 재사용 :CLPT_IND_SEQ)
				strObjVal = getPortSeq(vvd, ydCd, clptIndSeq);
				log.debug(prefixLogText+" Port Seq [" + objNos[i] +"]:=[" + strObjVal+"]");
				break;				
	
			default:
				break;
		}

		// Manually Input --->>>>
		String curObjVal = "";

		switch (iObjListNo) {
			case 6:
				curObjVal = calcTariffVO.getArrNT();// map.get("[6]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Arr.NT[6]:=[" + curObjVal + "]");
					}
				}
				break;
			case 7:
				curObjVal = calcTariffVO.getDepNT();// map.get("[7]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Dep.NT[7]:=[" + curObjVal + "]");
					}
				}
				break;
			case 8:
				curObjVal = calcTariffVO.getArrTP();// map.get("[8]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Arr.TP[8]:=[" + curObjVal + "]");
					}
				}
				break;
			case 9:
				curObjVal = calcTariffVO.getDepTP();// map.get("[9]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Dep.TP[9]:=[" + curObjVal + "]");
					}
				}
				break;
			case 10:
				curObjVal = calcTariffVO.getArrTUH();// map.get("[10]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Arr.TUH[10]:=[" + curObjVal + "]");
					}
				}
				break;
			case 11:
				curObjVal = calcTariffVO.getDepTUH();// map.get("[11]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Dep.TUH[11]:=[" + curObjVal + "]");
					}
				}
				break;
			case 17:
				curObjVal = calcTariffVO.getBoat();// map.get("[17]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Boat[17]:=[" + curObjVal + "]");
					}
				}
				break;
			case 50:
				curObjVal = calcTariffVO.getArrLH();// map.get("[50]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Arr.LH[50]:=[" + curObjVal + "]");
					}
				}
				break;
			case 52:
				curObjVal = calcTariffVO.getBarge();// map.get("[52]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Barge[52]:=[" + curObjVal + "]");
					}
				}
				break;
			case 57:
				curObjVal = calcTariffVO.getBuoy();// map.get("[57]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Buoy[57]:=[" + curObjVal + "]");
					}
				}
				break;
			case 60:
				curObjVal = calcTariffVO.getDepLH();// map.get("[60]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Dep.LH[60]:=[" + curObjVal + "]");
					}
				}
				break;
			case 75:
				curObjVal = calcTariffVO.getHoliday();// map.get("[75]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Holiday[75]:=[" + curObjVal + "]");
					}
				}
				break;
			case 78:
				curObjVal = calcTariffVO.getInspection();// map.get("[78]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Inspection[78]:=[" + curObjVal + "]");
					}
				}
				break;
			case 86:
				curObjVal = calcTariffVO.getNight();// map.get("[86]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Night[86]:=[" + curObjVal + "]");
					}
				}
				break;
			case 97:
				curObjVal = calcTariffVO.getSanit();// map.get("[97]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Sanitation[97]:=[" + curObjVal + "]");
					}
				}
				break;
			case 110:
				curObjVal = calcTariffVO.getTUGRope();// map.get("[110]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  TugRope[110]:=[" + curObjVal + "]");
					}
				}
				break;
			case 111:
				curObjVal = calcTariffVO.getUsdhrs();// map.get("[110]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  TugRope[110]:=[" + curObjVal + "]");
					}
				}
				break;
			case 119:
				curObjVal = calcTariffVO.getNewservice();// map.get("[119]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  NewService[119]:=[" + curObjVal + "]");
					}
				}
				break;
			case 125:
				curObjVal = calcTariffVO.getCopilot();// map.get("[125]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Co-Pilot[125]:=[" + curObjVal + "]");
					}
				}
				break;
			case 114://sdr
				curObjVal = calcTariffVO.getSDR();// map.get("[114]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  SDR[114]:=[" + curObjVal + "]");
					}
				}
				break;
			/*case 115://tier
				curObjVal = calcTariffVO.getTier();// map.get("[115]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Tier[115]:=[" + curObjVal + "]");
					}
				}
				break;*/
			case 116://limit time
				curObjVal = calcTariffVO.getLimitTm();// map.get("[116]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Limit Time[116]:=[" + curObjVal + "]");
					}
				}
				break;
			case 170://others
				curObjVal = calcTariffVO.getOthers();// map.get("[170]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  Others[170]:=[" + curObjVal + "]");
					}
				}
				break;
			case 171://other value
				curObjVal = calcTariffVO.getOtherValue();// map.get("[171]");
				if (curObjVal != null) {
					if (!curObjVal.equals("")) {
						strObjVal = curObjVal;
						log.debug(prefixLogText+"In [45] Manually Input  OtherValue[171]:=[" + curObjVal + "]");
					}
				}
				break;
			default:
				break;
		}
		// Manually Input <---<<<

		if (strObjVal == null || strObjVal.equals("") || strObjVal.equals("0")) {
			log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Replace Default Value[0,Y/N] Start================================");
			String tmpStrObjVal = strObjVal; //2016.03.18 기존에 구한 value를 임시로 저장한다.
			String tmpObjNoKey = iObjListNo + "";
			
			strObjVal = getRegularValue(ydChgNo, ydChgVerSeq, tmpObjNoKey);
			log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> getRegularValue ["+tmpObjNoKey+"] := ["+strObjVal+"] E n d.");
			
			//2016.03.18 Default 0을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(0) 를 셋팅한다.
			HashMap<String, String> dftZeroAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_ZERO_ALLOW_OBJECT_NO);
			if(dftZeroAllowMap.containsKey(tmpObjNoKey)){				
				log.debug(prefixLogText+"[Zero & Flag]Null Value  >> Before Default Zero Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
				
				if(StringUtils.isEmpty(strObjVal)){
					if(StringUtils.isEmpty(tmpStrObjVal)){
						strObjVal = "0";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
					}else{
						strObjVal = tmpStrObjVal;
					}
				}
				log.debug(prefixLogText+"[Zero & Flag]Null Value >> After Default Zero Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
			}
			
			//2016.04.14 Default N Flag을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(N) 를 셋팅한다.
			HashMap<String, String> dftFlagAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_FLAG_ALLOW_OBJECT_NO);
			if(dftFlagAllowMap.containsKey(tmpObjNoKey)){				
				log.debug(prefixLogText+"[Zero & Flag]Null Value >> Before Default Flag Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
				
				if(StringUtils.isEmpty(strObjVal)){
					if(StringUtils.isEmpty(tmpStrObjVal)){
						strObjVal = "'N'";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
					}else{
						strObjVal = tmpStrObjVal;
					}
				}
				log.debug(prefixLogText+"[Zero & Flag]Null Value >> After Default Flag Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
			}			
			
			log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Regular Value [" + tmpObjNoKey + "]:=[" + strObjVal +"]");
			log.debug(prefixLogText+"[Zero & Flag]Null & Zero Value >> Replace Default Value[0,Y/N] E n d================================");
		}
		
		log.debug("\n============================================================================"+
				  "\n getObjectValue LastValue ["+strObjVal+"] E N D."+
				  "\n============================================================================");

		return strObjVal;
	}

	/**
	 * 63://Design Capacity
	 * 
	 * @category Obj63_DesigCapacity
	 * @param String
	 *            vvd
	 * @return String
	 * @throws EventException
	 */
	private String getDesignCapacity(String vvd) throws EventException {
		try {
			return dbDao.getDesignCapacity(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj63_DesigCapacity" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj63_DesigCapacity" }).getMessage(), ex);
		}
	}

	/**
	 * case 36: //No. of Crew
	 * 
	 * @category Obj36_NoOfCrew
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getNoOfCrew(String vvd) throws EventException {
		try {
			return dbDao.getNoOfCrew(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj36_NoOfCrew" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj36_NoOfCrew" }).getMessage(), ex);
		}
	}

	/**
	 * case 26: //Departure Draft Feet
	 * 
	 * @category Obj26_DepartureDraftFeet
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDprDftFeet(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDprDftFeet(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj26_DepartureDraftFeet" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj26_DepartureDraftFeet" }).getMessage(), ex);
		}
	}

	/**
	 * case 27: //Garbage Volume
	 * 
	 * @category Obj27_GarbageVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getGarbageVol(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getGarbageVol(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj27_GarbageVol" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj27_GarbageVol" }).getMessage(), ex);
		}
	}

	/**
	 * case 40: //Sludge Volume
	 * 
	 * @category Obj40_SludgeVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getSludgeVol(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getSludgeVol(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj40_SludgeVol" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj40_SludgeVol" }).getMessage(), ex);
		}
	}

	/**
	 * case 61: //Departure POB
	 * 
	 * @category Obj61_DepPob
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDepPob(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDepPob(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj61_DepPob" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj61_DepPob" }).getMessage(), ex);
		}
	}

	/**
	 * case 58://Carrier
	 * 
	 * @category Obj58_Carrier
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getCarrier(String vvd) throws EventException {
		try {
			return dbDao.getCarrier(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj58_Carrier" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj58_Carrier" }).getMessage(), ex);
		}
	}

	/**
	 * case 55://Bound
	 * 
	 * @category Obj55_Bound
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getBound(String vvd, String ydCd) throws EventException {
		try {
			return dbDao.getBound(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj55_Bound" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj55_Bound" }).getMessage(), ex);
		}
	}

	/**
	 * case 56://Bunker Volume
	 * 
	 * @category Obj56_BkerVol
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getBkerVol(String vvd) throws EventException {
		try {
			return dbDao.getBkerVol(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj56_BkerVol" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj56_BkerVol" }).getMessage(), ex);
		}
	}

	/**
	 * case 64://DWT
	 * 
	 * @category Obj64_Dwt
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getDwt(String vvd) throws EventException {
		try {
			return dbDao.getDwt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj64_Dwt" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj64_Dwt" }).getMessage(), ex);
		}
	}

	/**
	 * case 51: //Arrival POB
	 * 
	 * @category Obj51_ArrPob
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getArrPob(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getArrPob(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj51_ArrPob" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj51_ArrPob" }).getMessage(), ex);
		}
	}

	/**
	 * case 49://Arrival Draft1 Feet
	 * 
	 * @category Obj49_ArrivalDraft1Feet
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftOneFeet(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getArvDrftOneFeet(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj49_ArrivalDraft1Feet" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj49_ArrivalDraft1Feet" }).getMessage(), ex);
		}
	}

	/**
	 * case 48://Arrival Draft 1 Meter
	 * 
	 * @category Obj48_ArrivalDraft1Meter
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftOneMeter(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getArvDrftOneMeter(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj48_ArrivalDraft1Meter" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj48_ArrivalDraft1Meter" }).getMessage(), ex);
		}
	}

	/**
	 * case 47://Arrival Draft Meter
	 * 
	 * @category Obj47_ArrivalDraftMeter
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftMeter(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getArvDrftMeter(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj47_ArrivalDraftMeter" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj47_ArrivalDraftMeter" }).getMessage(), ex);
		}
	}

	/**
	 * case 96://Yearly Vessel Call
	 * 
	 * @category Obj96_YearlyVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCall(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getYearlyVesselCall(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj96_YearlyVesselCall" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj96_YearlyVesselCall" }).getMessage(), ex);
		}
	}

	/**
	 * case 133://Yearly Vessel Call Lane
	 * 
	 * @category Obj133_YearlyVesselCallLane
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCallLane(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getYearlyVesselCallLane(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj133_YearlyVesselCallLane" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj133_YearlyVesselCallLane" }).getMessage(), ex);
		}
	}

	/**
	 * case 94://Monthly Vessel Call
	 * 
	 * @category Obj94_MonthlyVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getMonthlyVesselCall(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getMonthlyVesselCall(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj94_MonthlyVesselCall" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj94_MonthlyVesselCall" }).getMessage(), ex);
		}
	}

	/**
	 * case 87://NRT1 case 151://NRT2
	 * 
	 * @category Obj87_NRT1
	 * @category Obj151_NRT2
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getNrtOne(String vvd) throws EventException {
		try {
			return dbDao.getNrtOne(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj87_NRT1/Obj151_NRT2" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj87_NRT1/Obj151_NRT2" }).getMessage(), ex);
		}
	}

	/**
	 * case 81:// LOA 1 case 82:// LOA 2 case 83:// LOA 3
	 * 
	 * @category Obj8123_LOA
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoa(String vvd) throws EventException {
		try {
			return dbDao.getLoa(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj8123_LOA" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj8123_LOA" }).getMessage(), ex);
		}
	}

	/**
	 * 114://SDR //Check SDR set by external
	 * 
	 * @category Obj114_SDR
	 * @return String
	 * @throws EventException
	 */
	private String getSdr() throws EventException {
		try {
			return dbDao.getSdr();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj114_SDR" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj114_SDR" }).getMessage(), ex);
		}
	}

	/**
	 * 99://ShipUnitOne
	 * 
	 * @category Obj99_ShipUnit1
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getShipUnitOne(String vvd) throws EventException {
		try {
			return dbDao.getShipUnitOne(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj99_ShipUnit1" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj99_ShipUnit1" }).getMessage(), ex);
		}
	}

	/**
	 * 100://Summer Draft(F)
	 * 
	 * @category Obj100_SmmrDftF
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getSmmrDftF(String vvd) throws EventException {
		try {
			return dbDao.getSmmrDftF(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj100_SmmrDftF" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj100_SmmrDftF" }).getMessage(), ex);
		}
	}

	/**
	 * 101://Summer Draft(M)
	 * 
	 * @category Obj101_SmmrDftM
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getSmmrDftM(String vvd) throws EventException {
		try {
			return dbDao.getSmmrDftM(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj101_SmmrDftM" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj101_SmmrDftM" }).getMessage(), ex);
		}
	}

	/**
	 * 39:// Ship Unit
	 * 
	 * @category Obj39_ShitUnit
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getShipUnit(String vvd) throws EventException {
		try {
			return dbDao.getShipUnit(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj39_ShitUnit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj39_ShitUnit" }).getMessage(), ex);
		}
	}

	/**
	 * //sameVvd
	 * 
	 * @category Obj95_sameVvd
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getSameVvd(String vvd, String ydCd) throws EventException {
		try {
			return dbDao.getSameVvd(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj95_sameVvd" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj95_sameVvd" }).getMessage(), ex);
		}
	}

	/**
	 * Next Port
	 * 
	 * @category Obj85_NextPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getNextPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getNextPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj85_NextPort" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj85_NextPort" }).getMessage(), ex);
		}
	}

	/**
	 * case 80://LastPort
	 * 
	 * @category Obj80_LastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getLastPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getLastPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj80_LastPort" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj80_LastPort" }).getMessage(), ex);
		}
	}

	/**
	 * 15: //Berthing Hour
	 * 
	 * @category Obj15_BerthingHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getBerthingHour(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getBerthingHour(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj15_BerthingHour" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj15_BerthingHour" }).getMessage(), ex);
		}
	}
	
	/**
	 * 166: //Berthing Date
	 * //SELECT (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1 FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
	 * @category Obj166_BerthingDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getBerthingDate(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getBerthingDate(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj166_BerthingDate"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj166_BerthingDate"}).getMessage(),ex);
		}
	}

	/**
	 * case 3: //Departure Draft Meter
	 * 
	 * @category Obj3_DepartuerDraftMeter
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDprDftMeter(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDprDrftMeter(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj3_DepartuerDraftMeter" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj3_DepartuerDraftMeter" }).getMessage(), ex);
		}
	}

	/**
	 * 2: //Arrival Draft
	 * 
	 * @category Obj2_ArrivalDraftFeet
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftFeet(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getArvDrftFeet(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj2_ArrivalDraft" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj2_ArrivalDraft" }).getMessage(), ex);
		}
	}

	/**
	 * 14: //BeamFeet
	 * 
	 * @category Obj14_BeamFeet
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getBeamFeet(String vvd) throws EventException {
		try {
			return dbDao.getBeamFeet(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj14_BeamFeet" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj14_BeamFeet" }).getMessage(), ex);
		}
	}

	/**
	 * 13: //BeamMeter
	 * 
	 * @category Obj13_BeamMeter
	 * @param String vvd
	 * @return String
	 */
	private String getBeamMeter(String vvd) throws EventException {
		try {
			return dbDao.getBeamMeter(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj13_BeamMeter" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj13_BeamMeter" }).getMessage(), ex);
		}
	}

	/**
	 * 11: //Departure Tug Used Hour
	 * 
	 * @category Obj11_DepartureTugUsedHour
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getDprTugUsedHour(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getDprTugUsedHour(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj11_DepartureTugUsedHour" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj11_DepartureTugUsedHour" }).getMessage(), ex);
		}
	}

	/**
	 * 10: //Arrival Tug Used Hour
	 * 
	 * @category Obj10_ArrivalTugUsedHour
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getArvTugUsedHour(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getArvTugUsedHour(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj10_ArrivalTugUsedHour" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj10_ArrivalTugUsedHour" }).getMessage(), ex);
		}
	}

	/**
	 * 9: //Departure Tug Power
	 * 
	 * @category Obj9_DepartureTugPower
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getDprTugPwr(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getDprTugPwr(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj9_DepartureTugPower" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj9_DepartureTugPower" }).getMessage(), ex);
		}
	}

	/**
	 * 8: //Arrival Tug Power
	 * 
	 * @category Obj8_ArrivalTugPower
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getArvTugPwr(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getArvTugPwr(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj8_ArrivalTugPower" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj8_ArrivalTugPower" }).getMessage(), ex);
		}
	}

	/**
	 * 7: //Departure No. of Tug
	 * 
	 * @category Obj7_DepartureNoofTug
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDprNoOfTug(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getDprNoOfTug(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj7_DepartureNoofTug" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj7_DepartureNoofTug" }).getMessage(), ex);
		}
	}

	/**
	 * 6: //Arrival No. of Tug
	 * 
	 * @category Obj6_ArrivalNoofTug
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getArvNoOfTug(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getArvNoOfTug(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj6_ArrivalNoofTug" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj6_ArrivalNoofTug" }).getMessage(), ex);
		}
	}

	/**
	 * Departure No. of Tractor
	 * 
	 * @category Obj5_DepartureNoofTractor
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getDprNoOfTrk(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getDprNoOfTrk(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj5_DepartureNoofTractor" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj5_DepartureNoofTractor" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj4_ArrivalNoofTractor
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getArvNoOfTrk(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getArvNoOfTrk(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj4_ArrivalNoofTractor" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj4_ArrivalNoofTractor" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj1_AllwTeu
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getAllwTeu(String vvd) throws EventException {
		try {
			return dbDao.getAllwTeu(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj1_AllwTeu" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj1_AllwTeu" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj16_BlockSize
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getBlockSize(String vvd) throws EventException {
		try {
			return dbDao.getBlockSize(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj16_BlockSize" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj16_BlockSize" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj38_SCNT
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getScnt(String vvd) throws EventException {
		try {
			return dbDao.getScnt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj38_SCNT" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj38_SCNT" }).getMessage(), ex);
		}
	}
	
	/**
	 * SELECT SUZ_GT_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj163_SCGT
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getScgt(String vvd) throws EventException{
		try {
			return  dbDao.getScgt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj163_SCGT"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj163_SCGT"}).getMessage(),ex);
		}
	}
	
	/**
	 * SELECT BWTHST_BHP_PWR FROM MDM_VSL_CNTR WHERE VSL_CD = 'HDDH'
	 * Towage 비용 tariff에서 Bow Thrust Power에 사용 TUG 수량이 달라짐에 따라 해당 신규 Object가 필요하오니 신규 생성 바랍니다.
	 * @category Obj168_BowThurustBHP
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	/*private String getBowThurustPowerBHP(String vvd) throws EventException{
		try {
			return  dbDao.getBowThurustPowerBHP(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj168_BowThurustBHP"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj168_BowThurustBHP"}).getMessage(),ex);
		}
	}*/
	/**
	 * SELECT BWTHST_BHP_PWR FROM MDM_VSL_CNTR WHERE VSL_CD = 'HDDH' 
	 * Towage 비용 tariff에서 Bow Thrust Power에 사용 TUG 수량이 달라짐에 따라 해당 신규 Object가 필요하오니 신규 생성 바랍니다.
	 * @category Obj169_BowThurustKW
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	/*private String getBowThurustPowerKW(String vvd) throws EventException{
		try {
			return  dbDao.getBowThurustPowerKW(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj169_BowThurustKW"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj169_BowThurustKW"}).getMessage(),ex);
		}
	}*/
	/**
	 *SELECT SHP_IDX_SCRE FROM VSK_VSL_ADD_SPEC WHERE VSL_CD = 'HJRJ' 
	 * @category Obj167_ESIScore
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	/*@SuppressWarnings("unused")
	private String getESIScore(String vvd) throws EventException{
		try {
			return  dbDao.getESIScore(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj167_ESIScore"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj167_ESIScore"}).getMessage(),ex);
		}
	}*/

	/**
	 * @category Obj34_Lane
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLane(String vvd) throws EventException {
		try {
			return dbDao.getLane(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj34_Lane" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj34_Lane" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj35_NalVsl
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getNalVsl(String vvd) throws EventException {
		try {
			return dbDao.getNalVsl(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj35_NalVsl" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj35_NalVsl" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj31_LoaFeet
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoaFeet(String vvd) throws EventException {
		try {
			return dbDao.getLoaFeet(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj31_LoaFeet" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj31_LoaFeet" }).getMessage(), ex);
		}
	}

	/**
	 * @category Obj30_LoaMeter
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoaMeter(String vvd) throws EventException {
		try {
			return dbDao.getLoaMeter(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj30_LoaMeter" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj30_LoaMeter" }).getMessage(), ex);
		}
	}

	/**
	 * Get Tariff chosen is which ObjectListNo
	 * 
	 * @param String tariffNo
	 * @return String
	 * @throws EventException
	 */
	private String getObjListNo(String tariffNo) throws EventException {
		try {
			return dbDao.getObjListNo(tariffNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getObjListNo" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getObjListNo" }).getMessage(), ex);
		}
	}

	/**
	 * Get Rate applicable
	 * 
	 * @param String tariffNo
	 * @param String prvObjVal
	 * @param String flag
	 * @return String
	 * @throws EventException
	 */
	private String getTrfRtAmt(String tariffNo, String prvObjVal, String flag) throws EventException {
		try {
			return dbDao.getTrfRtAmt(tariffNo, prvObjVal, flag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getTrfRtAmt" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getTrfRtAmt" }).getMessage(), ex);
		}
	}

	/**
	 * Get Tariff applicalbe on PSO_TARIFF table
	 * 
	 * @param String tariffNo
	 * @return String
	 * @throws EventException
	 */
	private String getPsoTrfTpCd(String tariffNo) throws EventException {
		try {
			return dbDao.getPsoTrfTpCd(tariffNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getPsoTrfTpCd" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : getPsoTrfTpCd" }).getMessage(), ex);
		}
	}

	/**
	 * Select GRT value on DB by having VVD given
	 * 
	 * @category Obj28_VslGrt
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getVslGrt(String vvd) throws EventException {
		try {
			return dbDao.getVslGrt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj28_VslGrt" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj28_VslGrt" }).getMessage(), ex);
		}
	}

	/**
	 * Select NRT value on DB by having VVD given
	 * 
	 * @category Obj29_VslNrt
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getVslNrt(String vvd) throws EventException {
		try {
			return dbDao.getVslNrt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj29_VslNrt" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj29_VslNrt" }).getMessage(), ex);
		}
	}

	/**
	 * Handling actual Invoice creationg in case of clicking Requested Advance
	 * Payment Confirm Button
	 * 
	 * @category VOP_PSO_0018_confirm_click_invoicecreation
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(AuditDataValidVO[] auditDataValidVOs) throws EventException {
		List<PsoChargeVO> insertPsoChargeVoList = new ArrayList<PsoChargeVO>();
		List<PsoChgDtlVO> insertPsoChgDtlVoList = new ArrayList<PsoChgDtlVO>();

		// set item which will be inserted in PSO_CHARGE
		PsoChargeVO psoChargeVO = new PsoChargeVO();
		psoChargeVO.setYdCd(auditDataValidVOs[0].getYdCd());
		psoChargeVO.setVndrSeq(auditDataValidVOs[0].getVndrSeq());
		psoChargeVO.setCostOfcCd(auditDataValidVOs[0].getLgsCostCd());
		psoChargeVO.setInvNo(auditDataValidVOs[0].getInvNo());
		psoChargeVO.setCreUsrId(auditDataValidVOs[0].getCreUsrId());
		psoChargeVO.setUpdUsrId(auditDataValidVOs[0].getUpdUsrId());
		psoChargeVO.setInvOfcCd(auditDataValidVOs[0].getOfcCd());
		psoChargeVO.setCostOfcCd(auditDataValidVOs[0].getOfcCd());
		psoChargeVO.setCurrCd("USD");
		if (auditDataValidVOs[0].getCnlTzBztpCd().equals("I")) {

			// float fval = 0;
			double fval = 0;
			String strTmp = "";
			for (int i = 0; i < auditDataValidVOs.length; i++) {
				if (auditDataValidVOs[i].getLgsCostCd().length() < 6)
					continue;
				strTmp = auditDataValidVOs[i].getCredits();
				if (strTmp != null) {
					if (!strTmp.equals(""))
						fval += Double.parseDouble(strTmp);
				} else
					fval += 0;
			}
			psoChargeVO.setTtlLoclAmt(fval + "");
			psoChargeVO.setInvLoclAmt(fval + "");
			psoChargeVO.setLoclNetAmt(fval + "");
			psoChargeVO.setTtlUsdAmt(fval + "");

			// PSO_TRNS_SLP_CTNT
			psoChargeVO.setPsoTrnsSlpCtnt("AA");
		} else {
			psoChargeVO.setTtlLoclAmt(auditDataValidVOs[0].getRqstAmtSum());
			psoChargeVO.setInvLoclAmt(auditDataValidVOs[0].getRqstAmtSum());
			psoChargeVO.setLoclNetAmt(auditDataValidVOs[0].getRqstAmtSum());
			psoChargeVO.setTtlUsdAmt(auditDataValidVOs[0].getRqstAmtSum());

			// PSO_TRNS_SLP_CTNT
			psoChargeVO.setPsoTrnsSlpCtnt("GO");
		}
		psoChargeVO.setDueDt(auditDataValidVOs[0].getDueDt());
		psoChargeVO.setPsoChgStsCd("A");

		insertPsoChargeVoList.add(psoChargeVO);

		try {

			dbDao.addPsoCharge(insertPsoChargeVoList);
			log.debug("\nXXX>> Total USD : " + insertPsoChargeVoList.size() + ", " + insertPsoChargeVoList.get(0).getTtlUsdAmt());

			for (int i = 0; i < auditDataValidVOs.length; i++) {
				PsoChgDtlVO vo = new PsoChgDtlVO();
				if (auditDataValidVOs[0].getCnlTzBztpCd().equals("I")) {
					if (auditDataValidVOs[i].getLgsCostCd().length() < 6)
						continue;
				}
				vo.setVslCd(auditDataValidVOs[i].getVvd().substring(0, 4));
				vo.setSkdVoyNo(auditDataValidVOs[i].getVvd().substring(4, 8));
				vo.setSkdDirCd(auditDataValidVOs[i].getVvd().substring(8, 9));

				if (auditDataValidVOs[0].getCnlTzBztpCd().equals("I")) {
					vo.setLoclAmt(auditDataValidVOs[i].getCredits());
					vo.setUsdAmt(auditDataValidVOs[i].getCredits());
				} else {
					vo.setLoclAmt(auditDataValidVOs[i].getRqstAmt());
					vo.setUsdAmt(auditDataValidVOs[i].getRqstAmt());
				}

				vo.setCalcAmt(auditDataValidVOs[i].getCalcAmt());
				vo.setXprDesc(auditDataValidVOs[i].getDfltXprDesc());
				vo.setLgsCostCd(auditDataValidVOs[i].getLgsCostCd());
				vo.setFomlDesc(auditDataValidVOs[i].getSysXprDesc());
				vo.setYdChgNo(auditDataValidVOs[i].getYdChgNo());
				vo.setYdChgVerSeq(auditDataValidVOs[i].getYdChgVerSeq());
				vo.setDiffRmk(auditDataValidVOs[i].getDiffRmk());
				vo.setSoDtlSeq(i + 1 + "");
				vo.setCreUsrId(auditDataValidVOs[0].getCreUsrId());
				vo.setUpdUsrId(auditDataValidVOs[0].getUpdUsrId());
				vo.setIoBndCd("O");
				vo.setDiffRmk(auditDataValidVOs[i].getDiffRmk());
				insertPsoChgDtlVoList.add(vo);

				log.debug("\nXXX>> Detail USD : " + vo.getUsdAmt());
			}
			dbDao.addPsoChgDtl(insertPsoChgDtlVoList);

			// dbDao.manageGenInvAudit(auditDataValidVOs);
			// Handling ToCSR

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Requested Advance Payment" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Requested Advance Payment" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve PSO_YD_CHG Info by condition given
	 * 
	 * @category VOP_PSO_0014_searchPsoYdChg
	 * @param String lgsCostCd
	 * @param String ydCd
	 * @param String vndrSeq
	 * @param String issDt
	 * @return List<PsoYdChgVO>
	 * @throws EventException
	 */
	public List<PsoYdChgVO> searchPsoYdChg(String lgsCostCd, String ydCd, String vndrSeq, String issDt) throws EventException {
		try {
			return dbDao.searchPsoYdChg(lgsCostCd, ydCd, vndrSeq, issDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Effective Date in case of changing Issue Date
	 * 
	 * @category VOP_PSO_0014_onChangeIssueDate
	 * @param String issDt
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchEffDateByIssDate(String issDt, String ofcCd) throws EventException {
		try {
			return dbDao.searchEffDateByIssDate(issDt, ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save in case of Clicking Invoice Creation & Audit page Save Button <br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO[] invAuditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(InvAuditDataValidVO[] invAuditDataValidVOs) throws EventException {
		try {
			List<PsoChgDtlVO> insertVoList = new ArrayList<PsoChgDtlVO>();
			// List<PsoChgDtlVO> updateVoList = new ArrayList<PsoChgDtlVO>();
			List<PsoChgDtlVO> deleteVoList = new ArrayList<PsoChgDtlVO>();

			PsoChargeVO mastervo = new PsoChargeVO();

			if (invAuditDataValidVOs.length > 0) {
				log.debug("\n[manageGenInvAudit] Master Call start =================================================");
				List<PsoChargeVO> lst = dbDao.isExistPsoCharge(invAuditDataValidVOs[0].getYdCd(), invAuditDataValidVOs[0].getVndrSeq(), invAuditDataValidVOs[0].getInvNo());

				List<PsoChargeVO> modifyPsoChargeList = new ArrayList<PsoChargeVO>();

				if (null != lst && lst.size() > 0) {
					// if(!"A".equals(invAuditDataValidVOs[0].getPsoChgStsCd())  && invAuditDataValidVOs[0].getUpdateflag().equals("false")){
					
					if (invAuditDataValidVOs[0].getUpdateflag().equals("false")) {
						throw new EventException(new ErrorHandler("PSO90006").getMessage());
					}
					mastervo.setIssCtyCd(lst.get(0).getIssCtyCd());
					mastervo.setSoSeq(lst.get(0).getSoSeq());
				} else{
					mastervo.setIssCtyCd(invAuditDataValidVOs[0].getInvOfcCd().substring(0, 3));
				}
				mastervo.setPsoChgStsCd		("I");
				// mastervo.setSoSeq(invAuditDataValidVOs[0].getSoSeq());
				mastervo.setYdCd			(invAuditDataValidVOs[0].getYdCd());
				mastervo.setVndrSeq			(invAuditDataValidVOs[0].getVndrSeq());
				mastervo.setCostOfcCd		(invAuditDataValidVOs[0].getCostOfcCd());
				mastervo.setInvOfcCd		(invAuditDataValidVOs[0].getInvOfcCd());
				mastervo.setInvNo			(invAuditDataValidVOs[0].getInvNo());
				mastervo.setCurrCd			(invAuditDataValidVOs[0].getCurrCd());

				mastervo.setInvLoclAmt		(invAuditDataValidVOs[0].getInvLoclAmt().replace(",", ""));
				mastervo.setLoclTaxAmt		(invAuditDataValidVOs[0].getLoclTaxAmt().replace(",", ""));
				mastervo.setLoclWhldTaxAmt	(invAuditDataValidVOs[0].getLoclWhldTaxAmt().replace(",", ""));
				mastervo.setLoclNetAmt		(invAuditDataValidVOs[0].getLoclNetAmt().replace(",", ""));
				mastervo.setLoclDdctAmt		(invAuditDataValidVOs[0].getLoclDdctAmt().replace(",", ""));
				mastervo.setTtlLoclAmt		(invAuditDataValidVOs[0].getTtlLoclAmt().replace(",", ""));

				mastervo.setIssDt			(invAuditDataValidVOs[0].getIssDt());
				mastervo.setPsoTrnsSlpCtnt	(invAuditDataValidVOs[0].getPsoTrnsSlpCtnt().equals("Y") ? "AR" : "");

				String usdAmt = dbDao.getUsdAmt(mastervo.getTtlLoclAmt().replace(",", ""), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
				String usdAmts[] = usdAmt.split("\\|", 2);
				if (usdAmts.length >= 2) {
					if (usdAmts[0].equals("")) {
						mastervo.setTtlUsdAmt(usdAmts[1]);
					} else {
						mastervo.setTtlUsdAmt(usdAmts[0]);
					}
				}
				mastervo.setAcptDt			(invAuditDataValidVOs[0].getAcptDt());
				mastervo.setEffDt			(invAuditDataValidVOs[0].getEffDt());
				mastervo.setUpdUsrId		(invAuditDataValidVOs[0].getUsrId());

				List<TermDueVO> tdlist = dbDao.getTermDueDate(mastervo.getVndrSeq(), mastervo.getIssDt());
				if (tdlist != null) {
					TermDueVO tdvo = tdlist.get(0);
					mastervo.setPayTermDys	(tdvo.getPayTermDays());
					mastervo.setDueDt		(tdvo.getDueDt());
				}

				if (null != lst && lst.size() > 0) {// Update
					modifyPsoChargeList.add(mastervo);
					dbDao.modifyPsoCharge(modifyPsoChargeList);
				} else {// Insert
					List<PsoChargeVO> insertPsoChargeVoList = new ArrayList<PsoChargeVO>();
					mastervo.setCreUsrId(invAuditDataValidVOs[0].getUsrId());
					insertPsoChargeVoList.add(mastervo);
					dbDao.addPsoCharge(insertPsoChargeVoList);
				}
				log.debug("\n[manageGenInvAudit] Master Call e n d =================================================");
			}

			// ddtLoclAmt = 0;
			// double netLoclAmt = 0;
			log.debug("\n[manageGenInvAudit] Detail Data Set Call start =================================================");
			//PSO_CHG_DTL 정책 : Detail All Delete 후에 Insert 정책입니다.
			for (int i = 0; i < invAuditDataValidVOs.length; i++) {
				InvAuditDataValidVO vo = invAuditDataValidVOs[i];
				PsoChgDtlVO vo1 = new PsoChgDtlVO();
				PsoChgDtlVO vo2 = new PsoChgDtlVO();

				//insertVoList는 Ibflag : D 가 아닐경우에만 Insert.
				setInsertList(insertVoList, mastervo, vo, vo1, vo2);

				vo1.setIssCtyCd	(mastervo.getIssCtyCd());
				vo1.setSoSeq	(mastervo.getSoSeq());
				vo1.setSoDtlSeq	(vo.getSoDtlSeq());
				vo1.setIbflag("U");
				deleteVoList.add(vo1);

			}
			log.debug("\n[manageGenInvAudit] Detail Data Set Call e n d =================================================");
			if (deleteVoList.size() > 0) {
				log.debug("\n[manageGenInvAudit] Detail removePsoChargeDetail Call.");
				dbDao.removePsoChargeDetail(deleteVoList);
			}
			for(PsoChgDtlVO targetVO : insertVoList){
				log.debug("\n[manageGenInvAudit] Detail addPsoChargeDetail Call.");
				dbDao.addPsoChargeDetail(targetVO);
			}

		} catch (EventException e) {
			throw e;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}

	}


	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save in case of Clicking Invoice Creation(Master) & Audit page Save Button <br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO[] invAuditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAuditMaster(InvAuditDataValidVO[] invAuditDataValidVOs) throws EventException {
		try {
			log.debug("\n[manageGenInvAuditMaster] Call start =========================================");
			
			PsoChargeVO mastervo = new PsoChargeVO();			

			if (invAuditDataValidVOs.length > 0) {
				List<PsoChargeVO> list = dbDao.isExistPsoCharge(invAuditDataValidVOs[0].getYdCd(), invAuditDataValidVOs[0].getVndrSeq(), invAuditDataValidVOs[0].getInvNo());
				
				if (null !=list && list.size() > 0) {
					if (invAuditDataValidVOs[0].getUpdateflag().equals("false")) {
						throw new EventException(new ErrorHandler("PSO90006").getMessage());
					}
					mastervo.setIssCtyCd	(list.get(0).getIssCtyCd());
					mastervo.setSoSeq		(list.get(0).getSoSeq());
				} else {
					mastervo.setIssCtyCd	(invAuditDataValidVOs[0].getInvOfcCd().substring(0, 3));
				}
				mastervo.setPsoChgStsCd		("I");
				// mastervo.setSoSeq(invAuditDataValidVOs[0].getSoSeq());
				mastervo.setYdCd			(invAuditDataValidVOs[0].getYdCd());
				mastervo.setVndrSeq			(invAuditDataValidVOs[0].getVndrSeq());
				mastervo.setCostOfcCd		(invAuditDataValidVOs[0].getCostOfcCd());
				mastervo.setInvOfcCd		(invAuditDataValidVOs[0].getInvOfcCd());
				mastervo.setInvNo			(invAuditDataValidVOs[0].getInvNo());
				mastervo.setCurrCd			(invAuditDataValidVOs[0].getCurrCd());

				mastervo.setInvLoclAmt		(invAuditDataValidVOs[0].getInvLoclAmt().replace(",", ""));
				mastervo.setLoclTaxAmt		(invAuditDataValidVOs[0].getLoclTaxAmt().replace(",", ""));
				mastervo.setLoclWhldTaxAmt	(invAuditDataValidVOs[0].getLoclWhldTaxAmt().replace(",", ""));
				mastervo.setLoclNetAmt		(invAuditDataValidVOs[0].getLoclNetAmt().replace(",", ""));
				mastervo.setLoclDdctAmt		(invAuditDataValidVOs[0].getLoclDdctAmt().replace(",", ""));
				//TtlLoclAmt 은 InvLoclAmt 를 넣는다. 마스터 정보는 무조건 1건만 들어가므로 입력된 InvLoclAmt 를 넣늗다.
				mastervo.setTtlLoclAmt		(mastervo.getInvLoclAmt());
				//mastervo.setTtlLoclAmt(invAuditDataValidVOs[0].getTtlLoclAmt().replace(",", ""));
				
				mastervo.setIssDt			(invAuditDataValidVOs[0].getIssDt());
				mastervo.setPsoTrnsSlpCtnt	(invAuditDataValidVOs[0].getPsoTrnsSlpCtnt().equals("Y") ? "AR" : "");

				String usdAmt = dbDao.getUsdAmt(mastervo.getTtlLoclAmt().replace(",", ""), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
				
				String usdAmts[] = usdAmt.split("\\|", 2);
				if (usdAmts.length >= 2) {
					if (usdAmts[0].equals("")) {
						mastervo.setTtlUsdAmt(usdAmts[1]);
					} else {
						mastervo.setTtlUsdAmt(usdAmts[0]);
					}
				}
				mastervo.setAcptDt			(invAuditDataValidVOs[0].getAcptDt());
				mastervo.setEffDt			(invAuditDataValidVOs[0].getEffDt());
				mastervo.setUpdUsrId		(invAuditDataValidVOs[0].getUsrId());

				List<TermDueVO> tdlist = dbDao.getTermDueDate(mastervo.getVndrSeq(), mastervo.getIssDt());
				
				if (tdlist != null) {
					TermDueVO tdvo = tdlist.get(0);
					mastervo.setPayTermDys	(tdvo.getPayTermDays());
					mastervo.setDueDt		(tdvo.getDueDt());
				}

				if (null != list && list.size() > 0) {// Update
					List<PsoChargeVO> modifyPsoChargeList = new ArrayList<PsoChargeVO>();
					modifyPsoChargeList.add(mastervo);

					dbDao.modifyPsoCharge(modifyPsoChargeList);
				} else {// Insert
					List<PsoChargeVO> insertPsoChargeVoList = new ArrayList<PsoChargeVO>();
					mastervo.setCreUsrId	(invAuditDataValidVOs[0].getUsrId());
					insertPsoChargeVoList.add(mastervo);
					
					dbDao.addPsoCharge(insertPsoChargeVoList);
				}
			}
			log.debug("\n[manageGenInvAuditMaster] Call e n d =========================================");
		} catch (EventException e) {
			throw e;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Master Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Master Creation & Audit" }).getMessage(), ex);
		}

	}

	/**
	 * Invoice charge detail setting
	 * 
	 * @param List <PsoChgDtlVO> insertVoList
	 * @param PsoChargeVO mastervo
	 * @param InvAuditDataValidVO vo
	 * @param PsoChgDtlVO vo1
	 * @param PsoChgDtlVO vo2
	 * @throws DAOException
	 */
	private void setInsertList(List<PsoChgDtlVO> insertVoList, PsoChargeVO mastervo, InvAuditDataValidVO vo, PsoChgDtlVO vo1, PsoChgDtlVO vo2) throws EventException, DAOException {
		log.debug("\nPort charge Invoice Creation [setInsertList] Call start ===============================================");
		log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"] IO Flag ["+vo.getIo()+"]");
		
		//2016.08.24 Add Exception Message: 화면에서 보여주는 메세지와 맞춤.
		String msgCheckedRevDerection = "There is no related revenue VVD, Plase contract the PIC of finance part.";
		if(!"D".equals(vo.getIbflag())){
			if (vo.getIo().equals("INOUT")) {
				log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case.");
				//2015.03.20 NYK Canal 구분없이 기존 Port 로 진행하도록 주석처리.
				/*
				if (vo.getYdCd().indexOf(PsoConstants.SUEZ_CANAL) != -1 || vo.getYdCd().indexOf(PsoConstants.PANAMA_CANAL) != -1) {
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"] INOUT Canal In Case.");
					vo1.setIssCtyCd(mastervo.getIssCtyCd());
					vo1.setSoSeq(mastervo.getSoSeq());
					vo1.setSoDtlSeq(vo.getSoDtlSeq());
					vo1.setVslCd(vo.getVslCd());
					vo1.setSkdVoyNo(vo.getSkdVoyNo());
					vo1.setSkdDirCd(vo.getSkdDirCd());
					vo1.setLgsCostCd(vo.getCostCd());
					vo1.setIoBndCd("O");
					vo1.setDpIoBndCd("");
					vo1.setLoclAmt(vo.getAmount());
					String usdAmt = dbDao.getUsdAmt(vo.getAmount(), vo.getCurrCd(), vo.getIssDt(), "1");
					// usdAmt = "|2";
					String usdAmts[] = usdAmt.split("\\|", 2);
					if (usdAmts.length >= 2) {
						if (usdAmts[0].equals("")) {
							vo1.setUsdAmt(usdAmts[1]);
						} else {
							vo1.setUsdAmt(usdAmts[0]);
						}
					}
					vo1.setCalcAmt(vo.getTariffCost());
					vo1.setAdjAmt(vo.getAdjcost());
					vo1.setXprDesc(vo.getFoml2());
					vo1.setFomlDesc(vo.getFoml1());
					vo1.setYdChgNo(vo.getYdChgNo());
					vo1.setYdChgVerSeq(vo.getYdChgVerSeq());
					vo1.setDiffRmk(vo.getRemark());
					vo1.setCreUsrId(vo.getUsrId());
					vo1.setUpdUsrId(vo.getUsrId());
	
					setInvCondDesc(vo, vo1);
	
					String strRevLaneDir = dbDao.getRevLaneDir(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd());
					String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
					vo1.setRlaneCd(aryRevLaneDir[0]);
					vo1.setRevDirCd(aryRevLaneDir[1]);
					vo1.setArYrmon(aryRevLaneDir[2]);
					
					
					insertVoList.add(vo1);
				} else {
				*/	
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case.");
					vo.setOrgFlg("I");
					//PSO_PORT_EXPN_DIV 등록 여부 판단 (SLAN_CD, LOC_CD)
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] getExistPortExpnDiv Call.");
					
					String sExistYn = dbDao.getExistPortExpnDiv(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(), vo.getClptIndSeq());
					
					log.debug("\n================================================================================================================================"+
					          "\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] getExistPortExpnDiv Call After sExistYn ["+sExistYn+"] getIoRatio Call Start."+
					          "\n================================================================================================================================");
					List<IoRatioVO> rList = dbDao.getIoRatio(vo, sExistYn);
					
					log.debug("\n================================================================================================================================"+
					          "\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] getExistPortExpnDiv Call After sExistYn ["+sExistYn+"] getIoRatio Call E n d."+
					          "\n================================================================================================================================");
					if (rList != null) {
						log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case => getIoRatio List Not Null Size ["+rList.size()+"].");
						//getIoRatio Data 없을때 size 0이므로 들어온 데이타를 기준으로 처리한다.
						if (rList.size() == 0) {
							log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 0 Row].");
							vo1.setIssCtyCd		(mastervo.getIssCtyCd());
							vo1.setSoSeq		(mastervo.getSoSeq());
							vo1.setSoDtlSeq		(vo.getSoDtlSeq());
							vo1.setVslCd		(vo.getVslCd());
							vo1.setSkdVoyNo		(vo.getSkdVoyNo());
							vo1.setSkdDirCd		(vo.getSkdDirCd());
							vo1.setLgsCostCd	(vo.getCostCd());
							vo1.setIoBndCd		("O");
							vo1.setDpIoBndCd	("");
							vo1.setLoclAmt		(vo.getAmount());
							
							String usdAmt = dbDao.getUsdAmt(vo.getAmount(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
							String usdAmts[] = usdAmt.split("\\|", 2);
							if (usdAmts.length >= 2) {
								if (usdAmts[0].equals("")) {
									vo1.setUsdAmt(usdAmts[1]);
								} else {
									vo1.setUsdAmt(usdAmts[0]);
								}
							}
							
							vo1.setCalcAmt		(vo.getTariffCost());
							vo1.setAdjAmt		(vo.getAdjcost());
							vo1.setXprDesc		(vo.getFoml2());
							vo1.setFomlDesc		(vo.getFoml1());
							vo1.setYdChgNo		(vo.getYdChgNo());
							vo1.setYdChgVerSeq	(vo.getYdChgVerSeq());
							vo1.setDiffRmk		(vo.getRemark());
							vo1.setCreUsrId		(vo.getUsrId());
							vo1.setUpdUsrId		(vo.getUsrId());
							
							vo1.setClptIndSeq	(vo.getClptIndSeq()); //2016.04.26 Double calling port Add 
	
							setInvCondDesc(vo, vo1);
	
							String strRevLaneDir = dbDao.getRevLaneDir(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(), vo.getClptIndSeq());
							if(!StringUtils.isEmpty(strRevLaneDir)){
								String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
								vo1.setRlaneCd		(aryRevLaneDir[0]);
								vo1.setRevDirCd		(aryRevLaneDir[1]);
								vo1.setArYrmon		(aryRevLaneDir[2]);
							}
							
							log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 0 Row] Before : Rev Data vo1 ["+vo1.getRlaneCd()+"]["+vo1.getRevDirCd()+"]["+vo1.getArYrmon()+"] Call.");
							//2016.08.24 Revenue lane/Direction 이 존재 하지 않을시 화면으로 메세지 리턴.
							if(StringUtils.isEmpty(vo1.getRlaneCd()) || StringUtils.isEmpty(vo1.getRevDirCd()) || StringUtils.isEmpty(vo1.getArYrmon())){
								//Failed to save [$s].
								throw new EventException(new ErrorHandler("PSO90011", new String[] {msgCheckedRevDerection}).getMessage());
							}
	
							insertVoList.add(vo1);
						} else if (rList.size() == 2) {// in out bound 2 record insert
							log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 2 Row].");
							IoRatioVO rvo1 = rList.get(0);
							IoRatioVO rvo2 = rList.get(1);
							
							vo1.setIssCtyCd		(mastervo.getIssCtyCd());
							vo1.setSoSeq		(mastervo.getSoSeq());
							vo1.setSoDtlSeq		(vo.getSoDtlSeq());
							vo1.setVslCd		(vo.getVslCd());
							vo1.setSkdVoyNo		(rvo1.getSkdVoyNo());
							vo1.setSkdDirCd		(rvo1.getSkdDirCd());
							vo1.setLgsCostCd	(vo.getCostCd());
							vo1.setRevDirCd		(rvo1.getRlaneDirCd());
							vo1.setRlaneCd		(rvo1.getRlaneCd());
							vo1.setIoBndCd		("O");
							vo1.setDpIoBndCd	("");
							
							//[OutBound]In/Out IORatio 에 따라 금액 나누기. 
							RoundTruncVO rtvo1in = new RoundTruncVO();
							rtvo1in.setIoBndCd	("O");
							rtvo1in.setRatio	(rvo1.getObRto());
							rtvo1in.setCurrCd	(mastervo.getCurrCd());
							rtvo1in.setLoclAmt	(vo.getAmount());
							rtvo1in.setCalcAmt	(vo.getTariffCost());
							rtvo1in.setAdjAmt	(vo.getAdjcost());
							if (rtvo1in.getRatio().equals("") || rtvo1in.getRatio() == null)
								rtvo1in.setRatio("50");
							RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
	
							vo1.setLoclAmt		(rtvo1out.getLoclAmt());
							
							// vo1.setUsdAmt("");
							String usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
							String usdAmts[] = usdAmt.split("\\|", 2);
							if (usdAmts.length >= 2) {
								if (usdAmts[0].equals("")) {
									vo1.setUsdAmt(usdAmts[1]);
								} else {
									vo1.setUsdAmt(usdAmts[0]);
								}
							}
							
							vo1.setCalcAmt		(rtvo1out.getCalcAmt());
							vo1.setAdjAmt		(rtvo1out.getAdjAmt());
							vo1.setXprDesc		(vo.getFoml2());
							vo1.setFomlDesc		(vo.getFoml1());
							vo1.setYdChgNo		(vo.getYdChgNo());
							vo1.setYdChgVerSeq	(vo.getYdChgVerSeq());
							vo1.setDiffRmk		(vo.getRemark());
							vo1.setArYrmon		(rvo1.getRevYrmon());
							vo1.setCreUsrId		(vo.getUsrId());
							vo1.setUpdUsrId		(vo.getUsrId());

							vo1.setClptIndSeq	(rvo1.getClptIndSeq()); //2016.04.26 Double calling port Add 
	
							vo2.setIssCtyCd		(mastervo.getIssCtyCd());
							vo2.setSoSeq		(mastervo.getSoSeq());
							vo2.setSoDtlSeq		(vo.getSoDtlSeq());
							vo2.setVslCd		(vo.getVslCd());
							vo2.setSkdVoyNo		(rvo2.getSkdVoyNo());
							vo2.setSkdDirCd		(rvo2.getSkdDirCd());
							vo2.setLgsCostCd	(vo.getCostCd());
							vo2.setRevDirCd		(rvo2.getRlaneDirCd());
							vo2.setRlaneCd		(rvo2.getRlaneCd());
	
							vo2.setIoBndCd		("I");
							vo2.setDpIoBndCd	("");
							
							//[InBound]In/Out IORatio 에 따라 금액 나누기. 
							RoundTruncVO rtvo2in = new RoundTruncVO();
							rtvo2in.setIoBndCd("I");
							rtvo2in.setRatio	(rvo2.getIbRto());
							rtvo2in.setCurrCd	(mastervo.getCurrCd());
							rtvo2in.setLoclAmt	(vo.getAmount());
							rtvo2in.setCalcAmt	(vo.getTariffCost());
							rtvo2in.setAdjAmt	(vo.getAdjcost());
							RoundTruncVO rtvo2out = dbDao.getRoundTruncAmt(rtvo2in);
	
							vo2.setLoclAmt		(rtvo2out.getLoclAmt());
	
							// -------------AS
							String usdAmt2 = dbDao.getUsdAmt(rtvo2out.getLoclAmt(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
							String usdAmts2[] = usdAmt2.split("\\|", 2);
							if (usdAmts2.length >= 2) {
								if (usdAmts[0].equals("")) {
									vo2.setUsdAmt(usdAmts2[1]);
								} else {
									vo2.setUsdAmt(usdAmts2[0]);
								}
							}
							
							vo2.setCalcAmt		(rtvo2out.getCalcAmt());
							vo2.setAdjAmt		(rtvo2out.getAdjAmt());
							vo2.setXprDesc		(vo.getFoml2());
							vo2.setFomlDesc		(vo.getFoml1());
							vo2.setYdChgNo		(vo.getYdChgNo());
							vo2.setYdChgVerSeq	(vo.getYdChgVerSeq());
							vo2.setDiffRmk		(vo.getRemark());
							vo2.setArYrmon		(rvo2.getRevYrmon());
							vo2.setCreUsrId		(vo.getUsrId());
							vo2.setUpdUsrId		(vo.getUsrId());
							vo2.setOrgSoDtlSeq	("-999");
	
							vo2.setClptIndSeq	(rvo2.getClptIndSeq()); //2016.04.26 Double calling port Add 
							
							setInvCondDesc(vo, vo1);
	
							setInvCondDesc(vo, vo2);
	
							//
							log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 2 Row] searchInboundVvd Before : Outbound VVD ["+(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd())+"] Call.");
							String inBndVvd = dbDao.searchInboundVvd(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(), vo.getClptIndSeq());
							log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 2 Row] searchInboundVvd After : Outbound VVD ["+(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd())+"] >> Inbound VVD ["+inBndVvd+"].");
							
							if(StringUtils.isNotEmpty(inBndVvd)){
								//2015.09.10 NYK Add : Virtual Port 를 넣는다.(사용자가 입력한 VVD 를 Set)
								vo2.setVtVvdFlg("Y");
								vo2.setTurnVvdCd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
							}
							
							log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 2 Row] Before : Rev Data vo1 ["+vo1.getRlaneCd()+"]["+vo1.getRevDirCd()+"]["+vo1.getArYrmon()+"] Call.");
							//2016.08.24 Revenue lane/Direction 이 존재 하지 않을시 화면으로 메세지 리턴.
							if(StringUtils.isEmpty(vo1.getRlaneCd()) || StringUtils.isEmpty(vo1.getRevDirCd()) || StringUtils.isEmpty(vo1.getArYrmon())){
								//Failed to save [$s].
								throw new EventException(new ErrorHandler("PSO90011", new String[] {msgCheckedRevDerection}).getMessage());
							}
							log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 2 Row] Before : Rev Data vo2 ["+vo2.getRlaneCd()+"]["+vo2.getRevDirCd()+"]["+vo2.getArYrmon()+"] Call.");
							//2016.08.24 Revenue lane/Direction 이 존재 하지 않을시 화면으로 메세지 리턴.
							if(StringUtils.isEmpty(vo2.getRlaneCd()) || StringUtils.isEmpty(vo2.getRevDirCd()) || StringUtils.isEmpty(vo2.getArYrmon())){
								//Failed to save [$s].
								throw new EventException(new ErrorHandler("PSO90011", new String[] {msgCheckedRevDerection}).getMessage());
							}
							
							insertVoList.add(vo1);
							insertVoList.add(vo2);
						}// end of else if
	
						else {
							//getIoRatio조회시 1건의 데이타만 존재하므로 OutBound로 100% 잡아서 들어온 Data를 기준으로 처리한다. 
							log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 1 Row].");
							IoRatioVO rvo1 = rList.get(0);
							
							vo1.setIssCtyCd		(mastervo.getIssCtyCd());
							vo1.setSoSeq		(mastervo.getSoSeq());
							vo1.setSoDtlSeq		(vo.getSoDtlSeq());
							vo1.setVslCd		(vo.getVslCd());
							vo1.setSkdVoyNo		(rvo1.getSkdVoyNo());
							vo1.setSkdDirCd		(rvo1.getSkdDirCd());
							vo1.setLgsCostCd	(vo.getCostCd());
							vo1.setRevDirCd		(rvo1.getRlaneDirCd());
							vo1.setRlaneCd		(rvo1.getRlaneCd());
	
							vo1.setIoBndCd		("O");	
							vo1.setDpIoBndCd	("");
							
							vo1.setLoclAmt		(vo.getAmount());
							
							String usdAmt = dbDao.getUsdAmt(vo.getAmount(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
							String usdAmts[] = usdAmt.split("\\|", 2);
							if (usdAmts.length >= 2) {
								if (usdAmts[0].equals("")) {
									vo1.setUsdAmt(usdAmts[1]);
								} else {
									vo1.setUsdAmt(usdAmts[0]);
								}
							}
							vo1.setCalcAmt		(vo.getTariffCost());
							vo1.setAdjAmt		(vo.getAdjcost());
							vo1.setXprDesc		(vo.getFoml2());
							vo1.setFomlDesc		(vo.getFoml1());
							vo1.setYdChgNo		(vo.getYdChgNo());
							vo1.setYdChgVerSeq	(vo.getYdChgVerSeq());
							vo1.setDiffRmk		(vo.getRemark());
							vo1.setArYrmon		(rvo1.getRevYrmon());
							vo1.setCreUsrId		(vo.getUsrId());
							vo1.setUpdUsrId		(vo.getUsrId());
							
							vo1.setClptIndSeq	(rvo1.getClptIndSeq()); //2016.04.26 Double calling port Add 
	
							setInvCondDesc(vo, vo1);
	
							log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] INOUT Case [Record 1 Row] Before : Rev Data vo1 ["+vo1.getRlaneCd()+"]["+vo1.getRevDirCd()+"]["+vo1.getArYrmon()+"] Call.");
							//2016.08.24 Revenue lane/Direction 이 존재 하지 않을시 화면으로 메세지 리턴.
							if(StringUtils.isEmpty(vo1.getRlaneCd()) || StringUtils.isEmpty(vo1.getRevDirCd()) || StringUtils.isEmpty(vo1.getArYrmon())){
								//Failed to save [$s].
								throw new EventException(new ErrorHandler("PSO90011", new String[] {msgCheckedRevDerection}).getMessage());
							}
							
							insertVoList.add(vo1);
						}
	
					}// end of if(rList != null)
				//}// end of else
			}// end of if(vo.getIo().equals("INOUT")){
			else {
				log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case.");
				
				//2015.07.01 Add
				//1. Outbound VVD가 넘어 올때 IO 가 IN 이면 Inbound VVD 를 찾아서 넣어준다.
				//   단, Normal VVD 이면서 IO = IN 이면 TURN_PORT_FLG <> 'Y' 이가 아니면 vvd 그대로 사용.
				String tmpVslCd 		= "";
				String tmpSkdVoyNo 		= "";
				String tmpSkdDirCd 		= "";
				String tmpClptIndSeq 	= "";
				
				if("IN".equals(vo.getIo())){
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IO Flag IN Case searchInboundVvd Before : Outbound VVD ["+(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd())+"] Call.");
					String inBndVvd = dbDao.searchInboundVvd(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(), vo.getClptIndSeq());
					
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IO Flag IN Case searchInboundVvd After : Outbound VVD ["+(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd())+"] >> Inbound VVD ["+inBndVvd+"].");
					
					if(StringUtils.isNotEmpty(inBndVvd)){
						String arrVvd[] = StringUtils.split(inBndVvd, "|");
						
						tmpVslCd 		=  arrVvd[0];
						tmpSkdVoyNo 	=  arrVvd[1];
						tmpSkdDirCd 	=  arrVvd[2];
						tmpClptIndSeq 	=  arrVvd[3];
						
						//2015.09.10 NYK Add : Virtual Port인지 조회 후에 넣는다.(사용자가 입력한 VVD 를 Set)
						vo1.setVtVvdFlg("Y");
						vo1.setTurnVvdCd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
						log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IO Flag IN Case searchInboundVvd After2 : Inbound VVD ["+(tmpVslCd+tmpSkdVoyNo+tmpSkdDirCd)+"] >> Inbound VVD ["+inBndVvd+"].");
					}else{
						tmpVslCd 		=  vo.getVslCd();
						tmpSkdVoyNo	 	=  vo.getSkdVoyNo();
						tmpSkdDirCd 	=  vo.getSkdDirCd();
						tmpClptIndSeq 	=  vo.getClptIndSeq();

						//2015.09.10 NYK Add
						vo1.setVtVvdFlg("");
						vo1.setTurnVvdCd("");
						log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IO Flag IN Case searchInboundVvd After2 : Outbound VVD ["+(tmpVslCd+tmpSkdVoyNo+tmpSkdDirCd)+"] >> Inbound VVD ["+inBndVvd+"].");
					}
				}else{
					tmpVslCd 		=  vo.getVslCd();
					tmpSkdVoyNo 	=  vo.getSkdVoyNo();
					tmpSkdDirCd 	=  vo.getSkdDirCd();
					tmpClptIndSeq 	=  vo.getClptIndSeq();
					
					//2015.09.10 NYK Add
					vo1.setVtVvdFlg("");
					vo1.setTurnVvdCd("");
				}
				log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case VVD ["+(tmpVslCd+tmpSkdVoyNo+tmpSkdDirCd)+"].");
				
				vo1.setIssCtyCd		(mastervo.getIssCtyCd());
				vo1.setSoSeq		(mastervo.getSoSeq());
				vo1.setSoDtlSeq		(vo.getSoDtlSeq());
				vo1.setVslCd		(tmpVslCd);
				vo1.setSkdVoyNo		(tmpSkdVoyNo);
				vo1.setSkdDirCd		(tmpSkdDirCd);
				vo1.setLgsCostCd	(vo.getCostCd());
				vo1.setIoBndCd		(vo.getIo().equals("IN") ? "I" : "O");
				vo1.setDpIoBndCd	(vo.getIo().equals("IN") ? "I" : "O");
				vo1.setLoclAmt		(vo.getAmount());
				
				String usdAmt = dbDao.getUsdAmt(vo.getAmount(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
				String usdAmts[] = usdAmt.split("\\|", 2);
				if (usdAmts.length >= 2) {
					if (usdAmts[0].equals("")) {
						vo1.setUsdAmt(usdAmts[1]);
					} else {
						vo1.setUsdAmt(usdAmts[0]);
					}
				}
				vo1.setCalcAmt		(vo.getTariffCost());
				vo1.setAdjAmt		(vo.getAdjcost());
				vo1.setXprDesc		(vo.getFoml2());
				vo1.setFomlDesc		(vo.getFoml1());
				vo1.setYdChgNo		(vo.getYdChgNo());
				vo1.setYdChgVerSeq	(vo.getYdChgVerSeq());
				vo1.setDiffRmk		(vo.getRemark());
				vo1.setCreUsrId		(vo.getUsrId());
				vo1.setUpdUsrId		(vo.getUsrId());

				vo1.setClptIndSeq	(tmpClptIndSeq); //2016.04.26 Double calling port Add 
				
				setInvCondDesc(vo, vo1);
	
				log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case getPendulumRevLaneDir Call.");
				//IO에 따른 펜들럼 일때 IO 구분으로 RlaneCd, RevDirCd, ㅁ 를 새로 구함. | 구분자로 3자리 옴.
				String tmpRlaneCd = "";
				String tmpRevDirCd = "";
				String tmpArYrmon = "";
				
				//PSO PSO_PORT_EXPN_DIV Pendulum이 등록되었을 경우 
				String strRevLaneDir = dbDao.getPendulumRevLaneDir(tmpVslCd, tmpSkdVoyNo, tmpSkdDirCd, mastervo.getYdCd(), vo.getIo());
				if(!StringUtils.isEmpty(strRevLaneDir)){
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case Pendulum(PSO_PORT_EXPN_DIV) getPendulumRevLaneDir strRevLaneDir ["+strRevLaneDir+"].");
					String aryPendulumRevLaneDir[] = strRevLaneDir.split("\\|", 3);
					tmpRlaneCd 	= aryPendulumRevLaneDir[0];
					tmpRevDirCd = aryPendulumRevLaneDir[1];
					tmpArYrmon 	= aryPendulumRevLaneDir[2];
				}
				
				log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case Pendulum(PSO_PORT_EXPN_DIV) Before strRevLaneDir["+strRevLaneDir+"] tmpRlaneCd["+tmpRlaneCd+"] tmpRevDirCd["+tmpRevDirCd+"] tmpArYrmon["+tmpArYrmon+"]");
				
				/*
				 * 2016.03.18 
				 *  정책1. PSO PSO_PORT_EXPN_DIV Pendulum이 등록되지 않고, AR 에만 등록된 경우
				 *  정책2. VVD Turning port 가 아닌 경우. 
				 */
				if(StringUtils.isEmpty(tmpRlaneCd) || StringUtils.isEmpty(tmpRevDirCd) || StringUtils.isEmpty(tmpArYrmon)){
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case AR Pendulum getNonexistentRevLaneDir Call Start.");
					
					strRevLaneDir = dbDao.getNonexistentRevLaneDir(tmpVslCd, tmpSkdVoyNo, tmpSkdDirCd, mastervo.getYdCd(), vo.getIo(), tmpClptIndSeq);
					
					if(!StringUtils.isEmpty(strRevLaneDir)){
						String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
						tmpRlaneCd 	= aryRevLaneDir[0];
						tmpRevDirCd = aryRevLaneDir[1];
						tmpArYrmon 	= aryRevLaneDir[2];
					}
					
					log.debug("\nAR Pendulum strRevLaneDir["+strRevLaneDir+"] tmpRlaneCd["+tmpRlaneCd+"] tmpRevDirCd["+tmpRevDirCd+"] tmpArYrmon["+tmpArYrmon+"]");
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case AR Pendulum getNonexistentRevLaneDir Call E n d.");
				}
				
				
				//1개라도 Null 이면 다시 구한다. 2016.03.17 pso expense에 pendulum이 등록되어 있지 않고 AR에 Pendulum 인 경우 Rev Lane을 구하도록 쿼리 수정조치함. 
				if(StringUtils.isEmpty(tmpRlaneCd) || StringUtils.isEmpty(tmpRevDirCd) || StringUtils.isEmpty(tmpArYrmon)){
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case Not Pendulum getRevLaneDir Call.");
					strRevLaneDir = dbDao.getRevLaneDir(tmpVslCd, tmpSkdVoyNo, tmpSkdDirCd, mastervo.getYdCd(), tmpClptIndSeq);
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case Not Pendulum getRevLaneDir strRevLaneDir ["+strRevLaneDir+"].");
					
					String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
					tmpRlaneCd 	= aryRevLaneDir[0];
					tmpRevDirCd = aryRevLaneDir[1];
					tmpArYrmon 	= aryRevLaneDir[2];
					log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case Not Pendulum Before strRevLaneDir["+strRevLaneDir+"] tmpRlaneCd["+tmpRlaneCd+"] tmpRevDirCd["+tmpRevDirCd+"] tmpArYrmon["+tmpArYrmon+"]");
				}
				
				//TEST를 위해서 무조건 Null로 넣는다.
				//tmpRlaneCd = ""; tmpRevDirCd = ""; tmpArYrmon = "";
				log.debug("\nPort charge Invoice Creation [setInsertList]  Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case Before : Rev Data vo1 ["+tmpRlaneCd+"]["+tmpRevDirCd+"]["+tmpArYrmon+"] Call.");
				//2016.08.24 Revenue lane/Direction 이 존재 하지 않을시 화면으로 메세지 리턴.
				if(StringUtils.isEmpty(tmpRlaneCd) || StringUtils.isEmpty(tmpRevDirCd) || StringUtils.isEmpty(tmpArYrmon)){
					//Failed to save [$s].
					throw new EventException(new ErrorHandler("PSO90011", new String[] {msgCheckedRevDerection}).getMessage());
				}
				
				/*
				String strRevLaneDir = dbDao.getRevLaneDir(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd());
				String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
				vo1.setRlaneCd(aryRevLaneDir[0]);
				vo1.setRevDirCd(aryRevLaneDir[1]);
				vo1.setArYrmon(aryRevLaneDir[2]);
				 */
				log.debug("\nPort charge Invoice Creation [setInsertList] Ibflag ["+vo.getIbflag()+"]/["+vo.getIo()+"] IN or OUT Case After SetData tmpRlaneCd["+tmpRlaneCd+"] tmpRevDirCd["+tmpRevDirCd+"] tmpArYrmon["+tmpArYrmon+"]");
				vo1.setRlaneCd		(tmpRlaneCd);
				vo1.setRevDirCd		(tmpRevDirCd);
				vo1.setArYrmon		(tmpArYrmon);
				insertVoList.add(vo1);
			}
		}
		log.debug("\nPort charge Invoice Creation [setInsertList] Call e n d =========================================");
	}

	/**
	 * Invoice Condition Setting
	 * @param InvAuditDataValidVO vo
	 * @param PsoChgDtlVO vo1
	 */
	private void setInvCondDesc(InvAuditDataValidVO vo, PsoChgDtlVO vo1) {

		StringBuilder sb = new StringBuilder("<o>");
		sb.append("<o86>" + vo.getNight() + "</o86>");
		sb.append("<o75>" + vo.getHoliday() + "</o75>");
		sb.append("<o17>" + vo.getBoat() + "</o17>");
		sb.append("<o110>" + vo.getTugrope() + "</o110>");
		sb.append("<o57>" + vo.getBuoy() + "</o57>");
		sb.append("<o97>" + vo.getSanitation() + "</o97>");
		sb.append("<o52>" + vo.getBarge() + "</o52>");
		sb.append("<o78>" + vo.getInspection() + "</o78>");
		sb.append("<o8>" + vo.getArrtp() + "</o8>");
		sb.append("<o9>" + vo.getDeptp() + "</o9>");
		sb.append("<o6>" + vo.getArrnt() + "</o6>");
		sb.append("<o7>" + vo.getDepnt() + "</o7>");
		sb.append("<o10>" + vo.getArrtuh() + "</o10>");
		sb.append("<o11>" + vo.getDeptuh() + "</o11>");
		sb.append("<o50>" + vo.getArrlh() + "</o50>");
		sb.append("<o60>" + vo.getDeplh() + "</o60>");
		sb.append("<o111>" + vo.getUsdhrs() + "</o111>");
		sb.append("<o119>" + vo.getNewservice() + "</o119>");
		sb.append("<o125>" + vo.getCopilot() + "</o125>");
		sb.append("<o114>" + vo.getSdr() + "</o114>");
		sb.append("<o115>" + vo.getTier() + "</o115>");
		sb.append("<o116>" + vo.getLimitTime() + "</o116>");
		sb.append("<o170>" + vo.getOthers() + "</o170>");
		sb.append("<o171>" + vo.getOtherValue() + "</o171>");
		sb.append("</o>");
		vo1.setInvCondDesc(sb.toString());
	}

	/**
	 * VOP_PSO_0014 : Retrieve Button Click <br/>
	 * Retrieve in case of clicking Invoice Creation & Audit page Retrieve
	 * Button <br />
	 * 
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws EventException
	 */
	public List<InvAuditDataValidVO> searchGenInvAudit(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchGenInvAudit(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Handle in case of clicking Invoice Creation & Audit page Delete Button .<br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @throws EventException
	 */
	public void removeGenInvAudit(String vndrSeq, String ydCd, String invNo) throws EventException {
		try {
			/*
			int delCnt = 0;
			delCnt = dbDao.removeInvChargeDetail(vndrSeq, ydCd, invNo);
			delCnt = dbDao.removeInvCharge(vndrSeq, ydCd, invNo);
			delCnt += 0;
			*/
			dbDao.removeInvChargeDetail(vndrSeq, ydCd, invNo);
			dbDao.removeInvCharge(vndrSeq, ydCd, invNo);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}

	}

	/**
	 * VOP_PSO_0014 : Grid Account Cd Change <br />
	 * Handle in case of changing Account Code on gied in Invoice Creation &
	 * Audit page<br />
	 * 
	 * @category VOP_PSO_0014_VvdLevelCheck
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdLevel(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.checkVvdLevel(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Retrieve Info which will be saved to AP_PAY_INV VO in case of clicking
	 * Confirm button on Invoice Creation & Audit page <br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInv(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchApPayInv(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Retrieve Info which will be saved to AP_PAY_INV_DTL VO in case of
	 * clicking Confirm button on Invoice Creation & Audit page<br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[]
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchApPayInvDtl(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * renew INV_RGST_NO and STATUS CD in case of clicking confirm button on
	 * Invoice Creation & Audit page<br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @throws EventException
	 */
	public void updatePsoCharge(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			dbDao.modifyPsoChargeStaus(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Check existence of CSR No. in case of clicking delete button on Invoice
	 * Creation & Audit page <br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClickCSRNoCheck
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkApPayInv(String vndrSeq, String ydCd, String invNo) throws EventException {
		try {
			return dbDao.checkApPayInv(vndrSeq, ydCd, invNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * Change Local Amount value to USD
	 * 
	 * @param String strLocalAmt
	 * @param String currCd
	 * @param String revYrmon
	 * @param String type
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String getUsdAmt(String strLocalAmt, String currCd, String revYrmon, String type) throws EventException {
		try {
			if (type.equals("B"))
				return dbDao.getUsdAmtBudget(strLocalAmt, currCd, revYrmon);
			else
				return dbDao.getUsdAmt(strLocalAmt, currCd, revYrmon, type);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * Check whether port of VVD chosen is Turning Port
	 * 
	 * @param String hvvd
	 * @param String tmnlCode
	 * @param String clptIndSeq
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode, String clptIndSeq) throws EventException {
		try {
			return dbDao.checkTurningPort(hvvd, tmnlCode, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
	 * VOP_PSO-0014 Check existence of INV No. input
	 * 
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param String vndrSeq
	 * @param String invNo
	 * @param String dftVslCd
	 * @return PsoChargeVO
	 * @throws EventException
	 */
	public PsoChargeVO checkInvNo(String vndrSeq, String invNo, String dftVslCd) throws EventException {
		try {
			List<PsoChargeVO> lst = dbDao.isExistPsoCharge("0", vndrSeq, invNo);
			if ( null != lst && lst.size() > 0) {
				PsoChargeVO vo = lst.get(0);
				
				return vo;
			} else {
				return null;
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Tariff of latest version
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<TariffInfoVO>
	 * @throws EventException
	 */
	public List<TariffInfoVO> getTariff(SimulationConditionVO simulationConditionVO) throws EventException {
		try {
			return dbDao.getTariff(simulationConditionVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Tariff" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Tariff" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Objects which construct Formula/Condition used in Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<SimulationObjectListVO>
	 * @throws EventException
	 */
	public List<SimulationObjectListVO> searchObjectBySimulation(SimulationConditionVO simulationConditionVO) throws EventException {
		try {
			return dbDao.searchObjectBySimulation(simulationConditionVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Tariff" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Tariff" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Invoice Detail
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO[] simulationConditionVOs
	 * @return List<SimulationInvoiceListVO>
	 * @throws EventException
	 */
	public List<SimulationInvoiceListVO> searchInvoiceBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs) throws EventException {
		try {
			List<SimulationInvoiceListVO> list1 = new ArrayList<SimulationInvoiceListVO>();
			for (int k = 0; k < simulationConditionVOs.length; k++) {
				List<SimulationInvoiceListVO> list2 = dbDao.searchInvoiceBySimulation(simulationConditionVO, simulationConditionVOs[k]);
				list1.addAll(list2);
			}
			return list1;
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Invoice Detail" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Invoice Detail" }).getMessage(), ex);
		}
	}

	/**
	 * Get DefaultValue of Auto Object
	 * 
	 * @category VOP_PSO_0038_setAutoObjectDfltVal
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO simulationConditionVO2
	 * @param List<SimulationObjectListVO> objectsList
	 * @throws EventException
	 */
	public void setAutoObjectDfltVal(SimulationConditionVO simulationConditionVO, SimulationConditionVO simulationConditionVO2, List<SimulationObjectListVO> objectsList) throws EventException {
		String vvd = simulationConditionVO.getVslCd() + simulationConditionVO.getSkdVoyNo() + simulationConditionVO.getSkdDirCd();

		if ((vvd.equals("") || vvd.length() < 9) && (simulationConditionVO.getVslCd() == null || simulationConditionVO.getVslCd().equals("")))
			return;
		CalcTariffVO calcTariffVO = new CalcTariffVO();
		String ydCd = simulationConditionVO.getPortCd() + simulationConditionVO.getYardCd();
		// String lgsCostCd = simulationConditionVO.getCostCd();
		String lgsCostCd = simulationConditionVO2.getCostCd();
		String ydChgNo = simulationConditionVO2.getYdChgNo();
		String ydChgVerSeq = simulationConditionVO2.getYdChgVerSeq();

		String clptIndSeq = simulationConditionVO.getClptIndSeq();
		//2016.04.26 Double calling port Add 조건 추가 : clptIndSeq 가 존재 하지 않을때 MIN 으로 재조회 한다.
		if(StringUtils.isEmpty(clptIndSeq)){
			try {
				clptIndSeq = dbDao.selectClptIndSeq(vvd, ydCd);// expr
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[] { "setAutoObjectDfltVal : selectClptIndSeq" }).getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[] { "setAutoObjectDfltVal : selectClptIndSeq" }).getMessage(), ex);
			}
		}

		log.debug("\n setAutoObjectDfltVal Before VVD Data vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]");
		//2016.04.06 Add : 버츄얼이 아닌 실제 VVD를 조회 한다. 
		//SCWT0022N|SGSIN04|1|SGSIN : vvd|ydcd|clptIndSeq|port
		String validVvd = getValidVvd(vvd, ydCd, clptIndSeq);
		if(!StringUtils.isEmpty(validVvd)){
			String arrayValidVvd[] = validVvd.split("\\|", 4);
			vvd 		= StringUtils.isEmpty(arrayValidVvd[0]) ? vvd 			: arrayValidVvd[0];
			ydCd 		= StringUtils.isEmpty(arrayValidVvd[1]) ? vvd 			: arrayValidVvd[1];
			clptIndSeq 	= StringUtils.isEmpty(arrayValidVvd[2]) ? clptIndSeq 	: arrayValidVvd[2];
		}
		log.debug("\n setAutoObjectDfltVal After VVD Data vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]");		
		
		String repVslCd = "";
		String cntrVslClssCapa = "";// calcTariffVO.getCntrVslClssCapa();
		try {
			repVslCd = dbDao.getRepVslCd(vvd, cntrVslClssCapa);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "setAutoObjectDfltVal : getRepVslCd" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "setAutoObjectDfltVal : getRepVslCd" }).getMessage(), ex);
		}

		String repVvd = "";
		if (repVslCd != null) {
			if (!repVslCd.equals("")) {
				repVvd = repVslCd + vvd.substring(4);
			} else {
				repVvd = vvd;
			}
		} else {
			repVvd = vvd;
		}

		int szList = 0;
		if (objectsList != null) {
			szList = objectsList.size();
		}
		if (szList > 0) {
			String strObjVal = "";
			int[] objNos = new int[szList];
			for (int i = 0; i < szList; i++) {
				SimulationObjectListVO vo = objectsList.get(i);
				objNos[i] = Integer.parseInt(vo.getObjListNo());

				strObjVal = "";
				if (vo.getDfltVal().equals("") || vo.getDfltVal() == null) {
					strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd, ydCd, lgsCostCd, ydChgNo, ydChgVerSeq, clptIndSeq, i, Integer.parseInt(vo.getObjListNo()), repVvd);
					if (strObjVal == null || strObjVal.equals("") || strObjVal.equals("0")) {
						log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null & Zero Value >> Replace Default Value[0,Y/N] Start================================");
						
						//2016.03.18 Default 0을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(0) 를 셋팅한다.
						String tmpStrObjVal = strObjVal;
						String tmpObjNoKey = objNos[i] + "";

						log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null & Zero Value >> getObjectValue ["+tmpObjNoKey+"]:=["+strObjVal+"] E n d.");
						
						HashMap<String, String> dftZeroAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_ZERO_ALLOW_OBJECT_NO);
						
						//2016.04.14 Default N Flag을 허용 하는 Object, ReqularValue가 존재 하지 않을시에는 위에서 구한 Value(N) 를 셋팅한다.
						HashMap<String, String> dftFlagAllowMap = BizComPsoUtil.getStringArrayToHashMap(PsoConstants.ARRAY_DEFAULT_FLAG_ALLOW_OBJECT_NO);
						
						if(dftZeroAllowMap.containsKey(tmpObjNoKey)){							
							log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null Value  >> Before Default Zero Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
							
							if(StringUtils.isEmpty(strObjVal)){
								if(StringUtils.isEmpty(tmpStrObjVal)){
									strObjVal = "0";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
								}else{
									strObjVal = tmpStrObjVal;
								}
							}							
							vo.setDfltVal(strObjVal);
							log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null Value  >> After Default Zero Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] E n d.");
						}else if(dftFlagAllowMap.containsKey(tmpObjNoKey)){				
							log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null Value  >> Before Default Flag Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] Start.");
							
							if(StringUtils.isEmpty(strObjVal)){
								if(StringUtils.isEmpty(tmpStrObjVal)){
									strObjVal = "'N'";//Before Object Value 가 "",null 일때는 디폴트로 0 셋팅.
								}else{
									strObjVal = tmpStrObjVal;
								}
							}
							vo.setDfltVal(strObjVal);
							log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null Value  >> After Default Flag Allow Object [" + tmpObjNoKey + "]:= Object Old Value ["+tmpStrObjVal+"]/ Reqular Value [" + strObjVal +"] E n d.");
						}else{
							vo.setDfltVal(vo.getRegVal());
							log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null Value  >> After Default Flag Allow Object [" + tmpObjNoKey + "]:= Object VO Regular Value ["+vo.getRegVal()+"] E n d.");
						}
						
						log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null & Zero Value >> Regular Value [" + tmpObjNoKey + "]:=[" + strObjVal +"]");
						log.debug("\nsetAutoObjectDfltVal [Zero & Flag]Null & Zero Value >> Replace Default Value[0,Y/N] E n d================================");
					} else {
						vo.setDfltVal(strObjVal);
					}
				}
			}
		}
	}

	/**
	 * Retrieve Service Providers which is applicable to Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<SimulationConditionVO>
	 * @throws EventException
	 */
	public List<SimulationConditionVO> searchProviderBySimulation(SimulationConditionVO simulationConditionVO) throws EventException {
		try {
			return dbDao.searchProviderBySimulation(simulationConditionVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Account used in Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<CostListVO>
	 * @throws EventException
	 */
	public List<CostListVO> searchAccountBySimulation(SimulationConditionVO simulationConditionVO) throws EventException {
		try {
			return dbDao.searchAccountBySimulation(simulationConditionVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve tariff converted to exchange rate
	 * 
	 * @category VOP_PSO_0014_Calculation
	 * @param String div
	 * @param String amt
	 * @param String dt
	 * @param String currCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchConvertedAmount(String div, String amt, String dt, String currCd) throws EventException {
		try {
			return dbDao.searchConvertedAmount(div, amt, dt, currCd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Exchange Rate" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Exchange Rate" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve tariff converted to exchange rate
	 * 2016.08.17 Add
	 * Local to Local 환율 계산 추가.
	 * 
	 * @category VOP_PSO_0014_Calculation
	 * @param String div
	 * @param String amt
	 * @param String dt
	 * @param String frCurrCd
	 * @param String toCurrCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchConvertedInvoiceAmount(String div, String amt, String dt, String frCurrCd, String toCurrCd) throws EventException {
		try {
			return dbDao.searchConvertedInvoiceAmount(div, amt, dt, frCurrCd, toCurrCd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Exchange Rate" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Exchange Rate" }).getMessage(), ex);
		}
	}

	/**
	 * case 132://Loaded TEU at Last Port
	 * 
	 * @category Obj132_LoadedTeuLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getstrLoadedTeuLastPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getLoadedTeuLastPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj132_LoadedTeuLastPort" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj132_LoadedTeuLastPort" }).getMessage(), ex);
		}
	}

	/**
	 * case 146://Loaded TEU at Last Port1
	 * 
	 * @category Obj146_LoadedTeuLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getstrLoadedTeuLastPort1(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getLoadedTeuLastPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj145_LoadedTeuLastPort1" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj145_LoadedTeuLastPort1" }).getMessage(), ex);
		}
	}

	/**
	 * case 147:add new Object DEM/DET Holiday ETB (except Day)
	 * 
	 * @category Obj147_DemdetHolidayETB
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String searchDemdetHolidayETBExceptDay(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.searchDemdetHolidayETBExceptDay(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj147_DemdetHolidayETB" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj147_DemdetHolidayETB" }).getMessage(), ex);
		}
	}

	/**
	 * case 148:add new Object DEM/DET Holiday ETD (except Day)
	 * 
	 * @category Obj148_DemdetHolidayETD
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String searchDemdetHolidayETDExceptDay(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.searchDemdetHolidayETDExceptDay(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj148_DemdetHolidayETD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj148_DemdetHolidayETD" }).getMessage(), ex);
		}
	}

	/**
	 * case 148:add new Object DEM/DET Holiday ETA (except Day)
	 * 
	 * @category Obj148_DemdetHolidayETA
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String searchDemdetHolidayETAExceptDay(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.searchDemdetHolidayETAExceptDay(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj148_DemdetHolidayETD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj148_DemdetHolidayETD" }).getMessage(), ex);
		}
	}

	/**
	 * case 115://Tier
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getTier(String vvd, String ydCd) throws EventException {
		try {
			return dbDao.getTier(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		}
	}

	/**
	 * case 116://Limit Time
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getLimitTime(String vvd, String ydCd) throws EventException {
		try {
			return dbDao.getLimitTime(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		}
	}

	/**
	 * case 134://Vessel Volume
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getVesselVolumeCi(String vvd, String ydCd) throws EventException {
		try {
			return dbDao.getVesselVolumeCi(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		}
	}

	/**
	 * case 135://LOA * Beam
	 * 
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoaBeam(String vvd) throws EventException {
		try {
			return dbDao.getLoaBeam(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(), ex);
		}
	}

	/**
	 * case 136://ETB DAY
	 * 
	 * @category Obj65_ETBDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtbDay(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtbDay(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj136_ETBDay" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj136_ETBDay" }).getMessage(), ex);
		}
	}

	/**
	 * case 137://ETD DAY
	 * 
	 * @category Obj137_ETDDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtdDay(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtdDay(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj137_ETDDay" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj137_ETDDay" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve yard .
	 * 
	 * @category VOP_PSO_0038
	 * @param String portCd
	 * @param String issueDate
	 * @return List<SearchYardsVO>
	 * @exception EventException
	 */
	public List<SearchYardsVO> searchYardList(String portCd, String issueDate) throws EventException {
		try {
			return dbDao.searchYardList(portCd, issueDate);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Yard" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Yard" }).getMessage(), ex);
		}
	}

	/**
	 * case 154: Duration get P/F Duration of VVD
	 * 
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	public String getDuration(String vvd) throws EventException {
		try {
			return dbDao.getDuration(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj154_Duration" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj154_Duration" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve cost used in Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<CostListVO>
	 * @throws EventException
	 */
	public List<CostListVO> searchCostBySimulation(SimulationConditionVO simulationConditionVO) throws EventException {
		try {
			return dbDao.searchCostBySimulation(simulationConditionVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve object list
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO[] simulationConditionVOs
	 * @return List<SimulationObjectListVO>
	 * @throws EventException
	 */
	public List<SimulationObjectListVO> searchObjectListBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs) throws EventException {
		String pattern = "([0-9]+)";
		Pattern p = Pattern.compile(pattern);
		String uom = "";
		String dfltVal = "";
		List<SimulationObjectListVO> tmpObjectsList = null;
		List<SimulationObjectListVO> objectsList = new ArrayList<SimulationObjectListVO>();
		try {
			for (int k = 0; k < simulationConditionVOs.length; k++) {
				tmpObjectsList = searchObjectBySimulation(simulationConditionVOs[k]);
				setAutoObjectDfltVal(simulationConditionVO, simulationConditionVOs[k], tmpObjectsList);
				for (int i = 0; i < tmpObjectsList.size(); i++) {
					uom = tmpObjectsList.get(i).getPsoMeasUtCd();
					dfltVal = tmpObjectsList.get(i).getDfltVal();

					if ("16".equals(uom)) { // DAY
						Matcher m = p.matcher(dfltVal);
						dfltVal = "";
						while (m.find()) {
							dfltVal = m.group(1);
						}
					}
					tmpObjectsList.get(i).setDfltVal(dfltVal.replaceAll("'", ""));
				}
				objectsList.addAll(tmpObjectsList);
			}
			return objectsList;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		}
	}

	/**
	 * Calculation
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO sVO
	 * @param SimulationConditionVO[] sVOs
	 * @param SimulationObjectListVO[] autovos
	 * @param SimulationObjectListVO[] vos
	 * @return List<CalcTariffResultVO>
	 * @throws EventException
	 */
	public List<CalcTariffResultVO> calculateTariff(SimulationConditionVO sVO, SimulationConditionVO[] sVOs, SimulationObjectListVO[] autovos, SimulationObjectListVO[] vos) throws EventException {
		// int objNo = 0;
		List<CalcTariffResultVO> calcVOs = new ArrayList<CalcTariffResultVO>();
		try {

			CalcTariffVO calcTariffVO = new CalcTariffVO();

			for (int k = 0; k < sVOs.length; k++) {

				calcTariffVO.setVslCd		(sVO.getVslCd());
				calcTariffVO.setSkdVoyNo	(sVO.getSkdVoyNo());
				calcTariffVO.setSkdDirCd	(sVO.getSkdDirCd());
				calcTariffVO.setVvd			(sVO.getVslCd() + sVO.getSkdVoyNo() + sVO.getSkdDirCd());
				calcTariffVO.setYdChgNo		(sVOs[k].getYdChgNo());
				calcTariffVO.setChgVerSeq	(sVOs[k].getYdChgVerSeq());
				calcTariffVO.setYdCd		(sVO.getYardCd());
				calcTariffVO.setLgsCostCd	(sVOs[k].getCostCd());
				calcTariffVO.setCurrCd		(sVOs[k].getCurrCd());
				calcTariffVO.setIoFlag		("OUT");
				
				calcTariffVO.setClptIndSeq	(sVO.getClptIndSeq()); //2016.04.26 Double calling port Add
				
				if (autovos != null) {
					for (int i = 0; i < autovos.length; i++) {
						calcTariffVO.hMap.put("[" + autovos[i].getObjListNo() + "]", autovos[i].getDfltVal());
					}
				}
				if (vos != null) {
					for (int i = 0; i < vos.length; i++) {
						if (vos[i].getObjListNo().equals("77") && vos[i].getDfltVal().indexOf("Y") != -1) {// IN
							calcTariffVO.setIoFlag("IN");
						}
						if (vos[i].getObjListNo().equals("89") && vos[i].getDfltVal().indexOf("Y") != -1) {// OUT
							calcTariffVO.setIoFlag("OUT");
						}
						calcTariffVO.hMap.put("[" + vos[i].getObjListNo() + "]", vos[i].getDfltVal());
					}
				}

				calcTariffVO.setFrom("SIMULATION");//

				CalcTariffResultVO calcVo = calGeneralInvAudit(calcTariffVO);
				
				calcVo.setAcctCd		(sVOs[k].getAcctCd());
				calcVo.setCostCd		(sVOs[k].getCostCd());
				calcVo.setVndrSeq		(sVOs[k].getVndrSeq());
				calcVo.setVndrLglEngNm	(sVOs[k].getVndrLglEngNm());
				calcVo.setCurrCd		(sVOs[k].getCurrCd());

				String date 			= sVO.getIssueDate().replaceAll("-", "");
				String[] usdAmt = searchConvertedAmount("Local2USD", calcVo.getTariffAmount(), date, calcVo.getCurrCd());
				calcVo.setTariffUsdAmount(usdAmt[0]);

				calcVOs.add(calcVo);
			}
			return calcVOs;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Tariff Simulation By VVD
	 * 
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return List<TariffSimByVvdVO>
	 * @exception EventException
	 */
	public TariffGRPVO searchSimulationByVvd(TariffSimByVvdVO tariffSimByVvdVO) throws EventException {
		try {
			// VVD에 해당하는 yard 조회
			List<TariffSimByVvdVO> ydList = dbDao.searchYardsByVvd(tariffSimByVvdVO);

			List<SimulationConditionVO> trf = new ArrayList<SimulationConditionVO>();
			List<CalcTariffResultVO> calcRslt = null;
			List<CalcTariffResultVO> detailVOs = new ArrayList<CalcTariffResultVO>();

			TariffGRPVO tariffGRPVO = new TariffGRPVO();

			if (ydList != null) {
				TariffSimByVvdVO targetYd = null;
				for (int i = 0; i < ydList.size(); i++) {

					targetYd = ydList.get(i);

					targetYd.setVvd(tariffSimByVvdVO.getVvd());
					targetYd.setSrcPsoBztpCd(tariffSimByVvdVO.getSrcPsoBztpCd());

					// 해당 yard의 tariff 조회
					trf = dbDao.searchTariffByYards(targetYd);

					SimulationConditionVO[] sVOs = new SimulationConditionVO[trf.size()];
					SimulationConditionVO temp = null;
					if (trf != null) {
						for (int j = 0; j < trf.size(); j++) {
							temp = new SimulationConditionVO();
							temp.setYdChgNo(trf.get(j).getYdChgNo());
							temp.setYdChgVerSeq(trf.get(j).getYdChgVerSeq());
							temp.setAcctCd(trf.get(j).getAcctCd());
							// temp.setAcctEngNm(trf.get(j).getAcctEngNm());
							temp.setVndrSeq(trf.get(j).getVndrSeq());
							temp.setVndrLglEngNm(trf.get(j).getVndrLglEngNm());
							temp.setCurrCd(trf.get(j).getCurrCd());
							temp.setCostCd(trf.get(j).getCostCd());
							sVOs[j] = temp;
						}
					}

					SimulationConditionVO sVO = new SimulationConditionVO();
					sVO.setVslCd(tariffSimByVvdVO.getVvd().substring(0, 4));
					sVO.setSkdVoyNo(tariffSimByVvdVO.getVvd().substring(4, 8));
					sVO.setSkdDirCd(tariffSimByVvdVO.getVvd().substring(8, 9));
					sVO.setPortCd(targetYd.getVpsPortCd());
					sVO.setYardCd(targetYd.getYdCd().substring(5, 7));
					// if("1".equals(targetYd.getSrcPsoBztpCd())){
					// sVO.setBudget(true);
					// }

					// yard, trf 정보로 object 조회
					List<SimulationObjectListVO> objectsList = searchObjectListBySimulation(sVO, sVOs);

					String tempObj = null;

					// tariff simulation의 화면과 같이 12(FLAG), 14(CODE), 17(DAY),
					// 16(DATE)의 DfltVal 변환
					boolean bInOutCondition = false;
					for (int a = 0; a < objectsList.size(); a++) {

						// acct_cd가 all일 때는 IN & OUT 의 value는 "Y"
						if ("77".equals(objectsList.get(a).getObjListNo()) || "89".equals(objectsList.get(a).getObjListNo())) {
							objectsList.get(a).setDfltVal("Y");
							
							bInOutCondition = true; // [2016.01.29] COA Modify
						}

						tempObj = objectsList.get(a).getPsoMeasUtCd();

						if ("12".equals(tempObj) || "14".equals(tempObj) || "17".equals(tempObj)) {
							tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
							objectsList.get(a).setDfltVal("'" + tempObj + "'");
						} else if ("16".equals(tempObj)) {
							tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
							objectsList.get(a).setDfltVal("TO_DATE(" + "'" + tempObj + "'" + ", 'YYYYMMDD')");
						}

					}

					HashMap<String, SimulationObjectListVO> autoObjMap = new HashMap<String, SimulationObjectListVO>();
					HashMap<String, SimulationObjectListVO> manuObjMap = new HashMap<String, SimulationObjectListVO>();
					List<SimulationObjectListVO> autoObjectList = new ArrayList<SimulationObjectListVO>();
					List<SimulationObjectListVO> manualObjectList = new ArrayList<SimulationObjectListVO>();

					for (int m = 0; m < objectsList.size(); m++) {
						if ("A".equals(objectsList.get(m).getPsoObjListTpCd())) {
							autoObjMap.put(objectsList.get(m).getObjListNo(), objectsList.get(m));
						} else if ("M".equals(objectsList.get(m).getPsoObjListTpCd())) {
							manuObjMap.put(objectsList.get(m).getObjListNo(), objectsList.get(m));
						}
					}

					for (SimulationObjectListVO simulationObjectListVO : autoObjMap.values()) {
						autoObjectList.add(simulationObjectListVO);
					}

					for (SimulationObjectListVO simulationObjectListVO : manuObjMap.values()) {
						manualObjectList.add(simulationObjectListVO);
					}

					// Port와 Yard로 나눴던 부분 다시 합침
					sVO.setYardCd(targetYd.getYdCd());

					//sVO.setIssueDate(targetYd.getVpsEtbDt());
					sVO.setIssueDate(targetYd.getVpsEtdDt());

					// Calculation
					calcRslt = calculateTariff(sVO, sVOs, autoObjectList.toArray(new SimulationObjectListVO[autoObjectList.size()]), manualObjectList.toArray(new SimulationObjectListVO[manualObjectList.size()]));

					double ydTtlUsdAmt = 0;

					String portType = dbDao.searchPortType(targetYd);
					if ("TURNING".equals(portType)) {
						targetYd.setPortType("T");
					} else if ("VIRTUAL".equals(portType)) {
						targetYd.setPortType("V");
					} else {
						targetYd.setPortType("");
					}

					//int cnt = 0;
					for (int amtInd = 0; amtInd < calcRslt.size(); amtInd++) {

						log.debug("\n #### calcRslt Info ["+calcRslt.get(amtInd).toString()+"] ");
						if (calcRslt.get(amtInd).getTariffUsdAmount() != null && !"".equals(calcRslt.get(amtInd).getTariffUsdAmount())) {
							ydTtlUsdAmt = ydTtlUsdAmt + Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount());

							if (!"V".equals(targetYd.getPortType())) { // Detail 정보(Excel Download용)
								CalcTariffResultVO tempVO = new CalcTariffResultVO();
								//cnt++;
								tempVO.setYdCd(targetYd.getYdCd());
								tempVO.setAcctCd(calcRslt.get(amtInd).getAcctCd());
								tempVO.setAcctEngNm(calcRslt.get(amtInd).getAcctEngNm());
								
								// [2016.01.29] COA Modify
								/*if ("Y".equals(tariffSimByVvdVO.getExpRto())) {
									if(!bInOutCondition){
										log.debug("\n #### getExpRto = Y Detail inout 존재 하지 않고 bInOutCondition = false case.");
										tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount()) * 100) / 100.0);
									}else{
										log.debug("\n #### Detail inout 존재  bInOutCondition = true case.");
										//이미 In/Out 으로 계산된 금액임.
										tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount()) * 100) / 100.0);
									}
								} else {
									log.debug("\n #### getExpRto != Y Detail inout 존재  bInOutCondition = true case.");
									tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount()) * 100) / 100.0);
								}*/

								
								if ("Y".equals(tariffSimByVvdVO.getExpRto())) {
									tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount()) * 100) / 200.0);
								} else {
									tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount()) * 100) / 100.0);
								}
								detailVOs.add(tempVO);
							}
						}
					}
					log.debug("\n============================================="+
					          "\n getExpRto ["+tariffSimByVvdVO.getExpRto()+"]"+
							  "\n portType  ["+portType+"]"+
							  "\n bInOutCondition  ["+bInOutCondition+"]"+
							  "\n ydTtlUsdAmt  ["+ydTtlUsdAmt+"]"+
							  "\n getVvd  ["+targetYd.getVvd()+"]"+
							  "\n getYdCd  ["+targetYd.getYdCd()+"]"+
							  "\n============================================="
							  );
					// Expense Ratio 적용시 Port Type별로 구분
					if ("Y".equals(tariffSimByVvdVO.getExpRto())) {
						// Turning이거나 Virtual Port인 경우 해당 금액에 50%만 적용
						// Turning Port : O/B 50%
						// Virtual Port : I/B 50%
						// General Port : O/B 100%

						if ("TURNING".equals(portType)) {
							targetYd.setIbRatio("0");
							targetYd.setObRatio("50");
							//[2016.01.29] COA Modify
							targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt * 100) / 200.0);
						} else if ("VIRTUAL".equals(portType)) {
							targetYd.setIbRatio("50");
							targetYd.setObRatio("0");
							//[2016.01.29] COA Modify
							targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt * 100) / 200.0);
						} else {
							targetYd.setIbRatio("0");
							targetYd.setObRatio("100");
							targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt * 100) / 100.0);
						}
					} else {
						targetYd.setIbRatio("0");
						targetYd.setObRatio("100");
						targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt * 100) / 100.0);
					}
				}
				

				tariffGRPVO.setTariffSimByVvdVOs(ydList);
			}


			TariffGRPVO titleInfo = arrangeYardAcct(detailVOs);// detail 정보에서 yard(skd 순서) / acct(숫자순서) 정보를 각각 정렬하여 리턴
			tariffGRPVO.setYards(titleInfo.getYards());
			tariffGRPVO.setAccts(titleInfo.getAccts());
			tariffGRPVO.setCalcTariffResultVOs(detailVOs);

			return tariffGRPVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation By VVD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Simulation By VVD" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve whether the VVD applicable is for business plan or for Live
	 * business plan == 1 / Live == 2
	 * 
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdBztpCd(String vvd) throws EventException {
		try {
			return dbDao.searchVvdBztpCd(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "VVD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "VVD" }).getMessage(), ex);
		}
	}

	/**
	 * detail 정보에서 yard(skd순서) / acct(숫자순서) 정보를 각각 정렬하여 리턴
	 * 
	 * @param List<CalcTariffResultVO> calcTariffResultVOs
	 * @return TariffGRPVO
	 * @throws EventException
	 */
	private TariffGRPVO arrangeYardAcct(List<CalcTariffResultVO> calcTariffResultVOs) throws EventException {
		try {
			TariffGRPVO tariffGrpVO = new TariffGRPVO();

			Map<String, String> yardMap = new LinkedHashMap<String, String>();
			Map<String, String> acctMap = new TreeMap<String, String>();

			for (CalcTariffResultVO vo : calcTariffResultVOs) {
				String ydCd = vo.getYdCd();
				String acctCd = vo.getAcctCd();
				String acctEngNm = vo.getAcctEngNm();
				if (!yardMap.containsKey(ydCd)) {
					yardMap.put(ydCd, ydCd);
				}
				if (!acctMap.containsKey(acctCd)) {
					acctMap.put(acctCd, acctEngNm);
				}
			}

			tariffGrpVO.setYards(yardMap);
			tariffGrpVO.setAccts(acctMap);

			return tariffGrpVO;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Arranging Yard and Account" }).getMessage(), ex);
		}
	}

	/**
	 * case 155: Previous Port(TW) Retrieve which Vessel was docking the Taiwan
	 * within past 120 days by certain port docking date standard
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	public String getPreviousTaiwanPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getPreviousTaiwanPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj155_Previous Port(TW)" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj155_Previous Port(TW)" }).getMessage(), ex);
		}
	}
	
	/**
	 * case 156: Yearly Vessel Call Port
	 * 당해년도 특정 port의 모든 선박(feeder 제외)의 calling count
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCallPort(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getYearlyVesselCallPort(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj156_Yearly Vessel Call Port"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj156_Yearly Vessel Call Port"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 157: ETA Date
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtaDate(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getEtaDate(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj157_ETA Date"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj157_ETA Date"}).getMessage(),ex);
		}
	}
	
	/**
	 * 158: //Berthing Hour
	 * @category Obj158_BerthingHour(D-A)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getBerthingHourDA(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getBerthingHourDA(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj15_BerthingHour"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj15_BerthingHour"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 159://ETA DAY
	 * @category Obj159_ETADay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtaDay(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return  dbDao.getEtaDay(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj159_ETADay"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj159_ETADay"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 160://ETA Month
	 * @category Obj160_EtaMonth 
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getEtaMonth(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getEtaMonth(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj160_EtaMonth"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj160_EtaMonth"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 161://Inbound Volume(Ton) / Vessel Volume(FR)
	 * @category Obj161_InboundTon/VesselVolume(FR)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getInboundDivideVessel(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getInboundDivideVessel(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj161_InboundTon/VesselVolume(FR)"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj161_InboundTon/VesselVolume(FR)"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 162://Outbound Volume(Ton) / Vessel Volume(FR)
	 * @category Obj162_OutboundTon/VesselVolume(FR)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getOutboundDivideVessel(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getOutboundDivideVessel(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj162_OutboundTon/VesselVolume(FR)"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj162_OutboundTon/VesselVolume(FR)"}).getMessage(),ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save in case of clicking Invoice Creation & Audit page Retrieve
	 * Button <br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws EventException
	 */
	public List<InvAuditDataValidVO> searchGenInvAuditMaster(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchGenInvAuditMaster(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit Master" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invoice Creation & Audit Master" }).getMessage(), ex);
		}
	}
	
	/**
	 * 유저가 입력한 VVD의 Yard가 스킵인지 확인
	 * 
	 * @category VOP_PSO_0014_vvdCheckClick
	 * @param String vslCd  
	 * @param String skdVoyNo 
	 * @param String skdDirCd 
	 * @param String ydCd
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkSkipYardInVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		try {
			return dbDao.checkSkipYardInVvd(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}

	/**
	 * Obj Reqular Value(Default Value) 단건
	 * 
	 * @category Obj Reqular Value
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getRegularValueByObjNo(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException {
		try {
			return dbDao.getRegularValueByObjNo(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj Reqular Value" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj Reqular Value" }).getMessage(), ex);
		}
	}

	/**
	 * Obj Reqular Value(Default Value) Search.
	 * 
	 * @category Obj Reqular Value
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param List<String> objNoList
	 * @return Map<String, Object>
	 * @throws EventException
	 */
	public Map<String, Object> getRegularValueByObjectNoMap(String ydChgNo, String ydChgVerSeq, List<String> objNoList) throws EventException {
		try {
			return dbDao.getRegularValueByObjectNoMap(ydChgNo, ydChgVerSeq, objNoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj Reqular Value Map" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Obj Reqular Value Map" }).getMessage(), ex);
		}
	}


	/**
	 * Valid VVD를 조회 한다.
	 * 2016.04.06 Add.
	 * 
	 * @category common_ValidVvd
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getValidVvd(String vvd, String ydCd, String clptIndSeq) throws EventException {
		try {
			return dbDao.getValidVvd(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Valid_VVD" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : Valid_VVD" }).getMessage(), ex);
		}
	}
	
	/**
	 * case 174://Last Yard
	 * 2016.11.02 Add Object	
	 * @category Obj174_LastYard
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getLastYard(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getLastYard(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj174_LastYard"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj174_LastYard"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 175://Current Yard
	 * 2016.11.02 Add Object	
	 * @category Obj175_CurrentYard
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getCurrentYard(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getCurrentYard(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj175_CurrentYard"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj175_CurrentYard"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 176://Next Yard
	 * 2016.11.02 Add Object	
	 * @category Obj176_NextYard
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getNextYard(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getNextYard(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj176_NextYard"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj176_NextYard"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 177://Double Call
	 * 2016.11.02 Add Object	
	 * @category Obj177_DoubleCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getDoubleCall(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getDoubleCall(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj177_DoubleCall"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj177_DoubleCall"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 178://Port Seq
	 * 2016.11.02 Add Object	
	 * @category Obj178_PortSeq
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws EventException
	 */
	private String getPortSeq(String vvd, String ydCd, String clptIndSeq) throws EventException{
		try {
			return  dbDao.getPortSeq(vvd, ydCd, clptIndSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj178_PortSeq"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj178_PortSeq"}).getMessage(),ex);
		}
	}
	
	/**
	 * Object Test Method.
	 * 
	 * @param HashMap<String, Object> map
	 * @return HashMap<String, Object>
	 * @throws EventException
	 */
	public HashMap<String, Object> getObjectTestValue(HashMap<String, Object> map)  throws EventException {
		HashMap<String, Object> rtnMap = new HashMap<String, Object>();
		
		Integer iObj 		= (Integer) map.get("objNo");
		String  vvd  		= (String ) map.get("vvd");
		String  ydCd 	 	= (String ) map.get("ydCd");
		String  clptIndSeq  = (String ) map.get("clptIndSeq");
		String  lgsCostCd  	= (String ) map.get("lgsCostCd");
	
		try {
			if(StringUtils.isEmpty(clptIndSeq)){
				clptIndSeq = dbDao.selectClptIndSeq(vvd, ydCd);// expr
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : selectClptIndSeq" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Calculation : selectClptIndSeq" }).getMessage(), ex);
		}
		
		log.debug("\n Before VVD Data vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]");
		//2016.04.06 Add : 버츄얼이 아닌 실제 VVD를 조회 한다. 
		//SCWT0022N|SGSIN04|1|SGSIN : vvd|ydcd|clptIndSeq|port
		String validVvd = getValidVvd(vvd, ydCd, clptIndSeq);
		if(!StringUtils.isEmpty(validVvd)){
			String arrayValidVvd[] = validVvd.split("\\|", 4);
			vvd 		= StringUtils.isEmpty(arrayValidVvd[0]) ? vvd 			: arrayValidVvd[0];
			ydCd 		= StringUtils.isEmpty(arrayValidVvd[1]) ? vvd 			: arrayValidVvd[1];
			clptIndSeq 	= StringUtils.isEmpty(arrayValidVvd[2]) ? clptIndSeq 	: arrayValidVvd[2];
		}
		log.debug("\n After VVD Data vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]");	
		
		
		log.debug("\n############################# getObjectTestValue #########################"+
		          "\n iObj ["+iObj+"] vvd ["+vvd+"] ydCd ["+ydCd+"] clptIndSeq ["+clptIndSeq+"]"+
				  "\n############################# getObjectTestValue #########################");
		
		String strObjVal	= "";
		switch(iObj){
			case 2: //Arrival Draft Feet
				strObjVal = getArvDrftFeet(vvd, ydCd, clptIndSeq);
				break;				
			case 3: // Departure Draft Meter
			case 25: // Departure Draft1 Meter
				strObjVal = getDprDftMeter(vvd, ydCd, clptIndSeq);
				break;
			case 6: // Arrival No. of Tug
				strObjVal = getArvNoOfTug(vvd, ydCd, clptIndSeq);
				break;
			case 7: // Departure No. of Tug
				strObjVal = getDprNoOfTug(vvd, ydCd, clptIndSeq);
				break;
			case 15: // Berthing Hour(D-B)
				strObjVal = getBerthingHour(vvd, ydCd, clptIndSeq);
				break;
			case 23:// Country of Last Port
				strObjVal = getCntLastPort(vvd, ydCd, clptIndSeq);
				break;
			case 24:// Country of Next Port
				strObjVal = getCntNextPort(vvd, ydCd, clptIndSeq);
				break;
			case 26: // Departure Draft Feet
				strObjVal = getDprDftFeet(vvd, ydCd, clptIndSeq);
				break;
			case 27:// Garbage Volume
				strObjVal = getGarbageVol(vvd, ydCd, clptIndSeq);
				break;
			case 32:// Inbound Volume
				strObjVal = getInboundVolume(vvd, ydCd, clptIndSeq);
				break;
			case 33:// Outbound Volume
				strObjVal = getOutboundVolume(vvd, ydCd, clptIndSeq);
				break;
			case 37:// Anchoring Hour
				strObjVal = getAnchoringHour(vvd, ydCd, clptIndSeq);
				break;
			case 40: // Sludge Volume
				strObjVal = getSludgeVol(vvd, ydCd, clptIndSeq);
				break;
			case 47:// Arrival Draft Meter
				strObjVal = getArvDrftMeter(vvd, ydCd, clptIndSeq);
				break;
			case 48:// Arrival Draft 1 Meter
				strObjVal = getArvDrftOneMeter(vvd, ydCd, clptIndSeq);
				break;
			case 49:// Arrival Draft1 Feet
				strObjVal = getArvDrftOneFeet(vvd, ydCd, clptIndSeq);
				break;
			case 51:// Arrival POB
				strObjVal = getArrPob(vvd, ydCd, clptIndSeq);
				break;
			case 61://Departure POB
				strObjVal = getDepPob(vvd, ydCd, clptIndSeq);
				break;
			case 65:// ETB(DT)
				strObjVal = getEtbDate(vvd, ydCd, clptIndSeq);
				break;
			case 66:// ETB Month
				strObjVal = getEtbMonth(vvd, ydCd, clptIndSeq);
				break;
			case 67:// ETB Time
			case 68:// ETB1 Time
				strObjVal = getEtbTime(vvd, ydCd, clptIndSeq);
				break;
			case 69:// ETD Date
				strObjVal = getEtdDate(vvd, ydCd, clptIndSeq);
				break;
			case 70:// ETD Month
				strObjVal = getEtdMonth(vvd, ydCd, clptIndSeq);
				break;
			case 71:// ETD Time
			case 72:// ETD1 Time
				strObjVal = getEtdTime(vvd, ydCd, clptIndSeq);
				break;
			case 76:// I/B Volume/Blocksize
				strObjVal = getIBVolBsz(vvd, ydCd, clptIndSeq);
				break;
			case 79:// last Issued Invoice ETD
				strObjVal = getLastInvEtd(vvd, ydCd, clptIndSeq, lgsCostCd);
				break;
			case 80:// LastPort
				strObjVal = getLastPort(vvd, ydCd, clptIndSeq);
				break;
			case 85:// Next Port
				strObjVal = getNextPort(vvd, ydCd, clptIndSeq);
				break;
			case 90:// Pilot Off
				strObjVal = "'" + getPOff(vvd, ydCd, clptIndSeq) + "'";
				break;
			case 91:// POB(T)
				strObjVal = "'" + getPob(vvd, ydCd, clptIndSeq) + "'";
				break;
			case 92:// Rehandling Volume
				strObjVal = getRhVol(vvd, ydCd, clptIndSeq);
				break;
			case 93:// Remain Vessel Call
				strObjVal = getRemainVesselCall(vvd, ydCd, clptIndSeq);
				break;
			case 94:// Monthly Vessel Call
				strObjVal = getMonthlyVesselCall(vvd, ydCd, clptIndSeq);
				break;
			case 96:// Yearly Vessel Call
				strObjVal = getYearlyVesselCall(vvd, ydCd, clptIndSeq);
				break;
			case 112:// Water Volume
				strObjVal = getWatVol(vvd, ydCd, clptIndSeq);
				break;
			case 120:// DEM/DET Holiday(ETB)
				strObjVal = getDemdetHolidayETB(vvd, ydCd, clptIndSeq);
				break;
			case 121:// DEM/DET Holiday(ETD)
				strObjVal = getDemdetHolidayETD(vvd, ydCd, clptIndSeq);
				break;
			case 123:// ETB(H)
				strObjVal = getEtbHr(vvd, ydCd, clptIndSeq);
				break;
			case 124:// ETD(H)
				strObjVal = getEtdHr(vvd, ydCd, clptIndSeq);
				break;
			case 126:// I/B (TON)
				strObjVal = getInboundTon(vvd, ydCd, clptIndSeq);
				break;
			case 127:// O/B (TON)
				strObjVal = getOutboundTon(vvd, ydCd, clptIndSeq);
				break;
			case 128:// RH (TON)
				strObjVal = getRhTon(vvd, ydCd, clptIndSeq);
				break;
			case 129:// ETA (H)
				strObjVal = getEtaHour(vvd, ydCd, clptIndSeq);
				break;
			case 130:// Cargo Volume(Ton)
				strObjVal = getCargoVolumeTon(vvd, ydCd, clptIndSeq);
				break;
			case 132:// Loaded TEU At Last Port
				strObjVal = getstrLoadedTeuLastPort(vvd, ydCd, clptIndSeq);
				break;
			case 146:// Loaded TEU At Last Port 1
				strObjVal = getstrLoadedTeuLastPort1(vvd, ydCd, clptIndSeq);
				break;
			case 133:// Yearly Vessel Call Lane
				strObjVal = getYearlyVesselCallLane(vvd, ydCd, clptIndSeq);
				break;
			case 136:// ETB Day
				strObjVal = getEtbDay(vvd, ydCd, clptIndSeq);
				break;
			case 137:// ETD Day
				strObjVal = getEtdDay(vvd, ydCd, clptIndSeq);
				break;
			case 147:// DEM/DET Holiday ETB (except Day)
				strObjVal = searchDemdetHolidayETBExceptDay(vvd, ydCd, clptIndSeq);
				break;
			case 148:// DEM/DET Holiday ETD (except Day)
				strObjVal = searchDemdetHolidayETDExceptDay(vvd, ydCd, clptIndSeq);
				break;
			case 149:// ETA Time
			case 150:// ETA1 Time
				strObjVal = getEtaTime(vvd, ydCd, clptIndSeq);
				break;
			case 152:// DEM/DET Holiday(ETA)
				strObjVal = getDemdetHolidayETA(vvd, ydCd, clptIndSeq);
				break;
			case 153:// DEM/DET Holiday ETA (except Day)
				strObjVal = searchDemdetHolidayETAExceptDay(vvd, ydCd, clptIndSeq);
				break;
			case 155: // Previous Port(TW)
				strObjVal = getPreviousTaiwanPort(vvd, ydCd, clptIndSeq);
				break;
			case 156: // Yearly Vessel Call Port
				strObjVal = getYearlyVesselCallPort(vvd, ydCd, clptIndSeq);
				break;
			case 157: // ETA Date
				strObjVal =  getEtaDate(vvd, ydCd, clptIndSeq);
				break;
			case 158: // Berthing Hour(D-A)
				strObjVal = getBerthingHourDA(vvd, ydCd, clptIndSeq);
				break;
			case 159: // ETA Day
				strObjVal = getEtaDay(vvd, ydCd, clptIndSeq);
				break;
			case 160:// ETA Month
				strObjVal = getEtaMonth(vvd, ydCd, clptIndSeq);
				break;
			case 161:// Inbound Volume(Ton) / Vessel Volume(FR)
				strObjVal = getInboundDivideVessel(vvd, ydCd, clptIndSeq);
				break;
			case 162:// Outbound Volume(Ton) / Vessel Volume(FR)
				strObjVal = getOutboundDivideVessel(vvd, ydCd, clptIndSeq);
				break;
			case 166: //Berthing Date(D-B)
	    	   strObjVal = getBerthingDate(vvd, ydCd, clptIndSeq);
	    	   break;
	    	   
			case 174: //Last Yard
		    	   strObjVal = getLastYard(vvd, ydCd, clptIndSeq);
		    	   break;
			case 175: //Current Yard 
		    	   strObjVal = getCurrentYard(vvd, ydCd, clptIndSeq);
		    	   break;
			case 176: //Next Yard
		    	   strObjVal = getNextYard(vvd, ydCd, clptIndSeq);
		    	   break;
			case 177: //Double Call
		    	   strObjVal = getDoubleCall(vvd, ydCd, clptIndSeq);
		    	   break;
			case 178: //Port Seq
		    	   strObjVal = getPortSeq(vvd, ydCd, clptIndSeq);
		    	   break;
		}

		rtnMap.put("dftValue", strObjVal);
		return rtnMap;
	}
	
	/**
	 * 2016.12.19 Add
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD가 기존 입력된 Invoice가 있는지 체크
	 * 
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<String> 
	 * @exception EventException
	 */
	public List<String> checkDoublePayInv(InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.checkDoublePayInv( invAuditDataValidVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
}