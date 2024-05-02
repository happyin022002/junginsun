/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking Customer 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUSTOMER (BKG_NO" ).append("\n"); 
		query.append("                        , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                        , CUST_CNT_CD" ).append("\n"); 
		query.append("                        , CUST_SEQ" ).append("\n"); 
		query.append("                        , CUST_NM" ).append("\n"); 
		query.append("                        , CUST_ADDR" ).append("\n"); 
		query.append("                        , CUST_CTY_NM" ).append("\n"); 
		query.append("                        , CUST_STE_CD" ).append("\n"); 
		query.append("                        , CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("                        , CUST_ZIP_ID" ).append("\n"); 
		query.append("                        , ADDR_PRN_FLG" ).append("\n"); 
		query.append("                        , CRE_USR_ID" ).append("\n"); 
		query.append("                        , CRE_DT" ).append("\n"); 
		query.append("                        , UPD_USR_ID" ).append("\n"); 
		query.append("                        , UPD_DT)                       " ).append("\n"); 
		query.append("SELECT SUB.BKG_NO            AS BKG_NO" ).append("\n"); 
		query.append("        , SUB.BKG_CUST_TP_CD AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("        , SUBSTR(DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD), 1, 2)     AS CUST_CNT_CD" ).append("\n"); 
		query.append("        , SUB.CUST_SEQ          AS CUST_SEQ" ).append("\n"); 
		query.append("        , (SELECT " ).append("\n"); 
		query.append("				 (SELECT LISTAGG(SUBSTR(MO.OFC_ENG_NM, ((LEVEL-1)*35)+1, 35), CHR(10)) WITHIN GROUP (ORDER BY LEVEL) " ).append("\n"); 
		query.append("				  FROM   DUAL " ).append("\n"); 
		query.append("                  CONNECT BY LEVEL <= 2" ).append("\n"); 
		query.append("  	              ) AS OFC_ENG_NM" ).append("\n"); 
		query.append("          FROM  MDM_YARD MY" ).append("\n"); 
		query.append("                 ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                 ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("          WHERE MY.YD_CD = DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD)" ).append("\n"); 
		query.append("          AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("          AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("          AND    ROWNUM   = 1) AS CUST_NM" ).append("\n"); 
		query.append("        , (SELECT 				 " ).append("\n"); 
		query.append("				 (SELECT LISTAGG(SUBSTR(MO.OFC_ADDR, ((LEVEL-1)*35)+1, 35), CHR(10)) WITHIN GROUP (ORDER BY LEVEL) " ).append("\n"); 
		query.append("				  FROM   DUAL " ).append("\n"); 
		query.append("                  CONNECT BY LEVEL <= 3" ).append("\n"); 
		query.append("  	              ) AS OFC_ADDR" ).append("\n"); 
		query.append("          FROM  MDM_YARD MY" ).append("\n"); 
		query.append("                 ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                 ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("          WHERE MY.YD_CD = DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD)" ).append("\n"); 
		query.append("          AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("          AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("          AND    ROWNUM   = 1) AS CUST_ADDR  " ).append("\n"); 
		query.append("        , (SELECT 				 " ).append("\n"); 
		query.append("                    CASE WHEN INSTR(ML.LOC_NM,',') > 0 THEN SUBSTR(ML.LOC_NM, 1, INSTR(ML.LOC_NM,',')-1)" ).append("\n"); 
		query.append("                         ELSE ML.LOC_NM" ).append("\n"); 
		query.append("                    END AS CUST_CTY_NM" ).append("\n"); 
		query.append("          FROM  MDM_YARD MY" ).append("\n"); 
		query.append("                 ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                 ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("          WHERE MY.YD_CD = DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD)" ).append("\n"); 
		query.append("          AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("          AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("          AND    ROWNUM   = 1) AS CUST_CTY_NM                    " ).append("\n"); 
		query.append("        , (SELECT ML.STE_CD" ).append("\n"); 
		query.append("          FROM  MDM_YARD MY" ).append("\n"); 
		query.append("                 ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                 ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("          WHERE MY.YD_CD = DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD)" ).append("\n"); 
		query.append("          AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("          AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("          AND    ROWNUM   = 1) AS CUST_STE_CD   " ).append("\n"); 
		query.append("        , SUBSTR(DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD), 1, 2) AS CSTMS_DECL_CNT_CD            " ).append("\n"); 
		query.append("        , (SELECT MO.OFC_ZIP_CD" ).append("\n"); 
		query.append("          FROM  MDM_YARD MY" ).append("\n"); 
		query.append("                 ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                 ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("          WHERE MY.YD_CD = DECODE(SUB.BKG_CUST_TP_CD, 'S', BB.POL_NOD_CD, BB.POD_NOD_CD)" ).append("\n"); 
		query.append("          AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("          AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("          AND    ROWNUM   = 1) AS CUST_ZIP_ID        " ).append("\n"); 
		query.append("        , 'N'                   AS ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , @[cre_usr_id]      AS CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE           AS CRE_DT" ).append("\n"); 
		query.append("        , @[upd_usr_id]    AS UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE           AS UPD_DT" ).append("\n"); 
		query.append("FROM (                        " ).append("\n"); 
		query.append("           SELECT @[bkg_no]  AS BKG_NO" ).append("\n"); 
		query.append("                , (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                    WHERE INTG_CD_ID = 'CD00880'" ).append("\n"); 
		query.append("                      AND INTG_CD_VAL_DP_SEQ = LVL) AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                , ATTR_CTNT1           AS CUST_CNT_CD" ).append("\n"); 
		query.append("                , ATTR_CTNT2           AS CUST_SEQ" ).append("\n"); 
		query.append("             FROM BKG_HRD_CDG_CTNT  HC" ).append("\n"); 
		query.append("                , (SELECT LEVEL AS LVL FROM DUAL  CONNECT BY LEVEL < 4)" ).append("\n"); 
		query.append("            WHERE 'MTY_BKG_CUST' = HC.HRD_CDG_ID " ).append("\n"); 
		query.append("          )SUB , BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE SUB.BKG_NO = BB.BKG_NO" ).append("\n"); 

	}
}