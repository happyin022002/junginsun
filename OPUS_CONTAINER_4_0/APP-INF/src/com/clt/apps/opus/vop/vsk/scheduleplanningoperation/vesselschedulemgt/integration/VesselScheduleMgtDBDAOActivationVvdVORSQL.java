/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOActivationVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.05.28 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOActivationVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL SKD Delete & Closing Query
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOActivationVvdVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T2.VSL_ENG_NM,T1.VSL_SLAN_CD,T1.SKD_STS_CD," ).append("\n"); 
		query.append("T1.CRE_DT, T1.N1ST_PORT_BRTH_DT, 'N' AS hisflag" ).append("\n"); 
		query.append("FROM	VSK_VSL_SKD T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("WHERE   T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("and	T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("and	T1.VSL_CD LIKE @[vsl_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_sts_cd} != '')" ).append("\n"); 
		query.append("and	T1.SKD_STS_CD LIKE @[skd_sts_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOActivationVvdVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}