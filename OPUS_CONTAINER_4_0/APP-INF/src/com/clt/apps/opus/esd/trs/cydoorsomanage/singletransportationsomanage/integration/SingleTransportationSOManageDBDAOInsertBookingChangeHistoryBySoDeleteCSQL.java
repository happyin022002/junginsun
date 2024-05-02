/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOInsertBookingChangeHistoryBySoDeleteCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOInsertBookingChangeHistoryBySoDeleteCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertBookingChangeHistoryBySoDelete
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOInsertBookingChangeHistoryBySoDeleteCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOInsertBookingChangeHistoryBySoDeleteCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_BKG_CNG_HIS (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,CNG_CATE_CD" ).append("\n"); 
		query.append("	,CNG_CATE_SUB_CD" ).append("\n"); 
		query.append("	,TRSP_CNG_SUB_SEQ" ).append("\n"); 
		query.append("	,TRSP_CNG_SUB_HIS_SEQ" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,TRSP_SO_SEQ" ).append("\n"); 
		query.append("	,PRMRY_COL_NM" ).append("\n"); 
		query.append("	,PRMRY_COL_VAL_RMK" ).append("\n"); 
		query.append("	,TBL_NM" ).append("\n"); 
		query.append("	,COL_NM" ).append("\n"); 
		query.append("	,COL_N1ST_RMK" ).append("\n"); 
		query.append("	,COL_N2ND_RMK" ).append("\n"); 
		query.append("	,DELT_FLG" ).append("\n"); 
		query.append("	,LOCL_CRE_DT" ).append("\n"); 
		query.append("	,LOCL_UPD_DT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,CNG_IND_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("	,CNG_CATE_CD" ).append("\n"); 
		query.append("	,CNG_CATE_SUB_CD" ).append("\n"); 
		query.append("	,TRSP_CNG_SUB_SEQ" ).append("\n"); 
		query.append("	,(NVL((SELECT MAX(TRSP_CNG_SUB_HIS_SEQ)" ).append("\n"); 
		query.append("				FROM TRS_TRSP_BKG_CNG_HIS" ).append("\n"); 
		query.append("			 WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("				 AND CNG_CATE_CD = C.CNG_CATE_CD" ).append("\n"); 
		query.append("				 AND CNG_CATE_SUB_CD = C.CNG_CATE_SUB_CD" ).append("\n"); 
		query.append("				 AND TRSP_CNG_SUB_SEQ = C.TRSP_CNG_SUB_SEQ)," ).append("\n"); 
		query.append("			0) + 1) AS TRSP_CNG_SUB_HIS_SEQ" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,TRSP_SO_SEQ" ).append("\n"); 
		query.append("	,PRMRY_COL_NM" ).append("\n"); 
		query.append("	,PRMRY_COL_VAL_RMK" ).append("\n"); 
		query.append("	,TBL_NM" ).append("\n"); 
		query.append("	,COL_NM" ).append("\n"); 
		query.append("	,COL_N1ST_RMK" ).append("\n"); 
		query.append("	,COL_N2ND_RMK" ).append("\n"); 
		query.append("	,DELT_FLG" ).append("\n"); 
		query.append("	,LOCL_CRE_DT" ).append("\n"); 
		query.append("	,LOCL_UPD_DT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,CNG_IND_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_BKG_CNG C" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}