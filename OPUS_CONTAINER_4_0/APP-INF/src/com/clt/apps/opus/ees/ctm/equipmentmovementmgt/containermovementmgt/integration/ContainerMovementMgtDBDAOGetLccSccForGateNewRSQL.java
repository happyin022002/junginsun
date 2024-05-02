/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetLccSccForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.26 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetLccSccForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetLccSccForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetLccSccForGateNewRSQL").append("\n"); 
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
		query.append("SELECT G1.SCC_CD AS DEL_SCC," ).append("\n"); 
		query.append("G1.LCC_CD AS DEL_LCC," ).append("\n"); 
		query.append("G2.SCC_CD AS EVENT_SCC," ).append("\n"); 
		query.append("G2.LCC_CD AS EVENT_LCC" ).append("\n"); 
		query.append("FROM DOM_BOOKING DB, MDM_LOCATION L1, MDM_EQ_ORZ_CHT G1," ).append("\n"); 
		query.append("MDM_LOCATION L2, MDM_EQ_ORZ_CHT G2" ).append("\n"); 
		query.append("WHERE DB.DMST_BKG_NO = @[dmst_bkg_no]" ).append("\n"); 
		query.append("AND L1.LOC_CD = DB.DEST_RAIL_LOC_CD" ).append("\n"); 
		query.append("AND L1.SCC_CD = G1.SCC_CD" ).append("\n"); 
		query.append("AND L2.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND L2.SCC_CD = G2.SCC_CD" ).append("\n"); 

	}
}