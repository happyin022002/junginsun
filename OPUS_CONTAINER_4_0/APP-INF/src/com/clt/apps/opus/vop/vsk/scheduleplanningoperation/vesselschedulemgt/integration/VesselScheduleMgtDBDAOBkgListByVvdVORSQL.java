/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOBkgListByVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.22 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOBkgListByVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별 Booking List를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOBkgListByVvdVORSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOBkgListByVvdVORSQL").append("\n"); 
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
		query.append("SELECT	T1.BKG_NO, (" ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM com_intg_cd_dtl S1" ).append("\n"); 
		query.append("WHERE S1.INTG_CD_ID = 'CD00769'" ).append("\n"); 
		query.append("AND S1.INTG_CD_VAL_CTNT = T1.BKG_STS_CD) AS BKG_STS" ).append("\n"); 
		query.append("FROM	BKG_BOOKING	T1, BKG_VVD	T2" ).append("\n"); 
		query.append("WHERE	T1.BKG_NO	= T2.BKG_NO" ).append("\n"); 
		query.append("AND	T1.BKG_STS_CD	!= 'X'" ).append("\n"); 
		query.append("AND	T2.VSL_CD	= @[vsl_cd]" ).append("\n"); 
		query.append("AND	T2.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	T2.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 

	}
}