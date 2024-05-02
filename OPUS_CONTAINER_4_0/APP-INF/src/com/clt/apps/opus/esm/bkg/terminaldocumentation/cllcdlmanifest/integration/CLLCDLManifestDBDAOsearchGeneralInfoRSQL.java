/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchGeneralInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flat_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_edi_msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	'{HEADER' ||CHR(10)||" ).append("\n"); 
		query.append("	'CLL_QUAL:'||'6OB'||CHR(10)||" ).append("\n"); 
		query.append("	'REF_NUM:'||@[flat_file_ref_no]||CHR(10)||" ).append("\n"); 
		query.append("	'FUNC_CD:'||DECODE(@[in_edi_msg_tp],'ORIGINAL',9,'REPLACE',5,'CANCEL',1,'CHANGE',4,'ADDITION',2)||CHR(10)|| " ).append("\n"); 
		query.append("	'RESP_CD:'||'AB'||CHR(10)||" ).append("\n"); 
		query.append("	'}HEADER'||CHR(10)||" ).append("\n"); 
		query.append("	'{VVD_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'TRANS_QUAL:'||'20'||CHR(10)||" ).append("\n"); 
		query.append("	'TMNL_VSL:'||VSL.ATTR_CTNT2||CHR(10)||" ).append("\n"); 
		query.append("	'SVC_VVD:'||SUBSTR(VSL.ATTR_CTNT2,-3)||SUBSTR((SELECT OB_CSSM_VOY_NO FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("											WHERE VSL_CD = @[in_vsl_cd] AND SKD_VOY_NO = @[in_skd_voy_no] AND SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("											AND VPS_PORT_CD = @[in_pol_cd] AND CLPT_IND_SEQ = 1),-4)||CHR(10)||" ).append("\n"); 
		query.append("	'CARRIER_CD:'||'NYK'||CHR(10)||" ).append("\n"); 
		query.append("	'CD_QUAL:'||'172'||CHR(10)||" ).append("\n"); 
		query.append("	'CD_RESP:'||'20'||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_NM:'||SUBSTR(VSL.ATTR_CTNT2,1,4)||SUBSTR((SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = @[in_vsl_cd]),1,13)||CHR(10)||" ).append("\n"); 
		query.append("	'{POL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'POL_QUAL:'||'9'||CHR(10)||" ).append("\n"); 
		query.append("	'TMNL_CD:'||NVL(POL.UN_LOC_CD, NVL(POL.LOC_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("	'TMNL_NM:'||(SELECT ATTR_CTNT3 FROM BKG_CSTMS_CD_CONV_CTNT WHERE CNT_CD = 'KR' AND CSTMS_DIV_ID = 'KR_CLL_EDI_SND_LIST' AND ATTR_CTNT1 = @[in_rcv_id])||CHR(10)||" ).append("\n"); 
		query.append("	'}POL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'}VVD_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{PARTY_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'PARTY_QUAL:'||'MR'||CHR(10)||" ).append("\n"); 
		query.append("	'PARTY_NM:'||@[in_rcv_id]||CHR(10)||" ).append("\n"); 
		query.append("	'}PARTY_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{PARTY_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'PARTY_QUAL:'||'MS'||CHR(10)||" ).append("\n"); 
		query.append("	'PARTY_NM:'||'NYKLE010'||CHR(10)||" ).append("\n"); 
		query.append("	'}PARTY_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{PARTY_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'PARTY_QUAL:'||'CA'||CHR(10)||" ).append("\n"); 
		query.append("	'PARTY_NM:'||'NYK'||CHR(10)||" ).append("\n"); 
		query.append("	'}PARTY_INFO'||CHR(10) GENERAL_INFO" ).append("\n"); 
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