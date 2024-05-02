/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialReportDBDAOSearchReportTemplateBstVipList3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.07.17 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOSearchReportTemplateBstVipList3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Report Kind List
	  * </pre>
	  */
	public SpecialReportDBDAOSearchReportTemplateBstVipList3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOSearchReportTemplateBstVipList3RSQL").append("\n"); 
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
		query.append("SELECT USR_ID" ).append("\n"); 
		query.append(",  BKG_RPT_KND_CD" ).append("\n"); 
		query.append(",  RPT_ID" ).append("\n"); 
		query.append(",  RPT_NM" ).append("\n"); 
		query.append(",  COM_FLG" ).append("\n"); 
		query.append(",  OWNR_USR_ID" ).append("\n"); 
		query.append(",  DP_SEQ" ).append("\n"); 
		query.append(",  SC_NO" ).append("\n"); 
		query.append(",  CUST_CNT_CD" ).append("\n"); 
		query.append(",  CUST_SEQ" ).append("\n"); 
		query.append(",  VIS_FLG" ).append("\n"); 
		query.append(",  USR_ID" ).append("\n"); 
		query.append(",  DECODE(COM_FLG,'Y','C',PRIVATE_GB) TYPE_GUBUN" ).append("\n"); 
		query.append(", BZC_COND_SQL_CTNT" ).append("\n"); 
		query.append("FROM ( SELECT /*+ INDEX(A XPKBKG_RPT_SET) */" ).append("\n"); 
		query.append("USR_ID" ).append("\n"); 
		query.append(", B.BKG_RPT_KND_CD" ).append("\n"); 
		query.append(", B.RPT_ID" ).append("\n"); 
		query.append(", B.RPT_NM" ).append("\n"); 
		query.append(", B.COM_FLG" ).append("\n"); 
		query.append(", B.OWNR_USR_ID" ).append("\n"); 
		query.append(", A.DP_SEQ" ).append("\n"); 
		query.append(", A.SC_NO" ).append("\n"); 
		query.append(", A.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", A.CUST_CNT_CD" ).append("\n"); 
		query.append(", A.CUST_SEQ" ).append("\n"); 
		query.append(", A.VIS_FLG" ).append("\n"); 
		query.append(", DECODE(OWNR_USR_ID ,@[upd_usr_id],'P','S') PRIVATE_GB" ).append("\n"); 
		query.append(", BZC_COND_SQL_CTNT" ).append("\n"); 
		query.append("from BKG_RPT_SET A, BKG_RPT_DFLT B" ).append("\n"); 
		query.append("WHERE A.BKG_RPT_KND_CD(+) = B.BKG_RPT_KND_CD" ).append("\n"); 
		query.append("AND   A.RPT_ID(+)         = B.RPT_ID" ).append("\n"); 
		query.append("AND   B.BKG_RPT_KND_CD    = @[p_bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("AND   (     A.USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("OR  B.COM_FLG     ='Y' )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}