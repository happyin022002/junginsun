/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCreditCustHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCreditCustHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Credit customer history
	  * </pre>
	  */
	public CustMainDBDAOSearchCreditCustHistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_key",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCreditCustHistRSQL").append("\n"); 
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
		query.append("SELECT MHD.HIS_SEQ" ).append("\n"); 
		query.append("       ,MHTC.TBL_DP_NM ITEM_HDR" ).append("\n"); 
		query.append("       , MHTC.COL_DP_NM HIS_CATE_NM" ).append("\n"); 
		query.append("       , NVL((SELECT CICD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CICD WHERE CICD.INTG_CD_ID = MHTC.INTG_CD_ID AND CICD.INTG_CD_VAL_CTNT = MHD.CRNT_CTNT),MHD.CRNT_CTNT) CRNT_CTNT" ).append("\n"); 
		query.append("       , NVL((SELECT CICD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CICD WHERE CICD.INTG_CD_ID = MHTC.INTG_CD_ID AND CICD.INTG_CD_VAL_CTNT = MHD.PRE_CTNT),MHD.PRE_CTNT) PRE_CTNT" ).append("\n"); 
		query.append("       , CU.USR_NM CRE_USR_ID" ).append("\n"); 
		query.append("       ,CU.OFC_CD OFFICE" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MHD.UPD_DT,BKG_COM_USER_LOC_FNC(MHD.UPD_USR_ID)), 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MHD.UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DT" ).append("\n"); 
		query.append("FROM MDM_HIS_DTL MHD" ).append("\n"); 
		query.append("     ,MDM_HIS_TBL_COL MHTC" ).append("\n"); 
		query.append("     ,COM_USER CU" ).append("\n"); 
		query.append("WHERE MHD.TBL_NM IN (SELECT MHTC1.TBL_NM FROM MDM_HIS_TBL_COL MHTC1 WHERE MHTC1.HIS_CATE_NM = 'MDM_CR_CUST')" ).append("\n"); 
		query.append("AND MHD.TBL_NM = MHTC.TBL_NM" ).append("\n"); 
		query.append("AND MHD.COL_NM = MHTC.COL_NM" ).append("\n"); 
		query.append("AND CU.USR_ID = MHD.UPD_USR_ID" ).append("\n"); 
		query.append("AND MHD.MST_KEY = @[mst_key]" ).append("\n"); 
		query.append("AND MHTC.HIS_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY MHD.HIS_SEQ, MHTC.TBL_DP_NM, MHTC.COL_DP_NM" ).append("\n"); 

	}
}