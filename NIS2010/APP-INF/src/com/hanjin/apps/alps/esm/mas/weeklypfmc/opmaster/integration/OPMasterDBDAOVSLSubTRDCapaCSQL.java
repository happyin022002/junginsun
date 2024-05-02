/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOVSLSubTRDCapaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOVSLSubTRDCapaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOVSLSubTRDCapaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOVSLSubTRDCapaCSQL").append("\n"); 
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
		query.append("#if (${update_flg} == 'Y')" ).append("\n"); 
		query.append("update MAS_VSL_SUB_TRD_CAPA" ).append("\n"); 
		query.append("set SUB_TRD_CAPA = @[sub_trd_capa]" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("where VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("and VSL_SEQ = @[vsl_seq]" ).append("\n"); 
		query.append("and SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO MAS_VSL_SUB_TRD_CAPA (" ).append("\n"); 
		query.append("	  VSL_CD" ).append("\n"); 
		query.append("	, VSL_SEQ" ).append("\n"); 
		query.append("	, SUB_TRD_CD" ).append("\n"); 
		query.append("	, SUB_TRD_CAPA" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, LST_FLG" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("	  @[vsl_cd]" ).append("\n"); 
		query.append(",CASE WHEN @[auto_flg] = 'Y' THEN (SELECT NVL(MAX(VSL_SEQ),0) seq FROM MAS_VSL_RGST WHERE VSL_CD = @[vsl_cd]) -- 이 쿼리전에 MAS_VSL_RGST에 먼저 INSERT되므로 +1 안해주는게 맞음." ).append("\n"); 
		query.append("      ELSE TO_NUMBER(@[vsl_seq])" ).append("\n"); 
		query.append("      END" ).append("\n"); 
		query.append("    , @[sub_trd_cd]" ).append("\n"); 
		query.append("    , @[sub_trd_capa]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}