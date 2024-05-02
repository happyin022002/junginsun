/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonBCImpl.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.18
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration.MSTCommonDBDAO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration.MSTCommonEAIDAO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CustomMstGeneralCodeVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.GeneralCodeSearchGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * MSTCommon Business Logic Basic Command implementation<br>
 * handling business logic about MSTCommon<br>
 *
 * @author 
 * @see MST_COMEventResponse,MSTCommonBC MSTCommonDBDAO
 * @since J2EE 1.6
 */
public class MSTCommonBCImpl extends BasicCommandSupport implements MSTCommonBC {

	// Database Access Object
	private transient MSTCommonDBDAO dbDao = null;
	private transient MSTCommonEAIDAO eaiDao = null;

	/**
	 * creating MSTCommonBCImpl<br>
	 * ctreating creating MSTCommonDBDAO<br>
	 */
	public MSTCommonBCImpl() {
		dbDao = new MSTCommonDBDAO();
		eaiDao = new MSTCommonEAIDAO();
	}
	/**
	 * ManufacturerList : common retrieve<br>
	 * retrieving for Manufacturer List<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchManufacturerListBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchManufacturerListData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacturer"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacturer"}).getMessage(),ex);		
		}
	}
	
	/**                       
	 * EqTypeSizeList :  common retrieve<br>
	 * retrieving for Eq Type Size List<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchEqTypeSizeListBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchEqTypeSizeListData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search TP/SZ"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search TP/SZ"}).getMessage(),ex);
		}
	} 
	
	/**                       
	 * ManufacturePlaceList : common retrieve<br>
	 * retrieving for Manufacture Place List<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchManufacturePlaceListBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchManufacturePlaceListData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacture Place"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacture Place"}).getMessage(),ex);		
		}
	}
	
	/**
	 * EES_MST_0014 : retrieve<br>
	 * retrieving for Lease Agreement List<br>
	 * 
	 * @param AgmtInfoVO agmtInfoVO
	 * @return List<AgmtInfoVO>
	 * @exception EventException
	 */
	public List<AgmtInfoVO> searchAgmtBasic(AgmtInfoVO agmtInfoVO) throws EventException {

		List<AgmtInfoVO> resultVOs = new ArrayList<AgmtInfoVO>();

		try {
			if (agmtInfoVO.getAgmtSeq() != null && !agmtInfoVO.getAgmtSeq().equals("")){
				resultVOs = dbDao.searchAgmtData(agmtInfoVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lease Agreement"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lease Agreement"}).getMessage(),ex);		
		}
		
		return resultVOs;
	}
	
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * retrieving for MSTCommon<br>
	 * @param CommonListVO   commonListVO
	 * @return CommonListVO
	 * @exception EventException
	 */	
	public CommonListVO searchYardCodeBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchYardCodeData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Yard Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Yard Code"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving for Lessor code name<br>
	 * 
	 * @param CommonListVO   commonListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchLessorCodeBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchLessorCodeData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lessor Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lessor Code"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Reefer Type Code<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchReeferTypeCodeListBasic() throws EventException {
		try {
			return dbDao.searchReeferTypeCodeListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		}
	}	
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Humidity Control Code<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchHumidityControlCodeListBasic() throws EventException {
		try {
			return dbDao.searchHumidityControlCodeListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		}
	}	
	
	/**
	 * retrieving for COM_INTG_CD<br>
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchComIntgCdListBasic(String intgCdId, String intgCdVal) throws EventException {
		try {
			return dbDao.searchComIntgCdListData(intgCdId,intgCdVal);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		}
	}	
	
	
	/**
	 * EDI msessage Send.<br>
	 * @param String   flatFile
	 * @return String
	 * @exception EventException
	 */	
	public String sendEdiToFleet(String flatFile) throws EventException { 
		try {
			return eaiDao.sendEdiToFleet(flatFile);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Send EDI to Fleet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Send EDI to Fleet"}).getMessage(),ex);
		}
	}	
	
	
	/**
	 * EDI EquipmentFleetInfo Send.<br>
	 * @param String   flatFile
	 * @return String
	 * @exception EventException
	 */	
	public String sendEquipmentFleetInfo(String flatFile) throws EventException { 
		try {
			return eaiDao.sendEquipmentFleetInfo(flatFile);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Send EDI to Fleet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Send EDI to Fleet"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MST_SECRETWEAPON] Query Execute. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @param SignOnUserAccount 	 account
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */ 
	public GeneralCodeSearchGRPVO searchComboInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO, SignOnUserAccount account) throws EventException {
		try {	   	
			ComboInitDataINVO[] comboInitDataINVOS = generalCodeSearchGRPVO.getComboInitDataINVOS();
				
			List<List<CustomMstGeneralCodeVO>> listCustomMstGeneralCodeVOS = new ArrayList<List<CustomMstGeneralCodeVO>>(); 
			for (int i = 0; i < comboInitDataINVOS.length ; i++){ 
				
				//EES_MST_QEXE
				if(comboInitDataINVOS[i].getSearchinfo().equals("EesMstQexe")){
				List<CustomMstGeneralCodeVO> CustomMstGeneralCodeVOS = new ArrayList<CustomMstGeneralCodeVO>(); 
				String[] qyerys = comboInitDataINVOS[i].getSearchkey().split(";");
				//EXE
				if(!comboInitDataINVOS[i].getSearchcon().equalsIgnoreCase("GET")){ 
					for(int x = 0; x < qyerys.length; x++){
						// deleting special string       
						String tempString = qyerys[x].replaceAll("\n"," ");  
						tempString = tempString.replaceAll(";","");			  
						// changing &(url connector) ☞
						tempString = tempString.replaceAll("☞","&");	 	
						
						qyerys[x] = tempString;					 
						//System.out.println(qyerys[x]); 
						int runCount = Integer.parseInt(comboInitDataINVOS[i].getSearchcon());
							
						int result = 0;
						StringBuilder sb = new StringBuilder("");
						for(int k = 0; k < runCount;k ++){
							result = dbDao.modifyMstQexeData(qyerys[x]); 
							sb.append(k + 1 + ":").append(String.valueOf(result));
										
							if(k != (runCount - 1)){
								sb.append("☞");  	
							} 			
						}		
						  	
						CustomMstGeneralCodeVO CustomMstGeneralCodeVO = new CustomMstGeneralCodeVO();
						CustomMstGeneralCodeVO.setCdId(qyerys[x]);
						CustomMstGeneralCodeVO.setCdDesc(sb.toString());
						CustomMstGeneralCodeVOS.add(CustomMstGeneralCodeVO);
					}	 
					listCustomMstGeneralCodeVOS.add(CustomMstGeneralCodeVOS); 
				//GET	
				} else {
					for(int x = 0; x < qyerys.length; x++){
						//deleting special string	
						String tempString = qyerys[x].replaceAll("\n"," ");
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
							DBRowSet dbRowset = dbDao.searchMstQexeData(qyerys[x]);
							     
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
								CustomMstGeneralCodeVO CustomMstGeneralCodeVO = new CustomMstGeneralCodeVO();
								CustomMstGeneralCodeVO.setCdId(qyerys[x]);
								CustomMstGeneralCodeVO.setCdDesc(retQuery.toString());
								CustomMstGeneralCodeVOS.add(CustomMstGeneralCodeVO); 
							}
							listCustomMstGeneralCodeVOS.add(CustomMstGeneralCodeVOS);   	
						} else {
							CustomMstGeneralCodeVO CustomMstGeneralCodeVO = new CustomMstGeneralCodeVO();
							CustomMstGeneralCodeVO.setCdId(qyerys[x]);
							CustomMstGeneralCodeVO.setCdDesc("NOT SELECT QUERY"); 
							CustomMstGeneralCodeVOS.add(CustomMstGeneralCodeVO);
						}	
						listCustomMstGeneralCodeVOS.add(CustomMstGeneralCodeVOS); 
					}	
				}				
			}		
			}                 
			generalCodeSearchGRPVO.setListCustomMstGeneralCodeVOS(listCustomMstGeneralCodeVOS);   
			   
			return generalCodeSearchGRPVO;    
		} catch (DAOException ex) {    	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchComboInitDataListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR_COMMON] searchComboInitDataListBasic"}).getMessage(),e);
		}  
	}
	
	
	/**
	 * retrieving for USER_INFO_SEARCH<br>
	 * @param String   inputUser
	 * @return String
	 * @exception EventException
	 */	
	public String searchUserInfoBasic(String inputUser) throws EventException {
		try {
			return dbDao.searchUserInfoData(inputUser);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		}
	}	
	
	/**
	 * retrieving for SAKURA INFO<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchSakuraCdListBasic() throws EventException {
		try {
			return dbDao.searchSakuraCdListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		}
	}	
	
}