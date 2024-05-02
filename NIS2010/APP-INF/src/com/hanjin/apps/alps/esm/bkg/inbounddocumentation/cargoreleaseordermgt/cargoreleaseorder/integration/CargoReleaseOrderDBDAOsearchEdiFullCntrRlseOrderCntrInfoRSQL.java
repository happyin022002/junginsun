/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderCntrInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO'                              || CHR(10) ||" ).append("\n"); 
		query.append("       'CNTN:'|| CNTR_NO                         || CHR(10) ||   -- 화면 입력 값 ( Container No ) " ).append("\n"); 
		query.append("       'CNTT:'|| CNTR_TPSZ_CD                    || CHR(10) ||   -- 화면 입력값 ( Container Tp Size Code ) " ).append("\n"); 
		query.append("       'SEAL:'                                   || CHR(10) ||     " ).append("\n"); 
		query.append("       'RIND:'|| DECODE(RC_FLG,'Y','1','0')      || CHR(10) ||              " ).append("\n"); 
		query.append("       'DIND:'|| DECODE(DCGO_FLG,'Y','1','0')    || CHR(10) ||                 " ).append("\n"); 
		query.append("       'AIND:'|| DECODE(AWK_CGO_FLG,'Y','1','0') || CHR(10) ||                 " ).append("\n"); 
		query.append("       'BIND:'|| DECODE(BB_CGO_FLG,'Y','1','0')  || CHR(10) ||        " ).append("\n"); 
		query.append("       'TEMP:'                                   || CHR(10) || " ).append("\n"); 
		query.append("       'TUN:'                                    || CHR(10) || " ).append("\n"); 
		query.append("       'VENT:'                                   || CHR(10) || " ).append("\n"); 
		query.append("       'GENSET:'                                 || CHR(10) || " ).append("\n"); 
		query.append("       'RF_REMARK:'                              || CHR(10) || " ).append("\n"); 
		query.append("       'RFDRY_IND:'                              || CHR(10) || " ).append("\n"); 
		query.append("       'OVF:'                                    || CHR(10) || " ).append("\n"); 
		query.append("       'OVR:'                                    						|| CHR(10) || " ).append("\n"); 
		query.append("       'OVH:'                                    						|| CHR(10) || " ).append("\n"); 
		query.append("       'OVLW:'                                   						|| CHR(10) || " ).append("\n"); 
		query.append("       'OVRW:'                                   						|| CHR(10) || " ).append("\n"); 
		query.append("       'OVWGT:'                                  						|| CHR(10) || " ).append("\n"); 
		query.append("       'VOID_SLOT:'                             				        || CHR(10) || " ).append("\n"); 
		query.append("       'STWG_REQ:'                               						|| CHR(10) || " ).append("\n"); 
		query.append("       'TRM_TYPE:'                               						|| CHR(10) || " ).append("\n"); 
		query.append("       'TRM_WEIGHT:'                             						|| CHR(10) || " ).append("\n"); 
		query.append("       'TRM_HAULAGE:'                            						|| CHR(10) || " ).append("\n"); 
		query.append("       'TRM_HMODE:'                              					    || CHR(10) || " ).append("\n"); 
		query.append("       'TRM_PICKUP_CY:'                              				    || CHR(10) || " ).append("\n"); 
		query.append("       'TRM_RETURN_CY:'                          					    || CHR(10) || " ).append("\n"); 
		query.append("       'TRM_INSTRUCTION:'                        					    || CHR(10) || " ).append("\n"); 
		query.append("       'TRM_TRAN_DT:'                            					    || CHR(10) || " ).append("\n"); 
		query.append("       'TRM_TRAN_OFFICE:'                        					    || CHR(10) || " ).append("\n"); 
		query.append("       'TRM_TRAN_NO:'                           					    || CHR(10) || " ).append("\n"); 
		query.append("       'USR_ID:'                                 					    || CHR(10) ||" ).append("\n"); 
		query.append(" 	   'EQRTN:'             || (SELECT TO_CHAR(TRO.CNTR_RTN_DT, 'YYYYMMDD')  AS CNTR_RTN_DT " ).append("\n"); 
		query.append("	              FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("	              WHERE 1=1" ).append("\n"); 
		query.append("	                AND TRO.BKG_NO  = CNTR.BKG_NO" ).append("\n"); 
		query.append("                    AND TRO.CNTR_NO  = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                    AND TRO.CXL_FLG  = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1)      						    || CHR(10) ||" ).append("\n"); 
		query.append("	   'CUSTOMS_VOY_NO:'    || @[cstms_voy_no]   						|| CHR(10) ||" ).append("\n"); 
		query.append("	   'FREIGHT_FORW_CD:'   || (SELECT ACT_CUST_CNT_CD || TO_CHAR (ACT_CUST_SEQ, 'FM000000') AS CUST" ).append("\n"); 
		query.append("        FROM   INV_AR_MN" ).append("\n"); 
		query.append("        WHERE  AR_IF_NO = (SELECT MAX (AR_IF_NO) IF_NO" ).append("\n"); 
		query.append("                           FROM   INV_AR_MN" ).append("\n"); 
		query.append("                           WHERE  BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                            AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                            AND AR_OFC_CD = (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("												FROM(" ).append("\n"); 
		query.append("    												 SELECT DISTINCT A.AR_OFC_CD," ).append("\n"); 
		query.append("      												  DECODE(B.AR_OFC_CD, A.AR_OFC_CD, 0, 1) OFCSEQ," ).append("\n"); 
		query.append("      														 C.INV_DUP_FLG" ).append("\n"); 
		query.append("    												   FROM INV_AR_MN A," ).append("\n"); 
		query.append("      														MDM_ORGANIZATION B," ).append("\n"); 
		query.append("     	 													INV_AR_STUP_OFC C" ).append("\n"); 
		query.append("   													  WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      													AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        																	SELECT AR_OFC_CD" ).append("\n"); 
		query.append("        																	  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("       																		 WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("            																							SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            																							  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            																						     WHERE OFC_CD = @[lgn_ofc_cd])" ).append("\n"); 
		query.append("          																								   AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("      																									   AND B.OFC_CD = @[lgn_ofc_cd]" ).append("\n"); 
		query.append("      																									   AND A.AR_OFC_CD = C.AR_OFC_CD (+)" ).append("\n"); 
		query.append("      																							           AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("																										   ORDER BY OFCSEQ)" ).append("\n"); 
		query.append("																			WHERE ROWNUM = 1" ).append("\n"); 
		query.append("																			)" ).append("\n"); 
		query.append("	AND NVL (INV_DELT_DIV_CD, 'N') <> 'Y'))                     		    || CHR(10) ||" ).append("\n"); 
		query.append("	   'PTY_TO_INVOICE_CD:' || (SELECT ACT_CUST_CNT_CD || TO_CHAR (ACT_CUST_SEQ, 'FM000000') AS CUST" ).append("\n"); 
		query.append("        FROM   INV_AR_MN" ).append("\n"); 
		query.append("        WHERE  AR_IF_NO = (SELECT MAX (AR_IF_NO) IF_NO" ).append("\n"); 
		query.append("                           FROM   INV_AR_MN" ).append("\n"); 
		query.append("                           WHERE  BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                            AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                            AND AR_OFC_CD = (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("												FROM(" ).append("\n"); 
		query.append("    												 SELECT DISTINCT A.AR_OFC_CD," ).append("\n"); 
		query.append("      												  DECODE(B.AR_OFC_CD, A.AR_OFC_CD, 0, 1) OFCSEQ," ).append("\n"); 
		query.append("      														 C.INV_DUP_FLG" ).append("\n"); 
		query.append("    												   FROM INV_AR_MN A," ).append("\n"); 
		query.append("      														MDM_ORGANIZATION B," ).append("\n"); 
		query.append("     	 													INV_AR_STUP_OFC C" ).append("\n"); 
		query.append("   													  WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      													AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        																	SELECT AR_OFC_CD" ).append("\n"); 
		query.append("        																	  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("       																		 WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("            																							SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            																							  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            																						     WHERE OFC_CD = @[lgn_ofc_cd])" ).append("\n"); 
		query.append("          																								   AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("      																									   AND B.OFC_CD = @[lgn_ofc_cd]" ).append("\n"); 
		query.append("      																									   AND A.AR_OFC_CD = C.AR_OFC_CD (+)" ).append("\n"); 
		query.append("      																							           AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("																										   ORDER BY OFCSEQ)" ).append("\n"); 
		query.append("																			WHERE ROWNUM =1" ).append("\n"); 
		query.append("																			)" ).append("\n"); 
		query.append("	AND NVL (INV_DELT_DIV_CD, 'N') <> 'Y'))                     			|| CHR(10) ||" ).append("\n"); 
		query.append("	   'MT_RET_CY_CD:'      || (SELECT TRO.CNTR_RTN_YD_CD  AS CNTR_RTN_YD_CD " ).append("\n"); 
		query.append("	              FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("	              WHERE 1=1" ).append("\n"); 
		query.append("	                AND TRO.BKG_NO  = CNTR.BKG_NO" ).append("\n"); 
		query.append("                    AND TRO.CNTR_NO  = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                    AND TRO.CXL_FLG  = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1)     				  	|| CHR(10)                " ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("  AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}