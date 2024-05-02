/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyRailBilOrdByMvCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyRailBilOrdByMvCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * move container 시 rail bill ord 의 bkg_no, bl_no, cop_no 를 변경한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyRailBilOrdByMvCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyRailBilOrdByMvCntrUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("SET BKG_NO = @[new_bkg_no]," ).append("\n"); 
		query.append("  BL_NO = @[new_bl_no]," ).append("\n"); 
		query.append("  COP_NO = @[new_cop_no]," ).append("\n"); 
		query.append("  BKG_NO_RVIS_FLG = DECODE(@[new_bkg_no], BKG_NO, NULL, 'Y')" ).append("\n"); 
		query.append("WHERE (TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("      TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("    SELECT TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("      TRSP_SO_SEQ" ).append("\n"); 
		query.append("    FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("    WHERE COP_NO = @[old_cop_no] AND NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("	AND COST_ACT_GRP_CD NOT LIKE 'OD%'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}