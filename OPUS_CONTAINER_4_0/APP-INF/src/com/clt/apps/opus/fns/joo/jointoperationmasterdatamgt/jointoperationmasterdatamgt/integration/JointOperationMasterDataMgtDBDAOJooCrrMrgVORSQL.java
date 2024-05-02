/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooCrrMrgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.04.09 박희동
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

public class JointOperationMasterDataMgtDBDAOJooCrrMrgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선사Merge 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooCrrMrgVORSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooCrrMrgVORSQL").append("\n"); 
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
		query.append("	rlane_cd" ).append("\n"); 
		query.append(",   acctg_crr_cd" ).append("\n"); 
		query.append(",	jo_n1st_crr_cd" ).append("\n"); 
		query.append(",	jo_n2nd_crr_cd" ).append("\n"); 
		query.append(",	trd_cd" ).append("\n"); 
		query.append(",	vsl_cd" ).append("\n"); 
		query.append(",	skd_voy_no" ).append("\n"); 
		query.append(",	skd_dir_cd" ).append("\n"); 
		query.append(",	rev_dir_cd" ).append("\n"); 
		query.append(",   to_char(eff_eta_dt,'yyyymmdd') as eff_eta_dt" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append(",	mrg_rmk" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append("FROM joo_crr_mrg" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("AND	trd_cd = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("AND rlane_cd = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("AND acctg_crr_cd = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != 'A')" ).append("\n"); 
		query.append("AND DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY rlane_cd, acctg_crr_cd, jo_n1st_crr_cd, jo_n2nd_crr_cd" ).append("\n"); 

	}
}