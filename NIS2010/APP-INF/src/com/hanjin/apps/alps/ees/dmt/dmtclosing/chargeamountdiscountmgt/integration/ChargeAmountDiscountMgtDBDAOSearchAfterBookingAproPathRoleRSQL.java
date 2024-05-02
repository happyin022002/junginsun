/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRoleRSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRoleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRoleRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT  NVL(" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  T1.AFT_BKG_PATH_CD ||'|'|| 	--// 현재 승인 경로" ).append("\n"); 
		query.append("						T2.ATTR_CTNT6      ||'|'|| 	--// 현재 승인 권한" ).append("\n"); 
		query.append("						T1.APRO_OFC_CD     ||'|'|| 	--// 현재 승인 OFFICE" ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN AFT_BKG_PATH_LVL <> " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  MAX(AFT_BKG_PATH_LVL) " ).append("\n"); 
		query.append("									  FROM  DMT_AFT_BKG_APRO_PATH " ).append("\n"); 
		query.append("									 WHERE  AFT_EXPT_DAR_NO       = T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("									   AND  AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("								) " ).append("\n"); 
		query.append("							THEN 'N' " ).append("\n"); 
		query.append("						ELSE 'Y' " ).append("\n"); 
		query.append("						END                ||'|'||  --// 현재 승인 경로가 최종 승인경로인지 여부" ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN INSTR(T2.ATTR_CTNT1, 'PIC') > 0 " ).append("\n"); 
		query.append("							THEN 'Y' " ).append("\n"); 
		query.append("						ELSE 'N' " ).append("\n"); 
		query.append("						END					||'|'	--// 현재 승인 경로가 PIC 담당인지 여부" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("				  FROM  DMT_AFT_BKG_APRO_PATH  T1" ).append("\n"); 
		query.append("					   ,DMT_HRD_CDG_CTNT       T2" ).append("\n"); 
		query.append("					   " ).append("\n"); 
		query.append("				 WHERE  #if(${dar_no} != '')" ).append("\n"); 
		query.append("                        T1.AFT_EXPT_DAR_NO  = @[dar_no]" ).append("\n"); 
		query.append("                        #elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("                        T1.AFT_EXPT_DAR_NO  = " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        	SELECT  AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                        	  FROM  DMT_AFT_BKG_ADJ_RQST" ).append("\n"); 
		query.append("                        	 WHERE  AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   AND  T1.AFT_BKG_PATH_LVL =" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SELECT  MIN(AFT_BKG_PATH_LVL)" ).append("\n"); 
		query.append("							  FROM  DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("							 WHERE  AFT_EXPT_DAR_NO = T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("							   AND  DMDT_EXPT_RQST_STS_CD IS NULL" ).append("\n"); 
		query.append("							   AND  AFT_BKG_PATH_CPLS_FLG = 'Y' " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   AND  T2.HRD_CDG_ID	   = 'AFT_BKG_APRO_PATH'" ).append("\n"); 
		query.append("				   AND  T1.AFT_BKG_PATH_CD = T2.ATTR_CTNT1" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		   ,'N|N|N|N|N|'" ).append("\n"); 
		query.append("		) ||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  T1.AFT_BKG_PATH_CD ||'|'|| 	--// 최종 승인 경로" ).append("\n"); 
		query.append("						T2.ATTR_CTNT6      ||'|'|| 	--// 최종 승인 권한" ).append("\n"); 
		query.append("						T1.APRO_OFC_CD     ||'|'|| 	--// 최종 승인 OFFICE" ).append("\n"); 
		query.append("						'Y'    			   ||'|'	--// 현재 승인 경로가 최종 승인경로인지 여부" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("				  FROM  DMT_AFT_BKG_APRO_PATH  T1" ).append("\n"); 
		query.append("					   ,DMT_HRD_CDG_CTNT       T2" ).append("\n"); 
		query.append("					   " ).append("\n"); 
		query.append("				 WHERE  #if(${dar_no} != '')" ).append("\n"); 
		query.append("                        T1.AFT_EXPT_DAR_NO  = @[dar_no]" ).append("\n"); 
		query.append("                        #elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("                        T1.AFT_EXPT_DAR_NO  = " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        	SELECT  AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                        	  FROM  DMT_AFT_BKG_ADJ_RQST" ).append("\n"); 
		query.append("                        	 WHERE  AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("				   AND  T1.AFT_BKG_PATH_LVL =" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SELECT  MAX(AFT_BKG_PATH_LVL)" ).append("\n"); 
		query.append("							  FROM  DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("							 WHERE  AFT_EXPT_DAR_NO = T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("							   AND  AFT_BKG_PATH_CPLS_FLG = 'Y' " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   AND  T2.HRD_CDG_ID	   = 'AFT_BKG_APRO_PATH'" ).append("\n"); 
		query.append("				   AND  T1.AFT_BKG_PATH_CD = T2.ATTR_CTNT1" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		   ,'N|N|N|N|'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 

	}
}