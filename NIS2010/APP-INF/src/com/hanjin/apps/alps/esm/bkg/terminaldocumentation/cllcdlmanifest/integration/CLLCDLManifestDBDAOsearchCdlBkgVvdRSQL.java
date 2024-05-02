/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.22 
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

public class CLLCDLManifestDBDAOsearchCdlBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlBkgVvd
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlBkgVvdRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlBkgVvdRSQL").append("\n"); 
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
		query.append("			NVL(A.SKD_DIR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BVVD_LANE:'||NVL(A.SLAN_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_CALLSIGN1:'||NVL(D.CALL_SGN_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_LLOYDCODE1:'||NVL(D.LLOYD_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_FULLNAME1:'||NVL(D.VSL_ENG_NM,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VVD_REF_NO1:'||NVL(decode(G.CVY_REF_NO, NULL, H.CVY_REF_NO, G.CVY_REF_NO),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOL1:'||NVL(A.POL_CD,' ')||chr(10)||" ).append("\n"); 
		query.append("	'POL_FULLNAME1:'||E.LOC_NM||chr(10)||" ).append("\n"); 
		query.append("	'BLPOD1:'||NVL(A.POD_CD,' ')||chr(10)||" ).append("\n"); 
		query.append("	'POD_FULLNAME1:'||F.LOC_NM||chr(10)||" ).append("\n"); 
		query.append("	'POLETA1:'||NVL(TO_CHAR(b.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POLETD1:'||NVL(TO_CHAR(b.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PODETA1:'||NVL(TO_CHAR(c.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PODETD1:'||NVL(TO_CHAR(c.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'OP_CODE:'||CHR(10)||" ).append("\n"); 
		query.append("	'}BKGVVD'||CHR(10) BKG_VVD_INFO" ).append("\n"); 
		query.append("FROM	BKG_VVD A, VSK_VSL_PORT_SKD B, VSK_VSL_PORT_SKD C, MDM_VSL_CNTR D, MDM_LOCATION E, MDM_LOCATION F, BKG_VSL_DCHG_YD G, BKG_VSL_DCHG_YD H" ).append("\n"); 
		query.append("WHERE	A.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("AND	A.VSL_CD		= B.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO	= B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD	= B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	A.POL_CD		= B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND	B.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("AND	A.VSL_CD		= C.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO	= C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD	= C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	A.POD_CD		= C.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND	C.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("AND	A.VSL_CD		= D.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.POL_CD		= E.LOC_CD(+)" ).append("\n"); 
		query.append("AND	A.POD_CD		= F.LOC_CD(+)" ).append("\n"); 
		query.append("AND	A.VSL_CD		= G.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO	= G.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD	= G.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	A.POL_CD		= G.PORT_CD(+)" ).append("\n"); 
		query.append("AND	G.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("AND	A.VSL_CD		= H.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO	= H.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD	= H.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	A.POD_CD		= H.PORT_CD(+)" ).append("\n"); 
		query.append("AND	H.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("ORDER BY A.VSL_PRE_PST_CD" ).append("\n"); 

	}
}