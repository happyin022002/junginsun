/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchWaterLocVesselYardInitialInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.29
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.07.29 이주현
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

public class CommonDBDAOSearchWaterLocVesselYardInitialInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Water에서 vessel schedule 에서 해당 vvd - location 의 yard 정보를 조회
	  * </pre>
	  */
	public CommonDBDAOSearchWaterLocVesselYardInitialInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdDirCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchWaterLocVesselYardInitialInfoRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD AS YD_CD, B.YD_NM AS YD_NM" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("     MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND   A.VSL_CD = @[vslCd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[skdVoyNo]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skdDirCd]" ).append("\n"); 
		query.append("AND   A.VPS_PORT_CD = @[ecc] " ).append("\n"); 
		query.append("AND   A.TURN_PORT_IND_CD NOT IN ( 'D', 'V')" ).append("\n"); 
		query.append("ORDER BY A.CLPT_SEQ" ).append("\n"); 

	}
}