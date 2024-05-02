/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOMaxCycleBkgBySameEccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.07 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOMaxCycleBkgBySameEccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOMaxCycleBkgBySameEccRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOMaxCycleBkgBySameEccRSQL").append("\n"); 
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
		query.append("SELECT CNMV_CYC_NO, BKG_NO, BKG_CGO_TP_CD, VVD" ).append("\n"); 
		query.append("FROM   (SELECT A.CNMV_CYC_NO" ).append("\n"); 
		query.append(",			   B.BKG_NO" ).append("\n"); 
		query.append(",			   B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",			   B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND (B.BKG_NO || B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD <> 'PSEUDO00001PSDO9999W')" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, ' ') NOT IN ('S', 'X')" ).append("\n"); 
		query.append("ORDER BY CNTR_NO DESC, CNMV_CYC_NO DESC, BKG_NO DESC)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1" ).append("\n"); 

	}
}