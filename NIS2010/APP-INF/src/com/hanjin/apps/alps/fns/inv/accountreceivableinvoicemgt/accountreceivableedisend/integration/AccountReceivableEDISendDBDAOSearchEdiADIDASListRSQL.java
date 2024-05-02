/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiADIDASListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
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

public class AccountReceivableEDISendDBDAOSearchEdiADIDASListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiADIDASList
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiADIDASListRSQL(){
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
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiADIDASListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  T.IO_BND_CD," ).append("\n"); 
		query.append("  T.BL_SRC_NO," ).append("\n"); 
		query.append("  T.POL_CD," ).append("\n"); 
		query.append("  T.POD_CD," ).append("\n"); 
		query.append("  T.INV_NO," ).append("\n"); 
		query.append("  T.ISS_DT," ).append("\n"); 
		query.append("  T.TTL_AMT," ).append("\n"); 
		query.append("  T.DUE_DT," ).append("\n"); 
		query.append("  NVL(E.EDI_SND_FLG, 'N') EDI_SND_FLG," ).append("\n"); 
		query.append("  TO_CHAR(E.EDI_SND_DT, 'YYYY-MM-DD HH24:MI:SS') EDI_SND_DT," ).append("\n"); 
		query.append("  DECODE(ACK.ACK_RSLT_CD, 'A', 'Accept', 'R', 'Reject', '') RECEIPT," ).append("\n"); 
		query.append("  TO_CHAR(ACK.ACK_DT, 'YYYY-MM-DD HH24:MI:SS') RECEIPT_DT" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("		A.IO_BND_CD IO_BND_CD," ).append("\n"); 
		query.append("		A.BL_SRC_NO BL_SRC_NO," ).append("\n"); 
		query.append("        A.POL_CD POL_CD," ).append("\n"); 
		query.append("        A.POD_CD POD_CD," ).append("\n"); 
		query.append("        C.INV_NO INV_NO," ).append("\n"); 
		query.append("        C.ISS_DT ISS_DT," ).append("\n"); 
		query.append("        ROUND(SUM(B.CHG_AMT * B.INV_XCH_RT), 2) TTL_AMT," ).append("\n"); 
		query.append("        A.DUE_DT DUE_DT, " ).append("\n"); 
		query.append("        (SELECT MAX(SND_SEQ) FROM INV_EDI_DHL WHERE C.INV_NO = INV_NO) MAX_SEQ," ).append("\n"); 
		query.append("		'A' AS INV_EDI_KND_CD" ).append("\n"); 
		query.append("      FROM INV_AR_MN A, INV_AR_CHG B, INV_AR_ISS C, INV_AR_ISS_DTL D" ).append("\n"); 
		query.append("      WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND A.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("        AND B.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("        AND B.CHG_SEQ = D.CHG_SEQ" ).append("\n"); 
		query.append("        AND A.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("        AND C.INV_SEQ = 1" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("        AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("        AND A.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${retr_opt} == 'B')  -- B/L NO" ).append("\n"); 
		query.append("        AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'N')  -- INV NO" ).append("\n"); 
		query.append("        AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'V')  -- VVD" ).append("\n"); 
		query.append("        AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'I')  -- ISSUE DATE" ).append("\n"); 
		query.append("        AND C.ISS_DT BETWEEN REPLACE (@[fm_dt],'-','') AND REPLACE (@[to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'S')  -- S/A DATE" ).append("\n"); 
		query.append("        AND A.SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      GROUP BY A.BL_SRC_NO, A.POL_CD, A.POD_CD, C.INV_NO, C.ISS_DT, A.DUE_DT, A.IO_BND_CD" ).append("\n"); 
		query.append("      ORDER BY A.BL_SRC_NO, C.INV_NO" ).append("\n"); 
		query.append("     ) T," ).append("\n"); 
		query.append("  INV_EDI_DHL E," ).append("\n"); 
		query.append("  INV_EDI_ACK ACK" ).append("\n"); 
		query.append("WHERE T.INV_NO = E.INV_NO(+)" ).append("\n"); 
		query.append("  AND T.MAX_SEQ = E.SND_SEQ(+)" ).append("\n"); 
		query.append("  AND T.INV_EDI_KND_CD = E.INV_EDI_KND_CD (+)" ).append("\n"); 
		query.append("  AND E.FLT_FILE_REF_NO = ACK.ACK_KEY_NO(+)" ).append("\n"); 
		query.append("#if (${sent_stat} != '' && ${sent_stat} != 'A') -- Send status" ).append("\n"); 
		query.append("  AND E.EDI_SND_FLG = @[sent_stat]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}