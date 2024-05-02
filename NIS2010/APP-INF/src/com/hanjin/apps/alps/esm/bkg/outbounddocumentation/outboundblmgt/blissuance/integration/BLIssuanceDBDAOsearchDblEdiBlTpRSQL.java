/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiBlTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.03 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiBlTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDblEdiBlTp
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiBlTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiBlTpRSQL").append("\n"); 
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
		query.append("SELECT DECODE(TRIM(ESVC_BL_TP_CD), 'BLF', 'Y', 'BIF', 'Y', 'BLN', 'N', 'BIN', 'N', ' ')" ).append("\n"); 
		query.append("FROM   (SELECT EEC.ESVC_BL_TP_CD" ).append("\n"); 
		query.append("        FROM   (SELECT EG.CUST_TRD_PRNR_ID AS EC_EDIRCV_ID" ).append("\n"); 
		query.append(",                      EG.ESVC_GRP_CD AS GROUP_CD" ).append("\n"); 
		query.append(",                      EG.ESVC_GRP_NM AS GROUP_NM" ).append("\n"); 
		query.append(",                      EG.ESVC_GRP_DELT_FLG AS DEL_IND" ).append("\n"); 
		query.append(",                      EC.CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append(",                      EC.CUST_SEQ" ).append("\n"); 
		query.append(",                      EC.BL_DRFT_FLG AS BL_IND" ).append("\n"); 
		query.append(",                      EC.SC_NO" ).append("\n"); 
		query.append(",                      EC.BKG_CTRT_TP_CD AS BKG_CTRT_DIV_CD" ).append("\n"); 
		query.append(",                      EC.ESVC_BL_TP_CD" ).append("\n"); 
		query.append(",                      EC.BKG_CUST_TP_DESC" ).append("\n"); 
		query.append("                FROM   BKG_EDI_GRP_CUST EC, BKG_EDI_GRP EG" ).append("\n"); 
		query.append("                WHERE  EC.ESVC_GRP_CD = EG.ESVC_GRP_CD" ).append("\n"); 
		query.append("                   AND EC.CO_CD = EG.CO_CD" ).append("\n"); 
		query.append("                   AND EC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND EG.ESVC_GRP_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND EC.BL_DRFT_FLG = 'Y') EEC" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("        WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("           AND EEC.EC_EDIRCV_ID = TRIM(@[edi_receive_id])" ).append("\n"); 
		query.append("           AND ( (CUST.CUST_CNT_CD = EEC.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND CUST.CUST_SEQ = EEC.CUST_SEQ)" ).append("\n"); 
		query.append("             OR EEC.SC_NO = DECODE (EEC.BKG_CTRT_DIV_CD, '2', BKG.RFA_NO, '1', BKG.SC_NO))" ).append("\n"); 
		query.append("           AND  DECODE(BKG_CUST_TP_DESC,'ALL','ALL',CUST.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("                                 IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE(BKG_SPLIT_FNC(BKG_CUST_TP_DESC,',')))" ).append("\n"); 
		query.append("        GROUP BY EEC.ESVC_BL_TP_CD)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1" ).append("\n"); 

	}
}