/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.03 
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

public class CLLCDLManifestDBDAOsearchCntrExportVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Export F/F 생성을 위한 VVD정보 쿼리
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_hjs_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_term_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportVvdRSQL").append("\n"); 
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
		query.append("SELECT  NVL(A.VSL_CD,' ')||NVL(A.SKD_VOY_NO,' ')||NVL(A.SKD_DIR_CD,' ') AS VVD," ).append("\n"); 
		query.append("NVL(D.CALL_SGN_NO,' ') AS VSL_CALLSIGN," ).append("\n"); 
		query.append("NVL(D.LLOYD_NO,' ') AS VSL_LLOYDCODE," ).append("\n"); 
		query.append("NVL(D.VSL_ENG_NM,' ') AS VSL_FULLNAME," ).append("\n"); 
		query.append("NVL(T.PSA_TML_VSL_CD,' ') AS TERM_VSL_CD," ).append("\n"); 
		query.append("NVL(T.TML_SKD_VOY_NO,' ') AS TERM_VOY_CD," ).append("\n"); 
		query.append("NVL(T.CALL_SGN_NO,' ') AS TERM_CALLSIGN," ).append("\n"); 
		query.append("NVL(T.EUR_TML_CD,' ') AS TERM_BERTH_CD," ).append("\n"); 
		query.append("NVL(T.TML_VVD_RMK,' ') AS TERM_REMARK," ).append("\n"); 
		query.append("NVL(decode(@[form_term_pol],NULL,@[form_term_pol],@[form_term_pol]),'') AS PORT," ).append("\n"); 
		query.append("(SELECT LOC_NM FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = NVL(decode(@[form_term_pol],NULL,@[pod_loc],@[form_term_pol]),'') ) AS PORTNAME," ).append("\n"); 
		query.append("NVL(TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') AS ETA," ).append("\n"); 
		query.append("NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ') AS ETD," ).append("\n"); 
		query.append("DECODE(@[form_term_pol],null,'',NVL(C.VPS_PORT_CD,'')) AS NEXTPORT," ).append("\n"); 
		query.append("DECODE(@[form_term_pol],null,'',NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),'')) AS NEXTPORT_ETA," ).append("\n"); 
		query.append("DECODE(@[form_term_pol],null,NVL(B.VPS_PORT_CD,''),'') AS PREVPORT," ).append("\n"); 
		query.append("DECODE(@[form_term_pol],null,NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),''),'') AS PREVPORT_ETD," ).append("\n"); 
		query.append("'EXP' AS IO_IND," ).append("\n"); 
		query.append("@[comp_id] AS COMP_ID," ).append("\n"); 
		query.append("'' AS MRN" ).append("\n"); 
		query.append("FROM  	VSK_vsl_port_skd A," ).append("\n"); 
		query.append("VSK_vsl_port_skd B," ).append("\n"); 
		query.append("VSK_vsl_port_skd C," ).append("\n"); 
		query.append("MDM_VSL_CNTR D," ).append("\n"); 
		query.append("bkg_cstms_vvd_tml T" ).append("\n"); 
		query.append("WHERE 	A.vsl_cd				= SUBSTR(@[form_hjs_vvd],1,4) and" ).append("\n"); 
		query.append("A.skd_voy_no 			= SUBSTR(@[form_hjs_vvd],5,4) and" ).append("\n"); 
		query.append("A.skd_dir_cd    		= SUBSTR(@[form_hjs_vvd],9,1) and" ).append("\n"); 
		query.append("A.CLPT_IND_SEQ  		= '1' and" ).append("\n"); 
		query.append("A.VPS_PORT_CD    		= NVL(@[form_term_pol], @[pod_loc]) and" ).append("\n"); 
		query.append("(A.CLPT_SEQ - 1) 	= B.CLPT_SEQ(+) and" ).append("\n"); 
		query.append("A.vsl_cd        		= B.vsl_cd(+) and" ).append("\n"); 
		query.append("A.skd_voy_no 			= B.skd_voy_no(+) and" ).append("\n"); 
		query.append("A.skd_dir_cd    		= B.skd_dir_cd(+) and" ).append("\n"); 
		query.append("B.CLPT_IND_SEQ(+)  		= '1'  and" ).append("\n"); 
		query.append("(A.CLPT_SEQ + 1) 	= C.CLPT_SEQ(+) and" ).append("\n"); 
		query.append("A.vsl_cd        		= C.vsl_cd(+) and" ).append("\n"); 
		query.append("A.skd_voy_no 			= C.skd_voy_no(+) and" ).append("\n"); 
		query.append("A.skd_dir_cd    		= C.skd_dir_cd(+) and" ).append("\n"); 
		query.append("C.CLPT_IND_SEQ(+)  		= '1'   and" ).append("\n"); 
		query.append("A.vsl_cd        		= D.vsl_cd and" ).append("\n"); 
		query.append("T.VSL_CD				= A.vsl_cd and" ).append("\n"); 
		query.append("T.SKD_VOY_NO			= A.skd_voy_no and" ).append("\n"); 
		query.append("T.SKD_DIR_CD			= A.skd_dir_cd and" ).append("\n"); 
		query.append("T.PORT_CD				= @[form_term_pol]" ).append("\n"); 

	}
}