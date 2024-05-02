/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusDgManifestListDownloadDBDAOsearchDgInfoinquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusDgManifestListDownloadDBDAOsearchDgInfoinquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주위험물 화면에서 DG 팝업 띄울때 DG정보를 조회해온다
	  * </pre>
	  */
	public AusDgManifestListDownloadDBDAOsearchDgInfoinquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration.temp").append("\n"); 
		query.append("FileName : AusDgManifestListDownloadDBDAOsearchDgInfoinquiryRSQL").append("\n"); 
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
		query.append("        A.DG_DECL_TP_CD" ).append("\n"); 
		query.append("        ,A.VSL_CD" ).append("\n"); 
		query.append("        ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.PORT_CD" ).append("\n"); 
		query.append("        ,A.BL_NO    " ).append("\n"); 
		query.append("		,BB.BKG_NO" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD         -- ������������������������� ������������ �����������������" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("            FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("            WHERE CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ) CNTR_TPSZ_ISO_CD      -- ISO �����" ).append("\n"); 
		query.append("        ,A.DCGO_MRN_POLUT_CD DCGO_MRN_POLUT_CD    -- Marine Pollutant  " ).append("\n"); 
		query.append("        ,A.IMDG_CLSS_CD         -- Class" ).append("\n"); 
		query.append("        ,A.IMDG_SUBS_RSK_LBL_CD1 -- Sub label 1" ).append("\n"); 
		query.append("        ,A.IMDG_SUBS_RSK_LBL_CD2 -- Sub label 2" ).append("\n"); 
		query.append("        ,A.IMDG_SUBS_RSK_LBL_CD3 -- Sub label 3" ).append("\n"); 
		query.append("        ,A.IMDG_SUBS_RSK_LBL_CD4 -- Sub label 4" ).append("\n"); 
		query.append("        ,A.IMDG_LMT_QTY_FLG     -- Limited quantity" ).append("\n"); 
		query.append("        ,A.EMER_RSPN_GID_NO     -- Page           " ).append("\n"); 
		query.append("        ,A.HCDG_FLG             -- High Consequence dangerous goods" ).append("\n"); 
		query.append("        ,A.IMDG_UN_NO           -- UN No. " ).append("\n"); 
		query.append("        ,A.IMDG_UN_NO_SEQ       -- UN No SEQ. " ).append("\n"); 
		query.append("        ,SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("        ,A.IN_IMDG_PCK_QTY1     -- Inner Package Qty" ).append("\n"); 
		query.append("        ,A.IN_IMDG_PCK_CD1      -- Inner Package Code" ).append("\n"); 
		query.append("        ,A.FLSH_PNT_CDO_TEMP    -- Flash Point" ).append("\n"); 
		query.append("        ,A.INR_PCK_DESC     -- Inner Package Description" ).append("\n"); 
		query.append("        ,A.IMDG_PCK_GRP_CD      -- Package Group" ).append("\n"); 
		query.append("        ,A.OUT_IMDG_PCK_QTY1     " ).append("\n"); 
		query.append("        ,A.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("        ,A.EMS_NO               -- EMS No." ).append("\n"); 
		query.append("        ,A.OUTR_PCK_DESC    -- Outer Package Description" ).append("\n"); 
		query.append("        ,A.NET_WGT              -- Net Weight       " ).append("\n"); 
		query.append("        ,A.MFAG_NO              -- MFAG" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,A.CELL_PSN_NO          -- CELL_PSN_NO" ).append("\n"); 
		query.append("        ,A.GRS_WGT              -- GRS_WGT" ).append("\n"); 
		query.append("        ,A.PCK_DESC         -- Packages" ).append("\n"); 
		query.append("        ,A.PRP_SHP_NM           -- Substance" ).append("\n"); 
		query.append("        ,A.HZD_DESC             -- Hazardous Contents" ).append("\n"); 
		query.append("        ,A.BRTH_YD_CD           -- Berth Code" ).append("\n"); 
		query.append("        ,A.BRTH_YD_NM           -- Berth Name" ).append("\n"); 
		query.append("        ,A.ANR_FWRD_ID          -- Forwarder Code" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRR_DT, 'YYYY-MM-DD') CRR_DT -- On-Carriage Date" ).append("\n"); 
		query.append("        ,A.XTD_STAY_PRMT_NO     -- Extended Stay Permit" ).append("\n"); 
		query.append("        ,A.DIFF_RMK             -- Additional Remark(s)" ).append("\n"); 
		query.append("        ,A.ANR_SPCL_TP_ID       -- Belgian Codes for Type of special UN numbers" ).append("\n"); 
		query.append("        ,A.ANR_CRR_TP_CD        -- Carriage Type" ).append("\n"); 
		query.append("        ,A.FDR_SVC_RQST_NO      -- SSR for Feeder transshipment" ).append("\n"); 
		query.append("        ,A.FDR_VSL_NM           -- Feeder Name" ).append("\n"); 
		query.append("        ,A.FDR_VSL_LLOYD_NO     -- Feeder Lloyd No" ).append("\n"); 
		query.append("        ,A.FDR_VVD_ID           -- Feeder VVD" ).append("\n"); 
		query.append("	    ,A.NET_EXPLO_WGT		-- Net Explosive Weight " ).append("\n"); 
		query.append("		,'' D_TYPE" ).append("\n"); 
		query.append("		,'' VVD_CD" ).append("\n"); 
		query.append("		,'' SAVE_TYPE" ).append("\n"); 
		query.append("		,'' CRE_USR_ID" ).append("\n"); 
		query.append("		,'' UPD_USR_ID" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_DG A" ).append("\n"); 
		query.append("	   ,BKG_BOOKING BB" ).append("\n"); 
		query.append("       ,SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  A.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("   AND  A.IMDG_UN_NO       = SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("   AND  A.IMDG_UN_NO_SEQ   = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  A.DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("   AND  A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND  A.PORT_CD           = @[port_cd]" ).append("\n"); 
		query.append("   AND  A.BL_NO             = @[bl_no]" ).append("\n"); 
		query.append("   AND  A.CNTR_NO           = @[cntr_no]" ).append("\n"); 
		query.append("   AND  A.CNTR_CGO_SEQ      = @[cntr_cgo_seq]" ).append("\n"); 

	}
}