/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAODeletePortPairRouteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.07.14 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAODeletePortPairRouteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeletePortPairRoute
	  * </pre>
	  */
	public PortPairRouteDBDAODeletePortPairRouteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAODeletePortPairRouteUSQL").append("\n"); 
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
		query.append("--PRD_OCN_ROUT에는 없는 Route가 SCE_PORT_PAIR_DTL 에만 있는경우" ).append("\n"); 
		query.append("--예) User가 PRD_OCN_ROUT에는 없는 Route를 화면 입력 한 경우나 초기 Insert Data." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SCE_PORT_PAIR_DTL d" ).append("\n"); 
		query.append("SET USE_FLG = 'N'" ).append("\n"); 
		query.append(", UPD_USR_ID = 'Delete_Bat_NoExist'" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE (d.ROUT_RCV_DT, d.ROUT_SEQ 	) IN (" ).append("\n"); 
		query.append("SELECT d.ROUT_RCV_DT, d.ROUT_SEQ" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   D.USE_FLG <> 'N'" ).append("\n"); 
		query.append("AND   NVL(D.MNL_USE_FLG,'Y') <> 'N'" ).append("\n"); 
		query.append("AND   D.VSL_SLAN_CD IS NULL" ).append("\n"); 
		query.append("AND   D.CRE_USR_ID <> 'COS-ES-LANE'" ).append("\n"); 
		query.append("AND   D.UPD_IND_CD <> 'M'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT d.ROUT_RCV_DT, d.ROUT_SEQ" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_DTL D , PRD_OCN_ROUT S" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   D.ORG_LOC_CD = S.ORG_LOC_CD" ).append("\n"); 
		query.append("AND   D.DEST_LOC_CD = S.DEST_LOC_CD" ).append("\n"); 
		query.append("AND   S.UPD_IND_CD IN ('S','G')" ).append("\n"); 
		query.append("AND   D.N1ST_POL_CD = S.N1ST_POL_CD" ).append("\n"); 
		query.append("AND   D.N1ST_POD_CD = S.N1ST_POD_CD" ).append("\n"); 
		query.append("AND   NVL(D.N2ND_POL_CD,'X') = NVL(S.N2ND_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N2ND_POD_CD,'X') = NVL(S.N2ND_POD_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N3RD_POL_CD,'X') = NVL(S.N3RD_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N3RD_POD_CD,'X') = NVL(S.N3RD_POD_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N4TH_POL_CD,'X') = NVL(S.N4TH_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N4TH_POD_CD,'X') = NVL(S.N4TH_POD_CD,'X')" ).append("\n"); 
		query.append("AND   D.USE_FLG <> 'N'" ).append("\n"); 
		query.append("AND   NVL(D.MNL_USE_FLG,'Y') <> 'N'" ).append("\n"); 
		query.append("AND   D.VSL_SLAN_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY d.ROUT_RCV_DT, d.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}