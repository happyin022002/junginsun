/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooBzcAgmtPeriodUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.04 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooBzcAgmtPeriodUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기간이 변경되면 같은 REF NO의 기간은 모두 수정해야 한다.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooBzcAgmtPeriodUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooBzcAgmtPeriodUSQL").append("\n"); 
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
		query.append("UPDATE JOO_BZC_AGMT SET" ).append("\n"); 
		query.append("       AGMT_EFF_DT          = REPLACE(@[agmt_eff_dt],'-','')" ).append("\n"); 
		query.append("      ,AGMT_EXP_DT          = REPLACE(@[agmt_exp_dt],'-','')         " ).append("\n"); 
		query.append("      ,UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("      ,UPD_USR_ID           = @[upd_usr_id]      " ).append("\n"); 
		query.append("WHERE JO_REF_NO  = @[jo_ref_no]           " ).append("\n"); 
		query.append("AND  (AGMT_EFF_DT <> REPLACE(@[agmt_eff_dt],'-','') OR AGMT_EXP_DT <> REPLACE(@[agmt_exp_dt],'-',''))" ).append("\n"); 

	}
}