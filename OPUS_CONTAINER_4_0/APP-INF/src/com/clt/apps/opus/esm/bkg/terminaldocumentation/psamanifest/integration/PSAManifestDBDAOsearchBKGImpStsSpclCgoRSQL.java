/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL").append("\n"); 
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
		query.append("SELECT A.OVR_HGT AS OVR_DIM_HGT," ).append("\n"); 
		query.append("       A.OVR_FWRD_LEN AS OVR_FNT_DIM_LEN," ).append("\n"); 
		query.append("       A.OVR_BKWD_LEN AS OVR_BAK_DIM_LEN," ).append("\n"); 
		query.append("       A.OVR_LF_LEN AS OVR_LF_DIM_WDT," ).append("\n"); 
		query.append("       A.OVR_RT_LEN AS OVR_RT_DIM_WDT," ).append("\n"); 
		query.append("       A.TTL_DIM_HGT AS DIM_HGT," ).append("\n"); 
		query.append("       A.TTL_DIM_WDT AS DIM_WDT," ).append("\n"); 
		query.append("       A.TTL_DIM_LEN AS DIM_LEN," ).append("\n"); 
		query.append("       R.CDO_TEMP AS RF_FLG," ).append("\n"); 
		query.append("       CO.CMDT_NM AS CMDT_DESC," ).append("\n"); 
		query.append("       'I' AS TYPE_CD," ).append("\n"); 
		query.append("       CO.CMDT_NM AS CGO_DESC," ).append("\n"); 
		query.append("       C.CNTR_NO," ).append("\n"); 
		query.append("       C.BKG_NO," ).append("\n"); 
		query.append("       @[vsl_cd] AS VSL_CD," ).append("\n"); 
		query.append("       @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("       @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("       R.CBM_PER_HR_QTY," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(DG XAK1BKG_DG_CGO) */" ).append("\n"); 
		query.append("               IMDG_CLSS_CD" ).append("\n"); 
		query.append("          FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("         WHERE DG.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("           AND DG.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("           AND DG.IMDG_CLSS_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS IMDG_CLSS_CD," ).append("\n"); 
		query.append("       S.STWG_CD AS LD_INS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO A," ).append("\n"); 
		query.append("       BKG_RF_CGO R," ).append("\n"); 
		query.append("       BKG_CONTAINER C," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       MDM_COMMODITY CO," ).append("\n"); 
		query.append("       BKG_STWG_CGO S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND C.BKG_NO = A.BKG_NO (+)" ).append("\n"); 
		query.append("  AND C.CNTR_NO = A.CNTR_NO (+)" ).append("\n"); 
		query.append("  AND C.BKG_NO = R.BKG_NO (+)" ).append("\n"); 
		query.append("  AND C.CNTR_NO = R.CNTR_NO (+)" ).append("\n"); 
		query.append("  AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("  AND B.CMDT_CD = CO.CMDT_CD (+)" ).append("\n"); 
		query.append("  AND C.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("  AND S.STWG_SEQ(+) = 1" ).append("\n"); 

	}
}