/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LocationDBDAOAddCountryIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOAddCountryIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Country 정보 및 처리상태를 다른 시스템으로 전송하기 위해 저장한다.
	  * </pre>
	  */
	public LocationDBDAOAddCountryIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocedi_insf_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eu_cnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecom_insf_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_iso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocedi_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ecom_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOAddCountryIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_COUNTRY_IF(" ).append("\n"); 
		query.append("             CNT_IF_SEQ" ).append("\n"); 
		query.append("            ,CNT_CD" ).append("\n"); 
		query.append("            ,CNT_NM" ).append("\n"); 
		query.append("            ,SCONTI_CD" ).append("\n"); 
		query.append("            ,CURR_CD" ).append("\n"); 
		query.append("            ,CNT_ISO_CD" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("			,ECOM_INSF_ID        " ).append("\n"); 
		query.append("			,ECOM_INSF_DV_CD     " ).append("\n"); 
		query.append("			,OCEDI_INSF_ID       " ).append("\n"); 
		query.append("			,OCEDI_INSF_DV_CD    " ).append("\n"); 
		query.append("            ,EU_CNT_FLG" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  @[cnt_if_seq]" ).append("\n"); 
		query.append("            ,@[cnt_cd]" ).append("\n"); 
		query.append("            ,@[cnt_nm]" ).append("\n"); 
		query.append("            ,@[sconti_cd]" ).append("\n"); 
		query.append("            ,@[curr_cd]" ).append("\n"); 
		query.append("            ,@[cnt_iso_cd]" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("			,@[ecom_insf_id]" ).append("\n"); 
		query.append("			,@[ecom_insf_dv_cd]" ).append("\n"); 
		query.append("			,@[ocedi_insf_id]" ).append("\n"); 
		query.append("			,@[ocedi_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[eu_cnt_flg]" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}