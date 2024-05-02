/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchBkgCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchBkgCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for select searchbkgcustinfo
	  * </pre>
	  */
	public Edi315SendDBDAOSearchBkgCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchBkgCustInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	           SH.CUST_CNT_CD || LPAD(SH.CUST_SEQ,6,0) 	                                SHPRCODE," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(SH.cust_nm, 1)              	                        SHPR1," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(SH.cust_nm, 2)              	                        SHPR2," ).append("\n"); 
		query.append("               DECODE(SH.ADDR_PRN_FLG, 'Y', SCE_TOKEN_NL_FNC(SH.cust_addr, 1), '')	    SHPR3," ).append("\n"); 
		query.append("               DECODE(SH.ADDR_PRN_FLG, 'Y', SCE_TOKEN_NL_FNC(SH.cust_addr, 2), '')	    SHPR4," ).append("\n"); 
		query.append("               DECODE(SH.ADDR_PRN_FLG, 'Y', SCE_TOKEN_NL_FNC(SH.cust_addr, 3), '')	    SHPR5," ).append("\n"); 
		query.append("               REPLACE(REPLACE(SH.CUST_CTY_NM, '*', '-'), ':', '-')  	                SHPR_CITY_NM," ).append("\n"); 
		query.append("               SH.CUST_STE_CD  	                                                        SHPR_STAT_CD," ).append("\n"); 
		query.append("               REPLACE(REPLACE(SH.CUST_ZIP_ID, '*', '-'), ':', '-')   	                SHPR_ZIP_CD," ).append("\n"); 
		query.append("               SH.CSTMS_DECL_CNT_CD        	                                            SHPR_CNT_CD," ).append("\n"); 
		query.append("               CN.CUST_CNT_CD || LPAD(CN.CUST_SEQ,6,0) 	                                CNEECODE," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(CN.cust_nm, 1)              	                        CNEE1," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(CN.cust_nm, 2)              	                        CNEE2," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(CN.cust_addr, 1)            	                        CNEE3," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(CN.cust_addr, 2)            	                        CNEE4," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(CN.cust_addr, 3)            	                        CNEE5," ).append("\n"); 
		query.append("               REPLACE(REPLACE(CN.CUST_CTY_NM, '*', '-'), ':', '-')  	                CNEE_CITY_NM," ).append("\n"); 
		query.append("               CN.CUST_STE_CD  	                                                        CNEE_STAT_CD," ).append("\n"); 
		query.append("               REPLACE(REPLACE(CN.CUST_ZIP_ID, '*', '-'), ':', '-')   	                CNEE_ZIP_CD," ).append("\n"); 
		query.append("               CN.CSTMS_DECL_CNT_CD   	                                                CNEE_CNT_CD," ).append("\n"); 
		query.append("               NF.CUST_CNT_CD || LPAD(NF.CUST_SEQ,6,0) 	                                NTFYCODE," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(NF.cust_nm, 1)              	                        NTFY1," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(NF.cust_nm, 2)              	                        NTFY2," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(NF.cust_addr, 1)            	                        NTFY3," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(NF.cust_addr, 2)            	                        NTFY4," ).append("\n"); 
		query.append("               SCE_TOKEN_NL_FNC(NF.cust_addr, 3)            	                        NTFY5," ).append("\n"); 
		query.append("               REPLACE(REPLACE(NF.CUST_CTY_NM, '*', '-'), ':', '-')  	                NTFY_CITY_NM," ).append("\n"); 
		query.append("               NF.CUST_STE_CD  	                                                        NTFY_STAT_CD," ).append("\n"); 
		query.append("               REPLACE(REPLACE(NF.CUST_ZIP_ID, '*', '-'), ':', '-')   	                NTFY_ZIP_CD," ).append("\n"); 
		query.append("               NF.CSTMS_DECL_CNT_CD                                                     NTFY_CNT_CD," ).append("\n"); 
		query.append("			   ANF.CUST_CNT_CD || LPAD(ANF.CUST_SEQ,6,0) 	                            ANTFYCODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM   BKG_BOOKING BK,     " ).append("\n"); 
		query.append("               BKG_CUSTOMER SH," ).append("\n"); 
		query.append("               BKG_CUSTOMER NF," ).append("\n"); 
		query.append("               BKG_CUSTOMER CN," ).append("\n"); 
		query.append("			   BKG_CUSTOMER ANF" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        WHERE  BK.bkg_no       =  @[e_bkg_no]" ).append("\n"); 
		query.append("           AND BK.bkg_no       = SH.bkg_no" ).append("\n"); 
		query.append("           AND SH.BKG_CUST_TP_CD    = 'S' " ).append("\n"); 
		query.append("           AND BK.bkg_no       = NF.bkg_no" ).append("\n"); 
		query.append("           AND NF.BKG_CUST_TP_CD    = 'N' " ).append("\n"); 
		query.append("           AND BK.bkg_no       = CN.bkg_no" ).append("\n"); 
		query.append("           AND CN.BKG_CUST_TP_CD    = 'C'" ).append("\n"); 
		query.append("           AND BK.bkg_no       = ANF.bkg_no" ).append("\n"); 
		query.append("           AND ANF.BKG_CUST_TP_CD    = 'A'" ).append("\n"); 

	}
}