/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOModifyPortPairRouteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.30 이윤정
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

public class PortPairRouteDBDAOModifyPortPairRouteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Port Pair Route Modify처리한다.
	  * </pre>
	  */
	public PortPairRouteDBDAOModifyPortPairRouteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOModifyPortPairRouteUSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_PORT_PAIR_DTL D" ).append("\n"); 
		query.append("--단계1. SCE_PORT_PAIR_MST 와 PRD_OCN_ROUT 만을 가지고 Possible Route 생성" ).append("\n"); 
		query.append("USING ( SELECT M.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",M.POR_CD,M.POL_CD,M.POD_CD,M.DEL_CD" ).append("\n"); 
		query.append(",N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD" ).append("\n"); 
		query.append(",N2ND_POL_CD" ).append("\n"); 
		query.append(",N2ND_POD_CD" ).append("\n"); 
		query.append(",N3RD_POL_CD" ).append("\n"); 
		query.append(",N3RD_POD_CD" ).append("\n"); 
		query.append(",N4TH_POL_CD" ).append("\n"); 
		query.append(",N4TH_POD_CD" ).append("\n"); 
		query.append(",MIN(UPD_IND_CD) UPD_IND_CD" ).append("\n"); 
		query.append("FROM   SCE_EDI_PRNR P, SCE_PORT_PAIR_MST M, PRD_OCN_ROUT R" ).append("\n"); 
		query.append("WHERE  M.CUST_TRD_PRNR_ID = P.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("AND    M.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND    P.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    R.ORG_LOC_CD = M.POL_CD" ).append("\n"); 
		query.append("AND    R.DEST_LOC_CD = M.POD_CD" ).append("\n"); 
		query.append("AND    R.UPD_IND_CD IN ('S','G')" ).append("\n"); 
		query.append("GROUP  BY  M.CUST_TRD_PRNR_ID,M.POR_CD,M.POL_CD,M.POD_CD,M.DEL_CD,N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD,N2ND_POL_CD,N2ND_POD_CD,N3RD_POL_CD,N3RD_POD_CD,N4TH_POL_CD,N4TH_POD_CD) S" ).append("\n"); 
		query.append("--단계2. 생성된 Possible Route와  SCE_PORT_PAIR_DTL 조인" ).append("\n"); 
		query.append("ON (D.CUST_TRD_PRNR_ID = S.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("AND   D.POR_CD = S.POR_CD" ).append("\n"); 
		query.append("AND   D.DEL_CD = S.DEL_CD" ).append("\n"); 
		query.append("AND   D.N1ST_POL_CD = S.N1ST_POL_CD" ).append("\n"); 
		query.append("AND   D.N1ST_POD_CD = S.N1ST_POD_CD" ).append("\n"); 
		query.append("AND   NVL(D.N2ND_POL_CD,'X') = NVL(S.N2ND_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N2ND_POD_CD,'X') = NVL(S.N2ND_POD_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N3RD_POL_CD,'X') = NVL(S.N3RD_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N3RD_POD_CD,'X') = NVL(S.N3RD_POD_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N4TH_POL_CD,'X') = NVL(S.N4TH_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N4TH_POD_CD,'X') = NVL(S.N4TH_POL_CD,'X')" ).append("\n"); 
		query.append("AND   D.USE_FLG <> 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--단계3. UPD_IND_CD 변경 된 경우 flag Update. 현업이 NoUse 한 Route 는 제외(D.MNL_USE_FLG is NULL)." ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE" ).append("\n"); 
		query.append("SET D.UPD_IND_CD = S.UPD_IND_CD" ).append("\n"); 
		query.append(",D.UPD_USR_ID = 'IndUpd_BAT'" ).append("\n"); 
		query.append(",D.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE D.UPD_IND_CD  <> S.UPD_IND_CD" ).append("\n"); 
		query.append("AND   D.UPD_IND_CD  <> 'M'" ).append("\n"); 
		query.append("AND   D.MNL_USE_FLG is NULL" ).append("\n"); 
		query.append("--단계4. SCE_PORT_PAIR_DTL에 데이타 없는 Possible Route INSERT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN INSERT (  ROUT_RCV_DT" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD" ).append("\n"); 
		query.append(",N2ND_POL_CD" ).append("\n"); 
		query.append(",N2ND_POD_CD" ).append("\n"); 
		query.append(",N3RD_POL_CD" ).append("\n"); 
		query.append(",N3RD_POD_CD" ).append("\n"); 
		query.append(",N4TH_POL_CD" ).append("\n"); 
		query.append(",N4TH_POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",UPD_IND_CD" ).append("\n"); 
		query.append(",USE_FLG" ).append("\n"); 
		query.append(",MNL_USE_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",ORG_LOC_CD" ).append("\n"); 
		query.append(",DEST_LOC_CD" ).append("\n"); 
		query.append(") VALUES ( TO_CHAR(SYSDATE,'YYYYMMDD')         --ROUT_RCV_DT" ).append("\n"); 
		query.append(",SCE_PORT_PAIR_DTL_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",S.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",S.POR_CD" ).append("\n"); 
		query.append(",S.N1ST_POL_CD" ).append("\n"); 
		query.append(",S.N1ST_POD_CD" ).append("\n"); 
		query.append(",S.N2ND_POL_CD" ).append("\n"); 
		query.append(",S.N2ND_POD_CD" ).append("\n"); 
		query.append(",S.N3RD_POL_CD" ).append("\n"); 
		query.append(",S.N3RD_POD_CD" ).append("\n"); 
		query.append(",S.N4TH_POL_CD" ).append("\n"); 
		query.append(",S.N4TH_POD_CD" ).append("\n"); 
		query.append(",S.DEL_CD" ).append("\n"); 
		query.append(",S.UPD_IND_CD" ).append("\n"); 
		query.append(",'Y'                                 --USE_FLG" ).append("\n"); 
		query.append(",''                                  --MNL_USE_FLG" ).append("\n"); 
		query.append(",'PRD_BAT'                           --CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE                             --CRE_DT" ).append("\n"); 
		query.append(",'PRD_BAT'                           --UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE                             --UPD_DT" ).append("\n"); 
		query.append(",S.POL_CD                            --ORG_LOC_CD" ).append("\n"); 
		query.append(",S.POD_CD                            --DEST_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}