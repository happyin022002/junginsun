/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPInvoiceEDIListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.09 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPInvoiceEDIListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPInvoiceEDIListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sent_stat",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPInvoiceEDIListRSQL").append("\n"); 
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
		query.append("SELECT M.BL_SRC_NO" ).append("\n"); 
		query.append("      ,M.INV_NO" ).append("\n"); 
		query.append("      ,M.ISS_DT" ).append("\n"); 
		query.append("      ,SUM(C.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("	  ,SUM(C.CHG_AMT) EDI_AMT" ).append("\n"); 
		query.append("      ,C.CURR_CD" ).append("\n"); 
		query.append("      ,V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,B.POL_CD" ).append("\n"); 
		query.append("      ,B.POD_CD" ).append("\n"); 
		query.append("      ,M.ACT_CUST_CNT_CD||'-'|| TO_CHAR(M.ACT_CUST_SEQ, 'FM000000') CUST_CD   " ).append("\n"); 
		query.append("      ,BC.CUST_CNT_CD AS SHIPPER_CNT_CD" ).append("\n"); 
		query.append("      ,MD.CNT_NM AS SHIPPER_CNT_NM" ).append("\n"); 
		query.append("      ,BC2.CUST_CNT_CD AS CONSIGNEE_CNT_CD" ).append("\n"); 
		query.append("      ,MD2.CNT_NM AS CONSIGNEE_CNT_NM" ).append("\n"); 
		query.append("      ,MAX(BR.DE_NO) AS SHIP_ID" ).append("\n"); 
		query.append("      ,MAX(BR.PRT_NO) AS PART_NO" ).append("\n"); 
		query.append("      ,DECODE(M.ACT_CUST_CNT_CD||M.ACT_CUST_SEQ,'','N'," ).append("\n"); 
		query.append("             DECODE(BC.CUST_CNT_CD ,'','N', " ).append("\n"); 
		query.append("                   DECODE(MD.CNT_NM ,'','N', " ).append("\n"); 
		query.append("                         DECODE(BC2.CUST_CNT_CD ,'','N', " ).append("\n"); 
		query.append("                               DECODE(MD2.CNT_NM ,'','N', " ).append("\n"); 
		query.append("                                     DECODE(MAX(BR.DE_NO) ,'','N', " ).append("\n"); 
		query.append("                                           DECODE(MAX(BR.PRT_NO) ,'','N','Y'))))))) AS VALID" ).append("\n"); 
		query.append("      ,NVL(MAX(H1.EDI_SND_FLG),'N') AS EDI_SND_FLG" ).append("\n"); 
		query.append("      ,DECODE(ACK_RSLT_CD,'A','Accept','R','Reject') AS HP_ACK_CD" ).append("\n"); 
		query.append("      ,H1.UPD_USR_ID   " ).append("\n"); 
		query.append("  FROM INV_AR_MN    M" ).append("\n"); 
		query.append("      ,INV_AR_CHG   C" ).append("\n"); 
		query.append("      ,BKG_BOOKING  B" ).append("\n"); 
		query.append("      ,BKG_VVD      V" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("      ,MDM_COUNTRY  MD" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BC2" ).append("\n"); 
		query.append("      ,MDM_COUNTRY  MD2" ).append("\n"); 
		query.append("      ,BKG_REF_DTL  BR" ).append("\n"); 
		query.append("      ,INV_HP_EDI_HDR H1" ).append("\n"); 
		query.append("      ,INV_EDI_ACK H2" ).append("\n"); 
		query.append(" WHERE M.AR_IF_NO   = C.AR_IF_NO" ).append("\n"); 
		query.append("   AND C.CURR_CD    = 'USD'" ).append("\n"); 
		query.append("   AND M.BKG_NO     = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO     = BC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO     = V.BKG_NO" ).append("\n"); 
		query.append("   AND V.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("   AND BC.CUST_CNT_CD = MD.CNT_CD(+)" ).append("\n"); 
		query.append("   AND BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND B.BKG_NO     = BC2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BC2.CUST_CNT_CD = MD2.CNT_CD(+)" ).append("\n"); 
		query.append("   AND BC2.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND B.BKG_NO     = BR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND M.INV_NO   = H1.INV_NO(+)" ).append("\n"); 
		query.append("   AND M.BL_SRC_NO   = H1.BL_SRC_NO(+)" ).append("\n"); 
		query.append("   AND H1.HP_INV_NO = SUBSTR(H2.ACK_KEY_NO(+),1,9)" ).append("\n"); 
		query.append("   AND H2.ACK_SNDR_ID(+) = 'HP'" ).append("\n"); 
		query.append("   AND NVL(H1.INV_SEQ,0) = (SELECT NVL(MAX(INV_SEQ),0) " ).append("\n"); 
		query.append("                          FROM INV_HP_EDI_HDR Z" ).append("\n"); 
		query.append("                         WHERE INV_NO(+) = M.INV_NO AND BL_SRC_NO(+) = M.BL_SRC_NO)" ).append("\n"); 
		query.append("   AND M.AR_OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${retr_opt} == 'B') " ).append("\n"); 
		query.append("   AND M.BL_SRC_NO  = @[bl_src_no]" ).append("\n"); 
		query.append("#elseif (${retr_opt} == 'N') " ).append("\n"); 
		query.append("   AND M.INV_NO  = @[inv_no]" ).append("\n"); 
		query.append("#elseif (${retr_opt} == 'V') " ).append("\n"); 
		query.append("   AND V.VSL_CD = substr(@[vvd],0,4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = substr(@[vvd],9,1)	" ).append("\n"); 
		query.append("#elseif (${retr_opt} == 'I') " ).append("\n"); 
		query.append("   AND M.ISS_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${retr_opt} == 'G')" ).append("\n"); 
		query.append("   AND M.BL_INV_CFM_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND M.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("   AND M.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("   AND NVL(M.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND M.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("#if (${sent_stat} != '') " ).append("\n"); 
		query.append("   AND NVL(H1.EDI_SND_FLG,'N') = @[sent_stat]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY M.BL_SRC_NO" ).append("\n"); 
		query.append("      ,M.INV_NO" ).append("\n"); 
		query.append("      ,M.ISS_DT" ).append("\n"); 
		query.append("      ,C.CURR_CD" ).append("\n"); 
		query.append("      ,V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,B.POL_CD" ).append("\n"); 
		query.append("      ,B.POD_CD" ).append("\n"); 
		query.append("      ,M.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,M.ACT_CUST_SEQ" ).append("\n"); 
		query.append("      ,BC.CUST_CNT_CD " ).append("\n"); 
		query.append("      ,MD.CNT_NM  " ).append("\n"); 
		query.append("      ,BC2.CUST_CNT_CD " ).append("\n"); 
		query.append("      ,MD2.CNT_NM" ).append("\n"); 
		query.append("      ,H1.UPD_USR_ID" ).append("\n"); 
		query.append("      ,H2.ACK_RSLT_CD" ).append("\n"); 
		query.append(" ORDER BY M.INV_NO, M.BL_SRC_NO" ).append("\n"); 

	}
}