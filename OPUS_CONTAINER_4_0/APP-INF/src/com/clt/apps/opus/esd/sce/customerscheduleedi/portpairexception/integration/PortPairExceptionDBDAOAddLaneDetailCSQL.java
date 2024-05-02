/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOAddLaneDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.29 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOAddLaneDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOAddLaneDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cct_adj_dy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etd_adj_dy",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOAddLaneDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CUST_EDI_ADJ (" ).append("\n"); 
		query.append("CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",ADJ_SEQ" ).append("\n"); 
		query.append(",ETD_ADJ_DY" ).append("\n"); 
		query.append(",ETD_ADJ_HRMNT" ).append("\n"); 
		query.append(",DCT_ADJ_TP_NM" ).append("\n"); 
		query.append(",DCT_ADJ_DY" ).append("\n"); 
		query.append(",DCT_ADJ_ETB_DYS" ).append("\n"); 
		query.append(",DCT_ADJ_ETD_DYS" ).append("\n"); 
		query.append(",DCT_ADJ_HRMNT" ).append("\n"); 
		query.append(",CCT_ADJ_TP_NM" ).append("\n"); 
		query.append(",CCT_ADJ_DY" ).append("\n"); 
		query.append(",CCT_ADJ_ETB_DYS" ).append("\n"); 
		query.append(",CCT_ADJ_ETD_DYS" ).append("\n"); 
		query.append(",CCT_ADJ_HRMNT" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[cust_trd_prnr_id]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[slan_cd]" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT NVL(MAX(ADJ_SEQ),0) + 1" ).append("\n"); 
		query.append("FROM SCE_CUST_EDI_ADJ" ).append("\n"); 
		query.append("WHERE CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND POD_CD	= @[pod_cd]" ).append("\n"); 
		query.append("AND SLAN_CD= @[slan_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",@[etd_adj_dy]" ).append("\n"); 
		query.append(",@[etd_adj_hrmnt]" ).append("\n"); 
		query.append(",@[dct_adj_tp_nm]" ).append("\n"); 
		query.append(",@[dct_adj_dy]" ).append("\n"); 
		query.append(",@[dct_adj_etb_dys]" ).append("\n"); 
		query.append(",@[dct_adj_etd_dys]" ).append("\n"); 
		query.append(",@[dct_adj_hrmnt]" ).append("\n"); 
		query.append(",@[cct_adj_tp_nm]" ).append("\n"); 
		query.append(",@[cct_adj_dy]" ).append("\n"); 
		query.append(",@[cct_adj_etb_dys]" ).append("\n"); 
		query.append(",@[cct_adj_etd_dys]" ).append("\n"); 
		query.append(",@[cct_adj_hrmnt]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}