/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllBkgVvd
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllBkgVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllBkgVvdRSQL").append("\n"); 
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
		query.append("SELECT	'{BKGVVD'||chr(10)||" ).append("\n"); 
		query.append("	'BVVD1:'||NVL(A.VSL_CD,' ')||NVL(A.SKD_VOY_NO,' ')||" ).append("\n"); 
		query.append("			  NVL(A.SKD_DIR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BVVD_LANE:'||NVL(A.SLAN_CD,' ')||CHR(10)||	" ).append("\n"); 
		query.append("	'VSL_CALLSIGN1:'||NVL(D.CALL_SGN_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_LLOYDCODE1:'||NVL(D.LLOYD_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_FULLNAME1:'||NVL(D.VSL_ENG_NM,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VVD_REF_NO1:'||NVL(decode(B.SHP_CALL_NO, NULL, C.SHP_CALL_NO, B.SHP_CALL_NO),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOL1:'||NVL(A.POL_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append(" 	'BLPOL_YDCD1:'||NVL(A.POL_YD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOL_YDNM1:'||(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.POL_YD_CD)||CHR(10)||" ).append("\n"); 
		query.append("	'POL_FULLNAME1:'||E.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOD1:'||NVL(A.POD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOD_YDCD1:'||NVL(A.POD_YD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOD_YDNM1:'||(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.POD_YD_CD)||CHR(10)||" ).append("\n"); 
		query.append("	'POD_FULLNAME1:'||F.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'POLETA1:'||NVL(TO_CHAR(B.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POLETD1:'||NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PODETA1:'||NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PODETD1:'||NVL(TO_CHAR(C.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'OP_CODE:'||CHR(10)||" ).append("\n"); 
		query.append("	'}BKGVVD'||CHR(10) BKG_VVD_INFO" ).append("\n"); 
		query.append("FROM	BKG_VVD A, VSK_VSL_PORT_SKD B, VSK_VSL_PORT_SKD C, MDM_VSL_CNTR D, MDM_LOCATION E, MDM_LOCATION F" ).append("\n"); 
		query.append("WHERE	A.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND	A.VSL_CD        = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD    = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	A.POL_CD       = B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND	NVL(A.POL_CLPT_IND_SEQ,'1') = B.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND	A.VSL_CD        = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	A.POD_CD       = C.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND	NVL(A.POD_CLPT_IND_SEQ,'1') = C.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND	A.VSL_CD        = D.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.POL_CD       = E.LOC_CD(+)" ).append("\n"); 
		query.append("AND	A.POD_CD       = F.LOC_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.VSL_PRE_PST_CD, A.VSL_SEQ" ).append("\n"); 

	}
}