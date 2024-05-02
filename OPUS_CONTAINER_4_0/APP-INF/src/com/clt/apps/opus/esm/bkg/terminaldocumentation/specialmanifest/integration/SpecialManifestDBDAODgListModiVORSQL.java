/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialManifestDBDAODgListModiVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier :
*@LastVersion : 1.0
* 2012.11.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgListModiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * DgListModiVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgListModiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n");
		query.append("FileName : SpecialManifestDBDAODgListModiVORSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("     ''D_TYPE 		  -- Declaration" ).append("\n");
		query.append("	,''VVD_CD" ).append("\n");
		query.append("	,''PORT_CD" ).append("\n");
		query.append("     " ).append("\n");
		query.append("    ,''VSL_CD         --Vessel Code" ).append("\n");
		query.append("    ,''VSL_ENG_NM     --Vessel Name" ).append("\n");
		query.append("    ,''VSL_CNT_CD     --Vessel Flag" ).append("\n");
		query.append("    ,''LLOYD_NO       --Lloyd code" ).append("\n");
		query.append("    ,''CALL_SGN_NO    --Call Sign" ).append("\n");
		query.append("    ,''ETA_D            --Arrival DATE" ).append("\n");
		query.append("    ,''ETA_T            --Arrival TIME" ).append("\n");
		query.append("    ,''ETD_D            --Departure DATE" ).append("\n");
		query.append("    ,''ETD_T            --Departure TIME" ).append("\n");
		query.append("    ,''BRTH_YD_CD		--Berth(Yard Code)" ).append("\n");
		query.append("    ,''YD_NM            --Yard Name" ).append("\n");
		query.append("     " ).append("\n");
		query.append("    ,''AUTO_SND_TP_CD   -- 자동 전송 여부" ).append("\n");
		query.append("    " ).append("\n");
		query.append("    ,''SVC_RQST_NO      -- SVC_RQST_NO" ).append("\n");
		query.append("    " ).append("\n");
		query.append("    ,''ACK_RSLT_ID      -- edi 전송 결과" ).append("\n");
		query.append("    " ).append("\n");
		query.append("    ,''SEQ" ).append("\n");
		query.append("    ,''MERGE_BKG_NO " ).append("\n");
		query.append("    ,''BKG_NO" ).append("\n");
		query.append("    ,''BL_NO" ).append("\n");
		query.append("    ,''POL_CD" ).append("\n");
		query.append("    ,''POD_CD" ).append("\n");
		query.append("    ,''CNTR_NO                            -- Container No" ).append("\n");
		query.append("	,''CNTR_CGO_SEQ" ).append("\n");
		query.append("    ,''CELL_PSN_NO                        -- Cell Position" ).append("\n");
		query.append("    ,''DCGO_SEQ" ).append("\n");
		query.append("    ,''DG_CNTR_SEQ" ).append("\n");
		query.append("    ,''IMDG_CLSS_CD                       -- Class" ).append("\n");
		query.append("    ,''IMDG_UN_NO" ).append("\n");
		query.append("    ,''IMDG_UN_NO_SEQ" ).append("\n");
		query.append("    ,''DG_SHORT_NM                        -- S.D/G" ).append("\n");
		query.append("    ,''FLSH_PNT_CDO_TEMP                  -- Flash Point" ).append("\n");
		query.append("    ,''AGENT                              -- Agent" ).append("\n");
		query.append("    ,''FWRD_ID                        	  -- Forwarder Code" ).append("\n");
		query.append("    ,''C_TYPE                             -- Carriage type" ).append("\n");
		query.append("    ,''FDR_SVC_RQST_NO                    -- FEEDER SSR" ).append("\n");
		query.append("	,''FDR_VVD_ID" ).append("\n");
		query.append("	,''FDR_VSL_NM" ).append("\n");
		query.append("	,''FDR_VSL_LLOYD_NO" ).append("\n");
		query.append("    ,''IMDG_PCK_GRP_CD                    -- Package Group" ).append("\n");
		query.append("    ,''OUT_IMDG_PCK_QTY1                  -- Outer Qty" ).append("\n");
		query.append("    ,''OUT_IMDG_PCK_CD1                   -- Outer Code" ).append("\n");
		query.append("    ,''EMS_NO                             -- EMS" ).append("\n");
		query.append("    ,''NET_WGT                            -- Net Weight" ).append("\n");
		query.append("    ,''GRS_WGT                            -- Gross Weight" ).append("\n");
		query.append("    ,''PACKAGES 						  -- Packages" ).append("\n");
		query.append("    ,''PRP_SHP_NM                         -- Substance" ).append("\n");
		query.append("    ,''HZD_DESC                           -- Hazardous Contents" ).append("\n");
		query.append("" ).append("\n");
		query.append("	,''CRE_USR_ID" ).append("\n");
		query.append("	,''UPD_USR_ID" ).append("\n");
		query.append("" ).append("\n");
		query.append("    ,''LOCAL_DB_YN                        -- Local DB or BKG DB" ).append("\n");
		query.append("" ).append("\n");
		query.append("	,''DCGO_MRN_POLUT_CD" ).append("\n");
		query.append("	,''IMDG_LMT_QTY_FLG" ).append("\n");
		query.append("" ).append("\n");
		query.append("	,''CNTR_TPSZ_CD" ).append("\n");
		query.append("	,''IN_PCK_DESC" ).append("\n");
		query.append(" 	,''OUT_PCK_DESC" ).append("\n");
		query.append("" ).append("\n");
		query.append("	,''CRR_DT							-- On Carriage Date" ).append("\n");
		query.append("" ).append("\n");
		query.append("	,''imdg_subs_rsk_lbl_cd1" ).append("\n");
		query.append("	,''imdg_subs_rsk_lbl_cd2" ).append("\n");
		query.append("	,''imdg_subs_rsk_lbl_cd3" ).append("\n");
		query.append("	,''imdg_subs_rsk_lbl_cd4" ).append("\n");
		query.append("" ).append("\n");
		query.append("    ,''net_explo_wgt" ).append("\n");
		query.append("    " ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}