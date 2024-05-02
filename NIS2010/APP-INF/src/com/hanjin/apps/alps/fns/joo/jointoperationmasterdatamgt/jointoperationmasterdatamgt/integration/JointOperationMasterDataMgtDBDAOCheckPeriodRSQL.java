/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOCheckPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOCheckPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * Discription : Key 생성규칙변경(OFC+수입/비용 구분+TRADE+REV LANE+Direction(추가)+년월+일련번호(3자리)
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOCheckPeriodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("jo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ref_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOCheckPeriodRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.JO_REF_NO," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.AGMT_EFF_DT,'YYYYMMDD'),'YYYY-MM-DD') AS AGMT_EFF_DT," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.AGMT_EXP_DT,'YYYYMMDD'),'YYYY-MM-DD') AS AGMT_EXP_DT" ).append("\n"); 
		query.append("  FROM JOO_BZC_AGMT A" ).append("\n"); 
		query.append(" WHERE A.OFC_CD      = @[ofc_cd]" ).append("\n"); 
		query.append("   AND A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("   AND A.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("   AND A.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("       A.AGMT_EFF_DT BETWEEN REPLACE(@[agmt_eff_dt],'-','') AND REPLACE(@[agmt_exp_dt],'-','') " ).append("\n"); 
		query.append("    OR A.AGMT_EXP_DT BETWEEN REPLACE(@[agmt_eff_dt],'-','') AND REPLACE(@[agmt_exp_dt],'-','') " ).append("\n"); 
		query.append("    OR REPLACE(@[agmt_eff_dt],'-','') BETWEEN A.AGMT_EFF_DT AND A.AGMT_EXP_DT" ).append("\n"); 
		query.append("    OR REPLACE(@[agmt_exp_dt],'-','') BETWEEN A.AGMT_EFF_DT AND A.AGMT_EXP_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${jo_ref_seq} != '')" ).append("\n"); 
		query.append("   AND NOT ( A.JO_REF_NO  = @[jo_ref_no] AND A.JO_REF_SEQ = TO_NUMBER(@[jo_ref_seq]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}