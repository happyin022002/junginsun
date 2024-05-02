/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoVvdMkFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoVvdMkFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoVvdMkFileRSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoVvdMkFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoVvdMkFileRSQL").append("\n"); 
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
		query.append("SELECT '{BKGVVD'                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'BVVD1:'          || NVL(A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'BCONSORT_VOY:'   || NVL(G.IB_CSSM_VOY_NO, ' ')                         || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_CALLSIGN1:'  || NVL(D.CALL_SGN_NO, ' ')                             || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_LLOYDCODE1:' || NVL(D.LLOYD_NO, ' ')                              || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_FULLNAME1:'  || NVL(D.VSL_ENG_NM, ' ')                                || CHR(10) ||" ).append("\n"); 
		query.append("       'BLPOL1:'         || NVL(A.POL_CD, ' ')                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_FULLNAME1:'  || E.LOC_NM                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'BLPOD1:'         || NVL(A.POD_CD, ' ')                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_FULLNAME1:'  || F.LOC_NM                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'POLETA1:'        || NVL(TO_CHAR(B.VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ')     || CHR(10) ||" ).append("\n"); 
		query.append("       'POLETA1_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(B.VPS_PORT_CD,B.VPS_ETA_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'POLATA1:'                                                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'POLATA1_GMT:'                                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'POLETD1:'        || NVL(TO_CHAR(B.VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ')     || CHR(10) ||" ).append("\n"); 
		query.append("       'POLETD1_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(B.VPS_PORT_CD,B.VPS_ETA_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'POLATD1:'                                                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'POLATD1_GMT:'                                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'PODETA1:'        || NVL(TO_CHAR(C.VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ')    || CHR(10) ||" ).append("\n"); 
		query.append("       'PODETA1_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(C.VPS_PORT_CD,C.VPS_ETA_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'PODATA1:'                                                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'PODATA1_GMT:'                                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'PODETD1:'        || NVL(TO_CHAR(C.VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ')     || CHR(10) ||" ).append("\n"); 
		query.append("       'PODETD1_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(C.VPS_PORT_CD,C.VPS_ETA_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'PODATD1:'        || CHR(10) ||" ).append("\n"); 
		query.append("       'PODATD1_GMT:'    || CHR(10) ||" ).append("\n"); 
		query.append("       '}BKGVVD' || CHR(10) AS flat_file_vvd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD          A," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD C," ).append("\n"); 
		query.append("       MDM_VSL_CNTR     D," ).append("\n"); 
		query.append("       MDM_LOCATION     E," ).append("\n"); 
		query.append("       MDM_LOCATION     F," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD G" ).append("\n"); 
		query.append(" WHERE A.BKG_NO          = @[bkg_no] /* 변수 치환 */" ).append("\n"); 
		query.append("   AND A.VSL_CD          = B.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO      = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD      = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.POL_CD          = B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND B.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("   AND A.VSL_CD          = C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO      = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD      = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD          = C.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND C.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("   AND A.VSL_CD          = D.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.POL_CD          = E.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD          = F.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.VSL_CD          = G.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO      = G.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD      = G.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD          = G.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND G.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 

	}
}