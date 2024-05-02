/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchBkgVvdTsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchBkgVvdTsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * t/s 화면에서 vvd 재지정시 special cargo 재 request를 위한 vvd를 조회한다.
	  * 2011.07.05 이일민 [CHM-201111757-01] [Special Cargo:Request로직] Group VVD assign, Next VVD Assign통한 자동 재승인요청
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchBkgVvdTsRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchBkgVvdTsRSQL").append("\n"); 
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
		query.append("SELECT A1.BKG_NO" ).append("\n"); 
		query.append("      ,A1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      ,A1.VSL_SEQ" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A1.CRE_DT" ).append("\n"); 
		query.append("      ,A1.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A1.UPD_DT" ).append("\n"); 
		query.append("      ,A1.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A1.POL_YD_CD" ).append("\n"); 
		query.append("      ,A1.POD_YD_CD" ).append("\n"); 
		query.append("      ,A1.SLAN_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A1" ).append("\n"); 
		query.append(",BKG_BL_DOC A2" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE A3" ).append("\n"); 
		query.append(",(select bkg_no, SPCL_CGO_APRO_CD, max(spcl_row) spcl_row" ).append("\n"); 
		query.append("    from " ).append("\n"); 
		query.append("	(select bkg_no, SPCL_CGO_APRO_CD, rownum spcl_row" ).append("\n"); 
		query.append("	    from" ).append("\n"); 
		query.append("		(SELECT DISTINCT BKG_NO, SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("		   FROM " ).append("\n"); 
		query.append("		    (SELECT BKG_NO, SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("		        FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("		       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				 AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("		       UNION ALL" ).append("\n"); 
		query.append("		      SELECT BKG_NO, SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("		        FROM BKG_RF_CGO DG" ).append("\n"); 
		query.append("		       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				 AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("		       UNION ALL" ).append("\n"); 
		query.append("		      SELECT BKG_NO, SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("		        FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("		       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				 AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("		       UNION ALL" ).append("\n"); 
		query.append("		      SELECT BKG_NO, SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("		        FROM BKG_BB_CGO" ).append("\n"); 
		query.append("		       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				 AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(" group by bkg_no, SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(") SPCL" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = SPCL.BKG_NO " ).append("\n"); 
		query.append("				-- 전부 'Y'이면 post만" ).append("\n"); 
		query.append("and 'Y' = case when spcl.spcl_row = 1 and spcl.SPCL_CGO_APRO_CD = 'Y' and a1.vsl_pre_pst_cd = 'U' then 'Y'" ).append("\n"); 
		query.append("			   when spcl.spcl_row = 1 and spcl.SPCL_CGO_APRO_CD <> 'Y' and (a1.vsl_pre_pst_cd = 'T' or a1.vsl_pre_pst_cd = 'U') then 'Y'" ).append("\n"); 
		query.append("               when spcl.spcl_row > 1 and (a1.vsl_pre_pst_cd = 'T' or a1.vsl_pre_pst_cd = 'U') then 'Y' " ).append("\n"); 
		query.append("               else 'N' end" ).append("\n"); 
		query.append("AND A1.SLAN_CD                    = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A3.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("AND A3.VSL_SVC_TP_CD              <> 'O' " ).append("\n"); 
		query.append("AND A3.DELT_FLG                   = 'N'" ).append("\n"); 
		query.append("AND A1.VSL_CD                     IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT A1.BKG_NO" ).append("\n"); 
		query.append("      ,A1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      ,A1.VSL_SEQ" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A1.CRE_DT" ).append("\n"); 
		query.append("      ,A1.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A1.UPD_DT" ).append("\n"); 
		query.append("      ,A1.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A1.POL_YD_CD" ).append("\n"); 
		query.append("      ,A1.POD_YD_CD" ).append("\n"); 
		query.append("      ,A1.SLAN_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A1" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if ($vvds.size() > 0)" ).append("\n"); 
		query.append("AND A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD IN (" ).append("\n"); 
		query.append("	#foreach($vvd IN ${vvds})" ).append("\n"); 
		query.append("		#if($velocityCount<$vvds.size()) '$vvd', #else '$vvd' #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.SLAN_CD                    = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A3.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("AND A3.VSL_SVC_TP_CD              <> 'O' " ).append("\n"); 
		query.append("AND A3.DELT_FLG                   = 'N'" ).append("\n"); 

	}
}