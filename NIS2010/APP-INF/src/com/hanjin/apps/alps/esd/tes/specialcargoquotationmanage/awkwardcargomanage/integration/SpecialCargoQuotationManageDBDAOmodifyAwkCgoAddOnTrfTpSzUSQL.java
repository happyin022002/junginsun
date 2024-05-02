/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOmodifyAwkCgoAddOnTrfTpSzUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.15
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.15 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOmodifyAwkCgoAddOnTrfTpSzUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyAwkCgoAddOnTrfTpSz
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOmodifyAwkCgoAddOnTrfTpSzUSQL(){
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
		params.put("to_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOmodifyAwkCgoAddOnTrfTpSzUSQL").append("\n"); 
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
		query.append("MERGE INTO TES_AWK_CGO_ADON_TP_SZ V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (    V.FM_LOC_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("AND V.FM_NOD_YD_NO = CASE WHEN @[fm_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[fm_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND V.TO_LOC_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("AND V.TO_NOD_YD_NO = CASE WHEN @[to_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[to_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND V.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND V.TML_AWK_ADON_VER_NO = (SELECT NVL(MAX(TML_AWK_ADON_VER_NO),0)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR" ).append("\n"); 
		query.append("WHERE FM_LOC_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("AND FM_NOD_YD_NO = CASE WHEN @[fm_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[fm_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND TO_LOC_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("AND TO_NOD_YD_NO = CASE WHEN @[to_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[to_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND V.CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("LOCL_CURR_CD = @[locl_curr_cd]," ).append("\n"); 
		query.append("LOCL_CURR_AMT = @[locl_curr_amt]," ).append("\n"); 
		query.append("USD_AMT = @[usd_amt]," ).append("\n"); 
		query.append("USD_XCH_DT = @[usd_xch_dt]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
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
		query.append("(SELECT NVL(MAX(TML_AWK_ADON_VER_NO),0)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR" ).append("\n"); 
		query.append("WHERE FM_LOC_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("AND FM_NOD_YD_NO = CASE WHEN @[fm_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[fm_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND TO_LOC_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("AND TO_NOD_YD_NO = CASE WHEN @[to_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[to_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("@[cntr_sz_cd]," ).append("\n"); 
		query.append("@[locl_curr_cd]," ).append("\n"); 
		query.append("@[locl_curr_amt]," ).append("\n"); 
		query.append("@[usd_amt]," ).append("\n"); 
		query.append("@[usd_xch_dt]," ).append("\n"); 
		query.append("TES_SPCL_CGO_REF_SEQ.nextval," ).append("\n"); 
		query.append("(SELECT OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("Y.OFC_CD," ).append("\n"); 
		query.append("COUNT(Y.OFC_CD) OVER (PARTITION BY SUBSTR(Y.YD_CD,1,5), Y.OFC_CD) CNT" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Y.YD_CD LIKE @[fm_loc_cd]||@[fm_nod_yd_no]||'%' --5자리 이상" ).append("\n"); 
		query.append("ORDER BY CNT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1)," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}