/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVvdByReceviedShipCallNoCallSignNoRSQL.java
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

public class ActualScheduleMgtDBDAOSearchVvdByReceviedShipCallNoCallSignNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VVD of vessel schedule, mapping EDI's info.
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVvdByReceviedShipCallNoCallSignNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ActualScheduleMgtDBDAOSearchVvdByReceviedShipCallNoCallSignNoRSQL").append("\n"); 
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
		query.append("SELECT	T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM	BKG_VSL_DCHG_YD T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND		T1.PORT_CD		= T2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND		T1.CLPT_IND_SEQ	= T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND		'S'            != NVL(T2.SKD_CNG_STS_CD	,' ')" ).append("\n"); 
		query.append("AND		T1.VSL_CD 	IN	" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  VSL_CD" ).append("\n"); 
		query.append("    FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("    WHERE 	CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("    AND 	DELT_FLG 	= 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    (T1.CVY_REF_NO	= @[shp_call_no] OR T1.UQ_VSL_ID_NO = @[shp_call_no])" ).append("\n"); 
		query.append("AND     T2.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("AND     T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("GROUP BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD" ).append("\n"); 

	}
}