/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchDeclarantCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.21
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.10.21 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchDeclarantCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG Declarant Customer 정보를 조회한다.
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchDeclarantCustomerRSQL(){
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
		params.put("dg_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchDeclarantCustomerRSQL").append("\n"); 
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
		query.append("SELECT DG.BKG_NO" ).append("\n"); 
		query.append("    ,DG.DCGO_SEQ" ).append("\n"); 
		query.append("    ,DG.DG_CNTR_SEQ" ).append("\n"); 
		query.append("    ,DG.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("    ,DG.CNTR_NO" ).append("\n"); 
		query.append("    ,NVL(S.DECL_NM,C.DECL_NM) AS DECL_NM" ).append("\n"); 
		query.append("    ,S.DG_DECL_SEQ		AS SH_DG_DECL_SEQ" ).append("\n"); 
		query.append("    ,S.CUST_CNT_CD      AS SH_CUST_CNT_CD" ).append("\n"); 
		query.append("    ,S.CUST_SEQ         AS SH_CUST_SEQ" ).append("\n"); 
		query.append("    ,S.CUST_NM          AS SH_CUST_NM" ).append("\n"); 
		query.append("    ,S.CUST_ADDR        AS SH_CUST_ADDR" ).append("\n"); 
		query.append("    ,S.CUST_CTY_NM      AS SH_CUST_CTY_NM" ).append("\n"); 
		query.append("    ,S.CUST_ZIP_ID      AS SH_CUST_ZIP_ID" ).append("\n"); 
		query.append("    ,S.CUST_STE_CD      AS SH_CUST_STE_CD" ).append("\n"); 
		query.append("    ,S.CSTMS_DECL_CNT_CD    AS SH_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("    ,S.PHN_NO           AS SH_PHN_NO" ).append("\n"); 
		query.append("    ,S.CUST_FAX_NO      AS SH_CUST_FAX_NO" ).append("\n"); 
		query.append("    ,S.CUST_EML         AS SH_CUST_EML" ).append("\n"); 
		query.append("    ,C.DG_DECL_SEQ		AS CN_DG_DECL_SEQ    --" ).append("\n"); 
		query.append("    ,C.CUST_CNT_CD      AS CN_CUST_CNT_CD" ).append("\n"); 
		query.append("    ,C.CUST_SEQ         AS CN_CUST_SEQ" ).append("\n"); 
		query.append("    ,C.CUST_NM          AS CN_CUST_NM" ).append("\n"); 
		query.append("    ,C.CUST_ADDR        AS CN_CUST_ADDR" ).append("\n"); 
		query.append("    ,C.CUST_CTY_NM      AS CN_CUST_CTY_NM" ).append("\n"); 
		query.append("    ,C.CUST_ZIP_ID      AS CN_CUST_ZIP_ID" ).append("\n"); 
		query.append("    ,C.CUST_STE_CD      AS CN_CUST_STE_CD" ).append("\n"); 
		query.append("    ,C.CSTMS_DECL_CNT_CD    AS CN_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("    ,C.PHN_NO           AS CN_PHN_NO" ).append("\n"); 
		query.append("    ,C.CUST_FAX_NO      AS CN_CUST_FAX_NO" ).append("\n"); 
		query.append("    ,C.CUST_EML         AS CN_CUST_EML" ).append("\n"); 
		query.append("    ,(SELECT TEMP_DG.SEQ " ).append("\n"); 
		query.append("	  FROM (SELECT DG_CNTR_SEQ, RANK()OVER(ORDER BY DG_CNTR_SEQ) SEQ  " ).append("\n"); 
		query.append("			FROM BKG_DG_CGO " ).append("\n"); 
		query.append("			WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("			GROUP BY DG_CNTR_SEQ" ).append("\n"); 
		query.append("		   ) TEMP_DG " ).append("\n"); 
		query.append("	  WHERE TEMP_DG.DG_CNTR_SEQ = DG.DG_CNTR_SEQ) AS DG_CNTR_ORD_SEQ" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG, BKG_DG_DECL S, BKG_DG_DECL C" ).append("\n"); 
		query.append("WHERE DG.BKG_NO		= S.BKG_NO(+)" ).append("\n"); 
		query.append("  AND DG.DG_CNTR_SEQ= S.DG_CNTR_SEQ(+)" ).append("\n"); 
		query.append("  AND DG.BKG_NO		= C.BKG_NO(+)" ).append("\n"); 
		query.append("  AND DG.DG_CNTR_SEQ= C.DG_CNTR_SEQ(+)" ).append("\n"); 
		query.append("  AND DG.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("  AND DG.DG_CNTR_SEQ	= @[dg_cntr_seq]" ).append("\n"); 
		query.append("  AND S.BKG_CUST_TP_CD(+) = 'S'  --S:SHIPPER" ).append("\n"); 
		query.append("  AND C.BKG_CUST_TP_CD(+) = 'C'  --C:CONSIGNEE" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}