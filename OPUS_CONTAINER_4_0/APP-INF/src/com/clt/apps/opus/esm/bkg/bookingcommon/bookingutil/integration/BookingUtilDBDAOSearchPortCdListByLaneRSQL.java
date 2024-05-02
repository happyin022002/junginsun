/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchPortCdListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.16
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.06.16 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchPortCdListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane과 Bound 조건으로 Port(POL) list를 가져와 콤보용으로 사용
	  * </pre>
	  */
	public BookingUtilDBDAOSearchPortCdListByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchPortCdListByLaneRSQL").append("\n"); 
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
		query.append("#if(${port_cd} !='')" ).append("\n"); 
		query.append("	SELECT DISTINCT A.POD_CD AS PORT_CD, A.SLAN_CD AS VSL_SLAN_CD, A.SKD_DIR_CD" ).append("\n"); 
		query.append("	FROM BKG_VVD_BDR_LOG A" ).append("\n"); 
		query.append("	WHERE  1=1" ).append("\n"); 
		query.append("		#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("			AND	   A.SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("			AND    A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${port_cd} != '') " ).append("\n"); 
		query.append("		AND    A.POL_CD  = @[port_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	ORDER BY PORT_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT DISTINCT A.POL_CD AS PORT_CD, A.SLAN_CD AS VSL_SLAN_CD, A.SKD_DIR_CD" ).append("\n"); 
		query.append("	FROM BKG_VVD_BDR_LOG A" ).append("\n"); 
		query.append("	WHERE  1=1" ).append("\n"); 
		query.append("		#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("			AND	   A.SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("			AND    A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	ORDER BY PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}