/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BangladeshOdcyReqDBDAOSearchShippingRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.04.24 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshOdcyReqDBDAOSearchShippingRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchShippingRequest
	  * </pre>
	  */
	public BangladeshOdcyReqDBDAOSearchShippingRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.integration").append("\n"); 
		query.append("FileName : BangladeshOdcyReqDBDAOSearchShippingRequestRSQL").append("\n"); 
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
		query.append("SELECT RQST.BKG_NO" ).append("\n"); 
		query.append("     , RQST.CNTR_NO" ).append("\n"); 
		query.append("     , RQST.CNTR_SEQ" ).append("\n"); 
		query.append("     , RQST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , RQST.CNTR_SEAL_NO" ).append("\n"); 
		query.append("     , RQST.PCK_QTY" ).append("\n"); 
		query.append("     , RQST.PCK_TP_CD" ).append("\n"); 
		query.append("     , RQST.CNTR_WGT" ).append("\n"); 
		query.append("     , RQST.WGT_UT_CD" ).append("\n"); 
		query.append("     , RQST.MEAS_QTY" ).append("\n"); 
		query.append("     , RQST.MEAS_UT_CD" ).append("\n"); 
		query.append("     , RQST.CNTR_VOL_QTY" ).append("\n"); 
		query.append("     , RQST.VNDR_SEQ" ).append("\n"); 
		query.append("     , BKGVVD.SLAN_CD SLANE_CD" ).append("\n"); 
		query.append("     , BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , BKG.POL_CD" ).append("\n"); 
		query.append("FROM BKG_CUST_SHP_RQST RQST" ).append("\n"); 
		query.append("   , BKG_BOOKING BKG" ).append("\n"); 
		query.append("   , BKG_VVD BKGVVD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG.BKG_NO = RQST.BKG_NO" ).append("\n"); 
		query.append("AND RQST.BKG_NO = BKGVVD.BKG_NO" ).append("\n"); 
		query.append("AND BKG.POL_CD = BKGVVD.POL_CD" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("  AND RQST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_cd} != '')" ).append("\n"); 
		query.append("  AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("  AND RQST.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vndr_seq} !='')" ).append("\n"); 
		query.append("  AND RQST.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${upd_dt_from} !='' && ${upd_dt_to} !='') " ).append("\n"); 
		query.append("  AND RQST.UPD_DT BETWEEN TO_DATE(@[upd_dt_from],'YYYY-MM-DD') AND TO_DATE(@[upd_dt_to],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RQST.CRE_USR_ID = 'SPPUSR'" ).append("\n"); 
		query.append("AND RQST.UPD_USR_ID = 'SPPUSR'" ).append("\n"); 

	}
}