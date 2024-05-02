/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltHisAmdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.16 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltHisAmdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAO
	  * </pre>
	  */
	public SCProposalMainDBDAORsltHisAmdVORSQL(){
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltHisAmdVORSQL").append("\n"); 
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
		query.append("SELECT   PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '03')" ).append("\n"); 
		query.append("		,DECODE('04',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '04')" ).append("\n"); 
		query.append("		,DECODE('07',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '11')" ).append("\n"); 
		query.append("		,DECODE('41',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append("		,DECODE('13',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("		,DECODE('14',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("		,DECODE('51',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("		,DECODE('71',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("		,DECODE('32',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '17')" ).append("\n"); 
		query.append("		,DECODE('15',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '18')" ).append("\n"); 
		query.append("		,DECODE('61',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '19')" ).append("\n"); 
		query.append("		,DECODE('16',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		,DECODE(@[term_type_cd],PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        ,MAX (AMDT_FLG)  AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		,DAT_FLG" ).append("\n"); 
		query.append("FROM     (SELECT DECODE(PROP_TERM_TP_CD,'03','02',PROP_TERM_TP_CD ) PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("                ,DECODE (AMDT_FLG, 'Y', 1, 0) AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				,0 AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				, 0 DAT_FLG" ).append("\n"); 
		query.append("          FROM   PRI_SP_AMDT_SMRY" ).append("\n"); 
		query.append("          WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT CASE PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                    WHEN '11'" ).append("\n"); 
		query.append("                       THEN '01'" ).append("\n"); 
		query.append("                    WHEN '12'" ).append("\n"); 
		query.append("                       THEN '02'" ).append("\n"); 
		query.append("                    WHEN '42'" ).append("\n"); 
		query.append("                       THEN '41'" ).append("\n"); 
		query.append("                    WHEN '52'" ).append("\n"); 
		query.append("                       THEN '51'" ).append("\n"); 
		query.append("                    WHEN '62'" ).append("\n"); 
		query.append("                       THEN '61'" ).append("\n"); 
		query.append("                    WHEN '72'" ).append("\n"); 
		query.append("                       THEN '71'" ).append("\n"); 
		query.append("                    ELSE PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("				,0 " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                ,DECODE (AMDT_FLG, 'Y', 1, 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				,DECODE (PROP_SCP_TERM_TP_CD ,'32'," ).append("\n"); 
		query.append("        				(SELECT  COUNT(*) FROM    PRI_SP_SCP_NOTE  " ).append("\n"); 
		query.append("						 WHERE   PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("					     AND     AMDT_SEQ   = A.AMDT_SEQ" ).append("\n"); 
		query.append("				         AND     SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("				         AND     NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("				         AND     ROWNUM = 1)" ).append("\n"); 
		query.append("						 , 0) " ).append("\n"); 
		query.append("          FROM   PRI_SP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("          WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("          AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND    PROP_SCP_TERM_TP_CD NOT IN ('31'))" ).append("\n"); 
		query.append("GROUP BY PROP_SCP_TERM_TP_CD,DAT_FLG" ).append("\n"); 

	}
}