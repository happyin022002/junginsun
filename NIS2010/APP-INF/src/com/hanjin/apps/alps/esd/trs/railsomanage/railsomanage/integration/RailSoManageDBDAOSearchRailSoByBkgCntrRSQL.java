/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOSearchRailSoByBkgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.12.07 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchRailSoByBkgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail O/B BKG#, CNTR#으로 SO 대상 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearchRailSoByBkgCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchRailSoByBkgCntrRSQL").append("\n"); 
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
		query.append("BK.BKG_NO BKG_NO ," ).append("\n"); 
		query.append("A.CNTR_NO BKG_CNTR_NO," ).append("\n"); 
		query.append("B.CNTR_NO COP_CNTR_NO," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("MAX( C.TRSP_SO_OFC_CTY_CD||C.TRSP_SO_SEQ) SO_NO," ).append("\n"); 
		query.append("MAX(C.FM_NOD_CD) RAIL_ORG," ).append("\n"); 
		query.append("MAX(C.TO_NOD_CD) RAIL_DEST," ).append("\n"); 
		query.append("MAX( TO_CHAR(C.WO_ISS_DT,'RRRRMMDD HH24:MI:SS'))  EDI_SENT_TIME," ).append("\n"); 
		query.append("MAX( DECODE(D.SUB_RAIL_SEQ, 1, V.USA_EDI_CD)||DECODE(D.SUB_RAIL_SEQ, 2, ' / '" ).append("\n"); 
		query.append("||V.USA_EDI_CD)||DECODE(D.SUB_RAIL_SEQ, 3, ' / '||V.USA_EDI_CD)  ) RAIL_ROAD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING BK," ).append("\n"); 
		query.append("BKG_CONTAINER A," ).append("\n"); 
		query.append("SCE_COP_HDR B," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD C," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_VNDR_SET D," ).append("\n"); 
		query.append("MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND   A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   B.COP_NO = C.COP_NO" ).append("\n"); 
		query.append("AND   C.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   C.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   D.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("AND   NVL(C.DELT_FLG, 'N') <>'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkgNo.size() > 0)" ).append("\n"); 
		query.append("AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${bkgNo})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("$key" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($cntrNo.size() > 0)" ).append("\n"); 
		query.append("AND B.COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntrNo})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("$key" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("BK.BKG_NO, A.CNTR_NO, B.COP_NO, B.CNTR_NO,	B.CNTR_TPSZ_CD" ).append("\n"); 

	}
}