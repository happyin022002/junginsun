/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCAffiliateProposalDBDAORsltPriSpAfilInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.05.18 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCAffiliateProposalDBDAORsltPriSpAfilInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직   
	  * </pre>
	  */
	public SCAffiliateProposalDBDAORsltPriSpAfilInqVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.integration").append("\n"); 
		query.append("FileName : SCAffiliateProposalDBDAORsltPriSpAfilInqVORSQL").append("\n"); 
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
		query.append("     A.PROP_NO             " ).append("\n"); 
		query.append("    ,A.AMDT_SEQ            " ).append("\n"); 
		query.append("    ,A.AFIL_SEQ           " ).append("\n"); 
		query.append("	,A.CUST_CNT_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.CUST_SEQ, '000000') CUST_SEQ" ).append("\n"); 
		query.append("	,DECODE(A.MNL_INP_FLG, 'Y', '1', '0') MNL_INP_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,MDM.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("    ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD00697'" ).append("\n"); 
		query.append("         AND INTG_CD_VAL_CTNT = MDM.RVIS_CNTR_CUST_TP_CD) AS RVIS_CNTR_CUST_TP_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,A.CUST_NM" ).append("\n"); 
		query.append("	,A.CUST_ADDR" ).append("\n"); 
		query.append("	,A.CUST_LOC_CD" ).append("\n"); 
		query.append("    ,A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("    ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("										AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  ) EFF_DT" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("        WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("        (    " ).append("\n"); 
		query.append("        SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("        FROM PRI_SP_MN N" ).append("\n"); 
		query.append("        WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1 " ).append("\n"); 
		query.append("        )    " ).append("\n"); 
		query.append("    END  EXP_DT            " ).append("\n"); 
		query.append("    ,A.SRC_INFO_CD" ).append("\n"); 
		query.append("    ,SRC.INTG_CD_VAL_DESC SRC_INFO_DTL       " ).append("\n"); 
		query.append("    ,A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    ,STS.INTG_CD_VAL_DESC PRC_PROG_STS_DTL " ).append("\n"); 
		query.append("    ,A.ACPT_USR_ID" ).append("\n"); 
		query.append("    ,A.ACPT_OFC_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(A.ACPT_DT,'YYYYMMDD') ACPT_DT	" ).append("\n"); 
		query.append("	,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID)||' / '||A.ACPT_OFC_CD ACPT_USR_NM" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("     PRI_SP_AFIL        A  " ).append("\n"); 
		query.append("    ,PRI_SP_MN          M  " ).append("\n"); 
		query.append("    ,MDM_CUSTOMER       MDM" ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL    SRC" ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL    STS" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    M.PROP_NO            = A.PROP_NO" ).append("\n"); 
		query.append("AND M.AMDT_SEQ 			 = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD        = MDM.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ           = MDM.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND M.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO 			 = @[prop_no]" ).append("\n"); 
		query.append("AND SRC.INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("AND SRC.INTG_CD_ID       = 'CD02064'" ).append("\n"); 
		query.append("AND STS.INTG_CD_VAL_CTNT = A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID       = 'CD01719'       " ).append("\n"); 
		query.append("AND A.SRC_INFO_CD 		 <> 'AD'" ).append("\n"); 
		query.append("ORDER BY A.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,A.CUST_SEQ" ).append("\n"); 
		query.append("        ,A.AFIL_SEQ" ).append("\n"); 
		query.append("        ,A.AMDT_SEQ" ).append("\n"); 
		query.append("		,A.CUST_NM" ).append("\n"); 

	}
}