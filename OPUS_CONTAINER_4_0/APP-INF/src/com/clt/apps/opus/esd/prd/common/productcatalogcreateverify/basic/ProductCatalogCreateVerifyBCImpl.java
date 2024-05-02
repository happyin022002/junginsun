/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBCImpl.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.basic;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.integration.ProductCatalogCreateVerifyDBDAO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * PRD Business Logic Basic Command implementation<br>
 * PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ProductCatalogCreateVerifyBCImpl extends BasicCommandSupport implements ProductCatalogCreateVerifyBC {

	// Database Access Object
	private transient ProductCatalogCreateVerifyDBDAO dbDao = null;

	/**
	 * PrdCommonManageDBDAO를 생성한다.<br>
	 */
	public ProductCatalogCreateVerifyBCImpl() {
		dbDao = new ProductCatalogCreateVerifyDBDAO();
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * PrdCommonManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * 
	 * @param event
	 * @param prdCreateParamVO
	 * @param prdPcCreateVO
	 * @param prdPatternVO
	 * @return
	 * @throws EventException
	 */
	public String getPcVerify(EsdPrd0080Event event, PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVO, PrdPatternVO prdPatternVO) throws EventException {
		StringBuilder sbMessage = new StringBuilder();
		try {
			DBRowSet rowset = null;
			rowset = dbDao.getPcVerify(event, prdCreateParamVO, prdPcCreateVO, prdPatternVO);
			if (rowset.next()) {
				if (Integer.parseInt(rowset.getString("ROUT_SEQ")) == 0) {
					sbMessage.append("\n Could not find OCN ROUTE. ");
					if (Integer.parseInt(rowset.getString("HUB_COUNT")) == 0) {
						sbMessage.append("\n Could not find Hub Location. ");
					}
					return sbMessage.toString();
				}
				if ("X".equals(rowset.getString("CHECK_ROUT"))) {
					if (!"".equals(rowset.getString("STS_CHECK"))) {
						sbMessage.append("\n * Please request Marine Operation Dep't in charge of Vessel Schedule to activate the status of '").append(rowset.getString("STS_CHECK"));
						sbMessage.append(" ' from 'Closed' to 'Active' so as to update booking inforamtion without any restriction.");
					} else {
						sbMessage.append("\n Could not find vessel SKD between ").append(prdCreateParamVO.getPol() + " - " + prdCreateParamVO.getPod());
						sbMessage.append("\n");
					}

				} else if ("Y".equals(rowset.getString("CHECK_ROUT")) && "X".equals(rowset.getString("OCN_SO_CHK"))) {
					sbMessage.append("\n Could not find proper Ocean Route from the S/O Information. \n Please check the S/O and the ocean route. ");
					sbMessage.append("\n");
				} else if (CheckUtilities.isInBlank(rowset.getString("MTPU_CY")) && CheckUtilities.isInBlank(rowset.getString("MTRTN_CY"))) {
					sbMessage.append("\n \"Empty Return Yard\" is not exists. ");
					sbMessage.append("\n");
				} else {
					String obTr = prdCreateParamVO.getObTrspMode();
					if ("Y".equals(rowset.getString("ORG_CHECK")) && "B".equals(rowset.getString("ORG_FLG_CHK"))) {
						sbMessage.append("\n Please check O/B's BKG Flag");
						sbMessage.append("\n and its Priority with the control RHQ for the route");
					} else if ("X".equals(rowset.getString("ORG_CHECK"))) {
						String fmNode = (prdCreateParamVO.getPorN() != null && !"".equals(prdCreateParamVO.getPorN())) ? prdCreateParamVO.getPorN() : prdCreateParamVO.getPor();
						String toNode = (prdCreateParamVO.getPolN() != null && !"".equals(prdCreateParamVO.getPolN())) ? prdCreateParamVO.getPolN() : prdCreateParamVO.getPol();
						sbMessage.append("\n There is no proper inland route from ").append(fmNode).append(" to ").append(toNode).append(" in PRD\n Please request each RHQ/Operation part to register the above inland route.");
						sbMessage.append("\n");
					} else if (!"".equals(obTr) && !obTr.equals(rowset.getString("OB_TRSP_MOD_CD"))) {
						sbMessage.append("\n Could not find Outbound TransMode [").append(obTr).append("] \n");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "X".equals(rowset.getString("OB_SO_CHK")) && "Y".equals(rowset.getString("OB_IRG_CHK").substring(0, 1))) {
						sbMessage.append("\n The O/B's Inland Route Information between BKG and SO is different. Please match the route of BKG and SO.");
						sbMessage.append("\n[SO ROUTE : ").append(rowset.getString("OB_IRG_CHK").substring(2)).append("]");
						sbMessage.append("\n");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "X".equals(rowset.getString("OB_SO_CHK"))) {
						sbMessage.append("\n Could not find proper Outbound Route from the S/O Information. \n Please check the O/B S/O of this booking. ");
						sbMessage.append("\n");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "N".equals(rowset.getString("ORG_FLG_CHK"))) {
						sbMessage.append("\n The O/B route you are trying to change have Temp flag, so you can’t choose that.");
						sbMessage.append("\n Please contact an operation group of RHQ who is controlling area’s inland route");
					}

					String ibTr = prdCreateParamVO.getIbTrspMode();
					if ("Y".equals(rowset.getString("DEST_CHECK")) && "B".equals(rowset.getString("DEST_FLG_CHK"))) {
						sbMessage.append("\n Please check I/B's BKG Flag");
						sbMessage.append("\n and its Priority with the control RHQ for the route");
					} else if ("X".equals(rowset.getString("DEST_CHECK"))) { // route를 먼저 체크한 다음 trans mode를 검사하도록 변경
						String podN = "";
						if (prdCreateParamVO.getDelN() != null && !"".equals(prdCreateParamVO.getDelN()) && prdCreateParamVO.getPod() != null && !"".equals(prdCreateParamVO.getPod())) {
							String pod = prdCreateParamVO.getPod();
							if (prdCreateParamVO.getPod4N() != null && !prdCreateParamVO.getPod4N().equals("") && pod.equals(prdCreateParamVO.getPod4N().substring(0, 5)) && prdCreateParamVO.getPod4N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod4N();
							} else if (prdCreateParamVO.getPod3N() != null && !prdCreateParamVO.getPod3N().equals("") && pod.equals(prdCreateParamVO.getPod3N().substring(0, 5)) && prdCreateParamVO.getPod3N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod3N();
							} else if (prdCreateParamVO.getPod2N() != null && !prdCreateParamVO.getPod2N().equals("") && pod.equals(prdCreateParamVO.getPod2N().substring(0, 5)) && prdCreateParamVO.getPod2N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod2N();
							} else if (prdCreateParamVO.getPod1N() != null && !prdCreateParamVO.getPod1N().equals("") && pod.equals(prdCreateParamVO.getPod1N().substring(0, 5)) && prdCreateParamVO.getPod1N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod1N();
							}
						}

						if (!podN.equals("")) {
							String toNode = (prdCreateParamVO.getDelN() != null && !"".equals(prdCreateParamVO.getDelN())) ? prdCreateParamVO.getDelN() : prdCreateParamVO.getDel();
							sbMessage.append("\n There is no proper inland route from ").append(podN).append(" to ").append(toNode).append(" in PRD\n Please request each RHQ/Operation part to register the above inland route.");
						} else {
							sbMessage.append("\n Could not find Inbound Route from ").append(prdCreateParamVO.getPod() + "," + prdCreateParamVO.getPodN()).append(" to ").append(prdCreateParamVO.getDel() + "," + prdCreateParamVO.getDelN()).append(" for D_Term[").append(prdCreateParamVO.getDelT())
									.append("]\n Please change service term or request to create new Inland Route ");
						}
						sbMessage.append("\n");
					} else if (!"".equals(ibTr) && !ibTr.equals(rowset.getString("IB_TRSP_MOD_CD"))) {
						sbMessage.append("\n Could not find Inbound TransMode [").append(ibTr).append("] \n");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "X".equals(rowset.getString("IB_SO_CHK")) && "Y".equals(rowset.getString("IB_IRG_CHK").substring(0, 1))) {
						sbMessage.append("\n The I/B's Inland Route Information between BKG and SO is different. Please match the route of BKG and SO.");
						sbMessage.append("\n[SO ROUTE : ").append(rowset.getString("IB_IRG_CHK").substring(2)).append("]");
						sbMessage.append("\n");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "X".equals(rowset.getString("IB_SO_CHK"))) {
						sbMessage.append("\n Could not find proper Inbound Route from the S/O Information. \n Please check the I/B S/O of this booking. ");
						sbMessage.append("\n");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "N".equals(rowset.getString("DEST_FLG_CHK"))) {
						sbMessage.append("\n The I/B route you are trying to change have Temp flag, so you can’t choose that.");
						sbMessage.append("\n Please contact an operation group of RHQ who is controlling area’s inland route");
					}
				}
			} else {
				sbMessage.append("\n Not Found Any Available Ocean Route !! ");
				sbMessage.append("\n");
			}

			if (sbMessage.length() == 0) {
				sbMessage.append("\n P/C Creation Failed. ");

			}

			return sbMessage.toString();

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	} // end method
}
