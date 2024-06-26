/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCustHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
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

public class CustMainDBDAOSearchCustHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer history
	  * </pre>
	  */
	public CustMainDBDAOSearchCustHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCustHistoryRSQL").append("\n"); 
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
		query.append("SELECT MCHD.HIS_SEQ" ).append("\n"); 
		query.append("       ,MCHD.HIS_DTL_SEQ" ).append("\n"); 
		query.append("       ,CASE WHEN MCHD.TBL_NM = 'MDM_CUST_ADDR' AND MCHD.COL_NM = 'ALL' THEN 'Address'" ).append("\n"); 
		query.append("             ELSE BHC.TBL_DP_NM END ITEM_HDR" ).append("\n"); 
		query.append("       ,MCHD.COL_NM" ).append("\n"); 
		query.append("       ,BHC.COL_DP_NM HIS_CATE_NM" ).append("\n"); 
		query.append("       ,CASE WHEN BHC.INTG_CD_ID IS NOT NULL" ).append("\n"); 
		query.append("             THEN (SELECT COD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL COD WHERE COD.INTG_CD_ID = BHC.INTG_CD_ID AND MCHD.PRE_CTNT = COD.INTG_CD_VAL_CTNT AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ELSE MCHD.PRE_CTNT" ).append("\n"); 
		query.append("        END PRE_CTNT" ).append("\n"); 
		query.append("        ,CASE WHEN BHC.INTG_CD_ID IS NOT NULL" ).append("\n"); 
		query.append("             THEN (SELECT COD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL COD WHERE COD.INTG_CD_ID = BHC.INTG_CD_ID AND MCHD.CRNT_CTNT = COD.INTG_CD_VAL_CTNT AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ELSE MCHD.CRNT_CTNT" ).append("\n"); 
		query.append("        END CRNT_CTNT" ).append("\n"); 
		query.append("       ,CU.USR_NM CRE_USR_ID" ).append("\n"); 
		query.append("       ,CU.OFC_CD OFFICE" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MCHD.CRE_DT,BKG_COM_USER_LOC_FNC(MCHD.CRE_USR_ID)), 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MCHD.CRE_DT,'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DT" ).append("\n"); 
		query.append("FROM MDM_CUST_HIS_DTL MCHD" ).append("\n"); 
		query.append("     ,COM_USER CU" ).append("\n"); 
		query.append("     ,MDM_HIS_TBL_COL BHC" ).append("\n"); 
		query.append("WHERE MCHD.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND MCHD.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND MCHD.CRE_USR_ID = CU.USR_ID(+) " ).append("\n"); 
		query.append("AND BHC.TBL_NM = 'MDM_CUSTOMER'" ).append("\n"); 
		query.append("AND MCHD.COL_NM = BHC.COL_NM" ).append("\n"); 
		query.append("ORDER BY MCHD.HIS_SEQ, MCHD.HIS_DTL_SEQ" ).append("\n"); 

	}
}