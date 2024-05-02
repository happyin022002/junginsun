/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOEdiNotUpdCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.13 김영출
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

public class BLDocumentationCMDBDAOEdiNotUpdCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BLDocumentationCMDBDAOEdiNotUpdCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOEdiNotUpdCntrRSQL").append("\n"); 
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
		query.append("SELECT B1.CNTR_NO" ).append("\n"); 
		query.append(",      B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      B1.CNTR_BKG_ATCH_CD" ).append("\n"); 
		query.append(",      B1.BKG_NO" ).append("\n"); 
		query.append(",      DECODE(B1.CNTR_BKG_ATCH_CD, 'A', B2.MVMT_STS_CD, B3.MVMT_STS_CD) STS" ).append("\n"); 
		query.append(",      DECODE(B1.CNTR_BKG_ATCH_CD, 'A', B2.ORG_YD_CD,   B3.ORG_YD_CD)   ORG_YD" ).append("\n"); 
		query.append(",      DECODE(B1.CNTR_BKG_ATCH_CD, 'A', B2.DEST_YD_CD,  B3.DEST_YD_CD)  DEST_YD" ).append("\n"); 
		query.append(",      TO_CHAR(DECODE(B1.CNTR_BKG_ATCH_CD, 'A', B2.CNMV_EVNT_DT, B3.CNMV_EVNT_DT), 'YYYYMMDD HH24MI') EVNT_DT" ).append("\n"); 
		query.append("FROM   CTM_MVMT_IRR B1, CTM_MOVEMENT B2, CTM_MOVEMENT B3" ).append("\n"); 
		query.append("WHERE  B1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    B1.CNMV_IRR_STL_FLG = 'N'" ).append("\n"); 
		query.append("AND    B2.CNTR_NO = B1.CNTR_NO" ).append("\n"); 
		query.append("AND    B2.CNMV_YR = B1.CNMV_YR" ).append("\n"); 
		query.append("AND    B2.CNMV_ID_NO = B1.CNMV_ID_NO" ).append("\n"); 
		query.append("AND    B3.CNTR_NO = B1.CNTR_NO" ).append("\n"); 
		query.append("AND    B3.CNMV_YR = B1.PRE_CNMV_YR" ).append("\n"); 
		query.append("AND    B3.CNMV_ID_NO = B1.PRE_CNMV_ID_NO" ).append("\n"); 

	}
}