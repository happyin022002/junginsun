/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOaddVesselSparePartCdDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 차상영
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOaddVesselSparePartCdDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReeferSparePartMgtDBDAOaddVesselSparePartCdDataCSQL
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOaddVesselSparePartCdDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_crnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_ut_mdl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_lst_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOaddVesselSparePartCdDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_VSL_SPR_PRT_CD(" ).append("\n"); 
		query.append("         SPR_PRT_SEQ" ).append("\n"); 
		query.append("        ,SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("        ,SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("        ,SPR_UT_MDL_NM" ).append("\n"); 
		query.append("        ,SPR_PRT_TP_CD" ).append("\n"); 
		query.append("        ,SPR_PRT_LST_AMT" ).append("\n"); 
		query.append("        ,SPR_PRT_CRNT_AMT" ).append("\n"); 
		query.append("        ,SPR_PRT_RMK" ).append("\n"); 
		query.append("		,SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("        ,SPR_PRT_DELT_FLG" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("            (SELECT NVL(MAX(SPR_PRT_SEQ),0) + 1 FROM MNR_VSL_SPR_PRT_CD)" ).append("\n"); 
		query.append("           ,@[spr_prt_ver_seq]" ).append("\n"); 
		query.append("           ,@[spr_prt_vndr_seq]" ).append("\n"); 
		query.append("           ,@[spr_ut_mdl_nm]" ).append("\n"); 
		query.append("           ,@[spr_prt_tp_cd]" ).append("\n"); 
		query.append("           ,@[spr_prt_lst_amt]" ).append("\n"); 
		query.append("           ,@[spr_prt_crnt_amt]" ).append("\n"); 
		query.append("           ,@[spr_prt_rmk]" ).append("\n"); 
		query.append("		   ,@[spr_prt_dp_seq]" ).append("\n"); 
		query.append("           ,'N'" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}