/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAORemoveVslSkdByEmptyVvdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAORemoveVslSkdByEmptyVvdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Virtual Port로만 구성된 Port SKD 삭제이후 Empty VVD 삭제처리
	  * </pre>
	  */
	public VesselScheduleMgtDBDAORemoveVslSkdByEmptyVvdDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAORemoveVslSkdByEmptyVvdDSQL").append("\n"); 
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
		query.append("DELETE    FROM   VSK_VSL_SKD X" ).append("\n"); 
		query.append("WHERE            (X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD)" ).append("\n"); 
		query.append("                 IN" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                 --------------------------------------------------" ).append("\n"); 
		query.append("                  SELECT    VS.VSL_CD,VS.SKD_VOY_NO,VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                  FROM      VSK_VSL_SKD   VS" ).append("\n"); 
		query.append("                  WHERE     NOT EXISTS    (SELECT   ''    " ).append("\n"); 
		query.append("                                           FROM     VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("                                           WHERE    PS.VSL_CD         = VS.VSL_CD" ).append("\n"); 
		query.append("                                           AND      PS.SKD_VOY_NO     = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND      PS.SKD_DIR_CD     = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                  AND       VS.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND       VS.SKD_VOY_NO  = @[turn_skd_voy_no]" ).append("\n"); 
		query.append("                  AND       VS.SKD_DIR_CD  = @[turn_skd_dir_cd]" ).append("\n"); 
		query.append("                 --------------------------------------------------" ).append("\n"); 
		query.append("                 )" ).append("\n"); 

	}
}