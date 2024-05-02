/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL").append("\n"); 
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
		query.append("SELECT  SLAN_CD" ).append("\n"); 
		query.append("        , VPS_PORT_CD" ).append("\n"); 
		query.append("        , YD_CD" ).append("\n"); 
		query.append("        , SKD_CNG_STS_CD" ).append("\n"); 
		query.append("        , VPS_ETA_DT" ).append("\n"); 
		query.append("        , VPS_ETB_DT" ).append("\n"); 
		query.append("        , VPS_ETD_DT" ).append("\n"); 
		query.append("FROM    ( " ).append("\n"); 
		query.append("        SELECT	1 AS SEQ" ).append("\n"); 
		query.append("                , T2.VSL_SLAN_CD                            AS SLAN_CD" ).append("\n"); 
		query.append("                , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                , T1.YD_CD" ).append("\n"); 
		query.append("                , T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                , TO_CHAR(T1.VPS_ETA_DT, 'YYYYMMDDHH24MI')  AS VPS_ETA_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI')  AS VPS_ETB_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI')  AS VPS_ETD_DT" ).append("\n"); 
		query.append("        FROM	VSK_VSL_PORT_SKD T1, VSK_VSL_SKD T2" ).append("\n"); 
		query.append("        WHERE	1 = 1" ).append("\n"); 
		query.append("        AND	T1.VSL_CD        = T2.VSL_CD" ).append("\n"); 
		query.append("        AND	T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND	T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND	T1.VSL_CD        = @[vsl_cd]    	/* 변경 전 VSL_CD           */" ).append("\n"); 
		query.append("        AND	T1.SKD_VOY_NO    = @[skd_voy_no]    /* 변경 전 SKD_VOY_NO       */" ).append("\n"); 
		query.append("        AND	T1.SKD_DIR_CD    = @[skd_dir_cd]    /* 변경 전 SKD_DIR_CD       */" ).append("\n"); 
		query.append("        #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("        AND	T1.VPS_PORT_CD   = @[vps_port_cd]   /* 변경 전 VPS_PORT_CD      */" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${clpt_ind_seq} != '') " ).append("\n"); 
		query.append("        AND	T1.CLPT_IND_SEQ  = @[clpt_ind_seq]  /* 변경 전 CLPT_IND_SEQ     */" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND	(" ).append("\n"); 
		query.append("                EXISTS	(   SELECT  'X'" ).append("\n"); 
		query.append("                            FROM    BKG_VVD S, BKG_BOOKING B" ).append("\n"); 
		query.append("                            WHERE   1 = 1" ).append("\n"); 
		query.append("                            AND     S.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("                            AND     B.BKG_STS_CD      != 'X'" ).append("\n"); 
		query.append("                            AND     S.VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("                            AND     S.SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND     S.SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND     (" ).append("\n"); 
		query.append("        								(S.POL_CD      = T1.VPS_PORT_CD AND S.POL_CLPT_IND_SEQ = T1.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("        								OR" ).append("\n"); 
		query.append("        								(S.POD_CD      = T1.VPS_PORT_CD AND S.POD_CLPT_IND_SEQ = T1.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("        							)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("		-- Turn/Virtual 연결을 다시 했을 경우, Virual SKD에 History를 생성하지 못하는 문제 해결. (2014.09.30)" ).append("\n"); 
		query.append("        SELECT  2 AS SEQ" ).append("\n"); 
		query.append("                , S.SLAN_CD                                 AS SLAN_CD" ).append("\n"); 
		query.append("                , @[vps_port_cd]                            AS VPS_PORT_CD" ).append("\n"); 
		query.append("                , @[yd_cd]                                  AS YD_CD" ).append("\n"); 
		query.append("                , 'T=V'                                     AS SKD_CNG_STS_CD  -- Addition로 처리한다.??" ).append("\n"); 
		query.append("                , @[vps_eta_dt]                             AS VPS_ETA_DT" ).append("\n"); 
		query.append("                , @[vps_etb_dt]                             AS VPS_ETB_DT" ).append("\n"); 
		query.append("                , @[vps_etd_dt]                             AS VPS_ETD_DT" ).append("\n"); 
		query.append("        FROM    BKG_VVD S, BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     S.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("        AND     B.BKG_STS_CD      != 'X'" ).append("\n"); 
		query.append("        AND     S.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("        AND     S.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND     S.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND     (" ).append("\n"); 
		query.append("        			(S.POL_CD      = @[vps_port_cd] AND S.POL_CLPT_IND_SEQ = @[clpt_ind_seq])" ).append("\n"); 
		query.append("        			OR" ).append("\n"); 
		query.append("        			(S.POD_CD      = @[vps_port_cd] AND S.POD_CLPT_IND_SEQ = @[clpt_ind_seq])" ).append("\n"); 
		query.append("        		)" ).append("\n"); 
		query.append("        AND     ROWNUM             = 1" ).append("\n"); 
		query.append("        ORDER BY SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   ROWNUM          = 1" ).append("\n"); 

	}
}