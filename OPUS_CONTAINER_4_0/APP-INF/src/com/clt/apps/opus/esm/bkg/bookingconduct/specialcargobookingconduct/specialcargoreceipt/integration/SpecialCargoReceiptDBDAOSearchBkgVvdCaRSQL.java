/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchBkgVvdCaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchBkgVvdCaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * c/a 화면에서 vvd 재지정시 special cargo 재 request를 위한 vvd를 조회한다.
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchBkgVvdCaRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchBkgVvdCaRSQL").append("\n"); 
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
		query.append("SELECT a4.BKG_NO" ).append("\n"); 
		query.append("      ,a4.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      ,a4.VSL_SEQ" ).append("\n"); 
		query.append("      ,a4.VSL_CD" ).append("\n"); 
		query.append("      ,a4.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,a4.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,a4.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,a4.POL_CD" ).append("\n"); 
		query.append("      ,a4.POD_CD" ).append("\n"); 
		query.append("      ,a4.CRE_USR_ID" ).append("\n"); 
		query.append("      ,a4.CRE_DT" ).append("\n"); 
		query.append("      ,a4.UPD_USR_ID" ).append("\n"); 
		query.append("      ,a4.UPD_DT" ).append("\n"); 
		query.append("      ,a4.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,a4.POL_YD_CD" ).append("\n"); 
		query.append("      ,a4.POD_YD_CD" ).append("\n"); 
		query.append("      ,a4.SLAN_CD" ).append("\n"); 
		query.append("FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("      , VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      , VSL_SEQ" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      , POL_YD_CD" ).append("\n"); 
		query.append("      , POD_YD_CD" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("		FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("	   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("      MINUS" ).append("\n"); 
		query.append("	  SELECT BKG_NO" ).append("\n"); 
		query.append("      , VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      , VSL_SEQ" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      , POL_YD_CD" ).append("\n"); 
		query.append("      , POD_YD_CD" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("		FROM BKG_VVD 	" ).append("\n"); 
		query.append("	   WHERE BKG_NO = @[bkg_no]		" ).append("\n"); 
		query.append("	 ) A1" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE A3, bkg_vvd_his a4" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and a1.bkg_no           = a4.bkg_no" ).append("\n"); 
		query.append("and a4.CORR_NO 			= 'TMP0000001'" ).append("\n"); 
		query.append("and a1.VSL_PRE_PST_CD   = a4.vsl_pre_pst_cd" ).append("\n"); 
		query.append("and a1.vsl_seq          = a4.VSL_SEQ" ).append("\n"); 
		query.append("AND A1.SLAN_CD                    = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A3.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("AND A3.VSL_SVC_TP_CD              <> 'O' " ).append("\n"); 
		query.append("AND A3.DELT_FLG                   = 'N'" ).append("\n"); 
		query.append("AND A1.VSL_CD                     IS NOT NULL" ).append("\n"); 

	}
}