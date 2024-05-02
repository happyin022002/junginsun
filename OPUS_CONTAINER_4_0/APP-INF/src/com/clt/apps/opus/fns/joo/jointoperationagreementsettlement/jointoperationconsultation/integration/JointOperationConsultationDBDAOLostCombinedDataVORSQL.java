/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOLostCombinedDataVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOLostCombinedDataVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationConsultationDBDAOLostCombinedDataVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOLostCombinedDataVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A.ACCT_YRMON," ).append("\n"); 
		query.append("       NVL(D.LST_LGIN_OFC_CD,D.OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       NVL(A.CMB_CFM_FLG,'N') AS CMB_CFM_FLG," ).append("\n"); 
		query.append("       NULL AS STL_CMB_SEQ," ).append("\n"); 
		query.append("       A.STL_ADJ_FLG" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT   A," ).append("\n"); 
		query.append("       COM_USER         D" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID  = D.USR_ID(+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#if (${slp_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    NVL(D.LST_LGIN_OFC_CD,D.OFC_CD) = @[slp_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    NVL(A.CMB_CFM_FLG,'N') = 'N'" ).append("\n"); 
		query.append("UNION  ALL" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A.ACCT_YRMON," ).append("\n"); 
		query.append("       NVL(C.SLP_OFC_CD, NVL(D.LST_LGIN_OFC_CD,D.OFC_CD)) AS OFC_CD," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       A.CMB_CFM_FLG," ).append("\n"); 
		query.append("       B.STL_CMB_SEQ," ).append("\n"); 
		query.append("       A.STL_ADJ_FLG" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT   A," ).append("\n"); 
		query.append("       JOO_STL_CMB_DTL  B," ).append("\n"); 
		query.append("       JOO_STL_CMB      C," ).append("\n"); 
		query.append("       COM_USER         D" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ" ).append("\n"); 
		query.append("AND    B.ACCT_YRMON  = C.ACCT_YRMON" ).append("\n"); 
		query.append("AND    B.JO_CRR_CD   = C.JO_CRR_CD" ).append("\n"); 
		query.append("AND    B.STL_CMB_SEQ = C.STL_CMB_SEQ" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD  = C.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    A.CRE_USR_ID  = D.USR_ID(+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#if (${slp_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    NVL(D.LST_LGIN_OFC_CD,D.OFC_CD) = @[slp_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND    C.SLP_SER_NO IS NULL" ).append("\n"); 
		query.append("ORDER  BY 1,2,3,4,5" ).append("\n"); 

	}
}