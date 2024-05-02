/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORequestCancelCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.07.28 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORequestCancelCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accept 가능 테이블에서  Accept, Returned상태인 데이터를 조회한다.
	  * </pre>
	  */
	public SCProposalMainDBDAORequestCancelCheckVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORequestCancelCheckVORSQL").append("\n"); 
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
		query.append("SELECT SUM(CNT) CNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD IN  ('A','R')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_CMDT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD IN  ('A','R')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("	AND   NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_LODG_AGN" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_GOH_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("	SELECT DECODE(ACPT_CNT, 0,0,NOT_GC_CNT) CNT" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT (" ).append("\n"); 
		query.append("				SELECT SUM( CNT) FROM (" ).append("\n"); 
		query.append("					SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("					FROM PRI_SP_BLPL_CTNT" ).append("\n"); 
		query.append("    				WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    				AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    				AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    				AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("					AND ROWNUM =1" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("					FROM PRI_SP_BLPL" ).append("\n"); 
		query.append("    				WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    				AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    				AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    				AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("					AND ROWNUM =1" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			) ACPT_CNT," ).append("\n"); 
		query.append("    		(	" ).append("\n"); 
		query.append("				SELECT SUM( CNT) FROM (" ).append("\n"); 
		query.append("					SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("					FROM PRI_SP_BLPL" ).append("\n"); 
		query.append("    				WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    				AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    				AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]    " ).append("\n"); 
		query.append("					AND   SRC_INFO_CD <> 'GC'		" ).append("\n"); 
		query.append("					AND ROWNUM =1" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT COUNT(*) " ).append("\n"); 
		query.append("					FROM PRI_SP_BLPL_CTNT " ).append("\n"); 
		query.append("    				WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    				AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    				AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]    " ).append("\n"); 
		query.append("					AND   SRC_INFO_CD <> 'GC'		" ).append("\n"); 
		query.append("					AND ROWNUM =1" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			) NOT_GC_CNT " ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_AFIL" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${amdt_seq} != '0')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_DUR" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_DUR" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_MQC" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD IN ('A','R')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SUB_MQC" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_MQC" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD IN ('A','R')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_CTRT_CUST_TP" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ROUT_DIR" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}