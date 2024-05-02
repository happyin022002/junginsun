/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchWaterLocDischargeYardInitialInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.10 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchWaterLocDischargeYardInitialInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_0059 Water Discharge LOC 콤보로 가져오기
	  * </pre>
	  */
	public CommonDBDAOSearchWaterLocDischargeYardInitialInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdDirCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchWaterLocDischargeYardInitialInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("A.YD_CD AS YD_CD" ).append("\n"); 
		query.append(", B.YD_NM AS YD_NM" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND   A.VSL_CD = @[vslCd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[skdVoyNo]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skdDirCd] " ).append("\n"); 
		query.append("AND   A.VPS_PORT_CD = SUBSTR(@[to_ecc] , 0, 5)" ).append("\n"); 
		query.append("AND   A.CLPT_SEQ > NVL(( SELECT MIN(SUB.CLPT_SEQ)" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD SUB" ).append("\n"); 
		query.append("                        WHERE SUB.VSL_CD = @[vslCd]" ).append("\n"); 
		query.append("                         AND   SUB.SKD_VOY_NO = @[skdVoyNo]" ).append("\n"); 
		query.append("                         AND   SUB.SKD_DIR_CD = @[skdDirCd]" ).append("\n"); 
		query.append("                         AND   SUB.VPS_PORT_CD = SUBSTR(@[fm_ecc] , 0, 5)" ).append("\n"); 
		query.append("                         GROUP BY SUB.VSL_CD, SUB.SKD_VOY_NO, SKD_DIR_CD), 0)" ).append("\n"); 

	}
}