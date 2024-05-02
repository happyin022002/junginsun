/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCProposalMainDBDAORsltAmdtHisMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltAmdtHisMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amendment History Inquery list 조회
	  * </pre>
	  */
	public SCProposalMainDBDAORsltAmdtHisMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_type_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltAmdtHisMnVORSQL").append("\n"); 
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
		query.append("#if (${svc_scp_cd} == 'X' && (${term_type_cd} == '01' || ${term_type_cd} == '02' || ${term_type_cd} == '03' || ${term_type_cd} == '04' || ${term_type_cd} == '05' || ${term_type_cd} == '06' || ${term_type_cd} == '') )" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,DECODE(MN.CONV_CFM_FLG,'Y','1','0') CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,(SELECT CONV_CFM_FLG FROM PRI_SP_MN WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ - 1) PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ IN (SELECT AMDT_SEQ FROM PRI_SP_MN WHERE PROP_NO =@[prop_no] AND PROP_STS_CD ='F')" ).append("\n"); 
		query.append("#if (${conv_flg} == '0')" ).append("\n"); 
		query.append("AND    1 =(SELECT COUNT (1)" ).append("\n"); 
		query.append("           FROM   PRI_SP_AMDT_SMRY" ).append("\n"); 
		query.append("           WHERE  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("           AND    AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '02')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD IN ('02','03')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '03')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '04'" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '04')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '07'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("           AND    ROWNUM = 1) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,'2' CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,'N' PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN SCP" ).append("\n"); 
		query.append("      ,PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'X')" ).append("\n"); 
		query.append("AND    SCP.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ IN (SELECT AMDT_SEQ FROM PRI_SP_MN WHERE PROP_NO =@[prop_no] AND PROP_STS_CD ='F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    1 =(SELECT COUNT (1)" ).append("\n"); 
		query.append("           FROM   PRI_SP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("           WHERE  PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("           AND    AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("           AND    SVC_SCP_CD = SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '11')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD IN ('41','42')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('13')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('14')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('51','52')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('71','72')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('32')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '17')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('15')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '18')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '19')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('16')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '01')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('11')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '02')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('12')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conv_flg} == '0')" ).append("\n"); 
		query.append("           AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND    ROWNUM = 1)" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == 'X' )" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,DECODE(MN.CONV_CFM_FLG,'Y','1','0') CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,(SELECT CONV_CFM_FLG FROM PRI_SP_MN WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ -1) PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,'2' CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,'N' PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN SCP" ).append("\n"); 
		query.append("      ,PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = 0" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'X')" ).append("\n"); 
		query.append("AND    SCP.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AMDT_SEQ DESC ,SVC_SCP_CD DESC" ).append("\n"); 

	}
}