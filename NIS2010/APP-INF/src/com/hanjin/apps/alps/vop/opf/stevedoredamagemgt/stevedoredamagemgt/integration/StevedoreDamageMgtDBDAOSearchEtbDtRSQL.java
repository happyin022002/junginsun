/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSearchEtbDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.07
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.07 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSearchEtbDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD, Port 입력시 ETB일자를 가져온다.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSearchEtbDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOSearchEtbDtRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("          PS.CLPT_IND_SEQ AS CLPT_IND_SEQ," ).append("\n"); 
		query.append("          TO_CHAR(PS.VPS_ETB_DT, 'YYYYMMDD') AS VPS_ETB_DT," ).append("\n"); 
		query.append("          TO_CHAR(PS.VPS_ETD_DT, 'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("FROM      VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("WHERE     PS.VSL_CD         =  @[vsl_cd]" ).append("\n"); 
		query.append("AND       PS.SKD_VOY_NO     =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND       PS.SKD_DIR_CD     =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND       PS.VPS_PORT_CD    =  @[vps_port_cd]" ).append("\n"); 
		query.append("AND       PS.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 

	}
}