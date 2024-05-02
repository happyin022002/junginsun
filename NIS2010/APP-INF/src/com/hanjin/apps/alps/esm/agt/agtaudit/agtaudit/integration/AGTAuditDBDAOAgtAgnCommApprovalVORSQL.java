/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOAgtAgnCommApprovalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAgtAgnCommApprovalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent Commission Approval 대상을 조회한다.
	  * </pre>
	  */
	public AGTAuditDBDAOAgtAgnCommApprovalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAgtAgnCommApprovalVORSQL").append("\n"); 
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
		query.append("A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("B.BL_NO AS BL_NO," ).append("\n"); 
		query.append("A.AGN_CD AS AGN_CD," ).append("\n"); 
		query.append("A.IO_BND_CD AS IO_BND_CD," ).append("\n"); 
		query.append("A.AC_SEQ AS AC_SEQ," ).append("\n"); 
		query.append("SUM(A.ACT_IF_COMM_AMT) AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("SUM(A.ACT_IF_LOCL_COMM_AMT) AS ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("A.AR_OFC_CD AS AR_OFC_CD" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM A, AGT_COMM_BKG_INFO B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} == 'HAMUR' or ${ar_ofc_cd} == 'HAMBB')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IN (@[ar_ofc_cd], 'HAMUR','HAMBB')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (A.BKG_NO||A.AGN_CD||A.IO_BND_CD||A.AC_SEQ) IN (${arr_val})" ).append("\n"); 
		query.append("AND ((@[scn_id] = 'AGTCOMM' AND A.AC_TP_CD <> 'T') OR (@[scn_id] = 'OTHER' AND A.AC_TP_CD = 'T'))" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD IN ('RS','RM')" ).append("\n"); 
		query.append("#if (${scn_id} == 'OTHER')" ).append("\n"); 
		query.append("#if (${exp_type} == 'G')" ).append("\n"); 
		query.append("AND A.COMM_STND_COST_CD not IN ('512692','512693') -- //:comm_stnd_cost_cd(General or General Exception)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.COMM_STND_COST_CD IN ('512692','512693')    -- //:comm_stnd_cost_cd(General or General Exception)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("#if (${sts_cd} != '')" ).append("\n"); 
		query.append("#if (${sts_cd} == '4')" ).append("\n"); 
		query.append("AND TO_DATE(A.SAIL_ARR_DT,'YYYYMMDD') BETWEEN TO_DATE(@[from_date],'YYYYMMDD') AND TO_DATE(@[to_date],'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AC_RQST_DT BETWEEN TO_DATE(@[from_date],'YYYYMMDD') AND TO_DATE(@[to_date],'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO, A.AC_SEQ, A.AGN_CD, A.IO_BND_CD, B.BL_NO, A.AR_OFC_CD" ).append("\n"); 

	}
}