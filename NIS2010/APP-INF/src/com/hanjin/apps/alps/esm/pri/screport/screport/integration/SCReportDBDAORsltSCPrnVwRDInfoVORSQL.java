/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCReportDBDAORsltSCPrnVwRDInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSCPrnVwRDInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCReportDBDAORsltSCPrnVwRDInfoVO
	  * </pre>
	  */
	public SCReportDBDAORsltSCPrnVwRDInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSCPrnVwRDInfoVORSQL").append("\n"); 
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
		query.append("HDR.SC_NO               ," ).append("\n"); 
		query.append("MN.PROP_NO      		," ).append("\n"); 
		query.append("MN.AMDT_SEQ     		," ).append("\n"); 
		query.append("TO_CHAR(DUR.CTRT_EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(DUR.CTRT_EXP_DT,'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("TO_CHAR(MN.FILE_DT,'YYYY-MM-DD') FILE_DT," ).append("\n"); 
		query.append("MN.PROP_OFC_CD," ).append("\n"); 
		query.append("MN.PROP_SREP_CD," ).append("\n"); 
		query.append("MN.PROP_APRO_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(MN.CRE_DT,'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CASE WHEN MN.PROP_STS_CD IN ('A','F') THEN USR.USR_NM ELSE '' END" ).append("\n"); 
		query.append("FROM PRI_SP_PROG PROG, COM_USER USR" ).append("\n"); 
		query.append("WHERE   PROG.PROP_NO     = INP.PROP_NO" ).append("\n"); 
		query.append("AND     PROG.AMDT_SEQ    = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND     PROG.PROP_PROG_SEQ = (SELECT MAX(PROP_PROG_SEQ) FROM pri_sp_prog" ).append("\n"); 
		query.append("WHERE PROP_NO = INP.PROP_NO AND AMDT_SEQ = INP.AMDT_SEQ AND PROP_STS_CD = 'A' )" ).append("\n"); 
		query.append("AND   PROG.PROG_USR_ID = USR.USR_ID" ).append("\n"); 
		query.append(") APRO_USR_NM," ).append("\n"); 
		query.append("DECODE (USR.USR_CNT, 0, 'N', DECODE(SIGN(AUTH.CNT2),1,'Y','N')) APRO_USR_FLG," ).append("\n"); 
		query.append("(SELECT AMDT_FLG FROM PRI_SP_AMDT_SMRY WHERE PROP_NO = INP.PROP_NO AND AMDT_SEQ = INP.AMDT_SEQ AND PROP_TERM_TP_CD = '06') BLPL_AMDT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO                 ," ).append("\n"); 
		query.append("AMDT_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(") INP  	            ," ).append("\n"); 
		query.append("PRI_SP_HDR HDR      ," ).append("\n"); 
		query.append("PRI_SP_MN MN    	," ).append("\n"); 
		query.append("PRI_SP_DUR DUR      ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.PROP_NO,B.AMDT_SEQ," ).append("\n"); 
		query.append("COUNT(A.SVC_SCP_CD) CNT2" ).append("\n"); 
		query.append("FROM   PRI_AUTHORIZATION A," ).append("\n"); 
		query.append("PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SVC_SCP_CD        = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.USR_ID            = @[usr_id]" ).append("\n"); 
		query.append("AND A.PRC_CTRT_TP_CD    = 'S'" ).append("\n"); 
		query.append("AND A.EXP_DT > SYSDATE" ).append("\n"); 
		query.append("GROUP BY B.PROP_NO,B.AMDT_SEQ" ).append("\n"); 
		query.append(") AUTH," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COUNT (*) USR_CNT" ).append("\n"); 
		query.append("FROM   COM_USER USR" ).append("\n"); 
		query.append("WHERE  USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#if (${rhq_yn} == 'Y')" ).append("\n"); 
		query.append("AND    @[rhq_ofc_cd] IN (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    OFC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT MN.PROP_APRO_OFC_CD OFC_CD" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT MN.PROP_SCP_APRO_OFC_CD" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append("WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")USR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INP.PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("AND INP.AMDT_SEQ 	= MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND INP.PROP_NO 	= DUR.PROP_NO" ).append("\n"); 
		query.append("AND INP.AMDT_SEQ 	= DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND INP.PROP_NO     = HDR.PROP_NO" ).append("\n"); 
		query.append("AND AUTH.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND AUTH.AMDT_SEQ(+)= MN.AMDT_SEQ" ).append("\n"); 

	}
}