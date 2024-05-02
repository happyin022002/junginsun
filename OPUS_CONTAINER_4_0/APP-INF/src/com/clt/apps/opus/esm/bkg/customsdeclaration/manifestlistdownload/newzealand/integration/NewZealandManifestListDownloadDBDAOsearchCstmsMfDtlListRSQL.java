/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandManifestListDownloadDBDAOsearchCstmsMfDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandManifestListDownloadDBDAOsearchCstmsMfDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandManifestListDownloadDBDAOsearchCstmsMfDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandManifestListDownloadDBDAOsearchCstmsMfDtlListRSQL").append("\n"); 
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
		query.append("SELECT VVD.VSL_CD," ).append("\n"); 
		query.append("       VVD.SKD_VOY_NO," ).append("\n"); 
		query.append("       VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("       BKG.BL_NO," ).append("\n"); 
		query.append("       BKG.BKG_NO," ).append("\n"); 
		query.append("       CNTR.CNTR_NO," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       BKG.POD_CD," ).append("\n"); 
		query.append("       BKG.DEL_CD," ).append("\n"); 
		query.append("       (SELECT VVD_PRE.POD_CD" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD_PRE" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = VVD_PRE.BKG_NO" ).append("\n"); 
		query.append("           AND VVD_PRE.POD_CD = VVD.POL_CD) AS PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("       (SELECT VVD_POST.POD_CD" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD_POST" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = VVD_POST.BKG_NO" ).append("\n"); 
		query.append("           AND VVD_POST.POL_CD = VVD.POD_CD) AS PST_RLY_PORT_CD," ).append("\n"); 
		query.append("       DOC.ACT_WGT," ).append("\n"); 
		query.append("       DOC.WGT_UT_CD," ).append("\n"); 
		query.append("       DOC.PCK_QTY," ).append("\n"); 
		query.append("       DOC.PCK_TP_CD," ).append("\n"); 
		query.append("       DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, 'N', 'Y'), 'Y') AS BDR_FLG," ).append("\n"); 
		query.append("       (SELECT MF.MK_DESC" ).append("\n"); 
		query.append("          FROM BKG_BL_MK_DESC MF" ).append("\n"); 
		query.append("         WHERE CNTR.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("           AND MF.MK_SEQ = '1') AS MF_DESC," ).append("\n"); 
		query.append("       SUBSTR(C_CUST.CUST_NM, 1, 100) AS N_NAME," ).append("\n"); 
		query.append("       VVD.POD_CD AS VVD_POD_CD," ).append("\n"); 
		query.append("       VVD.POL_CD AS VVD_POL_CD," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XPKBKG_CSTMS_NZL_SND_LOG) */" ).append("\n"); 
		query.append("               'Success'" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.NZL_SND_LOG_ID = 'NZL'" ).append("\n"); 
		query.append("           AND VVD.VSL_CD = SND.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SND.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.POD_CD = SND.POD_CD" ).append("\n"); 
		query.append("           AND DECODE(SND.MSG_RGST_ID, NULL, '%', SND.BL_NO) LIKE DECODE(SND.MSG_RGST_ID, NULL, '%', BKG.BKG_NO)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = SND.CNTR_NO" ).append("\n"); 
		query.append("           AND BKG.BL_NO = SND.BL_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS STATUS," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XPKBKG_CSTMS_NZL_SND_LOG) */" ).append("\n"); 
		query.append("          MRN_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.NZL_SND_LOG_ID = 'NZL'" ).append("\n"); 
		query.append("           AND VVD.VSL_CD = SND.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SND.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SND.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD.POD_CD = SND.POD_CD" ).append("\n"); 
		query.append("           AND DECODE(SND.MSG_RGST_ID, NULL, '%', SND.BL_NO) LIKE DECODE(SND.MSG_RGST_ID, NULL, '%', BKG.BKG_NO)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = SND.CNTR_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS MRN_NO," ).append("\n"); 
		query.append("       '' CNTR_MF_SEQ," ).append("\n"); 
		query.append("       '' KIND," ).append("\n"); 
		query.append("       '' VVD," ).append("\n"); 
		query.append("       '' SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("       BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BL_DOC DOC," ).append("\n"); 
		query.append("       BKG_VVD_BDR_LOG D," ).append("\n"); 
		query.append("       BKG_CUSTOMER C_CUST," ).append("\n"); 
		query.append("       BKG_CUSTOMER N_CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.POD_CD LIKE @[pod] || '%'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND D.VSL_CD(+) = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND D.SKD_VOY_NO(+) = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND D.SKD_DIR_CD(+) = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND D.POL_CLPT_IND_SEQ(+) = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND D.POD_CLPT_IND_SEQ(+) = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND D.POL_CD(+) = VVD.POL_CD" ).append("\n"); 
		query.append("   AND D.POD_CD(+) = VVD.POD_CD" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND C_CUST.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND C_CUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND N_CUST.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND N_CUST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY BKG.BKG_NO" ).append("\n"); 

	}
}