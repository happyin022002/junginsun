/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : MstMgmtDBDAOSearchMdmHistListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchMdmHistListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_HIS_DTL List 정보 조회
	  * </pre>
	  */
	public MstMgmtDBDAOSearchMdmHistListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchMdmHistListRSQL").append("\n"); 
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
		query.append("SELECT MHTC.TBL_DP_NM" ).append("\n"); 
		query.append("       , MHTC.COL_DP_NM" ).append("\n"); 
		query.append("       , NVL((SELECT CICD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CICD WHERE CICD.INTG_CD_ID = MHTC.INTG_CD_ID AND CICD.INTG_CD_VAL_CTNT = MHD.CRNT_CTNT),MHD.CRNT_CTNT) CRNT_CTNT" ).append("\n"); 
		query.append("       , NVL((SELECT CICD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CICD WHERE CICD.INTG_CD_ID = MHTC.INTG_CD_ID AND CICD.INTG_CD_VAL_CTNT = MHD.PRE_CTNT),MHD.PRE_CTNT) PRE_CTNT" ).append("\n"); 
		query.append("       , CU.USR_NM" ).append("\n"); 
		query.append("       ,CU.OFC_CD OFFICE" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MHD.UPD_DT,BKG_COM_USER_LOC_FNC(MHD.UPD_USR_ID)), 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MHD.UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DT" ).append("\n"); 
		query.append("FROM MDM_HIS_DTL MHD" ).append("\n"); 
		query.append("     ,MDM_HIS_TBL_COL MHTC" ).append("\n"); 
		query.append("     ,COM_USER CU" ).append("\n"); 
		query.append("WHERE MHD.TBL_NM IN (SELECT MHTC1.TBL_NM FROM MDM_HIS_TBL_COL MHTC1 WHERE MHTC1.HIS_CATE_NM = @[tbl_nm])" ).append("\n"); 
		query.append("AND MHD.TBL_NM = MHTC.TBL_NM " ).append("\n"); 
		query.append("AND MHD.COL_NM = MHTC.COL_NM" ).append("\n"); 
		query.append("AND CU.USR_ID = MHD.UPD_USR_ID" ).append("\n"); 
		query.append("AND MHD.MST_KEY = @[mst_key]" ).append("\n"); 
		query.append("AND MHTC.HIS_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY MHD.CRE_DT" ).append("\n"); 

	}
}