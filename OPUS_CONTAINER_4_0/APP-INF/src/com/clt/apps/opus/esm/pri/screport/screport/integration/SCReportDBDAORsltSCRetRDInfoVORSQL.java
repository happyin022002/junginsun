/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCReportDBDAORsltSCRetRDInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSCRetRDInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCReportDBDAORsltSCRetRDInfoVORSQL
	  * </pre>
	  */
	public SCReportDBDAORsltSCRetRDInfoVORSQL(){
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
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSCRetRDInfoVORSQL").append("\n"); 
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
		query.append("SC_NO               ," ).append("\n"); 
		query.append("AMDT_SEQ            ," ).append("\n"); 
		query.append("MAX_SEQ             ," ).append("\n"); 
		query.append("CTRT_EFF_DT         ," ).append("\n"); 
		query.append("CTRT_EXP_DT         ," ).append("\n"); 
		query.append("PROP_OFC_CD         ," ).append("\n"); 
		query.append("PRC_CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("PROP_SREP_CD        ," ).append("\n"); 
		query.append("APRO_USR_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HDR.SC_NO                   ," ).append("\n"); 
		query.append("MN.AMDT_SEQ                 ," ).append("\n"); 
		query.append("MAX(MN.AMDT_SEQ) OVER (PARTITION BY SC_NO) MAX_SEQ," ).append("\n"); 
		query.append("TO_CHAR(DUR.CTRT_EFF_DT,'YYYY-MM-DD') CTRT_EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(DUR.CTRT_EXP_DT,'YYYY-MM-DD') CTRT_EXP_DT," ).append("\n"); 
		query.append("MN.PROP_OFC_CD          ," ).append("\n"); 
		query.append("CUST.PRC_CTRT_CUST_TP_CD," ).append("\n"); 
		query.append("MN.PROP_SREP_CD         ," ).append("\n"); 
		query.append("DECODE (USR.USR_CNT, 0, 'N', DECODE(SIGN(AUTH.CNT2),1,'Y','N')) APRO_USR_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_HDR HDR          ," ).append("\n"); 
		query.append("PRI_SP_MN MN            ," ).append("\n"); 
		query.append("PRI_SP_DUR DUR          ," ).append("\n"); 
		query.append("PRI_SP_CTRT_CUST_TP CUST," ).append("\n"); 
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
		query.append("MN.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND MN.PROP_NO  = HDR.PROP_NO" ).append("\n"); 
		query.append("AND MN.PROP_NO  = DUR.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.PROP_NO  = CUST.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD IN ('I', 'A', 'F', 'Q')" ).append("\n"); 
		query.append("AND AUTH.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND AUTH.AMDT_SEQ(+)= MN.AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE AMDT_SEQ = MAX_SEQ" ).append("\n"); 

	}
}