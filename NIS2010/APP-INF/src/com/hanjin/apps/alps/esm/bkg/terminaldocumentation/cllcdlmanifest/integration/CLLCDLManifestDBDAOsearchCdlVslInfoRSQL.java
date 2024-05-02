/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.27 
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

public class CLLCDLManifestDBDAOsearchCdlVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlVslInfo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_edi_msg_func",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_area_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlVslInfoRSQL").append("\n"); 
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
		query.append("SELECT	'BRAC:'||NVL(DECODE(@[in_edi_msg_func], 'ORIGINAL','O'," ).append("\n"); 
		query.append("'REPLACE', 'U'," ).append("\n"); 
		query.append("'CANCEL',  'C'," ).append("\n"); 
		query.append("'CHANGE',  'G'," ).append("\n"); 
		query.append("'ADDITION','A', 'O'),'O')||CHR(10)||" ).append("\n"); 
		query.append("'VVD:'||NVL(A.VSL_CD,' ')||NVL(A.SKD_VOY_NO,' ')||NVL(A.SKD_DIR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'VSL_CALLSIGN:'||NVL(D.CALL_SGN_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("'VSL_LLOYDCODE:'||NVL(D.LLOYD_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("'VSL_FULLNAME:'||NVL(D.VSL_ENG_NM,' ')||CHR(10)||" ).append("\n"); 
		query.append("'LANE_CD:'||NVL(A.SLAN_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'VVD_REF_NO:'||NVL(A.SHP_CALL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("'PORT:'||NVL(DECODE(@[in_pol_cd],NULL,@[in_pod_cd],@[in_pol_cd]),'')||CHR(10)||" ).append("\n"); 
		query.append("'PORTNAME:'||NVL(@[in_loc_nm],'')||CHR(10)||" ).append("\n"); 
		query.append("'ETA:'||NVL(TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("'ETD:'||NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("DECODE(@[in_pol_cd]," ).append("\n"); 
		query.append("NULL,'NEXTPORT:'||CHR(10)||" ).append("\n"); 
		query.append("'NEXTPORT_ETA:'||CHR(10)||" ).append("\n"); 
		query.append("'PREVPORT:'||NVL(B.VPS_PORT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'PREVPORT_ETD:'||NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)," ).append("\n"); 
		query.append("'NEXTPORT:'||NVL(C.VPS_PORT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'NEXTPORT_ETA:'||NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ')||CHR(10)||" ).append("\n"); 
		query.append("'PREVPORT:'||CHR(10)||" ).append("\n"); 
		query.append("'PREVPORT_ETD:'||CHR(10)" ).append("\n"); 
		query.append(")||" ).append("\n"); 
		query.append("'IO_IND:'||'CDL'||CHR(10)||" ).append("\n"); 
		query.append("'COMP_ID:'||@[in_area_id]||CHR(10)||" ).append("\n"); 
		query.append("'MRN:'||NVL(D.CRR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'MRN_NAME:'||NVL(E.CRR_NM,' ')||CHR(10)||" ).append("\n"); 
		query.append("'CRN_NO:'||F.VSL_CALL_REF_NO||CHR(10) PSEUDO_VVD" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD C," ).append("\n"); 
		query.append("MDM_VSL_CNTR D," ).append("\n"); 
		query.append("MDM_CARRIER E," ).append("\n"); 
		query.append("BKG_CSTMS_RTM_VSL F" ).append("\n"); 
		query.append("WHERE	A.VSL_CD			= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO			= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD			= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	A.CLPT_IND_SEQ			= '1'" ).append("\n"); 
		query.append("AND	A.VPS_PORT_CD			= NVL(@[in_pol_cd],@[in_pod_cd])" ).append("\n"); 
		query.append("AND	(A.CLPT_SEQ - 1)		= B.CLPT_SEQ(+)" ).append("\n"); 
		query.append("AND	A.VSL_CD				= B.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO			= B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD			= B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	B.CLPT_IND_SEQ(+)		= '1'" ).append("\n"); 
		query.append("AND	(A.CLPT_SEQ + 1)		= C.CLPT_SEQ(+)" ).append("\n"); 
		query.append("AND	A.VSL_CD				= C.VSL_CD(+)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO			= C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD			= C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	C.CLPT_IND_SEQ(+)		= '1'" ).append("\n"); 
		query.append("AND	A.VSL_CD				= D.VSL_CD" ).append("\n"); 
		query.append("AND	D.CRR_CD				= E.CRR_CD" ).append("\n"); 
		query.append("AND	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD	= F.VSL_CD(+)||F.SKD_VOY_NO(+)||F.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	F.VSL_CALL_REF_STS_CD(+)			= 'Y'" ).append("\n"); 

	}
}