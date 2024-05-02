/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SHATideInformationMgtDBDAOVskPortTideVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.01.18 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SHATideInformationMgtDBDAOVskPortTideVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SHATideInformationMgtDBDAOVskPortTideVORSQL(){
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
		params.put("tide_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tide_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration").append("\n"); 
		query.append("FileName : SHATideInformationMgtDBDAOVskPortTideVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("b.LOC_CD" ).append("\n"); 
		query.append(",	b.TIDE_YR" ).append("\n"); 
		query.append(",	b.TIDE_DY" ).append("\n"); 
		query.append(",	b.TIDE_MON" ).append("\n"); 
		query.append(",	a.N1ST_TIDE_FM_HRMNT" ).append("\n"); 
		query.append(",	a.N1ST_TIDE_TO_HRMNT" ).append("\n"); 
		query.append(",	a.N1ST_HIGH_TIDE_HGT" ).append("\n"); 
		query.append(",	a.N1ST_LOW_TIDE_HGT" ).append("\n"); 
		query.append(",	a.N2ND_FM_TIDE_HRMNT" ).append("\n"); 
		query.append(",	a.N2ND_TO_TIDE_HRMNT" ).append("\n"); 
		query.append(",	a.N2ND_HIGH_TIDE_HGT" ).append("\n"); 
		query.append(",	a.N2ND_LOW_TIDE_HGT" ).append("\n"); 
		query.append(",	a.CRE_USR_ID" ).append("\n"); 
		query.append(",	a.CRE_DT" ).append("\n"); 
		query.append(",	a.UPD_USR_ID" ).append("\n"); 
		query.append(",	a.UPD_DT" ).append("\n"); 
		query.append(",	LPAD(b.TIDE_DY, 2, '0') AS DISP_TIDE_DY" ).append("\n"); 
		query.append(",	b.TIDE_YR||'/'||LPAD(b.TIDE_MON, 2, '0') AS TIDE_YR_MON" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("LOC_CD" ).append("\n"); 
		query.append(",	TIDE_YR" ).append("\n"); 
		query.append(",	TIDE_MON" ).append("\n"); 
		query.append(",   TIDE_DY" ).append("\n"); 
		query.append(",	N1ST_TIDE_FM_HRMNT" ).append("\n"); 
		query.append(",	N1ST_TIDE_TO_HRMNT" ).append("\n"); 
		query.append(",	N1ST_HIGH_TIDE_HGT" ).append("\n"); 
		query.append(",	N1ST_LOW_TIDE_HGT" ).append("\n"); 
		query.append(",	N2ND_FM_TIDE_HRMNT" ).append("\n"); 
		query.append(",	N2ND_TO_TIDE_HRMNT" ).append("\n"); 
		query.append(",	N2ND_HIGH_TIDE_HGT" ).append("\n"); 
		query.append(",	N2ND_LOW_TIDE_HGT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT,'yyyy-mm-dd hh24:mi') AS CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'yyyy-mm-dd hh24:mi') AS UPD_DT" ).append("\n"); 
		query.append("FROM VSK_PORT_TIDE" ).append("\n"); 
		query.append("WHERE TIDE_YR = @[tide_yr]" ).append("\n"); 
		query.append("AND	TIDE_MON = @[tide_mon]" ).append("\n"); 
		query.append("AND	LOC_CD = @[loc_cd] ) a," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_CD" ).append("\n"); 
		query.append(",	TIDE_YR" ).append("\n"); 
		query.append(",	TIDE_MON" ).append("\n"); 
		query.append(",   TIDE_DY" ).append("\n"); 
		query.append("FROM ( SELECT @[loc_cd] LOC_CD, @[tide_yr] TIDE_YR, @[tide_mon] TIDE_MON,  TO_CHAR(LEVEL) TIDE_DY" ).append("\n"); 
		query.append("FROM   DUAL CONNECT BY LEVEL <= ( SELECT TO_CHAR(LAST_DAY(TO_DATE(@[tide_yr]||LPAD(@[tide_mon], 2, '0'),'YYYYMM')),'DD') FROM DUAL ) )" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append("WHERE a.TIDE_DY(+) = b.TIDE_DY" ).append("\n"); 
		query.append("ORDER BY to_number(b.TIDE_DY) ASC" ).append("\n"); 

	}
}