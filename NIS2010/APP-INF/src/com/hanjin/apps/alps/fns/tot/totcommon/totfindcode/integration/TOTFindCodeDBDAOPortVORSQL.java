/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TOTFindCodeDBDAOPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.12 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TOTFindCodeDBDAOPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * port code 조회
	  * </pre>
	  */
	public TOTFindCodeDBDAOPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration").append("\n"); 
		query.append("FileName : TOTFindCodeDBDAOPortVORSQL").append("\n"); 
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
		query.append("SELECT VPS_PORT_CD code" ).append("\n"); 
		query.append("     , VPS_PORT_CD name" ).append("\n"); 
		query.append(" FROM(" ).append("\n"); 
		query.append("		SELECT MIN(NVL(P.PORT_ROTN_SEQ,A.CLPT_SEQ)), A.SKD_DIR_CD, A.VPS_PORT_CD" ).append("\n"); 
		query.append("		  FROM VSK_VSL_PORT_SKD A, VSK_PF_SKD_DTL P" ).append("\n"); 
		query.append("		 WHERE A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("		   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		   AND A.SLAN_CD = P.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("		   AND A.SKD_DIR_CD = P.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		   AND A.VPS_PORT_CD  = P.PORT_CD(+)" ).append("\n"); 
		query.append("		   AND A.VPS_ETD_DT BETWEEN ADD_MONTHS(TO_DATE(@[vps_etd_dt],'YYYY-MM'), - 3) AND LAST_DAY(TO_DATE(@[vps_etd_dt],'YYYY-MM'))+0.99999" ).append("\n"); 
		query.append("		GROUP BY A.SKD_DIR_CD,A.VPS_PORT_CD" ).append("\n"); 
		query.append("		ORDER BY A.SKD_DIR_CD, MIN(NVL(P.PORT_ROTN_SEQ,99)),  A.VPS_PORT_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}