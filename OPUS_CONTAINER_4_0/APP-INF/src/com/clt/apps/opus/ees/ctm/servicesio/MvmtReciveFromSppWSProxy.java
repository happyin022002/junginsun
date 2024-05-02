/*========================================================
 *Copyright(c) 2009 CyberLogitec 
 *ProcessChain    : NPI
 *@FileName       : MvmtReciveFromSppWSProxy.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Feb 16, 2009
 *@LastModifier   : Jeong-Hoon, KIM
 *@LastVersion    : 1.0
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/

package com.clt.apps.opus.ees.ctm.servicesio;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.bea.common.security.jdkutils.WeaverUtil.Collections;
import com.clt.apps.opus.ees.ctm.ctmcommon.CTMCommonSC;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.event.CtmComEvent;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.EquipmentMovementMgtSC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0408Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgSppVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerSppVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0999Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementSppVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.RestuffingMgtSC;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0422Event;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingSppVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailSppVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * It's MvmtReciveFromSppWSProxy.java
 * 
 * @author KyungMin, Woo
 * @see
 * @since J2EE 1.5 Feb 23, 2009 /opuscntr/webservices/MvmtReciveFromSppProxy
 */
@WebService(name = "MvmtReciveFromSppProxyPortType", serviceName = "MvmtReciveFromSppProxy", targetNamespace = "http://www.clt.com/integration")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath = "/opuscntr/webservices", serviceUri = "/MvmtReciveFromSppProxy", portName = "MvmtReciveFromSppProxyPort")
public class MvmtReciveFromSppWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * manageSppMovement for MvmtReciveFromSppWSProxy
	 * 
	 * @author KyungMin, Woo
	 * @param cusCtmMovementSppVOs
	 *            CusCtmMovementSppVO[]
	 * @return list
	 */
	@WebMethod()
	public String[][] manageSppMovement(
			CusCtmMovementSppVO[] cusCtmMovementSppVOs) {

		String[][] list = new String[cusCtmMovementSppVOs.length][3];
		EquipmentMovementMgtSC sc = new EquipmentMovementMgtSC();

		CusCtmMovementVO[] cusCtmMovementVOS = copy(cusCtmMovementSppVOs);
		Event event = new EesCtm0999Event(cusCtmMovementVOS);

		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.MULTI);
		event.setFormCommand(f);
		try {
			Map<String, String> rtnMap = new HashMap<String, String>();
			EventResponse rtn = sc.perform(event);
			rtnMap = rtn.getETCData();
			String rtnStr = (String) rtnMap.get("rtnStr");
			String[] result = new String[cusCtmMovementVOS.length + 1];
			String tmpStr = rtnStr;

			for (int id = 0; id < cusCtmMovementVOS.length + 1; id++) {
				log.info("\n\n==============================================================="
						+ "\n SPP : cusCtmMovementVOS["
						+ id
						+ "] : ColumnValues"
						+ "\n======================================"
						+ "\n"
						+ cusCtmMovementVOS[id].getColumnValues().toString()
								.replaceAll(", ", "\n")
						+ "\n===============================================================\n");
				int idxOf = tmpStr.indexOf("^^");
				result[id] = tmpStr.substring(0, idxOf);
				tmpStr = tmpStr.substring(idxOf + 2, tmpStr.length());
				if (tmpStr.length() <= 2)
					break;
			}

			for (int ix = 0; ix < result.length - 1; ix++) {
				if (result[ix] == null || result[ix].equals("null")
						|| result[ix].equals("")) {
					list[ix][0] = cusCtmMovementVOS[ix].getCntrNo();
					list[ix][1] = "Y";
					list[ix][2] = "Successfully transmitted.";
				} else {
					list[ix][0] = cusCtmMovementVOS[ix].getCntrNo();
					list[ix][1] = "N";
					log.info("Result : " + result[ix]);
					list[ix][2] = "Transmission Failed.";
				}
			}
		} catch (Exception ex) {
			list[0][0] = cusCtmMovementVOS[0].getCntrNo();
			list[0][1] = "N";
			log.error(ex.getMessage(), ex);
			list[0][2] = "Transmission Failed.";
		}

		return list;
	}

	/**
	 * [Method] Object Copy
	 * 
	 * @param cusCtmMovementSppVOS
	 * @return
	 */
	private CusCtmMovementVO[] copy(CusCtmMovementSppVO[] cusCtmMovementSppVOS) {
		int size = cusCtmMovementSppVOS.length;
		CusCtmMovementVO[] cusCtmMovementVOS = new CusCtmMovementVO[size];
		for (int i = 0; i < size; i++) {
			cusCtmMovementVOS[i] = setField(cusCtmMovementSppVOS[i]);
		}
		return cusCtmMovementVOS;
	}

	/**
	 * [Method] Object Copy
	 * 
	 * @param cusCtmMovementSppVOS
	 * @return
	 */
	private CusCtmMovementVO setField(CusCtmMovementSppVO cusCtmMovementSppVOS) {
		CusCtmMovementVO ctmMovementVO = new CusCtmMovementVO();
		Class<?> c1 = cusCtmMovementSppVOS.getClass();
		Class<?> c = ctmMovementVO.getClass();
		Field[] field = c.getDeclaredFields();
		Object fieldValueObject = "";
		for (Field f : field) {
			String name = f.getName();
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			try {
				fieldValueObject = null;
				Field originField = c1.getDeclaredField(name);
				if (!originField.isAccessible()) {
					originField.setAccessible(true);
					fieldValueObject = originField.get(cusCtmMovementSppVOS);
				} else {
					fieldValueObject = originField.get(cusCtmMovementSppVOS);
				}
				f.set(ctmMovementVO, fieldValueObject);
			} catch (Exception e) {
				log.error("err " + e.toString(), e);
			}
		}
		return ctmMovementVO;
	}

	/**
	 * createRestuffingContainer for MvmtReciveFromSppWSProxy
	 * 
	 * @param ctmRestuffingDetailSppVO
	 *            CtmRestuffingDetailSppVO[]
	 * @return response String
	 */
	@WebMethod()
	public String createRestuffingContainer(
			CtmRestuffingDetailSppVO[] ctmRestuffingDetailSppVO) {
		String response = "success";
		try {
			RestuffingMgtSC sc = new RestuffingMgtSC();
			// //////////////////////////////////////////////////////////////////////////////////////////
			Event ev = new EesCtm0422Event(
					(CtmRestuffingDetailVO[]) copy(ctmRestuffingDetailSppVO));
			String usr_id = "ESVCUSER";
			String usr_nm = "ESVCUSER";
			String ofc_cd = "";
			SignOnUserAccount account = new SignOnUserAccount(usr_id, usr_nm,
					"", "", "", "", "", "", "", "", "", "", ofc_cd, "", "", "",
					"", "", "", "", "", "");
			ev.setAttribute("com.clt.component.signon.SIGN_ON_USER_ACCOUNT",
					account);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			ev.setFormCommand(f);

			sc.init(ev);
			// //////////////////////////////////////////////////////////////////////////////////////////
			// Event event = new EesCtm0422Event((CtmRestuffingDetailVO[])
			// copy(ctmRestuffingDetailSppVO));
			sc.doStart();
			sc.perform(ev);
			sc.doEnd();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			response = "fail";
		}
		return response;
	}

	/**
	 * searchReasonList for MvmtReciveFromSppWSProxy retrieving Reason List
	 * example for getting Reason List :
	 * eventResponse.getETCData().get("returnValue") data sample : BE|BKG clerk
	 * Er|BE^CM|Carrier Mist|CM^DM|CNTR
	 * damaged|DM^DP|Disposal,L/O|DP^ET|IM-EXIT|ET^OD|Over
	 * Due|OD^OT|Others|OT^OW|Over Weight|OW^OZ|Over size|OZ^RC|BKG
	 * correct|RC^SM|Shpr mis-use|SM^ delimeter is ^
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@WebMethod()
	public String searchReasonList() {
		String rtnValue = null;
		CTMCommonSC sc = new CTMCommonSC();
		Event event = new CtmComEvent();

		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.SEARCH06);
		event.setFormCommand(f);

		try {
			rtnValue = sc.perform(event).getETCData().get("rtnValue");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * searchReasonList for MvmtReciveFromSppWSProxy retrieving Reason List
	 * example for getting Reason List :
	 * eventResponse.getETCData().get("returnValue") data sample : BE|BKG clerk
	 * Er|BE^CM|Carrier Mist|CM^DM|CNTR
	 * damaged|DM^DP|Disposal,L/O|DP^ET|IM-EXIT|ET^OD|Over
	 * Due|OD^OT|Others|OT^OW|Over Weight|OW^OZ|Over size|OZ^RC|BKG
	 * correct|RC^SM|Shpr mis-use|SM^ delimeter is ^
	 * 
	 * @param String p_cntrno
	 * @return response EventResponse
	 * @exception EventException
	 */
	@WebMethod()
	public String checkContainerNo(String p_cntrno) {
		String rtnValue = null;
		CtmCommonVO vo = new CtmCommonVO();
		CtmComEvent event = new CtmComEvent();
		CTMCommonSC sc = new CTMCommonSC();

		vo.setPCntrno(p_cntrno);
		event.setCTMCommonVO(vo);

		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.SEARCH10);
		event.setFormCommand(f);

		try {
			rtnValue = sc.perform(event).getETCData().get("rtnValue");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * createRestuffingContainer for MvmtReciveFromSppWSProxy example for
	 * getting BKG,B/L : eventResponse.getETCData().get("Split") data sample :
	 * BOOKING NO|BL NO^^ delimeter is ^^
	 * 
	 * example for getting Value Object List : List<CTMRestuffingVO> list =
	 * (CTMRestuffingVO) eventResponse.getRsVoList()
	 * 
	 * @param cntrNo
	 *            String
	 * @param checkDigit
	 *            String
	 * @return CTMRestuffingSppVO[]
	 */
	@WebMethod()
	public CTMRestuffingSppVO[] searchOBJMVMT(String cntrNo, String checkDigit) {
		CTMRestuffingSppVO[] objs = null;
		CtmMovementHistoryVO vo = new CtmMovementHistoryVO();
		EesCtm0422Event event = new EesCtm0422Event();
		RestuffingMgtSC sc = new RestuffingMgtSC();

		vo.setCntrNo(cntrNo+checkDigit);
//		vo.setCheckDigit(checkDigit);
		event.setCtmMovementHistoryVO(vo);

		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.SEARCH);
		event.setFormCommand(f);

		try {
			EventResponse rtn = sc.perform(event);
			objs = (CTMRestuffingSppVO[]) copy(rtn.getRsVoList());

			Map<String, String> rtnMap = new HashMap<String, String>();

			rtnMap = rtn.getETCData();
			String rtnStr = (String) rtnMap.get("Split");
			if (rtnStr != null) {
				if (objs == null)
					objs = new CTMRestuffingSppVO[1];
				objs[0].setSplit(rtnStr);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		return objs;
	}

	/**
	 * searchMovementListByContainer for MvmtReciveFromSppWSProxy example for
	 * getting Value Object List : List list = eventResponse.getRsVoList()
	 * 
	 * @param cntrNo
	 *            String
	 * @param checkDigit
	 *            String
	 * @param tpszCd
	 *            String
	 * @param pDate1
	 *            String
	 * @param pDate2
	 *            String
	 * @return SearchMovementListByContainerSppVO[]
	 */
	@WebMethod()
	public SearchMovementListByContainerSppVO[] searchMovementListByContainer(
			String cntrNo, String checkDigit, String tpszCd, String pDate1,
			String pDate2) {
		ArrayList<SearchMovementListByContainerSppVO> returnList = null;
		SearchMovementListByContainerVO searchMovementListByContainerVO = new SearchMovementListByContainerVO();
		SearchEdiMsgVO searchEdiMsgVO = new SearchEdiMsgVO();
		EesCtm0408Event event = new EesCtm0408Event();
		EquipmentMovementMgtSC sc = new EquipmentMovementMgtSC();

		searchMovementListByContainerVO.setPCntrno(cntrNo+checkDigit);
//		searchMovementListByContainerVO.setCheckDigit(checkDigit);
		searchMovementListByContainerVO.setPDate1(pDate1);
		searchMovementListByContainerVO.setPDate2(pDate2);
		event.setSearchMovementListByContainerVO(searchMovementListByContainerVO);

		searchEdiMsgVO.setPCntrno(cntrNo+checkDigit);
//		searchEdiMsgVO.setCheckDigit(checkDigit);
		event.setSearchEdiMsgVO(searchEdiMsgVO);

		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.SEARCH);
		event.setFormCommand(f);

		try {
			Object[] objs = copy(sc.perform(event).getRsVoList());
			returnList = new ArrayList<SearchMovementListByContainerSppVO>();
			if (objs != null && objs.length > 0)
				Collections.addAll(returnList, objs);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		return returnList
				.toArray(new SearchMovementListByContainerSppVO[returnList
						.size()]);
	}

	/**
	 * [Method] Object Copy
	 * 
	 * @param Object
	 *            [] objects
	 * @return Object[]
	 */
	private Object[] copy(Object[] objects) {
		Object[] object2 = null;

		if (objects != null) {
			int size = objects.length;
			if (size > 0)
				try {
					if (objects[0] instanceof CtmRestuffingDetailSppVO) {
						object2 = new CtmRestuffingDetailVO[size];
						for (int i = 0; i < size; i++) {
							object2[i] = (CtmRestuffingDetailVO) setField(objects[i]);
						}
					} else if (objects[0] instanceof SearchMovementListByContainerVO) {
						object2 = new SearchMovementListByContainerSppVO[size];
						for (int i = 0; i < size; i++) {
							object2[i] = (SearchMovementListByContainerSppVO) setField(objects[i]);
						}
					} else if (objects[0] instanceof SearchEdiMsgVO) {
						object2 = new SearchEdiMsgSppVO[size];
						for (int i = 0; i < size; i++) {
							object2[i] = (SearchEdiMsgSppVO) setField(objects[i]);
						}
					} else {
						object2 = new CTMRestuffingSppVO[size];
						for (int i = 0; i < size; i++) {
							object2[i] = (CTMRestuffingSppVO) setField(objects[i]);
						}
					}
				} catch (Exception e) {
					// System.out.println("ERROR ::::::::::::::::::: " +
					// e.getMessage());
					// e.printStackTrace();
					log.error("err " + e.toString(), e);
				}
		}
		return object2;
	}

	/**
	 * [Method] Object Copy
	 * 
	 * @param Object
	 *            [] objects
	 * @return Object[]
	 */
	private Object[] copy(List<?> objects) {
		Object[] object2 = null;

		if (objects != null) {
			int size = objects.size();

			if (size > 0)
				try {
					if (objects.get(0) instanceof CtmRestuffingDetailSppVO) {
						object2 = objects.toArray(new CtmRestuffingDetailSppVO[size]);
					} else if (objects.get(0) instanceof SearchMovementListByContainerVO) {
						object2 = objects.toArray(new SearchMovementListByContainerVO[size]);
					} else if (objects.get(0) instanceof SearchEdiMsgVO) {
						object2 = objects.toArray(new SearchEdiMsgVO[size]);
					} else {
						object2 = objects.toArray(new CTMRestuffingVO[size]);
					}
				} catch (Exception e) {
					// System.out.println("ERROR ::::::::::::::::::: " +
					// e.getMessage());
					// e.printStackTrace();
					log.error("err " + e.toString(), e);
				}
		}
		return copy(object2);
	}

	/**
	 * [Method] Object Copy
	 * 
	 * @param Object
	 * @return Object
	 */
	private Object setField(Object object) {
		Object object2 = null;

//		try {
			if (object instanceof CtmRestuffingDetailSppVO) {
				object2 = new CtmRestuffingDetailVO();
				// System.out.println("CtmRestuffingDetailSppVO");
			} else if (object instanceof SearchMovementListByContainerVO) {
				object2 = new SearchMovementListByContainerSppVO();
				// System.out.println("SearchMovementListByContainerVO");
			} else if (object instanceof SearchEdiMsgVO) {
				object2 = new SearchEdiMsgSppVO();
				// System.out.println("SearchEdiMsgVO");
			} else if (object instanceof CTMRestuffingVO) {
				object2 = new CTMRestuffingSppVO();
				// System.out.println("CTMRestuffingVO");
			}
			// [2015.05.28]소스품질 Modify
			if (null != object2) {
				Class<?> c1 = object.getClass();
				Class<?> c = object2.getClass();
				Field[] field = c.getDeclaredFields();
				Object fieldValueObject = "";
				for (Field f : field) {
					String name = f.getName();
					if (!f.isAccessible()) {
						f.setAccessible(true);
					}
//					try {
						fieldValueObject = null;
						Field originField = null;
						try {
							originField = c1.getDeclaredField(name);
						}  catch(NoSuchFieldException ee) {
							log.error(ee.getMessage());
							continue;
						}
						
					try {
						if ( !Modifier.isStatic(originField.getModifiers()) && !Modifier.isFinal(originField.getModifiers())) {
							if (!originField.isAccessible()) {
								originField.setAccessible(true);
								fieldValueObject = originField.get(object);
							} else {
								fieldValueObject = originField.get(object);
							}
							f.set(object2, fieldValueObject);
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
//					} catch (Exception e) {
//						log.error(e.getMessage());
//					}
				}
			}
//		} catch (Exception e) {
//			log.error("err " + e.toString(), e);
//		}

		return object2;
	}

	/**
	 * [Method] main
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		// [2015.05.28]소스품질 Modify
		// Object ctmMovementVO1 = new CusCtmMovementVO();
		// CusCtmMovementVO ctmMovementVO2 = new CusCtmMovementVO();
		/*
		 * System.out.println(ctmMovementVO1.getClass());
		 * System.out.println(ctmMovementVO2.getClass());
		 */
	}
}
