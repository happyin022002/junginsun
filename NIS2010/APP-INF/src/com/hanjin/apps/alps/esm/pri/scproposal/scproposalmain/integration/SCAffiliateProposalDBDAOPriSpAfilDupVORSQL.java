/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCAffiliateProposalDBDAOPriSpAfilDupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.05.20 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCAffiliateProposalDBDAOPriSpAfilDupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직 
	  * S/C type 별 Request/Approve 당시의 Master 정보 (MDM/CRM) 상 type 정보가 아래와 같을 경우. 
	  *       S/C Type	Master Type	Alert
	  * --①	BCO	≠ BCO	Attention :  Affiliate type not match to S/C type!!
	  * --②	Association	혼재 시	Attention :  Mixed type of Affiliate!!!
	  * --③	NVO	≠ NVO	Attention :  Affiliate type not match to S/C type!!
	  * --④	Others	혼재 시	Attention :  Mixed type of Affiliate!!!
	  * </pre>
	  */
	public SCAffiliateProposalDBDAOPriSpAfilDupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCAffiliateProposalDBDAOPriSpAfilDupVORSQL").append("\n"); 
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
		query.append("SELECT C.PRC_CTRT_CUST_TP_CD AS ETC1 -- CASE 1,3적용 -> 1) BCO('I') ≠ BCO('B') , 3) NVO('N') ≠ NVO('N') " ).append("\n"); 
		query.append("    FROM   " ).append("\n"); 
		query.append("         PRI_SP_AFIL        A  " ).append("\n"); 
		query.append("        ,PRI_SP_MN          M  " ).append("\n"); 
		query.append("        ,MDM_CUSTOMER       MDM" ).append("\n"); 
		query.append("        ,PRI_SP_CTRT_CUST_TP C " ).append("\n"); 
		query.append("    WHERE " ).append("\n"); 
		query.append("        M.PROP_NO           	= A.PROP_NO" ).append("\n"); 
		query.append("    AND M.AMDT_SEQ              = A.AMDT_SEQ   " ).append("\n"); 
		query.append("    AND C.PROP_NO           	= A.PROP_NO" ).append("\n"); 
		query.append("    AND C.AMDT_SEQ              = A.AMDT_SEQ " ).append("\n"); 
		query.append("    AND C.PRC_CTRT_PTY_TP_CD    = 'C'" ).append("\n"); 
		query.append("    AND A.CUST_CNT_CD       	= MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("    AND A.CUST_SEQ          	= MDM.CUST_SEQ" ).append("\n"); 
		query.append("    AND A.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("    AND A.PROP_NO 				= @[prop_no]" ).append("\n"); 
		query.append("    AND A.MNL_INP_FLG           = 'N'" ).append("\n"); 
		query.append("    AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    AND C.PRC_CTRT_CUST_TP_CD   IN ( 'I', 'N' ) -- CASE BCO	, NVO " ).append("\n"); 
		query.append("    AND    EXISTS ( SELECT '1'" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER T" ).append("\n"); 
		query.append("                     WHERE T.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND T.CUST_SEQ    = A.CUST_SEQ" ).append("\n"); 
		query.append("                       AND T.RVIS_CNTR_CUST_TP_CD = DECODE ( C.PRC_CTRT_CUST_TP_CD, 'I', 'N', 'N', 'B' )" ).append("\n"); 
		query.append("                    )                  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("  SELECT C.PRC_CTRT_CUST_TP_CD     AS ETC1 -- CASE 2,4적용 ->  2) Association('A') -> 혼재 시 , 4) Others('O') -> 혼재 시" ).append("\n"); 
		query.append("    FROM PRI_SP_MN          M  " ).append("\n"); 
		query.append("        ,PRI_SP_CTRT_CUST_TP C " ).append("\n"); 
		query.append("   WHERE C.PROP_NO           	= M.PROP_NO" ).append("\n"); 
		query.append("     AND C.AMDT_SEQ             = M.AMDT_SEQ " ).append("\n"); 
		query.append("     AND C.PRC_CTRT_PTY_TP_CD   = 'C'" ).append("\n"); 
		query.append("     AND M.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("     AND M.PROP_NO 				= @[prop_no]" ).append("\n"); 
		query.append("     AND C.PRC_CTRT_CUST_TP_CD   IN ( 'A', 'O' )  -- CASE Association, Others	 " ).append("\n"); 
		query.append("     AND ( SELECT COUNT  ( DISTINCT T1.RVIS_CNTR_CUST_TP_CD ) " ).append("\n"); 
		query.append("            FROM MDM_CUSTOMER T1" ).append("\n"); 
		query.append("                ,PRI_SP_AFIL  T2" ).append("\n"); 
		query.append("           WHERE T1.CUST_CNT_CD = T2.CUST_CNT_CD" ).append("\n"); 
		query.append("             AND T1.CUST_SEQ    = T2.CUST_SEQ" ).append("\n"); 
		query.append("             AND T2.MNL_INP_FLG = 'N'" ).append("\n"); 
		query.append("             AND T2.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("             AND T2.PROP_NO     = M.PROP_NO" ).append("\n"); 
		query.append("             AND T2.AMDT_SEQ    = M.AMDT_SEQ" ).append("\n"); 
		query.append("          ) > 1" ).append("\n"); 

	}
}