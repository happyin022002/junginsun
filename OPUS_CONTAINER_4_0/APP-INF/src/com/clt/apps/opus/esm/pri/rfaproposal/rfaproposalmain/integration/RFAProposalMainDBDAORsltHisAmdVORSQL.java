/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltHisAmdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.22 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltHisAmdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltHisAmdVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltHisAmdVORSQL").append("\n"); 
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
		query.append("#if (${term_type_cd} == '07')" ).append("\n"); 
		query.append(",DECODE('08',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append(",DECODE('13',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append(",DECODE('14',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append(",DECODE('51',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append(",DECODE('71',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append(",DECODE('32',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(@[term_type_cd],PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",MAX (AMDT_FLG)  AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",DAT_FLG" ).append("\n"); 
		query.append("FROM     (SELECT PROP_TERM_TP_CD PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append(",DECODE (AMDT_FLG, 'Y', 1, 0) AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",0 AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 0 DAT_FLG" ).append("\n"); 
		query.append("FROM   PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CASE PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("WHEN '11'" ).append("\n"); 
		query.append("THEN '01'" ).append("\n"); 
		query.append("WHEN '52'" ).append("\n"); 
		query.append("THEN '51'" ).append("\n"); 
		query.append("ELSE PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE (AMDT_FLG, 'Y', 1, 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PROP_SCP_TERM_TP_CD,DAT_FLG" ).append("\n"); 

	}
}