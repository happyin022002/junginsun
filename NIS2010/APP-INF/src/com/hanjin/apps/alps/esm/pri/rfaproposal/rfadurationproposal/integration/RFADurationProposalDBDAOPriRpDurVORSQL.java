/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFADurationProposalDBDAOPriRpDurVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.17 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFADurationProposalDBDAOPriRpDurVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Proposal Creation - Duration select
	  * </pre>
	  */
	public RFADurationProposalDBDAOPriRpDurVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.integration").append("\n"); 
		query.append("FileName : RFADurationProposalDBDAOPriRpDurVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.PROP_NO                       ," ).append("\n"); 
		query.append("A.AMDT_SEQ                      ," ).append("\n"); 
		query.append("TO_CHAR(A.CTRT_EFF_DT, 'YYYYMMDD') CTRT_EFF_DT            ," ).append("\n"); 
		query.append("TO_CHAR(A.CTRT_EXP_DT, 'YYYYMMDD') CTRT_EXP_DT       ," ).append("\n"); 
		query.append("A.N1ST_CMNC_AMDT_SEQ ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_RP_MN WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  ) EFF_DT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("END AS EXP_DT" ).append("\n"); 
		query.append("FROM PRI_RP_MN N" ).append("\n"); 
		query.append("WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END  EXP_DT," ).append("\n"); 
		query.append("A.SRC_INFO_CD                   ," ).append("\n"); 
		query.append("SRC.INTG_CD_VAL_DESC SRC_INFO_NM  ," ).append("\n"); 
		query.append("A.PRC_PROG_STS_CD ," ).append("\n"); 
		query.append("STS.INTG_CD_VAL_DESC PRC_PROG_STS_NM ," ).append("\n"); 
		query.append("A.ACPT_USR_ID," ).append("\n"); 
		query.append("A.ACPT_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.ACPT_DT,'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append(",TO_CHAR(M.EFF_DT, 'YYYYMMDD') MN_EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(M.EXP_DT, 'YYYYMMDD') MN_EXP_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.CTRT_EXP_DT, 'YYYYMMDD') ORI_EXP_DT" ).append("\n"); 
		query.append(",NVL((" ).append("\n"); 
		query.append("SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS EXP_DT" ).append("\n"); 
		query.append("FROM PRI_RP_MN N" ).append("\n"); 
		query.append("WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1" ).append("\n"); 
		query.append("),'N') DUR_DUP_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_DUR A  ," ).append("\n"); 
		query.append("PRI_RP_MN           M  ," ).append("\n"); 
		query.append("COM_INTG_CD_DTL        SRC," ).append("\n"); 
		query.append("COM_INTG_CD_DTL        STS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("M.PROP_NO           = A.PROP_NO" ).append("\n"); 
		query.append("AND M.AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ IN ( @[amdt_seq], @[amdt_seq] -1 )" ).append("\n"); 
		query.append("AND    ( A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND  NOT EXISTS ( SELECT 'X' FROM PRI_RP_DUR B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("B.PROP_NO            = A.PROP_NO" ).append("\n"); 
		query.append("AND B.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("AND B.N1ST_CMNC_AMDT_SEQ    = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SRC.INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("AND SRC.INTG_CD_ID       = 'CD02198'" ).append("\n"); 
		query.append("AND STS.INTG_CD_VAL_CTNT = A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID       = 'CD01719'" ).append("\n"); 
		query.append("ORDER BY A.AMDT_SEQ" ).append("\n"); 

	}
}