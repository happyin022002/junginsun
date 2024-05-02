/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandRouteManageDBDAOUpdateOptmFlagForUsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOUpdateOptmFlagForUsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRouteManageDBDAOUpdateOptmFlagForUsUSQL
	  * </pre>
	  */
	public InlandRouteManageDBDAOUpdateOptmFlagForUsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOUpdateOptmFlagForUsUSQL").append("\n"); 
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
		query.append("UPDATE prd_inlnd_rout_mst m          " ).append("\n"); 
		query.append("SET inlnd_rout_optm_flg = 'Y'" ).append("\n"); 
		query.append("WHERE m.rout_org_nod_cd = @[i_rout_org_nod_cd]  " ).append("\n"); 
		query.append("AND m.rout_dest_nod_cd = @[i_rout_dest_nod_cd] " ).append("\n"); 
		query.append("AND m.rout_seq = @[i_rout_seq]" ).append("\n"); 
		query.append("AND 'Y' = NVL(@[i_bkg_flg] ,'X')" ).append("\n"); 
		query.append("AND SUBSTR(m.ROUT_ORG_NOD_CD, 1,5) <> SUBSTR(m.ROUT_DEST_NOD_CD, 1,5)" ).append("\n"); 
		query.append("AND 0 = (SELECT COUNT(1) FROM PRD_INLND_ROUT_MST ML" ).append("\n"); 
		query.append("          WHERE ML.ROUT_ORG_NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("            AND ML.ROUT_DEST_NOD_CD = M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            AND ML.PCTL_IO_BND_CD = M.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("            AND NVL(ML.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("            AND ML.INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append("            AND ROWNUM = 1)" ).append("\n"); 

	}
}