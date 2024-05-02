/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOModifyAwkCgoTrfAddOnToUpdateTpSzUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOModifyAwkCgoTrfAddOnToUpdateTpSzUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USD AMT UPDATE
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOModifyAwkCgoTrfAddOnToUpdateTpSzUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_awk_adon_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOModifyAwkCgoTrfAddOnToUpdateTpSzUSQL").append("\n"); 
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
		query.append("INSERT INTO TES_AWK_CGO_ADON_TP_SZ (" ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("FM_NOD_YD_NO," ).append("\n"); 
		query.append("TO_LOC_CD," ).append("\n"); 
		query.append("TO_NOD_YD_NO," ).append("\n"); 
		query.append("COND_NO," ).append("\n"); 
		query.append("TML_AWK_ADON_VER_NO," ).append("\n"); 
		query.append("CNTR_SZ_CD," ).append("\n"); 
		query.append("LOCL_CURR_CD," ).append("\n"); 
		query.append("LOCL_CURR_AMT," ).append("\n"); 
		query.append("USD_AMT," ).append("\n"); 
		query.append("USD_XCH_DT," ).append("\n"); 
		query.append("SPCL_CGO_REF_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[fm_loc_cd]," ).append("\n"); 
		query.append("NVL(@[fm_nod_yd_no], ' ')," ).append("\n"); 
		query.append("@[to_loc_cd]," ).append("\n"); 
		query.append("NVL(@[to_nod_yd_no], ' ')," ).append("\n"); 
		query.append("@[cond_no]," ).append("\n"); 
		query.append("@[tml_awk_adon_ver_no]," ).append("\n"); 
		query.append("@[cntr_sz_cd]," ).append("\n"); 
		query.append("@[locl_curr_cd]," ).append("\n"); 
		query.append("@[locl_curr_amt]," ).append("\n"); 
		query.append("@[usd_amt]," ).append("\n"); 
		query.append("@[usd_xch_dt]," ).append("\n"); 
		query.append("TES_SPCL_CGO_REF_SEQ.nextval," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("TO_DATE(@[cre_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}