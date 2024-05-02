/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiPHILSCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PHILS EDI 전송 Cntr List
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSCntrListRSQL").append("\n"); 
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
		query.append("SELECT IC.CNTR_NO, BC.PCK_TP_CD, BC.PCK_QTY, BC.CNTR_WGT, BC.WGT_UT_CD, BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       MAX(DECODE(BC.CNTR_SEAL_SEQ, 1, BC.CNTR_SEAL_NO, '')) SEAL_NO1," ).append("\n"); 
		query.append("       MAX(DECODE(BC.CNTR_SEAL_SEQ, 2, BC.CNTR_SEAL_NO, '')) SEAL_NO2," ).append("\n"); 
		query.append("       MAX(DECODE(BC.CNTR_SEAL_SEQ, 3, BC.CNTR_SEAL_NO, '')) SEAL_NO3" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("            SELECT BC.CNTR_NO, BC.PCK_TP_CD, BC.PCK_QTY, BC.CNTR_WGT, BC.WGT_UT_CD, BC.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                   BCS.CNTR_SEAL_SEQ, BCS.CNTR_SEAL_NO" ).append("\n"); 
		query.append("            FROM   BKG_CONTAINER BC," ).append("\n"); 
		query.append("                   BKG_CNTR_SEAL_NO BCS" ).append("\n"); 
		query.append("            WHERE  BC.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("            AND    BC.CNTR_NO = BCS.CNTR_NO" ).append("\n"); 
		query.append("            AND    BC.BKG_NO = @[bl_src_no] " ).append("\n"); 
		query.append("        ) BC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CNTR.CNTR_NO," ).append("\n"); 
		query.append("                   CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM   INV_AR_CNTR CNTR," ).append("\n"); 
		query.append("                  (SELECT BL_SRC_NO, MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                   FROM  INV_AR_MN" ).append("\n"); 
		query.append("                   WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND   ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("                   AND   ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("                   AND   INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                   AND   REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                   AND   BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                   GROUP BY BL_SRC_NO" ).append("\n"); 
		query.append("                  ) MN" ).append("\n"); 
		query.append("                WHERE MN.AR_IF_NO = CNTR.AR_IF_NO" ).append("\n"); 
		query.append("        ) IC" ).append("\n"); 
		query.append("WHERE    BC.CNTR_NO(+) = IC.CNTR_NO " ).append("\n"); 
		query.append("GROUP BY IC.CNTR_NO, BC.PCK_TP_CD, BC.PCK_QTY, BC.CNTR_WGT, BC.WGT_UT_CD, BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY IC.CNTR_NO" ).append("\n"); 

	}
}