/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtBCImpl.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.16 신혜정 [CHM-201115121-01] 유저아이디 Office Change 로 로긴정보 중 RHQ 변경 안되는 로직 보완
* 2011.12.27 신혜정 [CHM-201115280] Estimate Creation 화면 Reefer Uint Maker 필드 추가
* 2014-03-31 by Jonghee HAN 선반영 CSR Ticket : CHM-201429703, Title : ALPS MNR-Disposal Request 시, Office Code 변경에 따른 Approval Office 변경 요청, 부산지역 조직통합으로 Disposal Request시 Approval Office 선택을 위한 PUSSC Office Code 추가  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCurrXchRtVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomLocalDateVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomSPPOFCVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomUnitPriceVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EtcInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.GeneralCodeSearchGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
	
/**
 * alps-MNRCommon Business Logic Basic Command implementation<br>
 * - alps-MNRCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin
 * @see EES_MNR_INITEventResponse,GeneralCodeSearchMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4  
 */
	
public  class GeneralCodeSearchMgtBCImpl extends BasicCommandSupport implements GeneralCodeSearchMgtBC {

	// Database Access Object
	private transient GeneralCodeSearchMgtDBDAO dbDao = null;

	//컨테이너 타입 변수	 	
	private String container = "U";
	private String chassis = "Z"; 
	private String mgSet = "G";  
		
	/**
	 * GeneralCodeSearchMgtBCImpl 객체 생성<br>
	 * GeneralCodeSearchMgtDBDAO를 생성한다.<br>
	 */
	public GeneralCodeSearchMgtBCImpl() {
		dbDao = new GeneralCodeSearchMgtDBDAO();
	}
	
	/**
	 * [EES_MNR_0011] 스탠다드 타리프의 EQ TYPE별 디폴트 Unit Of Measure를 구합니다. <br>
	 *
	 * @param DefaultUnitOfMeasureVO inDefaultUnitOfMeasureVO
	 * @return DefaultUnitOfMeasureVO
	 * @exception EventException 
	 */   
	public DefaultUnitOfMeasureVO searchDEFUnitOfMeasureBasic(DefaultUnitOfMeasureVO inDefaultUnitOfMeasureVO) throws EventException {
		try {   	
			DefaultUnitOfMeasureVO defaultUnitOfMeasureVO = dbDao.searchDEFUnitOfMeasureData(inDefaultUnitOfMeasureVO);	
			return defaultUnitOfMeasureVO ; 
		} catch (DAOException ex) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R COMMON] searchDEFUnitOfMeasureBasic"}).getMessage(),ex);
		} catch (Exception ex) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R COMMON] searchDEFUnitOfMeasureBasic"}).getMessage(),ex);
		}	
	}		
	
	/**
	 * [EES_MNR_0189]M&R Service Provider Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO
	 * @return ServiceProviderInfoListGRPVO
	 * @exception EventException
	 */
	public ServiceProviderInfoListGRPVO searchServiceProviderInfoListBasic(ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO) throws EventException {
		try {  	
			serviceProviderInfoListGRPVO.setCustomMdmVendorVOS(dbDao.searchServiceProviderInfoListData(serviceProviderInfoListGRPVO.getServiceProviderInfoListINVO()));
			return serviceProviderInfoListGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Service Provider Inquiry_Pop Up] searchServiceProviderInfoListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Service Provider Inquiry_Pop Up] searchServiceProviderInfoListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [MNR_COMMON] 공통콤보를 조회합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @param SignOnUserAccount 	 account
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */ 
	public GeneralCodeSearchGRPVO searchComboInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO,SignOnUserAccount account) throws EventException {
		try {	   	
			ComboInitDataINVO[] comboInitDataINVOS = generalCodeSearchGRPVO.getComboInitDataINVOS();
				
			List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVOS = new ArrayList<List<CustomMnrGeneralCodeVO>>(); 
			for (int i = 0; i < comboInitDataINVOS.length ; i++){ 
				if(comboInitDataINVOS[i].getSearchinfo().equals("MnrGenCd")){                               
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrGenCdData(comboInitDataINVOS[i],account));   
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MdmCurrency")){                      
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMdmCurrencyData(comboInitDataINVOS[i]));  
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MdmVendor")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMdmVendorData(comboInitDataINVOS[i]));  
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("EqTpSz")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchEqTpSzData(comboInitDataINVOS[i]));  					
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("ComUser")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchComUserData(comboInitDataINVOS[i]));  					
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrEqCmpoCd")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrEqCmpoCdData(comboInitDataINVOS[i]));  		
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrEqCmpoCdByEqType")){			
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrEqCmpoCdByEqTypeData(comboInitDataINVOS[i]));  		
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrEqCmpoUpCd")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrEqCmpoUpCdData(comboInitDataINVOS[i]));  		
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrCedexOthCd")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrCedexOthCdData(comboInitDataINVOS[i]));  
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrEqLocCd")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrEqLocCdData(comboInitDataINVOS[i])); 
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrFldQltyAudRslt")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrFldQltyAudRsltData(comboInitDataINVOS[i]));
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrOnsiteInspectionResultHistory")){ // 2015515
                    listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrOnsiteInspectionResultHistory(comboInitDataINVOS[i]));	
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrAgmtHdr")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrAgmtHdrData(comboInitDataINVOS[i])); 
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrDivCd")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrDivisionCodeData(comboInitDataINVOS[i])); 					
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrRprCd")){					
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMnrRepairCodeData(comboInitDataINVOS[i])); 					
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("ComIntgCd")){
					listCustomMnrGeneralCodeVOS.add(dbDao.searchComIntgCodeData(comboInitDataINVOS[i])); 
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MdmOrganization")){ 
					if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("RHQ")){
						listCustomMnrGeneralCodeVOS.add(dbDao.searchRhqOfcCdData(comboInitDataINVOS[i]));
					}else if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("RHQplus")){
						listCustomMnrGeneralCodeVOS.add(dbDao.searchRhqOfcCdPlusData(comboInitDataINVOS[i]));
					} else if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("RPRINV")){
						listCustomMnrGeneralCodeVOS.add(dbDao.searchRprInvOfcCdData(comboInitDataINVOS[i]));
					}else if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("RHQCHG")){
						listCustomMnrGeneralCodeVOS.add(dbDao.searchRhqOfcChgCdData(comboInitDataINVOS[i]));						
					}else if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("COUNTRY")){
						listCustomMnrGeneralCodeVOS.add(dbDao.searchCountryByRhqOfcCdData(comboInitDataINVOS[i]));						
					}else if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("OFCBYCOUNTRY")){
						listCustomMnrGeneralCodeVOS.add(dbDao.searchOfcCdByCountryData(comboInitDataINVOS[i]));						
					}else {		
						listCustomMnrGeneralCodeVOS.add(dbDao.searchOfcCdFromRhqData(comboInitDataINVOS[i]));
					}		
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("MnrOfcGenInfo")){ 
					//OFC 없으면 그냥 account 에서 넣어준다.   
					if(comboInitDataINVOS[i].getSearchkey().equals("") || comboInitDataINVOS[i].getSearchkey() == null){
						if(comboInitDataINVOS[i].getSearchcon().equalsIgnoreCase("DISP")){
							//OFC가 PUSBTE 인 경우는 SELCON로 세팅한다.
							//2014-03-31 by Jonghee HAN CSR ID : , Title : , 부산지역 조직통합으로 Disposal Request시 Approval Office 선택을 위한 PUSSC Office Code 추가
							String ofcCd = account.getOfc_cd().toUpperCase().trim();
							if(ofcCd.equals("PUSBO") || ofcCd.equals("SELCON") || ofcCd.equals("PUSSC") || ofcCd.equals("TYOSC") || ofcCd.equals("OSASO") ){
								comboInitDataINVOS[i].setSearchkey(ofcCd);	            
							} else {
								comboInitDataINVOS[i].setSearchkey(account.getRhq_ofc_cd()); 
							}
						} else {		  
							comboInitDataINVOS[i].setSearchkey(account.getOfc_cd()); 
						} 				 
					}			    	
					listCustomMnrGeneralCodeVOS.add(dbDao.searchOfcComboCodeListData(comboInitDataINVOS[i])); 
				} else if(comboInitDataINVOS[i].getSearchinfo().equals("MdmCurrencyPrcsKnt")){                      
					listCustomMnrGeneralCodeVOS.add(dbDao.searchMdmCurrencyPrcsKntData(comboInitDataINVOS[i]));  
				} else if(comboInitDataINVOS[i].getSearchinfo().equals("PrntVndrSeq")){                      
					listCustomMnrGeneralCodeVOS.add(dbDao.searchPrntVndrSeqData(comboInitDataINVOS[i]));  
							
				//EES_MNR_QEXE
				}else if(comboInitDataINVOS[i].getSearchinfo().equals("EesMnrQexe")){
					List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVOS = new ArrayList<CustomMnrGeneralCodeVO>(); 
					String[] qyerys = comboInitDataINVOS[i].getSearchkey().split(";");
					//EXE
					if(!comboInitDataINVOS[i].getSearchcon().equalsIgnoreCase("GET")){ 
						for(int x = 0; x < qyerys.length; x++){
							//특수 문자열 제거       
							String tempString = qyerys[x].replaceAll("\n","");  
							tempString = tempString.replaceAll(";","");			  
							//&는  url 연결자 이므로 ☞ 변경 해서 다시 원복한다.
							tempString = tempString.replaceAll("☞","&");	 	
							
							qyerys[x] = tempString;					 
							//System.out.println(qyerys[x]); 
							int runCount = Integer.parseInt(comboInitDataINVOS[i].getSearchcon());
								
							int result = 0;
							StringBuilder sb = new StringBuilder("");
							for(int k = 0; k < runCount;k ++){
								result = dbDao.modifyMnrQexeData(qyerys[x]); 
								sb.append(k + 1 + ":").append(String.valueOf(result));
											
								if(k != (runCount - 1)){
									sb.append("☞");  	
								} 			
							}		
							  	
							CustomMnrGeneralCodeVO customMnrGeneralCodeVO = new CustomMnrGeneralCodeVO();
							customMnrGeneralCodeVO.setCdId(qyerys[x]);
							customMnrGeneralCodeVO.setCdDesc(sb.toString());
							customMnrGeneralCodeVOS.add(customMnrGeneralCodeVO);
						}	 
						listCustomMnrGeneralCodeVOS.add(customMnrGeneralCodeVOS); 
					//GET	
					} else {
						for(int x = 0; x < qyerys.length; x++){
							//특수 문자열 제거	
							String tempString = qyerys[x].replaceAll("\n","");
							tempString = tempString.replaceAll(";","");  
							//&는  url 연결자 이므로 ☞ 변경 해서 다시 원복한다.
							tempString = tempString.replaceAll("☞","&");
							qyerys[x] = tempString.toUpperCase(); 	
							
							int cur = qyerys[x].indexOf("FROM");
							String tabName  = "";	
							
							//FROM 절이 있을때만 
							if(cur != -1){
								int tabStartIdx = cur + 5;
								int nextSpace = qyerys[x].indexOf(" ",tabStartIdx);      
								int nextLine = qyerys[x].indexOf("WHERE",tabStartIdx);   
								int settingIdx = 0;
							     		
								boolean isNeedIdx = false;
								if(nextSpace == -1 && nextLine == -1){
									settingIdx = qyerys[x].length(); 
								} else {
									if(nextSpace == -1) nextSpace = 500000;
									if(nextLine == -1) nextLine = 500000;  
									isNeedIdx = true;   	
								}
									
								if(isNeedIdx){
									if(nextLine < nextSpace){
										settingIdx = nextLine; 
									} else {
										settingIdx = nextSpace;
									}  
								} 
								    
								tabName = qyerys[x].substring(tabStartIdx, settingIdx).trim(); 
									
								//Query 가 * 를 포함할경우 	
								if(qyerys[x].indexOf("*") != -1){ 	
									
									DBRowSet colInfo = dbDao.searchTabColInfoData(tabName);  
									StringBuilder sb = new StringBuilder("\n");
									while(colInfo.next()){             
										sb.append("\t" + colInfo.getString("COLUMN_NAME")); 
											
									 	if(!colInfo.isLast()){      
											sb.append(",\n");   
										} else {
											sb.append("\n"); 
										}
									}   
									qyerys[x] = qyerys[x].replace("*", sb.toString()).trim();
								}
								     	  
								//search data	  
								DBRowSet dbRowset = dbDao.searchMnrQexeData(qyerys[x]);
								     
								ResultSetMetaData meta = dbRowset.getMetaData();
								int colCount = meta.getColumnCount() + 1;
								StringBuffer retQuery = new StringBuffer();   
								while(dbRowset.next()){
								    retQuery.setLength(0);
									retQuery.append("INSERT INTO " + tabName + " (\n");
									for(int j = 1; j < colCount; j++)
					                {
										String columnName = dbRowset.getMetaData().getColumnName(j).toUpperCase();
										retQuery.append(columnName);;
										if(j != (colCount - 1)){
										    retQuery.append(",\n");    
										} else {
										    retQuery.append("\n");	
										}	
					                } 	
									retQuery .append(") VALUES (\n"); 
									
									for(int j = 1; j < colCount; j++) 
					                {
										String columnName = dbRowset.getMetaData().getColumnName(j).toUpperCase();
										Object columnValue = null;
										columnValue = dbRowset.getObject(j);
										String dateString = "";	
											
										if(columnValue != null){	
											if(columnName.toString().endsWith("_DT")){	
												String tempStr = columnValue.toString();
												if(tempStr.lastIndexOf(".") != -1){			
													tempStr = tempStr.substring(0,tempStr.lastIndexOf("."));
												}		
													
												//dateString = "TO_DATE(\'" + tempStr + "\',\'YYYY-MM-DD HH24:MI:SS\')";	
												dateString = "SYSDATE";    
												retQuery.append(dateString);		
											} else {
												 retQuery.append("'" + columnValue.toString() + "'");	
											}
										} else {
										    retQuery.append("''");     
										}
																			
										if(j != (colCount - 1)){	
										    retQuery.append(",\n"); 
										} else {
										    retQuery.append("\n");
										}
					                }     
									 			
									retQuery.append(");\n");      
									CustomMnrGeneralCodeVO customMnrGeneralCodeVO = new CustomMnrGeneralCodeVO();
									customMnrGeneralCodeVO.setCdId(qyerys[x]);
									customMnrGeneralCodeVO.setCdDesc(retQuery.toString());
									customMnrGeneralCodeVOS.add(customMnrGeneralCodeVO); 
								}
								listCustomMnrGeneralCodeVOS.add(customMnrGeneralCodeVOS);   	
							} else {
								CustomMnrGeneralCodeVO customMnrGeneralCodeVO = new CustomMnrGeneralCodeVO();
								customMnrGeneralCodeVO.setCdId(qyerys[x]);
								customMnrGeneralCodeVO.setCdDesc("NOT SELECT QUERY"); 
								customMnrGeneralCodeVOS.add(customMnrGeneralCodeVO);
							}
							listCustomMnrGeneralCodeVOS.add(customMnrGeneralCodeVOS); 
						}	
					}				
				}		
			}                 
			generalCodeSearchGRPVO.setListCustomMnrGeneralCodeVOS(listCustomMnrGeneralCodeVOS);   
			   
			return generalCodeSearchGRPVO;    
		} catch (DAOException ex) {    	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchComboInitDataListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchComboInitDataListBasic"}).getMessage(),e);
		}  
	} 
	
	/**
	 * [MNR_COMMON] MnrComSearchGrid 공통 코드를 조회합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO	
	 * @exception EventException	
	 */
	public GeneralCodeSearchGRPVO searchCommonInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException {
		try {  
			/////////////////////////////////////////////////////////////
			// 1. MnrComSearchGrid
			// "type_size_search_ind" - typeSize(타입사이즈 코드)
			// "com_code_search_ind"  - FQA Result Description Code
			// 	 			
			// 2. MnrComSearchGrid2 
			// active type size 				- "ACTTypeSize" 
 			// disposal type size   			- "DSPTypeSize"
			/////////////////////////////////////////////////////////////
			  			
			//코드종류가 typeSize인 경우(type_size_search_ind)
			if(generalCodeSearchGRPVO.getCommonInitDataINVO().getTypeSizeSearchInd().equals("Y")) {
				List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVO = new ArrayList<List<CustomMnrGeneralCodeVO>>(); 
				
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd(container);
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO0 = dbDao.searchTypeSizeListData(generalCodeSearchGRPVO.getCommonInitDataINVO());
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd(chassis); 
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO1 = dbDao.searchTypeSizeListData(generalCodeSearchGRPVO.getCommonInitDataINVO());
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd(mgSet);
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO2 = dbDao.searchTypeSizeListData(generalCodeSearchGRPVO.getCommonInitDataINVO());
					
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO0);  
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO1);  
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO2);  
				 
				generalCodeSearchGRPVO.setListCustomMnrGeneralCodeVOS(listCustomMnrGeneralCodeVO);   
			//코드종류가 active type size 인 경우
			} if(generalCodeSearchGRPVO.getCommonInitDataINVO().getCodeType().equals("ACTTypeSize")) {
				List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVO = new ArrayList<List<CustomMnrGeneralCodeVO>>(); 
				//Active 구분 하기 위한 
				generalCodeSearchGRPVO.getCommonInitDataINVO().setTypeSizeSearchInd("A");
				generalCodeSearchGRPVO.getCommonInitDataINVO().setOrderByColNm("Y");
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd(container);
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO0 = dbDao.searchTypeSizeListData(generalCodeSearchGRPVO.getCommonInitDataINVO());
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd(chassis); 
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO1 = dbDao.searchTypeSizeListData(generalCodeSearchGRPVO.getCommonInitDataINVO());
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd(mgSet);
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO2 = dbDao.searchTypeSizeListData(generalCodeSearchGRPVO.getCommonInitDataINVO());
					
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO0);  
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO1);  
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO2);  
				 
				generalCodeSearchGRPVO.setListCustomMnrGeneralCodeVOS(listCustomMnrGeneralCodeVO);   
			}else if(generalCodeSearchGRPVO.getCommonInitDataINVO().getComCodeSearchInd().equals("Y")){ 
				List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVO = new ArrayList<List<CustomMnrGeneralCodeVO>>(); 
				listCustomMnrGeneralCodeVO.add(dbDao.searchComGeneralCodeListData(generalCodeSearchGRPVO.getCommonInitDataINVO()));
           
				generalCodeSearchGRPVO.setListCustomMnrGeneralCodeVOS(listCustomMnrGeneralCodeVO);   
			
			//코드종류가 Disposal TypeSize 인 경우
			} else if (generalCodeSearchGRPVO.getCommonInitDataINVO().getCodeType().equals("DSPTypeSize")) {
				List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVO = new ArrayList<List<CustomMnrGeneralCodeVO>>(); 
				
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd("U");
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO0 = dbDao.searchTypeSizeListForDSPData(generalCodeSearchGRPVO.getCommonInitDataINVO());
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd("Z"); 
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO1 = dbDao.searchTypeSizeListForDSPData(generalCodeSearchGRPVO.getCommonInitDataINVO());
				generalCodeSearchGRPVO.getCommonInitDataINVO().setKndCd("G");
				List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVO2 = dbDao.searchTypeSizeListForDSPData(generalCodeSearchGRPVO.getCommonInitDataINVO());
					
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO0);  
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO1);  
				listCustomMnrGeneralCodeVO.add(customMnrGeneralCodeVO2);  
				
				generalCodeSearchGRPVO.setListCustomMnrGeneralCodeVOS(listCustomMnrGeneralCodeVO);   
				
			}
			
			return generalCodeSearchGRPVO;  
		} catch (DAOException ex) {   	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MnrComSearchGrid] searchCommonInitDataListBasic"}).getMessage(),ex);
		} catch (Exception ex) {	 	  	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MnrComSearchGrid] searchCommonInitDataListBasic"}).getMessage(),ex);
		}	
	}
	
	/**
	 * [EES_MNR_0226]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchEQGeneralInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException {
		try {  
			List<List<CustomMnrEqStsVVO>> listCustomMnrEqStsVVOs = new ArrayList<List<CustomMnrEqStsVVO>>(); 
			
			List<CustomMnrEqStsVVO> customMnrEqStsVVO = dbDao.searchEQGeneralInfoData (generalCodeSearchGRPVO.getEQGeneralInfoINVO());
			
			listCustomMnrEqStsVVOs.add(customMnrEqStsVVO); 
			
			generalCodeSearchGRPVO.setListCustomMnrEqStsVVOs(listCustomMnrEqStsVVOs);  
			
			return generalCodeSearchGRPVO;  
		} catch (DAOException ex) {   	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchEQGeneralInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {   	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchEQGeneralInfoBasic"}).getMessage(),ex);
		}
	}
		
	/**
	 * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param AGMTRtGRPVO agmtRtGRPVO
	 * @return AGMTRtGRPVO
	 * @exception EventException
	 */
	public AGMTRtGRPVO searchAgmtRtInfoBasic(AGMTRtGRPVO agmtRtGRPVO) throws EventException {
		try{
			agmtRtGRPVO.setAGMTRtListVOS(dbDao.searchAgmtRateListData(agmtRtGRPVO));
			return agmtRtGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Inquiry Pop Up] searchAgmtRtInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Inquiry Pop Up] searchAgmtRtInfoBasic"}).getMessage(),ex);
		}
	}
	   	
	/**
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param CostCodeGRPVO costCodeGRPVO
	 * @return CostCodeGRPVO
	 * @exception EventException
	 */
	public CostCodeGRPVO searchCostCodeBasic(CostCodeGRPVO costCodeGRPVO) throws EventException {
		try{					
			costCodeGRPVO.setCustomCostCodeVOS(dbDao.searchCostCodeData(costCodeGRPVO.getCostCodeINVO()));  
			return costCodeGRPVO ;   
		} catch (DAOException ex) {  
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchCostCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {	  
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchCostCodeBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0194]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchVesselInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException {
		try{	
			VesselInfoVO vesselInfoVO = generalCodeSearchGRPVO.getVesselInfoVO();
			generalCodeSearchGRPVO.setVesselInfoVOS(dbDao.searchVesselInfoData(vesselInfoVO));
			
			return generalCodeSearchGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] searchVesselInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] searchVesselInfoBasic"}).getMessage(),ex);
		}	
	}
	
	/**
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchCustomerInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException {
		try{	
			CustomerInfoVO customerInfoVO = generalCodeSearchGRPVO.getCustomerInfoVO();
			generalCodeSearchGRPVO.setCustomerInfoVOS(dbDao.searchCustomerInfoData(customerInfoVO));
			
			return generalCodeSearchGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Buyer Management] searchCustomerInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Buyer Management] searchCustomerInfoBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0157]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param UnitPriceGRPVO unitPriceGRPVO
	 * @return UnitPriceGRPVO
	 * @exception EventException
	 */
	public UnitPriceGRPVO searchUnitPriceBasic(UnitPriceGRPVO unitPriceGRPVO) throws EventException {
		try{	
			CustomUnitPriceVO customUnitPriceVO = unitPriceGRPVO.getInCustomUnitPriceVO();
			unitPriceGRPVO.setOutCustomUnitPriceVO(dbDao.searchUnitPriceData(customUnitPriceVO));
			
			return unitPriceGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchUnitPriceBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchUnitPriceBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0041]Conversion할 Curr rate를 조회 합니다.  <br>
	 *
	 * @param UnitPriceGRPVO unitPriceGRPVO
	 * @return UnitPriceGRPVO
	 * @exception EventException
	 */
	public UnitPriceGRPVO searchCurrXchRtInfoBasic(UnitPriceGRPVO unitPriceGRPVO) throws EventException {
		try{	
			CustomCurrXchRtVO customCurrXchRtVO = unitPriceGRPVO.getCustomCurrXchRtVO();
			unitPriceGRPVO.setCustomCurrXchRtVO(dbDao.searchCurrXchRtInfoData(customCurrXchRtVO));
			return unitPriceGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Invoice Curr rate] searchCurrXchRtInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Invoice Curr rate] searchCurrXchRtInfoBasic"}).getMessage(),ex);
		}
	}	
	
	/**
	 * [CoMnr] OFFICE 별 로칼 날짜(YYYY-MM-DD)를 조회합니다. <br>
	 *
	 * @param EtcInfoGRPVO etcInfoGRPVO
	 * @return EtcInfoGRPVO
	 * @exception EventException
	 */	
	public EtcInfoGRPVO searchLoCalDateInfoBasic(EtcInfoGRPVO etcInfoGRPVO) throws EventException {
		try {			
			CustomLocalDateVO customLocalDateVO = etcInfoGRPVO.getInCustomLocalDateVO();
			etcInfoGRPVO.setOutCustomLocalDateVO(dbDao.searchLoCalDateInfoData(customLocalDateVO));
			return etcInfoGRPVO;
		} catch (DAOException ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchLoCalDateInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchLoCalDateInfoBasic"}).getMessage(),ex);
		}
	}	
	
	/**
	 * [CoMnr] SPP바이어 OFC정보를 조회  <br>
	 *
	 * @param EtcInfoGRPVO etcInfoGRPVO
	 * @return EtcInfoGRPVO
	 * @exception EventException
	 */
	public EtcInfoGRPVO searchSPPOFCInfoBasic(EtcInfoGRPVO etcInfoGRPVO) throws EventException {
		try {			
			CustomSPPOFCVO customSPPOFCVO = etcInfoGRPVO.getInCustomSPPOFCVO();
			etcInfoGRPVO.setOutCustomSPPOFCVO(dbDao.searchSPPOFCInfoData(customSPPOFCVO));
			return etcInfoGRPVO;	
		} catch (DAOException ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchLoCalDateInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchLoCalDateInfoBasic"}).getMessage(),ex);
		}
	}	
	
	/**
	 * [CoMnr]Office 의 RHQ 정보를 조회 합니다. <br>
	 * 
	 * @param CustomerInfoVO customerInfoVO 
	 * @return String 
	 * @throws EventException
	 */	
	public String searchHqOfcByOfcBasic(CustomerInfoVO customerInfoVO) throws EventException {
		try{	
			return dbDao.searchHqOfcByOfcData(customerInfoVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchHqOfcByOfcBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchHqOfcByOfcBasic"}).getMessage(),ex);
		}
	}	
	
	/**
	 * [EES_MNR_0019] rfUnitMaker를 조회 합니다. <br>
	 * 
	 * @param String eqNo
	 * @return CustomMnrEqStsVVO 
	 * @throws EventException
	 */	
	public CustomMnrEqStsVVO searchRfUnitMakerBasic(String eqNo) throws EventException {
		try{	
			return dbDao.searchRfUnitMakerData(eqNo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchRfUnitMakerBasic"}).getMessage(), ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchRfUnitMakerBasic"}).getMessage(), ex);
		}
	}	
	
	/**
	 * MNR 공통 조회 기능 <br>
	 * OFFICE CODE 의 AGMT NO 를 조회하여 AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @param String ofc_cd
	 * @return String return_agmt_no
	 * @exception DAOException
	 */
	public String searchMnrAgmtNoBasic(String agmt_no, String ofc_cd) throws EventException {
		try{	
			return dbDao.searchMnrAgmtNoData(agmt_no, ofc_cd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchMnrAgmtNoBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchMnrAgmtNoBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * India SAC Code의 존재 유무 확인 <br>
	 * SAC Code의 Validate Check의 Error Flag 리턴<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception DAOException
	 */
	public EventResponse validSacCd(Event e) throws EventException {
		MnrComEvent				event			= (MnrComEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			String errFlg = null;
			DBRowSet dbRowset = dbDao.validSacCd( event );
			while (dbRowset.next()){
				errFlg = dbRowset.getString("err_flg");
				break;
			}
			eventResponse.setRs(dbRowset);
//			etcData.put("successFlag", "SUCCESS" );
//			etcData.put("ETC_KEY_NAME", event.getMnrCommonVO().getCoid() );
			etcData.put("err_flg", errFlg );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Office Code, Vendor Seq, SAC Code를 통한 India GST 세율 정보 조회 <br>
	 * CGST, SGST, IGST, UGST Rate 리턴<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception DAOException
	 */
	public EventResponse getIdaGstRto(Event e) throws EventException {
		MnrComEvent				event			= (MnrComEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			String idaSacCd = null;
			String idaCgstRt = null;
			String idaSgstRt = null;
			String idaIgstRt = null;
			String idaUgstRt = null;
			
			DBRowSet dbRowset = dbDao.getIdaGstRto( event );
			while (dbRowset.next()){
				idaSacCd = dbRowset.getString("ida_sac_cd");
				idaCgstRt = dbRowset.getString("ida_cgst_rto");
				idaSgstRt = dbRowset.getString("ida_sgst_rto");
				idaIgstRt = dbRowset.getString("ida_igst_rto");
				idaUgstRt = dbRowset.getString("ida_ugst_rto");
				break;
			}
			eventResponse.setRs(dbRowset);
//			etcData.put("successFlag", "SUCCESS" );
//			etcData.put("ETC_KEY_NAME", event.getMnrCommonVO().getCoid() );
			etcData.put("ida_gst_rt", idaSacCd + "|" + idaCgstRt + "|" + idaSgstRt + "|" + idaIgstRt + "|" + idaUgstRt + "#" );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}