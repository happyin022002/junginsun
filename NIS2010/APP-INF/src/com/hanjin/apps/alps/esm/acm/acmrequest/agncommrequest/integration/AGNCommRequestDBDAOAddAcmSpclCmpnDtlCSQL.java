/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmSpclCmpnDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.16 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmSpclCmpnDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmSpclCmpnDtl
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmSpclCmpnDtlCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmSpclCmpnDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SPCL_CMPN_DTL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" C.BKG_NO" ).append("\n"); 
		query.append(",C.SPCL_OFC_CD" ).append("\n"); 
		query.append(",C.SPCL_CMPN_SEQ" ).append("\n"); 
		query.append(",Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",Q.OP_CNTR_QTY AS BKG_VOL_QTY" ).append("\n"); 
		query.append(",ROUND(C.IF_AMT     * (Q.IND/Q.TTL),2)  AS IF_DTRB_AMT" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM ACM_SPCL_CMPN C, " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT QTY.BKG_NO " ).append("\n"); 
		query.append("         , QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,QTY.OP_CNTR_QTY,QTY.OP_CNTR_QTY*2) AS IND" ).append("\n"); 
		query.append("         , SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,QTY.OP_CNTR_QTY,QTY.OP_CNTR_QTY*2))OVER (PARTITION BY QTY.BKG_NO) AS TTL" ).append("\n"); 
		query.append("    FROM  BKG_QUANTITY QTY" ).append("\n"); 
		query.append("    WHERE QTY.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append(") Q" ).append("\n"); 
		query.append("WHERE Q.BKG_NO = C.BKG_NO" ).append("\n"); 

	}
}