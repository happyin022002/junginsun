/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOCaInquiryReportMarksRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.17 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaInquiryReportMarksRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaInquiryReportMarksRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaInquiryReportMarksRSQL").append("\n"); 
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
		query.append("#if (${corr_no} == '')" ).append("\n"); 
		query.append("SELECT  MK.MK_SEQ," ).append("\n"); 
		query.append("DECODE(F.CONTI_CD,G.CONTI_CD,'Local','T/S') LOC_TS," ).append("\n"); 
		query.append("MK.MK_DESC," ).append("\n"); 
		query.append("MK.CMDT_DESC" ).append("\n"); 
		query.append("FROM  BKG_BOOKING B, BKG_VVD V, BKG_BL_MK_DESC MK ,MDM_LOCATION F, MDM_LOCATION G" ).append("\n"); 
		query.append("WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND B.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.BKG_NO = MK.BKG_NO" ).append("\n"); 
		query.append("AND B.POD_CD = F.LOC_CD" ).append("\n"); 
		query.append("AND V.POD_CD = G.LOC_CD" ).append("\n"); 
		query.append("AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT MK.MK_SEQ" ).append("\n"); 
		query.append(",DECODE(F.CONTI_CD,G.CONTI_CD,'Local','T/S') LOC_TC" ).append("\n"); 
		query.append(",MK.MK_DESC" ).append("\n"); 
		query.append(",MK.CMDT_DESC" ).append("\n"); 
		query.append("FROM BKG_BOOKING          BKG" ).append("\n"); 
		query.append(",BKG_BL_MK_DESC_HIS   MK" ).append("\n"); 
		query.append(",BKG_VVD V,MDM_LOCATION F, MDM_LOCATION G" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = MK.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND BKG.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND BKG.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BKG.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BKG.POD_CD = F.LOC_CD" ).append("\n"); 
		query.append("AND V.POD_CD = G.LOC_CD" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND MK.CORR_NO = @[corr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}