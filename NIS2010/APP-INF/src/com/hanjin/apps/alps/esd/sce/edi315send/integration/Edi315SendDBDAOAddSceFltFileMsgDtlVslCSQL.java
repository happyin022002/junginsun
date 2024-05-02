/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceFltFileMsgDtlVslCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.07.29 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceFltFileMsgDtlVslCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_FLT_FILE_MSG_DTL_VSL 테이블 ROW ADD
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceFltFileMsgDtlVslCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_estm_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_estm_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_estm_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_estm_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceFltFileMsgDtlVslCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_FLT_FILE_MSG_DTL_VSL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("EDI_SND_DT" ).append("\n"); 
		query.append(", EDI_SND_HR" ).append("\n"); 
		query.append(", EDI_SND_SEQ" ).append("\n"); 
		query.append(", EDI_SND_DTL_SEQ" ).append("\n"); 
		query.append(", FLT_FILE_REF_NO" ).append("\n"); 
		query.append(", VVD_SEQ" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", ORG_NOD_CD" ).append("\n"); 
		query.append(", DEST_NOD_CD" ).append("\n"); 
		query.append(", ORG_ESTM_ARR_DT" ).append("\n"); 
		query.append(", ORG_ESTM_DEP_DT" ).append("\n"); 
		query.append(", DEST_ESTM_ARR_DT" ).append("\n"); 
		query.append(", DEST_ESTM_DEP_DT" ).append("\n"); 
		query.append(", ORG_ACT_ARR_DT" ).append("\n"); 
		query.append(", ORG_ACT_DEP_DT" ).append("\n"); 
		query.append(", DEST_ACT_ARR_DT" ).append("\n"); 
		query.append(", DEST_ACT_DEP_DT" ).append("\n"); 
		query.append(", VVD_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[edi_snd_dt]" ).append("\n"); 
		query.append(", @[edi_snd_hr]" ).append("\n"); 
		query.append(", @[edi_snd_seq]" ).append("\n"); 
		query.append(", SCE_FLT_FILE_MSG_DTL_VSL_SEQ.NEXTVAL" ).append("\n"); 
		query.append(", @[flt_file_ref_no]" ).append("\n"); 
		query.append(", @[vvd_seq]" ).append("\n"); 
		query.append(", @[vsl_cd]" ).append("\n"); 
		query.append(", @[skd_voy_no]" ).append("\n"); 
		query.append(", @[skd_dir_cd]" ).append("\n"); 
		query.append(", @[org_nod_cd]" ).append("\n"); 
		query.append(", @[dest_nod_cd]" ).append("\n"); 
		query.append(", to_date(TRIM(@[org_estm_arr_dt]), 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_date(TRIM(@[org_estm_dep_dt]), 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_date(TRIM(@[dest_estm_arr_dt]), 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_date(TRIM(@[dest_estm_dep_dt]), 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_date(TRIM(@[org_act_arr_dt]) , 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_date(TRIM(@[org_act_dep_dt]) , 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_Date(TRIM(@[dest_act_arr_dt]), 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", to_Date(TRIM(@[dest_act_dep_dt]) , 'yyyymmddhh24mi')" ).append("\n"); 
		query.append(", @[vvd_rmk]" ).append("\n"); 
		query.append(", NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}