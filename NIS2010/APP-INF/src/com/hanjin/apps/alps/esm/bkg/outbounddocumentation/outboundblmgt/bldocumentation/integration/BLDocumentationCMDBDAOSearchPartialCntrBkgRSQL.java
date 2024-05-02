/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchPartialCntrBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchPartialCntrBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partial인 컨테이너의 BKG를 찾는다
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchPartialCntrBkgRSQL(){
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
		query.append("FileName : BLDocumentationCMDBDAOSearchPartialCntrBkgRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT /*+ ORDERED INDEX_DESC(A XAK1BKG_CONTAINER) INDEX(BO XPKBKG_BOOKING) */ BO.BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BO, BKG_BOOKING BO2" ).append("\n"); 
		query.append("         WHERE BO.BKG_NO  IN  (SELECT BKG_NO FROM BKG_CONTAINER WHERE CNTR_NO = @[cntr_no] AND CRE_DT > SYSDATE - 60)" ).append("\n"); 
		query.append("           AND NVL (BO.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("           AND BO.VSL_CD = BO2.VSL_CD" ).append("\n"); 
		query.append("           AND BO.SKD_VOY_NO	= BO2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BO.SKD_DIR_CD	= BO2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BO2.BKG_NO	    = @[bkg_no]" ).append("\n"); 
		query.append("           AND BO.POL_CD	    = BO2.POL_CD" ).append("\n"); 
		query.append("           AND BO.POD_CD        = BO2.POD_CD " ).append("\n"); 

	}
}