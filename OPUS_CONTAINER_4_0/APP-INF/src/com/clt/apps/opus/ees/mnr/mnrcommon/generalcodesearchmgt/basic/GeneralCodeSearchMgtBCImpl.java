/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtBCImpl.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCurrXchRtVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomUnitPriceVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.GeneralCodeSearchGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.OfficeInfoListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
	
/**
 * COM-MNRCommon Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_MNR_INITEventResponse,GeneralCodeSearchMgtBC DAO class reference
 * @since J2EE 1.4  
 */
	
public  class GeneralCodeSearchMgtBCImpl extends BasicCommandSupport implements GeneralCodeSearchMgtBC {

	// Database Access Object
	private transient GeneralCodeSearchMgtDBDAO dbDao = null;

	//variable of container
	private String container = "U";
	private String chassis = "Z"; 
	private String mgSet = "G";  
		
	/**
	 * creating GeneralCodeSearchMgtBCImpl object<br>
	 * creating GeneralCodeSearchMgtDBDAO <br>
	 */
	public GeneralCodeSearchMgtBCImpl() {
		dbDao = new GeneralCodeSearchMgtDBDAO();
	}
	
	/**
	 * [EES_MNR_0011] getting default Unit Of Measure per EQ TYPE of standard tarrif. <br>
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
	 * [EES_MNR_0189] retrieving M&R Service Provider Inquiry_Pop Up. <br>
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
	 * [MNR_COMMON] retrieving common Combo. <br>
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
					}else if(comboInitDataINVOS[i].getSearchkey().equalsIgnoreCase("RPRINV")){
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
					// setting at account in case of not existing OFC.   
					if(comboInitDataINVOS[i].getSearchkey().equals("") || comboInitDataINVOS[i].getSearchkey() == null){
						if(comboInitDataINVOS[i].getSearchcon().equalsIgnoreCase("DISP")){
							comboInitDataINVOS[i].setSearchkey(account.getRhq_ofc_cd()); 
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
							// deleting special string       
							String tempString = qyerys[x].replaceAll("\n","");  
							tempString = tempString.replaceAll(";","");			  
							// changing &(url connector) ☞
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
							//deleting special string	
							String tempString = qyerys[x].replaceAll("\n","");
							tempString = tempString.replaceAll(";","");  
							//changing &(url connector) ☞
							tempString = tempString.replaceAll("☞","&");
							qyerys[x] = tempString.toUpperCase(); 	
							
							int cur = qyerys[x].indexOf("FROM");
							String tabName  = "";	
							
							// in case of existing FROM clause
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
									
								// in case of Query containing * 
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
	 * [MNR_COMMON] retrieving MnrComSearchGrid common code. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO	
	 * @exception EventException	
	 */
	public GeneralCodeSearchGRPVO searchCommonInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException {
		try {  
			/////////////////////////////////////////////////////////////
			// 1. MnrComSearchGrid
			// "type_size_search_ind" - typeSize
			// "com_code_search_ind"  - FQA Result Description Code
			// 	 			
			// 2. MnrComSearchGrid2 
			// active type size 				- "ACTTypeSize" 
 			// disposal type size   			- "DSPTypeSize"
			/////////////////////////////////////////////////////////////
			  			
			// in case of code kind is typeSize(type_size_search_ind)
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
			//in case of code kind active type size 
			} if(generalCodeSearchGRPVO.getCommonInitDataINVO().getCodeType().equals("ACTTypeSize")) {
				List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVO = new ArrayList<List<CustomMnrGeneralCodeVO>>(); 
				// disginguish Active
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
			
			//in case of code kind is Disposal TypeSize 
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
	 * [EES_MNR_0226] retrieving Total Loss Request. <br>
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
	 * [EES_MNR_0226] retrieving Simple W/O Inquiry Pop Up. <br>
	 *
	 * @param AGMTRtGRPVO agmtRtGRPVO
	 * @return AGMTRtGRPVO
	 * @exception EventException
	 */
	public AGMTRtGRPVO searchAgmtRtInfoBasic(AGMTRtGRPVO agmtRtGRPVO) throws EventException {
		String type = "";
		try{
			List<AGMTRtListVO> list = dbDao.searchCostYardCodeData(agmtRtGRPVO);
			if(list.size() > 0){
				for(int i = 0; i<list.size(); i++){
					if("ALL".equals(list.get(i).getYdCd())){
						type = "A";
					}
				}
				
				for(int i = 0; i<list.size(); i++){
					if(agmtRtGRPVO.getAGMTRtINVO().getYdCd().substring(0, 5).equals(list.get(i).getYdCd())){
						type = "L";
					}
				}
				
				for(int i = 0; i<list.size(); i++){
					if(agmtRtGRPVO.getAGMTRtINVO().getYdCd().equals(list.get(i).getYdCd())){
						type = "Y";
					}
				}
			}
			
			agmtRtGRPVO.getAGMTRtINVO().setType(type);
			agmtRtGRPVO.setAGMTRtListVOS(dbDao.searchAgmtRateListData(agmtRtGRPVO));
			return agmtRtGRPVO ;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Inquiry Pop Up] searchAgmtRtInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Inquiry Pop Up] searchAgmtRtInfoBasic"}).getMessage(),ex);
		}
	}
	   	
	/**
	 * [EES_MNR_0023] retrieving Repair Estimate Creation. <br>
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
	 * [EES_MNR_0194] retrieving Vessel Reefer Spare Part Purchase W/O Creation. <br>
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
	 * [EES_MNR_0155] retrieving Disposal Buyer Management. <br>
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
	 * [EES_MNR_0157] retrieving Disposal Request. <br>
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
	 * [EES_MNR_0041] retrieving Curr rate to Conversion.  <br>
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
     * [EES_MNR_0019] Searching rfUnitMaker<br>
     * 
     * @param String eqNo
     * @return CustomMnrEqStsVVO
     * @throws EventException
     */
	@Override
	public CustomMnrEqStsVVO searchRfUnitMakerBasic(String eqNo) throws EventException {
		try{
			return dbDao.searchRfUnitMakerData(eqNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchRfUnitMakerBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchRfUnitMakerBasic"}).getMessage(),ex);
		}
	}
	
	/**
     * [EES_MNR_0052] Searching Bkg Code, Trade Code<br>
     * 
     * @param BkgTrdCodeVO bkgTrdCodeVO
     * @return List<BkgTrdCodeVO>
     * @throws EventException
     */
	@Override
	public List<BkgTrdCodeVO> searchBkgTrdCdBasic(BkgTrdCodeVO bkgTrdCodeVO) throws EventException {
		try{
			List<BkgTrdCodeVO> list = new ArrayList<BkgTrdCodeVO>();
			String costShpSrchPatt = dbDao.checkCostShpSrchPattData(bkgTrdCodeVO);
			if(!"".equals(costShpSrchPatt)){
				bkgTrdCodeVO.setEqType(costShpSrchPatt.substring(0, 1));
				bkgTrdCodeVO.setPl(costShpSrchPatt.substring(1, 2));
				bkgTrdCodeVO.setFm(costShpSrchPatt.substring(2, 3));
				
				list = dbDao.searchBkgTrdCodeData(bkgTrdCodeVO);
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchBkgTrdCdBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchBkgTrdCdBasic"}).getMessage(),ex);
		}
	}
	
	/**
     * Searching LCC CODE<br>
     * 
     * @param CustomerInfoVO customerInfoVO
     * @return String
     * @throws EventException
     */
	@Override
	public String searchOfcLccCdBasic(CustomerInfoVO customerInfoVO) throws EventException {
		try{
			return dbDao.searchOfcLccCdata(customerInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchOfcLccCdBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchOfcLccCdBasic"}).getMessage(),ex);
		}
	}
	
	/**
     * Searching RHQ OFC<br>
     * 
     * @param OfficeInfoListVO officeInfoListVO
     * @return String
     * @throws EventException
     */
	@Override
	public String searchRhqOfcFmOfcCdBasic(OfficeInfoListVO officeInfoListVO) throws EventException {
		try{
			return dbDao.searchRhqOfcFmOfcCdData(officeInfoListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchRhqOfcFmOfcCdBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchRhqOfcFmOfcCdBasic"}).getMessage(),ex);
		}
	}
	
	/**
     * [EES_MNR_0018] Searching Agreement Group<br>
     * 
     * @param  String eqType
     * @return List<CustomCostCodeVO>
     * @throws EventException
     */
	public List<CustomCostCodeVO> searchAgmtGrpBasic(String eqType) throws EventException {
		try{
			return dbDao.searchAgmtGrpData(eqType);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchAgmtGrpBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchAgmtGrpBasic"}).getMessage(),ex);
		}
	}
}