/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOUpdatePortPairRouteUSQL.java
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

public class PortPairRouteDBDAOUpdatePortPairRouteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Port Pair Route Modify처리한다.
	  * </pre>
	  */
	public PortPairRouteDBDAOUpdatePortPairRouteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOUpdatePortPairRouteUSQL").append("\n"); 
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
		query.append("-- PRD_OCN_ROUT.UPD_IND_CD 가 S,G 에서 다른 Code로 변한 경우," ).append("\n"); 
		query.append("-- SCE_PORT_PAIR_DTL.USE_FLG    = 'N' Update한다." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE   SCE_PORT_PAIR_DTL d" ).append("\n"); 
		query.append("SET  D.USE_FLG    = 'N'" ).append("\n"); 
		query.append(",D.UPD_USR_ID = 'Delete_BAT'" ).append("\n"); 
		query.append(",D.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and nvl(D.MNL_USE_FLG,'Y')  <> 'N'" ).append("\n"); 
		query.append("and D.USE_FLG <> 'N'" ).append("\n"); 
		query.append("AND D.UPD_IND_CD <> 'M'" ).append("\n"); 
		query.append("and (ROUT_RCV_DT,ROUT_SEQ  ) in    (" ).append("\n"); 
		query.append("--아래 With 문 : 결과적으로 S,G가 하나도 없는 Route가 조회됨." ).append("\n"); 
		query.append("--  SCE_PORT_PAIR_MST 와 PRD_OCN_ROUT 만을 가지고 Possible Route 생성" ).append("\n"); 
		query.append("--  minus" ).append("\n"); 
		query.append("--  PRD_OCN_ROUT.UPD_IND_CD IN ('S','G')인 Route" ).append("\n"); 
		query.append("WITH S AS (" ).append("\n"); 
		query.append("SELECT  M.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",M.POR_CD,M.POL_CD,M.POD_CD,M.DEL_CD" ).append("\n"); 
		query.append(",N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD" ).append("\n"); 
		query.append(",N2ND_POL_CD" ).append("\n"); 
		query.append(",N2ND_POD_CD" ).append("\n"); 
		query.append(",N3RD_POL_CD" ).append("\n"); 
		query.append(",N3RD_POD_CD" ).append("\n"); 
		query.append(",N4TH_POL_CD" ).append("\n"); 
		query.append(",N4TH_POD_CD" ).append("\n"); 
		query.append("FROM   SCE_EDI_PRNR P, SCE_PORT_PAIR_MST M, PRD_OCN_ROUT R" ).append("\n"); 
		query.append("WHERE  M.CUST_TRD_PRNR_ID = P.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("AND    M.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND    P.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    R.ORG_LOC_CD = M.POL_CD" ).append("\n"); 
		query.append("AND    R.DEST_LOC_CD = M.POD_CD" ).append("\n"); 
		query.append("GROUP  BY  M.CUST_TRD_PRNR_ID,M.POR_CD,M.POL_CD,M.POD_CD,M.DEL_CD,N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD,N2ND_POL_CD,N2ND_POD_CD,N3RD_POL_CD,N3RD_POD_CD,N4TH_POL_CD,N4TH_POD_CD" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("SELECT  M.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",M.POR_CD,M.POL_CD,M.POD_CD,M.DEL_CD" ).append("\n"); 
		query.append(",N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD" ).append("\n"); 
		query.append(",N2ND_POL_CD" ).append("\n"); 
		query.append(",N2ND_POD_CD" ).append("\n"); 
		query.append(",N3RD_POL_CD" ).append("\n"); 
		query.append(",N3RD_POD_CD" ).append("\n"); 
		query.append(",N4TH_POL_CD" ).append("\n"); 
		query.append(",N4TH_POD_CD" ).append("\n"); 
		query.append("FROM   SCE_EDI_PRNR P, SCE_PORT_PAIR_MST M, PRD_OCN_ROUT R" ).append("\n"); 
		query.append("WHERE  M.CUST_TRD_PRNR_ID = P.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("AND    M.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND    P.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    R.ORG_LOC_CD = M.POL_CD" ).append("\n"); 
		query.append("AND    R.DEST_LOC_CD = M.POD_CD" ).append("\n"); 
		query.append("AND    R.UPD_IND_CD IN ('S','G')" ).append("\n"); 
		query.append("GROUP  BY  M.CUST_TRD_PRNR_ID,M.POR_CD,M.POL_CD,M.POD_CD,M.DEL_CD,N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD,N2ND_POL_CD,N2ND_POD_CD,N3RD_POL_CD,N3RD_POD_CD,N4TH_POL_CD,N4TH_POD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT d.ROUT_RCV_DT, d.ROUT_SEQ" ).append("\n"); 
		query.append("FROM S, SCE_PORT_PAIR_DTL D" ).append("\n"); 
		query.append("WHERE D.CUST_TRD_PRNR_ID = S.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("AND   D.POR_CD = S.POR_CD" ).append("\n"); 
		query.append("AND   D.DEL_CD = S.DEL_CD" ).append("\n"); 
		query.append("AND   D.N1ST_POL_CD = S.N1ST_POL_CD" ).append("\n"); 
		query.append("AND   D.N1ST_POD_CD = S.N1ST_POD_CD" ).append("\n"); 
		query.append("AND   NVL(D.N2ND_POL_CD,'X') = NVL(S.N2ND_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N2ND_POD_CD,'X') = NVL(S.N2ND_POD_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N3RD_POL_CD,'X') = NVL(S.N3RD_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N3RD_POD_CD,'X') = NVL(S.N3RD_POD_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N4TH_POL_CD,'X') = NVL(S.N4TH_POL_CD,'X')" ).append("\n"); 
		query.append("AND   NVL(D.N4TH_POD_CD,'X') = NVL(S.N4TH_POD_CD,'X')" ).append("\n"); 
		query.append("AND   D.USE_FLG <> 'N'" ).append("\n"); 
		query.append("AND   D.MNL_USE_FLG IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}