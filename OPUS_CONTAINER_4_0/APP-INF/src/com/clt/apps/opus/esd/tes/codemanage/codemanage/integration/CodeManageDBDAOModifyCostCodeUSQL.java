/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeManageDBDAOModifyCostCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.17 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOModifyCostCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCostCode
	  * </pre>
	  */
	public CodeManageDBDAOModifyCostCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd_clss_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_opt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lgs_cost_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thrp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ").append("\n"); 
		query.append("FileName : CodeManageDBDAOModifyCostCodeUSQL").append("\n"); 
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
		query.append("UPDATE TES_LGS_COST SET" ).append("\n"); 
		query.append("LGS_COST_FULL_NM      =@[lgs_cost_full_nm]" ).append("\n"); 
		query.append(", LGS_COST_SUBJ_CD    =@[lgs_cost_subj_cd]" ).append("\n"); 
		query.append(", LGS_COST_DTL_CD     =@[lgs_cost_dtl_cd]" ).append("\n"); 
		query.append(", LGS_COST_CD_CLSS_LVL=@[lgs_cost_cd_clss_lvl]" ).append("\n"); 
		query.append(", LGS_COST_OPT_NO     =@[lgs_cost_opt_no]" ).append("\n"); 
		query.append(", LGS_COST_ABBR_NM    =@[lgs_cost_abbr_nm]" ).append("\n"); 
		query.append(", ACCT_CD             =@[acct_cd]" ).append("\n"); 
		query.append(", LGS_COST_RMK        =@[lgs_cost_rmk]" ).append("\n"); 
		query.append(", THRP_FLG            =@[thrp_flg]" ).append("\n"); 
		query.append(", CRR_ACCT_CD         =@[crr_acct_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID          =@[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT              =SYSDATE" ).append("\n"); 
		query.append("WHERE LGS_COST_CD 	   =@[lgs_cost_cd]" ).append("\n"); 

	}
}