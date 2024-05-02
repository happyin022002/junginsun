/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KeyManInfoDBDAOaddKeyManInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyManInfoDBDAOaddKeyManInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create customer keyman
	  * </pre>
	  */
	public KeyManInfoDBDAOaddKeyManInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("occupation",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("home_ph_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fst_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cell_ph_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("work_ph_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("email_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eye_color",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("birth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_ph_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prmry_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hair_color",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("con_manager_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_title",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spouse_name",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("last_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pager_pin",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("per_title",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wed_anvrsry_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.integration").append("\n"); 
		query.append("FileName : KeyManInfoDBDAOaddKeyManInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUST_KEYMAN(" ).append("\n"); 
		query.append("    KEYMAN_SEQ" ).append("\n"); 
		query.append("    ,FST_NAME" ).append("\n"); 
		query.append("    ,LAST_NAME" ).append("\n"); 
		query.append("    ,CUST_CNT_CD" ).append("\n"); 
		query.append("    ,CUST_SEQ" ).append("\n"); 
		query.append("    ,PRMRY_CHK_FLG" ).append("\n"); 
		query.append("    ,PER_TITLE" ).append("\n"); 
		query.append("    ,JOB_TITLE" ).append("\n"); 
		query.append("    ,PAGER_PIN" ).append("\n"); 
		query.append("    ,OCCUPATION" ).append("\n"); 
		query.append("    ,EYE_COLOR" ).append("\n"); 
		query.append("    ,EMAIL_ADDR" ).append("\n"); 
		query.append("    ,SREP_CD" ).append("\n"); 
		query.append("    ,CON_MANAGER_NAME" ).append("\n"); 
		query.append("    ,WORK_PH_NUM" ).append("\n"); 
		query.append("    ,FAX_PH_NUM" ).append("\n"); 
		query.append("    ,CELL_PH_NUM" ).append("\n"); 
		query.append("    ,HOME_PH_NUM" ).append("\n"); 
		query.append("    ,HAIR_COLOR" ).append("\n"); 
		query.append("    ,SPOUSE_NAME" ).append("\n"); 
		query.append("    ,BIRTH_DT" ).append("\n"); 
		query.append("    ,WED_ANVRSRY_DT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("    MDM_CUST_KEYMAN_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    ,NVL(@[fst_name],'')" ).append("\n"); 
		query.append("    ,NVL(@[last_name],'')" ).append("\n"); 
		query.append("    ,NVL(@[cust_cnt_cd],'')" ).append("\n"); 
		query.append("    ,NVL(@[cust_seq],'')" ).append("\n"); 
		query.append("    ,decode(@[prmry_chk_flg],'1','Y',null,'N','0','N',@[prmry_chk_flg])" ).append("\n"); 
		query.append("    ,NVL(@[per_title],'')" ).append("\n"); 
		query.append("    ,NVL(@[job_title],'')" ).append("\n"); 
		query.append("    ,NVL(@[pager_pin],'')" ).append("\n"); 
		query.append("    ,NVL(@[occupation],'')" ).append("\n"); 
		query.append("    ,NVL(@[eye_color],'')" ).append("\n"); 
		query.append("    ,NVL(@[email_addr],'')" ).append("\n"); 
		query.append("    ,NVL(@[srep_cd],'')" ).append("\n"); 
		query.append("    ,NVL(@[con_manager_name],'')" ).append("\n"); 
		query.append("    ,NVL(@[work_ph_num],'')" ).append("\n"); 
		query.append("    ,NVL(@[fax_ph_num],'')" ).append("\n"); 
		query.append("    ,NVL(@[cell_ph_num],'')" ).append("\n"); 
		query.append("    ,NVL(@[home_ph_num],'')" ).append("\n"); 
		query.append("    ,NVL(@[hair_color],'')" ).append("\n"); 
		query.append("    ,NVL(@[spouse_name],'')" ).append("\n"); 
		query.append("    ,NVL(TO_DATE(@[birth_dt], 'YYYY-MM-DD'),'')" ).append("\n"); 
		query.append("    ,NVL(TO_DATE(@[wed_anvrsry_dt], 'YYYY-MM-DD'),'')" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}