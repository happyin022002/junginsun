/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAODualTypeCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAODualTypeCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지역 Calculation Type과 무관하게 Combined Tariff 적용이 필요한 화주 입력용 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAODualTypeCustomerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_expt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ctrt_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAODualTypeCustomerCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_DUL_TP_EXPT (" ).append("\n"); 
		query.append("CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	CUST_EXPT_SEQ" ).append("\n"); 
		query.append(",	DUL_EXPT_EFF_DT" ).append("\n"); 
		query.append(",	DUL_EXPT_EXP_DT" ).append("\n"); 
		query.append(",	DUL_EXPT_RMK" ).append("\n"); 
		query.append(",	DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",	DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",	DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	DMDT_CTRT_EXPT_TP_CD" ).append("\n"); 
		query.append(",	CVRG_CNT_CD" ).append("\n"); 
		query.append(",	CVRG_RGN_STE_CD" ).append("\n"); 
		query.append(",	CVRG_LOC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	PROP_NO" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append(",	SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append(",	@[cust_expt_seq]" ).append("\n"); 
		query.append(",	TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	TO_DATE(@[dul_expt_exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[dul_expt_rmk]" ).append("\n"); 
		query.append(",	DECODE(@[dmdt_ctrt_expt_tp_cd], 'B', SUBSTR(@[dmdt_cntr_cgo_tp_cd], 0, 1), '')" ).append("\n"); 
		query.append(",	DECODE(@[dmdt_ctrt_expt_tp_cd], 'B', SUBSTR(@[dmdt_cntr_cgo_tp_cd], 3), '')" ).append("\n"); 
		query.append(",	DECODE(@[dmdt_ctrt_expt_tp_cd], 'S', @[dmdt_cntr_cgo_tp_cd], '')" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[dmdt_ctrt_expt_tp_cd]" ).append("\n"); 
		query.append(",	NVL(@[cvrg_cnt_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[cvrg_rgn_ste_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[cvrg_loc_cd], ' ')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	TRIM(@[prop_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}