/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtDBDAOmodifyStatusHistoryDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.25 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusHistoryMgtDBDAOmodifyStatusHistoryDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status History 수정
	  * </pre>
	  */
	public StatusHistoryMgtDBDAOmodifyStatusHistoryDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_his_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration").append("\n"); 
		query.append("FileName : StatusHistoryMgtDBDAOmodifyStatusHistoryDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_STS_HIS A" ).append("\n"); 
		query.append("SET A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(",A.MNR_HIS_STS_CD = @[mnr_his_sts_cd]" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD = @[mnr_inp_tp_cd]" ).append("\n"); 
		query.append(",A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append(",A.RQST_DT = TO_DATE(@[rqst_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",A.RQST_USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append(",A.APRO_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 
		query.append(",A.APRO_DT = TO_DATE(@[apro_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",A.APRO_USR_ID = @[apro_usr_id]" ).append("\n"); 
		query.append(",A.MNR_STS_RMK = @[mnr_sts_rmk]" ).append("\n"); 
		query.append(",A.MNR_STS_DT = TO_DATE(@[mnr_sts_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.MNR_STS_REF_NO = @[mnr_sts_ref_no]" ).append("\n"); 
		query.append("AND A.MNR_STS_DTL_SEQ = @[mnr_sts_dtl_seq]" ).append("\n"); 

	}
}