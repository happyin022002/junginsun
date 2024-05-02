/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InternalRemarkPopupDBDAOInternalRemarkVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.06.17 박찬우
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

public class InternalRemarkPopupDBDAOInternalRemarkVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update Internal Remark Table or set DELT_FLG = 'Y'
	  * </pre>
	  */
	public InternalRemarkPopupDBDAOInternalRemarkVOUSQL(){
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
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration").append("\n"); 
		query.append("FileName : InternalRemarkPopupDBDAOInternalRemarkVOUSQL").append("\n"); 
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
		query.append("	  INTER_RMK_CTNT = @[inter_rmk]" ).append("\n"); 
		query.append("     ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	 ,LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("#if (${status} == 'D')" ).append("\n"); 
		query.append("	 ,DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND INTER_RMK_SEQ = @[inter_rmk_seq]" ).append("\n"); 
		query.append("#if(${eq_no} != '')" ).append("\n"); 
		query.append("  AND EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${so_no} != '')" ).append("\n"); 
		query.append("  AND TRSP_SO_OFC_CTY_CD = SUBSTR(@[so_no], 0, 3)" ).append("\n"); 
		query.append("  AND TRSP_SO_SEQ = SUBSTR(@[so_no], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wo_no} != '')" ).append("\n"); 
		query.append("  AND TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no], 0, 3)" ).append("\n"); 
		query.append("  AND TRSP_WO_SEQ = SUBSTR(@[wo_no], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}