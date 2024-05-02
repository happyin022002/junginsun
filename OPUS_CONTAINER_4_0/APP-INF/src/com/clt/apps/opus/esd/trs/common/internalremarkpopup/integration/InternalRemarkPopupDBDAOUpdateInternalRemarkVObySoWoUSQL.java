/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.02
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.02 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. S/O delete 시
	  * : S/O No.에 해당하는 Remark들의 DELT_FLG = 'Y'로 설정
	  * 2. W/O cancel 시
	  * : W/O No.에 해당하는 Remark들의 DELT_FLG = 'Y'로 설정
	  * </pre>
	  */
	public InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration").append("\n"); 
		query.append("FileName : InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_INTER_RMK SET" ).append("\n"); 
		query.append("	DELT_FLG = 'Y'" ).append("\n"); 
		query.append("   ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("   ,LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${so_no} != '')" ).append("\n"); 
		query.append("  AND TRSP_SO_OFC_CTY_CD = SUBSTR(@[so_no], 0, 3)" ).append("\n"); 
		query.append("  AND TRSP_SO_SEQ = SUBSTR(@[so_no], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wo_no} != '')" ).append("\n"); 
		query.append("  AND (TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ" ).append("\n"); 
		query.append("        FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("        WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("            AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("            AND WO_CXL_FLG = 'Y' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}