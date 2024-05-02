/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementDBDAOAddRuLabelAttachHistoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.10.13 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOAddRuLabelAttachHistoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label History 저장
	  * </pre>
	  */
	public RuLabelManagementDBDAOAddRuLabelAttachHistoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_upd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ru_label_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ru_label_value",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOAddRuLabelAttachHistoryDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_RSTR_USG_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    CNTR_NO" ).append("\n"); 
		query.append(",   RSTR_USG_HIS_SEQ        --시퀀스" ).append("\n"); 
		query.append(",   RSTR_USG_UPD_TP_CD      -- CUD" ).append("\n"); 
		query.append(",   RSTR_USG_TP_CD          -- TYPE CODE" ).append("\n"); 
		query.append(",   RSTR_USG_LBL_NM         -- VALUE" ).append("\n"); 
		query.append(",	CNTR_RMK " ).append("\n"); 
		query.append(",   CNMV_YR                 -- CNTR MST MOVE키 값" ).append("\n"); 
		query.append(",   CNMV_ID_NO              -- CNTR MST MOVE키 값" ).append("\n"); 
		query.append(",   CNMV_SEQ                -- CNTR MST MOVE키 값" ).append("\n"); 
		query.append(",   CNMV_SPLIT_NO           -- CNTR MST MOVE키 값" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[cntr_no]" ).append("\n"); 
		query.append(", rstr_usg_his_seq.nextval" ).append("\n"); 
		query.append(", DECODE(@[rstr_usg_upd_tp_cd], 'D', 'D'" ).append("\n"); 
		query.append("                              , NVL((SELECT DECODE(SUBSTR(MAX(TO_CHAR(SUB.RSTR_USG_HIS_SEQ, '00000000')||TRIM(SUB.RSTR_USG_UPD_TP_CD)), 10, 1), 'D', 'C', NULL, 'C', 'U')" ).append("\n"); 
		query.append("                                     FROM MST_CNTR_RSTR_USG_HIS SUB" ).append("\n"); 
		query.append("                                     WHERE SUB.CNTR_NO        = @[cntr_no]" ).append("\n"); 
		query.append("                                     AND   SUB.RSTR_USG_TP_CD = @[ru_label_type]" ).append("\n"); 
		query.append("                                    ), 'C')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(", @[ru_label_type]" ).append("\n"); 
		query.append(", @[ru_label_value]" ).append("\n"); 
		query.append(", @[remark]" ).append("\n"); 
		query.append(", (SELECT CNMV_YR       FROM MST_CONTAINER MC WHERE MC.CNTR_NO = @[cntr_no] AND ROWNUM=1)" ).append("\n"); 
		query.append(", (SELECT CNMV_ID_NO    FROM MST_CONTAINER MC WHERE MC.CNTR_NO = @[cntr_no] AND ROWNUM=1)" ).append("\n"); 
		query.append(", (SELECT CNMV_SEQ      FROM MST_CONTAINER MC WHERE MC.CNTR_NO = @[cntr_no] AND ROWNUM=1)" ).append("\n"); 
		query.append(", (SELECT CNMV_SPLIT_NO FROM MST_CONTAINER MC WHERE MC.CNTR_NO = @[cntr_no] AND ROWNUM=1)" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}