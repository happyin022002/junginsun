/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.03 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 B/L의 Container List를 조회한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchCntrListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO, CNTR_SEAL_NO, CNTR_TPSZ_CD, ISO_CNTR_TPSZ_CD, CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("PCK_QTY, PCK_TP_CD, PCK_DESC, CNTR_MF_WGT, CNTR_WGT_UT_CD, T1_DOC_FLG T1_DOC_CD," ).append("\n"); 
		query.append("VSL_CALL_REF_NO, BKG_NO" ).append("\n"); 
		query.append("FROM	 BKG_CSTMS_RTM_CNTR" ).append("\n"); 
		query.append("WHERE	 VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("AND	 BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}