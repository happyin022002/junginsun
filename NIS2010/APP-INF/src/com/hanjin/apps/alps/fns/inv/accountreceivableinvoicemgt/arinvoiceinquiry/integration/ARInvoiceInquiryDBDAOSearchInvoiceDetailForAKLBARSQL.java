/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchInvoiceDetailForAKLBARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchInvoiceDetailForAKLBARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceInquiryDBDAO::SearchInvoiceDetailForAKLBA
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchInvoiceDetailForAKLBARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchInvoiceDetailForAKLBARSQL").append("\n"); 
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
		query.append("SELECT MN.BL_INV_IF_DT," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("       MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT 'Shpr Code -'||BC.CUST_CNT_CD || BC.CUST_SEQ|| ', Shpr Name -' || BC.CUST_NM ||', Shpr Addr- '|| BC.CUST_ADDR" ).append("\n"); 
		query.append("        FROM   BKG_CUSTOMER BC" ).append("\n"); 
		query.append("        WHERE  MN.BL_SRC_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND    BC.BKG_CUST_TP_CD ='S') SHPR," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT 'Cnee Code -'||BC.CUST_CNT_CD || BC.CUST_SEQ|| ', Cnee Name -' || BC.CUST_NM ||', Cnee Addr- '|| BC.CUST_ADDR" ).append("\n"); 
		query.append("        FROM   BKG_CUSTOMER BC" ).append("\n"); 
		query.append("        WHERE  MN.BL_SRC_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND    BC.BKG_CUST_TP_CD ='C') CNEE," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT 'Notify Code -'||BC.CUST_CNT_CD || BC.CUST_SEQ|| ', Notify Name -' || BC.CUST_NM ||', Notify Addr- '|| BC.CUST_ADDR" ).append("\n"); 
		query.append("        FROM   BKG_CUSTOMER BC" ).append("\n"); 
		query.append("        WHERE  MN.BL_SRC_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND    BC.BKG_CUST_TP_CD ='N') NOTIFY," ).append("\n"); 
		query.append("       MN.POR_CD," ).append("\n"); 
		query.append("       MN.POL_CD," ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.DEL_CD," ).append("\n"); 
		query.append("       CHG.CHG_CD," ).append("\n"); 
		query.append("       CHG.CHG_FULL_NM," ).append("\n"); 
		query.append("       CHG.CURR_CD," ).append("\n"); 
		query.append("       CHG.TRF_RT_AMT," ).append("\n"); 
		query.append("       CHG.CHG_AMT/CHG.RAT_AS_CNTR_QTY CHG_AMT," ).append("\n"); 
		query.append("       CHG.INV_XCH_RT," ).append("\n"); 
		query.append("       MN.INV_TTL_LOCL_AMT," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT WM_CONCAT(CNTR_NO)" ).append("\n"); 
		query.append("        FROM   INV_AR_CNTR C" ).append("\n"); 
		query.append("        WHERE  C.AR_IF_NO = MN.AR_IF_NO) CNTR_NO" ).append("\n"); 
		query.append("FROM  INV_AR_MN  MN," ).append("\n"); 
		query.append("      INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE MN.AR_IF_NO IN ( " ).append("\n"); 
		query.append("                       SELECT G.AR_IF_NO" ).append("\n"); 
		query.append("                       FROM   INV_AR_MN G" ).append("\n"); 
		query.append("                       WHERE  G.BL_INV_CFM_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("                       AND    G.INV_DELT_DIV_CD = 'N'" ).append("\n"); 
		query.append("                   #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("                       AND    G.AR_OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${act_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("                       AND    G.ACT_CUST_CNT_CD = NVL(@[act_cust_cnt_cd], '')" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${act_cust_seq} != '') " ).append("\n"); 
		query.append("                       AND    G.ACT_CUST_SEQ = CASE WHEN REGEXP_INSTR(@[act_cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                                                    TO_NUMBER(@[act_cust_seq])" ).append("\n"); 
		query.append("                                               ELSE" ).append("\n"); 
		query.append("                                                    -999999" ).append("\n"); 
		query.append("                                               END " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                       AND G.VSL_CD = SUBSTR(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("                       AND G.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                       AND G.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${io_bnd_cd} != '') " ).append("\n"); 
		query.append("                       AND G.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${por_cd} != '') " ).append("\n"); 
		query.append("                       AND G.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                       AND G.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${pod_cd} != '') " ).append("\n"); 
		query.append("                       AND G.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${del_cd} != '') " ).append("\n"); 
		query.append("                       AND G.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${iss_opt} != '') " ).append("\n"); 
		query.append("                   	#if (${iss_opt} == 'I') " ).append("\n"); 
		query.append("                       AND NVL(G.INV_ISS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("                 	#else" ).append("\n"); 
		query.append("                       AND NVL(G.INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                	#end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                   	#if (${svc_scp_cd} != 'ALL')" ).append("\n"); 
		query.append("                       AND G.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("AND   MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("ORDER BY MN.BL_INV_IF_DT, MN.BL_INV_CFM_DT, MN.BL_SRC_NO, MN.AR_IF_NO" ).append("\n"); 

	}
}