/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsmanifestListDownloadDBDAOaddCntrForYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsmanifestListDownloadDBDAOaddCntrForYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 B/L Container Info를 생성한다. (B/L Creation Indicator = 'Y')
	  * </pre>
	  */
	public RocsmanifestListDownloadDBDAOaddCntrForYRSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vcr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsmanifestListDownloadDBDAOaddCntrForYRSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_RTM_CNTR" ).append("\n"); 
		query.append("         (VSL_CALL_REF_NO, 	BKG_NO," ).append("\n"); 
		query.append("			 CNTR_NO, 	CNTR_TPSZ_CD, 	ISO_CNTR_TPSZ_CD, 	CNTR_TPSZ_DESC, " ).append("\n"); 
		query.append("             CNTR_SEAL_NO," ).append("\n"); 
		query.append("			 PCK_TP_CD, PCK_QTY, PCK_DESC," ).append("\n"); 
		query.append("			 CNTR_WGT_UT_CD, CNTR_MF_WGT, CMDT_MEAS_UT_CD, 	CNTR_MF_MEAS_QTY," ).append("\n"); 
		query.append("			 CRE_USR_ID, CRE_OFC_CD, UPD_DT, 	CRE_DT,		T1_DOC_FLG)" ).append("\n"); 
		query.append("          SELECT @[vcr_no],     CNTR.BKG_NO," ).append("\n"); 
		query.append("             CNTR.CNTR_NO, CNTR.CNTR_TPSZ_CD, ISO.ISO_CNTR_TPSZ_CD, CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("			(  SELECT NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("			   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("			   WHERE BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("			   AND CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("			   ) CNTR_SEAL_NO," ).append("\n"); 
		query.append("			CNTR.CNTR_TPSZ_CD,	PCK_QTY, PKG.PCK_NM," ).append("\n"); 
		query.append("			WGT_UT_CD,CNTR_WGT, MEAS_UT_CD,	MEAS_QTY," ).append("\n"); 
		query.append("			@[user_id],@[ofc_cd],sysdate,sysdate,DOC_CMPL_FLG" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER CNTR, MST_ISO_CNTR_TP_SZ ISO," ).append("\n"); 
		query.append("			   MDM_CNTR_TP_SZ TPSZ, MDM_PCK_TP PKG," ).append("\n"); 
		query.append("			   BKG_CSTMS_RTM_TRO TRO" ).append("\n"); 
		query.append("        WHERE CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND CNTR.CNTR_TPSZ_CD = ISO.ISO_CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        AND CNTR.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        AND CNTR.PCK_TP_CD = PKG.PCK_CD(+)" ).append("\n"); 
		query.append("        AND CNTR.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("        AND TRO.IO_BND_CD(+) = 'I'" ).append("\n"); 
		query.append("        AND CNTR.CNTR_NO = TRO.CNTR_NO(+)" ).append("\n"); 

	}
}