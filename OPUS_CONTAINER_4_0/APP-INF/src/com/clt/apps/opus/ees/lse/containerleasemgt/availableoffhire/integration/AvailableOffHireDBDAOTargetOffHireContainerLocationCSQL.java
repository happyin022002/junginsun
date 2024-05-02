/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvailableOffHireDBDAOTargetOffHireContainerLocationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOTargetOffHireContainerLocationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.05.17 / Jiyeon Jeon - Target Off-hire location 지정 후 저장하는 쿼리
	  * </pre>
	  */
	public AvailableOffHireDBDAOTargetOffHireContainerLocationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("offh_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOTargetOffHireContainerLocationCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_AGMT_OFFH_PLC (" ).append("\n"); 
		query.append("	AGMT_CTY_CD" ).append("\n"); 
		query.append(",	AGMT_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	EQ_LOC_TP_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	GEN_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT " ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	EDW_UPD_DT" ).append("\n"); 
		query.append(",	USE_FLG" ).append("\n"); 
		query.append(",   OFFH_FM_DT" ).append("\n"); 
		query.append(",   OFFH_TO_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("	@[agmt_cty_cd]" ).append("\n"); 
		query.append(",	@[agmt_seq]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[eq_loc_tp_cd]" ).append("\n"); 
		query.append(",	@[loc_cd]" ).append("\n"); 
		query.append(",	@[gen_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("#if (${use_flg} != '' )" ).append("\n"); 
		query.append(", 	@[use_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",   '0'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if(${offh_fm_dt} != '')" ).append("\n"); 
		query.append(",	TO_DATE(@[offh_fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${offh_to_dt} != '')" ).append("\n"); 
		query.append(",   TO_DATE(@[offh_to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}