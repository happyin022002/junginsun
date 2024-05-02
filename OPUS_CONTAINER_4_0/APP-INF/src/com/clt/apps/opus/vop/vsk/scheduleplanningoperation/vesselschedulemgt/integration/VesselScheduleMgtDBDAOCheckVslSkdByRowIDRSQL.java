/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.07 
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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
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
		query.append("SELECT		T1.VSL_CD" ).append("\n"); 
		query.append("		,	T1.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	T2.VSL_SLAN_CD		AS SLAN_CD" ).append("\n"); 
		query.append("		, 	T1.VPS_PORT_CD" ).append("\n"); 
		query.append("		, 	T1.YD_CD" ).append("\n"); 
		query.append("		, 	T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("		, 	TO_CHAR(T1.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("		, 	TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("		, 	TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	CASE 	WHEN T1.TURN_PORT_IND_CD IN ('Y','N') THEN 'ACTUAL'" ).append("\n"); 
		query.append("					ELSE 'VIRTUAL'" ).append("\n"); 
		query.append("			END					AS BKG_VVD_KND" ).append("\n"); 
		query.append("FROM		VSK_VSL_PORT_SKD 	T1" ).append("\n"); 
		query.append("		, 	VSK_VSL_SKD 		T2" ).append("\n"); 
		query.append("WHERE		1 = 1" ).append("\n"); 
		query.append("AND			T1.VSL_CD        	= T2.VSL_CD" ).append("\n"); 
		query.append("AND			T1.SKD_VOY_NO   	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND			T1.SKD_DIR_CD    	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND			T1.VSL_CD        	= @[vsl_cd]    		/* 변경 전 VSL_CD           */" ).append("\n"); 
		query.append("AND			T1.SKD_VOY_NO    	= @[skd_voy_no]    	/* 변경 전 SKD_VOY_NO       */" ).append("\n"); 
		query.append("AND			T1.SKD_DIR_CD    	= @[skd_dir_cd]    	/* 변경 전 SKD_DIR_CD       */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("AND			T1.VPS_PORT_CD  	 = @[vps_port_cd]   /* 변경 전 VPS_PORT_CD      */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND			T1.CLPT_IND_SEQ  	= @[clpt_ind_seq]  	/* 변경 전 CLPT_IND_SEQ     */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	(" ).append("\n"); 
		query.append("        EXISTS	(   SELECT  	'X'" ).append("\n"); 
		query.append("                    FROM    	BKG_VVD 			S" ).append("\n"); 
		query.append("							, 	BKG_BOOKING 		B" ).append("\n"); 
		query.append("                    WHERE   	1 = 1" ).append("\n"); 
		query.append("                    AND     	S.BKG_NO           	= B.BKG_NO" ).append("\n"); 
		query.append("                    AND     	B.BKG_STS_CD      	!= 'X'" ).append("\n"); 
		query.append("                    AND     	S.VSL_CD           	= T1.VSL_CD" ).append("\n"); 
		query.append("                    AND     	S.SKD_VOY_NO       	= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     	S.SKD_DIR_CD       	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     	(" ).append("\n"); 
		query.append("								(S.POL_CD      		= T1.VPS_PORT_CD AND S.POL_CLPT_IND_SEQ = T1.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("								OR" ).append("\n"); 
		query.append("								(S.POD_CD      		= T1.VPS_PORT_CD AND S.POD_CLPT_IND_SEQ = T1.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}