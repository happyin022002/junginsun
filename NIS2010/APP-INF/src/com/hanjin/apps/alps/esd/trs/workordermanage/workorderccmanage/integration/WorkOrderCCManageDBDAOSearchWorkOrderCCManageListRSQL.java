/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderCCManageDBDAOSearchWorkOrderCCManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2010.04.09 조풍연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author POONG-YEON CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderCCManageDBDAOSearchWorkOrderCCManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderCC 관리 목록을 조회한다.
	  * </pre>
	  */
	public WorkOrderCCManageDBDAOSearchWorkOrderCCManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_Cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration").append("\n"); 
		query.append("FileName : WorkOrderCCManageDBDAOSearchWorkOrderCCManageListRSQL").append("\n"); 
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
		query.append("SELECT XX.* FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL2(X.VNDR_SEQ, 'Y', 'N') CC_EXIST_INDICATOR ," ).append("\n"); 
		query.append("X.VNDR_SEQ VNDR_SEQ ," ).append("\n"); 
		query.append("X.VNDR_LGL_ENG_NM VNDR_NM ," ).append("\n"); 
		query.append("X.OFC_CD CTRL_OFC_CD ," ).append("\n"); 
		query.append("X.LOC_CD LOC_CD ," ).append("\n"); 
		query.append("Y.CRE_OFC_CD CRE_OFC_CD ," ).append("\n"); 
		query.append("Y.CRE_USR_ID CRE_USR_ID ," ).append("\n"); 
		query.append("TO_CHAR(Y.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT," ).append("\n"); 
		query.append("Y.HJL_NO HJL_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_CC Y ," ).append("\n"); 
		query.append("MDM_VENDOR X" ).append("\n"); 
		query.append("WHERE X.VNDR_SEQ = Y.VNDR_SEQ (+)" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND X.VNDR_SEQ = NVL(@[vndr_seq], X.VNDR_SEQ)" ).append("\n"); 
		query.append("AND X.OFC_CD = NVL(UPPER(@[ofc_Cd]), X.OFC_CD)" ).append("\n"); 
		query.append("AND X.LOC_CD = NVL(@[loc_cd], X.LOC_CD)" ).append("\n"); 
		query.append("AND rownum < 500" ).append("\n"); 
		query.append("-- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("--AND Y.HJL_NO(+) IS NULL" ).append("\n"); 
		query.append("ORDER BY X.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(") XX" ).append("\n"); 

	}
}