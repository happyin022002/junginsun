/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정전 Booking 정보 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL(){
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT  RCV_TERM_CD, " ).append("\n"); 
		query.append("        DE_TERM_CD, " ).append("\n"); 
		query.append("        BKG_CGO_TP_CD," ).append("\n"); 
		query.append("        OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD BKG_TRUNK_VVD," ).append("\n"); 
		query.append("        FIRST_VVD.FIRST_VVD," ).append("\n"); 
		query.append("        FIRST_VVD.FIRST_POD," ).append("\n"); 
		query.append("        POR_CD, " ).append("\n"); 
		query.append("        POR_NOD_CD, " ).append("\n"); 
		query.append("        POL_CD, " ).append("\n"); 
		query.append("        POL_NOD_CD," ).append("\n"); 
		query.append("        POD_CD, " ).append("\n"); 
		query.append("        POD_NOD_CD, " ).append("\n"); 
		query.append("        DEL_CD, " ).append("\n"); 
		query.append("        DEL_NOD_CD, " ).append("\n"); 
		query.append("        PRE_RLY_PORT_CD, " ).append("\n"); 
		query.append("        PST_RLY_PORT_CD," ).append("\n"); 
		query.append("        MTY_PKUP_YD_CD, " ).append("\n"); 
		query.append("        FULL_RTN_YD_CD," ).append("\n"); 
		query.append("		PCTL_NO," ).append("\n"); 
		query.append("		SLAN_CD," ).append("\n"); 
		query.append("		BKG_OFC_CD," ).append("\n"); 
		query.append("		CTRT_CUST_CNT_CD," ).append("\n"); 
		query.append("		CTRT_CUST_SEQ," ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		NVL((SELECT 'Y'" ).append("\n"); 
		query.append("			  FROM (SELECT DISTINCT LOC FROM " ).append("\n"); 
		query.append("						   (SELECT LOC" ).append("\n"); 
		query.append("			    		      FROM (SELECT POD_CD LOC FROM BKG_VVD_HIS VVD WHERE VVD.BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("					                 UNION " ).append("\n"); 
		query.append("				    	            SELECT DEL_CD LOC FROM BKG_BKG_HIS BK WHERE BK.BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("				        	MINUS" ).append("\n"); 
		query.append("					        SELECT LOC" ).append("\n"); 
		query.append("			    		      FROM (SELECT SUBSTR(DEST_NOD_CD, 1, 5) LOC" ).append("\n"); 
		query.append("				        		      FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("				        	         WHERE PCTL_NO = NVL(@[pctl_no], (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append("					                   AND TRSP_MOD_CD IN ('VD','WD')" ).append("\n"); 
		query.append("									   AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("			        		         UNION " ).append("\n"); 
		query.append("			                		SELECT DEL_CD LOC FROM PRD_PROD_CTL_MST WHERE PCTL_NO = NVL(@[pctl_no], (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])))					" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					UNION " ).append("\n"); 
		query.append("					SELECT DISTINCT LOC FROM " ).append("\n"); 
		query.append("					       (SELECT LOC" ).append("\n"); 
		query.append("			    		      FROM (SELECT SUBSTR(DEST_NOD_CD, 1, 5) LOC" ).append("\n"); 
		query.append("				        		      FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("				        	         WHERE PCTL_NO = NVL(@[pctl_no], (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append("					                   AND TRSP_MOD_CD IN ('VD','WD')" ).append("\n"); 
		query.append("									   AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("			        		         UNION " ).append("\n"); 
		query.append("			                		SELECT DEL_CD LOC FROM PRD_PROD_CTL_MST WHERE PCTL_NO = NVL(@[pctl_no], (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])))" ).append("\n"); 
		query.append("				        	MINUS" ).append("\n"); 
		query.append("						    SELECT LOC" ).append("\n"); 
		query.append("			    		      FROM (SELECT POD_CD LOC FROM BKG_VVD_HIS VVD WHERE VVD.BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			            		     UNION " ).append("\n"); 
		query.append("				    	            SELECT DEL_CD LOC FROM BKG_BKG_HIS BK WHERE BK.BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			 WHERE ROWNUM = 1" ).append("\n"); 
		query.append("			   AND sysdate > (SELECT VPS_ETD_DT" ).append("\n"); 
		query.append("								FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("							   WHERE SKD.VSL_CD = SUBSTR(FIRST_VVD, 1, 4)" ).append("\n"); 
		query.append("								 AND SKD.SKD_VOY_NO = SUBSTR(FIRST_VVD, 5, 4)" ).append("\n"); 
		query.append("								 AND SKD.SKD_DIR_CD = SUBSTR(FIRST_VVD, 9, 1)" ).append("\n"); 
		query.append("								 AND SKD.VPS_PORT_CD = FIRST_POL" ).append("\n"); 
		query.append("								 AND SKD.CLPT_IND_SEQ = FIRST_POL_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("			   AND 'ON' = (SELECT ATTR_CTNT2 " ).append("\n"); 
		query.append("							 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("							WHERE HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("							  AND ATTR_CTNT1 = 'AUTO_COD')), 'N') COD_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		NVL((SELECT 'Y'" ).append("\n"); 
		query.append("			  FROM (SELECT DISTINCT LOC FROM " ).append("\n"); 
		query.append("						   (SELECT LOC" ).append("\n"); 
		query.append("					          FROM (SELECT POD_CD LOC FROM BKG_VVD VVD WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			    		             UNION " ).append("\n"); 
		query.append("		    	        		    SELECT DEL_CD LOC FROM BKG_BOOKING BK WHERE BK.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("				        	MINUS" ).append("\n"); 
		query.append("					        SELECT LOC" ).append("\n"); 
		query.append("			    		      FROM (SELECT SUBSTR(DEST_NOD_CD, 1, 5) LOC" ).append("\n"); 
		query.append("				        		      FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("				        	         WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("					                   AND TRSP_MOD_CD IN ('VD','WD')" ).append("\n"); 
		query.append("									   AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("			        		         UNION " ).append("\n"); 
		query.append("			                		SELECT DEL_CD LOC FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no])					" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					UNION " ).append("\n"); 
		query.append("					SELECT DISTINCT LOC FROM " ).append("\n"); 
		query.append("					       (SELECT LOC" ).append("\n"); 
		query.append("			    		      FROM (SELECT SUBSTR(DEST_NOD_CD, 1, 5) LOC" ).append("\n"); 
		query.append("				        		      FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("				        	         WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("					                   AND TRSP_MOD_CD IN ('VD','WD')" ).append("\n"); 
		query.append("									   AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("			        		         UNION " ).append("\n"); 
		query.append("			                		SELECT DEL_CD LOC FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no])	" ).append("\n"); 
		query.append("				        	MINUS" ).append("\n"); 
		query.append("						    SELECT LOC" ).append("\n"); 
		query.append("					          FROM (SELECT POD_CD LOC FROM BKG_VVD VVD WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			    		             UNION " ).append("\n"); 
		query.append("		    	        		    SELECT DEL_CD LOC FROM BKG_BOOKING BK WHERE BK.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			 WHERE ROWNUM = 1" ).append("\n"); 
		query.append("			   AND sysdate > (SELECT VPS_ETD_DT" ).append("\n"); 
		query.append("								FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("							   WHERE SKD.VSL_CD = SUBSTR(FIRST_VVD, 1, 4)" ).append("\n"); 
		query.append("								 AND SKD.SKD_VOY_NO = SUBSTR(FIRST_VVD, 5, 4)" ).append("\n"); 
		query.append("								 AND SKD.SKD_DIR_CD = SUBSTR(FIRST_VVD, 9, 1)" ).append("\n"); 
		query.append("								 AND SKD.VPS_PORT_CD = FIRST_POL" ).append("\n"); 
		query.append("								 AND SKD.CLPT_IND_SEQ = FIRST_POL_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("			   AND 'ON' = (SELECT ATTR_CTNT2 " ).append("\n"); 
		query.append("							 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("							WHERE HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("							  AND ATTR_CTNT1 = 'AUTO_COD')), 'N') COD_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS BK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , (SELECT BKG_NO" ).append("\n"); 
		query.append("              , FIRST_VVD" ).append("\n"); 
		query.append("              , FIRST_POD" ).append("\n"); 
		query.append("			  , FIRST_POL" ).append("\n"); 
		query.append("			  , FIRST_POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("           FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("                      , VSL_CD||SKD_VOY_NO||SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("                      , POD_CD FIRST_POD" ).append("\n"); 
		query.append("			  		  , POL_CD FIRST_POL" ).append("\n"); 
		query.append("			  		  , POL_CLPT_IND_SEQ FIRST_POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                   FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                   FROM BKG_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("				    AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  ORDER BY VSL_PRE_PST_CD,VSL_SEQ " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           WHERE ROWNUM = 1 " ).append("\n"); 
		query.append("        ) FIRST_VVD" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.BKG_NO = FIRST_VVD.BKG_NO (+)" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("   AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}