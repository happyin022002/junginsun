/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : PegasusMapping.java
 *@FileTitle : PegasusMapping
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.15
 *@LastModifier : 정인선
 *@LastVersion : 1.0
 * 2015.07.15 정인선
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * PegasusMapping<br>
 * 
 * @author 정인선
 * @see PegasusMapping
 * @since J2EE 1.4
 */
public class PegasusMapping {

	protected Logger log = Logger.getLogger(super.getClass().getName());
	private String lineSep = "\n";
	private String colon = ":";
	
	/**
	 * 
	 * @param command
	 * @param mapList
	 * @param document
	 * @return
	 * @throws XPathExpressionException
	 */
	public String mappingStart(EBookingReceiptBC command, List<BkgHrdCdgCtntVO> mapList, Document document) throws XPathExpressionException {
		StringBuffer sb = new StringBuffer();
		String lineTmp = System.getProperty("line.separator");
		if (lineTmp != null) lineSep = lineTmp;
		
		LinkedHashMap<String, ArrayList<BkgHrdCdgCtntVO>> voMap = new LinkedHashMap<String, ArrayList<BkgHrdCdgCtntVO>>();
		HashMap<String, String> filterMap = new HashMap<String, String>();
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xPath = xPathfactory.newXPath();
		
		for (int i = 0; i < mapList.size(); i++) {
			BkgHrdCdgCtntVO vo = mapList.get(i);

			/* 신규 노드일때 ArrayList 생성 */
			if (!voMap.containsKey(vo.getAttrCtnt6())) {
				voMap.put(vo.getAttrCtnt6(), new ArrayList<BkgHrdCdgCtntVO>());
			}
			voMap.get(vo.getAttrCtnt6()).add(vo);
		}

		String[] key = voMap.keySet().toArray(new String[0]);
		for (int i = 0; i < key.length; i++) {
			ArrayList<BkgHrdCdgCtntVO> nodeListVO = voMap.get(key[i]);
			NodeList nodeList = (NodeList) xPath.compile( nodeListVO.get(0).getAttrCtnt10().trim()).evaluate( document, XPathConstants.NODESET);
			for (int j = 0; j < nodeList.getLength(); j++) {
				StringBuffer nodeSb = new StringBuffer("{").append(key[i]) .append(lineSep);
				StringBuffer troSb = new StringBuffer("");
				boolean filterNodeCk = false;
				boolean nodeDataCk = false;

				Document doc = createDocument(nodeList.item(j));
				for (int vos = 0; vos < nodeListVO.size(); vos++) {
					BkgHrdCdgCtntVO vo = nodeListVO.get(vos);
					String dataNode = "";

					if (vo.getAttrCtnt9() != null) {
						/* 특정 기능을 위한 메소드 호출 (연산 또는 기능추가) */
						if (vo.getAttrCtnt9().trim().toUpperCase().indexOf("METHOD:") > -1) {
							String method = vo.getAttrCtnt9().trim().toUpperCase().replaceAll("METHOD:", "");
							if (method.equalsIgnoreCase("AWKWARDCARGO")) {
								dataNode = awkwardCargo(vo, doc, xPath);
							} else if (method.equalsIgnoreCase("EDITYPE")) {
								dataNode = ediType(vo, doc, xPath);
							} else if (method.equalsIgnoreCase("TROGEN")) {
								dataNode = troGen(doc, xPath, lineSep, colon);
							} else if (method .equalsIgnoreCase("FROMCITYUNLOCCODE")) {
								dataNode = fromCityUnlocCode(doc, xPath, lineSep, colon, command);
							} else if (method .equalsIgnoreCase("TOCITYUNLOCCODE")) {
								dataNode = toCityUnlocCode(doc, xPath, lineSep, colon, command);
							} else if (method.equalsIgnoreCase("CONTACTNAME")) {
								dataNode = contactName(doc, xPath);
							} else if (method.equalsIgnoreCase("CONTACTTEL")) {
								dataNode = contactTel(doc, xPath);
							} else if (method.equalsIgnoreCase("CONTACTEML")) {
								dataNode = contactEml(doc, xPath);
							} else if (method .equalsIgnoreCase("GROSSCARGOWEIGHT")) {
								dataNode = grossCargoWeight(doc, xPath);
							} else if (method .equalsIgnoreCase("NETCARGOWEIGHT")) {
								dataNode = netCargoWeight(doc, xPath);
							} else if (method .equalsIgnoreCase("FLASHPOINTTEMPERATURE")) {
								dataNode = flashPointTemperature(doc, xPath);
//							} else if (method.equalsIgnoreCase("CARGOCONTACT")) {
//								dataNode = cargoContact(doc, xPath);
							} else if (method.equalsIgnoreCase("VENTILATIONUNITCODE")) {
								dataNode = ventilationUnitCode(doc, xPath);
							} else if (method.equalsIgnoreCase("MPAGROUPNUMBER")) {
								dataNode = mpaGroupNumber(doc, xPath);
							} else if (method.equalsIgnoreCase("ORIGINFACILITYUNLOCCODE")) {
								dataNode = originFacilityUnlocCode(doc, xPath, command);
							} else if (method.equalsIgnoreCase("DESTINATIONFACILITYUNLOCCODE")) {
								dataNode = destinationFacilityUnlocCode(doc, xPath, command);
							} else if (method.equalsIgnoreCase("GROSSCARGOWEIGHTQUANTITY")) {
								dataNode = grossCargoWeightQuantity(doc, xPath, document);
							} else if (method.equalsIgnoreCase("GROSSCARGOWEIGHTUNITCODE")) {
								dataNode = grossCargoWeightUnitCode(doc, xPath, document);
							} else if (method.equalsIgnoreCase("EARLYDEPARTUREDATE")) {
								dataNode = earlyDepartureDate(doc, xPath);
							} else if (method.equalsIgnoreCase("ESTDEPORGNLOCALDATE")) {
								dataNode = estDepOrgnLocalDate(doc, xPath);
							} else if (method.equalsIgnoreCase("COMMODITYCODE")) {
								dataNode = commodityCode(doc, xPath);
							} else if (method.equalsIgnoreCase("LOADPORTNAME")) {
								dataNode = loadPortName(doc, xPath);
							} else if (method.equalsIgnoreCase("DISCHARGEPORTNAME")) {
								dataNode = dischargePortName(doc, xPath);
							} else if (method.equalsIgnoreCase("PACKAGETYPE")) {
								dataNode = packageType(doc, xPath, document);
							} else if (method.equalsIgnoreCase("PACKAGECOUNT")) {
								dataNode = packageCount(doc, xPath, document);
							} else if (method.equalsIgnoreCase("MESURECOUNT")) {
								dataNode = mesureCount(doc, xPath, document);
							} else if (method.equalsIgnoreCase("MESURETYPE")) {
								dataNode = mesureType(doc, xPath, document);
							} else if (method.equalsIgnoreCase("CONTAINERSIZETYPECODE")) {
								dataNode = containerSizeTypeCode(doc, xPath);
							} else if (method.equalsIgnoreCase("CARGOPACKAGECOUNT")) {
								dataNode = cargoPackageCount(doc, xPath);
							} else if (method.equalsIgnoreCase("CARGOPACKAGETYPE")) {
								dataNode = cargoPackageType(doc, xPath);
							} else if (method.equalsIgnoreCase("CARGOWEIGHTQUANTITY")) {
								dataNode = cargoWeightQuantity(doc, xPath);
							} else if (method.equalsIgnoreCase("CARGOVOLUMEQUANTITY")) {
								dataNode = cargoVolumeQuantity(doc, xPath);
							} else if (method.equalsIgnoreCase("CARGOWEIGHTUNITCODE")) {
								dataNode = cargoWeightUnitCode(doc, xPath);
							} else if (method.equalsIgnoreCase("CARGOVOLUMEUNITCODE")) {
								dataNode = cargoVolumeUnitCode(doc, xPath);
							}else if (method.equalsIgnoreCase("NETWEIGHT")) {
								dataNode = netWeight(doc, xPath);
							}
							
						} else if (vo.getAttrCtnt9().trim().toUpperCase() .indexOf("VALUE:") > -1) {
							String value = vo.getAttrCtnt9().trim().toUpperCase().replaceAll("VALUE:", "");
							dataNode = value;
						}

						/* 일반 형식 */
						else if (!vo.getAttrCtnt9().trim().isEmpty()) {
							String strPath = "//" + vo.getAttrCtnt9().trim();
							dataNode = xPath.compile(strPath).evaluate(doc);
						}

						/* 필터 불필요한 Node 삭제 */
						if (vo.getAttrCtnt7() != null && !vo.getAttrCtnt7().trim().isEmpty()) {
							filterMap.put(vo.getAttrCtnt6(), vo.getAttrCtnt7());
							if (!checkFilterData(vo.getAttrCtnt7(), dataNode)) {
								filterNodeCk = true;
								break;
							}
						}

						if (dataNode != null && !dataNode.isEmpty()) {
							if (vo.getAttrCtnt8() != null && !vo.getAttrCtnt8().isEmpty())
								dataNode = dataNode.trim().substring(0, Integer.parseInt(vo.getAttrCtnt8()));
							
						}
					}
					
					/* 기존에 값을 해당 값으로 변경한다. */
					if (vo.getAttrCtnt5() != null && !vo.getAttrCtnt5().isEmpty()){
						if(vo.getAttrCtnt5().indexOf("=") > -1){
							/* 여러건 체크 */
							if(vo.getAttrCtnt5().indexOf(",") > -1){
								String[] attrCtnts = vo.getAttrCtnt5().split(",");
								for (int k = 0; k < attrCtnts.length; k++) {
									String checkVlaue = attrCtnts[k].split("=")[0].trim();
									String changeValue = attrCtnts[k].split("=")[1].trim();
									if(checkVlaue.equals(dataNode)){
										dataNode = changeValue;
									}
								}
							}
							/* 단건 */
							else{
								String checkVlaue = vo.getAttrCtnt5().split("=")[0].trim();
								String changeValue = vo.getAttrCtnt5().split("=")[1].trim();
								if(checkVlaue.equals(dataNode)){
									dataNode = changeValue;
								}
							}
						}
					}
					
					if (dataNode != null && !dataNode.isEmpty() && !key[i].equals("I_BKG_TRO")) {
						nodeDataCk = true;
						if ("DATE".equals(vo.getAttrCtnt5())) {
							nodeSb.append(vo.getAttrCtnt2().trim()).append(colon).append(dataNode.trim().replaceAll("\n", " ").replace("-", "").replace("T", "").replace(":", "")).append(lineSep);
						} else {
							nodeSb.append(vo.getAttrCtnt2().trim()).append(colon).append(dataNode.trim().replaceAll("\n", " ")).append(lineSep);
						}
					} else if (dataNode != null && !dataNode.isEmpty() && key[i].equals("I_BKG_TRO")) {
						nodeDataCk = true;
						troSb.append(dataNode.trim()).append(lineSep);
					}
				}

				nodeSb.append("}").append(key[i]).append(lineSep);
				if (!filterNodeCk && nodeDataCk && troSb.toString().length() == 0)
					sb.append(nodeSb.toString());
				else if (troSb.toString().length() > 0) {
					sb.append(troSb.toString());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param BkgHrdCdgCtntVO vo
	 * @param Document doc
	 * @param XPath xPath
	 * @return
	 */
	private String ediType(BkgHrdCdgCtntVO vo, Document doc, XPath xPath) {
		String nodeData = "";
		try {
			String partnerCode = xPath.compile("//PartnerCode").evaluate(doc);
			if (partnerCode != null && partnerCode.equalsIgnoreCase("PG"))
				nodeData = "W";
			else
				nodeData = "E";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return nodeData;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param lineSep
	 * @param colon
	 * @return
	 */
	private String fromCityUnlocCode(Document doc, XPath xPath, String lineSep, String colon, EBookingReceiptBC command) {
		String nodeData = "";
		try {
			String unlocCode = xPath.compile("//BookingContainers/BookingContainer/FromCity/UnlocCode").evaluate(doc);
			if(unlocCode.equals("")) unlocCode = xPath.compile("//BookingContainers/BookingContainer/FromCity/CityCode").evaluate(doc);
			nodeData = command.getUnlocCodeToLocCd(unlocCode);
			if (nodeData == null || nodeData.equals("")){
				if(unlocCode.length() > 5){
					unlocCode = unlocCode.substring(0, 5);
				}
				nodeData = unlocCode;
			}
				
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		} catch (EventException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param lineSep
	 * @param colon
	 * @return
	 */
	private String toCityUnlocCode(Document doc, XPath xPath, String lineSep, String colon, EBookingReceiptBC command) {
		String nodeData = "";
		try {
			String unlocCode = xPath.compile("//BookingContainers/BookingContainer/ToCity/UnlocCode").evaluate(doc);
			if(unlocCode.equals("")) unlocCode = xPath.compile("//BookingContainers/BookingContainer/ToCity/CityCode").evaluate(doc);
			nodeData = command.getUnlocCodeToLocCd(unlocCode);
			if (nodeData == null || nodeData.equals("")){
				if(unlocCode.length() > 5){
					unlocCode = unlocCode.substring(0, 5);
				}
				nodeData = unlocCode;
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		} catch (EventException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String contactName(Document doc, XPath xPath) {
		String nodeData = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingBody/BookingCustomers/BookingCustomer").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCustomer = createDocument(nodeList.item(i));
				String customerTypeCode = xPath.compile("//CustomerTypeCode").evaluate(bookingCustomer);
				if (customerTypeCode.equals("B01"))
					return xPath.compile("//Contacts/Contact/ContactName").evaluate(bookingCustomer);
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String contactTel(Document doc, XPath xPath) {
		String nodeData = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingBody/BookingCustomers/BookingCustomer").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCustomer = createDocument(nodeList.item(i));
				String customerTypeCode = xPath.compile("//CustomerTypeCode").evaluate(bookingCustomer);
				if (customerTypeCode.equals("B01"))
					return xPath.compile("//Contacts/Contact/PhoneNumber").evaluate(bookingCustomer);
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String contactEml(Document doc, XPath xPath) {
		String nodeData = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingBody/BookingCustomers/BookingCustomer").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCustomer = createDocument(nodeList.item(i));
				String customerTypeCode = xPath.compile("//CustomerTypeCode").evaluate(bookingCustomer);
				if (customerTypeCode.equals("B01")){
					nodeData = xPath.compile("//Contacts/Contact/EmailAddress").evaluate(bookingCustomer);
					break;
				}
			}
			
			String emailAddress = xPath.compile("//BookingBody/BookingAddlParties/BookingAddlParty/EmailAddress").evaluate(doc);
			if(!emailAddress.isEmpty()){
				if(nodeData.isEmpty()){
					nodeData = emailAddress;
				}else{
					nodeData = nodeData + ";" + emailAddress;
				}
//				nodeData = nodeData == ""? emailAddress : nodeData + ";" + emailAddress;
			}
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}

	/**
	 * 
	 * @param Document doc
	 * @param XPath xPath
	 * @param String lineSep
	 * @param String colon
	 * @return
	 */
	private String troGen(Document doc, XPath xPath, String lineSep, String colon) {
		StringBuffer tro = new StringBuffer();
		StringBuffer dtl = new StringBuffer();
		int troSeq = 0;
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document cntrDoc = createDocument(nodeList.item(i));
				String containerSizeTypeCode = xPath.compile("//ContainerSizeTypeCode").evaluate(cntrDoc);

				if (containerSizeTypeCode == null || containerSizeTypeCode.equals(""))
					containerSizeTypeCode = xPath.compile("//ISOContainerSzTypeCode").evaluate(cntrDoc);
				
				NodeList troList = (NodeList) xPath.compile("//BookingAppointments/BookingAppointment").evaluate(cntrDoc, XPathConstants.NODESET);

				String obdr = "OBDR";
				for (int j = 0; j < troList.getLength(); j++) {
					Document troMst = createDocument(troList.item(j));
					String routeLegTypeCode = xPath.compile("//BookingAppointment/RouteLegTypeCode").evaluate(troMst).trim();
					if (troList.getLength() > 0 && obdr.equals(routeLegTypeCode)) {
						++troSeq;
						String groupNumber = String.valueOf(troSeq);
						tro.append("{I_BKG_TRO").append(lineSep);
						tro.append("IB_TRO_SEQ").append(colon).append(groupNumber).append(lineSep);
						tro.append("IB_TRO_ACUST_NM").append(colon).append(xPath.compile("//BookingAppointment/AddresseName").evaluate(troMst)).append(lineSep);

						String addressLine1 = xPath.compile("//BookingAppointment/Address/AddressLine1").evaluate(troMst);
						String addressLine2 = xPath.compile("//BookingAppointment/Address/AddressLine2").evaluate(troMst);
						
						tro.append("IB_TRO_ADDR").append(colon).append(addressLine1).append(lineSep);
						if (addressLine2 != null && !addressLine2.equals(""))
							tro.append("IB_TRO_ADDR").append(colon).append(addressLine2).append(lineSep);


						StringBuffer addressLine3 = new StringBuffer();
						String cityCode = xPath.compile("//BookingAppointment/Address/CityCode").evaluate(troMst);
						String cityname = xPath.compile("//BookingAppointment/Address/CityName").evaluate(troMst);
						String stateProvinceName = xPath.compile("//BookingAppointment/Address/StateProvinceName").evaluate(troMst);
						String countryCode = xPath.compile("//BookingAppointment/Address/CountryCode").evaluate(troMst);
						String unlocCode = xPath.compile("//BookingAppointment/Address/UnlocCode").evaluate(troMst);

						if (cityCode != null && !cityCode.equals("")) {
							addressLine3.append(cityCode).append(" ");
						}
						if (cityname != null && !cityname.equals("")) {
							addressLine3.append(cityname).append(" ");
						}
						if (stateProvinceName != null && !stateProvinceName.equals("")) {
							addressLine3.append(stateProvinceName).append(" ");
						}
						if (countryCode != null && !countryCode.equals("")) {
							addressLine3.append(countryCode).append(" ");
						}
						if (unlocCode != null && !unlocCode.equals("")) {
							addressLine3.append(unlocCode);
						}
						tro.append("IB_TRO_ADDR").append(colon).append(addressLine3.toString()).append(lineSep);

						String contactName = xPath.compile("//BookingAppointment/Contact/ContactName").evaluate(troMst);
						if(contactName != null && contactName.length() > 50) contactName = contactName.substring(0, 50);
						tro.append("IB_TRO_PERSON").append(colon).append(contactName).append(lineSep);
						
						tro.append("IB_TRO_DOOR_LOC").append(colon).append(xPath.compile("//BookingAppointment/Address/UnlocCode").evaluate(troMst)).append(lineSep);
						tro.append("IB_TRO_TEL").append(colon).append(xPath.compile("//BookingAppointment/Contact/PhoneNumber").evaluate(troMst)).append(lineSep);

						String zipCode = xPath.compile("//BookingAppointment/Address/ZipCode").evaluate(troMst);
						tro.append("IB_TRO_ZIP").append(colon).append(zipCode).append(lineSep);
						tro.append("IB_TRO_CNTRTS_CD").append(colon).append(containerSizeTypeCode).append(lineSep);
						
						String remark = xPath.compile("//BookingAppointment/Remarks").evaluate(troMst);
						tro.append("IB_TRO_REMARK").append(colon).append(remark.replaceAll("\n", " ")).append(lineSep);
						
						tro.append("}I_BKG_TRO").append(lineSep);
						for (int o = 0; o < troList.getLength(); o++) {
							Document troDtlDoc = createDocument(troList.item(o));
							
							if(!obdr.equals(xPath.compile("//BookingAppointment/RouteLegTypeCode").evaluate(troDtlDoc).trim()))	continue;
							 
							dtl.append("{I_BKG_TDTL").append(lineSep);
							dtl.append("IB_TRD_SEQ").append(colon).append(groupNumber).append(lineSep);
							dtl.append("IB_TRD_SUBSEQ").append(colon).append(xPath.compile("//AppointmentSequenceNumber").evaluate(troDtlDoc)).append(lineSep);

							dtl.append("IB_CNTRTS_CD").append(colon).append(containerSizeTypeCode).append(lineSep);
							
							String estTimeofArrivalLocal = xPath.compile("//EstTimeofArrivalLocal").evaluate(troDtlDoc);

							if (estTimeofArrivalLocal != null && !estTimeofArrivalLocal.equals(""))
								estTimeofArrivalLocal = estTimeofArrivalLocal.replaceAll("T", " ").replaceAll("-", "").replaceAll(":", "");

							String estTimeofDepartureLocal = xPath.compile("//EstTimeofDepartureLocal").evaluate(troDtlDoc);
							if(estTimeofDepartureLocal != null && !estTimeofDepartureLocal.equals(""))
								estTimeofDepartureLocal = estTimeofDepartureLocal.replaceAll("T", " ").replaceAll("-", "").replaceAll(":", "");
							else
								estTimeofDepartureLocal = estTimeofArrivalLocal;
							
							dtl.append("IB_TRD_PICKUP_DT").append(colon).append(estTimeofDepartureLocal).append(lineSep);
							dtl.append("IB_TRD_REQ_DT").append(colon).append(estTimeofArrivalLocal).append(lineSep);
							dtl.append("IB_TRD_ACUST_NM").append(colon).append(xPath.compile("//AddresseName").evaluate(troDtlDoc)).append(lineSep);

							dtl.append("IB_TRD_ADDR").append(colon).append(addressLine1);
							if (addressLine2 != null && !addressLine2.equals(""))
								dtl.append(" / ").append(addressLine2);
							
							if(addressLine3.toString().length() > 0)
								dtl.append(" / ").append(addressLine3.toString());
							
							dtl.append(lineSep);
							
							dtl.append("IB_TRD_ZIP").append(colon).append(zipCode).append(lineSep);
							dtl.append("IB_TRD_PERSON").append(colon).append(contactName).append(lineSep);
							
							dtl.append("}I_BKG_TDTL").append(lineSep);
						}
						
						//break;
					}
				}
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		// catch (ParseException e) {
		// log.error(e.getMessage(), e);
		// }

		return tro.toString() + dtl.toString();
	}

	/**
	 * 
	 * @param BkgHrdCdgCtntVO vo
	 * @param Document doc
	 * @param XPath xPath
	 * @return
	 */
	private String awkwardCargo(BkgHrdCdgCtntVO vo, Document doc, XPath xPath) {
		String nodeData = "";
		try {
			if (vo.getAttrCtnt2().trim().equalsIgnoreCase("IAK_LGT")) {
				String overLengthFrontQuantity = xPath.compile("//OverLengthFrontQuantity").evaluate(doc);
				String overLengthFrontUnitCode = xPath.compile("//OverLengthFrontUnitCode").evaluate(doc);
				String overLengthBackQuantity = xPath.compile("//OverLengthBackQuantity").evaluate(doc);
				String overLengthBackUnitCode = xPath.compile("//OverLengthBackUnitCode").evaluate(doc);
				if ((overLengthFrontQuantity != null && !overLengthFrontQuantity.isEmpty()) && (overLengthBackQuantity != null && !overLengthBackUnitCode.isEmpty()))
					nodeData = String.valueOf((changeCm(overLengthFrontUnitCode, overLengthFrontQuantity) + changeCm(overLengthBackUnitCode, overLengthBackQuantity)));
			} else if (vo.getAttrCtnt2().trim().equalsIgnoreCase("IAK_HGT")) {
				String overHeightQuantity = xPath.compile("//OverHeightQuantity").evaluate(doc);
				String overHeightUnitCode = xPath.compile("//OverHeightUnitCode").evaluate(doc);

				if ((overHeightQuantity != null && !overHeightUnitCode.isEmpty()))
					nodeData = String.valueOf(changeCm(overHeightUnitCode, overHeightQuantity));
			} else if (vo.getAttrCtnt2().trim().equalsIgnoreCase("IAK_WDT")) {
				String overWidthRightQuantity = xPath.compile("//OverWidthRightQuantity").evaluate(doc);
				String overWidthRightUnitCode = xPath.compile("//OverWidthRightUnitCode").evaluate(doc);
				String overWidthLeftQuantity = xPath.compile("//OverWidthLeftQuantity").evaluate(doc);
				String overWidthLeftUnitCode = xPath.compile("//OverWidthLeftUnitCode").evaluate(doc);

				if ((overWidthRightQuantity != null && !overWidthRightUnitCode.isEmpty()) && (overWidthLeftQuantity != null && !overWidthLeftUnitCode.isEmpty()))
					nodeData = String.valueOf((changeCm(overWidthRightUnitCode, overWidthRightQuantity) + changeCm(overWidthLeftUnitCode, overWidthLeftQuantity)));
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}

//	/**
//	 * 
//	 * @param doc
//	 * @param xPath
//	 * @return
//	 */
//	private String cargoContact(Document doc, XPath xPath) {
//		try {
//			NodeList nodeList = (NodeList) xPath.compile("//CargoContacts").evaluate(doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Document cargoContact = createDocument(nodeList.item(i));
//				String shipmentBoundCode = xPath.compile("//ShipmentBoundCode").evaluate(cargoContact);
//				if (shipmentBoundCode != null && shipmentBoundCode.equals("Outbound")) {
//					return xPath.compile("//ContactName").evaluate(cargoContact) + " " + xPath.compile("//ContactPhoneNumber").evaluate(cargoContact);
//				}
//			}
//		} catch (XPathExpressionException e) {
//			log.error(e.getMessage(), e);
//		}
//		return null;
//	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String grossCargoWeight(Document doc, XPath xPath) {
		String grossCargoWeightUnitCode;
		String grossCargoWeightQuantity = null;
		try {
			grossCargoWeightUnitCode = xPath.compile("//GrossCargoWeightUnitCode").evaluate(doc);
			grossCargoWeightQuantity = xPath.compile("//GrossCargoWeightQuantity").evaluate(doc);
			if (grossCargoWeightUnitCode.equals("LBS"))
				return changeKgs(grossCargoWeightUnitCode, grossCargoWeightQuantity);
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return grossCargoWeightQuantity;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String netWeight(Document doc, XPath xPath) {
		String netCargoWeightUnitCode = null;
		String netCargoWeightQuantity = null;
		double wet = 0.0;
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingCargo").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				netCargoWeightUnitCode = xPath.compile("//NetCargoWeightUnitCode").evaluate(doc);
				netCargoWeightQuantity = xPath.compile("//NetCargoWeightQuantity").evaluate(bookingCargo);
				
				if (netCargoWeightUnitCode.equals("LBS"))
					netCargoWeightQuantity = changeKgs(netCargoWeightUnitCode, netCargoWeightQuantity);
				
				if(netCargoWeightQuantity != null && !netCargoWeightQuantity.equals(""))
					wet = wet + Double.parseDouble(netCargoWeightQuantity);
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return String.valueOf(wet);
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String netCargoWeight(Document doc, XPath xPath) {
		String netCargoWeightUnitCode;
		String netCargoWeightQuantity = null;
		try {
			netCargoWeightUnitCode = xPath.compile("//NetCargoWeightUnitCode").evaluate(doc);
			netCargoWeightQuantity = xPath.compile("//NetCargoWeightQuantity").evaluate(doc);
			if (netCargoWeightUnitCode.equals("LBS"))
				return changeKgs(netCargoWeightUnitCode, netCargoWeightQuantity);
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return netCargoWeightQuantity;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String flashPointTemperature(Document doc, XPath xPath) {
		String flashPointTemperatureQuantity = null;
		String flashPointTemperatureUnitCode = null;
		try {
			flashPointTemperatureQuantity = xPath.compile("//FlashPointTemperatureQuantity").evaluate(doc);
			flashPointTemperatureUnitCode = xPath.compile("//FlashPointTemperatureUnitCode").evaluate(doc);
			if (flashPointTemperatureUnitCode != null && flashPointTemperatureUnitCode.equals("F")) {
				DecimalFormat dformat = new DecimalFormat(".##");
				return String.valueOf(dformat.format((Integer.parseInt(flashPointTemperatureQuantity) - 32) / 1.8));
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return flashPointTemperatureQuantity;
	}

	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String ventilationUnitCode(Document doc, XPath xPath) {
		String unitCode = null;
		try {
			unitCode = xPath.compile("//VentilationUnitCode").evaluate(doc);
			if (unitCode != null && unitCode.equals("cbmPerHour"))
				unitCode = "C";
			else if(unitCode != null && unitCode.equals("cbfPerMin"))
				unitCode = "M";
				
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return unitCode;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String mpaGroupNumber(Document doc, XPath xPath) {
		String mpaGroupNumber = null;
		try {
			mpaGroupNumber = xPath.compile("//MPAGroupNumber").evaluate(doc);
			if (mpaGroupNumber != null && !mpaGroupNumber.equals("")){
				if(mpaGroupNumber.equals("I")){
					mpaGroupNumber = "1";
				}else if(mpaGroupNumber.equals("II")){
					mpaGroupNumber = "2";
				}else if(mpaGroupNumber.equals("III")){
					mpaGroupNumber = "3";
				}
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return mpaGroupNumber;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param command
	 * @return
	 */
	private String originFacilityUnlocCode(Document doc, XPath xPath, EBookingReceiptBC command) {
		String nodeData = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer/ShipmentRouteLegs/ShipmentRouteLeg").evaluate(doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Document shipmentRouteLeg = createDocument(nodeList.item(i));
//				String transportModeCode = xPath.compile("//ShipmentRouteLeg/TransportModeCode").evaluate(shipmentRouteLeg);
//				if(transportModeCode.equals("Vessel")){
//					nodeData = xPath.compile("//ShipmentRouteLeg/OriginFacility/Address/UnlocCode").evaluate(shipmentRouteLeg);
//					break;
//				}
//			}
//			
//			if(nodeData.equals("")){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String routeLegTypeCode = xPath.compile("//ShipmentRouteLeg/RouteLegTypeCode").evaluate(shipmentRouteLeg);
					if(routeLegTypeCode.equals("TRNK")){
						nodeData = xPath.compile("//ShipmentRouteLeg/OriginFacility/Address/UnlocCode").evaluate(shipmentRouteLeg);
						if(nodeData.equals("")){
							nodeData = xPath.compile("//ShipmentRouteLeg/OriginFacility/Address/CityCode").evaluate(shipmentRouteLeg);
							if(nodeData.length() > 5){
								nodeData = nodeData.substring(0, 5);
							}
						}
						break;
					}
				}
//			}
			
			if (!nodeData.equals(""))
				nodeData = command.getUnlocCodeToLocCd(nodeData);
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		} catch (EventException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String loadPortName(Document doc, XPath xPath) {
		String nodeData = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer/ShipmentRouteLegs/ShipmentRouteLeg").evaluate(doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Document shipmentRouteLeg = createDocument(nodeList.item(i));
//				String transportModeCode = xPath.compile("//ShipmentRouteLeg/TransportModeCode").evaluate(shipmentRouteLeg);
//				if(transportModeCode.equals("Vessel")){
//					nodeData = xPath.compile("//ShipmentRouteLeg/LoadPortName").evaluate(shipmentRouteLeg);
//					break;
//				}
//			}
//			
//			if(nodeData.equals("")){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String routeLegTypeCode = xPath.compile("//ShipmentRouteLeg/RouteLegTypeCode").evaluate(shipmentRouteLeg);
					if(routeLegTypeCode.equals("TRNK")){
						nodeData = xPath.compile("//ShipmentRouteLeg/LoadPortName").evaluate(shipmentRouteLeg);
						
						if(nodeData.equals(""))
							nodeData = xPath.compile("//ShipmentRouteLeg/OriginFacility/Address/CityName").evaluate(shipmentRouteLeg);
						break;
					}
				}
//			}
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		} 
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String dischargePortName(Document doc, XPath xPath) {
		String nodeData = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer/ShipmentRouteLegs/ShipmentRouteLeg").evaluate(doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Document shipmentRouteLeg = createDocument(nodeList.item(i));
//				String transportModeCode = xPath.compile("//ShipmentRouteLeg/TransportModeCode").evaluate(shipmentRouteLeg);
//				if(transportModeCode.equals("Vessel")){
//					nodeData = xPath.compile("//ShipmentRouteLeg/DischargePortName").evaluate(shipmentRouteLeg);
//					break;
//				}
//			}
//			
//			if(nodeData.equals("")){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String routeLegTypeCode = xPath.compile("//ShipmentRouteLeg/RouteLegTypeCode").evaluate(shipmentRouteLeg);
					if(routeLegTypeCode.equals("TRNK")){
						nodeData = xPath.compile("//ShipmentRouteLeg/DischargePortName").evaluate(shipmentRouteLeg);
						if(nodeData.equals(""))
							nodeData = xPath.compile("//ShipmentRouteLeg/DestinationFacility/Address/CityName").evaluate(shipmentRouteLeg);
						break;
					}
				}
//			}
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		} 
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param command
	 * @return
	 */
	private String destinationFacilityUnlocCode(Document doc, XPath xPath, EBookingReceiptBC command) {
		String nodeData = "";
		int vesselLstRow = -1;
		String unlocCode = "";
		try {
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer/ShipmentRouteLegs/ShipmentRouteLeg").evaluate(doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Document shipmentRouteLeg = createDocument(nodeList.item(i));
//				String transportModeCode = xPath.compile("//ShipmentRouteLeg/TransportModeCode").evaluate(shipmentRouteLeg);
//				if(transportModeCode.equals("Vessel")){
//					vesselLstRow = i;
//				}
//			}
			
			if(vesselLstRow == -1){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String routeLegTypeCode = xPath.compile("//ShipmentRouteLeg/RouteLegTypeCode").evaluate(shipmentRouteLeg);
					if(routeLegTypeCode.equals("TRNK")){
						vesselLstRow = i;
						break;
					}
				}
			}
			
			if (vesselLstRow > -1){
				Document shipmentRouteLeg = createDocument(nodeList.item(vesselLstRow));
				
				String 	cityCode = xPath.compile("//ShipmentRouteLeg/DestinationFacility/Address/CityCode").evaluate(shipmentRouteLeg);
				String 	cityName = xPath.compile("//ShipmentRouteLeg/DestinationFacility/Address/CityName").evaluate(shipmentRouteLeg);
				String 	dischargePortCode = xPath.compile("//ShipmentRouteLeg/DischargePortCode").evaluate(shipmentRouteLeg);
				String 	dischargePortName = xPath.compile("//ShipmentRouteLeg/DischargePortName").evaluate(shipmentRouteLeg);
				
				if(cityCode.equals(dischargePortCode) || cityName.equals(dischargePortName)){
					unlocCode = xPath.compile("//ShipmentRouteLeg/DestinationFacility/Address/UnlocCode").evaluate(shipmentRouteLeg);
					if(unlocCode.equals("")) unlocCode = xPath.compile("//ShipmentRouteLeg/DestinationFacility/Address/CityCode").evaluate(shipmentRouteLeg);
					nodeData = command.getUnlocCodeToLocCd(unlocCode);
					if(nodeData == null || nodeData.equals("")){
						if(unlocCode.length() > 5){
							unlocCode = unlocCode.substring(0, 5);
						}
						nodeData = unlocCode;
					}
				}
			}
		} catch (EventException e) {
			log.error(e.getMessage(), e);
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param document
	 * @return
	 */
	private String grossCargoWeightQuantity(Document doc, XPath xPath, Document document){
		String nodeData = null;
		try {
			nodeData = xPath.compile("//GrossCargoWeightQuantity").evaluate(doc);
			if(nodeData.equals("")){
				String groupNumer = xPath.compile("//GroupNumber").evaluate(doc);
				String seqNumber = xPath.compile("//SeqNumber").evaluate(doc);
				
				NodeList nodeList = (NodeList) xPath.compile("//nyk_sdi_msg/sdi_msgBody/BookingBody/BookingCargos/BookingCargo").evaluate(document, XPathConstants.NODESET);
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document bookingCargo = createDocument(nodeList.item(i));
					String cargoGroupNumer = xPath.compile("//GroupNumber").evaluate(bookingCargo);
					String cargoSeqNumber = xPath.compile("//SeqNumber").evaluate(bookingCargo);
					if(groupNumer.equals(cargoGroupNumer) && seqNumber.equals(cargoSeqNumber)){
						nodeData = xPath.compile("//GrossCargoWeightQuantity").evaluate(bookingCargo);
						break;
					}
				}
			}
				
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param document
	 * @return
	 */
	private String grossCargoWeightUnitCode(Document doc, XPath xPath, Document document){
		String nodeData = null;
		try {
			nodeData = xPath.compile("//GrossCargoWeightUnitCode").evaluate(doc);
			if(nodeData.equals("")){
				String groupNumer = xPath.compile("//GroupNumber").evaluate(doc);
				String seqNumber = xPath.compile("//SeqNumber").evaluate(doc);
				
				NodeList nodeList = (NodeList) xPath.compile("//nyk_sdi_msg/sdi_msgBody/BookingBody/BookingCargos/BookingCargo").evaluate(document, XPathConstants.NODESET);
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document bookingCargo = createDocument(nodeList.item(i));
					String cargoGroupNumer = xPath.compile("//GroupNumber").evaluate(bookingCargo);
					String cargoSeqNumber = xPath.compile("//SeqNumber").evaluate(bookingCargo);
					if(groupNumer.equals(cargoGroupNumer) && seqNumber.equals(cargoSeqNumber)){
						nodeData = xPath.compile("//GrossCargoWeightUnitCode").evaluate(bookingCargo);
						break;
					}
				}
			}
				
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param document
	 * @return
	 */
	private String packageType(Document doc, XPath xPath, Document document){
		String nodeData = null;
		try {
			String groupNumer = xPath.compile("//GroupNumber").evaluate(doc);
			String seqNumber = xPath.compile("//SeqNumber").evaluate(doc);
			
			NodeList nodeList = (NodeList) xPath.compile("//nyk_sdi_msg/sdi_msgBody/BookingBody/BookingCargos/BookingCargo").evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				String cargoGroupNumer = xPath.compile("//GroupNumber").evaluate(bookingCargo);
				String cargoSeqNumber = xPath.compile("//SeqNumber").evaluate(bookingCargo);
				if(groupNumer.equals(cargoGroupNumer) && seqNumber.equals(cargoSeqNumber)){
					nodeData = xPath.compile("//BookingCargoPackages/BookingCargoPackage/PackageType").evaluate(bookingCargo);
					if(nodeData != null && nodeData.length() > 2) nodeData = "";
					break;
				}
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param document
	 * @return
	 */
	private String mesureType(Document doc, XPath xPath, Document document){
		String nodeData = null;
		try {
			String groupNumer = xPath.compile("//GroupNumber").evaluate(doc);
			String seqNumber = xPath.compile("//SeqNumber").evaluate(doc);
			
			NodeList nodeList = (NodeList) xPath.compile("//nyk_sdi_msg/sdi_msgBody/BookingBody/BookingCargos/BookingCargo").evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				String cargoGroupNumer = xPath.compile("//GroupNumber").evaluate(bookingCargo);
				String cargoSeqNumber = xPath.compile("//SeqNumber").evaluate(bookingCargo);
				if(groupNumer.equals(cargoGroupNumer) && seqNumber.equals(cargoSeqNumber)){
					nodeData = xPath.compile("//GrossCargoVolumeUnitCode").evaluate(bookingCargo);
					break;
				}
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String containerSizeTypeCode(Document doc, XPath xPath){
		String nodeData = null;
		try {
			nodeData = xPath.compile("//ContainerSizeTypeCode").evaluate(doc);

			if (nodeData == null || nodeData.equals(""))
				nodeData = xPath.compile("//ISOContainerSzTypeCode").evaluate(doc);
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param document
	 * @return
	 */
	private String mesureCount(Document doc, XPath xPath, Document document){
		String nodeData = null;
		try {
			String groupNumer = xPath.compile("//GroupNumber").evaluate(doc);
			String seqNumber = xPath.compile("//SeqNumber").evaluate(doc);
			
			NodeList nodeList = (NodeList) xPath.compile("//nyk_sdi_msg/sdi_msgBody/BookingBody/BookingCargos/BookingCargo").evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				String cargoGroupNumer = xPath.compile("//GroupNumber").evaluate(bookingCargo);
				String cargoSeqNumber = xPath.compile("//SeqNumber").evaluate(bookingCargo);
				if(groupNumer.equals(cargoGroupNumer) && seqNumber.equals(cargoSeqNumber)){
					nodeData = xPath.compile("//GrossCargoVolumeQuantity").evaluate(bookingCargo);
					break;
				}
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @param document
	 * @return
	 */
	private String packageCount(Document doc, XPath xPath, Document document){
		String nodeData = null;
		try {
			String groupNumer = xPath.compile("//GroupNumber").evaluate(doc);
			String seqNumber = xPath.compile("//SeqNumber").evaluate(doc);
			
			NodeList nodeList = (NodeList) xPath.compile("//nyk_sdi_msg/sdi_msgBody/BookingBody/BookingCargos/BookingCargo").evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				String cargoGroupNumer = xPath.compile("//GroupNumber").evaluate(bookingCargo);
				String cargoSeqNumber = xPath.compile("//SeqNumber").evaluate(bookingCargo);
				if(groupNumer.equals(cargoGroupNumer) && seqNumber.equals(cargoSeqNumber)){
					nodeData = xPath.compile("//BookingCargoPackages/BookingCargoPackage/PackageCount").evaluate(bookingCargo);
					break;
				}
			}
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String estDepOrgnLocalDate(Document doc, XPath xPath){
		String nodeData = null;
		try {
			nodeData = xPath.compile("//BookingBody/EstDepOrgnLocalDate").evaluate(doc);
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer/ShipmentRouteLegs/ShipmentRouteLeg").evaluate(doc, XPathConstants.NODESET);
			if(nodeData.equals("")){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String transportModeCode = xPath.compile("//ShipmentRouteLeg/RouteLegTypeCode").evaluate(shipmentRouteLeg);
					if(transportModeCode.equals("OBDR")){
						nodeData = xPath.compile("//EstDepOrgnLocalDate").evaluate(shipmentRouteLeg);
						break;
					}
				}
			}
			
			if(!nodeData.equals(""))
				nodeData = nodeData.replaceAll("T", " ").replaceAll("-", "").replaceAll(":", "");
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String earlyDepartureDate(Document doc, XPath xPath){
		String nodeData = null;
		try {
			nodeData = xPath.compile("//EarlyDepartureDate").evaluate(doc);
			NodeList nodeList = (NodeList) xPath.compile("//BookingContainers/BookingContainer/ShipmentRouteLegs/ShipmentRouteLeg").evaluate(doc, XPathConstants.NODESET);
			if(nodeData.equals("")){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String transportModeCode = xPath.compile("//ShipmentRouteLeg/TransportModeCode").evaluate(shipmentRouteLeg);
					if(transportModeCode.equals("Vessel")){
						nodeData = xPath.compile("//EstDepOrgnLocalDate").evaluate(shipmentRouteLeg);
						break;
					}
				}
			}
			
			if(nodeData.equals("")){
				for (int i = 0; i < nodeList.getLength(); i++) {
					Document shipmentRouteLeg = createDocument(nodeList.item(i));
					String routeLegTypeCode = xPath.compile("//ShipmentRouteLeg/RouteLegTypeCode").evaluate(shipmentRouteLeg);
					if(routeLegTypeCode.equals("TRNK")){
						nodeData = xPath.compile("//EstDepOrgnLocalDate").evaluate(shipmentRouteLeg);
						break;
					}
				}
			}
			
			if(!nodeData.equals(""))
				nodeData = nodeData.replaceAll("T", " ").replaceAll("-", "").replaceAll(":", "");
			
		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String commodityCode(Document doc, XPath xPath){
		String nodeData = null;
		try{
			String commodityCode = xPath.compile("//BookingCargos/BookingCargo/Commodity/CommodityCode").evaluate(doc);
			if(commodityCode != null && commodityCode.length() <= 6){
				nodeData = commodityCode;
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String cargoPackageType(Document doc, XPath xPath){
		String nodeData = null;
		try{
			nodeData = xPath.compile("//BookingCargos/BookingCargo/BookingCargoPackages/BookingCargoPackage/PackageType").evaluate(doc);
			if(nodeData.length() > 2) nodeData = nodeData.substring(0, 2);
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String cargoPackageCount(Document doc, XPath xPath){
		double packageCount = 0;
		try{
			NodeList nodeList = (NodeList) xPath.compile("//BookingCargos/BookingCargo/BookingCargoPackages/BookingCargoPackage").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargoPackage = createDocument(nodeList.item(i));
				String count = xPath.compile("//BookingCargoPackage/PackageCount").evaluate(bookingCargoPackage);
				if(count.equals("")) continue;
				packageCount = packageCount + Double.parseDouble(count);
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return String.valueOf(packageCount);
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String cargoWeightUnitCode(Document doc, XPath xPath){
		String nodeData = null;
		try{
			nodeData = xPath.compile("//BookingCargos/BookingCargo/GrossCargoWeightUnitCode").evaluate(doc);
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String cargoWeightQuantity(Document doc, XPath xPath){
		double quantityCount = 0;
		try{
			NodeList nodeList = (NodeList) xPath.compile("//BookingCargos/BookingCargo").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				String quantity = xPath.compile("//GrossCargoWeightQuantity").evaluate(bookingCargo);
				if(quantity.equals("")) continue;
				quantityCount = quantityCount + Double.parseDouble(quantity);
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return String.valueOf(quantityCount);
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String cargoVolumeUnitCode(Document doc, XPath xPath){
		String nodeData = null;
		try{
			nodeData = xPath.compile("//BookingCargos/BookingCargo/GrossCargoVolumeUnitCode").evaluate(doc);
			if(nodeData.equalsIgnoreCase("CFT")) nodeData = "CBF";
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return nodeData;
	}
	
	/**
	 * 
	 * @param doc
	 * @param xPath
	 * @return
	 */
	private String cargoVolumeQuantity(Document doc, XPath xPath){
		double quantityCount = 0;
		try{
			NodeList nodeList = (NodeList) xPath.compile("//BookingCargos/BookingCargo").evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Document bookingCargo = createDocument(nodeList.item(i));
				String quantity = xPath.compile("//GrossCargoVolumeQuantity").evaluate(bookingCargo);
				if(quantity.equals("")) continue;
				//DecimalFormat _numberFormat= new DecimalFormat("#" + quantity);
				quantityCount = quantityCount + Double.parseDouble(quantity);
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return String.valueOf(quantityCount);
	}

	/**
	 * 
	 * @param String type
	 * @param String no
	 * @return
	 */
	private double changeCm(String type, String no) {
		Double cm = null;
		if (type.equalsIgnoreCase("CM")) {
			cm = changeStringToCm(no);
		} else if (type.equalsIgnoreCase("FT")) {
			cm = changeFeetToCm(no);
		} else if (type.equalsIgnoreCase("Meter")) {
			cm = changeMeterToCm(no);
		}
		return cm;
	}

	/**
	 * 
	 * @param type
	 * @param no
	 * @return
	 */
	private String changeKgs(String type, String no) {
		String kgs = null;
		if (type.equalsIgnoreCase("LBS"))
			kgs = changeLbsTokgs(no);

		return kgs;
	}

	/**
	 * 
	 * @param lbs
	 * @return
	 */
	private String changeLbsTokgs(String lbs) {
		double lb = Double.valueOf(lbs);
		double kg = lb / 2.20462;
		DecimalFormat dformat = new DecimalFormat(".###");
		return dformat.format(kg);
	}

	/**
	 * 
	 * @param String feetNo
	 * @return
	 */
	private double changeFeetToCm(String feetNo) {
		double feet = Double.parseDouble(feetNo);
		double cm = feet / 30.48;
		return Double.parseDouble(String.format("%.2f", cm));
	}

	/**
	 * 
	 * @param String meter
	 * @return
	 */
	private double changeMeterToCm(String meter) {
		double meters = Double.parseDouble(meter);
		double cm = meters * 100;
		return Double.parseDouble(String.format("%.2f", cm));
	}

	/**
	 * 
	 * @param String str
	 * @return
	 */
	private double changeStringToCm(String str) {
		return Double.parseDouble(str);
	}

	/**
	 * 
	 * @param String filterData
	 * @param String dataNode
	 * @return
	 */
	private boolean checkFilterData(String filterData, String dataNode) {
		String[] filterDatas = null;
		if (filterData.indexOf(",") > -1) {
			filterDatas = filterData.split(",");
		} else {
			filterDatas = new String[] { filterData };
		}

		for (int i = 0; i < filterDatas.length; i++) {
			if (filterDatas[i].equals(dataNode.trim()))
				return true;
		}

		return false;
	}

	/**
	 * 
	 * @param Node node
	 * @return
	 */
	private String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		} catch (TransformerException te) {
			log.error(te.getMessage(), te);
		}
		return sw.toString();
	}

	/**
	 * 
	 * @param Node node
	 * @return
	 */
	private Document createDocument(Node node) {
		return createDocument(nodeToString(node));
	}

	/**
	 * 
	 * @param String node
	 * @return
	 */
	private Document createDocument(String node) {
		Document document = null;
		try {
			InputStream is = new ByteArrayInputStream(node.getBytes());
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			document = db.parse(is);
			is.close();
		} catch (ParserConfigurationException pe) {
			log.error(pe.getMessage(), pe);
		} catch (SAXException se) {
			log.error(se.getMessage(), se);
		} catch (IOException ie) {
			log.error(ie.getMessage(), ie);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return document;
	}
}
