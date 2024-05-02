/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyDgCgoByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.03 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOcopyDgCgoByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyDgCgoByBkg
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyDgCgoByBkgCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyDgCgoByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DG_CGO(BKG_NO" ).append("\n"); 
		query.append("        , DCGO_SEQ" ).append("\n"); 
		query.append("        , DG_CNTR_SEQ" ).append("\n"); 
		query.append("        , CNTR_CGO_SEQ" ).append("\n"); 
		query.append("        , IMDG_UN_NO" ).append("\n"); 
		query.append("        , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("        , IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("        , IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("        , IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("        , NET_WGT" ).append("\n"); 
		query.append("        , GRS_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("        , PRP_SHP_NM" ).append("\n"); 
		query.append("        , HZD_DESC" ).append("\n"); 
		query.append("        , MEAS_QTY" ).append("\n"); 
		query.append("        , MEAS_UT_CD" ).append("\n"); 
		query.append("        , CLOD_FLG" ).append("\n"); 
		query.append("        , SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("        , DCGO_STS_CD" ).append("\n"); 
		query.append("        , CGO_LCL_FLG" ).append("\n"); 
		query.append("        , EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("        , EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("        , EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append("        , EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("        , EMER_TEMP_CTNT" ).append("\n"); 
		query.append("        , CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("        , EMS_NO" ).append("\n"); 
		query.append("        , IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("        , MRN_POLUT_FLG" ).append("\n"); 
		query.append("        , PSA_NO" ).append("\n"); 
		query.append("        , CERTI_NO" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append("        , MAX_IN_PCK_QTY" ).append("\n"); 
		query.append("        , MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append("        , CNEE_DTL_DESC" ).append("\n"); 
		query.append("        , NET_EXPLO_WGT" ).append("\n"); 
		query.append("        , RADA_SKD_NO" ).append("\n"); 
		query.append("        , RADA_AMT" ).append("\n"); 
		query.append("        , RADA_UT_CD" ).append("\n"); 
		query.append("        , RADA_TRSP_NO" ).append("\n"); 
		query.append("        , RC_FLG" ).append("\n"); 
		query.append("        , AWK_CGO_FLG" ).append("\n"); 
		query.append("        , BB_CGO_FLG" ).append("\n"); 
		query.append("        , RC_SEQ" ).append("\n"); 
		query.append("        , AWK_CGO_SEQ" ).append("\n"); 
		query.append("        , BB_CGO_SEQ" ).append("\n"); 
		query.append("        , HCDG_FLG" ).append("\n"); 
		query.append("        , HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , APLY_NO" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("        , CNTR_VOL_QTY" ).append("\n"); 
		query.append("        , DCGO_REF_NO" ).append("\n"); 
		query.append("        , IMDG_AMDT_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append("		,(SELECT /*+index_desc (bkg_dg_cgo XPKBKG_DG_CGO)*/" ).append("\n"); 
		query.append("					NVL(SUM(DCGO_SEQ),0)+DG.DCGO_SEQ" ).append("\n"); 
		query.append("					FROM BKG_DG_CGO" ).append("\n"); 
		query.append("					WHERE DCGO_SEQ >= 0" ).append("\n"); 
		query.append("					AND ROWNUM <= 1" ).append("\n"); 
		query.append("					AND BKG_NO = @[mst_bkg_no]) DCGO_SEQ" ).append("\n"); 
		query.append("--dg_cntr_seq" ).append("\n"); 
		query.append("		, (select case when dg.cntr_no is null then (select nvl(max(cgo.dg_cntr_seq), 0) + dg.dg_cntr_seq" ).append("\n"); 
		query.append("    	            		                           from bkg_dg_cgo cgo" ).append("\n"); 
		query.append("        	                	                      where cgo.bkg_no = @[mst_bkg_no])" ).append("\n"); 
		query.append("					  when (select count(1) -- 같은 cntr라면 dg_cntr_seq는 그대로 유지" ).append("\n"); 
		query.append("	          		          from bkg_dg_cgo mst " ).append("\n"); 
		query.append("    	            		 where mst.bkg_no = @[mst_bkg_no] " ).append("\n"); 
		query.append("			                   and mst.cntr_no = dg.cntr_no" ).append("\n"); 
		query.append("        			           and rownum = 1) > 0 then (select cgo.dg_cntr_seq" ).append("\n"); 
		query.append("                		                                   from bkg_dg_cgo cgo" ).append("\n"); 
		query.append("                        	 	                          where cgo.bkg_no = @[mst_bkg_no]" ).append("\n"); 
		query.append("                                                            and dg.cntr_no = cgo.cntr_no" ).append("\n"); 
		query.append("															and rownum = 1)" ).append("\n"); 
		query.append(" 		              else (select nvl(max(cgo.dg_cntr_seq), 0) + dg.dg_cntr_seq --그외의 경우는 max(dg_cntr_seq) + 1" ).append("\n"); 
		query.append("        		              from bkg_dg_cgo cgo" ).append("\n"); 
		query.append("                		     where cgo.bkg_no = @[mst_bkg_no]) end" ).append("\n"); 
		query.append("		     from dual) dg_cntr_seq" ).append("\n"); 
		query.append("--cntr_cgo_seq" ).append("\n"); 
		query.append("		, (select case when (select count(1) -- 같은 cntr라면 동일 cntr 내의 cntr_cgo_Seq 중가" ).append("\n"); 
		query.append("          		      	      from bkg_dg_cgo mst " ).append("\n"); 
		query.append("                			 where mst.bkg_no = @[mst_bkg_no] " ).append("\n"); 
		query.append("		                       and mst.cntr_no = dg.cntr_no" ).append("\n"); 
		query.append("	        		           and rownum = 1) > 0 then (select nvl(max(cgo.cntr_cgo_seq), 0) + dg.cntr_cgo_seq" ).append("\n"); 
		query.append("    	            		                               from bkg_dg_cgo cgo" ).append("\n"); 
		query.append("        	                	                       	  where cgo.bkg_no = @[mst_bkg_no]" ).append("\n"); 
		query.append("            	                    		                and cgo.cntr_no = dg.cntr_no)" ).append("\n"); 
		query.append("		              else cntr_cgo_seq end --그외의 경우는 그대로 복사" ).append("\n"); 
		query.append("		     from dual) cntr_cgo_seq" ).append("\n"); 
		query.append("        , IMDG_UN_NO" ).append("\n"); 
		query.append("        , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("        , IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("        , IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("        , IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("        , NET_WGT" ).append("\n"); 
		query.append("        , GRS_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("        , PRP_SHP_NM" ).append("\n"); 
		query.append("        , HZD_DESC" ).append("\n"); 
		query.append("        , MEAS_QTY" ).append("\n"); 
		query.append("        , MEAS_UT_CD" ).append("\n"); 
		query.append("        , CLOD_FLG" ).append("\n"); 
		query.append("        , SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("        , DCGO_STS_CD" ).append("\n"); 
		query.append("        , CGO_LCL_FLG" ).append("\n"); 
		query.append("        , EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("        , EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("        , EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append("        , EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("        , EMER_TEMP_CTNT" ).append("\n"); 
		query.append("        , CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("        , EMS_NO" ).append("\n"); 
		query.append("        , IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("        , MRN_POLUT_FLG" ).append("\n"); 
		query.append("        , PSA_NO" ).append("\n"); 
		query.append("        , CERTI_NO" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("        , IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("        , OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append("        , MAX_IN_PCK_QTY" ).append("\n"); 
		query.append("        , MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append("        , CNEE_DTL_DESC" ).append("\n"); 
		query.append("        , NET_EXPLO_WGT" ).append("\n"); 
		query.append("        , RADA_SKD_NO" ).append("\n"); 
		query.append("        , RADA_AMT" ).append("\n"); 
		query.append("        , RADA_UT_CD" ).append("\n"); 
		query.append("        , RADA_TRSP_NO" ).append("\n"); 
		query.append("        , RC_FLG" ).append("\n"); 
		query.append("        , AWK_CGO_FLG" ).append("\n"); 
		query.append("        , BB_CGO_FLG" ).append("\n"); 
		query.append("        , RC_SEQ" ).append("\n"); 
		query.append("        , AWK_CGO_SEQ" ).append("\n"); 
		query.append("        , BB_CGO_SEQ" ).append("\n"); 
		query.append("        , HCDG_FLG" ).append("\n"); 
		query.append("        , HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , APLY_NO" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("        , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("        , nvl((select cntr.CNTR_VOL_QTY " ).append("\n"); 
		query.append("                 from bkg_container cntr " ).append("\n"); 
		query.append("                where cntr.bkg_no  = @[mst_bkg_no]" ).append("\n"); 
		query.append("                  and cntr.cntr_no = dg.cntr_no), 1)" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , DCGO_REF_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        , BKG_COMMON_PKG.BKG_NO_GEN_FNC('DGN', @[ofc_cd], @[usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , IMDG_AMDT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}