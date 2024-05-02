/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TariffConditionManageDBDAOSearchTariffObjectListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.04 
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

public class TariffConditionManageDBDAOSearchTariffObjectListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Object 정보 조회
	  * </pre>
	  */
	public TariffConditionManageDBDAOSearchTariffObjectListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration").append("\n"); 
		query.append("FileName : TariffConditionManageDBDAOSearchTariffObjectListRSQL").append("\n"); 
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
		query.append("O.OBJ_LIST_NO" ).append("\n"); 
		query.append(", O.OBJ_LIST_NM" ).append("\n"); 
		query.append(", O.OBJ_LIST_ABBR_NM" ).append("\n"); 
		query.append(", O.TML_OBJ_LIST_TP_CD" ).append("\n"); 
		query.append(", O.TML_MEAS_UT_CD" ).append("\n"); 
		query.append(", O.TML_VAL_TP_CD" ).append("\n"); 
		query.append(", O.DFLT_CTNT" ).append("\n"); 
		query.append(", O.DFLT_VAL" ).append("\n"); 
		query.append(", O.MAX_VAL" ).append("\n"); 
		query.append(", O.MIN_VAL" ).append("\n"); 
		query.append(", O.OBJ_RMK" ).append("\n"); 
		query.append(", O.INTER_USE_FLG" ).append("\n"); 
		query.append(", O.DELT_FLG" ).append("\n"); 
		query.append("FROM TES_OBJ_LIST O" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cond_tp_cd} != '')" ).append("\n"); 
		query.append("AND O.TML_OBJ_LIST_TP_CD = @[cond_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(O.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(O.INTER_USE_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("ORDER BY O.TML_OBJ_LIST_TP_CD, O.OBJ_LIST_NO" ).append("\n"); 

	}
}