/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOModifyBsaBudSltChtrBzcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.25 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOModifyBsaBudSltChtrBzcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOModifyBsaBudSltChtrBzcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scht_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_bsa_bfr_sub_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_bsa_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration ").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOModifyBsaBudSltChtrBzcUSQL").append("\n"); 
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
		query.append("UPDATE BSA_BUD_SLT_CHTR_BZC SET " ).append("\n"); 
		query.append("	    VVD_CD               = @[vvd_cd]" ).append("\n"); 
		query.append("       ,BSA_FM_DT            = @[bsa_fm_dt]" ).append("\n"); 
		query.append("       ,BSA_TO_DT            = @[bsa_to_dt]" ).append("\n"); 
		query.append("       ,VSL_CD               = @[vsl_cd]" ).append("\n"); 
		query.append("       ,HJS_FNL_BSA_CAPA     = @[hjs_fnl_bsa_capa]" ).append("\n"); 
		query.append("       ,HJS_BSA_BFR_SUB_CAPA = @[hjs_bsa_bfr_sub_capa]" ).append("\n"); 
		query.append("       ,VSL_BSA_CHK_FLG      = @[vsl_bsa_chk_flg]" ).append("\n"); 
		query.append("       ,SCHT_DESC            = @[scht_desc]" ).append("\n"); 
		query.append("       ,UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT               = SYSDATE" ).append("\n"); 
		query.append(" WHERE  BSA_SEQ              = @[bsa_seq]" ).append("\n"); 
		query.append(" AND    TRD_CD               = @[trd_cd]" ).append("\n"); 
		query.append(" AND    RLANE_CD             = @[rlane_cd]" ).append("\n"); 
		query.append(" AND    DIR_CD               = @[dir_cd]" ).append("\n"); 
		query.append(" AND    VSL_SEQ              = @[vsl_seq]" ).append("\n"); 

	}
}