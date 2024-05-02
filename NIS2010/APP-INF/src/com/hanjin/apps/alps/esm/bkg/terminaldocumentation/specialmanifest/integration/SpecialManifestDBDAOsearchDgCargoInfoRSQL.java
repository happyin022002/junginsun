/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgCargoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchDgCargoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDgCargoInfo
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgCargoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgCargoInfoRSQL").append("\n"); 
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
		query.append("SELECT  A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.PORT_CD" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.CNTR_NO" ).append("\n"); 
		query.append(",A.CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append(",A.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",A.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",A.IMDG_UN_NO" ).append("\n"); 
		query.append(",A.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",A.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",IP.IMDG_PCK_DESC" ).append("\n"); 
		query.append(",A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",A.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",A.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",A.EMS_NO" ).append("\n"); 
		query.append(",OP.IMDG_PCK_DESC" ).append("\n"); 
		query.append(",A.NET_WGT" ).append("\n"); 
		query.append(",A.CELL_PSN_NO" ).append("\n"); 
		query.append(",A.GRS_WGT" ).append("\n"); 
		query.append(",A.PCK_QTY" ).append("\n"); 
		query.append(",A.PCK_TP_CD" ).append("\n"); 
		query.append(",A.PRP_SHP_NM" ).append("\n"); 
		query.append(",A.HZD_DESC" ).append("\n"); 
		query.append(",B.BRTH_YD_CD" ).append("\n"); 
		query.append(",D.FWRD_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.CRR_DT, 'DD-MM-YYYY') AS CRR_DT" ).append("\n"); 
		query.append("--,A.STAY_FLG" ).append("\n"); 
		query.append(",A.DIFF_RMK" ).append("\n"); 
		query.append(",A.IMDG_UN_NO" ).append("\n"); 
		query.append(",A.ANR_CRR_TP_CD" ).append("\n"); 
		query.append(",A.FDR_SVC_RQST_NO" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.LLOYD_NO" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append(",BKG_CSTMS_EUR_DG_VSL_SKD B" ).append("\n"); 
		query.append(",BKG_DG_CGO C" ).append("\n"); 
		query.append(",SCG_IMDG_PCK_CD IP" ).append("\n"); 
		query.append(",SCG_IMDG_PCK_CD OP" ).append("\n"); 
		query.append(",BKG_CSTMS_EUR_DG_FWRD D" ).append("\n"); 
		query.append(",BKG_CSTMS_EUR_DG_SPCL E" ).append("\n"); 
		query.append("WHERE  A.EUR_DG_DECL_TP_CD = B.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("AND  A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND  A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND  A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND  A.PORT_CD = B.PORT_CD(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.CNTR_CGO_SEQ = C.DCGO_SEQ(+)" ).append("\n"); 
		query.append("AND  A.IN_IMDG_PCK_CD1 = IP.IMDG_PCK_CD(+)" ).append("\n"); 
		query.append("AND  A.OUT_IMDG_PCK_CD1 = OP.IMDG_PCK_CD(+)" ).append("\n"); 
		query.append("AND  A.ANR_FWRD_ID = D.ANR_FWRD_ID(+)" ).append("\n"); 
		query.append("AND  A.IMDG_UN_NO = E.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND  A.ANR_SPCL_TP_ID = E.ANR_SPCL_TP_ID(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND  A.CNTR_CGO_SEQ = @[cntr_cgo_seq]" ).append("\n"); 

	}
}