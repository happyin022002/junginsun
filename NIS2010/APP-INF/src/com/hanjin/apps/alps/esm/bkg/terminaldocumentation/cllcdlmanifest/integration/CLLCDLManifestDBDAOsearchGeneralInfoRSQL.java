/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchGeneralInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.23 
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

public class CLLCDLManifestDBDAOsearchGeneralInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchGeneralInfo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchGeneralInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flat_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchGeneralInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'{10' ||CHR(10)||" ).append("\n"); 
		query.append("	'6OB'||CHR(10)||" ).append("\n"); 
		query.append("	@[flat_file_ref_no]||CHR(10)||" ).append("\n"); 
		query.append("	'9'||CHR(10)||" ).append("\n"); 
		query.append("	'AB'||CHR(10)||" ).append("\n"); 
		query.append("	'}10'||CHR(10)||" ).append("\n"); 
		query.append("	'{11'||CHR(10)||" ).append("\n"); 
		query.append("	'20'||CHR(10)||" ).append("\n"); 
		query.append("	 SUBSTR(TRIM(VSL.ATTR_CTNT2),5,LENGTH(TRIM(VSL.ATTR_CTNT2))-4)||CHR(10)||" ).append("\n"); 
		query.append("	'SML'||CHR(10)||" ).append("\n"); 
		query.append("	'172'||CHR(10)||" ).append("\n"); 
		query.append("	'20'||CHR(10)||" ).append("\n"); 
		query.append("	SUBSTR(VSL.ATTR_CTNT2, 1, 4)||SUBSTR(NVL(VSL.ATTR_CTNT3, ' '),1,13)||CHR(10)||" ).append("\n"); 
		query.append("	'{20'||CHR(10)||" ).append("\n"); 
		query.append("	'9'||CHR(10)||" ).append("\n"); 
		query.append("	NVL(POL.UN_LOC_CD, NVL(POL.LOC_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("	NVL(POL.LOC_NM,  ' ')||CHR(10)||" ).append("\n"); 
		query.append("	'}20'||CHR(10)||" ).append("\n"); 
		query.append("	'}11'||CHR(10)||" ).append("\n"); 
		query.append("	'{12'||CHR(10)||" ).append("\n"); 
		query.append("	'MR'||CHR(10)||" ).append("\n"); 
		query.append("	@[in_rcv_id]||CHR(10)||" ).append("\n"); 
		query.append("	'}12'||CHR(10)||" ).append("\n"); 
		query.append("	'{12'||CHR(10)||" ).append("\n"); 
		query.append("	'MS'||CHR(10)||" ).append("\n"); 
		query.append("	'SMLMM010'||CHR(10)||" ).append("\n"); 
		query.append("	'}12'||CHR(10)||" ).append("\n"); 
		query.append("	'{12'||CHR(10)||" ).append("\n"); 
		query.append("	'CA'||CHR(10)||" ).append("\n"); 
		query.append("	'SML'||CHR(10)||" ).append("\n"); 
		query.append("	'}12'||CHR(10) GENERAL_INFO" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("	MDM_LOCATION POL," ).append("\n"); 
		query.append("	BKG_CSTMS_CD_CONV_CTNT VSL" ).append("\n"); 
		query.append("WHERE CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND VSL.ATTR_CTNT1 = CLL.VSL_CD" ).append("\n"); 
		query.append("AND VSL.CNT_CD = 'KR' " ).append("\n"); 
		query.append("AND VSL.CSTMS_DIV_ID = 'KTML_CD' " ).append("\n"); 
		query.append("AND VSL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CLL.BKG_POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("AND NVL(CLL.POL_YD_CD,' ') LIKE @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}