/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcopyBkgCustomerByBkgCSQL.java
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

public class GeneralBookingReceiptDBDAOcopyBkgCustomerByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sourceBkg의 bkg_customer를 targetBkg로 복사한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcopyBkgCustomerByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcopyBkgCustomerByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_customer" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(", BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", CUST_NM" ).append("\n"); 
		query.append(", CUST_ADDR" ).append("\n"); 
		query.append(", CUST_CTY_NM" ).append("\n"); 
		query.append(", CUST_STE_CD" ).append("\n"); 
		query.append(", CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", CUST_ZIP_ID" ).append("\n"); 
		query.append(", CUST_FAX_NO" ).append("\n"); 
		query.append(", CUST_EML" ).append("\n"); 
		query.append(", CUST_TP_CD" ).append("\n"); 
		query.append(", REF_NO" ).append("\n"); 
		query.append(", ADDR_PRN_FLG" ).append("\n"); 
		query.append(", VAL_NM" ).append("\n"); 
		query.append(", VAL_FAX_NO" ).append("\n"); 
		query.append(", VAL_CD" ).append("\n"); 
		query.append(", VAL_USR_ID" ).append("\n"); 
		query.append(", VAL_OFC_CD" ).append("\n"); 
		query.append(", VAL_DT" ).append("\n"); 
		query.append(", MTCH_FLG" ).append("\n"); 
		query.append(", AN_SND_FLG" ).append("\n"); 
		query.append(", CHG_DP_FLG" ).append("\n"); 
		query.append(", ORG_CUST_CNT_CD" ).append("\n"); 
		query.append(", ORG_CUST_SEQ" ).append("\n"); 
		query.append(", IB_CUST_NM" ).append("\n"); 
		query.append(", IB_CUST_ADDR" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", EORI_NO)" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(", BC.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", BC.CUST_CNT_CD" ).append("\n"); 
		query.append(", BC.CUST_SEQ" ).append("\n"); 
		query.append(", CASE WHEN SUB.BKG_CGO_TP_CD = 'P' AND BC.BKG_CUST_TP_CD IN ('N','C') THEN SUB.MT_CUST_NM" ).append("\n"); 
		query.append("  ELSE BC.CUST_NM" ).append("\n"); 
		query.append("  END AS CUST_NM" ).append("\n"); 
		query.append(", CASE WHEN SUB.BKG_CGO_TP_CD = 'P' AND BC.BKG_CUST_TP_CD IN ('N','C') THEN SUB.MT_CUST_ADDR" ).append("\n"); 
		query.append("  ELSE BC.CUST_ADDR" ).append("\n"); 
		query.append("  END AS CUST_ADDR" ).append("\n"); 
		query.append(", CASE WHEN SUB.BKG_CGO_TP_CD = 'P' AND BC.BKG_CUST_TP_CD IN ('N','C') THEN " ).append("\n"); 
		query.append("           (SELECT 				 " ).append("\n"); 
		query.append("                    CASE WHEN INSTR(ML.LOC_NM,',') > 0 THEN SUBSTR(ML.LOC_NM, 1, INSTR(ML.LOC_NM,',')-1)" ).append("\n"); 
		query.append("                         ELSE ML.LOC_NM" ).append("\n"); 
		query.append("                    END AS CTY_NM" ).append("\n"); 
		query.append("          FROM  MDM_YARD MY" ).append("\n"); 
		query.append("                 ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                 ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("                 ,  BKG_BOOKING BB" ).append("\n"); 
		query.append("          WHERE  MY.YD_CD =  BB.POD_NOD_CD" ).append("\n"); 
		query.append("          AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("          AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("          AND    BB.BKG_NO = @[targetBkg]" ).append("\n"); 
		query.append("          AND    ROWNUM   = 1) " ).append("\n"); 
		query.append("   ELSE BC.CUST_CTY_NM" ).append("\n"); 
		query.append("   END CUST_CTY_NM " ).append("\n"); 
		query.append(",  CASE WHEN SUB.BKG_CGO_TP_CD = 'P' AND BC.BKG_CUST_TP_CD IN ('N','C') THEN SUB.MT_CUST_STE_CD" ).append("\n"); 
		query.append("   ELSE BC.CUST_STE_CD" ).append("\n"); 
		query.append("   END CUST_STE_CD " ).append("\n"); 
		query.append(",  CASE WHEN SUB.BKG_CGO_TP_CD = 'P' AND BC.BKG_CUST_TP_CD IN ('N','C') THEN SUB.MT_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("   ELSE BC.CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("   END CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", BC.CUST_ZIP_ID" ).append("\n"); 
		query.append(", BC.CUST_FAX_NO" ).append("\n"); 
		query.append(", BC.CUST_EML" ).append("\n"); 
		query.append(", BC.CUST_TP_CD" ).append("\n"); 
		query.append(", BC.REF_NO" ).append("\n"); 
		query.append(", BC.ADDR_PRN_FLG" ).append("\n"); 
		query.append(", BC.VAL_NM" ).append("\n"); 
		query.append(", BC.VAL_FAX_NO" ).append("\n"); 
		query.append(", BC.VAL_CD" ).append("\n"); 
		query.append(", BC.VAL_USR_ID" ).append("\n"); 
		query.append(", BC.VAL_OFC_CD" ).append("\n"); 
		query.append(", BC.VAL_DT" ).append("\n"); 
		query.append(", BC.MTCH_FLG" ).append("\n"); 
		query.append(", BC.AN_SND_FLG" ).append("\n"); 
		query.append(", BC.CHG_DP_FLG" ).append("\n"); 
		query.append(", BC.ORG_CUST_CNT_CD" ).append("\n"); 
		query.append(", BC.ORG_CUST_SEQ" ).append("\n"); 
		query.append(", BC.IB_CUST_NM" ).append("\n"); 
		query.append(", BC.IB_CUST_ADDR" ).append("\n"); 
		query.append(", @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(", sysdate CRE_DT" ).append("\n"); 
		query.append(", @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(", sysdate UPD_DT" ).append("\n"); 
		query.append(", BC.EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", BC.EORI_NO" ).append("\n"); 
		query.append("from bkg_customer BC" ).append("\n"); 
		query.append("    , (SELECT " ).append("\n"); 
		query.append("			 (SELECT LISTAGG(SUBSTR(MO.OFC_ENG_NM, ((LEVEL-1)*35)+1, 35), CHR(10)) WITHIN GROUP (ORDER BY LEVEL)" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("              CONNECT BY LEVEL <= 2) AS MT_CUST_NM" ).append("\n"); 
		query.append("            ,(SELECT LISTAGG(SUBSTR(MO.OFC_ADDR, ((LEVEL-1)*35)+1, 35), CHR(10)) WITHIN GROUP (ORDER BY LEVEL) " ).append("\n"); 
		query.append("			  FROM   DUAL " ).append("\n"); 
		query.append("              CONNECT BY LEVEL <= 3) AS MT_CUST_ADDR" ).append("\n"); 
		query.append("            , ML.STE_CD  AS MT_CUST_STE_CD" ).append("\n"); 
		query.append("            , SUBSTR(ML.LOC_CD, 1, 2) AS MT_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("            , MO.OFC_ZIP_CD AS MT_CUST_ZIP_ID" ).append("\n"); 
		query.append("            , BB.BKG_CGO_TP_CD BKG_CGO_TP_CD" ).append("\n"); 
		query.append("            , BB.BKG_NO" ).append("\n"); 
		query.append("       FROM  MDM_YARD MY" ).append("\n"); 
		query.append("          ,  MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("          ,  MDM_LOCATION ML" ).append("\n"); 
		query.append("          ,  BKG_BOOKING BB" ).append("\n"); 
		query.append("      WHERE MY.YD_CD = BB.POD_NOD_CD" ).append("\n"); 
		query.append("      AND    MY.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("      AND    MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("      AND    BB.BKG_NO = @[targetBkg]" ).append("\n"); 
		query.append("      AND    ROWNUM   = 1) SUB" ).append("\n"); 
		query.append("where BC.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}