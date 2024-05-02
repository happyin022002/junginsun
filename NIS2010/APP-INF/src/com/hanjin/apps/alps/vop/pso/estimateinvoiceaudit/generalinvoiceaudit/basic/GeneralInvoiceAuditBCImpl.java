/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditBCImpl.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.16 김진일
* 1.0 Creation
* 
* History
* 
* 2010.08.25 진마리아 CHM-201005567-01 신규 Object(133) 생성 요청(Yearly Vessel Call(S/L))
* 2010.08.31 진마리아 CHM-201005695-01 Limit Time 및 Tier Object 로직 변경
* 2010.10.04 진마리아 CHM-201006224-01 신규 Object(135) 생성 요청(LOA * Beam)
* 2010.10.13 진마리아 CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
* 2010.11.25 유혁 CHM-2010 신규 Object(145) 추가(Loaded TEU At Last Port 1)
* 2010.11.25 진마리아 CHM-201007037-01 Meter를 Feet로 환산하는 로직을 변경한다.
* 2010.12.09 이석준 CHM-201007132-01 신규 Object DEM/DET Holiday ETB/ETD (except Day) 추가
* 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
* 2011.07.04 진마리아 CHM-201111567-01 신규 Object(152, 153) 생성
* 2011.07.18 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
* 2011.07.28 진마리아 CHM-201111838-01 R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 - 태깅을 위해 일부소스(searchVvdBztpCd) 주석처리
* 2011.09.29 진마리아 CHM-201113488-01 [VOP-VSK] 신규 Object 등록 요청 (Previous Port(TW))
* 2012.01.10 진마리아 선처리(SRM-201222935) invoice creation 화면 오픈시 미 Confirm된 Invoice List Notice 메시지 alert
* 2012.02.16 진마리아 CHM-201215933-01 신규 Object 추가 요청건 - Yearly Vessel Call(Port)
* 2012.02.16 진마리아 CHM-201216004-01 신규 Object 생성 요청 - ETA(DT), ETA(M), ETA(DY), Berthing Hour(D-A), InboundVolume(Ton)/VesselVolume(FR), OutboundVolume(Ton)/VesselVolume(FR)
* 2012.07.24 진마리아 CHM-201218370-01 계산되는 formula description 의 자릿수를 제한한다. (추정시 에러나지 않도록)
* 2012.07.27 유혁 surcharge 작업
* 2012.08.01 진마리아 CHM-201219306-01 CHM-201218370-01(7/24 커밋) 반영을 위한 surcharge부분 원복
* 2012.08.02 진마리아 CHM-201219306-01 surcharge 반영
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
* 2012.11.19 이혜민   CHM-201221185-01 [PSO] 항비 입력시 skip port 에 대한 pop up 메시지 추가 요청
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
* 2013.01.24 SKY    CHM-201322525    Invoice creation 중복 account code 체크 로직 추가
* 2014.03.18 이윤정 CHM-201429129 [PSO] Tariff simulation 로직 수정 - Inboud regular value
* 2014.05.30 박다은 CHM-201430328 [PSO] Port Charge invoice Creation 기능 개선
* 2014.06.27 이윤정 CHM-201429607 [PSO] New Object 생성 요청 (ESIscore)
* 2014.06.27 이윤정 CHM-201429888 [PSO] New Object - Berthing Date
* 2014.06.27 이윤정 CHM-201430610 [PSO] New OBject Creation (SCGT)
* 2014.07.18 이윤정 CHM-201430973 [PSO] New Object (Bow Thrust Power)
* 2014.08.05 이성훈 HJSBIZ_CR_671 [PSO] Invoice내 Exchanage Rate 칼럼 추가
* 2015.02.12 김기원 CHM-201534260 [PSO] Invoice 비용 배분 및 Tariff Cost 생성 로직 변경
* 2015.03.17 김기원 CHM-201534621 tonnage 관련 로직 추가
* 2015.05.13 김기원 CHM-201535833 [PSO] USD이외의 Local 환율적용에 따른 exchange Rate 적용
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration.GeneralInvoiceAuditDBDAO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.ExpressionListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.IoRatioVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.RoundTruncVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TermDueVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TpbIfVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.PsoChargeVO;
import com.hanjin.syscommon.common.table.PsoChgDtlVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 * - ALPS-EstimateInvoiceAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0018EventResponse,GeneralInvoiceAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class GeneralInvoiceAuditBCImpl extends BasicCommandSupport implements GeneralInvoiceAuditBC {

	// Database Access Object
	private transient GeneralInvoiceAuditDBDAO dbDao = null;

	//[jmh]
	//HashMap<String, String> MAP_OBJ_VAL = new HashMap<String, String>();
	
	/**
	 * GeneralInvoiceAuditBCImpl 객체 생성<br>
	 * GeneralInvoiceAuditDBDAO를 생성한다.<br>
	 */
	public GeneralInvoiceAuditBCImpl() {
		dbDao = new GeneralInvoiceAuditDBDAO();
		//initMapObjVal();
	}
	
	/**
	 * parameterized constructor
	 * @param dataSource
	 */
	public GeneralInvoiceAuditBCImpl(String dataSource) {
		dbDao = new GeneralInvoiceAuditDBDAO(dataSource);
		//initMapObjVal();
	}
	
	/**jmh
	 * @param 
	 */
	//private void initMapObjVal(){
	//	MAP_OBJ_VAL.put("53", "");	//Base Constant
	//	MAP_OBJ_VAL.put("54", "");	//Base Constant1
	//}
	
	/**
	 * 입력된 키값 및 매개변수값을 이용하여 Tariff계산을 실행한다.
	 * @category TariffCalcEngine
	 * @param CalcTariffVO calcTariffVO
	 * @return CalcTariffResultVO
	 * @throws EventException
	 */
	public CalcTariffResultVO calGeneralInvAudit(CalcTariffVO calcTariffVO) throws EventException {
		
		int rowsNumberOfDesc = 0;	//[2010.04.21:jmh] 줄 수가 3이면 에 따라 그리드의 Row Height를 늘려주기 위해 Descript뒤에 \n를 하나 추가한다.
 		CalcTariffResultVO vo = new CalcTariffResultVO();
 		String flag = "Y";
 		/*
		hMap.put("vndrSeq", event.getPayTo());//vendor_seq
				hMap.put("vvd", event.getVvd());//vvd
				hMap.put("ydCd", vo.getYdCd());//YD_CD
				hMap.put("callSeq", vo.getCallSeq());// CallSeq
				hMap.put("lgsCostCd",vo.getLgsCostCd());//Logistics COde
				hMap.put("ydChgNo", vo.getYdChgNo());
				hMap.put("ydChgVerSeq", vo.getYdChgVerSeq());
				hMap.put("sysexpr", vo.getSysXprDesc());
				hMap.put("dspexpr", vo.getDfltXprDesc());
		*/
//		String lgsCostCd = map.get("lgsCostCd");
//		lgsCostCd += lgsCostCd;
		List<ExpressionListVO> list=null;
		//
		try {
			//Sorting : B, S, D
			list =  dbDao.searchExpression(calcTariffVO.getYdChgNo(), calcTariffVO.getYdChgVerSeq());// 들어온. YD,
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : searchExpression"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : searchExpression"}).getMessage(),ex);
		}
		
//		float fval = 0;
//		float fval2 = 0;//Surcharge의 값을 유지하기 위한 변수
		BigDecimal fval = new BigDecimal("0");
		BigDecimal fval2 = new BigDecimal("0");
		
		
		CalcTariffResultVO resultvo = null;
		StringBuilder dspSb = new StringBuilder();
		StringBuilder runSb = new StringBuilder();
		for(int i=0; i<list.size();i++){
			ExpressionListVO listvo = list.get(i);
//			map.put("CalcType", listvo.getPsoChgTpCd());
			calcTariffVO.setCalcType(listvo.getPsoChgTpCd());
			try{
				if(listvo.getSysXprDesc()!=null){
					if(!listvo.getSysXprDesc().equals(""))
//						if(listvo.getValflg().equals("Y"))
						log.debug(">>------------------->[Tariff Error Start]");
						log.debug("vvd:="+calcTariffVO.getVvd());
						log.debug("ydCd:="+calcTariffVO.getYdCd());
						log.debug("ydChgNo:="+calcTariffVO.getYdChgNo());
						log.debug("ydChgVerSeq:="+calcTariffVO.getYdChgVerSeq());
						log.debug("chgXprNo:="+listvo.getChgXprNo());
						log.debug("<-------------------<<[Tariff Error End]");
							resultvo = calcTariff(calcTariffVO, listvo);//.getSysXprDesc(), listvo.getDfltSysXprUsrDesc(), listvo.getDfltSysXprValDesc(), listvo.getDfltSysXprDesc());
//						else{
//						}
				}
			}
			catch (Exception ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : calcTariff"}).getMessage(),ex);
			}
			
			if(resultvo!=null){
				//>>[2010.03.02:jmh]
				//log.debug("\n>> Type : " + listvo.getPsoChgTpCd());
				//log.debug("\n>> Amount : " + resultvo.getTariffAmount());
				//<<[2010.03.02:jmh]
				if(!resultvo.getTariffAmount().equals("")
						&&!resultvo.getTariffAmount().equals("empty")
						&&resultvo.getTariffAmount()!=null){
					//합계는 Sum하고 
					if(listvo.getPsoChgTpCd().equals("D")) //Discount -= 
						fval  = fval.subtract(new BigDecimal(resultvo.getTariffAmount()));
					else{
						fval2 = new BigDecimal(resultvo.getTariffAmount());
				        fval = fval.add(fval2);
                	}
					//2015.02.09 추가 
					if("B".equals(listvo.getPsoChgTpCd()) && "0".equals(resultvo.getTariffAmount())) // BASE 가 0 이면 SURCHARGE / DISCOUNT 는 무조건 계산 안됨													
					{													
						flag ="N";												
					}													

					if(listvo.getPsoChgTpCd().equals("B")){
						dspSb.append("[B]: "+ resultvo.getDisplayFormulaDesc());
						runSb.append("[B]: "+ resultvo.getRuntimeFormulaDesc());
						//S와 D에서 사용하도록 B의 값을 저장 Base에 대한 Input 정보 제공
//						map.put("Base", fval+"");
					    calcTariffVO.setBase(fval+"");
						rowsNumberOfDesc++;	//[2010.04.21:jmh]
					}
					else if(listvo.getPsoChgTpCd().equals("S")){
						dspSb.append("\n[S]: "+ resultvo.getDisplayFormulaDesc());
						runSb.append("\n[S]: "+ resultvo.getRuntimeFormulaDesc());
						//Srucharge의 값을 map에 전달 
//						map.put("Surcharge", fval2+"");
						calcTariffVO.setSurcharge(fval2+"");
						
						rowsNumberOfDesc++;	//[2010.04.21:jmh]
					}
					else if(listvo.getPsoChgTpCd().equals("D")){
						dspSb.append("\n[D]: "+ resultvo.getDisplayFormulaDesc());
						runSb.append("\n[D]: "+ resultvo.getRuntimeFormulaDesc());
						
						rowsNumberOfDesc++;	//[2010.04.21:jmh]
					}
					
					log.debug("fval:="+fval);
				}
				else{//2009.12.17. 계산식이 null 이거 계산되지 않을 경우 에러추적을 위한 추가 
					if(listvo.getPsoChgTpCd().equals("B")){
						dspSb.append("[B]: "+ resultvo.getDisplayFormulaDesc());
						runSb.append("[B]: "+ resultvo.getRuntimeFormulaDesc());
						
						rowsNumberOfDesc++;	//[2010.04.21:jmh]
					}
					else if(listvo.getPsoChgTpCd().equals("S")){
						dspSb.append("\n[S]: "+ resultvo.getDisplayFormulaDesc());
						runSb.append("\n[S]: "+ resultvo.getRuntimeFormulaDesc());
						
						rowsNumberOfDesc++;	//[2010.04.21:jmh]
					}
					else if(listvo.getPsoChgTpCd().equals("D")){
						dspSb.append("\n[D]: "+ resultvo.getDisplayFormulaDesc());
						runSb.append("\n[D]: "+ resultvo.getRuntimeFormulaDesc());
						
						rowsNumberOfDesc++;	//[2010.04.21:jmh]
					}
					
				}
				
			 if(resultvo.getTariffObjList()!=null && resultvo.getTariffObjList().size()>0){
					vo.setTariffObjList(resultvo.getTariffObjList());
				}
			}			
		}
		
		//outbound의 값으로 계산 
		RoundTruncVO rtvo1in = new RoundTruncVO();
		rtvo1in.setIoBndCd("O");
		rtvo1in.setRatio("100");
		rtvo1in.setCurrCd(calcTariffVO.getCurrCd());//map.get("currCd"));	
		
		//rtvo1in.setCalcAmt(fval+"");
		if ("N".equals(flag)){				
			rtvo1in.setCalcAmt(0+"");			
		}				
		else {
		    rtvo1in.setCalcAmt(fval+"");				
		}				

		
		RoundTruncVO rtvo1out1 = new RoundTruncVO();
		try {
			rtvo1out1 = dbDao.getRoundTruncAmt(rtvo1in);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getRoundTruncAmt"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getRoundTruncAmt"}).getMessage(),ex);
		}
	
		fval = new BigDecimal(rtvo1out1.getCalcAmt());
		
		//if()--> Expression Basic, Surcharge, Discount.가 있음로.. 
//		[B, expr
//		 S, expr,
//		 D, expr] ==> dao.select expre( param)
		
//		 for ( size ){ 
//		 	vo+ = calcTariff();
//		 }
		if(resultvo!=null){
			vo.setTariffAmount(fval+"");
//			vo.setDisplayFormulaDesc(resultvo.getDisplayFormulaDesc());
//			vo.setRuntimeFormulaDesc(resultvo.getRuntimeFormulaDesc());
			vo.setDisplayFormulaDesc(dspSb.toString());
			vo.setRuntimeFormulaDesc(runSb.toString());
			
			vo.setPagerows(rowsNumberOfDesc + "");	//[2010.04.21:jmh]
			
			//vo.setTariffObjList(resultvo.getTariffObjList());
		}
		return vo;
	}
	/**
	 * ObjectList를 해석하면서 실제 Tariff 계산을 실행한다.
	 * 
	 * @param CalcTariffVO calcTariffVO
	 * @param ExpressionListVO expressListVO
	 * @return CalcTariffResultVO
	 * @throws EventException
	 */
	private CalcTariffResultVO calcTariff(CalcTariffVO calcTariffVO,
			ExpressionListVO expressListVO) throws EventException {
		
		CalcTariffResultVO vo = new CalcTariffResultVO();
		String regex = "(\\[[0-9]+\\]@[0-9]+<[0-9]+>)|(\\[[0-9]+\\]@[0-9]+)|(\\[[0-9]+\\])";
		String input = expressListVO.getSysXprDesc();

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input); // get a matcher object

		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		while (m.find()) {
			if (tMap.get(m.start()) == null){
				tMap.put(m.start(), input.substring(m.start(), m.end()));
			}
		}

		Object[] strObjs = tMap.values().toArray();

		log.debug("expressListVO.getSysXprDesc():="	+ expressListVO.getSysXprDesc());
		if (strObjs.length == 0) {
			log.debug("########## There is no any Objects.");
			return null;
		}
		
		int[] objNos = new int[strObjs.length];
		int[] refObjNos = new int[strObjs.length];// [45]<###> 의 형태에서 <###>을 위한 변수
		
		HashMap<String, String> hMap = new HashMap<String, String>();
		String strTmp = "";
		String[] strList = null;
		String tariffNo = "";

		String strObjVal = ""; // R2타입의 경우 구한 Object의 value
		String strRate = "";
		String strObjListNo = "";// R2타입의 경우 해당 ObjectListNO를 가지고 있음

		String vvd = calcTariffVO.getVvd();// map.get("vvd");//vvd
		String ydCd = calcTariffVO.getYdCd();// map.get("ydCd");//YD_CD
		String lgsCostCd = calcTariffVO.getLgsCostCd();// map.get("lgsCostCd");//Logistics Code
		String ydChgNo = calcTariffVO.getYdChgNo();// map.get("ydChgNo");
		String ydChgVerSeq = calcTariffVO.getYdChgVerSeq();// map.get("ydChgVerSeq");
		boolean isBudget = calcTariffVO.isBudget();
		String strType = calcTariffVO.getCalcType();// map.get("CalcType");

		String clptIndSeq = "";
		// CLPT_IND_SEQ
		// 의 값을 Select 해 온다.
//		String torHeaderFlg = "N";
		try {
			clptIndSeq = dbDao.selectClptIndSeq(vvd, ydCd, isBudget);// expr
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010",
					new String[] { "Tariff Calculation : selectClptIndSeq" })
					.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010",
					new String[] { "Tariff Calculation : selectClptIndSeq" })
					.getMessage(), ex);
		}

		// 2009.12.16.add TBN#~항차 대응
		String repVslCd = "";// TBN항차에 대응하는 대응항차
		String cntrVslClssCapa = calcTariffVO.getCntrVslClssCapa();
		try {
			repVslCd = dbDao.getRepVslCd(vvd, cntrVslClssCapa);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010",
					new String[] { "Tariff Calculation : getRepVslCd" })
					.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010",
					new String[] { "Tariff Calculation : getRepVslCd" })
					.getMessage(), ex);
		}

		// 구한 repVslCd로 전환한다.
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
		
		/**
		 * 2009.12.16 repVvd를 사용해야 할 Object List
		 * 1,13,14,16,28,29,30,31,35,36,39,58,63,73,74,81,82,83,87,99
		 * 
		 */

		for (int i = 0; i < strObjs.length; i++) {
			// [##]@##의 형태를 해석해야 한다.
			strTmp = strObjs[i].toString();
			// [45]@254<28>
			log.debug("strTmp := " +strTmp);
			strList = strTmp.split("@");// 0번째는 -> OBJECT 1번째는 Tariff NUmber
			log.debug("strObjs[i]:=" + strTmp);
			log.debug("strList := " +strList);
			if (strList != null && strList.length >= 2) {
				String[] strInfo = strList[1].split("<");
				log.debug("strInfo := " +strInfo);
				if (strInfo.length >= 2) {
					log.debug("strList[0] := " +strList[0]);
					objNos[i] = Integer.parseInt(strList[0].replace("[", "")
							.replace("]", ""));
					tariffNo = strInfo[0];
					log.debug("strInfo[1] := " +strInfo[1]);
					refObjNos[i] = Integer.parseInt(strInfo[1].replace("<", "")
							.replace(">", ""));
					log.debug("refObjNos[i]:= " +refObjNos[i]);
				} else {// [45]@254
					log.debug("strList[0] **:= " +strList[0]);
					objNos[i] = Integer.parseInt(strList[0].replace("[", "")
							.replace("]", ""));
					tariffNo = strList[1];
					log.debug("tariffNo  **:= " +tariffNo);
				}
			} else {
				// [45]<18> 2009.11.23 형태 대응 --> error
				// String[] strInfo=strList[0].split("<");
				// if(strInfo!=null){
				// if(strInfo.length >= 2){
				// objNos[i] = Integer.parseInt(strInfo[0].replace("[",
				// "").replace("]", ""));
				// refObjNos[i] = Integer.parseInt(strInfo[1].replace("<",
				// "").replace(">", ""));
				// }
				// else{
				objNos[i] = Integer.parseInt(strList[0].replace("[", "")
						.replace("]", ""));
				log.debug("strList[0] ***:= " +strList[0]);
				// }
				// }
			}
			
			if (objNos[i] != 45 && objNos[i] != 46 && objNos[i] != 117
					&& calcTariffVO.getFrom().equals("SIMULATION")) {
				hMap.put(strObjs[i].toString(), calcTariffVO.hMap
						.get(strObjs[i].toString()));
			} else {

				log.debug("tariffNo:=" + tariffNo);
				log.debug("objNo : "+objNos[i]);
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
				 * 181 - loaded DG Cargo at arrival - 173
				 * 182 - loaded DG Cargo at departure - 174
				 * 183 - Conventional Flags For GR - 175
				 * 184 - BAF - 176
				 * 185 - Loaded MT Q'TY - 177
				 */
				case 1: // Allowance TEU
					// SELECT CNTR_PNM_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD =
					// :VSL_CD
					String strAllwTeu = getAllwTeu(repVvd);
					hMap.put(strObjs[i].toString(), strAllwTeu);
					log.debug("Allowance TEU [1]:=" + strAllwTeu);
					break;
				case 2: // Arrival Draft Feet
					log.debug("Arrival Draft Feet" + "[" + 2 + "]");
					String strArvDrft = getArvDrftFeet(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strArvDrft);
					break;
				case 3: // Departure Draft Meter
				case 25: // Departure Draft1 Meter
					log.debug("Departure Draft Meter" + "[" + 25 + "]");
					String strDprDftMeter = getDprDftMeter(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDprDftMeter);
					break;

				case 4: // Arrival No. of Tractor
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					log.debug("Arrival No. of Tractor" + "[" + 4 + "]");
					String strArvNoOfTrk = getArvNoOfTrk(ydChgNo, ydChgVerSeq, 4 + "");
					hMap.put(strObjs[i].toString(), strArvNoOfTrk);
					break;
				case 5: // Departure No. of Tractor
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					log.debug("Departure No. of  Tractor" + "[" + 5 + "]");
					String strDprNoOfTrk = getDprNoOfTrk(ydChgNo, ydChgVerSeq,
							5 + "");
					hMap.put(strObjs[i].toString(), strDprNoOfTrk);
					break;
				case 6: // Arrival No. of Tug
					// SELECT T1.ARR_TUG_BOT_KNT FROM VSK_ACT_PORT_SKD T1,
					// VSK_VSL_PORT_SKD T2 WHERE 1 = 1 AND T1.VSL_CD = T2.VSL_CD
					// AND T1.SKD_VOY_NO = T2.SKD_VOY_NO AND T1.SKD_DIR_CD =
					// T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND
					// T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX'
					// AND T1.SKD_VOY_NO = '0036' AND T1.SKD_DIR_CD = 'E' AND
					// T2.YD_CD = 'KRINCYP'

					log.debug("Arrival No. of Tug" + "[" + 6 + "]");
					String strArvNoOfTug = getArvNoOfTug(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strArvNoOfTug);
					break;
				case 7: // Departure No. of Tug

					log.debug("Departure No. of Tug" + "[" + 7 + "]");
					String strDprNoOfTug = getDprNoOfTug(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDprNoOfTug);
					break;
				case 8: // Arrival Tug Power
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO
					log.debug("Arrival Tug Power" + "[" + 8 + "]");
					String strArvTugPwr = getArvTugPwr(ydChgNo, ydChgVerSeq,
							8 + "");
					hMap.put(strObjs[i].toString(), strArvTugPwr);
					break;
				case 9: // Departure Tug Power
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					log.debug("Departure Tug Power" + "[" + 9 + "]");
					String strDprTugPwr = getDprTugPwr(ydChgNo, ydChgVerSeq,
							9 + "");
					hMap.put(strObjs[i].toString(), strDprTugPwr);
					break;
				case 10: // Arrival Tug Used Hour
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO
					log.debug("Arrival Tug Used Hour" + "[" + 10 + "]");
					String strArvTugUsedHour = getArvTugUsedHour(ydChgNo,
							ydChgVerSeq, 10 + "");
					hMap.put(strObjs[i].toString(), strArvTugUsedHour);
					break;
				case 11: // Departure Tug Used Hour
					// SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO
					// = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND
					// OBJ_LIST_NO = :OBJ_LIST_NO

					log.debug("Departure Tug Used Hour" + "[" + 11 + "]");
					String strDprTugUsedHour = getDprTugUsedHour(ydChgNo,
							ydChgVerSeq, 11 + "");
					hMap.put(strObjs[i].toString(), strDprTugUsedHour);
					break;
				case 13: // BeamFeet
					// SELECT ROUND(VSL_WDT * 3.28, 4) FROM MDM_VSL_CNTR WHERE
					// VSL_CD = 'BAHX'

					log.debug("Beam" + "[" + 13 + "]");
					String strBeamFeet = getBeamFeet(repVvd);
					hMap.put(strObjs[i].toString(), strBeamFeet);
					break;
				case 14: // BeamMeter
					// SELECT VSL_WDT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'

					log.debug("Beam" + "[" + 14 + "]");
					String strBeamMeter = getBeamMeter(repVvd);
					hMap.put(strObjs[i].toString(), strBeamMeter);
					break;
				case 15: // Berthing Hour(D-B)
					// SELECT ROUND((VPS_ETD_DT - VPS_ETB_DT) * 24, 2) FROM
					// VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO =
					// '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND
					// CALL_YD_IND_SEQ = '1'

					log.debug("Berthing Hour(D-B)" + "[" + 15 + "]");
					String strBerthingHour = getBerthingHour(vvd, ydCd, clptIndSeq, isBudget);
					// if(strBerthingHour == null || strBerthingHour.equals(""))
					// strBerthingHour = "null"; //[2010.04.13:jmh] close
					hMap.put(strObjs[i].toString(), strBerthingHour);
					break;
				case 166: // Berthing Date(D-B)
					//SELECT (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1
					//FROM VSK_VSL_PORT_SKD 
					//WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0167' AND SKD_DIR_CD = 'E' 
					//AND YD_CD = 'CNSHAM1' AND CALL_YD_IND_SEQ = '1'
					log.debug("Berthing Date(D-B)" + "[" + 166 + "]");
					String strBerthingDate = getBerthingDate(vvd, ydCd, clptIndSeq, isBudget);
					hMap.put(strObjs[i].toString(), strBerthingDate);
					break;
				case 16: // Block Size
					// SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) *
					// NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR
					// WHERE VSL_CD = :VSL_CD

					log.debug("Block Size" + "[" + 16 + "]");
					String strBlockSize = getBlockSize(repVvd);
					hMap.put(strObjs[i].toString(), strBlockSize);
					break;
				case 18:// Constant1
				case 19:// Constant2
				case 20:// Constant3
				case 21:// Constant4
				case 22:// Constant5
				case 183:// Constant6

					log.debug("Constant" + "[" + objNos[i] + "]");
					hMap.put(strObjs[i].toString(), "1"); // 일단 1로 셋팅
					break;
				case 23:// Country of Last Port
					String strCntLastPort = getCntLastPort(vvd, ydCd, isBudget);
					if (strCntLastPort == null || strCntLastPort.equals(""))
						strCntLastPort = "/*no found : Country of Last Port*/";
					hMap.put(strObjs[i].toString(), strCntLastPort);
					log.debug("Country of Last Port[23]:=" + strCntLastPort);
					break;
				case 24:// Country of Next Port

					String strCntNextPort = getCntNextPort(vvd, ydCd, isBudget);
					if (strCntNextPort == null || strCntNextPort.equals(""))
						strCntNextPort = "/*no found : Country of Next Port*/";
					hMap.put(strObjs[i].toString(), strCntNextPort);
					log.debug("Country of Next Port[24]:=" + strCntNextPort);
					break;

				case 26: // Departure Draft Feet

					log.debug("Departure Draft Feet" + "[" + 26 + "]");
					String strDprDftFeet = getDprDftFeet(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDprDftFeet);
					break;
				case 27:// Garbage Volume
					log.debug("Garbage Volume" + "[" + 27 + "]");
					String strGarbageVol = getGarbageVol(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strGarbageVol);
					break;
				case 28: // GRT
				case 73:// GRT 1
				case 74:// GRT 2

					log.debug("GRT" + "[" + 28 + "]");
					String strGRT = getVslGrt(repVvd);
					hMap.put(strObjs[i].toString(), strGRT);
					break;
				case 29: // NRT
					// SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD =
					// 'BAHX'

					log.debug("NRT" + "[" + 29 + "]");
					String strNRT = getVslNrt(repVvd);
					hMap.put(strObjs[i].toString(), strNRT);
					break;
				case 30: // LOAFEET
					// SELECT ROUND(LOA_LEN * 3.28, 4) FROM MDM_VSL_CNTR WHERE
					// VSL_CD = 'BAHX'

					log.debug("LOAFeet[30]");
					String strLOAFeet = getLoaFeet(repVvd);
					// .... .....
					hMap.put(strObjs[i].toString(), strLOAFeet);
					break;
				case 31: // LOAMETER
					// SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'

					log.debug("LOAMeter[31]");
					String strLOA = getLoaMeter(repVvd);
					hMap.put(strObjs[i].toString(), strLOA);
					break;
				case 34: // Lane
					// SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = 'BAHX'
					// AND SKD_VOY_NO = '0036' AND SKD_DIR_CD = 'E'

					log.debug("Lane" + "[" + 34 + "]");
					String strLane = getLane(vvd, isBudget);
					hMap.put(strObjs[i].toString(), "'" + strLane + "'");
					break;

				case 35: //
					// SELECT VSL_RGST_CNT_CD FROM mdm_vsl_cntr WHERE VSL_CD =
					// 'HPSH'

					String strNalVsl = getNalVsl(vvd);
					hMap.put(strObjs[i].toString(), "'" + strNalVsl + "'");
					log.debug("Nationality of Vessel [35]:=" + strNalVsl);
					break;

				case 36: // No. of Crew

					String strNoOfCrew = getNoOfCrew(repVvd);
					hMap.put(strObjs[i].toString(), strNoOfCrew);
					log.debug("No. of Crew" + "[" + 36 + "] := " + strNoOfCrew);
					break;
				case 38: // SCNT
					String strScnt = "";

					strScnt = calcTariffVO.getScnt();// map.get("SCNT");
					if (strScnt == null || strScnt.equals(""))
						strScnt = getScnt(vvd);
					hMap.put(strObjs[i].toString(), strScnt);
					log.debug("SCNT" + "[" + 38 + "]:=" + strScnt);
					break;
					

				case 40: // Sludge Volume
					String strSludgeVol = getSludgeVol(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strSludgeVol);
					log.debug("Sludge Volume" + "[" + 40 + "] := "
							+ strSludgeVol);
					break;

				//case 41:
					
				case 32:// Inbound Volume
					String strInboundVolume = getInboundVolume(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strInboundVolume);
					log.debug("Inbound Volume[32]:=" + strInboundVolume);
					break;
				case 33:// Outbound Volume

					String strOutboundVolume = getOutboundVolume(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strOutboundVolume);
					log.debug("Outbound Volume[33]:=" + strOutboundVolume);
					break;
				case 37:// Anchoring Hour

					String strAnchoringHour = getAnchoringHour(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strAnchoringHour);
					log.debug("Anchoring Hour[37]:=" + strAnchoringHour);
					break;
				case 39:// Ship Unit

					log.debug("Ship Unit" + "[" + 39 + "]");
					String strShipUnit = getShipUnit(repVvd);
					hMap.put(strObjs[i].toString(), strShipUnit);
					log.debug("Ship Unit[39]:=" + strShipUnit);
					break;
				case 42:// Vessel Visit

					log.debug("Vessel Visit ");
					hMap.put(strObjs[i].toString(), "1");
					break;
				case 45:// RATE --PSO_TARIFF에서 구한다.

					log.debug(">>> in RATE[45]");
					if (tariffNo.equals(""))
						tariffNo = "-1";// TEST DATA
					String psoTrfTpCd = getPsoTrfTpCd(tariffNo);
					if (psoTrfTpCd.equals("R")) {

						log.debug("previousInfo= " + refObjNos[i] + "" + ":="
								+ hMap.get("[" + refObjNos[i] + "]")); // 이전정보를
																		// 참조 할
																		// 경우
						// TariffDetail을 이전 값으로 찔러서 해당 Rate값을 구해 온다.
                       
						if (hMap.get("[" + refObjNos[i] + "]") == null) {
							log.debug("calcTariffVO.getFrom()+"+calcTariffVO.getFrom());
							if (calcTariffVO.getFrom().equals("SIMULATION")) {
								strObjVal = calcTariffVO.hMap.get("["
										+ refObjNos[i] + "]");
							} else {
								strObjVal = getObjectValue(calcTariffVO,
										objNos, strObjVal, vvd, ydCd,
										lgsCostCd, ydChgNo, ydChgVerSeq,
										clptIndSeq, i, refObjNos[i], repVvd);
							}
						} else {
							strObjVal = hMap.get("[" + refObjNos[i] + "]");
						}
						log.debug("previousInfo= " + refObjNos[i] + "" + ":="
								+ strObjVal); // 이전정보를 참조 할 경우
						strRate = getTrfRtAmt(tariffNo, strObjVal, "1");
					} else if (psoTrfTpCd.equals("S")) {// R2 의 경우 Rate 온리이다.
														// 이경우 해당 RATE가 어떤 레이트
														// 인지 찾아야 한다.
						// 해당 RATE가 어떤 Object의 레이트인지를 구하기 위해 PSO_TARIFF의 테이블을
						// tariffNo로 찔러서 Object의 타입을 구한다.
						strObjListNo = getObjListNo(tariffNo);
						int iObjListNo = -1; // /
						if (strObjListNo != null)
							iObjListNo = Integer.parseInt(strObjListNo);
						log.debug("case 45: TYPE S : iObjListNo :="
								+ iObjListNo);
						if (calcTariffVO.getFrom().equals("SIMULATION")) {
							strObjVal = calcTariffVO.hMap.get("[" + iObjListNo
									+ "]");
						} else {
							strObjVal = getObjectValue(calcTariffVO, objNos,
									strObjVal, vvd, ydCd, lgsCostCd, ydChgNo,
									ydChgVerSeq, clptIndSeq, i, iObjListNo,
									repVvd);
						}
						strRate = getTrfRtAmt(tariffNo, strObjVal, "1");
					} else {// F /// null --> s, d 의 경우 null
						// 1개의 값 만을 가지고 있기 때문에..
						// PSO_TRF_DTL에 하나의 값만 가지고 있다.
						log.debug("Fixed Type의 경우 ");
						strRate = getTrfRtAmt(tariffNo, null, "2");
						// strRate = "0.1";
					}

					if (strRate == null || strRate.equals(""))
						strRate = "null";
					hMap.put(strObjs[i].toString(), strRate);
					break;
				case 46: // Base 에서 계산 된 결과 값으로 치환
//					String strType = "";
					// S, D 인 경우만 처리
//					strType = calcTariffVO.getCalcType();// map.get("CalcType");
					String strBase = calcTariffVO.getBase();// map.get("Base");
					log.debug(i + "Base Rate" + "[" + 46 + "]");
					log.debug(strBase);
					log.debug(strObjs[i].toString());
					if (strType.equals("S") || strType.equals("D")) {
						hMap.put(strObjs[i].toString(), strBase);
					}
					break;
				case 47:// Arrival Draft Meter
					log.debug("Arrival Draft Meter" + "[" + 47 + "]");
					String strArvDrftMeter = getArvDrftMeter(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strArvDrftMeter);
					break;
				case 48:// Arrival Draft 1 Meter

					log.debug("Arrival Draft1 Meter" + "[" + 48 + "]");
					String strArvDrftOneMeter = getArvDrftOneMeter(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strArvDrftOneMeter);
					break;
				case 49:// Arrival Draft1 Feet

					log.debug("Arrival Draft1 Feet" + "[" + 49 + "]");
					String strArvDrftOneFeet = getArvDrftOneFeet(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strArvDrftOneFeet);
					break;
				case 51:// Arrival POB
					log.debug("Arrival POB" + "[" + 51 + "]");
					String strArrPob = getArrPob(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strArrPob);
					break;
				case 55:// Bound
					log.debug("Bound" + "[" + 55 + "]");
					String strBound = getBound(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), "'" + strBound + "'");
					break;
				case 56:// Bunker Volume

					log.debug("Bunker Volume" + "[" + 56 + "]");
					String strBkerVol = getBkerVol(vvd);
					hMap.put(strObjs[i].toString(), strBkerVol);
					break;
				case 58:// Carrier

					String strCarrier = getCarrier(repVvd, isBudget);
					hMap.put(strObjs[i].toString(), "'" + strCarrier + "'");
					log.debug("Carrier [58] := " + strCarrier);
					break;
				case 59:
					// TODO : 임플리 먼트 필요
					hMap.put(strObjs[i].toString(), "'N'");
					break;
				case 61:

					log.debug("Departure POB" + "[" + 61 + "]");
					String strDepPob = getDepPob(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDepPob);
					break;
				case 63:// Design Capacity
					String strDesignCapacity = getDesignCapacity(repVvd);
					hMap.put(strObjs[i].toString(), strDesignCapacity);
					log.debug("Design Capacity" + "[" + 63 + " ]:="
							+ strDesignCapacity);
					break;
				case 64:// DWT

					log.debug("DWT" + "[" + 64 + "]");
					String strDwt = getDwt(vvd);
					hMap.put(strObjs[i].toString(), strDwt);
					break;
				/*
				 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
				 */
				case 65:// ETB Date

					String strEtbDate = getEtbDate(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtbDate);
					log.debug("ETB Date[65]:=" + strEtbDate);
					break;
				case 66:// ETB Month

					String strEtbMonth = getEtbMonth(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtbMonth);
					log.debug("ETB Month" + "[" + 66 + " ]:=" + strEtbMonth);
					break;
				case 67:// ETB Time
				case 68:// ETB1 Time

					String strEtbTime = getEtbTime(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtbTime);
					log.debug("ETB Time" + "[" + 67 + " ]:=" + strEtbTime);
					break;
				/*
				 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
				 */
				case 69:// ETD Date
					String strEtdDate = getEtdDate(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtdDate);
					log.debug("ETD Date" + "[" + 69 + " ]:=" + strEtdDate);
					break;
				case 70:// ETD Month

					String strEtdMonth = getEtdMonth(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtdMonth);
					log.debug("ETD Month" + "[" + objNos[i] + " ]:="
							+ strEtdMonth);
					break;
				case 71:// ETD Time
				case 72:// ETD1 Time
					String strEtdTime = getEtdTime(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtdTime);
					log.debug("ETD Time" + "[" + objNos[i] + " ]:="
							+ strEtdTime);
					break;
				case 77: // IN
					String strInFlag = calcTariffVO.getIoFlag();// map.get("ioFlag");
					if (strInFlag != null) {
						if (strInFlag.equals("IN")) {
							hMap.put(strObjs[i].toString(), "'Y'");
						} else {
							hMap.put(strObjs[i].toString(), "'N'");
						}
					}
					vo.addTariffObjList(77);
					break;
				case 79:// last Issued Invoice ETD

					String strLastInvEtd = getLastInvEtd(vvd, ydCd, lgsCostCd, isBudget);
					hMap.put(strObjs[i].toString(), strLastInvEtd);
					log.debug("last Issued Invoice ETD[79]:=" + strLastInvEtd);
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
					String strLastPort = getLastPort(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strLastPort);
					log.debug("Last Port[80]:=" + strLastPort);
					break;
				case 81:// LOA 1
				case 82:// LOA 2
				case 83:// LOA 3
					// SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
					log.debug("getLoa" + "[" + objNos[i] + "]");
					String strLoa = getLoa(repVvd);
					hMap.put(strObjs[i].toString(), strLoa);
					break;
				case 85:// Next Port

					String strNextPort = getNextPort(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strNextPort);
					log.debug("Next Port[85]:=" + strNextPort);
					break;
			   		
				case 168:// Next Yard

					String strNextYard = getNextYard(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strNextYard);
					log.debug("Next Yard[168]:=" + strNextYard);
					break;	
				case 169:// Last Yard
					String strLastYard = getLastYard(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strLastYard);
					log.debug("Last Yard[169]:=" + strLastYard);
					break;		
				case 86: // Night 의 여부 Y , N값이 들어 온다. 아무값이 안들어 오면 default값을 구한다.
					String strNightYN = "'N'";
					hMap.put(strObjs[i].toString(), strNightYN);
					break;
				case 87:// NRT1
					// SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD =
					// 'BAHX'
					log.debug("NRT1" + "[" + objNos[i] + "]");
					String strNrt1 = getNrtOne(repVvd);
					hMap.put(strObjs[i].toString(), strNrt1);
					break;
				case 89: // OUT
					String strOutFlag = calcTariffVO.getIoFlag();// map.get("ioFlag");
					if (strOutFlag != null) {
						if (strOutFlag.equals("OUT")) {
							hMap.put(strObjs[i].toString(), "'Y'");
						} else {
							hMap.put(strObjs[i].toString(), "'N'");
						}
					}
					vo.addTariffObjList(89);
					break;
				case 90:// Pilot Off

					log.debug("Pilot Off" + "[" + 90 + "]");
					String strPOff = getPOff(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), "'" + strPOff + "'");
					break;
				case 91:// POB

					log.debug("POB" + "[" + 91 + "]");
					String strPob = getPob(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), "'" + strPob + "'");
					break;
				case 92:// Rehandling Volume

					log.debug("Rehandling Volume" + "[" + 92 + "]");
					String strRhVol = getRhVol(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strRhVol);
					break;
				case 93:// Remain Vessel Call

					String strRemainVesselCall = getRemainVesselCall(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strRemainVesselCall);
					log.debug("Remain Vessel Call [93] :="
							+ strRemainVesselCall);
					break;
				case 94:// Monthly Vessel Call

					String strMonthlyVesselCall = getMonthlyVesselCall(vvd,	ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strMonthlyVesselCall);
					log.debug("Monthly Vessel Call" + "[" + 94 + "] :="
							+ strMonthlyVesselCall);
					break;
				case 95:// sameVvd

					log.debug("sameVvd" + "[" + 95 + "]");
					String strSameVvd = getSameVvd(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strSameVvd);
					break;
				case 96:// Yearly Vessel Call

					String strYearlyVesselCall = getYearlyVesselCall(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strYearlyVesselCall);
					log.debug("Yearly Vessel Call" + "[" + 96 + "] :="
							+ strYearlyVesselCall);
					break;
				case 170:// Yearly Vessel Call(US)

					String strYearlyVesselCallUs = getYearlyVesselCallUs(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strYearlyVesselCallUs);
					log.debug("Yearly Vessel Call(US)" + "[" + 170 + "] :="
							+ strYearlyVesselCallUs);
					break;	
				case 98:// SCNT1

					log.debug("SCNT1" + "[" + 98 + "]");
					String strScnt1 = calcTariffVO.getScntOne();// map.get("SCNT1");
					if (strScnt1 == null || strScnt1.equals(""))
						strScnt = getScnt(vvd);
					hMap.put(strObjs[i].toString(), strScnt1);
					break;
				case 99:// ShipUnitOne

					log.debug("ShipUnit1" + "[" + 99 + "]");
					String strShipUnitOne = getShipUnitOne(repVvd);
					hMap.put(strObjs[i].toString(), strShipUnitOne);
					break;
				case 100:// Summer Draft(F)
					log.debug("Summer Draft(F)" + "[" + 100 + "]");
					String strSmmrDftF = getSmmrDftF(repVvd);
					hMap.put(strObjs[i].toString(), strSmmrDftF);
					break;
				case 101:// Summer Draft(M)
					log.debug("Summer Draft(M)" + "[" + 101 + "]");
					String strSmmrDftM = getSmmrDftM(repVvd);
					hMap.put(strObjs[i].toString(), strSmmrDftM);
					break;
				case 112:// Water Volume
					log.debug("Water Volume" + "[" + 112 + "]");
					String strWatVol = getWatVol(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strWatVol);
					break;
				case 114:// SDR

					// 우선 외부에서 설정된 SDR이 있는지 확인
					log.debug("SDR" + "[" + 114 + "]");
					String strSdr = calcTariffVO.getSDR();// map.get("SDR");
					if (strSdr == null || strSdr.equals(""))
						strSdr = getSdr();
					hMap.put(strObjs[i].toString(), strSdr);// 일단 1 을 넣음
					break;
				/*
				 * CHM-201005695-01 추정실적 산출시, tier의 값을 조회
				 */
				case 115:// Tier
					String strTier;
					if ("Y".equals(calcTariffVO.getEstFlg())) {
						strTier = getTier(vvd, ydCd, isBudget);
					} else {
						strTier = calcTariffVO.getTier();// map.get("Tier");
					}
					if (strTier != null) {
						hMap.put(strObjs[i].toString(), strTier);
					}
					log.debug("Tier [115]:=" + strTier);
					break;
				/*
				 * CHM-201005695-01 추정실적 산출시, limit time의 값을 조회
				 */
				case 116:// Limit Time
					String strLimitTime;
					if ("Y".equals(calcTariffVO.getEstFlg())) {
						strLimitTime = getLimitTime(vvd, ydCd, isBudget);
					} else {
						strLimitTime = calcTariffVO.getLimitTm();// map.get("LimitTime");
					}
					if (strLimitTime != null) {
						hMap.put(strObjs[i].toString(), strLimitTime);
					}
					log.debug("Limit Time [116]:=" + strLimitTime);
					break;
				case 117:// Surcharge Amount
					// Discount 인 경우만 처리
//					strType = calcTariffVO.getCalcType();// map.get("CalcType");
					String strSurcharge = calcTariffVO.getSurcharge();// map.get("Surcharge");
					if (strType.equals("D"))
						hMap.put(strObjs[i].toString(), strSurcharge);
					log.debug( i + "Surcharge Amount [117] :=" + 117);
					break;
				case 118: // Block Size1 (Obj 16 Block Size와 동일한 값을 return 한다.)
					// SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) *
					// NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR
					// WHERE VSL_CD = :VSL_CD

					log.debug("Block Size" + "[" + 118 + "]");
					strBlockSize = getBlockSize(repVvd);
					hMap.put(strObjs[i].toString(), strBlockSize);
					break;
				case 120:// DEM/DET Holiday(ETB)

					String strDdHolEtb = getDemdetHolidayETB(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDdHolEtb);
					log.debug("DEM/DET Holiday(ETB) [120] :=" + strDdHolEtb);
					break;
				case 121:// DEM/DET Holiday(ETD)

					String strDdHolEtd = getDemdetHolidayETD(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDdHolEtd);
					log.debug("DEM/DET Holiday(ETD) [121] :=" + strDdHolEtd);
					break;
				case 122:// Ownership
					String strOwnrship = getOwnrship(vvd);
					hMap.put(strObjs[i].toString(), strOwnrship);
					log.debug("Ownership [122] :=" + strOwnrship);
					break;
				case 123:// ETB(H)

					String strEtbHr = getEtbHr(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtbHr);
					log.debug("ETB(H) [123] :=" + strEtbHr);
					break;
				case 124:// ETD(H)

					String strEtdHr = getEtdHr(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtdHr);
					log.debug("ETD(H) [123] :=" + strEtdHr);
					break;
				case 126:// I/B (TON)

					String strInboundTon = getInboundTon(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strInboundTon);
					log.debug("I/B (TON) [126] :=" + strInboundTon);
					break;
				case 127:// O/B (TON)

					String strOutboundTon = getOutboundTon(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strOutboundTon);
					log.debug("O/B (TON) [127] :=" + strOutboundTon);
					break;
				case 128:// RH (TON)

					String strRhTon = getRhTon(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strRhTon);
					log.debug("RH (TON) [128] :=" + strRhTon);
					break;
				case 129:// ETA (H)
					String strEtaHour = getEtaHour(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtaHour);
					log.debug("ETA (H) [129] :=" + strEtaHour);
					break;
				case 130:// Cargo Volume(Ton)
					String strCargoVolume = getCargoVolumeTon(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strCargoVolume);
					log.debug("Cargo Volume(Ton) [130] :=" + strCargoVolume);
					break;
				case 131:// Vessel Volume(FR)
				case 164:// Vessel Volume(FR)1
				case 165:// Vessel Volume(FR)2
					String strVesselVolumeFr = getVesselVolumeFr(vvd);
					hMap.put(strObjs[i].toString(), strVesselVolumeFr);
					log.debug("Vessel Volume(FR) [131] :=" + strVesselVolumeFr);
					break;
				case 132:// Loaded TEU WBLP (West bound last port)
					String strLoadedTeuLastPort = getstrLoadedTeuLastPort(vvd,ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strLoadedTeuLastPort);
					log.debug("Loaded TEU WBLP [132] :="
							+ strLoadedTeuLastPort);
					break;
				/*
				 * CHM-201005567-01 동일 노선이 해당 Port에 연간 기항하는 횟수를 조회하는 로직을 추가
				 */
				case 133:// Yearly Vessel Call Lane
					String strYearlyVesselCallLane = getYearlyVesselCallLane(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strYearlyVesselCallLane);
					log.debug("Yearly Vessel Call Lane [133] :="
							+ strYearlyVesselCallLane);
					break;
				case 134:// vessel volume(CI)
					String strVesselVolume = getVesselVolumeCi(vvd, ydCd);
					hMap.put(strObjs[i].toString(), strVesselVolume);
					log.debug("Vessel Volume Ci [134] :=" + strVesselVolume);
					break;
				case 135:// LOA * Beam
					String strLoaBeam = getLoaBeam(vvd);
					hMap.put(strObjs[i].toString(), strLoaBeam);
					log.debug("LOA*BM [135] :=" + strLoaBeam);
					break;
				/*
				 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
				 */
				case 136:// ETB Day
					String strEtbDay = getEtbDay(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtbDay);
					log.debug("ETB Day[136]:=" + strEtbDay);
					break;
				case 137:// ETD Day
					String strEtdDay = getEtdDay(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtdDay);
					log.debug("ETD Day[137]:=" + strEtdDay);
					break;
				case 138:// SUN
					String strSun = "'SUN'";
					hMap.put(strObjs[i].toString(), strSun);
					log.debug("SUN [138] :=" + strSun);
					break;
				case 139:// MON
					String strMon = "'MON'";
					hMap.put(strObjs[i].toString(), strMon);
					log.debug("MON [139] :=" + strMon);
					break;
				case 140:// TUE
					String strTue = "'TUE'";
					hMap.put(strObjs[i].toString(), strTue);
					log.debug("TUE [140] :=" + strTue);
					break;
				case 141:// WED
					String strWed = "'WED'";
					hMap.put(strObjs[i].toString(), strWed);
					log.debug("WED [141] :=" + strWed);
					break;
				case 142:// THU
					String strThu = "'THU'";
					hMap.put(strObjs[i].toString(), strThu);
					log.debug("THU [142] :=" + strThu);
					break;
				case 143:// FRI
					String strFri = "'FRI'";
					hMap.put(strObjs[i].toString(), strFri);
					log.debug("FRI [143] :=" + strFri);
					break;
				case 144:// SAT
					String strSat = "'SAT'";
					hMap.put(strObjs[i].toString(), strSat);
					log.debug("SAT [144] :=" + strSat);
					break;
				case 146:// Loaded TEU EBLP (East bound last port)
					strObjVal = getstrLoadedTeuLastPort1(vvd, ydCd, isBudget);
					log.debug("in[45] Loaded TEU EBLP [146] :="
							+ strObjVal);
					break;
				/*
				 * CHM-201007132-01 신규 Object DEM/DET Holiday ETB/ETD (except
				 * Day) 추가
				 */
				case 147:// DEM/DET Holiday ETB (except Day)
					String strDemdetHolidayETBExceptDay = searchDemdetHolidayETBExceptDay(
							vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(),
							strDemdetHolidayETBExceptDay);
					log.debug("DEM/DET Holiday ETB(except Day) [147] :="
							+ strDemdetHolidayETBExceptDay);
					break;
				case 148:// DEM/DET Holiday ETD (except Day)
					String strDemdetHolidayETDExceptDay = searchDemdetHolidayETDExceptDay(
							vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(),
							strDemdetHolidayETDExceptDay);
					log.debug("DEM/DET Holiday ETD(except Day) [148] :="
							+ strDemdetHolidayETDExceptDay);
					break;
					
				/*
				 * CHM-201111356-01 신규 Object 추가 ETA(T), ETA1(T)
				 */
				case 149:// ETA Time
				case 150:// ETA1 Time
					String strEtaTime = getEtaTime(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtaTime);
					log.debug("ETA Time" + "[" + objNos[i] + " ]:="
							+ strEtaTime);
					break;
					
				/*
				 * CHM-201111356-01 신규 Object 추가 NRT 2
				 */
				case 151: // NRT2
					String strNrt2 = getNrtOne(repVvd); // NRT1과 동일
					hMap.put(strObjs[i].toString(), strNrt2);
					log.debug("NRT 2" + "[" + objNos[i] + " ]:="
							+ strNrt2);
					break;
					
				case 152:// DEM/DET Holiday(ETA)

					String strDdHolEta = getDemdetHolidayETA(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strDdHolEta);
					log.debug("DEM/DET Holiday(ETA) [152] :=" + strDdHolEta);
					break;
					
				case 153:// DEM/DET Holiday ETA (except Day)
					String strDemdetHolidayETAExceptDay = searchDemdetHolidayETAExceptDay(
							vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(),
							strDemdetHolidayETAExceptDay);
					log.debug("DEM/DET Holiday ETA(except Day) [153] :="
							+ strDemdetHolidayETAExceptDay);
					break;
					
				case 154: // Duration
					String duration = getDuration(vvd, isBudget);
					hMap.put(strObjs[i].toString(), duration);
					log.debug("Duration [154] :=" + duration);
					break;
					
				case 155: // Previous Port(TW)
					String previousTaiwanPort = getPreviousTaiwanPort(vvd, ydCd);
					hMap.put(strObjs[i].toString(), previousTaiwanPort);
					log.debug("Previous Port(TW) [155] :=" + previousTaiwanPort);
					break;
					
				case 156: // Yearly Vessel Call Port
					String yearlyVesselCallPort = getYearlyVesselCallPort(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), yearlyVesselCallPort);
					log.debug("Yearly Vessel Call Port [156] :=" + yearlyVesselCallPort);
					break;
					
				case 157: // ETA Date
					String strEtaDate =  getEtaDate(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtaDate);
					log.debug("ETA Date [157] :=" + strEtaDate);
					break;
					
				case 158: // Berthing Hour(D-A)
					String strBerthingHourDA = getBerthingHourDA(vvd, ydCd, clptIndSeq, isBudget);
					hMap.put(strObjs[i].toString(), strBerthingHourDA);
					log.debug("Berthing Hour(D-A) [158] :=" + strBerthingHourDA);
					break;
					
				case 159: // ETA Day
					String strEtaDay = getEtaDay(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtaDay);
					log.debug("ETA Day[159]:=" + strEtaDay);
					break;
					
				case 160:// ETA Month
					String strEtaMonth = getEtaMonth(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strEtaMonth);
					log.debug("ETA Month[160]:=" + strEtaMonth);
					break;
					
				case 161:// Inbound Volume(Ton) / Vessel Volume(FR)
					String strInboundDivideVessel = getInboundDivideVessel(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strInboundDivideVessel);
					log.debug("Inbound Volume(Ton) / Vessel Volume(FR)[161]:=" + strInboundDivideVessel);
					break;
					
				case 162:// Outbound Volume(Ton) / Vessel Volume(FR)
					String strOutboundDivideVessel = getOutboundDivideVessel(vvd, ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strOutboundDivideVessel);
					log.debug("Outbound Volume(Ton) / Vessel Volume(FR)[162]:=" + strOutboundDivideVessel);
					break;
					
				case 163: // SCGT <<<비슷함 case 38: // SCNT>>>
					String strScgt = "";
	
					strScgt = calcTariffVO.getScgt();// map.get("SCGT");
					if (strScgt == null || strScgt.equals(""))
						strScgt = getScgt(vvd);
					hMap.put(strObjs[i].toString(), strScgt);
					log.debug("SCGT" + "[" + 163 + "]:=" + strScgt);
					break;
				case 167: // ESIscore
					String strESIScore = "";
	
					strESIScore = calcTariffVO.getESIScore();// map.get("SCGT");
					if (strESIScore == null || strESIScore.equals(""))
						strESIScore = getESIScore(vvd);
					hMap.put(strObjs[i].toString(), strESIScore);
					log.debug("ESIscore" + "[" + 167 + "]:=" + strESIScore);
					break;
				case 171:// Loaded WGT at L/P
					String strLoadedWgtLastPort = searchLoadedWgtLastPort(vvd,ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strLoadedWgtLastPort);
					log.debug("Loaded WGT at L/P [171] :="
							+ strLoadedWgtLastPort);
					break;	
				case 172:// Effective DT (TONNAGE)
					String strWithinEffectiveDate = searchWithinEffectiveDate(vvd,ydCd, isBudget);
					hMap.put(strObjs[i].toString(), strWithinEffectiveDate);
					log.debug("Effective DT [172] :="
							+ strWithinEffectiveDate);
					break;	
				case 173:// Loaded DG Cargo at Arrival
					String strLoadedDGcargoArr = searchLoadedDGcargoArr(vvd,ydCd);
					hMap.put(strObjs[i].toString(), strLoadedDGcargoArr);
					log.debug("Loaded DG at Arrival [173] :="
							+ strLoadedDGcargoArr);
					break;	
				case 174:// Loaded DG Cargo at Departure
					String strLoadedDGcargoDep = searchLoadedDGcargoDep(vvd,ydCd);
					hMap.put(strObjs[i].toString(), strLoadedDGcargoDep);
					log.debug("Loaded DG at Departure [174] :="
							+ strLoadedDGcargoDep);
					break;	
				case 175:// Conventional Flags For GR
					String strConventionalFlag = searchConventionalFlag(vvd, isBudget);
					hMap.put(strObjs[i].toString(), strConventionalFlag);
					log.debug("Conventional Flags For GR [175] :="
							+ strConventionalFlag);
					break;	
				case 176:// BAF
				//	String strConventionalFlag = searchConventionalFlag(vvd, isBudget);
					hMap.put(strObjs[i].toString(), "0");
					log.debug("BAF [176] := 0");
					break;		
				
				case 177://Loaded MT Q'TY
					    String strLoadedMtQty = searchLoadedMtQty(vvd,ydCd);
						hMap.put(strObjs[i].toString(), strLoadedMtQty);
						log.debug("Loaded MT Q'TY [177] := "+ strLoadedMtQty);
						break;	
			   
				case 178://ETA에서 부터 ETD까지 걸리는 기간
				    String strArrivalDay = searchArrivalDay(vvd, ydCd, clptIndSeq, isBudget);
					hMap.put(strObjs[i].toString(), strArrivalDay);
					log.debug("Berthing Date(D-A)" + "[" + 178 + "]" + strArrivalDay);
					break;				
				
				case 179://Main Engine Capacity 
				    String strMainEngCapa = searchMainEngCapa(vvd);
					hMap.put(strObjs[i].toString(), strMainEngCapa);
					log.debug("Main Engine Capacity" + "[" + 179 + "]" + strMainEngCapa);
					break;
					
				//case 168://B/T Power(BHP) - Bow Thurust Power
				//	String strBowThurustPowerBHP = getBowThurustPowerBHP(vvd);
				//	hMap.put(strObjs[i].toString(), strBowThurustPowerBHP);
				//	log.debug("Bow Thurust Power(BHP)[168]:=" + strBowThurustPowerBHP);
				//	break;	
				//case 169://B/T Power(KW)  - Bow Thurust Power
				//	String strBowThurustPowerKW = getBowThurustPowerKW(vvd);
				//	hMap.put(strObjs[i].toString(), strBowThurustPowerKW);
				//	log.debug("Bow Thurust Power(KW)[169]:=" + strBowThurustPowerKW);
				//	break;		
					
				default:
					log.debug(">>>>> in default");
					break;
				}

				// Manually Input --->
				/**
				 * hMap.put("[6]", auditDataValidVos[i].getArrnt());
				 * hMap.put("[7]", auditDataValidVos[i].getDepnt());
				 * hMap.put("[8]", auditDataValidVos[i].getArrtp());
				 * hMap.put("[9]", auditDataValidVos[i].getDeptp());
				 * hMap.put("[10]", auditDataValidVos[i].getArrtuh());
				 * hMap.put("[11]", auditDataValidVos[i].getDeptuh());
				 * hMap.put("[17]", auditDataValidVos[i].getBoat());
				 * hMap.put("[50]", auditDataValidVos[i].getArrlh());
				 * hMap.put("[52]", auditDataValidVos[i].getBarge());
				 * hMap.put("[57]", auditDataValidVos[i].getBuoy());
				 * hMap.put("[60]", auditDataValidVos[i].getDeplh());
				 * hMap.put("[75]", auditDataValidVos[i].getHoliday());
				 * hMap.put("[78]", auditDataValidVos[i].getInspection());
				 * hMap.put("[86]", auditDataValidVos[i].getNight());
				 * hMap.put("[97]", auditDataValidVos[i].getSanitation());
				 * hMap.put("[110]", auditDataValidVos[i].getTugrope());
				 * hMap.put("[111]", auditDataValidVos[i].getUsdHr());
				 */
				
			
				String curObjVal = "";
				switch (objNos[i]) {
				case 6:
					curObjVal = calcTariffVO.getArrNT();// map.get("[6]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Arr.NT[6]:=" + curObjVal);
						}
					}
					break;
				case 7:
					curObjVal = calcTariffVO.getDepNT();// map.get("[7]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Dep.NT[7]:=" + curObjVal);
						}
					}
					break;
				case 8:
					curObjVal = calcTariffVO.getArrTP();// map.get("[8]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Arr.TP[8]:=" + curObjVal);
						}
					}
					break;
				case 9:
					curObjVal = calcTariffVO.getDepTP();// map.get("[9]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Dep.TP[9]:=" + curObjVal);
						}
					}
					break;
				case 10:
					curObjVal = calcTariffVO.getArrTUH();// map.get("[10]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Arr.TUH[10]:="
									+ curObjVal);
						}
					}
					break;
				case 11:
					curObjVal = calcTariffVO.getDepTUH();// map.get("[11]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Dep.TUH[11]:="
									+ curObjVal);
						}
					}
					break;
				case 17:
					curObjVal = calcTariffVO.getBoat();// map.get("[17]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Boat[17]:=" + curObjVal);
						}
					}
					break;
				case 50:
					curObjVal = calcTariffVO.getArrLH();// map.get("[50]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Arr.LH[50]:="
											+ curObjVal);
						}
					}
					break;
				case 52:
					curObjVal = calcTariffVO.getBarge();// map.get("[52]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Barge[52]:=" + curObjVal);
						}
					}
					break;
				case 57:
					curObjVal = calcTariffVO.getBuoy();// map.get("[57]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Buoy[57]:=" + curObjVal);
						}
					}
					break;
				case 60:
					curObjVal = calcTariffVO.getDepLH();// map.get("[60]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log
									.debug("Manually Input Dep.LH[60]:="
											+ curObjVal);
						}
					}
					break;
				case 75:
					curObjVal = calcTariffVO.getHoliday();// map.get("[75]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Holiday[75]:="
									+ curObjVal);
						}
					}
					break;
				/**
				 * hMap.put("[78]", auditDataValidVos[i].getInspection());
				 * hMap.put("[86]", auditDataValidVos[i].getNight());
				 * hMap.put("[97]", auditDataValidVos[i].getSanitation());
				 * hMap.put("[110]", auditDataValidVos[i].getTugrope());
				 */

				case 78:
					curObjVal = calcTariffVO.getInspection();// map.get("[78]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Inspection[78]:="
									+ curObjVal);
						}
					}
					break;
				case 86:
					curObjVal = calcTariffVO.getNight();// map.get("[86]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Night[86]:=" + curObjVal);
						}
					}
					break;
				case 97:
					curObjVal = calcTariffVO.getSanit();// map.get("[97]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Sanitation[97]:="
									+ curObjVal);
						}
					}
					break;
				case 110:
					curObjVal = calcTariffVO.getTUGRope();// map.get("[110]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input TugRope[110]:="
									+ curObjVal);
						}
					}
					break;
				case 111:
					curObjVal = calcTariffVO.getUsdhrs();// map.get("[110]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input TugRope[110]:="
									+ curObjVal);
						}
					}
					break;
				case 119:
					curObjVal = calcTariffVO.getNewservice();// map.get("[119]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input NewService[119]:="
									+ curObjVal);
						}
					}
					break;
				case 125:
					curObjVal = calcTariffVO.getCopilot();// map.get("[125]");
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input Co-Pilot[25]:="
									+ curObjVal);
						}
					}
					break;
				case 176:
					curObjVal = calcTariffVO.getBafRt();// map.get("[125]");
					log.debug("curObjValcurObjVal"+curObjVal);
					if (curObjVal != null) {
						if (!curObjVal.equals("")) {
							hMap.put(strObjs[i].toString(), curObjVal);
							log.debug("Manually Input BAF Rate[176]:="
									+ curObjVal);
						}
					}
					break;
				default:
					break;
				}
				// Manually Input <---

				// log.debug(strObjs[i].toString());
				// Switch Case 를 타고 도 데이터 값이 없으면 Regular Value를 적용한다.
				// TODO ://Regular Value 적용 로직.
				String objVal = hMap.get(strObjs[i].toString());
				if (objVal == null) {
					objVal = getRegularValue(ydChgNo, ydChgVerSeq, objNos[i]
							+ "");
					hMap.put(strObjs[i].toString(), objVal);
					log.debug("Regular Value [" + objNos[i] + "]:=" + objVal);
				} else {
					if (objVal.equals("") || objVal.equals("0")) {
						objVal = getRegularValue(ydChgNo, ydChgVerSeq,
								objNos[i] + "");
						hMap.put(strObjs[i].toString(), objVal);
						log.debug("Regular Value [" + objNos[i] + "]:="+ objVal);
					}
				}
			}// End of Else

		}

		// String[] strXpr = sysXprDesc.split("\\|\\$\\$\\|");//계산식 amount를 위한
		// string
		String calXpr = "";
		String calDspXpr = "";
		String dspXpr = "";// dfltSysXprDesc; //Display를 위한 String
		
		String inCalXpr = "";
		String inCalDspXpr = "";
		String inDspXpr = "";
		
		String outCalXpr = "";
		String outCalDspXpr = "";
		String outDspXpr = "";
		
		calXpr = expressListVO.getSysXprDesc();
		calDspXpr = expressListVO.getDfltSysXprUsrDesc();
		dspXpr = expressListVO.getDfltSysXprValDesc();
		
		inCalXpr = calXpr;
		inCalDspXpr = calDspXpr;
		inDspXpr = dspXpr;
		
		outCalXpr = calXpr;
		outCalDspXpr = calDspXpr;
		outDspXpr = dspXpr;

		log.debug(">>>---before calXpr:=" + calXpr);
		log.debug(">>>---before calDspXpr:=" + calDspXpr);
		log.debug(">>>---before dspXpr:=" + dspXpr);

		if (calXpr == null)
			calXpr = "'null'";
		if (calDspXpr == null)
			calXpr = "null";
		if (dspXpr == null)
			calXpr = "null";

		
		// Check 'IN' and 'OUT' conditions are all 'Y'.
		boolean inCondi = false;
		boolean outCondi = false;
		for(Object obj : strObjs){
			if("[77]".equals(obj.toString())){
				if("'Y'".equals(hMap.get(obj.toString()))){
					log.debug(">>>---inCondi");
					inCondi = true;
				}
			}else if("[89]".equals(obj.toString())){
				if("'Y'".equals(hMap.get(obj.toString()))){
					log.debug(">>>---outCondi");
					outCondi = true;
				}
			}
		}
		
		// replace
		for (int i = 0; i < strObjs.length; i++) {
			if (strObjs[i].toString().equals("[45]")) // 이경우는 replace를 하면 안된다.
				continue;
			
			//log.debug("strObjs[i].toString()===>"+strObjs[i].toString());
			String strRplc = hMap.get(strObjs[i].toString());
			//log.debug("strRplc===>"+strRplc);
			
			if (strObjs[i].toString().indexOf("@") != -1) {
				for (int k = i; k < strObjs.length; k++) {
					String tmp = hMap.get(strObjs[k].toString());
					if (strObjs[k].toString().indexOf(
							strObjs[i].toString() + "<") != -1) {
						calXpr = calXpr.replace(strObjs[k].toString(), tmp);
						calDspXpr = calDspXpr.replace(strObjs[k].toString(),
								tmp);
						dspXpr = dspXpr.replace(strObjs[k].toString(), tmp);
					}
				}
			}
			
			if (strRplc != null) {

				if (StringUtil.isEmpty(strRplc)) {
					strRplc = isStrOperator(calXpr, strObjs[i].toString()) ? "null" : "0";
				}
				
				calXpr = calXpr.replace(strObjs[i].toString(), strRplc);
				
				
				calDspXpr = calDspXpr.replace(strObjs[i].toString(), strRplc);
				dspXpr = dspXpr.replace(strObjs[i].toString(), strRplc);
				log.debug(">>>---inCondiaaa"+inCondi+outCondi);
				if(inCondi && outCondi){
//					if("B".equals(strType)){ // Append to 'Base Tariff', to calculate in/out condition amount.
//						if(!"[77]".equals(strObjs[i].toString()) && !"[89]".equals(strObjs[i].toString())){
//							inCalXpr = inCalXpr.replace(strObjs[i].toString(), strRplc);;
//							outCalXpr = outCalXpr.replace(strObjs[i].toString(), strRplc);;
//						}
//					}else if("D".equals(strType)){
//						if(!"[46]".equals(strObjs[i].toString())){
//							inCalXpr = inCalXpr.replace(strObjs[i].toString(), strRplc);;
//							outCalXpr = outCalXpr.replace(strObjs[i].toString(), strRplc);;
//						}
//					}
					
					// IN/OUT Expression ==> do not replace [77:IN / 89:OUT / 46:BASE] 
					if(!"[77]".equals(strObjs[i].toString()) &&
							!"[89]".equals(strObjs[i].toString()) &&
							!"[46]".equals(strObjs[i].toString())){
						inCalXpr = inCalXpr.replace(strObjs[i].toString(), strRplc);
						inCalDspXpr = inCalDspXpr.replace(strObjs[i].toString(), strRplc);
						inDspXpr = inDspXpr.replace(strObjs[i].toString(), strRplc);
						
						outCalXpr = outCalXpr.replace(strObjs[i].toString(), strRplc);
						outCalDspXpr = outCalDspXpr.replace(strObjs[i].toString(), strRplc);
						outDspXpr = outDspXpr.replace(strObjs[i].toString(), strRplc);
					}
				}
			}
			
		}
		
		if(inCondi && outCondi){
		
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
				inCalXpr = inCalXpr.replace("[46]", calcTariffVO.getInBase());
				inCalDspXpr = inCalDspXpr.replace("[46]", calcTariffVO.getInBase());
				inDspXpr = inDspXpr.replace("[46]", calcTariffVO.getInBase());
				
				outCalXpr = outCalXpr.replace("[46]", calcTariffVO.getOutBase());
				outCalDspXpr = outCalDspXpr.replace("[46]", calcTariffVO.getOutBase());
				outDspXpr = outDspXpr.replace("[46]", calcTariffVO.getOutBase());
			}
		}
		
		log.debug(">>>---after calXpr:=" + calXpr);
		log.debug(">>>---after calDspXpr:=" + calDspXpr);
		log.debug(">>>---after dspXpr:=" + dspXpr);

		// select dual
		List<CalcTariffResultVO> list = null;
		List<CalcTariffResultVO> inResult = null;
		List<CalcTariffResultVO> outResult = null;
		//
		try {
			
			list = dbDao.executeTariff(calXpr, calDspXpr, dspXpr);// expr
//			if("B".equals(strType) && inCondi && outCondi){
			if(inCondi && outCondi){
				inResult = dbDao.executeTariff(inCalXpr, inCalDspXpr, inDspXpr);// expr
				outResult = dbDao.executeTariff(outCalXpr, outCalDspXpr, outDspXpr);// expr
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010",
					new String[] { "Tariff Calculation : executeTariff" })
					.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010",
					new String[] { "Tariff Calculation : executeTariff" })
					.getMessage(), ex);
		}
		
		String iDisFormDesc = "";
		String iRunFormDesc = "";
		String oDisFormDesc = "";
		String oRunFormDesc = "";
		
		if(inCondi && outCondi){
			String inAmt = inResult.get(0).getTariffAmount();
			String outAmt = outResult.get(0).getTariffAmount();
			if(inAmt==null || inAmt.trim().length()==0){
				inAmt = "0";
			}
			if(outAmt==null || outAmt.trim().length()==0){
				outAmt = "0";
			}
			vo.setInAmt(inAmt);
			vo.setOutAmt(outAmt);
			
			
			iDisFormDesc = inResult.get(0).getDisplayFormulaDesc();
			iRunFormDesc = inResult.get(0).getRuntimeFormulaDesc();
			
			oDisFormDesc = outResult.get(0).getDisplayFormulaDesc();
			oRunFormDesc = outResult.get(0).getRuntimeFormulaDesc();
			
			if("B".equals(strType)){
				calcTariffVO.setInBase(inAmt);
				calcTariffVO.setOutBase(outAmt);
				
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			CalcTariffResultVO rlt = list.get(i);
			
			if(inCondi && outCondi){

				vo.setTariffAmount(new BigDecimal(vo.getInAmt()).add(new BigDecimal(vo.getOutAmt())).toString());
			}else{
				vo.setTariffAmount(rlt.getTariffAmount());
			}
			if (rlt.getTariffAmount() != null) {
				if (!rlt.getTariffAmount().equals("0")) {
					if(inCondi && outCondi){
						vo.setDisplayFormulaDesc(iDisFormDesc + " + " + oDisFormDesc);
						vo.setRuntimeFormulaDesc(iRunFormDesc + " + " + oRunFormDesc);
					}else{
						vo.setDisplayFormulaDesc(rlt.getDisplayFormulaDesc());
						vo.setRuntimeFormulaDesc(rlt.getRuntimeFormulaDesc());
					}
				} else {
					if (strType.equals("B")) {// Base타입의 경우만 Error정보를 표시한다.
						vo.setDisplayFormulaDesc(rlt.getDisplayFormulaDesc()
								+ " [info]:= { " + dspXpr + " }");
						vo.setRuntimeFormulaDesc(rlt.getRuntimeFormulaDesc()
								+ " [info]:= { " + calDspXpr + " }");
					} else {
//						vo.setDisplayFormulaDesc(rlt.getDisplayFormulaDesc());
//						vo.setRuntimeFormulaDesc(rlt.getRuntimeFormulaDesc());
						if(inCondi && outCondi){
							vo.setDisplayFormulaDesc(iDisFormDesc + " + " + oDisFormDesc);
							vo.setRuntimeFormulaDesc(iRunFormDesc + " + " + oRunFormDesc);
						}else{
							vo.setDisplayFormulaDesc(rlt.getDisplayFormulaDesc());
							vo.setRuntimeFormulaDesc(rlt.getRuntimeFormulaDesc());
						}
					}
				}
			} else {// 계산값이 null이면
				vo.setDisplayFormulaDesc(rlt.getDisplayFormulaDesc());
				vo.setRuntimeFormulaDesc(rlt.getRuntimeFormulaDesc());
			}
			
			// 컬럼 길이 4000 Byte 제약 조건 때문에 수식을 제한하도록 함.
			if(vo.getDisplayFormulaDesc() != null && vo.getDisplayFormulaDesc().length() > 4000){
				vo.setDisplayFormulaDesc(vo.getDisplayFormulaDesc().substring(0, 3500));
			}
			if(vo.getRuntimeFormulaDesc() != null && vo.getRuntimeFormulaDesc().length() > 4000){
				vo.setRuntimeFormulaDesc(vo.getRuntimeFormulaDesc().substring(0, 3500));
			}
		}
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
		
		int i = expr.indexOf(str);

		if (i > -1) {		// 치환할 문자가 존재할 경우
			String expr2 = expr.substring(i + str.length()).replaceAll(" ", "");	// 다음문자를 찾기위해 빈공백을 제거한다.

			char ch = expr2.charAt(0);

			switch(ch) {
				case '=':
				case '>':
				case '<':
					isOp = true;
				break;
			}
		}
		
		return isOp;		
	}
	
	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 *   case 65://ETB DATE
	 * @category Obj65_ETBDate
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtbDate(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getEtbDate(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj65_ETBDate"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj65_ETBDate"}).getMessage(),ex);
		}
	}

	/**
	 * case 79://last Issued Invoice ETD
	 * @category Obj79_lastIssuedInvoiceETD
	 * @param String vvd
	 * @param String ydCd
	 * @param String lgsCostCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getLastInvEtd(String vvd, String ydCd, String lgsCostCd, boolean isBudget)  throws EventException{
		try {
			return  dbDao.getLastInvEtd(vvd, ydCd, lgsCostCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj79_lastIssuedInvoiceETD"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj79_lastIssuedInvoiceETD"}).getMessage(),ex);
		}
	}
	/**
	 * case 24://Country of Next Port
	 * @category Obj24_CountryofNextPort
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getCntNextPort(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getCntNextPort(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj24_CountryofNextPort"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj24_CountryofNextPort"}).getMessage(),ex);
		}
	}
	/**
	 * case 23://Country of Last Port
	 * @category Obj23_CountryofLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getCntLastPort(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getCntLastPort(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj23_CountryofLastPort"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj23_CountryofLastPort"}).getMessage(),ex);
		}
	}
	/**
	 * case 37://Anchoring Hour
	 * @category Obj37_AnchoringHour
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getAnchoringHour(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getAnchoringHour(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj37_AnchoringHour"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj37_AnchoringHour"}).getMessage(),ex);
		}
	}
	/**
	 * case 90:/Pilot Off
	 * @category Obj90_POff
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getPOff(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getPOff(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj90_POff"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj90_POff"}).getMessage(),ex);
		}
	}
	/**
	 * case 91://POB
	 * @category Obj91_Pob
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getPob(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getPob(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj91_Pob"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj91_Pob"}).getMessage(),ex);
		}
	}
	/**
	 * case 92://Rehandling Volume
	 * @category Obj92_RhVol
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getRhVol(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getRhVol(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj92_RhVol"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj92_RhVol"}).getMessage(),ex);
		}
	}
	/**
	 * case 93://Remain Vessel Call
	 * @category Obj93_RemainVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getRemainVesselCall(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getRemainVesselCall(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj93_RemainVesselCall"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj93_RemainVesselCall"}).getMessage(),ex);
		}
	}
	/**
	 * case 112://Water Volume
	 * @category Obj112_WatVol
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getWatVol(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getWatVol(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj112_WatVol"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj112_WatVol"}).getMessage(),ex);
		}
	}
	/**
	 * case 33://Outbound Volume
	 * @category Obj33_OutbundVolume
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getOutboundVolume(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getOutboundVolume(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj33_OutbundVolume"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj33_OutbundVolume"}).getMessage(),ex);
		}
	}
	/**
	 *  case 32://Inbound Volume
	 * @category Obj32_InboundVolume
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getInboundVolume(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getInboundVolume(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj32_InboundVolume"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj32_InboundVolume"}).getMessage(),ex);
		}
	}
	/**
	 *  case 32://Inbound Volume
	 * @category Obj32_InboundVolume
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getInboundVolumeTorHeaderCnt(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getInboundVolumeTorHeaderCnt(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj32_InboundVolume"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj32_InboundVolume"}).getMessage(),ex);
		}
	}	
	

	/**
	 *  case 126://Inbound Ton
	 * @category Obj126_InboundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getInboundTon(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";
			}
			return  dbDao.getInboundTon(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj126_InboundTon"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj126_InboundTon"}).getMessage(),ex);
		}
	}

	/**
	 * case 127://Outbound Ton
	 * @category Obj127_OutbundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getOutboundTon(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			if(isBudget){
				return "";
			}
			return  dbDao.getOutboundTon(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj127_OutbundTon"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj127_OutbundTon"}).getMessage(),ex);
		}
	}
	/**
	 * case 128://Rehandling Ton
	 * @category Obj128_RhTon
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getRhTon(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";
			}
			return  dbDao.getRhTon(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj128_RhTon"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj128_RhTon"}).getMessage(),ex);
		}
	}
	/**
	 * case 129://ETA Hour
	 * @category Obj129_EtaHour
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getEtaHour(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtaHour(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj129_EtaHour"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj129_EtaHour"}).getMessage(),ex);
		}
	}

	/**
	 * case 130://Cargo Volume Ton
	 * @category Obj130_CargoVolumeTon
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getCargoVolumeTon(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			if(isBudget){
				return "";
			}
			return  dbDao.getCargoVolumeTon(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj130_CargoVolumeTon"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj127_CargoVolumeTon"}).getMessage(),ex);
		}
	}

	/**
	 * case 131://Vessel Volume(FR)
	 * @category Obj131_VesselVolumeFr
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getVesselVolumeFr(String vvd) throws EventException {
		try {
			return  dbDao.getVesselVolumeFr(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj131_VesselVolumeFr"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj131_VesselVolumeFr"}).getMessage(),ex);
		}
	}
	
	/**
	 * Regular Value값을 구한다.
	 * @category getRegularValue
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String 
	 * @throws EventException
	 */
	private String getRegularValue(String ydChgNo, String ydChgVerSeq,
			String objListNo) throws EventException{
		try {
			return  dbDao.getRegularValue(ydChgNo, ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getRegularValue"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getRegularValue"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 71://ETD Time
	 * case 72://ETD1 Time
	 * @category Obj71_EtdTime
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtdTime(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtdTime(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj71_EtdTime"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj71_EtdTime"}).getMessage(),ex);
		}
	}
	/**
	 * case 70://ETD Month
	 * @category Obj70_EtdMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtdMonth(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtdMonth(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj70_EtdMonth"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj70_EtdMonth"}).getMessage(),ex);
		}
	}
	/**
	 * case 76://I/B Volume/Blocksize
	 * @category Obj76_IBVolBsz
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getIBVolBsz(String vvd, String ydCd) throws EventException{
		try {
			return  dbDao.getIBVolBsz(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj76_IBVolBsz"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj76_IBVolBsz"}).getMessage(),ex);
		}
	}
	/**
	 * case 88://O/B Volume/Blocksize
	 * @category Obj88_OBVolBsz
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getOBVolBsz(String vvd, String ydCd) throws EventException{
		try {
			return  dbDao.getOBVolBsz(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj88_OBVolBsz"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj88_OBVolBsz"}).getMessage(),ex);
		}
	}
	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 * case 69://ETD Date
	 * @category Obj69_EtdDate
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtdDate(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtdDate(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj69_EtdDate"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj69_EtdDate"}).getMessage(),ex);
		}
	}
	/**
	 * case 67://ETB Time
	 * @category Obj67_EtbTime
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtbTime(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtbTime(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj67_EtbTime"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj67_EtbTime"}).getMessage(),ex);
		}
	}
	/**
	 * case 66://ETB Month
	 * @category Obj66_EtbMonth 
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtbMonth(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtbMonth(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj66_EtbMonth"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj66_EtbMonth"}).getMessage(),ex);
		}
	}
	/**
	 * case 120://DEM/DET Holiday(ETB)
	 * @category Obj120_DemdetHolidayETB
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getDemdetHolidayETB(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getDemdetHolidayETB(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj120_DemdetHolidayETB"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj120_DemdetHolidayETB"}).getMessage(),ex);
		}
	}
	/**
	 * case 121://DEM/DET Holiday(ETD)
	 * @category Obj120_DemdetHolidayETB
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getDemdetHolidayETD(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getDemdetHolidayETD(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj121_DemdetHolidayETD"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj121_DemdetHolidayETD"}).getMessage(),ex);
		}
	}
	/**
	 * case 152://DEM/DET Holiday(ETA)
	 * @category Obj120_DemdetHolidayETA
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getDemdetHolidayETA(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getDemdetHolidayETA(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj121_DemdetHolidayETD"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj121_DemdetHolidayETD"}).getMessage(),ex);
		}
	}
	/**
	 * case 122://Ownership
	 * 해당 Vessel의 Owner가 HJS이면 Y, Charter이면 N을 리턴한다.
	 * @category Obj122_Ownership
	 * @param String vvd
	 * @return String 
	 * @throws EventException
	 */
	private String getOwnrship(String vvd) throws EventException{
		try {
			return  dbDao.getOwnrship(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj122_Ownership"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj122_Ownership"}).getMessage(),ex);
		}
	}
	/**
	 * case 123://ETB(H)
	 * SELECT TO_CHAR(VPS_ETB_DT, 'HH24')
	 * FROM VSK_VSL_PORT_SKD
	 * WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0146' AND SKD_DIR_CD = 'E' AND YD_CD = 'KRPUSHN'
	 * @category Obj123_ETB(H)
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getEtbHr(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtbHr(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj123_ETB(H)"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj123_ETB(H)"}).getMessage(),ex);
		}
	}
	/**
	 * case 124://ETD(H)
	 * SELECT TO_CHAR(VPS_ETD_DT, 'HH24')
	 * FROM VSK_VSL_PORT_SKD
	 * WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0146' AND SKD_DIR_CD = 'E' AND YD_CD = 'KRPUSHN'
	 * @category Obj124_ETD(H)
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getEtdHr(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtdHr(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj124_ETD(H)"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj124_ETD(H)"}).getMessage(),ex);
		}
	}
	/**
	 * case 149://ETA Time
	 * case 150://ETA1 Time
	 * 
	 * @category Obj149_EtaTime
	 * @category Obj150_Eta1Time
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtaTime(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtaTime(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj149_EtaTime/Obj150_Eta1Time"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj149_EtaTime/Obj150_Eta1Time"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * @param CalcTariffVO calcTariffVO
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
	private String getObjectValue(CalcTariffVO calcTariffVO, int[] objNos,
			String strObjVal, String vvd, String ydCd, String lgsCostCd,
			String ydChgNo, String ydChgVerSeq, String clptIndSeq, int i,
			int iObjListNo, String repVvd) throws EventException {
		
		boolean isBudget = calcTariffVO.isBudget();
		String torHeaderExistFlg = "N";
		log.debug("objNo : "+iObjListNo);
		switch(iObjListNo){
		   	   //Replace Pattern =    str([a-z,A-Z])*\s=
		       //                -->  strObjVal =
			   case 1: //Allowance TEU
		    	   	//SELECT CNTR_PNM_CAPA FROM  MDM_VSL_CNTR WHERE VSL_CD  = :VSL_CD
		    	   	log.debug("Allowance TEU" + "[" +1+"]");
		    	   	strObjVal = getAllwTeu(repVvd);
		    		//hMap.put(strObjs[i].toString(), strAllwTeu);
		    	   	break;
			   case 2: //Arrival Draft
		    	   	//SELECT ARR_AFTDR_HGT FROM  VSK_DEP_RPT WHERE VSL_CD  = :VSL_CD AND SKD_VOY_NO = :SKD_VOY_NO AND SKD_DIR_CD = :SKD_DIR_CD AND VPS_PORT_CD = :VPS_PORT_CD AND CLPT_IND_SEQ = :CLPT_IND_SEQ
		    	   	log.debug("Arrival Draft Feet" + "[" +2+"]");
		    	   	strObjVal = getArvDrftFeet(vvd, ydCd, isBudget);
		    	   	//hMap.put(strObjs[i].toString(), strArvDrft);
		    	   	break;
			   case 3:  //Departure Draft Meter
	    	   case 25: //Departure Draft1 Meter
		    	   	//SELECT DEP_AFTDR_HGT FROM  VSK_DEP_RPT WHERE VSL_CD  = :VSL_CD AND SKD_VOY_NO = :SKD_VOY_NO AND SKD_DIR_CD = :SKD_DIR_CD AND VPS_PORT_CD = :VPS_PORT_CD AND CLPT_IND_SEQ = :CLPT_IND_SEQ
				    log.debug("Departure Draft Meter" + "[" +3+"]");
		    	   	strObjVal = getDprDftMeter(vvd, ydCd, isBudget);
		    	   	//hMap.put(strObjs[i].toString(), strDprDft);
		    	   	break;
			   case 4: //Arrival No. of Tractor
		    	   	//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
		    	   	log.debug("Arrival No. of Tractor" + "[" +4+"]");
		    	   	strObjVal = getArvNoOfTrk(ydChgNo, ydChgVerSeq, 4+"" );
		    		//hMap.put(strObjs[i].toString(), strArvNoOfTrk);
		    	   	break;
			   case 5: //Departure No. of  Tractor
			   		//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
				    log.debug("Departure No. of  Tractor" + "[" +5+"]");
				    strObjVal = getDprNoOfTrk(ydChgNo, ydChgVerSeq, 5+"" );
		    		//hMap.put(strObjs[i].toString(), strDprNoOfTrk);
		    		break;
			   case 6: //Arrival No. of Tug
			   		//SELECT T1.ARR_TUG_BOT_KNT FROM VSK_ACT_PORT_SKD T1, VSK_VSL_PORT_SKD T2 WHERE 1 = 1 AND T1.VSL_CD = T2.VSL_CD AND T1.SKD_VOY_NO = T2.SKD_VOY_NO AND T1.SKD_DIR_CD = T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX' AND T1.SKD_VOY_NO = '0036' AND T1.SKD_DIR_CD = 'E' AND T2.YD_CD = 'KRINCYP'
				    log.debug("Arrival No. of Tug" + "[" +6+"]");
				    strObjVal = getArvNoOfTug(vvd, ydCd, isBudget);
		    		//hMap.put(strObjs[i].toString(), strArvNoOfTug);
				    break;
			   case 7: //Departure No. of Tug
		    	   	//SELECT T1.ARR_TUG_BOT_KNT FROM VSK_ACT_PORT_SKD T1, VSK_VSL_PORT_SKD T2 WHERE 1 = 1 AND T1.VSL_CD = T2.VSL_CD AND T1.SKD_VOY_NO = T2.SKD_VOY_NO AND T1.SKD_DIR_CD = T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX' AND T1.SKD_VOY_NO = '0036' AND T1.SKD_DIR_CD = 'E' AND T2.YD_CD = 'KRINCYP'
		    	   	log.debug("Departure No. of Tug" + "[" +7+"]");
		    	   	strObjVal = getDprNoOfTug(vvd, ydCd, isBudget);
		    		//hMap.put(strObjs[i].toString(), strDprNoOfTug);
		    	   	break;
			   case 8: //Arrival Tug Power
		    	   	//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
		    	   	log.debug("Arrival Tug Power" + "[" +8+"]");
		    	   	strObjVal = getArvTugPwr(ydChgNo, ydChgVerSeq, 8+"");
		    	   	//hMap.put(strObjs[i].toString(), strArvTugPwr);
		    	   	break;
			   case 9: //Departure Tug Power
		    	   	//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
		    	   	log.debug("Departure Tug Power" + "[" +9+"]");
		    	   	strObjVal = getDprTugPwr(ydChgNo, ydChgVerSeq, 9+"");
		    	   	//hMap.put(strObjs[i].toString(), strDprTugPwr);
		    	   	break;
			   case 10: //Arrival Tug Used Hour
		    	   	//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
		    	   	log.debug("Arrival Tug Used Hour" + "[" +10+"]");
		    	   	strObjVal = getArvTugUsedHour(ydChgNo, ydChgVerSeq, 10+"");
		    	   	//hMap.put(strObjs[i].toString(), strArvTugUsedHour);
		    	   	break;
			   case 11: //Departure Tug Used Hour
		    	   	//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
		    	   	log.debug("Departure Tug Used Hour" + "[" +11+"]");
		    	   	strObjVal = getDprTugUsedHour(ydChgNo, ydChgVerSeq, 11+"");
		    	   	//hMap.put(strObjs[i].toString(), strDprTugUsedHour);
		    	   	break;
			   case 13: //BeamFeet
				   //SELECT ROUND(VSL_WDT * 3.28, 4) FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' 
				   log.debug("Beam" + "[" +13+"]");
				   strObjVal = getBeamFeet(repVvd);
				   //hMap.put(strObjs[i].toString(), strBeamFeet);
				   break;
			   case 14: //BeamMeter
		    	   	//SELECT VSL_WDT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
		    	   	log.debug("Beam" + "[" +14+"]");
		    	   	strObjVal = getBeamMeter(repVvd);
		    	   	//hMap.put(strObjs[i].toString(), strBeamMeter);
		    	   	break;
			   case 15: //Berthing Hour(D-B)
		    	   	//SELECT ROUND((VPS_ETD_DT - VPS_ETB_DT) * 24, 2) FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
		    	   	log.debug("Berthing Hour(D-B)" + "[" +15+"]");
		    	   	strObjVal = getBerthingHour(vvd, ydCd, clptIndSeq, isBudget);
		    	   	//hMap.put(strObjs[i].toString(), strBerthingHour);
		    	   	break;
			   case 166: //Berthing Date(D-B)
		    	   	//SELECT (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1 FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
		    	   	log.debug("Berthing Date(D-B)" + "[" +166+"]");
		    	   	strObjVal = getBerthingDate(vvd, ydCd, clptIndSeq, isBudget);
		    	   	//hMap.put(strObjs[i].toString(), strBerthingDate);
		    	   	break;
			   case 16: //Block Size
		    	   	//SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR WHERE VSL_CD = :VSL_CD
		    	   	log.debug("Block Size" + "[" +16+"]");
		    	   	strObjVal = getBlockSize(repVvd);
		    		//hMap.put(strObjs[i].toString(), strBlockSize);
		    	   	break;
			   case 18://	Constant1
			   case 19://	Constant2
			   case 20://	Constant3
			   case 21://	Constant4
			   case 22://	Constant5
			   case 183://	Constant6
				    log.debug("Constant" + "[" +objNos[i]+"]");
				    strObjVal = "1"; //일단 1로 셋팅 
		    	   	break;
			   case 23://Country of Last Port
				   strObjVal = getCntLastPort(vvd, ydCd, isBudget);
				   if(strObjVal==null||strObjVal.equals("")) strObjVal = "/*no found : Country of Last Port*/";
	    		   log.debug("Country of Last Port[23] in [45]:="+strObjVal);
	    		   break;
			   case 24://Country of Next Port

				   strObjVal = getCntNextPort(vvd, ydCd, isBudget);
				   if(strObjVal==null||strObjVal.equals("")) strObjVal = "/*no found : Country of Next Port*/";
	    		   log.debug("Country of Next Port[24] in [45]:="+strObjVal);
	    		   break;

		       //TODO : 중복된 Object 인지 체크 필요 
			   case 26: //Departure Draft Feet
		    	   	strObjVal = getDprDftFeet(vvd, ydCd, isBudget); 
		    	   	log.debug("Departure Draft Feet in [45] " + "[" +26+"]:="+strObjVal);
		    	   	//hMap.put(strObjs[i].toString(), strDprDft);
				   	break;
			   case 27: //Garbage Volume
				   strObjVal = getGarbageVol(vvd, ydCd, isBudget);
				   log.debug("arbage Volume[27] in [45]:="+strObjVal);
				   break;
			   case 28://GRT
			   case 73://GRT 1
	    	   case 74://GRT 2
				   //SELECT GRS_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' 
				   log.debug("> in RATE2 at GRT[28]");
				   strObjVal = getVslGrt(repVvd);
				   //hMap.put(strObjs[i].toString(), strGRT);
				   break;
			   case 29://NRT
				   //SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' 
				   log.debug("> in RATE2 at NRT[29]");
				   strObjVal = getVslNrt(repVvd);
				   //.... ..... 
				   //hMap.put(strObjs[i].toString(), strNRT);
				   break;
			   case 30: //LOAFEET
				   //SELECT ROUND(LOA_LEN * 3.28, 4) FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
				   log.debug("LOAFeet" + "[" +31+"]");
				   strObjVal = getLoaFeet(repVvd);
				   //.... ..... 
				   //hMap.put(strObjs[i].toString(), strLOAFeet);
				   break;
			   case 31: //LOAMETER
				   	//SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
				   	log.debug("LOAMeter" + "[" +30+"]");
				   	strObjVal = getLoaMeter(repVvd);
				   	//hMap.put(strObjs[i].toString(), strLOA);
			   		break;
			   case 32://Inbound Volume
				   strObjVal = getInboundVolume(vvd, ydCd, isBudget);
				   if("0".equalsIgnoreCase(strObjVal)){
					   String torHeaderCnt = "0";
					   torHeaderCnt = getInboundVolumeTorHeaderCnt(vvd, ydCd, isBudget);
					   if(!"0".equalsIgnoreCase(torHeaderCnt)){
						   torHeaderExistFlg = "Y";
					   }
				   }
		    	   log.debug("Inbound Volume[32] in [45]:=" + strObjVal);
	    		   break;
			   case 33://Outbound Volume
				   strObjVal = getOutboundVolume(vvd, ydCd, isBudget);
		    	   log.debug("Outbound Volume[33] in [45]:=" + strObjVal);
				   break;
			   case 34: //Lane
		    	   	//SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = 'BAHX' AND SKD_VOY_NO = '0036' AND SKD_DIR_CD = 'E'
		    	   	log.debug("Lane" + "[" +34+"]");
		    	   	strObjVal = "'"+getLane(vvd, isBudget)+"'"; //쿼테이션 추가 2010.01.22.
		    		//hMap.put(strObjs[i].toString(), strLane);
		    	   	break;
			   case 35: //
	    		   //SELECT VSL_RGST_CNT_CD FROM mdm_vsl_cntr WHERE VSL_CD = 'HPSH'
				   strObjVal = getNalVsl(vvd);
	    		   log.debug("Nationality of Vessel [35] in [45]:="+strObjVal);
	    		   break;
			   case 36: //No. of Crew
				   strObjVal = getNoOfCrew(repVvd);
				   log.debug("No. of Crew in [45]" + "[" +36+ "]:=" + strObjVal);
				   break;
			   case 37://Anchoring Hour
	    		   strObjVal = getAnchoringHour(vvd, ydCd, isBudget);
		    	   log.debug("Anchoring Hour[37] in [45]:=" + strObjVal);
				   break;
			   case 38: //SCNT
				    String strSCNT = calcTariffVO.getScnt();//map.get("SCNT");
				    if(strSCNT==null||strSCNT.equals(""))
				    	strSCNT = getScnt(vvd);
			   		strObjVal = strSCNT;
			   		log.debug("SCNT in [45]" + "[" +38+"]:="+strObjVal);
		    		//hMap.put(strObjs[i].toString(), strScnt);
			   		break;
			   case 39://	Ship Unit

				    log.debug("Ship Unit" + "[" +39+"]");
			   		strObjVal = getShipUnit(repVvd);
			   		break;
	    	   case 40: //Sludge Volume
	    		   log.debug("Sludge Volume" + "[" +39+"]");
	    		   strObjVal = getSludgeVol(vvd, ydCd, isBudget);
	    		   break;
			   case 42:// Vessel Visit 
				   log.debug("Vessel Visit" + "[" +42+"]");
			   		strObjVal = "1";
			   		break;
			   case 46: // Base 에서 계산 된 결과 값으로 치환 
	    		   //S, D 인 경우만 처리
	    		   String strType = calcTariffVO.getCalcType();//map.get("CalcType");
	    		   String strBase = calcTariffVO.getBase();//map.get("Base");
	    		   if(strType.equals("S")||strType.equals("D")){
	    			   strObjVal = strBase;
	    		   }
	    		   log.debug("in [45] Base[46] :="+strObjVal);
	    		   break;
			   case 47://Arrival Draft Meter 
				   strObjVal = getArvDrftMeter(vvd, ydCd, isBudget);
		    	   	log.debug("Arrival Draft Meter in [45]" + "[" +47+"]:="+strObjVal);
		    	   	break;
			   case 48://Arrival Draft 1 Meter 
				   strObjVal = getArvDrftOneMeter(vvd, ydCd, isBudget);
				   log.debug("Arrival Draft1 Meter in [45]" + "[" +48+"]:="+strObjVal);
	    		   break;
	    	   case 49://Arrival Draft1 Feet 
	    		   strObjVal = getArvDrftOneFeet(vvd, ydCd, isBudget);
	    		   log.debug("Arrival Draft1 Feet in [45]" + "[" +49+"]:="+strObjVal);
	    		   break;
	    	   case 51://Arrival POB
	    		   // select ROUND((BERTH - PILOT_ARR)*24,1) FROM TDR_HEADER where vsl_cd = 'HJBH' and VOY_NO = '0021' and DIR_CD=  'W' and PORT_CD = 'KRPUS'
	    		   strObjVal = getArrPob(vvd, ydCd, isBudget);
	    		   log.debug("Arrival POB in [45]" + "[" +51+"]:="+strObjVal);
	    		   break;
	    	   case 55://Bound
	    		   strObjVal = getBound(vvd, ydCd, isBudget);
	    		   log.debug("Bound in [45]" + "[" +55+"]:="+strObjVal);
	    		   break;
	    	   case 56://Bunker Volume
	    		   // select NVL(FOIL_CAPA,0) + NVL(DOIL_CAPA,0) from mdm_vsl_cntr where vsl_cd = 'HJNA'
	    		   strObjVal = getBkerVol(vvd);
	    		   log.debug("Bunker Volume in [45]" + "[" +56+"]:="+strObjVal);
	    		   break;
	    	   case 58://Carrier
	    		   strObjVal = getCarrier(repVvd, isBudget);
	    		   log.debug("in [45] Carrier [58] :="+strObjVal);
	    		   break;
			   case 59:
		    		 //TODO : 임플리 먼트 필요 
		    		   strObjVal = "'N'";
		    		   break;
			   case 61://Departure POB
				   //SELECT ROUND((PILOT_DEP - UNBERTH)*24,1) FROM TDR_HEADER where vsl_cd = 'HJBH' and VOY_NO = '0021' and DIR_CD=  'W' and PORT_CD = 'KRPUS'
				   strObjVal = getDepPob(vvd, ydCd, isBudget);
				   log.debug("Departure POB in [45]" + "[" +61+"]:="+strObjVal);
				   break;
			   case 63://Design Capacity
				   strObjVal = getDesignCapacity(repVvd);
	    		   log.debug("Design Capacity in [45]" + "[" +63+" ]:="+strObjVal);
	    		   break;
			   case 64://DWT
				   // select NVL(DWT_WGT,0) from mdm_vsl_cntr where vsl_cd = 'HJNA'
				   strObjVal = getDwt(vvd);
	    		   log.debug("DWT in [45]" + "[" +64+" ]:="+strObjVal);
				   break;
			   case 65://ETB Date
				   strObjVal = getEtbDate(vvd, ydCd, isBudget);
	    		   log.debug("In[45] ETB Date[65]:="+strObjVal);
				   break;
			   case 66://ETB Month
				   strObjVal = getEtbMonth(vvd, ydCd, isBudget);
	    		   log.debug("ETB Month in [45]" + "[" +66+" ]:="+strObjVal);
	    		   break;
			   case 67://ETB Time
			   case 68://ETB1 Time
				   strObjVal = getEtbTime(vvd, ydCd, isBudget);
				   log.debug("ETB Time in [45]" + "[" +67+" ]:="+strObjVal);
				   break;
			   case 69://ETD Date
		    		   strObjVal = getEtdDate(vvd, ydCd, isBudget);
					   log.debug("ETD Date in [45]" + "[" +iObjListNo+" ]:="+strObjVal);
		    		   break;
			   case 70://ETD Month
		    		   strObjVal = getEtdMonth(vvd, ydCd, isBudget);
					   log.debug("ETD Month in [45]" + "[" +iObjListNo+" ]:="+strObjVal);
		    		   break;
			   case 71://ETD Time
	    	   case 72://ETD1 Time
	    		   strObjVal = getEtdTime(vvd, ydCd, isBudget);
				   log.debug("ETD Time in [45]" + "[" +iObjListNo+" ]:="+strObjVal);
	    		   break;
	    	   case 76://I/B Volume/Blocksize

	    		   strObjVal = getIBVolBsz(vvd,ydCd);;
	    		   log.debug("I/B Volume/Blocksize in[45]" + "[" +76+" ]:="+strObjVal);
	    		   break;
	    	   case 79://last Issued Invoice ETD

	    		   strObjVal = getLastInvEtd(vvd, ydCd, lgsCostCd, isBudget);
		    		log.debug("last Issued Invoice ETD[79] in [45]:="+strObjVal);
	    		   break;
	    	   case 80://LastPort
	    		   strObjVal = getLastPort(vvd, ydCd, isBudget);
		    		log.debug("Last Port [80] in [45]:="+strObjVal);
		    	   	break;
			   case 81://	LOA 1
			   case 82://	LOA 2
			   case 83://	LOA 3
				    //SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
				    log.debug("getLoa" + "[" +objNos[i]+"]");
		    	   	strObjVal = getLoa(repVvd);
				    break;
			   case 85://Next Port
				  
				    strObjVal = getNextPort(vvd, ydCd, isBudget);
				    log.debug("In [45] Next Port[85]:="+strObjVal);
		    	   	break;
			   case 168:// Next Yard

				   strObjVal = getNextYard(vvd, ydCd, isBudget);
					log.debug("Next Yard[168]:=" + strObjVal);
					break;	
				case 169:// Last Yard

					strObjVal = getLastYard(vvd, ydCd, isBudget);
					log.debug("Last Yard[169]:=" + strObjVal);
					break;	
				case 170:// Yearly Vessel Call(US)

					strObjVal = getYearlyVesselCallUs(vvd, ydCd, isBudget);
					log.debug("Yearly Vessel Call(US)" + "[" + 170 + "] :="
							+ strObjVal);
					break;			
			   case 87://NRT1
	    		   //SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' 
	    		   strObjVal = getNrtOne(repVvd);
	    		   log.debug("[45]>>NRT1[87] :="+strObjVal);
	    		   break;
	    	   case 88://O/B Volume/Blocksize

	    		   strObjVal = getOBVolBsz(vvd,ydCd);;
	    		   log.debug("I/B Volume/Blocksize in[45]" + "[" +88+" ]:="+strObjVal);
	    		   break;
	    	   case 90://Pilot Off
	    		   strObjVal = "'"+getPOff(vvd,ydCd, isBudget)+"'";
	    		   log.debug("Pilot Off in[45]" + "[" +90+" ]:="+strObjVal);
	    		   break;
	    	   case 91://POB

	    		   strObjVal = "'"+getPob(vvd,ydCd, isBudget)+"'";
	    		   log.debug("POB in[45]" + "[" +91+" ]:="+strObjVal);
	    		   break;
	    	   case 92://Rehandling Volume
	    		   strObjVal = getRhVol(vvd,ydCd, isBudget);
	    		   log.debug("Rehandling Volume in[45]" + "[" +92+" ]:="+strObjVal);
	    		   break;
	    	   case 93://Remain Vessel Call

	    		   strObjVal = getRemainVesselCall(vvd, ydCd, isBudget);
		    		log.debug("[45]>>Remain Vessel Call" + "[93] :="+strObjVal);
	    		   break;
			   case 94://Monthly Vessel Call
					strObjVal = getMonthlyVesselCall(vvd, ydCd, isBudget);
		    		log.debug("[45]>>Monthly Vessel Call" + "[" +94+"] :="+strObjVal);
		    	   	break;
			   case 95://sameVvd 
				    log.debug("sameVvd" + "[" +95+"]");
				    strObjVal = getSameVvd(vvd, ydCd, isBudget);
		    	   	break;
			   case 96://Yearly Vessel Call
				   strObjVal = getYearlyVesselCall(vvd, ydCd, isBudget);
		    	   log.debug("in[45]>>>Yearly Vessel Call" + "[" +96+"] :="+strObjVal);
	    		   break;
			   case 98: //SCNT1
				    log.debug("SCNT1" + "[" +98+"]");
				    String strSCNT1 = calcTariffVO.getScntOne();//map.get("SCNT1");
				    if(strSCNT1==null||strSCNT1.equals(""))
				    	strSCNT1 = getScnt(vvd);
			   		strObjVal = strSCNT1;
		    		//hMap.put(strObjs[i].toString(), strScnt);
			   		break;
			   case 99://ShipUnitOne
				   strObjVal = getShipUnitOne(repVvd);
				   log.debug("ShipUnit1[99] in [45]:="+strObjVal);
		    	   	break;
			   case 100://Summer Draft(F)

				   strObjVal = getSmmrDftF(repVvd);
				   log.debug("Summer Draft(F)[100] in [45]:="+strObjVal);
				   break;
			   case 101://Summer Draft(M)

				   strObjVal = getSmmrDftM(repVvd);
				   log.debug("Summer Draft(M)[101] in [45]:="+strObjVal);
				   break;
			   case 112://Water Volume

				   strObjVal = getWatVol(vvd,ydCd, isBudget);
				   log.debug("Water Volume[112] in [45]:="+strObjVal);
				   break;
			   case 114://SDR
				   log.debug("SDR" + "[" +114+"]");
			   	   String strSdr = calcTariffVO.getSDR();//map.get("SDR");
				   	if(strSdr == null || strSdr.equals(""))
				   		strSdr = getSdr();
				   strObjVal = strSdr; //일단 1 을 넣음 
		    	   	break;
		    	   	/*
		    		 * CHM-201005695-01
		    		 * 추정실적 산출시, tier의 값을 조회
		    		 */
			   case 115://Tier
				   String strTier;
				   if("Y".equals(calcTariffVO.getEstFlg())){
	    			   strTier = getTier(vvd, ydCd, isBudget);
	    		   }else{
	    			   strTier = calcTariffVO.getTier();//map.get("Tier");
	    		   }
	    		   if(strTier!=null){
	    			  strObjVal = strTier;
	    		   }
	    		   log.debug("in [45] Tier [115]:=" + strObjVal);
	    		   break;
	    		   /*
		    		* CHM-201005695-01
		    		* 추정실적 산출시, limit time의 값을 조회
		    		*/
			   case 116://Limit Time
				   String strLimitTime;
	    		   if("Y".equals(calcTariffVO.getEstFlg())){
	    			   strLimitTime = getLimitTime(vvd, ydCd, isBudget);
	    		   }else{
	    			   strLimitTime = calcTariffVO.getLimitTm();//map.get("LimitTime");
	    		   }
	    		   if(strLimitTime!=null){
	    			   strObjVal =  strLimitTime;
	    		   }
	    		   log.debug("in [45] Limit Time [116]:=" + strObjVal);
	    		   break;
			   case 117://Surcharge Amount 
	    		   //Discount 인 경우만 처리
	    		   strType = calcTariffVO.getCalcType();//map.get("CalcType");
	    		   String strSurcharge = calcTariffVO.getSurcharge();//map.get("Surcharge");
	    		   if(strType.equals("D"))
	    			   strObjVal = strSurcharge;
	    		   log.debug("Surcharge Amount [117] in [45] :="+strObjVal);
	    		   break;
			   case 118: //Block Size1 (Obj 16 Block Size와 동일한 값을 return 한다.)
		    	   	//SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR WHERE VSL_CD = :VSL_CD
		    	   	log.debug("Block Size1" + "[" +118+"]");
		    	   	strObjVal = getBlockSize(repVvd);
		    		//hMap.put(strObjs[i].toString(), strBlockSize);
		    	   	break;

			   case 120://DEM/DET Holiday(ETB)
				   strObjVal = getDemdetHolidayETB(vvd, ydCd, isBudget);
				   log.debug("in[45] DEM/DET Holiday(ETB) [120]:=" + strObjVal);
				   break;
			   case 121://DEM/DET Holiday(ETD)
				   strObjVal = getDemdetHolidayETD(vvd, ydCd, isBudget);
				   log.debug("in[45] DEM/DET Holiday(ETD) [121]:=" + strObjVal);
				   break;
	    	   case 122://Ownership
	    		   strObjVal = getOwnrship(vvd);
				   log.debug("in[45] Ownership [122]:=" + strObjVal);
	    		   break;
	    	   case 123://ETB(H)
	    		   strObjVal = getEtbHr(vvd, ydCd, isBudget);
				   log.debug("in[45] ETB(H) [123]:=" + strObjVal);
	    		   break;
	    	   case 124://ETD(H)

	    		   strObjVal = getEtdHr(vvd, ydCd, isBudget);
				   log.debug("in[45] ETD(H) [124]:=" + strObjVal);
	    		   break;
	    	   case 126://I/B (TON)
	    	
	    		   strObjVal = getInboundTon(vvd, ydCd, isBudget);
				   log.debug("in[45] I/B (TON) [126]:=" + strObjVal);
	    		   break;
	    	   case 127://O/B (TON)
	    	
	    		   strObjVal = getOutboundTon(vvd, ydCd, isBudget);
				   log.debug("in[45] O/B (TON) [127]:=" + strObjVal);
	    		   break;
	    	   case 128://RH (TON)
	    		   strObjVal = getRhTon(vvd, ydCd, isBudget);
				   log.debug("in[45] RH (TON) [128]:=" + strObjVal);
	    		   break;
	    	   case 129://ETA (H)  
	    		   strObjVal = getEtaHour(vvd, ydCd, isBudget);
	    		   log.debug("in[45] ETA (H) [129]:=" + strObjVal);
	    		   break;
	    	   case 130://Cargo Volume(Ton)  
	    		   strObjVal = getCargoVolumeTon(vvd, ydCd, isBudget);
	    		   log.debug("in[45] Cargo Volume(Ton) [130]:=" + strObjVal);
	    		   break;
	    	   case 131://Vessel Volume(FR) 
	    	   case 164://Vessel Volume(FR)1
	    	   case 165://Vessel Volume(FR)2
	    		   strObjVal = getVesselVolumeFr(vvd);
	    		   log.debug("in[45] Vessel Volume(FR) [131]:=" + strObjVal);
	    		   break;
	    	   case 132://Loaded TEU WBLP (West bound last port)
	    		   strObjVal = getstrLoadedTeuLastPort(vvd, ydCd, isBudget);
	    		   log.debug("in[45] Loaded TEU WBLP [132] :="+strObjVal);
	    		   break;
    		   /*
    		    * CHM-201005567-01
		    	* 동일 노선이 해당 Port에 연간 기항하는 횟수를 조회하는 로직을 추가
    		    */
	    	   case 133://Yearly Vessel Call Lane
				   strObjVal = getYearlyVesselCallLane(vvd, ydCd, isBudget);
		    	   log.debug("in[45]>>>Yearly Vessel Call Lane" + "[" +133+"] :="+strObjVal);
	    		   break;
	    	   case 134://vessel volume(CI)
	    		   strObjVal = getVesselVolumeCi(vvd,ydCd);
	    		   log.debug("in[45]>>>Vessel Volume Ci" + "[" +134+"] :="+strObjVal);
	    		   break;
	    	   case 135://LOA * Beam
	    		   strObjVal = getLoaBeam(vvd);
	    		   log.debug("in[45]>>>LOA*BM" + "[" +135+"] :="+strObjVal);
	    		   break;
	    	   case 136://ETB DAY
				   strObjVal = getEtbDay(vvd, ydCd, isBudget);
	    		   log.debug("In[45] ETB Day [136]:="+strObjVal);
				   break;
	    	   case 137://ETD DAY
				   strObjVal = getEtdDay(vvd, ydCd, isBudget);
	    		   log.debug("In[45] ETD Day [137]:="+strObjVal);
				   break;
	    	   case 138://SUN
				   strObjVal = "'SUN'";
	    		   log.debug("In[45] SUN [138]:="+strObjVal);
				   break;
	    	   case 139://MON
				   strObjVal = "'MON'";
	    		   log.debug("In[45] MON [139]:="+strObjVal);
				   break;
	    	   case 140://TUE
				   strObjVal = "'TUE'";
	    		   log.debug("In[45] TUE [140]:="+strObjVal);
				   break;
	    	   case 141://WED
				   strObjVal = "'WED'";
	    		   log.debug("In[45] WED [141]:="+strObjVal);
				   break;
	    	   case 142://THU
				   strObjVal = "'THU'";
	    		   log.debug("In[45] THU [142]:="+strObjVal);
				   break;
	    	   case 143://FRI
				   strObjVal = "'FRI'";
	    		   log.debug("In[45] FRI [143]:="+strObjVal);
				   break;
	    	   case 144://SAT
				   strObjVal = "'SAT'";
	    		   log.debug("In[45] SAT [144]:="+strObjVal);
				   break;
	    	   case 146://Loaded TEU EBLP
	    		   strObjVal = getstrLoadedTeuLastPort1(vvd, ydCd, isBudget );
	    		   log.debug("in[45] Loaded TEU EBLP [146] :="+strObjVal);
	    		   break;
    		   /*
				 * CHM-201007132-01 신규 Object DEM/DET Holiday ETB/ETD (except
				 * Day) 추가
				 */
				case 147:// DEM/DET Holiday ETB (except Day)
					strObjVal = searchDemdetHolidayETBExceptDay(vvd, ydCd, isBudget);
					log.debug("DEM/DET Holiday ETB(except Day) [147] :="+ strObjVal);
					break;
				case 148:// DEM/DET Holiday ETD (except Day)
					strObjVal = searchDemdetHolidayETDExceptDay(vvd, ydCd, isBudget);
					log.debug("DEM/DET Holiday ETD(except Day) [148] :="+ strObjVal);
					break;
				/*
				 * CHM-201111356-01 신규 Object 추가 ETA(T), ETA1(T)
				 */
				case 149:// ETA Time
				case 150:// ETA1 Time
					strObjVal = getEtaTime(vvd, ydCd, isBudget);
					log.debug("ETA Time" + "[" + objNos[i] + " ]:="+ strObjVal);
					break;
				/*
				 * CHM-201111356-01 신규 Object 추가 NRT 2
				 */
				case 151: // NRT2
					strObjVal = getNrtOne(repVvd); // NRT1과 동일
					log.debug("NRT2" + "[" + objNos[i] + "]:="+ strObjVal);
					break;
					
				case 152:// DEM/DET Holiday(ETD)

					strObjVal = getDemdetHolidayETA(vvd, ydCd, isBudget);
					log.debug("DEM/DET Holiday(ETA) [152] :="+ strObjVal);
					break;
					
				case 153:// DEM/DET Holiday ETD (except Day)
					strObjVal = searchDemdetHolidayETAExceptDay(vvd, ydCd, isBudget);
					log.debug("DEM/DET Holiday ETA(except Day) [153] :="+ strObjVal);
					break;
					
				case 154: // Duration
					strObjVal = getDuration(vvd, isBudget);
					log.debug("Duration [154] :=" + strObjVal);
					break;
					
				case 155: // Previous Port(TW)
					strObjVal = getPreviousTaiwanPort(vvd, ydCd);
					log.debug("Previous Port(TW) [155] :=" + strObjVal);
					break;
					
				case 156: // Yearly Vessel Call Port
					strObjVal = getYearlyVesselCallPort(vvd, ydCd, isBudget);
					log.debug("Yearly Vessel Call Port [156] :=" + strObjVal);
					break;
					
				case 157: // ETA Date
					strObjVal = getEtaDate(vvd, ydCd, isBudget);
					log.debug("ETA Date [157] :=" + strObjVal);
					break;
					
				case 158: // Berthing Hour(D-A)
					strObjVal = getBerthingHourDA(vvd, ydCd, clptIndSeq, isBudget);
					log.debug("Berthing Hour(D-A) [158] :=" + strObjVal);
					break;
					
				case 159://ETA DAY
					strObjVal = getEtaDay(vvd, ydCd, isBudget);
					log.debug("ETA Day [159] :="+strObjVal);
					break;
					
				case 160://ETA Month
					strObjVal = getEtaMonth(vvd, ydCd, isBudget);
					log.debug("ETA Month [160] :="+strObjVal);
					break;
					
				case 161://Inbound Volume(Ton) / Vessel Volume(FR)
					strObjVal = getInboundDivideVessel(vvd, ydCd, isBudget);
					log.debug("Inbound Volume(Ton) / Vessel Volume(FR) [161] :="+strObjVal);
					break;
					
				case 162://Outbound Volume(Ton) / Vessel Volume(FR)
					strObjVal = getOutboundDivideVessel(vvd, ydCd, isBudget);
					log.debug("Outbound Volume(Ton) / Vessel Volume(FR) [162] :="+strObjVal);
					break;
				case 163: //SCGT
				    String strSCGT = calcTariffVO.getScgt();//map.get("SCGT");
				    if(strSCGT==null||strSCGT.equals(""))
				    	strSCGT = getScgt(vvd);
			   		strObjVal = strSCGT;
			   		log.debug("SCGT in [45]" + "[" +163+"]:="+strObjVal);
		    		//hMap.put(strObjs[i].toString(), strScgt);
			   		break;	
				case 167: //ESIscore
					String strESIScore  = calcTariffVO.getESIScore();//map.get("ESIScore");
					if(strESIScore==null||strESIScore.equals(""))
						strESIScore = getESIScore(vvd);
					strObjVal = strESIScore;
					log.debug("ESIscore in [45]" + "[" +167+"]:="+strObjVal);
					//hMap.put(strObjs[i].toString(), strESIScore);
					break;	
			   case 171:// Loaded WGT at L/P
				   strObjVal = searchLoadedWgtLastPort(vvd,ydCd, isBudget);
					log.debug("Loaded WGT at L/P" + "[" +171+"]" );
					break;
			   case 172:// Effective DT (TONNAGE)
				   strObjVal = searchWithinEffectiveDate(vvd,ydCd, isBudget);
					log.debug("Effective DT" + "[" +172+"]" );
					break;	
			   case 173:// Loaded DG Cargo at Arrival
				   strObjVal = searchLoadedDGcargoArr(vvd,ydCd);
					log.debug("Loaded DG Cargo Arr." + "[" +173+"]" );
					break;	
			   case 174:// Loaded DG Cargo at Departure
				   strObjVal = searchLoadedDGcargoDep(vvd,ydCd);
					log.debug("Loaded DG Cargo Dep." + "[" +174+"]" );
					break;	
			   case 175:// Conventional Flags For GR
				   strObjVal = searchConventionalFlag(vvd,isBudget);
					log.debug("Conventional Flags For GR ." + "[" +175+"]" );
					break;	
			   case 176:// BAF
				   strObjVal = "0";
					log.debug("BAF ." + "[" +176+"]" );
					break;
			   case 177:// Loaded MT Q'TY
				    strObjVal = searchLoadedMtQty(vvd,ydCd);
					log.debug("Loaded MT Q'TY ." + "[" +177+"]" );
					break;	
			   case 178: //ETA에서 부터 ETD까지 걸리는 기간
				    strObjVal = searchArrivalDay(vvd, ydCd, clptIndSeq, isBudget);
				    log.debug("Berthing Date(D-A)" + "[" +178+"]");
					break;	
			   case 179://Main Engine Capacity 
				    strObjVal = searchMainEngCapa(vvd);
				    log.debug("Main Engine Capacity" + "[" +179+"]");
					break;	
					
//				case 168://B/T Power(BHP) - Bow Thurust Power
//					strObjVal = getBowThurustPowerBHP(vvd);
//					log.debug("B/T Power(BHP)[168] :="+strObjVal);
//					break;		
//				case 169://B/T Power(KW)  - Bow Thurust Power
//					strObjVal = getBowThurustPowerKW(vvd);
//					log.debug("B/T Power(KW)[169] :="+strObjVal);
//					break;
			   default: break;
		   }
		
		//Manually Input --->>>>
		String curObjVal = "";
		//---> 값을 구했는데도 Manually Input 된 값이 있으면 이넘을 이용한다.
		switch(iObjListNo){
	   	   case 6:
	   		   curObjVal = calcTariffVO.getArrNT();//map.get("[6]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   			   	   log.debug("In [45] Manually Input  Arr.NT[6]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 7:
	   		   curObjVal = calcTariffVO.getDepNT();//map.get("[7]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   			   	   log.debug("In [45] Manually Input  Dep.NT[7]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 8:
	   		   curObjVal = calcTariffVO.getArrTP();//map.get("[8]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   			   	   log.debug("In [45] Manually Input  Arr.TP[8]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 9:
	   		   curObjVal = calcTariffVO.getDepTP();//map.get("[9]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   			   	   log.debug("In [45] Manually Input  Dep.TP[9]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 10:
	   		   curObjVal = calcTariffVO.getArrTUH();//map.get("[10]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Arr.TUH[10]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 11:
	   		   curObjVal = calcTariffVO.getDepTUH();//map.get("[11]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Dep.TUH[11]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 17:
	   		   curObjVal = calcTariffVO.getBoat();//map.get("[17]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Boat[17]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 50:
	   		   curObjVal = calcTariffVO.getArrLH();//map.get("[50]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Arr.LH[50]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 52:
	   		   curObjVal = calcTariffVO.getBarge();//map.get("[52]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Barge[52]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 57:
	   		   curObjVal = calcTariffVO.getBuoy();//map.get("[57]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Buoy[57]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 60:
	   		   curObjVal = calcTariffVO.getDepLH();//map.get("[60]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Dep.LH[60]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 75:
	   		   curObjVal = calcTariffVO.getHoliday();//map.get("[75]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Holiday[75]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
    	   		 /**
			hMap.put("[78]", auditDataValidVos[i].getInspection());
			hMap.put("[86]", auditDataValidVos[i].getNight());
			hMap.put("[97]", auditDataValidVos[i].getSanitation());
			hMap.put("[110]", auditDataValidVos[i].getTugrope());
	    */

	   	   case 78:
	   		   curObjVal = calcTariffVO.getInspection();//map.get("[78]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Inspection[78]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 86:
	   		   curObjVal = calcTariffVO.getNight();//map.get("[86]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Night[86]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 97:
	   		   curObjVal = calcTariffVO.getSanit();//map.get("[97]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Sanitation[97]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 110:
	   		   curObjVal = calcTariffVO.getTUGRope();//map.get("[110]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  TugRope[110]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 111:
	   		   curObjVal = calcTariffVO.getUsdhrs();//map.get("[110]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  TugRope[110]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 119:
	   		   curObjVal = calcTariffVO.getNewservice();//map.get("[119]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  NewService[119]:="+curObjVal);
	   			   }
	   		   }
	   		   break;
	   	   case 125:
	   		   curObjVal = calcTariffVO.getCopilot();//map.get("[125]");
	   		   if(curObjVal!=null){
	   			   if(!curObjVal.equals("")){
	   				   strObjVal = curObjVal;
	   				   log.debug("In [45] Manually Input  Co-Pilot[125]:="+curObjVal);
	   			   }                   
	   		   }
	   		   break;
	   	   default: break;
		}
		//Manually Input <---<<<
		log.debug("torHeaderExistFlg : "+torHeaderExistFlg);
		// Object 값이 없는 경우에는 Regular value를 찾도록 함 - #Add 2010.08.23 by sj
		if((strObjVal == null || strObjVal.equals("") || strObjVal.equals("0"))
				&& "N".equalsIgnoreCase(torHeaderExistFlg)	
		){
			strObjVal = getRegularValue(ydChgNo, ydChgVerSeq, iObjListNo+"" );
			log.debug("Regular Value ["+iObjListNo+"]:="+strObjVal);
		}
		
		return strObjVal;
	}
	
	/**
	 *  63://Design Capacity
	 * @category Obj63_DesigCapacity
	 * @param String vvd
	 * @return String 
	 * @throws EventException
	 */
	private String getDesignCapacity(String vvd) throws EventException{
		try {
			return  dbDao.getDesignCapacity(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj63_DesigCapacity"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj63_DesigCapacity"}).getMessage(),ex);
		}
	}
	/**
	 * case 36: //No. of Crew
	 * @category Obj36_NoOfCrew 
	 * @param String vvd
	 * @return String 
	 * @throws EventException
	 */
	private String getNoOfCrew(String vvd) throws EventException{
		try {
			return  dbDao.getNoOfCrew(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj36_NoOfCrew"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj36_NoOfCrew"}).getMessage(),ex);
		}
	}
	/**
	 * case 26: //Departure Draft Feet
     * @category Obj26_DepartureDraftFeet
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getDprDftFeet(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return ""; // 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getDprDftFeet(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj26_DepartureDraftFeet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj26_DepartureDraftFeet"}).getMessage(),ex);
		}
	}
	/**
	 * case 27: //Garbage Volume
     * @category Obj27_GarbageVol
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getGarbageVol(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getGarbageVol(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj27_GarbageVol"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj27_GarbageVol"}).getMessage(),ex);
		}
	}
	/**
	 * case 40: //Sludge Volume
     * @category Obj40_SludgeVol
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getSludgeVol(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getSludgeVol(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj40_SludgeVol"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj40_SludgeVol"}).getMessage(),ex);
		}
	}
	/**
	 * case 61: //Departure POB
     * @category Obj61_DepPob
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getDepPob(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getDepPob(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj61_DepPob"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj61_DepPob"}).getMessage(),ex);
		}
	}
	/**
	 * case 58://Carrier
     * @category Obj58_Carrier 
	 * @param String vvd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getCarrier(String vvd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getCarrier(vvd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj58_Carrier"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj58_Carrier"}).getMessage(),ex);
		}
	}
	/**
	 * case 55://Bound
     * @category Obj55_Bound
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getBound(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getBound(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj55_Bound"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj55_Bound"}).getMessage(),ex);
		}
	}
	/**
	 * case 56://Bunker Volume
     * @category Obj56_BkerVol
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getBkerVol(String vvd) throws EventException{
		try {
			return  dbDao.getBkerVol(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj56_BkerVol"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj56_BkerVol"}).getMessage(),ex);
		}
	}
	/**
	 * case 64://DWT
     * @category Obj64_Dwt
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getDwt(String vvd) throws EventException{
		try {
			return  dbDao.getDwt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj64_Dwt"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj64_Dwt"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 51: //Arrival POB
     * @category Obj51_ArrPob
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getArrPob(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getArrPob(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj51_ArrPob"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj51_ArrPob"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 49://Arrival Draft1 Feet 
     * @category Obj49_ArrivalDraft1Feet 
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftOneFeet(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getArvDrftOneFeet(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj49_ArrivalDraft1Feet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj49_ArrivalDraft1Feet"}).getMessage(),ex);
		}
	}
	/**
	 * case 48://Arrival Draft 1 Meter 
     * @category Obj48_ArrivalDraft1Meter 
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftOneMeter(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getArvDrftOneMeter(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj48_ArrivalDraft1Meter"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj48_ArrivalDraft1Meter"}).getMessage(),ex);
		}
	}
	/**
	 *    case 47://Arrival Draft Meter 
	 * @category Obj47_ArrivalDraftMeter 
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftMeter(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getArvDrftMeter(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj47_ArrivalDraftMeter"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj47_ArrivalDraftMeter"}).getMessage(),ex);
		}
	}
	/**
	 *  case 96://Yearly Vessel Call
	 * @category Obj96_YearlyVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCall(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getYearlyVesselCall(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj96_YearlyVesselCall"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj96_YearlyVesselCall"}).getMessage(),ex);
		}
	}
	/**
	 *  case 170://Yearly Vessel Call(US)
	 * @category Obj170_YearlyVesselCall(US)
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCallUs(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getYearlyVesselCallUs(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj170_YearlyVesselCallUs"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj170_YearlyVesselCallUs"}).getMessage(),ex);
		}
	}
	/**
	 *  case 133://Yearly Vessel Call Lane
	 * @category Obj133_YearlyVesselCallLane
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCallLane(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getYearlyVesselCallLane(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj133_YearlyVesselCallLane"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj133_YearlyVesselCallLane"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 94://Monthly Vessel Call
     * @category Obj94_MonthlyVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getMonthlyVesselCall(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getMonthlyVesselCall(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj94_MonthlyVesselCall"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj94_MonthlyVesselCall"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 87://NRT1
	 * case 151://NRT2
	 * @category Obj87_NRT1
	 * @category Obj151_NRT2
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getNrtOne(String vvd) throws EventException {
		try {
			return  dbDao.getNrtOne(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj87_NRT1/Obj151_NRT2"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj87_NRT1/Obj151_NRT2"}).getMessage(),ex);
		}
	}
	/**
	 * case 81://	LOA 1
	 * case 82://	LOA 2
	 * case 83://	LOA 3
	 * @category Obj8123_LOA
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoa(String vvd) throws EventException{
		try {
			return  dbDao.getLoa(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj8123_LOA"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj8123_LOA"}).getMessage(),ex);
		}
	}
	/**
	 * 114://SDR
	   //우선 외부에서 설정된 SDR이 있는지 확인 
     * @category Obj114_SDR
	 * @return String
	 * @throws EventException
	 */
	private String getSdr() throws EventException {
		try {
			return  dbDao.getSdr();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj114_SDR"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj114_SDR"}).getMessage(),ex);
		}
	}
	/**
	 * 99://ShipUnitOne
	 * @category Obj99_ShipUnit1
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getShipUnitOne(String vvd) throws EventException{
		try {
			return  dbDao.getShipUnitOne(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj99_ShipUnit1"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj99_ShipUnit1"}).getMessage(),ex);
		}
	}
	/**
	 * 100://Summer Draft(F)
	 * @category Obj100_SmmrDftF
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getSmmrDftF(String vvd) throws EventException{
		try {
			return  dbDao.getSmmrDftF(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj100_SmmrDftF"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj100_SmmrDftF"}).getMessage(),ex);
		}
	}
	/**
	 * 101://Summer Draft(M)
	 * @category Obj101_SmmrDftM
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getSmmrDftM(String vvd) throws EventException{
		try {
			return  dbDao.getSmmrDftM(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj101_SmmrDftM"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj101_SmmrDftM"}).getMessage(),ex);
		}
	}
	/**
	 * 39://	Ship Unit
	 * @category Obj39_ShitUnit
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getShipUnit(String vvd) throws EventException{
		try {
			return  dbDao.getShipUnit(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj39_ShitUnit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj39_ShitUnit"}).getMessage(),ex);
		}
	}
	/**
	 * //sameVvd 
  	 * @category Obj95_sameVvd
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getSameVvd(String vvd, String ydCd, boolean isBudget)  throws EventException{
		try {
			return  dbDao.getSameVvd(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj95_sameVvd"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj95_sameVvd"}).getMessage(),ex);
		}
	}
	/**
	 * Next Port
	 * @category Obj85_NextPort
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getNextPort(String vvd, String ydCd, boolean isBudget)  throws EventException{
		try {
			return  dbDao.getNextPort(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj85_NextPort"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj85_NextPort"}).getMessage(),ex);
		}
	}
	/**
	 * Next Yard
	 * @category Obj168_NextYard
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getNextYard(String vvd, String ydCd, boolean isBudget)  throws EventException{
		try {
			return  dbDao.getNextYard(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj168_NextYard"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj168_NextYard"}).getMessage(),ex);
		}
	}
	/**
	 *  case 80://LastPort
	 * @category Obj80_LastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getLastPort(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getLastPort(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj80_LastPort"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj80_LastPort"}).getMessage(),ex);
		}
	}
	/**
	 *  case 169://LastYard
	 * @category Obj169_LastYard
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String 
	 * @throws EventException
	 */
	private String getLastYard(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getLastYard(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj169_LastYard"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj169_LastYard"}).getMessage(),ex);
		}
	}
	/**
	 * 15: //Berthing Hour
	 * //SELECT ROUND((VPS_ETD_DT - VPS_ETB_DT) * 24, 2) FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
	 * @category Obj15_BerthingHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getBerthingHour(String vvd, String ydCd, String clptIndSeq, boolean isBudget) throws EventException{
		try {
			return  dbDao.getBerthingHour(vvd, ydCd, clptIndSeq, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj15_BerthingHour"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj15_BerthingHour"}).getMessage(),ex);
		}
	}
	/**
	 * 166: //Berthing Date
	 * //SELECT (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1 FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD = 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
	 * @category Obj166_BerthingDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getBerthingDate(String vvd, String ydCd, String clptIndSeq, boolean isBudget) throws EventException{
		try {
			return  dbDao.getBerthingDate(vvd, ydCd, clptIndSeq, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj166_BerthingDate"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj166_BerthingDate"}).getMessage(),ex);
		}
	}
	/**
	 * case 3: //Departure Draft Meter
   	 * @category Obj3_DepartuerDraftMeter
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getDprDftMeter(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getDprDrftMeter(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj3_DepartuerDraftMeter"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj3_DepartuerDraftMeter"}).getMessage(),ex);
		}
	}
	/**
	 *2: //Arrival Draft
	 * @category Obj2_ArrivalDraftFeet
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getArvDrftFeet(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return "";// 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getArvDrftFeet(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj2_ArrivalDraft"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj2_ArrivalDraft"}).getMessage(),ex);
		}
	}
	/**
	 * 14: //BeamFeet
	 * //SELECT ROUND(VSL_WDT * 3.28, 4) FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj14_BeamFeet
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getBeamFeet(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getBeamFeet(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj14_BeamFeet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj14_BeamFeet"}).getMessage(),ex);
		}
	}
	/**
	 * 13: //BeamMeter
	 * //SELECT VSL_WDT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj13_BeamMeter
	 * @param String vvd
	 * @return String
	 */
	private String getBeamMeter(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getBeamMeter(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj13_BeamMeter"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj13_BeamMeter"}).getMessage(),ex);
		}
	}
	/**
	 * 11: //Departure Tug Used Hour
	 * //SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * @category Obj11_DepartureTugUsedHour
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getDprTugUsedHour(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getDprTugUsedHour(ydChgNo,ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj11_DepartureTugUsedHour"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj11_DepartureTugUsedHour"}).getMessage(),ex);
		}
	}
	/**
	 * 10: //Arrival Tug Used Hour
	 * //SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * @category Obj10_ArrivalTugUsedHour
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getArvTugUsedHour(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getArvTugUsedHour(ydChgNo,ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj10_ArrivalTugUsedHour"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj10_ArrivalTugUsedHour"}).getMessage(),ex);
		}
	}
	/**
	 * 9: //Departure Tug Power
   	 *	//SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * @category Obj9_DepartureTugPower
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getDprTugPwr(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getDprTugPwr(ydChgNo,ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj9_DepartureTugPower"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj9_DepartureTugPower"}).getMessage(),ex);
		}
	}
	/**
	 * 8: //Arrival Tug Power
	 * SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * @category Obj8_ArrivalTugPower
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getArvTugPwr(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getArvTugPwr(ydChgNo,ydChgVerSeq, objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj8_ArrivalTugPower"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj8_ArrivalTugPower"}).getMessage(),ex);
		}
	}
	/**
	 * 7: //Departure No. of Tug
	 * SELECT   T1.DEP_TUG_BOT_KNT
		  FROM   VSK_ACT_PORT_SKD T1, VSK_VSL_PORT_SKD T2
		 WHERE       1 = 1
		         AND T1.VSL_CD = T2.VSL_CD
		         AND T1.SKD_VOY_NO = T2.SKD_VOY_NO
		         AND T1.SKD_DIR_CD = T2.SKD_DIR_CD
		         AND T1.VPS_PORT_CD = T2.VPS_PORT_CD
		         AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ
		         AND T1.VSL_CD = 'BAHX'
		         AND T1.SKD_VOY_NO = '0036'
		         AND T1.SKD_DIR_CD = 'E'
		         AND T2.YD_CD = 'KRINCYP'
	 * @category Obj7_DepartureNoofTug
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getDprNoOfTug(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				log.debug("isbudget");
				return ""; // 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
	
			return  dbDao.getDprNoOfTug(vvd,ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj7_DepartureNoofTug"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj7_DepartureNoofTug"}).getMessage(),ex);
		}
	}
	/**
	 * 6: //Arrival No. of Tug
	 * SELECT T1.ARR_TUG_BOT_KNT FROM VSK_ACT_PORT_SKD T1, VSK_VSL_PORT_SKD T2 WHERE 1 = 1 AND T1.VSL_CD = T2.VSL_CD AND T1.SKD_VOY_NO = T2.SKD_VOY_NO AND T1.SKD_DIR_CD = T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX' AND T1.SKD_VOY_NO = '0036' AND T1.SKD_DIR_CD = 'E' AND T2.YD_CD = 'KRINCYP'
	 * @category Obj6_ArrivalNoofTug
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getArvNoOfTug(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			if(isBudget){
				return ""; // 사업계획인 경우 Actual 정보 없음. Regular 정보 이용할 것임.
			}
			return  dbDao.getArvNoOfTug(vvd,ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj6_ArrivalNoofTug"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj6_ArrivalNoofTug"}).getMessage(),ex);
		}
	}
	/**
	 * Departure No. of  Tractor
 	 * SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
 	 * @category Obj5_DepartureNoofTractor
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getDprNoOfTrk(String ydChgNo, String ydChgVerSeq, String objListNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getDprNoOfTrk(ydChgNo,ydChgVerSeq,objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj5_DepartureNoofTractor"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj5_DepartureNoofTractor"}).getMessage(),ex);
		}
	}
	/**
	 * SELECT DFLT_VAL FROM  PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * @category Obj4_ArrivalNoofTractor
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws EventException
	 */
	private String getArvNoOfTrk(String ydChgNo, String ydChgVerSeq,String objListNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getArvNoOfTrk(ydChgNo,ydChgVerSeq,objListNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj4_ArrivalNoofTractor"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj4_ArrivalNoofTractor"}).getMessage(),ex);
		}
	}
	/**
	 * SELECT CNTR_PNM_CAPA FROM  MDM_VSL_CNTR WHERE VSL_CD  = :VSL_CD
	 * @category Obj1_AllwTeu
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getAllwTeu(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getAllwTeu(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj1_AllwTeu"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj1_AllwTeu"}).getMessage(),ex);
		}
	}
	/**
	 * SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0) AS BLOCK_SIZE FROM MDM_VSL_CNTR WHERE VSL_CD = :VSL_CD
	 * @category Obj16_BlockSize
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getBlockSize(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getBlockSize(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj16_BlockSize"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj16_BlockSize"}).getMessage(),ex);
		}
	}
//	/**
//	 * SELECT DWT_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
//	 * @category Obj25_DeadWeight
//	 * @param String vvd
//	 * @return String
//	 * @throws EventException
//	 */
//	private String getDeadWeight(String vvd) throws EventException{
//		// TODO Auto-generated method stub
//		try {
//			return  dbDao.getDeadWeight(vvd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj25_DeadWeight"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj25_DeadWeight"}).getMessage(),ex);
//		}
//	}
	/**
	 * SELECT SUZ_NET_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj38_SCNT
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getScnt(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getScnt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj38_SCNT"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj38_SCNT"}).getMessage(),ex);
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
		// TODO Auto-generated method stub
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
//	private String getBowThurustPowerBHP(String vvd) throws EventException{
//		// TODO Auto-generated method stub
//		try {
//			return  dbDao.getBowThurustPowerBHP(vvd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj168_BowThurustBHP"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj168_BowThurustBHP"}).getMessage(),ex);
//		}
//	}
	/**
	 * SELECT BWTHST_BHP_PWR FROM MDM_VSL_CNTR WHERE VSL_CD = 'HDDH' 
	 * Towage 비용 tariff에서 Bow Thrust Power에 사용 TUG 수량이 달라짐에 따라 해당 신규 Object가 필요하오니 신규 생성 바랍니다.
	 * @category Obj169_BowThurustKW
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
//	private String getBowThurustPowerKW(String vvd) throws EventException{
//		// TODO Auto-generated method stub
//		try {
//			return  dbDao.getBowThurustPowerKW(vvd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj169_BowThurustKW"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj169_BowThurustKW"}).getMessage(),ex);
//		}
//	}
	/**
	 *SELECT SHP_IDX_SCRE FROM VSK_VSL_ADD_SPEC WHERE VSL_CD = 'HJRJ' 
	 * @category Obj167_ESIScore
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getESIScore(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getESIScore(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj167_ESIScore"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj167_ESIScore"}).getMessage(),ex);
		}
	}
	/**
	 * SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = 'BAHX' AND SKD_VOY_NO = '0036' AND SKD_DIR_CD = 'E'
	 * @category Obj34_Lane
	 * @param String vvd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getLane(String vvd, boolean isBudget) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getLane(vvd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj34_Lane"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj34_Lane"}).getMessage(),ex);
		}
	}
	/**
	 * SELECT VSL_RGST_CNT_CD FROM mdm_vsl_cntr WHERE VSL_CD = 'HPSH'
	 * @category Obj35_NalVsl
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getNalVsl(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try{
			return dbDao.getNalVsl(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj35_NalVsl"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj35_NalVsl"}).getMessage(),ex);
		}
	}
	
	/**
	 * SELECT ROUND(LOA_LEN * 3.28, 4) FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj31_LoaFeet
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoaFeet(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getLoaFeet(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj31_LoaFeet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj31_LoaFeet"}).getMessage(),ex);
		}
	}
	/**
	 * //SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj30_LoaMeter
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoaMeter(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getLoaMeter(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj30_LoaMeter"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj30_LoaMeter"}).getMessage(),ex);
		}
	}
	/**
	 * 해당 Tariff가 어떤 ObjectListNo인지 구한다. 
	 * @param String tariffNo
	 * @return String
	 * @throws EventException
	 */
	private String getObjListNo(String tariffNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getObjListNo(tariffNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getObjListNo"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getObjListNo"}).getMessage(),ex);
		}
	}
	/**
	 * TariffDetail을 이전 OBJECT의 구한 값으로 찔러서 해당 Rate값을 구해 온다. 
	 * @param String tariffNo
	 * @param String prvObjVal
	 * @param String flag
	 * @return String
	 * @throws EventException
	 */
	private String getTrfRtAmt(String tariffNo, String prvObjVal, String flag) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getTrfRtAmt(tariffNo, prvObjVal, flag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getTrfRtAmt"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getTrfRtAmt"}).getMessage(),ex);
		}
	}
	/**
	 * PSO_TARIFF테이블에서 해당 Tariff의 타입을 구해 온다. 
	 * @param String tariffNo
	 * @return String
	 * @throws EventException
	 */
	private String getPsoTrfTpCd(String tariffNo) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getPsoTrfTpCd(tariffNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getPsoTrfTpCd"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : getPsoTrfTpCd"}).getMessage(),ex);
		}
	}
	/**
	 * 주어진 VVD를 가지고 GRT의 값을 DB에서 Select한다. 
	 * //SELECT GRS_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' 
	 * @category Obj28_VslGrt
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getVslGrt(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getVslGrt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj28_VslGrt"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj28_VslGrt"}).getMessage(),ex);
		}
	}
	/**
	 * 주어진 VVD를 가지고 NRT의  값을 DB에서 Select 한다.
	 * //SELECT NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * @category Obj29_VslNrt
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getVslNrt(String vvd) throws EventException{
		// TODO Auto-generated method stub
		try {
			return  dbDao.getVslNrt(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj29_VslNrt"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj29_VslNrt"}).getMessage(),ex);
		}
	}
	
	/**
	 * Requested Advance Payment Confirm Button클릭시 실제 Invoice createion처리
	 * @category VOP_PSO_0018_confirm_click_invoicecreation
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(AuditDataValidVO[] auditDataValidVOs) throws EventException{
		List<PsoChargeVO> insertPsoChargeVoList = new ArrayList<PsoChargeVO>();
		List<PsoChgDtlVO> insertPsoChgDtlVoList = new ArrayList<PsoChgDtlVO>();

		//PSO_CHARGE에 Insert할 항목을 set한다.
		PsoChargeVO psoChargeVO = new PsoChargeVO();
		psoChargeVO.setYdCd(auditDataValidVOs[0].getYdCd());
		psoChargeVO.setVndrSeq(auditDataValidVOs[0].getVndrSeq());
		psoChargeVO.setCostOfcCd(auditDataValidVOs[0].getLgsCostCd());//일단 이렇게 맵핑 TODO 맵핑확인..
		psoChargeVO.setInvNo(auditDataValidVOs[0].getInvNo());
		psoChargeVO.setCreUsrId(auditDataValidVOs[0].getCreUsrId());
		psoChargeVO.setUpdUsrId(auditDataValidVOs[0].getUpdUsrId());
		psoChargeVO.setInvOfcCd(auditDataValidVOs[0].getOfcCd());
		psoChargeVO.setCostOfcCd(auditDataValidVOs[0].getOfcCd());
		psoChargeVO.setCurrCd("USD");
		
	
		if(auditDataValidVOs[0].getCnlTzBztpCd().equals("I")){//Invoice업무이면 
			//detail level의 값을 모두 합산한다. 
//			float fval = 0;   float에서 Double로 변경  2010.05.05
			double fval = 0;
			String strTmp = "";
			for ( int i=0; i<auditDataValidVOs.length; i++ ) { //Credits에 해당하는 값을 모두 합산한다.
				if(auditDataValidVOs[i].getLgsCostCd().length() < 6 ) //CostCODE가 6자리일 경우만 합산
					continue; 
				strTmp = auditDataValidVOs[i].getCredits();
				if(strTmp != null ){
					if(!strTmp.equals(""))
						fval += Double.parseDouble(strTmp);
				}
				else 
					fval += 0 ;
			}
			psoChargeVO.setTtlLoclAmt(fval+"");
			psoChargeVO.setInvLoclAmt(fval+"");
			psoChargeVO.setLoclNetAmt(fval+"");
			psoChargeVO.setTtlUsdAmt(fval+"");
			
			//PSO_TRNS_SLP_CTNT 2009.12.07 adding 
			psoChargeVO.setPsoTrnsSlpCtnt("AA");
		}
		else{//전도금 업무이면 
			psoChargeVO.setTtlLoclAmt(auditDataValidVOs[0].getRqstAmtSum());
			psoChargeVO.setInvLoclAmt(auditDataValidVOs[0].getRqstAmtSum());
			psoChargeVO.setLoclNetAmt(auditDataValidVOs[0].getRqstAmtSum());
			psoChargeVO.setTtlUsdAmt(auditDataValidVOs[0].getRqstAmtSum());
			
			//PSO_TRNS_SLP_CTNT 2009.12.07 adding 
			psoChargeVO.setPsoTrnsSlpCtnt("GO");
		}
		psoChargeVO.setDueDt(auditDataValidVOs[0].getDueDt());
		psoChargeVO.setPsoChgStsCd("A");//Active 로 설정한다. 
		

		insertPsoChargeVoList.add(psoChargeVO);
		
		try {
			//Step2.PSO_CHG 항목을 insert한다.
			// ??? insert전에 PsoChg의 PK를 따는 로직이 추가 될 수 도 있다. here .. 
			//TODO PK따는 로직 추가 아마도 있을 수도 있다.
			dbDao.addPsoCharge(insertPsoChargeVoList);
			log.debug("\nXXX>> Total USD : " + insertPsoChargeVoList.size() + ", " + insertPsoChargeVoList.get(0).getTtlUsdAmt());
			
			//Step3.PSO_CHG_DTL항목을 insert한다. //logistics별로 인서트 된다. 
			for ( int i=0; i<auditDataValidVOs.length; i++ ) {
				//TODO 
				PsoChgDtlVO vo = new PsoChgDtlVO();
				if(auditDataValidVOs[0].getCnlTzBztpCd().equals("I")){//Invoice업무이면
					if(auditDataValidVOs[i].getLgsCostCd().length() < 6 ) 
						continue; 
				}
				vo.setVslCd(auditDataValidVOs[i].getVvd().substring(0, 4));
				vo.setSkdVoyNo(auditDataValidVOs[i].getVvd().substring(4, 8));
				vo.setSkdDirCd(auditDataValidVOs[i].getVvd().substring(8, 9));
				
				if(auditDataValidVOs[0].getCnlTzBztpCd().equals("I")){//Invoice업무이면					
					vo.setLoclAmt(auditDataValidVOs[i].getCredits());//요청된 Amount값 
					vo.setUsdAmt(auditDataValidVOs[i].getCredits());//요청된 Amount값
				}
				else{
					vo.setLoclAmt(auditDataValidVOs[i].getRqstAmt());//요청된 Amount값 
					vo.setUsdAmt(auditDataValidVOs[i].getRqstAmt());//요청된 Amount값
				}
				
				vo.setCalcAmt(auditDataValidVOs[i].getCalcAmt());//자동 계산 된 Amount값
				vo.setXprDesc(auditDataValidVOs[i].getDfltXprDesc());
				vo.setLgsCostCd(auditDataValidVOs[i].getLgsCostCd());
				vo.setFomlDesc(auditDataValidVOs[i].getSysXprDesc());//TODO 순서 바꿔야 된다.
				vo.setYdChgNo(auditDataValidVOs[i].getYdChgNo());
				vo.setYdChgVerSeq(auditDataValidVOs[i].getYdChgVerSeq());
				vo.setDiffRmk(auditDataValidVOs[i].getDiffRmk());
				vo.setSoDtlSeq(i+1+"");
				vo.setCreUsrId(auditDataValidVOs[0].getCreUsrId());
				vo.setUpdUsrId(auditDataValidVOs[0].getUpdUsrId());
				vo.setIoBndCd("O");
				vo.setDiffRmk(auditDataValidVOs[i].getDiffRmk());
				insertPsoChgDtlVoList.add(vo);
				
				log.debug("\nXXX>> Detail USD : " + vo.getUsdAmt()); 
			}
			dbDao.addPsoChgDtl(insertPsoChgDtlVoList);
			
			//--> 여기 까지 하믄.. 끝..
//			dbDao.manageGenInvAudit(auditDataValidVOs);
			//ToCSR처리 
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getMessage(),ex);
		}
	}
	
	/**
	 * 주어진 조건으로 PSO_YD_CHG 의 정보를 조회 한다. 
	 * @category VOP_PSO_0014_searchPsoYdChg
	 * @param String lgsCostCd
	 * @param String ydCd
	 * @param String vndrSeq
	 * @param String issDt
	 * @return List<PsoYdChgVO>
	 * @throws EventException
	 */
	public List<PsoYdChgVO> searchPsoYdChg(String lgsCostCd, String ydCd,
			String vndrSeq, String issDt) throws EventException {
		// TODO Auto-generated method stub
		try {
			return  dbDao.searchPsoYdChg(lgsCostCd, ydCd, vndrSeq, issDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}

	/**
	 * Issue Date 가 변경 될 경우 Effective Date 를 조회한다.
	 * @category VOP_PSO_0014_onChangeIssueDate
	 * @param String issDt
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchEffDateByIssDate(String issDt, String ofcCd)
			throws EventException {
		try {
			return  dbDao.searchEffDateByIssDate(issDt, ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 저장처리를 한다.<br />
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO[] invAuditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(
			InvAuditDataValidVO[] invAuditDataValidVOs)
			throws EventException {
		try {
			List<PsoChgDtlVO> insertVoList = new ArrayList<PsoChgDtlVO>();
			//List<PsoChgDtlVO> updateVoList = new ArrayList<PsoChgDtlVO>();
			List<PsoChgDtlVO> deleteVoList = new ArrayList<PsoChgDtlVO>();
			/*
			≪≫ addPsoCharge ( [in] chargeVO ) : PsoChargeVO
			≪≫ modifyPsoCharge (  )
			≪≫ addPsoChargeDetail ( [in] chgDtlVO ) : PsoChgDtlVO
			≪≫ modifyPsoChargeDetail (  )
			≪≫ removePsoChargeDetail (  )
			≪≫ removePsoCharge (  )
			*/
			// 해당 PSO_CHARGE에 데이터가 존재 하는지 확인 
			// 존재 하면 Update 존재하지 않으면 ADD 처리 
			PsoChargeVO mastervo = new PsoChargeVO();
			
			//log.error("===================="+invAuditDataValidVOs[0].getPsoChgStsCd());
			
			
			if(invAuditDataValidVOs.length > 0 ) {
				
				List<PsoChargeVO> lst = dbDao.isExistPsoCharge(invAuditDataValidVOs[0].getYdCd(), invAuditDataValidVOs[0].getVndrSeq(), invAuditDataValidVOs[0].getInvNo());
				
				List<PsoChargeVO> modifyPsoChargeList = new ArrayList<PsoChargeVO>();
				
				if (lst.size() > 0) {//PK 설정 
					//if(!"A".equals(invAuditDataValidVOs[0].getPsoChgStsCd()) && invAuditDataValidVOs[0].getUpdateflag().equals("false")){// 기존재 하는 넘이므로 에러 처리 
					if(invAuditDataValidVOs[0].getUpdateflag().equals("false")){// 기존재 하는 넘이므로 에러 처리
						throw new EventException(new ErrorHandler("PSO90006").getMessage());//이미 존재하는 데이터 처리
					}
					mastervo.setIssCtyCd(lst.get(0).getIssCtyCd());
					mastervo.setSoSeq(lst.get(0).getSoSeq());
				}
				else
					mastervo.setIssCtyCd(invAuditDataValidVOs[0].getInvOfcCd().substring(0, 3));//신규의 경우 InvoiceOfcCd의 앞 3자리를 취한다.
				mastervo.setPsoChgStsCd("I");
//				mastervo.setSoSeq(invAuditDataValidVOs[0].getSoSeq());
				mastervo.setYdCd(invAuditDataValidVOs[0].getYdCd());
				mastervo.setVndrSeq(invAuditDataValidVOs[0].getVndrSeq());
				mastervo.setCostOfcCd(invAuditDataValidVOs[0].getCostOfcCd());
				mastervo.setInvOfcCd(invAuditDataValidVOs[0].getInvOfcCd());
				mastervo.setInvNo(invAuditDataValidVOs[0].getInvNo());
				mastervo.setCurrCd(invAuditDataValidVOs[0].getCurrCd());
				
				mastervo.setInvLoclAmt(invAuditDataValidVOs[0].getInvLoclAmt().replace(",",""));				//[2010.04.07:jmh] INV Amt
				mastervo.setLoclTaxAmt(invAuditDataValidVOs[0].getLoclTaxAmt().replace(",",""));
				mastervo.setLoclWhldTaxAmt(invAuditDataValidVOs[0].getLoclWhldTaxAmt().replace(",",""));	//[2010.04.07:jmh] WHLD Amt
				mastervo.setLoclNetAmt(invAuditDataValidVOs[0].getLoclNetAmt().replace(",",""));
				mastervo.setLoclDdctAmt(invAuditDataValidVOs[0].getLoclDdctAmt().replace(",",""));
				mastervo.setTtlLoclAmt(invAuditDataValidVOs[0].getTtlLoclAmt().replace(",",""));

				mastervo.setIssDt(invAuditDataValidVOs[0].getIssDt());
				mastervo.setPsoTrnsSlpCtnt(invAuditDataValidVOs[0].getPsoTrnsSlpCtnt().equals("Y") ? "AR":"");//2009.11.24 adding column

				String usdAmt = dbDao.getUsdAmt(mastervo.getTtlLoclAmt().replace(",",""), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
				String usdAmts[] = usdAmt.split("\\|", 2);
				if(usdAmts.length>=2){
					if(usdAmts[0].equals("")){
						mastervo.setTtlUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
					}
					else{
						mastervo.setTtlUsdAmt(usdAmts[0]);
					}
				}
				mastervo.setAcptDt(invAuditDataValidVOs[0].getAcptDt());
				mastervo.setEffDt(invAuditDataValidVOs[0].getEffDt());
				mastervo.setUpdUsrId(invAuditDataValidVOs[0].getUsrId());//Update user 설정 
				//Payment Term Day 와 DueDate를 설정한다. 
				List<TermDueVO> tdlist = dbDao.getTermDueDate(mastervo.getVndrSeq(), mastervo.getIssDt());
				if(tdlist!=null){
					TermDueVO tdvo = tdlist.get(0);
					mastervo.setPayTermDys(tdvo.getPayTermDays());
					mastervo.setDueDt(tdvo.getDueDt());
				}
				
				if(lst.size()>0){//Update
					modifyPsoChargeList.add(mastervo);
					dbDao.modifyPsoCharge(modifyPsoChargeList);
				}
				else{//Insert 
					List<PsoChargeVO> insertPsoChargeVoList = new ArrayList<PsoChargeVO>();
					mastervo.setCreUsrId(invAuditDataValidVOs[0].getUsrId());//Create user 설정 
					insertPsoChargeVoList.add(mastervo);
					dbDao.addPsoCharge(insertPsoChargeVoList);
				}
			}
			
			// ddtLoclAmt = 0;
			//double netLoclAmt = 0;
			List<TpbIfVO> tpbIfVOs = new ArrayList<TpbIfVO>(); //tpb interface 정보를 담을 vo list
			
			for ( int i=0; i<invAuditDataValidVOs.length; i++ ) {
				InvAuditDataValidVO vo = invAuditDataValidVOs[i];
				PsoChgDtlVO vo1 = new PsoChgDtlVO();
				PsoChgDtlVO vo2 = new PsoChgDtlVO();
				
				//log.error("TEST--------->" +vo.getIbflag());
				/*
				if ( vo.getIbflag().equals("I")){

					
					setInsertList(insertVoList, mastervo, vo, vo1, vo2);
					
				
				} else if ( vo.getIbflag().equals("U")){

					
					setInsertList(insertVoList, mastervo, vo, vo1, vo2);
				}
				*/
				
				setInsertList(insertVoList, mastervo, vo, vo1, vo2);
				
				vo1.setIssCtyCd(mastervo.getIssCtyCd());
				vo1.setSoSeq(mastervo.getSoSeq());
				vo1.setSoDtlSeq(vo.getSoDtlSeq());
				vo1.setIbflag("U"); //Update 에서 온 Delete의 경우 
				deleteVoList.add(vo1);
				
				
				/*
				} else if ( vo.getIbflag().equals("D")){
					vo1.setIssCtyCd(mastervo.getIssCtyCd());
					vo1.setSoSeq(mastervo.getSoSeq());
					vo1.setSoDtlSeq(vo.getSoDtlSeq());
					vo1.setVslCd(vo.getVslCd());
					vo1.setSkdVoyNo(vo.getSkdVoyNo());
					vo1.setSkdDirCd(vo.getSkdDirCd());
					vo1.setLgsCostCd(vo.getAcctCd());
					vo1.setIoBndCd(vo.getIo().equals("IN") ? "I":"O");
					vo1.setLoclAmt(vo.getAmount());
					String usdAmt = dbDao.getUsdAmt(vo.getAmount(), vo.getCurrCd(), vo.getIssDt(), "1");
					String usdAmts[] = usdAmt.split("\\|", 2);
					if(usdAmts.length>=2){
						if(usdAmts[0].equals("")){
							vo1.setUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
						}
						else{
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
					deleteVoList.add(vo1);
				}
				*/
				
				/*
				if(vo1.getLoclAmt() != null){
					if(Double.parseDouble(vo1.getLoclAmt()) >= 0){
						netLoclAmt += Double.parseDouble(vo1.getLoclAmt());
					} else{						
						ddtLoclAmt += Double.parseDouble(vo1.getLoclAmt());
					}
				}
				*/
				
				//TPB INTERFACE 할 데이터를 미리 SETTING.
				if("Y".equals(vo.getN3ptyBilIfFlg())){
					TpbIfVO tempVO = new TpbIfVO();
					tempVO.setIssCtyCd(mastervo.getIssCtyCd());
					tempVO.setSoSeq(mastervo.getSoSeq());
					tempVO.setN3ptyBilTpCd(vo.getN3ptyBilTpCd());
					tempVO.setIfOfcCd(mastervo.getInvOfcCd());
					tempVO.setCostOfcCd(mastervo.getCostOfcCd());
					tempVO.setInvNo(mastervo.getInvNo());
					tempVO.setVslCd(vo.getVslCd());
					tempVO.setSkdVoyNo(vo.getSkdVoyNo());
					tempVO.setSkdDirCd(vo.getSkdDirCd());
					tempVO.setYdCd(mastervo.getYdCd());//TPB 팝업을 통해 지정된 vndr
//					tempVO.setVndrSeq(mastervo.getVndrSeq());//pso invoice의 vndr
					tempVO.setVndrSeq(vo.getN3ptyVndrSeq());
					tempVO.setIfCurrCd(mastervo.getCurrCd());
					tempVO.setIfAmt(vo.getAmount());//안쪼개진 금액
					tempVO.setIfRmk(vo.getIfRmk());
					tempVO.setAcctCd(vo.getCostCd());//바뀌어 들어가있음
					tempVO.setLgsCostCd(vo.getAcctCd());//바뀌어 들어가있음
	//				tempVO.setVpsEtdDt(vo.getAtd());
					tempVO.setIfUsrId(vo.getUsrId());
					tempVO.setCreUsrId(vo.getUsrId());
						
					tpbIfVOs.add(tempVO);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePsoChargeDetail(deleteVoList);
			}

			if (mastervo.getSoSeq()!=null){
				removeTpbInv(mastervo.getIssCtyCd(), mastervo.getSoSeq());
			}
			int cnt=0;
			for(PsoChgDtlVO targetVO : insertVoList){
				dbDao.addPsoChargeDetail(targetVO);
				log.debug("getCostCalcEffFmDt"+targetVO.getCostCalcEffFmDt());
				if(targetVO.getN3ptyBilIfFlg()!=null && "Y".equals(targetVO.getN3ptyBilIfFlg())){
					dbDao.addTpbInv(tpbIfVOs.get(cnt));
					cnt++;
				}
			}
			
			/*
			List<PsoChargeVO> modifyAmtPsoChargeList = new ArrayList<PsoChargeVO>();
			//TtlLoclAmt = InvLoclAmt - VAT + Withholding
			mastervo.setTtlLoclAmt(Double.parseDouble(invAuditDataValidVOs[0].getInvLoclAmt().replace(",","")) - Double.parseDouble(invAuditDataValidVOs[0].getLoclTaxAmt().replace(",","")) + Double.parseDouble(invAuditDataValidVOs[0].getLoclWhldTaxAmt().replace(",","")) + "");
			mastervo.setLoclDdctAmt(ddtLoclAmt + "");
			mastervo.setLoclNetAmt(netLoclAmt + "");
			//mastervo.setIssCtyCd(issCtyCd)
			modifyAmtPsoChargeList.add(mastervo);
			dbDao.modifyPsoCharge(modifyAmtPsoChargeList);
			*/
			
			/*[jmh]
			if ( updateVoList.size() > 0 ) {//Update는 Delete Insert로 처리 
//				dbDao.removePsoChargeDetail(deleteVoList);
//				dbDao.addPsoChargeDetail(insertVoList);
				dbDao.modifyPsoChargeDetail(updateVoList);
			}
			*/
		} 
		catch (EventException e){
			throw e;
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
		
	}
	/**
	 * @param List<PsoChgDtlVO> insertVoList
	 * @param PsoChargeVO mastervo
	 * @param InvAuditDataValidVO vo
	 * @param PsoChgDtlVO vo1
	 * @param PsoChgDtlVO vo2
	 * @throws DAOException
	 */
	private void setInsertList(List<PsoChgDtlVO> insertVoList,
			PsoChargeVO mastervo, InvAuditDataValidVO vo, PsoChgDtlVO vo1,
			PsoChgDtlVO vo2) throws DAOException {
		//1. IN/OUT BOUND의 Flag 값에 따라 처리 분기 

		log.debug("vo.getIo()"+vo.getIo());
		if(vo.getIo().equals("INOUT")){//All의 경우 
			if(vo.getYdCd().indexOf("EGSUZ") != -1 || vo.getYdCd().indexOf("PAPAC")!=-1){// EGSUZ, PAPAC는 무조건 OUT BOUND 가 100 임
				log.debug("vo.getIo2()"+vo.getIo());
				vo1.setIssCtyCd(mastervo.getIssCtyCd());
				vo1.setSoSeq(mastervo.getSoSeq());
				vo1.setSoDtlSeq(vo.getSoDtlSeq());
				vo1.setVslCd(vo.getVslCd());
				vo1.setSkdVoyNo(vo.getSkdVoyNo());
				vo1.setSkdDirCd(vo.getSkdDirCd());
				vo1.setLgsCostCd(vo.getAcctCd());//AcctCd의 Code값에 Lgs COST CD가 담겨져 있기 때문 
				vo1.setIoBndCd("O");
				vo1.setDpIoBndCd("");
				vo1.setLoclAmt(vo.getAmount());
				String usdAmt = dbDao.getUsdAmt(vo.getAmount(), vo.getCurrCd(), vo.getIssDt(), "1");
//							usdAmt = "|2";
				String usdAmts[] = usdAmt.split("\\|", 2);
				if(usdAmts.length>=2){
					if(usdAmts[0].equals("")){
						vo1.setUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
					}
					else{
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
				vo1.setCostCalcEffFmDt(vo.getCostCalcEffFmDt());
				vo1.setCostCalcEffToDt(vo.getCostCalcEffToDt());
				vo1.setCreUsrId(vo.getUsrId());
				vo1.setUpdUsrId(vo.getUsrId());
				//xmlType으로 데이터 저장
				setInvCondDesc(vo, vo1);
				
				//IO Ratio를 구하지 못한 경우 RLANE_CD와 RLANE_DIR_CD를 구한다. 2009.11.26. 추가 Logic 
				String strRevLaneDir = dbDao.getRevLaneDir(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(),"");
				String aryRevLaneDir[] = strRevLaneDir.split("\\|", 2);
				vo1.setRlaneCd(aryRevLaneDir[0]);
				vo1.setRevDirCd(aryRevLaneDir[1]);
				vo1.setN3ptyBilIfFlg(vo.getN3ptyBilIfFlg());//tpb대상건 여부
				vo1.setMnlInpXchRt(vo.getMnlInpXchRt());	//Exchange Rate
				
				insertVoList.add(vo1);
			}
			else{
				log.debug("vo.getIo3()"+vo.getIo());
				vo.setOrgFlg("I");//Invoice설정.. OrgFlg
				List<IoRatioVO> rList = dbDao.getIoRatio(vo);
				if(rList != null){
					log.debug("vo.getIo4()"+vo.getIo());
					if(rList.size() == 0){//OutBound 100%
						vo1.setIssCtyCd(mastervo.getIssCtyCd());
						vo1.setSoSeq(mastervo.getSoSeq());
						vo1.setSoDtlSeq(vo.getSoDtlSeq());
						vo1.setVslCd(vo.getVslCd());
						vo1.setSkdVoyNo(vo.getSkdVoyNo());
						vo1.setSkdDirCd(vo.getSkdDirCd());
						vo1.setLgsCostCd(vo.getAcctCd());
						vo1.setIoBndCd("O");
						vo1.setDpIoBndCd("");
						vo1.setLoclAmt(vo.getAmount());
						String usdAmt = dbDao.getUsdAmt(vo.getAmount(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
						String usdAmts[] = usdAmt.split("\\|", 2);
						if(usdAmts.length>=2){
							if(usdAmts[0].equals("")){
								vo1.setUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
							}
							else{
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
						
						//xmlType으로 데이터 저장
						setInvCondDesc(vo, vo1);
						
						//IO Ratio를 구하지 못한 경우 RLANE_CD와 RLANE_DIR_CD를 구한다. 2009.11.26. 추가 Logic 
						String strRevLaneDir = dbDao.getRevLaneDir(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(),"");
						String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
						vo1.setRlaneCd(aryRevLaneDir[0]);
						vo1.setRevDirCd(aryRevLaneDir[1]);
						vo1.setArYrmon(aryRevLaneDir[2]);
						vo1.setN3ptyBilIfFlg(vo.getN3ptyBilIfFlg());//tpb대상건 여부
						vo1.setMnlInpXchRt(vo.getMnlInpXchRt());	//Exchange Rate

						insertVoList.add(vo1);
					}
					else if(rList.size() == 2){//in out bound 2 record insert
						log.debug("vo.getIo5()"+vo.getIo());
						IoRatioVO rvo1 = rList.get(0);
						IoRatioVO rvo2 = rList.get(1);
						vo1.setIssCtyCd(mastervo.getIssCtyCd());
						vo1.setSoSeq(mastervo.getSoSeq());
						vo1.setSoDtlSeq(vo.getSoDtlSeq());
						vo1.setVslCd(vo.getVslCd());
						vo1.setSkdVoyNo(rvo1.getSkdVoyNo());
						vo1.setSkdDirCd(rvo1.getSkdDirCd());
						vo1.setLgsCostCd(vo.getAcctCd());
						vo1.setRevDirCd(rvo1.getRlaneDirCd());
						vo1.setRlaneCd(rvo1.getRlaneCd());
						vo1.setIoBndCd("O");
						vo1.setDpIoBndCd("");
						RoundTruncVO rtvo1in = new RoundTruncVO();
						rtvo1in.setIoBndCd("O");
						rtvo1in.setRatio(rvo1.getObRto());
						rtvo1in.setCurrCd(mastervo.getCurrCd());
						rtvo1in.setLoclAmt(vo.getAmount());
						rtvo1in.setCalcAmt(vo.getTariffCost());
						rtvo1in.setAdjAmt(vo.getAdjcost());
						if(rtvo1in.getRatio().equals("")||rtvo1in.getRatio()==null)
							rtvo1in.setRatio("50");
						RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
						
						vo1.setLoclAmt(rtvo1out.getLoclAmt());
//									vo1.setUsdAmt("");//계산식으로 구해야 될 부분
						String usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
						String usdAmts[] = usdAmt.split("\\|", 2);
						if(usdAmts.length>=2){
							if(usdAmts[0].equals("")){
								vo1.setUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
							}
							else{
								vo1.setUsdAmt(usdAmts[0]);
							}
						}
						vo1.setCalcAmt(rtvo1out.getCalcAmt());
						vo1.setAdjAmt(rtvo1out.getAdjAmt());
						vo1.setXprDesc(vo.getFoml2());
						vo1.setFomlDesc(vo.getFoml1());
						vo1.setYdChgNo(vo.getYdChgNo());
						vo1.setYdChgVerSeq(vo.getYdChgVerSeq());
						vo1.setDiffRmk(vo.getRemark());
						vo1.setArYrmon(rvo1.getRevYrmon());
						vo1.setCreUsrId(vo.getUsrId());
						vo1.setUpdUsrId(vo.getUsrId());
						vo1.setN3ptyBilIfFlg(vo.getN3ptyBilIfFlg());//tpb대상건 여부. inbound(virtual)에는 flg를 저장하지 않음
						vo1.setMnlInpXchRt(vo.getMnlInpXchRt());	//Exchange Rate
						vo1.setCostCalcEffFmDt(vo.getCostCalcEffFmDt());
						vo1.setCostCalcEffToDt(vo.getCostCalcEffToDt());
						vo2.setIssCtyCd(mastervo.getIssCtyCd());
						vo2.setSoSeq(mastervo.getSoSeq());
						vo2.setSoDtlSeq(vo.getSoDtlSeq());
						vo2.setVslCd(vo.getVslCd());
						vo2.setSkdVoyNo(rvo2.getSkdVoyNo());
						vo2.setSkdDirCd(rvo2.getSkdDirCd());
						vo2.setLgsCostCd(vo.getAcctCd());
						vo2.setRevDirCd(rvo2.getRlaneDirCd());
						vo2.setRlaneCd(rvo2.getRlaneCd());
						
						
						vo2.setIoBndCd("I");
						vo2.setDpIoBndCd("");
						RoundTruncVO rtvo2in = new RoundTruncVO();
						rtvo2in.setIoBndCd("I");
						rtvo2in.setRatio(rvo2.getIbRto());
						rtvo2in.setCurrCd(mastervo.getCurrCd());
						rtvo2in.setLoclAmt(vo.getAmount());
						rtvo2in.setCalcAmt(vo.getTariffCost());
						rtvo2in.setAdjAmt(vo.getAdjcost());
						RoundTruncVO rtvo2out = dbDao.getRoundTruncAmt(rtvo2in);
						
						vo2.setLoclAmt(rtvo2out.getLoclAmt());

						//-------------AS
						String usdAmt2 = dbDao.getUsdAmt(rtvo2out.getLoclAmt(),  mastervo.getCurrCd(), mastervo.getIssDt(), "1");
						String usdAmts2[] = usdAmt2.split("\\|", 2);
						if(usdAmts2.length>=2){
							if(usdAmts[0].equals("")){
								vo2.setUsdAmt(usdAmts2[1]);//계산식으로 구해야 될 부분 
							}
							else{
								vo2.setUsdAmt(usdAmts2[0]);
							}
						}
						vo2.setCalcAmt(rtvo2out.getCalcAmt());
						vo2.setAdjAmt(rtvo2out.getAdjAmt());
						vo2.setXprDesc(vo.getFoml2());
						vo2.setFomlDesc(vo.getFoml1());
						vo2.setYdChgNo(vo.getYdChgNo());
						vo2.setYdChgVerSeq(vo.getYdChgVerSeq());
						vo2.setDiffRmk(vo.getRemark());
						vo2.setArYrmon(rvo2.getRevYrmon());
						vo2.setCreUsrId(vo.getUsrId());
						vo2.setUpdUsrId(vo.getUsrId());
						vo2.setOrgSoDtlSeq("-999");//OUTBOUND의 SO_DTL_SEQ를저장하기위한 Inform정보 
						
						//xmlType으로 데이터 저장
						setInvCondDesc(vo, vo1);
						//xmlType으로 데이터 저장
						setInvCondDesc(vo, vo2);
						
						insertVoList.add(vo1);
						insertVoList.add(vo2);
					}//end of else if 
					
					else{//Row 가 1개 인경우 Outbound 에 RTO = 100 에 대한 처리 추가
						log.debug("vo.getIo6()"+vo.getIo());
						IoRatioVO rvo1 = rList.get(0);
						vo1.setIssCtyCd(mastervo.getIssCtyCd());
						vo1.setSoSeq(mastervo.getSoSeq());
						vo1.setSoDtlSeq(vo.getSoDtlSeq());
						vo1.setVslCd(vo.getVslCd());
						vo1.setSkdVoyNo(rvo1.getSkdVoyNo());
						vo1.setSkdDirCd(rvo1.getSkdDirCd());
						vo1.setLgsCostCd(vo.getAcctCd());
						vo1.setRevDirCd(rvo1.getRlaneDirCd());
						vo1.setRlaneCd(rvo1.getRlaneCd());
						vo1.setLgsCostCd(vo.getAcctCd());
						
												
						vo1.setIoBndCd("O");
						
						vo1.setDpIoBndCd("");
						vo1.setLoclAmt(vo.getAmount());
						String usdAmt = dbDao.getUsdAmt(vo.getAmount(), mastervo.getCurrCd(), mastervo.getIssDt(), "1");
						String usdAmts[] = usdAmt.split("\\|", 2);
						if(usdAmts.length>=2){
							if(usdAmts[0].equals("")){
								vo1.setUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
							}
							else{
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
						vo1.setArYrmon(rvo1.getRevYrmon());
						vo1.setCreUsrId(vo.getUsrId());
						vo1.setUpdUsrId(vo.getUsrId());
						vo1.setN3ptyBilIfFlg(vo.getN3ptyBilIfFlg());//tpb대상건 여부
						vo1.setMnlInpXchRt(vo.getMnlInpXchRt());	//Exchange Rate
						vo1.setCostCalcEffFmDt(vo.getCostCalcEffFmDt());
						vo1.setCostCalcEffToDt(vo.getCostCalcEffToDt());
						//xmlType으로 데이터 저장
						setInvCondDesc(vo, vo1);

						insertVoList.add(vo1);
					}

				}//end of if(rList != null) 
			}//end of else 
		}//end of if(vo.getIo().equals("INOUT")){//All의 경우 
		else{// IN or OUT BOUND 둘 중 하나인 경우 
			log.debug("vo.getIo7()"+vo.getIo());
			vo1.setIssCtyCd(mastervo.getIssCtyCd());
			vo1.setSoSeq(mastervo.getSoSeq());
			vo1.setSoDtlSeq(vo.getSoDtlSeq());
			vo1.setVslCd(vo.getVslCd());
			vo1.setSkdVoyNo(vo.getSkdVoyNo());
			vo1.setSkdDirCd(vo.getSkdDirCd());
			vo1.setLgsCostCd(vo.getAcctCd());
			vo1.setIoBndCd(vo.getIo().equals("IN") ? "I":"O");
			vo1.setDpIoBndCd(vo.getIo().equals("IN") ? "I":"O");
			vo1.setLoclAmt(vo.getAmount());
			String usdAmt = dbDao.getUsdAmt(vo.getAmount(),  mastervo.getCurrCd(), mastervo.getIssDt(), "1");
			String usdAmts[] = usdAmt.split("\\|", 2);
			if(usdAmts.length>=2){
				if(usdAmts[0].equals("")){
					vo1.setUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
				}
				else{
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
			
			//xmlType으로 데이터 저장
			setInvCondDesc(vo, vo1);
			log.debug("vo1.getDpIoBndCd()+++"+vo1.getDpIoBndCd());
			//IO Ratio를 구하지 못한 경우 RLANE_CD와 RLANE_DIR_CD를 구한다. 2009.11.26. 추가 Logic 
		    String strRevLaneDir = dbDao.getRevLaneDir(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), mastervo.getYdCd(),vo1.getDpIoBndCd());
			String aryRevLaneDir[] = strRevLaneDir.split("\\|", 3);
			vo1.setRlaneCd(aryRevLaneDir[0]);
			vo1.setCostCalcEffFmDt(vo.getCostCalcEffFmDt());
			vo1.setCostCalcEffToDt(vo.getCostCalcEffToDt());
			vo1.setRevDirCd(aryRevLaneDir[1]);
			vo1.setArYrmon(aryRevLaneDir[2]);
			vo1.setN3ptyBilIfFlg(vo.getN3ptyBilIfFlg());//tpb대상건 여부
			vo1.setMnlInpXchRt(vo.getMnlInpXchRt());	//Exchange Rate
			
			insertVoList.add(vo1);
		}
	}
	/**
	 * @param InvAuditDataValidVO vo
	 * @param PsoChgDtlVO vo1
	 */
	private void setInvCondDesc(InvAuditDataValidVO vo, PsoChgDtlVO vo1) {
		//xml타입으로 저장처리
		StringBuilder sb = new StringBuilder("<o>");
		sb.append("<o86>"+vo.getNight()+"</o86>");
		sb.append("<o75>"+vo.getHoliday()+"</o75>");
		sb.append("<o17>"+vo.getBoat()+"</o17>");
		sb.append("<o110>"+vo.getTugrope()+"</o110>");
		sb.append("<o57>"+vo.getBuoy()+"</o57>");
		sb.append("<o97>"+vo.getSanitation()+"</o97>");
		sb.append("<o52>"+vo.getBarge()+"</o52>");
		sb.append("<o78>"+vo.getInspection()+"</o78>");
		sb.append("<o8>"+vo.getArrtp()+"</o8>");
		sb.append("<o9>"+vo.getDeptp()+"</o9>");
		sb.append("<o6>"+vo.getArrnt()+"</o6>");
		sb.append("<o7>"+vo.getDepnt()+"</o7>");
		sb.append("<o10>"+vo.getArrtuh()+"</o10>");
		sb.append("<o11>"+vo.getDeptuh()+"</o11>");
		sb.append("<o50>"+vo.getArrlh()+"</o50>");
		sb.append("<o60>"+vo.getDeplh()+"</o60>");
		sb.append("<o111>"+vo.getUsdhrs()+"</o111>");
		sb.append("<o119>"+vo.getNewservice()+"</o119>");
		sb.append("<o125>"+vo.getCopilot()+"</o125>");
		sb.append("<o176>"+vo.getBafRt()+"</o176>");
		sb.append("</o>");
		vo1.setInvCondDesc(sb.toString());
	}

	/**
	 * VOP_PSO_0014 : Retrieve Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Retrieve Button Click 시 조회 처리를 한다.<br />
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws EventException 
	 */
	public List<InvAuditDataValidVO> searchGenInvAudit(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return  dbDao.searchGenInvAudit(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq 
	 * @param String ydCd 
	 * @param String invNo 
	 * @throws EventException 
	 */
	public void removeGenInvAudit(String vndrSeq, String ydCd, String invNo)
			throws EventException {
		try {
			
			int delCnt = 0;
			delCnt = dbDao.removeInvChargeDetail(vndrSeq, ydCd, invNo);
			delCnt = dbDao.removeInvCharge(vndrSeq, ydCd, invNo);
			delCnt+=0;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
		
	}
	/**
	 * VOP_PSO_0014 : Grid Account Cd Change <br />
	 * Invoice Creation & Audit 화면의 그리드에서 Account Code 변경 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_VvdLevelCheck
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdLevel(InvAuditDataValidVO invAuditDataValidVO)
			throws EventException {
		try {
			return  dbDao.checkVvdLevel(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	
//	/**
//	 * VOP_PSO_0014 : Confirm Button Click <br />
//	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 처리를 한다.<br />
//	 * @category VOP_PSO_0014_ConfirmButtonClick
//	 * @param InvAuditDataValidVO invAuditDataValidVO
//	 * @throws EventException
//	 */
//	public void createInvApprovalRqstAp(InvAuditDataValidVO invAuditDataValidVO)
//			throws EventException {
//		// TODO Auto-generated method stub
////		"≪≫ addApPaymentInvoice ( [in] AP PAYMENT INVOICE : AP PAYMENT INVOICE ) : void
////		≪≫ addApPaymentInvoiceDetail ( [in] AP PAYMENT INVOICE DETAIL : AP PAYMENT INVOICE DETAIL[] ) : void
////		≪≫ modifyPsoChargeStaus (  )"
//		try {
//			dbDao.addApPaymentInvoice(invAuditDataValidVO);
//			dbDao.addApPaymentInvoiceDetail(invAuditDataValidVO);
//			invAuditDataValidVO.setPsoChgStsCd("A");//Approved 로 변경 
//			dbDao.modifyPsoChargeStaus(invAuditDataValidVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
//		}
//
//	}
	
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV 에 저장 할 정보를 조회한다. <br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInv(InvAuditDataValidVO invAuditDataValidVO)
			throws EventException {
		try {
			return dbDao.searchApPayInv(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할 정보를 조회한다.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[]
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchApPayInvDtl(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할 정보를 조회한다.TONNAGE 배분 로직 포함<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[]
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtlDiv(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchApPayInvDtlDiv(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할 정보를 조회한다. tonnage배분 로직이 들어가는 지 여부 판단<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws EventException
	 */
	public String searchTonnageDiv(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException {
		try {
			return dbDao.searchTonnageDiv(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 INV_RGST_NO 및 STATUS CD 를 갱신한다.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @throws EventException
	 */
	public void updatePsoCharge(InvAuditDataValidVO invAuditDataValidVO)
			throws EventException {
		try {
			dbDao.modifyPsoChargeStaus(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}

    /**
     *  VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 CSR No. 의 존재 여부 확인 <br />
	 * @category VOP_PSO_0014_DeleteButtonClickCSRNoCheck
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return boolean
	 * @throws EventException
     */
	public boolean checkApPayInv(String vndrSeq, String ydCd, String invNo)
			throws EventException {
		try {
			return dbDao.checkApPayInv(vndrSeq, ydCd, invNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	
	/**
	 *  Local Amount의 값을 USD도 바꾼다. 
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
			if(type.equals("B"))//추정의 경우 
				return dbDao.getUsdAmtBudget(strLocalAmt, currCd, revYrmon);
			else
				return dbDao.getUsdAmt(strLocalAmt, currCd, revYrmon,type);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	/**
	 * 해당 VVD의 포트가 Turning Port인지 확인
	 * @param String hvvd
	 * @param String tmnlCode
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode)
			throws EventException {
		try {
			return dbDao.checkTurningPort(hvvd, tmnlCode);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}

	/**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
	 * VOP_PSO-0014 입력된 INV No.가 존재하는지 확인한다.
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param String vndrSeq
	 * @param String invNo
	 * @return String
	 * @throws EventException
	 */
	public String checkInvNo(String vndrSeq, String invNo) throws EventException {
		try {
			String oldInvNo = "";
			// Search if there exists already the same invoice NO. in PSO CHARGE or not. 
			List<PsoChargeVO> lst = dbDao.isExistPsoCharge("0", vndrSeq, invNo);
			if(lst!=null){
				if(lst.size()>0){
					PsoChargeVO vo = lst.get(0);
					oldInvNo = vo.getInvNo();
				}
			}
			
			// Search if there exists already the same invoice NO. in Common CSR or not.
			lst = dbDao.isExistInvNoInCSR(vndrSeq, invNo);
			if(lst!=null){
				if(lst.size()>0){
					PsoChargeVO vo = lst.get(0);
					oldInvNo = vo.getInvNo();
				}
			}
			
			return oldInvNo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	
	/**
	 * 최근 버전의 Tariff를 조회한다.
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<TariffInfoVO>
	 * @throws   EventException
	 */		
	public List<TariffInfoVO> getTariff(SimulationConditionVO simulationConditionVO)  throws EventException{
		try {
			return dbDao.getTariff(simulationConditionVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Tariff"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Tariff"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff에 사용된 Formula/Condition를 구성하는 Objects를 조회한다.
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<SimulationObjectListVO>
	 * @throws   EventException
	 */		
	public List<SimulationObjectListVO> searchObjectBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException{
		try {
			return dbDao.searchObjectBySimulation(simulationConditionVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Tariff"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Tariff"}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Detail 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @param    SimulationConditionVO[] simulationConditionVOs
	 * @return   List<SimulationInvoiceListVO>
	 * @throws   EventException
	 */		
	public List<SimulationInvoiceListVO> searchInvoiceBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs)  throws EventException{
		try {
			List<SimulationInvoiceListVO> list1 = new ArrayList<SimulationInvoiceListVO>();
			for(int k=0;k<simulationConditionVOs.length;k++){
				List<SimulationInvoiceListVO> list2 = dbDao.searchInvoiceBySimulation(simulationConditionVO, simulationConditionVOs[k]);
				list1.addAll(list2);
			}
			return list1;
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Invoice Detail"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Invoice Detail"}).getMessage(), ex);
		}
	}

	/**
	 * Auto Object 의 DefaultValue 값을 구한다.
	 * @category VOP_PSO_0038_setAutoObjectDfltVal
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO simulationConditionVO2
	 * @param List<SimulationObjectListVO> objectsList
	 * @throws EventException
	 */
	public void setAutoObjectDfltVal(SimulationConditionVO simulationConditionVO, SimulationConditionVO simulationConditionVO2, List<SimulationObjectListVO> objectsList)
			throws EventException {
		String vvd = simulationConditionVO.getVslCd() + simulationConditionVO.getSkdVoyNo() + simulationConditionVO.getSkdDirCd();
		
		if((vvd.equals("")||vvd.length()<9)&&(simulationConditionVO.getVslCd()==null||simulationConditionVO.getVslCd().equals("")))//조건 충족 안할 경우. 리턴
			return;
		CalcTariffVO calcTariffVO = new CalcTariffVO();
		String ydCd = simulationConditionVO.getPortCd()+simulationConditionVO.getYardCd();
//		String lgsCostCd = simulationConditionVO.getCostCd();
		String lgsCostCd = simulationConditionVO2.getCostCd();
		String ydChgNo = simulationConditionVO2.getYdChgNo();
		String ydChgVerSeq = simulationConditionVO2.getYdChgVerSeq();;
		
		
		String clptIndSeq = "";
		//CLPT_IND_SEQ
		//의 값을  Select 해 온다. 
		try {
			clptIndSeq =  dbDao.selectClptIndSeq(vvd, ydCd, false);// expr
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"setAutoObjectDfltVal : selectClptIndSeq"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"setAutoObjectDfltVal : selectClptIndSeq"}).getMessage(),ex);
		}
		
		String repVslCd = "";//TBN항차에 대응하는 대응항차 
		String cntrVslClssCapa = "";//calcTariffVO.getCntrVslClssCapa();
		try {
			repVslCd =  dbDao.getRepVslCd(vvd, cntrVslClssCapa);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"setAutoObjectDfltVal : getRepVslCd"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"setAutoObjectDfltVal : getRepVslCd"}).getMessage(),ex);
		}
		
		//구한 repVslCd로 전환한다. 
		String repVvd = "";
		if(repVslCd!=null){
			if(!repVslCd.equals("")){
				repVvd = repVslCd + vvd.substring(4);
			}
			else{
				repVvd = vvd;
			}
		}
		else{
			repVvd = vvd;
		}
		
		int szList = 0;
		if(objectsList != null){
			szList = objectsList.size();
		}
		if(szList > 0){
			String strObjVal = "";
			int[] objNos = new int[szList];
			for(int i=0; i<szList;i++){
				SimulationObjectListVO vo = objectsList.get(i);
				objNos[i] = Integer.parseInt(vo.getObjListNo());
				//[2010.02.23:jmh] dflt_val는 모두 NULL임. Actual값을 가져온후, 없으면 Regular Value로 setDfltVal()
				//[2010.02.25:jmh] dflt_val중 Constant 등의 값은 NULL이 아님. Actual값을 가져온후, 없으면 Regular Value로 setDfltVal()
				strObjVal = "";
				if(vo.getDfltVal().equals("") || vo.getDfltVal() == null){
					strObjVal = getObjectValue(calcTariffVO, objNos, strObjVal, vvd,
							ydCd, lgsCostCd, ydChgNo, ydChgVerSeq,
							clptIndSeq, i, Integer.parseInt(vo.getObjListNo()), repVvd);
					//CHM-201429129 [PSO] Tariff simulation 로직 수정 -Inboud regular value
					//TOR Report 가 있고, 값만 없는경우 Reqular value 사용 하지 않도록 로직 추가 -- start
					String torHeaderExistFlg = "N";
					if("32".equalsIgnoreCase(vo.getObjListNo()) &&"0".equalsIgnoreCase(strObjVal)){
						   String torHeaderCnt = "0";
						   torHeaderCnt = getInboundVolumeTorHeaderCnt(vvd, ydCd, calcTariffVO.isBudget());
						   if(!"0".equalsIgnoreCase(torHeaderCnt)){
							   torHeaderExistFlg = "Y";
						   }
					   }
					if("Y".equalsIgnoreCase(torHeaderExistFlg)){
						log.debug("torHeaderFlg = Y, strObjVal : "+strObjVal);
						vo.setDfltVal(strObjVal);
					} 
					//TOR Report 가 있고, 값만 없는경우 Reqular value 사용 하지 않도록 로직 추가 -- end
					else if(strObjVal == null || strObjVal.equals("") || strObjVal.equals("0")){
						vo.setDfltVal(vo.getRegVal());
					} else{
						vo.setDfltVal(strObjVal);
					}
				}
			}
		}
	}
	
	/**
	 * Tariff에 해당하는 Service Providers 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<SimulationConditionVO>
	 * @throws   EventException
	 */		
	public List<SimulationConditionVO> searchProviderBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException{
		try {
			return dbDao.searchProviderBySimulation(simulationConditionVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff에서 사용하는 Account 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<CostListVO>
	 * @throws   EventException
	 */		
	public List<CostListVO> searchAccountBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException{
		try {
			return dbDao.searchAccountBySimulation(simulationConditionVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		}
	}
	
	/**
	 * 환율변환된 금액을 조회한다.
	 * @category VOP_PSO_0014_Calculation
	 * @param    String div
	 * @param    String amt
	 * @param    String dt
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmount(String div, String amt, String dt, String currCd)  throws EventException{
		try {
			return dbDao.searchConvertedAmount(div, amt, dt, currCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		}
	}
	
	/**
	 * 환율변환된 금액을 조회한다. 2015-05-08 ex) tariff : XOF  invoice : EUR 인 경우   XOF --> USD ---> EUR로  환율 계산을 해 주도록 함.
	 * @category VOP_PSO_0014_Calculation
	 * @param    String amt
	 * @param    String dt
	 * @param    String bcurrCd
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmountOther( String amt, String dt, String bcurrCd, String currCd )  throws EventException{
		try {
			return dbDao.searchConvertedAmountOther( amt, dt, bcurrCd, currCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		}
	}
		
	/**
	 * case 132://Loaded TEU WBLP (West bound last port)
	 * @category Obj132_Loaded TEU WBLP
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getstrLoadedTeuLastPort(String vvd, String ydCd, boolean isBudget ) throws EventException {
		try {
			String skdDirCd = "W";
			return  dbDao.getLoadedTeuLastPort(vvd, ydCd, isBudget,skdDirCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj132_Loaded TEU WBLP"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj132_Loaded TEU WBLP"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 146://Loaded TEU EBLP (East bound last port)
	 * @category Obj146_Loaded TEU EBLP
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getstrLoadedTeuLastPort1(String vvd, String ydCd, boolean isBudget ) throws EventException {
		try {
			String skdDirCd = "E"; 
			return  dbDao.getLoadedTeuLastPort(vvd, ydCd, isBudget, skdDirCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj146_Loaded TEU EBLP"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj146_Loaded TEU EBLP"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 171://Loaded WGT at L/P
	 * @category Obj171_LoadedWgtLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String searchLoadedWgtLastPort(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.searchLoadedWgtLastPort(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj171_LoadedWgtLastPort"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj171_LoadedWgtLastPort"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 172://Effective Date
	 * @category Obj172_WithinEffectiveDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String isBudget
	 * @return String
	 * @throws EventException
	 */
	private String searchWithinEffectiveDate(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.searchWithinEffectiveDate(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj172_WithinEffectiveDate"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj172_WithinEffectiveDate"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 173://Loaded DG Cargo at Arrival
	 * @category Obj173_LoadedDGcargoArr
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String searchLoadedDGcargoArr(String vvd, String ydCd) throws EventException {
		try {
			return  dbDao.searchLoadedDGcargoArr(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj173_LoadedDGcargoArr"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj173_LoadedDGcargoArr"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 174://Loaded DG Cargo at Departure
	 * @category Obj174_LoadedDGcargoDep
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String searchLoadedDGcargoDep(String vvd, String ydCd) throws EventException {
		try {
			return  dbDao.searchLoadedDGcargoDep(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj174_LoadedDGcargoDep"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj174_LoadedDGcargoDep"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 175://Conventional Flags For GR
	 * @category Obj175_ConventionalFlag
	 * @param String vvd
	 * @param String isBudget
	 * @return String
	 * @throws EventException
	 */
	private String searchConventionalFlag(String vvd, boolean isBudget) throws EventException {
		try {
			return  dbDao.searchConventionalFlag(vvd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj174_LoadedDGcargoDep"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj174_LoadedDGcargoDep"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 177://Loaded MT Q'TY
	 * @category Obj177_LoadedMtQty
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String searchLoadedMtQty(String vvd, String ydCd) throws EventException {
		try {
			return  dbDao.searchLoadedMtQty(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj177_LoadedMtyQty"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj177_LoadedMtyQty"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 178://ETA에서 부터 ETD까지 걸리는 기간
	 * @category Obj178_ArrivalDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @param String isBudget
	 * @return String
	 * @throws EventException
	 */
	private String searchArrivalDay(String vvd, String ydCd, String clptIndSeq, boolean isBudget) throws EventException {
		try {
			return  dbDao.searchArrivalDay(vvd, ydCd, clptIndSeq, isBudget );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj178_ArrivalDay"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj178_ArrivalDay"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 179://Main Engine Capacity 
	 * @category Obj179_MainEngCapa
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String searchMainEngCapa(String vvd) throws EventException {
		try {
			return  dbDao.searchMainEngCapa(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj179_MainEngCapa"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj179_MainEngCapa"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 147:신규 Object DEM/DET Holiday ETB (except Day) 추가
	 * @category Obj147_DemdetHolidayETB
	 * @param String vvd
	 * @param String ydCd
	 * @return String 
	 * @throws EventException
	 */
	private String searchDemdetHolidayETBExceptDay(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.searchDemdetHolidayETBExceptDay(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj147_DemdetHolidayETB"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj147_DemdetHolidayETB"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 148:신규 Object DEM/DET Holiday ETD (except Day) 추가
	 * @category Obj148_DemdetHolidayETD
	 * @param String vvd
	 * @param String ydCd
	 * @return String 
	 * @throws EventException
	 */
	private String searchDemdetHolidayETDExceptDay(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.searchDemdetHolidayETDExceptDay(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj148_DemdetHolidayETD"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj148_DemdetHolidayETD"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 148:신규 Object DEM/DET Holiday ETA (except Day) 추가
	 * @category Obj148_DemdetHolidayETA
	 * @param String vvd
	 * @param String ydCd
	 * @return String 
	 * @throws EventException
	 */
	private String searchDemdetHolidayETAExceptDay(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.searchDemdetHolidayETAExceptDay(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj148_DemdetHolidayETD"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj148_DemdetHolidayETD"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 115://Tier
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getTier(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getTier(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		}
	}
	
	
	/**
	 * case 116://Limit Time
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getLimitTime(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getLimitTime(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		}
	}

	/**
	 * case 134://Vessel Volume
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getVesselVolumeCi(String vvd, String ydCd) throws EventException {
		try {
			return  dbDao.getVesselVolumeCi(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		}
	}	
	
	/**
	 * case 135://LOA * Beam
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	private String getLoaBeam(String vvd) throws EventException {
		try {
			return  dbDao.getLoaBeam(vvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler().getMessage(),ex);
		}
	}	
	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 *   case 136://ETB DAY
	 * @category Obj65_ETBDay
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getEtbDay(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getEtbDay(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj136_ETBDay"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj136_ETBDay"}).getMessage(),ex);
		}
	}
	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 *   case 137://ETD DAY
	 * @category Obj137_ETDDay
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	private String getEtdDay(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getEtdDay(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj137_ETDDay"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj137_ETDDay"}).getMessage(),ex);
		}
	}
	
	/**
	 * yard 정보를 조회한다.
	 * @category VOP_PSO_0038
	 * @param String portCd
	 * @param String issueDate
	 * @return List<SearchYardsVO>
	 * @exception EventException
	 */
	public List<SearchYardsVO> searchYardList (String portCd, String issueDate) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchYardList(portCd, issueDate);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		}
	}
	
	/**
	 * case 154: Duration
	 * vvd의 P/F Duration을 구한다.
	 * 
	 * @param String vvd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	public String getDuration(String vvd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getDuration(vvd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj154_Duration"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj154_Duration"}).getMessage(),ex);
		}
	}

	/**
	 * Tariff에서 사용하는 Cost 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<CostListVO>
	 * @throws   EventException
	 */		
	public List<CostListVO> searchCostBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException{
		try {
//			String acctCd = simulationConditionVO.getAcctCd();
//			if(acctCd != null && !acctCd.equals("")){
////				acctCd = "'" + acctCd.replaceAll(",", "','") + "'";
//				acctCd = acctCd.replaceAll(",", "','");
//				simulationConditionVO.setAcctCd(acctCd);
//			}
			return dbDao.searchCostBySimulation(simulationConditionVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		}
	}
	
	/**
	 * object list 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @param    SimulationConditionVO[] simulationConditionVOs
	 * @return   List<SimulationObjectListVO>
	 * @throws   EventException
	 */		
	public List<SimulationObjectListVO> searchObjectListBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs)  throws EventException{
		String pattern = "([0-9]+)";
		Pattern p = Pattern.compile(pattern);
		String uom = "";
		String dfltVal = "";
		List<SimulationObjectListVO> tmpObjectsList = null ;
		List<SimulationObjectListVO> objectsList = new ArrayList<SimulationObjectListVO>() ;
		try {
			for(int k=0;k<simulationConditionVOs.length;k++){
				tmpObjectsList = searchObjectBySimulation(simulationConditionVOs[k]);
				setAutoObjectDfltVal(simulationConditionVO, simulationConditionVOs[k], tmpObjectsList);
				for(int i=0; i<tmpObjectsList.size(); i++){
					uom = tmpObjectsList.get(i).getPsoMeasUtCd();
					dfltVal = tmpObjectsList.get(i).getDfltVal();

					//DAY(16)인 경우, TO_DATE('20100129', 'YYYYMMDD') 형식의 문자열이므로 날짜만 취한다.
					if("16".equals(uom)){	//DAY
						Matcher m = p.matcher(dfltVal);
						dfltVal = "";
						while(m.find()) {
							dfltVal = m.group(1);
						}
					}
					tmpObjectsList.get(i).setDfltVal(dfltVal.replaceAll("'", ""));
				}
				objectsList.addAll(tmpObjectsList);
			}
			return objectsList;
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		}
	}
	
	/**
	 * Calculation
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO sVO
	 * @param    SimulationConditionVO[] sVOs
	 * @param    SimulationObjectListVO[] autovos
	 * @param    SimulationObjectListVO[] vos
	 * @return   List<CalcTariffResultVO>
	 * @throws   EventException
	 */		
	public List<CalcTariffResultVO> calculateTariff(SimulationConditionVO sVO, SimulationConditionVO[] sVOs, SimulationObjectListVO[] autovos, SimulationObjectListVO[] vos)  throws EventException{
//		int objNo = 0;
		List<CalcTariffResultVO> calcVOs = new ArrayList<CalcTariffResultVO>();
		try{
//			StringBuilder data = new StringBuilder();
				//Calc를 위한 파라미터 Input...
				CalcTariffVO calcTariffVO = new CalcTariffVO();
				
				for(int k=0;k<sVOs.length;k++){
					
					calcTariffVO.setVslCd(sVO.getVslCd());
					calcTariffVO.setSkdVoyNo(sVO.getSkdVoyNo());
					calcTariffVO.setSkdDirCd(sVO.getSkdDirCd());
					calcTariffVO.setVvd(sVO.getVslCd()+sVO.getSkdVoyNo()+sVO.getSkdDirCd());
					calcTariffVO.setYdChgNo(sVOs[k].getYdChgNo());
					calcTariffVO.setChgVerSeq(sVOs[k].getYdChgVerSeq());
					calcTariffVO.setYdCd(sVO.getYardCd());
					calcTariffVO.setLgsCostCd(sVOs[k].getCostCd());
					
					calcTariffVO.setCurrCd(sVOs[k].getCurrCd());
					calcTariffVO.setIoFlag("OUT");
					if(sVO.isBudget()){
						calcTariffVO.setBudget(true);
					}
					
					//Manually Input 값처리 
					if(autovos!=null){//MenualType 설정 
						for(int i=0; i<autovos.length; i++){
							calcTariffVO.hMap.put("["+autovos[i].getObjListNo()+"]", autovos[i].getDfltVal());
						}
					}
					if(vos!=null){//MenualType 설정 
						for(int i=0; i<vos.length; i++){
							if(vos[i].getObjListNo().equals("77")&&vos[i].getDfltVal().indexOf("Y")!=-1){//IN
								calcTariffVO.setIoFlag("IN");
							}
							if(vos[i].getObjListNo().equals("89")&&vos[i].getDfltVal().indexOf("Y")!=-1){//OUT
								calcTariffVO.setIoFlag("OUT");
							}
							calcTariffVO.hMap.put("["+vos[i].getObjListNo()+"]", vos[i].getDfltVal());
						}
					}
					
					calcTariffVO.setFrom("SIMULATION");//
					
					CalcTariffResultVO calcVo = calGeneralInvAudit(calcTariffVO);
					calcVo.setAcctCd(sVOs[k].getAcctCd());
					calcVo.setAcctEngNm(sVOs[k].getAcctEngNm());
					calcVo.setVndrSeq(sVOs[k].getVndrSeq());
					calcVo.setVndrLglEngNm(sVOs[k].getVndrLglEngNm());
					calcVo.setCurrCd(sVOs[k].getCurrCd());
					calcVo.setLgsCostCd(sVOs[k].getCostCd());
					
					String date = sVO.getIssueDate().replaceAll("-", "");
					String[] usdAmt =  searchConvertedAmount("Local2USD", calcVo.getTariffAmount(), date, calcVo.getCurrCd());
					calcVo.setTariffUsdAmount(usdAmt[0]);
					
					calcVOs.add(calcVo);
				}
			return calcVOs;
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Simulation By VVD 정보를 조회한다.
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return TariffGRPVO
	 * @exception EventException
	 */
	public TariffGRPVO searchSimulationByVvd (TariffSimByVvdVO tariffSimByVvdVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			//VVD에 해당하는 yard 조회
			List<TariffSimByVvdVO> ydList = dbDao.searchYardsByVvd(tariffSimByVvdVO);
			
			List<SimulationConditionVO> trf = new ArrayList<SimulationConditionVO>();
			List<CalcTariffResultVO> calcRslt = null;
			List<CalcTariffResultVO> detailVOs = new ArrayList<CalcTariffResultVO>();
			
			if(ydList != null){
				TariffSimByVvdVO targetYd = null;
				for(int i=0; i<ydList.size(); i++){
					
					targetYd = ydList.get(i);
					
					targetYd.setVvd(tariffSimByVvdVO.getVvd());
					targetYd.setSrcPsoBztpCd(tariffSimByVvdVO.getSrcPsoBztpCd());
					
					//해당 yard의 tariff 조회
					trf = dbDao.searchTariffByYards(targetYd);

					SimulationConditionVO[] sVOs = new SimulationConditionVO[trf.size()];
					SimulationConditionVO temp = null;
					if(trf != null){
						for(int j=0; j<trf.size(); j++){
							temp = new SimulationConditionVO();
							temp.setYdChgNo(trf.get(j).getYdChgNo());
							temp.setYdChgVerSeq(trf.get(j).getYdChgVerSeq());
							temp.setAcctCd(trf.get(j).getAcctCd());
							temp.setAcctEngNm(trf.get(j).getAcctEngNm());
							temp.setVndrSeq(trf.get(j).getVndrSeq());
							temp.setVndrLglEngNm(trf.get(j).getVndrLglEngNm());
							temp.setCurrCd(trf.get(j).getCurrCd());
							temp.setCostCd(trf.get(j).getCostCd());
							sVOs[j] = temp;
						}
					}
					
					SimulationConditionVO sVO = new SimulationConditionVO();
					sVO.setVslCd(tariffSimByVvdVO.getVvd().substring(0,4));
					sVO.setSkdVoyNo(tariffSimByVvdVO.getVvd().substring(4,8));
					sVO.setSkdDirCd(tariffSimByVvdVO.getVvd().substring(8,9));
					sVO.setPortCd(targetYd.getVpsPortCd());
					sVO.setYardCd(targetYd.getYdCd().substring(5,7));
					if("1".equals(targetYd.getSrcPsoBztpCd())){
						sVO.setBudget(true);	
					}
					
					// yard, trf 정보로 object 조회
					List<SimulationObjectListVO> objectsList = searchObjectListBySimulation(sVO, sVOs);
					
					String tempObj = null;
					
					// tariff simulation의 화면과 같이 12(FLAG), 14(CODE), 17(DAY), 16(DATE)의 DfltVal 변환
					for(int a=0; a<objectsList.size(); a++){
						
						// acct_cd가 all일 때는 IN & OUT 의 value는 "Y"
						if("77".equals(objectsList.get(a).getObjListNo()) || "89".equals(objectsList.get(a).getObjListNo())){
							objectsList.get(a).setDfltVal("Y");
						}
						
						tempObj = objectsList.get(a).getPsoMeasUtCd();
											
						if("12".equals(tempObj) || "14".equals(tempObj) || "17".equals(tempObj)){
							tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
							objectsList.get(a).setDfltVal("'" + tempObj + "'");
						}else if("16".equals(tempObj)){
							tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
							objectsList.get(a).setDfltVal("TO_DATE(" + "'" + tempObj + "'" + ", 'YYYYMMDD')");
						}
						
					}
					
					HashMap<String, SimulationObjectListVO> autoObjMap = new HashMap<String, SimulationObjectListVO>();
					HashMap<String, SimulationObjectListVO> manuObjMap = new HashMap<String, SimulationObjectListVO>();
					List<SimulationObjectListVO> autoObjectList = new ArrayList<SimulationObjectListVO>();
					List<SimulationObjectListVO> manualObjectList = new ArrayList<SimulationObjectListVO>();
					
					for(int m=0; m<objectsList.size(); m++){
						if("A".equals(objectsList.get(m).getPsoObjListTpCd())){
							autoObjMap.put(objectsList.get(m).getObjListNo(), objectsList.get(m)); 
						} else if("M".equals(objectsList.get(m).getPsoObjListTpCd())){
							manuObjMap.put(objectsList.get(m).getObjListNo(), objectsList.get(m));
						}
					}
					
					for(SimulationObjectListVO simulationObjectListVO : autoObjMap.values()){
						autoObjectList.add(simulationObjectListVO);
					}
					
					for(SimulationObjectListVO simulationObjectListVO : manuObjMap.values()){
						manualObjectList.add(simulationObjectListVO);
					}
					
					//Port와 Yard로 나눴던 부분 다시 합침
					sVO.setYardCd(targetYd.getYdCd());
					
					sVO.setIssueDate(targetYd.getVpsEtbDt());
					
					//Calculation
					calcRslt = calculateTariff(sVO, sVOs, autoObjectList.toArray(new SimulationObjectListVO[autoObjectList.size()]),
							                              manualObjectList.toArray(new SimulationObjectListVO[manualObjectList.size()]));

					double ydTtlUsdAmt = 0;
					
					String portType = dbDao.searchPortType(targetYd);
					if("TURNING".equals(portType)){
						targetYd.setPortType("T");
					}else if("VIRTUAL".equals(portType)){
						targetYd.setPortType("V");
					}else{
						targetYd.setPortType("");
					}
					
					int cnt=0;
					for(int amtInd=0; amtInd<calcRslt.size(); amtInd++){
						if(calcRslt.get(amtInd).getTariffUsdAmount()!=null && !"".equals(calcRslt.get(amtInd).getTariffUsdAmount())){
							ydTtlUsdAmt = ydTtlUsdAmt + Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount());
							
							if(!"V".equals(targetYd.getPortType())){ //Detail 정보 (Excel Download용) 
								CalcTariffResultVO tempVO = new CalcTariffResultVO();
								cnt++;
								tempVO.setYdCd(targetYd.getYdCd());
								tempVO.setAcctCd(calcRslt.get(amtInd).getAcctCd());
								tempVO.setAcctEngNm(calcRslt.get(amtInd).getAcctEngNm());
								if("Y".equals(tariffSimByVvdVO.getExpRto())){
									tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount())*100)/200.0);
								}else{
									tempVO.setTariffUsdAmount("" + Math.round(Double.parseDouble(calcRslt.get(amtInd).getTariffUsdAmount())*100)/100.0);
								}
								detailVOs.add(tempVO);
							}
						}
					}
					
					// Expense Ratio 적용시 Port Type별로 구분
					if("Y".equals(tariffSimByVvdVO.getExpRto())){
						// Turning이거나 Virtual Port인 경우 해당 금액에 50%만 적용
						// Turning Port : O/B 50%
						// Virtual Port : I/B 50%
						// General Port : O/B 100%
						
						if("TURNING".equals(portType)){
							targetYd.setIbRatio("0");
							targetYd.setObRatio("50");
							targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt*100)/200.0);
						}else if("VIRTUAL".equals(portType)){
							targetYd.setIbRatio("50");
							targetYd.setObRatio("0");
							targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt*100)/200.0);
						}else{
							targetYd.setIbRatio("0");
							targetYd.setObRatio("100");
							targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt*100)/100.0);
						}
					}else{
						targetYd.setIbRatio("0");
						targetYd.setObRatio("100");
						targetYd.setYdTtlUsdAmt("" + Math.round(ydTtlUsdAmt*100)/100.0);
					}
				}
			}
			
			TariffGRPVO tariffGRPVO = new TariffGRPVO();
			tariffGRPVO.setTariffSimByVvdVOs(ydList);
			
			TariffGRPVO titleInfo = arrangeYardAcct(detailVOs);//detail 정보에서 yard(skd 순서) / acct(숫자순서) 정보를 각각 정렬하여 리턴
			tariffGRPVO.setYards(titleInfo.getYards());
			tariffGRPVO.setAccts(titleInfo.getAccts());
			tariffGRPVO.setCalcTariffResultVOs(detailVOs);
			
			return tariffGRPVO;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation By VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Simulation By VVD"}).getMessage(), ex);
		}
	}
	
	/**
	 * 대상 VVD가 사업계획용인지 Live용인지 조회한다.
	 * 사업계획 == 1 / Live == 2
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVvdBztpCd(String vvd) throws EventException {
		try {
			return dbDao.searchVvdBztpCd(vvd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"VVD"}).getMessage(), ex);
		}		
	}
	
	/**
	 * case 155: Previous Port(TW)
	 * 어떤 Vessel이 특정 포트 접안일 기준, 과거 120일 이내에 Taiwan을 접안 하였는지 조회
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws EventException
	 */
	public String getPreviousTaiwanPort(String vvd, String ydCd) throws EventException {
		try {
			return  dbDao.getPreviousTaiwanPort(vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj155_Previous Port(TW)"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj155_Previous Port(TW)"}).getMessage(),ex);
		}
	}
	
	/**
	 * case 156: Yearly Vessel Call Port
	 * 당해년도 특정 port의 모든 선박(feeder 제외)의 calling count
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getYearlyVesselCallPort(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return dbDao.getYearlyVesselCallPort(vvd, ydCd, isBudget);
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
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtaDate(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return dbDao.getEtaDate(vvd, ydCd, isBudget);
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
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getBerthingHourDA(String vvd, String ydCd, String clptIndSeq, boolean isBudget) throws EventException{
		try {
			return  dbDao.getBerthingHourDA(vvd, ydCd, clptIndSeq, isBudget);
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
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtaDay(String vvd, String ydCd, boolean isBudget) throws EventException {
		try {
			return  dbDao.getEtaDay(vvd, ydCd, isBudget);
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
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getEtaMonth(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getEtaMonth(vvd, ydCd, isBudget);
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
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getInboundDivideVessel(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getInboundDivideVessel(vvd, ydCd, isBudget);
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
	 * @param boolean isBudget
	 * @return String
	 * @throws EventException
	 */
	private String getOutboundDivideVessel(String vvd, String ydCd, boolean isBudget) throws EventException{
		try {
			return  dbDao.getOutboundDivideVessel(vvd, ydCd, isBudget);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj162_OutboundTon/VesselVolume(FR)"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff Calculation : Obj162_OutboundTon/VesselVolume(FR)"}).getMessage(),ex);
		}
	}
	
	/**
	 * 해당 유저가 생성한 invoice 중, 미 confirm된 invoice list를 조회한다.
	 * 
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchNoConfirmInvoice(SignOnUserAccount account) throws EventException {
		try {
			return  dbDao.searchNoConfirmInvoice(account.getUsr_id());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Search No Confirm Invoice"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Search No Confirm Invoice"}).getMessage(),ex);
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
			
			for(CalcTariffResultVO vo : calcTariffResultVOs){
				String ydCd = vo.getYdCd();
				String acctCd = vo.getAcctCd();
				String acctEngNm = vo.getAcctEngNm();
				if(!yardMap.containsKey(ydCd)){
					yardMap.put(ydCd, ydCd);
				}
				if(!acctMap.containsKey(acctCd)){
					acctMap.put(acctCd, acctEngNm);
				}
			}

			tariffGrpVO.setYards(yardMap);
			tariffGrpVO.setAccts(acctMap);
			
			return tariffGrpVO;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Arranging Yard and Account"}).getMessage(),ex);
		}
	}
		
	/**
	 * 유저가 입력한 VVD의 Yard가 스킵인지 확인
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
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD가 기존 입력된 Invoice가 있는지 체크
	 * @param String vndrSeq  
	 * @param String costOfcCd 
	 * @param String ydCd 
	 * @param String costCd
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<String> 
	 * @exception EventException
	 */
	public List<String> checkDoublePayInv(String vndrSeq,String costOfcCd,String ydCd, String costCd, String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		try {
			return dbDao.checkDoublePayInv( vndrSeq, costOfcCd, ydCd, costCd, vslCd, skdVoyNo, skdDirCd );
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
	
	/**
	 * tonnage 입력시 cost_calc_eff_fm_dt와 cost_calc_eff_to_dt를 입력했는지 여부 확인
	 * @param String invNo  
	 * @param String vndrSeq 
	 * @return String 
	 * @exception EventException
	 */
	public String searchTonnageDivFlag(String invNo, String vndrSeq) throws EventException {
		try {
			return dbDao.searchTonnageDivFlag( invNo, vndrSeq );
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
	
	/**
	 * PSO-TPB Interface할 때의 billing type을 조회합니다.
	 * 
	 * @return List<TpbIfVO>
	 * @throws EventException
	 */
	public List<TpbIfVO> searchTpbBillType() throws EventException {
		try {
			return dbDao.searchTpbBillType();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"TPB Billing Type"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"TPB Billing Type"}).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * TPB IF 대상건 삭제
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String issCtyCd 
	 * @param String  soSeq 
	 * @throws EventException 
	 */
	public void removeTpbInv(String issCtyCd, String soSeq)	throws EventException {
		try {
			
			dbDao.removeTpbInv(issCtyCd, soSeq);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"TPB Interface Data"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"TPB Interface Data"}).getMessage(),ex);
		}
		
	}	
	
	/**
	 * ERP에서 인보이스 승인시 호출되며, TPB 대상건의 IF_FLG를 Y로 변경하고 TPB procedure를 호출한다.
	 * @param String csrNo
	 * @throws EventException 
	 */
	public void manageApprovalCsr(String csrNo)	throws EventException {
		try {
			log.debug("============== csrNo : "+csrNo);

			dbDao.modifyTpbIfFlg(csrNo);
			log.debug("============== modifyTpbIfFlg end ==============");
			List<TpbIfVO> tpbIfVOs = new ArrayList<TpbIfVO>();
			tpbIfVOs = dbDao.searchTpbIfData(csrNo);
			log.debug("============== searchTpbIfData end ==============");
			for(TpbIfVO vo : tpbIfVOs){
				dbDao.addTpbCreIfDataPsoProc(vo);
			}
			log.debug("============== addTpbCreIfDataPsoProc end ==============");
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12211", new String[]{"Call TPB Interface Procedure"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12211", new String[]{"Call TPB Interface Procedure"}).getMessage(),ex);
		}
	}	
	
	/**
	 * [VOP_PSO_0014] VVD 입력 시 해당 ATD 를 조회한다.
	 * 
	 * @param invAuditDataValidVO
	 * @return
	 * @throws EventException
	 */
	public String searchAtdData(InvAuditDataValidVO invAuditDataValidVO)
			throws EventException {
		try {
			return  dbDao.searchAtdData(invAuditDataValidVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invoice Creation & Audit"}).getMessage(),ex);
		}
	}
	
	 /**
		 * Invoice Detail 조회하기  2014.12.16
		 * @category VOP_PSO_0014
		 * @param    String vndrSeq
		 * @param    String invNo
		 * @return   String
		 * @throws   EventException
		 */		
		public String checkDoubleInvNo(String vndrSeq, String invNo)  throws EventException{
			try {
				return dbDao.isExistInvoice("0",vndrSeq, invNo);
			} catch(DAOException ex) {
				log.error(">>DAOException BC :" + ex.toString(), ex);
				throw new EventException(new ErrorHandler("PSO90005",new String[]{"Invoice Detail"}).getMessage(), ex);
			} catch (Exception ex) {
				log.error(">>Exception BC : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("PSO90005",new String[]{"Invoice Detail"}).getMessage(), ex);
			}
		}	 
	 
		
	
	/**
	 * 환율변환된 금액을 조회한다.
	 * @category VOP_PSO_0014_Calculation
	 * @param    String div
	 * @param    String amt
	 * @param    String xchRt
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmountByXchRt(String div, String amt, String xchRt, String currCd)  throws EventException{
		try {
			return dbDao.searchConvertedAmountByXchRt(div, amt, xchRt, currCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		}
	}
	
	/**
	 * 환율변환된 금액을 조회한다. 2015.05.08 USD를 제외한 통화를 계산하기 위해서는 중간에 한번 USD로 바꾸고 난 후 다시 INVOICE 통화로 변경
	 * @category VOP_PSO_0014_Calculation
	 * @param    String amt
	 * @param    String xchRt
	 * @param    String bcurrCd
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmountOtherByXchRt( String amt, String xchRt, String bcurrCd, String currCd)  throws EventException{
		try {
			return dbDao.searchConvertedAmountOtherByXchRt( amt, xchRt, bcurrCd, currCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Exchange Rate"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_PSO_0014 : Tariff File GW폴더로 카피 <br/>
	 * Invoice Creation & Audit 화면에서 Confirm Button Click 시 Tariff File GW폴더로 카피.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO[] fileSrchVOs
	 * @throws EventException
	 */
	public void fileSrchYdChgNos(InvAuditDataValidVO[] fileSrchVOs)  throws EventException{
		InvAuditDataValidVO fileSrchVO = new InvAuditDataValidVO();
		String rootPath = (new StringBuilder(String.valueOf(SiteConfigFactory.get("COM.FILE.UPLOAD.DIRECTORY")))).toString();	///a_upload/FILE/
		
		StringBuffer ydChgNoBuf = new StringBuffer();
		for(int i=0; i<fileSrchVOs.length; i++) {
			String ydChgNoStr = fileSrchVOs[i].getYdChgNo() == null ? "X" : fileSrchVOs[i].getYdChgNo();
			
			if ( i > 0 ) {
				ydChgNoBuf.append(",");
			}
			ydChgNoBuf.append("'" + ydChgNoStr + "'");
		}
		log.info("\n ydChgNoBuf = "+ydChgNoBuf);
		fileSrchVO.setYdChgNo(ydChgNoBuf.toString());
		List<ComUpldFileVO> fileList = null;
		try {
			fileList = dbDao.fileSrchYdChgNos(fileSrchVO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("err"+e.toString(),e);
			throw new EventException(e.getMessage(), e);
		}	catch (Exception e) {
			log.error("err"+e.toString(),e);
            throw new EventException(e.getMessage(), e);
        } //Confirm 대상 Tariff File List
		
		for(int i=0; i<fileList.size(); i++){
			ComUpldFileVO fvo  = new ComUpldFileVO();
			fvo = fileList.get(i);
			String oriFileID   = fvo.getFileSavId();
			String oriPath     = fvo.getFilePathUrl();
			String oriFullPath = oriPath+File.separator+oriFileID;	 //저장대상파일루트
			String gwPath      = rootPath+"GW_CSR_APRO"+File.separator+oriFileID; //카피대상폴더 //File.separator+
			
			File orgfile 	= new File(oriFullPath);
			File targetfile = new File(gwPath);
			
			try {
				log.info("\n fileCopy START!!!!!!!!!!!!!!!");
				log.info("\n oriFullPath ===> "+oriFullPath);
				log.info("\n oriFullPath ===> "+gwPath);
				fileCopy(orgfile, targetfile);
				log.info("\n fileCopy END!!!!!!!!!!!!!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("\n fileCopy ERROR!!");
				log.error(e);
				//e.printStackTrace();
				log.error("err"+e.toString(),e);
				throw new EventException(e.getMessage(), e);
			} 
			catch (Exception e) {
				log.error("err"+e.toString(),e);
	            throw new EventException(e.getMessage(), e);
	        } 
		}
	}
	
	/**
	 * CSR File Info List
	 * @param csrNo
	 * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrFileInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	 /**
	  * PSO Tariff 를 GW용 폴더로 파일카피 - 속도개선 nio 사용
	  * @param fOrg
	  * @param fTarget
	  * @throws IOException
	  */
	 private void fileCopy( File fOrg, File fTarget) throws IOException{
		  FileInputStream inputStream = new FileInputStream( fOrg);
		  if ( !fTarget.isFile())
		  {
			  File fParent = new File ( fTarget.getParent());
			  if ( !fParent.exists()){
			    fParent.mkdir();
			  }
			  fTarget.createNewFile();
		  }
		  FileOutputStream outputStream = new FileOutputStream( fTarget);
		  FileChannel fcin =  inputStream.getChannel();
		  FileChannel fcout = outputStream.getChannel();
		  long size = fcin.size();
		  fcin.transferTo(0, size, fcout);
		  fcout.close();
		  fcin.close();
		  outputStream.close();
		  inputStream.close();
	 }
	
	 
	 /**
	 *  VOP_PSO_0014 : TUG BOAT를 사용하는 계정을 CHECK하기 위함..
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String costCd
	 * @param String issDt
	 * @return String
	 * @throws EventException
	 */
	 public String searchAddInfo(String vndrSeq, String ydCd, String costCd, String issDt) throws EventException {
			try {
				return dbDao.searchAddInfo(vndrSeq,ydCd,costCd,issDt);
	
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[]{"NO.of Tug."}).getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("PSO90010", new String[]{"NO.of Tug."}).getMessage(),ex);
			}
		}	
	 
	 /**
		 *  VOP_PSO_0014 : BAF를 사용하는 계정을 CHECK하기 위함..
		 * @param String vndrSeq
		 * @param String ydCd
		 * @param String costCd
		 * @param String issDt
		 * @return String
		 * @throws EventException
		 */
		 public String searchAddCharge(String vndrSeq, String ydCd, String costCd, String issDt) throws EventException {
				try {
					return dbDao.searchAddCharge(vndrSeq,ydCd,costCd,issDt);
		
				} catch (DAOException ex) {
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"NO.of Tug."}).getMessage(),ex);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"NO.of Tug."}).getMessage(),ex);
				}
			}	
	 
	 /**
	 *  VOP_PSO_0217 : TUG BOAT를 사용하는 계정인 경우 regular value값 가져오기..
	 * @param String vvd
	 * @param String ydcd
	 * @param String io
	 * @param String ydchgno
	 * @param String ydchgverseq
	 * @return String
	 * @throws EventException
	 */
	 public String searchRegularAddInfo(String vvd,String ydcd, String io, String ydchgno, String ydchgverseq) throws EventException {
	    
		 String strNoTug ;
	    
		 if(("IN").equals(io))  {	
			  String strArvNoOfTug = getArvNoOfTug(vvd, ydcd, false); 
			  String strRegNoOfTug = getRegularValue(ydchgno,ydchgverseq, "6");
			  String strArvUsedHourOfTug = getRegularValue(ydchgno,ydchgverseq, "10");
			  
			  if(("").equals(strArvNoOfTug)) strArvNoOfTug = "0";
			  if(("").equals(strRegNoOfTug)) strRegNoOfTug = "0";
			  if(("").equals(strArvUsedHourOfTug)) strArvUsedHourOfTug = "0";
			  
			  strNoTug = strRegNoOfTug.toString() + "+" + strArvNoOfTug.toString() + "+" + strArvUsedHourOfTug.toString();
			  
			  return strNoTug;
			  
		     }
		 else if(("OUT").equals(io)) { 
		 	  String strDprNoOfTug = getDprNoOfTug(vvd, ydcd, false);
			  String strRegNoOfTug = getRegularValue(ydchgno,ydchgverseq, "7");
			  String strDprUsedHourOfTug = getRegularValue(ydchgno,ydchgverseq, "11");
			  
			  if(("").equals(strDprNoOfTug)) strDprNoOfTug = "0";
			  if(("").equals(strRegNoOfTug)) strDprNoOfTug = "0";
			  if(("").equals(strDprUsedHourOfTug)) strDprUsedHourOfTug = "0";
			  
			  strNoTug = strRegNoOfTug.toString() + "+" + strDprNoOfTug.toString() + "+" + strDprUsedHourOfTug.toString();
			
			  return strNoTug;
		    }
		 else return "";
		
		}	
	
	 /**
		 *  VOP_PSO_0218 : BAF를 사용하는 계정인 경우 가장 최근 value값 가져오기..
		 * @param String vndrSeq
		 * @param String ydcd
		 * @param String lgscostCd
		 * @return String
		 * @throws EventException
		 */
		 public String searchLastBafRate(String vndrSeq,String ydcd, String lgscostCd) throws EventException {
		    
			 try {
					return dbDao.searchLastBafRate(vndrSeq,ydcd,lgscostCd);
		
				} catch (DAOException ex) {
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"NO.of Tug."}).getMessage(),ex);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"NO.of Tug."}).getMessage(),ex);
				}
			
			}
	
	 /**
	 *  CSR Confirm시 해당 CSR의 INVOICE건에 대해 Tariff가 있는 경우 attach해 주기 위함.
	 * @param String csrno
	 * @param String creusrid
	 * @throws EventException
	 */
	 public void addCsrAttchTariffFile(String csrno, String creusrid)	throws EventException {
			try {

					dbDao.addCsrAttchTariffFile(csrno,creusrid);
				
					dbDao.modifyCsrAttchTariffFile(csrno);
					
		    	} catch (DAOException ex) {
				  throw new EventException(new ErrorHandler("COM12211", new String[]{"Call TPB Interface Procedure"}).getMessage(),ex);
			    } catch (Exception ex) {
				  throw new EventException(new ErrorHandler("COM12211", new String[]{"Call TPB Interface Procedure"}).getMessage(),ex);
			}
		}	
	 
}