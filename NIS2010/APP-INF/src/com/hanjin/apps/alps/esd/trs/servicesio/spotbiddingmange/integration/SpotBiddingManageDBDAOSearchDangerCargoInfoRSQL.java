/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOSearchDangerCargoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.11.04 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBiddingManageDBDAOSearchDangerCargoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG Danger Cargo info search
	  * </pre>
	  */
	public SpotBiddingManageDBDAOSearchDangerCargoInfoRSQL(){
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration ").append("\n"); 
		query.append("FileName : SpotBiddingManageDBDAOSearchDangerCargoInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,A.CNTR_NO EQ_NO" ).append("\n"); 
		query.append("      ,A.DCGO_SEQ" ).append("\n"); 
		query.append("      ,A.HCDG_FLG   --DCGO_HCDG_FLG" ).append("\n"); 
		query.append("      ,A.IMDG_UN_NO --DCGO_UN_NO" ).append("\n"); 
		query.append("      ,A.IMDG_CLSS_CD --DCGO_IMO_CLSS_CD" ).append("\n"); 
		query.append("      ,A.GRS_WGT --DCGO_GRS_WGT" ).append("\n"); 
		query.append("      ,A.NET_WGT -- DCGO_NET_WGT" ).append("\n"); 
		query.append("      ,A.PRP_SHP_NM -- DCGO_ACT_SHP_NM" ).append("\n"); 
		query.append("      ,A.HZD_DESC -- DCGO_HZD_DESC" ).append("\n"); 
		query.append("      ,A.FLSH_PNT_CDO_TEMP -- DCGO_FLSH_PNT_FDO_TEMP_CTNT" ).append("\n"); 
		query.append("      ,A.CTRL_TEMP_CTNT -- DCGO_CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("      ,A.EMER_TEMP_CTNT -- DCGO_EMER_TEMP_CTNT" ).append("\n"); 
		query.append("      ,A.IMDG_PCK_GRP_CD -- DCGO_N1ST_PCK_GRP_CD" ).append("\n"); 
		query.append("      ,A.IMDG_SUBS_RSK_LBL_CD1 -- DCGO_SUB_LBL_DESC" ).append("\n"); 
		query.append("      ,A.EMS_NO -- DCGO_EMS_NO" ).append("\n"); 
		query.append("      ,A.IMDG_LMT_QTY_FLG -- DCGO_IMO_LMT_FLG" ).append("\n"); 
		query.append("      ,A.MRN_POLUT_FLG -- DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("      ,A.EMER_RSPN_GID_NO -- DCGO_EMER_NO" ).append("\n"); 
		query.append("      ,A.EMER_RSPN_GID_CHR_NO -- DCGO_EMER_CHR_CD" ).append("\n"); 
		query.append("      ,A.PSA_NO -- DCGO_PSA_CD" ).append("\n"); 
		query.append("      ,DECODE(A.DCGO_STS_CD,'P','PASTE','L','LIQUID','S','SOLID','G','GAS') DCGO_STS_CD" ).append("\n"); 
		query.append("      ,A.EMER_CNTC_PHN_NO_CTNT -- DCGO_EMER_CNTC_PNT_NM " ).append("\n"); 
		query.append("      ,A.CERTI_NO -- DCGO_CERTI_NO" ).append("\n"); 
		query.append("      ,A.CNEE_DTL_DESC -- DCGO_CNEE_DTL_DESC" ).append("\n"); 
		query.append("      ,A.NET_EXPLO_WGT -- DCGO_NET_EXPLO_WGT" ).append("\n"); 
		query.append("      ,A.RADA_SKD_NO -- DCGO_RADA_SKD_CD" ).append("\n"); 
		query.append("      ,A.RADA_AMT -- DCGO_RADA_QTY" ).append("\n"); 
		query.append("      ,A.RADA_UT_CD -- DCGO_RADA_TP_CD" ).append("\n"); 
		query.append("      ,A.RADA_TRSP_NO -- DCGO_RADA_TRSP_ID" ).append("\n"); 
		query.append("      ,A.IN_IMDG_PCK_QTY1 --DCGO_PCK_QTY" ).append("\n"); 
		query.append("      ,A.OUT_IMDG_PCK_CD1 -- DCGO_OUT_PCK_N1ST_TP_CD" ).append("\n"); 
		query.append("      ,B.PCK_DESC" ).append("\n"); 
		query.append("      ,A.MAX_IN_PCK_QTY -- DCGO_IN_MAX_QTY" ).append("\n"); 
		query.append("      ,A.IN_IMDG_PCK_CD1 -- DCGO_IN_PCK_N1ST_TP_CD" ).append("\n"); 
		query.append("      ,C.PCK_DESC PCK_DESC2" ).append("\n"); 
		query.append("      ,A.DIFF_RMK -- DCGO_RMK" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO A" ).append("\n"); 
		query.append("      ,TRS_SPCL_CGO_PCK_CD B" ).append("\n"); 
		query.append("      ,TRS_SPCL_CGO_PCK_CD C" ).append("\n"); 
		query.append(" WHERE A.OUT_IMDG_PCK_CD1 = B.SPCL_CGO_PCK_CD(+)" ).append("\n"); 
		query.append("   AND A.IN_IMDG_PCK_CD1  = C.SPCL_CGO_PCK_CD(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.CNTR_NO  = @[eq_no]" ).append("\n"); 

	}
}