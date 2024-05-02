/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoAllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수신된 CONVEYANCE REFERENCE NUMBER (SHIP CALL NO.) MYPKG에서 사용하는 NO , SML Vessel Code, Location Code를 이용한 SML에 맵핑되는 모든 VVD를 조회한다.
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoAllRSQL").append("\n"); 
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
		query.append("SELECT  T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.YD_CD" ).append("\n"); 
		query.append("FROM    BKG_VSL_DCHG_YD T1, VSK_VSL_PORT_SKD T2                              " ).append("\n"); 
		query.append("WHERE   1 = 1                                                                " ).append("\n"); 
		query.append("AND     T1.VSL_CD         = T2.VSL_CD                          " ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO     = T2.SKD_VOY_NO                              " ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD     = T2.SKD_DIR_CD                              " ).append("\n"); 
		query.append("AND     T1.PORT_CD        = T2.VPS_PORT_CD                     " ).append("\n"); 
		query.append("AND     T1.CLPT_IND_SEQ   = T2.CLPT_IND_SEQ                            " ).append("\n"); 
		query.append("AND     'S'              != NVL(T2.SKD_CNG_STS_CD, ' ')                " ).append("\n"); 
		query.append("AND     T1.VSL_CD         = @[edi_vsl_nm]                       " ).append("\n"); 
		query.append("AND    (T1.CVY_REF_NO     = @[shp_call_no] OR T1.UQ_VSL_ID_NO = @[shp_call_no])" ).append("\n"); 
		query.append("AND     T2.VPS_PORT_CD    = @[vps_port_cd]                                        " ).append("\n"); 
		query.append("AND     T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')                           " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.YD_CD" ).append("\n"); 
		query.append("FROM    BKG_VSL_DCHG_YD T1, VSK_VSL_PORT_SKD T2                              " ).append("\n"); 
		query.append("WHERE   1 = 1                                                                " ).append("\n"); 
		query.append("AND     T1.VSL_CD         = T2.VSL_CD                          " ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO     = T2.SKD_VOY_NO                              " ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD     = T2.SKD_DIR_CD                              " ).append("\n"); 
		query.append("AND     T1.PORT_CD        = T2.VPS_PORT_CD                     " ).append("\n"); 
		query.append("AND     T1.CLPT_IND_SEQ   = T2.CLPT_IND_SEQ                            " ).append("\n"); 
		query.append("AND     'S'              != NVL(T2.SKD_CNG_STS_CD, ' ')                " ).append("\n"); 
		query.append("AND     T1.VSL_CD      IN                " ).append("\n"); 
		query.append("(                                                                            " ).append("\n"); 
		query.append("    SELECT  VSL_CD                                                           " ).append("\n"); 
		query.append("    FROM    MDM_VSL_CNTR                                                     " ).append("\n"); 
		query.append("    WHERE   CALL_SGN_NO = @[call_sgn_no]                               " ).append("\n"); 
		query.append("    AND     DELT_FLG    = 'N'                                        " ).append("\n"); 
		query.append(")                                                                            " ).append("\n"); 
		query.append("AND    (T1.CVY_REF_NO   = @[shp_call_no] OR T1.UQ_VSL_ID_NO = @[shp_call_no])" ).append("\n"); 
		query.append("AND     T2.VPS_PORT_CD    = @[vps_port_cd]                                          " ).append("\n"); 
		query.append("AND     T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')                           " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.YD_CD" ).append("\n"); 
		query.append("FROM    BKG_VSL_DCHG_YD T1, VSK_VSL_PORT_SKD T2                              " ).append("\n"); 
		query.append("WHERE   1 = 1                                                                " ).append("\n"); 
		query.append("AND     T1.VSL_CD         = T2.VSL_CD                          " ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO     = T2.SKD_VOY_NO                              " ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD     = T2.SKD_DIR_CD                              " ).append("\n"); 
		query.append("AND     T1.PORT_CD        = T2.VPS_PORT_CD                             " ).append("\n"); 
		query.append("AND     T1.CLPT_IND_SEQ   = T2.CLPT_IND_SEQ                            " ).append("\n"); 
		query.append("AND     'S'              != NVL(T2.SKD_CNG_STS_CD, ' ')                " ).append("\n"); 
		query.append("AND     T1.VSL_CD IN                                          " ).append("\n"); 
		query.append("(                                                                            " ).append("\n"); 
		query.append("    SELECT  VSL_CD                                                           " ).append("\n"); 
		query.append("    FROM    MDM_VSL_CNTR                                                     " ).append("\n"); 
		query.append("    WHERE   LLOYD_NO    = @[lloyd_no]                                      " ).append("\n"); 
		query.append("    AND     DELT_FLG    = 'N'                                            " ).append("\n"); 
		query.append(")                                                                            " ).append("\n"); 
		query.append("AND    (T1.CVY_REF_NO     = @[shp_call_no] OR T1.UQ_VSL_ID_NO = @[shp_call_no])" ).append("\n"); 
		query.append("AND     T2.VPS_PORT_CD    = @[vps_port_cd]                                       " ).append("\n"); 
		query.append("AND     T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')                           " ).append("\n"); 
		query.append("GROUP BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.YD_CD" ).append("\n"); 

	}
}