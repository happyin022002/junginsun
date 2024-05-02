/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrCmDescInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.28 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrCmDescInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrCmDescInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrCmDescInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      B.CNTR_NO" ).append("\n"); 
		query.append(",      C.CNTR_MF_SEQ" ).append("\n"); 
		query.append(",      C.PCK_QTY" ).append("\n"); 
		query.append(",      C.PCK_TP_CD" ).append("\n"); 
		query.append(",      C.CNTR_MF_WGT" ).append("\n"); 
		query.append(",      C.WGT_UT_CD" ).append("\n"); 
		query.append(",      C.MEAS_QTY" ).append("\n"); 
		query.append(",      C.MEAS_UT_CD" ).append("\n"); 
		query.append(",      C.DCGO_FLG" ).append("\n"); 
		query.append(",      C.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      C.HNGR_FLG" ).append("\n"); 
		query.append(",      C.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",      C.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",      C.CRE_USR_ID" ).append("\n"); 
		query.append(",      C.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_CONTAINER B, BKG_CNTR_MF_DESC C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND    B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND    B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND    A.BKG_STS_CD <> 'X'" ).append("\n"); 

	}
}