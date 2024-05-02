/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCheckArMasterRevenueVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCheckArMasterRevenueVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ArMasterRevenueVvd checked
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCheckArMasterRevenueVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCheckArMasterRevenueVvdRSQL").append("\n"); 
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
		query.append("SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD||B.RLANE_DIR_CD AS AR_VVD" ).append("\n"); 
		query.append("  FROM JOO_SETTLEMENT A" ).append("\n"); 
		query.append("     , AR_MST_REV_VVD B" ).append("\n"); 
		query.append("     , JOO_STL_CMB E" ).append("\n"); 
		query.append("     , JOO_STL_CMB_DTL J" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.REV_DIR_CD     = B.RLANE_DIR_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD       = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.ACCT_YRMON     = J.ACCT_YRMON" ).append("\n"); 
		query.append("   AND A.STL_VVD_SEQ    = J.STL_VVD_SEQ" ).append("\n"); 
		query.append("   AND A.STL_SEQ        = J.STL_SEQ" ).append("\n"); 
		query.append("   AND J.ACCT_YRMON     = E.ACCT_YRMON" ).append("\n"); 
		query.append("   AND J.JO_CRR_CD      = E.JO_CRR_CD" ).append("\n"); 
		query.append("   AND J.STL_CMB_SEQ    = E.STL_CMB_SEQ" ).append("\n"); 
		query.append("   AND J.RE_DIVR_CD     = E.RE_DIVR_CD" ).append("\n"); 
		query.append("   AND A.ACCT_YRMON     = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND J.STL_CMB_SEQ    = TO_NUMBER(@[stl_cmb_seq])" ).append("\n"); 
		query.append("   AND A.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("   AND A.STL_LOCL_AMT   <> 0" ).append("\n"); 

	}
}