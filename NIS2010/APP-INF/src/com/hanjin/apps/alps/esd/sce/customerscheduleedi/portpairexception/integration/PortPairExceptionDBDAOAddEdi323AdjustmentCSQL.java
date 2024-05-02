/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAOAddEdi323AdjustmentCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOAddEdi323AdjustmentCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi_323_adj 테이블에 데이터 insert 함
	  * </pre>
	  */
	public PortPairExceptionDBDAOAddEdi323AdjustmentCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_adj_dy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dct_adj_dy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dct_adj_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_adj_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rgst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_adj_etb_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dct_adj_etd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_adj_dy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cct_adj_etd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_adj_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_adj_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dct_adj_etb_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dct_adj_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOAddEdi323AdjustmentCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_323_ADJ " ).append("\n"); 
		query.append("(	" ).append("\n"); 
		query.append("	 ADJ_RGST_DT" ).append("\n"); 
		query.append("	,ADJ_SEQ" ).append("\n"); 
		query.append("	,CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("	,POL_CD" ).append("\n"); 
		query.append("	,POD_CD" ).append("\n"); 
		query.append("	,POL_CNT_CD" ).append("\n"); 
		query.append("	,POD_CNT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,ETD_ADJ_DY" ).append("\n"); 
		query.append("	,ETD_ADJ_HRMNT" ).append("\n"); 
		query.append("	,DCT_ADJ_TP_NM" ).append("\n"); 
		query.append("	,DCT_ADJ_DY" ).append("\n"); 
		query.append("	,DCT_ADJ_ETB_DYS" ).append("\n"); 
		query.append("	,DCT_ADJ_ETD_DYS" ).append("\n"); 
		query.append("	,DCT_ADJ_HRMNT" ).append("\n"); 
		query.append("	,CCT_ADJ_TP_NM" ).append("\n"); 
		query.append("	,CCT_ADJ_DY" ).append("\n"); 
		query.append("	,CCT_ADJ_ETB_DYS" ).append("\n"); 
		query.append("	,CCT_ADJ_ETD_DYS" ).append("\n"); 
		query.append("	,CCT_ADJ_HRMNT" ).append("\n"); 
		query.append("	,DELT_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 @[adj_rgst_dt]" ).append("\n"); 
		query.append("	,@[adj_seq]" ).append("\n"); 
		query.append("	, @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("	,@[pol_cd]" ).append("\n"); 
		query.append("	,@[pod_cd]" ).append("\n"); 
		query.append("	,@[pol_cnt_cd]" ).append("\n"); 
		query.append("	,@[pod_cnt_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,@[etd_adj_dy]" ).append("\n"); 
		query.append("	,@[etd_adj_hrmnt]" ).append("\n"); 
		query.append("	,@[dct_adj_tp_nm]" ).append("\n"); 
		query.append("	,@[dct_adj_dy]" ).append("\n"); 
		query.append("	,@[dct_adj_etb_dys]" ).append("\n"); 
		query.append("	,@[dct_adj_etd_dys]" ).append("\n"); 
		query.append("	,@[dct_adj_hrmnt]" ).append("\n"); 
		query.append("	,@[cct_adj_tp_nm]" ).append("\n"); 
		query.append("	,@[cct_adj_dy]" ).append("\n"); 
		query.append("	,@[cct_adj_etb_dys]" ).append("\n"); 
		query.append("	,@[cct_adj_etd_dys]" ).append("\n"); 
		query.append("	,@[cct_adj_hrmnt]" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}