/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchCntrCgoByCntrBaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchCntrCgoByCntrBaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이터에 해당하는 아이템 정보 조회
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchCntrCgoByCntrBaseRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchCntrCgoByCntrBaseRSQL").append("\n"); 
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
		query.append("     A.CNTR_CGO_SEQ             ITEM_NBR    " ).append("\n"); 
		query.append("    ,A.OUT_IMDG_PCK_QTY1        PKG_QTY" ).append("\n"); 
		query.append("    ,A.OUT_IMDG_PCK_QTY1        OUTPKG_QTY" ).append("\n"); 
		query.append("    ,A.IN_IMDG_PCK_QTY1         INPKG_QTY" ).append("\n"); 
		query.append("    ,A.OUT_IMDG_PCK_CD1         PKG_TP" ).append("\n"); 
		query.append("    ,A.OUT_IMDG_PCK_CD1         OUTPKG_TP" ).append("\n"); 
		query.append("    ,A.IN_IMDG_PCK_CD1          INPKG_TP" ).append("\n"); 
		query.append("    ,A.EUR_PCK_DESC             PKG_DESC" ).append("\n"); 
		query.append("    ,A.EUR_OUTR_PCK_DESC        OUTPKG_DESC" ).append("\n"); 
		query.append("    ,A.EUR_INR_PCK_DESC         INPKG_DESC" ).append("\n"); 
		query.append("    ,A.HZD_DESC                 HAZ_CONT" ).append("\n"); 
		query.append("    ,A.PRP_SHP_NM               PROP_SHIP_NM" ).append("\n"); 
		query.append("    ,A.IMDG_CLSS_CD 			IMO_CLASS" ).append("\n"); 
		query.append("	,SIUN.IMDG_COMP_GRP_CD		IMO_COMP" ).append("\n"); 
		query.append("    ,A.EMER_RSPN_GID_NO         IMO_PAGE" ).append("\n"); 
		query.append("    ,A.IMDG_UN_NO               UN_NBR" ).append("\n"); 
		query.append("    ,A.IMDG_UN_NO_SEQ           UN_NBR_SEQ" ).append("\n"); 
		query.append("    ,A.FLSH_PNT_CDO_TEMP        FLASH" ).append("\n"); 
		query.append("    ,'CEL'                      FLASH_UNIT" ).append("\n"); 
		query.append("    ,A.IMDG_PCK_GRP_CD          PKG_GROUP" ).append("\n"); 
		query.append("    ,A.EMS_NO                   EMS_NBR" ).append("\n"); 
		query.append("    ,A.MFAG_NO                  MFAG" ).append("\n"); 
		query.append("    ,A.XTD_STAY_PRMT_NO         ESPN" ).append("\n"); 
		query.append("    ,NVL(A.DIFF_RMK, '')        DIFF_RMK" ).append("\n"); 
		query.append("    ,A.EUR_DCGO_MRN_POLUT_CD    POLLUTANT" ).append("\n"); 
		query.append("    ,A.IMDG_LMT_QTY_FLG         IMO_LIMIT" ).append("\n"); 
		query.append("    ,A.HCDG_FLG                 HCDG" ).append("\n"); 
		query.append("    ,A.GRS_WGT                  GROSSWGT" ).append("\n"); 
		query.append("    ,'KGM'                      GROSSWGT_UNIT" ).append("\n"); 
		query.append("    ,A.NET_WGT                  NETWGT" ).append("\n"); 
		query.append("    ,'KGM'                      NETWGT_UNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,A.NET_EXPLO_WGT			NW_EXPLOSIVE" ).append("\n"); 
		query.append("	,'KGM'						NW_EXP_UNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.CNTR_NO                  CNTRNBR" ).append("\n"); 
		query.append("    ,DECODE(NVL(A.CELL_PSN_NO, ''), '', '', LPAD(A.CELL_PSN_NO, 7,0 )) STOWPOS" ).append("\n"); 
		query.append("	,A.IMDG_SUBS_RSK_LBL_CD1	SUB_CLASS1" ).append("\n"); 
		query.append("	,A.IMDG_SUBS_RSK_LBL_CD2	SUB_CLASS2" ).append("\n"); 
		query.append("	,A.IMDG_SUBS_RSK_LBL_CD3	SUB_CLASS3" ).append("\n"); 
		query.append("	,A.IMDG_SUBS_RSK_LBL_CD4	SUB_CLASS4" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_DG A, SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND  A.IMDG_UN_NO       = SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND  A.IMDG_UN_NO_SEQ   = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("AND   A.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.PORT_CD         = @[port_cd]" ).append("\n"); 
		query.append("AND   A.BL_NO           = @[bl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, CNTR_CGO_SEQ" ).append("\n"); 

	}
}