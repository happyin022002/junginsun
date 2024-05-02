/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOReportItemVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOReportItemVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.09.10 김영철 [ ] VIP REPORT 부분 오류 수정 ( 반영일 : 2010.09.24 )
	  * </pre>
	  */
	public BookingUtilDBDAOReportItemVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOReportItemVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.TBL_NM" ).append("\n"); 
		query.append(",	A.COL_NM" ).append("\n"); 
		query.append(",	B.DP_NM  AS ITEM_NM" ).append("\n"); 
		query.append(",	B.SQL_CTNT" ).append("\n"); 
		query.append(",	A.RPT_ID" ).append("\n"); 
		query.append(",	A.BKG_RPT_KND_CD" ).append("\n"); 
		query.append(",	A.ORD_SEQ" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_RPT_DFLT_DTL A" ).append("\n"); 
		query.append(",BKG_TBL_COL      B" ).append("\n"); 
		query.append("WHERE B.TBL_NM = A.TBL_NM" ).append("\n"); 
		query.append("AND B.COL_NM = A.COL_NM" ).append("\n"); 
		query.append("AND A.RPT_ID = @[rpt_id]" ).append("\n"); 
		query.append("AND	A.BKG_RPT_KND_CD = @[bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("--ORDER BY B.VIP_RPT_ORD_SEQ ASC" ).append("\n"); 
		query.append("ORDER BY A.ORD_SEQ ASC" ).append("\n"); 

	}
}