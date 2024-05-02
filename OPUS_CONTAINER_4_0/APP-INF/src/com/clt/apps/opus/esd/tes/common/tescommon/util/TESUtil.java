/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESUtil
*@FileTitle : TES UTIL
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2009-03-03 : 성능측정 관련 pageUrl 추출 및 param 절삭 기능 추가
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.util;

import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.clt.framework.component.util.JSPUtil;

/**
 * - TES의 공통 UTIL <br>
 * 
 * @author byungheeyoo
 * @see TESCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class TESUtil {

	protected static Logger log = Logger.getLogger(TESUtil.class.getName());
	
    /**
     * 성능측정 관련 pageURL 추출 METHOD - PAGE URL길이 50으로 제한
     * @param hm
     * @return String
     */
   public static String getPerfPageURL(HashMap<String, Object> hm) {
    	
//    	log.debug("\n  ###### TESUtil.getPerfPageURL()  ------------ \n");

    	String retval = null;
    	
    	try {
    		
    		if (hm!=null && hm.get(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME)!=null){
    			if (((String)hm.get(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME)).indexOf("/") >= 0){
	    			String tmpPageURL[] = ((String)hm.get(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME)).split("/");
	    			if (tmpPageURL!=null && tmpPageURL.length >= 1){
	    				retval = tmpPageURL[tmpPageURL.length-1].indexOf("?")>0?tmpPageURL[tmpPageURL.length-1].split("\\?")[0]:tmpPageURL[tmpPageURL.length-1];
	    			}
    			} else {
    				retval = ((String)hm.get(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME)).indexOf("?")>0?((String)hm.get(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME)).split("\\?")[0]:(String)hm.get(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME);
    			}
    		}
    		
    		return (retval!=null?(retval.toString().length()>TESCommonBC.PERF_SIZE_PAGE_URL?retval.toString().substring(0,TESCommonBC.PERF_SIZE_PAGE_URL):retval.toString()):"");
    		
    	} catch (Exception e){
    		log.error("### TESUtil.getPerfPageURL() - Exception msg:"+e.getMessage());
    		return "";
    	}
    }

	/**
	 * MAP의 내용을 TES의 기본 제한으로만 전부 문자열로 return - 무제한으로 처리하는것을 막기위해 기본 제한둠
	 * @param hm
	 * @return String
	 */
	public static String getParamNotNullValue(HashMap<String, Object> hm) {
		return getParamNotNullValue(hm, TESCommonBC.PERF_DEFAULT_MAX_SIZE_PARAMETER_VALUE);
	}

	/**
	 * MAP의 내용을 성능측정 param값들의 길이를 성능 측정 TABLE의 PARAM VALUE의 길이로 제한하여 문자열로 return
	 * @param hm
	 * @return String
	 */
	public static String getParamNotNullValueChkPerfParamSize(HashMap<String, Object> hm) {
		return getParamNotNullValue(hm, TESCommonBC.PERF_SIZE_PARAMETER_VALUE);
	}
	
	/**
	 * MAP의 내용이 빈값이 아닌경우만 주어진 길이 제한에 한해서 문자열로 return한다.
	 * @param hm
	 * @param param_size
	 * @return String
	 */
    @SuppressWarnings("unchecked")
	private static String getParamNotNullValue(HashMap<String, Object> hm, int param_size) {
    	
//    	log.debug("\n  ###### TESUtil.getParamNotNullValue() " + (param_size) + " ------------- \n");

    	StringBuffer retval = null;
    	
    	try {
			if (param_size > 0){
	    		retval = new StringBuffer();
				String key = null;
				if ("{".length() <= param_size){
					retval.append("{");
				}
				for (java.util.Iterator it=hm.keySet().iterator(); hm!=null && it.hasNext();){
					key = it.next().toString();
					if (key !=null && !key.trim().equals("")){
						if (hm.get(key)!=null && !((String)hm.get(key)).equals("")){
							if ((retval.length() + (key + "=" + hm.get(key)).length()) < param_size){
								if (retval.length() > "{".length()){
									if ((retval.length() + ",".length()) < param_size){
										retval.append(",");
									} else {
										break;
									}
								}
								retval.append(key + "=" + hm.get(key));
//								if (it.hasNext() && (retval.length() + ((it.hasNext()?",":"")).length()) < param_size){
//									retval.append((it.hasNext()?",":""));
//								} else {
//									break;	
//								}
							} else {
								break;
							}
						}
					}
				}
				if ((retval.length() + "}".length()) <= param_size){
					retval.append("}");
				}
			}
			
			return (retval!=null?retval.toString():"");
			
    	} catch (Exception e){
    		log.error("### TESUtil.getParamNotNullValue() - Exception msg:"+e.getMessage());
    		return "";
    	}
    }

	/**
	 * 
	 * @param src
	 * @param delim
	 * @return String[]
	 */
    public static String[] getStringToArray(String src, String delim) {
        String[] retval = null;
        StringTokenizer st = new StringTokenizer(src, delim);
        int count = st.countTokens();
        retval = new String[count];
        for (int i = 0; i < count; i++) {
        	retval[i] = st.nextToken();
        }

        return retval;
    }	
    
	/**
	 * 특수문자 처리
	 * @param str String
	 * @return String
	 */
    public static String convertText(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        } else {
            String retval = null;
            retval = JSPUtil.replace(str, "&", "&amp;");
            retval = JSPUtil.replace(retval, "<", "&lt;");
            retval = JSPUtil.replace(retval, ">", "&gt;");
            retval = JSPUtil.replace(retval, "\"", "&quot;");
            retval = JSPUtil.replace(retval, "\'", "&apos;");
            return retval;
        }
    }
    
    
//    /** getCodeValue 코드값을 가져옴
//     * 
//     * @param DBdate
//     * @param TESCostCodeList
//     * @param CntrTPCDList
//     * @param CntrSZCDList
//     * @param CntrTPSZCDList
//     * @param MTAutoTESTmlSoCostCDList
//     * @param ONAutoTESTmlSoCostCDList
//     * @param OTAutoTESTmlSoCostCDList
//     * @param OSAutoTESTmlSoCostCDList
//     * @param STAutoTESTmlSoCostCDList
//     * @return String
//     */
//	public static String getCodeValue(
//			String DBdate, 						// SYSDATE
//			String TESCostCodeList, 			// TES COST CODE LIST
//			String CntrTPCDList, 				//
//			String CntrSZCDList, 				//
//			String CntrTPSZCDList, 				//
//			String MTAutoTESTmlSoCostCDList,	// Marine Terminal Invoice 자동 COST CODE
//			String ONAutoTESTmlSoCostCDList,	// On-dock Rail Charge Invoice 자동 COST CODE
//			String OTAutoTESTmlSoCostCDList,	// Off-dock CY Invoice(Terminal) 자동 COST CODE
//			String OSAutoTESTmlSoCostCDList,	// Off-dock CY Invoice(Storage) 자동 COST CODE
//			String STAutoTESTmlSoCostCDList 	// Storage Invoice 자동 COST CODE
//			)
//	{
//		
//		StringBuffer retval = new StringBuffer();
//		
//		if (DBdate!=null && !DBdate.trim().equals("")){
//			retval.append(" var "+DBdate+" = '" + TESCodeUtil.getInstance().getCodeValue("searchDBdate","") + "';	\n");
//		}
//		if (TESCostCodeList!=null && !TESCostCodeList.trim().equals("")){
//			retval.append(" var "+TESCostCodeList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchTESCostCodeList","") + "';	\n");
//		}
//		if (CntrTPCDList!=null && !CntrTPCDList.trim().equals("")){
//			retval.append(" var "+CntrTPCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchCntrTPCDList","") + "';	\n");
//		}		
//		if (CntrSZCDList!=null && !CntrSZCDList.trim().equals("")){
//			retval.append(" var "+CntrSZCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchCntrSZCDList","") + "';	\n");
//		}		
//		if (CntrTPSZCDList!=null && !CntrTPSZCDList.trim().equals("")){
//			retval.append(" var "+CntrTPSZCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchCntrTPSZCDList","") + "';	\n");
//		}
//		if (MTAutoTESTmlSoCostCDList!=null && !MTAutoTESTmlSoCostCDList.trim().equals("")){
//			retval.append(" var "+MTAutoTESTmlSoCostCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchAutoTESTmlSoCostCDList","calc_cost_grp_cd|MT") + "';	\n");
//		}		
//		if (ONAutoTESTmlSoCostCDList!=null && !ONAutoTESTmlSoCostCDList.trim().equals("")){
//			retval.append(" var "+ONAutoTESTmlSoCostCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchAutoTESTmlSoCostCDList","calc_cost_grp_cd|ON") + "';	\n");
//		}		
//		if (OTAutoTESTmlSoCostCDList!=null && !OTAutoTESTmlSoCostCDList.trim().equals("")){
//			retval.append(" var "+OTAutoTESTmlSoCostCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchAutoTESTmlSoCostCDList","calc_cost_grp_cd|OT") + "';	\n");
//		}		
//		if (OSAutoTESTmlSoCostCDList!=null && !OSAutoTESTmlSoCostCDList.trim().equals("")){
//			retval.append(" var "+OSAutoTESTmlSoCostCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchAutoTESTmlSoCostCDList","calc_cost_grp_cd|OS") + "';	\n");
//		}		
//		if (STAutoTESTmlSoCostCDList!=null && !STAutoTESTmlSoCostCDList.trim().equals("")){
//			retval.append(" var "+STAutoTESTmlSoCostCDList+" = '" + TESCodeUtil.getInstance().getCodeValue("searchAutoTESTmlSoCostCDList","calc_cost_grp_cd|ST") + "';	\n");
//		}		
//		
//		return retval.toString();
//	}

}
