/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AvailableOffHireBackEndJob.java
 *@FileTitle : Available Off Hire Q'ty
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration.CIMCommonDBDAO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.ComIntgCdListDataVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration.EQMatchBackNLoadFactorMgtDBDAO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.LoadFactorByTradeLaneVvdVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchMBByVesselVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * OPUS--Containerleasemgt Business Logic Command Interface<br>
 * 
 * @author 
 * @see Ees_lse_0020EventResponse reference
 * @since J2EE 1.6
 */
public class EQMatchBackNLoadFactorMgtBackEndJob extends BackEndCommandSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8991259368143777211L;

	private String jobType = null;

	private CIMCommonDBDAO dbComDao = new CIMCommonDBDAO();
	private EQMatchBackNLoadFactorMgtDBDAO dbDao = new EQMatchBackNLoadFactorMgtDBDAO();

	private SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO;

	/**
	 * handling requested job by BackEndJob <br>
	 * 
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception {
		List list2 = null;
		List list3 = null;
		List<ComIntgCdListDataVO> comList=null;
		
		String strCom= ConstantMgr.getCompanyCode();
		try {
			if (getJobType().equals("searchLoadFactorByTrade")) {
				
				list2 = new ArrayList<LoadFactorByTradeLaneVvdVO>();
				list3 = new ArrayList<LoadFactorByTradeLaneVvdVO>();
				comList=new ArrayList<ComIntgCdListDataVO>();
				
//				String fromDate = searchOptionByTradeLaneVvdVO.getFromdate().replace("-", "");
				List arrList = new ArrayList();
				if ("TTL".equals(searchOptionByTradeLaneVvdVO.getCompany())) { 
					
					 comList = dbComDao.searchComIntgCdListData("CD20064","");
					 
					 for (int  t=0; t < comList.size(); t++ ){
						 arrList.add(comList.get(t).getCodeNm());
					 }
				}
				else if (strCom.equals(searchOptionByTradeLaneVvdVO.getCompany())) {
						arrList.add(strCom);
				}
				else {
					arrList.add(searchOptionByTradeLaneVvdVO.getCompany());
				}
				LoadFactorByTradeLaneVvdVO vo = null;
				int y = 1;
				for (int x = 0; x < arrList.size(); x++) {
					List<LoadFactorByTradeLaneVvdVO> list = null;
					searchOptionByTradeLaneVvdVO.setCompany((String)arrList.get(x));
					list = dbDao.searchLoadFactorByTrade(searchOptionByTradeLaneVvdVO);

					for (int i = 0; i < list.size(); i++) {
						LoadFactorByTradeLaneVvdVO vos = new LoadFactorByTradeLaneVvdVO();
						vos = (LoadFactorByTradeLaneVvdVO) list.get(i);
						vo = new LoadFactorByTradeLaneVvdVO();

						vo.setColsorts(y + "");
						vo.setCompany((String) arrList.get(x));
						vo.setFromregion(vos.getFromregion());
						vo.setTrade(vos.getTrade());
						vo.setLane(vos.getLane());
						vo.setVvd(vos.getVvd());
						vo.setPort(vos.getPort());
						vo.setAtd(vos.getAtd());
						vo.setAtdWeek(vos.getAtdWeek());
						// BSA 
						if (!"".equals(vos.getBsaspace())) {
							int index = vos.getBsaspace().indexOf(",");
							vo.setBsaspace(vos.getBsaspace().substring(0, index));
							vo.setBsaweight(vos.getBsaspace().substring(index + 1));
						/*	
							String[] arrValue = cutStringToArray(vos.getBsaspace(),",");
							vo.setBsaspace(arrValue[0]);
							vo.setBsaweight(arrValue[1]);
							vo.setReleasedteu(arrValue[2]);
							vo.setReleasedweight(arrValue[3]);
						*/	
						}
						else {
							vo.setBsaspace("0");
							vo.setBsaweight("0");
					//		vo.setReleasedteu("0");
					//		vo.setReleasedweight("0");
						}
						if ("".equals(vos.getDatasource())) {
							DBRowSet rowQty = null;
							rowQty = dbDao.searchLoadFactorByTradeQTY(vos.getVvd(), vo.getCompany(), vos.getFromregion(), vos.getCallseq());

							if (rowQty.next()) { 
								if ("0".equals(rowQty.getString("weightTotal")) && strCom.equals(vo.getCompany())) { 
									vo.setDatasource(rowQty.getString("dataSource_b"));
									vo.setFull20qty(rowQty.getString("full20Qty_b"));
									vo.setFull40qty(rowQty.getString("full40Qty_b"));
									vo.setFullhcqty(rowQty.getString("fullHcQty_b"));
									vo.setFull45qty(rowQty.getString("full45Qty_b"));
									vo.setMty20qty(rowQty.getString("mty20Qty_b"));
									vo.setMty40qty(rowQty.getString("mty40Qty_b"));
									vo.setMtyhcqty(rowQty.getString("mtyHcQty_b"));
									vo.setMty45qty(rowQty.getString("mty45Qty_b"));
									vo.setWeighttotal("0");
									vo.setDeadslot(rowQty.getString("deadSlot"));
								}
								else { // in case of existing RDR
									if("0".equals(rowQty.getString("weightTotal"))){
										
										vo.setDatasource("");
										vo.setFull20qty("0");
										vo.setFull40qty("0");
										vo.setFullhcqty("0");
										vo.setFull45qty("0");
										vo.setMty20qty("0");
										vo.setMty40qty("0");
										vo.setMtyhcqty("0");
										vo.setMty45qty("0");
										vo.setWeighttotal("0");
										vo.setDeadslot(vos.getDeadslot());
										if("0".equals(vo.getBsaspace())){
											continue;
										}
									}
									else{
										vo.setDatasource(rowQty.getString("dataSource"));
										vo.setFull20qty(rowQty.getString("full20Qty"));
										vo.setFull40qty(rowQty.getString("full40Qty"));
										vo.setFullhcqty(rowQty.getString("fullHcQty"));
										vo.setFull45qty(rowQty.getString("full45Qty"));
										vo.setMty20qty(rowQty.getString("mty20Qty"));
										vo.setMty40qty(rowQty.getString("mty40Qty"));
										vo.setMtyhcqty(rowQty.getString("mtyHcQty"));
										vo.setMty45qty(rowQty.getString("mty45Qty"));
										vo.setWeighttotal(rowQty.getString("weightTotal"));
										vo.setDeadslot(vos.getDeadslot());
									}

								}
							}
							else {
								vo.setDatasource("");
								vo.setFull20qty("0");
								vo.setFull40qty("0");
								vo.setFullhcqty("0");
								vo.setFull45qty("0");
								vo.setMty20qty("0");
								vo.setMty40qty("0");
								vo.setMtyhcqty("0");
								vo.setMty45qty("0");
								vo.setWeighttotal("0");
								vo.setDeadslot("0");
								if("0".equals(vo.getBsaspace())){
									continue;
								}

							}
						}
						else { 
							vo.setDatasource("BAY");
							vo.setFull20qty(vos.getFull20qty());
							vo.setFull40qty(vos.getFull40qty());
							vo.setFullhcqty(vos.getFullhcqty());
							vo.setFull45qty(vos.getFull45qty());
							vo.setMty20qty(vos.getMty20qty());
							vo.setMty40qty(vos.getMty40qty());
							vo.setMtyhcqty(vos.getMtyhcqty());
							vo.setMty45qty(vos.getMty45qty());
							vo.setWeighttotal(vos.getWeighttotal());
							vo.setDeadslot(vos.getDeadslot());

						}

						if (!"".equals(vos.getReleasedteu())) {
							int index = vos.getReleasedteu().indexOf(",");
							vo.setReleasedteu(vos.getReleasedteu().substring(0, index));
							vo.setReleasedweight(vos.getReleasedteu().substring(index + 1));
						}
						else{
							vo.setReleasedteu("0");
							vo.setReleasedweight("0");
						}
						
						double nTEUTotal = (Double.parseDouble(vo.getFull20qty()) + (2 * (Double.parseDouble(vo
								.getFull40qty())
								+ Double.parseDouble(vo.getFullhcqty()) + Double.parseDouble(vo.getFull45qty()))))
								+ (Double.parseDouble(vo.getMty20qty()) + (2 * (Double.parseDouble(vo.getMty40qty())
										+ Double.parseDouble(vo.getMtyhcqty()) + Double.parseDouble(vo.getMty45qty()))));
						// TEUTotal value
						vo.setTeutotal(String.valueOf(nTEUTotal));
						// FullTotal value
						vo.setFulltotal(String.valueOf(Double.parseDouble(vo.getFull20qty())
								+ Double.parseDouble(vo.getFull40qty()) + Double.parseDouble(vo.getFullhcqty())
								+ Double.parseDouble(vo.getFull45qty())));
						// MTYTotal value
						vo.setMtytotal(String.valueOf(Double.parseDouble(vo.getMty20qty())
								+ Double.parseDouble(vo.getMty40qty()) + Double.parseDouble(vo.getMtyhcqty())
								+ Double.parseDouble(vo.getMty45qty())));
						// Unusedspace value
						vo.setUnusedspace(String.valueOf(Double.parseDouble(vo.getBsaspace())
								- (nTEUTotal + Double.parseDouble(vo.getDeadslot()))
								+ Double.parseDouble(vo.getReleasedteu())));
						// Unusedweight value
						vo.setUnusedweight(String.valueOf((Double.parseDouble(vo.getBsaweight()) - Double
								.parseDouble(vo.getWeighttotal()))
								+ Double.parseDouble(vo.getReleasedweight())));
						// Boxtotal value
						vo.setBoxtotal(String.valueOf(Double.parseDouble(vo.getFull20qty())
								+ Double.parseDouble(vo.getFull40qty()) + Double.parseDouble(vo.getFullhcqty())
								+ Double.parseDouble(vo.getFull45qty()) + Double.parseDouble(vo.getMty20qty())
								+ Double.parseDouble(vo.getMty40qty()) + Double.parseDouble(vo.getMtyhcqty())
								+ Double.parseDouble(vo.getMty45qty())));

						// fullLf calculation logic
						if (Float.parseFloat(vo.getBsaspace()) == 0) {
							vo.setLffull("0.0");
						}
						else {
							// Load Factor Full value calculation logic
							float lfFull = (Float.parseFloat(vo.getFull20qty())+ 2
									* (Float.parseFloat(vo.getFull40qty()) + Float.parseFloat(vo.getFullhcqty()) + Float
											.parseFloat(vo.getFull45qty())) + Float.parseFloat(vo.getDeadslot()))
									/ (Float.parseFloat(vo.getBsaspace()) + Float.parseFloat(vo.getReleasedteu()))
									* 100;

							BigDecimal blfFull = new BigDecimal(lfFull);

							vo.setLffull(String.valueOf(blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue())+ "");
						}

						// LF_EQ calculation logic
						if (Float.parseFloat(vo.getBsaspace()) == 0) {
							vo.setLfeq("0.0");
						}
						else {
							// Load Factor EQ value calculation logic
							float teuTotal = (Float.parseFloat(vo.getFull20qty())
									+ 2
									* (Float.parseFloat(vo.getFull40qty()) + Float.parseFloat(vo.getFullhcqty()) + Float
											.parseFloat(vo.getFull45qty())) + Float.parseFloat(vo.getMty20qty()) + 2 * (Float
									.parseFloat(vo.getMty40qty())
									+ Float.parseFloat(vo.getMtyhcqty()) + Float.parseFloat(vo.getMty45qty())));

							float lfEq = ((teuTotal + Integer.parseInt(vo.getDeadslot())) / (Float.parseFloat(vo
									.getBsaspace()) + Float.parseFloat(vo.getReleasedteu()))) * 100;

							BigDecimal blfEq = new BigDecimal(lfEq);

							vo.setLfeq(String.valueOf(blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()) + "");

						}

						// LF_WGT calculation logic
						if (Float.parseFloat(vo.getBsaweight()) == 0) {
							vo.setLfwgt("0.0");
						}
						else {
							// Load Factor Weight value calculation logic
							float lfWgt = (Float.parseFloat(vo.getWeighttotal()) / (Float.parseFloat(vo.getBsaweight()) + Float
									.parseFloat(vo.getReleasedweight()))) * 100;

							BigDecimal blfWgt = new BigDecimal(lfWgt);
							vo.setLfwgt(String.valueOf(blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()) + "");

						}

						list3.add(vo);
						y++;
					}
				}

				// S.Total G.Total calculation logic
				String xTCompany = "";
				String xTRegion = "";
				String xTTrade = "";

				double[] loadQtyS = new double[23];

				double[] loadQtyG = new double[23];

				int m = 0;
				for (int k = 0; k < list3.size(); k++) {
					LoadFactorByTradeLaneVvdVO vos = new LoadFactorByTradeLaneVvdVO();
					vos = (LoadFactorByTradeLaneVvdVO) list3.get(k);

					String zTCompany = vos.getCompany();
					String zTRegion = vos.getFromregion();
					String zTTrade = vos.getTrade();
					
					// calculating sub total by Company,Region,Tread
					if ((zTCompany.equals(xTCompany) && zTRegion.equals(xTRegion) && zTTrade.equals(xTTrade)) || k == 0) {

						vo = new LoadFactorByTradeLaneVvdVO();
						vo.setColsorts(vos.getColsorts());
						vo.setCompany(vos.getCompany());
						vo.setFromregion(vos.getFromregion());
						vo.setTrade(vos.getTrade());
						vo.setLane(vos.getLane());
						vo.setVvd(vos.getVvd());
						vo.setPort(vos.getPort());
						vo.setAtd(vos.getAtd());
						vo.setAtdWeek(vos.getAtdWeek());

						vo.setFull20qty(vos.getFull20qty());
						vo.setFull40qty(vos.getFull40qty());
						vo.setFullhcqty(vos.getFullhcqty());
						vo.setFull45qty(vos.getFull45qty());
						vo.setMty20qty(vos.getMty20qty());
						vo.setMty40qty(vos.getMty40qty());
						vo.setMtyhcqty(vos.getMtyhcqty());
						vo.setMty45qty(vos.getMty45qty());
						vo.setWeighttotal(vos.getWeighttotal());
						vo.setDeadslot(vos.getDeadslot());

						vo.setReleasedteu(vos.getReleasedteu());
						vo.setReleasedweight(vos.getReleasedweight());

						vo.setFulltotal(vos.getFulltotal());
						vo.setMtytotal(vos.getMtytotal());
						vo.setUnusedspace(vos.getUnusedspace());
						vo.setUnusedweight(vos.getUnusedweight());
						vo.setBoxtotal(vos.getBoxtotal());
						vo.setBsaspace(vos.getBsaspace());
						vo.setBsaweight(vos.getBsaweight());
						vo.setTeutotal(vos.getTeutotal());
						vo.setLffull(vos.getLffull());
						vo.setLfeq(vos.getLfeq());
						vo.setLfwgt(vos.getLfwgt());
						vo.setDatasource(vos.getDatasource());

						list2.add(m, vo);
						m++;

						loadQtyS[0] = Double.parseDouble(vos.getFull20qty()) + loadQtyS[0];
						loadQtyS[1] = Double.parseDouble(vos.getFull40qty()) + loadQtyS[1];
						loadQtyS[2] = Double.parseDouble(vos.getFullhcqty()) + loadQtyS[2];
						loadQtyS[3] = Double.parseDouble(vos.getFull45qty()) + loadQtyS[3];
						loadQtyS[4] = Double.parseDouble(vos.getFulltotal()) + loadQtyS[4];
						loadQtyS[5] = Double.parseDouble(vos.getMty20qty()) + loadQtyS[5];
						loadQtyS[6] = Double.parseDouble(vos.getMty40qty()) + loadQtyS[6];
						loadQtyS[7] = Double.parseDouble(vos.getMtyhcqty()) + loadQtyS[7];
						loadQtyS[8] = Double.parseDouble(vos.getMty45qty()) + loadQtyS[8];
						loadQtyS[9] = Double.parseDouble(vos.getMtytotal()) + loadQtyS[9];

						loadQtyS[10] = Double.parseDouble(vos.getBoxtotal()) + loadQtyS[10];
						loadQtyS[11] = Double.parseDouble(vos.getTeutotal()) + loadQtyS[11];
						loadQtyS[12] = Double.parseDouble(vos.getDeadslot()) + loadQtyS[12];
						loadQtyS[13] = Double.parseDouble(vos.getWeighttotal()) + loadQtyS[13];
						loadQtyS[14] = Double.parseDouble(vos.getReleasedteu()) + loadQtyS[14];
						loadQtyS[15] = Double.parseDouble(vos.getReleasedweight()) + loadQtyS[15];
						loadQtyS[16] = Double.parseDouble(vos.getBsaspace()) + loadQtyS[16];

						loadQtyS[17] = Double.parseDouble(vos.getBsaweight()) + loadQtyS[17];
						loadQtyS[18] = Double.parseDouble(vos.getUnusedspace()) + loadQtyS[18];
						loadQtyS[19] = Double.parseDouble(vos.getUnusedweight()) + loadQtyS[19];

						if (loadQtyS[16] != 0.0) {
							double lfFull = ((loadQtyS[0] + 2 * (loadQtyS[1] + loadQtyS[2] + loadQtyS[3]) + loadQtyS[12]) / (loadQtyS[16] + loadQtyS[14])) * 100;
							BigDecimal blfFull = new BigDecimal(lfFull);
							loadQtyS[20] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

						}
						else {
							loadQtyS[20] = Double.parseDouble("0.0");
						}

						if (loadQtyS[16] == 0.0) {
							loadQtyS[21] = Double.parseDouble("0.0");
						}
						else {
							double teuTotal = (loadQtyS[0] + 2 * (loadQtyS[1] + loadQtyS[2] + loadQtyS[3])
									+ loadQtyS[5] + 2 * (loadQtyS[6] + loadQtyS[7] + loadQtyS[8]));

							double lfEq = ((teuTotal + loadQtyS[12]) / (loadQtyS[16] + loadQtyS[14])) * 100;

							BigDecimal blfEq = new BigDecimal(lfEq);

							loadQtyS[21] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
						}

						if (loadQtyS[17] == 0.0) {
							loadQtyS[22] = Double.parseDouble("0.0");
						}
						else {
							double lfWgt = (loadQtyS[13] / (loadQtyS[17] + loadQtyS[15])) * 100;

							BigDecimal blfWgt = new BigDecimal(lfWgt);
							loadQtyS[22] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

						}

						loadQtyG[0] = Double.parseDouble(vos.getFull20qty()) + loadQtyG[0];
						loadQtyG[1] = Double.parseDouble(vos.getFull40qty()) + loadQtyG[1];
						loadQtyG[2] = Double.parseDouble(vos.getFullhcqty()) + loadQtyG[2];
						loadQtyG[3] = Double.parseDouble(vos.getFull45qty()) + loadQtyG[3];
						loadQtyG[4] = Double.parseDouble(vos.getFulltotal()) + loadQtyG[4];
						loadQtyG[5] = Double.parseDouble(vos.getMty20qty()) + loadQtyG[5];
						loadQtyG[6] = Double.parseDouble(vos.getMty40qty()) + loadQtyG[6];
						loadQtyG[7] = Double.parseDouble(vos.getMtyhcqty()) + loadQtyG[7];
						loadQtyG[8] = Double.parseDouble(vos.getMty45qty()) + loadQtyG[8];
						loadQtyG[9] = Double.parseDouble(vos.getMtytotal()) + loadQtyG[9];

						loadQtyG[10] = Double.parseDouble(vos.getBoxtotal()) + loadQtyG[10];
						loadQtyG[11] = Double.parseDouble(vos.getTeutotal()) + loadQtyG[11];
						loadQtyG[12] = Double.parseDouble(vos.getDeadslot()) + loadQtyG[12];
						loadQtyG[13] = Double.parseDouble(vos.getWeighttotal()) + loadQtyG[13];
						loadQtyG[14] = Double.parseDouble(vos.getReleasedteu()) + loadQtyG[14];
						loadQtyG[15] = Double.parseDouble(vos.getReleasedweight()) + loadQtyG[15];
						loadQtyG[16] = Double.parseDouble(vos.getBsaspace()) + loadQtyG[16];

						loadQtyG[17] = Double.parseDouble(vos.getBsaweight()) + loadQtyG[17];
						loadQtyG[18] = Double.parseDouble(vos.getUnusedspace()) + loadQtyG[18];
						loadQtyG[19] = Double.parseDouble(vos.getUnusedweight()) + loadQtyG[19];

						if (loadQtyG[16] != 0.0) {
							double lfFull = ((loadQtyG[0] + 2 * (loadQtyG[1] + loadQtyG[2] + loadQtyG[3]) + loadQtyG[12]) / (loadQtyG[16] + loadQtyG[14])) * 100;
							BigDecimal blfFull = new BigDecimal(lfFull);
							loadQtyG[20] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

						}
						else {
							loadQtyG[20] = Double.parseDouble("0.0");
						}

						if (loadQtyG[16] == 0.0) {
							loadQtyG[21] = Double.parseDouble("0.0");
						}
						else {
							double teuTotal = (loadQtyG[0] + 2 * (loadQtyG[1] + loadQtyG[2] + loadQtyG[3])
									+ loadQtyG[5] + 2 * (loadQtyG[6] + loadQtyG[7] + loadQtyG[8]));

							double lfEq = ((teuTotal + loadQtyG[12]) / (loadQtyG[16] + loadQtyG[14])) * 100;

							BigDecimal blfEq = new BigDecimal(lfEq);

							loadQtyG[21] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
						}

						if (loadQtyG[17] == 0.0) {
							loadQtyG[22] = Double.parseDouble("0.0");
						}
						else {
							double lfWgt = (loadQtyG[13] / (loadQtyG[17] + loadQtyG[15])) * 100;

							BigDecimal blfWgt = new BigDecimal(lfWgt);
							loadQtyG[22] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

						}

						xTCompany = zTCompany;
						xTRegion = zTRegion;
						xTTrade = zTTrade;

					}
					else { 
						// No showing total in case of VVD condition
						if ("".equals(searchOptionByTradeLaneVvdVO.getVvd())) { 
							vo = new LoadFactorByTradeLaneVvdVO();
							vo.setColsorts("");
							vo.setCompany("Total");
							vo.setFromregion(xTRegion);
							vo.setTrade(xTTrade);
							vo.setLane("");
							vo.setVvd("");
							vo.setPort("");
							vo.setAtd("");
							vo.setAtdWeek("");
							vo.setFull20qty(loadQtyS[0] + "");
							vo.setFull40qty(loadQtyS[1] + "");
							vo.setFullhcqty(loadQtyS[2] + "");
							vo.setFull45qty(loadQtyS[3] + "");
							vo.setFulltotal(loadQtyS[4] + "");
							vo.setMty20qty(loadQtyS[5] + "");
							vo.setMty40qty(loadQtyS[6] + "");
							vo.setMtyhcqty(loadQtyS[7] + "");
							vo.setMty45qty(loadQtyS[8] + "");
							vo.setMtytotal(loadQtyS[9] + "");

							vo.setWeighttotal(loadQtyS[13] + "");
							vo.setDeadslot(loadQtyS[12] + "");

							vo.setReleasedteu(loadQtyS[14] + "");
							vo.setReleasedweight(loadQtyS[15] + "");

							vo.setUnusedspace(loadQtyS[18] + "");
							vo.setUnusedweight(loadQtyS[19] + "");
							vo.setBoxtotal(loadQtyS[10] + "");

							vo.setBsaspace(loadQtyS[16] + "");
							vo.setBsaweight(loadQtyS[17] + "");
							vo.setTeutotal(loadQtyS[11] + "");

							vo.setLffull(loadQtyS[20] + "");
							vo.setLfeq(loadQtyS[21] + "");
							vo.setLfwgt(loadQtyS[22] + "");
							vo.setDatasource("");

							list2.add(m, vo);
							m++;

							loadQtyS[0] = 0;
							loadQtyS[1] = 0;
							loadQtyS[2] = 0;
							loadQtyS[3] = 0;
							loadQtyS[4] = 0;
							loadQtyS[5] = 0;
							loadQtyS[6] = 0;
							loadQtyS[7] = 0;
							loadQtyS[8] = 0;
							loadQtyS[9] = 0;
							loadQtyS[10] = 0;
							loadQtyS[11] = 0;
							loadQtyS[12] = 0;
							loadQtyS[13] = 0;
							loadQtyS[14] = 0;
							loadQtyS[15] = 0;
							loadQtyS[16] = 0;
							loadQtyS[17] = 0;
							loadQtyS[18] = 0;
							loadQtyS[19] = 0;
							loadQtyS[20] = 0;
							loadQtyS[21] = 0;
							loadQtyS[22] = 0;
						}
						vo = new LoadFactorByTradeLaneVvdVO();
						vo.setColsorts(vos.getColsorts());
						vo.setCompany(vos.getCompany());
						vo.setFromregion(vos.getFromregion());
						vo.setTrade(vos.getTrade());
						vo.setLane(vos.getLane());
						vo.setVvd(vos.getVvd());
						vo.setPort(vos.getPort());
						vo.setAtd(vos.getAtd());
						vo.setAtdWeek(vos.getAtdWeek());

						vo.setFull20qty(vos.getFull20qty());
						vo.setFull40qty(vos.getFull40qty());
						vo.setFullhcqty(vos.getFullhcqty());
						vo.setFull45qty(vos.getFull45qty());
						vo.setMty20qty(vos.getMty20qty());
						vo.setMty40qty(vos.getMty40qty());
						vo.setMtyhcqty(vos.getMtyhcqty());
						vo.setMty45qty(vos.getMty45qty());
						vo.setWeighttotal(vos.getWeighttotal());
						vo.setDeadslot(vos.getDeadslot());

						vo.setReleasedteu(vos.getReleasedteu());
						vo.setReleasedweight(vos.getReleasedweight());

						vo.setFulltotal(vos.getFulltotal());
						vo.setMtytotal(vos.getMtytotal());
						vo.setUnusedspace(vos.getUnusedspace());
						vo.setUnusedweight(vos.getUnusedweight());
						vo.setBoxtotal(vos.getBoxtotal());
						vo.setBsaspace(vos.getBsaspace());
						vo.setBsaweight(vos.getBsaweight());
						vo.setTeutotal(vos.getTeutotal());
						vo.setLffull(vos.getLffull());
						vo.setLfeq(vos.getLfeq());
						vo.setLfwgt(vos.getLfwgt());

						vo.setDatasource(vos.getDatasource());
						list2.add(m, vo);
						m++;
						// No showing total in case of VVD condition
						if ("".equals(searchOptionByTradeLaneVvdVO.getVvd())) { 
							loadQtyS[0] = Double.parseDouble(vos.getFull20qty()) + loadQtyS[0];
							loadQtyS[1] = Double.parseDouble(vos.getFull40qty()) + loadQtyS[1];
							loadQtyS[2] = Double.parseDouble(vos.getFullhcqty()) + loadQtyS[2];
							loadQtyS[3] = Double.parseDouble(vos.getFull45qty()) + loadQtyS[3];
							loadQtyS[4] = Double.parseDouble(vos.getFulltotal()) + loadQtyS[4];
							loadQtyS[5] = Double.parseDouble(vos.getMty20qty()) + loadQtyS[5];
							loadQtyS[6] = Double.parseDouble(vos.getMty40qty()) + loadQtyS[6];
							loadQtyS[7] = Double.parseDouble(vos.getMtyhcqty()) + loadQtyS[7];
							loadQtyS[8] = Double.parseDouble(vos.getMty45qty()) + loadQtyS[8];
							loadQtyS[9] = Double.parseDouble(vos.getMtytotal()) + loadQtyS[9];

							loadQtyS[10] = Double.parseDouble(vos.getBoxtotal()) + loadQtyS[10];
							loadQtyS[11] = Double.parseDouble(vos.getTeutotal()) + loadQtyS[11];
							loadQtyS[12] = Double.parseDouble(vos.getDeadslot()) + loadQtyS[12];
							loadQtyS[13] = Double.parseDouble(vos.getWeighttotal()) + loadQtyS[13];
							loadQtyS[14] = Double.parseDouble(vos.getReleasedteu()) + loadQtyS[14];
							loadQtyS[15] = Double.parseDouble(vos.getReleasedweight()) + loadQtyS[15];
							loadQtyS[16] = Double.parseDouble(vos.getBsaspace()) + loadQtyS[16];

							loadQtyS[17] = Double.parseDouble(vos.getBsaweight()) + loadQtyS[17];
							loadQtyS[18] = Double.parseDouble(vos.getUnusedspace()) + loadQtyS[18];
							loadQtyS[19] = Double.parseDouble(vos.getUnusedweight()) + loadQtyS[19];

							if (loadQtyS[16] != 0.0) {
								double lfFull = ((loadQtyS[0] + 2 * (loadQtyS[1] + loadQtyS[2] + loadQtyS[3]) + loadQtyS[12]) / (loadQtyS[16] + loadQtyS[14])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								loadQtyS[20] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								loadQtyS[20] = Double.parseDouble("0.0");
							}

							if (loadQtyS[16] == 0.0) {
								loadQtyS[21] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (loadQtyS[0] + 2 * (loadQtyS[1] + loadQtyS[2] + loadQtyS[3])
										+ loadQtyS[5] + 2 * (loadQtyS[6] + loadQtyS[7] + loadQtyS[8]));

								double lfEq = ((teuTotal + loadQtyS[12]) / (loadQtyS[16] + loadQtyS[14])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								loadQtyS[21] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (loadQtyS[17] == 0.0) {
								loadQtyS[22] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (loadQtyS[13] / (loadQtyS[17] + loadQtyS[15])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								loadQtyS[22] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
						}

						loadQtyG[0] = Double.parseDouble(vos.getFull20qty()) + loadQtyG[0];
						loadQtyG[1] = Double.parseDouble(vos.getFull40qty()) + loadQtyG[1];
						loadQtyG[2] = Double.parseDouble(vos.getFullhcqty()) + loadQtyG[2];
						loadQtyG[3] = Double.parseDouble(vos.getFull45qty()) + loadQtyG[3];
						loadQtyG[4] = Double.parseDouble(vos.getFulltotal()) + loadQtyG[4];
						loadQtyG[5] = Double.parseDouble(vos.getMty20qty()) + loadQtyG[5];
						loadQtyG[6] = Double.parseDouble(vos.getMty40qty()) + loadQtyG[6];
						loadQtyG[7] = Double.parseDouble(vos.getMtyhcqty()) + loadQtyG[7];
						loadQtyG[8] = Double.parseDouble(vos.getMty45qty()) + loadQtyG[8];
						loadQtyG[9] = Double.parseDouble(vos.getMtytotal()) + loadQtyG[9];

						loadQtyG[10] = Double.parseDouble(vos.getBoxtotal()) + loadQtyG[10];
						loadQtyG[11] = Double.parseDouble(vos.getTeutotal()) + loadQtyG[11];
						loadQtyG[12] = Double.parseDouble(vos.getDeadslot()) + loadQtyG[12];
						loadQtyG[13] = Double.parseDouble(vos.getWeighttotal()) + loadQtyG[13];
						loadQtyG[14] = Double.parseDouble(vos.getReleasedteu()) + loadQtyG[14];
						loadQtyG[15] = Double.parseDouble(vos.getReleasedweight()) + loadQtyG[15];
						loadQtyG[16] = Double.parseDouble(vos.getBsaspace()) + loadQtyG[16];

						loadQtyG[17] = Double.parseDouble(vos.getBsaweight()) + loadQtyG[17];
						loadQtyG[18] = Double.parseDouble(vos.getUnusedspace()) + loadQtyG[18];
						loadQtyG[19] = Double.parseDouble(vos.getUnusedweight()) + loadQtyG[19];

						if (loadQtyG[16] != 0.0) {
							double lfFull = ((loadQtyG[0] + 2 * (loadQtyG[1] + loadQtyG[2] + loadQtyG[3]) + loadQtyG[12]) / (loadQtyG[16] + loadQtyG[14])) * 100;
							BigDecimal blfFull = new BigDecimal(lfFull);
							loadQtyG[20] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

						}
						else {
							loadQtyG[20] = Double.parseDouble("0.0");
						}

						if (loadQtyG[16] == 0.0) {
							loadQtyG[21] = Double.parseDouble("0.0");
						}
						else {
							double teuTotal = (loadQtyG[0] + 2 * (loadQtyG[1] + loadQtyG[2] + loadQtyG[3])
									+ loadQtyG[5] + 2 * (loadQtyG[6] + loadQtyG[7] + loadQtyG[8]));

							double lfEq = ((teuTotal + loadQtyG[12]) / (loadQtyG[16] + loadQtyG[14])) * 100;

							BigDecimal blfEq = new BigDecimal(lfEq);

							loadQtyG[21] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
						}

						if (loadQtyG[17] == 0.0) {
							loadQtyG[22] = Double.parseDouble("0.0");
						}
						else {
							double lfWgt = (loadQtyG[13] / (loadQtyG[17] + loadQtyG[15])) * 100;

							BigDecimal blfWgt = new BigDecimal(lfWgt);
							loadQtyG[22] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

						}

						xTCompany = zTCompany;
						xTRegion = zTRegion;
						xTTrade = zTTrade;
					}
				} // for end
				if (list2.size() > 0) {
					// No showing total in case of VVD condition
					if ("".equals(searchOptionByTradeLaneVvdVO.getVvd())) { 
						vo = new LoadFactorByTradeLaneVvdVO();
						vo.setColsorts("");
						vo.setCompany("Total");
						vo.setFromregion(xTRegion);
						vo.setTrade(xTTrade);
						vo.setLane("");
						vo.setVvd("");
						vo.setPort("");
						vo.setAtd("");
						vo.setAtdWeek("");
						vo.setFull20qty(loadQtyS[0] + "");
						vo.setFull40qty(loadQtyS[1] + "");
						vo.setFullhcqty(loadQtyS[2] + "");
						vo.setFull45qty(loadQtyS[3] + "");
						vo.setFulltotal(loadQtyS[4] + "");
						vo.setMty20qty(loadQtyS[5] + "");
						vo.setMty40qty(loadQtyS[6] + "");
						vo.setMtyhcqty(loadQtyS[7] + "");
						vo.setMty45qty(loadQtyS[8] + "");
						vo.setMtytotal(loadQtyS[9] + "");

						vo.setWeighttotal(loadQtyS[13] + "");
						vo.setDeadslot(loadQtyS[12] + "");

						vo.setReleasedteu(loadQtyS[14] + "");
						vo.setReleasedweight(loadQtyS[15] + "");

						vo.setUnusedspace(loadQtyS[18] + "");
						vo.setUnusedweight(loadQtyS[19] + "");
						vo.setBoxtotal(loadQtyS[10] + "");

						vo.setBsaspace(loadQtyS[16] + "");
						vo.setBsaweight(loadQtyS[17] + "");
						vo.setTeutotal(loadQtyS[11] + "");

						vo.setLffull(loadQtyS[20] + "");
						vo.setLfeq(loadQtyS[21] + "");
						vo.setLfwgt(loadQtyS[22] + "");
						vo.setDatasource("");
						list2.add(m, vo);
						m++;
					}

					vo = new LoadFactorByTradeLaneVvdVO();
					vo.setColsorts("");
					vo.setCompany("G.Total");
					vo.setFromregion(xTRegion);
					vo.setTrade(xTTrade);
					vo.setLane("");
					vo.setVvd("");
					vo.setPort("");
					vo.setAtd("");
					vo.setAtdWeek("");
					vo.setFull20qty(loadQtyG[0] + "");
					vo.setFull40qty(loadQtyG[1] + "");
					vo.setFullhcqty(loadQtyG[2] + "");
					vo.setFull45qty(loadQtyG[3] + "");
					vo.setFulltotal(loadQtyG[4] + "");
					vo.setMty20qty(loadQtyG[5] + "");
					vo.setMty40qty(loadQtyG[6] + "");
					vo.setMtyhcqty(loadQtyG[7] + "");
					vo.setMty45qty(loadQtyG[8] + "");
					vo.setMtytotal(loadQtyG[9] + "");

					vo.setWeighttotal(loadQtyG[13] + "");
					vo.setDeadslot(loadQtyG[12] + "");

					vo.setReleasedteu(loadQtyG[14] + "");
					vo.setReleasedweight(loadQtyG[15] + "");

					vo.setUnusedspace(loadQtyG[18] + "");
					vo.setUnusedweight(loadQtyG[19] + "");
					vo.setBoxtotal(loadQtyG[10] + "");

					vo.setBsaspace(loadQtyG[16] + "");
					vo.setBsaweight(loadQtyG[17] + "");
					vo.setTeutotal(loadQtyG[11] + "");

					vo.setLffull(loadQtyG[20] + "");
					vo.setLfeq(loadQtyG[21] + "");
					vo.setLfwgt(loadQtyG[22] + "");
					vo.setDatasource("");
					list2.add(m, vo);
					m++;
				}

			}
			else if (getJobType().equals("searchMBByVessel")) {
				List<SearchMBByVesselVO> list1 = new ArrayList<SearchMBByVesselVO>();
				list2 = new ArrayList<SearchMBByVesselVO>();
//				String fromDate = searchOptionByTradeLaneVvdVO.getFromdate().replace("-", "");
				List arrList = new ArrayList();
				if ("TTL".equals(searchOptionByTradeLaneVvdVO.getCompany())) { 	
					comList = dbComDao.searchComIntgCdListData("CD20064","");
					 
					 for (int  t=0; t < comList.size(); t++ ){
						 arrList.add(comList.get(t).getCodeNm());
					 }
				}
				else if (strCom.equals(searchOptionByTradeLaneVvdVO.getCompany())) {

					arrList.add(strCom);

				}
				else {
					arrList.add(searchOptionByTradeLaneVvdVO.getCompany());
				}
				SearchMBByVesselVO vo = null;

				// SEQ COM TRADE .... WEEK SETTING
				// if ( list.size() > 0 ) {

				int k = 0;

				for (int x = 0; x < arrList.size(); x++) {
					List<SearchMBByVesselVO> list = null;
					searchOptionByTradeLaneVvdVO.setCompany((String) arrList.get(x));
					list = dbDao.searchMBByVessel(searchOptionByTradeLaneVvdVO);

					for (int i = 0; i < list.size(); i++) {
						SearchMBByVesselVO vos = new SearchMBByVesselVO();
						vos = (SearchMBByVesselVO) list.get(i);

						if ("Out".equals(vos.getIo())) {
							k++;
						}

						if (!"".equals(vos.getVvd())) {
							vos.setSeq(k + "");
							vos.setCom((String) arrList.get(x));
							vos.setTrade(vos.getTrdCd());
							vos.setLane(vos.getLaneCd());
							vos.setRegion(vos.getFromRgn());
							vos.setLastport(vos.getVpsPortCd());
							vos.setAtd(vos.getVpsEtdDt());
							vos.setDatasource(vos.getVal01());
							// BSA 
							if (!"".equals(vos.getBsaspace())) {
								int index = vos.getBsaspace().indexOf(",");
								vos.setBsaweight(vos.getBsaspace().substring(index + 1));
								vos.setBsaspace(vos.getBsaspace().substring(0, index));
							}
							else {
								vos.setBsaspace("0");
								vos.setBsaweight("0");

							}
							// Releasedteu,Releasedweight 
							if (!"".equals(vos.getReleasedteu())) {
								int index = vos.getReleasedteu().indexOf(",");
								vos.setReleasedweight(vos.getReleasedteu().substring(index + 1));
								vos.setReleasedteu(vos.getReleasedteu().substring(0, index));
							}
							else{
								vos.setReleasedteu("0");
								vos.setReleasedweight("0");
							}
							
							list1.add(vos);

						} // end if
						else {
							List<SearchMBByVesselVO> vos2 = null;
							vos2 = dbDao.searchMBByVessel02(vos.getLaneCd(), vos.getWkStDt(), vos.getWkEndDt(), vos.getFromRgn(), vos.getToRgn(), (String) arrList.get(x));
							if (vos2.size() > 0) {
								vos2.get(0).setSeq(k + "");
								vos2.get(0).setCom((String) arrList.get(x));
								vos2.get(0).setTrade(vos2.get(0).getTrdCd());
								vos2.get(0).setLane(vos2.get(0).getLaneCd());
								vos2.get(0).setRegion(vos2.get(0).getFromRgn());
								vos2.get(0).setLastport(vos2.get(0).getVpsPortCd());
								vos2.get(0).setAtd(vos2.get(0).getVpsEtdDt());
								vos2.get(0).setDatasource(vos2.get(0).getVal01());
								// BSA 
								if (!"".equals(vos2.get(0).getBsaspace())) {
									int index = vos2.get(0).getBsaspace().indexOf(",");
									vos2.get(0).setBsaweight(vos2.get(0).getBsaspace().substring(index + 1));
									vos2.get(0).setBsaspace(vos2.get(0).getBsaspace().substring(0, index));
								}
								else {
									vos2.get(0).setBsaspace("0");
									vos2.get(0).setBsaweight("0");

								}

								// Releasedteu,Releasedweight 
								if (!"".equals(vos2.get(0).getReleasedteu())) {
									int index = vos2.get(0).getReleasedteu().indexOf(",");
									vos2.get(0).setReleasedweight(vos2.get(0).getReleasedteu().substring(index + 1));
									vos2.get(0).setReleasedteu(vos2.get(0).getReleasedteu().substring(0, index));
								}
								else{
									vos2.get(0).setReleasedteu("0");
									vos2.get(0).setReleasedweight("0");
								}
								
								list1.add(vos2.get(0));
							}
						}
					} // end FOR
				} // end FOR

				// FULL(BOX) MTY(BOX) SETTING
				int outFullTotal = 0;
				int outTeuTotal = 0;
				int outEq20 = 0;
				int outEq40 = 0;
				int outEqHc = 0;
				int outEq45 = 0;
				int outBoxTotal = 0;

				int outFullBoxTeuTotal = 0;

				int inFullTotal = 0;
				int inTeuTotal = 0;
				int inEq20 = 0;
				int inEq40 = 0;
				int inEqHc = 0;
				int inEq45 = 0;
				int inBoxTotal = 0;

				int inFullBoxTeuTotal = 0;

				for (int i = 0; i < list1.size(); i++) {
					SearchMBByVesselVO vos = new SearchMBByVesselVO();
					vos = (SearchMBByVesselVO) list1.get(i);
					// calculating performance
					if (!"".equals(vos.getDatasource())) { // in case of BAY

						vos.setDatasource(vos.getVal01());
						vos.setFull20(vos.getVal02());
						vos.setFull40(vos.getVal03());
						vos.setFullHc(vos.getVal04());
						vos.setFull45(vos.getVal05());
						vos.setMty20(vos.getVal06());
						vos.setMty40(vos.getVal07());
						vos.setMtyHc(vos.getVal08());
						vos.setMty45(vos.getVal09());
						vos.setFullTotal((Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal03())
								+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05()))
								+ "");
						vos.setMtyTotal((Integer.parseInt(vos.getVal06()) + Integer.parseInt(vos.getVal07())
								+ Integer.parseInt(vos.getVal08()) + Integer.parseInt(vos.getVal09()))
								+ "");

						if ((vos.getIo()).equals("Out")) {
							outFullTotal = (Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05()));

							outFullBoxTeuTotal = (Integer.parseInt(vos.getVal02()) + 2 * (Integer.parseInt(vos
									.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05())));

							outTeuTotal = (Integer.parseInt(vos.getVal02()) + 2 * (Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05())))
									+ (Integer.parseInt(vos.getVal06()) + 2 * (Integer.parseInt(vos.getVal07())
											+ Integer.parseInt(vos.getVal08()) + Integer.parseInt(vos.getVal09())));
							outEq20 = Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal06());
							outEq40 = Integer.parseInt(vos.getVal03()) + Integer.parseInt(vos.getVal07());
							outEqHc = Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal08());
							outEq45 = Integer.parseInt(vos.getVal05()) + Integer.parseInt(vos.getVal09());
							outBoxTotal = Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05())
									+ Integer.parseInt(vos.getVal06()) + Integer.parseInt(vos.getVal07())
									+ Integer.parseInt(vos.getVal08()) + Integer.parseInt(vos.getVal09());
							vos.setVal01(outFullTotal + "");
							vos.setVal02(outTeuTotal + "");
							vos.setVal03(outEq20 + "");
							vos.setVal04(outEq40 + "");
							vos.setVal05(outEqHc + "");
							vos.setVal06(outEq45 + "");
							vos.setVal07(outBoxTotal + "");
							vos.setWeighttotal(vos.getWeighttotal()); // weightTotal

						}
						else { // if( (vos.getIo()).equals("Out") ){
							inFullTotal = (Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05()));

							inFullBoxTeuTotal = (Integer.parseInt(vos.getVal02()) + 2 * (Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05())));

							inTeuTotal = (Integer.parseInt(vos.getVal02()) + 2 * (Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05())))
									+ (Integer.parseInt(vos.getVal06()) + 2 * (Integer.parseInt(vos.getVal07())
											+ Integer.parseInt(vos.getVal08()) + Integer.parseInt(vos.getVal09())));

							inEq20 = Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal06());
							inEq40 = Integer.parseInt(vos.getVal03()) + Integer.parseInt(vos.getVal07());
							inEqHc = Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal08());
							inEq45 = Integer.parseInt(vos.getVal05()) + Integer.parseInt(vos.getVal09());
							inBoxTotal = Integer.parseInt(vos.getVal02()) + Integer.parseInt(vos.getVal03())
									+ Integer.parseInt(vos.getVal04()) + Integer.parseInt(vos.getVal05())
									+ Integer.parseInt(vos.getVal06()) + Integer.parseInt(vos.getVal07())
									+ Integer.parseInt(vos.getVal08()) + Integer.parseInt(vos.getVal09());
							vos.setVal01(inFullTotal + "");
							vos.setVal02(inTeuTotal + "");
							vos.setVal03(inEq20 + "");
							vos.setVal04(inEq40 + "");
							vos.setVal05(inEqHc + "");
							vos.setVal06(inEq45 + "");
							vos.setVal07(inBoxTotal + "");
							vos.setWeighttotal(vos.getWeighttotal()); // weightTotal
						} // end if - if( (vos.getIo()).equals("Out") ){

					}
					else {
						DBRowSet rtnRow05 = null;
						rtnRow05 = dbDao.searchLoadFactorByTradeQTY(vos.getVvd(), vos.getCom(), vos.getFromRgn(), vos
								.getClptSeq());

						if (rtnRow05.next()) {
							if ("0".equals(rtnRow05.getString("weightTotal")) && strCom.equals(vos.getCom())) {
								vos.setDatasource(rtnRow05.getString("dataSource_b"));
								vos.setFull20(rtnRow05.getString("full20Qty_b"));
								vos.setFull40(rtnRow05.getString("full40Qty_b"));
								vos.setFullHc(rtnRow05.getString("fullHcQty_b"));
								vos.setFull45(rtnRow05.getString("full45Qty_b"));
								vos.setMty20(rtnRow05.getString("mty20Qty_b"));
								vos.setMty40(rtnRow05.getString("mty40Qty_b"));
								vos.setMtyHc(rtnRow05.getString("mtyHcQty_b"));
								vos.setMty45(rtnRow05.getString("mty45Qty_b"));
								vos.setFullTotal((Integer.parseInt(rtnRow05.getString("full20Qty_b"))
										+ Integer.parseInt(rtnRow05.getString("full40Qty_b"))
										+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
										+ Integer.parseInt(rtnRow05.getString("full45Qty_b")))
										+ "");
								vos.setMtyTotal((Integer.parseInt(rtnRow05.getString("mty20Qty_b"))
										+ Integer.parseInt(rtnRow05.getString("mty40Qty_b"))
										+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b")) 
										+ Integer.parseInt(rtnRow05.getString("mty45Qty_b")))
										+ "");

								if ((vos.getIo()).equals("Out")) {

									outFullTotal = (Integer.parseInt(rtnRow05.getString("full20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b")));

									outFullBoxTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty_b")) + 2 * (Integer
											.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b"))));

									outTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty_b")) + 2 * (Integer
											.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b"))))
											+ (Integer.parseInt(rtnRow05.getString("mty20Qty_b")) 
													+ 2 * (Integer.parseInt(rtnRow05.getString("mty40Qty_b"))
													+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b")) 
													+ Integer.parseInt(rtnRow05.getString("mty45Qty_b"))));
									outEq20 = Integer.parseInt(rtnRow05.getString("full20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty20Qty_b"));
									outEq40 = Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty40Qty_b"));
									outEqHc = Integer.parseInt(rtnRow05.getString("fullHcQty_b"))
											+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b"));
									outEq45 = Integer.parseInt(rtnRow05.getString("full45Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty45Qty_b"));
									outBoxTotal = Integer.parseInt(rtnRow05.getString("full20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b"))
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty45Qty_b"));
									vos.setVal01(outFullTotal + "");
									vos.setVal02(outTeuTotal + "");
									vos.setVal03(outEq20 + "");
									vos.setVal04(outEq40 + "");
									vos.setVal05(outEqHc + "");
									vos.setVal06(outEq45 + "");
									vos.setVal07(outBoxTotal + "");
									vos.setDeadslot(rtnRow05.getString("deadSlot"));
									vos.setWeighttotal("0");
								}
								else { // if( (vos.getIo()).equals("Out") ){

									inFullTotal = (Integer.parseInt(rtnRow05.getString("full20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b")));

									inFullBoxTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty_b")) 
											+ 2 * (Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b"))));

									inTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty_b")) 
											+ 2 * (Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b"))))
											+ (Integer.parseInt(rtnRow05.getString("mty20Qty_b")) 
													+ 2 * (Integer.parseInt(rtnRow05.getString("mty40Qty_b"))
													+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b")) 
													+ Integer.parseInt(rtnRow05.getString("mty45Qty_b"))));
									inEq20 = Integer.parseInt(rtnRow05.getString("full20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty20Qty_b"));
									inEq40 = Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty40Qty_b"));
									inEqHc = Integer.parseInt(rtnRow05.getString("fullHcQty_b"))
											+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b"));
									inEq45 = Integer.parseInt(rtnRow05.getString("full45Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty45Qty_b"));
									inBoxTotal = Integer.parseInt(rtnRow05.getString("full20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("full40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty_b"))
											+ Integer.parseInt(rtnRow05.getString("full45Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty20Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty40Qty_b"))
											+ Integer.parseInt(rtnRow05.getString("mtyHcQty_b"))
											+ Integer.parseInt(rtnRow05.getString("mty45Qty_b"));
									vos.setVal01(inFullTotal + "");
									vos.setVal02(inTeuTotal + "");
									vos.setVal03(inEq20 + "");
									vos.setVal04(inEq40 + "");
									vos.setVal05(inEqHc + "");
									vos.setVal06(inEq45 + "");
									vos.setVal07(inBoxTotal + "");
									vos.setDeadslot(rtnRow05.getString("deadSlot"));
									vos.setWeighttotal("0");

								} // end if - if( (vos.getIo()).equals("Out") ){
							}
							else {
								if("0".equals(rtnRow05.getString("weightTotal"))){
									vos.setDatasource("");
									vos.setFull20("0");
									vos.setFull40("0");
									vos.setFullHc("0");
									vos.setFull45("0");
									vos.setMty20("0");
									vos.setMty40("0");
									vos.setMtyHc("0");
									vos.setMty45("0");
									vos.setFullTotal("0");
									vos.setMtyTotal("0");
	
									if ((vos.getIo()).equals("Out")) {
	
										outFullTotal = 0;
	
										outFullBoxTeuTotal = 0;
	
										outTeuTotal = 0;
										outEq20 = 0;
										outEq40 = 0;
										outEqHc = 0;
										outEq45 = 0;
										outBoxTotal = 0;
										vos.setVal01(outFullTotal + "");
										vos.setVal02(outTeuTotal + "");
										vos.setVal03(outEq20 + "");
										vos.setVal04(outEq40 + "");
										vos.setVal05(outEqHc + "");
										vos.setVal06(outEq45 + "");
										vos.setVal07(outBoxTotal + "");
										vos.setDeadslot("0");
										vos.setWeighttotal("0");
									}
									else { // if( (vos.getIo()).equals("Out") ){
	
										inFullTotal = 0;
	
										inFullBoxTeuTotal = 0;
	
										inTeuTotal = 0;
										inEq20 = 0;
										inEq40 = 0;
										inEqHc = 0;
										inEq45 = 0;
										inBoxTotal = 0;
										vos.setVal01(inFullTotal + "");
										vos.setVal02(inTeuTotal + "");
										vos.setVal03(inEq20 + "");
										vos.setVal04(inEq40 + "");
										vos.setVal05(inEqHc + "");
										vos.setVal06(inEq45 + "");
										vos.setVal07(inBoxTotal + "");
										vos.setDeadslot("0");
										vos.setWeighttotal("0");
	
									} // end if - if( (vos.getIo()).equals("Out") ){
								} // if("0".equals(rtnRow05.getString("weightTotal"))){
								else{
									vos.setDatasource(rtnRow05.getString("dataSource"));
									vos.setFull20(rtnRow05.getString("full20Qty"));
									vos.setFull40(rtnRow05.getString("full40Qty"));
									vos.setFullHc(rtnRow05.getString("fullHcQty"));
									vos.setFull45(rtnRow05.getString("full45Qty"));
									vos.setMty20(rtnRow05.getString("mty20Qty"));
									vos.setMty40(rtnRow05.getString("mty40Qty"));
									vos.setMtyHc(rtnRow05.getString("mtyHcQty"));
									vos.setMty45(rtnRow05.getString("mty45Qty"));
									vos.setFullTotal((Integer.parseInt(rtnRow05.getString("full20Qty"))
											+ Integer.parseInt(rtnRow05.getString("full40Qty"))
											+ Integer.parseInt(rtnRow05.getString("fullHcQty")) 
											+ Integer.parseInt(rtnRow05.getString("full45Qty")))
											+ "");
									vos.setMtyTotal((Integer.parseInt(rtnRow05.getString("mty20Qty"))
											+ Integer.parseInt(rtnRow05.getString("mty40Qty"))
											+ Integer.parseInt(rtnRow05.getString("mtyHcQty")) 
											+ Integer.parseInt(rtnRow05.getString("mty45Qty")))
											+ "");
	
									if ((vos.getIo()).equals("Out")) {
	
										outFullTotal = (Integer.parseInt(rtnRow05.getString("full20Qty"))
												+ Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty")) + Integer
												.parseInt(rtnRow05.getString("full45Qty")));
	
										outFullBoxTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty")) 
												+ 2 * (Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty")) + Integer
												.parseInt(rtnRow05.getString("full45Qty"))));
	
										outTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty")) 
												+ 2 * (Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty")) 
												+ Integer.parseInt(rtnRow05.getString("full45Qty"))))
												+ (Integer.parseInt(rtnRow05.getString("mty20Qty")) 
														+ 2 * (Integer.parseInt(rtnRow05.getString("mty40Qty"))
														+ Integer.parseInt(rtnRow05.getString("mtyHcQty")) 
														+ Integer.parseInt(rtnRow05.getString("mty45Qty"))));
										outEq20 = Integer.parseInt(rtnRow05.getString("full20Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty20Qty"));
										outEq40 = Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty40Qty"));
										outEqHc = Integer.parseInt(rtnRow05.getString("fullHcQty"))
												+ Integer.parseInt(rtnRow05.getString("mtyHcQty"));
										outEq45 = Integer.parseInt(rtnRow05.getString("full45Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty45Qty"));
										outBoxTotal = Integer.parseInt(rtnRow05.getString("full20Qty"))
												+ Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty"))
												+ Integer.parseInt(rtnRow05.getString("full45Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty20Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty40Qty"))
												+ Integer.parseInt(rtnRow05.getString("mtyHcQty"))
												+ Integer.parseInt(rtnRow05.getString("mty45Qty"));
										vos.setVal01(outFullTotal + "");
										vos.setVal02(outTeuTotal + "");
										vos.setVal03(outEq20 + "");
										vos.setVal04(outEq40 + "");
										vos.setVal05(outEqHc + "");
										vos.setVal06(outEq45 + "");
										vos.setVal07(outBoxTotal + "");
										vos.setDeadslot(rtnRow05.getString("deadSlot"));
										vos.setWeighttotal("0");
									}
									else { // if( (vos.getIo()).equals("Out") ){
	
										inFullTotal = (Integer.parseInt(rtnRow05.getString("full20Qty"))
												+ Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty")) 
												+ Integer.parseInt(rtnRow05.getString("full45Qty")));
	
										inFullBoxTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty")) 
												+ 2 * (Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty")) 
												+ Integer.parseInt(rtnRow05.getString("full45Qty"))));
	
										inTeuTotal = (Integer.parseInt(rtnRow05.getString("full20Qty")) 
												+ 2 * (Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty")) 
												+ Integer.parseInt(rtnRow05.getString("full45Qty"))))
												+ (Integer.parseInt(rtnRow05.getString("mty20Qty")) 
														+ 2 * (Integer.parseInt(rtnRow05.getString("mty40Qty"))
														+ Integer.parseInt(rtnRow05.getString("mtyHcQty")) 
														+ Integer.parseInt(rtnRow05.getString("mty45Qty"))));
										inEq20 = Integer.parseInt(rtnRow05.getString("full20Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty20Qty"));
										inEq40 = Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty40Qty"));
										inEqHc = Integer.parseInt(rtnRow05.getString("fullHcQty"))
												+ Integer.parseInt(rtnRow05.getString("mtyHcQty"));
										inEq45 = Integer.parseInt(rtnRow05.getString("full45Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty45Qty"));
										inBoxTotal = Integer.parseInt(rtnRow05.getString("full20Qty"))
												+ Integer.parseInt(rtnRow05.getString("full40Qty"))
												+ Integer.parseInt(rtnRow05.getString("fullHcQty"))
												+ Integer.parseInt(rtnRow05.getString("full45Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty20Qty"))
												+ Integer.parseInt(rtnRow05.getString("mty40Qty"))
												+ Integer.parseInt(rtnRow05.getString("mtyHcQty"))
												+ Integer.parseInt(rtnRow05.getString("mty45Qty"));
										vos.setVal01(inFullTotal + "");
										vos.setVal02(inTeuTotal + "");
										vos.setVal03(inEq20 + "");
										vos.setVal04(inEq40 + "");
										vos.setVal05(inEqHc + "");
										vos.setVal06(inEq45 + "");
										vos.setVal07(inBoxTotal + "");
										vos.setDeadslot(rtnRow05.getString("deadSlot"));
										vos.setWeighttotal("0");
	
									} // end if - if( (vos.getIo()).equals("Out") ){									
								}
							}
						}
						else {
							vos.setDatasource("");
							vos.setFull20("0");
							vos.setFull40("0");
							vos.setFullHc("0");
							vos.setFull45("0");
							vos.setMty20("0");
							vos.setMty40("0");
							vos.setMtyHc("0");
							vos.setMty45("0");
							vos.setFullTotal("0");
							vos.setMtyTotal("0");

							if ((vos.getIo()).equals("Out")) {

								outFullTotal = 0;
								outFullBoxTeuTotal = 0;
								outTeuTotal = 0;
								outEq20 = 0;
								outEq40 = 0;
								outEqHc = 0;
								outEq45 = 0;
								outBoxTotal = 0;
								vos.setVal01("0");
								vos.setVal02("0");
								vos.setVal03("0");
								vos.setVal04("0");
								vos.setVal05("0");
								vos.setVal06("0");
								vos.setVal07("0");
								vos.setWeighttotal("0"); // adding weightTotal
								vos.setDeadslot("0");
							}
							else { // if( (vos.getIo()).equals("Out") ){

								inFullTotal = 0;
								inFullBoxTeuTotal = 0;
								inTeuTotal = 0;
								inEq20 = 0;
								inEq40 = 0;
								inEqHc = 0;
								inEq45 = 0;
								inBoxTotal = 0;
								vos.setVal01("0");
								vos.setVal02("0");
								vos.setVal03("0");
								vos.setVal04("0");
								vos.setVal05("0");
								vos.setVal06("0");
								vos.setVal07("0");
								vos.setWeighttotal("0"); // adding weightTotal
								vos.setDeadslot("0");
							} // end if - if( (vos.getIo()).equals("Out") ){
						}

					} // end if

					// fullLf calculation logic
					if (Float.parseFloat(vos.getBsaspace()) == 0) {
						vos.setLffull("0.0");
					}
					else {
						float lfFull = (Float.parseFloat(vos.getFull20())
								+ 2
								* (Float.parseFloat(vos.getFull40()) + Float.parseFloat(vos.getFullHc()) + Float
										.parseFloat(vos.getFull45())) + Float.parseFloat(vos.getDeadslot()))
								/ (Float.parseFloat(vos.getBsaspace()) + Float.parseFloat(vos.getReleasedteu())) * 100;

						BigDecimal blfFull = new BigDecimal(lfFull);

						vos.setLffull(String.valueOf(blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()));
					}

					// LF_EQ calculation logic
					if (Float.parseFloat(vos.getBsaspace()) == 0) {
						vos.setLfeq("0.0");
					}
					else {
						float teuTotal = (Float.parseFloat(vos.getFull20())
								+ 2
								* (Float.parseFloat(vos.getFull40()) + Float.parseFloat(vos.getFullHc()) 
										+ Float.parseFloat(vos.getFull45())) 
										+ Float.parseFloat(vos.getMty20()) + 2 * (Float.parseFloat(vos.getMty40())
								+ Float.parseFloat(vos.getMtyHc()) + Float.parseFloat(vos.getMty45())));

						float lfEq = ((teuTotal + Integer.parseInt(vos.getDeadslot())) / 
								(Float.parseFloat(vos.getBsaspace()) + Float.parseFloat(vos.getReleasedteu()))) * 100;

						BigDecimal blfEq = new BigDecimal(lfEq);

						vos.setLfeq(String.valueOf(blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()));

					}

					// LF_WGT
					if (Float.parseFloat(vos.getBsaweight()) == 0) {
						vos.setLfwgt("0.0");
					}
					else {
						float lfWgt = (Float.parseFloat(vos.getWeighttotal()) / (Float.parseFloat(vos.getBsaweight()) 
								+ Float.parseFloat(vos.getReleasedweight()))) * 100;

						BigDecimal blfWgt = new BigDecimal(lfWgt);
						vos.setLfwgt(String.valueOf(blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()));

					}

					// TEU M/BACK EQ M/BACK SETTING

					/*
					 * 
					 * TEU Total : calculation logic = Full TEU Sum { 20’+ 2 ( 40’+ H/C’+
					 * 45’) } + MTY TEU Sum { 20’+ 2 ( 40’+ H/C’+ 45’) }
					 * 
					 * converting 40ft into TEU (40ft(40’/ HC/ 45’)x2), using below logic
					 * Full = If (
					 * Full I/B vol > Full O/B vol , + Full O/B ÷ Full I/B , -
					 * Full I/B ÷ Full O/B ) EQ = If ( Full & MTY I/B vol > Full
					 * & MTY O/B vol , + Full & MTY O/B ÷ Full & MTY I/B , -
					 * Full & MTY I/B ÷ Full & MTY O/B )
					 */

					if ((vos.getIo()).equals("In")) {
						vos.setTeuFull(calcRationFloat(inFullBoxTeuTotal, outFullBoxTeuTotal));
						// vos.setTeuFull( "");
						vos.setTeuEq(calcRationFloat(inTeuTotal, outTeuTotal));
						vos.setEq20(calcRationFloat(inEq20, outEq20));
						vos.setEq40(calcRationFloat(inEq40, outEq40));
						vos.setEqHc(calcRationFloat(inEqHc, outEqHc));
						vos.setEq45(calcRationFloat(inEq45, outEq45));
						vos.setEqTotal(calcRationFloat(inBoxTotal, outBoxTotal));

						SearchMBByVesselVO vosBe4 = new SearchMBByVesselVO();
						vosBe4 = (SearchMBByVesselVO) list1.get(i - 1);
						vosBe4.setTeuFull(calcRationFloat(inFullBoxTeuTotal, outFullBoxTeuTotal));
						// vosBe4.setTeuFull( "");
						vosBe4.setTeuEq(calcRationFloat(inTeuTotal, outTeuTotal));
						vosBe4.setEq20(calcRationFloat(inEq20, outEq20));
						vosBe4.setEq40(calcRationFloat(inEq40, outEq40));
						vosBe4.setEqHc(calcRationFloat(inEqHc, outEqHc));
						vosBe4.setEq45(calcRationFloat(inEq45, outEq45));
						vosBe4.setEqTotal(calcRationFloat(inBoxTotal, outBoxTotal));

					} // end if - if( (vos.getIo()).equals("In") ){

				} // end for

				// S.Total G.Total
				String xTCompany = "";
				String xTTrade = "";

				double[] innQtyS = new double[26];
				double[] outQtyS = new double[26];

				double[] innQtyG = new double[26];
				double[] outQtyG = new double[26];

				int m = 0;
				for (int i = 0; i < list1.size(); i++) {
					SearchMBByVesselVO vos = new SearchMBByVesselVO();
					vos = (SearchMBByVesselVO) list1.get(i);

					String xTIO = vos.getIo();
					String zTCompany = vos.getCom();
					String zTTrade = vos.getTrade();
					
					// calculating sub total by Company,Tread
					if ((zTCompany.equals(xTCompany) && zTTrade.equals(xTTrade)) || i == 0) {

						vo = new SearchMBByVesselVO();
						vo.setSeq(vos.getSeq());
						vo.setCom(vos.getCom());
						vo.setTrade(vos.getTrade());
						vo.setLane(vos.getLane());
						vo.setIo(vos.getIo());
						vo.setRegion(vos.getRegion());
						vo.setVvd(vos.getVvd());
						vo.setLastport(vos.getLastport());
						vo.setAtd(vos.getAtd());
						vo.setWeek(vos.getWeek());
						vo.setFull20(vos.getFull20());
						vo.setFull40(vos.getFull40());
						vo.setFullHc(vos.getFullHc());
						vo.setFull45(vos.getFull45());
						vo.setFullTotal(vos.getFullTotal());
						vo.setMty20(vos.getMty20());
						vo.setMty40(vos.getMty40());
						vo.setMtyHc(vos.getMtyHc());
						vo.setMty45(vos.getMty45());
						vo.setMtyTotal(vos.getMtyTotal());
						// vo.setBoxTotal(vos.getBoxTotal());
						// vo.setTeuTotal(vos.getTeuTotal());
						vo.setTeuFull(vos.getTeuFull());
						vo.setTeuEq(vos.getTeuEq());
						vo.setEq20(vos.getEq20());
						vo.setEq40(vos.getEq40());
						vo.setEqHc(vos.getEqHc());
						vo.setEq45(vos.getEq45());
						vo.setEqTotal(vos.getEqTotal());
						vo.setDatasource(vos.getDatasource());
						vo.setLffull(vos.getLffull());
						vo.setLfeq(vos.getLfeq());
						vo.setLfwgt(vos.getLfwgt());
						vo.setWeighttotal(vos.getWeighttotal()); // adding weightTotal
						vo.setDeadslot(vos.getDeadslot()); // deadSlot
						vo.setBsaspace(vos.getBsaspace());
						vo.setBsaweight(vos.getBsaweight());
						vo.setReleasedteu(vos.getReleasedteu());
						vo.setReleasedweight(vos.getReleasedweight());

						list2.add(m, vo);
						m++;

						if (xTIO.equals("Out")) {

							outQtyS[0] = Double.parseDouble(vos.getFull20()) + outQtyS[0];
							outQtyS[1] = Double.parseDouble(vos.getFull40()) + outQtyS[1];
							outQtyS[2] = Double.parseDouble(vos.getFullHc()) + outQtyS[2];
							outQtyS[3] = Double.parseDouble(vos.getFull45()) + outQtyS[3];
							outQtyS[4] = Double.parseDouble(vos.getFullTotal()) + outQtyS[4];
							outQtyS[5] = Double.parseDouble(vos.getMty20()) + outQtyS[5];
							outQtyS[6] = Double.parseDouble(vos.getMty40()) + outQtyS[6];
							outQtyS[7] = Double.parseDouble(vos.getMtyHc()) + outQtyS[7];
							outQtyS[8] = Double.parseDouble(vos.getMty45()) + outQtyS[8];
							outQtyS[9] = Double.parseDouble(vos.getMtyTotal()) + outQtyS[9];
							outQtyS[10] = (Double.parseDouble(vos.getVal01()) - Double.parseDouble(vos.getFull20()))
									* 2 + Double.parseDouble(vos.getFull20()) + outQtyS[10];
							outQtyS[11] = Double.parseDouble(vos.getVal02()) + outQtyS[11];
							outQtyS[12] = Double.parseDouble(vos.getVal03()) + outQtyS[12];
							outQtyS[13] = Double.parseDouble(vos.getVal04()) + outQtyS[13];
							outQtyS[14] = Double.parseDouble(vos.getVal05()) + outQtyS[14];
							outQtyS[15] = Double.parseDouble(vos.getVal06()) + outQtyS[15];
							outQtyS[16] = Double.parseDouble(vos.getVal07()) + outQtyS[16];

							outQtyS[17] = Double.parseDouble(vos.getDeadslot()) + outQtyS[17];
							outQtyS[18] = Double.parseDouble(vos.getWeighttotal()) + outQtyS[18];
							outQtyS[19] = Double.parseDouble(vos.getReleasedteu()) + outQtyS[19];
							outQtyS[20] = Double.parseDouble(vos.getReleasedweight()) + outQtyS[20];
							outQtyS[21] = Double.parseDouble(vos.getBsaspace()) + outQtyS[21];
							outQtyS[22] = Double.parseDouble(vos.getBsaweight()) + outQtyS[22];
							if (outQtyS[21] != 0.0) {
								double lfFull = ((outQtyS[0] + 2 * (outQtyS[1] + outQtyS[2] + outQtyS[3]) + outQtyS[17]) / (outQtyS[21] + outQtyS[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								outQtyS[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								outQtyS[23] = Double.parseDouble("0.0");
							}

							if (outQtyS[21] == 0.0) {
								outQtyS[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (outQtyS[0] + 2 * (outQtyS[1] + outQtyS[2] + outQtyS[3]) + outQtyS[5] + 2 * (outQtyS[6]
										+ outQtyS[7] + outQtyS[8]));

								double lfEq = ((teuTotal + outQtyS[17]) / (outQtyS[21] + outQtyS[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								outQtyS[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (outQtyS[22] == 0.0) {
								outQtyS[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (outQtyS[18] / (outQtyS[22] + outQtyS[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								outQtyS[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

							outQtyG[0] = Double.parseDouble(vos.getFull20()) + outQtyG[0];
							outQtyG[1] = Double.parseDouble(vos.getFull40()) + outQtyG[1];
							outQtyG[2] = Double.parseDouble(vos.getFullHc()) + outQtyG[2];
							outQtyG[3] = Double.parseDouble(vos.getFull45()) + outQtyG[3];
							outQtyG[4] = Double.parseDouble(vos.getFullTotal()) + outQtyG[4];
							outQtyG[5] = Double.parseDouble(vos.getMty20()) + outQtyG[5];
							outQtyG[6] = Double.parseDouble(vos.getMty40()) + outQtyG[6];
							outQtyG[7] = Double.parseDouble(vos.getMtyHc()) + outQtyG[7];
							outQtyG[8] = Double.parseDouble(vos.getMty45()) + outQtyG[8];
							outQtyG[9] = Double.parseDouble(vos.getMtyTotal()) + outQtyG[9];
							outQtyG[10] = Double.parseDouble(vos.getVal01()) + outQtyG[10];
							outQtyG[11] = Double.parseDouble(vos.getVal02()) + outQtyG[11];
							outQtyG[12] = Double.parseDouble(vos.getVal03()) + outQtyG[12];
							outQtyG[13] = Double.parseDouble(vos.getVal04()) + outQtyG[13];
							outQtyG[14] = Double.parseDouble(vos.getVal05()) + outQtyG[14];
							outQtyG[15] = Double.parseDouble(vos.getVal06()) + outQtyG[15];
							outQtyG[16] = Double.parseDouble(vos.getVal07()) + outQtyG[16];

							outQtyG[17] = Double.parseDouble(vos.getDeadslot()) + outQtyG[17];
							outQtyG[18] = Double.parseDouble(vos.getWeighttotal()) + outQtyG[18];
							outQtyG[19] = Double.parseDouble(vos.getReleasedteu()) + outQtyG[19];
							outQtyG[20] = Double.parseDouble(vos.getReleasedweight()) + outQtyG[20];
							outQtyG[21] = Double.parseDouble(vos.getBsaspace()) + outQtyG[21];
							outQtyG[22] = Double.parseDouble(vos.getBsaweight()) + outQtyG[22];
							if (outQtyG[21] != 0.0) {
								double lfFull = ((outQtyG[0] + 2 * (outQtyG[1] + outQtyG[2] + outQtyG[3]) + outQtyG[17]) / (outQtyG[21] + outQtyG[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								outQtyG[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								outQtyG[23] = Double.parseDouble("0.0");
							}

							if (outQtyG[21] == 0.0) {
								outQtyG[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (outQtyG[0] + 2 * (outQtyG[1] + outQtyG[2] + outQtyG[3]) + outQtyG[5] + 2 * (outQtyG[6]
										+ outQtyG[7] + outQtyG[8]));

								double lfEq = ((teuTotal + outQtyG[17]) / (outQtyG[21] + outQtyG[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								outQtyG[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (outQtyG[22] == 0.0) {
								outQtyG[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (outQtyG[18] / (outQtyG[22] + outQtyG[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								outQtyG[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
						}
						else {

							innQtyS[0] = Double.parseDouble(vos.getFull20()) + innQtyS[0];
							innQtyS[1] = Double.parseDouble(vos.getFull40()) + innQtyS[1];
							innQtyS[2] = Double.parseDouble(vos.getFullHc()) + innQtyS[2];
							innQtyS[3] = Double.parseDouble(vos.getFull45()) + innQtyS[3];
							innQtyS[4] = Double.parseDouble(vos.getFullTotal()) + innQtyS[4];
							innQtyS[5] = Double.parseDouble(vos.getMty20()) + innQtyS[5];
							innQtyS[6] = Double.parseDouble(vos.getMty40()) + innQtyS[6];
							innQtyS[7] = Double.parseDouble(vos.getMtyHc()) + innQtyS[7];
							innQtyS[8] = Double.parseDouble(vos.getMty45()) + innQtyS[8];
							innQtyS[9] = Double.parseDouble(vos.getMtyTotal()) + innQtyS[9];
							innQtyS[10] = (Double.parseDouble(vos.getVal01()) - Double.parseDouble(vos.getFull20()))
									* 2 + Double.parseDouble(vos.getFull20()) + innQtyS[10];
							innQtyS[11] = Double.parseDouble(vos.getVal02()) + innQtyS[11];
							innQtyS[12] = Double.parseDouble(vos.getVal03()) + innQtyS[12];
							innQtyS[13] = Double.parseDouble(vos.getVal04()) + innQtyS[13];
							innQtyS[14] = Double.parseDouble(vos.getVal05()) + innQtyS[14];
							innQtyS[15] = Double.parseDouble(vos.getVal06()) + innQtyS[15];
							innQtyS[16] = Double.parseDouble(vos.getVal07()) + innQtyS[16];
							innQtyS[17] = Double.parseDouble(vos.getDeadslot()) + innQtyS[17];
							innQtyS[18] = Double.parseDouble(vos.getWeighttotal()) + innQtyS[18];
							innQtyS[19] = Double.parseDouble(vos.getReleasedteu()) + innQtyS[19];
							innQtyS[20] = Double.parseDouble(vos.getReleasedweight()) + innQtyS[20];
							innQtyS[21] = Double.parseDouble(vos.getBsaspace()) + innQtyS[21];
							innQtyS[22] = Double.parseDouble(vos.getBsaweight()) + innQtyS[22];
							if (innQtyS[21] != 0.0) {
								double lfFull = ((innQtyS[0] + 2 * (innQtyS[1] + innQtyS[2] + innQtyS[3]) + innQtyS[17]) / (innQtyS[21] + innQtyS[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								innQtyS[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								innQtyS[23] = Double.parseDouble("0.0");
							}

							if (innQtyS[21] == 0.0) {
								innQtyS[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (innQtyS[0] + 2 * (innQtyS[1] + innQtyS[2] + innQtyS[3]) + innQtyS[5] + 2 * (innQtyS[6]
										+ innQtyS[7] + innQtyS[8]));

								double lfEq = ((teuTotal + innQtyS[17]) / (innQtyS[21] + innQtyS[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								innQtyS[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (innQtyS[22] == 0.0) {
								innQtyS[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (innQtyS[18] / (innQtyS[22] + innQtyS[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								innQtyS[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

							innQtyG[0] = Double.parseDouble(vos.getFull20()) + innQtyG[0];
							innQtyG[1] = Double.parseDouble(vos.getFull40()) + innQtyG[1];
							innQtyG[2] = Double.parseDouble(vos.getFullHc()) + innQtyG[2];
							innQtyG[3] = Double.parseDouble(vos.getFull45()) + innQtyG[3];
							innQtyG[4] = Double.parseDouble(vos.getFullTotal()) + innQtyG[4];
							innQtyG[5] = Double.parseDouble(vos.getMty20()) + innQtyG[5];
							innQtyG[6] = Double.parseDouble(vos.getMty40()) + innQtyG[6];
							innQtyG[7] = Double.parseDouble(vos.getMtyHc()) + innQtyG[7];
							innQtyG[8] = Double.parseDouble(vos.getMty45()) + innQtyG[8];
							innQtyG[9] = Double.parseDouble(vos.getMtyTotal()) + innQtyG[9];
							innQtyG[10] = Double.parseDouble(vos.getVal01()) + innQtyG[10];
							innQtyG[11] = Double.parseDouble(vos.getVal02()) + innQtyG[11];
							innQtyG[12] = Double.parseDouble(vos.getVal03()) + innQtyG[12];
							innQtyG[13] = Double.parseDouble(vos.getVal04()) + innQtyG[13];
							innQtyG[14] = Double.parseDouble(vos.getVal05()) + innQtyG[14];
							innQtyG[15] = Double.parseDouble(vos.getVal06()) + innQtyG[15];
							innQtyG[16] = Double.parseDouble(vos.getVal07()) + innQtyG[16];
							innQtyG[17] = Double.parseDouble(vos.getDeadslot()) + innQtyG[17];
							innQtyG[18] = Double.parseDouble(vos.getWeighttotal()) + innQtyG[18];
							innQtyG[19] = Double.parseDouble(vos.getReleasedteu()) + innQtyG[19];
							innQtyG[20] = Double.parseDouble(vos.getReleasedweight()) + innQtyG[20];
							innQtyG[21] = Double.parseDouble(vos.getBsaspace()) + innQtyG[21];
							innQtyG[22] = Double.parseDouble(vos.getBsaweight()) + innQtyG[22];
							if (innQtyG[21] != 0.0) {
								double lfFull = ((innQtyG[0] + 2 * (innQtyG[1] + innQtyG[2] + innQtyG[3]) + innQtyG[17]) / (innQtyG[21] + innQtyG[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								innQtyG[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								innQtyG[23] = Double.parseDouble("0.0");
							}

							if (innQtyG[21] == 0.0) {
								innQtyG[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (innQtyG[0] + 2 * (innQtyG[1] + innQtyG[2] + innQtyG[3]) + innQtyG[5] + 2 * (innQtyG[6]
										+ innQtyG[7] + innQtyG[8]));

								double lfEq = ((teuTotal + innQtyG[17]) / (innQtyG[21] + innQtyG[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								innQtyG[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (innQtyG[22] == 0.0) {
								innQtyG[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (innQtyG[18] / (innQtyG[22] + innQtyG[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								innQtyG[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

						}
						xTTrade = zTTrade;

					}
					else { // if( ( zTCompany.equals(xTCompany) && zTTrade.equals(xTTrade) ) || i == 0 ){

						vo = new SearchMBByVesselVO();
						vo.setSeq(" ");
						vo.setCom("Total");
						vo.setTrade("");
						vo.setLane("");
						vo.setIo("Out");
						vo.setRegion("");
						vo.setVvd("");
						vo.setLastport("");
						vo.setAtd("");
						vo.setWeek("");
						vo.setFull20(outQtyS[0] + "");
						vo.setFull40(outQtyS[1] + "");
						vo.setFullHc(outQtyS[2] + "");
						vo.setFull45(outQtyS[3] + "");
						vo.setFullTotal(outQtyS[4] + "");
						vo.setMty20(outQtyS[5] + "");
						vo.setMty40(outQtyS[6] + "");
						vo.setMtyHc(outQtyS[7] + "");
						vo.setMty45(outQtyS[8] + "");
						vo.setMtyTotal(outQtyS[9] + "");
						// vo.setBoxTotal(vos.getBoxTotal());
						// vo.setTeuTotal(vos.getTeuTotal());
						vo.setTeuFull(calcRationFloat(innQtyS[10], outQtyS[10]));
						vo.setTeuEq(calcRationFloat(innQtyS[11], outQtyS[11]));
						vo.setEq20(calcRationFloat(innQtyS[12], outQtyS[12]));
						vo.setEq40(calcRationFloat(innQtyS[13], outQtyS[13]));
						vo.setEqHc(calcRationFloat(innQtyS[14], outQtyS[14]));
						vo.setEq45(calcRationFloat(innQtyS[15], outQtyS[15]));
						vo.setEqTotal(calcRationFloat(innQtyS[16], outQtyS[16]));
						vo.setDatasource("");
						vo.setLffull(outQtyS[23] + "");
						vo.setLfeq(outQtyS[24] + "");
						vo.setLfwgt(outQtyS[25] + "");
						vo.setWeighttotal(outQtyS[18] + ""); // weightTotal
						vo.setDeadslot(outQtyS[17] + ""); // deadSlot
						vo.setBsaspace(outQtyS[21] + "");
						vo.setBsaweight(outQtyS[22] + "");
						vo.setReleasedteu(outQtyS[19] + "");
						vo.setReleasedweight(outQtyS[20] + "");

						list2.add(m, vo);
						m++;

						vo = new SearchMBByVesselVO();
						vo.setSeq(" ");
						vo.setCom("");
						vo.setTrade("");
						vo.setLane("");
						vo.setIo("In");
						vo.setRegion("");
						vo.setVvd("");
						vo.setLastport("");
						vo.setAtd("");
						vo.setWeek("");
						vo.setFull20(innQtyS[0] + "");
						vo.setFull40(innQtyS[1] + "");
						vo.setFullHc(innQtyS[2] + "");
						vo.setFull45(innQtyS[3] + "");
						vo.setFullTotal(innQtyS[4] + "");
						vo.setMty20(innQtyS[5] + "");
						vo.setMty40(innQtyS[6] + "");
						vo.setMtyHc(innQtyS[7] + "");
						vo.setMty45(innQtyS[8] + "");
						vo.setMtyTotal(innQtyS[9] + "");
						// vo.setBoxTotal(vos.getBoxTotal());
						// vo.setTeuTotal(vos.getTeuTotal());
						vo.setTeuFull(calcRationFloat(innQtyS[10], outQtyS[10]));
						vo.setTeuEq(calcRationFloat(innQtyS[11], outQtyS[11]));
						vo.setEq20(calcRationFloat(innQtyS[12], outQtyS[12]));
						vo.setEq40(calcRationFloat(innQtyS[13], outQtyS[13]));
						vo.setEqHc(calcRationFloat(innQtyS[14], outQtyS[14]));
						vo.setEq45(calcRationFloat(innQtyS[15], outQtyS[15]));
						vo.setEqTotal(calcRationFloat(innQtyS[16], outQtyS[16]));
						vo.setDatasource("");

						vo.setLffull(innQtyS[23] + "");
						vo.setLfeq(innQtyS[24] + "");
						vo.setLfwgt(innQtyS[25] + "");
						vo.setWeighttotal(innQtyS[18] + ""); // weightTotal
						vo.setDeadslot(innQtyS[17] + ""); // deadSlot
						vo.setBsaspace(innQtyS[21] + "");
						vo.setBsaweight(innQtyS[22] + "");
						vo.setReleasedteu(innQtyS[19] + "");
						vo.setReleasedweight(innQtyS[20] + "");

						vo.setDatasource("");
						list2.add(m, vo);
						m++;

						outQtyS[0] = 0;
						innQtyS[0] = 0;
						outQtyS[1] = 0;
						innQtyS[1] = 0;
						outQtyS[2] = 0;
						innQtyS[2] = 0;
						outQtyS[3] = 0;
						innQtyS[3] = 0;
						outQtyS[4] = 0;
						innQtyS[4] = 0;
						outQtyS[5] = 0;
						innQtyS[5] = 0;
						outQtyS[6] = 0;
						innQtyS[6] = 0;
						outQtyS[7] = 0;
						innQtyS[7] = 0;
						outQtyS[8] = 0;
						innQtyS[8] = 0;
						outQtyS[9] = 0;
						innQtyS[9] = 0;
						outQtyS[10] = 0;
						innQtyS[10] = 0;
						outQtyS[11] = 0;
						innQtyS[11] = 0;
						outQtyS[12] = 0;
						innQtyS[12] = 0;
						outQtyS[13] = 0;
						innQtyS[13] = 0;
						outQtyS[14] = 0;
						innQtyS[14] = 0;
						outQtyS[15] = 0;
						innQtyS[15] = 0;
						outQtyS[16] = 0;
						innQtyS[16] = 0;
						outQtyS[17] = 0;
						innQtyS[17] = 0;
						outQtyS[18] = 0;
						innQtyS[18] = 0;
						outQtyS[19] = 0;
						innQtyS[19] = 0;
						outQtyS[20] = 0;
						innQtyS[20] = 0;
						outQtyS[21] = 0;
						innQtyS[21] = 0;
						outQtyS[22] = 0;
						innQtyS[22] = 0;
						outQtyS[23] = 0;
						innQtyS[23] = 0;
						outQtyS[24] = 0;
						innQtyS[24] = 0;
						outQtyS[25] = 0;
						innQtyS[25] = 0;

						vo = new SearchMBByVesselVO();
						vo.setSeq(vos.getSeq());
						vo.setCom(vos.getCom());
						vo.setTrade(vos.getTrade());
						vo.setLane(vos.getLane());
						vo.setIo(vos.getIo());
						vo.setRegion(vos.getRegion());
						vo.setVvd(vos.getVvd());
						vo.setLastport(vos.getLastport());
						vo.setAtd(vos.getAtd());
						vo.setWeek(vos.getWeek());
						vo.setFull20(vos.getFull20());
						vo.setFull40(vos.getFull40());
						vo.setFullHc(vos.getFullHc());
						vo.setFull45(vos.getFull45());
						vo.setFullTotal(vos.getFullTotal());
						vo.setMty20(vos.getMty20());
						vo.setMty40(vos.getMty40());
						vo.setMtyHc(vos.getMtyHc());
						vo.setMty45(vos.getMty45());
						vo.setMtyTotal(vos.getMtyTotal());
						// vo.setBoxTotal(vos.getBoxTotal());
						// vo.setTeuTotal(vos.getTeuTotal());
						vo.setTeuFull(vos.getTeuFull());
						vo.setTeuEq(vos.getTeuEq());
						vo.setEq20(vos.getEq20());
						vo.setEq40(vos.getEq40());
						vo.setEqHc(vos.getEqHc());
						vo.setEq45(vos.getEq45());
						vo.setEqTotal(vos.getEqTotal());
						vo.setDatasource(vos.getDatasource());
						vo.setLffull(vos.getLffull());
						vo.setLfeq(vos.getLfeq());
						vo.setLfwgt(vos.getLfwgt());
						vo.setWeighttotal(vos.getWeighttotal()); // weightTotal
						vo.setDeadslot(vos.getDeadslot()); // deadSlot
						vo.setBsaspace(vos.getBsaspace());
						vo.setBsaweight(vos.getBsaweight());
						vo.setReleasedteu(vos.getReleasedteu());
						vo.setReleasedweight(vos.getReleasedweight());

						list2.add(m, vo);
						m++;

						if ((vos.getIo()).equals("Out")) {

							outQtyS[0] = Double.parseDouble(vos.getFull20()) + outQtyS[0];
							outQtyS[1] = Double.parseDouble(vos.getFull40()) + outQtyS[1];
							outQtyS[2] = Double.parseDouble(vos.getFullHc()) + outQtyS[2];
							outQtyS[3] = Double.parseDouble(vos.getFull45()) + outQtyS[3];
							outQtyS[4] = Double.parseDouble(vos.getFullTotal()) + outQtyS[4];
							outQtyS[5] = Double.parseDouble(vos.getMty20()) + outQtyS[5];
							outQtyS[6] = Double.parseDouble(vos.getMty40()) + outQtyS[6];
							outQtyS[7] = Double.parseDouble(vos.getMtyHc()) + outQtyS[7];
							outQtyS[8] = Double.parseDouble(vos.getMty45()) + outQtyS[8];
							outQtyS[9] = Double.parseDouble(vos.getMtyTotal()) + outQtyS[9];
							outQtyS[10] = (Double.parseDouble(vos.getVal01()) - Double.parseDouble(vos.getFull20()))
									* 2 + Double.parseDouble(vos.getFull20()) + outQtyS[10];
							outQtyS[11] = Double.parseDouble(vos.getVal02()) + outQtyS[11];
							outQtyS[12] = Double.parseDouble(vos.getVal03()) + outQtyS[12];
							outQtyS[13] = Double.parseDouble(vos.getVal04()) + outQtyS[13];
							outQtyS[14] = Double.parseDouble(vos.getVal05()) + outQtyS[14];
							outQtyS[15] = Double.parseDouble(vos.getVal06()) + outQtyS[15];
							outQtyS[16] = Double.parseDouble(vos.getVal07()) + outQtyS[16];
							outQtyS[17] = Double.parseDouble(vos.getDeadslot()) + outQtyS[17];
							outQtyS[18] = Double.parseDouble(vos.getWeighttotal()) + outQtyS[18];
							outQtyS[19] = Double.parseDouble(vos.getReleasedteu()) + outQtyS[19];
							outQtyS[20] = Double.parseDouble(vos.getReleasedweight()) + outQtyS[20];
							outQtyS[21] = Double.parseDouble(vos.getBsaspace()) + outQtyS[21];
							outQtyS[22] = Double.parseDouble(vos.getBsaweight()) + outQtyS[22];
							if (outQtyS[21] != 0.0) {
								double lfFull = ((outQtyS[0] + 2 * (outQtyS[1] + outQtyS[2] + outQtyS[3]) + outQtyS[17]) / (outQtyS[21] + outQtyS[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								outQtyS[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								outQtyS[23] = Double.parseDouble("0.0");
							}

							if (outQtyS[21] == 0.0) {
								outQtyS[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (outQtyS[0] + 2 * (outQtyS[1] + outQtyS[2] + outQtyS[3]) + outQtyS[5] + 2 * (outQtyS[6]
										+ outQtyS[7] + outQtyS[8]));

								double lfEq = ((teuTotal + outQtyS[17]) / (outQtyS[21] + outQtyS[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								outQtyS[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (outQtyS[22] == 0.0) {
								outQtyS[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (outQtyS[18] / (outQtyS[22] + outQtyS[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								outQtyS[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

							outQtyG[0] = Double.parseDouble(vos.getFull20()) + outQtyG[0];
							outQtyG[1] = Double.parseDouble(vos.getFull40()) + outQtyG[1];
							outQtyG[2] = Double.parseDouble(vos.getFullHc()) + outQtyG[2];
							outQtyG[3] = Double.parseDouble(vos.getFull45()) + outQtyG[3];
							outQtyG[4] = Double.parseDouble(vos.getFullTotal()) + outQtyG[4];
							outQtyG[5] = Double.parseDouble(vos.getMty20()) + outQtyG[5];
							outQtyG[6] = Double.parseDouble(vos.getMty40()) + outQtyG[6];
							outQtyG[7] = Double.parseDouble(vos.getMtyHc()) + outQtyG[7];
							outQtyG[8] = Double.parseDouble(vos.getMty45()) + outQtyG[8];
							outQtyG[9] = Double.parseDouble(vos.getMtyTotal()) + outQtyG[9];
							outQtyG[10] = Double.parseDouble(vos.getVal01()) + outQtyG[10];
							outQtyG[11] = Double.parseDouble(vos.getVal02()) + outQtyG[11];
							outQtyG[12] = Double.parseDouble(vos.getVal03()) + outQtyG[12];
							outQtyG[13] = Double.parseDouble(vos.getVal04()) + outQtyG[13];
							outQtyG[14] = Double.parseDouble(vos.getVal05()) + outQtyG[14];
							outQtyG[15] = Double.parseDouble(vos.getVal06()) + outQtyG[15];
							outQtyG[16] = Double.parseDouble(vos.getVal07()) + outQtyG[16];
							outQtyG[17] = Double.parseDouble(vos.getDeadslot()) + outQtyG[17];
							outQtyG[18] = Double.parseDouble(vos.getWeighttotal()) + outQtyG[18];
							outQtyG[19] = Double.parseDouble(vos.getReleasedteu()) + outQtyG[19];
							outQtyG[20] = Double.parseDouble(vos.getReleasedweight()) + outQtyG[20];
							outQtyG[21] = Double.parseDouble(vos.getBsaspace()) + outQtyG[21];
							outQtyG[22] = Double.parseDouble(vos.getBsaweight()) + outQtyG[22];
							if (outQtyG[21] != 0.0) {
								double lfFull = ((outQtyG[0] + 2 * (outQtyG[1] + outQtyG[2] + outQtyG[3]) + outQtyG[17]) / (outQtyG[21] + outQtyG[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								outQtyG[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								outQtyG[23] = Double.parseDouble("0.0");
							}

							if (outQtyG[21] == 0.0) {
								outQtyG[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (outQtyG[0] + 2 * (outQtyG[1] + outQtyG[2] + outQtyG[3]) + outQtyG[5] + 2 * (outQtyG[6]
										+ outQtyG[7] + outQtyG[8]));

								double lfEq = ((teuTotal + outQtyG[17]) / (outQtyG[21] + outQtyG[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								outQtyG[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (outQtyG[22] == 0.0) {// error in case of 0.0 
								outQtyG[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (outQtyG[18] / (outQtyG[22] + outQtyG[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								outQtyG[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

						}
						else {

							innQtyS[0] = Double.parseDouble(vos.getFull20()) + innQtyS[0];
							innQtyS[1] = Double.parseDouble(vos.getFull40()) + innQtyS[1];
							innQtyS[2] = Double.parseDouble(vos.getFullHc()) + innQtyS[2];
							innQtyS[3] = Double.parseDouble(vos.getFull45()) + innQtyS[3];
							innQtyS[4] = Double.parseDouble(vos.getFullTotal()) + innQtyS[4];
							innQtyS[5] = Double.parseDouble(vos.getMty20()) + innQtyS[5];
							innQtyS[6] = Double.parseDouble(vos.getMty40()) + innQtyS[6];
							innQtyS[7] = Double.parseDouble(vos.getMtyHc()) + innQtyS[7];
							innQtyS[8] = Double.parseDouble(vos.getMty45()) + innQtyS[8];
							innQtyS[9] = Double.parseDouble(vos.getMtyTotal()) + innQtyS[9];
							innQtyS[10] = (Double.parseDouble(vos.getVal01()) - Double.parseDouble(vos.getFull20()))
									* 2 + Double.parseDouble(vos.getFull20()) + innQtyS[10];
							innQtyS[11] = Double.parseDouble(vos.getVal02()) + innQtyS[11];
							innQtyS[12] = Double.parseDouble(vos.getVal03()) + innQtyS[12];
							innQtyS[13] = Double.parseDouble(vos.getVal04()) + innQtyS[13];
							innQtyS[14] = Double.parseDouble(vos.getVal05()) + innQtyS[14];
							innQtyS[15] = Double.parseDouble(vos.getVal06()) + innQtyS[15];
							innQtyS[16] = Double.parseDouble(vos.getVal07()) + innQtyS[16];
							innQtyS[17] = Double.parseDouble(vos.getDeadslot()) + innQtyS[17];
							innQtyS[18] = Double.parseDouble(vos.getWeighttotal()) + innQtyS[18];
							innQtyS[19] = Double.parseDouble(vos.getReleasedteu()) + innQtyS[19];
							innQtyS[20] = Double.parseDouble(vos.getReleasedweight()) + innQtyS[20];
							innQtyS[21] = Double.parseDouble(vos.getBsaspace()) + innQtyS[21];
							innQtyS[22] = Double.parseDouble(vos.getBsaweight()) + innQtyS[22];
							if (innQtyS[21] != 0.0) {
								double lfFull = ((innQtyS[0] + 2 * (innQtyS[1] + innQtyS[2] + innQtyS[3]) + innQtyS[17]) / (innQtyS[21] + innQtyS[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								innQtyS[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								innQtyS[23] = Double.parseDouble("0.0");
							}

							if (innQtyS[21] == 0.0) {
								innQtyS[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (innQtyS[0] + 2 * (innQtyS[1] + innQtyS[2] + innQtyS[3]) + innQtyS[5] + 2 * (innQtyS[6]
										+ innQtyS[7] + innQtyS[8]));

								double lfEq = ((teuTotal + innQtyS[17]) / (innQtyS[21] + innQtyS[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								innQtyS[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (innQtyS[22] == 0.0) {
								innQtyS[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (innQtyS[18] / (innQtyS[22] + innQtyS[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								innQtyS[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

							innQtyG[0] = Double.parseDouble(vos.getFull20()) + innQtyG[0];
							innQtyG[1] = Double.parseDouble(vos.getFull40()) + innQtyG[1];
							innQtyG[2] = Double.parseDouble(vos.getFullHc()) + innQtyG[2];
							innQtyG[3] = Double.parseDouble(vos.getFull45()) + innQtyG[3];
							innQtyG[4] = Double.parseDouble(vos.getFullTotal()) + innQtyG[4];
							innQtyG[5] = Double.parseDouble(vos.getMty20()) + innQtyG[5];
							innQtyG[6] = Double.parseDouble(vos.getMty40()) + innQtyG[6];
							innQtyG[7] = Double.parseDouble(vos.getMtyHc()) + innQtyG[7];
							innQtyG[8] = Double.parseDouble(vos.getMty45()) + innQtyG[8];
							innQtyG[9] = Double.parseDouble(vos.getMtyTotal()) + innQtyG[9];
							innQtyG[10] = Double.parseDouble(vos.getVal01()) + innQtyG[10];
							innQtyG[11] = Double.parseDouble(vos.getVal02()) + innQtyG[11];
							innQtyG[12] = Double.parseDouble(vos.getVal03()) + innQtyG[12];
							innQtyG[13] = Double.parseDouble(vos.getVal04()) + innQtyG[13];
							innQtyG[14] = Double.parseDouble(vos.getVal05()) + innQtyG[14];
							innQtyG[15] = Double.parseDouble(vos.getVal06()) + innQtyG[15];
							innQtyG[16] = Double.parseDouble(vos.getVal07()) + innQtyG[16];
							innQtyG[17] = Double.parseDouble(vos.getDeadslot()) + innQtyG[17];
							innQtyG[18] = Double.parseDouble(vos.getWeighttotal()) + innQtyG[18];
							innQtyG[19] = Double.parseDouble(vos.getReleasedteu()) + innQtyG[19];
							innQtyG[20] = Double.parseDouble(vos.getReleasedweight()) + innQtyG[20];
							innQtyG[21] = Double.parseDouble(vos.getBsaspace()) + innQtyG[21];
							innQtyG[22] = Double.parseDouble(vos.getBsaweight()) + innQtyG[22];
							if (innQtyG[21] != 0.0) {
								double lfFull = ((innQtyG[0] + 2 * (innQtyG[1] + innQtyG[2] + innQtyG[3]) + innQtyG[17]) / (innQtyG[21] + innQtyG[19])) * 100;
								BigDecimal blfFull = new BigDecimal(lfFull);
								innQtyG[23] = blfFull.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}
							else {
								innQtyG[23] = Double.parseDouble("0.0");
							}

							if (innQtyG[21] == 0.0) {
								innQtyG[24] = Double.parseDouble("0.0");
							}
							else {
								double teuTotal = (innQtyG[0] + 2 * (innQtyG[1] + innQtyG[2] + innQtyG[3]) + innQtyG[5] + 2 * (innQtyG[6]
										+ innQtyG[7] + innQtyG[8]));

								double lfEq = ((teuTotal + innQtyG[17]) / (innQtyG[21] + innQtyG[19])) * 100;

								BigDecimal blfEq = new BigDecimal(lfEq);

								innQtyG[24] = blfEq.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

							if (innQtyG[22] == 0.0) {
								innQtyG[25] = Double.parseDouble("0.0");
							}
							else {
								double lfWgt = (innQtyG[18] / (innQtyG[22] + innQtyG[20])) * 100;

								BigDecimal blfWgt = new BigDecimal(lfWgt);
								innQtyG[25] = blfWgt.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							}

						}

					} // end if - if( ( zTCompany.equals(xTCompany) && zTTrade.equals(xTTrade) ) || i == 0 ){

					xTCompany = zTCompany;
					xTTrade = zTTrade;

				} // end for
				if(list2.size() > 0){
				vo = new SearchMBByVesselVO();
				vo.setSeq(" ");
				vo.setCom("Total");
				vo.setTrade("");
				vo.setLane("");
				vo.setIo("Out");
				vo.setRegion("");
				vo.setVvd("");
				vo.setLastport("");
				vo.setAtd("");
				vo.setWeek("");
				vo.setFull20(outQtyS[0] + "");
				vo.setFull40(outQtyS[1] + "");
				vo.setFullHc(outQtyS[2] + "");
				vo.setFull45(outQtyS[3] + "");
				vo.setFullTotal(outQtyS[4] + "");
				vo.setMty20(outQtyS[5] + "");
				vo.setMty40(outQtyS[6] + "");
				vo.setMtyHc(outQtyS[7] + "");
				vo.setMty45(outQtyS[8] + "");
				vo.setMtyTotal(outQtyS[9] + "");
				// vo.setBoxTotal(vos.getBoxTotal());
				// vo.setTeuTotal(vos.getTeuTotal());
				vo.setTeuFull(calcRationFloat(innQtyS[10], outQtyS[10]));
				vo.setTeuEq(calcRationFloat(innQtyS[11], outQtyS[11]));
				vo.setEq20(calcRationFloat(innQtyS[12], outQtyS[12]));
				vo.setEq40(calcRationFloat(innQtyS[13], outQtyS[13]));
				vo.setEqHc(calcRationFloat(innQtyS[14], outQtyS[14]));
				vo.setEq45(calcRationFloat(innQtyS[15], outQtyS[15]));
				vo.setEqTotal(calcRationFloat(innQtyS[16], outQtyS[16]));
				vo.setDatasource("");
				vo.setLffull(outQtyS[23] + "");
				vo.setLfeq(outQtyS[24] + "");
				vo.setLfwgt(outQtyS[25] + "");
				vo.setWeighttotal(outQtyS[18] + ""); // weightTotal
				vo.setDeadslot(outQtyS[17] + ""); // deadSlot
				vo.setBsaspace(outQtyS[21] + "");
				vo.setBsaweight(outQtyS[22] + "");
				vo.setReleasedteu(outQtyS[19] + "");
				vo.setReleasedweight(outQtyS[20] + "");

				list2.add(m, vo);
				m++;

				vo = new SearchMBByVesselVO();
				vo.setSeq(" ");
				vo.setCom("");
				vo.setTrade("");
				vo.setLane("");
				vo.setIo("In");
				vo.setRegion("");
				vo.setVvd("");
				vo.setLastport("");
				vo.setAtd("");
				vo.setWeek("");
				vo.setFull20(innQtyS[0] + "");
				vo.setFull40(innQtyS[1] + "");
				vo.setFullHc(innQtyS[2] + "");
				vo.setFull45(innQtyS[3] + "");
				vo.setFullTotal(innQtyS[4] + "");
				vo.setMty20(innQtyS[5] + "");
				vo.setMty40(innQtyS[6] + "");
				vo.setMtyHc(innQtyS[7] + "");
				vo.setMty45(innQtyS[8] + "");
				vo.setMtyTotal(innQtyS[9] + "");
				// vo.setBoxTotal(vos.getBoxTotal());
				// vo.setTeuTotal(vos.getTeuTotal());
				vo.setTeuFull(calcRationFloat(innQtyS[10], outQtyS[10]));
				vo.setTeuEq(calcRationFloat(innQtyS[11], outQtyS[11]));
				vo.setEq20(calcRationFloat(innQtyS[12], outQtyS[12]));
				vo.setEq40(calcRationFloat(innQtyS[13], outQtyS[13]));
				vo.setEqHc(calcRationFloat(innQtyS[14], outQtyS[14]));
				vo.setEq45(calcRationFloat(innQtyS[15], outQtyS[15]));
				vo.setEqTotal(calcRationFloat(innQtyS[16], outQtyS[16]));
				vo.setDatasource("");
				vo.setLffull(innQtyS[23] + "");

				vo.setLfeq(innQtyS[24] + "");
				vo.setLfwgt(innQtyS[25] + "");
				vo.setWeighttotal(innQtyS[18] + ""); // weightTotal
				vo.setDeadslot(innQtyS[17] + ""); // deadSlot
				vo.setBsaspace(innQtyS[21] + "");
				vo.setBsaweight(innQtyS[22] + "");
				vo.setReleasedteu(innQtyS[19] + "");
				vo.setReleasedweight(innQtyS[20] + "");

				list2.add(m, vo);
				m++;

				vo = new SearchMBByVesselVO();
				vo.setSeq("");
				vo.setCom("G.Total");
				vo.setTrade("");
				vo.setLane("");
				vo.setIo("Out");
				vo.setRegion("");
				vo.setVvd("");
				vo.setLastport("");
				vo.setAtd("");
				vo.setWeek("");
				vo.setFull20(outQtyG[0] + "");
				vo.setFull40(outQtyG[1] + "");
				vo.setFullHc(outQtyG[2] + "");
				vo.setFull45(outQtyG[3] + "");
				vo.setFullTotal(outQtyG[4] + "");
				vo.setMty20(outQtyG[5] + "");
				vo.setMty40(outQtyG[6] + "");
				vo.setMtyHc(outQtyG[7] + "");
				vo.setMty45(outQtyG[8] + "");
				vo.setMtyTotal(outQtyG[9] + "");
				// vo.setBoxTotal(vos.getBoxTotal());
				// vo.setTeuTotal(vos.getTeuTotal());
				vo.setTeuFull(calcRationFloat(innQtyG[10], outQtyG[10]));
				vo.setTeuEq(calcRationFloat(innQtyG[11], outQtyG[11]));
				vo.setEq20(calcRationFloat(innQtyG[12], outQtyG[12]));
				vo.setEq40(calcRationFloat(innQtyG[13], outQtyG[13]));
				vo.setEqHc(calcRationFloat(innQtyG[14], outQtyG[14]));
				vo.setEq45(calcRationFloat(innQtyG[15], outQtyG[15]));
				vo.setEqTotal(calcRationFloat(innQtyG[16], outQtyG[16]));
				vo.setDatasource("");
				vo.setLffull(outQtyG[23] + "");
				vo.setLfeq(outQtyG[24] + "");
				vo.setLfwgt(outQtyG[25] + "");
				vo.setWeighttotal(outQtyG[18] + ""); // weightTotal
				vo.setDeadslot(outQtyG[17] + ""); // deadSlot
				vo.setBsaspace(outQtyG[21] + "");
				vo.setBsaweight(outQtyG[22] + "");
				vo.setReleasedteu(outQtyG[19] + "");
				vo.setReleasedweight(outQtyG[20] + "");

				list2.add(m, vo);
				m++;

				vo = new SearchMBByVesselVO();
				vo.setSeq("");
				vo.setCom("G.Total");
				vo.setTrade("");
				vo.setLane("");
				vo.setIo("In");
				vo.setRegion("");
				vo.setVvd("");
				vo.setLastport("");
				vo.setAtd("");
				vo.setWeek("");
				vo.setFull20(innQtyG[0] + "");
				vo.setFull40(innQtyG[1] + "");
				vo.setFullHc(innQtyG[2] + "");
				vo.setFull45(innQtyG[3] + "");
				vo.setFullTotal(innQtyG[4] + "");
				vo.setMty20(innQtyG[5] + "");
				vo.setMty40(innQtyG[6] + "");
				vo.setMtyHc(innQtyG[7] + "");
				vo.setMty45(innQtyG[8] + "");
				vo.setMtyTotal(innQtyG[9] + "");
				// vo.setBoxTotal(vos.getBoxTotal());
				// vo.setTeuTotal(vos.getTeuTotal());
				vo.setTeuFull(calcRationFloat(innQtyG[10], outQtyG[10]));
				vo.setTeuEq(calcRationFloat(innQtyG[11], outQtyG[11]));
				vo.setEq20(calcRationFloat(innQtyG[12], outQtyG[12]));
				vo.setEq40(calcRationFloat(innQtyG[13], outQtyG[13]));
				vo.setEqHc(calcRationFloat(innQtyG[14], outQtyG[14]));
				vo.setEq45(calcRationFloat(innQtyG[15], outQtyG[15]));
				vo.setEqTotal(calcRationFloat(innQtyG[16], outQtyG[16]));
				vo.setDatasource("");
				vo.setLffull(innQtyG[23] + "");
				vo.setLfeq(innQtyG[24] + "");
				vo.setLfwgt(innQtyG[25] + "");
				vo.setWeighttotal(innQtyG[18] + ""); // weightTotal
				vo.setDeadslot(innQtyG[17] + ""); // deadSlot
				vo.setBsaspace(innQtyG[21] + "");
				vo.setBsaweight(innQtyG[22] + "");
				vo.setReleasedteu(innQtyG[19] + "");
				vo.setReleasedweight(innQtyG[20] + "");

				list2.add(m, vo);
				m++;
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return list2;
	}

	/**
	 * return ratio <br>
	 * 
	 * @param innVal
	 * @param outVal
	 * @return String
	 */
	private String calcRationFloat(double innVal, double outVal) {
		String rtnStrVal = "0";
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		if ((innVal - outVal) >= 0) {
			if (innVal == 0) {
				rtnStrVal = "0";
			}
			else {
				rtnStrVal = nf.format((outVal / innVal) * 100) + "";
			}
		}
		else {
			if (outVal == 0) {
				rtnStrVal = "0";
			}
			else {
				rtnStrVal = nf.format((innVal / outVal) * (-1) * 100) + "";
			}
		}
		return checkStringRemoveZero(rtnStrVal);
	}

	/**
	 * return 0 in case of 0.0 <br>
	 * 
	 * @param xTempVal
	 * @return String
	 */
	private String checkStringRemoveZero(String xTempVal) {
		String xVal01 = xTempVal;
		// log.debug("@@@@@@@ xVal01 [" + xVal01 + "]");
		String xVal02 = "";
		if (xVal01 == null || xVal01.equals("")) {
			xVal01 = "0";
		}
		if (xVal01.equals("-0.0")) {
			xVal01 = "0";
		}
		if (xVal01.indexOf(".") != -1) {
			xVal02 = xVal01.substring(xVal01.indexOf(".") + 1, xVal01.length());
			if (xVal02.equals("0")) {
				xVal01 = xVal01.substring(0, xVal01.indexOf("."));
			}
		}
		// log.debug("@@@@@@@ ");
		return xVal01;
	}

	public SearchOptionByTradeLaneVvdVO getSearchOptionByTradeLaneVvdVO() {
		return searchOptionByTradeLaneVvdVO;
	}

	public void setSearchOptionByTradeLaneVvdVO(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) {
		this.searchOptionByTradeLaneVvdVO = searchOptionByTradeLaneVvdVO;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/*
	private String[] cutStringToArray(String strIn, String chrSeprator){
		int curIndex=0,endIndex=0;
		ArrayList<String>arrString = new ArrayList<String>(); 

		while(1==1){
			curIndex=strIn.indexOf(chrSeprator,endIndex);
			if(curIndex==-1){
				arrString.add(strIn.substring(endIndex));
				break;
			}
			else{
				arrString.add(strIn.substring(endIndex,curIndex));
			}
			endIndex=curIndex+1;
		}
		
		String[] result = new String[arrString.size()];  
		return arrString.toArray(result);  
	}
	*/
}
