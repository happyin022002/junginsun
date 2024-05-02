/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOsearchResultEDIListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.10.19 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOsearchResultEDIListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerMovementFinderDBDAO.java
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOsearchResultEDIListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vls_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOsearchResultEDIListRSQL").append("\n"); 
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
		query.append("#if (${flgrslt} == 'VL')" ).append("\n"); 
		query.append("#if (${viewtype} == '1')" ).append("\n"); 
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD, ORG_YD_CD, FULL_FG, MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE (B.BKG_CGO_TP_CD, 'P', 'M', 'F' ) FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MVMT_STS_CD, ORG_YD_CD" ).append("\n"); 
		query.append("ORDER BY CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DISTINCT EDI.CNTR_NO, MST.CNTR_TPSZ_CD, EDI.CNTR_FULL_STS_CD FULL_FG," ).append("\n"); 
		query.append("EDI.EDI_MVMT_STS_CD MVMT_STS_CD, EDI.EVNT_YD_CD ORG_YD_CD, 'EDI' BKG_NO," ).append("\n"); 
		query.append("TO_CHAR(EVNT_DT, 'YYYY-MM-DD HH24:MI') EVNT_DT, MVMT_EDI_MSG_AREA_CD AS SVR_ID" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG EDI, MST_CONTAINER MST" ).append("\n"); 
		query.append("WHERE 1 =1" ).append("\n"); 
		query.append("AND   EDI.CNTR_NO = MST.CNTR_NO" ).append("\n"); 
		query.append("AND EDI_GATE_IO_CD = 'AE'" ).append("\n"); 
		query.append("AND CRNT_VSL_CD || CRNT_SKD_VOY_NO || CRNT_SKD_DIR_CD = @[vls_cd]" ).append("\n"); 
		query.append("AND EVNT_YD_CD  LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("ORDER BY EDI.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'VD')" ).append("\n"); 
		query.append("#if (${viewtype} == '1')" ).append("\n"); 
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD, FULL_FG, ORG_YD_CD, MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE C.BKG_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV" ).append("\n"); 
		query.append("WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POD_CD = @[pol_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MVMT_STS_CD, ORG_YD_CD" ).append("\n"); 
		query.append("ORDER BY CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DISTINCT EDI.CNTR_NO, MST.CNTR_TPSZ_CD, EDI.CNTR_FULL_STS_CD FULL_FG," ).append("\n"); 
		query.append("EDI.EDI_MVMT_STS_CD MVMT_STS_CD, EDI.EVNT_YD_CD ORG_YD_CD, 'EDI' BKG_NO," ).append("\n"); 
		query.append("TO_CHAR(EVNT_DT, 'YYYY-MM-DD HH24:MI') EVNT_DT, MVMT_EDI_MSG_AREA_CD AS SVR_ID" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG EDI, MST_CONTAINER MST" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   EDI.CNTR_NO = MST.CNTR_NO" ).append("\n"); 
		query.append("AND EDI_GATE_IO_CD = 'UV'" ).append("\n"); 
		query.append("AND CRNT_VSL_CD || CRNT_SKD_VOY_NO || CRNT_SKD_DIR_CD = @[vls_cd]" ).append("\n"); 
		query.append("AND EVNT_YD_CD  LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("ORDER BY EDI.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}