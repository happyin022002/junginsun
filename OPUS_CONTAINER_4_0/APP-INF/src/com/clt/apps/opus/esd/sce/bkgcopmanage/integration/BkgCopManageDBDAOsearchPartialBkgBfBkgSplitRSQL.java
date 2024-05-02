/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCopManageDBDAOsearchPartialBkgBfBkgSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : Yoo
*@LastVersion : 1.0
* 2014.03.12 Yoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOsearchPartialBkgBfBkgSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG Split 되기 전 orginal bkg의 Partial BKG list 조회
	  * </pre>
	  */
	public BkgCopManageDBDAOsearchPartialBkgBfBkgSplitRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOsearchPartialBkgBfBkgSplitRSQL").append("\n"); 
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
		query.append("SELECT H2.BKG_NO, H2.COP_NO FROM SCE_COP_HDR H1, SCE_COP_HDR H2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (H1.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("     OR (H1.BKG_NO, H1.CNTR_NO) IN ((@[bkg_no], @[cntr_no])) )" ).append("\n"); 
		query.append("AND H1.CNTR_NO = H2.CNTR_NO" ).append("\n"); 
		query.append("AND H2.TRNK_VSL_CD = H1.TRNK_VSL_CD" ).append("\n"); 
		query.append("AND H2.TRNK_SKD_VOY_NO = H1.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("AND H2.TRNK_SKD_DIR_CD = H1.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("AND H2.CNTR_NO <> 'COMU0000000'" ).append("\n"); 

	}
}