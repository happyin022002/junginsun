/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label Attachment 저장
	  * </pre>
	  */
	public RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rstr_usg_tp_lbl_nm9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_tp_lbl_nm6",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER SET" ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM1  = DECODE( @[ru_label_type], 'FLOW', @[rstr_usg_tp_lbl_nm1], RSTR_USG_TP_LBL_NM1 ), " ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM2  = DECODE( @[ru_label_type], 'OWFU', @[rstr_usg_tp_lbl_nm2], RSTR_USG_TP_LBL_NM2 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM3  = DECODE( @[ru_label_type], 'OFHR', @[rstr_usg_tp_lbl_nm3], RSTR_USG_TP_LBL_NM3 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM4  = DECODE( @[ru_label_type], 'DOME', @[rstr_usg_tp_lbl_nm4], RSTR_USG_TP_LBL_NM4 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM5  = DECODE( @[ru_label_type], 'SALE', @[rstr_usg_tp_lbl_nm5], RSTR_USG_TP_LBL_NM5 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM6  = DECODE( @[ru_label_type], 'GOHH', @[rstr_usg_tp_lbl_nm6], RSTR_USG_TP_LBL_NM6 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM7  = DECODE( @[ru_label_type], 'REFR', @[rstr_usg_tp_lbl_nm7], RSTR_USG_TP_LBL_NM7 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM8  = DECODE( @[ru_label_type], 'ASST', @[rstr_usg_tp_lbl_nm8], RSTR_USG_TP_LBL_NM8 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM9  = DECODE( @[ru_label_type], 'OTR1', @[rstr_usg_tp_lbl_nm9], RSTR_USG_TP_LBL_NM9 )," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM10 = DECODE( @[ru_label_type], 'OTR2', @[rstr_usg_tp_lbl_nm10], RSTR_USG_TP_LBL_NM10)," ).append("\n"); 
		query.append("	RSTR_USG_TP_LBL_NM11 = DECODE( @[ru_label_type], 'OTR3', @[rstr_usg_tp_lbl_nm11], RSTR_USG_TP_LBL_NM11)," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}