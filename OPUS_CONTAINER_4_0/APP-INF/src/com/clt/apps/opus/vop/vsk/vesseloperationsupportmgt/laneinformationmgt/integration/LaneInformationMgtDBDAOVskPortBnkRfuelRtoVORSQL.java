/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LaneInformationMgtDBDAOVskPortBnkRfuelRtoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOVskPortBnkRfuelRtoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Bunkering Ports Search
	  * </pre>
	  */
	public LaneInformationMgtDBDAOVskPortBnkRfuelRtoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOVskPortBnkRfuelRtoVORSQL").append("\n"); 
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
		query.append("SELECT 'Lane' as VSL_SLAN_NM " ).append("\n"); 
		query.append("		, A.VSL_SLAN_CD" ).append("\n"); 
		query.append("#foreach($key IN ${loc_cd}) " ).append("\n"); 
		query.append("	#if($velocityCount < 10)" ).append("\n"); 
		query.append("		, SUM(CASE WHEN	LOC_CD	= '$key' THEN BNK_RFUEL_RTO ELSE null END) AS RFUEL_RTO_0$velocityCount" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		, SUM(CASE WHEN	LOC_CD	= '$key' THEN BNK_RFUEL_RTO ELSE null END) AS RFUEL_RTO_$velocityCount" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("		, SUM(NVL(BNK_RFUEL_RTO, 0)) AS RFUEL_RTO_TOT" ).append("\n"); 
		query.append("FROM 	VSK_PORT_BNK_RFUEL_RTO	A," ).append("\n"); 
		query.append("		MDM_VSL_SVC_LANE		B" ).append("\n"); 
		query.append("WHERE	A.VSL_SLAN_CD		=	B.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND		A.VSL_SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.VSL_SLAN_CD" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD" ).append("\n"); 

	}
}