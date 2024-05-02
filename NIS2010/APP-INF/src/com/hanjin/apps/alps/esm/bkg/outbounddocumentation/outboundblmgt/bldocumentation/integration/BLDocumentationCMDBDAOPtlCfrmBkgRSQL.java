/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOPtlCfrmBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.02 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOPtlCfrmBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOPtlCfrmBkgRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOPtlCfrmBkgRSQL").append("\n"); 
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
		query.append("SELECT C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   A.BKG_CGO_TP_CD = B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("AND   A.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("AND   A.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("AND   B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND   B.BKG_STS_CD IN ('W','F')" ).append("\n"); 
		query.append("AND   B.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND   C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   C.CNTR_CFM_FLG = 'Y'" ).append("\n"); 

	}
}