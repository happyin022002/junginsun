/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOGetJoRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.05 
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

public class JointOperationMasterDataMgtDBDAOGetJoRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * 2012.06.01 : 김상근[CHM-201218057-01]
	  * Discription : Key 생성규칙변경(OFC+수입/비용 구분+TRADE+REV LANE+Direction(추가)+년월+일련번호(3자리)
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOGetJoRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : JointOperationMasterDataMgtDBDAOGetJoRefNoRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(A XPKJOO_BZC_AGMT)*/" ).append("\n"); 
		query.append("       A.JO_REF_NO," ).append("\n"); 
		query.append("       A.JO_REF_SEQ + 1 AS JO_REF_SEQ" ).append("\n"); 
		query.append("  FROM JOO_BZC_AGMT A" ).append("\n"); 
		query.append(" WHERE REPLACE(A.JO_REF_NO,'-','') LIKE @[ofc_cd]||@[re_divr_cd]||@[trd_cd]||@[rlane_cd]||@[skd_dir_cd]||TO_CHAR(SYSDATE,'RRMM')||'%'" ).append("\n"); 
		query.append("   AND A.AGMT_EFF_DT = REPLACE(@[agmt_eff_dt],'-','')" ).append("\n"); 
		query.append("   AND A.AGMT_EXP_DT = REPLACE(@[agmt_exp_dt],'-','')" ).append("\n"); 
		query.append("   AND A.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("   AND ROWNUM      = 1" ).append("\n"); 

	}
}