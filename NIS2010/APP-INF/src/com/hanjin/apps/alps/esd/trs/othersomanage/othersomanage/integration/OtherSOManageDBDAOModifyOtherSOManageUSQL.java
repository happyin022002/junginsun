/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OtherSOManageDBDAOModifyOtherSOManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2012.09.20 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOModifyOtherSOManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Other SO 수정
	  * </pre>
	  */
	public OtherSOManageDBDAOModifyOtherSOManageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_de_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_otr_cost_mon_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_purp_rsn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOModifyOtherSOManageUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("SET ACT_CUST_CNT_CD    = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append(", ACT_CUST_SEQ       = @[act_cust_seq]" ).append("\n"); 
		query.append(", DOR_DE_ADDR        = @[dor_de_addr]" ).append("\n"); 
		query.append(", VSL_CD             = NVL(SUBSTR(TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(@[usr_ofc_cd], TO_CHAR(SYSDATE,'YYYYMMDD'), @[trsp_so_tp_cd], @[trsp_so_ofc_cty_cd], @[trsp_so_seq], @[eq_knd_cd], @[cgo_tp_cd], NULL, DECODE(@[ref_bkg_no],NULL,@[ref_bl_no],@[ref_bkg_no]), NULL, NULL, NULL, @[trsp_otr_cost_mon_dt]),1,4),'CNTC')" ).append("\n"); 
		query.append(", SKD_VOY_NO         = NVL(SUBSTR(TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(@[usr_ofc_cd], TO_CHAR(SYSDATE,'YYYYMMDD'), @[trsp_so_tp_cd], @[trsp_so_ofc_cty_cd], @[trsp_so_seq], @[eq_knd_cd], @[cgo_tp_cd], NULL, DECODE(@[ref_bkg_no],NULL,@[ref_bl_no],@[ref_bkg_no]), NULL, NULL, NULL, @[trsp_otr_cost_mon_dt]),5,4),@[trsp_otr_cost_mon_dt])" ).append("\n"); 
		query.append(", SKD_DIR_CD         = NVL(SUBSTR(TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(@[usr_ofc_cd], TO_CHAR(SYSDATE,'YYYYMMDD'), @[trsp_so_tp_cd], @[trsp_so_ofc_cty_cd], @[trsp_so_seq], @[eq_knd_cd], @[cgo_tp_cd], NULL, DECODE(@[ref_bkg_no],NULL,@[ref_bl_no],@[ref_bkg_no]), NULL, NULL, NULL, @[trsp_otr_cost_mon_dt]),9,1),'M')" ).append("\n"); 
		query.append(", REF_BKG_NO         = @[ref_bkg_no]" ).append("\n"); 
		query.append(", REF_BL_NO          = @[ref_bl_no]" ).append("\n"); 
		query.append(", TRSP_PURP_RSN      = @[trsp_purp_rsn]" ).append("\n"); 
		query.append(", UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT             = SYSDATE" ).append("\n"); 
		query.append(", LOCL_UPD_DT		  = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ        = @[trsp_so_seq]" ).append("\n"); 
		query.append("--/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 

	}
}