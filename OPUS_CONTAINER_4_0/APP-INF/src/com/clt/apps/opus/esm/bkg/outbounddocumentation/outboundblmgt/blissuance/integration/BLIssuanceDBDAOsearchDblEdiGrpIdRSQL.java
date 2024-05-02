/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiGrpIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiGrpIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiGrpIdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiGrpIdRSQL").append("\n"); 
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
		query.append("SELECT CODE, GROUP_CD, GROUP_NM" ).append("\n"); 
		query.append("FROM   (SELECT SUBSTR (MIN (CODE), 2) CODE, GROUP_CD, GROUP_NM" ).append("\n"); 
		query.append("        FROM   (SELECT BKG.BKG_NO" ).append("\n"); 
		query.append(",                      DECODE (BKG.SC_NO," ).append("\n"); 
		query.append("                               EEC.SC_NO, '7SC'," ).append("\n"); 
		query.append("                               DECODE (CUST.BKG_CUST_TP_CD, 'S', '1SH', 'C', '2CN', 'N', '3NF', 'F', '4FF', 'A', '5AN', '6ER'))" ).append("\n"); 
		query.append("                         AS REASON" ).append("\n"); 
		query.append(",                      DECODE (BKG.SC_NO, EEC.SC_NO, '7' || EEC.SC_NO" ).append("\n"); 
		query.append(",                         DECODE (CUST.BKG_CUST_TP_CD, 'S', '1', 'C', '2', 'N', '3', 'F', '4', 'A', '5', '6')" ).append("\n"); 
		query.append("                       || CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                       || CUST.CUST_SEQ)" ).append("\n"); 
		query.append("                         AS CODE" ).append("\n"); 
		query.append(",                      EEC.EC_EDIRCV_ID RCV_ID" ).append("\n"); 
		query.append(",                      EEC.GROUP_CD GROUP_CD" ).append("\n"); 
		query.append(",                      EEC.GROUP_NM GROUP_NM" ).append("\n"); 
		query.append("                FROM   (SELECT EG.CUST_TRD_PRNR_ID AS EC_EDIRCV_ID" ).append("\n"); 
		query.append(",                              EG.ESVC_GRP_CD AS GROUP_CD" ).append("\n"); 
		query.append(",                              EG.ESVC_GRP_NM AS GROUP_NM" ).append("\n"); 
		query.append(",                              EG.ESVC_GRP_DELT_FLG AS DEL_IND" ).append("\n"); 
		query.append(",                              EC.CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append(",                              EC.CUST_SEQ" ).append("\n"); 
		query.append(",                              EC.BL_DRFT_FLG AS BL_IND" ).append("\n"); 
		query.append(",                              EC.SC_NO" ).append("\n"); 
		query.append(",                              EC.BKG_CTRT_TP_CD AS BKG_CTRT_DIV_CD" ).append("\n"); 
		query.append("                        FROM   BKG_EDI_GRP_CUST EC, BKG_EDI_GRP EG" ).append("\n"); 
		query.append("                        WHERE  EC.ESVC_GRP_CD = EG.ESVC_GRP_CD" ).append("\n"); 
		query.append("                           AND EC.CO_CD = EG.CO_CD" ).append("\n"); 
		query.append("                           AND EC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND EG.ESVC_GRP_DELT_FLG = 'N') EEC, BKG_CUSTOMER CUST, BKG_BOOKING BKG" ).append("\n"); 
		query.append("                WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("                   AND EEC.DEL_IND = 'N'" ).append("\n"); 
		query.append("                   AND EEC.BL_IND = 'Y'" ).append("\n"); 
		query.append("                   AND EEC.EC_EDIRCV_ID = @[edi_receive_id]" ).append("\n"); 
		query.append("                   #if ('' != ${group_edi_id})" ).append("\n"); 
		query.append("                   AND EEC.GROUP_CD = @[group_edi_id]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   AND ( (CUST.CUST_CNT_CD = EEC.CUST_CNT_CD" ).append("\n"); 
		query.append("                      AND CUST.CUST_SEQ = EEC.CUST_SEQ)" ).append("\n"); 
		query.append("                     OR EEC.SC_NO = DECODE (EEC.BKG_CTRT_DIV_CD, '2', BKG.RFA_NO, '1', BKG.SC_NO)" ).append("\n"); 
		query.append("                     ))" ).append("\n"); 
		query.append("        GROUP BY GROUP_CD,GROUP_NM)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1" ).append("\n"); 

	}
}