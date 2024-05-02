/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseMHListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.11.25 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseMHListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseMHListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pd_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseMHListRSQL").append("\n"); 
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
		query.append("SELECT STK.SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("STK.SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("TRO.TRO_SEQ AS TRO_SEQ," ).append("\n"); 
		query.append("TRO.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO TRO," ).append("\n"); 
		query.append("CIM_CNTR_STK STK" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND TRO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND TRO.TRO_PROC_CD = 'C'" ).append("\n"); 
		query.append("AND TRO.HLG_TP_CD = 'M'" ).append("\n"); 
		query.append("AND TRO.CNTR_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND TRO.CNTR_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("AND TRO.CNTR_PKUP_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("AND TO_CHAR (TRO.CNTR_PKUP_DT, 'YYYY-MM-DD') = @[pd_date]" ).append("\n"); 
		query.append("AND TRO.SO_CTY_CD = STK.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND TRO.SO_SEQ_NO = STK.SO_SEQ" ).append("\n"); 
		query.append("AND STK.TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("AND ROWNUM <= @[qty]" ).append("\n"); 
		query.append("AND NVL (TRO.CNTR_NO, 1) = NVL (@[cntr_no], 1)" ).append("\n"); 
		query.append("AND STK.STK_EVNT_DT = TO_DATE (@[issue_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("AND STK.STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("AND STK.STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("AND STK.IO_BND_CD = @[bd]" ).append("\n"); 
		query.append("AND STK.STL_FLG = 'N'" ).append("\n"); 

	}
}