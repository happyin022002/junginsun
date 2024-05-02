/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WeeklyCMDBDAOModifyBkgQtyToMonVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOModifyBkgQtyToMonVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyBkgQtyToMonVVD UPDATE
	  * </pre>
	  */
	public WeeklyCMDBDAOModifyBkgQtyToMonVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOModifyBkgQtyToMonVVDUSQL").append("\n"); 
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
		query.append("UPDATE COA_MON_VVD C" ).append("\n"); 
		query.append("    SET C.BKG_TTL_QTY =" ).append("\n"); 
		query.append("        (SELECT SUM(DECODE(SUBSTR(B.CNTR_TPSZ_CD,2,1),'2',B.BKG_QTY,'3',B.BKG_QTY,B.BKG_QTY*2))" ).append("\n"); 
		query.append("           FROM COA_RGST_BKG    A," ).append("\n"); 
		query.append("                COA_BKG_REV_DTL B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("            AND A.BKG_NO_SPLIT  = B.BKG_NO_SPLIT" ).append("\n"); 
		query.append("            AND A.IOC_CD        = C.IOC_CD" ).append("\n"); 
		query.append("            AND A.TRD_CD        = C.TRD_CD" ).append("\n"); 
		query.append("            AND A.RLANE_CD      = C.RLANE_CD" ).append("\n"); 
		query.append("            AND A.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO    = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A.DIR_CD        = C.DIR_CD" ).append("\n"); 
		query.append("            AND A.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("            AND A.BKG_STS_CD    IN ('F','S') " ).append("\n"); 
		query.append("            AND A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       ,C.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,C.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("  WHERE C.COST_YRMON LIKE @[cost_yrmon]||'%'" ).append("\n"); 
		query.append("    AND C.COST_WK = @[cost_wk]" ).append("\n"); 

	}
}