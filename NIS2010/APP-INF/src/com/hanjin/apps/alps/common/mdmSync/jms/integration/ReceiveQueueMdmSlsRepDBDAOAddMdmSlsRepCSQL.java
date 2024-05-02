/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmSlsRepDBDAOAddMdmSlsRepCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.28
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.06.28 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmSlsRepDBDAOAddMdmSlsRepCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JMS에서 받은 데이터 DB Logic 처리를 담당한다.(추가)
	  * </pre>
	  */
	public ReceiveQueueMdmSlsRepDBDAOAddMdmSlsRepCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_srep_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sex_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("empe_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_team_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmSlsRepDBDAOAddMdmSlsRepCSQL").append("\n"); 
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
		query.append("INSERT INTO mdm_sls_rep (" ).append("\n"); 
		query.append("    srep_cd     ," ).append("\n"); 
		query.append("    ofc_cd      ," ).append("\n"); 
		query.append("    srep_nm     ," ).append("\n"); 
		query.append("    ofc_team_cd ," ).append("\n"); 
		query.append("    sex_cd      ," ).append("\n"); 
		query.append("    srep_abbr_nm," ).append("\n"); 
		query.append("    ib_srep_flg ," ).append("\n"); 
		query.append("    ob_srep_flg ," ).append("\n"); 
		query.append("    empe_cd     ," ).append("\n"); 
		query.append("    srep_eml    ," ).append("\n"); 
		query.append("    intl_mphn_no," ).append("\n"); 
		query.append("    mphn_no     ," ).append("\n"); 
		query.append("    cre_usr_id  ," ).append("\n"); 
		query.append("    cre_dt      ," ).append("\n"); 
		query.append("    upd_usr_id  ," ).append("\n"); 
		query.append("    upd_dt      ," ).append("\n"); 
		query.append("    srep_sts_cd ," ).append("\n"); 
		query.append("    eai_evnt_dt ," ).append("\n"); 
		query.append("    eai_if_id" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[srep_cd]     ," ).append("\n"); 
		query.append("    @[ofc_cd]      ," ).append("\n"); 
		query.append("    @[srep_nm]     ," ).append("\n"); 
		query.append("    SUBSTR(@[ofc_team_cd], 1, 3)," ).append("\n"); 
		query.append("    @[sex_cd]      ," ).append("\n"); 
		query.append("    @[srep_abbr_nm]," ).append("\n"); 
		query.append("    @[ib_srep_flg] ," ).append("\n"); 
		query.append("    @[ob_srep_flg] ," ).append("\n"); 
		query.append("    @[empe_cd]     ," ).append("\n"); 
		query.append("    @[srep_eml]    ," ).append("\n"); 
		query.append("    @[intl_mphn_no]," ).append("\n"); 
		query.append("    @[mphn_no]     ," ).append("\n"); 
		query.append("    @[cre_usr_id]  ," ).append("\n"); 
		query.append("    TO_DATE(@[cre_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("    @[upd_usr_id]  ," ).append("\n"); 
		query.append("    TO_DATE(@[upd_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("    @[srep_sts_cd] ," ).append("\n"); 
		query.append("    TO_DATE(@[eai_evnt_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("    @[eai_if_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}