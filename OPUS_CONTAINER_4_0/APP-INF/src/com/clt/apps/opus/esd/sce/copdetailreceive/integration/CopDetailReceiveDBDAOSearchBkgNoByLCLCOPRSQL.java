/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchBkgNoByLCLCOPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : Yoo
*@LastVersion : 1.0
* 2014.03.12 Yoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchBkgNoByLCLCOPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgNoByLCLCOP
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchBkgNoByLCLCOPRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchBkgNoByLCLCOPRSQL").append("\n"); 
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
		query.append("H.BKG_NO," ).append("\n"); 
		query.append("H.CNTR_NO," ).append("\n"); 
		query.append("H.COP_NO," ).append("\n"); 
		query.append("H.MST_COP_NO," ).append("\n"); 
		query.append("H.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT B.BL_NO FROM BKG_BOOKING B WHERE H.BKG_NO = B.BKG_NO) BL_NO" ).append("\n"); 
		query.append(",H.POD_NOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_COP_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (H.CNTR_NO, H.TRNK_VSL_CD, H.TRNK_SKD_VOY_NO, H.TRNK_SKD_DIR_CD) IN " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT I.CNTR_NO, I.TRNK_VSL_CD, I.TRNK_SKD_VOY_NO, I.TRNK_SKD_DIR_CD FROM SCE_COP_HDR I WHERE (I.CNTR_NO, I.BKG_NO) = ((@[cntr_no], @[bkg_no])) AND I.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("ORDER BY CASE WHEN (H.CNTR_NO, H.BKG_NO) = ((@[cntr_no], @[bkg_no])) THEN 1 ELSE 2 END" ).append("\n"); 

	}
}