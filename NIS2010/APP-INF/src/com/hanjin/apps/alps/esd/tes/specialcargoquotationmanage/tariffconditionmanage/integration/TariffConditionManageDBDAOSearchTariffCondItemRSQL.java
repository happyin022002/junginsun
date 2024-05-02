/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TariffConditionManageDBDAOSearchTariffCondItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffConditionManageDBDAOSearchTariffCondItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Condition 항목 조회
	  * </pre>
	  */
	public TariffConditionManageDBDAOSearchTariffCondItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_dtl_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration").append("\n"); 
		query.append("FileName : TariffConditionManageDBDAOSearchTariffCondItemRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("--C.TML_AWK_CGO_COND_TP_CD, D.COND_NO," ).append("\n"); 
		query.append("D.COND_DTL_USE_TP_CD," ).append("\n"); 
		query.append("D.COND_SEQ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN D.TML_COND_DTL_TP_CD IN ('O','P')" ).append("\n"); 
		query.append("THEN O.OBJ_LIST_ABBR_NM" ).append("\n"); 
		query.append("WHEN D.TML_COND_DTL_TP_CD IN ('C')" ).append("\n"); 
		query.append("THEN D.COND_OPR_VAL_CTNT" ).append("\n"); 
		query.append("END OBJ_DP_NM" ).append("\n"); 
		query.append(", D.TML_COND_DTL_TP_CD, D.TML_COND_OPR_CD, D.OBJ_LIST_NO, D.COND_OPR_VAL_CTNT" ).append("\n"); 
		query.append(", O.TML_OBJ_LIST_TP_CD, O.DELT_FLG OBJ_DELT_FLG" ).append("\n"); 
		query.append("FROM TES_TRF_COND C, TES_TRF_COND_DTL D, TES_OBJ_LIST O" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND C.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#if (${cond_dtl_use_tp_cd} != '')" ).append("\n"); 
		query.append("AND D.COND_DTL_USE_TP_CD = @[cond_dtl_use_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cond_tp_cd} != '')" ).append("\n"); 
		query.append("AND C.TML_AWK_CGO_COND_TP_CD = @[cond_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND D.OBJ_LIST_NO = O.OBJ_LIST_NO(+)" ).append("\n"); 

	}
}