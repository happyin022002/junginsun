/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InternalRemarkPopupDBDAOInternalRemarkVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InternalRemarkPopupDBDAOInternalRemarkVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create New Internal Remark
	  * </pre>
	  */
	public InternalRemarkPopupDBDAOInternalRemarkVOCSQL(){
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
		params.put("inter_rmk_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InternalRemarkPopupDBDAOInternalRemarkVOCSQL").append("\n"); 
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
		query.append("INSERT INTO " ).append("\n"); 
		query.append("TRS_INTER_RMK(" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("   ,INTER_RMK_SEQ" ).append("\n"); 
		query.append("   ,EQ_NO" ).append("\n"); 
		query.append("   ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("   ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("   ,INTER_RMK_CTNT" ).append("\n"); 
		query.append("   ,DELT_FLG" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,INTER_RMK_CD" ).append("\n"); 
		query.append("   ,CRE_OFC_CD" ).append("\n"); 
		query.append("   ,LOCL_CRE_DT" ).append("\n"); 
		query.append("   ,LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("	NVL(@[bkg_no], 'DUM000000000')" ).append("\n"); 
		query.append("   ,NVL((SELECT /*+ index_desc(TRS_INTER_RMK XPKTRS_INTER_RMK) +*/   " ).append("\n"); 
		query.append("            INTER_RMK_SEQ" ).append("\n"); 
		query.append("            FROM TRS_INTER_RMK" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("			  AND BKG_NO = NVL(@[bkg_no], 'DUM000000000')" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), 0) + 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("   ,@[eq_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   ,''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${so_no} != '')" ).append("\n"); 
		query.append("   ,SUBSTR(@[so_no], 0, 3)" ).append("\n"); 
		query.append("   ,SUBSTR(@[so_no], 4)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   ,''" ).append("\n"); 
		query.append("   ,''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${wo_no} != '')" ).append("\n"); 
		query.append("   ,SUBSTR(@[wo_no], 0, 3)" ).append("\n"); 
		query.append("   ,SUBSTR(@[wo_no], 4)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   ,''" ).append("\n"); 
		query.append("   ,''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ,@[inter_rmk]" ).append("\n"); 
		query.append("   ,'N'" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,DECODE(@[inter_rmk_cd], 'BKG', 'B', 'T')" ).append("\n"); 
		query.append("   ,@[ofc_cd]" ).append("\n"); 
		query.append("   ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("   ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}