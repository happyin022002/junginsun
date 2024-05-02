/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVvdByReceviedVoyDirCallSignNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.04.12 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchVvdByReceviedVoyDirCallSignNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VVD of vessel schedule, mapping EDI's voyage, direction, call sign no, yard code.
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVvdByReceviedVoyDirCallSignNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_skd_dir_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchVvdByReceviedVoyDirCallSignNoRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD  IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  VSL_CD" ).append("\n"); 
		query.append("    FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("    WHERE 	CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("    AND 	DELT_FLG 	= 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = @[edi_skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = @[edi_skd_dir_nm]" ).append("\n"); 
		query.append("AND     YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("AND     'S'         <> NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}