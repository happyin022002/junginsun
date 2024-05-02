/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCargoVolByTDRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.11 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCargoVolByTDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCargoVolByTDRRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCargoVolByTDRRSQL").append("\n"); 
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
		query.append("SELECT	NVL(ROUND(( TP_20 / TTL_CALL_CNT )), 0) AS TP_20_QTY" ).append("\n"); 
		query.append("		, NVL(ROUND(( TP_40 / TTL_CALL_CNT )), 0) AS TP_40_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT	" ).append("\n"); 
		query.append("					COUNT(DISTINCT T1.VSL_CD||T1.VOY_NO||T1.DIR_CD||T1.PORT_CD||T1.CALL_IND) AS TTL_CALL_CNT" ).append("\n"); 
		query.append("					, SUM(DECODE(CNTR_SIZE, '2', QTY, 0  )) AS TP_20" ).append("\n"); 
		query.append("					, SUM(DECODE(CNTR_SIZE, '2', 0  , QTY)) AS TP_40" ).append("\n"); 
		query.append("			FROM	TDR_SUMMARY	T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("			WHERE	T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("			AND		T1.VOY_NO		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND		T1.DIR_CD		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND		T1.PORT_CD		= T2.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND		T1.CALL_IND		= T2.CLPT_IND_SEQ		" ).append("\n"); 
		query.append("			AND		T2.SKD_DIR_CD	= @[skd_dir_cd]			/* INPUT DATA : SKIP PORT와 동일한 DIRECTION */" ).append("\n"); 
		query.append("			AND		T1.POD			= @[vps_port_cd]		/* INPUT DATA : SKIP PORT					 */" ).append("\n"); 
		query.append("			AND		T2.VPS_ETD_DT	BETWEEN SYSDATE - 365 AND SYSDATE + 0.99999" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}