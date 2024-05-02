/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchCntrDgListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchCntrDgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCntrDgList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchCntrDgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchCntrDgListRSQL").append("\n");
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
		query.append("SELECT	BB.BL_NO					AS BL_NO," ).append("\n");
		query.append("    	DC.DCGO_SEQ					AS DCGO_SEQ," ).append("\n");
		query.append("    	DC.IMDG_UN_NO				AS IMDG_UN_NO," ).append("\n");
		query.append("    	NVL(DC.IMDG_CLSS_CD, ' ')	AS IMDG_CLSS_CD," ).append("\n");
		query.append("    	NVL(DC.CNTR_NO, ' ')		AS CNTR_NO," ).append("\n");
		query.append("    	--NVL(DC.IMDG_PG_NO, ' ')		AS IMDG_PG_NO," ).append("\n");
		query.append("    	NVL(DC.IMDG_SUBS_RSK_LBL_CD1, ' ') AS IMDG_SUBS_RSK_LBL_CD," ).append("\n");
		query.append("    	NVL(TRIM(DC.EMER_CNTC_PHN_NO_CTNT),' ') AS CNTC_PSON_TELCM_NO," ).append("\n");
		query.append("    	NVL(TRIM(DC.EMER_CNTC_PSON_NM),' ') AS CNTC_PSON_NM," ).append("\n");
		query.append("		FLSH_PNT_CDO_TEMP," ).append("\n");
		query.append("		EMS_NO," ).append("\n");
		query.append("    	@[trans_mode]				AS CHN_MF_SND_IND_CD," ).append("\n");
		query.append("		@[usr_id]					AS CRE_USR_ID," ).append("\n");
		query.append("		@[usr_id]					AS UPD_USR_ID" ).append("\n");
		query.append("FROM	BKG_DG_CGO DC," ).append("\n");
		query.append("        BKG_BOOKING BB" ).append("\n");
		query.append("WHERE   1=1" ).append("\n");
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n");
		query.append("      	#if($velocityCount > 1)" ).append("\n");
		query.append("      	OR #end      BB.BKG_NO IN ( $field_id )" ).append("\n");
		query.append("      #end" ).append("\n");
		query.append(")" ).append("\n");
		query.append("#if (${bkg_cgo_tp_cd} != '') " ).append("\n");
		query.append("AND     DECODE(BB.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND	    BB.BKG_NO = DC.BKG_NO" ).append("\n");

	}
}